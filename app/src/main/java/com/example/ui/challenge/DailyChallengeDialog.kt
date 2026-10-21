package com.example.ui.challenge

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.QuizViewModel
import com.example.audio.SoundEffectsManager
import com.example.localization.LocalAppStrings

@Composable
fun DailyChallengeDialog(
    viewModel: QuizViewModel,
    modifier: Modifier = Modifier
) {
    val challengeState by viewModel.dailyChallengeState.collectAsState()
    val isDark by viewModel.isDarkMode.collectAsState()
    val strings = LocalAppStrings.current
    val context = LocalContext.current

    LaunchedEffect(challengeState.currentIndex, challengeState.isAnswerSubmitted) {
        if (challengeState.isAnswerSubmitted) {
            val q = challengeState.questions.getOrNull(challengeState.currentIndex)
            val isCorrect = q != null && challengeState.selectedAnswer.trim().equals(q.correctAnswer.trim(), ignoreCase = true)
            if (isCorrect) {
                SoundEffectsManager.playCorrect(context)
            } else {
                SoundEffectsManager.playIncorrect(context)
            }
        }
    }

    LaunchedEffect(challengeState.isFinished) {
        if (challengeState.isFinished) {
            val isPerfect = challengeState.correctCount == challengeState.questions.size && challengeState.questions.isNotEmpty()
            SoundEffectsManager.playQuizCompletion(context, isPerfect = isPerfect, isHighScore = challengeState.correctCount >= 4)
        }
    }

    if (!challengeState.isActive) return

    val currentQuestion = challengeState.questions.getOrNull(challengeState.currentIndex)

    Dialog(
        onDismissRequest = { viewModel.exitDailyChallenge() },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .testTag("daily_challenge_dialog"),
            shape = RoundedCornerShape(28.dp),
            color = MaterialTheme.colorScheme.background,
            tonalElevation = 8.dp
        ) {
            if (challengeState.isFinished) {
                // Completion Reward Screen
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFEF3C7)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🎯", fontSize = 48.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Daily Quest Conquered!",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Score: ${challengeState.correctCount} / ${challengeState.questions.size} correct answers",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Rewards Display
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Color(0xFF7C3AED).copy(alpha = 0.12f),
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("⚡ XP Earned", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color(0xFF7C3AED))
                                Text("+${challengeState.earnedXP}", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF7C3AED))
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = Color(0xFFF59E0B).copy(alpha = 0.12f),
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("🪙 Bonus Coins", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color(0xFFF59E0B))
                                Text("+${challengeState.earnedCoins}", fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFF59E0B))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = { viewModel.exitDailyChallenge() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("claim_challenge_reward_button"),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4F46E5)
                        )
                    ) {
                        Text(strings.claimReward, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
                    }
                }
            } else if (currentQuestion != null) {
                // Active Question View
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    // Top Bar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { viewModel.exitDailyChallenge() }) {
                            Icon(Icons.Default.Close, contentDescription = "Close Challenge")
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "🎯 ${strings.dailyChallenge}",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp
                            )
                            Text(
                                text = "${strings.question} ${challengeState.currentIndex + 1} ${strings.ofTotal} ${challengeState.questions.size}",
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        // Timer Badge
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (challengeState.secondsRemaining <= 10) Color(0xFFEF4444).copy(alpha = 0.15f) else MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text("⏱️", fontSize = 11.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "${challengeState.secondsRemaining}s",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 12.sp,
                                    color = if (challengeState.secondsRemaining <= 10) Color(0xFFEF4444) else MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }

                    // Question Text Card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isDark) Color(0xFF1E293B) else Color.White
                        ),
                        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
                    ) {
                        Text(
                            text = currentQuestion.questionText,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp)
                        )
                    }

                    // Options List
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.weight(1f, fill = false)
                    ) {
                        currentQuestion.options.forEach { option ->
                            val isSelected = challengeState.selectedAnswer == option
                            val isSubmitted = challengeState.isAnswerSubmitted
                            val isCorrectAnswer = option.trim().equals(currentQuestion.correctAnswer.trim(), ignoreCase = true)

                            val optionBorder = when {
                                isSubmitted && isCorrectAnswer -> Color(0xFF10B981)
                                isSubmitted && isSelected && !isCorrectAnswer -> Color(0xFFEF4444)
                                isSelected -> MaterialTheme.colorScheme.primary
                                else -> if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
                            }

                            val optionContainer = when {
                                isSubmitted && isCorrectAnswer -> Color(0xFF10B981).copy(alpha = 0.15f)
                                isSubmitted && isSelected && !isCorrectAnswer -> Color(0xFFEF4444).copy(alpha = 0.15f)
                                isSelected -> MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                                else -> if (isDark) Color(0xFF1E293B) else Color.White
                            }

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable(enabled = !isSubmitted) {
                                        viewModel.selectDailyChallengeAnswer(option)
                                    }
                                    .testTag("challenge_option_$option"),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(containerColor = optionContainer),
                                border = BorderStroke(1.5.dp, optionBorder)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(14.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = option,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp
                                    )
                                    if (isSubmitted) {
                                        Text(
                                            text = if (isCorrectAnswer) "✅" else if (isSelected) "❌" else "",
                                            fontSize = 16.sp
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // Bottom Action Button (Submit or Next)
                    if (!challengeState.isAnswerSubmitted) {
                        Button(
                            onClick = { viewModel.submitDailyChallengeAnswer() },
                            enabled = challengeState.selectedAnswer.isNotEmpty(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("challenge_submit_button"),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text("Submit Answer", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        }
                    } else {
                        Button(
                            onClick = { viewModel.nextDailyChallengeQuestion() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("challenge_next_button"),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF4F46E5)
                            )
                        ) {
                            Text(
                                text = if (challengeState.currentIndex + 1 < challengeState.questions.size) "Next Question ➡️" else "Finish Quest 🏁",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
