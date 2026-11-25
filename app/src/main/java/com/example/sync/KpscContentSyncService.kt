package com.example.sync

import android.content.Context
import android.util.Log
import com.example.auth.NamedFirestoreProvider
import com.example.auth.OperationType
import com.example.auth.handleFirestoreError
import com.example.data.DownloadedQuizEntity
import com.example.data.KpscStudyMaterialEntity
import com.example.data.KpscStudyMaterialRemote
import com.example.data.QuizDatabase
import com.example.data.QuizQuestionEntity
import com.example.data.QuizStaticData
import com.example.data.toQuizQuestionEntity
import com.google.firebase.firestore.DocumentSnapshot
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

enum class KpscSyncStatus {
    IDLE,
    SYNCING,
    SYNCED,
    OFFLINE_INDEXED,
    ERROR
}

data class KpscSyncResult(
    val isSuccess: Boolean,
    val materialsSynced: Int = 0,
    val questionsIndexed: Int = 0,
    val remoteMaterialsFetched: Int = 0,
    val remoteQuestionsFetched: Int = 0,
    val usedCloudSync: Boolean = false,
    val errorMessage: String? = null
)

/**
 * Coordinates KPSC-specific content synchronization between Cloud Firestore
 * (`/kpsc_study_materials` and `/questions` where `stdId == 15`) and the local
 * indexed Room tables (`kpsc_study_materials`, `quiz_questions`, `downloaded_quizzes`).
 *
 * Always indexes bundled KPSC modules locally so offline access is immediately guaranteed,
 * and overlays/merges updated Firestore KPSC materials and MCQs whenever signed in & online.
 */
class KpscContentSyncService private constructor(private val appContext: Context) {

    private val syncScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val syncMutex = Mutex()
    private val prefs = appContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _syncStatus = MutableStateFlow(KpscSyncStatus.IDLE)
    val syncStatus: StateFlow<KpscSyncStatus> = _syncStatus.asStateFlow()

    private val _lastSyncTimestamp = MutableStateFlow(prefs.getLong(KEY_LAST_SYNC, 0L))
    val lastSyncTimestamp: StateFlow<Long> = _lastSyncTimestamp.asStateFlow()

    private val _lastSyncSummary = MutableStateFlow(
        prefs.getString(KEY_LAST_SUMMARY, "") ?: ""
    )
    val lastSyncSummary: StateFlow<String> = _lastSyncSummary.asStateFlow()

    private val database: QuizDatabase by lazy {
        QuizDatabase.getDatabase(appContext, syncScope)
    }

    /**
     * Triggers a non-blocking KPSC content sync in the background IO scope.
     */
    fun triggerBackgroundSync() {
        syncScope.launch {
            syncKpscContent()
        }
    }

