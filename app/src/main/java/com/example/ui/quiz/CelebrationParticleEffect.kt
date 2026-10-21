package com.example.ui.quiz

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.isActive
import java.util.Random
import kotlin.math.cos
import kotlin.math.sin

/**
 * Types of celebration particles emitted during high-score celebration.
 */
enum class CelebrationParticleType {
    CONFETTI_RIBBON, // Rectangular fluttering confetti
    STAR_BURST,      // 5-pointed geometric star
    SPARKLE_DOT,     // Shimmering light orb
    GOLD_DISC        // Shiny coin/disc token
}

/**
 * Single dynamic particle state.
 */
private data class CelebrationParticle(
    val id: Int,
    var x: Float,
    var y: Float,
    var vx: Float,
    var vy: Float,
    val color: Color,
    val width: Float,
    val height: Float,
    val type: CelebrationParticleType,
    var rotation: Float,
    val rotationSpeed: Float,
    var tumble: Float = 0f,
    val tumbleSpeed: Float,
    val swaySeed: Float,
    val swayFrequency: Float,
    val maxLifeMillis: Float,
    var ageMillis: Float = 0f
) {
    val isAlive: Boolean get() = ageMillis < maxLifeMillis
    val alpha: Float get() {
        val remaining = 1f - (ageMillis / maxLifeMillis)
        return when {
            remaining < 0.25f -> (remaining / 0.25f).coerceIn(0f, 1f)
            ageMillis < 200f -> (ageMillis / 200f).coerceIn(0f, 1f)
            else -> 1f
        }
    }
}

/**
 * Canvas overlay that renders a particle celebration (confetti rain and starbursts).
 * Passes touch events through to underlying views so it never blocks buttons.
 */
