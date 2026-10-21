package com.example

import com.example.data.UserProfile
import com.example.ui.dashboard.AvatarCatalog
import org.junit.Assert.*
import org.junit.Test

class StudentProfileAvatarTest {

    @Test
    fun testAvatarCatalogPredefinedIllustrations() {
        val avatars = AvatarCatalog.allAvatars
        assertTrue("Catalog should contain at least 8 predefined avatars", avatars.size >= 8)

        val astro = AvatarCatalog.getAvatarById("avatar_astro_explorer")
        assertEquals("Astro Nova", astro.name)
        assertEquals("🚀", astro.emoji)
        assertEquals("Cosmic Explorer", astro.title)

        val coding = AvatarCatalog.getAvatarById("avatar_coding_wizard")
        assertEquals("Byte Spark", coding.name)
        assertEquals("⚡", coding.emoji)

        val nature = AvatarCatalog.getAvatarById("avatar_nature_scholar")
        assertEquals("Leafy Sage", nature.name)
        assertEquals("🌿", nature.emoji)

        val math = AvatarCatalog.getAvatarById("avatar_math_whiz")
        assertEquals("Pi Dynamo", math.name)
        assertEquals("📐", math.emoji)
    }

    @Test
    fun testAvatarFallbackForUnknownId() {
        val fallback = AvatarCatalog.getAvatarById("non_existent_avatar_xyz")
        assertNotNull(fallback)
        assertEquals("avatar_astro_explorer", fallback.id)

        val nullFallback = AvatarCatalog.getAvatarById(null)
        assertNotNull(nullFallback)
        assertEquals("avatar_astro_explorer", nullFallback.id)
    }

    @Test
    fun testUserProfileNicknameAndAvatar() {
        val profile = UserProfile(
            name = "Suhas Govind",
            nickname = "QuantumKid",
            avatar = "avatar_coding_wizard"
        )

        assertEquals("Suhas Govind", profile.name)
        assertEquals("QuantumKid", profile.nickname)
        assertEquals("avatar_coding_wizard", profile.avatar)
    }
}
