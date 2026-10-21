package com.example.ui.quiz

import java.util.Locale

/**
 * Result of attempting to match a spoken transcript to quiz options or commands.
 */
data class VoiceMatchResult(
    val spokenTranscript: String,
    val matchedAnswer: String? = null,
    val matchedOptionIndex: Int? = null,
    val confidence: Float = 0f,
    val isCommand: Boolean = false,
    val commandType: VoiceCommandType? = null,
    val feedbackMessage: String = ""
)

enum class VoiceCommandType {
    SUBMIT,
    CLEAR,
    NEXT
}

/**
 * Robust natural speech matching engine for quiz answers.
 * Supports letter choices ("A", "Option B"), positional choices ("First one", "Option 2"),
 * boolean choices ("True", "False"), exact/fuzzy text matching, and voice control commands.
 */
object VoiceAnswerMatcher {

    private val numberWordToDigit = mapOf(
        "one" to 1, "first" to 1, "1st" to 1,
        "two" to 2, "second" to 2, "2nd" to 2,
        "three" to 3, "third" to 3, "3rd" to 3,
        "four" to 4, "fourth" to 4, "4th" to 4,
        "five" to 5, "fifth" to 5, "5th" to 5,
        "six" to 6, "sixth" to 6, "6th" to 6
    )

    private val letterNames = mapOf(
        "a" to 0, "ay" to 0, "alpha" to 0,
        "b" to 1, "bee" to 1, "bravo" to 1, "be" to 1,
        "c" to 2, "see" to 2, "sea" to 2, "charlie" to 2,
        "d" to 3, "dee" to 3, "delta" to 3,
        "e" to 4, "echo" to 4,
        "f" to 5, "foxtrot" to 5
    )

