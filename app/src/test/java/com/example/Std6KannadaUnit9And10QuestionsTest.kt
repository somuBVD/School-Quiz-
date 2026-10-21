package com.example

import com.example.data.QuizStaticData
import com.example.data.Std6KannadaQuestionBank
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Std6KannadaUnit9And10QuestionsTest {

    @Test
    fun testStd6KannadaUnit9QuestionCountAndMetadata() {
        val unit9 = Std6KannadaQuestionBank.units.find { it.id == 9 }
        assertTrue("Unit 9 should exist", unit9 != null)
        assertEquals(2, unit9?.totalQuestions)
        assertEquals("ಪದ್ಯಪಾಠ–9: ನೀ ಹೋದ ಮರುದಿನ", unit9?.name)

        val unit9Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 9 }
        assertEquals(2, unit9Questions.size)
        assertEquals("ಸಂಭ್ರಮವು", unit9Questions[0].correctAnswer)
        assertEquals("1943", unit9Questions[1].correctAnswer)
        assertTrue(unit9Questions[0].options.contains(unit9Questions[0].correctAnswer))
        assertTrue(unit9Questions[1].options.contains(unit9Questions[1].correctAnswer))
    }

    @Test
    fun testStd6KannadaUnit10QuestionCountAndMetadata() {
        val unit10 = Std6KannadaQuestionBank.units.find { it.id == 10 }
        assertTrue("Unit 10 should exist", unit10 != null)
        assertEquals(7, unit10?.totalQuestions)
        assertEquals("ಪದ್ಯಪಾಠ–10: ಗಂಗವ್ವತಾಯಿ", unit10?.name)

        val unit10Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 10 }
        assertEquals(7, unit10Questions.size)
        assertEquals("ವಾಯು ಮಾಲಿನ್ಯ", unit10Questions[0].correctAnswer)
        assertEquals("ಜಲ ಮಾಲಿನ್ಯ", unit10Questions[1].correctAnswer)
        assertEquals("ಗಂಗವ್ವ", unit10Questions[2].correctAnswer)
        assertEquals("ನೀರವ್ವ", unit10Questions[3].correctAnswer)
        assertEquals("ತೊಳೆಯವ್ವ", unit10Questions[4].correctAnswer)
        assertEquals("ಮಳಿಯಾಗಿ", unit10Questions[5].correctAnswer)
        assertEquals("ಹಸುರಾಗಿ", unit10Questions[6].correctAnswer)

        unit10Questions.forEach { q ->
            assertTrue(q.options.contains(q.correctAnswer))
        }
    }

    @Test
    fun testQuizStaticDataRetrievalForUnit9And10() {
        val q9 = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 9,
            custom = emptyList()
        )
        assertEquals(2, q9.size)
        assertEquals("ಸಂಭ್ರಮವು", q9[0].correctAnswer)

        val q10 = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 10,
            custom = emptyList()
        )
        assertEquals(7, q10.size)
        assertEquals("ವಾಯು ಮಾಲಿನ್ಯ", q10[0].correctAnswer)
    }
}
