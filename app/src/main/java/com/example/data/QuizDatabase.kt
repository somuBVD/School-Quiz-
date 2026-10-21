package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        UserProfile::class,
        UnitProgress::class,
        CustomQuestion::class,
        LeaderboardUser::class,
        NotificationEntity::class,
        AdvertisementEntity::class,
        BookmarkedQuestionEntity::class,
        QuizQuestionEntity::class,
        HistoricalScoreEntity::class,
        StudentPointEntity::class,
        DownloadedQuizEntity::class
    ],
    version = 7,
    exportSchema = false
)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun quizDao(): QuizDao
    abstract fun quizQuestionDao(): QuizQuestionDao
    abstract fun downloadedQuizDao(): DownloadedQuizDao
    abstract fun studentProgressDao(): StudentProgressDao
    abstract fun historicalScoreDao(): HistoricalScoreDao
    abstract fun studentPointDao(): StudentPointDao

    companion object {
        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): QuizDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuizDatabase::class.java,
                    "school_quiz_database"
                )
                .fallbackToDestructiveMigration(dropAllTables = true)
                .addCallback(QuizDatabaseCallback(scope))
                .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class QuizDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(
                        dao = database.quizDao(),
                        questionDao = database.quizQuestionDao(),
                        pointDao = database.studentPointDao()
                    )
                }
            }
        }

        suspend fun populateDatabase(
            dao: QuizDao,
            questionDao: QuizQuestionDao? = null,
            pointDao: StudentPointDao? = null
        ) {
            // 1. Initial User Profile
            dao.insertUserProfile(
                UserProfile(
                    id = 1,
                    name = "Suhas Govind",
                    nickname = "StarScholar",
                    standard = 6,
                    coins = 240,
                    stars = 42,
                    xp = 1250,
                    totalPoints = 1850,
                    avatar = "avatar_astro_explorer",
                    attendanceStreak = 5,
                    lastClaimedTimestamp = System.currentTimeMillis() - 86400000, // Claimed yesterday
                    language = "English"
                )
            )

            // Initial point records in Room
            pointDao?.let { pDao ->
                val initialPoints = listOf(
                    StudentPointEntity(
                        points = 100,
                        source = "CORRECT_ANSWER",
                        stdId = 6,
                        subjectId = "math",
                        unitId = 1,
                        correctAnswersCount = 10,
                        description = "Solved 10 questions in Numbers"
                    ),
                    StudentPointEntity(
                        points = 50,
                        source = "PERFECT_SCORE_BONUS",
                        stdId = 6,
                        subjectId = "math",
                        unitId = 1,
                        correctAnswersCount = 10,
                        description = "Perfect score achievement bonus!"
                    )
                )
                pDao.insertPointRecords(initialPoints)
            }

            // 2. Prepopulate Default Quiz Questions into Local Database
            questionDao?.let { qDao ->
                // Keep Room database lean (initial sample) to prevent SQLite CursorWindow buffer overflow
                val initialSample = QuizStaticData.staticQuestions.take(50).map { qModel ->
                    qModel.toQuizQuestionEntity(
                        unitName = "Unit ${qModel.unitId}",
                        difficulty = "Medium",
                        hint = "Review key chapter concepts",
                        points = 10,
                        isCustom = false
                    )
                }
                qDao.insertQuestions(initialSample)
            }

            // 2. Pre-fill Competition Leaderboard
            val mockStudents = listOf(
                LeaderboardUser("Prajwal K.", 320, 68, 1750, isMe = false, rank = 1),
                LeaderboardUser("Sneha Rao", 290, 55, 1420, isMe = false, rank = 2),
                LeaderboardUser("Suhas Govind", 240, 42, 1250, isMe = true, rank = 3), // Match user profile initially
                LeaderboardUser("Akshay N.", 180, 31, 1100, isMe = false, rank = 4),
                LeaderboardUser("Tejas Gowda", 150, 24, 980, isMe = false, rank = 5),
                LeaderboardUser("Kavya S.", 110, 18, 820, isMe = false, rank = 6)
            )
            dao.insertLeaderboardUsers(mockStudents)

            // 3. Pre-fill Welcome Notifications
            dao.insertNotification(
                NotificationEntity(
                    title = "📚 Welcome to School Quiz!",
                    description = "Take interactive quizzes for your school standards 6 to 10, earn stars, and climb the leaderboard!",
                    category = "System"
                )
            )
            dao.insertNotification(
                NotificationEntity(
                    title = "🔥 Daily Challenge Active!",
                    description = "Attempt 'Numbers' inside Std 6 Mathematics to earn a bonus of 50 coins today!",
                    category = "Daily Challenge"
                )
            )
            dao.insertNotification(
                NotificationEntity(
                    title = "🏆 Scholarship Announcements",
                    description = "National Quiz Olympiad registration starting under standard 6-10 chapters. Tap play now!",
                    category = "Exam"
                )
            )

            // 4. Prepopulate Educational Banners
            dao.insertAdvertisement(
                AdvertisementEntity(
                    title = "🌟 Science Olympiad 2026",
                    subtitle = "Test your skills against students country-wide. Win exciting robotics kits!",
                    imageUrl = "science_banner"
                )
            )
            dao.insertAdvertisement(
                AdvertisementEntity(
                    title = "🧮 Math Ninja Challenge",
                    subtitle = "Finish 3 consecutive math units to unlock the rare 'Matrix Sensei' badge!",
                    imageUrl = "math_banner"
                )
            )
            dao.insertAdvertisement(
                AdvertisementEntity(
                    title = "🚀 Interactive Space Quiz",
                    subtitle = "Explore orbits, stellar objects, and planetary structures. Claim 100 bonus XP!",
                    imageUrl = "space_banner"
                )
            )

            // 5. Prepopulate initial Unit Progress placeholders so they aren't empty
            QuizStaticData.standardsList.forEach { std ->
                std.subjects.forEach { subj ->
                    subj.units.forEach { unit ->
                        dao.insertUnitProgress(
                            UnitProgress(
                                stdId = std.std,
                                subjectId = subj.id,
                                unitId = unit.id,
                                progress = 0,
                                completedQuestions = 0,
                                totalQuestions = unit.totalQuestions,
                                difficulty = unit.difficulty
                            )
                        )
                    }
                }
            }
        }
    }
}
