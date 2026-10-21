package com.example.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Room entity for tracking points awarded to students for correct answers,
 * quiz completions, and learning streaks.
 */
@Entity(
    tableName = "student_points",
    indices = [
        Index(value = ["stdId", "subjectId", "unitId"]),
        Index(value = ["source"]),
        Index(value = ["timestamp"])
    ]
)
data class StudentPointEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val points: Int,
    val source: String = "CORRECT_ANSWER", // "CORRECT_ANSWER", "PERFECT_SCORE_BONUS", "STREAK_BONUS"
    val stdId: Int,
    val subjectId: String,
    val unitId: Int,
    val correctAnswersCount: Int = 1,
    val description: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
