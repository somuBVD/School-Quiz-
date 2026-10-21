package com.example.data

/**
 * 9th Standard Kannada (ಪ್ರಥಮ ಭಾಷೆ ಕನ್ನಡ) - ಪದ್ಯ ಭಾಗ (Poetry Units 9 to 16)
 * Sourced directly from Karnataka State DSERT 2026-27 LBA Question Bank.
 * Includes MCQs, Analogies/Fill-in-the-blanks, and Single-line questions converted to MCQs.
 */
object Std9KannadaPoemQuestionBank {

    val units = listOf(
        UnitTemplate(9, "ಘಟಕ 9: ಪಾರಿವಾಳ (ಸು.ರಂ. ಎಕ್ಕುಂಡಿ)", 21, "Easy"),
        UnitTemplate(10, "ಘಟಕ 10: ಹೊಸ ಹಾಡು (ಕಯ್ಯಾರ ಕಿಞ್ಞಣ್ಣ ರೈ)", 18, "Medium"),
        UnitTemplate(11, "ಘಟಕ 11: ಚಕ್ರಗ್ರಹಣ (ದೇವಿದಾಸ)", 25, "Hard"),
        UnitTemplate(12, "ಘಟಕ 12: ಬಲಿಯನಿತ್ತೊಡೆ ಮುನಿವೆಂ (ಜನ್ನ)", 23, "Hard"),
        UnitTemplate(13, "ಘಟಕ 13: ಹೇಮಂತ (ಎಸ್. ವಿ. ಪರಮೇಶ್ವರ ಭಟ್ಟ)", 16, "Medium"),
        UnitTemplate(14, "ಘಟಕ 14: ತತ್ವಪದಗಳು (ಕಡಕೋಳ ಮಡಿವಾಳಪ್ಪ & ಸಂತ ಶಿಶುನಾಳ ಶರೀಫರು)", 31, "Medium"),
        UnitTemplate(15, "ಘಟಕ 15: ನಿನ್ನ ಮುತ್ತಿನ ಸತ್ತಿಗೆಯನಿತ್ತು ಸಲಹು (ರಾಘವಾಂಕ)", 20, "Medium"),
        UnitTemplate(16, "ಘಟಕ 16: ಕನ್ನಡ ನಾಡು ನುಡಿ (ಶ್ರೀ ವಿಜಯ, ನಯಸೇನ, ನೇಮಿಚಂದ್ರ, ಮಹಲಿಂಗರಂಗ, ಆಂಡಯ್ಯ)", 19, "Easy")
    )

