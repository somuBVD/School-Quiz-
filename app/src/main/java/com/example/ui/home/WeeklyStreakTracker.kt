package com.example.ui.home

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserProfile
import java.util.Calendar

/**
 * Interactive Weekly Study Streak & Goal Tracker Card.
 * Displays 7-day Mon-Sun activity bubbles, current flame streak,
 * XP badge, and responsive quick-launch tiles without text overflow or overlap.
 */
@Composable
fun WeeklyStreakTrackerCard(
    userProfile: UserProfile?,
    onOpenMockExam: () -> Unit,
    onOpenFocusTimer: () -> Unit,
    onOpenFormulaVault: () -> Unit,
    modifier: Modifier = Modifier
) {
    val currentStreak = userProfile?.attendanceStreak ?: 1
    val totalPoints = userProfile?.totalPoints ?: 350
    val isDark = MaterialTheme.colorScheme.background.red < 0.25f

    // Calendar day of week calculation (0 = Mon, 6 = Sun)
    val calendar = Calendar.getInstance()
    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    val currentDayIndex = when (dayOfWeek) {
        Calendar.MONDAY -> 0
        Calendar.TUESDAY -> 1
        Calendar.WEDNESDAY -> 2
        Calendar.THURSDAY -> 3
        Calendar.FRIDAY -> 4
        Calendar.SATURDAY -> 5
        Calendar.SUNDAY -> 6
        else -> 0
    }

    val daysOfWeekLabels = listOf("M", "T", "W", "T", "F", "S", "S")

    val infiniteTransition = rememberInfiniteTransition(label = "flame_pulse")
    val flameScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.12f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "flame_scale"
    )

    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
        modifier = modifier
            .fillMaxWidth()
            .testTag("weekly_streak_card")
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header: Streak Counter & XP Pill (weighted so they never collide)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "🔥",
                        fontSize = 22.sp,
                        modifier = Modifier.scale(flameScale)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(
                                text = "$currentStreak Day Streak",
                                fontSize = 15.sp,
                                lineHeight = 19.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onSurface,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f, fill = false)
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (isDark) Color(0xFF78350F) else Color(0xFFFEF3C7)
                            ) {
                                Text(
                                    text = "Active",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = if (isDark) Color(0xFFFDE68A) else Color(0xFFB45309),
                                    maxLines = 1,
                                    softWrap = false,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = if (currentStreak >= 3) "Great consistency! Keep practicing daily" else "Complete 1 quiz today to keep your streak",
                            fontSize = 11.sp,
                            lineHeight = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = if (isDark) Color(0xFF312E81) else Color(0xFFEEF2FF)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp)
                    ) {
                        Text("⭐", fontSize = 11.sp)
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = "$totalPoints XP",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color(0xFFC7D2FE) else Color(0xFF4338CA),
                            maxLines = 1,
                            softWrap = false
                        )
                    }
                }
            }

            // 7-Day Visual Calendar Bubbles (evenly weighted so narrow screens never crowd)
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    daysOfWeekLabels.forEachIndexed { index, label ->
                        val isPast = index < currentDayIndex
                        val isToday = index == currentDayIndex

                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = label,
                                fontSize = 10.5.sp,
                                fontWeight = if (isToday) FontWeight.Black else FontWeight.Medium,
                                color = if (isToday) Color(0xFF4F46E5) else MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1,
                                softWrap = false
                            )

                            Box(
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .background(
                                        when {
                                            isToday -> Color(0xFF4F46E5)
                                            isPast -> Color(0xFF10B981)
                                            else -> if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                                        }
                                    )
                                    .then(
                                        if (isToday) Modifier.border(2.dp, Color(0xFF818CF8), CircleShape) else Modifier
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                when {
                                    isPast -> Text("✓", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                    isToday -> Text("⚡", fontSize = 13.sp)
                                    else -> Text("•", color = Color(0xFF94A3B8), fontSize = 13.sp)
                                }
                            }
                        }
                    }
                }
            }

            // Responsive Quick Launch Action Pads (vertical centered tiles prevent text wrapping/clipping)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                QuickLaunchTile(
                    emoji = "📝",
                    title = "Mock Exam",
                    subtitle = "15m Test",
                    accentColor = Color(0xFF4F46E5),
                    titleColor = if (isDark) Color(0xFFC7D2FE) else Color(0xFF4338CA),
                    subtitleColor = if (isDark) Color(0xFFA5B4FC) else Color(0xFF6366F1),
                    onClick = onOpenMockExam,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("quick_launch_mock_exam")
                )

                QuickLaunchTile(
                    emoji = "🎧",
                    title = "Focus Audio",
                    subtitle = "Ambience",
                    accentColor = Color(0xFF10B981),
                    titleColor = if (isDark) Color(0xFFA7F3D0) else Color(0xFF047857),
                    subtitleColor = if (isDark) Color(0xFF6EE7B7) else Color(0xFF10B981),
                    onClick = onOpenFocusTimer,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("quick_launch_focus_timer")
                )

                QuickLaunchTile(
                    emoji = "📐",
                    title = "Formulas",
                    subtitle = "Cheatsheet",
                    accentColor = Color(0xFFF59E0B),
                    titleColor = if (isDark) Color(0xFFFDE68A) else Color(0xFFB45309),
                    subtitleColor = if (isDark) Color(0xFFFCD34D) else Color(0xFFD97706),
                    onClick = onOpenFormulaVault,
                    modifier = Modifier
                        .weight(1f)
                        .testTag("quick_launch_formula_vault")
                )
            }
        }
    }
}

@Composable
private fun QuickLaunchTile(
    emoji: String,
    title: String,
    subtitle: String,
    accentColor: Color,
    titleColor: Color,
    subtitleColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = accentColor.copy(alpha = 0.1f),
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.3f)),
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(text = emoji, fontSize = 18.sp)
            Text(
                text = title,
                fontSize = 11.5.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = titleColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
            Text(
                text = subtitle,
                fontSize = 9.5.sp,
                lineHeight = 12.sp,
                color = subtitleColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }
}
