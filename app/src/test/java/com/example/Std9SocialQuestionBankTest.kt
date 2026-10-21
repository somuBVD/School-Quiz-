package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std9SocialQuestionBankTest {

    @Test
    fun testStd9SocialUnitsStructure() {
        val std9 = QuizStaticData.standardsList.find { it.std == 9 }
        assertNotNull("Standard 9 must be present in standardsList", std9)

        val socialSubject = std9!!.subjects.find { it.id == "social" }
        assertNotNull("Social Science subject must be present in Std 9", socialSubject)

        // All 33 units must be present
        assertEquals("Standard 9 Social Science must contain 33 units", 33, socialSubject!!.units.size)

        // Validate all 33 unit titles
        val unitTitles = listOf(
            1 to "ಪಾಶ್ಚಾತ್ಯ ಧರ್ಮಗಳು",
            2 to "6 ರಿಂದ 14 ನೇ ಶತಮಾನದ ಭಾರತ",
            3 to "ಭಾರತದ ಮತ ಪ್ರವರ್ತಕರು",
            4 to "ವಿಜಯನಗರ ಸಾಮ್ರಾಜ್ಯ ಮತ್ತು ಬಹಮನಿ ರಾಜ್ಯ",
            5 to "ನಮ್ಮ ಸಂವಿಧಾನ",
            6 to "ಕೇಂದ್ರ ಸರ್ಕಾರ",
            7 to "ರಾಜ್ಯ ಸರ್ಕಾರ",
            8 to "ನ್ಯಾಯಾಂಗ",
            9 to "ಕುಟುಂಬ",
            10 to "ನಮ್ಮ ರಾಜ್ಯ–ಕರ್ನಾಟಕ-ಪ್ರಾಕೃತಿಕ ವಿಭಾಗಗಳು",
            11 to "ಕರ್ನಾಟಕದ ಪ್ರಾಕೃತಿಕ ವೈವಿಧ್ಯ",
            12 to "ಕರ್ನಾಟಕದ ಜಲಸಂಪನ್ಮೂಲಗಳು",
            13 to "ಕರ್ನಾಟಕದ ಭೂ ಸಂಪತ್ತು",
            14 to "ಆರ್ಥಿಕ ರಚನೆ",
            15 to "ಭಾರತೀಯ ಅರ್ಥವ್ಯವಸ್ಥೆಯ ವಲಯಗಳು",
            16 to "ವ್ಯವಹಾರ ನಿರ್ವಹಣೆ",
            17 to "ಅಹೋಮ್ ರಾಜಮನೆತನ, ಮೊಘಲರು ಮತ್ತು ಮರಾಠರು",
            18 to "ಭಕ್ತಿ ಪಂಥ",
            19 to "ಯುರೋಪ್: ಮಧ್ಯಯುಗ ಹಾಗೂ ಆಧುನಿಕ ಯುಗ",
            20 to "ಕ್ರಾಂತಿ - ರಾಷ್ಟ್ರ ಪ್ರಭುತ್ವಗಳ ಉದಯ",
            21 to "ಚುನಾವಣಾ ವ್ಯವಸ್ಥೆ",
            22 to "ದೇಶದ ರಕ್ಷಣೆ",
            23 to "ರಾಷ್ಟ್ರೀಯ ಭಾವೈಕ್ಯತೆ",
            24 to "ಅಂತರರಾಷ್ಟ್ರೀಯ ಸಂಬಂಧಗಳ ಅಧ್ಯಯನ-ಒಂದು ಪರಿಚಯ",
            25 to "ಸಾಮಾಜಿಕರಣ ಹಾಗೂ ಕುಟುಂಬದ ಸಂಬಂಧಗಳು",
            26 to "ಸಮುದಾಯ",
            27 to "ಕರ್ನಾಟಕದ ಖನಿಜ ಸಂಪನ್ಮೂಲ",
            28 to "ಕರ್ನಾಟಕದಲ್ಲಿ ಸಾರಿಗೆ ವ್ಯವಸ್ಥೆ",
            29 to "ಕರ್ನಾಟಕದ ಕೈಗಾರಿಕೆಗಳು",
            30 to "ಕರ್ನಾಟಕದ ಪ್ರಮುಖ ಪ್ರವಾಸಿ ಕೇಂದ್ರಗಳು",
            31 to "ಹಣ ಮತ್ತು ಸಾಲ",
            32 to "ಶ್ರಮ ಮತ್ತು ಉದ್ಯೋಗ",
            33 to "ಮಾರುಕಟ್ಟೆ ನಿರ್ವಹಣೆ"
        )

        for ((id, expectedNamePart) in unitTitles) {
            val unit = socialSubject.units.find { it.id == id }
            assertNotNull("Unit $id must exist", unit)
            assertTrue(
                "Unit $id title '${unit!!.name}' should contain '$expectedNamePart'",
                unit.name.contains(expectedNamePart)
            )
        }
    }

    @Test
    fun testStd9SocialQuestionsIntegrity() {
        val questions = Std9SocialQuestionBank.questions
        assertEquals("Std 9 Social question bank should contain exactly 363 questions (11 per unit for 33 units)", 363, questions.size)

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
            assertEquals("subjectId must be 'social'", "social", q.subjectId)
            assertTrue("unitId must be between 1 and 33, but was ${q.unitId}", q.unitId in 1..33)
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
    fun testStd9SocialQuestionsDistributionPerUnit() {
        val questions = Std9SocialQuestionBank.questions
        for (u in 1..33) {
            val unitQuestions = questions.filter { it.unitId == u }
            assertEquals("Unit $u must have exactly 11 questions", 11, unitQuestions.size)
        }
    }

    @Test
    fun testStd9SocialIntegratedInStaticData() {
        val filteredStatic = QuizStaticData.staticQuestions.filter {
            it.stdId == 9 && it.subjectId == "social"
        }
        assertEquals("QuizStaticData must contain all 363 Std 9 Social questions", 363, filteredStatic.size)

        // Verify fallback getter returns authentic questions for unit 1 (Western religions)
        val unit1Questions = QuizStaticData.getQuestionsForUnit(9, "social", 1, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 1", unit1Questions.isNotEmpty())
        assertTrue(unit1Questions.any { it.questionText.contains("ಯೇಸು ಕ್ರಿಸ್ತ") || it.questionText.contains("ಇಸ್ಲಾಂ") || it.questionText.contains("ಬೈಬಲ್") })

        // Verify fallback getter returns authentic questions for unit 5 (Our Constitution)
        val unit5Questions = QuizStaticData.getQuestionsForUnit(9, "social", 5, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 5", unit5Questions.isNotEmpty())
        assertTrue(unit5Questions.any { it.questionText.contains("ಸಂವಿಧಾನ") || it.questionText.contains("ಅಂಬೇಡ್ಕರ್") })

        // Verify fallback getter returns authentic questions for unit 10 (Karnataka Physiographic Divisions)
        val unit10Questions = QuizStaticData.getQuestionsForUnit(9, "social", 10, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 10", unit10Questions.isNotEmpty())
        assertTrue(unit10Questions.any { it.questionText.contains("ಕರ್ನಾಟಕ") || it.questionText.contains("ಕರಾವಳಿ") || it.questionText.contains("ಮಲೆನಾಡು") })

        // Verify fallback getter returns authentic questions for unit 33 (Marketing Management)
        val unit33Questions = QuizStaticData.getQuestionsForUnit(9, "social", 33, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 33", unit33Questions.isNotEmpty())
        assertTrue(unit33Questions.any { it.questionText.contains("ಮಾರುಕಟ್ಟೆ") || it.questionText.contains("ಗ್ರಾಹಕ") })
    }
}
