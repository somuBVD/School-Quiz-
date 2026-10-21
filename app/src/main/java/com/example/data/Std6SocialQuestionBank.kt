package com.example.data

/**
 * Standard 6 Social Science (Kannada Medium - LBA Revised 2026-27, 6thSS-KM-LBARevised_1787048536.pdf)
 * Complete question bank containing all MCQs and converted fill-in-the-blanks across History, Civics, and Geography units.
 */
object Std6SocialQuestionBank {

    val units = listOf(
        // ಭಾಗ 1 — ಇತಿಹಾಸ
        UnitTemplate(1, "ಇತಿಹಾಸ: ಅಧ್ಯಾಯ 1 - ಇತಿಹಾಸ ಪರಿಚಯ ಮತ್ತು ಆರಂಭಿಕ ಸಮಾಜ", 18, "Easy"),
        UnitTemplate(2, "ಇತಿಹಾಸ: ಅಧ್ಯಾಯ 2 - ನಮ್ಮ ಹೆಮ್ಮೆಯ ಕರ್ನಾಟಕ (ಕಂದಾಯ ವಿಭಾಗಗಳು)", 33, "Medium"),
        UnitTemplate(3, "ಇತಿಹಾಸ: ಅಧ್ಯಾಯ 3 - ಪ್ರಾಚೀನ ನಾಗರಿಕತೆಗಳು", 12, "Medium"),
        UnitTemplate(4, "ಇತಿಹಾಸ: ಅಧ್ಯಾಯ 4 - ವೇದ ಸಂಸ್ಕೃತಿ ಮತ್ತು ಹೊಸ ಧರ್ಮಗಳ ಉದಯ", 25, "Hard"),
        UnitTemplate(5, "ಇತಿಹಾಸ: ಅಧ್ಯಾಯ 5 - ಉತ್ತರ ಭಾರತದ ಪ್ರಮುಖ ರಾಜಮನೆತನಗಳು", 10, "Medium"),
        UnitTemplate(6, "ಇತಿಹಾಸ: ಅಧ್ಯಾಯ 6 - ದಕ್ಷಿಣ ಭಾರತದ ಪ್ರಮುಖ ರಾಜಮನೆತನಗಳು", 22, "Hard"),
        // ಭಾಗ 2 — ಪೌರನೀತಿ
        UnitTemplate(7, "ಪೌರನೀತಿ: ಅಧ್ಯಾಯ 7 - ಪೌರತ್ವ, ರಾಷ್ಟ್ರೀಯ ಲಾಂಛನಗಳು ಮತ್ತು ದಿನಾಚರಣೆಗಳು", 12, "Easy"),
        UnitTemplate(8, "ಪೌರನೀತಿ: ಅಧ್ಯಾಯ 8 - ನಮ್ಮ ಸಂವಿಧಾನ, ಮಾನವ ಹಕ್ಕುಗಳು ಮತ್ತು ಕರ್ತವ್ಯಗಳು", 29, "Medium"),
        UnitTemplate(9, "ಪೌರನೀತಿ: ಅಧ್ಯಾಯ 9 - ಪ್ರಭುತ್ವದ ಪ್ರಕಾರಗಳು ಮತ್ತು ಸ್ಥಳೀಯ ಸರ್ಕಾರಗಳು", 13, "Easy"),
        // ಭಾಗ 3 — ಭೂಗೋಳ
        UnitTemplate(10, "ಭೂಗೋಳ: ಅಧ್ಯಾಯ 10 - ನಮ್ಮ ಭೂಮಿ ಮತ್ತು ಸೌರವ್ಯೂಹ", 13, "Medium"),
        UnitTemplate(11, "ಭೂಗೋಳ: ಅಧ್ಯಾಯ 11 - ಭೂಗೋಳದ ಪರಿಕರಗಳು: ಗೋಳ ಮತ್ತು ನಕ್ಷೆಗಳು", 8, "Easy"),
        UnitTemplate(12, "ಭೂಗೋಳ: ಅಧ್ಯಾಯ 12 - ಏಷ್ಯಾ: ವೈವಿಧ್ಯತೆಗಳ ಖಂಡ", 11, "Medium")
    )

