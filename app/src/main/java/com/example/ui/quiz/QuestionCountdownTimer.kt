package com.example.ui.quiz

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

        fun forElapsedSeconds(elapsedSecs: Int): TimeThresholdZone = getZoneForElapsed(elapsedSecs)

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
 * Prominent, interactive countdown timer component displayed during active quiz questions.
 * Designed specifically for students to practice time management and exam pacing with:
 *  - Radial / circular visual countdown gauge that sweeps in real time
 *  - Color-coded urgency zones (Speed Bonus ⚡, Standard ⏱️, Overtime ⚠️, Critical 🚨)
 *  - Multi-segment stage progress bar showing the 4 point zones
 *  - Real-time time management coaching tip
 *  - Pulsing alert effects during final seconds
 *  - Optional pace preset adjustments (30s, 60s, 90s, 120s or Untimed)
 */
@Composable
fun QuestionCountdownTimer(
    secondsRemaining: Int,
    totalSeconds: Int = 120,
    isAnswerSubmitted: Boolean,
    isReviewMarked: Boolean = false,
    isTimerEnabled: Boolean = true,
    onSelectTimeLimit: ((Int) -> Unit)? = null,
    onToggleTimer: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    var showPaceDialog by remember { mutableStateOf(false) }

    if (!isTimerEnabled) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .testTag("question_timer_disabled_pill"),
            shape = RoundedCornerShape(14.dp),
            color = Color(0xFFF0FDF4),
            border = BorderStroke(1.dp, Color(0xFFBBF7D0))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFDCFCE7)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🌱", fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Untimed Practice Mode",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF15803D),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Relaxed pace • Take all the time you need",
                            fontSize = 10.sp,
                            color = Color(0xFF16A34A),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                if (onToggleTimer != null) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF16A34A),
                        modifier = Modifier.clickable { onToggleTimer() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.Timer,
                                contentDescription = "Enable Timer",
                                tint = Color.White,
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Start Timer ⏱️",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
        return
    }

    val elapsedSeconds = (totalSeconds - secondsRemaining).coerceIn(0, totalSeconds)
    val currentZone = remember(elapsedSeconds) { TimeThresholdZone.getZoneForElapsed(elapsedSeconds) }
    val zoneColor = Color(currentZone.colorHex)
    val progressFraction = (secondsRemaining.toFloat() / totalSeconds.toFloat()).coerceIn(0f, 1f)

    // Pulsing animation when running low on time (<= 15s remaining)
    val infiniteTransition = rememberInfiniteTransition(label = "timer_pulse")
    val pulseScale by if (secondsRemaining <= 15 && !isAnswerSubmitted) {
        infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = if (secondsRemaining <= 5) 1.08f else 1.04f,
            animationSpec = infiniteRepeatable(
                animation = tween(if (secondsRemaining <= 5) 350 else 600, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "pulseScale"
        )
    } else {
        remember { mutableStateOf(1f) }
    }

    // Border glow for critical time
    val borderColor = if (secondsRemaining <= 10 && !isAnswerSubmitted) {
        Color(0xFFEF4444)
    } else {
        zoneColor.copy(alpha = 0.4f)
    }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .testTag("question_countdown_timer"),
        shape = RoundedCornerShape(16.dp),
        color = zoneColor.copy(alpha = 0.07f),
        border = BorderStroke(if (secondsRemaining <= 10 && !isAnswerSubmitted) 1.8.dp else 1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            // MAIN ROW: Radial Countdown Dial + Urgency Badge + Time Management Guidance
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Circular Visual Countdown Dial
                CircularCountdownDial(
                    secondsRemaining = secondsRemaining,
                    totalSeconds = totalSeconds,
                    zoneColor = zoneColor,
                    pulseScale = pulseScale,
                    modifier = Modifier.testTag("circular_countdown_dial")
                )

                // Middle Column: Live Status + Time Management Coaching
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Current Zone Status Pill
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = zoneColor.copy(alpha = 0.16f),
                            border = BorderStroke(0.8.dp, zoneColor.copy(alpha = 0.45f))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(currentZone.badgeEmoji, fontSize = 11.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = currentZone.label,
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = zoneColor,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }

                        // Pace Preset Button (30s, 60s, 90s, 120s)
                        if (onSelectTimeLimit != null) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                                modifier = Modifier
                                    .clickable { showPaceDialog = true }
                                    .testTag("timer_pace_settings_chip")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        Icons.Default.Tune,
                                        contentDescription = "Pace Settings",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(11.dp)
                                    )
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(
                                        text = "${totalSeconds}s",
                                        fontSize = 9.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }

                    // Educational Time Management Coaching Guidance
                    val coachingTip = when {
                        isAnswerSubmitted -> "✅ Answer submitted in ${elapsedSeconds}s (${currentZone.title})"
                        secondsRemaining <= 10 -> "🚨 Auto-submitting in ${secondsRemaining}s! Lock your answer now"
                        elapsedSeconds <= 30 -> "⚡ Fast zone! Answer in ≤30s for +15 Speed Bonus"
                        elapsedSeconds <= 60 -> "⏱️ Ideal board exam pace (31-60s) • Full 100 points"
                        elapsedSeconds <= 90 -> "⚠️ Overtime zone • 20 pts deduction active"
                        else -> "🚨 Critical overtime • 50 pts deduction active"
                    }
                    Text(
                        text = coachingTip,
                        fontSize = 10.5.sp,
                        fontWeight = if (secondsRemaining <= 10 || elapsedSeconds <= 30) FontWeight.Bold else FontWeight.Medium,
                        color = if (secondsRemaining <= 10) Color(0xFFDC2626) else MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // 4-STAGE TIME MANAGEMENT PACING METER (Visual Progress Segments)
            TimeManagementMilestoneBar(
                elapsedSeconds = elapsedSeconds,
                totalSeconds = totalSeconds,
                currentZone = currentZone
            )
        }
    }

    // Pace Preset Selection Dialog
    if (showPaceDialog && onSelectTimeLimit != null) {
        AlertDialog(
            onDismissRequest = { showPaceDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⏱️", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Question Pace & Time Limit", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "Choose your practice pace per question to practice time management for exams:",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    listOf(
                        Triple(30, "⚡ 30s Lightning Sprint", "Fast-paced reflex challenge for scholarship speed practice"),
                        Triple(60, "⏱️ 60s Target Pace", "Ideal 1-minute standard for competitive multiple choice exams"),
                        Triple(90, "📚 90s Board Exam Pace", "Deep thinking pace with time to double-check choices"),
                        Triple(120, "⏳ 120s Extended Study", "Default comfortable timing for new chapters and revision")
                    ).forEach { (seconds, label, desc) ->
                        val isSelected = totalSeconds == seconds
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (isSelected) Color(0xFF4F46E5).copy(alpha = 0.12f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
                            border = BorderStroke(1.dp, if (isSelected) Color(0xFF4F46E5) else Color.Transparent),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onSelectTimeLimit(seconds)
                                    showPaceDialog = false
                                }
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(
                                    text = label,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.5.sp,
                                    color = if (isSelected) Color(0xFF4F46E5) else MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = desc,
                                    fontSize = 10.5.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showPaceDialog = false }) {
                    Text("Close")
                }
            }
        )
    }
}

