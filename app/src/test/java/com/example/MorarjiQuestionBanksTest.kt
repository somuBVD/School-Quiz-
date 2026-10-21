package com.example

import com.example.data.MorarjiEnglishQuestionBank
import com.example.data.MorarjiGKQuestionBank
import com.example.data.MorarjiKannadaQuestionBank
import com.example.data.MorarjiMathsQuestionBank
import com.example.data.MorarjiMentalAbilityQuestionBank
import com.example.data.MentalAbilityQuestionBank
import com.example.data.MentalAbilityData
import com.example.data.QuizStaticData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MorarjiQuestionBanksTest {

    @Test
    fun testMorarjiStandardConfigured() {
        val morarji = QuizStaticData.morarjiStandard
        assertEquals(11, morarji.std)
        assertEquals("Morarji", morarji.name)
        
        val subjectIds = morarji.subjects.map { it.id }
        assertTrue(subjectIds.contains("kannada"))
        assertTrue(subjectIds.contains("english"))
        assertTrue(subjectIds.contains("math"))
        assertTrue(subjectIds.contains("general_science"))
        assertTrue(subjectIds.contains("gk"))
        assertTrue(subjectIds.contains("mental_ability"))

        val evsSubject = morarji.subjects.find { it.id == "general_science" }
        assertEquals("Environmental Studies (ಪರಿಸರ ಅಧ್ಯಯನ)", evsSubject?.title)

        val maSubject = morarji.subjects.find { it.id == "mental_ability" }
        assertEquals("Mental Ability (ಬೌದ್ಧಿಕ ಸಾಮರ್ಥ್ಯ)", maSubject?.title)
    }

    @Test
    fun testMorarjiKannadaQuestionsLoaded() {
        assertTrue(MorarjiKannadaQuestionBank.questions.isNotEmpty())
        assertTrue(MorarjiKannadaQuestionBank.units.isNotEmpty())
        
        MorarjiKannadaQuestionBank.questions.forEach { q ->
            assertEquals(11, q.stdId)
            assertEquals("kannada", q.subjectId)
            assertEquals(4, q.options.size)
            assertTrue("Option should contain answer for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse(q.questionText.isBlank())
        }
    }

    @Test
    fun testMorarjiEnglishQuestionsLoaded() {
        assertTrue(MorarjiEnglishQuestionBank.questions.isNotEmpty())
        assertTrue(MorarjiEnglishQuestionBank.units.isNotEmpty())
        
        MorarjiEnglishQuestionBank.questions.forEach { q ->
            assertEquals(11, q.stdId)
            assertEquals("english", q.subjectId)
            assertEquals(4, q.options.size)
            assertTrue("Option should contain answer for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse(q.questionText.isBlank())
        }
    }

    @Test
    fun testMorarjiMathsQuestionsLoaded() {
        assertTrue(MorarjiMathsQuestionBank.questions.isNotEmpty())
        assertTrue(MorarjiMathsQuestionBank.units.isNotEmpty())
        
        MorarjiMathsQuestionBank.questions.forEach { q ->
            assertEquals(11, q.stdId)
            assertEquals("math", q.subjectId)
            assertEquals(4, q.options.size)
            assertTrue("Option should contain answer for ${q.id}", q.options.contains(q.correctAnswer))
            assertFalse(q.questionText.isBlank())
        }
    }

    @Test
    fun testMorarjiGKQuestionsLoaded() {
        assertEquals(140, MorarjiGKQuestionBank.questions.size)
        assertEquals(5, MorarjiGKQuestionBank.units.size)
        
        MorarjiGKQuestionBank.questions.forEach { q ->
            assertEquals(11, q.stdId)
            assertEquals("gk", q.subjectId)
            assertEquals(4, q.options.size)
            assertTrue("Option should contain answer for ${q.id}: ${q.correctAnswer} in ${q.options}", q.options.contains(q.correctAnswer))
            assertFalse(q.questionText.isBlank())
        }
    }

    @Test
    fun testMorarjiQuestionsRetrievalViaQuizStaticData() {
        val mathQ1 = QuizStaticData.getQuestionsForUnit(11, "math", 1, emptyList())
        assertTrue("Math Unit 1 should return questions", mathQ1.isNotEmpty())

        val kanQ1 = QuizStaticData.getQuestionsForUnit(11, "kannada", 1, emptyList())
        assertTrue("Kannada Unit 1 should return questions", kanQ1.isNotEmpty())

        val engQ1 = QuizStaticData.getQuestionsForUnit(11, "english", 1, emptyList())
        assertTrue("English Unit 1 should return questions", engQ1.isNotEmpty())

        val gkQ1 = QuizStaticData.getQuestionsForUnit(11, "gk", 1, emptyList())
        assertTrue("GK Unit 1 should return questions", gkQ1.isNotEmpty())

        val gkQ5 = QuizStaticData.getQuestionsForUnit(11, "gk", 5, emptyList())
        assertTrue("GK Unit 5 should return questions", gkQ5.isNotEmpty())

        val maQ1 = QuizStaticData.getQuestionsForUnit(11, "mental_ability", 1, emptyList())
        assertTrue("Mental Ability Unit 1 should return questions", maQ1.isNotEmpty())
    }

    @Test
    fun testMorarjiMentalAbilityQuestionsLoaded() {
        assertTrue(MorarjiMentalAbilityQuestionBank.questions.isNotEmpty())
        assertTrue(MorarjiMentalAbilityQuestionBank.units.isNotEmpty())

        MorarjiMentalAbilityQuestionBank.questions.forEach { q ->
            assertEquals(11, q.stdId)
            assertEquals("mental_ability", q.subjectId)
            assertEquals(4, q.options.size)
            assertTrue("Option should contain answer for ${q.id}: ${q.correctAnswer} in ${q.options}", q.options.contains(q.correctAnswer))
            assertFalse(q.questionText.isBlank())
        }
    }

    @Test
    fun testMentalAbilityQuestionBankLoaded() {
        assertTrue(MentalAbilityQuestionBank.questions.isNotEmpty())
        assertTrue(MentalAbilityQuestionBank.units.isNotEmpty())

        MentalAbilityQuestionBank.questions.forEach { q ->
            assertEquals(12, q.stdId)
            assertTrue(q.subjectId == "mental_ability" || q.subjectId == "gmat")
            assertEquals(4, q.options.size)
            assertTrue("Option should contain answer for ${q.id}: ${q.correctAnswer} in ${q.options}", q.options.contains(q.correctAnswer))
            assertFalse(q.questionText.isBlank())
            assertFalse(q.explanation.isNullOrBlank())
        }
    }

    @Test
    fun testMentalAbilityDataLoaded() {
        assertEquals(10, MentalAbilityData.questions.size)
        MentalAbilityData.questions.forEach { q ->
            assertFalse(q.text.isBlank())
            assertTrue(q.options.size >= 4)
            assertTrue("Correct answer index should be within bounds: ${q.correctIndex}", q.correctIndex in q.options.indices)
        }
    }

    @Test
    fun testMorarjiMathsAllUnitsLoaded() {
        assertEquals(7, MorarjiMathsQuestionBank.units.size)
        // Verify every unit from 1 to 7 has questions
        (1..7).forEach { unitId ->
            val unitQuestions = MorarjiMathsQuestionBank.questions.filter { it.unitId == unitId }
            assertTrue("Math unit $unitId should have questions", unitQuestions.isNotEmpty())
        }
    }

    @Test
    fun testMorarjiQuestionIdsUnique() {
        val allMorarjiQuestions = MorarjiKannadaQuestionBank.questions +
            MorarjiEnglishQuestionBank.questions +
            MorarjiMathsQuestionBank.questions +
            MorarjiGKQuestionBank.questions +
            MorarjiMentalAbilityQuestionBank.questions

        val ids = allMorarjiQuestions.map { it.id }
        val duplicates = ids.groupingBy { it }.eachCount().filter { it.value > 1 }
        assertTrue("All Morarji question IDs must be unique: $duplicates", duplicates.isEmpty())
    }
}

