package com.example.data

// Models for UI presentation represent current quiz structure
data class SubjectTemplate(
    val id: String,
    val title: String,
    val iconName: String, // "kannada", "english", "hindi", "math", "science", "social", "computer", "general"
    val colorHex: Long,
    val units: List<UnitTemplate>
)

data class UnitTemplate(
    val id: Int,
    val name: String,
    val totalQuestions: Int,
    val difficulty: String // "Easy", "Medium", "Hard"
)

data class StandardTemplate(
    val std: Int,
    val name: String = "Std $std",
    val subjects: List<SubjectTemplate>
)

data class QuestionModel(
    val id: String,
    val stdId: Int,
    val subjectId: String,
    val unitId: Int,
    val type: String = "MCQ", // "MCQ", "MULTIPLE_CHOICE", "TF", "MATCH", "FILL", "IMAGE", "AUDIO", "VIDEO"
    val questionText: String,
    val options: List<String>,
    val correctAnswer: String,
    val explanation: String = "",
    val mediaRes: String = "" // Contains text clues, emoji, or TTS script
) {
    /**
     * Determines if the question requires multiple choices to be selected.
     */
    val isMultipleChoice: Boolean
        get() = type.equals("MULTIPLE_CHOICE", ignoreCase = true) ||
                type.equals("MULTI_SELECT", ignoreCase = true) ||
                type.equals("MSQ", ignoreCase = true) ||
                (correctAnswer.contains(",") && options.size > 2) ||
                (correctAnswer.contains("|") && options.size > 2)

    /**
     * Set of correct answers parsed from correctAnswer (normalized to lowercase).
     */
    val correctAnswersSet: Set<String>
        get() {
            val delimiter = if (correctAnswer.contains(",")) "," else if (correctAnswer.contains("|")) "|" else null
            return if (delimiter != null) {
                correctAnswer.split(delimiter).map { it.trim().lowercase() }.filter { it.isNotEmpty() }.toSet()
            } else {
                setOf(correctAnswer.trim().lowercase())
            }
        }
}

object QuizStaticData {

    // Helper map of icons and subject colors
    val SUBJECT_COLORS = mapOf(
        "fln" to 0xFF00BCD4,           // Cyan
        "computer" to 0xFF00BCD4,      // Cyan (legacy alias)
        "kannada" to 0xFF2196F3,       // Blue
        "english" to 0xFF4CAF50,       // Green
        "hindi" to 0xFFFF9800,         // Orange
        "math" to 0xFFF44336,          // Red
        "science" to 0xFF9C27B0,       // Purple
        "social" to 0xFFFF5722,        // Deep Orange
        "general_science" to 0xFF059669,// Emerald Green
        "gk" to 0xFFD97706,            // Warm Amber
        "mental_ability" to 0xFF8B5CF6,// Violet
        "general" to 0xFF795548        // Brown
    )

    // Build standards 6 to 10 dynamically: FLN (Basics) is 1st subject above Kannada
    val std6To10List: List<StandardTemplate> = (6..10).map { stdNum ->
        val kannadaUnits = when (stdNum) {
            6 -> Std6KannadaQuestionBank.units
            7 -> Std7KannadaQuestionBank.units
            8 -> Std8KannadaQuestionBank.units
            9 -> Std9KannadaProseQuestionBank.units + Std9KannadaPoemQuestionBank.units + Std9KannadaSupplementaryQuestionBank.units
            10 -> Std10KannadaQuestionBank.units
            else -> listOf(
                UnitTemplate(1, "ಕನ್ನಡ ವರ್ಣಮಾಲೆ ಮತ್ತು ವ್ಯಾಕರಣ", 5, "Easy"),
                UnitTemplate(2, "ಗುಣಿತಾಕ್ಷರಗಳು & ಸಂಯುಕ್ತಾಕ್ಷರ", 5, "Medium"),
                UnitTemplate(3, "ಸಾಹಿತ್ಯ ಮತ್ತು ಗಾದೆ ಮಾತುಗಳು", 5, "Easy")
            )
        }
        val englishUnits = when (stdNum) {
            7 -> Std7EnglishQuestionBank.units
            8 -> Std8EnglishQuestionBank.units
            9 -> Std9EnglishQuestionBank.units
            10 -> Std10EnglishQuestionBank.units
            else -> listOf(
                UnitTemplate(1, "Nouns & Pronouns", 4, "Easy"),
                UnitTemplate(2, "Verbs & Tenses", 4, "Medium"),
                UnitTemplate(3, "Prefixes & Suffixes", 5, "Hard")
            )
        }
        val hindiUnits = when (stdNum) {
            6 -> Std6HindiQuestionBank.units
            7 -> Std7HindiQuestionBank.units
            8 -> Std8HindiQuestionBank.units
            9 -> Std9HindiQuestionBank.units
            10 -> Std10HindiQuestionBank.units
            else -> listOf(
                UnitTemplate(1, "स्वर और व्यंजन (Vowels & Consonants)", 5, "Easy"),
                UnitTemplate(2, "मात्राएँ & व्याकरण", 5, "Medium"),
                UnitTemplate(3, "हिन्दी संख्याएँ और वाक्य रचना", 5, "Medium")
            )
        }
        val mathUnits = when (stdNum) {
            6 -> Std6MathsQuestionBank.units
            7 -> Std7MathsQuestionBank.units
            8 -> Std8MathsQuestionBank.units
            9 -> Std9MathsQuestionBank.units
            10 -> Std10MathsQuestionBank.units
            else -> listOf(
                UnitTemplate(1, "Numbers (Place Value)", 5, "Easy"),
                UnitTemplate(2, "Addition & Subtraction", 5, "Easy"),
                UnitTemplate(3, "Multiplication & Division", 5, "Medium"),
                UnitTemplate(4, "Fractions & Decimals", 5, "Hard"),
                UnitTemplate(5, "Geometry & Shapes", 5, "Medium")
            )
        }
        val scienceUnits = when (stdNum) {
            6 -> Std6ScienceQuestionBank.units
            7 -> Std7SciencePart2QuestionBank.units
            8 -> Std8ScienceQuestionBank.units
            9 -> Std9ScienceQuestionBank.units
            10 -> Std10ScienceQuestionBank.units
            else -> listOf(
                UnitTemplate(1, "Living vs Non-Living Things", 5, "Easy"),
                UnitTemplate(2, "Parts of a Plant", 5, "Easy"),
                UnitTemplate(3, "Human Digestive System", 5, "Hard")
            )
        }
        val socialUnits = when (stdNum) {
            6 -> Std6SocialQuestionBank.units
            7 -> Std7SocialPart2QuestionBank.units
            8 -> Std8SocialQuestionBank.units
            9 -> Std9SocialQuestionBank.units
            10 -> Std10SocialQuestionBank.units
            else -> listOf(
                UnitTemplate(1, "Our Solar System", 5, "Medium"),
                UnitTemplate(2, "Indian Freedom Movement", 5, "Hard"),
                UnitTemplate(3, "Maps & Directions", 5, "Medium")
            )
        }
        StandardTemplate(
            std = stdNum,
            name = "Std $stdNum",
            subjects = listOf(
                SubjectTemplate("fln", "FLN (Basics)", "fln", 0xFF00BCD4, listOf(
                    UnitTemplate(1, "ಘಟಕ 1: ಮೂಲಭೂತ ಸಾಕ್ಷರತೆ - ಕನ್ನಡ (FLN Kannada)", 20, "Easy"),
                    UnitTemplate(2, "Unit 2: Foundational Literacy - English (FLN English)", 20, "Easy"),
                    UnitTemplate(3, "ಘಟಕ 3: ಮೂಲಭೂತ ಸಂಖ್ಯಾಜ್ಞಾನ & ಗಣಿತ (FLN Mathematics)", 20, "Medium")
                )),
                SubjectTemplate("kannada", "ಕನ್ನಡ (Kannada)", "kannada", 0xFF2196F3, kannadaUnits),
                SubjectTemplate("english", "English", "english", 0xFF4CAF50, englishUnits),
                SubjectTemplate("hindi", "हिन्दी (Hindi)", "hindi", 0xFFFF9800, hindiUnits),
                SubjectTemplate("math", if (stdNum in listOf(6, 7, 8, 9, 10)) "ಗಣಿತ (Mathematics)" else "Mathematics", "math", 0xFFE91E63, mathUnits),
                SubjectTemplate("science", if (stdNum in listOf(6, 7, 8, 9, 10)) "ವಿಜ್ಞಾನ (Science)" else "Science", "science", 0xFF9C27B0, scienceUnits),
                SubjectTemplate("social", if (stdNum in listOf(6, 7, 8, 9, 10)) "ಸಮಾಜ ವಿಜ್ಞಾನ (Social Science)" else "Social Science", "social", 0xFFFF5722, socialUnits)
            )
        )
    }

