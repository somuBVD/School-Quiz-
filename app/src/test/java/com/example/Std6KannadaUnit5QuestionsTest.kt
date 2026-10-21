package com.example

import com.example.data.QuizStaticData
import com.example.data.Std6KannadaQuestionBank
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Std6KannadaUnit5QuestionsTest {

    @Test
    fun testStd6KannadaUnit5QuestionCountAndMetadata() {
        val unit5 = Std6KannadaQuestionBank.units.find { it.id == 5 }
        assertTrue("Unit 5 should exist", unit5 != null)
        assertEquals(12, unit5?.totalQuestions)
        assertEquals("ಗದ್ಯಪಾಠ–5: ಧನ್ಯವಾದ ಹೇಳಿದ ಆಕ್ಕರೆ", unit5?.name)
    }

    @Test
    fun testStd6KannadaUnit5QuestionsDirect() {
        val unit5Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 5 }
        assertEquals(12, unit5Questions.size)

        // Verify Question 1
        assertEquals("2024ರ ರಾಜ್ಯ ಚಲನಚಿತ್ರ ಪ್ರಶಸ್ತಿಯಲ್ಲಿ ‘ಮಿಥ್ಯ’ ಯಾವ ವಿಭಾಗದಲ್ಲಿ ಗುರುತಿಸಲ್ಪಟ್ಟಿದೆ?", unit5Questions[0].questionText)
        assertEquals("ಅತ್ಯುತ್ತಮ ಮಕ್ಕಳ ಚಿತ್ರ", unit5Questions[0].correctAnswer)

        // Verify Question 2
        assertEquals("ಹರಿ ಉಪಚರಿಸಿದ ಪಕ್ಷಿ ಯಾವುದು?", unit5Questions[1].questionText)
        assertEquals("ಆಕ್ಕರೆ", unit5Questions[1].correctAnswer)

        // Verify Question 3
        assertEquals("‘ಹಿಮದ ಹೂ’ ಕೃತಿ ಯಾರದು?", unit5Questions[2].questionText)
        assertEquals("ಅನುಪಮಾ ನಿರಂಜನ", unit5Questions[2].correctAnswer)

        // Verify Question 4
        assertEquals("‘ಕ್ಷಾಮ’ ಪದದ ಅರ್ಥ ಯಾವುದು?", unit5Questions[3].questionText)
        assertEquals("ಬರಗಾಲ", unit5Questions[3].correctAnswer)

        // Verify Question 5
        assertEquals("“ಅಹಾ ಹೂವು ಎಷ್ಟು ಸುಂದರವಾಗಿದೆ” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿ ಬಳಸಬಹುದಾದ ಲೇಖನ ಚಿಹ್ನೆಗಳು ಯಾವುವು?", unit5Questions[4].questionText)
        assertEquals("ಭಾವಸೂಚಕ ಮತ್ತು ಅಲ್ಪವಿರಾಮ", unit5Questions[4].correctAnswer)

        // Verify Question 6
        assertEquals("‘ಕಾರ್ಯ’ ಪದದ ತದ್ಭವ ರೂಪ ಯಾವುದು?", unit5Questions[5].questionText)
        assertEquals("ಕಜ್ಜ", unit5Questions[5].correctAnswer)

        // Verify Question 7
        assertEquals("‘ಹೆಂಡತಿ’ ಪದದ ಪುಲ್ಲಿಂಗ ರೂಪ ಯಾವುದು?", unit5Questions[6].questionText)
        assertEquals("ಗಂಡ", unit5Questions[6].correctAnswer)

        // Verify Question 8
        assertEquals("ಗುಬ್ಬಚ್ಚಿ ಸಿಕ್ಕಿಕೊಂಡಿದ್ದು ಎಲ್ಲಿ?", unit5Questions[7].questionText)
        assertEquals("ಗಿಡದ ಮುಳ್ಳಿನಲ್ಲಿ", unit5Questions[7].correctAnswer)

        // Verify Question 9
        assertEquals("ಗುಬ್ಬಚ್ಚಿಯನ್ನು ರಕ್ಷಿಸಿದವರು ಯಾರು?", unit5Questions[8].questionText)
        assertEquals("ಮೀನುಗಾರ", unit5Questions[8].correctAnswer)

        // Verify Question 10
        assertEquals("ಬಾಲಕನಿಗೆ ಬಾಟಲಿಯನ್ನು ತೆಗೆದು ಕೊಟ್ಟವರು ಯಾರು?", unit5Questions[9].questionText)
        assertEquals("ಕೋತಿ", unit5Questions[9].correctAnswer)

        // Verify Question 11
        assertEquals("ಗುಬ್ಬಚ್ಚಿಯು ಯಾವ ಗುಣವನ್ನು ತೋರಿಸಿತು?", unit5Questions[10].questionText)
        assertEquals("ಕೃತಜ್ಞತೆ", unit5Questions[10].correctAnswer)

        // Verify Question 12
        assertEquals("ಈ ಕಥೆಯ ಮುಖ್ಯ ಸಂದೇಶ ಯಾವುದು?", unit5Questions[11].questionText)
        assertEquals("ಉಪಕಾರಕ್ಕೆ ಕೃತಜ್ಞತೆ ಸಲ್ಲಿಸಬೇಕು", unit5Questions[11].correctAnswer)
    }

    @Test
    fun testQuizStaticDataRetrievalForUnit5() {
        val questions = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            custom = emptyList()
        )
        assertEquals("Should retrieve exactly 12 questions with no duplicates", 12, questions.size)
        assertEquals("s_6_kan_u5_1", questions[0].id)
        assertEquals("s_6_kan_u5_12", questions[11].id)
    }
}
