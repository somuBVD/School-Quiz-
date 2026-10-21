package com.example.data

/**
 * Standard 8 Kannada (ಕನ್ನಡ - LBA Revised 2026-27)
 * Consolidated chapter-wise question bank without duplicate questions.
 * Chapters covered:
 * 1. ಮಗೆದ ಸಾಹೇಬ (15 questions)
 * 2. ಸಾರ್ಥಕ ಬದುಕಿನ ಸಾಧಕ (16 questions)
 * 3. ನೀರು ಕೊಡದ ನಾಡಿನಲ್ಲಿ (7 questions)
 * 4. ಯಶೋಧರೆ (10 questions)
 * 5. ಭಾರತೀಯತೆ (10 questions)
 * 6. ಬೇವು ಬೆಲ್ಲ ದಳಿಡಲೇನ್ನ ಫಲ (10 questions)
 * 7. ಸೋಮೇಶ್ವರ ಶತಕ (11 questions)
 * 8. ಕನ್ನಡಿಗರ ತಾಯಿ (11 questions)
 * 9. ಬಹುಮಾನ (6 questions)
 * 10. ಗೆಳತನ (6 questions)
 * 11. ವಚನಾಮೃತ (15 questions)
 * 12. ರಮಧಾನ್ ಚರಿತೆ (11 questions)
 * 14. ಆಟೋರಿಕ್ಷಾದ ರಸಪ್ರಸಂಗಗಳು (6 questions)
 * 15. ಸೀಮ (5 questions)
 */
object Std8KannadaQuestionBank {

    val units = listOf(
        UnitTemplate(1, "ಅಧ್ಯಾಯ 1: ಮಗೆದ ಸಾಹೇಬ", 15, "Easy"),
        UnitTemplate(2, "ಅಧ್ಯಾಯ 2: ಸಾರ್ಥಕ ಬದುಕಿನ ಸಾಧಕ", 16, "Medium"),
        UnitTemplate(3, "ಅಧ್ಯಾಯ 3: ನೀರು ಕೊಡದ ನಾಡಿನಲ್ಲಿ", 7, "Easy"),
        UnitTemplate(4, "ಅಧ್ಯಾಯ 4: ಯಶೋಧರೆ", 10, "Medium"),
        UnitTemplate(5, "ಅಧ್ಯಾಯ 5: ಭಾರತೀಯತೆ", 10, "Medium"),
        UnitTemplate(6, "ಅಧ್ಯಾಯ 6: ಬೇವು ಬೆಲ್ಲ ದಳಿಡಲೇನ್ನ ಫಲ", 10, "Hard"),
        UnitTemplate(7, "ಅಧ್ಯಾಯ 7: ಸೋಮೇಶ್ವರ ಶತಕ", 11, "Medium"),
        UnitTemplate(8, "ಅಧ್ಯಾಯ 8: ಕನ್ನಡಿಗರ ತಾಯಿ", 11, "Easy"),
        UnitTemplate(9, "ಅಧ್ಯಾಯ 9: ಬಹುಮಾನ", 6, "Easy"),
        UnitTemplate(10, "ಅಧ್ಯಾಯ 10: ಗೆಳತನ", 6, "Easy"),
        UnitTemplate(11, "ಅಧ್ಯಾಯ 11: ವಚನಾಮೃತ", 15, "Hard"),
        UnitTemplate(12, "ಅಧ್ಯಾಯ 12: ರಮಧಾನ್ ಚರಿತೆ", 11, "Medium"),
        UnitTemplate(14, "ಅಧ್ಯಾಯ 14: ಆಟೋರಿಕ್ಷಾದ ರಸಪ್ರಸಂಗಗಳು", 6, "Easy"),
        UnitTemplate(15, "ಅಧ್ಯಾಯ 15: ಸೀಮ", 5, "Easy")
    )

