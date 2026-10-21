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
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.ui.unit.dp
import java.util.Locale
import androidx.compose.ui.unit.sp

/**
 * Reusable Exam Timer component that displays a countdown during quizzes,
 * tests, and duels with distinct visual cues (pulsing, turning vibrant red,
 * warning badges) when time is running low to enhance competitive excitement.
 *
 * Uses solid, high-contrast typography without any hollow outline text.
 */
@Composable
fun ExamTimer(
    totalSeconds: Int,
    secondsRemaining: Int,
    modifier: Modifier = Modifier,
    compact: Boolean = false,
    showProgressBar: Boolean = true,
    label: String = "Exam Timer",
    onTimeUp: (() -> Unit)? = null
) {
    // Notify on expiration
    LaunchedEffect(secondsRemaining) {
        if (secondsRemaining <= 0) {
            onTimeUp?.invoke()
        }
    }

    val fractionRemaining = if (totalSeconds > 0) {
        (secondsRemaining.toFloat() / totalSeconds.toFloat()).coerceIn(0f, 1f)
    } else 0f

    val isCritical = secondsRemaining <= 10 || fractionRemaining <= 0.25f
    val isUrgent = secondsRemaining <= 5
    val isWarning = !isCritical && (secondsRemaining <= 20 || fractionRemaining <= 0.50f)

    // Distinct theme colors based on remaining time threshold
    val timerColor = when {
        isCritical -> Color(0xFFEF4444) // Bright Red for critical time
        isWarning -> Color(0xFFF59E0B)  // Amber for warning
        else -> Color(0xFF10B981)       // Emerald Green for ample time
    }

    val statusText = when {
        secondsRemaining <= 0 -> "TIME UP!"
        isUrgent -> "HURRY UP!"
        isCritical -> "CRITICAL TIME"
        isWarning -> "PACE UP"
        else -> "ON TRACK"
    }

    // Urgent heartbeat scale animation for critical seconds
    val pulseScale by if (isCritical && secondsRemaining > 0) {
        val infiniteTransition = rememberInfiniteTransition(label = "examTimerPulse")
        infiniteTransition.animateFloat(
            initialValue = 1.0f,
            targetValue = if (isUrgent) 1.14f else 1.08f,
            animationSpec = infiniteRepeatable(
                animation = tween(if (isUrgent) 350 else 550, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "pulseScale"
        )
    } else {
        remember { mutableFloatStateOf(1.0f) }
    }

    // Format display string as mm:ss when total duration is > 60s, or ss seconds
    val formattedTime = if (totalSeconds >= 60) {
        val mins = (secondsRemaining / 60).coerceAtLeast(0)
        val secs = (secondsRemaining % 60).coerceAtLeast(0)
        String.format(Locale.getDefault(), "%02d:%02d", mins, secs)
    } else {
        "${secondsRemaining.coerceAtLeast(0)}s"
    }

    if (compact) {
        // Compact pill layout suitable for headers and top bars
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = timerColor.copy(alpha = 0.12f),
            border = BorderStroke(1.2.dp, timerColor.copy(alpha = 0.45f)),
            modifier = modifier
                .scale(pulseScale)
                .testTag("compact_exam_timer")
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = if (isCritical) "🚨" else if (isWarning) "⏳" else "⏱️",
                    fontSize = 13.sp
                )
                Text(
                    text = formattedTime,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Black,
                    color = timerColor
                )
            }
        }
    } else {
        // Full feature card with countdown display, status badge, and animated progress bar
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .testTag("reusable_exam_timer"),
            shape = RoundedCornerShape(20.dp),
            color = timerColor.copy(alpha = 0.08f),
            border = BorderStroke(1.5.dp, timerColor.copy(alpha = if (isCritical) 0.6f else 0.35f))
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Time Left with pulse scale
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.scale(pulseScale)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(timerColor.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (isCritical) "🚨" else if (isWarning) "⏳" else "⏱️",
                                fontSize = 18.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Column {
                            Row(verticalAlignment = Alignment.Bottom) {
                                Text(
                                    text = formattedTime,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Black,
                                    color = timerColor
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "remaining",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = timerColor.copy(alpha = 0.85f)
                                )
                            }
                            Text(
                                text = "$label • ${totalSeconds}s Total Time",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    // Alert / Status Pill with solid typography
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = timerColor.copy(alpha = 0.18f),
                        border = BorderStroke(1.dp, timerColor.copy(alpha = 0.5f))
                    ) {
                        Text(
                            text = statusText,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = timerColor,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }
                }

                // Smooth Progress Bar
                if (showProgressBar) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFFE2E8F0))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(fraction = fractionRemaining)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(4.dp))
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            timerColor.copy(alpha = 0.75f),
                                            timerColor
                                        )
                                    )
                                )
                        )
                    }
                }
            }
        }
    }
}
