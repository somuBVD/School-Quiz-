package com.example.data

/**
 * Standard 6 Science (Kannada Medium - LBA Revised 2026-27)
 * Question bank containing text-verified MCQs across all 12 Chapters.
 */
object Std6ScienceQuestionBank {

    val units = listOf(
        UnitTemplate(1, "ಅಧ್ಯಾಯ 1: ವಿಜ್ಞಾನದ ಅದ್ಭುತ ಪ್ರಪಂಚ", 26, "Easy"),
        UnitTemplate(2, "ಅಧ್ಯಾಯ 2: ಜೀವಜಗತ್ತಿನಲ್ಲಿ ವೈವಿಧ್ಯತೆ", 17, "Medium"),
        UnitTemplate(3, "ಅಧ್ಯಾಯ 3: ಮನದುಂಬಿದ ಊಟ — ಸ್ವಸ್ಥ ಶರೀರಕ್ಕೆ ಸೋಪಾನ", 25, "Medium"),
        UnitTemplate(4, "ಅಧ್ಯಾಯ 4: ಕಾಂತಗಳ ಅನ್ವೇಷಣೆ", 15, "Medium"),
        UnitTemplate(5, "ಅಧ್ಯಾಯ 5: ಉದ್ದದ ಅಳತೆ ಮತ್ತು ಚಲನೆ", 12, "Medium"),
        UnitTemplate(6, "ಅಧ್ಯಾಯ 6: ನಮ್ಮ ಸುತ್ತಲಿನ ಸಾಮಗ್ರಿಗಳು", 12, "Easy"),
        UnitTemplate(7, "ಅಧ್ಯಾಯ 7: ಶಾಖ ಮತ್ತು ಅದರ ಮಾಪನ", 14, "Medium"),
        UnitTemplate(8, "ಅಧ್ಯಾಯ 8: ನೀರಿನ ಸ್ಥಿತಿಗಳ ಮೂಲಕ ಒಂದು ಪಯಣ", 14, "Easy"),
        UnitTemplate(9, "ಅಧ್ಯಾಯ 9: ದೈನಂದಿನ ಜೀವನದಲ್ಲಿ ಬೇರ್ಪಡಿಸುವಿಕೆಯ ವಿಧಾನಗಳು", 17, "Medium"),
        UnitTemplate(10, "ಅಧ್ಯಾಯ 10: ಜೀವಿಗಳು — ಅವುಗಳ ಗುಣಗಳ ಅನ್ವೇಷಣೆ", 16, "Medium"),
        UnitTemplate(11, "ಅಧ್ಯಾಯ 11: ನಿಸರ್ಗದ ಸಂಪತ್ತು", 15, "Easy"),
        UnitTemplate(12, "ಅಧ್ಯಾಯ 12: ಭೂಮಿಯಿಂದ ಆಚೆ", 8, "Medium")
    )

