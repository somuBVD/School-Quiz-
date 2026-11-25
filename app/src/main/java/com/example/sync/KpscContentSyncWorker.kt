package com.example.sync

import android.content.Context
import android.util.Log
import androidx.work.BackoffPolicy
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
 * Background WorkManager worker that periodically fetches updated KPSC-specific
 * study materials and MCQs from Cloud Firestore and indexes them in the local
 * Room database for offline exam preparation.
 */
class KpscContentSyncWorker(
    private val appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        Log.d(TAG, "KpscContentSyncWorker started (attempt=$runAttemptCount)")
        return try {
            val service = KpscContentSyncService.getInstance(appContext)
            val result = service.syncKpscContent()

            if (result.isSuccess) {
                Log.d(
                    TAG,
                    "KpscContentSyncWorker completed: ${result.materialsSynced} materials, " +
                        "${result.questionsIndexed} KPSC questions indexed (remoteMaterials=${result.remoteMaterialsFetched}, " +
                        "remoteQuestions=${result.remoteQuestionsFetched})"
                )
                Result.success()
            } else {
                Log.w(TAG, "KpscContentSyncWorker partial sync warning: ${result.errorMessage}")
                if (runAttemptCount < 3) Result.retry() else Result.success()
            }
        } catch (e: Throwable) {
            if (e is CancellationException || isStopped) {
                Log.d(TAG, "KpscContentSyncWorker cancelled normally by WorkManager")
                Result.success()
            } else {
                Log.e(TAG, "KpscContentSyncWorker failed: ${e.message}", e)
                if (runAttemptCount < 3) Result.retry() else Result.failure()
            }
        }
    }

    companion object {
        const val TAG = "KpscContentSyncWorker"
        const val UNIQUE_PERIODIC_WORK_NAME = "kpsc_content_periodic_sync_work"
        const val UNIQUE_IMMEDIATE_WORK_NAME = "kpsc_content_immediate_sync_work"

        /**
         * Schedules periodic background KPSC quiz & study material synchronization.
         * Runs every [intervalHours] hours (default 6h) when network is connected and battery is not low.
         */
        fun schedulePeriodic(context: Context, intervalHours: Long = 6) {
            try {
                val constraints = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .setRequiresBatteryNotLow(true)
                    .build()

                val periodicRequest = PeriodicWorkRequestBuilder<KpscContentSyncWorker>(
                    intervalHours.coerceAtLeast(1),
                    TimeUnit.HOURS,
                    30,
                    TimeUnit.MINUTES
                )
                    .setConstraints(constraints)
                    .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 15, TimeUnit.MINUTES)
                    .addTag(TAG)
                    .build()

                WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                    UNIQUE_PERIODIC_WORK_NAME,
                    ExistingPeriodicWorkPolicy.KEEP,
                    periodicRequest
                )
                Log.d(TAG, "Scheduled periodic KPSC content sync every $intervalHours hours")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to schedule periodic KPSC content sync: ${e.message}", e)
            }
        }

        /**
         * Enqueues an immediate KPSC content sync job with connected network constraint.
         */
        fun enqueueImmediate(context: Context) {
            try {
                val constraints = Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()

                val immediateRequest = OneTimeWorkRequestBuilder<KpscContentSyncWorker>()
                    .setConstraints(constraints)
                    .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 30, TimeUnit.SECONDS)
                    .addTag(TAG)
                    .build()

                WorkManager.getInstance(context).enqueueUniqueWork(
                    UNIQUE_IMMEDIATE_WORK_NAME,
                    ExistingWorkPolicy.REPLACE,
                    immediateRequest
                )
                Log.d(TAG, "Enqueued immediate KPSC content sync")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to enqueue immediate KPSC content sync: ${e.message}", e)
            }
        }

        /**
         * Cancels periodic and pending KPSC sync jobs.
         */
        fun cancel(context: Context) {
            try {
                val wm = WorkManager.getInstance(context)
                wm.cancelUniqueWork(UNIQUE_PERIODIC_WORK_NAME)
                wm.cancelUniqueWork(UNIQUE_IMMEDIATE_WORK_NAME)
                Log.d(TAG, "Cancelled KPSC content sync work")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to cancel KPSC content sync: ${e.message}", e)
            }
        }
    }
}
