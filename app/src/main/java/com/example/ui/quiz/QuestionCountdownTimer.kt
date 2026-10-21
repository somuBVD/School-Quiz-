package com.example.ui.quiz

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HourglassBottom
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.WarningAmber
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Threshold stages for time taken per question with associated point adjustments.
 */
enum class TimeThresholdZone(
    val title: String,
    val minElapsedSec: Int,
    val maxElapsedSec: Int,
    val penaltyDeduction: Int,
    val speedBonus: Int,
    val colorHex: Long,
    val badgeEmoji: String,
    val label: String,
    val ruleDescription: String
) {
    SPEED_BONUS(
        title = "Speed Bonus",
        minElapsedSec = 0,
        maxElapsedSec = 30,
        penaltyDeduction = 0,
        speedBonus = 15,
        colorHex = 0xFF10B981, // Emerald Green
        badgeEmoji = "⚡",
        label = "+15 Pts Speed Bonus",
        ruleDescription = "Answered in ≤ 30s: +15 bonus points awarded!"
    ),
    STANDARD(
        title = "Standard Pace",
        minElapsedSec = 31,
        maxElapsedSec = 60,
        penaltyDeduction = 0,
        speedBonus = 0,
        colorHex = 0xFF3B82F6, // Blue
        badgeEmoji = "⏱️",
        label = "Full Points (0 penalty)",
        ruleDescription = "Answered in 31-60s: 100% full points, no deduction."
    ),
    THRESHOLD_1_PENALTY(
        title = "Moderate Overtime",
        minElapsedSec = 61,
        maxElapsedSec = 90,
        penaltyDeduction = 20,
        speedBonus = 0,
        colorHex = 0xFFF59E0B, // Amber
        badgeEmoji = "⚠️",
        label = "-20 Pts Overtime Penalty",
        ruleDescription = "Exceeded 60s threshold: 20 points deducted."
    ),
    THRESHOLD_2_PENALTY(
        title = "Critical Overtime",
        minElapsedSec = 91,
        maxElapsedSec = 120,
        penaltyDeduction = 50,
        speedBonus = 0,
        colorHex = 0xFFEF4444, // Red
        badgeEmoji = "🚨",
        label = "-50 Pts Critical Penalty",
        ruleDescription = "Exceeded 90s threshold: 50 points deducted."
    ),
    TIMEOUT(
        title = "Time Expired",
        minElapsedSec = 120,
        maxElapsedSec = Int.MAX_VALUE,
        penaltyDeduction = 100,
        speedBonus = 0,
        colorHex = 0xFF991B1B, // Dark Red
        badgeEmoji = "⌛",
        label = "0 Pts (Timed Out)",
        ruleDescription = "Question timed out: 0 points awarded."
    );

    val shortLabel: String
        get() = when (this) {
            SPEED_BONUS -> "+15 Pts"
            STANDARD -> "Full Pts"
            THRESHOLD_1_PENALTY -> "-20 Pts"
            THRESHOLD_2_PENALTY -> "-50 Pts"
            TIMEOUT -> "0 Pts"
        }

    companion object {
        fun getZoneForElapsed(elapsedSecs: Int): TimeThresholdZone {
            return when {
                elapsedSecs <= 30 -> SPEED_BONUS
                elapsedSecs <= 60 -> STANDARD
                elapsedSecs <= 90 -> THRESHOLD_1_PENALTY
                elapsedSecs < 120 -> THRESHOLD_2_PENALTY
                else -> TIMEOUT
            }
        }

        fun calculateScore(
            isCorrect: Boolean,
            elapsedSecs: Int,
            isTimedOut: Boolean = false,
            basePoints: Int = 100
        ): QuestionScoreResult {
            if (!isCorrect || isTimedOut) {
                val zone = if (isTimedOut) TIMEOUT else getZoneForElapsed(elapsedSecs)
                return QuestionScoreResult(
                    basePoints = basePoints,
                    speedBonus = 0,
                    penaltyDeduction = 0,
                    finalPoints = 0,
                    zone = zone,
                    isCorrect = false
                )
            }

            val zone = getZoneForElapsed(elapsedSecs)
            val penalty = zone.penaltyDeduction
            val bonus = zone.speedBonus
            val finalPoints = maxOf(0, basePoints + bonus - penalty)

            return QuestionScoreResult(
                basePoints = basePoints,
                speedBonus = bonus,
                penaltyDeduction = penalty,
                finalPoints = finalPoints,
                zone = zone,
                isCorrect = true
            )
        }
    }
}

