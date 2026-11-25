package com.example.data

/**
 * KPSC (KAS / FDA / SDA / PDO) Kannada-medium core units/subjects question bank:
 *  - ಸಾಮಾನ್ಯ ಕನ್ನಡ (General Kannada)
 *  - ಸಾಮಾನ್ಯ ಇಂಗ್ಲಿಷ್ (General English)
 *  - ಸಾಮಾನ್ಯ ಜ್ಞಾನ (General Knowledge)
 *  - ಸಾಮಾನ್ಯ ವಿಜ್ಞಾನ (General Science)
 *  - ಕನ್ನಡ ವ್ಯಾಕರಣ (Kannada Grammar)
 *  - ಕಂಪ್ಯೂಟರ್ ಜ್ಞಾನ (Computer Knowledge)
 * Standard / Exam ID: 15.
 */
object KpscKannadaUnitsQuestionBank {

    val generalKannadaUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಕನ್ನಡ ಸಾಹಿತ್ಯ ಮತ್ತು ಕವಿ-ಕೃತಿಗಳು", 5, "Easy"),
        UnitTemplate(2, "ಘಟಕ 2: ಗಾದೆಗಳು, ನುಡಿಗಟ್ಟುಗಳು ಮತ್ತು ಪದಸಂಪತ್ತು", 5, "Medium")
    )

    val generalEnglishUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Grammar, Tenses & Parts of Speech", 5, "Easy"),
        UnitTemplate(2, "Unit 2: Vocabulary, Synonyms, Antonyms & Idioms", 5, "Medium")
    )

    val generalKnowledgeUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಕರ್ನಾಟಕ ಮತ್ತು ಭಾರತದ ಸಾಮಾನ್ಯ ಜ್ಞಾನ", 5, "Easy"),
        UnitTemplate(2, "ಘಟಕ 2: ಪ್ರಶಸ್ತಿಗಳು, ಅಂತಾರಾಷ್ಟ್ರೀಯ ಸಂಸ್ಥೆಗಳು ಮತ್ತು ಪ್ರಮುಖ ದಿನಗಳು", 5, "Medium")
    )

    val generalScienceUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಭೌತಶಾಸ್ತ್ರ ಮತ್ತು ರಸಾಯನಶಾಸ್ತ್ರದ ಮೂಲಭೂತ ಅಂಶಗಳು", 5, "Easy"),
        UnitTemplate(2, "ಘಟಕ 2: ಜೀವಶಾಸ್ತ್ರ, ಪೋಷಕಾಂಶಗಳು ಮತ್ತು ಮಾನವ ಆರೋಗ್ಯ", 5, "Medium")
    )

    val kannadaGrammarUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ವರ್ಣಮಾಲೆ, ಸಂಧಿಗಳು ಮತ್ತು ಸಮಾಸಗಳು", 5, "Medium"),
        UnitTemplate(2, "ಘಟಕ 2: ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯಗಳು, ತತ್ಸಮ-ತದ್ಭವ ಮತ್ತು ಅಲಂಕಾರಗಳು", 5, "Hard")
    )

    val computerKnowledgeUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಕಂಪ್ಯೂಟರ್ ಮೂಲಭೂತ ಅಂಶಗಳು ಮತ್ತು ಹಾರ್ಡ್‌ವೇರ್-ಸಾಫ್ಟ್‌ವೇರ್", 5, "Easy"),
        UnitTemplate(2, "ಘಟಕ 2: ಇಂಟರ್ನೆಟ್, ಎಂ.ಎಸ್. ಆಫೀಸ್ ಮತ್ತು ಸೈಬರ್ ಸುರಕ್ಷತೆ", 5, "Medium")
    )

    val generalKannadaQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscGeneralKannada") {
            listOf(
                QuestionModel(
                    id = "kpsc_kan_u1_q1",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡದ 'ಆದಿಕವಿ' ಎಂದು ಯಾರನ್ನು ಕರೆಯಲಾಗುತ್ತದೆ?",
                    options = listOf("ಪಂಪ", "ರನ್ನ", "ಪೊನ್ನ", "ಜನ್ನ"),
                    correctAnswer = "ಪಂಪ",
                    explanation = "ವಿಕ್ರಮಾರ್ಜುನ ವಿಜಯ ಮತ್ತು ಆದಿಪುರಾಣ ಮಹಾಕಾವ್ಯಗಳನ್ನು ರಚಿಸಿದ ಪಂಪನನ್ನು ಕನ್ನಡದ ಆದಿಕವಿ ಎನ್ನುತ್ತಾರೆ."
                ),
                QuestionModel(
                    id = "kpsc_kan_u1_q2",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡಕ್ಕೆ ಮೊಟ್ಟಮೊದಲ ಜ್ಞಾನಪೀಠ ಪ್ರಶಸ್ತಿ ತಂದುಕೊಟ್ಟ ಕೃತಿ ಯಾವುದು?",
                    options = listOf("ಶ್ರೀ ರಾಮಾಯಣ ದರ್ಶನಂ", "ನಾಕುತಂತಿ", "ಮೂಕಜ್ಜಿಯ ಕನಸುಗಳು", "ಚಿಕ್ಕವೀರ ರಾಜೇಂದ್ರ"),
                    correctAnswer = "ಶ್ರೀ ರಾಮಾಯಣ ದರ್ಶನಂ",
                    explanation = "1967ರಲ್ಲಿ ಕುವೆಂಪು ಅವರ 'ಶ್ರೀ ರಾಮಾಯಣ ದರ್ಶನಂ' ಕೃತಿಗೆ ಕನ್ನಡದ ಮೊದಲ ಜ್ಞಾನಪೀಠ ಪ್ರಶಸ್ತಿ ಲಭಿಸಿತು."
                ),
                QuestionModel(
                    id = "kpsc_kan_u1_q3",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡದ ಪ್ರಥಮ ಉಪಲಬ್ಧ ಗ್ರಂಥವಾದ 'ಕವಿರಾಜಮಾರ್ಗ'ವನ್ನು ರಚಿಸಿದವರು ಯಾರು?",
                    options = listOf("ಶ್ರೀವಿಜಯ", "ಶಿವಕೋಟ್ಯಾಚಾರ್ಯ", "ನಾಗಚಂದ್ರ", "ಕುಮಾರವ್ಯಾಸ"),
                    correctAnswer = "ಶ್ರೀವಿಜಯ",
                    explanation = "ರಾಷ್ಟ್ರಕೂಟ ದೊರೆ ಅಮೋಘವರ್ಷ ನೃಪತುಂಗನ ಆಸ್ಥಾನದಲ್ಲಿದ್ದ ಶ್ರೀವಿಜಯನು 'ಕವಿರಾಜಮಾರ್ಗ' ಕೃತಿಯನ್ನು ರಚಿಸಿದನು."
                ),
                QuestionModel(
                    id = "kpsc_kan_u1_q4",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "'ಕನ್ನಡದ ಕಣ್ವ' ಎಂದು ಪ್ರಸಿದ್ಧರಾದ ಸಾಹಿತಿ ಯಾರು?",
                    options = listOf("ಬಿ.ಎಂ. ಶ್ರೀಕಂಠಯ್ಯ", "ದ.ರಾ. ಬೇಂದ್ರೆ", "ಮಾಸ್ತಿ ವೆಂಕಟೇಶ ಅಯ್ಯಂಗಾರ್", "ಶಿವರಾಮ ಕಾರಂತ"),
                    correctAnswer = "ಬಿ.ಎಂ. ಶ್ರೀಕಂಠಯ್ಯ",
                    explanation = "ನವೋದಯ ಕನ್ನಡ ಸಾಹಿತ್ಯದ ಪ್ರವರ್ತಕರಾದ ಬಿ.ಎಂ. ಶ್ರೀಕಂಠಯ್ಯ ಅವರನ್ನು 'ಕನ್ನಡದ ಕಣ್ವ' ಎಂದು ಕರೆಯುತ್ತಾರೆ."
                ),
                QuestionModel(
                    id = "kpsc_kan_u1_q5",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡದ 'ಆದ್ಯ ವಚನಕಾರ' ಎಂದು ಯಾರನ್ನು ಪರಿಗಣಿಸಲಾಗಿದೆ?",
                    options = listOf("ದೇವರ ದಾಸಿಮಯ್ಯ", "ಬಸವಣ್ಣ", "ಅಲ್ಲಮಪ್ರಭು", "ಅಕ್ಕಮಹಾದೇವಿ"),
                    correctAnswer = "ದೇವರ ದಾಸಿಮಯ್ಯ",
                    explanation = "ಜೇಡರ ದಾಸಿಮಯ್ಯ (ದೇವರ ದಾಸಿಮಯ್ಯ) ಅವರನ್ನು ಕನ್ನಡದ ಆದ್ಯ ವಚನಕಾರ ಎಂದು ಕರೆಯಲಾಗುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "kpsc_kan_u2_q1",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "'ಕೈ ಕೆಸರಾದರೆ ಬಾಯಿ ಮೊಸರು' ಎಂಬ ಗಾದೆಯ ಸರಿಯಾದ ಅರ್ಥವೇನು?",
                    options = listOf(
                        "ಕಷ್ಟಪಟ್ಟು ದುಡಿದರೆ ಉತ್ತಮ ಫಲ ದೊರೆಯುತ್ತದೆ",
                        "ಮೊಸರು ತಿನ್ನಲು ಕೈ ತೊಳೆಯಬೇಕು",
                        "ಕೆಸರಿನಲ್ಲಿ ಆಟವಾಡಬಾರದು",
                        "ದುಡಿಮೆ ಇಲ್ಲದೆಯೇ ಫಲ ಸಿಗುತ್ತದೆ"
                    ),
                    correctAnswer = "ಕಷ್ಟಪಟ್ಟು ದುಡಿದರೆ ಉತ್ತಮ ಫಲ ದೊರೆಯುತ್ತದೆ",
                    explanation = "ಶ್ರಮಪಟ್ಟು ಕೆಲಸ ಮಾಡಿದಾಗ ಮಾತ್ರ ಜೀವನದಲ್ಲಿ ಸುಖ ಮತ್ತು ಉತ್ತಮ ಪ್ರತಿಫಲ ದೊರೆಯುತ್ತದೆ ಎಂಬುದು ಈ ಗಾದೆಯ ಆಶಯ."
                ),
                QuestionModel(
                    id = "kpsc_kan_u2_q2",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "'ನೀರು ಕುಡಿದಷ್ಟೇ ಸುಲಭ' ಎಂಬ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥವೇನು?",
                    options = listOf("ಬಹಳ ಸುಲಭವಾದ ಕೆಲಸ", "ತುಂಬಾ ಕಷ್ಟವಾದ ಕೆಲಸ", "ನೀರು ಕುಡಿಯುವ ಅಭ್ಯಾಸ", "ಅಸಾಧ್ಯವಾದ ಕಾರ್ಯ"),
                    correctAnswer = "ಬಹಳ ಸುಲಭವಾದ ಕೆಲಸ",
                    explanation = "ಯಾವುದೇ ಪ್ರಯಾಸವಿಲ್ಲದೆ ಸರಾಗವಾಗಿ ಮಾಡಬಹುದಾದ ಕೆಲಸವನ್ನು 'ನೀರು ಕುಡಿದಷ್ಟೇ ಸುಲಭ' ಎನ್ನುತ್ತಾರೆ."
                ),
                QuestionModel(
                    id = "kpsc_kan_u2_q3",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "'ಅಮೃತ' ಎಂಬ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
                    options = listOf("ವಿಷ", "ಜೇನು", "ಹಾಲು", "ಸುಧೆ"),
                    correctAnswer = "ವಿಷ",
                    explanation = "'ಅಮೃತ' ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ 'ವಿಷ'."
                ),
                QuestionModel(
                    id = "kpsc_kan_u2_q4",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "'ನೇಸರ' ಎಂಬ ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
                    options = listOf("ಸೂರ್ಯ", "ಚಂದ್ರ", "ನಕ್ಷತ್ರ", "ಮೋಡ"),
                    correctAnswer = "ಸೂರ್ಯ",
                    explanation = "ನೇಸರ, ರವಿ, ಭಾಸ್ಕರ, ಆದಿತ್ಯ ಇವೆಲ್ಲವೂ 'ಸೂರ್ಯ' ಪದದ ಸಮಾನಾರ್ಥಕ ಪದಗಳಾಗಿವೆ."
                ),
                QuestionModel(
                    id = "kpsc_kan_u2_q5",
                    stdId = 15,
                    subjectId = "kpsc_kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "'ಮಾತು ಬೆಳ್ಳಿ, ಮೌನ ______' - ಈ ಪ್ರಸಿದ್ಧ ಗಾದೆಯನ್ನು ಪೂರ್ಣಗೊಳಿಸಿ.",
                    options = listOf("ಬಂಗಾರ", "ತಾಮ್ರ", "ಕಬ್ಬಿಣ", "ವಜ್ರ"),
                    correctAnswer = "ಬಂಗಾರ",
                    explanation = "ಅನಾವಶ್ಯಕವಾಗಿ ಮಾತನಾಡುವುದಕ್ಕಿಂತ ಸಂದರ್ಭೋಚಿತ ಮೌನವು ಹೆಚ್ಚು ಮೌಲ್ಯಯುತ ಎಂಬುದನ್ನು 'ಮಾತು ಬೆಳ್ಳಿ, ಮೌನ ಬಂಗಾರ' ಸೂಚಿಸುತ್ತದೆ."
                )
            )
        }

    val generalEnglishQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscGeneralEnglish") {
            listOf(
                QuestionModel(
                    id = "kpsc_eng_u1_q1",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Choose the correct passive voice of: \"The committee approved the proposal.\"",
                    options = listOf(
                        "The proposal was approved by the committee.",
                        "The proposal is approved by the committee.",
                        "The proposal has been approved by the committee.",
                        "The committee was approved by the proposal."
                    ),
                    correctAnswer = "The proposal was approved by the committee.",
                    explanation = "Simple past tense ('approved') converts to 'was/were + past participle' ('was approved') in passive voice."
                ),
                QuestionModel(
                    id = "kpsc_eng_u1_q2",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Fill in the blank with the appropriate preposition: \"She has been working in this office ______ 2019.\"",
                    options = listOf("since", "for", "from", "by"),
                    correctAnswer = "since",
                    explanation = "'Since' is used with a specific starting point in time (2019), whereas 'for' is used with a duration."
                ),
                QuestionModel(
                    id = "kpsc_eng_u1_q3",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Identify the part of speech of the word 'fluently' in: \"He spoke fluently during the interview.\"",
                    options = listOf("Adverb", "Adjective", "Verb", "Preposition"),
                    correctAnswer = "Adverb",
                    explanation = "'Fluently' modifies the verb 'spoke' by describing how he spoke, making it an adverb of manner."
                ),
                QuestionModel(
                    id = "kpsc_eng_u1_q4",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Choose the grammatically correct sentence:",
                    options = listOf(
                        "Neither of the candidates was selected.",
                        "Neither of the candidates were selected.",
                        "Neither of the candidate was selected.",
                        "Neither of the candidates are selected."
                    ),
                    correctAnswer = "Neither of the candidates was selected.",
                    explanation = "'Neither of + plural noun' takes a singular verb ('was')."
                ),
                QuestionModel(
                    id = "kpsc_eng_u1_q5",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Fill in the blank with the correct article: \"He is ______ honest officer.\"",
                    options = listOf("an", "a", "the", "no article"),
                    correctAnswer = "an",
                    explanation = "The 'h' in 'honest' is silent, so it begins with a vowel sound and takes the indefinite article 'an'."
                ),
                QuestionModel(
                    id = "kpsc_eng_u2_q1",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Choose the word most similar in meaning (synonym) to 'ABUNDANT':",
                    options = listOf("Plentiful", "Scarce", "Brief", "Fragile"),
                    correctAnswer = "Plentiful",
                    explanation = "'Abundant' means existing in large quantities, which is synonymous with 'plentiful'."
                ),
                QuestionModel(
                    id = "kpsc_eng_u2_q2",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Choose the word opposite in meaning (antonym) to 'BENEVOLENT':",
                    options = listOf("Malevolent", "Kind", "Generous", "Helpful"),
                    correctAnswer = "Malevolent",
                    explanation = "'Benevolent' means well-meaning and kind; its direct antonym is 'malevolent' (wishing evil to others)."
                ),
                QuestionModel(
                    id = "kpsc_eng_u2_q3",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "What does the idiom \"Break the ice\" mean?",
                    options = listOf(
                        "To initiate a conversation in an awkward situation",
                        "To end a long friendship",
                        "To cool down water",
                        "To postpone an important meeting"
                    ),
                    correctAnswer = "To initiate a conversation in an awkward situation",
                    explanation = "'Break the ice' means to do or say something to relieve tension and get conversation started."
                ),
                QuestionModel(
                    id = "kpsc_eng_u2_q4",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Give a one-word substitute for: \"A person who knows and speaks many languages.\"",
                    options = listOf("Polyglot", "Philanthropist", "Monologue", "Bibliophile"),
                    correctAnswer = "Polyglot",
                    explanation = "A 'polyglot' is someone who knows and is able to use several languages."
                ),
                QuestionModel(
                    id = "kpsc_eng_u2_q5",
                    stdId = 15,
                    subjectId = "kpsc_english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Choose the correctly spelt word:",
                    options = listOf("Accommodation", "Acommodation", "Accomodation", "Acomodation"),
                    correctAnswer = "Accommodation",
                    explanation = "'Accommodation' is spelled with double 'c' and double 'm'."
                )
            )
        }

    val generalKnowledgeQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscGeneralKnowledge") {
            listOf(
                QuestionModel(
                    id = "kpsc_gk_u1_q1",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕರ್ನಾಟಕದ ರಾಜ್ಯ ಪಕ್ಷಿ ಯಾವುದು?",
                    options = listOf("ನೀಲಕಂಠ (Indian Roller)", "ನವಿಲು", "ಕೋಗಿಲೆ", "ಹಂಸ"),
                    correctAnswer = "ನೀಲಕಂಠ (Indian Roller)",
                    explanation = "ನೀಲಕಂಠ (Indian Roller / Coracias benghalensis) ಕರ್ನಾಟಕ ರಾಜ್ಯದ ಅಧಿಕೃತ ರಾಜ್ಯ ಪಕ್ಷಿಯಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_gk_u1_q2",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಭಾರತದ ರಾಷ್ಟ್ರೀಯ ಗೀತೆ 'ವಂದೇ ಮಾತರಂ' ಅನ್ನು ರಚಿಸಿದವರು ಯಾರು?",
                    options = listOf("ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿ", "ರವೀಂದ್ರನಾಥ ಟ್ಯಾಗೋರ್", "ಸರೋಜಿನಿ ನಾಯ್ಡು", "ಸುಬ್ರಮಣ್ಯ ಭಾರತಿ"),
                    correctAnswer = "ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿ",
                    explanation = "ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿ ಅವರು ತಮ್ಮ 'ಆನಂದಮಠ' ಕಾದಂಬರಿಯಲ್ಲಿ 'ವಂದೇ ಮಾತರಂ' ಗೀತೆಯನ್ನು ರಚಿಸಿದರು."
                ),
                QuestionModel(
                    id = "kpsc_gk_u1_q3",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕರ್ನಾಟಕದ ಅತಿ ಎತ್ತರದ ಶಿಖರ ಯಾವುದು?",
                    options = listOf("ಮುಳ್ಳಯ್ಯನಗಿರಿ", "ಕುದುರೆಮುಖ", "ಪುಷ್ಪಗಿರಿ", "ಕೊಡಚಾದ್ರಿ"),
                    correctAnswer = "ಮುಳ್ಳಯ್ಯನಗಿರಿ",
                    explanation = "ಚಿಕ್ಕಮಗಳೂರು ಜಿಲ್ಲೆಯ ಬಾಬಾಬುಡನ್‌ಗಿರಿ ಶ್ರೇಣಿಯಲ್ಲಿರುವ ಮುಳ್ಳಯ್ಯನಗಿರಿ (1,925 ಮೀ.) ಕರ್ನಾಟಕದ ಅತಿ ಎತ್ತರದ ಶಿಖರವಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_gk_u1_q4",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಭಾರತದ ಸಂವಿಧಾನವು ಯಾವ ದಿನಾಂಕದಂದು ಅಧಿಕೃತವಾಗಿ ಜಾರಿಗೆ ಬಂದಿತು?",
                    options = listOf("ಜನವರಿ 26, 1950", "ನವೆಂಬರ್ 26, 1949", "ಆಗಸ್ಟ್ 15, 1947", "ಜನವರಿ 26, 1949"),
                    correctAnswer = "ಜನವರಿ 26, 1950",
                    explanation = "ನವೆಂಬರ್ 26, 1949 ರಂದು ಸಂವಿಧಾನ ಅಂಗೀಕಾರಗೊಂಡು, ಜನವರಿ 26, 1950 ರಂದು ಜಾರಿಗೆ ಬಂದಿತು."
                ),
                QuestionModel(
                    id = "kpsc_gk_u1_q5",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕರ್ನಾಟಕದಲ್ಲಿ ಅತಿ ಹೆಚ್ಚು ಜಿಲ್ಲೆಗಳನ್ನು ಹೊಂದಿರುವ ಕಂದಾಯ ವಿಭಾಗ ಯಾವುದು?",
                    options = listOf("ಬೆಂಗಳೂರು ವಿಭಾಗ", "ಮೈಸೂರು ವಿಭಾಗ", "ಬೆಳಗಾವಿ ವಿಭಾಗ", "ಕಲಬುರಗಿ ವಿಭಾಗ"),
                    correctAnswer = "ಬೆಂಗಳೂರು ವಿಭಾಗ",
                    explanation = "ಬೆಂಗಳೂರು ಕಂದಾಯ ವಿಭಾಗವು ಒಟ್ಟು 9 ಜಿಲ್ಲೆಗಳನ್ನು ಹೊಂದಿದ್ದು, ಕರ್ನಾಟಕದಲ್ಲಿ ಅತಿ ಹೆಚ್ಚು ಜಿಲ್ಲೆಗಳನ್ನು ಒಳಗೊಂಡ ವಿಭಾಗವಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_gk_u2_q1",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಭಾರತದ ಅತ್ಯುನ್ನತ ನಾಗರಿಕ ಪ್ರಶಸ್ತಿ ಯಾವುದು?",
                    options = listOf("ಭಾರತ ರತ್ನ", "ಪದ್ಮ ವಿಭೂಷಣ", "ಪದ್ಮ ಭೂಷಣ", "ಪದ್ಮಶ್ರೀ"),
                    correctAnswer = "ಭಾರತ ರತ್ನ",
                    explanation = "1954ರಲ್ಲಿ ಸ್ಥಾಪಿಸಲಾದ 'ಭಾರತ ರತ್ನ' ಭಾರತದ ಅತ್ಯುನ್ನತ ನಾಗರಿಕ ಪುರಸ್ಕಾರವಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_gk_u2_q2",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ವಿಶ್ವಸಂಸ್ಥೆಯ (UNO) ಕೇಂದ್ರ ಕಚೇರಿ ಎಲ್ಲಿದೆ?",
                    options = listOf("ನ್ಯೂಯಾರ್ಕ್", "ಜಿನೀವಾ", "ಪ್ಯಾರಿಸ್", "ಲಂಡನ್"),
                    correctAnswer = "ನ್ಯೂಯಾರ್ಕ್",
                    explanation = "ವಿಶ್ವಸಂಸ್ಥೆಯ (United Nations) ಪ್ರಧಾನ ಕಚೇರಿಯು ಅಮೆರಿಕದ ನ್ಯೂಯಾರ್ಕ್ ನಗರದಲ್ಲಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_gk_u2_q3",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ರಾಷ್ಟ್ರೀಯ ವಿಜ್ಞಾನ ದಿನವನ್ನು (National Science Day) ಪ್ರತಿ ವರ್ಷ ಯಾವ ದಿನದಂದು ಆಚರಿಸಲಾಗುತ್ತದೆ?",
                    options = listOf("ಫೆಬ್ರವರಿ 28", "ಜನವರಿ 12", "ಜೂನ್ 5", "ಡಿಸೆಂಬರ್ 22"),
                    correctAnswer = "ಫೆಬ್ರವರಿ 28",
                    explanation = "ಸರ್ ಸಿ.ವಿ. ರಾಮನ್ ಅವರು 'ರಾಮನ್ ಪರಿಣಾಮ'ವನ್ನು ಆವಿಷ್ಕರಿಸಿದ ನೆನಪಿಗಾಗಿ ಫೆಬ್ರವರಿ 28ರಂದು ರಾಷ್ಟ್ರೀಯ ವಿಜ್ಞಾನ ದಿನ ಆಚರಿಸಲಾಗುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "kpsc_gk_u2_q4",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ವಿಶ್ವ ಆರೋಗ್ಯ ಸಂಸ್ಥೆಯ (WHO) ಕೇಂದ್ರ ಕಚೇರಿ ಎಲ್ಲಿದೆ?",
                    options = listOf("ಜಿನೀವಾ", "ರೋಮ್", "ವಿಯೆನ್ನಾ", "ವಾಷಿಂಗ್ಟನ್"),
                    correctAnswer = "ಜಿನೀವಾ",
                    explanation = "ವಿಶ್ವ ಆರೋಗ್ಯ ಸಂಸ್ಥೆಯು (WHO) ಸ್ವಿಟ್ಜರ್ಲೆಂಡ್‌ನ ಜಿನೀವಾ ನಗರದಲ್ಲಿ ತನ್ನ ಕೇಂದ್ರ ಕಚೇರಿಯನ್ನು ಹೊಂದಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_gk_u2_q5",
                    stdId = 15,
                    subjectId = "kpsc_gk",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಕ್ರೀಡಾ ಕ್ಷೇತ್ರದ ಅತ್ಯುತ್ತಮ ತರಬೇತುದಾರರಿಗೆ ನೀಡುವ ರಾಷ್ಟ್ರೀಯ ಪ್ರಶಸ್ತಿ ಯಾವುದು?",
                    options = listOf("ದ್ರೋಣಾಚಾರ್ಯ ಪ್ರಶಸ್ತಿ", "ಅರ್ಜುನ ಪ್ರಶಸ್ತಿ", "ಧ್ಯಾನ್‌ಚಂದ್ ಖೇಲ್ ರತ್ನ", "ರಾಷ್ಟ್ರೀಯ ಖೇಲ್ ಪ್ರೋತ್ಸಾಹನ"),
                    correctAnswer = "ದ್ರೋಣಾಚಾರ್ಯ ಪ್ರಶಸ್ತಿ",
                    explanation = "ಭಾರತದಲ್ಲಿ ಶ್ರೇಷ್ಠ ಕ್ರೀಡಾ ತರಬೇತುದಾರರಿಗೆ (Coaches) 1985ರಿಂದ ದ್ರೋಣಾಚಾರ್ಯ ಪ್ರಶಸ್ತಿಯನ್ನು ನೀಡಲಾಗುತ್ತಿದೆ."
                )
            )
        }

    val generalScienceQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscGeneralScienceKan") {
            listOf(
                QuestionModel(
                    id = "kpsc_sci_u1_q1",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಬಲದ (Force) ಅಂತಾರಾಷ್ಟ್ರೀಯ (SI) ಏಕಮಾನ ಯಾವುದು?",
                    options = listOf("ನ್ಯೂಟನ್ (Newton)", "ಜೌಲ್ (Joule)", "ವ್ಯಾಟ್ (Watt)", "ಪ್ಯಾಸ್ಕಲ್ (Pascal)"),
                    correctAnswer = "ನ್ಯೂಟನ್ (Newton)",
                    explanation = "ಬಲದ (Force) SI ಏಕಮಾನ ನ್ಯೂಟನ್ (N) ಆಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_sci_u1_q2",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಅಡುಗೆ ಸೋಡಾದ (Baking Soda) ರಾಸಾಯನಿಕ ಹೆಸರು ಏನು?",
                    options = listOf("ಸೋಡಿಯಂ ಬೈಕಾರ್ಬೊನೇಟ್", "ಸೋಡಿಯಂ ಕಾರ್ಬೊನೇಟ್", "ಸೋಡಿಯಂ ಕ್ಲೋರೈಡ್", "ಕ್ಯಾಲ್ಸಿಯಂ ಕಾರ್ಬೊನೇಟ್"),
                    correctAnswer = "ಸೋಡಿಯಂ ಬೈಕಾರ್ಬೊನೇಟ್",
                    explanation = "ಅಡುಗೆ ಸೋಡಾದ ರಾಸಾಯನಿಕ ಹೆಸರು ಸೋಡಿಯಂ ಬೈಕಾರ್ಬೊನೇಟ್ (NaHCO₃)."
                ),
                QuestionModel(
                    id = "kpsc_sci_u1_q3",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಭೂಮಿಯ ವಾತಾವರಣದಲ್ಲಿ ಅತಿ ಹೆಚ್ಚು ಪ್ರಮಾಣದಲ್ಲಿರುವ ಅನಿಲ ಯಾವುದು?",
                    options = listOf("ಸಾರಜನಕ (Nitrogen)", "ಆಮ್ಲಜನಕ (Oxygen)", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್", "ಆರ್ಗಾನ್"),
                    correctAnswer = "ಸಾರಜನಕ (Nitrogen)",
                    explanation = "ವಾತಾವರಣದಲ್ಲಿ ಸುಮಾರು 78% ಸಾರಜನಕ (Nitrogen) ಮತ್ತು 21% ಆಮ್ಲಜನಕ (Oxygen) ಇರುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "kpsc_sci_u1_q4",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಸಾಮಾನ್ಯ ತಾಪಮಾನದಲ್ಲಿ ದ್ರವ ರೂಪದಲ್ಲಿರುವ ಲೋಹ ಯಾವುದು?",
                    options = listOf("ಪಾದರಸ (Mercury)", "ಬ್ರೋಮಿನ್", "ಸೋಡಿಯಂ", "ಕಬ್ಬಿಣ"),
                    correctAnswer = "ಪಾದರಸ (Mercury)",
                    explanation = "ಪಾದರಸ (Hg) ಕೋಣೆಯ ಉಷ್ಣಾಂಶದಲ್ಲಿ ದ್ರವ ರೂಪದಲ್ಲಿರುವ ಲೋಹವಾಗಿದ್ದು, ಬ್ರೋಮಿನ್ ದ್ರವ ರೂಪದ ಅಲೋಹವಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_sci_u1_q5",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಧ್ವನಿಯ ವೇಗವು ಈ ಕೆಳಗಿನ ಯಾವ ಮಾಧ್ಯಮದಲ್ಲಿ ಗರಿಷ್ಠವಾಗಿರುತ್ತದೆ?",
                    options = listOf("ಘನ ವಸ್ತುಗಳಲ್ಲಿ (Solids)", "ದ್ರವಗಳಲ್ಲಿ (Liquids)", "ಅನಿಲಗಳಲ್ಲಿ (Gases)", "ನಿರ್ವಾತದಲ್ಲಿ (Vacuum)"),
                    correctAnswer = "ಘನ ವಸ್ತುಗಳಲ್ಲಿ (Solids)",
                    explanation = "ಘನ ವಸ್ತುಗಳಲ್ಲಿ ಕಣಗಳು ಅತಿ ಹತ್ತಿರದಲ್ಲಿರುವುದರಿಂದ ಧ್ವನಿಯ ವೇಗ ಗರಿಷ್ಠವಾಗಿರುತ್ತದೆ; ನಿರ್ವಾತದಲ್ಲಿ ಧ್ವನಿ ಚಲಿಸುವುದಿಲ್ಲ."
                ),
                QuestionModel(
                    id = "kpsc_sci_u2_q1",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಮಾನವನ ದೇಹದಲ್ಲಿ ರಕ್ತವನ್ನು ಸೋಸಿ ಶುದ್ಧೀಕರಿಸುವ ಪ್ರಮುಖ ಅಂಗ ಯಾವುದು?",
                    options = listOf("ಮೂತ್ರಪಿಂಡಗಳು (Kidneys)", "ಜಠರ", "ಮೇದೋಜೀರಕ ಗ್ರಂಥಿ", "ಪಿತ್ತಕೋಶ"),
                    correctAnswer = "ಮೂತ್ರಪಿಂಡಗಳು (Kidneys)",
                    explanation = "ಮೂತ್ರಪಿಂಡಗಳಲ್ಲಿರುವ ನೆಫ್ರಾನ್‌ಗಳು ರಕ್ತದಲ್ಲಿನ ತ್ಯಾಜ್ಯಗಳನ್ನು ಸೋಸಿ ಮೂತ್ರದ ರೂಪದಲ್ಲಿ ಹೊರಹಾಕುತ್ತವೆ."
                ),
                QuestionModel(
                    id = "kpsc_sci_u2_q2",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ವಿಟಮಿನ್ 'C' ಕೊರತೆಯಿಂದ ಉಂಟಾಗುವ ರೋಗ ಯಾವುದು?",
                    options = listOf("ಸ್ಕರ್ವಿ (Scurvy)", "ರಿಕೆಟ್ಸ್", "ಬೆರಿಬೆರಿ", "ಇರುಳುಕುರುಡು"),
                    correctAnswer = "ಸ್ಕರ್ವಿ (Scurvy)",
                    explanation = "ವಿಟಮಿನ್ 'C' (ಆಸ್ಕಾರ್ಬಿಕ್ ಆಮ್ಲ) ಕೊರತೆಯಿಂದ ವಸಡುಗಳಲ್ಲಿ ರಕ್ತಸ್ರಾವವಾಗುವ 'ಸ್ಕರ್ವಿ' ರೋಗ ಉಂಟಾಗುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "kpsc_sci_u2_q3",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಜೀವಕೋಶದ 'ಶಕ್ತಿ ಉತ್ಪಾದನಾ ಕೇಂದ್ರ' (Powerhouse of the Cell) ಎಂದು ಯಾವುದನ್ನು ಕರೆಯುತ್ತಾರೆ?",
                    options = listOf("ಮೈಟೋಕಾಂಡ್ರಿಯಾ", "ರೈಬೋಸೋಮ್", "ಲೈಸೋಸೋಮ್", "ಗಾಲ್ಗಿ ಸಂಕೀರ್ಣ"),
                    correctAnswer = "ಮೈಟೋಕಾಂಡ್ರಿಯಾ",
                    explanation = "ಮೈಟೋಕಾಂಡ್ರಿಯಾವು ಜೀವಕೋಶಕ್ಕೆ ಅಗತ್ಯವಾದ ಶಕ್ತಿಯನ್ನು ATP ರೂಪದಲ್ಲಿ ಉತ್ಪಾದಿಸುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "kpsc_sci_u2_q4",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಸಸ್ಯಗಳು ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆ (Photosynthesis) ಕ್ರಿಯೆಯಲ್ಲಿ ಯಾವ ಅನಿಲವನ್ನು ಬಿಡುಗಡೆ ಮಾಡುತ್ತವೆ?",
                    options = listOf("ಆಮ್ಲಜನಕ (Oxygen)", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್", "ಸಾರಜನಕ", "ಮೀಥೇನ್"),
                    correctAnswer = "ಆಮ್ಲಜನಕ (Oxygen)",
                    explanation = "ಸಸ್ಯಗಳು ಸೂರ್ಯನ ಬೆಳಕಿನಲ್ಲಿ ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ ಮತ್ತು ನೀರನ್ನು ಬಳಸಿ ಆಹಾರ ತಯಾರಿಸಿ, ಆಮ್ಲಜನಕವನ್ನು ಬಿಡುಗಡೆ ಮಾಡುತ್ತವೆ."
                ),
                QuestionModel(
                    id = "kpsc_sci_u2_q5",
                    stdId = 15,
                    subjectId = "kpsc_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಮಾನವನ ರಕ್ತದಲ್ಲಿ ಆಮ್ಲಜನಕವನ್ನು ಸಾಗಿಸುವ ವರ್ಣದ್ರವ್ಯ ಯಾವುದು?",
                    options = listOf("ಹಿಮೋಗ್ಲೋಬಿನ್", "ಕ್ಲೋರೋಫಿಲ್", "ಮೆಲನಿನ್", "ಇನ್ಸುಲಿನ್"),
                    correctAnswer = "ಹಿಮೋಗ್ಲೋಬಿನ್",
                    explanation = "ಕೆಂಪು ರಕ್ತಕಣಗಳಲ್ಲಿರುವ ಕಬ್ಬಿಣಯುಕ್ತ 'ಹಿಮೋಗ್ಲೋಬಿನ್' ದೇಹದ ಎಲ್ಲಾ ಭಾಗಗಳಿಗೆ ಆಮ್ಲಜನಕವನ್ನು ಪೂರೈಸುತ್ತದೆ."
                )
            )
        }

    val kannadaGrammarQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscKannadaGrammar") {
            listOf(
                QuestionModel(
                    id = "kpsc_kgram_u1_q1",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿರುವ ಒಟ್ಟು ಅಕ್ಷರಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
                    options = listOf("49", "45", "52", "47"),
                    correctAnswer = "49",
                    explanation = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ 13 ಸ್ವರಗಳು, 2 ಯೋಗವಾಹಗಳು ಮತ್ತು 34 ವ್ಯಂಜನಗಳು ಸೇರಿ ಒಟ್ಟು 49 ಅಕ್ಷರಗಳಿವೆ."
                ),
                QuestionModel(
                    id = "kpsc_kgram_u1_q2",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "'ಮಳೆಗಾಲ' (ಮಳೆ + ಕಾಲ) ಪದವು ಯಾವ ಸಂಧಿಗೆ ಉದಾಹರಣೆಯಾಗಿದೆ?",
                    options = listOf("ಆದೇಶ ಸಂಧಿ", "ಲೋಪ ಸಂಧಿ", "ಆಗಮ ಸಂಧಿ", "ಗುಣ ಸಂಧಿ"),
                    correctAnswer = "ಆದೇಶ ಸಂಧಿ",
                    explanation = "ಉತ್ತರಪದದ ಆದಿಯ 'ಕ' ಕಾರಕ್ಕೆ 'ಗ' ಕಾರ ಆದೇಶವಾಗಿ ಬಂದಿರುವುದರಿಂದ ಇದು ಆದೇಶ ಸಂಧಿಯಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_kgram_u1_q3",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "'ಅರಮನೆ' (ಅರಸನ + ಮನೆ) ಪದವು ಯಾವ ಸಮಾಸಕ್ಕೆ ಉದಾಹರಣೆಯಾಗಿದೆ?",
                    options = listOf("ತತ್ಪುರುಷ ಸಮಾಸ", "ದ್ವಂದ್ವ ಸಮಾಸ", "ದ್ವಿಗು ಸಮಾಸ", "ಕರ್ಮಧಾರಯ ಸಮಾಸ"),
                    correctAnswer = "ತತ್ಪುರುಷ ಸಮಾಸ",
                    explanation = "ಪೂರ್ವಪದವು ಷಷ್ಠೀ ವಿಭಕ್ತಿಯಿಂದ ಕೂಡಿ ಉತ್ತರಪದದ ಅರ್ಥ ಪ್ರಧಾನವಾಗಿರುವುದರಿಂದ ಇದು ತತ್ಪುರುಷ ಸಮಾಸವಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_kgram_u1_q4",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "'ದೇವಾಲಯ' (ದೇವ + ಆಲಯ) ಪದದಲ್ಲಿರುವ ಸಂಧಿ ಯಾವುದು?",
                    options = listOf("ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ", "ವೃದ್ಧಿ ಸಂಧಿ", "ಯಣ್ ಸಂಧಿ", "ಜಶ್ತ್ವ ಸಂಧಿ"),
                    correctAnswer = "ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ",
                    explanation = "'ಅ + ಆ = ಆ' ಎಂದು ಸವರ್ಣ ಸ್ವರಗಳು ಸೇರಿ ದೀರ್ಘ ಸ್ವರ ಆದೇಶವಾಗುವುದರಿಂದ ಇದು ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ."
                ),
                QuestionModel(
                    id = "kpsc_kgram_u1_q5",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "'ಮುಕ್ಕಣ್ಣ' (ಮೂರು ಕಣ್ಣುಗಳುಳ್ಳವನು - ಶಿವ) ಪದವು ಯಾವ ಸಮಾಸಕ್ಕೆ ಉದಾಹರಣೆಯಾಗಿದೆ?",
                    options = listOf("ಬಹುವ್ರೀಹಿ ಸಮಾಸ", "ದ್ವಿಗು ಸಮಾಸ", "ಅಂಶಿ ಸಮಾಸ", "ಕ್ರಿಯಾ ಸಮಾಸ"),
                    correctAnswer = "ಬಹುವ್ರೀಹಿ ಸಮಾಸ",
                    explanation = "ಪೂರ್ವ ಮತ್ತು ಉತ್ತರ ಪದಗಳೆರಡೂ ಸೇರಿ ಬೇರೊಂದು ಅನ್ಯಪದದ (ಶಿವ) ಅರ್ಥವನ್ನು ಸೂಚಿಸುವುದರಿಂದ ಇದು ಬಹುವ್ರೀಹಿ ಸಮಾಸವಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_kgram_u2_q1",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡದಲ್ಲಿ 'ತೃತೀಯಾ ವಿಭಕ್ತಿ' ಪ್ರತ್ಯಯ ಯಾವುದು?",
                    options = listOf("ಇಂದ", "ಅನ್ನು", "ಗೆ, ಇಗೆ, ಕ್ಕೆ", "ಅಲ್ಲಿ"),
                    correctAnswer = "ಇಂದ",
                    explanation = "ಕನ್ನಡದ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯಗಳಲ್ಲಿ ತೃತೀಯಾ ವಿಭಕ್ತಿಯ ಪ್ರತ್ಯಯ 'ಇಂದ' (ಕರಣಾರ್ಥಕ) ಆಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_kgram_u2_q2",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "'ವರ್ಷ' ಎಂಬ ತತ್ಸಮ ಪದದ ತದ್ಭವ ರೂಪ ಯಾವುದು?",
                    options = listOf("ವರುಷ", "ಮಳೆ", "ವರ್ಷಣ", "ವಾರ್ಷಿಕ"),
                    correctAnswer = "ವರುಷ",
                    explanation = "ಸಂಸ್ಕೃತದ 'ವರ್ಷ' ಎಂಬ ತತ್ಸಮ ಪದವು ಕನ್ನಡದಲ್ಲಿ 'ವರುಷ' ಎಂದು ತದ್ಭವ ರೂಪ ಪಡೆಯುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "kpsc_kgram_u2_q3",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "'ಹಕ್ಕಿ' ಎಂಬ ತದ್ಭವ ಪದದ ತತ್ಸಮ ರೂಪ ಯಾವುದು?",
                    options = listOf("ಪಕ್ಷಿ", "ಖಗ", "ವಿಹಗ", "ಪಕ್ಷ"),
                    correctAnswer = "ಪಕ್ಷಿ",
                    explanation = "'ಪಕ್ಷಿ' ತತ್ಸಮ ಪದದ ಕನ್ನಡ ತದ್ಭವ ರೂಪ 'ಹಕ್ಕಿ'."
                ),
                QuestionModel(
                    id = "kpsc_kgram_u2_q4",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಎರಡು ವಸ್ತುಗಳ ನಡುವೆ ಪರಸ್ಪರ ಹೋಲಿಕೆಯನ್ನು ವರ್ಣಿಸುವ ಅಲಂಕಾರ ಯಾವುದು?",
                    options = listOf("ಉಪಮಾಲಂಕಾರ", "ರೂಪಕಾಲಂಕಾರ", "ಉತ್ಪ್ರೇಕ್ಷಾಲಂಕಾರ", "ಶ್ಲೇಷಾಲಂಕಾರ"),
                    correctAnswer = "ಉಪಮಾಲಂಕಾರ",
                    explanation = "ಉಪಮೇಯವನ್ನು ಉಪಮಾನಕ್ಕೆ 'ಅಂತೆ, ಹಾಗೆ, ವೊಲ್' ಮುಂತಾದ ವಾಚಕ ಪದಗಳಿಂದ ಹೋಲಿಸಿ ವರ್ಣಿಸುವುದೇ ಉಪಮಾಲಂಕಾರ."
                ),
                QuestionModel(
                    id = "kpsc_kgram_u2_q5",
                    stdId = 15,
                    subjectId = "kpsc_kannada_grammar",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಕ್ರಿಯಾಪದದ ಮೂಲ ರೂಪವನ್ನು ಕನ್ನಡ ವ್ಯಾಕರಣದಲ್ಲಿ ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
                    options = listOf("ಧಾತು", "ಪ್ರತ್ಯಯ", "ಅವ್ಯಯ", "ನಾಮಪ್ರಕೃತಿ"),
                    correctAnswer = "ಧಾತು",
                    explanation = "ಕ್ರಿಯಾಪದದ ಮೂಲ ರೂಪವನ್ನು 'ಧಾತು' ಅಥವಾ 'ಕ್ರಿಯಾಪ್ರಕೃತಿ' ಎಂದು ಕರೆಯಲಾಗುತ್ತದೆ (ಉದಾ: ಮಾಡು, ಓದು, ಬರೆ)."
                )
            )
        }

    val computerKnowledgeQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscComputerKnowledge") {
            listOf(
                QuestionModel(
                    id = "kpsc_comp_u1_q1",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕಂಪ್ಯೂಟರ್‌ನ 'ಮೆದುಳು' (Brain of the Computer) ಎಂದು ಯಾವ ಭಾಗವನ್ನು ಕರೆಯುತ್ತಾರೆ?",
                    options = listOf("CPU (ಸೆಂಟ್ರಲ್ ಪ್ರೊಸೆಸಿಂಗ್ ಯೂನಿಟ್)", "ಮಾನಿಟರ್", "ಕೀಬೋರ್ಡ್", "ಪ್ರಿಂಟರ್"),
                    correctAnswer = "CPU (ಸೆಂಟ್ರಲ್ ಪ್ರೊಸೆಸಿಂಗ್ ಯೂನಿಟ್)",
                    explanation = "CPU ಕಂಪ್ಯೂಟರ್‌ನ ಎಲ್ಲಾ ಗಣನೆ ಮತ್ತು ನಿಯಂತ್ರಣ ಕಾರ್ಯಗಳನ್ನು ನಿರ್ವಹಿಸುವುದರಿಂದ ಇದನ್ನು ಕಂಪ್ಯೂಟರ್‌ನ ಮೆದುಳು ಎನ್ನುತ್ತಾರೆ."
                ),
                QuestionModel(
                    id = "kpsc_comp_u1_q2",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "'RAM' ನ ವಿಸ್ತೃತ ರೂಪ ಯಾವುದು?",
                    options = listOf(
                        "Random Access Memory",
                        "Read Always Memory",
                        "Rapid Action Module",
                        "Remote Access Machine"
                    ),
                    correctAnswer = "Random Access Memory",
                    explanation = "RAM ಎಂದರೆ Random Access Memory — ಇದು ಕಂಪ್ಯೂಟರ್‌ನ ಪ್ರಾಥಮಿಕ ತಾತ್ಕಾಲಿಕ ಮೆಮೊರಿಯಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "kpsc_comp_u1_q3",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು 'ಇನ್‌ಪುಟ್ ಸಾಧನ' (Input Device) ಆಗಿದೆ?",
                    options = listOf("ಕೀಬೋರ್ಡ್ (Keyboard)", "ಮಾನಿಟರ್ (Monitor)", "ಪ್ರಿಂಟರ್ (Printer)", "ಸ್ಪೀಕರ್ (Speaker)"),
                    correctAnswer = "ಕೀಬೋರ್ಡ್ (Keyboard)",
                    explanation = "ಕೀಬೋರ್ಡ್ ಮೂಲಕ ದತ್ತಾಂಶವನ್ನು ಕಂಪ್ಯೂಟರ್‌ಗೆ ನೀಡಲಾಗುತ್ತದೆ; ಮಾನಿಟರ್, ಪ್ರಿಂಟರ್ ಮತ್ತು ಸ್ಪೀಕರ್ ಔಟ್‌ಪುಟ್ ಸಾಧನಗಳಾಗಿವೆ."
                ),
                QuestionModel(
                    id = "kpsc_comp_u1_q4",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "1 ಕಿಲೋಬೈಟ್ (1 KB) ಎಂದರೆ ಎಷ್ಟು ಬೈಟ್‌ಗಳು?",
                    options = listOf("1024 ಬೈಟ್‌ಗಳು", "1000 ಬೈಟ್‌ಗಳು", "512 ಬೈಟ್‌ಗಳು", "2048 ಬೈಟ್‌ಗಳು"),
                    correctAnswer = "1024 ಬೈಟ್‌ಗಳು",
                    explanation = "ದ್ವಿಮಾನ (Binary) ಪದ್ಧತಿಯ ಪ್ರಕಾರ 1 ಕಿಲೋಬೈಟ್ (KB) = 2¹⁰ = 1024 ಬೈಟ್‌ಗಳು."
                ),
                QuestionModel(
                    id = "kpsc_comp_u1_q5",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕಂಪ್ಯೂಟರ್ ಆಫ್ ಮಾಡಿದಾಗ ತನ್ನಲ್ಲಿರುವ ದತ್ತಾಂಶವನ್ನು ಕಳೆದುಕೊಳ್ಳುವ ತಾತ್ಕಾಲಿಕ (Volatile) ಮೆಮೊರಿ ಯಾವುದು?",
                    options = listOf("RAM", "ROM", "ಹಾರ್ಡ್ ಡಿಸ್ಕ್", "ಪೆನ್ ಡ್ರೈವ್"),
                    correctAnswer = "RAM",
                    explanation = "RAM ತಾತ್ಕಾಲಿಕ (Volatile) ಮೆಮೊರಿಯಾಗಿದ್ದು, ವಿದ್ಯುತ್ ಸ್ಥಗಿತಗೊಂಡಾಗ ಅದರಲ್ಲಿರುವ ಮಾಹಿತಿ ಅಳಿಸಿಹೋಗುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "kpsc_comp_u2_q1",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಇಂಟರ್ನೆಟ್‌ನಲ್ಲಿ ಬಳಸುವ 'WWW' ನ ವಿಸ್ತೃತ ರೂಪ ಯಾವುದು?",
                    options = listOf(
                        "World Wide Web",
                        "World Web Window",
                        "Wide World Wire",
                        "Web World Work"
                    ),
                    correctAnswer = "World Wide Web",
                    explanation = "ಟಿಮ್ ಬರ್ನರ್ಸ್-ಲೀ ಅವರು 1989ರಲ್ಲಿ ಆವಿಷ್ಕರಿಸಿದ WWW ನ ವಿಸ್ತೃತ ರೂಪ World Wide Web."
                ),
                QuestionModel(
                    id = "kpsc_comp_u2_q2",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "MS Word ನಲ್ಲಿ ದಾಖಲೆಯನ್ನು (Document) ಸೇವ್ ಮಾಡಲು ಬಳಸುವ ಶಾರ್ಟ್‌ಕಟ್ ಕೀ ಯಾವುದು?",
                    options = listOf("Ctrl + S", "Ctrl + C", "Ctrl + V", "Ctrl + P"),
                    correctAnswer = "Ctrl + S",
                    explanation = "Ctrl + S ಸೇವ್ ಮಾಡಲು, Ctrl + C ಕಾಪಿ ಮಾಡಲು, Ctrl + V ಪೇಸ್ಟ್ ಮಾಡಲು ಮತ್ತು Ctrl + P ಪ್ರಿಂಟ್ ಮಾಡಲು ಬಳಸಲಾಗುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "kpsc_comp_u2_q3",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "MS Excel ನಲ್ಲಿ ಪ್ರತಿ ಫಾರ್ಮುಲಾ (Formula) ಯಾವ ಚಿಹ್ನೆಯಿಂದ ಪ್ರಾರಂಭವಾಗುತ್ತದೆ?",
                    options = listOf("=", "+", "#", "@"),
                    correctAnswer = "=",
                    explanation = "MS Excel ನಲ್ಲಿ ಯಾವುದೇ ಗಣಿತದ ಸೂತ್ರ ಅಥವಾ ಫಂಕ್ಷನ್ ಯಾವಾಗಲೂ '=' ಚಿಹ್ನೆಯಿಂದಲೇ ಪ್ರಾರಂಭವಾಗಬೇಕು."
                ),
                QuestionModel(
                    id = "kpsc_comp_u2_q4",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "'HTTPS' ಎಂಬ ವೆಬ್ ಪ್ರೋಟೋಕಾಲ್‌ನಲ್ಲಿ 'S' ಅಕ್ಷರವು ಏನನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
                    options = listOf("Secure", "System", "Server", "Speed"),
                    correctAnswer = "Secure",
                    explanation = "HTTPS ಎಂದರೆ HyperText Transfer Protocol Secure — ಇದು ದತ್ತಾಂಶವನ್ನು ಎನ್‌ಕ್ರಿಪ್ಟ್ ಮಾಡಿ ಸುರಕ್ಷಿತವಾಗಿ ರವಾನಿಸುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "kpsc_comp_u2_q5",
                    stdId = 15,
                    subjectId = "kpsc_computer",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಅನಪೇಕ್ಷಿತ (Unsolicited) ಬಲ್ಕ್ ಇ-ಮೇಲ್‌ಗಳನ್ನು ಸಾಮಾನ್ಯವಾಗಿ ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
                    options = listOf("ಸ್ಪ್ಯಾಮ್ (Spam)", "ಫೈರ್‌ವಾಲ್ (Firewall)", "ಕುಕೀಸ್ (Cookies)", "ಕ್ಯಾಶ್ (Cache)"),
                    correctAnswer = "ಸ್ಪ್ಯಾಮ್ (Spam)",
                    explanation = "ಬಳಕೆದಾರರ ಅನುಮತಿಯಿಲ್ಲದೆ ಕಳುಹಿಸಲಾಗುವ ಅನಗತ್ಯ ಜಾಹೀರಾತು ಅಥವಾ ಬಲ್ಕ್ ಇ-ಮೇಲ್‌ಗಳನ್ನು 'ಸ್ಪ್ಯಾಮ್' ಎನ್ನುತ್ತಾರೆ."
                )
            )
        }

    val allQuestions: List<QuestionModel>
        get() = generalKannadaQuestions +
            generalEnglishQuestions +
            generalKnowledgeQuestions +
            generalScienceQuestions +
            kannadaGrammarQuestions +
            computerKnowledgeQuestions
}
