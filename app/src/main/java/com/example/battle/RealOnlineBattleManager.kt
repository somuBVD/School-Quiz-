package com.example.battle

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.example.auth.NamedFirestoreProvider
import com.example.auth.OperationType
import com.example.auth.handleFirestoreError
import com.example.data.QuestionModel
import com.example.data.UserProfile
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await

data class OnlinePlayer(
    val uid: String = "",
    val name: String = "Student",
    val school: String = "Karnataka High School",
    val avatar: String = "avatar_1",
    val standard: Int = 6,
    val score: Int = 0,
    val currentAnswer: String = "",
    val streak: Int = 0,
    val answeredAt: Long = 0L
)

data class OnlineRoomData(
    val roomId: String = "",
    val roomCode: String = "",
    val hostUid: String = "",
    val player2Uid: String? = null,
    val participantUids: List<String> = emptyList(),
    val isPrivate: Boolean = false,
    val subject: String = "mixed",
    val standard: Int = 6,
    val status: String = "WAITING", // WAITING, IN_PROGRESS, ROUND_REVEAL, COMPLETED, CANCELLED
    val currentRound: Int = 0,
    val roundStartTime: Long = 0L,
    val questions: List<QuestionModel> = emptyList(),
    val player1: OnlinePlayer = OnlinePlayer(),
    val player2: OnlinePlayer? = null,
    val winnerUid: String? = null
)

/**
 * RealOnlineBattleManager powers live 1 vs 1 student multiplayer duels using
 * the provisioned named Cloud Firestore database (`battle_rooms` collection) and
 * authenticated Firebase Auth user UIDs (via Google Sign-In).
 *
 * Key guarantees:
 * 1. Always connects to the provisioned named Firestore database (`firestore_database_id`).
 * 2. Uses authenticated `FirebaseAuth.currentUser.uid` so students on different devices have unique IDs.
 * 3. Uses atomic Firestore transactions when joining waiting rooms to prevent race conditions.
 * 4. Logs all Firestore errors with structured JSON via `handleFirestoreError`.
 */
class RealOnlineBattleManager private constructor(private val context: Context) {

    private val firestore: FirebaseFirestore?
        get() = NamedFirestoreProvider.getDatabase(context)

    private var activeRoomListener: ListenerRegistration? = null

    fun isOnlineAvailable(): Boolean = firestore != null

    fun isAuthenticatedForOnlineBattle(): Boolean = NamedFirestoreProvider.currentUid(context) != null

