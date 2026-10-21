package com.example.ui.battle

import com.example.data.QuestionModel

data class BattleOpponent(
    val id: String,
    val name: String,
    val school: String,
    val avatar: String,
    val standard: Int,
    val winRate: Int,
    val accuracy: Float, // 0.0 to 1.0
    val responseSpeedRangeMs: LongRange = 2500L..7000L
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
    val opponentRoundScore: Int
)

data class BattleArenaState(
    val stage: BattleStage = BattleStage.LOBBY,
    val selectedSubject: String = "mixed", // "math", "science", "english", "kannada", "social", "hindi", "mixed"
    val opponent: BattleOpponent? = null,
    val questions: List<QuestionModel> = emptyList(),
    val currentRoundIndex: Int = 0,
    val roundSecondsRemaining: Int = 15,
    val userScore: Int = 0,
    val opponentScore: Int = 0,
    val userSelectedAnswer: String = "",
    val opponentSelectedAnswer: String = "",
    val userStreak: Int = 0,
    val opponentStreak: Int = 0,
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
}
