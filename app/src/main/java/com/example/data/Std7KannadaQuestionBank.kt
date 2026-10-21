package com.example.data

/**
 * Standard 7 Kannada (LBA Revised 2026-27, 7thKannadaLBARevised_1787048371.pdf)
 * Question bank containing authentic MCQs and converted fill-in-the-blanks across chapters.
 */
object Std7KannadaQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಅಧ್ಯಾಯ 1: ಪುಟ್ಟಜ್ಜಿ ಪುಟ್ಟಜ್ಜಿ ಕಥೆ ಹೇಳು", 9, "Easy"),
        UnitTemplate(2, "ಅಧ್ಯಾಯ 2: ಸೀನಶೆಟ್ಟರು ನಮ್ಮ ಟೀಚರ್", 14, "Medium"),
        UnitTemplate(3, "ಅಧ್ಯಾಯ 3: ಹಿಲ್ಟನ್ ಹೆಡ್ ಚಳವಳಿ", 10, "Medium"),
        UnitTemplate(4, "ಅಧ್ಯಾಯ 4: ಮೈಲಾರ ಮಹದೇವ", 7, "Medium"),
        UnitTemplate(5, "ಅಧ್ಯಾಯ 5: ಪರಿಸರ ಸಮತೋಲನ", 13, "Medium"),
        UnitTemplate(6, "ಅಧ್ಯಾಯ 6: ಚಗಳಿ ಇರುವೆ", 8, "Easy"),
        UnitTemplate(7, "ಅಧ್ಯಾಯ 7: ಬಿಲ್ಲ ಹಬ್ಬ", 28, "Hard"),
        UnitTemplate(8, "ಅಧ್ಯಾಯ 8: ಸಂಕ್ರಾಂತಿಯಂದು ಸುಖ–ದುಃಖ", 18, "Medium"),
        UnitTemplate(9, "ಅಧ್ಯಾಯ 9: ಹುತ್ತರಿ ಹಾಡು", 12, "Medium"),
        UnitTemplate(10, "ಅಧ್ಯಾಯ 10: ಸ್ವಾತಂತ್ರ್ಯ ಸ್ವರ್ಗ", 14, "Medium"),
        UnitTemplate(11, "ಅಧ್ಯಾಯ 11: ಹಚ್ಚೇವು ಕನ್ನಡದ ದೀಪ", 16, "Easy"),
        UnitTemplate(12, "ಅಧ್ಯಾಯ 12: ಬಿಡುಗಡೆಯ ಹಾಡು", 19, "Medium"),
        UnitTemplate(13, "ಅಧ್ಯಾಯ 13: ತಿರುಕನ ಕನಸು", 26, "Medium"),
        UnitTemplate(14, "ಅಧ್ಯಾಯ 14: ಅಭಿಮನ್ಯು ಪರಾಕ್ರಮ", 15, "Hard"),
        UnitTemplate(15, "ಘಟಕ 15: ಭಾಗ್ಯದ ಬಳೆಗಾರ", 8, "Easy"),
        UnitTemplate(16, "ಘಟಕ 16: ವಚನಗಳ ಭಾವ ಸಂಗಮ", 9, "Medium")
    )

    val questions: List<QuestionModel> = listOf(
        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 1: ಪುಟ್ಟಜ್ಜಿ ಪುಟ್ಟಜ್ಜಿ ಕಥೆ ಹೇಳು (Unit 1)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u1_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಂದು ಕಾಡಿನಲ್ಲಿ ಒಂದು ______ ಪಾರಿವಾಳ ವಾಸವಾಗಿತ್ತು.",
            options = listOf("ದೊಡ್ಡ", "ಪುಟ್ಟ", "ಬಿಳಿಯ", "ಕಪ್ಪು"),
            correctAnswer = "ಪುಟ್ಟ",
            explanation = "ಕಥೆಯ ಪ್ರಕಾರ ಕಾಡಿನಲ್ಲಿ ಒಂದು ಪುಟ್ಟ ಪಾರಿವಾಳ ವಾಸವಾಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u1_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮರದ ಕೆಳಗಿದ್ದ ಆಳದ ______ ಇರುವೆಯೊಂದು ಬಿದ್ದುಕೊಂಡಿತ್ತು.",
            options = listOf("ಗುಂಡಿಯಲ್ಲಿ", "ನೆಲದಲ್ಲಿ", "ನೀರಿನಲ್ಲಿ", "ಮರದಲ್ಲಿ"),
            correctAnswer = "ನೀರಿನಲ್ಲಿ",
            explanation = "ಮರದ ಕೆಳಗಿದ್ದ ಆಳದ ನೀರಿನಲ್ಲಿ ಇರುವೆಯೊಂದು ಬಿದ್ದುಕೊಂಡಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u1_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಇರುವೆಯು ತನ್ನ ______ ಉಳಿಸಿಕೊಳ್ಳಲು ಒದ್ದಾಡುತ್ತಿತ್ತು.",
            options = listOf("ಆಹಾರ", "ಗೂಡು", "ದೇಹ", "ಪ್ರಾಣ"),
            correctAnswer = "ಪ್ರಾಣ",
            explanation = "ನೀರಿನಲ್ಲಿ ಬಿದ್ದ ಇರುವೆ ತನ್ನ ಪ್ರಾಣ ಉಳಿಸಿಕೊಳ್ಳಲು ಒದ್ದಾಡುತ್ತಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u1_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಇರುವೆಯನ್ನು ಕಂಡ ______ ಮರದ ಕಡ್ಡಿಗಳನ್ನು ಕೀಳುತ್ತಾ ಆಳದೊಳಗೆ ಹಾಕಿತು.",
            options = listOf("ಪಾರಿವಾಳವು", "ಜಿಂಕೆಯು", "ಹುಲಿಯು", "ಯುವಕನು"),
            correctAnswer = "ಪಾರಿವಾಳವು",
            explanation = "ಪಾರಿವಾಳವು ದಯೆ ತೋರಿ ಮರದ ಕಡ್ಡಿಗಳನ್ನು ಕೀಳುತ್ತಾ ನೀರಿನೊಳಗೆ ಹಾಕಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u1_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪಾರಿವಾಳವು ಮರದ ______ ಕೀಳುತ್ತಾ ನೀರಿನಲ್ಲಿ ಹಾಕಿತು.",
            options = listOf("ಎಲೆಗಳನ್ನು", "ಹಣ್ಣುಗಳನ್ನು", "ಕಡ್ಡಿಗಳನ್ನು", "ಹೂವುಗಳನ್ನು"),
            correctAnswer = "ಕಡ್ಡಿಗಳನ್ನು",
            explanation = "ಪಾರಿವಾಳವು ಮರದ ಕಡ್ಡಿಗಳನ್ನು ಕೀಳುತ್ತಾ ನೀರಿನಲ್ಲಿ ಹಾಕಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u1_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "______ ಆ ಕಡ್ಡಿಯನ್ನು ಏರಿ ನಿಧಾನವಾಗಿ ದಡ ಸೇರಿತು.",
            options = listOf("ಪಾರಿವಾಳವು", "ಇರುವೆಯು", "ಜಿಂಕೆಯು", "ಚುಕ್ಕಿಯು"),
            correctAnswer = "ಇರುವೆಯು",
            explanation = "ಇರುವೆಯು ಆ ಕಡ್ಡಿಯನ್ನು ಏರಿ ನಿಧಾನವಾಗಿ ದಡ ಸೇರಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u1_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಇರುವೆಯು ನಿಧಾನವಾಗಿ ______ ಸೇರಿತು.",
            options = listOf("ಮರ", "ಗೂಡು", "ಕಾಡು", "ದಡ"),
            correctAnswer = "ದಡ",
            explanation = "ಇರುವೆಯು ಕಡ್ಡಿಯ ಸಹಾಯದಿಂದ ನಿಧಾನವಾಗಿ ದಡ ಸೇರಿ ಪ್ರಾಣ ಉಳಿಸಿಕೊಂಡಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u1_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಇದಕ್ಕಾಗಿ ______ ಪಾರಿವಾಳಕ್ಕೆ ಧನ್ಯವಾದ ಹೇಳಿತು.",
            options = listOf("ಹುಲಿಯು", "ಜಿಂಕೆಯು", "ಇರುವೆಯು", "ಯುವಕನು"),
            correctAnswer = "ಇರುವೆಯು",
            explanation = "ಪ್ರಾಣ ಉಳಿಸಿದ ಪಾರಿವಾಳಕ್ಕೆ ಇರುವೆಯು ಧನ್ಯವಾದ ಹೇಳಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u1_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 1,
            type = "MCQ",
            questionText = "ಇರುವೆಯು ಯಾರಿಗೆ ಧನ್ಯವಾದ ಹೇಳಿತು?",
            options = listOf("ಯುವಕನಿಗೆ", "ಪಾರಿವಾಳಕ್ಕೆ", "ಹುಲಿಗೆ", "ಜಿಂಕೆಗೆ"),
            correctAnswer = "ಪಾರಿವಾಳಕ್ಕೆ",
            explanation = "ತನ್ನನ್ನು ರಕ್ಷಿಸಿದ ಪಾರಿವಾಳಕ್ಕೆ ಇರುವೆಯು ಧನ್ಯವಾದ ಅರ್ಪಿಸಿತು."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 2: ಸೀನಶೆಟ್ಟರು ನಮ್ಮ ಟೀಚರ್ (Unit 2)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u2_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "“ಇವರು ಇವತ್ತಿನಿಂದ ನಿಮ್ಮ ಟೀಚರ್, ಇವರು ನಿಮಗೆಲ್ಲ ಏನೆಲ್ಲ ಕಲಿಸಿಕೊಡುತ್ತಾರೋ ನೋಡುತ್ತಿರಿ” ಎಂದು ಹೇಳಿದವರು ಯಾರು?",
            options = listOf("ಮಾಂಡವಿ ಟೀಚರ್", "ತುಂಗಾ", "ಸೀನಶೆಟ್ಟರು", "ಯಶೋಧೆ"),
            correctAnswer = "ಮಾಂಡವಿ ಟೀಚರ್",
            explanation = "ಮಾಂಡವಿ ಟೀಚರ್ ಅವರು ಮಕ್ಕಳ ಮುಂದೆ ಸೀನಶೆಟ್ಟರನ್ನು ಹೀಗೆ ಪರಿಚಯಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u2_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "“ಹಂಗಾರೆ ಸೀನಶೆಟ್ಟರು ಇನ್ನು ನಮ್ಮ ಟೀಚರ್” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿರುವ ಸರ್ವನಾಮ ಪದ ಯಾವುದು?",
            options = listOf("ಸೀನಶೆಟ್ಟರು", "ಇನ್ನು", "ಟೀಚರ್", "ನಮ್ಮ"),
            correctAnswer = "ನಮ್ಮ",
            explanation = "‘ನಮ್ಮ’ ಎಂಬುದು ಪುರುಷವಾಚಕ ಸರ್ವನಾಮ ಪದವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "“ಎಂಥ ಮಗ ಆರಾಮ? ಅವ್ವ ಅಪ್ಪಯ್ಯ ಚೆಂದ ಅದಾರ?” ಎಂಬುದರಲ್ಲಿ ಗೆರೆ ಎಳೆದ ಪದದ ನಾನಾರ್ಥ ಪದ ಯಾವುದು?",
            options = listOf("ಚೆನ್ನಾಗಿ, ತೆರಿಗೆ", "ಚೆನ್ನಾಗಿ, ಮರ", "ಚೆನ್ನಾಗಿ, ಚಂದ್ರ", "ಚೆನ್ನಾಗಿ, ಶಶಿ"),
            correctAnswer = "ಚೆನ್ನಾಗಿ, ತೆರಿಗೆ",
            explanation = "‘ಚೆಂದ’ ಪದಕ್ಕೆ ಚೆನ್ನಾಗಿ ಮತ್ತು ತೆರಿಗೆ ಎಂಬ ನಾನಾರ್ಥಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಮೂರು ಎಕರೆ ಜಮೀನಿನಲ್ಲಿ ಸೀನಶೆಟ್ಟರು ಬೆಳೆದಿದ್ದ ಬೆಳೆ ಯಾವುದು?",
            options = listOf("ರಾಗಿ", "ಸಾಸಿವೆ", "ಕಡಲೆ", "ಭತ್ತ"),
            correctAnswer = "ಸಾಸಿವೆ",
            explanation = "ಮೂರು ಎಕರೆ ಜಮೀನಿನಲ್ಲಿ ಸೀನಶೆಟ್ಟರು ಸಾಸಿವೆ ಬೆಳೆಯನ್ನು ಬೆಳೆದಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u2_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "“ನಾಟಿ ಮುಗಿದ ಮೇಲೆ ಇನ್ನೂ ಯಾವಾಗ ಹೊಡೆಹೊರಟಿತೋ?” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿನ “ಹೊಡೆ” ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಬೆತ್ತದ ಏಟು", "ಕಾಳು ತುಂಬುವ ಮೊದಲು ಕಾಣುವ ಪೈರಿನ ತುದಿ", "ಪೈರಿನ ಸಸಿ ನೆಡುವುದು", "ಒಣಗಿದ ಸಸಿಯ ತುದಿ"),
            correctAnswer = "ಕಾಳು ತುಂಬುವ ಮೊದಲು ಕಾಣುವ ಪೈರಿನ ತುದಿ",
            explanation = "‘ಹೊಡೆ’ ಎಂದರೆ ಕಾಳು ತುಂಬುವ ಮೊದಲು ಕಾಣುವ ಪೈರಿನ ತುದಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಶ್ರೀಮತಿ ಗಾಯತ್ರಿಯವರು ಬರೆದ ಮಕ್ಕಳ ಸೃಜನಶೀಲ ಕಲಿಕೆಯನ್ನು ಸುತ್ತ ಹೆಣೆದ ಕಾದಂಬರಿ ಯಾವುದು?",
            options = listOf("ತೊತ್ತೋಚಾನ್", "ಗೆಳೆಯರಿಗಾಗಿ ಪರಿಸರ", "ತುಂಗಾ", "ಗಂಗ"),
            correctAnswer = "ತುಂಗಾ",
            explanation = "ಶ್ರೀಮತಿ ಗಾಯತ್ರಿಯವರು ಮಕ್ಕಳ ಸೃಜನಶೀಲ ಕಲಿಕೆಯನ್ನು ಆಧರಿಸಿ ‘ತುಂಗಾ’ ಕಾದಂಬರಿ ರಚಿಸಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಒಬ್ಬ ಒಳ್ಳೆಯ ಶಿಕ್ಷಕನ ಗುಣ ಯಾವುದು?",
            options = listOf("ಸ್ವತಃ ಕಲಿಯುವುದು", "ಕಲಿಯುತ್ತಾ ಕಲಿಸುವುದು", "ಸೃಜನಾತ್ಮಕವಾಗಿ ಕಲಿಯುವುದು", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಒಳ್ಳೆಯ ಶಿಕ್ಷಕ ಸ್ವತಃ ಕಲಿಯುತ್ತಾನೆ, ಕಲಿಯುತ್ತಾ ಕಲಿಸುತ್ತಾನೆ ಮತ್ತು ಸೃಜನಾತ್ಮಕತೆಯನ್ನು ಪ್ರೋತ್ಸಾಹಿಸುತ್ತಾನೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಶಿಶುಪ್ರಾಸ ಪೂರ್ಣಗೊಳಿಸಿ: ಸೂರ್ಯನು ಮೇಲೆ ______.",
            options = listOf("ಬಂದನು", "ಹೋದನು", "ಕುಳಿತನು", "ಮಲಗಿದನು"),
            correctAnswer = "ಬಂದನು",
            explanation = "‘ಸೂರ್ಯನು ಮೇಲೆ ಬಂದನು’ ಎಂಬುದು ಸರಿಯಾದ ಪ್ರಾಸಬದ್ಧ ವಾಕ್ಯ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಶಿಶುಪ್ರಾಸ ಪೂರ್ಣಗೊಳಿಸಿ: ಬೆಳಕನು ನಮಗೆ ______.",
            options = listOf("ತಂದನು", "ಚೆಲ್ಲಿದನು", "ಮರೆಮಾಡಿದನು", "ತೆಗೆದನು"),
            correctAnswer = "ಚೆಲ್ಲಿದನು",
            explanation = "‘ಬೆಳಕನು ನಮಗೆ ಚೆಲ್ಲಿದನು’ ಎಂಬುದು ಪ್ರಾಸ ವಾಕ್ಯ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಶಿಶುಪ್ರಾಸ ಪೂರ್ಣಗೊಳಿಸಿ: ಬೆಳಿಗ್ಗೆ ಬೇಗ ______.",
            options = listOf("ಮಲಗೋಣ", "ಆಟವಾಡೋಣ", "ಏಳೋಣ", "ಕುಳಿತುಕೊಳ್ಳೋಣ"),
            correctAnswer = "ಏಳೋಣ",
            explanation = "‘ಬೆಳಿಗ್ಗೆ ಬೇಗ ಏಳೋಣ’ ಎಂಬುದು ಸರಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "ಖುಷಿಯಿಂದ ನಾವು ______.",
            options = listOf("ಓದೋಣ", "ಮಲಗೋಣ", "ಆಡೋಣ", "ನಿಲ್ಲೋಣ"),
            correctAnswer = "ಓದೋಣ",
            explanation = "‘ಖುಷಿಯಿಂದ ನಾವು ಓದೋಣ’ ಎಂಬುದು ಪದ್ಯದ ಪ್ರಾಸಪೂರ್ಣ ಸಾಲು."
        ),
        QuestionModel(
            id = "s_7_kan_u2_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "“ಲಪಟೆ” ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ತಲೆಗೆ ಸುತ್ತುವ ರುಮಾಲು ಅಥವಾ ಬಟ್ಟೆ", "ಪಾದರಕ್ಷೆ", "ಕೈಗವಸು", "ಚೀಲ"),
            correctAnswer = "ತಲೆಗೆ ಸುತ್ತುವ ರುಮಾಲು ಅಥವಾ ಬಟ್ಟೆ",
            explanation = "‘ಲಪಟೆ’ ಎಂದರೆ ತಲೆಗೆ ಸುತ್ತುವ ರುಮಾಲು ಅಥವಾ ಬಟ್ಟೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_13",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "“ವಾಸ್ತವ” ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಸತ್ಯ", "ಭ್ರಮೆ", "ನಿಜ", "ವಾಸ್ತವಿಕ"),
            correctAnswer = "ಭ್ರಮೆ",
            explanation = "ವಾಸ್ತವ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಭ್ರಮೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u2_14",
            stdId = 7,
            subjectId = "kannada",
            unitId = 2,
            type = "MCQ",
            questionText = "“ಸೀನಶೆಟ್ಟರು ತುಂಬಾ ಕೋಪಿಷ್ಠರಾಗಿದ್ದರು” — ಈ ಹೇಳಿಕೆ ಸರಿ ಅಥವಾ ತಪ್ಪು?",
            options = listOf("ಸರಿ", "ತಪ್ಪು", "ಎರಡೂ ಸರಿ", "ನಿರ್ಧರಿಸಲಾಗದು"),
            correctAnswer = "ತಪ್ಪು",
            explanation = "ಸೀನಶೆಟ್ಟರು ಪ್ರೀತಿಯಿಂದ ಕಲಿಸುವ ಶಾಂತ ಸ್ವಭಾವದವರಾಗಿದ್ದರು, ಆದ್ದರಿಂದ ಈ ಹೇಳಿಕೆ ತಪ್ಪು."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 3: ಹಿಲ್ಟನ್ ಹೆಡ್ ಚಳವಳಿ (Unit 3)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u3_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಬ್ಬ ________ಗೆ ಪರಿಸರದ ಸುಖದುಃಖಗಳಿಗೆ ಮನಸ್ಸು ಕೊಡುವ ಇಂಬಾಯಿತು.",
            options = listOf("ನೆಲದಾಳಿಗೆ", "ವಕೀಲನಿಗೆ", "ವೈದ್ಯನಿಗೆ", "ಇಂಜಿನಿಯರ್ಗೆ"),
            correctAnswer = "ನೆಲದಾಳಿಗೆ",
            explanation = "ಒಬ್ಬ ನೆಲದಾಳಿಗೆ ಪರಿಸರದ ಸುಖದುಃಖಗಳಿಗೆ ಮನಸ್ಸು ಕೊಡುವ ಇಂಬಾಯಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u3_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "________ ಮರಗಳನ್ನು ಕಡಿಯಲೇ ಕೂಡದು ಎನ್ನುವ ಚಳವಳಿ ಆರಂಭವಾಯಿತು.",
            options = listOf("ಆಲದ", "ಮಾವಿನ", "ಓಕ್", "ಬೇವಿನ"),
            correctAnswer = "ಓಕ್",
            explanation = "ಓಕ್ ಮರಗಳನ್ನು ಕಡಿಯಲೇ ಕೂಡದು ಎಂದು ಹಿಲ್ಟನ್ ಹೆಡ್ ಚಳವಳಿ ಆರಂಭವಾಯಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u3_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ಓಕ್ ಮರದ ಸಾನ್ನಿಧ್ಯದಲ್ಲಿಯೇ ಎಷ್ಟೋ ________ಗಳಾಗಿವೆ!",
            options = listOf("ಆಲೆ", "ವಿವಾಹ", "ಜಗಳ", "ಸಭೆ"),
            correctAnswer = "ವಿವಾಹ",
            explanation = "ಓಕ್ ಮರದ ಸಾನ್ನಿಧ್ಯದಲ್ಲಿಯೇ ಎಷ್ಟೋ ವಿವಾಹಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u3_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "________ ದಶಕದಲ್ಲಿ ಪರಿಸರ ಸಂರಕ್ಷಣೆಗಾಗಿ ಜನ ಒಗ್ಗೂಡಿ ಪಣತೊಟ್ಟಿದ್ದರು.",
            options = listOf("ಐವತ್ತರ", "ಅರವತ್ತರ", "ಎಪ್ಪತ್ತರ", "ತೊಂಬತ್ತರ"),
            correctAnswer = "ಐವತ್ತರ",
            explanation = "ಐವತ್ತರ ದಶಕದಲ್ಲಿ ಪರಿಸರ ಸಂರಕ್ಷಣೆಗಾಗಿ ಜನ ಒಗ್ಗೂಡಿ ಪಣತೊಟ್ಟಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u3_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ಯೂರೋಪಿಯನ್ನರ ಆಗಮನವಾದ ಮೇಲೆ ಅಮೆರಿಂಡಿಯನ್ನರ ಸಮುದಾಯವು ________ ಆಯಿತು.",
            options = listOf("ಅಭಿವೃದ್ಧಿ", "ಶಿಕ್ಷಿತ", "ಧೂಳೀಪಟ", "ಸಮೃದ್ಧ"),
            correctAnswer = "ಧೂಳೀಪಟ",
            explanation = "ಯೂರೋಪಿಯನ್ನರ ಆಗಮನದ ನಂತರ ಸ್ಥಳೀಯ ಅಮೆರಿಂಡಿಯನ್ನರ ಸಮುದಾಯವು ಧೂಳೀಪಟವಾಯಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u3_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ಅಟ್ಲಾಂಟಿಕ್ ಸಾಗರವು ಅಮೆರಿಕದ ________ ಭಾಗದಲ್ಲಿದೆ.",
            options = listOf("ಪೂರ್ವ", "ಉತ್ತರ", "ಪಶ್ಚಿಮ", "ದಕ್ಷಿಣ"),
            correctAnswer = "ಪೂರ್ವ",
            explanation = "ಅಟ್ಲಾಂಟಿಕ್ ಸಾಗರವು ಅಮೆರಿಕದ ಪೂರ್ವ ಭಾಗದಲ್ಲಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u3_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ವಿಧಿ ಇಲ್ಲದೆ ಕೊನೆಗೆ ________ ಮೊರೆಹೋಗಬೇಕಾಯಿತು.",
            options = listOf("ಧನಿಕರ", "ಅಮೆರಿಕ ಅಧ್ಯಕ್ಷರ", "ನ್ಯಾಯಾಲಯದ", "ಪೊಲೀಸರ"),
            correctAnswer = "ನ್ಯಾಯಾಲಯದ",
            explanation = "ಪರಿಸರ ಹೋರಾಟಗಾರರು ಕೊನೆಗೆ ನ್ಯಾಯಾಲಯದ ಮೊರೆಹೋಗಬೇಕಾಯಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u3_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕಟ್ಟಡಗಳಿಗೆ ತೋರಿಸುತ್ತಿದ್ದ ________ ಶ್ರದ್ಧೆಯನ್ನೇ ಜನ ಪರಿಸರಕ್ಕೂ ನೀಡತೊಡಗಿದರು.",
            options = listOf("ಪಾರಂಪರಿಕ", "ಅಭಿಯಂತರ", "ರಾಜಕೀಯ", "ಧಾರ್ಮಿಕ"),
            correctAnswer = "ಅಭಿಯಂತರ",
            explanation = "ಕಟ್ಟಡಗಳಿಗೆ ತೋರಿಸುತ್ತಿದ್ದ ಅಭಿಯಂತರ ಶ್ರದ್ಧೆಯನ್ನೇ ಜನ ಪರಿಸರಕ್ಕೂ ನೀಡತೊಡಗಿದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u3_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ದ್ವೀಪದ ಸೌಂದರ್ಯವನ್ನು ಹೆಚ್ಚಿಸಿಕೊಳ್ಳಲು ಮೊದಲು ಎಲ್ಲರೂ ಸೇರಿ ________ ನಡೆಸಿದರು.",
            options = listOf("ಮಂತ್ರಾಲೋಚನೆ", "ಜಾಥಾ", "ಪ್ರತಿಭಟನೆ", "ಸಭೆ"),
            correctAnswer = "ಮಂತ್ರಾಲೋಚನೆ",
            explanation = "ದ್ವೀಪದ ಸೌಂದರ್ಯವನ್ನು ಕಾಪಾಡಲು ಮೊದಲು ಎಲ್ಲರೂ ಸೇರಿ ಮಂತ್ರಾಲೋಚನೆ ನಡೆಸಿದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u3_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 3,
            type = "MCQ",
            questionText = "ಹೋರಾಟ ಮುಂದುವರಿದ ಬಳಿಕ ಹಿಲ್ಟನ್ ಹೆಡ್ ________ ಕಂಗೊಳಿಸತೊಡಗಿತು.",
            options = listOf("ನಂದನವನದಂತೆ", "ಅಭಯಾರಣ್ಯದಂತೆ", "ರಾಜಧಾನಿಯಂತೆ", "ಕೈಗಾರಿಕಾ ಪ್ರದೇಶದಂತೆ"),
            correctAnswer = "ನಂದನವನದಂತೆ",
            explanation = "ಹೋರಾಟದ ಯಶಸ್ಸಿನ ಬಳಿಕ ಹಿಲ್ಟನ್ ಹೆಡ್ ದ್ವೀಪ ನಂದನವನದಂತೆ ಕಂಗೊಳಿಸತೊಡಗಿತು."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 4: ಮೈಲಾರ ಮಹದೇವ (Unit 4)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u4_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಪ್ರಾಥಮಿಕದ ನಂತರ ವಿದ್ಯಾಭ್ಯಾಸಕ್ಕಾಗಿ ಮಹದೇವ ______ ಶಾಲೆಗೆ ಹೋದರು.",
            options = listOf("ಹಂಸಭಾವಿ", "ಕಲಾದಗಿ", "ಹೊಸರಿತ್ತಿ", "ವಿಜಯಪುರ"),
            correctAnswer = "ಹಂಸಭಾವಿ",
            explanation = "ಪ್ರಾಥಮಿಕದ ನಂತರ ವಿದ್ಯಾಭ್ಯಾಸಕ್ಕಾಗಿ ಮಹದೇವ ಹಂಸಭಾವಿ ಶಾಲೆಗೆ ಹೋದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u4_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಮಹದೇವ ______ ಚಳವಳಿಯಲ್ಲಿ ಭಾಗವಹಿಸಿ ಜೈಲು ಸೇರಿದರು.",
            options = listOf("ಅಸಹಕಾರ", "ದಂಡಿ", "ಪರಿಸರ ಸಂರಕ್ಷಣೆ", "ರೈತ"),
            correctAnswer = "ದಂಡಿ",
            explanation = "ಮಹದೇವ ದಂಡಿ ಚಳವಳಿಯಲ್ಲಿ (ಉಪ್ಪಿನ ಸತ್ಯಾಗ್ರಹ) ಭಾಗವಹಿಸಿ ಜೈಲು ಸೇರಿದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u4_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಹಾವೇರಿ ಜಿಲ್ಲೆಯ ಹೊಸರಿತ್ತಿಯಲ್ಲಿದ್ದ ಸಹಕಾರ ಕೇಂದ್ರ ______ ವಸೂಲಿ ಮಾಡುತ್ತಿತ್ತು.",
            options = listOf("ತೆರಿಗೆ", "ಕಂದಾಯ", "ದಂಡ", "ಬಾಡಿಗೆ"),
            correctAnswer = "ಕಂದಾಯ",
            explanation = "ಹಾವೇರಿ ಜಿಲ್ಲೆಯ ಹೊಸರಿತ್ತಿಯಲ್ಲಿದ್ದ ಸಹಕಾರ ಕೇಂದ್ರ ಕಂದಾಯ ವಸೂಲಿ ಮಾಡುತ್ತಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u4_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ವನ್ಯಜೀವಿಗಳ ಸಂರಕ್ಷಿತ ಪ್ರದೇಶವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸೆರೆಮನೆ", "ಅಭಯಾರಣ್ಯ", "ಗ್ರಂಥಾಲಯ", "ಕಾರ್ಯಾಗಾರ"),
            correctAnswer = "ಅಭಯಾರಣ್ಯ",
            explanation = "ವನ್ಯಜೀವಿಗಳ ಸಂರಕ್ಷಿತ ಪ್ರದೇಶವನ್ನು ಅಭಯಾರಣ್ಯ ಎಂದು ಕರೆಯುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u4_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೈದಿಗಳನ್ನು ಸೆರೆಹಿಡಿದು ಇಡುವ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಅರಮನೆ", "ಆಶ್ರಮ", "ಸೆರೆಮನೆ", "ಶಾಲೆ"),
            correctAnswer = "ಸೆರೆಮನೆ",
            explanation = "ಕೈದಿಗಳನ್ನು ಸೆರೆಹಿಡಿದು ಇಡುವ ಸ್ಥಳ ಸೆರೆಮನೆ (ಜೈಲು)."
        ),
        QuestionModel(
            id = "s_7_kan_u4_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಬಟ್ಟೆ ನೇಯಲು ಉಪಯೋಗಿಸುವ ಯಂತ್ರ ಯಾವುದು?",
            options = listOf("ಚರಕ", "ನೇಗಿಲು", "ಗಿರಣಿ", "ಮಗ್ಗದ ಸೂಜಿ"),
            correctAnswer = "ಚರಕ",
            explanation = "ಬಟ್ಟೆ ನೇಯಲು ನೂಲು ತೆಗೆಯಲು ಮತ್ತು ನೇಯಲು ಚರಕವನ್ನು ಬಳಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u4_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 4,
            type = "MCQ",
            questionText = "ಯಾರ ಹುಟ್ಟುಹಬ್ಬವನ್ನು ಮಕ್ಕಳ ದಿನಾಚರಣೆಯಾಗಿ ಆಚರಿಸುತ್ತಾರೆ?",
            options = listOf("ಮಹಾತ್ಮ ಗಾಂಧೀಜಿ", "ಜವಾಹರಲಾಲ್ ನೆಹರು", "ಸುಭಾಷ್ ಚಂದ್ರ ಬೋಸ್", "ಸರ್ದಾರ್ ವಲ್ಲಭಭಾಯಿ ಪಟೇಲ್"),
            correctAnswer = "ಜವಾಹರಲಾಲ್ ನೆಹರು",
            explanation = "ಪಂಡಿತ್ ಜವಾಹರಲಾಲ್ ನೆಹರು ಅವರ ಹುಟ್ಟುಹಬ್ಬವನ್ನು (ನವೆಂಬರ್ 14) ಮಕ್ಕಳ ದಿನಾಚರಣೆಯಾಗಿ ಆಚರಿಸಲಾಗುತ್ತದೆ."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 5: ಪರಿಸರ ಸಮತೋಲನ (Unit 5)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u5_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "“ಉಪ್ಪಿಗಿಂತ ರುಚಿಯಿಲ್ಲ, ತಾಯಿಗಿಂತ ______.” ಗಾದೆ ಪೂರ್ಣಗೊಳಿಸಿ:",
            options = listOf("ಸ್ನೇಹಿತೆಯಿಲ್ಲ", "ಬಂಧುವಿಲ್ಲ", "ಗುರುಗಳಿಲ್ಲ", "ಶತ್ರುವಿಲ್ಲ"),
            correctAnswer = "ಬಂಧುವಿಲ್ಲ",
            explanation = "ಉಪ್ಪಿಗಿಂತ ರುಚಿಯಿಲ್ಲ, ತಾಯಿಗಿಂತ ಬಂಧುವಿಲ್ಲ ಎಂಬುದು ಪ್ರಸಿದ್ಧ ಗಾದೆ ಮಾತು."
        ),
        QuestionModel(
            id = "s_7_kan_u5_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "“ದೂರದ ಬೆಟ್ಟ ______.” ಗಾದೆ ಪೂರ್ಣಗೊಳಿಸಿ:",
            options = listOf("ಎತ್ತರ", "ಸುಂದರ", "ನುಣ್ಣಗೆ", "ಹಸಿರು"),
            correctAnswer = "ನುಣ್ಣಗೆ",
            explanation = "ದೂರದ ಬೆಟ್ಟ ಕಣ್ಣಿಗೆ ನುಣ್ಣಗೆ ಎಂಬುದು ಗಾದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u5_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "“ಹಿತ್ತಲ ಗಿಡ ______.” ಗಾದೆ ಪೂರ್ಣಗೊಳಿಸಿ:",
            options = listOf("ಔಷಧಿ", "ಮದ್ದಲ್ಲ", "ಸುಂದರ", "ಚಿಕ್ಕದು"),
            correctAnswer = "ಮದ್ದಲ್ಲ",
            explanation = "ಹಿತ್ತಲ ಗಿಡ ಮದ್ದಲ್ಲ ಎಂಬುದು ನಾಣ್ಣುಡಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u5_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "“ಉಪ್ಪಿಗಿಂತ ರುಚಿಯಿಲ್ಲ, ತಾಯಿಗಿಂತ ಬಂಧುವಿಲ್ಲ” ಎಂಬ ಗಾದೆಯಲ್ಲಿ ‘ಬಂಧು’ ಎಂದರೆ ಯಾರು?",
            options = listOf("ನೆಂಟ", "ಶತ್ರು", "ವ್ಯಾಪಾರಿ", "ಪರದೇಶಿ"),
            correctAnswer = "ನೆಂಟ",
            explanation = "ಬಂಧು ಎಂದರೆ ನೆಂಟ / ಸಂಬಂಧಿಕ."
        ),
        QuestionModel(
            id = "s_7_kan_u5_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "“ಕೂತು ಉಣ್ಣುವವನಿಗೆ ______.” ಗಾದೆ ಪೂರ್ಣಗೊಳಿಸಿ:",
            options = listOf("ಮನೆ ಸಾಲದು", "ಊರು ಸಾಲದು", "ಕುಡಿಕೆ ಹೊನ್ನು ಸಾಲದು", "ಹೊಲ ಸಾಲದು"),
            correctAnswer = "ಕುಡಿಕೆ ಹೊನ್ನು ಸಾಲದು",
            explanation = "ಶ್ರಮಪಡದೆ ಕೂತು ತಿಂದರೆ ಕುಡಿಕೆ ಹೊನ್ನು ಸಾಲದು."
        ),
        QuestionModel(
            id = "s_7_kan_u5_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "“ಹಸು ಕಪ್ಪಾದರೆ ______?” ಗಾದೆ ಪೂರ್ಣಗೊಳಿಸಿ:",
            options = listOf("ಹಾಲು ಕಪ್ಪೆ?", "ಹಾಲು ಸಿಹಿ", "ಹಾಲು ಕಡಿಮೆ", "ಹಸು ಬಿಳಿ"),
            correctAnswer = "ಹಾಲು ಕಪ್ಪೆ?",
            explanation = "ಹಸು ಕಪ್ಪಾದರೆ ಹಾಲು ಕಪ್ಪೆ? ಎಂಬುದು ಗಾದೆಯ ಒಗಟು."
        ),
        QuestionModel(
            id = "s_7_kan_u5_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ದಟ್ಟವಾದ ಕಾಡು ಎಲ್ಲಿ ಬೆಳೆಯುತ್ತದೆ?",
            options = listOf("ಬರಡು ಭೂಮಿಯಲ್ಲಿ", "ನೀರು ಮತ್ತು ತೇವಾಂಶ ಇರುವಲ್ಲಿ", "ಮರುಭೂಮಿಯಲ್ಲಿ", "ಕಟ್ಟಡಗಳ ಮೇಲೆ"),
            correctAnswer = "ನೀರು ಮತ್ತು ತೇವಾಂಶ ಇರುವಲ್ಲಿ",
            explanation = "ಧಾರಾಳವಾಗಿ ನೀರು ಮತ್ತು ತೇವಾಂಶ ಇರುವಲ್ಲಿ ದಟ್ಟ ಕಾಡು ಬೆಳೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u5_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಬೀಜ ಪ್ರಸರಣವು ಯಾವುದರ ಮೂಲಕ ನಡೆಯುತ್ತದೆ?",
            options = listOf("ಕೀಟ, ವಾಯು ಮತ್ತು ನೀರಿನ ಮೂಲಕ", "ಕೇವಲ ಮಣ್ಣಿನ ಮೂಲಕ", "ಕೇವಲ ಸೂರ್ಯನ ಬೆಳಕಿನಿಂದ", "ಕೇವಲ ಪ್ರಾಣಿಗಳ ಮೂಲಕ"),
            correctAnswer = "ಕೀಟ, ವಾಯು ಮತ್ತು ನೀರಿನ ಮೂಲಕ",
            explanation = "ಬೀಜ ಪ್ರಸರಣ ಕೀಟಗಳು, ಗಾಳಿ (ವಾಯು) ಮತ್ತು ನೀರಿನ ಮೂಲಕ ಸಹಜವಾಗಿ ನಡೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u5_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪ್ರಾಣಿಗಳ ನಡುವೆ ಸ್ಪರ್ಧೆ ಏಕೆ ನಡೆಯುತ್ತದೆ?",
            options = listOf("ಆಟವಾಡಲು", "ಆಹಾರ ಸಂಪಾದನೆಗಾಗಿ", "ನಿದ್ರೆಗಾಗಿ", "ವಲಸೆ ಹೋಗಲು ಮಾತ್ರ"),
            correctAnswer = "ಆಹಾರ ಸಂಪಾದನೆಗಾಗಿ",
            explanation = "ಪರಿಸರದಲ್ಲಿ ಪ್ರಾಣಿಗಳ ನಡುವೆ ಆಹಾರ ಸಂಪಾದನೆಗಾಗಿ ನೈಸರ್ಗಿಕ ಸ್ಪರ್ಧೆ ಇರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u5_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಸಸ್ಯಪ್ರಾಣಿ ಸಂಕುಲ ನಾಶವಾಗಲು ಕಾರಣ ಯಾವುದು?",
            options = listOf("ಜನಸಂಖ್ಯೆ ಹೆಚ್ಚಳ ಮತ್ತು ಕೈಗಾರಿಕೀಕರಣ", "ಮರಗಳನ್ನು ನೆಡುವುದು", "ನೀರಿನ ಸಂರಕ್ಷಣೆ", "ಅರಣ್ಯ ಸಂರಕ್ಷಣೆ"),
            correctAnswer = "ಜನಸಂಖ್ಯೆ ಹೆಚ್ಚಳ ಮತ್ತು ಕೈಗಾರಿಕೀಕರಣ",
            explanation = "ಅತಿಯಾದ ಜನಸಂಖ್ಯೆ ಹೆಚ್ಚಳ ಮತ್ತು ಕೈಗಾರಿಕೀಕರಣದಿಂದ ವನ್ಯಜೀವಿಗಳ ಆವಾಸಸ್ಥಾನ ನಾಶವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u5_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಆನೆ ಎಷ್ಟು ವರ್ಷಕ್ಕೊಮ್ಮೆ ಮರಿಯನ್ನು ಹಾಕುತ್ತದೆ?",
            options = listOf("ಎರಡು ವರ್ಷಕ್ಕೊಮ್ಮೆ", "ಮೂರು ವರ್ಷಕ್ಕೊಮ್ಮೆ", "ಐದು ವರ್ಷಕ್ಕೊಮ್ಮೆ", "ಹತ್ತು ವರ್ಷಕ್ಕೊಮ್ಮೆ"),
            correctAnswer = "ಐದು ವರ್ಷಕ್ಕೊಮ್ಮೆ",
            explanation = "ಆನೆ ಸಾಮಾನ್ಯವಾಗಿ ಸುಮಾರು ಐದು ವರ್ಷಕ್ಕೊಮ್ಮೆ ಮರಿಯನ್ನು ಹಾಕುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u5_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪ್ರಾಣಿಗಳಲ್ಲಿ ಅತಿ ದೊಡ್ಡ ಪ್ರಾಣಿ ಯಾವುದು?",
            options = listOf("ಆನೆ", "ಜಿರಾಫೆ", "ನೀಲಿ ತಿಮಿಂಗಿಲ", "ಸಿಂಹ"),
            correctAnswer = "ನೀಲಿ ತಿಮಿಂಗಿಲ",
            explanation = "ಭೂಮಿ ಮೇಲಿನ ಅತಿ ದೊಡ್ಡ ಜೀವಿ ನೀಲಿ ತಿಮಿಂಗಿಲ."
        ),
        QuestionModel(
            id = "s_7_kan_u5_13",
            stdId = 7,
            subjectId = "kannada",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪರಿಸರ ಸಮತೋಲನ ಕಾಪಾಡಲು ಯಾವ ಕ್ರಮ ಸಹಾಯಕ?",
            options = listOf("ಅರಣ್ಯ ನಾಶ", "ಜಲಮೂಲಗಳ ಮಾಲಿನ್ಯ", "ಮರಗಳ ರಕ್ಷಣೆ ಮತ್ತು ಮಾಲಿನ್ಯ ನಿಯಂತ್ರಣ", "ಅತಿಯಾದ ಗಣಿಗಾರಿಕೆ"),
            correctAnswer = "ಮರಗಳ ರಕ್ಷಣೆ ಮತ್ತು ಮಾಲಿನ್ಯ ನಿಯಂತ್ರಣ",
            explanation = "ಮರಗಳನ್ನು ರಕ್ಷಿಸುವುದು ಮತ್ತು ಮಾಲಿನ್ಯ ನಿಯಂತ್ರಿಸುವುದು ಪರಿಸರ ಸಮತೋಲನಕ್ಕೆ ಅನಿವಾರ್ಯ."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 6: ಚಗಳಿ ಇರುವೆ (Unit 6)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u6_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ಚಗಳಿ ಇರುವೆಗಳು ಉತ್ಪಾದಿಸುವ ರಾಸಾಯನಿಕ ವಸ್ತುವಿಗೆ ಏನೆಂದು ಹೆಸರು?",
            options = listOf("ಲಾವಾ", "ಫಿರಮೋನ್", "ಆಮ್ಲಜನಕ", "ಇಂಗಾಲದ ಡೈಆಕ್ಸೈಡ್"),
            correctAnswer = "ಫಿರಮೋನ್",
            explanation = "ಇರುವೆಗಳು ಸಂವಹನಕ್ಕಾಗಿ ‘ಫಿರಮೋನ್’ ರಾಸಾಯನಿಕ ವಸ್ತುವನ್ನು ಉತ್ಪಾದಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u6_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಆಟೆ’ ಎಂದರೆ ಏನು?",
            options = listOf("ಗೂಡು", "ಆಹಾರ", "ರಾಣಿ ಇರುವೆ", "ಕೆಲಸಗಾರ ಇರುವೆ"),
            correctAnswer = "ಗೂಡು",
            explanation = "‘ಆಟೆ’ ಎಂದರೆ ಚಗಳಿ ಇರುವೆಯ ಗೂಡು."
        ),
        QuestionModel(
            id = "s_7_kan_u6_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ಜೇನುನೊಣಗಳಲ್ಲಿ ರಾಣಿ ಜೇನುನೊಣ ಇರುವಂತೆ ಇರುವೆಗಳಲ್ಲಿಯೂ ______ ಇರುತ್ತದೆ.",
            options = listOf("ಕೆಲಸಗಾರ ಇರುವೆ", "ಸೈನಿಕ ಇರುವೆ", "ರಾಣಿ ಇರುವೆ", "ಗಂಡು ಇರುವೆ"),
            correctAnswer = "ರಾಣಿ ಇರುವೆ",
            explanation = "ಇರುವೆಗಳ ಗೂಡಿನಲ್ಲಿಯೂ ಸಂತಾನೋತ್ಪತ್ತಿ ಮಾಡುವ ರಾಣಿ ಇರುವೆ ಇರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u6_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "‘ಅರಸನ ಮನೆ’ ಎಂಬ ಪದದಲ್ಲಿ ‘ಅರಸನ’ ಪೂರ್ವಪದವಾದರೆ, ‘ಮನೆ’ ______ ಪದವಾಗಿದೆ.",
            options = listOf("ಪೂರ್ವ", "ಉತ್ತರ", "ಸಮಾಸ", "ಸಂಧಿ"),
            correctAnswer = "ಉತ್ತರ",
            explanation = "ಸಮಾಸ ಪದದಲ್ಲಿ ಮೊದಲನೆಯದು ಪೂರ್ವಪದ, ಎರಡನೆಯದು ಉತ್ತರಪದ."
        ),
        QuestionModel(
            id = "s_7_kan_u6_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "“ಸ್ವಾಮಿ, ಬನ್ನಿ, ದಯಮಾಡಿ ಕುಳಿತುಕೊಳ್ಳಿ” ಎಂಬ ಮಾತಿನಲ್ಲಿ ವ್ಯಕ್ತವಾಗುವ ಪ್ರಮುಖ ಭಾವನೆ ಯಾವುದು?",
            options = listOf("ಕೋಪ", "ದುಃಖ", "ಗೌರವ", "ಭಯ"),
            correctAnswer = "ಗೌರವ",
            explanation = "ದಯಮಾಡಿ ಬನ್ನಿ ಕುಳಿತುಕೊಳ್ಳಿ ಎಂಬುದು ಗೌರವ ಮತ್ತು ಸತ್ಕಾರದ ಭಾವನೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u6_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ಚಗಳಿ ಇರುವೆಗಳಿಗೆ ಮೂಲ ______.",
            options = listOf("ರಾಣಿ", "ಗೂಡು", "ಮರ", "ಆಹಾರ"),
            correctAnswer = "ಗೂಡು",
            explanation = "ಚಗಳಿ ಇರುವೆಗಳ ಸಂಘಜೀವನಕ್ಕೆ ಮೂಲ ಗೂಡು (ಆಟೆ)."
        ),
        QuestionModel(
            id = "s_7_kan_u6_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ದನ ಸಾಕುವ ಗೋಪಾಲಕರನ್ನು ಹೋಲುವ ಇರುವೆಗಳು ಯಾವುವು?",
            options = listOf("ರಾಣಿ ಇರುವೆಗಳು", "ಕೆಲಸಗಾರ ಇರುವೆಗಳು", "ಕೆಂಪಿರುವೆಗಳು", "ಗಂಡು ಇರುವೆಗಳು"),
            correctAnswer = "ಕೆಲಸಗಾರ ಇರುವೆಗಳು",
            explanation = "ಹೇನುಗಳನ್ನು ಮೇಯಿಸಿ ರಕ್ಷಿಸುವ ಕೆಲಸಗಾರ ಇರುವೆಗಳು ಗೋಪಾಲಕರಂತಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u6_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದು ಚಗಳಿ ಇರುವೆಯ ಗೂಡಿನಲ್ಲಿ ಸುಮಾರು ಎಷ್ಟು ಇರುವೆಗಳು ಇರುತ್ತವೆ?",
            options = listOf("500–1,000", "10,000–20,000", "1–2 ಲಕ್ಷ", "5–10 ಲಕ್ಷ"),
            correctAnswer = "5–10 ಲಕ್ಷ",
            explanation = "ಒಂದು ದೊಡ್ಡ ಚಗಳಿ ಇರುವೆಯ ಗೂಡಿನಲ್ಲಿ ಸುಮಾರು 5 ರಿಂದ 10 ಲಕ್ಷ ಇರುವೆಗಳಿರುತ್ತವೆ."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 7: ಬಿಲ್ಲ ಹಬ್ಬ (Unit 7)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u7_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "‘ರಾಜ’ ಪದದ ತದ್ಭವ ರೂಪ ಯಾವುದು?",
            options = listOf("ರಾಯ", "ಅರಸ", "ರಾಜನು", "ರಾಜಮನೆ"),
            correctAnswer = "ರಾಯ",
            explanation = "‘ರಾಜ’ ತತ್ಸಮ, ‘ರಾಯ’ ತದ್ಭವ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "‘ಬಂಧನ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಸೆರೆಮನೆ", "ಸ್ವತಂತ್ರ", "ಶಿಕ್ಷೆ", "ಸಂಕೋಲೆ"),
            correctAnswer = "ಸ್ವತಂತ್ರ",
            explanation = "ಬಂಧನ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಸ್ವತಂತ್ರ / ಮುಕ್ತಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "“ಅರಸನ ಅಂಕೆಯಿಲ್ಲ, ದೆವ್ವದ ಕಾಟವಿಲ್ಲ” ಎಂಬ ಮಾತನ್ನು ಯಾರು ಯಾರಿಗೆ ಹೇಳಿದರು?",
            options = listOf("ಕೃಷ್ಣನು ಬಲರಾಮನಿಗೆ", "ಕಂಸನು ವಸುದೇವ ಮತ್ತು ದೇವಕಿಗೆ", "ನಂದನು ಯಶೋದೆಗೆ", "ವಸುದೇವನು ಕಂಸನಿಗೆ"),
            correctAnswer = "ಕಂಸನು ವಸುದೇವ ಮತ್ತು ದೇವಕಿಗೆ",
            explanation = "ಕಂಸನು ಸೆರೆಮನೆಯಲ್ಲಿ ವಸುದೇವ ಮತ್ತು ದೇವಕಿಗೆ ಈ ಮಾತನ್ನು ಹೇಳಿದನು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "‘ತಾಯಿ’ ಪದದ ಪುಲ್ಲಿಂಗ ರೂಪ ಯಾವುದು?",
            options = listOf("ಮಗಳು", "ಅಕ್ಕ", "ತಂದೆ", "ಅಜ್ಜಿ"),
            correctAnswer = "ತಂದೆ",
            explanation = "ತಾಯಿ ಪದದ ಪುಲ್ಲಿಂಗ ತಂದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "‘ರಾಕ್ಷಸ’ ಪದದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ರಾಕ್ಷಸಿ", "ರಾಕ್ಷಸರು", "ರಾಕ್ಷಸನ", "ರಾಕ್ಷಸತನ"),
            correctAnswer = "ರಾಕ್ಷಸರು",
            explanation = "ರಾಕ್ಷಸ ಏಕವಚನ, ರಾಕ್ಷಸರು ಬಹುವಚನ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "“ಸರ್ವರಿಗೂ ಆತ್ಮೀಯ ಸ್ವಾಗತ” ಎಂಬ ವಾಕ್ಯದ ಶುದ್ಧ ರೂಪ ಯಾವುದು?",
            options = listOf("ಸರ್ವರಿಗೂ ಆತ್ಮೀಯ ಸ್ವಾಗತ.", "ಸರ್ವರಿಗೂ ಆತ್ಮೀಯ ಸ್ವಾಗತವೇ?", "ಸರ್ವರಿಗೂ ಆತ್ಮೀಯ ಸ್ವಾಗತ!", "ಸರ್ವರಿಗೂ ಆತ್ಮೀಯ ಸ್ವಾಗತ,"),
            correctAnswer = "ಸರ್ವರಿಗೂ ಆತ್ಮೀಯ ಸ್ವಾಗತ.",
            explanation = "ಸಾಮಾನ್ಯ ಹೇಳಿಕೆಗೆ ವಾಕ್ಯದ ಕೊನೆಯಲ್ಲಿ ಪೂರ್ಣವಿರಾಮ ಇರಬೇಕು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "“ನೀನು ಇಲ್ಲಿ ಏನು ಮಾಡುತ್ತಿದ್ದೀಯ?” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿರುವ ಲೇಖನ ಚಿಹ್ನೆ ಯಾವುದು?",
            options = listOf("ಅಲ್ಪವಿರಾಮ", "ಪೂರ್ಣವಿರಾಮ", "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ", "ಆಶ್ಚರ್ಯಸೂಚಕ ಚಿಹ್ನೆ"),
            correctAnswer = "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ",
            explanation = "ಪ್ರಶ್ನಾರ್ಥಕ ವಾಕ್ಯದಲ್ಲಿ ‘?’ ಚಿಹ್ನೆ ಇರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "“ಭಾ.ತ, ರ.ಹಾ.ಮ” ಅಕ್ಷರಗಳನ್ನು ಸರಿಪಡಿಸಿ ರಚಿಸುವ ಪದ ಯಾವುದು?",
            options = listOf("ಮಹಾಭಾರತ", "ಭಾಗವತ", "ರಾಮಾಯಣ", "ಹರಿಕಥೆ"),
            correctAnswer = "ಮಹಾಭಾರತ",
            explanation = "ಅಕ್ಷರಗಳನ್ನು ಸರಿಯಾಗಿ ಜೋಡಿಸಿದಾಗ ‘ಮಹಾಭಾರತ’ ಎಂದಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕೃಷ್ಣನ ರಕ್ತವನ್ನು ಹೀರಿದವಳು ಯಾರು?",
            options = listOf("ದೇವಕಿ", "ಪೂತನಿ", "ರೋಹಿಣಿ", "ಯಶೋದೆ"),
            correctAnswer = "ಪೂತನಿ",
            explanation = "ವಿಷದ ಮೊಲೆಹಾಲು ಕುಡಿಸಲು ಬಂದ ರಾಕ್ಷಸಿ ಪೂತನಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕೃಷ್ಣನ ಬಗ್ಗೆ ಹುಡುಕಾಟ ನಡೆಸುತ್ತಿದ್ದವರು ಯಾರು?",
            options = listOf("ಗೋಪಾಲಕರು", "ಸೈನಿಕರು", "ಘಟಚಾರರು", "ರೈತರು"),
            correctAnswer = "ಘಟಚಾರರು",
            explanation = "ಕಂಸನ ಗೂಢಚಾರರಾದ ಘಟಚಾರರು ಹುಡುಕಾಟ ನಡೆಸುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕಂಸನ ಪರವಾಗಿ ಕೆಲಸ ಮಾಡಲು ಬಂದವರು ಯಾರು?",
            options = listOf("ಮಂತ್ರಿ ಮತ್ತು ವೈದ್ಯ", "ಸೈನಿಕ ಮತ್ತು ದುರ್ವಿಧ", "ನಂದ ಮತ್ತು ಯಶೋದೆ", "ವಸುದೇವ ಮತ್ತು ದೇವಕಿ"),
            correctAnswer = "ಸೈನಿಕ ಮತ್ತು ದುರ್ವಿಧ",
            explanation = "ಸೈನಿಕ ಮತ್ತು ದುರ್ವಿಧ ಕಂಸನ ಆದೇಶ ಪಾಲಿಸಲು ಬಂದವರು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಾಜಗೋಪುರದ ಇಡೀ ರಚನೆ ಯಾವುದರ ಮೇಲೆ ನಿಂತಿತ್ತು?",
            options = listOf("ದೊಡ್ಡ ಕಲ್ಲಿನ ಮೇಲೆ", "ಸಣ್ಣ ಕೀಲಿನ ಮೇಲೆ", "ಮರದ ಕಂಬದ ಮೇಲೆ", "ಕಬ್ಬಿಣದ ಸರಪಳಿಯ ಮೇಲೆ"),
            correctAnswer = "ಸಣ್ಣ ಕೀಲಿನ ಮೇಲೆ",
            explanation = "ರಾಜಗೋಪುರದ ಇಡೀ ರಚನೆ ಸಣ್ಣ ಕೀಲಿನ ಮೇಲೆ ನಿಂತಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_13",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಪಟ್ಟದ ಆನೆಯ ಹೆಸರು ಯಾವುದು?",
            options = listOf("ಶೈಲಿಕ", "ಕುವಲಯಾಪೀಡ", "ಧೇನುಕ", "ತೃಣಾವರ್ತ"),
            correctAnswer = "ಕುವಲಯಾಪೀಡ",
            explanation = "ಕಂಸನ ಪಟ್ಟದ ಆನೆಯ ಹೆಸರು ಕುವಲಯಾಪೀಡ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_14",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ವಸುದೇವ ಮತ್ತು ದೇವಕಿ ಎಲ್ಲಿದ್ದರು?",
            options = listOf("ಅರಮನೆಯಲ್ಲಿ", "ಆಶ್ರಮದಲ್ಲಿ", "ಸೆರೆಮನೆಯಲ್ಲಿ", "ಉದ್ಯಾನದಲ್ಲಿ"),
            correctAnswer = "ಸೆರೆಮನೆಯಲ್ಲಿ",
            explanation = "ಕಂಸನು ವಸುದೇವ-ದೇವಕಿಯರನ್ನು ಸೆರೆಮನೆಯಲ್ಲಿ ಬಂಧಿಸಿದ್ದನು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_15",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಾಕ್ಷಸರು ಏನನ್ನು ಕುಡಿಯುವವರು ಎಂದು ಪಾಠದಲ್ಲಿ ಹೇಳಲಾಗಿದೆ?",
            options = listOf("ನೀರು", "ಹಾಲು", "ಹಲಾಹಲ", "ಜೇನು"),
            correctAnswer = "ಹಲಾಹಲ",
            explanation = "ರಾಕ್ಷಸರು ಹಲಾಹಲವನ್ನು ಕುಡಿಯುವವರು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_16",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಮಥುರಾ ನಗರದಲ್ಲಿ ಯಾವ ಮಹೋತ್ಸವ ನಡೆಯುತ್ತಿತ್ತು?",
            options = listOf("ದೀಪಾವಳಿ ಮಹೋತ್ಸವ", "ಧನುರ್ಜಾಗ ಮಹೋತ್ಸವ", "ದಸರಾ ಮಹೋತ್ಸವ", "ಕೃಷಿ ಮಹೋತ್ಸವ"),
            correctAnswer = "ಧನುರ್ಜಾಗ ಮಹೋತ್ಸವ",
            explanation = "ಮಥುರಾ ನಗರದಲ್ಲಿ ಬಿಲ್ಲ ಹಬ್ಬ ಅಥವಾ ಧನುರ್ಜಾಗ ಮಹೋತ್ಸವ ಏರ್ಪಡಿಸಲಾಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_17",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಾಜನ ಮುಂದೆ ತಮ್ಮ ಶಕ್ತಿಯನ್ನು ಪ್ರದರ್ಶಿಸಿದವರಿಗೆ ಯಾವ ಪ್ರಶಸ್ತಿ ಸಿಗಬೇಕಿತ್ತು?",
            options = listOf("ಮಥುರಾವೀರ ಪ್ರಶಸ್ತಿ", "ರಾಜ್ಯ ಪ್ರಶಸ್ತಿ", "ಶೌರ್ಯ ಪ್ರಶಸ್ತಿ", "ವೀರಚಕ್ರ"),
            correctAnswer = "ಮಥುರಾವೀರ ಪ್ರಶಸ್ತಿ",
            explanation = "ಶಕ್ತಿ ಪ್ರದರ್ಶಿಸಿದ ಮಲ್ಲರಿಗೆ ಮಥುರಾವೀರ ಪ್ರಶಸ್ತಿ ನೀಡಲಾಗುತ್ತಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_18",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ದೇವಕಿಯ ಪ್ರಕಾರ ಕೃಷ್ಣ ಯಾರ ಮಗ?",
            options = listOf("ನಂದ ಮತ್ತು ಯಶೋದೆಯ ಮಗ", "ವಸುದೇವ ಮತ್ತು ದೇವಕಿಯ ಮಗ", "ಕಂಸನ ಮಗ", "ಬಲರಾಮನ ಮಗ"),
            correctAnswer = "ವಸುದೇವ ಮತ್ತು ದೇವಕಿಯ ಮಗ",
            explanation = "ದೇವಕಿಯ ಪ್ರಕಾರ ಕೃಷ್ಣ ವಸುದೇವ ಮತ್ತು ದೇವಕಿಯ ಹೆತ್ತ ಮಗ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_19",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕಂಸನ ಅರಮನೆಯಲ್ಲಿ ಗುಸುಗುಸು ಮಾತನಾಡುತ್ತಿದ್ದವರು ಯಾರು?",
            options = listOf("ಮಂತ್ರಿ ಮತ್ತು ಸೈನಿಕ", "ಮಂತ್ರಿ ಮತ್ತು ದುರ್ವಿಧ", "ಮಂತ್ರಿ ಮತ್ತು ವೈದ್ಯ", "ಮಂತ್ರಿ ಮತ್ತು ಸೇನಾಪತಿ"),
            correctAnswer = "ಮಂತ್ರಿ ಮತ್ತು ವೈದ್ಯ",
            explanation = "ಕಂಸನ ಅರಮನೆಯಲ್ಲಿ ಮಂತ್ರಿ ಮತ್ತು ವೈದ್ಯ ಗುಸುಗುಸು ಮಾತನಾಡುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_20",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕೃಷ್ಣನ ಕೈಯಲ್ಲಿ ತೃಣಾವರ್ತ ಏನಾಗಿ ಹೋದನು?",
            options = listOf("ಗಾತ್ರ", "ಬುಗರಿ", "ಬಾಡಿಗೆ", "ಬಂಡಿ"),
            correctAnswer = "ಬುಗರಿ",
            explanation = "ಕೃಷ್ಣನ ಶಕ್ತಿಗೆ ತೃಣಾವರ್ತ ಸುಳಿಯಂತೆ ಬುಗರಿಯಾಗಿ ಹೋದನು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_21",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಮಂತ್ರಿಯು ಯಾವುದಕ್ಕೆ ಹಬ್ಬಾಳವನ್ನು ತಯಾರಿಸಿದ್ದನು?",
            options = listOf("ಕ್ರೀಡಾಂಗಣ", "ಅರಮನೆ", "ಒಡ್ಡೋಲಗ", "ಸೆರೆಮನೆ"),
            correctAnswer = "ಕ್ರೀಡಾಂಗಣ",
            explanation = "ಮಲ್ಲಯುದ್ಧಕ್ಕಾಗಿ ಕ್ರೀಡಾಂಗಣವನ್ನು ಸಜ್ಜುಗೊಳಿಸಲಾಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_22",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕುವಲಯಾಪೀಡ ಯಾವ ಬಣ್ಣವನ್ನು ನೋಡಿದರೆ ಮೈಮೇಲೆ ಬೀಳುತ್ತಿತ್ತು?",
            options = listOf("ಕೆಂಪು", "ಹಸಿರು", "ಕಪ್ಪು", "ಹಳದಿ"),
            correctAnswer = "ಹಳದಿ",
            explanation = "ಕುವಲಯಾಪೀಡ ಆನೆ ಹಳದಿ ಬಣ್ಣ ನೋಡಿದರೆ ಕೆರಳಿ ಮೈಮೇಲೆ ಬೀಳುತ್ತಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_23",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ವಸುದೇವನು ಕೃಷ್ಣನನ್ನು ನೋಡಿ ಎಷ್ಟು ವರ್ಷಗಳಾಗಿದ್ದವು?",
            options = listOf("ಹತ್ತು", "ಇಪ್ಪತ್ತು", "ಹದಿನೈದು", "ಹದಿನಾರು"),
            correctAnswer = "ಹದಿನಾರು",
            explanation = "ವಸುದೇವನು ಕೃಷ್ಣನನ್ನು ನೋಡಿ ಹದಿನಾರು ವರ್ಷಗಳಾಗಿದ್ದವು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_24",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕಂಸನು ಶೃಂಖಲೆಯನ್ನು ಯಾವುದರಿಂದ ಮಾಡಿಸಿದ್ದನು?",
            options = listOf("ಕಬ್ಬಿಣ", "ಅಪರಂಜಿ", "ಬೆಳ್ಳಿ", "ತಾಮ್ರ"),
            correctAnswer = "ಅಪರಂಜಿ",
            explanation = "ಕಂಸನು ಅಪರಂಜಿಯಿಂದ (ಶುದ್ಧ ಬಂಗಾರ) ಶೃಂಖಲೆಯನ್ನು ಮಾಡಿಸಿದ್ದನು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_25",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಧನುರ್ಜಾಗ ಮಹೋತ್ಸವವು ಯಾವ ನಗರದಲ್ಲಿ ನಡೆಯುತ್ತಿತ್ತು?",
            options = listOf("ಮಥುರಾ", "ದ್ವಾರಕಾ", "ಗೋಕುಲ", "ಕಾಳಿ"),
            correctAnswer = "ಮಥುರಾ",
            explanation = "ಧನುರ್ಜಾಗ ಮಹೋತ್ಸವ ಮಥುರಾ ನಗರದಲ್ಲಿ ನಡೆಯುತ್ತಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_26",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕಂಸನು ಲಕ್ಷಲಕ್ಷ ಮಕ್ಕಳನ್ನು ಕೊಲ್ಲಿಸಿದ್ದು ಯಾವ ರಾತ್ರಿ?",
            options = listOf("ಅಷ್ಟಮಿ", "ನವಮಿ", "ದಶಮಿ", "ಪಂಚಮಿ"),
            correctAnswer = "ಅಷ್ಟಮಿ",
            explanation = "ಕೃಷ್ಣ ಜನಿಸಿದ ಅಷ್ಟಮಿ ರಾತ್ರಿಯ ನಂತರ ಕಂಸ ಮಕ್ಕಳನ್ನು ಸಂಹರಿಸಲು ಯತ್ನಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_7_kan_u7_27",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ವಸುದೇವನ ಮೊದಲ ಹೆಂಡತಿ ಯಾರು?",
            options = listOf("ಪೂತನಿ", "ರೋಹಿಣಿ", "ದೇವಕಿ", "ಯಶೋದೆ"),
            correctAnswer = "ರೋಹಿಣಿ",
            explanation = "ವಸುದೇವನ ಮೊದಲ ಹೆಂಡತಿ ರೋಹಿಣಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u7_28",
            stdId = 7,
            subjectId = "kannada",
            unitId = 7,
            type = "MCQ",
            questionText = "ಕಂಸನಿಂದ ಕೊಲ್ಲಲು ಸಾಧ್ಯವಾಗದೆ ಉಳಿದವನು ಯಾರು?",
            options = listOf("ಶಕಟ", "ತೃಣಾವರ್ತ", "ಕೃಷ್ಣ", "ಶೈಲಿಕ"),
            correctAnswer = "ಕೃಷ್ಣ",
            explanation = "ಕಂಸನ ಎಲ್ಲ ಸಂಚುಗಳನ್ನು ಮೆಟ್ಟಿ ನಿಂತು ಉಳಿದವನು ಶ್ರೀಕೃಷ್ಣ."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 8: ಸಂಕ್ರಾಂತಿಯಂದು ಸುಖ–ದುಃಖ (Unit 8)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u8_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "“ಭಾರತದಲ್ಲಿ ಎಷ್ಟೆಂಥ ಭಾಷೆಗಳು!” ಎಂಬ ವಾಕ್ಯದ ಕೊನೆಯಲ್ಲಿ ಯಾವ ಲೇಖನ ಚಿಹ್ನೆ ಬಳಸಬೇಕು?",
            options = listOf("!", "?", "‘ ’", ":-"),
            correctAnswer = "!",
            explanation = "ಆಶ್ಚರ್ಯ ಅಥವಾ ಭಾವನೆ ವ್ಯಕ್ತಪಡಿಸುವಾಗ ಭಾವಸೂಚಕ ಚಿಹ್ನೆ (!) ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "“ನನಗೆ ಇಬ್ಬರು ಬಾವ ಇದ್ದಾರೆ” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿ ‘ಬಾವ’ ಪದದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ಬಾವಗಳು", "ಭಾಷಾವಾರು", "ಬಾವಂದಿರು", "ಬಾವ"),
            correctAnswer = "ಬಾವಂದಿರು",
            explanation = "ಬಾವ ಪದದ ಬಹುವಚನ ಬಾವಂದಿರು."
        ),
        QuestionModel(
            id = "s_7_kan_u8_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಹಿರಿಯರು ಸಂಕ್ರಾಂತಿ ಎಂದು ಜಗಳವಾಡಿದವರನ್ನು ಒಂದೆಡೆ ಸೇರಿಸಿ ಏನು ಮಾಡುತ್ತಿದ್ದರು?",
            options = listOf("ಒಗ್ಗಟ್ಟು", "ರಾಜಿ", "ಶಿಕ್ಷೆ", "ಒಬ್ಬಟ್ಟು"),
            correctAnswer = "ರಾಜಿ",
            explanation = "ಎಳ್ಳು-ಬೆಲ್ಲ ಹಂಚಿ ಹಳೆಯ ವೈಮನಸ್ಯ ಮರೆಸಿ ರಾಜಿ ಮಾಡಿಸುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u8_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಬೇವು–ಬೆಲ್ಲ ಹಂಚಿ ತಿನ್ನುವ ಹಬ್ಬ ಯಾವುದು?",
            options = listOf("ಸಂಕ್ರಾಂತಿ", "ಯುಗಾದಿ", "ದಸರಾ", "ವಿಜಯದಶಮಿ"),
            correctAnswer = "ಯುಗಾದಿ",
            explanation = "ಬೇವು-ಬೆಲ್ಲ ಹಂಚಿ ತಿನ್ನುವ ಹೊಸ ವರ್ಷದ ಹಬ್ಬ ಯುಗಾದಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "‘ಅಪ್ಪ ಅಂದರೆ ಆಕಾಶ’ ಕೃತಿಯ ರಚನಕಾರರು ಯಾರು?",
            options = listOf("ಎ. ಆರ್. ಮಣಿಕಾಂತ್", "ಕೃಷ್ಣಾನಂದ ಕಾಮತ್", "ಪೂರ್ಣಚಂದ್ರ ತೇಜಸ್ವಿ", "ಹೆಚ್. ಎಸ್. ವೆಂಕಟೇಶಮೂರ್ತಿ"),
            correctAnswer = "ಎ. ಆರ್. ಮಣಿಕಾಂತ್",
            explanation = "‘ಅಪ್ಪ ಅಂದರೆ ಆಕಾಶ’ ಕೃತಿಯನ್ನು ಎ. ಆರ್. ಮಣಿಕಾಂತ್ ರಚಿಸಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "‘ನೆನಪಿನ ದೋಣಿಯಲ್ಲಿ’ ಎಂಬ ಗ್ರಂಥದ ಹೆಸರಿಗೆ ಬಳಸುವ ಲೇಖನ ಚಿಹ್ನೆ ಯಾವುದು?",
            options = listOf("ಭಾವಸೂಚಕ", "ವಾಕ್ಯವೇಷ್ಠನ", "ಪ್ರಶ್ನಾರ್ಥಕ", "ಉದ್ಧರಣ"),
            correctAnswer = "ಉದ್ಧರಣ",
            explanation = "ಕೃತಿಯ ಹೆಸರು ಅಥವಾ ಪ್ರಮುಖ ಪದವನ್ನು ಸೂಚಿಸಲು ಉದ್ಧರಣ ಚಿಹ್ನೆ (‘ ’) ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಜಾತಿ, ಧರ್ಮ, ಲಿಂಗಭೇದವಿಲ್ಲದೆ ಆಚರಿಸುವ ಹಬ್ಬಗಳು ಯಾವುವು?",
            options = listOf("ರಾಷ್ಟ್ರೀಯ ಹಬ್ಬಗಳು", "ಧಾರ್ಮಿಕ ಹಬ್ಬಗಳು ಮಾತ್ರ", "ಕುಟುಂಬದ ಹಬ್ಬಗಳು", "ಜನ್ಮದಿನಗಳು"),
            correctAnswer = "ರಾಷ್ಟ್ರೀಯ ಹಬ್ಬಗಳು",
            explanation = "ಎಲ್ಲ ಭಾರತೀಯರು ಒಗ್ಗಟ್ಟಾಗಿ ಆಚರಿಸುವುದು ರಾಷ್ಟ್ರೀಯ ಹಬ್ಬಗಳು."
        ),
        QuestionModel(
            id = "s_7_kan_u8_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಜಾನುವಾರುಗಳಿಗೆ ಮೀಸಲಾದ ವಿಶೇಷ ಹಬ್ಬ ಯಾವುದು?",
            options = listOf("ಯುಗಾದಿ", "ಸಂಕ್ರಾಂತಿ", "ದೀಪಾವಳಿ", "ಕ್ರಿಸ್ಮಸ್"),
            correctAnswer = "ಸಂಕ್ರಾಂತಿ",
            explanation = "ಸಂಕ್ರಾಂತಿಯ ಮರುದಿನ ರಾಸುಗಳನ್ನು ಸಿಂಗರಿಸಿ ಕಿಚ್ಚು ಹಾಯಿಸಿ ಸಂಭ್ರಮಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "“ನಮ್ಮ ಮನೆಯಲ್ಲಿ ನಾಲ್ಕು ದನ ಇದೆ” ಎಂಬ ವಾಕ್ಯದ ಸರಿಯಾದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ನಮ್ಮ ಮನೆಯಲ್ಲಿ ನಾಲ್ಕು ದನಗಳು ಇವೆ.", "ನಮ್ಮ ಮನೆಯಲ್ಲಿ ನಾಲ್ಕು ದನ ಇದ್ದಾನೆ.", "ನಮ್ಮ ಮನೆಯಲ್ಲಿ ನಾಲ್ಕು ದನ ಇತ್ತು.", "ನಮ್ಮ ಮನೆಯಲ್ಲಿ ನಾಲ್ಕು ದನದಿದೆ."),
            correctAnswer = "ನಮ್ಮ ಮನೆಯಲ್ಲಿ ನಾಲ್ಕು ದನಗಳು ಇವೆ.",
            explanation = "‘ದನಗಳು ಇವೆ’ ಎಂಬುದು ವ್ಯಾಕರಣಬದ್ಧ ಬಹುವಚನ ರೂಪ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ದನಕರುಗಳನ್ನು ಬೆಂಕಿಯಲ್ಲಿ ಹಾರಿಸುವುದನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಧ್ವಜಾರೋಹಣ", "ಕಿಚ್ಚು ಹಾಯಿಸುವುದು", "ಪೂಜೆ ಮಾಡುವುದು", "ಮೆರವಣಿಗೆ"),
            correctAnswer = "ಕಿಚ್ಚು ಹಾಯಿಸುವುದು",
            explanation = "ಸಂಕ್ರಾಂತಿಯಲ್ಲಿ ಹಳ್ಳಿಗಳಲ್ಲಿ ದನಕರುಗಳಿಗೆ ಕಿಚ್ಚು ಹಾಯಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಇಂದಿನ ಕಾಲದಲ್ಲಿ ಕೃಷಿಕರ ಮನೆಗೆ ದನಕರುಗಳ ಜಾಗಕ್ಕೆ ಬಂದು ನಿಲ್ಲುವ ವಾಹನ ಯಾವುದು?",
            options = listOf("ಕಾರು", "ಬಸ್ಸು", "ಟ್ರ್ಯಾಕ್ಟರ್", "ರೈಲು"),
            correctAnswer = "ಟ್ರ್ಯಾಕ್ಟರ್",
            explanation = "ಯಾಂತ್ರೀಕರಣದ ಪರಿಣಾಮವಾಗಿ ಎತ್ತು-ದನಗಳ ಜಾಗಕ್ಕೆ ಟ್ರ್ಯಾಕ್ಟರ್ ಬಂದಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಹಳ್ಳಿಗಳಲ್ಲಿ ಪಟೇಲರು ಸಂಕ್ರಾಂತಿಯಂದು ಏನು ಮಾಡುತ್ತಿದ್ದರು?",
            options = listOf("ಎಳ್ಳು–ಬೆಲ್ಲ ಹಂಚಿ ರಾಜಿ ಮಾಡಿಸುತ್ತಿದ್ದರು", "ಮಕ್ಕಳಿಗೆ ಪುಸ್ತಕ ಹಂಚುತ್ತಿದ್ದರು", "ಜಾತ್ರೆ ನಡೆಸುತ್ತಿದ್ದರು", "ಬೆಳೆ ಮಾರಾಟ ಮಾಡುತ್ತಿದ್ದರು"),
            correctAnswer = "ಎಳ್ಳು–ಬೆಲ್ಲ ಹಂಚಿ ರಾಜಿ ಮಾಡಿಸುತ್ತಿದ್ದರು",
            explanation = "ಗ್ರಾಮದ ಮುಖಂಡರು ಸಂಕ್ರಾಂತಿ ದಿನದಂದು ಪರಸ್ಪರ ಎಳ್ಳು-ಬೆಲ್ಲ ಹಂಚಿಸಿ ವಿವಾದಗಳನ್ನು ಬಗೆಹರಿಸುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_7_kan_u8_13",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ನಮ್ಮ ಸಂಕ್ರಾಂತಿಯಲ್ಲಿ ಏನಿರಬೇಕು?",
            options = listOf("ಸ್ಪರ್ಧೆ", "ಪ್ರೀತಿ", "ಕೋಪ", "ಜಗಳ"),
            correctAnswer = "ಪ್ರೀತಿ",
            explanation = "ಸಂಕ್ರಾಂತಿಯ ಆಶಯ ಪ್ರೀತಿ, ಸೌಹಾರ್ದತೆ ಮತ್ತು ಮಧುರ ಬಾಂಧವ್ಯ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_14",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂಕ್ರಾಂತಿ ಹಬ್ಬದಂದು ಹಂಚುವ ಪದಾರ್ಥಗಳು ಯಾವುವು?",
            options = listOf("ಹಣ್ಣು ಮತ್ತು ಹಾಲು", "ಎಳ್ಳು–ಬೆಲ್ಲ", "ಅಕ್ಕಿ ಮತ್ತು ಉಪ್ಪು", "ಹಾಲು ಮತ್ತು ತುಪ್ಪ"),
            correctAnswer = "ಎಳ್ಳು–ಬೆಲ್ಲ",
            explanation = "‘ಎಳ್ಳು-ಬೆಲ್ಲ ತಿಂದು ಒಳ್ಳೆ ಮಾತಾಡು’ ಎಂದು ಸಂಕ್ರಾಂತಿಯಂದು ಎಳ್ಳು-ಬೆಲ್ಲ ಹಂಚುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_15",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂಕ್ರಾಂತಿಯಂದು ಮನೆಯಲ್ಲಿ ವಿಶೇಷವಾಗಿ ಏನೆಲ್ಲ ಅಡುಗೆ ಮಾಡುತ್ತಾರೆ?",
            options = listOf("ಪೊಂಗಲ್, ತರಕಾರಿ ಕೂಟ ಮತ್ತು ಸಿಹಿತಿಂಡಿಗಳು", "ಕೇವಲ ಅನ್ನ ಮತ್ತು ಸಾರು", "ಕೇವಲ ರೊಟ್ಟಿ", "ಕೇವಲ ಹಣ್ಣುಗಳು"),
            correctAnswer = "ಪೊಂಗಲ್, ತರಕಾರಿ ಕೂಟ ಮತ್ತು ಸಿಹಿತಿಂಡಿಗಳು",
            explanation = "ಹೊಸ ಅಕ್ಕಿಯ ಪೊಂಗಲ್, ತರಕಾರಿ ಕೂಟ ಮತ್ತು ಸಿಹಿತಿಂಡಿಗಳನ್ನು ತಯಾರಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_16",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂಕ್ರಾಂತಿ ದಿನದಿಂದ ಸೂರ್ಯನು ಯಾವ ದಿಕ್ಕಿಗೆ ಚಲಿಸಲು ಆರಂಭಿಸುತ್ತಾನೆ ಎಂದು ಪಾಠದಲ್ಲಿ ವಿವರಿಸಲಾಗಿದೆ?",
            options = listOf("ಉತ್ತರದಿಂದ ದಕ್ಷಿಣಕ್ಕೆ", "ದಕ್ಷಿಣದಿಂದ ಉತ್ತರಕ್ಕೆ", "ಪೂರ್ವದಿಂದ ಪಶ್ಚಿಮಕ್ಕೆ", "ಪಶ್ಚಿಮದಿಂದ ಪೂರ್ವಕ್ಕೆ"),
            correctAnswer = "ದಕ್ಷಿಣದಿಂದ ಉತ್ತರಕ್ಕೆ",
            explanation = "ಸೂರ್ಯನು ದಕ್ಷಿಣಾಯನದಿಂದ ಉತ್ತರಾಯಣಕ್ಕೆ (ದಕ್ಷಿಣದಿಂದ ಉತ್ತರಕ್ಕೆ) ಚಲಿಸುತ್ತಾನೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_17",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "‘ಸಂಕ್ರಾಂತಿ’ ಪದವು ಯಾವ ಆಶಯವನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ದುಃಖದ ಆರಂಭ", "ಉತ್ತಮ ದಿನಗಳ ಸ್ವಾಗತದ ಆಶಯ", "ಮಳೆಗಾಲದ ಆರಂಭ", "ಬೆಳೆ ನಾಶದ ಸೂಚನೆ"),
            correctAnswer = "ಉತ್ತಮ ದಿನಗಳ ಸ್ವಾಗತದ ಆಶಯ",
            explanation = "ಸಂಕ್ರಾಂತಿ ಎಂದರೆ ಸಂಕ್ರಮಣ - ಶುಭದಾಯಕ, ಸಮೃದ್ಧ ದಿನಗಳ ಆರಂಭ."
        ),
        QuestionModel(
            id = "s_7_kan_u8_18",
            stdId = 7,
            subjectId = "kannada",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸಂಕ್ರಾಂತಿಯಂದು ಎಳ್ಳು–ಬೆಲ್ಲ ಹಂಚುವುದರ ಕುರಿತು ಪಾಠದಲ್ಲಿ ಯಾವ ವಿಷಯವನ್ನು ಚರ್ಚಿಸಲಾಗಿದೆ?",
            options = listOf("ಇಂದಿನ ಕಾಲದಲ್ಲಿ ಅದು ಪ್ರತಿಷ್ಠೆಯ ವಿಚಾರವಾಗಿರುವುದು", "ಅದನ್ನು ಸಂಪೂರ್ಣವಾಗಿ ನಿಲ್ಲಿಸಿರುವುದು", "ಕೇವಲ ಮಕ್ಕಳಿಗೆ ಹಂಚುವುದು", "ಹಬ್ಬದಂದು ಹಂಚಬಾರದು ಎಂಬುದು"),
            correctAnswer = "ಇಂದಿನ ಕಾಲದಲ್ಲಿ ಅದು ಪ್ರತಿಷ್ಠೆಯ ವಿಚಾರವಾಗಿರುವುದು",
            explanation = "ಸರಳ ಆಚರಣೆ ಇಂದು ಆಡಂಬರ ಮತ್ತು ಪ್ರತಿಷ್ಠೆಯ ವಿಷಯವಾಗಿ ಬದಲಾಗುತ್ತಿರುವ ಬಗ್ಗೆ ಚರ್ಚಿಸಲಾಗಿದೆ."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 9: ಹುತ್ತರಿ ಹಾಡು (Unit 9)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u9_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "‘ಬಗ್ಗ’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಹುಲಿ", "ಭೂದೇವಿ", "ಶರೀರ", "ಆಶ್ಚರ್ಯ"),
            correctAnswer = "ಹುಲಿ",
            explanation = "‘ಬಗ್ಗ’ ಎಂದರೆ ಹುಲಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u9_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "‘ಭೂರಮೆ’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಆಕಾಶ", "ಭೂದೇವಿ", "ನದಿ", "ಬೆಟ್ಟ"),
            correctAnswer = "ಭೂದೇವಿ",
            explanation = "‘ಭೂರಮೆ’ ಎಂದರೆ ಭೂಮಿ ಅಥವಾ ಭೂದೇವಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u9_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "‘ಒಡಲು’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಮನೆ", "ಕಾಡು", "ಶರೀರ / ದೇಹ", "ನೀರು"),
            correctAnswer = "ಶರೀರ / ದೇಹ",
            explanation = "‘ಒಡಲು’ ಎಂದರೆ ಶರೀರ ಅಥವಾ ದೇಹ."
        ),
        QuestionModel(
            id = "s_7_kan_u9_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "‘ಬೆರಗು’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ದುಃಖ", "ಕೋಪ", "ಸಂತೋಷ", "ಆಶ್ಚರ್ಯ"),
            correctAnswer = "ಆಶ್ಚರ್ಯ",
            explanation = "‘ಬೆರಗು’ ಎಂದರೆ ಆಶ್ಚರ್ಯ ಅಥವಾ ವಿಸ್ಮಯ."
        ),
        QuestionModel(
            id = "s_7_kan_u9_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "‘ದೇಶ ಸೇವೆ’ ಎಂಬುದಕ್ಕೆ ಪಾಠದ ಉತ್ತರ ಸೂಚಿಯಲ್ಲಿ ನೀಡಿರುವ ಪದ ಯಾವುದು?",
            options = listOf("ಈಶ ಸೇವೆ", "ಮನೆ ಸೇವೆ", "ಜನ ಸೇವೆ", "ವನ ಸೇವೆ"),
            correctAnswer = "ಈಶ ಸೇವೆ",
            explanation = "‘ದೇಶ ಸೇವೆಯೆ ಈಶ ಸೇವೆ’ ಎಂಬುದು ಗಾದೆಯಾಧಾರಿತ ಸಾಲು."
        ),
        QuestionModel(
            id = "s_7_kan_u9_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "‘ದೇಶವೇ ಗುಡಿ’ ಎಂಬ ಸಾಲಿಗೆ ಸಂಬಂಧಿಸಿದ ಸರಿಯಾದ ಉತ್ತರ ಯಾವುದು?",
            options = listOf("ದೇಶವೇ ನದಿ", "ದೇಶಕ್ಕಾಗಿ ದುಡಿ", "ದೇಶವೇ ಬೆಟ್ಟ", "ದೇಶವೇ ಹೂವು"),
            correctAnswer = "ದೇಶಕ್ಕಾಗಿ ದುಡಿ",
            explanation = "‘ದೇಶವೇ ಗುಡಿ, ಕೈಯೇ ಕಾಯಕ, ದೇಶಕ್ಕಾಗಿ ದುಡಿ’."
        ),
        QuestionModel(
            id = "s_7_kan_u9_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "‘ಹುತ್ತರಿ ಹಾಡು’ ಯಾವ ಗುಂಪಿಗೆ ಸೇರುತ್ತದೆ?",
            options = listOf("ಶಿಶುಗೀತೆ", "ಜೋಗುಳ", "ಸುಗ್ಗಿ ಹಾಡು", "ಪ್ರಾರ್ಥನೆ"),
            correctAnswer = "ಸುಗ್ಗಿ ಹಾಡು",
            explanation = "ಹುತ್ತರಿ ಹಾಡು ಸುಗ್ಗಿಯ ಸಂಭ್ರಮವನ್ನು ಸಾರುವ ಸುಗ್ಗಿ ಹಾಡಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u9_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಹುತ್ತರಿ ಹಬ್ಬವನ್ನು ಯಾವಾಗ ಆಚರಿಸುತ್ತಾರೆ?",
            options = listOf("ಬಿತ್ತನೆ ಸಮಯದಲ್ಲಿ", "ಮಳೆಗಾಲದಲ್ಲಿ", "ಹೊಸ ಬೆಳೆ ಬಂದಾಗ", "ಬೇಸಿಗೆಯಲ್ಲಿ"),
            correctAnswer = "ಹೊಸ ಬೆಳೆ ಬಂದಾಗ",
            explanation = "ಸುಗ್ಗಿಯ ಕಾಲದಲ್ಲಿ ಹೊಲದಿಂದ ಹೊಸ ಬೆಳೆ ಮನೆಗೆ ಬಂದಾಗ ಹುತ್ತರಿ ಹಬ್ಬ ಆಚರಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u9_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಹುತ್ತರಿ ಹಬ್ಬವು ಮುಖ್ಯವಾಗಿ ಯಾವ ಬೆಳೆಗೆ ಸಂಬಂಧಿಸಿದೆ?",
            options = listOf("ಹತ್ತಿ", "ಭತ್ತ", "ಕಬ್ಬು", "ರಾಗಿ"),
            correctAnswer = "ಭತ್ತ",
            explanation = "ಹುತ್ತರಿ ಹಬ್ಬವು ಮುಖ್ಯವಾಗಿ ಭತ್ತದ ಸುಗ್ಗಿಯ ಹಬ್ಬವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u9_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಹುತ್ತರಿ ಹಾಡಿನಿಂದ ತಿಳಿಯುವ ಮುಖ್ಯ ವಿಷಯ ಯಾವುದು?",
            options = listOf("ವ್ಯಾಪಾರದ ಮಹತ್ವ", "ಆಟದ ಮಹತ್ವ", "ಪ್ರಯಾಣದ ಮಹತ್ವ", "ಪ್ರಕೃತಿ ಮತ್ತು ಕೃಷಿಯ ಮಹತ್ವ"),
            correctAnswer = "ಪ್ರಕೃತಿ ಮತ್ತು ಕೃಷಿಯ ಮಹತ್ವ",
            explanation = "ಪ್ರಕೃತಿಯ ಸೌಂದರ್ಯ ಮತ್ತು ಕೃಷಿ ಸಂಸ್ಕೃತಿಯ ಮಹತ್ವವನ್ನು ಈ ಹಾಡು ಸಾರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u9_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಹುತ್ತರಿ ಹಾಡಿನಲ್ಲಿ ಯಾವ ಭಾವನೆ ವ್ಯಕ್ತವಾಗಿದೆ?",
            options = listOf("ನಿರಾಶೆ", "ಕೃತಜ್ಞತೆ", "ಭಯ", "ಅಸೂಯೆ"),
            correctAnswer = "ಕೃತಜ್ಞತೆ",
            explanation = "ಭೂತಾಯಿಗೆ ಹಾಗೂ ಪ್ರಕೃತಿಗೆ ಕೃತಜ್ಞತೆ ಸಲ್ಲಿಸುವ ಭಾವನೆ ವ್ಯಕ್ತವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u9_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 9,
            type = "MCQ",
            questionText = "ಹುತ್ತರಿ ಹಬ್ಬವನ್ನು ಯಾವ ಪ್ರದೇಶದ ಜನರು ಪ್ರಮುಖ ಸುಗ್ಗಿ ಹಬ್ಬವಾಗಿ ಆಚರಿಸುತ್ತಾರೆ?",
            options = listOf("ಕೊಡಗು", "ಕರಾವಳಿ", "ಉತ್ತರ ಕರ್ನಾಟಕ", "ಹೈದರಾಬಾದ್ ಕರ್ನಾಟಕ"),
            correctAnswer = "ಕೊಡಗು",
            explanation = "ಕೊಡಗಿನ ನಾಡಿನಲ್ಲಿ ಹುತ್ತರಿ ಹಬ್ಬವನ್ನು ಅತ್ಯಂತ ಸಂಭ್ರಮದಿಂದ ಆಚರಿಸಲಾಗುತ್ತದೆ."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 10: ಸ್ವಾತಂತ್ರ್ಯ ಸ್ವರ್ಗ (Unit 10)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u10_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕವಿಯ ಪ್ರಕಾರ ಸ್ವಾತಂತ್ರ್ಯ ಸ್ವರ್ಗದ ಪರಿಕಲ್ಪನೆ ಯಾವುದು?",
            options = listOf("ಸ್ವೇಚ್ಛೆಯ ಸ್ವರ್ಗವಲ್ಲ", "ಹೆದರಿಕೆ ಇರುವುದಿಲ್ಲ", "ಎಲ್ಲರೂ ಒಂದು ಎಂಬ ಭಾವನೆ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಸ್ವಾತಂತ್ರ್ಯ ಸ್ವರ್ಗದಲ್ಲಿ ಭಯವಿರದು, ಎಲ್ಲರೂ ಒಂದಾಗಿರುತ್ತಾರೆ ಹಾಗೂ ಅದು ಕೇವಲ ಸ್ವೇಚ್ಛೆಯಲ್ಲ."
        ),
        QuestionModel(
            id = "s_7_kan_u10_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ಮಸ್ತಕ’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಪುಸ್ತಕ", "ಮೆದುಳು", "ಹೃದಯ", "ಶರೀರ"),
            correctAnswer = "ಮೆದುಳು",
            explanation = "‘ಮಸ್ತಕ’ ಎಂದರೆ ತಲೆ / ಮೆದುಳು."
        ),
        QuestionModel(
            id = "s_7_kan_u10_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ಸ್ವಾತಂತ್ರ್ಯ ಸ್ವರ್ಗ’ ಕವನವನ್ನು ಯಾವ ಕವನ ಸಂಕಲನದಿಂದ ಆರಿಸಲಾಗಿದೆ?",
            options = listOf("ತಮಸಾನದ ಎಡಬಲದಿ", "ನಿರೀಕ್ಷೆಯಲ್ಲಿ", "ಅವ್ವ", "ಗಂಧಕೇಸರ"),
            correctAnswer = "ತಮಸಾನದ ಎಡಬಲದಿ",
            explanation = "ಡಾ. ಎಂ. ಅಕ್ಬರ್ ಅಲಿ ಅವರ ‘ತಮಸಾನದ ಎಡಬಲದಿ’ ಸಂಕಲನದಿಂದ ಈ ಕವನವನ್ನು ಆರಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u10_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "“ಮೈಸೂರಿನಿಂದ ನಮ್ಮ ಶಾಲೆಗೆ ಹುಡುಗ ಬಂದುದನು” ಎಂಬ ವಾಕ್ಯದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ಮೈಸೂರಿನಿಂದ ನಮ್ಮ ಶಾಲೆಗಳಿಗೆ ಹುಡುಗ ಬಂದುದನು.", "ಮೈಸೂರಿನಿಂದ ನಮ್ಮ ಶಾಲೆಗಳಿಗೆ ಹುಡುಗಿಯರು ಬಂದಿದ್ದಾರೆ.", "ಮೈಸೂರಿನಿಂದ ನಮ್ಮ ಶಾಲೆಗೆ ಹುಡುಗಿಯರು ಬಂದಿದ್ದಾರೆ.", "ಮೈಸೂರಿನಿಂದ ನಮ್ಮ ಶಾಲೆಗೆ ಹುಡುಗ ಬಂದಿದ್ದಾರೆ."),
            correctAnswer = "ಮೈಸೂರಿನಿಂದ ನಮ್ಮ ಶಾಲೆಗಳಿಗೆ ಹುಡುಗಿಯರು ಬಂದಿದ್ದಾರೆ.",
            explanation = "ಶಾಲೆಯ ಬಹುವಚನ ಶಾಲೆಗಳು, ಹುಡುಗರಿಗೆ ಹುಡುಗಿಯರು/ಹುಡುಗರು."
        ),
        QuestionModel(
            id = "s_7_kan_u10_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "“ಚಡ್ಡಿ ಜಡ್ಡಿ ಹಾಕಿಕೊಂಡು ಕುದುರೆ ಮೇಲೆ ಕುಳಿತುಕೊಂಡು ಲಗಾಮು ಹಿಡಿದುಕೊಂಡು” – ಇದರಲ್ಲಿರುವ ಪ್ರಾಸಪದಗಳು ಯಾವುವು?",
            options = listOf("ಚಡ್ಡಿ, ಕುದುರೆ", "ಹಾಕಿಕೊಂಡು, ಕುಳಿತುಕೊಂಡು", "ಕುದುರೆ, ಲಗಾಮು", "ಜಡ್ಡಿ, ಮೇಲೆ"),
            correctAnswer = "ಹಾಕಿಕೊಂಡು, ಕುಳಿತುಕೊಂಡು",
            explanation = "ಹಾಕಿಕೊಂಡು ಮತ್ತು ಕುಳಿತುಕೊಂಡು ಪ್ರಾಸಪದಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u10_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸಂಕುಚಿತ ಮನೋವೃತ್ತಿ ಅಳಿದರೆ ವಿಶ್ವವು ______ ಆಗುತ್ತದೆ.",
            options = listOf("ಪ್ರತ್ಯೇಕ", "ಒಂದಾಗುತ್ತದೆ", "ದುರ್ಬಲವಾಗುತ್ತದೆ", "ಚಿಕ್ಕದಾಗುತ್ತದೆ"),
            correctAnswer = "ಒಂದಾಗುತ್ತದೆ",
            explanation = "ಸಂಕುಚಿತ ಭಾವನೆ ತೊರೆದರೆ ಇಡೀ ವಿಶ್ವವೇ ಒಂದಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u10_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಡಾ. ಎಂ. ಅಕ್ಬರ್ ಅಲಿ ಅವರ ಕವನ ಸಂಕಲನದ ಹೆಸರನ್ನು ಗುರುತಿಸಿ:",
            options = listOf("ಅವ್ವ", "ನವಚೇತನ", "ನಿರೀಕ್ಷೆಯಲ್ಲಿ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "ಅವ್ವ, ನವಚೇತನ, ನಿರೀಕ್ಷೆಯಲ್ಲಿ ಇವೆಲ್ಲವೂ ಅವರ ಕೃತಿಗಳು."
        ),
        QuestionModel(
            id = "s_7_kan_u10_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸ್ವಾತಂತ್ರ್ಯ ಸ್ವರ್ಗದಲ್ಲಿ ಅಭಿಮಾನಧನವೆನಿಸುವ ಮಸ್ತಕವು ಹೇಗಿರಬೇಕು?",
            options = listOf("ಜಗ್ಗದೆ, ಕುಗ್ಗದೆ, ತಗ್ಗದೆ, ಬಗ್ಗದೆ ನೀಟಾಗಿರಬೇಕು", "ಹೆದರಿಕೆಯಿಂದ ಇರಬೇಕು", "ಸಂಕುಚಿತವಾಗಿರಬೇಕು", "ದುಃಖದಿಂದ ಇರಬೇಕು"),
            correctAnswer = "ಜಗ್ಗದೆ, ಕುಗ್ಗದೆ, ತಗ್ಗದೆ, ಬಗ್ಗದೆ ನೀಟಾಗಿರಬೇಕು",
            explanation = "ಯಾವುದಕ್ಕೂ ಅಂಜದೆ ತಲೆ ಎತ್ತಿ ನಿಲ್ಲುವ ಸ್ವಾಭಿಮಾನಿ ಮಸ್ತಕವಿರಬೇಕು."
        ),
        QuestionModel(
            id = "s_7_kan_u10_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "ಕವಿಯ ಪ್ರಕಾರ ಎಲ್ಲಿ ಪ್ರೀತಿ, ದಯೆ ಮತ್ತು ಕೃಪೆ ಇರುತ್ತವೆಯೋ ಅಲ್ಲಿ ಯಾವುದನ್ನು ಕಾಣಬಹುದು?",
            options = listOf("ಭಯವನ್ನು", "ಸ್ವಾತಂತ್ರ್ಯ ಸ್ವರ್ಗವನ್ನು", "ದುಃಖವನ್ನು", "ಅಸೂಯೆಯನ್ನು"),
            correctAnswer = "ಸ್ವಾತಂತ್ರ್ಯ ಸ್ವರ್ಗವನ್ನು",
            explanation = "ಪ್ರೀತಿ ಮತ್ತು ದಯೆ ನೆಲೆಸಿರುವಲ್ಲಿ ನಿಜವಾದ ಸ್ವಾತಂತ್ರ್ಯ ಸ್ವರ್ಗವನ್ನು ಕಾಣಬಹುದು."
        ),
        QuestionModel(
            id = "s_7_kan_u10_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ನಿತ್ಯ ವೈಶಾಲ್ಯವಹ’ ಎಂಬ ಪದ್ಯಭಾಗದಲ್ಲಿ ಮನಸ್ಸು ಅರಳಲು ಯಾವುದು ಕಾರಣವಾಗುತ್ತದೆ?",
            options = listOf("ಹಣ", "ಅಧಿಕಾರ", "ವಿಶಾಲವಾದ ನಡೆ-ನುಡಿಗಳು", "ಭಯ"),
            correctAnswer = "ವಿಶಾಲವಾದ ನಡೆ-ನುಡಿಗಳು",
            explanation = "ವಿಶಾಲವಾದ ನಡೆ-ನುಡಿಗಳು ಮನುಷ್ಯನ ಮನಸ್ಸನ್ನು ವಿಕಾಸಗೊಳಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u10_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ನಿರ್ಮುಕ್ತ’ ಪದದ ಅರ್ಥಕ್ಕೆ ಹತ್ತಿರವಾದ ಆಯ್ಕೆ ಯಾವುದು?",
            options = listOf("ಬಂಧಿತ", "ಮುಕ್ತ", "ದುಃಖಿತ", "ಸಂಕುಚಿತ"),
            correctAnswer = "ಮುಕ್ತ",
            explanation = "‘ನಿರ್ಮುಕ್ತ’ ಎಂದರೆ ಸಂಪೂರ್ಣ ಮುಕ್ತ ಅಥವಾ ಸ್ವತಂತ್ರ."
        ),
        QuestionModel(
            id = "s_7_kan_u10_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ಹರಿಗಡಿಯದೆ’ ಪದದ ಅರ್ಥಕ್ಕೆ ಹೊಂದುವ ಆಯ್ಕೆ ಯಾವುದು?",
            options = listOf("ಮುಂದುವರಿಯದೆ", "ಹರಿಯದೆ", "ಕಡಿಯದೆ", "ನಿಲ್ಲದೆ"),
            correctAnswer = "ಹರಿಯದೆ",
            explanation = "‘ಹರಿಗಡಿಯದೆ’ ಎಂದರೆ ನಿರಂತರವಾಗಿ ಹರಿಯದೆ ನಿಲ್ಲದಿರುವುದು."
        ),
        QuestionModel(
            id = "s_7_kan_u10_13",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ನಿನ್ನೊಲವು’ ಪದವನ್ನು ಬಿಡಿಸಿದಾಗ ಯಾವ ರೂಪ ಬರುತ್ತದೆ?",
            options = listOf("ನಿನ್ನ + ಒಲವು", "ನಿನ್ನ + ಬಲ", "ನಿನ್ನ + ಮನ", "ನಿನ್ನ + ನೆನಪು"),
            correctAnswer = "ನಿನ್ನ + ಒಲವು",
            explanation = "ನಿನ್ನ + ಒಲವು = ನಿನ್ನೊಲವು (ಲೋಪ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s_7_kan_u10_14",
            stdId = 7,
            subjectId = "kannada",
            unitId = 10,
            type = "MCQ",
            questionText = "‘ಮನವರಳಿ’ ಪದವನ್ನು ಬಿಡಿಸಿದಾಗ ಯಾವ ರೂಪ ಬರುತ್ತದೆ?",
            options = listOf("ಮನ + ಅರಳಿ", "ಮನ + ಮನೆ", "ಮನ + ವರ", "ಮನ + ಹರಳಿ"),
            correctAnswer = "ಮನ + ಅರಳಿ",
            explanation = "ಮನ + ಅರಳಿ = ಮನವರಳಿ (ವ-ಕಾರಾಗಮ ಸಂಧಿ)."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 11: ಹಚ್ಚೇವು ಕನ್ನಡದ ದೀಪ (Unit 11)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u11_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "“ಎಲ್ಲಾದರೂ ಇರು, ಎಂತಾದರೂ ಇರು, ಎಂದೆಂದಿಗೂ ನೀ ಕನ್ನಡವಾಗಿರು” ಎಂಬ ಹಾಡನ್ನು ಬರೆದವರು ಯಾರು?",
            options = listOf("ಕುವೆಂಪು", "ಡಿ. ಎಸ್. ಕರ್ಕಿ", "ಬೇಂದ್ರೆ", "ಪು. ತಿ. ನರಸಿಂಹಾಚಾರ್"),
            correctAnswer = "ಕುವೆಂಪು",
            explanation = "ರಾಷ್ಟ್ರಕವಿ ಕುವೆಂಪು ಅವರು ಈ ಪ್ರಸಿದ್ಧ ಸಾಲುಗಳನ್ನು ಬರೆದಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u11_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಹಚ್ಚೇವು ಕನ್ನಡದ ದೀಪ’ ಪದ್ಯವನ್ನು ಯಾವ ಕವನ ಸಂಕಲನದಿಂದ ಆರಿಸಲಾಗಿದೆ?",
            options = listOf("ಬಣ್ಣದ ಚೆಂಡು", "ಭಾವತೀರ್ಥ", "ನಕ್ಷತ್ರ ಗಾನ", "ಗೀತದರವ"),
            correctAnswer = "ನಕ್ಷತ್ರ ಗಾನ",
            explanation = "ಡಿ. ಎಸ್. ಕರ್ಕಿ ಅವರ ‘ನಕ್ಷತ್ರ ಗಾನ’ ಸಂಕಲನದಿಂದ ಆರಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u11_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಸೂರ್ಯೋದಯ’ ಎಂಬ ಪದವು ಯಾವ ಸಂಧಿಗೆ ಉದಾಹರಣೆ?",
            options = listOf("ಲೋಪ ಸಂಧಿ", "ಗುಣ ಸಂಧಿ", "ಯಣ್ ಸಂಧಿ", "ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ"),
            correctAnswer = "ಗುಣ ಸಂಧಿ",
            explanation = "ಸೂರ್ಯ + ಉದಯ = ಸೂರ್ಯೋದಯ (ಅ + ಉ = ಓ, ಗುಣ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s_7_kan_u11_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ಪದಗಳಲ್ಲಿ ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ ಏರ್ಪಟ್ಟಿರುವ ಪದ ಯಾವುದು?",
            options = listOf("ದೇವೇಂದ್ರ", "ರವೀಂದ್ರ", "ಮಹೇಶ", "ಇತ್ಯಾದಿ"),
            correctAnswer = "ರವೀಂದ್ರ",
            explanation = "ರವಿ + ಇಂದ್ರ = ರವೀಂದ್ರ (ಇ + ಇ = ಈ, ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s_7_kan_u11_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ವೃದ್ಧಿ ಸಂಧಿಗೆ ಸೇರಿದ ಭಿನ್ನವಾದ ಪದ ಯಾವುದು?",
            options = listOf("ಏಕೈಕ", "ವನೌಷಧಿ", "ಜಾತ್ಯತೀತ", "ಲೋಕೈಕ"),
            correctAnswer = "ವನೌಷಧಿ",
            explanation = "ವನ + ಔಷಧಿ = ವನೌಷಧಿ (ಔ-ಕಾರ ವೃದ್ಧಿ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s_7_kan_u11_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಹೊಂದಿಸಿ ಬರೆಯಿರಿ: ಶತ್ರು : ಮಿತ್ರ :: ರಾತ್ರಿ : ____",
            options = listOf("ಹಗಲು", "ಸಂಜೆ", "ಬೆಳಗ್ಗೆ", "ಮಧ್ಯಾಹ್ನ"),
            correctAnswer = "ಹಗಲು",
            explanation = "ರಾತ್ರಿಯ ವಿರುದ್ಧ ಪದ ಹಗಲು."
        ),
        QuestionModel(
            id = "s_7_kan_u11_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಹೊಂದಿಸಿ ಬರೆಯಿರಿ: ಮಾತಾ : ತಾಯಿ :: ಪಿತೃ : ____",
            options = listOf("ಅಣ್ಣ", "ತಂದೆ", "ತಮ್ಮ", "ಅಜ್ಜ"),
            correctAnswer = "ತಂದೆ",
            explanation = "ಪಿತೃ ಎಂದರೆ ತಂದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u11_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಹೊಂದಿಸಿ ಬರೆಯಿರಿ: ದಾವಣಗೆರೆ : ನಡುನಾಡು :: ಬೆಳಗಾವಿ : ____",
            options = listOf("ಕರಾವಳಿ", "ಗಡಿನಾಡು", "ಮಲೆನಾಡು", "ಬಯಲುನಾಡು"),
            correctAnswer = "ಗಡಿನಾಡು",
            explanation = "ಬೆಳಗಾವಿ ಕರ್ನಾಟಕದ ಗಡಿನಾಡು."
        ),
        QuestionModel(
            id = "s_7_kan_u11_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಹೊಂದಿಸಿ ಬರೆಯಿರಿ: ಅತ್ಯಂತ : ಯಣ್ ಸಂಧಿ :: ಚಿನ್ಮಯ : ____",
            options = listOf("ಲೋಪ ಸಂಧಿ", "ಗುಣ ಸಂಧಿ", "ಅನುನಾಸಿಕ ಸಂಧಿ", "ಸವರ್ಣದೀರ್ಘ ಸಂಧಿ"),
            correctAnswer = "ಅನುನಾಸಿಕ ಸಂಧಿ",
            explanation = "ಚಿತ್ + ಮಯ = ಚಿನ್ಮಯ (ಅನುನಾಸಿಕ ಸಂಧಿ)."
        ),
        QuestionModel(
            id = "s_7_kan_u11_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಹೊಂದಿಸಿ ಬರೆಯಿರಿ: 1956 : ಮೈಸೂರು ರಾಜ್ಯ :: 1973 : ____",
            options = listOf("ಕೇರಳ ರಾಜ್ಯ", "ಕರ್ನಾಟಕ", "ಆಂಧ್ರ ಪ್ರದೇಶ", "ತಮಿಳುನಾಡು"),
            correctAnswer = "ಕರ್ನಾಟಕ",
            explanation = "1973ರಲ್ಲಿ ಮೈಸೂರು ರಾಜ್ಯಕ್ಕೆ ‘ಕರ್ನಾಟಕ’ ಎಂದು ಮರುನಾಮಕರಣ ಮಾಡಲಾಯಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u11_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕನ್ನಡದ ಕಂಪನ್ನು ಸೂಸಲು ಕವಿ ಏನನ್ನು ಹಚ್ಚುತ್ತೇವೆ ಎಂದು ಹೇಳುತ್ತಾರೆ?",
            options = listOf("ದೀಪವನ್ನು", "ಮೇಣದ ಬತ್ತಿಯನ್ನು", "ಕರ್ಪೂರವನ್ನು", "ಧೂಪವನ್ನು"),
            correctAnswer = "ದೀಪವನ್ನು",
            explanation = "ಕನ್ನಡದ ಕಂಪು ಪಸರಿಸಲು ಕನ್ನಡದ ದೀಪವನ್ನು ಹಚ್ಚುತ್ತೇವೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u11_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕಲ್ಪನೆಯ ಕಣ್ಣು ಹರಿಯುವ ತನಕ ಯಾವುದನ್ನು ಹಚ್ಚುತ್ತೇವೆ?",
            options = listOf("ಮನೆ ದೀಪಗಳನ್ನು", "ಸಾಲು ದೀಪಗಳನ್ನು", "ಬೀದಿ ದೀಪಗಳನ್ನು", "ದೇವಾಲಯದ ದೀಪಗಳನ್ನು"),
            correctAnswer = "ಸಾಲು ದೀಪಗಳನ್ನು",
            explanation = "‘ಕಲ್ಪನೆಯ ಕಣ್ಣು ಹರಿಯುವ ತನಕ ಸಾಲು ದೀಪಗಳನ್ನು ಹಚ್ಚುತ್ತೇವೆ’."
        ),
        QuestionModel(
            id = "s_7_kan_u11_13",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ನಮ್ಮವರು ಗಳಿಸಿದ ಹೆಸರನ್ನು ಉಳಿಸಲು ನಾವೆಲ್ಲರೂ ಏನು ಮಾಡಬೇಕು?",
            options = listOf("ದೂರ ಹೋಗಬೇಕು", "ಒಂದಾಗಬೇಕು", "ಮೌನವಾಗಿರಬೇಕು", "ವಿಶ್ರಾಂತಿ ಪಡೆಯಬೇಕು"),
            correctAnswer = "ಒಂದಾಗಬೇಕು",
            explanation = "ಕನ್ನಡಿಗರೆಲ್ಲರೂ ಒಗ್ಗಟ್ಟಾಗಿ ಒಂದಾಗಬೇಕು."
        ),
        QuestionModel(
            id = "s_7_kan_u11_14",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "ನಮ್ಮ ಸಿರಿ ನೀಡುವ ಈ ನಾಡಿನಲ್ಲಿ ಯಾವ ಗೀತೆಯನ್ನು ಹಾಡುತ್ತೇವೆ?",
            options = listOf("ಜೋಗುಳ ಗೀತೆ", "ಮಂಗಳ ಗೀತೆ", "ಭಕ್ತಿಗೀತೆ", "ದೇಶಭಕ್ತಿಗೀತೆ"),
            correctAnswer = "ಮಂಗಳ ಗೀತೆ",
            explanation = "ಸಿರಿ ನೀಡುವ ಈ ಪಾವನ ನಾಡಿನಲ್ಲಿ ಮಂಗಳ ಗೀತೆಯನ್ನು ಹಾಡುತ್ತೇವೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u11_15",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಕರುಳೆಂಬ ಕುಡಿಗೆ’ ಏನನ್ನು ಮುಡಿಸುತ್ತೇವೆ?",
            options = listOf("ಹೂವನ್ನು", "ಮುತ್ತನ್ನು", "ಮಿಂಚನ್ನು", "ದೀಪವನ್ನು"),
            correctAnswer = "ಮಿಂಚನ್ನು",
            explanation = "‘ಕರುಳೆಂಬ ಕುಡಿಗೆ ಮಿಂಚನ್ನು ಮುಡಿಸುತ್ತೇವೆ’."
        ),
        QuestionModel(
            id = "s_7_kan_u11_16",
            stdId = 7,
            subjectId = "kannada",
            unitId = 11,
            type = "MCQ",
            questionText = "‘ಹಚ್ಚೇವು ಕನ್ನಡದ ದೀಪ’ ಕವಿತೆಯನ್ನು ಬರೆದ ಕವಿ ಯಾರು?",
            options = listOf("ಡಿ. ಎಸ್. ಕರ್ಕಿ", "ಕುವೆಂಪು", "ದ.ರಾ. ಬೇಂದ್ರೆ", "ಜಿ. ಎಸ್. ಶಿವರುದ್ರಪ್ಪ"),
            correctAnswer = "ಡಿ. ಎಸ್. ಕರ್ಕಿ",
            explanation = "‘ಹಚ್ಚೇವು ಕನ್ನಡದ ದೀಪ’ ಗೀತೆಯನ್ನು ರಚಿಸಿದವರು ಡಾ. ಡಿ. ಎಸ್. ಕರ್ಕಿ."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 12: ಬಿಡುಗಡೆಯ ಹಾಡು (Unit 12)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u12_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಸ್ವಾತಂತ್ರ್ಯ ಇಲ್ಲದ ಬದುಕು ಯಾವುದಕ್ಕೆ ಸಮಾನವಾದದ್ದು?",
            options = listOf("ಸ್ವರ್ಗಕ್ಕೆ", "ನರಕಕ್ಕೆ", "ಅರಮನೆಗೆ", "ನಂದನವನಕ್ಕೆ"),
            correctAnswer = "ನರಕಕ್ಕೆ",
            explanation = "ಪಾರತಂತ್ರ್ಯದ ಬಂಧನದ ಬದುಕು ನರಕಕ್ಕೆ ಸಮಾನ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಬಿಡುಗಡೆಯ ಹಾಡು’ ಪದ್ಯದ ರಚನಕಾರರು ಯಾರು?",
            options = listOf("ಕುವೆಂಪು", "ದ.ರಾ. ಬೇಂದ್ರೆ", "ಮುದುನೂರು ಸಂಗಣ್ಣ", "ಕಿಕ್ಕೇರಿ ಕೃಷ್ಣಮೂರ್ತಿ"),
            correctAnswer = "ಮುದುನೂರು ಸಂಗಣ್ಣ",
            explanation = "‘ಬಿಡುಗಡೆಯ ಹಾಡು’ ಪದ್ಯವನ್ನು ಮುದುನೂರು ಸಂಗಣ್ಣನವರು ರಚಿಸಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಮೃಗರಾಜ’ ಎಂದರೆ ಯಾರು?",
            options = listOf("ಆನೆ", "ಹುಲಿ", "ಸಿಂಹ", "ಕುದುರೆ"),
            correctAnswer = "ಸಿಂಹ",
            explanation = "ಕಾಡಿನ ರಾಜ ಅಥವಾ ಮೃಗರಾಜ ಎಂದರೆ ಸಿಂಹ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ನಮ್ಮ ರಾಷ್ಟ್ರಧ್ವಜದ ಮತ್ತೊಂದು ಹೆಸರು ಯಾವುದು?",
            options = listOf("ಪಂಚವರ್ಣ ಧ್ವಜ", "ತ್ರಿವರ್ಣ ಧ್ವಜ", "ವಿಜಯ ಧ್ವಜ", "ಶಾಂತಿ ಧ್ವಜ"),
            correctAnswer = "ತ್ರಿವರ್ಣ ಧ್ವಜ",
            explanation = "ಭಾರತದ ರಾಷ್ಟ್ರಧ್ವಜದಲ್ಲಿ ಮೂರು ಬಣ್ಣಗಳಿರುವುದರಿಂದ ಇದನ್ನು ತ್ರಿವರ್ಣ ಧ್ವಜ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ರೆಕ್ಕೆಗಳನ್ನು ಬಿಗಿಹಿಡಿದು ನರಳುತ್ತಿರುವುದು ಯಾವುದು?",
            options = listOf("ಸಿಂಹ", "ಕುದುರೆ", "ಹಕ್ಕಿ", "ಆನೆ"),
            correctAnswer = "ಹಕ್ಕಿ",
            explanation = "ಪಂಜರದಲ್ಲಿ ಬಂಧಿಯಾದ ಹಕ್ಕಿ ರೆಕ್ಕೆ ಬಿಗಿಹಿಡಿದು ನರಳುತ್ತಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಚಡಪಡಿಸುತ್ತಿದೆ’ ಎಂಬ ಪದಕ್ಕೆ ಹತ್ತಿರದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ಸಂತೋಷಪಡುತ್ತಿದೆ", "ಕಳವಳಪಡುತ್ತಿದೆ", "ವಿಶ್ರಾಂತಿ ಪಡೆಯುತ್ತಿದೆ", "ನಗುತ್ತಿದೆ"),
            correctAnswer = "ಕಳವಳಪಡುತ್ತಿದೆ",
            explanation = "‘ಚಡಪಡಿಸುವುದು’ ಎಂದರೆ ಆತಂಕ, ಕಳವಳ ಅಥವಾ ತೊಳಲಾಟ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಸೆರೆಮನೆಯಿಂದ ನಾವು ಹೇಗಿರಬೇಕು ಎಂದು ಪದ್ಯದಲ್ಲಿ ಹೇಳಲಾಗಿದೆ?",
            options = listOf("ಸೋತು", "ಹೆದರಿ", "ಜಿಗಿದು", "ಮರೆತು"),
            correctAnswer = "ಜಿಗಿದು",
            explanation = "ಸೆರೆಯಿಂದ ಜಿಗಿದು ಹೊರಬಂದು ಸ್ವತಂತ್ರರಾಗಬೇಕು."
        ),
        QuestionModel(
            id = "s_7_kan_u12_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಇನ್ನೆಲ್ಲ ನೀನೇಳು ______ ರಾಣಿ’ ಎಂಬ ಸಾಲಿನಲ್ಲಿ ಬರುವ ಪದ ಯಾವುದು?",
            options = listOf("ನಾಡಿನ", "ಕಡಲಗಳ", "ಅರಮನೆಯ", "ಮನೆಯ"),
            correctAnswer = "ಕಡಲಗಳ",
            explanation = "‘ಇನ್ನೆಲ್ಲ ನೀನೇಳು ಕಡಲಗಳ ರಾಣಿ’."
        ),
        QuestionModel(
            id = "s_7_kan_u12_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಹಾಡುವೆವು ಬಿಡುಗಡೆಯ ______ ಹಾಡು’ ಎಂಬ ಸಾಲಿನಲ್ಲಿ ಬರುವ ಪದ ಯಾವುದು?",
            options = listOf("ದೇಶಭಕ್ತಿಯ", "ಒಕ್ಕೊರಲ", "ಮದುವೆಯ", "ಪ್ರಕೃತಿಯ"),
            correctAnswer = "ಒಕ್ಕೊರಲ",
            explanation = "‘ಹಾಡುವೆವು ಬಿಡುಗಡೆಯ ಒಕ್ಕೊರಲ ಹಾಡು’."
        ),
        QuestionModel(
            id = "s_7_kan_u12_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ನಮ್ಮ ರಾಷ್ಟ್ರಪಿತ ಯಾರು?",
            options = listOf("ಜವಾಹರಲಾಲ್ ನೆಹರು", "ಸುಭಾಷ್ ಚಂದ್ರ ಬೋಸ್", "ಮಹಾತ್ಮ ಗಾಂಧೀಜಿ", "ಸರ್ದಾರ್ ವಲ್ಲಭಭಾಯಿ ಪಟೇಲ್"),
            correctAnswer = "ಮಹಾತ್ಮ ಗಾಂಧೀಜಿ",
            explanation = "ಮಹಾತ್ಮ ಗಾಂಧೀಜಿಯವರನ್ನು ಭಾರತದ ರಾಷ್ಟ್ರಪಿತ ಎಂದು ಗೌರವಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಪಕ್ಷಿಯು ಯಾವುದನ್ನು ಮುರಿದು ಹೊರಬರಬೇಕು?",
            options = listOf("ಗೂಡಿನ ಗೋಡೆ", "ಪಂಜರದ ಕದ", "ಮರದ ಕೊಂಬೆ", "ಮನೆಯ ಬಾಗಿಲು"),
            correctAnswer = "ಪಂಜರದ ಕದ",
            explanation = "ಬಂಧನದಲ್ಲಿರುವ ಪಕ್ಷಿಯು ಪಂಜರದ ಕದವನ್ನು ಮುರಿದು ಮುಕ್ತ ಆಕಾಶಕ್ಕೆ ಹಾರಬೇಕು."
        ),
        QuestionModel(
            id = "s_7_kan_u12_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಕಡಲಗಳ ರಾಣಿ’ ಎಂದರೆ ಯಾರು?",
            options = listOf("ಭಾರತ", "ಇಂಗ್ಲೆಂಡ್", "ಅಮೆರಿಕ", "ಜಪಾನ್"),
            correctAnswer = "ಇಂಗ್ಲೆಂಡ್",
            explanation = "ಬ್ರಿಟಿಷ್ ಸಾಮ್ರಾಜ್ಯವನ್ನು ಕಡಲಗಳ ರಾಣಿ (ಕ್ವೀನ್ ಆಫ್ ದಿ ಸೀಸ್) ಎನ್ನಲಾಗುತ್ತಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u12_13",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "‘ಸಿಡಿಲ ಮರಿಗಳು’ ಎಂದರೆ ಯಾರು?",
            options = listOf("ರೈತರು", "ಮಕ್ಕಳು", "ಸ್ವಾತಂತ್ರ್ಯಕ್ಕಾಗಿ ಹೋರಾಡಿದ ಹೋರಾಟಗಾರರು", "ಸೈನಿಕರ ಕುದುರೆಗಳು"),
            correctAnswer = "ಸ್ವಾತಂತ್ರ್ಯಕ್ಕಾಗಿ ಹೋರಾಡಿದ ಹೋರಾಟಗಾರರು",
            explanation = "ಸಿಡಿಲಂತೆ ಬ್ರಿಟಿಷರ ವಿರುದ್ಧ ಗುಡುಗಿದ ಸ್ವಾತಂತ್ರ್ಯ ಹೋರಾಟಗಾರರನ್ನು ಸಿಡಿಲ ಮರಿಗಳು ಎನ್ನಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_14",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ನಾವು ಯಾವ ಹಾಡನ್ನು ಹಾಡಬೇಕು ಎಂದು ಕವಿ ಬಯಸುತ್ತಾರೆ?",
            options = listOf("ಮದುವೆಯ ಹಾಡು", "ಬಿಡುಗಡೆಯ ಹಾಡು", "ಜೋಗುಳದ ಹಾಡು", "ಮಳೆಯ ಹಾಡು"),
            correctAnswer = "ಬಿಡುಗಡೆಯ ಹಾಡು",
            explanation = "ಪಾರತಂತ್ರ್ಯದಿಂದ ಮುಕ್ತಿ ಪಡೆದ ಬಿಡುಗಡೆಯ ಹಾಡನ್ನು ಹಾಡಬೇಕು."
        ),
        QuestionModel(
            id = "s_7_kan_u12_15",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಪಂಜರದ ಹಕ್ಕಿ ಯಾವುದರ ಸಂಕೇತವಾಗಿದೆ?",
            options = listOf("ಸ್ವತಂತ್ರವಾಗಿ ಬದುಕುವವರ", "ಬಂಧನದಲ್ಲಿರುವ ಭಾರತೀಯರ", "ರೈತರ", "ಮಕ್ಕಳ"),
            correctAnswer = "ಬಂಧನದಲ್ಲಿರುವ ಭಾರತೀಯರ",
            explanation = "ಬ್ರಿಟಿಷರ ಆಡಳಿತದಲ್ಲಿ ಗುಲಾಮಗಿರಿಯಲ್ಲಿದ್ದ ಭಾರತೀಯರ ಸಂಕೇತ ಪಂಜರದ ಹಕ್ಕಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_16",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಹಂಜನ ಅರಮನೆಯಲ್ಲಿ ಹಕ್ಕಿ ಹೇಗೆ ನರಳುತ್ತಿದೆ?",
            options = listOf("ರೆಕ್ಕೆಗಳನ್ನು ಬಿಚ್ಚಿ ಹಾರುತ್ತಿದೆ", "ರೆಕ್ಕೆಗಳನ್ನು ಬಿಗಿಹಿಡಿದು ನರಳುತ್ತಿದೆ", "ಗೂಡು ಕಟ್ಟುತ್ತಿದೆ", "ಹಾಡುತ್ತಿದೆ"),
            correctAnswer = "ರೆಕ್ಕೆಗಳನ್ನು ಬಿಗಿಹಿಡಿದು ನರಳುತ್ತಿದೆ",
            explanation = "ಹಕ್ಕಿಯು ರೆಕ್ಕೆಗಳನ್ನು ಬಿಗಿಹಿಡಿದು ನರಳುತ್ತಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_17",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಮೃಗರಾಜನು ಏನೆಂದು ಗುಣುಗುಟ್ಟುತ್ತಿದ್ದಾನೆ?",
            options = listOf("ಇನ್ನೂ ಈ ಬಂಧನ ಸಾಕು ಎಂದು", "ಇನ್ನೂ ಆಹಾರ ಬೇಕು ಎಂದು", "ಕಾಡಿಗೆ ಹೋಗಬೇಕು ಎಂದು", "ಮಲಗಬೇಕು ಎಂದು"),
            correctAnswer = "ಇನ್ನೂ ಈ ಬಂಧನ ಸಾಕು ಎಂದು",
            explanation = "ಮೃಗರಾಜನು ಇನ್ನೂ ಈ ಬಂಧನ ಸಾಕು ಎಂದು ಗುಣುಗುಟ್ಟುತ್ತಿದ್ದಾನೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_18",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ಕಾರಿರುಳು ತನ್ನ ಸೆರೆಒಳಗೆ ಯಾವುದನ್ನು ಅಡಗಿಸಿಟ್ಟಿದೆ?",
            options = listOf("ಚಂದ್ರಕಿರಣಗಳನ್ನು", "ರವಿಕಿರಣಗಳನ್ನು", "ನಕ್ಷತ್ರಗಳನ್ನು", "ಮಿಂಚನ್ನು"),
            correctAnswer = "ರವಿಕಿರಣಗಳನ್ನು",
            explanation = "ಕಾರಿರುಳು ತನ್ನ ಕತ್ತಲೆಯ ಸೆರೆಯೊಳಗೆ ಸೂರ್ಯನ (ರವಿ) ಕಿರಣಗಳನ್ನು ಅಡಗಿಸಿಟ್ಟಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u12_19",
            stdId = 7,
            subjectId = "kannada",
            unitId = 12,
            type = "MCQ",
            questionText = "ನಮ್ಮ ಬಾವುಟವು ಎಷ್ಟು ಬಣ್ಣಗಳನ್ನು ಹೊಂದಿದೆ?",
            options = listOf("ಎರಡು", "ಮೂರು", "ನಾಲ್ಕು", "ಐದು"),
            correctAnswer = "ಮೂರು",
            explanation = "ನಮ್ಮ ರಾಷ್ಟ್ರಧ್ವಜವು ಕೇಸರಿ, ಬಿಳಿ, ಹಸಿರು ಎಂಬ ಮೂರು ಪ್ರಮುಖ ಬಣ್ಣಗಳನ್ನು ಹೊಂದಿದೆ."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 13: ತಿರುಕನ ಕನಸು (Unit 13)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u13_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಪ್ರಬಂಧ ಬರೆಯುವ ಮೊದಲ ಹಂತ ಯಾವುದು?",
            options = listOf("ವಿಷಯದ ಮಂಡನೆ", "ವಿಷಯದ ಆಯ್ಕೆ", "ಪರಿಶೀಲನೆ", "ಮಾಹಿತಿ ಸಂಗ್ರಹಣೆ"),
            correctAnswer = "ವಿಷಯದ ಆಯ್ಕೆ",
            explanation = "ಪ್ರಬಂಧ ರಚನೆಯ ಮೊದಲ ಹಂತ ವಿಷಯದ ಆಯ್ಕೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ಶಾಂತಿ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಪ್ರೀತಿ", "ನೆಮ್ಮದಿ", "ಅಶಾಂತಿ", "ಸಂತೋಷ"),
            correctAnswer = "ಅಶಾಂತಿ",
            explanation = "ಶಾಂತಿ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಅಶಾಂತಿ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ರಾಜ’ ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ಪ್ರಜೆ", "ರಾಯ", "ಸೇವಕ", "ಸೈನಿಕ"),
            correctAnswer = "ರಾಯ",
            explanation = "ರಾಜ, ರಾಯ, ದೊರೆ, ಒಡೆಯ ಇವು ಸಮಾನಾರ್ಥಕ ಪದಗಳು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ಅಲ್ಪನಿಗೆ ಐಶ್ವರ್ಯ ಬಂದರೆ ______’ ಎಂಬ ಗಾದೆಯನ್ನು ಪೂರ್ಣಗೊಳಿಸಿ:",
            options = listOf("ಮನೆ ಬೆಳಗಿದಂತೆ", "ಅರ್ಧರಾತ್ರಿಯಲ್ಲಿ ಆನೆ ಹಿಡಿದಂತೆ", "ಹೂವು ಅರಳಿದಂತೆ", "ಮಳೆ ಬಂದಂತೆ"),
            correctAnswer = "ಅರ್ಧರಾತ್ರಿಯಲ್ಲಿ ಆನೆ ಹಿಡಿದಂತೆ",
            explanation = "ಅಲ್ಪನಿಗೆ ಐಶ್ವರ್ಯ ಬಂದರೆ ಅರ್ಧರಾತ್ರಿಯಲ್ಲಿ ಆನೆ ಹಿಡಿದಂತೆ (ಅಥವಾ ಛತ್ರಿ ಹಿಡಿದಂತೆ)."
        ),
        QuestionModel(
            id = "s_7_kan_u13_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ಅರಮನೆ, ಓಲಗ, ತಿರುಕ, ರಾಜ’ ಪದಗಳಲ್ಲಿ ಗುಂಪಿಗೆ ಸೇರದ ಪದ ಯಾವುದು?",
            options = listOf("ಅರಮನೆ", "ಓಲಗ", "ತಿರುಕ", "ರಾಜ"),
            correctAnswer = "ತಿರುಕ",
            explanation = "ಅರಮನೆ, ಓಲಗ, ರಾಜ ಇವು ರಾಜವೈಭವಕ್ಕೆ ಸಂಬಂಧಿಸಿದವು; ತಿರುಕ ಭಿಕ್ಷುಕ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ಹೆಂಗಸು’ ಪದದ ಬಹುವಚನ ರೂಪ ಯಾವುದು?",
            options = listOf("ಹೆಂಗಸನು", "ಹೆಂಗಸರು", "ಹೆಂಗಸಿಗೆ", "ಹೆಂಗಸಿನ"),
            correctAnswer = "ಹೆಂಗಸರು",
            explanation = "ಹೆಂಗಸು ಏಕವಚನ, ಹೆಂಗಸರು ಬಹುವಚನ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ತಿರುಕ ಹೆದರಿ ಕಣ್ಣು ತೆರೆದನು!’ ವಾಕ್ಯದಲ್ಲಿರುವ ಚಿಹ್ನೆ ಯಾವುದು?",
            options = listOf("ಅಲ್ಪವಿರಾಮ", "ಪೂರ್ಣವಿರಾಮ", "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ", "ಭಾವಸೂಚಕ ಚಿಹ್ನೆ"),
            correctAnswer = "ಭಾವಸೂಚಕ ಚಿಹ್ನೆ",
            explanation = "ಆಶ್ಚರ್ಯ ಮತ್ತು ಭಯದ ಭಾವನೆ ವ್ಯಕ್ತಪಡಿಸಲು ಭಾವಸೂಚಕ ಚಿಹ್ನೆ (!) ಬಳಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ತಿರುಕನು ಕನಸು ಕಂಡಿದ್ದು ಎಲ್ಲಿ?",
            options = listOf("ಅರಮನೆಯಲ್ಲಿ", "ರಸ್ತೆಯಲ್ಲಿ", "ಮುರುಕು ಧರ್ಮಶಾಲೆಯಲ್ಲಿ", "ಮಾಳಿಗೆಯಲ್ಲಿ"),
            correctAnswer = "ಮುರುಕು ಧರ್ಮಶಾಲೆಯಲ್ಲಿ",
            explanation = "ತಿರುಕನು ಮುರುಕು ಧರ್ಮಶಾಲೆಯ ಮೂಲೆಯಲ್ಲಿ ಮಲಗಿ ಕನಸು ಕಂಡನು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಪುರದ ರಾಜನಿಗೆ ಯಾರು ಇರಲಿಲ್ಲ?",
            options = listOf("ಮಂತ್ರಿಗಳು", "ವರಕುಮಾರರು", "ಕುಮಾರಿಯರು", "ಸೈನಿಕರು"),
            correctAnswer = "ವರಕುಮಾರರು",
            explanation = "ರಾಜನಿಗೆ ಗಂಡು ಸಂತಾನವಿಲ್ಲದೆ ವರಕುಮಾರರು ಇರಲಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಕುಸುಮಮಾಲೆಯನ್ನು ಯಾರ ಕೈಗೆ ಇಡುವರು?",
            options = listOf("ಸಿಂಹ", "ಆನೆ", "ಹುಲಿ", "ತಿರುಕ"),
            correctAnswer = "ಆನೆ",
            explanation = "ಪಟ್ಟದ ಆನೆಯ ಸೊಂಡಿಲಿಗೆ ಕುಸುಮಮಾಲೆಯನ್ನು ಇಡಲಾಗಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಆನೆಯು ಯಾರ ಕೊರಳಿಗೆ ಕುಸುಮಮಾಲೆ ಹಾಕಿತು?",
            options = listOf("ರಾಜನ", "ರಾಣಿಯ", "ತಿರುಕನ", "ಮಕ್ಕಳ"),
            correctAnswer = "ತಿರುಕನ",
            explanation = "ಆನೆಯು ಧರ್ಮಶಾಲೆಯಲ್ಲಿದ್ದ ತಿರುಕನ ಕೊರಳಿಗೆ ಕುಸುಮಮಾಲೆ ಹಾಕಿತು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ರಾಜ್ಯದ ಜೊತೆಗೆ ತಿರುಕನಿಗೆ ಏನನ್ನು ಕೊಟ್ಟರು?",
            options = listOf("ಹಣ್ಣುಗಳನ್ನು", "ಕನ್ಯೆಯರನ್ನು", "ರಥವನ್ನು", "ಪುಸ್ತಕಗಳನ್ನು"),
            correctAnswer = "ಕನ್ಯೆಯರನ್ನು",
            explanation = "ರಾಜ್ಯದ ಜೊತೆಗೆ ರಾಜಕುಮಾರಿಯರನ್ನು ವಿವಾಹ ಮಾಡಿಕೊಟ್ಟರು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_13",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ತಿರುಕ ರಾಜನ ಬಳಿ ಯಾವ ಬಲವಿತ್ತು?",
            options = listOf("ಗಜಬಲ", "ಅಶ್ವಬಲ", "ಚತುರಂಗಬಲ", "ನೌಕಾಬಲ"),
            correctAnswer = "ಚತುರಂಗಬಲ",
            explanation = "ಆನೆ, ಕುದುರೆ, ರಥ, ಪದಾತಿ ಸೈನ್ಯಗಳನ್ನೊಳಗೊಂಡ ಚತುರಂಗಬಲವಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_14",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ರಾಜನು ಸುತರಿಗೆ ಏನು ಮಾಡಲು ನಿಶ್ಚಯಿಸಿದನು?",
            options = listOf("ಯುದ್ಧ ಮಾಡಲು", "ಮದುವೆ ಮಾಡಲು", "ಪಟ್ಟ ಕಟ್ಟಲು", "ನಾಮಕರಣ ಮಾಡಲು"),
            correctAnswer = "ಮದುವೆ ಮಾಡಲು",
            explanation = "ರಾಜನು ತನ್ನ ಗಂಡು ಮಕ್ಕಳಿಗೆ (ಸುತರಿಗೆ) ಮದುವೆ ಮಾಡಲು ನಿಶ್ಚಯಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_15",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ತಿರುಕ ರಾಜನು ಕನಸಿನಿಂದ ಕಣ್ಣು ತೆರೆದದ್ದು ಏಕೆ?",
            options = listOf("ನಿದ್ರಾಭಂಗವಾದ್ದರಿಂದ", "ಮಂಚದಿಂದ ಬಿದ್ದುದರಿಂದ", "ರಾಜರ ದಂಡು ಮುತ್ತಿದುದರಿಂದ", "ರಾಣಿ ಎಬ್ಬಿಸಿದ್ದರಿಂದ"),
            correctAnswer = "ರಾಜರ ದಂಡು ಮುತ್ತಿದುದರಿಂದ",
            explanation = "ಯುದ್ಧದಲ್ಲಿ ಶತ್ರುರಾಜರ ಸೈನ್ಯ ಮುತ್ತಿಗೆ ಹಾಕಿದಾಗ ಭಯದಿಂದ ಕಣ್ಣು ತೆರೆದನು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_16",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಮುಪ್ಪಿನ ಷಡಕ್ಷರಿಯವರ ಊರು ಯಾವುದು?",
            options = listOf("ಮೈಸೂರು", "ಬಳ್ಳಾರಿ", "ಆಳ್ಲೇಗೋಳ", "ಧಾರವಾಡ"),
            correctAnswer = "ಆಳ್ಲೇಗೋಳ",
            explanation = "ಮುಪ್ಪಿನ ಷಡಕ್ಷರಿಯವರ ಊರು ಆಳ್ಲೇಗೋಳ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_17",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ಒಡೆಯ’ ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ದಾಸ", "ದೊರೆ", "ಸೇವಕ", "ಪ್ರಜೆ"),
            correctAnswer = "ದೊರೆ",
            explanation = "ಒಡೆಯ ಎಂದರೆ ದೊರೆ, ಒಡೆಯನ್, ಪ್ರಭು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_18",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ತಿರುಕನು ಎಲ್ಲಿ ಒರಗುತ್ತ ಕನಸು ಕಂಡನು?",
            options = listOf("ಅರಮನೆಯಲ್ಲಿ", "ಮುರುಕು ಧರ್ಮಶಾಲೆಯಲ್ಲಿ", "ಉದ್ಯಾನವನದಲ್ಲಿ", "ಶಾಲೆಯಲ್ಲಿ"),
            correctAnswer = "ಮುರುಕು ಧರ್ಮಶಾಲೆಯಲ್ಲಿ",
            explanation = "ಮುರುಕು ಧರ್ಮಶಾಲೆಯ ಒಂದು ಮೂಲೆಯಲ್ಲಿ ಒರಗಿ ಕನಸು ಕಂಡನು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_19",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಆನೆಯ ಕೈಯಲ್ಲಿ ಏನಿತ್ತು?",
            options = listOf("ಕತ್ತಿ", "ಕುಸುಮಮಾಲೆ", "ಧ್ವಜ", "ಕಿರೀಟ"),
            correctAnswer = "ಕುಸುಮಮಾಲೆ",
            explanation = "ಪಟ್ಟದ ಆನೆಯ ಸೊಂಡಿಲಿನಲ್ಲಿ ಹೂವಿನ ಮಾಲೆ (ಕುಸುಮಮಾಲೆ) ಇತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_20",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ಆನೆಯು ಯಾರ ಕೊರಳಿಗೆ ಮಾಲೆ ಹಾಕುತ್ತದೆಯೋ ಅವರೇ ______ ಆಗುತ್ತಾರೆ.",
            options = listOf("ಮಂತ್ರಿ", "ಸೈನಿಕ", "ಪುರದ ರಾಜ", "ವ್ಯಾಪಾರಿ"),
            correctAnswer = "ಪುರದ ರಾಜ",
            explanation = "ಪಟ್ಟದ ಆನೆ ಮಾಲೆ ಹಾಕಿದ ವ್ಯಕ್ತಿಯನ್ನೇ ಪುರದ ರಾಜನನ್ನಾಗಿ ಆಯ್ಕೆ ಮಾಡುವ ಪದ್ಧತಿಯಿತ್ತು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_21",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ತಿರುಕ ರಾಜನು ಯಾವ ರಾಜ್ಯವನ್ನು ಆಳುತ್ತಿದ್ದನು?",
            options = listOf("ಕನಸಿನಲ್ಲಿ ಕಂಡ ರಾಜ್ಯವನ್ನು", "ಮೈಸೂರು ರಾಜ್ಯವನ್ನು", "ವಿಜಯನಗರ ರಾಜ್ಯವನ್ನು", "ಬಳ್ಳಾರಿ ರಾಜ್ಯವನ್ನು"),
            correctAnswer = "ಕನಸಿನಲ್ಲಿ ಕಂಡ ರಾಜ್ಯವನ್ನು",
            explanation = "ತಿರುಕ ಆಳಿದ್ದು ತಾನು ನಿದ್ರೆಯಲ್ಲಿ ಕಂಡ ಭ್ರಾಮಕ ಕನಸಿನ ರಾಜ್ಯವನ್ನು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_22",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ಸುತ’ ಪದದ ಅರ್ಥ ಯಾವುದು?",
            options = listOf("ತಂದೆ", "ಮಗ", "ಸ್ನೇಹಿತ", "ಗುರು"),
            correctAnswer = "ಮಗ",
            explanation = "‘ಸುತ’ ಎಂದರೆ ಮಗ, ‘ಸುತೆ’ ಎಂದರೆ ಮಗಳು."
        ),
        QuestionModel(
            id = "s_7_kan_u13_23",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ಆಡೆ’ ಪದಕ್ಕೆ ಪಾಠದ ಉತ್ತರದ ಪ್ರಕಾರ ಯಾವ ಅರ್ಥಗಳಿವೆ?",
            options = listOf("ಗಾತ್ರ ಮತ್ತು ಕೊಡುವುದು", "ಓಡುವುದು ಮತ್ತು ನಿಲ್ಲುವುದು", "ಹಾಡುವುದು ಮತ್ತು ಕುಣಿಯುವುದು", "ನಗುವುದು ಮತ್ತು ಅಳುವುದು"),
            correctAnswer = "ಗಾತ್ರ ಮತ್ತು ಕೊಡುವುದು",
            explanation = "ಆಡೆ ಪದಕ್ಕೆ ಗಾತ್ರ ಮತ್ತು ಕೊಡುವುದು ಎಂಬ ನಾನಾರ್ಥಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_24",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ರಾಜ’ ಪದದ ತದ್ಭವ ರೂಪ ಯಾವುದು?",
            options = listOf("ಅರಮನೆ", "ರಾಯ", "ರಾಜ್ಯ", "ರಾಜನು"),
            correctAnswer = "ರಾಯ",
            explanation = "ರಾಜ ತತ್ಸಮ, ರಾಯ ತದ್ಭವ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_25",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "‘ಧರ್ಮ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?",
            options = listOf("ನ್ಯಾಯ", "ಸತ್ಯ", "ಅಧರ್ಮ", "ಶಾಂತಿ"),
            correctAnswer = "ಅಧರ್ಮ",
            explanation = "ಧರ್ಮ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಅಧರ್ಮ."
        ),
        QuestionModel(
            id = "s_7_kan_u13_26",
            stdId = 7,
            subjectId = "kannada",
            unitId = 13,
            type = "MCQ",
            questionText = "ತಿರುಕನ ಕನಸು ಪದ್ಯದ ಕವಿ ಯಾರು?",
            options = listOf("ಕುವೆಂಪು", "ಮುಪ್ಪಿನ ಷಡಕ್ಷರಿ", "ದ.ರಾ. ಬೇಂದ್ರೆ", "ಮುದುನೂರು ಸಂಗಣ್ಣ"),
            correctAnswer = "ಮುಪ್ಪಿನ ಷಡಕ್ಷರಿ",
            explanation = "‘ತಿರುಕನ ಕನಸು’ ಪದ್ಯವನ್ನು ಮುಪ್ಪಿನ ಷಡಕ್ಷರಿಯವರು ರಚಿಸಿದ್ದಾರೆ."
        ),

        // ========================================================
        // 🟦 ಅಧ್ಯಾಯ 14: ಅಭಿಮನ್ಯು ಪರಾಕ್ರಮ (Unit 14)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u14_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "‘ಆಹವ’ ಪದದ ಹೊಸಗನ್ನಡ ರೂಪ ಯಾವುದು?",
            options = listOf("ಜಗಳ", "ಯುದ್ಧ", "ಸೈನ್ಯ", "ಸೇನೆ"),
            correctAnswer = "ಯುದ್ಧ",
            explanation = "‘ಆಹವ’ ಎಂದರೆ ಸಮರ ಅಥವಾ ಯುದ್ಧ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "‘ಗದುಗಿನ ಕರ್ಣಪ್ಪ’ ಎಂದು ಕರೆಯಲಾಗುವ ಕವಿ ಯಾರು?",
            options = listOf("ರನ್ನ", "ಪಂಪ", "ಕುಮಾರವ್ಯಾಸ", "ಜನ್ನ"),
            correctAnswer = "ಕುಮಾರವ್ಯಾಸ",
            explanation = "ಕುಮಾರವ್ಯಾಸನ ಮೂಲ ಹೆಸರು ನಾರಾಯಣಪ್ಪ (ಗದುಗಿನ ನಾರಾಣಪ್ಪ / ಕರ್ಣಪ್ಪ)."
        ),
        QuestionModel(
            id = "s_7_kan_u14_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಅಭಿಮನ್ಯುವಿನ ಪರಾಕ್ರಮ ಕಾಣಸಿಗುವ ಯುದ್ಧ ಯಾವುದು?",
            options = listOf("ರಾಮಾಯಣ ಯುದ್ಧ", "ಕಳಿಂಗ ಯುದ್ಧ", "ಕುರುಕ್ಷೇತ್ರ ಯುದ್ಧ", "ಖಾಂಡವದಹನ ಯುದ್ಧ"),
            correctAnswer = "ಕುರುಕ್ಷೇತ್ರ ಯುದ್ಧ",
            explanation = "ಮಹಾಭಾರತದ ಕುರುಕ್ಷೇತ್ರ ಯುದ್ಧದ 13ನೇ ದಿನದಂದು ಅಭಿಮನ್ಯುವಿನ ಅದ್ಭುತ ಪರಾಕ್ರಮ ಕಂಡುಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಛಂದಸ್ಸಿನಲ್ಲಿ ಲಘುವನ್ನು ಗುರುತಿಸಲು ಬಳಸುವ ಚಿಹ್ನೆ ಯಾವುದು?",
            options = listOf("U", "C", "–", "೧"),
            correctAnswer = "U",
            explanation = "ಒಂದು ಮಾತ್ರೆಯ ಕಾಲದ ಲಘುವನ್ನು ‘U’ ಚಿಹ್ನೆಯಿಂದ ಗುರುತಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಛಂದಸ್ಸಿನಲ್ಲಿ ಎರಡು ಮಾತ್ರೆಗಳ ಕಾಲದ ಅಕ್ಷರವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಲಘು", "ಗುರು", "ಅಲ್ಪಪ್ರಾಣ", "ಮಹಾಪ್ರಾಣ"),
            correctAnswer = "ಗುರು",
            explanation = "ಎರಡು ಮಾತ್ರೆಗಳ ಕಾಲದಲ್ಲಿ ಉಚ್ಚರಿಸಲಾಗುವ ಅಕ್ಷರವನ್ನು ಗುರು (–) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಅಭಿಮನ್ಯು ಭೇದಿಸಬೇಕಾಗಿದ್ದ ವ್ಯೂಹ ಯಾವುದು?",
            options = listOf("ಚಕ್ರವ್ಯೂಹ", "ಗರುಡವ್ಯೂಹ", "ಮಕರವ್ಯೂಹ", "ಪದ್ಮವ್ಯೂಹ"),
            correctAnswer = "ಪದ್ಮವ್ಯೂಹ",
            explanation = "ದ್ರೋಣಾಚಾರ್ಯರು ರಚಿಸಿದ ಪದ್ಮವ್ಯೂಹ (ಚಕ್ರವ್ಯೂಹ)ವನ್ನು ಭೇದಿಸಲು ಹೊರಟನು."
        ),
        QuestionModel(
            id = "s_7_kan_u14_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "‘ಗದುಗಿನ ಭಾರತ’ ಎಂದು ಕರೆಯಲಾಗುವ ಕೃತಿ ಯಾವುದು?",
            options = listOf("ಕರ್ನಾಟಕ ಭಾರತ", "ಭಾರತ ಮಂಜರಿ", "ಕರ್ನಾಟಕ ಭಾರತ ಕಥೆ", "ಕರ್ನಾಟಕ ಭಾರತ ಕಥಾಮಂಜರಿ"),
            correctAnswer = "ಕರ್ನಾಟಕ ಭಾರತ ಕಥಾಮಂಜರಿ",
            explanation = "ಕುಮಾರವ್ಯಾಸನ ಕರ್ನಾಟಕ ಭಾರತ ಕಥಾಮಂಜರಿಗೆ ಗದುಗಿನ ಭಾರತ ಎಂಬ ಹೆಸರಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಅಭಿಮನ್ಯು ಯಾರ ಮಗ?",
            options = listOf("ಧರ್ಮರಾಯ", "ಅರ್ಜುನ", "ಭೀಮ", "ನಕುಲ"),
            correctAnswer = "ಅರ್ಜುನ",
            explanation = "ಅಭಿಮನ್ಯು ಅರ್ಜುನ ಮತ್ತು ಸುಭದ್ರೆಯರ ವೀರ ಪುತ್ರ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "‘ಅಭಿಮನ್ಯು ಪರಾಕ್ರಮ’ ಪದ್ಯದಿಂದ ನಾವು ಕಲಿಯಬೇಕಾದದ್ದು ಯಾವುದು?",
            options = listOf("ಕೋಪ ಮಾಡಿಕೊಳ್ಳಬೇಕು", "ಧೈರ್ಯ ಮತ್ತು ಕರ್ತವ್ಯ ಪಾಲಿಸಬೇಕು", "ಹಿರಿಯರ ಮಾತನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಕು", "ಬರಿಮಾತಿನಲ್ಲಿ ಹೊಗಳಿಕೊಳ್ಳಬೇಕು"),
            correctAnswer = "ಧೈರ್ಯ ಮತ್ತು ಕರ್ತವ್ಯ ಪಾಲಿಸಬೇಕು",
            explanation = "ಅಪ್ರತಿಮ ಸಾಹಸ, ಧೈರ್ಯ ಮತ್ತು ಕರ್ತವ್ಯ ನಿಷ್ಠೆಯನ್ನು ಕಲಿಯಬೇಕು."
        ),
        QuestionModel(
            id = "s_7_kan_u14_10",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಅಭಿಮನ್ಯು ಯಾರ ಬಳಿ ಯುದ್ಧಕ್ಕೆ ಹೋಗಲು ಅಪ್ಪಣೆ ಕೇಳುತ್ತಾನೆ?",
            options = listOf("ಕರ್ಣ", "ಧರ್ಮರಾಯ", "ದುರ್ಯೋಧನ", "ಅಶ್ವತ್ಥಾಮ"),
            correctAnswer = "ಧರ್ಮರಾಯ",
            explanation = "ದೊಡ್ಡಪ್ಪನಾದ ಧರ್ಮರಾಯನ (ಯುಧಿಷ್ಠಿರ) ಚರಣಗಳಿಗೆ ವಂದಿಸಿ ಅಪ್ಪಣೆ ಬೇಡುತ್ತಾನೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_11",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಅಭಿಮನ್ಯುವಿನ ತಾಯಿ ಯಾರು?",
            options = listOf("ದ್ರೌಪದಿ", "ಸುಭದ್ರೆ", "ಕುಂತಿ", "ಗಾಂಧಾರಿ"),
            correctAnswer = "ಸುಭದ್ರೆ",
            explanation = "ಅಭಿಮನ್ಯುವಿನ ತಾಯಿ ಶ್ರೀಕೃಷ್ಣನ ತಂಗಿಯಾದ ಸುಭದ್ರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_12",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಅಭಿಮನ್ಯುವಿನ ತಂದೆ ಯಾರು?",
            options = listOf("ಅರ್ಜುನ", "ಭೀಮ", "ಧರ್ಮರಾಯ", "ನಕುಲ"),
            correctAnswer = "ಅರ್ಜುನ",
            explanation = "ಅಭಿಮನ್ಯುವಿನ ಪಿತ ಅರ್ಜುನ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_13",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಅಭಿಮನ್ಯುವಿಗೆ ಪದ್ಮವ್ಯೂಹವನ್ನು ಭೇದಿಸಲು ಸಾಧ್ಯವೆಂದು ಹೇಳುತ್ತಾನೆ. ಅವನು ಯಾವುದಕ್ಕೆ ಸಿದ್ಧನಾಗಿದ್ದಾನೆ?",
            options = listOf("ಮದುವೆಗೆ", "ಯುದ್ಧಕ್ಕೆ", "ರಾಜ್ಯಾಭಿಷೇಕಕ್ಕೆ", "ವನವಾಸಕ್ಕೆ"),
            correctAnswer = "ಯುದ್ಧಕ್ಕೆ",
            explanation = "ಶತ್ರುಸೈನ್ಯದ ವ್ಯೂಹ ಭೇದಿಸಿ ಸಮರಗೈಯಲು ಸಿದ್ಧನಾಗಿದ್ದಾನೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_14",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "ಧರ್ಮರಾಯನು ಅಭಿಮನ್ಯುವನ್ನು ಯುದ್ಧಕ್ಕೆ ಕಳುಹಿಸುವ ಮೊದಲು ಏಕೆ ಚಿಂತಿಸುತ್ತಾನೆ?",
            options = listOf("ಅಭಿಮನ್ಯುವಿಗೆ ಯುದ್ಧದಲ್ಲಿ ಆಸಕ್ತಿ ಇಲ್ಲದ ಕಾರಣ", "ಶತ್ರುಸೈನ್ಯದಲ್ಲಿ ಬಲಿಷ್ಠ ಯೋಧರಿದ್ದ ಕಾರಣ", "ಸೈನ್ಯದಲ್ಲಿ ಕುದುರೆಗಳಿಲ್ಲದ ಕಾರಣ", "ಯುದ್ಧ ಮುಗಿದ ಕಾರಣ"),
            correctAnswer = "ಶತ್ರುಸೈನ್ಯದಲ್ಲಿ ಬಲಿಷ್ಠ ಯೋಧರಿದ್ದ ಕಾರಣ",
            explanation = "ದ್ರೋಣ, ಕರ್ಣ, ದುರ್ಯೋಧನರಂತಹ ಮಹಾರಥಿಗಳು ಎದುರಿರುವಾಗ ಎಳೆಯ ಬಾಲಕನೆಂದು ಧರ್ಮರಾಯ ಚಿಂತಿಸುತ್ತಾನೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u14_15",
            stdId = 7,
            subjectId = "kannada",
            unitId = 14,
            type = "MCQ",
            questionText = "‘ಲೆಪ್ಪದುರುಗನ ಹಿಡಿಯಲೇತಕೆ ಗರುಡಮಂತ್ರವು’ ಎಂಬ ರೂಪಕದ ಸಾರವೇನು?",
            options = listOf("ದುರ್ಬಲರನ್ನು ಹೆದರಿಸಬೇಕು", "ಜೀವವಿಲ್ಲದ ಹಾವನ್ನು ಹಿಡಿಯಲು ಗರುಡಮಂತ್ರದ ಅಗತ್ಯವಿಲ್ಲ", "ಯುದ್ಧಕ್ಕೆ ಸೈನ್ಯ ಬೇಕು", "ಗರುಡವು ಹಾವಿಗೆ ಹೆದರುತ್ತದೆ"),
            correctAnswer = "ಜೀವವಿಲ್ಲದ ಹಾವನ್ನು ಹಿಡಿಯಲು ಗರುಡಮಂತ್ರದ ಅಗತ್ಯವಿಲ್ಲ",
            explanation = "ಚಿತ್ರದ ಅಥವಾ ಮಣ್ಣಿನ ಹಾವನ್ನು ಹಿಡಿಯಲು ಮಹಾಮಂತ್ರವೇಕೆ ಎಂಬಂತೆ ಶತ್ರುಗಳನ್ನು ಲೀಲಾಜಾಲವಾಗಿ ಸದೆಬಡಿಯುವೆ ಎಂದರ್ಥ."
        ),

        // ========================================================
        // 🟦 ಘಟಕ 15: ಭಾಗ್ಯದ ಬಳೆಗಾರ (Unit 15)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u15_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "“ನವಿಲು ಸಾರಂಗ ______ ಬಳೆಗಾರ.” ಪದ್ಯದ ಸಾಲನ್ನು ಪೂರ್ಣಗೊಳಿಸಿ:",
            options = listOf("ನಲಿತಾವೆ", "ನಲಿಯುತ್ತವೆ", "ಹಾಡುತ್ತವೆ", "ಹಾರುತ್ತವೆ"),
            correctAnswer = "ನಲಿತಾವೆ",
            explanation = "“ನವಿಲು ಸಾರಂಗ ನಲಿತಾವೆ ಬಳೆಗಾರ” ಎಂಬುದು ಜನಪದ ಗೀತೆಯ ಸಾಲು."
        ),
        QuestionModel(
            id = "s_7_kan_u15_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "“ಮಿಂಚಾಡವೆರಡು ______ ಕಾಣೆ ಬಳೆಗಾರ.” ಸಾಲಿನಲ್ಲಿ ಬರುವ ಪದ ಯಾವುದು?",
            options = listOf("ಹಕ್ಕಿಗಳು", "ಕಣ್ಣು", "ಮುತ್ತು", "ಹೂವು"),
            correctAnswer = "ಕಣ್ಣು",
            explanation = "“ಮಿಂಚಾಡವೆರಡು ಕಣ್ಣು ಕಾಣೆ ಬಳೆಗಾರ”."
        ),
        QuestionModel(
            id = "s_7_kan_u15_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "“ನಟ್ಟ ನಡುವೇಲಿ ______ ಆಡುತ್ತಾಳೆ.” ಸಾಲಿನಲ್ಲಿ ಬರುವ ಪದ ಯಾವುದು?",
            options = listOf("ಬಾಲೆ", "ಮಗು", "ತಾಯಿ", "ಹಕ್ಕಿ"),
            correctAnswer = "ಬಾಲೆ",
            explanation = "“ನಟ್ಟ ನಡುವೇಲಿ ಬಾಲೆ ಆಡುತ್ತಾಳೆ”."
        ),
        QuestionModel(
            id = "s_7_kan_u15_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "“ಅಚ್ಚ ಕೆಂಪಿನ ಬಳೆ ______ ಜೋಡಿನ ಬಳೆ.” ಸಾಲಿನಲ್ಲಿ ಬರುವ ಪದ ಯಾವುದು?",
            options = listOf("ಹಸಿರಿನ", "ಬಿಳಿಯ", "ಕಪ್ಪಿನ", "ನೀಲಿಯ"),
            correctAnswer = "ಹಸಿರಿನ",
            explanation = "“ಅಚ್ಚ ಕೆಂಪಿನ ಬಳೆ ಹಸಿರಿನ ಜೋಡಿನ ಬಳೆ”."
        ),
        QuestionModel(
            id = "s_7_kan_u15_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "“ಹಂಚಿನ ಮನೆ ಕಾಣೆ ______ ಕದ ಕಾಣೆ.” ಸಾಲಿನಲ್ಲಿ ಬರುವ ಪದ ಯಾವುದು?",
            options = listOf("ಬೆಳ್ಳಿಯ", "ಬಂಗಾರದ", "ಕಂಚಿನ", "ಮರದ"),
            correctAnswer = "ಬಂಗಾರದ",
            explanation = "“ಹಂಚಿನ ಮನೆ ಕಾಣೆ ಬಂಗಾರದ ಕದ ಕಾಣೆ”."
        ),
        QuestionModel(
            id = "s_7_kan_u15_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "“ಮುತ್ತೈದೆ ಹಟ್ಟೀಲಿ ______ ಚಪ್ಪದ ಹಾಕಿ.” ಸಾಲಿನಲ್ಲಿ ಬರುವ ಪದ ಯಾವುದು?",
            options = listOf("ಬಳೆ", "ಮುತ್ತಿನ", "ಚಪ್ಪರ", "ಹೂವಿನ"),
            correctAnswer = "ಬಳೆ",
            explanation = "“ಮುತ್ತೈದೆ ಹಟ್ಟೀಲಿ ಬಳೆ ಚಪ್ಪದ ಹಾಕಿ”."
        ),
        QuestionModel(
            id = "s_7_kan_u15_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "“ಕೊಂಡೊಯ್ಯತ ಎನ್ನು ______.” ಸಾಲಿನಲ್ಲಿ ಬರುವ ಪದ ಯಾವುದು?",
            options = listOf("ತವರಿಗೆ", "ಊರಿಗೆ", "ಮನೆಗೆ", "ಶಾಲೆಗೆ"),
            correctAnswer = "ತವರಿಗೆ",
            explanation = "“ಕೊಂಡೊಯ್ಯತ ಎನ್ನು ತವರಿಗೆ”."
        ),
        QuestionModel(
            id = "s_7_kan_u15_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 15,
            type = "MCQ",
            questionText = "“ಅವಳ ಕಾಣೆ ಎನ್ನು ______.” ಸಾಲಿನಲ್ಲಿ ಬರುವ ಪದ ಯಾವುದು?",
            options = listOf("ತಾಯಿ", "ತವರು", "ಬಳೆ", "ಬಾಳೆ"),
            correctAnswer = "ತವರು",
            explanation = "“ಅವಳ ಕಾಣೆ ಎನ್ನು ತವರು”."
        ),

        // ========================================================
        // 🟦 ಘಟಕ 16: ವಚನಗಳ ಭಾವ ಸಂಗಮ (Unit 16)
        // ========================================================
        QuestionModel(
            id = "s_7_kan_u16_1",
            stdId = 7,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "“ಇರುಳೆಲ್ಲ ನಡೆದನಾ ಸುಂಕಕಂಜಿ” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿನ ‘ಸುಂಕ’ ಪದದ ಅರ್ಥವೇನು?",
            options = listOf("ದುಡ್ಡು", "ತೆರಿಗೆ", "ಮರ್ಯಾದೆ", "ದೇವರು"),
            correctAnswer = "ತೆರಿಗೆ",
            explanation = "‘ಸುಂಕ’ ಎಂದರೆ ಕಂದಾಯ ಅಥವಾ ತೆರಿಗೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u16_2",
            stdId = 7,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "‘ರಾಮನಾಥ’ ಎಂಬುದು ಯಾರ ವಚನಗಳ ಅಂಕಿತನಾಮ?",
            options = listOf("ಬಸವಣ್ಣ", "ಜೇಡರ ದಾಸಿಮಯ್ಯ", "ಸತ್ಯಕ್ಕ", "ಮಡಿವಾಳ ಮಾಚಯ್ಯ"),
            correctAnswer = "ಜೇಡರ ದಾಸಿಮಯ್ಯ",
            explanation = "ಆದ್ಯ ವಚನಕಾರ ಜೇಡರ ದಾಸಿಮಯ್ಯನವರ ಅಂಕಿತನಾಮ ‘ರಾಮನಾಥ’."
        ),
        QuestionModel(
            id = "s_7_kan_u16_3",
            stdId = 7,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "“ನುಡಿಯಲು ಬಾರದು ಕೆಟ್ಟ ನುಡಿಗಳ, ನಡೆಯಲು ಬಾರದು ಕೆಟ್ಟ ನಡೆಗಳ” ಎಂಬ ಮಾತನ್ನು ಹೇಳಿದವರು ಯಾರು?",
            options = listOf("ಮಡಿವಾಳ ಮಾಚಯ್ಯ", "ಜೇಡರ ದಾಸಿಮಯ್ಯ", "ಸತ್ಯಕ್ಕ", "ಮುಕ್ತಾಯಕ್ಕ"),
            correctAnswer = "ಮುಕ್ತಾಯಕ್ಕ",
            explanation = "ಶರಣೆ ಮುಕ್ತಾಯಕ್ಕನವರು ತಮ್ಮ ವಚನದಲ್ಲಿ ಈ ನೀತಿಯನ್ನು ಬೋಧಿಸಿದ್ದಾರೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u16_4",
            stdId = 7,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "“ಬಸವಣ್ಣನವರು ಕಾಯವೇ ಕೈಲಾಸ ಎಂದು ಹೇಳಿದರು” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿನ ಕ್ರಿಯಾಪದ ಯಾವುದು?",
            options = listOf("ಬಸವಣ್ಣನವರು", "ಕೈಲಾಸ", "ಎಂದು", "ಹೇಳಿದರು"),
            correctAnswer = "ಹೇಳಿದರು",
            explanation = "ವಾಕ್ಯದ ಕಾರ್ಯವನ್ನು ಪೂರ್ಣಗೊಳಿಸುವ ‘ಹೇಳಿದರು’ ಎಂಬುದು ಕ್ರಿಯಾಪದ."
        ),
        QuestionModel(
            id = "s_7_kan_u16_5",
            stdId = 7,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "“ರೈತರು ಕಾಳುಗಳನ್ನು ಬಿತ್ತಿದರು” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿನ ಕರ್ತೃಪದ ಯಾವುದು?",
            options = listOf("ರೈತರು", "ಕಾಳುಗಳನ್ನು", "ಬಿತ್ತಿದರು", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ರೈತರು",
            explanation = "ಕ್ರಿಯೆಯನ್ನು ಮಾಡುವವರು ‘ರೈತರು’ (ಕರ್ತೃಪದ)."
        ),
        QuestionModel(
            id = "s_7_kan_u16_6",
            stdId = 7,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "“ಶಿಕ್ಷಕರು ಪಾಠವನ್ನು ಓದಿದರು” ಎಂಬ ವಾಕ್ಯದಲ್ಲಿನ ಕರ್ಮಪದ ಯಾವುದು?",
            options = listOf("ಪಾಠವನ್ನು", "ಶಿಕ್ಷಕರು", "ಓದಿದರು", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "ಪಾಠವನ್ನು",
            explanation = "ಕ್ರಿಯೆಯ ಫಲವನ್ನು ಅನುಭವಿಸುವ ‘ಪಾಠವನ್ನು’ ಕರ್ಮಪದವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_7_kan_u16_7",
            stdId = 7,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ವಚನದ ಸಾಲು ಪೂರ್ಣಗೊಳಿಸಿ: “ಇರುಳೆಲ್ಲ ನಡೆದ ______.”",
            options = listOf("ಸುಂಕಕಂಜಿ", "ಅರಮನೆ", "ನಂದನವನ", "ಕೈಲಾಸ"),
            correctAnswer = "ಸುಂಕಕಂಜಿ",
            explanation = "“ಇರುಳೆಲ್ಲ ನಡೆದ ಸುಂಕಕಂಜಿ”."
        ),
        QuestionModel(
            id = "s_7_kan_u16_8",
            stdId = 7,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "ವಚನದ ಸಾಲು ಪೂರ್ಣಗೊಳಿಸಿ: “ನುಡಿಯಲು ಬಾರದು ಕೆಟ್ಟ ______.”",
            options = listOf("ನಡೆಗಳ", "ನುಡಿಗಳ", "ವಚನಗಳ", "ಕಾರ್ಯಗಳ"),
            correctAnswer = "ನುಡಿಗಳ",
            explanation = "“ನುಡಿಯಲು ಬಾರದು ಕೆಟ್ಟ ನುಡಿಗಳ”."
        ),
        QuestionModel(
            id = "s_7_kan_u16_9",
            stdId = 7,
            subjectId = "kannada",
            unitId = 16,
            type = "MCQ",
            questionText = "PDFಯ ಉತ್ತರ ಸೂಚಿಯ ಪ್ರಕಾರ “ಇಂತಲ್ಲದೆ ನಾನು ______.”",
            options = listOf("ಅಳಿಮನವ", "ಸುಂಕಕಂಜಿ", "ಕೈಲಾಸ", "ನಂದನವನ"),
            correctAnswer = "ಅಳಿಮನವ",
            explanation = "“ಇಂತಲ್ಲದೆ ನಾನು ಅಳಿಮನವ”."
        )
    )
}
