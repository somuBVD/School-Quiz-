package com.example

import com.example.data.StudentLevelSystem
import org.junit.Assert.*
import org.junit.Test

class StudentLevelSystemTest {

    @Test
    fun testLevel1ForZeroXp() {
        val levelInfo = StudentLevelSystem.calculateLevel(0)
        assertEquals(1, levelInfo.level)
        assertEquals("Curious Beginner", levelInfo.title)
        assertEquals("🌱", levelInfo.badgeEmoji)
        assertEquals(0, levelInfo.currentLevelMinXp)
        assertEquals(200, levelInfo.nextLevelMinXp)
        assertEquals(200, levelInfo.xpRequiredForNextLevel)
        assertEquals(0f, levelInfo.progressFraction, 0.001f)
    }

    @Test
    fun testLevelProgressionAtThresholds() {
        // Level 2 begins at 200 XP
        val lvl2 = StudentLevelSystem.calculateLevel(200)
        assertEquals(2, lvl2.level)
        assertEquals("Apprentice Scholar", lvl2.title)
        assertEquals(0f, lvl2.progressFraction, 0.001f)

        // Mid-Level 2: 350 XP (150 / 300) = 50%
        val midLvl2 = StudentLevelSystem.calculateLevel(350)
        assertEquals(2, midLvl2.level)
        assertEquals(150, midLvl2.xpInCurrentLevel)
        assertEquals(150, midLvl2.xpRequiredForNextLevel)
        assertEquals(0.5f, midLvl2.progressFraction, 0.01f)

        // Level 3 begins at 500 XP
        val lvl3 = StudentLevelSystem.calculateLevel(500)
        assertEquals(3, lvl3.level)
        assertEquals("Rising Thinker", lvl3.title)

        // Level 4 at 900 XP
        val lvl4 = StudentLevelSystem.calculateLevel(900)
        assertEquals(4, lvl4.level)
        assertEquals("Mastermind", lvl4.title)

        // Level 5 at 1400 XP
        val lvl5 = StudentLevelSystem.calculateLevel(1400)
        assertEquals(5, lvl5.level)
        assertEquals("Quiz Champion", lvl5.title)
    }

    @Test
    fun testMaxLevelBehavior() {
        // Level 10 at 6000+ XP
        val lvl10 = StudentLevelSystem.calculateLevel(7500)
        assertEquals(10, lvl10.level)
        assertEquals("Supreme Grandmaster", lvl10.title)
        assertEquals(1.0f, lvl10.progressFraction, 0.001f)
        assertNull(lvl10.nextUnlockTitle)
    }

    @Test
    fun testXpConstantPerCorrectAnswer() {
        assertEquals(25, StudentLevelSystem.XP_PER_CORRECT_ANSWER)
        // 8 correct answers = 200 XP -> advances from Level 1 to Level 2!
        val xpEarned = 8 * StudentLevelSystem.XP_PER_CORRECT_ANSWER
        val level = StudentLevelSystem.calculateLevel(xpEarned)
        assertEquals(2, level.level)
    }
}