    // Morarji class: Kannada, English, Maths, Environmental Studies (ಪರಿಸರ ಅಧ್ಯಯನ), General Knowledge, Mental Ability
    val morarjiStandard = StandardTemplate(
        std = 11,
        name = "Morarji",
        subjects = listOf(
            SubjectTemplate("kannada", "Kannada (ಕನ್ನಡ)", "kannada", 0xFF2196F3, MorarjiKannadaQuestionBank.units),
            SubjectTemplate("english", "English", "english", 0xFF4CAF50, MorarjiEnglishQuestionBank.units),
            SubjectTemplate("math", "Maths (ಗಣಿತ)", "math", 0xFFE91E63, MorarjiMathsQuestionBank.units),
            SubjectTemplate("general_science", "Environmental Studies (ಪರಿಸರ ಅಧ್ಯಯನ)", "general_science", 0xFF059669, listOf(
                UnitTemplate(1, "ಘಟಕ 1: ಸಸ್ಯಗಳು, ಪ್ರಾಣಿಗಳು ಮತ್ತು ಪರಿಸರ (Plants, Animals & Environment)", 5, "Easy"),
                UnitTemplate(2, "ಘಟಕ 2: ಮಾನವನ ದೇಹ, ಪೋಷಕಾಂಶಗಳು ಮತ್ತು ಆರೋಗ್ಯ (Human Body & Health)", 5, "Medium"),
                UnitTemplate(3, "ಘಟಕ 3: ವಸ್ತುಗಳು, ಶಕ್ತಿ ಮತ್ತು ದೈನಂದಿನ ವಿಜ್ಞಾನ (Matter, Energy & Everyday Science)", 5, "Medium")
            )),
            SubjectTemplate("gk", "General Knowledge (ಸಾಮಾನ್ಯ ಜ್ಞಾನ)", "gk", 0xFFD97706, MorarjiGKQuestionBank.units),
            SubjectTemplate("mental_ability", "Mental Ability (ಬೌದ್ಧಿಕ ಸಾಮರ್ಥ್ಯ)", "mental_ability", 0xFF8B5CF6, MorarjiMentalAbilityQuestionBank.units)
        )
    )

    // NMMS class: GMAT, SAT (Maths), SAT (Science), SAT (Social science)
    val nmmsStandard = StandardTemplate(
        std = 12,
        name = "NMMS",
        subjects = listOf(
            SubjectTemplate("gmat", "GMAT", "mental_ability", 0xFF8B5CF6, MentalAbilityQuestionBank.units),
            SubjectTemplate("sat_math", "SAT (Maths)", "math", 0xFFE91E63, NmmsSatMathsQuestionBank.units),
            SubjectTemplate("sat_science", "SAT (Science)", "science", 0xFF9C27B0, NmmsSatScienceQuestionBank.units),
            SubjectTemplate("sat_social", "SAT (Social Science)", "social", 0xFFFF5722, NmmsSatSocialQuestionBank.units)
        )
    )

    // Complete standards list containing Std 6-10 plus Morarji and NMMS
    val standardsList: List<StandardTemplate> = std6To10List + listOf(morarjiStandard, nmmsStandard)

    /**
     * Determines the next unit in sequence.
     * If current is Unit 1 in Math -> returns Unit 2 in Math.
     * If the current unit is the final unit in the subject -> returns Unit 1 of the next subject in this standard.
     */
    fun getNextUnit(stdId: Int, subjectId: String, currentUnitId: Int): Pair<SubjectTemplate, UnitTemplate>? {
        val stdTemplate = standardsList.find { it.std == stdId } ?: return null
        val currentSubject = stdTemplate.subjects.find { it.id.equals(subjectId, ignoreCase = true) } ?: return null
        val currentUnitIdx = currentSubject.units.indexOfFirst { it.id == currentUnitId }
        if (currentUnitIdx != -1 && currentUnitIdx + 1 < currentSubject.units.size) {
            return Pair(currentSubject, currentSubject.units[currentUnitIdx + 1])
        }
        // If current was the last unit of this subject, advance to the next subject's first unit
        val currentSubjIdx = stdTemplate.subjects.indexOfFirst { it.id.equals(subjectId, ignoreCase = true) }
        if (currentSubjIdx != -1 && currentSubjIdx + 1 < stdTemplate.subjects.size) {
            val nextSubj = stdTemplate.subjects[currentSubjIdx + 1]
            val firstUnit = nextSubj.units.firstOrNull()
            if (firstUnit != null) {
                return Pair(nextSubj, firstUnit)
            }
        }
        return null
    }