    /**
     * Performs full KPSC content sync:
     * 1. Indexes bundled KPSC curriculum MCQs & baseline study material records into Room.
     * 2. When authenticated with Google Sign-In, fetches published `/kpsc_study_materials`
     *    and KPSC `/questions` (`stdId == 15`) from the named Firestore database.
     * 3. Upserts all fetched records into indexed Room tables and refreshes offline unit manifests.
     */
    suspend fun syncKpscContent(): KpscSyncResult = withContext(Dispatchers.IO) {
        if (!syncMutex.tryLock()) {
            Log.d(TAG, "KPSC sync already in progress; skipping duplicate invocation")
            return@withContext KpscSyncResult(isSuccess = true)
        }

        try {
            _syncStatus.value = KpscSyncStatus.SYNCING
            val now = System.currentTimeMillis()
            val questionDao = database.quizQuestionDao()
            val materialDao = database.kpscStudyMaterialDao()
            val downloadedDao = database.downloadedQuizDao()

            // Step 1: Index bundled KPSC curriculum questions & baseline material metadata into Room
            val bundledMaterials = mutableListOf<KpscStudyMaterialEntity>()
            val bundledQuestions = mutableListOf<QuizQuestionEntity>()
            val existingMaterialsById = materialDao.getAllPublishedDirect().associateBy { it.id }

            QuizStaticData.kpscStandard.subjects.forEach { subject ->
                subject.units.forEach { unit ->
                    val unitQuestions = QuizStaticData.getQuestionsForUnit(
                        stdId = KpscStudyMaterialRemote.KPSC_STD_ID,
                        subjectId = subject.id,
                        unitId = unit.id,
                        custom = emptyList()
                    )
                    unitQuestions.forEach { q ->
                        bundledQuestions.add(
                            q.toQuizQuestionEntity(
                                unitName = unit.name,
                                difficulty = unit.difficulty.ifBlank { "Medium" },
                                hint = "KPSC ${subject.title}",
                                points = 10,
                                isCustom = false
                            )
                        )
                    }

                    val baselineId = "kpsc_local_${subject.id}_u${unit.id}"
                    val existing = existingMaterialsById[baselineId]
                    val resolvedVersion = existing?.contentVersion ?: 1
                    bundledMaterials.add(
                        KpscStudyMaterialEntity(
                            id = baselineId,
                            subjectId = subject.id,
                            unitId = unit.id,
                            unitName = unit.name,
                            title = "${subject.title} — ${unit.name}",
                            summary = "Offline KPSC study unit with ${unitQuestions.size} MCQs for KAS, FDA, SDA & PDO.",
                            contentMarkdown = existing?.contentMarkdown.orEmpty(),
                            language = if (subject.id == "kpsc_english") "en" else "bilingual",
                            difficulty = unit.difficulty.ifBlank { "Medium" },
                            examTagsCsv = "KAS,FDA,SDA,PDO",
                            questionCount = unitQuestions.size,
                            contentVersion = resolvedVersion,
                            published = true,
                            updatedAtMillis = existing?.updatedAtMillis ?: now,
                            lastSyncedAtMillis = now
                        )
                    )
                }
            }

            if (bundledQuestions.isNotEmpty()) {
                // Insert in manageable chunks to keep SQLite transactions fast and bounded
                bundledQuestions.chunked(150).forEach { chunk ->
                    questionDao.insertQuestions(chunk)
                }
            }
            if (bundledMaterials.isNotEmpty()) {
                materialDao.upsertMaterials(bundledMaterials)
            }

            // Step 2: Fetch remote KPSC study materials & KPSC questions from named Firestore DB if signed in
            var remoteMaterialsFetched = 0
            var remoteQuestionsFetched = 0
            var usedCloudSync = false
            var cloudError: String? = null

            val uid = NamedFirestoreProvider.currentUid(appContext)
            val firestore = NamedFirestoreProvider.getDatabase(appContext)

            if (uid != null && firestore != null) {
                usedCloudSync = true

                // 2a. Query /kpsc_study_materials with exact rule-aligned filter: published == true
                try {
                    val materialsSnap = firestore
                        .collection(KpscStudyMaterialRemote.COLLECTION_NAME)
                        .whereEqualTo("published", true)
                        .get()
                        .await()

                    val remoteMaterialEntities = mutableListOf<KpscStudyMaterialEntity>()
                    val embeddedQuestions = mutableListOf<QuizQuestionEntity>()

                    for (doc in materialsSnap.documents) {
                        val remote = doc.toObject(
                            KpscStudyMaterialRemote::class.java,
                            DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                        ) ?: continue
                        if (remote.subjectId !in KpscStudyMaterialRemote.VALID_SUBJECT_IDS) continue

                        val parsedQs = remote.parseEmbeddedQuestions(now)
                        embeddedQuestions.addAll(parsedQs)
                        remoteMaterialEntities.add(
                            remote.toLocalEntity(
                                syncTimeMillis = now,
                                parsedQuestionCount = parsedQs.size
                            )
                        )
                    }

                    if (embeddedQuestions.isNotEmpty()) {
                        embeddedQuestions.chunked(150).forEach { chunk ->
                            questionDao.insertQuestions(chunk)
                        }
                        remoteQuestionsFetched += embeddedQuestions.size
                    }
                    if (remoteMaterialEntities.isNotEmpty()) {
                        materialDao.upsertMaterials(remoteMaterialEntities)
                        remoteMaterialsFetched = remoteMaterialEntities.size
                    }
                } catch (e: Exception) {
                    if (e is CancellationException) throw e
                    handleFirestoreError(e, OperationType.LIST, KpscStudyMaterialRemote.COLLECTION_NAME)
                    cloudError = e.message
                }

                // 2b. Query /questions where stdId == 15 for any newly published KPSC MCQs
                try {
                    val questionsSnap = firestore
                        .collection("questions")
                        .whereEqualTo("stdId", KpscStudyMaterialRemote.KPSC_STD_ID)
                        .get()
                        .await()

                    val remoteStandaloneQuestions = mutableListOf<QuizQuestionEntity>()
                    for (doc in questionsSnap.documents) {
                        val qText = doc.getString("questionText")?.trim().orEmpty()
                        val correct = doc.getString("correctAnswer")?.trim().orEmpty()
                        val subjectId = doc.getString("subjectId")?.trim().orEmpty()
                        if (qText.isBlank() || correct.isBlank() || subjectId.isBlank()) continue

                        val unitId = (doc.get("unitId") as? Number)?.toInt()?.coerceIn(1, 100) ?: 1
                        val rawOptions = (doc.get("options") as? List<*>)
                            ?.mapNotNull { it?.toString()?.trim() }
                            ?.filter { it.isNotEmpty() }
                            ?: emptyList()
                        val resolvedId = doc.getString("id")?.takeIf { it.isNotBlank() } ?: doc.id

                        remoteStandaloneQuestions.add(
                            QuizQuestionEntity(
                                id = resolvedId,
                                stdId = KpscStudyMaterialRemote.KPSC_STD_ID,
                                subjectId = subjectId,
                                unitId = unitId,
                                unitName = doc.getString("unitName")?.takeIf { it.isNotBlank() } ?: "Unit $unitId",
                                type = doc.getString("type")?.takeIf { it.isNotBlank() } ?: "MCQ",
                                questionText = qText,
                                optionsString = rawOptions.joinToString("|"),
                                correctAnswer = correct,
                                explanation = doc.getString("explanation").orEmpty(),
                                mediaRes = doc.getString("mediaRes").orEmpty(),
                                difficulty = doc.getString("difficulty")?.takeIf { it.isNotBlank() } ?: "Medium",
                                hint = doc.getString("hint").orEmpty(),
                                points = (doc.get("points") as? Number)?.toInt()?.coerceIn(5, 100) ?: 10,
                                isCustom = false,
                                createdAt = (doc.get("createdAt") as? Number)?.toLong() ?: now
                            )
                        )
                    }

                    if (remoteStandaloneQuestions.isNotEmpty()) {
                        remoteStandaloneQuestions.chunked(150).forEach { chunk ->
                            questionDao.insertQuestions(chunk)
                        }
                        remoteQuestionsFetched += remoteStandaloneQuestions.size
                    }
                } catch (e: Exception) {
                    if (e is CancellationException) throw e
                    handleFirestoreError(e, OperationType.LIST, "questions")
                    if (cloudError == null) cloudError = e.message
                }
            }

            // Step 3: Refresh offline manifest in downloaded_quizzes for all KPSC subjects & units
            QuizStaticData.kpscStandard.subjects.forEach { subject ->
                subject.units.forEach { unit ->
                    val indexedCount = questionDao.getQuestionCountForUnit(
                        stdId = KpscStudyMaterialRemote.KPSC_STD_ID,
                        subjectId = subject.id,
                        unitId = unit.id
                    )
                    if (indexedCount > 0) {
                        downloadedDao.insertDownloadedQuiz(
                            DownloadedQuizEntity(
                                stdId = KpscStudyMaterialRemote.KPSC_STD_ID,
                                subjectId = subject.id,
                                unitId = unit.id,
                                unitName = unit.name,
                                questionCount = indexedCount,
                                downloadedAt = now,
                                sizeBytes = indexedCount * 320L,
                                isDownloaded = true
                            )
                        )
                    }
                }
            }

            val totalIndexedKpscQuestions = questionDao.getQuestionCountForStandardDirect(
                KpscStudyMaterialRemote.KPSC_STD_ID
            )
            val totalMaterials = materialDao.getPublishedCountDirect()

            val summaryText = if (usedCloudSync && cloudError == null) {
                "Cloud + Offline Ready • $totalIndexedKpscQuestions Qs"
            } else {
                "Offline Ready • $totalIndexedKpscQuestions Qs"
            }

            prefs.edit()
                .putLong(KEY_LAST_SYNC, now)
                .putString(KEY_LAST_SUMMARY, summaryText)
                .apply()

            _lastSyncTimestamp.value = now
            _lastSyncSummary.value = summaryText
            _syncStatus.value = when {
                usedCloudSync && cloudError == null -> KpscSyncStatus.SYNCED
                else -> KpscSyncStatus.OFFLINE_INDEXED
            }

            Log.d(
                TAG,
                "KPSC sync finished: materials=$totalMaterials (remote=$remoteMaterialsFetched), " +
                    "questions=$totalIndexedKpscQuestions (remote=$remoteQuestionsFetched), cloud=$usedCloudSync"
            )

            KpscSyncResult(
                isSuccess = cloudError == null || !usedCloudSync,
                materialsSynced = totalMaterials,
                questionsIndexed = totalIndexedKpscQuestions,
                remoteMaterialsFetched = remoteMaterialsFetched,
                remoteQuestionsFetched = remoteQuestionsFetched,
                usedCloudSync = usedCloudSync,
                errorMessage = cloudError
            )
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Log.e(TAG, "KPSC content sync failed: ${e.message}", e)
            _syncStatus.value = KpscSyncStatus.ERROR
            KpscSyncResult(isSuccess = false, errorMessage = e.message)
        } finally {
            syncMutex.unlock()
        }
    }

