package com.example.data

import com.example.auth.FirebaseCloudSyncManager

/**
 * Consolidated unit-wise question bank for Standard 6 Kannada.
 * Contains both Prose (ಗದ್ಯಪಾಠ) and Poetry (ಪದ್ಯಪಾಠ) units without duplicates.
 */
object Std6KannadaQuestionBank {

    val units: List<UnitTemplate> = listOf(
        // ಗದ್ಯಪಾಠಗಳು
        UnitTemplate(1, "ಗದ್ಯಪಾಠ–1: ದೊಡ್ಡವರ ದಾರಿ", 12, "Easy"),
        UnitTemplate(2, "ಗದ್ಯಪಾಠ–2: ಗಂಧರ್ವ ಸೇನ", 6, "Medium"),
        UnitTemplate(3, "ಗದ್ಯಪಾಠ–3: ಕೃಷ್ಣ ಸುಧಾಮ", 6, "Easy"),
        UnitTemplate(4, "ಗದ್ಯಪಾಠ–4: ಡಾ. ರಾಜಕುಮಾರ್", 5, "Medium"),
        UnitTemplate(5, "ಗದ್ಯಪಾಠ–5: ಧನ್ಯವಾದ ಹೇಳಿದ ಆಕ್ಕರೆ", 12, "Medium"),
        UnitTemplate(6, "ಗದ್ಯಪಾಠ–6: ಕರ್ನಾಟಕ ಏಕೀಕರಣ", 3, "Medium"),
        UnitTemplate(7, "ಪದ್ಯಪಾಠ–7: ಬೇಸಿಗೆ", 3, "Easy"),
        UnitTemplate(11, "ಗದ್ಯಪಾಠ–11: ಸಿದ್ಧಾರೂಢ ಜಾತ್ರೆ", 5, "Medium"),
        UnitTemplate(14, "ಗದ್ಯಪಾಠ–14: ಯಾಣ ಕುರಿತೊಂದು ಪತ್ರ", 4, "Medium"),

        // ಪದ್ಯಪಾಠಗಳು
        UnitTemplate(8, "ಪದ್ಯಪಾಠ–8: ಮಂಗಳ ಗ್ರಹದಲ್ಲಿ ಪುಟ್ಟಿ", 3, "Medium"),
        UnitTemplate(9, "ಪದ್ಯಪಾಠ–9: ನೀ ಹೋದ ಮರುದಿನ", 2, "Easy"),
        UnitTemplate(10, "ಪದ್ಯಪಾಠ–10: ಗಂಗವ್ವತಾಯಿ", 7, "Medium"),
        UnitTemplate(12, "ಪದ್ಯಪಾಠ–12: ಕಿತ್ತೂರು ಕೇಸರಿ", 4, "Medium"),
        UnitTemplate(13, "ಪದ್ಯಪಾಠ–13: ಹೃದಯ ವಚನಗಳು", 2, "Medium")
    )

