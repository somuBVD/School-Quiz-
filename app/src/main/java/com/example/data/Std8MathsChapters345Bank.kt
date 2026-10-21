package com.example.data

/**
 * Standard 8 Mathematics (ಗಣಿತ - Kannada Medium)
 * LBA Revised Question Bank • 2026–27
 * Chapters include:
 * 1. ವರ್ಗಸಂಖ್ಯೆ ಮತ್ತು ಘನಸಂಖ್ಯೆ
 * 2. ಘಾತಾಂಕಗಳ ಆಟ (ಘಾತಾಂಕ)
 * 3. ಸಂಖ್ಯೆಗಳ ಕಥೆ
 * 4. ಚತುರ್ಭುಜಗಳು
 * 5. ಸಂಖ್ಯೆಗಳ ಆಟ
 * 6. ನಾವು ವಿಭಜಿಸುತ್ತೇವೆ ಆದರೆ ಅವು ಗುಣಿಸಲ್ಪಡುತ್ತವೆ
 * 7. ಸಮಾನುಪಾತತೆಯ ತಾರ್ಕಿಕತೆ–1
 * 8. ವೇಷಧಾರಿ ಭಿನ್ನರಾಶಿಗಳು
 * 9. ಬೌಧಾಯನ–ಪೈಥಾಗರಸ್ ಪ್ರಮೇಯ
 * 10. ಸಮಾನುಪಾತತೆಯ ತಾರ್ಕಿಕತೆ–2
 * 11. ಕೆಲವು ಜ್ಯಾಮಿತೀಯ ವಿಷಯಗಳನ್ನು ಅನ್ವೇಷಿಸುವುದು
 * 12. ಚುಕ್ಕೆಗಳು ಮತ್ತು ರೇಖೆಗಳ ಮೂಲಕ ಕಥೆ
 * 13. ಬೀಜಗಣಿತ ಆಟ
 * 14. ವಿಸ್ತೀರ್ಣ
 */
object Std8MathsChapters345Bank {

