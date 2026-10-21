package com.example.data

/**
 * Categories for grouping student badges and achievements.
 */
enum class BadgeCategory(val title: String, val icon: String) {
    ALL("All", "⭐"),
    MASTERY("Mastery", "🏆"),
    PERFECT("Accuracy", "🎯"),
    SPEED("Speed", "⚡"),
    STREAK("Consistency", "🔥"),
    SUBJECT("Subject", "📚")
}

/**
 * Calculated progress status for a badge.
 */
data class BadgeProgress(
    val current: Int,
    val target: Int,
    val progressFraction: Float,
    val progressText: String,
    val isUnlocked: Boolean
)

/**
 * Definition of an achievement badge with unlocking evaluation logic.
 */
data class BadgeDefinition(
    val id: String,
    val title: String,
    val description: String,
    val criteria: String,
    val emoji: String,
    val category: BadgeCategory,
    val rarity: String, // "Common", "Rare", "Epic", "Legendary"
    val colorHex: Long,
    val xpReward: Int,
    val evaluate: (UserProfile, List<UnitProgress>) -> BadgeProgress
)

/**
 * Global repository of merit badges, criteria rules and rewards.
 */
object BadgeSystem {
    val allBadges: List<BadgeDefinition> = listOf(
        BadgeDefinition(
            id = "quiz_master",
            title = "Quiz Master",
            description = "Consistently master school subjects and accumulate high learning experience.",
            criteria = "Earn at least 1,000 XP through quizzes and learning",
            emoji = "👑",
            category = BadgeCategory.MASTERY,
            rarity = "Legendary",
            colorHex = 0xFFFFB300, // Gold / Amber
            xpReward = 150,
            evaluate = { profile, _ ->
                val current = profile.xp
                val target = 1000
                BadgeProgress(
                    current = current,
                    target = target,
                    progressFraction = (current.toFloat() / target).coerceIn(0f, 1f),
                    progressText = "$current / $target XP",
                    isUnlocked = current >= target
                )
            }
        ),
        BadgeDefinition(
            id = "perfect_score",
            title = "Perfect Score",
            description = "Achieve 100% precision in a unit test or earn over 40 stars.",
            criteria = "Score 100% on any chapter quiz or earn 40+ stars",
            emoji = "🎯",
            category = BadgeCategory.PERFECT,
            rarity = "Epic",
            colorHex = 0xFF10B981, // Emerald Green
            xpReward = 100,
            evaluate = { profile, progressList ->
                val has100Percent = progressList.any { it.progress >= 100 }
                val has40Stars = profile.stars >= 40
                val unlocked = has100Percent || has40Stars
                val current = if (has100Percent) 40 else profile.stars.coerceAtMost(40)
                BadgeProgress(
                    current = current,
                    target = 40,
                    progressFraction = if (unlocked) 1f else (current.toFloat() / 40f).coerceIn(0f, 1f),
                    progressText = if (unlocked) "100% Achieved" else "$current / 40 Stars",
                    isUnlocked = unlocked
                )
            }
        ),
        BadgeDefinition(
            id = "speed_demon",
            title = "Speed Demon",
            description = "Quick reflexes and rapid problem solving across chapters.",
            criteria = "Complete at least 3 quiz units with active participation",
            emoji = "⚡",
            category = BadgeCategory.SPEED,
            rarity = "Rare",
            colorHex = 0xFFF59E0B, // Amber / Lightning
            xpReward = 75,
            evaluate = { _, progressList ->
                val completedUnits = progressList.count { it.progress > 0 }
                val target = 3
                BadgeProgress(
                    current = completedUnits,
                    target = target,
                    progressFraction = (completedUnits.toFloat() / target).coerceIn(0f, 1f),
                    progressText = "$completedUnits / $target Units",
                    isUnlocked = completedUnits >= target
                )
            }
        ),
        BadgeDefinition(
            id = "streak_champion",
            title = "Streak Champion",
            description = "Show steadfast daily commitment to your learning journey.",
            criteria = "Maintain an attendance streak of 5 or more days",
            emoji = "🔥",
            category = BadgeCategory.STREAK,
            rarity = "Epic",
            colorHex = 0xFFEA580C, // Flame Orange
            xpReward = 100,
            evaluate = { profile, _ ->
                val current = profile.attendanceStreak
                val target = 5
                BadgeProgress(
                    current = current,
                    target = target,
                    progressFraction = (current.toFloat() / target).coerceIn(0f, 1f),
                    progressText = "$current / $target Days",
                    isUnlocked = current >= target
                )
            }
        ),
        BadgeDefinition(
            id = "math_wizard",
            title = "Math Wizard",
            description = "Solve mathematical problems, arithmetic, and geometric puzzles.",
            criteria = "Attempt and score in any Mathematics unit",
            emoji = "📐",
            category = BadgeCategory.SUBJECT,
            rarity = "Rare",
            colorHex = 0xFFEF4444, // Red
            xpReward = 50,
            evaluate = { _, progressList ->
                val mathProgress = progressList.find { it.subjectId == "math" && it.progress > 0 }
                val score = mathProgress?.progress ?: 0
                BadgeProgress(
                    current = score,
                    target = 50,
                    progressFraction = (score.toFloat() / 50f).coerceIn(0f, 1f),
                    progressText = if (score > 0) "$score% Score" else "0 / 1 Units",
                    isUnlocked = score > 0
                )
            }
        ),
        BadgeDefinition(
            id = "science_prodigy",
            title = "Science Prodigy",
            description = "Explore scientific inquiry, physics, biology, and chemistry chapters.",
            criteria = "Attempt and score in any Science unit",
            emoji = "🔬",
            category = BadgeCategory.SUBJECT,
            rarity = "Rare",
            colorHex = 0xFF8B5CF6, // Purple
            xpReward = 50,
            evaluate = { _, progressList ->
                val scienceProgress = progressList.find { it.subjectId == "science" && it.progress > 0 }
                val score = scienceProgress?.progress ?: 0
                BadgeProgress(
                    current = score,
                    target = 50,
                    progressFraction = (score.toFloat() / 50f).coerceIn(0f, 1f),
                    progressText = if (score > 0) "$score% Score" else "0 / 1 Units",
                    isUnlocked = score > 0
                )
            }
        ),
        BadgeDefinition(
            id = "language_ace",
            title = "Language Ace",
            description = "Master vernacular literature, grammar, and comprehension.",
            criteria = "Complete a Kannada, English, or Hindi unit quiz",
            emoji = "📖",
            category = BadgeCategory.SUBJECT,
            rarity = "Common",
            colorHex = 0xFF3B82F6, // Blue
            xpReward = 50,
            evaluate = { _, progressList ->
                val langAttempt = progressList.any { 
                    (it.subjectId == "kannada" || it.subjectId == "english" || it.subjectId == "hindi") && it.progress > 0 
                }
                BadgeProgress(
                    current = if (langAttempt) 1 else 0,
                    target = 1,
                    progressFraction = if (langAttempt) 1f else 0f,
                    progressText = if (langAttempt) "1 / 1 Units" else "0 / 1 Units",
                    isUnlocked = langAttempt
                )
            }
        ),
        BadgeDefinition(
            id = "coin_hoarder",
            title = "Treasure Collector",
            description = "Save up school rewards and accumulate golden study coins.",
            criteria = "Accumulate 200 or more golden coins",
            emoji = "💰",
            category = BadgeCategory.MASTERY,
            rarity = "Common",
            colorHex = 0xFFEAB308, // Gold
            xpReward = 40,
            evaluate = { profile, _ ->
                val current = profile.coins
                val target = 200
                BadgeProgress(
                    current = current,
                    target = target,
                    progressFraction = (current.toFloat() / target).coerceIn(0f, 1f),
                    progressText = "$current / $target Coins",
                    isUnlocked = current >= target
                )
            }
        ),
        BadgeDefinition(
            id = "grand_scholar",
            title = "Grand Scholar",
            description = "Elite achievement for all-round academic excellence across the curriculum.",
            criteria = "Reach 1,200+ XP and maintain 30+ stars",
            emoji = "🎓",
            category = BadgeCategory.MASTERY,
            rarity = "Legendary",
            colorHex = 0xFF6366F1, // Indigo
            xpReward = 200,
            evaluate = { profile, _ ->
                val xpOk = profile.xp >= 1200
                val starsOk = profile.stars >= 30
                val unlocked = xpOk && starsOk
                val prog = ((profile.xp.toFloat() / 1200f).coerceIn(0f, 1f) + (profile.stars.toFloat() / 30f).coerceIn(0f, 1f)) / 2f
                BadgeProgress(
                    current = profile.xp,
                    target = 1200,
                    progressFraction = if (unlocked) 1f else prog,
                    progressText = if (unlocked) "Mastered" else "${profile.xp}/1200 XP",
                    isUnlocked = unlocked
                )
            }
        )
    )
}
