package com.example.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.HistoricalScoreEntity
import com.example.data.QuizStaticData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HistoricalScoresSection(
    historicalScores: List<HistoricalScoreEntity>,
    isDark: Boolean,
    onDeleteScore: (Long) -> Unit,
    onClearAll: () -> Unit,
    onStartNewQuiz: () -> Unit,
    onExportPdf: (() -> Unit)? = null,
    studentName: String = "Student",
    modifier: Modifier = Modifier
) {
    var showClearConfirmDialog by remember { mutableStateOf(false) }
    var selectedCertificateScore by remember { mutableStateOf<HistoricalScoreEntity?>(null) }

    val titleColor = MaterialTheme.colorScheme.onSurface
    val subtitleColor = MaterialTheme.colorScheme.onSurfaceVariant
    val cardBorder = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Section Header Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "📜 Quiz Score History",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = titleColor
                )
                Text(
                    text = "${historicalScores.size} recorded attempts stored locally on device",
                    style = MaterialTheme.typography.bodySmall,
                    color = subtitleColor
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.CenterVertically) {
                if (onExportPdf != null) {
                    FilledTonalButton(
                        onClick = onExportPdf,
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                        modifier = Modifier.testTag("export_pdf_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.PictureAsPdf,
                            contentDescription = "Export PDF",
                            modifier = Modifier.size(15.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Export PDF", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }

                if (historicalScores.isNotEmpty()) {
                    TextButton(
                        onClick = { showClearConfirmDialog = true },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.colorScheme.error
                        ),
                        modifier = Modifier.testTag("clear_history_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.DeleteSweep,
                            contentDescription = "Clear All History",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Clear", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        if (historicalScores.isEmpty()) {
            // Clean Illustrated Empty State
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("empty_history_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = cardBorder
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(
                                    listOf(Color(0xFF6366F1), Color(0xFF8B5CF6))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("📝", fontSize = 28.sp)
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "No Quiz Attempts Recorded Yet",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = titleColor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Complete your first chapter quiz or challenge to view score accuracy, XP gains, and performance stats here!",
                        style = MaterialTheme.typography.bodySmall,
                        color = subtitleColor,
                        lineHeight = 18.sp,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = onStartNewQuiz,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier.testTag("history_start_quiz_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Start Quiz",
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Start a Quiz", fontWeight = FontWeight.Bold)
                    }
                }
            }
        } else {
            // Aggregate Score Summary Card
            val avgAccuracy = historicalScores.map { it.accuracyPercentage }.average().toInt()
            val totalCoins = historicalScores.sumOf { it.earnedCoins }
            val totalXP = historicalScores.sumOf { it.earnedXP }
            val passedCount = historicalScores.count { it.isPassed }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("history_summary_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark) Color(0xFF1E1B4B) else Color(0xFFEEF2FF)
                ),
                border = BorderStroke(1.dp, if (isDark) Color(0xFF3730A3) else Color(0xFFC7D2FE))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HistoryStatItem(
                        label = "Avg Accuracy",
                        value = "$avgAccuracy%",
                        color = if (avgAccuracy >= 80) Color(0xFF10B981) else Color(0xFFF59E0B)
                    )
                    HistoryStatItem(
                        label = "Passed",
                        value = "$passedCount/${historicalScores.size}",
                        color = Color(0xFF6366F1)
                    )
                    HistoryStatItem(
                        label = "Total XP",
                        value = "+$totalXP",
                        color = Color(0xFF8B5CF6)
                    )
                    HistoryStatItem(
                        label = "Coins",
                        value = "+$totalCoins 🪙",
                        color = Color(0xFFF59E0B)
                    )
                }
            }

            // List of Historical Attempt Cards
            historicalScores.forEach { score ->
                HistoricalScoreCard(
                    score = score,
                    isDark = isDark,
                    cardBorder = cardBorder,
                    titleColor = titleColor,
                    subtitleColor = subtitleColor,
                    onDelete = { onDeleteScore(score.id) },
                    onViewCertificate = { selectedCertificateScore = score }
                )
            }
        }
    }

    selectedCertificateScore?.let { certScore ->
        QuizCertificateDialog(
            certificateData = CertificateData(
                studentName = studentName,
                standard = certScore.stdId,
                subjectTitle = certScore.subjectId.replaceFirstChar { it.uppercase() },
                unitName = certScore.unitName.ifBlank { "Unit ${certScore.unitId}" },
                score = certScore.score,
                totalQuestions = certScore.totalQuestions,
                accuracyPercentage = certScore.accuracyPercentage,
                completedAt = certScore.completedAt
            ),
            isDark = isDark,
            onDismiss = { selectedCertificateScore = null }
        )
    }

    if (showClearConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showClearConfirmDialog = false },
            title = {
                Text("Clear Quiz History?", fontWeight = FontWeight.Bold)
            },
            text = {
                Text("This will permanently remove all past quiz score records from your device's local Room database.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showClearConfirmDialog = false
                        onClearAll()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("Clear All")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showClearConfirmDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun HistoryStatItem(
    label: String,
    value: String,
    color: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
            color = color
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun HistoricalScoreCard(
    score: HistoricalScoreEntity,
    isDark: Boolean,
    cardBorder: BorderStroke,
    titleColor: Color,
    subtitleColor: Color,
    onDelete: () -> Unit,
    onViewCertificate: () -> Unit
) {
    val subjectColorHex = QuizStaticData.SUBJECT_COLORS[score.subjectId] ?: 0xFF6366F1
    val subjectColor = Color(subjectColorHex)
    val dateFormat = remember { SimpleDateFormat("MMM d, yyyy • h:mm a", Locale.getDefault()) }
    val formattedDate = remember(score.completedAt) { dateFormat.format(Date(score.completedAt)) }

    val statusColor = if (score.isPassed) Color(0xFF10B981) else Color(0xFFEF4444)
    val statusBg = if (score.isPassed) Color(0xFF10B981).copy(alpha = 0.12f) else Color(0xFFEF4444).copy(alpha = 0.12f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("historical_score_item_${score.id}"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = cardBorder
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Top Row: Subject & Standard Tag + Delete Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(subjectColor)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    val stdLabel = when (score.stdId) {
                        11 -> "Morarji"
                        12 -> "NMMS"
                        else -> "Std ${score.stdId}"
                    }
                    Text(
                        text = "${score.subjectId.replaceFirstChar { it.uppercase() }} • $stdLabel",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = subjectColor
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Pass/Fail badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(statusBg)
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = if (score.isPassed) "Passed 🎯" else "Needs Review 📖",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = statusColor
                        )
                    }

                    Spacer(modifier = Modifier.width(4.dp))

                    IconButton(
                        onClick = onDelete,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Delete Attempt",
                            tint = subtitleColor,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            // Unit Title & Score
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = score.unitName.ifBlank { "Unit ${score.unitId}" },
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = titleColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = formattedDate,
                        fontSize = 11.sp,
                        color = subtitleColor
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = "${score.score}/${score.totalQuestions}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = if (score.accuracyPercentage >= 80) Color(0xFF10B981) else if (score.accuracyPercentage >= 50) Color(0xFFF59E0B) else Color(0xFFEF4444)
                    )
                    Text(
                        text = "${score.accuracyPercentage}% Accuracy",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = subtitleColor
                    )
                }
            }

            // Accuracy Progress Bar
            LinearProgressIndicator(
                progress = { score.accuracyPercentage / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp)),
                color = if (score.accuracyPercentage >= 80) Color(0xFF10B981) else if (score.accuracyPercentage >= 50) Color(0xFFF59E0B) else Color(0xFFEF4444),
                trackColor = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
            )

            // Reward Tags & Certificate Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RewardPill(text = "+${score.earnedXP} XP", color = Color(0xFF8B5CF6))
                    RewardPill(text = "+${score.earnedCoins} 🪙", color = Color(0xFFF59E0B))
                    if (score.earnedStars > 0) {
                        RewardPill(text = "+${score.earnedStars} ⭐", color = Color(0xFF10B981))
                    }
                }

                if (score.isPassed) {
                    FilledTonalButton(
                        onClick = onViewCertificate,
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                        modifier = Modifier
                            .height(28.dp)
                            .testTag("certificate_button_${score.id}")
                    ) {
                        Text("🎓 Certificate", fontSize = 10.5.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }
            }
        }
    }
}

@Composable
private fun RewardPill(text: String, color: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color.copy(alpha = 0.12f))
            .padding(horizontal = 7.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}
