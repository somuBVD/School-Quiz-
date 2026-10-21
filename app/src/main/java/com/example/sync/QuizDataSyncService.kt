package com.example.sync

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.auth.FirebaseAuthManager
import com.example.auth.FirebaseCloudSyncManager
import com.example.data.HistoricalScoreEntity
import com.example.data.QuizDatabase
import com.example.data.UnitProgress
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext
import java.util.UUID

/**
 * High-level status states for quiz progress and history synchronization.
 */
sealed class SyncStatus {
    object Idle : SyncStatus()
    object Syncing : SyncStatus()
    data class Success(
        val progressCount: Int,
        val historyCount: Int,
        val timestamp: Long = System.currentTimeMillis()
    ) : SyncStatus()
    data class Error(val message: String, val timestamp: Long = System.currentTimeMillis()) : SyncStatus()
}

/**
 * Result metrics summary returned by full synchronization cycle.
 */
data class SyncSummary(
    val isSuccess: Boolean,
    val progressSynced: Int = 0,
    val historySynced: Int = 0,
    val remoteProgressMerged: Int = 0,
    val remoteHistoryMerged: Int = 0,
    val errorMessage: String? = null,
    val timestamp: Long = System.currentTimeMillis()
)

/**
 * QuizDataSyncService
 *
 * Dedicated background and foreground service that coordinates bidirectional
 * synchronization of local Room quiz progress (UnitProgress) and quiz attempt history
 * (HistoricalScoreEntity) with Cloud Firestore.
 *
 * Features:
 * 1. Automatic Two-Way Persistence: Pushes local progress & quiz scores to Firestore,
 *    and pulls/merges any remote changes across devices.
 * 2. Deduplication & Conflict Resolution:
 *    - UnitProgress: Merges and preserves the highest progress & completion percentage.
 *    - HistoricalScores: Deterministic document IDs and timestamp reconciliation prevent duplicates.
 * 3. Offline-First Resilience: Operates seamlessly with Firestore persistent disk cache.
 * 4. Automatic Background Scheduling: Integrates with WorkManager for periodic background sync.
 */
class QuizDataSyncService private constructor(private val appContext: Context) {

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val prefs: SharedPreferences = appContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val cloudSyncManager: FirebaseCloudSyncManager = FirebaseCloudSyncManager.getInstance(appContext)
    private val authManager: FirebaseAuthManager = FirebaseAuthManager(appContext)

    // Lazy initialization of local database
    private val database: QuizDatabase by lazy {
        QuizDatabase.getDatabase(appContext, serviceScope)
    }

    private val _syncStatus = MutableStateFlow<SyncStatus>(SyncStatus.Idle)
    val syncStatus: StateFlow<SyncStatus> = _syncStatus.asStateFlow()

    private val _lastSyncTimestamp = MutableStateFlow(prefs.getLong(KEY_LAST_SYNC, 0L))
    val lastSyncTimestamp: StateFlow<Long> = _lastSyncTimestamp.asStateFlow()

    private val syncMutex = Mutex()

    init {
        Log.d(TAG, "QuizDataSyncService initialized")
    }

    /**
     * Resolves the primary student identifier used for Firestore documents:
     * 1. Firebase Auth UID if authenticated with Google or Firebase.
     * 2. Active session UID from FirebaseAuthManager.
     * 3. Persistent installation UID stored locally to ensure zero data loss.
     */
    fun resolveCurrentUserId(): String {
        val firebaseAuthUser = try {
            FirebaseAuth.getInstance().currentUser?.uid
        } catch (e: Exception) {
            null
        }

        if (!firebaseAuthUser.isNullOrBlank()) {
            return firebaseAuthUser
        }

        val authManagerUser = (authManager.uiState.value as? com.example.auth.AuthUiState.Authenticated)?.user?.uid
        if (!authManagerUser.isNullOrBlank()) {
            return authManagerUser
        }

        // Return or create a persistent student cloud UID
        var persistentUid = prefs.getString(KEY_STUDENT_CLOUD_UID, null)
        if (persistentUid.isNullOrBlank()) {
            persistentUid = "student_" + UUID.randomUUID().toString().replace("-", "").take(16)
            prefs.edit().putString(KEY_STUDENT_CLOUD_UID, persistentUid).apply()
            Log.d(TAG, "Generated persistent student cloud UID: $persistentUid")
        }
        return persistentUid
    }

