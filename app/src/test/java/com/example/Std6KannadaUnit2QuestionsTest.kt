package com.example

import com.example.data.QuizStaticData
import com.example.data.Std6KannadaQuestionBank
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Std6KannadaUnit2QuestionsTest {

    @Test
    fun testStd6KannadaUnit2QuestionCountAndMetadata() {
        val unit2 = Std6KannadaQuestionBank.units.find { it.id == 2 }
        assertTrue("Unit 2 should exist", unit2 != null)
        assertEquals(6, unit2?.totalQuestions)
        assertEquals("ಗದ್ಯಪಾಠ–2: ಗಂಧರ್ವ ಸೇನ", unit2?.name)
    }

    @Test
    fun testStd6KannadaUnit2QuestionsDirect() {
        val unit2Questions = Std6KannadaQuestionBank.questions.filter { it.unitId == 2 }
        assertEquals(6, unit2Questions.size)

        // Verify Question 1
        assertEquals("ಗಂಧರ್ವ ಸೇನ ಎನ್ನುವುದು ಯಾವುದು?", unit2Questions[0].questionText)
        assertEquals(listOf("ಕುದುರೆ", "ಸಿಂಹ", "ಕತ್ತೆ", "ಆನೆ"), unit2Questions[0].options)
        assertEquals("ಕತ್ತೆ", unit2Questions[0].correctAnswer)

        // Verify Question 2
        assertEquals("ಅಂಕಿತನಾಮಕ್ಕೆ ಉದಾಹರಣೆಯಾದ ಪದ ಯಾವುದು?", unit2Questions[1].questionText)
        assertEquals(listOf("ಕಾವೇರಿ", "ಮನುಷ್ಯ", "ವಿದ್ವಾಂಸ", "ಹೊಸದು"), unit2Questions[1].options)
        assertEquals("ಕಾವೇರಿ", unit2Questions[1].correctAnswer)

        // Verify Question 3
        assertEquals("ಕೆಳಗಿನವರಲ್ಲಿ ಚುರುಕು ಬುದ್ಧಿಯವರು ಯಾರು?", unit2Questions[2].questionText)
        assertEquals(listOf("ಮಂತ್ರಿ", "ಸೇವಕಿ", "ಸೈನಿಕ", "ಮಡಿವಾಳ"), unit2Questions[2].options)
        assertEquals("ಸೇವಕಿ", unit2Questions[2].correctAnswer)

        // Verify Question 4
        assertEquals("ರಾಜನ ಒಡ್ಡೋಲಗಕ್ಕೆ ಅಳುತ್ತಾ ಬಂದವರು ಯಾರು?", unit2Questions[3].questionText)
        assertEquals(listOf("ರಾಣಿ", "ಸೇವಕಿ", "ಪ್ರಜೆ", "ಮಂತ್ರಿ"), unit2Questions[3].options)
        assertEquals("ಮಂತ್ರಿ", unit2Questions[3].correctAnswer)

        // Verify Question 5
        assertEquals("ರಾಜನಿಗೆ ಗಂಧರ್ವ ಸೇನ ತೀರಿಹೋದ ವಿಷಯವನ್ನು ತಿಳಿಸಿದವರು ಯಾರು?", unit2Questions[4].questionText)
        assertEquals(listOf("ಮಂತ್ರಿ", "ರಾಣಿ", "ಸೇವಕಿ", "ಸೈನಿಕ"), unit2Questions[4].options)
        assertEquals("ಮಂತ್ರಿ", unit2Questions[4].correctAnswer)

        // Verify Question 6
        assertEquals("‘ಅಂತಃಪುರ’ ಪದದ ಅರ್ಥ ಯಾವುದು?", unit2Questions[5].questionText)
        assertEquals(listOf("ರಾಜಾಂಗಣ", "ರಾಣಿವಾಸ", "ರಾಜಸಭೆ", "ಸೇವಕಿಯರ ವಾಸ"), unit2Questions[5].options)
        assertEquals("ರಾಣಿವಾಸ", unit2Questions[5].correctAnswer)
    }

    @Test
    fun testQuizStaticDataRetrievalForUnit2() {
        val questions = QuizStaticData.getQuestionsForUnit(
            stdId = 6,
            subjectId = "kannada",
            unitId = 2,
            custom = emptyList()
        )
        assertEquals("Should retrieve exactly 6 questions with no duplicates", 6, questions.size)
        assertEquals("s_6_kan_u2_1", questions[0].id)
        assertEquals("s_6_kan_u2_6", questions[5].id)
    }
}
