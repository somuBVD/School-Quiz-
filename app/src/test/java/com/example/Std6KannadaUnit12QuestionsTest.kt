package com.example

import com.example.data.QuizStaticData
import com.example.data.Std6KannadaQuestionBank
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Std6KannadaUnit12QuestionsTest {

    @Test
    fun testStd6KannadaUnit12QuestionCountAndMetadata() {
        val unit12 = Std6KannadaQuestionBank.units.find { it.id == 12 }
        assertTrue("Unit 12 should exist", unit12 != null)
        assertEquals(4, unit12?.totalQuestions)
        assertEquals("ಪದ್ಯಪಾಠ–12: ಕಿತ್ತೂರು ಕೇಸರಿ", unit12?.name)

        val unit12Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 12 }
        assertEquals(4, unit12Questions.size)
        assertEquals("ಬೇಸಿಗೆ ಕಾಲ", unit12Questions[0].correctAnswer)
        assertEquals("ಪ. ಗು. ಸಿದ್ಧಾಪುರ", unit12Questions[1].correctAnswer)
        assertEquals("ಸಾಮಾನ್ಯವಾಕ್ಯ", unit12Questions[2].correctAnswer)
        assertEquals("ಹೆಣ್ಣಾಗಿ", unit12Questions[3].correctAnswer)

        unit12Questions.forEach { q ->
            assertTrue("Option list should contain correct answer", q.options.contains(q.correctAnswer))
        }
    }

    @Test
    fun testQuizStaticDataRetrievalForUnit12() {
        val q12 = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 12,
            custom = emptyList()
        )
        assertEquals(4, q12.size)
        assertEquals("ಬೇಸಿಗೆ ಕಾಲ", q12[0].correctAnswer)
        assertEquals("ಪ. ಗು. ಸಿದ್ಧಾಪುರ", q12[1].correctAnswer)
        assertEquals("ಸಾಮಾನ್ಯವಾಕ್ಯ", q12[2].correctAnswer)
        assertEquals("ಹೆಣ್ಣಾಗಿ", q12[3].correctAnswer)
    }
}
