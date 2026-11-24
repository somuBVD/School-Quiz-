package com.example.ui.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.R
import kotlinx.coroutines.launch
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
    val coroutineScope = rememberCoroutineScope()
    var isProcessingShare by remember { mutableStateOf(false) }

    val dateFormat = remember { SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()) }
    val formattedDate = remember(certificateData.completedAt) {
        dateFormat.format(Date(certificateData.completedAt))
    }

    val grade = remember(certificateData.accuracyPercentage) {
        when {
            certificateData.accuracyPercentage == 100 -> "Perfect (A++)"
            certificateData.accuracyPercentage >= 90 -> "Distinction (A+)"
            certificateData.accuracyPercentage >= 75 -> "First Class (A)"
            certificateData.accuracyPercentage >= 60 -> "Second Class (B)"
            else -> "Pass Certificate"
        }
    }

    val certificateId = remember(certificateData.completedAt, certificateData.score) {
        "KSQ-${(certificateData.completedAt % 100000).toString().padStart(5, '0')}-${certificateData.accuracyPercentage}"
    }

    val shareCaption = remember(certificateData, grade, certificateId, formattedDate) {
        CertificateShareHelper.buildShareCaption(
            certificateData = certificateData,
            grade = grade,
            certificateId = certificateId,
            formattedDate = formattedDate
        )
    }

    fun triggerShare(platform: SocialSharePlatform) {
        if (isProcessingShare) return
        coroutineScope.launch {
            isProcessingShare = true
            try {
                CertificateShareHelper.shareCertificate(
                    context = context,
                    certificateData = certificateData,
                    grade = grade,
                    certificateId = certificateId,
                    formattedDate = formattedDate,
                    platform = platform
                )
            } finally {
                isProcessingShare = false
            }
        }
    }

    val goldPrimary = Color(0xFFD97706)
    val goldDeep = Color(0xFFB45309)
    val goldTitle = if (isDark) Color(0xFFFDE68A) else Color(0xFF92400E)
    val parchmentBg = if (isDark) Color(0xFF0F172A) else Color(0xFFFFFBEB)
    val bodyMuted = if (isDark) Color(0xFFCBD5E1) else Color(0xFF64748B)
    val labelGold = if (isDark) Color(0xFFFCD34D) else Color(0xFF78350F)

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 560.dp)
                .padding(16.dp)
                .testTag("quiz_certificate_dialog"),
            shape = RoundedCornerShape(24.dp),
            color = parchmentBg,
            border = BorderStroke(3.dp, goldPrimary),
            tonalElevation = 10.dp
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                // Ornate Compose Canvas inner diploma frame & corner filigree accents
                Canvas(modifier = Modifier.matchParentSize()) {
                    val inset = 10.dp.toPx()
                    drawRoundRect(
                        color = goldPrimary.copy(alpha = if (isDark) 0.45f else 0.55f),
                        topLeft = Offset(inset, inset),
                        size = Size(size.width - inset * 2f, size.height - inset * 2f),
                        cornerRadius = CornerRadius(18.dp.toPx(), 18.dp.toPx()),
                        style = Stroke(width = 1.5.dp.toPx())
                    )
                    val cornerOffset = 20.dp.toPx()
                    val dotRadius = 3.5.dp.toPx()
                    val corners = listOf(
                        Offset(cornerOffset, cornerOffset),
                        Offset(size.width - cornerOffset, cornerOffset),
                        Offset(cornerOffset, size.height - cornerOffset),
                        Offset(size.width - cornerOffset, size.height - cornerOffset)
                    )
                    corners.forEach { center ->
                        drawCircle(
                            color = goldPrimary.copy(alpha = 0.7f),
                            radius = dotRadius,
                            center = center
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 22.dp, vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Top Action Bar: Verified ID + Quick Share Icon + Close Button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = goldPrimary.copy(alpha = 0.15f),
                            border = BorderStroke(1.dp, goldPrimary)
                        ) {
                            Text(
                                text = "VERIFIED ID: $certificateId",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isDark) Color(0xFFFDE68A) else goldDeep,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(
                                onClick = { triggerShare(SocialSharePlatform.SYSTEM_SHEET) },
                                enabled = !isProcessingShare,
                                modifier = Modifier
                                    .size(48.dp)
                                    .testTag("certificate_top_share_icon")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Share,
                                    contentDescription = stringResource(R.string.certificate_share_button),
                                    tint = if (isDark) Color(0xFFFDE68A) else goldDeep
                                )
                            }

                            IconButton(
                                onClick = onDismiss,
                                modifier = Modifier
                                    .size(48.dp)
                                    .testTag("close_certificate_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = stringResource(R.string.certificate_close_description),
                                    tint = labelGold
                                )
                            }
                        }
                    }

                    // Perfect Score Ribbon Banner (when 100%)
                    if (certificateData.accuracyPercentage == 100) {
                        Surface(
                            shape = RoundedCornerShape(50),
                            color = goldPrimary
                        ) {
                            Text(
                                text = "★ PERFECT 100% SCORE ★",
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                letterSpacing = 0.8.sp,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                            )
                        }
                    }

                    // Decorative Gold Crest / Seal
                    Box(
                        modifier = Modifier
                            .size(68.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.radialGradient(
                                    colors = listOf(Color(0xFFFDE68A), goldPrimary)
                                )
                            )
                            .border(2.dp, goldDeep, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.WorkspacePremium,
                            contentDescription = "Excellence Seal",
                            tint = Color(0xFF78350F),
                            modifier = Modifier.size(36.dp)
                        )
                    }

                    Text(
                        text = stringResource(R.string.certificate_title),
                        fontFamily = FontFamily.Serif,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = goldTitle,
                        letterSpacing = 1.2.sp,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = stringResource(R.string.certificate_subtitle),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isDark) Color(0xFFFBBF24) else goldDeep,
                        textAlign = TextAlign.Center
                    )

                    HorizontalDivider(
                        modifier = Modifier
                            .width(180.dp)
                            .padding(vertical = 2.dp),
                        color = goldPrimary,
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
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily.Serif,
                        color = if (isDark) Color(0xFFFDE68A) else Color(0xFF1E293B),
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "For successfully completing and mastering the curriculum quiz for",
                        fontSize = 11.5.sp,
                        textAlign = TextAlign.Center,
                        color = bodyMuted
                    )

                    // Unit & Subject Details Card
                    Surface(
                        shape = RoundedCornerShape(14.dp),
                        color = if (isDark) Color(0xFF1E293B) else Color(0xFFFEF3C7),
                        border = BorderStroke(1.dp, if (isDark) Color(0xFFB45309) else Color(0xFFFCD34D)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            val stdLabel = CertificateShareHelper.formatStandardLabel(certificateData.standard)
                            Text(
                                text = "${certificateData.subjectTitle} • $stdLabel",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = if (isDark) Color(0xFFFBBF24) else goldDeep,
                                textAlign = TextAlign.Center
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
                                .background(goldPrimary.copy(alpha = 0.3f))
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
                                .background(goldPrimary.copy(alpha = 0.3f))
                        )

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = grade,
                                fontSize = 13.5.sp,
                                fontWeight = FontWeight.Black,
                                color = if (isDark) Color(0xFFFBBF24) else goldPrimary,
                                textAlign = TextAlign.Center
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
                            .padding(top = 6.dp),
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
                                color = if (isDark) Color(0xFFFBBF24) else goldPrimary
                            )
                        }
                    }

                    HorizontalDivider(
                        color = goldPrimary.copy(alpha = 0.25f),
                        thickness = 1.dp,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    // Primary Share Certificate Button (Shares High-Res PNG + Caption via Android Share Sheet)
                    Button(
                        onClick = { triggerShare(SocialSharePlatform.SYSTEM_SHEET) },
                        enabled = !isProcessingShare,
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 48.dp)
                            .testTag("share_certificate_button"),
                        shape = RoundedCornerShape(14.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = goldPrimary,
                            contentColor = Color.White
                        )
                    ) {
                        if (isProcessingShare) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(18.dp),
                                strokeWidth = 2.dp,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = stringResource(R.string.certificate_preparing_share),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = stringResource(R.string.certificate_share_button),
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = stringResource(R.string.certificate_share_button),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 14.sp
                            )
                        }
                    }

                    // Direct Social Media & Utility Actions Row
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.certificate_share_social_label),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = bodyMuted
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SocialPlatformShareChip(
                                label = stringResource(R.string.certificate_share_whatsapp),
                                badge = "WA",
                                accentColor = Color(0xFF16A34A),
                                isDark = isDark,
                                enabled = !isProcessingShare,
                                testTagName = "share_certificate_whatsapp",
                                onClick = { triggerShare(SocialSharePlatform.WHATSAPP) }
                            )

                            SocialPlatformShareChip(
                                label = stringResource(R.string.certificate_share_instagram),
                                badge = "IG",
                                accentColor = Color(0xFFE11D48),
                                isDark = isDark,
                                enabled = !isProcessingShare,
                                testTagName = "share_certificate_instagram",
                                onClick = { triggerShare(SocialSharePlatform.INSTAGRAM) }
                            )

                            SocialPlatformShareChip(
                                label = stringResource(R.string.certificate_share_x),
                                badge = "X",
                                accentColor = if (isDark) Color(0xFFE2E8F0) else Color(0xFF0F172A),
                                isDark = isDark,
                                enabled = !isProcessingShare,
                                testTagName = "share_certificate_x",
                                onClick = { triggerShare(SocialSharePlatform.X_TWITTER) }
                            )

                            // Save High-Res PNG to Gallery
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (isDark) Color(0xFF1E293B) else Color.White,
                                border = BorderStroke(1.dp, goldPrimary.copy(alpha = 0.5f)),
                                modifier = Modifier
                                    .heightIn(min = 48.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable(enabled = !isProcessingShare) {
                                        coroutineScope.launch {
                                            isProcessingShare = true
                                            try {
                                                CertificateShareHelper.saveCertificateToGallery(
                                                    context = context,
                                                    certificateData = certificateData,
                                                    grade = grade,
                                                    certificateId = certificateId,
                                                    formattedDate = formattedDate
                                                )
                                            } finally {
                                                isProcessingShare = false
                                            }
                                        }
                                    }
                                    .testTag("save_certificate_image_button")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Download,
                                        contentDescription = stringResource(R.string.certificate_save_image),
                                        tint = goldPrimary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        text = stringResource(R.string.certificate_save_image),
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isDark) Color.White else Color(0xFF1E293B)
                                    )
                                }
                            }

                            // Copy Achievement Caption
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = if (isDark) Color(0xFF1E293B) else Color.White,
                                border = BorderStroke(1.dp, goldPrimary.copy(alpha = 0.5f)),
                                modifier = Modifier
                                    .heightIn(min = 48.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .clickable(enabled = !isProcessingShare) {
                                        CertificateShareHelper.copyCaptionToClipboard(context, shareCaption)
                                    }
                                    .testTag("copy_certificate_text_button")
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ContentCopy,
                                        contentDescription = stringResource(R.string.certificate_copy_caption),
                                        tint = goldPrimary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        text = stringResource(R.string.certificate_copy_caption),
                                        fontSize = 11.5.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isDark) Color.White else Color(0xFF1E293B)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SocialPlatformShareChip(
    label: String,
    badge: String,
    accentColor: Color,
    isDark: Boolean,
    enabled: Boolean,
    testTagName: String,
    onClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(12.dp),
        color = accentColor.copy(alpha = if (isDark) 0.18f else 0.10f),
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.45f)),
        modifier = Modifier
            .heightIn(min = 48.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable(enabled = enabled, onClick = onClick)
            .testTag(testTagName)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(22.dp)
                    .clip(CircleShape)
                    .background(accentColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = badge,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Black,
                    color = if (accentColor == Color(0xFFE2E8F0)) Color(0xFF0F172A) else Color.White
                )
            }
            Text(
                text = label,
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = if (isDark) Color.White else Color(0xFF1E293B),
                maxLines = 1
            )
        }
    }
}
