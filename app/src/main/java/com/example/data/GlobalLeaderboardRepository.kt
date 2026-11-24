package com.example.data

import android.content.Context
import androidx.annotation.Keep
import com.example.auth.NamedFirestoreProvider
import com.example.auth.OperationType
import com.example.auth.handleFirestoreError
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.IgnoreExtraProperties
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

/**
 * PII-free public student entry stored in `/global_leaderboard/{studentId}`
 * and ranked by total accumulated XP.
 */
@Keep
@IgnoreExtraProperties
data class GlobalLeaderboardEntry(
    @DocumentId val id: String = "",
    val uid: String = "",
    val displayName: String = "",
    val standard: Int = 6,
    val avatar: String = "avatar_astro_explorer",
    val xp: Int = 0,
    val stars: Int = 0,
    val attendanceStreak: Int = 0,
    val updatedAt: Timestamp? = null
)

sealed interface GlobalLeaderboardUiState {
    data object Loading : GlobalLeaderboardUiState
    data object SignedOut : GlobalLeaderboardUiState
    data class Success(
        val entries: List<GlobalLeaderboardEntry>,
        val currentUserUid: String?,
        val isFromCache: Boolean = false
    ) : GlobalLeaderboardUiState
    data class Error(val message: String) : GlobalLeaderboardUiState
}

/**
 * Firestore repository for fetching the Top 10 students ranked by total accumulated XP
 * from `/global_leaderboard` using the provisioned named Firestore database.
 */
