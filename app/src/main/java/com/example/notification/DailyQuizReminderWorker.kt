package com.example.notification

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

/**
 * WorkManager CoroutineWorker responsible for background execution of daily quiz reminders.
 * Runs reliably across app process termination and device restarts.
 */
class DailyQuizReminderWorker(
    private val appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        Log.d(TAG, "DailyQuizReminderWorker executing scheduled reminder task")
        try {
            val settings = DailyReminderScheduler.getSettings(appContext)

            if (!settings.isEnabled) {
                Log.d(TAG, "Daily reminders disabled in settings. Skipping notification.")
                return Result.success()
            }

            // Post the local notification
            DailyReminderScheduler.sendQuizReminderNotification(appContext, settings)

            // Reschedule the next day's reminder via WorkManager
            schedule(appContext, settings.hour, settings.minute)

            return Result.success()
        } catch (e: Exception) {
            Log.e(TAG, "Error executing DailyQuizReminderWorker: ${e.message}", e)
            return Result.retry()
        }
    }

    companion object {
        const val TAG = "DailyQuizReminderWorker"
        const val UNIQUE_WORK_NAME = "daily_quiz_practice_reminder_work"
        const val TEST_WORK_NAME = "test_quiz_reminder_work"

        /**
         * Schedules the daily quiz reminder using WorkManager with a calculated initial delay
         * targeting the user's chosen hour and minute.
         */
        fun schedule(
            context: Context,
            hour: Int,
            minute: Int
        ) {
            val nextTriggerMillis = DailyReminderScheduler.calculateNextTriggerMillis(hour, minute)
            val delayMillis = (nextTriggerMillis - System.currentTimeMillis()).coerceAtLeast(0)

            Log.d(TAG, "Scheduling WorkManager reminder for $hour:$minute (delay: ${delayMillis / 1000}s)")

            val constraints = Constraints.Builder()
                .setRequiresBatteryNotLow(false)
                .build()

            val workRequest = OneTimeWorkRequestBuilder<DailyQuizReminderWorker>()
                .setInitialDelay(delayMillis, TimeUnit.MILLISECONDS)
                .setConstraints(constraints)
                .addTag(TAG)
                .build()

            WorkManager.getInstance(context).enqueueUniqueWork(
                UNIQUE_WORK_NAME,
                ExistingWorkPolicy.REPLACE,
                workRequest
            )
        }

        /**
         * Enqueues an immediate one-time WorkManager task to test background notification dispatch.
         */
        fun enqueueImmediateTest(context: Context) {
            Log.d(TAG, "Enqueuing immediate test reminder via WorkManager")
            val workRequest = OneTimeWorkRequestBuilder<DailyQuizReminderWorker>()
                .setInitialDelay(0, TimeUnit.MILLISECONDS)
                .addTag("immediate_test")
                .build()

            WorkManager.getInstance(context).enqueueUniqueWork(
                TEST_WORK_NAME,
                ExistingWorkPolicy.REPLACE,
                workRequest
            )
        }

        /**
         * Cancels the active WorkManager daily reminder job.
         */
        fun cancel(context: Context) {
            Log.d(TAG, "Cancelling WorkManager daily reminder")
            WorkManager.getInstance(context).cancelUniqueWork(UNIQUE_WORK_NAME)
        }
    }
}