    /**
     * Publishes a KPSC study material bundle to `/kpsc_study_materials/{materialId}` (Teacher/Admin only)
     * and immediately indexes it into local Room tables.
     */
    suspend fun publishKpscStudyMaterial(
        materialId: String,
        material: KpscStudyMaterialRemote
    ): Result<Unit> = withContext(Dispatchers.IO) {
        val uid = NamedFirestoreProvider.currentUid(appContext)
            ?: return@withContext Result.failure(IllegalStateException("Sign in required to publish KPSC materials"))
        val firestore = NamedFirestoreProvider.getDatabase(appContext)
            ?: return@withContext Result.failure(IllegalStateException("Firestore unavailable"))

        val safeId = materialId.trim().replace(Regex("[^a-zA-Z0-9_-]"), "_").take(120)
        if (safeId.isBlank()) {
            return@withContext Result.failure(IllegalArgumentException("Invalid materialId"))
        }

        val path = "${KpscStudyMaterialRemote.COLLECTION_NAME}/$safeId"
        return@withContext try {
            val docRef = firestore.collection(KpscStudyMaterialRemote.COLLECTION_NAME).document(safeId)
            val existing = docRef.get().await()
            if (existing.exists()) {
                docRef.update(material.toUpdateMap()).await()
            } else {
                docRef.set(material.toCreateMap()).await()
            }

            // Immediately index into local Room tables
            val now = System.currentTimeMillis()
            val resolvedMaterial = material.copy(id = safeId)
            val parsedQuestions = resolvedMaterial.parseEmbeddedQuestions(now)
            if (parsedQuestions.isNotEmpty()) {
                database.quizQuestionDao().insertQuestions(parsedQuestions)
            }
            database.kpscStudyMaterialDao().upsertMaterial(
                resolvedMaterial.toLocalEntity(
                    syncTimeMillis = now,
                    parsedQuestionCount = parsedQuestions.size
                )
            )
            Log.d(TAG, "Published KPSC study material $safeId by uid=$uid")
            Result.success(Unit)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            handleFirestoreError(e, OperationType.WRITE, path)
            Result.failure(e)
        }
    }

    companion object {
        private const val TAG = "KpscContentSyncService"
        private const val PREFS_NAME = "kpsc_content_sync_prefs"
        private const val KEY_LAST_SYNC = "last_kpsc_sync_timestamp"
        private const val KEY_LAST_SUMMARY = "last_kpsc_sync_summary"

        @Volatile
        private var INSTANCE: KpscContentSyncService? = null

        fun getInstance(context: Context): KpscContentSyncService {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: KpscContentSyncService(context.applicationContext).also {
                    INSTANCE = it
                }
            }
        }
    }
}
