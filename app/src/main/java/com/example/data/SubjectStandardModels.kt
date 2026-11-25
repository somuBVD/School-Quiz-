package com.example.data

/**
 * Enumeration of Core Curriculum Subjects supported by the school quiz system.
 * Specifically covers:
 *  - Kannada (ಕನ್ನಡ)
 *  - English
 *  - Hindi (हिन्दी)
 *  - Mathematics (ಗಣಿತ / गणित)
 *  - Science (ವಿಜ್ಞಾನ / विज्ञान)
 *  - Social Science (ಸಮಾಜ ವಿಜ್ಞಾನ / सामाजिक विज्ञान)
 */
enum class SubjectType(
    val id: String,
    val displayName: String,
    val vernacularName: String,
    val iconName: String,
    val colorHex: Long,
    val description: String
) {
    FLN(
        id = "fln",
        displayName = "FLN (Basics)",
        vernacularName = "ಮೂಲಭೂತ ಕಲಿಕೆ (FLN)",
        iconName = "fln",
        colorHex = 0xFF00BCD4, // Cyan
        description = "Foundational Literacy, Numeracy & Digital Skills"
    ),
    KANNADA(
        id = "kannada",
        displayName = "Kannada",
        vernacularName = "ಕನ್ನಡ",
        iconName = "kannada",
        colorHex = 0xFF2196F3, // Royal Blue
        description = "ಕನ್ನಡ ಭಾಷೆ, ವರ್ಣಮಾಲೆ, ವ್ಯಾಕರಣ, ಗಾದೆಗಳು ಮತ್ತು ಸಾಹಿತ್ಯ"
    ),
    ENGLISH(
        id = "english",
        displayName = "English",
        vernacularName = "English",
        iconName = "english",
        colorHex = 0xFF4CAF50, // Forest Green
        description = "English grammar, parts of speech, vocabulary, comprehension and idioms"
    ),
    HINDI(
        id = "hindi",
        displayName = "Hindi",
        vernacularName = "हिन्दी",
        iconName = "hindi",
        colorHex = 0xFFFF9800, // Amber / Saffron
        description = "हिन्दी व्याकरण, स्वर-व्यंजन, शब्द-रचना, और भाषा अभ्यास"
    ),
    MATHEMATICS(
        id = "math",
        displayName = "Mathematics",
        vernacularName = "ಗಣಿತ / गणित",
        iconName = "math",
        colorHex = 0xFFE91E63, // Crimson / Pink
        description = "Arithmetic, number systems, algebra, fractions, geometry and statistics"
    ),
    SCIENCE(
        id = "science",
        displayName = "Science",
        vernacularName = "ವಿಜ್ಞಾನ / विज्ञान",
        iconName = "science",
        colorHex = 0xFF9C27B0, // Purple
        description = "Physics, Chemistry, Biology, Environmental science and everyday science"
    ),
    SOCIAL_SCIENCE(
        id = "social",
        displayName = "Social Science",
        vernacularName = "ಸಮಾಜ ವಿಜ್ಞಾನ / सामाजिक विज्ञान",
        iconName = "social",
        colorHex = 0xFFFF5722, // Deep Orange
        description = "History, Indian freedom struggle, Geography, Solar system and Civics"
    ),
    GENERAL_SCIENCE(
        id = "general_science",
        displayName = "Environmental Studies (ಪರಿಸರ ಅಧ್ಯಯನ)",
        vernacularName = "ಪರಿಸರ ಅಧ್ಯಯನ (Environmental Studies)",
        iconName = "general_science",
        colorHex = 0xFF059669, // Emerald Green
        description = "Fundamental everyday science, nature, ecology, plants, animals, health and environmental studies"
    ),
    GENERAL_KNOWLEDGE(
        id = "gk",
        displayName = "General Knowledge",
        vernacularName = "ಸಾಮಾನ್ಯ ಜ್ಞಾನ (GK)",
        iconName = "gk",
        colorHex = 0xFFD97706, // Amber
        description = "Current affairs, Karnataka heritage, Indian constitution, national awards and space facts"
    ),
    MENTAL_ABILITY(
        id = "mental_ability",
        displayName = "Mental Ability (ಬೌದ್ಧಿಕ ಸಾಮರ್ಥ್ಯ)",
        vernacularName = "ಬೌದ್ಧಿಕ ಸಾಮರ್ಥ್ಯ (Mental Ability)",
        iconName = "mental_ability",
        colorHex = 0xFF8B5CF6, // Violet
        description = "Reasoning, analogies, pattern recognition, number series and problem solving"
    ),
    GMAT(
        id = "gmat",
        displayName = "GMAT",
        vernacularName = "GMAT (Mental Ability)",
        iconName = "mental_ability",
        colorHex = 0xFF8B5CF6,
        description = "General Mental Ability Test (GMAT) for NMMS Scholarship"
    ),
    SAT_MATH(
        id = "sat_math",
        displayName = "SAT (Maths)",
        vernacularName = "SAT (Maths)",
        iconName = "math",
        colorHex = 0xFFE91E63,
        description = "Scholastic Aptitude Test - Mathematics"
    ),
    SAT_SCIENCE(
        id = "sat_science",
        displayName = "SAT (Science)",
        vernacularName = "SAT (Science)",
        iconName = "science",
        colorHex = 0xFF9C27B0,
        description = "Scholastic Aptitude Test - Science"
    ),
    SAT_SOCIAL(
        id = "sat_social",
        displayName = "SAT (Social science)",
        vernacularName = "SAT (ಸಮಾಜವಿಜ್ಞಾನ)",
        iconName = "social",
        colorHex = 0xFFFF5722,
        description = "Scholastic Aptitude Test - Social Science"
    ),
    CDP(
        id = "cdp",
        displayName = "Child Development & Pedagogy",
        vernacularName = "ಶೈಕ್ಷಣಿಕ ಮನೋವಿಜ್ಞಾನ (CDP)",
        iconName = "cdp",
        colorHex = 0xFF0EA5E9,
        description = "Child development theories, learning psychology, NCF 2005, and RTE Act for TET"
    ),
    TEACHING_RESEARCH(
        id = "teaching_research",
        displayName = "Teaching & Research Aptitude",
        vernacularName = "Teaching & Research Aptitude",
        iconName = "teaching_research",
        colorHex = 0xFF6366F1,
        description = "Teaching levels, evaluation systems, research methodology, and ethics for UGC-NET / KSET"
    ),
    LOGICAL_REASONING(
        id = "logical_reasoning",
        displayName = "Logical Reasoning & DI",
        vernacularName = "Logical Reasoning & Data Interpretation",
        iconName = "mental_ability",
        colorHex = 0xFF8B5CF6,
        description = "Syllogisms, Indian Logic (Pramanas), fallacies, and data interpretation for NET"
    ),
    ICT_COMMUNICATION(
        id = "ict_communication",
        displayName = "ICT & Communication",
        vernacularName = "ICT & Communication",
        iconName = "computer",
        colorHex = 0xFF06B6D4,
        description = "Classroom communication models, ICT fundamentals, and digital initiatives for NET"
    ),
    HIGHER_ED_ENV(
        id = "higher_ed_env",
        displayName = "People, Environment & Higher Ed",
        vernacularName = "Environment & Higher Education",
        iconName = "general_science",
        colorHex = 0xFF10B981,
        description = "Sustainable Development Goals, climate treaties, UGC, NAAC, and NEP 2020 for NET"
    ),
    KARNATAKA_HISTORY(
        id = "karnataka_history",
        displayName = "Karnataka History & Culture",
        vernacularName = "ಕರ್ನಾಟಕ ಇತಿಹಾಸ ಮತ್ತು ಸಂಸ್ಕೃತಿ",
        iconName = "social",
        colorHex = 0xFFD97706,
        description = "Dynasties of Karnataka, Vijayanagara, Mysuru Wodeyars, and Ekikarana for KPSC"
    ),
    INDIAN_POLITY(
        id = "indian_polity",
        displayName = "Indian Polity & Constitution",
        vernacularName = "ಭಾರತದ ಸಂವಿಧಾನ ಮತ್ತು ರಾಜಕೀಯ",
        iconName = "gk",
        colorHex = 0xFFEF4444,
        description = "Fundamental Rights, DPSP, Parliament, Judiciary, and Panchayat Raj for KPSC"
    ),
    GEOGRAPHY_ECONOMY(
        id = "geography_economy",
        displayName = "Geography & Indian Economy",
        vernacularName = "ಭೂಗೋಳಶಾಸ್ತ್ರ ಮತ್ತು ಅರ್ಥಶಾಸ್ತ್ರ",
        iconName = "general_science",
        colorHex = 0xFF059669,
        description = "Karnataka & Indian physical geography, RBI, NITI Aayog, and GST for KPSC"
    ),
    KPSC_KANNADA(
        id = "kpsc_kannada",
        displayName = "General Kannada",
        vernacularName = "ಸಾಮಾನ್ಯ ಕನ್ನಡ",
        iconName = "kannada",
        colorHex = 0xFF2196F3,
        description = "ಕನ್ನಡ ಸಾಹಿತ್ಯ, ಕವಿ-ಕೃತಿಗಳು, ಗಾದೆಗಳು ಮತ್ತು ನುಡಿಗಟ್ಟುಗಳು (KPSC)"
    ),
    KPSC_ENGLISH(
        id = "kpsc_english",
        displayName = "General English",
        vernacularName = "ಸಾಮಾನ್ಯ ಇಂಗ್ಲಿಷ್",
        iconName = "english",
        colorHex = 0xFF4CAF50,
        description = "English grammar, comprehension, vocabulary, synonyms, antonyms and idioms (KPSC)"
    ),
    KPSC_GK(
        id = "kpsc_gk",
        displayName = "General Knowledge",
        vernacularName = "ಸಾಮಾನ್ಯ ಜ್ಞಾನ",
        iconName = "gk",
        colorHex = 0xFFF59E0B,
        description = "ಕರ್ನಾಟಕ ಮತ್ತು ಭಾರತದ ಸಾಮಾನ್ಯ ಜ್ಞಾನ, ಪ್ರಶಸ್ತಿಗಳು ಮತ್ತು ಸಂಸ್ಥೆಗಳು (KPSC)"
    ),
    KPSC_SCIENCE(
        id = "kpsc_science",
        displayName = "General Science (Kannada)",
        vernacularName = "ಸಾಮಾನ್ಯ ವಿಜ್ಞಾನ",
        iconName = "science",
        colorHex = 0xFF0EA5E9,
        description = "ಭೌತಶಾಸ್ತ್ರ, ರಸಾಯನಶಾಸ್ತ್ರ ಮತ್ತು ಜೀವಶಾಸ್ತ್ರದ ಮೂಲಭೂತ ಅಂಶಗಳು (KPSC)"
    ),
    KPSC_KANNADA_GRAMMAR(
        id = "kpsc_kannada_grammar",
        displayName = "Kannada Grammar",
        vernacularName = "ಕನ್ನಡ ವ್ಯಾಕರಣ",
        iconName = "kannada",
        colorHex = 0xFFE91E63,
        description = "ವರ್ಣಮಾಲೆ, ಸಂಧಿ, ಸಮಾಸ, ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯಗಳು, ತತ್ಸಮ-ತದ್ಭವ ಮತ್ತು ಅಲಂಕಾರಗಳು (KPSC)"
    ),
    KPSC_COMPUTER(
        id = "kpsc_computer",
        displayName = "Computer Basics",
        vernacularName = "ಕಂಪ್ಯೂಟರ್ ಜ್ಞಾನ",
        iconName = "computer",
        colorHex = 0xFF06B6D4,
        description = "ಕಂಪ್ಯೂಟರ್ ಮೂಲಭೂತ ಅಂಶಗಳು, ಎಂ.ಎಸ್. ಆಫೀಸ್, ಇಂಟರ್ನೆಟ್ ಮತ್ತು ಸೈಬರ್ ಸುರಕ್ಷತೆ (KPSC)"
    );

    companion object {
        val coreSubjects: List<SubjectType> = entries.toList()

        fun fromId(id: String): SubjectType? {
            if (id.equals("computer", ignoreCase = true)) return FLN
            return entries.find { it.id.equals(id, ignoreCase = true) }
        }

        fun getDisplayNameWithVernacular(type: SubjectType): String {
            return if (type.vernacularName == type.displayName) {
                type.displayName
            } else {
                "${type.vernacularName} (${type.displayName})"
            }
        }
    }
}

