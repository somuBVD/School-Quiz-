package com.example.data

/**
 * Data class representing a mental ability quiz question.
 *
 * @param text The question text or prompt.
 * @param options The list of multiple choice options.
 * @param correctIndex The 0-based index of the correct answer in [options].
 */
data class MentalAbilityQuizQuestion(
    val text: String,
    val options: List<String>,
    val correctIndex: Int
)

// Alias for Question as requested
typealias QuestionItem = MentalAbilityQuizQuestion

/**
 * MentalAbilityData object providing 10 diverse quiz questions covering
 * pattern sequences, logical series, and simple family logic.
 */
object MentalAbilityData {

    /**
     * Internal nested Question data class matching the requested signature:
     * Question(text: String, options: List<String>, correctIndex: Int)
     */
    data class Question(
        val text: String,
        val options: List<String>,
        val correctIndex: Int
    )

    /**
     * Compatibility alias/property for MentalAbilityQuestion
     */
    val correctAnswerIndexCompat: (Question) -> Int = { it.correctIndex }

    /**
     * 10 diverse quiz questions covering pattern sequences and simple family logic
     */
    val questions: List<Question> = listOf(
        // 1. Number pattern: Cubes sequence
        Question(
            text = "ಮುಂದಿನ ಸಂಖ್ಯೆಯನ್ನು ಬರೆಯಿರಿ (Find the next number in sequence):\n1, 8, 27, 64, …?",
            options = listOf("100", "120", "125", "128"),
            correctIndex = 2 // 125 (1³, 2³, 3³, 4³, 5³=125)
        ),

        // 2. Number pattern: Arithmetic sequence (+10)
        Question(
            text = "ಮುಂದಿನ ಸಂಖ್ಯೆ ಯಾವುದು (Complete the series):\n13, 23, 33, 43, …?",
            options = listOf("83", "73", "53", "63"),
            correctIndex = 2 // 53 (+10 progression)
        ),

        // 3. Number pattern: Squares series
        Question(
            text = "ಸಂಖ್ಯಾ ಸರಣಿಯ ಮುಂದಿನ ಸಂಖ್ಯೆ ಕಂಡುಹಿಡಿಯಿರಿ:\n1, 4, 9, 16, …?",
            options = listOf("20", "25", "30", "36"),
            correctIndex = 1 // 25 (1², 2², 3², 4², 5²=25)
        ),

        // 4. Number pattern: Decreasing odd numbers (-2)
        Question(
            text = "ಮುಂದಿನ ಸಂಖ್ಯೆಯನ್ನು ಗುರುತಿಸಿ:\n99, 97, 95, 93, 91, …?",
            options = listOf("90", "89", "88", "87"),
            correctIndex = 1 // 89 (91 - 2 = 89)
        ),

        // 5. Logical series: Doubling increments (+2, +4, +8, +16, +32)
        Question(
            text = "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆಯ ಜಾಗದಲ್ಲಿ ಬರುವ ಸಂಖ್ಯೆ ಯಾವುದು?\n3, 5, 9, 17, 33, ?",
            options = listOf("45", "55", "65", "68"),
            correctIndex = 2 // 65 (33 + 32 = 65)
        ),

        // 6. Geometric sequence: Doubling (x2)
        Question(
            text = "ಸಂಖ್ಯಾ ಶ್ರೇಣಿಯ ಮುಂದಿನ ಸಂಖ್ಯೆ ಯಾವುದು?\n2, 4, 8, 16, 32, ?",
            options = listOf("48", "60", "64", "72"),
            correctIndex = 2 // 64 (32 x 2 = 64)
        ),

        // 7. Letter pattern & coding analogy
        Question(
            text = "ಅಕ್ಷರ ಶ್ರೇಣಿಯನ್ನು ಪೂರ್ಣಗೊಳಿಸಿ (Complete the letter analogy):\nABC : ZYX :: DEF : ?",
            options = listOf("UVW", "WVU", "VUT", "XYZ"),
            correctIndex = 1 // WVU (Opposite alphabet letters)
        ),

        // 8. Family logic puzzle: Paternal relation
        Question(
            text = "ತಂದೆಯ ತಮ್ಮನನ್ನು ಏನೆಂದು ಕರೆಯುವರು? (What is your father's younger brother called?)",
            options = listOf("ದೊಡ್ಡಪ್ಪ", "ಚಿಕ್ಕಪ್ಪ (Paternal Uncle)", "ಭಾವ", "ಮಾವ"),
            correctIndex = 1 // ಚಿಕ್ಕಪ್ಪ
        ),

        // 9. Family logic puzzle: Grandfather's daughter-in-law
        Question(
            text = "ನಿನ್ನ ಅಜ್ಜನ ಸೊಸೆಯ ಗಂಡ ನಿನಗೆ ಏನಾಗುತ್ತಾರೆ? (Who is your paternal grandfather's daughter-in-law's husband to you?)",
            options = listOf("ಅಣ್ಣ (Brother)", "ತಂದೆ (Father)", "ಅಜ್ಜ (Grandfather)", "ಮಾವ (Uncle)"),
            correctIndex = 1 // ತಂದೆ
        ),

        // 10. Family logic puzzle: Direct lineage
        Question(
            text = "ಮಗನ ಮಗನನ್ನು ಏನೆಂದು ಕರೆಯುವರು? (What is one's son's son called?)",
            options = listOf("ಮೊಮ್ಮಗ (Grandson)", "ಅಳಿಯ (Son-in-law)", "ತಮ್ಮ (Brother)", "ಭಾವ (Brother-in-law)"),
            correctIndex = 0 // ಮೊಮ್ಮಗ
        )
    )

    /**
     * Converts a Question to QuestionModel for integration with quiz runners.
     */
    fun toQuestionModel(q: Question, id: String, stdId: Int = 11, unitId: Int = 1): QuestionModel {
        val safeOptions = if (q.options.isNotEmpty()) q.options else listOf("A", "B", "C", "D")
        val correctStr = if (q.correctIndex in safeOptions.indices) {
            safeOptions[q.correctIndex]
        } else {
            safeOptions[0]
        }
        return QuestionModel(
            id = id,
            stdId = stdId,
            subjectId = "mental_ability",
            unitId = unitId,
            type = "MCQ",
            questionText = q.text,
            options = safeOptions,
            correctAnswer = correctStr
        )
    }

    /**
     * Provides QuestionModel representation of all questions.
     */
    val asQuestionModels: List<QuestionModel> by lazy {
        questions.mapIndexed { index, q ->
            toQuestionModel(q, "ma_data_q_${index + 1}")
        }
    }
}