    val questions: List<QuestionModel> = listOf(
        // ==================== ಅಧ್ಯಾಯ 1: ವಿಜ್ಞಾನದ ಅದ್ಭುತ ಪ್ರಪಂಚ ====================
        QuestionModel(
            id = "s_6_sci_u1_1",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕುತೂಹಲ ನಮಗೆ ಏನನ್ನು ಕೇಳಲು ಪ್ರೇರಣೆ ನೀಡುತ್ತದೆ?",
            options = listOf("ಉತ್ತರ", "ಕಥೆ", "ಪ್ರಶ್ನೆ", "ಅನಿಸಿಕೆ"),
            correctAnswer = "ಪ್ರಶ್ನೆ",
            explanation = "ಕುತೂಹಲವು ಜಗತ್ತನ್ನು ಅರಿಯಲು ಹೊಸ ಹೊಸ ಪ್ರಶ್ನೆಗಳನ್ನು ಕೇಳಲು ಪ್ರೇರೇಪಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_2",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನವು ನಮಗೆ ಏನನ್ನು ಅರ್ಥಮಾಡಿಕೊಳ್ಳಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ?",
            options = listOf("ಕಲೆ", "ಪರಿಸರ", "ಸಂಗೀತ", "ನೃತ್ಯ"),
            correctAnswer = "ಪರಿಸರ",
            explanation = "ವಿಜ್ಞಾನವು ನಮ್ಮ ಸುತ್ತಮುತ್ತಲಿನ ಪರಿಸರ ಮತ್ತು ನೈಸರ್ಗಿಕ ಪ್ರಕ್ರಿಯೆಗಳನ್ನು ಅರ್ಥಮಾಡಿಕೊಳ್ಳಲು ನೆರವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_3",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ನೀರು ಇಲ್ಲಿಂದ ದೊರೆಯುತ್ತದೆ:",
            options = listOf("ನದಿ", "ಕೆರೆ", "ಕೊಳ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ನದಿ, ಕೆರೆ ಮತ್ತು ಕೊಳಗಳು ನೈಸರ್ಗಿಕ ಜಲಮೂಲಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_4",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಜಗತ್ತನ್ನು ಅನ್ವೇಷಿಸಲು ಮತ್ತು ಅರ್ಥಮಾಡಿಕೊಳ್ಳಲು ಯಾವ ವಿಷಯ ಸಹಾಯ ಮಾಡುತ್ತದೆ?",
            options = listOf("ಸಮಾಜ", "ವಿಜ್ಞಾನ", "ಕನ್ನಡ", "ಗಣಿತ"),
            correctAnswer = "ವಿಜ್ಞಾನ",
            explanation = "ವಿಜ್ಞಾನವು ಪ್ರಕೃತಿಯ ನಿಯಮಗಳನ್ನು ಮತ್ತು ಜಗತ್ತಿನ ವಿದ್ಯಮಾನಗಳನ್ನು ಅನ್ವೇಷಿಸಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_5",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನವು ಇದರ ಮೇಲೆ ಅವಲಂಬಿತವಾಗಿದೆ:",
            options = listOf("ಅಭಿಪ್ರಾಯಗಳು", "ಮೂಢನಂಬಿಕೆಗಳು", "ಪ್ರಯೋಗಗಳು", "ಕಥೆಗಳು"),
            correctAnswer = "ಪ್ರಯೋಗಗಳು",
            explanation = "ವಿಜ್ಞಾನವು ಆಧಾರಗಳು ಮತ್ತು ವ್ಯವಸ್ಥಿತ ಪ್ರಯೋಗಗಳ ಮೇಲೆ ನಿಂತಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_6",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಜೀವಿಗಳಿರುವ ಏಕೈಕ ಗ್ರಹ ಯಾವುದು?",
            options = listOf("ಮಂಗಳ", "ಗುರು", "ಬುಧ", "ಭೂಮಿ"),
            correctAnswer = "ಭೂಮಿ",
            explanation = "ಸೌರವ್ಯೂಹದಲ್ಲಿ ಜೀವಜಾಲಕ್ಕೆ ಸೂಕ್ತ ಪರಿಸರವಿರುವ ಏಕೈಕ ಗ್ರಹ ಭೂಮಿ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_7",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಭೂಮಿಯು ಬೆಳಕು ಮತ್ತು ಶಾಖವನ್ನು ಇದರಿಂದ ಪಡೆಯುತ್ತದೆ:",
            options = listOf("ಸೂರ್ಯ", "ಚಂದ್ರ", "ಉಪಗ್ರಹ", "ನಕ್ಷತ್ರ"),
            correctAnswer = "ಸೂರ್ಯ",
            explanation = "ಸೂರ್ಯನು ಭೂಮಿಯ ಪ್ರಾಥಮಿಕ ಬೆಳಕು ಮತ್ತು ಶಾಖದ ನೈಸರ್ಗಿಕ ಮೂಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_8",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬೀಜವು ಗಿಡವಾಗಿ ಬೆಳೆಯಲು ಬೇಕಾದ ಅಂಶಗಳು ಯಾವುವು?",
            options = listOf("ಮಣ್ಣು", "ಗಾಳಿ", "ಪೋಷಕಾಂಶಗಳು", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಬೀಜ ಮೊಳಕೆಯೊಡೆದು ಸಸ್ಯವಾಗಿ ಬೆಳೆಯಲು ಮಣ್ಣು, ಗಾಳಿ, ನೀರು ಮತ್ತು ಪೋಷಕಾಂಶಗಳೆಲ್ಲವೂ ಅಗತ್ಯ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_9",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ನೀರು ಮಂಜುಗಡ್ಡೆಯಾಗುವುದು ಯಾವಾಗ?",
            options = listOf("ಬಿಸಿ ಮಾಡಿದಾಗ", "ಕುದಿಸಿದಾಗ", "ತಂಪು ಮಾಡಿದಾಗ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ತಂಪು ಮಾಡಿದಾಗ",
            explanation = "ನೀರನ್ನು ತಂಪುಗೊಳಿಸಿ 0°C ಗೆ ತಂದಾಗ ಅದು ಘನೀಕರಿಸಿ ಮಂಜುಗಡ್ಡೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_10",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ಬಹಳಷ್ಟು ಸಂದರ್ಭಗಳಲ್ಲಿ ನೈಸರ್ಗಿಕ ಘಟನೆ ಅಲ್ಲ?",
            options = listOf("ಕಾಮನಬಿಲ್ಲು", "ಮಿಂಚು", "ಮಾಲಿನ್ಯ", "ಮಳೆ"),
            correctAnswer = "ಮಾಲಿನ್ಯ",
            explanation = "ಮಾಲಿನ್ಯವು ಮಾನವನ ಚಟುವಟಿಕೆಗಳಿಂದ ಉಂಟಾಗುವ ಮಾನವ ನಿರ್ಮಿತ ಸಮಸ್ಯೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_11",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ವೈಜ್ಞಾನಿಕ ವಿಧಾನದ ಹಂತವಲ್ಲ?",
            options = listOf("ಊಹೆ", "ತೀರ್ಮಾನ", "ಕನಸು", "ಪ್ರಶ್ನೆ"),
            correctAnswer = "ಕನಸು",
            explanation = "ಪ್ರಶ್ನಿಸುವಿಕೆ, ಪರಿಕಲ್ಪನೆ (ಊಹೆ), ಪ್ರಯೋಗ ಮತ್ತು ತೀರ್ಮಾನಗಳು ವೈಜ್ಞಾನಿಕ ವಿಧಾನದ ಹಂತಗಳು; ಕನಸು ಇದರಲ್ಲಿ ಸೇರುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_12",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವೈಜ್ಞಾನಿಕ ವಿಧಾನವು ಏನನ್ನು ಒಳಗೊಂಡಿದೆ?",
            options = listOf("ಊಹೆಯ ಕೆಲಸ", "ಮೂಢನಂಬಿಕೆ", "ಕ್ರಮಬದ್ಧವಾದ ತನಿಖೆ", "ಯಾದೃಚ್ಛಿಕ ಪ್ರಯೋಗ"),
            correctAnswer = "ಕ್ರಮಬದ್ಧವಾದ ತನಿಖೆ",
            explanation = "ವೈಜ್ಞಾನಿಕ ವಿಧಾನವು ಕ್ರಮಬದ್ಧ ಮತ್ತು ವ್ಯವಸ್ಥಿತ ತನಿಖಾ ಹಂತಗಳನ್ನು ಒಳಗೊಂಡಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_13",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಅನ್ವೇಷಣೆ ಮತ್ತು ಪ್ರಶ್ನಿಸುವಿಕೆಯು ಯಾವ ಹಂತದಿಂದ ಪ್ರಾರಂಭವಾಗುತ್ತದೆ?",
            options = listOf("ಬಾಲ್ಯದಿಂದ", "ವೃದ್ಧಾಪ್ಯದಿಂದ", "ಶಾಲೆ ಮುಗಿದ ನಂತರ", "ಉದ್ಯೋಗದಿಂದ"),
            correctAnswer = "ಬಾಲ್ಯದಿಂದ",
            explanation = "ಮಕ್ಕಳಲ್ಲಿ ಸಹಜ ಕುತೂಹಲವಿರುವುದರಿಂದ ಅನ್ವೇಷಣೆ ಮತ್ತು ಪ್ರಶ್ನಿಸುವಿಕೆ ಬಾಲ್ಯದಿಂದಲೇ ಶುರುವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_14",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನದ ಅತ್ಯಂತ ರೋಚಕ ವಿಚಾರವೆಂದರೆ ಅದು ________.",
            options = listOf("ಸೀಮಿತವಾಗಿದೆ", "ಸರ್ವವ್ಯಾಪಿಯಾಗಿದೆ", "ಬದಲಾಗುವುದಿಲ್ಲ", "ಕೇವಲ ಪುಸ್ತಕಗಳಲ್ಲಿದೆ"),
            correctAnswer = "ಸರ್ವವ್ಯಾಪಿಯಾಗಿದೆ",
            explanation = "ವಿಜ್ಞಾನವು ನಮ್ಮ ದೈನಂದಿನ ಜೀವನದ ಪ್ರತಿಯೊಂದು ಅಂಗದಲ್ಲೂ ಸರ್ವವ್ಯಾಪಿಯಾಗಿ ಅಡಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_15",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನವು ಬೃಹತ್ ಮತ್ತು ಕೊನೆಯಾಗದ ________ ನಂತಿದೆ.",
            options = listOf("ಆಟ", "ಒಗಟು", "ಕಥೆ", "ಚಿತ್ರ"),
            correctAnswer = "ಒಗಟು",
            explanation = "ವಿಜ್ಞಾನವು ನಿರಂತರವಾಗಿ ಹೊಸ ರಹಸ್ಯಗಳನ್ನು ಬಿಡಿಸುವ ಒಂದು ಬೃಹತ್ ಒಗಟಿನಂತಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_16",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ನೂತನ ಆವಿಷ್ಕಾರಗಳು ಪ್ರಪಂಚದ ಬಗೆಗಿನ ನಮ್ಮ ಸಾಮಾನ್ಯ ತಿಳುವಳಿಕೆಯನ್ನು ________ ಮಾಡುತ್ತವೆ.",
            options = listOf("ಕಡಿಮೆ", "ಸ್ಥಿರ", "ಬದಲಾವಣೆ", "ನಾಶ"),
            correctAnswer = "ಬದಲಾವಣೆ",
            explanation = "ಹೊಸ ಸಂಶೋಧನೆಗಳು ಪ್ರಪಂಚದ ಬಗೆಗಿನ ನಮ್ಮ ತಿಳುವಳಿಕೆಯನ್ನು ಪರಿಷ್ಕರಿಸಿ ಬದಲಾವಣೆ ತರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_17",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಚಳಿಗಾಲದಲ್ಲಿ ________ ನೀರಿನ ಸ್ನಾನವು ಆರಾಮದಾಯಕ.",
            options = listOf("ತಣ್ಣನೆಯ", "ಬಿಸಿ", "ಮಂಜುಗಡ್ಡೆಯ", "ಉಪ್ಪಿನ"),
            correctAnswer = "ಬಿಸಿ",
            explanation = "ಚಳಿಗಾಲದ ಕಡಿಮೆ ತಾಪಮಾನದಲ್ಲಿ ಬಿಸಿನೀರಿನ ಸ್ನಾನವು ದೇಹಕ್ಕೆ ಹಿತಕರ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_18",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪ್ರಯೋಗಗಳ ಮೂಲಕ ಉತ್ತರಗಳನ್ನು ಕಂಡುಹಿಡಿಯುವ ಪ್ರಕ್ರಿಯೆಯನ್ನು ________ ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ವೈಜ್ಞಾನಿಕ ವಿಧಾನ", "ಮೂಢನಂಬಿಕೆ", "ಕಲ್ಪನೆ", "ಆಟ"),
            correctAnswer = "ವೈಜ್ಞಾನಿಕ ವಿಧಾನ",
            explanation = "ವ್ಯವಸ್ಥಿತ ವೀಕ್ಷಣೆ ಮತ್ತು ಪ್ರಯೋಗಗಳಿಂದ ಉತ್ತರ ಪಡೆಯುವ ವಿಧಾನವೇ ವೈಜ್ಞಾನಿಕ ವಿಧಾನ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_19",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಸ್ತುಗಳನ್ನು ಸೂಕ್ಷ್ಮವಾಗಿ ಗಮನಿಸುವ ಕ್ರಿಯೆಯನ್ನು ________ ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ಊಹೆ", "ವೀಕ್ಷಣೆ", "ತೀರ್ಮಾನ", "ಪ್ರಯೋಗಾಲಯ"),
            correctAnswer = "ವೀಕ್ಷಣೆ",
            explanation = "ಘಟನೆಗಳು ಮತ್ತು ವಸ್ತುಗಳನ್ನು ಎಚ್ಚರಿಕೆಯಿಂದ ಗಮನಿಸುವುದೇ ವೀಕ್ಷಣೆ (Observation)."
        ),
        QuestionModel(
            id = "s_6_sci_u1_20",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪರೀಕ್ಷಿಸಬಹುದಾದ ವಿವರಣೆಯನ್ನು ________ ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ನಂಬಿಕೆ", "ತೀರ್ಮಾನ", "ಊಹೆ", "ಅಭಿಪ್ರಾಯ"),
            correctAnswer = "ಊಹೆ",
            explanation = "ವೈಜ್ಞಾನಿಕವಾಗಿ ಪರೀಕ್ಷಿಸಬಹುದಾದ ಆರಂಭಿಕ ವಿವರಣೆಯನ್ನು ಪರಿಕಲ್ಪನೆ ಅಥವಾ ಊಹೆ (Hypothesis) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_21",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ನಾವು ಪ್ರಯೋಗಗಳನ್ನು ಮಾಡುವ ಸ್ಥಳ ________.",
            options = listOf("ಗ್ರಂಥಾಲಯ", "ವಿಜ್ಞಾನ ಪ್ರಯೋಗಾಲಯ", "ಆಟದ ಮೈದಾನ", "ಕಚೇರಿ"),
            correctAnswer = "ವಿಜ್ಞಾನ ಪ್ರಯೋಗಾಲಯ",
            explanation = "ವಿಜ್ಞಾನದ ಪ್ರಯೋಗಗಳನ್ನು ವಿಜ್ಞಾನ ಪ್ರಯೋಗಾಲಯದಲ್ಲಿ (Science Laboratory) ನಡೆಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_22",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನವು ನಮಗೆ ________ ಬಗೆಹರಿಸಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ.",
            options = listOf("ಸಮಸ್ಯೆಗಳನ್ನು", "ಹಾಡುಗಳನ್ನು", "ಚಿತ್ರಗಳನ್ನು", "ಕಥೆಗಳನ್ನು"),
            correctAnswer = "ಸಮಸ್ಯೆಗಳನ್ನು",
            explanation = "ದೈನಂದಿನ ಜೀವನದ ತಾರ್ಕಿಕ ಮತ್ತು ಪ್ರಾಯೋಗಿಕ ಸಮಸ್ಯೆಗಳನ್ನು ಬಗೆಹರಿಸಲು ವಿಜ್ಞಾನ ನೆರವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_23",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನಿಗಳು ಪರಿಸರವನ್ನು ಅರ್ಥಮಾಡಿಕೊಳ್ಳಲು ________ ವಿಧಾನವನ್ನು ಬಳಸುತ್ತಾರೆ.",
            options = listOf("ವೈಜ್ಞಾನಿಕ", "ಮೂಢನಂಬಿಕೆಯ", "ಕಾಲ್ಪನಿಕ", "ಅಸಂಬದ್ಧ"),
            correctAnswer = "ವೈಜ್ಞಾನಿಕ",
            explanation = "ವಿಜ್ಞಾನಿಗಳು ಸತ್ಯವನ್ನು ಶೋಧಿಸಲು ಕ್ರಮಬದ್ಧ ವೈಜ್ಞಾನಿಕ ವಿಧಾನವನ್ನು ಬಳಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_24",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನದಲ್ಲಿ ಕಲ್ಪನೆಗಳನ್ನು ________ ಮಾಡಿ ಪರೀಕ್ಷಿಸಲಾಗುತ್ತದೆ.",
            options = listOf("ಮರೆಮಾಡಿ", "ಪ್ರಯೋಗ", "ತಿರಸ್ಕರಿಸಿ", "ಬರೆಯದೆ"),
            correctAnswer = "ಪ್ರಯೋಗ",
            explanation = "ಯಾವುದೇ ಕಲ್ಪನೆಯ ಸತ್ಯಾಸತ್ಯತೆಯನ್ನು ಪ್ರಯೋಗಗಳ ಮೂಲಕ ಪರೀಕ್ಷಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_25",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ದೊಡ್ಡ ಸಮಸ್ಯೆಗಳನ್ನು ಪರಿಹರಿಸಲು ವಿಜ್ಞಾನಿಗಳು ಬಹುಪಾಲು ________ಗಳಲ್ಲಿ ಕೆಲಸ ಮಾಡುತ್ತಾರೆ.",
            options = listOf("ಒಬ್ಬರೇ", "ತಂಡ", "ಪ್ರೇಕ್ಷಕರ", "ಆಟಗಾರರ"),
            correctAnswer = "ತಂಡ",
            explanation = "ಸಂಕೀರ್ಣ ಸಮಸ್ಯೆಗಳಿಗೆ ಸಾಮೂಹಿಕ ಪರಿಹಾರ ಕಂಡುಕೊಳ್ಳಲು ತಂಡಗಳಲ್ಲಿ (Teams) ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u1_26",
            stdId = 6,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವೈಜ್ಞಾನಿಕ ವಿಧಾನವನ್ನು ಅನುಸರಿಸುವ ವ್ಯಕ್ತಿ ________ರಂತೆ ಕೆಲಸ ಮಾಡುತ್ತಾರೆ.",
            options = listOf("ಕಲಾವಿದ", "ವಿಜ್ಞಾನಿ", "ವ್ಯಾಪಾರಿ", "ಕ್ರೀಡಾಪಟು"),
            correctAnswer = "ವಿಜ್ಞಾನಿ",
            explanation = "ವೈಜ್ಞಾನಿಕ ಮನೋಭಾವ ಮತ್ತು ವಿಧಾನವನ್ನು ಅಳವಡಿಸಿಕೊಂಡವರು ವಿಜ್ಞಾನಿಯಂತೆ ಆಲೋಚಿಸಿ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತಾರೆ."
        ),

        // ==================== ಅಧ್ಯಾಯ 2: ಜೀವಜಗತ್ತಿನಲ್ಲಿ ವೈವಿಧ್ಯತೆ ====================
        QuestionModel(
            id = "s_6_sci_u2_1",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ತಪ್ಪಾದ ಹೇಳಿಕೆ ಯಾವುದು?",
            options = listOf(
                "ಕಡಲೆ – ಸಮಾಂತರ ನಾಳವಿನ್ಯಾಸ",
                "ಗೋಧಿ – ಸಮಾಂತರ ನಾಳವಿನ್ಯಾಸ",
                "ಮೆಕ್ಕೆಜೋಳ – ಸಮಾಂತರ ನಾಳವಿನ್ಯಾಸ",
                "ರಾಗಿ – ಸಮಾಂತರ ನಾಳವಿನ್ಯಾಸ"
            ),
            correctAnswer = "ಕಡಲೆ – ಸಮಾಂತರ ನಾಳವಿನ್ಯಾಸ",
            explanation = "ಕಡಲೆಯು ದ್ವಿದಳ ಸಸ್ಯವಾಗಿದ್ದು, ಜಾಲರೂಪದ ನಾಳವಿನ್ಯಾಸವನ್ನು ಹೊಂದಿರುತ್ತದೆ; ಸಮಾಂತರ ನಾಳವಿನ್ಯಾಸವಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_2",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಪಾರ್ಶ್ವ ಬೇರುಗಳು ಇಲ್ಲಿ ಕಂಡುಬರುತ್ತವೆ:",
            options = listOf("ತಾಯಿಬೇರು", "ತಂತುಬೇರು", "A ಮತ್ತು B ಎರಡೂ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "A ಮತ್ತು B ಎರಡೂ",
            explanation = "ತಾಯಿಬೇರು ವ್ಯವಸ್ಥೆಯಲ್ಲಿ ಮುಖ್ಯ ಬೇರಿನಿಂದ ಪಾರ್ಶ್ವ ಬೇರುಗಳು ಕವಲೊಡೆಯುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_3",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಸರಿಯಾದ ಹೇಳಿಕೆಯನ್ನು ಗುರುತಿಸಿ:\nP: ಮೆಕ್ಕೆಜೋಳವು ಒಂದು ಏಕದಳ ಸಸ್ಯ.\nQ: ಮೆಕ್ಕೆಜೋಳವು ಸಮಾಂತರ ನಾಳವಿನ್ಯಾಸವನ್ನು ಹೊಂದಿದೆ.",
            options = listOf("P ಮತ್ತು Q ಎರಡೂ ಸರಿ", "P ಸರಿ, Q ತಪ್ಪು", "P ತಪ್ಪು, Q ಸರಿ", "P ಮತ್ತು Q ಎರಡೂ ತಪ್ಪು"),
            correctAnswer = "P ಮತ್ತು Q ಎರಡೂ ಸರಿ",
            explanation = "ಮೆಕ್ಕೆಜೋಳವು ಏಕದಳ ಸಸ್ಯವಾಗಿದ್ದು, ಅದರ ಎಲೆಗಳು ಸಮಾಂತರ ನಾಳವಿನ್ಯಾಸವನ್ನು ಹೊಂದಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_4",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಒಂಟೆಯು ಮರುಭೂಮಿ ಪರಿಸರದಲ್ಲಿ ಬದುಕಲು ಸಹಾಯಕವಾದ ಅಂಶ ಯಾವುದು?",
            options = listOf(
                "ಉದ್ದನೆಯ ಕಾಲುಗಳನ್ನು ಹೊಂದಿರುವುದು",
                "ಸ್ವಲ್ಪ ಪ್ರಮಾಣದ ಮೂತ್ರ ಮತ್ತು ಒಣ ಸಗಣಿಯನ್ನು ವಿಸರ್ಜಿಸುವುದು",
                "ಅಗಲವಾದ ಪಾದಗಳನ್ನು ಹೊಂದಿರುವುದು",
                "ಮೇಲಿನ ಎಲ್ಲವೂ"
            ),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಈ ಎಲ್ಲಾ ಹೊಂದಾಣಿಕೆಗಳು ಒಂಟೆಗೆ ಮರುಭೂಮಿಯ ಕಠಿಣ ಉಷ್ಣ ಮತ್ತು ಮರಳಿನಲ್ಲಿ ಬದುಕಲು ನೆರವಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_5",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಸಸ್ಯ ಅಥವಾ ಪ್ರಾಣಿಯು ತನ್ನ ಪರಿಸರದಲ್ಲಿ ಸಹಜವಾಗಿ ಜೀವಿಸಲು ಸಹಾಯ ಮಾಡುವ ನಿರ್ದಿಷ್ಟ ಲಕ್ಷಣಗಳು ಅಥವಾ ಅಭ್ಯಾಸಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಬದುಕುವುದು", "ಹೊಂದಾಣಿಕೆ", "ಜೀವಿಸುವುದು", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ಹೊಂದಾಣಿಕೆ",
            explanation = "ನಿರ್ದಿಷ್ಟ ಪರಿಸರಕ್ಕೆ ಹೊಂದಿಕೊಳ್ಳುವ ಜೀವಿಗಳ ವಿಶಿಷ್ಟ ಗುಣವನ್ನು 'ಹೊಂದಾಣಿಕೆ' (Adaptation) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_6",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಒಂದು ಆವಾಸದಲ್ಲಿರುವ ಸಸ್ಯಗಳು ಮತ್ತು ಪ್ರಾಣಿಗಳು ಅದರ ಯಾವ ಘಟಕಗಳಾಗಿವೆ?",
            options = listOf("ಜೈವಿಕ ಘಟಕಗಳು", "ಅಜೈವಿಕ ಘಟಕಗಳು", "A ಮತ್ತು B ಎರಡೂ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ಜೈವಿಕ ಘಟಕಗಳು",
            explanation = "ಆವಾಸದಲ್ಲಿರುವ ಎಲ್ಲಾ ಜೀವಿಗಳು (ಸಸ್ಯಗಳು, ಪ್ರಾಣಿಗಳು, ಸೂಕ್ಷ್ಮಜೀವಿಗಳು) ಜೈವಿಕ ಘಟಕಗಳಾಗಿವೆ (Biotic components)."
        ),
        QuestionModel(
            id = "s_6_sci_u2_7",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಪಾಪಸ್‌ಕಳ್ಳಿಯ ಮುಳ್ಳುಗಳು ಸಸ್ಯದ ಯಾವ ಭಾಗದ ಮಾರ್ಪಾಡಾದ ರಚನೆ?",
            options = listOf("ಎಲೆ", "ಹೂವು", "ಬೇರು", "ಕಾಂಡ"),
            correctAnswer = "ಎಲೆ",
            explanation = "ನೀರಿನ ನಷ್ಟವನ್ನು ತಪ್ಪಿಸಲು ಮರುಭೂಮಿಯ ಪಾಪಸ್‌ಕಳ್ಳಿ ಸಸ್ಯಗಳಲ್ಲಿ ಎಲೆಗಳು ಮುಳ್ಳುಗಳಾಗಿ ಮಾರ್ಪಟ್ಟಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_8",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಗುಲಾಬಿ ಸಸ್ಯವು ________ಗೆ ಒಂದು ಉದಾಹರಣೆಯಾಗಿದೆ.",
            options = listOf("ಮರ", "ಪೊದೆ", "ಮೂಲಿಕೆ", "ಬಳ್ಳಿ"),
            correctAnswer = "ಪೊದೆ",
            explanation = "ಗುಲಾಬಿಯು ಮಧ್ಯಮ ಎತ್ತರದ, ಗಟ್ಟಿಯಾದ ಆದರೆ ಹೆಚ್ಚು ದಪ್ಪವಲ್ಲದ ಕಾಂಡವಿರುವ ಪೊದೆ (Shrub) ಸಸ್ಯ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_9",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬೆಳೆಯಲು ಆಧಾರ ಅಗತ್ಯವಿರುವ, ದುರ್ಬಲ ಕಾಂಡವಿರುವ ಸಸ್ಯಗಳು ________.",
            options = listOf("ಮರಗಳು", "ಬಳ್ಳಿಗಳು", "ಪೊದೆಗಳು", "ಹುಲ್ಲುಗಳು"),
            correctAnswer = "ಬಳ್ಳಿಗಳು",
            explanation = "ದುರ್ಬಲ ಕಾಂಡವಿದ್ದು ಇತರ ಆಧಾರಗಳ ಸಹಾಯದಿಂದ ಹಬ್ಬುವ ಸಸ್ಯಗಳನ್ನು ಬಳ್ಳಿಗಳು (Climbers/Creepers) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_10",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಎಲೆಯ ಮೇಲಿನ ನಾಳಗಳ ಜೋಡಣೆಯನ್ನು ________ ಎಂದು ಕರೆಯುತ್ತಾರೆ.",
            options = listOf("ಬೇರು ವ್ಯವಸ್ಥೆ", "ಕಾಂಡ ವಿನ್ಯಾಸ", "ನಾಳವಿನ್ಯಾಸ", "ಹೂವಿನ ರಚನೆ"),
            correctAnswer = "ನಾಳವಿನ್ಯಾಸ",
            explanation = "ಎಲೆಯ ಪತ್ರದ ಮೇಲೆ ನಾಳಗಳ ವ್ಯವಸ್ಥೆ ಮತ್ತು ವಿನ್ಯಾಸವನ್ನು 'ನಾಳವಿನ್ಯಾಸ' (Venation) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_11",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ದ್ವಿದಳ ಧಾನ್ಯಗಳ ಸಸ್ಯಗಳು ಸಾಮಾನ್ಯವಾಗಿ ________ ನಾಳವಿನ್ಯಾಸ ಮತ್ತು ________ ಬೇರಿನ ವ್ಯವಸ್ಥೆಯನ್ನು ಹೊಂದಿರುತ್ತವೆ.",
            options = listOf("ಸಮಾಂತರ, ತಂತುಬೇರು", "ಜಾಲಬಂಧ, ತಾಯಿಬೇರು", "ಸಮಾಂತರ, ತಾಯಿಬೇರು", "ಜಾಲಬಂಧ, ತಂತುಬೇರು"),
            correctAnswer = "ಜಾಲಬಂಧ, ತಾಯಿಬೇರು",
            explanation = "ದ್ವಿದಳ ಸಸ್ಯಗಳ ಎಲೆಗಳಲ್ಲಿ ಜಾಲರೂಪದ (ಜಾಲಬಂಧ) ನಾಳವಿನ್ಯಾಸ ಮತ್ತು ಬೇರಿನಲ್ಲಿ ತಾಯಿಬೇರು ವ್ಯವಸ್ಥೆ ಇರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_12",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಏಕದಳ ಧಾನ್ಯಗಳ ಸಸ್ಯಗಳು ಸಾಮಾನ್ಯವಾಗಿ ________ ನಾಳವಿನ್ಯಾಸ ಮತ್ತು ________ ಬೇರಿನ ವ್ಯವಸ್ಥೆಯನ್ನು ಹೊಂದಿರುತ್ತವೆ.",
            options = listOf("ಜಾಲಬಂಧ, ತಾಯಿಬೇರು", "ಸಮಾಂತರ, ತಂತುಬೇರು", "ಜಾಲಬಂಧ, ತಂತುಬೇರು", "ಸಮಾಂತರ, ತಾಯಿಬೇರು"),
            correctAnswer = "ಸಮಾಂತರ, ತಂತುಬೇರು",
            explanation = "ಏಕದಳ ಸಸ್ಯಗಳಲ್ಲಿ (ಹುಲ್ಲು, ಮೆಕ್ಕೆಜೋಳ ಇತ್ಯಾದಿ) ಸಮಾಂತರ ನಾಳವಿನ್ಯಾಸ ಮತ್ತು ತಂತುಬೇರು ವ್ಯವಸ್ಥೆ ಕಂಡುಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_13",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಜೀವಿಗಳನ್ನು ಅವುಗಳ ಸಾಮಾನ್ಯ ಗುಣಲಕ್ಷಣಗಳ ಆಧಾರದ ಮೇಲೆ ಗುಂಪುಗಳಾಗಿ ವಿಂಗಡಿಸುವ ವಿಧಾನವನ್ನು ________ ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ವರ್ಗೀಕರಣ", "ಆವಾಸ", "ವೀಕ್ಷಣೆ", "ಚಲನೆ"),
            correctAnswer = "ವರ್ಗೀಕರಣ",
            explanation = "ಸಾಮ್ಯತೆಗಳು ಮತ್ತು ಭಿನ್ನತೆಗಳ ಆಧಾರದ ಮೇಲೆ ಜೀವಿಗಳನ್ನು ವ್ಯವಸ್ಥಿತವಾಗಿ ಗುಂಪು ಮಾಡುವುದನ್ನು ವರ್ಗೀಕರಣ (Classification) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_14",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳು ಮತ್ತು ಪ್ರಾಣಿಗಳು ವಾಸಿಸುವ ನೈಸರ್ಗಿಕ ಸ್ಥಳವನ್ನು ಅವುಗಳ ________ ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ಆಹಾರ", "ಆವಾಸ", "ಚಲನೆ", "ಗುಂಪು"),
            correctAnswer = "ಆವಾಸ",
            explanation = "ಜೀವಿಗಳು ನೈಸರ್ಗಿಕವಾಗಿ ವಾಸಿಸುವ ಪರಿಸರವನ್ನು 'ಆವಾಸ' (Habitat) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_15",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ನೆಲದ ಮೇಲೆ ವಾಸಿಸುವ ಸಸ್ಯಗಳು ಮತ್ತು ಪ್ರಾಣಿಗಳನ್ನು ________ ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ಜಲವಾಸಿಗಳು", "ನೆಲವಾಸಿಗಳು", "ಉಭಯವಾಸಿಗಳು", "ಪರಾವಲಂಬಿಗಳು"),
            correctAnswer = "ನೆಲವಾಸಿಗಳು",
            explanation = "ಭೂಮಿಯ ಮೇಲ್ಮೈಯಲ್ಲಿ ವಾಸಿಸುವ ಜೀವಿಗಳನ್ನು ನೆಲವಾಸಿಗಳು (Terrestrial organisms) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_16",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ನೀರಿನಲ್ಲಿ ವಾಸಿಸುವ ಸಸ್ಯಗಳು ಮತ್ತು ಪ್ರಾಣಿಗಳನ್ನು ________ ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ನೆಲವಾಸಿಗಳು", "ಜಲವಾಸಿಗಳು", "ಉಭಯವಾಸಿಗಳು", "ಮರದವಾಸಿಗಳು"),
            correctAnswer = "ಜಲವಾಸಿಗಳು",
            explanation = "ಜಲಮೂಲಗಳಲ್ಲಿ ವಾಸಿಸುವ ಜೀವಿಗಳನ್ನು ಜಲವಾಸಿಗಳು (Aquatic organisms) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u2_17",
            stdId = 6,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ನೀರಿನಲ್ಲಿ ಮತ್ತು ನೆಲದ ಮೇಲೆ ಎರಡೂ ಕಡೆ ವಾಸಿಸುವ ಜೀವಿಗಳನ್ನು ________ ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ನೆಲವಾಸಿಗಳು", "ಜಲವಾಸಿಗಳು", "ಉಭಯವಾಸಿಗಳು", "ಸಸ್ಯಾಹಾರಿಗಳು"),
            correctAnswer = "ಉಭಯವಾಸಿಗಳು",
            explanation = "ಕಪ್ಪೆಯಂತಹ ನೀರು ಮತ್ತು ನೆಲ ಎರಡರಲ್ಲೂ ಜೀವಿಸಬಲ್ಲ ಜೀವಿಗಳನ್ನು ಉಭಯವಾಸಿಗಳು (Amphibians) ಎನ್ನುತ್ತಾರೆ."
        ),

        // ==================== ಅಧ್ಯಾಯ 3: ಮನದುಂಬಿದ ಊಟ — ಸ್ವಸ್ಥ ಶರೀರಕ್ಕೆ ಸೋಪಾನ ====================
        QuestionModel(
            id = "s_6_sci_u3_1",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ರಜು–ಉಪ್ಪಿಟ್ಟು, ರವಿ–ಇಡ್ಲಿ, ನಮಿತ್–ಚಪಾತಿ ಹಾಗೂ ನವ್ಯಾ–ತರಕಾರಿ ಪಲಾವ್ ಸೇವಿಸಿದರೆ ಇದರಿಂದ ತಿಳಿಯುವುದೇನು?",
            options = listOf(
                "ನಾವು ಸೇವಿಸುವ ಆಹಾರದಲ್ಲಿ ಏಕತೆ ಇದೆ",
                "ನಾವು ಸೇವಿಸುವ ಆಹಾರದಲ್ಲಿ ಸಾಮ್ಯತೆ ಇದೆ",
                "ನಾವು ಸೇವಿಸುವ ಆಹಾರದಲ್ಲಿ ವೈವಿಧ್ಯತೆ ಇದೆ",
                "ಮೇಲಿನ ಎಲ್ಲ ಹೇಳಿಕೆಗಳು ಸರಿ"
            ),
            correctAnswer = "ನಾವು ಸೇವಿಸುವ ಆಹಾರದಲ್ಲಿ ವೈವಿಧ್ಯತೆ ಇದೆ",
            explanation = "ವಿಭಿನ್ನ ವ್ಯಕ್ತಿಗಳು ಬೇರೆ ಬೇರೆ ಬಗೆಯ ಆಹಾರ ಪದಾರ್ಥಗಳನ್ನು ಸೇವಿಸುವುದು ಆಹಾರದ ವೈವಿಧ್ಯತೆಯನ್ನು ತೋರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_2",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಭಾರತದ ಬೇರೆ ಬೇರೆ ರಾಜ್ಯಗಳಲ್ಲಿ ಬೇರೆ ಬೇರೆ ಆಹಾರ ಪದಾರ್ಥಗಳನ್ನು ಸೇವಿಸಲು ಕಾರಣವೇನು?\ni) ಆಹಾರ ಪದ್ಧತಿಯನ್ನು ಆ ಪ್ರದೇಶದ ವಾಯುಗುಣ ಪ್ರಭಾವಿಸುತ್ತದೆ.\nii) ಬೇರೆ ಬೇರೆ ಪ್ರದೇಶಗಳಲ್ಲಿ ಆಹಾರದ ಲಭ್ಯತೆ ಭಿನ್ನವಾಗಿರುತ್ತದೆ.\niii) ಆಯಾ ಪ್ರದೇಶಗಳ ಸಂಸ್ಕೃತಿ ಆಹಾರ ಪದ್ಧತಿಯನ್ನು ನಿರ್ಧರಿಸುತ್ತದೆ.",
            options = listOf("i ಮಾತ್ರ ಸರಿ", "i ಮತ್ತು ii ಮಾತ್ರ ಸರಿ", "i ಮತ್ತು iii ಮಾತ್ರ ಸರಿ", "ಮೇಲಿನ ಎಲ್ಲ ಹೇಳಿಕೆಗಳು ಸರಿ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲ ಹೇಳಿಕೆಗಳು ಸರಿ",
            explanation = "ವಾಯುಗುಣ, ಬೆಳೆಗಳ ಲಭ್ಯತೆ ಮತ್ತು ಪ್ರಾದೇಶಿಕ ಸಂಸ್ಕೃತಿಗಳು ಆಹಾರ ಪದ್ಧತಿಯ ಮೇಲೆ ಪ್ರಭಾವ ಬೀರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_3",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ದೇಹದ ಬೆಳವಣಿಗೆ ಮತ್ತು ದುರಸ್ತಿಗೆ ಅಗತ್ಯವಾದ ಪ್ರೋಟೀನ್ ಯಾವ ಆಹಾರಗಳಲ್ಲಿ ಸಮೃದ್ಧವಾಗಿದೆ?",
            options = listOf("ಬಟಾಣಿ ಮತ್ತು ಮೀನು", "ಅಕ್ಕಿ ಮತ್ತು ತುಪ್ಪ", "ಮೆಕ್ಕೆಜೋಳ ಮತ್ತು ಮೊಟ್ಟೆ", "ಸಜ್ಜೆ ಮತ್ತು ಗಣಸು"),
            correctAnswer = "ಬಟಾಣಿ ಮತ್ತು ಮೀನು",
            explanation = "ಬಟಾಣಿ, ಬೇಳೆಕಾಳುಗಳು ಮತ್ತು ಮೀನು ಪ್ರೋಟೀನ್‌ನ ಉತ್ತಮ ಮೂಲಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_4",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕುತ್ತಿಗೆಯಲ್ಲಿನ ಗ್ರಂಥಿಗಳು ಊದಿಕೊಂಡಿರುವ ವ್ಯಕ್ತಿಗೆ (ಗಳಗಂಡ ರೋಗಿಗೆ) ಯಾವ ಸಲಹೆ ಸೂಕ್ತ?",
            options = listOf(
                "ಕಬ್ಬಿಣ ಹೆಚ್ಚಿರುವುದರಿಂದ ಹಸಿರು ಸೊಪ್ಪುಗಳನ್ನು ಸೇವಿಸಬೇಕು",
                "ಕಬ್ಬಿಣ ಕಡಿಮೆಯಿರುವುದರಿಂದ ಸಿಟ್ರಸ್ ಹಣ್ಣುಗಳನ್ನು ಸೇವಿಸಬೇಕು",
                "ಅಯೋಡಿನ್ ಕಡಿಮೆಯಿರುವುದರಿಂದ ಅಯೋಡಿನ್‌ಯುಕ್ತ ಆಹಾರ ಸೇವಿಸಬೇಕು",
                "ಹಣ್ಣು ತರಕಾರಿಗಳನ್ನು ಸೇವಿಸಬೇಕು"
            ),
            correctAnswer = "ಅಯೋಡಿನ್ ಕಡಿಮೆಯಿರುವುದರಿಂದ ಅಯೋಡಿನ್‌ಯುಕ್ತ ಆಹಾರ ಸೇವಿಸಬೇಕು",
            explanation = "ಗಳಗಂಡ ರೋಗವು ಅಯೋಡಿನ್ ಕೊರತೆಯಿಂದ ಬರುತ್ತದೆ; ಆದ್ದರಿಂದ ಅಯೋಡಿನ್‌ಯುಕ್ತ ಉಪ್ಪು ಮತ್ತು ಸಮುದ್ರಾಹಾರ ಸೇವಿಸಬೇಕು."
        ),
        QuestionModel(
            id = "s_6_sci_u3_5",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮೊಳಕೆ ಕಟ್ಟಿದ ಹುರುಳಿಕಾಳು ಮತ್ತು ಹಸಿರು ಕಾಳುಗಳಲ್ಲಿ ಸಮೃದ್ಧವಾಗಿರುವ ಪೋಷಕಾಂಶ ಯಾವುದು?",
            options = listOf("ಸರಳ ಪ್ರೋಟೀನ್", "ಕಾರ್ಬೋಹೈಡ್ರೇಟ್", "ಖನಿಜಗಳು", "ಲಿಪಿಡ್"),
            correctAnswer = "ಸರಳ ಪ್ರೋಟೀನ್",
            explanation = "ಮೊಳಕೆ ಬರಿಸಿದ ಕಾಳುಗಳಲ್ಲಿ ಸುಲಭವಾಗಿ ಜೀರ್ಣವಾಗುವ ಪ್ರೋಟೀನ್ ಹೇರಳವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_6",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ನಾರಿನಂಶವಿರುವ (Roughage) ಪದಾರ್ಥ ಯಾವುದು?",
            options = listOf("ಬೆಣ್ಣೆ", "ಮಾಂಸ", "ಅಕ್ಕಿ", "ನುಗ್ಗೆಕಾಯಿ"),
            correctAnswer = "ನುಗ್ಗೆಕಾಯಿ",
            explanation = "ನುಗ್ಗೆಕಾಯಿ ಮತ್ತು ತರಕಾರಿಗಳಲ್ಲಿ ನಾರಿನಂಶ (ರಫೇಜ್) ಸಮೃದ್ಧವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_7",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮಾವಿನಕಾಯಿ ಚೂರಿನ ಮೇಲೆ ಅಯೋಡಿನ್ ದ್ರಾವಣ ಹಾಕಿದಾಗ ನೀಲಿ-ಕಪ್ಪು ಬಣ್ಣ ಕಂಡುಬಂದರೆ ಕಾರಣವೇನು?",
            options = listOf("ಪಿಷ್ಟ ಇದೆ", "ಪಿಷ್ಟವಿಲ್ಲ", "ಪಿಷ್ಟ ಇಲ್ಲದ ಕಾರಣ ಕೆಂಪು ಬಣ್ಣ ಬಂದಿದೆ", "ಸಕ್ಕರೆ ಅಂಶವಿದೆ"),
            correctAnswer = "ಪಿಷ್ಟ ಇದೆ",
            explanation = "ಅಯೋಡಿನ್ ಪರೀಕ್ಷೆಯಲ್ಲಿ ನೀಲಿ-ಕಪ್ಪು ಬಣ್ಣ ಬಂದರೆ ಅದು ಪಿಷ್ಟದ (Starch) ಇರುವಿಕೆಯನ್ನು ದೃಢೀಕರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_8",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಪರೀಕ್ಷಾ ನಳಿಕೆಯಲ್ಲಿ ದ್ರಾವಣಕ್ಕೆ ಕಾಪರ್ ಸಲ್ಫೇಟ್ ಮತ್ತು ಕಾಸ್ಟಿಕ್ ಸೋಡಾ ಸೇರಿಸಿದಾಗ ನೀಲಿ ಬಣ್ಣ ನೇರಳೆ ಬಣ್ಣಕ್ಕೆ ಬದಲಾಗುತ್ತದೆ. ದ್ರಾವಣದಲ್ಲಿ ಇರುವುದೇನು?",
            options = listOf("ಪ್ರೋಟೀನ್", "ಗ್ಲೂಕೋಸ್", "ಕೊಬ್ಬು", "ಪಿಷ್ಟ"),
            correctAnswer = "ಪ್ರೋಟೀನ್",
            explanation = "ಕಾಪರ್ ಸಲ್ಫೇಟ್ ಮತ್ತು ಕಾಸ್ಟಿಕ್ ಸೋಡಾದೊಂದಿಗೆ ನೇರಳೆ (violet) ಬಣ್ಣ ಬಂದರೆ ಅದು ಪ್ರೋಟೀನ್ ಇರುವಿಕೆಯನ್ನು ತೋರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_9",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮೊಟ್ಟೆಯ ಬಿಳಿ ಲೋಳೆಗೆ ಕಾಪರ್ ಸಲ್ಫೇಟ್ ಮತ್ತು ಕಾಸ್ಟಿಕ್ ಸೋಡಾ ಸೇರಿಸಿದಾಗ ನೇರಳೆ ಬಣ್ಣ ಕಂಡುಬಂದರೆ ಕಾರಣವೇನು?",
            options = listOf("ಪಿಷ್ಟ ಇದೆ", "ಪಿಷ್ಟವಿಲ್ಲ", "ಪ್ರೋಟೀನ್ ಇದೆ", "ಲಿಪಿಡ್ ಇದೆ"),
            correctAnswer = "ಪ್ರೋಟೀನ್ ಇದೆ",
            explanation = "ಮೊಟ್ಟೆಯ ಬಿಳಿ ಭಾಗದಲ್ಲಿ ಆಲ್ಬುಮಿನ್ ಎಂಬ ಪ್ರೋಟೀನ್ ಇರುವುದರಿಂದ ನೇರಳೆ ಬಣ್ಣ ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_10",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಪ್ರೋಟೀನ್ ಪರೀಕ್ಷೆಯಲ್ಲಿ ಧನಾತ್ಮಕ ಫಲಿತಾಂಶ ನೀಡುವ ಆಹಾರ ಪದಾರ್ಥಗಳು ಯಾವುವು?\ni) ಹಾಲು ii) ಬಾಳೆಹಣ್ಣು iii) ಎಣ್ಣೆ iv) ಕಡಲೆಹಿಟ್ಟು",
            options = listOf("i ಮತ್ತು iii", "ii ಮತ್ತು iv", "i ಮತ್ತು iv", "i, ii ಮತ್ತು iv"),
            correctAnswer = "i ಮತ್ತು iv",
            explanation = "ಹಾಲು ಮತ್ತು ಕಡಲೆಹಿಟ್ಟಿನಲ್ಲಿ ಪ್ರೋಟೀನ್ ಸಮೃದ್ಧವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_11",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕಡಲೆಕಾಯಿ ಬೀಜವನ್ನು ಕಾಗದದಲ್ಲಿ ಸುತ್ತಿ ಜಜ್ಜಿದಾಗ ಎಣ್ಣೆಯ ಕಲೆ ಕಾಣಿಸಿದರೆ ಅದು ಯಾವ ಪೋಷಕಾಂಶದ ಇರುವಿಕೆಯನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಪ್ರೋಟೀನ್", "ಪಿಷ್ಟ", "ಕೊಬ್ಬು (ಲಿಪಿಡ್)", "ವಿಟಮಿನ್"),
            correctAnswer = "ಕೊಬ್ಬು (ಲಿಪಿಡ್)",
            explanation = "ಕಾಗದದ ಮೇಲೆ ಪಾರದರ್ಶಕ ಎಣ್ಣೆಯ ಕಲೆ ಕಂಡುಬಂದರೆ ಅದು ಕೊಬ್ಬಿನ (Fats/Lipids) ಉಪಸ್ಥಿತಿಯನ್ನು ಸೂಚಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_12",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಪಾನಿಪುರಿ, ಚಿಪ್ಸ್ ಮುಂತಾದ ಜಂಕ್ ಫುಡ್‌ಗಳನ್ನು ಹೆಚ್ಚು ಸೇವಿಸಬಾರದು. ಏಕೆ?",
            options = listOf(
                "ಪ್ರೋಟೀನ್‌ಯುಕ್ತ ಆಹಾರಗಳು ಮಾತ್ರ",
                "ರಕ್ಷಣಾತ್ಮಕ ಪೋಷಕಾಂಶಗಳು ಮಾತ್ರ",
                "ತುಂಬಾ ದುಬಾರಿ ಆಹಾರ ಪದಾರ್ಥಗಳು",
                "ಕಡಿಮೆ ಪೋಷಕಾಂಶವಿರುವ ಆಹಾರ ಪದಾರ್ಥಗಳು"
            ),
            correctAnswer = "ಕಡಿಮೆ ಪೋಷಕಾಂಶವಿರುವ ಆಹಾರ ಪದಾರ್ಥಗಳು",
            explanation = "ಜಂಕ್ ಫುಡ್‌ಗಳಲ್ಲಿ ಅನಾರೋಗ್ಯಕರ ಕೊಬ್ಬು ಮತ್ತು ಸಕ್ಕರೆ ಹೆಚ್ಚಿದ್ದು, ಅಗತ್ಯ ಪೋಷಕಾಂಶಗಳು ಕಡಿಮೆ ಇರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_13",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಸರಿಯಲ್ಲದ ಹೇಳಿಕೆ ಯಾವುದು?",
            options = listOf(
                "ಬೇಯಿಸುವುದರಿಂದ ಆಹಾರ ರುಚಿಯಾಗುತ್ತದೆ ಮತ್ತು ಸುಲಭವಾಗಿ ಜೀರ್ಣವಾಗುತ್ತದೆ",
                "ಅತಿಯಾಗಿ ಬೇಯಿಸುವುದು ಪೋಷಕಾಂಶಗಳ ನಾಶಕ್ಕೆ ಕಾರಣವಾಗುತ್ತದೆ",
                "ಹೆಚ್ಚು ನೀರಿನಲ್ಲಿ ಬೇಯಿಸಿ ನೀರನ್ನು ಬಸಿದರೆ ಕೆಲವು ಪೋಷಕಾಂಶಗಳು ನಷ್ಟವಾಗಬಹುದು",
                "ಶಾಖದಿಂದ ವಿಟಮಿನ್‌ಗಳು ಎಂದಿಗೂ ನಾಶವಾಗುವುದಿಲ್ಲ"
            ),
            correctAnswer = "ಶಾಖದಿಂದ ವಿಟಮಿನ್‌ಗಳು ಎಂದಿಗೂ ನಾಶವಾಗುವುದಿಲ್ಲ",
            explanation = "ಅತಿಯಾದ ಶಾಖದಿಂದ ವಿಟಮಿನ್ ಸಿ ಯಂತಹ ವಿಟಮಿನ್‌ಗಳು ಸುಲಭವಾಗಿ ನಾಶವಾಗುತ್ತವೆ; ಆದ್ದರಿಂದ ಆ ಹೇಳಿಕೆ ತಪ್ಪು."
        ),
        QuestionModel(
            id = "s_6_sci_u3_14",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಜೋಳ, ಗೋಧಿ, ರಾಗಿ ಮತ್ತು ಕಡಲೆಕಾಳುಗಳಲ್ಲಿ ಸಾಮಾನ್ಯವಾಗಿ ಹೆಚ್ಚು ಕಂಡುಬರುವ ಮುಖ್ಯ ಪೋಷಕಾಂಶ ________.",
            options = listOf("ಕಾರ್ಬೋಹೈಡ್ರೇಟ್", "ವಿಟಮಿನ್ C", "ನೀರು", "ಅಯೋಡಿನ್"),
            correctAnswer = "ಕಾರ್ಬೋಹೈಡ್ರೇಟ್",
            explanation = "ಧಾನ್ಯಗಳು ಮತ್ತು ಕಾಳುಗಳಲ್ಲಿ ಶಕ್ತಿ ನೀಡುವ ಕಾರ್ಬೋಹೈಡ್ರೇಟ್ ಅಧಿಕವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_15",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ನಮ್ಮ ದೇಹಕ್ಕೆ ಶಕ್ತಿಯನ್ನು ಒದಗಿಸುವ, ಬೆಳವಣಿಗೆ ಮತ್ತು ದುರಸ್ತಿಗೆ ನೆರವಾಗುವ ಹಾಗೂ ಆರೋಗ್ಯವನ್ನು ಕಾಪಾಡುವ ಆಹಾರದಲ್ಲಿನ ಅಂಶಗಳನ್ನು ________ ಎನ್ನುತ್ತಾರೆ.",
            options = listOf("ಪೋಷಕಾಂಶಗಳು", "ಬಣ್ಣಗಳು", "ಸುವಾಸನೆಗಳು", "ತ್ಯಾಜ್ಯಗಳು"),
            correctAnswer = "ಪೋಷಕಾಂಶಗಳು",
            explanation = "ಆಹಾರದಲ್ಲಿರುವ ಉಪಯುಕ್ತ ಜೈವಿಕ ರಾಸಾಯನಿಕ ಘಟಕಗಳನ್ನು ಪೋಷಕಾಂಶಗಳು (Nutrients) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_16",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮ್ಯಾರಥಾನ್ ಓಟಗಾರನಿಗೆ ಗ್ಲೂಕೋಸ್ ದ್ರಾವಣ ನೀಡುವುದರಿಂದ ತಕ್ಷಣ ________ ದೊರೆಯುತ್ತದೆ.",
            options = listOf("ಶಕ್ತಿ", "ನಾರು", "ಅಯೋಡಿನ್", "ಕ್ಯಾಲ್ಸಿಯಂ"),
            correctAnswer = "ಶಕ್ತಿ",
            explanation = "ಗ್ಲೂಕೋಸ್ ಸರಳ ಸಕ್ಕರೆಯಾಗಿದ್ದು ಜೀರ್ಣಕ್ರಿಯೆಯ ಅಗತ್ಯವಿಲ್ಲದೆ ರಕ್ತಕ್ಕೆ ನೇರವಾಗಿ ಹೀರಿಕೊಂಡು ತ್ವರಿತ ಶಕ್ತಿ ನೀಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_17",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಅತ್ಯಂತ ಸರಳ ಕಾರ್ಬೋಹೈಡ್ರೇಟ್ ________.",
            options = listOf("ಗ್ಲೂಕೋಸ್", "ಪ್ರೋಟೀನ್", "ಕೊಬ್ಬು", "ಖನಿಜ"),
            correctAnswer = "ಗ್ಲೂಕೋಸ್",
            explanation = "ಗ್ಲೂಕೋಸ್ ನಮ್ಮ ದೇಹಕ್ಕೆ ಅತಿ ಶೀಘ್ರವಾಗಿ ಲಭ್ಯವಾಗುವ ಸರಳ ಕಾರ್ಬೋಹೈಡ್ರೇಟ್ (ಏಕಶರ್ಕರ)."
        ),
        QuestionModel(
            id = "s_6_sci_u3_18",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಬಳಕೆಯಾಗದ ಹೆಚ್ಚುವರಿ ಕಾರ್ಬೋಹೈಡ್ರೇಟ್ ಪ್ರಾಣಿ ದೇಹದಲ್ಲಿ ________ ರೂಪದಲ್ಲಿ ಸಂಗ್ರಹವಾಗುತ್ತದೆ.",
            options = listOf("ನೀರು", "ಗ್ಲೈಕೋಜನ್", "ವಿಟಮಿನ್ C", "ಅಯೋಡಿನ್"),
            correctAnswer = "ಗ್ಲೈಕೋಜನ್",
            explanation = "ಮಾನವ ಹಾಗೂ ಪ್ರಾಣಿಗಳ ಯಕೃತ್ತು ಮತ್ತು ಸ್ನಾಯುಗಳಲ್ಲಿ ಗ್ಲೂಕೋಸ್ ಗ್ಲೈಕೋಜನ್ ರೂಪದಲ್ಲಿ ಶೇಖರವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_19",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಕ್ಕರೆ, ಜೇನುತುಪ್ಪ ಮತ್ತು ಕಬ್ಬಿನ ಹಾಲಿನಲ್ಲಿ ಕಂಡುಬರುವ ಮುಖ್ಯ ಪೋಷಕಾಂಶ ________.",
            options = listOf("ಕಾರ್ಬೋಹೈಡ್ರೇಟ್", "ಪ್ರೋಟೀನ್", "ಖನಿಜ", "ನಾರು"),
            correctAnswer = "ಕಾರ್ಬೋಹೈಡ್ರೇಟ್",
            explanation = "ಸಿಹಿ ಪದಾರ್ಥಗಳಲ್ಲಿ ಸರಳ ಶರ್ಕರಗಳಾದ ಗ್ಲೂಕೋಸ್, ಸುಕ್ರೋಸ್ ಮತ್ತು ಫ್ರಕ್ಟೋಸ್ ಕಾರ್ಬೋಹೈಡ್ರೇಟ್‌ಗಳು ಸಮೃದ್ಧವಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_20",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ದೇಹದ ಬೆಳವಣಿಗೆ ಮತ್ತು ದುರಸ್ತಿಗೆ ಮುಖ್ಯವಾಗಿ ಅಗತ್ಯವಿರುವ ಪೋಷಕಾಂಶ ________.",
            options = listOf("ಪ್ರೋಟೀನ್", "ನೀರು ಮಾತ್ರ", "ಉಪ್ಪು", "ಸಕ್ಕರೆ ಮಾತ್ರ"),
            correctAnswer = "ಪ್ರೋಟೀನ್",
            explanation = "ಪ್ರೋಟೀನ್‌ಗಳನ್ನು 'ದೇಹ ನಿರ್ಮಾಣ ಪೋಷಕಾಂಶಗಳು' (Body building foods) ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_21",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ತಿನ್ನಬಹುದಾದ ಅಣಬೆಗಳಲ್ಲಿ (Mushrooms) ಹೇರಳವಾಗಿರುವ ಪೋಷಕಾಂಶ ________.",
            options = listOf("ಪ್ರೋಟೀನ್", "ಅಯೋಡಿನ್", "ವಿಟಮಿನ್ D ಮಾತ್ರ", "ನೀರು ಮಾತ್ರ"),
            correctAnswer = "ಪ್ರೋಟೀನ್",
            explanation = "ಅಣಬೆಗಳು ಸಸ್ಯಾಹಾರಿಗಳಲ್ಲಿ ಪ್ರೋಟೀನ್‌ಗಳ ಶ್ರೇಷ್ಠ ಮೂಲವಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_22",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ನೀರು ನಮ್ಮ ದೇಹದಿಂದ ತ್ಯಾಜ್ಯಗಳನ್ನು ಮುಖ್ಯವಾಗಿ ________ ಮತ್ತು ________ ರೂಪದಲ್ಲಿ ಹೊರಹಾಕಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ.",
            options = listOf("ಬೆವರು, ಮೂತ್ರ", "ರಕ್ತ, ಮೂಳೆ", "ಕೊಬ್ಬು, ಪ್ರೋಟೀನ್", "ಉಗುರು, ಕೂದಲು"),
            correctAnswer = "ಬೆವರು, ಮೂತ್ರ",
            explanation = "ದೇಹದಲ್ಲಿನ ವಿಷಕಾರಿ ದ್ರವ ತ್ಯಾಜ್ಯಗಳನ್ನು ಮೂತ್ರ ಮತ್ತು ಬೆವರಿನ ಮೂಲಕ ಹೊರಹಾಕಲು ನೀರು ನೆರವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_23",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಟೊಮೆಟೊ, ನೆಲ್ಲಿಕಾಯಿ, ನಿಂಬೆ ಮತ್ತು ಹಸಿರು ಮೆಣಸಿನಕಾಯಿಯಲ್ಲಿ ಸಮೃದ್ಧವಾಗಿರುವ ವಿಟಮಿನ್ ________.",
            options = listOf("ವಿಟಮಿನ್ A", "ವಿಟಮಿನ್ B₁", "ವಿಟಮಿನ್ C", "ವಿಟಮಿನ್ D"),
            correctAnswer = "ವಿಟಮಿನ್ C",
            explanation = "ಹುಳಿ ಹಣ್ಣುಗಳು, ನೆಲ್ಲಿಕಾಯಿ ಮತ್ತು ತರಕಾರಿಗಳಲ್ಲಿ ರೋಗನಿರೋಧಕ ವಿಟಮಿನ್ ಸಿ ಹೇರಳವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_24",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಆಹಾರ ಪದಾರ್ಥಗಳ ಪ್ಯಾಕೆಟ್ ಮೇಲೆ ಪೋಷಕಾಂಶಗಳ ಹೆಸರು ಮತ್ತು ಅವುಗಳ ಪ್ರಮಾಣವನ್ನು ಸೂಚಿಸುವುದರ ಮುಖ್ಯ ಉದ್ದೇಶ ________.",
            options = listOf("ಆಹಾರದ ಪೋಷಕಾಂಶಗಳ ಮಾಹಿತಿ ನೀಡುವುದು", "ಪ್ಯಾಕೆಟ್ನ ಬಣ್ಣ ತಿಳಿಸುವುದು", "ಆಹಾರದ ತೂಕವನ್ನು ಮರೆಮಾಡುವುದು", "ಬೆಲೆಯನ್ನು ತೆಗೆದುಹಾಕುವುದು"),
            correctAnswer = "ಆಹಾರದ ಪೋಷಕಾಂಶಗಳ ಮಾಹಿತಿ ನೀಡುವುದು",
            explanation = "ಗ್ರಾಹಕರಿಗೆ ತಾವು ಸೇವಿಸುವ ಆಹಾರದಲ್ಲಿರುವ ಪೋಷಕಾಂಶ ಮೌಲ್ಯಗಳ (Nutritional facts) ಸ್ಪಷ್ಟ ಅರಿವು ಮೂಡಿಸುವುದು ಮುಖ್ಯ ಉದ್ದೇಶ."
        ),
        QuestionModel(
            id = "s_6_sci_u3_25",
            stdId = 6,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕಿತ್ತಳೆ, ನಿಂಬೆ ಮತ್ತು ನೆಲ್ಲಿಕಾಯಿಯಂತಹ ಹುಳಿ ಸಿಟ್ರಸ್ ಆಹಾರಗಳಲ್ಲಿ ಸಾಮಾನ್ಯವಾಗಿ ಸಮೃದ್ಧವಾಗಿರುವ ವಿಟಮಿನ್ ________.",
            options = listOf("ವಿಟಮಿನ್ A", "ವಿಟಮಿನ್ C", "ವಿಟಮಿನ್ D", "ವಿಟಮಿನ್ K"),
            correctAnswer = "ವಿಟಮಿನ್ C",
            explanation = "ಸಿಟ್ರಸ್ ಹಣ್ಣುಗಳಲ್ಲಿ ಆಸ್ಕೋರ್ಬಿಕ್ ಆಮ್ಲ (ವಿಟಮಿನ್ ಸಿ) ಹೇರಳವಾಗಿರುತ್ತದೆ."
        ),

