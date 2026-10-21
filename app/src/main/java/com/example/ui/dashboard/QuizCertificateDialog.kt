package com.example.ui.dashboard

import android.content.Intent
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class CertificateData(
    val studentName: String,
    val standard: Int,
    val subjectTitle: String,
    val unitName: String,
    val score: Int,
    val totalQuestions: Int,
    val accuracyPercentage: Int,
    val completedAt: Long = System.currentTimeMillis()
)

@Composable
fun QuizCertificateDialog(
    certificateData: CertificateData,
    isDark: Boolean,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val dateFormat = remember { SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()) }
    val formattedDate = remember(certificateData.completedAt) {
        dateFormat.format(Date(certificateData.completedAt))
    }

    val grade = remember(certificateData.accuracyPercentage) {
        when {
            certificateData.accuracyPercentage >= 90 -> "Distinction (A+)"
            certificateData.accuracyPercentage >= 75 -> "First Class (A)"
            certificateData.accuracyPercentage >= 60 -> "Second Class (B)"
            else -> "Pass Certificate"
        }
    }

    val certificateId = remember(certificateData.completedAt, certificateData.score) {
        "KSQ-${(certificateData.completedAt % 100000).toString().padStart(5, '0')}-${certificateData.accuracyPercentage}"
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .testTag("quiz_certificate_dialog"),
            shape = RoundedCornerShape(24.dp),
            color = if (isDark) Color(0xFF0F172A) else Color(0xFFFFFBEB), // Elegant parchment look
            border = BorderStroke(3.dp, Color(0xFFD97706)), // Gold border
            tonalElevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Top Action Bar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFFD97706).copy(alpha = 0.15f),
                        border = BorderStroke(1.dp, Color(0xFFD97706))
                    ) {
                        Text(
                            text = "VERIFIED ID: $certificateId",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFB45309),
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = Color(0xFF78350F)
                        )
                    }
                }

                // Decorative Crest / Seal
                Box(
                    modifier = Modifier
                        .size(68.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.radialGradient(
                                colors = listOf(Color(0xFFFDE68A), Color(0xFFD97706))
                            )
                        )
                        .border(2.dp, Color(0xFFB45309), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🏅", fontSize = 34.sp)
                }

                Text(
                    text = "CERTIFICATE OF EXCELLENCE",
                    fontFamily = FontFamily.Serif,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF92400E),
                    letterSpacing = 1.2.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Karnataka State School Quiz Portal",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB45309)
                )

                HorizontalDivider(
                    modifier = Modifier
                        .width(180.dp)
                        .padding(vertical = 4.dp),
                    color = Color(0xFFD97706),
                    thickness = 1.5.dp
                )

                Text(
                    text = "This is proudly presented to",
                    fontSize = 12.sp,
                    color = if (isDark) Color(0xFFE2E8F0) else Color(0xFF78350F)
                )

                // Recipient Name
                Text(
                    text = certificateData.studentName.ifBlank { "Dedicated Student" },
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.Serif,
                    color = if (isDark) Color(0xFFFDE68A) else Color(0xFF1E293B),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "For successfully completing and mastering the curriculum quiz for",
                    fontSize = 11.5.sp,
                    textAlign = TextAlign.Center,
                    color = if (isDark) Color(0xFFCBD5E1) else Color(0xFF64748B)
                )

                // Unit & Subject Details Card
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isDark) Color(0xFF1E293B) else Color(0xFFFEF3C7),
                    border = BorderStroke(1.dp, Color(0xFFFCD34D)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        val stdLabel = when (certificateData.standard) {
                            11 -> "Morarji"
                            12 -> "NMMS"
                            else -> "Standard ${certificateData.standard}"
                        }
                        Text(
                            text = "${certificateData.subjectTitle} • $stdLabel",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFB45309)
                        )
                        Text(
                            text = "\"${certificateData.unitName}\"",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isDark) Color.White else Color(0xFF1E293B),
                            textAlign = TextAlign.Center
                        )
                    }
                }

                // Performance Score Box (Score, Accuracy, Grade)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "${certificateData.score}/${certificateData.totalQuestions}",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF10B981)
                        )
                        Text(
                            text = "Score",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isDark) Color(0xFF94A3B8) else Color(0xFF78350F)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .width(1.dp)
                            .height(30.dp)
                            .background(Color(0xFFD97706).copy(alpha = 0.3f))
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "${certificateData.accuracyPercentage}%",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF3B82F6)
                        )
                        Text(
                            text = "Accuracy",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isDark) Color(0xFF94A3B8) else Color(0xFF78350F)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .width(1.dp)
                            .height(30.dp)
                            .background(Color(0xFFD97706).copy(alpha = 0.3f))
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = grade,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFFD97706)
                        )
                        Text(
                            text = "Rating",
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isDark) Color(0xFF94A3B8) else Color(0xFF78350F)
                        )
                    }
                }

                // Date and Digital Signature line
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Column {
                        Text(
                            text = "Issued on:",
                            fontSize = 10.sp,
                            color = if (isDark) Color(0xFF94A3B8) else Color(0xFF78350F)
                        )
                        Text(
                            text = formattedDate,
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isDark) Color.White else Color(0xFF1E293B)
                        )
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "Verified Portal Seal",
                            fontSize = 10.sp,
                            color = if (isDark) Color(0xFF94A3B8) else Color(0xFF78350F)
                        )
                        Text(
                            text = "ಕಲಿಕಾ ಕರ್ನಾಟಕ ✍️",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFD97706)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Share / Save Button
                Button(
                    onClick = {
                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(
                                Intent.EXTRA_SUBJECT,
                                "School Quiz Certificate of Excellence: ${certificateData.studentName}"
                            )
                            val stdShareText = when (certificateData.standard) {
                                11 -> "Morarji"
                                12 -> "NMMS"
                                else -> "Std ${certificateData.standard}"
                            }
                            putExtra(
                                Intent.EXTRA_TEXT,
                                "🎓 Certificate of Excellence!\n\nStudent: ${certificateData.studentName}\nStandard: $stdShareText\nSubject: ${certificateData.subjectTitle}\nUnit: ${certificateData.unitName}\nScore: ${certificateData.score}/${certificateData.totalQuestions} (${certificateData.accuracyPercentage}%)\nGrade: $grade\nVerified Certificate ID: $certificateId\n\nIssued by Karnataka School Quiz Portal on $formattedDate ✨"
                            )
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "Share Certificate via"))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("share_certificate_button"),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFD97706)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share",
                        modifier = Modifier.size(16.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Share Certificate 🎓",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                }
            }
        }
    }
}
