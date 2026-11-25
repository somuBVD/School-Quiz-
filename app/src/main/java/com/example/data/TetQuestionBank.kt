package com.example.data

/**
 * Teacher Eligibility Test (KAR-TET / CTET) Question Bank.
 * Standard / Exam ID: 13.
 * Covers: Child Development & Pedagogy, Kannada Language & Pedagogy,
 * English Language & Pedagogy, Mathematics & Pedagogy, and EVS/Science & Social Pedagogy.
 */
object TetQuestionBank {

    val cdpUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Child Growth, Piaget & Vygotsky Theories", 5, "Medium"),
        UnitTemplate(2, "Unit 2: Learning Theories, Motivation & Inclusive Education", 5, "Medium"),
        UnitTemplate(3, "Unit 3: Assessment, NCF 2005 & RTE Act 2009", 5, "Hard")
    )

    val kannadaUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಕನ್ನಡ ವ್ಯಾಕರಣ ಮತ್ತು ಭಾಷಾ ಕೌಶಲ್ಯಗಳು", 5, "Easy"),
        UnitTemplate(2, "ಘಟಕ 2: ಕನ್ನಡ ಸಾಹಿತ್ಯ ಮತ್ತು ಬೋಧನಾ ವಿಧಾನಗಳು", 5, "Medium")
    )

    val englishUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: English Grammar & Vocabulary", 5, "Easy"),
        UnitTemplate(2, "Unit 2: English Language Pedagogy & Teaching Methods", 5, "Medium")
    )

    val mathUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Number System, Arithmetic & Geometry", 5, "Medium"),
        UnitTemplate(2, "Unit 2: Nature & Pedagogy of Mathematics", 5, "Hard")
    )

    val evsUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Environmental Studies & Everyday Science", 5, "Easy"),
        UnitTemplate(2, "Unit 2: Social Studies, Civics & EVS Pedagogy", 5, "Medium"),
        TetFoodAndWaterQuestionBank.unitTemplate,
        TetPlantsQuestionBank.unitTemplate,
        TetAnimalsQuestionBank.unitTemplate,
        TetEnvironmentQuestionBank.unitTemplate,
        TetNaturalResourcesQuestionBank.unitTemplate,
        TetFamilyAndTransportQuestionBank.unitTemplate,
        TetSciencePedagogyQuestionBank.unitTemplate,
        TetLivingWorldQuestionBank.unitTemplate,
        TetNaturalProcessesQuestionBank.unitTemplate,
        TetMaterialsQuestionBank.unitTemplate,
        TetHowThingsWorkQuestionBank.unitTemplate
    )

    val cdpQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetCDP") {
            listOf(
                QuestionModel(
                    id = "tet_cdp_u1_q1",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "According to Jean Piaget, during which stage of cognitive development does a child develop 'object permanence'?",
                    options = listOf("Sensorimotor stage", "Pre-operational stage", "Concrete operational stage", "Formal operational stage"),
                    correctAnswer = "Sensorimotor stage",
                    explanation = "In Piaget's Sensorimotor stage (birth to 2 years), infants learn that objects continue to exist even when out of sight (object permanence)."
                ),
                QuestionModel(
                    id = "tet_cdp_u1_q2",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "In Lev Vygotsky's sociocultural theory, what does 'ZPD' stand for?",
                    options = listOf("Zone of Proximal Development", "Zone of Primary Development", "Zero Potential Development", "Zone of Psychological Dynamics"),
                    correctAnswer = "Zone of Proximal Development",
                    explanation = "ZPD is the gap between what a learner can do independently and what they can achieve with guidance from a More Knowledgeable Other (MKO)."
                ),
                QuestionModel(
                    id = "tet_cdp_u1_q3",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which principle of development states that growth proceeds from head to toe?",
                    options = listOf("Cephalocaudal principle", "Proximodistal principle", "Principle of integration", "Principle of continuity"),
                    correctAnswer = "Cephalocaudal principle",
                    explanation = "Cephalocaudal development moves from head downward to feet, whereas proximodistal moves from the center of the body outward."
                ),
                QuestionModel(
                    id = "tet_cdp_u1_q4",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Who proposed the Theory of Multiple Intelligences identifying linguistic, logical, spatial, musical, and other intelligences?",
                    options = listOf("Howard Gardner", "Charles Spearman", "Robert Sternberg", "Alfred Binet"),
                    correctAnswer = "Howard Gardner",
                    explanation = "Howard Gardner proposed the Theory of Multiple Intelligences in 1983, challenging the idea of a single general intelligence factor."
                ),
                QuestionModel(
                    id = "tet_cdp_u1_q5",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "According to Lawrence Kohlberg, obeying rules purely to avoid punishment belongs to which level of moral development?",
                    options = listOf("Pre-conventional level", "Conventional level", "Post-conventional level", "Autonomous level"),
                    correctAnswer = "Pre-conventional level",
                    explanation = "Stage 1 (Obedience and Punishment Orientation) falls under Kohlberg's Pre-conventional level of moral reasoning."
                ),
                QuestionModel(
                    id = "tet_cdp_u2_q1",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "B.F. Skinner's theory of learning based on reinforcement and consequences is known as:",
                    options = listOf("Operant Conditioning", "Classical Conditioning", "Insight Learning", "Observational Learning"),
                    correctAnswer = "Operant Conditioning",
                    explanation = "Operant conditioning strengthens or weakens voluntary behaviors using positive/negative reinforcement or punishment."
                ),
                QuestionModel(
                    id = "tet_cdp_u2_q2",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "A student experiencing persistent difficulty in reading, decoding words, and spelling is most likely showing signs of:",
                    options = listOf("Dyslexia", "Dyscalculia", "Dysgraphia", "Dyspraxia"),
                    correctAnswer = "Dyslexia",
                    explanation = "Dyslexia affects reading and language processing; dyscalculia affects math, and dysgraphia affects handwriting."
                ),
                QuestionModel(
                    id = "tet_cdp_u2_q3",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "In Abraham Maslow's Hierarchy of Needs, which need sits at the very top of the pyramid?",
                    options = listOf("Self-actualization", "Esteem needs", "Safety needs", "Belongingness and love"),
                    correctAnswer = "Self-actualization",
                    explanation = "Self-actualization represents realizing one's full personal potential once physiological, safety, love, and esteem needs are satisfied."
                ),
                QuestionModel(
                    id = "tet_cdp_u2_q4",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Inclusive education primarily emphasizes:",
                    options = listOf(
                        "Educating children of all abilities together with necessary support",
                        "Separating gifted learners into exclusive classrooms",
                        "Focusing strictly on exam rankings",
                        "Using identical worksheets for every learner without adaptation"
                    ),
                    correctAnswer = "Educating children of all abilities together with necessary support",
                    explanation = "Inclusive education adapts teaching, curriculum, and classroom environments so every learner participates meaningfully."
                ),
                QuestionModel(
                    id = "tet_cdp_u2_q5",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which type of motivation comes from genuine curiosity and joy in learning rather than external rewards?",
                    options = listOf("Intrinsic motivation", "Extrinsic motivation", "Secondary drive", "Conditioned reflex"),
                    correctAnswer = "Intrinsic motivation",
                    explanation = "Intrinsic motivation arises from internal satisfaction and interest in the activity itself."
                ),
                QuestionModel(
                    id = "tet_cdp_u3_q1",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "The Right of Children to Free and Compulsory Education (RTE) Act, 2009 guarantees free education for children aged:",
                    options = listOf("6 to 14 years", "3 to 12 years", "5 to 16 years", "6 to 18 years"),
                    correctAnswer = "6 to 14 years",
                    explanation = "Under Article 21A and the RTE Act 2009, every child aged 6 to 14 years has a fundamental right to free and compulsory elementary education."
                ),
                QuestionModel(
                    id = "tet_cdp_u3_q2",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "What is the main purpose of Formative Assessment during instruction?",
                    options = listOf(
                        "To monitor learning and provide ongoing feedback for improvement",
                        "To issue final annual promotion certificates",
                        "To rank schools at the state level",
                        "To eliminate classroom discussions"
                    ),
                    correctAnswer = "To monitor learning and provide ongoing feedback for improvement",
                    explanation = "Formative assessment ('assessment for learning') diagnoses gaps during teaching so teachers can adjust instruction."
                ),
                QuestionModel(
                    id = "tet_cdp_u3_q3",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "According to NCF 2005, the role of a teacher in a constructivist classroom is primarily that of a:",
                    options = listOf("Facilitator", "Dictator", "Passive observer", "Strict examiner"),
                    correctAnswer = "Facilitator",
                    explanation = "NCF 2005 advocates learner-centered constructivism where teachers facilitate inquiry and active knowledge construction."
                ),
                QuestionModel(
                    id = "tet_cdp_u3_q4",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "In Revised Bloom's Taxonomy (2001), which is the highest level of the cognitive domain?",
                    options = listOf("Creating", "Evaluating", "Analyzing", "Applying"),
                    correctAnswer = "Creating",
                    explanation = "Anderson & Krathwohl's revised taxonomy orders cognitive skills as: Remember, Understand, Apply, Analyze, Evaluate, and Create."
                ),
                QuestionModel(
                    id = "tet_cdp_u3_q5",
                    stdId = 13,
                    subjectId = "cdp",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "Under NEP 2020, the existing 10+2 school structure is replaced by which curricular structure?",
                    options = listOf("5+3+3+4", "4+4+4+2", "6+3+3+2", "5+4+3+3"),
                    correctAnswer = "5+3+3+4",
                    explanation = "NEP 2020 introduces the 5+3+3+4 structure covering Foundational, Preparatory, Middle, and Secondary stages (ages 3–18)."
                )
            )
        }

    val kannadaQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetKannada") {
            listOf(
                QuestionModel(
                    id = "tet_kan_u1_q1",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡ ಭಾಷಾ ಕಲಿಕೆಯ ನಾಲ್ಕು ಮೂಲಭೂತ ಕೌಶಲ್ಯಗಳ ಸರಿಯಾದ ಕ್ರಮ ಯಾವುದು?",
                    options = listOf("ಆಲಿಸುವುದು, ಮಾತನಾಡುವುದು, ಓದುವುದು, ಬರೆಯುವುದು", "ಓದುವುದು, ಬರೆಯುವುದು, ಆಲಿಸುವುದು, ಮಾತನಾಡುವುದು", "ಬರೆಯುವುದು, ಓದುವುದು, ಮಾತನಾಡುವುದು, ಆಲಿಸುವುದು", "ಮಾತನಾಡುವುದು, ಬರೆಯುವುದು, ಓದುವುದು, ಆಲಿಸುವುದು"),
                    correctAnswer = "ಆಲಿಸುವುದು, ಮಾತನಾಡುವುದು, ಓದುವುದು, ಬರೆಯುವುದು",
                    explanation = "ಭಾಷಾ ಕೌಶಲ್ಯಗಳ ಸ್ವಾಭಾವಿಕ ಕ್ರಮ LSRW — ಆಲಿಸುವುದು (Listening), ಮಾತನಾಡುವುದು (Speaking), ಓದುವುದು (Reading), ಬರೆಯುವುದು (Writing)."
                ),
                QuestionModel(
                    id = "tet_kan_u1_q2",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "'ಮಳೆಗಾಲ' ಎಂಬ ಪದದಲ್ಲಿರುವ ಕನ್ನಡ ಸಂಧಿ ಯಾವುದು?",
                    options = listOf("ಆದೇಶ ಸಂಧಿ", "ಲೋಪ ಸಂಧಿ", "ಆಗಮ ಸಂಧಿ", "ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ"),
                    correctAnswer = "ಆದೇಶ ಸಂಧಿ",
                    explanation = "ಮಳೆ + ಕಾಲ = ಮಳೆಗಾಲ; ಇಲ್ಲಿ 'ಕ' ಕಾರದ ಸ್ಥಾನದಲ್ಲಿ 'ಗ' ಕಾರವು ಆದೇಶವಾಗಿ ಬಂದಿರುವುದರಿಂದ ಇದು ಆದೇಶ ಸಂಧಿ."
                ),
                QuestionModel(
                    id = "tet_kan_u1_q3",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡದ ಪ್ರಥಮ ಜ್ಞಾನಪೀಠ ಪ್ರಶಸ್ತಿ ಪುರಸ್ಕೃತರು ಯಾರು?",
                    options = listOf("ಕುವೆಂಪು", "ದ.ರಾ. ಬೇಂದ್ರೆ", "ಶಿವರಾಮ ಕಾರಂತ", "ಮಾಸ್ತಿ ವೆಂಕಟೇಶ ಅಯ್ಯಂಗಾರ್"),
                    correctAnswer = "ಕುವೆಂಪು",
                    explanation = "ರಾಷ್ಟ್ರಕವಿ ಕುವೆಂಪು ಅವರು 'ಶ್ರೀ ರಾಮಾಯಣ ದರ್ಶನಂ' ಮಹಾಕಾವ್ಯಕ್ಕಾಗಿ 1967ರಲ್ಲಿ ಕನ್ನಡದ ಮೊದಲ ಜ್ಞಾನಪೀಠ ಪ್ರಶಸ್ತಿ ಪಡೆದರು."
                ),
                QuestionModel(
                    id = "tet_kan_u1_q4",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "'ಮುಕ್ಕಣ್ಣ' ಎಂಬುದು ಯಾವ ಸಮಾಸಕ್ಕೆ ಉದಾಹರಣೆಯಾಗಿದೆ?",
                    options = listOf("ಬಹುವ್ರೀಹಿ ಸಮಾಸ", "ತತ್ಪುರುಷ ಸಮಾಸ", "ದ್ವಂದ್ವ ಸಮಾಸ", "ಅಂಶಿ ಸಮಾಸ"),
                    correctAnswer = "ಬಹುವ್ರೀಹಿ ಸಮಾಸ",
                    explanation = "ಮೂರು ಕಣ್ಣುಗಳು ಉಳ್ಳವನು ಯಾವನೋ ಅವನು (ಶಿವ) — ಅನ್ಯಪದದ ಅರ್ಥ ಪ್ರಧಾನವಾಗಿದ್ದರೆ ಅದು ಬಹುವ್ರೀಹಿ ಸಮಾಸ."
                ),
                QuestionModel(
                    id = "tet_kan_u1_q5",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ ಒಟ್ಟು ಎಷ್ಟು ವರ್ಗೀಯ ವ್ಯಂಜನಗಳಿವೆ?",
                    options = listOf("25", "9", "13", "34"),
                    correctAnswer = "25",
                    explanation = "ಕ-ವರ್ಗದಿಂದ ಪ-ವರ್ಗದವರೆಗೆ 5 ವರ್ಗಗಳಲ್ಲಿ ತಲಾ 5 ಅಕ್ಷರಗಳಂತೆ ಒಟ್ಟು 25 ವರ್ಗೀಯ ವ್ಯಂಜನಗಳಿವೆ."
                ),
                QuestionModel(
                    id = "tet_kan_u2_q1",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ವ್ಯಾಕರಣ ಬೋಧನೆಗೆ ಪ್ರಾಥಮಿಕ ಹಂತದಲ್ಲಿ ಅತ್ಯಂತ ಸೂಕ್ತವಾದ ಬೋಧನಾ ವಿಧಾನ ಯಾವುದು?",
                    options = listOf("ಆಗಮನ ವಿಧಾನ (Inductive Method)", "ನಿಗಮನ ವಿಧಾನ (Deductive Method)", "ಉಪನ್ಯಾಸ ವಿಧಾನ", "ಕಂಠಪಾಠ ವಿಧಾನ"),
                    correctAnswer = "ಆಗಮನ ವಿಧಾನ (Inductive Method)",
                    explanation = "ಆಗಮನ ವಿಧಾನದಲ್ಲಿ ಮೊದಲು ಹಲವು ಉದಾಹರಣೆಗಳನ್ನು ನೀಡಿ ನಂತರ ವ್ಯಾಕರಣ ನಿಯಮವನ್ನು ಮಕ್ಕಳೇ ಕಂಡುಕೊಳ್ಳುವಂತೆ ಮಾಡಲಾಗುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_kan_u2_q2",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಕನ್ನಡದ ಆದಿಕವಿ ಎಂದು ಪ್ರಸಿದ್ಧರಾದವರು ಯಾರು?",
                    options = listOf("ಪಂಪ", "ರನ್ನ", "ಪೊನ್ನ", "ಕುಮಾರವ್ಯಾಸ"),
                    correctAnswer = "ಪಂಪ",
                    explanation = "ಆದಿಪುರಾಣ ಮತ್ತು ವಿಕ್ರಮಾರ್ಜುನ ವಿಜಯ ಕೃತಿಗಳನ್ನು ರಚಿಸಿದ ಪಂಪನನ್ನು ಕನ್ನಡದ ಆದಿಕವಿ ಎಂದು ಕರೆಯಲಾಗುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_kan_u2_q3",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಮೌನ ಓದಿನ (Silent Reading) ಪ್ರಮುಖ ಉದ್ದೇಶವೇನು?",
                    options = listOf("ವೇಗವಾಗಿ ಓದಿ ಅರ್ಥಗ್ರಹಣ ಮಾಡಿಕೊಳ್ಳುವುದು", "ಉಚ್ಚಾರಣೆ ಸರಿಪಡಿಸುವುದು", "ಕಂಠಪಾಠ ಮಾಡುವುದು", "ಬರವಣಿಗೆ ಸುಧಾರಿಸುವುದು"),
                    correctAnswer = "ವೇಗವಾಗಿ ಓದಿ ಅರ್ಥಗ್ರಹಣ ಮಾಡಿಕೊಳ್ಳುವುದು",
                    explanation = "ಮೌನ ಓದು ವಿದ್ಯಾರ್ಥಿಗಳಲ್ಲಿ ಏಕಾಗ್ರತೆ, ವೇಗ ಮತ್ತು ಆಳವಾದ ಅರ್ಥಗ್ರಹಣ ಸಾಮರ್ಥ್ಯವನ್ನು ಬೆಳೆಸುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_kan_u2_q4",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "ಪರಿಹಾರ ಬೋಧನೆ (Remedial Teaching) ಯಾವ ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಅಗತ್ಯವಾಗಿದೆ?",
                    options = listOf("ಕಲಿಕೆಯಲ್ಲಿ ಹಿಂದುಳಿದ ಮತ್ತು ನಿರ್ದಿಷ್ಟ ದೋಷ ಹೊಂದಿರುವ ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ", "ಪ್ರತಿಭಾವಂತ ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಮಾತ್ರ", "ಪರೀಕ್ಷೆ ಬರೆಯದ ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಮಾತ್ರ", "ಹೊಸದಾಗಿ ದಾಖಲಾದವರಿಗೆ ಮಾತ್ರ"),
                    correctAnswer = "ಕಲಿಕೆಯಲ್ಲಿ ಹಿಂದುಳಿದ ಮತ್ತು ನಿರ್ದಿಷ್ಟ ದೋಷ ಹೊಂದಿರುವ ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ",
                    explanation = "ನೈದಾನಿಕ ಪರೀಕ್ಷೆಯ (Diagnostic Test) ಮೂಲಕ ಕಲಿಕಾ ನ್ಯೂನತೆಗಳನ್ನು ಗುರುತಿಸಿ ಪರಿಹಾರ ಬೋಧನೆ ನೀಡಲಾಗುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_kan_u2_q5",
                    stdId = 13,
                    subjectId = "kannada",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "'ಕವಿರಾಜಮಾರ್ಗ' ಕೃತಿಯನ್ನು ರಚಿಸಿದವರು ಯಾರು?",
                    options = listOf("ಶ್ರೀವಿಜಯ", "ನಾಗವರ್ಮ", "ಕೇಶಿರಾಜ", "ಜನ್ನ"),
                    correctAnswer = "ಶ್ರೀವಿಜಯ",
                    explanation = "ರಾಷ್ಟ್ರಕೂಟ ದೊರೆ ಅಮೋಘವರ್ಷ ನೃಪತುಂಗನ ಆಸ್ಥಾನ ಕವಿ ಶ್ರೀವಿಜಯನು ಕನ್ನಡದ ಪ್ರಥಮ ಉಪಲಬ್ಧ ಗ್ರಂಥವಾದ ಕವಿರಾಜಮಾರ್ಗವನ್ನು ರಚಿಸಿದನು."
                )
            )
        }

    val englishQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetEnglish") {
            listOf(
                QuestionModel(
                    id = "tet_eng_u1_q1",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Choose the correct passive voice form: 'The teacher praised the student.'",
                    options = listOf(
                        "The student was praised by the teacher.",
                        "The student is praised by the teacher.",
                        "The student were praised by the teacher.",
                        "The student has praised by the teacher."
                    ),
                    correctAnswer = "The student was praised by the teacher.",
                    explanation = "Simple past active ('praised') converts to 'was/were + past participle' in passive voice."
                ),
                QuestionModel(
                    id = "tet_eng_u1_q2",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Identify the figure of speech in: 'The classroom was a zoo during recess.'",
                    options = listOf("Metaphor", "Simile", "Alliteration", "Onomatopoeia"),
                    correctAnswer = "Metaphor",
                    explanation = "A metaphor makes a direct comparison without using 'like' or 'as'."
                ),
                QuestionModel(
                    id = "tet_eng_u1_q3",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Fill in the blank with the right preposition: 'Neither Ravi nor his friends ___ present today.'",
                    options = listOf("were", "was", "is", "has"),
                    correctAnswer = "were",
                    explanation = "With 'neither...nor', the verb agrees with the nearest subject ('his friends', which is plural)."
                ),
                QuestionModel(
                    id = "tet_eng_u1_q4",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which of the following is the antonym of 'Benevolent'?",
                    options = listOf("Malevolent", "Generous", "Kind", "Altruistic"),
                    correctAnswer = "Malevolent",
                    explanation = "'Benevolent' means well-meaning and kind; its direct opposite is 'malevolent' (wishing harm)."
                ),
                QuestionModel(
                    id = "tet_eng_u1_q5",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "In the sentence 'She ran quickly to catch the bus', the word 'quickly' is a/an:",
                    options = listOf("Adverb", "Adjective", "Preposition", "Conjunction"),
                    correctAnswer = "Adverb",
                    explanation = "'Quickly' modifies the verb 'ran' by describing how she ran, making it an adverb of manner."
                ),
                QuestionModel(
                    id = "tet_eng_u2_q1",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which language teaching approach prioritizes real-life interaction and meaningful communication over rote grammar drills?",
                    options = listOf("Communicative Language Teaching (CLT)", "Grammar-Translation Method", "Audio-Lingual Drill Method", "Dictation Method"),
                    correctAnswer = "Communicative Language Teaching (CLT)",
                    explanation = "CLT focuses on developing communicative competence through authentic dialogues, role plays, and interaction."
                ),
                QuestionModel(
                    id = "tet_eng_u2_q2",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Who proposed the concept of 'Language Acquisition Device' (LAD) and Universal Grammar?",
                    options = listOf("Noam Chomsky", "B.F. Skinner", "Edward Thorndike", "Ivan Pavlov"),
                    correctAnswer = "Noam Chomsky",
                    explanation = "Chomsky argued that humans are born with an innate Language Acquisition Device (LAD) for acquiring grammar naturally."
                ),
                QuestionModel(
                    id = "tet_eng_u2_q3",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Quickly glancing over a passage to locate a specific date or name is called:",
                    options = listOf("Scanning", "Skimming", "Intensive reading", "Proofreading"),
                    correctAnswer = "Scanning",
                    explanation = "Scanning looks for specific facts/keywords, whereas skimming reads rapidly for the general gist."
                ),
                QuestionModel(
                    id = "tet_eng_u2_q4",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "The smallest unit of sound in a language that distinguishes one word from another is called a:",
                    options = listOf("Phoneme", "Morpheme", "Syntax", "Grapheme"),
                    correctAnswer = "Phoneme",
                    explanation = "A phoneme is the smallest distinctive sound unit (e.g., /p/ vs /b/ in 'pat' and 'bat'); a morpheme is the smallest unit of meaning."
                ),
                QuestionModel(
                    id = "tet_eng_u2_q5",
                    stdId = 13,
                    subjectId = "english",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which two language skills are classified as 'Productive (Active) Skills'?",
                    options = listOf("Speaking and Writing", "Listening and Reading", "Listening and Speaking", "Reading and Writing"),
                    correctAnswer = "Speaking and Writing",
                    explanation = "Speaking and Writing require producing language output, while Listening and Reading are Receptive skills."
                )
            )
        }

    val mathQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetMaths") {
            listOf(
                QuestionModel(
                    id = "tet_math_u1_q1",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "What is the sum of the first 20 natural numbers?",
                    options = listOf("210", "200", "190", "220"),
                    correctAnswer = "210",
                    explanation = "Using n(n + 1)/2 = 20 × 21 / 2 = 210."
                ),
                QuestionModel(
                    id = "tet_math_u1_q2",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The HCF of two numbers is 12 and their LCM is 180. If one number is 36, find the other number.",
                    options = listOf("60", "48", "72", "54"),
                    correctAnswer = "60",
                    explanation = "Product of two numbers = HCF × LCM → 36 × x = 12 × 180 → x = 2160 / 36 = 60."
                ),
                QuestionModel(
                    id = "tet_math_u1_q3",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "What is the measure of each interior angle of a regular hexagon?",
                    options = listOf("120°", "108°", "135°", "90°"),
                    correctAnswer = "120°",
                    explanation = "Each interior angle of a regular n-gon = ((n - 2) × 180°) / n = (4 × 180°) / 6 = 120°."
                ),
                QuestionModel(
                    id = "tet_math_u1_q4",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "If the cost price of 10 articles equals the selling price of 8 articles, what is the profit percentage?",
                    options = listOf("25%", "20%", "15%", "30%"),
                    correctAnswer = "25%",
                    explanation = "Profit % = ((10 - 8) / 8) × 100 = (2 / 8) × 100 = 25%."
                ),
                QuestionModel(
                    id = "tet_math_u1_q5",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which is the only even prime number?",
                    options = listOf("2", "0", "4", "6"),
                    correctAnswer = "2",
                    explanation = "2 has exactly two factors (1 and 2); all other even numbers are divisible by 2."
                ),
                QuestionModel(
                    id = "tet_math_u2_q1",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "According to Van Hiele's theory of geometric thinking, Level 0 is known as:",
                    options = listOf("Visualization", "Analysis", "Informal Deduction", "Rigor"),
                    correctAnswer = "Visualization",
                    explanation = "At Level 0 (Visualization), students recognize geometric shapes by their overall appearance rather than formal properties."
                ),
                QuestionModel(
                    id = "tet_math_u2_q2",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which teaching aid is best suited to help primary students understand place value and decimal fractions?",
                    options = listOf("Dienes Blocks (Base-10 Blocks)", "Protractor", "Compass", "Graph Paper only"),
                    correctAnswer = "Dienes Blocks (Base-10 Blocks)",
                    explanation = "Dienes Base-10 blocks concretely model ones, tens, hundreds, and regrouping in arithmetic."
                ),
                QuestionModel(
                    id = "tet_math_u2_q3",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "According to NCF 2005, the main goal of Mathematics education in schools is:",
                    options = listOf("Mathematisation of the child's thought processes", "Memorizing multiplication tables up to 50", "Scoring 100% in board exams", "Learning fast calculator shortcuts"),
                    correctAnswer = "Mathematisation of the child's thought processes",
                    explanation = "NCF 2005 states that developing logical reasoning, abstraction, and problem-solving ('mathematisation') is the core aim."
                ),
                QuestionModel(
                    id = "tet_math_u2_q4",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Proceeding from 'unknown to known' to break a complex mathematical proof into simpler parts is called:",
                    options = listOf("Analytic Method", "Synthetic Method", "Lecture Method", "Drill Method"),
                    correctAnswer = "Analytic Method",
                    explanation = "Analysis breaks down the required conclusion toward known facts; Synthesis builds from known facts to the conclusion."
                ),
                QuestionModel(
                    id = "tet_math_u2_q5",
                    stdId = 13,
                    subjectId = "math",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "A student writes 1/2 + 1/3 = 2/5. What is the best remedial step for the teacher?",
                    options = listOf(
                        "Use fraction strips or area models to show equivalence before common denominators",
                        "Penalize the student with extra homework",
                        "Move on to algebra immediately",
                        "Ask the student to memorize the formula silently"
                    ),
                    correctAnswer = "Use fraction strips or area models to show equivalence before common denominators",
                    explanation = "Visual fraction models address the conceptual misconception that numerators and denominators can be added independently."
                )
            )
        }

    val evsQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetEVS") {
            listOf(
                QuestionModel(
                    id = "tet_evs_u1_q1",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which gas is primarily responsible for the greenhouse effect and global warming?",
                    options = listOf("Carbon dioxide (CO₂)", "Nitrogen (N₂)", "Oxygen (O₂)", "Argon (Ar)"),
                    correctAnswer = "Carbon dioxide (CO₂)",
                    explanation = "Carbon dioxide traps outgoing infrared radiation in Earth's atmosphere, driving anthropogenic global warming."
                ),
                QuestionModel(
                    id = "tet_evs_u1_q2",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Deficiency of Vitamin D in children causes which bone-weakening disease?",
                    options = listOf("Rickets", "Scurvy", "Beriberi", "Night blindness"),
                    correctAnswer = "Rickets",
                    explanation = "Vitamin D is essential for calcium absorption; its deficiency leads to soft, weak bones (Rickets)."
                ),
                QuestionModel(
                    id = "tet_evs_u1_q3",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which layer of Earth's atmosphere contains the protective ozone layer?",
                    options = listOf("Stratosphere", "Troposphere", "Mesosphere", "Thermosphere"),
                    correctAnswer = "Stratosphere",
                    explanation = "The stratospheric ozone layer absorbs harmful ultraviolet (UV-B) radiation from the Sun."
                ),
                QuestionModel(
                    id = "tet_evs_u1_q4",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The Chipko Movement for forest conservation originated in which Indian region in 1973?",
                    options = listOf("Uttarakhand (then Uttar Pradesh)", "Kerala", "Rajasthan", "Assam"),
                    correctAnswer = "Uttarakhand (then Uttar Pradesh)",
                    explanation = "Villagers in Chamoli (now in Uttarakhand), led by Chandi Prasad Bhatt and Sunderlal Bahuguna, hugged trees to stop logging."
                ),
                QuestionModel(
                    id = "tet_evs_u1_q5",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which plant tissue transports water and dissolved minerals from roots to leaves?",
                    options = listOf("Xylem", "Phloem", "Cortex", "Stomata"),
                    correctAnswer = "Xylem",
                    explanation = "Xylem carries water/minerals upward from roots, while Phloem transports food produced during photosynthesis."
                ),
                QuestionModel(
                    id = "tet_evs_u2_q1",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "In EVS teaching at the primary stage, curriculum is organized around themes (Family, Food, Water, Shelter) to:",
                    options = listOf(
                        "Promote an integrated, holistic understanding of the child's environment",
                        "Separate Physics, Chemistry, and History strictly",
                        "Reduce outdoor observation activities",
                        "Increase textbook length"
                    ),
                    correctAnswer = "Promote an integrated, holistic understanding of the child's environment",
                    explanation = "Young children perceive the world holistically, so NCF 2005 integrates science, social studies, and environmental education."
                ),
                QuestionModel(
                    id = "tet_evs_u2_q2",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Field trips in Social Studies and EVS are most valuable because they:",
                    options = listOf(
                        "Provide direct, firsthand experiential learning",
                        "Replace all classroom assessments",
                        "Keep students quiet",
                        "Avoid the need for lesson planning"
                    ),
                    correctAnswer = "Provide direct, firsthand experiential learning",
                    explanation = "Field visits connect classroom concepts to real communities, ecosystems, and heritage sites."
                ),
                QuestionModel(
                    id = "tet_evs_u2_q3",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which Constitutional Amendment lowered the voting age in India from 21 to 18 years?",
                    options = listOf("61st Amendment Act, 1988", "42nd Amendment Act, 1976", "44th Amendment Act, 1978", "73rd Amendment Act, 1992"),
                    correctAnswer = "61st Amendment Act, 1988",
                    explanation = "The 61st Constitutional Amendment amended Article 326 to lower the voting age for Lok Sabha and Assembly elections to 18."
                ),
                QuestionModel(
                    id = "tet_evs_u2_q4",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which UNESCO World Heritage Site in Karnataka was the capital of the Vijayanagara Empire?",
                    options = listOf("Hampi", "Pattadakal", "Belur", "Badami"),
                    correctAnswer = "Hampi",
                    explanation = "The Group of Monuments at Hampi represents the glorious 14th–16th century capital of the Vijayanagara Empire."
                ),
                QuestionModel(
                    id = "tet_evs_u2_q5",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "A portfolio in Continuous and Comprehensive Evaluation (CCE) consists of:",
                    options = listOf(
                        "A purposeful collection of a student's work showing progress over time",
                        "Only the final annual examination mark sheet",
                        "The teacher's personal attendance register",
                        "A list of textbook chapters"
                    ),
                    correctAnswer = "A purposeful collection of a student's work showing progress over time",
                    explanation = "Portfolios track longitudinal student growth through projects, reflections, drawings, and assignments."
                )
            )
        } + TetFoodAndWaterQuestionBank.questions + TetPlantsQuestionBank.questions + TetAnimalsQuestionBank.questions + TetEnvironmentQuestionBank.questions + TetNaturalResourcesQuestionBank.questions + TetFamilyAndTransportQuestionBank.questions + TetSciencePedagogyQuestionBank.questions + TetLivingWorldQuestionBank.questions + TetNaturalProcessesQuestionBank.questions + TetMaterialsQuestionBank.questions + TetHowThingsWorkQuestionBank.questions

    val allQuestions: List<QuestionModel>
        get() = cdpQuestions + kannadaQuestions + englishQuestions + mathQuestions + evsQuestions
}