class GlobalLeaderboardRepository(
    private val context: Context,
    private val dbProvider: () -> FirebaseFirestore? = { NamedFirestoreProvider.getDatabase(context) },
    private val uidProvider: () -> String? = { NamedFirestoreProvider.currentUid(context) }
) {
    companion object {
        const val COLLECTION_GLOBAL_LEADERBOARD = "global_leaderboard"
        const val DEFAULT_TOP_LIMIT = 10L
    }

    /**
     * Real-time stream of the top [limitCount] students ranked descending by accumulated XP.
     * Auth-gated: never opens an unauthenticated Firestore listener.
     */
    fun observeTopStudents(limitCount: Long = DEFAULT_TOP_LIMIT): Flow<GlobalLeaderboardUiState> {
        val currentUid = uidProvider()?.takeIf { it.isNotBlank() }
        if (currentUid == null) {
            return callbackFlow {
                trySend(GlobalLeaderboardUiState.SignedOut)
                close()
            }
        }

        val db = dbProvider()
        if (db == null) {
            return callbackFlow {
                trySend(GlobalLeaderboardUiState.Error("Cloud Firestore is currently unavailable."))
                close()
            }
        }

        return callbackFlow {
            trySend(GlobalLeaderboardUiState.Loading)

            // Matches firestore.rules: allow list: if isSignedIn() && resource.data.xp >= 0;
            // Single-field range + descending orderBy on `xp` uses Firestore's automatic single-field index.
            val registration = db.collection(COLLECTION_GLOBAL_LEADERBOARD)
                .whereGreaterThanOrEqualTo("xp", 0)
                .orderBy("xp", Query.Direction.DESCENDING)
                .limit(limitCount)
                .addSnapshotListener { snapshot, error ->
                    if (error != null) {
                        handleFirestoreError(error, OperationType.LIST, COLLECTION_GLOBAL_LEADERBOARD)
                        val friendlyMessage = when (error.code) {
                            FirebaseFirestoreException.Code.PERMISSION_DENIED ->
                                "Sign in with Google to view the live Global Leaderboard."
                            FirebaseFirestoreException.Code.UNAVAILABLE ->
                                "You are offline. Reconnect to refresh the Global Leaderboard."
                            else ->
                                error.localizedMessage ?: "Unable to load Global Leaderboard."
                        }
                        trySend(GlobalLeaderboardUiState.Error(friendlyMessage))
                        return@addSnapshotListener
                    }

                    val entries = snapshot?.documents?.mapNotNull { doc ->
                        parseEntry(doc)
                    } ?: emptyList()

                    trySend(
                        GlobalLeaderboardUiState.Success(
                            entries = entries,
                            currentUserUid = currentUid,
                            isFromCache = snapshot?.metadata?.isFromCache == true
                        )
                    )
                }

            awaitClose {
                registration.remove()
            }
        }.catch { throwable ->
            val firestoreError = generateSequence(throwable) { it.cause }
                .filterIsInstance<FirebaseFirestoreException>()
                .firstOrNull()
            if (throwable is CancellationException && firestoreError == null) {
                throw throwable
            }
            val root = firestoreError ?: throwable
            handleFirestoreError(root, OperationType.LIST, COLLECTION_GLOBAL_LEADERBOARD)
            emit(GlobalLeaderboardUiState.Error(root.localizedMessage ?: "Unable to load Global Leaderboard."))
        }
    }

    /**
     * Publishes or updates the signed-in student's PII-free XP entry in `/global_leaderboard/{uid}`.
     */
    suspend fun publishStudentEntry(profile: UserProfile): Result<Unit> {
        val uid = uidProvider()?.takeIf { it.isNotBlank() }
            ?: return Result.failure(IllegalStateException("Sign in with Google to join the Global Leaderboard."))
        val db = dbProvider()
            ?: return Result.failure(IllegalStateException("Cloud Firestore is unavailable."))

        val docPath = "$COLLECTION_GLOBAL_LEADERBOARD/$uid"
        return try {
            val payload = buildLeaderboardPayload(uid, profile)
            db.collection(COLLECTION_GLOBAL_LEADERBOARD)
                .document(uid)
                .set(payload, SetOptions.merge())
                .await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docPath)
            Result.failure(e)
        }
    }

    private fun parseEntry(doc: DocumentSnapshot): GlobalLeaderboardEntry? {
        val data = doc.getData(DocumentSnapshot.ServerTimestampBehavior.ESTIMATE) ?: return null
        val uid = (data["uid"] as? String)?.takeIf { it.isNotBlank() } ?: doc.id
        val displayName = (data["displayName"] as? String)?.takeIf { it.isNotBlank() } ?: "Student"
        val standard = ((data["standard"] as? Number)?.toInt() ?: 6).coerceIn(1, 12)
        val avatar = (data["avatar"] as? String)?.takeIf { it.isNotBlank() } ?: "avatar_astro_explorer"
        val xp = ((data["xp"] as? Number)?.toInt() ?: 0).coerceAtLeast(0)
        val stars = ((data["stars"] as? Number)?.toInt() ?: 0).coerceAtLeast(0)
        val streak = ((data["attendanceStreak"] as? Number)?.toInt() ?: 0).coerceAtLeast(0)
        val updatedAt = data["updatedAt"] as? Timestamp

        return GlobalLeaderboardEntry(
            id = doc.id,
            uid = uid,
            displayName = displayName,
            standard = standard,
            avatar = avatar,
            xp = xp,
            stars = stars,
            attendanceStreak = streak,
            updatedAt = updatedAt
        )
    }

    /**
     * Builds the exact schema-compliant payload enforced by `isValidGlobalLeaderboardEntry` in `firestore.rules`.
     */
    fun buildLeaderboardPayload(uid: String, profile: UserProfile): Map<String, Any> {
        val publicName = profile.nickname.trim()
            .ifBlank { profile.name.trim() }
            .ifBlank { "Student" }
            .take(60)
        val safeAvatar = profile.avatar.trim()
            .ifBlank { "avatar_astro_explorer" }
            .take(250)

        return mapOf(
            "uid" to uid,
            "displayName" to publicName,
            "standard" to profile.standard.coerceIn(1, 12),
            "avatar" to safeAvatar,
            "xp" to profile.xp.coerceIn(0, 10_000_000),
            "stars" to profile.stars.coerceIn(0, 1_000_000),
            "attendanceStreak" to profile.attendanceStreak.coerceIn(0, 10_000),
            "updatedAt" to FieldValue.serverTimestamp()
        )
    }
}
