package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std9MathsQuestionBankTest {

    @Test
    fun testStd9MathsUnitsStructure() {
        val std9 = QuizStaticData.standardsList.find { it.std == 9 }
        assertNotNull("Standard 9 must be present in standardsList", std9)

        val mathSubject = std9!!.subjects.find { it.id == "math" }
        assertNotNull("Maths subject must be present in Std 9", mathSubject)

        // All 12 units must be present
        assertEquals("Standard 9 Mathematics must contain 12 units", 12, mathSubject!!.units.size)

        // Validate all 12 unit titles
        val unitTitles = listOf(
            1 to "ಸಂಖ್ಯಾ ಪದ್ಧತಿ",
            2 to "ಬಹುಪದೋಕ್ತಿಗಳು",
            3 to "ನಿರ್ದೇಶಾಂಕ ರೇಖಾಗಣಿತ",
            4 to "ಎರಡು ಚರಾಕ್ಷರವುಳ್ಳ ರೇಖಾತ್ಮಕ ಸಮೀಕರಣಗಳು",
            5 to "ಯೂಕ್ಲಿಡ್‌ನ ರೇಖಾಗಣಿತದ ಪ್ರಸ್ತಾವನೆ",
            6 to "ರೇಖೆಗಳು ಮತ್ತು ಕೋನಗಳು",
            7 to "ತ್ರಿಭುಜಗಳು",
            8 to "ಚತುರ್ಭುಜಗಳು",
            9 to "ವೃತ್ತಗಳು",
            10 to "ಹೆರಾನ್‌ನ ಸೂತ್ರ",
            11 to "ಮೇಲ್ಮೈ ವಿಸ್ತೀರ್ಣಗಳು ಮತ್ತು ಘನಫಲಗಳು",
            12 to "ಸಂಖ್ಯಾಶಾಸ್ತ್ರ"
        )

        for ((id, expectedNamePart) in unitTitles) {
            val unit = mathSubject.units.find { it.id == id }
            assertNotNull("Unit $id must exist", unit)
            assertTrue(
                "Unit $id title '${unit!!.name}' should contain '$expectedNamePart'",
                unit.name.contains(expectedNamePart)
            )
        }
    }

    @Test
    fun testStd9MathsQuestionsIntegrity() {
        val questions = Std9MathsQuestionBank.questions
        assertEquals("Std 9 Maths question bank should contain exactly 192 questions (16 per unit for 12 units)", 192, questions.size)

        val seenIds = mutableSetOf<String>()
        val seenTexts = mutableSetOf<String>()

        for (q in questions) {
            // ID uniqueness
            assertFalse("Duplicate question ID: ${q.id}", seenIds.contains(q.id))
            seenIds.add(q.id)

            // Text uniqueness (omit duplicates)
            val normalizedText = q.questionText.trim()
            assertFalse("Duplicate question text found: ${q.questionText}", seenTexts.contains(normalizedText))
            seenTexts.add(normalizedText)

            // Std and subject checks
            assertEquals("stdId must be 9", 9, q.stdId)
            assertEquals("subjectId must be 'math'", "math", q.subjectId)
            assertTrue("unitId must be between 1 and 12, but was ${q.unitId}", q.unitId in 1..12)
            assertEquals("type must be MCQ", "MCQ", q.type)

            // Options and answer validation
            assertEquals("Every question must have exactly 4 options: ${q.id}", 4, q.options.size)
            assertTrue(
                "correctAnswer '${q.correctAnswer}' must be in options ${q.options} for question ${q.id}",
                q.options.contains(q.correctAnswer)
            )

            // Explanations must be detailed
            assertTrue("Explanation should not be blank for ${q.id}", q.explanation.isNotBlank())

            // Picture-based questions must be omitted (no mediaRes)
            assertTrue("Picture-based questions must be omitted: ${q.id}", q.mediaRes.isBlank())
        }
    }

    @Test
    fun testStd9MathsQuestionsDistributionPerUnit() {
        val questions = Std9MathsQuestionBank.questions
        for (u in 1..12) {
            val unitQuestions = questions.filter { it.unitId == u }
            assertEquals("Unit $u must have exactly 16 questions", 16, unitQuestions.size)
        }
    }

    @Test
    fun testStd9MathsIntegratedInStaticData() {
        val filteredStatic = QuizStaticData.staticQuestions.filter {
            it.stdId == 9 && it.subjectId == "math"
        }
        assertEquals("QuizStaticData must contain all 192 Std 9 Maths questions", 192, filteredStatic.size)

        // Verify fallback getter returns authentic questions for Unit 1 (Number systems)
        val unit1Questions = QuizStaticData.getQuestionsForUnit(9, "math", 1, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 1", unit1Questions.isNotEmpty())
        assertTrue(unit1Questions.any { it.questionText.contains("ಭಾಗಲಬ್ಧ") || it.questionText.contains("ಅಭಾಗಲಬ್ಧ") })

        // Verify fallback getter returns authentic questions for Unit 2 (Polynomials)
        val unit2Questions = QuizStaticData.getQuestionsForUnit(9, "math", 2, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 2", unit2Questions.isNotEmpty())
        assertTrue(unit2Questions.any { it.questionText.contains("ಬಹುಪದೋಕ್ತಿ") || it.questionText.contains("ಶೂನ್ಯತೆ") })

        // Verify fallback getter returns authentic questions for Unit 10 (Heron's formula)
        val unit10Questions = QuizStaticData.getQuestionsForUnit(9, "math", 10, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 10", unit10Questions.isNotEmpty())
        assertTrue(unit10Questions.any { it.questionText.contains("ಹೆರಾನ್") || it.questionText.contains("ಅರ್ಧಸುತ್ತಳತೆ") })

        // Verify fallback getter returns authentic questions for Unit 12 (Statistics)
        val unit12Questions = QuizStaticData.getQuestionsForUnit(9, "math", 12, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 12", unit12Questions.isNotEmpty())
        assertTrue(unit12Questions.any { it.questionText.contains("ಸ್ತಂಭಲೇಖ") || it.questionText.contains("ವರ್ಗಾಂತರ") || it.questionText.contains("ಆವೃತ್ತಿ") })
    }
}
