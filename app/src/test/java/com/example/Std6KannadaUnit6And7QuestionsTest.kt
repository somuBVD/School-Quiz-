package com.example

import com.example.data.QuizStaticData
import com.example.data.Std6KannadaQuestionBank
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Std6KannadaUnit6And7QuestionsTest {

    @Test
    fun testStd6KannadaUnit6QuestionCountAndMetadata() {
        val unit6 = Std6KannadaQuestionBank.units.find { it.id == 6 }
        assertTrue("Unit 6 should exist", unit6 != null)
        assertEquals(3, unit6?.totalQuestions)
        assertEquals("ಗದ್ಯಪಾಠ–6: ಕರ್ನಾಟಕ ಏಕೀಕರಣ", unit6?.name)

        val unit6Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 6 }
        assertEquals(3, unit6Questions.size)
        assertEquals("ಸಿದ್ಧಪ್ಪ ಕಂಬಳಿ", unit6Questions[0].correctAnswer)
        assertEquals("ದಸರಾ", unit6Questions[1].correctAnswer)
        assertEquals("ಆಕಾಶವಾಣಿ", unit6Questions[2].correctAnswer)
    }

    @Test
    fun testStd6KannadaUnit7QuestionCountAndMetadata() {
        val unit7 = Std6KannadaQuestionBank.units.find { it.id == 7 }
        assertTrue("Unit 7 should exist", unit7 != null)
        assertEquals(3, unit7?.totalQuestions)
        assertEquals("ಪದ್ಯಪಾಠ–7: ಬೇಸಿಗೆ", unit7?.name)

        val unit7Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 7 }
        assertEquals(3, unit7Questions.size)
        assertEquals("ಶಾಲೆ", unit7Questions[0].correctAnswer)
        assertEquals("ಷಟ್ಕೋನ", unit7Questions[1].correctAnswer)
        assertEquals("ಕಲ್ಲು – ಜಡ", unit7Questions[2].correctAnswer)
    }

    @Test
    fun testQuizStaticDataRetrievalForUnit6And7() {
        val q6 = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 6,
            custom = emptyList()
        )
        assertEquals(3, q6.size)

        val q7 = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 7,
            custom = emptyList()
        )
        assertEquals(3, q7.size)
    }
}
