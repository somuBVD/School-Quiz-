package com.example.audio

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.sin
import kotlin.random.Random

/**
 * Soundscape types available for background study and exam focus.
 */
enum class SoundscapeType(
    val title: String,
    val emoji: String,
    val description: String,
    val subtitle: String
) {
    RAIN(
        title = "Gentle Rain",
        emoji = "🌧️",
        description = "Calming raindrops on glass to soothe thoughts",
        subtitle = "Soothing & Peaceful"
    ),
    BROWN_NOISE(
        title = "Study Brown Noise",
        emoji = "☕",
        description = "Deep warm acoustic spectrum for absolute speech masking",
        subtitle = "Deep Masking & Focus"
    ),
    OCEAN_WAVES(
        title = "Ocean Waves",
        emoji = "🌊",
        description = "Rhythmic natural ocean swells for calm breathing",
        subtitle = "Rhythmic & Relaxing"
    ),
    FOREST_BREEZE(
        title = "Forest Breeze",
        emoji = "🌲",
        description = "Soft canopy whispers and ambient nature resonance",
        subtitle = "Fresh & Expansive"
    ),
    ALPHA_BEATS(
        title = "Alpha Waves (432Hz)",
        emoji = "🧘",
        description = "Binaural 10Hz beat for relaxed alertness and memory retention",
        subtitle = "Memory & Concentration"
    )
}

/**
 * StudyAmbienceManager synthesizes soothing continuous acoustic soundscapes
 * directly on-device using Android's native AudioTrack with PCM buffer generation.
 *
 * Benefits:
 * - 100% offline, requires zero external audio/mp3 assets.
 * - Zero network bandwidth, lightweight, instant startup.
 * - Dynamic volume control and seamless switching between presets.
 */
object StudyAmbienceManager {

    private const val TAG = "StudyAmbienceManager"
    private const val SAMPLE_RATE = 22050
    private const val BUFFER_SIZE = 4096

    private val ambienceScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    private var playbackJob: Job? = null
    private var activeAudioTrack: AudioTrack? = null

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _activeSoundscape = MutableStateFlow(SoundscapeType.RAIN)
    val activeSoundscape: StateFlow<SoundscapeType> = _activeSoundscape.asStateFlow()

    private val _volume = MutableStateFlow(0.7f)
    val volume: StateFlow<Float> = _volume.asStateFlow()

