package com.example

import com.example.data.BulkQuestionParser
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class BulkQuestionParserTest {

    @Test
    fun testParseCsvSampleTemplate() {
        val parsed = BulkQuestionParser.parseAuto(
            content = BulkQuestionParser.SAMPLE_CSV_TEMPLATE,
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            unitName = "Chapter 1: Matter & Chemistry"
        )

        assertEquals(5, parsed.size)
        assertTrue(parsed.all { it.isValid })

        val firstQ = parsed[0].entity
        assertEquals(6, firstQ.stdId)
        assertEquals("science", firstQ.subjectId)
        assertEquals(1, firstQ.unitId)
        assertEquals("What is the chemical symbol for Gold?", firstQ.questionText)
        assertEquals("Au", firstQ.correctAnswer)
        assertTrue(firstQ.optionsString.contains("Au"))
        assertTrue(firstQ.optionsString.contains("Ag"))
    }

    @Test
    fun testParsePdfQuestionPaperFormat() {
        val parsed = BulkQuestionParser.parseTextOrPdfDocument(
            text = BulkQuestionParser.SAMPLE_PDF_TEXT_TEMPLATE,
            stdId = 8,
            subjectId = "math",
            unitId = 2,
            unitName = "Chapter 2: Real Numbers & Geometry"
        )

        assertEquals(5, parsed.size)
        assertTrue(parsed.all { it.isValid })

        // Check Q1 Pi question
        val q1 = parsed[0].entity
        assertTrue(q1.questionText.contains("Pi"))
        assertEquals("3.14", q1.correctAnswer)
        assertEquals(4, q1.optionsString.split('|').size)

        // Check True/False sound waves question
        val q3 = parsed[2].entity
        assertEquals("TF", q3.type)
        assertEquals("False", q3.correctAnswer)
    }

    @Test
    fun testParsePositionalCsvWithoutHeader() {
        val rawCsv = """
"What is the square root of 64?","6","7","8","9","8","8 squared equals 64.","Easy","MCQ"
"Which planet is closest to the Sun?","Venus","Mercury","Mars","Earth","Mercury","Mercury is nearest to the sun.","Easy","MCQ"
""".trimIndent()

        val parsed = BulkQuestionParser.parseCsvOrTsv(
            csvText = rawCsv,
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            unitName = "Unit 3: Solar System"
        )

        assertEquals(2, parsed.size)
        assertTrue(parsed.all { it.isValid })
        assertEquals("8", parsed[0].entity.correctAnswer)
        assertEquals("Mercury", parsed[1].entity.correctAnswer)
    }

    @Test
    fun testValidationFlagsInvalidQuestion() {
        // Question too short and missing options
        val invalidCsv = """
question,optionA,optionB,optionC,optionD,correctAnswer,explanation
"Hi?","","","","","",""
""".trimIndent()

        val parsed = BulkQuestionParser.parseCsvOrTsv(
            csvText = invalidCsv,
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            unitName = "Unit 1"
        )

        assertEquals(1, parsed.size)
        assertFalse(parsed[0].isValid)
    }
}
