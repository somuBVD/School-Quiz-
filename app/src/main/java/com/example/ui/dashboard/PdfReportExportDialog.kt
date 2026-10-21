package com.example.ui.dashboard

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
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
import com.example.data.HistoricalScoreEntity
import com.example.data.QuizRankInfo
import com.example.data.UnitProgress
import com.example.data.UserProfile
import com.example.data.WeakAreaTopic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * Interactive Material 3 dialog for generating, previewing, saving, and sharing
 * the student's official PDF performance report and academic transcript.
 */
@Composable
fun PdfReportExportDialog(
    profile: UserProfile,
    progressList: List<UnitProgress>,
    historicalScores: List<HistoricalScoreEntity>,
    rankInfo: QuizRankInfo,
    weakAreaTopics: List<WeakAreaTopic> = emptyList(),
    isDark: Boolean,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var isGenerating by remember { mutableStateOf(false) }
    var generatedFile by remember { mutableStateOf<File?>(null) }
    var savedLocationMessage by remember { mutableStateOf<String?>(null) }

    val attemptedCount = remember(progressList) { progressList.count { it.progress > 0 } }
    val avgAccuracy = remember(progressList) {
        if (attemptedCount > 0) {
            progressList.filter { it.progress > 0 }.map { it.progress }.average().toInt()
        } else 0
    }

    // Function to generate the PDF if not already generated
    fun getOrGeneratePdf(onReady: (File) -> Unit) {
        if (generatedFile != null && generatedFile!!.exists()) {
            onReady(generatedFile!!)
            return
        }
        isGenerating = true
        coroutineScope.launch {
            try {
                val file = withContext(Dispatchers.IO) {
                    StudentReportPdfExporter.generatePdfReport(
                        context = context,
                        profile = profile,
                        progressList = progressList,
                        historicalScores = historicalScores,
                        rankInfo = rankInfo,
                        weakAreaTopics = weakAreaTopics
                    )
                }
                generatedFile = file
                isGenerating = false
                onReady(file)
            } catch (e: Exception) {
                isGenerating = false
                Toast.makeText(context, "Failed to generate PDF: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .fillMaxHeight(0.85f)
                .clip(RoundedCornerShape(24.dp))
                .testTag("pdf_report_export_dialog"),
            color = if (isDark) Color(0xFF1E293B) else Color.White,
            shape = RoundedCornerShape(24.dp),
            tonalElevation = 6.dp
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // DIALOG HEADER BANNER
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF4F46E5))
                        .padding(horizontal = 20.dp, vertical = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(Color.White.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.PictureAsPdf,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            Column {
                                Text(
                                    text = "Academic PDF Transcript",
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(
                                    text = "Official Student Progress Report",
                                    fontSize = 12.sp,
                                    color = Color(0xFFE0E7FF)
                                )
                            }
                        }

                        IconButton(
                            onClick = onDismiss,
                            modifier = Modifier
                                .size(32.dp)
                                .testTag("close_pdf_dialog_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = Color.White
                            )
                        }
                    }
                }

                // DIALOG SCROLLABLE CONTENT BODY
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // REPORT PREVIEW CARD
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC)
                        ),
                        border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // Student Profile Row
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(
                                        text = profile.name.ifBlank { "Student Learner" },
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if (isDark) Color.White else Color(0xFF0F172A)
                                    )
                                    val stdDisplay = when (profile.standard) {
                                        11 -> "Morarji Entrance"
                                        12 -> "NMMS Scholarship"
                                        else -> "Class ${profile.standard}th Standard"
                                    }
                                    Text(
                                        text = "$stdDisplay • ${rankInfo.rankTitle}",
                                        fontSize = 12.sp,
                                        color = if (isDark) Color(0xFF94A3B8) else Color(0xFF64748B)
                                    )
                                }

                                Text(
                                    text = rankInfo.badgeEmoji,
                                    fontSize = 28.sp
                                )
                            }

                            HorizontalDivider(color = if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))

                            // Key Highlights Grid
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "Total Points",
                                        fontSize = 10.sp,
                                        color = if (isDark) Color(0xFF94A3B8) else Color(0xFF64748B)
                                    )
                                    Text(
                                        text = "${profile.totalPoints}",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFF59E0B)
                                    )
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "Accuracy",
                                        fontSize = 10.sp,
                                        color = if (isDark) Color(0xFF94A3B8) else Color(0xFF64748B)
                                    )
                                    Text(
                                        text = "$avgAccuracy%",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF10B981)
                                    )
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "Quizzes",
                                        fontSize = 10.sp,
                                        color = if (isDark) Color(0xFF94A3B8) else Color(0xFF64748B)
                                    )
                                    Text(
                                        text = "$attemptedCount units",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF6366F1)
                                    )
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "Streak",
                                        fontSize = 10.sp,
                                        color = if (isDark) Color(0xFF94A3B8) else Color(0xFF64748B)
                                    )
                                    Text(
                                        text = "${profile.attendanceStreak}d 🔥",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFEF4444)
                                    )
                                }
                            }
                        }
                    }

                    // SECTIONS INCLUDED CHECKLIST
                    Text(
                        text = "Document Contents (2-Page A4 Report)",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isDark) Color.White else Color(0xFF1E293B)
                    )

                    val includedSections = listOf(
                        Pair(Icons.Default.Person, "Student Profile, Rank Badge & Academic Standing"),
                        Pair(Icons.AutoMirrored.Filled.MenuBook, "Subject-Wise Mastery Breakdown (Kannada, Math, Science, etc.)"),
                        Pair(Icons.Default.Timeline, "Chronological Quiz History Log (${historicalScores.size} records)"),
                        Pair(Icons.Default.EmojiEvents, "Unlocked Merit Badges & Honors Recognition"),
                        Pair(Icons.Default.Psychology, "Personalized Learning Focus & Guidance Areas"),
                        Pair(Icons.Default.Verified, "Digital System Security Hash & School Seal")
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                if (isDark) Color(0xFF0F172A).copy(alpha = 0.5f) else Color(0xFFF1F5F9),
                                RoundedCornerShape(12.dp)
                            )
                            .padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        includedSections.forEach { (icon, desc) ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = null,
                                    tint = Color(0xFF4F46E5),
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = desc,
                                    fontSize = 11.sp,
                                    color = if (isDark) Color(0xFFCBD5E1) else Color(0xFF334155),
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = Color(0xFF10B981),
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    }

                    // SAVED STATUS BANNER (if previously saved)
                    savedLocationMessage?.let { msg ->
                        Surface(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color(0xFFECFDF5),
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, Color(0xFFA7F3D0))
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = Color(0xFF059669),
                                    modifier = Modifier.size(18.dp)
                                )
                                Text(
                                    text = msg,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF065F46)
                                )
                            }
                        }
                    }

                    // GENERATING PROGRESS INDICATOR
                    if (isGenerating) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                strokeWidth = 2.dp,
                                color = Color(0xFF4F46E5)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "Composing official 2-page PDF document...",
                                fontSize = 12.sp,
                                color = if (isDark) Color(0xFF94A3B8) else Color(0xFF64748B)
                            )
                        }
                    }
                }

                // BOTTOM ACTION CONTROLS
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = if (isDark) Color(0xFF0F172A) else Color(0xFFF8FAFC),
                    border = BorderStroke(1.dp, if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Primary Action: Share PDF
                        Button(
                            onClick = {
                                getOrGeneratePdf { file ->
                                    StudentReportPdfExporter.sharePdf(context, file)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("share_pdf_report_button"),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                            enabled = !isGenerating,
                            contentPadding = PaddingValues(vertical = 12.dp)
                        ) {
                            Icon(Icons.Default.Share, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Share PDF Report (WhatsApp / Drive / Mail)",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        // Secondary Actions Row: Save to Downloads + View PDF
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            OutlinedButton(
                                onClick = {
                                    getOrGeneratePdf { file ->
                                        val (success, path) = StudentReportPdfExporter.savePdfToDownloads(context, file)
                                        if (success) {
                                            savedLocationMessage = "Saved to: $path"
                                            Toast.makeText(context, "✅ PDF saved to $path", Toast.LENGTH_LONG).show()
                                        } else {
                                            Toast.makeText(context, "Could not save PDF: $path", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("save_pdf_downloads_button"),
                                shape = RoundedCornerShape(12.dp),
                                enabled = !isGenerating,
                                border = BorderStroke(1.dp, Color(0xFF4F46E5)),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = Color(0xFF4F46E5)
                                ),
                                contentPadding = PaddingValues(vertical = 10.dp)
                            ) {
                                Icon(Icons.Default.Download, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Save to Device",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            FilledTonalButton(
                                onClick = {
                                    getOrGeneratePdf { file ->
                                        StudentReportPdfExporter.viewPdf(context, file)
                                    }
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .testTag("view_pdf_report_button"),
                                shape = RoundedCornerShape(12.dp),
                                enabled = !isGenerating,
                                colors = ButtonDefaults.filledTonalButtonColors(
                                    containerColor = Color(0xFFEEF2FF),
                                    contentColor = Color(0xFF4F46E5)
                                ),
                                contentPadding = PaddingValues(vertical = 10.dp)
                            ) {
                                Icon(Icons.Default.Visibility, contentDescription = null, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Preview PDF",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