    val questions: List<QuestionModel> = listOf(
        // ========================================================
        // 🟦 ಗದ್ಯಪಾಠ
        // ========================================================

        // --------------------------------------------------------
        // ಘಟಕ 1 — ದೊಡ್ಡವರ ದಾರಿ (Unit 1)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u1_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿರುವ ಅಕ್ಷರಗಳು ಎಷ್ಟು?",
            options = listOf("49", "50", "47", "52"),
            correctAnswer = "49",
            explanation = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ ಒಟ್ಟು 49 ಅಕ್ಷರಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u1_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿರುವ ಸ್ವರಾಕ್ಷರಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("15", "18", "13", "25"),
            correctAnswer = "13",
            explanation = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ 13 ಸ್ವರಾಕ್ಷರಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u1_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಅನುಸ್ವಾರ ಮತ್ತು ವಿಸರ್ಗ ಎನ್ನುವುದು ಏನು?",
            options = listOf("ಸ್ವರಾಕ್ಷರಗಳು", "ಯೋಗವಾಹಗಳು", "ವ್ಯಂಜನಾಕ್ಷರಗಳು", "ದೀರ್ಘಸ್ವರಗಳು"),
            correctAnswer = "ಯೋಗವಾಹಗಳು",
            explanation = "ಅನುಸ್ವಾರ (ಂ) ಮತ್ತು ವಿಸರ್ಗ (ಃ) ಇವು ಯೋಗವಾಹಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u1_4",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಅನುನಾಸಿಕ ಅಕ್ಷರಕ್ಕೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಙ", "ಕ", "ಇ", "ಚ"),
            correctAnswer = "ಙ",
            explanation = "ಮೂಗಿನ ಸಹಾಯದಿಂದ ಉಚ್ಚರಿಸಲ್ಪಡುವ ಅಕ್ಷರಗಳಲ್ಲಿ 'ಙ' ಅನುನಾಸಿಕ ಅಕ್ಷರವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u1_5",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ರಾಷ್ಟ್ರದ ಪ್ರಥಮ ಪ್ರಜೆ ಯಾರು?",
            options = listOf("ಪ್ರಧಾನಮಂತ್ರಿ", "ರಾಷ್ಟ್ರಾಧ್ಯಕ್ಷರು", "ರಾಜ್ಯಪಾಲರು", "ಮುಖ್ಯಮಂತ್ರಿಗಳು"),
            correctAnswer = "ರಾಷ್ಟ್ರಾಧ್ಯಕ್ಷರು",
            explanation = "ರಾಷ್ಟ್ರದ ಪ್ರಥಮ ಪ್ರಜೆ ಭಾರತದ ರಾಷ್ಟ್ರಾಧ್ಯಕ್ಷರು (ರಾಷ್ಟ್ರಪತಿಗಳು)."
        ),
        QuestionModel(
            id = "s_6_kan_u1_6",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಆದೇಶ’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಬೇರೆ ದೇಶ", "ದೇಶ", "ಆಜ್ಞೆ", "ಪಾಲಿಸು"),
            correctAnswer = "ಆಜ್ಞೆ",
            explanation = "‘ಆದೇಶ’ ಪದದ ಅರ್ಥ ‘ಆಜ್ಞೆ’."
        ),
        QuestionModel(
            id = "s_6_kan_u1_7",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಉಪಕುಲಪತಿ ಯಾರ ಮುಖ್ಯಸ್ಥರು?",
            options = listOf("ಶಾಲೆಯ", "ವಿಶ್ವವಿದ್ಯಾಲಯದ", "ಕಚೇರಿಯ", "ಊರಿನ"),
            correctAnswer = "ವಿಶ್ವವಿದ್ಯಾಲಯದ",
            explanation = "ಉಪಕುಲಪತಿಗಳು (Vice-Chancellor) ವಿಶ್ವವಿದ್ಯಾಲಯದ ಮುಖ್ಯಸ್ಥರಾಗಿರುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u1_8",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಮಗು’ ಪದದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ಮಗುಗಳು", "ವಿದ್ಯಾರ್ಥಿಗಳು", "ಮಕ್ಕಳು", "ಸುತ"),
            correctAnswer = "ಮಕ್ಕಳು",
            explanation = "‘ಮಗು’ ಏಕವಚನವಾದರೆ, ‘ಮಕ್ಕಳು’ ಬಹುವಚನ ರೂಪ."
        ),
        QuestionModel(
            id = "s_6_kan_u1_9",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮಕ್ಕಳು ಯಾವ ವ್ಯಕ್ತಿಗೆ ಸಹಾಯ ಮಾಡುತ್ತಿದ್ದರು?",
            options = listOf("ಸ್ನೇಹಿತರಿಗೆ", "ಶಿಕ್ಷಕರಿಗೆ", "ಹಿರಿಯ ನಾಗರಿಕರಿಗೆ", "ಅಂಗಡಿಯವರಿಗೆ"),
            correctAnswer = "ಹಿರಿಯ ನಾಗರಿಕರಿಗೆ",
            explanation = "ಮಕ್ಕಳು ಹಿರಿಯ ನಾಗರಿಕರಿಗೆ ಸಹಾಯ ಮಾಡುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_6_kan_u1_10",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮಕ್ಕಳು ಹಿರಿಯರಿಗೆ ಮಾಡಿದ ಸಹಾಯ ಯಾವುದು?",
            options = listOf("ಆಟವಾಡಿಸಿದರು", "ರಸ್ತೆ ದಾಟಲು ಸಹಾಯ ಮಾಡಿದರು", "ಓಡಲು ಹೇಳಿದರು", "ಮನೆಗೆ ಕಳುಹಿಸಿದರು"),
            correctAnswer = "ರಸ್ತೆ ದಾಟಲು ಸಹಾಯ ಮಾಡಿದರು",
            explanation = "ಮಕ್ಕಳು ಹಿರಿಯರಿಗೆ ರಸ್ತೆ ದಾಟಲು ನೆರವಾದರು."
        ),
        QuestionModel(
            id = "s_6_kan_u1_11",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಹಿರಿಯರಿಗೆ ಸಹಾಯ ಮಾಡುವುದು ಯಾವ ಗುಣವನ್ನು ತೋರಿಸುತ್ತದೆ?",
            options = listOf("ಮಾನವೀಯತೆ", "ಸೋಮಾರಿತನ", "ಕೋಪ", "ಅಹಂಕಾರ"),
            correctAnswer = "ಮಾನವೀಯತೆ",
            explanation = "ಹಿರಿಯರಿಗೆ ಸಹಾಯ ಮಾಡುವುದು ಮಾನವೀಯತೆ ಗುಣವನ್ನು ತೋರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u1_12",
            stdId = 6,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಈ ಸನ್ನಿವೇಶದಿಂದ ನಾವು ಏನು ಕಲಿಯುತ್ತೇವೆ?",
            options = listOf("ಜಗಳ ಮಾಡುವುದು", "ಸಮಯ ವ್ಯರ್ಥ ಮಾಡುವುದು", "ಅಗತ್ಯವಿರುವವರಿಗೆ ಸಹಾಯ ಮಾಡುವುದು", "ಹಿರಿಯರನ್ನು ನಿರ್ಲಕ್ಷಿಸುವುದು"),
            correctAnswer = "ಅಗತ್ಯವಿರುವವರಿಗೆ ಸಹಾಯ ಮಾಡುವುದು",
            explanation = "ಈ ಸನ್ನಿವೇಶದಿಂದ ನಾವು ಅಗತ್ಯವಿರುವವರಿಗೆ ಸಹಾಯ ಮಾಡುವುದನ್ನು ಕಲಿಯುತ್ತೇವೆ."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 2 — ಗಂಧರ್ವ ಸೇನ (Unit 2)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u2_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಗಂಧರ್ವ ಸೇನ ಎನ್ನುವುದು ಯಾವುದು?",
            options = listOf("ಕುದುರೆ", "ಸಿಂಹ", "ಕತ್ತೆ", "ಆನೆ"),
            correctAnswer = "ಕತ್ತೆ",
            explanation = "ಗಂಧರ್ವ ಸೇನ ಎನ್ನುವುದು ಕತ್ತೆಯಾಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_6_kan_u2_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಅಂಕಿತನಾಮಕ್ಕೆ ಉದಾಹರಣೆಯಾದ ಪದ ಯಾವುದು?",
            options = listOf("ಕಾವೇರಿ", "ಮನುಷ್ಯ", "ವಿದ್ವಾಂಸ", "ಹೊಸದು"),
            correctAnswer = "ಕಾವೇರಿ",
            explanation = "‘ಕಾವೇರಿ’ ಎಂಬುದು ನಿರ್ದಿಷ್ಟ ನದಿಯ ಹೆಸರಾಗಿದ್ದು ಅಂಕಿತನಾಮವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u2_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವರಲ್ಲಿ ಚುರುಕು ಬುದ್ಧಿಯವರು ಯಾರು?",
            options = listOf("ಮಂತ್ರಿ", "ಸೇವಕಿ", "ಸೈನಿಕ", "ಮಡಿವಾಳ"),
            correctAnswer = "ಸೇವಕಿ",
            explanation = "ಸೇವಕಿಯು ಚುರುಕು ಬುದ್ಧಿಯವಳಾಗಿದ್ದಳು."
        ),
        QuestionModel(
            id = "s_6_kan_u2_4",
            stdId = 6,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ರಾಜನ ಒಡ್ಡೋಲಗಕ್ಕೆ ಅಳುತ್ತಾ ಬಂದವರು ಯಾರು?",
            options = listOf("ರಾಣಿ", "ಸೇವಕಿ", "ಪ್ರಜೆ", "ಮಂತ್ರಿ"),
            correctAnswer = "ಮಂತ್ರಿ",
            explanation = "ಮಂತ್ರಿ ಅಳುತ್ತಾ ರಾಜನ ಒಡ್ಡೋಲಗಕ್ಕೆ ಬಂದನು."
        ),
        QuestionModel(
            id = "s_6_kan_u2_5",
            stdId = 6,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ರಾಜನಿಗೆ ಗಂಧರ್ವ ಸೇನ ತೀರಿಹೋದ ವಿಷಯವನ್ನು ತಿಳಿಸಿದವರು ಯಾರು?",
            options = listOf("ಮಂತ್ರಿ", "ರಾಣಿ", "ಸೇವಕಿ", "ಸೈನಿಕ"),
            correctAnswer = "ಮಂತ್ರಿ",
            explanation = "ರಾಜನಿಗೆ ಗಂಧರ್ವ ಸೇನ ತೀರಿಹೋದ ವಿಷಯವನ್ನು ಮಂತ್ರಿ ತಿಳಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_kan_u2_6",
            stdId = 6,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ಅಂತಃಪುರ’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ರಾಜಾಂಗಣ", "ರಾಣಿವಾಸ", "ರಾಜಸಭೆ", "ಸೇವಕಿಯರ ವಾಸ"),
            correctAnswer = "ರಾಣಿವಾಸ",
            explanation = "‘ಅಂತಃಪುರ’ ಪದದ ಅರ್ಥ ‘ರಾಣಿವಾಸ’."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 3 — ಕೃಷ್ಣ ಸುಧಾಮ (Unit 3)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u3_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ಕೈಚೆಲ್ಲಿದರು’ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಕೈತೊಳೆಯುವುದು", "ಪ್ರಯತ್ನಬಿಟ್ಟುಬಿಡುವುದು", "ಸಹಾಯ ಮಾಡುವುದು", "ಆಟವಾಡುವುದು"),
            correctAnswer = "ಪ್ರಯತ್ನಬಿಟ್ಟುಬಿಡುವುದು",
            explanation = "‘ಕೈಚೆಲ್ಲಿದರು’ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥ ‘ಪ್ರಯತ್ನಬಿಟ್ಟುಬಿಡುವುದು’."
        ),
        QuestionModel(
            id = "s_6_kan_u3_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ಕೈಜೋಡಿಸುವುದು’ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಜಗಳ ಮಾಡುವುದು", "ಓಡುವುದು", "ಸಹಾಯ ಮಾಡುವುದು", "ನಗುವುದು"),
            correctAnswer = "ಸಹಾಯ ಮಾಡುವುದು",
            explanation = "‘ಕೈಜೋಡಿಸುವುದು’ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥ ‘ಸಹಾಯ ಮಾಡುವುದು’."
        ),
        QuestionModel(
            id = "s_6_kan_u3_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ಈ ಗದ್ಯದ ನೀತಿ ಯಾವುದು?",
            options = listOf("ಒಗ್ಗಟ್ಟಿದ್ದರೆ ಯಶಸ್ಸು ಸಿಗುತ್ತದೆ", "ಸಮಯ ವ್ಯರ್ಥ ಮಾಡಬೇಕು", "ಸುಳ್ಳು ಹೇಳಬಾರದು", "ಒಬ್ಬರೇ ಕೆಲಸ ಮಾಡಬೇಕು"),
            correctAnswer = "ಒಗ್ಗಟ್ಟಿದ್ದರೆ ಯಶಸ್ಸು ಸಿಗುತ್ತದೆ",
            explanation = "ಈ ಗದ್ಯದ ನೀತಿ ‘ಒಗ್ಗಟ್ಟಿದ್ದರೆ ಯಶಸ್ಸು ಸಿಗುತ್ತದೆ’."
        ),
        QuestionModel(
            id = "s_6_kan_u3_4",
            stdId = 6,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ಮಿತ್ರರು’ ಪದಕ್ಕೆ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಗೆಳೆಯ", "ಸ್ನೇಹ", "ಶತ್ರು", "ರಾಜ"),
            correctAnswer = "ಶತ್ರು",
            explanation = "‘ಮಿತ್ರರು’ ಪದಕ್ಕೆ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ‘ಶತ್ರು’."
        ),
        QuestionModel(
            id = "s_6_kan_u3_5",
            stdId = 6,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ದೂರ’ ಪದಕ್ಕೆ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಸಮೀಪ", "ದೂರ", "ಕಠಿಣ", "ಮೇಲಿನ ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ಸಮೀಪ",
            explanation = "‘ದೂರ’ ಪದಕ್ಕೆ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ‘ಸಮೀಪ’."
        ),
        QuestionModel(
            id = "s_6_kan_u3_6",
            stdId = 6,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ನೀತಿ’ ಪದಕ್ಕೆ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಅನೀತಿ", "ವಿನಾಶ", "ಆಶ್ಚರ್ಯ", "ಅವನತಿ"),
            correctAnswer = "ಅನೀತಿ",
            explanation = "‘ನೀತಿ’ ಪದಕ್ಕೆ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ‘ಅನೀತಿ’."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 4 — ಡಾ. ರಾಜಕುಮಾರ್ (Unit 4)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u4_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಕನ್ನಡ ಸಂಧಿಯ ಹೆಸರನ್ನು ಗುರುತಿಸಿ.",
            options = listOf("ಗುಣಸಂಧಿ", "ಯಣ್ ಸಂಧಿ", "ಆಗಮ ಸಂಧಿ", "ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ"),
            correctAnswer = "ಯಣ್ ಸಂಧಿ",
            explanation = "ಪ್ರಶ್ನೆಯ ಉತ್ತರ: ಬಿ) ಯಣ್ ಸಂಧಿ."
        ),
        QuestionModel(
            id = "s_6_kan_u4_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "‘ಮಿಥ್ಯ’ ಚಿತ್ರದ ನಿರ್ದೇಶಕರು ಯಾರು?",
            options = listOf("ಯೋಗರಾಜ್", "ಬಿ. ಎಂ. ಗಿರಿರಾಜ್", "ಸುಮಂತ್ ಭಟ್", "ರಿಷಬ್ ಶೆಟ್ಟಿ"),
            correctAnswer = "ಸುಮಂತ್ ಭಟ್",
            explanation = "‘ಮಿಥ್ಯ’ ಚಿತ್ರದ ನಿರ್ದೇಶಕರು ಸುಮಂತ್ ಭಟ್."
        ),
        QuestionModel(
            id = "s_6_kan_u4_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ರಾಜಕುಮಾರ್ ಅವರು ಹುಟ್ಟಿದ ಊರು ಯಾವುದು?",
            options = listOf("ಮೈಸೂರು", "ಗಾಜನೂರು", "ಬೆಂಗಳೂರು", "ಹುಬ್ಬಳ್ಳಿ"),
            correctAnswer = "ಗಾಜನೂರು",
            explanation = "ಡಾ. ರಾಜಕುಮಾರ್ ಅವರು ಗಾಜನೂರಿನಲ್ಲಿ ಜನಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_6_kan_u4_4",
            stdId = 6,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ರಾಜಕುಮಾರ್ ಮೊದಲು ಅಭಿನಯಿಸಿದ ನಾಟಕ ಕಂಪನಿ ಯಾವುದು?",
            options = listOf("ಗುಬ್ಬಿವೀರಣ್ಣ", "ರಂಗಭೂಮಿ", "ನಾಟಕ ಮಂಡಳಿ", "ಕನ್ನಡ ಕಲಾ ಸಂಘ"),
            correctAnswer = "ಗುಬ್ಬಿವೀರಣ್ಣ",
            explanation = "ರಾಜಕುಮಾರ್ ಅವರು ತಮ್ಮ ಆರಂಭದ ದಿನಗಳಲ್ಲಿ ಗುಬ್ಬಿವೀರಣ್ಣ ನಾಟಕ ಕಂಪನಿಯಲ್ಲಿ ಅಭಿನಯಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_6_kan_u4_5",
            stdId = 6,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಮೈಸೂರು ವಿಶ್ವವಿದ್ಯಾಲಯವು ರಾಜಕುಮಾರ್ ಅವರಿಗೆ ನೀಡಿದ ಪದವಿ ಯಾವುದು?",
            options = listOf("ಸಾಹಿತ್ಯ ರತ್ನ", "ಗೌರವ ಡಾಕ್ಟರೇಟ್", "ಕಲಾ ಭೂಷಣ", "ನಾಡೋಜ"),
            correctAnswer = "ಗೌರವ ಡಾಕ್ಟರೇಟ್",
            explanation = "ಮೈಸೂರು ವಿಶ್ವವಿದ್ಯಾಲಯವು ರಾಜಕುಮಾರ್ ಅವರಿಗೆ ಗೌರವ ಡಾಕ್ಟರೇಟ್ ಪದವಿ ನೀಡಿ ಗೌರವಿಸಿತು."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 5 — ಧನ್ಯವಾದ ಹೇಳಿದ ಆಕ್ಕರೆ (Unit 5)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u5_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "2024ರ ರಾಜ್ಯ ಚಲನಚಿತ್ರ ಪ್ರಶಸ್ತಿಯಲ್ಲಿ ‘ಮಿಥ್ಯ’ ಯಾವ ವಿಭಾಗದಲ್ಲಿ ಗುರುತಿಸಲ್ಪಟ್ಟಿದೆ?",
            options = listOf("ಅತ್ಯುತ್ತಮ ಹಾಸ್ಯಚಿತ್ರ", "ಅತ್ಯುತ್ತಮ ಮಕ್ಕಳ ಚಿತ್ರ", "ಅತ್ಯುತ್ತಮ ಬಾಲನಟ ವಿಭಾಗದ ಚಿತ್ರ", "ಅತ್ಯುತ್ತಮ ಸಂಗೀತ ಚಿತ್ರ"),
            correctAnswer = "ಅತ್ಯುತ್ತಮ ಮಕ್ಕಳ ಚಿತ್ರ",
            explanation = "2024ರ ರಾಜ್ಯ ಚಲನಚಿತ್ರ ಪ್ರಶಸ್ತಿಯಲ್ಲಿ ‘ಮಿಥ್ಯ’ ಅತ್ಯುತ್ತಮ ಮಕ್ಕಳ ಚಿತ್ರ ವಿಭಾಗದಲ್ಲಿ ಗುರುತಿಸಲ್ಪಟ್ಟಿದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u5_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಹರಿ ಉಪಚರಿಸಿದ ಪಕ್ಷಿ ಯಾವುದು?",
            options = listOf("ಕಾಡು", "ನವಿಲು", "ಆಕ್ಕರೆ", "ಗುಬ್ಬಚ್ಚಿ"),
            correctAnswer = "ಆಕ್ಕರೆ",
            explanation = "ಹರಿ ಉಪಚರಿಸಿದ ಪಕ್ಷಿ ಆಕ್ಕರೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u5_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಹಿಮದ ಹೂ’ ಕೃತಿ ಯಾರದು?",
            options = listOf("ಔರಂಗಜೇಬ್", "ಅಯಸ್ಕಾಂತ", "ಹಕ್ಕಿಗಳು", "ಅನುಪಮಾ ನಿರಂಜನ"),
            correctAnswer = "ಅನುಪಮಾ ನಿರಂಜನ",
            explanation = "‘ಹಿಮದ ಹೂ’ ಕೃತಿಯು ಅನುಪಮಾ ನಿರಂಜನ ಅವರದ್ದಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u5_4",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಕ್ಷಾಮ’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಕಾಲ", "ಬರಗಾಲ", "ಆಜ್ಞೆ", "ಜಡಮೂಲಿಕೆ"),
            correctAnswer = "ಬರಗಾಲ",
            explanation = "‘ಕ್ಷಾಮ’ ಪದದ ಅರ್ಥ ‘ಬರಗಾಲ’."
        ),
        QuestionModel(
            id = "s_6_kan_u5_5",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "“ಅಹಾ ಹೂವು ಎಷ್ಟು ಸುಂದರವಾಗಿದೆ” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿ ಬಳಸಬಹುದಾದ ಲೇಖನ ಚಿಹ್ನೆಗಳು ಯಾವುವು?",
            options = listOf("ಭಾವಸೂಚಕ ಮತ್ತು ಪ್ರಶ್ನಾರ್ಥಕ", "ಭಾವಸೂಚಕ ಮತ್ತು ಅಲ್ಪವಿರಾಮ", "ಭಾವಸೂಚಕ ಮತ್ತು ಪೂರ್ಣವಿರಾಮ", "ಉದ್ಧರಣ ಮತ್ತು ಭಾವಸೂಚಕ"),
            correctAnswer = "ಭಾವಸೂಚಕ ಮತ್ತು ಅಲ್ಪವಿರಾಮ",
            explanation = "ಭಾವಸೂಚಕ ಮತ್ತು ಅಲ್ಪವಿರಾಮ ಚಿಹ್ನೆಗಳನ್ನು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u5_6",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಕಾರ್ಯ’ ಪದದ ತದ್ಭವ ರೂಪ ಯಾವುದು?",
            options = listOf("ಕಜ್ಜ", "ಕಬ್ಬ", "ಕಂದ", "ಕಾಯಕ"),
            correctAnswer = "ಕಜ್ಜ",
            explanation = "‘ಕಾರ್ಯ’ ಪದದ ತದ್ಭವ ರೂಪ ‘ಕಜ್ಜ’."
        ),
        QuestionModel(
            id = "s_6_kan_u5_7",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಹೆಂಡತಿ’ ಪದದ ಪುಲ್ಲಿಂಗ ರೂಪ ಯಾವುದು?",
            options = listOf("ಹೆಂಡಿರು", "ಗಂಡ", "ಮಕ್ಕಳು", "ಪತ್ನಿ"),
            correctAnswer = "ಗಂಡ",
            explanation = "‘ಹೆಂಡತಿ’ ಪದದ ಪುಲ್ಲಿಂಗ ರೂಪ ‘ಗಂಡ’."
        ),
        QuestionModel(
            id = "s_6_kan_u5_8",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಗುಬ್ಬಚ್ಚಿ ಸಿಕ್ಕಿಕೊಂಡಿದ್ದು ಎಲ್ಲಿ?",
            options = listOf("ನೀರಿನಲ್ಲಿ", "ಮರದ ಕೊಂಬೆಯಲ್ಲಿ", "ಗಿಡದ ಮುಳ್ಳಿನಲ್ಲಿ", "ಮನೆಯೊಳಗೆ"),
            correctAnswer = "ಗಿಡದ ಮುಳ್ಳಿನಲ್ಲಿ",
            explanation = "ಗುಬ್ಬಚ್ಚಿ ಗಿಡದ ಮುಳ್ಳಿನಲ್ಲಿ ಸಿಕ್ಕಿಕೊಂಡಿತ್ತು."
        ),
        QuestionModel(
            id = "s_6_kan_u5_9",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಗುಬ್ಬಚ್ಚಿಯನ್ನು ರಕ್ಷಿಸಿದವರು ಯಾರು?",
            options = listOf("ರೈತ", "ಬಾಲಕ", "ಶಿಕ್ಷಕ", "ಮೀನುಗಾರ"),
            correctAnswer = "ಮೀನುಗಾರ",
            explanation = "ಗುಬ್ಬಚ್ಚಿಯನ್ನು ಮೀನುಗಾರ ರಕ್ಷಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_kan_u5_10",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಬಾಲಕನಿಗೆ ಬಾಟಲಿಯನ್ನು ತೆಗೆದು ಕೊಟ್ಟವರು ಯಾರು?",
            options = listOf("ನಾಯಿ", "ಕೋತಿ", "ಹಸು", "ಬೆಕ್ಕು"),
            correctAnswer = "ಕೋತಿ",
            explanation = "ಬಾಲಕನಿಗೆ ಬಾಟಲಿಯನ್ನು ತೆಗೆದು ಕೊಟ್ಟವರು ಕೋತಿ."
        ),
        QuestionModel(
            id = "s_6_kan_u5_11",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಗುಬ್ಬಚ್ಚಿಯು ಯಾವ ಗುಣವನ್ನು ತೋರಿಸಿತು?",
            options = listOf("ಸೋಮಾರಿತನ", "ಕೃತಜ್ಞತೆ", "ಕೋಪ", "ಅಸೂಯೆ"),
            correctAnswer = "ಕೃತಜ್ಞತೆ",
            explanation = "ಗುಬ್ಬಚ್ಚಿಯು ಕೃತಜ್ಞತೆ ಗುಣವನ್ನು ತೋರಿಸಿತು."
        ),
        QuestionModel(
            id = "s_6_kan_u5_12",
            stdId = 6,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಈ ಕಥೆಯ ಮುಖ್ಯ ಸಂದೇಶ ಯಾವುದು?",
            options = listOf("ಸುಳ್ಳು ಹೇಳಬೇಕು", "ಉಪಕಾರವನ್ನು ಮರೆಯಬೇಕು", "ಉಪಕಾರಕ್ಕೆ ಕೃತಜ್ಞತೆ ಸಲ್ಲಿಸಬೇಕು", "ಒಂಟಿಯಾಗಿ ಬದುಕಬೇಕು"),
            correctAnswer = "ಉಪಕಾರಕ್ಕೆ ಕೃತಜ್ಞತೆ ಸಲ್ಲಿಸಬೇಕು",
            explanation = "ಈ ಕಥೆಯ ಮುಖ್ಯ ಸಂದೇಶ ‘ಉಪಕಾರಕ್ಕೆ ಕೃತಜ್ಞತೆ ಸಲ್ಲಿಸಬೇಕು’."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 6 — ಕರ್ನಾಟಕ ಏಕೀಕರಣ (Unit 6)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u6_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕ ಸಭೆಯ ಅಧ್ಯಕ್ಷತೆಯನ್ನು ವಹಿಸಿಕೊಂಡಿದ್ದವರು ಯಾರು?",
            options = listOf("ಎಂ. ಗೋವಿಂದ ಪೈ", "ಸಿದ್ಧಪ್ಪ ಕಂಬಳಿ", "ಪಂಜೆ ಮಂಗೇಶರಾಯರು", "ಬಿ. ಎಂ. ಶ್ರೀ"),
            correctAnswer = "ಸಿದ್ಧಪ್ಪ ಕಂಬಳಿ",
            explanation = "ಕರ್ನಾಟಕ ಸಭೆಯ ಅಧ್ಯಕ್ಷತೆಯನ್ನು ಸಿದ್ಧಪ್ಪ ಕಂಬಳಿಯವರು ವಹಿಸಿಕೊಂಡಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_6_kan_u6_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದಲ್ಲಿ ಈ ಸಂದರ್ಭದಲ್ಲಿ ನಾಡಹಬ್ಬ ನಡೆಯುತ್ತದೆ.",
            options = listOf("ದಸರಾ", "ದೀಪಾವಳಿ", "ಸಂಕ್ರಾಂತಿ", "ಯುಗಾದಿ"),
            correctAnswer = "ದಸರಾ",
            explanation = "ಕರ್ನಾಟಕದಲ್ಲಿ ದಸರಾ ಸಂದರ್ಭದಲ್ಲಿ ನಾಡಹಬ್ಬ ನಡೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u6_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ವೀಡಿಯೊದಲ್ಲಿ ಮಕ್ಕಳಿಗಾಗಿ ಬಂದ ಕಾರ್ಯಕ್ರಮದ ಹೆಸರು ಯಾವುದು?",
            options = listOf("ಆಕಾಶ ನಕ್ಷತ್ರ", "ಆಕಾಶ ಕೇಂದ್ರ", "ಆಕಾಶವಾಣಿ", "ಆಕಾಶ ಆಕಾಶ"),
            correctAnswer = "ಆಕಾಶವಾಣಿ",
            explanation = "ಮಕ್ಕಳಿಗಾಗಿ ಬಂದ ಕಾರ್ಯಕ್ರಮದ ಹೆಸರು ‘ಆಕಾಶವಾಣಿ’."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 7 — ಬೇಸಿಗೆ (Unit 7)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u7_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ಯಾವ ಪದದಲ್ಲಿ “ಶ” ಧ್ವನಿ ಬಂದಿದೆ?",
            options = listOf("ಷಡಕ್ಷರಿ", "ಶಾಲೆ", "ಸರೋವರ", "ಸಂತೆ"),
            correctAnswer = "ಶಾಲೆ",
            explanation = "‘ಶಾಲೆ’ ಪದದಲ್ಲಿ “ಶ” ಧ್ವನಿ ಬಂದಿದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u7_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "“ಷ” ಅಕ್ಷರ ಸರಿಯಾಗಿ ಬಳಕೆಯಾದ ಪದ ಯಾವುದು?",
            options = listOf("ಶಟ್ಕೋನ", "ಸಟ್ಕೋನ", "ಷಟ್ಕೋನ", "ಶಡ್ಕೋನ"),
            correctAnswer = "ಷಟ್ಕೋನ",
            explanation = "‘ಷಟ್ಕೋನ’ ಪದದಲ್ಲಿ “ಷ” ಅಕ್ಷರ ಸರಿಯಾಗಿ ಬಳಕೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u7_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "“ನ” ಮತ್ತು “ಣ” ಧ್ವನಿಗಳ ವ್ಯತ್ಯಾಸವನ್ನು ಸರಿಯಾಗಿ ತೋರಿಸುವ ಪದಜೋಡಿ ಯಾವುದು?",
            options = listOf("ನದಿ – ಗಣೇಶ", "ಮನೆ – ಮರ", "ಕಲ್ಲು – ಜಡ", "ಶಾಲೆ – ರಸ್ತೆ"),
            correctAnswer = "ಕಲ್ಲು – ಜಡ",
            explanation = "ಪ್ರಶ್ನೆಯ ಉತ್ತರ: ಸಿ) ಕಲ್ಲು – ಜಡ."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 11 — ಸಿದ್ಧಾರೂಢ ಜಾತ್ರೆ (Unit 11)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u11_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸಿದ್ಧಾರೂಢ ಜಾತ್ರೆ ನಡೆಯುವ ವಿಶೇಷ ದಿನ ಯಾವುದು?",
            options = listOf("ಯುಗಾದಿ", "ದೀಪಾವಳಿ", "ಶಿವರಾತ್ರಿ", "ಸಂಕ್ರಾಂತಿ"),
            correctAnswer = "ಶಿವರಾತ್ರಿ",
            explanation = "ಸಿದ್ಧಾರೂಢ ಜಾತ್ರೆಯು ಶಿವರಾತ್ರಿಯ ವಿಶೇಷ ದಿನದಂದು ನಡೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u11_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಅದರಗುಂಚಿ ಶಾಲೆಯ ವಿದ್ಯಾರ್ಥಿಗಳು ಎಲ್ಲಿಗೆ ತೆರಳಿದರು?",
            options = listOf("ಶಾಲೆಗೆ", "ಜಾತ್ರೆಗೆ", "ಮಠಕ್ಕೆ", "ಮಾರುಕಟ್ಟೆಗೆ"),
            correctAnswer = "ಜಾತ್ರೆಗೆ",
            explanation = "ಅದರಗುಂಚಿ ಶಾಲೆಯ ವಿದ್ಯಾರ್ಥಿಗಳು ಜಾತ್ರೆಗೆ ತೆರಳಿದರು."
        ),
        QuestionModel(
            id = "s_6_kan_u11_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸಿದ್ಧಾರೂಢರ ಜನ್ಮಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಬೀದರ್", "ಮೈಸೂರು", "ಧಾರವಾಡ", "ಬೆಳಗಾವಿ"),
            correctAnswer = "ಬೀದರ್",
            explanation = "ಸಿದ್ಧಾರೂಢರ ಜನ್ಮಸ್ಥಳ ಬೀದರ್."
        ),
        QuestionModel(
            id = "s_6_kan_u11_4",
            stdId = 6,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಮಠದಲ್ಲಿ ಜನರು ಏನು ಮಾಡುತ್ತಿದ್ದಾರೆ?",
            options = listOf("ನೃತ್ಯ", "ಆಟ", "ಭಜನೆ", "ಪಾಠ"),
            correctAnswer = "ಭಜನೆ",
            explanation = "ಮಠದಲ್ಲಿ ಜನರು ಭಜನೆ ಮಾಡುತ್ತಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u11_5",
            stdId = 6,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸದಾನಂದರು ಸ್ನೇಹಿತರಿಗೆ ಏನು ಹಂಚಿದರು?",
            options = listOf("ಹಣ್ಣು", "ಮಿಠಾಯಿ", "ಪುಸ್ತಕ", "ಪ್ರಸಾದ"),
            correctAnswer = "ಮಿಠಾಯಿ",
            explanation = "ಸದಾನಂದರು ತಮ್ಮ ಸ್ನೇಹಿತರಿಗೆ ಮಿಠಾಯಿ ಹಂಚಿದರು."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 14 — ಯಾಣ ಕುರಿತೊಂದು ಪತ್ರ (Unit 14)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u14_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಅಂದು ಭಾನುವಾರ ಎಲ್ಲರೂ ಯಾರ ಮನೆಗೆ ಬಂದರು?",
            options = listOf("ರಾಜು", "ರವಿ", "ಸದಾನಂದ", "ಸುರೇಶ್"),
            correctAnswer = "ರಾಜು",
            explanation = "ಭಾನುವಾರ ಎಲ್ಲರೂ ರಾಜುವಿನ ಮನೆಗೆ ಬಂದರು."
        ),
        QuestionModel(
            id = "s_6_kan_u14_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ವಿಶೇಷ ಪತ್ರ ತಯಾರಿಸಲು ಹೇಳಿದವರು ಯಾರು?",
            options = listOf("ರಾಣಿ", "ಪದ್ಮಿನಿ", "ಜೆನಿಫರ್", "ರಾಜು"),
            correctAnswer = "ಪದ್ಮಿನಿ",
            explanation = "ವಿಶೇಷ ಪತ್ರವನ್ನು ತಯಾರಿಸಲು ಪದ್ಮಿನಿ ಹೇಳಿದಳು."
        ),
        QuestionModel(
            id = "s_6_kan_u14_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಯಾಣ ಕುರಿತಾಗಿರುವ ಕೃತಿ ಯಾವುದು?",
            options = listOf("ಕಾದಂಬರಿ", "ದಂತಕಥೆ", "ನಾಟಕ", "ಜೀವನಚರಿತ್ರೆ"),
            correctAnswer = "ದಂತಕಥೆ",
            explanation = "ಯಾಣ ಕುರಿತಾಗಿರುವ ಕೃತಿ ದಂತಕಥೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u14_4",
            stdId = 6,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಯಾಣದ ಚಿತ್ರಗಳನ್ನು ಅವುಗಳ ವಿವರಗಳೊಂದಿಗೆ ಓದಿದವರು ಯಾರು?",
            options = listOf("ರಾಜು ಮತ್ತು ಪದ್ಮಿನಿ", "ರಾಣಿ ಮತ್ತು ಜೆನಿಫರ್", "ರಾಜು ಮತ್ತು ರಾಣಿ", "ಪದ್ಮಿನಿ ಮತ್ತು ಜೆನಿಫರ್"),
            correctAnswer = "ರಾಣಿ ಮತ್ತು ಜೆನಿಫರ್",
            explanation = "ಚಿತ್ರಗಳನ್ನು ವಿವರಗಳೊಂದಿಗೆ ರಾಣಿ ಮತ್ತು ಜೆನಿಫರ್ ಓದಿದರು."
        ),

        // ========================================================
        // 🟩 ಪದ್ಯಪಾಠ
        // ========================================================

        // --------------------------------------------------------
        // ಘಟಕ 8 — ಮಂಗಳ ಗ್ರಹದಲ್ಲಿ ಪುಟ್ಟಿ (Unit 8)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u8_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಒಂದು ದಿನ ಇದ್ದಕ್ಕಿದ್ದಂತೆ ಪುಟ್ಟಿಗೆ ಏನು ಬಂದಿತು?",
            options = listOf("ಕೊಂಬುಗಳು", "ರೆಕ್ಕೆಗಳು", "ಬಾಲ", "ಕಿರೀಟ"),
            correctAnswer = "ರೆಕ್ಕೆಗಳು",
            explanation = "ಒಂದು ದಿನ ಇದ್ದಕ್ಕಿದ್ದಂತೆ ಪುಟ್ಟಿಗೆ ರೆಕ್ಕೆಗಳು ಬಂದವು."
        ),
        QuestionModel(
            id = "s_6_kan_u8_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಹಾರುತ್ತಾ ತೇಲುತ್ತಾ ಮುಂದೆ ಸಾಗಿ ಚಂದ್ರನ ______ ಸೇರಿದಳು.",
            options = listOf("ಮನೆಗೆ", "ಮಡಿಲನ್ನು", "ದಾರಿಗೆ", "ಬೆಟ್ಟಕ್ಕೆ"),
            correctAnswer = "ಮಡಿಲನ್ನು",
            explanation = "ಹಾರುತ್ತಾ ತೇಲುತ್ತಾ ಮುಂದೆ ಸಾಗಿ ಚಂದ್ರನ ಮಡಿಲನ್ನು ಸೇರಿದಳು."
        ),
        QuestionModel(
            id = "s_6_kan_u8_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಕೂಡಲೇ ಪುಟ್ಟಿ ತಣ್ಣನೆ ಜಿಗಿದು ______ ಹಾರಿದಳು.",
            options = listOf("ನೀರಿನೊಳಗೆ", "ಆಗಸದೊಳಗೆ", "ಮನೆಯೊಳಗೆ", "ಕಾಡಿನೊಳಗೆ"),
            correctAnswer = "ಆಗಸದೊಳಗೆ",
            explanation = "ಕೂಡಲೇ ಪುಟ್ಟಿ ತಣ್ಣನೆ ಜಿಗಿದು ಆಗಸದೊಳಗೆ ಹಾರಿದಳು."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 9 — ನೀ ಹೋದ ಮರುದಿನ (Unit 9)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u9_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಪ್ರತಿನಿತ್ಯ ಎದ್ದಾಗ ನಮ್ಮ ಸುದ್ದಿ ______ ಕೇಳು ಹಾಕುವುದು ತಪ್ಪಿಲ್ಲ ನಮಗೆ.",
            options = listOf("ಸಂಭ್ರಮವು", "ದುಃಖವು", "ಕೋಪವು", "ಭಯವು"),
            correctAnswer = "ಸಂಭ್ರಮವು",
            explanation = "ಖಾಲಿ ಸ್ಥಳಕ್ಕೆ ಸೂಕ್ತವಾದ ಪದ ‘ಸಂಭ್ರಮವು’."
        ),
        QuestionModel(
            id = "s_6_kan_u9_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಡಾ. ಚೆನ್ನಣ್ಣ ವಾಲೀಕಾರರು ಯಾವ ವರ್ಷದಲ್ಲಿ ಜನಿಸಿದರು?",
            options = listOf("1940", "1941", "1943", "1945"),
            correctAnswer = "1943",
            explanation = "ಡಾ. ಚೆನ್ನಣ್ಣ ವಾಲೀಕಾರರು 1943ರಲ್ಲಿ ಜನಿಸಿದರು."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 10 — ಗಂಗವ್ವತಾಯಿ (Unit 10)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u10_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕಾರ್ಖಾನೆಗಳಿಂದ ಹೊರಬರುವ ಹೊಗೆ ಯಾವ ಮಾಲಿನ್ಯವನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಜಲ ಮಾಲಿನ್ಯ", "ವಾಯು ಮಾಲಿನ್ಯ", "ಮಣ್ಣಿನ ಮಾಲಿನ್ಯ", "ಬೆಳಕಿನ ಮಾಲಿನ್ಯ"),
            correctAnswer = "ವಾಯು ಮಾಲಿನ್ಯ",
            explanation = "ಕಾರ್ಖಾನೆಗಳಿಂದ ಹೊರಬರುವ ಹೊಗೆ ವಾಯು ಮಾಲಿನ್ಯವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u10_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ನದಿಗೆ ಕಸ ಮತ್ತು ತ್ಯಾಜ್ಯವನ್ನು ಹಾಕುವುದರಿಂದ ಉಂಟಾಗುವ ಮಾಲಿನ್ಯ ಯಾವುದು?",
            options = listOf("ಜಲ ಮಾಲಿನ್ಯ", "ವಾಯು ಮಾಲಿನ್ಯ", "ಶಬ್ದ ಮಾಲಿನ್ಯ", "ಬೆಳಕಿನ ಮಾಲಿನ್ಯ"),
            correctAnswer = "ಜಲ ಮಾಲಿನ್ಯ",
            explanation = "ನದಿಗೆ ಕಸ ಮತ್ತು ತ್ಯಾಜ್ಯವನ್ನು ಹಾಕುವುದರಿಂದ ಜಲ ಮಾಲಿನ್ಯ ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u10_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬಾರವ್ವತಾಯಿ ______ ತಾಯಿ.",
            options = listOf("ನೀರವ್ವ", "ಗಂಗವ್ವ", "ಹೊಳೆಯವ್ವ", "ಮಳಿಯವ್ವ"),
            correctAnswer = "ಗಂಗವ್ವ",
            explanation = "ಪದ್ಯದ ಸಾಲು: ‘ಬಾರವ್ವತಾಯಿ ಗಂಗವ್ವ ತಾಯಿ’."
        ),
        QuestionModel(
            id = "s_6_kan_u10_4",
            stdId = 6,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಹೊಳೆಯವ್ವತಾಯಿ ______ ತಾಯಿ.",
            options = listOf("ಗಂಗವ್ವ", "ನೀರವ್ವ", "ಬಾರವ್ವ", "ತೊಳೆಯವ್ವ"),
            correctAnswer = "ನೀರವ್ವ",
            explanation = "ಪದ್ಯದ ಸಾಲು: ‘ಹೊಳೆಯವ್ವತಾಯಿ ನೀರವ್ವ ತಾಯಿ’."
        ),
        QuestionModel(
            id = "s_6_kan_u10_5",
            stdId = 6,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಮೈಮನಸು ಹೊಲಸಲ್ಲ ______ ತಾಯಿ.",
            options = listOf("ಬಾರವ್ವ", "ಗಂಗವ್ವ", "ತೊಳೆಯವ್ವ", "ಹೊಳೆಯವ್ವ"),
            correctAnswer = "ತೊಳೆಯವ್ವ",
            explanation = "ಪದ್ಯದ ಸಾಲು: ‘ಮೈಮನಸು ಹೊಲಸಲ್ಲ ತೊಳೆಯವ್ವ ತಾಯಿ’."
        ),
        QuestionModel(
            id = "s_6_kan_u10_6",
            stdId = 6,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ನೀರವ್ವ ಗಂಗವ್ವ ______ ಬಾರವ್ವ.",
            options = listOf("ಮಳಿಯಾಗಿ", "ಹಸುರಾಗಿ", "ಒಣಗಿಯಾಗಿ", "ಬೆಳಕಾಗಿ"),
            correctAnswer = "ಮಳಿಯಾಗಿ",
            explanation = "ಪದ್ಯದ ಸಾಲು: ‘ನೀರವ್ವ ಗಂಗವ್ವ ಮಳಿಯಾಗಿ ಬಾರವ್ವ’."
        ),
        QuestionModel(
            id = "s_6_kan_u10_7",
            stdId = 6,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಒಣಗಿದ ನೆಲದಾಗ ______ ಹೊಳೆಯವ್ವ.",
            options = listOf("ಬಿಳಿಯಾಗಿ", "ಹಸುರಾಗಿ", "ಕಪ್ಪಾಗಿ", "ಒಣಗಿಯಾಗಿ"),
            correctAnswer = "ಹಸುರಾಗಿ",
            explanation = "ಪದ್ಯದ ಸಾಲು: ‘ಒಣಗಿದ ನೆಲದಾಗ ಹಸುರಾಗಿ ಹೊಳೆಯವ್ವ’."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 13 — ಹೃದಯ ವಚನಗಳು (Unit 13)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u13_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ಎನಿತು’ ಎಂಬ ಪದದ ಗ್ರಾಂಥಿಕ ರೂಪ ಯಾವುದು?",
            options = listOf("ಅಷ್ಟು", "ಎಷ್ಟು", "ಎಂತು", "ಯಾವಾಗ"),
            correctAnswer = "ಎಷ್ಟು",
            explanation = "‘ಎನಿತು’ ಎಂಬ ಪದದ ಗ್ರಾಂಥಿಕ ರೂಪ ‘ಎಷ್ಟು’."
        ),
        QuestionModel(
            id = "s_6_kan_u13_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಶಿವಶರಣರು ರಚಿಸಿದ ಸಾಹಿತ್ಯಪ್ರಕಾರ ಯಾವುದು?",
            options = listOf("ಕಥೆ", "ಕವನ", "ಕಾದಂಬರಿ", "ವಚನಗಳು"),
            correctAnswer = "ವಚನಗಳು",
            explanation = "ಶಿವಶರಣರು ರಚಿಸಿದ ಸಾಹಿತ್ಯಪ್ರಕಾರ ವಚನಗಳು."
        ),

        // --------------------------------------------------------
        // ಘಟಕ 12 — ಕಿತ್ತೂರು ಕೇಸರಿ (Unit 12)
        // --------------------------------------------------------
        QuestionModel(
            id = "s_6_kan_u12_1",
            stdId = 6,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಬೀಜವನ್ನು ಬಿತ್ತುವ ಕಾಲ ಯಾವುದು?",
            options = listOf("ಮಳೆಗಾಲ", "ಚಳಿಗಾಲ", "ಬೇಸಿಗೆ ಕಾಲ", "ವಸಂತಕಾಲ"),
            correctAnswer = "ಬೇಸಿಗೆ ಕಾಲ",
            explanation = "ಬೀಜವನ್ನು ಬಿತ್ತುವ ಕಾಲ ಬೇಸಿಗೆ ಕಾಲ."
        ),
        QuestionModel(
            id = "s_6_kan_u12_2",
            stdId = 6,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಕಿತ್ತೂರಿನ ಕೇಸರಿ’ ಪದ್ಯ ಬರೆದವರು ಯಾರು?",
            options = listOf("ಪ. ಗು. ಸಿದ್ಧಾಪುರ", "ಬೀಚಿ", "ಎಂ. ಗೋವಿಂದ ಪೈ", "ಕುವೆಂಪು"),
            correctAnswer = "ಪ. ಗು. ಸಿದ್ಧಾಪುರ",
            explanation = "‘ಕಿತ್ತೂರಿನ ಕೇಸರಿ’ ಪದ್ಯವನ್ನು ಪ. ಗು. ಸಿದ್ಧಾಪುರ ಅವರು ರಚಿಸಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u12_3",
            stdId = 6,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "“ಹಕ್ಕಿ ಹಣ್ಣನ್ನು ತಿನ್ನುತ್ತದೆ” ಎಂಬ ವಾಕ್ಯ ಯಾವ ಪ್ರಕಾರಕ್ಕೆ ಸೇರಿದೆ?",
            options = listOf("ಸಾಮಾನ್ಯವಾಕ್ಯ", "ಸಂಯೋಜಿತ ವಾಕ್ಯ", "ಮಿಶ್ರವಾಕ್ಯ", "ಪ್ರಶ್ನಾರ್ಥಕ ವಾಕ್ಯ"),
            correctAnswer = "ಸಾಮಾನ್ಯವಾಕ್ಯ",
            explanation = "“ಹಕ್ಕಿ ಹಣ್ಣನ್ನು ತಿನ್ನುತ್ತದೆ” ಎಂಬುದು ಸಾಮಾನ್ಯವಾಕ್ಯವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_kan_u12_4",
            stdId = 6,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "“ಮರುಜನ್ಮ ನೀಡನಡ … ಈ ನೆಲದಿ” ಎಂಬ ಪ್ರಶ್ನೆಯಲ್ಲಿನ ಖಾಲಿ ಸ್ಥಳಕ್ಕೆ ಸೂಕ್ತ ಪದ ಯಾವುದು?",
            options = listOf("ಮಗುವಾಗಿ", "ವೀರ ವನಿತೆ", "ಗಂಡಾಗಿ", "ಹೆಣ್ಣಾಗಿ"),
            correctAnswer = "ಹೆಣ್ಣಾಗಿ",
            explanation = "ಖಾಲಿ ಸ್ಥಳಕ್ಕೆ ಸೂಕ್ತವಾದ ಪದ ‘ಹೆಣ್ಣಾಗಿ’."
        )
    )

    /**
     * Uploads all consolidated Std 6 Kannada questions to Firebase Firestore under collection `quiz_questions`.
     */
    suspend fun uploadToFirestore(cloudSyncManager: FirebaseCloudSyncManager): Result<Int> {
        return cloudSyncManager.syncQuestionModelsToCloud(questions)
    }
}
