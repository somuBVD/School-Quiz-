package com.example.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Room entity representing a quiz Question for offline persistence.
 */
@Entity(
    tableName = "questions",
    indices = [
        Index(value = ["stdId", "subjectId", "unitId"]),
        Index(value = ["difficulty"]),
        Index(value = ["type"])
    ]
)
data class Question(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "stdId")
    val stdId: Int,

    @ColumnInfo(name = "subjectId")
    val subjectId: String,

    @ColumnInfo(name = "unitId")
    val unitId: Int,

    @ColumnInfo(name = "unitName")
    val unitName: String = "",

    @ColumnInfo(name = "questionText")
    val questionText: String,

    @ColumnInfo(name = "options")
    val options: String, // Pipe-separated options or JSON representation (e.g. "Option A|Option B|Option C|Option D")

    @ColumnInfo(name = "correctAnswer")
    val correctAnswer: String,

    @ColumnInfo(name = "explanation")
    val explanation: String = "",

    @ColumnInfo(name = "difficulty")
    val difficulty: String = "Medium", // "Easy", "Medium", "Hard"

    @ColumnInfo(name = "type")
    val type: String = "MCQ", // "MCQ", "TF", "MATCH", "FILL", etc.

    @ColumnInfo(name = "points")
    val points: Int = 10,

    @ColumnInfo(name = "hint")
    val hint: String = "",

    @ColumnInfo(name = "mediaRes")
    val mediaRes: String = "",

    @ColumnInfo(name = "isCustom")
    val isCustom: Boolean = false,

    @ColumnInfo(name = "createdAt")
    val createdAt: Long = System.currentTimeMillis()
)

/**
 * Extension conversion function between Question entity and QuestionModel.
 */
fun Question.toQuestionModel(): QuestionModel {
    val optList = if (options.isBlank()) emptyList() else options.split("|")
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

/**
 * Extension conversion function between QuestionModel and Question entity.
 */
fun QuestionModel.toQuestion(
    unitName: String = "",
    difficulty: String = "Medium",
    points: Int = 10,
    hint: String = "",
    isCustom: Boolean = false
): Question {
    return Question(
        id = id,
        stdId = stdId,
        subjectId = subjectId,
        unitId = unitId,
        unitName = unitName,
        questionText = questionText,
        options = options.joinToString("|"),
        correctAnswer = correctAnswer,
        explanation = explanation,
        difficulty = difficulty,
        type = type,
        points = points,
        hint = hint,
        mediaRes = mediaRes,
        isCustom = isCustom,
        createdAt = System.currentTimeMillis()
    )
}
