package com.example

import com.example.data.QuizStaticData
import com.example.data.Std6KannadaQuestionBank
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Std6KannadaUnit1QuestionsTest {

    @Test
    fun testStd6KannadaUnit1QuestionCountAndMetadata() {
        val unit1 = Std6KannadaQuestionBank.units.find { it.id == 1 }
        assertTrue("Unit 1 should exist", unit1 != null)
        assertEquals(12, unit1?.totalQuestions)
        assertEquals("ಗದ್ಯಪಾಠ–1: ದೊಡ್ಡವರ ದಾರಿ", unit1?.name)
    }

    @Test
    fun testStd6KannadaUnit1QuestionsDirect() {
        val unit1Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 1 }
        assertEquals(12, unit1Questions.size)

        // Verify Question 1
        assertEquals("ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿರುವ ಅಕ್ಷರಗಳು ಎಷ್ಟು?", unit1Questions[0].questionText)
        assertEquals(listOf("49", "50", "47", "52"), unit1Questions[0].options)
        assertEquals("49", unit1Questions[0].correctAnswer)

        // Verify Question 2
        assertEquals("ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿರುವ ಸ್ವರಾಕ್ಷರಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?", unit1Questions[1].questionText)
        assertEquals(listOf("15", "18", "13", "25"), unit1Questions[1].options)
        assertEquals("13", unit1Questions[1].correctAnswer)

        // Verify Question 3
        assertEquals("ಅನುಸ್ವಾರ ಮತ್ತು ವಿಸರ್ಗ ಎನ್ನುವುದು ಏನು?", unit1Questions[2].questionText)
        assertEquals("ಯೋಗವಾಹಗಳು", unit1Questions[2].correctAnswer)

        // Verify Question 4
        assertEquals("ಅನುನಾಸಿಕ ಅಕ್ಷರಕ್ಕೆ ಉದಾಹರಣೆ ಯಾವುದು?", unit1Questions[3].questionText)
        assertEquals("ಙ", unit1Questions[3].correctAnswer)

        // Verify Question 5
        assertEquals("ರಾಷ್ಟ್ರದ ಪ್ರಥಮ ಪ್ರಜೆ ಯಾರು?", unit1Questions[4].questionText)
        assertEquals("ರಾಷ್ಟ್ರಾಧ್ಯಕ್ಷರು", unit1Questions[4].correctAnswer)

        // Verify Question 6
        assertEquals("‘ಆದೇಶ’ ಪದದ ಅರ್ಥ ಯಾವುದು?", unit1Questions[5].questionText)
        assertEquals("ಆಜ್ಞೆ", unit1Questions[5].correctAnswer)

        // Verify Question 7
        assertEquals("ಉಪಕುಲಪತಿ ಯಾರ ಮುಖ್ಯಸ್ಥರು?", unit1Questions[6].questionText)
        assertEquals("ವಿಶ್ವವಿದ್ಯಾಲಯದ", unit1Questions[6].correctAnswer)

        // Verify Question 8
        assertEquals("‘ಮಗು’ ಪದದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?", unit1Questions[7].questionText)
        assertEquals("ಮಕ್ಕಳು", unit1Questions[7].correctAnswer)

        // Verify Question 9
        assertEquals("ಮಕ್ಕಳು ಯಾವ ವ್ಯಕ್ತಿಗೆ ಸಹಾಯ ಮಾಡುತ್ತಿದ್ದರು?", unit1Questions[8].questionText)
        assertEquals("ಹಿರಿಯ ನಾಗರಿಕರಿಗೆ", unit1Questions[8].correctAnswer)

        // Verify Question 10
        assertEquals("ಮಕ್ಕಳು ಹಿರಿಯರಿಗೆ ಮಾಡಿದ ಸಹಾಯ ಯಾವುದು?", unit1Questions[9].questionText)
        assertEquals("ರಸ್ತೆ ದಾಟಲು ಸಹಾಯ ಮಾಡಿದರು", unit1Questions[9].correctAnswer)

        // Verify Question 11
        assertEquals("ಹಿರಿಯರಿಗೆ ಸಹಾಯ ಮಾಡುವುದು ಯಾವ ಗುಣವನ್ನು ತೋರಿಸುತ್ತದೆ?", unit1Questions[10].questionText)
        assertEquals("ಮಾನವೀಯತೆ", unit1Questions[10].correctAnswer)

        // Verify Question 12
        assertEquals("ಈ ಸನ್ನಿವೇಶದಿಂದ ನಾವು ಏನು ಕಲಿಯುತ್ತೇವೆ?", unit1Questions[11].questionText)
        assertEquals("ಅಗತ್ಯವಿರುವವರಿಗೆ ಸಹಾಯ ಮಾಡುವುದು", unit1Questions[11].correctAnswer)
    }

    @Test
    fun testQuizStaticDataRetrievalForUnit1() {
        val questions = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            custom = emptyList()
        )
        assertEquals("Should retrieve exactly 12 questions with no old duplicates", 12, questions.size)
        assertEquals("s_6_kan_u1_1", questions[0].id)
        assertEquals("s_6_kan_u1_12", questions[11].id)
    }
}