    val chapter3Questions: List<QuestionModel> = listOf(
        // === ಅಧ್ಯಾಯ–3: ಸಂಖ್ಯೆಗಳ ಕಥೆ (ಮೂಲ MCQs & 1-ಅಂಕದ ಪರಿವರ್ತಿತ MCQs) ===
        QuestionModel(
            id = "s_8_mat_c3_1",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಭಾರತೀಯ 10 ಚಿಹ್ನೆಗಳ ವ್ಯವಸ್ಥೆಯೊಂದಿಗೆ ವೈಜ್ಞಾನಿಕ ಲೆಕ್ಕಾಚಾರಗಳನ್ನು ಸಂಪೂರ್ಣವಾಗಿ ವಿವರಿಸಿ ವಿಸ್ತರಿಸಿದ ಮೊದಲ ಗಣಿತಜ್ಞ ಯಾರು?",
            options = listOf("ಅಲ್-ಖ್ವಾರಿಜ್ಮಿ", "ಆರ್ಯಭಟ", "ಅಲ್-ಕಿಂಡಿ", "ಫಿಬೊನಾಚಿ"),
            correctAnswer = "ಅಲ್-ಖ್ವಾರಿಜ್ಮಿ",
            explanation = "ಅಲ್-ಖ್ವಾರಿಜ್ಮಿ ಭಾರತೀಯ 10 ಚಿಹ್ನೆಗಳ ವ್ಯವಸ್ಥೆಯೊಂದಿಗೆ ವೈಜ್ಞಾನಿಕ ಲೆಕ್ಕಾಚಾರಗಳನ್ನು ಸಂಪೂರ್ಣವಾಗಿ ವಿವರಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_8_mat_c3_2",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮಾಯನ್ನರು ಶೂನ್ಯಕ್ಕೆ placeholder ಆಗಿ ಬಳಸಿದ ಚಿಹ್ನೆ ಯಾವುದು?",
            options = listOf("ಚೌಕ", "ಬಾರ್", "ಸೀಶೆಲ್", "ವೃತ್ತ"),
            correctAnswer = "ಸೀಶೆಲ್",
            explanation = "ಮಾಯನ್ ಸಂಸ್ಕೃತಿಯಲ್ಲಿ ಶೂನ್ಯಕ್ಕೆ ಸೀಶೆಲ್ (ಕಪ್ಪೆಚಿಪ್ಪು) ಚಿಹ್ನೆಯನ್ನು ಬಳಸುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_8_mat_c3_3",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಬ್ರಹ್ಮಗುಪ್ತನು 628 CEನಲ್ಲಿ ರಚಿಸಿದ ಪ್ರಸಿದ್ಧ ಗಣಿತ ಕೃತಿ ಯಾವುದು?",
            options = listOf("ಬ್ರಹ್ಮ ಸ್ಫುಟ ಸಿದ್ಧಾಂತ", "ಆರ್ಯಭಟೀಯ ಸಿದ್ಧಾಂತ", "ಬ್ರಹ್ಮ ಸಿದ್ಧಾಂತ", "ದಶಮಾಂಶ ಸಿದ್ಧಾಂತ"),
            correctAnswer = "ಬ್ರಹ್ಮ ಸ್ಫುಟ ಸಿದ್ಧಾಂತ",
            explanation = "ಬ್ರಹ್ಮಗುಪ್ತನು 628 CEನಲ್ಲಿ 'ಬ್ರಹ್ಮ ಸ್ಫುಟ ಸಿದ್ಧಾಂತ'ವನ್ನು ರಚಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_8_mat_c3_4",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಈಜಿಪ್ಟಿನ ಸಂಖ್ಯಾ ಪದ್ಧತಿಯಲ್ಲಿ 231 ಅನ್ನು ಸೂಚಿಸುವ ಸರಿಯಾದ ಚಿತ್ರಲಿಪಿ ಸಂಕೇತ ರೂಪ ಯಾವುದು?",
            options = listOf("∩∩∩|", "99∩∩∩|", "∩∩|||", "9∩∩|"),
            correctAnswer = "99∩∩∩|",
            explanation = "ಈಜಿಪ್ಟ್ ಪದ್ಧತಿಯಲ್ಲಿ 100 ಕ್ಕೆ ಸುರುಳಿ (9 ರೂಪ), 10 ಕ್ಕೆ ಹಿಮ್ಮಡಿ (∩), 1 ಕ್ಕೆ ಗೆರೆ (|). ಹೀಗಾಗಿ 200 + 30 + 1 = 99∩∩∩|."
        ),
        QuestionModel(
            id = "s_8_mat_c3_5",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಶೂನ್ಯಕ್ಕೆ ಅಂಕಗಣಿತದ ನಿಯಮಗಳನ್ನು ಮೊದಲು ನಿರೂಪಿಸಿದ ಪ್ರಾಚೀನ ಭಾರತೀಯ ಗಣಿತಜ್ಞ ಯಾರು?",
            options = listOf("ಭಾಸ್ಕರಾಚಾರ್ಯ", "ಬ್ರಹ್ಮಗುಪ್ತ", "ವರಾಹಮಿಹಿರ", "ಆರ್ಯಭಟ"),
            correctAnswer = "ಬ್ರಹ್ಮಗುಪ್ತ",
            explanation = "ಬ್ರಹ್ಮಗುಪ್ತನು ಶೂನ್ಯದೊಂದಿಗೆ ಸಂಕಲನ, ವ್ಯವಕಲನ, ಗುಣಾಕಾರ ನಿಯಮಗಳನ್ನು ಮೊದಲ ಬಾರಿಗೆ ಕ್ರಮಬದ್ಧವಾಗಿ ನಿರೂಪಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_8_mat_c3_6",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಬ್ಯಾಬಿಲೋನಿಯನ್ನರ ಸಂಖ್ಯಾ ಪದ್ಧತಿಯು ಯಾವ ಆಧಾರ (base) ಸಂಖ್ಯಾ ಪದ್ಧತಿಯಾಗಿತ್ತು?",
            options = listOf("ಆಧಾರ 10", "ಆಧಾರ 20", "ಆಧಾರ 60", "ಆಧಾರ 12"),
            correctAnswer = "ಆಧಾರ 60",
            explanation = "ಬ್ಯಾಬಿಲೋನಿಯನ್ನರು sexagesimal (ಆಧಾರ 60) ಪದ್ಧತಿಯನ್ನು ಬಳಸುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_8_mat_c3_7",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ರೋಮನ್ ಸಂಖ್ಯಾ ಪದ್ಧತಿಯಲ್ಲಿ 'C' ಅಕ್ಷರವು ಯಾವ ಮೌಲ್ಯವನ್ನು ಪ್ರತಿನಿಧಿಸುತ್ತದೆ?",
            options = listOf("50", "100", "500", "1000"),
            correctAnswer = "100",
            explanation = "ರೋಮನ್ ಪದ್ಧತಿಯಲ್ಲಿ C ಎಂದರೆ 100 (Centum)."
        ),
        QuestionModel(
            id = "s_8_mat_c3_8",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ರೋಮನ್ ಸಂಖ್ಯಾ ಪದ್ಧತಿಯಲ್ಲಿ 'M' ಅಕ್ಷರವು ಯಾವ ಮೌಲ್ಯವನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("100", "500", "1000", "50"),
            correctAnswer = "1000",
            explanation = "ರೋಮನ್ ಪದ್ಧತಿಯಲ್ಲಿ M ಎಂದರೆ 1000 (Mille)."
        ),
        QuestionModel(
            id = "s_8_mat_c3_9",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕ್ರಿ.ಶ. 499 ರಲ್ಲಿ ಆರ್ಯಭಟನು ರಚಿಸಿದ ಪ್ರಸಿದ್ಧ ಗಣಿತ-ಖಗೋಳ ಕೃತಿ ಯಾವುದು?",
            options = listOf("ಆರ್ಯಭಟೀಯ", "ಸಿದ್ಧಾಂತ ಶಿರೋಮಣಿ", "ಲೀಲಾವತಿ", "ಬ್ರಹ್ಮಸ್ಫುಟ ಸಿದ್ಧಾಂತ"),
            correctAnswer = "ಆರ್ಯಭಟೀಯ",
            explanation = "ಆರ್ಯಭಟನು ಕ್ರಿ.ಶ. 499 ರಲ್ಲಿ 'ಆರ್ಯಭಟೀಯ' ಕೃತಿಯನ್ನು ರಚಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_8_mat_c3_10",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಹಿಂದೂ-ಅರೇಬಿಕ್ ಸಂಖ್ಯಾ ಪದ್ಧತಿಯನ್ನು ಯುರೋಪಿಗೆ ಪರಿಚಯಿಸಿದ ಗಣಿತಜ್ಞ ಯಾರು?",
            options = listOf("ಫಿಬೊನಾಚಿ", "ಯೂಕ್ಲಿಡ್", "ಪೈಥಾಗರಸ್", "ಡೆಕಾರ್ಟೆ"),
            correctAnswer = "ಫಿಬೊನಾಚಿ",
            explanation = "ಫಿಬೊನಾಚಿ (ಲಿಯೊನಾರ್ಡೊ ಪಿಸಾನೊ) ತನ್ನ 'Liber Abaci' (1202) ಕೃತಿಯ ಮೂಲಕ ಹಿಂದೂ-ಅರೇಬಿಕ್ ಪದ್ಧತಿಯನ್ನು ಯುರೋಪಿಗೆ ಜನಪ್ರಿಯಗೊಳಿಸಿದನು."
        ),
        QuestionModel(
            id = "s_8_mat_c3_11",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸ್ಥಾನಬೆಲೆ (Place value) ಪದ್ಧತಿಯನ್ನು ಮೊದಲು ವಿಶ್ವಕ್ಕೆ ಪರಿಚಯಿಸಿದ ಸಂಸ್ಕೃತಿ/ದೇಶ ಯಾವುದು?",
            options = listOf("ಭಾರತ", "ಗ್ರೀಸ್", "ಈಜಿಪ್ಟ್", "ರೋಮ್"),
            correctAnswer = "ಭಾರತ",
            explanation = "ದಶಮಾಂಶ ಸ್ಥಾನಬೆಲೆ ಪದ್ಧತಿಯು ಭಾರತೀಯ ಗಣಿತಜ್ಞರ ಮಹತ್ತರ ಕೊಡುಗೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c3_12",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಯಾವ ಪ್ರಾಚೀನ ಸಂಖ್ಯಾ ಪದ್ಧತಿಯಲ್ಲಿ ಶೂನ್ಯಕ್ಕೆ (Zero) ಯಾವುದೇ ಚಿಹ್ನೆ ಇರಲಿಲ್ಲ?",
            options = listOf("ರೋಮನ್ ಸಂಖ್ಯಾ ಪದ್ಧತಿ", "ಮಾಯನ್ ಪದ್ಧತಿ", "ಭಾರತೀಯ ಪದ್ಧತಿ", "ಬ್ಯಾಬಿಲೋನಿಯನ್ ಪದ್ಧತಿ"),
            correctAnswer = "ರೋಮನ್ ಸಂಖ್ಯಾ ಪದ್ಧತಿ",
            explanation = "ರೋಮನ್ ಸಂಖ್ಯಾ ಪದ್ಧತಿಯಲ್ಲಿ ಶೂನ್ಯಕ್ಕೆ ಯಾವುದೇ ಸಂಕೇತ ಅಥವಾ ಚಿಹ್ನೆ ಇರಲಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_8_mat_c3_13",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ರೋಮನ್ ಸಂಖ್ಯೆ 'XL' ನ ಹಿಂದೂ-ಅರೇಬಿಕ್ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("60", "40", "90", "50"),
            correctAnswer = "40",
            explanation = "L = 50, X = 10; ಸಣ್ಣ ಮೌಲ್ಯವು ಎಡಭಾಗದಲ್ಲಿರುವುದರಿಂದ 50 − 10 = 40."
        ),
        QuestionModel(
            id = "s_8_mat_c3_14",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ರೋಮನ್ ಸಂಖ್ಯೆ 'XC' ನ ಹಿಂದೂ-ಅರೇಬಿಕ್ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("110", "90", "80", "100"),
            correctAnswer = "90",
            explanation = "C = 100, X = 10; ಎಡಭಾಗದಲ್ಲಿ ಕಳೆಯುವುದರಿಂದ 100 − 10 = 90."
        ),
        QuestionModel(
            id = "s_8_mat_c3_15",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮಾಯನ್ನರ ಸಂಖ್ಯಾ ಪದ್ಧತಿಯಲ್ಲಿ ಸಂಖ್ಯೆಗಳ ಆಧಾರ (Base) ಎಷ್ಟಾಗಿತ್ತು?",
            options = listOf("10", "20", "60", "5"),
            correctAnswer = "20",
            explanation = "ಮಾಯನ್ನರು vigesimal (ಆಧಾರ 20) ಸಂಖ್ಯಾ ಪದ್ಧತಿಯನ್ನು ಬಳಸುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_8_mat_c3_16",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಪ್ರಾಚೀನ ಬಕ್ಷಾಲಿ ಹಸ್ತಪ್ರತಿಯಲ್ಲಿ ಶೂನ್ಯವನ್ನು ಸೂಚಿಸಲು ಬಳಸಲಾದ ಗುರುತು ಯಾವುದು?",
            options = listOf("ಒಂದು ಬಿಂದು (ಚುಕ್ಕೆ/Dot)", "ಒಂದು ವೃತ್ತ", "ಒಂದು ತ್ರಿಕೋನ", "ಒಂದು ಚೌಕ"),
            correctAnswer = "ಒಂದು ಬಿಂದು (ಚುಕ್ಕೆ/Dot)",
            explanation = "ಬಕ್ಷಾಲಿ ಹಸ್ತಪ್ರತಿಯಲ್ಲಿ ಶೂನ್ಯವನ್ನು ಒಂದು ಚುಕ್ಕೆ (Dot) ಯಿಂದ ಗುರುತಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c3_17",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ದಶಮಾಂಶ ಪದ್ಧತಿಯಲ್ಲಿ ಬಳಸುವ ಒಟ್ಟು ಮೂಲ ಅಂಕೆಗಳ (digits) ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("9", "10", "8", "12"),
            correctAnswer = "10",
            explanation = "ದಶಮಾಂಶ ಪದ್ಧತಿಯಲ್ಲಿ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ಎಂಬ 10 ಮೂಲ ಅಂಕೆಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c3_18",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಸಂಖ್ಯೆಯಲ್ಲಿ ಅಂಕೆಯು ಇರುವ ಸ್ಥಾನವನ್ನು ಅವಲಂಬಿಸಿ ಪಡೆಯುವ ಬೆಲೆ ಯಾವುದು?",
            options = listOf("ಸ್ಥಾನಬೆಲೆ (Place value)", "ಮುಖಬೆಲೆ (Face value)", "ಮೂಲಬೆಲೆ", "ವರ್ಗಬೆಲೆ"),
            correctAnswer = "ಸ್ಥಾನಬೆಲೆ (Place value)",
            explanation = "ಅಂಕೆಯ ಸ್ಥಾನವನ್ನು ಆಧರಿಸಿ ನಿರ್ಧಾರವಾಗುವ ಬೆಲೆಯನ್ನು ಸ್ಥಾನಬೆಲೆ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c3_19",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಯಾವುದೇ ಸಂಖ್ಯೆಯಲ್ಲಿ ಅಂಕೆಯ ಸ್ಥಾನವು ಏನೇ ಇದ್ದರೂ ಬದಲಾಗದ ಅದರ ನೈಜ ಮೌಲ್ಯ ಯಾವುದು?",
            options = listOf("ಮುಖಬೆಲೆ (Face value)", "ಸ್ಥಾನಬೆಲೆ", "ದಶಮಾಂಶ ಬೆಲೆ", "ಗುಣಕ ಬೆಲೆ"),
            correctAnswer = "ಮುಖಬೆಲೆ (Face value)",
            explanation = "ಅಂಕೆಯ ನೈಜ ಮೌಲ್ಯವೇ ಮುಖಬೆಲೆ (Face value), ಇದು ಸ್ಥಾನ ಬದಲಾದರೂ ಬದಲಾಗುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_8_mat_c3_20",
            stdId = 8,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಂಖ್ಯೆ 7482 ರಲ್ಲಿ '4' ರ ಸ್ಥಾನಬೆಲೆ ಮತ್ತು ಮುಖಬೆಲೆಯ ನಡುವಿನ ವ್ಯತ್ಯಾಸ ಎಷ್ಟು?",
            options = listOf("400", "396", "4", "390"),
            correctAnswer = "396",
            explanation = "4 ರ ಸ್ಥಾನಬೆಲೆ = 400, ಮುಖಬೆಲೆ = 4. ವ್ಯತ್ಯಾಸ = 400 − 4 = 396."
        )
    )

