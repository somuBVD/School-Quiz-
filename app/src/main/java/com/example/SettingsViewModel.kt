package com.example

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import com.example.localization.AppLanguage
import com.example.localization.CustomLanguageSettingsProvider
import com.example.localization.LanguageSettingsProvider

/**
 * Settings ViewModel responsible for UI state and interaction for global
 * app settings, primarily global theme mode (light / dark / system) via [ThemeManager]
 * and language management via [LanguageSettingsProvider].
 */
class SettingsViewModel(
    application: Application,
    val themeManager: ThemeManager = ThemeManager.getInstance(application),
    val languageSettingsProvider: LanguageSettingsProvider = CustomLanguageSettingsProvider.getInstance(application)
) : AndroidViewModel(application) {

    // --- Global Theme Flows ---
    val isDarkMode: StateFlow<Boolean> = themeManager.isDarkMode
    val isDarkModeFlow: Flow<Boolean> = themeManager.isDarkModeFlow
    val themeMode: StateFlow<ThemeMode> = themeManager.themeMode

    // --- Secondary App Preferences ---
    private val appPrefs = application.getSharedPreferences("app_general_settings", Context.MODE_PRIVATE)

    private val _soundEffectsEnabled = MutableStateFlow(appPrefs.getBoolean("pref_sound_effects", true))
    val soundEffectsEnabled: StateFlow<Boolean> = _soundEffectsEnabled.asStateFlow()

    private val _vibrationEnabled = MutableStateFlow(appPrefs.getBoolean("pref_vibration", true))
    val vibrationEnabled: StateFlow<Boolean> = _vibrationEnabled.asStateFlow()

    private val userPrefs = application.getSharedPreferences("quiz_app_user_data", Context.MODE_PRIVATE)
    private val _currentLanguage = MutableStateFlow(
        userPrefs.getString("app_language", null) ?: languageSettingsProvider.currentLanguageName
    )
    val currentLanguage: StateFlow<String> = _currentLanguage.asStateFlow()

    init {
        languageSettingsProvider.addOnLanguageChangeListener { newLang ->
            _currentLanguage.value = newLang.displayName
        }
    }

    fun setLanguage(lang: String) {
        val appLang = AppLanguage.from(lang)
        val canonicalName = appLang.displayName
        _currentLanguage.value = canonicalName
        languageSettingsProvider.setLanguage(appLang)
        userPrefs.edit().putString("app_language", canonicalName).apply()
        try {
            com.example.localization.LocaleManager.updateConfiguration(getApplication(), appLang)
        } catch (ignored: Exception) {}
    }

    fun toggleLanguage(): AppLanguage {
        val next = languageSettingsProvider.toggleNextLanguage()
        _currentLanguage.value = next.displayName
        return next
    }

    /**
     * Toggles between bright/light and dark mode across the entire app.
     */
    fun toggleDarkMode() {
        themeManager.toggleTheme()
    }

    /**
     * Explicitly sets light or dark mode globally.
     */
    fun setDarkMode(isDark: Boolean) {
        themeManager.setDarkMode(isDark)
    }

    /**
     * Sets theme mode to LIGHT, DARK, or SYSTEM.
     */
    fun setThemeMode(mode: ThemeMode, isSystemInDark: Boolean = false) {
        themeManager.setThemeMode(mode, isSystemInDark)
    }

    /**
     * Updates dark mode state if mode is set to SYSTEM.
     */
    fun updateSystemDark(isSystemInDark: Boolean) {
        themeManager.updateSystemDark(isSystemInDark)
    }

    /**
     * Toggle sound effects on quiz answer selection.
     */
    fun toggleSoundEffects() {
        val updated = !_soundEffectsEnabled.value
        _soundEffectsEnabled.value = updated
        appPrefs.edit().putBoolean("pref_sound_effects", updated).apply()
    }

    /**
     * Toggle haptic vibration feedback.
     */
    fun toggleVibration() {
        val updated = !_vibrationEnabled.value
        _vibrationEnabled.value = updated
        appPrefs.edit().putBoolean("pref_vibration", updated).apply()
    }

    // --- Visible Classes / Standards Preferences ---
    val defaultVisibleStandards: Set<Int> = setOf(6, 7, 8, 9, 10, 11, 12)

    private val _visibleStandards = MutableStateFlow<Set<Int>>(loadVisibleStandards())
    val visibleStandards: StateFlow<Set<Int>> = _visibleStandards.asStateFlow()

    private fun loadVisibleStandards(): Set<Int> {
        val saved = appPrefs.getStringSet("pref_visible_standards", null)
        return if (saved.isNullOrEmpty()) {
            defaultVisibleStandards
        } else {
            val parsed = saved.mapNotNull { it.toIntOrNull() }.toSet()
            if (parsed.isEmpty()) defaultVisibleStandards else parsed
        }
    }

    fun isStandardVisible(std: Int): Boolean {
        return _visibleStandards.value.contains(std)
    }

    /**
     * Toggles visibility for a specific standard (6..10, 11=Morarji, 12=NMMS).
     * Ensures at least one standard remains enabled.
     * Returns true if toggled successfully, false if prevented because it's the only one left.
     */
    fun toggleStandardVisibility(std: Int): Boolean {
        val current = _visibleStandards.value
        val updated = if (current.contains(std)) {
            if (current.size <= 1) {
                return false // Must keep at least one class visible
            }
            current - std
        } else {
            current + std
        }
        _visibleStandards.value = updated
        appPrefs.edit().putStringSet("pref_visible_standards", updated.map { it.toString() }.toSet()).apply()
        return true
    }

    fun setAllStandardsVisible() {
        _visibleStandards.value = defaultVisibleStandards
        appPrefs.edit().putStringSet("pref_visible_standards", defaultVisibleStandards.map { it.toString() }.toSet()).apply()
    }

    fun setVisibleStandards(standards: Set<Int>) {
        val valid = if (standards.isEmpty()) defaultVisibleStandards else standards
        _visibleStandards.value = valid
        appPrefs.edit().putStringSet("pref_visible_standards", valid.map { it.toString() }.toSet()).apply()
    }
}

/**
 * Factory class for constructing [SettingsViewModel] with optional custom [ThemeManager].
 */
class SettingsViewModelFactory(
    private val application: Application,
    private val themeManager: ThemeManager? = null,
    private val languageSettingsProvider: LanguageSettingsProvider? = null
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            val tm = themeManager ?: ThemeManager.getInstance(application)
            val lsp = languageSettingsProvider ?: CustomLanguageSettingsProvider.getInstance(application)
            return SettingsViewModel(application, tm, lsp) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
