package com.example.auth

import android.content.Context
import android.util.Log
import com.example.R
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.CancellationException
import org.json.JSONArray
import org.json.JSONObject

enum class OperationType(val value: String) {
    CREATE("create"),
    UPDATE("update"),
    DELETE("delete"),
    LIST("list"),
    GET("get"),
    WRITE("write"),
}

/**
 * Logs structured JSON diagnostics for every Firestore failure so permission or schema
 * issues can be pinpointed immediately without crashing asynchronous listeners.
 */
fun handleFirestoreError(
    exception: Throwable,
    operationType: OperationType,
    path: String?
): String {
    val causes = generateSequence(exception) { it.cause }
    val rootError = causes.firstOrNull { it is FirebaseFirestoreException }
        ?: causes.firstOrNull { it !is CancellationException }
        ?: exception

    val currentUser = try {
        FirebaseAuth.getInstance().currentUser
    } catch (_: Throwable) {
        null
    }

    val providerInfoList = currentUser?.providerData?.map { provider ->
        JSONObject().apply {
            put("providerId", provider.providerId)
            put("email", provider.email)
        }
    } ?: emptyList()

    val authInfoJson = JSONObject().apply {
        put("userId", currentUser?.uid)
        put("email", currentUser?.email)
        put("emailVerified", currentUser?.isEmailVerified)
        put("tenantId", currentUser?.tenantId)
        put("providerInfo", JSONArray(providerInfoList))
    }

    val errorInfoJson = JSONObject().apply {
        put("error", rootError.message ?: rootError.toString())
        put("operationType", operationType.value)
        put("path", path)
        put("authInfo", authInfoJson)
    }

    val jsonString = errorInfoJson.toString()
    Log.e("FirestoreError", "Firestore Error: $jsonString")
    return jsonString
}

/**
 * Returns the provisioned named Cloud Firestore database instance defined in
 * `res/values/firebase_applet_config.xml` (`firestore_database_id`).
 * Never falls back to the unprovisioned `(default)` database when a named ID is configured.
 */
object NamedFirestoreProvider {
    private const val TAG = "NamedFirestoreProvider"

    fun getApp(context: Context): FirebaseApp? {
        val appCtx = context.applicationContext ?: context
        return try {
            FirebaseApp.getApps(appCtx).firstOrNull()
                ?: FirebaseApp.initializeApp(appCtx)
                ?: initializeFromResources(appCtx)
        } catch (t: Throwable) {
            Log.w(TAG, "FirebaseApp unavailable via default init, retrying explicit options: ${t.message}")
            try {
                initializeFromResources(appCtx)
            } catch (fallbackErr: Throwable) {
                Log.e(TAG, "FirebaseApp initialization failed: ${fallbackErr.message}", fallbackErr)
                null
            }
        }
    }

    private fun initializeFromResources(appCtx: Context): FirebaseApp? {
        val appId = appCtx.getString(R.string.google_app_id).trim()
        val apiKey = appCtx.getString(R.string.google_api_key).trim()
        val projectId = appCtx.getString(R.string.project_id).trim()
        if (appId.isBlank() || apiKey.isBlank() || projectId.isBlank()) {
            Log.e(TAG, "Firebase resource strings missing or blank")
            return null
        }
        val optionsBuilder = FirebaseOptions.Builder()
            .setApplicationId(appId)
            .setApiKey(apiKey)
            .setProjectId(projectId)

        val gcmSenderId = appCtx.getString(R.string.gcm_defaultSenderId).trim()
        if (gcmSenderId.isNotBlank()) optionsBuilder.setGcmSenderId(gcmSenderId)

        val storageBucket = appCtx.getString(R.string.google_storage_bucket).trim()
        if (storageBucket.isNotBlank()) optionsBuilder.setStorageBucket(storageBucket)

        val databaseUrl = appCtx.getString(R.string.firebase_database_url).trim()
        if (databaseUrl.isNotBlank()) optionsBuilder.setDatabaseUrl(databaseUrl)

        return FirebaseApp.initializeApp(appCtx, optionsBuilder.build())
    }

    fun getDatabase(context: Context): FirebaseFirestore? {
        return try {
            val app = getApp(context) ?: return null
            val dbId = context.getString(R.string.firestore_database_id).trim()
            if (dbId.isBlank()) {
                Log.e(TAG, "firestore_database_id resource is blank")
                null
            } else {
                FirebaseFirestore.getInstance(app, dbId)
            }
        } catch (t: Throwable) {
            Log.w(TAG, "Named Firestore initialization failed: ${t.message}")
            null
        }
    }

    fun getAuth(context: Context): FirebaseAuth? {
        return try {
            val app = getApp(context) ?: return null
            FirebaseAuth.getInstance(app)
        } catch (t: Throwable) {
            Log.w(TAG, "FirebaseAuth unavailable: ${t.message}")
            null
        }
    }

    fun currentUid(context: Context): String? {
        return getAuth(context)?.currentUser?.uid
    }

    fun requireAuthenticatedUid(context: Context): String {
        return currentUid(context)
            ?: throw IllegalStateException("Please sign in with Google to use live online 1 vs 1 battles.")
    }
}