    // Static question bank covering Standard 6 primarily, falling back seamlessly.
    val staticQuestions: List<QuestionModel> = listOf(
        // === STD 6 - MATH - UNIT 1 (Numbers) ===
        QuestionModel(
            id = "s_6_math_1_1",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "What is the place value of 7 in the number 45,712?",
            options = listOf("70", "700", "7,000", "7"),
            correctAnswer = "700",
            explanation = "In 45,712, 7 is in the hundreds position. Therefore, its place value is 7 x 100 = 700."
        ),
        QuestionModel(
            id = "s_6_math_1_2",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "TF",
            questionText = "The successor of the largest 4-digit number (9999) is a 5-digit number.",
            options = listOf("True", "False"),
            correctAnswer = "True",
            explanation = "The largest 4-digit number is 9,999. Its successor (add 1) is 10,000, which is indeed the smallest 5-digit number."
        ),
        QuestionModel(
            id = "s_6_math_1_3",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "FILL",
            questionText = "Complete the number pattern: 2500, 3000, 3500, _______, 4500",
            options = listOf("4000", "3600", "3800", "4100"),
            correctAnswer = "4000",
            explanation = "The common difference between terms is 500. So (3500 + 500) = 4000."
        ),
        QuestionModel(
            id = "s_6_math_1_4",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "IMAGE",
            questionText = "Look at this shape 📐. Which geometrical angle is shown inside the interior curve?",
            options = listOf("Acute Angle (<90°)", "Right Angle (90°)", "Obtuse Angle (>90°)", "Reflex Angle (>180°)"),
            correctAnswer = "Right Angle (90°)",
            explanation = "The drafting set square 📐 forms a perpendicular corner, representing a right angle of 90 degrees.",
            mediaRes = "geometric_set_square"
        ),
        QuestionModel(
            id = "s_6_math_1_5",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MATCH",
            questionText = "Match the Roman numerals with their Hindu-Arabic equivalent values.",
            options = listOf("XXV = 25", "IX = 9", "XL = 40", "C = 100"),
            correctAnswer = "0=0,1=1,2=2,3=3", // Represents matched indices
            explanation = "X=10, so XXV=25. IX is 10-1=9. XL is 50-10=40. C stands for 100."
        ),

        // === STD 6 - MATH - UNIT 5 (Geometry & Shapes) --- VIDEO BASED ---
        QuestionModel(
            id = "s_6_math_5_1",
            stdId = 6,
            subjectId = "math",
            unitId = 5,
            type = "VIDEO",
            questionText = "Observe the rotating timeline simulation of the clock. When the minute hand moves exactly from 12 to 3, what shape of rotation is traced out?",
            options = listOf("Semicircle", "Quadrant (Quarter Circle)", "Complete Sphere", "Hexagonal Chord"),
            correctAnswer = "Quadrant (Quarter Circle)",
            explanation = "Going from 12 to 3 sweeps out 90 degrees out of a 360-degree clock. This is 1/4 of a circle, known as a quadrant.",
            mediaRes = "clock_rotation_90"
        ),

        // === STD 6 - ENGLISH - UNIT 1 (Nouns & Pronouns) --- AUDIO BASED ---
        QuestionModel(
            id = "s_6_eng_1_1",
            stdId = 6,
            subjectId = "english",
            unitId = 1,
            type = "AUDIO",
            questionText = "Listen to the word pronounced in the audio. Which part of speech does it belong to?",
            options = listOf("Proper Noun", "Collective Noun", "Action Verb", "Adverb of Manner"),
            correctAnswer = "Collective Noun",
            explanation = "The audio says 'Flock of birds'. A collective noun names a group of things or animals.",
            mediaRes = "Flock of birds"
        ),
        QuestionModel(
            id = "s_6_eng_1_2",
            stdId = 6,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Find the pronoun in the sentence: 'Sarah runs fast because she practices every morning.'",
            options = listOf("Sarah", "fast", "she", "practices"),
            correctAnswer = "she",
            explanation = "'she' is a third-person singular pronoun replacing the name 'Sarah'."
        ),
        QuestionModel(
            id = "s_6_eng_1_3",
            stdId = 6,
            subjectId = "english",
            unitId = 1,
            type = "TF",
            questionText = "In 'The Taj Mahal is in Agra', both 'Taj Mahal' and 'Agra' are proper nouns.",
            options = listOf("True", "False"),
            correctAnswer = "True",
            explanation = "Both refer to unique, specific names of a landmark and a place, so they are capitalized proper nouns."
        ),
        QuestionModel(
            id = "s_6_eng_1_4",
            stdId = 6,
            subjectId = "english",
            unitId = 1,
            type = "FILL",
            questionText = "Fill in the correct relative pronoun: 'The boy _______ won the spelling competition received a gold badge.'",
            options = listOf("who", "which", "whose", "whom"),
            correctAnswer = "who",
            explanation = "We use 'who' to describe a person acting as the subject of a clause."
        ),

        // === STD 6 - HINDI - UNIT 1 & 2 & 3 ===
        QuestionModel(
            id = "s_6_hin_1_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 1,
            type = "MCQ",
            questionText = "हिन्दी वर्णमाला में कुल कितने स्वर (Vowels) होते हैं?",
            options = listOf("9", "11", "13", "15"),
            correctAnswer = "11",
            explanation = "हिन्दी वर्णमाला में मुख्य रूप से 11 स्वर होते हैं (अ से औ तक)।"
        ),
        QuestionModel(
            id = "s_6_hin_1_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 1,
            type = "TF",
            questionText = "'क' से लेकर 'ह' तक के सभी वर्ण व्यंजन (Consonants) कहलाते हैं।",
            options = listOf("True", "False"),
            correctAnswer = "True",
            explanation = "हिन्दी में क वर्ग, च वर्ग आदि 'ह' तक के वर्ण व्यंजन हैं।"
        ),
        QuestionModel(
            id = "s_6_hin_1_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 1,
            type = "FILL",
            questionText = "कमल भारत का _______ फूल है।",
            options = listOf("राष्ट्रीय", "राज्य", "वन्य", "घरेलू"),
            correctAnswer = "राष्ट्रीय",
            explanation = "कमल (Lotus) भारत का राष्ट्रीय पुष्प है।"
        ),
        QuestionModel(
            id = "s_6_hin_2_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 2,
            type = "MCQ",
            questionText = "शब्द 'किताब' में कौन से स्वर की मात्रा प्रयुक्त हुई है?",
            options = listOf("ह्रस्व इ (ि)", "दीर्घ ई (ी)", "उ (ु)", "ए (े)"),
            correctAnswer = "ह्रस्व इ (ि)",
            explanation = "क पर 'ि' लगाने से 'कि' बनता है (क + इ = कि)।"
        ),
        QuestionModel(
            id = "s_6_hin_3_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 3,
            type = "MATCH",
            questionText = "हिन्दी अंकों को उनके शब्दों से मिलाएँ:",
            options = listOf("१ = एक", "५ = पाँच", "१० = दस", "२० = बीस"),
            correctAnswer = "0=0,1=1,2=2,3=3",
            explanation = "१ (एक), ५ (पाँच), १० (दस), २० (बीस) मानक हिन्दी संख्याएँ हैं।"
        ),

        // === STD 6 - SCIENCE - UNIT 1, 2, 3 ===
        QuestionModel(
            id = "s_6_sci_1_1",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "Which life process is described by plants converting sunlight into chemical energy using chlorophyll?",
            options = listOf("Respiration", "Photosynthesis", "Transpiration", "Decomposition"),
            correctAnswer = "Photosynthesis",
            explanation = "Photosynthesis is the process green plants use to synthesize organic foods from light energy."
        ),
        QuestionModel(
            id = "s_6_sci_1_2",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "TF",
            questionText = "Yeast is a non-living organism because it cannot move from place to place.",
            options = listOf("True", "False"),
            correctAnswer = "False",
            explanation = "Yeast is a living single-celled fungus. Mobility is not a strict requirement for all living organisms (e.g., plants and fungi are living)."
        ),
        QuestionModel(
            id = "s_6_sci_1_3",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "IMAGE",
            questionText = "Observe this symbol ♻️. What action does it represent in environmental science?",
            options = listOf("Deforestation", "Recycling", "Thermal Heating", "Water Condensation"),
            correctAnswer = "Recycling",
            explanation = "The chasing arrows triangular ribbon represents the 3 R's: Reduce, Reuse, Recycle.",
            mediaRes = "recycle_symbol"
        ),
        QuestionModel(
            id = "s_6_sci_2_1",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "Which organ of a plant absorbs water and mineral nutrients from the soil?",
            options = listOf("Leaves", "Roots", "Flower petals", "Bark"),
            correctAnswer = "Roots",
            explanation = "Roots anchor the plant and have fine root hairs that absorb moisture and minerals from the soil."
        ),
        QuestionModel(
            id = "s_6_sci_3_1",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "In the human digestive system, where does the majority of nutrient absorption into the bloodstream occur?",
            options = listOf("Stomach", "Small Intestine", "Large Intestine", "Esophagus"),
            correctAnswer = "Small Intestine",
            explanation = "The small intestine has millions of microscopic villi that absorb digested nutrients into the circulatory system."
        ),

        // === STD 6 - SOCIAL SCIENCE - UNIT 1 (Our Solar System) ===
        QuestionModel(
            id = "s_6_soc_1_1",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "Which planet is known as the 'Blue Planet' and supports human life?",
            options = listOf("Mars", "Venus", "Earth", "Jupiter"),
            correctAnswer = "Earth",
            explanation = "Earth is known as the blue planet because two-thirds of its surface is covered by water."
        ),
        QuestionModel(
            id = "s_6_soc_1_2",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "TF",
            questionText = "The Equator is the 0° latitude that divides the Earth into the Northern and Southern Hemispheres.",
            options = listOf("True", "False"),
            correctAnswer = "True",
            explanation = "The Equator is an imaginary horizontal line around the middle of the planet at 0 degrees latitude."
        ),
        QuestionModel(
            id = "s_6_soc_1_3",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "FILL",
            questionText = "The planet closest to the Sun in our solar system is _______.",
            options = listOf("Mercury", "Venus", "Mars", "Neptune"),
            correctAnswer = "Mercury",
            explanation = "Mercury is the smallest and innermost planet in the Solar System, orbiting closest to the Sun."
        ),
        QuestionModel(
            id = "s_6_soc_1_4",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "IMAGE",
            questionText = "Look at this navigation instrument 🧭. Which cardinal direction does the magnetic needle always indicate?",
            options = listOf("North", "South", "East", "West"),
            correctAnswer = "North",
            explanation = "The magnetized needle of a magnetic compass aligns with the Earth's magnetic poles, always pointing North."
        ),
        QuestionModel(
            id = "s_6_soc_1_5",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MATCH",
            questionText = "Match the historical Indian monuments with their respective locations.",
            options = listOf("Taj Mahal = Agra", "Gol Gumbaz = Vijayapura", "Hampi = Ballari", "Red Fort = New Delhi"),
            correctAnswer = "0=0,1=1,2=2,3=3",
            explanation = "Taj Mahal is in Agra, Gol Gumbaz in Vijayapura, Hampi in Ballari/Vijayanagara, and Red Fort in New Delhi."
        ),

        // === STD 6 - COMPUTER - UNIT 1 (Intro to PC) ===
        QuestionModel(
            id = "s_6_comp_1_1",
            stdId = 6,
            subjectId = "computer",
            unitId = 1,
            type = "MCQ",
            questionText = "Which part of the computer is known as its brain?",
            options = listOf("RAM", "Hard Disk", "Monitor", "CPU (Central Processing Unit)"),
            correctAnswer = "CPU (Central Processing Unit)",
            explanation = "The CPU processes calculations, manages data, and acts entirely as the brain of the computer."
        ),
        QuestionModel(
            id = "s_6_comp_1_2",
            stdId = 6,
            subjectId = "computer",
            unitId = 1,
            type = "TF",
            questionText = "A printer is a hardware device used to get output in the form of soft copy on a screen.",
            options = listOf("True", "False"),
            correctAnswer = "False",
            explanation = "Printers produce hard copies on paper. The monitor produces soft copies on screen."
        ),

        // ==========================================
        // === STD 6 - ADDITIONAL CURRICULUM QUESTIONS
        // ==========================================
        QuestionModel(
            id = "s_6_math_2_1",
            stdId = 6,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "A school library had 8,450 books. If 1,275 books were issued to students, how many books remain in the library?",
            options = listOf("7,175", "7,225", "6,175", "7,075"),
            correctAnswer = "7,175",
            explanation = "8,450 - 1,275 = 7,175 books remaining in the school library."
        ),
        QuestionModel(
            id = "s_6_math_3_1",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "What is the quotient and remainder when 458 is divided by 6?",
            options = listOf("Quotient 76, Remainder 2", "Quotient 75, Remainder 8", "Quotient 74, Remainder 4", "Quotient 76, Remainder 0"),
            correctAnswer = "Quotient 76, Remainder 2",
            explanation = "458 = (6 x 76) + 2. The quotient is 76 with a remainder of 2."
        ),
        QuestionModel(
            id = "s_6_math_4_1",
            stdId = 6,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "Convert the improper fraction 7/4 into a mixed fraction.",
            options = listOf("1 3/4", "1 1/4", "2 1/4", "1 2/3"),
            correctAnswer = "1 3/4",
            explanation = "7 divided by 4 equals 1 whole with a remainder of 3, yielding 1 3/4."
        ),
        QuestionModel(
            id = "s_6_eng_2_1",
            stdId = 6,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the tense of the verb in: 'The train had left before we reached the platform.'",
            options = listOf("Past Perfect", "Simple Past", "Present Perfect", "Past Continuous"),
            correctAnswer = "Past Perfect",
            explanation = "'had left' denotes an action completed prior to another past event, which is the Past Perfect tense."
        ),
        QuestionModel(
            id = "s_6_eng_3_1",
            stdId = 6,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Which prefix can be added to the root word 'agree' to mean 'to not agree'?",
            options = listOf("dis-", "un-", "mis-", "in-"),
            correctAnswer = "dis-",
            explanation = "Prefixing 'dis-' to 'agree' gives 'disagree', expressing conflicting opinions."
        ),
        QuestionModel(
            id = "s_6_sci_2_2",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "Which tiny microscopic pores on the underside of green leaves regulate gas exchange and transpiration?",
            options = listOf("Stomata", "Chloroplasts", "Xylem vessels", "Phloem tubes"),
            correctAnswer = "Stomata",
            explanation = "Stomata are specialized pores flanked by guard cells that facilitate gas exchange and water transpiration."
        ),
        QuestionModel(
            id = "s_6_soc_2_1",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "Who is famously recognized as the 'Father of the Nation' in India?",
            options = listOf("Mahatma Gandhi", "Subhash Chandra Bose", "Jawaharlal Nehru", "Sardar Vallabhbhai Patel"),
            correctAnswer = "Mahatma Gandhi",
            explanation = "Mahatma Gandhi led the non-violent freedom movement and is revered as the Father of the Nation."
        ),
        QuestionModel(
            id = "s_6_soc_3_1",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "On a standard cartographic map, which cardinal direction is conventionally oriented toward the bottom?",
            options = listOf("South", "North", "East", "West"),
            correctAnswer = "South",
            explanation = "By universal cartographic convention, the bottom of a standard map points South."
        ),
        QuestionModel(
            id = "s_6_comp_2_1",
            stdId = 6,
            subjectId = "computer",
            unitId = 2,
            type = "MCQ",
            questionText = "Which peripheral device is an input device used to digitize physical photos and documents into a computer?",
            options = listOf("Scanner", "Plotter", "Speaker", "Monitor"),
            correctAnswer = "Scanner",
            explanation = "A scanner captures optical data from physical documents and converts it into digital image files."
        ),
        QuestionModel(
            id = "s_6_comp_3_1",
            stdId = 6,
            subjectId = "computer",
            unitId = 3,
            type = "MCQ",
            questionText = "In graphics drawing software like MS Paint, which tool is used to sample and duplicate an exact color from the canvas?",
            options = listOf("Color Picker (Eyedropper)", "Fill with Color", "Magnifier", "Pencil Tool"),
            correctAnswer = "Color Picker (Eyedropper)",
            explanation = "The Color Picker eyedropper tool samples the exact RGB color value from any pixel."
        ),

        // ==========================================
        // === STD 7 - CURRICULUM QUESTIONS
        // ==========================================
        QuestionModel(
            id = "s_7_math_1_1",
            stdId = 7,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "Evaluate the integer expression: (-15) + (-20) - (-10).",
            options = listOf("-25", "-45", "-5", "25"),
            correctAnswer = "-25",
            explanation = "(-15) + (-20) = -35. Then (-35) - (-10) = -35 + 10 = -25."
        ),
        QuestionModel(
            id = "s_7_math_2_1",
            stdId = 7,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the value of the algebraic expression 3x² - 5x + 4 when x = 2?",
            options = listOf("6", "10", "14", "2"),
            correctAnswer = "6",
            explanation = "3(2)² - 5(2) + 4 = 3(4) - 10 + 4 = 12 - 10 + 4 = 6."
        ),
        QuestionModel(
            id = "s_7_math_3_1",
            stdId = 7,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "If two angles are complementary and one angle measures 38°, what is the measure of the second angle?",
            options = listOf("52°", "142°", "62°", "42°"),
            correctAnswer = "52°",
            explanation = "Complementary angles sum to 90°. 90° - 38° = 52°."
        ),
        QuestionModel(
            id = "s_7_sci_1_1",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "Which mode of heterotrophic nutrition is exhibited by fungi that obtain nourishment from dead and decaying matter?",
            options = listOf("Saprotrophic", "Parasitic", "Autotrophic", "Holozoic"),
            correctAnswer = "Saprotrophic",
            explanation = "Saprotrophs secrete digestive enzymes onto decaying matter and absorb dissolved organic nutrients."
        ),
        QuestionModel(
            id = "s_7_sci_2_1",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the normal core body temperature of a healthy human being in degrees Celsius?",
            options = listOf("37°C", "98.6°C", "35°C", "42°C"),
            correctAnswer = "37°C",
            explanation = "The standard normal human body temperature is approximately 37°C (corresponding to 98.6°F)."
        ),
        QuestionModel(
            id = "s_7_sci_3_1",
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "What color does blue litmus paper turn when dipped into an acidic solution like lemon juice?",
            options = listOf("Red", "Green", "Yellow", "Remains Blue"),
            correctAnswer = "Red",
            explanation = "Acidic substances turn blue litmus paper red, while basic solutions turn red litmus paper blue."
        ),
        QuestionModel(
            id = "s_7_eng_1_1",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Choose the correct superlative adjective: 'Mount Everest is the _______ peak in the world.'",
            options = listOf("highest", "higher", "most high", "more high"),
            correctAnswer = "highest",
            explanation = "The degrees of comparison for 'high' are high, higher, and highest."
        ),
        QuestionModel(
            id = "s_7_soc_1_1",
            stdId = 7,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "The solid outermost crust and rigid top layer of the Earth is known as the _______.",
            options = listOf("Lithosphere", "Hydrosphere", "Atmosphere", "Biosphere"),
            correctAnswer = "Lithosphere",
            explanation = "The lithosphere comprises the Earth's solid brittle crust and uppermost mantle."
        ),
        QuestionModel(
            id = "s_7_kan_1_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "'ದೇವ + ಇಂದ್ರ = ದೇವೇಂದ್ರ' - ಇದು ಯಾವ ಸಂಸ್ಕೃತ ಸಂಧಿಗೆ ಸೂಕ್ತ ಉದಾಹರಣೆಯಾಗಿದೆ?",
            options = listOf("ಗುಣ ಸಂಧಿ", "ಲೋಪ ಸಂಧಿ", "ಆಗಮ ಸಂಧಿ", "ಆದೇಶ ಸಂಧಿ"),
            correctAnswer = "ಗುಣ ಸಂಧಿ",
            explanation = "ಅ-ಕಾರಕ್ಕೆ ಇ-ಕಾರ ಪರವಾದಾಗ 'ಏ' ಕಾರಾದೇಶವಾಗುವುದು ಗುಣ ಸಂಧಿಯ ನಿಯಮವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_hin_1_1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 1,
            type = "MCQ",
            questionText = "'नदी' शब्द का सही बहुवचन रूप क्या होगा?",
            options = listOf("नदियाँ", "नदियां", "नदिएँ", "नदियों"),
            correctAnswer = "नदियाँ",
            explanation = "स्त्रीलिंग इ-कारान्त शब्दों के बहुवचन में 'याँ' प्रत्यय लगाया जाता है, जैसे नदी -> नदियाँ।"
        ),

        // ==========================================
        // === STD 8 - CURRICULUM QUESTIONS
        // ==========================================
        QuestionModel(
            id = "s_8_math_1_1",
            stdId = 8,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "What is the additive inverse of the rational number -7/19?",
            options = listOf("7/19", "-19/7", "19/7", "0"),
            correctAnswer = "7/19",
            explanation = "The additive inverse of a/b is -a/b, because (-7/19) + (7/19) = 0."
        ),
        QuestionModel(
            id = "s_8_math_2_1",
            stdId = 8,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "Solve for x: 5x - 7 = 2x + 8.",
            options = listOf("x = 5", "x = 3", "x = 1", "x = -5"),
            correctAnswer = "x = 5",
            explanation = "5x - 2x = 8 + 7 => 3x = 15 => x = 15/3 = 5."
        ),
        QuestionModel(
            id = "s_8_math_3_1",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "What is the positive square root of 625?",
            options = listOf("25", "35", "15", "45"),
            correctAnswer = "25",
            explanation = "25 x 25 = 625, therefore √625 = 25."
        ),
        QuestionModel(
            id = "s_8_sci_1_1",
            stdId = 8,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "Which cellular organelle is designated as the 'powerhouse of the cell' for synthesizing ATP molecules?",
            options = listOf("Mitochondria", "Ribosome", "Golgi apparatus", "Endoplasmic reticulum"),
            correctAnswer = "Mitochondria",
            explanation = "Mitochondria perform cellular respiration and produce chemical energy stored in ATP."
        ),
        QuestionModel(
            id = "s_8_sci_2_1",
            stdId = 8,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the SI unit of pressure?",
            options = listOf("Pascal (Pa)", "Newton (N)", "Joule (J)", "Watt (W)"),
            correctAnswer = "Pascal (Pa)",
            explanation = "Pressure equals force divided by area (N/m²), which is the definition of the Pascal (Pa)."
        ),
        QuestionModel(
            id = "s_8_sci_3_1",
            stdId = 8,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "Which beneficial bacterium promotes the fermentation and curdling of milk into curd?",
            options = listOf("Lactobacillus", "Rhizobium", "Penicillium", "Streptococcus"),
            correctAnswer = "Lactobacillus",
            explanation = "Lactobacillus converts lactose sugars into lactic acid, causing milk proteins to coagulate into curd."
        ),
        QuestionModel(
            id = "s_8_eng_1_1",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Convert to reported speech: He said, 'I am reading an interesting novel.'",
            options = listOf(
                "He said that he was reading an interesting novel.",
                "He said that I am reading an interesting novel.",
                "He says he is reading an interesting novel.",
                "He told that he had read an interesting novel."
            ),
            correctAnswer = "He said that he was reading an interesting novel.",
            explanation = "In indirect speech with a past reporting verb, the present continuous changes to past continuous."
        ),
        QuestionModel(
            id = "s_8_soc_1_1",
            stdId = 8,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "Who served as the Chairman of the Drafting Committee of the Indian Constitution?",
            options = listOf("Dr. B. R. Ambedkar", "Dr. Rajendra Prasad", "Mahatma Gandhi", "Jawaharlal Nehru"),
            correctAnswer = "Dr. B. R. Ambedkar",
            explanation = "Dr. B. R. Ambedkar chaired the Drafting Committee that formulated the Indian Constitution."
        ),
        QuestionModel(
            id = "s_8_kan_1_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "'ಮುಖ' ಎಂಬ ಸಂಸ್ಕೃತ ತತ್ಸಮ ಪದದ ತದ್ಭವ ರೂಪ ಯಾವುದು?",
            options = listOf("ಮೊಗ", "ಬಾಯಿ", "ನಾಸಿಕ", "ಶಿರ"),
            correctAnswer = "ಮೊಗ",
            explanation = "ಮುಖ ಎಂಬ ತತ್ಸಮ ಪದವು ಕನ್ನಡ ಜನಸಾಮಾನ್ಯರ ಬಳಕೆಯಲ್ಲಿ ತದ್ಭವವಾಗಿ 'ಮೊಗ' ಎಂದಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_hin_1_1",
            stdId = 8,
            subjectId = "hindi",
            unitId = 1,
            type = "MCQ",
            questionText = "'अमृत' शब्द का सही विलोम (Antonym) शब्द क्या है?",
            options = listOf("विष", "जल", "दूध", "पीयूष"),
            correctAnswer = "विष",
            explanation = "अमृत का अर्थ जीवनदायिनी सुधा है, जिसका विपरीतार्थी (विलोम) शब्द 'विष' (जहर) है।"
        ),

        // ==========================================
        // === STD 9 - CURRICULUM QUESTIONS
        // ==========================================



        QuestionModel(
            id = "s_9_kan_1_1",
            stdId = 9,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "'ಹೆಮ್ಮರ' (ಹಿರಿದು + ಮರ) ಎಂಬ ಪದವು ಯಾವ ಕನ್ನಡ ಸಮಾಸಕ್ಕೆ ನಿಖರ ಉದಾಹರಣೆಯಾಗಿದೆ?",
            options = listOf("ಕರ್ಮಧಾರಯ ಸಮಾಸ", "ತತ್ಪುರುಷ ಸಮಾಸ", "ದ್ವಂದ್ವ ಸಮಾಸ", "ಕ್ರಿಯಾ ಸಮಾಸ"),
            correctAnswer = "ಕರ್ಮಧಾರಯ ಸಮಾಸ",
            explanation = "ಪೂರ್ವಪದವು ವಿಶೇಷಣವಾಗಿದ್ದು, ಉತ್ತರಪದವು ವಿಶೇಷ್ಯವಾಗಿದ್ದರೆ ಅದು ಕರ್ಮಧಾರಯ ಸಮಾಸವೆನಿಸುತ್ತದೆ (ಹಿರಿದಾದ ಮರ = ಹೆಮ್ಮರ)."
        ),
        QuestionModel(
            id = "s_9_comp_1_1",
            stdId = 9,
            subjectId = "computer",
            unitId = 1,
            type = "MCQ",
            questionText = "In Python programming, which built-in function is standard for outputting messages to the terminal console?",
            options = listOf("print()", "echo()", "display()", "write()"),
            correctAnswer = "print()",
            explanation = "The standard print() function outputs strings and evaluated expressions to standard console output."
        ),

        // ==========================================
        // === STD 10 - CURRICULUM QUESTIONS
        // ==========================================
        QuestionModel(
            id = "s_10_math_1_1",
            stdId = 10,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "If the discriminant (b² - 4ac) of a quadratic equation ax² + bx + c = 0 is strictly positive (D > 0), its roots are:",
            options = listOf("Real and distinct", "Real and equal", "Non-real / Complex", "Zero"),
            correctAnswer = "Real and distinct",
            explanation = "When discriminant D > 0, the quadratic equation possesses two unequal real roots."
        ),
        QuestionModel(
            id = "s_10_math_2_1",
            stdId = 10,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "Find the 10th term of the Arithmetic Progression (AP): 2, 7, 12, 17, ...",
            options = listOf("47", "42", "52", "50"),
            correctAnswer = "47",
            explanation = "First term a = 2, common difference d = 5. a₁₀ = a + 9d = 2 + 9(5) = 2 + 45 = 47."
        ),
        QuestionModel(
            id = "s_10_math_3_1",
            stdId = 10,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "What is the fundamental Pythagorean identity value of sin²θ + cos²θ for any angle θ?",
            options = listOf("1", "0", "2", "-1"),
            correctAnswer = "1",
            explanation = "By trigonometric definitions on the unit circle, sin²θ + cos²θ = 1 holds true for all angles θ."
        ),
        QuestionModel(
            id = "s_10_sci_1_1",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "What type of chemical reaction is represented by the formula: 2H₂ + O₂ -> 2H₂O?",
            options = listOf("Combination reaction", "Decomposition reaction", "Displacement reaction", "Double displacement reaction"),
            correctAnswer = "Combination reaction",
            explanation = "A reaction in which two or more reactants combine to form a single product is a combination reaction."
        ),
        QuestionModel(
            id = "s_10_sci_2_1",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the focal length of a spherical mirror that has a radius of curvature equal to 30 cm?",
            options = listOf("15 cm", "60 cm", "30 cm", "10 cm"),
            correctAnswer = "15 cm",
            explanation = "The focal length f of a spherical mirror equals half its radius of curvature: f = R / 2 = 30 / 2 = 15 cm."
        ),
        QuestionModel(
            id = "s_10_sci_3_1",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "According to Ohm's Law, what is the formula linking Potential Difference (V), Current (I), and Resistance (R)?",
            options = listOf("V = I × R", "V = I / R", "V = R / I", "V = I² × R"),
            correctAnswer = "V = I × R",
            explanation = "Ohm's Law states that potential difference V across a conductor equals the product of current I and resistance R."
        ),
        QuestionModel(
            id = "s_10_soc_1_1",
            stdId = 10,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "In which historic year did Mahatma Gandhi initiate the Salt Satyagraha with the famous Dandi March?",
            options = listOf("1930", "1919", "1942", "1922"),
            correctAnswer = "1930",
            explanation = "The Salt March to Dandi began on 12 March 1930 and culminated in civil disobedience against British salt laws."
        ),

        QuestionModel(
            id = "s_10_comp_1_1",
            stdId = 10,
            subjectId = "computer",
            unitId = 1,
            type = "MCQ",
            questionText = "Which standard SQL clause is used to filter records in a database query based on specified boolean criteria?",
            options = listOf("WHERE", "ORDER BY", "GROUP BY", "SELECT"),
            correctAnswer = "WHERE",
            explanation = "The WHERE clause in SQL extracts and filters only those rows that satisfy a specified boolean condition."
        ),

        // ==========================================
        // === FLN (BASICS) CURRICULUM QUESTIONS
        // ==========================================
        QuestionModel(
            id = "s_6_fln_1_1",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ ಒಟ್ಟು ಎಷ್ಟು ಅಕ್ಷರಗಳಿವೆ? (How many total letters are in the Kannada alphabet?)",
            options = listOf("49", "52", "46", "50"),
            correctAnswer = "49",
            explanation = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ 49 ಅಕ್ಷರಗಳಿವೆ (ಸ್ವರಗಳು 13, ಯೋಗವಾಹಗಳು 2, ವ್ಯಂಜನಗಳು 34)."
        ),
        QuestionModel(
            id = "s_6_fln_1_2",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "Identify the correct rhyming word for 'Bright':",
            options = listOf("Light", "Brave", "Bring", "Break"),
            correctAnswer = "Light",
            explanation = "'Bright' and 'Light' share the same ending sound (-ight), making them rhyming words."
        ),
        QuestionModel(
            id = "s_6_fln_2_1",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the sum of 450 + 550?",
            options = listOf("1000", "900", "1100", "950"),
            correctAnswer = "1000",
            explanation = "450 + 550 = 1,000."
        ),
        QuestionModel(
            id = "s_6_fln_2_2",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "If a box contains 24 chocolates and is shared equally among 6 children, how many does each child get?",
            options = listOf("4", "6", "3", "5"),
            correctAnswer = "4",
            explanation = "24 ÷ 6 = 4 chocolates per child."
        ),
        QuestionModel(
            id = "s_6_fln_3_1",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "Which device is commonly used to click and select items on a desktop computer screen?",
            options = listOf("Mouse", "Speaker", "Printer", "Microphone"),
            correctAnswer = "Mouse",
            explanation = "A mouse is a handheld pointing input device used to interact with graphical items on a screen."
        ),

        // ==========================================
        // === MORARJI ENTRANCE EXAM QUESTIONS (STD 11)
        // ==========================================
        QuestionModel(
            id = "s_morarji_kan_1_1",
            stdId = 11,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕನ್ನಡದ ಮೊದಲ ರಾಷ್ಟ್ರಕವಿ ಎಂಬ ಬಿರುದು ಪಡೆದವರು ಯಾರು?",
            options = listOf("ಮಂಜೇಶ್ವರ ಗೋವಿಂದ ಪೈ", "ಕುವೆಂಪು", "ದ.ರಾ. ಬೇಂದ್ರೆ", "ಶಿವರಾಮ ಕಾರಂತ"),
            correctAnswer = "ಮಂಜೇಶ್ವರ ಗೋವಿಂದ ಪೈ",
            explanation = "ಮಂಜೇಶ್ವರ ಗೋವಿಂದ ಪೈ ಅವರಿಗೆ ಮದ್ರಾಸ್ ಸರ್ಕಾರವು 1949ರಲ್ಲಿ 'ರಾಷ್ಟ್ರಕವಿ' ಬಿರುದನ್ನು ನೀಡಿ ಗೌರವಿಸಿತು."
        ),
        QuestionModel(
            id = "s_morarji_eng_1_1",
            stdId = 11,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Choose the correct collective noun: 'A _______ of wolves attacked the herd.'",
            options = listOf("pack", "flock", "herd", "swarm"),
            correctAnswer = "pack",
            explanation = "A group of wolves is called a 'pack'."
        ),
        QuestionModel(
            id = "s_morarji_math_1_1",
            stdId = 11,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "What is the Least Common Multiple (LCM) of 12 and 18?",
            options = listOf("36", "72", "6", "24"),
            correctAnswer = "36",
            explanation = "Multiples of 12: 12, 24, 36. Multiples of 18: 18, 36. The smallest common multiple is 36."
        ),
        QuestionModel(
            id = "s_morarji_sci_1_1",
            stdId = 11,
            subjectId = "general_science",
            unitId = 1,
            type = "MCQ",
            questionText = "Which pigment gives green color to plant leaves and traps sunlight for photosynthesis?",
            options = listOf("Chlorophyll", "Hemoglobin", "Melanin", "Xanthophyll"),
            correctAnswer = "Chlorophyll",
            explanation = "Chlorophyll is the green pigment in chloroplasts that absorbs sunlight energy for photosynthesis."
        ),
        QuestionModel(
            id = "s_morarji_gk_1_1",
            stdId = 11,
            subjectId = "gk",
            unitId = 1,
            type = "MCQ",
            questionText = "Which river is widely called the 'Lifeline of Karnataka' (ಕಾವೇರಿ ನದಿ)?",
            options = listOf("Kaveri", "Krishna", "Tungabhadra", "Sharavathi"),
            correctAnswer = "Kaveri",
            explanation = "River Kaveri originates at Talakaveri in Kodagu and is considered the sacred lifeline of southern Karnataka."
        ),

        // ==========================================
        // === NMMS SCHOLARSHIP EXAM QUESTIONS (STD 12)
        // ==========================================
        // ==========================================
        // === NMMS SCHOLARSHIP EXAM QUESTIONS (STD 12)
        // ==========================================
        QuestionModel(
            id = "s_nmms_gmat_1_1",
            stdId = 12,
            subjectId = "gmat",
            unitId = 1,
            type = "MCQ",
            questionText = "Complete the number pattern series: 2, 6, 12, 20, 30, ?",
            options = listOf("42", "40", "44", "38"),
            correctAnswer = "42",
            explanation = "The differences increase consecutively by 2: +4, +6, +8, +10, +12. Hence 30 + 12 = 42."
        ),
        QuestionModel(
            id = "s_nmms_gmat_1_2",
            stdId = 12,
            subjectId = "gmat",
            unitId = 1,
            type = "MCQ",
            questionText = "If CAT is coded as 3120 in a numerical code (C=3, A=1, T=20), what is the code for DOG?",
            options = listOf("4157", "4147", "4158", "3157"),
            correctAnswer = "4157",
            explanation = "Letter positions in English alphabet: D = 4, O = 15, G = 7. Concatenated: 4157."
        ),
        QuestionModel(
            id = "s_nmms_gmat_2_1",
            stdId = 12,
            subjectId = "gmat",
            unitId = 2,
            type = "MCQ",
            questionText = "Find the odd one out among the given options:",
            options = listOf("144", "27", "64", "125"),
            correctAnswer = "144",
            explanation = "27 (3³), 64 (4³), and 125 (5³) are perfect cubes. 144 is a square (12²), not a cube."
        ),
        QuestionModel(
            id = "s_nmms_gmat_3_1",
            stdId = 12,
            subjectId = "gmat",
            unitId = 3,
            type = "MCQ",
            questionText = "Pointing to a photograph, Suresh says: 'He is the only son of my grandfather's only son.' How is the person related to Suresh?",
            options = listOf("Himself", "Brother", "Cousin", "Father"),
            correctAnswer = "Himself",
            explanation = "Grandfather's only son is Suresh's father. The only son of his father is Suresh himself."
        ),
        QuestionModel(
            id = "s_nmms_gmat_4_1",
            stdId = 12,
            subjectId = "gmat",
            unitId = 4,
            type = "MCQ",
            questionText = "A clock shows 3:00. What is the angle between the hour and minute hands?",
            options = listOf("90°", "60°", "120°", "45°"),
            correctAnswer = "90°",
            explanation = "At 3:00, the minute hand points at 12 and the hour hand at 3. The angle is 3 × 30° = 90°."
        ),
        QuestionModel(
            id = "s_nmms_gmat_5_1",
            stdId = 12,
            subjectId = "gmat",
            unitId = 5,
            type = "MCQ",
            questionText = "Which number does NOT belong to the group: 8, 27, 64, 100, 125?",
            options = listOf("100", "8", "64", "125"),
            correctAnswer = "100",
            explanation = "8=2³, 27=3³, 64=4³, 125=5³ are perfect cubes. 100=10² is a square."
        ),
        QuestionModel(
            id = "s_nmms_sat_math_1_1",
            stdId = 12,
            subjectId = "sat_math",
            unitId = 1,
            type = "MCQ",
            questionText = "What is the square root of 576 (√576)?",
            options = listOf("24", "26", "22", "28"),
            correctAnswer = "24",
            explanation = "24 × 24 = 576. Therefore, the square root of 576 is 24."
        ),
        QuestionModel(
            id = "s_nmms_sat_math_2_1",
            stdId = 12,
            subjectId = "sat_math",
            unitId = 2,
            type = "MCQ",
            questionText = "Solve for x: 3x - 5 = 16",
            options = listOf("7", "6", "8", "9"),
            correctAnswer = "7",
            explanation = "3x = 16 + 5 = 21 => x = 21 / 3 = 7."
        ),
        QuestionModel(
            id = "s_nmms_sat_math_3_1",
            stdId = 12,
            subjectId = "sat_math",
            unitId = 3,
            type = "MCQ",
            questionText = "An article bought for ₹500 is sold for ₹600. What is the profit percentage?",
            options = listOf("20%", "25%", "15%", "10%"),
            correctAnswer = "20%",
            explanation = "Profit = 600 - 500 = ₹100. Profit % = (100 / 500) × 100 = 20%."
        ),
        QuestionModel(
            id = "s_nmms_sat_math_4_1",
            stdId = 12,
            subjectId = "sat_math",
            unitId = 4,
            type = "MCQ",
            questionText = "What is the sum of interior angles of a quadrilateral?",
            options = listOf("360°", "180°", "540°", "720°"),
            correctAnswer = "360°",
            explanation = "The sum of interior angles in any four-sided quadrilateral is (4 - 2) × 180° = 360°."
        ),
        QuestionModel(
            id = "s_nmms_sat_sci_1_1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "What is the unit of pressure in the SI system?",
            options = listOf("Pascal (Pa)", "Newton (N)", "Joule (J)", "Watt (W)"),
            correctAnswer = "Pascal (Pa)",
            explanation = "Pressure = Force / Area. 1 Pascal = 1 N/m²."
        ),
        QuestionModel(
            id = "s_nmms_sat_sci_2_1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "Which chemical compound is the main constituent of rust?",
            options = listOf("Hydrated Iron(III) Oxide", "Iron Carbonate", "Iron Nitrate", "Iron Chloride"),
            correctAnswer = "Hydrated Iron(III) Oxide",
            explanation = "Rust is hydrated iron(III) oxide (Fe₂O₃·xH₂O) formed when iron reacts with oxygen and moisture."
        ),
        QuestionModel(
            id = "s_nmms_sat_sci_3_1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "Which fuel has the highest calorific value?",
            options = listOf("Hydrogen", "LPG", "CNG", "Petrol"),
            correctAnswer = "Hydrogen",
            explanation = "Hydrogen has the highest calorific value (approx. 150,000 kJ/kg) among common fuels."
        ),
        QuestionModel(
            id = "s_nmms_sat_sci_4_1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "Which bacterium converts milk into curd by producing lactic acid?",
            options = listOf("Lactobacillus", "Rhizobium", "Streptococcus", "E. coli"),
            correctAnswer = "Lactobacillus",
            explanation = "Lactobacillus promotes curd formation by fermenting lactose into lactic acid."
        )
    ) + Std6KannadaQuestionBank.questions + Std6HindiQuestionBank.questions + Std6MathsQuestionBank.questions + Std6ScienceQuestionBank.questions + Std6SocialQuestionBank.questions + Std7KannadaQuestionBank.questions + Std7EnglishQuestionBank.questions + Std7HindiQuestionBank.questions + Std7MathsQuestionBank.questions + Std7MathsExtraUnitsBank.questions + Std7MathsPart2UnitsBank.questions + Std7SciencePart1QuestionBank.questions + Std7SciencePart2QuestionBank.questions + Std7SocialPart1QuestionBank.questions + Std7SocialPart2QuestionBank.questions + Std8KannadaQuestionBank.questions + Std8EnglishQuestionBank.questions + Std8HindiQuestionBank.questions + Std8MathsQuestionBank.questions + Std8ScienceQuestionBank.questions + Std8SocialQuestionBank.questions + MorarjiKannadaQuestionBank.questions + MorarjiEnglishQuestionBank.questions + MorarjiMathsQuestionBank.questions + MorarjiGKQuestionBank.questions + MorarjiMentalAbilityQuestionBank.questions + MentalAbilityQuestionBank.questions + NmmsSatMathsQuestionBank.questions + NmmsSatScienceQuestionBank.questions + NmmsSatSocialQuestionBank.questions + Std9KannadaProseQuestionBank.questions + Std9KannadaPoemQuestionBank.questions + Std9KannadaSupplementaryQuestionBank.questions + Std9EnglishQuestionBank.questions + Std9HindiQuestionBank.questions + Std9ScienceQuestionBank.questions + Std9SocialQuestionBank.questions + Std9MathsQuestionBank.questions + Std10KannadaQuestionBank.questions + Std10EnglishQuestionBank.questions + Std10HindiQuestionBank.questions + Std10ScienceQuestionBank.questions + Std10SocialQuestionBank.questions + Std10MathsQuestionBank.questions + FlnCompetencyQuestionBank.questions

