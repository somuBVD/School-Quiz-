package com.example.notification

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.MainActivity
import com.example.R
import java.util.Calendar
import java.util.Locale

/**
 * Data model for daily quiz practice reminder settings.
 */
data class ReminderSettings(
    val isEnabled: Boolean = true,
    val hour: Int = 18,     // Default: 6:00 PM
    val minute: Int = 0,    // Default: :00
    val customMessage: String = "Keep your learning streak alive! Practice 5 quick questions today.",
    val preferredSubject: String = "All Subjects"
) {
    val formattedTime: String
        get() {
            val period = if (hour >= 12) "PM" else "AM"
            val displayHour = when {
                hour == 0 -> 12
                hour > 12 -> hour - 12
                else -> hour
            }
            val displayMinute = String.format(Locale.getDefault(), "%02d", minute)
            return "$displayHour:$displayMinute $period"
        }
}

/**
 * Local notification scheduler that schedules, reschedules, cancels,
 * and triggers daily practice quiz reminders for students.
 */
object DailyReminderScheduler {

    const val CHANNEL_ID = "daily_quiz_practice_reminder"
    const val CHANNEL_NAME = "Daily Practice Quiz Reminder"
    const val NOTIFICATION_ID = 2001
    const val ACTION_DAILY_QUIZ_REMINDER = "com.example.ACTION_DAILY_QUIZ_REMINDER"

