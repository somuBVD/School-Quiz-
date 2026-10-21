package com.example

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.example.audio.SoundEffectsManager
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class SoundEffectsManagerTest {

    private lateinit var application: Application

    @Before
    fun setup() {
        application = ApplicationProvider.getApplicationContext()
        // Reset to default enabled
        SoundEffectsManager.setSoundEnabled(application, true)
        SoundEffectsManager.setVibrationEnabled(application, true)
    }

    @Test
    fun testSoundEffectsSettingsToggle() {
        assertTrue("Sound should be enabled by default", SoundEffectsManager.isSoundEnabled(application))

        val toggled = SoundEffectsManager.toggleSoundEnabled(application)
        assertFalse("Toggled sound should now be false", toggled)
        assertFalse("isSoundEnabled should report false", SoundEffectsManager.isSoundEnabled(application))

        SoundEffectsManager.setSoundEnabled(application, true)
        assertTrue("Explicitly enabled sound should be true", SoundEffectsManager.isSoundEnabled(application))
    }

    @Test
    fun testVibrationSettingsToggle() {
        assertTrue("Vibration should be enabled by default", SoundEffectsManager.isVibrationEnabled(application))

        val toggled = SoundEffectsManager.toggleVibrationEnabled(application)
        assertFalse("Toggled vibration should now be false", toggled)
        assertFalse("isVibrationEnabled should report false", SoundEffectsManager.isVibrationEnabled(application))

        SoundEffectsManager.setVibrationEnabled(application, true)
        assertTrue("Explicitly enabled vibration should be true", SoundEffectsManager.isVibrationEnabled(application))
    }

    @Test
    fun testPlayCorrectDoesNotThrow() {
        try {
            SoundEffectsManager.playCorrect(application)
        } catch (e: Exception) {
            fail("playCorrect should not throw exception: ${e.message}")
        }
    }

    @Test
    fun testPlayIncorrectDoesNotThrow() {
        try {
            SoundEffectsManager.playIncorrect(application)
        } catch (e: Exception) {
            fail("playIncorrect should not throw exception: ${e.message}")
        }
    }

    @Test
    fun testPlayComboStreakDoesNotThrow() {
        try {
            SoundEffectsManager.playComboStreak(application, combo = 3)
            SoundEffectsManager.playComboStreak(application, combo = 5)
            SoundEffectsManager.playComboStreak(application, combo = 7)
        } catch (e: Exception) {
            fail("playComboStreak should not throw exception: ${e.message}")
        }
    }

    @Test
    fun testPlayTimerTickDoesNotThrow() {
        try {
            SoundEffectsManager.playTimerTick(application)
        } catch (e: Exception) {
            fail("playTimerTick should not throw exception: ${e.message}")
        }
    }

    @Test
    fun testPlayQuizCompletionAndStreakBonusDoesNotThrow() {
        try {
            SoundEffectsManager.playQuizCompletion(application, isPerfect = true, isHighScore = true)
            SoundEffectsManager.playQuizCompletion(application, isPerfect = false, isHighScore = false)
            SoundEffectsManager.playStreakBonus(application)
            SoundEffectsManager.playClick(application)
        } catch (e: Exception) {
            fail("Completion sounds should not throw exception: ${e.message}")
        }
    }

    @Test
    fun testAudioMethodsGracefullyHandleDisabledSound() {
        SoundEffectsManager.setSoundEnabled(application, false)
        SoundEffectsManager.setVibrationEnabled(application, false)

        try {
            SoundEffectsManager.playCorrect(application)
            SoundEffectsManager.playIncorrect(application)
            SoundEffectsManager.playComboStreak(application, 4)
            SoundEffectsManager.playTimerTick(application)
            SoundEffectsManager.playQuizCompletion(application)
            SoundEffectsManager.playStreakBonus(application)
            SoundEffectsManager.playClick(application)
        } catch (e: Exception) {
            fail("Audio methods should run silently without error when disabled: ${e.message}")
        }
    }
}