    private fun questionsToMaps(questions: List<QuestionModel>): List<Map<String, Any>> {
        return questions.take(10).map { q ->
            mapOf(
                "id" to q.id,
                "stdId" to q.stdId,
                "subjectId" to q.subjectId,
                "unitId" to q.unitId,
                "type" to q.type,
                "questionText" to q.questionText,
                "options" to q.options,
                "correctAnswer" to q.correctAnswer,
                "explanation" to q.explanation,
                "mediaRes" to q.mediaRes
            )
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun mapsToQuestions(rawList: List<Any>?): List<QuestionModel> {
        if (rawList == null) return emptyList()
        return rawList.mapNotNull { item ->
            val map = item as? Map<String, Any> ?: return@mapNotNull null
            try {
                QuestionModel(
                    id = map["id"]?.toString() ?: "",
                    stdId = (map["stdId"] as? Number)?.toInt() ?: 6,
                    subjectId = map["subjectId"]?.toString() ?: "mixed",
                    unitId = (map["unitId"] as? Number)?.toInt() ?: 1,
                    type = map["type"]?.toString() ?: "MCQ",
                    questionText = map["questionText"]?.toString() ?: "",
                    options = (map["options"] as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList(),
                    correctAnswer = map["correctAnswer"]?.toString() ?: "",
                    explanation = map["explanation"]?.toString() ?: "",
                    mediaRes = map["mediaRes"]?.toString() ?: ""
                )
            } catch (_: Exception) {
                null
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun parseRoomDoc(docData: Map<String, Any>?): OnlineRoomData? {
        if (docData == null) return null
        return try {
            val p1Map = docData["player1"] as? Map<String, Any> ?: emptyMap()
            val p2Map = docData["player2"] as? Map<String, Any>
            val participants = (docData["participantUids"] as? List<*>)?.mapNotNull { it?.toString() } ?: emptyList()

            val player1 = OnlinePlayer(
                uid = p1Map["uid"]?.toString() ?: "",
                name = p1Map["name"]?.toString() ?: "Student 1",
                school = p1Map["school"]?.toString() ?: "School",
                avatar = p1Map["avatar"]?.toString() ?: "avatar_1",
                standard = (p1Map["standard"] as? Number)?.toInt() ?: 6,
                score = (p1Map["score"] as? Number)?.toInt() ?: 0,
                currentAnswer = p1Map["currentAnswer"]?.toString() ?: "",
                streak = (p1Map["streak"] as? Number)?.toInt() ?: 0,
                answeredAt = (p1Map["answeredAt"] as? Number)?.toLong() ?: 0L
            )

            val player2 = p2Map?.let {
                OnlinePlayer(
                    uid = it["uid"]?.toString() ?: "",
                    name = it["name"]?.toString() ?: "Student 2",
                    school = it["school"]?.toString() ?: "School",
                    avatar = it["avatar"]?.toString() ?: "avatar_2",
                    standard = (it["standard"] as? Number)?.toInt() ?: 6,
                    score = (it["score"] as? Number)?.toInt() ?: 0,
                    currentAnswer = it["currentAnswer"]?.toString() ?: "",
                    streak = (it["streak"] as? Number)?.toInt() ?: 0,
                    answeredAt = (it["answeredAt"] as? Number)?.toLong() ?: 0L
                )
            }

            OnlineRoomData(
                roomId = docData["roomId"]?.toString() ?: "",
                roomCode = docData["roomCode"]?.toString() ?: "",
                hostUid = docData["hostUid"]?.toString() ?: "",
                player2Uid = docData["player2Uid"]?.toString(),
                participantUids = participants,
                isPrivate = docData["isPrivate"] as? Boolean ?: false,
                subject = docData["subject"]?.toString() ?: "mixed",
                standard = (docData["standard"] as? Number)?.toInt() ?: 6,
                status = docData["status"]?.toString() ?: "WAITING",
                currentRound = (docData["currentRound"] as? Number)?.toInt() ?: 0,
                roundStartTime = (docData["roundStartTime"] as? Number)?.toLong() ?: 0L,
                questions = mapsToQuestions(docData["questions"] as? List<Any>),
                player1 = player1,
                player2 = player2,
                winnerUid = docData["winnerUid"]?.toString()
            )
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing room document: ${e.message}", e)
            null
        }
    }

    private fun buildPlayerMap(uid: String, user: UserProfile): Map<String, Any> {
        return mapOf(
            "uid" to uid,
            "name" to user.name.ifBlank { "Student" }.take(60),
            "school" to "Karnataka State Board",
            "avatar" to user.avatar.take(200),
            "standard" to user.standard,
            "score" to 0,
            "currentAnswer" to "",
            "streak" to 0,
            "answeredAt" to 0L
        )
    }

    /**
     * Atomically joins a WAITING battle room as Player 2 inside a Firestore transaction.
     */
    private suspend fun joinRoomTransaction(
        db: FirebaseFirestore,
        roomId: String,
        currentUid: String,
        user: UserProfile
    ): Boolean {
        val docRef = db.collection(COLLECTION_BATTLE_ROOMS).document(roomId)
        val p2Map = buildPlayerMap(currentUid, user)
        return db.runTransaction { transaction ->
            val snapshot = transaction.get(docRef)
            if (!snapshot.exists()) return@runTransaction false
            val status = snapshot.getString("status") ?: ""
            val hostUid = snapshot.getString("hostUid") ?: ""
            val existingP2 = snapshot.getString("player2Uid")
            if (status != "WAITING" || hostUid.isBlank() || hostUid == currentUid || !existingP2.isNullOrBlank()) {
                return@runTransaction false
            }

            transaction.update(
                docRef,
                mapOf(
                    "player2" to p2Map,
                    "player2Uid" to currentUid,
                    "participantUids" to listOf(hostUid, currentUid),
                    "status" to "IN_PROGRESS",
                    "roundStartTime" to System.currentTimeMillis(),
                    "updatedAt" to FieldValue.serverTimestamp()
                )
            )
            true
        }.await()
    }

    /**
     * Search for an existing open waiting room in Firestore, or create a new room as Host.
     * Returns Result<Triple(roomId, roomCode, isHost)>.
     */
    suspend fun findOrCreateMatch(
        user: UserProfile,
        subjectId: String,
        candidateQuestions: List<QuestionModel>
    ): Result<Triple<String, String, Boolean>> {
        val db = firestore
            ?: return Result.failure(IllegalStateException("Cloud Firestore is offline."))
        val currentUid = try {
            NamedFirestoreProvider.requireAuthenticatedUid(context)
        } catch (e: Exception) {
            return Result.failure(e)
        }

        val now = System.currentTimeMillis()

        // 1. Query open waiting rooms for same standard (matches firestore.rules list constraint)
        try {
            val snapshot = db.collection(COLLECTION_BATTLE_ROOMS)
                .whereEqualTo("status", "WAITING")
                .whereEqualTo("isPrivate", false)
                .whereEqualTo("standard", user.standard)
                .limit(10)
                .get()
                .await()

            for (doc in snapshot.documents) {
                val hostUid = doc.getString("hostUid") ?: ""
                val createdAtMs = when (val rawCreated = doc.get("createdAt")) {
                    is Timestamp -> rawCreated.toDate().time
                    is Number -> rawCreated.toLong()
                    else -> now
                }
                // Match with a different authenticated student & ignore stale rooms (> 5 min old)
                if (hostUid.isNotBlank() && hostUid != currentUid && (now - createdAtMs) < 300_000L) {
                    val roomId = doc.id
                    val roomCode = doc.getString("roomCode") ?: ""
                    val joined = try {
                        joinRoomTransaction(db, roomId, currentUid, user)
                    } catch (e: CancellationException) {
                        throw e
                    } catch (t: Throwable) {
                        handleFirestoreError(t, OperationType.UPDATE, "$COLLECTION_BATTLE_ROOMS/$roomId")
                        false
                    }
                    if (joined) {
                        Log.i(TAG, "Joined online battle room $roomId as Player 2")
                        return Result.success(Triple(roomId, roomCode, false))
                    }
                }
            }
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.LIST, COLLECTION_BATTLE_ROOMS)
            return Result.failure(t)
        }

        // 2. No open room available — create a new public room as Host
        val generatedCode = (100000..999999).random().toString()
        val roomId = "battle_${now}_${(1000..9999).random()}"
        val selectedQuestions = candidateQuestions.shuffled().take(5)
        val p1Map = buildPlayerMap(currentUid, user)

        val roomMap = hashMapOf<String, Any>(
            "roomId" to roomId,
            "roomCode" to generatedCode,
            "hostUid" to currentUid,
            "participantUids" to listOf(currentUid),
            "isPrivate" to false,
            "subject" to subjectId.take(40),
            "standard" to user.standard,
            "status" to "WAITING",
            "currentRound" to 0,
            "roundStartTime" to 0L,
            "createdAt" to FieldValue.serverTimestamp(),
            "updatedAt" to FieldValue.serverTimestamp(),
            "questions" to questionsToMaps(selectedQuestions),
            "player1" to p1Map
        )

        return try {
            db.collection(COLLECTION_BATTLE_ROOMS).document(roomId).set(roomMap).await()
            Log.i(TAG, "Created public online battle room $roomId (code $generatedCode)")
            Result.success(Triple(roomId, generatedCode, true))
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.CREATE, "$COLLECTION_BATTLE_ROOMS/$roomId")
            Result.failure(t)
        }
    }

    /**
     * Create a private battle room for classmate duels via 6-digit code.
     */
    suspend fun createPrivateRoom(
        user: UserProfile,
        subjectId: String,
        candidateQuestions: List<QuestionModel>
    ): Result<Pair<String, String>> {
        val db = firestore
            ?: return Result.failure(IllegalStateException("Cloud Firestore is offline."))
        val currentUid = try {
            NamedFirestoreProvider.requireAuthenticatedUid(context)
        } catch (e: Exception) {
            return Result.failure(e)
        }

        val now = System.currentTimeMillis()
        val roomCode = (100000..999999).random().toString()
        val roomId = "private_${now}_${(1000..9999).random()}"
        val selectedQuestions = candidateQuestions.shuffled().take(5)
        val p1Map = buildPlayerMap(currentUid, user)

        val roomMap = hashMapOf<String, Any>(
            "roomId" to roomId,
            "roomCode" to roomCode,
            "hostUid" to currentUid,
            "participantUids" to listOf(currentUid),
            "isPrivate" to true,
            "subject" to subjectId.take(40),
            "standard" to user.standard,
            "status" to "WAITING",
            "currentRound" to 0,
            "roundStartTime" to 0L,
            "createdAt" to FieldValue.serverTimestamp(),
            "updatedAt" to FieldValue.serverTimestamp(),
            "questions" to questionsToMaps(selectedQuestions),
            "player1" to p1Map
        )

        return try {
            db.collection(COLLECTION_BATTLE_ROOMS).document(roomId).set(roomMap).await()
            Result.success(Pair(roomId, roomCode))
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.CREATE, "$COLLECTION_BATTLE_ROOMS/$roomId")
            Result.failure(t)
        }
    }

    /**
     * Join an existing battle room using a 6-digit room code.
     */
    suspend fun joinByRoomCode(user: UserProfile, code: String): Result<String> {
        val db = firestore
            ?: return Result.failure(IllegalStateException("Cloud Firestore is offline."))
        val currentUid = try {
            NamedFirestoreProvider.requireAuthenticatedUid(context)
        } catch (e: Exception) {
            return Result.failure(e)
        }

        val trimmed = code.trim().uppercase()
        if (trimmed.length != 6) {
            return Result.failure(IllegalArgumentException("Please enter a valid 6-digit room code."))
        }

        return try {
            val snapshot = db.collection(COLLECTION_BATTLE_ROOMS)
                .whereEqualTo("roomCode", trimmed)
                .whereEqualTo("status", "WAITING")
                .limit(1)
                .get()
                .await()

            val doc = snapshot.documents.firstOrNull()
                ?: return Result.failure(IllegalStateException("Room code '$trimmed' not found or match already started."))

            val hostUid = doc.getString("hostUid") ?: ""
            if (hostUid == currentUid) {
                return Result.failure(IllegalStateException("You cannot join your own room. Share code '$trimmed' with a friend!"))
            }

            val roomId = doc.id
            val joined = joinRoomTransaction(db, roomId, currentUid, user)
            if (joined) {
                Result.success(roomId)
            } else {
                Result.failure(IllegalStateException("Room '$trimmed' is already full or no longer waiting."))
            }
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.LIST, COLLECTION_BATTLE_ROOMS)
            Result.failure(t)
        }
    }

    /**
     * Attaches a real-time snapshot listener to the active battle room.
     */
    fun attachRoomListener(
        roomId: String,
        onUpdate: (OnlineRoomData) -> Unit,
        onError: ((String) -> Unit)? = null
    ) {
        detachListener()
        val db = firestore ?: return
        val path = "$COLLECTION_BATTLE_ROOMS/$roomId"
        activeRoomListener = db.collection(COLLECTION_BATTLE_ROOMS).document(roomId)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    handleFirestoreError(error, OperationType.GET, path)
                    onError?.invoke(error.localizedMessage ?: "Lost connection to battle room.")
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {
                    val roomData = parseRoomDoc(snapshot.data)
                    if (roomData != null) {
                        onUpdate(roomData)
                    }
                }
            }
    }

    /**
     * Submits an answer for the local player (player1 if host, else player2).
     */
    suspend fun submitPlayerAnswer(roomId: String, isHost: Boolean, answer: String, scoreDelta: Int) {
        val db = firestore ?: return
        val prefix = if (isHost) "player1" else "player2"
        val path = "$COLLECTION_BATTLE_ROOMS/$roomId"
        try {
            val updates = hashMapOf<String, Any>(
                "$prefix.currentAnswer" to answer.take(500),
                "$prefix.answeredAt" to System.currentTimeMillis(),
                "updatedAt" to FieldValue.serverTimestamp()
            )
            db.collection(COLLECTION_BATTLE_ROOMS).document(roomId).update(updates).await()
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.UPDATE, path)
        }
    }

