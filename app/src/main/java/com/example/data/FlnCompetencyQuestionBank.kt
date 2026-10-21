package com.example.data

/**
 * FLN (Foundational Literacy & Numeracy - ಮೂಲಭೂತ ಕಲಿಕಾ ಸಾಮರ್ಥ್ಯಗಳು) Question Bank
 * Covers Classes 6, 7, 8, 9, and 10 across 3 core subjects:
 * 1. Kannada (ಕನ್ನಡ) - 20 MCQs per class (Reading comprehension, sentence writing, vocabulary, everyday communication)
 * 2. English - 20 MCQs per class (Passage comprehension, grammar, vocabulary, conversation)
 * 3. Mathematics (ಗಣಿತ) - 20 MCQs per class (4-digit numbers, place value, operations, word problems, practical math)
 * Total: 300 MCQs.
 */
object FlnCompetencyQuestionBank {

    val units = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಮೂಲಭೂತ ಸಾಕ್ಷರತೆ - ಕನ್ನಡ (FLN Kannada Literacy)", 20, "Easy"),
        UnitTemplate(2, "Unit 2: Foundational Literacy - English (FLN English)", 20, "Easy"),
        UnitTemplate(3, "ಘಟಕ 3: ಮೂಲಭೂತ ಸಂಖ್ಯಾಜ್ಞಾನ & ಗಣಿತ (FLN Numeracy & Mathematics)", 20, "Medium")
    )

    val questions: List<QuestionModel> = listOf(
        // =========================================================================
        // =========================== 6 STD KANNADA (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_6_kan_1",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ವಾಕ್ಯವನ್ನು ಓದಿ: “ರಮೇಶನು ಪ್ರತಿದಿನ ಶಾಲೆಗೆ ಹೋಗುತ್ತಾನೆ.” ರಮೇಶನು ಎಲ್ಲಿಗೆ ಹೋಗುತ್ತಾನೆ?",
            options = listOf("ಮಾರುಕಟ್ಟೆಗೆ", "ಶಾಲೆಗೆ", "ಆಸ್ಪತ್ರೆಗೆ", "ಉದ್ಯಾನವನಕ್ಕೆ"),
            correctAnswer = "ಶಾಲೆಗೆ",
            explanation = "ವಾಕ್ಯದಲ್ಲಿ “ಶಾಲೆಗೆ ಹೋಗುತ್ತಾನೆ” ಎಂದು ಸ್ಪಷ್ಟವಾಗಿ ತಿಳಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "fln_6_kan_2",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಸೀತಾ ತೋಟದಲ್ಲಿ ಹೂವುಗಳಿಗೆ ನೀರು ಹಾಕಿದಳು.” ಸೀತಾ ಎಲ್ಲಿದ್ದಳು?",
            options = listOf("ಮನೆಯಲ್ಲಿ", "ಶಾಲೆಯಲ್ಲಿ", "ತೋಟದಲ್ಲಿ", "ಅಂಗಡಿಯಲ್ಲಿ"),
            correctAnswer = "ತೋಟದಲ್ಲಿ",
            explanation = "ವಾಕ್ಯದ ಪ್ರಕಾರ ಸೀತಾ ತೋಟದಲ್ಲಿದ್ದು ಹೂವುಗಳಿಗೆ ನೀರು ಹಾಕುತ್ತಿದ್ದಳು."
        ),
        QuestionModel(
            id = "fln_6_kan_3",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಮಳೆ ಬಂದ ಕಾರಣ ಮಕ್ಕಳು ಮನೆಯೊಳಗೆ ಆಟವಾಡಿದರು.” ಮಕ್ಕಳು ಮನೆಯೊಳಗೆ ಏಕೆ ಆಟವಾಡಿದರು?",
            options = listOf("ಬಿಸಿಲಿದ್ದುದರಿಂದ", "ಮಳೆ ಬಂದಿದ್ದರಿಂದ", "ಶಾಲೆ ಇದ್ದುದರಿಂದ", "ರಾತ್ರಿ ಆಗಿದ್ದರಿಂದ"),
            correctAnswer = "ಮಳೆ ಬಂದಿದ್ದರಿಂದ",
            explanation = "ಮಳೆ ಬಂದ ಕಾರಣ ಮಕ್ಕಳು ಹೊರಗೆ ಆಟವಾಡದೆ ಮನೆಯೊಳಗೆ ಆಡಿದರು."
        ),
        QuestionModel(
            id = "fln_6_kan_4",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ರವಿ ಪುಸ್ತಕವನ್ನು ಓದಿದನು.” ಈ ವಾಕ್ಯದಲ್ಲಿ ಕ್ರಿಯಾಪದ ಯಾವುದು?",
            options = listOf("ರವಿ", "ಪುಸ್ತಕವನ್ನು", "ಓದಿದನು", "ಈ"),
            correctAnswer = "ಓದಿದನು",
            explanation = "ಕ್ರಿಯೆಯನ್ನು (ಕೆಲಸವನ್ನು) ಸೂಚಿಸುವ ಪದವೇ ಕ್ರಿಯಾಪದ. ಇಲ್ಲಿ 'ಓದಿದನು' ಕ್ರಿಯಾಪದ."
        ),
        QuestionModel(
            id = "fln_6_kan_5",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಹೂವು” ಪದದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ಹೂವಿನ", "ಹೂಗಳು", "ಹೂವಿಗೆ", "ಹೂವಿನಿಂದ"),
            correctAnswer = "ಹೂಗಳು",
            explanation = "ಹೂವು ಪದದ ಬಹುವಚನ 'ಹೂಗಳು' ಅಥವಾ 'ಹೂವುಗಳು'."
        ),
        QuestionModel(
            id = "fln_6_kan_6",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಹಗಲು” ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಬೆಳಕು", "ಸೂರ್ಯ", "ರಾತ್ರಿ", "ಬೆಳಗ್ಗೆ"),
            correctAnswer = "ರಾತ್ರಿ",
            explanation = "ಹಗಲು ಪದದ ನೇರ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ರಾತ್ರಿ."
        ),
        QuestionModel(
            id = "fln_6_kan_7",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಸಂತೋಷ” ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ದುಃಖ", "ಆನಂದ", "ಕೋಪ", "ಭಯ"),
            correctAnswer = "ಆನಂದ",
            explanation = "ಸಂತೋಷ ಎಂದರೆ ಆನಂದ, ಹರ್ಷ."
        ),
        QuestionModel(
            id = "fln_6_kan_8",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸರಿಯಾದ ಪದವನ್ನು ಆಯ್ಕೆಮಾಡಿ (ಶುದ್ಧ ರೂಪ).",
            options = listOf("ವಿಧ್ಯಾರ್ಥಿ", "ವಿದ್ಯಾರ್ಥಿ", "ವಿದ್ಯಾರ್ತಿ", "ವಿದ್ಯಾಥಿ"),
            correctAnswer = "ವಿದ್ಯಾರ್ಥಿ",
            explanation = "ವಿದ್ಯೆಯನ್ನು ಕಲಿಯುವವನು 'ವಿದ್ಯಾರ್ಥಿ' ಎಂಬುದು ಸರಿಯಾದ ಅಕ್ಷರ ಜೋಡಣೆ."
        ),
        QuestionModel(
            id = "fln_6_kan_9",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ವ್ಯಾಕರಣಬದ್ಧವಾದ ಸರಿಯಾದ ವಾಕ್ಯವನ್ನು ಗುರುತಿಸಿ.",
            options = listOf("ನಾನು ಶಾಲೆಗೆ ಹೋಗುತ್ತೇನೆ.", "ನಾನು ಶಾಲೆಗೆ ಹೋಗುತ್ತಾನೆ.", "ನಾನು ಶಾಲೆಗೆ ಹೋಗುತ್ತಾರೆ.", "ನಾನು ಶಾಲೆಗೆ ಹೋಗುತ್ತಾಳೆ."),
            correctAnswer = "ನಾನು ಶಾಲೆಗೆ ಹೋಗುತ್ತೇನೆ.",
            explanation = "ಉತ್ತಮ ಪುರುಷ ಏಕವಚನ 'ನಾನು' ಕ್ರಿಯಾಪದ 'ಹೋಗುತ್ತೇನೆ' ಯೊಂದಿಗೆ ಹೊಂದಿಕೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_6_kan_10",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪ್ರಶ್ನಾರ್ಥಕ ವಾಕ್ಯದ ಕೊನೆಯಲ್ಲಿ ಸಾಮಾನ್ಯವಾಗಿ ಯಾವ ಲೇಖನ ಚಿಹ್ನೆ ಬಳಸಲಾಗುತ್ತದೆ?",
            options = listOf("ಪೂರ್ಣವಿರಾಮ (.)", "ಅಲ್ಪವಿರಾಮ (,)", "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ (?)", "ಆಶ್ಚರ್ಯಸೂಚಕ ಚಿಹ್ನೆ (!)"),
            correctAnswer = "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ (?)",
            explanation = "ಪ್ರಶ್ನೆಗಳನ್ನು ಕೇಳುವ ವಾಕ್ಯಗಳ ಕೊನೆಯಲ್ಲಿ '?' ಚಿಹ್ನೆಯನ್ನು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_6_kan_11",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಹಸು ಹಾಲು ಕೊಡುತ್ತದೆ.” ಈ ವಾಕ್ಯದಲ್ಲಿ ಯಾವ ಪ್ರಾಣಿಯ ಬಗ್ಗೆ ಹೇಳಲಾಗಿದೆ?",
            options = listOf("ಆಡು", "ಹಸು", "ಕುದುರೆ", "ನಾಯಿ"),
            correctAnswer = "ಹಸು",
            explanation = "ಈ ವಾಕ್ಯವು ಸಾಕುಪ್ರಾಣಿ ಹಸುವಿನ ಉಪಯುಕ್ತತೆಯ ಬಗ್ಗೆ ಹೇಳುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_6_kan_12",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ನಾವು ಪ್ರತಿದಿನ ಗಿಡಗಳಿಗೆ ನೀರು ಹಾಕಬೇಕು.” ಈ ವಾಕ್ಯವು ಯಾವ ಒಳ್ಳೆಯ ಅಭ್ಯಾಸವನ್ನು ತಿಳಿಸುತ್ತದೆ?",
            options = listOf("ಗಿಡಗಳನ್ನು ಕಡಿಯುವುದು", "ಗಿಡಗಳನ್ನು ಬೆಳೆಸಿ ಆರೈಕೆ ಮಾಡುವುದು", "ನೀರನ್ನು ವ್ಯರ್ಥ ಮಾಡುವುದು", "ಹೂವುಗಳನ್ನು ಕೀಳುವುದು"),
            correctAnswer = "ಗಿಡಗಳನ್ನು ಬೆಳೆಸಿ ಆರೈಕೆ ಮಾಡುವುದು",
            explanation = "ಪರಿಸರ ಸಂರಕ್ಷಣೆ ಮತ್ತು ಗಿಡಗಳ ಪಾಲನೆ-ಪೋಷಣೆ ಉತ್ತಮ ಅಭ್ಯಾಸವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "fln_6_kan_13",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ನಾನು ಪುಸ್ತಕ ಓದುತ್ತೇನೆ.” ಈ ವಾಕ್ಯದಲ್ಲಿ ಕರ್ತೃ ಯಾರು?",
            options = listOf("ಪುಸ್ತಕ", "ಓದುತ್ತೇನೆ", "ನಾನು", "ಓದು"),
            correctAnswer = "ನಾನು",
            explanation = "ಕ್ರಿಯೆಯನ್ನು ಮಾಡುವ ವ್ಯಕ್ತಿ ಕರ್ತೃ. ಇಲ್ಲಿ 'ನಾನು' ಕರ್ತೃಪದ."
        ),
        QuestionModel(
            id = "fln_6_kan_14",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಖಾಲಿ ಜಾಗವನ್ನು ಸೂಕ್ತ ಪದದಿಂದ ತುಂಬಿ: “ಸೂರ್ಯನು ಪೂರ್ವದಲ್ಲಿ ______.”",
            options = listOf("ಮುಳುಗುತ್ತಾನೆ", "ಉದಯಿಸುತ್ತಾನೆ", "ಮಲಗುತ್ತಾನೆ", "ಓಡುತ್ತಾನೆ"),
            correctAnswer = "ಉದಯಿಸುತ್ತಾನೆ",
            explanation = "ಸೂರ್ಯನು ಪ್ರತಿದಿನ ಬೆಳಗ್ಗೆ ಪೂರ್ವ ದಿಕ್ಕಿನಲ್ಲಿ ಉದಯಿಸುತ್ತಾನೆ."
        ),
        QuestionModel(
            id = "fln_6_kan_15",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ನದಿ” ಪದಕ್ಕೆ ಸಂಬಂಧಿಸಿದ ಸರಿಯಾದ ಅರ್ಥಪೂರ್ಣ ವಾಕ್ಯ ಯಾವುದು?",
            options = listOf("ನದಿಯಲ್ಲಿ ನೀರು ಹರಿಯುತ್ತದೆ.", "ನದಿಯಲ್ಲಿ ಪುಸ್ತಕ ಓದುತ್ತದೆ.", "ನದಿಯಲ್ಲಿ ಗಡಿಯಾರ ನಡೆಯುತ್ತದೆ.", "ನದಿಯಲ್ಲಿ ಮನೆ ಹಾರುತ್ತದೆ."),
            correctAnswer = "ನದಿಯಲ್ಲಿ ನೀರು ಹರಿಯುತ್ತದೆ.",
            explanation = "ನದಿಗಳು ಸದಾ ಹರಿಯುವ ಸಿಹಿನೀರಿನ ನೈಸರ್ಗಿಕ ಜಲಮೂಲಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "fln_6_kan_16",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಯಾರಾದರೂ ನಿಮಗೆ ಕಷ್ಟದಲ್ಲಿ ಸಹಾಯ ಮಾಡಿದಾಗ ಯಾವ ಸೌಜನ್ಯದ ಮಾತನ್ನು ಹೇಳುವುದು ಸೂಕ್ತ?",
            options = listOf("ಹೋಗು", "ಧನ್ಯವಾದಗಳು", "ಬೇಡ", "ಸುಮ್ಮನಿರು"),
            correctAnswer = "ಧನ್ಯವಾದಗಳು",
            explanation = "ನೆರವು ಪಡೆದಾಗ ಕೃತಜ್ಞತೆ ವ್ಯಕ್ತಪಡಿಸಲು 'ಧನ್ಯವಾದಗಳು' (Thank you) ಎಂದು ಹೇಳಬೇಕು."
        ),
        QuestionModel(
            id = "fln_6_kan_17",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ನಿಮ್ಮ ಶಾಲೆಯ ಶಿಕ್ಷಕರನ್ನು ಭೇಟಿಯಾದಾಗ ಯಾವ ರೀತಿಯ ಗೌರವದ ಮಾತು ಸೂಕ್ತ?",
            options = listOf("ನಮಸ್ಕಾರ ಶಿಕ್ಷಕರೇ", "ನೀನು ಯಾರು?", "ಇಲ್ಲಿಂದ ಹೋಗಿ", "ನನಗೆ ಸಂಬಂಧವಿಲ್ಲ"),
            correctAnswer = "ನಮಸ್ಕಾರ ಶಿಕ್ಷಕರೇ",
            explanation = "ಗುರುಹಿರಿಯರಿಗೆ ಆದರದಿಂದ 'ನಮಸ್ಕಾರ' ಹೇಳಿ ವಂದಿಸುವುದು ಶಿಷ್ಟಾಚಾರ."
        ),
        QuestionModel(
            id = "fln_6_kan_18",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ನನ್ನ ಶಾಲೆ ಸ್ವಚ್ಛವಾಗಿದೆ.” ಈ ವಾಕ್ಯವು ಯಾವುದನ್ನು ವಿವರಿಸುತ್ತದೆ?",
            options = listOf("ಶಾಲೆಯ ಸ್ವಚ್ಛತೆಯನ್ನು", "ಮಳೆಯ ಪ್ರಮಾಣವನ್ನು", "ಮಾರುಕಟ್ಟೆಯ ಬೆಲೆಯನ್ನು", "ಆಟದ ಸಮಯವನ್ನು"),
            correctAnswer = "ಶಾಲೆಯ ಸ್ವಚ್ಛತೆಯನ್ನು",
            explanation = "ಈ ವಾಕ್ಯವು ಶಾಲೆಯ ಸುಂದರವಾದ ಹಾಗೂ ಶುಚಿಯಾದ ಪರಿಸರವನ್ನು ವರ್ಣಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_6_kan_19",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಹೊಸಬರ ಬಳಿ ನಿಮ್ಮ ಆತ್ಮಪರಿಚಯವನ್ನು ಆರಂಭಿಸಲು ಸೂಕ್ತವಾದ ವಾಕ್ಯ ಯಾವುದು?",
            options = listOf("ನನ್ನ ಹೆಸರು ರವಿ.", "ಬಾಗಿಲು ಮುಚ್ಚು.", "ಪುಸ್ತಕ ಎಲ್ಲಿದೆ?", "ಮಳೆ ಬರುತ್ತಿದೆ."),
            correctAnswer = "ನನ್ನ ಹೆಸರು ರವಿ.",
            explanation = "ಸ್ವಪರಿಚಯ ಮಾಡಿಕೊಳ್ಳುವಾಗ ಮೊದಲು ನಮ್ಮ ಹೆಸರನ್ನು ಸ್ಪಷ್ಟವಾಗಿ ತಿಳಿಸಬೇಕು."
        ),
        QuestionModel(
            id = "fln_6_kan_20",
            stdId = 6,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸರಳ ವಾಕ್ಯವನ್ನು ಪೂರ್ಣಗೊಳಿಸಿ: “ನಾವು ಅಮೂಲ್ಯವಾದ ನೀರನ್ನು ______.”",
            options = listOf("ವ್ಯರ್ಥ ಮಾಡಬೇಕು", "ಸಂರಕ್ಷಿಸಬೇಕು", "ಚೆಲ್ಲಬೇಕು", "ಮರೆಮಾಡಬೇಕು"),
            correctAnswer = "ಸಂರಕ್ಷಿಸಬೇಕು",
            explanation = "ನೀರು ಜೀವಾಮೃತವಾಗಿದ್ದು, ಅದನ್ನು ಮಿತವಾಗಿ ಬಳಸಿ ಸಂರಕ್ಷಿಸುವುದು ಪ್ರತಿಯೊಬ್ಬರ ಕರ್ತವ್ಯ."
        ),

        // =========================================================================
        // =========================== 6 STD ENGLISH (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_6_eng_1",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Read: 'Ravi is a student of Class 6. He gets up at 6 o'clock. He brushes his teeth, bathes and eats breakfast. He walks to school with his friend.' Which class does Ravi study in?",
            options = listOf("Class 4", "Class 5", "Class 6", "Class 7"),
            correctAnswer = "Class 6",
            explanation = "The passage explicitly states 'Ravi is a student of Class 6.'"
        ),
        QuestionModel(
            id = "fln_6_eng_2",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What time does Ravi get up every morning?",
            options = listOf("5 o'clock", "6 o'clock", "7 o'clock", "8 o'clock"),
            correctAnswer = "6 o'clock",
            explanation = "The passage says 'He gets up at six o'clock every morning.'"
        ),
        QuestionModel(
            id = "fln_6_eng_3",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "How does Ravi travel to school?",
            options = listOf("By school bus", "By bicycle", "He walks to school", "By car"),
            correctAnswer = "He walks to school",
            explanation = "The text clearly states 'He walks to school with his friend.'"
        ),
        QuestionModel(
            id = "fln_6_eng_4",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Who accompanies Ravi while going to school?",
            options = listOf("His brother", "His friend", "His teacher", "His father"),
            correctAnswer = "His friend",
            explanation = "The passage mentions he walks with his friend."
        ),
        QuestionModel(
            id = "fln_6_eng_5",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Which favorite subjects of Ravi are mentioned in the passage?",
            options = listOf("Science and Social", "Kannada and Hindi", "English and Mathematics", "Art and Physical Education"),
            correctAnswer = "English and Mathematics",
            explanation = "The passage concludes with 'He likes English and Mathematics.'"
        ),
        QuestionModel(
            id = "fln_6_eng_6",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the noun in the sentence: 'The cat sleeps on the mat.'",
            options = listOf("cat", "sleeps", "on", "the"),
            correctAnswer = "cat",
            explanation = "A noun names a person, animal, place or thing. 'Cat' is the naming word."
        ),
        QuestionModel(
            id = "fln_6_eng_7",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct plural form of 'Child':",
            options = listOf("Childs", "Children", "Childes", "Childrens"),
            correctAnswer = "Children",
            explanation = "'Child' forms an irregular plural: 'children'."
        ),
        QuestionModel(
            id = "fln_6_eng_8",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the opposite of 'Difficult'?",
            options = listOf("Hard", "Easy", "Tough", "Heavy"),
            correctAnswer = "Easy",
            explanation = "The direct antonym of difficult is easy."
        ),
        QuestionModel(
            id = "fln_6_eng_9",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank with the correct preposition: 'The book is ______ the table.'",
            options = listOf("on", "at", "underneath of", "in to"),
            correctAnswer = "on",
            explanation = "'On' is used when an object rests upon a surface."
        ),
        QuestionModel(
            id = "fln_6_eng_10",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Select the sentence with correct punctuation:",
            options = listOf("where are you going?", "Where are you going.", "Where are you going?", "Where are you going!"),
            correctAnswer = "Where are you going?",
            explanation = "A question starts with a capital letter and concludes with a question mark."
        ),
        QuestionModel(
            id = "fln_6_eng_11",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Complete the greeting: When you meet someone in the morning, you say: '______'",
            options = listOf("Good night", "Good afternoon", "Good morning", "Goodbye"),
            correctAnswer = "Good morning",
            explanation = "'Good morning' is the standard polite greeting from sunrise till noon."
        ),
        QuestionModel(
            id = "fln_6_eng_12",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Which pronoun replaces 'Ananya' in: 'Ananya sings well. ______ has a sweet voice.'",
            options = listOf("He", "She", "It", "They"),
            correctAnswer = "She",
            explanation = "'She' is the feminine singular third-person pronoun."
        ),
        QuestionModel(
            id = "fln_6_eng_13",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct spelling:",
            options = listOf("Beautifull", "Beautiful", "Beutiful", "Beatiful"),
            correctAnswer = "Beautiful",
            explanation = "'Beautiful' ends with single 'l' in suffix -ful."
        ),
        QuestionModel(
            id = "fln_6_eng_14",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What do you say when you ask for water politely?",
            options = listOf("Give me water now!", "Please give me a glass of water.", "Water here!", "I take water."),
            correctAnswer = "Please give me a glass of water.",
            explanation = "Using 'Please' indicates courteous social communication."
        ),
        QuestionModel(
            id = "fln_6_eng_15",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Find the action verb in: 'Birds fly high in the blue sky.'",
            options = listOf("Birds", "fly", "high", "sky"),
            correctAnswer = "fly",
            explanation = "'Fly' denotes the action performed by the birds."
        ),
        QuestionModel(
            id = "fln_6_eng_16",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Which word rhymes with 'Tree'?",
            options = listOf("Free", "Try", "Tray", "True"),
            correctAnswer = "Free",
            explanation = "'Tree' and 'Free' end with the identical sound /i:/."
        ),
        QuestionModel(
            id = "fln_6_eng_17",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: 'An apple a day keeps the ______ away.'",
            options = listOf("teacher", "doctor", "lawyer", "driver"),
            correctAnswer = "doctor",
            explanation = "This is a famous English health proverb."
        ),
        QuestionModel(
            id = "fln_6_eng_18",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Select the correct article: 'This is ______ honest boy.'",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "an",
            explanation = "'Honest' starts with a silent 'h' and vowel sound /ɒ/, requiring 'an'."
        ),
        QuestionModel(
            id = "fln_6_eng_19",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Past tense form of 'Go' is:",
            options = listOf("Goed", "Gone", "Went", "Going"),
            correctAnswer = "Went",
            explanation = "'Go' is an irregular verb whose simple past tense is 'went'."
        ),
        QuestionModel(
            id = "fln_6_eng_20",
            stdId = 6,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What does the sign 'SILENCE PLEASE' in a library mean?",
            options = listOf("Shout loudly", "Do not make noise", "Listen to songs", "Run around"),
            correctAnswer = "Do not make noise",
            explanation = "Libraries require quiet study environments without noise."
        ),

        // =========================================================================
        // =========================== 6 STD MATHEMATICS (20 MCQs) =================
        // =========================================================================
        QuestionModel(
            id = "fln_6_mat_1",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "4582 ಈ ಸಂಖ್ಯೆಯಲ್ಲಿ '5' ರ ಸ್ಥಾನಬೆಲೆ (Place Value) ಎಷ್ಟು?",
            options = listOf("5", "50", "500", "5000"),
            correctAnswer = "500",
            explanation = "4582 ರಲ್ಲಿ 5 ನೂರರ ಸ್ಥಾನದಲ್ಲಿದೆ, ಆದ್ದರಿಂದ 5 × 100 = 500."
        ),
        QuestionModel(
            id = "fln_6_mat_2",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ನಾಲ್ಕು ಅಂಕಿಗಳ ಅತ್ಯಂತ ದೊಡ್ಡ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("1000", "9999", "9000", "9876"),
            correctAnswer = "9999",
            explanation = "9999 ನಾಲ್ಕು ಅಂಕಿಗಳ ಗರಿಷ್ಠ ಸಂಖ್ಯೆಯಾಗಿದೆ (ಇದಕ್ಕೆ 1 ಕೂಡಿಸಿದರೆ 10000 ಬರುತ್ತದೆ)."
        ),
        QuestionModel(
            id = "fln_6_mat_3",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "3425 + 2354 = ಎಷ್ಟು?",
            options = listOf("5779", "5679", "5769", "5879"),
            correctAnswer = "5779",
            explanation = "3425 + 2354 = (3000+2000) + (400+300) + (20+50) + (5+4) = 5779."
        ),
        QuestionModel(
            id = "fln_6_mat_4",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "7860 - 3420 = ಎಷ್ಟು?",
            options = listOf("4440", "4420", "4340", "4540"),
            correctAnswer = "4440",
            explanation = "7860 - 3420 = 4440."
        ),
        QuestionModel(
            id = "fln_6_mat_5",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ನೋಟ್‌ಬುಕ್ ಬೆಲೆ ₹45 ಆದರೆ, 6 ನೋಟ್‌ಬುಕ್‌ಗಳ ಒಟ್ಟು ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("₹240", "₹260", "₹270", "₹280"),
            correctAnswer = "₹270",
            explanation = "45 × 6 = ₹270."
        ),
        QuestionModel(
            id = "fln_6_mat_6",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "1200 ಚಾಕೊಲೇಟ್‌ಗಳನ್ನು 4 ಶಾಲೆಗಳಿಗೆ ಸಮನಾಗಿ ಹಂಚಿದರೆ, ಪ್ರತಿ ಶಾಲೆಗೆ ಸಿಗುವ ಚಾಕೊಲೇಟ್‌ಗಳು ಎಷ್ಟು?",
            options = listOf("250", "300", "350", "400"),
            correctAnswer = "300",
            explanation = "1200 ÷ 4 = 300 ಚಾಕೊಲೇಟ್‌ಗಳು."
        ),
        QuestionModel(
            id = "fln_6_mat_7",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "3/4 ಭಿನ್ನರಾಶಿಯ ಅರ್ಥವೇನು?",
            options = listOf("4 ಸಮಭಾಗಗಳಲ್ಲಿ 3 ಭಾಗ", "3 ಸಮಭಾಗಗಳಲ್ಲಿ 4 ಭಾಗ", "3 ಮತ್ತು 4 ರ ಗುಣಲಬ್ಧ", "4 ರಲ್ಲಿ 1 ಭಾಗ"),
            correctAnswer = "4 ಸಮಭಾಗಗಳಲ್ಲಿ 3 ಭಾಗ",
            explanation = "ಛೇದ 4 ಒಟ್ಟು ಸಮಭಾಗಗಳನ್ನು, ಅಂಶ 3 ತೆಗೆದುಕೊಂಡ ಭಾಗಗಳನ್ನು ಸೂಚಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_6_mat_8",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "1 ಮೀಟರ್‌ನಲ್ಲಿ ಎಷ್ಟು ಸೆಂಟಿಮೀಟರ್‌ಗಳಿರುತ್ತವೆ?",
            options = listOf("10 cm", "100 cm", "1000 cm", "50 cm"),
            correctAnswer = "100 cm",
            explanation = "1 m = 100 cm."
        ),
        QuestionModel(
            id = "fln_6_mat_9",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಚೌಕದ ಪ್ರತಿಯೊಂದು ಬಾಹುವಿನ ಉದ್ದ 5 cm ಆದರೆ, ಅದರ ಸುತ್ತಳತೆ (Perimeter) ಎಷ್ಟು?",
            options = listOf("15 cm", "20 cm", "25 cm", "10 cm"),
            correctAnswer = "20 cm",
            explanation = "ಚೌಕದ ಸುತ್ತಳತೆ = 4 × ಬಾಹು = 4 × 5 cm = 20 cm."
        ),
        QuestionModel(
            id = "fln_6_mat_10",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ದಿನದಲ್ಲಿ ಒಟ್ಟು ಎಷ್ಟು ಗಂಟೆಗಳಿರುತ್ತವೆ?",
            options = listOf("12 ಗಂಟೆ", "24 ಗಂಟೆ", "60 ಗಂಟೆ", "36 ಗಂಟೆ"),
            correctAnswer = "24 ಗಂಟೆ",
            explanation = "ಭೂಮಿಯು ತನ್ನ ಅಕ್ಷದ ಮೇಲೆ ಒಂದು ಸುತ್ತು ಸುತ್ತಲು 24 ಗಂಟೆ (1 ದಿನ) ತೆಗೆದುಕೊಳ್ಳುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_6_mat_11",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "6000 + 400 + 80 + 3 ರ ಸಂಕ್ಷಿಪ್ತ ರೂಪ ಯಾವುದು?",
            options = listOf("6483", "60483", "64803", "6438"),
            correctAnswer = "6483",
            explanation = "ಸ್ಥಾನಬೆಲೆಗಳನ್ನು ಕೂಡಿಸಿದಾಗ 6483 ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_6_mat_12",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಸಮ ಸಂಖ್ಯೆ (Even Number) ಯಾವುದು?",
            options = listOf("135", "247", "588", "991"),
            correctAnswer = "588",
            explanation = "ಬಿಡಿ ಸ್ಥಾನದಲ್ಲಿ 0, 2, 4, 6, 8 ಇರುವ ಸಂಖ್ಯೆಗಳು ಸಮ ಸಂಖ್ಯೆಗಳಾಗಿವೆ. 588 ರ ಬಿಡಿ ಸ್ಥಾನದಲ್ಲಿ 8 ಇದೆ."
        ),
        QuestionModel(
            id = "fln_6_mat_13",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "1 ಕಿಲೋಗ್ರಾಂ (kg) ನಲ್ಲಿ ಎಷ್ಟು ಗ್ರಾಂಗಳಿರುತ್ತವೆ?",
            options = listOf("100 ಗ್ರಾಂ", "500 ಗ್ರಾಂ", "1000 ಗ್ರಾಂ", "2000 ಗ್ರಾಂ"),
            correctAnswer = "1000 ಗ್ರಾಂ",
            explanation = "1 kg = 1000 g."
        ),
        QuestionModel(
            id = "fln_6_mat_14",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಅನಿಲ್ ಬಳಿ ₹500 ಇತ್ತು. ಅವನು ₹265 ಖರ್ಚು ಮಾಡಿದರೆ, ಅವನ ಬಳಿ ಉಳಿದ ಹಣವೆಷ್ಟು?",
            options = listOf("₹235", "₹245", "₹225", "₹255"),
            correctAnswer = "₹235",
            explanation = "500 - 265 = ₹235."
        ),
        QuestionModel(
            id = "fln_6_mat_15",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "250 × 4 = ಎಷ್ಟು?",
            options = listOf("800", "900", "1000", "1250"),
            correctAnswer = "1000",
            explanation = "250 × 4 = 1000."
        ),
        QuestionModel(
            id = "fln_6_mat_16",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಲಂಬಕೋನದ (Right Angle) ಅಳತೆ ಎಷ್ಟು ಡಿಗ್ರಿ?",
            options = listOf("45°", "90°", "180°", "360°"),
            correctAnswer = "90°",
            explanation = "ಸರಿಯಾಗಿ 90 ಡಿಗ್ರಿ ಇರುವ ಕೋನವನ್ನು ಲಂಬಕೋನ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "fln_6_mat_17",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "7/10 ರ ದಶಮಾಂಶ (Decimal) ರೂಪ ಯಾವುದು?",
            options = listOf("0.07", "0.7", "7.0", "7.10"),
            correctAnswer = "0.7",
            explanation = "7 ನ್ನು 10 ರಿಂದ ಭಾಗಿಸಿದಾಗ 0.7 ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_6_mat_18",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ವಾರದಲ್ಲಿ ಎಷ್ಟು ದಿನಗಳಿರುತ್ತವೆ?",
            options = listOf("5", "6", "7", "8"),
            correctAnswer = "7",
            explanation = "ಭಾನುವಾರದಿಂದ ಶನಿವಾರದವರೆಗೆ ವಾರಕ್ಕೆ 7 ದಿನಗಳು."
        ),
        QuestionModel(
            id = "fln_6_mat_19",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "8500 ಸಂಖ್ಯೆಯಲ್ಲಿ 8 ರ ಮುಖಬೆಲೆ (Face Value) ಎಷ್ಟು?",
            options = listOf("8000", "800", "8", "80"),
            correctAnswer = "8",
            explanation = "ಸಂಖ್ಯೆಯ ಮುಖಬೆಲೆಯು ಅದರ ಸ್ಥಾನದ ಮೇಲೆ ಅವಲಂಬಿತವಾಗಿರದೆ ಅಂಕೆಯ ಮೂಲ ಮೌಲ್ಯವೇ ಆಗಿರುತ್ತದೆ (ಅಂದರೆ 8)."
        ),
        QuestionModel(
            id = "fln_6_mat_20",
            stdId = 6,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "48 ನ್ನು 6 ರಿಂದ ಭಾಗಿಸಿದಾಗ ಬರುವ ಭಾಗಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("6", "7", "8", "9"),
            correctAnswer = "8",
            explanation = "48 ÷ 6 = 8 (ಏಕೆಂದರೆ 6 × 8 = 48)."
        ),

        // =========================================================================
        // =========================== 7 STD KANNADA (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_7_kan_1",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ಪಠ್ಯವನ್ನು ಓದಿ: 'ರಮ್ಯಾ ಏಳನೇ ತರಗತಿಯಲ್ಲಿ ಓದುತ್ತಿದ್ದಾಳೆ. ಅವಳು ಪ್ರತಿದಿನ ಬೆಳಿಗ್ಗೆ ಬೇಗ ಎದ್ದು, ತನ್ನ ಮನೆಯ ಸುತ್ತಮುತ್ತಲಿನ ಪರಿಸರವನ್ನು ಸ್ವಚ್ಛವಾಗಿಡುತ್ತಾಳೆ.' ರಮ್ಯಾ ಯಾವ ತರಗತಿಯಲ್ಲಿ ಓದುತ್ತಿದ್ದಾಳೆ?",
            options = listOf("ಐದನೇ ತರಗತಿ", "ಆರನೇ ತರಗತಿ", "ಏಳನೇ ತರಗತಿ", "ಎಂಟನೇ ತರಗತಿ"),
            correctAnswer = "ಏಳನೇ ತರಗತಿ",
            explanation = "ಪಠ್ಯದ ಪ್ರಕಾರ ರಮ್ಯಾ ಏಳನೇ ತರಗತಿಯಲ್ಲಿ ಓದುತ್ತಿದ್ದಾಳೆ."
        ),
        QuestionModel(
            id = "fln_7_kan_2",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ರಮ್ಯಾ ಬೆಳಿಗ್ಗೆ ಎದ್ದು ಯಾವ ಕೆಲಸ ಮಾಡುತ್ತಾಳೆ?",
            options = listOf("ದೂರದರ್ಶನ ನೋಡುತ್ತಾಳೆ", "ಪರಿಸರವನ್ನು ಸ್ವಚ್ಛವಾಗಿಡುತ್ತಾಳೆ", "ಆಟವಾಡುತ್ತಾಳೆ", "ಮಾರುಕಟ್ಟೆಗೆ ಹೋಗುತ್ತಾಳೆ"),
            correctAnswer = "ಪರಿಸರವನ್ನು ಸ್ವಚ್ಛವಾಗಿಡುತ್ತಾಳೆ",
            explanation = "ರಮ್ಯಾ ಬೆಳಿಗ್ಗೆ ಎದ್ದು ತನ್ನ ಮನೆಯ ಸುತ್ತಮುತ್ತಲಿನ ಪರಿಸರವನ್ನು ಸ್ವಚ್ಛವಾಗಿಡುತ್ತಾಳೆ."
        ),
        QuestionModel(
            id = "fln_7_kan_3",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ರಮ್ಯಾ ಶಾಲೆಗೆ ಹೋಗುವ ಮೊದಲು ಏನು ಮಾಡುತ್ತಾಳೆ?",
            options = listOf("ಗಿಡಗಳಿಗೆ ನೀರು ಹಾಕುತ್ತಾಳೆ", "ಅಂಗಡಿಗೆ ಹೋಗುತ್ತಾಳೆ", "ಮಲಗುತ್ತಾಳೆ", "ಚಿತ್ರಮಂದಿರಕ್ಕೆ ಹೋಗುತ್ತಾಳೆ"),
            correctAnswer = "ಗಿಡಗಳಿಗೆ ನೀರು ಹಾಕುತ್ತಾಳೆ",
            explanation = "ಶಾಲೆಗೆ ಹೋಗುವ ಮುನ್ನ ರಮ್ಯಾ ಗಿಡಗಳಿಗೆ ನೀರು ಹಾಕುತ್ತಾಳೆ."
        ),
        QuestionModel(
            id = "fln_7_kan_4",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ರಮ್ಯಾಳಿಗೆ ಯಾವ ಪುಸ್ತಕಗಳನ್ನು ಓದುವುದು ಇಷ್ಟ?",
            options = listOf("ವಿಜ್ಞಾನ ಪುಸ್ತಕಗಳು ಮಾತ್ರ", "ಇಂಗ್ಲಿಷ್ ಪುಸ್ತಕಗಳು ಮಾತ್ರ", "ಕನ್ನಡ ಪುಸ್ತಕಗಳು", "ಗಣಿತ ಪುಸ್ತಕಗಳು ಮಾತ್ರ"),
            correctAnswer = "ಕನ್ನಡ ಪುಸ್ತಕಗಳು",
            explanation = "ಅವಳಿಗೆ ಕನ್ನಡ ಪುಸ್ತಕಗಳನ್ನು ಓದುವುದು ಬಹಳ ಇಷ್ಟ."
        ),
        QuestionModel(
            id = "fln_7_kan_5",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ರಮ್ಯಾ ಶಾಲೆಯಲ್ಲಿ ನಡೆಯುವ ಯಾವ ಕಾರ್ಯಕ್ರಮಗಳಲ್ಲಿ ಭಾಗವಹಿಸುತ್ತಾಳೆ?",
            options = listOf("ಕ್ರೀಡಾ ಕಾರ್ಯಕ್ರಮಗಳಲ್ಲಿ ಮಾತ್ರ", "ಪರಿಸರ ಸಂರಕ್ಷಣಾ ಕಾರ್ಯಕ್ರಮಗಳಲ್ಲಿ", "ಸಂಗೀತ ಕಾರ್ಯಕ್ರಮಗಳಲ್ಲಿ ಮಾತ್ರ", "ವ್ಯಾಪಾರ ಕಾರ್ಯಕ್ರಮಗಳಲ್ಲಿ"),
            correctAnswer = "ಪರಿಸರ ಸಂರಕ್ಷಣಾ ಕಾರ್ಯಕ್ರಮಗಳಲ್ಲಿ",
            explanation = "ಶಾಲೆಯಲ್ಲಿ ನಡೆಯುವ ಪರಿಸರ ಸಂರಕ್ಷಣಾ ಕಾರ್ಯಕ್ರಮಗಳಲ್ಲಿ ಉತ್ಸಾಹದಿಂದ ಭಾಗವಹಿಸುತ್ತಾಳೆ."
        ),
        QuestionModel(
            id = "fln_7_kan_6",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಧೈರ್ಯ” ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಸಾಹಸ", "ಶೌರ್ಯ", "ಭಯ", "ಬಲ"),
            correctAnswer = "ಭಯ",
            explanation = "ಧೈರ್ಯ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಭಯ."
        ),
        QuestionModel(
            id = "fln_7_kan_7",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಸೂರ್ಯ” ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಚಂದ್ರ", "ರವಿ", "ನಕ್ಷತ್ರ", "ಆಕಾಶ"),
            correctAnswer = "ರವಿ",
            explanation = "ಸೂರ್ಯ ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ರವಿ, ಭಾನು, ದಿನಕರ."
        ),
        QuestionModel(
            id = "fln_7_kan_8",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಮಗು” ಪದದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ಮಗುವಿನ", "ಮಕ್ಕಳು", "ಮಗುವಿಗೆ", "ಮಗುವನ್ನು"),
            correctAnswer = "ಮಕ್ಕಳು",
            explanation = "ಮಗು ಪದದ ಸರಿಯಾದ ಬಹುವಚನ ರೂಪ 'ಮಕ್ಕಳು'."
        ),
        QuestionModel(
            id = "fln_7_kan_9",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಅವಳು ಹಾಡನ್ನು ಹಾಡಿದಳು.” ಈ ವಾಕ್ಯದಲ್ಲಿನ ಕ್ರಿಯಾಪದ ಯಾವುದು?",
            options = listOf("ಅವಳು", "ಹಾಡನ್ನು", "ಹಾಡಿದಳು", "ಈ"),
            correctAnswer = "ಹಾಡಿದಳು",
            explanation = "ಕ್ರಿಯೆಯನ್ನು ಸೂಚಿಸುವ ಪದ 'ಹಾಡಿದಳು' ಕ್ರಿಯಾಪದ."
        ),
        QuestionModel(
            id = "fln_7_kan_10",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ರಾಮನು ಶಾಲೆಗೆ ಹೋದನು.” ಈ ವಾಕ್ಯದಲ್ಲಿನ ಕರ್ತೃ ಯಾರು?",
            options = listOf("ರಾಮನು", "ಶಾಲೆಗೆ", "ಹೋದನು", "ಶಾಲೆ"),
            correctAnswer = "ರಾಮನು",
            explanation = "ಕ್ರಿಯೆಯನ್ನು ಮಾಡುವ ವ್ಯಕ್ತಿ ಕರ್ತೃ. ಇಲ್ಲಿ 'ರಾಮನು' ಕರ್ತೃ."
        ),
        QuestionModel(
            id = "fln_7_kan_11",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸರಿಯಾದ ಕಾಗುಣಿತ ಹೊಂದಿರುವ ಶುದ್ಧ ಪದವನ್ನು ಆಯ್ಕೆಮಾಡಿ.",
            options = listOf("ಪರಿಸರ", "ಪರೀಸರ", "ಪರೀಷರ", "ಪರೀಸರಂ"),
            correctAnswer = "ಪರಿಸರ",
            explanation = "'ಪರಿಸರ' ಸರಿಯಾದ ಕಾಗುಣಿತ ರೂಪವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "fln_7_kan_12",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ನಾನು ನಾಳೆ ಮೈಸೂರಿಗೆ ______.” ಖಾಲಿ ಜಾಗಕ್ಕೆ ಸೂಕ್ತ ಭವಿಷ್ಯತ್ಕಾಲದ ಪದ ಯಾವುದು?",
            options = listOf("ಹೋದೆನು", "ಹೋಗುತ್ತೇನೆ", "ಹೋಗಿದ್ದೆನು", "ಹೋದನು"),
            correctAnswer = "ಹೋಗುತ್ತೇನೆ",
            explanation = "ನಾಳೆ (ಮುಂದಿನ ದಿನ) ಕ್ರಿಯೆಯನ್ನು ಸೂಚಿಸಲು 'ಹೋಗುತ್ತೇನೆ' ಬಳಸಬೇಕು."
        ),
        QuestionModel(
            id = "fln_7_kan_13",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಮಕ್ಕಳು ಮೈದಾನದಲ್ಲಿ ಆಟವಾಡುತ್ತಿದ್ದಾರೆ.” ಈ ವಾಕ್ಯವು ಯಾವ ಕಾಲವನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಭೂತಕಾಲ", "ವರ್ತಮಾನಕಾಲ", "ಭವಿಷ್ಯತ್ಕಾಲ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ವರ್ತಮಾನಕಾಲ",
            explanation = "ಪ್ರಸ್ತುತ ನಡೆಯುತ್ತಿರುವ ಆಟದ ಕ್ರಿಯೆಯನ್ನು ಸೂಚಿಸುವುದರಿಂದ ವರ್ತಮಾನಕಾಲ."
        ),
        QuestionModel(
            id = "fln_7_kan_14",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಪ್ರಾಮಾಣಿಕ” ಪದದ ಅರ್ಥಕ್ಕೆ ಹತ್ತಿರವಾದ ಪದ ಯಾವುದು?",
            options = listOf("ಸುಳ್ಳುಗಾರ", "ಸತ್ಯವಂತ", "ಸೋಮಾರಿ", "ಕೋಪಿಷ್ಠ"),
            correctAnswer = "ಸತ್ಯವಂತ",
            explanation = "ಪ್ರಾಮಾಣಿಕ ಎಂದರೆ ಸತ್ಯವಂತ, ನಿಷ್ಠಾವಂತ."
        ),
        QuestionModel(
            id = "fln_7_kan_15",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಪ್ರಶ್ನಾರ್ಥಕ ವಾಕ್ಯವನ್ನು ಗುರುತಿಸಿ.",
            options = listOf("ಇಂದು ಮಳೆ ಬರುತ್ತದೆ.", "ನಾನು ಪುಸ್ತಕ ಓದುತ್ತೇನೆ.", "ನೀನು ಎಲ್ಲಿಗೆ ಹೋಗುತ್ತಿದ್ದೀಯ?", "ಅವನು ಒಳ್ಳೆಯ ವಿದ್ಯಾರ್ಥಿ."),
            correctAnswer = "ನೀನು ಎಲ್ಲಿಗೆ ಹೋಗುತ್ತಿದ್ದೀಯ?",
            explanation = "'ನೀನು ಎಲ್ಲಿಗೆ ಹೋಗುತ್ತಿದ್ದೀಯ?' ಎಂಬುದು ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆಯುಳ್ಳ ಪ್ರಶ್ನೆ ವಾಕ್ಯ."
        ),
        QuestionModel(
            id = "fln_7_kan_16",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಯಾರಾದರೂ ನಿಮಗೆ ಸಹಾಯ ಮಾಡಿದಾಗ ಯಾವ ಸೌಜನ್ಯದ ಮಾತನ್ನು ಹೇಳುವುದು ಸೂಕ್ತ?",
            options = listOf("ಕ್ಷಮಿಸಿ", "ಧನ್ಯವಾದಗಳು", "ಹೋಗಿ ಬನ್ನಿ", "ನನಗೆ ಬೇಡ"),
            correctAnswer = "ಧನ್ಯವಾದಗಳು",
            explanation = "ನೆರವು ಪಡೆದಾಗ ಕೃತಜ್ಞತೆಯಿಂದ 'ಧನ್ಯವಾದಗಳು' ಹೇಳಬೇಕು."
        ),
        QuestionModel(
            id = "fln_7_kan_17",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಶಾಲೆಯಲ್ಲಿ ಸ್ನೇಹಿತನಿಗೆ ಪೆನ್ನು ಬೇಕಾದಾಗ ನೀವು ಹೇಗೆ ವಿನಯವಾಗಿ ಕೇಳಬಹುದು?",
            options = listOf("ನಿನ್ನ ಪೆನ್ನು ಕೊಡು, ಇಲ್ಲದಿದ್ದರೆ ನೋಡು!", "ದಯವಿಟ್ಟು ನಿನ್ನ ಪೆನ್ನನ್ನು ಸ್ವಲ್ಪ ಕೊಡುತ್ತೀಯಾ?", "ನನಗೆ ಪೆನ್ನು ಬೇಕಿಲ್ಲ.", "ಪೆನ್ನನ್ನು ಎಸೆದುಬಿಡು."),
            correctAnswer = "ದಯವಿಟ್ಟು ನಿನ್ನ ಪೆನ್ನನ್ನು ಸ್ವಲ್ಪ ಕೊಡುತ್ತೀಯಾ?",
            explanation = "ದಯವಿಟ್ಟು ಎಂದು ವಿನಯದಿಂದ ಕೇಳುವುದು ಸಭ್ಯ ಸಂವಹನ."
        ),
        QuestionModel(
            id = "fln_7_kan_18",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಪರಿಸರ ಸಂರಕ್ಷಣೆಗೆ ಸಹಾಯಕವಾದ ಉತ್ತಮ ಅಭ್ಯಾಸ ಯಾವುದು?",
            options = listOf("ಎಲ್ಲೆಂದರಲ್ಲಿ ಕಸ ಎಸೆಯುವುದು", "ನೀರನ್ನು ವ್ಯರ್ಥ ಮಾಡುವುದು", "ಗಿಡಗಳನ್ನು ನೆಟ್ಟು ಬೆಳೆಸುವುದು", "ಮರಗಳನ್ನು ಅನಗತ್ಯವಾಗಿ ಕಡಿಯುವುದು"),
            correctAnswer = "ಗಿಡಗಳನ್ನು ನೆಟ್ಟು ಬೆಳೆಸುವುದು",
            explanation = "ಗಿಡಮರಗಳನ್ನು ನೆಟ್ಟು ಪೋಷಿಸುವುದು ಪರಿಸರ ಸಂರಕ್ಷಣೆಯ ಅತ್ಯುತ್ತಮ ವಿಧಾನ."
        ),
        QuestionModel(
            id = "fln_7_kan_19",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ವ್ಯಾಕರಣಬದ್ಧವಾದ ಸರಿಯಾದ ವಾಕ್ಯವನ್ನು ಆಯ್ಕೆಮಾಡಿ.",
            options = listOf("ನಾವು ಪ್ರತಿದಿನ ಶಾಲೆಗೆ ಹೋಗುತ್ತೇನೆ.", "ನಾವು ಪ್ರತಿದಿನ ಶಾಲೆಗೆ ಹೋಗುತ್ತಾನೆ.", "ನಾವು ಪ್ರತಿದಿನ ಶಾಲೆಗೆ ಹೋಗುತ್ತೇವೆ.", "ನಾವು ಪ್ರತಿದಿನ ಶಾಲೆಗೆ ಹೋಗುತ್ತಾಳೆ."),
            correctAnswer = "ನಾವು ಪ್ರತಿದಿನ ಶಾಲೆಗೆ ಹೋಗುತ್ತೇವೆ.",
            explanation = "'ನಾವು' ಉತ್ತಮ ಪುರುಷ ಬಹುವಚನಕ್ಕೆ 'ಹೋಗುತ್ತೇವೆ' ಕ್ರಿಯಾಪದ ಹೊಂದುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_7_kan_20",
            stdId = 7,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಂದು ಕಥೆಯನ್ನು ಓದಿದ ನಂತರ ಅದರ ಮುಖ್ಯ ಆಶಯವನ್ನು ತಿಳಿದುಕೊಳ್ಳುವುದರಿಂದ ಏನು ಪ್ರಯೋಜನ?",
            options = listOf("ಕಥೆಯ ಅರ್ಥವನ್ನು ಗ್ರಹಿಸಬಹುದು", "ಕಥೆಯನ್ನು ಓದದೆ ಇರಬಹುದು", "ಅಕ್ಷರಗಳನ್ನು ಮರೆತುಬಿಡಬಹುದು", "ಪುಸ್ತಕವನ್ನು ಮುಚ್ಚಬಹುದು"),
            correctAnswer = "ಕಥೆಯ ಅರ್ಥವನ್ನು ಗ್ರಹಿಸಬಹುದು",
            explanation = "ಆಶಯವನ್ನು ಗ್ರಹಿಸುವುದರಿಂದ ಕಥೆಯ ನೈತಿಕ ಪಾಠ ಮತ್ತು ಭಾವಾರ್ಥ ಸ್ಪಷ್ಟವಾಗುತ್ತದೆ."
        ),

        // =========================================================================
        // =========================== 7 STD ENGLISH (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_7_eng_1",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Read: 'Anita is a student of Class 7. She lives in a small village with her family. Every morning, she wakes up early and helps her mother water the plants. She walks to school with her younger brother.' Which class does Anita study in?",
            options = listOf("Class 5", "Class 6", "Class 7", "Class 8"),
            correctAnswer = "Class 7",
            explanation = "The passage directly states 'Anita is a student of Class 7.'"
        ),
        QuestionModel(
            id = "fln_7_eng_2",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Where does Anita live?",
            options = listOf("In a large city", "In a small village", "Near an airport", "In a forest"),
            correctAnswer = "In a small village",
            explanation = "The passage says 'She lives in a small village with her family.'"
        ),
        QuestionModel(
            id = "fln_7_eng_3",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What does Anita do every morning?",
            options = listOf("Watches television", "Plays video games", "Helps water the plants", "Goes shopping"),
            correctAnswer = "Helps water the plants",
            explanation = "Anita helps her mother water the plants every morning."
        ),
        QuestionModel(
            id = "fln_7_eng_4",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "With whom does Anita walk to school?",
            options = listOf("Her elder sister", "Her father", "Her friend", "Her younger brother"),
            correctAnswer = "Her younger brother",
            explanation = "The text states 'She walks to school with her younger brother.'"
        ),
        QuestionModel(
            id = "fln_7_eng_5",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What kind of student is Anita based on the passage?",
            options = listOf("Helpful and responsible", "Careless and lazy", "Rude and unkind", "Dishonest and selfish"),
            correctAnswer = "Helpful and responsible",
            explanation = "Anita keeps her classroom clean and helps classmates, showing helpfulness and responsibility."
        ),
        QuestionModel(
            id = "fln_7_eng_6",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the opposite of “brave”.",
            options = listOf("Bold", "Courageous", "Cowardly", "Strong"),
            correctAnswer = "Cowardly",
            explanation = "The direct antonym of brave is cowardly."
        ),
        QuestionModel(
            id = "fln_7_eng_7",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the synonym of “happy”.",
            options = listOf("Sad", "Joyful", "Angry", "Tired"),
            correctAnswer = "Joyful",
            explanation = "Happy and joyful both describe feeling pleasure and contentment."
        ),
        QuestionModel(
            id = "fln_7_eng_8",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct plural form of “mouse”.",
            options = listOf("Mouses", "Mouse", "Mice", "Mices"),
            correctAnswer = "Mice",
            explanation = "The irregular plural form of mouse is mice."
        ),
        QuestionModel(
            id = "fln_7_eng_9",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: “She ______ to school every day.”",
            options = listOf("go", "goes", "going", "gone"),
            correctAnswer = "goes",
            explanation = "Third-person singular 'She' with daily habit takes simple present 'goes'."
        ),
        QuestionModel(
            id = "fln_7_eng_10",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the verb in the sentence: “The children played football.”",
            options = listOf("The", "Children", "Played", "Football"),
            correctAnswer = "Played",
            explanation = "'Played' is the action word showing what the children did."
        ),
        QuestionModel(
            id = "fln_7_eng_11",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct article: “He is ______ honest man.”",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "an",
            explanation = "'Honest' begins with a silent 'h' and vowel sound /ɒ/, requiring 'an'."
        ),
        QuestionModel(
            id = "fln_7_eng_12",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: “Yesterday, we ______ a movie.”",
            options = listOf("watch", "watches", "watched", "watching"),
            correctAnswer = "watched",
            explanation = "'Yesterday' indicates past time, requiring the simple past verb 'watched'."
        ),
        QuestionModel(
            id = "fln_7_eng_13",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct pronoun: “Ravi and I are friends. ______ study together.”",
            options = listOf("They", "He", "We", "She"),
            correctAnswer = "We",
            explanation = "'Ravi and I' refers to the speaker and another person, replaced by 'We'."
        ),
        QuestionModel(
            id = "fln_7_eng_14",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correctly spelled word.",
            options = listOf("Enviroment", "Environment", "Envirnoment", "Environmant"),
            correctAnswer = "Environment",
            explanation = "The correct spelling includes the letter 'n': Environment."
        ),
        QuestionModel(
            id = "fln_7_eng_15",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the adjective in the sentence: “The beautiful bird sang sweetly.”",
            options = listOf("Bird", "Sang", "Beautiful", "Sweetly"),
            correctAnswer = "Beautiful",
            explanation = "'Beautiful' describes the appearance of the noun 'bird'."
        ),
        QuestionModel(
            id = "fln_7_eng_16",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the grammatically correct sentence.",
            options = listOf("He do his homework daily.", "He does his homework daily.", "He doing his homework daily.", "He done his homework daily."),
            correctAnswer = "He does his homework daily.",
            explanation = "Subject 'He' takes the singular auxiliary/verb 'does'."
        ),
        QuestionModel(
            id = "fln_7_eng_17",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Which is the most polite way to ask for help?",
            options = listOf("Help me now!", "You must help me.", "Could you please help me?", "Do not speak to me."),
            correctAnswer = "Could you please help me?",
            explanation = "'Could you please...' is the polite, respectful way to request assistance."
        ),
        QuestionModel(
            id = "fln_7_eng_18",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the appropriate response to “How are you?”",
            options = listOf("I am fine, thank you.", "Good night.", "See you yesterday.", "I am a school."),
            correctAnswer = "I am fine, thank you.",
            explanation = "'I am fine, thank you' is the standard polite reply to 'How are you?'."
        ),
        QuestionModel(
            id = "fln_7_eng_19",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct question word: “______ do you go to school?”",
            options = listOf("Where", "When", "Who", "Which"),
            correctAnswer = "When",
            explanation = "'When' asks about the time of going to school."
        ),
        QuestionModel(
            id = "fln_7_eng_20",
            stdId = 7,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Which sentence expresses a good environmental habit?",
            options = listOf("We should throw plastic into rivers.", "We should waste electricity.", "We should plant trees and save water.", "We should burn all the waste."),
            correctAnswer = "We should plant trees and save water.",
            explanation = "Planting trees and conserving water preserves our natural environment."
        ),

        // =========================================================================
        // =========================== 7 STD MATHEMATICS (20 MCQs) =================
        // =========================================================================
        QuestionModel(
            id = "fln_7_mat_1",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "48,576 ಸಂಖ್ಯೆಯಲ್ಲಿ 8ರ ಸ್ಥಾನಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("8", "80", "800", "8,000"),
            correctAnswer = "8,000",
            explanation = "8 ಸಾವಿರದ ಸ್ಥಾನದಲ್ಲಿದೆ, ಆದ್ದರಿಂದ 8 × 1000 = 8,000."
        ),
        QuestionModel(
            id = "fln_7_mat_2",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "23,456 + 14,789 = ?",
            options = listOf("37,245", "38,245", "38,145", "39,245"),
            correctAnswer = "38,245",
            explanation = "23,456 + 14,789 = 38,245."
        ),
        QuestionModel(
            id = "fln_7_mat_3",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "50,000 − 27,685 = ?",
            options = listOf("22,315", "23,315", "22,415", "21,315"),
            correctAnswer = "22,315",
            explanation = "50,000 - 27,685 = 22,315."
        ),
        QuestionModel(
            id = "fln_7_mat_4",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "246 × 35 = ?",
            options = listOf("8,510", "8,610", "8,710", "8,810"),
            correctAnswer = "8,610",
            explanation = "246 × 35 = 8,610."
        ),
        QuestionModel(
            id = "fln_7_mat_5",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "4,536 ÷ 18 = ?",
            options = listOf("242", "252", "262", "272"),
            correctAnswer = "252",
            explanation = "4,536 ÷ 18 = 252 (ಏಕೆಂದರೆ 18 × 252 = 4,536)."
        ),
        QuestionModel(
            id = "fln_7_mat_6",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ದಶಮಾಂಶಗಳಲ್ಲಿ ಅತಿ ಚಿಕ್ಕ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("0.75", "0.57", "0.705", "0.675"),
            correctAnswer = "0.57",
            explanation = "ಹತ್ತನೇ ಸ್ಥಾನದಲ್ಲಿ 5 ಇರುವುದರಿಂದ 0.57 ಇವೆಲ್ಲವುಗಳಿಗಿಂತ ಚಿಕ್ಕದು."
        ),
        QuestionModel(
            id = "fln_7_mat_7",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "24 ಮತ್ತು 36ರ ಮಹತ್ತರ ಸಾಮಾನ್ಯ ಅಪವರ್ತಕ (HCF / ಮ.ಸಾ.ಅ) ಎಷ್ಟು?",
            options = listOf("6", "8", "12", "18"),
            correctAnswer = "12",
            explanation = "24 ಮತ್ತು 36 ಎರಡನ್ನೂ ಭಾಗಿಸುವ ಗರಿಷ್ಠ ಸಾಮಾನ್ಯ ಸಂಖ್ಯೆ 12."
        ),
        QuestionModel(
            id = "fln_7_mat_8",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "6 ಮತ್ತು 8ರ ಕನಿಷ್ಠ ಸಾಮಾನ್ಯ ಅಪವರ್ತ್ಯ (LCM / ಲ.ಸಾ.ಅ) ಎಷ್ಟು?",
            options = listOf("12", "18", "24", "48"),
            correctAnswer = "24",
            explanation = "6 ಮತ್ತು 8 ರ ಗುಣಕಗಳಲ್ಲಿ ಕನಿಷ್ಠ ಸಾಮಾನ್ಯ ಸಂಖ್ಯೆ 24 (6 × 4 = 24, 8 × 3 = 24)."
        ),
        QuestionModel(
            id = "fln_7_mat_9",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "3/4 + 1/4 = ?",
            options = listOf("1/2", "1", "3/8", "4/8"),
            correctAnswer = "1",
            explanation = "(3 + 1) / 4 = 4 / 4 = 1."
        ),
        QuestionModel(
            id = "fln_7_mat_10",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "5/6 − 1/3 = ?",
            options = listOf("1/2", "2/3", "1/3", "5/3"),
            correctAnswer = "1/2",
            explanation = "5/6 - 2/6 = 3/6 = 1/2."
        ),
        QuestionModel(
            id = "fln_7_mat_11",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "0.25 ಅನ್ನು ಸಂಕ್ಷಿಪ್ತ ಭಿನ್ನರಾಶಿಯಲ್ಲಿ ಬರೆದಾಗ ಯಾವುದು ಸರಿಯಾಗಿರುತ್ತದೆ?",
            options = listOf("1/2", "1/4", "3/4", "2/5"),
            correctAnswer = "1/4",
            explanation = "0.25 = 25/100 = 1/4."
        ),
        QuestionModel(
            id = "fln_7_mat_12",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "200 ರ 15% ಎಷ್ಟು?",
            options = listOf("15", "20", "30", "40"),
            correctAnswer = "30",
            explanation = "(15 / 100) × 200 = 15 × 2 = 30."
        ),
        QuestionModel(
            id = "fln_7_mat_13",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಪುಸ್ತಕದ ಬೆಲೆ ₹85. ಇಂತಹ 12 ಪುಸ್ತಕಗಳ ಒಟ್ಟು ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("₹920", "₹1,020", "₹1,120", "₹1,220"),
            correctAnswer = "₹1,020",
            explanation = "85 × 12 = ₹1,020."
        ),
        QuestionModel(
            id = "fln_7_mat_14",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಬ್ಬ ರೈತನು 2,450 ಕೆ.ಜಿ. ಅಕ್ಕಿಯನ್ನು 25 ಕೆ.ಜಿ. ಸಾಮರ್ಥ್ಯದ ಚೀಲಗಳಲ್ಲಿ ತುಂಬಿದನು. ಎಷ್ಟು ಚೀಲಗಳು ಬೇಕಾಗುತ್ತವೆ?",
            options = listOf("88", "96", "98", "108"),
            correctAnswer = "98",
            explanation = "2,450 ÷ 25 = 98 ಚೀಲಗಳು."
        ),
        QuestionModel(
            id = "fln_7_mat_15",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಬಸ್ಸು ಬೆಳಿಗ್ಗೆ 8:35ಕ್ಕೆ ಹೊರಟು 11:20ಕ್ಕೆ ತಲುಪಿತು. ಒಟ್ಟು ಪ್ರಯಾಣದ ಅವಧಿ ಎಷ್ಟು?",
            options = listOf("2 ಗಂಟೆ 35 ನಿಮಿಷ", "2 ಗಂಟೆ 45 ನಿಮಿಷ", "3 ಗಂಟೆ 15 ನಿಮಿಷ", "3 ಗಂಟೆ 25 ನಿಮಿಷ"),
            correctAnswer = "2 ಗಂಟೆ 45 ನಿಮಿಷ",
            explanation = "8:35 ರಿಂದ 11:20 ರವರೆಗೆ = 2 ಗಂಟೆ 45 ನಿಮಿಷಗಳು (8:35 + 2h25m = 11:00 + 20m = 11:20)."
        ),
        QuestionModel(
            id = "fln_7_mat_16",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಆಯತದ ಉದ್ದ 15 ಮೀಟರ್ ಮತ್ತು ಅಗಲ 9 ಮೀಟರ್. ಅದರ ವಿಸ್ತೀರ್ಣ ಎಷ್ಟು?",
            options = listOf("24 ಚ.ಮೀ.", "48 ಚ.ಮೀ.", "120 ಚ.ಮೀ.", "135 ಚ.ಮೀ."),
            correctAnswer = "135 ಚ.ಮೀ.",
            explanation = "ಆಯತದ ವಿಸ್ತೀರ್ಣ = ಉದ್ದ × ಅಗಲ = 15 × 9 = 135 ಚದರ ಮೀಟರ್ (ಚ.ಮೀ.)."
        ),
        QuestionModel(
            id = "fln_7_mat_17",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಚೌಕದ ಒಂದು ಬದಿಯ ಉದ್ದ 12 ಸೆಂ.ಮೀ. ಇದ್ದರೆ ಅದರ ಪರಿಧಿ (ಸುತ್ತಳತೆ) ಎಷ್ಟು?",
            options = listOf("24 ಸೆಂ.ಮೀ.", "36 ಸೆಂ.ಮೀ.", "48 ಸೆಂ.ಮೀ.", "144 ಸೆಂ.ಮೀ."),
            correctAnswer = "48 ಸೆಂ.ಮೀ.",
            explanation = "ಚೌಕದ ಪರಿಧಿ = 4 × ಬಾಹು = 4 × 12 = 48 ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "fln_7_mat_18",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಬ್ಬ ವಿದ್ಯಾರ್ಥಿ ಗಣಿತದಲ್ಲಿ 78, ವಿಜ್ಞಾನದಲ್ಲಿ 85 ಮತ್ತು ಕನ್ನಡದಲ್ಲಿ 72 ಅಂಕಗಳನ್ನು ಪಡೆದನು. ಮೂರು ವಿಷಯಗಳ ಒಟ್ಟು ಅಂಕಗಳು ಎಷ್ಟು?",
            options = listOf("225", "230", "235", "245"),
            correctAnswer = "235",
            explanation = "78 + 85 + 72 = 235 ಅಂಕಗಳು."
        ),
        QuestionModel(
            id = "fln_7_mat_19",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಅಂಗಡಿಯಲ್ಲಿ ಒಂದು ಬ್ಯಾಗಿನ ಬೆಲೆ ₹800. ಅದರ ಮೇಲೆ 10% ರಿಯಾಯಿತಿ ನೀಡಿದರೆ ಗ್ರಾಹಕನು ಪಾವತಿಸಬೇಕಾದ ಹಣ ಎಷ್ಟು?",
            options = listOf("₹700", "₹720", "₹750", "₹780"),
            correctAnswer = "₹720",
            explanation = "ರಿಯಾಯಿತಿ = ₹800 ರ 10% = ₹80. ಪಾವತಿಸಬೇಕಾದ ಹಣ = ₹800 - ₹80 = ₹720."
        ),
        QuestionModel(
            id = "fln_7_mat_20",
            stdId = 7,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ತರಗತಿಯಲ್ಲಿ 40 ವಿದ್ಯಾರ್ಥಿಗಳಿದ್ದಾರೆ. ಅವರಲ್ಲಿ 60% ವಿದ್ಯಾರ್ಥಿನಿಯರಾಗಿದ್ದರೆ ವಿದ್ಯಾರ್ಥಿನಿಯರ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("16", "20", "24", "28"),
            correctAnswer = "24",
            explanation = "ವಿದ್ಯಾರ್ಥಿನಿಯರ ಸಂಖ್ಯೆ = 40 ರ 60% = (60 / 100) × 40 = 24."
        ),

        // =========================================================================
        // =========================== 8 STD KANNADA (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_8_kan_1",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಉದಾರ” ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ದಯಾಳು", "ಸಹೃದಯ", "ಜಿಪುಣ", "ಸಜ್ಜನ"),
            correctAnswer = "ಜಿಪುಣ",
            explanation = "ಉದಾರ (ದಾನಶೀಲ) ದ ವಿರುದ್ಧ ಪದ ಜಿಪುಣ (ಲೋಭಿ)."
        ),
        QuestionModel(
            id = "fln_8_kan_2",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಸಮುದ್ರ” ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಸಾಗರ", "ಪರ್ವತ", "ಅರಣ್ಯ", "ಮರುಭೂಮಿ"),
            correctAnswer = "ಸಾಗರ",
            explanation = "ಸಮುದ್ರ ಎಂದರೆ ಸಾಗರ, ಕಡಲು, ವಾರಿಧಿ, ಅಂಬುಧಿ."
        ),
        QuestionModel(
            id = "fln_8_kan_3",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಮರ” ಪದದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ಮರದ", "ಮರಕ್ಕೆ", "ಮರಗಳು", "ಮರದಿಂದ"),
            correctAnswer = "ಮರಗಳು",
            explanation = "ಮರ ಪದಕ್ಕೆ 'ಗಳು' ಪ್ರತ್ಯಯ ಸೇರಿ 'ಮರಗಳು' ಬಹುವಚನವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_8_kan_4",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ವಿದ್ಯಾರ್ಥಿಗಳು ಪರೀಕ್ಷೆಯನ್ನು ಬರೆದರು.” ಈ ವಾಕ್ಯದಲ್ಲಿನ ಕ್ರಿಯಾಪದ ಯಾವುದು?",
            options = listOf("ವಿದ್ಯಾರ್ಥಿಗಳು", "ಪರೀಕ್ಷೆಯನ್ನು", "ಬರೆದರು", "ಈ"),
            correctAnswer = "ಬರೆದರು",
            explanation = "ಕ್ರಿಯೆಯನ್ನು (ಬರೆಯುವ ಕೆಲಸ) ಸೂಚಿಸುವ ಪದ 'ಬರೆದರು' ಕ್ರಿಯಾಪದ."
        ),
        QuestionModel(
            id = "fln_8_kan_5",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಅವಳು ಸುಂದರವಾಗಿ ಹಾಡಿದಳು.” ಈ ವಾಕ್ಯದಲ್ಲಿ ಕ್ರಿಯಾವಿಶೇಷಣ ಯಾವುದು?",
            options = listOf("ಅವಳು", "ಸುಂದರವಾಗಿ", "ಹಾಡಿದಳು", "ಸುಂದರ"),
            correctAnswer = "ಸುಂದರವಾಗಿ",
            explanation = "ಹಾಡಿದ ಬಗೆಯನ್ನು ವರ್ಣಿಸುವ ಪದ 'ಸುಂದರವಾಗಿ' ಕ್ರಿಯಾವಿಶೇಷಣ."
        ),
        QuestionModel(
            id = "fln_8_kan_6",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸರಿಯಾದ ಕಾಗುಣಿತ ಹೊಂದಿರುವ ಶುದ್ಧ ಪದವನ್ನು ಆಯ್ಕೆಮಾಡಿ.",
            options = listOf("ಜವಾಬ್ದಾರಿ", "ಜವಬ್ದಾರಿ", "ಜವಾಬ್ದಾರೀ", "ಜವಬ್ದಾರೀ"),
            correctAnswer = "ಜವಾಬ್ದಾರಿ",
            explanation = "'ಜವಾಬ್ದಾರಿ' ಸರಿಯಾದ ಕಾಗುಣಿತ ರೂಪ."
        ),
        QuestionModel(
            id = "fln_8_kan_7",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಮಕ್ಕಳು ಪುಸ್ತಕಗಳನ್ನು ಓದುತ್ತಿದ್ದಾರೆ.” ಈ ವಾಕ್ಯವು ಯಾವ ಕಾಲವನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಭೂತಕಾಲ", "ವರ್ತಮಾನಕಾಲ", "ಭವಿಷ್ಯತ್ಕಾಲ", "ಪೂರ್ಣ ಭೂತಕಾಲ"),
            correctAnswer = "ವರ್ತಮಾನಕಾಲ",
            explanation = "ಪ್ರಸ್ತುತ ನಡೆಯುತ್ತಿರುವ ಕ್ರಿಯೆಯನ್ನು ಸೂಚಿಸುವುದರಿಂದ ವರ್ತಮಾನಕಾಲ."
        ),
        QuestionModel(
            id = "fln_8_kan_8",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಕೈಕಟ್ಟಿ ಕುಳಿತುಕೊಳ್ಳು” ಎಂಬ ನುಡಿಗಟ್ಟಿನ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಕೆಲಸ ಮಾಡದೆ ಇರುವುದು", "ವೇಗವಾಗಿ ಓಡುವುದು", "ಕೈ ತೊಳೆಯುವುದು", "ಸಹಾಯ ಮಾಡುವುದು"),
            correctAnswer = "ಕೆಲಸ ಮಾಡದೆ ಇರುವುದು",
            explanation = "ಯಾವುದೇ ಕೆಲಸ ಅಥವಾ ಪ್ರಯತ್ನ ಮಾಡದೆ ಸೋಮಾರಿಯಾಗಿರುವುದನ್ನು ಕೈಕಟ್ಟಿ ಕುಳಿತುಕೊಳ್ಳುವುದು ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_8_kan_9",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಒಗ್ಗಟ್ಟಿನಲ್ಲಿ ಬಲವಿದೆ” ಎಂಬ ಗಾದೆಯ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಒಬ್ಬರೇ ಎಲ್ಲ ಕೆಲಸ ಮಾಡಬೇಕು", "ಒಟ್ಟಾಗಿ ಕೆಲಸ ಮಾಡಿದರೆ ಶಕ್ತಿ ಹೆಚ್ಚುತ್ತದೆ", "ಕೆಲಸ ಮಾಡುವುದು ಬೇಡ", "ಬಲವಿದ್ದರೆ ಓದುವುದು ಬೇಡ"),
            correctAnswer = "ಒಟ್ಟಾಗಿ ಕೆಲಸ ಮಾಡಿದರೆ ಶಕ್ತಿ ಹೆಚ್ಚುತ್ತದೆ",
            explanation = "ಎಲ್ಲರೂ ಒಗ್ಗಟ್ಟಿನಿಂದ ಕೈಜೋಡಿಸಿದಾಗ ಯಾವುದೇ ಕಷ್ಟಕರ ಕೆಲಸವನ್ನೂ ಸುಲಭವಾಗಿ ಸಾಧಿಸಬಹುದು."
        ),
        QuestionModel(
            id = "fln_8_kan_10",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಸಂಯುಕ್ತ ಪದವನ್ನು ಗುರುತಿಸಿ.",
            options = listOf("ಮನೆ", "ಹೂವು", "ತಾಯ್ನಾಡು", "ಮರ"),
            correctAnswer = "ತಾಯ್ನಾಡು",
            explanation = "ತಾಯಿ + ನಾಡು = ತಾಯ್ನಾಡು (ಎರಡು ನಾಮಪದಗಳು ಸೇರಿ ಸಂಯುಕ್ತ ಪದವಾಗಿದೆ)."
        ),
        QuestionModel(
            id = "fln_8_kan_11",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಅಧಿಕೃತ ಪತ್ರವನ್ನು ಬರೆಯುವಾಗ ಯಾವುದಕ್ಕೆ ಹೆಚ್ಚಿನ ಮಹತ್ವ ನೀಡಬೇಕು?",
            options = listOf("ಅಸ್ಪಷ್ಟ ಭಾಷೆಗೆ", "ಸೂಕ್ತ ಸಂಬೋಧನೆ ಮತ್ತು ಸ್ಪಷ್ಟ ವಿಷಯಕ್ಕೆ", "ಅನಗತ್ಯ ಚಿತ್ರಗಳಿಗೆ", "ವಿಷಯಕ್ಕೆ ಸಂಬಂಧಿಸದ ಮಾತುಗಳಿಗೆ"),
            correctAnswer = "ಸೂಕ್ತ ಸಂಬೋಧನೆ ಮತ್ತು ಸ್ಪಷ್ಟ ವಿಷಯಕ್ಕೆ",
            explanation = "ಅಧಿಕೃತ ಪತ್ರದಲ್ಲಿ ಸಭ್ಯ ಸಂಬೋಧನೆ, ಅಚ್ಚುಕಟ್ಟಾದ ಭಾಷೆ ಮತ್ತು ಸ್ಪಷ್ಟವಾದ ವಿಷಯ ನಿರೂಪಣೆ ಅತಿ ಮುಖ್ಯ."
        ),
        QuestionModel(
            id = "fln_8_kan_12",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸಾರ್ವಜನಿಕ ಸ್ಥಳದಲ್ಲಿ ಕಸವನ್ನು ಕಂಡಾಗ ಸೂಕ್ತವಾದ ನಾಗರಿಕ ಕ್ರಮ ಯಾವುದು?",
            options = listOf("ಅಲ್ಲಿಯೇ ಮತ್ತಷ್ಟು ಕಸ ಹಾಕುವುದು", "ಕಸವನ್ನು ನೀರಿಗೆ ಎಸೆಯುವುದು", "ಕಸವನ್ನು ಸೂಕ್ತ ಕಸದ ಬುಟ್ಟಿಗೆ ಹಾಕುವುದು", "ಕಸಕ್ಕೆ ಬೆಂಕಿ ಹಚ್ಚುವುದು"),
            correctAnswer = "ಕಸವನ್ನು ಸೂಕ್ತ ಕಸದ ಬುಟ್ಟಿಗೆ ಹಾಕುವುದು",
            explanation = "ಸಾರ್ವಜನಿಕ ನೈರ್ಮಲ್ಯ ಕಾಪಾಡಲು ಕಸವನ್ನು ಕಸದ ಬುಟ್ಟಿಗೆ (Dustbin) ಹಾಕುವುದು ಆದ್ಯ ಕರ್ತವ್ಯ."
        ),
        QuestionModel(
            id = "fln_8_kan_13",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಚರ್ಚೆಯಲ್ಲಿ ಇತರರ ಅಭಿಪ್ರಾಯವನ್ನು ಕೇಳುವಾಗ ಯಾವ ಸದ್ಗುಣ ಮುಖ್ಯ?",
            options = listOf("ತಾಳ್ಮೆ ಮತ್ತು ಗೌರವ", "ಕೋಪ ಮತ್ತು ಹಠ", "ಅಡ್ಡಿಪಡಿಸುವುದು", "ಅಪಹಾಸ್ಯ ಮಾಡುವುದು"),
            correctAnswer = "ತಾಳ್ಮೆ ಮತ್ತು ಗೌರವ",
            explanation = "ಇತರರ ವಿಚಾರಗಳನ್ನು ತಾಳ್ಮೆಯಿಂದ ಆಲಿಸಿ ಗೌರವಿಸುವುದು ಪ್ರಬುದ್ಧ ಸಂವಹನದ ಲಕ್ಷಣ."
        ),
        QuestionModel(
            id = "fln_8_kan_14",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ನೀರು ಅಮೂಲ್ಯ ಸಂಪನ್ಮೂಲವಾಗಿದೆ.” ಈ ವಾಕ್ಯದ ಮುಖ್ಯ ಸಂದೇಶವೇನು?",
            options = listOf("ನೀರನ್ನು ವ್ಯರ್ಥ ಮಾಡಲು ಪ್ರೇರೇಪಿಸುವುದು", "ನೀರಿನ ಮಹತ್ವವನ್ನು ತಿಳಿಸುವುದು", "ನೀರಿನ ಬಣ್ಣವನ್ನು ವಿವರಿಸುವುದು", "ಮಳೆಯ ಸಮಯ ತಿಳಿಸುವುದು"),
            correctAnswer = "ನೀರಿನ ಮಹತ್ವವನ್ನು ತಿಳಿಸುವುದು",
            explanation = "ನೀರಿನ ಪ್ರಾಮುಖ್ಯತೆ ಮತ್ತು ಅದನ್ನು ಸಂರಕ್ಷಿಸುವ ಜವಾಬ್ದಾರಿಯನ್ನು ಈ ವಾಕ್ಯ ಎತ್ತಿಹಿಡಿಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_8_kan_15",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಂದು ಪಠ್ಯವನ್ನು ಓದಿದ ನಂತರ ಅದರ ಮುಖ್ಯ ಆಶಯವನ್ನು ಸಂಕ್ಷಿಪ್ತವಾಗಿ ಬರೆಯುವುದನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸಂಭಾಷಣೆ", "ಸಾರಾಂಶ", "ಜಾಹೀರಾತು", "ಅರ್ಜಿ"),
            correctAnswer = "ಸಾರಾಂಶ",
            explanation = "ದೊಡ್ಡ ಲೇಖನ ಅಥವಾ ಕಥೆಯ ಪ್ರಮುಖ ಅಂಶಗಳನ್ನು ಸಂಗ್ರಹಿಸಿ ಬರೆಯುವುದಕ್ಕೆ ಸಾರಾಂಶ (Summary) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "fln_8_kan_16",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಜ್ಞಾನ” ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಅಜ್ಞಾನ", "ಸುಜ್ಞಾನ", "ವಿಜ್ಞಾನ", "ಪ್ರಜ್ಞೆ"),
            correctAnswer = "ಅಜ್ಞಾನ",
            explanation = "ಜ್ಞಾನದ ನೇರ ವಿರುದ್ಧ ಪದ ಅಜ್ಞಾನ."
        ),
        QuestionModel(
            id = "fln_8_kan_17",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಜನನಿ” ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ತಾಯಿ", "ಮಗಳು", "ಸಹೋದರಿ", "ಸ್ನೇಹಿತೆ"),
            correctAnswer = "ತಾಯಿ",
            explanation = "ಜನನಿ ಎಂದರೆ ಜನ್ಮ ನೀಡಿದ ತಾಯಿ, ಮಾತೆ."
        ),
        QuestionModel(
            id = "fln_8_kan_18",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಕಣ್ಣು” ಪದದ ತತ್ಸಮ ರೂಪ ಯಾವುದು?",
            options = listOf("ಅಕ್ಷಿ", "ಕರ್ಣ", "ನಾಸಿಕ", "ಮುಖ"),
            correctAnswer = "ಅಕ್ಷಿ",
            explanation = "ಸಂಸ್ಕೃತದ 'ಅಕ್ಷಿ' ತತ್ಸಮ ರೂಪದಿಂದ ಕನ್ನಡದ 'ಕಣ್ಣು' ತದ್ಭವ ರೂಪ ಬಂದಿದೆ."
        ),
        QuestionModel(
            id = "fln_8_kan_19",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಬೇಗಬೇಗ” ಎಂಬುದು ಯಾವ ರೀತಿಯ ವ್ಯಾಕರಣಾಂಶವಾಗಿದೆ?",
            options = listOf("ದ್ವಿರುಕ್ತಿ", "ಜೋಡುನುಡಿ", "ಅನುಕರಣಾವ್ಯಯ", "ಸಮಾಸ"),
            correctAnswer = "ದ್ವಿರುಕ್ತಿ",
            explanation = "ಅರ್ಥದ ದೃಢತೆಗಾಗಿ ಒಂದೇ ಪದ ಎರಡು ಬಾರಿ ಬಂದರೆ ಅದು ದ್ವಿರುಕ್ತಿ ('ಬೇಗಬೇಗ')."
        ),
        QuestionModel(
            id = "fln_8_kan_20",
            stdId = 8,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ರವಿ ಮತ್ತು ಕಿರಣ ಶಾಲೆಗೆ ಹೋದರು.” ಈ ವಾಕ್ಯದಲ್ಲಿರುವ ಸಮುಚ್ಚಯ ಅವ್ಯಯ (Conjunction) ಯಾವುದು?",
            options = listOf("ರವಿ", "ಮತ್ತು", "ಕಿರಣ", "ಹೋದರು"),
            correctAnswer = "ಮತ್ತು",
            explanation = "ಎರಡು ಪದಗಳನ್ನು ಬೆಸೆಯುವ 'ಮತ್ತು' ಸಮುಚ್ಚಯ ಅವ್ಯಯವಾಗಿದೆ."
        ),

        // =========================================================================
        // =========================== 8 STD ENGLISH (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_8_eng_1",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Read: 'Meena lived in a village where water was scarce during summer. Her science teacher explained rainwater harvesting. Meena and her classmates prepared posters and spread awareness. The villagers built rainwater harvesting systems.' What problem did Meena's village face during summer?",
            options = listOf("Lack of electricity", "Shortage of water", "Lack of schools", "Poor road facilities"),
            correctAnswer = "Shortage of water",
            explanation = "The passage explicitly states 'water was scarce during summer.'"
        ),
        QuestionModel(
            id = "fln_8_eng_2",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Who explained rainwater harvesting to Meena?",
            options = listOf("Her father", "Her friend", "Her science teacher", "The village head"),
            correctAnswer = "Her science teacher",
            explanation = "Her science teacher explained the importance of rainwater harvesting."
        ),
        QuestionModel(
            id = "fln_8_eng_3",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "How did Meena and her classmates spread awareness?",
            options = listOf("By writing examination papers", "By preparing posters and explaining the idea", "By closing the school", "By selling water"),
            correctAnswer = "By preparing posters and explaining the idea",
            explanation = "They prepared informative posters and explained the collection methods."
        ),
        QuestionModel(
            id = "fln_8_eng_4",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What positive outcome happened within a year?",
            options = listOf("The village had a better water supply.", "The village lost its school.", "The villagers left the village.", "The rainfall stopped completely."),
            correctAnswer = "The village had a better water supply.",
            explanation = "Harvesting rainwater improved the village's water supply within a year."
        ),
        QuestionModel(
            id = "fln_8_eng_5",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the main message of the passage?",
            options = listOf("Only adults can solve problems.", "Small collective efforts can bring positive change.", "Students should avoid community work.", "Water conservation is unnecessary."),
            correctAnswer = "Small collective efforts can bring positive change.",
            explanation = "When students and community members work together, significant positive transformations occur."
        ),
        QuestionModel(
            id = "fln_8_eng_6",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the synonym of “scarce”.",
            options = listOf("Abundant", "Limited", "Plenty", "Sufficient"),
            correctAnswer = "Limited",
            explanation = "Scarce means occurring in small or limited quantities."
        ),
        QuestionModel(
            id = "fln_8_eng_7",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the antonym of “ancient”.",
            options = listOf("Old", "Historic", "Modern", "Traditional"),
            correctAnswer = "Modern",
            explanation = "Ancient means from very long ago; modern means current/contemporary."
        ),
        QuestionModel(
            id = "fln_8_eng_8",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct passive voice: “The teacher praised Meena.”",
            options = listOf("Meena praised the teacher.", "Meena was praised by the teacher.", "Meena is praising the teacher.", "The teacher was praised by Meena."),
            correctAnswer = "Meena was praised by the teacher.",
            explanation = "Subject Meena + was praised + by the agent."
        ),
        QuestionModel(
            id = "fln_8_eng_9",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: “If it rains, we ______ at home.”",
            options = listOf("stayed", "staying", "will stay", "stays"),
            correctAnswer = "will stay",
            explanation = "First conditional structure: If + present, will + base verb."
        ),
        QuestionModel(
            id = "fln_8_eng_10",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the adjective in the sentence: “The clever student solved the problem.”",
            options = listOf("Student", "Solved", "Problem", "Clever"),
            correctAnswer = "Clever",
            explanation = "'Clever' describes the intelligence of the noun 'student'."
        ),
        QuestionModel(
            id = "fln_8_eng_11",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct indirect speech: Ravi said, “I am tired.”",
            options = listOf("Ravi said that I am tired.", "Ravi said that he was tired.", "Ravi says that he tired.", "Ravi said that he is tiring."),
            correctAnswer = "Ravi said that he was tired.",
            explanation = "In reported speech, present tense 'am' shifts to past tense 'was'."
        ),
        QuestionModel(
            id = "fln_8_eng_12",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: “She has lived here ______ 2020.”",
            options = listOf("for", "from", "since", "by"),
            correctAnswer = "since",
            explanation = "'Since' denotes a specific starting year in the past with perfect tense."
        ),
        QuestionModel(
            id = "fln_8_eng_13",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct question tag: “You are ready, ______?”",
            options = listOf("are you", "aren't you", "don't you", "isn't it"),
            correctAnswer = "aren't you",
            explanation = "Positive statement with 'are' requires negative tag 'aren't you?'."
        ),
        QuestionModel(
            id = "fln_8_eng_14",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the adverb in the sentence: “The athlete ran quickly.”",
            options = listOf("Athlete", "Ran", "Quickly", "The"),
            correctAnswer = "Quickly",
            explanation = "'Quickly' describes the speed of the running action."
        ),
        QuestionModel(
            id = "fln_8_eng_15",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correctly spelled word.",
            options = listOf("Neccessary", "Necesary", "Necessary", "Nessessary"),
            correctAnswer = "Necessary",
            explanation = "One 'c' and double 's': Necessary."
        ),
        QuestionModel(
            id = "fln_8_eng_16",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the grammatically correct sentence.",
            options = listOf("Neither of the boys are present.", "Neither of the boys is present.", "Neither boys is present.", "Neither of boys were present."),
            correctAnswer = "Neither of the boys is present.",
            explanation = "'Neither of' is grammatically singular and takes the singular verb 'is'."
        ),
        QuestionModel(
            id = "fln_8_eng_17",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Which sentence expresses a polite request?",
            options = listOf("Open the window immediately!", "You must open the window.", "Could you please open the window?", "Open it or leave."),
            correctAnswer = "Could you please open the window?",
            explanation = "'Could you please...' is the respectful modal phrasing for requests."
        ),
        QuestionModel(
            id = "fln_8_eng_18",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the most appropriate formal email opening to a head teacher.",
            options = listOf("Hey buddy!", "Dear Head Teacher,", "What's up?", "Hi dude!"),
            correctAnswer = "Dear Head Teacher,",
            explanation = "'Dear Head Teacher,' is professional and courteous."
        ),
        QuestionModel(
            id = "fln_8_eng_19",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct conjunction: “He was tired, ______ he completed his homework.”",
            options = listOf("but", "because", "or", "unless"),
            correctAnswer = "but",
            explanation = "'But' connects contrasting clauses showing effort despite tiredness."
        ),
        QuestionModel(
            id = "fln_8_eng_20",
            stdId = 8,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Which sentence best expresses environmental responsibility?",
            options = listOf("We should waste natural resources.", "We should throw waste into rivers.", "We should reduce waste and conserve resources.", "We should cut trees without planting new ones."),
            correctAnswer = "We should reduce waste and conserve resources.",
            explanation = "Reducing waste and conserving resources preserves nature for future generations."
        ),

        // =========================================================================
        // =========================== 8 STD MATHEMATICS (20 MCQs) =================
        // =========================================================================
        QuestionModel(
            id = "fln_8_mat_1",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "48,756 + 29,845 ರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("77,601", "78,601", "78,501", "79,601"),
            correctAnswer = "78,601",
            explanation = "48,756 + 29,845 = 78,601."
        ),
        QuestionModel(
            id = "fln_8_mat_2",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "90,000 − 47,586 ರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("42,414", "43,414", "42,514", "41,414"),
            correctAnswer = "42,414",
            explanation = "90,000 - 47,586 = 42,414."
        ),
        QuestionModel(
            id = "fln_8_mat_3",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "325 × 48 ರ ಗುಣಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("14,600", "15,200", "15,600", "16,200"),
            correctAnswer = "15,600",
            explanation = "325 × 48 = 15,600."
        ),
        QuestionModel(
            id = "fln_8_mat_4",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "7,560 ÷ 24 ರ ಭಾಗಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("305", "315", "325", "335"),
            correctAnswer = "315",
            explanation = "7,560 ÷ 24 = 315 (ಏಕೆಂದರೆ 24 × 315 = 7,560)."
        ),
        QuestionModel(
            id = "fln_8_mat_5",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸರಳೀಕರಿಸಿ: (-12) + 25 − 8 = ಎಷ್ಟು?",
            options = listOf("3", "5", "9", "13"),
            correctAnswer = "5",
            explanation = "(-12 - 8) + 25 = -20 + 25 = 5."
        ),
        QuestionModel(
            id = "fln_8_mat_6",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "2/3 + 1/6 ರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("1/2", "3/9", "5/6", "2/9"),
            correctAnswer = "5/6",
            explanation = "ಲ.ಸಾ.ಅ 6: 4/6 + 1/6 = 5/6."
        ),
        QuestionModel(
            id = "fln_8_mat_7",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "3/4 ನ್ನು ಶೇಕಡಾ ರೂಪದಲ್ಲಿ ಬರೆದಾಗ ಎಷ್ಟು?",
            options = listOf("25%", "50%", "75%", "80%"),
            correctAnswer = "75%",
            explanation = "(3/4) × 100 = 75%."
        ),
        QuestionModel(
            id = "fln_8_mat_8",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "₹800 ರ 15% ಎಷ್ಟು?",
            options = listOf("₹100", "₹110", "₹120", "₹150"),
            correctAnswer = "₹120",
            explanation = "(15 / 100) × 800 = 15 × 8 = ₹120."
        ),
        QuestionModel(
            id = "fln_8_mat_9",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಶಾಲಾ ಬ್ಯಾಗಿನ ಬೆಲೆ ₹1,200. ಅದರ ಮೇಲೆ 20% ರಿಯಾಯಿತಿ ನೀಡಿದರೆ, ಮಾರಾಟ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("₹900", "₹940", "₹960", "₹1,000"),
            correctAnswer = "₹960",
            explanation = "ರಿಯಾಯಿತಿ = ₹1,200 ರ 20% = ₹240. ಮಾರಾಟ ಬೆಲೆ = 1200 - 240 = ₹960."
        ),
        QuestionModel(
            id = "fln_8_mat_10",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "0.375 ನ್ನು ಅತ್ಯಂತ ಸರಳ ಭಿನ್ನರಾಶಿ ರೂಪದಲ್ಲಿ ಬರೆಯಿರಿ.",
            options = listOf("3/8", "3/5", "5/8", "7/8"),
            correctAnswer = "3/8",
            explanation = "0.375 = 375/1000 = (375÷125) / (1000÷125) = 3/8."
        ),
        QuestionModel(
            id = "fln_8_mat_11",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "x + 15 = 42 ಆದರೆ, x ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("17", "27", "37", "57"),
            correctAnswer = "27",
            explanation = "x = 42 - 15 = 27."
        ),
        QuestionModel(
            id = "fln_8_mat_12",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸರಳೀಕರಿಸಿ: 5a + 3a − 2a = ಎಷ್ಟು?",
            options = listOf("6a", "8a", "10a", "6a²"),
            correctAnswer = "6a",
            explanation = "(5 + 3 - 2)a = 6a."
        ),
        QuestionModel(
            id = "fln_8_mat_13",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "x = 4 ಆದರೆ, 3x + 7 ರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("12", "15", "19", "21"),
            correctAnswer = "19",
            explanation = "3(4) + 7 = 12 + 7 = 19."
        ),
        QuestionModel(
            id = "fln_8_mat_14",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "25 ರ ವರ್ಗ (Square - 25²) ಎಷ್ಟು?",
            options = listOf("125", "525", "625", "725"),
            correctAnswer = "625",
            explanation = "25 × 25 = 625."
        ),
        QuestionModel(
            id = "fln_8_mat_15",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "4 ರ ಘನ (Cube - 4³) ಎಷ್ಟು?",
            options = listOf("16", "32", "48", "64"),
            correctAnswer = "64",
            explanation = "4 × 4 × 4 = 64."
        ),
        QuestionModel(
            id = "fln_8_mat_16",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಆಯತದ ಉದ್ದ 18 cm ಮತ್ತು ಅಗಲ 12 cm ಇದ್ದರೆ, ಅದರ ಸುತ್ತಳತೆ (ಪರಿಧಿ) ಎಷ್ಟು?",
            options = listOf("30 cm", "48 cm", "60 cm", "216 cm"),
            correctAnswer = "60 cm",
            explanation = "ಸುತ್ತಳತೆ = 2(ಉದ್ದ + ಅಗಲ) = 2(18 + 12) = 2 × 30 = 60 cm."
        ),
        QuestionModel(
            id = "fln_8_mat_17",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "15 m ಬಾಹುವನ್ನು ಹೊಂದಿರುವ ಒಂದು ಚೌಕದ ವಿಸ್ತೀರ್ಣ ಎಷ್ಟು?",
            options = listOf("30 m²", "60 m²", "150 m²", "225 m²"),
            correctAnswer = "225 m²",
            explanation = "ಚೌಕದ ವಿಸ್ತೀರ್ಣ = ಬಾಹು × ಬಾಹು = 15 × 15 = 225 m² (ಚದರ ಮೀಟರ್)."
        ),
        QuestionModel(
            id = "fln_8_mat_18",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ತ್ರಿಭುಜದ ಎರಡು ಕೋನಗಳು 55° ಮತ್ತು 65° ಆಗಿದ್ದರೆ, ಮೂರನೇ ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("50°", "60°", "70°", "80°"),
            correctAnswer = "60°",
            explanation = "ತ್ರಿಭುಜದ ಒಳಕೋನಗಳ ಮೊತ್ತ 180°: 180° - (55° + 65°) = 180° - 120° = 60°."
        ),
        QuestionModel(
            id = "fln_8_mat_19",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಬ್ಬ ರೈತನು 2,880 kg ಅಕ್ಕಿಯನ್ನು 40 kg ಸಾಮರ್ಥ್ಯದ ಚೀಲಗಳಲ್ಲಿ ತುಂಬಿದರೆ, ಒಟ್ಟು ಎಷ್ಟು ಚೀಲಗಳು ಬೇಕಾಗುತ್ತವೆ?",
            options = listOf("62", "68", "72", "82"),
            correctAnswer = "72",
            explanation = "2,880 ÷ 40 = 72 ಚೀಲಗಳು."
        ),
        QuestionModel(
            id = "fln_8_mat_20",
            stdId = 8,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಬ್ಬ ವಿದ್ಯಾರ್ಥಿಯು ನಾಲ್ಕು ವಿಷಯಗಳಲ್ಲಿ 72, 85, 68 ಮತ್ತು 75 ಅಂಕಗಳನ್ನು ಪಡೆದಿದ್ದಾನೆ. ಅವನ ಸರಾಸರಿ ಅಂಕ ಎಷ್ಟು?",
            options = listOf("70", "72", "75", "80"),
            correctAnswer = "75",
            explanation = "ಒಟ್ಟು = 72 + 85 + 68 + 75 = 300. ಸರಾಸರಿ = 300 ÷ 4 = 75."
        ),

        // =========================================================================
        // =========================== 9 STD KANNADA (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_9_kan_1",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕನ್ನಡದಲ್ಲಿ ಮೊದಲ ಉಪಲಬ್ಧ ಗ್ರಂಥ ಯಾವುದು?",
            options = listOf("ಕವಿರಾಜಮಾರ್ಗ", "ವಡ್ಡಾರಾಧನೆ", "ಪಂಪಭಾರತ", "ಗದುಗಿನ ಭಾರತ"),
            correctAnswer = "ಕವಿರಾಜಮಾರ್ಗ",
            explanation = "9ನೇ ಶತಮಾನದ ಶ್ರೀವಿಜಯ ರಚಿತ 'ಕವಿರಾಜಮಾರ್ಗ' ಲಕ್ಷಣ ಗ್ರಂಥವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "fln_9_kan_2",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಕನ್ನಡ ನಾಡು ಕಾವೇರಿಯಿಂದ ಗೋದಾವರಿಯವರೆಗೆ ವಿಸ್ತರಿಸಿತ್ತು” ಎಂದು ಹೇಳಿದ ಕೃತಿ ಯಾವುದು?",
            options = listOf("ಕವಿರಾಜಮಾರ್ಗ", "ಕರ್ಣಾಟ ಕಾದಂಬರಿ", "ಯಶೋಧರ ಚರಿತೆ", "ಲೀಲಾವತಿ ಪ್ರಬಂಧ"),
            correctAnswer = "ಕವಿರಾಜಮಾರ್ಗ",
            explanation = "'ಕಾವೇರಿಯಿಂದಮಾ ಗೋದಾವರಿವರಮಿರ್ಪ ನಾಡದಾ ಕನ್ನಡದೊಳ್' ಎಂದು ಕವಿರಾಜಮಾರ್ಗ ಹೇಳುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_9_kan_3",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ದ್ವಂದ್ವ ಸಮಾಸಕ್ಕೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಗಿಡಮರಬಳ್ಳಿಗಳು", "ಹೆಮ್ಮರ", "ಕೈಬಳೆ", "ಅರಮನೆ"),
            correctAnswer = "ಗಿಡಮರಬಳ್ಳಿಗಳು",
            explanation = "ಎಲ್ಲ ಪದಗಳ ಅರ್ಥವೂ ಪ್ರಧಾನವಾಗಿರುವ ಸಮಾಸ ದ್ವಂದ್ವ ಸಮಾಸ."
        ),
        QuestionModel(
            id = "fln_9_kan_4",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ವೃದ್ಧಿ ಸಂಧಿಗೆ ಸೂಕ್ತ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಏಕೈಕ (ಏಕ + ಏಕ)", "ದೇವಾಲಯ", "ಮಹರ್ಷಿ", "ಇತ್ಯಾದಿ"),
            correctAnswer = "ಏಕೈಕ (ಏಕ + ಏಕ)",
            explanation = "ಅ + ಏ = ಐ ಆದಾಗ ವೃದ್ಧಿ ಸಂಧಿ (ಏಕ + ಏಕ = ಏಕೈಕ)."
        ),
        QuestionModel(
            id = "fln_9_kan_5",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಭಾಮಿನಿ ಷಟ್ಪದಿಯ ಪ್ರತಿ ಪಾದದಲ್ಲಿ ಒಟ್ಟು ಎಷ್ಟು ಮಾತ್ರೆಗಳಿರುತ್ತವೆ (3 ಮತ್ತು 4 ನೇ ಸಾಲಿನಲ್ಲಿ)?",
            options = listOf("14 ಮಾತ್ರೆಗಳು", "23 ಮಾತ್ರೆಗಳು", "15 ಮಾತ್ರೆಗಳು", "20 ಮಾತ್ರೆಗಳು"),
            correctAnswer = "23 ಮಾತ್ರೆಗಳು",
            explanation = "ಭಾಮಿನಿ ಷಟ್ಪದಿಯ 3 ಮತ್ತು 6ನೇ ಸಾಲಿನಲ್ಲಿ 23 ಮಾತ್ರೆಗಳಿರುತ್ತವೆ (3-4-3-4-3-4-1)."
        ),
        QuestionModel(
            id = "fln_9_kan_6",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ರೂಪಕ ಅಲಂಕಾರಕ್ಕೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಅವನ ಮುಖ ಕಮಲದಂತಿದೆ", "ಅವನ ಮುಖಕಮಲವು ಕಂಗೊಳಿಸಿತು", "ಮಿಂಚಿನಂತೆ ಓಡಿದನು", "ಹೂವಿನಂತೆ ನಕ್ಕಳು"),
            correctAnswer = "ಅವನ ಮುಖಕಮಲವು ಕಂಗೊಳಿಸಿತು",
            explanation = "ಉಪಮೇಯ ಮತ್ತು ಉಪಮಾನಗಳಿಗೆ ಅಭೇದ ಕಲ್ಪಿಸಿ ವರ್ಣಿಸಿದರೆ ರೂಪಕ ಅಲಂಕಾರ."
        ),
        QuestionModel(
            id = "fln_9_kan_7",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಉಪ್ಪಿಗಿಂತ ರುಚಿಯಿಲ್ಲ, ತಾಯಿಗಿಂತ ಬಂಧುವಿಲ್ಲ.” ಈ ಗಾದೆಯು ಯಾವುದರ ಅಗಾಧತೆಯನ್ನು ಸಾರುತ್ತದೆ?",
            options = listOf("ತಾಯಿಯ ನಿಸ್ವಾರ್ಥ ಪ್ರೀತಿ ಮತ್ತು ಮಮತೆ", "ಉಪ್ಪಿನ ಬೆಲೆ", "ವ್ಯಾಪಾರದ ಲಾಭ", "ಬಂಧುಗಳ ವೈರಾಗ್ಯ"),
            correctAnswer = "ತಾಯಿಯ ನಿಸ್ವಾರ್ಥ ಪ್ರೀತಿ ಮತ್ತು ಮಮತೆ",
            explanation = "ಜಗತ್ತಿನಲ್ಲಿ ತಾಯಿಯ ಪ್ರೀತಿ ಮತ್ತು ಕಾಳಜಿಗೆ ಸಮಾನವಾದ ಬೇರೆ ಯಾವುದೇ ಬಾಂಧವ್ಯವಿಲ್ಲ."
        ),
        QuestionModel(
            id = "fln_9_kan_8",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕನ್ನಡದ ಮೊದಲ ಗದ್ಯ ಕೃತಿ ಯಾವುದು?",
            options = listOf("ವಡ್ಡಾರಾಧನೆ", "ಕವಿರಾಜಮಾರ್ಗ", "ಶಾಕುಂತಲ", "ಚದುರಂಗ"),
            correctAnswer = "ವಡ್ಡಾರಾಧನೆ",
            explanation = "ಶಿವಕೋಟ್ಯಾಚಾರ್ಯ ವಿರಚಿತ 'ವಡ್ಡಾರಾಧನೆ' ಕನ್ನಡದ ಪ್ರಾಚೀನ ಗದ್ಯ ಕೃತಿಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "fln_9_kan_9",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಆತ್ಮವಿಶ್ವಾಸವೇ ಯಶಸ್ಸಿನ ಮೊದಲ ಮೆಟ್ಟಿಲು.” ಈ ವಾಕ್ಯದಲ್ಲಿ ಕರ್ತೃ ಪದ ಯಾವುದು?",
            options = listOf("ಆತ್ಮವಿಶ್ವಾಸ", "ಯಶಸ್ಸು", "ಮೊದಲ", "ಮೆಟ್ಟಿಲು"),
            correctAnswer = "ಆತ್ಮವಿಶ್ವಾಸ",
            explanation = "ವಾಕ್ಯದ ಕೇಂದ್ರ ವಿಷಯ ಮತ್ತು ಕರ್ತೃ 'ಆತ್ಮವಿಶ್ವಾಸ'."
        ),
        QuestionModel(
            id = "fln_9_kan_10",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕನ್ನಡದಲ್ಲಿ ಜ್ಞಾನಪೀಠ ಪ್ರಶಸ್ತಿ ಪಡೆದ ಮೊದಲ ಕೃತಿ ಯಾವುದು?",
            options = listOf("ಶ್ರೀ ರಾಮಾಯಣ ದರ್ಶನಂ (ಕುವೆಂಪು)", "ಮೂಕಜ್ಜಿಯ ಕನಸುಗಳು", "ನಾಕುತಂತಿ", "ಯಯಾತಿ"),
            correctAnswer = "ಶ್ರೀ ರಾಮಾಯಣ ದರ್ಶನಂ (ಕುವೆಂಪು)",
            explanation = "ರಾಷ್ಟ್ರಕವಿ ಕುವೆಂಪು ಅವರ 'ಶ್ರೀ ರಾಮಾಯಣ ದರ್ಶನಂ' ಮಹಾಕಾವ್ಯಕ್ಕೆ ಕನ್ನಡದ ಪ್ರಥಮ ಜ್ಞಾನಪೀಠ ಸಂದಿತು."
        ),
        QuestionModel(
            id = "fln_9_kan_11",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಯಣ್ ಸಂಧಿಗೆ ಸೂಕ್ತ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಇತ್ಯಾದಿ (ಇತಿ + ಆದಿ)", "ದೇವರ್ಷಿ", "ಮಹೋತ್ಸವ", "ವಿದ್ಯಾಲಯ"),
            correctAnswer = "ಇತ್ಯಾದಿ (ಇತಿ + ಆದಿ)",
            explanation = "ಇ, ಈ ಕಾರಗಳಿಗೆ ಸವರ್ಣವಲ್ಲದ ಸ್ವರ ಪರವಾದಾಗ 'ಯ್' ಕಾರ ಬರುವುದು ಯಣ್ ಸಂಧಿ (ಇತಿ + ಆದಿ = ಇತ್ಯಾದಿ)."
        ),
        QuestionModel(
            id = "fln_9_kan_12",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ವಸುಧೆ” ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಭೂಮಿ / ಧರೆ", "ಆಕಾಶ", "ಸಮುದ್ರ", "ವಾಯು"),
            correctAnswer = "ಭೂಮಿ / ಧರೆ",
            explanation = "ವಸುಧೆ ಎಂದರೆ ಪೃಥ್ವಿ, ಭೂಮಿ, ಧರಣಿ, ಇಳೆ."
        ),
        QuestionModel(
            id = "fln_9_kan_13",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಮೌಲ್ಯಯುತ ಶಿಕ್ಷಣವೇ ದೇಶದ ಬಲ.” ಈ ವಾಕ್ಯದಲ್ಲಿ ಕರ್ಮಪದ (Object) ಯಾವುದು?",
            options = listOf("ದೇಶದ ಬಲ", "ಶಿಕ್ಷಣವೇ", "ಮೌಲ್ಯಯುತ", "ಇದೆ"),
            correctAnswer = "ದೇಶದ ಬಲ",
            explanation = "ಕ್ರಿಯಾಪದದ ಫಲವನ್ನು ಸ್ವೀಕರಿಸುವ ಪದ ದೇಶದ ಬಲ."
        ),
        QuestionModel(
            id = "fln_9_kan_14",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕ್ರಿಯಾಸಮಾಸಕ್ಕೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಮೈದಡವಿ (ಮೈಯನ್ನು + ತಡವಿ)", "ಹೆಬ್ಬಂಡೆ", "ಇನ್ಮುಡಿ", "ಕಾಳುಮೆಣಸು"),
            correctAnswer = "ಮೈದಡವಿ (ಮೈಯನ್ನು + ತಡವಿ)",
            explanation = "ಉತ್ತರಪದದಲ್ಲಿ ಕ್ರಿಯಾಪದ ಅಥವಾ ಕೃದಂತವಿದ್ದರೆ ಕ್ರಿಯಾಸಮಾಸ."
        ),
        QuestionModel(
            id = "fln_9_kan_15",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ವಿದ್ವಾನ್ ಸರ್ವತ್ರ ಪೂಜ್ಯತೇ” ಇದರ ಸಾರಾಂಶವೇನು?",
            options = listOf("ವಿದ್ವಾಂಸನು ಎಲ್ಲೆಡೆಯೂ ಗೌರವಿಸಲ್ಪಡುತ್ತಾನೆ", "ಹಣವಂತನೇ ದೇವರು", "ರಾಜ ಮಾತ್ರ ಪೂಜ್ಯನು", "ಯಾರೂ ಗೌರವಿಸುವುದಿಲ್ಲ"),
            correctAnswer = "ವಿದ್ವಾಂಸನು ಎಲ್ಲೆಡೆಯೂ ಗೌರವಿಸಲ್ಪಡುತ್ತಾನೆ",
            explanation = "ರಾಜ ತನ್ನ ದೇಶದಲ್ಲಿ ಮಾತ್ರ ಪೂಜಿಸಲ್ಪಡುತ್ತಾನೆ, ವಿದ್ವಾಂಸ ಜಗದ ಎಲ್ಲೆಡೆಯೂ ಗೌರವ ಪಡೆಯುತ್ತಾನೆ."
        ),
        QuestionModel(
            id = "fln_9_kan_16",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬಹುವ್ರೀಹಿ ಸಮಾಸಕ್ಕೆ ಸೂಕ್ತ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಮುಕ್ಕಣ್ಣ (ಮೂರು ಕಣ್ಣುಗಳುಳ್ಳವನು - ಶಿವ)", "ಮನೆಕೆಲಸ", "ದಿನದಿನ", "ಹೊಸಗನ್ನಡ"),
            correctAnswer = "ಮುಕ್ಕಣ್ಣ (ಮೂರು ಕಣ್ಣುಗಳುಳ್ಳವನು - ಶಿವ)",
            explanation = "ಬೇರೊಂದು ಅನ್ಯ ಪದದ ಅರ್ಥ ಪ್ರಧಾನವಾಗಿರುವ ಸಮಾಸ ಬಹುವ್ರೀಹಿ ಸಮಾಸ."
        ),
        QuestionModel(
            id = "fln_9_kan_17",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಆದೇಶ ಸಂಧಿಗೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಮಳೆಗಾಲ (ಮಳೆ + ಕಾಲ)", "ರಾಮೇಶ್ವರ", "ಸೂರ್ಯೋದಯ", "ಸುರೇಂದ್ರ"),
            correctAnswer = "ಮಳೆಗಾಲ (ಮಳೆ + ಕಾಲ)",
            explanation = "ಉತ್ತರ ಪದದ ಕ, ತ, ಪ ಗಳಿಗೆ ಗ, ದ, ಬ ಗಳು ಆದೇಶವಾಗಿ ಬರುವುದು ಆದೇಶ ಸಂಧಿ (ಕಾಲ -> ಗಾಲ)."
        ),
        QuestionModel(
            id = "fln_9_kan_18",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಕನ್ನಡ ಎನೆ ಕುಣಿದಾಡುವುದೆನ್ನೆದೆ, ಕನ್ನಡ ಎನೆ ಕಿವಿ ನಿಮಿರುವುದು” ಈ ಸಾಲುಗಳನ್ನು ಬರೆದ ಕವಿ ಯಾರು?",
            options = listOf("ಕುವೆಂಪು", "ದ.ರಾ. ಬೇಂದ್ರೆ", "ಬಿ.ಎಂ. ಶ್ರೀಕಂಠಯ್ಯ", "ಗೋವಿಂದ ಪೈ"),
            correctAnswer = "ಕುವೆಂಪು",
            explanation = "ಕುವೆಂಪು ಅವರ ಸುಪ್ರಸಿದ್ಧ ಕನ್ನಡಾಭಿಮಾನದ ಗೀತೆ."
        ),
        QuestionModel(
            id = "fln_9_kan_19",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "“ಸಂಪತ್ತು ಕ್ಷಣಿಕ, ಕೀರ್ತಿ ಶಾಶ್ವತ.” ಈ ನುಡಿಯ ಸಂದೇಶವೇನು?",
            options = listOf("ಹಣಕ್ಕಿಂತ ಸತ್ಕೀರ್ತಿ ಶಾಶ್ವತವಾದುದು", "ಹಣವೇ ಶಾಶ್ವತ", "ಕೀರ್ತಿಯಿಂದ ಪ್ರಯೋಜನವಿಲ್ಲ", "ಸಂಪತ್ತನ್ನು ಅಳೆಯಲಾಗದು"),
            correctAnswer = "ಹಣಕ್ಕಿಂತ ಸತ್ಕೀರ್ತಿ ಶಾಶ್ವತವಾದುದು",
            explanation = "ಲೌಕಿಕ ಸಂಪತ್ತು ನಶ್ವರ, ಸತ್ಕಾರ್ಯಗಳಿಂದ ಗಳಿಸಿದ ಒಳ್ಳೆಯ ಹೆಸರು ಅಜರಾಮರ."
        ),
        QuestionModel(
            id = "fln_9_kan_20",
            stdId = 9,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದ ಗಾಂಧಿ ಎಂದು ಯಾರನ್ನು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಹರ್ಡೇಕರ್ ಮಂಜಪ್ಪ", "ಕಾರ್ನಾಡ್ ಸದಾಶಿವರಾವ್", "ಕಡಪಾ ರಾಘವೇಂದ್ರರಾವ್", "ಆಲೂರು ವೆಂಕಟರಾವ್"),
            correctAnswer = "ಹರ್ಡೇಕರ್ ಮಂಜಪ್ಪ",
            explanation = "ಗಾಂಧೀಜಿಯವರ ತತ್ವಗಳನ್ನು ಕನ್ನಡ ನಾಡಿನಲ್ಲಿ ಪ್ರಚಾರ ಮಾಡಿದ ಹರ್ಡೇಕರ್ ಮಂಜಪ್ಪನವರನ್ನು ಕರ್ನಾಟಕದ ಗಾಂಧಿ ಎನ್ನುತ್ತಾರೆ."
        ),

        // =========================================================================
        // =========================== 9 STD ENGLISH (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_9_eng_1",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the plural form of “Child”?",
            options = listOf("Childs", "Children", "Childes", "Childrens"),
            correctAnswer = "Children",
            explanation = "The irregular plural form of 'child' is 'children'."
        ),
        QuestionModel(
            id = "fln_9_eng_2",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the opposite of “Ancient”.",
            options = listOf("Old", "Historic", "Modern", "Traditional"),
            correctAnswer = "Modern",
            explanation = "The antonym of 'ancient' (belonging to very distant past) is 'modern'."
        ),
        QuestionModel(
            id = "fln_9_eng_3",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the synonym of “Brave”.",
            options = listOf("Cowardly", "Courageous", "Weak", "Lazy"),
            correctAnswer = "Courageous",
            explanation = "'Courageous' has the same meaning as 'brave'."
        ),
        QuestionModel(
            id = "fln_9_eng_4",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: She _____ to school every day.",
            options = listOf("go", "going", "goes", "gone"),
            correctAnswer = "goes",
            explanation = "Third-person singular 'she' takes 'goes' in simple present."
        ),
        QuestionModel(
            id = "fln_9_eng_5",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct article: He is _____ honest man.",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "an",
            explanation = "'Honest' starts with a vowel sound (/ɒ/), requiring article 'an'."
        ),
        QuestionModel(
            id = "fln_9_eng_6",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the past tense of “Write”?",
            options = listOf("Writed", "Written", "Wrote", "Writing"),
            correctAnswer = "Wrote",
            explanation = "Simple past tense of 'write' is 'wrote'."
        ),
        QuestionModel(
            id = "fln_9_eng_7",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the noun in the sentence: “The bird sings sweetly.”",
            options = listOf("The", "Bird", "Sings", "Sweetly"),
            correctAnswer = "Bird",
            explanation = "'Bird' is the naming noun in this sentence."
        ),
        QuestionModel(
            id = "fln_9_eng_8",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct pronoun: Ravi is my friend. _____ is kind.",
            options = listOf("She", "It", "He", "They"),
            correctAnswer = "He",
            explanation = "'He' is the appropriate subject pronoun for Ravi."
        ),
        QuestionModel(
            id = "fln_9_eng_9",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: They _____ playing cricket now.",
            options = listOf("is", "am", "are", "was"),
            correctAnswer = "are",
            explanation = "Plural subject 'They' takes 'are' in present continuous tense."
        ),
        QuestionModel(
            id = "fln_9_eng_10",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct spelling.",
            options = listOf("Beautifull", "Beutiful", "Beautiful", "Beautifal"),
            correctAnswer = "Beautiful",
            explanation = "The correct spelling is B-e-a-u-t-i-f-u-l."
        ),
        QuestionModel(
            id = "fln_9_eng_11",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the adjective: “It is a beautiful flower.”",
            options = listOf("It", "Is", "Beautiful", "Flower"),
            correctAnswer = "Beautiful",
            explanation = "'Beautiful' describes the noun 'flower'."
        ),
        QuestionModel(
            id = "fln_9_eng_12",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the opposite of “Victory”.",
            options = listOf("Success", "Defeat", "Achievement", "Progress"),
            correctAnswer = "Defeat",
            explanation = "The opposite of victory (win) is defeat (loss)."
        ),
        QuestionModel(
            id = "fln_9_eng_13",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: I have lived here _____ 2020.",
            options = listOf("for", "since", "from", "by"),
            correctAnswer = "since",
            explanation = "'Since' is used for a specific starting point in time (2020)."
        ),
        QuestionModel(
            id = "fln_9_eng_14",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct question tag: You are a student, _____?",
            options = listOf("are you", "do you", "aren't you", "isn't it"),
            correctAnswer = "aren't you",
            explanation = "Positive statement with 'are' takes negative question tag 'aren't you'."
        ),
        QuestionModel(
            id = "fln_9_eng_15",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the verb: “The children played football.”",
            options = listOf("Children", "Played", "Football", "The"),
            correctAnswer = "Played",
            explanation = "'Played' is the action verb in the past tense."
        ),
        QuestionModel(
            id = "fln_9_eng_16",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct comparative form of “Good”.",
            options = listOf("Gooder", "More good", "Best", "Better"),
            correctAnswer = "Better",
            explanation = "Comparative degree of 'good' is 'better' (superlative is 'best')."
        ),
        QuestionModel(
            id = "fln_9_eng_17",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: If it rains, we _____ stay at home.",
            options = listOf("will", "would have", "had", "were"),
            correctAnswer = "will",
            explanation = "First conditional: If + present, will + base verb."
        ),
        QuestionModel(
            id = "fln_9_eng_18",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct passive voice: “Ravi wrote a letter.”",
            options = listOf("A letter is written by Ravi.", "A letter was written by Ravi.", "Ravi was written a letter.", "A letter has write by Ravi."),
            correctAnswer = "A letter was written by Ravi.",
            explanation = "Past simple 'wrote' becomes passive 'was written by'."
        ),
        QuestionModel(
            id = "fln_9_eng_19",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the plural form of “Mouse”?",
            options = listOf("Mouses", "Mices", "Mice", "Mousees"),
            correctAnswer = "Mice",
            explanation = "The irregular plural of 'mouse' is 'mice'."
        ),
        QuestionModel(
            id = "fln_9_eng_20",
            stdId = 9,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct indirect speech: He said, “I am happy.”",
            options = listOf("He said that I am happy.", "He said that he was happy.", "He says that he happy.", "He said he is happily."),
            correctAnswer = "He said that he was happy.",
            explanation = "Direct speech 'am' becomes 'was' in indirect speech."
        ),
        // =========================================================================
        // =========================== 9 STD MATHEMATICS (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_9_mat_1",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "(-8) + 15 ರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("7", "−7", "23", "−23"),
            correctAnswer = "7",
            explanation = "15 - 8 = 7."
        ),
        QuestionModel(
            id = "fln_9_mat_2",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "3/5 + 1/5 ರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("4/10", "4/5", "2/5", "3/10"),
            correctAnswer = "4/5",
            explanation = "ಛೇದಗಳು ಸಮನಾಗಿದ್ದಾಗ ಅಂಶಗಳನ್ನು ಕೂಡಿಸಿದರೆ: 3/5 + 1/5 = 4/5."
        ),
        QuestionModel(
            id = "fln_9_mat_3",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "2⁵ ರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("10", "16", "32", "25"),
            correctAnswer = "32",
            explanation = "2 × 2 × 2 × 2 × 2 = 32."
        ),
        QuestionModel(
            id = "fln_9_mat_4",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "√144 ರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("10", "11", "12", "14"),
            correctAnswer = "12",
            explanation = "12 × 12 = 144, ಆದ್ದರಿಂದ √144 = 12."
        ),
        QuestionModel(
            id = "fln_9_mat_5",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "3x + 5 = 20 ಆದರೆ x ನ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("3", "5", "7", "10"),
            correctAnswer = "5",
            explanation = "3x = 20 - 5 = 15 => x = 15 / 3 = 5."
        ),
        QuestionModel(
            id = "fln_9_mat_6",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "5a + 3a - 2a ಸರಳ ರೂಪ ಯಾವುದು?",
            options = listOf("10a", "6a", "8a", "5a"),
            correctAnswer = "6a",
            explanation = "5a + 3a = 8a; 8a - 2a = 6a."
        ),
        QuestionModel(
            id = "fln_9_mat_7",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "x² - 9 ರ ಅಪವರ್ತನ ರೂಪ ಯಾವುದು?",
            options = listOf("(x - 3)(x + 3)", "(x - 9)(x + 1)", "(x - 3)²", "(x + 9)(x - 1)"),
            correctAnswer = "(x - 3)(x + 3)",
            explanation = "a² - b² = (a - b)(a + b); x² - 3² = (x - 3)(x + 3)."
        ),
        QuestionModel(
            id = "fln_9_mat_8",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "x = 2 ಆದರೆ x² + 3x + 1 ರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("7", "9", "11", "13"),
            correctAnswer = "11",
            explanation = "x=2 ಆದಾಗ 2² + 3(2) + 1 = 4 + 6 + 1 = 11."
        ),
        QuestionModel(
            id = "fln_9_mat_9",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ತ್ರಿಭುಜದ ಮೂರು ಒಳಕೋನಗಳ ಮೊತ್ತ ಎಷ್ಟು?",
            options = listOf("90°", "180°", "270°", "360°"),
            correctAnswer = "180°",
            explanation = "ಯಾವುದೇ ತ್ರಿಭುಜದ ಒಳಕೋನಗಳ ಮೊತ್ತ ಯಾವಾಗಲೂ 180° ಆಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_9_mat_10",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ತ್ರಿಭುಜದ ಎರಡು ಕೋನಗಳು 50° ಮತ್ತು 60° ಆಗಿದ್ದರೆ, ಮೂರನೇ ಕೋನ ಎಷ್ಟು?",
            options = listOf("60°", "70°", "80°", "90°"),
            correctAnswer = "70°",
            explanation = "180° - (50° + 60°) = 180° - 110° = 70°."
        ),
        QuestionModel(
            id = "fln_9_mat_11",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಚೌಕದ ಒಂದು ಬದಿಯ ಉದ್ದ 8 ಸೆಂ.ಮೀ. ಆಗಿದ್ದರೆ, ಅದರ ವಿಸ್ತೀರ್ಣ ಎಷ್ಟು?",
            options = listOf("16 ಚ.ಸೆಂ.ಮೀ.", "32 ಚ.ಸೆಂ.ಮೀ.", "64 ಚ.ಸೆಂ.ಮೀ.", "80 ಚ.ಸೆಂ.ಮೀ."),
            correctAnswer = "64 ಚ.ಸೆಂ.ಮೀ.",
            explanation = "ಚೌಕದ ವಿಸ್ತೀರ್ಣ = ಬಾಹು × ಬಾಹು = 8 × 8 = 64 ಚ.ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "fln_9_mat_12",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಉದ್ದ 12 ಸೆಂ.ಮೀ. ಮತ್ತು ಅಗಲ 5 ಸೆಂ.ಮೀ. ಇರುವ ಆಯತದ ಪರಿಮಿತಿ ಎಷ್ಟು?",
            options = listOf("17 ಸೆಂ.ಮೀ.", "34 ಸೆಂ.ಮೀ.", "60 ಸೆಂ.ಮೀ.", "30 ಸೆಂ.ಮೀ."),
            correctAnswer = "34 ಸೆಂ.ಮೀ.",
            explanation = "ಆಯತದ ಪರಿಮಿತಿ = 2(ಉದ್ದ + ಅಗಲ) = 2(12 + 5) = 2(17) = 34 ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "fln_9_mat_13",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ತ್ರಿಜ್ಯ 7 ಸೆಂ.ಮೀ. ಇರುವ ವೃತ್ತದ ಸುತ್ತಳತೆ ಎಷ್ಟು? (π = 22/7)",
            options = listOf("22 ಸೆಂ.ಮೀ.", "44 ಸೆಂ.ಮೀ.", "49 ಸೆಂ.ಮೀ.", "154 ಸೆಂ.ಮೀ."),
            correctAnswer = "44 ಸೆಂ.ಮೀ.",
            explanation = "ವೃತ್ತದ ಸುತ್ತಳತೆ = 2πr = 2 × (22/7) × 7 = 44 ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "fln_9_mat_14",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "200 ರಲ್ಲಿ 25% ಎಷ್ಟು?",
            options = listOf("25", "40", "50", "75"),
            correctAnswer = "50",
            explanation = "200 × (25/100) = 50."
        ),
        QuestionModel(
            id = "fln_9_mat_15",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "₹800 ಮೌಲ್ಯದ ವಸ್ತುವಿಗೆ 10% ರಿಯಾಯಿತಿ ನೀಡಿದರೆ, ರಿಯಾಯಿತಿ ಮೊತ್ತ ಎಷ್ಟು?",
            options = listOf("₹40", "₹60", "₹80", "₹100"),
            correctAnswer = "₹80",
            explanation = "800 ರ 10% = 800 × 0.10 = ₹80."
        ),
        QuestionModel(
            id = "fln_9_mat_16",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "4, 6, 8, 10, 12 ಇವುಗಳ ಸರಾಸರಿ ಎಷ್ಟು?",
            options = listOf("6", "8", "10", "12"),
            correctAnswer = "8",
            explanation = "(4 + 6 + 8 + 10 + 12) / 5 = 40 / 5 = 8."
        ),
        QuestionModel(
            id = "fln_9_mat_17",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ನಾಣ್ಯವನ್ನು ಒಮ್ಮೆ ಎಸೆದಾಗ ತಲೆ ಬೀಳುವ ಸಂಭವನೀಯತೆ ಎಷ್ಟು?",
            options = listOf("1/4", "1/3", "1/2", "1"),
            correctAnswer = "1/2",
            explanation = "ಸಾಧ್ಯ ಫಲಿತಾಂಶಗಳು: {ತಲೆ, ಬಾಲ} = 2. ತಲೆ ಬೀಳುವ ಸಂಭವನೀಯತೆ = 1/2."
        ),
        QuestionModel(
            id = "fln_9_mat_18",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "x + y = 10 ಮತ್ತು x = 4 ಆದರೆ y ನ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("4", "5", "6", "10"),
            correctAnswer = "6",
            explanation = "4 + y = 10 => y = 10 - 4 = 6."
        ),
        QuestionModel(
            id = "fln_9_mat_19",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಘನದ ಒಂದು ಅಂಚು 3 ಸೆಂ.ಮೀ. ಆಗಿದ್ದರೆ, ಅದರ ಘನಫಲ ಎಷ್ಟು?",
            options = listOf("9 ಘ.ಸೆಂ.ಮೀ.", "18 ಘ.ಸೆಂ.ಮೀ.", "27 ಘ.ಸೆಂ.ಮೀ.", "36 ಘ.ಸೆಂ.ಮೀ."),
            correctAnswer = "27 ಘ.ಸೆಂ.ಮೀ.",
            explanation = "ಘನಫಲ = a³ = 3 × 3 × 3 = 27 ಘ.ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "fln_9_mat_20",
            stdId = 9,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "12 ಮತ್ತು 18 ರ ಮಹತ್ತಮ ಸಾಮಾನ್ಯ ಅಪವರ್ತಕ (ಮ.ಸಾ.ಅ.) ಯಾವುದು?",
            options = listOf("2", "3", "6", "9"),
            correctAnswer = "6",
            explanation = "12 ಮತ್ತು 18 ನ್ನು ಭಾಗಿಸುವ ಗರಿಷ್ಠ ಸಂಖ್ಯೆ 6 (HCF = 6)."
        ),
        // =========================================================================
        // =========================== 10 STD KANNADA (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_10_kan_1",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ ಸ್ವತಂತ್ರವಾಗಿ ಉಚ್ಚರಿಸಬಹುದಾದ ವರ್ಣಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ವ್ಯಂಜನಗಳು", "ಸ್ವರಗಳು", "ಒತ್ತಕ್ಷರಗಳು", "ಸಂಯುಕ್ತಾಕ್ಷರಗಳು"),
            correctAnswer = "ಸ್ವರಗಳು",
            explanation = "ಸ್ವಯಂ ರಾಜಂತೇ ಇತಿ ಸ್ವರಾಃ - ಸ್ವತಂತ್ರವಾಗಿ ಉಚ್ಚರಿಸಲಾಗುವ ವರ್ಣಗಳೇ ಸ್ವರಗಳು."
        ),
        QuestionModel(
            id = "fln_10_kan_2",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಕೈಕೆಲಸ’ ಪದವು ಯಾವ ರೀತಿಯ ಪದಕ್ಕೆ ಉದಾಹರಣೆ?",
            options = listOf("ಜೋಡುಪದ", "ಕ್ರಿಯಾಪದ", "ಸರ್ವನಾಮ", "ಅವ್ಯಯ"),
            correctAnswer = "ಜೋಡುಪದ",
            explanation = "ಕೈ ಮತ್ತು ಕೆಲಸ ಒಟ್ಟಿಗೆ ಸೇರಿ ಆದ ಜೋಡುಪದ/ಸಮಸ್ತ ಪದ."
        ),
        QuestionModel(
            id = "fln_10_kan_3",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಸತ್ಯ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ನ್ಯಾಯ", "ಧರ್ಮ", "ಅಸತ್ಯ", "ನೀತಿ"),
            correctAnswer = "ಅಸತ್ಯ",
            explanation = "ಸತ್ಯ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಅಸತ್ಯ ಅಥವಾ ಸುಳ್ಳು."
        ),
        QuestionModel(
            id = "fln_10_kan_4",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಸೂರ್ಯ’ ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಶಶಿ", "ರವಿ", "ನಿಶೆ", "ತಾರೆ"),
            correctAnswer = "ರವಿ",
            explanation = "ಸೂರ್ಯ, ರವಿ, ಭಾನು, ದಿನಕರ ಇವು ಸಮಾನಾರ್ಥಕಗಳು."
        ),
        QuestionModel(
            id = "fln_10_kan_5",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಅವಳು ಹಾಡನ್ನು ಹಾಡಿದಳು’ ಎಂಬ ವಾಕ್ಯದಲ್ಲಿ ಕ್ರಿಯಾಪದ ಯಾವುದು?",
            options = listOf("ಅವಳು", "ಹಾಡನ್ನು", "ಹಾಡಿದಳು", "ಎಂಬ"),
            correctAnswer = "ಹಾಡಿದಳು",
            explanation = "ಕೆಲಸ ಅಥವಾ ಕ್ರಿಯೆಯನ್ನು ಸೂಚಿಸುವ ಪದ 'ಹಾಡಿದಳು'."
        ),
        QuestionModel(
            id = "fln_10_kan_6",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಮಕ್ಕಳು ಶಾಲೆಗೆ ಹೋದರು’ ಎಂಬ ವಾಕ್ಯ ಯಾವ ಕಾಲವನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ವರ್ತಮಾನಕಾಲ", "ಭೂತಕಾಲ", "ಭವಿಷ್ಯತ್ಕಾಲ", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ಭೂತಕಾಲ",
            explanation = "ಕ್ರಿಯೆ ನಡೆದು ಮುಗಿದಿರುವುದರಿಂದ ಇದು ಭೂತಕಾಲ."
        ),
        QuestionModel(
            id = "fln_10_kan_7",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಒಳ್ಳೆಯ’ ಪದವು ಯಾವ ಪದಭೇದಕ್ಕೆ ಸೇರಿದೆ?",
            options = listOf("ನಾಮಪದ", "ಸರ್ವನಾಮ", "ವಿಶೇಷಣ", "ಕ್ರಿಯಾಪದ"),
            correctAnswer = "ವಿಶೇಷಣ",
            explanation = "ನಾಮಪದದ ಗುಣ ಲಕ್ಷಣಗಳನ್ನು ತಿಳಿಸುವ ಪದ ವಿಶೇಷಣ."
        ),
        QuestionModel(
            id = "fln_10_kan_8",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ನಾವು’ ಯಾವ ಪದಭೇದಕ್ಕೆ ಸೇರಿದೆ?",
            options = listOf("ನಾಮಪದ", "ಸರ್ವನಾಮ", "ಕ್ರಿಯಾಪದ", "ವಿಶೇಷಣ"),
            correctAnswer = "ಸರ್ವನಾಮ",
            explanation = "ನಾಮಪದದ ಬದಲಾಗಿ ಬಳಸುವ ಪದ ಸರ್ವನಾಮ (ಪ್ರಥಮ ಪುರುಷ ಬಹುವಚನ)."
        ),
        QuestionModel(
            id = "fln_10_kan_9",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಕತ್ತಲೆ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ರಾತ್ರಿ", "ನೆರಳು", "ಬೆಳಕು", "ಮೋಡ"),
            correctAnswer = "ಬೆಳಕು",
            explanation = "ಕತ್ತಲೆಯ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಬೆಳಕು."
        ),
        QuestionModel(
            id = "fln_10_kan_10",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಮರಗಳು’ ಪದದ ಏಕವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ಮರಕ್ಕೆ", "ಮರದಿಂದ", "ಮರ", "ಮರದ"),
            correctAnswer = "ಮರ",
            explanation = "'ಮರ' ಎಂಬುದು ಏಕವಚನ, 'ಮರಗಳು' ಬಹುವಚನ."
        ),
        QuestionModel(
            id = "fln_10_kan_11",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಹಕ್ಕಿ ಆಕಾಶದಲ್ಲಿ ಹಾರುತ್ತದೆ’ ಎಂಬ ವಾಕ್ಯದಲ್ಲಿ ಕರ್ತೃ ಯಾವುದು?",
            options = listOf("ಆಕಾಶದಲ್ಲಿ", "ಹಾರುತ್ತದೆ", "ಹಕ್ಕಿ", "ಎಂಬ"),
            correctAnswer = "ಹಕ್ಕಿ",
            explanation = "ಕ್ರಿಯೆಯನ್ನು ಮಾಡುವ ಮುಖ್ಯ ನಾಮಪದ 'ಹಕ್ಕಿ' ಕರ್ತೃ ಪದ."
        ),
        QuestionModel(
            id = "fln_10_kan_12",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ವೇಗವಾಗಿ’ ಪದವು ಯಾವ ಪದಭೇದಕ್ಕೆ ಸೇರಿದೆ?",
            options = listOf("ನಾಮಪದ", "ಕ್ರಿಯಾವಿಶೇಷಣ", "ಸರ್ವನಾಮ", "ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ"),
            correctAnswer = "ಕ್ರಿಯಾವಿಶೇಷಣ",
            explanation = "ಕ್ರಿಯಾಪದದ ರೀತಿ ಅಥವಾ ವೇಗವನ್ನು ವಿವರಿಸುವ ಪದ ಕ್ರಿಯಾವಿಶೇಷಣ."
        ),
        QuestionModel(
            id = "fln_10_kan_13",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ವಿದ್ಯೆ’ ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಜ್ಞಾನ", "ಅಜ್ಞಾನ", "ಕೋಪ", "ಭಯ"),
            correctAnswer = "ಜ್ಞಾನ",
            explanation = "ವಿದ್ಯೆ ಎಂದರೆ ಜ್ಞಾನ, ಅರಿವು."
        ),
        QuestionModel(
            id = "fln_10_kan_14",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಧೈರ್ಯ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಸಾಹಸ", "ಶೌರ್ಯ", "ಭಯ", "ಶಕ್ತಿ"),
            correctAnswer = "ಭಯ",
            explanation = "ಧೈರ್ಯದ ವಿರುದ್ಧಾರ್ಥಕ ಭಯ ಅಥವಾ ಹೇಡಿತನ."
        ),
        QuestionModel(
            id = "fln_10_kan_15",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಅವನು ನಾಳೆ ಪರೀಕ್ಷೆ ಬರೆಯುವನು’ ಎಂಬ ವಾಕ್ಯ ಯಾವ ಕಾಲವನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಭೂತಕಾಲ", "ವರ್ತಮಾನಕಾಲ", "ಭವಿಷ್ಯತ್ಕಾಲ", "ಅಪೂರ್ಣ ಭೂತಕಾಲ"),
            correctAnswer = "ಭವಿಷ್ಯತ್ಕಾಲ",
            explanation = "ಮುಂದೆ ನಡೆಯಲಿರುವ ಕೆಲಸವನ್ನು ತಿಳಿಸುವುದು ಭವಿಷ್ಯತ್ಕಾಲ."
        ),
        QuestionModel(
            id = "fln_10_kan_16",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ಮನೆಮನೆಗೆ’ ಎಂಬ ಪದವು ಯಾವ ಅರ್ಥವನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಒಂದೇ ಮನೆ", "ಪ್ರತಿಯೊಂದು ಮನೆಗೆ", "ಮನೆಯ ಒಳಗೆ ಮಾತ್ರ", "ಮನೆಯ ಹಿಂದೆ ಮಾತ್ರ"),
            correctAnswer = "ಪ್ರತಿಯೊಂದು ಮನೆಗೆ",
            explanation = "ದ್ವಿರುಕ್ತಿ ರೂಪ 'ಮನೆಮನೆಗೆ' ಎಂದರೆ ಪ್ರತಿಯೊಂದು ಮನೆಗೂ ಎಂದರ್ಥ."
        ),
        QuestionModel(
            id = "fln_10_kan_17",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಗದ್ಯ ಮತ್ತು ಪದ್ಯಗಳ ನಡುವಿನ ಮುಖ್ಯ ವ್ಯತ್ಯಾಸ ಯಾವುದು?",
            options = listOf("ಗದ್ಯವು ಸಾಮಾನ್ಯ ವಾಕ್ಯರಚನೆಯಲ್ಲಿರುತ್ತದೆ; ಪದ್ಯವು ಛಂದಸ್ಸು ಅಥವಾ ಕಾವ್ಯಾತ್ಮಕ ರಚನೆ ಹೊಂದಿರಬಹುದು", "ಗದ್ಯದಲ್ಲಿ ಅರ್ಥವಿರುವುದಿಲ್ಲ", "ಪದ್ಯದಲ್ಲಿ ಪದಗಳಿರುವುದಿಲ್ಲ", "ಎರಡೂ ಯಾವಾಗಲೂ ಒಂದೇ ರೂಪದಲ್ಲಿರುತ್ತವೆ"),
            correctAnswer = "ಗದ್ಯವು ಸಾಮಾನ್ಯ ವಾಕ್ಯರಚನೆಯಲ್ಲಿರುತ್ತದೆ; ಪದ್ಯವು ಛಂದಸ್ಸು ಅಥವಾ ಕಾವ್ಯಾತ್ಮಕ ರಚನೆ ಹೊಂದಿರಬಹುದು",
            explanation = "ಗದ್ಯವು ಸಾಮಾನ್ಯ ವಾಕ್ಯ ರೂಪದಲ್ಲಿದ್ದು, ಪದ್ಯವು ಲಯ, ಛಂದಸ್ಸು ಹಾಗೂ ಪ್ರಾಸವನ್ನು ಹೊಂದಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_10_kan_18",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಂದು ವಾಕ್ಯದಲ್ಲಿ ಪ್ರಶ್ನೆಯನ್ನು ಸೂಚಿಸಲು ಸಾಮಾನ್ಯವಾಗಿ ಯಾವ ವಿರಾಮಚಿಹ್ನೆ ಬಳಸಲಾಗುತ್ತದೆ?",
            options = listOf("ಪೂರ್ಣವಿರಾಮ (.)", "ಅಲ್ಪವಿರಾಮ (,)", "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ (?)", "ಉದ್ಗಾರ ಚಿಹ್ನೆ (!)"),
            correctAnswer = "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ (?)",
            explanation = "ಪ್ರಶ್ನೆ ವಾಕ್ಯಗಳ ಕೊನೆಯಲ್ಲಿ ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ (?) ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "fln_10_kan_19",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "‘ದೇಶಪ್ರೇಮ’ ಎಂದರೆ ಏನು?",
            options = listOf("ದೇಶದ ಬಗ್ಗೆ ಪ್ರೀತಿ ಮತ್ತು ಗೌರವ", "ಇತರರನ್ನು ಅವಮಾನಿಸುವುದು", "ಪ್ರಕೃತಿಯನ್ನು ನಾಶಮಾಡುವುದು", "ಸಾರ್ವಜನಿಕ ಆಸ್ತಿಯನ್ನು ಹಾಳುಮಾಡುವುದು"),
            correctAnswer = "ದೇಶದ ಬಗ್ಗೆ ಪ್ರೀತಿ ಮತ್ತು ಗೌರವ",
            explanation = "ಸ್ವದೇಶದ ಬಗ್ಗೆ ಇರುವ ನಿಷ್ಠೆ, ಭಕ್ತಿ ಮತ್ತು ಗೌರವವೇ ದೇಶಪ್ರೇಮ."
        ),
        QuestionModel(
            id = "fln_10_kan_20",
            stdId = 10,
            subjectId = "fln",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪರಿಣಾಮಕಾರಿ ಸಂವಹನಕ್ಕೆ ಅತ್ಯಂತ ಅಗತ್ಯವಾದದ್ದು ಯಾವುದು?",
            options = listOf("ಸ್ಪಷ್ಟವಾದ ಅಭಿವ್ಯಕ್ತಿ ಮತ್ತು ಗಮನವಿಟ್ಟು ಕೇಳುವುದು", "ಇತರರ ಮಾತನ್ನು ಮಧ್ಯದಲ್ಲೇ ನಿಲ್ಲಿಸುವುದು", "ಅಸ್ಪಷ್ಟವಾಗಿ ಮಾತನಾಡುವುದು", "ತಪ್ಪು ಮಾಹಿತಿಯನ್ನು ಹರಡುವುದು"),
            correctAnswer = "ಸ್ಪಷ್ಟವಾದ ಅಭಿವ್ಯಕ್ತಿ ಮತ್ತು ಗಮನವಿಟ್ಟು ಕೇಳುವುದು",
            explanation = "ಉತ್ತಮ ಸಂವಹನಕ್ಕೆ ಸ್ಪಷ್ಟ ಮಾತು ಮತ್ತು ಆಲಿಸುವಿಕೆ ಅತ್ಯಗತ್ಯ."
        ),
        // =========================================================================
        // =========================== 10 STD ENGLISH (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_10_eng_1",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the synonym of “Abundant”.",
            options = listOf("Scarce", "Plentiful", "Empty", "Little"),
            correctAnswer = "Plentiful",
            explanation = "'Abundant' means existing or available in large quantities; plentiful."
        ),
        QuestionModel(
            id = "fln_10_eng_2",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the antonym of “Expand”.",
            options = listOf("Increase", "Extend", "Contract", "Enlarge"),
            correctAnswer = "Contract",
            explanation = "To expand means to grow larger; contract means to decrease or shrink."
        ),
        QuestionModel(
            id = "fln_10_eng_3",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: Neither Ravi nor his friends _____ present yesterday.",
            options = listOf("was", "were", "is", "has"),
            correctAnswer = "were",
            explanation = "With 'neither... nor', the verb agrees with the closer plural subject 'his friends'."
        ),
        QuestionModel(
            id = "fln_10_eng_4",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct passive voice: “The teacher praised the student.”",
            options = listOf("The student praises the teacher.", "The student was praised by the teacher.", "The teacher was praised by the student.", "The student is praising the teacher."),
            correctAnswer = "The student was praised by the teacher.",
            explanation = "Simple past 'praised' turns into 'was praised by'."
        ),
        QuestionModel(
            id = "fln_10_eng_5",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct indirect speech: She said, “I am tired.”",
            options = listOf("She said that I am tired.", "She said that she was tired.", "She says that she tired.", "She told that I was tired."),
            correctAnswer = "She said that she was tired.",
            explanation = "Tense changes from present ('am') to past ('was') in reported speech."
        ),
        QuestionModel(
            id = "fln_10_eng_6",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the adjective in the sentence: “The diligent student completed the work.”",
            options = listOf("Student", "Completed", "Diligent", "Work"),
            correctAnswer = "Diligent",
            explanation = "'Diligent' (hardworking) is the adjective modifying 'student'."
        ),
        QuestionModel(
            id = "fln_10_eng_7",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct question tag: They have finished the work, _____?",
            options = listOf("haven't they", "don't they", "didn't they", "aren't they"),
            correctAnswer = "haven't they",
            explanation = "Positive statement with 'have finished' takes negative tag 'haven't they'."
        ),
        QuestionModel(
            id = "fln_10_eng_8",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: If I had studied harder, I _____ the examination.",
            options = listOf("will pass", "would pass", "would have passed", "am passing"),
            correctAnswer = "would have passed",
            explanation = "Third conditional: If + past perfect, would have + past participle."
        ),
        QuestionModel(
            id = "fln_10_eng_9",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct spelling.",
            options = listOf("Accomodation", "Accommodation", "Acommodation", "Accommadation"),
            correctAnswer = "Accommodation",
            explanation = "The correct spelling is A-C-C-O-M-M-O-D-A-T-I-O-N (double c, double m)."
        ),
        QuestionModel(
            id = "fln_10_eng_10",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct comparative form of “Little” when referring to quantity.",
            options = listOf("Littler", "Least", "Less", "More little"),
            correctAnswer = "Less",
            explanation = "Degrees of quantity: Little, Less, Least."
        ),
        QuestionModel(
            id = "fln_10_eng_11",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the figure of speech: “The wind whispered through the trees.”",
            options = listOf("Simile", "Personification", "Hyperbole", "Oxymoron"),
            correctAnswer = "Personification",
            explanation = "Giving human action ('whispered') to non-human element ('wind')."
        ),
        QuestionModel(
            id = "fln_10_eng_12",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct preposition: He is good _____ mathematics.",
            options = listOf("in", "on", "at", "for"),
            correctAnswer = "at",
            explanation = "The standard idiom for competence is 'good at' an activity or subject."
        ),
        QuestionModel(
            id = "fln_10_eng_13",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the plural form of “Phenomenon”?",
            options = listOf("Phenomenons", "Phenomena", "Phenomenas", "Phenomeni"),
            correctAnswer = "Phenomena",
            explanation = "'Phenomenon' is a Greek-derived noun whose plural is 'phenomena'."
        ),
        QuestionModel(
            id = "fln_10_eng_14",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct sentence.",
            options = listOf("She do not like coffee.", "She does not likes coffee.", "She does not like coffee.", "She not like coffee."),
            correctAnswer = "She does not like coffee.",
            explanation = "'Does not' takes the bare infinitive 'like'."
        ),
        QuestionModel(
            id = "fln_10_eng_15",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the synonym of “Compassion”.",
            options = listOf("Cruelty", "Sympathy", "Anger", "Hatred"),
            correctAnswer = "Sympathy",
            explanation = "'Compassion' means sympathetic pity and concern for the sufferings of others."
        ),
        QuestionModel(
            id = "fln_10_eng_16",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: By the time we arrived, the train _____.",
            options = listOf("leaves", "has left", "had left", "will leave"),
            correctAnswer = "had left",
            explanation = "Past perfect 'had left' describes an action completed before another past event."
        ),
        QuestionModel(
            id = "fln_10_eng_17",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the antonym of “Optimistic”.",
            options = listOf("Hopeful", "Positive", "Pessimistic", "Confident"),
            correctAnswer = "Pessimistic",
            explanation = "Optimistic (hopeful) is the opposite of pessimistic (expecting worst)."
        ),
        QuestionModel(
            id = "fln_10_eng_18",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Identify the noun clause: “I know that he is honest.”",
            options = listOf("I know", "That he is honest", "He is", "Is honest"),
            correctAnswer = "That he is honest",
            explanation = "'That he is honest' acts as the object of the verb 'know'."
        ),
        QuestionModel(
            id = "fln_10_eng_19",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct passive voice: “People speak English all over the world.”",
            options = listOf("English spoke all over the world.", "English is spoken all over the world.", "English was speaking all over the world.", "People are spoken English."),
            correctAnswer = "English is spoken all over the world.",
            explanation = "Present tense 'speak' becomes 'is spoken by'."
        ),
        QuestionModel(
            id = "fln_10_eng_20",
            stdId = 10,
            subjectId = "fln",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct meaning of the idiom “Once in a blue moon”.",
            options = listOf("Every day", "Very frequently", "Very rarely", "At midnight"),
            correctAnswer = "Very rarely",
            explanation = "The idiom 'once in a blue moon' means something that happens very rarely."
        ),
        // =========================================================================
        // =========================== 10 STD MATHEMATICS (20 MCQs) =====================
        // =========================================================================
        QuestionModel(
            id = "fln_10_mat_1",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "x² - 5x + 6 = 0 ಈ ವರ್ಗ ಸಮೀಕರಣದ ಮೂಲಗಳು ಯಾವುವು?",
            options = listOf("1, 6", "2, 3", "−2, −3", "3, 4"),
            correctAnswer = "2, 3",
            explanation = "(x - 2)(x - 3) = 0 => x = 2 ಅಥವಾ x = 3."
        ),
        QuestionModel(
            id = "fln_10_mat_2",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "2x + 3 = 11 ಆದರೆ x ನ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("2", "3", "4", "5"),
            correctAnswer = "4",
            explanation = "2x = 11 - 3 = 8 => x = 8 / 2 = 4."
        ),
        QuestionModel(
            id = "fln_10_mat_3",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "x² - 9 ರ ಅಪವರ್ತನ ರೂಪ ಯಾವುದು?",
            options = listOf("(x - 3)(x + 3)", "(x - 9)(x + 1)", "(x - 3)²", "(x + 9)(x - 1)"),
            correctAnswer = "(x - 3)(x + 3)",
            explanation = "a² - b² = (a - b)(a + b) => x² - 3² = (x - 3)(x + 3)."
        ),
        QuestionModel(
            id = "fln_10_mat_4",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಮಾಂತರ ಶ್ರೇಣಿ 2, 5, 8, 11, ... ಇದರ ಸಾಮಾನ್ಯ ವ್ಯತ್ಯಾಸ ಎಷ್ಟು?",
            options = listOf("2", "3", "5", "8"),
            correctAnswer = "3",
            explanation = "ಸಾಮಾನ್ಯ ವ್ಯತ್ಯಾಸ d = a₂ - a₁ = 5 - 2 = 3."
        ),
        QuestionModel(
            id = "fln_10_mat_5",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಮಾಂತರ ಶ್ರೇಣಿ 3, 7, 11, 15, ... ಇದರ 10ನೇ ಪದ ಎಷ್ಟು?",
            options = listOf("35", "39", "40", "43"),
            correctAnswer = "39",
            explanation = "a_n = a + (n - 1)d => a₁₀ = 3 + 9(4) = 3 + 36 = 39."
        ),
        QuestionModel(
            id = "fln_10_mat_6",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "x² + 4x + 4 ರ ಅಪವರ್ತನ ರೂಪ ಯಾವುದು?",
            options = listOf("(x + 2)²", "(x - 2)²", "(x + 4)²", "(x - 4)²"),
            correctAnswer = "(x + 2)²",
            explanation = "(x + 2)² = x² + 2(2)x + 2² = x² + 4x + 4."
        ),
        QuestionModel(
            id = "fln_10_mat_7",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ತ್ರಿಭುಜದ ಎರಡು ಕೋನಗಳು 50° ಮತ್ತು 60° ಆಗಿದ್ದರೆ, ಮೂರನೇ ಕೋನ ಎಷ್ಟು?",
            options = listOf("60°", "70°", "80°", "90°"),
            correctAnswer = "70°",
            explanation = "180° - (50° + 60°) = 180° - 110° = 70°."
        ),
        QuestionModel(
            id = "fln_10_mat_8",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "sin 30° ರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("0", "1/2", "√3/2", "1"),
            correctAnswer = "1/2",
            explanation = "ತ್ರಿಕೋನಮಿತಿಯ ಮೂಲ ಕೋನ ಮೌಲ್ಯ: sin 30° = 1/2."
        ),
        QuestionModel(
            id = "fln_10_mat_9",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "cos 60° ರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("0", "1/2", "√3/2", "1"),
            correctAnswer = "1/2",
            explanation = "cos 60° = sin 30° = 1/2."
        ),
        QuestionModel(
            id = "fln_10_mat_10",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "tan 45° ರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("0", "1/2", "1", "√3"),
            correctAnswer = "1",
            explanation = "tan 45° = sin 45° / cos 45° = 1."
        ),
        QuestionModel(
            id = "fln_10_mat_11",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಬಿಂದುಗಳು (0,0) ಮತ್ತು (3,4) ಗಳ ನಡುವಿನ ದೂರ ಎಷ್ಟು?",
            options = listOf("3", "4", "5", "7"),
            correctAnswer = "5",
            explanation = "ದೂರ = √(3² + 4²) = √(9 + 16) = √25 = 5."
        ),
        QuestionModel(
            id = "fln_10_mat_12",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಬಿಂದುಗಳು (2,4) ಮತ್ತು (6,8) ಗಳ ಮಧ್ಯಬಿಂದು ಯಾವುದು?",
            options = listOf("(4,6)", "(8,12)", "(2,6)", "(3,4)"),
            correctAnswer = "(4,6)",
            explanation = "ಮಧ್ಯಬಿಂದು = ((2+6)/2, (4+8)/2) = (8/2, 12/2) = (4,6)."
        ),
        QuestionModel(
            id = "fln_10_mat_13",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ತ್ರಿಜ್ಯ 7 ಸೆಂ.ಮೀ. ಇರುವ ವೃತ್ತದ ವಿಸ್ತೀರ್ಣ ಎಷ್ಟು? (π = 22/7)",
            options = listOf("44 ಚ.ಸೆಂ.ಮೀ.", "77 ಚ.ಸೆಂ.ಮೀ.", "154 ಚ.ಸೆಂ.ಮೀ.", "308 ಚ.ಸೆಂ.ಮೀ."),
            correctAnswer = "154 ಚ.ಸೆಂ.ಮೀ.",
            explanation = "ವಿಸ್ತೀರ್ಣ = πr² = (22/7) × 7 × 7 = 154 ಚ.ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "fln_10_mat_14",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ತ್ರಿಜ್ಯ 7 ಸೆಂ.ಮೀ. ಇರುವ ವೃತ್ತದ ಸುತ್ತಳತೆ ಎಷ್ಟು? (π = 22/7)",
            options = listOf("22 ಸೆಂ.ಮೀ.", "44 ಸೆಂ.ಮೀ.", "49 ಸೆಂ.ಮೀ.", "154 ಸೆಂ.ಮೀ."),
            correctAnswer = "44 ಸೆಂ.ಮೀ.",
            explanation = "ಸುತ್ತಳತೆ = 2πr = 2 × (22/7) × 7 = 44 ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "fln_10_mat_15",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "5, 7, 9, 11, 13 ಇವುಗಳ ಸರಾಸರಿ ಎಷ್ಟು?",
            options = listOf("7", "8", "9", "11"),
            correctAnswer = "9",
            explanation = "ಸರಾಸರಿ = (5 + 7 + 9 + 11 + 13) / 5 = 45 / 5 = 9."
        ),
        QuestionModel(
            id = "fln_10_mat_16",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ನಾಣ್ಯವನ್ನು ಒಮ್ಮೆ ಎಸೆದಾಗ ತಲೆ ಬೀಳುವ ಸಂಭವನೀಯತೆ ಎಷ್ಟು?",
            options = listOf("1/4", "1/3", "1/2", "1"),
            correctAnswer = "1/2",
            explanation = "P(ತಲೆ) = 1/2."
        ),
        QuestionModel(
            id = "fln_10_mat_17",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಘನದ ಅಂಚು 4 ಸೆಂ.ಮೀ. ಆಗಿದ್ದರೆ, ಅದರ ಘನಫಲ ಎಷ್ಟು?",
            options = listOf("16 ಘ.ಸೆಂ.ಮೀ.", "32 ಘ.ಸೆಂ.ಮೀ.", "48 ಘ.ಸೆಂ.ಮೀ.", "64 ಘ.ಸೆಂ.ಮೀ."),
            correctAnswer = "64 ಘ.ಸೆಂ.ಮೀ.",
            explanation = "ಘನಫಲ = a³ = 4 × 4 × 4 = 64 ಘ.ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "fln_10_mat_18",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಸಿಲಿಂಡರಿನ ತ್ರಿಜ್ಯ 3 ಸೆಂ.ಮೀ. ಮತ್ತು ಎತ್ತರ 5 ಸೆಂ.ಮೀ. ಆಗಿದ್ದರೆ, ಅದರ ಘನಫಲ ಎಷ್ಟು?",
            options = listOf("15π ಘ.ಸೆಂ.ಮೀ.", "30π ಘ.ಸೆಂ.ಮೀ.", "45π ಘ.ಸೆಂ.ಮೀ.", "60π ಘ.ಸೆಂ.ಮೀ."),
            correctAnswer = "45π ಘ.ಸೆಂ.ಮೀ.",
            explanation = "ಸಿಲಿಂಡರ್ ಘನಫಲ = πr²h = π × 3² × 5 = 45π ಘ.ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "fln_10_mat_19",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "x² - 7x + 12 = 0 ಸಮೀಕರಣದ ಮೂಲಗಳು ಯಾವುವು?",
            options = listOf("2 ಮತ್ತು 6", "3 ಮತ್ತು 4", "−3 ಮತ್ತು −4", "1 ಮತ್ತು 12"),
            correctAnswer = "3 ಮತ್ತು 4",
            explanation = "(x - 3)(x - 4) = 0 => x = 3 ಮತ್ತು x = 4."
        ),
        QuestionModel(
            id = "fln_10_mat_20",
            stdId = 10,
            subjectId = "fln",
            unitId = 3,
            type = "MCQ",
            questionText = "ಎರಡು ಸಂಖ್ಯೆಗಳ ಮ.ಸಾ.ಅ. 6 ಮತ್ತು ಅವುಗಳ ಲ.ಸಾ.ಅ. 36 ಆಗಿದೆ. ಒಂದು ಸಂಖ್ಯೆ 12 ಆಗಿದ್ದರೆ, ಇನ್ನೊಂದು ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("12", "18", "24", "36"),
            correctAnswer = "18",
            explanation = "ಲ.ಸಾ.ಅ. × ಮ.ಸಾ.ಅ. = ಸಂಖ್ಯೆ1 × ಸಂಖ್ಯೆ2 => 36 × 6 = 12 × x => 216 / 12 = 18."
        )
    )
}
