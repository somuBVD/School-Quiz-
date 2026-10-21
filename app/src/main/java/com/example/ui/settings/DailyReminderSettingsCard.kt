package com.example.ui.settings

import android.Manifest
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import java.util.Locale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.SubjectType
import com.example.notification.DailyQuizReminderWorker
import com.example.notification.DailyReminderScheduler
import com.example.notification.ReminderSettings

/**
 * Material 3 Card allowing students to configure daily quiz practice reminders,
 * choose preferred study times, preferred focus subjects, and motivational tones.
 * Backed by Android WorkManager for persistent, battery-efficient background execution.
 */
@Composable
fun DailyReminderSettingsCard(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var settings by remember { mutableStateOf(DailyReminderScheduler.getSettings(context)) }
    var selectedHour by remember { mutableIntStateOf(settings.hour) }
    var selectedMinute by remember { mutableIntStateOf(settings.minute) }
    var isEnabled by remember { mutableStateOf(settings.isEnabled) }
    var selectedSubject by remember { mutableStateOf(settings.preferredSubject) }
    var customMsg by remember { mutableStateOf(settings.customMessage) }

    // Android 13+ Notification Permission Launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            DailyQuizReminderWorker.enqueueImmediateTest(context)
            DailyReminderScheduler.sendImmediateTestReminder(context)
            Toast.makeText(context, "⚡ WorkManager practice reminder dispatched!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Notification permission is needed for reminders", Toast.LENGTH_LONG).show()
        }
    }

    val triggerNotificationWithPermission = {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            DailyQuizReminderWorker.enqueueImmediateTest(context)
            DailyReminderScheduler.sendImmediateTestReminder(context)
            Toast.makeText(context, "⚡ WorkManager practice reminder dispatched!", Toast.LENGTH_SHORT).show()
        }
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("daily_reminder_settings_card"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Header Row: Icon, Full Title & Toggle Switch (Uncrowded, perfectly horizontal)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f, fill = false),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF4F46E5).copy(alpha = 0.14f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Alarm,
                            contentDescription = "Daily Reminder",
                            tint = Color(0xFF4F46E5),
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    Text(
                        text = "Daily quiz reminder",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Switch(
                    checked = isEnabled,
                    onCheckedChange = { checked ->
                        isEnabled = checked
                        if (checked) {
                            DailyReminderScheduler.scheduleDailyReminder(
                                context = context,
                                hour = selectedHour,
                                minute = selectedMinute,
                                customMessage = customMsg,
                                preferredSubject = selectedSubject
                            )
                            Toast.makeText(
                                context,
                                "Daily reminder scheduled for ${settings.copy(hour = selectedHour, minute = selectedMinute).formattedTime}",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            DailyReminderScheduler.cancelDailyReminder(context)
                            Toast.makeText(context, "Daily reminder cancelled", Toast.LENGTH_SHORT).show()
                        }
                        settings = DailyReminderScheduler.getSettings(context)
                    },
                    modifier = Modifier
                        .scale(0.8f)
                        .testTag("daily_reminder_switch")
                )
            }

            // Subtitle & Status indicator row (Refined & balanced)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (isEnabled) "Scheduled daily at ${settings.formattedTime}" else "Background alerts to maintain daily streak",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f, fill = false)
                )

                if (isEnabled) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xFF10B981).copy(alpha = 0.12f),
                        border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.35f))
                    ) {
                        Text(
                            text = "Active",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF10B981),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            AnimatedVisibility(
                visible = isEnabled,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)

                    // WorkManager System Status Banner
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = Color(0xFF4F46E5).copy(alpha = 0.08f),
                        border = BorderStroke(1.dp, Color(0xFF4F46E5).copy(alpha = 0.25f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("⚡", fontSize = 13.sp)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Scheduled daily via WorkManager at:",
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                                Text(
                                    text = "Survives app termination and device reboots",
                                    fontSize = 9.5.sp,
                                    color = Color(0xFF64748B)
                                )
                            }
                            Text(
                                text = ReminderSettings(isEnabled, selectedHour, selectedMinute).formattedTime,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFF4F46E5),
                                modifier = Modifier.testTag("scheduled_reminder_time_text")
                            )
                        }
                    }

                    // 1. Quick Preset Time Chips
                    Text(
                        text = "Choose Practice Time Preset:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    val presets = listOf(
                        Triple(7, 30, "🌅 7:30 AM Morning Boost"),
                        Triple(16, 0, "🌤️ 4:00 PM After School"),
                        Triple(18, 0, "🌆 6:00 PM Evening Study"),
                        Triple(20, 30, "🌙 8:30 PM Night Revision")
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        presets.forEach { (h, m, label) ->
                            val isSelected = selectedHour == h && selectedMinute == m
                            FilterChip(
                                selected = isSelected,
                                onClick = {
                                    selectedHour = h
                                    selectedMinute = m
                                    DailyReminderScheduler.scheduleDailyReminder(
                                        context = context,
                                        hour = h,
                                        minute = m,
                                        customMessage = customMsg,
                                        preferredSubject = selectedSubject
                                    )
                                    settings = DailyReminderScheduler.getSettings(context)
                                    Toast.makeText(context, "Reminder time set to $label", Toast.LENGTH_SHORT).show()
                                },
                                label = {
                                    Text(
                                        text = label,
                                        fontSize = 11.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                    )
                                },
                                modifier = Modifier.testTag("preset_${h}_$m")
                            )
                        }
                    }

                    // 2. Custom Time Adjuster (+ / - Hour buttons)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Fine-tune Hour:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            OutlinedButton(
                                onClick = {
                                    val newH = (selectedHour - 1 + 24) % 24
                                    selectedHour = newH
                                    DailyReminderScheduler.scheduleDailyReminder(
                                        context = context,
                                        hour = newH,
                                        minute = selectedMinute,
                                        customMessage = customMsg,
                                        preferredSubject = selectedSubject
                                    )
                                    settings = DailyReminderScheduler.getSettings(context)
                                },
                                modifier = Modifier
                                    .size(36.dp)
                                    .testTag("decrease_reminder_hour_button"),
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text("-1h", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }

                            Text(
                                text = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            OutlinedButton(
                                onClick = {
                                    val newH = (selectedHour + 1) % 24
                                    selectedHour = newH
                                    DailyReminderScheduler.scheduleDailyReminder(
                                        context = context,
                                        hour = newH,
                                        minute = selectedMinute,
                                        customMessage = customMsg,
                                        preferredSubject = selectedSubject
                                    )
                                    settings = DailyReminderScheduler.getSettings(context)
                                },
                                modifier = Modifier
                                    .size(36.dp)
                                    .testTag("increase_reminder_hour_button"),
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text("+1h", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    // 3. Preferred Focus Subject Selector
                    Text(
                        text = "Preferred Study Subject:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    val subjectOptions = listOf("All Subjects") + SubjectType.entries.map { it.displayName }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        subjectOptions.forEach { subject ->
                            val isSelected = selectedSubject == subject
                            FilterChip(
                                selected = isSelected,
                                onClick = {
                                    selectedSubject = subject
                                    DailyReminderScheduler.scheduleDailyReminder(
                                        context = context,
                                        hour = selectedHour,
                                        minute = selectedMinute,
                                        customMessage = customMsg,
                                        preferredSubject = subject
                                    )
                                    settings = DailyReminderScheduler.getSettings(context)
                                },
                                label = {
                                    Text(
                                        text = subject,
                                        fontSize = 11.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                    )
                                },
                                modifier = Modifier.testTag("subject_chip_$subject")
                            )
                        }
                    }

                    // 4. Motivational Reminder Preset Message
                    Text(
                        text = "Motivational Message Theme:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    val messageThemes = listOf(
                        Pair("🔥 Streak Protector", "Keep your learning streak alive! Practice 5 quick questions today."),
                        Pair("⭐ Rank Climber", "Climb the school leaderboard! Solve today's practice questions & earn XP."),
                        Pair("🧠 Brain Workout", "Quick 5-minute study session to master key school concepts."),
                        Pair("🎯 Exam Mastery", "Daily practice makes permanent! Test your knowledge in $selectedSubject.")
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        messageThemes.forEach { (title, msg) ->
                            val isSelected = customMsg == msg
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable {
                                        customMsg = msg
                                        DailyReminderScheduler.scheduleDailyReminder(
                                            context = context,
                                            hour = selectedHour,
                                            minute = selectedMinute,
                                            customMessage = msg,
                                            preferredSubject = selectedSubject
                                        )
                                        settings = DailyReminderScheduler.getSettings(context)
                                    },
                                color = if (isSelected) Color(0xFF4F46E5).copy(alpha = 0.12f) else MaterialTheme.colorScheme.surface,
                                border = BorderStroke(
                                    1.dp,
                                    if (isSelected) Color(0xFF4F46E5) else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
                                )
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = isSelected,
                                        onClick = {
                                            customMsg = msg
                                            DailyReminderScheduler.scheduleDailyReminder(
                                                context = context,
                                                hour = selectedHour,
                                                minute = selectedMinute,
                                                customMessage = msg,
                                                preferredSubject = selectedSubject
                                            )
                                            settings = DailyReminderScheduler.getSettings(context)
                                        },
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = title,
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isSelected) Color(0xFF4F46E5) else MaterialTheme.colorScheme.onSurface
                                        )
                                        Text(
                                            text = msg,
                                            fontSize = 9.5.sp,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // 5. WorkManager Test & Trigger Button (Full horizontal line alignment)
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = "Verify notification delivery on device:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Button(
                            onClick = triggerNotificationWithPermission,
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4F46E5)),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(vertical = 10.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("send_test_reminder_button")
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.NotificationsActive,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Test WorkManager Alert",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
