package com.example.localization

import androidx.compose.runtime.compositionLocalOf

/**
 * Type-safe, centralized application strings for all supported languages.
 */
data class AppStrings(
    val language: AppLanguage,
    // Top Bar & App Identity
    val appName: String,
    val topTitle: String,
    val alerts: String,
    val settings: String,
    val studyTimer: String,
    val bookmarksVault: String,
    val battleArena: String,
    val firebaseAccount: String,

    // Navigation Bar
    val navHome: String,
    val navDashboard: String,
    val navBattle: String,
    val navRankings: String,
    val navAdmin: String,

    // Student Profile & Badges
    val profileTitle: String,
    val coins: String,
    val stars: String,
    val xp: String,
    val totalPoints: String,
    val streak: String,
    val std: String,
    val level: String,
    val changeLanguage: String,

    // Daily Attendance Reward
    val dailyReward: String,
    val dailyRewardDesc: String,
    val claimReward: String,
    val rewardClaimed: String,

    // Home & Catalog Search
    val searchHint: String,
    val classSelect: String,
    val subjects: String,
    val chapters: String,
    val unit: String,
    val questions: String,
    val play: String,
    val startQuiz: String,
    val progress: String,

    // Difficulty Levels
    val difficulty: String,
    val easy: String,
    val medium: String,
    val hard: String,

    // Quiz Play Engine
    val question: String,
    val ofTotal: String,
    val timeRemaining: String,
    val speedBonus: String,
    val timePenalty: String,
    val submitAnswer: String,
    val nextQuestion: String,
    val finishQuiz: String,
    val exitQuiz: String,
    val markForReview: String,
    val explanation: String,
    val correctNotice: String,
    val incorrectNotice: String,
    val autoAdvanceNext: String,
    val autoAdvanceFinish: String,
    val timedOut: String,
    val score: String,
    val accuracy: String,
    val questionsReview: String,

    // Flashcard & Study Modes
    val flashcards: String,
    val tapToFlip: String,
    val mastered: String,
    val needsReview: String,
    val completeDeck: String,
    val restartDeck: String,

    // Settings Modal
    val settingsTitle: String,
    val appearanceSection: String,
    val appearanceDesc: String,
    val lightMode: String,
    val darkMode: String,
    val systemMode: String,
    val soundEffects: String,
    val soundEffectsDesc: String,
    val hapticVibration: String,
    val hapticVibrationDesc: String,
    val dailyReminder: String,
    val dailyReminderDesc: String,
    val languageSection: String,
    val languageDesc: String,
    val chooseLanguage: String,

    // Common UI actions
    val close: String,
    val done: String,
    val cancel: String,
    val confirm: String,
    val save: String,
    val delete: String,
    val filterAll: String,
    val overview: String = "Overview",
    val badges: String = "Badges",
    val savedQuestions: String = "Saved Questions",
    val leaderboardTitle: String = "Leaderboard Arena",
    val leaderboardSubtitle: String = "Compete with classmates & rise to the top!",
    val weeklyLeaders: String = "Weekly Leaders",
    val allTimeLegends: String = "All-Time Legends",
    val dailyChallenge: String = "Daily Quest Challenge",
    val dailyChallengeDesc: String = "5 quick questions • +100 XP & +30 Coins",
    val startQuest: String = "Start Quest",
    val skipQuestion: String = "Skip Question",
    val noAlerts: String = "No active bulletins."
) {
    companion object {
        val English = AppStrings(
            language = AppLanguage.ENGLISH,
            appName = "School Quiz",
            topTitle = "School Quiz",
            alerts = "Alerts & Notifications",
            settings = "Application Settings",
            studyTimer = "Study Focus Timer",
            bookmarksVault = "Saved Bookmarks",
            battleArena = "1vs1 Battle Arena",
            firebaseAccount = "Account & Cloud Sync",

            navHome = "Home",
            navDashboard = "Dashboard",
            navBattle = "1vs1 Duel",
            navRankings = "Rankings",
            navAdmin = "Teacher Panel",

            profileTitle = "Student Profile",
            coins = "Coins",
            stars = "Stars",
            xp = "XP",
            totalPoints = "Total Points",
            streak = "Attendance Streak",
            std = "Std",
            level = "Level",
            changeLanguage = "Language",

            dailyReward = "Daily Attendance Reward",
            dailyRewardDesc = "Claim free bonus coins for studying every day!",
            claimReward = "Claim Bonus",
            rewardClaimed = "Claimed Today",

            searchHint = "Search by Subject, Unit or Chapter...",
            classSelect = "Select Standard / Class",
            subjects = "Subjects",
            chapters = "Chapters",
            unit = "Unit",
            questions = "Questions",
            play = "Play",
            startQuiz = "Start Quiz",
            progress = "Progress",

            difficulty = "Difficulty",
            easy = "Easy",
            medium = "Medium",
            hard = "Hard",

            question = "Question",
            ofTotal = "of",
            timeRemaining = "Time Remaining",
            speedBonus = "Speed Bonus",
            timePenalty = "Time Penalty",
            submitAnswer = "Submit Answer",
            nextQuestion = "Next Question ➡️",
            finishQuiz = "Finish Quiz 📊",
            exitQuiz = "Exit Quiz",
            markForReview = "Mark for Review",
            explanation = "Explanation",
            correctNotice = "Correct!",
            incorrectNotice = "Incorrect",
            autoAdvanceNext = "Correct! Moving to Next Question ➡️",
            autoAdvanceFinish = "Correct! Moving to Results... 🎉",
            timedOut = "Time Up!",
            score = "Score",
            accuracy = "Accuracy",
            questionsReview = "Question Breakdown",

            flashcards = "Flashcard Revision",
            tapToFlip = "Tap card to flip definition 🔄",
            mastered = "Mastered",
            needsReview = "Needs Review",
            completeDeck = "Deck Completed!",
            restartDeck = "Restart Deck",

            settingsTitle = "Application Settings",
            appearanceSection = "Appearance Theme (ThemeManager)",
            appearanceDesc = "Controls the global light and dark theme mode across all screens and components.",
            lightMode = "☀️ Light Mode",
            darkMode = "🌙 Dark Mode",
            systemMode = "⚙️ System Default",
            soundEffects = "Sound Effects",
            soundEffectsDesc = "Audio cues for answers & completions",
            hapticVibration = "Haptic Vibration",
            hapticVibrationDesc = "Vibrate on quiz responses",
            dailyReminder = "Daily Study Reminder",
            dailyReminderDesc = "Receive daily notification to practice quizzes",
            languageSection = "Language / ಭಾಷೆ / भाषा",
            languageDesc = "Switch the application strings between English, Kannada, and Hindi.",
            chooseLanguage = "Choose Quiz Language",

            close = "Close",
            done = "Done",
            cancel = "Cancel",
            confirm = "Confirm",
            save = "Save",
            delete = "Delete",
            filterAll = "All",
            overview = "Overview",
            badges = "Badges",
            savedQuestions = "Saved Questions",
            leaderboardTitle = "Leaderboard Arena",
            leaderboardSubtitle = "Compete with classmates & rise to the top!",
            weeklyLeaders = "Weekly Leaders",
            allTimeLegends = "All-Time Legends",
            dailyChallenge = "Daily Quest Challenge",
            dailyChallengeDesc = "5 quick questions • +100 XP & +30 Coins",
            startQuest = "Start Quest",
            skipQuestion = "Skip Question",
            noAlerts = "No active bulletins."
        )

        val Kannada = AppStrings(
            language = AppLanguage.KANNADA,
            appName = "ಸ್ಕೂಲ್ ಕ್ವಿಜ್",
            topTitle = "ಸ್ಕೂಲ್ ಕ್ವಿಜ್",
            alerts = "ಅಧಿಸೂಚನೆಗಳು",
            settings = "ಅಪ್ಲಿಕೇಶನ್ ಸೆಟ್ಟಿಂಗ್‌ಗಳು",
            studyTimer = "ಅಧ್ಯಯನ ಏಕಾಗ್ರತೆ ಟೈಮರ್",
            bookmarksVault = "ಉಳಿಸಿದ ಬುಕ್‌ಮಾರ್ಕ್‌ಗಳು",
            battleArena = "೧vs೧ ದ್ವಂದ್ವ ಕಾಳಗ",
            firebaseAccount = "ಖಾತೆ & ಕ್ಲೌಡ್ ಸಿಂಕ್",

            navHome = "ಮುಖಪುಟ",
            navDashboard = "ವರದಿ ಪತ್ರಿಕೆ",
            navBattle = "ದ್ವಂದ್ವ ಕಾಳಗ",
            navRankings = "ಶ್ರೇಯಾಂಕಗಳು",
            navAdmin = "ಶಿಕ್ಷಕರ ಫಲಕ",

            profileTitle = "ವಿದ್ಯಾರ್ಥಿ ಪ್ರೊಫೈಲ್",
            coins = "ನಾಣ್ಯಗಳು",
            stars = "ನಕ್ಷತ್ರಗಳು",
            xp = "ಎಕ್ಸ್‌ಪಿ",
            totalPoints = "ಒಟ್ಟು ಅಂಕಗಳು",
            streak = "ಹಾಜರಾತಿ ದಿನಗಳು",
            std = "ತರಗತಿ",
            level = "ಹಂತ",
            changeLanguage = "ಭಾಷೆ",

            dailyReward = "ದೈನಂದಿನ ಹಾಜರಾತಿ ಉಡುಗೊರೆ",
            dailyRewardDesc = "ಪ್ರತಿದಿನ ಅಧ್ಯಯನ ಮಾಡಿ ಉಚಿತ ಬೋನಸ್ ನಾಣ್ಯಗಳನ್ನು ಪಡೆಯಿರಿ!",
            claimReward = "ಪಡೆಯಿರಿ",
            rewardClaimed = "ಇಂದು ಪಡೆಯಲಾಗಿದೆ",

            searchHint = "ವಿಷಯ, ಘಟಕ ಅಥವಾ ಅಧ್ಯಾಯ ಹುಡುಕಿ...",
            classSelect = "ತರಗತಿ ಆಯ್ಕೆಮಾಡಿ",
            subjects = "ವಿಷಯಗಳು",
            chapters = "ಅಧ್ಯಾಯಗಳು",
            unit = "ಘಟಕ",
            questions = "ಪ್ರಶ್ನೆಗಳು",
            play = "ಆಟವಾಡು",
            startQuiz = "ಕ್ವಿಜ್ ಪ್ರಾರಂಭಿಸಿ",
            progress = "ಪ್ರಗತಿ",

            difficulty = "ಮಟ್ಟ",
            easy = "ಸುಲಭ",
            medium = "ಮಧ್ಯಮ",
            hard = "ಕಷ್ಟ",

            question = "ಪ್ರಶ್ನೆ",
            ofTotal = "/",
            timeRemaining = "ಉಳಿದ ಸಮಯ",
            speedBonus = "ವೇಗದ ಬೋನಸ್",
            timePenalty = "ಸಮಯ ದಂಡ",
            submitAnswer = "ಉತ್ತರ ಸಲ್ಲಿಸಿ",
            nextQuestion = "ಮುಂದಿನ ಪ್ರಶ್ನೆ ➡️",
            finishQuiz = "ಕ್ವಿಜ್ ಮುಕ್ತಾಯಗೊಳಿಸಿ 📊",
            exitQuiz = "ಕ್ವಿಜ್‌ನಿಂದ ನಿರ್ಗಮಿಸಿ",
            markForReview = "ಪುನರ್ಪರಿಶೀಲನೆಗೆ ಗುರುತಿಸಿ",
            explanation = "ವಿವರಣೆ",
            correctNotice = "ಸರಿಯಾಗಿದೆ!",
            incorrectNotice = "ತಪ್ಪಾಗಿದೆ",
            autoAdvanceNext = "ಸರಿಯಾಗಿದೆ! ಮುಂದಿನ ಪ್ರಶ್ನೆಗೆ ಚಲಿಸಲಾಗುತ್ತಿದೆ ➡️",
            autoAdvanceFinish = "ಸರಿಯಾಗಿದೆ! ಫಲಿತಾಂಶಗಳಿಗೆ ಚಲಿಸಲಾಗುತ್ತಿದೆ... 🎉",
            timedOut = "ಸಮಯ ಮುಗಿದಿದೆ!",
            score = "ಅಂಕಗಳು",
            accuracy = "ನಿಖರತೆ",
            questionsReview = "ಪ್ರಶ್ನೆಗಳ ವಿಶ್ಲೇಷಣೆ",

            flashcards = "ಫ್ಲ್ಯಾಶ್‌ಕಾರ್ಡ್ ಪುನರಾವರ್ತನೆ",
            tapToFlip = "ವಿವರಣೆ ನೋಡಲು ಕಾರ್ಡ್ ಟ್ಯಾಪ್ ಮಾಡಿ 🔄",
            mastered = "ಕಲಿತಿದ್ದೇನೆ",
            needsReview = "ಪುನರಾವರ್ತನೆ ಬೇಕು",
            completeDeck = "ಎಲ್ಲಾ ಕಾರ್ಡ್‌ಗಳು ಮುಗಿದಿವೆ!",
            restartDeck = "ಮತ್ತೆ ಪ್ರಾರಂಭಿಸಿ",

            settingsTitle = "ಅಪ್ಲಿಕೇಶನ್ ಸೆಟ್ಟಿಂಗ್‌ಗಳು",
            appearanceSection = "ಥೀಮ್ ಮೋಡ್ (ThemeManager)",
            appearanceDesc = "ಬೆಳಕು ಮತ್ತು ಡಾರ್ಕ್ ಮೋಡ್ ನಿಯಂತ್ರಣ.",
            lightMode = "☀️ ಬೆಳಕಿನ ಮೋಡ್",
            darkMode = "🌙 ಡಾರ್ಕ್ ಮೋಡ್",
            systemMode = "⚙️ ಸಿಸ್ಟಮ್ ಡೀಫಾಲ್ಟ್",
            soundEffects = "ಧ್ವನಿ ಪರಿಣಾಮಗಳು",
            soundEffectsDesc = "ಉತ್ತರಗಳಿಗೆ ಆಡಿಯೋ ಪರಿಣಾಮಗಳು",
            hapticVibration = "ಕಂಪನ",
            hapticVibrationDesc = "ಪ್ರತಿಕ್ರಿಯೆಗಾಗಿ ಕಂಪನ",
            dailyReminder = "ದೈನಂದಿನ ಅಧ್ಯಯನ ಜ್ಞಾಪನೆ",
            dailyReminderDesc = "ಕ್ವಿಜ್ ಅಭ್ಯಾಸ ಮಾಡಲು ದಿನಂಪ್ರತಿ ನೆನಪಿಸುವ ಸೂಚನೆ",
            languageSection = "ಭಾಷೆ / Language / भाषा",
            languageDesc = "ಅಪ್ಲಿಕೇಶನ್ ಭಾಷೆಯನ್ನು ಇಂಗ್ಲಿಷ್, ಕನ್ನಡ ಅಥವಾ ಹಿಂದಿಗೆ ಬದಲಾಯಿಸಿ.",
            chooseLanguage = "ಕ್ವಿಜ್ ಭಾಷೆಯನ್ನು ಆಯ್ಕೆಮಾಡಿ",

            close = "ಮುಚ್ಚು",
            done = "ಮುಗಿದಿದೆ",
            cancel = "ರದ್ದುಮಾಡಿ",
            confirm = "ದೃಢೀಕರಿಸಿ",
            save = "ಉಳಿಸಿ",
            delete = "ಅಳಿಸಿ",
            filterAll = "ಎಲ್ಲಾ",
            overview = "ಅವಲೋಕನ",
            badges = "ಬ್ಯಾಡ್ಜ್‌ಗಳು",
            savedQuestions = "ಉಳಿಸಿದ ಪ್ರಶ್ನೆಗಳು",
            leaderboardTitle = "ಶ್ರೇಯಾಂಕಗಳ ಅಖಾಡ",
            leaderboardSubtitle = "ಸಹಪಾಠಿಗಳೊಂದಿಗೆ ಸ್ಪರ್ಧಿಸಿ ಮತ್ತು ಉನ್ನತ ಸ್ಥಾನಕ್ಕೇರಿ!",
            weeklyLeaders = "ವಾರದ ಮುಂಚೂಣಿ",
            allTimeLegends = "ಸಾರ್ವಕಾಲಿಕ ವಿಜೇತರು",
            dailyChallenge = "ದೈನಂದಿನ ಸವಾಲು",
            dailyChallengeDesc = "೫ ಕ್ಷಿಪ್ರ ಪ್ರಶ್ನೆಗಳು • +೧೦೦ XP & +೩೦ ನಾಣ್ಯಗಳು",
            startQuest = "ಪ್ರಾರಂಭಿಸಿ",
            skipQuestion = "ಪ್ರಶ್ನೆ ಬಿಟ್ಟುಬಿಡಿ",
            noAlerts = "ಯಾವುದೇ ಅಧಿಸೂಚನೆಗಳಿಲ್ಲ."
        )

        val Hindi = AppStrings(
            language = AppLanguage.HINDI,
            appName = "स्कूल क्विज",
            topTitle = "स्कूल क्विज",
            alerts = "सूचनाएं",
            settings = "एप्लिकेशन सेटिंग्स",
            studyTimer = "अध्ययन फोकस टाइमर",
            bookmarksVault = "सहेजे गए बुकमार्क",
            battleArena = "1vs1 मुकाबला",
            firebaseAccount = "खाता और क्लाउड सिंक",

            navHome = "मुख्य",
            navDashboard = "डैशबोर्ड",
            navBattle = "1vs1 मुकाबला",
            navRankings = "रैंकिंग",
            navAdmin = "शिक्षक पैनल",

            profileTitle = "छात्र प्रोफ़ाइल",
            coins = "सिक्के",
            stars = "सितारे",
            xp = "एक्सपी",
            totalPoints = "कुल अंक",
            streak = "उपस्थिति",
            std = "कक्षा",
            level = "स्तर",
            changeLanguage = "भाषा",

            dailyReward = "दैनिक उपस्थिति इनाम",
            dailyRewardDesc = "रोजाना अभ्यास करके मुफ्त बोनस सिक्के पाएँ!",
            claimReward = "प्राप्त करें",
            rewardClaimed = "आज प्राप्त किया",

            searchHint = "विषय, इकाई या अध्याय खोजें...",
            classSelect = "कक्षा चुनें",
            subjects = "विषय",
            chapters = "अध्याय",
            unit = "इकाई",
            questions = "प्रश्न",
            play = "खेलें",
            startQuiz = "क्विज शुरू करें",
            progress = "प्रगति",

            difficulty = "कठिनाई",
            easy = "आसान",
            medium = "मध्यम",
            hard = "कठिन",

            question = "प्रश्न",
            ofTotal = "/",
            timeRemaining = "शेष समय",
            speedBonus = "स्पीड बोनस",
            timePenalty = "समय कटौती",
            submitAnswer = "उत्तर जमा करें",
            nextQuestion = "अगला प्रश्न ➡️",
            finishQuiz = "क्विज समाप्त करें 📊",
            exitQuiz = "क्विज से बाहर निकलें",
            markForReview = "समीक्षा के लिए चिह्नित करें",
            explanation = "स्पष्टीकरण",
            correctNotice = "सही उत्तर!",
            incorrectNotice = "गलत उत्तर",
            autoAdvanceNext = "सही उत्तर! अगले प्रश्न पर जा रहे हैं ➡️",
            autoAdvanceFinish = "सही उत्तर! परिणाम देख रहे हैं... 🎉",
            timedOut = "समय समाप्त!",
            score = "अंक",
            accuracy = "सटीकता",
            questionsReview = "प्रश्नों का विवरण",

            flashcards = "फ्लैशकार्ड पुनरावृत्ति",
            tapToFlip = "परिभाषा देखने के लिए कार्ड पर टैप करें 🔄",
            mastered = "याद हो गया",
            needsReview = "समीक्षा चाहिए",
            completeDeck = "सभी कार्ड समाप्त हुए!",
            restartDeck = "पुनः प्रारंभ करें",

            settingsTitle = "एप्लिकेशन सेटिंग्स",
            appearanceSection = "थीम मोड (ThemeManager)",
            appearanceDesc = "लाइट और डार्क मोड सेटिंग।",
            lightMode = "☀️ लाइट मोड",
            darkMode = "🌙 डार्क मोड",
            systemMode = "⚙️ सिस्टम डिफ़ॉल्ट",
            soundEffects = "ध्वनि प्रभाव",
            soundEffectsDesc = "उत्तरों के लिए ऑडियो संकेत",
            hapticVibration = "कंपन",
            hapticVibrationDesc = "प्रतिक्रिया के लिए कंपन",
            dailyReminder = "दैनिक अध्ययन अनुस्मारक",
            dailyReminderDesc = "क्विज अभ्यास के लिए दैनिक सूचना",
            languageSection = "भाषा / Language / ಭಾಷೆ",
            languageDesc = "एप्लिकेशन की भाषा अंग्रेजी, कन्नड़ या हिंदी में बदलें।",
            chooseLanguage = "क्विज भाषा चुनें",

            close = "बंद करें",
            done = "पूर्ण",
            cancel = "रद्द करें",
            confirm = "पुष्टि करें",
            save = "सहेजें",
            delete = "हटाएं",
            filterAll = "सभी",
            overview = "अवलोकन",
            badges = "बैज",
            savedQuestions = "सहेजे गए प्रश्न",
            leaderboardTitle = "लीडरबोर्ड अखाड़ा",
            leaderboardSubtitle = "सहपाठियों के साथ मुकाबला करें और शीर्ष पर पहुंचें!",
            weeklyLeaders = "साप्ताहिक लीडर्स",
            allTimeLegends = "सर्वकालिक लीजेंड्स",
            dailyChallenge = "दैनिक प्रश्नोत्तरी चुनौती",
            dailyChallengeDesc = "5 त्वरित प्रश्न • +100 XP और +30 सिक्के",
            startQuest = "शुरू करें",
            skipQuestion = "प्रश्न छोड़ें",
            noAlerts = "कोई सक्रिय सूचना नहीं है।"
        )

        fun forLanguage(language: AppLanguage): AppStrings {
            return when (language) {
                AppLanguage.ENGLISH -> English
                AppLanguage.KANNADA -> Kannada
                AppLanguage.HINDI -> Hindi
            }
        }

        fun forLanguage(langNameOrCode: String?): AppStrings {
            return forLanguage(AppLanguage.from(langNameOrCode))
        }

        /**
         * Key-based lookup supporting existing Translator usages.
         */
        fun get(key: String, lang: String?): String {
            val s = forLanguage(lang)
            return when (key.lowercase().trim()) {
                "app_name" -> s.appName
                "home" -> s.navHome
                "dashboard" -> s.navDashboard
                "admin" -> s.navAdmin
                "battle", "1vs1", "duel" -> s.navBattle
                "rankings", "leaderboard" -> s.navRankings
                "profile" -> s.profileTitle
                "coins" -> s.coins
                "stars" -> s.stars
                "xp" -> s.xp
                "points", "total_points" -> s.totalPoints
                "streak" -> s.streak
                "std", "class" -> s.std
                "level" -> s.level
                "language" -> s.changeLanguage
                "daily_reward" -> s.dailyReward
                "claim" -> s.claimReward
                "claim_bonus" -> s.claimReward
                "claimed" -> s.rewardClaimed
                "search_hint" -> s.searchHint
                "class_select" -> s.classSelect
                "subjects" -> s.subjects
                "chapters" -> s.chapters
                "unit" -> s.unit
                "questions" -> s.questions
                "play" -> s.play
                "start_quiz" -> s.startQuiz
                "progress" -> s.progress
                "difficulty" -> s.difficulty
                "easy" -> s.easy
                "medium" -> s.medium
                "hard" -> s.hard
                "settings" -> s.settingsTitle
                "next_question" -> s.nextQuestion
                "finish_quiz" -> s.finishQuiz
                "correct" -> s.correctNotice
                "incorrect" -> s.incorrectNotice
                "explanation" -> s.explanation
                "flashcards" -> s.flashcards
                "alerts" -> s.alerts
                "close" -> s.close
                "done" -> s.done
                "cancel" -> s.cancel
                "confirm" -> s.confirm
                "overview" -> s.overview
                "badges" -> s.badges
                "saved_questions", "savedquestions", "saved_bookmarks" -> s.savedQuestions
                "leaderboard", "leaderboard_title" -> s.leaderboardTitle
                "leaderboard_sub", "leaderboard_subtitle" -> s.leaderboardSubtitle
                "weekly_leaders", "weekly" -> s.weeklyLeaders
                "all_time_legends", "alltime" -> s.allTimeLegends
                "daily_challenge", "daily_quest" -> s.dailyChallenge
                "daily_challenge_desc" -> s.dailyChallengeDesc
                "start_quest" -> s.startQuest
                "skip", "skip_question" -> s.skipQuestion
                "no_alerts", "no_bulletins" -> s.noAlerts
                "daily_reward_desc" -> s.dailyRewardDesc
                else -> key
            }
        }
    }
}

val LocalAppStrings = compositionLocalOf { AppStrings.English }
