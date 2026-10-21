package com.example

import com.example.data.QuizStaticData
import com.example.data.Std6KannadaQuestionBank
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Std6KannadaUnit3QuestionsTest {

    @Test
    fun testStd6KannadaUnit3QuestionCountAndMetadata() {
        val unit3 = Std6KannadaQuestionBank.units.find { it.id == 3 }
        assertTrue("Unit 3 should exist", unit3 != null)
        assertEquals(6, unit3?.totalQuestions)
        assertEquals("ಗದ್ಯಪಾಠ–3: ಕೃಷ್ಣ ಸುಧಾಮ", unit3?.name)
    }

    @Test
    fun testStd6KannadaUnit3QuestionsDirect() {
        val unit3Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 3 }
        assertEquals(6, unit3Questions.size)

        // Verify Question 1
        assertEquals("‘ಕೈಚೆಲ್ಲಿದರು’ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥ ಯಾವುದು?", unit3Questions[0].questionText)
        assertEquals(listOf("ಕೈತೊಳೆಯುವುದು", "ಪ್ರಯತ್ನಬಿಟ್ಟುಬಿಡುವುದು", "ಸಹಾಯ ಮಾಡುವುದು", "ಆಟವಾಡುವುದು"), unit3Questions[0].options)
        assertEquals("ಪ್ರಯತ್ನಬಿಟ್ಟುಬಿಡುವುದು", unit3Questions[0].correctAnswer)

        // Verify Question 2
        assertEquals("‘ಕೈಜೋಡಿಸುವುದು’ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥ ಯಾವುದು?", unit3Questions[1].questionText)
        assertEquals(listOf("ಜಗಳ ಮಾಡುವುದು", "ಓಡುವುದು", "ಸಹಾಯ ಮಾಡುವುದು", "ನಗುವುದು"), unit3Questions[1].options)
        assertEquals("ಸಹಾಯ ಮಾಡುವುದು", unit3Questions[1].correctAnswer)

        // Verify Question 3
        assertEquals("ಈ ಗದ್ಯದ ನೀತಿ ಯಾವುದು?", unit3Questions[2].questionText)
        assertEquals(listOf("ಒಗ್ಗಟ್ಟಿದ್ದರೆ ಯಶಸ್ಸು ಸಿಗುತ್ತದೆ", "ಸಮಯ ವ್ಯರ್ಥ ಮಾಡಬೇಕು", "ಸುಳ್ಳು ಹೇಳಬಾರದು", "ಒಬ್ಬರೇ ಕೆಲಸ ಮಾಡಬೇಕು"), unit3Questions[2].options)
        assertEquals("ಒಗ್ಗಟ್ಟಿದ್ದರೆ ಯಶಸ್ಸು ಸಿಗುತ್ತದೆ", unit3Questions[2].correctAnswer)

        // Verify Question 4
        assertEquals("‘ಮಿತ್ರರು’ ಪದಕ್ಕೆ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?", unit3Questions[3].questionText)
        assertEquals(listOf("ಗೆಳೆಯ", "ಸ್ನೇಹ", "ಶತ್ರು", "ರಾಜ"), unit3Questions[3].options)
        assertEquals("ಶತ್ರು", unit3Questions[3].correctAnswer)

        // Verify Question 5
        assertEquals("‘ದೂರ’ ಪದಕ್ಕೆ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?", unit3Questions[4].questionText)
        assertEquals(listOf("ಸಮೀಪ", "ದೂರ", "ಕಠಿಣ", "ಮೇಲಿನ ಯಾವುದೂ ಅಲ್ಲ"), unit3Questions[4].options)
        assertEquals("ಸಮೀಪ", unit3Questions[4].correctAnswer)

        // Verify Question 6
        assertEquals("‘ನೀತಿ’ ಪದಕ್ಕೆ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?", unit3Questions[5].questionText)
        assertEquals(listOf("ಅನೀತಿ", "ವಿನಾಶ", "ಆಶ್ಚರ್ಯ", "ಅವನತಿ"), unit3Questions[5].options)
        assertEquals("ಅನೀತಿ", unit3Questions[5].correctAnswer)
    }

    @Test
    fun testQuizStaticDataRetrievalForUnit3() {
        val questions = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 3,
            custom = emptyList()
        )
        assertEquals("Should retrieve exactly 6 questions with no duplicates", 6, questions.size)
        assertEquals("s_6_kan_u3_1", questions[0].id)
        assertEquals("s_6_kan_u3_6", questions[5].id)
    }
}