    val chapter4Questions: List<QuestionModel> = listOf(
        // === ಅಧ್ಯಾಯ–4: ಚತುರ್ಭುಜಗಳು (Consolidated MCQs) ===
        QuestionModel(
            id = "s_8_mat_c4_1",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಚತುರ್ಭುಜದ ಒಳಕೋನಗಳ ಒಟ್ಟು ಮೊತ್ತವು ಎಷ್ಟು?",
            options = listOf("180°", "270°", "360°", "540°"),
            correctAnswer = "360°",
            explanation = "ಯಾವುದೇ ಚತುರ್ಭುಜದ ನಾಲ್ಕು ಒಳಕೋನಗಳ ಮೊತ್ತವು ಯಾವಾಗಲೂ 360° ಆಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_2",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಮಾಂತರ ಚತುರ್ಭುಜದ ಅಭಿಮುಖ ಬಾಹುಗಳು ಮತ್ತು ಅಭಿಮುಖ ಕೋನಗಳು ಪರಸ್ಪರ —",
            options = listOf("ಸಮ", "ಅಸಮ", "ಲಂಬ", "ಪೂರಕ"),
            correctAnswer = "ಸಮ",
            explanation = "ಸಮಾಂತರ ಚತುರ್ಭುಜದಲ್ಲಿ ಅಭಿಮುಖ ಬಾಹುಗಳು ಮತ್ತು ಅಭಿಮುಖ ಕೋನಗಳು ಪರಸ್ಪರ ಸಮನಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_3",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ರಾಂಬಸ್‌ನ (ವಜ್ರಾಕೃತಿ) ಕರ್ಣಗಳು ಪರಸ್ಪರ ಹೇಗೆ ಛೇದಿಸುತ್ತವೆ?",
            options = listOf("ಲಂಬವಾಗಿ ಅರ್ಧಿಸುತ್ತವೆ", "ಕೇವಲ ಅರ್ಧಿಸುತ್ತವೆ", "ಸಮಕೋನದಲ್ಲಿರುವುದಿಲ್ಲ", "ಅಸಮವಾಗಿ ಛೇದಿಸುತ್ತವೆ"),
            correctAnswer = "ಲಂಬವಾಗಿ ಅರ್ಧಿಸುತ್ತವೆ",
            explanation = "ರಾಂಬಸ್‌ನ ಕರ್ಣಗಳು ಪರಸ್ಪರ ಲಂಬವಾಗಿ ಅರ್ಧಿಸುತ್ತವೆ (perpendicular bisectors)."
        ),
        QuestionModel(
            id = "s_8_mat_c4_4",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಯಾವುದೇ ಪೀನ ಬಹುಭುಜಾಕೃತಿಯ ಹೊರಕೋನಗಳ ಒಟ್ಟು ಮೊತ್ತವು —",
            options = listOf("180°", "360°", "540°", "720°"),
            correctAnswer = "360°",
            explanation = "ಯಾವುದೇ ಬಹುಭುಜಾಕೃತಿಯ ಎಲ್ಲಾ ಹೊರಕೋನಗಳ ಮೊತ್ತವು ಯಾವಾಗಲೂ 360° ಆಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_5",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಮಾಂತರ ಚತುರ್ಭುಜದ ಪಾರ್ಶ್ವ ಕೋನಗಳ ಮೊತ್ತ ಎಷ್ಟು?",
            options = listOf("90°", "180°", "270°", "360°"),
            correctAnswer = "180°",
            explanation = "ಸಮಾಂತರ ಚತುರ್ಭುಜದ ಅನುಕ್ರಮ ಪಾರ್ಶ್ವ ಕೋನಗಳು ಪರಸ್ಪರ ಪೂರಕ (180°) ಆಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_6",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಎಲ್ಲಾ ಬಾಹುಗಳು ಮತ್ತು ಎಲ್ಲಾ ಕೋನಗಳು ಸಮನಾಗಿರುವ ಚತುರ್ಭುಜ ಯಾವುದು?",
            options = listOf("ಆಯತ", "ರಾಂಬಸ್", "ಚೌಕ", "ತ್ರಾಪಿಜ್ಯ"),
            correctAnswer = "ಚೌಕ",
            explanation = "ಚೌಕದಲ್ಲಿ ನಾಲ್ಕೂ ಬಾಹುಗಳು ಸಮ ಹಾಗೂ ನಾಲ್ಕೂ ಕೋನಗಳು 90° ಸಮನಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_7",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಜೋಡಿ ಅಭಿಮುಖ ಬಾಹುಗಳು ಮಾತ್ರ ಸಮಾಂತರವಾಗಿರುವ ಚತುರ್ಭುಜ —",
            options = listOf("ತ್ರಾಪಿಜ್ಯ (Trapezium)", "ಸಮಾಂತರ ಚತುರ್ಭುಜ", "ರಾಂಬಸ್", "ಗಾಳಿಪಟ"),
            correctAnswer = "ತ್ರಾಪಿಜ್ಯ (Trapezium)",
            explanation = "ಕೇವಲ ಒಂದು ಜೋಡಿ ಅಭಿಮುಖ ಬಾಹುಗಳು ಸಮಾಂತರವಾಗಿದ್ದರೆ ಅದನ್ನು ತ್ರಾಪಿಜ್ಯ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_8",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ನಿಯಮಿತ ಷಡ್ಭುಜಾಕೃತಿಯ (regular hexagon) ಪ್ರತಿಯೊಂದು ಹೊರಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("45°", "60°", "72°", "90°"),
            correctAnswer = "60°",
            explanation = "ನಿಯಮಿತ ಷಡ್ಭುಜದ ಹೊರಕೋನ = 360° / 6 = 60°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_9",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ನಿಯಮಿತ ಅಷ್ಟಭುಜಾಕೃತಿಯ (regular octagon) ಪ್ರತಿಯೊಂದು ಹೊರಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("40°", "45°", "60°", "30°"),
            correctAnswer = "45°",
            explanation = "ನಿಯಮಿತ ಅಷ್ಟಭುಜದ ಹೊರಕೋನ = 360° / 8 = 45°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_10",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ನಿಯಮಿತ ಬಹುಭುಜಾಕೃತಿಯ ಪ್ರತಿಯೊಂದು ಹೊರಕೋನವು 24° ಆದರೆ, ಅದರ ಬಾಹುಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("12", "15", "18", "20"),
            correctAnswer = "15",
            explanation = "ಬಾಹುಗಳ ಸಂಖ್ಯೆ n = 360° / 24° = 15."
        ),
        QuestionModel(
            id = "s_8_mat_c4_11",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಚತುರ್ಭುಜದ ಮೂರು ಕೋನಗಳು 80°, 110°, ಮತ್ತು 70° ಆದರೆ ನಾಲ್ಕನೇ ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("100°", "90°", "120°", "80°"),
            correctAnswer = "100°",
            explanation = "ನಾಲ್ಕನೇ ಕೋನ = 360° − (80° + 110° + 70°) = 360° − 260° = 100°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_12",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಆಯತದ ಕರ್ಣಗಳ ಗುಣಲಕ್ಷಣ ಯಾವುದು?",
            options = listOf("ಪರಸ್ಪರ ಸಮ ಮತ್ತು ಅರ್ಧಿಸುತ್ತವೆ", "ಪರಸ್ಪರ ಲಂಬ", "ಅಸಮ", "ಲಂಬವಾಗಿರುವುದಿಲ್ಲ ಮತ್ತು ಸಮವಲ್ಲ"),
            correctAnswer = "ಪರಸ್ಪರ ಸಮ ಮತ್ತು ಅರ್ಧಿಸುತ್ತವೆ",
            explanation = "ಆಯತದ ಕರ್ಣಗಳು ಪರಸ್ಪರ ಸಮನಾಗಿರುತ್ತವೆ ಮತ್ತು ಪರಸ್ಪರ ಅರ್ಧಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_13",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗಾಳಿಪಟ (Kite) ಆಕೃತಿಯಲ್ಲಿ ಕರ್ಣಗಳು ಪರಸ್ಪರ ಹೇಗೆ ಛೇದಿಸುತ್ತವೆ?",
            options = listOf("ಲಂಬವಾಗಿರುತ್ತವೆ", "ಸಮನಾಗಿರುತ್ತವೆ", "ಸಮಾಂತರವಾಗಿರುತ್ತವೆ", "ಪೂರಕವಾಗಿರುತ್ತವೆ"),
            correctAnswer = "ಲಂಬವಾಗಿರುತ್ತವೆ",
            explanation = "ಗಾಳಿಪಟದಲ್ಲಿ ಕರ್ಣಗಳು ಪರಸ್ಪರ ಲಂಬವಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_14",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಸಮಾಂತರ ಚತುರ್ಭುಜದ ಒಂದು ಕೋನವು 70° ಆದರೆ ಅದರ ಅಭಿಮುಖ ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("110°", "70°", "140°", "20°"),
            correctAnswer = "70°",
            explanation = "ಸಮಾಂತರ ಚತುರ್ಭುಜದಲ್ಲಿ ಅಭಿಮುಖ ಕೋನಗಳು ಸಮವಾಗಿರುತ್ತವೆ, ಆದ್ದರಿಂದ ಅದು 70°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_15",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಸಮಾಂತರ ಚತುರ್ಭುಜದ ಒಂದು ಕೋನವು 70° ಆದರೆ ಅದರ ಪಾರ್ಶ್ವ ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("70°", "110°", "180°", "90°"),
            correctAnswer = "110°",
            explanation = "ಪಾರ್ಶ್ವ ಕೋನಗಳು ಪೂರಕ: 180° − 70° = 110°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_16",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "n ಬಾಹುಗಳನ್ನು ಹೊಂದಿರುವ ಬಹುಭುಜಾಕೃತಿಯ ಒಳಕೋನಗಳ ಮೊತ್ತದ ಸೂತ್ರ ಯಾವುದು?",
            options = listOf("(n − 2) × 180°", "(n + 2) × 180°", "n × 180°", "(n − 1) × 180°"),
            correctAnswer = "(n − 2) × 180°",
            explanation = "ಒಳಕೋನಗಳ ಮೊತ್ತ = (n − 2) × 180°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_17",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಪಂಚಭುಜಾಕೃತಿಯ (pentagon) ಎಲ್ಲಾ ಒಳಕೋನಗಳ ಒಟ್ಟು ಮೊತ್ತ ಎಷ್ಟು?",
            options = listOf("360°", "540°", "720°", "180°"),
            correctAnswer = "540°",
            explanation = "ಮೊತ್ತ = (5 − 2) × 180° = 3 × 180° = 540°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_18",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ನಿಯಮಿತ ಪಂಚಭುಜಾಕೃತಿಯ ಪ್ರತಿಯೊಂದು ಒಳಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("108°", "120°", "90°", "72°"),
            correctAnswer = "108°",
            explanation = "ಪ್ರತಿಯೊಂದು ಒಳಕೋನ = 540° / 5 = 108°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_19",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಮದ್ವಿಬಾಹು ತ್ರಾಪಿಜ್ಯದಲ್ಲಿ (Isosceles trapezium) ಯಾವ ಬಾಹುಗಳು ಸಮನಾಗಿರುತ್ತವೆ?",
            options = listOf("ಸಮಾಂತರವಲ್ಲದ ಬಾಹುಗಳು", "ಸಮಾಂತರ ಬಾಹುಗಳು", "ಎಲ್ಲಾ ಬಾಹುಗಳು", "ಕರ್ಣಗಳು ಮಾತ್ರ"),
            correctAnswer = "ಸಮಾಂತರವಲ್ಲದ ಬಾಹುಗಳು",
            explanation = "ಸಮದ್ವಿಬಾಹು ತ್ರಾಪಿಜ್ಯದಲ್ಲಿ ಸಮಾಂತರವಲ್ಲದ ಎರಡು ಬಾಹುಗಳು ಪರಸ್ಪರ ಸಮನಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_20",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಚತುರ್ಭುಜದ ಕೋನಗಳ ಅನುಪಾತವು 1:2:3:4 ಆದರೆ, ಅತ್ಯಂತ ದೊಡ್ಡ ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("36°", "72°", "108°", "144°"),
            correctAnswer = "144°",
            explanation = "1x + 2x + 3x + 4x = 10x = 360° => x = 36°. ದೊಡ್ಡ ಕೋನ = 4 × 36° = 144°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_21",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಚತುರ್ಭುಜದ ಕೋನಗಳ ಅನುಪಾತ 1:2:3:4 ಆದರೆ, ಅತ್ಯಂತ ಚಿಕ್ಕ ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("36°", "40°", "30°", "45°"),
            correctAnswer = "36°",
            explanation = "10x = 360° => x = 36°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_22",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕರ್ಣಗಳು ಪರಸ್ಪರ ಸಮನಾಗಿರುವ ಮತ್ತು ಪರಸ್ಪರ ಲಂಬವಾಗಿ ಅರ್ಧಿಸುವ ಚತುರ್ಭುಜ ಯಾವುದು?",
            options = listOf("ಚೌಕ", "ಆಯತ", "ರಾಂಬಸ್", "ತ್ರಾಪಿಜ್ಯ"),
            correctAnswer = "ಚೌಕ",
            explanation = "ಚೌಕದ ಕರ್ಣಗಳು ಪರಸ್ಪರ ಸಮನಾಗಿರುತ್ತವೆ ಮತ್ತು ಲಂಬವಾಗಿ ಅರ್ಧಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c4_23",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ನಿಯಮಿತ ಬಹುಭುಜಾಕೃತಿಯ ಕನಿಷ್ಠ ಒಳಕೋನದ ಅಳತೆ ಎಷ್ಟು ಸಾಧ್ಯ?",
            options = listOf("60°", "90°", "45°", "30°"),
            correctAnswer = "60°",
            explanation = "ಕನಿಷ್ಠ ಬಾಹುಗಳ ಬಹುಭುಜಾಕೃತಿ ಸಮಬಾಹು ತ್ರಿಕೋನ, ಅದರ ಪ್ರತಿಯೊಂದು ಒಳಕೋನ 60°."
        ),
        QuestionModel(
            id = "s_8_mat_c4_24",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ನಿಯಮಿತ ಬಹುಭುಜಾಕೃತಿಯ ಗರಿಷ್ಠ ಹೊರಕೋನದ ಅಳತೆ ಎಷ್ಟು ಸಾಧ್ಯ?",
            options = listOf("120°", "90°", "60°", "180°"),
            correctAnswer = "120°",
            explanation = "ಗರಿಷ್ಠ ಹೊರಕೋನ = 180° − 60° = 120° (ಸಮಬಾಹು ತ್ರಿಕೋನದಲ್ಲಿ)."
        ),
        QuestionModel(
            id = "s_8_mat_c4_25",
            stdId = 8,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಒಂದು ಚತುರ್ಭುಜವನ್ನು ರಚಿಸಲು ಕನಿಷ್ಠ ಎಷ್ಟು ಸ್ವತಂತ್ರ ಅಳತೆಗಳು ಅಗತ್ಯವಾಗಿವೆ?",
            options = listOf("3", "4", "5", "6"),
            correctAnswer = "5",
            explanation = "ಒಂದು ನಿರ್ದಿಷ್ಟ ಚತುರ್ಭುಜವನ್ನು ನಿಖರವಾಗಿ ರಚಿಸಲು ಕನಿಷ್ಠ 5 ಸ್ವತಂತ್ರ ಅಳತೆಗಳು ಬೇಕು."
        )
    )

