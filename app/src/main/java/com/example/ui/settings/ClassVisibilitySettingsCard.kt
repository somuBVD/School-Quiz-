package com.example.ui.settings

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.SettingsViewModel

/**
 * Data model for a selectable class / curriculum entry in the settings.
 */
data class ClassVisibilityItem(
    val std: Int,
    val title: String,
    val subtitle: String,
    val badgeLabel: String,
    val badgeColor: Color
)

val ALL_CONFIGURABLE_CLASSES = listOf(
    ClassVisibilityItem(
        std = 6,
        title = "Class 6 (Std 6)",
        subtitle = "Science, Maths, Social, Kannada, English, Hindi",
        badgeLabel = "6",
        badgeColor = Color(0xFF3B82F6)
    ),
    ClassVisibilityItem(
        std = 7,
        title = "Class 7 (Std 7)",
        subtitle = "Science, Maths, Social, Kannada, English, Hindi",
        badgeLabel = "7",
        badgeColor = Color(0xFF0EA5E9)
    ),
    ClassVisibilityItem(
        std = 8,
        title = "Class 8 (Std 8)",
        subtitle = "Science, Maths, Social, Kannada, English, Hindi",
        badgeLabel = "8",
        badgeColor = Color(0xFF059669)
    ),
    ClassVisibilityItem(
        std = 9,
        title = "Class 9 (Std 9)",
        subtitle = "Science, Maths, Social, Kannada, English, Hindi",
        badgeLabel = "9",
        badgeColor = Color(0xFF10B981)
    ),
    ClassVisibilityItem(
        std = 10,
        title = "Class 10 (SSLC)",
        subtitle = "Science, Maths, Social, Kannada, English, Hindi",
        badgeLabel = "10",
        badgeColor = Color(0xFF4F46E5)
    ),
    ClassVisibilityItem(
        std = 11,
        title = "Morarji (MDRS Entrance)",
        subtitle = "Kannada, English, Maths, Environmental Science, GK, Mental Ability",
        badgeLabel = "MD",
        badgeColor = Color(0xFFD97706)
    ),
    ClassVisibilityItem(
        std = 12,
        title = "NMMS (Scholarship Exam)",
        subtitle = "GMAT (Mental Ability) & SAT (Maths, Science, Social)",
        badgeLabel = "NM",
        badgeColor = Color(0xFF8B5CF6)
    )
)

/**
 * Material 3 Card inside Settings that allows students and teachers to hide and show
 * class switches for Standards 6 to 10, Morarji, and NMMS.
 */
@Composable
fun ClassVisibilitySettingsCard(
    settingsViewModel: SettingsViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val visibleStandards by settingsViewModel.visibleStandards.collectAsState()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("class_visibility_settings_card"),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header: Title, Description, and Show All action
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Visible Classes / Curriculum",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Hide or show classes to focus only on what you study",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
                ) {
                    Text(
                        text = "${visibleStandards.size} of ${ALL_CONFIGURABLE_CLASSES.size} Active",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                    )
                }
            }

            // Quick Show All Button if some classes are hidden
            if (visibleStandards.size < ALL_CONFIGURABLE_CLASSES.size) {
                TextButton(
                    onClick = {
                        settingsViewModel.setAllStandardsVisible()
                        Toast.makeText(context, "All classes are now visible", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .align(Alignment.End)
                        .testTag("reset_visible_classes_button"),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.RestartAlt,
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Show All Classes",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

            // Quick Preset Filters
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Presets:",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                AssistChip(
                    onClick = {
                        settingsViewModel.setAllStandardsVisible()
                        Toast.makeText(context, "All classes enabled", Toast.LENGTH_SHORT).show()
                    },
                    label = { Text("All Classes", fontSize = 10.5.sp) },
                    modifier = Modifier.testTag("preset_all_classes")
                )
                AssistChip(
                    onClick = {
                        settingsViewModel.setVisibleStandards(setOf(8, 9, 10))
                        Toast.makeText(context, "High School (8, 9, 10) enabled", Toast.LENGTH_SHORT).show()
                    },
                    label = { Text("High School (8-10)", fontSize = 10.5.sp) },
                    modifier = Modifier.testTag("preset_high_school")
                )
                AssistChip(
                    onClick = {
                        settingsViewModel.setVisibleStandards(setOf(6, 7))
                        Toast.makeText(context, "Middle School (6, 7) enabled", Toast.LENGTH_SHORT).show()
                    },
                    label = { Text("Middle (6-7)", fontSize = 10.5.sp) },
                    modifier = Modifier.testTag("preset_middle_school")
                )
                AssistChip(
                    onClick = {
                        settingsViewModel.setVisibleStandards(setOf(11, 12))
                        Toast.makeText(context, "Competitive (Morarji & NMMS) enabled", Toast.LENGTH_SHORT).show()
                    },
                    label = { Text("Morarji & NMMS", fontSize = 10.5.sp) },
                    modifier = Modifier.testTag("preset_competitive")
                )
            }

            // List of Class Switches
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ALL_CONFIGURABLE_CLASSES.forEach { item ->
                    val isVisible = visibleStandards.contains(item.std)
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = if (isVisible)
                            MaterialTheme.colorScheme.surface
                        else
                            MaterialTheme.colorScheme.surface.copy(alpha = 0.45f),
                        border = BorderStroke(
                            1.dp,
                            if (isVisible)
                                item.badgeColor.copy(alpha = 0.35f)
                            else
                                MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("class_visibility_row_${item.std}")
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
                                modifier = Modifier.weight(1f)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(
                                            if (isVisible) item.badgeColor else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = item.badgeLabel,
                                        color = Color.White,
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 12.sp
                                    )
                                }

                                Spacer(modifier = Modifier.width(10.dp))

                                Column(modifier = Modifier.weight(1f, fill = false)) {
                                    Text(
                                        text = item.title,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isVisible)
                                            MaterialTheme.colorScheme.onSurface
                                        else
                                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = item.subtitle,
                                        fontSize = 10.5.sp,
                                        color = if (isVisible)
                                            MaterialTheme.colorScheme.onSurfaceVariant
                                        else
                                            MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f),
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Switch(
                                checked = isVisible,
                                onCheckedChange = {
                                    val success = settingsViewModel.toggleStandardVisibility(item.std)
                                    if (!success) {
                                        Toast.makeText(
                                            context,
                                            "At least one class must remain visible",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = item.badgeColor
                                ),
                                modifier = Modifier.testTag("switch_class_${item.std}")
                            )
                        }
                    }
                }
            }
        }
    }
}
