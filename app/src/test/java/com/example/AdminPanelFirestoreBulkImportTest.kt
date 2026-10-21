package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class AdminPanelFirestoreBulkImportTest {

    @Test
    fun testParseCsvWithKannadaQuestions() {
        val csv = """
standard,subject,unit,question,optionA,optionB,optionC,optionD,answer,explanation
6,science,1,ಸಸ್ಯಗಳು ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಗೆ ಬಳಸುವ ಅನಿಲ ಯಾವುದು?,ಆಮ್ಲಜನಕ,ಇಂಗಾಲದ ಡೈಆಕ್ಸೈಡ್,ಸಾರಜನಕ,ಹೈಡ್ರೋಜನ್,ಇಂಗಾಲದ ಡೈಆಕ್ಸೈಡ್,ಸಸ್ಯಗಳು ಸೂರ್ಯನ ಬೆಳಕಿನಲ್ಲಿ ಆಹಾರ ತಯಾರಿಸಲು CO2 ಬಳಸುತ್ತವೆ.
6,science,1,ಮಾನವ ದೇಹದ ಅತಿ ದೊಡ್ಡ ಅಂಗ ಯಾವುದು?,ಯಕೃತ್ತು,ಚರ್ಮ,ಹೃದಯ,ಮೆದುಳು,ಚರ್ಮ,ಮಾನವನ ಬಾಹ್ಯ ರಕ್ಷಣಾ ಕವಚವಾಗಿರುವ ಚರ್ಮ ಅತಿ ದೊಡ್ಡ ಅಂಗವಾಗಿದೆ.
        """.trimIndent()

        val parsed = BulkQuestionParser.parseAuto(
            content = csv,
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            unitName = "ಸಸ್ಯಗಳ ಜೀವನ"
        )

        assertEquals(2, parsed.size)
        assertTrue(parsed.all { it.isValid })

        val q1 = parsed[0].entity
        assertEquals("ಸಸ್ಯಗಳು ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಗೆ ಬಳಸುವ ಅನಿಲ ಯಾವುದು?", q1.questionText)
        assertEquals("ಇಂಗಾಲದ ಡೈಆಕ್ಸೈಡ್", q1.correctAnswer)
        assertTrue(q1.optionsString.contains("ಆಮ್ಲಜನಕ"))
        assertTrue(q1.optionsString.contains("ಇಂಗಾಲದ ಡೈಆಕ್ಸೈಡ್"))

        // Convert to Firestore QuestionModel
        val model1 = q1.toQuestionModel()
        assertEquals(q1.id, model1.id)
        assertEquals(6, model1.stdId)
        assertEquals("science", model1.subjectId)
        assertEquals(1, model1.unitId)
        assertEquals(4, model1.options.size)
        assertEquals("ಇಂಗಾಲದ ಡೈಆಕ್ಸೈಡ್", model1.correctAnswer)
    }

    @Test
    fun testValidationFlagsMissingAnswersOrOptions() {
        val invalidCsv = """
question,optionA,optionB,optionC,optionD,answer,explanation
Complete Question?,Opt A,Opt B,Opt C,Opt D,Opt A,Good explanation
Incomplete Question with no answer?,Opt 1,Opt 2,Opt 3,Opt 4,,No answer provided
        """.trimIndent()

        val parsed = BulkQuestionParser.parseAuto(
            content = invalidCsv,
            stdId = 8,
            subjectId = "math",
            unitId = 2,
            unitName = "Algebra"
        )

        assertEquals(2, parsed.size)
        assertTrue(parsed[0].isValid)
        assertFalse(parsed[1].isValid)
        assertTrue(parsed[1].validationMessage.contains("answer", ignoreCase = true))
    }

    @Test
    fun testFirestoreChunkingBatchBoundary() {
        // Create 600 synthetic questions to test chunking
        val entities = (1..600).map { i ->
            QuizQuestionEntity(
                id = "bulk_q_$i",
                stdId = 10,
                subjectId = "math",
                unitId = 1,
                unitName = "Trigonometry",
                type = "MCQ",
                questionText = "Question number $i?",
                optionsString = "A|B|C|D",
                correctAnswer = "A",
                explanation = "Explanation for $i"
            )
        }

        val models = entities.map { it.toQuestionModel() }
        assertEquals(600, models.size)

        // Firestore batch max is 500, we chunk by 250
        val chunks = models.chunked(250)
        assertEquals(3, chunks.size)
        assertEquals(250, chunks[0].size)
        assertEquals(250, chunks[1].size)
        assertEquals(100, chunks[2].size)
    }
}
