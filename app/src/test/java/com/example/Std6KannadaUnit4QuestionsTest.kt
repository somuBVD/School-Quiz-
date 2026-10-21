package com.example

import com.example.data.QuizStaticData
import com.example.data.Std6KannadaQuestionBank
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Std6KannadaUnit4QuestionsTest {

    @Test
    fun testStd6KannadaUnit4QuestionCountAndMetadata() {
        val unit4 = Std6KannadaQuestionBank.units.find { it.id == 4 }
        assertTrue("Unit 4 should exist", unit4 != null)
        assertEquals(5, unit4?.totalQuestions)
        assertEquals("ಗದ್ಯಪಾಠ–4: ಡಾ. ರಾಜಕುಮಾರ್", unit4?.name)
    }

    @Test
    fun testStd6KannadaUnit4QuestionsDirect() {
        val unit4Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 4 }
        assertEquals(5, unit4Questions.size)

        // Verify Question 1
        assertEquals("ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಕನ್ನಡ ಸಂಧಿಯ ಹೆಸರನ್ನು ಗುರುತಿಸಿ.", unit4Questions[0].questionText)
        assertEquals(listOf("ಗುಣಸಂಧಿ", "ಯಣ್ ಸಂಧಿ", "ಆಗಮ ಸಂಧಿ", "ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ"), unit4Questions[0].options)
        assertEquals("ಯಣ್ ಸಂಧಿ", unit4Questions[0].correctAnswer)

        // Verify Question 2
        assertEquals("‘ಮಿಥ್ಯ’ ಚಿತ್ರದ ನಿರ್ದೇಶಕರು ಯಾರು?", unit4Questions[1].questionText)
        assertEquals(listOf("ಯೋಗರಾಜ್", "ಬಿ. ಎಂ. ಗಿರಿರಾಜ್", "ಸುಮಂತ್ ಭಟ್", "ರಿಷಬ್ ಶೆಟ್ಟಿ"), unit4Questions[1].options)
        assertEquals("ಸುಮಂತ್ ಭಟ್", unit4Questions[1].correctAnswer)

        // Verify Question 3
        assertEquals("ರಾಜಕುಮಾರ್ ಅವರು ಹುಟ್ಟಿದ ಊರು ಯಾವುದು?", unit4Questions[2].questionText)
        assertEquals("ಗಾಜನೂರು", unit4Questions[2].correctAnswer)

        // Verify Question 4
        assertEquals("ರಾಜಕುಮಾರ್ ಮೊದಲು ಅಭಿನಯಿಸಿದ ನಾಟಕ ಕಂಪನಿ ಯಾವುದು?", unit4Questions[3].questionText)
        assertEquals("ಗುಬ್ಬಿವೀರಣ್ಣ", unit4Questions[3].correctAnswer)

        // Verify Question 5
        assertEquals("ಮೈಸೂರು ವಿಶ್ವವಿದ್ಯಾಲಯವು ರಾಜಕುಮಾರ್ ಅವರಿಗೆ ನೀಡಿದ ಪದವಿ ಯಾವುದು?", unit4Questions[4].questionText)
        assertEquals("ಗೌರವ ಡಾಕ್ಟರೇಟ್", unit4Questions[4].correctAnswer)
    }

    @Test
    fun testQuizStaticDataRetrievalForUnit4() {
        val questions = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 4,
            custom = emptyList()
        )
        assertEquals("Should retrieve exactly 5 questions with no duplicates", 5, questions.size)
        assertEquals("s_6_kan_u4_1", questions[0].id)
        assertEquals("s_6_kan_u4_5", questions[4].id)
    }
}