    /**
     * Performs a complete bidirectional synchronization cycle of:
     * - Local UnitProgress <-> Firestore students/{userId}/unit_progress
     * - Local HistoricalScores <-> Firestore students/{userId}/historical_scores
     */
    suspend fun syncAll(forcedUserId: String? = null): SyncSummary = withContext(Dispatchers.IO) {
        if (!syncMutex.tryLock()) {
            Log.d(TAG, "Sync operation already in progress, skipping concurrent duplicate run")
            return@withContext SyncSummary(
                isSuccess = true,
                errorMessage = "Sync already in progress"
            )
        }

        try {
            val userId = forcedUserId ?: resolveCurrentUserId()
            Log.d(TAG, "Beginning full bidirectional sync for student: $userId")
            _syncStatus.value = SyncStatus.Syncing

            var totalProgressSynced = 0
            var totalHistorySynced = 0
            var remoteProgressMerged = 0
            var remoteHistoryMerged = 0

            val progressDao = database.studentProgressDao()
            val historyDao = database.historicalScoreDao()

            // ==========================================
            // 1. UNIT PROGRESS SYNCHRONIZATION
            // ==========================================
            // 1a. Upload local progress to Firestore
            val localProgressList = progressDao.getAllUnitProgressList()
            if (localProgressList.isNotEmpty()) {
                val progressUploadResult = cloudSyncManager.syncProgressToCloud(userId, localProgressList)
                if (progressUploadResult.isSuccess) {
                    totalProgressSynced = localProgressList.size
                    Log.d(TAG, "Uploaded $totalProgressSynced local unit progress records to Firestore")
                } else {
                    Log.w(TAG, "Note on progress upload: ${progressUploadResult.exceptionOrNull()?.message}")
                }
            }

            // 1b. Download remote progress from Firestore and merge with local Room DB
            val remoteProgressResult = cloudSyncManager.fetchProgressFromCloud(userId)
            if (remoteProgressResult.isSuccess) {
                val remoteProgressList = remoteProgressResult.getOrNull() ?: emptyList()
                for (remoteProg in remoteProgressList) {
                    val localRecord = progressDao.getUnitProgressDirect(
                        remoteProg.stdId,
                        remoteProg.subjectId,
                        remoteProg.unitId
                    )
                    if (localRecord == null) {
                        // Insert new unit progress from cloud
                        progressDao.insertUnitProgress(remoteProg)
                        remoteProgressMerged++
                    } else if (remoteProg.progress > localRecord.progress || remoteProg.completedQuestions > localRecord.completedQuestions) {
                        // Merge by taking the higher progress & completion
                        val merged = localRecord.copy(
                            progress = maxOf(localRecord.progress, remoteProg.progress),
                            completedQuestions = maxOf(localRecord.completedQuestions, remoteProg.completedQuestions),
                            difficulty = remoteProg.difficulty
                        )
                        progressDao.insertUnitProgress(merged)
                        remoteProgressMerged++
                    }
                }
                Log.d(TAG, "Merged $remoteProgressMerged remote unit progress records into local database")
            }

            // ==========================================
            // 2. QUIZ HISTORY SYNCHRONIZATION
            // ==========================================
            // 2a. Upload local historical scores to Firestore
            val localScores = historyDao.getAllHistoricalScoresList()
            if (localScores.isNotEmpty()) {
                val historyUploadResult = cloudSyncManager.syncHistoricalScoresToCloud(userId, localScores)
                if (historyUploadResult.isSuccess) {
                    totalHistorySynced = historyUploadResult.getOrDefault(localScores.size)
                    Log.d(TAG, "Uploaded $totalHistorySynced local historical scores to Firestore")
                } else {
                    Log.w(TAG, "Note on history upload: ${historyUploadResult.exceptionOrNull()?.message}")
                }
            }

            // 2b. Download remote historical scores from Firestore and merge into Room DB
            val remoteHistoryResult = cloudSyncManager.fetchHistoricalScoresFromCloud(userId, limit = 200)
            if (remoteHistoryResult.isSuccess) {
                val remoteScores = remoteHistoryResult.getOrNull() ?: emptyList()
                for (remoteScore in remoteScores) {
                    val existingLocalScore = historyDao.getScoreByCompletedAt(remoteScore.completedAt)
                    if (existingLocalScore == null) {
                        historyDao.insertHistoricalScore(remoteScore)
                        remoteHistoryMerged++
                    }
                }
                Log.d(TAG, "Merged $remoteHistoryMerged remote historical scores into local database")
            }

            // ==========================================
            // 3. FINALIZE & UPDATE SYNC STATE
            // ==========================================
            val now = System.currentTimeMillis()
            _lastSyncTimestamp.value = now
            prefs.edit().putLong(KEY_LAST_SYNC, now).apply()

            val successStatus = SyncStatus.Success(
                progressCount = totalProgressSynced + remoteProgressMerged,
                historyCount = totalHistorySynced + remoteHistoryMerged,
                timestamp = now
            )
            _syncStatus.value = successStatus
            Log.d(TAG, "Sync complete: Progress ($totalProgressSynced up / $remoteProgressMerged down), History ($totalHistorySynced up / $remoteHistoryMerged down)")

            SyncSummary(
                isSuccess = true,
                progressSynced = totalProgressSynced,
                historySynced = totalHistorySynced,
                remoteProgressMerged = remoteProgressMerged,
                remoteHistoryMerged = remoteHistoryMerged,
                timestamp = now
            )
        } catch (e: Throwable) {
            if (e is CancellationException || e.javaClass.name.contains("Cancellation") || e.message?.contains("cancelled", ignoreCase = true) == true) {
                Log.d(TAG, "Quiz synchronization cancelled normally: ${e.message}")
                SyncSummary(
                    isSuccess = true,
                    errorMessage = "Synchronization cancelled"
                )
            } else {
                val errMsg = e.localizedMessage ?: "Unknown synchronization error"
                Log.e(TAG, "Error during quiz synchronization: $errMsg", e)
                _syncStatus.value = SyncStatus.Error(errMsg)
                SyncSummary(
                    isSuccess = false,
                    errorMessage = errMsg
                )
            }
        } finally {
            if (syncMutex.isLocked) {
                try {
                    syncMutex.unlock()
                } catch (ignored: Exception) {}
            }
        }
    }

    /**
     * Triggers an immediate asynchronous background sync.
     * Safe to call from UI threads after a quiz attempt completes.
     */
    fun triggerAutoSync(forcedUserId: String? = null) {
        serviceScope.launch {
            try {
                syncAll(forcedUserId)
            } catch (e: CancellationException) {
                // Normal coroutine cancellation
            } catch (e: Exception) {
                Log.w(TAG, "Auto sync note: ${e.message}")
            }
        }
    }

    companion object {
        private const val TAG = "QuizDataSyncService"
        private const val PREFS_NAME = "quiz_firestore_sync_prefs"
        private const val KEY_LAST_SYNC = "key_last_sync_timestamp"
        private const val KEY_STUDENT_CLOUD_UID = "key_student_cloud_uid"

        @Volatile
        private var instance: QuizDataSyncService? = null

        fun getInstance(context: Context): QuizDataSyncService {
            return instance ?: synchronized(this) {
                instance ?: QuizDataSyncService(context.applicationContext).also {
                    instance = it
                }
            }
        }
    }
}
