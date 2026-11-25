package com.example.data

/**
 * TET (Teacher Eligibility Test - Standard / Exam ID: 13)
 * Subject: EVS, Science & Social Pedagogy ("general_science")
 * Unit 7: 6. ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲಗಳು (Natural Resources) — 181 MCQs.
 */
object TetNaturalResourcesQuestionBank {

    val unitTemplate = UnitTemplate(
        id = 7,
        name = "6. ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲಗಳು (Natural Resources)",
        totalQuestions = 181,
        difficulty = "Medium"
    )

    val questions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("TetNaturalResources") {
            listOf(
                QuestionModel(
                    id = "tet_nr_q1",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "1) ಇವುಗಳಲ್ಲಿ ಜೈವಿಕ ಸಂಪನ್ಮೂಲಗಳನ್ನು ತಿಳಿಸಿ",
                    options = listOf("ಗಾಳಿ", "ಮಣ್ಣು", "ಸಸ್ಯಗಳು", "ಖನಿಜಗಳು"),
                    correctAnswer = "ಸಸ್ಯಗಳು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಸ್ಯಗಳು."
                ),
                QuestionModel(
                    id = "tet_nr_q2",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "2) ಇವುಗಳಲ್ಲಿ ಒಂದು ಈ ಗುಂಪಿಗೆ ಸೇರುವುದಿಲ್ಲ",
                    options = listOf("ನೀರು", "ಕಾಡುಗಳು", "ಪೆಟ್ರೋಲ್", "ಮಣ್ಣು"),
                    correctAnswer = "ಪೆಟ್ರೋಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪೆಟ್ರೋಲ್."
                ),
                QuestionModel(
                    id = "tet_nr_q3",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "3) ಅತಿ ಹೆಚ್ಚು ಪ್ರಮಾಣದ ಕಾರ್ಬನ ಇರುವ ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲ",
                    options = listOf("ಆಂಥ್ರಸೈಟ್", "ಪಿಟ್", "ಲಿಗ್ನೈಟ", "ಬಿಟ್ಯೂಮಿನಸ"),
                    correctAnswer = "ಆಂಥ್ರಸೈಟ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಆಂಥ್ರಸೈಟ್."
                ),
                QuestionModel(
                    id = "tet_nr_q4",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "4) ಯಾವ ದಿನದಂದು ವಿಶ್ವದಾದ್ಯಂತ ವಿಶ್ವಜಲ ದಿನ ವನ್ನಾಗಿ ಆಚರಿಸುತ್ತಾರೆ.",
                    options = listOf("ಮಾರ್ಚ-21", "ಮಾರ್ಚ-22", "ಡಿಸೆಂಬರ್-1", "ಫೆಬ್ರುವರಿ-14"),
                    correctAnswer = "ಮಾರ್ಚ-22",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾರ್ಚ-22."
                ),
                QuestionModel(
                    id = "tet_nr_q5",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "5) ಅಳಿವಿನಂಚಿನಲ್ಲಿರುವ ಪ್ರಭೇದ",
                    options = listOf("ಬೇವಿನ ಮರ", "ಗುಲಾಬಿ", "ಸರ್ಪಗಂಧಿ", "ಜಾಲಿಮರ"),
                    correctAnswer = "ಸರ್ಪಗಂಧಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸರ್ಪಗಂಧಿ."
                ),
                QuestionModel(
                    id = "tet_nr_q6",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "6) ಅನ್ಯನೆಲೆ ಜೀವಿ ಸಂರಕ್ಷಣೆಗೆ ಉದಾಹರಣೆ",
                    options = listOf("ಬೀಜ ಬ್ಯಾಂಕ್", "ರಾಷ್ಟೀಯ ಉದ್ಯಾನವನ", "ಅಭಯಾರಣ್ಯ", "ಸಾಕು ಪ್ರಾಣಿಗಳು"),
                    correctAnswer = "ಬೀಜ ಬ್ಯಾಂಕ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬೀಜ ಬ್ಯಾಂಕ್."
                ),
                QuestionModel(
                    id = "tet_nr_q7",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "7) ಇದು ಕಲ್ಲಿದ್ದಿಲಿನ ಒಂದು ಉಪ ಉತ್ಪನ್ನ",
                    options = listOf("ಸಾರಜನಕ", "ಕೋಕ", "ಗ್ರಾಫೈಟ", "ವಜ್ರ"),
                    correctAnswer = "ಕೋಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೋಕ."
                ),
                QuestionModel(
                    id = "tet_nr_q8",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "8) ನಶಿಸಿ ಹೋಗುತ್ತಿರುವ ಪ್ರಾಣಿ",
                    options = listOf("ಹುಲಿ", "ಕಾಡೆಮ್ಮೆ", "ಉಣ್ಣೆಯ ಮಹಾಗಜ", "ಮಂಗುಸಿ"),
                    correctAnswer = "ಉಣ್ಣೆಯ ಮಹಾಗಜ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಉಣ್ಣೆಯ ಮಹಾಗಜ."
                ),
                QuestionModel(
                    id = "tet_nr_q9",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "9) ಚಿಪ್ಕೋ ಚಳುವಳಿಯನ್ನು ಪ್ರಾರಂಭಿಸಿದವರು",
                    options = listOf("ಸಾಲುಮರದ ತಿಮ್ಮಕ್ಕ", "ಸುಂದರಲಾಲ ಬಹುಗುಣ", "ಮೋಧಾ ತಾಟ್ಕರ", "ಸುರೇಶ ಹೆಬ್ಳೀಕರ್"),
                    correctAnswer = "ಸುಂದರಲಾಲ ಬಹುಗುಣ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸುಂದರಲಾಲ ಬಹುಗುಣ."
                ),
                QuestionModel(
                    id = "tet_nr_q10",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "10) ಚಿಪ್ಕೋ ಚಳುವಳಿ ಸಂಬಂಧಿಸಿದ್ದು",
                    options = listOf("ಅರಣ್ಯ ಸಂರಕ್ಷಣೆ", "ಮಣ್ಣಿನ ಸಂರಕ್ಷಣೆ", "ನೀರಿನ ಸಂರಕ್ಷಣೆ", "ಜಾಗುನೆಲೆ ಸಂರಕ್ಷಣೆ"),
                    correctAnswer = "ಅರಣ್ಯ ಸಂರಕ್ಷಣೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅರಣ್ಯ ಸಂರಕ್ಷಣೆ."
                ),
                QuestionModel(
                    id = "tet_nr_q11",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "11) ಅರಣ್ಯನಾಶದಿಂದ ಕಡಿಮೆಯಾಗುವುದು",
                    options = listOf("ಮಣ್ಣಿನ ಸವಕಳಿ", "ಮಣ್ಣಿನ ಫಲವತ್ತತೆ", "ಬೆಟ್ಟದಿಣ್ಣೆಗಳು", "ಮಳೆ ಬಿಳುವಿಕೆ"),
                    correctAnswer = "ಮಳೆ ಬಿಳುವಿಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಳೆ ಬಿಳುವಿಕೆ."
                ),
                QuestionModel(
                    id = "tet_nr_q12",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "12) ಅರಣ್ಯಗಳ ಬಂಜರಾಗುವುದು ಕೆಳಗಿನವುಗಳಿಂದ ತಡೆಯಬಹುದು",
                    options = listOf(
                        "ಮಣ್ಣಿನ ಸವಕಳಿ ತಡೆಯುವುದು",
                        "ಆಕ್ಸಿಜನ ಹೆಚ್ಚಿಸುವುದರಿಂದ",
                        "ವಾತಾವರಣದಲ್ಲಿ ತೇವಾಂಶ ಹಾಗು ಮಳೆ ಬೀಳುವಿಕೆ",
                        "ಚಂಡಮಾರುತಗಳನ್ನು ತಡೆಯುವುದು"
                    ),
                    correctAnswer = "ವಾತಾವರಣದಲ್ಲಿ ತೇವಾಂಶ ಹಾಗು ಮಳೆ ಬೀಳುವಿಕೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಾತಾವರಣದಲ್ಲಿ ತೇವಾಂಶ ಹಾಗು ಮಳೆ ಬೀಳುವಿಕೆ."
                ),
                QuestionModel(
                    id = "tet_nr_q13",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "13) ಭೂಮಿಯ ಮೇಲೆ ಸಿಹಿ ನೀರಿನ ಪ್ರಮಾಣ",
                    options = listOf("97.5%", "0.01%", "2.5%", "1.97%"),
                    correctAnswer = "2.5%",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 2.5%."
                ),
                QuestionModel(
                    id = "tet_nr_q14",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "14) ಓಝೋನ ಪದರ ಯಾವ ಗೊಳದಲ್ಲಿ ಕಂಡು ಬರುತ್ತದೆ.",
                    options = listOf("ವಾಯಗೋಳ", "ಸ್ತರಗೋಳ", "ಆಯಾನುಗೋಳ", "ಬಹೀಗೋಳ"),
                    correctAnswer = "ಸ್ತರಗೋಳ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ತರಗೋಳ."
                ),
                QuestionModel(
                    id = "tet_nr_q15",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "15) ರಾಷ್ಟೀಯ ಉದ್ಯಾನವನದ ಸಂರಕ್ಷಣೆಯ ಕಾರ್ಯ",
                    options = listOf("ಒಟ್ಟು ಪರಿಸರ ವ್ಯವಸ್ಥೆ", "ಸಸ್ಯ ಮತ್ತು ಪ್ರಾಣಿಗಳು", "ಸಸ್ಯಗಳು", "ಪ್ರಾಣಿಗಳು"),
                    correctAnswer = "ಒಟ್ಟು ಪರಿಸರ ವ್ಯವಸ್ಥೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಒಟ್ಟು ಪರಿಸರ ವ್ಯವಸ್ಥೆ."
                ),
                QuestionModel(
                    id = "tet_nr_q16",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "16) IUCN stands for",
                    options = listOf(
                        "Indian Union of Chemical Nomenclature",
                        "Indian Union of Conservation of Nature",
                        "International Union for conservation of Nature",
                        "International Union for conservation of nutrients."
                    ),
                    correctAnswer = "International Union for conservation of Nature",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: International Union for conservation of Nature."
                ),
                QuestionModel(
                    id = "tet_nr_q17",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "17) ಭೂಮಿಯಲ್ಲಿ ದೊರೆಯುವ ನೈಸರ್ಗಿಕ ಕಾಂತ",
                    options = listOf("ಮಾಗ್ನಟೈಟ್", "ಹೆಮೆಟೈಟ್", "ಲಿಮೋನೈಟ", "ಸೆಡರೈಟ್"),
                    correctAnswer = "ಮಾಗ್ನಟೈಟ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾಗ್ನಟೈಟ್."
                ),
                QuestionModel(
                    id = "tet_nr_q18",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "18) ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಪ್ರಚ್ಚನ ಶಕ್ತಿಯನ್ನು ಗುರುತಿಸಿ?",
                    options = listOf("ಹರಿಯುತ್ತಿರುವ ನೀರು", "ಚಲಿಸುತ್ತಿರುವ ಗಾಳಿ", "ಗಡಿಯಾರದ ಸ್ಪ್ರಿಂಗಿನ ಕೀ", "ತೂಗುತ್ತಿರುವ ಉಯ್ಯಾಲೆ"),
                    correctAnswer = "ಗಡಿಯಾರದ ಸ್ಪ್ರಿಂಗಿನ ಕೀ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗಡಿಯಾರದ ಸ್ಪ್ರಿಂಗಿನ ಕೀ."
                ),
                QuestionModel(
                    id = "tet_nr_q19",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "19) ಸೌರಶಕ್ತಿಯನ್ನು ವಿದ್ಯುತ ಶಕ್ತಿಯನ್ನಾಗಿ ಪರಿವರ್ತಿಸುವ ಸಾಧನ",
                    options = listOf("ಸೌರಕೋಶ", "ಡ್ರೆನಮೋ", "ಮೋಟಾರ್", "ಮೈಕ್ರೋಫೋನ್"),
                    correctAnswer = "ಸೌರಕೋಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೌರಕೋಶ."
                ),
                QuestionModel(
                    id = "tet_nr_q20",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "20) ಮಣ್ಣಿಗೆ ನೀರಿನ ಮುಖ್ಯ ಮೂಲ",
                    options = listOf("ಮಳೆ", "ನದಿ", "ಕಾಲುವೆ", "ಸರೋವರ"),
                    correctAnswer = "ಮಳೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಳೆ."
                ),
                QuestionModel(
                    id = "tet_nr_q21",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "21) ಸಿಹಿ ನೀರಿನ ಗರಿಷ್ಠ ಪ್ರಮಾಣದ ಉಪಯೋಗ",
                    options = listOf("ಕೃಷಿ", "ಕಾರ್ಖಾನೆ", "ಮೀನು ಸಾಕಾಣಿಕೆ", "ಗೃಹ ಬಳಕೆ"),
                    correctAnswer = "ಕೃಷಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೃಷಿ."
                ),
                QuestionModel(
                    id = "tet_nr_q22",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "22) ಗಿರ್ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ ಇರುವ ರಾಜ್ಯ",
                    options = listOf("ರಾಜಸ್ಥಾನ", "ಹಿಮಾಚಲ ಪ್ರದೇಶ", "ಗುಜರಾತ", "ಜಾರ್ಖಂಡ"),
                    correctAnswer = "ಗುಜರಾತ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಗುಜರಾತ."
                ),
                QuestionModel(
                    id = "tet_nr_q23",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "23) ನರ್ಮದಾ ಬಚಾವೋ ಆಂದೋಲನ್ ಎಂಬ ಚಳವಳಿ ಪ್ರಾರಂಭಿಸಿದವರು.",
                    options = listOf("ಸಾಲು ಮರದ ತಿಮ್ಮಕ್ಕ", "ತೆಹ್ರಿ ಹಳ್ಳಿಯ ಮಹಿಳೆ", "ಮೇಧಾ ಪಾಟ್ಕರ್", "ಸುಂದರ್ ಲಾಲ್ ಬಹುಗುಣ"),
                    correctAnswer = "ಮೇಧಾ ಪಾಟ್ಕರ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಧಾ ಪಾಟ್ಕರ್."
                ),
                QuestionModel(
                    id = "tet_nr_q24",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "24) ಸಂಜಯಗಾಂಧಿ ವನ್ಯಜೀವಿ ಅಭಯಾರಣ್ಯ ಇರುವ ರಾಜ್ಯ",
                    options = listOf("ಗುಜರಾತ", "ಕರ್ನಾಟಕ", "ಮಹಾರಾಷ್ಟ್ರ", "ತಮಿಳುನಾಡು"),
                    correctAnswer = "ಮಹಾರಾಷ್ಟ್ರ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಹಾರಾಷ್ಟ್ರ."
                ),
                QuestionModel(
                    id = "tet_nr_q25",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "25) ಭಾರತೀಯ ಅರಣ್ಯ ಕಾಯ್ದೆ ಜಾರಿಗೆ ಬಂದ ವರ್ಷ",
                    options = listOf("1926", "1927", "1929", "1930"),
                    correctAnswer = "1927",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 1927."
                ),
                QuestionModel(
                    id = "tet_nr_q26",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "26) ಕಲ್ಲಿದ್ದಲಿನ ಅನಿಲದಿಂದ ತಯಾರಿಸುವ ಸಾವಯವ ಸಂಯುಕ್ತ",
                    options = listOf("ಗಂಧಕ", "ಕೋಕ್", "ಅಮೋನಿಯಾ", "ಸ್ಯಾಕರಿನ್"),
                    correctAnswer = "ಸ್ಯಾಕರಿನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸ್ಯಾಕರಿನ್."
                ),
                QuestionModel(
                    id = "tet_nr_q27",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "27) ಮಾಗ್ನೇಸೈಟ್ ತಯ್ಯಾರಿಕೆಯಲ್ಲಿ ಮಂಚೂಣಿ ಯಲ್ಲಿರುವ ರಾಜ್ಯ",
                    options = listOf("ಕರ್ನಾಟಕ", "ಆಂದ್ರಪ್ರದೇಶ", "ತಮಿಳುನಾಡು", "ಓಡಿಸ್ಸಾ"),
                    correctAnswer = "ತಮಿಳುನಾಡು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತಮಿಳುನಾಡು."
                ),
                QuestionModel(
                    id = "tet_nr_q28",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "28) ಮ್ಯಾಂಗನೀಸ್ ತಯಾರಿಕೆಯಲ್ಲಿ ಮಂಚೂಣಿ ಯಲ್ಲಿರುವ ರಾಜ್ಯ",
                    options = listOf("ಓಡಿಸ್ಸಾ", "ಆಂಧ್ರಪ್ರದೇಶ", "ಕರ್ನಾಟಕ", "ಮಹಾರಾಷ್ಟ್ರ"),
                    correctAnswer = "ಓಡಿಸ್ಸಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಓಡಿಸ್ಸಾ."
                ),
                QuestionModel(
                    id = "tet_nr_q29",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "29) ಬಾಹ್ಯರೇಖೆ ಕೃಷಿ ಪದ್ಧತಿಯಲ್ಲಿ ಇಳಿಜಾರು ಪ್ರದೇಶಕ್ಕೆ ................. ವಾಗಿ ಉಳುಮೆ ಮಾಡಲಾಗುತ್ತದೆ",
                    options = listOf("ಸಮಾನಾಂತರ", "ಲಂಬಕೋನ", "ಕರ್ಣ", "ಮೇಲಿನ ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಲಂಬಕೋನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಲಂಬಕೋನ."
                ),
                QuestionModel(
                    id = "tet_nr_q30",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "30) ಯಾವ ನೈಸರ್ಗಿಕ ಕ್ರಿಯೆಯ ಮೂಲಕ ಮಣ್ಣು ರೂಪುಗೊಳ್ಳುತ್ತದೆ",
                    options = listOf("ಶಿಥೀಲೀಕರಣ", "ಬಂಡೆಗಳ ಶಿಥೀಲಿಕರಣ", "ಶೈತಿಕರಣ", "ಶುದ್ಧಿಕರಣ"),
                    correctAnswer = "ಬಂಡೆಗಳ ಶಿಥೀಲಿಕರಣ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಬಂಡೆಗಳ ಶಿಥೀಲಿಕರಣ."
                ),
                QuestionModel(
                    id = "tet_nr_q31",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "31) ಗಂಧಕದ ಪ್ರಮಾಣ ಕಡಿಮೆ ಇರುವ ಇಂಧನ",
                    options = listOf("ಪೆಟ್ರೋಲ್", "ನಾಫ್ತಾ", "ಪ್ಯಾರಾಫೀನ್", "ನೈಸರ್ಗಿಕ ಅನಿಲ"),
                    correctAnswer = "ನೈಸರ್ಗಿಕ ಅನಿಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೈಸರ್ಗಿಕ ಅನಿಲ."
                ),
                QuestionModel(
                    id = "tet_nr_q32",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "32) ಯಾವುದೇ ಆಣೆಕಟ್ಟು ಸಹಾಯವಿಲ್ಲದೆ ನದಿ ಗಳಿಂದ ನೇರವಾಗಿ ನೀರು ಪಡೆಯುವುದು",
                    options = listOf("ಸಾರ್ವಕಾಲಿಕ ಕಾಲುವೆ", "ಸಾರ್ವಕಾಲಿಕವಲ್ಲದ ಕಾಲುವೆ", "ಪ್ರವಾಹ ಕಾಲುವೆ", "ನಂಗಲ್ ಕಾಲುವೆ"),
                    correctAnswer = "ಪ್ರವಾಹ ಕಾಲುವೆ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪ್ರವಾಹ ಕಾಲುವೆ."
                ),
                QuestionModel(
                    id = "tet_nr_q33",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "33) ಹತ್ತಿ ಬೆಳೆಯಲು ಕಪ್ಪು ಮಣ್ಣು ಸೂಕ್ತವಾಗಿರುವುದು ಏಕೆಂದರೆ ಅದು",
                    options = listOf(
                        "ಪೊಟಾಷ್ ಮತ್ತು ಸಾರಜನಕ",
                        "ಕಬ್ಬಿಣದ ಅಂಶ ಹೇರಳವಾಗಿದೆ",
                        "ತೇವಾಂಶ ಹಿಡಿದಿಡಲು ಸಾಧ್ಯವಿರುವುದು",
                        "ಶಿಲೆಗಳ ಶಿಥಿಲೀಕರಣದಿಂದ ರಚಿತವಾಗಿರುವುದು"
                    ),
                    correctAnswer = "ತೇವಾಂಶ ಹಿಡಿದಿಡಲು ಸಾಧ್ಯವಿರುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ತೇವಾಂಶ ಹಿಡಿದಿಡಲು ಸಾಧ್ಯವಿರುವುದು."
                ),
                QuestionModel(
                    id = "tet_nr_q34",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "34) ಕೆಳಕಂಡವುಗಳಲ್ಲಿ ಒಂದು ಮುಗಿಯುವ ಸಂಪನ್ಮೂಲವಲ್ಲ",
                    options = listOf("ಸೂರ್ಯನ ಬೆಳಕು", "ಕಾಡುಗಳು", "ನೈಸರ್ಗಿಕ ಅನಿಲ", "ಗಾಳಿ"),
                    correctAnswer = "ನೈಸರ್ಗಿಕ ಅನಿಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೈಸರ್ಗಿಕ ಅನಿಲ."
                ),
                QuestionModel(
                    id = "tet_nr_q35",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "35) ಆಮ್ಲ ಮಳೆಯಲ್ಲಿ ಹೆಚ್ಚಾಗಿ ಕಂಡುಬರುವ ಆಮ್ಲ",
                    options = listOf("ಸಲಫ್ಯೂರಿಕ್ ಆಮ್ಲ", "ಹೈಡ್ರೋಕ್ಲೊರಿಕ ಆಮ್ಲ", "ನೈಟ್ರಿಕ ಆಮ್ಲ", "ಕಾರ್ಬೋನಿಕ ಆಮ್ಲ"),
                    correctAnswer = "ಸಲಫ್ಯೂರಿಕ್ ಆಮ್ಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಲಫ್ಯೂರಿಕ್ ಆಮ್ಲ."
                ),
                QuestionModel(
                    id = "tet_nr_q36",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "36) ಭಾರತದಲ್ಲಿ ಅತಿ ಹೆಚ್ಚು ನೀರಾವರಿ ಪ್ರದೇಶ ಹೊಂದಿರುವ ರಾಜ್ಯ",
                    options = listOf("ಪಂಜಾಬ್", "ಬಿಹಾರ", "ಆಂಧ್ರಪ್ರದೇಶ", "ಉತ್ತರ ಪ್ರದೇಶ"),
                    correctAnswer = "ಪಂಜಾಬ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪಂಜಾಬ್."
                ),
                QuestionModel(
                    id = "tet_nr_q37",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "37) “ಪರಿಸರ ವ್ಯವಸ್ಥೆಯ ಜನರು” ಎಂಬುದಕ್ಕೆ ಕೆಳಗಿನ ಯಾರು ಉದಾಹರಣೆ",
                    options = listOf(
                        "ತೀವ್ರ ವ್ಯವಸಾಯದಲ್ಲಿ ನಿರತರಾದ ರೈತರು",
                        "ರಫ್ತು ಮಾಡುವುದಕ್ಕಾಗಿ ಜೈವಿಕ ವ್ಯವಸಾಯ ವೃತ್ತಿ",
                        "ಅರಣ್ಯದಿಂದ ಸಂಪನ್ಮೂಲಗಳನ್ನು ಸಂಗ್ರಹಿಸುವ ಬುಡಕಟ್ಟಿನವರು",
                        "ಭಾರಿ ಉತ್ಪಾದನೆಯಲ್ಲಿ ತೊಡಗಿರುವ ಜಾನುವಾರು ಕ್ಷೇತ್ರ ಇಟ್ಟಿರುವವರು."
                    ),
                    correctAnswer = "ಅರಣ್ಯದಿಂದ ಸಂಪನ್ಮೂಲಗಳನ್ನು ಸಂಗ್ರಹಿಸುವ ಬುಡಕಟ್ಟಿನವರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಅರಣ್ಯದಿಂದ ಸಂಪನ್ಮೂಲಗಳನ್ನು ಸಂಗ್ರಹಿಸುವ ಬುಡಕಟ್ಟಿನವರು."
                ),
                QuestionModel(
                    id = "tet_nr_q38",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "38) ಬಯಾಲಾಜಿಕಲ್ ಹಾಟಸ್ಪಾಟ ಎಂದರೆ",
                    options = listOf(
                        "ಜೈವಿಕವಾಗಿ ಬಹಳ ಮುಖ್ಯ ಪ್ರದೇಶ",
                        "ಪರಿಸರ ಆತಂಕಕಾರಿ ಹಂತ ತಲುಪಿರುವ ಪ್ರದೇಶ",
                        "ಬಹಳ ಬಿಸಿಯಾದ ಸ್ಥಳ",
                        "ಜೀವ ವೈವಿದ್ಯ ಸುರಕ್ಷಿತ ತಾಣ"
                    ),
                    correctAnswer = "ಪರಿಸರ ಆತಂಕಕಾರಿ ಹಂತ ತಲುಪಿರುವ ಪ್ರದೇಶ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪರಿಸರ ಆತಂಕಕಾರಿ ಹಂತ ತಲುಪಿರುವ ಪ್ರದೇಶ."
                ),
                QuestionModel(
                    id = "tet_nr_q39",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "39) ವೈಜ್ಞಾನಿಕವಾಗಿ ಓಜೋನ್ನ್ನು ಗುರುತಿಸುವ ವಿಧಾನ",
                    options = listOf("0", "02", "03", "04"),
                    correctAnswer = "03",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 03."
                ),
                QuestionModel(
                    id = "tet_nr_q40",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "40) ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಸಾಂಪ್ರದಾಯಿಕ ಶಕ್ತಿಯ ಆಕರವನ್ನು ಗುರುತಿಸಿ",
                    options = listOf("ಸೌರಶಕ್ತಿ", "ಅಲೆಗಳ ಶಕ್ತಿ", "ನೈಸರ್ಗಿಕ ಅನಿಲ", "ಜೈವಿಕ ಶಕ್ತಿ"),
                    correctAnswer = "ನೈಸರ್ಗಿಕ ಅನಿಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೈಸರ್ಗಿಕ ಅನಿಲ."
                ),
                QuestionModel(
                    id = "tet_nr_q41",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "41) ಈ ಕೆಳಗಿನ ಒಂದು ಸೌರಶಕ್ತಿಯ ಪರೋಕ್ಷ ರೂಪ",
                    options = listOf("ಅಲೆಗಳ ಶಕ್ತಿ", "ತ್ಯಾಜ್ಯಗಳಿಂದ ಬರುವ ಶಕ್ತಿ", "ಭೂಗರ್ಭ ಉಷ್ಣ ಶಕ್ತಿ", "ವಿದ್ಯುತ ಶಕ್ತಿ"),
                    correctAnswer = "ವಿದ್ಯುತ ಶಕ್ತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ವಿದ್ಯುತ ಶಕ್ತಿ."
                ),
                QuestionModel(
                    id = "tet_nr_q42",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "42) ನಮ್ಮ ದೇಶದಲ್ಲಿ ಅತಿದೊಡ್ಡ ಗಾಳಿ ಯಂತ್ರಗಳು ಇಲ್ಲಿ ಕಂಡುಬರುತ್ತವೆ",
                    options = listOf("ಲಡಾಖ್", "ಗುಜರಾತ್", "ಕನ್ಯಾಕುಮಾರಿ", "ಮಧ್ಯಪ್ರದೇಶ"),
                    correctAnswer = "ಕನ್ಯಾಕುಮಾರಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕನ್ಯಾಕುಮಾರಿ."
                ),
                QuestionModel(
                    id = "tet_nr_q43",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "43) ಕುಲಾಂತರಿ ಸಸ್ಯಗಳ ಅನುಕೂಲತೆ",
                    options = listOf("ಕೀಟಗಳ ಹಾವಳಿ ತಡೆಯುವುದು", "ಬೀಜಗಳ ಬಂಜೆತನ", "ಕೀಟಗಳ ಆಕರ್ಷಣೆ", "ಸಸ್ಯಗಳ ಬೆಳವಣಿಗೆ"),
                    correctAnswer = "ಕೀಟಗಳ ಹಾವಳಿ ತಡೆಯುವುದು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕೀಟಗಳ ಹಾವಳಿ ತಡೆಯುವುದು."
                ),
                QuestionModel(
                    id = "tet_nr_q44",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "44) ಅಣುಬಾಂಬನ್ನು ಕಂಡು ಹಿಡಿದ ವಿಜ್ಞಾನಿ ಯಾರು?",
                    options = listOf("ರುದರ್ ಪೋರ್ಡ್", "ಒಟ್ಟೋಹಾನ್", "ಕಾರ್ಲ್ಬೆಂಜ್", "ಮ್ಯಾಕಮಿಲನ್"),
                    correctAnswer = "ಒಟ್ಟೋಹಾನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಒಟ್ಟೋಹಾನ್."
                ),
                QuestionModel(
                    id = "tet_nr_q45",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "45) ಭವಿಷ್ಯದ ಇಂಧನವಾಗಿ ಬಿಂಬಿಸುವ ಅನಿಲ",
                    options = listOf("ಆಕ್ಸಿಜನ್", "ಹೈಡ್ರೋಜನ್", "ನೈಟ್ರೋಜನ್", "ಬ್ರೋಮಿನ್"),
                    correctAnswer = "ಹೈಡ್ರೋಜನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹೈಡ್ರೋಜನ್."
                ),
                QuestionModel(
                    id = "tet_nr_q46",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "46) ಕಾರ್ಬನ್ ಇಲ್ಲದ ಏಕೈಕ ಅನಿಲ ರೂಪದ ಇಂಧನವಿದ.",
                    options = listOf("ಆಮ್ಮಜನಕ", "ಜಲಜನಕ", "ಪಾದರಸ", "ಬ್ರೋಮಿನ್"),
                    correctAnswer = "ಜಲಜನಕ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜಲಜನಕ."
                ),
                QuestionModel(
                    id = "tet_nr_q47",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "47) C N G ಯ ವಿಸ್ತೂತರೂಪ",
                    options = listOf("Compound Nature", "Complet Natural Gal", "Compressed Natural Gas", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "Compressed Natural Gas",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: Compressed Natural Gas."
                ),
                QuestionModel(
                    id = "tet_nr_q48",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "48) ಒಂದು ಕಾರ್ಬನ್ ಮತ್ತು ನಾಲ್ಕು ಹೈಡ್ರೋಜನ್ ಪರಮಾಣು ಹೊಂದಿದೆ.",
                    options = listOf("ಮೀಥೇನ್", "ಈಥೇನ್", "ಪೆಂಟೇನ್", "ಬ್ರೋಮೀನ್"),
                    correctAnswer = "ಮೀಥೇನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೀಥೇನ್."
                ),
                QuestionModel(
                    id = "tet_nr_q49",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "49) ಕಪ್ಪು ಬಂಗಾರವೆಂತಲೂ ಕರೆಯಲಾಗುತ್ತದೆ.",
                    options = listOf("ಪೆಟ್ರೋಲ್", "ಕಲ್ಲಿದ್ದಲು", "ಪೆಟ್ರೋಲಿಯಮ್", "ಯಾವುದ ಅಲ್ಲ."),
                    correctAnswer = "ಕಲ್ಲಿದ್ದಲು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಕಲ್ಲಿದ್ದಲು."
                ),
                QuestionModel(
                    id = "tet_nr_q50",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "50) ಆಕಾಶ ನೌಕೆಯಲ್ಲಿ ಬಳಸುವ ಇಂಧನ",
                    options = listOf("ದ್ರವರೂಪದ ಹೈಡ್ರೋಜನ್", "ಘನರೂಪದ ಹೈಡ್ರೋಜನ್", "ಅನಿಲರೂಪದ ಹೈಡ್ರೋಜನ್", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ದ್ರವರೂಪದ ಹೈಡ್ರೋಜನ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ದ್ರವರೂಪದ ಹೈಡ್ರೋಜನ್."
                ),
                QuestionModel(
                    id = "tet_nr_q51",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "51) ನಿಕ್ಕಲ್ ನಿಕ್ಷೇಪಗಳನ್ನು ಹೊಂದಿದ ಭಾರತದ ಏಕೈಕ ರಾಜ್ಯ",
                    options = listOf("ಮಹಾರಾಷ್ಟ್ರ", "ಕರ್ನಾಟಕ", "ಆಂದ್ರಪ್ರದೇಶ", "ಓಡಿಸ್ಸಾ"),
                    correctAnswer = "ಓಡಿಸ್ಸಾ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಓಡಿಸ್ಸಾ."
                ),
                QuestionModel(
                    id = "tet_nr_q52",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "52) ಮಾನವನ ದೇಹದಲ್ಲಿ ಅತಿ ತೂಕವನ್ನು ಹೊಂದಿದ ಅಂಗ",
                    options = listOf("ಮೆದುಳು", "ಯಕೃತ", "ಹೃದಯ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಹೃದಯ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಹೃದಯ."
                ),
                QuestionModel(
                    id = "tet_nr_q53",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "53) ಹಸುವಿನ ದೇಹದಲ್ಲಿರುವ ಜೀರ್ಣಚೀಲಗಳು",
                    options = listOf("2", "3", "4", "ಯಾವುದು ಅಲ್ಲ."),
                    correctAnswer = "4",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: 4."
                ),
                QuestionModel(
                    id = "tet_nr_q54",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "54) ಗ್ಯಾಸೋಲಿನ್ ಇದು",
                    options = listOf("ಘನ ಇಂಧನ", "ದ್ರವ ಇಂಧನ", "ಅನಿಲ ಇಂಧನ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ದ್ರವ ಇಂಧನ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ದ್ರವ ಇಂಧನ."
                ),
                QuestionModel(
                    id = "tet_nr_q55",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "55) ಸಾಮಾನ್ಯವಾಗಿ 'ಬಿಳಿ ಇದ್ದಿಲು' ಎಂದು ಕರೆಯುವರು",
                    options = listOf("ಯುರೇನಿಯಮ್", "ಲಿಗ್ನೈಟ್", "ಲಿಥಿಯಮ್", "ಥೋರಿಯಮ್"),
                    correctAnswer = "ಯುರೇನಿಯಮ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಯುರೇನಿಯಮ್."
                ),
                QuestionModel(
                    id = "tet_nr_q56",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "56) ಸೂರ್ಯ ಸೌರಶಕ್ತಿ :: ಚಲಿಸುವ ಗಾಳಿ :",
                    options = listOf("ವಿದ್ಯುತ್ ಶಕ್ತಿ", "ಪವನ ಶಕ್ತಿ", "ಸ್ನಾಯು ಶಕ್ತಿ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ಪವನ ಶಕ್ತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಪವನ ಶಕ್ತಿ."
                ),
                QuestionModel(
                    id = "tet_nr_q57",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "57) ಉಷ್ಣ ವಿದ್ಯುತ್ ಸ್ಥಾವರ ಕರ್ನಾಟಕದ ಈ ಜಿಲ್ಲೆಯಲ್ಲಿದೆ.",
                    options = listOf("ಕೊಪ್ಪಳ", "ಬಳ್ಳಾರಿ", "ರಾಯಚೂರು", "ಬೀದರ್"),
                    correctAnswer = "ರಾಯಚೂರು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ರಾಯಚೂರು."
                ),
                QuestionModel(
                    id = "tet_nr_q58",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "58) ಸೌರ ಜಲತಾಪಕದ ಬಳಕೆ",
                    options = listOf("ನೀರು ಕಾಯಿಸಲು", "ಅಡುಗೆ ತಯಾರಿಕೆ", "ವಿದ್ಯುತ್ ತಯಾರಿಕೆ", "ಎಲ್ಲವೂ"),
                    correctAnswer = "ನೀರು ಕಾಯಿಸಲು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೀರು ಕಾಯಿಸಲು."
                ),
                QuestionModel(
                    id = "tet_nr_q59",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "59) ಹ್ಯೂಮಸ್ ಪ್ರಮಾಣವು ಈ ಮಣ್ಣಿನಲ್ಲಿ ಅತ್ಯಂತ ಕಡಿಮೆ",
                    options = listOf("ರ್ಯಾವಿ ಮಣ್ಣು", "ಮೆಕ್ಕಲು ಮಣ್ಣು", "ಮರಳು ಮಣ್ಣು", "ಎರೆ ಮಣ್ಣು"),
                    correctAnswer = "ಮರಳು ಮಣ್ಣು",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮರಳು ಮಣ್ಣು."
                ),
                QuestionModel(
                    id = "tet_nr_q60",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "60) ನವೀಕರಣಗೊಳ್ಳುವ ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲ",
                    options = listOf("ಖನಿಜಗಳು", "ಸೌರಶಕ್ತಿ", "ಕಲ್ಲಿದ್ದಲು", "ಪಳೆಯುಳಿಕೆ ಇಂಧನ ಶಕ್ತಿ"),
                    correctAnswer = "ಸೌರಶಕ್ತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೌರಶಕ್ತಿ."
                ),
                QuestionModel(
                    id = "tet_nr_q61",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "61) ವಿಶ್ವ ಜಲ ದಿನ",
                    options = listOf("ಮೇ-22", "ಮಾರ್ಚ-21", "ಮಾರ್ಚ-22", "ಏಪ್ರೀಲ್-08"),
                    correctAnswer = "ಮಾರ್ಚ-22",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾರ್ಚ-22."
                ),
                QuestionModel(
                    id = "tet_nr_q62",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "62) ವಿಶ್ವ ಅರಣ್ಯ ದಿನ",
                    options = listOf("ಮಾರ್ಚ-21", "ಜೂನ್-05", "ಮಾರ್ಚ-22", "ಜೂನ್-06"),
                    correctAnswer = "ಮಾರ್ಚ-21",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮಾರ್ಚ-21."
                ),
                QuestionModel(
                    id = "tet_nr_q63",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "63) ಎಲ್ಲಾ ಶಕ್ತಿಗಳಿಗೆ ಮೂಲ ಶಕ್ತಿ",
                    options = listOf("ಸೌರಶಕ್ತಿ", "ಜಲಶಕ್ತಿ", "ವಿದ್ಯುತ್ಶಕ್ತಿ", "ವಾಯುಶಕ್ತಿ"),
                    correctAnswer = "ಸೌರಶಕ್ತಿ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸೌರಶಕ್ತಿ."
                ),
                QuestionModel(
                    id = "tet_nr_q64",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "64) ಜೈವಿಕ ವಿಘಟನೆಯಾಗದ ವಸ್ತು",
                    options = listOf("ಉಪ್ಪು", "ಲಿಪಿಡ್", "ಪಿಷ್ಟ", "ಡಿ.ಡಿ.ಟಿ."),
                    correctAnswer = "ಡಿ.ಡಿ.ಟಿ.",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಡಿ.ಡಿ.ಟಿ."
                ),
                QuestionModel(
                    id = "tet_nr_q65",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "65) ಇವುಗಳಲ್ಲಿ ಅತ್ಯಂತ ಕಡಿಮೆ ಪರಿಸರ ಮಾಲಿನ್ಯ ವನ್ನು ಉಂಟು ಮಾಡುವುದು",
                    options = listOf("ಪೆಟ್ರೋಲ್", "ಸಿಂಪಡಿತ ನೈಸರ್ಗಿಕ ಅನಿಲ", "ಡೀಸೆಲ್", "ಕಲ್ಲಿದ್ದಲು"),
                    correctAnswer = "ಸಿಂಪಡಿತ ನೈಸರ್ಗಿಕ ಅನಿಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಸಿಂಪಡಿತ ನೈಸರ್ಗಿಕ ಅನಿಲ."
                ),
                QuestionModel(
                    id = "tet_nr_q66",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "66) ಸ್ವಾಭಾವಿಕ ಸಂಪನ್ಮೂಲಗಳಿಗೆ ಉದಾಹರಣೆಗಳು .............",
                    options = listOf(
                        "ಗಾಳಿ ಮತ್ತು ವಾತಾವರಣ",
                        "ಸಸ್ಯಗಳು ಮತ್ತು ಪ್ರಾಣಿಗಳು",
                        "ಪಕ್ಷಿಗಳು ಮತ್ತು ಪಳಿಯುಳಿಕೆ ಇಂಧನಗಳು",
                        "ಮೇಲಿನ ಎಲ್ಲವೂ"
                    ),
                    correctAnswer = "ಮೇಲಿನ ಎಲ್ಲವೂ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಮೇಲಿನ ಎಲ್ಲವೂ."
                ),
                QuestionModel(
                    id = "tet_nr_q67",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "67) ಕೆಳಗಿನ ಯಾವುದು ನವೀಕರಿಸಲಾಗದ ಸಂಪನ್ಮೂಲವಾಗಿದೆ.",
                    options = listOf("ಸೌರ ಶಕ್ತಿ", "ನೈಸರ್ಗಿಕ ಅನಿಲ", "ಪವನ ಶಕ್ತಿ", "ಯಾವುದು ಅಲ್ಲ"),
                    correctAnswer = "ನೈಸರ್ಗಿಕ ಅನಿಲ",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ನೈಸರ್ಗಿಕ ಅನಿಲ."
                ),
                QuestionModel(
                    id = "tet_nr_q68",
                    stdId = 13,
                    subjectId = "general_science",
                    unitId = 7,
                    type = "MCQ",
                    questionText = "68) ಶಕ್ತಿಯ ಅಂತರಾಷ್ಟ್ರೀಯ ಮೂಲಮಾನ ಯಾವುದು?",
                    options = listOf("ಕ್ಯಾಲೋರಿ", "ಜೌಲ್", "ವ್ಯಾಟ್", "ನ್ಯೂಟನ್"),
                    correctAnswer = "ಜೌಲ್",
                    explanation = "ಸರಿಯಾದ ಉತ್ತರ: ಜೌಲ್."
                )
            ) + TetNaturalResourcesExtraQuestions.questions
        }
}
