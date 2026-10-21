package com.example.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Model representing a pre-defined student avatar illustration.
 */
data class StudentAvatarIllustration(
    val id: String,
    val name: String,
    val title: String,
    val description: String,
    val emoji: String,
    val secondaryEmoji: String,
    val category: String,
    val primaryColorHex: Long,
    val gradientColors: List<Long>,
    val badgeLabel: String
)

/**
 * Pre-defined set of illustrated character avatars for students.
 */
object AvatarCatalog {

    val allAvatars: List<StudentAvatarIllustration> = listOf(
        StudentAvatarIllustration(
            id = "avatar_astro_explorer",
            name = "Astro Nova",
            title = "Cosmic Explorer",
            description = "Reaches for distant stars, astrophysics, and orbital wonders.",
            emoji = "🚀",
            secondaryEmoji = "🌌",
            category = "Space & Physics",
            primaryColorHex = 0xFF6366F1, // Indigo
            gradientColors = listOf(0xFF4F46E5, 0xFF818CF8, 0xFFC7D2FE),
            badgeLabel = "Star Voyager"
        ),
        StudentAvatarIllustration(
            id = "avatar_coding_wizard",
            name = "Byte Spark",
            title = "Logic Wizard",
            description = "Constructs smart algorithms, loops, and digital magic.",
            emoji = "⚡",
            secondaryEmoji = "💻",
            category = "Tech & Logic",
            primaryColorHex = 0xFF0EA5E9, // Sky blue
            gradientColors = listOf(0xFF0284C7, 0xFF38BDF8, 0xFFBAE6FD),
            badgeLabel = "Code Prodigy"
        ),
        StudentAvatarIllustration(
            id = "avatar_nature_scholar",
            name = "Leafy Sage",
            title = "Eco Naturalist",
            description = "Discovers botanical wonders, ecosystems, and animal biology.",
            emoji = "🌿",
            secondaryEmoji = "🦋",
            category = "Earth & Bio",
            primaryColorHex = 0xFF10B981, // Emerald
            gradientColors = listOf(0xFF059669, 0xFF34D399, 0xFFA7F3D0),
            badgeLabel = "Earth Scholar"
        ),
        StudentAvatarIllustration(
            id = "avatar_math_whiz",
            name = "Pi Dynamo",
            title = "Geometry Master",
            description = "Cracks algebraic puzzles and geometry formulas with speed.",
            emoji = "📐",
            secondaryEmoji = "🔢",
            category = "Mathematics",
            primaryColorHex = 0xFFF59E0B, // Amber
            gradientColors = listOf(0xFFD97706, 0xFFFBBF24, 0xFFFDE68A),
            badgeLabel = "Number Ace"
        ),
        StudentAvatarIllustration(
            id = "avatar_creative_artist",
            name = "Color Muse",
            title = "Creative Maestro",
            description = "Brings vivid ideas to life through design, color, and storytelling.",
            emoji = "🎨",
            secondaryEmoji = "✨",
            category = "Arts & Design",
            primaryColorHex = 0xFFEC4899, // Pink
            gradientColors = listOf(0xFFDB2777, 0xFFF472B6, 0xFFFBCFE8),
            badgeLabel = "Visionary"
        ),
        StudentAvatarIllustration(
            id = "avatar_history_champ",
            name = "Chronos Quest",
            title = "Time Historian",
            description = "Explores ancient dynasties, monuments, and world civilization.",
            emoji = "🏛️",
            secondaryEmoji = "📜",
            category = "History & Culture",
            primaryColorHex = 0xFF8B5CF6, // Purple
            gradientColors = listOf(0xFF7C3AED, 0xFFA78BFA, 0xFFDDD6FE),
            badgeLabel = "Heritage Master"
        ),
        StudentAvatarIllustration(
            id = "avatar_robotics_builder",
            name = "Robo Gizmo",
            title = "Robotics Engineer",
            description = "Invents automated rovers, gadgets, and scientific mechanisms.",
            emoji = "🤖",
            secondaryEmoji = "⚙️",
            category = "Engineering",
            primaryColorHex = 0xFF14B8A6, // Teal
            gradientColors = listOf(0xFF0D9488, 0xFF2DD4BF, 0xFF99F6E4),
            badgeLabel = "Innovator"
        ),
        StudentAvatarIllustration(
            id = "avatar_literature_owl",
            name = "Athena Book",
            title = "Wisdom Owl",
            description = "Reads deep philosophies, languages, poems, and grammar.",
            emoji = "🦉",
            secondaryEmoji = "📖",
            category = "Literature",
            primaryColorHex = 0xFFF97316, // Orange
            gradientColors = listOf(0xFFEA580C, 0xFFFB923C, 0xFFFED7AA),
            badgeLabel = "Bookworm"
        ),
        StudentAvatarIllustration(
            id = "avatar_champion_athlete",
            name = "Apex Champion",
            title = "Quiz Olympian",
            description = "Excels at high-speed answers with determination and grit.",
            emoji = "🏆",
            secondaryEmoji = "🔥",
            category = "Athletics & Grit",
            primaryColorHex = 0xFFEF4444, // Red
            gradientColors = listOf(0xFFDC2626, 0xFFF87171, 0xFFFECACA),
            badgeLabel = "Grand Master"
        )
    )

    fun getAvatarById(id: String?): StudentAvatarIllustration {
        return allAvatars.firstOrNull { it.id == id } ?: allAvatars.first()
    }
}

/**
 * Reusable illustration badge for displaying the avatar with custom borders & gradients.
 */
@Composable
fun StudentAvatarBadge(
    avatar: StudentAvatarIllustration,
    size: Dp = 56.dp,
    showRing: Boolean = true,
    modifier: Modifier = Modifier
) {
    val gradientBrush = Brush.linearGradient(
        avatar.gradientColors.map { Color(it) }
    )

    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(gradientBrush)
            .then(
                if (showRing) {
                    Modifier.border(2.dp, Color.White.copy(alpha = 0.8f), CircleShape)
                } else Modifier
            ),
        contentAlignment = Alignment.Center
    ) {
        val fontSize = (size.value * 0.48f).sp
        Text(
            text = avatar.emoji,
            fontSize = fontSize,
            lineHeight = fontSize
        )
    }
}