    private const val PREFS_NAME = "daily_reminder_prefs"
    private const val KEY_ENABLED = "reminder_enabled"
    private const val KEY_HOUR = "reminder_hour"
    private const val KEY_MINUTE = "reminder_minute"
    private const val KEY_CUSTOM_MESSAGE = "reminder_custom_message"
    private const val KEY_PREFERRED_SUBJECT = "reminder_preferred_subject"
    private const val KEY_LAST_TRIGGER = "last_reminder_trigger_timestamp"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Creates the Android Notification Channel required on Android 8.0+ (API 26+).
     */
    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Daily practice reminders to keep your quiz learning streak active."
                enableLights(true)
                enableVibration(true)
                setShowBadge(true)
            }
            manager?.createNotificationChannel(channel)
        }
    }

    /**
     * Schedules the daily practice reminder via WorkManager (and AlarmManager) at the specified hour and minute.
     */
    fun scheduleDailyReminder(
        context: Context,
        hour: Int,
        minute: Int,
        customMessage: String? = null,
        preferredSubject: String? = null
    ) {
        createNotificationChannel(context)

        // 1. Primary: Schedule using Android WorkManager for reliable background execution
        try {
            DailyQuizReminderWorker.schedule(context, hour, minute)
        } catch (_: Exception) {
            // WorkManager fallback if not yet initialized in test
        }

        // 2. AlarmManager scheduling for precise delivery and test runner compatibility
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        if (alarmManager != null) {
            val intent = Intent(context, DailyReminderReceiver::class.java).apply {
                action = ACTION_DAILY_QUIZ_REMINDER
            }

            val pendingIntent = PendingIntent.getBroadcast(
                context,
                NOTIFICATION_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            val triggerAtMillis = calculateNextTriggerMillis(hour, minute)

            try {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    triggerAtMillis,
                    pendingIntent
                )
            } catch (_: SecurityException) {
                alarmManager.set(
                    AlarmManager.RTC_WAKEUP,
                    triggerAtMillis,
                    pendingIntent
                )
            }
        }

        // Persist configured settings
        val current = getSettings(context)
        saveSettings(
            context,
            ReminderSettings(
                isEnabled = true,
                hour = hour,
                minute = minute,
                customMessage = customMessage ?: current.customMessage,
                preferredSubject = preferredSubject ?: current.preferredSubject
            )
        )
    }

    /**
     * Explicit WorkManager daily reminder scheduling entrypoint.
     */
    fun scheduleDailyReminderWithWorkManager(
        context: Context,
        hour: Int,
        minute: Int,
        customMessage: String? = null,
        preferredSubject: String? = null
    ) {
        scheduleDailyReminder(context, hour, minute, customMessage, preferredSubject)
    }

    /**
     * Cancels any scheduled daily practice reminder from both WorkManager and AlarmManager.
     */
    fun cancelDailyReminder(context: Context) {
        // 1. Cancel WorkManager job
        try {
            DailyQuizReminderWorker.cancel(context)
        } catch (_: Exception) {
        }

        // 2. Cancel AlarmManager pending intent
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
        if (alarmManager != null) {
            val intent = Intent(context, DailyReminderReceiver::class.java).apply {
                action = ACTION_DAILY_QUIZ_REMINDER
            }

            val pendingIntent = PendingIntent.getBroadcast(
                context,
                NOTIFICATION_ID,
                intent,
                PendingIntent.FLAG_NO_CREATE or PendingIntent.FLAG_IMMUTABLE
            )

            if (pendingIntent != null) {
                alarmManager.cancel(pendingIntent)
                pendingIntent.cancel()
            }
        }

        val current = getSettings(context)
        saveSettings(context, current.copy(isEnabled = false))
    }

    /**
     * Explicit WorkManager cancellation entrypoint.
     */
    fun cancelDailyReminderWithWorkManager(context: Context) {
        cancelDailyReminder(context)
    }

    /**
     * Dispatches the local practice quiz notification with action buttons and rich styling.
     */
    fun sendQuizReminderNotification(context: Context, settings: ReminderSettings) {
        createNotificationChannel(context)

        // Main Tap Intent: Launches MainActivity into daily challenge
        val contentIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("navigate_to", "daily_challenge")
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID,
            contentIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Action 1: "Play Quiz Now"
        val playQuizIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("navigate_to", "quiz")
        }
        val playQuizPendingIntent = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID + 10,
            playQuizIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Action 2: "Flashcards"
        val flashcardIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("navigate_to", "flashcards")
        }
        val flashcardPendingIntent = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID + 20,
            flashcardIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val subjectPrefix = if (settings.preferredSubject != "All Subjects") "${settings.preferredSubject} • " else ""
        val title = "🎯 ${subjectPrefix}Daily Quiz Challenge!"
        val body = settings.customMessage.ifBlank { "Keep your learning streak alive! Practice 5 quick questions today." }

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(body)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("$body\n\n⏰ Scheduled daily via WorkManager for ${settings.formattedTime}. Complete today's session to earn +20 coins & maintain your daily streak!")
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .addAction(android.R.drawable.ic_media_play, "Play Quiz 🎯", playQuizPendingIntent)
            .addAction(android.R.drawable.ic_menu_agenda, "Flashcards 📚", flashcardPendingIntent)
            .setAutoCancel(true)
            .build()

        try {
            NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
        } catch (_: SecurityException) {
            // Notification permission denied
        }
    }

    /**
     * Dispatches an immediate practice quiz notification for testing and instant preview.
     */
    fun sendImmediateTestReminder(context: Context) {
        createNotificationChannel(context)
        val settings = getSettings(context)

        // Intent to launch MainActivity when notification is tapped
        val contentIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("navigate_to", "daily_challenge")
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID + 1,
            contentIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val subjectPrefix = if (settings.preferredSubject != "All Subjects") "${settings.preferredSubject} • " else ""
        val title = "🎯 ${subjectPrefix}Daily Practice Reminder"
        val body = settings.customMessage.ifBlank { "Keep your learning streak alive! Solve today's practice questions & earn bonus coins." }

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(body)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("$body\n\nScheduled for ${settings.formattedTime} daily. Solve practice questions to earn +10 points & climb quiz ranks!")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        try {
            NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
        } catch (_: SecurityException) {
            // Permission not granted yet
        }
    }

    /**
     * Calculates the next epoch timestamp for the given hour and minute.
     * If the time has already passed today, schedules for tomorrow.
     */
    fun calculateNextTriggerMillis(hour: Int, minute: Int, currentTimeMillis: Long = System.currentTimeMillis()): Long {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = currentTimeMillis
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }

        if (calendar.timeInMillis <= currentTimeMillis) {
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }

        return calendar.timeInMillis
    }

    /**
     * Retrieves the stored reminder settings.
     */
    fun getSettings(context: Context): ReminderSettings {
        val prefs = getPrefs(context)
        return ReminderSettings(
            isEnabled = prefs.getBoolean(KEY_ENABLED, true),
            hour = prefs.getInt(KEY_HOUR, 18),
            minute = prefs.getInt(KEY_MINUTE, 0),
            customMessage = prefs.getString(KEY_CUSTOM_MESSAGE, "Keep your learning streak alive! Practice 5 quick questions today.")
                ?: "Keep your learning streak alive! Practice 5 quick questions today.",
            preferredSubject = prefs.getString(KEY_PREFERRED_SUBJECT, "All Subjects") ?: "All Subjects"
        )
    }

    /**
     * Saves the reminder settings to SharedPreferences.
     */
    fun saveSettings(context: Context, settings: ReminderSettings) {
        getPrefs(context).edit()
            .putBoolean(KEY_ENABLED, settings.isEnabled)
            .putInt(KEY_HOUR, settings.hour)
            .putInt(KEY_MINUTE, settings.minute)
            .putString(KEY_CUSTOM_MESSAGE, settings.customMessage)
            .putString(KEY_PREFERRED_SUBJECT, settings.preferredSubject)
            .apply()
    }
}