/**
 * Standards / Grades enumeration strictly supporting Standards 6 to 10 (Secondary & Middle School).
 */
enum class StandardGrade(
    val grade: Int,
    val title: String,
    val stage: String,
    val ageGroup: String,
    val description: String
) {
    STD_6(
        grade = 6,
        title = "Standard 6",
        stage = "Middle School",
        ageGroup = "11-12 Years",
        description = "Fundamental transition into middle school subjects and analytical thinking"
    ),
    STD_7(
        grade = 7,
        title = "Standard 7",
        stage = "Middle School",
        ageGroup = "12-13 Years",
        description = "Intermediate concept deepening across languages, mathematics and sciences"
    ),
    STD_8(
        grade = 8,
        title = "Standard 8",
        stage = "Middle School",
        ageGroup = "13-14 Years",
        description = "Advanced foundations bridging towards secondary school board preparation"
    ),
    STD_9(
        grade = 9,
        title = "Standard 9",
        stage = "Secondary School",
        ageGroup = "14-15 Years",
        description = "Rigorous high-school curriculum covering core board examination basics"
    ),
    STD_10(
        grade = 10,
        title = "Standard 10",
        stage = "Secondary School (SSLC / Matriculation)",
        ageGroup = "15-16 Years",
        description = "Mastery for SSLC / Class 10 board examinations and comprehensive review"
    ),
    MORARJI(
        grade = 11,
        title = "Morarji",
        stage = "Residential School Entrance (MDRS)",
        ageGroup = "10-12 Years",
        description = "Morarji Desai Residential School (MDRS) Entrance Exam Preparation"
    ),
    NMMS(
        grade = 12,
        title = "NMMS",
        stage = "National Merit Scholarship (NMMS)",
        ageGroup = "13-14 Years",
        description = "National Means-cum-Merit Scholarship Exam Preparation (MAT & SAT)"
    ),
    TET(
        grade = 13,
        title = "TET",
        stage = "Teacher Eligibility Test (KAR-TET / CTET)",
        ageGroup = "Aspiring Teachers",
        description = "Child Development & Pedagogy, Languages, Maths & EVS for TET Paper I & II"
    ),
    NET(
        grade = 14,
        title = "NET",
        stage = "UGC-NET / KSET Paper 1",
        ageGroup = "Postgraduate & Research",
        description = "Teaching & Research Aptitude, Logical Reasoning, ICT & Higher Education"
    ),
    KPSC(
        grade = 15,
        title = "KPSC",
        stage = "Karnataka Public Service Commission",
        ageGroup = "Competitive Services (KAS/FDA/SDA)",
        description = "Karnataka History, Indian Polity, Geography, Economy, Science & CSAT"
    );

    companion object {
        val validGrades: List<Int> = entries.map { it.grade }

        fun fromGrade(grade: Int): StandardGrade? {
            return entries.find { it.grade == grade }
        }

        fun shortLabel(grade: Int, stdPrefix: String = "Std"): String = when (grade) {
            11 -> "Morarji"
            12 -> "NMMS"
            13 -> "TET"
            14 -> "NET"
            15 -> "KPSC"
            else -> "$stdPrefix $grade"
        }
    }
}

