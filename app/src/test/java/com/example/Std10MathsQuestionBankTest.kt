package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std10MathsQuestionBankTest {

    @Test
    fun testStd10MathsUnitsStructure() {
        val std10 = QuizStaticData.standardsList.find { it.std == 10 }
        assertNotNull("Standard 10 must be present in standardsList", std10)

        val mathSubject = std10!!.subjects.find { it.id == "math" }
        assertNotNull("Maths subject must be present in Std 10", mathSubject)

        // All 14 units must be present
        assertEquals("Standard 10 Mathematics must contain 14 units", 14, mathSubject!!.units.size)

        // Validate unit titles
        val unitTitles = listOf(
            1 to "ವಾಸ್ತವ ಸಂಖ್ಯೆಗಳು",
            2 to "ಬಹುಪದೋಕ್ತಿಗಳು",
            3 to "ಎರಡು ಚರಾಕ್ಷರವುಳ್ಳ ರೇಖಾತ್ಮಕ ಸಮೀಕರಣಗಳ ಜೋಡಿಗಳು",
            4 to "ವರ್ಗ ಸಮೀಕರಣಗಳು",
            5 to "ಸಮಾಂತರ ಶ್ರೇಢಿಗಳು",
            6 to "ತ್ರಿಭುಜಗಳು",
            7 to "ನಿರ್ದೇಶಾಂಕ ರೇಖಾಗಣಿತ",
            8 to "ತ್ರಿಕೋನಮಿತಿಯ ಪ್ರಸ್ತಾವನೆ",
            9 to "ತ್ರಿಕೋನಮಿತಿಯ ಕೆಲವು ಅನ್ವಯಗಳು",
            10 to "ವೃತ್ತಗಳು",
            11 to "ವೃತ್ತಗಳಿಗೆ ಸಂಬಂಧಿಸಿದ ವಿಸ್ತೀರ್ಣಗಳು",
            12 to "ಮೇಲ್ಮೈ ವಿಸ್ತೀರ್ಣಗಳು ಹಾಗೂ ಘನಫಲಗಳು",
            13 to "ಸಂಖ್ಯಾಶಾಸ್ತ್ರ",
            14 to "ಸಂಭವನೀಯತೆ"
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
    fun testStd10MathsQuestionsIntegrity() {
        val questions = Std10MathsQuestionBank.questions
        assertTrue("Std 10 Maths question bank should contain more than 150 questions", questions.size >= 150)

        val seenIds = mutableSetOf<String>()
        val seenTexts = mutableSetOf<String>()

        for (q in questions) {
            // ID uniqueness
            assertTrue("Duplicate question ID: ${q.id}", seenIds.add(q.id))
            assertTrue("Question ID should start with std10_math: ${q.id}", q.id.startsWith("std10_math"))

            // Standard and Subject verification
            assertEquals("stdId must be 10", 10, q.stdId)
            assertEquals("subjectId must be math", "math", q.subjectId)
            assertTrue("unitId must be between 1 and 14", q.unitId in 1..14)

            // Text and options
            assertFalse("Question text must not be empty", q.questionText.isBlank())
            assertEquals("Each question must have exactly 4 options", 4, q.options.size)
            assertTrue(
                "Options must be distinct: ${q.options}",
                q.options.toSet().size == q.options.size
            )
            assertTrue(
                "Correct answer '${q.correctAnswer}' must be in options: ${q.options}",
                q.options.contains(q.correctAnswer)
            )
            assertFalse("Explanation must not be empty", q.explanation.isBlank())
        }

        // Verify each of the 14 units has questions
        for (u in 1..14) {
            val unitQuestions = questions.filter { it.unitId == u }
            assertTrue("Unit $u must have at least 10 questions", unitQuestions.size >= 10)
        }
    }
}