@Composable
fun CelebrationParticleOverlay(
    triggerKey: Int,
    isHighScore: Boolean = true,
    isPerfectScore: Boolean = false,
    modifier: Modifier = Modifier
) {
    val particles = remember(triggerKey) { mutableStateListOf<CelebrationParticle>() }
    var canvasSize by remember { mutableStateOf(Size.Zero) }

    // Celebration colors palette (Vibrant M3 celebratory spectrum)
    val celebrationColors = remember {
        listOf(
            Color(0xFFFFD700), // Gold
            Color(0xFF6366F1), // Electric Indigo
            Color(0xFF10B981), // Emerald Green
            Color(0xFFF43F5E), // Coral Pink
            Color(0xFFF59E0B), // Vibrant Amber
            Color(0xFF06B6D4), // Sky Cyan
            Color(0xFF8B5CF6), // Royal Violet
            Color(0xFFEC4899), // Hot Pink
            Color(0xFF22C55E)  // Mint Green
        )
    }

    // Initialize particles when triggered and canvas dimensions are ready
    LaunchedEffect(triggerKey, canvasSize) {
        if (canvasSize.width <= 0 || canvasSize.height <= 0) return@LaunchedEffect

        particles.clear()
        val random = Random()
        val count = when {
            isPerfectScore -> 140
            isHighScore -> 95
            else -> 65
        }
        val width = canvasSize.width
        val height = canvasSize.height

        val newParticles = mutableListOf<CelebrationParticle>()

        // 1. Dual Cannon blasts (from left and right bottom corners firing upwards into the center)
        for (i in 0 until count) {
            val fromLeftCannon = i % 2 == 0
            val startX = if (fromLeftCannon) random.nextFloat() * (width * 0.2f)
            else width - (random.nextFloat() * (width * 0.2f))
            val startY = height * 0.7f + (random.nextFloat() * height * 0.2f)

            // Angle towards upper-center
            val baseAngleDeg = if (fromLeftCannon) -60f + (random.nextFloat() * 40f - 20f)
            else -120f + (random.nextFloat() * 40f - 20f)
            val angleRad = Math.toRadians(baseAngleDeg.toDouble()).toFloat()
            val speed = 900f + random.nextFloat() * 800f

            val type = when (random.nextInt(4)) {
                0 -> CelebrationParticleType.STAR_BURST
                1 -> CelebrationParticleType.SPARKLE_DOT
                2 -> CelebrationParticleType.GOLD_DISC
                else -> CelebrationParticleType.CONFETTI_RIBBON
            }

            val pSize = when (type) {
                CelebrationParticleType.STAR_BURST -> 16f + random.nextFloat() * 14f
                CelebrationParticleType.CONFETTI_RIBBON -> 12f + random.nextFloat() * 12f
                CelebrationParticleType.GOLD_DISC -> 14f + random.nextFloat() * 10f
                CelebrationParticleType.SPARKLE_DOT -> 8f + random.nextFloat() * 8f
            }

            newParticles.add(
                CelebrationParticle(
                    id = i,
                    x = startX,
                    y = startY,
                    vx = cos(angleRad) * speed,
                    vy = sin(angleRad) * speed,
                    color = celebrationColors[random.nextInt(celebrationColors.size)],
                    width = pSize,
                    height = if (type == CelebrationParticleType.CONFETTI_RIBBON) pSize * (1.6f + random.nextFloat() * 0.8f) else pSize,
                    type = type,
                    rotation = random.nextFloat() * 360f,
                    rotationSpeed = (random.nextFloat() * 360f - 180f) * 1.5f,
                    tumble = random.nextFloat() * 360f,
                    tumbleSpeed = (random.nextFloat() * 400f - 200f),
                    swaySeed = random.nextFloat() * 10f,
                    swayFrequency = 2f + random.nextFloat() * 3f,
                    maxLifeMillis = 4000f + random.nextFloat() * 1500f
                )
            )
        }

        // 2. Central Starburst explosion in upper third
        val starburstCount = if (isPerfectScore) 35 else 20
        val burstCenterX = width * 0.5f
        val burstCenterY = height * 0.35f

        for (j in 0 until starburstCount) {
            val burstAngle = random.nextFloat() * 2f * Math.PI.toFloat()
            val burstSpeed = 200f + random.nextFloat() * 600f
            val starColor = if (j % 2 == 0) Color(0xFFFFD700) else celebrationColors[random.nextInt(celebrationColors.size)]

            newParticles.add(
                CelebrationParticle(
                    id = 1000 + j,
                    x = burstCenterX + (random.nextFloat() * 40f - 20f),
                    y = burstCenterY + (random.nextFloat() * 40f - 20f),
                    vx = cos(burstAngle) * burstSpeed,
                    vy = sin(burstAngle) * burstSpeed - 150f, // initial upward kick
                    color = starColor,
                    width = 18f + random.nextFloat() * 12f,
                    height = 18f + random.nextFloat() * 12f,
                    type = CelebrationParticleType.STAR_BURST,
                    rotation = random.nextFloat() * 360f,
                    rotationSpeed = (random.nextFloat() * 300f - 150f),
                    tumble = 0f,
                    tumbleSpeed = 100f,
                    swaySeed = random.nextFloat() * 10f,
                    swayFrequency = 3f,
                    maxLifeMillis = 3500f + random.nextFloat() * 1200f
                )
            )
        }

        particles.addAll(newParticles)

        // Physics animation loop
        var lastTime = withFrameNanos { it }
        val gravity = 900f // pixels / sec^2

        while (isActive && particles.any { it.isAlive }) {
            val currentTime = withFrameNanos { it }
            val dt = ((currentTime - lastTime) / 1_000_000_000f).coerceIn(0f, 0.05f) // clamp delta
            val dtMillis = dt * 1000f
            lastTime = currentTime

            particles.forEach { p ->
                if (p.isAlive) {
                    p.ageMillis += dtMillis

                    // Kinematics: gravity and drag
                    p.vy += gravity * dt
                    p.vx *= (1f - 0.35f * dt) // air resistance

                    // Sway drift
                    val sway = sin(p.ageMillis / 1000f * p.swayFrequency + p.swaySeed) * 50f * dt
                    p.x += (p.vx * dt) + sway
                    p.y += (p.vy * dt)

                    // Rotations
                    p.rotation += p.rotationSpeed * dt
                    p.tumble += p.tumbleSpeed * dt
                }
            }
        }
    }

    // Render Canvas
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .testTag("celebration_particle_canvas")
    ) {
        if (canvasSize != size) {
            canvasSize = size
        }

        particles.forEach { p ->
            if (p.isAlive && p.alpha > 0.01f) {
                drawParticle(p)
            }
        }
    }
}