    val questions: List<QuestionModel> = listOf(
        // ==========================================
        // ಘಟಕ 9: ಪಾರಿವಾಳ (ಸು.ರಂ. ಎಕ್ಕುಂಡಿ)
        // ==========================================
        QuestionModel(
            id = "s9_kan_u9_1",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಉಪಮೇಯ, ಉಪಮಾನ, ಸಮಾನಧರ್ಮ, ಉಪಮಾವಾಚಕ ಈ ನಾಲ್ಕೂ ಅಂಶಗಳು ಇರುವ ಅಲಂಕಾರ:",
            options = listOf("ಪೂರ್ಣೋಪಮಾಲಂಕಾರ", "ಲುಪ್ತೋಪಮಾಲಂಕಾರ", "ರೂಪಕಾಲಂಕಾರ", "ಶಬ್ದಾಲಂಕಾರ"),
            correctAnswer = "ಪೂರ್ಣೋಪಮಾಲಂಕಾರ",
            explanation = "ಉಪಮೆಯ ನಾಲ್ಕೂ ಅಂಗಗಳಾದ ಉಪಮೇಯ, ಉಪಮಾನ, ಉಪಮಾವಾಚಕ, ಸಮಾನಧರ್ಮಗಳು ಸ್ಪಷ್ಟವಾಗಿರುವ ಅಲಂಕಾರವೇ ಪೂರ್ಣೋಪಮಾಲಂಕಾರ."
        ),
        QuestionModel(
            id = "s9_kan_u9_2",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "'ಮಾತು ಬಲ್ಲವನಿಗೆ ಜಗಳವಿಲ್ಲ; ಊಟ ಬಲ್ಲವನಿಗೆ ರೋಗವಿಲ್ಲ' - ಈ ವಾಕ್ಯದಲ್ಲಿರುವ ಅಲಂಕಾರ:",
            options = listOf("ದೃಷ್ಟಾಂತಾಲಂಕಾರ", "ರೂಪಕಾಲಂಕಾರ", "ಉಪಮಾಲಂಕಾರ", "ಉತ್ಪ್ರೇಕ್ಷಾಲಂಕಾರ"),
            correctAnswer = "ದೃಷ್ಟಾಂತಾಲಂಕಾರ",
            explanation = "ಎರಡು ವಾಕ್ಯಗಳ ಅರ್ಥವು ಬಿಂಬ-ಪ್ರತಿಬಿಂಬ ಭಾವದಿಂದ ಕೂಡಿದ್ದರೆ ಅದು ದೃಷ್ಟಾಂತಾಲಂಕಾರ."
        ),
        QuestionModel(
            id = "s9_kan_u9_3",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "'ಗೀಜಗನ ಗೂಡುಗಳು ತೊಟ್ಟಿಲಿನಂತೆ ತೂಗಾಡುತ್ತಿದ್ದವು'. ಈ ವಾಕ್ಯದಲ್ಲಿರುವ ಉಪಮಾನ ಯಾವುದು?",
            options = listOf("ತೊಟ್ಟಿಲು", "ಗೀಜಗನ ಗೂಡು", "ಅಂತೆ", "ತೂಗಾಡುವುದು"),
            correctAnswer = "ತೊಟ್ಟಿಲು",
            explanation = "ಹೋಲಿಕೆಗೆ ತಂದ ಸುಪ್ರಸಿದ್ಧ ವಸ್ತು ಉಪಮಾನ (ತೊಟ್ಟಿಲು)."
        ),
        QuestionModel(
            id = "s9_kan_u9_4",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "'ಬಾನಿನಲ್ಲಿ ಗಾಳಿಪಟಗಳು ಹಕ್ಕಿಗಳಂತೆ ಹಾರಾಡುತ್ತಿದ್ದವು' ಈ ವಾಕ್ಯದಲ್ಲಿರುವ ಸಮಾನಧರ್ಮ:",
            options = listOf("ಹಾರಾಡುವುದು", "ಹಕ್ಕಿಗಳು", "ಗಾಳಿಪಟಗಳು", "ಅಂತೆ"),
            correctAnswer = "ಹಾರಾಡುವುದು",
            explanation = "ಉಪಮೇಯ ಮತ್ತು ಉಪಮಾನಗಳೆರಡರಲ್ಲೂ ಇರುವ ಸಮಾನ ಕ್ರಿಯೆ 'ಹಾರಾಡುವುದು'."
        ),
        QuestionModel(
            id = "s9_kan_u9_5",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಉಪಮೇಯ ಉಪಮಾನಗಳು ಎರಡೂ ಒಂದೇ ಎಂದು ಅಭೇದವಾಗಿ ಹೇಳುವ ಅಲಂಕಾರ:",
            options = listOf("ರೂಪಕಾಲಂಕಾರ", "ಉಪಮಾಲಂಕಾರ", "ಶಬ್ದಾಲಂಕಾರ", "ಅರ್ಥಾಂತರನ್ಯಾಸಾಲಂಕಾರ"),
            correctAnswer = "ರೂಪಕಾಲಂಕಾರ",
            explanation = "ಉಪಮೇಯ ಮತ್ತು ಉಪಮಾನಗಳಲ್ಲಿ ಭೇದವಿಲ್ಲದೆ ಒಂದೇ ಎಂದು ವರ್ಣಿಸುವುದು ರೂಪಕಾಲಂಕಾರ."
        ),
        QuestionModel(
            id = "s9_kan_u9_6",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "'ಶಾಲೆಗೆ ಈ ವಿದ್ಯಾರ್ಥಿಯೊಂದು ರತ್ನ' ಈ ವಾಕ್ಯದಲ್ಲಿರುವ ಉಪಮೇಯ:",
            options = listOf("ವಿದ್ಯಾರ್ಥಿ", "ಶಾಲೆ", "ರತ್ನ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ವಿದ್ಯಾರ್ಥಿ",
            explanation = "ವರ್ಣಿಸಲ್ಪಡುವ ವಸ್ತು ಉಪಮೇಯ (ವಿದ್ಯಾರ್ಥಿ)."
        ),
        QuestionModel(
            id = "s9_kan_u9_7",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಎರಡು ವಸ್ತುಗಳಲ್ಲಿ ಪರಸ್ಪರ ಇರುವ ಹೋಲಿಕೆಯನ್ನು ವರ್ಣಿಸುವ ಅಲಂಕಾರ:",
            options = listOf("ಉಪಮಾಲಂಕಾರ", "ದೃಷ್ಟಾಂತಾಲಂಕಾರ", "ರೂಪಕಾಲಂಕಾರ", "ಅರ್ಥಾಲಂಕಾರ"),
            correctAnswer = "ಉಪಮಾಲಂಕಾರ",
            explanation = "ಹೋಲಿಕೆಯನ್ನು ಸ್ಪಷ್ಟವಾಗಿ ಹೇಳುವ ಅಲಂಕಾರ ಉಪಮಾಲಂಕಾರ."
        ),
        QuestionModel(
            id = "s9_kan_u9_8",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಉಪಮೇಯ : ವರ್ಣ್ಯ :: ಉಪಮಾನ : __________",
            options = listOf("ಅವರ್ಣ್ಯ", "ಸಮಾನಧರ್ಮ", "ವಾಚಕ", "ರೂಪಕ"),
            correctAnswer = "ಅವರ್ಣ್ಯ",
            explanation = "ಉಪಮೇಯವನ್ನು ವರ್ಣ್ಯವೆಂದೂ, ಉಪಮಾನವನ್ನು ಅವರ್ಣ್ಯವೆಂದೂ ಕರೆಯುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u9_9",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಹೋಲಿಕೆಯಾಗಿದೆ ಎಂದು ಹೇಳುವ ಪದ : ಅಂತೆ :: ಉಪಮೇಯ ಉಪಮಾನಗಳ ಗುಣಗಳನ್ನು ತಿಳಿಸುವ ಪದ : __________",
            options = listOf("ಸಮಾನಧರ್ಮ", "ಉಪಮಾನ", "ಉಪಮೇಯ", "ವಾಚಕಪದ"),
            correctAnswer = "ಸಮಾನಧರ್ಮ",
            explanation = "ಉಭಯತ್ರ ಇರುವ ಸಾಮಾನ್ಯ ಗುಣವೇ ಸಮಾನಧರ್ಮ."
        ),
        QuestionModel(
            id = "s9_kan_u9_10",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸೀತೆಯ ಮುಖ ಕಮಲದಂತೆ ಅರಳಿತು : ಉಪಮಾಲಂಕಾರ :: ಸೀತೆಯ ಮುಖ ಕಮಲ ಅರಳಿತು : __________",
            options = listOf("ರೂಪಕಾಲಂಕಾರ", "ದೃಷ್ಟಾಂತಾಲಂಕಾರ", "ಉಪಮಾಲಂಕಾರ", "ಶ್ಲೇಷಾಲಂಕಾರ"),
            correctAnswer = "ರೂಪಕಾಲಂಕಾರ",
            explanation = "ಮುಖವೇ ಕಮಲವೆಂದು ಅಭೇದವಾಗಿ ಹೇಳಿರುವುದರಿಂದ ರೂಪಕಾಲಂಕಾರ."
        ),
        QuestionModel(
            id = "s9_kan_u9_11",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಎರಡು ವಸ್ತುಗಳಲ್ಲಿ ಹೋಲಿಕೆ : ಉಪಮಾಲಂಕಾರ :: ಎರಡು ವಾಕ್ಯಗಳ ಅರ್ಥ ಬಿಂಬ ಪ್ರತಿಬಿಂಬದಂತೆ ತೋರುತ್ತಿದ್ದರೆ : __________",
            options = listOf("ದೃಷ್ಟಾಂತಾಲಂಕಾರ", "ರೂಪಕಾಲಂಕಾರ", "ಉಪಮಾಲಂಕಾರ", "ಉತ್ಪ್ರೇಕ್ಷಾಲಂಕಾರ"),
            correctAnswer = "ದೃಷ್ಟಾಂತಾಲಂಕಾರ",
            explanation = "ಬಿಂಬ-ಪ್ರತಿಬಿಂಬ ರೂಪದಲ್ಲಿ ಎರಡು ವಾಕ್ಯಗಳು ಬಂದರೆ ದೃಷ್ಟಾಂತಾಲಂಕಾರ."
        ),
        QuestionModel(
            id = "s9_kan_u9_12",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮುದ್ದು ಬಿಳಿ ಪಾರಿವಾಳಗಳ ಜೋಡಿ ಎಲ್ಲಿ ಸಂಸಾರ ಹೂಡಿದ್ದವು?",
            options = listOf("ದಟ್ಟ ಕಾಡಿನಲ್ಲಿದ್ದ ಹೆಮ್ಮರದ ಪೊದರಿನಲ್ಲಿ", "ಮನೆಯ ಮಾಳಿಗೆಯಲ್ಲಿ", "ಕೋಟೆಯ ಗೋಪುರದಲ್ಲಿ", "ದೇವಾಲಯದ ಶಿಖರದಲ್ಲಿ"),
            correctAnswer = "ದಟ್ಟ ಕಾಡಿನಲ್ಲಿದ್ದ ಹೆಮ್ಮರದ ಪೊದರಿನಲ್ಲಿ",
            explanation = "ದಟ್ಟ ಕಾನನದ ಒಂದು ಹೆಮ್ಮರದ ಪೊಟರೆಯಲ್ಲಿ ಪಾರಿವಾಳಗಳ ಜೋಡಿ ನೆಲೆಸಿತ್ತು."
        ),
        QuestionModel(
            id = "s9_kan_u9_13",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಜೋಡಿ ಪಾರಿವಾಳಗಳು ಹೇಗೆ ಬಾಳುತ್ತಿದ್ದವು?",
            options = listOf("ಹಗಲಿರುಳು ಜೊತೆಗೂಡಿ ಪ್ರೀತಿಯಿಂದ", "ಸದಾ ಜಗಳವಾಡುತ್ತಾ", "ಬೇರೆಬೇರೆಯಾಗಿ", "ಬೇಟೆಗಾರನ ಭಯದಿಂದ"),
            correctAnswer = "ಹಗಲಿರುಳು ಜೊತೆಗೂಡಿ ಪ್ರೀತಿಯಿಂದ",
            explanation = "ಎಂದೂ ಅಗಲದಂತೆ ಹಗಲಿರುಳು ಅನ್ಯೋನ್ಯ ಪ್ರೀತಿಯಿಂದ ಬಾಳುತ್ತಿದ್ದವು."
        ),
        QuestionModel(
            id = "s9_kan_u9_14",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಬಲೆಯಲ್ಲಿದ್ದ ಮರಿಗಳು ಹೊರಗೆ ಬರಲು ಏನು ಮಾಡಿದವು?",
            options = listOf("ಚೀತ್ಕರಿಸತೊಡಗಿದವು", "ಹಾರಿಹೋದವು", "ಸುಮ್ಮನೆ ಮಲಗಿದವು", "ಬಲೆಯನ್ನು ಕತ್ತರಿಸಿದವು"),
            correctAnswer = "ಚೀತ್ಕರಿಸತೊಡಗಿದವು",
            explanation = "ಬೇಡನ ಬಲೆಗೆ ಸಿಲುಕಿದ ಪುಟ್ಟ ಮರಿಗಳು ಹೊರಬರಲಾರದೆ ಚೀತ್ಕಾರ ಮಾಡತೊಡಗಿದವು."
        ),
        QuestionModel(
            id = "s9_kan_u9_15",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಏನನ್ನು ತೊರೆದು ಬಾಳಬೇಕು ಎಂದು ಕವಿ ಹೇಳುತ್ತಾರೆ?",
            options = listOf("ವ್ಯಾಮೋಹವನ್ನು", "ಪ್ರೀತಿಯನ್ನು", "ಆಹಾರವನ್ನು", "ಸಂಸಾರವನ್ನು"),
            correctAnswer = "ವ್ಯಾಮೋಹವನ್ನು",
            explanation = "ಅಂಧ ವ್ಯಾಮೋಹವನ್ನು ತೊರೆದು ತಾಳ್ಮೆ ಮತ್ತು ವಿವೇಕದಿಂದ ಬಾಳಬೇಕೆಂದು ಕವಿ ಸಾರುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u9_16",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಪಾರಿವಾಳ ಪದ್ಯ ಬರೆದ ಕವಿಯ ಹೆಸರೇನು?",
            options = listOf("ಸು. ರಂ. ಎಕ್ಕುಂಡಿ", "ಕಯ್ಯಾರ ಕಿಞ್ಞಣ್ಣ ರೈ", "ಹರಿಹರ", "ಕುವೆಂಪು"),
            correctAnswer = "ಸು. ರಂ. ಎಕ್ಕುಂಡಿ",
            explanation = "ಸುಬ್ಬಣ್ಣ ರಂಗಣ್ಣ ಎಕ್ಕುಂಡಿಯವರು ಈ ಕಥನ ಕವನದ ಕರ್ತೃ."
        ),
        QuestionModel(
            id = "s9_kan_u9_17",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಪಾರಿವಾಳ ಪದ್ಯವನ್ನು ಯಾವ ಕೃತಿಯಿಂದ ಆರಿಸಲಾಗಿದೆ?",
            options = listOf("ಸಮಗ್ರ ಕಥನ ಕವನಗಳು", "ಬಕುಳದ ಹೂಗಳು", "ಮತ್ಸ್ಯಗಂಧಿ", "ಹಾವಾಡಿಗರ ಹುಡುಗ"),
            correctAnswer = "ಸಮಗ್ರ ಕಥನ ಕವನಗಳು",
            explanation = "ಸು.ರಂ. ಎಕ್ಕುಂಡಿಯವರ 'ಸಮಗ್ರ ಕಥನ ಕವನಗಳು' ಸಂಕಲನದಿಂದ ಆಯ್ದುಕೊಳ್ಳಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u9_18",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಬೇಡನು ಹಕ್ಕಿಗಳನ್ನು ಹಿಡಿಯಲು ಏನನ್ನು ಹರಡಿದನು?",
            options = listOf("ಬಲೆಯನ್ನು", "ಹಗ್ಗವನ್ನು", "ಧಾನ್ಯವನ್ನು ಮಾತ್ರ", "ಬಾಣವನ್ನು"),
            correctAnswer = "ಬಲೆಯನ್ನು",
            explanation = "ಬೇಡನು ಮರದ ಕೆಳಗೆ ಧಾನ್ಯ ಚೆಲ್ಲಿ ಬಲೆಯನ್ನು ಹರಡಿದ್ದನು."
        ),
        QuestionModel(
            id = "s9_kan_u9_19",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಬಲೆಯಲ್ಲಿದ್ದ ಮರಿಗಳನ್ನು ಕಂಡು ತಾಯಿ ಪಾರಿವಾಳ ಏನು ಮಾಡಿತು?",
            options = listOf("ತಾನೂ ಕೂಡ ಬಲೆಗೆ ಧುಮುಕಿತು", "ಬೇಡನ ಮೇಲೆ ದಾಳಿ ಮಾಡಿತು", "ದೂರ ಹಾರಿಹೋಯಿತು", "ಇತರ ಹಕ್ಕಿಗಳನ್ನು ಕರೆತಂದಿತು"),
            correctAnswer = "ತಾನೂ ಕೂಡ ಬಲೆಗೆ ಧುಮುಕಿತು",
            explanation = "ಮರಿಗಳ ಸಂಕಟವನ್ನು ಸಹಿಸಲಾರದೆ ಅಂಧ ವಾತ್ಸಲ್ಯದಿಂದ ತಾನೂ ಬಲೆಗೆ ಹಾರಿತು."
        ),
        QuestionModel(
            id = "s9_kan_u9_20",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಕುರುಡು ವಾತ್ಸಲ್ಯದಿಂದ ಪಾರಿವಾಳದ ಹಿಂಡು ಏನು ಮಾಡಿತು?",
            options = listOf("ವಿವೇಕ ಕಳೆದುಕೊಂಡು ಬಲೆಗೆ ನುಗ್ಗಿತು", "ಜಾಣತನದಿಂದ ತಪ್ಪಿಸಿಕೊಂಡಿತು", "ಬೇಡನನ್ನು ಕೊಲ್ಲಲು ಯತ್ನಿಸಿತು", "ಗೂಡಿಗೆ ಮರಳಿತು"),
            correctAnswer = "ವಿವೇಕ ಕಳೆದುಕೊಂಡು ಬಲೆಗೆ ನುಗ್ಗಿತು",
            explanation = "ಕುರುಡು ಪ್ರೀತಿಯಿಂದ ವಿವೇಕವನ್ನು ಮರೆತು ಇಡೀ ಪಾರಿವಾಳಗಳ ಕುಟುಂಬವೇ ಬಲೆಗೆ ಬಲಿಯಾಯಿತು."
        ),
        QuestionModel(
            id = "s9_kan_u9_21",
            stdId = 9,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮೋಹ ಮುಸುಕಿದ ಬುದ್ಧಿ ಯಾವುದರ ಸಿದ್ಧಿ?",
            options = listOf("ಸರ್ವನಾಶದ ಸಿದ್ಧಿ", "ಜಯದ ಸಿದ್ಧಿ", "ಸುಖದ ಸಿದ್ಧಿ", "ಶಾಂತಿಯ ಸಿದ್ಧಿ"),
            correctAnswer = "ಸರ್ವನಾಶದ ಸಿದ್ಧಿ",
            explanation = "ಅತಿಯಾದ ಮೋಹವು ಬುದ್ಧಿಯನ್ನು ಮರೆಮಾಚಿ ಸರ್ವನಾಶಕ್ಕೆ ದಾರಿಮಾಡಿಕೊಡುತ್ತದೆ."
        ),

        // ==========================================
        // ಘಟಕ 10: ಹೊಸ ಹಾಡು (ಕಯ್ಯಾರ ಕಿಞ್ಞಣ್ಣ ರೈ)
        // ==========================================
        QuestionModel(
            id = "s9_kan_u10_1",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "'ನಭ' ಪದದ ಅರ್ಥ:",
            options = listOf("ಆಕಾಶ", "ಭೂಮಿ", "ಮನೆ", "ಕಾಡು"),
            correctAnswer = "ಆಕಾಶ",
            explanation = "ನಭ ಎಂದರೆ ಆಕಾಶ ಅಥವಾ ಗಗನ."
        ),
        QuestionModel(
            id = "s9_kan_u10_2",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "'ಹೊಸ ಹಾಡು' ಪದ್ಯದ ಆಕರ ಗ್ರಂಥ:",
            options = listOf("ಶತಮಾನದ ಗಾನ", "ಪುನರ್ನವ", "ಚೇತನ", "ಕೊರಗ"),
            correctAnswer = "ಶತಮಾನದ ಗಾನ",
            explanation = "ಕಯ್ಯಾರರ 'ಶತಮಾನದ ಗಾನ' ಕವನ ಸಂಕಲನದಿಂದ ಈ ಪದ್ಯವನ್ನು ಆರಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u10_3",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಭವಿಷ್ಯತ್ ಕಾಲದ ಕಾಲಸೂಚಕ ಪ್ರತ್ಯಯ:",
            options = listOf("ವ", "ಉತ್ತ", "ದ", "ಅಲಿ"),
            correctAnswer = "ವ",
            explanation = "ಕನ್ನಡದಲ್ಲಿ ಭವಿಷ್ಯತ್ ಕಾಲವನ್ನು ಸೂಚಿಸುವ ಪ್ರತ್ಯಯ 'ವ' (ಉದಾ: ಮಾಡುವನು, ತಿನ್ನುವನು)."
        ),
        QuestionModel(
            id = "s9_kan_u10_4",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಭೂತ ಕಾಲದ ಕಾಲಸೂಚಕ ಪ್ರತ್ಯಯ:",
            options = listOf("ದ", "ಉತ್ತ", "ವ", "ಅಲಿ"),
            correctAnswer = "ದ",
            explanation = "ಭೂತಕಾಲವನ್ನು ಸೂಚಿಸುವ ಪ್ರತ್ಯಯ 'ದ' (ಉದಾ: ಮಾಡಿದನು, ತಿಂದನು)."
        ),
        QuestionModel(
            id = "s9_kan_u10_5",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ವರ್ತಮಾನ ಕಾಲದ ಕಾಲಸೂಚಕ ಪ್ರತ್ಯಯ:",
            options = listOf("ಉತ್ತ", "ದ", "ವ", "ಅಲಿ"),
            correctAnswer = "ಉತ್ತ",
            explanation = "ವರ್ತಮಾನ ಕಾಲವನ್ನು ಸೂಚಿಸುವ ಪ್ರತ್ಯಯ 'ಉತ್ತ' (ಉದಾ: ಮಾಡುತ್ತಾನೆ, ಓದುತ್ತಿದ್ದಾನೆ)."
        ),
        QuestionModel(
            id = "s9_kan_u10_6",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "'ಹೋಗು' ಧಾತುವಿನ ವರ್ತಮಾನ ಕಾಲ ರೂಪ:",
            options = listOf("ಹೋಗುತ್ತಾನೆ", "ಹೋದನು", "ಹೋಗುವನು", "ಹೋಗಬೇಕು"),
            correctAnswer = "ಹೋಗುತ್ತಾನೆ",
            explanation = "ಹೋಗು + ಉತ್ತ + ಆನೆ = ಹೋಗುತ್ತಾನೆ (ವರ್ತಮಾನ ಕಾಲ)."
        ),
        QuestionModel(
            id = "s9_kan_u10_7",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "'ಹೋಗು' ಧಾತುವಿನ ಭೂತಕಾಲ ರೂಪ:",
            options = listOf("ಹೋದನು", "ಹೋಗುತ್ತಾನೆ", "ಹೋಗುವನು", "ಹೋಗಬೇಕು"),
            correctAnswer = "ಹೋದನು",
            explanation = "ಹೋಗು + ದ + ಇನು = ಹೋದನು (ಭೂತಕಾಲ)."
        ),
        QuestionModel(
            id = "s9_kan_u10_8",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "'ಹೋಗು' ಧಾತುವಿನ ಭವಿಷ್ಯತ್ಕಾಲ ರೂಪ:",
            options = listOf("ಹೋಗುವನು", "ಹೋಗುತ್ತಾನೆ", "ಹೋದನು", "ಹೋಗಬೇಕು"),
            correctAnswer = "ಹೋಗುವನು",
            explanation = "ಹೋಗು + ವ + ಇನು = ಹೋಗುವನು (ಭವಿಷ್ಯತ್ಕಾಲ)."
        ),
        QuestionModel(
            id = "s9_kan_u10_9",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಧ್ವನಿ : ದನಿ :: ಯುಗ : __________",
            options = listOf("ಜುಗ", "ಯುಗಾದಿ", "ಕಾಲ", "ಜಗ"),
            correctAnswer = "ಜುಗ",
            explanation = "ಯುಗ ತತ್ಸಮದ ತದ್ಭವ ರೂಪ ಜುಗ."
        ),
        QuestionModel(
            id = "s9_kan_u10_10",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬಾನು : ಆಕಾಶ :: ಭಾನು : __________",
            options = listOf("ಸೂರ್ಯ", "ಚಂದ್ರ", "ನಕ್ಷತ್ರ", "ಭೂಮಿ"),
            correctAnswer = "ಸೂರ್ಯ",
            explanation = "ಭಾನು ಎಂದರೆ ಸೂರ್ಯ."
        ),
        QuestionModel(
            id = "s9_kan_u10_11",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕ್ರಾಂತಿ : ಬದಲಾವಣೆ :: ತೆರೆ : __________",
            options = listOf("ತರಂಗ / ಅಲೆ", "ಬಾಗಿಲು", "ಮುಚ್ಚಳ", "ಆವರಣ"),
            correctAnswer = "ತರಂಗ / ಅಲೆ",
            explanation = "ತೆರೆ ಎಂದರೆ ಅಲೆ ಅಥವಾ ತರಂಗ."
        ),
        QuestionModel(
            id = "s9_kan_u10_12",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ತಿನ್ನುತ್ತಾನೆ : ವರ್ತಮಾನ ಕಾಲ :: ತಿನ್ನುವನು : __________",
            options = listOf("ಭವಿಷ್ಯತ್ ಕಾಲ", "ವರ್ತಮಾನ ಕಾಲ", "ಭೂತಕಾಲ", "ನಿಷೇಧಾರ್ಥಕ"),
            correctAnswer = "ಭವಿಷ್ಯತ್ ಕಾಲ",
            explanation = "ತಿನ್ನುವನು ಎಂಬುದು ಮುಂದಿನ ಕಾಲದ ಭವಿಷ್ಯತ್ ರೂಪ."
        ),
        QuestionModel(
            id = "s9_kan_u10_13",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಹೊಸ ಹಾಡು ಪದ್ಯ ಭಾಗದ ಕರ್ತೃ ಯಾರು?",
            options = listOf("ಕಯ್ಯಾರ ಕಿಞ್ಞಣ್ಣ ರೈ", "ಕುವೆಂಪು", "ಬೇಂದ್ರೆ", "ಜಿ.ಎಸ್.ಶಿವರುದ್ರಪ್ಪ"),
            correctAnswer = "ಕಯ್ಯಾರ ಕಿಞ್ಞಣ್ಣ ರೈ",
            explanation = "ಕಾಸರಗೋಡಿನ ಕಯ್ಯಾರ ಕಿಞ್ಞಣ್ಣ ರೈ ಈ ಪ್ರಸಿದ್ಧ ಜಾಗೃತಿ ಕವನದ ಕರ್ತೃ."
        ),
        QuestionModel(
            id = "s9_kan_u10_14",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕವಿ ಎಂತಹ ಹಾಡು ಹಾಡಬೇಕೆಂದು ಬಯಸುವರು?",
            options = listOf("ನವಭಾವ ನವಜೀವ ನವಶಕ್ತಿ ತುಂಬಿಸುವ ಹಾಡು", "ಶೃಂಗಾರದ ಹಾಡು", "ಭಕ್ತಿಯ ಹಾಡು", "ಜೋಗುಳದ ಹಾಡು"),
            correctAnswer = "ನವಭಾವ ನವಜೀವ ನವಶಕ್ತಿ ತುಂಬಿಸುವ ಹಾಡು",
            explanation = "ಸಮಾಜದಲ್ಲಿ ಹೊಸ ಚೈತನ್ಯ ಮತ್ತು ಕ್ರಾಂತಿಯನ್ನು ಉಂಟುಮಾಡುವ ಹಾಡನ್ನು ಹಾಡಬೇಕೆನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u10_15",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕಡಿದೊಗೆಯ ಬೇಕಾದ ಪಾಶಗಳು ಯಾವುವು?",
            options = listOf("ಜಾತಿ ಕುಲ ಮತ ಧರ್ಮಗಳ ಸಂಕುಚಿತ ಪಾಶಗಳು", "ಸ್ನೇಹದ ಪಾಶ", "ಕರ್ತವ್ಯದ ಪಾಶ", "ರಾಜಕೀಯ ಪಾಶ"),
            correctAnswer = "ಜಾತಿ ಕುಲ ಮತ ಧರ್ಮಗಳ ಸಂಕುಚಿತ ಪಾಶಗಳು",
            explanation = "ಮನುಷ್ಯನನ್ನು ಬಂಧಿಸಿರುವ ಜಾತಿ, ಕುಲ, ಮತಗಳ ಕಟ್ಟುಪಾಡುಗಳನ್ನು ಕಡಿದು ಹಾಕಬೇಕು."
        ),
        QuestionModel(
            id = "s9_kan_u10_16",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಹಾಡು ನುಡಿಗುಂಡುಗಳು ಯಾವುದರ ಬೆನ್ನಟ್ಟಬೇಕು?",
            options = listOf("ಭಯದ ಬೆನ್ನಟ್ಟಬೇಕು", "ಶತ್ರುಗಳ ಬೆನ್ನಟ್ಟಬೇಕು", "ದುಷ್ಟರ ಬೆನ್ನಟ್ಟಬೇಕು", "ಪ್ರಾಣಿಗಳ ಬೆನ್ನಟ್ಟಬೇಕು"),
            correctAnswer = "ಭಯದ ಬೆನ್ನಟ್ಟಬೇಕು",
            explanation = "ಹಾಡಿನ ನುಡಿಗುಂಡುಗಳು ಜನರ ಮನದಲ್ಲಿರುವ ಭಯವನ್ನು ಬೆನ್ನಟ್ಟಿ ಓಡಿಸಬೇಕು."
        ),
        QuestionModel(
            id = "s9_kan_u10_17",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬಾನು ಭೂಮಿ ಯಾವುದರಿಂದ ಬೆಳಗಬೇಕು?",
            options = listOf("ಜಡನಿದ್ರೆ ಸಿಡಿದೆದ್ದ ವೀರಟ್ಟಹಾಸದಿಂದ", "ಸೂರ್ಯನ ಕಿರಣಗಳಿಂದ", "ದೀಪಗಳ ಸಾಲಿನಿಂದ", "ಚಂದ್ರನ ಬೆಳಕಿನಿಂದ"),
            correctAnswer = "ಜಡನಿದ್ರೆ ಸಿಡಿದೆದ್ದ ವೀರಟ್ಟಹಾಸದಿಂದ",
            explanation = "ಜಡತ್ವವನ್ನು ಕಳಚಿ ಸಿಡಿದೆದ್ದ ಕ್ರಾಂತಿಕಾರಿ ವೀರಟ್ಟಹಾಸದಿಂದ ಬಾನು-ಭೂಮಿ ಬೆಳಗಬೇಕು."
        ),
        QuestionModel(
            id = "s9_kan_u10_18",
            stdId = 9,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಹೊಸ ಹಾಡು ಪದ್ಯದ ಆಕರ ಗ್ರಂಥ ಯಾವುದು?",
            options = listOf("ಶತಮಾನದ ಗಾನ", "ಐಕ್ಯಗಾನ", "ಪುನರ್ನವ", "ಚೇತನ"),
            correctAnswer = "ಶತಮಾನದ ಗಾನ",
            explanation = "ಕಯ್ಯಾರ ಕಿಞ್ಞಣ್ಣ ರೈ ಅವರ 'ಶತಮಾನದ ಗಾನ' ಕೃತಿಯಿಂದ ಈ ಪದ್ಯವನ್ನು ಆಯ್ದುಕೊಳ್ಳಲಾಗಿದೆ."
        ),

        // ==========================================
        // ಘಟಕ 11: ಚಕ್ರಗ್ರಹಣ (ದೇವಿದಾಸ)
        // ==========================================
        QuestionModel(
            id = "s9_kan_u11_1",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "'ಪಾರ್ಥನಂ' ಈ ಪದದಲ್ಲಿರುವ ಹಳಗನ್ನಡ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯವಿದು:",
            options = listOf("ದ್ವಿತೀಯಾ", "ಪ್ರಥಮಾ", "ತೃತೀಯಾ", "ಪಂಚಮೀ"),
            correctAnswer = "ದ್ವಿತೀಯಾ",
            explanation = "ಹಳಗನ್ನಡದಲ್ಲಿ ದ್ವಿತೀಯಾ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ 'ಅಂ' (ಪಾರ್ಥನ್ + ಅಂ = ಪಾರ್ಥನಂ)."
        ),
        QuestionModel(
            id = "s9_kan_u11_2",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಷಷ್ಠಿ ವಿಭಕ್ತಿಯ ಕಾರಕಾರ್ಥವಿದು:",
            options = listOf("ಸಂಬಂಧ", "ಕರಣಾರ್ಥ", "ಸಂಪ್ರದಾನ", "ಅಪಾದಾನ"),
            correctAnswer = "ಸಂಬಂಧ",
            explanation = "ಷಷ್ಠಿ ವಿಭಕ್ತಿಯ ಕಾರಕಾರ್ಥ 'ಸಂಬಂಧ'."
        ),
        QuestionModel(
            id = "s9_kan_u11_3",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "'ರಥದಿಂದ' ಎಂಬುದು ಈ ವಿಭಕ್ತಿಯಲ್ಲಿದೆ:",
            options = listOf("ತೃತೀಯಾ", "ಚತುರ್ಥಿ", "ಪಂಚಮೀ", "ಸಪ್ತಮೀ"),
            correctAnswer = "ತೃತೀಯಾ",
            explanation = "ರಥ + ಇಂದ = ರಥದಿಂದ (ತೃತೀಯಾ ವಿಭಕ್ತಿ ಕರಣಾರ್ಥ)."
        ),
        QuestionModel(
            id = "s9_kan_u11_4",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಈ ಕೆಳಗಿನ ಪದಗಳಲ್ಲಿ ಆದೇಶ ಸಂಧಿಗೆ ಸೇರಿದ ಪದವಿದು:",
            options = listOf("ಕ್ರೋಧಗೊಂಡು", "ಸಾಗರೋತ್ತರ", "ಜನಾನುರಾಗಿ", "ಒಮ್ಮೊಮ್ಮೆ"),
            correctAnswer = "ಕ್ರೋಧಗೊಂಡು",
            explanation = "ಕ್ರೋಧ + ಕೊಂಡು = ಕ್ರೋಧಗೊಂಡು (ಕ-ಕಾರಕ್ಕೆ ಗ-ಕಾರ ಆದೇಶ)."
        ),
        QuestionModel(
            id = "s9_kan_u11_5",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "'ಮುರಾರಿ' ಪದ ಕೆಳಗಿನ ಈ ಸಮಾಸಕ್ಕೆ ಉದಾಹರಣೆಯಾಗಿದೆ:",
            options = listOf("ಬಹುವ್ರೀಹಿ ಸಮಾಸ", "ತತ್ಪುರುಷ", "ಕರ್ಮಧಾರಯ", "ದ್ವಿಗು"),
            correctAnswer = "ಬಹುವ್ರೀಹಿ ಸಮಾಸ",
            explanation = "ಮುರ ಎಂಬ ರಾಕ್ಷಸನ ವೈರಿ ಯಾರೋ ಅವನು ಮುರಾರಿ (ಶ್ರೀಕೃಷ್ಣ) - ಬಹುವ್ರೀಹಿ."
        ),
        QuestionModel(
            id = "s9_kan_u11_6",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕ್ರಿಯಾ ಸಮಾಸಕ್ಕೆ ಸೇರಿದ ಪದವಿದು:",
            options = listOf("ಕಂಠವನಿರಿ", "ಅರಮನೆ", "ದನುಜದಲಣ", "ಕಿರೀಟಿ"),
            correctAnswer = "ಕಂಠವನಿರಿ",
            explanation = "ಕಂಠಮಂ + ಇರಿ = ಕಂಠವನಿರಿ (ದ್ವಿತೀಯಾ ವಿಭಕ್ತಿಯೊಡನೆ ಕ್ರಿಯಾಪದ ಸೇರಿ ಕ್ರಿಯಾ ಸಮಾಸ)."
        ),
        QuestionModel(
            id = "s9_kan_u11_7",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "'ಚರಣಂದೊಡೆ' ಪದವು ಕೆಳಗಿನ ಈ ಸಂಧಿಗೆ ಉದಾಹರಣೆಯಾಗಿದೆ:",
            options = listOf("ಲೋಪ ಸಂಧಿ", "ಆಗಮ", "ಗುಣ", "ಅನುನಾಸಿಕ"),
            correctAnswer = "ಲೋಪ ಸಂಧಿ",
            explanation = "ಚರಣಂ + ತೊಡೆ = ಚರಣಂದೊಡೆ (ಸ್ವರ ಲೋಪ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s9_kan_u11_8",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "'ವಾಜಿ' ಪದದ ಅರ್ಥವಿದು:",
            options = listOf("ಕುದುರೆ (ಕಡಿವಾಣ)", "ರಥ", "ಹುಲಿ", "ಸೈನ್ಯ"),
            correctAnswer = "ಕುದುರೆ (ಕಡಿವಾಣ)",
            explanation = "ವಾಜಿ ಎಂದರೆ ವೇಗವಾಗಿ ಓಡುವ ಕುದುರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u11_9",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸ್ಯಂದನ : ರಥ :: ಅಳವ : __________",
            options = listOf("ಯುದ್ಧ / ಸಾಮರ್ಥ್ಯ", "ಆಯುಧ", "ಕುದುರೆ", "ರಥಿಕ"),
            correctAnswer = "ಯುದ್ಧ / ಸಾಮರ್ಥ್ಯ",
            explanation = "ಅಳವ ಎಂದರೆ ಯುದ್ಧ ಅಥವಾ ಸಾಮರ್ಥ್ಯ."
        ),
        QuestionModel(
            id = "s9_kan_u11_10",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಬಿಸಜ ಪೀಠ : ಬ್ರಹ್ಮ :: ಶಕ್ರ : __________",
            options = listOf("ಇಂದ್ರ", "ಯಮ", "ವರುಣ", "ಅಗ್ನಿ"),
            correctAnswer = "ಇಂದ್ರ",
            explanation = "ಶಕ್ರ ಎಂದರೆ ದೇವೇಂದ್ರ."
        ),
        QuestionModel(
            id = "s9_kan_u11_11",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಪರಿಕ್ಷಿಸು : ಪರೀಕ್ಷಿಸು :: ಹರುಷ : __________",
            options = listOf("ಹರ್ಷ", "ಹರುಸ", "ಸಂತೋಷ", "ಹರುಶ"),
            correctAnswer = "ಹರ್ಷ",
            explanation = "ಹರುಷ ತದ್ಭವದ ತತ್ಸಮ ರೂಪ ಹರ್ಷ."
        ),
        QuestionModel(
            id = "s9_kan_u11_12",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭಾಮಿನಿ : 3-4 ಮಾತ್ರೆ :: ವಾರ್ಧಕ : __________",
            options = listOf("೫ ಮಾತ್ರೆ", "೪ ಮಾತ್ರೆ", "೩ ಮಾತ್ರೆ", "೬ ಮಾತ್ರೆ"),
            correctAnswer = "೫ ಮಾತ್ರೆ",
            explanation = "ವಾರ್ಧಕ ಷಟ್ಪದಿಯಲ್ಲಿ ಪ್ರತಿ ಗಣವೂ ಐದು ಮಾತ್ರೆಗಳದ್ದಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u11_13",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಪ್ರಥಮಾ : ಕರ್ತೃರ್ಥ :: ಪಂಚಮೀ : __________",
            options = listOf("ಅಪಾದಾನ", "ಕರಣಾರ್ಥ", "ಸಂಪ್ರದಾನ", "ಅಧಿಕರಣ"),
            correctAnswer = "ಅಪಾದಾನ",
            explanation = "ಪಂಚಮೀ ವಿಭಕ್ತಿಯ ಕಾರಕಾರ್ಥ ಅಪಾದಾನ."
        ),
        QuestionModel(
            id = "s9_kan_u11_14",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಗಂಗಾಸುತ : ಭೀಷ್ಮ :: ತ್ರಿಣಯನ : __________",
            options = listOf("ಶಿವ", "ವಿಷ್ಣು", "ಬ್ರಹ್ಮ", "ಇಂದ್ರ"),
            correctAnswer = "ಶಿವ",
            explanation = "ಮೂರು ಕಣ್ಣುಳ್ಳ ತ್ರಿಣಯನನು ಶಿವ."
        ),
        QuestionModel(
            id = "s9_kan_u11_15",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಚಿತ್ರಸೇನ ಕಾಳಗ : ದೇವಿದಾಸ :: ಗದುಗಿನ ಭಾರತ : __________",
            options = listOf("ಕುಮಾರವ್ಯಾಸ", "ಪಂಪ", "ರನ್ನ", "ಜನ್ನ"),
            correctAnswer = "ಕುಮಾರವ್ಯಾಸ",
            explanation = "ಗದುಗಿನ ಭಾರತ (ಕರ್ಣಾಟ ಭಾರತ ಕಥಾಮಂಜರಿ) ಬರೆದವರು ಕುಮಾರವ್ಯಾಸ."
        ),
        QuestionModel(
            id = "s9_kan_u11_16",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಪಾರ್ಥನು ಬಾಣದಿಂದ ಯಾರಿಗೆ ವಂದಿಸಿದನು?",
            options = listOf("ಭೀಷ್ಮರಿಗೆ", "ದ್ರೋಣರಿಗೆ", "ಕರ್ಣನಿಗೆ", "ಕೃಷ್ಣನಿಗೆ"),
            correctAnswer = "ಭೀಷ್ಮರಿಗೆ",
            explanation = "ಯುದ್ಧ ಆರಂಭಕ್ಕೆ ಮುನ್ನ ಅರ್ಜುನನು ಬಾಣಗಳನ್ನು ಭೀಷ್ಮರ ಚರಣಗಳಿಗೆ ಬಿಟ್ಟು ವಂದಿಸಿದನು."
        ),
        QuestionModel(
            id = "s9_kan_u11_17",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭೀಷ್ಮರು ಎದುರಾದಾಗ ಪಾರ್ಥನು ಏನೆಂದು ಕೇಳಿದನು?",
            options = listOf("ಎಳೆಯರೊಡನೆ ಯುದ್ಧ ಮಾಡುವುದು ವಿವೇಕವೇ? ನಮ್ಮಿಬ್ಬರಲ್ಲಿ ಭೇದ ತೋರುವುದು ಸರಿಯೇ?", "ನನ್ನನ್ನು ಕೊಲ್ಲುವಿರಾ?", "ಶಸ್ತ್ರ ತ್ಯಾಗ ಮಾಡುವಿರಾ?", "ಕೌರವರನ್ನು ಬಿಟ್ಟು ಬರುವಿರಾ?"),
            correctAnswer = "ಎಳೆಯರೊಡನೆ ಯುದ್ಧ ಮಾಡುವುದು ವಿವೇಕವೇ? ನಮ್ಮಿಬ್ಬರಲ್ಲಿ ಭೇದ ತೋರುವುದು ಸರಿಯೇ?",
            explanation = "ತನ್ನ ತಾತನಾದ ಭೀಷ್ಮರಿಗೆ ವಿನಯದಿಂದ ಪಾರ್ಥನು ಧರ್ಮಯುದ್ಧದ ಸಂದಿಗ್ಧತೆಯನ್ನು ಕೇಳಿದನು."
        ),
        QuestionModel(
            id = "s9_kan_u11_18",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಪರಶುರಾಮರಿಂದ ದಿವ್ಯಾಸ್ತ್ರ (ಶರ) ಪಡೆದವರು ಯಾರು?",
            options = listOf("ಭೀಷ್ಮರು", "ಅರ್ಜುನ", "ದ್ರೋಣರು", "ದುರ್ಯೋಧನ"),
            correctAnswer = "ಭೀಷ್ಮರು",
            explanation = "ಭೀಷ್ಮರು ತಮ್ಮ ಗುರುಗಳಾದ ಭಗವಾನ್ ಪರಶುರಾಮರಿಂದ ದಿವ್ಯ ಶರಗಳನ್ನು ಪಡೆದಿದ್ದರು."
        ),
        QuestionModel(
            id = "s9_kan_u11_19",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕೃಷ್ಣನು ಚಕ್ರವನ್ನು ಹಿಡಿದಾಗ ಏನಾಯಿತು?",
            options = listOf("ಚತುರ್ದಶ ಭುವನ ತಲ್ಲಣಿಸಿತು", "ಭೂಮಿ ಮುಳುಗಿತು", "ಸೂರ್ಯ ಮರೆಯಾದನು", "ಸೈನ್ಯ ಓಡಿಹೋಯಿತು"),
            correctAnswer = "ಚತುರ್ದಶ ಭುವನ ತಲ್ಲಣಿಸಿತು",
            explanation = "ಶ್ರೀಕೃಷ್ಣನು ಸುದರ್ಶನ ಚಕ್ರವೆತ್ತಿದಾಗ ಹದಿನಾಲ್ಕು ಲೋಕಗಳೂ ಭಯದಿಂದ ತಲ್ಲಣಿಸಿದವು."
        ),
        QuestionModel(
            id = "s9_kan_u11_20",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಚಕ್ರಗ್ರಹಣ ಪದ್ಯದ ಪ್ರಮುಖ ಆಕರ ಗ್ರಂಥ ಯಾವುದು?",
            options = listOf("ಕುಮಾರವ್ಯಾಸ ಭಾರತ", "ಪಂಪಭಾರತ", "ಜೈಮಿನಿ ಭಾರತ", "ವಚನ ಭಾರತ"),
            correctAnswer = "ಕುಮಾರವ್ಯಾಸ ಭಾರತ",
            explanation = "ಕುಮಾರವ್ಯಾಸ ಭಾರತದ ಭೀಷ್ಮಪರ್ವದ ಕಥಾಸಂದರ್ಭವನ್ನಾಧರಿಸಿ ದೇವಿದಾಸರು ಈ ಯಕ್ಷಗಾನ ಪ್ರಸಂಗ ರಚಿಸಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u11_21",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಚಕ್ರಗ್ರಹಣ ಪದ್ಯ ಕುರುಕ್ಷೇತ್ರ ಯುದ್ಧದ ಎಷ್ಟನೇ ದಿನದ ವಿದ್ಯಮಾನವನ್ನು ವರ್ಣಿಸುತ್ತದೆ?",
            options = listOf("ಮೂರನೇ ದಿನದ", "ಹತ್ತನೇ ದಿನದ", "ಮೊದಲನೇ ದಿನದ", "ಹದಿನೆಂಟನೇ ದಿನದ"),
            correctAnswer = "ಮೂರನೇ ದಿನದ",
            explanation = "ಕುರುಕ್ಷೇತ್ರದ ಮೂರನೆಯ ದಿನದ ಭೀಕರ ಯುದ್ಧದಲ್ಲಿ ಈ ಪ್ರಸಂಗ ನಡೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u11_22",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕುರುಕ್ಷೇತ್ರ ಯುದ್ಧದಲ್ಲಿ ಕೃಷ್ಣನು ಏನೆಂದು ಪ್ರತಿಜ್ಞೆ ಮಾಡಿದ್ದನು?",
            options = listOf("ತಾನು ಶಸ್ತ್ರ (ಚಕ್ರ) ಹಿಡಿಯುವುದಿಲ್ಲವೆಂದು", "ಅರ್ಜುನನನ್ನು ರಕ್ಷಿಸುವುದಿಲ್ಲವೆಂದು", "ಯುದ್ಧದಲ್ಲಿ ಭಾಗವಹಿಸುವುದಿಲ್ಲವೆಂದು", "ರಥ ನಡೆಸುವುದಿಲ್ಲವೆಂದು"),
            correctAnswer = "ತಾನು ಶಸ್ತ್ರ (ಚಕ್ರ) ಹಿಡಿಯುವುದಿಲ್ಲವೆಂದು",
            explanation = "ಕೃಷ್ಣನು ತಾನು ಯುದ್ಧದಲ್ಲಿ ಯಾವುದೇ ಆಯುಧ ಹಿಡಿಯದೆ ಕೇವಲ ಸಾರಥಿಯಾಗಿರುತ್ತೇನೆ ಎಂದು ಪ್ರತಿಜ್ಞೆ ಮಾಡಿದ್ದನು."
        ),
        QuestionModel(
            id = "s9_kan_u11_23",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಅರ್ಜುನನು ಯುದ್ಧಕ್ಕೆ ಸಿದ್ಧನಾಗಿ ನಿಂತಾಗ ಕೃಷ್ಣನಿಗೆ ಏನೆಂದು ಹೇಳುತ್ತಾನೆ?",
            options = listOf("ಹಿರಿಯರೊಂದಿಗೆ ಯುದ್ಧ ಮಾಡುವ ಸಂದರ್ಭ ದೊರಕಿದೆ, ನನ್ನ ಪರಾಕ್ರಮವನ್ನು ಪರೀಕ್ಷಿಸು", "ನಾನು ಯುದ್ಧ ಮಾಡಲಾರೆ", "ಶಸ್ತ್ರ ತ್ಯಾಗ ಮಾಡುವೆ", "ಕೌರವರೊಂದಿಗೆ ಸಂಧಿ ಮಾಡು"),
            correctAnswer = "ಹಿರಿಯರೊಂದಿಗೆ ಯುದ್ಧ ಮಾಡುವ ಸಂದರ್ಭ ದೊರಕಿದೆ, ನನ್ನ ಪರಾಕ್ರಮವನ್ನು ಪರೀಕ್ಷಿಸು",
            explanation = "ಅರ್ಜುನನು ಕೃಷ್ಣನಿಗೆ ತನ್ನ ಪರಾಕ್ರಮ ಪರೀಕ್ಷಿಸಲು ಸನ್ನದ್ಧನಾಗಿರುವುದನ್ನು ತಿಳಿಸಿದನು."
        ),
        QuestionModel(
            id = "s9_kan_u11_24",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭೀಷ್ಮನು ಅರ್ಜುನನಿಗೆ ಯಾವ ಬಾಣವನ್ನು ಪ್ರಯೋಗಿಸಲು ಹೇಳುತ್ತಾರೆ?",
            options = listOf("ಶಿವನು ಕೊಟ್ಟ ಪಾಶುಪತಾಸ್ತ್ರವನ್ನು", "ಬ್ರಹ್ಮಾಸ್ತ್ರವನ್ನು", "ನಾರಾಯಣಾಸ್ತ್ರವನ್ನು", "ವಾಯವ್ಯಾಸ್ತ್ರವನ್ನು"),
            correctAnswer = "ಶಿವನು ಕೊಟ್ಟ ಪಾಶುಪತಾಸ್ತ್ರವನ್ನು",
            explanation = "ಸಾಮಾನ್ಯ ಬಾಣಗಳು ಸಾಲದು, ಶಂಕರನು ಕೊಟ್ಟ ಪಾಶುಪತಾಸ್ತ್ರವನ್ನು ಪ್ರಯೋಗಿಸು ಎಂದರು."
        ),
        QuestionModel(
            id = "s9_kan_u11_25",
            stdId = 9,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭೀಷ್ಮರು ಕೃಷ್ಣನಿಗೆ 'ಎನಗೆ ನಗೆಯು ಬಂತು' ಎಂದು ಹೇಳಲು ಕಾರಣವೇನು?",
            options = listOf("ಹುಲ್ಲು ಕಡ್ಡಿಯನ್ನು ಮುರಿಯಲು ಕೊಡಲಿ ಬೇಕೆ? ನನ್ನ ಕೊಲ್ಲಲು ಚಕ್ರ ಬೇಕೆ?", "ಕೃಷ್ಣ ರಥದಿಂದ ಇಳಿದುದನ್ನು ಕಂಡು", "ಅರ್ಜುನ ಹೆದರಿದ್ದನ್ನು ಕಂಡು", "ಕೌರವರು ಸೋಲುವುದನ್ನು ಕಂಡು"),
            correctAnswer = "ಹುಲ್ಲು ಕಡ್ಡಿಯನ್ನು ಮುರಿಯಲು ಕೊಡಲಿ ಬೇಕೆ? ನನ್ನ ಕೊಲ್ಲಲು ಚಕ್ರ ಬೇಕೆ?",
            explanation = "ಅಲ್ಪನಾದ ನನ್ನನ್ನು ಸಂಹರಿಸಲು ಪರಮಾತ್ಮನೇ ಚಕ್ರವೆತ್ತಿ ಬಂದಿರುವುದನ್ನು ಕಂಡು ಭಕ್ತಿಯಿಂದ ನಗೆ ಬಂತೆಂದರು."
        ),

        // ==========================================
        // ಘಟಕ 12: ಬಲಿಯನಿತ್ತೊಡೆ ಮುನಿವೆಂ (ಜನ್ನ)
        // ==========================================
        QuestionModel(
            id = "s9_kan_u12_1",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "'ಬಲಿಯನಿತ್ತೊಡೆ ಮುನಿವೆಂ' ಈ ಪದ್ಯದ ಛಂದಸ್ಸು:",
            options = listOf("ಕಂದ ಪದ್ಯ", "ಭಾಮಿನಿ ಷಟ್ಪದಿ", "ವಾರ್ಧಕ ಷಟ್ಪದಿ", "ರಗಳೆ"),
            correctAnswer = "ಕಂದ ಪದ್ಯ",
            explanation = "ಜನ್ನ ಕವಿಯ ಯಶೋಧರ ಚರಿತೆಯು ಕಂದ ಪದ್ಯಗಳಿಂದ ಕೂಡಿದ ಕಾವ್ಯ."
        ),
        QuestionModel(
            id = "s9_kan_u12_2",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "'ಬಲಿಯನಿತ್ತೊಡೆ ಮುನಿವೆಂ' ಈ ಪದ್ಯದ ಆಕರ ಗ್ರಂಥ:",
            options = listOf("ಯಶೋಧರ ಚರಿತೆ", "ಅನಂತನಾಥ ಪುರಾಣ", "ಅನುಭವ ಮುಕುರ", "ಅಜಿತನಾಥ ಪುರಾಣ"),
            correctAnswer = "ಯಶೋಧರ ಚರಿತೆ",
            explanation = "ಜನ್ನನ ಪ್ರಖ್ಯಾತ ಜೈನ ಕಾವ್ಯ 'ಯಶೋಧರ ಚರಿತೆ'ಯಿಂದ ಆರಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u12_3",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "'ಬಲಿಯನಿತ್ತೊಡೆ ಮುನಿವೆಂ' ಈ ಪದ್ಯವನ್ನು ಬರೆದ ಕವಿ ಯಾರು?",
            options = listOf("ಜನ್ನ", "ರನ್ನ", "ಪೊನ್ನ", "ಪಂಪ"),
            correctAnswer = "ಜನ್ನ",
            explanation = "ಹೊಯ್ಸಳರ ಆಸ್ಥಾನ ಕವಿಚಕ್ರವರ್ತಿ ಜನ್ನನು ಈ ಪದ್ಯದ ಕರ್ತೃ."
        ),
        QuestionModel(
            id = "s9_kan_u12_4",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಅಭಯರುಚಿಯ ಸಹೋದರಿಯ ಹೆಸರು ಏನು?",
            options = listOf("ಅಭಯಮತಿ", "ಚಂದ್ರಮತಿ", "ಯಶೋಧರೆ", "ಅಮೃತಮತಿ"),
            correctAnswer = "ಅಭಯಮತಿ",
            explanation = "ಅಭಯರುಚಿ ಮತ್ತು ಅಭಯಮತಿ ಅವಳಿ ಅಣ್ಣ-ತಂಗಿಯರು."
        ),
        QuestionModel(
            id = "s9_kan_u12_5",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಮಾರಿದತ್ತನ ಮಗನ ಹೆಸರೇನು?",
            options = listOf("ಕುಸುಮದತ್ತ", "ಯಶೋಧರ", "ಪುಷ್ಪದತ್ತ", "ಸೋಮದತ್ತ"),
            correctAnswer = "ಕುಸುಮದತ್ತ",
            explanation = "ಮಾರಿದತ್ತ ರಾಜನ ಮಗನ ಹೆಸರು ಕುಸುಮದತ್ತ."
        ),
        QuestionModel(
            id = "s9_kan_u12_6",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "'ಬಲಿಯನಿತ್ತೊಡೆ ಮುನಿವೆಂ' ಈ ಪದ್ಯದ ಪ್ರಮುಖ ಸಂದೇಶ ಯಾವುದು?",
            options = listOf("ಅಹಿಂಸೆ", "ಹಿಂಸೆ", "ದ್ವೇಷ", "ಮತ್ಸರ"),
            correctAnswer = "ಅಹಿಂಸೆ",
            explanation = "ಮನಸ್ಸಿನಲ್ಲೂ ಹಿಂಸೆಯನ್ನು ಚಿಂತಿಸದೆ ಸರ್ವ ಜೀವಿಗಳಿಗೂ ದಯೆ ತೋರುವ ಅಹಿಂಸಾ ತತ್ವ."
        ),
        QuestionModel(
            id = "s9_kan_u12_7",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ವ್ರಜ : ಸಮೂಹ :: ತಂಡುಲ : __________",
            options = listOf("ಅಕ್ಕಿ", "ಗೋಧಿ", "ರಾಗಿ", "ಜೇನು"),
            correctAnswer = "ಅಕ್ಕಿ",
            explanation = "ತಂಡುಲ ಎಂದರೆ ಅಕ್ಕಿ."
        ),
        QuestionModel(
            id = "s9_kan_u12_8",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿ : ಆರು ಸಾಲು :: ಕಂದಪದ್ಯ : __________",
            options = listOf("ನಾಲ್ಕು ಸಾಲು", "ಮೂರು ಸಾಲು", "ಎರಡು ಸಾಲು", "ಎಂಟು ಸಾಲು"),
            correctAnswer = "ನಾಲ್ಕು ಸಾಲು",
            explanation = "ಕಂದಪದ್ಯದಲ್ಲಿ ನಾಲ್ಕು ಸಾಲುಗಳಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u12_9",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಯಶೋಧರ : ಅಮೃತಮತಿ :: ಯಶೋಮತಿ : __________",
            options = listOf("ಕುಸುಮಾವಳಿ", "ಚಂದ್ರಮತಿ", "ಗುಣವತಿ", "ಸಾವಿತ್ರಿ"),
            correctAnswer = "ಕುಸುಮಾವಳಿ",
            explanation = "ಯಶೋಮತಿಯ ಪತ್ನಿ ಕುಸುಮಾವಳಿ."
        ),
        QuestionModel(
            id = "s9_kan_u12_10",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ನೃಪೇಂದ್ರ : ಗುಣಸಂಧಿ :: ಪ್ರಜೆಯಲ್ಲಂ : __________",
            options = listOf("ಆಗಮ ಸಂಧಿ", "ಆದೇಶ ಸಂಧಿ", "ಲೋಪ ಸಂಧಿ", "ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ"),
            correctAnswer = "ಆಗಮ ಸಂಧಿ",
            explanation = "ಪ್ರಜೆ + ಯ್ + ಅಲ್ಲಂ = ಪ್ರಜೆಯಲ್ಲಂ (ಆಗಮ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s9_kan_u12_11",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಕಂದ ಪದ್ಯ : ಮಾತ್ರಾಗಣ :: ರಳ, ಕುಳ, ಕ್ಷಳ : __________",
            options = listOf("ಶಿಥಿಲದ್ವಿತ್ವ (ವರ್ಣಗಳು)", "ಸಂಯುಕ್ತಾಕ್ಷರ", "ಸ್ವರಗಳು", "ಮಹಾಪ್ರಾಣಗಳು"),
            correctAnswer = "ಶಿಥಿಲದ್ವಿತ್ವ (ವರ್ಣಗಳು)",
            explanation = "ಪ್ರಾಚೀನ ಕನ್ನಡದ ರಳ, ಕುಳ, ಕ್ಷಳಗಳು ಪ್ರಾಸದಲ್ಲಿ ಶಿಥಿಲದ್ವಿತ್ವ ಹೊಂದುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u12_12",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಲೋಚನ : ಕಣ್ಣು :: ವಿಭು : __________",
            options = listOf("ದೊರೆ / ರಾಜ", "ಮಂತ್ರಿ", "ಸೇವಕ", "ಗುರು"),
            correctAnswer = "ದೊರೆ / ರಾಜ",
            explanation = "ವಿಭು ಎಂದರೆ ಪ್ರಭು ಅಥವಾ ದೊರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u12_13",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಭಾಮಿನಿ ಷಟ್ಪದಿ : ೩/೪/೩/೪ :: ಕಂದ ಪದ್ಯ : __________",
            options = listOf("೪/೪/೪", "೩/೩/೩", "೫/೫/೫", "೩/೪/೫"),
            correctAnswer = "೪/೪/೪",
            explanation = "ಕಂದ ಪದ್ಯದ ಗಣಗಳು ನಾಲ್ಕು ಮಾತ್ರೆಗಳ ಗಣಗಳಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u12_14",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "'ಬಲಿಯನಿತ್ತೊಡೆ ಮುನಿವೆಂ' ಈ ಪದ್ಯದಲ್ಲಿ ಭಿಕ್ಷೆ ಬೇಡಲು ಬಂದ ಮಕ್ಕಳ ಹೆಸರೇನು?",
            options = listOf("ಅಭಯರುಚಿ ಮತ್ತು ಅಭಯಮತಿ", "ಲವ ಮತ್ತು ಕುಶ", "ಧರ್ಮ ಮತ್ತು ಶಾಂತಿ", "ರಾಮ ಮತ್ತು ಲಕ್ಷ್ಮಣ"),
            correctAnswer = "ಅಭಯರುಚಿ ಮತ್ತು ಅಭಯಮತಿ",
            explanation = "ಸುದತ್ತಾಚಾರ್ಯರ ಶಿಷ್ಯರಾದ ಬಾಲ ಸನ್ಯಾಸಿಗಳು ಅಭಯರುಚಿ ಮತ್ತು ಅಭಯಮತಿ."
        ),
        QuestionModel(
            id = "s9_kan_u12_15",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಅಭಯಮತಿ ಮತ್ತು ಅಭಯರುಚಿಯನ್ನು ಯಾವಾಗ ಸೆರೆ ಹಿಡಿಯಲಾಯಿತು?",
            options = listOf("ಭಿಕ್ಷೆ ಬೇಡಲು ಬಂದಾಗ", "ಆಟವಾಡುತ್ತಿದ್ದಾಗ", "ನದಿಯಲ್ಲಿ ಸ್ನಾನ ಮಾಡುವಾಗ", "ಮಲಗಿದ್ದಾಗ"),
            correctAnswer = "ಭಿಕ್ಷೆ ಬೇಡಲು ಬಂದಾಗ",
            explanation = "ಮಾರಿದತ್ತನ ತಳವಾರ ಚಂಡಕರ್ಮನು ಅವರನ್ನು ಭಿಕ್ಷಾಟನೆಗೆ ಬಂದಾಗ ನರಬಲಿಗಾಗಿ ಸೆರೆಹಿಡಿದನು."
        ),
        QuestionModel(
            id = "s9_kan_u12_16",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಅಭಯಮತಿ ಮತ್ತು ಅಭಯರುಚಿಯ ಸೋದರಮಾವನ ಹೆಸರೇನು?",
            options = listOf("ಮಾರಿದತ್ತ", "ಚಂಡಕರ್ಮ", "ಸುದತ್ತಾಚಾರ್ಯ", "ಕುಸುಮದತ್ತ"),
            correctAnswer = "ಮಾರಿದತ್ತ",
            explanation = "ಅವರ ತಾಯಿ ಕೌಸುಂಬಿಯ ಸೋದರನೇ ರಾಜಪುರದ ದೊರೆ ಮಾರಿದತ್ತ."
        ),
        QuestionModel(
            id = "s9_kan_u12_17",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಅಭಯರುಚಿಯು ಮಾರಿದತ್ತನ ಪಾಪಗಳಿಗೆ ಎಲ್ಲಿ ಪರಿಹಾರ ಸಿಗುತ್ತದೆ ಎಂದು ಹೇಳಿದನು?",
            options = listOf("ನರಕದಲ್ಲಿ", "ಕಾಶಿಯಲ್ಲಿ", "ಗಂಗಾ ಸ್ನಾನದಲ್ಲಿ", "ತಪಸ್ಸಿನಲ್ಲಿ"),
            correctAnswer = "ನರಕದಲ್ಲಿ",
            explanation = "ನೀನು ಮಾಡುತ್ತಿರುವ ಘೋರ ಪ್ರಾಣಿಹಿಂಸೆಯ ಪಾಪಕ್ಕೆ ನರಕಯಾತನೆಯಲ್ಲೇ ಪರಿಹಾರ ದೊರೆಯುವುದು ಎಂದನು."
        ),
        QuestionModel(
            id = "s9_kan_u12_18",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಚಂಡಮಾರಿಯು ಪ್ರತ್ಯಕ್ಷಳಾಗಿ ಅಭಯರುಚಿಗೆ ಏನೆಂದು ಸಂಬೋಧಿಸಿದಳು?",
            options = listOf("ನೀನು ಆಚಾರ್ಯನು", "ನೀನು ರಾಜನು", "ನೀನು ಬಾಲಕನು", "ನೀನು ಶತ್ರುವು"),
            correctAnswer = "ನೀನು ಆಚಾರ್ಯನು",
            explanation = "ಚಂಡಮಾರಿ ಪ್ರತ್ಯಕ್ಷಳಾಗಿ 'ನೀನು ಆಚಾರ್ಯನು, ನನಗೆ ಧರ್ಮಬೋಧನೆ ಮಾಡಿದ ಗುರು' ಎಂದಳು."
        ),
        QuestionModel(
            id = "s9_kan_u12_19",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಚಂಡಮಾರಿಯು ಜನರಿಗೆ ನಾನು ಯಾವಾಗ ಕೋಪಗೊಳ್ಳುತ್ತೇನೆ ಎಂದು ಹೇಳುತ್ತಾಳೆ?",
            options = listOf("ಜೀವಬಲಿಯನ್ನು ಕೊಟ್ಟಾಗ", "ಹೂವು ಹಣ್ಣು ತರದಿದ್ದಾಗ", "ಪೂಜೆ ಮಾಡದಿದ್ದಾಗ", "ಪ್ರಾರ್ಥಿಸದಿದ್ದಾಗ"),
            correctAnswer = "ಜೀವಬಲಿಯನ್ನು ಕೊಟ್ಟಾಗ",
            explanation = "'ಬಲಿಯನಿತ್ತೊಡೆ ಮುನಿವೆಂ' - ನನಗೆ ಪ್ರಾಣಿಬಲಿ ಕೊಟ್ಟರೆ ನಾನು ಅತ್ಯಂತ ಕೋಪಗೊಳ್ಳುತ್ತೇನೆ ಎಂದಳು."
        ),
        QuestionModel(
            id = "s9_kan_u12_20",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಚಂಡಮಾರಿಯು ಜನಸಮೂಹಕ್ಕೆ ನನ್ನನ್ನು ಯಾವುದರಿಂದ ಪೂಜಿಸಬೇಕೆಂದು ಹೇಳುತ್ತಾಳೆ?",
            options = listOf("ಹೂಮಾಲೆ, ಅಕ್ಷತೆ, ಧೂಪ, ದೀಪ, ಹವಿಸ್ಸು, ತಾಂಬೂಲಗಳಿಂದ", "ಪ್ರಾಣಿ ಬಲಿಯಿಂದ", "ಚಿನ್ನಾಭರಣಗಳಿಂದ", "ಮದ್ಯ ಮಾಂಸಗಳಿಂದ"),
            correctAnswer = "ಹೂಮಾಲೆ, ಅಕ್ಷತೆ, ಧೂಪ, ದೀಪ, ಹವಿಸ್ಸು, ತಾಂಬೂಲಗಳಿಂದ",
            explanation = "ಸಾತ್ವಿಕ ಪೂಜಾ ದ್ರವ್ಯಗಳಾದ ಹೂವು, ಗಂಧ, ಅಕ್ಷತೆ, ಧೂಪ, ದೀಪಗಳಿಂದ ಪೂಜಿಸಬೇಕೆಂದಳು."
        ),
        QuestionModel(
            id = "s9_kan_u12_21",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಮಾರಿದತ್ತನು ತನ್ನ ತಂಗಿಯ ಮಕ್ಕಳನ್ನು ಹೇಗೆ ಲಾಲಿಸಿದನು?",
            options = listOf("ಆನಂದದಿಂದ ಬಲಿಪ್ರಾಣಿಗಳನ್ನು ಬಿಡಿಸಿ ಮಕ್ಕಳನ್ನು ಲಾಲಿಸಿದನು", "ಕೋಪದಿಂದ", "ಉಡುಗೊರೆ ಕೊಟ್ಟು ಕಳುಹಿಸಿದನು", "ಉಪದೇಶ ನೀಡಿದನು"),
            correctAnswer = "ಆನಂದದಿಂದ ಬಲಿಪ್ರಾಣಿಗಳನ್ನು ಬಿಡಿಸಿ ಮಕ್ಕಳನ್ನು ಲಾಲಿಸಿದನು",
            explanation = "ಕಣ್ಣೀರು ಸುರಿಸುತ್ತಾ ಬಲಿಗಾಗಿ ತಂದಿದ್ದ ಪ್ರಾಣಿಗಳನ್ನು ಮುಕ್ತಗೊಳಿಸಿ ಮಕ್ಕಳನ್ನು ಅಪ್ಪಿಕೊಂಡನು."
        ),
        QuestionModel(
            id = "s9_kan_u12_22",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಮಾರಿದತ್ತನು ಯಾವುದಕ್ಕೆ ಭಯಪಟ್ಟು ದೀಕ್ಷೆ ಕೈಗೊಂಡನು?",
            options = listOf("ತಾನು ಮಾಡಿರುವ ಪಾಪಕೃತ್ಯಗಳಿಗೆ (ನರಕದ ಭಯಕ್ಕೆ)", "ಶತ್ರುಗಳ ದಾಳಿಗೆ", "ರೋಗಕ್ಕೆ", "ಬಡತನಕ್ಕೆ"),
            correctAnswer = "ತಾನು ಮಾಡಿರುವ ಪಾಪಕೃತ್ಯಗಳಿಗೆ (ನರಕದ ಭಯಕ್ಕೆ)",
            explanation = "ತಾನು ಮಾಡಿದ ಹಿಂಸಾತ್ಮಕ ಪಾಪಕೃತ್ಯಗಳ ಪರಿಣಾಮಕ್ಕೆ ಬೆದರಿ ಜೈನ ಸನ್ಯಾಸ ದೀಕ್ಷೆ ವಹಿಸಿದನು."
        ),
        QuestionModel(
            id = "s9_kan_u12_23",
            stdId = 9,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಮಾರಿದತ್ತನಿಗೆ ತಪದ ಫಲವಾಗಿ ಎಷ್ಟನೇ ಸ್ವರ್ಗ ಪ್ರಾಪ್ತಿಯಾಯಿತು?",
            options = listOf("ಮೂರನೆಯ ಸ್ವರ್ಗ", "ಮೊದಲನೆಯ ಸ್ವರ್ಗ", "ಐದನೆಯ ಸ್ವರ್ಗ", "ಏಳನೆಯ ಸ್ವರ್ಗ"),
            correctAnswer = "ಮೂರನೆಯ ಸ್ವರ್ಗ",
            explanation = "ಉಗ್ರ ತಪಸ್ಸಿನ ನಂತರ ಮಾರಿದತ್ತನು ಮೂರನೆಯ ಸ್ವರ್ಗವನ್ನು ಪಡೆದನು."
        ),

        // ==========================================
        // ಘಟಕ 13: ಹೇಮಂತ (ಎಸ್. ವಿ. ಪರಮೇಶ್ವರ ಭಟ್ಟ)
        // ==========================================
        QuestionModel(
            id = "s9_kan_u13_1",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಸಿಂಗರ : ಸಿಂಗಾರ :: ಮರುತ : __________",
            options = listOf("ಮಾರುತ", "ಮೃತ್ಯು", "ಮರಳು", "ಮಳೆಯ"),
            correctAnswer = "ಮಾರುತ",
            explanation = "ಮರುತ ತದ್ಭವದ ತತ್ಸಮ ರೂಪ ಮಾರುತ (ಗಾಳಿ)."
        ),
        QuestionModel(
            id = "s9_kan_u13_2",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಮೌನ : ಮಾತು :: ಜಡ : __________",
            options = listOf("ಚೇತನ", "ಕಲ್ಲು", "ಸುಮ್ಮನೆ", "ಶಕ್ತಿ"),
            correctAnswer = "ಚೇತನ",
            explanation = "ಜಡ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಚೇತನ."
        ),
        QuestionModel(
            id = "s9_kan_u13_3",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಬನ : ವನ :: ಮೊಗ : __________",
            options = listOf("ಮುಖ", "ಮೂಗು", "ಮಣ್ಣು", "ಮೊಸರು"),
            correctAnswer = "ಮುಖ",
            explanation = "ಮೊಗ ತದ್ಭವದ ತತ್ಸಮ ರೂಪ ಮುಖ."
        ),
        QuestionModel(
            id = "s9_kan_u13_4",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಚಿಗುರೆಲೆ : ಲೋಪ ಸಂಧಿ :: ತಲೆವಾಗು : __________",
            options = listOf("ಆದೇಶ ಸಂಧಿ", "ಆಗಮ ಸಂಧಿ", "ಲೋಪ ಸಂಧಿ", "ಗುಣ ಸಂಧಿ"),
            correctAnswer = "ಆದೇಶ ಸಂಧಿ",
            explanation = "ತಲೆ + ಬಾಗು = ತಲೆವಾಗು (ಬ-ಕಾರಕ್ಕೆ ವ-ಕಾರ ಆದೇಶ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s9_kan_u13_5",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಸುಯ್ಯನೆ : ಅನುಕರಣಾವ್ಯಯ :: ಬೇಗನೆ : __________",
            options = listOf("ಸಾಮಾನ್ಯಾರ್ಥಕ ಅವ್ಯಯ", "ಅನುಕರಣಾವ್ಯಯ", "ಕ್ರಿಯಾರ್ಥಕಾವ್ಯಯ", "ಭಾವಾರ್ಥಕಾವ್ಯಯ"),
            correctAnswer = "ಸಾಮಾನ್ಯಾರ್ಥಕ ಅವ್ಯಯ",
            explanation = "ಬೇಗನೆ ಎಂಬುದು ಸಾಮಾನ್ಯಾರ್ಥಕ ಅವ್ಯಯ."
        ),
        QuestionModel(
            id = "s9_kan_u13_6",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಗಂಧ : ಪರಿಮಳ :: ಜವನಿಕೆ : __________",
            options = listOf("ಮುಖ ಪರದೆ (ತೆರೆ / ಹೊದಿಕೆ)", "ಜೇನು", "ಗಾಳಿ", "ಬಟ್ಟೆ"),
            correctAnswer = "ಮುಖ ಪರದೆ (ತೆರೆ / ಹೊದಿಕೆ)",
            explanation = "ಜವನಿಕೆ ಎಂದರೆ ಪರದೆ ಅಥವಾ ಮುಸುಕು."
        ),
        QuestionModel(
            id = "s9_kan_u13_7",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ವರೂಥ : ತೇರು :: ಮರುತ : __________",
            options = listOf("ಗಾಳಿ", "ಮೋಡ", "ಮಳೆ", "ಮಿಂಚು"),
            correctAnswer = "ಗಾಳಿ",
            explanation = "ಮರುತ ಎಂದರೆ ಗಾಳಿ."
        ),
        QuestionModel(
            id = "s9_kan_u13_8",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ನಳನಳಿಸು : ದ್ವಿರುಕ್ತಿ :: ಕೆನೆ ಮೊಸರು : __________",
            options = listOf("ಜೋಡುನುಡಿ", "ದ್ವಿರುಕ್ತಿ", "ಅನುಕರಣಾವ್ಯಯ", "ನುಡಿಗಟ್ಟು"),
            correctAnswer = "ಜೋಡುನುಡಿ",
            explanation = "ಕೆನೆ ಮೊಸರು ಜೋಡುನುಡಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u13_9",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಹೇಮಂತ ರಾಜನು ಇಳೆಗೆ ಬಂದಾಗ ಮರಗಳು ಹೇಗಿರುತ್ತವೆ?",
            options = listOf("ಎಲೆಗಳನ್ನು ಉದುರಿಸಿ ಬೋಳಾಗಿ ನಿಲ್ಲುತ್ತವೆ", "ಹಸಿರಾಗಿ ನಳನಳಿಸುತ್ತವೆ", "ಹೂಗಳಿಂದ ತುಂಬಿರುತ್ತವೆ", "ಫಲಗಳಿಂದ ಬಾಗಿರುತ್ತವೆ"),
            correctAnswer = "ಎಲೆಗಳನ್ನು ಉದುರಿಸಿ ಬೋಳಾಗಿ ನಿಲ್ಲುತ್ತವೆ",
            explanation = "ಚಳಿಗಾಲದ ಹೇಮಂತದಲ್ಲಿ ಮರಗಳು ತಮ್ಮ ಹಣ್ಣೆಲೆಗಳನ್ನು ಉದುರಿಸಿ ಬೋಳಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u13_10",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಮಂಜು ಮುಸುಕನು ಹೊದ್ದು ಮಲಗಿರುವವರು ಯಾರು?",
            options = listOf("ಹೊಲ ಗದ್ದೆಗಳು", "ಕಾಡಿನ ಪ್ರಾಣಿಗಳು", "ಹಳ್ಳಿಯ ಜನರು", "ಪಕ್ಷಿಗಳು"),
            correctAnswer = "ಹೊಲ ಗದ್ದೆಗಳು",
            explanation = "ಬೆಳಗಿನ ಮಂಜನ್ನು ಮುಖಪರದೆಯಂತೆ ಹೊದ್ದು ಹೊಲಗದ್ದೆಗಳು ಮಲಗಿವೆ ಎಂದು ಕವಿ ವರ್ಣಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u13_11",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಕಾನನದ ಹಕ್ಕಿ ಏನು ಮಾಡುತ್ತಿದೆ?",
            options = listOf("ಕಣ್ಣೀರು ಸುರಿಸುತ್ತಿದೆ", "ಸಂತೋಷದಿಂದ ಹಾಡುತ್ತಿದೆ", "ಗೂಡು ಕಟ್ಟುತ್ತಿದೆ", "ಹಾರಾಡುತ್ತಿದೆ"),
            correctAnswer = "ಕಣ್ಣೀರು ಸುರಿಸುತ್ತಿದೆ",
            explanation = "ಚಳಿಯ ತೀವ್ರತೆಗೆ ಹೂ-ಎಲೆಗಳು ಇಲ್ಲದ ಮರಗಳ ಮೇಲೆ ಕುಳಿತು ಕಾನನದ ಹಕ್ಕಿ ಕಣ್ಣೀರು ಸುರಿಸುತ್ತಿದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u13_12",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಹೇಮಂತದಲ್ಲಿ ಎಲ್ಲೆಡೆ ಕಾಣುತ್ತಿರುವ ದೃಶ್ಯ ಯಾವುದು?",
            options = listOf("ಚಳಿ, ಹಿಮ, ಮಂಜು, ಜಡತ್ವ ಹಾಗೂ ನೀರಸ ವಾತಾವರಣ", "ಸುಂದರ ಹೂಗಳು", "ಹಸಿರು ಕಾನನ", "ಬಿಸಿಲ ತಾಪ"),
            correctAnswer = "ಚಳಿ, ಹಿಮ, ಮಂಜು, ಜಡತ್ವ ಹಾಗೂ ನೀರಸ ವಾತಾವರಣ",
            explanation = "ಪ್ರಕೃತಿಯು ಮೈಮುದುರಿಕೊಂಡು ಮೌನ ಹಾಗೂ ಜಡತ್ವವನ್ನು ಆವರಿಸಿಕೊಂಡಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u13_13",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಹೇಮಂತ ಋತುವಿನಲ್ಲಿ ತುಂಗಾ ತೊರೆ ಹೇಗೆ ಹರಿಯುತ್ತದೆ?",
            options = listOf("ಹಿಮದಿಂದ ಮೈನೆನೆದು ನಡುಗುತ್ತಾ ನಿಧಾನವಾಗಿ", "ರಭಸವಾಗಿ ಹರಿಯುತ್ತದೆ", "ಬತ್ತಿಹೋಗುತ್ತದೆ", "ಪ್ರವಾಹ ಬರುತ್ತದೆ"),
            correctAnswer = "ಹಿಮದಿಂದ ಮೈನೆನೆದು ನಡುಗುತ್ತಾ ನಿಧಾನವಾಗಿ",
            explanation = "ತುಂಗೆಯು ಹಿಮದಿಂದ ತಣ್ಣಗಾಗಿ ಮೈನೆನೆದು ನಡುಗುತ್ತಾ ನಿಧಾನವಾಗಿ ಸಾಗುತ್ತಿದ್ದಾಳೆ."
        ),
        QuestionModel(
            id = "s9_kan_u13_14",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಯಾವುದಕ್ಕೆ ತಲೆಬಾಗಬೇಕೆಂದು ಕವಿ ಹೇಳುತ್ತಾರೆ?",
            options = listOf("ಹೇಮಂತನಾಳಿಕೆಯ ಕಠಿಣ ಶಾಸನಕ್ಕೆ (ಸೃಷ್ಟಿಯ ನಿಯಮಕ್ಕೆ)", "ರಾಜನಿಗೆ", "ಪ್ರಕೃತಿ ವಿಕೋಪಕ್ಕೆ", "ಶತ್ರುಗಳಿಗೆ"),
            correctAnswer = "ಹೇಮಂತನಾಳಿಕೆಯ ಕಠಿಣ ಶಾಸನಕ್ಕೆ (ಸೃಷ್ಟಿಯ ನಿಯಮಕ್ಕೆ)",
            explanation = "ಸೃಷ್ಟಿಯ ನಿಯಮವಾದ ಹೇಮಂತದ ಕಠಿಣ ನಿಯಮಕ್ಕೆ ಎಲ್ಲರೂ ತಲೆಬಾಗಲೇಬೇಕು."
        ),
        QuestionModel(
            id = "s9_kan_u13_15",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಜೀವಿಗಳ ಧರ್ಮ ಯಾವುದು?",
            options = listOf("ಕಾಲಕ್ಕನುಗುಣವಾಗಿ ಸಂಸ್ಕಾರ ಪಡೆಯುವುದು", "ಸುಖವಾಗಿರುವುದು ಮಾತ್ರ", "ಸದಾ ನಿದ್ರಿಸುವುದು", "ಆಹಾರ ಸಂಗ್ರಹಿಸುವುದು"),
            correctAnswer = "ಕಾಲಕ್ಕನುಗುಣವಾಗಿ ಸಂಸ್ಕಾರ ಪಡೆಯುವುದು",
            explanation = "ಪ್ರತಿಯೊಂದು ಋತುವಿನಲ್ಲೂ ಸೂಕ್ತ ಬದಲಾವಣೆ ಹೊಂದಿ ಸಂಸ್ಕಾರ ಪಡೆಯುವುದೇ ಜೀವಧರ್ಮ."
        ),
        QuestionModel(
            id = "s9_kan_u13_16",
            stdId = 9,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಭಾರತೀಯ ಪದ್ಧತಿಯ ಆರು ಋತುಗಳು ಯಾವುವು?",
            options = listOf("ವಸಂತ, ಗ್ರೀಷ್ಮ, ವರ್ಷ, ಶರದ್, ಹೇಮಂತ, ಶಿಶಿರ", "ಚೈತ್ರ, ವೈಶಾಖ, ಜ್ಯೇಷ್ಠ, ಆಷಾಢ, ಶ್ರಾವಣ, ಭಾದ್ರಪದ", "ಪೂರ್ವ, ಪಶ್ಚಿಮ, ಉತ್ತರ, ದಕ್ಷಿಣ, ಈಶಾನ್ಯ, ನೈರುತ್ಯ", "ಪ್ರಾತಃಕಾಲ, ಮಧ್ಯಾಹ್ನ, ಸಾಯಂಕಾಲ, ರಾತ್ರಿ, ನಸುಕು, ಸಂಜೆ"),
            correctAnswer = "ವಸಂತ, ಗ್ರೀಷ್ಮ, ವರ್ಷ, ಶರದ್, ಹೇಮಂತ, ಶಿಶಿರ",
            explanation = "ಭಾರತೀಯ ಪದ್ಧತಿಯ ಷಡೃತುಗಳಿವು."
        ),

        // ==========================================
        // ಘಟಕ 14: ತತ್ವಪದಗಳು (ಕಡಕೋಳ ಮಡಿವಾಳಪ್ಪ & ಸಂತ ಶಿಶುನಾಳ ಶರೀಫರು)
        // ==========================================
        QuestionModel(
            id = "s9_kan_u14_1",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ಅಶನ' ಪದದ ಅರ್ಥ:",
            options = listOf("ಅನ್ನ / ಆಹಾರ", "ಆಸೆ", "ಬಟ್ಟೆ", "ನೀರು"),
            correctAnswer = "ಅನ್ನ / ಆಹಾರ",
            explanation = "ಅಶನ ಎಂದರೆ ಆಹಾರ ಅಥವಾ ಅನ್ನ."
        ),
        QuestionModel(
            id = "s9_kan_u14_2",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ಬೆತ್ತ' ಪದದ ತತ್ಸಮ ರೂಪ:",
            options = listOf("ವೇತ್ರ", "ವೆತ್ತ", "ಬೆತ್ರ", "ಪೆತ್ತ"),
            correctAnswer = "ವೇತ್ರ",
            explanation = "ವೇತ್ರ ತತ್ಸಮದ ತದ್ಭವ ರೂಪ ಬೆತ್ತ."
        ),
        QuestionModel(
            id = "s9_kan_u14_3",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ಕರುಣೆ' ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ:",
            options = listOf("ನಿಷ್ಕರುಣೆ", "ಅನುಕರಣೆ", "ನಿಕರುಣೆ", "ಅಪಕರುಣೆ"),
            correctAnswer = "ನಿಷ್ಕರುಣೆ",
            explanation = "ಕರುಣೆ ಪದದ ಸರಿಯಾದ ವಿರುದ್ಧ ಪದ ನಿಷ್ಕರುಣೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_4",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ಅಂಬಿಗ' ಎಂದರೆ ಯಾರು?",
            options = listOf("ದೋಣಿ ನಡೆಸುವವ", "ರೈತ", "ಗಾಡಿ ಹೊಡೆಯುವವ", "ಗುರು"),
            correctAnswer = "ದೋಣಿ ನಡೆಸುವವ",
            explanation = "ದೋಣಿ ಅಥವಾ ಹಡಗು ನಡೆಸುವವನನ್ನು ಅಂಬಿಗ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_5",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ಅಕ್ಕ-ತಂಗಿ' ಪದವು ಈ ವ್ಯಾಕರಣಾಂಶಕ್ಕೆ ಉದಾಹರಣೆಯಾಗಿದೆ:",
            options = listOf("ಜೋಡುನುಡಿ", "ದ್ವಿರುಕ್ತಿ", "ಅನುಕರಣಾವ್ಯಯ", "ನುಡಿಗಟ್ಟು"),
            correctAnswer = "ಜೋಡುನುಡಿ",
            explanation = "ಅಕ್ಕ-ತಂಗಿ ಸಮಾನಾರ್ಥಕ ಜೋಡುನುಡಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_6",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ನಿತ್ಯ ಕಾಲದಲ್ಲಿ' ಪದದಲ್ಲಿರುವ ವಿಭಕ್ತಿಯ ಹೆಸರು:",
            options = listOf("ಸಪ್ತಮೀ ವಿಭಕ್ತಿ", "ಚತುರ್ಥಿ", "ಪಂಚಮೀ", "ಷಷ್ಠಿ"),
            correctAnswer = "ಸಪ್ತಮೀ ವಿಭಕ್ತಿ",
            explanation = "'ಅಲ್ಲಿ' ಪ್ರತ್ಯಯವಿರುವುದರಿಂದ ಸಪ್ತಮೀ ವಿಭಕ್ತಿ."
        ),
        QuestionModel(
            id = "s9_kan_u14_7",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ಮಹಾತ್ಮ' ಪದದಲ್ಲಿ ಅಡಗಿರುವ ಸಂಧಿ:",
            options = listOf("ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ", "ಗುಣ ಸಂಧಿ", "ವೃದ್ಧಿ ಸಂಧಿ", "ಲೋಪ ಸಂಧಿ"),
            correctAnswer = "ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ",
            explanation = "ಮಹಾ + ಆತ್ಮ = ಮಹಾತ್ಮ (ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s9_kan_u14_8",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ನಾನಾದೆ, ತಾನಾದೆ, ಕೋಲಾದೆ, ಈ ಪದಗಳು ಈ ಸಂಧಿಗೆ ಉದಾಹರಣೆಯಾಗಿದೆ:",
            options = listOf("ಲೋಪ ಸಂಧಿ", "ಆಗಮ ಸಂಧಿ", "ಆದೇಶ ಸಂಧಿ", "ಗುಣ ಸಂಧಿ"),
            correctAnswer = "ಲೋಪ ಸಂಧಿ",
            explanation = "ನಾನು + ಆದೆ = ನಾನಾದೆ (ಉ-ಕಾರ ಲೋಪ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s9_kan_u14_9",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ನೆರಳಿಗೆ' ಈ ಪದದಲ್ಲಿ ಬಂದಿರುವ ವಿಭಕ್ತಿ:",
            options = listOf("ಚತುರ್ಥೀ ವಿಭಕ್ತಿ", "ಪ್ರಥಮಾ", "ತೃತೀಯಾ", "ಷಷ್ಠಿ"),
            correctAnswer = "ಚತುರ್ಥೀ ವಿಭಕ್ತಿ",
            explanation = "'ಗೆ' ಪ್ರತ್ಯಯವಿರುವ ಚತುರ್ಥೀ ವಿಭಕ್ತಿ."
        ),
        QuestionModel(
            id = "s9_kan_u14_10",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ಬಿದಿರಿನ' ಈ ಪದದಲ್ಲಿರುವ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ:",
            options = listOf("ಅ (ಷಷ್ಠಿ)", "ಅನ್ನು", "ಅಲ್ಲಿ", "ಇ"),
            correctAnswer = "ಅ (ಷಷ್ಠಿ)",
            explanation = "ಬಿದಿರು + ಇನ್ + ಅ = ಬಿದಿರಿನ (ಷಷ್ಠಿ ವಿಭಕ್ತಿ 'ಅ' ಪ್ರತ್ಯಯ)."
        ),
        QuestionModel(
            id = "s9_kan_u14_11",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ಜನ್ಮ' ಪದದ ತದ್ಭವ ರೂಪ:",
            options = listOf("ಜನುಮ", "ಜನ್ಮ", "ಜನ", "ರನ್ನ"),
            correctAnswer = "ಜನುಮ",
            explanation = "ಜನ್ಮ ತತ್ಸಮದ ತದ್ಭವ ಜನುಮ."
        ),
        QuestionModel(
            id = "s9_kan_u14_12",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "'ನಿತ್ಯ' ಪದದ ತದ್ಭವ ರೂಪ:",
            options = listOf("ನಿಚ್ಚ", "ಪ್ರತಿದಿನ", "ಕರ್ಮ", "ನಿಜ"),
            correctAnswer = "ನಿಚ್ಚ",
            explanation = "ನಿತ್ಯ ತತ್ಸಮದ ತದ್ಭವ ರೂಪ ನಿಚ್ಚ."
        ),
        QuestionModel(
            id = "s9_kan_u14_13",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಹಿರಿದು : ಕಿರಿದು :: ಹಿರಿದು : __________",
            options = listOf("ಕಿರಿದು", "ದೊಡ್ಡದು", "ಚಿಕ್ಕದು", "ಅಗಲ"),
            correctAnswer = "ಕಿರಿದು",
            explanation = "ಹಿರಿದು ಪದದ ವಿರುದ್ಧ ರೂಪ ಕಿರಿದು."
        ),
        QuestionModel(
            id = "s9_kan_u14_14",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಮಾತಿಲ್ಲದವನ : ಲೋಪ ಸಂಧಿ :: ಕರುಣವಿಲ್ಲದವನ : __________",
            options = listOf("ಆಗಮ ಸಂಧಿ", "ಲೋಪ ಸಂಧಿ", "ಆದೇಶ ಸಂಧಿ", "ಗುಣ ಸಂಧಿ"),
            correctAnswer = "ಆಗಮ ಸಂಧಿ",
            explanation = "ಕರುಣ + ವ್ + ಇಲ್ಲದವನ = ಕರುಣವಿಲ್ಲದವನ (ವ-ಕಾರಾಗಮ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s9_kan_u14_15",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಮನುಷ್ಯನ : ಷಷ್ಠಿ ವಿಭಕ್ತಿ :: ಮುದುಕರಿಗೆ : __________",
            options = listOf("ಚತುರ್ಥಿ ವಿಭಕ್ತಿ", "ತೃತೀಯಾ", "ಪಂಚಮೀ", "ಸಪ್ತಮೀ"),
            correctAnswer = "ಚತುರ್ಥಿ ವಿಭಕ್ತಿ",
            explanation = "ಮುದುಕರಿಗೆ ಪದದಲ್ಲಿ 'ಗೆ' ಚತುರ್ಥಿ ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯವಿದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_16",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಪತ್ರ : ಎಲೆ :: ಚಕ್ಕಡಿ : __________",
            options = listOf("ಎತ್ತಿನ ಗಾಡಿ", "ರಥ", "ಬಂಡಿ", "ಕುದುರೆಗಾಡಿ"),
            correctAnswer = "ಎತ್ತಿನ ಗಾಡಿ",
            explanation = "ಚಕ್ಕಡಿ ಎಂದರೆ ಎತ್ತಿನ ಬಂಡಿ."
        ),
        QuestionModel(
            id = "s9_kan_u14_17",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಹುಟ್ಟು : ಸಾವು :: ಮಿತ್ರ : __________",
            options = listOf("ಶತ್ರು", "ಬಂಧು", "ಸೋದರ", "ಗೆಳೆಯ"),
            correctAnswer = "ಶತ್ರು",
            explanation = "ಮಿತ್ರ ಪದದ ವಿರುದ್ಧ ಪದ ಶತ್ರು."
        ),
        QuestionModel(
            id = "s9_kan_u14_18",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಬಹುಪಾಡು : ಬಹಳ ಕಷ್ಟ :: ದಿವಿನಾಗು : __________",
            options = listOf("ಮೈತುಂಬಿಕೊಳ್ಳು / ಸಮೃದ್ಧವಾಗು", "ನಾಶವಾಗು", "ಒಣಗು", "ಸಾಯು"),
            correctAnswer = "ಮೈತುಂಬಿಕೊಳ್ಳು / ಸಮೃದ್ಧವಾಗು",
            explanation = "ದಿವಿನಾಗು ಎಂದರೆ ಮೈತುಂಬಿಕೊಂಡು ಸಮೃದ್ಧವಾಗಿ ಬೆಳೆಯುವುದು."
        ),
        QuestionModel(
            id = "s9_kan_u14_19",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಮೊರ : ಕೇರುವ ಸಾಧನ :: ಕೂರಿಗೆ : __________",
            options = listOf("ಬೀಜ ಬಿತ್ತುವ ಸಾಧನ", "ನೇಗಿಲು", "ಗಾಡಿ", "ಕಟಾವು ಯಂತ್ರ"),
            correctAnswer = "ಬೀಜ ಬಿತ್ತುವ ಸಾಧನ",
            explanation = "ಕೂರಿಗೆಯು ಭೂಮಿಯಲ್ಲಿ ಬೀಜ ಬಿತ್ತಲು ಬಳಸುವ ಕೃಷಿ ಸಾಧನ."
        ),
        QuestionModel(
            id = "s9_kan_u14_20",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಸಾಧು ಸತ್ಪುರುಷ : ಜೋಡು ನುಡಿ :: ಬೆಳೆಬೆಳೆಯುತ್ತ : __________",
            options = listOf("ದ್ವಿರುಕ್ತಿ", "ಅನುಕರಣಾವ್ಯಯ", "ನುಡಿಗಟ್ಟು", "ಜೋಡುನುಡಿ"),
            correctAnswer = "ದ್ವಿರುಕ್ತಿ",
            explanation = "ಬೆಳೆಬೆಳೆಯುತ್ತ ಎಂಬುದು ದ್ವಿರುಕ್ತಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_21",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ನಿತ್ಯ : ಅನಿತ್ಯ :: ಸತ್ಯ : __________",
            options = listOf("ಅಸತ್ಯ", "ನಿಜ", "ಸುಳ್ಳು", "ಮಿಥ್ಯ"),
            correctAnswer = "ಅಸತ್ಯ",
            explanation = "ಸತ್ಯ ಪದದ ತತ್ಸಮ ವಿರುದ್ಧ ರೂಪ ಅಸತ್ಯ."
        ),
        QuestionModel(
            id = "s9_kan_u14_22",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಯಾರ ಸ್ನೇಹವು ಸಾಯುವ ತನಕ ಬೇಡ ಎಂದಿದ್ದಾರೆ?",
            options = listOf("ಗುರು ಕರುಣವಿಲ್ಲದವನ ಸ್ನೇಹ", "ಬಡವನ ಸ್ನೇಹ", "ವಿದ್ವಾಂಸನ ಸ್ನೇಹ", "ರಾಜನ ಸ್ನೇಹ"),
            correctAnswer = "ಗುರು ಕರುಣವಿಲ್ಲದವನ ಸ್ನೇಹ",
            explanation = "ಗುರುವಿನ ದಯೆ ಮತ್ತು ಕರುಣೆ ಇಲ್ಲದವನ ಸ್ನೇಹ ಎಂದಿಗೂ ಬೇಡ ಎಂದಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_23",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಯಾರ ಸ್ನೇಹವನ್ನು ಮಾಡಿ ಕೆಡಬಾರದು?",
            options = listOf("ಹೀನ ಮನುಷ್ಯನ ಸ್ನೇಹ", "ಬಲಶಾಲಿಯ ಸ್ನೇಹ", "ವಿದೇಶಿಯ ಸ್ನೇಹ", "ಹಿರಿಯರ ಸ್ನೇಹ"),
            correctAnswer = "ಹೀನ ಮನುಷ್ಯನ ಸ್ನೇಹ",
            explanation = "ದುಷ್ಟ ಹಾಗೂ ಹೀನ ಮನುಷ್ಯನ ಸ್ನೇಹ ಮಾಡಿ ಕೆಟ್ಟುಹೋಗಬಾರದು."
        ),
        QuestionModel(
            id = "s9_kan_u14_24",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ತತ್ವಪದಕಾರರು ಯಾರ ಸೇವೆ ಮಾಡಬೇಕು ಎಂದಿದ್ದಾರೆ?",
            options = listOf("ಸಾಧು-ಸತ್ಪುರುಷರ ಸೇವೆ", "ಕೇವಲ ರಾಜರ ಸೇವೆ", "ಧನಿಕರ ಸೇವೆ", "ಸೈನಿಕರ ಸೇವೆ"),
            correctAnswer = "ಸಾಧು-ಸತ್ಪುರುಷರ ಸೇವೆ",
            explanation = "ಸಾಧು-ಸತ್ಪುರುಷರ ಸೇವೆಯೇ ಜೀವನದಲ್ಲಿ ಮೋಕ್ಷದ ದಾರಿ."
        ),
        QuestionModel(
            id = "s9_kan_u14_25",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಬಿದಿರು ಹೇಗೆ ಬೆಳೆಯುತ್ತದೆ?",
            options = listOf("ಹುಟ್ಟುತ್ತ ಹುಲ್ಲಾಗಿ, ಬೆಳೆಬೆಳೆಯುತ್ತ ಮೈತುಂಬಿಕೊಂಡು ದಿವಿನಾಗಿ", "ದೊಡ್ಡ ಮರವಾಗಿ", "ಬಳ್ಳಿಯಾಗಿ", "ಮುಳ್ಳಿನ ಗಿಡವಾಗಿ"),
            correctAnswer = "ಹುಟ್ಟುತ್ತ ಹುಲ್ಲಾಗಿ, ಬೆಳೆಬೆಳೆಯುತ್ತ ಮೈತುಂಬಿಕೊಂಡು ದಿವಿನಾಗಿ",
            explanation = "ಹುಟ್ಟುವಾಗ ಕೇವಲ ಹುಲ್ಲಿನಂತಿರುತ್ತಾ ಬೆಳೆಯುತ್ತಾ ಬೃಹತ್ ಬಿದಿರಿನ ಮೆಳೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_26",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಬಿದಿರಿನ ಚಪ್ಪರವು ಏನನ್ನು ಕೊಡುತ್ತದೆ?",
            options = listOf("ನೆರಳನ್ನು", "ಬಿಸಿಲನ್ನು", "ಮಳೆಯನ್ನು", "ಗಾಳಿಯನ್ನು"),
            correctAnswer = "ನೆರಳನ್ನು",
            explanation = "ಬಿಸಿಲಿನಲ್ಲಿ ಬಸವಳಿದವರಿಗೆ ಬಿದಿರಿನ ಚಪ್ಪರ ತಂಪಾದ ನೆರಳು ಕೊಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_27",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಬಿದಿರು ಶಿಶುನಾಳಧೀಶನಿಗೆ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಓಲಗವಾಗುತ್ತದೆ (ಶಹನಾಯಿ ವಾದ್ಯ)", "ಬಿಲ್ಲಾಗುತ್ತದೆ", "ಕೊಡೆಯಾಗುತ್ತದೆ", "ಪೀಠವಾಗುತ್ತದೆ"),
            correctAnswer = "ಓಲಗವಾಗುತ್ತದೆ (ಶಹನಾಯಿ ವಾದ್ಯ)",
            explanation = "ಶಿವನ ಆರಾಧನೆಯಲ್ಲಿ ಓಲಗವೆಂಬ ಶಹನಾಯಿ ವಾದ್ಯವಾಗಿ ನಾದ ಹೊಮ್ಮಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_28",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ಕಬೀರರೆಂದು ಹೆಸರು ಗಳಿಸಿದವರು ಯಾರು?",
            options = listOf("ಸಂತ ಶಿಶುನಾಳ ಶರೀಫರು", "ಕಡಕೋಳ ಮಡಿವಾಳಪ್ಪ", "ಕನಕದಾಸರು", "ಪುರಂದರದಾಸರು"),
            correctAnswer = "ಸಂತ ಶಿಶುನಾಳ ಶರೀಫರು",
            explanation = "ಭಾವೈಕ್ಯತೆಯ ತತ್ವಪದಗಳನ್ನು ರಚಿಸಿದ ಸಂತ ಶಿಶುನಾಳ ಶರೀಫರನ್ನು ಕರ್ನಾಟಕದ ಕಬೀರ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u14_29",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಕಡಕೋಳ ಮಡಿವಾಳಪ್ಪ ಅವರ ಅಂಕಿತನಾಮವೇನು?",
            options = listOf("ಮಹಾಂತೇಶ", "ಶಿಶುನಾಳಧೀಶ", "ಕೂಡಲಸಂಗಮದೇವ", "ಚೆನ್ನಮಲ್ಲಿಕಾರ್ಜುನ"),
            correctAnswer = "ಮಹಾಂತೇಶ",
            explanation = "ಕಡಕೋಳ ಮಡಿವಾಳಪ್ಪನವರ ತತ್ವಪದಗಳ ಅಂಕಿತನಾಮ 'ಮಹಾಂತೇಶ'."
        ),
        QuestionModel(
            id = "s9_kan_u14_30",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಕಡಕೋಳ ಮಡಿವಾಳಪ್ಪ ಅವರ ತಂದೆ ತಾಯಿಯ ಹೆಸರೇನು?",
            options = listOf("ವಿರೂಪಾಕ್ಷಯ್ಯ ಮತ್ತು ಗಂಗಮ್ಮ", "ದೇವಪ್ಪ ಮತ್ತು ಈರಮ್ಮ", "ರಾಮಯ್ಯ ಮತ್ತು ಸೀತಮ್ಮ", "ಮಲ್ಲಪ್ಪ ಮತ್ತು ರುದ್ರಮ್ಮ"),
            correctAnswer = "ವಿರೂಪಾಕ್ಷಯ್ಯ ಮತ್ತು ಗಂಗಮ್ಮ",
            explanation = "ಅವರ ತಂದೆ ವಿರೂಪಾಕ್ಷಯ್ಯ ಮತ್ತು ತಾಯಿ ಗಂಗಮ್ಮ."
        ),
        QuestionModel(
            id = "s9_kan_u14_31",
            stdId = 9,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಶಿಶುನಾಳ ಶರೀಫರ ಬಾಲ್ಯದ ಹೆಸರೇನು?",
            options = listOf("ಮಹಮ್ಮದ್ ಶರೀಫ", "ಇಮಾಮ್ ಸಾಹೇಬ", "ಫಕೀರಪ್ಪ", "ರಹೀಮ್"),
            correctAnswer = "ಮಹಮ್ಮದ್ ಶರೀಫ",
            explanation = "ಅವರ ಬಾಲ್ಯದ ಹೆಸರು ಮಹಮ್ಮದ್ ಶರೀಫ."
        ),

        // ==========================================
        // ಘಟಕ 15: ನಿನ್ನ ಮುತ್ತಿನ ಸತ್ತಿಗೆಯನಿತ್ತು ಸಲಹು (ರಾಘವಾಂಕ)
        // ==========================================
        QuestionModel(
            id = "s9_kan_u15_1",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿ ಪದ್ಯದಲ್ಲಿರುವ ಸಾಲುಗಳು ಎಷ್ಟು?",
            options = listOf("ಆರು", "ಮೂರು", "ನಾಲ್ಕು", "ಹದಿನಾಲ್ಕು"),
            correctAnswer = "ಆರು",
            explanation = "ಷಟ್ಪದಿ ಎಂದರೆ ಆರು ಸಾಲುಗಳ ಪದ್ಯ (ಷಟ್ + ಪದಿ)."
        ),
        QuestionModel(
            id = "s9_kan_u15_2",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿ ಪದ್ಯದ ಗಣ ಪ್ರಕಾರ ಯಾವುದು?",
            options = listOf("ಮಾತ್ರಾ ಗಣ", "ಅಕ್ಷರ ಗಣ", "ಅಂಶ ಗಣ", "ಅಂಕ ಗಣ"),
            correctAnswer = "ಮಾತ್ರಾ ಗಣ",
            explanation = "ಷಟ್ಪದಿಯು ಮಾತ್ರಾಗಣಕ್ಕೆ ಸೇರಿದ ಕಾವ್ಯ ಪ್ರಕಾರ."
        ),
        QuestionModel(
            id = "s9_kan_u15_3",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿ ಪದ್ಯದಲ್ಲಿರುವ ಒಟ್ಟು ಪ್ರಮುಖ ವಿಧಗಳು ಎಷ್ಟು?",
            options = listOf("ಆರು", "ಐದು", "ಏಳು", "ಎಂಟು"),
            correctAnswer = "ಆರು",
            explanation = "ಶರ, ಕುಸುಮ, ಭೋಗ, ಭಾಮಿನಿ, ವಾರ್ಧಕ, ಪರಿವರ್ಧಿನಿ ಎಂದು ಷಟ್ಪದಿಯಲ್ಲಿ ಆರು ಪ್ರಮುಖ ವಿಧಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u15_4",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿಯಲ್ಲಿ ಈ ಪ್ರಾಸವು ನಿಯಮಿತವಾಗಿರುತ್ತದೆ:",
            options = listOf("ಆದಿ ಪ್ರಾಸ", "ಒಳ ಪ್ರಾಸ", "ಮಧ್ಯ ಪ್ರಾಸ", "ಅಂತ್ಯ ಪ್ರಾಸ"),
            correctAnswer = "ಆದಿ ಪ್ರಾಸ",
            explanation = "ಷಟ್ಪದಿಯ ಆರೂ ಸಾಲುಗಳ ಎರಡನೇ ಅಕ್ಷರ ಒಂದೇ ಆಗಿರುವ ಆದಿಪ್ರಾಸ ನಿಯಮಿತವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u15_5",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿ ಪದ್ಯದಲ್ಲಿ ಮೂರು ಮತ್ತು ಆರನೇ ಸಾಲಿನ ಕೊನೆಯ ಅಕ್ಷರವನ್ನು ಹೀಗೆಂದು ಪರಿಗಣಿಸಬೇಕು:",
            options = listOf("ಗುರು", "ಲಘು", "ಯತಿ", "ಪ್ರಾಸ"),
            correctAnswer = "ಗುರು",
            explanation = "೩ ಮತ್ತು ೬ ನೇ ಸಾಲಿನ ಕೊನೆಯ ಲಘು ಅಕ್ಷರವೂ ಛಂದಸ್ಸಿನ ನಿಯಮದಂತೆ ಗುರುವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u15_6",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿ ಪದ್ಯದ ಒಂದು ಮತ್ತು ಎರಡನೇ ಸಾಲುಗಳಿಗೆ ಸಮನಾಗಿರುವ ಸಾಲುಗಳು:",
            options = listOf("೪ ಮತ್ತು ೫", "೨ ಮತ್ತು ೩", "೩ ಮತ್ತು ೪", "೫ ಮತ್ತು ೬"),
            correctAnswer = "೪ ಮತ್ತು ೫",
            explanation = "ಷಟ್ಪದಿಯಲ್ಲಿ ೧, ೨ ಸಾಲುಗಳು ಮತ್ತು ೪, ೫ ಸಾಲುಗಳು ಸಮಾನ ಮಾತ್ರಾ ವಿನ್ಯಾಸ ಹೊಂದಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u15_7",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿಯ ಮೊದಲ ಮೂರು ಸಾಲುಗಳು : ಪೂರ್ವಾರ್ಧ :: ಕೊನೆಯ ಮೂರು ಸಾಲುಗಳು : __________",
            options = listOf("ಉತ್ತರಾರ್ಧ", "ಮಧ್ಯಾರ್ಧ", "ಪೂರ್ಣಾರ್ಧ", "ಅಂತ್ಯಾರ್ಧ"),
            correctAnswer = "ಉತ್ತರಾರ್ಧ",
            explanation = "೪, ೫, ೬ ನೇ ಸಾಲುಗಳನ್ನು ಉತ್ತರಾರ್ಧ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s9_kan_u15_8",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಭಾಮಿನಿ ಷಟ್ಪದಿ : ೩, ೪ ಮಾತ್ರೆಗಳು :: ವಾರ್ಧಕ ಷಟ್ಪದಿ : __________",
            options = listOf("೫, ೫, ೫, ೫ ಮಾತ್ರೆಗಳು", "೩, ೪ ಮಾತ್ರೆಗಳು", "೪, ೪ ಮಾತ್ರೆಗಳು", "೬, ೬ ಮಾತ್ರೆಗಳು"),
            correctAnswer = "೫, ೫, ೫, ೫ ಮಾತ್ರೆಗಳು",
            explanation = "ವಾರ್ಧಕ ಷಟ್ಪದಿಯಲ್ಲಿ ಪ್ರತಿ ಸಾಲಿನಲ್ಲಿ ೫ ಮಾತ್ರೆಗಳ ಗಣಗಳು ಬರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u15_9",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ವರದ : UUU :: ಕನ್ನಡ : __________",
            options = listOf("-UU", "U-U", "UU-", "---"),
            correctAnswer = "-UU",
            explanation = "ಕನ್(ಗುರು -) ನ(ಲಘು U) ಡ(ಲಘು U) = -UU (ಭ-ಗಣ)."
        ),
        QuestionModel(
            id = "s9_kan_u15_10",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಹರವು : ಮೂರು ಮಾತ್ರೆಗಳು :: ವರಕಾ : __________",
            options = listOf("ನಾಲ್ಕು ಮಾತ್ರೆಗಳು", "ಮೂರು ಮಾತ್ರೆಗಳು", "ಐದು ಮಾತ್ರೆಗಳು", "ಆರು ಮಾತ್ರೆಗಳು"),
            correctAnswer = "ನಾಲ್ಕು ಮಾತ್ರೆಗಳು",
            explanation = "ವ(೧) ರ(೧) ಕಾ(೨) = ಒಟ್ಟು ನಾಲ್ಕು ಮಾತ್ರೆಗಳು."
        ),
        QuestionModel(
            id = "s9_kan_u15_11",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಹರಿಶ್ಚಂದ್ರನು ಕಾಡುಹಂದಿಯನ್ನು ಹಿಂಬಾಲಿಸುತ್ತ ಯಾರ ತಪೋವನಕ್ಕೆ ಬಂದನು?",
            options = listOf("ವಿಶ್ವಾಮಿತ್ರನ ಬನಕ್ಕೆ", "ವಸಿಷ್ಠರ ಆಶ್ರಮಕ್ಕೆ", "ವಾಲ್ಮೀಕಿ ಬನಕ್ಕೆ", "ಗೌತಮರ ಆಶ್ರಮಕ್ಕೆ"),
            correctAnswer = "ವಿಶ್ವಾಮಿತ್ರನ ಬನಕ್ಕೆ",
            explanation = "ವಿಶ್ವಾಮಿತ್ರ ಮುನಿಯ ತಪೋವನಕ್ಕೆ ಮಾಯಾ ಹಂದಿಯನ್ನು ಅಟ್ಟಿಸಿಕೊಂಡು ಬಂದನು."
        ),
        QuestionModel(
            id = "s9_kan_u15_12",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಹರಿಶ್ಚಂದ್ರನ ಕುಲಗುರು ಯಾರು?",
            options = listOf("ವಸಿಷ್ಠ ಮುನಿ", "ವಿಶ್ವಾಮಿತ್ರ", "ವಾಲ್ಮೀಕಿ", "ಕಣ್ವ"),
            correctAnswer = "ವಸಿಷ್ಠ ಮುನಿ",
            explanation = "ಸೂರ್ಯವಂಶದ ಕುಲಗುರು ಬ್ರಹ್ಮರ್ಷಿ ವಸಿಷ್ಠರು."
        ),
        QuestionModel(
            id = "s9_kan_u15_13",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಗಾನರಾಣಿಯರು ಅವನೀಶನನ್ನು ನೋಡಲು ಬಂದದ್ದನ್ನು ಕವಿಯು ಯಾವುದಕ್ಕೆ ಹೋಲಿಸಿದ್ದಾನೆ?",
            options = listOf("ಕಗ್ಗತ್ತಲೆಯ ರಾತ್ರಿಯಲ್ಲಿ ಕನ್ಯೆಯರು ಹಗಲನ್ನು ನೋಡುವುದಕ್ಕೆ ಬಂದಂತೆ", "ನವಿಲುಗಳು ಮಳೆಯನ್ನು ಎದುರುನೋಡುವಂತೆ", "ಹಂಸಗಳು ಸರೋವರಕ್ಕೆ ಬಂದಂತೆ", "ತಾರೆಗಳು ಭೂಮಿಗೆ ಇಳಿದಂತೆ"),
            correctAnswer = "ಕಗ್ಗತ್ತಲೆಯ ರಾತ್ರಿಯಲ್ಲಿ ಕನ್ಯೆಯರು ಹಗಲನ್ನು ನೋಡುವುದಕ್ಕೆ ಬಂದಂತೆ",
            explanation = "ಕತ್ತಲೆಯನ್ನು ಹೋಲುವ ಕನ್ಯೆಯರು ಸೂರ್ಯನಂತಿರುವ ಹರಿಶ್ಚಂದ್ರನನ್ನು ನೋಡಲು ಬಂದಂತೆ ವರ್ಣಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u15_14",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಹರಿಶ್ಚಂದ್ರನು ಯಾರ ಆಜ್ಞೆಯನ್ನು ಮೀರಿದ ದುಃಖವನ್ನು ಮರೆತನು?",
            options = listOf("ಎರಡನೇ ಮುಕ್ಕಣ್ಣನೆನಿಸ ಗುರು ವಸಿಷ್ಠರ ಆಜ್ಞೆ", "ವಿಶ್ವಾಮಿತ್ರರ ಆಜ್ಞೆ", "ತಂದೆಯ ಆಜ್ಞೆ", "ತಾಯಿಯ ಆಜ್ಞೆ"),
            correctAnswer = "ಎರಡನೇ ಮುಕ್ಕಣ್ಣನೆನಿಸ ಗುರು ವಸಿಷ್ಠರ ಆಜ್ಞೆ",
            explanation = "ಗಾನರಾಣಿಯರ ಸಂಗೀತಕ್ಕೆ ಮರುಳಾಗಿ ಗುರುವಿನ ಆಜ್ಞೆಯನ್ನು ಮೀರಿದ ಚಿಂತೆಯನ್ನು ಮರೆತನು."
        ),
        QuestionModel(
            id = "s9_kan_u15_15",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಗಾನರಾಣಿಯರಿಗೆ ಹರಿಶ್ಚಂದ್ರನು ಯಾವ ಬಹುಮಾನವನ್ನು ಕೊಟ್ಟನು?",
            options = listOf("ಸರ್ವಾಭರಣವನ್ನು (ಚಿನ್ನದ ಒಡವೆಗಳನ್ನು)", "ಆನೆಗಳನ್ನು", "ರಥಗಳನ್ನು", "ಭೂಮಿಯನ್ನು"),
            correctAnswer = "ಸರ್ವಾಭರಣವನ್ನು (ಚಿನ್ನದ ಒಡವೆಗಳನ್ನು)",
            explanation = "ತನ್ನ ಮೈಮೇಲಿನ ಬೆಲೆಬಾಳುವ ಸಮಸ್ತ ರತ್ನಾಭರಣಗಳನ್ನು ಬಹುಮಾನವಾಗಿ ನೀಡಿದನು."
        ),
        QuestionModel(
            id = "s9_kan_u15_16",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಗಾನರಾಣಿಯರು ಹರಿಶ್ಚಂದ್ರನನ್ನು ಏನನ್ನು ಕೊಡು ಎಂದು ಕೇಳಿದರು?",
            options = listOf("ಮುತ್ತಿನ ಸತ್ತಿಗೆಯನ್ನು (ಬೆಳ್ಕೊಡೆಯನ್ನು)", "ಕಿರೀಟವನ್ನು", "ಸಿಂಹಾಸನವನ್ನು", "ಅರಮನೆಯನ್ನು"),
            correctAnswer = "ಮುತ್ತಿನ ಸತ್ತಿಗೆಯನ್ನು (ಬೆಳ್ಕೊಡೆಯನ್ನು)",
            explanation = "ಆಭರಣಗಳನ್ನು ತಿರಸ್ಕರಿಸಿ ರಾಜಲಾಂಛನವಾದ ಮುತ್ತಿನ ಛತ್ರವನ್ನು (ಸತ್ತಿಗೆ) ಕೇಳಿದರು."
        ),
        QuestionModel(
            id = "s9_kan_u15_17",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಯುದ್ಧರಂಗದಲ್ಲಿ ಸತ್ತಿಗೆಯನ್ನು ನೋಡಿದರೆ ಶತ್ರುಗಳು ಏನಾಗುತ್ತಾರೆ?",
            options = listOf("ಶತ್ರುಗಳು ನಿಲ್ಲುವುದಿಲ್ಲ (ಹೆದರಿ ಓಡುತ್ತಾರೆ)", "ಯುದ್ಧ ನಿಲ್ಲಿಸುತ್ತಾರೆ", "ಶರಣಾಗುತ್ತಾರೆ", "ನಗುತ್ತಾರೆ"),
            correctAnswer = "ಶತ್ರುಗಳು ನಿಲ್ಲುವುದಿಲ್ಲ (ಹೆದರಿ ಓಡುತ್ತಾರೆ)",
            explanation = "ರಾಜಸತ್ತಿಗೆಯನ್ನು ನೋಡಿದೊಡನೆ ಯುದ್ಧರಂಗದಲ್ಲಿ ಶತ್ರುಸೈನ್ಯವು ನಿಲ್ಲದೆ ನಡುಗಿ ಓಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u15_18",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಸತ್ತಿಗೆಯ ನೆರಳಿನಲ್ಲಿ ಇರುವವನಿಗೆ ಯಾವುದೆಲ್ಲವೂ ಕಳೆದುಹೋಗುತ್ತದೆ ಎಂದು ಹರಿಶ್ಚಂದ್ರನು ಹೇಳಿದನು?",
            options = listOf("ವಿಪತ್ತು, ಅಡಚಣೆ, ಬಡತನ, ರೋಗ, ಸೋಲು ಮತ್ತು ಭಯ", "ಸಂಪತ್ತು ಮತ್ತು ಕೀರ್ತಿ", "ಹಸಿವು ಮತ್ತು ನಿದ್ರೆ", "ಕೋಪ ಮತ್ತು ಮತ್ಸರ"),
            correctAnswer = "ವಿಪತ್ತು, ಅಡಚಣೆ, ಬಡತನ, ರೋಗ, ಸೋಲು ಮತ್ತು ಭಯ",
            explanation = "ರಾಜಛತ್ರದ ನೆರಳಿನಲ್ಲಿ ಪ್ರಜೆಗಳ ಸಮಸ್ತ ವಿಪತ್ತು, ಬಡತನ ಮತ್ತು ಭಯಗಳು ಮಾಯವಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u15_19",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಹರಿಶ್ಚಂದ್ರನು ಸತ್ತಿಗೆ ಇಲ್ಲದೆ ಯಾರು ಇಲ್ಲ ಎಂದನು?",
            options = listOf("ತಂದೆ ತಾಯಿಯರು ಇಲ್ಲ", "ಸೈನಿಕರು ಇಲ್ಲ", "ಮಂತ್ರಿಗಳು ಇಲ್ಲ", "ಪ್ರಜೆಗಳು ಇಲ್ಲ"),
            correctAnswer = "ತಂದೆ ತಾಯಿಯರು ಇಲ್ಲ",
            explanation = "ಸತ್ತಿಗೆಯು ತನಗೆ ಸಾಕ್ಷಾತ್ ತಂದೆ-ತಾಯಿಯ ಸಮಾನವಾದ ರಕ್ಷಣಾ ಕವಚ ಎಂದನು."
        ),
        QuestionModel(
            id = "s9_kan_u15_20",
            stdId = 9,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "ಸತ್ತಿಗೆಯು ರಾಜಪಟ್ಟ ಕಟ್ಟುವಾಗ ಯಾರ ಸ್ವರೂಪ ಎಂದು ಹರಿಶ್ಚಂದ್ರನು ಹೇಳುತ್ತಾನೆ?",
            options = listOf("ದೈವ ಸ್ವರೂಪ (ದೇವರು)", "ಸೂರ್ಯ ಸ್ವರೂಪ", "ಗುರು ಸ್ವರೂಪ", "ವಾಯು ಸ್ವರೂಪ"),
            correctAnswer = "ದೈವ ಸ್ವರೂಪ (ದೇವರು)",
            explanation = "ಪಟ್ಟ ಕಟ್ಟುವ ಸಮಯದಲ್ಲಿ ರಾಜನಿಗೆ ಸತ್ತಿಗೆಯೇ ಸಾಕ್ಷಾತ್ ದೈವಸ್ವರೂಪವಾಗಿರುತ್ತದೆ."
        ),

        // ==========================================
        // ಘಟಕ 16: ಕನ್ನಡ ನಾಡು ನುಡಿ (ಶ್ರೀ ವಿಜಯ, ನಯಸೇನ, ನೇಮಿಚಂದ್ರ, ಮಹಲಿಂಗರಂಗ, ಆಂಡಯ್ಯ)
        // ==========================================
        QuestionModel(
            id = "s9_kan_u16_1",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಚದುರ' ಪದದ ತತ್ಸಮ ರೂಪ ಇದಾಗಿದೆ:",
            options = listOf("ಚತುರ", "ಚದರ", "ಚದೂರ", "ಚಧುರ"),
            correctAnswer = "ಚತುರ",
            explanation = "ಚತುರ ತತ್ಸಮದ ಕನ್ನಡ ತದ್ಭವ ರೂಪ ಚದುರ."
        ),
        QuestionModel(
            id = "s9_kan_u16_2",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ಅಕ್ಷರ ಗಣದಲ್ಲಿರುವ ಒಟ್ಟು ಗಣಗಳ ಸಂಖ್ಯೆ:",
            options = listOf("ಎಂಟು", "ನಾಲ್ಕು", "ಐದು", "ಏಳು"),
            correctAnswer = "ಎಂಟು",
            explanation = "ಮ, ಯ, ರ, ಸ, ತ, ಜ, ಭ, ನ ಎಂದು ಅಕ್ಷರ ಗಣಗಳು ಎಂಟು (೮)."
        ),
        QuestionModel(
            id = "s9_kan_u16_3",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ಖ್ಯಾತ ಕರ್ನಾಟಕ ವೃತ್ತಗಳ ಒಟ್ಟು ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("ಆರು", "ಐದು", "ಮೂರು", "ಎಂಟು"),
            correctAnswer = "ಆರು",
            explanation = "ಉತ್ಪಲಮಾಲಾ, ಚಂಪಕಮಾಲಾ, ಶಾರ್ದೂಲವಿಕ್ರೀಡಿತ, ಮತ್ತೇಭವಿಕ್ರೀಡಿತ, ಸ್ರಗ್ಧರಾ, ಮಹಾಸ್ರಗ್ಧರಾ - ಇವು ಆರು ಖ್ಯಾತ ಕರ್ನಾಟಕ ವೃತ್ತಗಳು."
        ),
        QuestionModel(
            id = "s9_kan_u16_4",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಉತ್ಪಲ ಮಾಲಾ ವೃತ್ತ'ದ ಒಂದು ಸಾಲಿನ ಅಕ್ಷರಗಳ ಸಂಖ್ಯೆ:",
            options = listOf("೨೦", "೨೧", "೨೨", "೧೮"),
            correctAnswer = "೨೦",
            explanation = "ಉತ್ಪಲಮಾಲಾ ವೃತ್ತದ ಪಾದದಲ್ಲಿ ೨೦ ಅಕ್ಷರಗಳಿರುತ್ತವೆ (ಭ ರ ನ ಭ ಭ ರ ಲಗು)."
        ),
        QuestionModel(
            id = "s9_kan_u16_5",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಅರಯ' ಪದದ ಅರ್ಥ:",
            options = listOf("ಪಾಲನೆ / ತಿಳಿಯುವುದು", "ಆಲಯ", "ಆದೇಶ", "ಗುಣ"),
            correctAnswer = "ಪಾಲನೆ / ತಿಳಿಯುವುದು",
            explanation = "ಅರಯ ಎಂದರೆ ಪಾಲನೆ ಅಥವಾ ಅರಿತುಕೊಳ್ಳುವುದು."
        ),
        QuestionModel(
            id = "s9_kan_u16_6",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಅಗಳ್' ಪದದ ಅರ್ಥ:",
            options = listOf("ಶ್ರೇಷ್ಠ", "ಕಡಿಮೆ", "ಬಿದಿರು", "ಗಡಿಗೆ"),
            correctAnswer = "ಶ್ರೇಷ್ಠ",
            explanation = "ಅಗಳ್ ಎಂದರೆ ಶ್ರೇಷ್ಠ ಅಥವಾ ಅಧಿಕ."
        ),
        QuestionModel(
            id = "s9_kan_u16_7",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಸಂಸ್ಕೃತ' ಪದದ ತದ್ಭವ ರೂಪ ಇದಾಗಿದೆ:",
            options = listOf("ಸಕ್ಕದ", "ಸಂಸದ", "ಸಂಸ್ಕೃತಿ", "ಸಂಸ್ಕಾರ"),
            correctAnswer = "ಸಕ್ಕದ",
            explanation = "ಸಂಸ್ಕೃತದ ಶುದ್ಧ ತದ್ಭವ ಸಕ್ಕದ."
        ),
        QuestionModel(
            id = "s9_kan_u16_8",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಕಂದ' ಪದ್ಯದ ನಾಲ್ಕೂ ಸಾಲುಗಳ ಒಟ್ಟು ಮಾತ್ರೆಗಳ ಸಂಖ್ಯೆ:",
            options = listOf("೬೪", "೪೬", "೧೦೨", "೧೪೪"),
            correctAnswer = "೬೪",
            explanation = "ಕಂದ ಪದ್ಯದಲ್ಲಿ ೧ ಮತ್ತು ೩ ನೇ ಸಾಲಿನಲ್ಲಿ ೧೨ ಮಾತ್ರೆ, ೨ ಮತ್ತು ೪ ನೇ ಸಾಲಿನಲ್ಲಿ ೨೦ ಮಾತ್ರೆ ಸೇರಿ ಒಟ್ಟು ೬೪ ಮಾತ್ರೆಗಳಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u16_9",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಚಂಪಕ ಮಾಲಾ ವೃತ್ತ'ದ ಒಂದು ಸಾಲಿನ ಅಕ್ಷರಗಳ ಸಂಖ್ಯೆ:",
            options = listOf("೨೧", "೨೨", "೨೦", "೧೮"),
            correctAnswer = "೨೧",
            explanation = "ಚಂಪಕಮಾಲಾ ವೃತ್ತದ ಪಾದದಲ್ಲಿ ೨೧ ಅಕ್ಷರಗಳಿರುತ್ತವೆ (ನ ಜ ಭ ಜ ಜ ಜ ರ)."
        ),
        QuestionModel(
            id = "s9_kan_u16_10",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಲಲಿತ' ಪದದ ಅರ್ಥ:",
            options = listOf("ಸುಂದರ", "ಹಾಡು", "ಬಳ್ಳಿ", "ಹೂ"),
            correctAnswer = "ಸುಂದರ",
            explanation = "ಲಲಿತ ಎಂದರೆ ಮೃದುವಾದ, ಸುಂದರವಾದ."
        ),
        QuestionModel(
            id = "s9_kan_u16_11",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ತೈಲ : ಎಣ್ಣೆ :: ಘೃತ : __________",
            options = listOf("ತುಪ್ಪ", "ಬೆಣ್ಣೆ", "ಹಾಲು", "ಜೇನು"),
            correctAnswer = "ತುಪ್ಪ",
            explanation = "ಘೃತ ಎಂದರೆ ಆಕಳ ತುಪ್ಪ."
        ),
        QuestionModel(
            id = "s9_kan_u16_12",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ಅ ಆ ಇ ಈ : ಸ್ವರಗಳು :: ಪ ಫ ಬ ಭ : __________",
            options = listOf("ವ್ಯಂಜನಗಳು", "ಯೋಗವಾಹಗಳು", "ಅನುನಾಸಿಕಗಳು", "ಪ್ಲುತಸ್ವರಗಳು"),
            correctAnswer = "ವ್ಯಂಜನಗಳು",
            explanation = "ಪ, ಫ, ಬ, ಭ, ಮ ಇವು ಓಷ್ಠ್ಯ ವರ್ಗೀಯ ವ್ಯಂಜನಗಳು."
        ),
        QuestionModel(
            id = "s9_kan_u16_13",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ಷಟ್ಪದಿಗಳು : ಮಾತ್ರಾಗಣ :: ವೃತ್ತಗಳು : __________",
            options = listOf("ಅಕ್ಷರಗಣ", "ಮಾತ್ರಾಗಣ", "ಅಂಶಗಣ", "ಲಯಗಣ"),
            correctAnswer = "ಅಕ್ಷರಗಣ",
            explanation = "ಖ್ಯಾತ ಕರ್ನಾಟಕ ವೃತ್ತಗಳು ಮೂರು ಮೂರು ಅಕ್ಷರಗಳ ಗಣಗಳಾದ ಅಕ್ಷರಗಣಗಳಿಂದ ರಚಿತವಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s9_kan_u16_14",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ಭಾಮಿನಿ ಷಟ್ಪದಿ : ೩, ೪, ೩, ೪ :: ಕಂದ : __________",
            options = listOf("೪-೪-೪", "೩-೩-೩", "೫-೫-೫", "೬-೬-೬"),
            correctAnswer = "೪-೪-೪",
            explanation = "ಕಂದ ಪದ್ಯದಲ್ಲಿ ಪ್ರತಿ ಗಣವೂ ನಾಲ್ಕು ಮಾತ್ರೆಗಳದ್ದಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s9_kan_u16_15",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ತುಪ್ಪದೊಡನೆ ಯಾವುದನ್ನು ಬೆರೆಸಬಾರದು ಎಂದು ನಯಸೇನ ಹೇಳುತ್ತಾನೆ?",
            options = listOf("ಎಣ್ಣೆಯನ್ನು", "ಹಾಲನ್ನು", "ನೀರನ್ನು", "ಜೇನನ್ನು"),
            correctAnswer = "ಎಣ್ಣೆಯನ್ನು",
            explanation = "ತುಪ್ಪದಲ್ಲಿ ಎಣ್ಣೆ ಬೆರೆಸಿದರೆ ರುಚಿ ಕೆಡುವಂತೆ, ಶುದ್ಧ ಕನ್ನಡದಲ್ಲಿ ಅನವಶ್ಯಕವಾಗಿ ಸಂಸ್ಕೃತ ಬೆರೆಸಬಾರದು ಎಂದರು."
        ),
        QuestionModel(
            id = "s9_kan_u16_16",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ಸುಲಿದ ಬಾಳೆಯ ಹಣ್ಣಿನಂತೆ ಸುಲಭವಾದ ಭಾಷೆ ಯಾವುದು?",
            options = listOf("ಕನ್ನಡ ಭಾಷೆ", "ಸಂಸ್ಕೃತ", "ಇಂಗ್ಲಿಷ್", "ಹಿಂದಿ"),
            correctAnswer = "ಕನ್ನಡ ಭಾಷೆ",
            explanation = "'ಸುಲಿದ ಬಾಳೆಯ ಹಣ್ಣಿನಂದದಿ' ಸುಲಲಿತವಾಗಿ ಎಲ್ಲರಿಗೂ ಅರ್ಥವಾಗುವ ಭಾಷೆ ಕನ್ನಡವೆಂದು ಮಹಲಿಂಗರಂಗ ಬಣ್ಣಿಸಿದ್ದಾನೆ."
        ),
        QuestionModel(
            id = "s9_kan_u16_17",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಕುರಿತೋದದೆಯುಂ ಕಾವ್ಯ ಪ್ರಯೋಗ ಪರಿಣತ ಮತಿಗಳ್' ಎಂದವರು ಯಾರು?",
            options = listOf("ಶ್ರೀ ವಿಜಯ ಕವಿ", "ನಯಸೇನ", "ಪಂಪ", "ಕುಮಾರವ್ಯಾಸ"),
            correctAnswer = "ಶ್ರೀ ವಿಜಯ ಕವಿ",
            explanation = "ಕವಿರಾಜಮಾರ್ಗದಲ್ಲಿ ಕನ್ನಡಿಗರ ಕಾವ್ಯ ಪ್ರೌಢಿಮೆಯನ್ನು ಶ್ರೀವಿಜಯನು ಹೀಗೆ ಕೊಂಡಾಡಿದ್ದಾನೆ."
        ),
        QuestionModel(
            id = "s9_kan_u16_18",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "'ಶುದ್ಧ ಕನ್ನಡದೊಳ್ ಸಂಸ್ಕೃತವನ್ನು ಬೆರೆಸಬಾರದು' ಎಂದ ಕವಿ ಯಾರು?",
            options = listOf("ನಯಸೇನ ಕವಿ", "ಆಂಡಯ್ಯ", "ನೇಮಿಚಂದ್ರ", "ಕೇಶಿರಾಜ"),
            correctAnswer = "ನಯಸೇನ ಕವಿ",
            explanation = "ಧರ್ಮಾಮೃತ ಕಾವ್ಯದಲ್ಲಿ ನಯಸೇನನು ಅಚ್ಚಗನ್ನಡದ ಶುದ್ಧತೆಯನ್ನು ಪ್ರತಿಪಾದಿಸಿದ್ದಾನೆ."
        ),
        QuestionModel(
            id = "s9_kan_u16_19",
            stdId = 9,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ಕನ್ನಡನಾಡಿನ ಪರಿಸರದಲ್ಲಿ ಏನೆಲ್ಲಾ ಬೆಳೆಯುತ್ತದೆ ಎಂದು ಆಂಡಯ್ಯ ಕವಿ ಹೇಳಿದ್ದಾರೆ?",
            options = listOf("ಮಲ್ಲಿಗೆ, ಸಂಪಿಗೆ, ದಾಳಿಂಬೆ, ಮಾವು, ತೆಂಗು, ಅಡಿಕೆ", "ಗೋಧಿ, ಬಾರ್ಲಿ, ಸೇಬು", "ಕಾಫಿ, ಚಹಾ, ರಬ್ಬರ್", "ಕಬ್ಬು, ಹತ್ತಿ, ಹೊಗೆಸೊಪ್ಪು"),
            correctAnswer = "ಮಲ್ಲಿಗೆ, ಸಂಪಿಗೆ, ದಾಳಿಂಬೆ, ಮಾವು, ತೆಂಗು, ಅಡಿಕೆ",
            explanation = "ಕಬ್ಬಿಗರ ಕಾವದಲ್ಲಿ ಆಂಡಯ್ಯ ಕವಿಯು ಕನ್ನಡನಾಡಿನ ಫಲಪುಷ್ಪ ಸಂಪತ್ತನ್ನು ಬಣ್ಣಿಸಿದ್ದಾನೆ."
        )
    )
}
