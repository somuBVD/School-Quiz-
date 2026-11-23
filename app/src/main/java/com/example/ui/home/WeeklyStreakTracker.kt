package com.example.ui.home

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.UserProfile
import java.util.Calendar

/**
 * Interactive Weekly Study Streak & Goal Tracker Card.
 * Displays 7-day Mon-Sun activity bubbles, current flame streak,
 * daily XP target progress, and quick action launch pads.
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
    val totalCoins = userProfile?.coins ?: 150
    val totalPoints = userProfile?.totalPoints ?: 350

    // Calendar day of week calculation (0 = Mon, 6 = Sun)
    val calendar = Calendar.getInstance()
    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) // 1 = Sun, 2 = Mon ... 7 = Sat
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

    // Flame scale animation
    val infiniteTransition = rememberInfiniteTransition(label = "flame_pulse")
    val flameScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "flame_scale"
    )

    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0)),
        modifier = modifier
            .fillMaxWidth()
            .testTag("weekly_streak_card")
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Header: Streak Counter & Reward
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "🔥",
                        fontSize = 24.sp,
                        modifier = Modifier.scale(flameScale)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "$currentStreak Day Streak",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Black,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = Color(0xFFFEF3C7)
                            ) {
                                Text(
                                    text = "Active 🔥",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color(0xFFB45309),
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        Text(
                            text = if (currentStreak >= 3) "Superb consistency! Keep practicing daily" else "Complete 1 quiz today to extend your streak",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFEEF2FF)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text("⭐", fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "$totalPoints XP",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFF4338CA)
                        )
                    }
                }
            }

            // 7-Day Visual Calendar Bubbles
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    daysOfWeekLabels.forEachIndexed { index, label ->
                        val isPast = index < currentDayIndex
                        val isToday = index == currentDayIndex
                        val isCompleted = isPast || isToday // completed or active today

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = label,
                                fontSize = 11.sp,
                                fontWeight = if (isToday) FontWeight.Black else FontWeight.Medium,
                                color = if (isToday) Color(0xFF4F46E5) else MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(
                                        when {
                                            isToday -> Color(0xFF4F46E5)
                                            isPast -> Color(0xFF10B981)
                                            else -> Color(0xFFE2E8F0)
                                        }
                                    )
                                    .then(
                                        if (isToday) Modifier.border(2.dp, Color(0xFF818CF8), CircleShape) else Modifier
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                when {
                                    isPast -> Text("✓", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                    isToday -> Text("⚡", fontSize = 14.sp)
                                    else -> Text("•", color = Color(0xFF94A3B8), fontSize = 14.sp)
                                }
                            }
                        }
                    }
                }
            }

            // High-Impact Quick Launch Action Pads
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Mock Exam Launch Pad
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = Color(0xFF4F46E5).copy(alpha = 0.1f),
                    border = BorderStroke(1.dp, Color(0xFF4F46E5).copy(alpha = 0.3f)),
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(14.dp))
                        .clickable { onOpenMockExam() }
                        .testTag("quick_launch_mock_exam")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("📝", fontSize = 18.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Column {
                            Text("Mock Exam", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF4338CA))
                            Text("15m Test", fontSize = 9.sp, color = Color(0xFF6366F1))
                        }
                    }
                }

                // Focus Audio & Study Timer
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = Color(0xFF10B981).copy(alpha = 0.1f),
                    border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.3f)),
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(14.dp))
                        .clickable { onOpenFocusTimer() }
                        .testTag("quick_launch_focus_timer")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("🎧", fontSize = 18.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Column {
                            Text("Focus Audio", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF047857))
                            Text("Ambience", fontSize = 9.sp, color = Color(0xFF10B981))
                        }
                    }
                }

                // Formula Vault Quick Pad
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = Color(0xFFF59E0B).copy(alpha = 0.1f),
                    border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.3f)),
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(14.dp))
                        .clickable { onOpenFormulaVault() }
                        .testTag("quick_launch_formula_vault")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("📐", fontSize = 18.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Column {
                            Text("Formulas", fontSize = 12.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFB45309))
                            Text("Cheatsheet", fontSize = 9.sp, color = Color(0xFFD97706))
                        }
                    }
                }
            }
        }
    }
}
