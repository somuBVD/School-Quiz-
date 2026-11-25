package com.example.data

/**
 * TET (Teacher Eligibility Test - Standard / Exam ID: 13)
 * Subject: EVS, Science & Social Pedagogy ("general_science")
 * Unit 6: 5. ಪರಿಸರ (Environment) — 275 MCQs.
 */
object TetEnvironmentQuestionBank {

    val unitTemplate = UnitTemplate(
        id = 6,
        name = "5. ಪರಿಸರ (Environment)",
        totalQuestions = 275,
        difficulty = "Medium"
    )

    val questions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetEnvironment") {
            listOf(
                QuestionModel(
                    id = "tet_env_q1",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "1) ಪ್ರಾಚೀನ ಭಾರತೀಯ “ಗಾಯತ್ರಿ” ಮಂತ್ರದಲ್ಲಿ ಪ್ರಾಧಾನ್ಯತೆ ನೀಡಿರುವರು",
                    options = listOf("ತಿಳುವಳಿಕೆಗೆ", "ಬುದ್ಧಿಗೆ", "ಶಕ್ತಿಗೆ", "ದೇವರಿಗೆ"),
                    correctAnswer = "ಬುದ್ಧಿಗೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬುದ್ಧಿಗೆ."
                ),
                QuestionModel(
                    id = "tet_env_q2",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "2) ಪ್ರಾಣಿಗಳಿಗೂ ಮನುಷ್ಯರಿಗೂ ಪ್ರಮುಖ ಭೇದ",
                    options = listOf("ಯೋಚನೆ", "ಆಹಾರ", "ನೀರು", "ಲೈಂಗಿಕ ಕ್ರಿಯೆ"),
                    correctAnswer = "ಯೋಚನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯೋಚನೆ."
                ),
                QuestionModel(
                    id = "tet_env_q3",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "3) “ಮಾನವನು ಬುದ್ಧಿಜೀವಿ” ಎಂದು ಹೇಳಿದ ಗ್ರೀಸಿನ ತತ್ವಜ್ಞಾನಿ",
                    options = listOf("ಪ್ಲೇಟೋ", "ಅರಿಸ್ಟಾಟಲ", "ಕಾರ್ಲಮಾಕ್ರ್ಸ್", "ಹೆರೋಡೋಟ್ಸ್"),
                    correctAnswer = "ಅರಿಸ್ಟಾಟಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅರಿಸ್ಟಾಟಲ."
                ),
                QuestionModel(
                    id = "tet_env_q4",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "4) ಪ್ರಜಾಪ್ರಭುತ್ವ ವ್ಯವಸ್ಥೆಯು ಫಲಕಾರಿಯಾಗ ಬೇಕಾದಲ್ಲಿ ಇದು ಅವಶ್ಯಕ",
                    options = listOf("ಸರ್ಕಾರ", "ಶಿಕ್ಷಣ", "ಕುಟುಂಬ", "ಸಮಾಜ"),
                    correctAnswer = "ಕುಟುಂಬ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕುಟುಂಬ."
                ),
                QuestionModel(
                    id = "tet_env_q5",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "5) ವಿಶ್ವಭಾರತಿ ವಿಶ್ವವಿದ್ಯಾಲಯವನ್ನು ಸ್ಥಾಪಿಸಿದವರು",
                    options = listOf("ಬೇಂದ್ರೆ", "ರವೀಂದ್ರನಾಥ ಠಾಗೋರ", "ಕುವೆಂಪು", "ನೇಹರು"),
                    correctAnswer = "ರವೀಂದ್ರನಾಥ ಠಾಗೋರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರವೀಂದ್ರನಾಥ ಠಾಗೋರ."
                ),
                QuestionModel(
                    id = "tet_env_q6",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "6) ಹಳ್ಳಿಯ ಪ್ರಮುಖ ಉದ್ಯೋಗ",
                    options = listOf("ವ್ಯಾಪಾರ", "ಕುಂಬಾರಿಕೆ", "ಒಕ್ಕಲುತನ", "ಬಡಗಿತನ"),
                    correctAnswer = "ಒಕ್ಕಲುತನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಒಕ್ಕಲುತನ."
                ),
                QuestionModel(
                    id = "tet_env_q7",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "7) ನಮ್ಮ ಭಾರತವು ಪ್ರಮುಖವಾಗಿ",
                    options = listOf("ವ್ಯವಸಾಯ ಪ್ರಧಾನ ರಾಷ್ಟ್ರ", "ಕೈಗಾರಿಕರಣ ರಾಷ್ಟ್ರ", "ನೌಕರಶಾಹಿ ರಾಷ್ಟ್ರ", "ತಂತ್ರಜ್ಞಾನ ರಾಷ್ಟ್ರ"),
                    correctAnswer = "ವ್ಯವಸಾಯ ಪ್ರಧಾನ ರಾಷ್ಟ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವ್ಯವಸಾಯ ಪ್ರಧಾನ ರಾಷ್ಟ್ರ."
                ),
                QuestionModel(
                    id = "tet_env_q8",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "8) ಸಹರಾದ ಬಿಡೋಯಿನ್ ಸಮುದಾಯದವರು ವೃತ್ತಿಯ ಆಧಾರಿತವಾಗಿ ಹೀಗೆ ಗುರ್ತಿಸಲ್ಪಟ್ಟಿದ್ದಾರೆ.",
                    options = listOf("ಪಶುಪಾಲಕ ಅಲೆಮಾರಿಗಳು", "ಬೇಟೆಗಾರಿಕಾ ಅಲೆಮಾರಿಗಳು", "ಕೃಷಿ ವಲಸೆಗಾರರು", "ಋತುಕಾಲಿಕ ವಲಸೆಗಾರರು"),
                    correctAnswer = "ಪಶುಪಾಲಕ ಅಲೆಮಾರಿಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪಶುಪಾಲಕ ಅಲೆಮಾರಿಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q9",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "9) ಸಮಾಜದ ಉಗಮಕ್ಕೆ ಕಾರಣವಾದ ಅಂಶ ಯಾವದು?",
                    options = listOf("ಸ್ವಾಲಂಬನೆ", "ಒಂಟಿತನ", "ತಬ್ಬಲಿತನ", "ಅಂತರ ಅವಲಂಬನೆ ಮತ್ತು ಸಂಘ ಜೀವನ"),
                    correctAnswer = "ಅಂತರ ಅವಲಂಬನೆ ಮತ್ತು ಸಂಘ ಜೀವನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಂತರ ಅವಲಂಬನೆ ಮತ್ತು ಸಂಘ ಜೀವನ."
                ),
                QuestionModel(
                    id = "tet_env_q10",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "10) ಇವುಗಳಲ್ಲಿ ಯಾವುದು ಸರಿ",
                    options = listOf("ಮಾನವ ಸ್ವಾವಲಂಬಿ", "ಮಾನವ ಸಂಘಜೀವಿ", "ಮಾನವ ಒಂಟಿ ಜೀವಿ", "ಸಿನಿಮಾ ಮಂದಿರ"),
                    correctAnswer = "ಮಾನವ ಸಂಘಜೀವಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾನವ ಸಂಘಜೀವಿ."
                ),
                QuestionModel(
                    id = "tet_env_q11",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "11) ಆಧುನಿಕ ಸಮಾಜದ ಲಕ್ಷಣಗಳು ಯಾವುವು ?",
                    options = listOf("ನಗರೀಕರಣ ಆಧುನಿಕ ತಂತ್ರಜ್ಞಾನ", "ಕೈಗಾರೀಕರಣ", "ಸಾಂಪ್ರದಾಯಿಕ ಆಲೋಚನೆ", "ಸಾಂಪ್ರದಾಯಿಕ ಜೀವನ ಶೈಲಿ"),
                    correctAnswer = "ನಗರೀಕರಣ ಆಧುನಿಕ ತಂತ್ರಜ್ಞಾನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನಗರೀಕರಣ ಆಧುನಿಕ ತಂತ್ರಜ್ಞಾನ."
                ),
                QuestionModel(
                    id = "tet_env_q12",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "12) ಒಂದು ನಿರ್ದಿಷ್ಟ ಭೂ ಪ್ರದೇಶದಲ್ಲಿ ರಾಜಕೀಯವಾಗಿ ಸಂಘಟಿತರಾಗಿರುವ ಜನ ಸಮುದಾಯವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ ?",
                    options = listOf("ರಾಜ್ಯ", "ಸಮಾಜ", "ಸರ್ಕಾರ", "ಐಚ್ಛಿಕ ಸಂಸ್ಥೆ"),
                    correctAnswer = "ಸಮಾಜ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಮಾಜ."
                ),
                QuestionModel(
                    id = "tet_env_q13",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "13) ರಾಜ್ಯವನ್ನು ಇತರ ಸಂಸ್ಥೆಗಳಿಂದ ಬೇರ್ಪಡಿಸುವ ಮೂಲಾಂಶ ಯಾವುದು ?",
                    options = listOf("ನಿರ್ದಿಷ್ಟ ಭೂ ಪ್ರದೇಶ", "ಸರ್ಕಾರ", "ಪರಮಾಧಿಕಾರ", "ಜನಸಂಖ್ಯೆ"),
                    correctAnswer = "ಪರಮಾಧಿಕಾರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಮಾಧಿಕಾರ."
                ),
                QuestionModel(
                    id = "tet_env_q14",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "14) ರಾಜ್ಯದ ಇಚ್ಛೆಯನ್ನು ಪ್ರಕಟಿಸುವ ಮತ್ತು ಅನುಷ್ಟಾನಗೊಳಿಸುವ ಯಂತ್ರ/ನಿಯೋಗಿ ಯಾವುದು ?",
                    options = listOf("ಸಮಾಜ", "ಕುಟುಂಬ", "ಸರ್ಕಾರ", "ಶಾಲೆ"),
                    correctAnswer = "ಸರ್ಕಾರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸರ್ಕಾರ."
                ),
                QuestionModel(
                    id = "tet_env_q15",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "15) ರಹಸ್ಯ ಭಾಷೆ ಹಾಗೂ ಬರಹಗಳ ಅಧ್ಯಯನದ ವಿಜ್ಞಾನಕ್ಕೆ ಏನೆನ್ನುವರು ?",
                    options = listOf("ಕ್ರಿಫ್ಟೋಲಜಿ", "ಖೋರೋಲಜಿ", "ಜಿಯೋಡೆಸಿ", "ಹಿಸ್ಟಾಲಜಿ"),
                    correctAnswer = "ಕ್ರಿಫ್ಟೋಲಜಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ರಿಫ್ಟೋಲಜಿ."
                ),
                QuestionModel(
                    id = "tet_env_q16",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "16) ಭೂಮಿಯಿಂದ ಮೇಲೆ ಹೋದಂತೆಲ್ಲಾ ವಾಯುವಿನ ಒತ್ತಡ ಏನಾಗಿರುತ್ತದೆ ?",
                    options = listOf("ಜಾಸ್ತಿಯಾಗಿರುತ್ತದೆ", "ಕಡಿಮೆಯಾಗಿರುತ್ತದೆ", "ಸಮನಾಗಿರುತ್ತದೆ", "ಹೇಳ ಬರುವುದಿಲ್ಲ"),
                    correctAnswer = "ಕಡಿಮೆಯಾಗಿರುತ್ತದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಡಿಮೆಯಾಗಿರುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_env_q17",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "17) ಸೇಸ್ಮೋಲಜಿ ಏನನ್ನು ಲಭ್ಯಸಿಸುತ್ತದೆ ?",
                    options = listOf("ಮಣ್ಣಿನ ಗುಣವನ್ನು", "ಜ್ವಾಲಾಮುಖಿಯ ಕುರಿತಂತೆ", "ಭೂಕಂಪ ಮತ್ತು ಸಂಬಂಧಿಸಿದ ವಿಚಾರಗಳನ್ನು", "ಖನಿಜಗಳ ಬಗೆಗೆ."),
                    correctAnswer = "ಭೂಕಂಪ ಮತ್ತು ಸಂಬಂಧಿಸಿದ ವಿಚಾರಗಳನ್ನು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಭೂಕಂಪ ಮತ್ತು ಸಂಬಂಧಿಸಿದ ವಿಚಾರಗಳನ್ನು."
                ),
                QuestionModel(
                    id = "tet_env_q18",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "18) ಬಾರ್ ಇದು ಯಾವುದರ ಅಳತೆಯ ಮಾನ",
                    options = listOf("ವಾತಾವರಣದ ಒತ್ತಡ", "ಶಾಖ", "ವಿದ್ಯುತ್", "ಶಕ್ತಿ"),
                    correctAnswer = "ವಾತಾವರಣದ ಒತ್ತಡ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಾತಾವರಣದ ಒತ್ತಡ."
                ),
                QuestionModel(
                    id = "tet_env_q19",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "19) ನಾಟ್ ಎಂಬುವು ಯಾವುದರ ವೇಗವನ್ನು ಅಳೆಯುವದರ ಮಾನವಾಗಿದೆ ?",
                    options = listOf("ವಾಹನಗಳು", "ವಿಮಾನಗಳು", "ಹಡಗುಗಳು", "ಕ್ಷಿಪಣಿಗಳು"),
                    correctAnswer = "ಹಡಗುಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹಡಗುಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q20",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "20) ಥಿಯೋಲಜಿ ಯಾವ ವಿಷಯವನ್ನು ಕುರಿತು ಅಭ್ಯಸಿಸುತ್ತದೆ ?",
                    options = listOf("ಧರ್ಮಗಳು", "ಮಣ್ಣಿನ ಸಾರ", "ಖನಿಜಗಳು", "ರೋಗಪತ್ತೆ"),
                    correctAnswer = "ಧರ್ಮಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಧರ್ಮಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q21",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "21) ಹಾಲಿನ ಸಾಂಧ್ರತೆಯನ್ನು ಅಳೆಯಲು ಉಪಯೋಗಿಸುವ ಉಪಕರಣ ಯಾವುದು?",
                    options = listOf("ಮಾನೋಮೀಟರ್", "ಲ್ಯಾಕ್ಟೋಮೀಟರ್", "ಮೈಕ್ರೋಮೀಟರ್", "ಹೈಡ್ರೋಮೀಟರ್"),
                    correctAnswer = "ಲ್ಯಾಕ್ಟೋಮೀಟರ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಲ್ಯಾಕ್ಟೋಮೀಟರ್."
                ),
                QuestionModel(
                    id = "tet_env_q22",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "22) ಸೊನ್ನೆಯನ್ನು ಒಂದು ಸಂಖ್ಯೆಯೆಂದು ತೋರಿಸಿ ಅದರ ಗಣಿತ ಪ್ರಕ್ರಿಯೆಯನ್ನು ಪರಿಚಯಿಸಿದವರಾರು?",
                    options = listOf("ಆರ್ಯಭಟ", "ಚಾಣಕ್ಯ", "ಬ್ರಹ್ಮಗುಪ್ತ", "ಅರಿಸ್ಟಾಟಲ್"),
                    correctAnswer = "ಬ್ರಹ್ಮಗುಪ್ತ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬ್ರಹ್ಮಗುಪ್ತ."
                ),
                QuestionModel(
                    id = "tet_env_q23",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "23) ವಿಶ್ವ ಪರಿಸರ ದಿನವನ್ನು ಆಚರಿಸುವ ದಿನ",
                    options = listOf("ಜುಲೈ 5", "ಆಗಸ್ಟ್ 5", "ಜೂನ್ 5", "ಯಾವುದ ಅಲ್ಲ."),
                    correctAnswer = "ಜೂನ್ 5",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜೂನ್ 5."
                ),
                QuestionModel(
                    id = "tet_env_q24",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "24) 'ಸಂಜೆಯ ನಕ್ಷತ್ರ' ಎಂಬ ಪರ್ಯಾಯ ಪದದಿಂದ ಕರೆಯಲ್ಪಡುವ ಗ್ರಹ",
                    options = listOf("ಮಂಗಳ", "ಗುರು", "ಶುಕ್ರ", "ಶನಿ"),
                    correctAnswer = "ಶುಕ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶುಕ್ರ."
                ),
                QuestionModel(
                    id = "tet_env_q25",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "25) ಬಂಡಿಪೂರ ವನ್ಯಜೀವಿ ಅಭಯಾರಣ್ಯವು ಇರುವ ರಾಜ್ಯ",
                    options = listOf("ಕರ್ನಾಟಕ", "ಕೇರಳ", "ದೆಹಲಿ", "ಮೇಘಾಲಯ"),
                    correctAnswer = "ಕರ್ನಾಟಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕರ್ನಾಟಕ."
                ),
                QuestionModel(
                    id = "tet_env_q26",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "26) ಗ್ರಹಗಳಲ್ಲಿ ಅತಿವೇಗವಾಗಿ ಪರಿಭ್ರಮಿಸುವ ಗ್ರಹ",
                    options = listOf("ಬುಧ", "ಶನಿ", "ಗುರು", "ಶುಕ್ರ"),
                    correctAnswer = "ಗುರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗುರು."
                ),
                QuestionModel(
                    id = "tet_env_q27",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "27) ಗಾಳಿಯಲ್ಲಿರುವ ಆಮ್ಲಜನಕ ಪ್ರಮಾಣ.",
                    options = listOf("22%", "217%", "21.1%", "22.2%"),
                    correctAnswer = "21.1%",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 21.1%."
                ),
                QuestionModel(
                    id = "tet_env_q28",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "28) ಸಲೀಮ್ ಅಲಿಯವರು",
                    options = listOf("ಪರಿಸರ ಅಧ್ಯಯನ", "ಪಕ್ಷಿಗಳ ಅಧ್ಯಯನ", "ಸರೋವರಗಳ ಅಧ್ಯಯನ", "ಸೂಕ್ಷ್ಮ ಜೀವಿಗಳ ಅಧ್ಯಯನ"),
                    correctAnswer = "ಪಕ್ಷಿಗಳ ಅಧ್ಯಯನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪಕ್ಷಿಗಳ ಅಧ್ಯಯನ."
                ),
                QuestionModel(
                    id = "tet_env_q29",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "29) ಇದನ್ನು ಕುಬ್ಜ ಗ್ರಹವೆಂದು ಕರೆಯಲಾಗುತ್ತದೆ.",
                    options = listOf("ಗುರು", "ಬುಧ", "ಶನಿ", "ಯಾವುದು ಅಲ್ಲ."),
                    correctAnswer = "ಗುರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗುರು."
                ),
                QuestionModel(
                    id = "tet_env_q30",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "30) ಶುಷ್ಕ ವಾತಾವರಣವನ್ನು ಹೊಂದಿರುವ ಗ್ರಹ",
                    options = listOf("ಭುಧ", "ಗುರು", "ಶುಕ್ರ", "ಭೂಮಿ"),
                    correctAnswer = "ಭೂಮಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಭೂಮಿ."
                ),
                QuestionModel(
                    id = "tet_env_q31",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "31) ಉಂಗುರಗಳನ್ನು ಹೊಂದಿರುವ ಗ್ರಹ",
                    options = listOf("ಭೂಮಿ", "ಶುಕ್ರ", "ಶನಿ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಶನಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶನಿ."
                ),
                QuestionModel(
                    id = "tet_env_q32",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "32) ಆಕಾಶದಿಂದ ಭೂಮಿಯ ವಾತಾವರಣವನ್ನು ಪ್ರವೇಶಿಸುವ ದ್ರವ್ಯದ ಚೂರುಗಳು",
                    options = listOf("ಗ್ರಹಗಳು", "ನಕ್ಷತ್ರಗಳು", "ಉಲ್ಕೆಗಳು", "ಯಾವುದು ಅಲ್ಲ."),
                    correctAnswer = "ಉಲ್ಕೆಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಉಲ್ಕೆಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q33",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "33) 76 ವರ್ಷಗಳಿಗೊಮ್ಮೆ ಕಾಣಿಸಿಕೊಳ್ಳುವ ಧೂಮಕೇತು",
                    options = listOf("ಹ್ಯಾಲಿ", "ಹೋಲಿ", "ಹಾಲಿ", "ಯಾವುದು ಅಲ್ಲ."),
                    correctAnswer = "ಹ್ಯಾಲಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹ್ಯಾಲಿ."
                ),
                QuestionModel(
                    id = "tet_env_q34",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "34) 1986 ರಲ್ಲಿ ಕಾಣಿಸಿಕೊಂಡ ಹ್ಯಾಲಿ ಧೂಮಕೇತು ಪುನಃ ಗೋಚರಿಸುವುದು.",
                    options = listOf("2076", "2035", "2062", "ಯಾವುದು ಅಲ್ಲ."),
                    correctAnswer = "2062",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 2062."
                ),
                QuestionModel(
                    id = "tet_env_q35",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "35) 'ಭಾರತವು ಮಾನವ ಜನಾಂಗದ ತೊಟ್ಟಿಲು' ಎಂದವರು?",
                    options = listOf("ಮಾರ್ಕ್ಟ್ವೈನ್", "ಮಾರ್ಕ", "ಕಾರ್ಲ್ಮಾಕ್ರ್ಸ", "ಯಾರೂ ಅಲ್ಲ"),
                    correctAnswer = "ಕಾರ್ಲ್ಮಾಕ್ರ್ಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾರ್ಲ್ಮಾಕ್ರ್ಸ."
                ),
                QuestionModel(
                    id = "tet_env_q36",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "36) ಸ್ವಾವಲಂಬನೆ ಮತ್ತು ವೃತ್ತಿಗೌರವದ ಸಂದೇಶ ಸಾರಿದವರು.",
                    options = listOf("ನೆಹರು", "ಮದರಥೆರೆಸಾ", "ಗಾಂಧೀಜಿ", "ಎಲ್ಲರೂ"),
                    correctAnswer = "ಗಾಂಧೀಜಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗಾಂಧೀಜಿ."
                ),
                QuestionModel(
                    id = "tet_env_q37",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "37) ನಮ್ಮ ರಾಷ್ಟ್ರಿಯ ಕ್ರೀಡೆ",
                    options = listOf("ಕ್ರಿಕೇಟ್", "ಕಬಡ್ಡಿ", "ಖೋ ಖೋ", "ಹಾಕಿ"),
                    correctAnswer = "ಹಾಕಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹಾಕಿ."
                ),
                QuestionModel(
                    id = "tet_env_q38",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "38) ಅತೀ ಶೀತ ಪ್ರದೇಶದ ಮನೆಗಳು",
                    options = listOf("ಇಗ್ಲೂ", "ಕಚ್ಚಾ", "ಪಕ್ಕಾ", "ಯಾವುದೂ ಅಲ್ಲ"),
                    correctAnswer = "ಇಗ್ಲೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಇಗ್ಲೂ."
                ),
                QuestionModel(
                    id = "tet_env_q39",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "39) ಚಂದ್ರನ ಭ್ರಮಣೆಯ ವೇಗ",
                    options = listOf("15 km/h", "16.7 km/h", "18 km/h", "20 km/h"),
                    correctAnswer = "16.7 km/h",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 16.7 km/h."
                ),
                QuestionModel(
                    id = "tet_env_q40",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "40) ಚಂದ್ರನ ದ್ರವ್ಯರಾಶಿ",
                    options = listOf("7.35x10²² Kg", "8x10²³ Kg", "7.53x10²¹ Kg", "8x10²⁰ Kg"),
                    correctAnswer = "7.35x10²² Kg",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 7.35x10²² Kg."
                ),
                QuestionModel(
                    id = "tet_env_q41",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "41) O₃ ಓಝೋನ್",
                    options = listOf("ಅಣು", "ಸಂಯುಕ್ತ", "ಧಾತು", "ಅಣು ಮತ್ತು ಧಾತು"),
                    correctAnswer = "ಅಣು ಮತ್ತು ಧಾತು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಣು ಮತ್ತು ಧಾತು."
                ),
                QuestionModel(
                    id = "tet_env_q42",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "42) ಹಸಿರು ಮನೆಗೆ ಕಾರಣವಾದ ಅನಿಲ",
                    options = listOf("CO₂", "CO", "H₂O", "SO₂"),
                    correctAnswer = "CO₂",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: CO₂."
                ),
                QuestionModel(
                    id = "tet_env_q43",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "43) ನಿಸರ್ಗದ ಆಯ್ಕೆಯ ಸಿದ್ಧಾಂತ ಮಂಡಿಸಿದ ವಿಜ್ಞಾನಿ",
                    options = listOf("ಚಾಲ್ಸ್ ಡಾರ್ವಿನ", "ಪಾಶ್ಚರ್", "ಒಪಾರಿನ್", "ಹಾಲ್ಡೇನ್"),
                    correctAnswer = "ಚಾಲ್ಸ್ ಡಾರ್ವಿನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚಾಲ್ಸ್ ಡಾರ್ವಿನ."
                ),
                QuestionModel(
                    id = "tet_env_q44",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "44) ಸೌರವ್ಯೂಹದಲ್ಲಿ ಅತ್ಯಂತ ಹೊಳೆಯುವ ಗ್ರಹ",
                    options = listOf("ಭೂಮಿ", "ಶುಕ್ರ", "ಬುಧ", "ಶನಿ"),
                    correctAnswer = "ಶುಕ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶುಕ್ರ."
                ),
                QuestionModel(
                    id = "tet_env_q45",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "45) ಉಂಗುರವನ್ನು ಹೊಂದಿರುವ ಗ್ರಹಗಳು",
                    options = listOf("ಶುಕ್ರ-ಶನಿ", "ಭೂಮಿ-ಶುಕ್ರ", "ಶನಿ-ಯರೇನಸ್", "ಶನಿ-ಪ್ಲೋಟೋ"),
                    correctAnswer = "ಶನಿ-ಯರೇನಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶನಿ-ಯರೇನಸ್."
                ),
                QuestionModel(
                    id = "tet_env_q46",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "46) ಅಯೋಡಿನ್ ಅಮೋನಿಯಮ್ ಕ್ಲೋರೈಡ್ ನಂತರ ಘನವಸ್ತುಗಳು ಉಷ್ಣದಿಂದ ದ್ರವಸ್ಥಿತಿಗೆ ಬದಲಾಗದೇ ನೇರವಾಗಿ ಅನಿಲ ಸ್ಥಿತಿಗೆ ಬದಲಾಗುತ್ತವೆ ಇಂತಹ ವಸ್ತುಗಳನ್ನು ಹೀಗೆ ಕರೆಯುತ್ತೇವೆ",
                    options = listOf(
                        "ಉತ್ಪತನ ವಸ್ತುಗಳೆಂದು",
                        "ವಸ್ತುವಿನ ಸ್ಥಿತಿ ಬದಲಾವಣೆ ವಸ್ತುಗಳೆಂದು",
                        "ಕಾಯಿಸಿದ ವಸ್ತುಗಳೆಂದು",
                        "ತಂಪು ಮಾಡಿದ ಬದಲಾವಣೆಯ ವಸ್ತುಗಳೆಂದು"
                    ),
                    correctAnswer = "ಉತ್ಪತನ ವಸ್ತುಗಳೆಂದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಉತ್ಪತನ ವಸ್ತುಗಳೆಂದು."
                ),
                QuestionModel(
                    id = "tet_env_q47",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "47) ಭೂಮಿಯಲ್ಲಿ ಸಿಗುವ ನೀರು ಎಷ್ಟು ಭಾಗದಷ್ಟು ಸಮುದ್ರ ಮತ್ತು ಸಾಗರದಲ್ಲಿ ಇದೆ",
                    options = listOf("ಶೇ. 95", "ಶೇ. 98", "ಶೇ. 97.2", "ಶೇ 90"),
                    correctAnswer = "ಶೇ. 97.2",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶೇ. 97.2."
                ),
                QuestionModel(
                    id = "tet_env_q48",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "48) ಸಾರ್ಕ್ ಅಸ್ಥಿತ್ವಕ್ಕೆ ಬಂದ ವರ್ಷ",
                    options = listOf("1985", "1986", "1987", "1988"),
                    correctAnswer = "1985",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1985."
                ),
                QuestionModel(
                    id = "tet_env_q49",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "49) ಪರಿಸರದ ಬಗ್ಗೆ ಜಾಗೃತಿಯನ್ನು ಮೂಡಿಸಲು ವಿಶ್ವಪರಿಸರ ದಿನವನ್ನು ಆಚರಿಸುವುದು",
                    options = listOf("ಜನವರಿ 5 ರಂದು", "ಜೂನ್ 5 ರಂದು", "ಸೆಪ್ಟೆಂಬರ್ 5 ರಂದು", "ಡಿಸೆಂಬರ್ 5 ರಂದು"),
                    correctAnswer = "ಜೂನ್ 5 ರಂದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜೂನ್ 5 ರಂದು."
                ),
                QuestionModel(
                    id = "tet_env_q50",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "50) ಶಿಕ್ಷಕರು ಸೂಚಿತ ಚಟುವಟಿಕೆಗಳನ್ನು ಕೈಗೊಳ್ಳುವ ಮೊದಲು",
                    options = listOf(
                        "ಕ್ಷೇತ್ರ ಭೇಟಿ ಮಾಡಬೇಕು",
                        "ವಾರ್ಷಿಕವಾಗಿ ಒಮ್ಮೆ ಸಭೆ ಕರೆಯಬೇಕು",
                        "ವಾರ್ಷಿಕ ಯೋಜನೆಯನ್ನು ಸಿದ್ದಪಡಿಸಿಕೊಳ್ಳಬೇಕು",
                        "ತಾಂತ್ರಿಕ ಯೋಜನೆಯನ್ನು ಸಿದ್ದಪಡಿಸಿಕೊಳ್ಳಬೇಕು"
                    ),
                    correctAnswer = "ವಾರ್ಷಿಕ ಯೋಜನೆಯನ್ನು ಸಿದ್ದಪಡಿಸಿಕೊಳ್ಳಬೇಕು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಾರ್ಷಿಕ ಯೋಜನೆಯನ್ನು ಸಿದ್ದಪಡಿಸಿಕೊಳ್ಳಬೇಕು."
                ),
                QuestionModel(
                    id = "tet_env_q51",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "51) ಪ್ರಾಥಮಿಕ ಹಂತದಲ್ಲಿ ಪರಿಸರ ಅಧ್ಯಯನವನ್ನು ಬೋಧಿಸುವ ಉದ್ದೇಶ",
                    options = listOf(
                        "ಮಕ್ಕಳನ್ನು ನೈಜ ಜಗತ್ತಿಗೆ ಪರಿಚಯಿಸುವುದು",
                        "ನಾಗರೀಕತೆಯ ಅರಿವನ್ನುಂಟು ಮಾಡಲು",
                        "ಸಾಮಾಜಿಕರಣ ಪ್ರಕ್ರಿಯೆಗೆ ಒಳಪಡಿಸಲು",
                        "ಧಾರ್ಮಿಕ ಪ್ರಜ್ಞೆಯನ್ನುಂಟು ಮಾಡಲು"
                    ),
                    correctAnswer = "ಮಕ್ಕಳನ್ನು ನೈಜ ಜಗತ್ತಿಗೆ ಪರಿಚಯಿಸುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಕ್ಕಳನ್ನು ನೈಜ ಜಗತ್ತಿಗೆ ಪರಿಚಯಿಸುವುದು."
                ),
                QuestionModel(
                    id = "tet_env_q52",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "52) 1986ರ ರಾಷ್ಟ್ರೀಯ ಶಿಕ್ಷಣ ನೀತಿಯ ಪ್ರಕಾರ ಪರಿಸರ ಶಿಕ್ಷಣವು",
                    options = listOf(
                        "ಪರಿಸರ ಸಂರಕ್ಷಣೆಯ ಮೌಲ್ಯವನ್ನು ಬೆಳೆಸುತ್ತದೆ",
                        "ವಿದ್ಯಾರ್ಥಿಗಳಲ್ಲಿ ಪರಿಸರ ಪ್ರಜ್ಞೆಯನ್ನುಂಟು ಮಾಡುತ್ತದೆ",
                        "ಶೈಕ್ಷಣಿಕ ಪ್ರಕ್ರಿಯೆಯನ್ನು ಸಮಗ್ರವಾಗಿಸುತ್ತದೆ",
                        "ಮೇಲಿನ ಎಲ್ಲವೂ"
                    ),
                    correctAnswer = "ಪರಿಸರ ಸಂರಕ್ಷಣೆಯ ಮೌಲ್ಯವನ್ನು ಬೆಳೆಸುತ್ತದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಿಸರ ಸಂರಕ್ಷಣೆಯ ಮೌಲ್ಯವನ್ನು ಬೆಳೆಸುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_env_q53",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "53) ಪರಿಸರ ಅಧ್ಯಯನದ ವ್ಯಾಪ್ತಿಯು",
                    options = listOf(
                        "ಶಿಶು ಕೇಂದ್ರಿತವಾಗಿದೆ",
                        "ಬೋಧನಾ ಆಧಾರಿತವಾಗಿದೆ",
                        "ಅನುಭವ ಆಧಾರಿತವಾಗಿದೆ",
                        "ಮೇಲಿನ ಎಲ್ಲವನ್ನು ಒಳಗೊಂಡಿದೆ"
                    ),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವನ್ನು ಒಳಗೊಂಡಿದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವನ್ನು ಒಳಗೊಂಡಿದೆ."
                ),
                QuestionModel(
                    id = "tet_env_q54",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "54) ಪರಿಸರ ಅಧ್ಯಯನವನ್ನು ನಿರ್ವಹಿಸಲು ಇರುವ ಉತ್ತಮ ವಿಧಾನ",
                    options = listOf("ಚಿತ್ರ ಗುರುತಿಸುವಿಕೆ", "ನೃತ್ಯ ಮಾಡುವಿಕೆ", "ಉಪನ್ಯಾಸ ನೀಡುವಿಕೆ", "ಪರಿಸರದಲ್ಲೇ ಬೋಧಿಸುವಿಕೆ"),
                    correctAnswer = "ಪರಿಸರದಲ್ಲೇ ಬೋಧಿಸುವಿಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಿಸರದಲ್ಲೇ ಬೋಧಿಸುವಿಕೆ."
                ),
                QuestionModel(
                    id = "tet_env_q55",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "55) ಸಸ್ಯದ ಬೆಳವಣಿಗೆಯ ಪರಿಕಲ್ಪನೆಯನ್ನು ಶಿಕ್ಷಕರು ತರಗತಿಯಲ್ಲಿ ಪರಿಣಾಮಕಾರಿಯಾಗಿ ಬೋಧಿಸಲು ಅತ್ಯುತ್ತಮ ವಿಧಾನ",
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
                    id = "tet_env_q56",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "56) ಪರಿಸರ ಅಧ್ಯಯನದ ಬಹು ಆಕರ ಕಲಿಕೆಯ ಮುಖ್ಯ ಆಕರ",
                    options = listOf("ಗಣಕಯಂತ್ರ", "ದೂರದರ್ಶನ", "ಆವಾಸ", "ಬಾನುಲಿ"),
                    correctAnswer = "ಆವಾಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆವಾಸ."
                ),
                QuestionModel(
                    id = "tet_env_q57",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "57) ಪರಿಸರ ಅಧ್ಯಯನದ ಮುಖ್ಯ ಸಂಯುಕ್ತ ಅಧ್ಯಯನ ಕ್ಷೇತ್ರಗಳೆಂದರೆ",
                    options = listOf("ಸಮಾಜ ವಿಜ್ಞಾನ್-ಭಾಷೆ", "ಸಮಾಜ ವಿಜ್ಞಾನ್-ಗಣಿತ", "ಸಮಾಜ ವಿಜ್ಞಾನ್-ವಿಜ್ಞಾನ್", "ಸಮಾಜ ವಿಜ್ಞಾನ್-ಪೌರನೀತಿ"),
                    correctAnswer = "ಸಮಾಜ ವಿಜ್ಞಾನ್-ವಿಜ್ಞಾನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಮಾಜ ವಿಜ್ಞಾನ್-ವಿಜ್ಞಾನ್."
                ),
                QuestionModel(
                    id = "tet_env_q58",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "58) ಸಂದರ್ಭೋಚಿತ ಕಲಿಕೆಯು ಬೋಧನೆ ಮತ್ತು ಕಲಿಕೆಯು",
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
                    id = "tet_env_q59",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "59) ಪರಿಸರದ ಸೌಂದರ್ಯವನ್ನು ವರ್ಣಿಸುವ ಮೌಲ್ಯವೇ",
                    options = listOf("ನೈತಿಕ ಮೌಲ್ಯ", "ಸೌಂದರ್ಯಾತ್ಮಕ ಮೌಲ್ಯ", "ಧಾರ್ಮಿಕ ಮೌಲ್ಯ", "ಆರ್ಥಿಕ ಮೌಲ್ಯ"),
                    correctAnswer = "ಸೌಂದರ್ಯಾತ್ಮಕ ಮೌಲ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೌಂದರ್ಯಾತ್ಮಕ ಮೌಲ್ಯ."
                ),
                QuestionModel(
                    id = "tet_env_q60",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "60) ಪರಿಸರ ಅಧ್ಯಯನವನ್ನು ಉತ್ಕೃಷ್ಟಗೊಳಿಸಲು ಈ ಕೆಳಗಿನ ಯಾವ ಅಂಶಗಳು ಸಹಾಯಕವಾಗಿವೆ",
                    options = listOf("ಕಲಿಕೋಪಕರಣಗಳು", "ಪ್ರಾಯೋಗಿಕ ಉಪಕರಣಗಳು", "ಮೂರ್ತರೂಪದ ಉಪಕರಣಗಳು", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_env_q61",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "61) ಪರಿಸರ ಅಧ್ಯಯನ ಕುರಿತು ತ್ರೈಮಾಸಿಕ ಪತ್ರಿಕೆ",
                    options = listOf("ಹಾರ್ನ್ ಬಿಟ್", "ಡೇನ್ ಟು ಅರ್ತ", "ಗ್ರೀನ್ ಫೈಲ್", "ಇಂಡಿಯಾ ಕ್ವಾಟರ್ಲಿ"),
                    correctAnswer = "ಹಾರ್ನ್ ಬಿಟ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹಾರ್ನ್ ಬಿಟ್."
                ),
                QuestionModel(
                    id = "tet_env_q62",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "62) ಯಾವ ಗ್ರಹವನ್ನು ನೀರಿನಲ್ಲಿ ಹಾಕಿದಾಗ ತೇಲುತ್ತದೆ",
                    options = listOf("ಶುಕ್ರ ಗ್ರಹ", "ಶನಿ ಗ್ರಹ", "ಭೂಮಿ", "ಗುರುಗ್ರಹ"),
                    correctAnswer = "ಶನಿ ಗ್ರಹ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶನಿ ಗ್ರಹ."
                ),
                QuestionModel(
                    id = "tet_env_q63",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "63) ಆಧುನಿಕ ತಳಿವಿಜ್ಞಾನದ ಪಿತಾಮಹ",
                    options = listOf("ಗ್ರೆಗೋರೆ ಜೋಹಾನೆ ಮೇಂಡಲ್", "ಹ್ಯೂಗೋಡಿನಿಸೆ", "ಕಾರೆನ್ಸೆ", "ಚೆರೆಮಾರ್ಕ್"),
                    correctAnswer = "ಗ್ರೆಗೋರೆ ಜೋಹಾನೆ ಮೇಂಡಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗ್ರೆಗೋರೆ ಜೋಹಾನೆ ಮೇಂಡಲ್."
                ),
                QuestionModel(
                    id = "tet_env_q64",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "64) ವಿಕಾಸ ಹಂತದ ಮೊದಲ ಮಾನವ",
                    options = listOf("ಡ್ರಯೋಪಿಥಿಕನ್", "ಆಸ್ಟಿಲೋಪಿಥಿನ್", "ಹೋಮೋಸೆಪಿಯನ್ಸ್", "ಕ್ರೋಮ್ಯಾಗ್ನಾನ್ ಮಾನವ"),
                    correctAnswer = "ಆಸ್ಟಿಲೋಪಿಥಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆಸ್ಟಿಲೋಪಿಥಿನ್."
                ),
                QuestionModel(
                    id = "tet_env_q65",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "65) ಭಾರತದ ಅತ್ಯಂತ ಎತ್ತರವಾದ ಆಣೆಕಟ್ಟು ಇದು ...............",
                    options = listOf("ಹಿರಾಕುಡ್", "ಭಾಕ್ರಾನಂಗಲ್", "ಮೆಟ್ಟೂರು", "ಆಲಮಟ್ಟಿ"),
                    correctAnswer = "ಭಾಕ್ರಾನಂಗಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಭಾಕ್ರಾನಂಗಲ್."
                ),
                QuestionModel(
                    id = "tet_env_q66",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "66) ಅಪ್ಪಿಕೋ ಚಳುವಳಿ ಪ್ರಾರಂಭವಾದ ವರ್ಷ",
                    options = listOf("1970", "1971", "1974", "1900"),
                    correctAnswer = "1974",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1974."
                ),
                QuestionModel(
                    id = "tet_env_q67",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "67) ‘ಗೀರ್ ಅರಣ್ಯವು’ ಈ ರಾಜ್ಯದಲ್ಲಿ ಕಂಡು ಬರುತ್ತದೆ",
                    options = listOf("ಆಸ್ಸಾಂ", "ಗುಜರಾತ್", "ಕೇರಳ", "ಮಧ್ಯಪ್ರದೇಶ"),
                    correctAnswer = "ಗುಜರಾತ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗುಜರಾತ್."
                ),
                QuestionModel(
                    id = "tet_env_q68",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "68) ಪ್ರಕೃತಿಯು ಮಾನವನ ಆಸೆಯನ್ನು ಈಡೇರಿಸುತ್ತದೆ ವಿನ: ದುರಾಸೆಯನ್ನಲ್ಲ ಎಂದು ಹೇಳಿದವರು",
                    options = listOf("ಮಹಾತ್ಮ ಗಾಂಧಿಜಿ", "ಬಹುಗುಣ", "ಮೇಧಾ ಪಾಟ್ಕರ್", "ಮೇನಕಾ ಗಾಂಧಿ"),
                    correctAnswer = "ಮಹಾತ್ಮ ಗಾಂಧಿಜಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಹಾತ್ಮ ಗಾಂಧಿಜಿ."
                ),
                QuestionModel(
                    id = "tet_env_q69",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "69) ಇತ್ತೀಚಿನ ‘ಪಶ್ಚಿಮ ಘಟ್ಟಗಳ ಸಂರಕ್ಷಣೆ ಬಗ್ಗೆ ವರದಿ ತಯ್ಯಾರಿಸಿ ವಿವಾದಕ್ಕೆ ಒಳಗಾದ ವ್ಯಕ್ತಿ......................",
                    options = listOf("ಕಸ್ತೂರಿ ರಂಗನ್", "ಯು.ಆರ್.ರಾವ", "ಸಿ.ಎನ್.ಆರ್.ರಾವ", "ಸುರೇಶ ಹೆಬ್ಳೆಕರ್ರ್"),
                    correctAnswer = "ಸುರೇಶ ಹೆಬ್ಳೆಕರ್ರ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸುರೇಶ ಹೆಬ್ಳೆಕರ್ರ್."
                ),
                QuestionModel(
                    id = "tet_env_q70",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "70) ಪರಿಸರ ಅಧ್ಯಯನದ ಪರಿಣಾಮಕಾರಿ ಕಲಿಕೆ ಇದರಿಂದ ಮಾತ್ರ ಸಾಧ್ಯ",
                    options = listOf("ಪರಿಸರ ಯಾನ", "ಶಿಕ್ಷಕರ ಒಲವು", "ಪಠ್ಯ", "ಇಂದ್ರಿಯಗಳಿಂದ"),
                    correctAnswer = "ಪರಿಸರ ಯಾನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಿಸರ ಯಾನ."
                ),
                QuestionModel(
                    id = "tet_env_q71",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "71) ಬಂಡೀಪುರ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ ಈ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ ............",
                    options = listOf("ಚಾಮರಾಜನಗರ", "ಮೈಸೂರು", "ಕೋಲಾರ", "ದಕ್ಷಿನ ಕನ್ನಡ"),
                    correctAnswer = "ಮೈಸೂರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೈಸೂರು."
                ),
                QuestionModel(
                    id = "tet_env_q72",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "72) ಹವಾಮಾನ ಎಂದರೆ........................",
                    options = listOf(
                        "ಒಮದು ವರ್ಷದಲ್ಲಾಗುವ ಬದಲಾವಣೆ",
                        "ಮಳೆಗಾಗಲದಲ್ಲಾಗುವ ಬದಲಾವಣೆ",
                        "ವಾರ್ಷಿಕ ಬದಲಾವಣೆ",
                        "ಒಂದು ದಿನದಲ್ಲಾಗುವ ಬದಲಾವಣೆ"
                    ),
                    correctAnswer = "ಒಂದು ದಿನದಲ್ಲಾಗುವ ಬದಲಾವಣೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಒಂದು ದಿನದಲ್ಲಾಗುವ ಬದಲಾವಣೆ."
                ),
                QuestionModel(
                    id = "tet_env_q73",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "73) ಕರ್ನಾಟಕದಲ್ಲಿ ಅತೀ ಹೆಚ್ಚು ಮಳೆ ಬೀಳುವ ಪ್ರದೇಶ",
                    options = listOf("ದಕ್ಷಿಣ ಕನ್ನಡ", "ಉತ್ತರ ಕನ್ನಡ", "ಚಿಕ್ಕ ಮಂಗಳೂರು", "ಶಿವಮೊಗ್ಗ"),
                    correctAnswer = "ಶಿವಮೊಗ್ಗ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶಿವಮೊಗ್ಗ."
                ),
                QuestionModel(
                    id = "tet_env_q74",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "74) ಇದೊಂದು ಇಂಧನ ರಹಿತವಾಹಹನ ಪರಿಸರದ ಮಿತ್ರ ಆರೋಗ್ಯವರ್ಧಕ ಕೂಡ......................",
                    options = listOf("ಉಗಿಬಂಡಿ", "ತ್ರಿಚಕ್ರವಾಹನ ಘಟಕ", "ಬೈಸಿಕಲ್", "ಹಡಗು"),
                    correctAnswer = "ಬೈಸಿಕಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೈಸಿಕಲ್."
                ),
                QuestionModel(
                    id = "tet_env_q75",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "75) ಪ್ರಾಣಿ ಪ್ರಪಂಚದಲ್ಲಿ ಇವುಗಳ ಸಂಖ್ಯೆ ಹೆಚ್ಚು",
                    options = listOf("ಕೀಟಗಳು", "ಪಕ್ಷಿಗಳು", "ಸಸ್ತನಿಗಳು", "ಸರಿಸೃಪಗಳು"),
                    correctAnswer = "ಕೀಟಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೀಟಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q76",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "76) ಅಪ್ಪಿಕೋ ಚಳುವಳಿಯ ಮುಖ್ಯ ಉದ್ದೇಶ",
                    options = listOf(
                        "ಭ್ರಷ್ಟಾಚಾರ ನಿಮೂಲನೆ",
                        "ಎಲ್ಲಾ ಮಕ್ಕಳಿಗೂ ಗುಣಮಟ್ಟದ ಶಿಕ್ಷಣ ನೀಡುವುದು",
                        "ಕಾಡನ್ನು ಉಳಿಸಿ ಬೆಳೆಸಿವುದು",
                        "ಕೃಷಿ ಉತ್ಪನ್ನ ಹೆಚ್ಚಿಸುವುದು"
                    ),
                    correctAnswer = "ಕಾಡನ್ನು ಉಳಿಸಿ ಬೆಳೆಸಿವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾಡನ್ನು ಉಳಿಸಿ ಬೆಳೆಸಿವುದು."
                ),
                QuestionModel(
                    id = "tet_env_q77",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "77) ಶಾಲೆಯ ಮಹತ್ವ",
                    options = listOf(
                        "ಪರೀಕ್ಷೆಯಲ್ಲಿ ಉತ್ತೀರ್ಣಗೊಳಿಸುವುದು",
                        "ಉದ್ಯೋಗ ನೀಡುವುದು",
                        "ಉತ್ತಮ ನಾಗರೀಕ ಪ್ರಜೆಯಾಗಿ ರೂಪಿಸುವುದು",
                        "ಮೇಲಿನ ಎಲ್ಲಾ ಅಂಶಗಳು ಸರಿ"
                    ),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲಾ ಅಂಶಗಳು ಸರಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲಾ ಅಂಶಗಳು ಸರಿ."
                ),
                QuestionModel(
                    id = "tet_env_q78",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "78) ಸೀಮೆ ಎಣ್ಣೆ ಅಪೂರ್ಣವಾಗಿ ದಹನವಾದಾಗ ಬಿಡುಗಡೆಯಾಗುವ ಅಪಾಯಕಾರಿ ಅನಿಲ",
                    options = listOf("ಕಾರ್ಬನ್ನಿನ ಕಣ", "ನೀರಾವಿ", "ಕಾರ್ಬನ ಮೊನಾಕ್ಸೈಡ್", "ಕಾರ್ಬನ್ ಡೈ ಆಕ್ಸೈಡ್"),
                    correctAnswer = "ಕಾರ್ಬನ ಮೊನಾಕ್ಸೈಡ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾರ್ಬನ ಮೊನಾಕ್ಸೈಡ್."
                ),
                QuestionModel(
                    id = "tet_env_q79",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "79) ಪರಿಸರ ಅಧ್ಯಯನದಲ್ಲಿ ಸಿ.ಸಿ.ಇ. ಅಳವಡಿಕೆಯಿಂದ",
                    options = listOf(
                        "ನಿಖರವಾದ ಅಂಕದಿಂದ ಉತ್ತೀರ್ಣ ಮಾಡಬಹುದು",
                        "ಪರೀಕ್ಷೆಗೆ ತಯ್ಯಾರು ಮಾಡಲು ಅನುಕೂಲ",
                        "ಕಂಠಪಾಠಕ್ಕೆ ಅನುಕೂಲ",
                        "ಕಲಿಕೆಯೊಂದಿಗೆ ಮೌಲ್ಯಮಾಪನ ನಡೆಸಲು ಅನುಕೂಲ"
                    ),
                    correctAnswer = "ಕಲಿಕೆಯೊಂದಿಗೆ ಮೌಲ್ಯಮಾಪನ ನಡೆಸಲು ಅನುಕೂಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಲಿಕೆಯೊಂದಿಗೆ ಮೌಲ್ಯಮಾಪನ ನಡೆಸಲು ಅನುಕೂಲ."
                ),
                QuestionModel(
                    id = "tet_env_q80",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "80) ಓಟಗಾರರು ಮತ್ತು ಕ್ರೀಡಾಳುಗಳು ತಮ್ಮ ತೀವ್ರ ಚಟುವಟಿಕೆಯ ನಂತರ ಸ್ವಲ್ಪ ಗ್ಲೂಕೋಸ್ನ್ನು ಸೇವಿಸುತ್ತಾರೆ",
                    options = listOf(
                        "ಚಟುವಟಿಕೆಯ ವೇಗ ಹೆಚ್ಚಿಸಲು",
                        "ಬಾಯಾರಿಕೆ ತಣಿಸಲು",
                        "ಶಕ್ತಿ ಪುನಶ್ಚೇತನಗೊಳಿಸಲು",
                        "ಬಾಯಿ ಸಿಹಿ ಮಾಡಲು"
                    ),
                    correctAnswer = "ಶಕ್ತಿ ಪುನಶ್ಚೇತನಗೊಳಿಸಲು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶಕ್ತಿ ಪುನಶ್ಚೇತನಗೊಳಿಸಲು."
                ),
                QuestionModel(
                    id = "tet_env_q81",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "81) ಶಂಕರಾಚಾರ್ಯರ ಜನ್ಮ ಸ್ಥಳ",
                    options = listOf("ಗಯಾ", "ಲುಂಬಿಣಿ", "ಪಾಜಕ", "ಕಾಲಟಿ"),
                    correctAnswer = "ಕಾಲಟಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾಲಟಿ."
                ),
                QuestionModel(
                    id = "tet_env_q82",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "82) ಪಕ್ಷಿಧಾಮ ಇಲ್ಲಿದೆ",
                    options = listOf("ಮೈಸೂರು", "ಮಂಡಗದ್ದೆ", "ಮಂಡ್ಯ", "ತೀರ್ಥಹಳ್ಳಿ"),
                    correctAnswer = "ಮಂಡಗದ್ದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಂಡಗದ್ದೆ."
                ),
                QuestionModel(
                    id = "tet_env_q83",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "83) ಸಂಗೋಳ್ಳಿ ರಾಯಣ್ಣ ಗಲ್ಲಿ ಶಿಕ್ಷೆಗೆ ಒಳಗಾದ ದಿನ",
                    options = listOf("1831 ಜನವರಿ 26", "1843 ಜನವರಿ 21", "1867 ಜನವರಿ 16", "1834 ಜನವರಿ 06"),
                    correctAnswer = "1831 ಜನವರಿ 26",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1831 ಜನವರಿ 26."
                ),
                QuestionModel(
                    id = "tet_env_q84",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "84) ಕೌಟಿಲ್ಯನು ರಚಿಸಿದ ಕೃತಿ",
                    options = listOf("ಇಂಡಿಕಾ", "ಸಸ್ಯಶಾಸ್ತ್ರ", "ಚರಕ ಸಂಹಿತೆ", "ಅರ್ಥಶಾಸ್ತ್ರ"),
                    correctAnswer = "ಅರ್ಥಶಾಸ್ತ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅರ್ಥಶಾಸ್ತ್ರ."
                ),
                QuestionModel(
                    id = "tet_env_q85",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "85) ಪರಿಸರ ಅಧ್ಯಯನ ಕಲಿಕೆಯ ಪ್ರಮುಖ ಕಲಿಕಾ ಫಲಿತಾಂಶಗಳು ಈ ಕೆಳಕಂಡಂತಿದೆ:\nಎ) ಪರಿಸರದ ಸಮಗ್ರವಾದ ಜ್ಞಾನವನ್ನು ಬೆಳೆಸುವುದು\nಬಿ) ಸ್ವಾಭಾವಿಕ ಸಾಮಾಜಿಕ ಮತ್ತು ಸಾಂಸ್ಕ್ರತಿಕ ಪರಿಸರಗಳ ನಡುವಿನ ಸಂಬಂಧಗಳನ್ನು ಗುರುತಿಸುವುದು\nಸಿ) ವೈವಿಧ್ಯತೆ, ಸಮಾನತೆ, ನ್ಯಾಯ, ಘನತೆ ಮತ್ತು ಸ್ವಂತ ಯೋಚನೆ ಇಂತಹ ಮಾನವೀಯ ಮೌಲ್ಯಗಳನ್ನು ಬೆಳೆಸುವುದು\nಡಿ) ಶಬ್ದ ಭಂಡಾರ ಹೆಚ್ಚಿಸುವುದು",
                    options = listOf("ಎ & ಬಿ", "ಬಿ", "ಎ,ಬಿ&ಸಿ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ಎ,ಬಿ&ಸಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎ,ಬಿ&ಸಿ."
                ),
                QuestionModel(
                    id = "tet_env_q86",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "86) “ಪರಿಸರ” ಎಂಬ ಪದವನ್ನು “ಎನ್ವಿರಾನರ್” ಎಂಬ ........... ಭಾಷೆಯಿಂದ ತೆಗೆದುಕೊಳ್ಳಲಾಗಿದೆ",
                    options = listOf("ಫ್ರೆಂಚ್", "ಪರ್ಷಿಯನ್", "ಇಂಗ್ಲೀಷ್", "ಲ್ಯಾಟಿನ್"),
                    correctAnswer = "ಫ್ರೆಂಚ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಫ್ರೆಂಚ್."
                ),
                QuestionModel(
                    id = "tet_env_q87",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "87) ಸ್ತರಿಕೃತ ಜಗತ್ತುಗಳ ಸರಣಿಗಳಲ್ಲಿ ಒಂದಾದ ಗಣಿತ ಜಗತ್ತು ಇನ್ನೊಂದು ಭೌತಿಕ ಜಗತ್ತು, ಮತ್ತೊಂದ ಐತಿಹಾಸಿಕ ಮುಂತಾದವುಗಳನ್ನು ನಾವು ಹೊಂದಿಲ್ಲ ಎಲ್ಲಾ ಅಧ್ಯಯನಗಳು ಒಂದು ಮಹಾನ ಸಾಮಾನ್ಯ ವಿಶ್ವದಲ್ಲಿ ಸಂಬಂಧಗಳ ಹೊರತಾಗಿವೆ ಎಂದು ಪ್ರಸಿದ್ಧ ಶಿಕ್ಷಣ ತತ್ವಜ್ಞಾನಿ ................. ರವರು ತೋರಿಸಿಕೊಟ್ಟಿದ್ದಾರೆ",
                    options = listOf("ರುಡಾಲ್ಫ ಸ್ಟೀನರ್", "ಜಾನ್ ಡ್ಯೂಯಿ", "ಶ್ರೀ ಅರವಿಂದೋ", "ಜೀನ್ ಪಿಯಾಜೆ"),
                    correctAnswer = "ಜಾನ್ ಡ್ಯೂಯಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಾನ್ ಡ್ಯೂಯಿ."
                ),
                QuestionModel(
                    id = "tet_env_q88",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "88) ಸಮಗ್ರ ಶಿಕ್ಷಣವು ಒಂದು ಮಗುವಿನ .............. ಬೆಳವಣಿಗೆಯೆಡೆ ಗುರಿ ಇಟ್ಟಿದೆ",
                    options = listOf("ಶೈಕ್ಷಣಿಕ ಸಾಧನೆ", "ಸಂವೇದನಾತ್ಮಕ ಬೆಳವಣಿಗೆ", "ಕೌಶಲ್ಯ ಬೆಳವಣಿಗೆ", "ಸರ್ವಾಂಗಿಣ ಬೆಳವಣಿಗೆ"),
                    correctAnswer = "ಸರ್ವಾಂಗಿಣ ಬೆಳವಣಿಗೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸರ್ವಾಂಗಿಣ ಬೆಳವಣಿಗೆ."
                ),
                QuestionModel(
                    id = "tet_env_q89",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "89) ಕ್ಷಿಪಣಿ ಪಿತಾಮಹ ಎಂದು ಪ್ರಖ್ಯಾತಿ ಆದವರು",
                    options = listOf("ಸರ್.ಸಿ.ವಿ.ರಾಮನ್", "ಗೆಲಿಲಿಯೋ ಗೆಲಿಲಿ", "ಎ.ಪಿ.ಜೆ.ಅಬ್ದುಲ್ ಕಲಾಂ", "ಮೌಲಾನ ಅಬುಲ್ ಕಲಾಂ ಅಜಾದ್"),
                    correctAnswer = "ಎ.ಪಿ.ಜೆ.ಅಬ್ದುಲ್ ಕಲಾಂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎ.ಪಿ.ಜೆ.ಅಬ್ದುಲ್ ಕಲಾಂ."
                ),
                QuestionModel(
                    id = "tet_env_q90",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "90) ವಿಷಯ ಸೂಚಿ ಮುಖ್ಯ ಸೂಚಿ ಮತ್ತು ಸಾರಾಂಶಗಳಿರುವ ಭಾರತದಲ್ಲಿನ ಪರಿಸರೀಯ ತುಣುಕುಗಳನ್ನು ಸಂಗ್ರಹಿಸುವ ಮಾಸಿಕ ನಿಯತಕಾಲಿಕೆ ................",
                    options = listOf("ಗ್ರೀನ್ ಪೇಪರ್", "ಗ್ರೀನ್ ಬುಕ್", "ಗ್ರೀನ್ ಪೈಲ್", "ಗ್ರೀನ್ ಪವರ್"),
                    correctAnswer = "ಗ್ರೀನ್ ಪೈಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗ್ರೀನ್ ಪೈಲ್."
                ),
                QuestionModel(
                    id = "tet_env_q91",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "91) ಪರಿಸರ ಅಧ್ಯಯನವು ಶಿಕ್ಷಕರಿಂದ ಬೋಧಿಸುವುದರ ಬದಲಾಗಿ .................. ಅನುಭವದ ಮೇಲೆ ಕೇಂದ್ರಿಕೃತವಾಗಿದೆ",
                    options = listOf("ಮಕ್ಕಳ", "ಶಿಕ್ಷಕರ", "ಶಾಲೆಯ", "ಪೋಷಕರ"),
                    correctAnswer = "ಮಕ್ಕಳ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಕ್ಕಳ."
                ),
                QuestionModel(
                    id = "tet_env_q92",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "92) ಸೌರವ್ಯೂಹದ ಅತ್ಯಂತ ದೊಡ್ಡ ಗ್ರಹ",
                    options = listOf("ಮಂಗಳ", "ಶನಿ", "ಗುರುಗ್ರಹ", "ನೆಪ್ಚೂನ್"),
                    correctAnswer = "ಗುರುಗ್ರಹ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗುರುಗ್ರಹ."
                ),
                QuestionModel(
                    id = "tet_env_q93",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "93) ನೆರಳು ಉಂಟಾಗಲು ಬೆಳಕಿನ ಈ ಕೆಳಗಿನ ಲಕ್ಷಣ ಕಾರಣವಾಗಿದೆ",
                    options = listOf("ವಕ್ರೀಭವನ", "ಸರಳ ರೇಖಾಗತ ಚಲನೆ", "ವಿಭಜನೆ", "ಪ್ರತಿಫಲನ"),
                    correctAnswer = "ಸರಳ ರೇಖಾಗತ ಚಲನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸರಳ ರೇಖಾಗತ ಚಲನೆ."
                ),
                QuestionModel(
                    id = "tet_env_q94",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "94) ಸಂಪೂರ್ಣ ಸೌರ ಗ್ರಹಣದ ಸಂದರ್ಭದಲ್ಲಿ ಮಾತ್ರ ಗೋಚರಿಸುವ ಸೌರವಾತಾವರಣ ವಲಯ",
                    options = listOf("ಸೌರಕೇಂದ್ರ", "ಪ್ರಭಾ ಮಂಡಲ", "ವರ್ಣಮಂಡಲ", "ಕರೋನಾ"),
                    correctAnswer = "ಕರೋನಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕರೋನಾ."
                ),
                QuestionModel(
                    id = "tet_env_q95",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "95) ಚಂದ್ರಗ್ರಹಣದ ಅವಧಿಯು",
                    options = listOf("ಸೂರ್ಯಗ್ರಹಣಕ್ಕಿಂತ ಹೆಚ್ಚು", "ಸೂರ್ಯಗ್ರಹಣಕ್ಕಿಂತ ಕಡಿಮೆ", "ಸೂರ್ಯಗ್ರಹಣದ ಅವಧಿಯಷ್ಟು", "ಯಾವುದು ಸರಿ ಇಲ್ಲ"),
                    correctAnswer = "ಸೂರ್ಯಗ್ರಹಣಕ್ಕಿಂತ ಹೆಚ್ಚು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೂರ್ಯಗ್ರಹಣಕ್ಕಿಂತ ಹೆಚ್ಚು."
                ),
                QuestionModel(
                    id = "tet_env_q96",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "96) ಚಂದ್ರಗ್ರಹಣದ ಸಂದರ್ಭದಲ್ಲಿ ಕಾಣಿಸುವ ಕೆಂಪು ಬಣ್ಣಕ್ಕೆ ಕಾರಣ",
                    options = listOf("ಚಂದ್ರನ ವಾತಾವರಣದಲ್ಲಿನ ಧೂಳು", "ಭೂ ವಾತಾವರಣದಲ್ಲಿನ ಧೂಳು", "ಆಕಾರದಲ್ಲಿನ ಧೂಳು", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಭೂ ವಾತಾವರಣದಲ್ಲಿನ ಧೂಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಭೂ ವಾತಾವರಣದಲ್ಲಿನ ಧೂಳು."
                ),
                QuestionModel(
                    id = "tet_env_q97",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "97) ಸೂರ್ಯಗ್ರಹಣದ ಸಂದರ್ಭದಲ್ಲಿ ಭೂಮಿ, ಸೂರ್ಯ, ಚಂದ್ರರ ಸರಿಯಾದ ಜೋಡಣಾ ಕ್ರಮ",
                    options = listOf("ಸೂರ್ಯ, ಚಂದ್ರ, ಭೂಮಿ", "ಚಂದ್ರ, ಸೂರ್ಯ, ಭೂಮಿ", "ಭೂಮಿ, ಸೂರ್ಯ, ಚಂದ್ರ", "ಸೂರ್ಯ, ಭೂಮಿ, ಚಂದ್ರ"),
                    correctAnswer = "ಸೂರ್ಯ, ಚಂದ್ರ, ಭೂಮಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೂರ್ಯ, ಚಂದ್ರ, ಭೂಮಿ."
                ),
                QuestionModel(
                    id = "tet_env_q98",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "98) ಚಂದ್ರಗ್ರಹಣದ ಸಂದರ್ಭದಲ್ಲಿ ಭೂಮಿ, ಸೂರ್ಯ, ಚಂದ್ರರ ಸರಿಯಾದ ಜೋಡಣಾ ಕ್ರಮ",
                    options = listOf("ಸೂರ್ಯ, ಭೂಮಿ, ಸೂರ್ಯ", "ಚಂದ್ರ, ಸೂರ್ಯ, ಭೂಮಿ", "ಭೂಮಿ, ಸೂರ್ಯ, ಚಂದ್ರ", "ಸೂರ್ಯ, ಚಂದ್ರ, ಭೂಮಿ"),
                    correctAnswer = "ಭೂಮಿ, ಸೂರ್ಯ, ಚಂದ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಭೂಮಿ, ಸೂರ್ಯ, ಚಂದ್ರ."
                ),
                QuestionModel(
                    id = "tet_env_q99",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "99) ಸೌರವ್ಯೂಹದಲ್ಲಿ ಕ್ಷುದ್ರಗ್ರಹಗಳು ಈ ಎರಡು ಗ್ರಹಗಳ ಕಕ್ಷೆಗಳ ಮಧ್ಯದಲ್ಲಿ ಕಂಡು ಬರುತ್ತದೆ.",
                    options = listOf("ನೆಪ್ಚೂನ್ ಮತ್ತು ಪ್ಲೊಟೋ", "ಮಂಗಳ ಮತ್ತು ಗುರು", "ಗುರು ಮತ್ತು ಭೂಮಿ", "ಮಂಗಳ ಮತ್ತು ಶನಿ"),
                    correctAnswer = "ಮಂಗಳ ಮತ್ತು ಗುರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಂಗಳ ಮತ್ತು ಗುರು."
                ),
                QuestionModel(
                    id = "tet_env_q100",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "100) ಹಾನಿಕಾರಕ ಅಥವಾ ಮಾಲಿನ್ಯಕಾರಕ ವಸ್ತುಗಳ ಸಾರತೆಯು ಆಹಾರ ಸರಪಳಿಯ ಒಂದೊಂದು ಕೊಂಡಿಯಲ್ಲಿ ಮೇಲೆ ಸಾಗುತ್ತಿದ್ದಂತೆ ಕ್ರಮೇಣ ಹೆಚ್ಚುತ್ತಾ ಹೋಗುವ ಪ್ರಕ್ರಿಯೆಗೆ ಹೀಗೆನ್ನುವರು",
                    options = listOf("ಜೈವಿಕ ವಿಘಟನೆ", "ಜೈವಿಕ ಸಂವರ್ಧನೆ", "ವಿಘಟನೆ", "ಸಂವರ್ಧನೆ"),
                    correctAnswer = "ಜೈವಿಕ ಸಂವರ್ಧನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜೈವಿಕ ಸಂವರ್ಧನೆ."
                ),
                QuestionModel(
                    id = "tet_env_q101",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "101) ಜೈವಿಕ ಸಂವರ್ಧನೆಯ ಆಹಾರ ಸರಪಳಿ ಯಲ್ಲಿರುವ ಸಮತೋಲನವನ್ನು",
                    options = listOf("ಹೆಚ್ಚಿಸುತ್ತದೆ", "ಹಾಳು ಮಾಡುತ್ತದೆ", "ಎ ಮತ್ತು ಬಿ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಹಾಳು ಮಾಡುತ್ತದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹಾಳು ಮಾಡುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_env_q102",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "102) ಸಾಮಾಜಿಕ ಅರಣ್ಯೀಕರಣ ಕಾರ್ಯಕ್ರಮವು ನಮ್ಮ ದೇಶದ ಯಾವ ರಾಜ್ಯದಲ್ಲಿ ಯಶಸ್ವಿಯಾಗಿ ನಡೆಯುತ್ತಿದೆ.",
                    options = listOf("ಕರ್ನಾಟಕ", "ಕೇರಳ", "ಬಿಹಾರ", "ಗುಜರಾತ"),
                    correctAnswer = "ಕೇರಳ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೇರಳ."
                ),
                QuestionModel(
                    id = "tet_env_q103",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "103) ವಾತಾವರಣವನ್ನು ಹೊಂದಿರುವ ಉಪಗ್ರಹ ..........",
                    options = listOf("ಟೈಟಾನ್", "ಚಂದ್ರ", "ಐಯೋ", "ಸೀರಸ್"),
                    correctAnswer = "ಟೈಟಾನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಟೈಟಾನ್."
                ),
                QuestionModel(
                    id = "tet_env_q104",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "104) ತುಕ್ಕು ಉಂಟಾಗಲು ಕಬ್ಬಿಣದ ಪದಾರ್ಥವನ್ನು",
                    options = listOf(
                        "ಶುಷ್ಕ ಗಾಳಿಗೆ ತೆರೆದು ಇಡಬೇಕು",
                        "ತೇವಾಂಶವುಳ್ಳ ಗಾಳಿಗೆ ತೆರೆದು ಇಡಬೇಕು",
                        "ನೀರಿನೊಳಗೆ ಮುಳುಗಿಸಬೇಕು",
                        "ಬೆಳಕಿಗೆ ಒಡ್ಡಬೇಕು"
                    ),
                    correctAnswer = "ತೇವಾಂಶವುಳ್ಳ ಗಾಳಿಗೆ ತೆರೆದು ಇಡಬೇಕು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತೇವಾಂಶವುಳ್ಳ ಗಾಳಿಗೆ ತೆರೆದು ಇಡಬೇಕು."
                ),
                QuestionModel(
                    id = "tet_env_q105",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "105) ಓಝೋನ್ ಇರುವ ವಾಯುಮಂಡಲದ ಪದರ ಭಾಗ",
                    options = listOf("ಹವಾಗೋಲ", "ಅಯಾನುಗೋಳ", "ಬಹಿರಗೋಲ", "ಸ್ತರಗೋಲ"),
                    correctAnswer = "ಸ್ತರಗೋಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ತರಗೋಲ."
                ),
                QuestionModel(
                    id = "tet_env_q106",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "106) ಸೋಸುವ ಕಾಗದದ ಮೇಲೆ ಉಳಿಯುವ ವಸ್ತುವಿಗೆ ..... ಎನ್ನುವರು.",
                    options = listOf("ಅಸವನ", "ರಾಸಾಯನಿಕ ಕ್ರಿಯೆ", "ತ್ಯಜ್ಯವಸ್ತು", "ಶೇಷವಸ್ತು"),
                    correctAnswer = "ಶೇಷವಸ್ತು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶೇಷವಸ್ತು."
                ),
                QuestionModel(
                    id = "tet_env_q107",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "107) ಭೂಮಿಯ ಮೇಲಿರುವ ಗಾಳಿ ಒತ್ತಡದ ಪ್ರಮಾಣವನ್ನು ಮೊದಲು ನಿರ್ಧರಿಸಿದ ವಿಜ್ಞಾನಿ ಯಾರು ?",
                    options = listOf("ಟಾರಿಸ್ಸೇಲ್ಲಿ", "ಫ್ಯಾರಡೆ", "ನ್ಯೂಟನ್", "ಐನಸ್ಟೀನ್"),
                    correctAnswer = "ಟಾರಿಸ್ಸೇಲ್ಲಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಟಾರಿಸ್ಸೇಲ್ಲಿ."
                ),
                QuestionModel(
                    id = "tet_env_q108",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "108) ‘ಜೂನ್ 21’ ಈ ದಿನಾಚರಣೆ",
                    options = listOf("ವಿಶ್ವ ಜಲದಿನ", "ವಿಶ್ವ ಯೋಗದಿನ", "ವಿಶ್ವ ಭೂದಿನ", "ವಿಶ್ವ ಪರಿಸರ ದಿನ"),
                    correctAnswer = "ವಿಶ್ವ ಯೋಗದಿನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಶ್ವ ಯೋಗದಿನ."
                ),
                QuestionModel(
                    id = "tet_env_q109",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "109) ಎತ್ತರದ ಕಟ್ಟಡಗಳು ಹಾಗೂ ವಾಸ್ತುಶಿಲ್ಪಗಳ ಬಳಿ ದೊಡ್ಡ ಲೋಹದ ಸರಳನ್ನು ಕಟ್ಟಡಕ್ಕಿಂತ ಎತ್ತರದಲ್ಲಿ ಭೂಮಿಯ ತನಕ ಬರುವಂತೆ ನೆಡಲು ಕಾರಣ",
                    options = listOf(
                        "ಮಳೆಯಿಂದ ರಕ್ಷಿಸಲು",
                        "ವಿದ್ಯುತ ಅವಘಡದಿಂದ ರಕ್ಷಿಸಲು",
                        "ಮಿಂಚು ಮತ್ತು ಗುಡುಗಿನಿಂದ ರಕ್ಷಿಸಲು",
                        "ಮಿಂಚು ಮತ್ತು ಸಿಡಿಲಿನಿಂದ ರಕ್ಷಿಸಲು"
                    ),
                    correctAnswer = "ಮಿಂಚು ಮತ್ತು ಸಿಡಿಲಿನಿಂದ ರಕ್ಷಿಸಲು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಿಂಚು ಮತ್ತು ಸಿಡಿಲಿನಿಂದ ರಕ್ಷಿಸಲು."
                ),
                QuestionModel(
                    id = "tet_env_q110",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "110) ಶಿಕ್ಷಕರು ತಮ್ಮ ಸೇವಾ ಅವಧಿಯಲ್ಲಿ ದಿನನಿತ್ಯ ತರಗತಿ ಕಲಿಕೆಯನ್ನು ಪರಿಣಾಮಕಾರಿಯಾಗಿಸಲು ನಿರ್ವಹಿಸುವ ದಾಖಲೆ",
                    options = listOf("ಪಾಠ ಯೋಜನೆ", "ದಿನಚರಿ", "ಚಿಂತನಾಶೀಲ ಜರ್ನಲ್", "ವರದಿ"),
                    correctAnswer = "ಚಿಂತನಾಶೀಲ ಜರ್ನಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚಿಂತನಾಶೀಲ ಜರ್ನಲ್."
                ),
                QuestionModel(
                    id = "tet_env_q111",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "111) ಭಾರತದ ಯಾವ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ ಒಂದು ಸರೋವರದ ಮಧ್ಯಭಾಗದಲ್ಲಿದೆ ?",
                    options = listOf("ಕಾಜಿರಂಗ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ", "ಮಧುಪುರ ನ್ಯಾಷನಲ ಪಾರ್ಕ", "ರಂಗನತಿಟ್ಟು ಪಕ್ಷಿಧಾಮ", "ಕ್ಷೀರ ವನ್ಯಧಾಮ"),
                    correctAnswer = "ಮಧುಪುರ ನ್ಯಾಷನಲ ಪಾರ್ಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಧುಪುರ ನ್ಯಾಷನಲ ಪಾರ್ಕ."
                ),
                QuestionModel(
                    id = "tet_env_q112",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "112) ರುಡ ಯಾರ್ಡ ಕಿಪ್ಲಿಂಗನ ಕಾಡಿನ ಕಥೆಗಳಲ್ಲಿ ಸ್ಥಳ ಯಾವುದು ?",
                    options = listOf("ಕೆನಡಾ", "ಮದುಮಲೈ", "ಲಗಾಂಡಾ", "ನೈಜಿರಿಯಾ"),
                    correctAnswer = "ಕೆನಡಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೆನಡಾ."
                ),
                QuestionModel(
                    id = "tet_env_q113",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "113) ಯಾವ ದೇಶ 1984 ರಿಂದ ನ್ಲೂಕಿಯರ ಮುಕ್ತ ವಲಯವನ್ನು ಹೊಂದಿದೆ ?",
                    options = listOf("ಭಾರತ", "ಪಾಕಿಸ್ತಾನ", "ಅಮೇರಿಕಾ", "ನ್ಯೂಜಿಲೆಂಡ"),
                    correctAnswer = "ನ್ಯೂಜಿಲೆಂಡ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನ್ಯೂಜಿಲೆಂಡ."
                ),
                QuestionModel(
                    id = "tet_env_q114",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "114) ಚಳಿಗಾಲದಲ್ಲಿ ಮಲಗುವ ಕೋಣೆಯಲ್ಲಿ ಇರಿಸಿದ ಊರಿಯುವ ಇದ್ದಿಲಿನ ಸ್ಟೋವಗಳು ಆಗಾಗ ಕೋಣೆಯಲ್ಲಿರುವ ವ್ಯಕ್ತಿಗಳನ್ನು ಕೊಲ್ಲುತ್ತವೆ ಹೇಗೆ ?",
                    options = listOf("ಇಂಗಾಲದ ಮೊನಾಕ್ಸೈಡ", "ಇಂಗಾಲದ ಡೈ ಆಕ್ಸೈಡ್", "ಸಲ್ಪರ್ ಆಕ್ಸೈಡ್", "ನೈಟ್ರೋಜನ್ ಆಕ್ಸೈಡ್"),
                    correctAnswer = "ಇಂಗಾಲದ ಮೊನಾಕ್ಸೈಡ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಇಂಗಾಲದ ಮೊನಾಕ್ಸೈಡ."
                ),
                QuestionModel(
                    id = "tet_env_q115",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "115) ಭಾರತೀಯ ಮರಗಳಲ್ಲಿ ವೈದ್ಯಕೀಯವಾಗಿ ಅತ್ಯಂತ ಉಪಯುಕ್ತವಾದುದು ಯಾವುದು ?",
                    options = listOf("ನಿಲಿಗಿರಿ ಮರ", "ಮಾವಿನ ಮರ", "ಬೇವಿನ ಮರ", "ಆಲದ ಮರ"),
                    correctAnswer = "ಬೇವಿನ ಮರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೇವಿನ ಮರ."
                ),
                QuestionModel(
                    id = "tet_env_q116",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "116) ಇಲ್ಲಿಯವರೆಗೆ ಯಾವ ಅಣೆಕಟ್ಟೆಯ ನಿರ್ಮಾಣ ಅತ್ಯಂತ ಅಧಿಕ ಸಂಖ್ಯೆಯ ಜನರನ್ನು ಸ್ಥಾನ ಪಲ್ಲಟ ಗೊಳಿಸಿದೆ ?",
                    options = listOf("ಚೀನಾದಲ್ಲಿ ನಿರ್ಮಿಸಲಾದ ಡ್ಯಾಂ", "ಚೌಕಾನಂಗಲ್ ಡ್ಯಾಂ", "ಆಸ್ಟನ ಹೈಡ್ಯಾಮ ಈಜಿಪ್ಟ", "ನೈಜಿರಿಯಾ ಫಾಲ್ಸ್"),
                    correctAnswer = "ಆಸ್ಟನ ಹೈಡ್ಯಾಮ ಈಜಿಪ್ಟ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆಸ್ಟನ ಹೈಡ್ಯಾಮ ಈಜಿಪ್ಟ."
                ),
                QuestionModel(
                    id = "tet_env_q117",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "117) ಹಿಮನದಿಗಳು ಮತ್ತು ಹಿಮಮುಕುಟಗಳಲ್ಲಿ ಬಂಧಿತವಾಗಿ ಭೂಮಿಯ ನೀರಿನ ಶೇಕಡಾವಾರು ಎಷ್ಟು ?",
                    options = listOf("50%", "40%", "70%", "80%"),
                    correctAnswer = "70%",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 70%."
                ),
                QuestionModel(
                    id = "tet_env_q118",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "118) ಸಂಸ್ಕೃತಿಕ ಮಾಲಿನ್ಯದೊಂದಿಗೆ ನಿಮ್ಮ ನೆರೆಯರು ದೂರದರ್ಶನದ ಧ್ವನಿಯನ್ನು ಗರಿಷ್ಠ ಮಟ್ಟಕ್ಕೆ ತಿರುಗಿಸುವ ಮೂಲಕ ಯಾವ ಮಾಲಿನ್ಯಕ್ಕೆ ಕಾರಣವಾಗಿದ್ದಾರೆ.",
                    options = listOf("ವಾಯುಮಾಲಿನ್ಯ", "ಶಬ್ದ ಮಾಲಿನ್ಯ", "ಜಲ ಮಾಲಿನ್ಯ", "ವಿಕಿರಣ ಮಾಲಿನ್ಯ"),
                    correctAnswer = "ಶಬ್ದ ಮಾಲಿನ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶಬ್ದ ಮಾಲಿನ್ಯ."
                ),
                QuestionModel(
                    id = "tet_env_q119",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "119) ಗೃಹಬಳಕೆಯ ಕೊಳಚೆ ನೀರಿನಲ್ಲಿ ಯಾವುದನ್ನು ಚರಂಡಿಗೆ ವಿಸರ್ಜಿಸಬಾರದು?",
                    options = listOf("ಕೊಳೆತ ಆಹಾರ", "ಪ್ಲಾಸ್ಟಿಕ್ ಪದಾರ್ಥ", "ಎಣ್ಣೆಯುಕ್ತ ಮತ್ತು ಕೊಬ್ಬಿನ ಪದಾರ್ಥಗಳು", "ಮೇಲಿನ ಎಲ್ಲವು"),
                    correctAnswer = "ಎಣ್ಣೆಯುಕ್ತ ಮತ್ತು ಕೊಬ್ಬಿನ ಪದಾರ್ಥಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎಣ್ಣೆಯುಕ್ತ ಮತ್ತು ಕೊಬ್ಬಿನ ಪದಾರ್ಥಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q120",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "120) ಕೆಳಗಿನ ಜೈವಿಕ ಶಿಥಿಲಿಯ ಪದಾರ್ಥವನ್ನು ಗುರುತಿಸಿರಿ",
                    options = listOf("ಮಾರ್ಜಕಗಳು", "ಸೀಸ", "ಪ್ಲಾಸ್ಟಿಕ್", "ಕೊಳೆತ ಆಹಾರದ ಪದಾರ್ಥ"),
                    correctAnswer = "ಕೊಳೆತ ಆಹಾರದ ಪದಾರ್ಥ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೊಳೆತ ಆಹಾರದ ಪದಾರ್ಥ."
                ),
                QuestionModel(
                    id = "tet_env_q121",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "121) ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಜೈವಿಕ ಶಿಥಿಲವಲ್ಲದ ವಸ್ತುವನ್ನು ಗುರುತಿಸಿ",
                    options = listOf("ಸಲ್ಪರ್ ಡೈ ಆಕ್ಸೈಡ್", "ಸಸ್ಯಮೂಲದ ತ್ಯಾಜ್ಯ", "ಪ್ರಾಣಿಮೂಲದ ತ್ಯಾಜ್ಯ", "ಮಾರ್ಜಕಗಳು"),
                    correctAnswer = "ಮಾರ್ಜಕಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾರ್ಜಕಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q122",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "122) ವಲ್ರ್ಡವೈಡ್ ಫಂಡ ಪಾರ್ ನೇಚರ ತನ್ನ ಶುಭಚಿಹ್ನೆಯನ್ನಾಗಿ ಯಾವ ಪ್ರಾಣಿಯನ್ನು ಅಳವಡಿಸಿಕೊಂಡಿದೆ ?",
                    options = listOf("ನವಿಲು", "ಹುಲಿ", "ಸಿಂಹ", "ಪಾಂಡಾ"),
                    correctAnswer = "ಪಾಂಡಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪಾಂಡಾ."
                ),
                QuestionModel(
                    id = "tet_env_q123",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "123) ಯಾವ ಬೆಳೆಯಿಂದ ಹಸಿರು ಕ್ರಾಂತಿ ಪ್ರಾರಂಭವಾಯಿತು?",
                    options = listOf("ಅಕ್ಕಿ", "ಗೋಧಿ", "ಮೆಕ್ಕೆಜೋಳ", "ರಾಗಿ"),
                    correctAnswer = "ಗೋಧಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗೋಧಿ."
                ),
                QuestionModel(
                    id = "tet_env_q124",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "124) ಭಾರತದಲ್ಲಿ ಹಸಿರು ಕ್ರಾಂತಿಯಾವಾಗ ಪ್ರಾರಂಭವಾಯಿತು?",
                    options = listOf("1925", "1940", "1966", "1965"),
                    correctAnswer = "1966",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1966."
                ),
                QuestionModel(
                    id = "tet_env_q125",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "125) ಪರಿಸರ ಪ್ರಜ್ಞೆಯನ್ನು ಉಂಟುಮಾಡುವ ಪುಸ್ತಕ ಇದಾಗಿದೆ",
                    options = listOf("ಸೈಲೆಂಟ್ ಸ್ಪ್ರಿಂಗ್", "ಹಸಿರು ಮನೆ ಪರಿಣಾಮ", "ಪರಿಸರದ ಮಾಲಿನ್ಯ", "ದಿ ಟ್ರೂಥ್"),
                    correctAnswer = "ಸೈಲೆಂಟ್ ಸ್ಪ್ರಿಂಗ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೈಲೆಂಟ್ ಸ್ಪ್ರಿಂಗ್."
                ),
                QuestionModel(
                    id = "tet_env_q126",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "126) ತಾಯಿಯ ಎದೆ ಹಾಲಿನಲ್ಲಿ ಕಾಣಿಸಿಕೊಂಡಿರುವ ರಸಾಯನಿಕ ವಸ್ತು",
                    options = listOf("ಲೆಡ್ ಆಕ್ಸೈಡ್", "ಸಲ್ಪರ ಆಕ್ಸೈಡ್", "ಡಿ.ಡಿ.ಟಿ", "ಕಾರ್ಬನ ಮೊನಾಕ್ಸೈಡ್"),
                    correctAnswer = "ಡಿ.ಡಿ.ಟಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಡಿ.ಡಿ.ಟಿ."
                ),
                QuestionModel(
                    id = "tet_env_q127",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "127) ಘನತ್ಯಾಜ್ಯ (ಸಾಲಿಡ್ ವೇಸ್ಟ್) ಎಂದರೇನು?",
                    options = listOf(
                        "ಸಸ್ಯ ಮೂಲದಿಂದ ಬಂದ ತ್ಯಾಜ್ಯ",
                        "ಪ್ರಾಣಿ ಮೂಲದಿಂದ ಬಂದ ತ್ಯಾಜ್ಯ",
                        "ಗುಜರಿಗೆ ಹಾಕಿದ ಉಪಕರಣ & ವಾಹನಗಳು",
                        "ಮೇಲಿನ ಎಲ್ಲವು"
                    ),
                    correctAnswer = "ಗುಜರಿಗೆ ಹಾಕಿದ ಉಪಕರಣ & ವಾಹನಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗುಜರಿಗೆ ಹಾಕಿದ ಉಪಕರಣ & ವಾಹನಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q128",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "128) ಕ್ರೋಮಿಯಂ ಬಳಸಿದ ವಸ್ತುಗಳು ಉಪಯೋಗ ಒಳ್ಳೆಯ ಅಲೋಚನೆಯಲ್ಲ ಎಕೆ?",
                    options = listOf(
                        "ದುಭಾರಿಯಾಗಿವೆ",
                        "ಹೆಚ್ಚು ಹೊಳಪನ್ನು ಹೊಂದಿವೆ",
                        "ಕ್ಯಾನ್ಸರ ತರುವ ಗುಣವನ್ನು ಹೊಂದಿವೆ",
                        "ಪರಿಸರ ಮಾಲಿನ್ಯಕ್ಕೆ ಕಾರಣವಾಗಿವೆ"
                    ),
                    correctAnswer = "ಕ್ಯಾನ್ಸರ ತರುವ ಗುಣವನ್ನು ಹೊಂದಿವೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ಯಾನ್ಸರ ತರುವ ಗುಣವನ್ನು ಹೊಂದಿವೆ."
                ),
                QuestionModel(
                    id = "tet_env_q129",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "129) ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ಮೂಳಯಲ್ಲಿ ಸೇರಿಕೊಂಡು ಬಿಳಿರಕ್ತ ಕಣಗಳ ಉತ್ಪತ್ತಿಯನ್ನು ತಡೆಯುತ್ತದೆ?",
                    options = listOf("ಕಾರ್ಬನ 12", "ಪ್ಲೊಟೊನಿಯಂ-239", "ಯುರೆನಿಯಂ-235", "ಅಮರೆಸಿಯಂ"),
                    correctAnswer = "ಪ್ಲೊಟೊನಿಯಂ-239",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪ್ಲೊಟೊನಿಯಂ-239."
                ),
                QuestionModel(
                    id = "tet_env_q130",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "130) ಮಾಲಿನ್ಯ ನಿಯಂತ್ರಣ ಬರುವುದಕ್ಕಿಂತ ಮುಂಚೆ ಯುರೋಪಿನ ಯಾವ ನದಿ ಚರಂಡಿಯಾಗಿತ್ತು?",
                    options = listOf("ರೈನ್", "ಥೇಮ್ಸ", "ನರ್ಮದಾ", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ರೈನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರೈನ್."
                ),
                QuestionModel(
                    id = "tet_env_q131",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "131) ಹಸಿರು ಮನೆ ಪರಿಣಾಮಕ್ಕೆ ಅನೇಕ ಅನಿಲಗಳು ಕಾರಣವಾಗಿವೆ ಅದರಲ್ಲಿ ಅತ್ಯಂತ ಹೆಚ್ಚಿನ ಕಾಣಿಕೆ ನೀಡುವ ಅನಿಲ",
                    options = listOf("CO²", "NO²", "SO²", "PBO"),
                    correctAnswer = "CO²",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: CO²."
                ),
                QuestionModel(
                    id = "tet_env_q132",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "132) ಗಾಳಿ ನೀರು ಮಣ್ಣು ಈ ಮಾಲಿನ್ಯಗಳಲ್ಲಿ ಯಾವುದರಿಂದ ಮಾನವನಿಗೆ ಹೆಚ್ಚಿನ ರೋಗಗಳು ಬರುತ್ತವೆ ?",
                    options = listOf("ವಾಯು ಮಾಲಿನ್ಯ", "ಜಲಮಾಲಿನ್ಯ", "ನೆಲ ಮಾಲಿನ್ಯ", "ವಿಕಿರಣ ಮಾಲಿನ್ಯ"),
                    correctAnswer = "ಜಲಮಾಲಿನ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಲಮಾಲಿನ್ಯ."
                ),
                QuestionModel(
                    id = "tet_env_q133",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "133) ಪೆಟ್ರೋಲ್ ದಹನದಿಂದ ಹೊರಬರುವ ಲೋಹ ಇದಾಗಿದೆ",
                    options = listOf("ಕಾರ್ಬನ", "ಲೆಡ್", "ಹೈಡ್ರೋಜನ್", "ಸೀಸ"),
                    correctAnswer = "ಸೀಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೀಸ."
                ),
                QuestionModel(
                    id = "tet_env_q134",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "134) ಸ್ಟ್ರೆಂಜ್ ಲವ್ ಓಷೀನ್ ಯಾವುದನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
                    options = listOf(
                        "ಸಮುದ್ರವನ್ನು",
                        "ಕೆಂಪು ಸಮುದ್ರವನ್ನು",
                        "ನ್ಯೂಕ್ಲಿಯರ ಸ್ಪೋಟದಿಂದ ಉಳಿಕ ನಿರ್ಜೀವ ಸಾಗರ",
                        "ಮೇಲಿನ ಎಲ್ಲವೂ"
                    ),
                    correctAnswer = "ನ್ಯೂಕ್ಲಿಯರ ಸ್ಪೋಟದಿಂದ ಉಳಿಕ ನಿರ್ಜೀವ ಸಾಗರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನ್ಯೂಕ್ಲಿಯರ ಸ್ಪೋಟದಿಂದ ಉಳಿಕ ನಿರ್ಜೀವ ಸಾಗರ."
                ),
                QuestionModel(
                    id = "tet_env_q135",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "135) ಬೇಸಾಯದಲ್ಲಿ ವ್ಯಾಪಕ ಡಿ. ಡಿ. ಟಿ ಯ ಬಳಕೆ ಪಕ್ಷಿಗಳಿಗೆ ಎನನ್ನು ಉಂಟು ಮಾಡುತ್ತದೆ?",
                    options = listOf("ಬೇಗ ಮೊಟ್ಟೆಯನ್ನು ಇಡುತ್ತದೆ", "ಮೊಟ್ಟೆಯ ಗಾತ್ರ ದೊಡ್ಡದು", "ಮೊಟ್ಟೆಯ ಪದರು ತೆಳುವಾಗಿದೆ", "ಮೊಟ್ಟೆಯ ಪದರು ದಪ್ಪವಾಗಿದೆ"),
                    correctAnswer = "ಮೊಟ್ಟೆಯ ಪದರು ತೆಳುವಾಗಿದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೊಟ್ಟೆಯ ಪದರು ತೆಳುವಾಗಿದೆ."
                ),
                QuestionModel(
                    id = "tet_env_q136",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "136) ಹಸಿರು ಮನೆಯ ಪರಿಣಾಮ ಸಹನೀಯ ಮಿತಿಯನ್ನು ದಾಟಿದರೆ ಏನು ಸಂಭವಿಸುತ್ತದೆ?",
                    options = listOf("ಭೂಮಿಯ ಮೇಲೆ ಉಷ್ಣತೆ ಹೆಚ್ಚಾಗುವದು", "ಸರಾಸರಿ ಉಷ್ಣತೆ ಹೆಚ್ಚಾಗುವದು", "ಹಿಮ ಕರಗುವದು", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_env_q137",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "137) ಮಾನವನ ದೇಹದ ಯಾವ ಭಾಗ ಜೈವಿಕ ವಿಕಿರಣಕ್ಕೆ ಅತ್ಯಂತ ಸುಲಭವಾಗಿ ತುತ್ತಾಗುತ್ತದೆ",
                    options = listOf("ಸ್ನಾಯುಗಳು", "ಹೃದಯ", "ಮೂಳೆ", "ರಕ್ತ"),
                    correctAnswer = "ಮೂಳೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೂಳೆ."
                ),
                QuestionModel(
                    id = "tet_env_q138",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "138) ಯಾವ ಸಸ್ಯಗಳನ್ನು ವಾತಾವರಣದ ಮಾಲಿನ್ಯ ಪರೀಕ್ಷಾ ಸಾಧನವನ್ನಾಗಿ ಬಳಸಲಾಗುತ್ತದೆ",
                    options = listOf("ಶೀಲಿಂಧ್ರ", "ಶೈವಲಗಳು", "ಲೈಕಿನ್ಸ", "ಹಾವಸೆ ಸಸ್ಯಗಳು"),
                    correctAnswer = "ಲೈಕಿನ್ಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಲೈಕಿನ್ಸ."
                ),
                QuestionModel(
                    id = "tet_env_q139",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "139) ರೈತ ಮಿತ್ರ ಎಂದು ಕರೆಯಲ್ಪಡುವ ಅಕಶೇರುಕ",
                    options = listOf("ಜಂತು ಹುಳಗಳು", "ಲಾಡಿ ಹುಳಗಳು", "ಎರೆ ಹುಳಗಳು", "ಕೊಕ್ಕರೆ ಹುಳ"),
                    correctAnswer = "ಎರೆ ಹುಳಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎರೆ ಹುಳಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q140",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "140) ಯಾವ ದೇಶ 2010 ರ ವರೆಗೆ ಹಂತ ಹಂತವಾಗಿ ನೂಕ್ಲಿಯರ್ ಶಕ್ತಿ ಕೇಂದ್ರಗಳನ್ನು ಮುಚ್ಚಲು ನಿರ್ಧಾರ ಮಾಡಿದೆ?",
                    options = listOf("ಜಪಾನ", "ಸ್ವಿಡನ್", "ಭಾರತ", "ಅಮೆರಿಕಾ"),
                    correctAnswer = "ಸ್ವಿಡನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ವಿಡನ್."
                ),
                QuestionModel(
                    id = "tet_env_q141",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "141) ನ್ಯೂಕ್ಲಿಯರ ಮೀಟರ್ ಎಂದರೇನು?",
                    options = listOf(
                        "ವಿದಳನದಲ್ಲಿ ಉಂಟಾಗುವ ನ್ಯೂಟನಗಳನ್ನು ಅಳೆಯುವದು",
                        "ವಿದಳನದಲ್ಲಿ ಉಂಟಾಗುವ ಉಷ್ಣತೆಯನ್ನು ಅಳೆಯುವುದು",
                        "ಭೈಜಿಕ ವಿಸ್ಪೋಟದ ನಂತರ ತಾಪಮಾನದಲ್ಲಿ ಆಗುವ ಆಗದ ಕುಸಿತ",
                        "ವಿದಳನದಲ್ಲಿನ ಶಕ್ತಿ ಪ್ರಮಾಣವನ್ನು ಅಳೆಯುವದು"
                    ),
                    correctAnswer = "ಭೈಜಿಕ ವಿಸ್ಪೋಟದ ನಂತರ ತಾಪಮಾನದಲ್ಲಿ ಆಗುವ ಆಗದ ಕುಸಿತ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಭೈಜಿಕ ವಿಸ್ಪೋಟದ ನಂತರ ತಾಪಮಾನದಲ್ಲಿ ಆಗುವ ಆಗದ ಕುಸಿತ."
                ),
                QuestionModel(
                    id = "tet_env_q142",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "142) ಏಕಲಾಜಿಕಲ್ ವಿಜಡಮ್ (ಪರಿಸರ ವಿಮೋಚನೆ) ಎಂದರೇನು?",
                    options = listOf(
                        "ಮಾನವನು ಪರಿಸರದ ಒಡೆಯ",
                        "ಮಾನವ ಪರಿಸರದ ಸೇವಕ",
                        "ಮಾನವನು ಪರಿಸರದ ಒಂದು ಭಾಗ",
                        "ಮಾನವನಿಂದಲೇ ಪರಿಸರ"
                    ),
                    correctAnswer = "ಮಾನವನು ಪರಿಸರದ ಒಂದು ಭಾಗ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾನವನು ಪರಿಸರದ ಒಂದು ಭಾಗ."
                ),
                QuestionModel(
                    id = "tet_env_q143",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "143) ಮರಗಳನ್ನು ಅವುಗಳ ಪರಿಸರಕ್ಕೆ ಸಂಬಂಧಿಸಿದಂತೆ ವ್ಯಕ್ತಿಗಳನ್ನಾಗಿ ಅಧ್ಯಯನ ಮಾಡುವ ವಿಭಾಗ",
                    options = listOf("ಎಕಲೋಜಿ", "ಅಪಕಾಲಜಿ", "ಪೆಲಿಯುಟಾಲೋಜಿ", "ಫಾಸಿಲಸ ಅಪಿಯನ್"),
                    correctAnswer = "ಅಪಕಾಲಜಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಪಕಾಲಜಿ."
                ),
                QuestionModel(
                    id = "tet_env_q144",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "144) ನೀರಿನಲ್ಲಿ ಫಾಸ್ಪೇಟ ಪ್ರಮಾಣ ಹೆಚ್ಚಾಗುವಿಕೆ ಯನ್ನು ಹೀಗೆನ್ನುವರು",
                    options = listOf("ಸೆಲೈನೆಗನ್", "ಯುಟ್ರೋಪಿಕೆಶನ", "ಬಯೋಮ್ಸೆನ್ನಿ ಪಿಕೋಶಸ್", "ಗ್ಲೋಬಲ್ ವಾರ್ಮಿಂಗ್"),
                    correctAnswer = "ಯುಟ್ರೋಪಿಕೆಶನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯುಟ್ರೋಪಿಕೆಶನ."
                ),
                QuestionModel(
                    id = "tet_env_q145",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "145) ಬಿ.ಓ.ಡಿ ಹೆಚ್ಚಾದಾಗ ಇದು ಇದನ್ನು ಸೂಚಿಸುತ್ತದೆ.",
                    options = listOf(
                        "ನೀರು ಶುದ್ದವಾಗಿದೆ",
                        "ನೀರಿನಲ್ಲಿ ಸೂಕ್ಷ್ಮಾಣು ಜೀವಿಗಳ ಇಲ್ಲ",
                        "ನೀರಿನಲ್ಲಿ ಸೂಕ್ಷ್ಮಾಣು ಜೀವಿಗಳ ಸಂಖ್ಯೆ ಹೆಚ್ಚು",
                        "ನೀರಿನಲ್ಲಿ ಸೂಕ್ಷ್ಮಣು ಜೀವಿಗಳ ಸಂಖ್ಯೆ ಕಡಿಮೆ"
                    ),
                    correctAnswer = "ನೀರಿನಲ್ಲಿ ಸೂಕ್ಷ್ಮಾಣು ಜೀವಿಗಳ ಸಂಖ್ಯೆ ಹೆಚ್ಚು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೀರಿನಲ್ಲಿ ಸೂಕ್ಷ್ಮಾಣು ಜೀವಿಗಳ ಸಂಖ್ಯೆ ಹೆಚ್ಚು."
                ),
                QuestionModel(
                    id = "tet_env_q146",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "146) 1960 ರಿಂದ ಈಚೆಗೆ ಕಾರ್ಬನ ಡೈ ಆಕ್ಸೈಡ ಪ್ರಮಾಣದಲ್ಲಿ ಆದ ಏರಿಕೆ",
                    options = listOf("25%", "20%", "14%", "30%"),
                    correctAnswer = "14%",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 14%."
                ),
                QuestionModel(
                    id = "tet_env_q147",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "147) ಕೆಳಗಿನವುಗಳಲ್ಲಿನ ಯಾವ ಅನಿಲವು ಹಸಿರುಮನೆ ಪರಿಣಾಮಕ್ಕೆ ಕಾರಣವಾಗಿಲ್ಲ?",
                    options = listOf("CO₂", "CO", "N₂O", "CH₄"),
                    correctAnswer = "CH₄",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: CH₄."
                ),
                QuestionModel(
                    id = "tet_env_q148",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "148) ಓಜೋನ್ ಪದರು ಕ್ಷೀಣಿಸಲು ಕಾರಣವಾದ ಅನಿಲಗಳು",
                    options = listOf("ನೈಟ್ರಸ ಅಕ್ಸೈಡ", "ಕಾರ್ಬನ ಮೊನಾಕ್ಸೈಡ್", "ಹೈಡ್ರೋಕಾರ್ಬನಗಳು", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_env_q149",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "149) ಮುಂದವರೆದ ದೇಶಗಳು ವಾತಾವರಣಕ್ಕೆ ಬಿಡುತ್ತಿರುವ CO₂ ಪ್ರಮಾಣ ಇದಾಗಿದೆ",
                    options = listOf("25%", "50%", "75%", "100%"),
                    correctAnswer = "75%",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 75%."
                ),
                QuestionModel(
                    id = "tet_env_q150",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "150) ಜಾಗತಿಕ ತಾಪದ ಎರಿಕೆಯಿಂದ ಭೂಮಿಯ ಮೇಲೆ ನೀರಿನ ಪ್ರಮಾಣದಲ್ಲಿ ಆದ ಹೆಚ್ಚಳ",
                    options = listOf("10mm ರಿಂದ 25m", "10cm ರಿಂದ 25cm", "100cm ರಿಂದ 250cm", "100m ರಿಂದ 250m"),
                    correctAnswer = "10cm ರಿಂದ 25cm",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 10cm ರಿಂದ 25cm."
                ),
                QuestionModel(
                    id = "tet_env_q151",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "151) ಕಾರ್ಬನ ಮಾನಕ್ಸೈಡೆಗೆ ಸಂಬದಿಸಿದಂತೆ ಸರಿಯಾದ ಹೆಳಿಕೆಯನ್ನು ಗುರುತಿಸಿರಿ",
                    options = listOf(
                        "ಆಮ್ಲ ಮಳೆಯನ್ನುಂಟು ಮಾಡುತ್ತಿದೆ",
                        "ಕ್ಯಾನ್ಸರ ರೋಗಕ್ಕೆ ಕಾರಣವಾಗಿದೆ",
                        "ವಾಹನಗಳ ಇಂಜಿನಗಳ ದಹನ ಕ್ರೀಯೆಯಿಂದ ಉಂಟಾಗುತ್ತದೆ",
                        "ಮೇಲಿನವು ಎಲ್ಲವು"
                    ),
                    correctAnswer = "ವಾಹನಗಳ ಇಂಜಿನಗಳ ದಹನ ಕ್ರೀಯೆಯಿಂದ ಉಂಟಾಗುತ್ತದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಾಹನಗಳ ಇಂಜಿನಗಳ ದಹನ ಕ್ರೀಯೆಯಿಂದ ಉಂಟಾಗುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_env_q152",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "152) ಸಸ್ಯಗಳಿಗೂ ಜೀವವಿದೆ ಎಂಬುದನ್ನು ಗುರುತಿಸಿದ ಭಾರತೀಯ ವ್ಯಕ್ತಿ ಯಾರು?",
                    options = listOf("ಸಿ.ವಿ. ರಾಮನ್", "ಜಗದೀಶ ಚಂದ್ರ ಬೋಸ", "ರಾಮಾನುಜನ್", "ಅಬ್ದುಲ್ ಕಲಾಂ"),
                    correctAnswer = "ಜಗದೀಶ ಚಂದ್ರ ಬೋಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಗದೀಶ ಚಂದ್ರ ಬೋಸ."
                ),
                QuestionModel(
                    id = "tet_env_q153",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "153) ಮರಭೂಮಿಗಳ ವಿಸ್ತರಣೆಯನ್ನು ತಡೆಯಲು ಅತ್ಯುತಮವಾದ ಕ್ರಮ ಯಾವುದು?",
                    options = listOf("ಕಾಲುವೆಗಳನ್ನು ತೆಗೆಯುವದು", "ಕಾಡುಗಳನ್ನು ಬೆಳೆಸುವದು", "ಕೃತಕ ಮಳೆಯನ್ನು ತರೆಸುವುದು", "ಜಲಾಶಯಗಳನ್ನು ನಿರ್ಮಿಸುವುದು"),
                    correctAnswer = "ಕಾಡುಗಳನ್ನು ಬೆಳೆಸುವದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾಡುಗಳನ್ನು ಬೆಳೆಸುವದು."
                ),
                QuestionModel(
                    id = "tet_env_q154",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "154) ಹೈಡ್ರೋಫೈಟ್ ಎಂಬುದು",
                    options = listOf("ನೀರು ಪ್ರಾಣಿ", "ನೀರಿನಲ್ಲಿ ಬೆಳೆಯು ಸಸ್ಯ", "ಸಸ್ಯಗಳಿಗೆ ಬುರವ ಒಂದು ರೋಗ", "ಬೇರು ರಹಿತ ಸಸ್ಯ"),
                    correctAnswer = "ನೀರಿನಲ್ಲಿ ಬೆಳೆಯು ಸಸ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೀರಿನಲ್ಲಿ ಬೆಳೆಯು ಸಸ್ಯ."
                ),
                QuestionModel(
                    id = "tet_env_q155",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "155) ವಾತಾವರಣದಲ್ಲಿರುವ ಜೈವಿಕ ಮತ್ತು ಅಜೈವಿಕ ಘಟಕಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
                    options = listOf("ಜೀವ ಮಂಡಲ", "ಪರಿಸರ", "ಜೀವ ವ್ಯವಸ್ಥೆ", "ಬಯೋಮ್"),
                    correctAnswer = "ಪರಿಸರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಿಸರ."
                ),
                QuestionModel(
                    id = "tet_env_q156",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "156) ಸಾಮಾನ್ಯವಾಗಿ ಯಾವ ಋತುವಿನಲ್ಲಿ ಧ್ವನಿ ವೇಗ ಹೆಚ್ಚಾಗುತ್ತದೆ.?",
                    options = listOf("ಚಳಿಗಾಲ", "ಮಳೆಗಾಲ", "ಬೇಸಿಗೆ ಕಾಲ", "ಎಲ್ಲಾ ಋತುವಿನಲ್ಲಿ"),
                    correctAnswer = "ಮಳೆಗಾಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಳೆಗಾಲ."
                ),
                QuestionModel(
                    id = "tet_env_q157",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "157) ಎಲ್ ನಿನೋ ಕೆಳಗಿನ ಯಾವುದಕ್ಕೆ ಸಂಬಂಧಿಸಿದೆ.",
                    options = listOf("ಮಾನ್ಸೂನ್ಗಳು", "ಜ್ವಾಲಾಮುಖಿಗಳು", "ಭೂಕಂಪಗಳು", "ಸುನಾಮಿಗಳು"),
                    correctAnswer = "ಮಾನ್ಸೂನ್ಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾನ್ಸೂನ್ಗಳು."
                ),
                QuestionModel(
                    id = "tet_env_q158",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "158) ಭೂವಾತಾವರಣಕ್ಕೆ ಸಸ್ಯಗಳು ಯಾವ ಅನಿಲವನ್ನು ಕೊಡುತ್ತವೆ?",
                    options = listOf("ನೈಟ್ರೋಜನ್", "ಜಲಜನಕ", "ಆಮ್ಲಜನಕ", "ಇಂಗಾಲದ ಡೈ ಆಕ್ಸೈಡ"),
                    correctAnswer = "ಆಮ್ಲಜನಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆಮ್ಲಜನಕ."
                ),
                QuestionModel(
                    id = "tet_env_q159",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "159) ಒಂಟೆಯ ಡುಬ್ಬದಲ್ಲಿ ಏನಿರುತ್ತದೆ.?",
                    options = listOf("ನೀರು ಇರುವುದಿಲ್ಲ", "ಕೊಬ್ಬು ಇರುತ್ತದೆ.", "2 ಲೀಟರ್ ನೀರುತ್ತದೆ", "4 ಲೀಟರ್ ನೀರಿರುತ್ತದೆ"),
                    correctAnswer = "ಕೊಬ್ಬು ಇರುತ್ತದೆ.",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೊಬ್ಬು ಇರುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_env_q160",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "160) ಭಾರದಲ್ಲಿ ಹಸಿರು ಕ್ರಾಂತಿಗೆ ಕಾರಣವಾದ ಪ್ರಸಿದ್ಧ ಭಾರತೀಯ ವ್ಯಕ್ತಿ ಯಾರು?",
                    options = listOf("ನಾರ್ಮನ ಬೋರ್ಲಾಗ್", "ಸಲೀಮ್ ಅಲಿ", "ಎಂ.ಎಸ್ ಸ್ವಾಮಿನಾಥನ್", "ಎಂ.ಎಸ್. ವೈದ್ಯನಾಥನ್"),
                    correctAnswer = "ಎಂ.ಎಸ್ ಸ್ವಾಮಿನಾಥನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎಂ.ಎಸ್ ಸ್ವಾಮಿನಾಥನ್."
                ),
                QuestionModel(
                    id = "tet_env_q161",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "161) ಕಪ್ಪು ಮಣ್ಣು ಯಾವ ಬೆಳೆಯನ್ನು ಬೆಳೆಯಲು ಹೆಚ್ಚು ಯೋಗ್ಯವಾಗಿದೆ.",
                    options = listOf("ಭತ್ತ", "ಹತ್ತಿ", "ಗೋಧಿ", "ಆಲೂಗಡ್ಡೆ"),
                    correctAnswer = "ಹತ್ತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹತ್ತಿ."
                ),
                QuestionModel(
                    id = "tet_env_q162",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "162) ಕೆಳಗೆ ಕೊಟ್ಟಿರುವ ಅಂಶಗಳಲ್ಲಿ ಯಾವುದು ಮಣ್ಣಿನ ಅಭಿವೃದ್ಧಿಗೆ ಭಾದಕ ಉಂಟು ಮಾಡುವುದಿಲ್ಲ.?",
                    options = listOf("ವಾಯುಗುಣ", "ಭೂಸ್ವರೂಪ", "ಮೂಲ ವಸ್ತುಗಳು", "ಅಂತರ್ಜಲದ ಗುಣಮಟ್ಟ"),
                    correctAnswer = "ಅಂತರ್ಜಲದ ಗುಣಮಟ್ಟ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಂತರ್ಜಲದ ಗುಣಮಟ್ಟ."
                ),
                QuestionModel(
                    id = "tet_env_q163",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "163) ಭಾರತದಲ್ಲಿ ಯಾವ ಎರಡು ಸ್ಥಳಗಳು ವರ್ಷಕ್ಕೆ 1080 ಸೆ.ಮೀ.ಗಿಂತ ಹೆಚ್ಚಿಗೆ ಮಳೆಯನ್ನು ಪಡೆಯುತ್ತವೆ.?",
                    options = listOf("ಚಿರಾಪುಂಜಿ ಮತ್ತು ಗೋಲ್ ಘಾಟ್", "ಚಿರಾಪುಂಜಿ ಮತ್ತು ಮೌಸಿನ್ ರಾಮ್", "ಆಗುಂಬೆ ಮತ್ತು ಸೂಪಾ", "ಆಗುಂಬೆ ಮತ್ತು ಕೆಮ್ಮಣ್ಣುಗುಂಡಿ"),
                    correctAnswer = "ಚಿರಾಪುಂಜಿ ಮತ್ತು ಮೌಸಿನ್ ರಾಮ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚಿರಾಪುಂಜಿ ಮತ್ತು ಮೌಸಿನ್ ರಾಮ್."
                ),
                QuestionModel(
                    id = "tet_env_q164",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "164) ವಿಶ್ವ ಪರಿಸರ ದಿನ ಯಾವಾಗ ಆಚರಿಸುತ್ತಾರೆ?",
                    options = listOf("ಮೇ-31", "ಜುಲೈ-4", "ಜೂನ್-5", "ಜೂನ್-4"),
                    correctAnswer = "ಜೂನ್-5",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜೂನ್-5."
                ),
                QuestionModel(
                    id = "tet_env_q165",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "165) ವಿಶ್ವ ಜಲ ದಿನ ಯಾವಾಗ?",
                    options = listOf("ನವ್ಹೆಂಬರ್-14", "ಮಾರ್ಚ-22", "ಮಾರ್ಚ-21", "ಡಿಸೆಂಬರ್-20"),
                    correctAnswer = "ಮಾರ್ಚ-21",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾರ್ಚ-21."
                ),
                QuestionModel(
                    id = "tet_env_q166",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 6,
                    type = "MCQ",
                    questionText = "166) ಪ್ರಪಂಚದ ಮೊದಲ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ ಯಾವುದು.?",
                    options = listOf(
                        "ಮನುರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ",
                        "ಹಳದಿಯ ಕಲಿನ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ",
                        "ರೆನಝೋರಿ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ",
                        "ಯೋಸಿಮೈಲ್ ರಾಷ್ಟೀಯ ಉದ್ಯಾನವನ"
                    ),
                    correctAnswer = "ಹಳದಿಯ ಕಲಿನ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹಳದಿಯ ಕಲಿನ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ."
                )
            ) + TetEnvironmentExtraQuestions.questions
        }
}
