package com.example.ui.battle

import com.example.data.QuestionModel

enum class BattleStreamMode(
    val displayTitle: String,
    val badgeLabel: String,
    val description: String
) {
    INFINITE(
        displayTitle = "Infinite Stream",
        badgeLabel = "∞ INFINITE",
        description = "Endless quick-fire MCQs with zero delay — cash out anytime"
    ),
    MAX_MARATHON(
        displayTitle = "Max Unique Pool",
        badgeLabel = "MAX MCQs",
        description = "Every unique MCQ in the subject with instant zero-delay flow"
    ),
    BLITZ_60S(
        displayTitle = "60s Turbo Blitz",
        badgeLabel = "60s BLITZ",
        description = "60-second non-stop reflex duel — score as many MCQs as possible"
    )
}

data class BattleOpponent(
    val id: String,
    val name: String,
    val school: String,
    val avatar: String,
    val standard: Int,
    val winRate: Int,
    val accuracy: Float, // 0.0 to 1.0
    val responseSpeedRangeMs: LongRange = 700L..2200L
)

enum class BattleStage {
    LOBBY,
    MATCHMAKING,
    IN_PROGRESS,
    ROUND_REVEAL,
    GAME_OVER
}

data class BattleRoundResult(
    val roundNumber: Int,
    val question: QuestionModel,
    val userSelectedAnswer: String,
    val opponentSelectedAnswer: String,
    val userCorrect: Boolean,
    val opponentCorrect: Boolean,
    val userRoundScore: Int,
    val opponentRoundScore: Int,
    val responseTimeMs: Long = 0L
)

data class BattleInstantFeedback(
    val roundNumber: Int,
    val userCorrect: Boolean,
    val opponentCorrect: Boolean,
    val pointsEarned: Int,
    val speedBonus: Int,
    val responseMs: Long,
    val correctAnswer: String,
    val skipped: Boolean = false,
    val timestampMs: Long = System.currentTimeMillis()
)

data class BattleArenaState(
    val stage: BattleStage = BattleStage.LOBBY,
    val selectedSubject: String = "mixed", // "mixed" or any curriculum / KPSC subjectId
    val streamMode: BattleStreamMode = BattleStreamMode.INFINITE,
    val opponent: BattleOpponent? = null,
    val questions: List<QuestionModel> = emptyList(),
    val uniquePoolSize: Int = 0,
    val availableMcqPreviewCount: Int = 0,
    val currentRoundIndex: Int = 0,
    val roundDurationMs: Long = 8000L,
    val roundTimeRemainingMs: Long = 8000L,
    val roundSecondsRemaining: Int = 8,
    val matchTimeRemainingMs: Long = 60_000L,
    val roundStartedAtMs: Long = 0L,
    val matchStartedAtMs: Long = 0L,
    val userScore: Int = 0,
    val opponentScore: Int = 0,
    val userSelectedAnswer: String = "",
    val opponentSelectedAnswer: String = "",
    val userStreak: Int = 0,
    val maxUserStreak: Int = 0,
    val opponentStreak: Int = 0,
    val totalResponseTimeMs: Long = 0L,
    val lastFeedback: BattleInstantFeedback? = null,
    val roundResults: List<BattleRoundResult> = emptyList(),
    val roomCode: String = "",
    val isSearchingMatch: Boolean = false,
    val isActive: Boolean = false,
    // Real-Time Online Multiplayer Student Attributes
    val isOnlineMatch: Boolean = false,
    val roomId: String = "",
    val isHost: Boolean = false,
    val isWaitingForOnlinePlayer: Boolean = false,
    val onlinePlayerCount: Int = 1,
    val opponentAnswerLocked: Boolean = false,
    val statusMessage: String = "",
    val matchmakingSeconds: Int = 0
) {
    val currentQuestion: QuestionModel?
        get() = questions.getOrNull(currentRoundIndex)

    val totalRounds: Int
        get() = questions.size

    val isUserLeading: Boolean
        get() = userScore > opponentScore

    val isTie: Boolean
        get() = userScore == opponentScore

    val answeredCount: Int
        get() = roundResults.size

    val correctCount: Int
        get() = roundResults.count { it.userCorrect }

    val accuracyPercent: Int
        get() = if (answeredCount > 0) (correctCount * 100) / answeredCount else 0

    val averageResponseMs: Long
        get() = if (answeredCount > 0) totalResponseTimeMs / answeredCount else 0L

    val questionsPerMinute: Int
        get() {
            if (answeredCount == 0 || matchStartedAtMs <= 0L) return 0
            val elapsedMs = (System.currentTimeMillis() - matchStartedAtMs).coerceAtLeast(1000L)
            return ((answeredCount * 60_000L) / elapsedMs).toInt().coerceAtMost(240)
        }
}
