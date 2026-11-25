package com.example.data

/**
 * TET (Teacher Eligibility Test - Standard / Exam ID: 13)
 * Subject: EVS, Science & Social Pedagogy ("general_science")
 * Unit 8: 7. ಕುಟುಂಬ ಮತ್ತು ಸಾರಿಗೆ (Family & Transport) — 200 MCQs.
 */
object TetFamilyAndTransportQuestionBank {

    val unitTemplate = UnitTemplate(
        id = 8,
        name = "7. ಕುಟುಂಬ ಮತ್ತು ಸಾರಿಗೆ (Family & Transport)",
        totalQuestions = 200,
        difficulty = "Medium"
    )

    val questions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetFamilyAndTransport") {
            listOf(
                QuestionModel(
                    id = "tet_ft_q1",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "1) ಸಮಾಜದ ಅತಿ ಚಿಕ್ಕ ಘಟಕ …",
                    options = listOf("ಶಾಲೆ", "ಮನೆ", "ಕುಟುಂಬ", "ಸಂಸ್ಥೆ"),
                    correctAnswer = "ಕುಟುಂಬ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕುಟುಂಬ."
                ),
                QuestionModel(
                    id = "tet_ft_q2",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "2) ಹಲವಾರು ಕುಟುಂಬಗಳ ಸಮೂಹವೇ ........ ಆಧಾರವಾಗಿದೆ",
                    options = listOf("ರಾಜ್ಯಕ್ಕೆ", "ರಾಷ್ಟ್ರಕ್ಕೆ", "ಜಿಲ್ಲೆಗೆ", "ಸಮಾಜಕ್ಕೆ"),
                    correctAnswer = "ಸಮಾಜಕ್ಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಮಾಜಕ್ಕೆ."
                ),
                QuestionModel(
                    id = "tet_ft_q3",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "3) ಪುರಾತನ ಕಾಲದಲ್ಲಿ ಯಾವ ಕುಟುಂಬ ಪದ್ಧತಿಯೇ ಜಾರಿಯಲ್ಲಿತ್ತೆಂದೇ ಹಲವರ ಅಭಿಪ್ರಾಯ",
                    options = listOf("ಪಿತೃ ಪ್ರಧಾನ ಕುಟುಂಬ", "ಮಾತೃಪ್ರಧಾನ ಕುಟುಂಬ", "ಅವಿಭಕ್ತ ಕುಟುಂಬ", "ವಿಭಕ್ತ ಕುಟುಂಬ"),
                    correctAnswer = "ವಿಭಕ್ತ ಕುಟುಂಬ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಭಕ್ತ ಕುಟುಂಬ."
                ),
                QuestionModel(
                    id = "tet_ft_q4",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "4) ಮಾತೃ ಪ್ರಧಾನ ಕುಟುಂಬ ಪದ್ಧತಿಯಲ್ಲಿ ತಾಯಿಯೇ ಮನೆಯ ಯಜಮಾನ ಅವಳ ನಂತರ",
                    options = listOf("ತಂದೆ", "ಹಿರಿಯ ಅಣ್ಣ", "ಹಿರಿಯ ಮಗಳು", "ಸಣ್ಣ ಮಗು"),
                    correctAnswer = "ಹಿರಿಯ ಮಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹಿರಿಯ ಮಗಳು."
                ),
                QuestionModel(
                    id = "tet_ft_q5",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "5) ಮಗುವಿಗೆ ಮೊದಲನೆಯ ಪಾಠಶಾಲೆ",
                    options = listOf("ಕುಟುಂಬ", "ಶಾಲೆ", "ಸಮಾಜ", "ಆಶ್ರಮ"),
                    correctAnswer = "ಕುಟುಂಬ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕುಟುಂಬ."
                ),
                QuestionModel(
                    id = "tet_ft_q6",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "6) ಮಗುವಿನ ಮೊದಲ ಗುರು",
                    options = listOf("ತಂದೆ", "ತಾಯಿ", "ಗುರುಗಳು", "ಮಠಾಧೀಶರು"),
                    correctAnswer = "ತಾಯಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತಾಯಿ."
                ),
                QuestionModel(
                    id = "tet_ft_q7",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "7) ಹೆಂಗಸರು ಮನೆಯಲ್ಲಿಯೇ ಇದ್ದು ಮನೆಗೆಲಸ ಗಳನ್ನು ನೋಡಿಕೊಳ್ಳುತ್ತಾರೆ.",
                    options = listOf("ಪಿತೃ ಪ್ರಧಾನ ಕುಟುಂಬ", "ಅವಿಭಕ್ತ ಕುಟುಂಬ", "ಮಾತೃಪ್ರಧಾನ ಕುಟುಂಬ", "ವಿಭಕ್ತ ಕುಟುಂಬ"),
                    correctAnswer = "ಪಿತೃ ಪ್ರಧಾನ ಕುಟುಂಬ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪಿತೃ ಪ್ರಧಾನ ಕುಟುಂಬ."
                ),
                QuestionModel(
                    id = "tet_ft_q8",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "8) ಇಂದು ಪಾಶ್ಚಿಮಾತ್ಯ ಸಂಸ್ಕøತಿಯ ಪ್ರಭಾವದಿಂದ ಯಾವ ಕುಟುಂಬ ಮಾಯವಾಗುತ್ತಿದೆ.",
                    options = listOf("ಅವಿಭಕ್ತ ಕುಟುಂಬ", "ವಿಭಕ್ತ ಕುಟುಂಬ", "ಪಿತೃ ಪ್ರಧಾನ ಕುಟುಂಬ", "ಮಾತೃ ಪ್ರಧಾನ ಕುಟುಂಬ"),
                    correctAnswer = "ವಿಭಕ್ತ ಕುಟುಂಬ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಭಕ್ತ ಕುಟುಂಬ."
                ),
                QuestionModel(
                    id = "tet_ft_q9",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "9) ನವೀನ ಮಾದರಿಯ ಕುಟುಂಬ ಲಕ್ಷಣ",
                    options = listOf("ತಾಯಿ, ತಂದೆ, ಅಕ್ಕ, ತಂಗಿ", "ಗಂಡ, ಹೆಂಡತಿ, ಮತ್ತು ಅವರ ಮಕ್ಕಳು", "ತಾಯಿ, ತಂದೆ, ಮಗ, ಸೊಸೆ", "ಕಾಕ, ತಮ್ಮ, ಅಣ್ಣ, ಬಾಬು"),
                    correctAnswer = "ಗಂಡ, ಹೆಂಡತಿ, ಮತ್ತು ಅವರ ಮಕ್ಕಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗಂಡ, ಹೆಂಡತಿ, ಮತ್ತು ಅವರ ಮಕ್ಕಳು."
                ),
                QuestionModel(
                    id = "tet_ft_q10",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "10) ಬುದ್ಧಿಯ ವಿಕಾಸಕ್ಕೆ ಅನಿವಾರ್ಯ",
                    options = listOf("ವಿದ್ಯೆ", "ಹಣ", "ತಂದೆ", "ತಾಯಿ"),
                    correctAnswer = "ವಿದ್ಯೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿದ್ಯೆ."
                ),
                QuestionModel(
                    id = "tet_ft_q11",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "11) ಪ್ರಜಾಪ್ರಭುತ್ವ ವ್ಯವಸ್ಥೆಯು ಫಲಕಾರಿ ಯಾಗಬೇಕಾದಲ್ಲಿ",
                    options = listOf("ಸರ್ಕಾರ", "ಶಿಕ್ಷಣ", "ಕುಟುಂಬ", "ಸಮಾಜ"),
                    correctAnswer = "ಶಿಕ್ಷಣ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶಿಕ್ಷಣ."
                ),
                QuestionModel(
                    id = "tet_ft_q12",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "12) ವ್ಯಕ್ತಿ ಸಮಾಜದ ಕೇಂದ್ರ ಬಿಂದು- ಈ ಕೇಂದ್ರ ಬಿಂದುವಿನ ಸುತ್ತಲೂ ಇರುವದು",
                    options = listOf("ಶಾಲೆ", "ಸಂಸ್ಥೆ", "ಕುಟುಂಬ", "ಸಮಾಜ"),
                    correctAnswer = "ಕುಟುಂಬ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕುಟುಂಬ."
                ),
                QuestionModel(
                    id = "tet_ft_q13",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "13) ಅವಿಭಕ್ತ ಕುಟುಂಬ ಪದ್ಧತಿಯಲ್ಲಿ ಕೆಳಗಿನ ಯಾವ ಹೇಳಿಕೆ ಅನುಕೂಲವಾಗಿದೆ",
                    options = listOf(
                        "ಸದಸ್ಯರು ಕುಟುಂಬದ ಧಾರ್ಮಿಕ ಮತ್ತು ಇತರ ಕಾರ್ಯಗಳಲ್ಲಿ ಸಾಮಾಜಿಕವಾಗಿ ಪಾಲ್ಗೋಳ್ಳುತ್ತಾರೆ",
                        "ಎಲ್ಲರೂ ಏಕ ರೀತಿಯಾದಂತಹ ಶಿಕ್ಷಣವನ್ನೇ ಪಡೆಯುತ್ತಾರೆ",
                        "ಸದಸ್ಯರು ಕುಟುಂಬದ ಆಸ್ತಿಯ ಮೆಲೆ ಸಮಾನವಾದ ಒಡೆತನವನ್ನು ಹೊಂದಿರುತ್ತಾರೆ",
                        "ಮೇಲಿನ ಎಲ್ಲವೂ"
                    ),
                    correctAnswer = "ಸದಸ್ಯರು ಕುಟುಂಬದ ಧಾರ್ಮಿಕ ಮತ್ತು ಇತರ ಕಾರ್ಯಗಳಲ್ಲಿ ಸಾಮಾಜಿಕವಾಗಿ ಪಾಲ್ಗೋಳ್ಳುತ್ತಾರೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸದಸ್ಯರು ಕುಟುಂಬದ ಧಾರ್ಮಿಕ ಮತ್ತು ಇತರ ಕಾರ್ಯಗಳಲ್ಲಿ ಸಾಮಾಜಿಕವಾಗಿ ಪಾಲ್ಗೋಳ್ಳುತ್ತಾರೆ."
                ),
                QuestionModel(
                    id = "tet_ft_q14",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "14) ವಿಭಕ್ತ ಕುಟುಂಬಕ್ಕೆ ಈ ಕೆಳಗಿನ ಯಾವ ಹೇಳಿಕೆ ಅನ್ವಯಿಸುವುದಿಲ್ಲ",
                    options = listOf(
                        "ಗಂಡ ಹೆಂಡತಿ ತಮ್ಮ ಅವಿವಾಹಿತ ಮಕ್ಕಳೊಂದಿಗೆ ವಾಸಿಸುತ್ತಾರೆ",
                        "ಮಕ್ಕಳು ತಮ್ಮ ವಿವಾಹ ಆಗುವವರೆಗಗೆ ತಮ್ಮ ತಾಯಿತಂದೆಯೊಂದಿಗೆ ವಾಸಿಸುತ್ತಾರೆ",
                        "ಮಕ್ಕಳು ವಿವಾಹ ಆದನಂತರವೂ ಕುಟುಂಬ ದಲ್ಲಿಯೇ ವಾಸಿಸುತ್ತಾರೆ",
                        "ಇಂತಹ ಕುಟುಂಬಗಳನ್ನು ಹೆಚ್ಚಾಗಿ ನಗರಗಳಲ್ಲಿ ಕಾಣಬಹುದು"
                    ),
                    correctAnswer = "ಮಕ್ಕಳು ವಿವಾಹ ಆದನಂತರವೂ ಕುಟುಂಬ ದಲ್ಲಿಯೇ ವಾಸಿಸುತ್ತಾರೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಕ್ಕಳು ವಿವಾಹ ಆದನಂತರವೂ ಕುಟುಂಬ ದಲ್ಲಿಯೇ ವಾಸಿಸುತ್ತಾರೆ."
                ),
                QuestionModel(
                    id = "tet_ft_q15",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "15) ಸಾರಿಗೆ ಎಂದರೆ",
                    options = listOf(
                        "ಒಂದು ಸ್ಥಳದಿಂದ ಮತ್ತೊಂದು ಸ್ಥಳಕ್ಕೆ ಸಾಗಿಸುವುದು",
                        "ಒಂದು ಸ್ಥಳದಿಂದ ಹೋಗುವ ಬಸ್ಸಿನ ವ್ಯವಸ್ಥೆ",
                        "ರಸ್ತೆ",
                        "ಒಂದು ರಾಷ್ಟ್ರಕ್ಕೆ ಸಂಪರ್ಕ ಕಲ್ಪಿಸುವುದು"
                    ),
                    correctAnswer = "ಒಂದು ಸ್ಥಳದಿಂದ ಮತ್ತೊಂದು ಸ್ಥಳಕ್ಕೆ ಸಾಗಿಸುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಒಂದು ಸ್ಥಳದಿಂದ ಮತ್ತೊಂದು ಸ್ಥಳಕ್ಕೆ ಸಾಗಿಸುವುದು."
                ),
                QuestionModel(
                    id = "tet_ft_q16",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "16) ಒಂದು ದೇಶದ ಅರ್ಥ ವ್ಯವಸ್ಥೆಯನ್ನು ದೇಹಕ್ಕೆ ಹೋಲಿಸದರೆ ಸಾರಿಗೆ ಸಂಪರ್ಕವು",
                    options = listOf("ಬೆನ್ನು ಮೂಳೆ", "ನರಮಂಡಲ", "ಜೀರ್ಣ ಕ್ರೀಯೆ", "ಶ್ವಾಸ ಕೋಶ"),
                    correctAnswer = "ಬೆನ್ನು ಮೂಳೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೆನ್ನು ಮೂಳೆ."
                ),
                QuestionModel(
                    id = "tet_ft_q17",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "17) ಬ್ರಿಟಿಷರ ಕಾಲದಲ್ಲಿ ರಸ್ತೆಗಳ ನಿರ್ಮಾಣ ಬಹುಮಟ್ಟಿಗೆ",
                    options = listOf("ರಕ್ಷಣಾ ವ್ಯವಸ್ಥೆ", "ಸಂಚಾರಕ್ಕೆ", "ವಸ್ತುಗಳು ಸಾಗಿಸಲು", "ದೇಶದ ಅಭಿವೃದ್ಧಿಗೆ"),
                    correctAnswer = "ರಕ್ಷಣಾ ವ್ಯವಸ್ಥೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರಕ್ಷಣಾ ವ್ಯವಸ್ಥೆ."
                ),
                QuestionModel(
                    id = "tet_ft_q18",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "18) ನಾಲ್ಕು ರಾಷ್ಟ್ರೀಯ ಹೆದ್ದಾರಿಗಳನ್ನು ನಿರ್ಮಿಸಲು ತಳಪಾಯ ಹಾಕಿದವರು",
                    options = listOf("ಕಾರ್ನವಾಲಿಸ್", "ವೆಲ್ಲಸ್ಲಿ", "ಡಾಲ್ ಹೌಸಿ", "ವಿಲಿಯಂ ಬೆಂಟಿಕ್"),
                    correctAnswer = "ಡಾಲ್ ಹೌಸಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಡಾಲ್ ಹೌಸಿ."
                ),
                QuestionModel(
                    id = "tet_ft_q19",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "19) ಭಾರತ ಕೈಗಾರಿಕೆಗಳ ಅಭಿವೃದ್ಧಿಗೆ ಅತ್ಯಅವಶ್ಯಕ",
                    options = listOf("ರಸ್ತೆಗಳು", "ಸರ್ಕಾರ", "ಸಂಪತ್ತು", "ಶಿಕ್ಷಣ"),
                    correctAnswer = "ರಸ್ತೆಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರಸ್ತೆಗಳು."
                ),
                QuestionModel(
                    id = "tet_ft_q20",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "20) ಭಾರತದ ರಸ್ತೆಗಳನ್ನು ಎಷ್ಟು ಪ್ರಕಾರಗಳಾಗಿ ವಿಂಗಡಿಸಲಾಗಿದೆ.",
                    options = listOf("3", "2", "4", "5"),
                    correctAnswer = "2",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 2."
                ),
                QuestionModel(
                    id = "tet_ft_q21",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "21) ಗ್ರಾಮೀಣ ಸಡಕ್ ಯೋಜನೆಯ ಗುರಿ",
                    options = listOf(
                        "ಭಾರತ ದೇಶದಲ್ಲಿ ರಸ್ತೆಗಳ ನಿರ್ಮಾಣ",
                        "ಕ್ವಾಡ್ರಿಲ್ಯಾಟರಲ್ ರಸ್ತೆ ಮಾರ್ಗ ನಿರ್ಮಾಣ",
                        "ಕಚ್ಛಾ ರಸ್ತೆಗಳನ್ನು ಪಕ್ಕಾ ರಸ್ತೆಗಳನ್ನಾಗಿ ಮಾರ್ಪಡಿಸುವುದು",
                        "ಹಳ್ಳಿಗಳ ರಸ್ತೆ ನಿರ್ಮಾಣ"
                    ),
                    correctAnswer = "ಕಚ್ಛಾ ರಸ್ತೆಗಳನ್ನು ಪಕ್ಕಾ ರಸ್ತೆಗಳನ್ನಾಗಿ ಮಾರ್ಪಡಿಸುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಚ್ಛಾ ರಸ್ತೆಗಳನ್ನು ಪಕ್ಕಾ ರಸ್ತೆಗಳನ್ನಾಗಿ ಮಾರ್ಪಡಿಸುವುದು."
                ),
                QuestionModel(
                    id = "tet_ft_q22",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "22) ಜಿಲ್ಲಾ ರಸ್ತೆಗಳ ನಿರ್ಮಾಣದ ನಿರ್ವಹಣೆ",
                    options = listOf("ರಾಜ್ಯ ಸರ್ಕಾರ", "ಜಿಲ್ಲಾ ಪಂಚಾಯತ", "ತಾಲ್ಲೂಕು ಪಂಚಾಯತ", "ಕೇಂದ್ರ ಸರ್ಕಾರ"),
                    correctAnswer = "ಜಿಲ್ಲಾ ಪಂಚಾಯತ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಿಲ್ಲಾ ಪಂಚಾಯತ."
                ),
                QuestionModel(
                    id = "tet_ft_q23",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "23) ಗಡಿ ರಸ್ತೆಗಳ ನಿರ್ಮಾಣ ಜವಾಬ್ದಾರಿ",
                    options = listOf("ಕೇಂದ್ರಸರ್ಕಾರ", "ಗಡಿ ರಸ್ತೆಗಳ ಪ್ರಾಧಿಕಾರ", "ರಾಜ್ಯ ಸರ್ಕಾರ", "ರಾಷ್ಟ್ರಪತಿ"),
                    correctAnswer = "ಗಡಿ ರಸ್ತೆಗಳ ಪ್ರಾಧಿಕಾರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗಡಿ ರಸ್ತೆಗಳ ಪ್ರಾಧಿಕಾರ."
                ),
                QuestionModel(
                    id = "tet_ft_q24",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "24) ಭಾರತದ ಮೊಟ್ಟ ಮೊದಲ ರೈಲು ಮಾರ್ಗ",
                    options = listOf("ಕಲ್ಕತ್ತದಿಂದ-ಥಾಣಾ", "ಮುಂಬಯಿಯಿಂದ-ಬೆಂಗಳೂರು", "ಥಾಣಾದಿಂದ-ಬೆಂಗಳೂರು", "ಮುಂಬಯಿಯಿಂದ-ಥಾಣಾ"),
                    correctAnswer = "ಮುಂಬಯಿಯಿಂದ-ಥಾಣಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮುಂಬಯಿಯಿಂದ-ಥಾಣಾ."
                ),
                QuestionModel(
                    id = "tet_ft_q25",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "25) ಏಷ್ಯ ಖಂಡದಲ್ಲೆ ಅತಿ ದೊಡ್ಡ ರೈಲು ಜಾಲ ಹೊಂದಿದ ರಾಷ್ಟ್ರ",
                    options = listOf("ಭಾರತ", "ಪಾಕಿಸ್ತಾನ", "ಶ್ರೀಲಂಕಾ", "ನೇಪಾಳ"),
                    correctAnswer = "ಭಾರತ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಭಾರತ."
                ),
                QuestionModel(
                    id = "tet_ft_q26",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "26) ಭಾರತ ರೈಲು ಸಾರಿಗೆಯಲ್ಲಿ ಪ್ರಪಂಚದಲ್ಲಿ ಎಷ್ಟನೆ ಸ್ಥಾನ ಪಡೆದುಕೊಂಡಿದೆ.?",
                    options = listOf("2ನೇ ಸ್ಥಾನ", "3ನೇ ಸ್ಥಾನ", "4ನೇ ಸ್ಥಾನ", "ಐದನೇ ಸ್ಥಾನ"),
                    correctAnswer = "4ನೇ ಸ್ಥಾನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 4ನೇ ಸ್ಥಾನ."
                ),
                QuestionModel(
                    id = "tet_ft_q27",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "27) ಭಾರತ ಸರ್ಕಾರ ಗೇಜ್ ಏಕೀಕರಣ ಯೋಜನೆ ಜಾರಿಗೆ ತಂದ ವರ್ಷ",
                    options = listOf("1991", "1990", "1993", "1992"),
                    correctAnswer = "1992",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1992."
                ),
                QuestionModel(
                    id = "tet_ft_q28",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "28) ಕೊಳವೆ ಮಾರ್ಗಗಳ ಉಪಯೋಗ",
                    options = listOf(
                        "ಒಂದು ವಾಹನದಿಂದ ಇನ್ನೊಂದು ವಾಹನಕ್ಕೆ ಸರಕು ಸಾಗಿಸಲು",
                        "ಬೃಹತ ಗಾತ್ರದ ತೈಲ ಸಾಗಿಸಲು",
                        "ಅತಿ ವೇಗವಾಗಿ ತೈಲ ಸಾಗಿಸಲು",
                        "ತೈಲ ಸುಧಾರಣೆ"
                    ),
                    correctAnswer = "ಒಂದು ವಾಹನದಿಂದ ಇನ್ನೊಂದು ವಾಹನಕ್ಕೆ ಸರಕು ಸಾಗಿಸಲು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಒಂದು ವಾಹನದಿಂದ ಇನ್ನೊಂದು ವಾಹನಕ್ಕೆ ಸರಕು ಸಾಗಿಸಲು."
                ),
                QuestionModel(
                    id = "tet_ft_q29",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "29) ನಮ್ಮ ವಿದೇಶ ವ್ಯಾಪಾರವು ಶೇಕಡಾ 85 ರಷ್ಟು ಈ ಮಾರ್ಗಗಳ ಮುಖಾಂತರ ಸಾಗುವದು",
                    options = listOf("ವಾಯು ಸಾರಿಗೆ", "ಜಲ ಸಾರಿಗೆ", "ಭೂ ಸಾರಿಗೆ", "ರೈಲು ಸಾರಿಗೆ"),
                    correctAnswer = "ಜಲ ಸಾರಿಗೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಲ ಸಾರಿಗೆ."
                ),
                QuestionModel(
                    id = "tet_ft_q30",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "30) ಒಳ ನಾಡಿನ ಜಲಸಾರಿಗೆ ಪ್ರಾಧಿಕಾರ ಸ್ಥಾಪಿಸಿದ ವರ್ಷ",
                    options = listOf("1985", "1986", "1988", "1989"),
                    correctAnswer = "1985",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1985."
                ),
                QuestionModel(
                    id = "tet_ft_q31",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "31) ಕಾಂಡ್ಲಾ ಬಂದರು ಹೊಂದಿರುವ ರಾಜ್ಯ",
                    options = listOf("ಕರ್ನಾಟಕ", "ರಾಜಸ್ಥಾನ", "ಕೇರಳ", "ಗುಜರಾತ"),
                    correctAnswer = "ಗುಜರಾತ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗುಜರಾತ."
                ),
                QuestionModel(
                    id = "tet_ft_q32",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "32) ಜವಹರಲಾಲ್ ನೇಹರು ಎಂಬ ಹೆಸರಿನಿಂದ ಕರೆಯುವ ಬಂದರು",
                    options = listOf("ತುತಕುಟಿ", "ಹಾಲ್ದಿಯಾ", "ಚೆನ್ನೈ", "ನವಾಶೇವಾ"),
                    correctAnswer = "ನವಾಶೇವಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನವಾಶೇವಾ."
                ),
                QuestionModel(
                    id = "tet_ft_q33",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "33) ಪ್ರಥಮ ಪಂಚವಾರ್ಷಿಕ ಯೋಜನೆಯಲ್ಲಿ ಪ್ರಾರಂಭವಾದ ಬಂದರು",
                    options = listOf("ಮುಂಬಯಿ", "ಮರ್ಮಗೋವಾ", "ಕಾಂಡ್ಲ", "ಪಾರಾದೀಪ"),
                    correctAnswer = "ಕಾಂಡ್ಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾಂಡ್ಲ."
                ),
                QuestionModel(
                    id = "tet_ft_q34",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "34) ಭಾರತದ ಹೆಬ್ಬಾಗಿಲು ಎಂದು ಕರೆಯುವ ಬಂದರು",
                    options = listOf("ಮುಂಬಯಿ", "ಕೊಚ್ಚಿ", "ಮಂಗಳೂರು", "ವಿಶಾಖಪಟ್ಟಣ"),
                    correctAnswer = "ಮುಂಬಯಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮುಂಬಯಿ."
                ),
                QuestionModel(
                    id = "tet_ft_q35",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "35) ಕರ್ನಾಟಕದ ಹೆಬ್ಬಾಗಿಲು ಬಂದರು",
                    options = listOf("ಮುರುಡೇಶ್ವರ", "ಮಂಗಳೂರು", "ಮಲ್ಪೆ", "ಕಲಬುರಗಿ"),
                    correctAnswer = "ಮಂಗಳೂರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಂಗಳೂರು."
                ),
                QuestionModel(
                    id = "tet_ft_q36",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "36) ಭಾರತದ ಅತ್ಯಂತ ಹಳೆಯ ಕೃತಕ ಬಂದರು",
                    options = listOf("ತುತುಕುಡಿ", "ಕೊಚಿ", "ಚೆನ್ನೈ", "ವಿಶಾಖಪಟ್ಟಣ"),
                    correctAnswer = "ಚೆನ್ನೈ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚೆನ್ನೈ."
                ),
                QuestionModel(
                    id = "tet_ft_q37",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "37) ಭಾರತದ ಚಹದ ಬಂದರು",
                    options = listOf("ಹಾಲ್ದಿಯಾ", "ಕೊಲ್ಕತ್ತಾ ಬಂದರು", "ಪಾರಾದೀಪ", "ಕೊಚ್ಚಿ"),
                    correctAnswer = "ಕೊಲ್ಕತ್ತಾ ಬಂದರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೊಲ್ಕತ್ತಾ ಬಂದರು."
                ),
                QuestionModel(
                    id = "tet_ft_q38",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "38) ಅಣ್ಣಾ ವಿಮಾನ ನಿಲ್ದಾಣ ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು?",
                    options = listOf("ಬೆಂಗಳೂರು", "ಆಗ್ರಾ", "ಚೆನ್ನೈ", "ಜೈಪೂರ"),
                    correctAnswer = "ಚೆನ್ನೈ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚೆನ್ನೈ."
                ),
                QuestionModel(
                    id = "tet_ft_q39",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "39) ಪಿನ್ ಕೋಡ ಭಾರತದಲ್ಲಿ ಜಾರಿಗೆ ಬಂದ ವರ್ಷ",
                    options = listOf("1972", "1976", "1973", "1974"),
                    correctAnswer = "1972",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1972."
                ),
                QuestionModel(
                    id = "tet_ft_q40",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "40) ಶೀಘ್ರ ಅಂಚೆ ಸೇವೆ ಜಾರಿಗೆ ಬಂದ ವರ್ಷ",
                    options = listOf("1975", "1977", "1978", "1979"),
                    correctAnswer = "1975",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1975."
                ),
                QuestionModel(
                    id = "tet_ft_q41",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "41) ಭಾರತದಲ್ಲಿ ಆಕಾಶವಾಣಿಯು ಮೊಟ್ಟ ಮೊದಲಿಗೆ ಯಾವಾಗ ಪ್ರಾರಂಭವಾಯಿತು.",
                    options = listOf("1931", "1932", "1930", "1934"),
                    correctAnswer = "1931",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1931."
                ),
                QuestionModel(
                    id = "tet_ft_q42",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "42) ದೆಹಲಿ ಬಳಿಯ ಪಿತಂಪುರದಲ್ಲಿ ಯಾರ ಜ್ಞಾಪಕಾರ್ಥವಾಗಿ ದೂರದರ್ಶನ ಗೋಪುರ ಸ್ಥಾಪಿಸಲಾಗಿದೆ.",
                    options = listOf("ನೆಹರು", "ಗಾಂಧೀಜಿ", "ಇಂದಿರಾಗಾಂಧಿ", "ಡಾ. ಬಿ.ಆರ್.ಅಂಬೇಡ್ಕರ"),
                    correctAnswer = "ಡಾ. ಬಿ.ಆರ್.ಅಂಬೇಡ್ಕರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಡಾ. ಬಿ.ಆರ್.ಅಂಬೇಡ್ಕರ."
                ),
                QuestionModel(
                    id = "tet_ft_q43",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "43) ಅತಿ ಕಡಿಮೆ ವೆಚ್ಚ ಸಾರಿಗೆ ಮಾಧ್ಯಮ",
                    options = listOf("ಜಲಸಾರಿಗೆ", "ವಾಯುಸಾರಿಗೆ", "ರಸ್ತೆ ಸಾರಿಗೆ", "ರೈಲ್ವೆ ಸಾರಿಗೆ"),
                    correctAnswer = "ರೈಲ್ವೆ ಸಾರಿಗೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರೈಲ್ವೆ ಸಾರಿಗೆ."
                ),
                QuestionModel(
                    id = "tet_ft_q44",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "44) ಗ್ರಾಮೀಣ ರಸ್ತೆಗಳ ನಿರ್ಮಾಣದ ಉದ್ದೇಶದ ಕಾರ್ಯಕ್ರಮ",
                    options = listOf(
                        "ಸಮಗ್ರ ಗ್ರಾಮೀಣ ಅಭಿವೃದ್ಧಿ ಕಾರ್ಯಕ್ರಮ",
                        "ಪ್ರಧಾನ ಮಂತ್ರಿಯವರ ಗ್ರಾಮ ಸಡಕ್ ಯೋಜನೆ",
                        "ರೋಜಗಾರ ಯೋಜನೆ",
                        "ಮೇಲಿನ ಎಲ್ಲವೂ"
                    ),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_ft_q45",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "45) ಶೇ.80ರಷ್ಟು ವಸ್ತುಗಳನ್ನು ಮತ್ತು ಶೇ.70ರಷ್ಟು ಜನರನ್ನು ಈ ಮಾರ್ಗ ಮೂಲಕ ಸಾಗಣೆ ಮಾಡಲಾಗುವುದು",
                    options = listOf("ವಾಯು ಮಾರ್ಗ", "ರಸ್ತೆ ಮಾರ್ಗ", "ಜಲ ಮಾರ್ಗ", "ರೈಲು ಮಾರ್ಗ"),
                    correctAnswer = "ರೈಲು ಮಾರ್ಗ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರೈಲು ಮಾರ್ಗ."
                ),
                QuestionModel(
                    id = "tet_ft_q46",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "46) ಪ್ರಪಂಚದಲ್ಲಿ ಅತ್ಯಂತ ವೇಗವಾಗಿ ಚಲಿಸುವ ರೈಲು",
                    options = listOf("ಎ.ಖ.ಮಾಗ್ಲೇವ್", "ಎ.ಖ.ವ್ಯಾಗ್ಲೇವ್", "ಎ.ಖ.ಗ್ಯಾಗೋವ್", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಎ.ಖ.ವ್ಯಾಗ್ಲೇವ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎ.ಖ.ವ್ಯಾಗ್ಲೇವ್."
                ),
                QuestionModel(
                    id = "tet_ft_q47",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "47) ದೇವನಹಳ್ಳಿ ಅಂತರ್ಟ್ರಾೀಯ ವಿಮಾನ ನಿಲ್ದಾಣವಿರುವುದು.",
                    options = listOf("ನವದೆಹಲಿ", "ಚೆನ್ನೈ", "ಬೆಂಗಳೂರು", "ಮುಂಬೈ"),
                    correctAnswer = "ಬೆಂಗಳೂರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೆಂಗಳೂರು."
                ),
                QuestionModel(
                    id = "tet_ft_q48",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "48) ಚಕ್ರಗಳು ಸಂಪರ್ಕಿಸಲ್ಪಟ್ಟಿರುವ ದಂಡ",
                    options = listOf("ಕಚ್ಚು", "ಅಚ್ಚು", "ಕೆಚ್ಚು", "ಯಾವುದು ಅಲ್ಲ."),
                    correctAnswer = "ಅಚ್ಚು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಚ್ಚು."
                ),
                QuestionModel(
                    id = "tet_ft_q49",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 8,
                    type = "MCQ",
                    questionText = "49) ಭಾರತೀಯ ರೇಲ್ವೆಯ ಅಚ್ಚು ಮತ್ತು ಗಾಲಿ ಕಾರ್ಖಾನೆ ಬೆಂಗಳೂರಿನ",
                    options = listOf("ಬನಶಂಕರಿ", "ಯಲಹಂಕ", "ಮಡಿವಾಳ", "ಯಾವುದು ಅಲ್ಲ."),
                    correctAnswer = "ಯಲಹಂಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯಲಹಂಕ."
                )
            ) + TetFamilyAndTransportExtraQuestions.questions
        }
}