    val chapter5Questions: List<QuestionModel> = listOf(
        // === ಅಧ್ಯಾಯ–5: ಸಂಖ್ಯೆಗಳ ಆಟ (Consolidated MCQs) ===
        QuestionModel(
            id = "s_8_mat_c5_1",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಎರಡಂಕಿಯ ಸಂಖ್ಯೆ 'ab' ಯ ಸಾಮಾನ್ಯ ವಿಸ್ತೃತ ರೂಪ ಯಾವುದು?",
            options = listOf("10a + b", "a + 10b", "a + b", "100a + b"),
            correctAnswer = "10a + b",
            explanation = "ab = 10 × a + b (a ಹತ್ತರ ಸ್ಥಾನದಲ್ಲಿದೆ, b ಬಿಡಿ ಸ್ಥಾನದಲ್ಲಿದೆ)."
        ),
        QuestionModel(
            id = "s_8_mat_c5_2",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮೂರಂಕಿಯ ಸಂಖ್ಯೆ 'abc' ಯ ಸಾಮಾನ್ಯ ವಿಸ್ತೃತ ರೂಪ ಯಾವುದು?",
            options = listOf("100a + 10b + c", "10a + b + c", "a + b + c", "1000a + 10b + c"),
            correctAnswer = "100a + 10b + c",
            explanation = "abc ಸಂಖ್ಯೆಯ ವಿಸ್ತೃತ ರೂಪ = 100a + 10b + c."
        ),
        QuestionModel(
            id = "s_8_mat_c5_3",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಸಂಖ್ಯೆಯು 9 ರಿಂದ ಸಂಪೂರ್ಣವಾಗಿ ಭಾಗವಾಗಬೇಕಾದರೆ —",
            options = listOf("ಅಂಕೆಗಳ ಮೊತ್ತ 9 ರಿಂದ ಭಾಗವಾಗಬೇಕು", "ಕೊನೆಯ ಅಂಕೆ 9 ಆಗಿರಬೇಕು", "ಸಂಖ್ಯೆಯು ಬೆಸವಾಗಿರಬೇಕು", "ಕೊನೆಯ ಅಂಕೆ 0 ಆಗಿರಬೇಕು"),
            correctAnswer = "ಅಂಕೆಗಳ ಮೊತ್ತ 9 ರಿಂದ ಭಾಗವಾಗಬೇಕು",
            explanation = "ಸಂಖ್ಯೆಯ ಎಲ್ಲಾ ಅಂಕೆಗಳ ಮೊತ್ತವು 9 ರ ಅಪವರ್ತ್ಯವಾಗಿದ್ದರೆ ಆ ಸಂಖ್ಯೆ 9 ರಿಂದ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_4",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಸಂಖ್ಯೆಯು 3 ರಿಂದ ಸಂಪೂರ್ಣವಾಗಿ ಭಾಗವಾಗಬೇಕಾದರೆ —",
            options = listOf("ಅಂಕೆಗಳ ಮೊತ್ತ 3 ರಿಂದ ಭಾಗವಾಗಬೇಕು", "ಕೊನೆಯ ಅಂಕೆ 3 ಆಗಿರಬೇಕು", "ಸಂಖ್ಯೆಯು ಸಮವಾಗಿರಬೇಕು", "ಕೊನೆಯ ಅಂಕೆ ಬೆಸವಾಗಿರಬೇಕು"),
            correctAnswer = "ಅಂಕೆಗಳ ಮೊತ್ತ 3 ರಿಂದ ಭಾಗವಾಗಬೇಕು",
            explanation = "ಸಂಖ್ಯೆಯ ಅಂಕೆಗಳ ಮೊತ್ತವು 3 ರಿಂದ ಭಾಗವಾದರೆ, ಆ ಇಡೀ ಸಂಖ್ಯೆಯು 3 ರಿಂದ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_5",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "21y5 ಎಂಬ ಸಂಖ್ಯೆಯು 9 ರ ಅಪವರ್ತ್ಯವಾಗಿದ್ದರೆ, 'y' ಅಂಕೆಯ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("1", "2", "3", "0"),
            correctAnswer = "1",
            explanation = "2 + 1 + y + 5 = 8 + y; 9 ರ ಅಪವರ್ತ್ಯವಾಗಲು 8 + 1 = 9, ಆದ್ದರಿಂದ y = 1."
        ),
        QuestionModel(
            id = "s_8_mat_c5_6",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "31z5 ಎಂಬ ಸಂಖ್ಯೆಯು 9 ರ ಅಪವರ್ತ್ಯವಾಗಿದ್ದರೆ, 'z' ಅಂಕೆಯ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("0", "9", "0 ಅಥವಾ 9", "2"),
            correctAnswer = "0 ಅಥವಾ 9",
            explanation = "3 + 1 + z + 5 = 9 + z; z = 0 ಆದಾಗ ಮೊತ್ತ 9, z = 9 ಆದಾಗ ಮೊತ್ತ 18. ಆದ್ದರಿಂದ z = 0 ಅಥವಾ 9."
        ),
        QuestionModel(
            id = "s_8_mat_c5_7",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "24x ಎಂಬ ಸಂಖ್ಯೆಯು 3 ರ ಅಪವರ್ತ್ಯವಾಗಿದ್ದರೆ, 'x' ನ ಕನಿಷ್ಠ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("0", "1", "2", "3"),
            correctAnswer = "0",
            explanation = "2 + 4 + x = 6 + x; 6 ಈಗಾಗಲೇ 3 ರಿಂದ ಭಾಗವಾಗುವುದರಿಂದ x ನ ಕನಿಷ್ಠ ಮೌಲ್ಯ 0."
        ),
        QuestionModel(
            id = "s_8_mat_c5_8",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಸಂಖ್ಯೆಯು 5 ರಿಂದ ಭಾಗವಾಗಬೇಕಾದರೆ ಅದರ ಬಿಡಿ ಸ್ಥಾನದಲ್ಲಿರಬೇಕಾದ ಅಂಕೆಗಳು ಯಾವುವು?",
            options = listOf("0 ಅಥವಾ 5", "ಕೇವಲ 5", "ಕೇವಲ 0", "2 ಅಥವಾ 5"),
            correctAnswer = "0 ಅಥವಾ 5",
            explanation = "ಬಿಡಿ ಸ್ಥಾನದಲ್ಲಿ 0 ಅಥವಾ 5 ಇದ್ದರೆ ಆ ಸಂಖ್ಯೆ 5 ರಿಂದ ನಿಶ್ಶೇಷವಾಗಿ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_9",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಸಂಖ್ಯೆಯು 10 ರಿಂದ ಭಾಗವಾಗಬೇಕಾದರೆ ಅದರ ಬಿಡಿ ಸ್ಥಾನದ ಅಂಕೆ ಯಾವುದಾಗಿರಬೇಕು?",
            options = listOf("0", "5", "1", "ಯಾವುದೇ ಸಮ ಸಂಖ್ಯೆ"),
            correctAnswer = "0",
            explanation = "ಬಿಡಿ ಸ್ಥಾನದಲ್ಲಿ 0 ಇದ್ದರೆ ಮಾತ್ರ ಆ ಸಂಖ್ಯೆಯು 10 ರಿಂದ ನಿಶ್ಶೇಷವಾಗಿ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_10",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಎರಡಂಕಿಯ ಸಂಖ್ಯೆ 'ab' ಮತ್ತು ಅದರ ಅಂಕೆಗಳನ್ನು ಅದಲು-ಬದಲು ಮಾಡಿದಾಗ ದೊರೆಯುವ ಸಂಖ್ಯೆ 'ba' ಗಳ ಮೊತ್ತವು (ab + ba) ಯಾವಾಗಲೂ ಯಾವ ಸಂಖ್ಯೆಯಿಂದ ಭಾಗವಾಗುತ್ತದೆ?",
            options = listOf("11", "9", "7", "5"),
            correctAnswer = "11",
            explanation = "(10a + b) + (10b + a) = 11a + 11b = 11(a + b). ಇದು ಯಾವಾಗಲೂ 11 ರಿಂದ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_11",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಎರಡಂಕಿಯ ಸಂಖ್ಯೆ 'ab' (a > b) ಮತ್ತು ಅದರ ಅಂಕೆಗಳನ್ನು ಅದಲು-ಬದಲು ಮಾಡಿದ ಸಂಖ್ಯೆ 'ba' ಗಳ ವ್ಯತ್ಯಾಸವು (ab − ba) ಯಾವಾಗಲೂ ಯಾವ ಸಂಖ್ಯೆಯಿಂದ ಭಾಗವಾಗುತ್ತದೆ?",
            options = listOf("9", "11", "10", "3"),
            correctAnswer = "9",
            explanation = "(10a + b) − (10b + a) = 9a − 9b = 9(a − b). ಇದು ಯಾವಾಗಲೂ 9 ರಿಂದ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_12",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮೂರಂಕಿಯ ಸಂಖ್ಯೆ abc ಮತ್ತು cba ಗಳ ವ್ಯತ್ಯಾಸವು (a > c) ಯಾವಾಗಲೂ ಯಾವ ಸಂಖ್ಯೆಯಿಂದ ಭಾಗವಾಗುತ್ತದೆ?",
            options = listOf("99", "11", "9", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
            correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
            explanation = "(100a + 10b + c) − (100c + 10b + a) = 99(a − c). ಇದು 99, 9 ಮತ್ತು 11 ಎಲ್ಲದರಿಂದಲೂ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_13",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಸಂಕಲನದಲ್ಲಿ: 3A + 25 = B2 ಆದರೆ, A ಮತ್ತು B ಗಳ ಬೆಲೆಗಳು ಕ್ರಮವಾಗಿ —",
            options = listOf("A = 7, B = 6", "A = 2, B = 5", "A = 7, B = 5", "A = 8, B = 6"),
            correctAnswer = "A = 7, B = 6",
            explanation = "A + 5 = 12 => A = 7; 1 ದಶಕ + 3 + 2 = 6 = B. ಆದ್ದರಿಂದ A = 7, B = 6."
        ),
        QuestionModel(
            id = "s_8_mat_c5_14",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "4A + 98 = CB3 ಆದರೆ, A, B, C ಗಳ ಬೆಲೆಗಳು ಕ್ರಮವಾಗಿ —",
            options = listOf("A = 5, B = 4, C = 1", "A = 5, B = 3, C = 1", "A = 4, B = 5, C = 1", "A = 6, B = 4, C = 1"),
            correctAnswer = "A = 5, B = 4, C = 1",
            explanation = "A + 8 = 13 => A = 5; 1 ದಶಕ + 4 + 9 = 14 => B = 4, C = 1."
        ),
        QuestionModel(
            id = "s_8_mat_c5_15",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಗುಣಾಕಾರದಲ್ಲಿ: 1A × A = 9A ಆದರೆ 'A' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("6", "5", "1", "9"),
            correctAnswer = "6",
            explanation = "16 × 6 = 96. ಆದ್ದರಿಂದ A = 6."
        ),
        QuestionModel(
            id = "s_8_mat_c5_16",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "AB × 3 = CAB ಆದರೆ, A ಮತ್ತು B ಗಳ ಬೆಲೆಗಳು ಕ್ರಮವಾಗಿ —",
            options = listOf("A = 5, B = 0", "A = 2, B = 5", "A = 5, B = 5", "A = 0, B = 5"),
            correctAnswer = "A = 5, B = 0",
            explanation = "50 × 3 = 150 (ಇಲ್ಲಿ A = 5, B = 0, C = 1)."
        ),
        QuestionModel(
            id = "s_8_mat_c5_17",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಸಂಖ್ಯೆಯು 2 ರಿಂದ ಸಂಪೂರ್ಣವಾಗಿ ಭಾಗವಾಗಬೇಕಾದರೆ ಅದರ ಬಿಡಿ ಅಂಕೆ ಯಾವುದಾಗಿರಬೇಕು?",
            options = listOf("ಸಮ ಸಂಖ್ಯೆ (0, 2, 4, 6, 8)", "ಬೆಸ ಸಂಖ್ಯೆ", "ಕೇವಲ 0", "ಕೇವಲ 2"),
            correctAnswer = "ಸಮ ಸಂಖ್ಯೆ (0, 2, 4, 6, 8)",
            explanation = "ಬಿಡಿ ಸ್ಥಾನದಲ್ಲಿ 0, 2, 4, 6, 8 ಇದ್ದರೆ ಆ ಸಂಖ್ಯೆ 2 ರಿಂದ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_18",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಸಂಖ್ಯೆಯು 4 ರಿಂದ ಭಾಗವಾಗಬೇಕಾದರೆ ಇರಬೇಕಾದ ನಿಯಮ ಯಾವುದು?",
            options = listOf("ಕೊನೆಯ ಎರಡು ಅಂಕೆಗಳಿಂದಾದ ಸಂಖ್ಯೆ 4 ರಿಂದ ಭಾಗವಾಗಬೇಕು", "ಕೊನೆಯ ಅಂಕೆ 4 ಆಗಿರಬೇಕು", "ಅಂಕೆಗಳ ಮೊತ್ತ 4 ರಿಂದ ಭಾಗವಾಗಬೇಕು", "ಕೊನೆಯ ಮೂರು ಅಂಕೆಗಳು ಸಮವಾಗಿರಬೇಕು"),
            correctAnswer = "ಕೊನೆಯ ಎರಡು ಅಂಕೆಗಳಿಂದಾದ ಸಂಖ್ಯೆ 4 ರಿಂದ ಭಾಗವಾಗಬೇಕು",
            explanation = "ಕೊನೆಯ ಎರಡು ಅಂಕೆಗಳು (ಹತ್ತು ಮತ್ತು ಬಿಡಿ) 4 ರಿಂದ ಭಾಗವಾದರೆ ಅಥವಾ '00' ಆಗಿದ್ದರೆ ಆ ಸಂಖ್ಯೆ 4 ರಿಂದ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_19",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಸಂಖ್ಯೆಯು 8 ರಿಂದ ಭಾಗವಾಗಬೇಕಾದರೆ ಪರಿಶೀಲಿಸಬೇಕಾದ ನಿಯಮ ಯಾವುದು?",
            options = listOf("ಕೊನೆಯ ಮೂರು ಅಂಕೆಗಳಿಂದಾದ ಸಂಖ್ಯೆ 8 ರಿಂದ ಭಾಗವಾಗಬೇಕು", "ಕೊನೆಯ ಅಂಕೆ 8 ಆಗಿರಬೇಕು", "ಅಂಕೆಗಳ ಮೊತ್ತ 8 ಆಗಿರಬೇಕು", "ಕೊನೆಯ ಎರಡು ಅಂಕೆಗಳು 8 ಆಗಿರಬೇಕು"),
            correctAnswer = "ಕೊನೆಯ ಮೂರು ಅಂಕೆಗಳಿಂದಾದ ಸಂಖ್ಯೆ 8 ರಿಂದ ಭಾಗವಾಗಬೇಕು",
            explanation = "ಕೊನೆಯ ಮೂರು ಅಂಕೆಗಳಿಂದ ಉಂಟಾದ ಸಂಖ್ಯೆ 8 ರಿಂದ ಭಾಗವಾದರೆ ಆ ಸಂಖ್ಯೆ 8 ರಿಂದ ಭಾಗವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_8_mat_c5_20",
            stdId = 8,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಸಂಖ್ಯೆಯು 11 ರಿಂದ ಭಾಗವಾಗಬೇಕಾದರೆ ಇರಬೇಕಾದ ನಿಯಮ ಯಾವುದು?",
            options = listOf("ಬೆಸ ಮತ್ತು ಸಮ ಸ್ಥಾನಗಳ ಅಂಕೆಗಳ ಮೊತ್ತಗಳ ವ್ಯತ್ಯಾಸ 0 ಅಥವಾ 11 ರ ಅಪವರ್ತ್ಯವಾಗಿರಬೇಕು", "ಅಂಕೆಗಳ ಮೊತ್ತ 11 ಆಗಿರಬೇಕು", "ಕೊನೆಯ ಅಂಕೆ 1 ಆಗಿರಬೇಕು", "ಎಲ್ಲಾ ಅಂಕೆಗಳೂ ಸಮವಾಗಿರಬೇಕು"),
            correctAnswer = "ಬೆಸ ಮತ್ತು ಸಮ ಸ್ಥಾನಗಳ ಅಂಕೆಗಳ ಮೊತ್ತಗಳ ವ್ಯತ್ಯಾಸ 0 ಅಥವಾ 11 ರ ಅಪವರ್ತ್ಯವಾಗಿರಬೇಕು",
            explanation = "ಬೆಸ ಸ್ಥಾನಗಳ ಅಂಕೆಗಳ ಮೊತ್ತ ಮತ್ತು ಸಮ ಸ್ಥಾನಗಳ ಅಂಕೆಗಳ ಮೊತ್ತದ ವ್ಯತ್ಯಾಸವು 0 ಅಥವಾ 11 ರಿಂದ ಭಾಗವಾಗುವ ಸಂಖ್ಯೆಯಾಗಿರಬೇಕು."
        )
    )
}
