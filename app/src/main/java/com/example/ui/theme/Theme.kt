package com.example.ui.theme

import android.app.Activity
import android.content.ContextWrapper
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val LocalAppDarkTheme = staticCompositionLocalOf { false }

private val DarkColorScheme =
    darkColorScheme(
        primary = Color(0xFF818CF8), // Indigo 400
        onPrimary = Color(0xFF0F172A), // Slate 900
        primaryContainer = Color(0xFF312E81), // Indigo 900
        onPrimaryContainer = Color(0xFFE0E7FF), // Indigo 100
        secondary = Color(0xFF94A3B8), // Slate 400
        onSecondary = Color(0xFF0F172A),
        secondaryContainer = Color(0xFF1E293B), // Slate 800
        onSecondaryContainer = Color(0xFFE2E8F0), // Slate 200
        tertiary = Color(0xFF34D399), // Emerald 400
        onTertiary = Color(0xFF064E3B),
        tertiaryContainer = Color(0xFF065F46),
        onTertiaryContainer = Color(0xFFD1FAE5),
        background = Color(0xFF0F172A), // Slate 900
        onBackground = Color(0xFFF8FAFC),
        surface = Color(0xFF1E293B), // Slate 800
        onSurface = Color(0xFFF8FAFC),
        surfaceVariant = Color(0xFF283548), // Deep Slate elevated card
        onSurfaceVariant = Color(0xFFCBD5E1),
        surfaceContainerLowest = Color(0xFF0B1120),
        surfaceContainerLow = Color(0xFF131C31),
        surfaceContainer = Color(0xFF1E293B),
        surfaceContainerHigh = Color(0xFF273549),
        surfaceContainerHighest = Color(0xFF334155),
        outline = Color(0xFF475569),
        outlineVariant = Color(0xFF334155),
        error = Color(0xFFF87171),
        onError = Color(0xFF450A0A),
        errorContainer = Color(0xFF7F1D1D),
        onErrorContainer = Color(0xFFFEE2E2)
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Color(0xFF4F46E5), // Indigo 600
        onPrimary = Color.White,
        primaryContainer = Color(0xFFE0E7FF), // Indigo 100
        onPrimaryContainer = Color(0xFF312E81), // Indigo 900
        secondary = Color(0xFF475569), // Slate 600
        onSecondary = Color.White,
        secondaryContainer = Color(0xFFF1F5F9), // Slate 100
        onSecondaryContainer = Color(0xFF1E293B), // Slate 800
        tertiary = Color(0xFF059669), // Emerald 600
        onTertiary = Color.White,
        tertiaryContainer = Color(0xFFD1FAE5),
        onTertiaryContainer = Color(0xFF065F46),
        background = Color(0xFFFDFBFF), // Crisp off-white background
        onBackground = Color(0xFF0F172A), // Slate 900 dark text
        surface = Color.White,
        onSurface = Color(0xFF0F172A),
        surfaceVariant = Color(0xFFF1F5F9), // Slate 100
        onSurfaceVariant = Color(0xFF475569), // Slate 600
        surfaceContainerLowest = Color.White,
        surfaceContainerLow = Color(0xFFF8FAFC),
        surfaceContainer = Color(0xFFF1F5F9),
        surfaceContainerHigh = Color(0xFFE2E8F0),
        surfaceContainerHighest = Color(0xFFCBD5E1),
        outline = Color(0xFF94A3B8),
        outlineVariant = Color(0xFFE2E8F0),
        error = Color(0xFFDC2626),
        onError = Color.White,
        errorContainer = Color(0xFFFEE2E2),
        onErrorContainer = Color(0xFF7F1D1D)
    )

private tailrec fun android.content.Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is disabled by default for strict brand theme compliance
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    // Keep system status bar & navigation bar icon appearances synced with active theme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = view.context.findActivity()?.window
            if (window != null) {
                val controller = WindowCompat.getInsetsController(window, view)
                controller.isAppearanceLightStatusBars = !darkTheme
                controller.isAppearanceLightNavigationBars = !darkTheme
            }
        }
    }

    CompositionLocalProvider(LocalAppDarkTheme provides darkTheme) {
        MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
    }
}