/**
 * Draws a single celebration particle onto the Canvas.
 */
private fun DrawScope.drawParticle(p: CelebrationParticle) {
    val alphaColor = p.color.copy(alpha = p.alpha)

    when (p.type) {
        CelebrationParticleType.CONFETTI_RIBBON -> {
            // Ribbon tumble effect: scale width based on cosine of tumble angle to simulate 3D rotation
            val tumbleScale = cos(Math.toRadians(p.tumble.toDouble())).toFloat()
            val effectiveWidth = (p.width * tumbleScale).coerceAtLeast(1.5f)

            rotate(degrees = p.rotation, pivot = Offset(p.x, p.y)) {
                drawRect(
                    color = alphaColor,
                    topLeft = Offset(p.x - effectiveWidth / 2f, p.y - p.height / 2f),
                    size = Size(effectiveWidth, p.height)
                )
            }
        }

        CelebrationParticleType.STAR_BURST -> {
            rotate(degrees = p.rotation, pivot = Offset(p.x, p.y)) {
                val starPath = createStarPath(
                    centerX = p.x,
                    centerY = p.y,
                    outerRadius = p.width / 2f,
                    innerRadius = p.width * 0.22f
                )
                drawPath(path = starPath, color = alphaColor)
            }
        }

        CelebrationParticleType.SPARKLE_DOT -> {
            // Pulsing sparkle dot
            val pulse = 0.8f + 0.2f * sin(p.ageMillis / 100f)
            drawCircle(
                color = alphaColor,
                radius = (p.width / 2f) * pulse,
                center = Offset(p.x, p.y)
            )
            // Outer subtle glow
            drawCircle(
                color = alphaColor.copy(alpha = (p.alpha * 0.35f)),
                radius = (p.width) * pulse,
                center = Offset(p.x, p.y)
            )
        }

        CelebrationParticleType.GOLD_DISC -> {
            val tumbleScale = cos(Math.toRadians(p.tumble.toDouble())).toFloat()
            val effectiveWidth = (p.width * tumbleScale).coerceAtLeast(2f)

            drawOval(
                color = alphaColor,
                topLeft = Offset(p.x - effectiveWidth / 2f, p.y - p.height / 2f),
                size = Size(effectiveWidth, p.height)
            )
        }
    }
}

/**
 * Creates a mathematical 5-pointed geometric star path for Canvas rendering.
 */
private fun createStarPath(
    centerX: Float,
    centerY: Float,
    outerRadius: Float,
    innerRadius: Float
): Path {
    val path = Path()
    val points = 5
    var angle = -Math.PI.toFloat() / 2f
    val step = Math.PI.toFloat() / points

    val startX = centerX + outerRadius * cos(angle)
    val startY = centerY + outerRadius * sin(angle)
    path.moveTo(startX, startY)

    for (i in 1 until points * 2) {
        angle += step
        val radius = if (i % 2 == 1) innerRadius else outerRadius
        val x = centerX + radius * cos(angle)
        val y = centerY + radius * sin(angle)
        path.lineTo(x, y)
    }
    path.close()
    return path
}

/**
 * High-score celebration headline banner with pulsating badge, glowing colors,
 * and an interactive "Celebrate Again" action button.
 */