        // ==================== ಅಧ್ಯಾಯ 4: ಕಾಂತಗಳ ಅನ್ವೇಷಣೆ ====================
        QuestionModel(
            id = "s_6_sci_u4_1",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೆಳಗೆ ನೀಡಿರುವ ವಸ್ತುಗಳಲ್ಲಿ ಕಾಂತೀಯ ವಸ್ತುಗಳನ್ನು ಗುರುತಿಸಿ:",
            options = listOf("ಕಬ್ಬಿಣ", "ನಿಕಲ್", "ಕೋಬಾಲ್ಟ್", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಕಬ್ಬಿಣ, ನಿಕಲ್ ಮತ್ತು ಕೋಬಾಲ್ಟ್‌ಗಳು ಕಾಂತದಿಂದ ಆಕರ್ಷಿಸಲ್ಪಡುವ ಕಾಂತೀಯ ವಸ್ತುಗಳು."
        ),
        QuestionModel(
            id = "s_6_sci_u4_2",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸರಿಯಾದ ಜೋಡಿಯನ್ನು ಕಂಡುಹಿಡಿಯಿರಿ:",
            options = listOf(
                "ಕಬ್ಬಿಣ — ಕಾಂತೀಯ",
                "ರಬ್ಬರ್ — ನೈಸರ್ಗಿಕ ಕಾಂತ",
                "ಕುದುರೆ ಲಾಳಾಕಾರದ ಕಾಂತ — ಅಕಾಂತೀಯ",
                "ಲೋಡ್‌ಸ್ಟೋನ್ — ಕೃತಕ ಕಾಂತ"
            ),
            correctAnswer = "ಕಬ್ಬಿಣ — ಕಾಂತೀಯ",
            explanation = "ಕಬ್ಬಿಣವು ಪ್ರಮುಖ ಕಾಂತೀಯ ವಸ್ತುವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u4_3",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ದಂಡಕಾಂತವನ್ನು ಕಬ್ಬಿಣದ ರಜಗಳ ಬಳಿ ತಂದಾಗ ಗರಿಷ್ಠ ಪ್ರಮಾಣದ ರಜಗಳು ಅಂಟಿಕೊಳ್ಳುವ ಭಾಗ ಯಾವುದು?",
            options = listOf("ಉತ್ತರ ಧ್ರುವ", "ದಕ್ಷಿಣ ಧ್ರುವ", "ಎರಡೂ ಧ್ರುವಗಳು", "ಕಾಂತದ ಮಧ್ಯಭಾಗ"),
            correctAnswer = "ಎರಡೂ ಧ್ರುವಗಳು",
            explanation = "ಕಾಂತದ ಕಾಂತೀಯ ಬಲವು ಅದರ ಎರಡು ಧ್ರುವಗಳಲ್ಲಿ ಅತ್ಯಂತ ಪ್ರಬಲವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u4_4",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಾಂತವಾಗಿ ಪರಿವರ್ತಿಸಬಹುದಾದ ವಸ್ತು ಯಾವುದು?",
            options = listOf("ಕಬ್ಬಿಣದ ಮೊಳೆ", "ಮರದ ಹಲಗೆ", "ಪೇಪರ್", "ಪ್ಲಾಸ್ಟಿಕ್ ತಟ್ಟೆ"),
            correctAnswer = "ಕಬ್ಬಿಣದ ಮೊಳೆ",
            explanation = "ಕಬ್ಬಿಣದ ಮೊಳೆಯನ್ನು ಕಾಂತದಿಂದ ಉಜ್ಜುವ ಮೂಲಕ ಕೃತಕ ಕಾಂತವಾಗಿ ಪರಿವರ್ತಿಸಬಹುದು."
        ),
        QuestionModel(
            id = "s_6_sci_u4_5",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಈ ಸಾಧನಗಳಲ್ಲಿ ಕಾಂತವನ್ನು ಬಳಸಿರುವುದಿಲ್ಲ:",
            options = listOf("ಧ್ವನಿವರ್ಧಕ", "ಕಂಪ್ಯೂಟರ್", "ಕುಕ್ಕರ್", "ಟಿ.ವಿ."),
            correctAnswer = "ಕುಕ್ಕರ್",
            explanation = "ಕುಕ್ಕರ್ ಕೇವಲ ಅಡುಗೆಯ ಪಾತ್ರೆಯಾಗಿದ್ದು ಅದರಲ್ಲಿ ಕಾಂತದ ಬಳಕೆಯಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u4_6",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಾಂತವನ್ನು ಪದೇಪದೇ ಎತ್ತರದಿಂದ ಬೀಳಿಸಿದರೆ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಕಾಂತವು ಪುಡಿಯಾಗುತ್ತದೆ", "ಕಾಂತೀಯ ಗುಣ ಹೆಚ್ಚಾಗುತ್ತದೆ", "ಕಾಂತೀಯ ಗುಣ ಕಳೆದುಕೊಳ್ಳುತ್ತದೆ", "ಕಾಂತವು ಗೋಳಾಕೃತಿ ಪಡೆಯುತ್ತದೆ"),
            correctAnswer = "ಕಾಂತೀಯ ಗುಣ ಕಳೆದುಕೊಳ್ಳುತ್ತದೆ",
            explanation = "ಕಾಂತವನ್ನು ಕೆಳಗೆ ಕೆಡವಿದಾಗ ಅಥವಾ ಬಡಿದಾಗ ಅದರ ಕಾಂತೀಯ ಶಕ್ತಿ ನಾಶವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u4_7",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಟಿ.ವಿ. ಮತ್ತು ರಿಮೋಟ್‌ನಂತಹ ಸಾಧನಗಳ ಹತ್ತಿರ ಕಾಂತವನ್ನು ತಂದರೆ ಏನಾಗಬಹುದು?",
            options = listOf("ಸಾಧನಗಳು ಹಾಳಾಗಬಹುದು", "ಕಾಂತ ಹಾಳಾಗಬಹುದು", "ಕಾಂತದ ಆಕರ್ಷಣ ಗುಣ ಕಡಿಮೆಯಾಗುತ್ತದೆ", "ಕಾಂತಗಳು ಹೊಳೆಯಬಹುದು"),
            correctAnswer = "ಸಾಧನಗಳು ಹಾಳಾಗಬಹುದು",
            explanation = "ಎಲೆಕ್ಟ್ರಾನಿಕ್ ಸಾಧನಗಳ ಆಯಸ್ಕಾಂತೀಯ ಭಾಗಗಳು ಹಾನಿಗೊಳಗಾಗಬಹುದು."
        ),
        QuestionModel(
            id = "s_6_sci_u4_8",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಮುಕ್ತವಾಗಿ ತೂಗುಬಿಟ್ಟ ಕಾಂತವು ಯಾವ ದಿಕ್ಕನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಪೂರ್ವ–ಪಶ್ಚಿಮ", "ಉತ್ತರ–ದಕ್ಷಿಣ", "ದಕ್ಷಿಣ–ಪಶ್ಚಿಮ", "ಉತ್ತರ–ಪಶ್ಚಿಮ"),
            correctAnswer = "ಉತ್ತರ–ದಕ್ಷಿಣ",
            explanation = "ಸ್ವತಂತ್ರವಾಗಿ ತೂಗಾಡುವ ಕಾಂತವು ಯಾವಾಗಲೂ ಉತ್ತರ-ದಕ್ಷಿಣ ದಿಕ್ಕಿಗೆ ನಿಲ್ಲುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u4_9",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಾಂತದ ಸಮಾನ ಧ್ರುವಗಳು ಒಂದಕ್ಕೊಂದು ಏನಾಗುತ್ತವೆ?",
            options = listOf("ಆಕರ್ಷಿಸುತ್ತವೆ", "ವಿಕರ್ಷಿಸುತ್ತವೆ", "ಬದಲಾವಣೆ ಇಲ್ಲ", "ಮೊದಲು ಆಕರ್ಷಿಸಿ ನಂತರ ವಿಕರ್ಷಿಸುತ್ತವೆ"),
            correctAnswer = "ವಿಕರ್ಷಿಸುತ್ತವೆ",
            explanation = "ಕಾಂತದ ಸಜಾತಿಯ (ಸಮಾನ) ಧ್ರುವಗಳು ಪರಸ್ಪರ ವಿಕರ್ಷಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u4_10",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಾಂತದ ಅಸಮಾನ ಧ್ರುವಗಳು ಒಂದಕ್ಕೊಂದು ಏನಾಗುತ್ತವೆ?",
            options = listOf("ವಿಕರ್ಷಿಸುತ್ತವೆ", "ಆಕರ್ಷಿಸುತ್ತವೆ", "ದೂರ ತಳ್ಳುತ್ತವೆ", "ಏನೂ ಆಗುವುದಿಲ್ಲ"),
            correctAnswer = "ಆಕರ್ಷಿಸುತ್ತವೆ",
            explanation = "ಕಾಂತದ ವಿಜಾತಿಯ (ವಿರುದ್ಧ) ಧ್ರುವಗಳು ಪರಸ್ಪರ ಆಕರ್ಷಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u4_11",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ದಿಕ್ಸೂಚಿಯನ್ನು ಯಾವುದಕ್ಕಾಗಿ ಬಳಸಲಾಗುತ್ತದೆ?",
            options = listOf("ತಾಪ ಅಳೆಯಲು", "ದಿಕ್ಕು ತಿಳಿಯಲು", "ದೂರ ಅಳೆಯಲು", "ಬೆಳಕನ್ನು ನೋಡಲು"),
            correctAnswer = "ದಿಕ್ಕು ತಿಳಿಯಲು",
            explanation = "ದಿಕ್ಸೂಚಿಯಲ್ಲಿರುವ ಕಾಂತೀಯ ಸೂಜಿಯು ದಿಕ್ಕುಗಳನ್ನು (ಉತ್ತರ-ದಕ್ಷಿಣ) ಗುರುತಿಸಲು ನೆರವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u4_12",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ನೈಸರ್ಗಿಕ ಕಾಂತಕ್ಕೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಪಟ್ಟಿ ಕಾಂತ", "ಕುದುರೆ ಲಾಳಾಕಾರದ ಕಾಂತ", "ಮ್ಯಾಗ್ನೆಟೈಟ್", "ಸೂಜಿ ಕಾಂತ"),
            correctAnswer = "ಮ್ಯಾಗ್ನೆಟೈಟ್",
            explanation = "ಮ್ಯಾಗ್ನೆಟೈಟ್ ನಿಸರ್ಗದಲ್ಲಿ ದೊರೆಯುವ ನೈಸರ್ಗಿಕ ಕಾಂತೀಯ ಅದಿರು."
        ),
        QuestionModel(
            id = "s_6_sci_u4_13",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಾಂತದ ಅತ್ಯಂತ ಹೆಚ್ಚಿನ ಆಕರ್ಷಣ ಶಕ್ತಿ ಎಲ್ಲಿದೆ?",
            options = listOf("ಮಧ್ಯದಲ್ಲಿ", "ಧ್ರುವಗಳಲ್ಲಿ", "ಒಂದು ಬದಿಯಲ್ಲಿ ಮಾತ್ರ", "ಎಲ್ಲ ಕಡೆ ಸಮನಾಗಿ"),
            correctAnswer = "ಧ್ರುವಗಳಲ್ಲಿ",
            explanation = "ಕಾಂತದ ಕಾಂತೀಯ ಬಲವು ಅದರ ಎರಡೂ ತುದಿಗಳಲ್ಲಿ (ಧ್ರುವಗಳಲ್ಲಿ) ಗರಿಷ್ಠವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u4_14",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಅಕಾಂತೀಯ ವಸ್ತು ಯಾವುದು?",
            options = listOf("ನಿಕ್ಕಲ್", "ಕೋಬಾಲ್ಟ್", "ಪ್ಲಾಸ್ಟಿಕ್", "ಉಕ್ಕು"),
            correctAnswer = "ಪ್ಲಾಸ್ಟಿಕ್",
            explanation = "ಪ್ಲಾಸ್ಟಿಕ್ ಕಾಂತದಿಂದ ಆಕರ್ಷಿತವಾಗುವುದಿಲ್ಲ, ಆದ್ದರಿಂದ ಇದು ಅಕಾಂತೀಯ ವಸ್ತು."
        ),
        QuestionModel(
            id = "s_6_sci_u4_15",
            stdId = 6,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಾಂತವನ್ನು ಕಾಯಿಸಿದಾಗ ಅದರ ಶಕ್ತಿ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಹೆಚ್ಚಾಗುತ್ತದೆ", "ಬದಲಾಗುವುದಿಲ್ಲ", "ನಾಶವಾಗುತ್ತದೆ ಅಥವಾ ಕಳೆದುಹೋಗುತ್ತದೆ", "ದ್ವಿಗುಣವಾಗುತ್ತದೆ"),
            correctAnswer = "ನಾಶವಾಗುತ್ತದೆ ಅಥವಾ ಕಳೆದುಹೋಗುತ್ತದೆ",
            explanation = "ಕಾಂತವನ್ನು ಕಾಯಿಸಿದಾಗ ಅದರ ಪರಮಾಣುಗಳ ಜೋಡಣೆ ತಪ್ಪಿ ಕಾಂತೀಯ ಗುಣ ನಾಶವಾಗುತ್ತದೆ."
        ),

        // ==================== ಅಧ್ಯಾಯ 5: ಉದ್ದದ ಅಳತೆ ಮತ್ತು ಚಲನೆ ====================
        QuestionModel(
            id = "s_6_sci_u5_1",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಅಳತೆಯಲ್ಲಿ ನಿರ್ದೇಶಕ ಬಿಂದುವನ್ನು ಪರಿಗಣಿಸುವುದರ ಉದ್ದೇಶವೇನು?",
            options = listOf("ಅಳತೆಯನ್ನು ಸುಲಭಗೊಳಿಸುವುದು", "ಅಳತೆಯನ್ನು ನಿಖರಗೊಳಿಸುವುದು", "ವಸ್ತುಗಳನ್ನು ಹೋಲಿಸುವುದು", "ಕಾಲವನ್ನು ಸರಿಯಾಗಿ ಅಳೆಯುವುದು"),
            correctAnswer = "ಅಳತೆಯನ್ನು ನಿಖರಗೊಳಿಸುವುದು",
            explanation = "ನಿರ್ದಿಷ್ಟ ನಿರ್ದೇಶಕ ಬಿಂದುವಿನಿಂದ ಅಳತೆ ಮಾಡಿದಾಗ ಅಳತೆಯು ನಿಖರವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u5_2",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಆಂದೋಲನ ಚಲನೆಗೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಗಡಿಯಾರದ ಲೋಲಕ", "ಚಲಿಸುತ್ತಿರುವ ಜೋಡಕಾಲು", "ಅಲುಗಾಡುವ ಎಲೆ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಮುಂದಕ್ಕೆ ಮತ್ತು ಹಿಂದಕ್ಕೆ ನಿಯಮಿತವಾಗಿ ಚಲಿಸುವ ಚಲನೆಗಳು ಆಂದೋಲನ ಚಲನೆಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u5_3",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಉದ್ದದ ಅಂತರರಾಷ್ಟ್ರೀಯ ಏಕಮಾನ (SI Unit) ಯಾವುದು?",
            options = listOf("ಸೆಂಟಿಮೀಟರ್", "ಮಿಲಿಮೀಟರ್", "ಮೀಟರ್", "ಕಿಲೋಮೀಟರ್"),
            correctAnswer = "ಮೀಟರ್",
            explanation = "ಉದ್ದದ ಅಧಿಕೃತ SI ಏಕಮಾನ ಮೀಟರ್ (Meter, m) ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u5_4",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಮೀಟರ್‌ನಲ್ಲಿ ಎಷ್ಟು ಸೆಂಟಿಮೀಟರ್‌ಗಳಿವೆ?",
            options = listOf("10", "50", "100", "1000"),
            correctAnswer = "100",
            explanation = "1 ಮೀಟರ್ = 100 ಸೆಂಟಿಮೀಟರ್."
        ),
        QuestionModel(
            id = "s_6_sci_u5_5",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಸಾಮಾನ್ಯ ಅಳತೆಪಟ್ಟಿಯಲ್ಲಿನ ಉದ್ದದ ಕನಿಷ್ಠ ಏಕಮಾನ ಯಾವುದು?",
            options = listOf("ಸೆಂಟಿಮೀಟರ್", "ಮೀಟರ್", "ಮಿಲಿಮೀಟರ್", "ಕಿಲೋಮೀಟರ್"),
            correctAnswer = "ಮಿಲಿಮೀಟರ್",
            explanation = "ಸಾಮಾನ್ಯ ಪ್ಲಾಸ್ಟಿಕ್ ಅಳತೆಪಟ್ಟಿಯ ಕನಿಷ್ಠ ಗುರುತು 1 ಮಿಲಿಮೀಟರ್ (1 mm) ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u5_6",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಬೆಂಚಿನ ಉದ್ದ 5 ಮೀಟರ್ ಆಗಿದ್ದರೆ ಅದರ ಉದ್ದ ಸೆಂಟಿಮೀಟರ್‌ಗಳಲ್ಲಿ ಎಷ್ಟು?",
            options = listOf("50 cm", "500 cm", "5 cm", "100 cm"),
            correctAnswer = "500 cm",
            explanation = "5 ಮೀಟರ್ × 100 = 500 cm."
        ),
        QuestionModel(
            id = "s_6_sci_u5_7",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮಿಲಿಮೀಟರ್ ಮತ್ತು ಸೆಂಟಿಮೀಟರ್ ನಡುವಿನ ಸರಿಯಾದ ಸಂಬಂಧ ಯಾವುದು?",
            options = listOf("1 mm = 1 cm", "1 mm = 10 cm", "1 mm = 0.1 cm", "1 mm = 100 cm"),
            correctAnswer = "1 mm = 0.1 cm",
            explanation = "10 mm = 1 cm, ಆದ್ದರಿಂದ 1 mm = 1/10 cm = 0.1 cm."
        ),
        QuestionModel(
            id = "s_6_sci_u5_8",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ರಸ್ತೆಯ ಬದಿಯ ಕಿಲೋಮೀಟರ್ ಕಲ್ಲು ಏನನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ನಿರ್ದಿಷ್ಟ ಸ್ಥಳ ತಲುಪಲು ಬೇಕಾದ ಕಾಲ", "ನಿರ್ದೇಶಕ ಬಿಂದುವಿನಿಂದ ನಿರ್ದಿಷ್ಟ ಸ್ಥಳಕ್ಕಿರುವ ದೂರ", "ವಾಹನದ ವೇಗ", "ಪ್ರಯಾಣದ ದಿಕ್ಕು"),
            correctAnswer = "ನಿರ್ದೇಶಕ ಬಿಂದುವಿನಿಂದ ನಿರ್ದಿಷ್ಟ ಸ್ಥಳಕ್ಕಿರುವ ದೂರ",
            explanation = "ಕಿಲೋಮೀಟರ್ ಕಲ್ಲು ಆರಂಭಿಕ ಬಿಂದುವಿನಿಂದ ಆ ಸ್ಥಳಕ್ಕಿರುವ ಒಟ್ಟು ದೂರವನ್ನು ತಿಳಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u5_9",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಹೊಲಿಗೆ ಯಂತ್ರದ ಸೂಜಿಯ ಚಲನೆ ಯಾವುದು?",
            options = listOf("ವೃತ್ತೀಯ ಚಲನೆ", "ಪರಿಭ್ರಮಣ ಚಲನೆ", "ಆಂದೋಲನ ಚಲನೆ", "ಆವರ್ತಕ ಚಲನೆ"),
            correctAnswer = "ಆಂದೋಲನ ಚಲನೆ",
            explanation = "ಹೊಲಿಗೆ ಯಂತ್ರದ ಸೂಜಿ ಮೇಲಕ್ಕೆ ಮತ್ತು ಕೆಳಕ್ಕೆ ಪುನರಾವರ್ತಿತವಾಗಿ ಆಂದೋಲನ ಚಲನೆ ನಡೆಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u5_10",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪ್ರತಿಪಾದನೆ: ವ್ಯಕ್ತಿಯ ಕೈಗೇಣು ಅಳತೆಯನ್ನು ದೂರದ ಆದರ್ಶಮಾನವಾಗಿ ಬಳಸಬಹುದು.\nಕಾರಣ: ವ್ಯಕ್ತಿಯ ಕೈಗೇಣು ಅಳತೆಯು ಒಬ್ಬರಿಂದ ಒಬ್ಬರಿಗೆ ಬೇರೆಬೇರೆ ಆಗಿರುತ್ತದೆ.",
            options = listOf("ಪ್ರತಿಪಾದನೆ ಸರಿ, ಕಾರಣ ತಪ್ಪು", "ಪ್ರತಿಪಾದನೆ ಸರಿ, ಕಾರಣ ಸರಿ", "ಪ್ರತಿಪಾದನೆ ತಪ್ಪು, ಕಾರಣ ತಪ್ಪು", "ಪ್ರತಿಪಾದನೆ ತಪ್ಪು, ಕಾರಣ ಸರಿ"),
            correctAnswer = "ಪ್ರತಿಪಾದನೆ ತಪ್ಪು, ಕಾರಣ ಸರಿ",
            explanation = "ಕೈಗೇಣು ವ್ಯಕ್ತಿಯಿಂದ ವ್ಯಕ್ತಿಗೆ ಬದಲಾಗುವುದರಿಂದ ಅದನ್ನು ಆದರ್ಶ ಮಾನದಂಡವಾಗಿ ಬಳಸಲು ಸಾಧ್ಯವಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u5_11",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಆಟದ ಮೈದಾನದ ಉದ್ದವನ್ನು ನಿಖರವಾಗಿ ಅಳೆಯಲು ಯಾವುದನ್ನು ಬಳಸಬೇಕು?",
            options = listOf("ಕೈಗೇಣು", "ಹೆಜ್ಜೆಗಳು", "ಅಳತೆಪಟ್ಟಿ", "ಪ್ಲಾಸ್ಟಿಕ್ ದಾರ"),
            correctAnswer = "ಅಳತೆಪಟ್ಟಿ",
            explanation = "ದೊಡ್ಡ ಮೈದಾನಗಳನ್ನು ನಿಖರವಾಗಿ ಅಳೆಯಲು ಅಳತೆಪಟ್ಟಿ (Measuring tape) ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u5_12",
            stdId = 6,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಸೀಲಿಂಗ್ ಫ್ಯಾನ್‌ನ ರೆಕ್ಕೆಗಳು ಮತ್ತು ಗಡಿಯಾರದ ಮುಳ್ಳುಗಳ ಚಲನೆ ಯಾವ ರೀತಿಯದು?",
            options = listOf("ಸರಳ ರೇಖೀಯ ಚಲನೆ", "ವೃತ್ತೀಯ ಚಲನೆ", "ಆವರ್ತಕ ಚಲನೆ", "ವೃತ್ತೀಯ ಮತ್ತು ಆವರ್ತಕ ಚಲನೆ"),
            correctAnswer = "ವೃತ್ತೀಯ ಮತ್ತು ಆವರ್ತಕ ಚಲನೆ",
            explanation = "ಇವುಗಳು ವೃತ್ತಾಕಾರದ ಪಥದಲ್ಲಿ ನಿಯಮಿತ ಕಾಲಾವಧಿಯಲ್ಲಿ ಸುತ್ತುತ್ತವೆ (ವೃತ್ತೀಯ ಮತ್ತು ಆವರ್ತಕ ಚಲನೆ)."
        ),

        // ==================== ಅಧ್ಯಾಯ 6: ನಮ್ಮ ಸುತ್ತಲಿನ ಸಾಮಗ್ರಿಗಳು ====================
        QuestionModel(
            id = "s_6_sci_u6_1",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದರ ಮೇಲೆ ಬೆಳಕು ಬಿದ್ದಾಗ ಹೊಳೆಯುತ್ತದೆ?",
            options = listOf("ಪೇಪರ್", "ಸೀಮೆಸುಣ್ಣ", "ಮರದ ತುಂಡು", "ಅಲ್ಯೂಮಿನಿಯಂ ಹಾಳೆ"),
            correctAnswer = "ಅಲ್ಯೂಮಿನಿಯಂ ಹಾಳೆ",
            explanation = "ಲೋಹದ ಮೇಲ್ಮೈಗಳು ಹೊಳಪು (Lustre) ಹೊಂದಿರುವುದರಿಂದ ಅಲ್ಯೂಮಿನಿಯಂ ಹಾಳೆ ಹೊಳೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u6_2",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಗಾಳಿಯ ಮೂಲಕ ಒಬ್ಬರನ್ನೊಬ್ಬರು ನೋಡಬಹುದು; ಆದರೆ ಮರದ ಬಾಗಿಲಿನ ಮೂಲಕ ನೋಡಲು ಸಾಧ್ಯವಿಲ್ಲ. ಕಾರಣವೇನು?",
            options = listOf(
                "ಪಾರದರ್ಶಕ ಮತ್ತು ಅಪಾರದರ್ಶಕ ವಸ್ತುಗಳು",
                "ಅರೆಪಾರದರ್ಶಕ ಮತ್ತು ಪಾರದರ್ಶಕ ವಸ್ತುಗಳು",
                "ಪಾರದರ್ಶಕ ಮತ್ತು ಅರೆಪಾರದರ್ಶಕ ವಸ್ತುಗಳು",
                "ಲೋಹ ಮತ್ತು ಅಲೋಹ ವಸ್ತುಗಳು"
            ),
            correctAnswer = "ಪಾರದರ್ಶಕ ಮತ್ತು ಅಪಾರದರ್ಶಕ ವಸ್ತುಗಳು",
            explanation = "ಗಾಳಿಯು ಪಾರದರ್ಶಕ (Transparent) ಮತ್ತು ಮರವು ಅಪಾರದರ್ಶಕ (Opaque) ವಸ್ತುವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u6_3",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ನೀರಿನಲ್ಲಿ ಕರಗದ ವಸ್ತು ಯಾವುದು?",
            options = listOf("ಉಪ್ಪು", "ಸಕ್ಕರೆ", "ಗ್ಲೂಕೋಸ್", "ಎಣ್ಣೆ"),
            correctAnswer = "ಎಣ್ಣೆ",
            explanation = "ಎಣ್ಣೆಯು ನೀರಿನಲ್ಲಿ ಕರಗುವುದಿಲ್ಲ (ಅವಿಲೀನ) ಮತ್ತು ನೀರಿನ ಮೇಲ್ಮೈಯಲ್ಲಿ ತೇಲುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u6_4",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಎಣ್ಣೆ ಮಿಶ್ರಿತ ಗಾಜು ಯಾವುದಕ್ಕೆ ಉದಾಹರಣೆ?",
            options = listOf("ಪಾರದರ್ಶಕ", "ಅಪಾರದರ್ಶಕ", "ಅರೆಪಾರದರ್ಶಕ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ಅರೆಪಾರದರ್ಶಕ",
            explanation = "ಎಣ್ಣೆ ಸವರಿದ ಕಾಗದ ಅಥವಾ ಗಾಜು ಬೆಳಕನ್ನು ಅಲ್ಪ ಪ್ರಮಾಣದಲ್ಲಿ ಹಾದುಹೋಗಲು ಬಿಡುತ್ತದೆ (ಅರೆಪಾರದರ್ಶಕ - Translucent)."
        ),
        QuestionModel(
            id = "s_6_sci_u6_5",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಲೋಹಗಳು ಸಾಮಾನ್ಯ ದಿನಗಳಲ್ಲಿ ಹೊಳಪನ್ನು ಕಳೆದುಕೊಳ್ಳಲು ಕಾರಣವೇನು?",
            options = listOf("ಧೂಳಿನಿಂದ", "ಗಾಳಿ ಮತ್ತು ತೇವಾಂಶದ ಕ್ರಿಯೆಯಿಂದ", "ಶಾಖದಿಂದ", "ತೇವಾಂಶದಿಂದ ಮಾತ್ರ"),
            correctAnswer = "ಗಾಳಿ ಮತ್ತು ತೇವಾಂಶದ ಕ್ರಿಯೆಯಿಂದ",
            explanation = "ವಾತಾವರಣದ ಗಾಳಿ ಮತ್ತು ತೇವಾಂಶದೊಂದಿಗೆ ವರ್ತಿಸಿ ಲೋಹಗಳು ಹೊಳಪು ಕಳೆದುಕೊಳ್ಳುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u6_6",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ನೀರಿನ ಮೇಲೆ ತೇಲುವ ವಸ್ತುವನ್ನು ಗುರುತಿಸಿ:",
            options = listOf("ನಾಣ್ಯ", "ಕಲ್ಲು", "ಒಣಗಿದ ಎಲೆ", "ಗಾಜಿನ ಗೋಲಿ"),
            correctAnswer = "ಒಣಗಿದ ಎಲೆ",
            explanation = "ಒಣಗಿದ ಎಲೆಯ ಸಾಂದ್ರತೆ ನೀರಿಗಿಂತ ಕಡಿಮೆಯಿರುವುದರಿಂದ ನೀರಿನ ಮೇಲೆ ತೇಲುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u6_7",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಗಟ್ಟಿಯಾದ ವಸ್ತುವಿನ ಗುಣಲಕ್ಷಣ ಯಾವುದು?",
            options = listOf("ಸುಲಭವಾಗಿ ಕುಗ್ಗಿಸಬಹುದು", "ಸುಲಭವಾಗಿ ಗೀಚಲು ಅಥವಾ ಕುಗ್ಗಿಸಲು ಸಾಧ್ಯವಿಲ್ಲ", "ಆಕಾರವನ್ನು ಸುಲಭವಾಗಿ ಬದಲಾಯಿಸಬಹುದು", "ನೀರಿನಲ್ಲಿ ಕರಗುತ್ತದೆ"),
            correctAnswer = "ಸುಲಭವಾಗಿ ಗೀಚಲು ಅಥವಾ ಕುಗ್ಗಿಸಲು ಸಾಧ್ಯವಿಲ್ಲ",
            explanation = "ಕಠಿಣ (Hard) ವಸ್ತುಗಳನ್ನು ಸುಲಭವಾಗಿ ಅದುಮಲು ಅಥವಾ ಗೀಚಲು ಸಾಧ್ಯವಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u6_8",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಅಂಗಡಿಯವರು ಮಿಠಾಯಿಗಳನ್ನು ಗಾಜು ಅಥವಾ ಪ್ಲಾಸ್ಟಿಕ್ ಡಬ್ಬಿಗಳಲ್ಲಿ ಇಡುವ ಕಾರಣವೇನು?",
            options = listOf("ಅವು ಅಗ್ಗವಾಗಿವೆ", "ಅವು ಅಪಾರದರ್ಶಕವಾಗಿವೆ", "ಖರೀದಿಸುವವರಿಗೆ ವಸ್ತುಗಳು ಸುಲಭವಾಗಿ ಕಾಣಲಿ ಎಂದು", "ಅವು ಬಲವಾಗಿವೆ"),
            correctAnswer = "ಖರೀದಿಸುವವರಿಗೆ ವಸ್ತುಗಳು ಸುಲಭವಾಗಿ ಕಾಣಲಿ ಎಂದು",
            explanation = "ಗಾಜು ಮತ್ತು ಪಾರದರ್ಶಕ ಪ್ಲಾಸ್ಟಿಕ್ ಮೂಲಕ ಗ್ರಾಹಕರು ಒಳಗಿನ ವಸ್ತುಗಳನ್ನು ಸ್ಪಷ್ಟವಾಗಿ ನೋಡಬಹುದು."
        ),
        QuestionModel(
            id = "s_6_sci_u6_9",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ನೀರಿನಲ್ಲಿ ಕರಗುವ ಅನಿಲಕ್ಕೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಸಾರಜನಕ", "ಆಮ್ಲಜನಕ", "ಜಲಜನಕ", "ಮಿಥೇನ್"),
            correctAnswer = "ಆಮ್ಲಜನಕ",
            explanation = "ನೀರಿನಲ್ಲಿ ಕರಗಿರುವ ಆಮ್ಲಜನಕವು (Dissolved Oxygen) ಜಲಚರ ಜೀವಿಗಳ ಉಸಿರಾಟಕ್ಕೆ ನೆರವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u6_10",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ವಸ್ತುವನ್ನು ತಯಾರಿಸಲು ಸಾಮಗ್ರಿಯನ್ನು ಯಾವುದರ ಆಧಾರದ ಮೇಲೆ ಆಯ್ಕೆ ಮಾಡಲಾಗುತ್ತದೆ?",
            options = listOf("ಅದರ ಬಣ್ಣ ಮಾತ್ರ", "ಅದರ ಗುಣಲಕ್ಷಣಗಳು ಮತ್ತು ಬಳಕೆಯ ಉದ್ದೇಶ", "ಅದರ ತೂಕ ಮಾತ್ರ", "ಅದರ ಲಭ್ಯತೆ ಮಾತ್ರ"),
            correctAnswer = "ಅದರ ಗುಣಲಕ್ಷಣಗಳು ಮತ್ತು ಬಳಕೆಯ ಉದ್ದೇಶ",
            explanation = "ವಸ್ತುವಿನ ಉದ್ದೇಶ ಮತ್ತು ಸಾಮಗ್ರಿಯ ಭೌತಿಕ ಗುಣಗಳ ಆಧಾರದ ಮೇಲೆ ಆಯ್ಕೆ ಮಾಡಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u6_11",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ಲೋಹವಲ್ಲ?",
            options = listOf("ಮರ", "ಚಿನ್ನ", "ತಾಮ್ರ", "ಅಲ್ಯೂಮಿನಿಯಂ"),
            correctAnswer = "ಮರ",
            explanation = "ಮರವು ನೈಸರ್ಗಿಕ ಜೈವಿಕ ವಸ್ತುವಾಗಿದ್ದು ಲೋಹವಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u6_12",
            stdId = 6,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ನೀರಿನಲ್ಲಿ ಮುಳುಗುವ ಆದರೆ ತೆಂಗಿನ ಎಣ್ಣೆಯಲ್ಲಿ ತೇಲುವ ವಸ್ತುವಿನ ಸಾಂದ್ರತೆ ಹೇಗಿರುತ್ತದೆ?",
            options = listOf("ನೀರಿಗಿಂತ ಹೆಚ್ಚು", "ನೀರಿಗಿಂತ ಕಡಿಮೆ, ತೆಂಗಿನ ಎಣ್ಣೆಗಿಂತ ಹೆಚ್ಚು", "ಎರಡಕ್ಕಿಂತಲೂ ಕಡಿಮೆ", "ಎರಡಕ್ಕಿಂತಲೂ ಹೆಚ್ಚು"),
            correctAnswer = "ನೀರಿಗಿಂತ ಕಡಿಮೆ, ತೆಂಗಿನ ಎಣ್ಣೆಗಿಂತ ಹೆಚ್ಚು",
            explanation = "ವಸ್ತುವಿನ ಸಾಂದ್ರತೆಯ ಆಧಾರದಲ್ಲಿ ತೇಲುವಿಕೆ ಮತ್ತು ಮುಳುಗುವಿಕೆ ನಿರ್ಧಾರವಾಗುತ್ತದೆ."
        ),

        // ==================== ಅಧ್ಯಾಯ 7: ಶಾಖ ಮತ್ತು ಅದರ ಮಾಪನ ====================
        QuestionModel(
            id = "s_6_sci_u7_1",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ತಾಪದ ಅಂತರರಾಷ್ಟ್ರೀಯ (SI) ಏಕಮಾನ ಯಾವುದು?",
            options = listOf("ಡಿಗ್ರಿ", "ಕೆಲ್ವಿನ್", "ಸೆಲ್ಸಿಯಸ್", "ಫ್ಯಾರನ್‌ಹೀಟ್"),
            correctAnswer = "ಕೆಲ್ವಿನ್",
            explanation = "ತಾಪಮಾನದ ಪ್ರಮಾಣಿತ SI ಏಕಮಾನ ಕೆಲ್ವಿನ್ (Kelvin, K) ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_2",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ತಾಪಮಾಪಕ ಯಾವುದನ್ನು ಅಳೆಯುತ್ತದೆ?",
            options = listOf("ಶಾಖ", "ಬೆಳಕಿನ ತೀವ್ರತೆ", "ತಾಪಮಾನ", "ಗಾಳಿಯ ಒತ್ತಡ"),
            correctAnswer = "ತಾಪಮಾನ",
            explanation = "ತಾಪಮಾಪಕವು (Thermometer) ವಸ್ತುವಿನ ತಾಪಮಾನವನ್ನು ನಿಖರವಾಗಿ ಅಳೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_3",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಬೇಸಿಗೆಯಲ್ಲಿ ನಲ್ಲಿಯ ನೀರು ಫ್ರಿಜ್‌ನ ತಣ್ಣನೆಯ ನೀರಿಗೆ ಹೋಲಿಸಿದರೆ ಹೇಗಿರುತ್ತದೆ?",
            options = listOf("ಹೆಚ್ಚು ಬಿಸಿಯಾಗಿರುತ್ತದೆ", "ತಣ್ಣಗಿರುತ್ತದೆ", "ಹೆಚ್ಚು ತಂಪಾಗಿರುತ್ತದೆ", "ದುರ್ಬಲವಾಗಿರುತ್ತದೆ"),
            correctAnswer = "ಹೆಚ್ಚು ಬಿಸಿಯಾಗಿರುತ್ತದೆ",
            explanation = "ಫ್ರಿಜ್‌ನ ನೀರಿಗೆ ಹೋಲಿಸಿದರೆ ನಲ್ಲಿಯ ನೀರು ಹೆಚ್ಚಿನ ತಾಪಮಾನ ಹೊಂದಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_4",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ದೇಹದ ತಾಪವನ್ನು ಅಳೆಯಲು ಬಳಸುವ ತಾಪಮಾಪಕ ಯಾವುದು?",
            options = listOf("ಪ್ರಯೋಗಶಾಲಾ ತಾಪಮಾಪಕ", "ಪ್ರಯೋಗಾತ್ಮಕ ತಾಪಮಾಪಕ", "ವೈದ್ಯಕೀಯ ತಾಪಮಾಪಕ", "ಗೋಡೆಗೆ ಅಳವಡಿಸುವ ತಾಪಮಾಪಕ"),
            correctAnswer = "ವೈದ್ಯಕೀಯ ತಾಪಮಾಪಕ",
            explanation = "ಮಾನವ ದೇಹದ ಉಷ್ಣತೆಯನ್ನು ಅಳೆಯಲು ವೈದ್ಯಕೀಯ (ಕ್ಲಿನಿಕಲ್) ತಾಪಮಾಪಕ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_5",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಡಿಜಿಟಲ್ ವೈದ್ಯಕೀಯ ತಾಪಮಾಪಕದಲ್ಲಿ ತಾಪವನ್ನು ಯಾವುದರ ಸಹಾಯದಿಂದ ನಿರ್ಧರಿಸಲಾಗುತ್ತದೆ?",
            options = listOf("ಶಾಖ ಸಂವೇದಕಗಳು", "ಶೀತ ಸಂವೇದಕಗಳು", "ಬಿಸಿ ಚಿಪ್‌ಗಳು", "ಬಿಸಿ ಪ್ಯಾನೆಲ್‌ಗಳು"),
            correctAnswer = "ಶಾಖ ಸಂವೇದಕಗಳು",
            explanation = "ಡಿಜಿಟಲ್ ತಾಪಮಾಪಕದಲ್ಲಿ ಶಾಖ ಸಂವೇದಕಗಳು (Heat sensors / thermistors) ತಾಪಮಾನವನ್ನು ಅಳೆಯುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_6",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "37°C ತಾಪಮಾನವು ಫ್ಯಾರನ್‌ಹೀಟ್‌ನಲ್ಲಿ ಎಷ್ಟಕ್ಕೆ ಸಮಾನ?",
            options = listOf("97.4°F", "97.6°F", "98.4°F", "98.6°F"),
            correctAnswer = "98.6°F",
            explanation = "ಸಾಮಾನ್ಯ ಮಾನವ ದೇಹದ ಉಷ್ಣತೆ 37°C ಅಥವಾ 98.6°F ಆಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_7",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ದೇಹವನ್ನು ಸಂಪರ್ಕಿಸದೆ ದೇಹದ ತಾಪವನ್ನು ಅಳೆಯಬಲ್ಲ ತಾಪಮಾಪಕ ಯಾವುದು?",
            options = listOf("ಪಾದರಸ ತಾಪಮಾಪಕ", "ಡಿಜಿಟಲ್ ತಾಪಮಾಪಕ", "ಅವಕೆಂಪು ವಿಕಿರಣ ತಾಪಮಾಪಕ", "ಪ್ರಯೋಗಶಾಲಾ ತಾಪಮಾಪಕ"),
            correctAnswer = "ಅವಕೆಂಪು ವಿಕಿರಣ ತಾಪಮಾಪಕ",
            explanation = "ಅವಕೆಂಪು (Infrared) ತಾಪಮಾಪಕವು ಸ್ಪರ್ಶವಿಲ್ಲದೆ ದೇಹದ ತಾಪವನ್ನು ಅಳೆಯಬಲ್ಲದು."
        ),
        QuestionModel(
            id = "s_6_sci_u7_8",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ತಾಪಮಾಪಕದಿಂದ ದೇಹದ ತಾಪವನ್ನು ಹೇಗೆ ಓದಬೇಕು?",
            options = listOf("ತಕ್ಷಣ ತೆಗೆದ ನಂತರ", "ಅದನ್ನು ಅಲುಗಾಡಿಸಿದ ನಂತರ", "ಅದನ್ನು ತೆಗೆದು", "5 ನಿಮಿಷಗಳ ನಂತರ"),
            correctAnswer = "ಅದನ್ನು ತೆಗೆದು",
            explanation = "ವೈದ್ಯಕೀಯ ತಾಪಮಾಪಕದಲ್ಲಿ ಕಿಂಕ್ (ಸಂಕೋಚನ) ಇರುವುದರಿಂದ ಬಾಯಿಯಿಂದ ಹೊರತೆಗೆದು ನಿಧಾನವಾಗಿ ಓದಬಹುದು."
        ),
        QuestionModel(
            id = "s_6_sci_u7_9",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ನೀರಿನ ಘನೀಕರಣ ಬಿಂದುವಿಗಿಂತ ಕಡಿಮೆ ಇರುವ ತಾಪಮಾನ ಯಾವುದು?",
            options = listOf("0°C", "−5°C", "10°C", "5°C"),
            correctAnswer = "−5°C",
            explanation = "ನೀರು 0°C ನಲ್ಲಿ ಘನೀಕರಿಸುತ್ತದೆ; −5°C ತಾಪಮಾನವು ಅದಕ್ಕಿಂತ ಕಡಿಮೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_10",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ತಾಪಮಾಪಕದ ಯಾವ ಭಾಗದಲ್ಲಿ ಪಾದರಸ ಇರುತ್ತದೆ?",
            options = listOf("ಕ್ಯಾಪಿಲರಿ ಟ್ಯೂಬ್", "ಹೊರಗಿನ ಕವಚ", "ಅಳತೆಪಟ್ಟಿ", "ಬಟನ್"),
            correctAnswer = "ಕ್ಯಾಪಿಲರಿ ಟ್ಯೂಬ್",
            explanation = "ತಾಪಮಾಪಕದ ಬುಗ್ಗೆಯಿಂದ ಸೂಕ್ಷ್ಮ ಕ್ಯಾಪಿಲರಿ ನಾಳದವರೆಗೆ ಪಾದರಸ ಚಲಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_11",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ವೈದ್ಯಕೀಯ ತಾಪಮಾಪಕದ ಓದುವಿಕೆಯನ್ನು ಯಾವ ಮಟ್ಟದಲ್ಲಿ ಹಿಡಿದು ಓದಬೇಕು?",
            options = listOf("ಕೈಯಲ್ಲಿ ಸಮತಲವಾಗಿ", "ಕಣ್ಣಿನ ಮಟ್ಟದಲ್ಲಿ", "ಕಣ್ಣಿನ ಮಟ್ಟಕ್ಕಿಂತ ಕೆಳಗೆ", "ಕಣ್ಣಿನ ಮಟ್ಟಕ್ಕಿಂತ ಮೇಲೆ"),
            correctAnswer = "ಕಣ್ಣಿನ ಮಟ್ಟದಲ್ಲಿ",
            explanation = "ದೃಷ್ಟಿದೋಷದ (Parallax error) ತಪ್ಪನ್ನು ನಿವಾರಿಸಲು ಕಣ್ಣಿನ ಸಮತಲ ಮಟ್ಟದಲ್ಲಿ ಹಿಡಿದು ಓದಬೇಕು."
        ),
        QuestionModel(
            id = "s_6_sci_u7_12",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ತಾಪಮಾಪಕದಲ್ಲಿ ಪಾದರಸವನ್ನು ಬಳಸುವ ಕಾರಣವೇನು?",
            options = listOf(
                "ಅದು ಬಣ್ಣಬಣ್ಣವಾಗಿರುತ್ತದೆ",
                "ಅದು ಅಂಟಿಕೊಳ್ಳುತ್ತದೆ",
                "ಅದು ಶಾಖದ ಉತ್ತಮ ವಾಹಕ ಮತ್ತು ಗಾಜಿಗೆ ಅಂಟಿಕೊಳ್ಳುವುದಿಲ್ಲ",
                "ಅದು ಸುಲಭವಾಗಿ ಕುದಿಯುತ್ತದೆ"
            ),
            correctAnswer = "ಅದು ಶಾಖದ ಉತ್ತಮ ವಾಹಕ ಮತ್ತು ಗಾಜಿಗೆ ಅಂಟಿಕೊಳ್ಳುವುದಿಲ್ಲ",
            explanation = "ಪಾದರಸವು ಸಮರೂಪವಾಗಿ ಹಿಗ್ಗುತ್ತದೆ, ಉತ್ತಮ ವಾಹಕ ಮತ್ತು ಗಾಜಿನ ನಳಿಗೆಗೆ ಅಂಟಿಕೊಳ್ಳುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_13",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕೆಲ್ವಿನ್ ಮಾಪಕದಲ್ಲಿನ ತಾಪ = ಸೆಲ್ಸಿಯಸ್ ಮಾಪಕದಲ್ಲಿನ ತಾಪ + ಎಷ್ಟು?",
            options = listOf("273.15", "273.25", "273.75", "273.85"),
            correctAnswer = "273.15",
            explanation = "K = °C + 273.15 ಎಂಬುದು ಸೆಲ್ಸಿಯಸ್ ಮತ್ತು ಕೆಲ್ವಿನ್ ನಡುವಿನ ಪರಿವರ್ತನಾ ಸೂತ್ರ."
        ),
        QuestionModel(
            id = "s_6_sci_u7_14",
            stdId = 6,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "“ಭಾರತದ ಹವಾಮಾನ ಮಹಿಳೆ” (Weather Woman of India) ಎಂದು ಯಾರನ್ನು ಕರೆಯಲಾಗುತ್ತದೆ?",
            options = listOf("ಅಣ್ಣಾ ಮಣಿ", "ಸುನಿತಾ ವಿಲಿಯಮ್ಸ್", "ಕಲ್ಪನಾ ಚಾವ್ಲಾ", "ನಿರ್ಮಲಾ ಸೀತಾರಾಮನ್"),
            correctAnswer = "ಅಣ್ಣಾ ಮಣಿ",
            explanation = "ಭಾರತದ ಪ್ರಸಿದ್ಧ ಭೌತವಿಜ್ಞಾನಿ ಮತ್ತು ಹವಾಮಾನ ತಜ್ಞೆ ಅಣ್ಣಾ ಮಣಿ ಅವರನ್ನು 'ವೆದರ್ ವುಮನ್ ಆಫ್ ಇಂಡಿಯಾ' ಎನ್ನುತ್ತಾರೆ."
        ),

        // ==================== ಅಧ್ಯಾಯ 8: ನೀರಿನ ಸ್ಥಿತಿಗಳ ಮೂಲಕ ಒಂದು ಪಯಣ ====================
        QuestionModel(
            id = "s_6_sci_u8_1",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ನೀರಿನ ಮೂರು ಸ್ಥಿತಿಗಳು ಯಾವುವು?",
            options = listOf("ಮಂಜುಗಡ್ಡೆ, ನೀರು, ಎಣ್ಣೆ", "ಘನ, ಅರ್ಘನ, ಅನಿಲ", "ಘನ, ದ್ರವ, ಅನಿಲ", "ಮಂಜುಗಡ್ಡೆ, ಮೋಡ, ನೀರಾವಿ"),
            correctAnswer = "ಘನ, ದ್ರವ, ಅನಿಲ",
            explanation = "ನೀರು ಘನ (ಮಂಜುಗಡ್ಡೆ), ದ್ರವ (ನೀರು) ಮತ್ತು ಅನಿಲ (ನೀರಾವಿ) ಈ ಮೂರು ಸ್ಥಿತಿಗಳಲ್ಲಿ ಕಂಡುಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_2",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ತನ್ನ ಪಾತ್ರೆಯ ಆಕಾರವನ್ನು ಪಡೆದುಕೊಂಡು ಸ್ಥಿರ ಪರಿಮಾಣ ಹೊಂದಿರುವ ನೀರಿನ ಸ್ಥಿತಿ ಯಾವುದು?",
            options = listOf("ಘನ", "ದ್ರವ", "ಅನಿಲ", "ಪ್ಲಾಸ್ಮಾ"),
            correctAnswer = "ದ್ರವ",
            explanation = "ದ್ರವ ಸ್ಥಿತಿಗೆ ನಿರ್ದಿಷ್ಟ ಗಾತ್ರ (ಪರಿಮಾಣ) ಇರುತ್ತದೆ ಆದರೆ ನಿರ್ದಿಷ್ಟ ಆಕಾರವಿರುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_3",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಕೊಚ್ಚೆಗುಂಡಿಯಲ್ಲಿರುವ ನೀರು ಬಿಸಿಲಿನಿಂದ ಮಾಯವಾಗಲು ಕಾರಣವೇನು?",
            options = listOf("ನೀರು ಮಣ್ಣಿನಲ್ಲಿ ಇಂಗುವುದು", "ಆವೀಕರಣ", "ನೀರು ಹರಿದು ಹೋಗುವುದು", "ನೀರು ಘನೀಕರಿಸುವುದು"),
            correctAnswer = "ಆವೀಕರಣ",
            explanation = "ಸೂರ್ಯನ ಶಾಖದಿಂದ ನೀರು ಆವಿಯಾಗಿ ವಾತಾವರಣ ಸೇರುತ್ತದೆ (Evaporation)."
        ),
        QuestionModel(
            id = "s_6_sci_u8_4",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ವಾತಾವರಣದಲ್ಲಿನ ನೀರಾವಿ ಮಂಜಾಗಿ ರೂಪಗೊಳ್ಳಲು ಕಾರಣವೇನು?",
            options = listOf("ಆವೀಕರಣ", "ಘನೀಕರಣ", "ಬಾಷ್ಪೀಭವನ", "ಸಾಂದ್ರೀಕರಣ"),
            correctAnswer = "ಸಾಂದ್ರೀಕರಣ",
            explanation = "ನೀರಾವಿ ತಂಪಾಗಿ ಪುನಃ ದ್ರವ ಹನಿಗಳಾಗುವುದನ್ನು ಸಾಂದ್ರೀಕರಣ (Condensation) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_5",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಮಣ್ಣಿನ ಮಡಕೆಯಲ್ಲಿನ ನೀರು ತಣ್ಣಗಿರಲು ಕಾರಣವೇನು?",
            options = listOf(
                "ಮಡಿಕೆಯು ಸೂರ್ಯನ ಬೆಳಕನ್ನು ತಡೆಯುತ್ತದೆ",
                "ಮಡಿಕೆ ನೀರನ್ನು ಹೀರಿಕೊಳ್ಳುತ್ತದೆ",
                "ನೀರು ಮಡಿಕೆಯ ರಂಧ್ರಗಳ ಮೂಲಕ ಆವಿಯಾಗಿ ತಣ್ಣಗಾಗುತ್ತದೆ",
                "ಮೇಲಿನ ಯಾವುದೂ ಅಲ್ಲ"
            ),
            correctAnswer = "ನೀರು ಮಡಿಕೆಯ ರಂಧ್ರಗಳ ಮೂಲಕ ಆವಿಯಾಗಿ ತಣ್ಣಗಾಗುತ್ತದೆ",
            explanation = "ಮಡಕೆಯ ಸೂಕ್ಷ್ಮ ರಂಧ್ರಗಳಿಂದ ನೀರು ಸತತವಾಗಿ ಆವಿಯಾಗುವಾಗ ಶಾಖವನ್ನು ಹೀರಿಕೊಂಡು ಒಳಗಿನ ನೀರನ್ನು ತಂಪಾಗಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_6",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಆವೀಕರಣ ವೇಗವಾಗಿ ಯಾವಾಗ ಸಂಭವಿಸುತ್ತದೆ?",
            options = listOf("ಕಡಿಮೆ ತಾಪಮಾನವಿದ್ದಾಗ", "ಹೆಚ್ಚು ಗಾಳಿ ಮತ್ತು ಬಿಸಿಲು ಇದ್ದಾಗ", "ಮೋಡ ಕವಿದಾಗ", "ಮೇಲಿನ ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ಹೆಚ್ಚು ಗಾಳಿ ಮತ್ತು ಬಿಸಿಲು ಇದ್ದಾಗ",
            explanation = "ತಾಪಮಾನ ಮತ್ತು ಗಾಳಿಯ ವೇಗ ಹೆಚ್ಚಿದಂತೆ ಆವೀಕರಣದ ದರ ಹೆಚ್ಚಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_7",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ನೀರು ಯಾವ ಸ್ಥಿತಿಯಲ್ಲಿ ಹೆಚ್ಚಿನ ಶಕ್ತಿಯನ್ನು ಹೊಂದಿರುತ್ತದೆ?",
            options = listOf("ಘನ", "ದ್ರವ", "ಅನಿಲ", "ಮಂಜುಗಡ್ಡೆ"),
            correctAnswer = "ಅನಿಲ",
            explanation = "ಅನಿಲ ರೂಪದ ಅಣುಗಳು ಹೆಚ್ಚಿನ ಚಲನಶಕ್ತಿ (Kinetic energy) ಮತ್ತು ಸುಪ್ತೋಷ್ಣವನ್ನು ಹೊಂದಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_8",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಹಬೆ (ಆವಿ) ಎಂದರೆ ಏನು?",
            options = listOf("ದ್ರವ ನೀರು", "ಘನ ನೀರು", "ನೀರಾವಿ", "ಮಂಜುಗಡ್ಡೆ"),
            correctAnswer = "ನೀರಾವಿ",
            explanation = "ನೀರು ಕುದಿದಾಗ ಉಂಟಾಗುವ ಅನಿಲ ಸ್ಥಿತಿಯೇ ನೀರಾವಿ (Steam)."
        ),
        QuestionModel(
            id = "s_6_sci_u8_9",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ನೀರಾವಿ ತಂಪಾದಾಗ ಏನು ಉಂಟಾಗುತ್ತದೆ?",
            options = listOf("ಮಂಜುಗಡ್ಡೆ", "ಮಂಜು", "ನೀರು", "ಹಿಮ"),
            correctAnswer = "ನೀರು",
            explanation = "ನೀರಾವಿ ಸಾಂದ್ರೀಕರಣಗೊಂಡು ದ್ರವ ರೂಪದ ನೀರಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_10",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಬೆಳಗಿನ ಜಾವ ಗಿಡಗಳ ಎಲೆಗಳ ಮೇಲಿನ ಇಬ್ಬನಿ ಹನಿಗಳು ಉಂಟಾಗಲು ಕಾರಣವೇನು?",
            options = listOf(
                "ನೀರಾವಿ ಸಾಂದ್ರೀಕರಣಗೊಂಡು ಎಲೆಗಳ ಮೇಲ್ಮೈ ತಣ್ಣಗಾಗುತ್ತದೆ",
                "ಎಲೆಗಳು ನೀರನ್ನು ಹೀರಿಕೊಳ್ಳುತ್ತವೆ",
                "ರಾತ್ರಿಯಲ್ಲಿ ಮಳೆ ಆಗುತ್ತದೆ",
                "ಎಲೆಗಳಿಂದ ನೀರು ಹೊರಬರುತ್ತದೆ"
            ),
            correctAnswer = "ನೀರಾವಿ ಸಾಂದ್ರೀಕರಣಗೊಳ್ಳುವುದು",
            explanation = "ರಾತ್ರಿಯ ತಂಪಾದ ವಾತಾವರಣದಲ್ಲಿ ಗಾಳಿಯಲ್ಲಿನ ನೀರಾವಿ ಸಾಂದ್ರೀಕರಿಸಿ ಎಲೆಗಳ ಮೇಲೆ ಇಬ್ಬನಿ ಹನಿಗಳಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_11",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ನೀರು ಮಂಜುಗಡ್ಡೆಯಾಗುವ ಪ್ರಕ್ರಿಯೆ ಯಾವುದು?",
            options = listOf("ಕರಗುವಿಕೆ", "ಘನೀಕರಣ", "ಆವೀಕರಣ", "ಸಾಂದ್ರೀಕರಣ"),
            correctAnswer = "ಘನೀಕರಣ",
            explanation = "ದ್ರವ ನೀರು ತಂಪಾಗಿ ಘನ ಮಂಜುಗಡ್ಡೆಯಾಗುವುದನ್ನು ಘನೀಕರಣ (Freezing) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_12",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸೂರ್ಯನ ಬಿಸಿಯಿಂದ ನೀರು ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಆವಿಯಾಗುತ್ತದೆ", "ಆವಿಯಾಗುವುದಿಲ್ಲ", "ಸಾಂದ್ರೀಕರಣಗೊಳ್ಳುತ್ತದೆ", "ತಾಪಮಾನವಾಗುತ್ತದೆ"),
            correctAnswer = "ಆವಿಯಾಗುತ್ತದೆ",
            explanation = "ಸೌರಶಾಖದಿಂದ ಜಲಮೂಲಗಳ ನೀರು ಆವಿಯಾಗಿ ಮೇಲೆರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_13",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಮೋಡಗಳಿಂದ ಮಳೆಹನಿಗಳು ಉಂಟಾಗಲು ನೀರಿನ ಯಾವ ಪ್ರಕ್ರಿಯೆ ಮುಖ್ಯ?",
            options = listOf("ಕರಗುವಿಕೆ", "ಘನೀಕರಣ", "ಸಾಂದ್ರೀಕರಣ", "ಮಳೆ"),
            correctAnswer = "ಸಾಂದ್ರೀಕರಣ",
            explanation = "ವಾತಾವರಣದ ಮೇಲ್ಭಾಗದಲ್ಲಿ ನೀರಾವಿಯು ತಂಪಾಗಿ ಸಾಂದ್ರೀಕರಿಸಿ ಮೋಡ ಮತ್ತು ಮಳೆಹನಿಗಳಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u8_14",
            stdId = 6,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಮಂಜುಗಡ್ಡೆ ಕರಗಿ ನೀರಾಗುವ ಪ್ರಕ್ರಿಯೆ ಯಾವುದು?",
            options = listOf("ಕರಗುವಿಕೆ", "ಘನೀಕರಣ", "ಸಾಂದ್ರೀಕರಣ", "ಮಳೆ"),
            correctAnswer = "ಕರಗುವಿಕೆ",
            explanation = "ಘನ ಮಂಜುಗಡ್ಡೆ ಉಷ್ಣತೆ ಪಡೆದು ದ್ರವ ನೀರಾಗುವ ಕ್ರಿಯೆಯೇ ಕರಗುವಿಕೆ (Melting)."
        ),

        // ==================== ಅಧ್ಯಾಯ 9: ದೈನಂದಿನ ಜೀವನದಲ್ಲಿ ಬೇರ್ಪಡಿಸುವಿಕೆಯ ವಿಧಾನಗಳು ====================
        QuestionModel(
            id = "s_6_sci_u9_1",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮಿಶ್ರಣಗಳಿಂದ ಘಟಕ ವಸ್ತುಗಳನ್ನು ಬೇರ್ಪಡಿಸುವ ಸರಿಯಾದ ಉದ್ದೇಶ ಯಾವುದು?",
            options = listOf(
                "ಅಶುದ್ಧ ಅಥವಾ ಹಾನಿಕಾರಕ ಘಟಕಗಳನ್ನು ತೆಗೆಯಲು",
                "ಉಪಯುಕ್ತವಲ್ಲದ ಘಟಕಗಳನ್ನು ತೆಗೆಯಲು",
                "ಉಪಯುಕ್ತ ಘಟಕಗಳನ್ನು ಪ್ರತ್ಯೇಕಿಸಲು",
                "ಮೇಲಿನ ಎಲ್ಲವೂ"
            ),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಅನಪೇಕ್ಷಿತ ವಸ್ತುಗಳನ್ನು ತೆಗೆದು ಉಪಯುಕ್ತ ಘಟಕಗಳನ್ನು ಪಡೆಯಲು ಬೇರ್ಪಡಿಸುವಿಕೆ ಮಾಡಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_2",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮಿಶ್ರಣದಿಂದ ಪದಾರ್ಥಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು ಮಿಶ್ರಣವು ಯಾವ ಸ್ಥಿತಿಯಲ್ಲಿರಬಹುದು?",
            options = listOf("ಘನ", "ದ್ರವ", "ಅನಿಲ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಘನ-ಘನ, ಘನ-ದ್ರವ, ದ್ರವ-ದ್ರವ ಅಥವಾ ಅನಿಲ ಮಿಶ್ರಣಗಳೆಲ್ಲವನ್ನೂ ಬೇರ್ಪಡಿಸಬಹುದು."
        ),
        QuestionModel(
            id = "s_6_sci_u9_3",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮಿಶ್ರಣದಿಂದ ಘಟಕಗಳನ್ನು ಬೇರ್ಪಡಿಸುವುದಕ್ಕೆ ಸಂಬಂಧಿಸಿದ ಸರಿಯಾದ ಹೇಳಿಕೆ ಯಾವುದು?\nಹೇಳಿಕೆ 1: ಮಿಶ್ರಣದ ಅನುಪಯುಕ್ತ ಘಟಕಗಳನ್ನು ನಾವು ಎಸೆಯುತ್ತೇವೆ.\nಹೇಳಿಕೆ 2: ಮಿಶ್ರಣದ ಉಪಯುಕ್ತ ಘಟಕಗಳನ್ನು ಬಳಸುತ್ತೇವೆ.",
            options = listOf("ಹೇಳಿಕೆ 1 ಮಾತ್ರ ಸರಿ", "ಹೇಳಿಕೆ 2 ಮಾತ್ರ ಸರಿ", "ಎರಡೂ ಸರಿ", "ಎರಡೂ ತಪ್ಪು"),
            correctAnswer = "ಎರಡೂ ಸರಿ",
            explanation = "ಬೇರ್ಪಡಿಸಿದ ನಂತರ ಅನುಪಯುಕ್ತ ಕಸವನ್ನು ಎಸೆದು ಉಪಯುಕ್ತ ಪದಾರ್ಥವನ್ನು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_4",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಚಹಾ ಮಾಡುವಾಗ ಜರಡಿ ಬಳಸಿ ಚಹಾ ಎಲೆಗಳನ್ನು ಬೇರ್ಪಡಿಸುವ ಉದ್ದೇಶವೇನು?",
            options = listOf(
                "ಹಾನಿಕಾರಕ ಘಟಕಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು",
                "ಎರಡು ಪ್ರತ್ಯೇಕ ಆದರೆ ಉಪಯುಕ್ತ ಘಟಕಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು",
                "ಉಪಯುಕ್ತವಲ್ಲದ ಘಟಕಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು",
                "ವಿಷಪೂರಿತ ಘಟಕಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು"
            ),
            correctAnswer = "ಎರಡು ಪ್ರತ್ಯೇಕ ಘಟಕಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು",
            explanation = "ದ್ರವ ಚಹಾವನ್ನು ಬಳಸಲು ಘನ ಚಹಾ ಪುಡಿಯ ಹಿಪ್ಪೆಯನ್ನು ಪ್ರತ್ಯೇಕಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_5",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮರಳಿನಲ್ಲಿರುವ ಕಲ್ಲುಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು ಜರಡಿ ಹಿಡಿಯುವಿಕೆ ಸೂಕ್ತವಾಗಿರುವ ಕಾರಣವೇನು?",
            options = listOf(
                "ಮರಳಿನ ಸಣ್ಣ ಕಣಗಳು ರಂಧ್ರಗಳಿಂದ ಹಾದುಹೋಗುವುದಿಲ್ಲ",
                "ದೊಡ್ಡ ಕಲ್ಲುಗಳು ಜರಡಿಯಲ್ಲಿ ಉಳಿಯುತ್ತವೆ",
                "ಮರಳಿನ ಸಣ್ಣ ಕಣಗಳು ಜರಡಿಯ ಮೇಲೆ ಉಳಿಯುತ್ತವೆ",
                "ಮರಳಿನ ಸಣ್ಣ ಕಣಗಳು ರಂಧ್ರಗಳಿಂದ ಹಾದುಹೋಗುತ್ತವೆ"
            ),
            correctAnswer = "ಮರಳಿನ ಸಣ್ಣ ಕಣಗಳು ರಂಧ್ರಗಳಿಂದ ಹಾದುಹೋಗುತ್ತವೆ",
            explanation = "ಜರಡಿಯ ರಂಧ್ರಗಳಿಗಿಂತ ಕಣಗಳ ಗಾತ್ರ ಚಿಕ್ಕದಾಗಿರುವಾಗ ಸಣ್ಣ ಕಣಗಳು ಕೆಳಗೆ ಇಳಿಯುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_6",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಭತ್ತದ ಕಾಳುಗಳಿಂದ ಹಗುರವಾದ ಹೊಟ್ಟಿನ ಕಣಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು ತೂರುವ ವಿಧಾನವನ್ನು ಬಳಸುವ ಕಾರಣವೇನು?",
            options = listOf(
                "ಹೊಟ್ಟಿನ ಕಣಗಳನ್ನು ಗಾಳಿ ದೂರ ಕೊಂಡೊಯ್ಯುತ್ತದೆ",
                "ಧಾನ್ಯವು ಹೊಟ್ಟಿನಿಂದ ಬೇರ್ಪಡುತ್ತದೆ",
                "ಹೊಟ್ಟನ್ನು ದನಕರುಗಳಿಗೆ ಮೇವಾಗಿ ಬಳಸಬಹುದು",
                "ಮೇಲಿನ ಎಲ್ಲವೂ"
            ),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಗಾಳಿಯು ಹಗುರವಾದ ಹೊಟ್ಟನ್ನು ದೂರಕ್ಕೆ ಹಾರಿಸುತ್ತದೆ, ಭಾರವಾದ ಧಾನ್ಯಗಳು ನೇರವಾಗಿ ಕೆಳಗೆ ಬೀಳುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_7",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಭತ್ತದ ಪೈರಿನಿಂದ ಧಾನ್ಯಗಳನ್ನು ಬೇರ್ಪಡಿಸುವುದು: ಬಡಿಯುವಿಕೆ :: ಅಕ್ಕಿಯಿಂದ ಕಲ್ಲುಗಳನ್ನು ಬೇರ್ಪಡಿಸುವುದು: ?",
            options = listOf("ತೂರುವಿಕೆ", "ಕೈಯಿಂದ ಆರಿಸುವಿಕೆ", "ಬಸಿಯುವಿಕೆ", "ಶೋಧಿಸುವಿಕೆ"),
            correctAnswer = "ಕೈಯಿಂದ ಆರಿಸುವಿಕೆ",
            explanation = "ಅಕ್ಕಿಯಲ್ಲಿರುವ ಕಲ್ಲುಗಳನ್ನು ಕೈಯಿಂದ ಆರಿಸಿ (Handpicking) ಪ್ರತ್ಯೇಕಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_8",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮಣ್ಣು ಮಿಶ್ರಿತ ನೀರಿನಿಂದ ಸ್ವಚ್ಛ ನೀರನ್ನು ಪಡೆಯಲು ಬೇರ್ಪಡಿಸುವ ವಿಧಾನಗಳ ಸರಿಯಾದ ಕ್ರಮ ಯಾವುದು?",
            options = listOf(
                "ಗುರುತ್ವ ಬಲದಿಂದ ಬೇರ್ಪಡಿಸುವಿಕೆ, ಬಸಿಯುವಿಕೆ, ಶೋಧಿಸುವಿಕೆ",
                "ಶೋಧಿಸುವಿಕೆ, ಬಸಿಯುವಿಕೆ, ಗುರುತ್ವ ಬಲದಿಂದ ಬೇರ್ಪಡಿಸುವಿಕೆ",
                "ಬಸಿಯುವಿಕೆ, ಶೋಧಿಸುವಿಕೆ, ಗುರುತ್ವ ಬಲದಿಂದ ಬೇರ್ಪಡಿಸುವಿಕೆ",
                "ಗುರುತ್ವ ಬಲದಿಂದ ಬೇರ್ಪಡಿಸುವಿಕೆ, ಶೋಧಿಸುವಿಕೆ, ಬಸಿಯುವಿಕೆ"
            ),
            correctAnswer = "ಗುರುತ್ವ ಬಲದಿಂದ ಬೇರ್ಪಡಿಸುವಿಕೆ, ಶೋಧಿಸುವಿಕೆ, ಬಸಿಯುವಿಕೆ",
            explanation = "ಮೊದಲು ಮಣ್ಣು ತಳಸೇರಲು ಬಿಡುವುದು (Sedimentation), ನಂತರ ಬಸಿಯುವುದು (Decantation) ಮತ್ತು ಕೊನೆಗೆ ಶೋಧಿಸುವುದು (Filtration)."
        ),
        QuestionModel(
            id = "s_6_sci_u9_9",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಉಪ್ಪಿನ ಪೂರಿತ ದ್ರಾವಣವನ್ನು ಕಾಯಿಸುವುದರಿಂದ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಇನ್ನಷ್ಟು ಉಪ್ಪು ಕರಗಿಸಲು ಸಾಧ್ಯವಿಲ್ಲ", "ಇನ್ನಷ್ಟು ಉಪ್ಪು ಕರಗಿಸಬಹುದು", "A ಮತ್ತು B ಎರಡೂ ಸರಿ", "A ಮತ್ತು B ಎರಡೂ ತಪ್ಪು"),
            correctAnswer = "ಇನ್ನಷ್ಟು ಉಪ್ಪು ಕರಗಿಸಲು ಸಾಧ್ಯವಿಲ್ಲ",
            explanation = "ಪರ್ಯಾಪ್ತ ದ್ರಾವಣದ ತಾಪಮಾನ ಹೆಚ್ಚಿಸಿದಾಗ ಕರಗುವ ಸಾಮರ್ಥ್ಯದಲ್ಲಿ ಬದಲಾವಣೆ ಕಂಡುಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_10",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಬೇರ್ಪಡಿಸುವ ಪ್ರಕ್ರಿಯೆಯಲ್ಲಿ ಕೈಯಿಂದ ಆರಿಸುವಿಕೆಯು ಯಾವ ಉದ್ದೇಶವನ್ನು ಈಡೇರಿಸುತ್ತದೆ?",
            options = listOf("ಶೋಧಿಸುವಿಕೆ", "ವಿಂಗಡಣೆ", "ಆವೀಕರಣ", "ಬಸಿಯುವಿಕೆ"),
            correctAnswer = "ವಿಂಗಡಣೆ",
            explanation = "ಗಾತ್ರ, ಬಣ್ಣ ಅಥವಾ ಆಕಾರದ ಆಧಾರದ ಮೇಲೆ ವಸ್ತುಗಳನ್ನು ಕೈಯಿಂದ ಆರಿಸಿ ವಿಂಗಡಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_11",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮರಳು ಮತ್ತು ಮರದ ಪುಡಿಯ ಮಿಶ್ರಣವನ್ನು ಬೇರ್ಪಡಿಸಲು ಯಾವ ವಿಧಾನ ಸೂಕ್ತ?",
            options = listOf("ತೂರುವಿಕೆ", "ಜರಡಿ ಹಿಡಿಯುವಿಕೆ", "ಕೈಯಿಂದ ಆರಿಸುವಿಕೆ", "ಶೋಧಿಸುವಿಕೆ"),
            correctAnswer = "ಜರಡಿ ಹಿಡಿಯುವಿಕೆ",
            explanation = "ಕಣಗಳ ಗಾತ್ರದ ವ್ಯತ್ಯಾಸದಿಂದಾಗಿ ಜರಡಿ ಹಿಡಿಯುವ ವಿಧಾನ ಸೂಕ್ತವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_12",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಗುರುತ್ವ ಬಲದಿಂದ ಬೇರ್ಪಡಿಸುವ (ತಳಸೇರುವಿಕೆ) ವಿಧಾನದಲ್ಲಿ ಯಾವುದು ಕೆಳಭಾಗದಲ್ಲಿ ಸಂಗ್ರಹವಾಗುತ್ತದೆ?",
            options = listOf("ಭಾರವಾದ ಘಟಕ ಮೇಲ್ಭಾಗದಲ್ಲಿ", "ಹಗುರವಾದ ಘಟಕ ಕೆಳಭಾಗದಲ್ಲಿ", "ಭಾರವಾದ ಘಟಕ ಕೆಳಭಾಗದಲ್ಲಿ", "ಭಾರವಾದ ಘಟಕ ಕೆಳಭಾಗದಲ್ಲಿ ಸಂಗ್ರಹವಾಗುವುದಿಲ್ಲ"),
            correctAnswer = "ಭಾರವಾದ ಘಟಕ ಕೆಳಭಾಗದಲ್ಲಿ",
            explanation = "ಗುರುತ್ವದ ಕಾರಣದಿಂದ ಹೆಚ್ಚು ಸಾಂದ್ರತೆಯುಳ್ಳ ಭಾರವಾದ ಕಣಗಳು ಪಾತ್ರೆಯ ತಳದಲ್ಲಿ ಕೂರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_13",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಅಕ್ಕಿ ಮತ್ತು ಬೇಳೆಗಳಲ್ಲಿ ಧೂಳಿನಂತಹ ಹಗುರವಾದ ಅಶುದ್ಧಿಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು ಸೂಕ್ತ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಜರಡಿ ಹಿಡಿಯುವಿಕೆ", "ಗುರುತ್ವ ಬಲದಿಂದ ಬೇರ್ಪಡಿಸುವಿಕೆ", "ತೂರುವಿಕೆ", "ಶೋಧಿಸುವಿಕೆ"),
            correctAnswer = "ತೂರುವಿಕೆ",
            explanation = "ತೂರುವಿಕೆಯಿಂದ ಹಗುರವಾದ ಧೂಳಿನ ಕಣಗಳು ಗಾಳಿಗೆ ಪ್ರತ್ಯೇಕಗೊಳ್ಳುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_14",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಅಕ್ಕಿಯಿಂದ ಕಲ್ಲುಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು ಅತ್ಯಂತ ಸೂಕ್ತವಾದ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ತೂರುವುದ", "ಕೈಯಿಂದ ಆರಿಸುವುದ", "ಶೋಧಿಸುವಿಕೆ", "ಜರಡಿ ಹಿಡಿಯುವುದ"),
            correctAnswer = "ಕೈಯಿಂದ ಆರಿಸುವುದ",
            explanation = "ಕಲ್ಲುಗಳ ಸಂಖ್ಯೆ ಕಡಿಮೆ ಇದ್ದಾಗ ಕೈಯಿಂದ ಆರಿಸುವುದು ಸರಳ ಮತ್ತು ಸೂಕ್ತ ವಿಧಾನ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_15",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಚಹಾ ಪುಡಿಯನ್ನು ತಯಾರಾದ ಚಹಾದಿಂದ ಬೇರ್ಪಡಿಸಲು ಯಾವ ವಿಧಾನ ಸೂಕ್ತ?",
            options = listOf("ತೇಲಿಸುವಿಕೆ", "ಶೋಧಿಸುವಿಕೆ", "ಕೈಯಿಂದ ಆರಿಸುವಿಕೆ", "ಆವೀಕರಣ"),
            correctAnswer = "ಶೋಧಿಸುವಿಕೆ",
            explanation = "ಜರಡಿಯಂತಹ ಶೋಧಕವನ್ನು ಬಳಸಿ ಶೋಧಿಸುವಿಕೆ (Filtration) ಮಾಡಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_16",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸಮುದ್ರದ ನೀರಿನಿಂದ ಸಾಮಾನ್ಯ ಉಪ್ಪನ್ನು ಪಡೆಯಲು ಯಾವ ವಿಧಾನ ಬಳಸುತ್ತಾರೆ?",
            options = listOf("ಶೋಧಿಸುವಿಕೆ", "ಆವೀಕರಣ", "ಒಕ್ಕಣೆ", "ಜರಡಿ ಹಿಡಿಯುವಿಕೆ"),
            correctAnswer = "ಆವೀಕರಣ",
            explanation = "ಸೂರ್ಯನ ಶಾಖದಿಂದ ನೀರು ಆವಿಯಾದಾಗ (Evaporation) ಉಪ್ಪು ಮಡಿಗಳಲ್ಲಿ ಉಳಿಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u9_17",
            stdId = 6,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಹಿಟ್ಟಿನಲ್ಲಿರುವ ಸಣ್ಣ ತೌಡು ಅಥವಾ ಕಸವನ್ನು ಬೇರ್ಪಡಿಸಲು ಯಾವ ವಿಧಾನ ಬಳಸುತ್ತಾರೆ?",
            options = listOf("ತೂರುವುದ", "ಒಣಗಿಸುವುದ", "ಜರಡಿ ಹಿಡಿಯುವಿಕೆ", "ಆವೀಕರಣ"),
            correctAnswer = "ಜರಡಿ ಹಿಡಿಯುವಿಕೆ",
            explanation = "ಹಿಟ್ಟಿನ ಜರಡಿಯ ಮೂಲಕ ಸಣ್ಣ ಹಿಟ್ಟು ಕೆಳಗೆ ಬೀಳುತ್ತದೆ ಮತ್ತು ತೌಡು ಜರಡಿಯ ಮೇಲೆ ಉಳಿಯುತ್ತದೆ."
        ),

        // ==================== ಅಧ್ಯಾಯ 10: ಜೀವಿಗಳು — ಅವುಗಳ ಗುಣಗಳ ಅನ್ವೇಷಣೆ ====================
        QuestionModel(
            id = "s_6_sci_u10_1",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ನೀರಿನ ಮೇಲ್ಮೈಯಲ್ಲಿ ಕಂಡುಬರುವ ಅಥವಾ ಕೊಳದ ಸಸ್ಯಗಳಿಗೆ ಅಂಟಿಕೊಂಡಿರುವ ಹಸಿರು/ಬಿಳಿ ಜೆಲ್ಲಿಯಂತಹ ವಸ್ತು ಯಾವುದು?",
            options = listOf("ಪಾಚಿ", "ಸಾಪನ್", "ಪರಾಗ", "ಸಮುದ್ರಕಳೆ"),
            correctAnswer = "ಪಾಚಿ",
            explanation = "ಕೊಳ ಮತ್ತು ಜಲಾಶಯಗಳಲ್ಲಿ ಪಾಚಿ (Algae) ಪದರವಾಗಿ ಕಂಡುಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_2",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ಯಾವ ಹೇಳಿಕೆ ತಪ್ಪಾಗಿದೆ?",
            options = listOf(
                "ಜೀವಂತ ಮತ್ತು ನಿರ್ಜೀವ ವಸ್ತುಗಳು ಜೀವಕೋಶಗಳಿಂದ ಮಾಡಲ್ಪಟ್ಟಿವೆ",
                "ನಿರ್ಜೀವ ವಸ್ತುಗಳು ವಸ್ತುವಿನಿಂದ ಮಾಡಲ್ಪಟ್ಟಿವೆ",
                "ಜೀವಕೋಶವು ಜೀವಿಗಳ ರಚನಾತ್ಮಕ ಘಟಕವಾಗಿದೆ",
                "ಒಂದೇ ರೀತಿಯ ಜೀವಕೋಶಗಳು ಸೇರಿ ಅಂಗಾಂಶಗಳನ್ನು ರೂಪಿಸುತ್ತವೆ"
            ),
            correctAnswer = "ಜೀವಂತ ಮತ್ತು ನಿರ್ಜೀವ ವಸ್ತುಗಳು ಜೀವಕೋಶಗಳಿಂದ ಮಾಡಲ್ಪಟ್ಟಿವೆ",
            explanation = "ಜೀವಕೋಶಗಳು ಕೇವಲ ಜೀವಿಗಳಲ್ಲಿ ಮಾತ್ರ ಇರುತ್ತವೆ; ನಿರ್ಜೀವ ವಸ್ತುಗಳಲ್ಲಿ ಜೀವಕೋಶಗಳಿರುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_3",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಪ್ರಾಣಿಗಳು ಚಲಿಸುವುದೇಕೆ?",
            options = listOf("ಆಹಾರ ಹುಡುಕಲು", "ಆಶ್ರಯ ಹುಡುಕಲು", "ಶತ್ರುಗಳಿಂದ ತಪ್ಪಿಸಿಕೊಳ್ಳಲು", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಆಹಾರ, ರಕ್ಷಣೆ ಮತ್ತು ಸಂತಾನೋತ್ಪತ್ತಿಗಾಗಿ ಪ್ರಾಣಿಗಳು ಒಂದು ಸ್ಥಳದಿಂದ ಮತ್ತೊಂದು ಸ್ಥಳಕ್ಕೆ ಚಲಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_4",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬೀಜ ಮೊಳಕೆಯೊಡೆಯಲು ಸಸ್ಯಗಳಿಗೆ ಪ್ರಾಥಮಿಕವಾಗಿ ಏನು ಬೇಕು?",
            options = listOf("ಸೂರ್ಯನ ಬೆಳಕು", "ನೀರು ಮತ್ತು ಗಾಳಿ", "ಮಣ್ಣು ಮತ್ತು ಗಾಳಿ", "ಶಾಖ"),
            correctAnswer = "ನೀರು ಮತ್ತು ಗಾಳಿ",
            explanation = "ಬೀಜದ ಅಂಕುರಣಕ್ಕೆ ನೀರು (ತೇವಾಂಶ), ಗಾಳಿ (ಆಮ್ಲಜನಕ) ಮತ್ತು ಸೂಕ್ತ ಉಷ್ಣತೆ ಅತ್ಯಗತ್ಯ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_5",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಡ್ರಾಸೆರಾದಂತಹ ಕೀಟಾಹಾರಿ ಸಸ್ಯಗಳು ಕೀಟಗಳನ್ನು ಹೇಗೆ ಸೆರೆಹಿಡಿಯುತ್ತವೆ?",
            options = listOf("ವಿಸರ್ಜನೆಯಿಂದ", "ಚಲನೆಯಿಂದ", "ಬೆಳವಣಿಗೆಯಿಂದ", "ಉಸಿರಾಟದಿಂದ"),
            correctAnswer = "ಚಲನೆಯಿಂದ",
            explanation = "ಕೀಟಗಳು ಸ್ಪರ್ಶಿಸಿದಾಗ ಎಲೆಗಳ ರೋಮಗಳು ಚಲಿಸಿ ಕೀಟವನ್ನು ಬಂಧಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_6",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಯಾವ ಪ್ರಕ್ರಿಯೆಯ ಸಮಯದಲ್ಲಿ ಶಕ್ತಿ ಬಿಡುಗಡೆಯಾಗುತ್ತದೆ?",
            options = listOf("ಜೀರ್ಣಕ್ರಿಯೆ", "ವಿಸರ್ಜನೆ", "ಬೆಳವಣಿಗೆ", "ಉಸಿರಾಟ"),
            correctAnswer = "ಉಸಿರಾಟ",
            explanation = "ಕೋಶೀಯ ಉಸಿರಾಟದಲ್ಲಿ (Respiration) ಆಹಾರದ ಆಕ್ಸಿಡೀಕರಣದಿಂದ ಶಕ್ತಿ (ATP) ಬಿಡುಗಡೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_7",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಎಲ್ಲಾ ಜೀವಿಗಳಿಗೆ ಸಾಮಾನ್ಯವಾದ ಲಕ್ಷಣ ಯಾವುದು?",
            options = listOf("ಬೆಳವಣಿಗೆ", "ಸಂತಾನೋತ್ಪತ್ತಿ", "ಚಲನೆ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಬೆಳವಣಿಗೆ, ಸಂತಾನೋತ್ಪತ್ತಿ, ಉಸಿರಾಟ, ಚಲನೆ ಮತ್ತು ಪ್ರತಿಕ್ರಿಯೆಗಳು ಜೀವಿಗಳ ಮೂಲ ಲಕ್ಷಣಗಳು."
        ),
        QuestionModel(
            id = "s_6_sci_u10_8",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬೀಜವನ್ನು ಕತ್ತಲೆಯ ಸ್ಥಳದಲ್ಲಿ ತೇವಾಂಶವಿರುವ ಮಣ್ಣಿನಲ್ಲಿ ಇರಿಸಿದಾಗ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಮೊಳಕೆಯೊಡೆದು ಸಾಮಾನ್ಯವಾಗಿ ಬೆಳೆಯುತ್ತದೆ", "ಒಣಗುತ್ತದೆ", "ಮೊಳಕೆಯೊಡೆಯುತ್ತದೆ, ಆದರೆ ಚೆನ್ನಾಗಿ ಬೆಳೆಯುವುದಿಲ್ಲ", "ಮೊಳಕೆಯೊಡೆಯುವುದಿಲ್ಲ"),
            correctAnswer = "ಮೊಳಕೆಯೊಡೆದು ಸಾಮಾನ್ಯವಾಗಿ ಬೆಳೆಯುತ್ತದೆ",
            explanation = "ಬೀಜ ಮೊಳಕೆಯೊಡೆಯಲು ಸೂರ್ಯನ ಬೆಳಕು ಕಡ್ಡಾಯವಲ್ಲ; ತೇವಾಂಶ ಮತ್ತು ಗಾಳಿ ಇದ್ದರೆ ಮೊಳಕೆಯೊಡೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_9",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳು ಮತ್ತು ಪ್ರಾಣಿಗಳಿಗೆ ಸಂಬಂಧಿಸಿದ ಸರಿಯಾದ ಸಮಾನ ಹೇಳಿಕೆ ಯಾವುದು?",
            options = listOf("ಅವು ತಮ್ಮ ಆಹಾರವನ್ನು ತಾವೇ ತಯಾರಿಸುತ್ತವೆ", "ಶಕ್ತಿಗಾಗಿ ಸೂರ್ಯನ ಬೆಳಕು ಬೇಕು", "ಶಕ್ತಿ ಪಡೆಯಲು ಉಸಿರಾಡುತ್ತವೆ", "ಅವು ಒಂದೇ ಸ್ಥಳದಿಂದ ಮತ್ತೊಂದು ಸ್ಥಳಕ್ಕೆ ಚಲಿಸುತ್ತವೆ"),
            correctAnswer = "ಶಕ್ತಿ ಪಡೆಯಲು ಉಸಿರಾಡುತ್ತವೆ",
            explanation = "ಸಸ್ಯಗಳು ಮತ್ತು ಪ್ರಾಣಿಗಳೆರಡೂ ಶಕ್ತಿ ಬಿಡುಗಡೆಗಾಗಿ ಸತತವಾಗಿ ಉಸಿರಾಟ ನಡೆಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_10",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸೊಳ್ಳೆಯ ಲಾರ್ವಾಗಳು ನೀರಿನಲ್ಲಿ ವಾಸಿಸುವಾಗ ಹೇಗೆ ಉಸಿರಾಡುತ್ತವೆ?",
            options = listOf("ಮೇಲ್ಮೈಗೆ ಬರುವ ಮೂಲಕ", "ಕಿವಿರುಗಳ ಮೂಲಕ", "ಚರ್ಮದ ಮೂಲಕ", "ಶ್ವಾಸಕೋಶಗಳ ಮೂಲಕ"),
            correctAnswer = "ಮೇಲ್ಮೈಗೆ ಬರುವ ಮೂಲಕ",
            explanation = "ಸೊಳ್ಳೆಯ ಲಾರ್ವಾಗಳು ನೀರಿನ ಮೇಲ್ಮೈಗೆ ಬಂದು ತಮ್ಮ ಉಸಿರಾಟದ ನಳಿಕೆಯ ಮೂಲಕ ವಾತಾವರಣದ ಗಾಳಿಯನ್ನು ಪಡೆಯುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_11",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕಪ್ಪೆಯ ಜೀವನಚಕ್ರದಲ್ಲಿ ಬಾಲ ಮತ್ತು ಕಾಲುಗಳು ಎರಡೂ ಇರುವ ಹಂತ ಯಾವುದು?",
            options = listOf("ಮೊಟ್ಟೆ", "ಮರಿಕಪ್ಪೆ", "ಭ್ರೂಣ", "ಸಾಪನ್"),
            correctAnswer = "ಮರಿಕಪ್ಪೆ",
            explanation = "ರೂಪಾಂತರದ ಸಮಯದಲ್ಲಿ ಮರಿಕಪ್ಪೆಯು (Froglet/Tadpole with legs) ಬಾಲ ಮತ್ತು ಕಾಲುಗಳೆರಡನ್ನೂ ಹೊಂದಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_12",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ಬೆಳೆಯುವುದಿಲ್ಲ?",
            options = listOf("ಮರ", "ಪುಸ್ತಕ", "ಮರಿ", "ಚಿಟ್ಟೆ"),
            correctAnswer = "ಪುಸ್ತಕ",
            explanation = "ಪುಸ್ತಕವು ನಿರ್ಜೀವ ವಸ್ತುವಾಗಿದ್ದು ಅದರಲ್ಲಿ ಯಾವುದೇ ಬೆಳವಣಿಗೆ ಇರುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_13",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ವಿಸರ್ಜನೆಯ ಉತ್ಪನ್ನವಲ್ಲ?",
            options = listOf("ಇಂಗಾಲದ ಡೈಆಕ್ಸೈಡ್", "ಶಕ್ತಿ", "ಮೂತ್ರ", "ಬೆವರು"),
            correctAnswer = "ಶಕ್ತಿ",
            explanation = "ಶಕ್ತಿಯು ಜೈವಿಕ ಕ್ರಿಯೆಗಳಿಗೆ ಬಳಕೆಯಾಗುವ ಫಲಿತಾಂಶ; ವಿಸರ್ಜಕ ತ್ಯಾಜ್ಯವಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_14",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಹುರುಳಿ ಬೀಜಗಳ ಮೊಳಕೆಯೊಡೆಯಲು ಅಗತ್ಯವಿರುವ ಅನಿಲ ಯಾವುದು?",
            options = listOf("ಸಾರಜನಕ", "ಆಮ್ಲಜನಕ", "ನೀರಿನ ಆವಿ", "ಹೈಡ್ರೋಜನ್"),
            correctAnswer = "ಆಮ್ಲಜನಕ",
            explanation = "ಬೀಜದ ಉಸಿರಾಟಕ್ಕೆ ಆಮ್ಲಜನಕವು ಅತ್ಯಗತ್ಯವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_15",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ಜೀವಿಗಳ ಲಕ್ಷಣವಲ್ಲ?",
            options = listOf("ಬೆಳವಣಿಗೆ", "ಉಸಿರಾಟ", "ವಿಸರ್ಜನೆ", "ಕೋಶೀಯ ರಚನೆ ಇಲ್ಲದಿರುವುದು"),
            correctAnswer = "ಕೋಶೀಯ ರಚನೆ ಇಲ್ಲದಿರುವುದು",
            explanation = "ಎಲ್ಲಾ ಜೀವಿಗಳು ಜೀವಕೋಶಗಳಿಂದ ನಿರ್ಮಿತವಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u10_16",
            stdId = 6,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸಂಪೂರ್ಣವಾಗಿ ಬೆಳೆದ ಜೀವಿಯನ್ನು ಏನೆಂದು ಕರೆಯಲಾಗುತ್ತದೆ?",
            options = listOf("ಪ್ಯೂಪಾ", "ಲಾರ್ವಾ", "ವಯಸ್ಕ", "ನವಜಾತ"),
            correctAnswer = "ವಯಸ್ಕ",
            explanation = "ಬೆಳವಣಿಗೆಯ ಅಂತಿಮ ಹಂತವನ್ನು ಮುಟ್ಟಿದ ಪ್ರೌಢ ಜೀವಿಯನ್ನು ವಯಸ್ಕ (Adult) ಎನ್ನುತ್ತಾರೆ."
        ),

        // ==================== ಅಧ್ಯಾಯ 11: ನಿಸರ್ಗದ ಸಂಪತ್ತು ====================
        QuestionModel(
            id = "s_6_sci_u11_1",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಗಾಳಿಯಲ್ಲಿ ಅತಿ ಹೆಚ್ಚು ಪ್ರಮಾಣದಲ್ಲಿರುವ ಅನಿಲ ಯಾವುದು?",
            options = listOf("ಆಮ್ಲಜನಕ", "ನೈಟ್ರೋಜನ್", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್", "ಧೂಳು"),
            correctAnswer = "ನೈಟ್ರೋಜನ್",
            explanation = "ವಾತಾವರಣದಲ್ಲಿ ಸಾರಜನಕ (ನೈಟ್ರೋಜನ್) ಅನಿಲ ಸುಮಾರು 78% ರಷ್ಟಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_2",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಜೀವಿಗಳು ಉಸಿರಾಡುವಾಗ ಒಳತೆಗೆದುಕೊಳ್ಳುವ ಅನಿಲ ಯಾವುದು?",
            options = listOf("ಆಮ್ಲಜನಕ", "ಆರ್ಗನ್", "ನೈಟ್ರೋಜನ್", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್"),
            correctAnswer = "ಆಮ್ಲಜನಕ",
            explanation = "ಉಸಿರಾಟಕ್ಕೆ ಪ್ರಾಣಿಗಳು ಮತ್ತು ಸಸ್ಯಗಳು ಆಮ್ಲಜನಕವನ್ನು (Oxygen) ಬಳಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_3",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಗಾಳಿಯಂತ್ರದ (ವಿಂಡ್‌ಮಿಲ್) ಉಪಯೋಗ ಯಾವುದು?",
            options = listOf("ಹಿಟ್ಟಿನ ಗಿರಣಿಗಳನ್ನು ನಡೆಸಲು", "ಬಾವಿಯಿಂದ ನೀರನ್ನು ಮೇಲೆತ್ತಲು", "ವಿದ್ಯುತ್ ಉತ್ಪಾದಿಸಲು", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಗಾಳಿಯ ಶಕ್ತಿಯನ್ನು ಈ ಎಲ್ಲಾ ಉಪಯುಕ್ತ ಕಾರ್ಯಗಳಿಗೆ ಬಳಸಿಕೊಳ್ಳಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_4",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕಟ್ಟಡಗಳ ಮೇಲೆ ಬೀಳುವ ಮಳೆನೀರನ್ನು ಭವಿಷ್ಯದ ಬಳಕೆಗಾಗಿ ಸಂಗ್ರಹಿಸುವುದನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಮಳೆನೀರು ಕೊಯ್ಲು", "ನೀರು ಶುದ್ಧೀಕರಣ", "ನೀರಾವರಿ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ಮಳೆನೀರು ಕೊಯ್ಲು",
            explanation = "ಮಳೆನೀರಿನ ಸಂರಕ್ಷಣೆ ಮತ್ತು ಮರುಬಳಕೆಯ ವಿಧಾನವನ್ನು 'ಮಳೆನೀರು ಕೊಯ್ಲು' (Rainwater Harvesting) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_5",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭೂಮಿಗೆ ಬೆಳಕು ಮತ್ತು ಶಾಖ ನೀಡುವ ಪ್ರಮುಖ ನೈಸರ್ಗಿಕ ಮೂಲ ಯಾವುದು?",
            options = listOf("ವಿದ್ಯುತ್ ಬಲ್ಬ್", "ಸೂರ್ಯ", "ಚಂದ್ರ", "ನಕ್ಷತ್ರಗಳು"),
            correctAnswer = "ಸೂರ್ಯ",
            explanation = "ಸೂರ್ಯನು ಭೂಮಿಯ ಶಕ್ತಿಯ ಪ್ರಾಥಮಿಕ ಮತ್ತು ಅಕ್ಷಯ ಮೂಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_6",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ನವೀಕರಿಸಬಹುದಾದ ಸಂಪನ್ಮೂಲಕ್ಕೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಅಡುಗೆ ಅನಿಲ", "ಪೆಟ್ರೋಲ್", "ಅರಣ್ಯಗಳು", "ಕಲ್ಲಿದ್ದಲು"),
            correctAnswer = "ಅರಣ್ಯಗಳು",
            explanation = "ಮರಗಿಡಗಳು ಮತ್ತು ಅರಣ್ಯಗಳು ಸರಿಯಾಗಿ ನಿರ್ವಹಿಸಿದರೆ ಪುನರುತ್ಪತ್ತಿಯಾಗಬಲ್ಲ ನವೀಕರಿಸಬಹುದಾದ ಸಂಪನ್ಮೂಲಗಳು."
        ),
        QuestionModel(
            id = "s_6_sci_u11_7",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸೂರ್ಯ, ನೀರು ಮತ್ತು ಜೀವಿಗಳ ಕ್ರಿಯೆಗಳಿಂದ ದೀರ್ಘಕಾಲದಲ್ಲಿ ಬಂಡೆಗಳು ವಿಘಟನೆ ಹೊಂದಿ ಉಂಟಾಗುವ ಸಂಪನ್ಮೂಲ ಯಾವುದು?",
            options = listOf("ಪಳೆಯುಳಿಕೆ ಇಂಧನ", "ಸಿಹಿನೀರು", "ಖನಿಜ", "ಮಣ್ಣು"),
            correctAnswer = "ಮಣ್ಣು",
            explanation = "ಶಿಥಿಲೀಕರಣ ಕ್ರಿಯೆಯಿಂದ ಬಂಡೆಗಳು ಪುಡಿಯಾಗಿ ಫಲವತ್ತಾದ ಮಣ್ಣು (Soil) ರೂಪುಗೊಳ್ಳುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_8",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಮಳೆಯ ಪ್ರಮಾಣ ಕಡಿಮೆಯಾಗಲು ಪ್ರಮುಖ ಕಾರಣ ಯಾವುದು?",
            options = listOf("ಸೂರ್ಯನ ಶಾಖ", "ಅರಣ್ಯನಾಶ", "ಅಂತರ್ಜಲ ಹೆಚ್ಚಾಗಿರುವುದು", "ಜಲಮಾಲಿನ್ಯ"),
            correctAnswer = "ಅರಣ್ಯನಾಶ",
            explanation = "ಮರಗಳನ್ನು ಕಡಿಯುವುದರಿಂದ ಬಾಷ್ಪೋತ್ಸರ್ಜನ ಕಡಿಮೆಯಾಗಿ ಮಳೆಯ ಪ್ರಮಾಣ ಕುಸಿಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_9",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸೌರಶಕ್ತಿ ದೀಪಗಳು ಕಾರ್ಯನಿರ್ವಹಿಸಲು ಬಳಸುವ ಶಕ್ತಿ ಯಾವುದು?",
            options = listOf("ಸೂರ್ಯನ ಬೆಳಕು", "ಗಾಳಿಶಕ್ತಿ", "ಪರಮಾಣುಶಕ್ತಿ", "ಸೂರ್ಯನ ಶಾಖ ಮಾತ್ರ"),
            correctAnswer = "ಸೂರ್ಯನ ಬೆಳಕು",
            explanation = "ಸೌರ ಫಲಕಗಳು ಸೂರ್ಯನ ಬೆಳಕನ್ನು ವಿದ್ಯುಚ್ಛಕ್ತಿಯಾಗಿ ಪರಿವರ್ತಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_10",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಸಿಹಿನೀರಿನ ಮೂಲವಲ್ಲದದ್ದು ಯಾವುದು?",
            options = listOf("ನದಿ", "ಸರೋವರ", "ಸಮುದ್ರ", "ಬಾವಿ"),
            correctAnswer = "ಸಮುದ್ರ",
            explanation = "ಸಮುದ್ರದ ನೀರು ಉಪ್ಪಾಗಿರುತ್ತದೆ (ಲವಣಯುಕ್ತ); ಸಿಹಿನೀರಲ್ಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_11",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲವಲ್ಲ?",
            options = listOf("ಮನೆ", "ಮಣ್ಣು", "ಸಸ್ಯಗಳು", "ಕಾಡುಗಳು ಮತ್ತು ಸಸ್ಯಗಳು"),
            correctAnswer = "ಮನೆ",
            explanation = "ಮನೆ ಮಾನವ ನಿರ್ಮಿತ ಆಶ್ರಯವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_12",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಗಾಳಿಯ ವೇಗವನ್ನು ಬಳಸಿ ವಿದ್ಯುತ್ ಉತ್ಪಾದಿಸುವ ಯಂತ್ರ ಯಾವುದು?",
            options = listOf("ಜಲವಿದ್ಯುತ್ ಸ್ಥಾವರ", "ಅಣುವಿದ್ಯುತ್ ಸ್ಥಾವರ", "ಸೌರಫಲಕ", "ಪವನಯಂತ್ರ"),
            correctAnswer = "ಪವನಯಂತ್ರ",
            explanation = "ಪವನಯಂತ್ರವು (Wind turbine) ಗಾಳಿ ಶಕ್ತಿಯನ್ನು ವಿದ್ಯುತ್ ಶಕ್ತಿಯಾಗಿ ಪರಿವರ್ತಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_13",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಮೇಲಿನ ಅತ್ಯಂತ ಅಮೂಲ್ಯವಾದ ದ್ರವ ಸಂಪನ್ಮೂಲ ಯಾವುದು?",
            options = listOf("ನೀರು", "ಡೀಸೆಲ್", "ಪೆಟ್ರೋಲಿಯಂ", "ಹಾಲು"),
            correctAnswer = "ನೀರು",
            explanation = "ನೀರು ಸಮಸ್ತ ಜೀವರಾಶಿಗಳ ಉಳಿವಿಗೆ ಅತ್ಯಂತ ಅಗತ್ಯವಾದ ಅಮೂಲ್ಯ ದ್ರವ ಸಂಪನ್ಮೂಲ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_14",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಮಣ್ಣಿನ ಸವೆತವನ್ನು ತಡೆಯಲು ಅತ್ಯಂತ ಸೂಕ್ತವಾದ ಮಾರ್ಗ ಯಾವುದು?",
            options = listOf("ಹೆಚ್ಚು ಮರಗಳನ್ನು ನೆಡುವುದು", "ಮರಗಳನ್ನು ಕಡಿಯುವುದು", "ರಾಸಾಯನಿಕಗಳ ಬಳಕೆ", "ಅತಿಯಾಗಿ ಜಾನುವಾರುಗಳನ್ನು ಮೇಯಿಸುವುದು"),
            correctAnswer = "ಹೆಚ್ಚು ಮರಗಳನ್ನು ನೆಡುವುದು",
            explanation = "ಸಸ್ಯಗಳ ಬೇರುಗಳು ಮಣ್ಣನ್ನು ಭದ್ರವಾಗಿ ಹಿಡಿದಿಟ್ಟು ಮಣ್ಣಿನ ಸವೆತವನ್ನು ತಡೆಯುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u11_15",
            stdId = 6,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "“ಕಪ್ಪು ಚಿನ್ನ” (Black Gold) ಎಂದು ಕರೆಯಲ್ಪಡುವ ಸಂಪನ್ಮೂಲ ಯಾವುದು?",
            options = listOf("ಕಪ್ಪು ಮಣ್ಣು", "ಕಬ್ಬಿಣ", "ಪೆಟ್ರೋಲಿಯಂ", "ಕಲ್ಲಿದ್ದಲು"),
            correctAnswer = "ಪೆಟ್ರೋಲಿಯಂ",
            explanation = "ವಾಣಿಜ್ಯಿಕವಾಗಿ ಅತ್ಯಂತ ಮೌಲ್ಯಯುತವಾಗಿರುವ ಕಚ್ಚಾ ತೈಲ ಮತ್ತು ಪೆಟ್ರೋಲಿಯಂ ಅನ್ನು ಕಪ್ಪು ಚಿನ್ನ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),

        // ==================== ಅಧ್ಯಾಯ 12: ಭೂಮಿಯಿಂದ ಆಚೆ ====================
        QuestionModel(
            id = "s_6_sci_u12_1",
            stdId = 6,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಧ್ರುವ ನಕ್ಷತ್ರಕ್ಕೆ (ಪೋಲಾರಿಸ್) ಸಂಬಂಧಿಸಿದಂತೆ ಸರಿಯಾದ ಹೇಳಿಕೆ ಯಾವುದು?",
            options = listOf(
                "ಉತ್ತರ ದಿಕ್ಕಿನಲ್ಲಿ ಸ್ಥಿರವಾಗಿರುವಂತೆ ಕಾಣುತ್ತದೆ",
                "ಉತ್ತರ ದಿಕ್ಕನ್ನು ಗುರುತಿಸಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ",
                "ಧ್ರುವ ನಕ್ಷತ್ರವು ಲಿಟಲ್ ಡಿಪ್ಪರ್ ನಕ್ಷತ್ರಪುಂಜದಲ್ಲಿದೆ",
                "ಮೇಲಿನ ಎಲ್ಲವೂ"
            ),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಧ್ರುವ ನಕ್ಷತ್ರವು ಭೂಮಿಯ ಅಕ್ಷದ ನೇರಕ್ಕಿರುವುದರಿಂದ ಆಕಾಶದಲ್ಲಿ ಉತ್ತರ ದಿಕ್ಕಿನಲ್ಲಿ ಸ್ಥಿರವಾಗಿ ಗೋಚರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u12_2",
            stdId = 6,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ರಾತ್ರಿ ಆಕಾಶ ವೀಕ್ಷಣೆಗೆ ಅಡಚಣೆಯಾಗುವ ಅನಪೇಕ್ಷಣೀಯ ಅಂಶಗಳು ಯಾವುವು?",
            options = listOf(
                "ಬೆಳಕಿನ ಮಾಲಿನ್ಯ",
                "ಹೊಗೆ ಮತ್ತು ಧೂಳು",
                "ವೀಕ್ಷಣಾ ಸ್ಥಳವನ್ನು ಎತ್ತರದ ಕಟ್ಟಡಗಳು ಮತ್ತು ಮರಗಳು ಸುತ್ತುವರಿದಿರುವುದು",
                "ಮೇಲಿನ ಎಲ್ಲವೂ"
            ),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ನಗರದ ಕೃತಕ ಬೆಳಕು, ವಾಯುಮಾಲಿನ್ಯ ಮತ್ತು ಕಟ್ಟಡಗಳ ಅಡಚಣೆಗಳು ಆಕಾಶ ವೀಕ್ಷಣೆಗೆ ತೊಂದರೆ ಉಂಟುಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u12_3",
            stdId = 6,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಬರಿಗಣ್ಣಿಗೆ ಗೋಚರಿಸುವ ಗ್ರಹಗಳ ಗುಂಪು ಯಾವುದು?",
            options = listOf(
                "ಬುಧ, ಶುಕ್ರ, ಮಂಗಳ, ಗುರು, ಶನಿ",
                "ಗುರು, ಶನಿ, ಯುರೇನಸ್, ಭೂಮಿ, ನೆಪ್ಚೂನ್",
                "ಬುಧ, ಶುಕ್ರ, ಭೂಮಿ, ಮಂಗಳ, ಗುರು",
                "ಯುರೇನಸ್, ನೆಪ್ಚೂನ್, ಸೂರ್ಯ, ಚಂದ್ರ"
            ),
            correctAnswer = "ಬುಧ, ಶುಕ್ರ, ಮಂಗಳ, ಗುರು, ಶನಿ",
            explanation = "ಟೆಲಿಸ್ಕೋಪ್ ಇಲ್ಲದೆ ಬರಿಗಣ್ಣಿನಿಂದ ಐದು ಗ್ರಹಗಳನ್ನು (Mercury, Venus, Mars, Jupiter, Saturn) ನೋಡಬಹುದು."
        ),
        QuestionModel(
            id = "s_6_sci_u12_4",
            stdId = 6,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ನಮ್ಮ ಸೌರವ್ಯೂಹದ ಸದಸ್ಯವಲ್ಲದದ್ದು ಯಾವುದು?",
            options = listOf("ಸಿರಿಯಸ್", "ಧೂಮಕೇತುಗಳು", "ಕ್ಷುದ್ರಗ್ರಹಗಳು", "ನೆಪ್ಚೂನ್"),
            correctAnswer = "ಸಿರಿಯಸ್",
            explanation = "ಸಿರಿಯಸ್ ಸೌರವ್ಯೂಹದಿಂದಾಚೆಗಿರುವ ಪ್ರಕಾಶಮಾನವಾದ ನಕ್ಷತ್ರ (ಲುಬ್ಧಕ)."
        ),
        QuestionModel(
            id = "s_6_sci_u12_5",
            stdId = 6,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ಸೂರ್ಯನ ಗ್ರಹವಲ್ಲ (ಕುಬ್ಜಗ್ರಹ)?",
            options = listOf("ಗುರು", "ಪ್ಲುಟೊ", "ನೆಪ್ಚೂನ್", "ಶನಿ"),
            correctAnswer = "ಪ್ಲುಟೊ",
            explanation = "2006 ರ ನಂತರ ಪ್ಲುಟೊವನ್ನು ಕುಬ್ಜಗ್ರಹ (Dwarf planet) ಎಂದು ವರ್ಗೀಕರಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u12_6",
            stdId = 6,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಸೌರವ್ಯೂಹದ ಕೇಂದ್ರದಲ್ಲಿರುವ ನಕ್ಷತ್ರ ಯಾವುದು?",
            options = listOf("ಭೂಮಿ", "ಚಂದ್ರ", "ಸೂರ್ಯ", "ಮಂಗಳ"),
            correctAnswer = "ಸೂರ್ಯ",
            explanation = "ಸೂರ್ಯನು ಸೌರವ್ಯೂಹದ ಕೇಂದ್ರದಲ್ಲಿರುವ ದೈತ್ಯ ನಕ್ಷತ್ರ."
        ),
        QuestionModel(
            id = "s_6_sci_u12_7",
            stdId = 6,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಕೆಂಪು ಗ್ರಹ (Red Planet) ಎಂದು ಕರೆಯಲ್ಪಡುವ ಗ್ರಹ ಯಾವುದು?",
            options = listOf("ಬುಧ", "ಶುಕ್ರ", "ಮಂಗಳ", "ಗುರು"),
            correctAnswer = "ಮಂಗಳ",
            explanation = "ಮಂಗಳ ಗ್ರಹದ ಮೇಲ್ಮೈಯಲ್ಲಿ ಕಬ್ಬಿಣದ ಆಕ್ಸೈಡ್ (ತುಕ್ಕು) ಇರುವುದರಿಂದ ಅದು ಕೆಂಪಾಗಿ ಕಾಣುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_6_sci_u12_8",
            stdId = 6,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಸೌರವ್ಯೂಹದ ಅತಿ ದೊಡ್ಡ ಗ್ರಹ ಯಾವುದು?",
            options = listOf("ಭೂಮಿ", "ಗುರು", "ಶನಿ", "ನೆಪ್ಚೂನ್"),
            correctAnswer = "ಗುರು",
            explanation = "ಗುರು ಗ್ರಹವು (Jupiter) ಸೌರವ್ಯೂಹದ ಅತ್ಯಂತ ಬೃಹತ್ ಗ್ರಹವಾಗಿದೆ."
        )
    )
}
