package com.example.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.media.ToneGenerator
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.sin

/**
 * SoundEffectsManager provides immersive audio and haptic feedback across the quiz module:
 * 1. Correct answers (cheerful bright harmonic chime: E5 + B5 overtone)
 * 2. Incorrect answers (gentle low descending tone: F3 + D3 chord)
 * 3. Combo streak flourishes (pitch rises with consecutive correct answers)
 * 4. Timer countdown warning tick (when under 5 seconds remain)
 * 5. Quiz completion fanfare (triumphant victory arpeggio: C5 - E5 - G5 - C6)
 * 6. Daily streak & milestone reward claim (sparkling multi-tone fanfare)
 * 7. Micro-interactions (subtle UI click)
 *
 * Employs synthetic AudioTrack waveforms with automatic zero-latency ToneGenerator fallback.
 * Strictly respects student preference settings ('pref_sound_effects' and 'pref_vibration').
 */
object SoundEffectsManager {

    private const val TAG = "SoundEffectsManager"
    private const val PREFS_NAME = "app_general_settings"
    private const val KEY_SOUND_EFFECTS = "pref_sound_effects"
    private const val KEY_VIBRATION = "pref_vibration"

    private val audioScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private var fallbackToneGenerator: ToneGenerator? = null

    init {
        try {
            fallbackToneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 85)
        } catch (e: Exception) {
            Log.w(TAG, "ToneGenerator init note: ${e.message}")
        }
    }

    fun isSoundEnabled(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_SOUND_EFFECTS, true)
    }

    fun setSoundEnabled(context: Context, enabled: Boolean) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(KEY_SOUND_EFFECTS, enabled).apply()
    }

    fun toggleSoundEnabled(context: Context): Boolean {
        val newState = !isSoundEnabled(context)
        setSoundEnabled(context, newState)
        return newState
    }

    fun isVibrationEnabled(context: Context): Boolean {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_VIBRATION, true)
    }

    fun setVibrationEnabled(context: Context, enabled: Boolean) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(KEY_VIBRATION, enabled).apply()
    }

    fun toggleVibrationEnabled(context: Context): Boolean {
        val newState = !isVibrationEnabled(context)
        setVibrationEnabled(context, newState)
        return newState
    }

    /**
     * Plays cheerful affirmative chime for a correct answer.
     * Ascending dual-tone harmony (E5 659.25Hz + B5 987.77Hz) with exponential decay.
     */
    fun playCorrect(context: Context) {
        if (isVibrationEnabled(context)) {
            vibrate(context, 40)
        }
        if (!isSoundEnabled(context)) return

        audioScope.launch {
            try {
                val sampleRate = 22050
                val durationMs = 180
                val numSamples = (sampleRate * durationMs / 1000)
                val buffer = ShortArray(numSamples)

                for (i in 0 until numSamples) {
                    val t = i.toDouble() / sampleRate
                    val decay = exp(-i.toDouble() / (numSamples * 0.35))
                    val sample = (sin(2 * PI * 659.25 * t) * 0.6 + sin(2 * PI * 987.77 * t) * 0.4) * decay
                    buffer[i] = (sample * Short.MAX_VALUE * 0.85).toInt().toShort()
                }

                playBuffer(buffer, sampleRate)
            } catch (e: Exception) {
                // Fallback to ToneGenerator
                try {
                    fallbackToneGenerator?.startTone(ToneGenerator.TONE_PROP_ACK, 180)
                } catch (ignored: Exception) {}
            }
        }
    }

    /**
     * Plays gentle low audio feedback for an incorrect answer.
     * Soft dissonant interval (F3 174.6Hz + D3 146.8Hz) to clearly signal mistakes without harshness.
     */
    fun playIncorrect(context: Context) {
        if (isVibrationEnabled(context)) {
            vibrate(context, 90)
        }
        if (!isSoundEnabled(context)) return

        audioScope.launch {
            try {
                val sampleRate = 22050
                val durationMs = 240
                val numSamples = (sampleRate * durationMs / 1000)
                val buffer = ShortArray(numSamples)

                for (i in 0 until numSamples) {
                    val t = i.toDouble() / sampleRate
                    val decay = exp(-i.toDouble() / (numSamples * 0.45))
                    val sample = (sin(2 * PI * 174.61 * t) * 0.55 + sin(2 * PI * 146.83 * t) * 0.45) * decay
                    buffer[i] = (sample * Short.MAX_VALUE * 0.65).toInt().toShort()
                }

                playBuffer(buffer, sampleRate)
            } catch (e: Exception) {
                try {
                    fallbackToneGenerator?.startTone(ToneGenerator.TONE_PROP_NACK, 250)
                } catch (ignored: Exception) {}
            }
        }
    }

    /**
     * Plays energetic rising chime when consecutive correct streaks hit 3x, 5x, 7x combos.
     */
    fun playComboStreak(context: Context, combo: Int) {
        if (isVibrationEnabled(context)) {
            vibrate(context, 55)
        }
        if (!isSoundEnabled(context)) return

        audioScope.launch {
            try {
                val baseFreq = 784.0 + (combo.coerceIn(1, 10) * 80.0)
                val frequencies = doubleArrayOf(baseFreq, baseFreq * 1.25, baseFreq * 1.5)
                val sampleRate = 22050
                val noteDurationMs = 70
                val numSamplesPerNote = (sampleRate * noteDurationMs / 1000)
                val totalSamples = numSamplesPerNote * frequencies.size
                val buffer = ShortArray(totalSamples)

                frequencies.forEachIndexed { noteIndex, freq ->
                    val offset = noteIndex * numSamplesPerNote
                    for (i in 0 until numSamplesPerNote) {
                        val t = i.toDouble() / sampleRate
                        val decay = exp(-i.toDouble() / (numSamplesPerNote * 0.4))
                        val sample = sin(2 * PI * freq * t) * decay
                        buffer[offset + i] = (sample * Short.MAX_VALUE * 0.85).toInt().toShort()
                    }
                }
                playBuffer(buffer, sampleRate)
            } catch (e: Exception) {
                try {
                    fallbackToneGenerator?.startTone(ToneGenerator.TONE_PROP_BEEP2, 120)
                } catch (ignored: Exception) {}
            }
        }
    }

    /**
     * Plays subtle countdown audio tick when under 5 seconds remain on the timer.
     */
    fun playTimerTick(context: Context) {
        if (!isSoundEnabled(context)) return
        audioScope.launch {
            try {
                val sampleRate = 22050
                val durationMs = 30
                val numSamples = (sampleRate * durationMs / 1000)
                val buffer = ShortArray(numSamples)
                for (i in 0 until numSamples) {
                    val t = i.toDouble() / sampleRate
                    val decay = exp(-i.toDouble() / (numSamples * 0.25))
                    val sample = sin(2 * PI * 1174.66 * t) * decay // D6 high woodblock tick
                    buffer[i] = (sample * Short.MAX_VALUE * 0.4).toInt().toShort()
                }
                playBuffer(buffer, sampleRate)
            } catch (e: Exception) {
                try {
                    fallbackToneGenerator?.startTone(ToneGenerator.TONE_PROP_BEEP, 20)
                } catch (ignored: Exception) {}
            }
        }
    }

    /**
     * Plays celebratory fanfare arpeggio upon quiz completion.
     */
    fun playQuizCompletion(context: Context, isPerfect: Boolean = false, isHighScore: Boolean = false) {
        if (isVibrationEnabled(context)) {
            vibrate(context, 120)
        }
        if (!isSoundEnabled(context)) return

        audioScope.launch {
            try {
                val frequencies = if (isPerfect) {
                    doubleArrayOf(523.25, 659.25, 783.99, 1046.50, 1318.51) // C - E - G - C - E
                } else if (isHighScore) {
                    doubleArrayOf(523.25, 659.25, 783.99, 1046.50)         // C - E - G - C
                } else {
                    doubleArrayOf(523.25, 659.25, 783.99)                  // C - E - G
                }

                val sampleRate = 22050
                val noteDurationMs = 120
                val numSamplesPerNote = (sampleRate * noteDurationMs / 1000)
                val totalSamples = numSamplesPerNote * frequencies.size
                val buffer = ShortArray(totalSamples)

                frequencies.forEachIndexed { noteIndex, freq ->
                    val offset = noteIndex * numSamplesPerNote
                    for (i in 0 until numSamplesPerNote) {
                        val t = i.toDouble() / sampleRate
                        val decay = exp(-i.toDouble() / (numSamplesPerNote * 0.5))
                        val sample = (sin(2 * PI * freq * t) * 0.8 + sin(2 * PI * (freq * 2) * t) * 0.2) * decay
                        buffer[offset + i] = (sample * Short.MAX_VALUE * 0.8).toInt().toShort()
                    }
                }

                playBuffer(buffer, sampleRate)
            } catch (e: Exception) {
                try {
                    fallbackToneGenerator?.startTone(ToneGenerator.TONE_CDMA_ALERT_NETWORK_LITE, 400)
                } catch (ignored: Exception) {}
            }
        }
    }

    /**
     * Plays sparkling celebration sound for daily streak bonus & reward claim.
     */
    fun playStreakBonus(context: Context) {
        if (isVibrationEnabled(context)) {
            vibrate(context, 75)
        }
        if (!isSoundEnabled(context)) return

        audioScope.launch {
            try {
                val frequencies = doubleArrayOf(783.99, 1046.50, 1318.51, 1567.98)
                val sampleRate = 22050
                val noteDurationMs = 85
                val numSamplesPerNote = (sampleRate * noteDurationMs / 1000)
                val totalSamples = numSamplesPerNote * frequencies.size
                val buffer = ShortArray(totalSamples)

                frequencies.forEachIndexed { noteIndex, freq ->
                    val offset = noteIndex * numSamplesPerNote
                    for (i in 0 until numSamplesPerNote) {
                        val t = i.toDouble() / sampleRate
                        val decay = exp(-i.toDouble() / (numSamplesPerNote * 0.45))
                        val sample = (sin(2 * PI * freq * t) * 0.75 + sin(2 * PI * (freq * 1.5) * t) * 0.25) * decay
                        buffer[offset + i] = (sample * Short.MAX_VALUE * 0.8).toInt().toShort()
                    }
                }

                playBuffer(buffer, sampleRate)
            } catch (e: Exception) {
                try {
                    fallbackToneGenerator?.startTone(ToneGenerator.TONE_PROP_ACK, 200)
                } catch (ignored: Exception) {}
            }
        }
    }

    /**
     * Subtle UI click feedback.
     */
    fun playClick(context: Context) {
        if (!isSoundEnabled(context)) return
        audioScope.launch {
            try {
                fallbackToneGenerator?.startTone(ToneGenerator.TONE_PROP_BEEP, 35)
            } catch (ignored: Exception) {}
        }
    }

    private fun playBuffer(buffer: ShortArray, sampleRate: Int) {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        val audioFormat = AudioFormat.Builder()
            .setSampleRate(sampleRate)
            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
            .build()

        val track = AudioTrack(
            audioAttributes,
            audioFormat,
            buffer.size * 2,
            AudioTrack.MODE_STATIC,
            AudioManager.AUDIO_SESSION_ID_GENERATE
        )

        if (track.state != AudioTrack.STATE_INITIALIZED) {
            try {
                track.release()
            } catch (ignored: Exception) {}
            throw IllegalStateException("AudioTrack failed to initialize")
        }

        track.write(buffer, 0, buffer.size)
        track.play()
        track.setNotificationMarkerPosition(buffer.size)
        track.setPlaybackPositionUpdateListener(object : AudioTrack.OnPlaybackPositionUpdateListener {
            override fun onMarkerReached(t: AudioTrack?) {
                try {
                    t?.release()
                } catch (ignored: Exception) {}
            }

            override fun onPeriodicNotification(t: AudioTrack?) {}
        })
    }

    private fun vibrate(context: Context, durationMs: Long) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
                vibratorManager?.defaultVibrator?.vibrate(
                    VibrationEffect.createOneShot(durationMs, VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                @Suppress("DEPRECATION")
                val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator?.vibrate(VibrationEffect.createOneShot(durationMs, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator?.vibrate(durationMs)
                }
            }
        } catch (ignored: Exception) {}
    }
}
