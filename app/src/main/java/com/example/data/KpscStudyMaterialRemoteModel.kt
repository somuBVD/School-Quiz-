package com.example.data

import androidx.annotation.Keep
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.IgnoreExtraProperties
import com.google.firebase.firestore.ServerTimestamp

/**
 * Firestore remote DTO for `/kpsc_study_materials/{materialId}`.
 *
 * Strictly aligned with `firestore.rules`:
 * - Document ID is bound via `@DocumentId` and never written inside the document payload.
 * - Boolean property uses `published` (no `is` prefix) for exact Firestore field parity.
 * - `createdAt` and `updatedAt` use server timestamps and are read with ESTIMATE behavior.
 */
@Keep
@IgnoreExtraProperties
data class KpscStudyMaterialRemote(
    @DocumentId val id: String = "",
    val subjectId: String = "kpsc_kannada",
    val unitId: Int = 1,
    val unitName: String = "",
    val title: String = "",
    val summary: String = "",
    val contentMarkdown: String = "",
    val language: String = "bilingual",
    val difficulty: String = "Medium",
    val examTags: List<String> = emptyList(),
    val questions: List<Map<String, Any?>> = emptyList(),
    val contentVersion: Int = 1,
    val published: Boolean = true,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
) {
    /**
     * Exact create payload matching `isValidKpscStudyMaterial` in `firestore.rules`.
     */
    fun toCreateMap(): Map<String, Any> = hashMapOf(
        "subjectId" to subjectId,
        "unitId" to unitId.coerceIn(1, 100),
        "unitName" to unitName.take(160).ifBlank { "Unit $unitId" },
        "title" to title.take(200).ifBlank { unitName.ifBlank { "KPSC Study Material" } },
        "summary" to summary.take(1000),
        "contentMarkdown" to contentMarkdown.take(25000),
        "language" to if (language in VALID_LANGUAGES) language else "bilingual",
        "difficulty" to if (difficulty in VALID_DIFFICULTIES) difficulty else "Medium",
        "examTags" to examTags.take(10),
        "questions" to questions.take(100),
        "contentVersion" to contentVersion.coerceIn(1, 10000),
        "published" to published,
        "createdAt" to FieldValue.serverTimestamp(),
        "updatedAt" to FieldValue.serverTimestamp()
    )

    /**
     * Partial update payload preserving `createdAt` per `createdAtUnchanged()` in `firestore.rules`.
     */
    fun toUpdateMap(): Map<String, Any> = hashMapOf(
        "subjectId" to subjectId,
        "unitId" to unitId.coerceIn(1, 100),
        "unitName" to unitName.take(160).ifBlank { "Unit $unitId" },
        "title" to title.take(200).ifBlank { unitName.ifBlank { "KPSC Study Material" } },
        "summary" to summary.take(1000),
        "contentMarkdown" to contentMarkdown.take(25000),
        "language" to if (language in VALID_LANGUAGES) language else "bilingual",
        "difficulty" to if (difficulty in VALID_DIFFICULTIES) difficulty else "Medium",
        "examTags" to examTags.take(10),
        "questions" to questions.take(100),
        "contentVersion" to contentVersion.coerceIn(1, 10000),
        "published" to published,
        "updatedAt" to FieldValue.serverTimestamp()
    )

    /**
     * Extracts valid embedded KPSC MCQ items into local Room `QuizQuestionEntity` rows (`stdId = 15`).
     */
    fun parseEmbeddedQuestions(syncTimeMillis: Long = System.currentTimeMillis()): List<QuizQuestionEntity> {
        val result = mutableListOf<QuizQuestionEntity>()
        questions.forEachIndexed { index, raw ->
            val qText = (raw["questionText"] as? String)?.trim().orEmpty()
            val correct = (raw["correctAnswer"] as? String)?.trim().orEmpty()
            if (qText.isBlank() || correct.isBlank()) return@forEachIndexed

            val rawId = (raw["id"] as? String)?.trim().orEmpty()
            val resolvedId = if (rawId.isNotBlank()) rawId else "kpsc_mat_${id}_q_${index + 1}"
            val resolvedUnitId = (raw["unitId"] as? Number)?.toInt()?.coerceIn(1, 100) ?: unitId
            val resolvedType = (raw["type"] as? String)?.ifBlank { "MCQ" } ?: "MCQ"
            val resolvedOptions = (raw["options"] as? List<*>)
                ?.mapNotNull { it?.toString()?.trim() }
                ?.filter { it.isNotEmpty() }
                ?: emptyList()
            val resolvedExplanation = (raw["explanation"] as? String)?.trim().orEmpty()
            val resolvedDifficulty = (raw["difficulty"] as? String)?.takeIf { it in VALID_DIFFICULTIES } ?: difficulty
            val resolvedHint = (raw["hint"] as? String)?.trim().orEmpty()

            result.add(
                QuizQuestionEntity(
                    id = resolvedId,
                    stdId = KPSC_STD_ID,
                    subjectId = subjectId,
                    unitId = resolvedUnitId,
                    unitName = unitName.ifBlank { "Unit $resolvedUnitId" },
                    type = resolvedType,
                    questionText = qText,
                    optionsString = resolvedOptions.joinToString("|"),
                    correctAnswer = correct,
                    explanation = resolvedExplanation,
                    mediaRes = (raw["mediaRes"] as? String)?.trim().orEmpty(),
                    difficulty = resolvedDifficulty,
                    hint = resolvedHint,
                    points = (raw["points"] as? Number)?.toInt()?.coerceIn(5, 100) ?: 10,
                    isCustom = false,
                    createdAt = updatedAt?.toDate()?.time ?: syncTimeMillis
                )
            )
        }
        return result
    }

    fun toLocalEntity(syncTimeMillis: Long = System.currentTimeMillis(), parsedQuestionCount: Int? = null): KpscStudyMaterialEntity {
        val effectiveId = id.ifBlank { "kpsc_${subjectId}_u${unitId}" }
        return KpscStudyMaterialEntity(
            id = effectiveId,
            subjectId = subjectId,
            unitId = unitId,
            unitName = unitName.ifBlank { "Unit $unitId" },
            title = title.ifBlank { unitName.ifBlank { "KPSC Module" } },
            summary = summary,
            contentMarkdown = contentMarkdown,
            language = language,
            difficulty = difficulty,
            examTagsCsv = examTags.joinToString(","),
            questionCount = parsedQuestionCount ?: questions.size,
            contentVersion = contentVersion,
            published = published,
            updatedAtMillis = updatedAt?.toDate()?.time ?: syncTimeMillis,
            lastSyncedAtMillis = syncTimeMillis
        )
    }

    companion object {
        const val COLLECTION_NAME = "kpsc_study_materials"
        const val KPSC_STD_ID = 15

        val VALID_SUBJECT_IDS = setOf(
            "kpsc_kannada",
            "kpsc_english",
            "kpsc_gk",
            "kpsc_science",
            "kpsc_kannada_grammar",
            "kpsc_computer",
            "karnataka_history",
            "indian_polity",
            "geography_economy",
            "general_science",
            "mental_ability"
        )

        val VALID_LANGUAGES = setOf("kn", "en", "bilingual")
        val VALID_DIFFICULTIES = setOf("Easy", "Medium", "Hard")
    }
}