    /**
     * Checks if a question's subject matches or aliases the requested subject.
     */
    fun matchesSubject(qSubject: String, targetSubject: String): Boolean {
        if (qSubject.equals(targetSubject, ignoreCase = true)) return true
        if (targetSubject.equals("fln", ignoreCase = true) && qSubject.equals("computer", ignoreCase = true)) return true
        if (targetSubject.equals("computer", ignoreCase = true) && qSubject.equals("fln", ignoreCase = true)) return true
        if (targetSubject.equals("gmat", ignoreCase = true) && (qSubject.equals("gmat", ignoreCase = true) || qSubject.equals("mental_ability", ignoreCase = true))) return true
        if (targetSubject.equals("mental_ability", ignoreCase = true) && (qSubject.equals("mental_ability", ignoreCase = true) || qSubject.equals("gmat", ignoreCase = true))) return true
        if (targetSubject.equals("sat_math", ignoreCase = true) && (qSubject.equals("sat_math", ignoreCase = true) || qSubject.equals("math", ignoreCase = true))) return true
        if (targetSubject.equals("math", ignoreCase = true) && (qSubject.equals("math", ignoreCase = true) || qSubject.equals("sat_math", ignoreCase = true))) return true
        if (targetSubject.equals("sat_science", ignoreCase = true) && (qSubject.equals("sat_science", ignoreCase = true) || qSubject.equals("science", ignoreCase = true))) return true
        if (targetSubject.equals("science", ignoreCase = true) && (qSubject.equals("science", ignoreCase = true) || qSubject.equals("sat_science", ignoreCase = true))) return true
        if (targetSubject.equals("sat_social", ignoreCase = true) && (qSubject.equals("sat_social", ignoreCase = true) || qSubject.equals("social", ignoreCase = true))) return true
        if (targetSubject.equals("social", ignoreCase = true) && (qSubject.equals("social", ignoreCase = true) || qSubject.equals("sat_social", ignoreCase = true))) return true
        return false
    }