/**
 * Data model for a Unit / Chapter within a subject curriculum.
 */
data class UnitModel(
    val id: Int,
    val stdId: Int,
    val subjectId: String,
    val name: String,
    val nativeName: String = "",
    val totalQuestions: Int = 5,
    val difficulty: String = "Medium", // "Easy", "Medium", "Hard"
    val topics: List<String> = emptyList()
) {
    fun toUnitTemplate(): UnitTemplate {
        return UnitTemplate(
            id = id,
            name = name,
            totalQuestions = totalQuestions,
            difficulty = difficulty
        )
    }
}

/**
 * Data model for a Subject containing its units and metadata.
 */
data class SubjectModel(
    val id: String,
    val type: SubjectType,
    val title: String,
    val nativeTitle: String,
    val iconName: String,
    val colorHex: Long,
    val description: String,
    val units: List<UnitModel>
) {
    fun toSubjectTemplate(): SubjectTemplate {
        return SubjectTemplate(
            id = id,
            title = title,
            iconName = iconName,
            colorHex = colorHex,
            units = units.map { it.toUnitTemplate() }
        )
    }
}

/**
 * Data model representing a Standard (Class 6-10) with its enrolled subjects and curriculum structure.
 */
data class StandardModel(
    val std: Int,
    val gradeInfo: StandardGrade,
    val title: String,
    val subjects: List<SubjectModel>
) {
    val totalUnits: Int
        get() = subjects.sumOf { it.units.size }

    val totalQuestions: Int
        get() = subjects.sumOf { subj -> subj.units.sumOf { it.totalQuestions } }

    fun toStandardTemplate(): StandardTemplate {
        return StandardTemplate(
            std = std,
            subjects = subjects.map { it.toSubjectTemplate() }
        )
    }
}

/**
 * Question types supported across the quiz application.
 */
enum class QuizQuestionType(val code: String, val title: String) {
    MCQ("MCQ", "Multiple Choice Question"),
    TRUE_FALSE("TF", "True or False"),
    MATCH("MATCH", "Match the Following"),
    FILL_IN_THE_BLANK("FILL", "Fill in the Blanks"),
    IMAGE("IMAGE", "Image / Visual Question"),
    AUDIO("AUDIO", "Listening Comprehension"),
    VIDEO("VIDEO", "Video Question");

    companion object {
        fun fromCode(code: String): QuizQuestionType {
            return entries.find { it.code.equals(code, ignoreCase = true) } ?: MCQ
        }
    }
}
