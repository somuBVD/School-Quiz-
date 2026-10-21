package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std9KannadaQuestionBankTest {

    @Test
    fun testStd9KannadaUnitsStructure() {
        val std9 = QuizStaticData.standardsList.find { it.std == 9 }
        assertNotNull("Standard 9 must be present in standardsList", std9)

        val kannadaSubject = std9!!.subjects.find { it.id == "kannada" }
        assertNotNull("Kannada subject must be present in Std 9", kannadaSubject)

        // All 23 units must be present
        assertEquals("Standard 9 Kannada must contain 23 units (8 Prose + 8 Poem + 7 Supplementary)", 23, kannadaSubject!!.units.size)

        // Check unit IDs and titles
        val unit1 = kannadaSubject.units.find { it.id == 1 }
        assertNotNull(unit1)
        assertTrue(unit1!!.name.contains("ಪ್ರಜಾನಿಷ್ಠೆ"))

        val unit9 = kannadaSubject.units.find { it.id == 9 }
        assertNotNull(unit9)
        assertTrue(unit9!!.name.contains("ಪಾರಿವಾಳ"))

        val unit17 = kannadaSubject.units.find { it.id == 17 }
        assertNotNull(unit17)
        assertTrue(unit17!!.name.contains("ಪುಟ್ಟ ಹಕ್ಕಿ"))

        val unit22 = kannadaSubject.units.find { it.id == 22 }
        assertNotNull(unit22)
        assertTrue(unit22!!.name.contains("ಗುಣಸಾಗರಿ ಪಂಧರೀಬಾಯಿ"))
    }

    @Test
    fun testStd9KannadaQuestionsIntegrity() {
        val proseQuestions = Std9KannadaProseQuestionBank.questions
        val poemQuestions = Std9KannadaPoemQuestionBank.questions
        val suppQuestions = Std9KannadaSupplementaryQuestionBank.questions

        assertEquals(236, proseQuestions.size)
        assertEquals(173, poemQuestions.size)
        assertEquals(73, suppQuestions.size)

        val allStd9Questions = proseQuestions + poemQuestions + suppQuestions
        assertEquals(482, allStd9Questions.size)

        // Check that every question has non-empty fields and correctAnswer is in options
        val seenIds = mutableSetOf<String>()
        val seenTexts = mutableSetOf<String>()

        for (q in allStd9Questions) {
            assertEquals(9, q.stdId)
            assertEquals("kannada", q.subjectId)
            assertTrue("Unit ID must be between 1 and 23", q.unitId in 1..23)

            assertFalse("ID must not be empty", q.id.isBlank())
            assertFalse("Question text must not be empty", q.questionText.isBlank())
            assertTrue("Options must have at least 2 choices", q.options.size >= 2)
            assertTrue(
                "Correct answer '${q.correctAnswer}' must be in options ${q.options} for question: ${q.questionText}",
                q.options.contains(q.correctAnswer)
            )

            // No duplicate IDs
            assertTrue("Duplicate ID found: ${q.id}", seenIds.add(q.id))

            // No duplicate question texts
            assertTrue("Duplicate question text found: ${q.questionText}", seenTexts.add(q.questionText.trim()))

            // Verify no picture-based questions exist
            assertFalse(
                "Picture based questions must be omitted: ${q.questionText}",
                q.questionText.contains("ಚಿತ್ರದಲ್ಲಿರುವ") || q.questionText.contains("ಈ ಚಿತ್ರವನ್ನು ನೋಡಿ")
            )
        }
    }

    @Test
    fun testGetQuestionsForUnitRetrieval() {
        // Test fetching each of the 23 units via QuizStaticData
        for (uId in 1..23) {
            val questions = QuizStaticData.getQuestionsForUnit(
                stdId = 9,
                subjectId = "kannada",
                unitId = uId,
                custom = emptyList()
            )
            assertTrue("Unit $uId must return questions", questions.isNotEmpty())
            assertTrue("All returned questions must belong to unit $uId", questions.all { it.unitId == uId })
        }
    }
}
