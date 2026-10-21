package com.example.notification

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.MainActivity

/**
 * BroadcastReceiver triggered by AlarmManager or device boot to fire daily quiz reminders.
 */
class DailyReminderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        if (action == Intent.ACTION_BOOT_COMPLETED) {
            // Reschedule daily reminder after device reboot
            val settings = DailyReminderScheduler.getSettings(context)
            if (settings.isEnabled) {
                DailyReminderScheduler.scheduleDailyReminder(
                    context = context,
                    hour = settings.hour,
                    minute = settings.minute
                )
            }
            return
        }

        if (action == DailyReminderScheduler.ACTION_DAILY_QUIZ_REMINDER) {
            val settings = DailyReminderScheduler.getSettings(context)
            if (!settings.isEnabled) return

            // Ensure channel exists
            DailyReminderScheduler.createNotificationChannel(context)

            // Content intent to open MainActivity
            val contentIntent = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                putExtra("navigate_to", "daily_challenge")
            }

            val pendingIntent = PendingIntent.getActivity(
                context,
                DailyReminderScheduler.NOTIFICATION_ID,
                contentIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            val motivationalPhrases = listOf(
                "Keep your learning streak alive! 📚✨ Practice 5 quick questions today.",
                "Today's practice questions are ready! Earn 10 points per answer and level up your Quiz Rank. 🏆",
                "A little practice each day leads to mastery! Complete today's quiz challenge now. 🌟"
            )
            val selectedPhrase = motivationalPhrases.random()

            val notification = NotificationCompat.Builder(context, DailyReminderScheduler.CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("🎯 Time for Daily Practice Quiz!")
                .setContentText(selectedPhrase)
                .setStyle(NotificationCompat.BigTextStyle().bigText(selectedPhrase))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()

            try {
                NotificationManagerCompat.from(context).notify(
                    DailyReminderScheduler.NOTIFICATION_ID,
                    notification
                )
            } catch (_: SecurityException) {
                // Notification permission not granted
            }

            // Reschedule for next day
            DailyReminderScheduler.scheduleDailyReminder(
                context = context,
                hour = settings.hour,
                minute = settings.minute
            )
        }
    }
}
