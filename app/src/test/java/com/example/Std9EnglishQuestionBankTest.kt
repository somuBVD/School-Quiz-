package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std9EnglishQuestionBankTest {

    @Test
    fun testStd9EnglishUnitsStructure() {
        val std9 = QuizStaticData.standardsList.find { it.std == 9 }
        assertNotNull("Standard 9 must be present in standardsList", std9)

        val englishSubject = std9!!.subjects.find { it.id == "english" }
        assertNotNull("English subject must be present in Std 9", englishSubject)

        // All 10 units must be present
        assertEquals("Standard 9 English must contain 10 units", 10, englishSubject!!.units.size)

        // Check unit IDs and titles
        val unit1 = englishSubject.units.find { it.id == 1 }
        assertNotNull(unit1)
        assertTrue(unit1!!.name.contains("The Enchanted Pool"))

        val unit2 = englishSubject.units.find { it.id == 2 }
        assertNotNull(unit2)
        assertTrue(unit2!!.name.contains("The Three Questions"))

        val unit3 = englishSubject.units.find { it.id == 3 }
        assertNotNull(unit3)
        assertTrue(unit3!!.name.contains("My Beginnings"))

        val unit5 = englishSubject.units.find { it.id == 5 }
        assertNotNull(unit5)
        assertTrue(unit5!!.name.contains("Justice Above Self"))

        val unit6 = englishSubject.units.find { it.id == 6 }
        assertNotNull(unit6)
        assertTrue(unit6!!.name.contains("The Noble Bishop"))

        val unit8 = englishSubject.units.find { it.id == 8 }
        assertNotNull(unit8)
        assertTrue(unit8!!.name.contains("To My Country Men"))

        val unit9 = englishSubject.units.find { it.id == 9 }
        assertNotNull(unit9)
        assertTrue(unit9!!.name.contains("Supplementary Reading"))

        val unit10 = englishSubject.units.find { it.id == 10 }
        assertNotNull(unit10)
        assertTrue(unit10!!.name.contains("Grammar"))
    }

    @Test
    fun testStd9EnglishQuestionsIntegrity() {
        val questions = Std9EnglishQuestionBank.questions
        assertEquals("Std 9 English question bank should contain exactly 150 questions", 150, questions.size)

        val seenIds = mutableSetOf<String>()
        val seenTexts = mutableSetOf<String>()

        for (q in questions) {
            // ID uniqueness
            assertFalse("Duplicate question ID: ${q.id}", seenIds.contains(q.id))
            seenIds.add(q.id)

            // Text uniqueness (omit duplicates)
            val normalizedText = q.questionText.trim().lowercase()
            assertFalse("Duplicate question text found: ${q.questionText}", seenTexts.contains(normalizedText))
            seenTexts.add(normalizedText)

            // Std and subject checks
            assertEquals("stdId must be 9", 9, q.stdId)
            assertEquals("subjectId must be 'english'", "english", q.subjectId)
            assertTrue("unitId must be between 1 and 10", q.unitId in 1..10)
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
    fun testStd9EnglishIntegratedInStaticData() {
        val filteredStatic = QuizStaticData.staticQuestions.filter {
            it.stdId == 9 && it.subjectId == "english"
        }
        assertEquals("QuizStaticData must contain all 150 Std 9 English questions", 150, filteredStatic.size)

        // Verify fallback getter returns authentic questions
        val unit1Questions = QuizStaticData.getQuestionsForUnit(9, "english", 1, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 1", unit1Questions.isNotEmpty())
        assertTrue(unit1Questions.any { it.questionText.contains("Pandava") || it.questionText.contains("Yaksha") })
    }
}
