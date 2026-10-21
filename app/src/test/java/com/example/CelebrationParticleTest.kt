package com.example

import com.example.ui.quiz.CelebrationParticleType
import org.junit.Assert.*
import org.junit.Test

class CelebrationParticleTest {

    @Test
    fun testHighScoreThresholds() {
        // High score triggers at 70% and above
        val score60 = (6.0 / 10.0 * 100).toInt()
        val score70 = (7.0 / 10.0 * 100).toInt()
        val score85 = (17.0 / 20.0 * 100).toInt()
        val score100 = (10.0 / 10.0 * 100).toInt()

        fun isHighScore(accuracy: Int) = accuracy >= 70
        fun isPerfectScore(accuracy: Int) = accuracy == 100

        assertFalse(isHighScore(score60))
        assertTrue(isHighScore(score70))
        assertTrue(isHighScore(score85))
        assertTrue(isHighScore(score100))

        assertFalse(isPerfectScore(score85))
        assertTrue(isPerfectScore(score100))
    }

    @Test
    fun testCelebrationParticleTypes() {
        // Verify all 4 particle types exist
        val types = CelebrationParticleType.entries
        assertEquals(4, types.size)
        assertTrue(types.contains(CelebrationParticleType.CONFETTI_RIBBON))
        assertTrue(types.contains(CelebrationParticleType.STAR_BURST))
        assertTrue(types.contains(CelebrationParticleType.SPARKLE_DOT))
        assertTrue(types.contains(CelebrationParticleType.GOLD_DISC))
    }
}
