package com.example.data

/**
 * Standard 7 Science (Kannada Medium - LBA Revised 2026-27)
 * Comprehensive official Question Bank containing all 12 units:
 * Unit 1: ನಿರಂತರವಾಗಿ ಬದಲಾಗುತ್ತಿರುವ ವಿಜ್ಞಾನದ ಜಗತ್ತು
 * Unit 2: ವಸ್ತುಗಳ ಅನ್ವೇಷಣೆ: ಆಮ್ಲೀಯ, ಪ್ರತ್ಯಾಮ್ಲೀಯ ಮತ್ತು ತಟಸ್ಥ
 * Unit 3: ವಿದ್ಯುತ್ ಕ್ಷೇಮ: ಮಂಡಲಗಳು ಮತ್ತು ಅದರ ಘಟಕಗಳು
 * Unit 4: ಲೋಹಗಳು ಮತ್ತು ಅಲೋಹಗಳ ಜಗತ್ತು
 * Unit 5: ನಮ್ಮ ಸುತ್ತಲಿನ ಬದಲಾವಣೆಗಳು: ಭೌತ ಮತ್ತು ರಾಸಾಯನಿಕ
 * Unit 6: ಹದಿಹರೆಯ: ಬೆಳವಣಿಗೆ ಮತ್ತು ಬದಲಾವಣೆಯ ಒಂದು ಹಂತ
 */
object Std7SciencePart1QuestionBank {

