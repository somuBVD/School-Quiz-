package com.example

import android.app.AlarmManager
import android.app.Application
import android.app.NotificationManager
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.notification.DailyReminderScheduler
import com.example.notification.ReminderSettings
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import java.util.Calendar

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class DailyReminderSchedulerTest {

    private lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext<Application>()
    }

    @Test
    fun testReminderSettingsTimeFormatting() {
        val morning = ReminderSettings(isEnabled = true, hour = 8, minute = 0)
        assertEquals("8:00 AM", morning.formattedTime)

        val evening = ReminderSettings(isEnabled = true, hour = 18, minute = 0)
        assertEquals("6:00 PM", evening.formattedTime)

        val night = ReminderSettings(isEnabled = true, hour = 20, minute = 30)
        assertEquals("8:30 PM", night.formattedTime)

        val midnight = ReminderSettings(isEnabled = true, hour = 0, minute = 15)
        assertEquals("12:15 AM", midnight.formattedTime)

        val noon = ReminderSettings(isEnabled = true, hour = 12, minute = 45)
        assertEquals("12:45 PM", noon.formattedTime)
    }

    @Test
    fun testCalculateNextTriggerMillis() {
        // Mock current time: 10:00 AM today
        val cal = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 10)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        val currentTime = cal.timeInMillis

        // 1. Time later today (6:00 PM): should trigger today
        val triggerLaterToday = DailyReminderScheduler.calculateNextTriggerMillis(18, 0, currentTime)
        val triggerCal = Calendar.getInstance().apply { timeInMillis = triggerLaterToday }
        assertEquals(18, triggerCal.get(Calendar.HOUR_OF_DAY))
        assertEquals(0, triggerCal.get(Calendar.MINUTE))
        assertEquals(cal.get(Calendar.DAY_OF_YEAR), triggerCal.get(Calendar.DAY_OF_YEAR))

        // 2. Time earlier today (8:00 AM): should trigger tomorrow
        val triggerTomorrow = DailyReminderScheduler.calculateNextTriggerMillis(8, 0, currentTime)
        val triggerTomorrowCal = Calendar.getInstance().apply { timeInMillis = triggerTomorrow }
        assertEquals(8, triggerTomorrowCal.get(Calendar.HOUR_OF_DAY))
        assertEquals(0, triggerTomorrowCal.get(Calendar.MINUTE))
        assertTrue(triggerTomorrow > currentTime)
    }

    @Test
    fun testSaveAndGetReminderSettings() {
        val newSettings = ReminderSettings(isEnabled = true, hour = 19, minute = 45)
        DailyReminderScheduler.saveSettings(context, newSettings)

        val retrieved = DailyReminderScheduler.getSettings(context)
        assertTrue(retrieved.isEnabled)
        assertEquals(19, retrieved.hour)
        assertEquals(45, retrieved.minute)
        assertEquals("7:45 PM", retrieved.formattedTime)
    }

    @Test
    fun testScheduleAndCancelDailyReminder() {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val shadowAlarmManager = Shadows.shadowOf(alarmManager)

        // Schedule
        DailyReminderScheduler.scheduleDailyReminder(context, 17, 30)

        val scheduledSettings = DailyReminderScheduler.getSettings(context)
        assertTrue(scheduledSettings.isEnabled)
        assertEquals(17, scheduledSettings.hour)
        assertEquals(30, scheduledSettings.minute)

        val nextScheduledAlarm = shadowAlarmManager.scheduledAlarms.firstOrNull()
        assertNotNull(nextScheduledAlarm)

        // Cancel
        DailyReminderScheduler.cancelDailyReminder(context)
        val cancelledSettings = DailyReminderScheduler.getSettings(context)
        assertFalse(cancelledSettings.isEnabled)
    }

    @Test
    fun testNotificationChannelCreated() {
        DailyReminderScheduler.createNotificationChannel(context)
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = notificationManager.getNotificationChannel(DailyReminderScheduler.CHANNEL_ID)
        assertNotNull(channel)
        assertEquals(DailyReminderScheduler.CHANNEL_NAME, channel.name)
    }

    @Test
    fun testSendImmediateTestReminder() {
        DailyReminderScheduler.sendImmediateTestReminder(context)
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val shadowNotificationManager = Shadows.shadowOf(notificationManager)
        val notifications = shadowNotificationManager.allNotifications
        assertFalse(notifications.isEmpty())
        val postedNotification = notifications.find { it.channelId == DailyReminderScheduler.CHANNEL_ID }
        assertNotNull(postedNotification)
    }

    @Test
    fun testWorkManagerReminderScheduling() {
        DailyReminderScheduler.scheduleDailyReminderWithWorkManager(
            context = context,
            hour = 18,
            minute = 30,
            customMessage = "Test WorkManager message",
            preferredSubject = "Mathematics"
        )

        val settings = DailyReminderScheduler.getSettings(context)
        assertTrue(settings.isEnabled)
        assertEquals(18, settings.hour)
        assertEquals(30, settings.minute)
        assertEquals("Test WorkManager message", settings.customMessage)
        assertEquals("Mathematics", settings.preferredSubject)

        DailyReminderScheduler.cancelDailyReminderWithWorkManager(context)
        val cancelledSettings = DailyReminderScheduler.getSettings(context)
        assertFalse(cancelledSettings.isEnabled)
    }

    @Test
    fun testSendQuizReminderNotification() {
        val settings = ReminderSettings(
            isEnabled = true,
            hour = 19,
            minute = 0,
            customMessage = "Practice makes perfect!",
            preferredSubject = "Science"
        )
        DailyReminderScheduler.sendQuizReminderNotification(context, settings)
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val shadowNotificationManager = Shadows.shadowOf(notificationManager)
        val notifications = shadowNotificationManager.allNotifications
        assertFalse(notifications.isEmpty())
        val postedNotification = notifications.find { it.channelId == DailyReminderScheduler.CHANNEL_ID }
        assertNotNull(postedNotification)
    }
}