    val questions: List<QuestionModel> = listOf(
        // ==========================================
        // ಅಧ್ಯಾಯ 1 — ಮಗೆದ ಸಾಹೇಬ (15 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u1_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ ಒಟ್ಟು ಎಷ್ಟು ಅಕ್ಷರಗಳಿವೆ?",
            options = listOf("47", "48", "49", "50"),
            correctAnswer = "49",
            explanation = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ 14 ಸ್ವರಗಳು, 2 ಯೋಗವಾಹಗಳು ಮತ್ತು 33 ವ್ಯಂಜನಗಳು ಸೇರಿ ಒಟ್ಟು 49 ಅಕ್ಷರಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u1_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸ್ವತಂತ್ರವಾಗಿ ಉಚ್ಚರಿಸಲ್ಪಡುವ ಅಕ್ಷರಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸ್ವರಗಳು", "ವ್ಯಂಜನಗಳು", "ಯೋಗವಾಹಗಳು", "ಅನುನಾಸಿಕಗಳು"),
            correctAnswer = "ಸ್ವರಗಳು",
            explanation = "ಯಾವುದೇ ಬೇರೆ ಅಕ್ಷರದ ಸಹಾಯವಿಲ್ಲದೆ ಸ್ವತಂತ್ರವಾಗಿ ಉಚ್ಚರಿಸಲ್ಪಡುವ ಅಕ್ಷರಗಳನ್ನು ಸ್ವರಗಳು ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u1_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಅನುನಾಸಿಕ ಅಕ್ಷರಗಳ ಗುಂಪು ಯಾವುದು?",
            options = listOf("ಕ ಚ ಟ ತ ಪ", "ಖ ಛ ಠ ಥ ಫ", "ಗ ಜ ಡ ದ ಬ", "ಙ ಞ ಣ ನ ಮ"),
            correctAnswer = "ಙ ಞ ಣ ನ ಮ",
            explanation = "ಮೂಗಿನ ಸಹಾಯದಿಂದ ಉಚ್ಚರಿಸಲ್ಪಡುವ ಪ್ರತಿಯೊಂದು ವರ್ಗದ ಐದನೆಯ ಅಕ್ಷರಗಳು ಅನುನಾಸಿಕಗಳು: ಙ, ಞ, ಣ, ನ, ಮ."
        ),
        QuestionModel(
            id = "s_8_kan_u1_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಅವರ್ಗೀಯ ವ್ಯಂಜನಾಕ್ಷರವಿರುವ ಪದ ಯಾವುದು?",
            options = listOf("ಕಮಲ", "ಕುಶಲ", "ಗಗನ", "ಚರಣ"),
            correctAnswer = "ಕುಶಲ",
            explanation = "'ಕುಶಲ' ಪದದಲ್ಲಿರುವ 'ಶ' ಕಾರವು ಅವರ್ಗೀಯ ವ್ಯಂಜನವಾಗಿದೆ (ಯ-ಳ ವರೆಗಿನ 9 ಅಕ್ಷರಗಳು)."
        ),
        QuestionModel(
            id = "s_8_kan_u1_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮೂರು ಅಥವಾ ಅದಕ್ಕಿಂತ ಹೆಚ್ಚು ಮಾತ್ರಾಕಾಲದಲ್ಲಿ ಉಚ್ಚರಿಸಲ್ಪಡುವ ಸ್ವರವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಹ್ರಸ್ವ ಸ್ವರ", "ದೀರ್ಘ ಸ್ವರ", "ಪ್ಲುತ ಸ್ವರ", "ಅನುಸ್ವಾರ"),
            correctAnswer = "ಪ್ಲುತ ಸ್ವರ",
            explanation = "ಕರೆಯುವಾಗ ಅಥವಾ ಅಳುವಾಗ ಮೂರು ಅಥವಾ ಹೆಚ್ಚು ಮಾತ್ರಾಕಾಲದಲ್ಲಿ ಎಳೆದು ಉಚ್ಚರಿಸುವ ಸ್ವರವೇ ಪ್ಲುತ ಸ್ವರ (ಉದಾ: ಅಣ್ಣಾ೩)."
        ),
        QuestionModel(
            id = "s_8_kan_u1_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಧ್ವನ್ಯಂಗದ ಅಡೆತಡೆಯೊಂದಿಗೆ ಉಚ್ಚರಿಸುವ ಅಕ್ಷರಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸ್ವರಗಳು", "ವ್ಯಂಜನಗಳು", "ಯೋಗವಾಹಗಳು", "ಅನುನಾಸಿಕಗಳು"),
            correctAnswer = "ವ್ಯಂಜನಗಳು",
            explanation = "ಸ್ವರಗಳ ಸಹಾಯದಿಂದ ಧ್ವನ್ಯಂಗದ ತಡೆಯೊಂದಿಗೆ ಉಚ್ಚರಿಸಲ್ಪಡುವ ಅಕ್ಷರಗಳೇ ವ್ಯಂಜನಗಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u1_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪ್ರತಿಯೊಂದು ವರ್ಗದ ಮೊದಲನೆಯ ಮತ್ತು ಮೂರನೆಯ ಅಕ್ಷರಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಅಲ್ಪಪ್ರಾಣ", "ಮಹಾಪ್ರಾಣ", "ಅನುನಾಸಿಕ", "ಯೋಗವಾಹ"),
            correctAnswer = "ಅಲ್ಪಪ್ರಾಣ",
            explanation = "ಕಡಿಮೆ ಉಸಿರಿನಿಂದ ಉಚ್ಚರಿಸಲ್ಪಡುವ 1 ಮತ್ತು 3ನೇ ವರ್ಗೀಯ ಅಕ್ಷರಗಳು ಅಲ್ಪಪ್ರಾಣಗಳು (ಕ, ಗ, ಚ, ಜ...)."
        ),
        QuestionModel(
            id = "s_8_kan_u1_8",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಅನುಸ್ವಾರ ಮತ್ತು ವಿಸರ್ಗಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸ್ವರಗಳು", "ವ್ಯಂಜನಗಳು", "ಯೋಗವಾಹಗಳು", "ಅವರ್ಗೀಯ ವ್ಯಂಜನಗಳು"),
            correctAnswer = "ಯೋಗವಾಹಗಳು",
            explanation = "ಬೇರೆ ಅಕ್ಷರಗಳ ಸಂಬಂಧದಿಂದ ಮಾತ್ರ ಉಚ್ಚರಿಸಬಹುದಾದ ಅಂ (ಅನುಸ್ವಾರ) ಮತ್ತು ಅಃ (ವಿಸರ್ಗ) ಯೋಗವಾಹಗಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u1_9",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ನವೀನ ಶಿಕ್ಷಣದ ಒಂದು ರೂಪ ಯಾವುದು?",
            options = listOf("ಔದ್ಯೋಗಿಕ ಶಿಕ್ಷಣ", "ಧಾರ್ಮಿಕ ಶಿಕ್ಷಣ", "ನೈತಿಕ ಶಿಕ್ಷಣ", "ಸಾಮಾನ್ಯ ಶಿಕ್ಷಣ"),
            correctAnswer = "ಔದ್ಯೋಗಿಕ ಶಿಕ್ಷಣ",
            explanation = "ವೃತ್ತಿ ಮತ್ತು ಕೌಶಲ್ಯಗಳನ್ನು ಕಲಿಸುವ ಔದ್ಯೋಗಿಕ ಶಿಕ್ಷಣವು ನವೀನ ಶಿಕ್ಷಣದ ಪ್ರಮುಖ ರೂಪವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u1_10",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಕರಕುಶಲ ವಸ್ತು ಯಾವುದು?",
            options = listOf("ಮಣ್ಣಿನ ಮಡಿಕೆ", "ಪುಸ್ತಕ", "ಪೆನ್ನು", "ಗಡಿಯಾರ"),
            correctAnswer = "ಮಣ್ಣಿನ ಮಡಿಕೆ",
            explanation = "ಕೈಚಳಕ ಮತ್ತು ಕುಶಲಕಲೆಯಿಂದ ರೂಪಿಸಿದ ಮಣ್ಣಿನ ಮಡಿಕೆಯು ಸಾಂಪ್ರದಾಯಿಕ ಕರಕುಶಲ ವಸ್ತುವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u1_11",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕರಕುಶಲ ವಸ್ತು ತಯಾರಿಸಲು ಮುಖ್ಯವಾಗಿ ಯಾವುದರ ಅಗತ್ಯವಿದೆ?",
            options = listOf("ಸೃಜನಶೀಲತೆ ಮತ್ತು ಕೈಚಳಕ", "ಕೇವಲ ಹಣ", "ಕೇವಲ ಯಂತ್ರ", "ಕೇವಲ ಪುಸ್ತಕ ಜ್ಞಾನ"),
            correctAnswer = "ಸೃಜನಶೀಲತೆ ಮತ್ತು ಕೈಚಳಕ",
            explanation = "ಕರಕುಶಲ ಕಲೆಗಾರಿಕೆಗೆ ಸೃಜನಶೀಲತೆ ಮತ್ತು ಕೈಚಳಕ ಅತಿಮುಖ್ಯ."
        ),
        QuestionModel(
            id = "s_8_kan_u1_12",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಕಳೇಬರ : ಮೃತದೇಹ :: ಗೌಪ್ಯ : ______’",
            options = listOf("ಗುಟ್ಟು", "ಸಂತೋಷ", "ಶಬ್ದ", "ಬೆಳಕು"),
            correctAnswer = "ಗುಟ್ಟು",
            explanation = "ಕಳೇಬರ ಎಂದರೆ ಮೃತದೇಹ; ಗೌಪ್ಯ ಎಂದರೆ ರಹಸ್ಯ ಅಥವಾ ಗುಟ್ಟು."
        ),
        QuestionModel(
            id = "s_8_kan_u1_13",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ವರ್ಗೀಯ ವ್ಯಂಜನ : 25 :: ಅವರ್ಗೀಯ ವ್ಯಂಜನ : ______’",
            options = listOf("08", "09", "10", "11"),
            correctAnswer = "09",
            explanation = "ವರ್ಗೀಯ ವ್ಯಂಜನಗಳು 25 (ಕ ದಿಂದ ಮ) ಮತ್ತು ಅವರ್ಗೀಯ ವ್ಯಂಜನಗಳು 9 (ಯ ದಿಂದ ಳ)."
        ),
        QuestionModel(
            id = "s_8_kan_u1_14",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಟ ವರ್ಗ : ಮೂರ್ಧನ್ಯ :: ಪ ವರ್ಗ : ______’",
            options = listOf("ದಂತ್ಯ", "ತಾಲವ್ಯ", "ಓಷ್ಠ್ಯ", "ಕಂಠ್ಯ"),
            correctAnswer = "ಓಷ್ಠ್ಯ",
            explanation = "ಟ ವರ್ಗವು ಮೂರ್ಧನ್ಯ ಸ್ಥಾನದಿಂದ ಹುಟ್ಟಿದರೆ, ಪ ವರ್ಗದ ಅಕ್ಷರಗಳು ತುಟಿಗಳ (ಓಷ್ಠ್ಯ) ಸಹಾಯದಿಂದ ಹುಟ್ಟುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u1_15",
            stdId = 8,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಹ್ರಸ್ವ ಸ್ವರ : 06 :: ದೀರ್ಘ ಸ್ವರ : ______’",
            options = listOf("05", "06", "07", "08"),
            correctAnswer = "07",
            explanation = "ಕನ್ನಡದಲ್ಲಿ ಹ್ರಸ್ವ ಸ್ವರಗಳು 6 (ಅ, ಇ, ಉ, ಋ, ಎ, ಒ) ಮತ್ತು ದೀರ್ಘ ಸ್ವರಗಳು 7 (ಆ, ಈ, ಊ, ಏ, ಐ, ಓ, ಔ)."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 2 — ಸಾರ್ಥಕ ಬದುಕಿನ ಸಾಧಕ (16 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u2_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ವಸ್ತು, ವ್ಯಕ್ತಿ, ಪ್ರಾಣಿ, ಸ್ಥಳ ಮುಂತಾದವುಗಳ ಹೆಸರುಗಳನ್ನು ಸೂಚಿಸುವ ಪದಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ನಾಮಪದ (ವಸ್ತುವಾಚಕ)", "ಕ್ರಿಯಾಪದ", "ಸರ್ವನಾಮ", "ಅವ್ಯಯ"),
            correctAnswer = "ನಾಮಪದ (ವಸ್ತುವಾಚಕ)",
            explanation = "ವಸ್ತು, ವ್ಯಕ್ತಿ, ಪ್ರಾಣಿ, ಸ್ಥಳ ಮುಂತಾದ ಹೆಸರುಗಳನ್ನು ಸೂಚಿಸುವ ಶಬ್ದಗಳು ನಾಮಪದಗಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u2_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ನಾಮಪದಗಳಿಗೆ ಬದಲಾಗಿ ಬಳಸುವ ಪದಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಗುಣವಾಚಕ", "ಸರ್ವನಾಮ", "ಕ್ರಿಯಾಪದ", "ಅವ್ಯಯ"),
            correctAnswer = "ಸರ್ವನಾಮ",
            explanation = "ನಾಮಪದದ ಸ್ಥಾನದಲ್ಲಿ ಅದರ ಬದಲಾಗಿ ಬಳಸುವ ಅವನು, ಇವಳು, ನೀನು, ನಾನು ಇತ್ಯಾದಿ ಪದಗಳು ಸರ್ವನಾಮಗಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u2_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "“ಸಚಿನ್ ತುಂಬ ಒಳ್ಳೆಯ ಹುಡುಗ.” ಈ ವಾಕ್ಯದಲ್ಲಿರುವ ಗುಣವಾಚಕ ಪದ ಯಾವುದು?",
            options = listOf("ಸಚಿನ್", "ತುಂಬ", "ಒಳ್ಳೆಯ", "ಹುಡುಗ"),
            correctAnswer = "ಒಳ್ಳೆಯ",
            explanation = "ಹುಡುಗನ ಗುಣವನ್ನು ವರ್ಣಿಸುವ 'ಒಳ್ಳೆಯ' ಎಂಬ ಪದವು ಗುಣವಾಚಕವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u2_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಅನ್ವರ್ಥನಾಮಕ್ಕೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ವಿದ್ಯಾರ್ಥಿ", "ಮಂಕುತಿಮ್ಮ", "ಬೆಂಗಳೂರು", "ಭಾರತ"),
            correctAnswer = "ವಿದ್ಯಾರ್ಥಿ",
            explanation = "ಕಾರಣ ಅಥವಾ ಕಾಯಕ-ವೃತ್ತಿಯ ಸಂಬಂಧದಿಂದ ಬಂದ ಹೆಸರು ಅನ್ವರ್ಥನಾಮ (ಉದಾ: ವಿದ್ಯಾರ್ಥಿ, ವೈದ್ಯ, ಕುರುಡ)."
        ),
        QuestionModel(
            id = "s_8_kan_u2_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಡಿ.ವಿ.ಜಿ. (ಡಿ.ವಿ. ಗುಂಡಪ್ಪ) ಅವರ ಪ್ರಸಿದ್ಧ ಕೃತಿ ಯಾವುದು?",
            options = listOf("ಮಂಕುತಿಮ್ಮನ ಕಗ್ಗ", "ರಾಮಾಯಣ ದರ್ಶನಂ", "ಶ್ರೀರಾಮಾಯಣ", "ಗದಾಯುದ್ಧ"),
            correctAnswer = "ಮಂಕುತಿಮ್ಮನ ಕಗ್ಗ",
            explanation = "ಡಿ.ವಿ. ಗುಂಡಪ್ಪನವರ 'ಮಂಕುತಿಮ್ಮನ ಕಗ್ಗ' ಕನ್ನಡದ ಅಮರ ಜೀವನ ಧರ್ಮದ ಕಾವ್ಯವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u2_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ಮೇಧಾವಿ’ ಪದದ ಸರಿಯಾದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಬುದ್ಧಿವಂತ", "ಬಡವ", "ಸೋಮಾರಿ", "ದುರ್ಬಲ"),
            correctAnswer = "ಬುದ್ಧಿವಂತ",
            explanation = "ಮೇಧಾವಿ ಎಂದರೆ ಅತ್ಯುನ್ನತ ಬುದ್ಧಿಶಕ್ತಿ, ಪ್ರತಿಭೆ ಹೊಂದಿರುವ ವ್ಯಕ್ತಿ (ಬುದ್ಧಿವಂತ)."
        ),
        QuestionModel(
            id = "s_8_kan_u2_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ದಕ್ಷಿಣ’ ಎಂಬುದು ಯಾವ ವಾಚಕಕ್ಕೆ ಉದಾಹರಣೆ?",
            options = listOf("ಪ್ರಮಾಣವಾಚಕ", "ದಿಗ್ವಾಚಕ", "ಸಂಖ್ಯಾವಾಚಕ", "ಗುಣವಾಚಕ"),
            correctAnswer = "ದಿಗ್ವಾಚಕ",
            explanation = "ದಿಕ್ಕುಗಳನ್ನು ಸೂಚಿಸುವ ಪೂರ್ವ, ಪಶ್ಚಿಮ, ಉತ್ತರ, ದಕ್ಷಿಣ ಪದಗಳು ದಿಗ್ವಾಚಕಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u2_8",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಮಧ್ಯಮ ಪುರುಷ ಸರ್ವನಾಮ ಯಾವುದು?",
            options = listOf("ನಾನು", "ಅವನು", "ನೀನು", "ಅವರು"),
            correctAnswer = "ನೀನು",
            explanation = "ಎದುರಿಗಿರುವವರನ್ನು ಉದ್ದೇಶಿಸಿ ಬಳಸುವ 'ನೀನು', 'ನೀವು' ಮಧ್ಯಮ ಪುರುಷ ಸರ್ವನಾಮಗಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u2_9",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಮೈಸೂರು ದಸರಾವನ್ನು ಕರ್ನಾಟಕದಲ್ಲಿ ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ರಾಷ್ಟ್ರಹಬ್ಬ", "ನಾಡಹಬ್ಬ", "ಧಾರ್ಮಿಕ ಹಬ್ಬ", "ಬೆಳೆಹಬ್ಬ"),
            correctAnswer = "ನಾಡಹಬ್ಬ",
            explanation = "ಕರ್ನಾಟಕದ ಐತಿಹಾಸಿಕ ಮತ್ತು ಸಾಂಸ್ಕೃತಿಕ ಪರಂಪರೆಯ ದಸರಾ ಉತ್ಸವವನ್ನು 'ನಾಡಹಬ್ಬ' ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u2_10",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ನದಿ : ರೂಢನಾಮ :: ಗಣೇಶ : ______’",
            options = listOf("ಅನ್ವರ್ಥನಾಮ", "ಅಂಕಿತನಾಮ", "ದಿಗ್ವಾಚಕ", "ಸಂಖ್ಯಾವಾಚಕ"),
            correctAnswer = "ಅಂಕಿತನಾಮ",
            explanation = "ಗುರುತಿಸುವುದಕ್ಕಾಗಿ ಇಟ್ಟ ನಿರ್ದಿಷ್ಟ ಹೆಸರು ಅಂಕಿತನಾಮ (ಉದಾ: ಗಣೇಶ, ಸೀತೆ, ಬೆಂಗಳೂರು)."
        ),
        QuestionModel(
            id = "s_8_kan_u2_11",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ಅಷ್ಟು : ಪ್ರಮಾಣವಾಚಕ :: ಅಂತದ್ದು : ______’",
            options = listOf("ಸಂಖ್ಯಾವಾಚಕ", "ಪ್ರಕಾರವಾಚಕ", "ದಿಗ್ವಾಚಕ", "ಗುಣವಾಚಕ"),
            correctAnswer = "ಪ್ರಕಾರವಾಚಕ",
            explanation = "ವಸ್ತುವಿನ ಪ್ರಕಾರ ಅಥವಾ ರೀತಿಯನ್ನು ತಿಳಿಸುವ ಎಂಥದ್ದು, ಅಂಥದ್ದು, ಇಂಥದ್ದು ಪ್ರಕಾರವಾಚಕಗಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u2_12",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ನಾನು : ಉತ್ತಮ ಪುರುಷ :: ಅವನು : ______’",
            options = listOf("ಮಧ್ಯಮ ಪುರುಷ", "ಉತ್ತಮ ಪುರುಷ", "ಪ್ರಥಮ ಪುರುಷ", "ಆತ್ಮಾರ್ಥಕ"),
            correctAnswer = "ಪ್ರಥಮ ಪುರುಷ",
            explanation = "ದೂರದಲ್ಲಿರುವ ಮೂರನೆಯ ವ್ಯಕ್ತಿಯನ್ನು ಸೂಚಿಸುವ ಅವನು, ಅವಳು, ಅವರು ಪ್ರಥಮ ಪುರುಷ."
        ),
        QuestionModel(
            id = "s_8_kan_u2_13",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ಯಾವುದೂ : ಪ್ರಶ್ನಾರ್ಥಕ ಸರ್ವನಾಮ :: ತಾವು : ______’",
            options = listOf("ಆತ್ಮಾರ್ಥಕ", "ಪ್ರಶ್ನಾರ್ಥಕ", "ಅನಿಶ್ಚಿತಾರ್ಥಕ", "ಸಂಬಂಧಾರ್ಥಕ"),
            correctAnswer = "ಆತ್ಮಾರ್ಥಕ",
            explanation = "ತಾನು, ತಾವು ಎಂಬ ಪದಗಳು ತಮ್ಮನ್ನು ತಾವು ಸೂಚಿಸಿಕೊಳ್ಳುವ ಆತ್ಮಾರ್ಥಕ ಸರ್ವನಾಮಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u2_14",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ಐದು : ಸಂಖ್ಯಾವಾಚಕ :: ಐದನೆಯ : ______’",
            options = listOf("ಪ್ರಮಾಣವಾಚಕ", "ಸಂಖ್ಯೆಯ ವಾಚಕ (ಸಂಖ್ಯೇಯವಾಚಕ)", "ದಿಗ್ವಾಚಕ", "ಪ್ರಕಾರವಾಚಕ"),
            correctAnswer = "ಸಂಖ್ಯೆಯ ವಾಚಕ (ಸಂಖ್ಯೇಯವಾಚಕ)",
            explanation = "ಸಂಖ್ಯೆಯಿಂದ ನಿರ್ದೇಶಿಸಲ್ಪಡುವ ಕ್ರಮವನ್ನು ತಿಳಿಸುವ ಒಂದನೆಯ, ಐದನೆಯ ಪದಗಳು ಸಂಖ್ಯೇಯವಾಚಕಗಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u2_15",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ಬಿಳಿಯದರ ಭಾವ : ಬಿಳುಪು :: ಆಡುವುದರ ಭಾವ : ______’",
            options = listOf("ಆಟ", "ಆಡು", "ಆಟಗಾರ", "ಆಡುವಿಕೆ"),
            correctAnswer = "ಆಟ",
            explanation = "ಕ್ರಿಯಾಪದದ ಭಾವನಾತ್ಮಕ ನಾಮರೂಪ: ಆಡುವುದರ ಭಾವ 'ಆಟ', ನೋಡುವುದರ ಭಾವ 'ನೋಟ'."
        ),
        QuestionModel(
            id = "s_8_kan_u2_16",
            stdId = 8,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "‘ಇಳ : ಭೂಮಿ :: ಕಾನನ : ______’",
            options = listOf("ಬೆಟ್ಟ", "ಅರಣ್ಯ", "ನದಿ", "ಮನೆ"),
            correctAnswer = "ಅರಣ್ಯ",
            explanation = "ಕಾನನ, ಅಡವಿ, ವನ ಎಂದರೆ ಕಾಡು ಅಥವಾ ಅರಣ್ಯ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 3 — ನೀರು ಕೊಡದ ನಾಡಿನಲ್ಲಿ (7 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u3_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಆಂಗ್ಲ ಭಾಷೆಯಿಂದ ಕನ್ನಡಕ್ಕೆ ಬಂದ ಪದ ಯಾವುದು?",
            options = listOf("ಬ್ಯಾಂಕ್", "ಮನೆ", "ನೀರು", "ಮಣ್ಣು"),
            correctAnswer = "ಬ್ಯಾಂಕ್",
            explanation = "'ಬ್ಯಾಂಕ್' (Bank) ಇಂಗ್ಲಿಷ್ ಭಾಷೆಯಿಂದ ಕನ್ನಡದಲ್ಲಿ ನೇರವಾಗಿ ರೂಢಿಗೆ ಬಂದ ಅನ್ಯದೇಶ್ಯ ಪದ."
        ),
        QuestionModel(
            id = "s_8_kan_u3_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ವರ್ಷ’ ಸಂಸ್ಕೃತ ಪದದ ತದ್ಭವ ರೂಪ ಯಾವುದು?",
            options = listOf("ವರ್ಷಾ", "ವರುಷಾ", "ವರ್ಷ", "ವರುಷ"),
            correctAnswer = "ವರುಷ",
            explanation = "ವರ್ಷ ಎಂಬ ತತ್ಸಮ ಪದದ ಕನ್ನಡ ತದ್ಭವ ರೂಪ 'ವರುಷ'."
        ),
        QuestionModel(
            id = "s_8_kan_u3_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರಕ್ಕೆ ಉದಾಹರಣೆಯಾಗಿರುವ ಪದ ಯಾವುದು?",
            options = listOf("ಸಂಸ್ಕೃತಿ", "ವಿದ್ಯೆ", "ಹುನ್ನಾರ", "ಪ್ರಶ್ನೆ"),
            correctAnswer = "ಹುನ್ನಾರ",
            explanation = "ಒಂದೇ ಜಾತಿಯ ವ್ಯಂಜನಕ್ಕೆ ಅದೇ ವ್ಯಂಜನ ಒತ್ತಾಗಿ ಬಂದರೆ ಸಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ (ನ್ + ನ್ = ನ್ನ)."
        ),
        QuestionModel(
            id = "s_8_kan_u3_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ಬುನಾದಿ : ತಳಹದಿ :: ಹರಡು : ______’",
            options = listOf("ಮುಚ್ಚು", "ಪಸರಿಸು", "ನಿಲ್ಲಿಸು", "ಕತ್ತರಿಸು"),
            correctAnswer = "ಪಸರಿಸು",
            explanation = "ಹರಡು ಎಂದರೆ ಸುತ್ತಲೂ ವಿಸ್ತರಿಸು ಅಥವಾ ಪಸರಿಸು."
        ),
        QuestionModel(
            id = "s_8_kan_u3_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ಪಾಣ್ಯ : ಹೂನ್ಯ :: ಪಾರಣ : ______’",
            options = listOf("ಪಯಣ", "ಹರಣ", "ಪಾರಣ", "ಪೂರಣ"),
            correctAnswer = "ಹರಣ",
            explanation = "ಹಳಗನ್ನಡ-ಹೊಸಗನ್ನಡ ರೂಪಾಂತರದಲ್ಲಿ ಪ ಕಾರವು ಹ ಕಾರವಾಗುತ್ತದೆ (ಪಾರಣ -> ಹರಣ)."
        ),
        QuestionModel(
            id = "s_8_kan_u3_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ಜಬರದಸ್ತ್ : ಹಿಂದಿ ಭಾಷೆ :: ಸಾಬೂನು : ______’",
            options = listOf("ಅರೇಬಿಕ್", "ಇಂಗ್ಲಿಷ್", "ಪೋರ್ಚುಗೀಸ್", "ಸಂಸ್ಕೃತ"),
            correctAnswer = "ಪೋರ್ಚುಗೀಸ್",
            explanation = "ಸಾಬೂನು, ಮೇಜು, ಪಾದ್ರಿ, ತಂಬಾಕು ಪದಗಳು ಪೋರ್ಚುಗೀಸ್ ಭಾಷೆಯಿಂದ ಕನ್ನಡಕ್ಕೆ ಬಂದಿವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u3_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ಅಮ್ಮ : ಸಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ :: ಸಂಸ್ಕೃತಿ : ______’",
            options = listOf("ಸಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ", "ವಿಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ", "ದ್ವಿತ್ವಾಕ್ಷರ", "ಅನುನಾಸಿಕ"),
            correctAnswer = "ವಿಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ",
            explanation = "ಬೇರೆ ಬೇರೆ ವ್ಯಂಜನಗಳು ಒಂದಕ್ಕೊಂದು ಒತ್ತಾಗಿ ಸೇರಿದಾಗ ವಿಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರವಾಗುತ್ತದೆ (ಸ್ಕೃ)."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 4 — ಯಶೋಧರೆ (10 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u4_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸ್ತ್ರೀಲಿಂಗಕ್ಕೆ ಸೂಕ್ತ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಸಿದ್ಧಾರ್ಥ", "ಯಶೋಧರೆ", "ರಾಜ", "ಗಿರೀಶ"),
            correctAnswer = "ಯಶೋಧರೆ",
            explanation = "ಹೆಣ್ಣು ಜೀವಿಯನ್ನು ಸೂಚಿಸುವ 'ಯಶೋಧರೆ' ಸ್ತ್ರೀಲಿಂಗ ನಾಮಪದ."
        ),
        QuestionModel(
            id = "s_8_kan_u4_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಏಕವಚನ ಪದ ಯಾವುದು?",
            options = listOf("ಅವರು", "ಮಕ್ಕಳು", "ರಾಣಿಯರು", "ನೀನು"),
            correctAnswer = "ನೀನು",
            explanation = "ಒಬ್ಬ ವ್ಯಕ್ತಿಯನ್ನು ಮಾತ್ರ ಸೂಚಿಸುವ 'ನೀನು' ಏಕವಚನವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u4_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಪೂರ್ಣ ಕ್ರಿಯಾಪದದೊಡನೆ ಸ್ವತಂತ್ರವಾಗಿರುವ ವಾಕ್ಯವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸಾಮಾನ್ಯ ವಾಕ್ಯ", "ಸಂಯುಕ್ತ ವಾಕ್ಯ", "ಮಿಶ್ರ ವಾಕ್ಯ", "ಪ್ರಶ್ನಾರ್ಥಕ ವಾಕ್ಯ"),
            correctAnswer = "ಸಾಮಾನ್ಯ ವಾಕ್ಯ",
            explanation = "ಒಂದೇ ಸ್ವತಂತ್ರ ಮುಖ್ಯ ವಾಕ್ಯ ಮತ್ತು ಪೂರ್ಣ ಕ್ರಿಯಾಪದವಿರುವ ವಾಕ್ಯ ಸಾಮಾನ್ಯ ವಾಕ್ಯ."
        ),
        QuestionModel(
            id = "s_8_kan_u4_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "‘ಕಾರ್ಯ’ ಪದದ ತದ್ಭವ ರೂಪ ಯಾವುದು?",
            options = listOf("ಕಾಯ", "ಕಾಯಾ", "ಕಜ್ಜ", "ಕಾಯಿ"),
            correctAnswer = "ಕಜ್ಜ",
            explanation = "ಸಂಸ್ಕೃತದ 'ಕಾರ್ಯ' ತತ್ಸಮದ ಕನ್ನಡ ತದ್ಭವ ರೂಪ 'ಕಜ್ಜ'."
        ),
        QuestionModel(
            id = "s_8_kan_u4_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸವರ್ಣದೀರ್ಘ ಸಂಧಿಗೆ ಸರಿಯಾದ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ದೇವಾಲಯ", "ಚಕ್ರಾಧಿಪತಿ", "ಲೋಕೋಪಕಾರ", "ಮಹೇಶ್ವರ"),
            correctAnswer = "ಚಕ್ರಾಧಿಪತಿ",
            explanation = "ಚಕ್ರ + ಅಧಿಪತಿ = ಚಕ್ರಾಧಿಪತಿ (ಅ + ಅ = ಆ, ಸವರ್ಣ ಸ್ವರ ಸೇರಿ ದೀರ್ಘವಾಗಿದೆ)."
        ),
        QuestionModel(
            id = "s_8_kan_u4_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "“ಸಿದ್ಧಾರ್ಥನು ಕ್ರಿಯೆಯನ್ನು ಕೇಳಿಸಿಕೊಳ್ಳಲಿ.” — ಈ ವಾಕ್ಯದಲ್ಲಿ ಕರ್ತೃ ಯಾವುದು?",
            options = listOf("ಸಿದ್ಧಾರ್ಥನು", "ಕ್ರಿಯೆಯನ್ನು", "ಕೇಳಿಸಿಕೊಳ್ಳಲಿ", "ವಾಕ್ಯ"),
            correctAnswer = "ಸಿದ್ಧಾರ್ಥನು",
            explanation = "ಕ್ರಿಯೆಯನ್ನು ಮಾಡುವವನು ಕರ್ತೃ; ಇಲ್ಲಿ ಸಿದ್ಧಾರ್ಥನು ಕರ್ತೃ ಪದವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u4_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "‘ಗಿರೀಶ : ಪುಲ್ಲಿಂಗ :: ಅರಮನೆ : ______’",
            options = listOf("ಸ್ತ್ರೀಲಿಂಗ", "ಪುಲ್ಲಿಂಗ", "ನಪುಂಸಕಲಿಂಗ", "ಬಹುವಚನ"),
            correctAnswer = "ನಪುಂಸಕಲಿಂಗ",
            explanation = "ಮಾನವೇತರ ವಸ್ತುಗಳು ಮತ್ತು ಕಟ್ಟಡಗಳು ನಪುಂಸಕಲಿಂಗಕ್ಕೆ ಸೇರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u4_8",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "‘ರಾಣಿ : ರಾಣಿಯರು :: ಮಗು : ______’",
            options = listOf("ಮಗುವು", "ಮಕ್ಕಳು", "ಮಗಗಳು", "ಮಗುವರು"),
            correctAnswer = "ಮಕ್ಕಳು",
            explanation = "ಮಗು ಎಂಬ ಏಕವಚನ ಪದದ ಬಹುವಚನ ರೂಪ 'ಮಕ್ಕಳು'."
        ),
        QuestionModel(
            id = "s_8_kan_u4_9",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "‘ವಿನೋದ : ಬಿನೋದ :: ರಾಜ : ______’",
            options = listOf("ರಾಯ", "ರಾಜಾ", "ರಜ", "ರಜಾ"),
            correctAnswer = "ರಾಯ",
            explanation = "ರಾಜ ತತ್ಸಮದ ದೇಶ್ಯ/ತದ್ಭವ ರೂಪ 'ರಾಯ'."
        ),
        QuestionModel(
            id = "s_8_kan_u4_10",
            stdId = 8,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "‘ಪತಿಯೊಡನೆ’ ಪದವು ಯಾವ ಸಂಧಿಗೆ ಉದಾಹರಣೆ?",
            options = listOf("ವಿಸರ್ಗಸಂಧಿ", "ಆಗಮಸಂಧಿ", "ಗುಣಸಂಧಿ", "ಸವರ್ಣದೀರ್ಘಸಂಧಿ"),
            correctAnswer = "ಆಗಮಸಂಧಿ",
            explanation = "ಪತಿ + ಒಡನೆ = ಪತಿಯೊಡನೆ (ಇ ಕಾರದ ಮುಂದೆ ಸ್ವರ ಬಂದು 'ಯ್' ಕಾರಾಗಮವಾಗಿದೆ)."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 5 — ಭಾರತೀಯತೆ (10 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u5_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮೂರು ಸಾಲುಗಳ ಪದ್ಯ ಪ್ರಕಾರವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ದ್ವಿಪದಿ", "ಚೌಪದಿ", "ತ್ರಿಪದಿ", "ಷಟ್ಪದಿ"),
            correctAnswer = "ತ್ರಿಪದಿ",
            explanation = "ಮೂರು ಪಾದಗಳನ್ನು ಹೊಂದಿರುವ ಕನ್ನಡದ ದೇಸೀ ಛಂದಸ್ಸಿನ ಪದ್ಯವೇ ತ್ರಿಪದಿ (ಉದಾ: ಸರ್ವಜ್ಞನ ವಚನಗಳು)."
        ),
        QuestionModel(
            id = "s_8_kan_u5_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಹದಿನಾಲ್ಕು ಪಾದಗಳುಳ್ಳ ಇಂಗ್ಲಿಷ್ ಮೂಲದ ಕಾವ್ಯ ಪ್ರಕಾರ (ಸಾನೆಟ್) ಕ್ಕೆ ಕನ್ನಡದಲ್ಲಿ ಏನೆನ್ನುತ್ತಾರೆ?",
            options = listOf("ಅಷ್ಟಷಟ್ಪದಿ (ಸುನೀತ)", "ತ್ರಿಪದಿ", "ಷಟ್ಪದಿ", "ಕಂದಪದ್ಯ"),
            correctAnswer = "ಅಷ್ಟಷಟ್ಪದಿ (ಸುನೀತ)",
            explanation = "14 ಸಾಲುಗಳ ಇಂಗ್ಲಿಷ್ ಸಾನೆಟ್ ಪ್ರಕಾರವನ್ನು ಕನ್ನಡದಲ್ಲಿ ಸುನೀತ ಅಥವಾ ಅಷ್ಟಷಟ್ಪದಿ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u5_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮಾತ್ರೆಗಳ ಆಧಾರದಿಂದ ಗಣ ವಿಭಾಗ ಮಾಡುವುದನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ವರ್ಣಗಣ", "ಮಾತ್ರಾಗಣ", "ಅಕ್ಷರಗಣ", "ಪದಗಣ"),
            correctAnswer = "ಮಾತ್ರಾಗಣ",
            explanation = "ಮಾತ್ರೆಗಳ ಲೆಕ್ಕಾಚಾರದಿಂದ (3, 4 ಅಥವಾ 5 ಮಾತ್ರೆಗಳು) ಗಣ ವಿಂಗಡಿಸುವುದು ಮಾತ್ರಾಗಣ."
        ),
        QuestionModel(
            id = "s_8_kan_u5_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪದ್ಯ ಓದುವಾಗ ಅರ್ಥಕ್ಕೆ ಲೋಪವಾಗದಂತೆ ನಿಲ್ಲಿಸುವ ಸ್ಥಳವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಪ್ರಾಸ", "ಗಣ", "ಯತಿ", "ಛಂದಸ್ಸು"),
            correctAnswer = "ಯತಿ",
            explanation = "ಪದ್ಯದ ಸಾಲಿನಲ್ಲಿ ನಿಶ್ಚಿತ ಜಾಗದಲ್ಲಿ ವಿರಾಮ ತೆಗೆದುಕೊಳ್ಳುವ ಸ್ಥಾನಕ್ಕೆ 'ಯತಿ' ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u5_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪ್ರತಿ ಸಾಲಿನ ಎರಡನೆಯ ಅಕ್ಷರ ಒಂದೇ ಆಗಿ ಬರುವ ನಿಯಮ ಯಾವುದು?",
            options = listOf("ಆದಿಪ್ರಾಸ", "ಅಂತ್ಯಪ್ರಾಸ", "ಮಧ್ಯಪ್ರಾಸ", "ದ್ವಿತೀಯಪ್ರಾಸ"),
            correctAnswer = "ಆದಿಪ್ರಾಸ",
            explanation = "ಪದ್ಯದ ಪ್ರತಿ ಪಾದದ ಎರಡನೆಯ ಅಕ್ಷರ ನಿಯಮಬದ್ಧವಾಗಿ ಒಂದೇ ಸಮನಾಗಿರುವುದನ್ನು ಆದಿಪ್ರಾಸ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u5_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "“ಗಡಿನಾಡುಗಳಲ್ಲಿ ಸೈನಿಕರು ಕಾವಲು ಕಾಯುತ್ತಾರೆ.” ಇದರ ಅರ್ಥವತ್ತಾದ ಸೂಕ್ತ ರೂಪ:",
            options = listOf("ಸೈನಿಕರು ಆಟವಾಡುತ್ತಿದ್ದಾರೆ", "ಸೈನಿಕರು ಮನೆಗೆ ಹೋಗುತ್ತಿದ್ದಾರೆ", "ಸೈನಿಕರು ದೇಶ ಸೇವೆಯನ್ನು ಮಾಡುತ್ತಿದ್ದಾರೆ", "ಸೈನಿಕರು ವಿಶ್ರಾಂತಿ ಪಡೆಯುತ್ತಿದ್ದಾರೆ"),
            correctAnswer = "ಸೈನಿಕರು ದೇಶ ಸೇವೆಯನ್ನು ಮಾಡುತ್ತಿದ್ದಾರೆ",
            explanation = "ಗಡಿಕಾಯುವುದು ದೇಶ ರಕ್ಷಣೆ ಹಾಗೂ ದೇಶ ಸೇವೆಯ ಅತ್ಯುನ್ನತ ರೂಪವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u5_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಮೈಸೂರು ಮಲ್ಲಿಗೆ’ ಖ್ಯಾತಿಯ ಕೆ.ಎಸ್. ನರಸಿಂಹಸ್ವಾಮಿ ಅವರ ಸಾಹಿತ್ಯ ಪ್ರಕಾರ ಯಾವುದು?",
            options = listOf("ನಾಟಕಗಳು", "ಕಾದಂಬರಿಗಳು", "ಕಥೆಗಳು", "ಕವನಗಳು"),
            correctAnswer = "ಕವನಗಳು",
            explanation = "ಕೆ.ಎಸ್. ನರಸಿಂಹಸ್ವಾಮಿ ಅವರು ಪ್ರೇಮ ಮತ್ತು ದಾಂಪತ್ಯ ಗೀತೆಗಳನ್ನು ರಚಿಸಿದ ನವೋದಯದ ಪ್ರಸಿದ್ಧ ಕವಿ."
        ),
        QuestionModel(
            id = "s_8_kan_u5_8",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಕೊರಳು : ಧ್ವನಿ :: ಯೋಧ : ______’",
            options = listOf("ಜೋಧ", "ಶಾಂತಿ", "ಸೈನಿಕ", "ಯುದ್ಧ"),
            correctAnswer = "ಜೋಧ",
            explanation = "ಯೋಧ ಪದದ ದೇಸೀ/ತದ್ಭವ ರೂಪ 'ಜೋಧ'."
        ),
        QuestionModel(
            id = "s_8_kan_u5_9",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ನಾಲ್ಕು ಪಾದ : ಕಂದಪದ್ಯ :: ಆರು ಪಾದ : ______’",
            options = listOf("ತ್ರಿಪದಿ", "ಕಂದಪದ್ಯ", "ಷಟ್ಪದಿ", "ದ್ವಿಪದಿ"),
            correctAnswer = "ಷಟ್ಪದಿ",
            explanation = "ಆರು ಪಾದಗಳನ್ನು (ಸಾಲುಗಳನ್ನು) ಒಳಗೊಂಡಿರುವ ಪದ್ಯವೇ ಷಟ್ಪದಿ."
        ),
        QuestionModel(
            id = "s_8_kan_u5_10",
            stdId = 8,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಭಾರತ : ಅಂಕಿತನಾಮ :: ಪರ್ವತ : ______’",
            options = listOf("ಅಂಕಿತನಾಮ", "ರೂಢನಾಮ", "ಅನ್ವರ್ಥನಾಮ", "ದಿಗ್ವಾಚಕ"),
            correctAnswer = "ರೂಢನಾಮ",
            explanation = "ರೂಢಿಯಿಂದ ಬಂದ ನದಿ, ಬೆಟ್ಟ, ಪರ್ವತ, ದೇಶ ಪದಗಳು ರೂಢನಾಮಗಳು."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 6 — ಬೇವು ಬೆಲ್ಲ ದಳಿಡಲೇನ್ನ ಫಲ (10 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u6_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ದ್ವಿತೀಯಾ ವಿಭಕ್ತಿಯ ಹೊಸಗನ್ನಡ ಪ್ರತ್ಯಯ ಯಾವುದು?",
            options = listOf("ಅನ್ನು", "ಇಂದ", "ಗೆ", "ಅ"),
            correctAnswer = "ಅನ್ನು",
            explanation = "ಕರ್ಮ ಕಾರಕಾರ್ಥವನ್ನು ಸೂಚಿಸುವ ದ್ವಿತೀಯಾ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ 'ಅನ್ನು'."
        ),
        QuestionModel(
            id = "s_8_kan_u6_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ಸಪ್ತಮೀ ವಿಭಕ್ತಿಯ ಕಾರಕಾರ್ಥ ಯಾವುದು?",
            options = listOf("ಅಪಾದಾನ", "ಕರಣ", "ಸಂಬಂಧ", "ಅಧಿಕರಣ"),
            correctAnswer = "ಅಧಿಕರಣ",
            explanation = "ಸ್ಥಳ ಅಥವಾ ಆಧಾರವನ್ನು ತಿಳಿಸುವ ಸಪ್ತಮೀ ವಿಭಕ್ತಿಯ ಕಾರಕಾರ್ಥ 'ಅಧಿಕರಣ' (ನಲ್ಲಿ)."
        ),
        QuestionModel(
            id = "s_8_kan_u6_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "“ಬೇಟೆಗಾರನ ದೆಸೆಯಿಂದ ಜಿಂಕೆಗಳ ಜೋಡಿ ಅಗಲಿತು.” — ಇಲ್ಲಿ ಪಂಚಮೀ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ ಯಾವುದು?",
            options = listOf("ಬೇಟೆಗಾರನ", "ದೆಸೆಯಿಂದ", "ಜಿಂಕೆಗಳ", "ಜೋಡಿ"),
            correctAnswer = "ದೆಸೆಯಿಂದ",
            explanation = "ಪಂಚಮೀ ವಿಭಕ್ತಿಯ ಪ್ರತ್ಯಯ 'ದೆಸೆಯಿಂದ' (ಅಪಾದಾನ ಕಾರಕಾರ್ಥ)."
        ),
        QuestionModel(
            id = "s_8_kan_u6_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಮನೆಯಿಂದ’ ಪದವು ಯಾವ ವಿಭಕ್ತಿಗೆ ಉದಾಹರಣೆ?",
            options = listOf("ಪ್ರಥಮಾ", "ದ್ವಿತೀಯಾ", "ತೃತೀಯಾ", "ಸಪ್ತಮೀ"),
            correctAnswer = "ತೃತೀಯಾ",
            explanation = "ಸಾಧನ ಅಥವಾ ಕರಣ ಕಾರಕಾರ್ಥವನ್ನು ಸೂಚಿಸುವ ತೃತೀಯಾ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ 'ಇಂದ' (ಮನೆ + ಇಂದ = ಮನೆಯಿಂದ)."
        ),
        QuestionModel(
            id = "s_8_kan_u6_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಪಂಚಮೀ ವಿಭಕ್ತಿ : ಅಪಾದಾನ :: ಷಷ್ಠೀ ವಿಭಕ್ತಿ : ______’",
            options = listOf("ಕರಣ", "ಸಂಬಂಧ", "ಅಧಿಕರಣ", "ಕರ್ತೃ"),
            correctAnswer = "ಸಂಬಂಧ",
            explanation = "ಷಷ್ಠೀ ವಿಭಕ್ತಿಯ ಪ್ರತ್ಯಯ 'ಅ' ಆಗಿದ್ದು ಅದರ ಕಾರಕಾರ್ಥ 'ಸಂಬಂಧ'."
        ),
        QuestionModel(
            id = "s_8_kan_u6_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಗೆ : ಚತುರ್ಥೀ ವಿಭಕ್ತಿ :: ಉ : ______’",
            options = listOf("ಪ್ರಥಮಾ ವಿಭಕ್ತಿ", "ದ್ವಿತೀಯಾ ವಿಭಕ್ತಿ", "ಪಂಚಮೀ ವಿಭಕ್ತಿ", "ಷಷ್ಠೀ ವಿಭಕ್ತಿ"),
            correctAnswer = "ಪ್ರಥಮಾ ವಿಭಕ್ತಿ",
            explanation = "ಪ್ರಥಮಾ ವಿಭಕ್ತಿಯ ಹೊಸಗನ್ನಡ ಪ್ರತ್ಯಯ 'ಉ' (ಕರ್ತೃ ಕಾರಕಾರ್ಥ)."
        ),
        QuestionModel(
            id = "s_8_kan_u6_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಕುಟಿಲ’ (ಕುಟ್ಟಲ) ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಮೋಸ", "ಕೋಪ", "ಸಂತೋಷ", "ಭಯ"),
            correctAnswer = "ಮೋಸ",
            explanation = "ಕುಟಿಲ ಎಂದರೆ ಕಪಟತನ ಅಥವಾ ಮೋಸದ ಬುದ್ಧಿ."
        ),
        QuestionModel(
            id = "s_8_kan_u6_8",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಸಟೆ’ ಪದದ ಅರ್ಥವೇನು?",
            options = listOf("ಸತ್ಯ", "ಸುಳ್ಳು", "ಧೈರ್ಯ", "ಭಯ"),
            correctAnswer = "ಸುಳ್ಳು",
            explanation = "ಸಟೆ ಎಂದರೆ ಅಸತ್ಯ ಅಥವಾ ಸುಳ್ಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u6_9",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಕುಜನರು’ ಎಂದರೆ ಯಾರು?",
            options = listOf("ಒಳ್ಳೆಯ ಜನರು", "ಕೆಟ್ಟ ಜನರು", "ವಿದ್ಯಾವಂತರು", "ಶ್ರೀಮಂತರು"),
            correctAnswer = "ಕೆಟ್ಟ ಜನರು",
            explanation = "ಕು + ಜನರು = ಕುಜನರು, ಎಂದರೆ ದುಷ್ಟರು ಅಥವಾ ಕೆಟ್ಟ ನಡತೆಯುಳ್ಳವರು."
        ),
        QuestionModel(
            id = "s_8_kan_u6_10",
            stdId = 8,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಮನುಜ’ ಪದದ ಅರ್ಥ:",
            options = listOf("ಪ್ರಾಣಿ", "ಮಾನವ", "ದೇವರು", "ರಾಜ"),
            correctAnswer = "ಮಾನವ",
            explanation = "ಮನುವಿನ ಸಂತತಿಯಾದ ಮನುಷ್ಯ ಅಥವಾ ಮಾನವನಿಗೆ 'ಮನುಜ' ಎನ್ನುತ್ತಾರೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 7 — ಸೋಮೇಶ್ವರ ಶತಕ (11 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u7_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "‘ಉಡುರಾಜ’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಸೂರ್ಯ", "ಚಂದ್ರ", "ನಕ್ಷತ್ರ", "ಆಕಾಶ"),
            correctAnswer = "ಚಂದ್ರ",
            explanation = "ಉಡು (ನಕ್ಷತ್ರಗಳ) ರಾಜನಾದವನು ಚಂದ್ರ."
        ),
        QuestionModel(
            id = "s_8_kan_u7_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "‘ಭಕ್ತಿಯುಳು’ ಪದವು ಯಾವ ಸಂಧಿಗೆ ಉದಾಹರಣೆ?",
            options = listOf("ಆಗಮಸಂಧಿ", "ಲೋಪಸಂಧಿ", "ಆದೇಶಸಂಧಿ", "ಗುಣಸಂಧಿ"),
            correctAnswer = "ಆಗಮಸಂಧಿ",
            explanation = "ಭಕ್ತಿ + ಉಳು = ಭಕ್ತಿಯುಳು (ಯ್ ಕಾರಾಗಮ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s_8_kan_u7_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಆದೇಶಸಂಧಿಗೆ ಸರಿಯಾದ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ದೇವಾಲಯ", "ಲೋಕೋಪಕಾರ", "ಮಹೇಶ್ವರ", "ಕಳಗುಂದು"),
            correctAnswer = "ಕಳಗುಂದು",
            explanation = "ಕಣ್ + ಕುಂದು = ಕಳಗುಂದು (ಕ-ತ-ಪ ಗಳಿಗೆ ಗ-ದ-ಬ ಆದೇಶವಾಗಿದೆ)."
        ),
        QuestionModel(
            id = "s_8_kan_u7_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "‘ಧರ್ಮ : ಅಧರ್ಮ :: ಬಡವ : ______’",
            options = listOf("ಬಡವ", "ಬಲ್ಲಿದ", "ಶ್ರೀಮಂತ", "ದರಿದ್ರ"),
            correctAnswer = "ಬಲ್ಲಿದ",
            explanation = "ಬಡವನ ವಿರುದ್ಧ ಪದ ದೇಶ್ಯ ರೂಪದಲ್ಲಿ 'ಬಲ್ಲಿದ' (ಶ್ರೀಮಂತ/ಶಕ್ತಿಶಾಲಿ)."
        ),
        QuestionModel(
            id = "s_8_kan_u7_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "‘ಕಾರ್ಯ : ಕಜ್ಜ :: ಭಕ್ತಿ : ______’",
            options = listOf("ಭಕುತಿ", "ಭಕ್ತಿ", "ಭಕ್ತ", "ಭಕ್ತಿಯು"),
            correctAnswer = "ಭಕುತಿ",
            explanation = "ಭಕ್ತಿ ತತ್ಸಮದ ಕನ್ನಡ ತದ್ಭವ ರೂಪ 'ಭಕುತಿ'."
        ),
        QuestionModel(
            id = "s_8_kan_u7_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "‘ನ್ಯಗ್ರೋಧ : ಆಲದಮರ :: ಪಾದಪ : ______’",
            options = listOf("ಸಣ್ಣ ಮರ", "ದೊಡ್ಡ ಮರ", "ಹೂವಿನ ಮರ", "ಹಣ್ಣಿನ ಮರ"),
            correctAnswer = "ದೊಡ್ಡ ಮರ",
            explanation = "ಪಾದಪ ಅಥವಾ ಮಹಾವೃಕ್ಷ ಎಂದರೆ ದೊಡ್ಡ ಮರ."
        ),
        QuestionModel(
            id = "s_8_kan_u7_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಸೋಮೇಶ್ವರ ಶತಕದ ಪ್ರಕಾರ, “ಹಿತವನ್ನ ತೋರುವವನೇ ನಿಜವಾದ ______”",
            options = listOf("ಶತ್ರು", "ಬಂಧು", "ರಾಜ", "ಗುರು"),
            correctAnswer = "ಬಂಧು",
            explanation = "ಯಾವಾಗಲೂ ಹಿತವನ್ನು ಬಯಸಿ ಹೇಳುವವನೇ ನಿಜವಾದ ಆಪ್ತ ಬಂಧು."
        ),
        QuestionModel(
            id = "s_8_kan_u7_8",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "“ಸತಿಯೀ ಸರ್ವಕೆ ಸಾಧನಂ ಕಲಿಸಿದಾತಂ ______”",
            options = listOf("ತಾಯಿ", "ತಂದೆ", "ಗುರು", "ಸುತ"),
            correctAnswer = "ತಂದೆ",
            explanation = "ಸಂಸ್ಕಾರ ಮತ್ತು ಜೀವನ ಸೂತ್ರ ಕಲಿಸಿದ ತಂದೆಯು ಶ್ರೇಷ್ಠ ಮಾರ್ಗದರ್ಶಕ."
        ),
        QuestionModel(
            id = "s_8_kan_u7_9",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "“ಸುತನೀ ಸದ್ಗತಿ ದಾತನೈ ______”",
            options = listOf("ತಂದೆ", "ಗುರು", "ಸತಿ", "ಬಂಧು"),
            correctAnswer = "ಸತಿ",
            explanation = "ಧರ್ಮಪತ್ನಿಯು ಸದ್ಗತಿಯ ಸಂಸಾರ ರಥವನ್ನು ಮುನ್ನಡೆಸುತ್ತಾಳೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u7_10",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಅಜ್ಞಾನವನ್ನು ಕಳೆದು ಜ್ಞಾನದ ಬೆಳಕು ತೋರುವವನು ಯಾರು?",
            options = listOf("ಗುರು", "ರಾಜ", "ತಂದೆ", "ಸುತ"),
            correctAnswer = "ಗುರು",
            explanation = "ಗುರುವು ಶಿಷ್ಯನ ಅಂಧಕಾರವನ್ನು ನೀಗಿಸಿ ವಿದ್ಯೆ ಕಲಿಸುತ್ತಾನೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u7_11",
            stdId = 8,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ವಂಶೋದ್ಧಾರಕನಾಗಿ ಕೀರ್ತಿ ತರುವ ಮಗನನ್ನು ಏನೆನ್ನುತ್ತಾರೆ?",
            options = listOf("ಬಂಧು", "ಸತಿ", "ಸುತ", "ಗುರು"),
            correctAnswer = "ಸುತ",
            explanation = "ಸುತ ಎಂದರೆ ಸತ್ಪುತ್ರ ಅಥವಾ ಮಗ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 8 — ಕನ್ನಡಿಗರ ತಾಯಿ (11 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u8_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ವ್ಯಂಜನಗಳಿಗೆ ಸ್ವರಗಳು ಸೇರಿದಾಗ ಉಂಟಾಗುವ ಅಕ್ಷರ ರೂಪ ಯಾವುದು?",
            options = listOf("ಗುಣಿತಾಕ್ಷರ", "ಸಂಧಿ", "ಸಮಾಸ", "ಯೋಗವಾಹ"),
            correctAnswer = "ಗುಣಿತಾಕ್ಷರ",
            explanation = "ಕ್ + ಅ = ಕ, ಕ್ + ಆ = ಕಾ ಇತ್ಯಾದಿ ವ್ಯಂಜನ ಮತ್ತು ಸ್ವರಗಳ ಸಂಯೋಗವೇ ಗುಣಿತಾಕ್ಷರ (ಕಾಗುಣಿತ)."
        ),
        QuestionModel(
            id = "s_8_kan_u8_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಎರಡು ಅಥವಾ ಹೆಚ್ಚು ವ್ಯಂಜನಗಳು ಸ್ವರದೊಂದಿಗೆ ಸೇರಿದಾಗ ಉಂಟಾಗುವುದು:",
            options = listOf("ಸ್ವರ", "ಸಂಯುಕ್ತಾಕ್ಷರ (ಒತ್ತಕ್ಷರ)", "ಯೋಗವಾಹ", "ಅನುನಾಸಿಕ"),
            correctAnswer = "ಸಂಯುಕ್ತಾಕ್ಷರ (ಒತ್ತಕ್ಷರ)",
            explanation = "ವ್ಯಂಜನಕ್ಕೆ ವ್ಯಂಜನ ಸೇರಿ ನಂತರ ಸ್ವರ ಸೇರಿದಾಗ ಸಂಯುಕ್ತಾಕ್ಷರ ಅಥವಾ ಒತ್ತಕ್ಷರವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u8_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಒಂದೇ ಜಾತಿಯ ಎರಡು ವ್ಯಂಜನಗಳು ಸೇರಿದರೆ ಅದು:",
            options = listOf("ಸಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ", "ವಿಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ", "ಗುಣಿತಾಕ್ಷರ", "ಯೋಗವಾಹ"),
            correctAnswer = "ಸಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ",
            explanation = "ಕ ಕ್ಕೆ ಕ ವತ್ತು, ತ ಕ್ಕೆ ತ ವತ್ತು ಬಂದರೆ ಸಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ (ದ್ವಿತ್ವ)."
        ),
        QuestionModel(
            id = "s_8_kan_u8_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಬೇರೆ ಬೇರೆ ಜಾತಿಯ ವ್ಯಂಜನಗಳು ಸೇರಿದಾಗ ಉಂಟಾಗುವ ಸಂಯುಕ್ತಾಕ್ಷರ:",
            options = listOf("ಸ್ವರ", "ಗುಣಿತಾಕ್ಷರ", "ವಿಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ", "ಅನುಸ್ವಾರ"),
            correctAnswer = "ವಿಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ",
            explanation = "ಬೇರೆ ವ್ಯಂಜನಕ್ಕೆ ಮತ್ತೊಂದು ವ್ಯಂಜನ ಸೇರಿದರೆ ವಿಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ (ಉದಾ: ರಕ್ + ತ = ರಕ್ತ)."
        ),
        QuestionModel(
            id = "s_8_kan_u8_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "‘ವಿದ್ಯೆ’ ಪದದಲ್ಲಿರುವ ‘ದ್ಯೆ’ ಯಾವ ಅಕ್ಷರಕ್ಕೆ ಉದಾಹರಣೆ?",
            options = listOf("ಸಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ", "ವಿಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ", "ದೀರ್ಘಸ್ವರ", "ಯೋಗವಾಹ"),
            correctAnswer = "ವಿಜಾತೀಯ ಸಂಯುಕ್ತಾಕ್ಷರ",
            explanation = "ದ್ + ಯ್ ಸೇರಿದ ಸಂಯುಕ್ತಾಕ್ಷರ ವಿಜಾತೀಯವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u8_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಹೊಯ್ಸಳರ ಶಿಲ್ಪಕಲೆಯ ತವರೂರಾದ ಬೇಲೂರನ್ನು ಕವಿತೆಯಲ್ಲಿ ಹೇಗೆ ವರ್ಣಿಸಲಾಗಿದೆ?",
            options = listOf("ಬೀಳೂರು", "ಬೆಂಗಳೂರು", "ಮೈಸೂರು", "ಹಂಪಿ"),
            correctAnswer = "ಬೀಳೂರು",
            explanation = "ಪ್ರಾಚೀನ ಕಾವ್ಯ ಶೈಲಿಯಲ್ಲಿ ಬೇಲೂರಿನ ಉಲ್ಲೇಖವಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u8_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಕನ್ನಡ ತಾಯಿಯ ಮಡಿಲಿನಲ್ಲಿ ಸುಮಧುರವಾಗಿ ಇಂಪಾಗಿ ಹಾಡುವ ಜೀವ ಯಾವುದು?",
            options = listOf("ಪ್ರಾಣಿ", "ಪಕ್ಷಿ", "ಮರ", "ಹೂವು"),
            correctAnswer = "ಪಕ್ಷಿ",
            explanation = "ಕೋಗಿಲೆ ಮುಂತಾದ ಸುಸ್ವರದ ಹಕ್ಕಿ/ಪಕ್ಷಿಗಳು ಕನ್ನಡ ನಾಡಿನ ಪ್ರಕೃತಿ ಸಿರಿಯನ್ನು ಹೆಚ್ಚಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u8_8",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ಹಸಿರು ಕಾನನದ ಸಹ್ಯಾದ್ರಿ ಸಾಲುಗಳು ಯಾವುದಕ್ಕೆ ಉದಾಹರಣೆ?",
            options = listOf("ನದಿ", "ಪರ್ವತ", "ಸಮುದ್ರ", "ಕಾಡು"),
            correctAnswer = "ಪರ್ವತ",
            explanation = "ಸಹ್ಯಾದ್ರಿ ಗಿರಿಶ್ರೇಣಿಯು ಕರ್ನಾಟಕದ ಶ್ರೇಷ್ಠ ಪರ್ವತ ಶ್ರೇಣಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u8_9",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಕನ್ನಡ ತಾಯಿಯನ್ನು ಕವಿಗಳು ಪ್ರೀತಿಯಿಂದ ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಕನ್ನಡಾಂಬೆ", "ಭಾರತಾಂಬೆ", "ತಾಯಮ್ಮ", "ಕರ್ನಾಟಕ ದೇವಿ"),
            correctAnswer = "ಕನ್ನಡಾಂಬೆ",
            explanation = "ಕನ್ನಡ ನಾಡಿನ ಅಧಿದೇವತೆಯನ್ನು ಗೌರವದಿಂದ 'ಕನ್ನಡಾಂಬೆ' ಅಥವಾ 'ಭುವನೇಶ್ವರಿ' ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u8_10",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಪ್ರಕೃತಿಯಲ್ಲಿ ಲತೆಯು ಪ್ರಕೃತಿದೇವಿಗೆ ಏನನ್ನು ಸಮರ್ಪಿಸುತ್ತದೆ?",
            options = listOf("ಹಣ್ಣು ಮಾತ್ರ", "ಪತ್ರ-ಪುಷ್ಪಗಳನ್ನು", "ನೀರು", "ಮರದ ತೊಗಟೆ"),
            correctAnswer = "ಪತ್ರ-ಪುಷ್ಪಗಳನ್ನು",
            explanation = "ಬಳ್ಳಿಗಳು (ಲತೆಗಳು) ಹಸಿರೆಲೆ ಮತ್ತು ಸುಂದರ ಸುಮ-ಪುಷ್ಪಗಳಿಂದ ತಾಯಿಯನ್ನು ಅಲಂಕರಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u8_11",
            stdId = 8,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಕನ್ನಡ ತಾಯಿಯ ಬಸಿರ ಹೊನ್ನುಗಣಿ ಎಂದು ಯಾರನ್ನು ಸ್ಮರಿಸಲಾಗಿದೆ?",
            options = listOf("ಪಂಪರು", "ವಿದ್ಯಾರಣ್ಯರು", "ಬಸವಣ್ಣ", "ರನ್ನ"),
            correctAnswer = "ವಿದ್ಯಾರಣ್ಯರು",
            explanation = "ವಿಜಯನಗರ ಸಾಮ್ರಾಜ್ಯದ ಸ್ಥಾಪನೆಗೆ ಕಾರಣರಾದ ಜಗದ್ಗುರು ವಿದ್ಯಾರಣ್ಯರು ಕನ್ನಡ ನಾಡಿನ ಕೀರ್ತಿ ರತ್ನ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 9 — ಬಹುಮಾನ (6 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u9_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "‘ಪಿಕ್’ (ಪಿಕ) ಪದದ ಸರಿಯಾದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಗಿಳಿ", "ಕೋಗಿಲೆ", "ನವಿಲು", "ಹಕ್ಕಿ"),
            correctAnswer = "ಕೋಗಿಲೆ",
            explanation = "ಸಂಸ್ಕೃತದಲ್ಲಿ ಪಿಕ ಎಂದರೆ ಕೋಗಿಲೆ (ಕೋಕಿಲ)."
        ),
        QuestionModel(
            id = "s_8_kan_u9_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ತಂದೆಗೆ ಪತ್ರ ಬರೆಯುವಾಗ ಗೌರವ ಸೂಚಕ ಆರಂಭಿಕ ಸಂಬೋಧನೆ ಯಾವುದು?",
            options = listOf("ತೀರ್ಥರೂಪ", "ಪ್ರಿಯ ತಂದೆ", "ಶ್ರೀಮಾನ್", "ಪೂಜ್ಯರು"),
            correctAnswer = "ತೀರ್ಥರೂಪ",
            explanation = "ಸಂಪ್ರದಾಯದ ಪ್ರಕಾರ ತಂದೆಗೆ ಪತ್ರ ಬರೆಯುವಾಗ 'ತೀರ್ಥರೂಪ ಸಮಾನರಾದ ತಂದೆಯವರಿಗೆ' ಎಂದು ಬರೆಯುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u9_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ತಾಯಿಗೆ ಪತ್ರ ಬರೆಯುವಾಗ ಬಳಸುವ ಸಾಂಪ್ರದಾಯಿಕ ಸಂಬೋಧನೆ ಯಾವುದು?",
            options = listOf("ಮಾತೃಶ್ರೀ", "ಪಿತೃಶ್ರೀ", "ಮಾರ್ತಶ್ರೀ", "ಗುರುಶ್ರೀ"),
            correctAnswer = "ಮಾತೃಶ್ರೀ",
            explanation = "ತಾಯಿಯವರಿಗೆ ಪತ್ರ ಬರೆಯುವಾಗ 'ಮಾತೃಶ್ರೀ' ಎಂದು ಸಂಬೋಧಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u9_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ವಸಂತ ಋತುವಿನಲ್ಲಿ ಇಂಪಾಗಿ ಹಾಡುವ ಪಕ್ಷಿ ಯಾವುದು?",
            options = listOf("ಕೋಗಿಲೆ", "ನವಿಲು", "ಗಿಳಿ", "ಹಂಸ"),
            correctAnswer = "ಕೋಗಿಲೆ",
            explanation = "ವಸಂತ ಕಾಲದ ಮಾವಿನ ಚಿಗುರನ್ನು ತಿಂದು ಕೋಗಿಲೆಯು ಪಂಚಮ ಸ್ವರದಲ್ಲಿ ಇಂಪಾಗಿ ಹಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u9_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಅಧಿಕಾರಿಗಳಿಗೆ ಅಥವಾ ಸಂಸ್ಥೆಗಳಿಗೆ ಬರೆಯುವ ಪತ್ರದ ಪ್ರಕಾರ ಯಾವುದು?",
            options = listOf("ವೈಯಕ್ತಿಕ ಪತ್ರ", "ವ್ಯಾವಹಾರಿಕ ಪತ್ರ", "ಆಪ್ತ ಪತ್ರ", "ಆಹ್ವಾನ ಪತ್ರ"),
            correctAnswer = "ವ್ಯಾವಹಾರಿಕ ಪತ್ರ",
            explanation = "ಶಾಲಾ ಮುಖ್ಯೋಪಾಧ್ಯಾಯರಿಗೆ ಅಥವಾ ಕಚೇರಿಗಳಿಗೆ ಬರೆಯುವ ಪತ್ರಗಳು ವ್ಯವಹಾರಿಕ ಪತ್ರಗಳಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u9_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಜಗತ್ತನ್ನು ತನ್ಮಯಗೊಳಿಸಿ ಜುಮ್ಮನಿಸುವುದು ಯಾವುದರ ಇಂಚರ ಧ್ವನಿ?",
            options = listOf("ನವಿಲಿನ ಧ್ವನಿ", "ಕೋಗಿಲೆಯ ಧ್ವನಿ", "ಗಿಳಿಯ ಧ್ವನಿ", "ಹಕ್ಕಿಯ ಧ್ವನಿ"),
            correctAnswer = "ಕೋಗಿಲೆಯ ಧ್ವನಿ",
            explanation = "ಕೋಗಿಲೆಯ ಮಧುರ ಕಂಠದ ಇಂಚರವು ಇಡೀ ಪರಿಸರವನ್ನು ಪುಳಕಿತಗೊಳಿಸುತ್ತದೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 10 — ಗೆಳತನ (6 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u10_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ಇಹಲೋಕ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಭೂಲೋಕ", "ಪರಲೋಕ", "ಸ್ವರ್ಗ", "ನರಕ"),
            correctAnswer = "ಪರಲೋಕ",
            explanation = "ಇಹಲೋಕ (ಈ ಭೂಮಿ) ಕ್ಕೆ ವಿರುದ್ಧ ಪದ ಪರಲೋಕ."
        ),
        QuestionModel(
            id = "s_8_kan_u10_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಗೆಳತನದ ಮೂಲ ಅಡಿಪಾಯ ಯಾವುದು?",
            options = listOf("ಕೋಪ", "ದ್ವೇಷ", "ಪ್ರೀತಿ", "ಭಯ"),
            correctAnswer = "ಪ್ರೀತಿ",
            explanation = "ಪ್ರಾಮಾಣಿಕ ಸ್ನೇಹ ಮತ್ತು ಗೆಳತನವು ನಿಷ್ಕಲ್ಮಷ ಪ್ರೀತಿ-ವಿಶ್ವಾಸದ ಮೇಲೆ ನಿಂತಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u10_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕಾವ್ಯದಲ್ಲಿ ಮಾಧುರ್ಯಕ್ಕೆ ಯಾವುದನ್ನು ಹೋಲಿಸಲಾಗುತ್ತದೆ?",
            options = listOf("ಕಬ್ಬು", "ಅಕ್ಕಿ", "ರಾಗಿ", "ಜೋಳ"),
            correctAnswer = "ಕಬ್ಬು",
            explanation = "ಕಬ್ಬಿನ ರಸವು ಸವಿಯಾದ ಮಾಧುರ್ಯಕ್ಕೆ ಪ್ರತೀಕವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u10_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬೆಳಕು ಮತ್ತು ಚೈತನ್ಯದ ಸಾರ್ವತ್ರಿಕ ಮೂಲ ಯಾವುದು?",
            options = listOf("ಚಂದ್ರ", "ಸೂರ್ಯ", "ನಕ್ಷತ್ರ", "ಭೂಮಿ"),
            correctAnswer = "ಸೂರ್ಯ",
            explanation = "ಸೂರ್ಯನು ಜಗತ್ತಿಗೆ ಬೆಳಕು ಹಾಗೂ ಶಕ್ತಿಯನ್ನು ನೀಡುವ ದಿನಕರ."
        ),
        QuestionModel(
            id = "s_8_kan_u10_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕವಿ ಎಲ್ಲಲ್ಲಿ ತಂಗಿ ವಿಶ್ರಾಂತಿ ಪಡೆದಿದ್ದಾರೆ?",
            options = listOf("ಅರಮನೆಯ ನೆರಳಿನಲ್ಲಿ", "ಗೆಳತನದ ಸುವಿಶಾಲ ಆಲದಡಿ", "ಬೆಟ್ಟದ ಮೇಲೆ", "ನದಿಯ ದಡದಲ್ಲಿ"),
            correctAnswer = "ಗೆಳತನದ ಸುವಿಶಾಲ ಆಲದಡಿ",
            explanation = "ಗೆಳತನ ಎಂಬುದು ಬಿಸಿಲಿನಲ್ಲಿ ಆಶ್ರಯ ನೀಡುವ ಆಲದ ಮರದ ತಂಪಾದ ನೆರಳಿನಂತಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u10_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕವಿ ಯಾವುದರ ಕಾವನ್ನು ಮೌನದಲ್ಲಿ ನುಂಗಿದ್ದಾರೆ?",
            options = listOf("ಜೀವನದ ಮುಗಿಯದ ಕ್ಷಣಗಳ ಕಾವನ್ನು", "ಬೇಸಿಗೆಯ ಕಾವನ್ನು", "ಸೂರ್ಯನ ಕಾವನ್ನು", "ಬೆಂಕಿಯ ಕಾವನ್ನು"),
            correctAnswer = "ಜೀವನದ ಮುಗಿಯದ ಕ್ಷಣಗಳ ಕಾವನ್ನು",
            explanation = "ಜೀವನದ ಕಷ್ಟ-ನೋವುಗಳ ಕಾವನ್ನು ಸ್ನೇಹಿತನ ಪ್ರೀತಿಯಲ್ಲಿ ಕವಿ ಮರೆತಿದ್ದಾರೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 11 — ವಚನಾಮೃತ (15 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u11_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಕೋಗಿಲೆ’ ಪದದ ತತ್ಸಮ ರೂಪ ಯಾವುದು?",
            options = listOf("ಕೋಕಿಲ", "ಸಂಕಿಲಾ", "ಕೋಕಿಲೆ", "ಕೊಕಿಲಾ"),
            correctAnswer = "ಕೋಕಿಲ",
            explanation = "ಕೋಗಿಲೆ ತದ್ಭವದ ಸಂಸ್ಕೃತ ತತ್ಸಮ ರೂಪ 'ಕೋಕಿಲ'."
        ),
        QuestionModel(
            id = "s_8_kan_u11_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಜಂಗಮ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ವಿರಕ್ತಿ", "ವಿದ್ವಾಂಸ", "ಗುರು", "ಸ್ಥಾವರ"),
            correctAnswer = "ಸ್ಥಾವರ",
            explanation = "ಸ್ಥಾವರಕ್ಕಳಿವುಂಟು ಜಂಗಮಕ್ಕಳಿವಿಲ್ಲ — ಸ್ಥಾವರ (ಸ್ಥಿರವಾದದ್ದು) ಕ್ಕೆ ವಿರುದ್ಧ ಜಂಗಮ (ಚಲಿಸುವ ಚೈತನ್ಯ)."
        ),
        QuestionModel(
            id = "s_8_kan_u11_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಹೊಟ್ಟೆ ಕಿಚ್ಚು’ ನುಡಿಗಟ್ಟಿನ ಸರಿಯಾದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಹೊಟ್ಟೆ ನೋವು", "ಹೊಟ್ಟೆಯಲ್ಲಿ ಬೆಂಕಿ ಉರಿಯುವುದು", "ಅಸೂಯೆ ಪಡುವುದು", "ಹಸಿವಾಗುವುದು"),
            correctAnswer = "ಅಸೂಯೆ ಪಡುವುದು",
            explanation = "ಇನ್ನೊಬ್ಬರ ಏಳಿಗೆಯನ್ನು ನೋಡಿ ಅಸೂಯೆ ಅಥವಾ ಮತ್ಸರ ಪಡುವುದಕ್ಕೆ ಹೊಟ್ಟೆಕಿಚ್ಚು ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u11_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಕಿವಿಗೊಡು’ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥವೇನು?",
            options = listOf("ಹಾಡು ಹೇಳು", "ಗಮನದಿಂದ ಕೇಳು", "ಓಡು", "ನಗು"),
            correctAnswer = "ಗಮನದಿಂದ ಕೇಳು",
            explanation = "ಶ್ರದ್ಧೆಯಿಂದ ಅಥವಾ ಗಮನವಿಟ್ಟು ಕೇಳುವುದಕ್ಕೆ ಕಿವಿಗೊಡು ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u11_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಕೈಜೋಡಿಸು’ ಎಂದರೆ:",
            options = listOf("ಜಗಳ ಮಾಡು", "ಸಹಾಯ ಮಾಡು", "ಮಲಗು", "ಆಟ ಆಡು"),
            correctAnswer = "ಸಹಾಯ ಮಾಡು",
            explanation = "ಒಂದು ಕೆಲಸದಲ್ಲಿ ಒಟ್ಟಾಗಿ ಸಹಕರಿಸುವುದು ಅಥವಾ ಸಹಾಯ ಮಾಡುವುದು."
        ),
        QuestionModel(
            id = "s_8_kan_u11_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಕೈಕಟ್ಟಿ ಕುಳಿತುಕೊಳ್ಳು’ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥ:",
            options = listOf("ಕೆಲಸ ಮಾಡದೆ ಇರು", "ಓಡಿಹೋಗು", "ಓದು ಮಾಡು", "ನಿದ್ರೆ ಮಾಡು"),
            correctAnswer = "ಕೆಲಸ ಮಾಡದೆ ಇರು",
            explanation = "ಏನೂ ಪ್ರಯತ್ನ ಅಥವಾ ಪರಿಶ್ರಮ ಪಡದೆ ಸೋಮಾರಿಯಾಗಿರುವುದು."
        ),
        QuestionModel(
            id = "s_8_kan_u11_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಅರಿವು : ತಿಳಿವಳಿಕೆ :: ಹಂಗು : ______’",
            options = listOf("ಧನ", "ಋಣ (ದಾಕ್ಷಿಣ್ಯ)", "ಸ್ನೇಹ", "ಜ್ಞಾನ"),
            correctAnswer = "ಋಣ (ದಾಕ್ಷಿಣ್ಯ)",
            explanation = "ಹಂಗು ಎಂದರೆ ಇನ್ನೊಬ್ಬರ ಉಪಕಾರದ ಋಣ ಅಥವಾ ದಾಕ್ಷಿಣ್ಯ."
        ),
        QuestionModel(
            id = "s_8_kan_u11_8",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಕಾಯಕ : ಕೆಲಸ :: ಆಚಾರ : ______’",
            options = listOf("ನಡತೆ", "ಜ್ಞಾನ", "ಕಾಯಕ", "ಗುರು"),
            correctAnswer = "ನಡತೆ",
            explanation = "ಆಚಾರವೆಂದರೆ ಉತ್ತಮ ನಡವಳಿಕೆ ಅಥವಾ ಸತ್ಪ್ರವರ್ತನೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u11_9",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕಲಿಯುಗದಲ್ಲಿ ಗುರುವು ಶಿಷ್ಯನಿಗೆ ಹೇಗೆ ಬುದ್ಧಿ ಹೇಳಬೇಕೆಂದು ವಚನದಲ್ಲಿದೆ?",
            options = listOf("ಶಿಕ್ಷೆ ನೀಡಬೇಕು", "ವಂದಿಸಿ ಬುದ್ಧಿಯನ್ನು ಹೇಳಬೇಕು", "ದೂರ ಹೋಗಬೇಕು", "ಪರೀಕ್ಷೆ ಮಾಡಬೇಕು"),
            correctAnswer = "ವಂದಿಸಿ ಬುದ್ಧಿಯನ್ನು ಹೇಳಬೇಕು",
            explanation = "ಕಲಿಯುಗದಲ್ಲಿ ಗುರುವು ವಿನಯದಿಂದ ನಮಸ್ಕರಿಸಿ ತಿಳಿಹೇಳಬೇಕಾದ ಪರಿಸ್ಥಿತಿಯಿದೆ ಎಂದು ವಚನಕಾರರು ಹೇಳುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u11_10",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕಾಯಕದಲ್ಲಿ ನಿರತನಾದವನು ಯಾರ ಸಂದರ್ಶನವನ್ನಾದರೂ ಮರೆಯಬೇಕು?",
            options = listOf("ತಂದೆ-ತಾಯಿಯನ್ನು", "ಗುರು, ಲಿಂಗ, ಜಂಗಮರನ್ನು", "ಸ್ನೇಹಿತರನ್ನು", "ಸಮಾಜವನ್ನು"),
            correctAnswer = "ಗುರು, ಲಿಂಗ, ಜಂಗಮರನ್ನು",
            explanation = "ಆಯ್ದಕ್ಕಿ ಮಾರಯ್ಯನ ವಚನ: ಕಾಯಕದಲ್ಲಿ ನಿರತನಾದರೆ ಗುರುದರ್ಶನವಾದರೂ ಮರೆಯಬೇಕು, ಲಿಂಗಪೂಜೆಯಾದರೂ ಮರೆಯಬೇಕು."
        ),
        QuestionModel(
            id = "s_8_kan_u11_11",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಶರಣರ ತತ್ವದ ಪ್ರಕಾರ ಯಾವುದು ಕೈಲಾಸ?",
            options = listOf("ವಿದ್ಯೆಯೇ ಕೈಲಾಸ", "ಭಕ್ತಿಯೇ ಕೈಲಾಸ", "ಕಾಯಕವೇ ಕೈಲಾಸ", "ಜ್ಞಾನವೇ ಕೈಲಾಸ"),
            correctAnswer = "ಕಾಯಕವೇ ಕೈಲಾಸ",
            explanation = "ಪ್ರಾಮಾಣಿಕವಾಗಿ ಮಾಡುವ ಶ್ರಮ ಮತ್ತು ಕಾಯಕವೇ ಮುಕ್ತಿ ನೀಡುವ ಕೈಲಾಸ."
        ),
        QuestionModel(
            id = "s_8_kan_u11_12",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕಾಗೆಯು ಎಷ್ಟೇ ಕೂಗಿದರೂ ಯಾವುದಾಗಲು ಸಾಧ್ಯವಿಲ್ಲ?",
            options = listOf("ಹಂಸವಾಗಲು", "ಕೋಗಿಲೆಯಾಗಲು", "ಗಿಳಿಯಾಗಲು", "ನವಿಲಾಗಲು"),
            correctAnswer = "ಕೋಗಿಲೆಯಾಗಲು",
            explanation = "ಕಾಗೆಯ ಕರ್ಕಶ ಕೂಗು ಕೋಗಿಲೆಯ ಮಧುರ ಸ್ವರವಾಗಲು ಸಾಧ್ಯವಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_8_kan_u11_13",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಅಮ್ಮುಗೆ ರಾಯಮ್ಮ ಅವರು ಯಾರ ಮುಖವನ್ನು ನೋಡಲಾಗದು ಎಂದು ಹೇಳಿದ್ದಾರೆ?",
            options = listOf("ವಿದ್ಯಾವಂತರ ಮುಖ", "ಅರಿವು-ಆಚಾರ-ಸಮಯ-ಜ್ಞಾನ ಅರಿಯದ ಗಾವಿಲರ ಮುಖ", "ಗುರುಗಳ ಮುಖ", "ಶರಣರ ಮುಖ"),
            correctAnswer = "ಅರಿವು-ಆಚಾರ-ಸಮಯ-ಜ್ಞಾನ ಅರಿಯದ ಗಾವಿಲರ ಮುಖ",
            explanation = "ಅರಿವು, ನಡತೆ ಮತ್ತು ಸಮಯದ ಜ್ಞಾನವಿಲ್ಲದ ಮೂಢರ ಮುಖ ನೋಡಬಾರದು ಎಂದಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u11_14",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಶರಣರು ಯಾವುದನ್ನು ಯೋಗಸಮಾಧಿ ಮಾಡಿ ಗೆದ್ದಿದ್ದಾರೆ?",
            options = listOf("ಕೋಪವನ್ನು", "ನಿದ್ರೆಯನ್ನು", "ಹಸಿವನ್ನು", "ಭಯವನ್ನು"),
            correctAnswer = "ನಿದ್ರೆಯನ್ನು",
            explanation = "ಅಜ್ಞಾನದ ನಿದ್ರೆಯನ್ನು ಗೆದ್ದು ಆತ್ಮಜ್ಞಾನದ ಎಚ್ಚರದಲ್ಲಿ ಶರಣರು ಬಾಳಿದರು."
        ),
        QuestionModel(
            id = "s_8_kan_u11_15",
            stdId = 8,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕೃತಯುಗದಲ್ಲಿ ಗುರುವು ಶಿಷ್ಯನಿಗೆ ಹೇಗೆ ಬುದ್ಧಿ ಕಲಿಸಿದನು?",
            options = listOf("ಹಾಡಿ", "ಬಡಿದು", "ನಗಿಸಿ", "ಕಥೆ ಹೇಳಿ"),
            correctAnswer = "ಬಡಿದು",
            explanation = "ಕೃತಯುಗದಲ್ಲಿ ಕಠಿಣ ಶಿಸ್ತು ಮತ್ತು ಬಡಿದು ಬುದ್ಧಿ ಕಲಿಸುವ ಸಂಪ್ರದಾಯವಿತ್ತು ಎಂಬುದು ವಚನದ ಉಲ್ಲೇಖ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 12 — ರಮಧಾನ್ ಚರಿತೆ (11 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u12_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಒಂದು ಮಾತ್ರಾಕಾಲದಲ್ಲಿ ಉಚ್ಚರಿಸಬಹುದಾದ ಅಕ್ಷರ ಯಾವುದು?",
            options = listOf("ಗುರು", "ದೀರ್ಘ", "ಪ್ಲುತ", "ಲಘು"),
            correctAnswer = "ಲಘು",
            explanation = "ಒಂದು ಮಾತ್ರಾಕಾಲದಲ್ಲಿ ಉಚ್ಚರಿಸುವ ಹ್ರಸ್ವಾಕ್ಷರವನ್ನು ಛಂದಸ್ಸಿನಲ್ಲಿ 'ಲಘು' (U) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u12_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಅನುಸ್ವಾರ, ವಿಸರ್ಗಗಳಿಂದ ಕೂಡಿರುವ ಅಕ್ಷರ ಛಂದಸ್ಸಿನಲ್ಲಿ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಗುರು", "ಲಘು", "ಹ್ರಸ್ವ", "ದೀರ್ಘ"),
            correctAnswer = "ಗುರು",
            explanation = "ಅನುಸ್ವಾರ ಅಥವಾ ವಿಸರ್ಗದಿಂದ ಕೂಡಿದ ಅಕ್ಷರ ಎರಡು ಮಾತ್ರೆಗಳ 'ಗುರು' (-) ಆಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u12_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಆರು ಪಾದಗಳಿಂದ ಕೂಡಿರುವ ಕನ್ನಡದ ಪ್ರಸಿದ್ಧ ಪದ್ಯ ಪ್ರಕಾರ:",
            options = listOf("ತ್ರಿಪದಿ", "ಕಂದಪದ್ಯ", "ಷಟ್ಪದಿ", "ದ್ವಿಪದಿ"),
            correctAnswer = "ಷಟ್ಪದಿ",
            explanation = "ಆರು ಸಾಲುಗಳ (ಪಾದಗಳ) ಪದ್ಯಕ್ಕೆ ಷಟ್ಪದಿ ಎನ್ನುತ್ತಾರೆ (ಉದಾ: ಭಾಮಿನಿ, ವಾರ್ಧಕ)."
        ),
        QuestionModel(
            id = "s_8_kan_u12_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಭಾಮಿನಿ ಷಟ್ಪದಿಯಲ್ಲಿರುವ ಒಟ್ಟು ಮಾತ್ರೆಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("102", "104", "100", "96"),
            correctAnswer = "102",
            explanation = "ಭಾಮಿನಿ ಷಟ್ಪದಿಯ ಒಂದು ಪದ್ಯದಲ್ಲಿ ಒಟ್ಟು 102 ಮಾತ್ರೆಗಳಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u12_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿಯಲ್ಲಿ ಮೊದಲ ಮೂರು ಪಾದಗಳು ಒಂದು ಅರ್ಧವಾದರೆ, ಒಟ್ಟು ಪಾದಗಳು ಎಷ್ಟು?",
            options = listOf("ಮೂರು", "ಐದು", "ನಾಲ್ಕು", "ಆರು"),
            correctAnswer = "ಆರು",
            explanation = "ಷಟ್ಪದಿ ಎಂದರೆ 6 ಪಾದಗಳಿರುವ ಪದ್ಯ."
        ),
        QuestionModel(
            id = "s_8_kan_u12_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಭಾಮಿನಿ ಷಟ್ಪದಿಯ ಮೂರನೆಯ ಮತ್ತು ಆರನೆಯ ಪಾದಗಳಲ್ಲಿ ಎಷ್ಟು ಮಾತ್ರೆಗಳಿರುತ್ತವೆ?",
            options = listOf("7 ಮಾತ್ರೆಗಳು", "14 ಮಾತ್ರೆಗಳು", "21 ಮಾತ್ರೆಗಳು", "28 ಮಾತ್ರೆಗಳು"),
            correctAnswer = "21 ಮಾತ್ರೆಗಳು",
            explanation = "ಭಾಮಿನಿ ಷಟ್ಪದಿಯ 3 ಮತ್ತು 6ನೇ ಪಾದಗಳಲ್ಲಿ 3+4+3+4+3+4+1 = 21 ಮಾತ್ರೆಗಳಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u12_7",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಮಾತೊಂದು’ ಪದವು ಯಾವ ಸಂಧಿಗೆ ಉದಾಹರಣೆ?",
            options = listOf("ಲೋಪಸಂಧಿ", "ಆಗಮಸಂಧಿ", "ಆದೇಶಸಂಧಿ", "ಗುಣಸಂಧಿ"),
            correctAnswer = "ಲೋಪಸಂಧಿ",
            explanation = "ಮಾತು + ಒಂದು = ಮಾತೊಂದು (ಉ ಕಾರ ಲೋಪವಾಗಿದೆ)."
        ),
        QuestionModel(
            id = "s_8_kan_u12_8",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಜೋಳ : ಧಾನ್ಯ :: ರಾಗಿ : ______’",
            options = listOf("ಧಾನ್ಯ", "ಹಣ್ಣು", "ತರಕಾರಿ", "ಎಣ್ಣೆಕಾಳು"),
            correctAnswer = "ಧಾನ್ಯ",
            explanation = "ರಾಗಿಯು ಪೌಷ್ಟಿಕಾಂಶಗಳುಳ್ಳ ಶ್ರೇಷ್ಠ ಸಿರಿಧಾನ್ಯವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u12_9",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ರಾಗಿಯು ಕರ್ನಾಟಕದ ಗ್ರಾಮೀಣ ಜನಜೀವನಕ್ಕೆ ಅತಿಶಯವಾದ ______ ಆಗಿದೆ.",
            options = listOf("ಹಣ್ಣು", "ಧಾನ್ಯ", "ತರಕಾರಿ", "ಪಾನೀಯ"),
            correctAnswer = "ಧಾನ್ಯ",
            explanation = "ರಾಗಿಯು ಕರ್ನಾಟಕದ ಪ್ರಮುಖ ಆಹಾರ ಧಾನ್ಯವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u12_10",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿರಹಿಯ ಒಣಗಿದ ಬಾಯಿಗೆ ಸಾಂತ್ವನ ನೀಡುವ ಆಹಾರ:",
            options = listOf("ನೀರು", "ತುತ್ತು", "ಹಣ್ಣು", "ಆಹಾರ"),
            correctAnswer = "ತುತ್ತು",
            explanation = "ಹಸಿದವನಿಗೆ ಅನ್ನದ ತುತ್ತು ಅಮೃತಕ್ಕೆ ಸಮಾನ."
        ),
        QuestionModel(
            id = "s_8_kan_u12_11",
            stdId = 8,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ದಶರಥ ಮಹಾರಾಜನ ಮಗನಾದ ಶ್ರೀರಾಮನನ್ನು ಹೀಗೆಂದು ಕರೆಯುತ್ತಾರೆ:",
            options = listOf("ರಾಘವ", "ದಾಶರಥಿ", "ಕೌಸಲ್ಯಾನಂದನ", "ರಘುವೀರ"),
            correctAnswer = "ದಾಶರಥಿ",
            explanation = "ದಶರಥನ ಮಗನಾದುದರಿಂದ ಶ್ರೀರಾಮನಿಗೆ 'ದಾಶರಥಿ' ಎನ್ನುತ್ತಾರೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 14 — ಆಟೋರಿಕ್ಷಾದ ರಸಪ್ರಸಂಗಗಳು (6 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u14_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಪ್ರಾರ್ಥನೆಯಿಂದ ಮಳೆ ಬರಿಸುವುದಾಗಿ ಹೇಳಿದವರು ಯಾರು?",
            options = listOf("ಸಾಯಿಬಾಬಾ", "ಸ್ವಾಮೀಜಿ", "ಪುರೋಹಿತರು", "ರೈತರು"),
            correctAnswer = "ಸಾಯಿಬಾಬಾ",
            explanation = "ಪಾಠದ ಪ್ರಸಂಗದಲ್ಲಿ ಸಾಯಿಬಾಬಾರ ಪ್ರಾರ್ಥನೆಯ ಉಲ್ಲೇಖ ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_kan_u14_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಜಯನಗರದ ನ್ಯಾಷನಲ್ ಕಾಲೇಜಿನಲ್ಲಿ ಕಾರ್ಯಕ್ರಮ ಮುಗಿದಾಗ ಎಷ್ಟು ಗಂಟೆಯಾಗಿತ್ತು?",
            options = listOf("ರಾತ್ರಿ 8 ಗಂಟೆ", "ರಾತ್ರಿ 9 ಗಂಟೆ", "ರಾತ್ರಿ 10 ಗಂಟೆ", "ರಾತ್ರಿ 11 ಗಂಟೆ"),
            correctAnswer = "ರಾತ್ರಿ 10 ಗಂಟೆ",
            explanation = "ಕಾರ್ಯಕ್ರಮ ಮುಗಿದು ಹೊರಬಂದಾಗ ರಾತ್ರಿ 10 ಗಂಟೆಯಾಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_8_kan_u14_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಬೆಂಗಳೂರಿನಲ್ಲಿ ಒಂದು ಕಡೆಯಿಂದ ಇನ್ನೊಂದು ಕಡೆ ಸಂಚರಿಸುವುದು ಲೇಖಕರಿಗೆ ಹೇಗಿತ್ತು?",
            options = listOf("ಸುಲಭದ ಕೆಲಸ", "ಪ್ರಯಾಸದ ಕೆಲಸ", "ಸಂತೋಷದ ಕೆಲಸ", "ಸಾಮಾನ್ಯ ಕೆಲಸ"),
            correctAnswer = "ಪ್ರಯಾಸದ ಕೆಲಸ",
            explanation = "ದಟ್ಟ ವಾಹನ ಸಂಚಾರ ಮತ್ತು ಆಟೋ ಹುಡುಕುವುದು ಪ್ರಯಾಸಕರವಾಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_8_kan_u14_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಲೇಖಕರು ಸಮೀಪದ ಸ್ಥಳಗಳಿಗೆ ಸಾಮಾನ್ಯವಾಗಿ ಹೇಗೆ ಹೋಗುತ್ತಿದ್ದರು?",
            options = listOf("ಕಾರಿನಲ್ಲಿ", "ಆಟೋರಿಕ್ಷಾದಲ್ಲಿ", "ನಡೆದುಕೊಂಡು", "ಬಸ್ಸಿನಲ್ಲಿ"),
            correctAnswer = "ನಡೆದುಕೊಂಡು",
            explanation = "ಸಮೀಪದ ಸ್ಥಳಗಳಿಗೆ ಲೇಖಕರು ನಡೆದುಕೊಂಡೇ ಹೋಗಲು ಇಷ್ಟಪಡುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_8_kan_u14_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಆಟೋರಿಕ್ಷಾಗಳು ಅತಿಯಾದ ವೇಗದಲ್ಲಿ ತಿರುವುಗಳಲ್ಲಿ ಚಲಿಸುವುದರಿಂದ ಲೇಖಕರಿಗೆ ಏನಾಗುತ್ತಿತ್ತು?",
            options = listOf("ಸಂತೋಷವಾಗುತ್ತಿತ್ತು", "ಭಯವಾಗುತ್ತಿತ್ತು", "ನಗುವು ಬರುತ್ತಿತ್ತು", "ನಿದ್ರೆ ಬರುತ್ತಿತ್ತು"),
            correctAnswer = "ಭಯವಾಗುತ್ತಿತ್ತು",
            explanation = "ಆಟೋಗಳ ಅತಿವೇಗದ ಓಟ ಮತ್ತು ಕಿರಿದಾದ ತಿರುವುಗಳಿಂದ ಲೇಖಕರಿಗೆ ಆತಂಕ ಮತ್ತು ಭಯವಾಗುತ್ತಿತ್ತು."
        ),
        QuestionModel(
            id = "s_8_kan_u14_6",
            stdId = 8,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ವಯಸ್ಸಾದ ಆಟೋ ಚಾಲಕನು ಲೇಖಕರಿಗೆ ಹೇಗೆ ಸ್ಪಂದಿಸಿದನು?",
            options = listOf("ಹಣ ಕೇಳಿದನು", "ಆತ್ಮೀಯವಾಗಿ ಸಹಾಯ ಮಾಡಲು ಮುಂದಾದನು", "ಅವರನ್ನು ಇಳಿಸಿದನು", "ಅವರನ್ನು ಬಿಟ್ಟುಹೋದನು"),
            correctAnswer = "ಆತ್ಮೀಯವಾಗಿ ಸಹಾಯ ಮಾಡಲು ಮುಂದಾದನು",
            explanation = "ವಯಸ್ಸಾದ ಚಾಲಕನು ಮಾನವೀಯತೆಯಿಂದ ಆತ್ಮೀಯವಾಗಿ ಸಹಾಯ ಮಾಡಲು ಮುಂದಾದನು."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 15 — ಸೀಮ (5 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_8_kan_u15_1",
            stdId = 8,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಹಳ್ಳಿಯಲ್ಲಿ ಮಳೆ ಇಲ್ಲದೆ ಭೀಕರ ಬರಗಾಲ ಉಂಟಾದಾಗ ತಿಮ್ಮರಾಯನು ಏನು ನಿರ್ಧರಿಸಿದನು?",
            options = listOf("ಊರಿನಲ್ಲೇ ಉಳಿಯಲು", "ದುಡಿಯಲು ಪಟ್ಟಣಕ್ಕೆ ಹೋಗಲು", "ಬೇರೆ ಊರಿಗೆ ಮದುವೆಯಾಗಲು", "ಕೃಷಿ ಮಾಡಲು"),
            correctAnswer = "ದುಡಿಯಲು ಪಟ್ಟಣಕ್ಕೆ ಹೋಗಲು",
            explanation = "ಬರಗಾಲದ ಸಂಕಷ್ಟದಿಂದ ಪಾರಾಗಲು ತಿಮ್ಮರಾಯನು ಪಟ್ಟಣಕ್ಕೆ ಹೋಗಿ ದುಡಿಯಲು ತೀರ್ಮಾನಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_8_kan_u15_2",
            stdId = 8,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ತಿಮ್ಮರಾಯನಿಗೆ ಹಸಿವನ್ನು ನೀಗಿಸಿಕೊಳ್ಳಲು ಮುದುಕಿಯು ಏನನ್ನು ತೋರಿಸಿದಳು?",
            options = listOf("ಹಣ್ಣಿನ ಮರ", "ಮನೆಯೊಂದನ್ನು", "ಹೊಲವನ್ನು", "ಅಂಗಡಿಯನ್ನು"),
            correctAnswer = "ಹಣ್ಣಿನ ಮರ",
            explanation = "ಮುದುಕಿಯು ಹಸಿದ ತಿಮ್ಮರಾಯನಿಗೆ ಹಣ್ಣುಗಳಿಂದ ಕೂಡಿದ ಮರವನ್ನು ತೋರಿಸಿದಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u15_3",
            stdId = 8,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಬಾಯಾರಿಕೆ ತಣಿಸಿಕೊಳ್ಳಲು ಮುದುಕಿಯು ಏನನ್ನು ತೋರಿಸಿದಳು?",
            options = listOf("ನದಿಯನ್ನು", "ಬಾವಿಯನ್ನು", "ನೀರಿನ ಮರವನ್ನು", "ಕೆರೆಯನ್ನು"),
            correctAnswer = "ನೀರಿನ ಮರವನ್ನು",
            explanation = "ಬಾಯಾರಿಕೆಯಾದಾಗ ನೀರು ಒಸರುವ ನೀರಿನ ಮರವನ್ನು ತೋರಿಸಿದಳು."
        ),
        QuestionModel(
            id = "s_8_kan_u15_4",
            stdId = 8,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ನೀರಿನ ಮರಕ್ಕೆ ಎಷ್ಟು ಬಾರಿಗಿಂತ ಹೆಚ್ಚು ಏಟು ಹಾಕಬಾರದು ಎಂದು ಮುದುಕಿ ಎಚ್ಚರಿಸಿದಳು?",
            options = listOf("ಒಂದಕ್ಕಿಂತ ಹೆಚ್ಚು ಬಾರಿ", "ಎರಡು ಬಾರಿ", "ಮೂರು ಬಾರಿ", "ನಾಲ್ಕು ಬಾರಿ"),
            correctAnswer = "ಒಂದಕ್ಕಿಂತ ಹೆಚ್ಚು ಬಾರಿ",
            explanation = "ಅತಿಯಾಸೆ ಪಡದೆ ಒಂದು ಬಾರಿಗಿಂತ ಹೆಚ್ಚು ಏಟು ಹಾಕಬಾರದು ಎಂಬ ನಿಯಮವಿತ್ತು."
        ),
        QuestionModel(
            id = "s_8_kan_u15_5",
            stdId = 8,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಹಣ್ಣಿನ ಮರದ ಬಗ್ಗೆ ಮುದುಕಿಯು ನೀಡಿದ ಕಟ್ಟುನಿಟ್ಟಿನ ಎಚ್ಚರಿಕೆ ಏನು?",
            options = listOf("ಅದನ್ನು ಸುಡಬೇಕು", "ಅದನ್ನು ಕಡಿಯಬಾರದು", "ಅದನ್ನು ಮಾರಬೇಕು", "ಅದನ್ನು ಬೇರುಸಹಿತ ತೆಗೆಯಬೇಕು"),
            correctAnswer = "ಅದನ್ನು ಕಡಿಯಬಾರದು",
            explanation = "ಜೀವ ನೀಡುವ ಹಣ್ಣಿನ ಮರವನ್ನು ಎಂದಿಗೂ ಕಡಿಯಬಾರದು ಎಂದು ಎಚ್ಚರಿಸಿದಳು."
        )
    )
}
