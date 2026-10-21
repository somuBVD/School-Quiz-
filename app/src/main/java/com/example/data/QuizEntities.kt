package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey val id: Int = 1,
    val name: String = "Suhas Govind",
    val nickname: String = "StarScholar",
    val standard: Int = 6,
    val coins: Int = 240,
    val stars: Int = 45,
    val xp: Int = 1250,
    val totalPoints: Int = 1850,
    val avatar: String = "avatar_astro_explorer",
    val attendanceStreak: Int = 5,
    val lastClaimedTimestamp: Long = 0L,
    val language: String = "English" // "English", "Kannada", "Hindi"
)

@Entity(tableName = "unit_progress", primaryKeys = ["stdId", "subjectId", "unitId"])
data class UnitProgress(
    val stdId: Int,
    val subjectId: String,
    val unitId: Int,
    val progress: Int = 0, // 0 to 100
    val completedQuestions: Int = 0,
    val totalQuestions: Int = 10,
    val difficulty: String = "Medium" // "Easy", "Medium", "Hard"
)

@Entity(tableName = "custom_questions")
data class CustomQuestion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val stdId: Int,
    val subjectId: String,
    val unitId: Int,
    val type: String, // "MCQ", "TF", "MATCH", "FILL", "IMAGE", "AUDIO", "VIDEO"
    val questionText: String,
    val optionsString: String, // Pipe-separated options e.g. "A|B|C|D" or matching column pairs
    val correctAnswer: String,
    val explanation: String,
    val mediaRes: String = "" // Identifies mock audio clue phrase or local vector drawing
)

@Entity(tableName = "leaderboard")
data class LeaderboardUser(
    @PrimaryKey val name: String,
    val coins: Int,
    val stars: Int,
    val xp: Int,
    val isMe: Boolean = false,
    val rank: Int = 0
)

@Entity(tableName = "notifications")
data class NotificationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val timestamp: Long = System.currentTimeMillis(),
    val isRead: Boolean = false,
    val category: String = "General" // "Daily Challenge", "Exam", "Reward", "System"
)

@Entity(tableName = "advertisements")
data class AdvertisementEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val subtitle: String,
    val imageUrl: String = "",
    val targetUrl: String = "",
    val isActive: Boolean = true
)

@Entity(tableName = "bookmarked_questions")
data class BookmarkedQuestionEntity(
    @PrimaryKey val questionId: String,
    val stdId: Int,
    val subjectId: String,
    val unitId: Int,
    val type: String, // "MCQ", "TF", "MATCH", "FILL", "IMAGE", "AUDIO", "VIDEO"
    val questionText: String,
    val optionsString: String, // Pipe-separated options e.g. "A|B|C|D"
    val correctAnswer: String,
    val explanation: String,
    val mediaRes: String = "",
    val bookmarkedAt: Long = System.currentTimeMillis()
)

fun BookmarkedQuestionEntity.toQuestionModel(): QuestionModel {
    val optList = if (optionsString.isBlank()) emptyList() else optionsString.split("|")
    return QuestionModel(
        id = questionId,
        stdId = stdId,
        subjectId = subjectId,
        unitId = unitId,
        type = type,
        questionText = questionText,
        options = optList,
        correctAnswer = correctAnswer,
        explanation = explanation,
        mediaRes = mediaRes
    )
}

fun QuestionModel.toBookmarkedEntity(): BookmarkedQuestionEntity {
    return BookmarkedQuestionEntity(
        questionId = id,
        stdId = stdId,
        subjectId = subjectId,
        unitId = unitId,
        type = type,
        questionText = questionText,
        optionsString = options.joinToString("|"),
        correctAnswer = correctAnswer,
        explanation = explanation,
        mediaRes = mediaRes,
        bookmarkedAt = System.currentTimeMillis()
    )
}
