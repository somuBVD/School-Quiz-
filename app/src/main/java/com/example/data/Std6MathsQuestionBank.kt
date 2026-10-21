package com.example.data

/**
 * Standard 6 Mathematics (Kannada Medium - LBA Revised 2026-27)
 * Question bank containing text-verified MCQs across all 10 Units.
 */
object Std6MathsQuestionBank {

    val units = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಗಣಿತದಲ್ಲಿ ವಿನ್ಯಾಸಗಳು", 16, "Easy"),
        UnitTemplate(2, "ಘಟಕ 2: ರೇಖೆಗಳು ಮತ್ತು ಕೋನಗಳು", 6, "Medium"),
        UnitTemplate(3, "ಘಟಕ 3: ಸಂಖ್ಯಾ ಆಟ", 9, "Medium"),
        UnitTemplate(4, "ಘಟಕ 4: ದತ್ತಾಂಶಗಳ ನಿರ್ವಹಣೆ ಮತ್ತು ಪ್ರಸ್ತುತಿ", 5, "Easy"),
        UnitTemplate(5, "ಘಟಕ 5: ಅವಿಭಾಜ್ಯ ಸಮಯ", 7, "Medium"),
        UnitTemplate(6, "ಘಟಕ 6: ಸುತ್ತಳತೆ ಮತ್ತು ವಿಸ್ತೀರ್ಣ", 2, "Easy"),
        UnitTemplate(7, "ಘಟಕ 7: ಭಿನ್ನರಾಶಿಗಳು", 4, "Medium"),
        UnitTemplate(8, "ಘಟಕ 8: ರಚನೆಗಳೊಂದಿಗೆ ಆಟ", 8, "Medium"),
        UnitTemplate(9, "ಘಟಕ 9: ಸಮಮಿತಿ", 5, "Medium"),
        UnitTemplate(10, "ಘಟಕ 10: ಸೊನ್ನೆಯ ಮತ್ತೊಂದು ಬದಿ", 10, "Easy")
    )

    val questions: List<QuestionModel> = listOf(
        // ==================== ಘಟಕ 1: ಗಣಿತದಲ್ಲಿ ವಿನ್ಯಾಸಗಳು ====================
        QuestionModel(
            id = "s_6_mat_u1_1",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "9, 18, 27, 36, ಈ ಸಂಖ್ಯಾ ಶ್ರೇಣಿಯ ಮುಂದಿನ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("100", "81", "45", "65"),
            correctAnswer = "45",
            explanation = "ಇದು 9ರ ಅಪವರ್ತ್ಯಗಳ ಶ್ರೇಣಿ (9 × 1, 9 × 2, 9 × 3, 9 × 4, 9 × 5 = 45)."
        ),
        QuestionModel(
            id = "s_6_mat_u1_2",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "5, 10, 20, 40 ಈ ಶ್ರೇಣಿಯ ಮುಂದಿನ ಎರಡು ಸಂಖ್ಯೆಗಳು ಯಾವುವು?",
            options = listOf("80, 160", "60, 80", "40, 50", "50, 100"),
            correctAnswer = "80, 160",
            explanation = "ಪ್ರತಿ ಸಂಖ್ಯೆಯು ಹಿಂದಿನ ಸಂಖ್ಯೆಯ ಎರಡರಷ್ಟಾಗಿದೆ (40 × 2 = 80, 80 × 2 = 160)."
        ),
        QuestionModel(
            id = "s_6_mat_u1_3",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "1, 4, 9, 16 ಈ ಸರಣಿಯ ಐದನೇ ಪದ ಯಾವುದು?",
            options = listOf("15", "25", "49", "20"),
            correctAnswer = "25",
            explanation = "ಇದು ವರ್ಗ ಸಂಖ್ಯೆಗಳ ಸರಣಿ: 1², 2², 3², 4², 5² = 25."
        ),
        QuestionModel(
            id = "s_6_mat_u1_4",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "1, 11, 111, 1111 ಈ ಸರಣಿಯ ಮುಂದಿನ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("111111", "111", "11111", "1111111"),
            correctAnswer = "11111",
            explanation = "ಪ್ರತಿ ಹಂತದಲ್ಲೂ '1' ಅಂಕಿ ಒಂದು ಬಾರಿ ಹೆಚ್ಚಾಗುತ್ತದೆ. 4 ಅಂಕಿಗಳ ನಂತರ 5 ಅಂಕಿಗಳ 11111 ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u1_5",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "A1, B2, C3, D4, ___, F6 ಈ ಸರಣಿಯಲ್ಲಿ ಬಿಟ್ಟುಹೋದ ಪದ ಯಾವುದು?",
            options = listOf("E5", "D5", "E8", "F5"),
            correctAnswer = "E5",
            explanation = "ವರ್ಣಮಾಲೆಯ ಅಕ್ಷರ ಮತ್ತು ಅನುಗುಣವಾದ ಕ್ರಮಸಂಖ್ಯೆ: D4 ನಂತರ E5 ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u1_6",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "2, 4, 8, 16, 34, 64 ಈ ವಿನ್ಯಾಸಕ್ಕೆ ಸೇರದ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("2", "8", "64", "34"),
            correctAnswer = "34",
            explanation = "ಪ್ರತಿ ಪದವು 2ರ ಗುಣಕವಾಗಿದ್ದು ದುಪ್ಪಟ್ಟಾಗುತ್ತಿದೆ. 16ರ ನಂತರ 32 ಬರಬೇಕಿತ್ತು, ಆದರೆ 34 ನೀಡಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u1_7",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "AB, BC, CD, DE ಈ ವಿನ್ಯಾಸದ 5ನೇ ಪದ ಯಾವುದು?",
            options = listOf("FG", "DF", "EF", "EE"),
            correctAnswer = "EF",
            explanation = "ಅಕ್ಷರಗಳ ಜೋಡಿಯ ಶ್ರೇಣಿಯಲ್ಲಿ DE ನಂತರ EF ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u1_8",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "2, 6, 12, 20, 30 ಈ ವಿನ್ಯಾಸದ ಮುಂದಿನ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("36", "40", "42", "48"),
            correctAnswer = "42",
            explanation = "ವ್ಯತ್ಯಾಸಗಳು ಅನುಕ್ರಮವಾಗಿ +4, +6, +8, +10, +12 ಹೆಚ್ಚಾಗುತ್ತವೆ. ಆದ್ದರಿಂದ 30 + 12 = 42."
        ),
        QuestionModel(
            id = "s_6_mat_u1_9",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "8, 16, _____, 64, 128 ಈ ಸರಣಿಯಲ್ಲಿ ಬಿಟ್ಟುಹೋದ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("24", "32", "36", "49"),
            correctAnswer = "32",
            explanation = "ಸಂಖ್ಯೆಗಳು ದುಪ್ಪಟ್ಟಾಗುತ್ತಿವೆ: 8 × 2 = 16, 16 × 2 = 32, 32 × 2 = 64."
        ),
        QuestionModel(
            id = "s_6_mat_u1_10",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಂದು ವಿನ್ಯಾಸದಲ್ಲಿ ಪ್ರತಿ ಪದವನ್ನು ಅದರ ಹಿಂದಿನ ಸಂಖ್ಯೆಯನ್ನು 5ರಿಂದ ಗುಣಿಸುವುದರಿಂದ ಪಡೆಯಲಾಗುತ್ತದೆ. ಮೊದಲ ಸಂಖ್ಯೆ 2 ಆಗಿದ್ದರೆ, ನಾಲ್ಕನೇ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("50", "100", "125", "250"),
            correctAnswer = "250",
            explanation = "1ನೇ ಪದ = 2; 2ನೇ ಪದ = 2 × 5 = 10; 3ನೇ ಪದ = 10 × 5 = 50; 4ನೇ ಪದ = 50 × 5 = 250."
        ),
        QuestionModel(
            id = "s_6_mat_u1_11",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "1, 3, 6, 10, 15, … ಈ ಸಂಖ್ಯೆಗಳನ್ನು ______ ಸಂಖ್ಯೆಗಳು ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ವರ್ಗ ಸಂಖ್ಯೆಗಳು", "ತ್ರಿಕೋನೀಯ ಸಂಖ್ಯೆಗಳು", "ಘನ ಸಂಖ್ಯೆಗಳು", "ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆಗಳು"),
            correctAnswer = "ತ್ರಿಕೋನೀಯ ಸಂಖ್ಯೆಗಳು",
            explanation = "ಬಿಂದುಗಳನ್ನು ತ್ರಿಕೋನಾಕಾರದಲ್ಲಿ ಜೋಡಿಸಿದಾಗ ಸಿಗುವ ಸಂಖ್ಯೆಗಳಿವು (Triangular numbers): 1, 1+2=3, 1+2+3=6, 1+2+3+4=10, ಇತ್ಯಾದಿ."
        ),
        QuestionModel(
            id = "s_6_mat_u1_12",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "1, 4, 9, 16, 25, … ಇವುಗಳನ್ನು ______ ಸಂಖ್ಯೆಗಳು ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ತ್ರಿಕೋನೀಯ ಸಂಖ್ಯೆಗಳು", "ವರ್ಗ ಸಂಖ್ಯೆಗಳು", "ಬೆಸ ಸಂಖ್ಯೆಗಳು", "ಸಮ ಸಂಖ್ಯೆಗಳು"),
            correctAnswer = "ವರ್ಗ ಸಂಖ್ಯೆಗಳು",
            explanation = "ಒಂದು ಸಂಖ್ಯೆಯನ್ನು ಅದೇ ಸಂಖ್ಯೆಯಿಂದ ಗುಣಿಸಿದಾಗ ಬರುವ ಗುಣಲಬ್ಧಗಳು (Square numbers): 1×1=1, 2×2=4, 3×3=9, 4×4=16, 5×5=25."
        ),
        QuestionModel(
            id = "s_6_mat_u1_13",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "1 + 3 + 5 + 7 + 9 = ______ = 25.",
            options = listOf("3²", "4²", "5²", "6²"),
            correctAnswer = "5²",
            explanation = "ಮೊದಲ 'n' ಅನುಕ್ರಮ ಬೆಸ ಸಂಖ್ಯೆಗಳ ಮೊತ್ತವು n² ಆಗಿರುತ್ತದೆ. ಇಲ್ಲಿ 5 ಬೆಸ ಸಂಖ್ಯೆಗಳ ಮೊತ್ತ 5² = 25."
        ),
        QuestionModel(
            id = "s_6_mat_u1_14",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "1, 8, 27, 64, 125, … ಈ ಸಂಖ್ಯೆಗಳನ್ನು ______ ಸಂಖ್ಯೆಗಳು ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ವರ್ಗ ಸಂಖ್ಯೆಗಳು", "ಘನ ಸಂಖ್ಯೆಗಳು", "ತ್ರಿಕೋನೀಯ ಸಂಖ್ಯೆಗಳು", "ಸಹ-ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆಗಳು"),
            correctAnswer = "ಘನ ಸಂಖ್ಯೆಗಳು",
            explanation = "ಒಂದು ಸಂಖ್ಯೆಯನ್ನು ಮೂರು ಬಾರಿ ಗುಣಿಸಿದಾಗ ಬರುವ ಸಂಖ್ಯೆಗಳು ಘನ ಸಂಖ್ಯೆಗಳು (Cube numbers): 1³=1, 2³=8, 3³=27, 4³=64, 5³=125."
        ),
        QuestionModel(
            id = "s_6_mat_u1_15",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "2, 4, 8, 16, 32, … ಈ ಸರಣಿಯಲ್ಲಿ ಪ್ರತಿ ಪದವು ಹಿಂದಿನ ಪದದ ______ ರಷ್ಟಾಗಿದೆ.",
            options = listOf("ಮೂರರಷ್ಟು", "ಎರಡರಷ್ಟು (ದುಪ್ಪಟ್ಟು)", "ನಾಲ್ಕರಷ್ಟು", "ಅರ್ಧದಷ್ಟು"),
            correctAnswer = "ಎರಡರಷ್ಟು (ದುಪ್ಪಟ್ಟು)",
            explanation = "ಪ್ರತಿ ಪದವನ್ನು 2 ರಿಂದ ಗುಣಿಸಿ ಮುಂದಿನ ಪದ ಪಡೆಯಲಾಗುತ್ತದೆ (2 × 2 = 4, 4 × 2 = 8, 8 × 2 = 16...)."
        ),
        QuestionModel(
            id = "s_6_mat_u1_16",
            stdId = 6,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "111 × 111 = 12321 ಆದರೆ, 1111 × 1111 = ______.",
            options = listOf("123454321", "1234321", "12345654321", "11111111"),
            correctAnswer = "1234321",
            explanation = "1 ರಿಂದ ಪ್ರಾರಂಭಿಸಿ 1 ರ ಸಂಖ್ಯೆಯಷ್ಟಕ್ಕೆ ಏರಿ, ನಂತರ ಇಳಿಯುವ ಪಾಲಿಂಡ್ರೋಮ್ ವಿನ್ಯಾಸ: 4 ಒಂದಂಕಿಗಳ ಗುಣಲಬ್ಧ 1234321."
        ),

        // ==================== ಘಟಕ 2: ರೇಖೆಗಳು ಮತ್ತು ಕೋನಗಳು ====================
        QuestionModel(
            id = "s_6_mat_u2_1",
            stdId = 6,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "ಡಿಗ್ರಿಗಳಲ್ಲಿ ಒಂದು ಪೂರ್ಣ ತಿರುಗುವಿಕೆಯ (ಪೂರ್ಣಕೋನದ) ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("90°", "360°", "180°", "270°"),
            correctAnswer = "360°",
            explanation = "ಒಂದು ಬಿಂದುವಿನ ಸುತ್ತಲಿನ ಪೂರ್ಣ ಕೋನದ ಅಳತೆ 360° ಆಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u2_2",
            stdId = 6,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "ಸಾಮಾನ್ಯ ಆರಂಭಿಕ ಬಿಂದುವನ್ನು ಹೊಂದಿರುವ ಎರಡು ಕಿರಣಗಳಿಂದ ಉಂಟಾಗುವ ಆಕೃತಿ ಯಾವುದು?",
            options = listOf("ಬಿಂದು", "ರೇಖೆ", "ಸಮತಲ", "ಕೋನ"),
            correctAnswer = "ಕೋನ",
            explanation = "ಒಂದೇ ಆರಂಭಿಕ ಬಿಂದುವಿನಿಂದ ಹೊರಡುವ ಎರಡು ಕಿರಣಗಳು ಕೋನವನ್ನು (Angle) ಉಂಟುಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u2_3",
            stdId = 6,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "ನಿರ್ದಿಷ್ಟ ಉದ್ದ ಮತ್ತು ಎರಡು ಅಂತ್ಯಬಿಂದುಗಳನ್ನು ಹೊಂದಿರುವ ಜ್ಯಾಮಿತೀಯ ಚಿತ್ರ ಯಾವುದು?",
            options = listOf("ಬಿಂದು", "ರೇಖಾಖಂಡ", "ರೇಖೆ", "ಕಿರಣ"),
            correctAnswer = "ರೇಖಾಖಂಡ",
            explanation = "ರೇಖಾಖಂಡವು (Line Segment) ಎರಡು ಅಂತ್ಯಬಿಂದುಗಳನ್ನು ಮತ್ತು ನಿರ್ದಿಷ್ಟ ಉದ್ದವನ್ನು ಹೊಂದಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u2_4",
            stdId = 6,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೋನವನ್ನು ಅಳೆಯಲು ಬಳಸುವ ಜ್ಯಾಮಿತೀಯ ಉಪಕರಣ ಯಾವುದು?",
            options = listOf("ಕೋನಮಾಪಕ (Protractor)", "ಅಳತೆಪಟ್ಟಿ (Scale/Ruler)", "ವಿಭಾಜಕ (Divider)", "ಕೈವಾರ (Compass)"),
            correctAnswer = "ಕೋನಮಾಪಕ (Protractor)",
            explanation = "ಕೋನಗಳನ್ನು ಡಿಗ್ರಿಗಳಲ್ಲಿ ಅಳೆಯಲು ಕೋನಮಾಪಕವನ್ನು (Protractor) ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u2_5",
            stdId = 6,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "ಒಂದು ಪೂರ್ಣಕೋನವು (360°) ಇವುಗಳನ್ನು ಒಳಗೊಂಡಿರುತ್ತದೆ:",
            options = listOf("ಎರಡು ಲಂಬಕೋನಗಳು", "ಎರಡು ಸರಳಕೋನಗಳು", "ನಾಲ್ಕು ಲಂಬಕೋನಗಳು", "ಎರಡು ಸರಳಕೋನಗಳು ಮತ್ತು ನಾಲ್ಕು ಲಂಬಕೋನಗಳು ಎರಡೂ"),
            correctAnswer = "ಎರಡು ಸರಳಕೋನಗಳು ಮತ್ತು ನಾಲ್ಕು ಲಂಬಕೋನಗಳು ಎರಡೂ",
            explanation = "360° = 2 × 180° (ಎರಡು ಸರಳಕೋನಗಳು) = 4 × 90° (ನಾಲ್ಕು ಲಂಬಕೋನಗಳು)."
        ),
        QuestionModel(
            id = "s_6_mat_u2_6",
            stdId = 6,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "ಒಂದು ಸರಳರೇಖೆಗೆ (180°) ಕೋನಾರ್ಧಕ ರೇಖೆಯನ್ನು ಎಳೆದಾಗ ಉಂಟಾಗುವ ಪ್ರತಿಯೊಂದು ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("180°", "30°", "60°", "90°"),
            correctAnswer = "90°",
            explanation = "ಸರಳಕೋನ 180°ಯ ಅರ್ಧಭಾಗ 90° (ಲಂಬಕೋನ) ಆಗಿರುತ್ತದೆ."
        ),

        // ==================== ಘಟಕ 3: ಸಂಖ್ಯಾ ಆಟ ====================
        QuestionModel(
            id = "s_6_mat_u3_1",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "3, 1, 0 ಅಂಕಿಗಳನ್ನು ಬಳಸಿ ರಚಿಸಬಹುದಾದ 5 ಅಂಕಿಯ ಅತಿ ದೊಡ್ಡ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("10003", "33310", "33333", "33301"),
            correctAnswer = "33310",
            explanation = "ದೊಡ್ಡ ಅಂಕಿಯನ್ನು ಗರಿಷ್ಠ ಪುನರಾವರ್ತಿಸಿ ಬರೆದಾಗ 33310 ದೊರೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u3_2",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "2, 5, 4 ಅಂಕಿಗಳನ್ನು ಬಳಸಿ ರಚಿಸಬಹುದಾದ 5 ಅಂಕಿಯ ಪಾಲಿಂಡ್ರೋಮ್ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("22254", "55542", "25452", "44522"),
            correctAnswer = "25452",
            explanation = "25452 ಅನ್ನು ಎಡದಿಂದ ಬಲಕ್ಕೆ ಅಥವಾ ಬಲದಿಂದ ಎಡಕ್ಕೆ ಓದಿದರೂ ಒಂದೇ ಸಂಖ್ಯೆಯಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u3_3",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಎಡದಿಂದ ಬಲಕ್ಕೆ ಮತ್ತು ಬಲದಿಂದ ಎಡಕ್ಕೆ ಓದಿದಾಗ ಬದಲಾಗದ 3 ಅಂಕಿಯ ಅತಿ ಚಿಕ್ಕ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("110", "101", "330", "909"),
            correctAnswer = "101",
            explanation = "101 ಮೂರು ಅಂಕಿಯ ಅತಿ ಚಿಕ್ಕ ಪಾಲಿಂಡ್ರೋಮ್ ಸಂಖ್ಯೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u3_4",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕಪ್ರೀಕರ (Kaprekar) ಮ್ಯಾಜಿಕ್ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("1234", "4321", "6174", "9999"),
            correctAnswer = "6174",
            explanation = "6174 ನಾಲ್ಕು ಅಂಕಿಗಳ ಪ್ರಸಿದ್ಧ ಕಪ್ರೀಕರ್ ಸ್ಥಿರಾಂಕ (Kaprekar's Constant) ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u3_5",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಪಾಲಿಂಡ್ರೋಮ್ (Palindrome) ಸಂಖ್ಯೆಗಳ ಮುಖ್ಯ ಲಕ್ಷಣ ಯಾವುದು?",
            options = listOf(
                "ಸಂಖ್ಯೆಗಳು 10ರಿಂದ ಭಾಗಿಸಲ್ಪಡುತ್ತವೆ",
                "ಎಡದಿಂದ ಬಲಕ್ಕೆ ಮತ್ತು ಬಲದಿಂದ ಎಡಕ್ಕೆ ಓದಿದಾಗ ಒಂದೇ ಆಗಿರುತ್ತವೆ",
                "ಅವುಗಳಲ್ಲಿ ಅಂಕಿಗಳ ಪುನರಾವರ್ತನೆ ಇರುವುದಿಲ್ಲ",
                "ಅವು ಯಾವಾಗಲೂ ಸಮ ಸಂಖ್ಯೆಗಳಾಗಿರುತ್ತವೆ"
            ),
            correctAnswer = "ಎಡದಿಂದ ಬಲಕ್ಕೆ ಮತ್ತು ಬಲದಿಂದ ಎಡಕ್ಕೆ ಓದಿದಾಗ ಒಂದೇ ಆಗಿರುತ್ತವೆ",
            explanation = "ಮುಂದಿನಿಂದ ಮತ್ತು ಹಿಂದಿನಿಂದ ಓದಿದಾಗ ಒಂದೇ ಆಗಿರುವ ಸಂಖ್ಯೆಗಳು ಪಾಲಿಂಡ್ರೋಮ್ ಸಂಖ್ಯೆಗಳು."
        ),
        QuestionModel(
            id = "s_6_mat_u3_6",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "‘21’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ಪ್ರಸಿದ್ಧ ಆಟದಲ್ಲಿ ಗೆಲ್ಲುವ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("10", "21", "50", "100"),
            correctAnswer = "21",
            explanation = "21 ಆಟದಲ್ಲಿ ಮೊದಲು 21 ತಲುಪುವ ಆಟಗಾರನು ಜಯಶಾಲಿಯಾಗುತ್ತಾನೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u3_7",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಂಖ್ಯಾರೇಖೆಯ ಮೇಲಿನ ಈ ವಿನ್ಯಾಸಗಳು ನಿರ್ದಿಷ್ಟ ಪ್ರಮಾಣದ ಏರಿಕೆಯನ್ನು ಸೂಚಿಸುತ್ತವೆ:",
            options = listOf("ಸರಿ ಮತ್ತು ಬೆಸ ಸಂಖ್ಯೆಗಳು", "ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆಗಳು", "ವರ್ಗ ಸಂಖ್ಯೆಗಳು", "ಸಮ ಅಂತರವುಳ್ಳ ಸಂಖ್ಯೆಗಳು"),
            correctAnswer = "ಸಮ ಅಂತರವುಳ್ಳ ಸಂಖ್ಯೆಗಳು",
            explanation = "ಸಂಖ್ಯಾರೇಖೆಯ ಮೇಲೆ ಸಮಾನ ಅಂತರವುಳ್ಳ ಬಿಂದುಗಳು ನಿರ್ದಿಷ್ಟ ಪ್ರಮಾಣದ ಏರಿಕೆಯನ್ನು ತೋರಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u3_8",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "1ರಿಂದ 100ರವರೆಗಿನ ಸಂಖ್ಯೆಗಳನ್ನು ಬರೆಯುವಾಗ '7' ಅಂಕಿ ಎಷ್ಟು ಬಾರಿ ಬರುತ್ತದೆ?",
            options = listOf("10", "15", "20", "25"),
            correctAnswer = "20",
            explanation = "7, 17, 27, 37, 47, 57, 67, 70, 71, 72, 73, 74, 75, 76, 77 (ಎರಡು ಬಾರಿ), 78, 79, 87, 97 = ಒಟ್ಟು 20 ಬಾರಿ."
        ),
        QuestionModel(
            id = "s_6_mat_u3_9",
            stdId = 6,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮೊದಲ ನಾಲ್ಕು ಸಮ ಸಂಖ್ಯೆಗಳ ಮೊತ್ತ ಎಷ್ಟು?",
            options = listOf("20", "16", "8", "10"),
            correctAnswer = "20",
            explanation = "ಮೊದಲ ನಾಲ್ಕು ಸಮ ಸಂಖ್ಯೆಗಳು: 2, 4, 6, 8. ಅವುಗಳ ಮೊತ್ತ = 2 + 4 + 6 + 8 = 20."
        ),

        // ==================== ಘಟಕ 4: ದತ್ತಾಂಶಗಳ ನಿರ್ವಹಣೆ ಮತ್ತು ಪ್ರಸ್ತುತಿ ====================
        QuestionModel(
            id = "s_6_mat_u4_1",
            stdId = 6,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ದತ್ತಾಂಶ (Data) ಎಂದರೆ ಯಾವುದು?",
            options = listOf("ಕೇವಲ ಸಂಖ್ಯೆಗಳು", "ಮಾಹಿತಿಯ ಸಂಗ್ರಹ", "ಆಕೃತಿಗಳು ಮಾತ್ರ", "ಪಟ್ಟಿಗಳು ಮಾತ್ರ"),
            correctAnswer = "ಮಾಹಿತಿಯ ಸಂಗ್ರಹ",
            explanation = "ಯಾವುದೇ ನಿರ್ದಿಷ್ಟ ಉದ್ದೇಶಕ್ಕಾಗಿ ಸಂಗ್ರಹಿಸಲಾದ ಅಂಕಿ-ಅಂಶಗಳು ಅಥವಾ ಮಾಹಿತಿಯ ಸಂಗ್ರಹವನ್ನು ದತ್ತಾಂಶ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u4_2",
            stdId = 6,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಆವರ್ತನವನ್ನು (Frequency) ತ್ವರಿತವಾಗಿ ದಾಖಲಿಸಲು ಯಾವ ಚಿಹ್ನೆಯನ್ನು ಬಳಸಲಾಗುತ್ತದೆ?",
            options = listOf("ಬಾಣ ಗುರುತುಗಳು", "ಟ್ಯಾಲಿ ಗುರುತುಗಳು (Tally marks)", "ನಕ್ಷತ್ರಗಳು", "ವೃತ್ತಗಳು"),
            correctAnswer = "ಟ್ಯಾಲಿ ಗುರುತುಗಳು (Tally marks)",
            explanation = "ದತ್ತಾಂಶಗಳಲ್ಲಿ ಆವರ್ತನವನ್ನು ತ್ವರಿತವಾಗಿ ಲೆಕ್ಕಹಾಕಲು ಟ್ಯಾಲಿ ಗುರುತುಗಳನ್ನು (||||) ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u4_3",
            stdId = 6,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಚಿತ್ರಲೇಖವು (Pictograph) ದತ್ತಾಂಶವನ್ನು ಯಾವುದರ ಮೂಲಕ ತೋರಿಸುತ್ತದೆ?",
            options = listOf("ಸಮೀಕರಣಗಳು", "ಭಿನ್ನರಾಶಿಗಳು", "ಕೋನಗಳು", "ಚಿತ್ರಗಳು"),
            correctAnswer = "ಚಿತ್ರಗಳು",
            explanation = "ಚಿತ್ರಲೇಖವು ದತ್ತಾಂಶವನ್ನು ಸಾಂಕೇತಿಕ ಚಿತ್ರಗಳ ಮೂಲಕ ಸುಲಭವಾಗಿ ಪ್ರಸ್ತುತಪಡಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u4_4",
            stdId = 6,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸ್ತಂಭ ನಕ್ಷೆಗಳಲ್ಲಿನ (Bar graph) ಎಲ್ಲಾ ಸ್ತಂಭಗಳು ಹೇಗಿರಬೇಕು?",
            options = listOf("ಬೇರೆ ಬೇರೆ ಅಗಲ", "ಸಮಾನ ಅಗಲ", "ಅಂತರವಿಲ್ಲದೆ", "ವಕ್ರಾಕಾರ"),
            correctAnswer = "ಸಮಾನ ಅಗಲ",
            explanation = "ಸ್ತಂಭ ನಕ್ಷೆಯ ನಿಯಮದಂತೆ ಎಲ್ಲಾ ಸ್ತಂಭಗಳ ಅಗಲ ಸಮಾನವಾಗಿರಬೇಕು ಹಾಗೂ ಅವುಗಳ ನಡುವಿನ ಅಂತರವೂ ಸಮಾನವಾಗಿರಬೇಕು."
        ),
        QuestionModel(
            id = "s_6_mat_u4_5",
            stdId = 6,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಪರ್ವತಗಳ ಎತ್ತರವನ್ನು ಪರಸ್ಪರ ಹೋಲಿಸಲು ಯಾವ ನಕ್ಷೆ ಅತ್ಯಂತ ಸೂಕ್ತ?",
            options = listOf("ಅಡ್ಡ ಸ್ತಂಭ ನಕ್ಷೆ", "ಪೈ ನಕ್ಷೆ", "ಲಂಬ ಸ್ತಂಭ ನಕ್ಷೆ", "ರೇಖಾ ನಕ್ಷೆ"),
            correctAnswer = "ಲಂಬ ಸ್ತಂಭ ನಕ್ಷೆ",
            explanation = "ಎತ್ತರಗಳನ್ನು ಹೋಲಿಸಲು ಲಂಬ ಸ್ತಂಭ ನಕ್ಷೆಯು (Vertical Bar Graph) ಸ್ಪಷ್ಟ ಮತ್ತು ನೈಸರ್ಗಿಕ ದೃಶ್ಯ ಮಾಧ್ಯಮವಾಗಿದೆ."
        ),

        // ==================== ಘಟಕ 5: ಅವಿಭಾಜ್ಯ ಸಮಯ ====================
        QuestionModel(
            id = "s_6_mat_u5_1",
            stdId = 6,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಈ ಕೆಳಗಿನ ಸಂಖ್ಯೆಗಳಲ್ಲಿ 66ರ ಅಪವರ್ತನವಲ್ಲದ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("3", "6", "11", "4"),
            correctAnswer = "4",
            explanation = "66 ಸಂಖ್ಯೆಯು 4ರಿಂದ ನಿಶ್ಶೇಷವಾಗಿ ಭಾಗವಾಗುವುದಿಲ್ಲ (66 ÷ 4 = 16.5). ಆದ್ದರಿಂದ 4 ಅಪವರ್ತನವಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_mat_u5_2",
            stdId = 6,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ 14ರ ಅಪವರ್ತ್ಯವಾಗಿರುವ (Multiple) ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("28", "44", "80", "21"),
            correctAnswer = "28",
            explanation = "14 × 2 = 28. ಆದ್ದರಿಂದ 28 ಸಂಖ್ಯೆಯು 14ರ ಅಪವರ್ತ್ಯವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u5_3",
            stdId = 6,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "1305 ಅನ್ನು ಪೂರ್ಣವಾಗಿ (ನಿಶ್ಶೇಷವಾಗಿ) ಭಾಗಿಸುವ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("13", "9", "5", "6"),
            correctAnswer = "5",
            explanation = "1305ರ ಕೊನೆಯ ಅಂಕಿ 5 ಆಗಿರುವುದರಿಂದ ಇದು 5ರಿಂದ ಸುಲಭವಾಗಿ ಭಾಗಿಸಲ್ಪಡುತ್ತದೆ (ಹಾಗೆಯೇ ಅಂಕಿಗಳ ಮೊತ್ತ 9 ಆಗಿರುವುದರಿಂದ 9ರಿಂದಲೂ ಭಾಗವಾಗುತ್ತದೆ, ಆದರೆ ಆಯ್ಕೆಯಲ್ಲಿ 5 ನೇರ ಭಾಜ್ಯತೆ ನಿಯಮ)."
        ),
        QuestionModel(
            id = "s_6_mat_u5_4",
            stdId = 6,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಈ ಸಂಖ್ಯೆಗಳ ಜೋಡಿಗಳಲ್ಲಿ ಸಹ-ಅವಿಭಾಜ್ಯ (Co-prime) ಸಂಖ್ಯೆಗಳ ಜೋಡಿ ಯಾವುದು?",
            options = listOf("15 ಮತ್ತು 39", "17 ಮತ್ತು 69", "81 ಮತ್ತು 18", "24 ಮತ್ತು 87"),
            correctAnswer = "17 ಮತ್ತು 69",
            explanation = "17 ಮತ್ತು 69 ಸಂಖ್ಯೆಗಳ ಸಾಮಾನ್ಯ ಅಪವರ್ತನ 1 ಮಾತ್ರ. (17 ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆ, 69 = 3 × 23)."
        ),
        QuestionModel(
            id = "s_6_mat_u5_5",
            stdId = 6,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "48 ಅನ್ನು ಅವಿಭಾಜ್ಯ ಅಪವರ್ತನಗಳ ಗುಣಲಬ್ಧವಾಗಿ ಈ ರೀತಿ ವ್ಯಕ್ತಪಡಿಸಬಹುದು:",
            options = listOf("2×2×2×2×3×5", "3×2×5×1", "2×2×2×2×3", "1×2×2×2×3"),
            correctAnswer = "2×2×2×2×3",
            explanation = "48 = 16 × 3 = 2 × 2 × 2 × 2 × 3."
        ),
        QuestionModel(
            id = "s_6_mat_u5_6",
            stdId = 6,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆ (Prime number) ಯಾವುದು?",
            options = listOf("21", "15", "17", "27"),
            correctAnswer = "17",
            explanation = "17 ಕೇವಲ 1 ಮತ್ತು 17ರಿಂದ ಮಾತ್ರ ಭಾಗವಾಗುವ ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u5_7",
            stdId = 6,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ಯಾವ ಜೋಡಿ ಸಹ-ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆಗಳಾಗಿವೆ?",
            options = listOf("12 ಮತ್ತು 18", "15 ಮತ್ತು 37", "24 ಮತ್ತು 36", "21 ಮತ್ತು 49"),
            correctAnswer = "15 ಮತ್ತು 37",
            explanation = "15 ಮತ್ತು 37ರ ಗ.ಸಾ.ಅ 1 ಆಗಿದೆ. ಆದ್ದರಿಂದ ಅವು ಸಹ-ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆಗಳು."
        ),

        // ==================== ಘಟಕ 6: ಸುತ್ತಳತೆ ಮತ್ತು ವಿಸ್ತೀರ್ಣ ====================
        QuestionModel(
            id = "s_6_mat_u6_1",
            stdId = 6,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಬಾಹುವಿನ ಅಳತೆ 10 cm ಇರುವ ಚೌಕದ ವಿಸ್ತೀರ್ಣ ಎಷ್ಟು?",
            options = listOf("100 cm²", "10 cm²", "40 cm²", "50 cm²"),
            correctAnswer = "100 cm²",
            explanation = "ಚೌಕದ ವಿಸ್ತೀರ್ಣ = ಬಾಹು × ಬಾಹು = 10 cm × 10 cm = 100 cm²."
        ),
        QuestionModel(
            id = "s_6_mat_u6_2",
            stdId = 6,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಬಾಹುವಿನ ಅಳತೆ 10 cm ಇರುವ ಚೌಕದ ಸುತ್ತಳತೆ ಎಷ್ಟು?",
            options = listOf("20 cm", "30 cm", "40 cm", "100 cm"),
            correctAnswer = "40 cm",
            explanation = "ಚೌಕದ ಸುತ್ತಳತೆ = 4 × ಬಾಹು = 4 × 10 cm = 40 cm."
        ),

        // ==================== ಘಟಕ 7: ಭಿನ್ನರಾಶಿಗಳು ====================
        QuestionModel(
            id = "s_6_mat_u7_1",
            stdId = 6,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ಭಿನ್ನರಾಶಿಗಳಲ್ಲಿ ಅತಿ ಚಿಕ್ಕ ಭಿನ್ನರಾಶಿ ಯಾವುದು? (5/4, 5/3, 5/6, 5/2)",
            options = listOf("5/4", "5/3", "5/6", "5/2"),
            correctAnswer = "5/6",
            explanation = "ಅಂಶಗಳು ಸಮಾನವಾಗಿದ್ದಾಗ, ಛೇದವು ದೊಡ್ಡದಾಗಿರುವ ಭಿನ್ನರಾಶಿಯು ಅತಿ ಚಿಕ್ಕದಾಗಿರುತ್ತದೆ (5/6 < 5/4 < 5/3 < 5/2)."
        ),
        QuestionModel(
            id = "s_6_mat_u7_2",
            stdId = 6,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "16/9 ಅನ್ನು ಮಿಶ್ರ ಭಿನ್ನರಾಶಿಯಾಗಿ ವ್ಯಕ್ತಪಡಿಸಿದಾಗ ದೊರೆಯುವ ರೂಪ ಯಾವುದು?",
            options = listOf("2 7/9", "1 5/9", "1 7/9", "2 5/9"),
            correctAnswer = "1 7/9",
            explanation = "16 ÷ 9 = ಭಾಗಲಬ್ಧ 1 ಮತ್ತು ಶೇಷ 7, ಆದ್ದರಿಂದ ಮಿಶ್ರ ಭಿನ್ನರಾಶಿ 1 7/9."
        ),
        QuestionModel(
            id = "s_6_mat_u7_3",
            stdId = 6,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "ಒಂದು ಗಂಟೆಯಲ್ಲಿ (60 ನಿಮಿಷ) 45 ನಿಮಿಷವನ್ನು ಕೆಳಗಿನ ಯಾವ ಭಿನ್ನರಾಶಿ ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಯಾವುದೂ ಅಲ್ಲ", "3/4", "1/4", "1/2"),
            correctAnswer = "3/4",
            explanation = "45/60 = (45 ÷ 15) / (60 ÷ 15) = 3/4."
        ),
        QuestionModel(
            id = "s_6_mat_u7_4",
            stdId = 6,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "17/101 ಮತ್ತು 12/101 ನಡುವಿನ ಸರಿಯಾದ ಸಂಬಂಧ ಯಾವುದು?",
            options = listOf("17/101 > 12/101", "17/101 < 12/101", "17/101 = 12/101", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "17/101 > 12/101",
            explanation = "ಛೇದಗಳು ಸಮಾನವಾಗಿದ್ದಾಗ (101), ದೊಡ್ಡ ಅಂಶ ಹೊಂದಿರುವ ಭಿನ್ನರಾಶಿಯು ದೊಡ್ಡದಾಗಿರುತ್ತದೆ (17 > 12)."
        ),

        // ==================== ಘಟಕ 8: ರಚನೆಗಳೊಂದಿಗೆ ಆಟ ====================
        QuestionModel(
            id = "s_6_mat_u8_1",
            stdId = 6,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "ಚೌಕವು (Square) ಹೊಂದಿರುವ ಸಮಬಾಹುಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("4", "2", "3", "5"),
            correctAnswer = "4",
            explanation = "ಚೌಕದ ಎಲ್ಲಾ 4 ಬಾಹುಗಳು ಪರಸ್ಪರ ಸಮಾನವಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u8_2",
            stdId = 6,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "ವೃತ್ತದ ಮೇಲಿರುವ ಎಲ್ಲಾ ಬಿಂದುಗಳು ಯಾವುದರಿಂದ ಸಮಾನ ದೂರದಲ್ಲಿರುತ್ತವೆ?",
            options = listOf("ತ್ರಿಜ್ಯ", "ಕೇಂದ್ರ", "ವ್ಯಾಸ", "ಪರಿಧಿ"),
            correctAnswer = "ಕೇಂದ್ರ",
            explanation = "ವೃತ್ತದ ಕೇಂದ್ರಬಿಂದುವಿನಿಂದ ವೃತ್ತದ ಪರಿಧಿಯ ಮೇಲಿನ ಎಲ್ಲಾ ಬಿಂದುಗಳಿಗೂ ಇರುವ ಅಂತರವು ಸಮಾನವಾಗಿರುತ್ತದೆ (ತ್ರಿಜ್ಯ)."
        ),
        QuestionModel(
            id = "s_6_mat_u8_3",
            stdId = 6,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "AB ರೇಖಾಖಂಡದ ಉದ್ದ 7 cm. M ಬಿಂದುವು ABಯ ಮಧ್ಯಬಿಂದು. A ಬಿಂದುವಿನಿಂದ Mವರೆಗಿನ ಅಂತರ ಎಷ್ಟು?",
            options = listOf("7 cm", "14 cm", "49 cm", "3.5 cm"),
            correctAnswer = "3.5 cm",
            explanation = "ಮಧ್ಯಬಿಂದುವು ರೇಖಾಖಂಡವನ್ನು ಸಮನಾಗಿ ಎರಡು ಭಾಗ ಮಾಡುತ್ತದೆ: 7 cm ÷ 2 = 3.5 cm."
        ),
        QuestionModel(
            id = "s_6_mat_u8_4",
            stdId = 6,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "ABCD ಆಯತವನ್ನು ಅನುಕ್ರಮವಾಗಿ ಈ ರೀತಿ ಗುರುತಿಸಬಹುದು:",
            options = listOf("ACDB", "DABC", "CABA", "BDCA"),
            correctAnswer = "DABC",
            explanation = "ಜ್ಯಾಮಿತೀಯ ಶೃಂಗಗಳನ್ನು ಅನುಕ್ರಮವಾಗಿ ಸುತ್ತುವರಿದು ಹೆಸರಿಸಿದಾಗ ABCD ಯು DABC ಗೆ ಸಮನಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u8_5",
            stdId = 6,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "ಚೌಕದಲ್ಲಿ ಪ್ರತಿಯೊಂದು ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("45°", "60°", "90°", "120°"),
            correctAnswer = "90°",
            explanation = "ಚೌಕದ ನಾಲ್ಕೂ ಕೋನಗಳು ಲಂಬಕೋನಗಳಾಗಿರುತ್ತವೆ (90°)."
        ),
        QuestionModel(
            id = "s_6_mat_u8_6",
            stdId = 6,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "ಆಯತದ ಕರ್ಣಗಳ ಬಗ್ಗೆ ಕೆಳಗಿನ ಹೇಳಿಕೆಗಳಲ್ಲಿ ಯಾವುದು ಸರಿ?",
            options = listOf(
                "ಅವು ಯಾವಾಗಲೂ ಸಮಾಂತರವಾಗಿರುತ್ತವೆ",
                "ಅವು 90°ನಲ್ಲಿ ಪರಸ್ಪರ ವಿಭಜಿಸುತ್ತವೆ",
                "ಅವು ಉದ್ದದಲ್ಲಿ ಸಮಾನವಾಗಿರುತ್ತವೆ",
                "ಯಾವುದೂ ಅಲ್ಲ"
            ),
            correctAnswer = "ಅವು ಉದ್ದದಲ್ಲಿ ಸಮಾನವಾಗಿರುತ್ತವೆ",
            explanation = "ಆಯತದ ಎರಡೂ ಕರ್ಣಗಳು ಪರಸ್ಪರ ಸಮಾನ ಉದ್ದವನ್ನು ಹೊಂದಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u8_7",
            stdId = 6,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "ಒಂದು ಆಯತಕ್ಕೆ ಎಳೆಯಬಹುದಾದ ಗರಿಷ್ಠ ಕರ್ಣಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("3", "2", "1", "ಅನಂತ"),
            correctAnswer = "2",
            explanation = "ಚತುರ್ಭುಜ ಅಥವಾ ಆಯತಕ್ಕೆ ಎಳೆಯಬಹುದಾದ ಕರ್ಣಗಳ ಗರಿಷ್ಠ ಸಂಖ್ಯೆ 2."
        ),
        QuestionModel(
            id = "s_6_mat_u8_8",
            stdId = 6,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "ಆಯತದಲ್ಲಿ ಪ್ರತಿಯೊಂದು ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("45°", "60°", "90°", "120°"),
            correctAnswer = "90°",
            explanation = "ಆಯತದ ನಾಲ್ಕೂ ಕೋನಗಳು ಲಂಬಕೋನಗಳಾಗಿದ್ದು ಪ್ರತಿಯೊಂದರ ಅಳತೆ 90° ಆಗಿರುತ್ತದೆ."
        ),

        // ==================== ಘಟಕ 9: ಸಮಮಿತಿ ====================
        QuestionModel(
            id = "s_6_mat_u9_1",
            stdId = 6,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ವಜ್ರಾಕೃತಿಯು (Rhombus) ಹೊಂದಿರುವ ಸಮಮಿತಿ ಅಕ್ಷಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("1", "2", "3", "4"),
            correctAnswer = "2",
            explanation = "ವಜ್ರಾಕೃತಿಯ ಕರ್ಣಗಳ ಮೂಲಕ ಹಾದುಹೋಗುವ 2 ಸಮಮಿತಿ ಅಕ್ಷಗಳು ಇರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u9_2",
            stdId = 6,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಇಂಗ್ಲಿಷ್ 'V' ಅಕ್ಷರಕ್ಕೆ ಇರುವ ಸಮಮಿತಿ ಅಕ್ಷಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("1", "ಅನಂತ", "4", "6"),
            correctAnswer = "1",
            explanation = "'V' ಅಕ್ಷರವು ಕೇವಲ 1 ಲಂಬ ಸಮಮಿತಿ ಅಕ್ಷವನ್ನು (Vertical line of symmetry) ಹೊಂದಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u9_3",
            stdId = 6,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಒಂದು ನಿಯತ ಷಡ್ಭುಜಾಕೃತಿಯ (Regular Hexagon) ರೇಖಾ ಸಮಮಿತಿಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("3", "6", "4", "12"),
            correctAnswer = "6",
            explanation = "ನಿಯತ ಷಡ್ಭುಜಾಕೃತಿಯು 6 ಸಮಬಾಹುಗಳನ್ನು ಹೊಂದಿದ್ದು 6 ರೇಖಾ ಸಮಮಿತಿಗಳನ್ನು ಹೊಂದಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u9_4",
            stdId = 6,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಕರ್ಣವನ್ನು ಸಮಮಿತಿ ಅಕ್ಷವಾಗಿ ಹೊಂದಿರುವ ಆಕೃತಿ ಯಾವುದು?",
            options = listOf("ವರ್ಗ (ಚೌಕ)", "ಸಮಾಂತರ ಚತುರ್ಭುಜ", "ಆಯತ", "ಪಂಚಭುಜಾಕೃತಿ"),
            correctAnswer = "ವರ್ಗ (ಚೌಕ)",
            explanation = "ವರ್ಗದಲ್ಲಿ (ಚೌಕ) ಕರ್ಣಗಳು ಸಮಮಿತಿ ಅಕ್ಷಗಳಾಗಿ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತವೆ (ಆಯತದಲ್ಲಿ ಕರ್ಣಗಳು ಸಮಮಿತಿ ಅಕ್ಷಗಳಲ್ಲ)."
        ),
        QuestionModel(
            id = "s_6_mat_u9_5",
            stdId = 6,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಇವುಗಳಲ್ಲಿ 90° ಭ್ರಮಣ ಸಮಮಿತಿ (Rotational symmetry) ಹೊಂದಿರುವ ಆಕೃತಿ ಯಾವುದು?",
            options = listOf("ಆಯತ", "ವರ್ಗ (ಚೌಕ)", "ಸಮಬಾಹು ತ್ರಿಭುಜ", "ಸಮಾಂತರ ಚತುರ್ಭುಜ"),
            correctAnswer = "ವರ್ಗ (ಚೌಕ)",
            explanation = "ವರ್ಗವು ಪ್ರತಿ 90° ತಿರುಗುವಿಕೆಯಲ್ಲೂ ತನ್ನ ಮೊದಲಿನ ರೂಪವನ್ನೇ ಹೋಲುತ್ತದೆ."
        ),

        // ==================== ಘಟಕ 10: ಸೊನ್ನೆಯ ಮತ್ತೊಂದು ಬದಿ ====================
        QuestionModel(
            id = "s_6_mat_u10_1",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "(−11) + (−15) ಮತ್ತು 11 + 15 ನಡುವಿನ ಸರಿಯಾದ ಸಂಬಂಧ ಯಾವುದು?",
            options = listOf("<", ">", "=", "ಆಯ್ಕೆ ಇಲ್ಲ"),
            correctAnswer = "<",
            explanation = "(−11) + (−15) = −26; 11 + 15 = 26. ಋಣ ಸಂಖ್ಯೆಯು ಧನ ಸಂಖ್ಯೆಗಿಂತ ಚಿಕ್ಕದು (−26 < 26)."
        ),
        QuestionModel(
            id = "s_6_mat_u10_2",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸಂಖ್ಯಾರೇಖೆಯಲ್ಲಿ ಎಡಕ್ಕೆ ಅತಿ ದೂರದಲ್ಲಿರುವ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("−12", "−5", "0", "10"),
            correctAnswer = "−12",
            explanation = "ಸಂಖ್ಯಾರೇಖೆಯಲ್ಲಿ ಎಡಕ್ಕೆ ಹೋದಂತೆ ಸಂಖ್ಯೆಗಳ ಮೌಲ್ಯ ಕಡಿಮೆಯಾಗುತ್ತದೆ; −12 ಎಲ್ಲಕ್ಕಿಂತ ಎಡಕ್ಕಿದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u10_3",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸೊನ್ನೆಗಿಂತ (0) ಕಡಿಮೆ ಇರುವ ಸಂಖ್ಯೆಗಳು ಯಾವುವು?",
            options = listOf("ಧನ ಸಂಖ್ಯೆಗಳು", "ದಶಮಾಂಶಗಳು", "ಪೂರ್ಣ ಸಂಖ್ಯೆಗಳು", "ಋಣ ಸಂಖ್ಯೆಗಳು"),
            correctAnswer = "ಋಣ ಸಂಖ್ಯೆಗಳು",
            explanation = "ಸೊನ್ನೆಗಿಂತ ಕಡಿಮೆ ಮೌಲ್ಯವನ್ನು ಹೊಂದಿರುವ ಸಂಖ್ಯೆಗಳನ್ನು ಋಣ ಸಂಖ್ಯೆಗಳು (Negative numbers) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u10_4",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "ಋಣ ಸಂಖ್ಯೆಗಳ ಬಗ್ಗೆ ಸರಿಯಾದ ಹೇಳಿಕೆ ಯಾವುದು?",
            options = listOf(
                "ಅವು ಯಾವಾಗಲೂ ಧನ ಸಂಖ್ಯೆಗಳಿಗಿಂತ ಕಡಿಮೆ",
                "ಅವು ಯಾವಾಗಲೂ ಧನ ಸಂಖ್ಯೆಗಳಿಗಿಂತ ಹೆಚ್ಚು",
                "ಅವು ಧನ ಸಂಖ್ಯೆಗಳಿಗೇ ಸಮ",
                "ಅವು ಭಿನ್ನರಾಶಿಗಳಿಗೆ ಸಮವಾಗಿರುತ್ತವೆ"
            ),
            correctAnswer = "ಅವು ಯಾವಾಗಲೂ ಧನ ಸಂಖ್ಯೆಗಳಿಗಿಂತ ಕಡಿಮೆ",
            explanation = "ಯಾವುದೇ ಋಣ ಸಂಖ್ಯೆಯು ಯಾವುದೇ ಧನ ಸಂಖ್ಯೆಗಿಂತ ಯಾವಾಗಲೂ ಕಿರಿದಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_mat_u10_5",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "ಧನಾತ್ಮಕವೂ ಅಲ್ಲ, ಋಣಾತ್ಮಕವೂ ಅಲ್ಲದ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("−1", "0", "1", "100"),
            correctAnswer = "0",
            explanation = "ಸೊನ್ನೆ (0) ಧನ ಪೂರ್ಣಾಂಕವೂ ಅಲ್ಲ ಮತ್ತು ಋಣ ಪೂರ್ಣಾಂಕವೂ ಅಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_mat_u10_6",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "+7ರ ವಿರುದ್ಧ ಸಂಖ್ಯೆ (Additive inverse) ಯಾವುದು?",
            options = listOf("+7", "−7", "0", "1"),
            correctAnswer = "−7",
            explanation = "+7ರ ಸಂಕಲನದ ವಿಲೋಮ ಅಥವಾ ವಿರುದ್ಧ ಸಂಖ್ಯೆ −7."
        ),
        QuestionModel(
            id = "s_6_mat_u10_7",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬಹುಮಹಡಿಯ ಕಟ್ಟಡದಲ್ಲಿ ನೆಲಮಹಡಿಯನ್ನು (Ground floor) ಸೂಚಿಸುವ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("+1", "−1", "0", "+2"),
            correctAnswer = "0",
            explanation = "ನೆಲಮಹಡಿಯನ್ನು ಉಲ್ಲೇಖ ಮಟ್ಟವಾಗಿ '0' ಎಂದು ಸೂಚಿಸಲಾಗುತ್ತದೆ; ಮೇಲಿನ ಮಹಡಿಗಳು ಧನ ಮತ್ತು ನೆಲಮಾಳಿಗೆಗಳು ಋಣ."
        ),
        QuestionModel(
            id = "s_6_mat_u10_8",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "ತಾಪಮಾನ −50°C ಇದ್ದು, ಇನ್ನೂ 30°C ಕಡಿಮೆಯಾದರೆ ಹೊಸ ತಾಪಮಾನ ಎಷ್ಟು?",
            options = listOf("−80°C", "−20°C", "30°C", "80°C"),
            correctAnswer = "−80°C",
            explanation = "ತಾಪಮಾನ ಕಡಿಮೆಯಾದರೆ: (−50°C) − 30°C = −80°C."
        ),
        QuestionModel(
            id = "s_6_mat_u10_9",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "(−4) + (+6) ಮೊತ್ತ ಎಷ್ಟು?",
            options = listOf("−10", "−2", "2", "10"),
            correctAnswer = "2",
            explanation = "ವಿಭಿನ್ನ ಚಿಹ್ನೆಗಳಿದ್ದಾಗ ದೊಡ್ಡ ಸಂಖ್ಯೆಯಿಂದ ಸಣ್ಣ ಸಂಖ್ಯೆ ಕಳೆದು ದೊಡ್ಡ ಸಂಖ್ಯೆಯ ಚಿಹ್ನೆ ಹಾಕಬೇಕು: 6 − 4 = 2 (+2)."
        ),
        QuestionModel(
            id = "s_6_mat_u10_10",
            stdId = 6,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "ನೀವು +3ನೇ ಮಹಡಿಯಲ್ಲಿದ್ದೀರಿ. ಲಿಫ್ಟ್‌ನಲ್ಲಿ “−” ಅನ್ನು 5 ಬಾರಿ ಕೆಳಗೆ ಇಳಿಸಿದರೆ ಯಾವ ಮಹಡಿಗೆ ತಲುಪುತ್ತೀರಿ?",
            options = listOf("+8", "−2", "0", "−3"),
            correctAnswer = "−2",
            explanation = "+3 ರಿಂದ 5 ಮಹಡಿ ಕೆಳಗೆ: 3 − 5 = −2 (ನೆಲಮಾಳಿಗೆಯ 2ನೇ ಹಂತ)."
        )
    )
}
