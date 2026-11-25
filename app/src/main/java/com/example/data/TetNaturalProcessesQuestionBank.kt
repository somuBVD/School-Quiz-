package com.example.data

/**
 * TET (Teacher Eligibility Test - Standard / Exam ID: 13)
 * Subject: EVS, Science & Social Pedagogy ("general_science")
 * Unit 11: 10. ನೈಸರ್ಗಿಕ ಪ್ರಕ್ರಿಯೆಗಳು (Natural Processes) — 68 MCQs.
 */
object TetNaturalProcessesQuestionBank {

    val unitTemplate = UnitTemplate(
        id = 11,
        name = "10. ನೈಸರ್ಗಿಕ ಪ್ರಕ್ರಿಯೆಗಳು (Natural Processes)",
        totalQuestions = 68,
        difficulty = "Medium"
    )

    val questions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetNaturalProcesses") {
            listOf(
                QuestionModel(
                    id = "tet_np_q1",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "1) ನೀರನ್ನು ಸಾಗಿಸುವ ಸಸ್ಯ ಅಂಗಾಂಶ",
                    options = listOf("ಪ್ಯಾರಂಕೈಮ್", "ಕ್ಸೈಲಂ", "ಫ್ಲೋಯಂ", "ಕೋಲಂಕೈಮ್"),
                    correctAnswer = "ಕ್ಸೈಲಂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ಸೈಲಂ."
                ),
                QuestionModel(
                    id = "tet_np_q2",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "2) ಆಹಾರ ವಾಹಕ ಅಂಗಾಂಶ ಎಂದು ಕರಿಯುವ ಸಸ್ಯ ಅಂಗಾಂಶ",
                    options = listOf("ಪ್ಯಾರಂಕೈಮ", "ಕ್ಸೈಲಂ", "ಫ್ಲೋಯಂ", "ಕೋಲಂಕೈಮ"),
                    correctAnswer = "ಫ್ಲೋಯಂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಫ್ಲೋಯಂ."
                ),
                QuestionModel(
                    id = "tet_np_q3",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "3) ಭಾಷ್ಪವಿಸರ್ಜನೆ ತೊಗಟೆಯ ಮೂಲಕ ನಡೆದರೆ",
                    options = listOf("ಲೆಂಟಿಕ್ಯೂಲಾರ ಭಾಷ್ಪವಿಸರ್ಜನೆ", "ಕ್ಯೂಟಿಕ್ಯೂಲಾರ ಭಾಷ್ಪವಿಸರ್ಜನೆ", "ಪತ್ರರಂಧದ ಭಾಷ್ಪವಿಸರ್ಜನೆ", "ದ್ಯುತಿ ಸಂಶ್ಲೇಷಣ ಕ್ರಿಯೆ"),
                    correctAnswer = "ಲೆಂಟಿಕ್ಯೂಲಾರ ಭಾಷ್ಪವಿಸರ್ಜನೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಲೆಂಟಿಕ್ಯೂಲಾರ ಭಾಷ್ಪವಿಸರ್ಜನೆ."
                ),
                QuestionModel(
                    id = "tet_np_q4",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "4) ಮೊಸಳೆಯ ಹೃದಯದಲ್ಲಿ ಎಷ್ಟು ಕೋಣೆಗಳನ್ನು ಕಾಣಬಹುದು",
                    options = listOf("3", "2", "4", "4 ಅಪೂರ್ಣ"),
                    correctAnswer = "4",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 4."
                ),
                QuestionModel(
                    id = "tet_np_q5",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "5) ಒಬ್ಬ ಆರೋಗ್ಯವಂತ ವ್ಯಕ್ತಿಯ ರಕ್ತದ ಒತ್ತಡ ಸುಮಾರು",
                    options = listOf("120/80 mmHg", "125/80 mmHg", "80/125 mmHg", "110/80 mmHg"),
                    correctAnswer = "120/80 mmHg",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 120/80 mmHg."
                ),
                QuestionModel(
                    id = "tet_np_q6",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "6) ಜಿರಳೆಯಲ್ಲಿ ರಕ್ತದ ಬಣ್ಣ",
                    options = listOf("ಹಸಿರು", "ಬಿಳಿ", "ಕೆಂಪು", "ಬಣ್ಣರಹಿತ"),
                    correctAnswer = "ಬಣ್ಣರಹಿತ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬಣ್ಣರಹಿತ."
                ),
                QuestionModel(
                    id = "tet_np_q7",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "7) ಜಿರಳೆಯಲ್ಲಿ ಎಷ್ಟು ಕೋಣೆಗಳ ಹೃದಯವಿದೆ",
                    options = listOf("4", "12", "13", "15"),
                    correctAnswer = "13",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 13."
                ),
                QuestionModel(
                    id = "tet_np_q8",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "8) ಆಕ್ಸಿಜನ್ಯುಕ್ತ ರಕ್ತವನ್ನು ಸ್ವೀಕರಿಸುವ ಮಾನವನ ಹೃದಯದ ಕೋಣೆ",
                    options = listOf("ಎಡ ಹೃತ್ಕರ್ಣ", "ಬಲ ಹೃತ್ಕರ್ಣ", "ಬಲ ಹೃತ್ಕಕ್ಷಿ", "ಎಡ ಹೃತ್ಕುಕ್ಷಿ"),
                    correctAnswer = "ಎಡ ಹೃತ್ಕುಕ್ಷಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎಡ ಹೃತ್ಕುಕ್ಷಿ."
                ),
                QuestionModel(
                    id = "tet_np_q9",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "9) ರೋಗ ನಿರೋಧಕ ಶಕ್ತಿಯನ್ನು ಒದಗಿಸುವ ರಕ್ತದ ಘಟಕ",
                    options = listOf("ಬಿಳಿ ರಕ್ತ ಕಣ", "ಪ್ಲಾಸ್ಮಾ", "ಕೆಂಪು ರಕ್ತಕಣ", "ಕಿರುತಟ್ಟೆಗಳು"),
                    correctAnswer = "ಬಿಳಿ ರಕ್ತ ಕಣ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬಿಳಿ ರಕ್ತ ಕಣ."
                ),
                QuestionModel(
                    id = "tet_np_q10",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "10) ಅಮೀಬಾದಲ್ಲಿ ಪದಾರ್ಥಗಳ ಸಾಗಣೆ ಇದರಿಂದ ಉಂಟಾಗುತ್ತದೆ.",
                    options = listOf("ಅಂಗಾಂಶಗಳು", "ಅಭಿಸರಣೆ", "ವಿಸರಣೆ", "ವಿಸರಣೆ ಮತ್ತು ಅಭಿಸರಣೆ"),
                    correctAnswer = "ವಿಸರಣೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಸರಣೆ."
                ),
                QuestionModel(
                    id = "tet_np_q11",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "11) ಜಿರಳೆಯಲ್ಲಿ ಅನಿಲಗಳ ವಿನಿಮಯವಾಗುವುದು",
                    options = listOf("ವಿಸರಣೆ", "ಅಭಿಸರಣೆ", "ಅಂಗಾಂಶಗಳು", "ವಿಸರಣೆ ಮತ್ತು ಅಭಿಸರಣೆ"),
                    correctAnswer = "ವಿಸರಣೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಸರಣೆ."
                ),
                QuestionModel(
                    id = "tet_np_q12",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "12) ರಕ್ತದ ಗುಂಪುಗಳನ್ನು ಕಂಡು ಹಿಡಿದ ವಿಜ್ಞಾನಿ",
                    options = listOf("ವಿಲಿಯಂ ಹಾರ್ವೆ", "ಜೋಸೆಫ ಲಿಸ್ಟರ್", "ಕಾರ್ಲ ಲ್ಯೂಂಡ್ ಸ್ಪಿನರ್", "ಅಲೆಕ್ಸಾಂಡರ್ ಪ್ಲೇಮಿಂಗ್"),
                    correctAnswer = "ಕಾರ್ಲ ಲ್ಯೂಂಡ್ ಸ್ಪಿನರ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾರ್ಲ ಲ್ಯೂಂಡ್ ಸ್ಪಿನರ್."
                ),
                QuestionModel(
                    id = "tet_np_q13",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "13) ಕಿರುತಟ್ಟೆಗಳ ಪ್ರಮುಖ ಕ್ರಿಯೆ",
                    options = listOf("ಆಕ್ಸಿಜನ ಸಾಗಾಣಿಕೆ", "ಅನವಶ್ಯಕ ವಸ್ತುಗಳ ನಿರ್ಮೂಲನೆ", "ರಕ್ತ ಹೆಪ್ಪುಗಟ್ಟುವ ಕ್ರಿಯೆ", "ಪ್ರತಿ ಕಾಯಗಳ ಉತ್ಪಾದನೆ"),
                    correctAnswer = "ರಕ್ತ ಹೆಪ್ಪುಗಟ್ಟುವ ಕ್ರಿಯೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರಕ್ತ ಹೆಪ್ಪುಗಟ್ಟುವ ಕ್ರಿಯೆ."
                ),
                QuestionModel(
                    id = "tet_np_q14",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "14) ಸಾವ್ರರ್ತಿಕ ದಾನಿ ಎಂದು ಕರೆಯಲ್ಪಡುವ ರಕ್ತದ ಗುಂಪು",
                    options = listOf("A", "B", "AB", "O"),
                    correctAnswer = "O",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: O."
                ),
                QuestionModel(
                    id = "tet_np_q15",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "15) ಸಾವ್ರರ್ತಿಕ ಸ್ವೀಕಾರಿ ಎಂದು ಕರೆಯಲ್ಪಡುವ ರಕ್ತದ ಗುಂಪು",
                    options = listOf("A", "B", "AB", "O"),
                    correctAnswer = "AB",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: AB."
                ),
                QuestionModel(
                    id = "tet_np_q16",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "16) ರಕ್ತ ಕೆಂಪಾಗಿರಲು ಕಾರಣ",
                    options = listOf("ಕೆರಾಟಿನ್", "ಹಿಮೊಗ್ಲೊಬಿನ್", "ಪ್ಲಾಸ್ಮಾ", "ದುಗ್ಧರಸ"),
                    correctAnswer = "ಹಿಮೊಗ್ಲೊಬಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹಿಮೊಗ್ಲೊಬಿನ್."
                ),
                QuestionModel(
                    id = "tet_np_q17",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "17) ಕೆಂಪು ರಕ್ತಕಣಗಳ ಜೀವಿತಾವದಿ",
                    options = listOf("100-120 ದಿನ", "80-100 ದಿನ", "120-140 ದಿನ", "30-50 ದಿನ"),
                    correctAnswer = "100-120 ದಿನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 100-120 ದಿನ."
                ),
                QuestionModel(
                    id = "tet_np_q18",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "18) ಕೆಂಪು ರಕ್ತಕಣಗಳು ಉತ್ಪತ್ತಿಯಾಗುವ ಸ್ಥಾನ",
                    options = listOf("ಅಸ್ಥಿ ಮಚ್ಚೆ", "ಫಿಮರ್", "ಮೂಳೆ", "ಹಾವರ್ಷಿಯನ್ ನಾಳ"),
                    correctAnswer = "ಅಸ್ಥಿ ಮಚ್ಚೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಸ್ಥಿ ಮಚ್ಚೆ."
                ),
                QuestionModel(
                    id = "tet_np_q19",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "19) ನಮ್ಮ ದೇಹದ ಅತ್ಯಂತ ಸಣ್ಣ ಮೂಳೆ",
                    options = listOf("ಟಿಬಿಯಾ", "ಸ್ಟೆಪಿಸ್", "ಫಿಮರ", "ಇಂಕಸ್"),
                    correctAnswer = "ಸ್ಟೆಪಿಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ಟೆಪಿಸ್."
                ),
                QuestionModel(
                    id = "tet_np_q20",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "20) ರಕ್ತವನ್ನು ಈ ಅಂಗಾಂಶ ಎಂದು ಪರಿಗಣಿಸಲಾಗಿದೆ.",
                    options = listOf("ಸಂಯೋಜಕ ಅಂಗಾಂಶ", "ನರ ಅಂಗಾಂಶ", "ಸ್ನಾಯು ಅಂಗಾಂಶ", "ಅನುಲೇಪಕ ಅಂಗಾಂಶ"),
                    correctAnswer = "ಸಂಯೋಜಕ ಅಂಗಾಂಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಂಯೋಜಕ ಅಂಗಾಂಶ."
                ),
                QuestionModel(
                    id = "tet_np_q21",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "21) ನರ ಅಂಗಾಂಶದ ರಚನೆಯ ಹಾಗೂ ಕಾರ್ಯದ ಮೂಲ ಘಟಕ",
                    options = listOf("ನೆಪ್ರಾನ್", "ನ್ಯೂರಾನ್", "ಸೈಟಾನ", "ಆಕ್ಸಾನ್"),
                    correctAnswer = "ನ್ಯೂರಾನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನ್ಯೂರಾನ್."
                ),
                QuestionModel(
                    id = "tet_np_q22",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "22) ಐಚ್ಛಿಕ ಸ್ನಾಯುಗಳಿಗೆ ಉದಾಹರಣೆ",
                    options = listOf("ಹೃದಯ", "ಶ್ವಾಸಕೋಶ", "ಎಪೆ", "ಕಾಲುಗಳು"),
                    correctAnswer = "ಎಪೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎಪೆ."
                ),
                QuestionModel(
                    id = "tet_np_q23",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "23) ನರಗಳ ಅಧ್ಯಾಯನಕ್ಕೆ ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ.",
                    options = listOf("ಅಂಕಾಲಜಿ", "ಜಿರಂಟಾಲಜಿ", "ನ್ಯೂರಾಲಜಿ", "ವಾಲೋಜಿ"),
                    correctAnswer = "ನ್ಯೂರಾಲಜಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನ್ಯೂರಾಲಜಿ."
                ),
                QuestionModel(
                    id = "tet_np_q24",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "24) ಕ್ಯಾಟ್ರಾಕ್ಟ್ ಇದು ಯಾವ ಅಂಗಕ್ಕೆ ಸಂಬಂಧಿಸಿದ ಕಾಯಿಲೆ?",
                    options = listOf("ಕಿವಿ", "ಕಣ್ಣು", "ಹೃದಯ", "ಮೆದಳು"),
                    correctAnswer = "ಕಣ್ಣು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಣ್ಣು."
                ),
                QuestionModel(
                    id = "tet_np_q25",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "25) ಚರ್ಮದ ಬಣ್ಣಕ್ಕೆ ಕಾರಣವಾದ ವಸ್ತು",
                    options = listOf("ಕೆರಾಟಿನ್", "ಹಿಮೊಗ್ಲೊಬಿನ್", "ಮೆಲಾನಿನ್", "ಫೈಕೊಎಂಡ್ರಿನ್"),
                    correctAnswer = "ಮೆಲಾನಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೆಲಾನಿನ್."
                ),
                QuestionModel(
                    id = "tet_np_q26",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "26) ಕ್ಷಯ ಯಾವ ಅಂಗಕ್ಕೆ ಸಂಬಂಧಿಸಿದ ಕಾಯಿಲೆ",
                    options = listOf("ಶ್ವಾಸ ಕೋಶ", "ಜಟರ", "ಮೂತ್ರಪಿಂಡ", "ಚರ್ಮ"),
                    correctAnswer = "ಶ್ವಾಸ ಕೋಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶ್ವಾಸ ಕೋಶ."
                ),
                QuestionModel(
                    id = "tet_np_q27",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "27) ನಮ್ಮ ಜಠರದಲ್ಲಿ ಉತ್ಪಾದನೆಗೊಳ್ಳುವ ಆಮ್ಲ ಯಾವುದು",
                    options = listOf("ಹೈಡ್ರೋಕ್ಲೋರಿಕ ಆಮ್ಲ", "ಹೈಡ್ರೋ ಪ್ಲೋರಿಕ ಆಮ್ಲ", "ಸಿಟ್ರೀಕ್ ಆಮ್ಲ", "ಟಾರ್ಟರಿಕ ಆಮ್ಲ"),
                    correctAnswer = "ಹೈಡ್ರೋಕ್ಲೋರಿಕ ಆಮ್ಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹೈಡ್ರೋಕ್ಲೋರಿಕ ಆಮ್ಲ."
                ),
                QuestionModel(
                    id = "tet_np_q28",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "28) ಮನುಷ್ಯನ ದೇಹದಲ್ಲಿರುವ ಅತಿ ದೊಡ್ಡ ಗ್ರಂಥಿ ಯಾವುದು",
                    options = listOf("ಅಶ್ರು ಗ್ರಂಥಿ", "ನಿರ್ನಾಳ ಗ್ರಂಥಿ", "ಪಿತ್ತಕೋಶ", "ಲಾಲಾರಸ"),
                    correctAnswer = "ಪಿತ್ತಕೋಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪಿತ್ತಕೋಶ."
                ),
                QuestionModel(
                    id = "tet_np_q29",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "29) ದೇಹದ ಸಮತೋಲನವನ್ನು ಕಾಪಾಡುವ ಮಿದುಳಿನ ಭಾಗ",
                    options = listOf("ಪಾನ್ಸ್", "ಅನುವ್ಯಸ್ತಿತ್ಕ", "ಮಹಾಮಸ್ತಿಕ", "ಮಧ್ಯ ಮೆದುಳು"),
                    correctAnswer = "ಅನುವ್ಯಸ್ತಿತ್ಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅನುವ್ಯಸ್ತಿತ್ಕ."
                ),
                QuestionModel(
                    id = "tet_np_q30",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "30) ಮೂತ್ರಜನಕಾಂಗಳಲ್ಲಿ ನೀರಿನ ವಿಸರ್ಜನೆಯನ್ನು ನಿಯಂತ್ರಿಸುವ ಹಾರ್ಮೊನು",
                    options = listOf("ಪ್ರೋಲ್ಯಾಕ್ಟಿನ್", "ವ್ಯಾಸೋಪ್ರೆಸಿನ್", "ಆಕ್ಸಿಟೊಸಿಸ್", "ಆಡ್ರಿನಾಲಿನ್"),
                    correctAnswer = "ವ್ಯಾಸೋಪ್ರೆಸಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವ್ಯಾಸೋಪ್ರೆಸಿನ್."
                ),
                QuestionModel(
                    id = "tet_np_q31",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "31) ಗೆರೊಂಟೋಲಾಜಿ ಈ ಅಧ್ಯಯನಕ್ಕೆ ಸಂಬಂಧಿಸಿದೆ",
                    options = listOf("ವಯಸ್ಸಾಗುವಿಕೆ", "ಜೀವಕೋಶಗಳ ಬೆಳವಣಿಗೆ", "ಪಕ್ಷಿಗಳು", "ತರಕಾರಿಗಳು"),
                    correctAnswer = "ವಯಸ್ಸಾಗುವಿಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಯಸ್ಸಾಗುವಿಕೆ."
                ),
                QuestionModel(
                    id = "tet_np_q32",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "32) ಬಿಳಿ ರಕ್ತಕಣಗಳ ಕಾರ್ಯ",
                    options = listOf("ರಕ್ತ ಹೆಪ್ಪುಗಟ್ಟುವುದು", "ಚಯಾಪಚಯ ಕ್ರಿಯೆ", "ಆಮ್ಲಜನಕ ಸಾಗಣೆ", "ಪ್ರತಿಕಾಯಗಳನ್ನು ತಯಾರಿಸುವುದು"),
                    correctAnswer = "ಪ್ರತಿಕಾಯಗಳನ್ನು ತಯಾರಿಸುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪ್ರತಿಕಾಯಗಳನ್ನು ತಯಾರಿಸುವುದು."
                ),
                QuestionModel(
                    id = "tet_np_q33",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "33) ರಕ್ತದ ಒತ್ತಡ ಕಂಡು ಹಿಡಿಯುವ ಸಾಧನ",
                    options = listOf("ಲ್ಯಾಕ್ಟೋಮೀಟರ", "ಫಾಥೋಮೀಟರ", "ಸ್ಟೇಥೆಸ್ಕೋಪ", "ಸ್ಪಿಗ್ಮೋಮ್ಯಾನೊ ಮೀಟರ"),
                    correctAnswer = "ಸ್ಪಿಗ್ಮೋಮ್ಯಾನೊ ಮೀಟರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ಪಿಗ್ಮೋಮ್ಯಾನೊ ಮೀಟರ."
                ),
                QuestionModel(
                    id = "tet_np_q34",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "34) ಇರುಳು ಪ್ರಕ್ರಿಯೆಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ.",
                    options = listOf("ಕ್ಯಾಲ್ವಿನ ಚಕ್ರ", "ಆರ್ನಿಥಿನ್ ಚಕ್ರ", "ಇಂಗಾಲ ಚಕ್ರ", "ಜೈವಿಕ ಚಕ್ರ"),
                    correctAnswer = "ಕ್ಯಾಲ್ವಿನ ಚಕ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ಯಾಲ್ವಿನ ಚಕ್ರ."
                ),
                QuestionModel(
                    id = "tet_np_q35",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "35) ಇರುಳು ಪ್ರಕ್ರಿಯೆಯು ನಡೆಯುವ ಭಾಗ",
                    options = listOf("ಗ್ರಾನಾ", "ಸ್ಟ್ರೋಮಾ", "ಹರಿದ್ರೇಣು", "ಮೀಸೊಫಿಲ್"),
                    correctAnswer = "ಸ್ಟ್ರೋಮಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ಟ್ರೋಮಾ."
                ),
                QuestionModel(
                    id = "tet_np_q36",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "36) ಹೂವಿನ ಗಂಡು ಪ್ರಜನನಾಂಗಗಳ ಸಮೂಹ",
                    options = listOf("ಕೇಸರ", "ಶಲಾಕಾಗ್ರ", "ಅಂಡಾಶಯ", "ಅಂಡಕಿ"),
                    correctAnswer = "ಕೇಸರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೇಸರ."
                ),
                QuestionModel(
                    id = "tet_np_q37",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "37) ಹೂವಿನ ಹೆಣ್ಣು ಪ್ರಜನನಾಂಗಗಳ ಸಮೂಹ",
                    options = listOf("ಕಾರ್ಪೆಲ್", "ಕೇಸರ", "ಪುಷ್ಪಪತ್ರ", "ಪುಷ್ಪಪೀಠ"),
                    correctAnswer = "ಕಾರ್ಪೆಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾರ್ಪೆಲ್."
                ),
                QuestionModel(
                    id = "tet_np_q38",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "38) ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಯಲ್ಲಿ ಬಿಡುಗಡೆಯಾಗುವ ಅನಿಲ",
                    options = listOf("ಆಮ್ಲಜನಕ", "ಹೈಡ್ರೋಜನ", "ಕಾರ್ಬನಡೈಆಕ್ಸೈಡ್", "ನೈಟ್ರೋಜನ್"),
                    correctAnswer = "ಕಾರ್ಬನಡೈಆಕ್ಸೈಡ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾರ್ಬನಡೈಆಕ್ಸೈಡ್."
                ),
                QuestionModel(
                    id = "tet_np_q39",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "39) ಶಿಲೀಂಧ್ರಗಳಿಗೆ ಆಹಾರವನ್ನು ಹೀರಲು ಸಹಾಯಕ ವಾಗಿರುವ ಭಾಗ",
                    options = listOf("ಹಾಸ್ಟೋರಿಯಾಗಳು", "ಹೈಫಾಗಳು", "ವೆಲಾಮೆನ್", "ರೋಮ ಬೇರುಗಳು"),
                    correctAnswer = "ಹೈಫಾಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹೈಫಾಗಳು."
                ),
                QuestionModel(
                    id = "tet_np_q40",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "40) ಮಾನವನ ಹಲ್ಲಿನ ಸಂಖ್ಯೆ",
                    options = listOf("32", "52", "23", "100"),
                    correctAnswer = "32",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 32."
                ),
                QuestionModel(
                    id = "tet_np_q41",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "41) ಕೀಟಾಹಾರಿ ಸಸ್ಯಗಳು ಕೀಟಗಳಿಂದ ಪಡೆಯುವ ಪೋಷಕಾಂಶ",
                    options = listOf("ಜಲಜನಕ ವಸ್ತುಗಳು", "ಇಂಗಾಲಯುಕ್ತ ವಸ್ತುಗಳು", "ಆಕ್ಸಿಜನಯುಕ್ತ ವಸ್ತುಗಳು", "ಸಾರಜನಕಯುಕ್ತ ವಸ್ತುಗಳು"),
                    correctAnswer = "ಸಾರಜನಕಯುಕ್ತ ವಸ್ತುಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಾರಜನಕಯುಕ್ತ ವಸ್ತುಗಳು."
                ),
                QuestionModel(
                    id = "tet_np_q42",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "42) ಅಪ್ಪು ಸಸ್ಯಗಳಲ್ಲಿರುವ ತೂಗಾಡುವ ಬೇರು ಗಳಲ್ಲಿರುವ ಅಂಗಾಂಶ",
                    options = listOf("ವೆಲಾಮೆನ್ ಅಂಗಾಂಶ", "ಕಾಲೆಂಕೈಮಾ ಅಂಗಾಂಶ", "ಪ್ಯಾರಂಕೈಮಾ ಅಂಗಾಂಶ", "ರಕ್ಷಕ ಅಂಗಾಂಶ"),
                    correctAnswer = "ವೆಲಾಮೆನ್ ಅಂಗಾಂಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವೆಲಾಮೆನ್ ಅಂಗಾಂಶ."
                ),
                QuestionModel(
                    id = "tet_np_q43",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "43) ಕಲ್ಲು ಹೂವಿನಲ್ಲಿ ಕೂಡು ಜೀವಿಸುವ ಸಸ್ಯಗಳು",
                    options = listOf("ಶೀಲಿಂದ್ರ ಕೀಟಹಾರಸಸ್ಯ", "ಶೀಲಿಂದ್ರ ಡಯಾಟಮ್", "ಪಾಚಿ ಶೀಲಿಂದ್ರ", "ಪಾಚಿ ಮಾಸ ಸಸ್ಯ"),
                    correctAnswer = "ಪಾಚಿ ಶೀಲಿಂದ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪಾಚಿ ಶೀಲಿಂದ್ರ."
                ),
                QuestionModel(
                    id = "tet_np_q44",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "44) ಹಲ್ಲನ್ನು ಆಧರಿಸಿರುವ ಗಟ್ಟಿ ವಸ್ತು",
                    options = listOf("ಡೆಂಟಿನ್", "ಸಿಮೆಂಟ", "ಎನಾಮಲ್", "ಮೂಳೆ"),
                    correctAnswer = "ಡೆಂಟಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಡೆಂಟಿನ್."
                ),
                QuestionModel(
                    id = "tet_np_q45",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "45) ಮಾನವನ ದೇಹದಲ್ಲಿ ಅತಿ ತೂಕವನ್ನು ಹೊಂದಿದ ಅಂಗ",
                    options = listOf("ಮೆದುಳು", "ಯಕೃತ", "ಹೃದಯ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಹೃದಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹೃದಯ."
                ),
                QuestionModel(
                    id = "tet_np_q46",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "46) ಹಸುವಿನ ದೇಹದಲ್ಲಿರುವ ಜೀರ್ಣಚೀಲಗಳು",
                    options = listOf("2", "3", "4", "ಯಾವುದು ಅಲ್ಲ."),
                    correctAnswer = "4",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 4."
                ),
                QuestionModel(
                    id = "tet_np_q47",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "47) ರಕ್ತನಾಳಗಳನ್ನು ಹೊಂದಿರದ ಚರ್ಮದ ಮೇಲ್ಪದರಿಗೆ",
                    options = listOf("ಎಪಿಡರ್ಮಿಸ್", "ಎಂಡ್ರ್ಮಿಸ್", "ಕೊಕಾಬಗ್ರ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಎಪಿಡರ್ಮಿಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎಪಿಡರ್ಮಿಸ್."
                ),
                QuestionModel(
                    id = "tet_np_q48",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "48) ಲಾಲಾರಸದಲ್ಲಿರುವ ಕಿಣ್ವ",
                    options = listOf("ಆಮೈಲೇಸ್", "ಲಿಪೇಸ್", "ಸುಕ್ರೇಸ್", "ಮಾಲ್ಟೇಸ್"),
                    correctAnswer = "ಆಮೈಲೇಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆಮೈಲೇಸ್."
                ),
                QuestionModel(
                    id = "tet_np_q49",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "49) ಸಣ್ಣ ಕರುಳಿನಲ್ಲಿರುವ ಬೆರಳಿನಾಕಾರದ ರಚನೆಯನ್ನು",
                    options = listOf("ಕಿಷ್ಟಿ", "ವಿಲ್ಲೈಗಳು", "ಮೇದೋಜಿರಕ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ವಿಲ್ಲೈಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಲ್ಲೈಗಳು."
                ),
                QuestionModel(
                    id = "tet_np_q50",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "50) ಹೀಮೋಡಯಾಲಿಸ್ನ ಕ್ರಿಯೆ",
                    options = listOf("ವಿಸರಣೆ", "ಅಭಿಸರಣೆ", "a & b", "ಯಾವುದು ಇಲ್ಲ"),
                    correctAnswer = "ಅಭಿಸರಣೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಭಿಸರಣೆ."
                ),
                QuestionModel(
                    id = "tet_np_q51",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "51) ಜೀವಕೋಶದ ಶಕ್ತಿ ಉತ್ಪಾದನೆ ಕೇಂದ್ರ",
                    options = listOf("ಲೈಸೋಸೋಮ್", "ಗಾಲ್ಗಿ ಸಂಕೀರ್ಣ", "ಮೈಟೋಕಾಂಡ್ರಿಯ", "ರೈಬೋಸೋಮ್"),
                    correctAnswer = "ಮೈಟೋಕಾಂಡ್ರಿಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೈಟೋಕಾಂಡ್ರಿಯ."
                ),
                QuestionModel(
                    id = "tet_np_q52",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "52) ಜೀವಕೋಶದ ಆತ್ಮಹತ್ಯಾ ಸಂಚಿಕೆಗಳು",
                    options = listOf("ಲೈಸೋಸೋಮ್", "ಗಾಲ್ಗಿ ಸಂಕೀರ್ಣ", "ಮೈಟೋಕಾಂಡ್ರಿಯ", "ರೈಬೋಸೋಮ್"),
                    correctAnswer = "ಲೈಸೋಸೋಮ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಲೈಸೋಸೋಮ್."
                ),
                QuestionModel(
                    id = "tet_np_q53",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "53) ಜೀವಕೋಶದ ಪ್ರೋಟಿನ್ ಕಾರ್ಖಾನೆ",
                    options = listOf("ರೈಬೋಸೋಮ್", "ಲೈಸಸೋಮ್", "ಮಟೋಕಾಂಡ್ರಿಯ", "ಗಾಲ್ಗಿಸಂಕೀರ್ಣ"),
                    correctAnswer = "ರೈಬೋಸೋಮ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರೈಬೋಸೋಮ್."
                ),
                QuestionModel(
                    id = "tet_np_q54",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "54) ವಯಸ್ಕ ಆರೋಗ್ಯವಂತ ಮಾನವರ ಮಿದುಳಿನ ತೂಕ",
                    options = listOf("200g", "1400g", "500g", "1250g"),
                    correctAnswer = "1400g",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1400g."
                ),
                QuestionModel(
                    id = "tet_np_q55",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "55) ಮಾನವನ ದೇಹದಲ್ಲಿ ಕೊಲೆಸ್ಟ್ರಾಲ್ ಸಂಗ್ರಹವನ್ನು ಕಡಿಮೆ ಮಾಡುವ ಲೋಹ",
                    options = listOf("ಕಬ್ಬಿಣ", "ಸತು", "ಬೆಳ್ಳಿ", "ಮೆಗ್ನೀಶಿಯಂ"),
                    correctAnswer = "ಸತು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸತು."
                ),
                QuestionModel(
                    id = "tet_np_q56",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "56) ಒಬ್ಬ ವ್ಯಕ್ತಿಗೆ ಸತತವಾಗಿ ಕೆಮ್ಮು ರಾತ್ರಿಯ ವೇಳೆಯಲ್ಲಿ ಜ್ವರ ಕಾಣಿಸಿಕೊಳ್ಳುವುದು ಹಸಿವಾಗದಿರುವುದು, ಊಟ ಸೇರದಿರುವುದು ಬಳಲಿಕೆ ಇದ್ದು, ಆ ವ್ಯಕ್ತಿ ಯಾವ ರೋಗದಿಂದ ಬಳಲುತ್ತಿದ್ದಾನೆ",
                    options = listOf("ಕಾಲರಾ", "ಮದುಮೇಹ", "ಅಜಿರ್ಣತೆ", "ಕ್ಷಯರೋಗ"),
                    correctAnswer = "ಕ್ಷಯರೋಗ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ಷಯರೋಗ."
                ),
                QuestionModel(
                    id = "tet_np_q57",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "57) ಅತಿಯಾದ ಗಣಿಗಾರಿಕೆ ನಡೆಸುವಂತಹ ಪ್ರದೇಶದಲ್ಲಿ ವಾಸಿಸುವ ಜನರು ಈ ಕಾಯಿಲೆಯಿಂದ ನರಳುತ್ತಿದ್ದಾರೆ",
                    options = listOf("ಸಿಲಿಕಾಸಿಸ್", "ಆಸ್ ಬೆಸ್ಟಾಸಿಸ್", "ಸೈಕಾಸಿಸ್", "ಅರ್ಥೈರೈಟಿಸ್"),
                    correctAnswer = "ಸಿಲಿಕಾಸಿಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಿಲಿಕಾಸಿಸ್."
                ),
                QuestionModel(
                    id = "tet_np_q58",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "58) ಕ್ಯಾನ್ಸರ ರೋಗ ಚಿಕಿತ್ಸೆಯಲ್ಲಿ ಬಳಸುವ ವಿಕಿರಣ ಸಮಸ್ಥಾನಿ",
                    options = listOf("ವಿಕಿರಣ ಸೋಡಿಯಂ-24", "ವಿಕಿರಣ ಪಾಸ್ಟರಸ್-30", "ವಿಕಿರಣ ಕೋಬಾಲ್ಟ್-60", "ಯುರೇನಿಯಂ-235"),
                    correctAnswer = "ವಿಕಿರಣ ಕೋಬಾಲ್ಟ್-60",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿಕಿರಣ ಕೋಬಾಲ್ಟ್-60."
                ),
                QuestionModel(
                    id = "tet_np_q59",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "59) ಅನ್ನನಾಳ ಮತ್ತು ದೇಹದ ಹೊರ ಭಿತ್ತಿಯ ನಡುವೆ ಮಿಥ್ಯಾಸ್ಥಳಾವಕಾಶ ಎಂಬ ದ್ರವ ತುಂಬಿದ ಕುಹರವನ್ನು ಹೊಂದಿರುವ ಜೀವಿ",
                    options = listOf("ಸೈಕಾನ್", "ಹೈಡ್ರಾ", "ಪ್ಲನೇರಿಯಾ", "ಜಿಗಣಿ"),
                    correctAnswer = "ಹೈಡ್ರಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹೈಡ್ರಾ."
                ),
                QuestionModel(
                    id = "tet_np_q60",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "60) ಡಿ.ಎನ್.ಎ ಯ ಜೋಡಿ ತಿರುವು ಸುರುಳಿ ಪಡಿರೂಪವನ್ನು ಪ್ರತಿಪಾದಿಸಿದ ವಿಜ್ಞಾನಿ ಯಾರು",
                    options = listOf("ಹಾರ್ಡಿ ಮತ್ತು ವೆನ್ ಬರ್ಗ", "ವ್ಯಾಟ್ಸನ್ ಮತ್ತು ಕ್ರಿಕ್", "ಬೆಂಥಮ್ ಮತ್ತು ಹುಕ್ಕರೆ", "ಯೂರೇ ಮತ್ತು ಮಿಲ್ಲರ್"),
                    correctAnswer = "ವ್ಯಾಟ್ಸನ್ ಮತ್ತು ಕ್ರಿಕ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವ್ಯಾಟ್ಸನ್ ಮತ್ತು ಕ್ರಿಕ್."
                ),
                QuestionModel(
                    id = "tet_np_q61",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "61) ಮೂತ್ರಜನಕಾಂಗಗಳಿಂದ ನೀರಿನ ವಿಸರ್ಜನೆಯನ್ನು ನಿಯಂತ್ರಿಸುವ ಹಾರ್ಮೋನು",
                    options = listOf("ವಾಸೋಪ್ರೆಸ್ಸಿನ್", "ಆಕ್ಸಿಟೋಸಿಸ್", "ಅಡ್ರಿನೋಕಾಟಿಕೋ ಟ್ರೋಫಿಕ್ ಹಾರ್ಮೋನ್", "ಲ್ಯೂಟಿನೈಜಿಂಗ್ ಹಾರ್ಮೋನ್"),
                    correctAnswer = "ವಾಸೋಪ್ರೆಸ್ಸಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಾಸೋಪ್ರೆಸ್ಸಿನ್."
                ),
                QuestionModel(
                    id = "tet_np_q62",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "62) ಪರಿವರ್ತಿತ ಚಾಪದ ಭಾಗಗಳನ್ನು ಕ್ರಮವಾಗಿ ಸಂದೇಶ ಹಾದುಹೋಗುವ ಮಾರ್ಗವನ್ನು ಗುರುತಿಸಿ",
                    options = listOf(
                        "ಜ್ಞಾನವಾಹಿ ನರಕೋಶ, ಕ್ರಿಯಾವಾಹಿ ನರ, ಸಂಬಂಧ ನರಕೋಶ, ಗ್ರಾಹಕ, ಕಾರ್ಯನಿರ್ವಾಹಕ",
                        "ಗ್ರಾಹಕ, ಸಂಬಂಧ ನರಕೋಶ, ಜ್ಞಾನಹಿನರಕೋಶ ಕ್ರಿಯಾವಾಹಿನರ ಕಾರ್ಯನಿರ್ವಾಹಕ",
                        "ಗ್ರಾಹಕ ಜ್ಞಾನವಾಹಹಿನರಕೋಶ, ಸಂಬಂಧ ನರಕೋಶ, ಕ್ರಿಯಾವಾಹಿನರ, ಕಾರ್ಯನಿರ್ವಾಹಕ",
                        "ಕ್ರಿಯಾವಾಹಿನರ, ಗ್ರಾಹಕ, ಜ್ಞಾನವಾಹಿನರಕೋಶ, ಸಂಬಂಧ ನರಕೋಶ, ಕಾರ್ಯನಿರ್ವಾಹಕ"
                    ),
                    correctAnswer = "ಗ್ರಾಹಕ ಜ್ಞಾನವಾಹಹಿನರಕೋಶ, ಸಂಬಂಧ ನರಕೋಶ, ಕ್ರಿಯಾವಾಹಿನರ, ಕಾರ್ಯನಿರ್ವಾಹಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗ್ರಾಹಕ ಜ್ಞಾನವಾಹಹಿನರಕೋಶ, ಸಂಬಂಧ ನರಕೋಶ, ಕ್ರಿಯಾವಾಹಿನರ, ಕಾರ್ಯನಿರ್ವಾಹಕ."
                ),
                QuestionModel(
                    id = "tet_np_q63",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "63) ಅನೇಕ ಕಾನೂನು ಬದ್ದ ವಿವಾದಗಳನ್ನು ಅತ್ಯಂತ ಸಮರ್ಪಕವಾಗಿ ಪರಿಹರಿಸಲು ಸಹಾಯ ಮಾಡುವ ತಂತ್ರಜ್ಞಾನ್",
                    options = listOf(
                        "ಪುನರ್ ಸಂಯೋಜಿತ ಡಿ.ಎನ್.ಎ ತಂತ್ರಜ್ಞಾನ್",
                        "ಡಿ.ಎನ್.ಎ ಬೆರಳಚ್ಚು ತಂತ್ರಜ್ಞಾನ",
                        "ಜೆಲ್ ಇಲೆಕ್ಟೋಫೊರೊಸಿಸ್",
                        "ಸಿ.ಎನ್.ಆರ್.ರಾವ್"
                    ),
                    correctAnswer = "ಡಿ.ಎನ್.ಎ ಬೆರಳಚ್ಚು ತಂತ್ರಜ್ಞಾನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಡಿ.ಎನ್.ಎ ಬೆರಳಚ್ಚು ತಂತ್ರಜ್ಞಾನ."
                ),
                QuestionModel(
                    id = "tet_np_q64",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "64) ಉಸಿರಾಟ ಒಂದು",
                    options = listOf("ಸ್ಪೋಟಕ ದಹನ", "ತೀವ್ರ ದಹನ", "ತಂತಾನೆ ದಹನ", "ನಿಧಾನ ದಹನ"),
                    correctAnswer = "ತೀವ್ರ ದಹನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತೀವ್ರ ದಹನ."
                ),
                QuestionModel(
                    id = "tet_np_q65",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "65) ಜೀವಕೋಶದಲ್ಲಿ ಸೆಂಟ್ರಿಯೋಲ್ ನ ಕಾರ್ಯ ಇದಾಗಿದೆ.",
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
                    id = "tet_np_q66",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "66) ದೇಹದಲ್ಲಿ ಆಹಾರವನ್ನು ಬಳಸಿಕೊಳ್ಳುವ ಪ್ರಕ್ರಿಯೆಯ ಹೆಸರು",
                    options = listOf("ಆಹಾರ ಸೇವನೆ", "ಪೋಷಣೆ", "ವಿಸರ್ಜನೆ", "ಮೇಲಿನ ಎಲ್ಲವು"),
                    correctAnswer = "ಪೋಷಣೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪೋಷಣೆ."
                ),
                QuestionModel(
                    id = "tet_np_q67",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "67) ಮಾನವನ ದೊಡ್ಡ ಕರುಳಿನಲ್ಲಿ ಕಾರ್ಬೋಹೈಡ್ರೇಟ್ನ್ನು ಜೀರ್ಣಿಸುವ ಬ್ಯಾಕ್ಟೀರಿಯಾ",
                    options = listOf("ಪ್ಲಾಸ್ಮೋಡಿಯಂ", "ನೇರಳೆ ಬ್ಯಾಕ್ಟೀರಿಯಾ", "ಇಸ್ಟಿರೀಶಿಯೋ ಕೊಲೈ", "ಎಂಟಮೀಬಾ"),
                    correctAnswer = "ಇಸ್ಟಿರೀಶಿಯೋ ಕೊಲೈ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಇಸ್ಟಿರೀಶಿಯೋ ಕೊಲೈ."
                ),
                QuestionModel(
                    id = "tet_np_q68",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 11,
                    type = "MCQ",
                    questionText = "68) ಮಾನವನ ಯಾವ ಅಂಗಕ್ಕೆ ಹೆಚ್ಚು ಆಕ್ಸಿಜನ್ ಅವಶ್ಯಕತೆ ಇದೆ",
                    options = listOf("ಶ್ವಾಸಕೋಶ", "ಹೃದಯ", "ಯಕೃತ್", "ಮಿದುಳು"),
                    correctAnswer = "ಮಿದುಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಿದುಳು."
                )
            )
        }
}
