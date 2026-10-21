package com.example.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Room entity for storing quiz questions locally on the device.
 */
@Entity(
    tableName = "quiz_questions",
    indices = [
        Index(value = ["stdId", "subjectId", "unitId"]),
        Index(value = ["type"]),
        Index(value = ["difficulty"])
    ]
)
data class QuizQuestionEntity(
    @PrimaryKey val id: String,
    val stdId: Int,
    val subjectId: String,
    val unitId: Int,
    val unitName: String = "",
    val type: String, // "MCQ", "TF", "MATCH", "FILL", "IMAGE", "AUDIO", "VIDEO"
    val questionText: String,
    val optionsString: String, // Pipe-separated options e.g. "A|B|C|D" or "PairLeft:PairRight"
    val correctAnswer: String,
    val explanation: String,
    val mediaRes: String = "",
    val difficulty: String = "Medium", // "Easy", "Medium", "Hard"
    val hint: String = "",
    val points: Int = 10,
    val isCustom: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

fun QuizQuestionEntity.toQuestionModel(): QuestionModel {
    val optList = if (optionsString.isBlank()) emptyList() else optionsString.split("|")
    return QuestionModel(
        id = id,
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

fun QuestionModel.toQuizQuestionEntity(
    unitName: String = "",
    difficulty: String = "Medium",
    hint: String = "",
    points: Int = 10,
    isCustom: Boolean = false
): QuizQuestionEntity {
    return QuizQuestionEntity(
        id = id,
        stdId = stdId,
        subjectId = subjectId,
        unitId = unitId,
        unitName = unitName,
        type = type,
        questionText = questionText,
        optionsString = options.joinToString("|"),
        correctAnswer = correctAnswer,
        explanation = explanation,
        mediaRes = mediaRes,
        difficulty = difficulty,
        hint = hint,
        points = points,
        isCustom = isCustom,
        createdAt = System.currentTimeMillis()
    )
}
