package com.example.data

/**
 * TET (Teacher Eligibility Test - Standard / Exam ID: 13)
 * Subject: EVS, Science & Social Pedagogy ("general_science")
 * Unit 4: 3. ಸಸ್ಯಗಳು (Plants) — 267 MCQs.
 */
object TetPlantsQuestionBank {

    val unitTemplate = UnitTemplate(
        id = 4,
        name = "3. ಸಸ್ಯಗಳು (Plants)",
        totalQuestions = 267,
        difficulty = "Medium"
    )

    val questions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetPlants") {
            listOf(
                QuestionModel(
                    id = "tet_pl_q1",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "1) ಈ ವರ್ಗದ ಸಸ್ಯಗಳನ್ನು ಉಭಯ ಜೀವಿಗಳು ಏನ್ನುವರು",
                    options = listOf("ಹಾವಸೆ ಸಸ್ಯಗಳು", "ಜರಿ ಸಸ್ಯಗಳು", "ಜೆಮ್ನೋಸ್ಪರ್ಮ", "ಎಂಜಿಯೋ ಸ್ಪರ್ಮ"),
                    correctAnswer = "ಹಾವಸೆ ಸಸ್ಯಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹಾವಸೆ ಸಸ್ಯಗಳು."
                ),
                QuestionModel(
                    id = "tet_pl_q2",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "2) ರಿಕ್ಸಿಯಾ ಯಾವ ವರ್ಗಕ್ಕೆ ಸೇರಿದ ಸಸ್ಯವಾಗಿದೆ",
                    options = listOf("ಹಾವಸೆ ಸಸ್ಯ", "ಜರಿಸಸ್ಯ", "ನಗ್ನ ಬೀಜ ಸಸ್ಯ", "ಹೂ ಬಿಡುವ ಸಸ್ಯ"),
                    correctAnswer = "ಹಾವಸೆ ಸಸ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹಾವಸೆ ಸಸ್ಯ."
                ),
                QuestionModel(
                    id = "tet_pl_q3",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "3) ಅಡಿಯಾಟು ಯಾವ ವರ್ಗಕ್ಕೆ ಸೇರಿದೆ",
                    options = listOf("ಜರಿ ಸಸ್ಯ", "ಹಾವಸೆ ಸಸ್ಯ", "ನಗ್ನ ಬೀಜ ಸಸ್ಯ", "ಹೂ ಬಿಡುವ ಸಸ್ಯ"),
                    correctAnswer = "ಜರಿ ಸಸ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜರಿ ಸಸ್ಯ."
                ),
                QuestionModel(
                    id = "tet_pl_q4",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "4) ಸಸ್ಯದ ಸಂತಾನೊತ್ಪತ್ತಿಯ ಭಾಗ ಯಾವುದು",
                    options = listOf("ಹೂ", "ಕಾಯಿ", "ಹಣ್ಣು", "ಮೊಗ್ಗು"),
                    correctAnswer = "ಹೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹೂ."
                ),
                QuestionModel(
                    id = "tet_pl_q5",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "5) ಅತ್ಯಂತ ಚಿಕ್ಕ ಹೂ ಯಾವುದು ?",
                    options = listOf("ರ್ಯಾಪೋಷಿಯಾ", "ಚೆಂಡೂ ಹೂ", "ಊಲ್ಫೀಯಾ", "ಢಫೋಡಿಲ್ಸ್"),
                    correctAnswer = "ಊಲ್ಫೀಯಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಊಲ್ಫೀಯಾ."
                ),
                QuestionModel(
                    id = "tet_pl_q6",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "6) ಅತ್ಯಂತ ದೊಡ್ಡ ಹೂ ಯಾವುದು ?",
                    options = listOf("ರ್ಯಾಫೋಷಿಯಾ", "ಆರ್ರ್ಕೀಡ", "ಲಿಲ್ಲಿ", "ಮಲ್ಲಿಗೆ"),
                    correctAnswer = "ರ್ಯಾಫೋಷಿಯಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರ್ಯಾಫೋಷಿಯಾ."
                ),
                QuestionModel(
                    id = "tet_pl_q7",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "7) ಮಾವಿನ ಗಿಡದ ವೈಜ್ಞಾನಿಕ ಹೆಸರೇನು ?",
                    options = listOf("ಫಿಕಸ ಬೆಂಗಾಲೆನ್ಸಿಸ್", "ಮ್ಯೂಂಜಿಫೇರಾ ಇಂಡಿಕಾ", "ರವಲಫೀನಾ ಸರಡೆಂಟಿನಾ", "ಕ್ಯಾಸಿಯಾ ತುರಾ"),
                    correctAnswer = "ಮ್ಯೂಂಜಿಫೇರಾ ಇಂಡಿಕಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮ್ಯೂಂಜಿಫೇರಾ ಇಂಡಿಕಾ."
                ),
                QuestionModel(
                    id = "tet_pl_q8",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "8) ಶಂಕುಗಳು ಕಂಡು ಬರುವ ಸಸ್ಯಗಳ ವರ್ಗ",
                    options = listOf("ಹಾವಸೆ", "ಜರಿ ಸಸ್ಯಗಳು", "ನಗ್ನ ಬೀಜ ಸಸ್ಯಗಳು", "ಹೂ ಬಿಡುವ ಸಸ್ಯಗಳು"),
                    correctAnswer = "ನಗ್ನ ಬೀಜ ಸಸ್ಯಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನಗ್ನ ಬೀಜ ಸಸ್ಯಗಳು."
                ),
                QuestionModel(
                    id = "tet_pl_q9",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "9) ಕೆಂಪು ಶೈವಲ ಕೆಂಪಾಗಿರಲು ಕಾರಣವಾದ ವರ್ಣಕ",
                    options = listOf("ಫೈಕೊಸೈನಿನ", "ಫೈಕೋ ಕ್ಸೆಥಿನ್", "ಫೈಕೊ ಎರಿಥ್ರಿನ", "ಕ್ಯಾಥೋಫೀಲ್"),
                    correctAnswer = "ಫೈಕೊ ಎರಿಥ್ರಿನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಫೈಕೊ ಎರಿಥ್ರಿನ."
                ),
                QuestionModel(
                    id = "tet_pl_q10",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "10) ಕಂದು ಶೈವಲ ಕಂದಾಗಿರಲು ಕಾರಣವಾದ ವರ್ಣಕ",
                    options = listOf("ಫೈಕೊ ಎರಿಥ್ರಿನ", "ಕ್ಸಾಂಥೋಫೀಲ್", "ಫೆಕೋಸೈನಿನ್", "ಕ್ಲೋರೋಷಿನ್"),
                    correctAnswer = "ಕ್ಸಾಂಥೋಫೀಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ಸಾಂಥೋಫೀಲ್."
                ),
                QuestionModel(
                    id = "tet_pl_q11",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "11) ಇವುಗಳಲ್ಲಿ ಔಷಧೀಯ ಸಸ್ಯವನ್ನು ಹೆಸರಿಸಿ",
                    options = listOf("ಮಾವು", "ಸರ್ಪಗಂಧಿ", "ತಾಳೆ", "ತೆಂಗು"),
                    correctAnswer = "ಸರ್ಪಗಂಧಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸರ್ಪಗಂಧಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q12",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "12) ಕುಂಡಗಳಲ್ಲಿ ಕುಬ್ಜ ಸಸ್ಯಗಳನ್ನು ಬೆಳೆಯುವ ಪದ್ಧತಿಗೆ ಹಿಗೆನ್ನುವರು",
                    options = listOf("ಬಡಿಂಗ", "ಬೊನ್ಸಾಯಿ", "ಹೈಡ್ರೋಪೋನಿಕ್ಸ", "ತಾರಸಿ ವಿಧಾನ"),
                    correctAnswer = "ಬೊನ್ಸಾಯಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೊನ್ಸಾಯಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q13",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "13) ಹೂವಿನ ಗಂಡು ಭಾಗ ತಿಳಿಸಿರಿ",
                    options = listOf("ಶಲಾಕಾಗ್ರ", "ಅಂಡಾಶಯ", "ಶಲಾಕ ನಳಿಕೆ", "ಪರಾಗಕೋಶ"),
                    correctAnswer = "ಪರಾಗಕೋಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಾಗಕೋಶ."
                ),
                QuestionModel(
                    id = "tet_pl_q14",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "14) ಇವುಗಳಲ್ಲಿ ಸಾಂಬರ ಸಸ್ಯವನ್ನು ಗುರುತಿಸಿ",
                    options = listOf("ಕರಿ ಮೆಣಸು", "ರಾಗಿ", "ಎಳ್ಳು", "ಕೋಕೋ"),
                    correctAnswer = "ಕರಿ ಮೆಣಸು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕರಿ ಮೆಣಸು."
                ),
                QuestionModel(
                    id = "tet_pl_q15",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "15) ಆಯುರ್ವೆದ ಪಿತಾಮಹ ಎಂದು ಇವರನ್ನು ಕರೆಯುತ್ತಾರೆ.",
                    options = listOf("ಚರಕ", "ಅರಿಸ್ಟಾಟಲ್", "ಶುಶೃತ", "ಕರೊಲೊಸಲಿನೆಯಸ್"),
                    correctAnswer = "ಚರಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚರಕ."
                ),
                QuestionModel(
                    id = "tet_pl_q16",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "16) ಚಾಕಲೇಟ ತಯಾರಿಸಲು ಉಪಯೋಗಿಸುವ ಪಾನೀಯ ಸಸ್ಯ",
                    options = listOf("ಕಾಫಿ", "ಎಳ್ಳು", "ಕೋಕೋ", "ಹೆಂಡ್"),
                    correctAnswer = "ಕೋಕೋ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೋಕೋ."
                ),
                QuestionModel(
                    id = "tet_pl_q17",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "17) ವೃಕ್ಷಾಯುರ್ವೇದ ಗ್ರಂಥ ಬರೆದ ವಿಜ್ಞಾನಿ",
                    options = listOf("ಚರಕ", "ಅರಿಸ್ಟಾಟಲ್", "ಶುಶ್ರೂತ", "ಕೆರೊಲಸ್ಲಿನೆಯನ್"),
                    correctAnswer = "ಚರಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚರಕ."
                ),
                QuestionModel(
                    id = "tet_pl_q18",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "18) ಆಲ್ಜಿನ್ ಎನ್ನುವ ವಸ್ತು ಇದರಿಂದ ಪಡೆಯುತ್ತೇವೆ.",
                    options = listOf("ಶೈವಲಸಸ್ಯ", "ಜರಿ ಸಸ್ಯ", "ಆವೃತ ಬೀಜ ಸಸ್ಯ", "ಅನಾವೃತ ಬೀಜ ಸಸ್ಯ"),
                    correctAnswer = "ಶೈವಲಸಸ್ಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಶೈವಲಸಸ್ಯ."
                ),
                QuestionModel(
                    id = "tet_pl_q19",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "19) ಸಸ್ಯಗಳಿಗೆ ಜೀವವಿದೆ ಎಂದು ಕಂಡು ಹಿಡಿದ ವಿಜ್ಞಾನಿ",
                    options = listOf("ಜೆ.ಸಿ. ಬೋಸ", "ಅರಿಸ್ಟಾಟಲ್", "ರಾ. ವಿಟೆಕರ್", "ಜೆ.ಜೆ. ಥಾಮ್ಸನ್"),
                    correctAnswer = "ಜೆ.ಸಿ. ಬೋಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜೆ.ಸಿ. ಬೋಸ."
                ),
                QuestionModel(
                    id = "tet_pl_q20",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "20) ಇವುಗಳಲ್ಲಿ ಬಯೊಡಿಸಲ್ ಸಸ್ಯ ಗುರುತಿಸಿ",
                    options = listOf("ಪೋಂಗಮಿಯಾ ಪಿನ್ನಟಾ", "ಕ್ಯಾಸಿಯಾ ತುರಾ", "ಅಜಡ್ರಿಕಾ ಇಂಡಿಕಾ", "ಮ್ಯೂಂಜಿಫೆರಾ ಇಂಡಿಕಾ"),
                    correctAnswer = "ಪೋಂಗಮಿಯಾ ಪಿನ್ನಟಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪೋಂಗಮಿಯಾ ಪಿನ್ನಟಾ."
                ),
                QuestionModel(
                    id = "tet_pl_q21",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "21) ಸಸ್ಯಗಳ ಜೀವಿತಾವಧಿಯನ್ನು ಈ ರೀತಿಯಾಗಿ ವಿಂಗಡಿಸಿಲ್ಲ",
                    options = listOf("ಬಹುವಾರ್ಷಿಕ", "ತ್ರೈವಾರ್ಷಿಕ", "ದ್ವೈವಾರ್ಷಿಕ", "ಏಕವಾರ್ಷಿಕ"),
                    correctAnswer = "ತ್ರೈವಾರ್ಷಿಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತ್ರೈವಾರ್ಷಿಕ."
                ),
                QuestionModel(
                    id = "tet_pl_q22",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "22) ಸಸ್ಯದ ಬೆಳವಣಿಗೆಯನ್ನು ಅಳೆಯುವ ಉಪಕರಣ",
                    options = listOf("ಕ್ರೆಸ್ಕೂಗ್ರಾಫ್", "ಸಿಸ್ಮೋಗ್ರಾಫ್", "ರಿಕ್ಟೋಗ್ರಾಫ್", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಕ್ರೆಸ್ಕೂಗ್ರಾಫ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ರೆಸ್ಕೂಗ್ರಾಫ್."
                ),
                QuestionModel(
                    id = "tet_pl_q23",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "23) ದ್ಯುತಿ ಸಂಶ್ಲೇಷಣೆಯ ವೇಗ ಉಸಿರಾಟದ ವೇಗಕ್ಕಿಂತ",
                    options = listOf("ಜಾಸ್ತಿ", "ಕಡಿಮೆ", "ಸಮ", "ಹೆಚ್ಚು – ಕಡಿಮೆ"),
                    correctAnswer = "ಜಾಸ್ತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಾಸ್ತಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q24",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "24) ಎಲೆಯ ಈ ರೀತಿಯ ಸೀಳಿಕೆಯಿಂದ ಪತ್ರರಂಧ್ರ ಗಳನ್ನು ನೋಡಬಹುದು.",
                    options = listOf("ಅಡ್ಡ", "ಉದ್ದ", "ನೇರ", "ವಕ್ರ"),
                    correctAnswer = "ಅಡ್ಡ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಡ್ಡ."
                ),
                QuestionModel(
                    id = "tet_pl_q25",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "25) ಅದರದೇ ಕಣ್ಣುಗಳುಳ್ಳ ತುಂಡುಗಳ ಮೂಲಕ ಸಂತಾನೋತ್ಪತ್ತಿ ಹೊಂದುವ ಸಸ್ಯ",
                    options = listOf("ಪಪಾಯ", "ಜೋಳ", "ಕಬ್ಬು", "ಬೇವು"),
                    correctAnswer = "ಕಬ್ಬು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಬ್ಬು."
                ),
                QuestionModel(
                    id = "tet_pl_q26",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "26) ಆರ್ಥಿಕ ಬೆಳೆ ಎಂಬ ಆನ್ವರ್ಥನಾಮ ದಿಂದಲೂ ಕರೆಯಲಾಗುವ ಬೆಳೆ",
                    options = listOf("ಜೋಳ", "ಹತ್ತಿ", "ರಾಗಿ", "ಕಬ್ಬು"),
                    correctAnswer = "ಹತ್ತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹತ್ತಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q27",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "27) ಅತಿ ವೇಗವಾಗಿ ಬೆಳೆಯುವ ಮರ",
                    options = listOf("ನೀಲಗಿರಿ", "ಅಶೋಕ", "ಮಾವು", "ಬೇವು"),
                    correctAnswer = "ನೀಲಗಿರಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೀಲಗಿರಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q28",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "28) ಹಸಿರು ಕ್ರಾಂತಿಗೆ ಕಾರಣಕರ್ತವಾಗಿದ್ದು ಸಸ್ಯ ಬೆಳೆ",
                    options = listOf("ಕಬ್ಬು", "ಗೋಧಿ", "ಜೋಳ", "ಭತ್ತ"),
                    correctAnswer = "ಭತ್ತ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಭತ್ತ."
                ),
                QuestionModel(
                    id = "tet_pl_q29",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "29) ದ್ಯುತಿ ಸಂಶ್ಲೇಷಣಾ ಕ್ರಿಯೆಯ ವೇಳೆಯಲ್ಲಿ ಬಿಡುಗಡೆ ಯಾದ ಅನಿಲ",
                    options = listOf("ಇಂಗಾಲದ ಡೈ ಆಕ್ಸೈಡ್", "ಸಲ್ಫರ್ ಆಕ್ಸೈಡ್", "ಆಮ್ಲಜನಕ", "ಗಂಧಕದ ಆಮ್ಲ"),
                    correctAnswer = "ಆಮ್ಲಜನಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆಮ್ಲಜನಕ."
                ),
                QuestionModel(
                    id = "tet_pl_q30",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "30) ಬೀಜ ಪ್ರಸರಣದ' ಅರ್ಥ",
                    options = listOf("ಹರಡುವುದು", "ಸಂರಕ್ಷಣೆ", "ಭಕ್ಷಣೆ", "ಎಲ್ಲವೂ"),
                    correctAnswer = "ಹರಡುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹರಡುವುದು."
                ),
                QuestionModel(
                    id = "tet_pl_q31",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "31) ನಿತ್ಯಹರಿದ್ವರ್ಣ ಕಾಡುಗಳಲ್ಲಿ ಬಹು ಎತ್ತರದ ಮರಗಳು ಕಂಡುಬರಲು ಕಾರಣ",
                    options = listOf("ಆಕ್ಸಿಜನಗಾಗಿನ ಪೈಪೊಟಿ", "ನೀರಿಗಾಗಿನ ಪೈಪೊಟಿ", "ಸೂರ್ಯನ ಬೆಳಕಿಗಾಗಿ ಪೈಪೊಟಿ", "ಜಾಗಕ್ಕಾಗಿನ ಪೈಪೊಟಿ"),
                    correctAnswer = "ಸೂರ್ಯನ ಬೆಳಕಿಗಾಗಿ ಪೈಪೊಟಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೂರ್ಯನ ಬೆಳಕಿಗಾಗಿ ಪೈಪೊಟಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q32",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "32) ಸಸ್ಯವ್ಯೂಹದಲ್ಲಿ ಕಾಂಡದ ಬಹುಮುಖ್ಯ ಕಾರ್ಯ",
                    options = listOf("ಸಸ್ಯಕ್ಕೆ ಆಧಾರ ಒದಗಿಸುವುದು", "ನೀರಿನ ಸಾಗಾಣಿಕೆ", "ಎಲೆಗಳನ್ನು ಎತ್ತರಿಸಿ ಹಿಡಿಯುವುದು", "ಮೇಲಿನ ಎಲ್ಲವೂ"),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_pl_q33",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "33) 1) ಹಸಿರು ಸಸ್ಯಗಳು ಮಾತ್ರ ಆಹಾರ ತಯಾರಿಸುತ್ತವೆ.\n2) ಹಸಿರು ಸಸ್ಯಗಳು ಹರಿತ್ತನ್ನು ಹೂಂದಿದೆ.",
                    options = listOf("1 ಮಾತ್ರ ಸರಿ", "2 ಮಾತ್ರ ಸರಿ", "1 &2 ಸರಿ", "1 &2 ತಪ್ಪು"),
                    correctAnswer = "1 &2 ಸರಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1 &2 ಸರಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q34",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "34) ಇದು ತಂತು ಬೇರುಗಳನ್ನು ಹೊಂದಿರುವ ಸಸ್ಯವಾಗಿದೆ.",
                    options = listOf("ಹತ್ತಿ", "ಬಟಾಣಿ", "ಹುಲ್ಲು", "ಶೇಂಗಾ"),
                    correctAnswer = "ಹುಲ್ಲು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹುಲ್ಲು."
                ),
                QuestionModel(
                    id = "tet_pl_q35",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "35) ಕೀಟಗಳನ್ನು ಆರ್ಕಸುವ ಹೂವಿನ ಭಾಗ",
                    options = listOf("ಪುಷ್ಪ ದಳಗಳು", "ಪಷ್ಪ ಪತ್ರಗಳು", "ಶಲಾಕೆ", "ಕೇಸರ"),
                    correctAnswer = "ಪುಷ್ಪ ದಳಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪುಷ್ಪ ದಳಗಳು."
                ),
                QuestionModel(
                    id = "tet_pl_q36",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "36) ಸಸ್ಯದಲ್ಲಿ ಹಣ್ಣು ಇದರಿಂದ ಉಂಟಾಗುತ್ತದೆ.",
                    options = listOf("ಶಲಾಕೆ", "ಅಂಟಕ್", "ಅಂಡಾಶಯ", "ಶಲಾಕಾಗ್ರ"),
                    correctAnswer = "ಅಂಡಾಶಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಂಡಾಶಯ."
                ),
                QuestionModel(
                    id = "tet_pl_q37",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "37) ಸಸ್ಯದ ಎಲೆ ಹಸಿರಾಗಿರಲು ಕಾರಣ",
                    options = listOf("ಹಿಮೋಗ್ಲೋಬಿನ್", "ಗ್ಲೊಕೋಸ್", "ಪತ್ರ ಹರಿತ್ತು", "ಆಕ್ಸಿಜನ್"),
                    correctAnswer = "ಪತ್ರ ಹರಿತ್ತು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪತ್ರ ಹರಿತ್ತು."
                ),
                QuestionModel(
                    id = "tet_pl_q38",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "38) ಗ್ರಾನ ಭಾಗದಲ್ಲಿ ನಡೆಯುವ ಕ್ರಿಯೆ",
                    options = listOf("ಬೆಳಕಿನ ಪ್ರತಿಕ್ರಿಯೆ", "ಇರುಳು ಕ್ರಿಯೆ", "ಎ. ಮತ್ತು ಬಿ", "ಎ.ಬಿ.ಸಿ. ಇಲ್ಲ"),
                    correctAnswer = "ಬೆಳಕಿನ ಪ್ರತಿಕ್ರಿಯೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೆಳಕಿನ ಪ್ರತಿಕ್ರಿಯೆ."
                ),
                QuestionModel(
                    id = "tet_pl_q39",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "39) ನೆಫೆಂಥಿಸ್ (ಹುಂಜಿಗಿಡ)ವು ಕೀಟಾಗಳಿಂದ ಪಡೆಯುವ ಮೂಲ ವಸ್ತು",
                    options = listOf("ಕ್ಯಾಸ್ಲಿಯಂ", "ನೈಟ್ರೋಜನ್", "ಸೋಡಿಯಂ", "ಆಕ್ಸಿಜನ್"),
                    correctAnswer = "ನೈಟ್ರೋಜನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೈಟ್ರೋಜನ್."
                ),
                QuestionModel(
                    id = "tet_pl_q40",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "40) ಹೂವಿನ ಬಣ್ಣಕ್ಕೆ ಕಾರಣ",
                    options = listOf("ಲ್ಯೂಕೋಪ್ಲಾಸ್ಟ್", "ಕ್ಲೋರೋಪ್ಲಾಸ್ಟ", "ಪತ್ರ ಹರಿತ್ತು", "ಕ್ರೋಮೋಪ್ಲಾಸ್ಟ"),
                    correctAnswer = "ಕ್ರೋಮೋಪ್ಲಾಸ್ಟ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ರೋಮೋಪ್ಲಾಸ್ಟ."
                ),
                QuestionModel(
                    id = "tet_pl_q41",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "41) ಬಟಾಣೆ ಗಿಡದ ವೈಜ್ಞಾನಿಕ ಹೆಸರು",
                    options = listOf("ಪೈಸಮ್ ಸಟೈವಮ್", "ಮ್ಯಾಂಜಿಫೆರ ಇಂಡಿಕ", "ಹೋಮೋ ಸೆಪಿಯನ್ಸ್", "ಕ್ಯಾನಿಸ್ ಫೆಮಿಲಿಯಾರಿಸ್"),
                    correctAnswer = "ಪೈಸಮ್ ಸಟೈವಮ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪೈಸಮ್ ಸಟೈವಮ್."
                ),
                QuestionModel(
                    id = "tet_pl_q42",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "42) ಹೂ ಮತ್ತು ಹಣ್ಣುಗಳ ಬಣ್ಣಕ್ಕೆ ಕಾರಣ",
                    options = listOf("ಲ್ಯೂಕೋಪ್ಲಾಸ್ಟ್", "ಕ್ರೋಮೋಪ್ಲಾಸ್ಟ್", "ಎ ಮತ್ತು ಬಿ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಕ್ರೋಮೋಪ್ಲಾಸ್ಟ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ರೋಮೋಪ್ಲಾಸ್ಟ್."
                ),
                QuestionModel(
                    id = "tet_pl_q43",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "43) ಆಯುರ್ವೇದ ಪಿತಾಮಹ",
                    options = listOf("ಚರಕ", "ಪರಾಶರ", "ಅರಿಸ್ಟಾಟಲ್", "ಬ್ಯಾಕ್ಟೀರಿಯಾ"),
                    correctAnswer = "ಚರಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಚರಕ."
                ),
                QuestionModel(
                    id = "tet_pl_q44",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "44) ಏಕದಳ ಸಸ್ಯದ ಬೇರುಗಳು",
                    options = listOf("ತಂತು ಬೇರು", "ತಾಯಿಬೇರು", "ಎ ಮತ್ತು ಬಿ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ತಂತು ಬೇರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತಂತು ಬೇರು."
                ),
                QuestionModel(
                    id = "tet_pl_q45",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "45) ದ್ವಿದಳ ಸಸ್ಯದ ಬೇರುಗಳಲ್ಲಿ",
                    options = listOf("ತಂತು ಬೇರು", "ತಾಯಿ ಬೇರು", "ಎ ಮತ್ತು ಬಿ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ತಾಯಿ ಬೇರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತಾಯಿ ಬೇರು."
                ),
                QuestionModel(
                    id = "tet_pl_q46",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "46) ಜೋಳ, ರಾಗಿ",
                    options = listOf("ಏಕದಳ", "ದ್ವಿದಳ", "ತ್ರೀದಳ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಏಕದಳ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಏಕದಳ."
                ),
                QuestionModel(
                    id = "tet_pl_q47",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "47) ದ್ವಿದಳ ಧಾನ್ಯಗಳ ಬೇರಿನಲ್ಲಿರುವ ಬ್ಯಾಕ್ಟೀರಿಯಾ",
                    options = listOf("ಲ್ಯಾಕ್ಟೋಬ್ಯಾಕ್ಟೀರಿಯಾ", "ರೈಜೋಬಿಯಂ", "ಸ್ಪೈರೋಬ್ಯಾಕ್ಟಿರಿಯಾ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ರೈಜೋಬಿಯಂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರೈಜೋಬಿಯಂ."
                ),
                QuestionModel(
                    id = "tet_pl_q48",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "48) ಯೂರಿಯಾ ದಲ್ಲಿರುವ ನೈಟ್ರೋಜನ ಪ್ರಮಾಣ",
                    options = listOf("47%", "27%", "25%", "50%"),
                    correctAnswer = "47%",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 47%."
                ),
                QuestionModel(
                    id = "tet_pl_q49",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "49) ಒಬ್ಬ ರೈತನು ತನ್ನ ಹೊಲದಲ್ಲಿ ಬೆಳೆದ ಆಲೂಗಡ್ಡೆ ಯಲ್ಲಿ ಪ್ರತಿ ವರ್ಷ ಲಾಭವನ್ನು ಗಳಿಸಿರುತ್ತಾನೆ ಆದರೆ ಪ್ರಸ್ತುತ ವರ್ಷದಲ್ಲಿ ಅವನು ಬೆಳೆದ ಬೆಳೆಯ ಎಲೆಗಳು ಬೂದುಬಣ್ಣಕ್ಕೆ ತಿರುಗಿ ಬೆಳೆಯು ಸೊರಗಿಹೋಗಿರುತ್ತದೆ ಕಾರಣ",
                    options = listOf("ಅತಿಯಾದ ಮಳೆ", "ಕಡಿಮೆ ಮಳೆ", "ಖನಿಜಾಂಶಗಳ ಕೊರತೆ", "ಫಂಗಸ್ ಹಾವಳಿ"),
                    correctAnswer = "ಫಂಗಸ್ ಹಾವಳಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಫಂಗಸ್ ಹಾವಳಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q50",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "50) ಶೈವಲಗಳಲ್ಲಿ ಕೆಂಪು ಬಣ್ಣಕ್ಕೆ ಕಾರಣವಾದ ವರ್ಣಕ",
                    options = listOf("ಕ್ಯಾಂಥೋಫಿಲ್", "ಫೈಕೋ ಎರಿಥ್ರಿನ್", "ಫೈಕೋ ಸೈಯನಿನ್", "ಕ್ಲೋರೋಫಿಲ್"),
                    correctAnswer = "ಫೈಕೋ ಎರಿಥ್ರಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಫೈಕೋ ಎರಿಥ್ರಿನ್."
                ),
                QuestionModel(
                    id = "tet_pl_q51",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "51) ಶೈವಲ ಮತ್ತು ಶಿಲೀಂದ್ರಿಯಗಳು ಪರಸ್ಪರ ಲಾಭಕ್ಕಾಗಿ ಜೊತೆ ಜೀವನವನ್ನು ನಡೆಸುತ್ತವೆ. ಇವುಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ",
                    options = listOf("ಹಾವಸ ಸಸ್ಯ", "ಕಲ್ಲು ಹೂ", "ಅನಾವೃತ ಬೀಜಸಸ್ಯ", "ಜೀವರೋಧಕ"),
                    correctAnswer = "ಕಲ್ಲು ಹೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಲ್ಲು ಹೂ."
                ),
                QuestionModel(
                    id = "tet_pl_q52",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "52) ಸಸ್ಯ ಶಾಸ್ತ್ರದ ಜನಕ.........",
                    options = listOf("ಕಾರ್ಲಲೂಯಿಸ್", "ಕಾರ್ನವಾಲೀಸ್", "ಕರೋಲಸ್ ಲಿನಿಯಸ್", "ಕಾರ್ಲಮಾಕ್ರ್ಸ್"),
                    correctAnswer = "ಕರೋಲಸ್ ಲಿನಿಯಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕರೋಲಸ್ ಲಿನಿಯಸ್."
                ),
                QuestionModel(
                    id = "tet_pl_q53",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "53) ‘ಸಸ್ಯಗಳಿಗೆ ಜೀವವಿದೆ’ ಎಂದು ಹೇಳಿದ ಭಾರತೀಯ ವಿಜ್ಞಾನಿ",
                    options = listOf("ಸುಭಾಷ ಚಂದ್ರಬೋಸ್", "ಜಗದೀಶ ಚಂದ್ರಬೋಸ್", "ಹೋಮಿ ಬಾಬಾ", "ಚಾಲ್ರ್ಸ್ ಡಾರ್ವಿನ್"),
                    correctAnswer = "ಜಗದೀಶ ಚಂದ್ರಬೋಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಗದೀಶ ಚಂದ್ರಬೋಸ್."
                ),
                QuestionModel(
                    id = "tet_pl_q54",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "54) ಇದು ಒಂದು ಬೇರು",
                    options = listOf("ಶುಂಟಿ", "ಆಲೂಗಡ್ಡೆ", "ಮೂಲಂಗಿ", "ಅರಿಶಿನ"),
                    correctAnswer = "ಅರಿಶಿನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅರಿಶಿನ."
                ),
                QuestionModel(
                    id = "tet_pl_q55",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "55) ಹೂಗಳನ್ನು ಹೊಂದಿರುವ ಸಸ್ಯ",
                    options = listOf("ಬ್ರಯೋಫೈಟಾ", "ಎಂಜಿಯೋಸ್ಪರ್ಮ", "ಜಿಮನೋಸ್ಪರ್ಮ", "ಶೈವಲ"),
                    correctAnswer = "ಎಂಜಿಯೋಸ್ಪರ್ಮ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎಂಜಿಯೋಸ್ಪರ್ಮ."
                ),
                QuestionModel(
                    id = "tet_pl_q56",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "56) ತಮ್ಮ ಆಹಾರವನ್ನು ತಾವೇ ತಯ್ಯಾರಿಸಿಕೊಳ್ಳುವ ಹಸಿರು ಸಸ್ಯಗಳು",
                    options = listOf("ಸ್ವಪೋಷಕಗಳು", "ಪರಪೋಷಕಗಳು", "ಬಳ್ಳಿಗಳು", "ವಾರ್ಷಿಕ ಸಸ್ಯಗಳು"),
                    correctAnswer = "ಸ್ವಪೋಷಕಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ವಪೋಷಕಗಳು."
                ),
                QuestionModel(
                    id = "tet_pl_q57",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "57) ಒಂದು ಜಮೀನಿನಲ್ಲಿ ಒಂದೇ ಋತುವಿನಲ್ಲಿ 2 ಅಥವಾ ಹೆಚ್ಚು ಬೆಳೆಗಳನ್ನು ಬೆಳೆಯುವುದಕ್ಕೆ ಹೀಗೆನ್ನುವರು",
                    options = listOf("ಸರದಿ ಬೆಳೆ", "ಮಿಶ್ರ ಬೆಳೆ", "ಕೊಯ್ಲು ಮಾಡುವುದು", "ಊಳುವುದು"),
                    correctAnswer = "ಮಿಶ್ರ ಬೆಳೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಿಶ್ರ ಬೆಳೆ."
                ),
                QuestionModel(
                    id = "tet_pl_q58",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "58) ಹುಲ್ಲುಗಾವಲು ಆವಾಸದಲ್ಲಿನ ಮಳೆಯ ಪ್ರಮಾಣ ವರ್ಷಕ್ಕೆ",
                    options = listOf("ವರ್ಷಕ್ಕೆ 30 ರಿಂದ 75 ಸೆಂ.ಮಿ", "ವರ್ಷಕ್ಕೆ 40 ರಿಂದ 80 ಸೆಂ.ಮಿ", "ವರ್ಷಕ್ಕೆ 30 ರಿಂದ 60 ಸೆಂ.ಮಿ", "ವರ್ಷಕ್ಕೆ 25 ರಿಂದ 75 ಸೆಂ.ಮಿ"),
                    correctAnswer = "ವರ್ಷಕ್ಕೆ 25 ರಿಂದ 75 ಸೆಂ.ಮಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವರ್ಷಕ್ಕೆ 25 ರಿಂದ 75 ಸೆಂ.ಮಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q59",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "59) ಈರುಳ್ಳಿ ಸಸ್ಯದಲ್ಲಿ ಆಹಾರ ಸಂಗ್ರಹಣೆಯ ಭಾಗ",
                    options = listOf("ಎಲೆ", "ಬೇರು", "ಕಾಂಡ", "ಹೂ"),
                    correctAnswer = "ಎಲೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಎಲೆ."
                ),
                QuestionModel(
                    id = "tet_pl_q60",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "60) ಹೂವಿನ ಸಂತಾನೋತ್ಪತ್ತಿಯ ಹೆಣ್ಣು ಭಾಗ ಯಾವುದು?",
                    options = listOf("ಕೇಸರ", "ಅಂಡಾಶಯ", "ಅಂಡಕಗಳು", "ಶಲಾಕೆ"),
                    correctAnswer = "ಅಂಡಾಶಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಂಡಾಶಯ."
                ),
                QuestionModel(
                    id = "tet_pl_q61",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "61) ಈ ಕೆಳಗಿನ ಯಾವ ಸಸ್ಯವು ಆವೃತ ಬೀಜ ಸಸ್ಯಕ್ಕೆ ಸೇರಿಲ್ಲ?",
                    options = listOf("ಮಾವು", "ದಾಳಿಂಬೆ", "ದ್ರಾಕ್ಷಿ", "ಸೈಕಾಸ"),
                    correctAnswer = "ಸೈಕಾಸ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೈಕಾಸ."
                ),
                QuestionModel(
                    id = "tet_pl_q62",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "62) ವೆಲಸನಿರೆಯಾ ಸಸ್ಯದ ಉಸಿರಾಟಕ್ಕೆ ಸಹಾಯ ಮಾಡುವ ಬೇರು",
                    options = listOf("ಹೀರು ಬೇರು", "ವಾಯವಿಕ ಬೇರು", "ತಂತು ಬೇರು", "ತಾಯ ಬೇರು"),
                    correctAnswer = "ವಾಯವಿಕ ಬೇರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಾಯವಿಕ ಬೇರು."
                ),
                QuestionModel(
                    id = "tet_pl_q63",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "63) ಈ ಸಸ್ಯದ ಬೀಜವು ಸಸ್ಯ ಪ್ರಪಂಚದ ಅತಿ ದೊಡ್ಡ ಬೀಜ",
                    options = listOf("ಮಾವು", "ರೆಪ್ಲೆಸೀಯಾ", "ಕೊಕೋಡಿಮೇರ್", "ವುಲ್ಫಿಯಾ"),
                    correctAnswer = "ಕೊಕೋಡಿಮೇರ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೊಕೋಡಿಮೇರ್."
                ),
                QuestionModel(
                    id = "tet_pl_q64",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "64) ಒಂದು ಹೂವಿನ ಕೇಸರದಿಂದ ಶಲಾಗ್ರಕ್ಕೆ ಪರಾಗವು ವರ್ಗಾವಣೆಯಾಗುವ ಪ್ರಕ್ರಿಯೆ",
                    options = listOf("ನಿಶೇಚನ", "ಪರಾಗಸ್ಪರ್ಶ", "ಸ್ಪರ್ಶ", "ಅಪರಾಗಸ್ಪರ್ಶ"),
                    correctAnswer = "ಪರಾಗಸ್ಪರ್ಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಾಗಸ್ಪರ್ಶ."
                ),
                QuestionModel(
                    id = "tet_pl_q65",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "65) ಸ್ಪೈರೋಗೈರ ಜೀವಿಯಲ್ಲಿ ಸಂತಾನೋತ್ಪತ್ತಿಯ ವಿಧ",
                    options = listOf("ವಿದಳನ", "ಪುನರುತ್ಪತ್ತಿ", "ಬೀಜಾಣು ಉತ್ಪತ್ತಿ", "ತುಂಡಾಗುವಿಕೆ"),
                    correctAnswer = "ವಿದಳನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿದಳನ."
                ),
                QuestionModel(
                    id = "tet_pl_q66",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "66) ಮಾಂಸಲ ಬೇರು ಹೊಂದಿರುವ ಸಸ್ಯ",
                    options = listOf("ಆಲೂಗಡ್ಡೆ", "ಗೆಣಸು", "ಶುಂಠಿ", "ಶೇಂಗಾ"),
                    correctAnswer = "ಗೆಣಸು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗೆಣಸು."
                ),
                QuestionModel(
                    id = "tet_pl_q67",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "67) ಸಸ್ಯದಲ್ಲಿ ಹಣ್ಣು ಇದರಿಂದ ಉಂಟಾಗುತ್ತದೆ",
                    options = listOf("ಶಲಾಕೆ", "ಅಂಡಕ", "ಅಂಡಾಶಯ", "ಶಲಾಕಾಗ್ರ"),
                    correctAnswer = "ಅಂಡಾಶಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅಂಡಾಶಯ."
                ),
                QuestionModel(
                    id = "tet_pl_q68",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "68) ಪಕ್ವವಾದ ಅಂಡಾಶಯ ಇದನ್ನು ಉಂಟು ಮಾಡುತ್ತದೆ",
                    options = listOf("ಬೀಜ", "ಕೇಸರ", "ಶಲಾಕೆ", "ಹಣ್ಣು"),
                    correctAnswer = "ಬೀಜ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೀಜ."
                ),
                QuestionModel(
                    id = "tet_pl_q69",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "69) ಕ್ರಿಸ್ಟೆಗಳು ಇಲ್ಲಿ ಕಂಡುಬರುತ್ತವೆ",
                    options = listOf("ಮೈಟೋಕಾಂಡ್ರಿಯಾ", "ಲೈಸೋಸೋಮು", "ಗಾಲ್ಗಿ ಸಂಕೀರ್ಣ", "ರೈಬೋಸೋಮು"),
                    correctAnswer = "ಮೈಟೋಕಾಂಡ್ರಿಯಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೈಟೋಕಾಂಡ್ರಿಯಾ."
                ),
                QuestionModel(
                    id = "tet_pl_q70",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "70) ಪ್ಲಾಸ್ಟಿಡ್ಗಳು ಇಲ್ಲಿ ಕಂಡು ಬರುತ್ತವೆ",
                    options = listOf("ಪ್ರಾಣಿ ಜೀವಕೋಶದಲ್ಲಿ", "ಸಸ್ಯ ಜೀವಕೋಶದಲ್ಲಿ", "ಪಕ್ಷಿ ಜೀವಕೋಶದಲ್ಲಿ", "ಸೂಕ್ಷ್ಮಾಣು ಜೀವಕೋಶದಲ್ಲಿ"),
                    correctAnswer = "ಸಸ್ಯ ಜೀವಕೋಶದಲ್ಲಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಸ್ಯ ಜೀವಕೋಶದಲ್ಲಿ."
                ),
                QuestionModel(
                    id = "tet_pl_q71",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "71) ಬಣ್ಣ ಕೊಡದ ವರ್ಣಕಗಳಿಲ್ಲದ ಪ್ಲಾಸ್ಟಿಡ್ಗಳು",
                    options = listOf("ಕ್ಲೋರೋಪ್ಲಾಸ್ಟಗಳು", "ಕ್ರೋಮೋಪ್ಲಾಸ್ಟಗಳು", "ಯೂಕೋಪ್ಲಸ್ಟಗಳು", "ಎಲ್ಲವು"),
                    correctAnswer = "ಕ್ರೋಮೋಪ್ಲಾಸ್ಟಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕ್ರೋಮೋಪ್ಲಾಸ್ಟಗಳು."
                ),
                QuestionModel(
                    id = "tet_pl_q72",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "72) ಕ್ಯಾರಟ್, ಗೆಣಸು, ಬೀಟ್ರೂಟ್ ಸಸ್ಯದ ಇದರ ಭಾಗಗಳಾಗಿವೆ.",
                    options = listOf("ಎಲೆಗಳು", "ಕಾಂಡಗಳು", "ಬೇರುಗಳು", "ಕಾಯಿಗಳು"),
                    correctAnswer = "ಕಾಂಡಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಾಂಡಗಳು."
                ),
                QuestionModel(
                    id = "tet_pl_q73",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "73) ಸ್ಪೀಪೀಸ್ ಪ್ಲಾಂಟೇರಂ ಪುಸ್ತಕದ ಕರ್ತೃ",
                    options = listOf("ಪರಾಶರ", "ಅರಿಸ್ಟಾಟಲ್", "ಕರೋಲಸ್ ಲೀನಿಯಸ್", "ಚಾಲ್ರ್ಸ ಡಾರ್ವಿನ್"),
                    correctAnswer = "ಕರೋಲಸ್ ಲೀನಿಯಸ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕರೋಲಸ್ ಲೀನಿಯಸ್."
                ),
                QuestionModel(
                    id = "tet_pl_q74",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "74) ಎಲ್ಲಾ ಸಸ್ಯಗಳ ಬೆಳವಿಣಿಗೆಗೆ ಅತ್ಯವಶ್ಯಕವಾಗಿ ಬೇಕಾಗಿರುವ ಧಾತುಗಳ ಸಂಕೇತಾಕ್ಷರಗಳು",
                    options = listOf("N, P, K", "S, Pb, K", "K, Cu, F", "P, Ca, Pt"),
                    correctAnswer = "N, P, K",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: N, P, K."
                ),
                QuestionModel(
                    id = "tet_pl_q75",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 4,
                    type = "MCQ",
                    questionText = "75) ನೈಟ್ರೋಜನಸ್ ಗೊಬ್ಬರಕ್ಕೆ ಒಂದು ಉದಾಹರಣೆ",
                    options = listOf("ಸುಪರ ಫಾಸ್ಫೇಟ್", "ಯೂರಿಯಾ", "ಫೊಟ್ಯಾಸಿಂ ಸಲ್ಫೇಟ್", "ಪೊಟ್ಯಾಶಿಯಮ ಕ್ಲೋರೈಡ್"),
                    correctAnswer = "ಯೂರಿಯಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯೂರಿಯಾ."
                )
            ) + TetPlantsExtraQuestions.questions
        }
}
