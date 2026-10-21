package com.example.ui.theme

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.SettingsViewModel

/**
 * A persistent Switch component in the UI that triggers [SettingsViewModel]
 * to update the global app theme, providing immediate visual feedback
 * for light and dark mode transitions.
 */
@Composable
fun ThemeSwitch(
    settingsViewModel: SettingsViewModel,
    modifier: Modifier = Modifier,
    showLabel: Boolean = true,
    compact: Boolean = false
) {
    val isDark by settingsViewModel.isDarkMode.collectAsState()

    PersistentThemeSwitch(
        isDark = isDark,
        onToggleTheme = { checked ->
            settingsViewModel.setDarkMode(checked)
        },
        modifier = modifier,
        showLabel = showLabel,
        compact = compact
    )
}

/**
 * Stateless persistent theme Switch component with immediate visual feedback.
 */
@Composable
fun PersistentThemeSwitch(
    isDark: Boolean,
    onToggleTheme: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    showLabel: Boolean = true,
    compact: Boolean = false
) {
    val containerBg by animateColorAsState(
        targetValue = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
        animationSpec = tween(durationMillis = 250),
        label = "switchContainerBg"
    )
    val borderColor by animateColorAsState(
        targetValue = if (isDark) Color(0xFF334155) else Color(0xFFCBD5E1),
        animationSpec = tween(durationMillis = 250),
        label = "switchBorderColor"
    )

    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .testTag("persistent_theme_switch_container"),
        shape = RoundedCornerShape(20.dp),
        color = containerBg,
        border = BorderStroke(1.dp, borderColor)
    ) {
        Row(
            modifier = Modifier
                .clickable { onToggleTheme(!isDark) }
                .padding(horizontal = if (compact) 6.dp else 10.dp, vertical = if (compact) 2.dp else 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            // Visual label / emoji with animated feedback
            AnimatedContent(
                targetState = isDark,
                transitionSpec = { fadeIn(tween(200)) togetherWith fadeOut(tween(200)) },
                label = "themeIconFeedback"
            ) { dark ->
                Text(
                    text = if (dark) "🌙" else "☀️",
                    fontSize = if (compact) 14.sp else 16.sp
                )
            }

            if (showLabel) {
                AnimatedContent(
                    targetState = isDark,
                    transitionSpec = { fadeIn(tween(200)) togetherWith fadeOut(tween(200)) },
                    label = "themeLabelFeedback"
                ) { dark ->
                    Text(
                        text = if (dark) "Dark" else "Light",
                        fontSize = if (compact) 11.sp else 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (dark) Color(0xFFFBBF24) else Color(0xFF4F46E5)
                    )
                }
            }

            // Material 3 Switch component
            Switch(
                checked = isDark,
                onCheckedChange = { checked ->
                    onToggleTheme(checked)
                },
                modifier = Modifier
                    .semantics {
                        contentDescription = if (isDark) "Switch to Light Mode" else "Switch to Dark Mode"
                    }
                    .testTag("theme_switch"),
                thumbContent = {
                    Icon(
                        imageVector = if (isDark) Icons.Filled.DarkMode else Icons.Filled.LightMode,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                        tint = if (isDark) Color(0xFF1E293B) else Color(0xFFEA580C)
                    )
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFFFBBF24),
                    checkedTrackColor = Color(0xFF4F46E5),
                    checkedBorderColor = Color(0xFF6366F1),
                    uncheckedThumbColor = Color(0xFFF8FAFC),
                    uncheckedTrackColor = Color(0xFFCBD5E1),
                    uncheckedBorderColor = Color(0xFF94A3B8)
                )
            )
        }
    }
}

/**
 * A dedicated Card row hosting the persistent theme Switch, ideal for settings menus
 * and configuration panels.
 */
@Composable
fun ThemeSwitchCard(
    settingsViewModel: SettingsViewModel,
    modifier: Modifier = Modifier
) {
    val isDark by settingsViewModel.isDarkMode.collectAsState()

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("theme_switch_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        border = BorderStroke(
            1.dp,
            if (isDark) Color(0xFF334155) else Color(0xFFE2E8F0)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(42.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = if (isDark) Color(0xFF312E81) else Color(0xFFE0E7FF)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(if (isDark) "🌙" else "☀️", fontSize = 20.sp)
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = if (isDark) "Dark Mode Active" else "Light Mode Active",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = if (isDark) "Deep palette for low light" else "High contrast bright palette",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Switch(
                checked = isDark,
                onCheckedChange = { checked ->
                    settingsViewModel.setDarkMode(checked)
                },
                modifier = Modifier
                    .semantics {
                        contentDescription = if (isDark) "Switch to Light Mode" else "Switch to Dark Mode"
                    }
                    .testTag("card_theme_switch"),
                thumbContent = {
                    Icon(
                        imageVector = if (isDark) Icons.Filled.DarkMode else Icons.Filled.LightMode,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                        tint = if (isDark) Color(0xFF1E293B) else Color(0xFFEA580C)
                    )
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFFFBBF24),
                    checkedTrackColor = Color(0xFF4F46E5),
                    checkedBorderColor = Color(0xFF6366F1),
                    uncheckedThumbColor = Color(0xFFF8FAFC),
                    uncheckedTrackColor = Color(0xFFCBD5E1),
                    uncheckedBorderColor = Color(0xFF94A3B8)
                )
            )
        }
    }
}

/**
 * A compact, accessible icon button for toggling light/dark mode globally.
 * Features accessibility labels, animated icon transition, and test tags.
 */
@Composable
fun GlobalThemeToggleButton(
    isDark: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onToggle,
        modifier = modifier
            .testTag("global_theme_toggle_button")
            .semantics {
                contentDescription = if (isDark) "Switch to Light Mode" else "Switch to Dark Mode"
            }
    ) {
        AnimatedContent(
            targetState = isDark,
            transitionSpec = { fadeIn(tween(200)) togetherWith fadeOut(tween(200)) },
            label = "globalThemeToggleAnim"
        ) { dark ->
            Icon(
                imageVector = if (dark) Icons.Filled.LightMode else Icons.Filled.DarkMode,
                contentDescription = if (dark) "Switch to Light Mode" else "Switch to Dark Mode",
                tint = if (dark) Color(0xFFFBBF24) else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
