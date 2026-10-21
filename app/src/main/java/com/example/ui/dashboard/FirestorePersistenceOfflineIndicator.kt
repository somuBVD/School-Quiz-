package com.example.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Visual indicator on the Student Dashboard that shows when the app is working
 * in offline mode due to the Firestore persistence setting (PersistentCacheSettings).
 */
@Composable
fun FirestorePersistenceOfflineIndicator(
    isOffline: Boolean,
    isPersistenceActive: Boolean,
    isForcedOffline: Boolean,
    isDark: Boolean,
    onToggleOfflineMode: () -> Unit,
    onSyncNow: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showDetailsDialog by remember { mutableStateOf(false) }
    var isExpanded by remember { mutableStateOf(false) }

    // Pulsing animation for the offline indicator dot
    val infiniteTransition = rememberInfiniteTransition(label = "pulse_transition")
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.4f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(900, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_alpha"
    )

    val containerBg = if (isOffline) {
        if (isDark) Color(0xFF451A03).copy(alpha = 0.85f) else Color(0xFFFFFBEB)
    } else {
        if (isDark) Color(0xFF064E3B).copy(alpha = 0.35f) else Color(0xFFF0FDF4)
    }

    val borderColor = if (isOffline) {
        if (isDark) Color(0xFFF59E0B) else Color(0xFFD97706)
    } else {
        if (isDark) Color(0xFF10B981) else Color(0xFF059669)
    }

    val primaryTextColor = if (isDark) Color.White else Color(0xFF1E293B)
    val subtitleTextColor = if (isDark) Color(0xFFE2E8F0) else Color(0xFF475569)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("firestore_offline_persistence_indicator"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = containerBg),
        border = BorderStroke(1.5.dp, borderColor.copy(alpha = if (isOffline) 0.85f else 0.45f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            // Header Row: Status badge & Toggle switch
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    // Pulsing Status Icon Circle
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(
                                if (isOffline) {
                                    borderColor.copy(alpha = 0.2f * pulseAlpha + 0.1f)
                                } else {
                                    borderColor.copy(alpha = 0.15f)
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (isOffline) Icons.Default.CloudOff else Icons.Default.CloudDone,
                            contentDescription = if (isOffline) "Offline Mode Active" else "Cloud Online",
                            tint = borderColor,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = if (isOffline) "Working in Offline Mode" else "Firestore Online & Persistent",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = primaryTextColor
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            // Badge pill
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = if (isOffline) Color(0xFFD97706) else Color(0xFF059669),
                                modifier = Modifier.testTag("firestore_offline_persistence_badge")
                            ) {
                                Text(
                                    text = if (isOffline) "Firestore Persistence" else "Ready",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(
                            text = if (isOffline) {
                                "Serving & storing via Firestore disk cache setting"
                            } else {
                                "Unlimited offline cache active & ready"
                            },
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = subtitleTextColor
                        )
                    }
                }

                // Interactive Toggle / Details Action Button
                IconButton(
                    onClick = { showDetailsDialog = true },
                    modifier = Modifier
                        .size(34.dp)
                        .testTag("firestore_persistence_details_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Firestore Persistence Info",
                        tint = borderColor,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Informative Context Box
            if (isOffline) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = if (isDark) Color(0xFF291505) else Color(0xFFFEF3C7),
                    border = BorderStroke(1.dp, borderColor.copy(alpha = 0.35f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(verticalAlignment = Alignment.Top) {
                            Text("⚡", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "App is operating in offline mode due to the Firestore persistence setting. Your quiz questions, unit progress, XP, and scores remain 100% accessible via local disk persistence and will synchronize automatically once reconnected.",
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = if (isDark) Color(0xFFFDE68A) else Color(0xFF92400E)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
            }

            // Status Chips Row (Cache, Persistence, Sync)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("firestore_cache_info_row"),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                PersistenceStatusChip(
                    icon = Icons.Default.SdStorage,
                    label = "Disk: Unlimited",
                    tint = borderColor,
                    isDark = isDark,
                    modifier = Modifier.weight(1f)
                )

                PersistenceStatusChip(
                    icon = Icons.Default.CheckCircle,
                    label = if (isPersistenceActive) "Setting: Active" else "Setting: Off",
                    tint = borderColor,
                    isDark = isDark,
                    modifier = Modifier.weight(1f)
                )

                PersistenceStatusChip(
                    icon = Icons.Default.Sync,
                    label = if (isOffline) "Auto-Sync Ready" else "Real-time Synced",
                    tint = borderColor,
                    isDark = isDark,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Action Buttons Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Toggle Offline Simulation Button
                OutlinedButton(
                    onClick = onToggleOfflineMode,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, borderColor),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                    modifier = Modifier
                        .weight(1.2f)
                        .testTag("firestore_offline_toggle_button")
                ) {
                    Icon(
                        imageVector = if (isOffline) Icons.Default.Wifi else Icons.Default.WifiOff,
                        contentDescription = null,
                        tint = borderColor,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (isOffline) "Go Online" else "Simulate Offline",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = borderColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Sync / Cache Details Button
                Button(
                    onClick = {
                        if (isOffline) {
                            showDetailsDialog = true
                        } else {
                            onSyncNow()
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = borderColor),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("firestore_offline_sync_button")
                ) {
                    Icon(
                        imageVector = if (isOffline) Icons.Default.Storage else Icons.Default.Refresh,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = if (isOffline) "Cache Info" else "Sync Now",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }

    // Comprehensive Firestore Persistence Details Dialog
    if (showDetailsDialog) {
        AlertDialog(
            onDismissRequest = { showDetailsDialog = false },
            modifier = Modifier.testTag("firestore_cache_info_dialog"),
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Storage,
                        contentDescription = null,
                        tint = borderColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Firestore Offline Persistence",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "How Firestore Offline Persistence Works:",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = primaryTextColor
                    )

                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = if (isDark) Color(0xFF1E293B) else Color(0xFFF1F5F9),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            InfoRow(label = "Persistence Engine", value = "PersistentCacheSettings")
                            InfoRow(label = "Disk Cache Size", value = "CACHE_SIZE_UNLIMITED")
                            InfoRow(label = "Offline Mode Status", value = if (isOffline) "ACTIVE (Offline)" else "ONLINE (Ready)")
                            InfoRow(label = "Local Data Source", value = "Persistent Disk Cache (Source.CACHE)")
                            InfoRow(label = "Sync Strategy", value = "Bidirectional Auto-Reconciliation")
                        }
                    }

                    Text(
                        text = "Key Offline Capabilities Enabled:\n" +
                                "• Student profile, coins, stars, and XP remain fully readable and updatable offline.\n" +
                                "• All curriculum question banks and custom quizzes work without internet connectivity.\n" +
                                "• Historical score records are queued locally and automatically committed upon network reconnection.",
                        fontSize = 11.sp,
                        lineHeight = 16.sp,
                        color = subtitleTextColor
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { showDetailsDialog = false }) {
                    Text("Close", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDetailsDialog = false
                    onToggleOfflineMode()
                }) {
                    Text(if (isOffline) "Switch Online" else "Simulate Offline")
                }
            }
        )
    }
}

/**
 * Compact visual pill indicator for the Student Dashboard header.
 */
@Composable
fun FirestorePersistenceStatusPill(
    isOffline: Boolean,
    isPersistenceActive: Boolean,
    isDark: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bgColor = if (isOffline) {
        if (isDark) Color(0xFF78350F) else Color(0xFFFEF3C7)
    } else {
        if (isDark) Color(0xFF064E3B) else Color(0xFFD1FAE5)
    }

    val contentColor = if (isOffline) {
        if (isDark) Color(0xFFFDE68A) else Color(0xFFB45309)
    } else {
        if (isDark) Color(0xFF6EE7B7) else Color(0xFF047857)
    }

    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        color = bgColor,
        border = BorderStroke(1.dp, contentColor.copy(alpha = 0.5f)),
        modifier = modifier.testTag("firestore_persistence_status_pill")
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .clip(CircleShape)
                    .background(contentColor)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = if (isOffline) "Offline (Firestore Cache)" else "Firestore Online",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
        }
    }
}

@Composable
private fun PersistenceStatusChip(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    tint: Color,
    isDark: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = if (isDark) Color(0xFF1E293B) else Color(0xFFF8FAFC),
        border = BorderStroke(1.dp, tint.copy(alpha = 0.25f)),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = tint,
                modifier = Modifier.size(11.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = label,
                fontSize = 9.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )
        Text(
            text = value,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