    // Fallback getter if specific parameters don't find questions
    fun getQuestionsForUnit(stdId: Int, subjectId: String, unitId: Int, custom: List<CustomQuestion>): List<QuestionModel> {
        val exactMatches = staticQuestions.filter {
            it.stdId == stdId && matchesSubject(it.subjectId, subjectId) && it.unitId == unitId
        }

        val filteredStatic = if (exactMatches.isNotEmpty()) {
            exactMatches
        } else {
            val sameSubjectAndUnit = staticQuestions.filter {
                matchesSubject(it.subjectId, subjectId) && it.unitId == unitId
            }
            if (sameSubjectAndUnit.isNotEmpty()) {
                sameSubjectAndUnit
            } else {
                val sameSubject = staticQuestions.filter {
                    matchesSubject(it.subjectId, subjectId)
                }
                if (sameSubject.isNotEmpty()) sameSubject
                else staticQuestions.filter { it.stdId == stdId }
            }
        }

        // Convert db custom questions
        val convertedCustom = custom.map {
            QuestionModel(
                id = "custom_${it.id}",
                stdId = it.stdId,
                subjectId = it.subjectId,
                unitId = it.unitId,
                type = it.type,
                questionText = it.questionText,
                options = it.optionsString.split("|").map { s -> s.trim() },
                correctAnswer = it.correctAnswer,
                explanation = it.explanation,
                mediaRes = it.mediaRes
            )
        }

        val all = filteredStatic + convertedCustom

        if (all.isNotEmpty()) return all

        // If completely empty, generate highly interactive mock fallback questions based on unit & subject names
        // so NO subject/unit combination ever crashes or is boring!
        return listOf(
            QuestionModel(
                id = "fallback_${stdId}_${subjectId}_${unitId}_1",
                stdId = stdId,
                subjectId = subjectId,
                unitId = unitId,
                type = "MCQ",
                questionText = "Review Unit $unitId: Which of the following is core to this course material?",
                options = listOf("Key Concept Alpha", "Key Concept Beta", "Key Concept Gamma", "All of the above"),
                correctAnswer = "All of the above",
                explanation = "All options cover standard requirements of Chapter $unitId in $subjectId."
            ),
            QuestionModel(
                id = "fallback_${stdId}_${subjectId}_${unitId}_2",
                stdId = stdId,
                subjectId = subjectId,
                unitId = unitId,
                type = "TF",
                questionText = "Consistent daily studying and practicing quizzes boosts retention by over 90%.",
                options = listOf("True", "False"),
                correctAnswer = "True",
                explanation = "Gamified daily mock practices improve associative learning and neural reinforcement."
            ),
            QuestionModel(
                id = "fallback_${stdId}_${subjectId}_${unitId}_3",
                stdId = stdId,
                subjectId = subjectId,
                unitId = unitId,
                type = "IMAGE",
                questionText = "Look at this happy educational helper 🦉. In folklore, which trait does it represent?",
                options = listOf("Speed", "Strength", "Wisdom", "Cunning"),
                correctAnswer = "Wisdom",
                explanation = "The owl 🦉 has traditionally symbolized academic wisdom, alert learning, and knowledge.",
                mediaRes = "wise_owl"
            )
        )
    }
}
