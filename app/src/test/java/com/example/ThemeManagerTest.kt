package com.example

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ThemeManagerTest {

    private lateinit var application: Application
    private lateinit var themeManager: ThemeManager
    private lateinit var settingsViewModel: SettingsViewModel

    @Before
    fun setup() {
        application = ApplicationProvider.getApplicationContext()
        // Clear shared preferences for clean test state
        application.getSharedPreferences("school_quiz_theme_preferences", Application.MODE_PRIVATE)
            .edit()
            .clear()
            .commit()

        themeManager = ThemeManager(application)
        settingsViewModel = SettingsViewModel(application, themeManager)
    }

    @Test
    fun testInitialThemeIsLight() = runBlocking {
        assertEquals(ThemeMode.LIGHT, themeManager.themeMode.first())
        assertFalse(themeManager.isDarkMode.first())
        assertFalse(settingsViewModel.isDarkMode.first())
    }

    @Test
    fun testToggleThemeUpdatesState() = runBlocking {
        themeManager.toggleTheme()
        assertTrue(themeManager.isDarkMode.first())
        assertEquals(ThemeMode.DARK, themeManager.themeMode.first())
        assertTrue(settingsViewModel.isDarkMode.first())

        themeManager.toggleTheme()
        assertFalse(themeManager.isDarkMode.first())
        assertEquals(ThemeMode.LIGHT, themeManager.themeMode.first())
        assertFalse(settingsViewModel.isDarkMode.first())
    }

    @Test
    fun testSettingsViewModelTogglesThemeGlobally() = runBlocking {
        settingsViewModel.toggleDarkMode()
        assertTrue(settingsViewModel.isDarkMode.first())
        assertTrue(themeManager.isDarkMode.first())
        assertEquals(ThemeMode.DARK, settingsViewModel.themeMode.first())

        settingsViewModel.setDarkMode(false)
        assertFalse(settingsViewModel.isDarkMode.first())
        assertFalse(themeManager.isDarkMode.first())
        assertEquals(ThemeMode.LIGHT, settingsViewModel.themeMode.first())
    }

    @Test
    fun testSetThemeModeSystem() = runBlocking {
        settingsViewModel.setThemeMode(ThemeMode.SYSTEM, isSystemInDark = true)
        assertEquals(ThemeMode.SYSTEM, settingsViewModel.themeMode.first())
        assertTrue(settingsViewModel.isDarkMode.first())

        settingsViewModel.updateSystemDark(false)
        assertFalse(settingsViewModel.isDarkMode.first())
    }

    @Test
    fun testThemePersistenceAcrossInstances() = runBlocking {
        themeManager.setDarkMode(true)
        assertTrue(themeManager.isDarkMode.first())

        // Create new instance mimicking app relaunch
        val newManager = ThemeManager(application)
        assertTrue(newManager.isDarkMode.first())
        assertEquals(ThemeMode.DARK, newManager.themeMode.first())
    }

    @Test
    fun testSwitchTriggerUpdatesAppThemeInstantly() = runBlocking {
        // Simulating Switch onCheckedChange callback with false -> true
        settingsViewModel.setDarkMode(true)
        assertTrue("Switch state immediately reflects dark mode", settingsViewModel.isDarkMode.first())
        assertEquals("Theme mode reflects dark mode", ThemeMode.DARK, settingsViewModel.themeMode.first())

        // Simulating Switch onCheckedChange callback with true -> false
        settingsViewModel.setDarkMode(false)
        assertFalse("Switch state immediately reflects light mode", settingsViewModel.isDarkMode.first())
        assertEquals("Theme mode reflects light mode", ThemeMode.LIGHT, settingsViewModel.themeMode.first())
    }

    @Test
    fun testFlowAndSnapshotAccessors() = runBlocking {
        themeManager.setDarkMode(true)
        assertTrue("isDarkModeFlow emits true", themeManager.isDarkModeFlow.first())
        assertTrue("currentIsDarkMode snapshot is true", themeManager.currentIsDarkMode)
        assertEquals("currentThemeMode snapshot is DARK", ThemeMode.DARK, themeManager.currentThemeMode)

        themeManager.setDarkMode(false)
        assertFalse("isDarkModeFlow emits false", themeManager.isDarkModeFlow.first())
        assertFalse("currentIsDarkMode snapshot is false", themeManager.currentIsDarkMode)
        assertEquals("currentThemeMode snapshot is LIGHT", ThemeMode.LIGHT, themeManager.currentThemeMode)
    }
}
