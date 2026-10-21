package com.example.battle

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.example.data.QuestionModel
import com.example.data.UserProfile
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.SetOptions
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
 * RealOnlineBattleManager provides genuine online 1 vs 1 student multiplayer battles
 * utilizing Google Cloud Firestore collection 'battle_rooms'.
 *
 * Supports:
 * 1. Quick Match: Auto-matches students in the same standard or creates an open room.
 * 2. Room Code Duels: Host creates a 6-digit room code, opponent enters the code to join instantly.
 * 3. Real-Time Gameplay: Snapshot listener synchronizes live rounds, timed answers, speed points, and victory stats.
 */
class RealOnlineBattleManager private constructor(private val context: Context) {

    private val firestore: FirebaseFirestore? by lazy {
        try {
            FirebaseFirestore.getInstance()
        } catch (t: Throwable) {
            Log.w(TAG, "Firestore initialization note: ${t.message}")
            null
        }
    }

    private var activeRoomListener: ListenerRegistration? = null

    fun isOnlineAvailable(): Boolean = firestore != null

    /**
     * Converts QuestionModel list to Firestore-compatible maps.
     */
    private fun questionsToMaps(questions: List<QuestionModel>): List<Map<String, Any>> {
        return questions.map { q ->
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

    /**
     * Reconstructs QuestionModel list from Firestore data.
     */
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
            } catch (e: Exception) {
                null
            }
        }
    }

    /**
     * Parses a Firestore document snapshot into OnlineRoomData.
     */
    @Suppress("UNCHECKED_CAST")
    fun parseRoomDoc(docData: Map<String, Any>?): OnlineRoomData? {
        if (docData == null) return null
        return try {
            val p1Map = docData["player1"] as? Map<String, Any> ?: emptyMap()
            val p2Map = docData["player2"] as? Map<String, Any>

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

    /**
     * Search for an existing open waiting room in Firestore, or create a new room as host.
     * Returns Triple(roomId, roomCode, isHost).
     */
    suspend fun findOrCreateMatch(
        user: UserProfile,
        subjectId: String,
        candidateQuestions: List<QuestionModel>
    ): Triple<String, String, Boolean> {
        val db = firestore ?: throw IllegalStateException("Cloud Firestore is offline")
        val currentUid = user.id.toString()
        val now = System.currentTimeMillis()

        // 1. Check for open waiting rooms in same standard
        try {
            val snapshot = db.collection("battle_rooms")
                .whereEqualTo("status", "WAITING")
                .whereEqualTo("isPrivate", false)
                .whereEqualTo("standard", user.standard)
                .limit(10)
                .get()
                .await()

            for (doc in snapshot.documents) {
                val hostUid = doc.getString("hostUid") ?: ""
                val createdAt = doc.getLong("createdAt") ?: 0L
                // Avoid matching with self and ignore expired rooms older than 3 minutes
                if (hostUid != currentUid && (now - createdAt) < 180_000L) {
                    val roomId = doc.id
                    val roomCode = doc.getString("roomCode") ?: ""

                    // Join as Player 2
                    val p2Map = mapOf(
                        "uid" to currentUid,
                        "name" to user.name.ifBlank { "Student" },
                        "school" to "Karnataka State Board",
                        "avatar" to user.avatar,
                        "standard" to user.standard,
                        "score" to 0,
                        "currentAnswer" to "",
                        "streak" to 0,
                        "answeredAt" to 0L
                    )

                    db.collection("battle_rooms").document(roomId).update(
                        mapOf(
                            "player2" to p2Map,
                            "status" to "IN_PROGRESS",
                            "roundStartTime" to System.currentTimeMillis()
                        )
                    ).await()

                    Log.i(TAG, "Successfully joined online battle room: $roomId as Player 2")
                    return Triple(roomId, roomCode, false)
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "Open room query note: ${e.message}")
        }

        // 2. If no open room found, create a new room as Host
        val generatedCode = (100000..999999).random().toString()
        val roomId = "battle_${now}_${(1000..9999).random()}"
        val selectedQuestions = candidateQuestions.shuffled().take(5)

        val p1Map = mapOf(
            "uid" to currentUid,
            "name" to user.name.ifBlank { "Student" },
            "school" to "Karnataka State Board",
            "avatar" to user.avatar,
            "standard" to user.standard,
            "score" to 0,
            "currentAnswer" to "",
            "streak" to 0,
            "answeredAt" to 0L
        )

        val roomMap = hashMapOf<String, Any>(
            "roomId" to roomId,
            "roomCode" to generatedCode,
            "hostUid" to currentUid,
            "isPrivate" to false,
            "subject" to subjectId,
            "standard" to user.standard,
            "status" to "WAITING",
            "currentRound" to 0,
            "roundStartTime" to 0L,
            "createdAt" to now,
            "questions" to questionsToMaps(selectedQuestions),
            "player1" to p1Map
        )

        db.collection("battle_rooms").document(roomId).set(roomMap).await()
        Log.i(TAG, "Created new online battle room: $roomId with code: $generatedCode as Host")
        return Triple(roomId, generatedCode, true)
    }

    /**
     * Create a private battle room for classmate duels via 6-digit code.
     */
    suspend fun createPrivateRoom(
        user: UserProfile,
        subjectId: String,
        candidateQuestions: List<QuestionModel>
    ): Pair<String, String> {
        val db = firestore ?: throw IllegalStateException("Cloud Firestore is offline")
        val currentUid = user.id.toString()
        val now = System.currentTimeMillis()
        val roomCode = (100000..999999).random().toString()
        val roomId = "private_${now}_${(1000..9999).random()}"
        val selectedQuestions = candidateQuestions.shuffled().take(5)

        val p1Map = mapOf(
            "uid" to currentUid,
            "name" to user.name.ifBlank { "Student" },
            "school" to "Karnataka State Board",
            "avatar" to user.avatar,
            "standard" to user.standard,
            "score" to 0,
            "currentAnswer" to "",
            "streak" to 0,
            "answeredAt" to 0L
        )

        val roomMap = hashMapOf<String, Any>(
            "roomId" to roomId,
            "roomCode" to roomCode,
            "hostUid" to currentUid,
            "isPrivate" to true,
            "subject" to subjectId,
            "standard" to user.standard,
            "status" to "WAITING",
            "currentRound" to 0,
            "roundStartTime" to 0L,
            "createdAt" to now,
            "questions" to questionsToMaps(selectedQuestions),
            "player1" to p1Map
        )

        db.collection("battle_rooms").document(roomId).set(roomMap).await()
        return Pair(roomId, roomCode)
    }

    /**
     * Join an existing battle room using a 6-digit room code.
     */
    suspend fun joinByRoomCode(user: UserProfile, code: String): Result<String> {
        val db = firestore ?: return Result.failure(IllegalStateException("Cloud Firestore is offline"))
        val trimmed = code.trim().uppercase()
        val currentUid = user.id.toString()

        return try {
            val snapshot = db.collection("battle_rooms")
                .whereEqualTo("roomCode", trimmed)
                .whereEqualTo("status", "WAITING")
                .limit(1)
                .get()
                .await()

            val doc = snapshot.documents.firstOrNull()
                ?: return Result.failure(Exception("Room code '$trimmed' not found or match already started."))

            val roomId = doc.id
            val p2Map = mapOf(
                "uid" to currentUid,
                "name" to user.name.ifBlank { "Student" },
                "school" to "Karnataka State Board",
                "avatar" to user.avatar,
                "standard" to user.standard,
                "score" to 0,
                "currentAnswer" to "",
                "streak" to 0,
                "answeredAt" to 0L
            )

            db.collection("battle_rooms").document(roomId).update(
                mapOf(
                    "player2" to p2Map,
                    "status" to "IN_PROGRESS",
                    "roundStartTime" to System.currentTimeMillis()
                )
            ).await()

            Result.success(roomId)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Attaches a real-time snapshot listener to the active battle room.
     */
    fun attachRoomListener(roomId: String, onUpdate: (OnlineRoomData) -> Unit) {
        detachListener()
        val db = firestore ?: return
        activeRoomListener = db.collection("battle_rooms").document(roomId)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.w(TAG, "Room listener error: ${error.message}")
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
        try {
            val updates = hashMapOf<String, Any>(
                "$prefix.currentAnswer" to answer,
                "$prefix.answeredAt" to System.currentTimeMillis()
            )
            db.collection("battle_rooms").document(roomId).update(updates).await()
        } catch (e: Exception) {
            Log.w(TAG, "Failed submitting answer: ${e.message}")
        }
    }

    /**
     * Transitions room to ROUND_REVEAL with updated scores.
     */
    suspend fun revealRound(roomId: String, p1Score: Int, p2Score: Int, p1Streak: Int, p2Streak: Int) {
        val db = firestore ?: return
        try {
            val updates = hashMapOf<String, Any>(
                "status" to "ROUND_REVEAL",
                "player1.score" to p1Score,
                "player2.score" to p2Score,
                "player1.streak" to p1Streak,
                "player2.streak" to p2Streak
            )
            db.collection("battle_rooms").document(roomId).update(updates).await()
        } catch (e: Exception) {
            Log.w(TAG, "Failed revealing round: ${e.message}")
        }
    }

    /**
     * Advances to the next question round or completes the game.
     */
    suspend fun advanceToNextRound(roomId: String, nextRoundIndex: Int, isGameOver: Boolean, winnerUid: String?) {
        val db = firestore ?: return
        try {
            val updates = hashMapOf<String, Any>(
                "status" to if (isGameOver) "COMPLETED" else "IN_PROGRESS",
                "currentRound" to nextRoundIndex,
                "roundStartTime" to System.currentTimeMillis(),
                "player1.currentAnswer" to "",
                "player2.currentAnswer" to ""
            )
            if (winnerUid != null) {
                updates["winnerUid"] = winnerUid
            }
            db.collection("battle_rooms").document(roomId).update(updates).await()
        } catch (e: Exception) {
            Log.w(TAG, "Failed advancing round: ${e.message}")
        }
    }

    /**
     * Detach real-time listener and cleans up active room.
     */
    fun detachListener() {
        activeRoomListener?.remove()
        activeRoomListener = null
    }

    /**
     * Leaves or cancels the room.
     */
    suspend fun cancelRoom(roomId: String) {
        detachListener()
        val db = firestore ?: return
        try {
            db.collection("battle_rooms").document(roomId).update("status", "CANCELLED").await()
        } catch (_: Exception) {}
    }

    companion object {
        private const val TAG = "RealOnlineBattleManager"

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
