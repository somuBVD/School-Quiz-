package com.example.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Room entity for storing historical quiz scores and attempt metrics locally on the device.
 */
@Entity(
    tableName = "historical_scores",
    indices = [
        Index(value = ["stdId", "subjectId", "unitId"]),
        Index(value = ["completedAt"]),
        Index(value = ["isPassed"])
    ]
)
data class HistoricalScoreEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val stdId: Int,
    val subjectId: String,
    val unitId: Int,
    val unitName: String,
    val score: Int,
    val totalQuestions: Int,
    val accuracyPercentage: Int, // 0 to 100
    val earnedCoins: Int,
    val earnedXP: Int,
    val earnedStars: Int,
    val timeTakenSeconds: Int = 0,
    val isPassed: Boolean = if (totalQuestions > 0) (score >= totalQuestions / 2) else false,
    val completedAt: Long = System.currentTimeMillis()
)
