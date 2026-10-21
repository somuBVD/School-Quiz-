package com.example

import com.example.ui.quiz.VoiceAnswerMatcher
import com.example.ui.quiz.VoiceCommandType
import org.junit.Assert.*
import org.junit.Test

class VoiceAnswerMatcherTest {

    private val sampleOptions = listOf(
        "Photosynthesis",
        "Cellular Respiration",
        "Fermentation",
        "Osmosis"
    )

    @Test
    fun testOptionLetterMatching() {
        val resultA = VoiceAnswerMatcher.matchSpokenTranscript("Option A", sampleOptions)
        assertEquals("Photosynthesis", resultA.matchedAnswer)
        assertEquals(0, resultA.matchedOptionIndex)
        assertTrue(resultA.confidence >= 0.9f)

        val resultB = VoiceAnswerMatcher.matchSpokenTranscript("choice b", sampleOptions)
        assertEquals("Cellular Respiration", resultB.matchedAnswer)
        assertEquals(1, resultB.matchedOptionIndex)

        val resultC = VoiceAnswerMatcher.matchSpokenTranscript("c", sampleOptions)
        assertEquals("Fermentation", resultC.matchedAnswer)
        assertEquals(2, resultC.matchedOptionIndex)

        val resultD = VoiceAnswerMatcher.matchSpokenTranscript("letter d", sampleOptions)
        assertEquals("Osmosis", resultD.matchedAnswer)
        assertEquals(3, resultD.matchedOptionIndex)
    }

    @Test
    fun testPositionalAndDigitMatching() {
        val result1 = VoiceAnswerMatcher.matchSpokenTranscript("the first option", sampleOptions)
        assertEquals("Photosynthesis", result1.matchedAnswer)
        assertEquals(0, result1.matchedOptionIndex)

        val result2 = VoiceAnswerMatcher.matchSpokenTranscript("second one", sampleOptions)
        assertEquals("Cellular Respiration", result2.matchedAnswer)
        assertEquals(1, result2.matchedOptionIndex)

        val result3 = VoiceAnswerMatcher.matchSpokenTranscript("number 3", sampleOptions)
        assertEquals("Fermentation", result3.matchedAnswer)
        assertEquals(2, result3.matchedOptionIndex)

        val result4 = VoiceAnswerMatcher.matchSpokenTranscript("option 4", sampleOptions)
        assertEquals("Osmosis", result4.matchedAnswer)
        assertEquals(3, result4.matchedOptionIndex)
    }

    @Test
    fun testDirectTextMatching() {
        // Exact text
        val resultExact = VoiceAnswerMatcher.matchSpokenTranscript("Photosynthesis", sampleOptions)
        assertEquals("Photosynthesis", resultExact.matchedAnswer)
        assertEquals(0, resultExact.matchedOptionIndex)

        // Lowercase & trimmed
        val resultLower = VoiceAnswerMatcher.matchSpokenTranscript("cellular respiration", sampleOptions)
        assertEquals("Cellular Respiration", resultLower.matchedAnswer)
        assertEquals(1, resultLower.matchedOptionIndex)

        // Substring / conversational: "I think it is osmosis"
        val resultSentence = VoiceAnswerMatcher.matchSpokenTranscript("i think it is osmosis", sampleOptions)
        assertEquals("Osmosis", resultSentence.matchedAnswer)
        assertEquals(3, resultSentence.matchedOptionIndex)
    }

    @Test
    fun testTrueFalseShortcuts() {
        val tfOptions = listOf("True", "False")

        val resultTrue = VoiceAnswerMatcher.matchSpokenTranscript("true", tfOptions)
        assertEquals("True", resultTrue.matchedAnswer)

        val resultYes = VoiceAnswerMatcher.matchSpokenTranscript("yes, correct", tfOptions)
        assertEquals("True", resultYes.matchedAnswer)

        val resultFalse = VoiceAnswerMatcher.matchSpokenTranscript("false", tfOptions)
        assertEquals("False", resultFalse.matchedAnswer)

        val resultNo = VoiceAnswerMatcher.matchSpokenTranscript("no", tfOptions)
        assertEquals("False", resultNo.matchedAnswer)
    }

    @Test
    fun testVoiceCommands() {
        val submitCmd = VoiceAnswerMatcher.matchSpokenTranscript("Submit answer", sampleOptions)
        assertTrue(submitCmd.isCommand)
        assertEquals(VoiceCommandType.SUBMIT, submitCmd.commandType)

        val clearCmd = VoiceAnswerMatcher.matchSpokenTranscript("clear answer", sampleOptions)
        assertTrue(clearCmd.isCommand)
        assertEquals(VoiceCommandType.CLEAR, clearCmd.commandType)

        val nextCmd = VoiceAnswerMatcher.matchSpokenTranscript("next question", sampleOptions)
        assertTrue(nextCmd.isCommand)
        assertEquals(VoiceCommandType.NEXT, nextCmd.commandType)
    }

    @Test
    fun testUnmatchedSpeechFeedback() {
        val unmatched = VoiceAnswerMatcher.matchSpokenTranscript("completely unrelated gibberish xyz", sampleOptions)
        assertNull(unmatched.matchedAnswer)
        assertEquals(0f, unmatched.confidence, 0.001f)
        assertTrue(unmatched.feedbackMessage.contains("no matching option was found"))
    }
}