    /**
     * Parses the spoken transcript and matches against the available options.
     */
    fun matchSpokenTranscript(
        rawTranscript: String,
        options: List<String>,
        allowCommands: Boolean = true
    ): VoiceMatchResult {
        val transcript = rawTranscript.trim().lowercase(Locale.ROOT)
            .replace(Regex("[.,!?;:]"), "")
            .trim()

        if (transcript.isEmpty()) {
            return VoiceMatchResult(
                spokenTranscript = rawTranscript,
                feedbackMessage = "No speech detected. Please try speaking again."
            )
        }

        // 1. Check for Voice Commands
        if (allowCommands) {
            when {
                transcript in listOf("submit", "submit answer", "confirm", "lock in", "done", "enter") ||
                        transcript.startsWith("submit") -> {
                    return VoiceMatchResult(
                        spokenTranscript = rawTranscript,
                        isCommand = true,
                        commandType = VoiceCommandType.SUBMIT,
                        confidence = 1.0f,
                        feedbackMessage = "Command recognized: Submitting answer."
                    )
                }
                transcript in listOf("next", "next question", "continue", "skip") -> {
                    return VoiceMatchResult(
                        spokenTranscript = rawTranscript,
                        isCommand = true,
                        commandType = VoiceCommandType.NEXT,
                        confidence = 1.0f,
                        feedbackMessage = "Command recognized: Going to next question."
                    )
                }
                transcript in listOf("clear", "clear answer", "reset", "deselect") -> {
                    return VoiceMatchResult(
                        spokenTranscript = rawTranscript,
                        isCommand = true,
                        commandType = VoiceCommandType.CLEAR,
                        confidence = 1.0f,
                        feedbackMessage = "Command recognized: Cleared selection."
                    )
                }
            }
        }

        if (options.isEmpty()) {
            return VoiceMatchResult(
                spokenTranscript = rawTranscript,
                matchedAnswer = rawTranscript.trim(),
                confidence = 0.8f,
                feedbackMessage = "Recorded speech as answer: \"${rawTranscript.trim()}\""
            )
        }

        // 2. Direct Exact Option Text Match
        options.forEachIndexed { idx, opt ->
            val cleanOpt = opt.trim().lowercase(Locale.ROOT).replace(Regex("[.,!?;:]"), "")
            if (cleanOpt == transcript) {
                val letterChar = ('A' + idx)
                return VoiceMatchResult(
                    spokenTranscript = rawTranscript,
                    matchedAnswer = options[idx],
                    matchedOptionIndex = idx,
                    confidence = 1.0f,
                    feedbackMessage = "Matched Option $letterChar: \"${options[idx]}\""
                )
            }
        }

        // 3. Check for True / False shortcuts
        val isTrueFalseQuestion = options.size == 2 &&
                options.any { it.equals("True", ignoreCase = true) } &&
                options.any { it.equals("False", ignoreCase = true) }

        if (isTrueFalseQuestion) {
            val trueOption = options.firstOrNull { it.equals("True", ignoreCase = true) } ?: "True"
            val falseOption = options.firstOrNull { it.equals("False", ignoreCase = true) } ?: "False"

            val trueKeywords = listOf("true", "yes", "correct", "right", "agree", "it's true", "its true")
            val falseKeywords = listOf("false", "no", "incorrect", "wrong", "disagree", "it's false", "its false")

            if (trueKeywords.any { transcript == it || transcript.startsWith("$it ") || transcript.endsWith(" $it") }) {
                val idx = options.indexOf(trueOption)
                return VoiceMatchResult(
                    spokenTranscript = rawTranscript,
                    matchedAnswer = trueOption,
                    matchedOptionIndex = idx,
                    confidence = 0.98f,
                    feedbackMessage = "Selected \"$trueOption\" from speech."
                )
            }
            if (falseKeywords.any { transcript == it || transcript.startsWith("$it ") || transcript.endsWith(" $it") }) {
                val idx = options.indexOf(falseOption)
                return VoiceMatchResult(
                    spokenTranscript = rawTranscript,
                    matchedAnswer = falseOption,
                    matchedOptionIndex = idx,
                    confidence = 0.98f,
                    feedbackMessage = "Selected \"$falseOption\" from speech."
                )
            }
        }

        // 4. Check for explicit letter indicators: "Option A", "Choice B", "Letter C", or lone "A"
        val optionLetterMatch = Regex("""\b(?:option|choice|letter|answer)\s+([a-f])\b""").find(transcript)
            ?: Regex("""^(?:it's\s+|its\s+|i\s+choose\s+|choose\s+|pick\s+)?([a-f])$""").find(transcript)

        if (optionLetterMatch != null) {
            val letter = optionLetterMatch.groupValues[1]
            val index = letter[0] - 'a'
            if (index in options.indices) {
                return VoiceMatchResult(
                    spokenTranscript = rawTranscript,
                    matchedAnswer = options[index],
                    matchedOptionIndex = index,
                    confidence = 0.95f,
                    feedbackMessage = "Selected Option ${letter.uppercase()}: \"${options[index]}\""
                )
            }
        }

        // Check phonetic letter names only when phrase is short (e.g., "ay", "see", "option bee")
        val tokens = transcript.split("\\s+".toRegex())
        if (tokens.size <= 2) {
            for (token in tokens) {
                val letterIdx = letterNames[token]
                if (letterIdx != null && letterIdx in options.indices) {
                    val letterChar = ('A' + letterIdx)
                    return VoiceMatchResult(
                        spokenTranscript = rawTranscript,
                        matchedAnswer = options[letterIdx],
                        matchedOptionIndex = letterIdx,
                        confidence = 0.90f,
                        feedbackMessage = "Selected Option $letterChar: \"${options[letterIdx]}\""
                    )
                }
            }
        }

        // 5. Check for positional indicators: "first option", "second one", "third", "option 1"
        val ordinalList = listOf(
            "first" to 1, "1st" to 1,
            "second" to 2, "2nd" to 2, "two" to 2,
            "third" to 3, "3rd" to 3, "three" to 3,
            "fourth" to 4, "4th" to 4, "four" to 4,
            "fifth" to 5, "5th" to 5, "five" to 5,
            "sixth" to 6, "6th" to 6, "six" to 6
        )
        for ((word, num) in ordinalList) {
            val wordPattern = Regex("""\b${Regex.escape(word)}\b""")
            if (wordPattern.containsMatchIn(transcript)) {
                val targetIndex = num - 1
                if (targetIndex in options.indices) {
                    val letterChar = ('A' + targetIndex)
                    return VoiceMatchResult(
                        spokenTranscript = rawTranscript,
                        matchedAnswer = options[targetIndex],
                        matchedOptionIndex = targetIndex,
                        confidence = 0.90f,
                        feedbackMessage = "Selected Option $letterChar ($word): \"${options[targetIndex]}\""
                    )
                }
            }
        }

        // Only match "one" if not used as a pronoun following an ordinal (e.g., "second one")
        if (Regex("""\b(?:option|choice|number)\s+one\b|^one$|\bthe\s+one\b""").containsMatchIn(transcript)) {
            if (options.isNotEmpty()) {
                return VoiceMatchResult(
                    spokenTranscript = rawTranscript,
                    matchedAnswer = options[0],
                    matchedOptionIndex = 0,
                    confidence = 0.90f,
                    feedbackMessage = "Selected Option A (one): \"${options[0]}\""
                )
            }
        }

        // Check digit patterns: "option 1", "number 2", or lone "3"
        val digitMatch = Regex("""\b(?:option|choice|number)\s*([1-9])\b""").find(transcript)
            ?: Regex("""^([1-9])$""").find(transcript)

        if (digitMatch != null) {
            val num = digitMatch.groupValues[1].toIntOrNull()
            if (num != null && (num - 1) in options.indices) {
                val index = num - 1
                val letterChar = ('A' + index)
                return VoiceMatchResult(
                    spokenTranscript = rawTranscript,
                    matchedAnswer = options[index],
                    matchedOptionIndex = index,
                    confidence = 0.92f,
                    feedbackMessage = "Selected Option $letterChar (#$num): \"${options[index]}\""
                )
            }
        }

        // 6. Direct Option Text Matching (Substring & Fuzzy)
        var bestOptionIndex: Int? = null
        var bestScore = 0f

        options.forEachIndexed { idx, opt ->
            val cleanOpt = opt.trim().lowercase(Locale.ROOT).replace(Regex("[.,!?;:]"), "")
            when {
                // Option text is contained inside transcript (e.g. "I think it is osmosis")
                transcript.contains(cleanOpt) && cleanOpt.length >= 3 -> {
                    val score = (cleanOpt.length.toFloat() / transcript.length.toFloat()).coerceIn(0.7f, 0.95f)
                    if (score > bestScore) {
                        bestScore = score
                        bestOptionIndex = idx
                    }
                }
                // Spoken transcript is contained in option text
                cleanOpt.contains(transcript) && transcript.length >= 3 -> {
                    val score = (transcript.length.toFloat() / cleanOpt.length.toFloat()).coerceIn(0.6f, 0.90f)
                    if (score > bestScore) {
                        bestScore = score
                        bestOptionIndex = idx
                    }
                }
                // Token overlap similarity
                else -> {
                    val optTokens = cleanOpt.split("\\s+".toRegex()).filter { it.length > 2 }.toSet()
                    val transTokens = transcript.split("\\s+".toRegex()).filter { it.length > 2 }.toSet()
                    if (optTokens.isNotEmpty() && transTokens.isNotEmpty()) {
                        val intersection = optTokens.intersect(transTokens).size
                        val jaccard = intersection.toFloat() / (optTokens.union(transTokens).size.toFloat())
                        if (jaccard >= 0.5f && jaccard > bestScore) {
                            bestScore = jaccard
                            bestOptionIndex = idx
                        }
                    }
                }
            }
        }

        if (bestOptionIndex != null && bestScore >= 0.4f) {
            val idx = bestOptionIndex!!
            val letterChar = ('A' + idx)
            return VoiceMatchResult(
                spokenTranscript = rawTranscript,
                matchedAnswer = options[idx],
                matchedOptionIndex = idx,
                confidence = bestScore,
                feedbackMessage = "Matched Option $letterChar: \"${options[idx]}\""
            )
        }

        // If no match could be found with high confidence
        return VoiceMatchResult(
            spokenTranscript = rawTranscript,
            matchedAnswer = null,
            matchedOptionIndex = null,
            confidence = 0f,
            feedbackMessage = "Heard \"$rawTranscript\", but no matching option was found. Try saying \"Option A\", \"True\", or the answer text."
        )
    }
}