    val questions: List<QuestionModel> = listOf(
        // ==========================================
        // ಭಾಗ 1 — ಇತಿಹಾಸ
        // ಅಧ್ಯಾಯ 1: ಇತಿಹಾಸ ಪರಿಚಯ ಮತ್ತು ಆರಂಭಿಕ ಸಮಾಜ (18 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u1_1",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಇತಿಹಾಸದ ಪಿತಾಮಹ’ ಹೆರೊಡೋಟಸ್‌ನ ದೇಶ ಯಾವುದು?",
            options = listOf("ಗ್ರೀಸ್", "ರೋಮ್", "ಭಾರತ", "ಈಜಿಪ್ಟ್"),
            correctAnswer = "ಗ್ರೀಸ್",
            explanation = "ಹೆರೊಡೋಟಸ್ ಗ್ರೀಸ್ ದೇಶದ ಪ್ರಸಿದ್ಧ ಇತಿಹಾಸಕಾರರಾಗಿದ್ದು, ಇತಿಹಾಸದ ಪಿತಾಮಹ ಎಂದು ಪ್ರಸಿದ್ಧರಾಗಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u1_2",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಆಧಾರಗಳಿಲ್ಲದೆ ಇತಿಹಾಸವಿಲ್ಲ’ — ಇದಕ್ಕೆ ಆಧಾರಗಳು ಎಷ್ಟು ಬಗೆ?",
            options = listOf("2 ಬಗೆ", "3 ಬಗೆ", "4 ಬಗೆ", "5 ಬಗೆ"),
            correctAnswer = "2 ಬಗೆ",
            explanation = "ಇತಿಹಾಸ ರಚನೆಗೆ ಆಧಾರಗಳನ್ನು 2 ಬಗೆಯಾಗಿ ವಿಂಗಡಿಸಲಾಗಿದೆ: 1. ಸಾಹಿತ್ಯಿಕ ಆಧಾರಗಳು, 2. ಪುರಾತತ್ವ ಆಧಾರಗಳು."
        ),
        QuestionModel(
            id = "s_6_soc_u1_3",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬರೆದ ಲಿಪಿಯಿಲ್ಲದ ಕಾಲವನ್ನು ಹೀಗೆನ್ನುವರು:",
            options = listOf("ಪ್ರಾಕ್ ಇತಿಹಾಸ ಕಾಲ", "ಐತಿಹಾಸಿಕ ಕಾಲ", "ಮಧ್ಯಕಾಲ", "ಆಧುನಿಕ ಕಾಲ"),
            correctAnswer = "ಪ್ರಾಕ್ ಇತಿಹಾಸ ಕಾಲ",
            explanation = "ಮಾನವನು ಲಿಪಿಯನ್ನು ಅರಿಯದಿದ್ದ ಕಾಲವನ್ನು ಪ್ರಾಕ್ ಇತಿಹಾಸ ಕಾಲ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u1_4",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಭಾರತದಲ್ಲಿ ಮೊದಲು ಬಳಸಿದ ಲೋಹ ಯಾವುದು?",
            options = listOf("ತಾಮ್ರ", "ಕಬ್ಬಿಣ", "ಚಿನ್ನ", "ಬೆಳ್ಳಿ"),
            correctAnswer = "ತಾಮ್ರ",
            explanation = "ಮಾನವನು ಮೊದಲು ಬಳಸಿದ ಲೋಹ ತಾಮ್ರ (ತಾಮ್ರ ಶಿಲಾಯುಗ)."
        ),
        QuestionModel(
            id = "s_6_soc_u1_5",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಹಳೆ ಶಿಲಾಯುಗದ ಮಾನವನು ಆಹಾರವನ್ನು ಹೇಗೆ ಪಡೆಯುತ್ತಿದ್ದನು?",
            options = listOf("ಬೇಟೆಯಾಡಿ ಮತ್ತು ಕಾಡು ಉತ್ಪನ್ನ ಸಂಗ್ರಹಿಸಿ", "ಕೃಷಿ ಮಾಡಿ", "ವ್ಯಾಪಾರ ಮಾಡಿ", "ಹೈನುಗಾರಿಕೆಯಿಂದ"),
            correctAnswer = "ಬೇಟೆಯಾಡಿ ಮತ್ತು ಕಾಡು ಉತ್ಪನ್ನ ಸಂಗ್ರಹಿಸಿ",
            explanation = "ಹಳೆ ಶಿಲಾಯುಗದ ಮಾನವನು ಅಲೆಮಾರಿಯಾಗಿದ್ದು ಬೇಟೆಯಾಡಿ ಆಹಾರ ಸಂಗ್ರಹಿಸುತ್ತಿದ್ದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u1_6",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮಾನವನು ಬೆಂಕಿಯನ್ನು ಕಂಡುಹಿಡಿದ ಯುಗ ಯಾವುದು?",
            options = listOf("ಹಳೆ ಶಿಲಾಯುಗ", "ನವ ಶಿಲಾಯುಗ", "ಕಬ್ಬಿಣ ಯುಗ", "ತಾಮ್ರ ಶಿಲಾಯುಗ"),
            correctAnswer = "ಹಳೆ ಶಿಲಾಯುಗ",
            explanation = "ಹಳೆ ಶಿಲಾಯುಗದಲ್ಲಿ ಮಾನವನು ಕಲ್ಲುಗಳ ಘರ್ಷಣೆಯಿಂದ ಬೆಂಕಿಯನ್ನು ಕಂಡುಹಿಡಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u1_7",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಚಕ್ರದ ಆವಿಷ್ಕಾರವಾದ ಕಾಲ ಯಾವುದು?",
            options = listOf("ನವ ಶಿಲಾಯುಗ", "ಹಳೆ ಶಿಲಾಯುಗ", "ಮಧ್ಯ ಶಿಲಾಯುಗ", "ಕಬ್ಬಿಣ ಯುಗ"),
            correctAnswer = "ನವ ಶಿಲಾಯುಗ",
            explanation = "ನವ ಶಿಲಾಯುಗದಲ್ಲಿ ಚಕ್ರದ ಆವಿಷ್ಕಾರವಾಗಿ ಮಡಕೆ ತಯಾರಿಕೆ ಮತ್ತು ಸಾರಿಗೆ ಸುಲಭವಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u1_8",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ನಾಣ್ಯಗಳ ಅಧ್ಯಯನವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ನಾಣ್ಯಶಾಸ್ತ್ರ (ನ್ಯೂಮಿಸ್ಮ್ಯಾಟಿಕ್ಸ್)", "ಶಾಸನಶಾಸ್ತ್ರ", "ಪುರಾತತ್ವಶಾಸ್ತ್ರ", "ಇತಿಹಾಸಶಾಸ್ತ್ರ"),
            correctAnswer = "ನಾಣ್ಯಶಾಸ್ತ್ರ (ನ್ಯೂಮಿಸ್ಮ್ಯಾಟಿಕ್ಸ್)",
            explanation = "ನಾಣ್ಯಗಳ ವೈಜ್ಞಾನಿಕ ಅಧ್ಯಯನವನ್ನು ನಾಣ್ಯಶಾಸ್ತ್ರ (Numismatics) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u1_9",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಶಾಸನಗಳ ಅಧ್ಯಯನಕ್ಕೆ ಹೀಗೆನ್ನುವರು:",
            options = listOf("ಶಾಸನಶಾಸ್ತ್ರ (ಎಪಿಗ್ರಫಿ)", "ನಾಣ್ಯಶಾಸ್ತ್ರ", "ಮಾನವಶಾಸ್ತ್ರ", "ಭೂಗೋಳಶಾಸ್ತ್ರ"),
            correctAnswer = "ಶಾಸನಶಾಸ್ತ್ರ (ಎಪಿಗ್ರಫಿ)",
            explanation = "ಶಾಸನಗಳ ಅಧ್ಯಯನವನ್ನು ಎಪಿಗ್ರಫಿ (ಶಾಸನಶಾಸ್ತ್ರ) ಎಂದು ಕರೆಯುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u1_10",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದಲ್ಲಿ ಹಳೆ ಶಿಲಾಯುಗದ ನೆಲೆಗಳು ಕಂಡುಬಂದ ಸ್ಥಳ:",
            options = listOf("ಹುಣಸಗಿ ಮತ್ತು ಕಿಬ್ಬನಹಳ್ಳಿ", "ಹಂಪೆ", "ಬನವಾಸಿ", "ತಲಕಾಡು"),
            correctAnswer = "ಹುಣಸಗಿ ಮತ್ತು ಕಿಬ್ಬನಹಳ್ಳಿ",
            explanation = "ಯಾದಗಿರಿ ಜಿಲ್ಲೆಯ ಹುಣಸಗಿ ಹಾಗೂ ತುಮಕೂರು ಜಿಲ್ಲೆಯ ಕಿಬ್ಬನಹಳ್ಳಿಯಲ್ಲಿ ಹಳೆ ಶಿಲಾಯುಗದ ಆಯುಧಗಳು ದೊರೆತಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u1_11",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಇತಿಹಾಸವೆಂದರೆ ______ ಗತಿಯ ಕ್ರಮಬದ್ಧ ಅಧ್ಯಯನ.",
            options = listOf("ಗತಕಾಲದ ಘಟನೆಗಳ", "ಭವಿಷ್ಯದ ಕಲ್ಪನೆಗಳ", "ವರ್ತಮಾನದ ವಾರ್ತೆಗಳ", "ಕಟ್ಟುಕಥೆಗಳ"),
            correctAnswer = "ಗತಕಾಲದ ಘಟನೆಗಳ",
            explanation = "ಇತಿಹಾಸವೆಂದರೆ ಗತಕಾಲದಲ್ಲಿ ನಡೆದುಹೋದ ಸತ್ಯ ಘಟನೆಗಳ ಕ್ರಮಬದ್ಧ ಅಧ್ಯಯನವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u1_12",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸಾಹಿತ್ಯ ಆಧಾರಗಳಲ್ಲಿ ______ ಮತ್ತು ವಿದೇಶಿ ಸಾಹಿತ್ಯ ಎಂಬ ಎರಡು ವಿಧಗಳಿವೆ.",
            options = listOf("ದೇಶಿ ಸಾಹಿತ್ಯ", "ಮೌಖಿಕ ಸಾಹಿತ್ಯ", "ಜನಪದ ಸಾಹಿತ್ಯ", "ಶಾಸನ ಸಾಹಿತ್ಯ"),
            correctAnswer = "ದೇಶಿ ಸಾಹಿತ್ಯ",
            explanation = "ಸಾಹಿತ್ಯ ಆಧಾರಗಳನ್ನು ದೇಶಿ ಸಾಹಿತ್ಯ ಮತ್ತು ವಿದೇಶಿ ಸಾಹಿತ್ಯ ಎಂದು ವಿಂಗಡಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u1_13",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಭಾರತದ ಅತ್ಯಂತ ಪ್ರಾಚೀನ ಶಾಸನಗಳು ಯಾರಿಗೆ ಸೇರಿವೆ?",
            options = listOf("ಅಶೋಕ ಚಕ್ರವರ್ತಿಗೆ", "ಕನಿಷ್ಕನಿಗೆ", "ಪುಲಕೇಶಿಗೆ", "ಸಮುದ್ರಗುಪ್ತನಿಗೆ"),
            correctAnswer = "ಅಶೋಕ ಚಕ್ರವರ್ತಿಗೆ",
            explanation = "ಮೌರ್ಯ ಚಕ್ರವರ್ತಿ ಅಶೋಕನ ಶಾಸನಗಳು ಭಾರತದ ಅತ್ಯಂತ ಪ್ರಾಚೀನ ಶಾಸನಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u1_14",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮಾನವನು ಕೃಷಿಯನ್ನು ಪ್ರಾರಂಭಿಸಿದ ಶಿಲಾಯುಗ:",
            options = listOf("ನವ ಶಿಲಾಯುಗ", "ಹಳೆ ಶಿಲಾಯುಗ", "ಮಧ್ಯ ಶಿಲಾಯುಗ", "ಕಬ್ಬಿಣ ಯುಗ"),
            correctAnswer = "ನವ ಶಿಲಾಯುಗ",
            explanation = "ನವ ಶಿಲಾಯುಗದಲ್ಲಿ ಮಾನವನು ಕೃಷಿ ಮತ್ತು ಪಶುಪಾಲನೆಯನ್ನು ಪ್ರಾರಂಭಿಸಿ ನೆಲೆನಿಂತು ಬದುಕಲಾರಂಭಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u1_15",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮಾನವನು ಪ್ರಾಣಿಗಳನ್ನು ಪಳಗಿಸಲು ಆರಂಭಿಸಿದ ಕಾಲ:",
            options = listOf("ಮಧ್ಯ ಶಿಲಾಯುಗ", "ಹಳೆ ಶಿಲಾಯುಗ", "ಕಬ್ಬಿಣ ಯುಗ", "ತಾಮ್ರ ಯುಗ"),
            correctAnswer = "ಮಧ್ಯ ಶಿಲಾಯುಗ",
            explanation = "ಮಧ್ಯ ಶಿಲಾಯುಗದಲ್ಲಿ ನಾಯಿಯನ್ನು ಮೊಟ್ಟಮೊದಲು ಪಳಗಿಸಿ, ಪ್ರಾಣಿ ಪಾಲನೆಗೆ ಆರಂಭ ಮಾಡಲಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u1_16",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪುರಾತತ್ವ ಆಧಾರಗಳಲ್ಲಿ ಶಾಸನಗಳು, ನಾಣ್ಯಗಳು, ಸ್ಮಾರಕಗಳು ಮತ್ತು ______ ಸೇರಿವೆ.",
            options = listOf("ಭೌತಿಕ ಅವಶೇಷಗಳು", "ಜನಪದ ಕಥೆಗಳು", "ಕಾವ್ಯಗಳು", "ನಾಟಕಗಳು"),
            correctAnswer = "ಭೌತಿಕ ಅವಶೇಷಗಳು",
            explanation = "ಉತ್ಖನನದಲ್ಲಿ ಸಿಗುವ ಮಡಕೆ, ಆಯುಧ ಮುಂತಾದ ಭೌತಿಕ ಅವಶೇಷಗಳು ಪ್ರಮುಖ ಪುರಾತತ್ವ ಆಧಾರಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u1_17",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮೈಕ್ರೋಲಿತ್ಸ್ (ಸೂಕ್ಷ್ಮ ಶಿಲಾಯುಧಗಳು) ಕಂಡುಬರುವ ಯುಗ:",
            options = listOf("ಮಧ್ಯ ಶಿಲಾಯುಗ", "ಹಳೆ ಶಿಲಾಯುಗ", "ನವ ಶಿಲಾಯುಗ", "ಕಬ್ಬಿಣ ಯುಗ"),
            correctAnswer = "ಮಧ್ಯ ಶಿಲಾಯುಗ",
            explanation = "ಮಧ್ಯ ಶಿಲಾಯುಗದ ವಿಶಿಷ್ಟ ಲಕ್ಷಣವೆಂದರೆ ಸಣ್ಣ ಮತ್ತು ಹರಿತವಾದ ಸೂಕ್ಷ್ಮ ಶಿಲಾಯುಧಗಳು (ಮೈಕ್ರೋಲಿತ್ಸ್)."
        ),
        QuestionModel(
            id = "s_6_soc_u1_18",
            stdId = 6,
            subjectId = "social",
            unitId = 1,
            type = "MCQ",
            questionText = "ಭಾರತದಲ್ಲಿ ಮೊದಲು ವ್ಯವಸಾಯ ಆರಂಭವಾದ ಪ್ರಮುಖ ಪ್ರಾಚೀನ ತಾಣ:",
            options = listOf("ಮೆಹರ್‌ಗಢ್", "ಹರಪ್ಪ", "ಲೋಥಾಲ್", "ಕಾಲಿಬಂಗನ್"),
            correctAnswer = "ಮೆಹರ್‌ಗಢ್",
            explanation = "ಬಲೂಚಿಸ್ತಾನದ ಮೆಹರ್‌ಗಢ್‌ನಲ್ಲಿ ಕ್ರಿ.ಪೂ. 7000 ರ ಸುಮಾರಿನ ಕೃಷಿಯ ಆರಂಭಿಕ ಕುರುಹುಗಳು ದೊರೆತಿವೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 2: ನಮ್ಮ ಕರ್ನಾಟಕ (ಕಂದಾಯ ವಿಭಾಗಗಳು) (19 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u2_1",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದಲ್ಲಿರುವ ಒಟ್ಟು ಕಂದಾಯ ವಿಭಾಗಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("4", "5", "6", "3"),
            correctAnswer = "4",
            explanation = "ಕರ್ನಾಟಕದಲ್ಲಿ 4 ಕಂದಾಯ ವಿಭಾಗಗಳಿವೆ: ಬೆಂಗಳೂರು, ಮೈಸೂರು, ಬೆಳಗಾವಿ ಮತ್ತು ಕಲಬುರಗಿ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_2",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬೆಂಗಳೂರು ವಿಭಾಗದಲ್ಲಿರುವ ಜಿಲ್ಲೆಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("9", "8", "7", "6"),
            correctAnswer = "9",
            explanation = "ಬೆಂಗಳೂರು ಕಂದಾಯ ವಿಭಾಗದಲ್ಲಿ 9 ಜಿಲ್ಲೆಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_3",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ಅತ್ಯಂತ ಎತ್ತರವಾದ ಶಿಖರ ಮುಳ್ಳಯ್ಯನಗಿರಿ ಯಾವ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ?",
            options = listOf("ಚಿಕ್ಕಮಗಳೂರು", "ಶಿವಮೊಗ್ಗ", "ಹಾಸನ", "ಕೊಡಗು"),
            correctAnswer = "ಚಿಕ್ಕಮಗಳೂರು",
            explanation = "ಮುಳ್ಳಯ್ಯನಗಿರಿ ಶಿಖರವು ಚಿಕ್ಕಮಗಳೂರು ಜಿಲ್ಲೆಯಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_4",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ವಿಶ್ವಪ್ರಸಿದ್ಧ ಜೋಗ ಜಲಪಾತ ಯಾವ ನದಿಯಿಂದ ಸೃಷ್ಟಿಯಾಗಿದೆ?",
            options = listOf("ಶರಾವತಿ", "ಕಾವೇರಿ", "ತುಂಗಭದ್ರಾ", "ಘಟಪ್ರಭಾ"),
            correctAnswer = "ಶರಾವತಿ",
            explanation = "ಜೋಗ ಜಲಪಾತವು ಶಿವಮೊಗ್ಗ ಜಿಲ್ಲೆಯ ಶರಾವತಿ ನದಿಯಿಂದ ನಿರ್ಮಾಣವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_5",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಭಾರತದ ಸಿಲಿಕಾನ್ ಸಿಟಿ ಎಂದು ಪ್ರಸಿದ್ಧವಾಗಿರುವ ನಗರ:",
            options = listOf("ಬೆಂಗಳೂರು", "ಮೈಸೂರು", "ಮಂಗಳೂರು", "ಹುಬ್ಬಳ್ಳಿ"),
            correctAnswer = "ಬೆಂಗಳೂರು",
            explanation = "ಮಾಹಿತಿ ತಂತ್ರಜ್ಞಾನದ ಕೇಂದ್ರವಾಗಿರುವ ಬೆಂಗಳೂರನ್ನು ಸಿಲಿಕಾನ್ ಸಿಟಿ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_6",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬೆಳಗಾವಿ ವಿಭಾಗದಲ್ಲಿರುವ ಒಟ್ಟು ಜಿಲ್ಲೆಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("7", "6", "8", "5"),
            correctAnswer = "7",
            explanation = "ಬೆಳಗಾವಿ ಕಂದಾಯ ವಿಭಾಗದಲ್ಲಿ ಬೆಳಗಾವಿ, ಬಾಗಲಕೋಟೆ, ವಿಜಯಪುರ, ಧಾರವಾಡ, ಗದಗ, ಹಾವೇರಿ, ಉತ್ತರ ಕನ್ನಡ ಒಟ್ಟು 7 ಜಿಲ್ಲೆಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_7",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಏಷ್ಯಾದಲ್ಲೇ ಮೊದಲ ಬಾರಿಗೆ ಜಲವಿದ್ಯುತ್ ಉತ್ಪಾದಿಸಿದ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಶಿವನಸಮುದ್ರ", "ಲಿಂಗನಮಕ್ಕಿ", "ಸೂಪಾ", "ಆಲಮಟ್ಟಿ"),
            correctAnswer = "ಶಿವನಸಮುದ್ರ",
            explanation = "1902 ರಲ್ಲಿ ಕಾವೇರಿ ನದಿಯ ಶಿವನಸಮುದ್ರದಲ್ಲಿ ಮೊದಲ ಜಲವಿದ್ಯುತ್ ಕೇಂದ್ರ ಸ್ಥಾಪಿಸಲಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u2_8",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕಿತ್ತೂರು ರಾಣಿ ಚೆನ್ನಮ್ಮ ಬ್ರಿಟಿಷರ ವಿರುದ್ಧ ಹೋರಾಡಿದ ಜಿಲ್ಲೆ:",
            options = listOf("ಬೆಳಗಾವಿ", "ಧಾರವಾಡ", "ವಿಜಯಪುರ", "ಬಾಗಲಕೋಟೆ"),
            correctAnswer = "ಬೆಳಗಾವಿ",
            explanation = "ಕಿತ್ತೂರು ಸಂಸ್ಥಾನವು ಪ್ರಸ್ತುತ ಬೆಳಗಾವಿ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_9",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಗೋಲ್ ಗುಂಬಜ್ (ಗುಮ್ಮಟ ನಗರ) ಇರುವ ಸ್ಥಳ:",
            options = listOf("ವಿಜಯಪುರ", "ಬೀದರ್", "ಕಲಬುರಗಿ", "ರಾಯಚೂರು"),
            correctAnswer = "ವಿಜಯಪುರ",
            explanation = "ವಿಶ್ವಪ್ರಸಿದ್ಧ ಪಿಸುಗುಟ್ಟುವ ಹಜಾರ ಹೊಂದಿರುವ ಗೋಲ್ ಗುಂಬಜ್ ವಿಜಯಪುರದಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_10",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ‘ಕಾಶ್ಮೀರ’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ಜಿಲ್ಲೆ:",
            options = listOf("ಕೊಡಗು", "ಚಿಕ್ಕಮಗಳೂರು", "ಶಿವಮೊಗ್ಗ", "ಉತ್ತರ ಕನ್ನಡ"),
            correctAnswer = "ಕೊಡಗು",
            explanation = "ತಂಪಾದ ಹವಾಗುಣ ಮತ್ತು ಪ್ರಕೃತಿ ಸೌಂದರ್ಯದಿಂದ ಕೊಡಗನ್ನು ಕರ್ನಾಟಕದ ಕಾಶ್ಮೀರ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_11",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಮೈಸೂರು ವಿಭಾಗದಲ್ಲಿರುವ ಜಿಲ್ಲೆಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("8", "7", "6", "9"),
            correctAnswer = "8",
            explanation = "ಮೈಸೂರು ಕಂದಾಯ ವಿಭಾಗದಲ್ಲಿ 8 ಜಿಲ್ಲೆಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_12",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕಲಬುರಗಿ ವಿಭಾಗದಲ್ಲಿರುವ ಜಿಲ್ಲೆಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("7", "6", "8", "5"),
            correctAnswer = "7",
            explanation = "ಕಲಬುರಗಿ, ಬೀದರ್, ಯಾದಗಿರಿ, ರಾಯಚೂರು, ಕೊಪ್ಪಳ, ಬಳ್ಳಾರಿ, ವಿಜಯನಗರ ಸೇರಿದಂತೆ 7 ಜಿಲ್ಲೆಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_13",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ಸಾಂಸ್ಕೃತಿಕ ರಾಜಧಾನಿ ಎಂದು ಕರೆಯಲ್ಪಡುವ ನಗರ:",
            options = listOf("ಮೈಸೂರು", "ಬೆಂಗಳೂರು", "ಧಾರವಾಡ", "ಹಂಪಿ"),
            correctAnswer = "ಮೈಸೂರು",
            explanation = "ದಸರಾ ಮಹೋತ್ಸವ ಮತ್ತು ಪರಂಪರೆಗೆ ಹೆಸರಾದ ಮೈಸೂರನ್ನು ಸಾಂಸ್ಕೃತಿಕ ರಾಜಧಾನಿ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_14",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ಪ್ರಸಿದ್ಧ ಚಿನ್ನದ ಗಣಿ ಇರುವ ಕೋಲಾರ ಯಾವ ಕಂದಾಯ ವಿಭಾಗಕ್ಕೆ ಸೇರಿದೆ?",
            options = listOf("ಬೆಂಗಳೂರು ವಿಭಾಗ", "ಮೈಸೂರು ವಿಭಾಗ", "ಕಲಬುರಗಿ ವಿಭಾಗ", "ಬೆಳಗಾವಿ ವಿಭಾಗ"),
            correctAnswer = "ಬೆಂಗಳೂರು ವಿಭಾಗ",
            explanation = "ಕೋಲಾರ ಜಿಲ್ಲೆಯು ಬೆಂಗಳೂರು ಕಂದಾಯ ವಿಭಾಗದ ವ್ಯಾಪ್ತಿಗೆ ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_15",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಪ್ರಸಿದ್ಧ ಬಾದಾಮಿ, ಐಹೊಳೆ, ಪಟ್ಟದಕಲ್ಲು ಐತಿಹಾಸಿಕ ತಾಣಗಳು ಯಾವ ಜಿಲ್ಲೆಯಲ್ಲಿವೆ?",
            options = listOf("ಬಾಗಲಕೋಟೆ", "ವಿಜಯಪುರ", "ಗದಗ", "ಬೆಳಗಾವಿ"),
            correctAnswer = "ಬಾಗಲಕೋಟೆ",
            explanation = "ಚಾಲುಕ್ಯರ ಶಿಲ್ಪಕಲಾ ತಾಣಗಳಾದ ಬಾದಾಮಿ, ಐಹೊಳೆ, ಪಟ್ಟದಕಲ್ಲು ಬಾಗಲಕೋಟೆ ಜಿಲ್ಲೆಯಲ್ಲಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_16",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ಪ್ರಮುಖ ಬಂದರು ‘ನವಮಂಗಳೂರು ಬಂದರು’ ಯಾವ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ?",
            options = listOf("ದಕ್ಷಿಣ ಕನ್ನಡ", "ಉತ್ತರ ಕನ್ನಡ", "ಉಡುಪಿ", "ಶಿವಮೊಗ್ಗ"),
            correctAnswer = "ದಕ್ಷಿಣ ಕನ್ನಡ",
            explanation = "ನವ ಮಂಗಳೂರು ಬಂದರು ದಕ್ಷಿಣ ಕನ್ನಡ ಜಿಲ್ಲೆಯ ಪಣಂಬೂರಿನಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_17",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಪ್ರಸಿದ್ಧ ಯುನೆಸ್ಕೋ ಪಾರಂಪರಿಕ ತಾಣ ‘ಹಂಪಿ’ ಯಾವ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ?",
            options = listOf("ವಿಜಯನಗರ", "ಬಳ್ಳಾರಿ", "ಕೊಪ್ಪಳ", "ರಾಯಚೂರು"),
            correctAnswer = "ವಿಜಯನಗರ",
            explanation = "ವಿಜಯನಗರ ಸಾಮ್ರಾಜ್ಯದ ರಾಜಧಾನಿಯಾಗಿದ್ದ ಹಂಪಿ ಹೊಸದಾಗಿ ರಚನೆಯಾದ ವಿಜಯನಗರ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_18",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕಲ್ಯಾಣ ಕರ್ನಾಟಕ ಪ್ರದೇಶಕ್ಕೆ ವಿಶೇಷ ಸ್ಥಾನಮಾನ ನೀಡುವ ಸಂವಿಧಾನದ ವಿಧಿ ಯಾವುದು?",
            options = listOf("371 (ಜೆ)", "370", "356", "352"),
            correctAnswer = "371 (ಜೆ)",
            explanation = "ಸಂವಿಧಾನದ 371 (ಜೆ) ವಿಧಿಯು ಕಲ್ಯಾಣ ಕರ್ನಾಟಕ ಭಾಗದ ಜಿಲ್ಲೆಗಳಿಗೆ ವಿಶೇಷ ಸ್ಥಾನಮಾನ ಒದಗಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_19",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಪ್ರಸಿದ್ಧ ಗೊಮ್ಮಟೇಶ್ವರ ಬಾಹುಬಲಿ ಏಕಶಿಲಾ ಪ್ರತಿಮೆ ಇರುವ ಶ್ರವಣಬೆಳಗೊಳ ಯಾವ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ?",
            options = listOf("ಹಾಸನ", "ಮಂಡ್ಯ", "ಮೈಸೂರು", "ತುಮಕೂರು"),
            correctAnswer = "ಹಾಸನ",
            explanation = "57 ಅಡಿ ಎತ್ತರದ ಗೊಮ್ಮಟೇಶ್ವರ ಪ್ರತಿಮೆ ಹಾಸನ ಜಿಲ್ಲೆಯ ಶ್ರವಣಬೆಳಗೊಳದಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_20",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬೆಳಗಾವಿ ವಿಭಾಗದಲ್ಲಿ ಜಿಲ್ಲೆಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("5", "6", "7", "8"),
            correctAnswer = "7",
            explanation = "ಬೆಳಗಾವಿ ಕಂದಾಯ ವಿಭಾಗದಲ್ಲಿ ಒಟ್ಟು 7 ಜಿಲ್ಲೆಗಳಿವೆ: ಬೆಳಗಾವಿ, ಬಾಗಲಕೋಟೆ, ವಿಜಯಪುರ, ಧಾರವಾಡ, ಗದಗ, ಹಾವೇರಿ, ಮತ್ತು ಉತ್ತರ ಕನ್ನಡ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_21",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕದಂಬರ ರಾಜಧಾನಿ ಯಾವುದು?",
            options = listOf("ಬನವಾಸಿ", "ಹಂಪಿ", "ಬಾದಾಮಿ", "ಮಾನ್ಯಖೇಟ"),
            correctAnswer = "ಬನವಾಸಿ",
            explanation = "ಕರ್ನಾಟಕದ ಪ್ರಥಮ ರಾಜಮನೆತನ ಕದಂಬರ ರಾಜಧಾನಿ ಉತ್ತರ ಕನ್ನಡ ಜಿಲ್ಲೆಯ ಬನವಾಸಿಯಾಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_6_soc_u2_22",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬಸವೇಶ್ವರರು ಐಕ್ಯರಾದ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಹಂಪಿ", "ಕೂಡಲಸಂಗಮ", "ತಲಕಾಡು", "ಬನವಾಸಿ"),
            correctAnswer = "ಕೂಡಲಸಂಗಮ",
            explanation = "ಜಗಜ್ಯೋತಿ ಬಸವೇಶ್ವರರು ಕೃಷ್ಣಾ ಮತ್ತು ಮಲಪ್ರಭಾ ನದಿಗಳ ಸಂಗಮ ಕ್ಷೇತ್ರವಾದ ಕೂಡಲಸಂಗಮದಲ್ಲಿ ಐಕ್ಯರಾದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u2_23",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೂಡಲಸಂಗಮ ಯಾವ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ?",
            options = listOf("ಬೆಳಗಾವಿ", "ವಿಜಯಪುರ", "ಬಾಗಲಕೋಟೆ", "ಧಾರವಾಡ"),
            correctAnswer = "ಬಾಗಲಕೋಟೆ",
            explanation = "ಕೂಡಲಸಂಗಮ ಪುಣ್ಯಕ್ಷೇತ್ರವು ಬಾಗಲಕೋಟೆ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_24",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಅಣಶಿ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ ಯಾವ ಜಿಲ್ಲೆಯಲ್ಲಿ ಇದೆ?",
            options = listOf("ಶಿವಮೊಗ್ಗ", "ಉತ್ತರ ಕನ್ನಡ", "ಹಾವೇರಿ", "ಬೆಳಗಾವಿ"),
            correctAnswer = "ಉತ್ತರ ಕನ್ನಡ",
            explanation = "ಅಣಶಿ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನವು (ಕಾಳಿ ಹುಲಿ ಸಂರಕ್ಷಿತ ಪ್ರದೇಶ) ಉತ್ತರ ಕನ್ನಡ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_25",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದಲ್ಲಿ ಅತಿ ಹೆಚ್ಚು ಅರಣ್ಯವಿರುವ ಜಿಲ್ಲೆ ಯಾವುದು?",
            options = listOf("ಮೈಸೂರು", "ಚಿಕ್ಕಮಗಳೂರು", "ಉತ್ತರ ಕನ್ನಡ", "ಧಾರವಾಡ"),
            correctAnswer = "ಉತ್ತರ ಕನ್ನಡ",
            explanation = "ಕರ್ನಾಟಕದಲ್ಲೇ ಅತ್ಯಧಿಕ ಅರಣ್ಯ ಪ್ರದೇಶವನ್ನು ಹೊಂದಿರುವ ಜಿಲ್ಲೆ ಉತ್ತರ ಕನ್ನಡ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_26",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಒಣ ಮೆಣಸಿನಕಾಯಿಗೆ ಪ್ರಸಿದ್ಧವಾದ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಬ್ಯಾಡಗಿ", "ಆಲಮಟ್ಟಿ", "ಬನವಾಸಿ", "ಕೂಡಲಸಂಗಮ"),
            correctAnswer = "ಬ್ಯಾಡಗಿ",
            explanation = "ಹಾವೇರಿ ಜಿಲ್ಲೆಯ ಬ್ಯಾಡಗಿಯು ಅಂತಾರಾಷ್ಟ್ರೀಯ ಮಟ್ಟದಲ್ಲಿ ಪ್ರಸಿದ್ಧವಾದ ಕೆಂಪು ಮೆಣಸಿನಕಾಯಿ ಮಾರುಕಟ್ಟೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_27",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೃಷ್ಣಾ ಮೇಲ್ದಂಡೆ ಯೋಜನೆಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ನವಿಲುತೀರ್ಥ", "ಆಲಮಟ್ಟಿ", "ಬಸವಸಾಗರ", "ಕಾರಂಜಾ"),
            correctAnswer = "ಆಲಮಟ್ಟಿ",
            explanation = "ಕೃಷ್ಣಾ ಮೇಲ್ದಂಡೆ ಯೋಜನೆಯ ಪ್ರಮುಖ ಜಲಾಶಯವೆಂದರೆ ಆಲಮಟ್ಟಿ (ಲಾಲ್ ಬಹದ್ದೂರ್ ಶಾಸ್ತ್ರಿ ಜಲಾಶಯ)."
        ),
        QuestionModel(
            id = "s_6_soc_u2_28",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬೆಳಗಾವಿ ವಿಭಾಗದಲ್ಲಿ ಸುಧಾರಿತ ಬೀಜಗಳನ್ನು ಉತ್ಪಾದಿಸುವ ಪ್ರಮುಖ ಕೇಂದ್ರ ಯಾವುದು?",
            options = listOf("ವಿಜಯಪುರ", "ಗದಗ", "ಹಾವೇರಿ", "ಉತ್ತರ ಕನ್ನಡ"),
            correctAnswer = "ಹಾವೇರಿ",
            explanation = "ಹಾವೇರಿ ಜಿಲ್ಲೆಯು ಸುಧಾರಿತ ಬೀಜೋತ್ಪಾದನೆಗೆ ಕರ್ನಾಟಕದ ಪ್ರಮುಖ ಕೇಂದ್ರವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_29",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ವಚನ ಪಿತಾಮಹ ಎಂದು ಯಾರನ್ನು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಬಸವಣ್ಣ", "ಫ. ಗು. ಹಳಕಟ್ಟಿ", "ಅಕ್ಕಮಹಾದೇವಿ", "ಅಲ್ಲಮಪ್ರಭು"),
            correctAnswer = "ಫ. ಗು. ಹಳಕಟ್ಟಿ",
            explanation = "ತಾಳೆಯೋಲೆಗಳಲ್ಲಿದ್ದ ವಚನಗಳನ್ನು ಸಂಗ್ರಹಿಸಿ, ಸಂಶೋಧಿಸಿ ಪ್ರಕಟಿಸಿದ ಡಾ. ಫ. ಗು. ಹಳಕಟ್ಟಿ ಅವರನ್ನು ‘ವಚನ ಪಿತಾಮಹ’ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_30",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬೆಳಗಾವಿ ವಿಭಾಗದ ಜಿಲ್ಲೆಗಳು ಕರ್ನಾಟಕದಲ್ಲಿ ಯಾವ ವರ್ಷ ವಿಲೀನಗೊಂಡವು?",
            options = listOf("1947", "1948", "1956", "1997"),
            correctAnswer = "1956",
            explanation = "1956 ರ ನವೆಂಬರ್ 1 ರಂದು ರಾಜ್ಯ ಪುನರ್ವಿಂಗಡಣೆಯ ಸಂದರ್ಭದಲ್ಲಿ ಬಾಂಬೆ ಪ್ರಾಂತ್ಯದಲ್ಲಿದ್ದ ಈ ಜಿಲ್ಲೆಗಳು ವಿಶಾಲ ಮೈಸೂರು ರಾಜ್ಯದಲ್ಲಿ ವಿಲೀನಗೊಂಡವು."
        ),
        QuestionModel(
            id = "s_6_soc_u2_31",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬ್ರಿಟಿಷರ ವಿರುದ್ಧ ಹೋರಾಟ ನಡೆಸಿದ ರಾಣಿ ಯಾರು?",
            options = listOf("ರಾಣಿ ಲಕ್ಷ್ಮೀಬಾಯಿ", "ಕಿತ್ತೂರು ರಾಣಿ ಚೆನ್ನಮ್ಮ", "ರಾಣಿ ಅಬ್ಬಕ್ಕ", "ಒನಕೆ ಓಬವ್ವ"),
            correctAnswer = "ಕಿತ್ತೂರು ರಾಣಿ ಚೆನ್ನಮ್ಮ",
            explanation = "ಬೆಳಗಾವಿ ಜಿಲ್ಲೆಯ ಕಿತ್ತೂರು ಸಂಸ್ಥಾನದ ರಾಣಿ ಚೆನ್ನಮ್ಮ ಬ್ರಿಟಿಷರ ವಿರುದ್ಧ ಸಶಸ್ತ್ರ ಹೋರಾಟ ನಡೆಸಿದ ವೀರವನಿತೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u2_32",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಹಾವೇರಿ, ಗದಗ ಮತ್ತು ಬಾಗಲಕೋಟೆ ಜಿಲ್ಲೆಗಳು ಯಾವ ವರ್ಷ ರಚನೆಯಾದವು?",
            options = listOf("1985", "1990", "1997", "2001"),
            correctAnswer = "1997",
            explanation = "1997 ರಲ್ಲಿ ಆಡಳಿತಾತ್ಮಕ ಅನುಕೂಲಕ್ಕಾಗಿ ಧಾರವಾಡ ಮತ್ತು ವಿಜಯಪುರ ಜಿಲ್ಲೆಗಳನ್ನು ವಿಭಜಿಸಿ ಹಾವೇರಿ, ಗದಗ ಮತ್ತು ಬಾಗಲಕೋಟೆ ಜಿಲ್ಲೆಗಳನ್ನು ರಚಿಸಲಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u2_33",
            stdId = 6,
            subjectId = "social",
            unitId = 2,
            type = "MCQ",
            questionText = "ಮುನವಳ್ಳಿ ವಕೀಲರ ನೇತೃತ್ವದಲ್ಲಿ ನಡೆದ ಸಂಸ್ಥಾನ ವಿಮೋಚನಾ ಹೋರಾಟದಲ್ಲಿ 8 ಜನ ಗಲ್ಲಿಗೇರಿದ ಸಂಸ್ಥಾನ ಯಾವುದು?",
            options = listOf("ಮೈಸೂರು", "ರಾಮದುರ್ಗ", "ಬನವಾಸಿ", "ಬೀದರ್"),
            correctAnswer = "ರಾಮದುರ್ಗ",
            explanation = "ಬೆಳಗಾವಿ ಜಿಲ್ಲೆಯ ರಾಮದುರ್ಗ ಸಂಸ್ಥಾನದ ವಿಮೋಚನಾ ಹೋರಾಟದಲ್ಲಿ ಸ್ವಾತಂತ್ರ್ಯ ಹೋರಾಟಗಾರರು ಬಲಿದಾನಗೈದರು."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 3: ಪ್ರಾಚೀನ ನಾಗರಿಕತೆಗಳು (12 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u3_1",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ಹರಪ್ಪ ನಾಗರಿಕತೆಯು ಯಾವ ನದಿಯ ಕಣಿವೆಯಲ್ಲಿ ವಿಕಸನಗೊಂಡಿತು?",
            options = listOf("ಸಿಂಧೂ ನದಿ", "ಗಂಗಾ ನದಿ", "ಬ್ರಹ್ಮಪುತ್ರ ನದಿ", "ಯಮುನಾ ನದಿ"),
            correctAnswer = "ಸಿಂಧೂ ನದಿ",
            explanation = "ಹರಪ್ಪ ನಾಗರಿಕತೆಯು ಸಿಂಧೂ ಮತ್ತು ಅದರ ಉಪನದಿಗಳ ಕಣಿವೆಯಲ್ಲಿ ಬೆಳೆಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u3_2",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮೊಹೆಂಜೊದಾರೊ ನಗರದಲ್ಲಿ ಕಂಡುಬಂದ ಅತ್ಯಂತ ಪ್ರಸಿದ್ಧ ರಚನೆ ಯಾವುದು?",
            options = listOf("ಬೃಹತ್ ಸ್ನಾನದ ಕೊಳ", "ಗೋಪುರ", "ಅರಮನೆ", "ಪಿರಮಿಡ್"),
            correctAnswer = "ಬೃಹತ್ ಸ್ನಾನದ ಕೊಳ",
            explanation = "ಮೊಹೆಂಜೊದಾರೋದ ಅತ್ಯಂತ ಗಮನಾರ್ಹ ಸಾರ್ವಜನಿಕ ಕಟ್ಟಡವೆಂದರೆ ‘ಬೃಹತ್ ಸ್ನಾನದ ಕೊಳ’ (Great Bath)."
        ),
        QuestionModel(
            id = "s_6_soc_u3_3",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಿಂಧೂ ನಾಗರಿಕತೆಯ ಪ್ರಸಿದ್ಧ ಹಡಗುಕಟ್ಟೆ (ಡಾಕ್‌ಯಾರ್ಡ್) ಎಲ್ಲಿ ದೊರೆತಿದೆ?",
            options = listOf("ಲೋಥಾಲ್", "ಕಾಲಿಬಂಗನ್", "ಹರಪ್ಪ", "ರೂಪಾರ್"),
            correctAnswer = "ಲೋಥಾಲ್",
            explanation = "ಗುಜರಾತ್‌ನ ಲೋಥಾಲ್‌ನಲ್ಲಿ ಕೃತಕ ಹಡಗುಕಟ್ಟೆ ಮತ್ತು ಸಾಗರೋತ್ತರ ವ್ಯಾಪಾರದ ಕುರುಹುಗಳು ಸಿಕ್ಕಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u3_4",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ನೈಲ್ ನದಿಯ ವರದಾನ’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ದೇಶ ಯಾವುದು?",
            options = listOf("ಈಜಿಪ್ಟ್", "ಮೆಸೊಪಟೋಮಿಯಾ", "ಚೀನಾ", "ಗ್ರೀಸ್"),
            correctAnswer = "ಈಜಿಪ್ಟ್",
            explanation = "ನೈಲ್ ನದಿಯ ಫಲವತ್ತತೆಯಿಂದ ಅಭಿವೃದ್ಧಿ ಹೊಂದಿದ್ದರಿಂದ ಈಜಿಪ್ಟನ್ನು ನೈಲ್ ನದಿಯ ವರದಾನ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u3_5",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ಈಜಿಪ್ಟಿನ ರಾಜರನ್ನು ಹೀಗೆಂದು ಕರೆಯುತ್ತಿದ್ದರು:",
            options = listOf("ಫೇರೋ", "ಚಕ್ರವರ್ತಿ", "ಸುಲ್ತಾನ", "ಜಾರ್"),
            correctAnswer = "ಫೇರೋ",
            explanation = "ಪ್ರಾಚೀನ ಈಜಿಪ್ಟಿನ ದೊರೆಗಳನ್ನು ‘ಫೇರೋ’ (Pharaoh) ಎಂದು ಕರೆಯಲಾಗುತ್ತಿತ್ತು."
        ),
        QuestionModel(
            id = "s_6_soc_u3_6",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮೆಸೊಪಟೋಮಿಯಾ ನಾಗರಿಕತೆ ಬೆಳೆದ ನದಿ ಕಣಿವೆಗಳು ಯಾವುವು?",
            options = listOf("ಟೈಗ್ರಿಸ್ ಮತ್ತು ಯುಫ್ರೆಟಿಸ್", "ಹೊವಾಂಗ್ ಹೋ ಮತ್ತು ಯಾಂಗ್ಟ್ಸಿ", "ನೈಲ್ ನದಿ", "ಸಿಂಧೂ ನದಿ"),
            correctAnswer = "ಟೈಗ್ರಿಸ್ ಮತ್ತು ಯುಫ್ರೆಟಿಸ್",
            explanation = "ಟೈಗ್ರಿಸ್ ಮತ್ತು ಯುಫ್ರೆಟಿಸ್ ನದಿಗಳ ನಡುವಿನ ಫಲವತ್ತಾದ ಭೂಮಿಯಲ್ಲಿ ಮೆಸೊಪಟೋಮಿಯಾ ನಾಗರಿಕತೆ ಬೆಳೆಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u3_7",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮೆಸೊಪಟೋಮಿಯಾದ ಪ್ರಸಿದ್ಧ ಮೆಟ್ಟಿಲು ಗೋಪುರಗಳನ್ನು ಏನೆನ್ನುತ್ತಾರೆ?",
            options = listOf("ಜಿಗ್ಗುರಾತ್", "ಪಿರಮಿಡ್", "ಸ್ತೂಪ", "ಪಗೋಡ"),
            correctAnswer = "ಜಿಗ್ಗುರಾತ್",
            explanation = "ಮೆಸೊಪಟೋಮಿಯಾದಲ್ಲಿ ದೇವರುಗಳ ಪೂಜೆಗೆ ನಿರ್ಮಿಸಿದ ಮೆಟ್ಟಿಲು ದೇವಾಲಯ-ಗೋಪುರಗಳನ್ನು ಜಿಗ್ಗುರಾತ್ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u3_8",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "‘ಕಣ್ಣಿಗೆ ಕಣ್ಣು, ಹಲ್ಲಿಗೆ ಹಲ್ಲು’ ಎಂಬ ಕಠಿಣ ಕಾನೂನು ಸಂಹಿತೆ ರಚಿಸಿದ ಬ್ಯಾಬಿಲೋನಿಯಾದ ದೊರೆ:",
            options = listOf("ಹಮ್ಮುರಾಬಿ", "ನೆಬುಕಡ್ನೆಜರ್", "ಅಲೆಕ್ಸಾಂಡರ್", "ದರಿಯಸ್"),
            correctAnswer = "ಹಮ್ಮುರಾಬಿ",
            explanation = "ಹಮ್ಮುರಾಬಿಯ ನ್ಯಾಯ ಸಂಹಿತೆಯು ಪ್ರಾಚೀನ ವಿಶ್ವದ ಅತ್ಯಂತ ಪ್ರಸಿದ್ಧ ಕಾನೂನು ಸಂಗ್ರಹವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u3_9",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ಪ್ರಾಚೀನ ಚೀನಾದ ನಾಗರಿಕತೆಯು ಯಾವ ನದಿ ದಂಡೆಯ ಮೇಲೆ ಹುಟ್ಟಿಕೊಂಡಿತು?",
            options = listOf("ಹೊವಾಂಗ್ ಹೋ (ಹಳದಿ ನದಿ)", "ನೈಲ್", "ಗಂಗಾ", "ಮೆಕಾಂಗ್"),
            correctAnswer = "ಹೊವಾಂಗ್ ಹೋ (ಹಳದಿ ನದಿ)",
            explanation = "ಹೊವಾಂಗ್ ಹೋ ನದಿ ಕಣಿವೆಯಲ್ಲಿ ಚೀನೀ ನಾಗರಿಕತೆಯು ಹುಟ್ಟಿ ಬೆಳೆಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u3_10",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ವಿದೇಶಿ ಆಕ್ರಮಣಗಳನ್ನು ತಡೆಯಲು ಚೀನಾದ ಮಹಾಗೋಡೆಯನ್ನು ನಿರ್ಮಿಸಿದ ದೊರೆ:",
            options = listOf("ಶಿ ಹುವಾಂಗ್ ತಿ", "ಕುಬ್ಲೈ ಖಾನ್", "ಕಾನ್‌ಫ್ಯೂಷಿಯಸ್", "ಮಾವೋ"),
            correctAnswer = "ಶಿ ಹುವಾಂಗ್ ತಿ",
            explanation = "ಕ್ರಿ.ಪೂ. 3ನೇ ಶತಮಾನದಲ್ಲಿ ಕ್ವಿನ್ ರಾಜವಂಶದ ಚಕ್ರವರ್ತಿ ಶಿ ಹುವಾಂಗ್ ತಿ ಚೀನಾದ ಮಹಾಗೋಡೆಯನ್ನು ನಿರ್ಮಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u3_11",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ಈಜಿಪ್ಟಿನವರ ಚಿತ್ರಲಿಪಿಯನ್ನು ಹೀಗೆಂದು ಕರೆಯುತ್ತಾರೆ:",
            options = listOf("ಹೈರೋಗ್ಲಿಫಿಕ್ಸ್", "ಕ್ಯೂನಿಫಾರ್ಮ್", "ದೇವನಾಗರಿ", "ಬ್ರಾಹ್ಮೀ"),
            correctAnswer = "ಹೈರೋಗ್ಲಿಫಿಕ್ಸ್",
            explanation = "ಪ್ರಾಚೀನ ಈಜಿಪ್ಟಿನ ಪವಿತ್ರ ಚಿತ್ರಲಿಪಿಯನ್ನು ಹೈರೋಗ್ಲಿಫಿಕ್ಸ್ (Hieroglyphics) ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u3_12",
            stdId = 6,
            subjectId = "social",
            unitId = 3,
            type = "MCQ",
            questionText = "ಹರಪ್ಪ ನಾಗರಿಕತೆಯ ನಗರಗಳ ರಸ್ತೆಗಳು ಯಾವ ಕೋನದಲ್ಲಿ ಪರಸ್ಪರ ಛೇದಿಸುತ್ತಿದ್ದವು?",
            options = listOf("ಲಂಬಕೋನ (90°)", "ಲಘುಕೋನ", "ವಿಶಾಲಕೋನ", "ಸರಳಕೋನ"),
            correctAnswer = "ಲಂಬಕೋನ (90°)",
            explanation = "ಹರಪ್ಪ ನಗರಗಳಲ್ಲಿ ರಸ್ತೆಗಳು ಜಾಲರಿಯಂತಿದ್ದು (Grid system), ಪರಸ್ಪರ ಲಂಬಕೋನದಲ್ಲಿ ಕತ್ತರಿಸುತ್ತಿದ್ದವು."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 4: ವೇದ ಸಂಸ್ಕೃತಿ ಮತ್ತು ಹೊಸ ಧರ್ಮಗಳ ಉದಯ (9 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u4_1",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ವೇದಗಳಲ್ಲಿ ಅತ್ಯಂತ ಪ್ರಾಚೀನವಾದ ವೇದ ಯಾವುದು?",
            options = listOf("ಋಗ್ವೇದ", "ಯಜುರ್ವೇದ", "ಸಾಮವೇದ", "ಅಥರ್ವಣವೇದ"),
            correctAnswer = "ಋಗ್ವೇದ",
            explanation = "ನಾಲ್ಕು ವೇದಗಳಲ್ಲಿ ಋಗ್ವೇದವು ಅತ್ಯಂತ ಪ್ರಾಚೀನವಾದದ್ದು ಮತ್ತು 1028 ಸೂಕ್ತಗಳನ್ನು ಒಳಗೊಂಡಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_2",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಂಗೀತದ ಮೂಲವೆಂದು ಪರಿಗಣಿಸಲಾದ ವೇದ:",
            options = listOf("ಸಾಮವೇದ", "ಋಗ್ವೇದ", "ಯಜುರ್ವೇದ", "ಅಥರ್ವಣವೇದ"),
            correctAnswer = "ಸಾಮವೇದ",
            explanation = "ಸಾಮವೇದವು ಮಂತ್ರಗಳ ಗಾಯನ ಮತ್ತು ಭಾರತೀಯ ಶಾಸ್ತ್ರೀಯ ಸಂಗೀತದ ಮೂಲ ಗ್ರಂಥವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_3",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಜೈನ ಧರ್ಮದ 24ನೇ ಮತ್ತು ಕೊನೆಯ ತೀರ್ಥಂಕರರು ಯಾರು?",
            options = listOf("ವರ್ಧಮಾನ ಮಹಾವೀರ", "ಪಾರ್ಶ್ವನಾಥ", "ಋಷಭನಾಥ", "ಅರಿಷ್ಟನೇಮಿ"),
            correctAnswer = "ವರ್ಧಮಾನ ಮಹಾವೀರ",
            explanation = "ವರ್ಧಮಾನ ಮಹಾವೀರರು ಜೈನ ಧರ್ಮದ 24ನೇ ತೀರ್ಥಂಕರರು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_4",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಬೌದ್ಧ ಧರ್ಮದ ಸಂಸ್ಥಾಪಕರು ಯಾರು?",
            options = listOf("ಗೌತಮ ಬುದ್ಧ", "ಮಹಾವೀರ", "ಶಂಕರಾಚಾರ್ಯ", "ಗುರುನಾನಕ್"),
            correctAnswer = "ಗೌತಮ ಬುದ್ಧ",
            explanation = "ಗೌತಮ ಬುದ್ಧರು (ಸಿದ್ಧಾರ್ಥ) ಬೌದ್ಧ ಧರ್ಮದ ಸಂಸ್ಥಾಪಕರು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_5",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಬುದ್ಧನಿಗೆ ಜ್ಞಾನೋದಯವಾದ (ಬೋಧಿ) ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಗಯಾ (ಬೋಧಗಯಾ)", "ಲುಂಬಿನಿ", "ಸಾರನಾಥ", "ಕುಶಿನಗರ"),
            correctAnswer = "ಗಯಾ (ಬೋಧಗಯಾ)",
            explanation = "ಬಿಹಾರದ ಬೋಧಗಯಾದಲ್ಲಿ ಅರಳಿ ಮರದ ಕೆಳಗೆ ಸಿದ್ಧಾರ್ಥನಿಗೆ ಜ್ಞಾನೋದಯವಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_6",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಬುದ್ಧನು ತನ್ನ ಮೊದಲ ಧರ್ಮೋಪದೇಶ ನೀಡಿದ ಸ್ಥಳ:",
            options = listOf("ಸಾರನಾಥದ ಜಿಂಕೆ ವನ", "ಲುಂಬಿನಿ", "ಕುಶಿನಗರ", "ಪಾಟ್ಲಿಪುತ್ರ"),
            correctAnswer = "ಸಾರನಾಥದ ಜಿಂಕೆ ವನ",
            explanation = "ಬುದ್ಧನು ಸಾರನಾಥದಲ್ಲಿ ತನ್ನ ಪ್ರಥಮ ಪ್ರವಚನ ನೀಡಿದನು. ಇದನ್ನು ‘ಧರ್ಮಚಕ್ರ ಪ್ರವರ್ತನ’ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_7",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಜೈನ ಧರ್ಮದ ಮೂಲ ತತ್ವಗಳಲ್ಲಿ ಅತ್ಯಂತ ಮುಖ್ಯವಾದದ್ದು ಯಾವುದು?",
            options = listOf("ಅಹಿಂಸೆ", "ಸತ್ಯ", "ಅಸ್ತೇಯ", "ಅಪರಿಗ್ರಹ"),
            correctAnswer = "ಅಹಿಂಸೆ",
            explanation = "ಯಾವುದೇ ಜೀವಿಗೆ ಹಿಂಸೆ ಮಾಡದಿರುವುದು (ಅಹಿಂಸಾ ಪರಮೋ ಧರ್ಮಃ) ಜೈನ ಧರ್ಮದ ಕೇಂದ್ರ ತತ್ವ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_8",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಬುದ್ಧ ಬೋಧಿಸಿದ ದುಃಖ ನಿವಾರಣೆಯ ಮಾರ್ಗಕ್ಕೆ ಏನೆನ್ನುತ್ತಾರೆ?",
            options = listOf("ಅಷ್ಟಾಂಗ ಮಾರ್ಗ", "ತ್ರಿರತ್ನ", "ಪಂಚಶೀಲ", "ಚತುರ್ವೇದ"),
            correctAnswer = "ಅಷ್ಟಾಂಗ ಮಾರ್ಗ",
            explanation = "ಬುದ್ಧನು ದುಃಖ ನಿವಾರಣೆಗಾಗಿ ಎಂಟು ಉತ್ತಮ ಮಾರ್ಗಗಳಾದ ‘ಅಷ್ಟಾಂಗ ಮಾರ್ಗ’ವನ್ನು ಬೋಧಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_9",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಜೈನ ಧರ್ಮದ ಮೊದಲ ತೀರ್ಥಂಕರರು ಯಾರು?",
            options = listOf("ಋಷಭನಾಥ", "ಪಾರ್ಶ್ವನಾಥ", "ಮಹಾವೀರ", "ಶಾಂತಿನಾಥ"),
            correctAnswer = "ಋಷಭನಾಥ",
            explanation = "ಜೈನ ಧರ್ಮದ ಪ್ರಥಮ ತೀರ್ಥಂಕರರು ಋಷಭನಾಥ (ಆದಿನಾಥ)."
        ),
        QuestionModel(
            id = "s_6_soc_u4_10",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಪ್ರಾಚೀನ ಕಾಲದಲ್ಲಿ ಘಗ್ಗರ್–ಹಕ್ರಾ ನದಿಯನ್ನು ಯಾವ ಹೆಸರಿನಿಂದ ಕರೆಯಲಾಗುತ್ತಿತ್ತು?",
            options = listOf("ಗಂಗಾ ನದಿ", "ಸರಸ್ವತಿ ನದಿ", "ಯಮುನಾ ನದಿ", "ಸಿಂಧೂ ನದಿ"),
            correctAnswer = "ಸರಸ್ವತಿ ನದಿ",
            explanation = "ಋಗ್ವೇದ ಕಾಲದ ಪವಿತ್ರ ಸರಸ್ವತಿ ನದಿಯನ್ನೇ ಘಗ್ಗರ್-ಹಕ್ರಾ ನದಿ ಎಂದು ಗುರುತಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_11",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಉತ್ತರ ವೇದಕಾಲದಲ್ಲಿ ಕಣ್ಮರೆಯಾದ ರಾಜಕೀಯ ಸಂಸ್ಥೆ ಯಾವುದು?",
            options = listOf("ಸಭಾ", "ಸಮಿತಿ", "ವಿಧಾತ", "ಗ್ರಾಮ"),
            correctAnswer = "ವಿಧಾತ",
            explanation = "ಪೂರ್ವ ವೇದಕಾಲದಲ್ಲಿದ್ದ ಅತ್ಯಂತ ಪ್ರಾಚೀನ ಜನಪದ ಸಭೆಯಾದ ‘ವಿಧಾತ’ ಉತ್ತರ ವೇದಕಾಲದಲ್ಲಿ ಕಣ್ಮರೆಯಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_12",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಋಗ್ವೇದದ ಕಾಲವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಉತ್ತರ ವೇದಕಾಲ", "ಪೂರ್ವ ವೇದಕಾಲ", "ಮೌರ್ಯಕಾಲ", "ಗುಪ್ತಕಾಲ"),
            correctAnswer = "ಪೂರ್ವ ವೇದಕಾಲ",
            explanation = "ಋಗ್ವೇದ ರಚನೆಯಾದ ಕಾಲವನ್ನು ಪೂರ್ವ ವೇದಕಾಲ ಅಥವಾ ಆರಂಭಿಕ ವೇದಕಾಲ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_13",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಮಹಾಭಾರತವನ್ನು ಬರೆದವರು ಯಾರು?",
            options = listOf("ವಾಲ್ಮೀಕಿ", "ಕಾಳಿದಾಸ", "ವೇದವ್ಯಾಸ", "ಬಾಣಭಟ್ಟ"),
            correctAnswer = "ವೇದವ್ಯಾಸ",
            explanation = "ಮಹರ್ಷಿ ವೇದವ್ಯಾಸರು ಮಹಾಭಾರತ ಮಹಾಕಾವ್ಯವನ್ನು ರಚಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_14",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗೌತಮ ಬುದ್ಧನು ಜನಿಸಿದ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಸಾರನಾಥ", "ಲುಂಬಿನಿ ವನ", "ಬೋಧಗಯಾ", "ಕುಶಿನಗರ"),
            correctAnswer = "ಲುಂಬಿನಿ ವನ",
            explanation = "ಗೌತಮ ಬುದ್ಧನು ನೇಪಾಳದ ತಪ್ಪಲಿನಲ್ಲಿರುವ ಲುಂಬಿನಿ ವನದಲ್ಲಿ ಶಾಕ್ಯ ವಂಶದಲ್ಲಿ ಜನಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_15",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗೌತಮ ಬುದ್ಧನ ಬಾಲ್ಯದ ಹೆಸರು ಯಾವುದು?",
            options = listOf("ವರ್ಧಮಾನ", "ಸಿದ್ಧಾರ್ಥ", "ಅಶೋಕ", "ಮಹಾವೀರ"),
            correctAnswer = "ಸಿದ್ಧಾರ್ಥ",
            explanation = "ಗೌತಮ ಬುದ್ಧನಿಗೆ ತಂದೆ-ತಾಯಿ ಇಟ್ಟ ಬಾಲ್ಯದ ಹೆಸರು ಸಿದ್ಧಾರ್ಥ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_16",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಿದ್ಧಾರ್ಥನ ಭವಿಷ್ಯದ ಬಗ್ಗೆ ನುಡಿದ ಮಹರ್ಷಿ ಯಾರು?",
            options = listOf("ವಾಲ್ಮೀಕಿ", "ಅಸಿತ", "ವೇದವ್ಯಾಸ", "ಕಪಿಲ"),
            correctAnswer = "ಅಸಿತ",
            explanation = "ಅಸಿತ ಮಹರ್ಷಿಯು ಸಿದ್ಧಾರ್ಥ ಚಕ್ರವರ್ತಿಯಾಗುವನು ಅಥವಾ ಜಗತ್ಪ್ರಸಿದ್ಧ ತಪಸ್ವಿಯಾಗುವನು ಎಂದು ಭವಿಷ್ಯ ನುಡಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_17",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗೌತಮ ಬುದ್ಧನಿಗೆ ಜ್ಞಾನೋದಯವಾದ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಬಿಹಾರದ ಗಯಾ", "ಲುಂಬಿನಿ", "ವೈಶಾಲಿ", "ಶ್ರವಣಬೆಳಗೊಳ"),
            correctAnswer = "ಬಿಹಾರದ ಗಯಾ",
            explanation = "ಬಿಹಾರದ ಗಯಾದಲ್ಲಿ ಬೋಧಿ ವೃಕ್ಷದ ಕೆಳಗೆ ಧ್ಯಾನನಿರತನಾಗಿದ್ದಾಗ ಬುದ್ಧನಿಗೆ ಜ್ಞಾನೋದಯವಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_18",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "‘ಬುದ್ಧ’ ಪದದ ಅರ್ಥವೇನು?",
            options = listOf("ರಾಜ", "ಯೋಧ", "ಜ್ಞಾನಿ", "ಗುರು"),
            correctAnswer = "ಜ್ಞಾನಿ",
            explanation = "‘ಬುದ್ಧ’ ಎಂದರೆ ಪರಮ ಜ್ಞಾನವನ್ನು ಪಡೆದ ಜ್ಞಾನಿ ಅಥವಾ ಜಾಗೃತನಾದವನು ಎಂದರ್ಥ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_19",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಅಷ್ಟಾಂಗ ಮಾರ್ಗ ಮತ್ತು ಆರ್ಯ ಸತ್ಯಗಳನ್ನು ಪ್ರತಿಪಾದಿಸಿದವರು ಯಾರು?",
            options = listOf("ಮಹಾವೀರ", "ಗೌತಮ ಬುದ್ಧ", "ಅಶೋಕ", "ವೃಷಭನಾಥ"),
            correctAnswer = "ಗೌತಮ ಬುದ್ಧ",
            explanation = "ನಾಲ್ಕು ಆರ್ಯ ಸತ್ಯಗಳು ಮತ್ತು ಅಷ್ಟಾಂಗ ಮಾರ್ಗವನ್ನು ಗೌತಮ ಬುದ್ಧರು ಜಗತ್ತಿಗೆ ಬೋಧಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_20",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಬುದ್ಧನ ಉಪದೇಶಗಳು ಇರುವ ಪ್ರಾಚೀನ ಗ್ರಂಥ ಯಾವುದು?",
            options = listOf("ವೇದಗಳು", "ತ್ರಿಪಿಟಕಗಳು", "ರಾಮಾಯಣ", "ಅರ್ಥಶಾಸ್ತ್ರ"),
            correctAnswer = "ತ್ರಿಪಿಟಕಗಳು",
            explanation = "ಬುದ್ಧನ ತತ್ವಗಳು ಮತ್ತು ಬೋಧನೆಗಳನ್ನು ವಿನಯ, ಸುತ್ತ ಮತ್ತು ಅಭಿಧಮ್ಮ ಎಂಬ ತ್ರಿಪಿಟಕಗಳಲ್ಲಿ ಸಂಗ್ರಹಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_21",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಜೈನ ಧರ್ಮದ ಮೊದಲ ತೀರ್ಥಂಕರ ಯಾರು?",
            options = listOf("ಪಾರ್ಶ್ವನಾಥ", "ಮಹಾವೀರ", "ವೃಷಭನಾಥ", "ಗೌತಮ ಬುದ್ಧ"),
            correctAnswer = "ವೃಷಭನಾಥ",
            explanation = "ವೃಷಭನಾಥರು (ಆದಿನಾಥ) ಜೈನ ಧರ್ಮದ ಪ್ರಥಮ ತೀರ್ಥಂಕರರಾಗಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_22",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಮಹಾವೀರನ ಹಿಂದಿನ ಹೆಸರು ಯಾವುದು?",
            options = listOf("ಸಿದ್ಧಾರ್ಥ", "ವರ್ಧಮಾನ", "ಶುದ್ಧೋದನ", "ರಾಹುಲ"),
            correctAnswer = "ವರ್ಧಮಾನ",
            explanation = "ಮಹಾವೀರರ ಮೂಲ ಬಾಲ್ಯದ ಹೆಸರು ವರ್ಧಮಾನ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_23",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಮಹಾವೀರನ ಅನುಯಾಯಿಗಳನ್ನು ಯಾವ ಹೆಸರಿನಿಂದ ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ದಿಗಂಬರರು", "ಶಾಕ್ಯರು", "ಮೌರ್ಯರು", "ರಜಾಕಾರರು"),
            correctAnswer = "ದಿಗಂಬರರು",
            explanation = "ಮಹಾವೀರನ ಕಠಿಣ ತ್ಯಾಗ ಮಾರ್ಗವನ್ನು ಅನುಸರಿಸುವ ಜೈನ ಮುನಿಗಳನ್ನು ದಿಗಂಬರರು ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u4_24",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಜೈನ ಧರ್ಮದ 23ನೇ ತೀರ್ಥಂಕರ ಯಾರು?",
            options = listOf("ವೃಷಭನಾಥ", "ಪಾರ್ಶ್ವನಾಥ", "ಮಹಾವೀರ", "ಬಾಹುಬಲಿ"),
            correctAnswer = "ಪಾರ್ಶ್ವನಾಥ",
            explanation = "ಜೈನ ಧರ್ಮದ 23ನೇ ತೀರ್ಥಂಕರರು ಪಾರ್ಶ್ವನಾಥರು."
        ),
        QuestionModel(
            id = "s_6_soc_u4_25",
            stdId = 6,
            subjectId = "social",
            unitId = 4,
            type = "MCQ",
            questionText = "ಋಗ್ವೇದದಲ್ಲಿರುವ ಒಟ್ಟು ಸೂಕ್ತಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("1028", "1000", "500", "1500"),
            correctAnswer = "1028",
            explanation = "ಋಗ್ವೇದವು 10 ಮಂಡಲಗಳು ಮತ್ತು 1028 ಸೂಕ್ತಗಳಿಂದ ಕೂಡಿದ ಅತ್ಯಂತ ಪ್ರಾಚೀನ ಗ್ರಂಥವಾಗಿದೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 5: ಉತ್ತರ ಭಾರತದ ಪ್ರಮುಖ ರಾಜಮನೆತನಗಳು (10 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u5_1",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮೌರ್ಯ ಸಾಮ್ರಾಜ್ಯದ ಸ್ಥಾಪಕರು ಯಾರು?",
            options = listOf("ಚಂದ್ರಗುಪ್ತ ಮೌರ್ಯ", "ಅಶೋಕ", "ಬಿಂದುಸಾರ", "ಧನನಂದ"),
            correctAnswer = "ಚಂದ್ರಗುಪ್ತ ಮೌರ್ಯ",
            explanation = "ಕೌಟಿಲ್ಯನ ಮಾರ್ಗದರ್ಶನದಲ್ಲಿ ಚಂದ್ರಗುಪ್ತ ಮೌರ್ಯನು ಮೌರ್ಯ ಸಾಮ್ರಾಜ್ಯವನ್ನು ಸ್ಥಾಪಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u5_2",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಅರ್ಥಶಾಸ್ತ್ರ’ ಕೃತಿಯನ್ನು ರಚಿಸಿದ ಪ್ರಸಿದ್ಧ ರಾಜನೀತಿಜ್ಞ ಯಾರು?",
            options = listOf("ಕೌಟಿಲ್ಯ (ಚಾಣಕ್ಯ)", "ಮೆಗಾಸ್ತನೀಸ್", "ವಿಶಾಖದತ್ತ", "ಕಲ್ಹಣ"),
            correctAnswer = "ಕೌಟಿಲ್ಯ (ಚಾಣಕ್ಯ)",
            explanation = "ಕೌಟಿಲ್ಯನು ಆಡಳಿತ ಮತ್ತು ರಾಜನೀತಿಯ ಕುರಿತಾದ ವಿಶ್ವವಿಖ್ಯಾತ ‘ಅರ್ಥಶಾಸ್ತ್ರ’ವನ್ನು ರಚಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u5_3",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಇಂಡಿಕಾ’ ಗ್ರಂಥವನ್ನು ಬರೆದ ಗ್ರೀಕ್ ರಾಯಭಾರಿ ಯಾರು?",
            options = listOf("ಮೆಗಾಸ್ತನೀಸ್", "ಟಾಲೆಮಿ", "ಹ್ಯೂಯೆನ್‌ತ್ಸಾಂಗ್", "ಫಾಹಿಯಾನ್"),
            correctAnswer = "ಮೆಗಾಸ್ತನೀಸ್",
            explanation = "ಚಂದ್ರಗುಪ್ತ ಮೌರ್ಯನ ಆಸ್ಥಾನದಲ್ಲಿದ್ದ ಸೆಲ್ಯೂಕಸ್‌ನ ರಾಯಭಾರಿ ಮೆಗಾಸ್ತನೀಸ್ ‘ಇಂಡಿಕಾ’ ಕೃತಿ ರಚಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u5_4",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "ಅಶೋಕನು ಯುದ್ಧ ತ್ಯಜಿಸಿ ಬೌದ್ಧ ಧರ್ಮ ಸ್ವೀಕರಿಸಲು ಕಾರಣವಾದ ಕದನ:",
            options = listOf("ಕಳಿಂಗ ಯುದ್ಧ", "ಪಾಣಿಪತ್ ಕದನ", "ಪ್ಲಾಸಿ ಕದನ", "ತಾಲಿಕೋಟೆ ಯುದ್ಧ"),
            correctAnswer = "ಕಳಿಂಗ ಯುದ್ಧ",
            explanation = "ಕ್ರಿ.ಪೂ. 261 ರ ಕಳಿಂಗ ಯುದ್ಧದ ಭೀಕರ ರಕ್ತಪಾತದಿಂದ ಮನನೊಂದು ಅಶೋಕನು ಯುದ್ಧ ತ್ಯಜಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u5_5",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "ಕುಶಾಣರ ಅತ್ಯಂತ ಪ್ರಸಿದ್ಧ ದೊರೆ ಯಾರು?",
            options = listOf("ಕನಿಷ್ಕ", "ಕುಜುಲ ಕಡ್ಫಿಸಿಸ್", "ವಿಮ ಕಡ್ಫಿಸಿಸ್", "ಹುವಿಷ್ಕ"),
            correctAnswer = "ಕನಿಷ್ಕ",
            explanation = "ಕುಶಾಣ ವಂಶದ ಅತ್ಯಂತ ಶ್ರೇಷ್ಠ ದೊರೆ ಕನಿಷ್ಕ."
        ),
        QuestionModel(
            id = "s_6_soc_u5_6",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "ಕನಿಷ್ಕನ ಕಾಲದಲ್ಲಿ ಆರಂಭವಾದ ಶಕೆ ಯಾವುದು?",
            options = listOf("ಶಕ ವರ್ಷ (ಶಕ ಶಕೆ - ಕ್ರಿ.ಶ. 78)", "ವಿಕ್ರಮ ಶಕೆ", "ಗುಪ್ತ ಶಕೆ", "ಹಿಜರಿ ಶಕೆ"),
            correctAnswer = "ಶಕ ವರ್ಷ (ಶಕ ಶಕೆ - ಕ್ರಿ.ಶ. 78)",
            explanation = "ಕನಿಷ್ಕನು ಸಿಂಹಾಸನಾರೋಹಣ ಮಾಡಿದ ಕ್ರಿ.ಶ. 78 ರಲ್ಲಿ ಶಕ ಯುಗ ಪ್ರಾರಂಭವಾಯಿತು. ಇದನ್ನು ಭಾರತ ಸರ್ಕಾರ ಅಧಿಕೃತವಾಗಿ ಬಳಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u5_7",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಭಾರತದ ನೆಪೋಲಿಯನ್’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ಗುಪ್ತ ದೊರೆ:",
            options = listOf("ಸಮುದ್ರಗುಪ್ತ", "ಚಂದ್ರಗುಪ್ತ-1", "ಸ್ಕಂಧಗುಪ್ತ", "ಕುಮಾರಗುಪ್ತ"),
            correctAnswer = "ಸಮುದ್ರಗುಪ್ತ",
            explanation = "ವಿನ್‌ಸೆಂಟ್ ಸ್ಮಿತ್ ಸಮುದ್ರಗುಪ್ತನ ದಿಗ್ವಿಜಯಗಳನ್ನು ನೋಡಿ ಆತನನ್ನು ‘ಭಾರತದ ನೆಪೋಲಿಯನ್’ ಎಂದು ಕರೆದಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u5_8",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "‘ಕವಿರಾಜಮಾರ್ಗ’ ಪೂರ್ವದ ಕಾಲದಲ್ಲಿದ್ದ ಸಂಸ್ಕೃತ ಮಹಾಕವಿ ಕಾಳಿದಾಸನ ಆಸ್ಥಾನ ಯಾರದ್ದು?",
            options = listOf("ಎರಡನೇ ಚಂದ್ರಗುಪ್ತ (ವಿಕ್ರಮಾದಿತ್ಯ)", "ಅಶೋಕ", "ಹರ್ಷವರ್ಧನ", "ಕನಿಷ್ಕ"),
            correctAnswer = "ಎರಡನೇ ಚಂದ್ರಗುಪ್ತ (ವಿಕ್ರಮಾದಿತ್ಯ)",
            explanation = "ಕಾಳಿದಾಸನು ಎರಡನೇ ಚಂದ್ರಗುಪ್ತನ ನವರತ್ನಗಳಲ್ಲಿ ಅಗ್ರಗಣ್ಯನಾಗಿದ್ದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u5_9",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "ವರ್ಧನ ಸಾಮ್ರಾಜ್ಯದ ರಾಜಧಾನಿ ಕನೌಜ್ ಆಗಿದ್ದು, ಅವರ ಪ್ರಸಿದ್ಧ ದೊರೆ ಯಾರು?",
            options = listOf("ಹರ್ಷವರ್ಧನ", "ಪ್ರಭಾಕರವರ್ಧನ", "ರಾಜ್ಯವರ್ಧನ", "ಶಶಾಂಕ"),
            correctAnswer = "ಹರ್ಷವರ್ಧನ",
            explanation = "ಹರ್ಷವರ್ಧನನು ಉತ್ತರ ಭಾರತವನ್ನಾಳಿದ ವರ್ಧನ ವಂಶದ ಅಪ್ರತಿಮ ಚಕ್ರವರ್ತಿ."
        ),
        QuestionModel(
            id = "s_6_soc_u5_10",
            stdId = 6,
            subjectId = "social",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪ್ರಾಚೀನ ನಳಂದ ವಿಶ್ವವಿದ್ಯಾಲಯವು ಯಾರ ಆಶ್ರಯದಲ್ಲಿ ಜಾಗತಿಕ ಕೀರ್ತಿ ಪಡೆಯಿತು?",
            options = listOf("ಗುಪ್ತರು ಮತ್ತು ಹರ್ಷವರ್ಧನ", "ಮೌರ್ಯರು", "ಕುಶಾಣರು", "ಶುಂಗರು"),
            correctAnswer = "ಗುಪ್ತರು ಮತ್ತು ಹರ್ಷವರ್ಧನ",
            explanation = "ಕುಮಾರಗುಪ್ತ ಸ್ಥಾಪಿಸಿದ ನಳಂದ ವಿಶ್ವವಿದ್ಯಾಲಯಕ್ಕೆ ಹರ್ಷವರ್ಧನ ಅಪಾರ ದಾನ-ದತ್ತಿಗಳನ್ನು ನೀಡಿದನು."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 6: ದಕ್ಷಿಣ ಭಾರತದ ಪ್ರಮುಖ ರಾಜಮನೆತನಗಳು (12 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u6_1",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ದಕ್ಷಿಣ ಭಾರತದ ಮೊದಲ ರಾಜಮನೆತನ ಯಾವುದು?",
            options = listOf("ಶಾತವಾಹನರು", "ಕದಂಬರು", "ಗಂಗರು", "ಚಾಲುಕ್ಯರು"),
            correctAnswer = "ಶಾತವಾಹನರು",
            explanation = "ಶಾತವಾಹನರು ಮೌರ್ಯರ ನಂತರ ದಕ್ಷಿಣ ಭಾರತದಲ್ಲಿ ಆಳಿದ ಪ್ರಥಮ ಸಾಮ್ರಾಜ್ಯ ಸ್ಥಾಪಕರು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_2",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಶಾತವಾಹನರ ಅತ್ಯಂತ ಪ್ರಸಿದ್ಧ ದೊರೆ ಯಾರು?",
            options = listOf("ಗೌತಮೀಪುತ್ರ ಶಾತಕರ್ಣಿ", "ಸಿಮುಖ", "ಹಾಲ", "ಯಜ್ಞಶ್ರೀ ಶಾತಕರ್ಣಿ"),
            correctAnswer = "ಗೌತಮೀಪುತ್ರ ಶಾತಕರ್ಣಿ",
            explanation = "ಗೌತಮೀಪುತ್ರ ಶಾತಕರ್ಣಿಯು ಶಾತವಾಹನರ ಶ್ರೇಷ್ಠ ದೊರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u6_3",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ಮೊಟ್ಟಮೊದಲ ರಾಜಮನೆತನ ಯಾವುದು?",
            options = listOf("ಕದಂಬರು", "ಗಂಗರು", "ಚಾಲುಕ್ಯರು", "ರಾಷ್ಟ್ರಕೂಟರು"),
            correctAnswer = "ಕದಂಬರು",
            explanation = "ಮಯೂರವರ್ಮನು ಬನವಾಸಿಯನ್ನು ರಾಜಧಾನಿಯನ್ನಾಗಿ ಮಾಡಿಕೊಂಡು ಕದಂಬ ವಂಶವನ್ನು ಸ್ಥಾಪಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_4",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕನ್ನಡದ ಮೊಟ್ಟಮೊದಲ ಶಾಸನ ಯಾವುದು?",
            options = listOf("ಹಲ್ಮಿಡಿ ಶಾಸನ", "ಬಾದಾಮಿ ಶಾಸನ", "ಐಹೊಳೆ ಶಾಸನ", "ತಲಗುಂದ ಶಾಸನ"),
            correctAnswer = "ಹಲ್ಮಿಡಿ ಶಾಸನ",
            explanation = "ಹಾಸನ ಜಿಲ್ಲೆಯ ಹಲ್ಮಿಡಿಯಲ್ಲಿ ದೊರೆತ ಕದಂಬರ ಕಾಕುಸ್ಥವರ್ಮನ ಕಾಲದ ಶಾಸನವು ಕನ್ನಡದ ಪ್ರಥಮ ಶಾಸನವಾಗಿದೆ (ಕ್ರಿ.ಶ. 450)."
        ),
        QuestionModel(
            id = "s_6_soc_u6_5",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ತಲಕಾಡನ್ನು ರಾಜಧಾನಿಯನ್ನಾಗಿ ಮಾಡಿಕೊಂಡು ಆಳಿದ ರಾಜಮನೆತನ:",
            options = listOf("ಗಂಗರು", "ಕದಂಬರು", "ಚಾಲುಕ್ಯರು", "ಹೊಯ್ಸಳರು"),
            correctAnswer = "ಗಂಗರು",
            explanation = "ಗಂಗರು ದಕ್ಷಿಣ ಕರ್ನಾಟಕದ ತಲಕಾಡಿನಿಂದ ಬಹುಕಾಲ ಆಳ್ವಿಕೆ ನಡೆಸಿದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_6",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಶ್ರವಣಬೆಳಗೊಳದ ಗೊಮ್ಮಟೇಶ್ವರ ಪ್ರತಿಮೆಯನ್ನು ಕೆತ್ತಿಸಿದ ಗಂಗರ ಮಂತ್ರಿ ಯಾರು?",
            options = listOf("ಚಾವುಂಡರಾಯ", "ಮಾರ್ಸಿಂಹ", "ದುರ್ವಿನೀತ", "ರಾಚಮಲ್ಲ"),
            correctAnswer = "ಚಾವುಂಡರಾಯ",
            explanation = "ಗಂಗ ದೊರೆ ನಾಲ್ಕನೇ ರಾಚಮಲ್ಲನ ಮಂತ್ರಿ ಚಾವುಂಡರಾಯನು ಕ್ರಿ.ಶ. 981 ರಲ್ಲಿ ಗೊಮ್ಮಟೇಶ್ವರ ಮೂರ್ತಿಯನ್ನು ಪ್ರತಿಷ್ಠಾಪಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_7",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಬಾದಾಮಿ ಚಾಲುಕ್ಯರ ಅತ್ಯಂತ ಶ್ರೇಷ್ಠ ದೊರೆ ಯಾರು?",
            options = listOf("ಎರಡನೇ ಪುಲಕೇಶಿ", "ಮೊದಲನೇ ಪುಲಕೇಶಿ", "ಕೀರ್ತಿವರ್ಮ", "ಮಂಗಳೇಶ"),
            correctAnswer = "ಎರಡನೇ ಪುಲಕೇಶಿ",
            explanation = "ಎರಡನೇ ಪುಲಕೇಶಿಯು ಹರ್ಷವರ್ಧನನನ್ನು ನರ್ಮದಾ ನದಿ ತೀರದಲ್ಲಿ ಸೋಲಿಸಿ ‘ಪರಮೇಶ್ವರ’ ಬಿರುದು ಪಡೆದ ಪ್ರಖ್ಯಾತ ಚಕ್ರವರ್ತಿ."
        ),
        QuestionModel(
            id = "s_6_soc_u6_8",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಎರಡನೇ ಪುಲಕೇಶಿಯ ಸಾಧನೆಗಳನ್ನು ವರ್ಣಿಸುವ ಪ್ರಸಿದ್ಧ ‘ಐಹೊಳೆ ಶಾಸನ’ ರಚಿಸಿದ ಕವಿ:",
            options = listOf("ರವಿಕೀರ್ತಿ", "ಕಾಳಿದಾಸ", "ಪಂಪ", "ಭಾರವಿ"),
            correctAnswer = "ರವಿಕೀರ್ತಿ",
            explanation = "ಜೈನ ಕವಿ ರವಿಕೀರ್ತಿಯು ಕ್ರಿ.ಶ. 634 ರಲ್ಲಿ ಪ್ರಸಿದ್ಧ ಐಹೊಳೆ ಪ್ರಶಸ್ತಿಯನ್ನು ರಚಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_9",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಭಾರತೀಯ ದೇವಾಲಯ ವಾಸ್ತುಶಿಲ್ಪದ ತೊಟ್ಟಿಲು’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ತಾಣ:",
            options = listOf("ಐಹೊಳೆ", "ಬಾದಾಮಿ", "ಪಟ್ಟದಕಲ್ಲು", "ಹಳೇಬೀಡು"),
            correctAnswer = "ಐಹೊಳೆ",
            explanation = "ಚಾಲುಕ್ಯರ ಕಾಲದ ನೂರಾರು ದೇವಾಲಯಗಳಿರುವ ಐಹೊಳೆಯನ್ನು ಭಾರತೀಯ ವಾಸ್ತುಶಿಲ್ಪದ ತೊಟ್ಟಿಲು ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u6_10",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಎಲ್ಲೋರಾದ ವಿಶ್ವವಿಖ್ಯಾತ ಕೈಲಾಸನಾಥ ದೇವಾಲಯವನ್ನು ನಿರ್ಮಿಸಿದ ರಾಷ್ಟ್ರಕೂಟ ದೊರೆ:",
            options = listOf("ಒಂದನೇ ಕೃಷ್ಣ", "ದಂತಿದುರ್ಗ", "ಅಮೋಘವರ್ಷ ನೃಪತುಂಗ", "ಗೋವಿಂದ-3"),
            correctAnswer = "ಒಂದನೇ ಕೃಷ್ಣ",
            explanation = "ಒಂದೇ ಬೃಹತ್ ಬಂಡೆಯನ್ನು ಮೇಲಿಂದ ಕೆಳಕ್ಕೆ ಕೊರೆದು ಏಕಶಿಲಾ ಕೈಲಾಸನಾಥ ದೇವಾಲಯವನ್ನು ಒಂದನೇ ಕೃಷ್ಣ ನಿರ್ಮಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_11",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕನ್ನಡದ ಮೊಟ್ಟಮೊದಲ ಉಪಲಬ್ಧ ಲಕ್ಷಣ ಗ್ರಂಥ ‘ಕವಿರಾಜಮಾರ್ಗ’ ಯಾರ ಆಸ್ಥಾನದಲ್ಲಿ ರಚನೆಯಾಯಿತು?",
            options = listOf("ಅಮೋಘವರ್ಷ ನೃಪತುಂಗ", "ಎರಡನೇ ಪುಲಕೇಶಿ", "ಮಯೂರವರ್ಮ", "ಚಾವುಂಡರಾಯ"),
            correctAnswer = "ಅಮೋಘವರ್ಷ ನೃಪತುಂಗ",
            explanation = "ರಾಷ್ಟ್ರಕೂಟ ಚಕ್ರವರ್ತಿ ಅಮೋಘವರ್ಷ ನೃಪತುಂಗನ ಆಸ್ಥಾನ ಕವಿ ಶ್ರೀವಿಜಯನು ‘ಕವಿರಾಜಮಾರ್ಗ’ವನ್ನು ರಚಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_12",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕಾವೇರಿಯಿಂದ ಗೋದಾವರಿಯವರೆಗೆ ವಿಸ್ತರಿಸಿದ್ದ ಕನ್ನಡ ನಾಡಿನ ಗಡಿಯನ್ನು ಉಲ್ಲೇಖಿಸುವ ಕೃತಿ:",
            options = listOf("ಕವಿರಾಜಮಾರ್ಗ", "ವಿಕ್ರಮಾರ್ಜುನ ವಿಜಯ", "ಗದಾಯುದ್ಧ", "ಶಾಂತಿಪುರಾಣ"),
            correctAnswer = "ಕವಿರಾಜಮಾರ್ಗ",
            explanation = "‘ಕಾವೇರಿಯಿಂದಮಾ ಗೋದಾವರಿವರಮಿರ್ಪ ನಾಡದಾ ಕನ್ನಡದೊಳ್’ ಎಂದು ಕವಿರಾಜಮಾರ್ಗದಲ್ಲಿ ವರ್ಣಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u6_13",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ತಿರುಕ್ಕುರಳ್’ ಕೃತಿಯ ರಚನಾಕಾರರು ಯಾರು?",
            options = listOf("ಪಂಪ", "ತಿರುವಳ್ಳುವರ್", "ರನ್ನ", "ಪೊನ್ನ"),
            correctAnswer = "ತಿರುವಳ್ಳುವರ್",
            explanation = "ಪ್ರಾಚೀನ ತಮಿಳು ಸಾಹಿತ್ಯದ ಶ್ರೇಷ್ಠ ನೀತಿ ಗ್ರಂಥ ‘ತಿರುಕ್ಕುರಳ್’ ಅನ್ನು ತಿರುವಳ್ಳುವರ್ ರಚಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_14",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಶಾತವಾಹನರ ರಾಜಧಾನಿ ಯಾವುದು?",
            options = listOf("ಬನವಾಸಿ", "ವಾತಾಪಿ", "ಪ್ರತಿಷ್ಠಾನಪುರ", "ತಲಕಾಡು"),
            correctAnswer = "ಪ್ರತಿಷ್ಠಾನಪುರ",
            explanation = "ಶಾತವಾಹನರ ಮೂಲ ರಾಜಧಾನಿ ಮಹಾರಾಷ್ಟ್ರದ ಪೈಠಣ (ಪ್ರತಿಷ್ಠಾನಪುರ) ಆಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_15",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಕಾತಂತ್ರ ವ್ಯಾಕರಣ’ ಕೃತಿಯನ್ನು ಬರೆದವರು ಯಾರು?",
            options = listOf("ಸರ್ವವರ್ಮ", "ಕಾಳಿದಾಸ", "ಚಾವುಂಡರಾಯ", "ರನ್ನ"),
            correctAnswer = "ಸರ್ವವರ್ಮ",
            explanation = "ಶಾತವಾಹನ ರಾಜ ಹಾಲನ ಆಸ್ಥಾನದಲ್ಲಿದ್ದ ಸರ್ವವರ್ಮನು ಸರಳ ಸಂಸ್ಕೃತ ವ್ಯಾಕರಣ ಗ್ರಂಥ ‘ಕಾತಂತ್ರ ವ್ಯಾಕರಣ’ವನ್ನು ರಚಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_16",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಶಾತವಾಹನರ ಕಾಲದ ಪ್ರಮುಖ ಶಿಕ್ಷಣ ಕೇಂದ್ರ ಯಾವುದು?",
            options = listOf("ಹಂಪಿ", "ತಾಳಗುಂದ", "ಶಿವಮೊಗ್ಗ ಜಿಲ್ಲೆಯ ತಾಳಗುಂದ", "ಕಂಚಿ"),
            correctAnswer = "ಶಿವಮೊಗ್ಗ ಜಿಲ್ಲೆಯ ತಾಳಗುಂದ",
            explanation = "ಶಿವಮೊಗ್ಗ ಜಿಲ್ಲೆಯ ತಾಳಗುಂದವು ಶಾತವಾಹನರು ಮತ್ತು ಕದಂಬರ ಕಾಲದ ಪ್ರಸಿದ್ಧ ಅಗ್ರಹಾರ ಹಾಗೂ ಶಿಕ್ಷಣ ಕೇಂದ್ರವಾಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_17",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ಮೊದಲ ರಾಜಮನೆತನ ಯಾವುದು?",
            options = listOf("ಗಂಗರು", "ಕದಂಬರು", "ರಾಷ್ಟ್ರಕೂಟರು", "ಹೊಯ್ಸಳರು"),
            correctAnswer = "ಕದಂಬರು",
            explanation = "ಮಯೂರವರ್ಮನು ಸ್ಥಾಪಿಸಿದ ಕದಂಬ ರಾಜವಂಶವು ಕರ್ನಾಟಕದ ಪ್ರಥಮ ಸ್ಥಳೀಯ ರಾಜಮನೆತನವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u6_18",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕನ್ನಡದ ಮೊದಲ ಶಾಸನ ಯಾವುದು?",
            options = listOf("ಐಹೊಳೆ ಶಾಸನ", "ತಾಳಗುಂದ ಶಾಸನ", "ಹಲ್ಮಿಡಿ ಶಾಸನ", "ಅಶೋಕನ ಶಾಸನ"),
            correctAnswer = "ಹಲ್ಮಿಡಿ ಶಾಸನ",
            explanation = "ಹಾಸನ ಜಿಲ್ಲೆಯ ಹಲ್ಮಿಡಿಯಲ್ಲಿ ದೊರೆತ ಕದಂಬರ ಕಾಲದ ಶಿಲಾಶಾಸನವು ಕನ್ನಡದ ಪ್ರಥಮ ಶಾಸನವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u6_19",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಬಾದಾಮಿ ಯಾವ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ?",
            options = listOf("ಬಾಗಲಕೋಟೆ", "ಧಾರವಾಡ", "ಕಲಬುರಗಿ", "ಹಾಸನ"),
            correctAnswer = "ಬಾಗಲಕೋಟೆ",
            explanation = "ಚಾಲುಕ್ಯರ ರಾಜಧಾನಿಯಾಗಿದ್ದ ಬಾದಾಮಿ (ವಾತಾಪಿ) ಬಾಗಲಕೋಟೆ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u6_20",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಗಂಗರ ಪ್ರಸಿದ್ಧ ಸೇನಾನಿ ಮತ್ತು ಶಿಲ್ಪಿ ಯಾರು?",
            options = listOf("ಮಯೂರವರ್ಮ", "ಚಾವುಂಡರಾಯ", "ಇಮ್ಮಡಿ ಪುಲಕೇಶಿ", "ವಿಷ್ಣುವರ್ಧನ"),
            correctAnswer = "ಚಾವುಂಡರಾಯ",
            explanation = "ಗಂಗರ ಮಂತ್ರಿಯೂ, ಮಹಾಸೇನಾನಿಯೂ ಆಗಿದ್ದ ಚಾವುಂಡರಾಯನು ಗೊಮ್ಮಟೇಶ್ವರ ವಿಗ್ರಹವನ್ನು ನಿರ್ಮಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_21",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ನರ್ಮದಾ ನದಿಯ ತೀರದಲ್ಲಿ ಹರ್ಷವರ್ಧನನನ್ನು ಸೋಲಿಸಿದ ಚಾಲುಕ್ಯ ದೊರೆ ಯಾರು?",
            options = listOf("ಮೊದಲ ಪುಲಕೇಶಿ", "ಇಮ್ಮಡಿ ಪುಲಕೇಶಿ", "ಮೊದಲ ಕೃಷ್ಣ", "ನರಸಿಂಹವರ್ಮ"),
            correctAnswer = "ಇಮ್ಮಡಿ ಪುಲಕೇಶಿ",
            explanation = "ಬಾದಾಮಿ ಚಾಲುಕ್ಯ ದೊರೆ ಇಮ್ಮಡಿ ಪುಲಕೇಶಿಯು ಉತ್ತರ ಭಾರತದ ಹರ್ಷವರ್ಧನನ ದಂಡಯಾತ್ರೆಯನ್ನು ನರ್ಮದಾ ತೀರದಲ್ಲಿ ಹಿಮ್ಮೆಟ್ಟಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_6_soc_u6_22",
            stdId = 6,
            subjectId = "social",
            unitId = 6,
            type = "MCQ",
            questionText = "ಬಾದಾಮಿ ಚಾಲುಕ್ಯರ ಸಾಧನೆಗಳನ್ನು ವಿವರಿಸುವ ಪ್ರಸಿದ್ಧ ಶಾಸನ ಯಾವುದು?",
            options = listOf("ಹಲ್ಮಿಡಿ ಶಾಸನ", "ತಾಳಗುಂದ ಶಾಸನ", "ಐಹೊಳೆ ಶಾಸನ", "ಅಶೋಕನ ಶಾಸನ"),
            correctAnswer = "ಐಹೊಳೆ ಶಾಸನ",
            explanation = "ರವಿಕೀರ್ತಿಯು ರಚಿಸಿದ ಐಹೊಳೆ ಶಾಸನವು ಇಮ್ಮಡಿ ಪುಲಕೇಶಿಯ ವಿಜಯಗಳನ್ನು ಸವಿಸ್ತಾರವಾಗಿ ದಾಖಲಿಸಿದೆ."
        ),

        // ==========================================
        // ಭಾಗ 2 — ಪೌರನೀತಿ
        // ಅಧ್ಯಾಯ 7: ಪೌರತ್ವ ಮತ್ತು ರಾಷ್ಟ್ರೀಯ ಲಾಂಛನಗಳು (8 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u7_1",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ಭಾರತದ ಸಂವಿಧಾನವು ತನ್ನ ನಾಗರಿಕರಿಗೆ ನೀಡಿರುವ ಪೌರತ್ವದ ಸ್ವರೂಪ:",
            options = listOf("ಏಕ ಪೌರತ್ವ", "ದ್ವಿ ಪೌರತ್ವ", "ಬಹು ಪೌರತ್ವ", "ತಾತ್ಕಾಲಿಕ ಪೌರತ್ವ"),
            correctAnswer = "ಏಕ ಪೌರತ್ವ",
            explanation = "ಭಾರತದಾದ್ಯಂತ ಎಲ್ಲಾ ನಾಗರಿಕರಿಗೂ ಕೇವಲ ಒಂದೇ ಭಾರತೀಯ ಏಕ ಪೌರತ್ವವಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u7_2",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ನಮ್ಮ ರಾಷ್ಟ್ರಧ್ವಜದ ಉದ್ದ ಮತ್ತು ಅಗಲದ ಅನುಪಾತ ಎಷ್ಟು?",
            options = listOf("3:2", "2:3", "4:3", "3:1"),
            correctAnswer = "3:2",
            explanation = "ಭಾರತದ ತ್ರಿವರ್ಣ ಧ್ವಜದ ಉದ್ದ ಮತ್ತು ಅಗಲದ ಅನುಪಾತ 3:2 ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u7_3",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಾಷ್ಟ್ರಧ್ವಜದ ಮಧ್ಯದಲ್ಲಿರುವ ಅಶೋಕ ಚಕ್ರದಲ್ಲಿರುವ ಕಡ್ಡಿಗಳ (ಆರೆಗಳ) ಸಂಖ್ಯೆ:",
            options = listOf("24", "20", "28", "32"),
            correctAnswer = "24",
            explanation = "ಅಶೋಕ ಚಕ್ರದಲ್ಲಿ ಸಮಾನ ಅಂತರದಲ್ಲಿರುವ 24 ಕಡ್ಡಿಗಳಿವೆ, ಇದು ದಿನದ 24 ಗಂಟೆಗಳ ನಿರಂತರ ಪ್ರಗತಿಯ ಸಂಕೇತ."
        ),
        QuestionModel(
            id = "s_6_soc_u7_4",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ನಮ್ಮ ರಾಷ್ಟ್ರಗೀತೆ ‘ಜನಗಣಮನ’ವನ್ನು ರಚಿಸಿದವರು ಯಾರು?",
            options = listOf("ರವೀಂದ್ರನಾಥ ಟ್ಯಾಗೋರ್", "ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿ", "ಕುವೆಂಪು", "ಸರೋಜಿನಿ ನಾಯ್ಡು"),
            correctAnswer = "ರವೀಂದ್ರನಾಥ ಟ್ಯಾಗೋರ್",
            explanation = "ರವೀಂದ್ರನಾಥ ಟ್ಯಾಗೋರ್ ಅವರು ‘ಜನಗಣಮನ’ ರಾಷ್ಟ್ರಗೀತೆಯನ್ನು ರಚಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u7_5",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಾಷ್ಟ್ರಗೀತೆಯನ್ನು ಹಾಡಲು ನಿಗದಿಪಡಿಸಲಾದ ಕಾಲಾವಧಿ ಎಷ್ಟು?",
            options = listOf("52 ಸೆಕೆಂಡುಗಳು", "60 ಸೆಕೆಂಡುಗಳು", "45 ಸೆಕೆಂಡುಗಳು", "55 ಸೆಕೆಂಡುಗಳು"),
            correctAnswer = "52 ಸೆಕೆಂಡುಗಳು",
            explanation = "ರಾಷ್ಟ್ರಗೀತೆಯನ್ನು ಪೂರ್ಣವಾಗಿ ಹಾಡಲು ನಿಗದಿತ ಸಮಯ 52 ಸೆಕೆಂಡುಗಳು."
        ),
        QuestionModel(
            id = "s_6_soc_u7_6",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ಭಾರತದ ರಾಷ್ಟ್ರೀಯ ಪ್ರಾಣಿ ಯಾವುದು?",
            options = listOf("ಹುಲಿ", "ಸಿಂಹ", "ಆನೆ", "ಜಿಂಕೆ"),
            correctAnswer = "ಹುಲಿ",
            explanation = "ರಾಯಲ್ ಬೆಂಗಾಲ್ ಹುಲಿಯು ಭಾರತದ ರಾಷ್ಟ್ರೀಯ ಪ್ರಾಣಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u7_7",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಾಷ್ಟ್ರೀಯ ಲಾಂಛನದಲ್ಲಿರುವ ‘ಸತ್ಯಮೇವ ಜಯತೆ’ ವಾಕ್ಯವನ್ನು ಎಲ್ಲಿಂದ ಪಡೆಯಲಾಗಿದೆ?",
            options = listOf("ಮುಂಡಕೋಪನಿಷತ್", "ಋಗ್ವೇದ", "ಭಗವದ್ಗೀತೆ", "ರಾಮಾಯಣ"),
            correctAnswer = "ಮುಂಡಕೋಪನಿಷತ್",
            explanation = "‘ಸತ್ಯಮೇವ ಜಯತೆ’ (ಸತ್ಯವೇ ಗೆಲ್ಲುವುದು) ಎಂಬ ಘೋಷವಾಕ್ಯ ಮುಂಡಕೋಪನಿಷತ್ತಿನಿಂದ ಆಯ್ದುಕೊಳ್ಳಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u7_8",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ನಮ್ಮ ರಾಷ್ಟ್ರೀಯ ಗೀತೆ ‘ವಂದೇ ಮಾತರಂ’ ರಚಿಸಿದವರು ಯಾರು?",
            options = listOf("ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿ", "ರವೀಂದ್ರನಾಥ ಟ್ಯಾಗೋರ್", "ಸುಬ್ರಹ್ಮಣ್ಯ ಭಾರತಿ", "ಮಹಾತ್ಮಾ ಗಾಂಧಿ"),
            correctAnswer = "ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿ",
            explanation = "ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿಯವರು ತಮ್ಮ ‘ಆನಂದಮಠ’ ಕಾದಂಬರಿಯಲ್ಲಿ ‘ವಂದೇ ಮಾತರಂ’ ಗೀತೆಯನ್ನು ರಚಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u7_9",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ಬಿಳಿ: ಶಾಂತಿ :: ಹಸಿರು: ________",
            options = listOf("ಸಮೃದ್ಧಿ", "ಧೈರ್ಯ", "ಶೌರ್ಯ", "ತ್ಯಾಗ"),
            correctAnswer = "ಸಮೃದ್ಧಿ",
            explanation = "ರಾಷ್ಟ್ರಧ್ವಜದಲ್ಲಿ ಬಿಳಿ ಬಣ್ಣವು ಶಾಂತಿಯ ಸಂಕೇತವಾದರೆ, ಹಸಿರು ಬಣ್ಣವು ಸಮೃದ್ಧಿ ಮತ್ತು ಕೃಷಿ ಸಂಪತ್ತಿನ ಸಂಕೇತವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u7_10",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ಜನಗಣಮನ: ರವೀಂದ್ರನಾಥ ಟಾಗೋರ್ :: ವಂದೇ ಮಾತರಂ: ________",
            options = listOf("ಜವಾಹರಲಾಲ್ ನೆಹರು", "ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿ", "ಮಹಾತ್ಮಾ ಗಾಂಧೀಜಿ", "ಸುಭಾಷ್ ಚಂದ್ರ ಬೋಸ್"),
            correctAnswer = "ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿ",
            explanation = "‘ಜನಗಣಮನ’ ರಾಷ್ಟ್ರಗೀತೆಯನ್ನು ರವೀಂದ್ರನಾಥ ಟಾಗೋರ್ ರಚಿಸಿದರೆ, ‘ವಂದೇ ಮಾತರಂ’ ರಾಷ್ಟ್ರೀಯ ಗೀತೆಯನ್ನು ಬಂಕಿಮಚಂದ್ರ ಚಟರ್ಜಿ ರಚಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u7_11",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಾಷ್ಟ್ರೀಯ ಪಕ್ಷಿ: ನವಿಲು :: ರಾಷ್ಟ್ರೀಯ ಪ್ರಾಣಿ: ________",
            options = listOf("ಆನೆ", "ಸಿಂಹ", "ಹುಲಿ", "ಜಿಂಕೆ"),
            correctAnswer = "ಹುಲಿ",
            explanation = "ಭಾರತದ ರಾಷ್ಟ್ರೀಯ ಪಕ್ಷಿ ನವಿಲು ಹಾಗೂ ರಾಷ್ಟ್ರೀಯ ಪ್ರಾಣಿ ಹುಲಿ (ವ್ಯಾಘ್ರ)."
        ),
        QuestionModel(
            id = "s_6_soc_u7_12",
            stdId = 6,
            subjectId = "social",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಾಷ್ಟ್ರೀಯ ಯುವದಿನ: ಸ್ವಾಮಿ ವಿವೇಕಾನಂದ :: ಮಕ್ಕಳ ದಿನಾಚರಣೆ: ________",
            options = listOf("ಮಹಾತ್ಮಾ ಗಾಂಧೀಜಿ", "ಜವಾಹರಲಾಲ್ ನೆಹರು", "ಡಾ. ಬಿ. ಆರ್. ಅಂಬೇಡ್ಕರ್", "ರವೀಂದ್ರನಾಥ ಟಾಗೋರ್"),
            correctAnswer = "ಜವಾಹರಲಾಲ್ ನೆಹರು",
            explanation = "ಸ್ವಾಮಿ ವಿವೇಕಾನಂದರ ಜನ್ಮದಿನವನ್ನು ರಾಷ್ಟ್ರೀಯ ಯುವದಿನವನ್ನಾಗಿಯೂ, ಜವಾಹರಲಾಲ್ ನೆಹರೂರವರ ಜನ್ಮದಿನವನ್ನು (ನವೆಂಬರ್ 14) ಮಕ್ಕಳ ದಿನಾಚರಣೆಯನ್ನಾಗಿಯೂ ಆಚರಿಸಲಾಗುತ್ತದೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 8: ನಮ್ಮ ಸಂವಿಧಾನ ಮತ್ತು ಸರ್ಕಾರ (14 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u8_1",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತದ ಸಂವಿಧಾನ ರಚನಾ ಸಭೆಯ ಕರಡು ಸಮಿತಿ ಅಧ್ಯಕ್ಷರು ಯಾರಾಗಿದ್ದರು?",
            options = listOf("ಡಾ. ಬಿ. ಆರ್. ಅಂಬೇಡ್ಕರ್", "ಡಾ. ಬಾಬು ರಾಜೇಂದ್ರ ಪ್ರಸಾದ್", "ಜವಾಹರಲಾಲ್ ನೆಹರು", "ಸರ್ದಾರ್ ಪಟೇಲ್"),
            correctAnswer = "ಡಾ. ಬಿ. ಆರ್. ಅಂಬೇಡ್ಕರ್",
            explanation = "ಡಾ. ಬಿ. ಆರ್. ಅಂಬೇಡ್ಕರ್ ಅವರು ಸಂವಿಧಾನ ಕರಡು ಸಮಿತಿಯ ಅಧ್ಯಕ್ಷರಾಗಿದ್ದು, ಸಂವಿಧಾನದ ಶಿಲ್ಪಿ ಎನಿಸಿಕೊಂಡಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_2",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತದ ಸಂವಿಧಾನವು ಜಾರಿಗೆ ಬಂದ ದಿನಾಂಕ ಯಾವುದು?",
            options = listOf("26 ಜನವರಿ 1950", "15 ಆಗಸ್ಟ್ 1947", "26 ನವೆಂಬರ್ 1949", "2 ಅಕ್ಟೋಬರ್ 1950"),
            correctAnswer = "26 ಜನವರಿ 1950",
            explanation = "1950 ರ ಜನವರಿ 26 ರಂದು ಸಂವಿಧಾನ ಜಾರಿಗೆ ಬಂತು. ಆ ದಿನವನ್ನು ನಾವು ಗಣರಾಜ್ಯೋತ್ಸವವನ್ನಾಗಿ ಆಚರಿಸುತ್ತೇವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_3",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂವಿಧಾನ ದಿನವನ್ನು ಪ್ರತಿವರ್ಷ ಯಾವ ದಿನದಂದು ಆಚರಿಸಲಾಗುತ್ತದೆ?",
            options = listOf("ನವೆಂಬರ್ 26", "ಜನವರಿ 26", "ಆಗಸ್ಟ್ 15", "ಅಕ್ಟೋಬರ್ 2"),
            correctAnswer = "ನವೆಂಬರ್ 26",
            explanation = "1949 ರ ನವೆಂಬರ್ 26 ರಂದು ಸಂವಿಧಾನ ರಚನಾ ಸಭೆಯು ಸಂವಿಧಾನವನ್ನು ಅಂಗೀಕರಿಸಿದ್ದರಿಂದ ನವೆಂಬರ್ 26 ನ್ನು ಸಂವಿಧಾನ ದಿನ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_4",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತದ ಸಂವಿಧಾನ ನೀಡಿರುವ ಮೂಲಭೂತ ಹಕ್ಕುಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("6", "7", "8", "10"),
            correctAnswer = "6",
            explanation = "ಭಾರತೀಯ ನಾಗರಿಕರಿಗೆ ಸಂವಿಧಾನವು 6 ಮೂಲಭೂತ ಹಕ್ಕುಗಳನ್ನು ನೀಡಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_5",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂವಿಧಾನದಲ್ಲಿರುವ ಮೂಲಭೂತ ಕರ್ತವ್ಯಗಳ ಒಟ್ಟು ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("11", "10", "12", "9"),
            correctAnswer = "11",
            explanation = "ಸಂವಿಧಾನದ 51(ಎ) ವಿಧಿಯ ಅಡಿಯಲ್ಲಿ ನಾಗರಿಕರಿಗೆ 11 ಮೂಲಭೂತ ಕರ್ತವ್ಯಗಳನ್ನು ವಿಧಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_6",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತದಲ್ಲಿ ಮತದಾನ ಮಾಡುವ ಕನಿಷ್ಠ ವಯಸ್ಸು ಎಷ್ಟು?",
            options = listOf("18 ವರ್ಷ", "21 ವರ್ಷ", "16 ವರ್ಷ", "20 ವರ್ಷ"),
            correctAnswer = "18 ವರ್ಷ",
            explanation = "18 ವರ್ಷ ತುಂಬಿದ ಪ್ರತಿಯೊಬ್ಬ ಭಾರತೀಯ ನಾಗರಿಕನಿಗೂ ಸಾರ್ವತ್ರಿಕ ವಯಸ್ಕ ಮತದಾನದ ಹಕ್ಕಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_7",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸರ್ಕಾರದ ಮೂರು ಅಂಗಗಳಲ್ಲಿ ಕಾನೂನು ರೂಪಿಸುವ ಅಂಗ ಯಾವುದು?",
            options = listOf("ಶಾಸಕಾಂಗ", "ಕಾರ್ಯಾಂಗ", "ನ್ಯಾಯಾಂಗ", "ಮಾಧ್ಯಮ"),
            correctAnswer = "ಶಾಸಕಾಂಗ",
            explanation = "ಶಾಸಕಾಂಗವು (ಸಂಸತ್ತು/ವಿಧಾನಮಂಡಲ) ದೇಶಕ್ಕೆ ಅಗತ್ಯವಾದ ಕಾನೂನುಗಳನ್ನು ರೂಪಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_8",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ರೂಪಿಸಿದ ಕಾನೂನುಗಳನ್ನು ಜಾರಿಗೆ ತರುವ ಸರ್ಕಾರದ ಅಂಗ ಯಾವುದು?",
            options = listOf("ಕಾರ್ಯಾಂಗ", "ಶಾಸಕಾಂಗ", "ನ್ಯಾಯಾಂಗ", "ಪೊಲೀಸ್ ಇಲಾಖೆ"),
            correctAnswer = "ಕಾರ್ಯಾಂಗ",
            explanation = "ಮಂತ್ರಿಮಂಡಲ ಮತ್ತು ಅಧಿಕಾರಿಗಳನ್ನೊಳಗೊಂಡ ಕಾರ್ಯಾಂಗವು ಕಾನೂನುಗಳನ್ನು ಅನುಷ್ಠಾನಗೊಳಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_9",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಕಾನೂನನ್ನು ಉಲ್ಲಂಘಿಸಿದವರಿಗೆ ಶಿಕ್ಷೆ ವಿಧಿಸಿ ನ್ಯಾಯ ಒದಗಿಸುವ ಅಂಗ:",
            options = listOf("ನ್ಯಾಯಾಂಗ", "ಶಾಸಕಾಂಗ", "ಕಾರ್ಯಾಂಗ", "ಚುನಾವಣಾ ಆಯೋಗ"),
            correctAnswer = "ನ್ಯಾಯಾಂಗ",
            explanation = "ಸ್ವತಂತ್ರ ನ್ಯಾಯಾಂಗವು ಸಂವಿಧಾನವನ್ನು ರಕ್ಷಿಸಿ ನ್ಯಾಯ ತೀರ್ಮಾನ ನೀಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_10",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತದ ಪ್ರಥಮ ಪ್ರಜೆಯೂ ಮತ್ತು ಮೂರೂ ಸಶಸ್ತ್ರ ಪಡೆಗಳ ಮಹಾದಂಡನಾಯಕರೂ ಯಾರು?",
            options = listOf("ರಾಷ್ಟ್ರಪತಿಗಳು", "ಪ್ರಧಾನಮಂತ್ರಿಗಳು", "ಉಪರಾಷ್ಟ್ರಪತಿಗಳು", "ರಕ್ಷಣಾ ಸಚಿವರು"),
            correctAnswer = "ರಾಷ್ಟ್ರಪತಿಗಳು",
            explanation = "ಭಾರತದ ರಾಷ್ಟ್ರಪತಿಗಳು ದೇಶದ ಮೊದಲ ಪ್ರಜೆ ಮತ್ತು ರಕ್ಷಣಾ ಪಡೆಗಳ ಸುಪ್ರೀಂ ಕಮಾಂಡರ್ ಆಗಿರುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_11",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಕೇಂದ್ರ ಸರ್ಕಾರದ ಕಾರ್ಯಾಂಗದ ನೈಜ ಮುಖ್ಯಸ್ಥರು ಯಾರು?",
            options = listOf("ಪ್ರಧಾನಮಂತ್ರಿ", "ರಾಷ್ಟ್ರಪತಿ", "ಲೋಕಸಭಾ ಸ್ಪೀಕರ್", "ಮುಖ್ಯ ನ್ಯಾಯಮೂರ್ತಿ"),
            correctAnswer = "ಪ್ರಧಾನಮಂತ್ರಿ",
            explanation = "ಸಂಸದೀಯ ಮಾದರಿಯಲ್ಲಿ ಪ್ರಧಾನಮಂತ್ರಿಗಳು ಕೇಂದ್ರ ಸರ್ಕಾರದ ವಾಸ್ತವಿಕ ಆಡಳಿತ ಮುಖ್ಯಸ್ಥರಾಗಿರುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_12",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತದ ಸರ್ವೋಚ್ಚ ನ್ಯಾಯಾಲಯ (ಸುಪ್ರೀಂ ಕೋರ್ಟ್) ಎಲ್ಲಿದೆ?",
            options = listOf("ನವದೆಹಲಿ", "ಮುಂಬೈ", "ಕೋಲ್ಕತ್ತಾ", "ಚೆನ್ನೈ"),
            correctAnswer = "ನವದೆಹಲಿ",
            explanation = "ದೇಶದ ಅತ್ಯುನ್ನತ ನ್ಯಾಯಾಲಯವಾದ ಸುಪ್ರೀಂ ಕೋರ್ಟ್ ನವದೆಹಲಿಯಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_13",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂವಿಧಾನ ರಚನಾ ಸಭೆಯ ಕಾಯಂ ಅಧ್ಯಕ್ಷರಾಗಿದ್ದವರು ಯಾರು?",
            options = listOf("ಡಾ. ಬಾಬು ರಾಜೇಂದ್ರ ಪ್ರಸಾದ್", "ಡಾ. ಬಿ. ಆರ್. ಅಂಬೇಡ್ಕರ್", "ಜವಾಹರಲಾಲ್ ನೆಹರು", "ಮೌಲಾನಾ ಆಜಾದ್"),
            correctAnswer = "ಡಾ. ಬಾಬು ರಾಜೇಂದ್ರ ಪ್ರಸಾದ್",
            explanation = "ಡಾ. ಬಾಬು ರಾಜೇಂದ್ರ ಪ್ರಸಾದ್ ಅವರು ಸಂವಿಧಾನ ರಚನಾ ಸಭೆಯ ಅಧ್ಯಕ್ಷರಾಗಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_14",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ವಿಶ್ವದಲ್ಲೇ ಅತ್ಯಂತ ದೊಡ್ಡ ಲಿಖಿತ ಸಂವಿಧಾನ ಹೊಂದಿರುವ ದೇಶ:",
            options = listOf("ಭಾರತ", "ಅಮೆರಿಕ", "ಇಂಗ್ಲೆಂಡ್", "ರಷ್ಯಾ"),
            correctAnswer = "ಭಾರತ",
            explanation = "ಭಾರತದ ಸಂವಿಧಾನವು ವಿಶ್ವದಲ್ಲೇ ಅತಿ ದೊಡ್ಡ ಮತ್ತು ವಿಸ್ತಾರವಾದ ಲಿಖಿತ ಸಂವಿಧಾನವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_15",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತ ಸಂವಿಧಾನವನ್ನು ಸಿದ್ಧಪಡಿಸಿದ ವಿಶೇಷ ಸಭೆ ಯಾವುದು?",
            options = listOf("ಲೋಕಸಭೆ", "ರಾಜ್ಯಸಭೆ", "ಸಂವಿಧಾನ ಸಭೆ", "ವಿಧಾನಸಭೆ"),
            correctAnswer = "ಸಂವಿಧಾನ ಸಭೆ",
            explanation = "ಭಾರತಕ್ಕೆ ಪ್ರತ್ಯೇಕ ಸಂವಿಧಾನವನ್ನು ರಚಿಸಲು ‘ಸಂವಿಧಾನ ರಚನಾ ಸಭೆ’ (Constituent Assembly) ಯನ್ನು ರಚಿಸಲಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_16",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂವಿಧಾನದ ಕರಡು ಪ್ರತಿಯನ್ನು ಸಿದ್ಧಪಡಿಸಲು ಯಾವ ಸಮಿತಿಯನ್ನು ರಚಿಸಲಾಯಿತು?",
            options = listOf("ಚುನಾವಣಾ ಸಮಿತಿ", "ಸಂವಿಧಾನ ಕರಡು ಸಮಿತಿ", "ಹಣಕಾಸು ಸಮಿತಿ", "ಯೋಜನಾ ಸಮಿತಿ"),
            correctAnswer = "ಸಂವಿಧಾನ ಕರಡು ಸಮಿತಿ",
            explanation = "ಡಾ. ಬಿ. ಆರ್. ಅಂಬೇಡ್ಕರ್ ಅವರ ಅಧ್ಯಕ್ಷತೆಯಲ್ಲಿ ಸಂವಿಧಾನ ಕರಡು ಸಮಿತಿಯನ್ನು ನೇಮಿಸಲಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_17",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಮೂಲಭೂತ ಹಕ್ಕುಗಳನ್ನು ಕುರಿತ ಸಲಹಾ ಸಮಿತಿಯ ಅಧ್ಯಕ್ಷರು ಯಾರು?",
            options = listOf("ಡಾ. ಬಿ.ಆರ್. ಅಂಬೇಡ್ಕರ್", "ಡಾ. ಬಾಬು ರಾಜೇಂದ್ರ ಪ್ರಸಾದ್", "ಸರ್ದಾರ್ ವಲ್ಲಭಭಾಯಿ ಪಟೇಲ್", "ಜವಾಹರಲಾಲ್ ನೆಹರು"),
            correctAnswer = "ಸರ್ದಾರ್ ವಲ್ಲಭಭಾಯಿ ಪಟೇಲ್",
            explanation = "ಸರ್ದಾರ್ ವಲ್ಲಭಭಾಯಿ ಪಟೇಲ್ ಅವರು ಮೂಲಭೂತ ಹಕ್ಕುಗಳು ಮತ್ತು ಅಲ್ಪಸಂಖ್ಯಾತರ ಸಲಹಾ ಸಮಿತಿಯ ಅಧ್ಯಕ್ಷರಾಗಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_18",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಜನವರಿ 26, 1950ರಂದು ಸಂವಿಧಾನವು ಭಾರತವನ್ನು ಏನೆಂದು ಘೋಷಿಸಿತು?",
            options = listOf("ವಸಾಹತು", "ಗಣರಾಜ್ಯ", "ರಾಜಪ್ರಭುತ್ವ", "ಸಾಮ್ರಾಜ್ಯ"),
            correctAnswer = "ಗಣರಾಜ್ಯ",
            explanation = "ಸಂವಿಧಾನವು ಭಾರತವನ್ನು ಸಾರ್ವಭೌಮ ಪ್ರಜಾಸತ್ತಾತ್ಮಕ ಗಣರಾಜ್ಯವೆಂದು ಘೋಷಿಸಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_19",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತದ ಪ್ರಥಮ ಸಾರ್ವತ್ರಿಕ ಚುನಾವಣೆಗಳು ನಡೆದ ವರ್ಷ ಯಾವುದು?",
            options = listOf("1947–48", "1949–50", "1951–52", "1955–56"),
            correctAnswer = "1951–52",
            explanation = "ಸ್ವತಂತ್ರ ಭಾರತದ ಮೊಟ್ಟಮೊದಲ ಸಾರ್ವತ್ರಿಕ ಚುನಾವಣೆಗಳು 1951–52 ರಲ್ಲಿ ಯಶಸ್ವಿಯಾಗಿ ನಡೆದವು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_20",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "2023ರ ಸೆಪ್ಟೆಂಬರ್ ವರೆಗೆ ಭಾರತದ ಸಂವಿಧಾನಕ್ಕೆ ಎಷ್ಟು ಬಾರಿ ತಿದ್ದುಪಡಿ ಮಾಡಲಾಗಿದೆ?",
            options = listOf("100", "102", "105", "106"),
            correctAnswer = "106",
            explanation = "ಮಹಿಳಾ ಮೀಸಲಾತಿ ಮಸೂದೆ (ನಾರೀಶಕ್ತಿ ವಂದನ್ ಅಧಿನಿಯಮ್) ಒಳಗೊಂಡಂತೆ 106 ತಿದ್ದುಪಡಿಗಳು ನಡೆದಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_21",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂವಿಧಾನದ ಹೃದಯ ಎಂದು ಯಾವುದನ್ನು ಕರೆಯಲಾಗಿದೆ?",
            options = listOf("ಮೂಲಭೂತ ಕರ್ತವ್ಯಗಳು", "ಸಂವಿಧಾನದ ಪ್ರಸ್ತಾವನೆ", "ಸಂಸತ್ತು", "ನ್ಯಾಯಾಂಗ"),
            correctAnswer = "ಸಂವಿಧಾನದ ಪ್ರಸ್ತಾವನೆ",
            explanation = "ಸಂವಿಧಾನದ ಮುನ್ನುಡಿ/ಪ್ರಸ್ತಾವನೆಯನ್ನು (Preamble) ಸಂವಿಧಾನದ ಆತ್ಮ ಮತ್ತು ಹೃದಯ ಎಂದು ಕರೆಯಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_22",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತ ಗಣರಾಜ್ಯದ ಪ್ರಥಮ ರಾಷ್ಟ್ರಪತಿ ಯಾರು?",
            options = listOf("ಡಾ. ಬಿ.ಆರ್. ಅಂಬೇಡ್ಕರ್", "ಡಾ. ಬಾಬು ರಾಜೇಂದ್ರ ಪ್ರಸಾದ್", "ಜವಾಹರಲಾಲ್ ನೆಹರು", "ಸರ್ದಾರ್ ವಲ್ಲಭಭಾಯಿ ಪಟೇಲ್"),
            correctAnswer = "ಡಾ. ಬಾಬು ರಾಜೇಂದ್ರ ಪ್ರಸಾದ್",
            explanation = "ಡಾ. ಬಾಬು ರಾಜೇಂದ್ರ ಪ್ರಸಾದ್ ಅವರು ಸ್ವತಂತ್ರ ಭಾರತದ ಮೊದಲ ರಾಷ್ಟ್ರಪತಿಗಳಾಗಿ ಆಯ್ಕೆಯಾದರು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_23",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಹಕ್ಕು ಎಂದರೆ ಏನು?",
            options = listOf("ನಾಗರಿಕರಿಗೆ ಇರಬೇಕಾದ ಅಧಿಕಾರ", "ಸರ್ಕಾರದ ಆದೇಶ", "ಶಾಲೆಯ ನಿಯಮ", "ಶಿಕ್ಷೆಯ ವಿಧಾನ"),
            correctAnswer = "ನಾಗರಿಕರಿಗೆ ಇರಬೇಕಾದ ಅಧಿಕಾರ",
            explanation = "ವ್ಯಕ್ತಿಯ ಸರ್ವಾಂಗೀಣ ವಿಕಾಸಕ್ಕಾಗಿ ಸಮಾಜ ಮತ್ತು ಸಂವಿಧಾನ ನೀಡುವ ಕಾನೂನುಬದ್ಧ ಅಧಿಕಾರವೇ ಹಕ್ಕು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_24",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತದಲ್ಲಿ ಬಾಲಕಾರ್ಮಿಕ ನಿಷೇಧ ಕಾಯಿದೆ ಯಾವ ವರ್ಷ ಜಾರಿಗೆ ಬಂದಿತು?",
            options = listOf("1976", "1986", "1991", "2001"),
            correctAnswer = "1986",
            explanation = "ಮಕ್ಕಳ ಶೋಷಣೆ ತಡೆಯಲು ಬಾಲಕಾರ್ಮಿಕ (ನಿಷೇಧ ಮತ್ತು ನಿಯಂತ್ರಣ) ಕಾಯ್ದೆಯನ್ನು 1986 ರಲ್ಲಿ ತರಲಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_25",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಮಕ್ಕಳ ಉಚಿತ ರಾಷ್ಟ್ರೀಯ ಸಹಾಯವಾಣಿ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("100", "101", "1098", "108"),
            correctAnswer = "1098",
            explanation = "ಸಂಕಷ್ಟದಲ್ಲಿರುವ ಮಕ್ಕಳ ತುರ್ತು ನೆರವಿಗಾಗಿ 1098 (ಚೈಲ್ಡ್ ಲೈನ್) ಸಹಾಯವಾಣಿ ನಿರಂತರ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_26",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಅಂತರರಾಷ್ಟ್ರೀಯ ಮಾನವ ಹಕ್ಕುಗಳ ಸಾರ್ವತ್ರಿಕ ಘೋಷಣೆ ಯಾವ ವರ್ಷ ಪ್ರಕಟವಾಯಿತು?",
            options = listOf("1945", "1947", "1948", "1950"),
            correctAnswer = "1948",
            explanation = "ವಿಶ್ವಸಂಸ್ಥೆಯು ಡಿಸೆಂಬರ್ 10, 1948 ರಂದು ಮಾನವ ಹಕ್ಕುಗಳ ಸಾರ್ವತ್ರಿಕ ಘೋಷಣೆಯನ್ನು (UDHR) ಅಂಗೀಕರಿಸಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_27",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಭಾರತ ಸರ್ಕಾರವು ಲಿಂಗತ್ವ ಅಲ್ಪಸಂಖ್ಯಾತರ ಹಕ್ಕುಗಳ ಸಂರಕ್ಷಣಾ ಕಾಯಿದೆಯನ್ನು ಜಾರಿಗೆ ತಂದ ವರ್ಷ ಯಾವುದು?",
            options = listOf("2014", "2016", "2018", "2019"),
            correctAnswer = "2019",
            explanation = "ತೃತೀಯ ಲಿಂಗಿಗಳ ರಕ್ಷಣೆಗಾಗಿ ಟ್ರಾನ್ಸ್‌ಜೆಂಡರ್ ವ್ಯಕ್ತಿಗಳ ಹಕ್ಕುಗಳ ಸಂರಕ್ಷಣಾ ಕಾಯ್ದೆಯನ್ನು 2019 ರಲ್ಲಿ ಜಾರಿಗೊಳಿಸಲಾಯಿತು."
        ),
        QuestionModel(
            id = "s_6_soc_u8_28",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂವಿಧಾನದ ಯಾವ ವಿಧಿಯ ಅಡಿಯಲ್ಲಿ ಅಸ್ಪೃಶ್ಯತೆ ಆಚರಣೆಯನ್ನು ಅಪರಾಧವೆಂದು ನಿಷೇಧಿಸಲಾಗಿದೆ?",
            options = listOf("17ನೇ ವಿಧಿ", "14ನೇ ವಿಧಿ", "19ನೇ ವಿಧಿ", "21ನೇ ವಿಧಿ"),
            correctAnswer = "17ನೇ ವಿಧಿ",
            explanation = "ಸಂವಿಧಾನದ 17ನೇ ವಿಧಿಯು ಅಸ್ಪೃಶ್ಯತೆ ಆಚರಣೆಯನ್ನು ಸಂಪೂರ್ಣವಾಗಿ ನಿಷೇಧಿಸಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u8_29",
            stdId = 6,
            subjectId = "social",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂವಿಧಾನದ ಯಾವ ವಿಧಿಯು 6 ರಿಂದ 14 ವರ್ಷದ ಮಕ್ಕಳಿಗೆ ಉಚಿತ ಮತ್ತು ಕಡ್ಡಾಯ ಶಿಕ್ಷಣದ ಹಕ್ಕು ನೀಡುತ್ತದೆ?",
            options = listOf("21 (ಎ) ವಿಧಿ", "45ನೇ ವಿಧಿ", "19ನೇ ವಿಧಿ", "32ನೇ ವಿಧಿ"),
            correctAnswer = "21 (ಎ) ವಿಧಿ",
            explanation = "21(ಎ) ವಿಧಿಯ ಪ್ರಕಾರ ಶಿಕ್ಷಣವು ಮಕ್ಕಳ ಮೂಲಭೂತ ಹಕ್ಕಾಗಿದೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 9: ಸ್ಥಳೀಯ ಸರ್ಕಾರಗಳು (8 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u9_1",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಗ್ರಾಮೀಣ ಸ್ಥಳೀಯ ಸಂಸ್ಥೆಗಳ ಪಂಚಾಯತ್ ರಾಜ್ ವ್ಯವಸ್ಥೆಯಲ್ಲಿ ಎಷ್ಟು ಹಂತಗಳಿವೆ?",
            options = listOf("3 ಹಂತಗಳು", "2 ಹಂತಗಳು", "4 ಹಂತಗಳು", "1 ಹಂತ"),
            correctAnswer = "3 ಹಂತಗಳು",
            explanation = "ಗ್ರಾಮ ಪಂಚಾಯತಿ, ತಾಲೂಕು ಪಂಚಾಯತಿ ಮತ್ತು ಜಿಲ್ಲಾ ಪಂಚಾಯತಿ ಎಂಬ ಮೂರು ಹಂತಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_2",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಗ್ರಾಮೀಣ ಸ್ಥಳೀಯ ಸರ್ಕಾರದ ತಳಹಂತದ ಸಂಸ್ಥೆ ಯಾವುದು?",
            options = listOf("ಗ್ರಾಮ ಪಂಚಾಯತಿ", "ತಾಲೂಕು ಪಂಚಾಯತಿ", "ಜಿಲ್ಲಾ ಪಂಚಾಯತಿ", "ಪುರಸಭೆ"),
            correctAnswer = "ಗ್ರಾಮ ಪಂಚಾಯತಿ",
            explanation = "ಗ್ರಾಮೀಣ ಪ್ರದೇಶದಲ್ಲಿ ಗ್ರಾಮ ಪಂಚಾಯತಿಯು ತಳಮಟ್ಟದ ಪ್ರಮುಖ ಆಡಳಿತ ಘಟಕವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_3",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಗ್ರಾಮ ಪಂಚಾಯತಿಯ ಮುಖ್ಯ ಆಡಳಿತಾಧಿಕಾರಿ ಯಾರು?",
            options = listOf("ಪಂಚಾಯಿತಿ ಅಭಿವೃದ್ಧಿ ಅಧಿಕಾರಿ (PDO)", "ಕಾರ್ಯನಿರ್ವಾಹಕ ಅಧಿಕಾರಿ (EO)", "ಮುಖ್ಯ ಕಾರ್ಯನಿರ್ವಾಹಕ ಅಧಿಕಾರಿ (CEO)", "ತಹಶೀಲ್ದಾರ್"),
            correctAnswer = "ಪಂಚಾಯಿತಿ ಅಭಿವೃದ್ಧಿ ಅಧಿಕಾರಿ (PDO)",
            explanation = "ಗ್ರಾಮ ಪಂಚಾಯತಿಯ ಸರ್ಕಾರಿ ಆಡಳಿತ ಮುಖ್ಯಸ್ಥರು ಪಿ.ಡಿ.ಒ (PDO)."
        ),
        QuestionModel(
            id = "s_6_soc_u9_4",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ನಗರ ಸ್ಥಳೀಯ ಸಂಸ್ಥೆಗಳಲ್ಲಿ ಬೃಹತ್ ಮಹಾನಗರಗಳಿಗೆ ಇರುವ ಆಡಳಿತ ಸಂಸ್ಥೆ ಯಾವುದು?",
            options = listOf("ಮಹಾನಗರ ಪಾಲಿಕೆ (ಕಾರ್ಪೊರೇಷನ್)", "ನಗರಸಭೆ", "ಪುರಸಭೆ", "ಪಟ್ಟಣ ಪಂಚಾಯತಿ"),
            correctAnswer = "ಮಹಾನಗರ ಪಾಲಿಕೆ (ಕಾರ್ಪೊರೇಷನ್)",
            explanation = "ದೊಡ್ಡ ನಗರಗಳಲ್ಲಿ (ಉದಾ: ಬಿಬಿಎಂಪಿ, ಮೈಸೂರು) ಮಹಾನಗರ ಪಾಲಿಕೆಗಳು ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_5",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮಹಾನಗರ ಪಾಲಿಕೆಯ ಪ್ರಥಮ ನಾಗರಿಕರೂ ಮತ್ತು ರಾಜಕೀಯ ಮುಖ್ಯಸ್ಥರೂ ಯಾರು?",
            options = listOf("ಮೇಯರ್", "ಕಮಿಷನರ್", "ಅಧ್ಯಕ್ಷರು", "ಉಪಾಧ್ಯಕ್ಷರು"),
            correctAnswer = "ಮೇಯರ್",
            explanation = "ಮಹಾನಗರ ಪಾಲಿಕೆಯ ಮುಖ್ಯಸ್ಥರನ್ನು ಮೇಯರ್ (ಮಹಾಪೌರರು) ಎಂದು ಕರೆಯುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_6",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಗ್ರಾಮ ಸಭೆಯ ಅಧ್ಯಕ್ಷತೆಯನ್ನು ಯಾರು ವಹಿಸುತ್ತಾರೆ?",
            options = listOf("ಗ್ರಾಮ ಪಂಚಾಯಿತಿ ಅಧ್ಯಕ್ಷರು", "ಪಿ.ಡಿ.ಒ", "ಶಾಸಕರು", "ಗ್ರಾಮ ಲೆಕ್ಕಿಗ"),
            correctAnswer = "ಗ್ರಾಮ ಪಂಚಾಯಿತಿ ಅಧ್ಯಕ್ಷರು",
            explanation = "ಗ್ರಾಮ ಸಭೆಯ ಸಭೆಗಳ ಅಧ್ಯಕ್ಷತೆಯನ್ನು ಗ್ರಾಮ ಪಂಚಾಯತಿ ಅಧ್ಯಕ್ಷರು ವಹಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_7",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕ ಪಂಚಾಯತ್ ರಾಜ್ ಕಾಯ್ದೆ ಪ್ರಕಾರ ಮಹಿಳೆಯರಿಗೆ ನೀಡಲಾಗಿರುವ ಮೀಸಲಾತಿ ಪ್ರಮಾಣ:",
            options = listOf("%50", "%33", "%25", "%40"),
            correctAnswer = "%50",
            explanation = "ಕರ್ನಾಟಕದ ಸ್ಥಳೀಯ ಸಂಸ್ಥೆಗಳ ಚುನಾವಣೆಯಲ್ಲಿ ಮಹಿಳೆಯರಿಗೆ ಶೇಕಡಾ 50 ರಷ್ಟು ಸ್ಥಾನಗಳು ಮೀಸಲಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_8",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸ್ಥಳೀಯ ಸಂಸ್ಥೆಗಳ ಚುನಾವಣೆ ಎಷ್ಟು ವರ್ಷಗಳಿಗೊಮ್ಮೆ ನಡೆಯುತ್ತದೆ?",
            options = listOf("5 ವರ್ಷ", "4 ವರ್ಷ", "6 ವರ್ಷ", "3 ವರ್ಷ"),
            correctAnswer = "5 ವರ್ಷ",
            explanation = "ಪಂಚಾಯಿತಿ ಮತ್ತು ನಗರ ಸ್ಥಳೀಯ ಸಂಸ್ಥೆಗಳ ಚುನಾವಣೆ ಪ್ರತಿ ಐದು ವರ್ಷಕ್ಕೊಮ್ಮೆ ಜರುಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_9",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಜನರಿಂದ ಆಯ್ಕೆಯಾದ ಪ್ರತಿನಿಧಿಗಳ ಮೂಲಕ ನಡೆಯುವ ಆಡಳಿತವನ್ನು ಏನೆಂದು ಕರೆಯಲಾಗುತ್ತದೆ?",
            options = listOf("ಸರ್ವಾಧಿಕಾರಿ ಸರ್ಕಾರ", "ಪ್ರಜಾಪ್ರಭುತ್ವ ಸರ್ಕಾರ", "ರಾಜಪ್ರಭುತ್ವ", "ಸಮತಾವಾದಿ ಸರ್ಕಾರ"),
            correctAnswer = "ಪ್ರಜಾಪ್ರಭುತ್ವ ಸರ್ಕಾರ",
            explanation = "ಜನರಿಂದ, ಜನರಿಗಾಗಿ, ಜನರಿಗೋಸ್ಕರ ನಡೆಯುವ ಪ್ರಜಾಪ್ರತಿನಿಧಿಗಳ ಆಡಳಿತವೇ ಪ್ರಜಾಪ್ರಭುತ್ವ ಸರ್ಕಾರ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_10",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಪ್ರಜಾಪ್ರಭುತ್ವದ ಜೀವಾಳ ಯಾವುದು?",
            options = listOf("ರಾಜನ ಅಧಿಕಾರ", "ಜನರಿಗೆ ಇರುವ ಆಯ್ಕೆ ಸ್ವಾತಂತ್ರ್ಯ", "ಸೈನ್ಯದ ಅಧಿಕಾರ", "ಖಾಸಗಿ ಆಸ್ತಿ"),
            correctAnswer = "ಜನರಿಗೆ ಇರುವ ಆಯ್ಕೆ ಸ್ವಾತಂತ್ರ್ಯ",
            explanation = "ತಮ್ಮ ನಾಯಕರನ್ನು ಮತ್ತು ಸರ್ಕಾರವನ್ನು ನಿರ್ಭಯವಾಗಿ ಆಯ್ಕೆ ಮಾಡುವ ಜನರ ಸ್ವಾತಂತ್ರ್ಯವೇ ಪ್ರಜಾಪ್ರಭುತ್ವದ ಜೀವನಾಡಿ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_11",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸರ್ವಾಧಿಕಾರಿ ಸರ್ಕಾರಕ್ಕೆ ಪ್ರಮುಖ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಭಾರತ", "ಅಮೆರಿಕಾ", "ಹಿಟ್ಲರನ ಆಡಳಿತ", "ಇಂಗ್ಲೆಂಡ್"),
            correctAnswer = "ಹಿಟ್ಲರನ ಆಡಳಿತ",
            explanation = "ಜರ್ಮನಿಯ ಅಡಾಲ್ಫ್ ಹಿಟ್ಲರನ ಆಡಳಿತವು ಸರ್ವಾಧಿಕಾರಿ ಅಥವಾ ನಿರಂಕುಶ ಪ್ರಭುತ್ವಕ್ಕೆ ಇತಿಹಾಸದ ಪ್ರಸಿದ್ಧ ಉದಾಹರಣೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u9_12",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸಮತಾವಾದಿ ಸರ್ಕಾರದ (ಕಮ್ಯುನಿಸ್ಟ್) ವ್ಯವಸ್ಥೆಯ ಮುಖ್ಯ ಪ್ರತಿಪಾದಕರು ಯಾರು?",
            options = listOf("ಕಾರ್ಲ್ ಮಾರ್ಕ್ಸ್", "ಮಹಾತ್ಮಾ ಗಾಂಧೀಜಿ", "ಜವಾಹರಲಾಲ್ ನೆಹರು", "ಅಬ್ರಹಾಂ ಲಿಂಕನ್"),
            correctAnswer = "ಕಾರ್ಲ್ ಮಾರ್ಕ್ಸ್",
            explanation = "ಕಾರ್ಲ್ ಮಾರ್ಕ್ಸ್ ಅವರು ವೈಜ್ಞಾನಿಕ ಸಮಾಜವಾದ ಮತ್ತು ಸಮತಾವಾದಿ ಸಿದ್ಧಾಂತದ ಪ್ರವರ್ತಕರು."
        ),
        QuestionModel(
            id = "s_6_soc_u9_13",
            stdId = 6,
            subjectId = "social",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸಮಾಜದಲ್ಲಿ ಉತ್ಪಾದನೆಯ ಮೂಲವಲ್ಲದ ಅಂಶ ಯಾವುದು?",
            options = listOf("ಭೂಮಿ", "ಸಂಘಟನೆ", "ಬಂಡವಾಳ", "ಖಾಸಗಿ ಆಸ್ತಿ"),
            correctAnswer = "ಖಾಸಗಿ ಆಸ್ತಿ",
            explanation = "ಅರ್ಥಶಾಸ್ತ್ರದಲ್ಲಿ ಉತ್ಪಾದನಾಾಂಗಗಳು: ಭೂಮಿ, ಶ್ರಮ, ಬಂಡವಾಳ ಮತ್ತು ಸಂಘಟನೆ; ಖಾಸಗಿ ಆಸ್ತಿ ನೇರ ಉತ್ಪಾದನಾ ಮೂಲವಲ್ಲ."
        ),

        // ==========================================
        // ಭಾಗ 3 — ಭೂಗೋಳ
        // ಅಧ್ಯಾಯ 10: ನಮ್ಮ ಭೂಮಿ ಮತ್ತು ಸೌರವ್ಯೂಹ (13 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u10_1",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸೂರ್ಯನಿಗೆ ಅತ್ಯಂತ ಹತ್ತಿರವಿರುವ ಗ್ರಹ ಯಾವುದು?",
            options = listOf("ಬುಧ", "ಶುಕ್ರ", "ಭೂಮಿ", "ಮಂಗಳ"),
            correctAnswer = "ಬುಧ",
            explanation = "ಬುಧ ಗ್ರಹವು ಸೌರವ್ಯೂಹದಲ್ಲಿ ಸೂರ್ಯನಿಗೆ ಅತ್ಯಂತ ಹತ್ತಿರವಿರುವ ಗ್ರಹವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_2",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸೌರವ್ಯೂಹದ ಅತ್ಯಂತ ದೊಡ್ಡ ಗ್ರಹ ಯಾವುದು?",
            options = listOf("ಗುರು", "ಶನಿ", "ಯುರೇನಸ್", "ನೆಪ್ಚೂನ್"),
            correctAnswer = "ಗುರು",
            explanation = "ಗುರು (Jupiter) ಗ್ರಹವು ಸೌರವ್ಯೂಹದ ಅತ್ಯಂತ ಬೃಹತ್ ಗ್ರಹ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_3",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ನೀಲಿ ಗ್ರಹ’ ಮತ್ತು ‘ಜೀವಂತ ಗ್ರಹ’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ಗ್ರಹ:",
            options = listOf("ಭೂಮಿ", "ಮಂಗಳ", "ಶುಕ್ರ", "ನೆಪ್ಚೂನ್"),
            correctAnswer = "ಭೂಮಿ",
            explanation = "ಮೂರು ಭಾಗ ನೀರಿನಿಂದ ಆವೃತವಾಗಿ ಜೀವಕೋಟಿಯನ್ನು ಹೊತ್ತಿರುವುದರಿಂದ ಭೂಮಿಯನ್ನು ನೀಲಿ ಗ್ರಹ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_4",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಏಕೈಕ ನೈಸರ್ಗಿಕ ಉಪಗ್ರಹ ಯಾವುದು?",
            options = listOf("ಚಂದ್ರ", "ಟೈಟಾನ್", "ಫೋಬೋಸ್", "ಗ್ಯಾನಿಮಿಡ್"),
            correctAnswer = "ಚಂದ್ರ",
            explanation = "ಚಂದ್ರನು ಭೂಮಿಯ ಏಕೈಕ ನೈಸರ್ಗಿಕ ಉಪಗ್ರಹ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_5",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ದೈನಂದಿನ ಚಲನೆಯಿಂದ (ಆವರ್ತನೆ) ಉಂಟಾಗುವುದು:",
            options = listOf("ಹಗಲು ಮತ್ತು ರಾತ್ರಿ", "ಋತುಮಾನಗಳು", "ಗ್ರಹಣಗಳು", "ವರ್ಷ"),
            correctAnswer = "ಹಗಲು ಮತ್ತು ರಾತ್ರಿ",
            explanation = "ಭೂಮಿಯು ತನ್ನ ಅಕ್ಷದ ಮೇಲೆ ತಾನೇ ತಿರುಗುವುದರಿಂದ ಹಗಲು ಮತ್ತು ರಾತ್ರಿಗಳು ಸಂಭವಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_6",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಭೂಮಿಯು ಸೂರ್ಯನ ಸುತ್ತ ಸುತ್ತುವುದರಿಂದ (ಪರಿಭ್ರಮಣ) ಉಂಟಾಗುವುದು:",
            options = listOf("ಋತುಮಾನಗಳ ಬದಲಾವಣೆ", "ಹಗಲು-ರಾತ್ರಿ", "ಭೂಕಂಪ", "ಉಬ್ಬರ-ವಿಳಿತ"),
            correctAnswer = "ಋತುಮಾನಗಳ ಬದಲಾವಣೆ",
            explanation = "ಭೂಮಿಯ ಪರಿಭ್ರಮಣೆ ಮತ್ತು ಅಕ್ಷದ ಓರೆಯಿಂದಾಗಿ ಬೇಸಿಗೆ, ಚಳಿಗಾಲ ಮುಂತಾದ ಋತುಗಳು ಉಂಟಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_7",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ಬೆಳ್ಳಿ ಚುಕ್ಕಿ’ ಅಥವಾ ‘ಸಂಜೆಯ ನಕ್ಷತ್ರ’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ಗ್ರಹ:",
            options = listOf("ಶುಕ್ರ", "ಬುಧ", "ಮಂಗಳ", "ಶನಿ"),
            correctAnswer = "ಶುಕ್ರ",
            explanation = "ಅತ್ಯಂತ ಪ್ರಕಾಶಮಾನವಾಗಿ ಬೆಳಗುವ ಶುಕ್ರ ಗ್ರಹವನ್ನು ಮುಂಜಾನೆ ಅಥವಾ ಸಂಜೆಯ ನಕ್ಷತ್ರ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_8",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ಕೆಂಪು ಗ್ರಹ’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ಗ್ರಹ ಯಾವುದು?",
            options = listOf("ಮಂಗಳ", "ಶುಕ್ರ", "ಗುರು", "ಬುಧ"),
            correctAnswer = "ಮಂಗಳ",
            explanation = "ಮಣ್ಣಿನಲ್ಲಿರುವ ಕಬ್ಬಿಣದ ಆಕ್ಸೈಡ್‌ನಿಂದಾಗಿ ಮಂಗಳ ಗ್ರಹ ಕೆಂಪಾಗಿ ಕಾಣುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_9",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸುಂದರವಾದ ಉಂಗುರಗಳನ್ನು ಹೊಂದಿರುವ ಆಕರ್ಷಕ ಗ್ರಹ ಯಾವುದು?",
            options = listOf("ಶನಿ", "ಗುರು", "ಯುರೇನಸ್", "ನೆಪ್ಚೂನ್"),
            correctAnswer = "ಶನಿ",
            explanation = "ಶನಿ ಗ್ರಹವು ತನ್ನ ಸುತ್ತಲೂ ಹಿಮ ಮತ್ತು ಧೂಳಿನ ಸುಂದರ ವಲಯಗಳನ್ನು (ಉಂಗುರ) ಹೊಂದಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_10",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸೂರ್ಯ ಮತ್ತು ಚಂದ್ರನ ನಡುವೆ ಭೂಮಿ ಬಂದಾಗ ಸಂಭವಿಸುವ ವಿದ್ಯಮಾನ:",
            options = listOf("ಚಂದ್ರಗ್ರಹಣ", "ಸೂರ್ಯಗ್ರಹಣ", "ಉಲ್ಕಾಪಾತ", "ಧೂಮಕೇತು"),
            correctAnswer = "ಚಂದ್ರಗ್ರಹಣ",
            explanation = "ಸೂರ್ಯ ಮತ್ತು ಚಂದ್ರನ ನಡುವೆ ಭೂಮಿ ಬಂದಾಗ ಭೂಮಿಯ ನೆರಳು ಚಂದ್ರನ ಮೇಲೆ ಬಿದ್ದು ಚಂದ್ರಗ್ರಹಣವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_11",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸೂರ್ಯ ಮತ್ತು ಭೂಮಿಯ ನಡುವೆ ಚಂದ್ರ ಬಂದಾಗ ಉಂಟಾಗುವುದು:",
            options = listOf("ಸೂರ್ಯಗ್ರಹಣ", "ಚಂದ್ರಗ್ರಹಣ", "ಅಮಾವಾಸ್ಯೆ", "ಹುಣ್ಣಿಮೆ"),
            correctAnswer = "ಸೂರ್ಯಗ್ರಹಣ",
            explanation = "ಸೂರ್ಯ ಮತ್ತು ಭೂಮಿಯ ನಡುವೆ ಚಂದ್ರ ಬಂದಾಗ ಚಂದ್ರನ ನೆರಳು ಭೂಮಿಯ ಮೇಲೆ ಬಿದ್ದು ಸೂರ್ಯಗ್ರಹಣವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_12",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಆಕಾರವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಜಿಯಾಯ್ಡ್ (ಭೂದಾಕಾರ)", "ಪೂರ್ಣ ಗೋಳ", "ವೃತ್ತಾಕಾರ", "ಅಂಡಾಕಾರ"),
            correctAnswer = "ಜಿಯಾಯ್ಡ್ (ಭೂದಾಕಾರ)",
            explanation = "ಧ್ರುವಗಳಲ್ಲಿ ಚಪ್ಪಟೆಯಾಗಿ ಮಧ್ಯದಲ್ಲಿ ಉಬ್ಬಿರುವ ಭೂಮಿಯ ವಿಶಿಷ್ಟ ಆಕಾರವನ್ನು ‘ಜಿಯಾಯ್ಡ್’ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u10_13",
            stdId = 6,
            subjectId = "social",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸೌರವ್ಯೂಹದಲ್ಲಿರುವ ಒಟ್ಟು ಗ್ರಹಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("8", "9", "7", "10"),
            correctAnswer = "8",
            explanation = "2006 ರಲ್ಲಿ ಪ್ಲುಟೋವನ್ನು ಕುಬ್ಜ ಗ್ರಹವೆಂದು ವರ್ಗೀಕರಿಸಿದ ನಂತರ ಸೌರವ್ಯೂಹದಲ್ಲಿ 8 ಮುಖ್ಯ ಗ್ರಹಗಳಿವೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 11: ಭೂಗೋಳದ ಪರಿಕರಗಳು: ಗೋಳ ಮತ್ತು ನಕ್ಷೆಗಳು (8 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u11_1",
            stdId = 6,
            subjectId = "social",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಅತ್ಯಂತ ನಿಖರವಾದ ಮೂರು ಆಯಾಮಗಳ (3D) ಮಾದರಿ ಯಾವುದು?",
            options = listOf("ಗ್ಲೋಬ್ (ಭೂಗೋಳ)", "ನಕ್ಷೆ", "ಚಿತ್ರ", "ಯೋಜನೆ"),
            correctAnswer = "ಗ್ಲೋಬ್ (ಭೂಗೋಳ)",
            explanation = "ಗ್ಲೋಬ್ ಭೂಮಿಯ ಆಕಾರ ಮತ್ತು ಖಂಡ-ಸಾಗರಗಳ ಸ್ಥಾನವನ್ನು ನಿಖರವಾಗಿ ಬಿಂಬಿಸುವ ಗೋಳ ಮಾದರಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u11_2",
            stdId = 6,
            subjectId = "social",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭೂಮಿಯನ್ನು ಉತ್ತರ ಮತ್ತು ದಕ್ಷಿಣ ಗೋಳಾರ್ಧಗಳಾಗಿ ವಿಭಜಿಸುವ 0° ಅಕ್ಷಾಂಶ ಯಾವುದು?",
            options = listOf("ವಿಷುವದ್ವೃತ್ತ (ಸಮಭಾಜಕ ವೃತ್ತ)", "ಕರ್ಕಾಟಕ ಸಂಕ್ರಾಂತಿ ವೃತ್ತ", "ಮಕರ ಸಂಕ್ರಾಂತಿ ವೃತ್ತ", "ಗ್ರೀನ್‌ವಿಚ್ ರೇಖಾಂಶ"),
            correctAnswer = "ವಿಷುವದ್ವೃತ್ತ (ಸಮಭಾಜಕ ವೃತ್ತ)",
            explanation = "0° ಅಕ್ಷಾಂಶ ರೇಖೆಯನ್ನು ಸಮಭಾಜಕ ವೃತ್ತ ಅಥವಾ ವಿಷುವದ್ವೃತ್ತ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u11_3",
            stdId = 6,
            subjectId = "social",
            unitId = 11,
            type = "MCQ",
            questionText = "0° ಪ್ರಧಾನ ರೇಖಾಂಶವು (ಗ್ರೀನ್‌ವಿಚ್ ರೇಖೆ) ಹಾದುಹೋಗುವ ದೇಶ ಯಾವುದು?",
            options = listOf("ಇಂಗ್ಲೆಂಡ್ (ಲಂಡನ್)", "ಭಾರತ", "ಫ್ರಾನ್ಸ್", "ಅಮೆರಿಕ"),
            correctAnswer = "ಇಂಗ್ಲೆಂಡ್ (ಲಂಡನ್)",
            explanation = "ಲಂಡನ್ ಬಳಿಯ ಗ್ರೀನ್‌ವಿಚ್ ಮೂಲಕ 0° ಮೂಲ ರೇಖಾಂಶವು ಹಾದುಹೋಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u11_4",
            stdId = 6,
            subjectId = "social",
            unitId = 11,
            type = "MCQ",
            questionText = "ನಕ್ಷೆಗಳ ಸಂಗ್ರಹವಿರುವ ಪುಸ್ತಕಕ್ಕೆ ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಅಟ್ಲಾಸ್ (ನಕ್ಷಾ ಪುಸ್ತಕ)", "ವಿಶ್ವಕೋಶ", "ನಿಘಂಟು", "ದಿನಚರಿ"),
            correctAnswer = "ಅಟ್ಲಾಸ್ (ನಕ್ಷಾ ಪುಸ್ತಕ)",
            explanation = "ವಿವಿಧ ಬಗೆಯ ನಕ್ಷೆಗಳನ್ನು ವ್ಯವಸ್ಥಿತವಾಗಿ ಹೊಂದಿರುವ ಪುಸ್ತಕವನ್ನು ಅಟ್ಲಾಸ್ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u11_5",
            stdId = 6,
            subjectId = "social",
            unitId = 11,
            type = "MCQ",
            questionText = "ನಕ್ಷೆಯಲ್ಲಿ ಮೇಲ್ಭಾಗವು ಯಾವಾಗಲೂ ಯಾವ ದಿಕ್ಕನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಉತ್ತರ", "ದಕ್ಷಿಣ", "ಪೂರ್ವ", "ಪಶ್ಚಿಮ"),
            correctAnswer = "ಉತ್ತರ",
            explanation = "ನಕ್ಷೆಯ ಸಂಪ್ರದಾಯದ ಪ್ರಕಾರ ಮೇಲ್ಭಾಗವು ಉತ್ತರ ದಿಕ್ಕನ್ನು (North) ಸೂಚಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u11_6",
            stdId = 6,
            subjectId = "social",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಮೇಲಿರುವ ಒಟ್ಟು ಅಕ್ಷಾಂಶ ರೇಖೆಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("181", "360", "180", "90"),
            correctAnswer = "181",
            explanation = "ಸಮಭಾಜಕ ವೃತ್ತ (1) + ಉತ್ತರದಲ್ಲಿ 90 + ದಕ್ಷಿಣದಲ್ಲಿ 90 ಸೇರಿದಂತೆ ಒಟ್ಟು 181 ಅಕ್ಷಾಂಶಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u11_7",
            stdId = 6,
            subjectId = "social",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಮೇಲಿರುವ ಒಟ್ಟು ರೇಖಾಂಶ ರೇಖೆಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("360", "180", "181", "90"),
            correctAnswer = "360",
            explanation = "ಭೂಮಿಯ ಸುತ್ತಲೂ ಒಟ್ಟು 360 ರೇಖಾಂಶ ರೇಖೆಗಳಿವೆ (ಪೂರ್ವ 180 ಮತ್ತು ಪಶ್ಚಿಮ 180)."
        ),
        QuestionModel(
            id = "s_6_soc_u11_8",
            stdId = 6,
            subjectId = "social",
            unitId = 11,
            type = "MCQ",
            questionText = "ನಕ್ಷೆಗಳನ್ನು ಸಿದ್ಧಪಡಿಸುವ ವಿಜ್ಞಾನ ಮತ್ತು ಕಲೆಯನ್ನು ಏನೆನ್ನುತ್ತಾರೆ?",
            options = listOf("ಕಾರ್ಟೋಗ್ರಫಿ (ನಕ್ಷಾಶಾಸ್ತ್ರ)", "ಕ್ಲೈಮ್ಯಾಟಾಲಜಿ", "ಜಿಆಲಜಿ", "ಮೆಟಿಯೊರಾಲಜಿ"),
            correctAnswer = "ಕಾರ್ಟೋಗ್ರಫಿ (ನಕ್ಷಾಶಾಸ್ತ್ರ)",
            explanation = "ನಕ್ಷೆ ತಯಾರಿಕಾ ಶಾಸ್ತ್ರವನ್ನು ಕಾರ್ಟೋಗ್ರಫಿ (Cartography) ಎನ್ನಲಾಗುತ್ತದೆ."
        ),

        // ==========================================
        // ಅಧ್ಯಾಯ 12: ಏಷ್ಯಾ: ವೈವಿಧ್ಯತೆಗಳ ಖಂಡ (11 ಪ್ರಶ್ನೆಗಳು)
        // ==========================================
        QuestionModel(
            id = "s_6_soc_u12_1",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿಶ್ವದ ಅತ್ಯಂತ ದೊಡ್ಡ ಖಂಡ ಯಾವುದು?",
            options = listOf("ಏಷ್ಯಾ", "ಆಫ್ರಿಕಾ", "ಉತ್ತರ ಅಮೆರಿಕ", "ಯುರೋಪ್"),
            correctAnswer = "ಏಷ್ಯಾ",
            explanation = "ವಿಸ್ತೀರ್ಣ ಮತ್ತು ಜನಸಂಖ್ಯೆ ಎರಡರಲ್ಲೂ ಏಷ್ಯಾ ಖಂಡವು ವಿಶ್ವದಲ್ಲೇ ಅತಿ ದೊಡ್ಡದಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_2",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿಶ್ವದ ಅತ್ಯಂತ ಎತ್ತರವಾದ ಪರ್ವತ ಶಿಖರ ಮೌಂಟ್ ಎವರೆಸ್ಟ್ ಯಾವ ಶ್ರೇಣಿಯಲ್ಲಿದೆ?",
            options = listOf("ಹಿಮಾಲಯ ಶ್ರೇಣಿ", "ಆಂಡಿಸ್", "ಆಲ್ಪ್ಸ್", "ರಾಕಿ"),
            correctAnswer = "ಹಿಮಾಲಯ ಶ್ರೇಣಿ",
            explanation = "8,848.86 ಮೀಟರ್ ಎತ್ತರದ ಮೌಂಟ್ ಎವರೆಸ್ಟ್ ಹಿಮಾಲಯ ಪರ್ವತ ಶ್ರೇಣಿಯಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_3",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ವಿಶ್ವದ ಮೇಲ್ಛಾವಣಿ’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ಪ್ರಸ್ಥಭೂಮಿ ಯಾವುದು?",
            options = listOf("ಪಾಮಿರ್ ಪ್ರಸ್ಥಭೂಮಿ", "ದಖನ್ ಪ್ರಸ್ಥಭೂಮಿ", "ಅರೇಬಿಯನ್ ಪ್ರಸ್ಥಭೂಮಿ", "ಕೊಲೊರಾಡೊ ಪ್ರಸ್ಥಭೂಮಿ"),
            correctAnswer = "ಪಾಮಿರ್ ಪ್ರಸ್ಥಭೂಮಿ",
            explanation = "ಅತ್ಯಂತ ಎತ್ತರದಲ್ಲಿರುವ ಪಾಮಿರ್ ಗಂಟು/ಪ್ರಸ್ಥಭೂಮಿಯನ್ನು ಪ್ರಪಂಚದ ಮೇಲ್ಛಾವಣಿ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_4",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿಶ್ವದಲ್ಲೇ ಅತ್ಯಂತ ಹೆಚ್ಚು ಆಳವಾದ ಸಿಹಿನೀರಿನ ಸರೋವರ ಯಾವುದು?",
            options = listOf("ಬೈಕಲ್ ಸರೋವರ", "ಕ್ಯಾಸ್ಪಿಯನ್ ಸಮುದ್ರ", "ವಿಕ್ಟೋರಿಯಾ ಸರೋವರ", "ಸುಪೀರಿಯರ್ ಸರೋವರ"),
            correctAnswer = "ಬೈಕಲ್ ಸರೋವರ",
            explanation = "ರಷ್ಯಾದ ಸೈಬೀರಿಯಾದಲ್ಲಿರುವ ಬೈಕಲ್ ಸರೋವರವು ವಿಶ್ವದ ಅತಿ ಆಳವಾದ ಸಿಹಿನೀರಿನ ಸರೋವರವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_5",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "ಏಷ್ಯಾ ಖಂಡದ ಅತ್ಯಂತ ಉದ್ದವಾದ ನದಿ ಯಾವುದು?",
            options = listOf("ಯಾಂಗ್ಟ್ಸಿ (ಚೀನಾ)", "ಹೊವಾಂಗ್ ಹೋ", "ಗಂಗಾ", "ಮೆಕಾಂಗ್"),
            correctAnswer = "ಯಾಂಗ್ಟ್ಸಿ (ಚೀನಾ)",
            explanation = "ಚೀನಾದ ಯಾಂಗ್ಟ್ಸಿ ನದಿಯು ಏಷ್ಯಾ ಖಂಡದ ಅತ್ಯಂತ ಉದ್ದವಾದ ನದಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_6",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿಶ್ವದಲ್ಲೇ ಅತ್ಯಂತ ಹೆಚ್ಚು ಮಳೆ ಪಡೆಯುವ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಮೌಸಿನ್‌ರಾಮ್ (ಭಾರತ)", "ಚಿರಾಪುಂಜಿ", "ಅಗುಂಬೆ", "ಟೋಕಿಯೋ"),
            correctAnswer = "ಮೌಸಿನ್‌ರಾಮ್ (ಭಾರತ)",
            explanation = "ಭಾರತದ ಮೇಘಾಲಯ ರಾಜ್ಯದ ಮೌಸಿನ್‌ರಾಮ್ ಜಗತ್ತಿನಲ್ಲೇ ಗರಿಷ್ಠ ವಾರ್ಷಿಕ ಮಳೆ ಪಡೆಯುವ ಸ್ಥಳವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_7",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಅತ್ಯಂತ ತಗ್ಗಾದ ಭೂಪ್ರದೇಶ (ಸಮುದ್ರ ಮಟ್ಟಕ್ಕಿಂತ ಕೆಳಗಿರುವ) ಯಾವುದು?",
            options = listOf("ಮೃತ ಸಮುದ್ರ (Dead Sea)", "ಕ್ಯಾಸ್ಪಿಯನ್ ಸಮುದ್ರ", "ಕೆಂಪು ಸಮುದ್ರ", "ಕಪ್ಪು ಸಮುದ್ರ"),
            correctAnswer = "ಮೃತ ಸಮುದ್ರ (Dead Sea)",
            explanation = "ಇಸ್ರೇಲ್ ಮತ್ತು ಜೋರ್ಡಾನ್ ಗಡಿಯಲ್ಲಿರುವ ಮೃತ ಸಮುದ್ರದ ತೀರವು ಸಮುದ್ರ ಮಟ್ಟಕ್ಕಿಂತ ಸುಮಾರು 400 ಮೀಟರ್ ಕೆಳಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_8",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "ಏಷ್ಯಾ ಮತ್ತು ಯುರೋಪ್ ಖಂಡಗಳನ್ನು ಪ್ರತ್ಯೇಕಿಸುವ ನೈಸರ್ಗಿಕ ಗಡಿ ಪರ್ವತಗಳು:",
            options = listOf("ಯುರಾಲ್ ಪರ್ವತಗಳು", "ಹಿಮಾಲಯ", "ಆಲ್ಪ್ಸ್", "ಅಟ್ಲಾಸ್"),
            correctAnswer = "ಯುರಾಲ್ ಪರ್ವತಗಳು",
            explanation = "ಯುರಾಲ್ ಪರ್ವತಗಳು ಮತ್ತು ಕ್ಯಾಸ್ಪಿಯನ್ ಸಮುದ್ರವು ಏಷ್ಯಾ ಹಾಗೂ ಯುರೋಪ್ ನಡುವೆ ಗಡಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_9",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಉದಯಿಸುವ ಸೂರ್ಯನ ನಾಡು’ ಎಂದು ಕರೆಯಲ್ಪಡುವ ಏಷ್ಯಾದ ದೇಶ:",
            options = listOf("ಜಪಾನ್", "ಚೀನಾ", "ಭಾರತ", "ಇಂಡೋನೇಷ್ಯಾ"),
            correctAnswer = "ಜಪಾನ್",
            explanation = "ಪೂರ್ವದ ತುತ್ತತುದಿಯಲ್ಲಿರುವ ಜಪಾನನ್ನು ಉದಯಿಸುವ ಸೂರ್ಯನ ನಾಡು ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_10",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "ಏಷ್ಯಾದ ಪ್ರಮುಖ ಶೀತ ಮರುಭೂಮಿ ಯಾವುದು?",
            options = listOf("ಗೋಬಿ ಮರುಭೂಮಿ", "ಥಾರ್ ಮರುಭೂಮಿ", "ಅರೇಬಿಯನ್ ಮರುಭೂಮಿ", "ಸಹಾರಾ ಮರುಭೂಮಿ"),
            correctAnswer = "ಗೋಬಿ ಮರುಭೂಮಿ",
            explanation = "ಮಂಗೋಲಿಯಾ ಮತ್ತು ಚೀನಾದಲ್ಲಿ ಹರಡಿರುವ ಗೋಬಿ ಮರುಭೂಮಿಯು ಪ್ರಸಿದ್ಧ ಶೀತ ಮರುಭೂಮಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_soc_u12_11",
            stdId = 6,
            subjectId = "social",
            unitId = 12,
            type = "MCQ",
            questionText = "ಭಾರತ ಮತ್ತು ಶ್ರೀಲಂಕಾವನ್ನು ಪ್ರತ್ಯೇಕಿಸುವ ಜಲಸಂಧಿ ಯಾವುದು?",
            options = listOf("ಪಾಕ್ ಜಲಸಂಧಿ", "ಮಲಕ್ಕಾ ಜಲಸಂಧಿ", "ಜಿಬ್ರಾಲ್ಟರ್ ಜಲಸಂಧಿ", "ಬೇರಿಂಗ್ ಜಲಸಂಧಿ"),
            correctAnswer = "ಪಾಕ್ ಜಲಸಂಧಿ",
            explanation = "ಭಾರತ ಮತ್ತು ಶ್ರೀಲಂಕಾ ನಡುವೆ ಪಾಕ್ ಜಲಸಂಧಿ (Palk Strait) ಇದೆ."
        )
    )
}
