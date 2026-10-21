package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std10EnglishQuestionBankTest {

    @Test
    fun testStd10EnglishUnitsStructure() {
        val std10 = QuizStaticData.standardsList.find { it.std == 10 }
        assertNotNull("Standard 10 must be present in standardsList", std10)

        val englishSubject = std10!!.subjects.find { it.id == "english" }
        assertNotNull("English subject must be present in Std 10", englishSubject)

        // All 21 units must be present
        assertEquals("Standard 10 English must contain 21 units", 21, englishSubject!!.units.size)

        // Validate unit titles
        val unitTitles = listOf(
            1 to "A Hero",
            2 to "There's a Girl by the Tracks!",
            3 to "Gentleman of Rio en Medio",
            4 to "Dr. B. R. Ambedkar",
            5 to "The Concert",
            6 to "The Discovery",
            7 to "Colours of Silence",
            8 to "Science and Hope of Survival",
            9 to "Grandma Climbs a Tree",
            10 to "Quality of Mercy",
            11 to "I am the Land",
            12 to "The Song of India",
            13 to "Jazz Poem Two",
            14 to "Ballad of the Tempest",
            15 to "The Blind Boy",
            16 to "Off to Outer Space Tomorrow Morning",
            17 to "Narayanpur Incident",
            18 to "On Top of the World",
            19 to "A Great Martyr Ever Cherished",
            20 to "The Bird of Happiness",
            21 to "Grammar, Vocabulary & Language Study"
        )

        for ((id, expectedNamePart) in unitTitles) {
            val unit = englishSubject.units.find { it.id == id }
            assertNotNull("Unit $id must exist", unit)
            assertTrue(
                "Unit $id title '${unit!!.name}' should contain '$expectedNamePart'",
                unit.name.contains(expectedNamePart)
            )
        }
    }

    @Test
    fun testStd10EnglishQuestionsIntegrity() {
        val questions = Std10EnglishQuestionBank.questions
        assertTrue(
            "Std 10 English question bank should contain at least 210 questions, found ${questions.size}",
            questions.size >= 210
        )

        val seenIds = mutableSetOf<String>()
        val seenTexts = mutableSetOf<String>()

        for (q in questions) {
            // ID uniqueness
            assertFalse("Duplicate question ID: ${q.id}", seenIds.contains(q.id))
            seenIds.add(q.id)

            // Text uniqueness (omit duplicate MCQs)
            val normalizedText = q.questionText.trim()
            assertFalse("Duplicate question text found: ${q.questionText}", seenTexts.contains(normalizedText))
            seenTexts.add(normalizedText)

            // Std and subject checks
            assertEquals("stdId must be 10", 10, q.stdId)
            assertEquals("subjectId must be 'english'", "english", q.subjectId)
            assertTrue("unitId must be between 1 and 21, but was ${q.unitId}", q.unitId in 1..21)
            assertEquals("type must be MCQ", "MCQ", q.type)

            // Options and answer validation
            assertEquals("Every question must have exactly 4 options: ${q.id}", 4, q.options.size)
            assertTrue(
                "correctAnswer '${q.correctAnswer}' must be in options ${q.options} for question ${q.id}",
                q.options.contains(q.correctAnswer)
            )

            // Explanations must be detailed
            assertTrue("Explanation should not be blank for ${q.id}", q.explanation.isNotBlank())

            // Picture-based questions must be omitted (no mediaRes)
            assertTrue("Picture-based questions must be omitted: ${q.id}", q.mediaRes.isBlank())
        }
    }

    @Test
    fun testStd10EnglishQuestionsDistributionPerUnit() {
        val questions = Std10EnglishQuestionBank.questions
        for (u in 1..21) {
            val unitQuestions = questions.filter { it.unitId == u }
            assertTrue("Unit $u must have at least 10 questions, but has ${unitQuestions.size}", unitQuestions.size >= 10)
        }
    }

    @Test
    fun testStd10EnglishIntegratedInStaticData() {
        val filteredStatic = QuizStaticData.staticQuestions.filter {
            it.stdId == 10 && it.subjectId == "english"
        }
        assertEquals(
            "QuizStaticData must contain all Std 10 English questions",
            Std10EnglishQuestionBank.questions.size,
            filteredStatic.size
        )

        // Verify fallback getter returns authentic questions for Unit 1 (A Hero)
        val unit1Questions = QuizStaticData.getQuestionsForUnit(10, "english", 1, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 1", unit1Questions.isNotEmpty())
        assertTrue(unit1Questions.any { it.questionText.contains("tiger") || it.questionText.contains("Swami") })

        // Verify fallback getter returns authentic questions for Unit 2 (There's a Girl by the Tracks!)
        val unit2Questions = QuizStaticData.getQuestionsForUnit(10, "english", 2, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 2", unit2Questions.isNotEmpty())
        assertTrue(unit2Questions.any { it.questionText.contains("Roma") || it.questionText.contains("Baleshwar") })

        // Verify fallback getter returns authentic questions for Unit 4 (Dr. B. R. Ambedkar)
        val unit4Questions = QuizStaticData.getQuestionsForUnit(10, "english", 4, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 4", unit4Questions.isNotEmpty())
        assertTrue(unit4Questions.any { it.questionText.contains("Ambedkar") || it.questionText.contains("Drafting") })

        // Verify fallback getter returns authentic questions for Unit 21 (Grammar & Vocabulary)
        val unit21Questions = QuizStaticData.getQuestionsForUnit(10, "english", 21, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 21", unit21Questions.isNotEmpty())
        assertTrue(unit21Questions.any { it.questionText.contains("collocates") || it.questionText.contains("syllables") })
    }
}