    val questions: List<QuestionModel> = listOf(
        // ==================== ಘಟಕ 1: ನಿರಂತರವಾಗಿ ಬದಲಾಗುತ್ತಿರುವ ವಿಜ್ಞಾನದ ಜಗತ್ತು ====================
        QuestionModel(
            id = "s_7_sci_u1_1",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಹೊಸ ಪುರಾವೆಗಳು ಮತ್ತು ಸಾಕ್ಷ್ಯಗಳು ದೊರೆತಂತೆ ವೈಜ್ಞಾನಿಕ ಜ್ಞಾನವು ನಿರಂತರವಾಗಿ ______ ಒಳಪಡುತ್ತದೆ.",
            options = listOf("ಸ್ಥಿರತೆಗೆ", "ಬದಲಾವಣೆ/ಪರಿಷ್ಕರಣೆಗೆ", "ನಾಶಕ್ಕೆ", "ವಿರಾಮಕ್ಕೆ"),
            correctAnswer = "ಬದಲಾವಣೆ/ಪರಿಷ್ಕರಣೆಗೆ",
            explanation = "ವೈಜ್ಞಾನಿಕ ಜ್ಞಾನವು ಸ್ಥಿರವಲ್ಲ, ಹೊಸ ಪುರಾವೆಗಳು ದೊರೆತಂತೆ ನಿರಂತರವಾಗಿ ಬದಲಾವಣೆ ಮತ್ತು ಪರಿಷ್ಕರಣೆಗೆ ಒಳಗಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u1_2",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಯಾವುದೇ ಒಂದು ವಿದ್ಯಮಾನವನ್ನು ಸೂಕ್ಷ್ಮವಾಗಿ ಗಮನಿಸುವುದನ್ನು ವೈಜ್ಞಾನಿಕ ವಿಧಾನದಲ್ಲಿ ______ ಎನ್ನಲಾಗುತ್ತದೆ.",
            options = listOf("ತೀರ್ಮಾನ", "ಪ್ರಯೋಗ", "ವೀಕ್ಷಣೆ (Observation)", "ತಂತ್ರಜ್ಞಾನ"),
            correctAnswer = "ವೀಕ್ಷಣೆ (Observation)",
            explanation = "ವೈಜ್ಞಾನಿಕ ವಿಧಾನದ ಮೊದಲ ಮತ್ತು ಪ್ರಮುಖ ಹಂತ ವೀಕ್ಷಣೆ (Observation)."
        ),
        QuestionModel(
            id = "s_7_sci_u1_3",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನದ ತತ್ವಗಳನ್ನು ಬಳಸಿಕೊಂಡು ಮಾನವನ ಸೌಕರ್ಯಕ್ಕಾಗಿ ಹೊಸ ಸಾಧನಗಳನ್ನು ನಿರ್ಮಿಸುವುದನ್ನು ______ ಎನ್ನಬಹುದು.",
            options = listOf("ವೀಕ್ಷಣೆ", "ತಂತ್ರಜ್ಞಾನ (Technology)", "ಪರಿಕಲ್ಪನೆ", "ಅನ್ವೇಷಣೆ"),
            correctAnswer = "ತಂತ್ರಜ್ಞಾನ (Technology)",
            explanation = "ವಿಜ್ಞಾನದ ಪ್ರಾಯೋಗಿಕ ಅನ್ವಯವೇ ತಂತ್ರಜ್ಞಾನ (Technology)."
        ),
        QuestionModel(
            id = "s_7_sci_u1_4",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪ್ರಯೋಗಗಳ ಮೂಲಕ ತಾತ್ಕಾಲಿಕ ಕಲ್ಪನೆಯನ್ನು ಪರೀಕ್ಷಿಸಿದ ನಂತರ ಹೊರಬರುವ ಫಲಿತಾಂಶವೇ ______ ಆಗಿದೆ.",
            options = listOf("ವೀಕ್ಷಣೆ", "ಪರಿಕಲ್ಪನೆ", "ತೀರ್ಮಾನ (Conclusion)", "ಪ್ರಶ್ನೆ"),
            correctAnswer = "ತೀರ್ಮಾನ (Conclusion)",
            explanation = "ಪ್ರಯೋಗ ಮತ್ತು ವಿಶ್ಲೇಷಣೆಯ ನಂತರ ತಲುಪುವ ಅಂತಿಮ ಫಲಿತಾಂಶವೇ ತೀರ್ಮಾನ."
        ),
        QuestionModel(
            id = "s_7_sci_u1_5",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನವು ಕೇವಲ ಮಾಹಿತಿಯ ಸಂಗ್ರಹವಲ್ಲ, ಅದೊಂದು ನಿರಂತರವಾಗಿ ನಡೆಯುವ ______.",
            options = listOf("ಪಟ್ಟಿ", "ಪ್ರಕ್ರಿಯೆ (Process)", "ನಿಯಮ", "ಸಿದ್ಧಾಂತ"),
            correctAnswer = "ಪ್ರಕ್ರಿಯೆ (Process)",
            explanation = "ವಿಜ್ಞಾನವು ಸತ್ಯಾನ್ವೇಷಣೆಯ ನಿರಂತರ ಪ್ರಕ್ರಿಯೆಯಾಗಿದೆ (Dynamic process)."
        ),
        QuestionModel(
            id = "s_7_sci_u1_6",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸತ್ಯವನ್ನು ಕಂಡುಕೊಳ್ಳಲು ಪರೀಕ್ಷಿಸಬಹುದಾದ ಊಹೆಗಳನ್ನು ಮಾಡುವುದು ಮತ್ತು ಪ್ರಯೋಗಗಳನ್ನು ನಡೆಸುವುದು ______ ಯ ಮುಖ್ಯ ಲಕ್ಷಣವಾಗಿದೆ.",
            options = listOf("ವೈಜ್ಞಾನಿಕ ವಿಧಾನ (Scientific Method)", "ಮೂಢನಂಬಿಕೆ", "ವೈಯಕ್ತಿಕ ನಂಬಿಕೆ", "ಸಂಪ್ರದಾಯ"),
            correctAnswer = "ವೈಜ್ಞಾನಿಕ ವಿಧಾನ (Scientific Method)",
            explanation = "ಊಹೆ, ಪ್ರಯೋಗ, ವಿಶ್ಲೇಷಣೆ ವೈಜ್ಞಾನಿಕ ವಿಧಾನದ ಲಕ್ಷಣಗಳು."
        ),
        QuestionModel(
            id = "s_7_sci_u1_7",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪ್ರಕೃತಿಯಲ್ಲಿ ಕಂಡುಬರುವ ವಿವಿಧ ವಿದ್ಯಮಾನಗಳನ್ನು ವೀಕ್ಷಿಸಿ ಪ್ರಶ್ನಿಸುವುದು ವೈಜ್ಞಾನಿಕ ______ ಯ ಮೊದಲ ಹಂತವಾಗಿದೆ.",
            options = listOf("ತೀರ್ಮಾನ", "ಅನ್ವೇಷಣೆ (Inquiry)", "ತಂತ್ರಜ್ಞಾನ", "ಸಿದ್ಧಾಂತ"),
            correctAnswer = "ಅನ್ವೇಷಣೆ (Inquiry)",
            explanation = "ಪ್ರಶ್ನಿಸುವುದು ಮತ್ತು ವೀಕ್ಷಿಸುವುದು ಅನ್ವೇಷಣೆಯ ಅಡಿಪಾಯ."
        ),
        QuestionModel(
            id = "s_7_sci_u1_8",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಹೊಸ ಸಾಕ್ಷ್ಯಗಳು ಮತ್ತು ಆವಿಷ್ಕಾರಗಳು ದೊರೆತಾಗ ಹಳೆಯ ವೈಜ್ಞಾನಿಕ ಸಿದ್ಧಾಂತಗಳು ______ಗೊಳ್ಳುತ್ತವೆ.",
            options = listOf("ಸ್ಥಿರ", "ಬದಲಾವಣೆ/ಪರಿಷ್ಕರಣೆಗೆ ಒಳಗಾಗುತ್ತವೆ", "ನಾಶ", "ಅಂತಿಮ"),
            correctAnswer = "ಬದಲಾವಣೆ/ಪರಿಷ್ಕರಣೆಗೆ ಒಳಗಾಗುತ್ತವೆ",
            explanation = "ಹೊಸ ಆವಿಷ್ಕಾರಗಳು ಹಳೆಯ ಸಿದ್ಧಾಂತಗಳನ್ನು ಸುಧಾರಿಸುತ್ತವೆ ಅಥವಾ ಪರಿಷ್ಕರಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u1_9",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಯಾವುದೇ ಒಂದು ವಿಷಯವನ್ನು ಮೂಲ ಸಾಕ್ಷ್ಯಾಧಾರಗಳಿಲ್ಲದೆ ಒಪ್ಪಿಕೊಳ್ಳದೆ, ಪ್ರಶ್ನಿಸಿ ಸತ್ಯಾಸತ್ಯತೆಯನ್ನು ತಿಳಿಯುವುದನ್ನು ______ ಎನ್ನಲಾಗುತ್ತದೆ.",
            options = listOf("ವೈಯಕ್ತಿಕ ಮನೋಭಾವ", "ವೈಜ್ಞಾನಿಕ ಮನೋಭಾವ (Scientific Temper)", "ಭಾವನಾತ್ಮಕ ಮನೋಭಾವ", "ಸಾಂಪ್ರದಾಯಿಕ ಮನೋಭಾವ"),
            correctAnswer = "ವೈಜ್ಞಾನಿಕ ಮನೋಭಾವ (Scientific Temper)",
            explanation = "ಪುರಾವೆ ಆಧಾರಿತ ತಾರ್ಕಿಕ ಚಿಂತನೆಯೇ ವೈಜ್ಞಾನಿಕ ಮನೋಭಾವ."
        ),
        QuestionModel(
            id = "s_7_sci_u1_10",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ವೈಜ್ಞಾನಿಕ ವಿಧಾನದ ಸರಿಯಾದ ಕ್ರಮವಾಗಿದೆ?",
            options = listOf(
                "ತೀರ್ಮಾನ → ಪ್ರಯೋಗ → ವೀಕ್ಷಣೆ",
                "ವೀಕ್ಷಣೆ → ಕಲ್ಪನೆ → ಪ್ರಯೋಗ → ತೀರ್ಮಾನ",
                "ಕಲ್ಪನೆ → ತೀರ್ಮಾನ → ವೀಕ್ಷಣೆ → ಪ್ರಯೋಗ",
                "ಪ್ರಯೋಗ → ವೀಕ್ಷಣೆ → ತೀರ್ಮಾನ → ಕಲ್ಪನೆ"
            ),
            correctAnswer = "ವೀಕ್ಷಣೆ → ಕಲ್ಪನೆ → ಪ್ರಯೋಗ → ತೀರ್ಮಾನ",
            explanation = "Observation -> Hypothesis -> Experiment -> Conclusion ಕ್ರಮಬದ್ಧ ಹಂತಗಳು."
        ),
        QuestionModel(
            id = "s_7_sci_u1_11",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನದಲ್ಲಿ ಒಂದು ಸಿದ್ಧಾಂತ ಅಥವಾ ನಿಯಮವು ಯಾವಾಗ ಬದಲಾಗುತ್ತದೆ?",
            options = listOf("ಸಮಾಜವು ಒಪ್ಪದಿದ್ದಾಗ", "ಹೊಸ ಮತ್ತು ಹೆಚ್ಚು ನಿಖರವಾದ ಸಾಕ್ಷ್ಯಗಳು ದೊರೆತಾಗ", "ವಿಜ್ಞಾನಿಗಳು ಬಯಸಿದಾಗ", "ಹಳೆಯ ಪುಸ್ತಕಗಳು ಮುಗಿದಾಗ"),
            correctAnswer = "ಹೊಸ ಮತ್ತು ಹೆಚ್ಚು ನಿಖರವಾದ ಸಾಕ್ಷ್ಯಗಳು ದೊರೆತಾಗ",
            explanation = "ಹೆಚ್ಚು ನಿಖರ ವೈಜ್ಞಾನಿಕ ಸಾಕ್ಷ್ಯಾಧಾರಗಳು ಸಿಕ್ಕಾಗ ನಿಯಮಗಳು ಮಾರ್ಪಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u1_12",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಹವಾಮಾನ ಮುನ್ಸೂಚನೆ ಮತ್ತು ದೂರಸಂಪರ್ಕ ವ್ಯವಸ್ಥೆಯಲ್ಲಿ ಕ್ರಾಂತಿಕಾರಿ ಬದಲಾವಣೆ ತಂದ ತಂತ್ರಜ್ಞಾನ ಯಾವುದು?",
            options = listOf("ಉಗಿ ಎಂಜಿನ್", "ಕೃತಕ ಉಪಗ್ರಹಗಳು (Satellites)", "ಸೂಕ್ಷ್ಮದರ್ಶಕ", "ಉಷ್ಣಮಾಪಕ"),
            correctAnswer = "ಕೃತಕ ಉಪಗ್ರಹಗಳು (Satellites)",
            explanation = "ಕೃತಕ ಉಪಗ್ರಹಗಳು ಜಾಗತಿಕ ಹವಾಮಾನ ಮತ್ತು ದೂರಸಂಪರ್ಕವನ್ನು ಬದಲಾಯಿಸಿವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u1_13",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನ ಎಂದರೆ:",
            options = listOf(
                "ಕೇವಲ ಸತ್ಯಗಳ ಮತ್ತು ಮಾಹಿತಿಯ ಸಂಗ್ರಹ",
                "ನಿರಂತರವಾಗಿ ಕಲಿಯುವ ಮತ್ತು ಅನ್ವೇಷಿಸುವ ಪ್ರಕ್ರಿಯೆ",
                "ನೆನಪಿನಲ್ಲಿ ಇಡಬೇಕಾದ ನಿಯಮಗಳ ಪಟ್ಟಿ",
                "ಬದಲಾವಣೆಯಾಗದ ಅಂತಿಮ ಸತ್ಯ"
            ),
            correctAnswer = "ನಿರಂತರವಾಗಿ ಕಲಿಯುವ ಮತ್ತು ಅನ್ವೇಷಿಸುವ ಪ್ರಕ್ರಿಯೆ",
            explanation = "ವಿಜ್ಞಾನವು ಕ್ರಿಯಾತ್ಮಕ ಅನ್ವೇಷಣೆಯ ನಿರಂತರ ಹಾದಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u1_14",
            stdId = 7,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿಜ್ಞಾನದ ಬೆಳವಣಿಗೆಯ ಮುಖ್ಯ ಉದ್ದೇಶವೇನು?",
            options = listOf(
                "ಪರೀಕ್ಷೆಗಳಲ್ಲಿ ಅಂಕ ಗಳಿಸುವುದು",
                "ಪ್ರಕೃತಿಯ ನಿಯಮಗಳನ್ನು ಅರ್ಥಮಾಡಿಕೊಂಡು ಮಾನವ ಜೀವನ ಮತ್ತು ಜಗತ್ತನ್ನು ಉತ್ತಮಪಡಿಸುವುದು",
                "ಹಳೆಯ ಪುಸ್ತಕಗಳನ್ನು ಕಂಠಪಾಠ ಮಾಡುವುದು",
                "ಹೊಸ ನಿಯಮಗಳನ್ನು ಹೇರುವುದು"
            ),
            correctAnswer = "ಪ್ರಕೃತಿಯ ನಿಯಮಗಳನ್ನು ಅರ್ಥಮಾಡಿಕೊಂಡು ಮಾನವ ಜೀವನ ಮತ್ತು ಜಗತ್ತನ್ನು ಉತ್ತಮಪಡಿಸುವುದು",
            explanation = "ಪ್ರಕೃತಿಯನ್ನು ಅರಿತು ಮಾನವ ಜೀವನ ಮತ್ತು ಪರಿಸರವನ್ನು ಸುಧಾರಿಸುವುದು ವಿಜ್ಞಾನದ ಗುರಿ."
        ),

        // ==================== ಘಟಕ 2: ವಸ್ತುಗಳ ಅನ್ವೇಷಣೆ: ಆಮ್ಲೀಯ, ಪ್ರತ್ಯಾಮ್ಲೀಯ ಮತ್ತು ತಟಸ್ಥ ====================
        QuestionModel(
            id = "s_7_sci_u2_1",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ಯಾವ ದ್ರಾವಣದಲ್ಲಿ ನೀಲಿ ಲಿಟ್ಮಸ್ ಕಾಗದವು ಕೆಂಪು ಬಣ್ಣಕ್ಕೆ ತಿರುಗುತ್ತದೆ?",
            options = listOf("ಸೋಡಿಯಂ ಬೈಕಾರ್ಬೋನೇಟ್ ದ್ರಾವಣ", "ಕ್ಯಾಲ್ಸಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್ ದ್ರಾವಣ", "ಪೊಟ್ಯಾಸಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್ ದ್ರಾವಣ", "ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲ",
            explanation = "ಆಮ್ಲಗಳು ನೀಲಿ ಲಿಟ್ಮಸ್ ಅನ್ನು ಕೆಂಪು ಬಣ್ಣಕ್ಕೆ ತಿರುಗಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u2_2",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಲಿಟ್ಮಸ್ ಕಾಗದವನ್ನು ಕೆಳಗಿನ ಯಾವ ನೈಸರ್ಗಿಕ ವಸ್ತುವಿನಿಂದ ಪಡೆಯಲಾಗುತ್ತದೆ?",
            options = listOf("ಲೈಕನ್ (ಕಲ್ಲುಹೂವು)", "ಸೇವಂತಿಗೆ ಹೂ", "ಚಂಡುಹೂ", "ಕಮಲದ ಹೂ"),
            correctAnswer = "ಲೈಕನ್ (ಕಲ್ಲುಹೂವು)",
            explanation = "ಲಿಟ್ಮಸ್ ಒಂದು ನೈಸರ್ಗಿಕ ಸೂಚಕವಾಗಿದ್ದು, ಲೈಕನ್ (ಕಲ್ಲುಹೂವು) ಸಸ್ಯದಿಂದ ಪಡೆಯಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u2_3",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಪ್ರತ್ಯಾಮ್ಲದ ರುಚಿಯು ಹೇಗಿರುತ್ತದೆ?",
            options = listOf("ಹುಳಿ", "ಕಹಿ ಮತ್ತು ಜಾರುವ ಸ್ವಭಾವ", "ಸಿಹಿ", "ಉಪ್ಪು"),
            correctAnswer = "ಕಹಿ ಮತ್ತು ಜಾರುವ ಸ್ವಭಾವ",
            explanation = "ಪ್ರತ್ಯಾಮ್ಲಗಳು ಕಹಿ ರುಚಿ ಮತ್ತು ಸ್ಪರ್ಶಿಸಿದಾಗ ಜಾರುವ (soapy) ಗುಣ ಹೊಂದಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u2_4",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ರಾಸಾಯನಿಕ (ಸಂಶ್ಲೇಷಿತ) ಸೂಚಕ ಯಾವುದು?",
            options = listOf("ಅರಿಶಿಣ", "ಲಿಟ್ಮಸ್ ಕಾಗದ", "ಫಿನಾಫ್ತಲೀನ್", "ದಾಸವಾಳದ ದಳ"),
            correctAnswer = "ಫಿನಾಫ್ತಲೀನ್",
            explanation = "ಫಿನಾಫ್ತಲೀನ್ ಪ್ರಯೋಗಶಾಲೆಯಲ್ಲಿ ಬಳಸುವ ಸಂಶ್ಲೇಷಿತ ರಾಸಾಯನಿಕ ಸೂಚಕ."
        ),
        QuestionModel(
            id = "s_7_sci_u2_5",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಅಸಿಟಿಕ್ ಆಮ್ಲವನ್ನು ಹೊಂದಿರುವ ಸಾಮಾನ್ಯ ಪದಾರ್ಥ ಯಾವುದು?",
            options = listOf("ಪಾಲಕ್ ಸೊಪ್ಪು", "ಮೊಸರು", "ವಿನೆಗರ್", "ಮಾವಿನಕಾಯಿ"),
            correctAnswer = "ವಿನೆಗರ್",
            explanation = "ವಿನೆಗರ್‌ನಲ್ಲಿ ಅಸಿಟಿಕ್ ಆಮ್ಲ (Acetic acid) ಇರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u2_6",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಸಾಬೂನಿನಲ್ಲಿ ಬಳಸಲಾಗುವ ಪ್ರತ್ಯಾಮ್ಲ ಯಾವುದು?",
            options = listOf("ಸೋಡಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್", "ಪೊಟ್ಯಾಸಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್", "A ಮತ್ತು B ಎರಡೂ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "A ಮತ್ತು B ಎರಡೂ",
            explanation = "NaOH ಮತ್ತು KOH ಎರಡನ್ನೂ ಸಾಬೂನು ತಯಾರಿಕೆಯಲ್ಲಿ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u2_7",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬೇಕಿಂಗ್ ಸೋಡಾದ (ಅಡುಗೆ ಸೋಡಾ) ರಾಸಾಯನಿಕ ಹೆಸರು ಯಾವುದು?",
            options = listOf("ಸೋಡಿಯಂ ಕಾರ್ಬೋನೇಟ್", "ಸೋಡಿಯಂ ಬೈ ಸಲ್ಫೇಟ್", "ಸೋಡಿಯಂ ಬೈಕಾರ್ಬೋನೇಟ್ (NaHCO₃)", "ಸೋಡಿಯಂ ಕ್ಲೋರೈಡ್"),
            correctAnswer = "ಸೋಡಿಯಂ ಬೈಕಾರ್ಬೋನೇಟ್ (NaHCO₃)",
            explanation = "ಬೇಕಿಂಗ್ ಸೋಡಾ = ಸೋಡಿಯಂ ಹೈಡ್ರೋಜನ್ ಕಾರ್ಬೋನೇಟ್ ಅಥವಾ ಸೋಡಿಯಂ ಬೈಕಾರ್ಬೋನೇಟ್."
        ),
        QuestionModel(
            id = "s_7_sci_u2_8",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಸೋಡಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್ ಮತ್ತು ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲ ವರ್ತಿಸಿದಾಗ ದೊರೆಯುವ ಉತ್ಪನ್ನಗಳು ಯಾವುವು?",
            options = listOf("ಲವಣ (NaCl) ಮತ್ತು ನೀರು (H₂O)", "ಲವಣ ಮತ್ತು ಹೈಡ್ರೋಜನ್", "ಆಮ್ಲ ಮತ್ತು ನೀರು", "ಪ್ರತ್ಯಾಮ್ಲಗಳು"),
            correctAnswer = "ಲವಣ (NaCl) ಮತ್ತು ನೀರು (H₂O)",
            explanation = "HCl + NaOH -> NaCl + H2O (ತಟಸ್ಥೀಕರಣ ಕ್ರಿಯೆ)."
        ),
        QuestionModel(
            id = "s_7_sci_u2_9",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಅರಿಶಿಣ ಸೂಚಕವನ್ನು ಬಳಸಿದಾಗ ಕೆಂಪು ಬಣ್ಣಕ್ಕೆ ತಿರುಗುವ ಪದಾರ್ಥ ಯಾವುದು?",
            options = listOf("ಸಕ್ಕರೆ ದ್ರಾವಣ", "ವಿನೆಗರ್", "ಉಪ್ಪಿನ ದ್ರಾವಣ", "ಸೋಪಿನ ದ್ರಾವಣ"),
            correctAnswer = "ಸೋಪಿನ ದ್ರಾವಣ",
            explanation = "ಅರಿಶಿಣವು ಪ್ರತ್ಯಾಮ್ಲಗಳೊಂದಿಗೆ (ಸಾಬೂನು ದ್ರಾವಣ) ಕೆಂಪು ಬಣ್ಣಕ್ಕೆ ತಿರುಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u2_10",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ನೆಲ್ಲಿಕಾಯಿಯಲ್ಲಿ (Amla) ಹೇರಳವಾಗಿ ದೊರೆಯುವ ವಿಟಮಿನ್ ಯಾವುದು?",
            options = listOf("ವಿಟಮಿನ್ A", "ವಿಟಮಿನ್ C (ಆಸ್ಕೋರ್ಬಿಕ್ ಆಮ್ಲ)", "ವಿಟಮಿನ್ D", "ವಿಟಮಿನ್ E"),
            correctAnswer = "ವಿಟಮಿನ್ C (ಆಸ್ಕೋರ್ಬಿಕ್ ಆಮ್ಲ)",
            explanation = "ನೆಲ್ಲಿಕಾಯಿಯಲ್ಲಿ ವಿಟಮಿನ್ C ಸಮೃದ್ಧವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u2_11",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಇರುವೆ ಕಚ್ಚಿದಾಗ ಚರ್ಮದಲ್ಲಿ ಉರಿ ಉಂಟಾಗಲು ಕಾರಣವಾದ ಆಮ್ಲ ಯಾವುದು?",
            options = listOf("ಸಿಟ್ರಿಕ್ ಆಮ್ಲ", "ಟಾರ್ಟಾರಿಕ್ ಆಮ್ಲ", "ಆಕ್ಸಾಲಿಕ್ ಆಮ್ಲ", "ಫಾರ್ಮಿಕ್ ಆಮ್ಲ (ಮೆಥನೋಯಿಕ್ ಆಮ್ಲ)"),
            correctAnswer = "ಫಾರ್ಮಿಕ್ ಆಮ್ಲ (ಮೆಥನೋಯಿಕ್ ಆಮ್ಲ)",
            explanation = "ಇರುವೆ ಕಡಿತದಲ್ಲಿ ಫಾರ್ಮಿಕ್ ಆಮ್ಲವಿರುತ್ತದೆ; ಇದಕ್ಕೆ ಕ್ಯಾಲಮೈನ್ ಅಥವಾ ಅಡುಗೆ ಸೋಡಾ ಹಚ್ಚಿ ಶಮನಗೊಳಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u2_12",
            stdId = 7,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ರಾಷ್ಟ್ರೀಯ ವಿಜ್ಞಾನ ದಿನವನ್ನು ಯಾವಾಗ ಆಚರಿಸಲಾಗುತ್ತದೆ?",
            options = listOf("ಜನವರಿ 26", "ಫೆಬ್ರವರಿ 28", "ಆಗಸ್ಟ್ 15", "ಸೆಪ್ಟೆಂಬರ್ 5"),
            correctAnswer = "ಫೆಬ್ರವರಿ 28",
            explanation = "ಸರ್ ಸಿ.ವಿ. ರಾಮನ್ ಅವರ 'ರಾಮನ್ ಎಫೆಕ್ಟ್' ಸಂಶೋಧನೆಯ ಸ್ಮರಣಾರ್ಥ ಫೆಬ್ರವರಿ 28 ರಂದು ಆಚರಿಸಲಾಗುತ್ತದೆ."
        ),

        // ==================== ಘಟಕ 3: ವಿದ್ಯುತ್ ಕ್ಷೇಮ: ಮಂಡಲಗಳು ಮತ್ತು ಅದರ ಘಟಕಗಳು ====================
        QuestionModel(
            id = "s_7_sci_u3_1",
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಬಲ್ಬ್‌ನಲ್ಲಿ ಬೆಳಕನ್ನು ಹೊರಸೂಸುವ ತೆಳುವಾದ ತಂತಿಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಕನೆಕ್ಟರ್", "ಫಿಲಮೆಂಟ್", "ಟರ್ಮಿನಲ್", "ಸ್ವಿಚ್"),
            correctAnswer = "ಫಿಲಮೆಂಟ್",
            explanation = "ಬಲ್ಬ್‌ನ ಒಳಗೆ ಹೊಳೆಯುವ ಸುರುಳಿಯಾಕಾರದ ತೆಳುವಾದ ತಂತಿಯೇ ಫಿಲಮೆಂಟ್."
        ),
        QuestionModel(
            id = "s_7_sci_u3_2",
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಬಲ್ಬ್‌ನ ಫಿಲಮೆಂಟ್ ತಯಾರಿಸಲು ಸಾಮಾನ್ಯವಾಗಿ ಬಳಸುವ ಲೋಹ ಯಾವುದು?",
            options = listOf("ತಾಮ್ರ", "ಕಬ್ಬಿಣ", "ಟಂಗ್‌ಸ್ಟನ್", "ಅಲ್ಯೂಮಿನಿಯಂ"),
            correctAnswer = "ಟಂಗ್‌ಸ್ಟನ್",
            explanation = "ಟಂಗ್‌ಸ್ಟನ್ ಅಧಿಕ ಕರಗುವ ಬಿಂದು ಹೊಂದಿದ್ದು ಹೆಚ್ಚಿನ ತಾಪದಲ್ಲೂ ಕರಗದೆ ಪ್ರಕಾಶಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u3_3",
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸರಳ ವಿದ್ಯುತ್ ಮಂಡಲದಲ್ಲಿ ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ಸಾಂಪ್ರದಾಯಿಕ ದಿಕ್ಕು ಯಾವುದು?",
            options = listOf("ಋಣಾತ್ಮಕ ತುದಿಯಿಂದ ಧನಾತ್ಮಕ ತುದಿಗೆ", "ಧನಾತ್ಮಕ ತುದಿಯಿಂದ ಋಣಾತ್ಮಕ ತುದಿಗೆ", "ಯಾವುದೇ ದಿಕ್ಕಿನಲ್ಲಿ", "ಧನದಿಂದ ಧನಕ್ಕೆ"),
            correctAnswer = "ಧನಾತ್ಮಕ ತುದಿಯಿಂದ ಋಣಾತ್ಮಕ ತುದಿಗೆ",
            explanation = "ವಿದ್ಯುತ್ ಪ್ರವಾಹವು ಯಾವಾಗಲೂ ಕೋಶದ ಧನ (+) ತುದಿಯಿಂದ ಋಣ (-) ತುದಿಯ ಕಡೆಗೆ ಹರಿಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u3_4",
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಎರಡು ಅಥವಾ ಎರಡಕ್ಕಿಂತ ಹೆಚ್ಚು ವಿದ್ಯುತ್ ಕೋಶಗಳ ಜೋಡಣೆಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಜನರೇಟರ್", "ಮೋಟಾರ್", "ಬ್ಯಾಟರಿ", "ಫ್ಯೂಸ್"),
            correctAnswer = "ಬ್ಯಾಟರಿ",
            explanation = "ವಿದ್ಯುತ್ ಕೋಶಗಳ ಸರಣಿ ಅಥವಾ ಸಮಾನಾಂತರ ಸಂಯೋಜನೆಯೇ ಬ್ಯಾಟರಿ."
        ),
        QuestionModel(
            id = "s_7_sci_u3_5",
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ವಿದ್ಯುತ್ ವಾಹಕವಾಗಿರುವ ಅಲೋಹ ಯಾವುದು?",
            options = listOf("ಪ್ಲಾಸ್ಟಿಕ್ ಸ್ಕೇಲ್", "ಮರದ ತುಂಡು", "ಗ್ರಾಫೈಟ್ (ಪೆನ್ಸಿಲ್ ಲೆಡ್)", "ಗಾಜು"),
            correctAnswer = "ಗ್ರಾಫೈಟ್ (ಪೆನ್ಸಿಲ್ ಲೆಡ್)",
            explanation = "ಗ್ರಾಫೈಟ್ ಕಾರ್ಬನ್‌ನ ಅಲೋಹ ರೂಪವಾಗಿದ್ದರೂ ವಿದ್ಯುತ್ತಿನ ಉತ್ತಮ ವಾಹಕವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u3_6",
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಣ ವಿದ್ಯುತ್ ಕೋಶಗಳಲ್ಲಿ ವಿದ್ಯುತ್ ಶಕ್ತಿಯು ಯಾವುದರಿಂದ ಉತ್ಪತ್ತಿಯಾಗುತ್ತದೆ?",
            options = listOf("ಉಷ್ಣಶಕ್ತಿ", "ರಾಸಾಯನಿಕ ಶಕ್ತಿ", "ಯಾಂತ್ರಿಕ ಶಕ್ತಿ", "ಸಾಂದ್ರ ಶಕ್ತಿ"),
            correctAnswer = "ರಾಸಾಯನಿಕ ಶಕ್ತಿ",
            explanation = "ವಿದ್ಯುತ್ ಕೋಶದಲ್ಲಿ ರಾಸಾಯನಿಕ ಶಕ್ತಿಯು ವಿದ್ಯುತ್ ಶಕ್ತಿಯಾಗಿ ಪರಿವರ್ತನೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u3_7",
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಮಂಡಲ ಸಂಕೇತಗಳಲ್ಲಿ ಉದ್ದವಾದ ತೆಳುವಾದ ರೇಖೆಯು ಯಾವುದನ್ನು ಪ್ರತಿನಿಧಿಸುತ್ತದೆ?",
            options = listOf("ಋಣಾತ್ಮಕ ತುದಿ", "ಧನಾತ್ಮಕ ತುದಿ (+)", "ಸ್ವಿಚ್", "ತಂತಿ"),
            correctAnswer = "ಧನಾತ್ಮಕ ತುದಿ (+)",
            explanation = "ಉದ್ದನೆಯ ತೆಳುವಾದ ಗೆರೆ ಧನಾತ್ಮಕ ತುದಿ (+), ಗಿಡ್ಡನೆಯ ದಪ್ಪ ಗೆರೆ ಋಣಾತ್ಮಕ ತುದಿ (-)."
        ),
        QuestionModel(
            id = "s_7_sci_u3_8",
            stdId = 7,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮಾನವನ ದೇಹವು ವಿದ್ಯುತ್ತಿನ ಉತ್ತಮ —",
            options = listOf("ಬಂಧಕ", "ವಾಹಕ", "ನಿರೋಧಕ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ವಾಹಕ",
            explanation = "ಮಾನವ ದೇಹದಲ್ಲಿ ಲವಣಯುಕ್ತ ದ್ರವಗಳಿರುವುದರಿಂದ ವಿದ್ಯುತ್ ಸುಲಭವಾಗಿ ಹರಿಯುತ್ತದೆ (ಉತ್ತಮ ವಾಹಕ)."
        ),

        // ==================== ಘಟಕ 4: ಲೋಹಗಳು ಮತ್ತು ಅಲೋಹಗಳ ಜಗತ್ತು ====================
        QuestionModel(
            id = "s_7_sci_u4_1",
            stdId = 7,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಅತ್ಯಧಿಕ ತನ್ಯತೆಯನ್ನು (Ductility - ತಂತಿಯಾಗಿ ಎಳೆಯುವ ಗುಣ) ಹೊಂದಿರುವ ಲೋಹ ಯಾವುದು?",
            options = listOf("ಕಬ್ಬಿಣ", "ತಾಮ್ರ", "ಚಿನ್ನ (Au)", "ಅಲ್ಯೂಮಿನಿಯಂ"),
            correctAnswer = "ಚಿನ್ನ (Au)",
            explanation = "ಚಿನ್ನವು ಅತ್ಯಂತ ಹೆಚ್ಚು ತನ್ಯ ಗುಣ ಹೊಂದಿದ್ದು, ಕೇವಲ 1 ಗ್ರಾಂ ಚಿನ್ನದಿಂದ 2 ಕಿ.ಮೀ ಉದ್ದದ ತಂತಿ ಎಳೆಯಬಹುದು."
        ),
        QuestionModel(
            id = "s_7_sci_u4_2",
            stdId = 7,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೋಣೆಯ ಉಷ್ಣತೆಯಲ್ಲಿ ದ್ರವ ಸ್ಥಿತಿಯಲ್ಲಿ ಕಂಡುಬರುವ ಲೋಹ ಯಾವುದು?",
            options = listOf("ತಾಮ್ರ", "ಕಬ್ಬಿಣ", "ಪಾದರಸ (Mercury)", "ಅಲ್ಯೂಮಿನಿಯಂ"),
            correctAnswer = "ಪಾದರಸ (Mercury)",
            explanation = "ಪಾದರಸ (Hg) ಕೊಠಡಿಯ ಸಾಮಾನ್ಯ ತಾಪಮಾನದಲ್ಲಿ ದ್ರವರೂಪದಲ್ಲಿರುವ ಏಕೈಕ ಲೋಹ."
        ),
        QuestionModel(
            id = "s_7_sci_u4_3",
            stdId = 7,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಚಾಕುವಿನಿಂದ ಸುಲಭವಾಗಿ ಕತ್ತರಿಸಬಹುದಾದ ಮೃದುವಾದ ಲೋಹ ಯಾವುದು?",
            options = listOf("ಕಬ್ಬಿಣ", "ತಾಮ್ರ", "ಸೋಡಿಯಂ (ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ)", "ಚಿನ್ನ"),
            correctAnswer = "ಸೋಡಿಯಂ (ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ)",
            explanation = "ಸೋಡಿಯಂ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ ಅತೀ ಮೃದುವಾದ ಲೋಹಗಳಾಗಿದ್ದು ಚಾಕುವಿನಿಂದ ಕತ್ತರಿಸಬಹುದು."
        ),
        QuestionModel(
            id = "s_7_sci_u4_4",
            stdId = 7,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸೋಡಿಯಂ ಲೋಹವನ್ನು ಗಾಳಿ ಮತ್ತು ನೀರಿನೊಂದಿಗೆ ಉಗ್ರವಾಗಿ ವರ್ತಿಸುವುದರಿಂದ ಎಲ್ಲಿ ಸಂಗ್ರಹಿಸಿಡಲಾಗುತ್ತದೆ?",
            options = listOf("ನೀರಿನಲ್ಲಿ", "ಆಲ್ಕೋಹಾಲ್‌ನಲ್ಲಿ", "ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ (Kerosene)", "ತೆರೆದ ಪಾತ್ರೆಯಲ್ಲಿ"),
            correctAnswer = "ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ (Kerosene)",
            explanation = "ಸೋಡಿಯಂ ತೇವಾಂಶ ಮತ್ತು ಆಮ್ಲಜನಕದೊಂದಿಗೆ ತಕ್ಷಣ ಹೊತ್ತಿಕೊಳ್ಳುವುದರಿಂದ ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ ಮುಳುಗಿಸಿಡುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u4_5",
            stdId = 7,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ನೀರಿನಲ್ಲಿ ಸಂಗ್ರಹಿಸಿಡುವ ಅತೀ ಕ್ರಿಯಾಶೀಲ ಅಲೋಹ ಯಾವುದು?",
            options = listOf("ಸೋಡಿಯಂ", "ಪೊಟ್ಯಾಸಿಯಂ", "ಸಲ್ಫರ್", "ಫಾಸ್ಫರಸ್ (ರಂಜಕ)"),
            correctAnswer = "ಫಾಸ್ಫರಸ್ (ರಂಜಕ)",
            explanation = "ಫಾಸ್ಫರಸ್ ಗಾಳಿಯ ಆಮ್ಲಜನಕದೊಂದಿಗೆ ತಕ್ಷಣ ಬೆಂಕಿ ಹೊತ್ತಿಕೊಳ್ಳುತ್ತದೆ, ಆದರೆ ನೀರಿನೊಂದಿಗೆ ವರ್ತಿಸುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_7_sci_u4_6",
            stdId = 7,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಬ್ಬಿಣದ ವಸ್ತುಗಳು ತುಕ್ಕು ಹಿಡಿಯುವುದನ್ನು ತಡೆಯಲು ಸತುವಿನ (Zinc) ತೆಳುವಾದ ಪದರ ಲೇಪಿಸುವ ಪ್ರಕ್ರಿಯೆ ಯಾವುದು?",
            options = listOf("ದಹನ", "ಗಾಲ್ವನೀಕರಣ (Galvanization)", "ಸವೆತ", "ತಟಸ್ಥೀಕರಣ"),
            correctAnswer = "ಗಾಲ್ವನೀಕರಣ (Galvanization)",
            explanation = "ಕಬ್ಬಿಣಕ್ಕೆ ಜಿಂಕ್ ಲೇಪನ ಮಾಡುವ ವಿಧಾನವೇ ಗಾಲ್ವನೈಸೇಶನ್."
        ),

        // ==================== ಘಟಕ 5: ನಮ್ಮ ಸುತ್ತಲಿನ ಬದಲಾವಣೆಗಳು: ಭೌತ ಮತ್ತು ರಾಸಾಯನಿಕ ====================
        QuestionModel(
            id = "s_7_sci_u5_1",
            stdId = 7,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಭೌತಿಕ ಬದಲಾವಣೆಗೆ ಸೂಕ್ತ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಹಾಲು ಮೊಸರಾಗುವುದು", "ಮಂಜುಗಡ್ಡೆ ಕರಗಿ ನೀರಾಗುವುದು", "ಕಾಗದವನ್ನು ಸುಡುವುದು", "ಕಬ್ಬಿಣ ತುಕ್ಕು ಹಿಡಿಯುವುದು"),
            correctAnswer = "ಮಂಜುಗಡ್ಡೆ ಕರಗಿ ನೀರಾಗುವುದು",
            explanation = "ಸ್ಥಿತಿ ಬದಲಾವಣೆಯಾಗಿದ್ದರೂ ನೀರಿನ ರಾಸಾಯನಿಕ ರಚನೆ ಬದಲಾಗುವುದಿಲ್ಲ, ಆದ್ದರಿಂದ ಭೌತಿಕ ಬದಲಾವಣೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u5_2",
            stdId = 7,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ತಾಮ್ರದ ಸಲ್ಫೇಟ್ ದ್ರಾವಣಕ್ಕೆ ಕಬ್ಬಿಣದ ಮೊಳೆಯನ್ನು ಹಾಕಿದಾಗ ದ್ರಾವಣದ ನೀಲಿ ಬಣ್ಣವು ಯಾವ ಬಣ್ಣಕ್ಕೆ ತಿರುಗುತ್ತದೆ?",
            options = listOf("ಕೆಂಪು", "ಹಳದಿ", "ಹಸಿರು (ಫೆರಸ್ ಸಲ್ಫೇಟ್)", "ಬಿಳಿ"),
            correctAnswer = "ಹಸಿರು (ಫೆರಸ್ ಸಲ್ಫೇಟ್)",
            explanation = "ಕಬ್ಬಿಣವು ತಾಮ್ರವನ್ನು ಸ್ಥಾನಪಲ್ಲಟಗೊಳಿಸಿ ಹಸಿರು ಬಣ್ಣದ ಫೆರಸ್ ಸಲ್ಫೇಟ್ (FeSO₄) ಉಂಟುಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u5_3",
            stdId = 7,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಸುಣ್ಣದ ನೀರಿಗೆ ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂) ಹಾಯಿಸಿದಾಗ ಹಾಲು ಬಿಳಿಯಾಗಲು ಕಾರಣವಾದ ಸಂಯುಕ್ತ ಯಾವುದು?",
            options = listOf("ಕ್ಯಾಲ್ಸಿಯಂ ಕಾರ್ಬೋನೇಟ್ (CaCO₃)", "ಕ್ಯಾಲ್ಸಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್", "ಕ್ಯಾಲ್ಸಿಯಂ ಸಲ್ಫೇಟ್", "ಕಾರ್ಬೋನಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಕ್ಯಾಲ್ಸಿಯಂ ಕಾರ್ಬೋನೇಟ್ (CaCO₃)",
            explanation = "Ca(OH)₂ + CO₂ -> CaCO₃ (ಬಿಳಿ ಅವಕ್ಷೇಪ) + H₂O."
        ),
        QuestionModel(
            id = "s_7_sci_u5_4",
            stdId = 7,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಕಬ್ಬಿಣ ತುಕ್ಕು ಹಿಡಿಯಲು ಅನಿವಾರ್ಯವಾಗಿ ಬೇಕಾಗುವ ಅಂಶಗಳು ಯಾವುವು?",
            options = listOf("ಆಮ್ಲಜನಕ ಮಾತ್ರ", "ತೇವಾಂಶ ಮಾತ್ರ", "ಆಮ್ಲಜನಕ ಮತ್ತು ನೀರು (ತೇವಾಂಶ) ಎರಡೂ", "ಸಾರಜನಕ ಮತ್ತು CO₂"),
            correctAnswer = "ಆಮ್ಲಜನಕ ಮತ್ತು ನೀರು (ತೇವಾಂಶ) ಎರಡೂ",
            explanation = "ಆಮ್ಲಜನಕ ಮತ್ತು ತೇವಾಂಶ ಎರಡೂ ಇದ್ದಾಗ ಮಾತ್ರ ಕಬ್ಬಿಣ ತುಕ್ಕು ಹಿಡಿಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u5_5",
            stdId = 7,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ದ್ರಾವಣದಿಂದ ಶುದ್ಧವಾದ ಘನ ಕಣಗಳನ್ನು ಪಡೆಯುವ ಸ್ಫಟಿಕೀಕರಣವು ಯಾವ ರೀತಿಯ ಬದಲಾವಣೆ?",
            options = listOf("ರಾಸಾಯನಿಕ ಬದಲಾವಣೆ", "ಭೌತಿಕ ಬದಲಾವಣೆ", "ಶಾಶ್ವತ ಬದಲಾವಣೆ", "ಜೈವಿಕ ಬದಲಾವಣೆ"),
            correctAnswer = "ಭೌತಿಕ ಬದಲಾವಣೆ",
            explanation = "ಸ್ಫಟಿಕೀಕರಣದಲ್ಲಿ ಯಾವುದೇ ಹೊಸ ರಾಸಾಯನಿಕ ವಸ್ತು ಉಂಟಾಗುವುದಿಲ್ಲ, ಕೇವಲ ಶುದ್ಧೀಕರಣ ಪ್ರಕ್ರಿಯೆ."
        ),

        // ==================== ಘಟಕ 6: ಹದಿಹರೆಯ: ಬೆಳವಣಿಗೆ ಮತ್ತು ಬದಲಾವಣೆಯ ಒಂದು ಹಂತ ====================
        QuestionModel(
            id = "s_7_sci_u6_1",
            stdId = 7,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಸಾಮಾನ್ಯವಾಗಿ 10 ರಿಂದ 19 ವರ್ಷ ವಯಸ್ಸಿನ ಮಾನವನ ಬೆಳವಣಿಗೆಯ ಹಂತವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಶೈಶವಾವಸ್ಥೆ", "ಬಾಲ್ಯಾವಸ್ಥೆ", "ಹದಿಹರೆಯ (Adolescence)", "ವೃದ್ಧಾಪ್ಯ"),
            correctAnswer = "ಹದಿಹರೆಯ (Adolescence)",
            explanation = "ವಿಶ್ವ ಆರೋಗ್ಯ ಸಂಸ್ಥೆಯ ಪ್ರಕಾರ 10-19 ವರ್ಷದ ಅವಧಿಯೇ ಹದಿಹರೆಯ."
        ),
        QuestionModel(
            id = "s_7_sci_u6_2",
            stdId = 7,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಹದಿಹರೆಯದ ಗಂಡುಮಕ್ಕಳಲ್ಲಿ ಗಂಟಲಿನ ಭಾಗದಲ್ಲಿ ಉಬ್ಬಿಕೊಂಡಂತಿರುವ ಧ್ವನಿಪೆಟ್ಟಿಗೆ ರಚನೆಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಶ್ವಾಸನಾಳ", "ಆಡಮ್ಸ್ ಆಪಲ್ (Adam's Apple)", "ಅನ್ನನಾಳ", "ಥೈರಾಯ್ಡ್"),
            correctAnswer = "ಆಡಮ್ಸ್ ಆಪಲ್ (Adam's Apple)",
            explanation = "ಲಾರಿಂಕ್ಸ್ (ಧ್ವನಿಪೆಟ್ಟಿಗೆ) ನ ಬೆಳವಣಿಗೆಯಿಂದ ಹೊರಚಾಚುವ ಭಾಗವೇ ಆಡಮ್ಸ್ ಆಪಲ್."
        ),
        QuestionModel(
            id = "s_7_sci_u6_3",
            stdId = 7,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕ ಸರ್ಕಾರವು ಋತುಸ್ರಾವದ ನೈರ್ಮಲ್ಯವನ್ನು ಬೆಂಬಲಿಸಲು ಹೆಣ್ಣುಮಕ್ಕಳಿಗಾಗಿ ಜಾರಿಗೆ ತಂದಿರುವ ಯೋಜನೆ ಯಾವುದು?",
            options = listOf("‘ಶುಚಿ’ ಯೋಜನೆ", "RKSK ಯೋಜನೆ", "NMBA ಅಭಿಯಾನ", "ಪುದುಮೈ ಪೆನ್"),
            correctAnswer = "‘ಶುಚಿ’ ಯೋಜನೆ",
            explanation = "ಕರ್ನಾಟಕ ಸರ್ಕಾರದ 'ಶುಚಿ' ಯೋಜನೆಯು ಶಾಲಾ ವಿದ್ಯಾರ್ಥಿನಿಯರಿಗೆ ನೈರ್ಮಲ್ಯ ಪ್ಯಾಡ್‌ಗಳನ್ನು ವಿತರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u6_4",
            stdId = 7,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ರಾಷ್ಟ್ರೀಯ ವ್ಯಸನ ನಿವಾರಣಾ ಸಹಾಯವಾಣಿಯ ಉಚಿತ ದೂರವಾಣಿ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("1098", "108", "14446", "112"),
            correctAnswer = "14446",
            explanation = "ಭಾರತ ಸರ್ಕಾರದ ರಾಷ್ಟ್ರೀಯ ಟೋಲ್ ಫ್ರೀ ವ್ಯಸನ ಮುಕ್ತ ಸಹಾಯವಾಣಿ ಸಂಖ್ಯೆ 14446."
        )
    )
}
