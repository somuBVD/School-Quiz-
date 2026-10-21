package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std10KannadaQuestionBankTest {

    @Test
    fun testStd10KannadaUnitsStructure() {
        val std10 = QuizStaticData.standardsList.find { it.std == 10 }
        assertNotNull("Standard 10 must be present in standardsList", std10)

        val kannadaSubject = std10!!.subjects.find { it.id == "kannada" }
        assertNotNull("Kannada subject must be present in Std 10", kannadaSubject)

        // All 22 units must be present
        assertEquals("Standard 10 Kannada must contain 22 units", 22, kannadaSubject!!.units.size)

        // Validate unit titles
        val unitTitles = listOf(
            1 to "ನಮ್ಮ ಭಾಷೆ",
            2 to "ವ್ಯಾಘ್ರಗೀತೆ",
            3 to "ಭಾಗ್ಯಶಿಲ್ಪಿಗಳು",
            4 to "ಎದೆಗೆ ಬಿದ್ದ ಅಕ್ಷರ",
            5 to "ಯುದ್ಧ",
            6 to "ಶಬರಿ",
            7 to "ಲಂಡನ್ ನಗರ",
            8 to "ಅಗ್ನಿಭೂತಿ ವಾಯುಭೂತಿಯರ ಕಥೆ",
            9 to "ಸಂಕಲ್ಪಗೀತೆ",
            10 to "ಹಕ್ಕಿ ಹಾರುತ್ತಿದೆ ನೋಡಿದಿರಾ",
            11 to "ಕೌರವೇಂದ್ರನ ಕೊಂದೆ ನೀನು",
            12 to "ಛಲಮನೆ ಮೆರೆವೆಂ",
            13 to "ಹಸುರು",
            14 to "ಹಲಗಲಿ ಬೇಡರು",
            15 to "ವೀರಲವ",
            16 to "ಕೆಮ್ಮನೆ ಮೀಸೆವೊತ್ತೆನೇ",
            17 to "ವಸಂತ ಮುಖ ತೋರಲಿಲ್ಲ",
            18 to "ಭಗತ್‌ಸಿಂಗ್",
            19 to "ಉದಾತ್ತ ಚಿಂತನೆಗಳು",
            20 to "ವಚನಗಳು",
            21 to "ನಾನು ಪ್ರಾಸ ಬಿಟ್ಟ ಕಥೆ",
            22 to "ಶುಕನಾಸನ ಉಪದೇಶ"
        )

        for ((id, expectedNamePart) in unitTitles) {
            val unit = kannadaSubject.units.find { it.id == id }
            assertNotNull("Unit $id must exist", unit)
            assertTrue(
                "Unit $id title '${unit!!.name}' should contain '$expectedNamePart'",
                unit.name.contains(expectedNamePart)
            )
        }
    }

    @Test
    fun testStd10KannadaQuestionsIntegrity() {
        val questions = Std10KannadaQuestionBank.questions
        assertEquals("Std 10 Kannada question bank should contain exactly 220 questions (10 per unit for 22 units)", 220, questions.size)

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
            assertEquals("stdId must be 10", 10, q.stdId)
            assertEquals("subjectId must be 'kannada'", "kannada", q.subjectId)
            assertTrue("unitId must be between 1 and 22, but was ${q.unitId}", q.unitId in 1..22)
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
    fun testStd10KannadaQuestionsDistributionPerUnit() {
        val questions = Std10KannadaQuestionBank.questions
        for (u in 1..22) {
            val unitQuestions = questions.filter { it.unitId == u }
            assertEquals("Unit $u must have exactly 10 questions", 10, unitQuestions.size)
        }
    }

    @Test
    fun testStd10KannadaIntegratedInStaticData() {
        val filteredStatic = QuizStaticData.staticQuestions.filter {
            it.stdId == 10 && it.subjectId == "kannada"
        }
        assertEquals("QuizStaticData must contain all 220 Std 10 Kannada questions", 220, filteredStatic.size)

        // Verify fallback getter returns authentic questions for Unit 1 (ನಮ್ಮ ಭಾಷೆ)
        val unit1Questions = QuizStaticData.getQuestionsForUnit(10, "kannada", 1, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 1", unit1Questions.isNotEmpty())
        assertTrue(unit1Questions.any { it.questionText.contains("ಮಹಾಪ್ರಾಣಾಕ್ಷರ") || it.questionText.contains("ವರ್ಣಮಾಲೆ") })

        // Verify fallback getter returns authentic questions for Unit 2 (ವ್ಯಾಘ್ರಗೀತೆ)
        val unit2Questions = QuizStaticData.getQuestionsForUnit(10, "kannada", 2, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 2", unit2Questions.isNotEmpty())
        assertTrue(unit2Questions.any { it.questionText.contains("ವಿಭಕ್ತಿ") || it.questionText.contains("ಶಾನುಭೋಗ") })

        // Verify fallback getter returns authentic questions for Unit 11 (ಕೌರವೇಂದ್ರನ ಕೊಂದೆ ನೀನು)
        val unit11Questions = QuizStaticData.getQuestionsForUnit(10, "kannada", 11, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 11", unit11Questions.isNotEmpty())
        assertTrue(unit11Questions.any { it.questionText.contains("ಸಮಾಸ") || it.questionText.contains("ಕರ್ಣ") })

        // Verify fallback getter returns authentic questions for Unit 20 (ವಚನಗಳು)
        val unit20Questions = QuizStaticData.getQuestionsForUnit(10, "kannada", 20, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 20", unit20Questions.isNotEmpty())
        assertTrue(unit20Questions.any { it.questionText.contains("ಅಕ್ಕಮಹಾದೇವಿ") || it.questionText.contains("ಚೆನ್ನಮಲ್ಲಿಕಾರ್ಜುನ") })
    }
}