/**
 * Result data holder for score calculation on an answered question.
 */
data class QuestionScoreResult(
    val basePoints: Int,
    val speedBonus: Int,
    val penaltyDeduction: Int,
    val finalPoints: Int,
    val zone: TimeThresholdZone,
    val isCorrect: Boolean
)

/**
 * Detailed per-question record stored during the quiz session.
 */
data class QuestionTimeStat(
    val questionIndex: Int,
    val questionId: String,
    val questionText: String,
    val timeTakenSeconds: Int,
    val totalTimeLimitSeconds: Int = 120,
    val basePoints: Int = 100,
    val speedBonus: Int = 0,
    val penaltyDeduction: Int = 0,
    val finalPoints: Int = 0,
    val isCorrect: Boolean = false,
    val isTimedOut: Boolean = false,
    val zone: TimeThresholdZone = TimeThresholdZone.STANDARD
)

/**
 * Highly polished countdown timer component displayed during active quiz questions.
 * Sleek, compact design that avoids vertical bloat and visual overflow.
 * Supports optional countdown timer mode for flexible student practice.
 */
@Composable
fun QuestionCountdownTimer(
    secondsRemaining: Int,
    totalSeconds: Int = 120,
    isAnswerSubmitted: Boolean,
    isReviewMarked: Boolean = false,
    isTimerEnabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    if (!isTimerEnabled) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .testTag("question_timer_disabled_pill"),
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFFF0FDF4),
            border = BorderStroke(1.dp, Color(0xFFBBF7D0))
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    Text("🌱", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Untimed Practice",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF15803D),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFFDCFCE7)
                ) {
                    Text(
                        text = "Practice ✨",
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF16A34A),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }
        }
        return
    }

    val elapsedSeconds = (totalSeconds - secondsRemaining).coerceIn(0, totalSeconds)
    val currentZone = remember(elapsedSeconds) { TimeThresholdZone.getZoneForElapsed(elapsedSeconds) }
    val zoneColor = Color(currentZone.colorHex)
    val progressFraction = (secondsRemaining.toFloat() / totalSeconds.toFloat()).coerceIn(0f, 1f)

    // Pulsing animation when running low on time (< 10s remaining)
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val pulseScale by if (secondsRemaining <= 10 && !isAnswerSubmitted) {
        infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = 1.05f,
            animationSpec = infiniteRepeatable(
                animation = tween(500, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "pulseScale"
        )
    } else {
        remember { mutableStateOf(1f) }
    }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .testTag("question_countdown_timer"),
        shape = RoundedCornerShape(12.dp),
        color = zoneColor.copy(alpha = 0.08f),
        border = BorderStroke(1.dp, zoneColor.copy(alpha = 0.35f))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Sleek Top Row: Time remaining badge + Current zone status pill
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .scale(pulseScale)
                ) {
                    Text(
                        text = if (secondsRemaining <= 10) "⚠️" else "⏱️",
                        fontSize = 13.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    val minutes = (secondsRemaining / 60).coerceAtLeast(0)
                    val seconds = (secondsRemaining % 60).coerceAtLeast(0)
                    val formattedTime = if (secondsRemaining >= 60) {
                        "%d:%02d".format(minutes, seconds)
                    } else {
                        "${secondsRemaining}s"
                    }
                    Text(
                        text = "$formattedTime left",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = zoneColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.testTag("timer_seconds_remaining")
                    )
                }

                // Dynamic Status Pill
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = zoneColor.copy(alpha = 0.15f),
                    border = BorderStroke(0.8.dp, zoneColor.copy(alpha = 0.35f))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(currentZone.badgeEmoji, fontSize = 9.5.sp)
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = currentZone.shortLabel,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = zoneColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            // Sleek Compact Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .clip(RoundedCornerShape(1.5.dp))
                    .background(zoneColor.copy(alpha = 0.15f))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = progressFraction)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(1.5.dp))
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(zoneColor.copy(alpha = 0.8f), zoneColor)
                            )
                        )
                )
            }
        }
    }
}
