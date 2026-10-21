package com.example

import com.example.data.NmmsSatSocialQuestionBank
import com.example.data.QuizStaticData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class NmmsSatSocialQuestionBankTest {

    @Test
    fun testNmmsSatSocialUnitsStructure() {
        val units = NmmsSatSocialQuestionBank.units
        assertEquals(6, units.size)

        assertEquals(1, units[0].id)
        assertTrue(units[0].name.contains("ಇತಿಹಾಸ"))
        assertEquals(45, units[0].totalQuestions)

        assertEquals(2, units[1].id)
        assertTrue(units[1].name.contains("ರಾಜಕೀಯ ವಿಜ್ಞಾನ") && units[1].name.contains("ವ್ಯಾಪಾರ"))
        assertEquals(49, units[1].totalQuestions)

        assertEquals(3, units[2].id)
        assertTrue(units[2].name.contains("ಭೂಗೋಳ ವಿಜ್ಞಾನ") && units[2].name.contains("ಅರ್ಥಶಾಸ್ತ್ರ"))
        assertEquals(47, units[2].totalQuestions)

        assertEquals(4, units[3].id)
        assertTrue(units[3].name.contains("NMMS-2025"))
        assertEquals(30, units[3].totalQuestions)

        assertEquals(5, units[4].id)
        assertTrue(units[4].name.contains("NMMS-2024"))
        assertEquals(35, units[4].totalQuestions)

        assertEquals(6, units[5].id)
        assertTrue(units[5].name.contains("NMMS-2023"))
        assertEquals(25, units[5].totalQuestions)
    }

    @Test
    fun testAllQuestionsAreValidAndVerified() {
        val questions = NmmsSatSocialQuestionBank.questions
        assertEquals(231, questions.size)

        val u1Questions = questions.filter { it.unitId == 1 }
        val u2Questions = questions.filter { it.unitId == 2 }
        val u3Questions = questions.filter { it.unitId == 3 }
        val u4Questions = questions.filter { it.unitId == 4 }
        val u5Questions = questions.filter { it.unitId == 5 }
        val u6Questions = questions.filter { it.unitId == 6 }

        assertEquals(45, u1Questions.size)
        assertEquals(49, u2Questions.size)
        assertEquals(47, u3Questions.size)
        assertEquals(30, u4Questions.size)
        assertEquals(35, u5Questions.size)
        assertEquals(25, u6Questions.size)

        // Verify question integrity
        questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_social", q.subjectId)
            assertTrue("Unit ID must be 1..6", q.unitId in 1..6)
            assertTrue("Question text must not be empty", q.questionText.isNotBlank())
            assertEquals("Each question must have 4 options", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options", q.options.contains(q.correctAnswer))
            assertTrue("Explanation must not be empty", q.explanation.isNotBlank())
            assertFalse("No picture-based questions should be present", q.questionText.contains("ಚಿತ್ರದಲ್ಲಿ") || q.questionText.contains("ನಕ್ಷೆಯಲ್ಲಿ"))
        }

        // Verify unique question IDs
        val ids = questions.map { it.id }
        assertEquals(ids.size, ids.toSet().size)
    }

    @Test
    fun testQuizStaticDataIntegration() {
        val nmms = QuizStaticData.standardsList.find { it.std == 12 }
        assertNotNull(nmms)

        val satSocial = nmms!!.subjects.find { it.id == "sat_social" }
        assertNotNull(satSocial)
        assertEquals(6, satSocial!!.units.size)

        // Query units via getQuestionsForUnit
        val u1FromRepo = QuizStaticData.getQuestionsForUnit(12, "sat_social", 1, emptyList())
        assertEquals(45, u1FromRepo.size)

        val u2FromRepo = QuizStaticData.getQuestionsForUnit(12, "sat_social", 2, emptyList())
        assertEquals(49, u2FromRepo.size)

        val u3FromRepo = QuizStaticData.getQuestionsForUnit(12, "sat_social", 3, emptyList())
        assertEquals(47, u3FromRepo.size)

        val u4FromRepo = QuizStaticData.getQuestionsForUnit(12, "sat_social", 4, emptyList())
        assertEquals(30, u4FromRepo.size)
    }
}
