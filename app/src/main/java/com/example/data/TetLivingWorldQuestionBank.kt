package com.example.data

/**
 * TET (Teacher Eligibility Test - Standard / Exam ID: 13)
 * Subject: EVS, Science & Social Pedagogy ("general_science")
 * Unit 10: 9. ಜೈವಿಕ ಪ್ರಪಂಚ (Living World) — 74 MCQs.
 */
object TetLivingWorldQuestionBank {

    val unitTemplate = UnitTemplate(
        id = 10,
        name = "9. ಜೈವಿಕ ಪ್ರಪಂಚ (Living World)",
        totalQuestions = 74,
        difficulty = "Medium"
    )

    val questions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetLivingWorld") {
            listOf(
                QuestionModel(
                    id = "tet_lw_q1",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "1) ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಬಟ್ಟೆ ಉತ್ಪಾದನೆಗೆ ಬೆಳಸುವ ಸಸ್ಯ",
                    options = listOf("ಹತ್ತಿ", "ಆಲೂಗಡ್ಡೆ", "ಕ್ಯಾರೆಟ್", "ತೆಂಗಿನಕಾಯಿ"),
                    correctAnswer = "ಹತ್ತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹತ್ತಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q2",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "2) ವಿಟಾಮಿನ ‘ಎ’ ಪೂರಿತ ಕುಲಾಂತರಿ ಸಸ್ಯ",
                    options = listOf("ಹೊಗೆಸೊಪ್ಪು", "ಪೋವರ್ ಸೆವರ ಟೊಮ್ಯಾಟೋ", "ಚಿನ್ನದ ಬಣ್ಣದ ಅಕ್ಕಿ", "ಬಿ.ಟಿ.ಹತ್ತಿ"),
                    correctAnswer = "ಚಿನ್ನದ ಬಣ್ಣದ ಅಕ್ಕಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚಿನ್ನದ ಬಣ್ಣದ ಅಕ್ಕಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q3",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "3) ಪೋಷಕ ಲವಣಗಳ ದ್ರವಗಳಲ್ಲಿ ಸಸ್ಯಗಳನ್ನು ಬೆಳೆಯುವ ವಿಧಾನ.",
                    options = listOf("ಜಲಕೃಷಿ", "ವಾಯು ಕೃಷಿ", "ಹನಿ ನೀರಾವರಿ", "ಸಿಂಚನ ಕೃಷಿ."),
                    correctAnswer = "ಜಲಕೃಷಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಲಕೃಷಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q4",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "4) ಇದು ಒಂದು ಮಾನವ ನಿರ್ಮಿತ ಮಿಶ್ರಕ.",
                    options = listOf("ಕೇಸರಿ", "ಬೀಟರೂಟ", "ಅರಶಿನ", "ಸ್ಯಾಕರಿನ್"),
                    correctAnswer = "ಸ್ಯಾಕರಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ಯಾಕರಿನ್."
                ),
                QuestionModel(
                    id = "tet_lw_q5",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "5) ಇದು ಒಂದು ಸಂಕರಣ ತಳಿ",
                    options = listOf("ಜರ್ಸಿ", "ಸಿಂಧ್", "ಹಳ್ಳಿಕಾರ", "ಕರಣ್ ಸ್ಪಿಸ್"),
                    correctAnswer = "ಕರಣ್ ಸ್ಪಿಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕರಣ್ ಸ್ಪಿಸ್."
                ),
                QuestionModel(
                    id = "tet_lw_q6",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "6) ರೇಷ್ಮೆ ಹುಳು ಸಾಕಾಣಿಕೆಯನ್ನು ಹೀಗೆ ಕರೆಯುತ್ತಾರೆ.",
                    options = listOf("ಎಲೆಕಲ್ಟರ್", "ಹಾರ್ಟಿಕಲ್ಟರ್", "ಸೆರಿಕಲ್ಟರ್", "ಪಿಸಿಕಲ್ಟರ್"),
                    correctAnswer = "ಸೆರಿಕಲ್ಟರ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೆರಿಕಲ್ಟರ್."
                ),
                QuestionModel(
                    id = "tet_lw_q7",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "7) ಒಂದು ಜೀವಕೋಶದಲ್ಲಿ ವರ್ಣತಂತು ಗುಂಪುಗಳ ಸಂಖ್ಯೆಯನ್ನು ಕೃತಕವಾಗಿ ಹೆಚ್ಚಿಸಬಹುದು.",
                    options = listOf("ಟೋಟಿ ಪೊಟೆನ್ಸಿ", "ಎಡಿಪೊಟಿನ್ಸಿ", "ಅಂಗಾಂಶ ಕೃಷಿ", "ಭ್ರೂಣ ಕೋಶಗಳು"),
                    correctAnswer = "ಟೋಟಿ ಪೊಟೆನ್ಸಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಟೋಟಿ ಪೊಟೆನ್ಸಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q8",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "8) ಇದರಿಂದ ಜೀವಕೋಶದಲ್ಲಿ ವರ್ಣತಂತು ಗುಂಪುಗಳ ಸಂಖ್ಯೆಯನ್ನು ಕೃತಕವಾಗಿ ಹೆಚ್ಚಿಸಬಹುದು.",
                    options = listOf("ಸ್ಯಾಕರಿನ", "ಪ್ಯಾರಾಷಿನ್", "ಕೋಲ್ಚಿಸಿನ್", "ವರ್ಣಕ"),
                    correctAnswer = "ಕೋಲ್ಚಿಸಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೋಲ್ಚಿಸಿನ್."
                ),
                QuestionModel(
                    id = "tet_lw_q9",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "9) ಕೀಟಗಳ ಉಸಿರಾಟದ ಅಂಗ.",
                    options = listOf("ನಳಕಾಪಾದ", "ಚರ್ಮ", "ಟಿನೀಡಿಯಾ", "ಟ್ರೇಕೆಯಾ"),
                    correctAnswer = "ಟ್ರೇಕೆಯಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಟ್ರೇಕೆಯಾ."
                ),
                QuestionModel(
                    id = "tet_lw_q10",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "10) ಅಮೀಬಾದ ಚಲನಾಂಗ.",
                    options = listOf("ಮಿಥ್ಯಾಪಾದ", "ಕಂಬಳ್ಳಿ", "ಈಜುರೆಕ್ಕೆ", "ನಳಕಪಾದ"),
                    correctAnswer = "ಮಿಥ್ಯಾಪಾದ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಿಥ್ಯಾಪಾದ."
                ),
                QuestionModel(
                    id = "tet_lw_q11",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "11) ಕುದುರೆಯ ವೈಜ್ಞಾನಿಕ ಹೆಸರು",
                    options = listOf("ಈಕ್ರಸ್ ಏಸಿನಸ್", "ಫೆಲಿಸ್ ಟೊಮೆಸ್ಟಿಕಾ", "ಕ್ಯಾನಿಸ್ ಫೆಮಿಲಿಯಾರಿಸ", "ಈಕ್ವ್ಯಾಸ್ ಕೆಬಾಲಸ್"),
                    correctAnswer = "ಈಕ್ವ್ಯಾಸ್ ಕೆಬಾಲಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಈಕ್ವ್ಯಾಸ್ ಕೆಬಾಲಸ್."
                ),
                QuestionModel(
                    id = "tet_lw_q12",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "12) ವರ್ಗೀಕರಣದ ಮೂಲ ಘಟಕ",
                    options = listOf("ಜಾತಿ", "ಕುಟುಂಬ", "ಪ್ರಭೇದ", "ವರ್ಗ"),
                    correctAnswer = "ಪ್ರಭೇದ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪ್ರಭೇದ."
                ),
                QuestionModel(
                    id = "tet_lw_q13",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "13) ಆಧುನಿಕ ವರ್ಗಿಕರಣ ಶಾಸ್ತ್ರದ ಪಿತಾಮಹ",
                    options = listOf("ಅರಿಸ್ಟಾಟಲ್", "ಕರೋಲಸ್ ಲಿನೀಯಸ್", "ಚರಕ", "ಶುಶ್ರುತ"),
                    correctAnswer = "ಕರೋಲಸ್ ಲಿನೀಯಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕರೋಲಸ್ ಲಿನೀಯಸ್."
                ),
                QuestionModel(
                    id = "tet_lw_q14",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "14) ಹಸುವಿನ ವೈಜ್ಞಾನಿಕ ಹೆಸರು",
                    options = listOf("ಬಾಸ್ ಇಂಡಿಕಸ್", "ಬಾಸ್ ಟಾರಸ", "ಫೆಲಿಸ ಲಿಯೋ", "ಹೆವಿಲೋ ಸೇಪಿಯನ್ಸ್"),
                    correctAnswer = "ಬಾಸ್ ಟಾರಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬಾಸ್ ಟಾರಸ."
                ),
                QuestionModel(
                    id = "tet_lw_q15",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "15) ನಾಯಿಕೊಡೆ ಸೇರಿರುವ ಸಾಮ್ರಾಜ್ಯ",
                    options = listOf("ಮೊನೆರಾ ಸಾಮ್ರಾಜ್ಯ", "ಮೈಕೋಟಾ ಸಾಮ್ರಾಜ್ಯ", "ಸಸ್ಯ ಸಾಮ್ರಾಜ್ಯ", "ಪೋಟಿಸ್ಟ ಸಾಮ್ರಾಜ್ಯ"),
                    correctAnswer = "ಮೈಕೋಟಾ ಸಾಮ್ರಾಜ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೈಕೋಟಾ ಸಾಮ್ರಾಜ್ಯ."
                ),
                QuestionModel(
                    id = "tet_lw_q16",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "16) ಜೀವಿ ಮತ್ತು ನಿರ್ಜೀವಿಗಳ ನಡುವಿನ ಕೊಂಡಿ",
                    options = listOf("ಬ್ಯಾಕ್ಟಿರಿಯಾ", "ವೈರಸ", "ಅಮಿಬಾ", "ಶಿಲಿಂದ್ರ"),
                    correctAnswer = "ವೈರಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವೈರಸ."
                ),
                QuestionModel(
                    id = "tet_lw_q17",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "17) ಓಸ್ಟಿಯಾ ಎಂಬ ರಂಧ್ರಗಳನ್ನು ಹೊಂದಿದ ಅಕಶೇರುಕಗಳ ವಂಶ",
                    options = listOf("ಚಪ್ಪಟೆ ಹುಳುಗಳು", "ದುಂಡು ಹುಳುಗಳು", "ಸ್ಪಂಜು ಪ್ರಾಣಿಗಳು", "ಸಂಧಿಪದಿಗಳು"),
                    correctAnswer = "ಸ್ಪಂಜು ಪ್ರಾಣಿಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ಪಂಜು ಪ್ರಾಣಿಗಳು."
                ),
                QuestionModel(
                    id = "tet_lw_q18",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "18) ನಕ್ಷತ್ರ ಮೀನು ಈ ವಂಶಕ್ಕೆ ಸೇರಿರುವ ಜೀವಿ",
                    options = listOf("ದುಂಡು ಹುಳುಗಳು", "ಸಂಧಿಪದಿಗಳು", "ಮೃಂದ್ವಂಗಿಗಳು", "ಕಂಟಕ ಚರ್ಮಿಗಳು"),
                    correctAnswer = "ಕಂಟಕ ಚರ್ಮಿಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಂಟಕ ಚರ್ಮಿಗಳು."
                ),
                QuestionModel(
                    id = "tet_lw_q19",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "19) ಶಿಲೀಂದ್ರಗಳ ಬಗ್ಗೆ ಅಧ್ಯಯನ",
                    options = listOf("ವೈರಾಲಜಿ", "ಮೈಕಾಲಜಿ", "ಪೆಡಾಲಜಿ", "ಮೇರಿಕಲ್ಚರ್"),
                    correctAnswer = "ಮೈಕಾಲಜಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೈಕಾಲಜಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q20",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "20) ಹಣ್ಣಿನ ಸಸ್ಯಗಳ ಅಭಿವೃದ್ಧಿಯ ಬಗ್ಗೆ ಅಧ್ಯಯನ",
                    options = listOf("ಫೈಕಾಲಜಿ", "ಪೊಮೋಲಾಜಿ", "ಪ್ಲಾಂಟ ಬ್ರೀಡಿಂಗ್", "ಸಿಲ್ಪಿಕಲ್ಚರ್"),
                    correctAnswer = "ಪೊಮೋಲಾಜಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪೊಮೋಲಾಜಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q21",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "21) ತಳಿಶಾಸ್ತ್ರದ ಪಿತಾಮಹ",
                    options = listOf("ಜಾನ್ ಗ್ರೆಗರ ಮೆಂಡಲ್", "ಚಾಲ್ರ್ಸ ಡಾರ್ವಿನ", "ಅರಿಸ್ಟಾಟಲ್", "ಥಿಯೋಪ್ರಾಸ್ಟಸ್"),
                    correctAnswer = "ಜಾನ್ ಗ್ರೆಗರ ಮೆಂಡಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಾನ್ ಗ್ರೆಗರ ಮೆಂಡಲ್."
                ),
                QuestionModel(
                    id = "tet_lw_q22",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "22) ಮೈಟೋಕಾಂಡ್ರಿಯವನ್ನು ಕಂಡು ಹಿಡಿದ ವಿಜ್ಞಾನಿ",
                    options = listOf("ಲೂಯಿ ಪಾಶ್ಚರ್", "ಕ್ರಿಶ್ಚಿಯನ್ ಡಿಡುವೆ", "ಕೋಲಿಕರ್", "ಪೆಲಾಡೆ"),
                    correctAnswer = "ಕೋಲಿಕರ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೋಲಿಕರ್."
                ),
                QuestionModel(
                    id = "tet_lw_q23",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "23) ಸ್ಪರ್ಶಜ್ಞಾನವಿಲ್ಲದ ಮಚ್ಚೆಗಳು ಈ ರೋಗದ ಲಕ್ಷಣ",
                    options = listOf("ಕ್ಷಯ ರೋಗ", "ಮೂರ್ಛೆ ರೋಗ", "ಕುಷ್ಟ", "ಡೆಂಗ್ಯೂ"),
                    correctAnswer = "ಕುಷ್ಟ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕುಷ್ಟ."
                ),
                QuestionModel(
                    id = "tet_lw_q24",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "24) ಅಗಾರ ಮತ್ತು ಅಲಜಿನ್ಗಳನ್ನು ಇವುಗಳಿಂದ ತಯಾರಿಸುತ್ತಾರೆ.",
                    options = listOf("ಬ್ಯಾಕ್ಟೇರಿಯಾ", "ವೈರಸ್", "ಶೈವಲ", "ಪ್ರೋಟೋಜೋವಾ"),
                    correctAnswer = "ಶೈವಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶೈವಲ."
                ),
                QuestionModel(
                    id = "tet_lw_q25",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "25) ಡಿ.ಎನ್.ಎ. ಒಳಗೊಂಡಿರುವುದು",
                    options = listOf("ವರ್ಣತಂತಗಳು", "ಪ್ಲಾಸ್ಟಿಡಗಳು", "ಶೈವಲ", "ಪ್ರೋಟೋಜೇವಾ"),
                    correctAnswer = "ವರ್ಣತಂತಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವರ್ಣತಂತಗಳು."
                ),
                QuestionModel(
                    id = "tet_lw_q26",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "26) ಜೀನ್ ಎಂಬ ಪದ ಪರಿಚಿಸಿದವರು",
                    options = listOf("ಮೋರ್ಗನ್", "ಡೇಡುವೆ", "ಕೋಲ್ಲಿಕರ್", "ಜ್ಯಾನ್ಸನ್"),
                    correctAnswer = "ಜ್ಯಾನ್ಸನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜ್ಯಾನ್ಸನ್."
                ),
                QuestionModel(
                    id = "tet_lw_q27",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "27) RNA ದಲ್ಲಿ ಇರಲಾರದ ನೈಟ್ರೋಜನ್ ಕ್ಷಾರ",
                    options = listOf("ಅಡಿನಿನ್", "ಸೈಟೋಸಿನ್", "ಗ್ವಾನೀನ", "ಥೈಯಾಮಿನ್"),
                    correctAnswer = "ಥೈಯಾಮಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಥೈಯಾಮಿನ್."
                ),
                QuestionModel(
                    id = "tet_lw_q28",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "28) ಕೃತಕವಾಗಿ ಬ್ಯಾಕ್ಟಿರಿಯಾದಿಂದ ಪಡೆದ ಮೊದಲ ಹಾರ್ಮೋನ",
                    options = listOf("ಇನಸುಲಿನ್", "ಥೈರಾಕ್ಸಿನ್", "ಅಡ್ರಿನಾಲಿನ್", "ಟೆಸೋಸ್ಟಿರಾನ್"),
                    correctAnswer = "ಇನಸುಲಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಇನಸುಲಿನ್."
                ),
                QuestionModel(
                    id = "tet_lw_q29",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "29) ಇದು ಜೆನೆಟಿಕ್ ಇಂಜಿನಿಯರಿಂಗಗೆ ಸಂಬಂಧಪಟ್ಟಿದೆ",
                    options = listOf("ಮೈಟೋಕಾಂಡ್ರಿಯ", "ಗಾಲ್ಗಿ ಸಂಕೀರ್ಣ", "ಲೈಸೋಸೊಮ", "ಪ್ಲಾಸ್ಮಿಡ್"),
                    correctAnswer = "ಪ್ಲಾಸ್ಮಿಡ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪ್ಲಾಸ್ಮಿಡ್."
                ),
                QuestionModel(
                    id = "tet_lw_q30",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "30) ಇದು ಕೇವಲ RNA ದಲ್ಲಿ ಕಂಡುಬರುತ್ತದೆ.",
                    options = listOf("ಸೈಟೋಸಿನ್", "ಅಡಿನಿನ್", "ಯುರಾಸಿಲ್", "ಗ್ವಾನೀನ"),
                    correctAnswer = "ಯುರಾಸಿಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯುರಾಸಿಲ್."
                ),
                QuestionModel(
                    id = "tet_lw_q31",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "31) ಪ್ರೋಟೀನ್ ಪ್ರೋಡಕ್ಟ be Toxin ಜೀನ Cry IAC ಮತ್ತು Cry II Ab ಇವುಗಳ ನಿಯಂತ್ರಣಕ್ಕೆ ಕಾರಣವಾಗಿದೆ.",
                    options = listOf("ಬೊಲ್ ವರ್ಮ", "ಕಾಂಡ ವರ್ಮ", "ಮೊಥ", "ಪ್ರೋಟ್ ಫೈ"),
                    correctAnswer = "ಬೊಲ್ ವರ್ಮ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೊಲ್ ವರ್ಮ."
                ),
                QuestionModel(
                    id = "tet_lw_q32",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "32) ಅಕ್ರೋಮೆಗಾಲಿ ಇದರ ಅನಿಯಂತ್ರಿತ ಸ್ರವಿಕೆಯಿಂದ ಬರುತ್ತದೆ.",
                    options = listOf("ಪಿಟ್ಯುಟರಿ", "ಅಡ್ರಿನಲ್", "ಥೈರಾಯ್ಡ", "ಪ್ಯಾನ್ ಕ್ರಿಯಾಸ್"),
                    correctAnswer = "ಪಿಟ್ಯುಟರಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪಿಟ್ಯುಟರಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q33",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "33) DNA ರಚನೆಯನ್ನು ಪ್ರಥಮವಾಗಿ ವಿವರಿಸಿದವರು",
                    options = listOf("ಕ್ಯಾಚೆಸೈಡ್", "ನೆರೆನ್ ಬರ್ಗ", "ಲೆಡರ ಬರ್ಗ", "ವ್ಯಾಟ್ಸನ್ ಮತ್ತು ಕ್ರಿಕ್"),
                    correctAnswer = "ವ್ಯಾಟ್ಸನ್ ಮತ್ತು ಕ್ರಿಕ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವ್ಯಾಟ್ಸನ್ ಮತ್ತು ಕ್ರಿಕ್."
                ),
                QuestionModel(
                    id = "tet_lw_q34",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "34) ಮೆಡುಲ್ಲಾ ಅಬ್ಲಾಂಗೆಟಾ ಮಾನವನ ಇದರ ಭಾಗ",
                    options = listOf("ಹೃದಯ", "ಮಿದಳು", "ಪಿತ್ತ ಜನಕಾಂಗ", "ಲೈಂಗಿಕ ಅಂಗಗಳು"),
                    correctAnswer = "ಮಿದಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಿದಳು."
                ),
                QuestionModel(
                    id = "tet_lw_q35",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "35) ಹಿಮೊಗ್ಲೋಬಿನ್ನ ಕಾರ್ಯ",
                    options = listOf("ಆಕ್ಸಿಜನ್ ಸರಬರಾಜು", "ಬ್ಯಾಕ್ಟಿರಿಯಾ ಭಕ್ಷಣೆ", "ಅನೆಮಿಯಾ ನಿಯಂತ್ರಣ", "ಶಕ್ತಿಯ ಸದ್ಭಳಕೆ"),
                    correctAnswer = "ಆಕ್ಸಿಜನ್ ಸರಬರಾಜು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆಕ್ಸಿಜನ್ ಸರಬರಾಜು."
                ),
                QuestionModel(
                    id = "tet_lw_q36",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "36) ಬೇರಿನ ಗಂಟುಗಳು ಸಾಮಾನ್ಯವಾಗಿ ಈ ಸಸ್ಯಗಳಲ್ಲಿ ಕಂಡು ಬರುತ್ತವೆ.",
                    options = listOf("ಲೇಗುಮಿನೊಸ ಸಸ್ಯಗಳು", "ಪ್ಯಾರಾಸೈಟಿಕ ಸಸ್ಯಗಳು", "ಐಪಿಪೈಟಿಕ್ ಸಸ್ಯಗಳು", "ಅಕ್ಟಾಲಿಕ ಸಸ್ಯಗಳು"),
                    correctAnswer = "ಲೇಗುಮಿನೊಸ ಸಸ್ಯಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಲೇಗುಮಿನೊಸ ಸಸ್ಯಗಳು."
                ),
                QuestionModel(
                    id = "tet_lw_q37",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "37) ಅಲ್ಜಿಮಿಯರ್ಸ ರೋಗ ಸಂಬಂಧಿಸಿದ್ದು",
                    options = listOf("ಪಿತ್ರಜನಕಾಂಗ", "ಮೂತ್ರಪಿಂಡ", "ಮಾನವ ರಕ್ಷಣಾ ವ್ಯವಸ್ಥೆ", "ಮಿದುಳು"),
                    correctAnswer = "ಮಿದುಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಿದುಳು."
                ),
                QuestionModel(
                    id = "tet_lw_q38",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "38) ಬೇರುಗಳ ಹಾಗೂ ಕಾಂಡಗಳ ತುದಿಗಳಲ್ಲಿ ಬೆಳವಣಿಗೆ ಹಾರ್ಮೊನ",
                    options = listOf("ಆಕ್ಸೀನ್", "ಜಿಬ್ಬರ್ ಲಿನ್", "ಇಥಲಿನ", "ಸೈಟೋಕೆರ್ನಿ"),
                    correctAnswer = "ಆಕ್ಸೀನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆಕ್ಸೀನ್."
                ),
                QuestionModel(
                    id = "tet_lw_q39",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "39) ಕೃತಕವಾಗಿ ಹಣ್ಣುಗಳನ್ನು ಮಾಗಿಸಲು ಉಪಯೋಗಿಸುವರು",
                    options = listOf("ಆಕ್ಸೀನ್", "ಜಿಬ್ಬರ ಲಿನ್", "ಇಥಲಿನ", "ಸೈಟೋಕ್ವೆನಿನ್"),
                    correctAnswer = "ಇಥಲಿನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಇಥಲಿನ."
                ),
                QuestionModel(
                    id = "tet_lw_q40",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "40) ಸೂಕ್ಷ್ಮದರ್ಶಕವನ್ನು ರೂಪಿಸುವಲ್ಲಿ ಮೊದಲಿಗರು ಇವರು",
                    options = listOf("ರಾಬರ್ಟಹುಕ್", "ಲೀವನ್ ಹಾಕ್", "ಜಾನ್ಡೀವ್", "ಯಾರುಅಲ್ಲ."),
                    correctAnswer = "ಲೀವನ್ ಹಾಕ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಲೀವನ್ ಹಾಕ್."
                ),
                QuestionModel(
                    id = "tet_lw_q41",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "41) 'ಕ್ಷಯ ರೋಗವನ್ನು' ಈ ರೀತಿಯಾಗಿ ಕರೆಯಲಾಗಿದೆ.",
                    options = listOf("ಕರಿಮಾರಿ", "ಬಿಳಿಮಾರಿ", "ಮಾಹಮಾರಿ", "ಯಾವುದು ಅಲ್ಲ ."),
                    correctAnswer = "ಬಿಳಿಮಾರಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬಿಳಿಮಾರಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q42",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "42) ಡಿ.ಪಿ.ಟಿ ಲಸಿಕೆಯು ಯಾವ ರೋಗಕ್ಕೆ ಪ್ರಯೋಜನ ಕಾರಿಯಲ್ಲ",
                    options = listOf("ಧನುರ್ವಾತ", "ಡಿಫ್ತೀರಿಯಾ", "ಪರ್ಟುಸಿಸ್", "ಕ್ಷಯರೂಲ್"),
                    correctAnswer = "ಪರ್ಟುಸಿಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರ್ಟುಸಿಸ್."
                ),
                QuestionModel(
                    id = "tet_lw_q43",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "43) ಹಿಮೊಗ್ಲೋಬಿನನ್ನು ಹೊಂದಿರುವ ರಕ್ತ ಕಣಗಳು",
                    options = listOf("ಕೆಂಪು", "ಬಿಳಿ", "ಪ್ಲೆಟೇಟ್ಸ್", "ಎಲ್ಲವೂ"),
                    correctAnswer = "ಕೆಂಪು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೆಂಪು."
                ),
                QuestionModel(
                    id = "tet_lw_q44",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "44) ಮಲೇರಿಯಾ ರೋಗಕ್ಕೆ ಕಾರಣವಾದ ಸೊಳ್ಳೆ",
                    options = listOf("ಅನಾಫಿಲಿಸ್ಸೊಳ್ಳೆ", "ಅನಾಫಿಲಿಸ್ ಹೆಣ್ಣು ಸೊಳ್ಳೆ", "ಸೊಳ್ಳೆ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಅನಾಫಿಲಿಸ್ ಹೆಣ್ಣು ಸೊಳ್ಳೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅನಾಫಿಲಿಸ್ ಹೆಣ್ಣು ಸೊಳ್ಳೆ."
                ),
                QuestionModel(
                    id = "tet_lw_q45",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "45) ಜೀವಕೋಶವನ್ನು ಕಂಡು ಹಿಡಿದವರು",
                    options = listOf("ಲಿವಿನ್ ಹಾಕ್", "ರಾಬರ್ಟ ಬ್ರೌನ್", "ರಾಬರ್ಟ ಹುಕ್", "ಪರಾಶರ"),
                    correctAnswer = "ರಾಬರ್ಟ ಹುಕ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರಾಬರ್ಟ ಹುಕ್."
                ),
                QuestionModel(
                    id = "tet_lw_q46",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "46) ಕೆಂಪು ಇರುವೆ ಅಥವಾ ಜೇನು ಹುಳು ಕಚ್ಚಿದಾಗ ವ್ಯಕ್ತಿಯ ದೇಹದ ಒಳಗೆ ಸೇರಿಸುವ ಆಮ್ಲ",
                    options = listOf("ಲ್ಯಾಕ್ಲಿಕ್ ಆಮ್ಲ", "ಆಕ್ಸಾಲಿಕ್ ಆಮ್ಲ", "ಆಸಿಟಿಕ್ ಆಮ್ಲ", "ಫಾರ್ಮಿಕ್ ಆಮ್ಲ"),
                    correctAnswer = "ಫಾರ್ಮಿಕ್ ಆಮ್ಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಫಾರ್ಮಿಕ್ ಆಮ್ಲ."
                ),
                QuestionModel(
                    id = "tet_lw_q47",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "47) ಹಾಲಿನಲ್ಲಿರುವ ಬ್ಯಾಕ್ಟೀರಿಯಾ",
                    options = listOf("ವಿಬ್ರೀಯೋ ಕಾಕ್ಯೆ", "ಲ್ಯಾಕ್ಟೊ ಬ್ಯಾಕ್ಟೀರಿಯಾ", "ಬ್ಯಾಕ್ಟೀರಿಯೋಫೆಜ್", "ಸ್ಪೈರಲೈ ಬ್ಯಾಕ್ಟೀರಿಯಾ"),
                    correctAnswer = "ಲ್ಯಾಕ್ಟೊ ಬ್ಯಾಕ್ಟೀರಿಯಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಲ್ಯಾಕ್ಟೊ ಬ್ಯಾಕ್ಟೀರಿಯಾ."
                ),
                QuestionModel(
                    id = "tet_lw_q48",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "48) ಬ್ಯಾಕ್ಟೀರಿಯಾದ ವೈರಸ್ ಸೋಂಕು",
                    options = listOf("ಬ್ಯಾಕ್ಟೀರಿಯೋಫೇಜ್", "ಸ್ಪೈರಲೈ ಬ್ಯಾಕ್ಟೀರಿಯಾ", "ಸ್ಟ್ರೈಪ್ಟೋಕಾಕೈ ಬ್ಯಾಕ್ಟೀರಿಯಾ", "ಲ್ಯಾಕ್ಟೋ ಬ್ಯಾಕ್ಟೀಯಾ"),
                    correctAnswer = "ಬ್ಯಾಕ್ಟೀರಿಯೋಫೇಜ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬ್ಯಾಕ್ಟೀರಿಯೋಫೇಜ್."
                ),
                QuestionModel(
                    id = "tet_lw_q49",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "49) ಹೆಚ್.ಐ.ವಿ ಯಿಂದ ಬರುವ ರೋಗ",
                    options = listOf("ಕಾಲರ", "ಕ್ಷಯ", "ಏಡ್ಸ್", "ಪ್ಲೇಗ್"),
                    correctAnswer = "ಏಡ್ಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಏಡ್ಸ್."
                ),
                QuestionModel(
                    id = "tet_lw_q50",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "50) ಸೆಲ್ಸ್ ಎಂದು ಮೊದಲಿಗೆ ಕರೆದ ವಿಜ್ಞಾನಿ",
                    options = listOf("ರಾಬರ್ಟ ಹುಕ್", "ರಾಬರ್ಟ ಹುಡ್", "ಕ್ಲೀಡನ್", "ನ್ಯೂಟಾನ್"),
                    correctAnswer = "ರಾಬರ್ಟ ಹುಕ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರಾಬರ್ಟ ಹುಕ್."
                ),
                QuestionModel(
                    id = "tet_lw_q51",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "51) ಭಾರತದಲ್ಲಿ ಏಡ್ಸ್ ರೋಗವನ್ನು ಅಧಿಕೃತವಾಗಿ ಎಷ್ಟರಲ್ಲಿ ಮತ್ತು ಎಲ್ಲಿ ಪತ್ತೆ ಹಚ್ಚಲಾಯಿತು?",
                    options = listOf("ಚೈನೈ 1987", "ಮುಂಬಾಯಿ 2000", "ದೆಹಲಿ 1987", "ಬೆಂಗಳೂರು 1987"),
                    correctAnswer = "ಚೈನೈ 1987",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚೈನೈ 1987."
                ),
                QuestionModel(
                    id = "tet_lw_q52",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "52) ಕಾಲರ ರೋಗಕ್ಕೆ ಕಾರಣವಾದ ಜೀವಿ.",
                    options = listOf("ವಿಬ್ರಿಯೋ", "ಪ್ಲಾಸ್ಮೋಡಿಯಮ್", "ಲ್ಯಾಕ್ಟೋಬೈಸೀಸ್", "ಅಮೀಬಾ"),
                    correctAnswer = "ವಿಬ್ರಿಯೋ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಬ್ರಿಯೋ."
                ),
                QuestionModel(
                    id = "tet_lw_q53",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "53) ಪ್ಲಾಸ್ಮೋಡಿಯಮ್ ವೈವಾಕ್ಸ್ ಈ ರೋಗಕ್ಕೆ ಕಾರಣ",
                    options = listOf("ಕಾಲರ", "ಭೇದಿ", "ಏಡ್ಸ್", "ಮಲೇರಿಯಾ"),
                    correctAnswer = "ಮಲೇರಿಯಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಲೇರಿಯಾ."
                ),
                QuestionModel(
                    id = "tet_lw_q54",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "54) ಆರೋಗ್ಯವಂತ ಮಾನವರ ದೇಹದ ತಾಪ",
                    options = listOf("40⁰C", "35⁰C", "37⁰C", "20⁰C"),
                    correctAnswer = "37⁰C",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 37⁰C."
                ),
                QuestionModel(
                    id = "tet_lw_q55",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "55) ಒಂದೇ ರೀತಿಯ ರಚನೆ ಮತ್ತು ಕಾರ್ಯವನ್ನು ನಿರ್ವಹಿಸುವ ಜೀವಕೋಶಗಳ ಗುಂಪು ಇದಾಗಿದೆ",
                    options = listOf("ಅಂಗಾಂಶ", "ಅಂಗ", "ಅಂಗವ್ಯೂಹ", "ಜೀವಿ"),
                    correctAnswer = "ಅಂಗಾಂಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಂಗಾಂಶ."
                ),
                QuestionModel(
                    id = "tet_lw_q56",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "56) ಪ್ರೋಕ್ಯಾರಿಯೋಟಿಕ್ ಜೀವಿಗಳನ್ನು ಈ ಕೆಳಗಿನ ಯಾವ ಸಾಮ್ರಾಜ್ಯಕ್ಕೆ ಸೇರಿಸಲಾಗಿದೆ",
                    options = listOf("ಮೊನೆರಾ", "ಪ್ರೊಟಿಸ್ಟಾ", "ಮೈಕೋಟರಿ", "ಸಸ್ಯ ಸಾಮ್ರಾಜ್ಯ"),
                    correctAnswer = "ಮೊನೆರಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೊನೆರಾ."
                ),
                QuestionModel(
                    id = "tet_lw_q57",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "57) ಈ ಬ್ಯಾಕ್ಟೀರಿಯಾಗಳನ್ನು ರೈತರ ನೈಸರ್ಗಿಕ ವೈರಿಗಳು ಎಂದು ಕರೆಯುವರು",
                    options = listOf("ಅಮೋನಿಕರಣ ಬ್ಯಾಕ್ಟೀರಿಯಾ", "ನೈಟ್ರೋಸೋಮೋನಾಸ್", "ಸ್ಯೂಡೋಮೋನಾಸೆ", "ನೈಟ್ರೋಬ್ಯಾಕ್ಟರ್"),
                    correctAnswer = "ಸ್ಯೂಡೋಮೋನಾಸೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ಯೂಡೋಮೋನಾಸೆ."
                ),
                QuestionModel(
                    id = "tet_lw_q58",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "58) ಮಲೇರಿಯಾಕ್ಕೆ ಕಾರಣವಾಗುವ ಪ್ಲಾಸ್ಮೋಡಿಯಂ ವೈವಾಕ್ಸ್ನ್ನು ಜೀವಿಗಳ ಯಾವ ಗುಂಪಿಗೆ ಸೇರಿಸಲಾಗಿದೆ",
                    options = listOf("ಆದಿಜೀವಿ", "ಬ್ಯಾಕ್ಟೀರಿಯಾ", "ಏಕಕೋಶಿಯ ಶೈವಲ", "ವೃರಾಣು"),
                    correctAnswer = "ಆದಿಜೀವಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆದಿಜೀವಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q59",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "59) ಒಸಡಿನಿಂದ ಹೊರಬರುವ ಹಲ್ಲಿನ ಹೊರಭಾಗ",
                    options = listOf("ಎನಾಮಲ್", "ಡೆಂಟೈನ್", "ಕ್ರೌನ್", "ಬೇರು"),
                    correctAnswer = "ಬೇರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೇರು."
                ),
                QuestionModel(
                    id = "tet_lw_q60",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "60) ಒಬ್ಬ ವ್ಯಕ್ತಿಗೆ ಸತತವಾಗಿ ಕೆಮ್ಮು ರಾತ್ರಿಯ ವೇಳೆಯಲ್ಲಿ ಜ್ವರ ಕಾಣಿಸಿಕೊಳ್ಳುವುದು, ಹಸಿವಾಗದಿರುವುದು, ಊಟ ಸೇರದಿರುವುದು, ಬಳಲಿಕೆ ಇದ್ದು, ಆ ವ್ಯಕ್ತಿ ಯಾವ ರೋಗದಿಂದ ಬಳಲುತ್ತಿದ್ದಾನೆ.?",
                    options = listOf("ಕಾಲರಾ", "ಮದುಮೇಹ", "ಅಜಿರ್ಣತೆ", "ಕ್ಷಯರೋಗ"),
                    correctAnswer = "ಕ್ಷಯರೋಗ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ಷಯರೋಗ."
                ),
                QuestionModel(
                    id = "tet_lw_q61",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "61) ಒಬ್ಬ ರೈತನು ತನ್ನ ಹೊಲದಲ್ಲಿ ಬೆಳೆದ ಆಲೂಗಡ್ಡೆಯಲ್ಲಿ ಪ್ರತೀ ವರ್ಷ ಲಾಭವನ್ನು ಗಳಿಸಿರುತ್ತಾನೆ. ಆದರೆ ಪ್ರಸ್ತುತ ವರ್ಷದಲ್ಲಿ ಅವನು ಬೆಳೆದ ಬೆಳೆಯ ಎಲೆಗಳು ಬೂದುಬಣ್ಣಕ್ಕೆ ತಿರುಗಿ ಬೆಳೆಯು ಸೊರಗಿಹೋಗಿರುತ್ತದೆ ಕಾರಣ",
                    options = listOf("ಅತಿಯಾದ ಮಳೆ", "ಕಡಿಮೆ ಮಳೆ", "ಖನಿಜಾಂಶಗಳ ಕೊರತೆ", "ಫಂಗಸ್ ಹಾವಳಿ"),
                    correctAnswer = "ಫಂಗಸ್ ಹಾವಳಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಫಂಗಸ್ ಹಾವಳಿ."
                ),
                QuestionModel(
                    id = "tet_lw_q62",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "62) ವೆಲಸನಿರೆಯಾ ಸಸ್ಯದ ಉಸಿರಾಟಕ್ಕೆ ಸಹಾಯ ಮಾಡುವ ಬೇರು",
                    options = listOf("ಹೀರು ಬೇರು", "ವಾಯಧರ ಬೇರು", "ತಂತು ಬೇರು", "ತಾಯ ಬೇರು"),
                    correctAnswer = "ವಾಯಧರ ಬೇರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಾಯಧರ ಬೇರು."
                ),
                QuestionModel(
                    id = "tet_lw_q63",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "63) ಜೀವಕೋಶದಲ್ಲಿ ಸೆಂಟ್ರಿಯೋಲ್ ನ ಕಾರ್ಯ ಇದಾಗಿದೆ.",
                    options = listOf(
                        "ರಾಸಾಯನಿಕಗಳನ್ನು ಸ್ರವಿಸುತ್ತದೆ",
                        "ಪ್ರೋಟಿನ್ ಸಂಶ್ಲೇಷಣೆ ಮಾಡುತ್ತದೆ",
                        "ಕೋಶ ವಿಭಜನೆಗೆ ಸಹಾಯ ಮಾಡುತ್ತದೆ",
                        "ಕೋಶದಲ್ಲಿನ ಸಾವಯವ ವಸ್ತುಗಳನ್ನು ಜೀರ್ಣಿಸಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ."
                    ),
                    correctAnswer = "ಕೋಶ ವಿಭಜನೆಗೆ ಸಹಾಯ ಮಾಡುತ್ತದೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೋಶ ವಿಭಜನೆಗೆ ಸಹಾಯ ಮಾಡುತ್ತದೆ."
                ),
                QuestionModel(
                    id = "tet_lw_q64",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "64) ಒಂದೇ ತೆರನಾದ ರಚನೆ ಮತ್ತು ಕಾರ್ಯವನ್ನು ಹೊಂದಿರುವ ಜೀವಕೋಶಗಳ ಗುಂಪು",
                    options = listOf("ಅಂಗ", "ಅಂಗವ್ಯೂಹ", "ಅಂಗಾಂಶ", "ಜೀವಕೋಶ"),
                    correctAnswer = "ಅಂಗಾಂಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಂಗಾಂಶ."
                ),
                QuestionModel(
                    id = "tet_lw_q65",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "65) ಜೀವಕೋಶದಲ್ಲಿ ರೈಬೋಸೋಮುಗಳ ಕಾರ್ಯ ಇದಾಗಿದೆ",
                    options = listOf("ಪ್ರೋಟೀನ್ ಸಂಶ್ಲೇಷಣೆ", "ಕೋಶ ವಿಭಜನೆ", "ರಾಸಾಯನಿಕಗಳನ್ನು ಸ್ರವಿಸುವುದು", "ಸಾವಯವ ವಸ್ತುಗಳ ಜೀರ್ಣಿಸುವುದು"),
                    correctAnswer = "ಪ್ರೋಟೀನ್ ಸಂಶ್ಲೇಷಣೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪ್ರೋಟೀನ್ ಸಂಶ್ಲೇಷಣೆ."
                ),
                QuestionModel(
                    id = "tet_lw_q66",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "66) ಪ್ರೋಕ್ಯಾರಿಯೋಟಿಕ್ ಜೀವಕೋಶದ ವಂಶವಾಹಿ ವಸ್ತು",
                    options = listOf("ಕ್ರೋಮೊಸೋಮ್", "ಡಿ.ಎನ್.ಎ", "ಆರ್.ಎನ್.ಎ", "ಮೇಲಿನ ಎಲ್ಲವು"),
                    correctAnswer = "ಡಿ.ಎನ್.ಎ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಡಿ.ಎನ್.ಎ."
                ),
                QuestionModel(
                    id = "tet_lw_q67",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "67) ನೈಜ ಕೋಶ ಕೇಂದ್ರವು ಈ ಜೀವಕೋಶದಲ್ಲಿ ಕಂಡು ಬರುತ್ತದೆ.",
                    options = listOf("ವೈರಸ್", "ಪ್ರೋಕ್ಯಾರಿಯೋಟಿಕ್", "ಯೂಕ್ಯಾರಿಯೋಟಿಕ್", "ಬ್ಯಾಕ್ಟೀರಿಯಾ"),
                    correctAnswer = "ಯೂಕ್ಯಾರಿಯೋಟಿಕ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯೂಕ್ಯಾರಿಯೋಟಿಕ್."
                ),
                QuestionModel(
                    id = "tet_lw_q68",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "68) ಜೀವಕೋಶದಲ್ಲಿ ರೈಬೋಸೋಮುಗಳ ಕಾರ್ಯ ಇದಾಗಿದೆ",
                    options = listOf("ಪ್ರೋಟೀನ್ ಸಂಶ್ಲೇಷಣೆ", "ಕೋಶ ವಿಭಜನೆ", "ರಾಸಾಯನಿಕಗಳನ್ನು ಸ್ರವಿಸುವುದು", "ಸಾವಯವ ವಸ್ತುಗಳ ಜೀರ್ಣಿಸುವುದು"),
                    correctAnswer = "ಪ್ರೋಟೀನ್ ಸಂಶ್ಲೇಷಣೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪ್ರೋಟೀನ್ ಸಂಶ್ಲೇಷಣೆ."
                ),
                QuestionModel(
                    id = "tet_lw_q69",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "69) ಇದರಲ್ಲಿ ಮೊಗ್ಗುವಿಕೆಯಿಂದ ಸಂತಾನೋತ್ಪತ್ತಿ ನಡೆಯುವುದು",
                    options = listOf("ಬೆಡ್ಡಿನ್ ಶಿಲೀಂಧ್ರ", "ಯೀಸ್ಟ", "ಸ್ಪೈರೋಗೈರ", "ಅಮೀಬಾ"),
                    correctAnswer = "ಯೀಸ್ಟ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯೀಸ್ಟ."
                ),
                QuestionModel(
                    id = "tet_lw_q70",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "70) ಇವುಗಳಲ್ಲಿ ಒಂದು ವಿಘಟಕ ಜೀವಿ",
                    options = listOf("ಶಿಲೀಂದ್ರ", "ಏಕಕೋಶ ಜೀವಿ", "ಶೈವಲ", "ಕೀಟ"),
                    correctAnswer = "ಶಿಲೀಂದ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶಿಲೀಂದ್ರ."
                ),
                QuestionModel(
                    id = "tet_lw_q71",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "71) ಕೋಶಕೇಂದ್ರವಿರದ ಜೀವಕೋಶದಲ್ಲಿ ಇದು ಇರುವುದಿಲ್ಲ",
                    options = listOf("ಪ್ಲಾಸ್ಮಾಪೊರೆ", "ಮೈಟೋಕಾಂಡ್ರಿಯಾ", "ರಸದಾನಿ", "ವರ್ಣತಂತು"),
                    correctAnswer = "ವರ್ಣತಂತು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವರ್ಣತಂತು."
                ),
                QuestionModel(
                    id = "tet_lw_q72",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "72) ಜೀವಕೋಶ ಸಿದ್ಧಾಂತವನ್ನು ಮಂಡಿಸಿದವರು",
                    options = listOf(
                        "ಶ್ಲೀಡನ್ ಮತ್ತು ಷ್ವಾನ್",
                        "ಶ್ಲೀಡನ್ ಮತ್ತು ರಾಬರ್ಟ ಹುಕ್",
                        "ಷ್ವಾನ್ ಮತ್ತು ರಾಬರ್ಟ ಹುಕ್",
                        "ಶ್ವೀಡನ್, ಷ್ವಾನ್ ಮತ್ತು ರಾಬರ್ಟ ಹುಕ್"
                    ),
                    correctAnswer = "ಶ್ಲೀಡನ್ ಮತ್ತು ಷ್ವಾನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶ್ಲೀಡನ್ ಮತ್ತು ಷ್ವಾನ್."
                ),
                QuestionModel(
                    id = "tet_lw_q73",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "73) ಅಲೆಕ್ಸಾಂಡರ್ ಪ್ಲೆಮಿಂಗ್ ರವರಿಗೆ 1947ರಲ್ಲಿ ಯಾವ ಆವಿಷ್ಕಾರಕ್ಕಾಗಿ ನೋಬೆಲ್ ಪ್ರಶಸ್ತಿ ದೊರೆಯಿತು",
                    options = listOf("ಪೋಲಿಯೋ ಲಸಿಕೆ", "ಪೆನ್ಸಿಲಿನ್ ಚುಚ್ಚುಮದ್ದು", "ಸಿಡುಬು ರೋಗಕ್ಕೆ ಲಸಿಕೆ", "ರೇಬಿಸ್ ರೋಗಕ್ಕೆ ಲಸಿಕೆ"),
                    correctAnswer = "ಪೆನ್ಸಿಲಿನ್ ಚುಚ್ಚುಮದ್ದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪೆನ್ಸಿಲಿನ್ ಚುಚ್ಚುಮದ್ದು."
                ),
                QuestionModel(
                    id = "tet_lw_q74",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 10,
                    type = "MCQ",
                    questionText = "74) ಆರೋಗ್ಯವಂತ ಮಾನವನ ದೇಹದಲ್ಲಿ ಇರಬೇಕಾದ ರಕ್ತದ ಪ್ರಮಾಣ ಎಷ್ಟು?",
                    options = listOf("3.5 ರಿಂದ 4.50 ಲೀಟರ್", "5 ರಿಂದ 6 ಲೀಟರ್", "4.5 ರಿಂದ 5.5 ಲೀಟರ್", "3 ರಿಂದ 4 ಲೀಟರ್"),
                    correctAnswer = "4.5 ರಿಂದ 5.5 ಲೀಟರ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 4.5 ರಿಂದ 5.5 ಲೀಟರ್."
                )
            )
        }
}
