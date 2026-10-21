package com.example

import com.example.data.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class Std9HindiQuestionBankTest {

    @Test
    fun testStd9HindiUnitsStructure() {
        val std9 = QuizStaticData.standardsList.find { it.std == 9 }
        assertNotNull("Standard 9 must be present in standardsList", std9)

        val hindiSubject = std9!!.subjects.find { it.id == "hindi" }
        assertNotNull("Hindi subject must be present in Std 9", hindiSubject)

        // All 18 units must be present
        assertEquals("Standard 9 Hindi must contain 18 units", 18, hindiSubject!!.units.size)

        // Check unit IDs and titles
        val unit1 = hindiSubject.units.find { it.id == 1 }
        assertNotNull(unit1)
        assertTrue(unit1!!.name.contains("जय-जय भारत माता"))

        val unit2 = hindiSubject.units.find { it.id == 2 }
        assertNotNull(unit2)
        assertTrue(unit2!!.name.contains("गुलाब सिंह"))

        val unit3 = hindiSubject.units.find { it.id == 3 }
        assertNotNull(unit3)
        assertTrue(unit3!!.name.contains("स्वामी विवेकानंद"))

        val unit4 = hindiSubject.units.find { it.id == 4 }
        assertNotNull(unit4)
        assertTrue(unit4!!.name.contains("अनुशासन ही शासन है"))

        val unit5 = hindiSubject.units.find { it.id == 5 }
        assertNotNull(unit5)
        assertTrue(unit5!!.name.contains("मौसी"))

        val unit6 = hindiSubject.units.find { it.id == 6 }
        assertNotNull(unit6)
        assertTrue(unit6!!.name.contains("चेरापूँजी से आया हूँ"))

        val unit7 = hindiSubject.units.find { it.id == 7 }
        assertNotNull(unit7)
        assertTrue(unit7!!.name.contains("पर्यावरण बचाओ"))

        val unit8 = hindiSubject.units.find { it.id == 8 }
        assertNotNull(unit8)
        assertTrue(unit8!!.name.contains("भीम और राक्षस"))

        val unit9 = hindiSubject.units.find { it.id == 9 }
        assertNotNull(unit9)
        assertTrue(unit9!!.name.contains("नफे के चक्कर में"))

        val unit10 = hindiSubject.units.find { it.id == 10 }
        assertNotNull(unit10)
        assertTrue(unit10!!.name.contains("चलना हमारा काम है"))

        val unit11 = hindiSubject.units.find { it.id == 11 }
        assertNotNull(unit11)
        assertTrue(unit11!!.name.contains("खेलो-कूदो-स्वस्थ रहो"))

        val unit12 = hindiSubject.units.find { it.id == 12 }
        assertNotNull(unit12)
        assertTrue(unit12!!.name.contains("सड़क की रक्षा – सबकी सुरक्षा"))

        val unit13 = hindiSubject.units.find { it.id == 13 }
        assertNotNull(unit13)
        assertTrue(unit13!!.name.contains("साथी, हाथ बढ़ाना"))

        val unit14 = hindiSubject.units.find { it.id == 14 }
        assertNotNull(unit14)
        assertTrue(unit14!!.name.contains("सौर ऊर्जा"))

        val unit15 = hindiSubject.units.find { it.id == 15 }
        assertNotNull(unit15)
        assertTrue(unit15!!.name.contains("वीरांगना चेन्नम्मा"))

        val unit16 = hindiSubject.units.find { it.id == 16 }
        assertNotNull(unit16)
        assertTrue(unit16!!.name.contains("पूर्वाक्षर का पूर्वाग्रह"))

        val unit17 = hindiSubject.units.find { it.id == 17 }
        assertNotNull(unit17)
        assertTrue(unit17!!.name.contains("रहीम के दोहे"))

        val unit18 = hindiSubject.units.find { it.id == 18 }
        assertNotNull(unit18)
        assertTrue(unit18!!.name.contains("व्याकरण"))
    }

    @Test
    fun testStd9HindiQuestionsIntegrity() {
        val questions = Std9HindiQuestionBank.questions
        assertEquals("Std 9 Hindi question bank should contain exactly 275 questions", 275, questions.size)

        val seenIds = mutableSetOf<String>()
        val seenTexts = mutableSetOf<String>()

        for (q in questions) {
            // ID uniqueness
            assertFalse("Duplicate question ID: ${q.id}", seenIds.contains(q.id))
            seenIds.add(q.id)

            // Text uniqueness (omit duplicates)
            val normalizedText = q.questionText.trim()
            assertFalse("Duplicate question text found: ${q.questionText}", seenTexts.contains(normalizedText))
            seenTexts.add(normalizedText)

            // Std and subject checks
            assertEquals("stdId must be 9", 9, q.stdId)
            assertEquals("subjectId must be 'hindi'", "hindi", q.subjectId)
            assertTrue("unitId must be between 1 and 18", q.unitId in 1..18)
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
    fun testStd9HindiIntegratedInStaticData() {
        val filteredStatic = QuizStaticData.staticQuestions.filter {
            it.stdId == 9 && it.subjectId == "hindi"
        }
        assertEquals("QuizStaticData must contain all 275 Std 9 Hindi questions", 275, filteredStatic.size)

        // Verify fallback getter returns authentic questions
        val unit1Questions = QuizStaticData.getQuestionsForUnit(9, "hindi", 1, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 1", unit1Questions.isNotEmpty())
        assertTrue(unit1Questions.any { it.questionText.contains("मैथिलीशरण गुप्त") || it.questionText.contains("हिमालय") })

        val unit15Questions = QuizStaticData.getQuestionsForUnit(9, "hindi", 15, emptyList())
        assertTrue("getQuestionsForUnit should return questions for unit 15", unit15Questions.isNotEmpty())
        assertTrue(unit15Questions.any { it.questionText.contains("चेन्नम्मा") || it.questionText.contains("कित्तूर") })
    }
}
