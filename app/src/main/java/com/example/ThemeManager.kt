package com.example

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Enumeration of available theme modes across the application.
 */
enum class ThemeMode {
    LIGHT,
    DARK,
    SYSTEM
}

/**
 * Global ThemeManager class responsible for persisting and broadcasting
 * the active theme mode and light/dark state across the entire application.
 *
 * Provides reactive [StateFlow] and [Flow] streams that notify observers immediately
 * when theme changes occur, guaranteeing real-time UI updates.
 */
class ThemeManager(context: Context) {

    private val prefs: SharedPreferences =
        context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _themeMode = MutableStateFlow(loadThemeMode())
    /** Observable [StateFlow] of the current [ThemeMode] (LIGHT, DARK, SYSTEM). */
    val themeMode: StateFlow<ThemeMode> = _themeMode.asStateFlow()

    private val _isDarkMode = MutableStateFlow(loadIsDarkMode())
    /** Observable [StateFlow] indicating whether dark mode is currently active. */
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    /** Observable [Flow] of dark mode state for reactive streams. */
    val isDarkModeFlow: Flow<Boolean> = _isDarkMode.asStateFlow()

    /** Immediate synchronous snapshot of current dark mode status. */
    val currentIsDarkMode: Boolean
        get() = _isDarkMode.value

    /** Immediate synchronous snapshot of current selected [ThemeMode]. */
    val currentThemeMode: ThemeMode
        get() = _themeMode.value

    init {
        // Ensure consistency between initial themeMode and isDarkMode
        syncDarkModeWithMode(_themeMode.value, isSystemInDark = false)
    }

    /**
     * Switch directly between light and dark modes.
     */
    fun toggleTheme() {
        setDarkMode(!_isDarkMode.value)
    }

    /**
     * Set explicit dark mode status (true for dark, false for light).
     */
    fun setDarkMode(isDark: Boolean) {
        _isDarkMode.value = isDark
        val newMode = if (isDark) ThemeMode.DARK else ThemeMode.LIGHT
        _themeMode.value = newMode
        prefs.edit()
            .putBoolean(KEY_DARK_MODE, isDark)
            .putString(KEY_THEME_MODE, newMode.name)
            .apply()
    }

    /**
     * Set the theme mode to LIGHT, DARK, or SYSTEM.
     * @param mode Selected [ThemeMode]
     * @param isSystemInDark Current device system dark theme status (used if mode is SYSTEM)
     */
    fun setThemeMode(mode: ThemeMode, isSystemInDark: Boolean = false) {
        _themeMode.value = mode
        syncDarkModeWithMode(mode, isSystemInDark)
        prefs.edit()
            .putString(KEY_THEME_MODE, mode.name)
            .putBoolean(KEY_DARK_MODE, _isDarkMode.value)
            .apply()
    }

    /**
     * Called when the system dark mode changes to update state if in SYSTEM mode.
     */
    fun updateSystemDark(isSystemInDark: Boolean) {
        if (_themeMode.value == ThemeMode.SYSTEM) {
            _isDarkMode.value = isSystemInDark
        }
    }

    private fun syncDarkModeWithMode(mode: ThemeMode, isSystemInDark: Boolean) {
        _isDarkMode.value = when (mode) {
            ThemeMode.LIGHT -> false
            ThemeMode.DARK -> true
            ThemeMode.SYSTEM -> isSystemInDark
        }
    }

    private fun loadThemeMode(): ThemeMode {
        val saved = prefs.getString(KEY_THEME_MODE, null)
        return if (saved != null) {
            try {
                ThemeMode.valueOf(saved)
            } catch (e: Exception) {
                ThemeMode.LIGHT
            }
        } else {
            if (prefs.getBoolean(KEY_DARK_MODE, false)) ThemeMode.DARK else ThemeMode.LIGHT
        }
    }

    private fun loadIsDarkMode(): Boolean {
        val savedMode = prefs.getString(KEY_THEME_MODE, null)
        return if (savedMode != null) {
            when (savedMode) {
                ThemeMode.DARK.name -> true
                ThemeMode.LIGHT.name -> false
                else -> prefs.getBoolean(KEY_DARK_MODE, false)
            }
        } else {
            prefs.getBoolean(KEY_DARK_MODE, false)
        }
    }

    companion object {
        private const val PREFS_NAME = "school_quiz_theme_preferences"
        private const val KEY_THEME_MODE = "key_theme_mode"
        private const val KEY_DARK_MODE = "key_dark_mode"

        @Volatile
        private var instance: ThemeManager? = null

        /**
         * Singleton accessor for global theme manager.
         */
        fun getInstance(context: Context): ThemeManager {
            return instance ?: synchronized(this) {
                instance ?: ThemeManager(context.applicationContext).also { instance = it }
            }
        }
    }
}
