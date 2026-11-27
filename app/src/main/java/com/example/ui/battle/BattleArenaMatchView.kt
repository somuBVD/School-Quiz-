package com.example.ui.battle

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import java.util.Locale

/**
 * High-speed, zero-delay 1vs1 Quick-Fire MCQ Stream Arena.
 * Designed for instantaneous tap-to-next responsiveness with:
 * - Smooth 50ms precision countdown bar
 * - Compact split VS scoreboard with live streak & QPM telemetry
 * - Non-blocking instant feedback strip from the previous answer (zero input lockout!)
 * - Tactile A/B/C/D quick-fire option deck with 56dp+ touch targets
 */
@Composable
fun BattleMatchView(
    battleState: BattleArenaState,
    userName: String,
    onSubmitAnswer: (String) -> Unit,
    onSkipQuestion: () -> Unit,
    onFinishEarly: () -> Unit,
    isDark: Boolean
) {
    val currentQuestion = battleState.currentQuestion ?: return
    val opponent = battleState.opponent
    val isBlitz = !battleState.isOnlineMatch && battleState.streamMode == BattleStreamMode.BLITZ_60S
    val isInfinite = !battleState.isOnlineMatch && battleState.streamMode == BattleStreamMode.INFINITE

    val timerFraction = if (battleState.isOnlineMatch) {
        (battleState.roundSecondsRemaining / 10f).coerceIn(0f, 1f)
    } else if (isBlitz) {
        (battleState.matchTimeRemainingMs.toFloat() / 60_000f).coerceIn(0f, 1f)
    } else {
        (battleState.roundTimeRemainingMs.toFloat() / battleState.roundDurationMs.coerceAtLeast(1L)).coerceIn(0f, 1f)
    }

    val timerColor = when {
        timerFraction <= 0.28f -> Color(0xFFEF4444)
        timerFraction <= 0.55f -> Color(0xFFF59E0B)
        else -> Color(0xFF10B981)
    }

    val hudGradient = if (isDark) {
        Brush.linearGradient(listOf(Color(0xFF0F172A), Color(0xFF1E1B4B), Color(0xFF172554)))
    } else {
        Brush.linearGradient(listOf(Color(0xFF1E1B4B), Color(0xFF312E81), Color(0xFF1D4ED8)))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .widthIn(max = 720.dp)
            .padding(horizontal = 14.dp, vertical = 8.dp)
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // 1. ELECTRIC COMPETITIVE VS HUD + SMOOTH COUNTDOWN BAR
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("battle_live_scoreboard"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(hudGradient)
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Local Player
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(34.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF38BDF8).copy(alpha = 0.22f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("⚡", fontSize = 16.sp)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(modifier = Modifier.weight(1f, fill = false)) {
                            Text(
                                text = userName,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White.copy(alpha = 0.82f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "${battleState.userScore}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFF7DD3FC)
                            )
                        }
                    }

                    // Center Stream Counter & High-Precision Clock
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(horizontal = 6.dp)
                    ) {
                        val roundBadge = when {
                            battleState.isOnlineMatch -> "R${battleState.currentRoundIndex + 1}/${battleState.totalRounds}"
                            isInfinite -> "∞ #${battleState.currentRoundIndex + 1}"
                            isBlitz -> "#${battleState.currentRoundIndex + 1} BLITZ"
                            else -> "R${battleState.currentRoundIndex + 1}/${battleState.uniquePoolSize.coerceAtLeast(battleState.totalRounds)}"
                        }
                        Text(
                            text = roundBadge,
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            softWrap = false
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        val timeText = if (battleState.isOnlineMatch) {
                            "${battleState.roundSecondsRemaining}s"
                        } else if (isBlitz) {
                            val sec = battleState.matchTimeRemainingMs / 1000L
                            val tenths = (battleState.matchTimeRemainingMs % 1000L) / 100L
                            "${sec}.${tenths}s"
                        } else {
                            val sec = battleState.roundTimeRemainingMs / 1000L
                            val tenths = (battleState.roundTimeRemainingMs % 1000L) / 100L
                            "${sec}.${tenths}s"
                        }
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = timerColor
                        ) {
                            Text(
                                text = timeText,
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                                maxLines = 1,
                                softWrap = false
                            )
                        }
                    }

                    // Rival Player
                    Row(
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            horizontalAlignment = Alignment.End,
                            modifier = Modifier.weight(1f, fill = false)
                        ) {
                            Text(
                                text = opponent?.name ?: "Rival",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White.copy(alpha = 0.82f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "${battleState.opponentScore}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFFFDA4AF)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(34.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFF43F5E).copy(alpha = 0.26f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(opponent?.avatar ?: "🎯", fontSize = 16.sp)
                        }
                    }
                }

                // Tug-of-War Momentum Bar
                val totalPoints = (battleState.userScore + battleState.opponentScore).coerceAtLeast(1)
                val userRatio = if (battleState.userScore == 0 && battleState.opponentScore == 0) {
                    0.5f
                } else {
                    (battleState.userScore.toFloat() / totalPoints).coerceIn(0.08f, 0.92f)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(Color(0xFFF43F5E))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(userRatio)
                            .background(Color(0xFF38BDF8))
                    )
                }

                // Smooth 50ms Timer Bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color.White.copy(alpha = 0.16f))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(timerFraction)
                            .background(timerColor)
                    )
                }

                // Live Telemetry Row (Streak • QPM • Rival Status)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (battleState.userStreak >= 2) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = Color(0xFFF59E0B).copy(alpha = 0.22f)
                            ) {
                                Text(
                                    text = "🔥 ${battleState.userStreak}x",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Black,
                                    color = Color(0xFFFDE68A),
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }
                        if (battleState.answeredCount > 0) {
                            Text(
                                text = "⚡ ${battleState.questionsPerMinute} Q/min • ${battleState.accuracyPercent}%",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFA7F3D0),
                                maxLines = 1,
                                softWrap = false
                            )
                        } else {
                            Text(
                                text = if (battleState.isOnlineMatch) {
                                    "LIVE ONLINE 1v1 • ${battleState.totalRounds} MCQs"
                                } else {
                                    "ZERO-DELAY STREAM • ${battleState.uniquePoolSize} UNIQUE MCQs"
                                },
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFC7D2FE),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Text(
                        text = if (battleState.opponentAnswerLocked || battleState.opponentSelectedAnswer.isNotEmpty()) {
                            "Rival Locked ⚡"
                        } else {
                            "Tap Fast!"
                        },
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (battleState.opponentAnswerLocked) Color(0xFFFDE68A) else Color.White.copy(alpha = 0.72f),
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }
        }

        // 2. NON-BLOCKING INSTANT FEEDBACK STRIP (from previous tap — zero delay on current MCQ!)
        battleState.lastFeedback?.let { fb ->
            val fbBg = when {
                fb.skipped -> Color(0xFF64748B).copy(alpha = 0.14f)
                fb.userCorrect -> Color(0xFF10B981).copy(alpha = 0.15f)
                else -> Color(0xFFEF4444).copy(alpha = 0.14f)
            }
            val fbAccent = when {
                fb.skipped -> Color(0xFF64748B)
                fb.userCorrect -> Color(0xFF059669)
                else -> Color(0xFFDC2626)
            }
            val speedSec = String.format(Locale.US, "%.1fs", fb.responseMs / 1000f)

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = fbBg,
                border = BorderStroke(1.dp, fbAccent.copy(alpha = 0.45f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("battle_instant_feedback_strip")
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 7.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = when {
                                fb.skipped -> Icons.Rounded.FastForward
                                fb.userCorrect -> Icons.Rounded.CheckCircle
                                else -> Icons.Rounded.Cancel
                            },
                            contentDescription = null,
                            tint = fbAccent,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = when {
                                fb.skipped -> "Q${fb.roundNumber} Skipped • Ans: ${fb.correctAnswer}"
                                fb.userCorrect -> "Q${fb.roundNumber} Correct! +${fb.pointsEarned} pts"
                                else -> "Q${fb.roundNumber} Ans: ${fb.correctAnswer}"
                            },
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = fbAccent,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "⚡ $speedSec",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = fbAccent,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }
        }

        // 3. QUESTION CARD (Zero transition delay — updates instantaneously on tap)
        key(currentQuestion.id, battleState.currentRoundIndex) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .testTag("battle_question_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.7f),
                        modifier = Modifier.padding(bottom = 10.dp)
                    ) {
                        Text(
                            text = currentQuestion.subjectId.replace("_", " ").uppercase(),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Text(
                        text = currentQuestion.questionText,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 23.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // 4. TACTILE ZERO-DELAY A/B/C/D OPTION DECK
            val optionLabels = listOf("A", "B", "C", "D", "E", "F")
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                currentQuestion.options.forEachIndexed { idx, option ->
                    val isSelected = battleState.userSelectedAnswer == option
                    val isCorrect = option == currentQuestion.correctAnswer
                    val isOnlineReveal = battleState.isOnlineMatch && battleState.stage == BattleStage.ROUND_REVEAL

                    val buttonBg = when {
                        isOnlineReveal && isCorrect -> Color(0xFF10B981)
                        isOnlineReveal && isSelected && !isCorrect -> Color(0xFFEF4444)
                        isSelected -> Color(0xFF4F46E5)
                        else -> if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC)
                    }
                    val borderColor = when {
                        isOnlineReveal && isCorrect -> Color(0xFF10B981)
                        isOnlineReveal && isSelected && !isCorrect -> Color(0xFFEF4444)
                        isSelected -> Color(0xFF4F46E5)
                        else -> if (isDark) Color(0xFF334155) else Color(0xFFCBD5E1)
                    }
                    val textColor = if (isSelected || (isOnlineReveal && isCorrect)) {
                        Color.White
                    } else {
                        MaterialTheme.colorScheme.onSurface
                    }

                    Surface(
                        onClick = {
                            if (!battleState.isOnlineMatch || battleState.userSelectedAnswer.isEmpty()) {
                                onSubmitAnswer(option)
                            }
                        },
                        shape = RoundedCornerShape(14.dp),
                        color = buttonBg,
                        border = BorderStroke(1.2.dp, borderColor),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 54.dp)
                            .testTag("battle_option_$option")
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        if (isSelected || (isOnlineReveal && isCorrect)) {
                                            Color.White.copy(alpha = 0.22f)
                                        } else {
                                            MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = optionLabels.getOrElse(idx) { "${idx + 1}" },
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Black,
                                    color = if (isSelected || (isOnlineReveal && isCorrect)) {
                                        Color.White
                                    } else {
                                        MaterialTheme.colorScheme.primary
                                    }
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = option,
                                fontSize = 14.sp,
                                fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.SemiBold,
                                color = textColor,
                                modifier = Modifier.weight(1f)
                            )
                            if (isOnlineReveal && isCorrect) {
                                Icon(
                                    imageVector = Icons.Rounded.Check,
                                    contentDescription = "Correct",
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // 5. QUICK-FIRE BOTTOM ACTION STRIP (Skip + Finish & Claim)
        if (!battleState.isOnlineMatch) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = onSkipQuestion,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .testTag("battle_skip_question_button")
                ) {
                    Icon(
                        imageVector = Icons.Rounded.FastForward,
                        contentDescription = stringResource(R.string.battle_skip_question),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = stringResource(R.string.battle_skip_question),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }

                Button(
                    onClick = onFinishEarly,
                    enabled = battleState.answeredCount > 0,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0F766E),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .weight(1.4f)
                        .height(48.dp)
                        .testTag("battle_finish_early_button")
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Flag,
                        contentDescription = stringResource(R.string.battle_end_and_claim),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (battleState.answeredCount > 0) {
                            "${stringResource(R.string.battle_end_and_claim)} (${battleState.answeredCount})"
                        } else {
                            stringResource(R.string.battle_end_and_claim)
                        },
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 12.5.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
