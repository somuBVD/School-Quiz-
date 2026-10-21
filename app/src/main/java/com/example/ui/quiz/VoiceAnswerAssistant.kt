package com.example.ui.quiz

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import java.util.Locale

sealed class VoiceInputStatus {
    object Idle : VoiceInputStatus()
    object Listening : VoiceInputStatus()
    data class Success(val matchResult: VoiceMatchResult) : VoiceInputStatus()
    data class Unmatched(val rawTranscript: String, val message: String) : VoiceInputStatus()
    data class Error(val message: String) : VoiceInputStatus()
}

/**
 * An accessible, animated Voice-to-Text input component for quiz questions.
 * Allows students to speak their answer (e.g., "Option A", "True", or the exact answer text).
 * Automatically selects the matching option and provides rich real-time visual feedback.
 */
@Composable
fun VoiceAnswerAssistant(
    options: List<String>,
    currentQuestionText: String,
    isSubmitted: Boolean,
    onAnswerMatched: (String) -> Unit,
    onSubmitRequested: () -> Unit,
    onClearRequested: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var status by remember(currentQuestionText) { mutableStateOf<VoiceInputStatus>(VoiceInputStatus.Idle) }
    var showManualSpeechDialog by remember { mutableStateOf(false) }
    var autoSubmitOnVoice by remember { mutableStateOf(false) }

    // Pulse animation for active listening
    val infiniteTransition = rememberInfiniteTransition(label = "micPulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.22f,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulseScale"
    )

    fun handleTranscript(transcript: String) {
        if (transcript.isBlank()) {
            status = VoiceInputStatus.Error("No speech detected. Please speak clearly.")
            return
        }

        val result = VoiceAnswerMatcher.matchSpokenTranscript(transcript, options)
        if (result.isCommand) {
            when (result.commandType) {
                VoiceCommandType.SUBMIT -> {
                    status = VoiceInputStatus.Success(result)
                    onSubmitRequested()
                }
                VoiceCommandType.CLEAR -> {
                    status = VoiceInputStatus.Success(result)
                    onClearRequested()
                }
                VoiceCommandType.NEXT -> {
                    status = VoiceInputStatus.Success(result)
                    onSubmitRequested()
                }
                null -> Unit
            }
        } else if (result.matchedAnswer != null) {
            status = VoiceInputStatus.Success(result)
            onAnswerMatched(result.matchedAnswer)
            if (autoSubmitOnVoice) {
                onSubmitRequested()
            }
        } else {
            status = VoiceInputStatus.Unmatched(
                rawTranscript = transcript,
                message = result.feedbackMessage
            )
        }
    }

    // System Recognizer Intent Launcher
    val speechIntentLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        status = VoiceInputStatus.Idle
        if (activityResult.resultCode == Activity.RESULT_OK && activityResult.data != null) {
            val spokenResults = activityResult.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            val primaryTranscript = spokenResults?.firstOrNull() ?: ""
            handleTranscript(primaryTranscript)
        } else if (activityResult.resultCode == Activity.RESULT_CANCELED) {
            status = VoiceInputStatus.Idle
        } else {
            status = VoiceInputStatus.Error("Voice input cancelled or unavailable.")
        }
    }

    // Audio Permission Launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            startSpeechRecognition(
                context = context,
                onStartListening = { status = VoiceInputStatus.Listening },
                launchIntent = { intent -> speechIntentLauncher.launch(intent) },
                onFallbackToManual = { showManualSpeechDialog = true },
                onError = { err -> status = VoiceInputStatus.Error(err) }
            )
        } else {
            status = VoiceInputStatus.Error("Microphone permission is required for voice input.")
            Toast.makeText(context, "Microphone permission is needed to speak answers", Toast.LENGTH_SHORT).show()
        }
    }

    fun initiateVoiceInput() {
        if (isSubmitted) return
        val hasPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED

        if (hasPermission) {
            startSpeechRecognition(
                context = context,
                onStartListening = { status = VoiceInputStatus.Listening },
                launchIntent = { intent -> speechIntentLauncher.launch(intent) },
                onFallbackToManual = { showManualSpeechDialog = true },
                onError = { err -> status = VoiceInputStatus.Error(err) }
            )
        } else {
            permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
        }
    }

    // Sleek, compact Voice Assistant Bar
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("voice_answer_card"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (status) {
                is VoiceInputStatus.Listening -> Color(0xFFEFF6FF)
                is VoiceInputStatus.Success -> Color(0xFFF0FDF4)
                is VoiceInputStatus.Unmatched -> Color(0xFFFFFBEB)
                is VoiceInputStatus.Error -> Color(0xFFFEF2F2)
                is VoiceInputStatus.Idle -> Color(0xFFF8FAFC)
            }
        ),
        border = BorderStroke(
            1.dp,
            when (status) {
                is VoiceInputStatus.Listening -> Color(0xFF3B82F6)
                is VoiceInputStatus.Success -> Color(0xFF22C55E)
                is VoiceInputStatus.Unmatched -> Color(0xFFF59E0B)
                is VoiceInputStatus.Error -> Color(0xFFEF4444)
                is VoiceInputStatus.Idle -> Color(0xFFE2E8F0)
            }
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .clickable(enabled = !isSubmitted) { initiateVoiceInput() }
            ) {
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .scale(if (status is VoiceInputStatus.Listening) pulseScale else 1f)
                        .clip(CircleShape)
                        .background(
                            Brush.linearGradient(
                                if (isSubmitted) listOf(Color(0xFFCBD5E1), Color(0xFF94A3B8))
                                else if (status is VoiceInputStatus.Listening) listOf(Color(0xFF3B82F6), Color(0xFF2563EB))
                                else if (status is VoiceInputStatus.Success) listOf(Color(0xFF10B981), Color(0xFF059669))
                                else listOf(Color(0xFF4F46E5), Color(0xFF6366F1))
                            )
                        )
                        .semantics {
                            contentDescription = if (status is VoiceInputStatus.Listening) {
                                "Listening for voice answer"
                            } else {
                                "Tap to speak your answer"
                            }
                        }
                        .testTag("voice_input_button"),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (status is VoiceInputStatus.Listening) Icons.Default.Hearing else Icons.Default.Mic,
                        contentDescription = "Microphone",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                Column(modifier = Modifier.weight(1f, fill = false)) {
                    val statusText = when (val s = status) {
                        is VoiceInputStatus.Listening -> "Listening... Speak now!"
                        is VoiceInputStatus.Success -> "Selected: ${s.matchResult.matchedAnswer ?: "Done"}"
                        is VoiceInputStatus.Unmatched -> "Heard: \"${s.rawTranscript}\""
                        is VoiceInputStatus.Error -> s.message
                        is VoiceInputStatus.Idle -> if (isSubmitted) "Answer recorded" else "Tap to speak your answer"
                    }
                    Text(
                        text = statusText,
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold,
                        color = when (status) {
                            is VoiceInputStatus.Listening -> Color(0xFF2563EB)
                            is VoiceInputStatus.Success -> Color(0xFF15803D)
                            is VoiceInputStatus.Unmatched -> Color(0xFFB45309)
                            is VoiceInputStatus.Error -> Color(0xFFDC2626)
                            is VoiceInputStatus.Idle -> Color(0xFF334155)
                        },
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Voice Assistant • Say Option A, B, C, D",
                        fontSize = 9.5.sp,
                        color = Color(0xFF64748B),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            IconButton(
                onClick = { showManualSpeechDialog = true },
                modifier = Modifier
                    .size(32.dp)
                    .testTag("voice_demo_prompt_button")
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardVoice,
                    contentDescription = "Simulate voice speech input",
                    tint = Color(0xFF64748B),
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }

    // Accessible Voice Demo / Direct Input Dialog for Emulators & Testing
    if (showManualSpeechDialog) {
        var speechSimulationText by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { showManualSpeechDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Mic, contentDescription = null, tint = Color(0xFF4F46E5))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Voice Answer Input", fontWeight = FontWeight.Bold)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Speak or enter your speech transcript to test the natural voice matcher. Available options: ${options.joinToString()}",
                        fontSize = 12.sp,
                        color = Color(0xFF475569)
                    )
                    OutlinedTextField(
                        value = speechSimulationText,
                        onValueChange = { speechSimulationText = it },
                        label = { Text("Spoken Transcript") },
                        placeholder = { Text("e.g., Option A, True, Paris, Submit") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("voice_simulation_input"),
                        singleLine = true
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showManualSpeechDialog = false
                        handleTranscript(speechSimulationText)
                    },
                    modifier = Modifier.testTag("voice_simulation_confirm_button")
                ) {
                    Text("Apply Spoken Answer")
                }
            },
            dismissButton = {
                TextButton(onClick = { showManualSpeechDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

/**
 * Initiates speech recognition using the standard RecognizerIntent.
 */
private fun startSpeechRecognition(
    context: Context,
    onStartListening: () -> Unit,
    launchIntent: (Intent) -> Unit,
    onFallbackToManual: () -> Unit,
    onError: (String) -> Unit
) {
    try {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak your answer (e.g., \"Option A\", \"True\", or the answer text)")
            putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)
        }

        val packageManager = context.packageManager
        val activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        if (activities.isNotEmpty()) {
            onStartListening()
            launchIntent(intent)
        } else {
            // No system speech recognizer package available (e.g., headless emulator)
            onFallbackToManual()
            onError("System speech recognition service unavailable. Switched to voice input simulator.")
        }
    } catch (e: Exception) {
        onFallbackToManual()
        onError("Speech input error: ${e.localizedMessage}")
    }
}
