package com.example

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.*
import com.example.localization.AppLanguage
import com.example.localization.AppStrings
import com.example.localization.LocaleManager
import com.example.ui.home.Translator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLooper

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class MultiLanguageSwitchingTest {

    private lateinit var context: Context
    private lateinit var db: QuizDatabase
    private lateinit var repository: QuizRepository
    private lateinit var viewModel: QuizViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() = runBlocking {
        Dispatchers.setMain(testDispatcher)
        context = ApplicationProvider.getApplicationContext<Application>()
        context.getSharedPreferences("quiz_app_user_data", Context.MODE_PRIVATE).edit().clear().apply()
        db = Room.inMemoryDatabaseBuilder(context, QuizDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        repository = QuizRepository(
            quizDao = db.quizDao(),
            quizQuestionDao = db.quizQuestionDao(),
            studentProgressDao = db.studentProgressDao(),
            historicalScoreDao = db.historicalScoreDao(),
            studentPointDao = db.studentPointDao()
        )

        // Seed a user profile
        db.quizDao().insertUserProfile(
            UserProfile(
                id = 1,
                name = "Test Student",
                standard = 6,
                coins = 100,
                stars = 10,
                xp = 500,
                totalPoints = 600,
                language = "English"
            )
        )

        viewModel = QuizViewModel(ApplicationProvider.getApplicationContext(), repository)
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
        db.close()
    }

    @Test
    fun testAppLanguageParsing() {
        // English variations
        assertEquals(AppLanguage.ENGLISH, AppLanguage.from("English"))
        assertEquals(AppLanguage.ENGLISH, AppLanguage.from("en"))
        assertEquals(AppLanguage.ENGLISH, AppLanguage.from("ENGLISH"))

        // Kannada variations
        assertEquals(AppLanguage.KANNADA, AppLanguage.from("Kannada"))
        assertEquals(AppLanguage.KANNADA, AppLanguage.from("kn"))
        assertEquals(AppLanguage.KANNADA, AppLanguage.from("ಕನ್ನಡ"))

        // Hindi variations
        assertEquals(AppLanguage.HINDI, AppLanguage.from("Hindi"))
        assertEquals(AppLanguage.HINDI, AppLanguage.from("hi"))
        assertEquals(AppLanguage.HINDI, AppLanguage.from("हिन्दी"))

        // Defaults to English on empty/null/unknown
        assertEquals(AppLanguage.ENGLISH, AppLanguage.from(null))
        assertEquals(AppLanguage.ENGLISH, AppLanguage.from(""))
        assertEquals(AppLanguage.ENGLISH, AppLanguage.from("unknown_code"))
    }

    @Test
    fun testAppStringsContentForEnglishKannadaAndHindi() {
        val enStrings = AppStrings.forLanguage(AppLanguage.ENGLISH)
        val knStrings = AppStrings.forLanguage(AppLanguage.KANNADA)
        val hiStrings = AppStrings.forLanguage(AppLanguage.HINDI)

        // App Name
        assertEquals("School Quiz", enStrings.appName)
        assertEquals("ಸ್ಕೂಲ್ ಕ್ವಿಜ್", knStrings.appName)
        assertEquals("स्कूल क्विज", hiStrings.appName)

        // Navigation
        assertEquals("Home", enStrings.navHome)
        assertEquals("ಮುಖಪುಟ", knStrings.navHome)
        assertEquals("मुख्य", hiStrings.navHome)

        assertEquals("Dashboard", enStrings.navDashboard)
        assertEquals("ವರದಿ ಪತ್ರಿಕೆ", knStrings.navDashboard)
        assertEquals("डैशबोर्ड", hiStrings.navDashboard)

        assertEquals("Rankings", enStrings.navRankings)
        assertEquals("ಶ್ರೇಯಾಂಕಗಳು", knStrings.navRankings)
        assertEquals("रैंकिंग", hiStrings.navRankings)

        assertEquals("Teacher Panel", enStrings.navAdmin)
        assertEquals("ಶಿಕ್ಷಕರ ಫಲಕ", knStrings.navAdmin)
        assertEquals("शिक्षक पैनल", hiStrings.navAdmin)

        // Profile labels
        assertEquals("Std", enStrings.std)
        assertEquals("ತರಗತಿ", knStrings.std)
        assertEquals("कक्षा", hiStrings.std)

        assertEquals("Coins", enStrings.coins)
        assertEquals("ನಾಣ್ಯಗಳು", knStrings.coins)
        assertEquals("सिक्के", hiStrings.coins)

        assertEquals("Stars", enStrings.stars)
        assertEquals("ನಕ್ಷತ್ರಗಳು", knStrings.stars)
        assertEquals("सितारे", hiStrings.stars)

        // Actions
        assertEquals("Play", enStrings.play)
        assertEquals("ಆಟವಾಡು", knStrings.play)
        assertEquals("खेलें", hiStrings.play)

        assertEquals("Questions", enStrings.questions)
        assertEquals("ಪ್ರಶ್ನೆಗಳು", knStrings.questions)
        assertEquals("प्रश्न", hiStrings.questions)
    }

    @Test
    fun testTranslatorDelegation() {
        assertEquals("ಮುಖಪುಟ", Translator.translate("home", "Kannada"))
        assertEquals("ಮುಂದಿನ ಪ್ರಶ್ನೆ ➡️", Translator.translate("next_question", "Kannada"))
        assertEquals("ವರದಿ ಪತ್ರಿಕೆ", Translator.translate("dashboard", "Kannada"))

        assertEquals("मुख्य", Translator.translate("home", "Hindi"))
        assertEquals("अगला प्रश्न ➡️", Translator.translate("next_question", "Hindi"))
        assertEquals("डैशबोर्ड", Translator.translate("dashboard", "Hindi"))

        assertEquals("Home", Translator.translate("home", "English"))
        assertEquals("Next Question ➡️", Translator.translate("next_question", "English"))
        assertEquals("Dashboard", Translator.translate("dashboard", "English"))
    }

    @Test
    fun testViewModelLanguageSwitchingAndPersistence() = runBlocking {
        // Initial language English
        assertEquals("English", viewModel.currentLanguage.value)

        // Switch to Kannada via ViewModel
        viewModel.switchLanguage("Kannada")
        assertEquals("Kannada", viewModel.currentLanguage.value)

        // Directly persist and verify in repository
        repository.changeLanguage("Kannada")
        val profileAfterKn = repository.getUserProfileDirect()
        assertNotNull(profileAfterKn)
        assertEquals("Kannada", profileAfterKn?.language)

        // Switch to Hindi via ViewModel
        viewModel.switchLanguage("Hindi")
        assertEquals("Hindi", viewModel.currentLanguage.value)

        repository.changeLanguage("Hindi")
        val profileAfterHi = repository.getUserProfileDirect()
        assertNotNull(profileAfterHi)
        assertEquals("Hindi", profileAfterHi?.language)

        // Switch back to English
        viewModel.switchLanguage("English")
        assertEquals("English", viewModel.currentLanguage.value)
    }

    @Test
    fun testLocaleManagerUpdates() {
        LocaleManager.updateConfiguration(context, AppLanguage.KANNADA)
        val knContext = LocaleManager.applyLocale(context, AppLanguage.KANNADA)
        assertNotNull(knContext)

        LocaleManager.updateConfiguration(context, AppLanguage.HINDI)
        val hiContext = LocaleManager.applyLocale(context, AppLanguage.HINDI)
        assertNotNull(hiContext)

        LocaleManager.updateConfiguration(context, AppLanguage.ENGLISH)
        val enContext = LocaleManager.applyLocale(context, AppLanguage.ENGLISH)
        assertNotNull(enContext)
    }

    @Test
    fun testSettingsViewModelLanguageSwitching() {
        val settingsViewModel = SettingsViewModel(ApplicationProvider.getApplicationContext())
        settingsViewModel.setLanguage("Kannada")
        assertEquals("Kannada", settingsViewModel.currentLanguage.value)
        settingsViewModel.setLanguage("Hindi")
        assertEquals("Hindi", settingsViewModel.currentLanguage.value)
        settingsViewModel.setLanguage("English")
        assertEquals("English", settingsViewModel.currentLanguage.value)
    }

    @Test
    fun testNewAppStringsKeys() {
        val en = AppStrings.forLanguage(AppLanguage.ENGLISH)
        val kn = AppStrings.forLanguage(AppLanguage.KANNADA)
        val hi = AppStrings.forLanguage(AppLanguage.HINDI)

        assertEquals("Overview", en.overview)
        assertEquals("ಅವಲೋಕನ", kn.overview)
        assertEquals("अवलोकन", hi.overview)

        assertEquals("Badges", en.badges)
        assertEquals("ಬ್ಯಾಡ್ಜ್‌ಗಳು", kn.badges)
        assertEquals("बैज", hi.badges)

        assertEquals("Leaderboard Arena", en.leaderboardTitle)
        assertEquals("ಶ್ರೇಯಾಂಕಗಳ ಅಖಾಡ", kn.leaderboardTitle)
        assertEquals("लीडरबोर्ड अखाड़ा", hi.leaderboardTitle)
    }

    @Test
    fun testLanguageSettingsProviderCycleAndPersistence() {
        val provider = com.example.localization.CustomLanguageSettingsProvider(context, AppLanguage.ENGLISH)
        assertEquals(AppLanguage.ENGLISH, provider.currentLanguage.value)
        assertEquals("English", provider.currentLanguageName)
        assertEquals("en", provider.currentLanguageCode)

        // Toggle next: English -> Hindi
        val lang2 = provider.toggleNextLanguage()
        assertEquals(AppLanguage.HINDI, lang2)
        assertEquals(AppLanguage.HINDI, provider.currentLanguage.value)
        assertEquals("Hindi", provider.currentLanguageName)
        assertEquals("hi", provider.currentLanguageCode)

        // Toggle next: Hindi -> Kannada
        val lang3 = provider.toggleNextLanguage()
        assertEquals(AppLanguage.KANNADA, lang3)
        assertEquals(AppLanguage.KANNADA, provider.currentLanguage.value)
        assertEquals("Kannada", provider.currentLanguageName)
        assertEquals("kn", provider.currentLanguageCode)

        // Toggle next: Kannada -> English
        val lang4 = provider.toggleNextLanguage()
        assertEquals(AppLanguage.ENGLISH, lang4)
        assertEquals(AppLanguage.ENGLISH, provider.currentLanguage.value)

        // Explicit set
        provider.setLanguage("kn")
        assertEquals(AppLanguage.KANNADA, provider.currentLanguage.value)

        provider.setLanguage("हिन्दी")
        assertEquals(AppLanguage.HINDI, provider.currentLanguage.value)
    }

    @Test
    fun testLanguageSettingsProviderListener() {
        val provider = com.example.localization.CustomLanguageSettingsProvider(context, AppLanguage.ENGLISH)
        var notifiedLang: AppLanguage? = null
        val listener: (AppLanguage) -> Unit = { notifiedLang = it }
        provider.addOnLanguageChangeListener(listener)

        provider.setLanguage(AppLanguage.HINDI)
        assertEquals(AppLanguage.HINDI, notifiedLang)

        provider.toggleNextLanguage()
        assertEquals(AppLanguage.KANNADA, notifiedLang)

        provider.removeOnLanguageChangeListener(listener)
        provider.setLanguage(AppLanguage.ENGLISH)
        assertEquals(AppLanguage.KANNADA, notifiedLang)
    }
}
