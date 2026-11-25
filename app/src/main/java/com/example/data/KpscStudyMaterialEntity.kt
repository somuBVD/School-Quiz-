package com.example.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Local Room entity caching synchronized KPSC study materials and subject-module quiz metadata
 * for offline accessibility and fast indexed lookups by subject, unit, difficulty, and freshness.
 */
@Entity(
    tableName = "kpsc_study_materials",
    indices = [
        Index(value = ["subjectId", "unitId"]),
        Index(value = ["subjectId", "updatedAtMillis"]),
        Index(value = ["difficulty"]),
        Index(value = ["published", "subjectId"])
    ]
)
data class KpscStudyMaterialEntity(
    @PrimaryKey val id: String,
    val subjectId: String,
    val unitId: Int,
    val unitName: String,
    val title: String,
    val summary: String = "",
    val contentMarkdown: String = "",
    val language: String = "bilingual",
    val difficulty: String = "Medium",
    val examTagsCsv: String = "KAS,FDA,SDA,PDO",
    val questionCount: Int = 0,
    val contentVersion: Int = 1,
    val published: Boolean = true,
    val updatedAtMillis: Long = System.currentTimeMillis(),
    val lastSyncedAtMillis: Long = System.currentTimeMillis()
) {
    fun examTagsList(): List<String> =
        examTagsCsv.split(",").map { it.trim() }.filter { it.isNotEmpty() }
}
