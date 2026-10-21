package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std10ScienceQuestionBankTest {

    @Test
    fun testStd10ScienceUnitsStructure() {
        val std10 = QuizStaticData.standardsList.find { it.std == 10 }
        assertNotNull("Standard 10 must be present in standardsList", std10)

        val scienceSubject = std10!!.subjects.find { it.id == "science" }
        assertNotNull("Science subject must be present in Std 10", scienceSubject)

        // All 16 units must be present
        assertEquals("Standard 10 Science must contain 16 units", 16, scienceSubject!!.units.size)

        // Validate unit titles
        val unitTitles = listOf(
            1 to "ಅಧ್ಯಾಯ 1: ರಾಸಾಯನಿಕ ಕ್ರಿಯೆಗಳು ಮತ್ತು ಸಮೀಕರಣಗಳು",
            2 to "ಅಧ್ಯಾಯ 2: ಆಮ್ಲಗಳು, ಪ್ರತ್ಯಾಮ್ಲಗಳು ಮತ್ತು ಲವಣಗಳು",
            3 to "ಅಧ್ಯಾಯ 3: ಲೋಹಗಳು ಮತ್ತು ಅಲೋಹಗಳು",
            4 to "ಅಧ್ಯಾಯ 4: ಕಾರ್ಬನ್ ಮತ್ತು ಅದರ ಸಂಯುಕ್ತಗಳು",
            5 to "ಅಧ್ಯಾಯ 5: ಧಾತುಗಳ ಆವರ್ತನೀಯ ವರ್ಗೀಕರಣ",
            6 to "ಅಧ್ಯಾಯ 6: ಜೀವಕ್ರಿಯೆಗಳು",
            7 to "ಅಧ್ಯಾಯ 7: ನಿಯಂತ್ರಣ ಮತ್ತು ಸಹಭಾಗಿತ್ವ",
            8 to "ಅಧ್ಯಾಯ 8: ಜೀವಿಗಳು ಹೇಗೆ ಸಂತಾನೋತ್ಪತ್ತಿ ನಡೆಸುತ್ತವೆ?",
            9 to "ಅಧ್ಯಾಯ 9: ಅನುವಂಶೀಯತೆ ಮತ್ತು ಜೀವ ವಿಕಾಸ",
            10 to "ಅಧ್ಯಾಯ 10: ಬೆಳಕು - ಪ್ರತಿಫಲನ ಮತ್ತು ವಕ್ರೀಭವನ",
            11 to "ಅಧ್ಯಾಯ 11: ಮಾನವನ ಕಣ್ಣು ಮತ್ತು ವರ್ಣಮಯ ಜಗತ್ತು",
            12 to "ಅಧ್ಯಾಯ 12: ವಿದ್ಯುಚ್ಛಕ್ತಿ",
            13 to "ಅಧ್ಯಾಯ 13: ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ಕಾಂತೀಯ ಪರಿಣಾಮಗಳು",
            14 to "ಅಧ್ಯಾಯ 14: ಶಕ್ತಿಯ ಆಕರಗಳು",
            15 to "ಅಧ್ಯಾಯ 15: ನಮ್ಮ ಪರಿಸರ",
            16 to "ಅಧ್ಯಾಯ 16: ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲಗಳ ಸುಸ್ಥಿರ ನಿರ್ವಹಣೆ"
        )

        for ((id, expectedNamePart) in unitTitles) {
            val unit = scienceSubject.units.find { it.id == id }
            assertNotNull("Unit $id must exist", unit)
            assertTrue(
                "Unit $id title '${unit!!.name}' should contain '$expectedNamePart'",
                unit.name.contains(expectedNamePart)
            )
        }
    }

    @Test
    fun testStd10ScienceQuestionsIntegrity() {
        val questions = Std10ScienceQuestionBank.questions
        assertTrue(
            "Total questions in 10th Science should be at least 240 (16 units x 15 questions)",
            questions.size >= 240
        )

        val seenIds = mutableSetOf<String>()
        val seenTexts = mutableSetOf<String>()

        for (q in questions) {
            // Check ID uniqueness
            assertFalse("Question ID '${q.id}' must be unique", seenIds.contains(q.id))
            seenIds.add(q.id)

            // Check duplicate question text
            assertFalse("Question text should not be duplicated: '${q.questionText}'", seenTexts.contains(q.questionText))
            seenTexts.add(q.questionText)

            // Fields validation
            assertEquals("stdId must be 10", 10, q.stdId)
            assertEquals("subjectId must be science", "science", q.subjectId)
            assertTrue("unitId must be between 1 and 16, got ${q.unitId}", q.unitId in 1..16)
            assertTrue("questionText must not be empty", q.questionText.isNotBlank())
            assertEquals("Question '${q.id}' must have exactly 4 options", 4, q.options.size)

            // Check options uniqueness within question
            val uniqueOptions = q.options.distinct()
            assertEquals("Options in question '${q.id}' must be distinct", 4, uniqueOptions.size)

            // Check correctAnswer in options
            assertTrue(
                "correctAnswer '${q.correctAnswer}' must match one of the options in '${q.id}'",
                q.options.contains(q.correctAnswer)
            )

            // Explanation validation
            assertTrue("explanation must not be empty for '${q.id}'", q.explanation.isNotBlank())
        }
    }

    @Test
    fun testEveryUnitHasQuestions() {
        for (unitId in 1..16) {
            val questions = Std10ScienceQuestionBank.questions.filter { it.unitId == unitId }
            assertTrue(
                "Unit $unitId must have at least 15 questions, found ${questions.size}",
                questions.size >= 15
            )

            // Verify retrieval via QuizStaticData
            val fetched = QuizStaticData.getQuestionsForUnit(10, "science", unitId, emptyList())
            assertTrue(
                "QuizStaticData should retrieve questions for Std 10 Science Unit $unitId",
                fetched.isNotEmpty()
            )
            assertEquals(
                "Retrieved questions should match unit $unitId",
                unitId,
                fetched.first().unitId
            )
        }
    }
}
