package com.example.data

import androidx.room.Entity
import androidx.room.Index

/**
 * Room entity representing a quiz unit downloaded for full offline play.
 */
@Entity(
    tableName = "downloaded_quizzes",
    primaryKeys = ["stdId", "subjectId", "unitId"],
    indices = [
        Index(value = ["stdId"]),
        Index(value = ["subjectId"])
    ]
)
data class DownloadedQuizEntity(
    val stdId: Int,
    val subjectId: String,
    val unitId: Int,
    val unitName: String,
    val questionCount: Int,
    val downloadedAt: Long = System.currentTimeMillis(),
    val sizeBytes: Long = 0L,
    val isDownloaded: Boolean = true
)
