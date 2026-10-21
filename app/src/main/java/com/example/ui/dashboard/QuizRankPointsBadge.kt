package com.example.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.QuizRankInfo
import com.example.data.QuizRankTier

/**
 * Compact Quiz Rank and Total Points Pill Badge for student headers and quick views.
 */
@Composable
fun QuizRankCompactBadge(
    rankInfo: QuizRankInfo,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val tierColor = Color(rankInfo.badgeColorHex)

    Surface(
        modifier = modifier
            .testTag("quiz_rank_compact_badge")
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier),
        shape = RoundedCornerShape(12.dp),
        color = tierColor.copy(alpha = 0.14f),
        border = BorderStroke(1.dp, tierColor.copy(alpha = 0.4f))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = rankInfo.badgeEmoji, fontSize = 13.sp)
            Text(
                text = rankInfo.rankTitle,
                fontSize = 11.sp,
                fontWeight = FontWeight.ExtraBold,
                color = tierColor
            )
            Text(
                text = "•",
                fontSize = 11.sp,
                color = tierColor.copy(alpha = 0.6f)
            )
            Text(
                text = "${rankInfo.totalPoints} pts",
                fontSize = 11.sp,
                fontWeight = FontWeight.Black,
                color = tierColor
            )
        }
    }
}

/**
 * Prominent Quiz Rank & Total Points Showcase Card for the Student Dashboard Overview.
 */
@Composable
fun QuizRankPointsShowcaseCard(
    rankInfo: QuizRankInfo,
    isDark: Boolean,
    cardBorder: BorderStroke,
    modifier: Modifier = Modifier
) {
    var showTiersDialog by remember { mutableStateOf(false) }
    val tierColor = Color(rankInfo.badgeColorHex)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("quiz_rank_showcase_card"),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E1B4B) else Color(0xFFEEF2FF)
        ),
        border = BorderStroke(1.5.dp, tierColor.copy(alpha = 0.5f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header Row: Badge Emoji, Rank Title, and Total Points
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(tierColor.copy(alpha = 0.2f))
                            .border(2.dp, tierColor, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = rankInfo.badgeEmoji, fontSize = 24.sp)
                    }

                    Column(modifier = Modifier.weight(1f, fill = false)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = rankInfo.rankTitle,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Black,
                                color = tierColor,
                                modifier = Modifier.testTag("quiz_rank_badge_title")
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Badge(
                                containerColor = tierColor,
                                contentColor = Color.White
                            ) {
                                Text("Rank", fontSize = 9.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                        Text(
                            text = "Reward: 10 pts per correct answer",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 2,
                            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.width(10.dp))

                // Total Points Counter Display
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "${rankInfo.totalPoints}",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Black,
                        color = tierColor,
                        modifier = Modifier.testTag("total_points_badge_value")
                    )
                    Text(
                        text = "Total Points",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Progress Bar to Next Rank
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (rankInfo.nextRankTitle != null) {
                            "Next: ${rankInfo.nextRankTitle}"
                        } else {
                            "Highest Rank Achieved! 🏆"
                        },
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f, fill = false),
                        maxLines = 1,
                        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    )

                    if (rankInfo.nextRankTitle != null) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${rankInfo.pointsToNextRank} pts needed",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = tierColor
                        )
                    }
                }

                LinearProgressIndicator(
                    progress = { rankInfo.progressFraction },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .testTag("rank_progress_bar"),
                    color = tierColor,
                    trackColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                )
            }

            // Footer Strip: Bonus Point Tip & View All Tiers Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🌟 +50 pts bonus for perfect quizzes!",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (isDark) Color(0xFFFCD34D) else Color(0xFFB45309),
                    modifier = Modifier.weight(1f),
                    maxLines = 2,
                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.width(8.dp))

                TextButton(
                    onClick = { showTiersDialog = true },
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                    modifier = Modifier.testTag("view_rank_tiers_button")
                ) {
                    Text(
                        text = "View Rank Tiers ›",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = tierColor
                    )
                }
            }
        }
    }

    // Dialog showing all Quiz Rank Tiers
    if (showTiersDialog) {
        AlertDialog(
            onDismissRequest = { showTiersDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("🏆 Quiz Rank Tiers", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Earn 10 points for every correct question answered, plus 50 points bonus for perfect quizzes to climb the student ranks:",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    QuizRankTier.entries.forEach { tier ->
                        val isCurrent = tier == rankInfo.tier
                        val color = Color(tier.colorHex)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (isCurrent) color.copy(alpha = 0.15f) else Color.Transparent)
                                .border(
                                    width = if (isCurrent) 1.5.dp else 0.dp,
                                    color = if (isCurrent) color else Color.Transparent,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(text = tier.badgeEmoji, fontSize = 20.sp)
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = tier.title,
                                            fontWeight = if (isCurrent) FontWeight.Black else FontWeight.Bold,
                                            fontSize = 13.sp,
                                            color = if (isCurrent) color else MaterialTheme.colorScheme.onSurface
                                        )
                                        if (isCurrent) {
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Badge(containerColor = color, contentColor = Color.White) {
                                                Text("You", fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                            }
                                        }
                                    }
                                    Text(
                                        text = if (tier.maxPoints == Int.MAX_VALUE) "${tier.minPoints}+ pts"
                                        else "${tier.minPoints} – ${tier.maxPoints} pts",
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = { showTiersDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = tierColor)
                ) {
                    Text("Got it")
                }
            }
        )
    }
}
