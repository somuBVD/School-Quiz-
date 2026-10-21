package com.example.sync

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import kotlinx.coroutines.CancellationException
import java.util.concurrent.TimeUnit

/**
 * Background WorkManager worker that automatically synchronizes quiz progress
 * and attempt history between the local Room database and Cloud Firestore.
 *
 * Runs with NetworkType.CONNECTED constraint to guarantee reliable transmission
 * without burning battery while offline.
 */
class QuizDataSyncWorker(
    private val appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        Log.d(TAG, "QuizDataSyncWorker started execution")
        return try {
            val syncService = QuizDataSyncService.getInstance(appContext)
            val result = syncService.syncAll()

            if (result.isSuccess) {
                Log.d(
                    TAG,
                    "QuizDataSyncWorker completed successfully: ${result.progressSynced} progress, ${result.historySynced} history synced"
                )
                Result.success()
            } else {
                Log.w(TAG, "QuizDataSyncWorker reported non-fatal sync issue: ${result.errorMessage}")
                // Retry if network dropped or transient failure occurred
                if (runAttemptCount < 3) Result.retry() else Result.success()
            }
        } catch (e: Throwable) {
            if (e is CancellationException || isStopped || e.javaClass.name.contains("Cancellation") || e.message?.contains("cancelled", ignoreCase = true) == true) {
                Log.d(TAG, "QuizDataSyncWorker cancelled normally by WorkManager: ${e.message}")
                Result.success()
            } else {
                Log.e(TAG, "QuizDataSyncWorker error: ${e.message}", e)
                if (runAttemptCount < 3) Result.retry() else Result.failure()
            }
        }
    }

    companion object {
        const val TAG = "QuizDataSyncWorker"
        const val UNIQUE_PERIODIC_WORK_NAME = "quiz_firestore_periodic_sync_work"
        const val UNIQUE_IMMEDIATE_WORK_NAME = "quiz_firestore_immediate_sync_work"

        /**
         * Schedules recurring automatic synchronization with Firestore.
         * Runs periodically (default every 1 hour) whenever device is connected to the internet.
         */
        fun schedulePeriodic(context: Context, intervalHours: Long = 1) {
            try {
                val constraints = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()

                val workRequest = PeriodicWorkRequestBuilder<QuizDataSyncWorker>(
                    intervalHours,
                    TimeUnit.HOURS,
                    15,
                    TimeUnit.MINUTES // Flex interval
                )
                    .setConstraints(constraints)
                    .build()

                WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                    UNIQUE_PERIODIC_WORK_NAME,
                    ExistingPeriodicWorkPolicy.KEEP,
                    workRequest
                )
                Log.d(TAG, "Scheduled periodic Firestore sync every $intervalHours hour(s)")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to schedule periodic quiz sync: ${e.message}", e)
            }
        }

        /**
         * Enqueues an immediate one-time sync task with connected network constraint.
         * Ideal for triggering immediately following quiz completion or after reconnecting.
         */
        fun enqueueImmediate(context: Context) {
            try {
                val constraints = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()

                val workRequest = OneTimeWorkRequestBuilder<QuizDataSyncWorker>()
                    .setConstraints(constraints)
                    .build()

                WorkManager.getInstance(context).enqueueUniqueWork(
                    UNIQUE_IMMEDIATE_WORK_NAME,
                    ExistingWorkPolicy.KEEP,
                    workRequest
                )
                Log.d(TAG, "Enqueued immediate Firestore quiz data sync")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to enqueue immediate quiz sync: ${e.message}", e)
            }
        }

        /**
         * Cancels scheduled background sync work.
         */
        fun cancel(context: Context) {
            try {
                WorkManager.getInstance(context).cancelUniqueWork(UNIQUE_PERIODIC_WORK_NAME)
                Log.d(TAG, "Cancelled periodic quiz data sync")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to cancel periodic quiz sync: ${e.message}", e)
            }
        }
    }
}
