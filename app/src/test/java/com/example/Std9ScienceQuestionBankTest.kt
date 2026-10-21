package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std9ScienceQuestionBankTest {

    @Test
    fun testStd9ScienceUnitsStructure() {
        val std9 = QuizStaticData.standardsList.find { it.std == 9 }
        assertNotNull("Standard 9 must be present in standardsList", std9)

        val scienceSubject = std9!!.subjects.find { it.id == "science" }
        assertNotNull("Science subject must be present in Std 9", scienceSubject)

        // All 15 units must be present
        assertEquals("Standard 9 Science must contain 15 units", 15, scienceSubject!!.units.size)

        // Check unit IDs and titles
        val unit1 = scienceSubject.units.find { it.id == 1 }
        assertNotNull(unit1)
        assertTrue(unit1!!.name.contains("ನಮ್ಮ ಸುತ್ತಮುತ್ತಲಿನ ದ್ರವ್ಯ"))

        val unit2 = scienceSubject.units.find { it.id == 2 }
        assertNotNull(unit2)
        assertTrue(unit2!!.name.contains("ದ್ರವ್ಯವು ಶುದ್ಧವೇ"))

        val unit3 = scienceSubject.units.find { it.id == 3 }
        assertNotNull(unit3)
        assertTrue(unit3!!.name.contains("ಪರಮಾಣುಗಳು ಮತ್ತು ಅಣುಗಳು"))

        val unit4 = scienceSubject.units.find { it.id == 4 }
        assertNotNull(unit4)
        assertTrue(unit4!!.name.contains("ಪರಮಾಣುವಿನ ರಚನೆ"))

        val unit5 = scienceSubject.units.find { it.id == 5 }
        assertNotNull(unit5)
        assertTrue(unit5!!.name.contains("ಜೀವದ ಮೂಲಭೂತ ಘಟಕ"))

        val unit6 = scienceSubject.units.find { it.id == 6 }
        assertNotNull(unit6)
        assertTrue(unit6!!.name.contains("ಅಂಗಾಂಶಗಳು"))

        val unit7 = scienceSubject.units.find { it.id == 7 }
        assertNotNull(unit7)
        assertTrue(unit7!!.name.contains("ಜೀವಿಗಳಲ್ಲಿ ವೈವಿಧ್ಯತೆ"))

        val unit8 = scienceSubject.units.find { it.id == 8 }
        assertNotNull(unit8)
        assertTrue(unit8!!.name.contains("ಚಲನೆ"))

        val unit9 = scienceSubject.units.find { it.id == 9 }
        assertNotNull(unit9)
        assertTrue(unit9!!.name.contains("ಬಲ ಮತ್ತು ಚಲನೆಯ ನಿಯಮಗಳು"))

        val unit10 = scienceSubject.units.find { it.id == 10 }
        assertNotNull(unit10)
        assertTrue(unit10!!.name.contains("ಗುರುತ್ವಾಕರ್ಷಣೆ"))

        val unit11 = scienceSubject.units.find { it.id == 11 }
        assertNotNull(unit11)
        assertTrue(unit11!!.name.contains("ಕೆಲಸ ಮತ್ತು ಶಕ್ತಿ"))

        val unit12 = scienceSubject.units.find { it.id == 12 }
        assertNotNull(unit12)
        assertTrue(unit12!!.name.contains("ಶಬ್ದ"))

        val unit13 = scienceSubject.units.find { it.id == 13 }
        assertNotNull(unit13)
        assertTrue(unit13!!.name.contains("ನಾವು ಏಕೆ ಕಾಯಿಲೆ ಬೀಳುತ್ತೇವೆ"))

        val unit14 = scienceSubject.units.find { it.id == 14 }
        assertNotNull(unit14)
        assertTrue(unit14!!.name.contains("ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲಗಳು"))

        val unit15 = scienceSubject.units.find { it.id == 15 }
        assertNotNull(unit15)
        assertTrue(unit15!!.name.contains("ಆಹಾರ ಸಂಪನ್ಮೂಲಗಳ ಸುಧಾರಣೆ"))
    }

    @Test
    fun testStd9ScienceQuestionsIntegrity() {
        val questions = Std9ScienceQuestionBank.questions
        assertEquals("Std 9 Science question bank should contain exactly 240 questions", 240, questions.size)

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
            assertEquals("subjectId must be 'science'", "science", q.subjectId)
            assertTrue("unitId must be between 1 and 15, but was ${q.unitId}", q.unitId in 1..15)
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
    fun testStd9ScienceIntegratedInStaticData() {
        val filteredStatic = QuizStaticData.staticQuestions.filter {
            it.stdId == 9 && it.subjectId == "science"
        }
        assertEquals("QuizStaticData must contain all 240 Std 9 Science questions", 240, filteredStatic.size)

        // Verify fallback getter returns authentic questions for unit 1
        val unit1Questions = QuizStaticData.getQuestionsForUnit(9, "science", 1, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 1", unit1Questions.isNotEmpty())
        assertTrue(unit1Questions.any { it.questionText.contains("ದ್ರವ್ಯ") || it.questionText.contains("ಉತ್ಪತನ") })

        // Verify fallback getter returns authentic questions for unit 5
        val unit5Questions = QuizStaticData.getQuestionsForUnit(9, "science", 5, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 5", unit5Questions.isNotEmpty())
        assertTrue(unit5Questions.any { it.questionText.contains("ಜೀವಕೋಶ") || it.questionText.contains("ಮೈಟೊಕಾಂಡ್ರಿಯ") })

        // Verify fallback getter returns authentic questions for unit 10
        val unit10Questions = QuizStaticData.getQuestionsForUnit(9, "science", 10, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 10", unit10Questions.isNotEmpty())
        assertTrue(unit10Questions.any { it.questionText.contains("ಗುರುತ್ವಾಕರ್ಷಣಾ") || it.questionText.contains("ತೂಕ") })
    }
}
