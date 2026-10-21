package com.example.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.UserProfile

private val funNicknames = listOf(
    "StarScholar",
    "MathNinja99",
    "CosmicSolver",
    "BrainyFox",
    "QuantumKid",
    "LogicAce",
    "AlphaThinker",
    "QuizVoyager",
    "SparkLearner",
    "AstroMind",
    "BookwormPro",
    "ApexCoder"
)

/**
 * Dialog allowing students to select an avatar from the pre-defined set of illustrations
 * and configure a custom nickname that is persisted to Firestore and local Room storage.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileDialog(
    userProfile: UserProfile,
    onDismissRequest: () -> Unit,
    onSaveProfile: (selectedAvatarId: String, nickname: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedAvatarId by remember { mutableStateOf(userProfile.avatar.ifBlank { "avatar_astro_explorer" }) }
    var nicknameInput by remember { mutableStateOf(userProfile.nickname.ifBlank { "StarScholar" }) }
    var nicknameError by remember { mutableStateOf<String?>(null) }

    val currentIllustration = remember(selectedAvatarId) {
        AvatarCatalog.getAvatarById(selectedAvatarId)
    }

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = modifier
                .fillMaxWidth(0.94f)
                .fillMaxHeight(0.92f)
                .clip(RoundedCornerShape(28.dp))
                .testTag("edit_profile_dialog"),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 6.dp,
            border = BorderStroke(1.5.dp, Color(currentIllustration.primaryColorHex).copy(alpha = 0.35f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Header with Close Action
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🎨", fontSize = 20.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Customize Profile",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.ExtraBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        Text(
                            text = "Choose an illustrated avatar & set your custom nickname",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    IconButton(
                        onClick = onDismissRequest,
                        modifier = Modifier.testTag("close_edit_profile_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close dialog",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Selected Avatar Preview & Nickname Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("selected_avatar_preview_card"),
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(currentIllustration.primaryColorHex).copy(alpha = 0.08f)
                    ),
                    border = BorderStroke(1.5.dp, Color(currentIllustration.primaryColorHex).copy(alpha = 0.45f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        StudentAvatarBadge(
                            avatar = currentIllustration,
                            size = 64.dp,
                            showRing = true
                        )

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = nicknameInput.ifBlank { "Choose Nickname" },
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(currentIllustration.secondaryEmoji, fontSize = 14.sp)
                            }
                            Text(
                                text = "${currentIllustration.name} • ${currentIllustration.title}",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(currentIllustration.primaryColorHex)
                            )
                            Text(
                                text = currentIllustration.description,
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }

                // Nickname Input & Generator Section
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Student Nickname",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )

                        TextButton(
                            onClick = {
                                val randomPick = funNicknames.filter { it != nicknameInput }.random()
                                nicknameInput = randomPick
                                nicknameError = null
                            },
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                            modifier = Modifier.testTag("random_nickname_button")
                        ) {
                            Icon(Icons.Default.Shuffle, contentDescription = null, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Randomize", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    OutlinedTextField(
                        value = nicknameInput,
                        onValueChange = {
                            if (it.length <= 20) {
                                nicknameInput = it
                                nicknameError = if (it.isBlank()) "Nickname cannot be empty" else null
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("nickname_input_field"),
                        placeholder = { Text("Enter a cool student nickname...") },
                        leadingIcon = {
                            Icon(Icons.Default.Badge, contentDescription = null, tint = Color(currentIllustration.primaryColorHex))
                        },
                        trailingIcon = {
                            Text(
                                text = "${nicknameInput.length}/20",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(end = 12.dp)
                            )
                        },
                        isError = nicknameError != null,
                        supportingText = {
                            if (nicknameError != null) {
                                Text(nicknameError!!, color = MaterialTheme.colorScheme.error)
                            } else {
                                Text("Displayed on leaderboards, battle arena, and study profiles", fontSize = 11.sp)
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp)
                    )
                }

                // Avatar Illustration Selection Grid
                Text(
                    text = "Select Avatar Illustration (${AvatarCatalog.allAvatars.size} available)",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .testTag("avatar_selection_grid"),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(AvatarCatalog.allAvatars, key = { it.id }) { avatar ->
                        val isSelected = avatar.id == selectedAvatarId
                        val avatarColor = Color(avatar.primaryColorHex)

                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(18.dp))
                                .clickable { selectedAvatarId = avatar.id }
                                .testTag("avatar_option_${avatar.id}"),
                            shape = RoundedCornerShape(18.dp),
                            color = if (isSelected) avatarColor.copy(alpha = 0.14f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                            border = BorderStroke(
                                if (isSelected) 2.dp else 1.dp,
                                if (isSelected) avatarColor else MaterialTheme.colorScheme.outlineVariant
                            )
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Box(contentAlignment = Alignment.TopEnd) {
                                    StudentAvatarBadge(
                                        avatar = avatar,
                                        size = 48.dp,
                                        showRing = isSelected
                                    )
                                    if (isSelected) {
                                        Box(
                                            modifier = Modifier
                                                .size(18.dp)
                                                .clip(CircleShape)
                                                .background(avatarColor),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Check,
                                                contentDescription = "Selected",
                                                tint = Color.White,
                                                modifier = Modifier.size(12.dp)
                                            )
                                        }
                                    }
                                }

                                Text(
                                    text = avatar.name,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Text(
                                    text = avatar.badgeLabel,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = avatarColor,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }

                // Cloud Firestore Persistence Notice
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFF4F46E5).copy(alpha = 0.08f),
                    border = BorderStroke(1.dp, Color(0xFF4F46E5).copy(alpha = 0.2f)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("☁️", fontSize = 13.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Persisted to Cloud Firestore with offline disk persistence",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF4F46E5)
                        )
                    }
                }

                // Bottom Action Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = onDismissRequest,
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .testTag("cancel_edit_profile_button"),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Cancel")
                    }

                    Button(
                        onClick = {
                            val finalNickname = nicknameInput.trim().ifBlank { userProfile.name }
                            onSaveProfile(selectedAvatarId, finalNickname)
                        },
                        enabled = nicknameInput.isNotBlank(),
                        modifier = Modifier
                            .weight(1.5f)
                            .height(48.dp)
                            .testTag("save_profile_button"),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(currentIllustration.primaryColorHex)
                        )
                    ) {
                        Icon(Icons.Default.CloudUpload, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Save to Firestore",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
    }
}
