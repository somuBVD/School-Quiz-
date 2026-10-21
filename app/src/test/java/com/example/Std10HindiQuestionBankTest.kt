package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std10HindiQuestionBankTest {

    @Test
    fun testStd10HindiUnitsStructure() {
        val std10 = QuizStaticData.standardsList.find { it.std == 10 }
        assertNotNull("Standard 10 must be present in standardsList", std10)

        val hindiSubject = std10!!.subjects.find { it.id == "hindi" }
        assertNotNull("Hindi subject must be present in Std 10", hindiSubject)

        // All 18 units must be present
        assertEquals("Standard 10 Hindi must contain 18 units", 18, hindiSubject!!.units.size)

        // Validate unit titles
        val unitTitles = listOf(
            1 to "पाठ 1: मातृभूमि",
            2 to "पाठ 2: कश्मीरी सेब",
            3 to "पाठ 3: गिल्लू",
            4 to "पाठ 4: इंटरनेट क्रांति",
            5 to "पाठ 5: ईमानदारी के सम्मेलन में",
            6 to "पाठ 6: बसंत की सच्चाई",
            7 to "पाठ 7: महिला की साहस गाथा",
            8 to "पाठ 8: मेरा बचपन",
            9 to "पाठ 9: शनि सबसे सुंदर ग्रह",
            10 to "पाठ 10: तुलसी के दोहे",
            11 to "पाठ 11: समय की पहचान",
            12 to "पाठ 12: अभिनव मनुष्य",
            13 to "पाठ 13: कोशिश करने वालों की कभी हार नहीं होती",
            14 to "पाठ 14: सूर-श्याम",
            15 to "पाठ 15: सवा सेर गेहूँ",
            16 to "पाठ 16: कर्नाटक संपदा",
            17 to "पाठ 17: उत्सवी आनंद",
            18 to "पाठ 18: व्यावहारिक व्याकरण, मुहावरे और अनुरूपता"
        )

        for ((id, expectedNamePart) in unitTitles) {
            val unit = hindiSubject.units.find { it.id == id }
            assertNotNull("Unit $id must exist", unit)
            assertTrue(
                "Unit $id title '${unit!!.name}' should contain '$expectedNamePart'",
                unit.name.contains(expectedNamePart)
            )
        }
    }

    @Test
    fun testStd10HindiQuestionsIntegrity() {
        val questions = Std10HindiQuestionBank.questions
        assertTrue(
            "Std 10 Hindi question bank should contain at least 250 questions, found ${questions.size}",
            questions.size >= 250
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
            assertEquals("subjectId must be 'hindi'", "hindi", q.subjectId)
            assertTrue("unitId must be between 1 and 18, but was ${q.unitId}", q.unitId in 1..18)
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
    fun testStd10HindiQuestionsDistributionPerUnit() {
        val questions = Std10HindiQuestionBank.questions
        for (u in 1..18) {
            val unitQuestions = questions.filter { it.unitId == u }
            assertTrue(
                "Unit $u must have at least 15 questions, but has ${unitQuestions.size}",
                unitQuestions.size >= 15
            )
        }
    }

    @Test
    fun testStd10HindiIntegratedInStaticData() {
        val filteredStatic = QuizStaticData.staticQuestions.filter {
            it.stdId == 10 && it.subjectId == "hindi"
        }
        assertEquals(
            "QuizStaticData must contain all Std 10 Hindi questions",
            Std10HindiQuestionBank.questions.size,
            filteredStatic.size
        )

        // Verify Unit 1 (मातृभूमि)
        val unit1Questions = QuizStaticData.getQuestionsForUnit(10, "hindi", 1, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 1", unit1Questions.isNotEmpty())
        assertTrue(unit1Questions.any { it.questionText.contains("मातृभूमि") || it.questionText.contains("भगवतीचरण") })

        // Verify Unit 2 (कश्मीरी सेब)
        val unit2Questions = QuizStaticData.getQuestionsForUnit(10, "hindi", 2, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 2", unit2Questions.isNotEmpty())
        assertTrue(unit2Questions.any { it.questionText.contains("सेब") || it.questionText.contains("प्रेमचंद") })

        // Verify Unit 3 (गिल्लू)
        val unit3Questions = QuizStaticData.getQuestionsForUnit(10, "hindi", 3, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 3", unit3Questions.isNotEmpty())
        assertTrue(unit3Questions.any { it.questionText.contains("गिल्लू") || it.questionText.contains("महादेवी") })

        // Verify Unit 18 (व्याकरण और अनुरूपता)
        val unit18Questions = QuizStaticData.getQuestionsForUnit(10, "hindi", 18, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 18", unit18Questions.isNotEmpty())
        assertTrue(unit18Questions.any { it.questionText.contains("अनुरूपता") || it.questionText.contains("मुहावरे") || it.questionText.contains("संधि") })
    }
}
