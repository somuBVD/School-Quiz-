package com.example.data

/**
 * Detailed level tier information for a student based on Experience Points (XP).
 * Students earn experience points for every correct answer across all quiz modes.
 */
data class StudentLevelInfo(
    val level: Int,
    val title: String,
    val badgeEmoji: String,
    val totalXp: Int,
    val currentLevelMinXp: Int,
    val nextLevelMinXp: Int,
    val xpInCurrentLevel: Int,
    val xpRequiredForNextLevel: Int,
    val progressFraction: Float,
    val colorHex: Long,
    val rankBadge: String,
    val perkDescription: String,
    val nextUnlockTitle: String?
)

/**
 * Progression curve and level calculator for the Student Level System.
 * Students earn Experience Points (XP) for every correct answer.
 */
object StudentLevelSystem {

    const val XP_PER_CORRECT_ANSWER = 25
    const val XP_PERFECT_SCORE_BONUS = 50
    const val XP_SPEED_SPRINT_BONUS = 15

    data class LevelDefinition(
        val level: Int,
        val minXp: Int,
        val title: String,
        val emoji: String,
        val colorHex: Long,
        val perk: String,
        val nextUnlock: String?
    )

    val LEVEL_DEFINITIONS = listOf(
        LevelDefinition(1, 0, "Curious Beginner", "🌱", 0xFF64748B, "Access to all foundational curriculum quizzes", "Level 2: Apprentice Scholar"),
        LevelDefinition(2, 200, "Apprentice Scholar", "🥉", 0xFFCD7F32, "+5% Daily Streak bonus XP booster", "Level 3: Rising Thinker"),
        LevelDefinition(3, 500, "Rising Thinker", "📘", 0xFF3B82F6, "Unlocks custom student avatars & theme accents", "Level 4: Mastermind"),
        LevelDefinition(4, 900, "Mastermind", "🥈", 0xFF94A3B8, "+10% Speed Blitz sprint combo multiplier", "Level 5: Quiz Champion"),
        LevelDefinition(5, 1400, "Quiz Champion", "🥇", 0xFFF59E0B, "Gold level badge & priority challenge queue", "Level 6: Grand Luminary"),
        LevelDefinition(6, 2000, "Grand Luminary", "🔮", 0xFF8B5CF6, "Special celebration victory confetti effects", "Level 7: Diamond Sage"),
        LevelDefinition(7, 2700, "Diamond Sage", "💎", 0xFF06B6D4, "Unlocks rare scholar profile titles & medals", "Level 8: Apex Genius"),
        LevelDefinition(8, 3500, "Apex Genius", "⚡", 0xFFEC4899, "Supercharged XP earning rate & special badge", "Level 9: Legend of Learning"),
        LevelDefinition(9, 4500, "Legend of Learning", "👑", 0xFFEAB308, "Exclusive legendary aura on classroom boards", "Level 10: Supreme Grandmaster"),
        LevelDefinition(10, 6000, "Supreme Grandmaster", "🌌", 0xFF6366F1, "Ultimate mastery status in all academic subjects", null)
    )

    fun calculateLevel(totalXp: Int): StudentLevelInfo {
        val safeXp = totalXp.coerceAtLeast(0)

        // Find current level definition based on XP thresholds
        val currentDef = LEVEL_DEFINITIONS.findLast { safeXp >= it.minXp } ?: LEVEL_DEFINITIONS.first()
        val nextDef = LEVEL_DEFINITIONS.getOrNull(currentDef.level) // Next level (0-indexed vs 1-indexed)

        val currentLevelMin = currentDef.minXp
        val nextLevelMin = nextDef?.minXp ?: (currentLevelMin + 1500)
        val span = (nextLevelMin - currentLevelMin).coerceAtLeast(1)
        val xpInLevel = (safeXp - currentLevelMin).coerceAtLeast(0)
        val needed = (nextLevelMin - safeXp).coerceAtLeast(0)
        val fraction = if (nextDef != null) {
            (xpInLevel.toFloat() / span).coerceIn(0f, 1f)
        } else {
            1.0f
        }

        return StudentLevelInfo(
            level = currentDef.level,
            title = currentDef.title,
            badgeEmoji = currentDef.emoji,
            totalXp = safeXp,
            currentLevelMinXp = currentLevelMin,
            nextLevelMinXp = nextLevelMin,
            xpInCurrentLevel = xpInLevel,
            xpRequiredForNextLevel = needed,
            progressFraction = fraction,
            colorHex = currentDef.colorHex,
            rankBadge = "LVL ${currentDef.level}",
            perkDescription = currentDef.perk,
            nextUnlockTitle = currentDef.nextUnlock
        )
    }
}
