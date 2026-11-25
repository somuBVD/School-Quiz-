package com.example.data

/**
 * TET (Teacher Eligibility Test - Standard / Exam ID: 13)
 * Subject: EVS, Science & Social Pedagogy ("general_science")
 * Unit 9: 8. ವಿಜ್ಞಾನ ಪೆಡಗಾಗಿಕಲ್ ಇಸ್ಯೂಸ್ (Science Pedagogy) — 79 MCQs.
 */
object TetSciencePedagogyQuestionBank {

    val unitTemplate = UnitTemplate(
        id = 9,
        name = "8. ವಿಜ್ಞಾನ ಪೆಡಗಾಗಿಕಲ್ ಇಸ್ಯೂಸ್ (Science Pedagogy)",
        totalQuestions = 79,
        difficulty = "Medium"
    )

    val questions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetSciencePedagogy") {
            listOf(
                QuestionModel(
                    id = "tet_sp_q1",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "1) ವ್ಯವಸ್ಥಿತವಾದ ಜ್ಞಾನ ಮತ್ತು ಸತ್ಯ ಸಂಗತಿಗಳ ಸಂಗ್ರಹಿಸಿದ ಪರಿಕಲ್ಪನೆಗೆ ಹೀಗೆನ್ನುವರು",
                    options = listOf("ವಿಜ್ಞಾನ", "ಇತಿಹಾಸ", "ಪೌರನೀತಿ", "ಅನಾಟಮಿ"),
                    correctAnswer = "ವಿಜ್ಞಾನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಜ್ಞಾನ."
                ),
                QuestionModel(
                    id = "tet_sp_q2",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "2) ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಒಂದು ವಿಜ್ಞಾನದ ವ್ಯಾಪ್ತಿಗೆ ಸೇರಿರುತ್ತದೆ.",
                    options = listOf("ಮಾಹಿತಿ ತಂತ್ರಜ್ಞಾನ", "ಸಾರಿಕೆ ಸಂಪರ್ಕ", "ಆಹಾರ ಪೂರೈಕೆ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_sp_q3",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "3) ನಕ್ಷತ್ರಗಳ ರಚನೆ ಹಾಗೂ ಗ್ರಹಗಳ ಲಕ್ಷಣಗಳ ಬಗ್ಗೆ ತಿಳಿಯುವ ವಿಜ್ಞಾನದ ಶಾಖೆ",
                    options = listOf("ಭೂಗೋಳ ಶಾಸ್ತ್ರ", "ರಸಾಯನ ಶಾಸ್ತ್ರ", "ಖಗೋಳ ಶಾಸ್ತ್ರ", "ಭೌತ ಶಾಸ್ತ್ರ"),
                    correctAnswer = "ಖಗೋಳ ಶಾಸ್ತ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಖಗೋಳ ಶಾಸ್ತ್ರ."
                ),
                QuestionModel(
                    id = "tet_sp_q4",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "4) ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ವಿಜ್ಞಾನದ ಸ್ವರೂಪ ಗುರುತಿಸುವ ಹೇಳಿಕೆಯನ್ನು ತಿಳಿಸಿ:\n1) ಇದು ಸಂಘಟಿತ ಜ್ಞಾನ ಭಂಡಾರ\n2) ಪೂರ್ವಾಗ್ರಹ ಪೀಡೆಯನ್ನು ಹೊಂದಿರುವುದಿಲ್ಲ\n3) ಹೊಸ ಸಿದ್ಧಾಂತಗಳನ್ನು ಸೂಕ್ತ ಮಾಹಿತಿ ಇಲ್ಲದೆ ಸ್ವಿಕರಿಸುವುದಿಲ್ಲ\n4) ಇದು ವೈಜ್ಞಾನಿಕ ಮನೋಭಾವನೆ ಯನ್ನು ಹುಟ್ಟು ಹಾಕುವುದಾಗಿದೆ.",
                    options = listOf("1 ಮತ್ತು 2", "2 ಮತ್ತು 3", "3 ಮತ್ತು 4", "1, 2, 3 ಮತ್ತು 4"),
                    correctAnswer = "1, 2, 3 ಮತ್ತು 4",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1, 2, 3 ಮತ್ತು 4."
                ),
                QuestionModel(
                    id = "tet_sp_q5",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "5) ಸಾಮಾಜಿಕ ಬದಲಾವಣೆಯಲ್ಲಿ ವಿಜ್ಞಾನದ ಪಾತ್ರವನ್ನು ವಿವರಿಸುತ್ತದೆ.",
                    options = listOf(
                        "ಯಂತ್ರಗಳಿಂದ ಕೈಗಾರಿಕೋದ್ಯಮ ಪ್ರಗತಿ ಪಥದಲ್ಲಿದೆ",
                        "ಸಾರಿಗೆ ಸಂಪರ್ಕ ಊಹೆಗೂ ಮೀರಿ ವಿಸ್ತಾರ ಗೊಳ್ಳುತ್ತದೆ.",
                        "ಸಾಂಪ್ರದಾಯ ಬದ್ಧ ಸಮಾಜವನ್ನು ಆಧುನಿಕ ಸಮಾಜವನ್ನಾಗಿ ಪರಿವರ್ತಿಸುತ್ತದೆ.",
                        "ಮೇಲಿನ ಎಲ್ಲವೂ"
                    ),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_sp_q6",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "6) ಮೂಢನಂಬಿಕೆ ಮತ್ತು ಸಮಸ್ಯೆ ಪರಿಹಾರ ವಿಜ್ಞಾನದ ಈ ವಿಭಾಗಕ್ಕೆ ಸಂಬಂಧಿಸಿದ್ದಾಗಿದೆ.",
                    options = listOf("ವಿಜ್ಞಾನ ಬೋಧನೆ", "ಪರಿಸರ ವಿಜ್ಞಾನ", "ವೈಜ್ಞಾನಿಕ ಮನೋಭಾವನೆ", "ಎ ಮತ್ತು ಬಿ"),
                    correctAnswer = "ವೈಜ್ಞಾನಿಕ ಮನೋಭಾವನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವೈಜ್ಞಾನಿಕ ಮನೋಭಾವನೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q7",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "7) ವಿಜ್ಞಾನ ಬೋಧನೆ ಮೂಲಕ ಬೆಳೆಸಬಹುದಾದ ಮೌಲ್ಯಗಳು:\n1) ಉಪಯುಕ್ತತಾ ಮೌಲ್ಯ\n2) ಶಿಸ್ತಿನ ಮೌಲ್ಯ\n3) ಸಾಂಸ್ಕೃತಿಕ ಮೌಲ್ಯ\n4) ವೃತ್ತಿ ಮೌಲ್ಯ",
                    options = listOf("1 ಮತ್ತು 2", "2 ಮತ್ತು 3", "1 ಮತ್ತು 4", "ಮೇಲಿನ ಎಲ್ಲವು"),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವು."
                ),
                QuestionModel(
                    id = "tet_sp_q8",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "8) ಈ ಕೆಳಗಿನ ಭಾರತೀಯ ವಿಜ್ಞಾನಿ ಗಳನ್ನು ತಿಳಿಸಿ:\n1) ಜಗದೀಶ ಚಂದ್ರ ಬೋಸ್\n2) ಗ್ರೇಗರ್ ಮೆಂಡಲ್\n3) ನ್ಯೂಟನ್\n4) ಸಿ.ವಿ. ರಾಮನ್",
                    options = listOf("1 ಮತ್ತು 4", "1 ಮತ್ತು 3", "2 ಮತ್ತು 4", "3 ಮತ್ತು 4"),
                    correctAnswer = "1 ಮತ್ತು 4",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1 ಮತ್ತು 4."
                ),
                QuestionModel(
                    id = "tet_sp_q9",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "9) ಕೌಶಲ್ಯಕ್ಕೆ ಸಂಬಂಧಿಸಿದಂತೆ ಎರಡು ನಿರ್ದಿಷ್ಟಗಳನ್ನು ಗುರುತಿಸಿ:\n1) ಪ್ರಯೋಗ ಮಾಡುವುದು\n2) ಸ್ಮರಿಸುವುದು\n3) ಅಂದವಾದ ಚಿತ್ರ ಬರೆಯುವುದು\n4) ಗುರುತಿಸುವುದು",
                    options = listOf("1 ಮತ್ತು 2", "1 ಮತ್ತು 3", "3 ಮತ್ತು 4", "1 ಮತ್ತು 4"),
                    correctAnswer = "1 ಮತ್ತು 3",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1 ಮತ್ತು 3."
                ),
                QuestionModel(
                    id = "tet_sp_q10",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "10) ತಿಳುವಳಿಕೆಗೆ ಸಂಬಂಧಪಟ್ಟ ನಿರ್ದಿಷ್ಟ ಗಳನ್ನು ಹೆಸರಿಸಿ",
                    options = listOf("ಉದಾಹರಣೆ ಕೊಡುವುದು", "ವರ್ಗಿಕರಿಸುವುದು", "ಪತ್ತೆಹಚ್ಚುವುದು", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_sp_q11",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "11) ರಾಬರ್ಟ ಮೇಜರ್ರವರ ಪ್ರಕಾರ ಬೋಧನಾ ಉದ್ದೇಶಗಳು ಈ ಮೂರು ಅಂಶಗಳನ್ನು ಒಳಗೊಂಡಿವೆ.",
                    options = listOf("ವಿಷಯ, ವರ್ತನೆ, ಸ್ವರೂಪ", "ಜ್ಞಾನ, ಆಸಕ್ತಿ, ಪ್ರಶಂಶೆ", "ವಿಷಯ, ಜ್ಞಾನ, ಆಸಕ್ತಿ", "ಮನೋಭಾವ, ಸ್ವರೂಪ, ಅನ್ವಯ"),
                    correctAnswer = "ವಿಷಯ, ವರ್ತನೆ, ಸ್ವರೂಪ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಷಯ, ವರ್ತನೆ, ಸ್ವರೂಪ."
                ),
                QuestionModel(
                    id = "tet_sp_q12",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "12) ಜ್ಞಾನ ವಲಯದ ಉದ್ದೇಶಗಳನ್ನು ವರ್ಗಿಕರಿಸಿದವರು ಯಾರು",
                    options = listOf("ಡೇವಿಡ್ ಕೃಥಾಲ್", "ಅನಿತ ಟಿ. ಹರೋರೆ", "ಹರ್ಬಾರ್ಟ", "ಬೆಂಜಮೀನ್ ಎಸ್.ಬ್ಲೂಮ್"),
                    correctAnswer = "ಬೆಂಜಮೀನ್ ಎಸ್.ಬ್ಲೂಮ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೆಂಜಮೀನ್ ಎಸ್.ಬ್ಲೂಮ್."
                ),
                QuestionModel(
                    id = "tet_sp_q13",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "13) ಪ್ರಾಥಮಿಕ ತರಗತಿಯಲ್ಲಿ ವಿಜ್ಞಾನ ಬೋಧನೆಯ ಗುರಿಗಳನ್ನು ಗುರುತಿಸಿ:\n1) ಮಗುವಿನಲ್ಲಿ ಸೃಜನ ಶೀಲತೆಯನ್ನು ತೋರಿಸುವುದು\n2) ತನ್ನ ಮತ್ತು ಪರಿಸರದ ಆರೋಗ್ಯ ಕಾಪಾಡಿ ಕೊಳ್ಳುವುದು\n3) ಮಕ್ಕಳಲ್ಲಿ ಉತ್ತಮ ವೈಜ್ಞಾನಿಕ ಹವ್ಯಾಸಗಳನ್ನು ಬೆಳೆಸುವುದು\n4) ಪ್ರಸ್ತುತ ವಿಜ್ಞಾನದಲ್ಲಾಗಿರುವ ಬದಲಾವಣೆಯನ್ನು ಗುರುತಿಸುವುದು",
                    options = listOf("1 ಮತ್ತು 2", "2 ಮತ್ತು 3", "1 ಮತ್ತು 4", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_sp_q14",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "14) ಪರಿಣಾಮಕಾರಿ ವಿಜ್ಞಾನ ಬೋಧನೆಗೆ ಈ ಅಂಶಗಳು ಕಾರಣವಾಗಿವೆ.",
                    options = listOf("ವಿಷಯ ಪ್ರಭುತ್ವ", "ಕೌಶಲ್ಯಗಳು", "ಅನ್ವಯಗಳು", "ಜ್ಞಾನ ಮತ್ತು ಕೌಶಲ್ಯ"),
                    correctAnswer = "ಜ್ಞಾನ ಮತ್ತು ಕೌಶಲ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜ್ಞಾನ ಮತ್ತು ಕೌಶಲ್ಯ."
                ),
                QuestionModel(
                    id = "tet_sp_q15",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "15) ನಿರ್ದಿಷ್ಟ ಅವಧಿಯಲ್ಲಿ ಕಲಿಕೆಯ ಚೌಕಟ್ಟಿನಲ್ಲಿ ಪ್ರತಿಯೊಂದು ಮಗುವು ಸಾಧಿಸಲೇಬೇಕಾದ ಸಾಮಥ್ರ್ಯ ಗಳನ್ನು ಹೀಗೆನ್ನುವರು",
                    options = listOf("ಕಲಿಕಾ ಮಟ್ಟ", "ಕನಿಷ್ಠ ಕಲಿಕಾ ಮಟ್ಟ", "ಗರಿಷ್ಟ ಕಲಿಕಾ ಮಟ್ಟ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ಕನಿಷ್ಠ ಕಲಿಕಾ ಮಟ್ಟ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕನಿಷ್ಠ ಕಲಿಕಾ ಮಟ್ಟ."
                ),
                QuestionModel(
                    id = "tet_sp_q16",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "16) ವೈಜ್ಞಾನಿಕ ತತ್ವಗಳು, ಪರಿಕಲ್ಪನೆಗಳು ಹೊಸ ತತ್ವಗಳನ್ನು ಬೆಳೆಸುವ ಸಾಮಥ್ರ್ಯ ವನ್ನು ರೂಪಿಸಲು ಈ ಕ್ರಮದಿಂದ ಸಾಧ್ಯ.",
                    options = listOf("ಉಪನ್ಯಾಸ ಪದ್ಧತಿ", "ಪ್ರಯೋಗಿಕ ವಿಜ್ಞಾನ", "ಸಮಸ್ಯಾ ಪರಿಹಾರ ಪದ್ಧತಿ", "ಪ್ರಾತ್ಯಕ್ಷಿಕ ಪದ್ಧತಿ"),
                    correctAnswer = "ಸಮಸ್ಯಾ ಪರಿಹಾರ ಪದ್ಧತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಮಸ್ಯಾ ಪರಿಹಾರ ಪದ್ಧತಿ."
                ),
                QuestionModel(
                    id = "tet_sp_q17",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "17) ಪ್ರಾತ್ಯಕ್ಷಿಕ ಪದ್ಧತಿಯ ಯಾವುದಾದರೂ 2 ಅನುಕೂಲಗಳನ್ನು ಗುರುತಿಸಿ",
                    options = listOf(
                        "ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ಪ್ರಯೋಗಗಳನ್ನು ಮಾಡುವ ಕೌಶಲ್ಯಗಳ ಜೊತೆಗೆ ಪ್ರದರ್ಶಿಸುವ ಕುಶಲತೆಯು ಬೆಳೆಯುತ್ತದೆ",
                        "ದತ್ತ ಸಮಯದಲ್ಲಿ ಪ್ರಯೋಗಗಳನ್ನು ಪ್ರದರ್ಶಿಸ ಬೇಕಾಗಿರುವುದರಿಂದ ಸಮಯ ಪ್ರಜ್ಞೆ ಮೂಡುತ್ತದೆ.",
                        "ಸಮಸ್ಯೆ ಬಿಡಿಸಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ.",
                        "ಎ ಮತ್ತು ಬಿ"
                    ),
                    correctAnswer = "ಎ ಮತ್ತು ಬಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎ ಮತ್ತು ಬಿ."
                ),
                QuestionModel(
                    id = "tet_sp_q18",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "18) ಈ ಕೆಳಗಿನ ಹೆಳಿಕೆಗಳಲ್ಲಿ ಉಪನ್ಯಾಸ ಪದ್ಧತಿ ಕುರಿತು ಸರಿಯಾದ ಹೇಳಿಕೆಯನ್ನು ಗುರುತಿಸಿ:\n1) ಇದು ಶಿಕ್ಷಕ ಕೇಂದ್ರಿಕೃತ\n2) ಇದು ವಿಷಯ ಕೇಂದ್ರಿಕೃತ\n3) ಇದು ಏಕಮುಖ ಬೋಧನಾ ವಿಧಾನ\n4) ಮಕ್ಕಳ ಪಾಲ್ಗೋಳ್ಳುವಿಕೆಯನ್ನು ಹೆಚ್ಚಿಸುತ್ತದೆ",
                    options = listOf("1, 2 ಮತ್ತು 4", "3, 4 ಮತ್ತು 2", "1, 2 ಮತ್ತು 3", "ಮೇಲಿನ ಎಲ್ಲವು"),
                    correctAnswer = "1, 2 ಮತ್ತು 3",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1, 2 ಮತ್ತು 3."
                ),
                QuestionModel(
                    id = "tet_sp_q19",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "19) ಉದಾಹರಣೆ ಮೂಲಕ ಪ್ರಾರಂಭಿಸಿ ಪರಿಕಲ್ಪನೆ ಗಳನ್ನು ಬೆಳೆಸುವ ಬೋಧನೆಗೆ ಹೀಗೆನ್ನುವರು",
                    options = listOf("ಪ್ರಾಯೋಗಿಕ ವಿಧಾನ", "ಶಿಶು ಕೇಂದ್ರಿತ ವಿಧಾನ", "ಯೋಜನಾ ವಿಧಾನ", "ಪರಿಕಲ್ಪನಾ ಬೋಧನೆ"),
                    correctAnswer = "ಪರಿಕಲ್ಪನಾ ಬೋಧನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಿಕಲ್ಪನಾ ಬೋಧನೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q20",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "20) ಕ್ರಮಾನುಗತ ಬೋಧನೆಯನ್ನು ರೂಪಿಸಿದ ವಿಜ್ಞಾನಿ ಯಾರು?",
                    options = listOf("ಬಿ.ಎಫ್ ಸ್ಕಿನರ್", "ಪಾವಲೋವ", "ಹರ್ಬಾಟ್", "ಬೆಂಜಿಮಿನ ಬ್ಲೂಮ್"),
                    correctAnswer = "ಬಿ.ಎಫ್ ಸ್ಕಿನರ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬಿ.ಎಫ್ ಸ್ಕಿನರ್."
                ),
                QuestionModel(
                    id = "tet_sp_q21",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "21) ಕಲಿಕೆಯಲ್ಲಿ ಹಿಂದುಳಿದ ಮಕ್ಕಳಿಗೆ ಅವರ ಸಮಸ್ಯೆಗಳನ್ನು ಗುರುತಿಸಿ ವಿಶೇಷವಾದ ಬೋಧನಾ ಕಾರ್ಯವನ್ನು ನಡೆಸುವುದಕ್ಕೆ ಹೀಗೆನ್ನುವರು",
                    options = listOf("ಪರಿಹಾರ ಬೋಧನೆ", "ವೇಗ ವರ್ಧಕ ಬೋಧನೆ", "ಕ್ರಮಾನುಗತ ಬೋಧನೆ", "ಶಿಶು ಕೇಂದ್ರಿತ ಬೋಧನೆ"),
                    correctAnswer = "ಪರಿಹಾರ ಬೋಧನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಿಹಾರ ಬೋಧನೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q22",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "22) ಪಾಠ ಯೋಜನೆ ಮತ್ತು ಘಟಕ ಯೋಜನೆಗೆ ಸಂಬಂಧಪಟ್ಟಂತೆ ಸರಿಯಾದ ಹೇಳಿಕೆಯನ್ನು ಗುರುತಿಸಿ",
                    options = listOf(
                        "ಪಾಠ ಯೋಜನೆ ದೊಡ್ಡದು ಘಟಕ ಯೋಜನೆ ಚಿಕ್ಕದು",
                        "ಪಾಠ ಯೋಜನೆ ವಿಶಾಲ ವ್ಯಾಪ್ತಿಯನ್ನು ಹೊಂದಿದ್ದು ಘಟಕ ಯೋಜನೆ ಸಂಕುಚಿತ ವ್ಯಾಪ್ತಿಯನ್ನು ಹೊಂದಿದೆ",
                        "ಪಾಠ ಯೋಜನೆ ನಿರಂತರ ಮೌಲ್ಯಮಾಪನಕ್ಕೆ ಸಹಕಾರಿಯಾಗಿದೆ ಘಟಕ ಯೋಜನೆ ವ್ಯಾಪಕ ಮೌಲ್ಯಮಾಪನಕ್ಕೆ ಸಹಾಯವಾಗಿದೆ.",
                        "ಮೇಲಿನ ಎಲ್ಲಾ"
                    ),
                    correctAnswer = "ಪಾಠ ಯೋಜನೆ ನಿರಂತರ ಮೌಲ್ಯಮಾಪನಕ್ಕೆ ಸಹಕಾರಿಯಾಗಿದೆ ಘಟಕ ಯೋಜನೆ ವ್ಯಾಪಕ ಮೌಲ್ಯಮಾಪನಕ್ಕೆ ಸಹಾಯವಾಗಿದೆ.",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪಾಠ ಯೋಜನೆ ನಿರಂತರ ಮೌಲ್ಯಮಾಪನಕ್ಕೆ ಸಹಕಾರಿಯಾಗಿದೆ ಘಟಕ ಯೋಜನೆ ವ್ಯಾಪಕ ಮೌಲ್ಯಮಾಪನಕ್ಕೆ ಸಹಾಯವಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q23",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "23) ವರ್ಷವಿಡಿ ಇಡಿ ಪಠ್ಯ ವಿಷಯವನ್ನು ಬೋಧಿಸಲು ತಯಾರಿಸುವ ವಿಷಯವನ್ನು ಹಿಗೆನ್ನುವರು",
                    options = listOf("ಪಾಠ ಯೋಜನೆ", "ವಾರ್ಷಿಕ ಯೋಜನೆ", "ಘಟಕ ಯೋಜನೆ", "ಮಾಸಿಕ ಯೋಜನೆ"),
                    correctAnswer = "ವಾರ್ಷಿಕ ಯೋಜನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಾರ್ಷಿಕ ಯೋಜನೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q24",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "24) ಮಕ್ಕಳು ನೀರಿನ ಪ್ರಾಮುಖ್ಯತೆಯನ್ನು ಉದಾಹರಣೆ ಯೊಂದಿಗೆ ವಿವರಿಸುವುದು, ಇದು ಕೆಳಗಿನ ಯಾವ ಬೋಧನಾ ಉದ್ದೇಶವನ್ನು ಹೊಂದಿದೆ.",
                    options = listOf("ಜ್ಞಾನ", "ತಿಳುವಳಿಕೆ", "ಅನ್ವಯ", "ಕೌಶಲ್ಯ"),
                    correctAnswer = "ತಿಳುವಳಿಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತಿಳುವಳಿಕೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q25",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "25) ಮಕ್ಕಳು ನೀರನ್ನು ಶುದ್ಧಿಕರಿಸಲು ಬೇಕಾಗುವ ಸಲಕರಣೆಗಳನ್ನು ವ್ಯವಸ್ಥೆ ಮಾಡುವರು ಇದು ಯಾವ ಬೋಧನಾ ಉದ್ದೇಶವನ್ನು ಹೊಂದಿದೆ",
                    options = listOf("ಜ್ಞಾನ", "ತಿಳುವಳಿಕೆ", "ಅನ್ವಯ", "ಕೌಶಲ್ಯ"),
                    correctAnswer = "ಕೌಶಲ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೌಶಲ್ಯ."
                ),
                QuestionModel(
                    id = "tet_sp_q26",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "26) ವಿಜ್ಞಾನ ಕಿಟ್ನಲ್ಲಿರುವ ಸಾಮಗ್ರಿಯನ್ನು ಗುರುತಿಸಿ",
                    options = listOf("ಸ್ಪಿರೀಟ ದೀಪ", "ಡಂಬೆಲ್ಸ್", "ಬೆಲ್ಸ್", "ಲೆಜಿಮ್ಸ್"),
                    correctAnswer = "ಸ್ಪಿರೀಟ ದೀಪ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ಪಿರೀಟ ದೀಪ."
                ),
                QuestionModel(
                    id = "tet_sp_q27",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "27) ಈ ಕೆಳಗಿನ ಹೇಳಿಕೆಯಲ್ಲಿ ವಿಜ್ಞಾನ ಹವ್ಯಾಸಕ್ಕೆ ಸಂಬಂಧ ಪಟ್ಟಿದನ್ನು ಗುರುತಿಸಿ",
                    options = listOf(
                        "ವಿಜ್ಞಾನ ಉಪಕರಣ ಮಾದರಿಯನ್ನು ಸಂಗ್ರಹಿಸುವುದು",
                        "ವಿಜ್ಞಾನಕ್ಕೆ ಸಂಬಂಧಿಸಿದ ಚಿತ್ರಗಳನ್ನು ಬಿಡಿಸುವುದು",
                        "ಕುತುಹಲ ಕೆರಳಿಸುವ ಪ್ರಶ್ನೆಗಳಿಗೆ ಉತ್ತರಿಸುವುದು",
                        "ಮೇಲಿನ ಎಲ್ಲವೂ"
                    ),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_sp_q28",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "28) ನವೋದಯ ಶಾಲೆಗಳು ಈ ಕಾರಣಕ್ಕೆ ಹುಟ್ಟಿಕೊಂಡಿವೆ",
                    options = listOf(
                        "ಗ್ರಾಮೀಣ ಭಾಗದಲ್ಲಿ ಶಾಲೆಗಳ ಹೆಚ್ಚಳಕ್ಕೆ",
                        "ಗ್ರಾಮೀಣ ಭಾಗದಲ್ಲಿ ಒಳ್ಳೆಯ ಶಿಕ್ಷಣ ಕೊಡುವುದಕ್ಕೆ",
                        "ಸರ್ವ ಶಿಕ್ಷಣದ ಭಾಗವಾಗಿ",
                        "ಗ್ರಾಮೀಣ ಭಾಗದಲ್ಲಿ ಶಿಕ್ಷಣದ ಅಪವ್ಯಯ ತಡೆಯುವುದಕ್ಕೆ"
                    ),
                    correctAnswer = "ಗ್ರಾಮೀಣ ಭಾಗದಲ್ಲಿ ಶಿಕ್ಷಣದ ಅಪವ್ಯಯ ತಡೆಯುವುದಕ್ಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗ್ರಾಮೀಣ ಭಾಗದಲ್ಲಿ ಶಿಕ್ಷಣದ ಅಪವ್ಯಯ ತಡೆಯುವುದಕ್ಕೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q29",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "29) ಶಿಕ್ಷಣವು ಕಲಿಸುವಿಕೆಯಿಂದ",
                    options = listOf(
                        "ಇದು ಮಗು ಕೇಂದ್ರಿತ ಶಿಕ್ಷಣಕ್ಕೆ ಒತ್ತು ಕೊಡುತ್ತದೆ.",
                        "ಇದು ಶಿಕ್ಷಣದ ಅಮಲಾಗ್ರ ಬದಲಾವಣೆಗೆ ಕಾರಣ",
                        "ಇದು ಪರೀಕ್ಷಾ ಫಲಿತಾಂಶದ ಕಡೆಗೆ ಒತ್ತು ನೀಡುತ್ತದೆ",
                        "ಶಿಕ್ಷಕನ ಕಡೆಗೆ ಗಮನ ಕೊಡುತ್ತದೆ."
                    ),
                    correctAnswer = "ಇದು ಮಗು ಕೇಂದ್ರಿತ ಶಿಕ್ಷಣಕ್ಕೆ ಒತ್ತು ಕೊಡುತ್ತದೆ.",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಇದು ಮಗು ಕೇಂದ್ರಿತ ಶಿಕ್ಷಣಕ್ಕೆ ಒತ್ತು ಕೊಡುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q30",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "30) ಸಂಪೂರ್ಣ ಶಿಕ್ಷಣ ಪ್ರಕ್ರೀಯೆ ಇದಕ್ಕೆ ಒತ್ತು ಕೊಡುತ್ತದೆ.",
                    options = listOf(
                        "ತರಗತಿಯಲ್ಲಿ ವೈವಿಧ್ಯತೆಗೆ ಪ್ರದನ್ಯೆತೆ ನೀಡುತ್ತದೆ.",
                        "ಇದು ತರಗತಿಗೆ ಕರೋರ ನಿರ್ಧಾರವನ್ನು ನೀಡುತ್ತದೆ.",
                        "ಕಲ್ಪನೆಗಳನ್ನು ಒತ್ತಾಯ ಪೂರ್ವಕವಾಗಿ ನೀಡುತ್ತದೆ.",
                        "ತರಗತಿಯಲ್ಲಿ ಕೆಲವರಿಗೆ ಮಾತ್ರ ಮಹತ್ವ ನೀಡುವದು"
                    ),
                    correctAnswer = "ತರಗತಿಯಲ್ಲಿ ವೈವಿಧ್ಯತೆಗೆ ಪ್ರದನ್ಯೆತೆ ನೀಡುತ್ತದೆ.",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತರಗತಿಯಲ್ಲಿ ವೈವಿಧ್ಯತೆಗೆ ಪ್ರದನ್ಯೆತೆ ನೀಡುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q31",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "31) ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ವಸ್ತು ನಿಷ್ಟ ಪ್ರಶ್ನೆಗಳಾಗಿವೆ",
                    options = listOf(
                        "ಕಿರು ಉತ್ತರಗಳು",
                        "ಮೂರು ನಾಲ್ಕುವಾಕ್ಯದಲ್ಲಿ ಬರೆಯುವ ಉತ್ತರಗಳು",
                        "ಸರಿ ಅಥವಾ ತಪ್ಪು",
                        "ಚಿತ್ರ ಬರೆಯುವುದು"
                    ),
                    correctAnswer = "ಕಿರು ಉತ್ತರಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಿರು ಉತ್ತರಗಳು."
                ),
                QuestionModel(
                    id = "tet_sp_q32",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "32) ವಿಜ್ಞಾನ ಬೋಧನೆಯಲ್ಲಿ ಸಾಮಾಜಿಕರಣವೆಂದರೆ ಇದರ ಅರ್ಥ",
                    options = listOf(
                        "ತನದೆ ಆದ ಸಾಮಾಜಿಕ ಸ್ಥಾನ ಮಾನವನ್ನು ಹೊಂದುವದು",
                        "ಸಮಾಜದಲ್ಲಿ ದೊಡ್ಡವರಿಗೆ ಗೌರವ ಕೊಡುವುದು",
                        "ಸಮಾಜಕ್ಕೆ ತಕ್ಕರೀತಿ ಹೊಂದಿಕೊಳ್ಳುವುದು ಮತ್ತು ಸಮಾಜದ ಒಳಿತಿಗಾಗಿ ಕಾರ್ಯ ಮಾಡುವುದು",
                        "ಯಾವಾಗಲು ಸಮಾಜದ ಕಾರ್ಯ ಮಾಡುವುದು"
                    ),
                    correctAnswer = "ಸಮಾಜಕ್ಕೆ ತಕ್ಕರೀತಿ ಹೊಂದಿಕೊಳ್ಳುವುದು ಮತ್ತು ಸಮಾಜದ ಒಳಿತಿಗಾಗಿ ಕಾರ್ಯ ಮಾಡುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಮಾಜಕ್ಕೆ ತಕ್ಕರೀತಿ ಹೊಂದಿಕೊಳ್ಳುವುದು ಮತ್ತು ಸಮಾಜದ ಒಳಿತಿಗಾಗಿ ಕಾರ್ಯ ಮಾಡುವುದು."
                ),
                QuestionModel(
                    id = "tet_sp_q33",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "33) ವಿಜ್ಞಾನ ಶಿಕ್ಷಕನು ತನ್ನ ತರಗತಿಯಲ್ಲಿ ಮಕ್ಕಳಿಗೆ ನೇರವಾಗಿ ಪ್ರಶ್ನೆಗಳಿಗೆ ಉತ್ತರ ಕೊಡದೆ ಅವರಲ್ಲಿಯ ಗುಂಪಿನಲ್ಲಿ ಚರ್ಚಿಸಿ ತಿರ್ಮಾನಕ್ಕೆ ಬರಲು ಸೂಚಿಸುವ ವಿಧಾನವು",
                    options = listOf(
                        "ಮಕ್ಕಳಲ್ಲಿ ಒಳ್ಳೆಯ ಗುಣಗಳನ್ನು ಬೆಳಸುವುದು",
                        "ಶಿಕ್ಷಕನಿಗೆ ಉತ್ತರದ ಮಾಹಿತಿ ಹೊಂದದ ಕಾರಣ",
                        "ಮಕ್ಕಳ ಮುಕ್ತ ಭಾಗವಹಿಸುವಿಕೆ ಹೆಚ್ಚಿಸುವುದು",
                        "ಕಲಿಕೆಯ ವೇಗ ಹೆಚ್ಚಲು"
                    ),
                    correctAnswer = "ಮಕ್ಕಳ ಮುಕ್ತ ಭಾಗವಹಿಸುವಿಕೆ ಹೆಚ್ಚಿಸುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಕ್ಕಳ ಮುಕ್ತ ಭಾಗವಹಿಸುವಿಕೆ ಹೆಚ್ಚಿಸುವುದು."
                ),
                QuestionModel(
                    id = "tet_sp_q34",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "34) ವಿಜ್ಞಾನ ಬೋಧನೆಯಲ್ಲಿ ಕೆಳಗಿನ ಯಾವ ಅಂಶ ಶಿಕ್ಷಕನ ಕುರಿತಾಗಿದೆ",
                    options = listOf(
                        "ವ್ಯವಸ್ಥಿತ ಕುಡುವ ವ್ಯವಸ್ಥೆ",
                        "ಒಳ್ಳೆಯ ಪಠ್ಯ ಪುಸ್ತಕ",
                        "ಪಠ್ಯಪುಸ್ತಕ ಹೊಂದಿರುವ ವಿಷಯಗಳು",
                        "ವಿಷಯದ ಬಗ್ಗೆ ಸಂಪೂರ್ಣ ಹಿಡಿತ"
                    ),
                    correctAnswer = "ವಿಷಯದ ಬಗ್ಗೆ ಸಂಪೂರ್ಣ ಹಿಡಿತ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಷಯದ ಬಗ್ಗೆ ಸಂಪೂರ್ಣ ಹಿಡಿತ."
                ),
                QuestionModel(
                    id = "tet_sp_q35",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "35) ವಿದ್ಯಾರ್ಥಿಯ ವ್ಯಕ್ತಿತ್ವವು ಇದರ ಫಲಿತಾಂಶವಾಗಿದೆ",
                    options = listOf(
                        "ಅವನು ಪಡೆದ ಶಿಕ್ಷಣದಿಂದ",
                        "ಅವನ ಪರಿಸರದಿಂದ",
                        "ಅವನು ಅನವಂಶಿಯ ಗುಣದಿಂದ",
                        "ಅವನ ಪರಿಸರ ಮತ್ತು ಅನುವಂಶಿಯ ಗುಣದಿಂದ"
                    ),
                    correctAnswer = "ಅವನ ಪರಿಸರ ಮತ್ತು ಅನುವಂಶಿಯ ಗುಣದಿಂದ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅವನ ಪರಿಸರ ಮತ್ತು ಅನುವಂಶಿಯ ಗುಣದಿಂದ."
                ),
                QuestionModel(
                    id = "tet_sp_q36",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "36) ವಿಜ್ಞಾನದ ವಿಷಯದಲ್ಲಿ ಸಮಸ್ಯೆ ಪರಿಹಾರ ಪದ್ಧತಿಯಲ್ಲಿ ಈ ಕೆಳಗಿನ ಯಾವು ಹಂತವು ಮೊದಲನೆಯದಾಗಿದೆ.",
                    options = listOf("ಕಲ್ಪನೆಗಳ ಬಗ್ಗೆ ಮಾಹಿತಿ", "ಸಮಸ್ಯೆಯ ಅರಿವು", "ಸಂಪೂರ್ಣ ಮಾಹಿತಿ ಸಂಗ್ರಹಣ", "ವಿಧಾನವನ್ನು ತಿಳಿಯುವುದು"),
                    correctAnswer = "ಸಮಸ್ಯೆಯ ಅರಿವು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಮಸ್ಯೆಯ ಅರಿವು."
                ),
                QuestionModel(
                    id = "tet_sp_q37",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "37) ಮಗು “ಫೇಲಾಗಿದೆ” ಎಂದರೆ ಇದರ ಅರ್ಥ",
                    options = listOf(
                        "ಮಗುವಿಗೆ ಉತ್ತರಗಳನ್ನು ಹೆಳಲು ಬರುವುದಿಲ್ಲ",
                        "ಮಗುವಿಗೆ ಓದಲು ಬರುವುದಿಲ್ಲ",
                        "ಮಗುವಿಗೆ ಓದಲು ಆಸಕ್ತಿ ಇಲ್ಲ",
                        "ಶಿಕ್ಷಣ ವ್ಯವಸ್ಥೆ ಫೇಲಾಗಿದೆ"
                    ),
                    correctAnswer = "ಶಿಕ್ಷಣ ವ್ಯವಸ್ಥೆ ಫೇಲಾಗಿದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶಿಕ್ಷಣ ವ್ಯವಸ್ಥೆ ಫೇಲಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q38",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "38) ವಿಜ್ಞಾನ ಬೋಧನೆಯ ಗುರಿ ಇದಾಗಿದೆ",
                    options = listOf(
                        "ವಿಷಯದ ಪರಿಕಲ್ಪನೆಯನ್ನು ತಿಳಿಸುವುದು",
                        "ಮಕ್ಕಳನ್ನು ಕಲಿಕೆಯಲ್ಲಿ ಪಾಲ್ಗೋಳ್ಳುವಂತೆ ಮಾಡುವುದು",
                        "ಜ್ಞಾನವನ್ನು ನೀಡುವುದು",
                        "ಮಗುವಿನಲ್ಲಿ ಅಪೇಕ್ಷಿತ ಬದಲಾವಣೆಯನ್ನು ತರುವುದು"
                    ),
                    correctAnswer = "ಮಗುವಿನಲ್ಲಿ ಅಪೇಕ್ಷಿತ ಬದಲಾವಣೆಯನ್ನು ತರುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಗುವಿನಲ್ಲಿ ಅಪೇಕ್ಷಿತ ಬದಲಾವಣೆಯನ್ನು ತರುವುದು."
                ),
                QuestionModel(
                    id = "tet_sp_q39",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "39) SOIO ವರ್ಗೀಕರಣವನ್ನು ನೀಡಿದವರು",
                    options = listOf("ಭ್ಲೂಮ", "ವೋಲರ", "ಸಿಂಪಸನ್", "ಬೀಗ್ಸ ಮತ್ತು ಕೂಲಿಸ"),
                    correctAnswer = "ಬೀಗ್ಸ ಮತ್ತು ಕೂಲಿಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೀಗ್ಸ ಮತ್ತು ಕೂಲಿಸ."
                ),
                QuestionModel(
                    id = "tet_sp_q40",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "40) ಹಿರೊಸ್ಟಿಕ್ ಇದರ ಅರ್ಥ",
                    options = listOf("ಸಂಶೋಧಿಸು", "ತೋರಿಸು", "ಮಾಡು", "ನಟಿಸು"),
                    correctAnswer = "ಸಂಶೋಧಿಸು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಂಶೋಧಿಸು."
                ),
                QuestionModel(
                    id = "tet_sp_q41",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "41) ವೈಜ್ಞಾನಿಕ ಚಟುವಟಿಕೆಗಳು ಎನನ್ನು ಹೊಂದಿರುತ್ತವೆ",
                    options = listOf("ದೈಯಿಕ ಶಿಕ್ಷಣ", "ಮಾನಸಿಕ ಶಿಕ್ಷಣ", "ಮನೋವಿಜ್ಞಾನ", "ಧೈಹಿಕ ಮತ್ತು ಮಾನಸಿಕ ಶಿಕ್ಷಣ"),
                    correctAnswer = "ಧೈಹಿಕ ಮತ್ತು ಮಾನಸಿಕ ಶಿಕ್ಷಣ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಧೈಹಿಕ ಮತ್ತು ಮಾನಸಿಕ ಶಿಕ್ಷಣ."
                ),
                QuestionModel(
                    id = "tet_sp_q42",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "42) ಎನ್ಸಿಎಫ್ 2005ರ ಪ್ರಕಾರರ ಪರಿಸರ ಶಿಕ್ಷಣದ ಆಧಾರ ತತ್ವ",
                    options = listOf(
                        "ಜ್ಞಾನವನ್ನು ವೃತ್ತ ಜೀವನಕ್ಕೆ ಸಂಬಂಧ ಕಲ್ಪಿಸುವುದು",
                        "ಜ್ಞಾನವನ್ನು ಶಾಲೆಯ ಹೊರಗಿನ ಜೀವನಕ್ಕೆ ಸಂಬಂಧ ಕಲ್ಪಿಸುವುದು",
                        "ಜ್ಞಾನವನ್ನು ಔದ್ಯೋಗಿಕ ಜೀವನಕ್ಕೆ ಸಂಬಂಧ ಕಲ್ಪಿಸುವುದು",
                        "ಜ್ಞಾನವನ್ನು ಪರೀಕ್ಷೆಗೆ ಸಂಬಂಧ ಕಲ್ಪಿಸುವುದು"
                    ),
                    correctAnswer = "ಜ್ಞಾನವನ್ನು ಶಾಲೆಯ ಹೊರಗಿನ ಜೀವನಕ್ಕೆ ಸಂಬಂಧ ಕಲ್ಪಿಸುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜ್ಞಾನವನ್ನು ಶಾಲೆಯ ಹೊರಗಿನ ಜೀವನಕ್ಕೆ ಸಂಬಂಧ ಕಲ್ಪಿಸುವುದು."
                ),
                QuestionModel(
                    id = "tet_sp_q43",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "43) ಸಸ್ಯದ ಬೆಳವಣಿಗೆಯ ಪರಿಕಲ್ಪನೆಯನ್ನು ಶಿಕ್ಷಕರು ತರಗತಿಯಲ್ಲಿ ಪರಿಣಾಮಕಾರಿಯಾಗಿ ಬೋಧಿಸಲು ಅತ್ಯುತ್ತಮ ವಿಧಾನ",
                    options = listOf(
                        "ಕಪ್ಪುಹಲಗೆಯ ಮೇಲೆ ಚಿತ್ರ ಬಿಡಿಸಿ ವಿವರಿಸುವುದು",
                        "ವಿವರವಾದ ವಿವರಣೆ ನೀಡುವುದು",
                        "ಸಸ್ಯದ ಬೆಳವಣಿಗೆಯನ್ನು ಚಿತ್ರಪಟದ ಮೂಲಕ ತೋರಿಸುವುದು",
                        "ಮಕ್ಕಳು ಬೀಜಗಳನ್ನು ಬಿತ್ತಿ ಅವು ಮೊಳಕೆ ಯೊಡೆದು ಸಸಿಯಾಗುವುದನ್ನು ಅವಲೋಕಿಸುವುದು"
                    ),
                    correctAnswer = "ಮಕ್ಕಳು ಬೀಜಗಳನ್ನು ಬಿತ್ತಿ ಅವು ಮೊಳಕೆ ಯೊಡೆದು ಸಸಿಯಾಗುವುದನ್ನು ಅವಲೋಕಿಸುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಕ್ಕಳು ಬೀಜಗಳನ್ನು ಬಿತ್ತಿ ಅವು ಮೊಳಕೆ ಯೊಡೆದು ಸಸಿಯಾಗುವುದನ್ನು ಅವಲೋಕಿಸುವುದು."
                ),
                QuestionModel(
                    id = "tet_sp_q44",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "44) ಸಂದರ್ಭೋಚಿತ ಕಲಿಕೆಯು ಬೋಧನೆ ಮತ್ತು ಕಲಿಕೆಯು",
                    options = listOf(
                        "ಮಾಧ್ಯಮಿಕ ಸಿದ್ದಾಂತವನ್ನು ಆಧರಿಸಿದೆ",
                        "ಅನ್ವೇಷಣಾತ್ಮಕ ಸಿದ್ದಾಂತವನ್ನು ಆಧರಿಸಿದೆ",
                        "ಸಾಂಸ್ಕ್ರತಿಕ ಸಿದ್ಧಾಂತವನ್ನು ಆಧರಿಸಿದೆ",
                        "ರಚನಾತ್ಮಕ ಸಿದ್ದಾಂತವನ್ನು ಆಧರಿಸಿದೆ"
                    ),
                    correctAnswer = "ರಚನಾತ್ಮಕ ಸಿದ್ದಾಂತವನ್ನು ಆಧರಿಸಿದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರಚನಾತ್ಮಕ ಸಿದ್ದಾಂತವನ್ನು ಆಧರಿಸಿದೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q45",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "45) ಪರಿಸರದ ಸೌಂದರ್ಯವನ್ನು ವರ್ಣಿಸುವ ಮೌಲ್ಯವೇ",
                    options = listOf("ನೈತಿಕ ಮೌಲ್ಯ", "ಸೌಂದರ್ಯಾತ್ಮಕ ಮೌಲ್ಯ", "ಧಾರ್ಮಿಕ ಮೌಲ್ಯ", "ಆರ್ಥಿಕ ಮೌಲ್ಯ"),
                    correctAnswer = "ಸೌಂದರ್ಯಾತ್ಮಕ ಮೌಲ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೌಂದರ್ಯಾತ್ಮಕ ಮೌಲ್ಯ."
                ),
                QuestionModel(
                    id = "tet_sp_q46",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "46) ಪರಿಸರ ಅಧ್ಯಯನದಲ್ಲಿ ಮಕ್ಕಳ ಮನೋಧೋರಣೆಗಳು ಮತ್ತು ಮೌಲ್ಯಗಳಲ್ಲಿನ ಬದಲಾವಣೆಗಳನ್ನು ಅಳೆಯುವ ಸೂಕ್ತ ವಿಧಾನ",
                    options = listOf(
                        "ರೂಪಣಾತ್ಮಕ ವಿಧಾನ",
                        "ಸಂಕಲನಾತ್ಮಕ ವಿಧಾನ",
                        "ರೂಪಣಾತ್ಮಕ ಮತ್ತು ಸಂಕಲನಾತ್ಮಕ ವಿಧಾನ",
                        "ಸಂಕಲನಾತ್ಮಕ ವಿಧಾನ ಮತ್ತು ಸೃಜನಾತ್ಮಕ ವಿಧಾನ"
                    ),
                    correctAnswer = "ರೂಪಣಾತ್ಮಕ ಮತ್ತು ಸಂಕಲನಾತ್ಮಕ ವಿಧಾನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರೂಪಣಾತ್ಮಕ ಮತ್ತು ಸಂಕಲನಾತ್ಮಕ ವಿಧಾನ."
                ),
                QuestionModel(
                    id = "tet_sp_q47",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "47) ವಿಜ್ಞಾನ ವಿಷಯವು ದಿನನಿತ್ಯದ ಅನುಭವಗಳನ್ನು ಪರೀಕ್ಷಿಸಿ ವಿಶ್ಲೇಷಿಸುವ ಅವಕಾಶ ನೀಡಬೇಕು ಎಂದು .......... ತಿಳಿಸುತ್ತದೆ",
                    options = listOf("ಎನ್ ಸಿ ಟಿ ಇ", "ಆರ್ ಟಿ ಐ-2005", "ಎನ್ ಸಿ ಎಫ್-2005", "ಆರ್.ಟಿ.ಐ-2009"),
                    correctAnswer = "ಎನ್ ಸಿ ಎಫ್-2005",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎನ್ ಸಿ ಎಫ್-2005."
                ),
                QuestionModel(
                    id = "tet_sp_q48",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "48) ಒಬ್ಬ ವಿದ್ಯಾರ್ಥಿಯು ಪ್ರಯೋಗವನ್ನು ನಡೆಸಲು ಸೂಕ್ತ ಪ್ರಯೋಗದ ಉಪಕರಣಗಳನ್ನು ಆಯ್ಕೆ ಮಾಡುವನು, ಪ್ರಯೋಗವನ್ನು ಹೊಂದಿಸುವನು ಮತ್ತು ನಿರ್ವಹಿಸುವನು",
                    options = listOf("ತಿಳುವಳಿಕೆ", "ಅನ್ವಯ", "ಕೌಶಲ್ಯ", "ಆಸಕ್ತಿ"),
                    correctAnswer = "ಕೌಶಲ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೌಶಲ್ಯ."
                ),
                QuestionModel(
                    id = "tet_sp_q49",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "49) ರಚನಾವಾದದ ‘5 ಇ’ಗಳಲ್ಲಿ ಕೆಳಗಿನ ಯಾವ ಇ ಇದಕ್ಕೆ ಸಂಬಂಧಿಸಿರುವುದಿಲ್ಲ",
                    options = listOf("ಎಂಗೇಜ್", "ಎಕ್ಸ್ ಫ್ಲೋರ್", "ಎಕ್ಸ್ ಪ್ರೆಸ್", "ಎಮೋಷನಲ್"),
                    correctAnswer = "ಎಮೋಷನಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎಮೋಷನಲ್."
                ),
                QuestionModel(
                    id = "tet_sp_q50",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "50) 10ನೇ ತರಗತಿಯ ವಿದ್ಯಾರ್ಥಿಯು ಮೆದುಳಿನ ಚಿತ್ರ ಬರೆದು ಭಾಗಗಳನ್ನು ಗುರುತಿಸುವಲ್ಲಿ ಸಮಸ್ಯೆಯನ್ನು ಎದುರಿಸುತ್ತಿದ್ದಾನೆ ಈ ಸಮಸ್ಯೆ ಪರಿಹಾರಕ್ಕೆ ಸೂಕ್ತ ಕ್ರಮ",
                    options = listOf("ಮರು ಬೋಧನೆ", "ಪರಿಹಾರ ಬೋಧನೆ", "ಪೂರಕ ಬೋಧನೆ", "ಕ್ರಿಯಾ ಸಂಶೋಧನೆ"),
                    correctAnswer = "ಪರಿಹಾರ ಬೋಧನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಿಹಾರ ಬೋಧನೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q51",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "51) ವಿವಿಧ ಸಸ್ಯಗಳ ಎಲೆಗಳನ್ನು ಸಂಗ್ರಹಿಸಿ ಅವುಗಳ ರಚನೆಯನ್ನು ಅಭ್ಯಸಿಸಿ ಪಟ್ಟಿ ಮಾಡಿ ವರದಿ ತಯ್ಯಾರಿಸಲು ಶಿಕ್ಷಕರು ಮಕ್ಕಳಿಗೆ ಚಟುವಟಿಕೆ ನೀಡುತ್ತಾರೆ ಇದು ಯಾವ ಒಂದು ಬೋಧನಾ ವಿಧಾನದ ಅಡಿಯಲ್ಲಿ ಬರುತ್ತದೆ",
                    options = listOf("ಯೋಜನಾ ವಿಧಾನ", "ಸಮಸ್ಯಾ ಪರಿಹಾರ ವಿಧಾನ", "ಚರ್ಚಾ ವಿಧಾನ", "ಪ್ರಾಯೋಗಿಕ ವಿಧಾನ"),
                    correctAnswer = "ಯೋಜನಾ ವಿಧಾನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯೋಜನಾ ವಿಧಾನ."
                ),
                QuestionModel(
                    id = "tet_sp_q52",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "52) ಒಬ್ಬ ಉತ್ತಮ ವಿಜ್ಞಾನ ಶಿಕ್ಷಕನು ಶೈಕ್ಷಣಿಕ ವರ್ಷದ ಪ್ರಾರಂಭದಲ್ಲಿಯೆ ಸಿದ್ದಪಡಿಸಿ ಕೊಳ್ಳಬೇಕಾದ ದಾಖಲೆಗಳು:\nಅ) ವಾರ್ಷಿಕ ಪಾಠ ಯೋಜನೆ\nಬಿ) ಸಂಪನ್ಮೂಲ ಘಟಕ ಯೋಜನೆ\nಸಿ) ಘಟಕ ಯೋಜನೆ\nಡಿ) ಕ್ರಿಯಾಯೋಜನೆ",
                    options = listOf("ಅ) ಬಿ) ಡಿ)", "ಬಿ) ಸಿ) ಡಿ)", "ಅ) ಸಿ) ಡಿ)", "ಅ) ಬಿ) ಸಿ)"),
                    correctAnswer = "ಅ) ಸಿ) ಡಿ)",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅ) ಸಿ) ಡಿ)."
                ),
                QuestionModel(
                    id = "tet_sp_q53",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "53) ಬೆಳಕಿನಲ್ಲಿ ಏಳು ಬಣ್ಣಗಳಿವೆ ಎಂಬುದನ್ನು ಪ್ರಾಯೋಗಿಕವಾಗಿ ತಿಳಿಸಲು ಬಳಸಬಹುದಾದ ಪರಿಣಾಮಕಾರಿ ಬೋಧನಾ ಕಲಿಕೋಪಕರಣ",
                    options = listOf("ಗಾಜಿನ ಪಟ್ಟಕ", "ಕಾಮನ ಬಿಲ್ಲು", "ನೀರಿನ ಮೇಲೆ ಬಿದ್ದ ಬೆಳಕಿನ ಕಿರಣಗಳು", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಗಾಜಿನ ಪಟ್ಟಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗಾಜಿನ ಪಟ್ಟಕ."
                ),
                QuestionModel(
                    id = "tet_sp_q54",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "54) ವಿಜ್ಞಾನದಲ್ಲಿ ಕೌಶಲ ಎಂದರೆ ಈ ಮೂರು ಕ್ರಿಯೆಗಳ ಸಂಗಮ",
                    options = listOf("ಜ್ಞಾನ+ಸಾಮಥ್ರ್ಯ+ಅಭ್ಯಾಸ", "ಜ್ಞಾನ್+ಸಾಮಥ್ರ್ಯ+ತಿಳುವಳಿಕೆ", "ಜ್ಞಾನ್+ತಿಳುವಳಿಕೆ+ಆಸಕ್ತಿ", "ಜ್ಞಾನ್+ಸಾಮಥ್ರ್ಯ+ಪ್ರಶಂಸೆ"),
                    correctAnswer = "ಜ್ಞಾನ+ಸಾಮಥ್ರ್ಯ+ಅಭ್ಯಾಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜ್ಞಾನ+ಸಾಮಥ್ರ್ಯ+ಅಭ್ಯಾಸ."
                ),
                QuestionModel(
                    id = "tet_sp_q55",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "55) ಸಮ್ಮೇಳನಲ್ಲಿ ಭಾಗವಹಿಸುವ ವ್ಯಕ್ತಿಗಳೊಡನೆ ಕುಳಿತಲ್ಲಿಂದಲೇ ಮುಖತ: ಸಂವಾದ ಮಾಡಬಹುದಾದ",
                    options = listOf("ವೀಡಿಯೋ ಕಾನ್ಫರೆನ್ಸ್", "ಟೆಲಿಕಾನ್ ಫರೆನ್ಸ್", "ಟೆಲಿವಿಷನ್ ಕಾನ್ಫರೆನ್ಸ್", "ವೀಡಿಯೋ ರೆಕಾರ್ಡಿಂಗ್ ಕಾನ್ಫರೆನ್ಸ್"),
                    correctAnswer = "ವೀಡಿಯೋ ಕಾನ್ಫರೆನ್ಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವೀಡಿಯೋ ಕಾನ್ಫರೆನ್ಸ್."
                ),
                QuestionModel(
                    id = "tet_sp_q56",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "56) ಒಬ್ಬ ವಿದ್ಯಾರ್ಥಿಯು ಪ್ರಯೋಗವನ್ನು ನಡೆಸಲು ಸೂಕ್ತ ಪ್ರಯೋಗದ ಉಪಕರಣಗಳನ್ನು ಆಯ್ಕೆ ಮಾಡುವನು, ಪ್ರಯೋಗವನ್ನು ಹೊಂದಿಸುವನು ಮತ್ತು ನಿರ್ವಹಿಸುವನು ಇದು. .......................",
                    options = listOf("ತಿಳುವಳಿಕೆ", "ಅನ್ವಯ", "ಕೌಶಲ್ಯ", "ಆಸಕ್ತಿ"),
                    correctAnswer = "ಕೌಶಲ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೌಶಲ್ಯ."
                ),
                QuestionModel(
                    id = "tet_sp_q57",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "57) ಭಿನ್ನ ಸಾಮಥ್ರ್ಯವುಳ್ಳ ವಿದ್ಯಾರ್ಥಿಗಳಿಗಾಗಿ ಪರ್ಯಾಯ ಮೌಲ್ಯಮಾಪನ ಕ್ರಮಗಳು ಅಗತ್ಯ ಏಕೆಂದರೆ",
                    options = listOf(
                        "ಮೌಲ್ಯಮಾಪನ ಸುಲಭ",
                        "ವ್ಯಕ್ತಿ ಭಿನ್ನತೆಯನ್ನು ಗೌರವಿಸುವುದು",
                        "ಎಲ್ಲರನ್ನೂ ತೇರ್ಗಡೆ ಮಾಡಲು",
                        "ಸಾಧಾರಣ ಮಕ್ಕಳ ವೇಗದಲ್ಲಿ ಅವರು ಉತ್ತರಿಸಲಾರರು"
                    ),
                    correctAnswer = "ವ್ಯಕ್ತಿ ಭಿನ್ನತೆಯನ್ನು ಗೌರವಿಸುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವ್ಯಕ್ತಿ ಭಿನ್ನತೆಯನ್ನು ಗೌರವಿಸುವುದು."
                ),
                QuestionModel(
                    id = "tet_sp_q58",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "58) ಶಿಕ್ಷಕರು ತಮ್ಮ ಸೇವಾ ಅವಧಿಯಲ್ಲಿ ದಿನನಿತ್ಯ ತರಗತಿ ಕಲಿಕೆಯನ್ನು ಪರಿಣಾಮಕಾರಿಯಾಗಿಸಲು ನಿರ್ವಹಿಸುವ ದಾಖಲೆ",
                    options = listOf("ಪಾಠ ಯೋಜನೆ", "ದಿನಚರಿ", "ಚಿಂತನಾಶೀಲ ಜರ್ನಲ್", "ವರದಿ"),
                    correctAnswer = "ಚಿಂತನಾಶೀಲ ಜರ್ನಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚಿಂತನಾಶೀಲ ಜರ್ನಲ್."
                ),
                QuestionModel(
                    id = "tet_sp_q59",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "59) 4ನೇ ತರಗತಿಯ ವಿದ್ಯಾರ್ಥಿಯು ಸಸ್ಯದ ಚಿತ್ರ ಬರೆದು ಭಾಗಗಳನ್ನು ಗುರುತಿಸುವಲ್ಲಿ ಸಮಸ್ಯೆಯನ್ನು ಎದುರಿಸುತ್ತಿದ್ದಾನೆ. ಈ ಸಮಸ್ಯೆ ಪರಿಹಾರಕ್ಕೆ ಸೂಕ್ತ ಕ್ರಮ",
                    options = listOf("ಮರು ಬೋಧನೆ", "ಪರಿಹಾರ ಬೋಧನೆ", "ಪೂರಕ ಬೋಧನೆ", "ಕ್ರಿಯಾ ಸಂಶೋಧನೆ"),
                    correctAnswer = "ಕ್ರಿಯಾ ಸಂಶೋಧನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ರಿಯಾ ಸಂಶೋಧನೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q60",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "60) ವಿವಿಧ ಸಸ್ಯಗಳ ಎಲೆಗಳನ್ನು ಸಂಗ್ರಹಿಸಿ ಅವುಗಳ ರಚನೆಯನ್ನು ಅಭ್ಯಸಿಸಿ ಪಟ್ಟಿ ಮಾಡಿ ವರದಿ ತಯ್ಯಾರಿಸಲು ಶಿಕ್ಷಕರು ಮಕ್ಕಳಿಗೆ ಚಟುವಟಿಕೆ ನೀಡುತ್ತಾರೆ ಇದು ಯಾವ ಒಂದು ಬೋಧನಾ ವಿಧಾನದ ಅಡಿಯಲ್ಲಿ ಬರುತ್ತದೆ.",
                    options = listOf("ಯೋಜನಾ ವಿಧಾನ", "ಸಮಸ್ಯಾ ಪರಿಹಾರ ವಿಧಾನ", "ಚರ್ಚಾ ವಿಧಾನ", "ಪ್ರಾಯೋಗಿಕ ವಿಧಾನ"),
                    correctAnswer = "ಯೋಜನಾ ವಿಧಾನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯೋಜನಾ ವಿಧಾನ."
                ),
                QuestionModel(
                    id = "tet_sp_q61",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "61) “5ಇ” ಮಾದರಿಯ ಬೋಧನಾ ವಿಧಾನವು .............. ತತ್ವದ ಮೇಲೆ ರೂಪಿತಗೊಂಡಿವೆ",
                    options = listOf("ರಚನಾವಾದ", "ಪ್ರತ್ಯಕ್ಷ ವಿಧಾನ", "ವಿಷಯಧಾರಿತ ವಿಧಾನ", "ಸಂವಹನ ವಿಧಾನ"),
                    correctAnswer = "ರಚನಾವಾದ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರಚನಾವಾದ."
                ),
                QuestionModel(
                    id = "tet_sp_q62",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "62) “5ಇ” ಮಾದರಿಯ ಬೋಧನಾ ವಿಧಾನದಲ್ಲಿ ಮಕ್ಕಳು ಪರಿಶೋಧಿಸಿದ ಉತ್ತರವನ್ನು ಮಂಡನೆ ಮಾಡಲು ಅವಕಾಶ ನೀಡುವ ಹಂತ ...................",
                    options = listOf("ತೊಡಗಿಸಿಕೊಳ್ಳುವಿಕೆ", "ವಿವರಣಾ", "ವಿಸ್ತರಿಸು", "ಮೌಲ್ಯಮಾಪನ"),
                    correctAnswer = "ವಿಸ್ತರಿಸು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಸ್ತರಿಸು."
                ),
                QuestionModel(
                    id = "tet_sp_q63",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "63) ಸಂದರ್ಭೋಚಿತ ಕಲಿಕೆಯು ಬೋಧನೆ ಮತ್ತು ಕಲಿಕೆಯ ರಚನಾತ್ಮಕ ಸಿದ್ದಾಂತವನ್ನು ಆಧರಿಸಿದೆ ಶಿಕ್ಷಕರು ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ತಮ್ಮ ಅನುಭವ/ಪರಿಸರದ ಸಮಸ್ಯೆಗಳ ಬಗ್ಗೆ............ಬೆಳೆಸುವುದು",
                    options = listOf("ವೀಕ್ಷಣೆ", "ವಿವರಣೆ", "ಜಾಗೃತಿ", "ಅನುಭವ"),
                    correctAnswer = "ಜಾಗೃತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಾಗೃತಿ."
                ),
                QuestionModel(
                    id = "tet_sp_q64",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "64) “5ಇ” ಗಳನ್ನು ಕ್ರಮಬದ್ಧವಾಗಿ ಜೋಡಿಸುವುದು ..................",
                    options = listOf(
                        "ತೊಡಗಿಸಿಕೊಳ್ಳುವುದು, ಅನ್ವೇಷಣೆ, ವಿವರಣೆ, ವಿಸ್ತರಣೆ, ಮೌಲ್ಯಯಮಾಪನ",
                        "ವಿವರಣೆ, ವಿಸ್ತರಣೆ, ಮೌಲ್ಯಮಾಪನ, ತೊಡಗಿಸಿಕೊಳ್ಳುವುದು, ಮೌಲ್ಯಮಾಪನ",
                        "ಅನ್ವೇಷಣೆ, ವಿಸ್ತರಣೆ, ವಿವರಣೆ, ತೊಡಗಿಸಿಕೊಳ್ಳುವುದು, ಮೌಲ್ಯಮಾಪನ",
                        "ತೊಡಗಿಸಿಕೊಳ್ಳುವುದು, ವಿವರಣೆ, ವಿಸ್ತರಣೆ, ಅನ್ವೇಷಣೆ, ಮೌಲ್ಯಮಾಪನ"
                    ),
                    correctAnswer = "ತೊಡಗಿಸಿಕೊಳ್ಳುವುದು, ಅನ್ವೇಷಣೆ, ವಿವರಣೆ, ವಿಸ್ತರಣೆ, ಮೌಲ್ಯಯಮಾಪನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತೊಡಗಿಸಿಕೊಳ್ಳುವುದು, ಅನ್ವೇಷಣೆ, ವಿವರಣೆ, ವಿಸ್ತರಣೆ, ಮೌಲ್ಯಯಮಾಪನ."
                ),
                QuestionModel(
                    id = "tet_sp_q65",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "65) ಈ ಭೂಮಿಯು ಈ ಪೀಳಿಗೆಯವರಿಗೆ ಮಾತ್ರವಲ್ಲ, ಮುಂದಿನ ಪೀಳಿಗೆಯವರಿಗೂ ಸೇರಿದೆ. ಈ ತಿಳುವಳಿಕೆಯು ................. ಮೌಲ್ಯವನ್ನು ವಿವರಿಸುತ್ತದೆ",
                    options = listOf("ಸನ್ನಡತೆಯ", "ನೈತಿಕ", "ಮತೀಯ", "ಸೌಂದರ್ಯಾತ್ಮಕ"),
                    correctAnswer = "ನೈತಿಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೈತಿಕ."
                ),
                QuestionModel(
                    id = "tet_sp_q66",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "66) ನಿರಂತರ ಮತ್ತು ಸಮಗ್ರ ಮೌಲ್ಯಮಾಪನವು ................ .ನ್ನು ಒಳಗೊಂಡಿದೆ",
                    options = listOf(
                        "ರೂಪಣಾತ್ಮಕ ಮೌಲ್ಯಮಾಪನ",
                        "ಸಂಕಲನಾತ್ಮಕ ಮೌಲ್ಯಮಾಪನ",
                        "ರೂಪಣಾತ್ಮಕ ಮೌಲ್ಯಮಾಪನ ಹಾಗೂ ಸಂಕಲನಾತ್ಮಕ ಮೌಲ್ಯಮಾಪನ",
                        "ಮೌಲ್ಯಮಾಪನ"
                    ),
                    correctAnswer = "ರೂಪಣಾತ್ಮಕ ಮೌಲ್ಯಮಾಪನ ಹಾಗೂ ಸಂಕಲನಾತ್ಮಕ ಮೌಲ್ಯಮಾಪನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರೂಪಣಾತ್ಮಕ ಮೌಲ್ಯಮಾಪನ ಹಾಗೂ ಸಂಕಲನಾತ್ಮಕ ಮೌಲ್ಯಮಾಪನ."
                ),
                QuestionModel(
                    id = "tet_sp_q67",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "67) ದಕ್ಷಿಣ ಕನ್ನಡ ಜಿಲ್ಲೆಯ ಗೋಡಂಬಿ ತೋಟಗಳಲ್ಲಿ ಎಂಡೋಸಲ್ಫಾನ್ ಎಂಬ ರಸಾಯನಿಕ ವಸ್ತು ಸಿಂಪಡಿಕೆಯಿಂದ ಅಲ್ಲಿನ ಜನರ ಮೇಲೆ ಭಾರಿ ದುಷ್ಪರಿಣಾಮ ಬೀರಿತು ಇದಕ್ಕೆ ಕಾರಣ",
                    options = listOf(
                        "ಸಮಾಜದ ಮೆಲೆ ಉಂಟಾಗಬಹುದಾದ ದುಷ್ಪರಿಣಾಮಗಳ ಬಗ್ಗೆ ವಿಜ್ಞಾನಿಗಳಿಂದ ಅಸಮರ್ಪಕ ವಿಶ್ಲೇಷಣೆ",
                        "ರಾಸಾಯನಿಕ ವಸ್ತುವನ್ನು ಸಿಂಪಡಿಸಿದ ಜನರ ಅಜಾಗರೂಕತೆ",
                        "ಜನರ ಅಜ್ಞಾನ",
                        "ಅಧಿಕಾರಿಗಳ ಭ್ರಷ್ಟಾಚಾರ"
                    ),
                    correctAnswer = "ಸಮಾಜದ ಮೆಲೆ ಉಂಟಾಗಬಹುದಾದ ದುಷ್ಪರಿಣಾಮಗಳ ಬಗ್ಗೆ ವಿಜ್ಞಾನಿಗಳಿಂದ ಅಸಮರ್ಪಕ ವಿಶ್ಲೇಷಣೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಮಾಜದ ಮೆಲೆ ಉಂಟಾಗಬಹುದಾದ ದುಷ್ಪರಿಣಾಮಗಳ ಬಗ್ಗೆ ವಿಜ್ಞಾನಿಗಳಿಂದ ಅಸಮರ್ಪಕ ವಿಶ್ಲೇಷಣೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q68",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "68) ವಿದ್ಯಾರ್ಥಿಗಳ ಒಂದು ಗುಂಪು ‘ಸೌರಶಕ್ತಿ’ ಕ್ರಿಯಾ ಮಾದರಿ ತಯ್ಯಾರಿಸಿದೆ. ಇದು ಪರಿಷ್ಕ್ರತ ಶೈಕ್ಷಣಿಕ ಉದ್ದೇಶಗಳ ವರ್ಗೀಕರಣದ ಯಾವ ಪ್ರಕ್ರಿಯೆಗೆ ಸಂಬಂಧಿಸಿದೆ.",
                    options = listOf("ಗ್ರಹಿಕೆ", "ವಿಶ್ಲೇಷಿಸುವುದು", "ಸೃಷ್ಟಿಸುವಿಕೆ", "ಸ್ಮರಿಸುವಿಕೆ"),
                    correctAnswer = "ಗ್ರಹಿಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗ್ರಹಿಕೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q69",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "69) ‘ಐತಿಹಾಸಿಕ ಮತ್ತು ಅಭಿವೃದ್ಧಿದಾಯಕ ದೃಷ್ಟಿಕೋನದಲ್ಲಿ ವಿಜ್ಞಾನವನ್ನು ಅಭಿವೃದ್ಧಿಪಡಿಸುವುದು ಮತ್ತು ವಿಜ್ಞಾನವನ್ನು ಸಾಮಾಜಿಕ ಉದ್ಯಮವಾಗಿ ನೋಡುವಂತೆ ಅವರನ್ನು ಸಮರ್ಥಗೊಳಿಸುವುದು’ ಯಾವ ಆಯೋಗದ ಪ್ರಕಾರ ಪ್ರಮುಖ ಉದ್ದೇಶವಾಗಿದೆ.",
                    options = listOf(
                        "ಕೊಠಾರಿ ಆಯೋಗ -1964-66",
                        "ತಾರಾದೇವಿ ಆಯೋಗ -1956",
                        "ರಾಷ್ಟ್ರೀಯ ಶಿಕ್ಷಣ ನೀತಿ -1986",
                        "ರಾಷ್ಟ್ರೀಯ ಪಠ್ಯಕ್ರಮ ಚೌಕಟ್ಟು -2005"
                    ),
                    correctAnswer = "ರಾಷ್ಟ್ರೀಯ ಪಠ್ಯಕ್ರಮ ಚೌಕಟ್ಟು -2005",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರಾಷ್ಟ್ರೀಯ ಪಠ್ಯಕ್ರಮ ಚೌಕಟ್ಟು -2005."
                ),
                QuestionModel(
                    id = "tet_sp_q70",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "70) ವಿಜ್ಞಾನ ಕಲಿಕೆಯನ್ನು ಅನುಕೂಲಿಸುವವರಿಗೆ ಇದು ಅವಶ್ಯಕ",
                    options = listOf(
                        "ವಿಜ್ಞಾನ ವಿಷಯ ಜ್ಞಾನ",
                        "ತರಗತಿ ಬೋಧನೆಗೆ ಸಿದ್ಧತೆ",
                        "ವಿಜ್ಞಾನ ಪ್ರಯೋಗಗಳನ್ನು ಮಾಡುವ ಮತ್ತು ವಿದ್ಯಾರ್ಥಿಗಳಿಂದ ಮಾಡಿಸುವ ಕೌಶಲ",
                        "ವಿಜ್ಞಾನಿಗಳ ಕೊಡುಗೆಗಳನ್ನು ಮೆಚ್ಚುವ ಸ್ವಭಾವ"
                    ),
                    correctAnswer = "ವಿಜ್ಞಾನ ಪ್ರಯೋಗಗಳನ್ನು ಮಾಡುವ ಮತ್ತು ವಿದ್ಯಾರ್ಥಿಗಳಿಂದ ಮಾಡಿಸುವ ಕೌಶಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಜ್ಞಾನ ಪ್ರಯೋಗಗಳನ್ನು ಮಾಡುವ ಮತ್ತು ವಿದ್ಯಾರ್ಥಿಗಳಿಂದ ಮಾಡಿಸುವ ಕೌಶಲ."
                ),
                QuestionModel(
                    id = "tet_sp_q71",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "71) ವೈಜ್ಞಾನಿಕ ವಿಧಾನವನ್ನು ಅನುಕೂಲಿಸುವ ಸ್ಥಳಗಳು",
                    options = listOf("ವಿಜ್ಞಾನ ಪ್ರಯೋಗಾಲಯ", "ವೈಜ್ಞಾನಿಕ ಸಂಶೋಧನಾ ಕೇಂದ್ರ", "ವಿಶ್ವವಿದ್ಯಾಲಯಗಳು", "ಇವುಗಳೆಲ್ಲವು"),
                    correctAnswer = "ಇವುಗಳೆಲ್ಲವು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಇವುಗಳೆಲ್ಲವು."
                ),
                QuestionModel(
                    id = "tet_sp_q72",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "72) ವಿಜ್ಞಾನ ಶಿಕ್ಷಕರು ತನ್ನ ತರಗತಿಯಲ್ಲಿ ಉದ್ಭವಿಸುವ ಸಮಸ್ಯೆಗಳಿಗೆ ಸ್ವತ: ತಾನೇ ಪರಿಹಾರ ಕಂಡುಕೊಳ್ಳಲು ಕೈಗೊಳ್ಳುವ ಸಂಶೋಧನೆ",
                    options = listOf("ಮೂಲಭೂತ ಸಂಶೋಧನೆ", "ಕ್ರಿಯಾ ಸಂಶೋಧನೆ", "ತಾಂತ್ರಿಕ ಸಂಶೋಧನೆ", "ವೈಜ್ಞಾನಿಕ ಸಂಶೋಧನೆ"),
                    correctAnswer = "ಕ್ರಿಯಾ ಸಂಶೋಧನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ರಿಯಾ ಸಂಶೋಧನೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q73",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "73) ಒಬ್ಬ ವಿದ್ಯಾರ್ಥಿ ಅಥವಾ ವಿದ್ಯಾಥಿಗಳ ಗುಂಪು ನೈಜ ವಾತಾವರಣದಲ್ಲಿ ಪೂರ್ವಬಾವಿಯಾಗಿ ಯೋಜಿಸಿರುವ ನಿಯಮಿತ ಹಂತಗಳಲ್ಲಿ ಸಮಸ್ಯೆಗೆ ಪರಿಹಾರ ಹುಡುಕುವುದೇ",
                    options = listOf("ಯೋಜನಾ ವಿಧಾನ", "ಸಮಸ್ಯಾ ಪರಿಹಾರ ವಿಧಾನ", "ಪ್ರಯೋಗಶಾಲಾ ವಿಧಾನ", "ಕ್ರೀಡಾ ವಿಧಾನ"),
                    correctAnswer = "ಸಮಸ್ಯಾ ಪರಿಹಾರ ವಿಧಾನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಮಸ್ಯಾ ಪರಿಹಾರ ವಿಧಾನ."
                ),
                QuestionModel(
                    id = "tet_sp_q74",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "74) ನಮ್ಮ ವಿದ್ಯಾರ್ಥಿಗಳಿಗೆ ನಾನು ಕಲಿಸುವುದಿಲ್ಲ ಅವರ ಕುತೂಹಲವನ್ನು ಕೆರಳಿಸುತ್ತೇನೆ ಎಂದು ಹೇಳಿದ ವಿಜ್ಞಾನಿ",
                    options = listOf("ಐನಸ್ಟೀನ್", "ಎಡಿಸನ್", "ನ್ಯೂಟನ್", "ಸಿ.ವಿ.ರಾಮನ್"),
                    correctAnswer = "ಐನಸ್ಟೀನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಐನಸ್ಟೀನ್."
                ),
                QuestionModel(
                    id = "tet_sp_q75",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "75) ವಿದ್ಯಾರ್ಥಿಗಳು ತಾವು ಪಡೆದುಕೊಂಡ ಜ್ಞಾನ ಮತ್ತು ಕೌಶಲವನ್ನು ನಿಜ ಜೀವನದ ಸಂದರ್ಭಗಳಿಗೆ ಅನ್ವಯಿಸುತ್ತಾರೆ. ಈ ವಿದ್ಯಾರ್ಥಿಗಳು 5ಇ ರಲ್ಲಿ ಕೆಳಗಿನ ಯಾವ ಹಂತದಲ್ಲಿದ್ದಾರೆ",
                    options = listOf("ಪರಿಶೋಧಿಸುವುದು", "ವಿಸ್ತರಿಸುವುದು", "ವ್ಯಕ್ತಪಡಿಸುವುದು", "ತೊಡಗಿಸುವುದು"),
                    correctAnswer = "ವಿಸ್ತರಿಸುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಸ್ತರಿಸುವುದು."
                ),
                QuestionModel(
                    id = "tet_sp_q76",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "76) “ಗಾಳಿಯು ತೂಕ ಹೊಂದಿದೆ ಮತ್ತು ಸ್ಥಳವನ್ನು ಆಕ್ರಮಿಸುತ್ತದೆ” ಇದು",
                    options = listOf("ವಾಸ್ತವಾಂಶ", "ಪರಿಕಲ್ಪನೆ", "ನಿಯಮ", "ಸಿದ್ಧಾಂತ"),
                    correctAnswer = "ವಾಸ್ತವಾಂಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಾಸ್ತವಾಂಶ."
                ),
                QuestionModel(
                    id = "tet_sp_q77",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "77) ವಿಜ್ಞಾನ ಕಲಿಕೆಯಲ್ಲಿ ‘ವೀಕ್ಷಿಸುವಿಕೆ’ ಪ್ರಕ್ರಿಯಾ ಕೌಶಲ ಬೆಳೆಸುವಲ್ಲಿ ಗಮನಿಸಬೆಕಾದ ಅಂಶವೆಂದರೆ",
                    options = listOf(
                        "ಮಾಹಿತಿಗಳಿಂದ ಸಂಬಂಧಗಳನ್ನು ಪತ್ತೆಹಚ್ಚುವುದು",
                        "ಮಾಹಿತಿ ಸಂಗ್ರಹಿಸಲು ಜ್ಞಾನೇಂದ್ರೀಯಗಳ ಬಳಕೆ",
                        "ಮಾಹಿತಿಗಾಗಿ ಪ್ರಶ್ನೆಗಳನ್ನು ಕೇಳುವುದು",
                        "ಮಾಹಿತಿ ಮೂಲಗಳನ್ನು ಬಳಸಿಕೊಳ್ಳುವುದು"
                    ),
                    correctAnswer = "ಮಾಹಿತಿ ಸಂಗ್ರಹಿಸಲು ಜ್ಞಾನೇಂದ್ರೀಯಗಳ ಬಳಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾಹಿತಿ ಸಂಗ್ರಹಿಸಲು ಜ್ಞಾನೇಂದ್ರೀಯಗಳ ಬಳಕೆ."
                ),
                QuestionModel(
                    id = "tet_sp_q78",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "78) ಒಂದು ತರಗತಿಯ ಪ್ರದರ್ಶನ ಪಾಠದ ವಿಡೀಯೋ ಕವರೇಜ್ ಮಾಡಿ ಏಕಕಾಲದಲ್ಲಿ ಅದನ್ನು ಇತರ ತರಗತಿಯಲ್ಲಿ ಕುಳಿತಿರುವ ವಿದ್ಯಾರ್ಥಿಗಳು ಈ ಮೂಲಕ ವೀಕ್ಷಷಿಸಬಹುದು",
                    options = listOf("ಟಿ.ವಿ", "ವಿ.ಸಿ.ಆರ್", "ಎಲ್.ಸಿ.ಡಿ", "ಸಿ.ಸಿ.ಟಿ.ವಿ"),
                    correctAnswer = "ಸಿ.ಸಿ.ಟಿ.ವಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಿ.ಸಿ.ಟಿ.ವಿ."
                ),
                QuestionModel(
                    id = "tet_sp_q79",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 9,
                    type = "MCQ",
                    questionText = "79) ಪರಿಸರ ಅಧ್ಯಯನವನ್ನು ನಿರ್ವಹಿಸಲು ಇರುವ ಉತ್ತಮ ವಿಧಾನ",
                    options = listOf("ಚಿತ್ರ ಗುರುತಿಸುವಿಕೆ", "ನೃತ್ಯ ಮಾಡುವಿಕೆ", "ಉಪನ್ಯಾಸ ನೀಡುವಿಕೆ", "ಪರಿಸರದಲ್ಲೇ ಬೋಧಿಸುವಿಕೆ"),
                    correctAnswer = "ಪರಿಸರದಲ್ಲೇ ಬೋಧಿಸುವಿಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಿಸರದಲ್ಲೇ ಬೋಧಿಸುವಿಕೆ."
                )
            )
        }
}