/**
 * Animated Circular Dial that sweeps 360 degrees as the question timer counts down.
 */
@Composable
fun CircularCountdownDial(
    secondsRemaining: Int,
    totalSeconds: Int,
    zoneColor: Color,
    pulseScale: Float,
    modifier: Modifier = Modifier
) {
    val progressFraction = (secondsRemaining.toFloat() / totalSeconds.toFloat()).coerceIn(0f, 1f)
    val animatedProgress by animateFloatAsState(
        targetValue = progressFraction,
        animationSpec = tween(durationMillis = 350, easing = LinearEasing),
        label = "timer_radial_progress"
    )

    Box(
        modifier = modifier
            .size(54.dp)
            .scale(pulseScale),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize().padding(3.dp)) {
            val strokeWidth = 5.dp.toPx()
            // Background circular track
            drawCircle(
                color = zoneColor.copy(alpha = 0.18f),
                radius = (size.minDimension - strokeWidth) / 2,
                style = Stroke(width = strokeWidth)
            )
            // Animated remaining sweep arc
            drawArc(
                color = zoneColor,
                startAngle = -90f,
                sweepAngle = 360f * animatedProgress,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                topLeft = Offset(strokeWidth / 2, strokeWidth / 2),
                size = Size(size.width - strokeWidth, size.height - strokeWidth)
            )
        }

        // Center Countdown Display
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val minutes = (secondsRemaining / 60).coerceAtLeast(0)
            val seconds = (secondsRemaining % 60).coerceAtLeast(0)
            val displayText = if (totalSeconds >= 60 && minutes > 0) {
                "%d:%02d".format(minutes, seconds)
            } else {
                "${secondsRemaining}s"
            }

            Text(
                text = displayText,
                fontSize = if (displayText.length > 3) 11.5.sp else 13.sp,
                fontWeight = FontWeight.Black,
                color = zoneColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.testTag("timer_seconds_remaining")
            )
        }
    }
}

/**
 * 4-stage visual milestone track showing the 4 point zones:
 *  1. Speed Bonus (0-30s / +15)
 *  2. Target Pace (31-60s / Full)
 *  3. Overtime Warning (61-90s / -20)
 *  4. Critical (91-120s / -50)
 */
@Composable
fun TimeManagementMilestoneBar(
    elapsedSeconds: Int,
    totalSeconds: Int,
    currentZone: TimeThresholdZone,
    modifier: Modifier = Modifier
) {
    val stages = listOf(
        TimeThresholdZone.SPEED_BONUS to "⚡ ≤30s",
        TimeThresholdZone.STANDARD to "⏱️ ≤60s",
        TimeThresholdZone.THRESHOLD_1_PENALTY to "⚠️ ≤90s",
        TimeThresholdZone.THRESHOLD_2_PENALTY to "🚨 >90s"
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(Color.Black.copy(alpha = 0.04f))
            .padding(2.dp),
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        stages.forEach { (zone, label) ->
            val isActive = currentZone == zone
            val isPassed = elapsedSeconds > zone.maxElapsedSec
            val zoneBaseColor = Color(zone.colorHex)

            val segmentBg = when {
                isActive -> zoneBaseColor
                isPassed -> zoneBaseColor.copy(alpha = 0.35f)
                else -> zoneBaseColor.copy(alpha = 0.12f)
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(16.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(segmentBg)
                    .then(
                        if (isActive) Modifier.border(1.dp, Color.White.copy(alpha = 0.8f), RoundedCornerShape(3.dp))
                        else Modifier
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    fontSize = 8.5.sp,
                    fontWeight = if (isActive) FontWeight.ExtraBold else FontWeight.Medium,
                    color = if (isActive) Color.White else zoneBaseColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
