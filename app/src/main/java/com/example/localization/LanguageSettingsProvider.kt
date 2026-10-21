package com.example.localization

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Custom Language Settings Provider interface for managing and toggling the entire
 * application's UI and content between English, Hindi, and Kannada.
 */
interface LanguageSettingsProvider {
    /**
     * Observable state flow representing the currently active [AppLanguage].
     */
    val currentLanguage: StateFlow<AppLanguage>

    /**
     * Canonical 2-letter ISO code for the current language ("en", "hi", "kn").
     */
    val currentLanguageCode: String
        get() = currentLanguage.value.code

    /**
     * Display name of the active language (e.g. "English", "Hindi", "Kannada").
     */
    val currentLanguageName: String
        get() = currentLanguage.value.displayName

    /**
     * Native localized title of the language ("English", "हिन्दी", "ಕನ್ನಡ").
     */
    val currentNativeName: String
        get() = currentLanguage.value.nativeName

    /**
     * Flag emoji representing the regional script / country.
     */
    val currentFlagEmoji: String
        get() = currentLanguage.value.flagEmoji

    /**
     * Fully resolved localized strings object for the current language.
     */
    val currentStrings: AppStrings
        get() = AppStrings.forLanguage(currentLanguage.value)

    /**
     * Supported languages in order of rotation: English -> Hindi -> Kannada.
     */
    val supportedLanguages: List<AppLanguage>
        get() = listOf(AppLanguage.ENGLISH, AppLanguage.HINDI, AppLanguage.KANNADA)

    /**
     * Explicitly set the application language.
     */
    fun setLanguage(language: AppLanguage)

    /**
     * Explicitly set the language by its code or display name.
     */
    fun setLanguage(languageNameOrCode: String)

    /**
     * Rotates to the next language in the cycle (English -> Hindi -> Kannada -> English)
     * and returns the newly selected [AppLanguage].
     */
    fun toggleNextLanguage(): AppLanguage

    /**
     * Returns the current [AppLanguage].
     */
    fun getLanguage(): AppLanguage = currentLanguage.value

    /**
     * Register an observer callback triggered whenever the language changes.
     */
    fun addOnLanguageChangeListener(listener: (AppLanguage) -> Unit)

    /**
     * Unregister an observer callback.
     */
    fun removeOnLanguageChangeListener(listener: (AppLanguage) -> Unit)
}

/**
 * Default production implementation of [LanguageSettingsProvider].
 * Synchronizes with SharedPreferences, Android runtime configuration via [LocaleManager],
 * and dispatches notifications to registered listeners.
 */
class CustomLanguageSettingsProvider(
    private val context: Context,
    initialLanguage: AppLanguage? = null
) : LanguageSettingsProvider {

    private val userPrefs = context.getSharedPreferences("quiz_app_user_data", Context.MODE_PRIVATE)
    private val appPrefs = context.getSharedPreferences("app_general_settings", Context.MODE_PRIVATE)

    private val initialLang: AppLanguage = initialLanguage ?: run {
        val saved = userPrefs.getString("app_language", null)
            ?: appPrefs.getString("app_language", null)
        AppLanguage.from(saved)
    }

    private val _currentLanguage = MutableStateFlow(initialLang)
    override val currentLanguage: StateFlow<AppLanguage> = _currentLanguage.asStateFlow()

    private val listeners = CopyOnWriteArrayList<(AppLanguage) -> Unit>()

    init {
        // Apply initial locale configuration to application context
        try {
            LocaleManager.updateConfiguration(context, initialLang)
        } catch (ignored: Exception) {}
    }

    override fun setLanguage(language: AppLanguage) {
        if (_currentLanguage.value == language) {
            // Still ensure preferences and locales are synced
            persistLanguage(language)
            return
        }

        _currentLanguage.value = language
        persistLanguage(language)
        notifyListeners(language)
    }

    override fun setLanguage(languageNameOrCode: String) {
        val resolved = AppLanguage.from(languageNameOrCode)
        setLanguage(resolved)
    }

    override fun toggleNextLanguage(): AppLanguage {
        val current = _currentLanguage.value
        val list = supportedLanguages
        val currentIndex = list.indexOf(current)
        val nextIndex = if (currentIndex == -1 || currentIndex >= list.size - 1) 0 else currentIndex + 1
        val nextLanguage = list[nextIndex]

        setLanguage(nextLanguage)
        return nextLanguage
    }

    override fun addOnLanguageChangeListener(listener: (AppLanguage) -> Unit) {
        listeners.addIfAbsent(listener)
    }

    override fun removeOnLanguageChangeListener(listener: (AppLanguage) -> Unit) {
        listeners.remove(listener)
    }

    private fun persistLanguage(language: AppLanguage) {
        val name = language.displayName
        userPrefs.edit().putString("app_language", name).apply()
        appPrefs.edit().putString("app_language", name).apply()

        try {
            LocaleManager.updateConfiguration(context, language)
        } catch (ignored: Exception) {}
    }

    private fun notifyListeners(language: AppLanguage) {
        listeners.forEach { listener ->
            try {
                listener(language)
            } catch (ignored: Exception) {}
        }
    }

    companion object {
        @Volatile
        private var instance: CustomLanguageSettingsProvider? = null

        fun getInstance(context: Context): CustomLanguageSettingsProvider {
            return instance ?: synchronized(this) {
                instance ?: CustomLanguageSettingsProvider(context.applicationContext).also {
                    instance = it
                }
            }
        }
    }
}

/**
 * CompositionLocal provider for the custom [LanguageSettingsProvider].
 */
val LocalLanguageSettingsProvider: ProvidableCompositionLocal<LanguageSettingsProvider> =
    staticCompositionLocalOf {
        object : LanguageSettingsProvider {
            private val _lang = MutableStateFlow(AppLanguage.ENGLISH)
            override val currentLanguage: StateFlow<AppLanguage> = _lang.asStateFlow()
            override fun setLanguage(language: AppLanguage) { _lang.value = language }
            override fun setLanguage(languageNameOrCode: String) { _lang.value = AppLanguage.from(languageNameOrCode) }
            override fun toggleNextLanguage(): AppLanguage {
                val next = when (_lang.value) {
                    AppLanguage.ENGLISH -> AppLanguage.HINDI
                    AppLanguage.HINDI -> AppLanguage.KANNADA
                    AppLanguage.KANNADA -> AppLanguage.ENGLISH
                }
                _lang.value = next
                return next
            }
            override fun addOnLanguageChangeListener(listener: (AppLanguage) -> Unit) {}
            override fun removeOnLanguageChangeListener(listener: (AppLanguage) -> Unit) {}
        }
    }

/**
 * Convenient wrapper composable that supplies the [LanguageSettingsProvider]
 * and resolved [AppStrings] to its child content.
 */
@Composable
fun ProvideLanguageSettings(
    provider: LanguageSettingsProvider,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalLanguageSettingsProvider provides provider,
        LocalAppStrings provides provider.currentStrings,
        content = content
    )
}
