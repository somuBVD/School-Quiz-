package com.example.ui.theme

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.SettingsBrightness
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.SettingsViewModel
import com.example.ThemeMode
import com.example.localization.LocalAppStrings

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
            AnimatedContent(
                targetState = isDark,
                transitionSpec = { fadeIn(tween(200)) togetherWith fadeOut(tween(200)) },
                label = "themeIconFeedback"
            ) { dark ->
                Icon(
                    imageVector = if (dark) Icons.Rounded.DarkMode else Icons.Rounded.LightMode,
                    contentDescription = null,
                    tint = if (dark) Color(0xFFFBBF24) else Color(0xFFEA580C),
                    modifier = Modifier.size(if (compact) 16.dp else 18.dp)
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
    val themeMode by settingsViewModel.themeMode.collectAsState()

    val iconBg by animateColorAsState(
        targetValue = if (isDark) Color(0xFF312E81) else Color(0xFFFEF3C7),
        animationSpec = tween(250),
        label = "themeCardIconBg"
    )
    val iconTint by animateColorAsState(
        targetValue = if (isDark) Color(0xFFFBBF24) else Color(0xFFD97706),
        animationSpec = tween(250),
        label = "themeCardIconTint"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(role = Role.Switch) {
                settingsViewModel.setDarkMode(!isDark)
            }
            .testTag("theme_switch_card"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outlineVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(44.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = iconBg
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        AnimatedContent(
                            targetState = isDark,
                            transitionSpec = { fadeIn(tween(200)) togetherWith fadeOut(tween(200)) },
                            label = "themeCardIconAnim"
                        ) { dark ->
                            Icon(
                                imageVector = if (dark) Icons.Rounded.DarkMode else Icons.Rounded.LightMode,
                                contentDescription = null,
                                tint = iconTint,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = if (isDark) {
                                stringResource(R.string.theme_dark_active)
                            } else {
                                stringResource(R.string.theme_light_active)
                            },
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        if (themeMode == ThemeMode.SYSTEM) {
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Text(
                                    text = stringResource(R.string.theme_auto_badge),
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 1.dp)
                                )
                            }
                        }
                    }
                    Text(
                        text = if (isDark) {
                            stringResource(R.string.theme_dark_subtitle)
                        } else {
                            stringResource(R.string.theme_light_subtitle)
                        },
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

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

private data class ThemeModeChoice(
    val mode: ThemeMode,
    val labelRes: Int,
    val icon: ImageVector,
    val previewBgTop: Color,
    val previewBgBottom: Color,
    val previewAccent: Color
)

/**
 * Full system-wide Appearance & Theme control section for App Settings.
 * Includes a primary instant Light/Dark toggle switch plus a 3-way visual
 * mode picker (Light, Dark, System Default) with live preview swatches.
 */
@Composable
fun SystemThemeSettingsPanel(
    settingsViewModel: SettingsViewModel,
    modifier: Modifier = Modifier
) {
    val isDark by settingsViewModel.isDarkMode.collectAsState()
    val themeMode by settingsViewModel.themeMode.collectAsState()
    val systemInDark = isSystemInDarkTheme()
    val strings = LocalAppStrings.current

    val choices = remember {
        listOf(
            ThemeModeChoice(
                mode = ThemeMode.LIGHT,
                labelRes = R.string.theme_mode_light,
                icon = Icons.Rounded.LightMode,
                previewBgTop = Color(0xFFFFFFFF),
                previewBgBottom = Color(0xFFE0E7FF),
                previewAccent = Color(0xFF4F46E5)
            ),
            ThemeModeChoice(
                mode = ThemeMode.DARK,
                labelRes = R.string.theme_mode_dark,
                icon = Icons.Rounded.DarkMode,
                previewBgTop = Color(0xFF0F172A),
                previewBgBottom = Color(0xFF312E81),
                previewAccent = Color(0xFFFBBF24)
            ),
            ThemeModeChoice(
                mode = ThemeMode.SYSTEM,
                labelRes = R.string.theme_mode_system,
                icon = Icons.Rounded.SettingsBrightness,
                previewBgTop = Color(0xFF4F46E5),
                previewBgBottom = Color(0xFF0F172A),
                previewAccent = Color(0xFF34D399)
            )
        )
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("system_theme_settings_panel"),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    imageVector = if (isDark) Icons.Rounded.DarkMode else Icons.Rounded.LightMode,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = strings.appearanceSection,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
            ) {
                Text(
                    text = when (themeMode) {
                        ThemeMode.LIGHT -> stringResource(R.string.theme_mode_light)
                        ThemeMode.DARK -> stringResource(R.string.theme_mode_dark)
                        ThemeMode.SYSTEM -> stringResource(R.string.theme_mode_system)
                    },
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                )
            }
        }

        Text(
            text = strings.appearanceDesc,
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // Primary 1-tap Light/Dark Switch Card
        ThemeSwitchCard(
            settingsViewModel = settingsViewModel,
            modifier = Modifier.testTag("settings_theme_switch_card")
        )

        // 3-Way Segmented Mode Selector with Mini Live Preview Swatches
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            choices.forEach { choice ->
                val isSelected = themeMode == choice.mode
                val label = stringResource(choice.labelRes)
                val cardBorderColor by animateColorAsState(
                    targetValue = if (isSelected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.outlineVariant
                    },
                    animationSpec = tween(200),
                    label = "themeChoiceBorder"
                )
                val cardContainerColor by animateColorAsState(
                    targetValue = if (isSelected) {
                        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.65f)
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant
                    },
                    animationSpec = tween(200),
                    label = "themeChoiceBg"
                )

                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 84.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .clickable(role = Role.RadioButton) {
                            settingsViewModel.setThemeMode(choice.mode, systemInDark)
                        }
                        .testTag("theme_option_${choice.mode.name.lowercase()}"),
                    shape = RoundedCornerShape(14.dp),
                    color = cardContainerColor,
                    border = BorderStroke(
                        width = if (isSelected) 2.dp else 1.dp,
                        color = cardBorderColor
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        // Mini palette swatch preview
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(26.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(choice.previewBgTop, choice.previewBgBottom)
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    imageVector = choice.icon,
                                    contentDescription = null,
                                    tint = choice.previewAccent,
                                    modifier = Modifier.size(14.dp)
                                )
                                Box(
                                    modifier = Modifier
                                        .size(width = 18.dp, height = 4.dp)
                                        .clip(CircleShape)
                                        .background(choice.previewAccent.copy(alpha = 0.85f))
                                )
                            }
                            if (isSelected) {
                                Icon(
                                    imageVector = Icons.Rounded.CheckCircle,
                                    contentDescription = stringResource(R.string.theme_selected_cd),
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(2.dp)
                                        .size(12.dp)
                                )
                            }
                        }

                        Text(
                            text = label,
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.SemiBold,
                            color = if (isSelected) {
                                MaterialTheme.colorScheme.onPrimaryContainer
                            } else {
                                MaterialTheme.colorScheme.onSurface
                            },
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
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
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