    /**
     * Transitions room to ROUND_REVEAL with updated scores.
     */
    suspend fun revealRound(roomId: String, p1Score: Int, p2Score: Int, p1Streak: Int, p2Streak: Int) {
        val db = firestore ?: return
        val path = "$COLLECTION_BATTLE_ROOMS/$roomId"
        try {
            val updates = hashMapOf<String, Any>(
                "status" to "ROUND_REVEAL",
                "player1.score" to p1Score,
                "player2.score" to p2Score,
                "player1.streak" to p1Streak,
                "player2.streak" to p2Streak,
                "updatedAt" to FieldValue.serverTimestamp()
            )
            db.collection(COLLECTION_BATTLE_ROOMS).document(roomId).update(updates).await()
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.UPDATE, path)
        }
    }

    /**
     * Advances to the next question round or completes the game.
     */
    suspend fun advanceToNextRound(roomId: String, nextRoundIndex: Int, isGameOver: Boolean, winnerUid: String?) {
        val db = firestore ?: return
        val path = "$COLLECTION_BATTLE_ROOMS/$roomId"
        try {
            val updates = hashMapOf<String, Any>(
                "status" to if (isGameOver) "COMPLETED" else "IN_PROGRESS",
                "currentRound" to nextRoundIndex,
                "roundStartTime" to System.currentTimeMillis(),
                "player1.currentAnswer" to "",
                "player2.currentAnswer" to "",
                "updatedAt" to FieldValue.serverTimestamp()
            )
            if (winnerUid != null) {
                updates["winnerUid"] = winnerUid
            }
            db.collection(COLLECTION_BATTLE_ROOMS).document(roomId).update(updates).await()
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.UPDATE, path)
        }
    }

    fun detachListener() {
        activeRoomListener?.remove()
        activeRoomListener = null
    }

    suspend fun cancelRoom(roomId: String) {
        detachListener()
        val db = firestore ?: return
        val path = "$COLLECTION_BATTLE_ROOMS/$roomId"
        try {
            db.collection(COLLECTION_BATTLE_ROOMS).document(roomId).update(
                mapOf(
                    "status" to "CANCELLED",
                    "updatedAt" to FieldValue.serverTimestamp()
                )
            ).await()
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.UPDATE, path)
        }
    }

    companion object {
        private const val TAG = "RealOnlineBattleManager"
        private const val COLLECTION_BATTLE_ROOMS = "battle_rooms"

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: RealOnlineBattleManager? = null

        fun getInstance(context: Context): RealOnlineBattleManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: RealOnlineBattleManager(context.applicationContext).also { INSTANCE = it }
            }
        }
    }
}
