package com.example.ui.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.CloudSync
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auth.CloudSyncState

/**
 * Reusable Offline Mode & Cloud Sync Indicator UI component.
 * Dynamically tracks student's real network connectivity and Firestore sync status.
 */
@Composable
fun OfflineModeSyncBanner(
    cloudSyncState: CloudSyncState,
    isDark: Boolean,
    onSyncNow: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isNetworkConnected by remember { mutableStateOf(checkNetworkConnected(context)) }

    // Register active network callback
    DisposableEffect(context) {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                isNetworkConnected = true
            }

            override fun onLost(network: Network) {
                isNetworkConnected = false
            }
        }

        try {
            val request = NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build()
            connectivityManager?.registerNetworkCallback(request, callback)
        } catch (e: Exception) {
            isNetworkConnected = checkNetworkConnected(context)
        }

        onDispose {
            try {
                connectivityManager?.unregisterNetworkCallback(callback)
            } catch (ignored: Exception) {}
        }
    }

    var isExpanded by remember { mutableStateOf(false) }

    val (bgColor, borderColor, icon, statusTitle, statusSubtitle) = when {
        !isNetworkConnected -> {
            Quint(
                if (isDark) Color(0xFF451A03).copy(alpha = 0.8f) else Color(0xFFFEF3C7),
                if (isDark) Color(0xFFD97706) else Color(0xFFF59E0B),
                Icons.Default.WifiOff,
                "Offline Mode Active (Firestore Persistence)",
                "Quizzes work 100% offline due to the Firestore persistence setting and local Room DB. Progress is safely saved to disk cache and will sync to Firebase once connection returns."
            )
        }
        cloudSyncState is CloudSyncState.Syncing -> {
            Quint(
                if (isDark) Color(0xFF1E1B4B).copy(alpha = 0.8f) else Color(0xFFEEF2FF),
                if (isDark) Color(0xFF6366F1) else Color(0xFF818CF8),
                Icons.Default.CloudSync,
                "Syncing with Firebase...",
                "Uploading local Room database scores, progress, and custom questions to Firebase Cloud."
            )
        }
        cloudSyncState is CloudSyncState.Success -> {
            Quint(
                if (isDark) Color(0xFF064E3B).copy(alpha = 0.8f) else Color(0xFFD1FAE5),
                if (isDark) Color(0xFF059669) else Color(0xFF10B981),
                Icons.Default.CloudDone,
                "Online & Synced",
                cloudSyncState.message.ifBlank { "All local Room data is fully up to date with Firebase Cloud." }
            )
        }
        cloudSyncState is CloudSyncState.Error -> {
            val rawMsg = cloudSyncState.message
            val isApiKeyOrInternal = rawMsg.contains("api key", ignoreCase = true) || rawMsg.contains("internal error", ignoreCase = true)
            Quint(
                if (isApiKeyOrInternal) (if (isDark) Color(0xFF064E3B).copy(alpha = 0.8f) else Color(0xFFD1FAE5))
                else (if (isDark) Color(0xFF450A0A).copy(alpha = 0.8f) else Color(0xFFFEE2E2)),
                if (isApiKeyOrInternal) (if (isDark) Color(0xFF059669) else Color(0xFF10B981))
                else (if (isDark) Color(0xFFDC2626) else Color(0xFFEF4444)),
                if (isApiKeyOrInternal) Icons.Default.CloudDone else Icons.Default.CloudOff,
                if (isApiKeyOrInternal) "Offline Storage Active" else "Sync Notice",
                if (isApiKeyOrInternal) "All quiz progress, scores, and questions are saved safely on this device."
                else "Offline storage active. Cloud sync will retry automatically: $rawMsg"
            )
        }
        else -> {
            Quint(
                if (isDark) Color(0xFF064E3B).copy(alpha = 0.6f) else Color(0xFFECFDF5),
                if (isDark) Color(0xFF059669) else Color(0xFF34D399),
                Icons.Default.CloudDone,
                "Online (Room & Cloud Active)",
                "Full offline resilience enabled. All quiz attempts persist locally and sync to Firebase."
            )
        }
    }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { isExpanded = !isExpanded }
            .testTag("offline_sync_status_banner"),
        shape = RoundedCornerShape(16.dp),
        color = bgColor,
        border = BorderStroke(1.dp, borderColor)
    ) {
        Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(borderColor.copy(alpha = 0.25f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = statusTitle,
                            tint = borderColor,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(
                            text = statusTitle,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = if (isDark) Color.White else Color(0xFF0F172A)
                        )
                        Text(
                            text = if (isNetworkConnected) "Local Room SQLite + Firebase Synced" else "Firestore Persistence Disk Cache Active",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = if (isDark) Color(0xFFCBD5E1) else Color(0xFF475569)
                        )
                    }
                }

                // Sync button
                IconButton(
                    onClick = onSyncNow,
                    modifier = Modifier
                        .size(32.dp)
                        .testTag("sync_now_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Sync Now",
                        tint = borderColor,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            // Expandable details section
            AnimatedVisibility(visible = isExpanded) {
                Column(modifier = Modifier.padding(top = 8.dp, start = 38.dp, end = 4.dp)) {
                    HorizontalDivider(
                        color = borderColor.copy(alpha = 0.3f),
                        thickness = 1.dp,
                        modifier = Modifier.padding(bottom = 6.dp)
                    )
                    Text(
                        text = statusSubtitle,
                        fontSize = 11.sp,
                        lineHeight = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = if (isDark) Color(0xFFE2E8F0) else Color(0xFF334155)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "💡 Tap 'Sync Now' anytime to force synchronize local quiz scores and progress.",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = borderColor
                    )
                }
            }
        }
    }
}

private fun checkNetworkConnected(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager ?: return false
    val network = cm.activeNetwork ?: return false
    val capabilities = cm.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}

private data class Quint<A, B, C, D, E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E
)