    /**
     * Start or switch to a specific soundscape.
     */
    fun startSoundscape(type: SoundscapeType, initialVolume: Float? = null) {
        if (initialVolume != null) {
            _volume.value = initialVolume.coerceIn(0f, 1f)
        }
        _activeSoundscape.value = type

        stopCurrentPlayback()

        playbackJob = ambienceScope.launch {
            try {
                val minBufferSize = AudioTrack.getMinBufferSize(
                    SAMPLE_RATE,
                    AudioFormat.CHANNEL_OUT_MONO,
                    AudioFormat.ENCODING_PCM_16BIT
                ).coerceAtLeast(BUFFER_SIZE)

                val audioTrack = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_MEDIA)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(SAMPLE_RATE)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(minBufferSize)
                    .setTransferMode(AudioTrack.MODE_STREAM)
                    .build()

                activeAudioTrack = audioTrack
                audioTrack.setVolume(_volume.value)
                audioTrack.play()
                _isPlaying.value = true

                val buffer = ShortArray(BUFFER_SIZE)
                var phase1 = 0.0
                var phase2 = 0.0
                var lastBrownVal = 0.0
                var wavePhase = 0.0

                while (isActive) {
                    val currentType = _activeSoundscape.value
                    val currentVol = _volume.value
                    audioTrack.setVolume(currentVol)

                    when (currentType) {
                        SoundscapeType.RAIN -> {
                            // Pink/brown filtered noise with random droplet spikes
                            for (i in buffer.indices) {
                                val white = Random.nextDouble(-1.0, 1.0)
                                lastBrownVal = (lastBrownVal + (0.04 * white)) / 1.04
                                var sample = lastBrownVal * 0.7

                                // Occasional soft raindrop transient
                                if (Random.nextInt(800) == 0) {
                                    sample += Random.nextDouble(0.3, 0.7)
                                }
                                val scaled = (sample * 16000).toInt().coerceIn(-32768, 32767)
                                buffer[i] = scaled.toShort()
                            }
                        }

                        SoundscapeType.BROWN_NOISE -> {
                            // True 1/f^2 Brown Noise generator: integrated white noise
                            for (i in buffer.indices) {
                                val white = Random.nextDouble(-1.0, 1.0)
                                lastBrownVal = (lastBrownVal + (0.025 * white)) / 1.025
                                val scaled = (lastBrownVal * 20000).toInt().coerceIn(-32768, 32767)
                                buffer[i] = scaled.toShort()
                            }
                        }

                        SoundscapeType.OCEAN_WAVES -> {
                            // Rhythmic swell: Low rumble modulated by slow sine wave (period ~6s)
                            val swellFreq = 2.0 * PI / (SAMPLE_RATE * 6.5)
                            for (i in buffer.indices) {
                                wavePhase += swellFreq
                                if (wavePhase > 2.0 * PI) wavePhase -= 2.0 * PI
                                val swell = (sin(wavePhase) + 1.2) * 0.45

                                val white = Random.nextDouble(-1.0, 1.0)
                                lastBrownVal = (lastBrownVal + (0.03 * white)) / 1.03
                                val sample = lastBrownVal * swell
                                val scaled = (sample * 22000).toInt().coerceIn(-32768, 32767)
                                buffer[i] = scaled.toShort()
                            }
                        }

                        SoundscapeType.FOREST_BREEZE -> {
                            // Soft oscillating breath with high-frequency flutter
                            val breezeFreq = 2.0 * PI / (SAMPLE_RATE * 8.0)
                            for (i in buffer.indices) {
                                wavePhase += breezeFreq
                                if (wavePhase > 2.0 * PI) wavePhase -= 2.0 * PI
                                val breeze = (sin(wavePhase) + 1.0) * 0.4 + 0.2

                                val white = Random.nextDouble(-0.7, 0.7)
                                lastBrownVal = (lastBrownVal + (0.05 * white)) / 1.05
                                val sample = lastBrownVal * breeze
                                val scaled = (sample * 14000).toInt().coerceIn(-32768, 32767)
                                buffer[i] = scaled.toShort()
                            }
                        }

                        SoundscapeType.ALPHA_BEATS -> {
                            // 432 Hz carrier + 442 Hz harmonic => 10 Hz binaural alpha beat
                            val freq1 = 432.0
                            val freq2 = 442.0
                            val step1 = 2.0 * PI * freq1 / SAMPLE_RATE
                            val step2 = 2.0 * PI * freq2 / SAMPLE_RATE

                            for (i in buffer.indices) {
                                phase1 += step1
                                phase2 += step2
                                if (phase1 > 2.0 * PI) phase1 -= 2.0 * PI
                                if (phase2 > 2.0 * PI) phase2 -= 2.0 * PI

                                val s1 = sin(phase1) * 0.4
                                val s2 = sin(phase2) * 0.4
                                val combined = s1 + s2
                                val scaled = (combined * 18000).toInt().coerceIn(-32768, 32767)
                                buffer[i] = scaled.toShort()
                            }
                        }
                    }

                    audioTrack.write(buffer, 0, buffer.size)
                }
            } catch (e: Exception) {
                Log.w(TAG, "Study soundscape playback note: ${e.message}")
            } finally {
                stopCurrentPlayback()
            }
        }
    }

    /**
     * Stop the currently playing soundscape.
     */
    fun stopSoundscape() {
        _isPlaying.value = false
        stopCurrentPlayback()
    }

    /**
     * Toggle play/pause for the active soundscape.
     */
    fun toggleSoundscape() {
        if (_isPlaying.value) {
            stopSoundscape()
        } else {
            startSoundscape(_activeSoundscape.value)
        }
    }

    /**
     * Set playback volume level (0.0f to 1.0f).
     */
    fun setVolume(vol: Float) {
        val clamped = vol.coerceIn(0f, 1f)
        _volume.value = clamped
        try {
            activeAudioTrack?.setVolume(clamped)
        } catch (ignored: Exception) {}
    }

    private fun stopCurrentPlayback() {
        playbackJob?.cancel()
        playbackJob = null
        try {
            activeAudioTrack?.let {
                if (it.state == AudioTrack.STATE_INITIALIZED) {
                    it.stop()
                    it.release()
                }
            }
        } catch (ignored: Exception) {}
        activeAudioTrack = null
        _isPlaying.value = false
    }
}
