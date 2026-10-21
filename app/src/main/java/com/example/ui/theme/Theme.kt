package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.graphics.Color

private val DarkColorScheme =
  darkColorScheme(
    primary = Color(0xFF818CF8), // indigo-400
    onPrimary = Color(0xFF0F172A), // slate-900
    primaryContainer = Color(0xFF312E81), // indigo-900
    onPrimaryContainer = Color(0xFFE0E7FF), // indigo-100
    secondary = Color(0xFF94A3B8), // slate-400
    onSecondary = Color(0xFF0F172A),
    background = Color(0xFF0F172A), // slate-900
    onBackground = Color(0xFFF8FAFC),
    surface = Color(0xFF1E293B), // slate-800
    onSurface = Color(0xFFF8FAFC),
    surfaceVariant = Color(0xFF334155), // slate-700
    onSurfaceVariant = Color(0xFFCBD5E1)
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
    background = Color(0xFFFDFBFF), // Off-white/violet background
    onBackground = Color(0xFF0F172A), // Slate 900 dark text
    surface = Color.White,
    onSurface = Color(0xFF0F172A),
    surfaceVariant = Color(0xFFF1F5F9), // Slate 100
    onSurfaceVariant = Color(0xFF475569) // Slate 600
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is disabled by default for strict theme compliance
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

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
