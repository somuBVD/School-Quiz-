package com.example.localization

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

/**
 * Supported application languages.
 */
enum class AppLanguage(
    val code: String,
    val displayName: String,
    val nativeName: String,
    val flagEmoji: String
) {
    ENGLISH("en", "English", "English", "🇬🇧"),
    KANNADA("kn", "Kannada", "ಕನ್ನಡ", "🇮🇳"),
    HINDI("hi", "Hindi", "हिन्दी", "🇮🇳");

    companion object {
        fun from(value: String?): AppLanguage {
            if (value.isNullOrBlank()) return ENGLISH
            val trimmed = value.trim()
            return entries.find {
                it.name.equals(trimmed, ignoreCase = true) ||
                it.code.equals(trimmed, ignoreCase = true) ||
                it.displayName.equals(trimmed, ignoreCase = true) ||
                it.nativeName.equals(trimmed, ignoreCase = true)
            } ?: ENGLISH
        }
    }
}

/**
 * Utility to synchronize system and Android resources configuration with chosen language.
 */
object LocaleManager {

    fun applyLocale(context: Context, language: AppLanguage): Context {
        val locale = Locale.forLanguageTag(language.code)
        Locale.setDefault(locale)

        val resources = context.resources
        val configuration = Configuration(resources.configuration)
        configuration.setLocale(locale)
        return context.createConfigurationContext(configuration)
    }

    fun updateConfiguration(context: Context, language: AppLanguage) {
        val locale = Locale.forLanguageTag(language.code)
        Locale.setDefault(locale)

        val resources = context.resources
        val configuration = resources.configuration
        configuration.setLocale(locale)
        @Suppress("DEPRECATION")
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}
