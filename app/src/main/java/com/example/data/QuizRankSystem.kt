package com.example.data

/**
 * Quiz Rank calculated from total student points earned from correct answers in Room DB.
 */
data class QuizRankInfo(
    val tier: QuizRankTier,
    val totalPoints: Int,
    val rankTitle: String,
    val badgeEmoji: String,
    val badgeColorHex: Long,
    val nextRankTitle: String?,
    val pointsToNextRank: Int,
    val progressFraction: Float
)

/**
 * Quiz Rank Tiers based on total student points earned.
 */
enum class QuizRankTier(
    val title: String,
    val minPoints: Int,
    val maxPoints: Int,
    val badgeEmoji: String,
    val colorHex: Long,
    val nextRankTitle: String?
) {
    NOVICE("Novice Explorer", 0, 499, "🌱", 0xFF64748B, "Bronze Scholar"),
    BRONZE("Bronze Scholar", 500, 999, "🥉", 0xFFCD7F32, "Silver Achiever"),
    SILVER("Silver Achiever", 1000, 1999, "🥈", 0xFF94A3B8, "Gold Master"),
    GOLD("Gold Master", 2000, 3499, "🥇", 0xFFF59E0B, "Diamond Champion"),
    DIAMOND("Diamond Champion", 3500, 4999, "💎", 0xFF06B6D4, "Grandmaster Supreme"),
    GRANDMASTER("Grandmaster Supreme", 5000, Int.MAX_VALUE, "👑", 0xFF8B5CF6, null);

    companion object {
        fun calculateRank(points: Int): QuizRankInfo {
            val tier = entries.findLast { points >= it.minPoints } ?: NOVICE
            val pointsInTier = points - tier.minPoints
            val tierSpan = if (tier.maxPoints == Int.MAX_VALUE) 2000 else (tier.maxPoints - tier.minPoints + 1)
            val progressFraction = (pointsInTier.toFloat() / tierSpan).coerceIn(0f, 1f)
            val pointsNeeded = if (tier.nextRankTitle != null) (tier.maxPoints + 1 - points).coerceAtLeast(0) else 0

            return QuizRankInfo(
                tier = tier,
                totalPoints = points,
                rankTitle = tier.title,
                badgeEmoji = tier.badgeEmoji,
                badgeColorHex = tier.colorHex,
                nextRankTitle = tier.nextRankTitle,
                pointsToNextRank = pointsNeeded,
                progressFraction = progressFraction
            )
        }
    }
}
