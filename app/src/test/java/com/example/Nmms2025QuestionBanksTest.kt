package com.example

import com.example.data.MentalAbilityQuestionBank
import com.example.data.NmmsSatMathsQuestionBank
import com.example.data.NmmsSatScienceQuestionBank
import com.example.data.NmmsSatSocialQuestionBank
import com.example.data.QuizStaticData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class Nmms2025QuestionBanksTest {

    @Test
    fun testNmms2025GmatQuestionsLoaded() {
        val u13 = MentalAbilityQuestionBank.units.find { it.id == 13 }
        assertTrue("Unit 13 should exist in GMAT", u13 != null)
        assertTrue("Unit 13 title should mention NMMS-2025", u13!!.name.contains("NMMS-2025"))

        val gmat2025Questions = MentalAbilityQuestionBank.questions.filter { it.unitId == 13 }
        assertEquals(55, gmat2025Questions.size)

        gmat2025Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("gmat", q.subjectId)
            assertTrue("Question must have [NMMS-2025] tag", q.questionText.contains("[NMMS-2025]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testNmms2025SatMathsQuestionsLoaded() {
        val u4 = NmmsSatMathsQuestionBank.units.find { it.id == 4 }
        assertTrue("Unit 4 should exist in SAT Maths", u4 != null)
        assertTrue("Unit 4 title should mention NMMS-2025", u4!!.name.contains("NMMS-2025"))

        val math2025Questions = NmmsSatMathsQuestionBank.questions.filter { it.unitId == 4 }
        assertEquals(30, math2025Questions.size)

        math2025Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_math", q.subjectId)
            assertTrue("Question must have [NMMS-2025] tag", q.questionText.contains("[NMMS-2025]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testNmms2025SatScienceQuestionsLoaded() {
        val u4 = NmmsSatScienceQuestionBank.units.find { it.id == 4 }
        assertTrue("Unit 4 should exist in SAT Science", u4 != null)
        assertTrue("Unit 4 title should mention NMMS-2025", u4!!.name.contains("NMMS-2025"))

        val sci2025Questions = NmmsSatScienceQuestionBank.questions.filter { it.unitId == 4 }
        assertEquals(30, sci2025Questions.size)

        sci2025Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_science", q.subjectId)
            assertTrue("Question must have [NMMS-2025] tag", q.questionText.contains("[NMMS-2025]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testNmms2025SatSocialQuestionsLoaded() {
        val u4 = NmmsSatSocialQuestionBank.units.find { it.id == 4 }
        assertTrue("Unit 4 should exist in SAT Social", u4 != null)
        assertTrue("Unit 4 title should mention NMMS-2025", u4!!.name.contains("NMMS-2025"))

        val soc2025Questions = NmmsSatSocialQuestionBank.questions.filter { it.unitId == 4 }
        assertEquals(30, soc2025Questions.size)

        soc2025Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_social", q.subjectId)
            assertTrue("Question must have [NMMS-2025] tag", q.questionText.contains("[NMMS-2025]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testAllNmms2025QuestionIdsAreUnique() {
        val allNmmsQuestions = MentalAbilityQuestionBank.questions +
            NmmsSatMathsQuestionBank.questions +
            NmmsSatScienceQuestionBank.questions +
            NmmsSatSocialQuestionBank.questions

        val ids = allNmmsQuestions.map { it.id }
        val duplicates = ids.groupingBy { it }.eachCount().filter { it.value > 1 }
        assertTrue("All NMMS question IDs must be unique across all banks: $duplicates", duplicates.isEmpty())
    }

    @Test
    fun testQuizStaticDataRetrievesNmms2025Units() {
        val gmatQuestions = QuizStaticData.getQuestionsForUnit(12, "gmat", 13, emptyList())
        assertTrue("GMAT Unit 13 should return questions via QuizStaticData", gmatQuestions.isNotEmpty())

        val mathQuestions = QuizStaticData.getQuestionsForUnit(12, "sat_math", 4, emptyList())
        assertTrue("SAT Math Unit 4 should return questions via QuizStaticData", mathQuestions.isNotEmpty())

        val sciQuestions = QuizStaticData.getQuestionsForUnit(12, "sat_science", 4, emptyList())
        assertTrue("SAT Science Unit 4 should return questions via QuizStaticData", sciQuestions.isNotEmpty())

        val socQuestions = QuizStaticData.getQuestionsForUnit(12, "sat_social", 4, emptyList())
        assertTrue("SAT Social Unit 4 should return questions via QuizStaticData", socQuestions.isNotEmpty())
    }

    @Test
    fun testNmms2024GmatQuestionsLoaded() {
        val u14 = MentalAbilityQuestionBank.units.find { it.id == 14 }
        assertTrue("Unit 14 should exist in GMAT", u14 != null)
        assertTrue("Unit 14 title should mention NMMS-2024", u14!!.name.contains("NMMS-2024"))

        val gmat2024Questions = MentalAbilityQuestionBank.questions.filter { it.unitId == 14 }
        assertEquals(35, gmat2024Questions.size)

        gmat2024Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("gmat", q.subjectId)
            assertTrue("Question must have [NMMS-2024] tag: ${q.id}", q.questionText.contains("[NMMS-2024]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testNmms2024SatMathsQuestionsLoaded() {
        val u5 = NmmsSatMathsQuestionBank.units.find { it.id == 5 }
        assertTrue("Unit 5 should exist in SAT Maths", u5 != null)
        assertTrue("Unit 5 title should mention NMMS-2024", u5!!.name.contains("NMMS-2024"))

        val math2024Questions = NmmsSatMathsQuestionBank.questions.filter { it.unitId == 5 }
        assertEquals(35, math2024Questions.size)

        math2024Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_math", q.subjectId)
            assertTrue("Question must have [NMMS-2024] tag: ${q.id}", q.questionText.contains("[NMMS-2024]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testNmms2024SatScienceQuestionsLoaded() {
        val u5 = NmmsSatScienceQuestionBank.units.find { it.id == 5 }
        assertTrue("Unit 5 should exist in SAT Science", u5 != null)
        assertTrue("Unit 5 title should mention NMMS-2024", u5!!.name.contains("NMMS-2024"))

        val sci2024Questions = NmmsSatScienceQuestionBank.questions.filter { it.unitId == 5 }
        assertEquals(35, sci2024Questions.size)

        sci2024Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_science", q.subjectId)
            assertTrue("Question must have [NMMS-2024] tag: ${q.id}", q.questionText.contains("[NMMS-2024]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testNmms2024SatSocialQuestionsLoaded() {
        val u5 = NmmsSatSocialQuestionBank.units.find { it.id == 5 }
        assertTrue("Unit 5 should exist in SAT Social", u5 != null)
        assertTrue("Unit 5 title should mention NMMS-2024", u5!!.name.contains("NMMS-2024"))

        val soc2024Questions = NmmsSatSocialQuestionBank.questions.filter { it.unitId == 5 }
        assertEquals(35, soc2024Questions.size)

        soc2024Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_social", q.subjectId)
            assertTrue("Question must have [NMMS-2024] tag: ${q.id}", q.questionText.contains("[NMMS-2024]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testQuizStaticDataRetrievesNmms2024Units() {
        val gmatQuestions = QuizStaticData.getQuestionsForUnit(12, "gmat", 14, emptyList())
        assertTrue("GMAT Unit 14 should return questions via QuizStaticData", gmatQuestions.isNotEmpty())

        val mathQuestions = QuizStaticData.getQuestionsForUnit(12, "sat_math", 5, emptyList())
        assertTrue("SAT Math Unit 5 should return questions via QuizStaticData", mathQuestions.isNotEmpty())

        val sciQuestions = QuizStaticData.getQuestionsForUnit(12, "sat_science", 5, emptyList())
        assertTrue("SAT Science Unit 5 should return questions via QuizStaticData", sciQuestions.isNotEmpty())

        val socQuestions = QuizStaticData.getQuestionsForUnit(12, "sat_social", 5, emptyList())
        assertTrue("SAT Social Unit 5 should return questions via QuizStaticData", socQuestions.isNotEmpty())
    }

    @Test
    fun testNmms2023GmatQuestionsLoaded() {
        val u15 = MentalAbilityQuestionBank.units.find { it.id == 15 }
        assertTrue("Unit 15 should exist in GMAT", u15 != null)
        assertTrue("Unit 15 title should mention NMMS-2023", u15!!.name.contains("NMMS-2023"))

        val gmat2023Questions = MentalAbilityQuestionBank.questions.filter { it.unitId == 15 }
        assertEquals(35, gmat2023Questions.size)

        gmat2023Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("gmat", q.subjectId)
            assertTrue("Question must have [NMMS-2023] tag: ${q.id}", q.questionText.contains("[NMMS-2023]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testNmms2023SatMathsQuestionsLoaded() {
        val u6 = NmmsSatMathsQuestionBank.units.find { it.id == 6 }
        assertTrue("Unit 6 should exist in SAT Maths", u6 != null)
        assertTrue("Unit 6 title should mention NMMS-2023", u6!!.name.contains("NMMS-2023"))

        val math2023Questions = NmmsSatMathsQuestionBank.questions.filter { it.unitId == 6 }
        assertEquals(20, math2023Questions.size)

        math2023Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_math", q.subjectId)
            assertTrue("Question must have [NMMS-2023] tag: ${q.id}", q.questionText.contains("[NMMS-2023]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testNmms2023SatScienceQuestionsLoaded() {
        val u6 = NmmsSatScienceQuestionBank.units.find { it.id == 6 }
        assertTrue("Unit 6 should exist in SAT Science", u6 != null)
        assertTrue("Unit 6 title should mention NMMS-2023", u6!!.name.contains("NMMS-2023"))

        val sci2023Questions = NmmsSatScienceQuestionBank.questions.filter { it.unitId == 6 }
        assertEquals(25, sci2023Questions.size)

        sci2023Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_science", q.subjectId)
            assertTrue("Question must have [NMMS-2023] tag: ${q.id}", q.questionText.contains("[NMMS-2023]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testNmms2023SatSocialQuestionsLoaded() {
        val u6 = NmmsSatSocialQuestionBank.units.find { it.id == 6 }
        assertTrue("Unit 6 should exist in SAT Social", u6 != null)
        assertTrue("Unit 6 title should mention NMMS-2023", u6!!.name.contains("NMMS-2023"))

        val soc2023Questions = NmmsSatSocialQuestionBank.questions.filter { it.unitId == 6 }
        assertEquals(25, soc2023Questions.size)

        soc2023Questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertEquals("sat_social", q.subjectId)
            assertTrue("Question must have [NMMS-2023] tag: ${q.id}", q.questionText.contains("[NMMS-2023]"))
            assertEquals("Each question must have 4 options: ${q.id}", 4, q.options.size)
            assertTrue("Correct answer '${q.correctAnswer}' must be in options for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse("Question text must not be blank", q.questionText.isBlank())
            assertFalse("Explanation must not be blank", q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testQuizStaticDataRetrievesNmms2023Units() {
        val gmatQuestions = QuizStaticData.getQuestionsForUnit(12, "gmat", 15, emptyList())
        assertTrue("GMAT Unit 15 should return questions via QuizStaticData", gmatQuestions.isNotEmpty())

        val mathQuestions = QuizStaticData.getQuestionsForUnit(12, "sat_math", 6, emptyList())
        assertTrue("SAT Math Unit 6 should return questions via QuizStaticData", mathQuestions.isNotEmpty())

        val sciQuestions = QuizStaticData.getQuestionsForUnit(12, "sat_science", 6, emptyList())
        assertTrue("SAT Science Unit 6 should return questions via QuizStaticData", sciQuestions.isNotEmpty())

        val socQuestions = QuizStaticData.getQuestionsForUnit(12, "sat_social", 6, emptyList())
        assertTrue("SAT Social Unit 6 should return questions via QuizStaticData", socQuestions.isNotEmpty())
    }
}