@Composable
fun HighScoreCelebrationBanner(
    accuracy: Int,
    onTriggerCelebration: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (accuracy < 70) return

    val isPerfect = accuracy == 100
    val infiniteTransition = rememberInfiniteTransition(label = "celebration_pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.98f,
        targetValue = 1.02f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale_pulse"
    )

    val gradientColors = if (isPerfect) {
        listOf(Color(0xFFF59E0B), Color(0xFFD97706), Color(0xFF7C3AED))
    } else {
        listOf(Color(0xFF10B981), Color(0xFF059669), Color(0xFF4F46E5))
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .scale(scale)
            .testTag("high_score_celebration_banner"),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.horizontalGradient(gradientColors))
                .border(2.dp, Color(0xFFFFD700).copy(alpha = 0.6f), RoundedCornerShape(22.dp))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.2f))
                            .border(1.5.dp, Color.White, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (isPerfect) "👑" else "🎉",
                            fontSize = 26.sp
                        )
                    }

                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = if (isPerfect) "PERFECT SCORE! 100%" else "OUTSTANDING MASTERY!",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Badge(
                                containerColor = Color(0xFFFFD700),
                                contentColor = Color(0xFF78350F)
                            ) {
                                Text("HIGH SCORE", fontSize = 9.sp, fontWeight = FontWeight.Black)
                            }
                        }
                        Text(
                            text = if (isPerfect) "Flawless accuracy! All questions answered correctly."
                            else "Scored $accuracy%! You're mastering this chapter.",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }
                }

                // Interactive Celebration Button
                Surface(
                    onClick = onTriggerCelebration,
                    shape = RoundedCornerShape(12.dp),
                    color = Color.White.copy(alpha = 0.25f),
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.5f)),
                    modifier = Modifier.testTag("trigger_celebration_button")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "🎊", fontSize = 14.sp)
                        Text(
                            text = "Cheer!",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

/**
 * Celebratory banner shown on quiz results screen upon completion.
 * Triggers confetti animation and displays completion congratulations.
 */
@Composable
fun QuizCompletionCelebrationBanner(
    accuracy: Int,
    isHighScore: Boolean,
    isPerfect: Boolean,
    onTriggerCelebration: () -> Unit,
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "celebration_pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.98f,
        targetValue = 1.02f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale_pulse"
    )

    val gradientColors = when {
        isPerfect -> listOf(Color(0xFFF59E0B), Color(0xFFD97706), Color(0xFF7C3AED))
        isHighScore -> listOf(Color(0xFF10B981), Color(0xFF059669), Color(0xFF4F46E5))
        else -> listOf(Color(0xFF6366F1), Color(0xFF4F46E5), Color(0xFF3730A3))
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .scale(scale)
            .testTag("quiz_completion_celebration_banner"),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.horizontalGradient(gradientColors))
                .border(1.5.dp, if (isPerfect) Color(0xFFFFD700).copy(alpha = 0.8f) else Color.White.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.2f))
                            .border(1.dp, Color.White, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = when {
                                isPerfect -> "👑"
                                isHighScore -> "🎉"
                                else -> "✨"
                            },
                            fontSize = 20.sp
                        )
                    }

                    Column(modifier = Modifier.weight(1f, fill = false)) {
                        Text(
                            text = when {
                                isPerfect -> "PERFECT SCORE! 100%"
                                isHighScore -> "OUTSTANDING! $accuracy%"
                                else -> "QUIZ COMPLETED! $accuracy%"
                            },
                            fontSize = 12.5.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = when {
                                isPerfect -> "Flawless! All answers correct."
                                isHighScore -> "Great mastery of this chapter!"
                                else -> "Completed! Practice makes perfect."
                            },
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White.copy(alpha = 0.9f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.width(6.dp))

                // Interactive Confetti Button
                Surface(
                    onClick = onTriggerCelebration,
                    shape = RoundedCornerShape(10.dp),
                    color = Color.White.copy(alpha = 0.25f),
                    border = BorderStroke(1.dp, Color.White.copy(alpha = 0.5f)),
                    modifier = Modifier.testTag("trigger_celebration_button")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Text(text = "🎊", fontSize = 12.sp)
                        Text(
                            text = "Confetti",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

