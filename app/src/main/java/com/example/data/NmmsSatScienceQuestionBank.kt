package com.example.data

/**
 * NMMS SAT (Science) Comprehensive Question Bank for Standard 12.
 * Covering Class 7 & 8 Science curriculum strictly in Kannada.
 * Total questions: 120 across 6 units.
 * Omit all picture-based questions; all answers mathematically & scientifically verified.
 */
object NmmsSatScienceQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(
            id = 1,
            name = "ಭೌತಶಾಸ್ತ್ರ (Physics)",
            totalQuestions = 40,
            difficulty = "Medium"
        ),
        UnitTemplate(
            id = 2,
            name = "ರಸಾಯನಶಾಸ್ತ್ರ (Chemistry)",
            totalQuestions = 40,
            difficulty = "Medium"
        ),
        UnitTemplate(
            id = 3,
            name = "ಜೀವಶಾಸ್ತ್ರ (Biology)",
            totalQuestions = 40,
            difficulty = "Medium"
        ),
        UnitTemplate(
            id = 4,
            name = "ಘಟಕ 4: NMMS-2025 ವಿಜ್ಞಾನ ಪ್ರಶ್ನೆಪತ್ರಿಕೆ (NMMS-2025 Paper 2 Science)",
            totalQuestions = 30,
            difficulty = "Medium"
        ),
        UnitTemplate(
            id = 5,
            name = "ಘಟಕ 5: NMMS-2024 ವಿಜ್ಞಾನ ಪ್ರಶ್ನೆಪತ್ರಿಕೆ (NMMS-2024 Paper 2 Science)",
            totalQuestions = 35,
            difficulty = "Medium"
        ),
        UnitTemplate(
            id = 6,
            name = "ಘಟಕ 6: NMMS-2023 ಅಧಿಕೃತ ವಿಜ್ಞಾನ ಪ್ರಶ್ನೆಪತ್ರಿಕೆ (NMMS-2023 Paper 2 Science Solved)",
            totalQuestions = 25,
            difficulty = "Medium"
        )
    )

    val questions: List<QuestionModel> = listOf(
        // ========================================================
        // ಘಟಕ 1: ಬಲ, ಒತ್ತಡ, ಘರ್ಷಣೆ ಮತ್ತು ಚಲನೆ (Force, Pressure, Friction & Motion)
        // ========================================================
        QuestionModel(
            id = "nmms_sat_sci_u1_q1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಯಾವುದೇ ವಸ್ತುವಿನ ಮೇಲೆ ಪ್ರಯೋಗಿಸುವ ತಳ್ಳುವಿಕೆ ಅಥವಾ ಎಳೆಯುವಿಕೆಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಬಲ (Force)", "ಒತ್ತಡ (Pressure)", "ಕಾರ್ಯ (Work)", "ಶಕ್ತಿ (Energy)"),
            correctAnswer = "ಬಲ (Force)",
            explanation = "ವಸ್ತುವಿನ ಮೇಲೆ ಉಂಟಾಗುವ ತಳ್ಳುವಿಕೆ ಅಥವಾ ಎಳೆಯುವಿಕೆಯ ಪರಸ್ಪರ ಕ್ರಿಯೆಯನ್ನು ಬಲ ಎನ್ನುತ್ತಾರೆ. ಬಲದ SI ಏಕಮಾನ ನ್ಯೂಟನ್ (N)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q2",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು 'ಸಂಪರ್ಕರಹಿತ ಬಲ' (Non-contact force) ಕ್ಕೆ ಉದಾಹರಣೆಯಾಗಿದೆ?",
            options = listOf("ಗುರುತ್ವಾಕರ್ಷಣ ಬಲ", "ಸ್ನಾಯು ಬಲ", "ಘರ್ಷಣಾ ಬಲ", "ಯಾಂತ್ರಿಕ ಬಲ"),
            correctAnswer = "ಗುರುತ್ವಾಕರ್ಷಣ ಬಲ",
            explanation = "ವಸ್ತುಗಳ ನಡುವೆ ಭೌತಿಕ ಸಂಪರ್ಕವಿಲ್ಲದಿದ್ದರೂ ಕಾರ್ಯನಿರ್ವಹಿಸುವ ಬಲಗಳನ್ನು ಸಂಪರ್ಕರಹಿತ ಬಲಗಳು ಎನ್ನುತ್ತಾರೆ. ಉದಾ: ಗುರುತ್ವಾಕರ್ಷಣ ಬಲ, ಕಾಂತೀಯ ಬಲ ಮತ್ತು ಸ್ಥಿರವಿದ್ಯುತ್ ಬಲ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q3",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒತ್ತಡವನ್ನು ಲೆಕ್ಕಾಚಾರ ಮಾಡುವ ಸರಿಯಾದ ಗಣಿತೀಯ ಸೂತ್ರ ಯಾವುದು?",
            options = listOf("ಒತ್ತಡ = ಬಲ / ವಿಸ್ತೀರ್ಣ", "ಒತ್ತಡ = ಬಲ × ವಿಸ್ತೀರ್ಣ", "ಒತ್ತಡ = ವಿಸ್ತೀರ್ಣ / ಬಲ", "ಒತ್ತಡ = ಬಲ + ವಿಸ್ತೀರ್ಣ"),
            correctAnswer = "ಒತ್ತಡ = ಬಲ / ವಿಸ್ತೀರ್ಣ",
            explanation = "ಪ್ರಮಾಣ ವಿಸ್ತೀರ್ಣದ ಮೇಲೆ ಲಂಬವಾಗಿ ಪ್ರಯೋಗವಾಗುವ ಬಲವನ್ನು ಒತ್ತಡ ಎನ್ನುತ್ತಾರೆ (Pressure = Force / Area). ಇದರ SI ಏಕಮಾನ ಪ್ಯಾಸ್ಕಲ್ (Pascal, N/m²)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q4",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಭಾರ ಹೊರುವ ಕೂಲಿಗಳು ತಮ್ಮ ತಲೆಯ ಮೇಲೆ ಬಟ್ಟೆಯ ಸುರುಳಿಯನ್ನು ಇಟ್ಟುಕೊಳ್ಳಲು ವೈಜ್ಞಾನಿಕ ಕಾರಣವೇನು?",
            options = listOf("ಸಂಪರ್ಕ ವಿಸ್ತೀರ್ಣ ಹೆಚ್ಚಿಸಿ, ತಲೆಯ ಮೇಲಿನ ಒತ್ತಡ ಕಡಿಮೆ ಮಾಡಲು", "ಸಂಪರ್ಕ ವಿಸ್ತೀರ್ಣ ಕಡಿಮೆ ಮಾಡಿ ಒತ್ತಡ ಹೆಚ್ಚಿಸಲು", "ಭಾರವನ್ನು ಹೆಚ್ಚಿಸಲು", "ಸೌಂದರ್ಯಕ್ಕಾಗಿ"),
            correctAnswer = "ಸಂಪರ್ಕ ವಿಸ್ತೀರ್ಣ ಹೆಚ್ಚಿಸಿ, ತಲೆಯ ಮೇಲಿನ ಒತ್ತಡ ಕಡಿಮೆ ಮಾಡಲು",
            explanation = "ಬಟ್ಟೆಯ ಸುರುಳಿಯು ಹೊರೆ ಮತ್ತು ತಲೆಯ ನಡುವಿನ ಸಂಪರ್ಕ ವಿಸ್ತೀರ್ಣವನ್ನು ಹೆಚ್ಚಿಸುತ್ತದೆ. ವಿಸ್ತೀರ್ಣ ಹೆಚ್ಚಾದಂತೆ ಒತ್ತಡ (P = F/A) ಕಡಿಮೆಯಾಗುತ್ತದೆ, ಇದರಿಂದ ಭಾರ ಸುಲಭವಾಗಿ ಹೊರಬಹುದು."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q5",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ದ್ರವಗಳು ಪಾತ್ರೆಯ ತಳ ಮತ್ತು ಗೋಡೆಗಳ ಮೇಲೆ ಉಂಟುಮಾಡುವ ಒತ್ತಡವು ಯಾವುದರ ಮೇಲೆ ಅವಲಂಬಿತವಾಗಿದೆ?",
            options = listOf("ದ್ರವ ಸ್ತಂಭದ ಆಳ/ಎತ್ತರ", "ಪಾತ್ರೆಯ ಆಕಾರ", "ದ್ರವದ ಬಣ್ಣ", "ವಾತಾವರಣದ ಬೆಳಕು"),
            correctAnswer = "ದ್ರವ ಸ್ತಂಭದ ಆಳ/ಎತ್ತರ",
            explanation = "ದ್ರವಗಳು ಪಾತ್ರೆಯ ತಳ ಮತ್ತು ಪಾರ್ಶ್ವಗೋಡೆಗಳ ಮೇಲೆ ಸಮನಾಗಿ ಒತ್ತಡ ಹಾಕುತ್ತವೆ. ದ್ರವದ ಆಳ ಹೆಚ್ಚಾದಂತೆ ಒತ್ತಡವೂ ಹೆಚ್ಚಾಗುತ್ತದೆ (P = hρg)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q6",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಾತಾವರಣದ ಒತ್ತಡವನ್ನು ಅಳೆಯಲು ಬಳಸುವ ವೈಜ್ಞಾನಿಕ ಉಪಕರಣ ಯಾವುದು?",
            options = listOf("ಬಾರೋಮೀಟರ್ (Barometer)", "ಥರ್ಮಾಮೀಟರ್", "ಹೈಗ್ರೋಮೀಟರ್", "ಅನಿಮೋಮೀಟರ್"),
            correctAnswer = "ಬಾರೋಮೀಟರ್ (Barometer)",
            explanation = "ಭೂಮಿಯ ವಾತಾವರಣವು ಉಂಟುಮಾಡುವ ವಾಯುಭಾರವನ್ನು ಅಳೆಯಲು ಬಾರೋಮೀಟರ್ ಉಪಕರಣವನ್ನು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q7",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ಘರ್ಷಣೆಗಳ ಪರಿಮಾಣವನ್ನು ಏರಿಕೆ ಕ್ರಮದಲ್ಲಿ ಬರೆದಾಗ ಸರಿಯಾದ ಜೋಡಣೆ ಯಾವುದು?",
            options = listOf("ಉರುಳುವ ಘರ್ಷಣೆ < ಜಾರುವ ಘರ್ಷಣೆ < ಸ್ಥಾಯಿ ಘರ್ಷಣೆ", "ಸ್ಥಾಯಿ ಘರ್ಷಣೆ < ಜಾರುವ ಘರ್ಷಣೆ < ಉರುಳುವ ಘರ್ಷಣೆ", "ಜಾರುವ ಘರ್ಷಣೆ < ಉರುಳುವ ಘರ್ಷಣೆ < ಸ್ಥಾಯಿ ಘರ್ಷಣೆ", "ಉರುಳುವ ಘರ್ಷಣೆ < ಸ್ಥಾಯಿ ಘರ್ಷಣೆ < ಜಾರುವ ಘರ್ಷಣೆ"),
            correctAnswer = "ಉರುಳುವ ಘರ್ಷಣೆ < ಜಾರುವ ಘರ್ಷಣೆ < ಸ್ಥಾಯಿ ಘರ್ಷಣೆ",
            explanation = "ಸ್ಥಾಯಿ ಘರ್ಷಣೆಯು ಗರಿಷ್ಟವಾಗಿರುತ್ತದೆ, ನಂತರ ಜಾರುವ ಘರ್ಷಣೆ, ಮತ್ತು ಉರುಳುವ ಘರ್ಷಣೆಯು ಅತ್ಯಂತ ಕಡಿಮೆಯಾಗಿರುತ್ತದೆ (Rolling < Sliding < Static)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q8",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಯಂತ್ರಗಳಲ್ಲಿ ಚಲಿಸುವ ಭಾಗಗಳ ನಡುವೆ ಘರ್ಷಣೆಯನ್ನು ಕಡಿಮೆ ಮಾಡಲು ಬಳಸುವ ವಸ್ತುಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸ್ನೇಹಕಗಳು (Lubricants)", "ಉತ್ಪನ್ನಗಳು", "ಅವಾಹಕಗಳು", "ಉತ್ಪ್ರೇರಕಗಳು"),
            correctAnswer = "ಸ್ನೇಹಕಗಳು (Lubricants)",
            explanation = "ಮೇಲ್ಮೈಗಳ ನಡುವೆ ತೆಳುವಾದ ಪದರವನ್ನು ನಿರ್ಮಿಸಿ, ಕೃತಕವಾಗಿ ಘರ್ಷಣೆಯನ್ನು ಕಡಿಮೆ ಮಾಡಲು ಗ್ರೀಸ್, ತೈಲ ಮುಂತಾದ ಸ್ನೇಹಕಗಳನ್ನು (Lubricants) ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q9",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಾಹನಗಳಲ್ಲಿ ಚಕ್ರ ಮತ್ತು ಆಕ್ಸಲ್ ನಡುವೆ ಜಾರುವ ಘರ್ಷಣೆಯನ್ನು ಉರುಳುವ ಘರ್ಷಣೆಯನ್ನಾಗಿ ಪರಿವರ್ತಿಸಲು ಬಳಸುವ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಬಾಲ್ ಬೇರಿಂಗ್ (Ball bearing)", "ಬ್ರೇಕ್ ಪ್ಯಾಡ್", "ಕ್ಲಚ್", "ಗೇರ್ ಬಾಕ್ಸ್"),
            correctAnswer = "ಬಾಲ್ ಬೇರಿಂಗ್ (Ball bearing)",
            explanation = "ಬಾಲ್ ಬೇರಿಂಗ್‌ಗಳು ಜಾರುವ ಘರ್ಷಣೆಯನ್ನು ಉರುಳುವ ಘರ್ಷಣೆಯನ್ನಾಗಿ ಪರಿವರ್ತಿಸಿ ಶಕ್ತಿಯ ಅಪವ್ಯಯವನ್ನು ಗಣನೀಯವಾಗಿ ಕಡಿಮೆ ಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q10",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ದ್ರವ ಮತ್ತು ಅನಿಲಗಳಂತಹ ಪ್ರವಾಹಿಗಳಲ್ಲಿ ಚಲಿಸುವ ಕಾಯಗಳ ಮೇಲೆ ಉಂಟಾಗುವ ಘರ್ಷಣಾ ಬಲವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಡ್ರ್ಯಾಗ್ (Drag / ಪ್ರವಾಹಿ ಘರ್ಷಣೆ)", "ಸ್ಥಾಯಿ ಘರ್ಷಣೆ", "ಗುರುತ್ವ ಬಲ", "ಉತ್ಪ್ಲಾವಕತೆ"),
            correctAnswer = "ಡ್ರ್ಯಾಗ್ (Drag / ಪ್ರವಾಹಿ ಘರ್ಷಣೆ)",
            explanation = "ದ್ರವ ಅಥವಾ ಅನಿಲಗಳ ಮೂಲಕ ಚಲಿಸುವ ವಸ್ತುಗಳ ಮೇಲೆ ಉಂಟಾಗುವ ಘರ್ಷಣಾ ರೋಧವನ್ನು 'ಡ್ರ್ಯಾಗ್' (ಪ್ರವಾಹಿ ಘರ್ಷಣೆ) ಎನ್ನಲಾಗುತ್ತದೆ. ಇದನ್ನು ಕಡಿಮೆ ಮಾಡಲು ವಿಮಾನ ಮತ್ತು ಹಡಗುಗಳಿಗೆ ಸುವ್ಯವಸ್ಥಿತ ಆಕಾರ (streamlined shape) ನೀಡಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q11",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಂದು ಕಾಯವು 2 ಗಂಟೆಗಳಲ್ಲಿ 120 ಕಿ.ಮೀ ದೂರವನ್ನು ಕ್ರಮಿಸಿದರೆ, ಅದರ ಸರಾಸರಿ ಜವ (Speed) ಎಷ್ಟು?",
            options = listOf("60 ಕಿ.ಮೀ/ಗಂಟೆ", "120 ಕಿ.ಮೀ/ಗಂಟೆ", "240 ಕಿ.ಮೀ/ಗಂಟೆ", "30 ಕಿ.ಮೀ/ಗಂಟೆ"),
            correctAnswer = "60 ಕಿ.ಮೀ/ಗಂಟೆ",
            explanation = "ಜವ = ಕ್ರಮಿಸಿದ ಒಟ್ಟು ದೂರ / ತೆಗೆದುಕೊಂಡ ಕಾಲ = 120 km / 2 h = 60 km/h."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q12",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸರಳ ಲೋಲಕವು (Simple Pendulum) ಒಂದು ಪೂರ್ಣ ಆಂದೋಲನವನ್ನು ಪೂರ್ಣಗೊಳಿಸಲು ತೆಗೆದುಕೊಳ್ಳುವ ಸಮಯವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಅಲೆಯುವಿಕೆಯ ಅವಧಿ (Time Period)", "ಆವೃತ್ತಿ (Frequency)", "ವಿಸ್ತಾರ (Amplitude)", "ಜವ (Speed)"),
            correctAnswer = "ಅಲೆಯುವಿಕೆಯ ಅವಧಿ (Time Period)",
            explanation = "ಲೋಲಕವು ಒಂದು ಆಂದೋಲನವನ್ನು ಮುಗಿಸಲು ತೆಗೆದುಕೊಳ್ಳುವ ಸಮಯವನ್ನು ಅಲೆಯುವಿಕೆಯ ಅವಧಿ (ಆವರ್ತ ಕಾಲ - Time Period) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q13",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಾಹನಗಳು ಕ್ರಮಿಸಿದ ದೂರವನ್ನು ದಾಖಲಿಸಲು ಬಳಸುವ ಉಪಕರಣ ಯಾವುದು?",
            options = listOf("ಓಡೋಮೀಟರ್ (Odometer)", "ಸ್ಪೀಡೋಮೀಟರ್", "ಟ್ಯಾಕೋಮೀಟರ್", "ಆಲ್ಟಿಮೀಟರ್"),
            correctAnswer = "ಓಡೋಮೀಟರ್ (Odometer)",
            explanation = "ವಾಹನ ಕ್ರಮಿಸಿದ ಒಟ್ಟು ದೂರವನ್ನು ಕಿಲೋಮೀಟರ್‌ಗಳಲ್ಲಿ ಅಳೆಯಲು ಓಡೋಮೀಟರ್ ಬಳಸಲಾಗುತ್ತದೆ; ವೇಗವನ್ನು ಅಳೆಯಲು ಸ್ಪೀಡೋಮೀಟರ್ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q14",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಂದು ಕಾಯದ ಮೇಲೆ ವಿರುದ್ಧ ದಿಕ್ಕುಗಳಲ್ಲಿ ಸಮಾನ ಪರಿಮಾಣದ ಎರಡು ಬಲಗಳು ಪ್ರಯೋಗವಾದಾಗ, ಆ ಕಾಯದ ಮೇಲಿನ ನಿವ್ವಳ ಬಲ (Net Force) ಎಷ್ಟು?",
            options = listOf("ಶೂನ್ಯ (0)", "ಎರಡು ಬಲಗಳ ಮೊತ್ತ", "ಎರಡು ಬಲಗಳ ಗುಣಲಬ್ಧ", "ಅನಂತ"),
            correctAnswer = "ಶೂನ್ಯ (0)",
            explanation = "ವಿರುದ್ಧ ದಿಕ್ಕಿನಲ್ಲಿ ಪ್ರಯೋಗವಾಗುವ ಸಮಾನ ಬಲಗಳು ಪರಸ್ಪರ ರದ್ದಾಗುತ್ತವೆ (F1 - F2 = 0), ಆದ್ದರಿಂದ ನಿವ್ವಳ ಬಲ ಶೂನ್ಯವಾಗಿರುತ್ತದೆ ಮತ್ತು ಕಾಯ ಚಲಿಸುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q15",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಣ ಕೂದಲನ್ನು ಪ್ಲಾಸ್ಟಿಕ್ ಬಾಚಣಿಕೆಯಿಂದ ಬಾಚಿ, ಕಾಗದದ ಸಣ್ಣ ತುಂಡುಗಳ ಬಳಿ ತಂದಾಗ ಅವು ಆಕರ್ಷಿತವಾಗಲು ಕಾರಣವಾದ ಬಲ ಯಾವುದು?",
            options = listOf("ಸ್ಥಿರವಿದ್ಯುತ್ ಬಲ (Electrostatic force)", "ಗುರುತ್ವಾಕರ್ಷಣ ಬಲ", "ಕಾಂತೀಯ ಬಲ", "ಘರ್ಷಣಾ ಬಲ"),
            correctAnswer = "ಸ್ಥಿರವಿದ್ಯುತ್ ಬಲ (Electrostatic force)",
            explanation = "ಬಾಚಣಿಕೆಯು ಕೂದಲಿನೊಂದಿಗೆ ಉಜ್ಜಿದಾಗ ಆವೇಶಭರಿತವಾಗುತ್ತದೆ. ಈ ವಿದ್ಯುದಾವೇಶಿತ ವಸ್ತುವು ಕಾಗದದ ತುಂಡುಗಳನ್ನು ಆಕರ್ಷಿಸಲು ಸ್ಥಿರವಿದ್ಯುತ್ ಬಲ ಕಾರಣ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q16",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಂದು ಕಾಯದ ತೂಕವು (Weight) ಭೂಮಿಯ ಮೇಲ್ಮೈಯಲ್ಲಿ ಎಲ್ಲಿ ಗರಿಷ್ಟವಾಗಿರುತ್ತದೆ?",
            options = listOf("ಧ್ರುವಗಳಲ್ಲಿ (Poles)", "ವಿಷುವದ್ವೃತ್ತದಲ್ಲಿ (Equator)", "ಭೂಮಿಯ ಕೇಂದ್ರದಲ್ಲಿ", "ಎಲ್ಲಾ ಕಡೆ ಸಮಾನವಾಗಿರುತ್ತದೆ"),
            correctAnswer = "ಧ್ರುವಗಳಲ್ಲಿ (Poles)",
            explanation = "ಭೂಮಿಯು ಧ್ರುವಗಳಲ್ಲಿ ಸ್ವಲ್ಪ ಚಪ್ಪಟೆಯಾಗಿರುವುದರಿಂದ ಭೂಕೇಂದ್ರಕ್ಕೆ ಹತ್ತಿರವಾಗಿದೆ. ಆದ್ದರಿಂದ ಧ್ರುವಗಳಲ್ಲಿ ಗುರುತ್ವ ವೇಗೋತ್ಕರ್ಷ (g) ಗರಿಷ್ಟವಾಗಿದ್ದು, ವಸ್ತುವಿನ ತೂಕ ಗರಿಷ್ಟವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q17",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕ್ರೀಡಾಪಟುಗಳು ಮತ್ತು ಓಟಗಾರರು ತಮ್ಮ ಬೂಟುಗಳ ತಳಭಾಗದಲ್ಲಿ ಮುಳ್ಳುಗಳನ್ನು (Spikes) ಏಕೆ ಹೊಂದಿರುತ್ತಾರೆ?",
            options = listOf("ನೆಲದೊಂದಿಗೆ ಘರ್ಷಣೆಯನ್ನು ಹೆಚ್ಚಿಸಿ ಜಾರದಂತೆ ಇರಲು", "ಘರ್ಷಣೆಯನ್ನು ಕಡಿಮೆ ಮಾಡಲು", "ಬೂಟಿನ ತೂಕ ಹೆಚ್ಚಿಸಲು", "ಧ್ವನಿಯನ್ನು ಉಂಟುಮಾಡಲು"),
            correctAnswer = "ನೆಲದೊಂದಿಗೆ ಘರ್ಷಣೆಯನ್ನು ಹೆಚ್ಚಿಸಿ ಜಾರದಂತೆ ಇರಲು",
            explanation = "ಸ್ಪೈಕ್‌ಗಳು ನೆಲದ ಮೇಲ್ಮೈಯೊಂದಿಗೆ ಸಂಪರ್ಕವನ್ನು ಬಲಪಡಿಸಿ ಘರ್ಷಣೆಯನ್ನು ಹೆಚ್ಚಿಸುತ್ತವೆ, ಇದರಿಂದ ಆಟಗಾರರು ಜಾರಿ ಬೀಳದೆ ವೇಗವಾಗಿ ಓಡಬಹುದು."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q18",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಾತಾವರಣದ ಗಾಳಿಯ ಒತ್ತಡವು ಎತ್ತರಕ್ಕೆ ಹೋದಂತೆ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಕಡಿಮೆಯಾಗುತ್ತದೆ", "ಹೆಚ್ಚಾಗುತ್ತದೆ", "ಬದಲಾಗುವುದಿಲ್ಲ", "ಮೊದಲು ಹೆಚ್ಚಾಗಿ ನಂತರ ಕಡಿಮೆಯಾಗುತ್ತದೆ"),
            correctAnswer = "ಕಡಿಮೆಯಾಗುತ್ತದೆ",
            explanation = "ಸಮುದ್ರ ಮಟ್ಟದಿಂದ ಎತ್ತರಕ್ಕೆ ಹೋದಂತೆ ಗಾಳಿಯ ಸಾಂದ್ರತೆ ಮತ್ತು ವಾಯುಸ್ತಂಭದ ಎತ್ತರ ಕಡಿಮೆಯಾಗುವುದರಿಂದ ವಾತಾವರಣದ ಒತ್ತಡ ಕ್ರಮೇಣ ಕಡಿಮೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q19",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಚಲಿಸುತ್ತಿರುವ ವಸ್ತುವಿನ ಮೇಲೆ ಚಲನೆಯ ದಿಕ್ಕಿಗೆ ವಿರುದ್ಧವಾಗಿ ಬಲ ಪ್ರಯೋಗಿಸಿದರೆ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ವಸ್ತುವಿನ ವೇಗ ಕಡಿಮೆಯಾಗುತ್ತದೆ ಅಥವಾ ನಿಲ್ಲುತ್ತದೆ", "ವಸ್ತುವಿನ ವೇಗ ಹೆಚ್ಚಾಗುತ್ತದೆ", "ವಸ್ತುವಿನ ವೇಗ ಬದಲಾಗುವುದಿಲ್ಲ", "ವಸ್ತುವಿನ ದ್ರವ್ಯರಾಶಿ ಹೆಚ್ಚಾಗುತ್ತದೆ"),
            correctAnswer = "ವಸ್ತುವಿನ ವೇಗ ಕಡಿಮೆಯಾಗುತ್ತದೆ ಅಥವಾ ನಿಲ್ಲುತ್ತದೆ",
            explanation = "ಚಲನೆಯ ವಿರುದ್ಧ ದಿಕ್ಕಿನಲ್ಲಿ ಪ್ರಯೋಗಿಸುವ ಬಲವು ಕಾಯದ ವೇಗೋತ್ಕರ್ಷಕ್ಕೆ ತಡೆಯೊಡ್ಡಿ ವೇಗವನ್ನು ಕಡಿಮೆ ಮಾಡುತ್ತದೆ ಅಥವಾ ನಿಲ್ಲಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u1_q20",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಒಂದು ವಸ್ತುವಿನ ದ್ರವ್ಯರಾಶಿ (Mass) ಮತ್ತು ತೂಕ (Weight) ಕುರಿತಾದ ಯಾವ ಹೇಳಿಕೆ ಸರಿಯಾಗಿದೆ?",
            options = listOf("ದ್ರವ್ಯರಾಶಿಯು ಸ್ಥಿರವಾಗಿರುತ್ತದೆ, ಆದರೆ ತೂಕವು ಸ್ಥಳದಿಂದ ಸ್ಥಳಕ್ಕೆ ಬದಲಾಗುತ್ತದೆ", "ತೂಕವು ಸ್ಥಿರವಾಗಿರುತ್ತದೆ, ಆದರೆ ದ್ರವ್ಯರಾಶಿ ಬದಲಾಗುತ್ತದೆ", "ಎರಡೂ ಸ್ಥಳದಿಂದ ಸ್ಥಳಕ್ಕೆ ಬದಲಾಗುತ್ತವೆ", "ಎರಡಕ್ಕೂ ದಿಕ್ಕು ಇರುವುದಿಲ್ಲ"),
            correctAnswer = "ದ್ರವ್ಯರಾಶಿಯು ಸ್ಥಿರವಾಗಿರುತ್ತದೆ, ಆದರೆ ತೂಕವು ಸ್ಥಳದಿಂದ ಸ್ಥಳಕ್ಕೆ ಬದಲಾಗುತ್ತದೆ",
            explanation = "ದ್ರವ್ಯರಾಶಿ (m) ವಸ್ತುವಿನಲ್ಲಿರುವ ದ್ರವ್ಯದ ಪರಿಮಾಣವಾಗಿದ್ದು ಸ್ಥಿರವಾಗಿರುತ್ತದೆ. ತೂಕ (W = mg) ಗುರುತ್ವಾಕರ್ಷಣೆಗೆ ಅನುಗುಣವಾಗಿ ಬದಲಾಗುತ್ತದೆ."
        ),
        // ========================================================
        // ಘಟಕ 2: ಬೆಳಕು, ಧ್ವನಿ, ವಿದ್ಯುತ್ ಮತ್ತು ಉಷ್ಣ (Light, Sound, Electricity & Heat)
        // ========================================================
        QuestionModel(
            id = "nmms_sat_sci_u2_q1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬೆಳಕಿನ ಪ್ರತಿಫಲನದ ನಿಯಮದ ಪ್ರಕಾರ, ಪತನ ಕೋನ (i) ಮತ್ತು ಪ್ರತಿಫಲನ ಕೋನ (r) ನಡುವಿನ ಸಂಬಂಧವೇನು?",
            options = listOf("ಪತನ ಕೋನವು ಪ್ರತಿಫಲನ ಕೋನಕ್ಕೆ ಸಮನಾಗಿರುತ್ತದೆ (∠i = ∠r)", "ಪತನ ಕೋನವು ಪ್ರತಿಫಲನ ಕೋನಕ್ಕಿಂತ ಹೆಚ್ಚಾಗಿರುತ್ತದೆ", "ಪತನ ಕೋನವು ಪ್ರತಿಫಲನ ಕೋನಕ್ಕಿಂತ ಕಡಿಮೆಯಾಗಿರುತ್ತದೆ", "ಅವುಗಳ ನಡುವೆ ಯಾವುದೇ ಸಂಬಂಧವಿಲ್ಲ"),
            correctAnswer = "ಪತನ ಕೋನವು ಪ್ರತಿಫಲನ ಕೋನಕ್ಕೆ ಸಮನಾಗಿರುತ್ತದೆ (∠i = ∠r)",
            explanation = "ಪ್ರತಿಫಲನದ ಮೊದಲ ನಿಯಮದ ಪ್ರಕಾರ ಪತನ ಕೋನವು ಯಾವಾಗಲೂ ಪ್ರತಿಫಲನ ಕೋನಕ್ಕೆ ಸಮನಾಗಿರುತ್ತದೆ (∠i = ∠r)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q2",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸಮತಲ ದರ್ಪಣದಲ್ಲಿ ಉಂಟಾಗುವ ಬಿಂಬದ ಮುಖ್ಯ ಲಕ್ಷಣ ಯಾವುದು?",
            options = listOf("ಮಿಥ್ಯ, ನೇರ ಮತ್ತು ವಸ್ತುವಿನಷ್ಟೇ ಗಾತ್ರ", "ಸತ್ಯ, ತಲೆಕೆಳಗಾದ ಮತ್ತು ದೊಡ್ಡದಾದ", "ಮಿಥ್ಯ, ತಲೆಕೆಳಗಾದ ಮತ್ತು ಚಿಕ್ಕದಾದ", "ಸತ್ಯ, ನೇರ ಮತ್ತು ಹಿಗ್ಗಿದ"),
            correctAnswer = "ಮಿಥ್ಯ, ನೇರ ಮತ್ತು ವಸ್ತುವಿನಷ್ಟೇ ಗಾತ್ರ",
            explanation = "ಸಮತಲ ದರ್ಪಣದಲ್ಲಿ ಉಂಟಾಗುವ ಬಿಂಬವು ಮಿಥ್ಯ (ತೆರೆಯ ಮೇಲೆ ಹಿಡಿಯಲಾಗದು), ನೇರ, ವಸ್ತುವಿನಷ್ಟೇ ಸಮಾನ ಗಾತ್ರ ಮತ್ತು ಪಾರ್ಶ್ವಪಲ್ಲಟಗೊಂಡಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q3",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮಾನವನ ಕಣ್ಣಿನಲ್ಲಿ ಬೆಳಕಿಗೆ ಸಂವೇದನಾಶೀಲವಾಗಿರುವ ಪರದೆ ಯಾವುದು?",
            options = listOf("ರೆಟಿನಾ (ಅಕ್ಷಿಪಟ)", "ಕಾರ್ನಿಯಾ", "ಐರಿಸ್", "ಪ್ಯೂಪಿಲ್ (ಕಣ್ಣುಗುಡ್ಡೆ)"),
            correctAnswer = "ರೆಟಿನಾ (ಅಕ್ಷಿಪಟ)",
            explanation = "ರೆಟಿನಾವು ಕಣ್ಣಿನ ಹಿಂಭಾಗದಲ್ಲಿರುವ ಬೆಳಕಿನ ಸಂವೇದನಾಶೀಲ ಪರದೆಯಾಗಿದ್ದು, ಇಲ್ಲಿ ರಾಡ್ಸ್ ಮತ್ತು ಕೋನ್ಸ್ ಕೋಶಗಳು ಬಿಂಬವನ್ನು ಗ್ರಹಿಸಿ ದೃಕ್ ನರಕ್ಕೆ ಕಳುಹಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q4",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕಣ್ಣಿನ ರೆಟಿನಾದಲ್ಲಿ ಮಂದ ಬೆಳಕನ್ನು ಗ್ರಹಿಸಲು ಸಹಕಾರಿಯಾದ ಕೋಶಗಳು ಯಾವುವು?",
            options = listOf("ದಂಡ ಕೋಶಗಳು (Rods)", "ಶಂಕು ಕೋಶಗಳು (Cones)", "ಐರಿಸ್ ಕೋಶಗಳು", "ಸ್ನಾಯು ಕೋಶಗಳು"),
            correctAnswer = "ದಂಡ ಕೋಶಗಳು (Rods)",
            explanation = "ದಂಡ ಕೋಶಗಳು (Rods) ಮಂದ ಬೆಳಕಿಗೆ ಸಂವೇದನಾಶೀಲವಾಗಿರುತ್ತವೆ, ಆದರೆ ಶಂಕು ಕೋಶಗಳು (Cones) ಪ್ರಖರ ಬೆಳಕು ಮತ್ತು ಬಣ್ಣಗಳನ್ನು ಗ್ರಹಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q5",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ದೃಷ್ಟಿ ದೋಷವುಳ್ಳ ವ್ಯಕ್ತಿಗಳು ಓದಲು ಮತ್ತು ಬರೆಯಲು ಬಳಸುವ ಸ್ಪರ್ಶ ಆಧಾರಿತ ಲಿಪಿ ಯಾವುದು?",
            options = listOf("ಬ್ರೈಲ್ ಲಿಪಿ (Braille)", "ದೇವನಾಗರಿ ಲಿಪಿ", "ಲ್ಯಾಟಿನ್ ಲಿಪಿ", "ರೋಮನ್ ಲಿಪಿ"),
            correctAnswer = "ಬ್ರೈಲ್ ಲಿಪಿ (Braille)",
            explanation = "ಲೂಯಿಸ್ ಬ್ರೈಲ್ ಅವರು 1821 ರಲ್ಲಿ ಅಂಧರಿಗಾಗಿ 6 ಉಬ್ಬಿದ ಚುಕ್ಕೆಗಳ ಸಂಯೋಜನೆಯಿಂದ ಕೂಡಿದ ಬ್ರೈಲ್ ಲಿಪಿಯನ್ನು ಅಭಿವೃದ್ಧಿಪಡಿಸಿದರು."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q6",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಧ್ವನಿಯು ಯಾವುದರಲ್ಲಿ ಅತ್ಯಂತ ವೇಗವಾಗಿ ಪ್ರಸಾರವಾಗುತ್ತದೆ?",
            options = listOf("ಘನ ವಸ್ತುಗಳಲ್ಲಿ (ಉದಾ: ಉಕ್ಕು)", "ದ್ರವಗಳಲ್ಲಿ (ಉದಾ: ನೀರು)", "ಅನಿಲಗಳಲ್ಲಿ (ಉದಾ: ಗಾಳಿ)", "ನಿರ್ವಾತದಲ್ಲಿ"),
            correctAnswer = "ಘನ ವಸ್ತುಗಳಲ್ಲಿ (ಉದಾ: ಉಕ್ಕು)",
            explanation = "ಧ್ವನಿಯು ಕಣಗಳ ಕಂಪನದಿಂದ ಪ್ರಸಾರವಾಗುತ್ತದೆ. ಕಣಗಳು ಹತ್ತಿರವಿರುವ ಘನಗಳಲ್ಲಿ ಧ್ವನಿಯ ವೇಗ ಗರಿಷ್ಟವಾಗಿರುತ್ತದೆ (ಘನ > ದ್ರವ > ಅನಿಲ). ನಿರ್ವಾತದಲ್ಲಿ ಧ್ವನಿ ಪ್ರಸಾರವಾಗುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q7",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಧ್ವನಿಯ ತೀಕ್ಷ್ಣತೆ ಅಥವಾ ಪಿಚ್ (Pitch) ಯಾವುದರ ಮೇಲೆ ಅವಲಂಬಿತವಾಗಿದೆ?",
            options = listOf("ಆವೃತ್ತಿ (Frequency)", "ಕಂಪನ ವಿಸ್ತಾರ (Amplitude)", "ವೇಗ (Speed)", "ತರಂಗಾಂತರ"),
            correctAnswer = "ಆವೃತ್ತಿ (Frequency)",
            explanation = "ಆವೃತ್ತಿಯು ಹೆಚ್ಚಾದಷ್ಟೂ ಧ್ವನಿಯ ಪಿಚ್ (ತೀಕ್ಷ್ಣತೆ) ಹೆಚ್ಚಾಗುತ್ತದೆ. ಗಂಡಸರ ಧ್ವನಿಗಿಂತ ಹೆಣ್ಣುಮಕ್ಕಳ ಧ್ವನಿಯ ಆವೃತ್ತಿ ಹೆಚ್ಚಾಗಿರುವುದರಿಂದ ತೀಕ್ಷ್ಣತೆ ಹೆಚ್ಚಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q8",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮಾನವನ ಕಿವಿಗೆ ಕೇಳಿಸಬಹುದಾದ ಶ್ರವ್ಯ ಧ್ವನಿಯ ಆವೃತ್ತಿ ವ್ಯಾಪ್ತಿ (Audible range) ಎಷ್ಟು?",
            options = listOf("20 Hz ನಿಂದ 20,000 Hz ವರೆಗೆ", "20 Hz ಗಿಂತ ಕಡಿಮೆ", "20,000 Hz ಗಿಂತ ಹೆಚ್ಚು", "2 Hz ನಿಂದ 200 Hz ವರೆಗೆ"),
            correctAnswer = "20 Hz ನಿಂದ 20,000 Hz ವರೆಗೆ",
            explanation = "ಮಾನವನ ಕಿವಿಗಳು 20 Hz ನಿಂದ 20,000 Hz (20 kHz) ನಡುವಿನ ಆವೃತ್ತಿಯ ಧ್ವನಿಯನ್ನು ಮಾತ್ರ ಗ್ರಹಿಸಬಲ್ಲವು."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q9",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಲೇಪನ (Electroplating) ಪ್ರಕ್ರಿಯೆಯು ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ಯಾವ ಪರಿಣಾಮವನ್ನು ಆಧರಿಸಿದೆ?",
            options = listOf("ರಾಸಾಯನಿಕ ಪರಿಣಾಮ", "ಕಾಂತೀಯ ಪರಿಣಾಮ", "ಉಷ್ಣ ಪರಿಣಾಮ", "ಯಾಂತ್ರಿಕ ಪರಿಣಾಮ"),
            correctAnswer = "ರಾಸಾಯನಿಕ ಪರಿಣಾಮ",
            explanation = "ವಿದ್ಯುತ್ ವಿಶ್ಲೇಷಣೆಯ ಮೂಲಕ ಒಂದು ಲೋಹದ ಮೇಲೆ ಮತ್ತೊಂದು ಅಪೇಕ್ಷಿತ ಲೋಹದ ತೆಳುವಾದ ಪದರವನ್ನು ಲೇಪಿಸುವುದು ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ರಾಸಾಯನಿಕ ಪರಿಣಾಮವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q10",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿದ್ಯುದ್ವಾಹಕ ದ್ರಾವಣದ ಮೂಲಕ ವಿದ್ಯುತ್ ಪ್ರವಹಿಸಿದಾಗ ನೀರಿನ ಅಣುಗಳು ವಿಭಜನೆಗೊಂಡು ಆನೋಡ್ ಬಳಿ ಬಿಡುಗಡೆಯಾಗುವ ಅನಿಲ ಯಾವುದು?",
            options = listOf("ಆಕ್ಸಿಜನ್ (O₂)", "ಹೈಡ್ರೋಜನ್ (H₂)", "ಸಾರಜನಕ (N₂)", "ಕ್ಲೋರಿನ್ (Cl₂)"),
            correctAnswer = "ಆಕ್ಸಿಜನ್ (O₂)",
            explanation = "ನೀರಿನ ವಿದ್ಯುದ್ವಿಭಜನೆಯಲ್ಲಿ ಧನಾಗ್ರವಾದ ಆನೋಡ್ ಬಳಿ ಆಕ್ಸಿಜನ್ ಅನಿಲ ಮತ್ತು ಋಣಾಗ್ರವಾದ ಕ್ಯಾಥೋಡ್ ಬಳಿ ಹೈಡ್ರೋಜನ್ ಅನಿಲ ಬಿಡುಗಡೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q11",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಉಪಕರಣಗಳಲ್ಲಿ ಬಳಸುವ LED ಯ ಪೂರ್ಣ ರೂಪವೇನು?",
            options = listOf("Light Emitting Diode", "Low Energy Device", "Light Energy Detector", "Laser Emitting Diode"),
            correctAnswer = "Light Emitting Diode",
            explanation = "LED ಎಂದರೆ Light Emitting Diode (ಬೆಳಕು ಹೊರಸೂಸುವ ಡಯೋಡ್). ಇದು ಅಲ್ಪ ವಿದ್ಯುತ್ ಪ್ರವಾಹದಲ್ಲೂ ಪ್ರಕಾಶಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q12",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಉಷ್ಣ ಪ್ರಸಾರಕ್ಕೆ ಮಾಧ್ಯಮದ ಅವಶ್ಯಕತೆಯೇ ಇಲ್ಲದ ಉಷ್ಣ ವರ್ಗಾವಣೆಯ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ವಿಕಿರಣ (Radiation)", "ವಹನ (Conduction)", "ಸಂವಹನ (Convection)", "ಅಭಿಸರಣೆ"),
            correctAnswer = "ವಿಕಿರಣ (Radiation)",
            explanation = "ಸೂರ್ಯನಿಂದ ಭೂಮಿಗೆ ಉಷ್ಣವು ನಿರ್ವಾತದ ಮೂಲಕ ವಿಕಿರಣ (Radiation) ರೂಪದಲ್ಲಿ ತಲುಪುತ್ತದೆ. ಇದಕ್ಕೆ ಯಾವುದೇ ಭೌತಿಕ ಮಾಧ್ಯಮದ ಅಗತ್ಯವಿಲ್ಲ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q13",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮಾನವನ ದೇಹದ ಸಾಮಾನ್ಯ ತಾಪಮಾನವು ಸೆಲ್ಸಿಯಸ್ ಮಾಪಕದಲ್ಲಿ ಎಷ್ಟು?",
            options = listOf("37°C", "98.6°C", "35°C", "42°C"),
            correctAnswer = "37°C",
            explanation = "ಆರೋಗ್ಯವಂತ ಮಾನವನ ಸಾಮಾನ್ಯ ಶರೀರ ತಾಪಮಾನವು 37°C ಅಥವಾ ಫ್ಯಾರನ್‌ಹೀಟ್ ಮಾಪಕದಲ್ಲಿ 98.6°F ಆಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q14",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ದಂತವೈದ್ಯರು ರೋಗಿಯ ಹಲ್ಲುಗಳನ್ನು ದೊಡ್ಡದಾಗಿ ವೀಕ್ಷಿಸಲು ಬಳಸುವ ದರ್ಪಣ ಯಾವುದು?",
            options = listOf("ಪೀನ ದರ್ಪಣ (ಕಾನ್ಕೇವ್ ದರ್ಪಣ)", "ನಿಮ್ನ ದರ್ಪಣ (ಕಾನ್ವೆಕ್ಸ್ ದರ್ಪಣ)", "ಸಮತಲ ದರ್ಪಣ", "ಸ್ಥೂಲ ದರ್ಪಣ"),
            correctAnswer = "ಪೀನ ದರ್ಪಣ (ಕಾನ್ಕೇವ್ ದರ್ಪಣ)",
            explanation = "ಕಾನ್ಕೇವ್ (ನಿಮ್ನ/ಒಳಬಾಗಿದ) ದರ್ಪಣವು ವಸ್ತುವನ್ನು ಸಂಗಮ ಬಿಂದುವಿನೊಳಗೆ ಇಟ್ಟಾಗ ನೇರವಾದ ಮತ್ತು ದೊಡ್ಡದಾದ (ಹಿಗ್ಗಿದ) ಮಿಥ್ಯ ಬಿಂಬವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q15",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ವಾಹನಗಳ ಹಿನ್ನೋಟ ದರ್ಪಣವಾಗಿ (Rear view mirror) ಬಳಸುವ ದರ್ಪಣ ಯಾವುದು?",
            options = listOf("ಕಾನ್ವೆಕ್ಸ್ ದರ್ಪಣ (ಪೀನ ದರ್ಪಣ)", "ಕಾನ್ಕೇವ್ ದರ್ಪಣ", "ಸಮತಲ ದರ್ಪಣ", "ದ್ವಿ-ನಿಮ್ನ ದರ್ಪಣ"),
            correctAnswer = "ಕಾನ್ವೆಕ್ಸ್ ದರ್ಪಣ (ಪೀನ ದರ್ಪಣ)",
            explanation = "ಕಾನ್ವೆಕ್ಸ್ ದರ್ಪಣವು ಯಾವಾಗಲೂ ನೇರವಾದ, ಚಿಕ್ಕದಾದ ಬಿಂಬಗಳನ್ನು ನೀಡುವುದರಿಂದ ಚಾಲಕನಿಗೆ ವಿಶಾಲವಾದ ಕ್ಷೇತ್ರ ನೋಟವನ್ನು (wider field of view) ಒದಗಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q16",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬಿಳಿ ಬೆಳಕು ಪ್ರಿಸ್ಮ್ ಮೂಲಕ ಹಾದುಹೋದಾಗ ಏಳು ಬಣ್ಣಗಳಾಗಿ ವಿಭಜನೆಗೊಳ್ಳುವ ವಿದ್ಯಮಾನವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಬೆಳಕಿನ ವರ್ಣವಿಭಜನೆ (Dispersion)", "ಬೆಳಕಿನ ಪ್ರತಿಫಲನ", "ಬೆಳಕಿನ ವಕ್ರೀಭವನ", "ಬೆಳಕಿನ ಧ್ರುವೀಕರಣ"),
            correctAnswer = "ಬೆಳಕಿನ ವರ್ಣವಿಭಜನೆ (Dispersion)",
            explanation = "ಬಿಳಿ ಬೆಳಕು ಗಾಜಿನ ಪ್ರಿಸ್ಮ್ ಮೂಲಕ ಹಾದುಹೋದಾಗ ವಿವಿಧ ತರಂಗಾಂತರಗಳ ಆಧಾರದಲ್ಲಿ VIBGYOR ಬಣ್ಣಗಳಾಗಿ ಪ್ರತ್ಯೇಕಗೊಳ್ಳುವುದನ್ನು ವರ್ಣವಿಭಜನೆ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q17",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಧ್ವನಿಯ ತೀವ್ರತೆ ಅಥವಾ ಕರ್ಕಶತೆಯನ್ನು (Loudness) ಅಳೆಯುವ ಏಕಮಾನ ಯಾವುದು?",
            options = listOf("ಡೆಸಿಬಲ್ (Decibel - dB)", "ಹರ್ಟ್ಜ್ (Hertz)", "ಮೀಟರ್/ಸೆಕೆಂಡ್", "ವ್ಯಾಟ್"),
            correctAnswer = "ಡೆಸಿಬಲ್ (Decibel - dB)",
            explanation = "ಧ್ವನಿಯ ತೀವ್ರತೆಯನ್ನು (Loudness) ಡೆಸಿಬಲ್ (dB) ಗಳಲ್ಲಿ ಅಳೆಯಲಾಗುತ್ತದೆ. 80 dB ಗಿಂತ ಹೆಚ್ಚಿನ ಧ್ವನಿಯು ಶ್ರವಣ ಮಾಲಿನ್ಯವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q18",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನ ದ್ರವಗಳಲ್ಲಿ ಯಾವುದು ಉತ್ತಮ ವಿದ್ಯುತ್ ವಾಹಕವಲ್ಲ?",
            options = listOf("ಬಟ್ಟಿ ಇಳಿಸಿದ ನೀರು (Distilled water)", "ನಿಂಬೆ ರಸ", "ಉಪ್ಪಿನ ದ್ರಾವಣ", "ಕಾಸ್ಟಿಕ್ ಸೋಡಾ ದ್ರಾವಣ"),
            correctAnswer = "ಬಟ್ಟಿ ಇಳಿಸಿದ ನೀರು (Distilled water)",
            explanation = "ಬಟ್ಟಿ ಇಳಿಸಿದ ಶುದ್ಧ ನೀರಿನಲ್ಲಿ ಲವಣಗಳು ಅಥವಾ ಮುಕ್ತ ಅಯಾನುಗಳು ಇರುವುದಿಲ್ಲವಾದ್ದರಿಂದ ಅದು ವಿದ್ಯುತ್ತಿನ ದುರ್ಬಲ ವಾಹಕವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q19",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸಮುದ್ರ ತೀರಗಳಲ್ಲಿ ಹಗಲಿನ ವೇಳೆಯಲ್ಲಿ ಸಮುದ್ರದಿಂದ ಭೂಮಿಯ ಕಡೆಗೆ ಬೀಸುವ ತಂಗಾಳಿಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಕಡಲ ಗಾಳಿ (Sea Breeze)", "ನೆಲ ಗಾಳಿ (Land Breeze)", "ಚಂಡಮಾರುತ", "ಮಾನ್ಸೂನ್ ಮಾರುತ"),
            correctAnswer = "ಕಡಲ ಗಾಳಿ (Sea Breeze)",
            explanation = "ಹಗಲಿನಲ್ಲಿ ಭೂಮಿ ಬೇಗ ಕಾದಾಗ ಅಲ್ಲಿನ ಗಾಳಿ ಮೇಲೇರುತ್ತದೆ, ಮತ್ತು ತಂಪಾದ ಕಡಲಿನ ಗಾಳಿ ಭೂಮಿಯತ್ತ ಬೀಸುತ್ತದೆ. ಇದು ಕಡಲ ಗಾಳಿ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u2_q20",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕಬ್ಬಿಣದ ವಸ್ತುಗಳು ತುಕ್ಕು ಹಿಡಿಯುವುದನ್ನು ತಡೆಯಲು ಅವುಗಳ ಮೇಲೆ ಸತುವಿನ (Zinc) ತೆಳುವಾದ ಲೇಪನ ಮಾಡುವ ಪ್ರಕ್ರಿಯೆ ಯಾವುದು?",
            options = listOf("ಗ್ಯಾಲ್ವನೀಕರಣ (Galvanization)", "ವಿದ್ಯುದ್ವಿಭಜನೆ", "ತಟಸ್ಥೀಕರಣ", "ಅಲ್ಯೂಮಿನಿಯಂ ಲೇಪನ"),
            correctAnswer = "ಗ್ಯಾಲ್ವನೀಕರಣ (Galvanization)",
            explanation = "ಕಬ್ಬಿಣವು ನೀರು ಮತ್ತು ಗಾಳಿಯ ಸಂಪರ್ಕದಿಂದ ತುಕ್ಕು ಹಿಡಿಯುವುದನ್ನು ತಡೆಯಲು ಅದರ ಮೇಲೆ ಸತುವಿನ ಲೇಪನ ಮಾಡುವುದನ್ನು ಗ್ಯಾಲ್ವನೀಕರಣ ಎನ್ನುತ್ತಾರೆ."
        ),
        // ========================================================
        // ಘಟಕ 3: ದ್ರವ್ಯ, ಲೋಹಗಳು, ಅಲೋಹಗಳು ಮತ್ತು ಸಂಶ್ಲೇಷಿತ ಎಳೆಗಳು (Metals, Non-metals & Synthetic Fibres)
        // ========================================================
        QuestionModel(
            id = "nmms_sat_sci_u3_q1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಲೋಹಗಳನ್ನು ತಟ್ಟಿ ತೆಳುವಾದ ಹಾಳೆಗಳನ್ನಾಗಿ ಮಾಡಬಹುದಾದ ಗುಣವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಕುಟ್ಟ್ಯತೆ (Malleability)", "ತನ್ಯತೆ (Ductility)", "ನಾದಗುಣ (Sonority)", "ವಾಹಕತೆ"),
            correctAnswer = "ಕುಟ್ಟ್ಯತೆ (Malleability)",
            explanation = "ಲೋಹಗಳನ್ನು ಹೊಡೆದು ತೆಳುವಾದ ಹಾಳೆಗಳನ್ನಾಗಿ ಮಾಡುವ ಗುಣವನ್ನು ಕುಟ್ಟ್ಯತೆ ಎನ್ನುತ್ತಾರೆ. ಚಿನ್ನ ಮತ್ತು ಬೆಳ್ಳಿ ಅತ್ಯುನ್ನತ ಕುಟ್ಟ್ಯತೆ ಹೊಂದಿವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q2",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಲೋಹಗಳನ್ನು ಎಳೆದು ಸಣ್ಣ ತಂತಿಗಳನ್ನಾಗಿ ಮಾಡಬಹುದಾದ ಗುಣವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ತನ್ಯತೆ (Ductility)", "ಕುಟ್ಟ್ಯತೆ", "ಸಾಂದ್ರತೆ", "ಹೊಳಪು"),
            correctAnswer = "ತನ್ಯತೆ (Ductility)",
            explanation = "ಲೋಹಗಳನ್ನು ಎಳೆದು ತಂತಿಗಳನ್ನಾಗಿ ಮಾಡುವ ಸಾಮರ್ಥ್ಯವನ್ನು ತನ್ಯತೆ (Ductility) ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q3",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೋಣೆಯ ಸಾಮಾನ್ಯ ತಾಪಮಾನದಲ್ಲಿ ದ್ರವ ರೂಪದಲ್ಲಿರುವ ಏಕೈಕ ಲೋಹ ಯಾವುದು?",
            options = listOf("ಪಾದರಸ (Mercury)", "ಬ್ರೋಮಿನ್", "ಸೋಡಿಯಂ", "ಗ್ಯಾಲಿಯಂ"),
            correctAnswer = "ಪಾದರಸ (Mercury)",
            explanation = "ಪಾದರಸ (Hg) ಸಾಮಾನ್ಯ ತಾಪಮಾನದಲ್ಲಿ ದ್ರವ ಸ್ಥಿತಿಯಲ್ಲಿರುವ ಏಕೈಕ ಲೋಹವಾಗಿದೆ. (ಬ್ರೋಮಿನ್ ದ್ರವ ರೂಪದ ಅಲೋಹ)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q4",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಚಾಕುವಿನಿಂದ ಸುಲಭವಾಗಿ ಕತ್ತರಿಸಬಹುದಾದ ಅತ್ಯಂತ ಮೃದುವಾದ ಲೋಹಗಳು ಯಾವುವು?",
            options = listOf("ಸೋಡಿಯಂ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ", "ಕಬ್ಬಿಣ ಮತ್ತು ತಾಮ್ರ", "ಚಿನ್ನ ಮತ್ತು ಬೆಳ್ಳಿ", "ಸೀಸ ಮತ್ತು ತವರ"),
            correctAnswer = "ಸೋಡಿಯಂ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ",
            explanation = "ಸೋಡಿಯಂ (Na) ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ (K) ಅತ್ಯಂತ ಮೃದುವಾದ ಲೋಹಗಳಾಗಿದ್ದು, ಚಾಕುವಿನಿಂದ ಸುಲಭವಾಗಿ ಕತ್ತರಿಸಬಹುದು."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q5",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಸೋಡಿಯಂ ಲೋಹವನ್ನು ಗಾಳಿ ಮತ್ತು ನೀರಿನೊಂದಿಗೆ ಉಗ್ರವಾಗಿ ವರ್ತಿಸುವುದರಿಂದ ಎಲ್ಲಿ ಸಂರಕ್ಷಿಸಿಡಲಾಗುತ್ತದೆ?",
            options = listOf("ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ (Kerosene)", "ನೀರಿನಲ್ಲಿ", "ಆಲ್ಕೋಹಾಲ್‌ನಲ್ಲಿ", "ತೆರೆದ ಗಾಳಿಯಲ್ಲಿ"),
            correctAnswer = "ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ (Kerosene)",
            explanation = "ಸೋಡಿಯಂ ಗಾಳಿಯಲ್ಲಿರುವ ಆಕ್ಸಿಜನ್ ಮತ್ತು ತೇವಾಂಶದೊಂದಿಗೆ ವೇಗವಾಗಿ ವರ್ತಿಸಿ ಬೆಂಕಿ ಹೊತ್ತಿಕೊಳ್ಳುವುದರಿಂದ ಅದನ್ನು ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ ಮುಳುಗಿಸಿಡಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q6",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಗಾಳಿಗೆ ತೆರೆದಿಟ್ಟಾಗ ಸುಲಭವಾಗಿ ಬೆಂಕಿ ಹೊತ್ತಿಕೊಳ್ಳುವುದರಿಂದ ನೀರಿನಲ್ಲಿ ಸಂಗ್ರಹಿಸಿಡುವ ಅಲೋಹ ಯಾವುದು?",
            options = listOf("ರಂಜಕ (Phosphorus)", "ಗಂಧಕ (Sulphur)", "ಕಾರ್ಬನ್", "ಅಯೋಡಿನ್"),
            correctAnswer = "ರಂಜಕ (Phosphorus)",
            explanation = "ಬಿಳಿ ರಂಜಕವು ಅತ್ಯಂತ ಕ್ರಿಯಾಶೀಲ ಅಲೋಹವಾಗಿದ್ದು, ಸಾಮಾನ್ಯ ತಾಪಮಾನದಲ್ಲೇ ಗಾಳಿಯೊಂದಿಗೆ ವರ್ತಿಸಿ ದಹಿಸುವುದರಿಂದ ಅದನ್ನು ನೀರಿನಲ್ಲಿ ಸಂಗ್ರಹಿಸಿಡಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q7",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಲೋಹಗಳು ಆಮ್ಲಗಳೊಂದಿಗೆ ವರ್ತಿಸಿದಾಗ ಬಿಡುಗಡೆಯಾಗುವ ಅನಿಲ ಯಾವುದು?",
            options = listOf("ಹೈಡ್ರೋಜನ್ (H₂)", "ಆಕ್ಸಿಜನ್ (O₂)", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)", "ಸಾರಜನಕ (N₂)"),
            correctAnswer = "ಹೈಡ್ರೋಜನ್ (H₂)",
            explanation = "ಲೋಹಗಳು ಸಾರರಿಕ್ತ ಆಮ್ಲಗಳೊಂದಿಗೆ ವರ್ತಿಸಿ ಲೋಹೀಯ ಲವಣ ಮತ್ತು ಹೈಡ್ರೋಜನ್ ಅನಿಲವನ್ನು ಬಿಡುಗಡೆ ಮಾಡುತ್ತವೆ. ಈ ಅನಿಲವು 'ಪಾಪ್' ಶಬ್ದದೊಂದಿಗೆ ಉರಿಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q8",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಸಾಮಾನ್ಯವಾಗಿ ಅಲೋಹಗಳ ಆಕ್ಸೈಡ್‌ಗಳು ಯಾವ ಸ್ವಭಾವವನ್ನು ಹೊಂದಿರುತ್ತವೆ?",
            options = listOf("ಆಮ್ಲೀಯ ಸ್ವಭಾವ", "ಪ್ರತ್ಯಾಮ್ಲೀಯ ಸ್ವಭಾವ", "ತಟಸ್ಥ ಸ್ವಭಾವ", "ಕ್ಷಾರೀಯ ಸ್ವಭಾವ"),
            correctAnswer = "ಆಮ್ಲೀಯ ಸ್ವಭಾವ",
            explanation = "ಅಲೋಹೀಯ ಆಕ್ಸೈಡ್‌ಗಳು (ಉದಾ: SO₂, CO₂) ನೀರಿನೊಂದಿಗೆ ವರ್ತಿಸಿ ಆಮ್ಲಗಳನ್ನು ಉಂಟುಮಾಡುತ್ತವೆ, ಆದ್ದರಿಂದ ಅವು ಆಮ್ಲೀಯವಾಗಿರುತ್ತವೆ. (ಲೋಹಗಳ ಆಕ್ಸೈಡ್‌ಗಳು ಪ್ರತ್ಯಾಮ್ಲೀಯ)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q9",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಮರದ ತಿರುಳಿನಿಂದ (Wood pulp) ರಾಸಾಯನಿಕ ಸಂಸ್ಕರಣೆ ಮೂಲಕ ತಯಾರಿಸಲಾಗುವ ಕೃತಕ ರೇಷ್ಮೆ ಯಾವುದು?",
            options = listOf("ರೇಯಾನ್ (Rayon)", "ನೈಲಾನ್ (Nylon)", "ಪಾಲಿಯೆಸ್ಟರ್", "ಅಕ್ರಿಲಿಕ್"),
            correctAnswer = "ರೇಯಾನ್ (Rayon)",
            explanation = "ಮರದ ತಿರುಳನ್ನು ಸಂಸ್ಕರಿಸಿ ತಯಾರಿಸುವ ರೇಯಾನ್ ನೈಸರ್ಗಿಕ ಮೂಲದ ಪಾಲಿಸ್ಯಾಕರೈಡ್ ಆಧಾರಿತವಾಗಿದ್ದು, ಇದನ್ನು 'ಕೃತಕ ರೇಷ್ಮೆ' ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q10",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಯಾವುದೇ ನೈಸರ್ಗಿಕ ಕಚ್ಚಾ ಪದಾರ್ಥಗಳಿಲ್ಲದೆ ಸಂಪೂರ್ಣವಾಗಿ ಸಂಶ್ಲೇಷಿಸಲ್ಪಟ್ಟ ಮೊದಲ ಕೃತಕ ಎಳೆ ಯಾವುದು?",
            options = listOf("ನೈಲಾನ್ (Nylon)", "ರೇಯಾನ್", "ಟೆರಿಲೀನ್", "ಪ್ಲಾಸ್ಟಿಕ್"),
            correctAnswer = "ನೈಲಾನ್ (Nylon)",
            explanation = "1931 ರಲ್ಲಿ ಕಲ್ಲಿದ್ದಲು, ನೀರು ಮತ್ತು ಗಾಳಿಯಿಂದ ಸಂಪೂರ್ಣವಾಗಿ ಸಂಶ್ಲೇಷಿಸಿದ ಮೊದಲ ಕೃತಕ ಎಳೆ ನೈಲಾನ್ ಆಗಿದೆ. ಇದು ಅತ್ಯಂತ ಬಲಿಷ್ಠ ಮತ್ತು ಸ್ಥಿತಿಸ್ಥಾಪಕತ್ವ ಹೊಂದಿದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q11",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬಿಸಿ ಮಾಡಿದಾಗ ಮೃದುವಾಗದೆ, ಒಮ್ಮೆ ಆಕಾರ ನೀಡಿದ ನಂತರ ಮತ್ತೆ ರೂಪಾಂತರಿಸಲಾಗದ ಪ್ಲಾಸ್ಟಿಕ್ ವಿಧ ಯಾವುದು?",
            options = listOf("ಥರ್ಮೋಸೆಟ್ಟಿಂಗ್ ಪ್ಲಾಸ್ಟಿಕ್", "ಥರ್ಮೋಪ್ಲಾಸ್ಟಿಕ್", "ಪಾಲಿಥೀನ್", "ಪಿವಿಸಿ (PVC)"),
            correctAnswer = "ಥರ್ಮೋಸೆಟ್ಟಿಂಗ್ ಪ್ಲಾಸ್ಟಿಕ್",
            explanation = "ಥರ್ಮೋಸೆಟ್ಟಿಂಗ್ ಪ್ಲಾಸ್ಟಿಕ್‌ಗಳು (ಉದಾ: ಬೇಕ್‌ಲೈಟ್, ಮೆಲಮೈನ್) ಒಮ್ಮೆ ಅಚ್ಚಿಗೆ ಹಾಕಿ ಗಟ್ಟಿಗೊಳಿಸಿದ ನಂತರ ಕಾಯಿಸಿದರೂ ಮೃದುವಾಗುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q12",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಸ್ವಿಚ್‌ಗಳು ಮತ್ತು ಪಾತ್ರೆಗಳ ಕೈಹಿಡಿಗಳನ್ನು ತಯಾರಿಸಲು ಬಳಸುವ ಉಷ್ಣ ಮತ್ತು ವಿದ್ಯುತ್ ಅವಾಹಕ ಪ್ಲಾಸ್ಟಿಕ್ ಯಾವುದು?",
            options = listOf("ಬೇಕ್‌ಲೈಟ್ (Bakelite)", "ಪಾಲಿಥೀನ್", "ಟೆಫ್ಲಾನ್", "ನೈಲಾನ್"),
            correctAnswer = "ಬೇಕ್‌ಲೈಟ್ (Bakelite)",
            explanation = "ಬೇಕ್‌ಲೈಟ್ ಥರ್ಮೋಸೆಟ್ಟಿಂಗ್ ಪ್ಲಾಸ್ಟಿಕ್ ಆಗಿದ್ದು, ವಿದ್ಯುತ್ ಮತ್ತು ಉಷ್ಣದ ದುರ್ಬಲ ವಾಹಕವಾಗಿರುವುದರಿಂದ ಸ್ವಿಚ್‌ಗಳು ಹಾಗೂ ಕುಕ್ಕರ್ ಹ್ಯಾಂಡಲ್‌ಗಳಿಗೆ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q13",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ನಾನ್-ಸ್ಟಿಕ್ ಅಡುಗೆ ಪಾತ್ರೆಗಳ ಮೇಲೆ ಎಣ್ಣೆ ಮತ್ತು ನೀರು ಅಂಟಿಕೊಳ್ಳದಂತೆ ಲೇಪಿಸಲು ಬಳಸುವ ಪಾಲಿಮರ್ ಯಾವುದು?",
            options = listOf("ಟೆಫ್ಲಾನ್ (Teflon - PTFE)", "ಮೆಲಮೈನ್", "ರೇಯಾನ್", "ಪಾಲಿವಿನೈಲ್ ಕ್ಲೋರೈಡ್"),
            correctAnswer = "ಟೆಫ್ಲಾನ್ (Teflon - PTFE)",
            explanation = "ಟೆಫ್ಲಾನ್ (ಪಾಲಿಟೆಟ್ರಾಫ್ಲೋರೋಎಥಿಲೀನ್) ಮೇಲೆ ಎಣ್ಣೆ ಅಥವಾ ನೀರು ಅಂಟಿಕೊಳ್ಳುವುದಿಲ್ಲ, ಆದ್ದರಿಂದ ನಾನ್‌ಸ್ಟಿಕ್ ಪಾತ್ರೆಗಳ ತಯಾರಿಕೆಯಲ್ಲಿ ಬಳಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q14",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ತಾಮ್ರದ ಪಾತ್ರೆಗಳು ತೇವಾಂಶವುಳ್ಳ ಗಾಳಿಗೆ ತೆರೆದುಕೊಂಡಾಗ ಅವುಗಳ ಮೇಲೆ ಉಂಟಾಗುವ ಹಸಿರು ಲೇಪನವು ಯಾವುದರ ಮಿಶ್ರಣವಾಗಿದೆ?",
            options = listOf("ಕಾಪರ್ ಹೈಡ್ರಾಕ್ಸೈಡ್ ಮತ್ತು ಕಾಪರ್ ಕಾರ್ಬೊನೇಟ್", "ಕಾಪರ್ ಆಕ್ಸೈಡ್ ಮತ್ತು ಕಾಪರ್ ಸಲ್ಫೇಟ್", "ಕಾಪರ್ ನೈಟ್ರೇಟ್", "ಶುದ್ಧ ತಾಮ್ರ"),
            correctAnswer = "ಕಾಪರ್ ಹೈಡ್ರಾಕ್ಸೈಡ್ ಮತ್ತು ಕಾಪರ್ ಕಾರ್ಬೊನೇಟ್",
            explanation = "ತಾಮ್ರವು ತೇವಾಂಶವಿರುವ ಗಾಳಿಯೊಂದಿಗೆ ವರ್ತಿಸಿದಾಗ Cu(OH)₂ ಮತ್ತು CuCO₃ ಮಿಶ್ರಣದ ಹಸಿರು ಬಣ್ಣದ ಪದರ ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q15",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕಬ್ಬಿಣದ ಮೊಳೆಯನ್ನು ತಾಮ್ರದ ಸಲ್ಫೇಟ್ (CuSO₄) ದ್ರಾವಣದಲ್ಲಿ ಮುಳುಗಿಸಿದಾಗ ನೀಲಿ ಬಣ್ಣವು ತಿಳಿ ಹಸಿರಾಗಲು ಕಾರಣವೇನು?",
            options = listOf("ಕಬ್ಬಿಣವು ತಾಮ್ರವನ್ನು ಸ್ಥಾನಪಲ್ಲಟಗೊಳಿಸಿ ಫೆರಸ್ ಸಲ್ಫೇಟ್ ಉಂಟಾಗುವುದು", "ತಾಮ್ರವು ಕರಗುವುದು", "ದ್ರಾವಣವು ಆವಿಯಾಗುವುದು", "ಆಕ್ಸಿಜನ್ ಹೀರಿಕೆಯಾಗುವುದು"),
            correctAnswer = "ಕಬ್ಬಿಣವು ತಾಮ್ರವನ್ನು ಸ್ಥಾನಪಲ್ಲಟಗೊಳಿಸಿ ಫೆರಸ್ ಸಲ್ಫೇಟ್ ಉಂಟಾಗುವುದು",
            explanation = "ಕಬ್ಬಿಣವು ತಾಮ್ರಕ್ಕಿಂತ ಹೆಚ್ಚು ಕ್ರಿಯಾಶೀಲವಾಗಿರುವುದರಿಂದ CuSO₄ ನಿಂದ ತಾಮ್ರವನ್ನು ಸ್ಥಾನಪಲ್ಲಟಗೊಳಿಸಿ ಹಸಿರು ಬಣ್ಣದ FeSO₄ ದ್ರಾವಣವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q16",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ಲೋಹಗಳ ಕ್ರಿಯಾಶೀಲತೆಯ ಇಳಿಕೆ ಕ್ರಮವನ್ನು ಸರಿಯಾಗಿ ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಪೊಟ್ಯಾಸಿಯಂ > ಸೋಡಿಯಂ > ಕ್ಯಾಲ್ಸಿಯಂ > ಮೆಗ್ನೀಸಿಯಂ", "ಕಬ್ಬಿಣ > ಸತು > ತಾಮ್ರ > ಚಿನ್ನ", "ಚಿನ್ನ > ಬೆಳ್ಳಿ > ತಾಮ್ರ > ಕಬ್ಬಿಣ", "ಅಲ್ಯೂಮಿನಿಯಂ > ಕ್ಯಾಲ್ಸಿಯಂ > ಸೋಡಿಯಂ > ಪೊಟ್ಯಾಸಿಯಂ"),
            correctAnswer = "ಪೊಟ್ಯಾಸಿಯಂ > ಸೋಡಿಯಂ > ಕ್ಯಾಲ್ಸಿಯಂ > ಮೆಗ್ನೀಸಿಯಂ",
            explanation = "ಕ್ರಿಯಾಶೀಲ ಸರಣಿಯಲ್ಲಿ ಪೊಟ್ಯಾಸಿಯಂ ಅತ್ಯುನ್ನತ ಕ್ರಿಯಾಶೀಲವಾಗಿದ್ದು ನಂತರ ಸೋಡಿಯಂ, ಕ್ಯಾಲ್ಸಿಯಂ ಮತ್ತು ಮೆಗ್ನೀಸಿಯಂ ಬರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q17",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಗಾಯಗಳಿಗೆ ನಂಜುನಿರೋಧಕವಾಗಿ (Antiseptic) ಬಳಸುವ ನೇರಳೆ ಬಣ್ಣದ ದ್ರಾವಣದಲ್ಲಿರುವ ಅಲೋಹ ಯಾವುದು?",
            options = listOf("ಅಯೋಡಿನ್ (Iodine)", "ಕ್ಲೋರಿನ್", "ಬ್ರೋಮಿನ್", "ಸಲ್ಫರ್"),
            correctAnswer = "ಅಯೋಡಿನ್ (Iodine)",
            explanation = "ಅಯೋಡಿನ್ ದ್ರಾವಣವನ್ನು (ಟಿಂಕ್ಚರ್ ಅಯೋಡಿನ್) ಗಾಯಗಳ ಮೇಲೆ ಸೋಂಕು ನಿವಾರಕವಾಗಿ (Antiseptic) ವ್ಯಾಪಕವಾಗಿ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q18",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ನೀರಿನಲ್ಲಿರುವ ರೋಗಾಣುಗಳನ್ನು ಕೊಲ್ಲಲು ಕ್ರಿಮಿನಾಶಕವಾಗಿ ಬಳಸುವ ಅಲೋಹ ಯಾವುದು?",
            options = listOf("ಕ್ಲೋರಿನ್ (Chlorine)", "ಕಾರ್ಬನ್", "ರಂಜಕ", "ಹೈಡ್ರೋಜನ್"),
            correctAnswer = "ಕ್ಲೋರಿನ್ (Chlorine)",
            explanation = "ಕ್ಲೋರಿನ್ ಅನಿಲ ಅಥವಾ ಕ್ಲೋರಿನ್ ಮಾತ್ರೆಗಳನ್ನು ಕುಡಿಯುವ ನೀರನ್ನು ಶುದ್ಧೀಕರಿಸಲು ಮತ್ತು ಕ್ರಿಮಿನಾಶಕವಾಗಿ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q19",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬೆಂಕಿ ನಂದಿಸುವ ಸಿಬ್ಬಂದಿಯ ಉಡುಪುಗಳು ಬೆಂಕಿಗೆ ಸುಡದಂತೆ ಮಾಡಲು ಯಾವ ಪ್ಲಾಸ್ಟಿಕ್ ಲೇಪನ ಬಳಸಲಾಗುತ್ತದೆ?",
            options = listOf("ಮೆಲಮೈನ್ (Melamine)", "ಪಾಲಿಥೀನ್", "ಪಿವಿಸಿ", "ರೇಯಾನ್"),
            correctAnswer = "ಮೆಲಮೈನ್ (Melamine)",
            explanation = "ಮೆಲಮೈನ್ ಬೆಂಕಿಯನ್ನು ತಡೆಯುವ ಮತ್ತು ಉಷ್ಣವನ್ನು ಸಹಿಸಿಕೊಳ್ಳುವ ವಿಶೇಷ ಥರ್ಮೋಸೆಟ್ಟಿಂಗ್ ಪ್ಲಾಸ್ಟಿಕ್ ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u3_q20",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಪರಿಸರ ಸಂರಕ್ಷಣೆಯಲ್ಲಿ ಪ್ಲಾಸ್ಟಿಕ್ ತ್ಯಾಜ್ಯ ನಿರ್ವಹಣೆಗಾಗಿ ಸೂಚಿಸಲಾದ 5R ತತ್ವದಲ್ಲಿ ಸೇರದ ಅಂಶ ಯಾವುದು?",
            options = listOf("Repeat (ಪುನರಾವರ್ತಿಸು)", "Refuse (ನಿರಾಕರಿಸು)", "Reduce (ಕಡಿಮೆ ಮಾಡು)", "Recycle (ಮರುಬಳಕೆ ಮಾಡು)"),
            correctAnswer = "Repeat (ಪುನರಾವರ್ತಿಸು)",
            explanation = "5R ತತ್ವಗಳು: Refuse (ನಿರಾಕರಿಸು), Reduce (ಕಡಿಮೆ ಮಾಡು), Reuse (ಮರುಬಳಕೆ ಮಾಡು), Repurpose/Recover (ಉದ್ದೇಶ ಬದಲಿಸು), ಮತ್ತು Recycle (ಮರುಚಕ್ರೀಕರಣ ಮಾಡು)."
        ),
        // ========================================================
        // ಘಟಕ 4: ಆಮ್ಲ-ಪ್ರತ್ಯಾಮ್ಲಗಳು, ಕಲ್ಲಿದ್ದಲು, ಪೆಟ್ರೋಲಿಯಂ ಮತ್ತು ದಹನ (Acids, Bases, Fuels & Combustion)
        // ========================================================
        QuestionModel(
            id = "nmms_sat_sci_u4_q1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ನೀಲಿ ಲಿಟ್ಮಸ್ ಕಾಗದವನ್ನು ಕೆಂಪು ಬಣ್ಣಕ್ಕೆ ತಿರುಗಿಸುವ ದ್ರಾವಣಗಳು ಯಾವುವು?",
            options = listOf("ಆಮ್ಲಗಳು (Acids)", "ಪ್ರತ್ಯಾಮ್ಲಗಳು (Bases)", "ತಟಸ್ಥ ದ್ರಾವಣಗಳು", "ಲವಣಗಳು"),
            correctAnswer = "ಆಮ್ಲಗಳು (Acids)",
            explanation = "ಆಮ್ಲಗಳು ಹುಳಿ ರುಚಿ ಹೊಂದಿದ್ದು, ನೀಲಿ ಲಿಟ್ಮಸ್ ಅನ್ನು ಕೆಂಪಾಗಿಸುತ್ತವೆ. ಪ್ರತ್ಯಾಮ್ಲಗಳು ಕೆಂಪು ಲಿಟ್ಮಸ್ ಅನ್ನು ನೀಲಿಯಾಗಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q2",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಇರುವೆ ಕಚ್ಚಿದಾಗ ಚರ್ಮದೊಳಗೆ ಸೇರುವ ಆಮ್ಲ ಯಾವುದು?",
            options = listOf("ಫಾರ್ಮಿಕ್ ಆಮ್ಲ (Formic acid / Methanoic acid)", "ಸಿಟ್ರಿಕ್ ಆಮ್ಲ", "ಲ್ಯಾಕ್ಟಿಕ್ ಆಮ್ಲ", "ಅಸಿಟಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಫಾರ್ಮಿಕ್ ಆಮ್ಲ (Formic acid / Methanoic acid)",
            explanation = "ಇರುವೆ ಕಚ್ಚಿದಾಗ ಚರ್ಮದೊಳಗೆ ಫಾರ್ಮಿಕ್ ಆಮ್ಲವನ್ನು ಚುಚ್ಚುತ್ತದೆ. ಉರಿಯನ್ನು ಶಮನಗೊಳಿಸಲು ಅಡುಗೆ ಸೋಡಾ (ಬೇಸ್) ಲೇಪಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q3",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಆಮ್ಲ ಮತ್ತು ಪ್ರತ್ಯಾಮ್ಲಗಳು ಪರಸ್ಪರ ವರ್ತಿಸಿ ಲವಣ ಮತ್ತು ನೀರನ್ನು ಉಂಟುಮಾಡುವ ಕ್ರಿಯೆಗೆ ಏನೆನ್ನುತ್ತಾರೆ?",
            options = listOf("ತಟಸ್ಥೀಕರಣ ಕ್ರಿಯೆ (Neutralization)", "ದಹನ ಕ್ರಿಯೆ", "ಉತ್ಕರ್ಷಣ ಕ್ರಿಯೆ", "ವಿಭಜನೆ ಕ್ರಿಯೆ"),
            correctAnswer = "ತಟಸ್ಥೀಕರಣ ಕ್ರಿಯೆ (Neutralization)",
            explanation = "ಆಮ್ಲ + ಪ್ರತ್ಯಾಮ್ಲ → ಲವಣ + ನೀರು + ಉಷ್ಣ. ಈ ಕ್ರಿಯೆಯನ್ನು ತಟಸ್ಥೀಕರಣ ಕ್ರಿಯೆ ಎನ್ನಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q4",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಹೊಟ್ಟೆಯಲ್ಲಿ ಅತಿಯಾದ ಆಮ್ಲೀಯತೆ (ಅಸಿಡಿಟಿ) ಉಂಟಾದಾಗ ಶಮನಗೊಳಿಸಲು ಬಳಸುವ ಆಂಟಾಸಿಡ್ (Antacid) ಯಾವುದು?",
            options = listOf("ಮಿಲ್ಕ್ ಆಫ್ ಮೆಗ್ನೀಸಿಯಾ (ಮೆಗ್ನೀಸಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್)", "ಸಲ್ಫ್ಯೂರಿಕ್ ಆಮ್ಲ", "ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲ", "ಸೋಡಿಯಂ ಕ್ಲೋರೈಡ್"),
            correctAnswer = "ಮಿಲ್ಕ್ ಆಫ್ ಮೆಗ್ನೀಸಿಯಾ (ಮೆಗ್ನೀಸಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್)",
            explanation = "ಮೆಗ್ನೀಸಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್ [Mg(OH)₂] ಸೌಮ್ಯ ಪ್ರತ್ಯಾಮ್ಲವಾಗಿದ್ದು ಹೊಟ್ಟೆಯಲ್ಲಿನ ಹೆಚ್ಚುವರಿ ಆಮ್ಲವನ್ನು ತಟಸ್ಥಗೊಳಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q5",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಮೃತ ಸಸ್ಯವರ್ಗಗಳು ಲಕ್ಷಾಂತರ ವರ್ಷಗಳ ತಾಪ ಮತ್ತು ಒತ್ತಡದಿಂದ ಕಲ್ಲಿದ್ದಲಾಗಿ ಪರಿವರ್ತನೆಗೊಳ್ಳುವ ನಿಧಾನ ಪ್ರಕ್ರಿಯೆ ಯಾವುದು?",
            options = listOf("ಕಾರ್ಬೊನೀಕರಣ (Carbonisation)", "ಬಟ್ಟಿ ಇಳಿಸುವಿಕೆ", "ದಹನ", "ಖನಿಜೀಕರಣ"),
            correctAnswer = "ಕಾರ್ಬೊನೀಕರಣ (Carbonisation)",
            explanation = "ಸತ್ತ ಸಸ್ಯಗಳು ತಾಪ ಮತ್ತು ಒತ್ತಡದ ಪ್ರಭಾವದಿಂದ ಕಲ್ಲಿದ್ದಲಾಗಿ ಮಾರ್ಪಾಡಾಗುವ ನಿಧಾನ ಪ್ರಕ್ರಿಯೆಗೆ ಕಾರ್ಬೊನೀಕರಣ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q6",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕಲ್ಲಿದ್ದಲನ್ನು ಸಂಸ್ಕರಿಸಿದಾಗ ದೊರೆಯುವ ಸುಮಾರು 98% ಶುದ್ಧ ಇಂಗಾಲದ ರೂಪ ಯಾವುದು?",
            options = listOf("ಕೋಕ್ (Coke)", "ಕೋಲ್ಟಾರ್", "ಕೋಲ್ ಗ್ಯಾಸ್", "ಪೆಟ್ರೋಲಿಯಂ"),
            correctAnswer = "ಕೋಕ್ (Coke)",
            explanation = "ಕೋಕ್ ಒಂದು ಕಠಿಣ, ರಂಧ್ರಯುಕ್ತ ಕಪ್ಪು ವಸ್ತುವಾಗಿದ್ದು, ಕಲ್ಲಿದ್ದಲಿನ ಅತ್ಯಂತ ಶುದ್ಧ ಇಂಗಾಲದ ರೂಪವಾಗಿದೆ. ಇದನ್ನು ಉಕ್ಕು ತಯಾರಿಕೆಯಲ್ಲಿ ಬಳಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q7",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಪೆಟ್ರೋಲಿಯಂನ ವಿವಿಧ ಘಟಕಗಳನ್ನು ಬೇರ್ಪಡಿಸಲು ಬಳಸುವ ವೈಜ್ಞಾನಿಕ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಅಂಶಿಕ ಬಟ್ಟಿ ಇಳಿಸುವಿಕೆ (Fractional Distillation)", "ಸೋಸುವಿಕೆ", "ಭಾಷ್ಪೀಕರಣ", "ಸ್ಫಟಿಕೀಕರಣ"),
            correctAnswer = "ಅಂಶಿಕ ಬಟ್ಟಿ ಇಳಿಸುವಿಕೆ (Fractional Distillation)",
            explanation = "ಪೆಟ್ರೋಲಿಯಂನಲ್ಲಿರುವ ವಿವಿಧ ಹೈಡ್ರೋಕಾರ್ಬನ್‌ಗಳ ಕುದಿಯುವ ಬಿಂದುಗಳ ವ್ಯತ್ಯಾಸದ ಆಧಾರದ ಮೇಲೆ ಅಂಶಿಕ ಬಟ್ಟಿ ಇಳಿಸುವಿಕೆ ಮೂಲಕ ಪೆಟ್ರೋಲ್, ಡೀಸೆಲ್, ಸೀಮೆಎಣ್ಣೆಗಳನ್ನು ಪ್ರತ್ಯೇಕಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q8",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ವಾಹನಗಳಲ್ಲಿ ಪರಿಸರ ಸ್ನೇಹಿ ಇಂಧನವಾಗಿ ಬಳಸಲಾಗುವ CNG ಯ ಪೂರ್ಣ ರೂಪವೇನು?",
            options = listOf("Compressed Natural Gas", "Common Natural Gas", "Condensed Nitrogen Gas", "Carbon Natural Gas"),
            correctAnswer = "Compressed Natural Gas",
            explanation = "CNG ಎಂದರೆ Compressed Natural Gas (ಸಂಪೀಡಿತ ನೈಸರ್ಗಿಕ ಅನಿಲ). ಇದು ಕಡಿಮೆ ಮಾಲಿನ್ಯ ಉಂಟುಮಾಡುವ ಸ್ವಚ್ಛ ಇಂಧನ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q9",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ದಹನಕ್ರಿಯೆ (Combustion) ನಡೆಯಲು ಅನಿವಾರ್ಯವಾಗಿ ಬೇಕಾಗುವ ಪೋಷಕ ಅನಿಲ ಯಾವುದು?",
            options = listOf("ಆಕ್ಸಿಜನ್ (O₂)", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)", "ಸಾರಜನಕ (N₂)", "ಹೈಡ್ರೋಜನ್ (H₂)"),
            correctAnswer = "ಆಕ್ಸಿಜನ್ (O₂)",
            explanation = "ಯಾವುದೇ ವಸ್ತು ಉರಿಯಲು (ದಹನ ಕ್ರಿಯೆಗೆ) ಆಮ್ಲಜನಕ (Oxygen) ಬೆಂಬಲ ಅತ್ಯಗತ್ಯ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q10",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಒಂದು ವಸ್ತುವು ಬೆಂಕಿ ಹೊತ್ತಿಕೊಂಡು ಉರಿಯಲು ಆರಂಭಿಸುವ ಕನಿಷ್ಠ ತಾಪಮಾನವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಜ್ವಲನ ತಾಪಮಾನ (Ignition temperature)", "ಕುದಿಯುವ ಬಿಂದು", "ಕರಗುವ ಬಿಂದು", "ಕ್ಯಾಲೋರಿಫಿಕ್ ಮೌಲ್ಯ"),
            correctAnswer = "ಜ್ವಲನ ತಾಪಮಾನ (Ignition temperature)",
            explanation = "ಒಂದು ವಸ್ತು ಬೆಂಕಿ ಹೊತ್ತಿಕೊಳ್ಳಲು ತಲುಪಬೇಕಾದ ಕನಿಷ್ಠ ತಾಪಮಾನವನ್ನು ಅದರ ಜ್ವಲನ ತಾಪಮಾನ (Ignition temperature) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q11",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಉಪಕರಣಗಳು ಮತ್ತು ಪೆಟ್ರೋಲ್‌ನಿಂದ ಉಂಟಾದ ಬೆಂಕಿಯನ್ನು ನಂದಿಸಲು ಬಳಸುವ ಅತ್ಯುತ್ತಮ ಅಗ್ನಿಶಾಮಕ ಯಾವುದು?",
            options = listOf("ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)", "ನೀರು", "ಆಕ್ಸಿಜನ್", "ಸಾರಜನಕ ಅನಿಲ"),
            correctAnswer = "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)",
            explanation = "CO₂ ಗಾಳಿಗಿಂತ ಭಾರವಾಗಿದ್ದು ಬೆಂಕಿಯ ಸುತ್ತ ಹೊದಿಕೆಯಂತೆ ಆವರಿಸಿ ಆಕ್ಸಿಜನ್ ಸಂಪರ್ಕ ಕಡಿತಗೊಳಿಸುತ್ತದೆ. ಅಲ್ಲದೆ ಇದು ವಿದ್ಯುತ್ ಹರಿಯಲು ಬಿಡುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q12",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಯಾವ ಇಂಧನವು ಅತ್ಯುನ್ನತ ಕ್ಯಾಲೋರಿಫಿಕ್ ಮೌಲ್ಯವನ್ನು (Calorific value) ಹೊಂದಿದೆ?",
            options = listOf("ಹೈಡ್ರೋಜನ್ (1,50,000 kJ/kg)", "LPG (55,000 kJ/kg)", "ಪೆಟ್ರೋಲ್ (45,000 kJ/kg)", "ಕಲ್ಲಿದ್ದಲು (25,000-33,000 kJ/kg)"),
            correctAnswer = "ಹೈಡ್ರೋಜನ್ (1,50,000 kJ/kg)",
            explanation = "ಹೈಡ್ರೋಜನ್ ಇಂಧನವು 1,50,000 kJ/kg ಯಷ್ಟು ಅತ್ಯುನ್ನತ ಕ್ಯಾಲೋರಿಫಿಕ್ ಮೌಲ್ಯವನ್ನು ಹೊಂದಿದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q13",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಮೇಣದಬತ್ತಿಯ ಜ್ವಾಲೆಯಲ್ಲಿ ಅತ್ಯಂತ ಹೆಚ್ಚು ಬಿಸಿಯಾಗಿರುವ ಮತ್ತು ಸಂಪೂರ್ಣ ದಹನ ನಡೆಯುವ ಹೊರ ವಲಯದ ಬಣ್ಣ ಯಾವುದು?",
            options = listOf("ನೀಲಿ (Blue)", "ಹಳದಿ (Yellow)", "ಕಪ್ಪು (Black)", "ಕೆಂಪು (Red)"),
            correctAnswer = "ನೀಲಿ (Blue)",
            explanation = "ಜ್ವಾಲೆಯ ಹೊರ ವಲಯದಲ್ಲಿ ಸಂಪೂರ್ಣ ದಹನ ನಡೆದು ನೀಲಿ ಬಣ್ಣದಲ್ಲಿರುತ್ತದೆ. ಇದು ಜ್ವಾಲೆಯ ಅತ್ಯಂತ ಬಿಸಿಯಾದ ಭಾಗವಾಗಿದೆ (ಅಕ್ಕಸಾಲಿಗರು ಇದನ್ನು ಊದಲು ಬಳಸುತ್ತಾರೆ)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q14",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಇಂಧನಗಳ ಅಪೂರ್ಣ ದಹನದಿಂದ ಬಿಡುಗಡೆಯಾಗುವ, ರಕ್ತದಲ್ಲಿನ ಹಿಮೋಗ್ಲೋಬಿನ್ ಜೊತೆ ಬೆರೆತು ಉಸಿರುಗಟ್ಟಿಸುವ ವಿಷಕಾರಿ ಅನಿಲ ಯಾವುದು?",
            options = listOf("ಕಾರ್ಬನ್ ಮಾನಾಕ್ಸೈಡ್ (CO)", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)", "ಸಲ್ಫರ್ ಡೈಆಕ್ಸೈಡ್", "ಆಕ್ಸಿಜನ್"),
            correctAnswer = "ಕಾರ್ಬನ್ ಮಾನಾಕ್ಸೈಡ್ (CO)",
            explanation = "ಕಾರ್ಬನ್ ಇಂಧನಗಳ ಅಪೂರ್ಣ ದಹನದಿಂದ ಬಿಡುಗಡೆಯಾಗುವ ಕಾರ್ಬನ್ ಮಾನಾಕ್ಸೈಡ್ (CO) ಅತ್ಯಂತ ವಿಷಕಾರಿ ಅನಿಲವಾಗಿದ್ದು, ಮುಚ್ಚಿದ ಕೋಣೆಯಲ್ಲಿ ಜೀವಕ್ಕೆ ಅಪಾಯ ತರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q15",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕಲ್ಲಿದ್ದಲು ಮತ್ತು ಡೀಸೆಲ್ ದಹನದಿಂದ ಬಿಡುಗಡೆಯಾಗುವ ಸಲ್ಫರ್ ಮತ್ತು ನೈಟ್ರೋಜನ್ ಆಕ್ಸೈಡ್‌ಗಳು ಮಳೆ ನೀರಿನೊಂದಿಗೆ ಬೆರೆತು ಉಂಟುಮಾಡುವುದು ಏನು?",
            options = listOf("ಆಮ್ಲ ಮಳೆ (Acid Rain)", "ಹಸಿರುಮನೆ ಪರಿಣಾಮ", "ಓಝೋನ್ ರಂಧ್ರ", "ಹಿಮಪಾತ"),
            correctAnswer = "ಆಮ್ಲ ಮಳೆ (Acid Rain)",
            explanation = "ಸಲ್ಫರ್ ಡೈಆಕ್ಸೈಡ್ ಮತ್ತು ನೈಟ್ರೋಜನ್ ಆಕ್ಸೈಡ್‌ಗಳು ಮಳೆನೀರಿನಲ್ಲಿ ಕರಗಿ ಸಲ್ಫ್ಯೂರಿಕ್ ಆಮ್ಲ ಹಾಗೂ ನೈಟ್ರಿಕ್ ಆಮ್ಲಗಳಾಗಿ ಆಮ್ಲ ಮಳೆಯನ್ನು ಉಂಟುಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q16",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ತಾಜ್ ಮಹಲ್ ನಂತಹ ಅಮೃತಶಿಲೆಯ ಸ್ಮಾರಕಗಳು ಹಳದಿಯಾಗಲು ಮತ್ತು ಶಿಥಿಲಗೊಳ್ಳಲು (Marble cancer) ಪ್ರಮುಖ ಕಾರಣವೇನು?",
            options = listOf("ಆಮ್ಲ ಮಳೆ", "ಹೆಚ್ಚಿನ ಸೂರ್ಯನ ಬೆಳಕು", "ಭೂಕಂಪ", "ಧ್ವನಿ ಮಾಲಿನ್ಯ"),
            correctAnswer = "ಆಮ್ಲ ಮಳೆ",
            explanation = "ಆಮ್ಲ ಮಳೆಯಲ್ಲಿರುವ ಆಮ್ಲಗಳು ಅಮೃತಶಿಲೆಯಾದ ಕ್ಯಾಲ್ಸಿಯಂ ಕಾರ್ಬೊನೇಟ್ (CaCO₃) ನೊಂದಿಗೆ ವರ್ತಿಸಿ ಸ್ಮಾರಕಗಳನ್ನು ಸವೆಸುತ್ತವೆ (ಮಾರ್ಬಲ್ ಕ್ಯಾನ್ಸರ್)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q17",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಅಡುಗೆ ಅನಿಲವಾದ LPG ಸಿಲಿಂಡರ್‌ಗಳಿಂದ ಅನಿಲ ಸೋರಿಕೆಯನ್ನು ಸುಲಭವಾಗಿ ಗುರುತಿಸಲು ಬೆರೆಸುವ ದುರ್ವಾಸನೆಯುಳ್ಳ ರಾಸಾಯನಿಕ ಯಾವುದು?",
            options = listOf("ಈಥೈಲ್ ಮರ್ಕ್ಯಾಪ್ಟನ್ (Ethyl Mercaptan)", "ಮೀಥೇನ್", "ಕ್ಲೋರಿನ್", "ಬ್ಯುಟೇನ್"),
            correctAnswer = "ಈಥೈಲ್ ಮರ್ಕ್ಯಾಪ್ಟನ್ (Ethyl Mercaptan)",
            explanation = "LPG ಯ ಮೂಲ ಅನಿಲಗಳಾದ ಪ್ರೊಪೇನ್ ಮತ್ತು ಬ್ಯುಟೇನ್ ವಾಸನಾರಹಿತವಾಗಿರುತ್ತವೆ. ಸೋರಿಕೆಯ ಪತ್ತೆಗಾಗಿ ತೀಕ್ಷ್ಣ ವಾಸನೆಯ ಈಥೈಲ್ ಮರ್ಕ್ಯಾಪ್ಟನ್ ಬೆರೆಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q18",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ನವೀಕರಿಸಲಾಗದ (ತೀರಿಹೋಗುವ) ಶಕ್ತಿ ಮೂಲವಾಗಿದೆ?",
            options = listOf("ಕಲ್ಲಿದ್ದಲು ಮತ್ತು ಪೆಟ್ರೋಲಿಯಂ", "ಸೌರ ಶಕ್ತಿ", "ಪವನ ಶಕ್ತಿ", "ಜಲವಿದ್ಯುತ್ ಶಕ್ತಿ"),
            correctAnswer = "ಕಲ್ಲಿದ್ದಲು ಮತ್ತು ಪೆಟ್ರೋಲಿಯಂ",
            explanation = "ಕಲ್ಲಿದ್ದಲು ಮತ್ತು ಪೆಟ್ರೋಲಿಯಂ ಪಳೆಯುಳಿಕೆ ಇಂಧನಗಳಾಗಿದ್ದು, ಇವುಗಳ ನಿಕ್ಷೇಪಗಳು ಸೀಮಿತವಾಗಿದ್ದು ಪುನರುತ್ಪತ್ತಿಗೆ ಲಕ್ಷಾಂತರ ವರ್ಷಗಳು ಬೇಕಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q19",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಅಡುಗೆ ಮನೆಯಲ್ಲಿ ಅಡುಗೆ ತಯಾರಿಸಲು ಬಳಸುವ 'ವಿನೆಗರ್' (Vinegar) ನ ರಾಸಾಯನಿಕ ಹೆಸರೇನು?",
            options = listOf("ಸಾರರಿಕ್ತ ಅಸಿಟಿಕ್ ಆಮ್ಲ (Acetic acid)", "ಸಿಟ್ರಿಕ್ ಆಮ್ಲ", "ಟಾರ್ಟಾರಿಕ್ ಆಮ್ಲ", "ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಸಾರರಿಕ್ತ ಅಸಿಟಿಕ್ ಆಮ್ಲ (Acetic acid)",
            explanation = "ನೀರಿನಲ್ಲಿ 5-8% ಅಸಿಟಿಕ್ ಆಮ್ಲದ ದ್ರಾವಣವನ್ನು ವಿನೆಗರ್ ಎನ್ನಲಾಗುತ್ತದೆ. ಇದನ್ನು ಆಹಾರ ಸಂರಕ್ಷಕವಾಗಿ ಬಳಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u4_q20",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಹುಣಸೆಹಣ್ಣಿನಲ್ಲಿ ಪ್ರಮುಖವಾಗಿ ಕಂಡುಬರುವ ನೈಸರ್ಗಿಕ ಆಮ್ಲ ಯಾವುದು?",
            options = listOf("ಟಾರ್ಟಾರಿಕ್ ಆಮ್ಲ (Tartaric acid)", "ಆಕ್ಸಾಲಿಕ್ ಆಮ್ಲ", "ಲ್ಯಾಕ್ಟಿಕ್ ಆಮ್ಲ", "ಅಸ್ಕಾರ್ಬಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಟಾರ್ಟಾರಿಕ್ ಆಮ್ಲ (Tartaric acid)",
            explanation = "ಹುಣಸೆಹಣ್ಣು ಮತ್ತು ದ್ರಾಕ್ಷಿಯಲ್ಲಿ ಟಾರ್ಟಾರಿಕ್ ಆಮ್ಲ ಹೇರಳವಾಗಿ ಕಂಡುಬರುತ್ತದೆ."
        ),
        // ========================================================
        // ಘಟಕ 5: ಜೀವಕೋಶ, ಸೂಕ್ಷ್ಮಜೀವಿಗಳು ಮತ್ತು ಆರೋಗ್ಯ (Cell, Microorganisms & Health)
        // ========================================================
        QuestionModel(
            id = "nmms_sat_sci_u5_q1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "1665 ರಲ್ಲಿ ಕಾರ್ಕ್ ನ ತೆಳುವಾದ ಹೋಳಿನಲ್ಲಿ ಮೊಟ್ಟಮೊದಲ ಬಾರಿಗೆ ಜೀವಕೋಶವನ್ನು ಸಂಶೋಧಿಸಿದ ವಿಜ್ಞಾನಿ ಯಾರು?",
            options = listOf("ರಾಬರ್ಟ್ ಹುಕ್ (Robert Hooke)", "ರಾಬರ್ಟ್ ಬ್ರೌನ್", "ಲೂಯಿ ಪಾಶ್ಚರ್", "ಅಲೆಕ್ಸಾಂಡರ್ ಫ್ಲೆಮಿಂಗ್"),
            correctAnswer = "ರಾಬರ್ಟ್ ಹುಕ್ (Robert Hooke)",
            explanation = "ರಾಬರ್ಟ್ ಹುಕ್ 1665 ರಲ್ಲಿ ಸ್ವನಿರ್ಮಿತ ಸೂಕ್ಷ್ಮದರ್ಶಕದ ಅಡಿಯಲ್ಲಿ ಕಾರ್ಕ್ ಹೋಳನ್ನು ಪರೀಕ್ಷಿಸಿ 'ಜೀವಕೋಶ' (Cell) ಗಳನ್ನು ಕಂಡುಹಿಡಿದರು."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q2",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಜೀವಕೋಶದ ಎಲ್ಲಾ ಚಟುವಟಿಕೆಗಳನ್ನು ನಿಯಂತ್ರಿಸುವ 'ಜೀವಕೋಶದ ನಿಯಂತ್ರಣ ಕೇಂದ್ರ' ಯಾವುದು?",
            options = listOf("ಕೋಶಕೇಂದ್ರ (Nucleus)", "ಮೈಟೊಕಾಂಡ್ರಿಯಾ", "ರೈಬೋಸೋಮ್", "ಕೋಶದ್ರವ್ಯ"),
            correctAnswer = "ಕೋಶಕೇಂದ್ರ (Nucleus)",
            explanation = "ಕೋಶಕೇಂದ್ರವು ಕೋಶದ ಅನುವಂಶೀಯ ವಸ್ತುಗಳನ್ನು (DNA/ವರ್ಣತಂತುಗಳು) ಹೊಂದಿದ್ದು, ಕೋಶದ ಎಲ್ಲಾ ಜೈವಿಕ ಕ್ರಿಯೆಗಳನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q3",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಸ್ಯ ಜೀವಕೋಶಗಳಲ್ಲಿ ಮಾತ್ರ ಕಂಡುಬರುವ, ಕೋಶಕ್ಕೆ ರಕ್ಷಣೆ ಮತ್ತು ಆಕಾರವನ್ನು ನೀಡುವ ಹೊರಪದರ ಯಾವುದು?",
            options = listOf("ಕೋಶಭಿತ್ತಿ (Cell Wall)", "ಕೋಶಪೊರೆ (Cell Membrane)", "ನ್ಯೂಕ್ಲಿಯರ್ ಪೊರೆ", "ಕ್ಲೋರೊಪ್ಲಾಸ್ಟ್"),
            correctAnswer = "ಕೋಶಭಿತ್ತಿ (Cell Wall)",
            explanation = "ಸಸ್ಯ ಜೀವಕೋಶಗಳಲ್ಲಿ ಕೋಶಪೊರೆಯ ಹೊರಗೆ ಸೆಲ್ಯುಲೋಸ್‌ನಿಂದ ಮಾಡಲ್ಪಟ್ಟ ಗಟ್ಟಿಯಾದ ಕೋಶಭಿತ್ತಿ ಇರುತ್ತದೆ. ಇದು ಪ್ರಾಣಿ ಜೀವಕೋಶಗಳಲ್ಲಿ ಇರುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q4",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಜೀವಕೋಶದ ಶಕ್ತಿ ಉತ್ಪಾದನಾ ಕೇಂದ್ರ (Powerhouse of the Cell) ಎಂದು ಯಾವುದನ್ನು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಮೈಟೊಕಾಂಡ್ರಿಯಾ (Mitochondria)", "ಲೈಸೋಸೋಮ್", "ಗಾಲ್ಗಿ ಸಂಕೀರ್ಣ", "ಕ್ಲೋರೊಪ್ಲಾಸ್ಟ್"),
            correctAnswer = "ಮೈಟೊಕಾಂಡ್ರಿಯಾ (Mitochondria)",
            explanation = "ಮೈಟೊಕಾಂಡ್ರಿಯಾದಲ್ಲಿ ಕೋಶೀಯ ಉಸಿರಾಟ ನಡೆದು ATP ರೂಪದಲ್ಲಿ ಶಕ್ತಿ ಉತ್ಪತ್ತಿಯಾಗುವುದರಿಂದ ಇದನ್ನು ಶಕ್ತಿ ಉತ್ಪಾದನಾ ಕೇಂದ್ರ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q5",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳಲ್ಲಿ ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಗೆ ಅಗತ್ಯವಾದ ಹಸಿರು ವರ್ಣದ್ರವ್ಯವಾದ ಕ್ಲೋರೋಫಿಲ್ ಅನ್ನು ಹೊಂದಿರುವ ಕಣದಂಗ ಯಾವುದು?",
            options = listOf("ಹರಿತ್ಕಣ (Chloroplast)", "ಲ್ಯೂಕೋಪ್ಲಾಸ್ಟ್", "ಕ್ರೋಮೋಪ್ಲಾಸ್ಟ್", "ನಿರ್ನಾಳ ಕಣ"),
            correctAnswer = "ಹರಿತ್ಕಣ (Chloroplast)",
            explanation = "ಹರಿತ್ಕಣಗಳಲ್ಲಿ ಕ್ಲೋರೋಫಿಲ್ ವರ್ಣದ್ರವ್ಯವಿದ್ದು, ಇದು ಸೂರ್ಯನ ಬೆಳಕನ್ನು ಹೀರಿಕೊಂಡು ಆಹಾರ ತಯಾರಿಸಲು ನೆರವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q6",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಹಾಲನ್ನು ಮೊಸರನ್ನಾಗಿ ಪರಿವರ್ತಿಸಲು ಕಾರಣವಾಗುವ ಪ್ರಯೋಜನಕಾರಿ ಬ್ಯಾಕ್ಟೀರಿಯಾ ಯಾವುದು?",
            options = listOf("ಲ್ಯಾಕ್ಟೋಬ್ಯಾಸಿಲಸ್ (Lactobacillus)", "ರೈಸೋಬಿಯಂ", "ಸ್ಪೈರೊಗೈರಾ", "ಸಾಲ್ಮೊನೆಲ್ಲಾ"),
            correctAnswer = "ಲ್ಯಾಕ್ಟೋಬ್ಯಾಸಿಲಸ್ (Lactobacillus)",
            explanation = "ಲ್ಯಾಕ್ಟೋಬ್ಯಾಸಿಲಸ್ ಬ್ಯಾಕ್ಟೀರಿಯಾ ಹಾಲಿನಲ್ಲಿ ಗುಣಿಸಿ, ಲ್ಯಾಕ್ಟೋಸ್ ಸಕ್ಕರೆಯನ್ನು ಲ್ಯಾಕ್ಟಿಕ್ ಆಮ್ಲವನ್ನಾಗಿ ಪರಿವರ್ತಿಸಿ ಮೊಸರನ್ನಾಗಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q7",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ದ್ವಿದಳ ಧಾನ್ಯ ಸಸ್ಯಗಳ ಬೇರು ಗಂಟುಗಳಲ್ಲಿ ವಾಸಿಸುತ್ತಾ ವಾತಾವರಣದ ಸಾರಜನಕವನ್ನು ಸ್ಥಿರೀಕರಿಸುವ ಬ್ಯಾಕ್ಟೀರಿಯಾ ಯಾವುದು?",
            options = listOf("ರೈಸೋಬಿಯಂ (Rhizobium)", "ಅಮೀಬಾ", "ಪೆನಿಸಿಲಿಯಂ", "ಲ್ಯಾಕ್ಟೋಬ್ಯಾಸಿಲಸ್"),
            correctAnswer = "ರೈಸೋಬಿಯಂ (Rhizobium)",
            explanation = "ರೈಸೋಬಿಯಂ ಬ್ಯಾಕ್ಟೀರಿಯಾಗಳು ದ್ವಿದಳ ಧಾನ್ಯಗಳ ಬೇರು ಗಂಟುಗಳಲ್ಲಿ ಸಹಜೀವನ ನಡೆಸುತ್ತಾ ವಾತಾವರಣದ ಸಾರಜನಕವನ್ನು ಮಣ್ಣಿನಲ್ಲಿ ಸ್ಥಿರೀಕರಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q8",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಕ್ಕರೆಯನ್ನು ಆಲ್ಕೋಹಾಲ್ ಆಗಿ ಪರಿವರ್ತಿಸುವ ಪ್ರಕ್ರಿಯೆಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಕಿಣ್ವನ (Fermentation)", "ಪಾಶ್ಚರೀಕರಣ", "ಸಾರಜನಕ ಸ್ಥಿರೀಕರಣ", "ತಟಸ್ಥೀಕರಣ"),
            correctAnswer = "ಕಿಣ್ವನ (Fermentation)",
            explanation = "ಯೀಸ್ಟ್‌ನಂತಹ ಸೂಕ್ಷ್ಮಜೀವಿಗಳ ಸಹಾಯದಿಂದ ಸಕ್ಕರೆಯನ್ನು ಆಲ್ಕೋಹಾಲ್ ಮತ್ತು CO₂ ಆಗಿ ಪರಿವರ್ತಿಸುವ ಕ್ರಿಯೆಯನ್ನು ಕಿಣ್ವನ (Fermentation) ಎನ್ನುತ್ತಾರೆ. ಇದನ್ನು ಲೂಯಿ ಪಾಶ್ಚರ್ 1857 ರಲ್ಲಿ ಶೋಧಿಸಿದರು."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q9",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "1928 ರಲ್ಲಿ ಪ್ರಪಂಚದ ಮೊದಲ ಪ್ರತಿಜೀವಕವಾದ 'ಪೆನ್ಸಿಲಿನ್' ಅನ್ನು ಕಂಡುಹಿಡಿದ ವಿಜ್ಞಾನಿ ಯಾರು?",
            options = listOf("ಅಲೆಕ್ಸಾಂಡರ್ ಫ್ಲೆಮಿಂಗ್ (Alexander Fleming)", "ಎಡ್ವರ್ಡ್ ಜೆನ್ನರ್", "ರಾಬರ್ಟ್ ಕೋಚ್", "ಲೂಯಿ ಪಾಶ್ಚರ್"),
            correctAnswer = "ಅಲೆಕ್ಸಾಂಡರ್ ಫ್ಲೆಮಿಂಗ್ (Alexander Fleming)",
            explanation = "ಅಲೆಕ್ಸಾಂಡರ್ ಫ್ಲೆಮಿಂಗ್ ಅವರು ಪೆನ್ಸಿಲಿಯಂ ನೊಟೇಟಮ್ ಎಂಬ ಶಿಲೀಂಧ್ರದಿಂದ ಮೊದಲ ಆ್ಯಂಟಿಬಯೋಟಿಕ್ 'ಪೆನ್ಸಿಲಿನ್' ತಯಾರಿಸಿದರು."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q10",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮಲೇರಿಯಾ ರೋಗವನ್ನು ಹರಡುವ ರೋಗವಾಹಕ ಕೀಟ ಯಾವುದು?",
            options = listOf("ಹೆಣ್ಣು ಅನಾಫಿಲಿಸ್ ಸೊಳ್ಳೆ (Female Anopheles mosquito)", "ಹೆಣ್ಣು ಈಡಿಸ್ ಸೊಳ್ಳೆ", "ಜಿಪ್ಸಿ ನೊಣ", "ಮನೆ ನೊಣ"),
            correctAnswer = "ಹೆಣ್ಣು ಅನಾಫಿಲಿಸ್ ಸೊಳ್ಳೆ (Female Anopheles mosquito)",
            explanation = "ಹೆಣ್ಣು ಅನಾಫಿಲಿಸ್ ಸೊಳ್ಳೆಯು ಪ್ಲಾಸ್ಮೋಡಿಯಂ ಪ್ರೋಟೋಜೋವಾವನ್ನು ಮನುಷ್ಯನ ರಕ್ತಕ್ಕೆ ವರ್ಗಾಯಿಸಿ ಮಲೇರಿಯಾ ರೋಗವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q11",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಡೆಂಗ್ಯೂ ಜ್ವರವನ್ನು ಉಂಟುಮಾಡುವ ವೈರಸ್‌ನ ಪ್ರಮುಖ ರೋಗವಾಹಕ ಯಾವುದು?",
            options = listOf("ಹೆಣ್ಣು ಈಡಿಸ್ ಸೊಳ್ಳೆ (Female Aedes mosquito)", "ಅನಾಫಿಲಿಸ್ ಸೊಳ್ಳೆ", "ಕ್ಯೂಲೆಕ್ಸ್ ಸೊಳ್ಳೆ", "ಮರಳು ನೊಣ"),
            correctAnswer = "ಹೆಣ್ಣು ಈಡಿಸ್ ಸೊಳ್ಳೆ (Female Aedes mosquito)",
            explanation = "ಡೆಂಗ್ಯೂ ವೈರಸ್ ಹೆಣ್ಣು ಈಡಿಸ್ ಈಜಿಪ್ಟಿ ಸೊಳ್ಳೆಯ ಕಡಿತದಿಂದ ಹರಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q12",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಹಾಲನ್ನು 70°C ತಾಪಮಾನದಲ್ಲಿ 15-30 ಸೆಕೆಂಡುಗಳ ಕಾಲ ಕಾಯಿಸಿ ತಕ್ಷಣವೇ ತಂಪುಗೊಳಿಸಿ ಸಂರಕ್ಷಿಸುವ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಪಾಶ್ಚರೀಕರಣ (Pasteurisation)", "ಕುದಿಯುವಿಕೆ", "ನಿರ್ಜಲೀಕರಣ", "ಘನೀಕರಣ"),
            correctAnswer = "ಪಾಶ್ಚರೀಕರಣ (Pasteurisation)",
            explanation = "ಲೂಯಿ ಪಾಶ್ಚರ್ ಕಂಡುಹಿಡಿದ ಪಾಶ್ಚರೀಕರಣ ವಿಧಾನದಲ್ಲಿ ಹಾನಿಕಾರಕ ಸೂಕ್ಷ್ಮಾಣುಜೀವಿಗಳು ನಾಶವಾಗುತ್ತವೆ ಮತ್ತು ಹಾಲು ಕೆಡದಂತೆ ಉಳಿಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q13",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಜಾಮ್, ಜೆಲ್ಲಿ ಮತ್ತು ಉಪ್ಪಿನಕಾಯಿಗಳಂತಹ ಆಹಾರ ಪದಾರ್ಥಗಳನ್ನು ಸಂರಕ್ಷಿಸಲು ಬಳಸುವ ರಾಸಾಯನಿಕ ಸಂರಕ್ಷಕ ಯಾವುದು?",
            options = listOf("ಸೋಡಿಯಂ ಬೆಂಜೋಯೇಟ್ ಮತ್ತು ಸೋಡಿಯಂ ಮೆಟಾಬೈಸಲ್ಫೈಟ್", "ಕ್ಯಾಲ್ಸಿಯಂ ಕಾರ್ಬೊನೇಟ್", "ಮೆಗ್ನೀಸಿಯಂ ಆಕ್ಸೈಡ್", "ಕಾಪರ್ ಸಲ್ಫೇಟ್"),
            correctAnswer = "ಸೋಡಿಯಂ ಬೆಂಜೋಯೇಟ್ ಮತ್ತು ಸೋಡಿಯಂ ಮೆಟಾಬೈಸಲ್ಫೈಟ್",
            explanation = "ಸೋಡಿಯಂ ಬೆಂಜೋಯೇಟ್ ಮತ್ತು ಸೋಡಿಯಂ ಮೆಟಾಬೈಸಲ್ಫೈಟ್‌ಗಳು ಸೂಕ್ಷ್ಮಜೀವಿಗಳ ಬೆಳವಣಿಗೆಯನ್ನು ತಡೆಯುವ ರಾಸಾಯನಿಕ ಆಹಾರ ಸಂರಕ್ಷಕಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q14",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ದೇಹದಲ್ಲಿ ರಕ್ತದಲ್ಲಿನ ಗ್ಲೂಕೋಸ್ ಮಟ್ಟವನ್ನು ನಿಯಂತ್ರಿಸುವ ಇನ್ಸುಲಿನ್ ಹಾರ್ಮೋನ್ ಅನ್ನು ಸ್ರವಿಸುವ ಗ್ರಂಥಿ ಯಾವುದು?",
            options = listOf("ಮೇದೋಜೀರಕ ಗ್ರಂಥಿ (Pancreas)", "ಪಿಟ್ಯುಟರಿ ಗ್ರಂಥಿ", "ಥೈರಾಯ್ಡ್ ಗ್ರಂಥಿ", "ಅಡ್ರಿನಲ್ ಗ್ರಂಥಿ"),
            correctAnswer = "ಮೇದೋಜೀರಕ ಗ್ರಂಥಿ (Pancreas)",
            explanation = "ಮೇದೋಜೀರಕ ಗ್ರಂಥಿಯು ಇನ್ಸುಲಿನ್ ಹಾರ್ಮೋನ್ ಸ್ರವಿಸುತ್ತದೆ. ಇದರ ಕೊರತೆಯಿಂದ ಸಕ್ಕರೆ ಕಾಯಿಲೆ (ಡಯಾಬಿಟಿಸ್) ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q15",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಆಹಾರದಲ್ಲಿ ಅಯೋಡಿನ್ ಕೊರತೆಯಿಂದ ಥೈರಾಯ್ಡ್ ಗ್ರಂಥಿ ಊದಿಕೊಳ್ಳುವ ರೋಗ ಯಾವುದು?",
            options = listOf("ಗಳಗಂಡ ರೋಗ (Goitre)", "ಅನೀಮಿಯಾ", "ರಿಕೇಟ್ಸ್", "ಸ್ಕರ್ವಿ"),
            correctAnswer = "ಗಳಗಂಡ ರೋಗ (Goitre)",
            explanation = "ಅಯೋಡಿನ್ ಕೊರತೆಯಿಂದ ಥೈರಾಕ್ಸಿನ್ ಹಾರ್ಮೋನ್ ಉತ್ಪತ್ತಿಯಾಗದೆ ಕತ್ತಿನ ಭಾಗದಲ್ಲಿರುವ ಥೈರಾಯ್ಡ್ ಗ್ರಂಥಿ ಹಿಗ್ಗಿ ಗಳಗಂಡ ರೋಗ ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q16",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮಾನವನ ದೇಹದಲ್ಲಿ 'ತುರ್ತು ಪರಿಸ್ಥಿತಿಯ ಹಾರ್ಮೋನ್' (Emergency Hormone) ಎಂದು ಕರೆಯಲ್ಪಡುವ ಅಡ್ರಿನಾಲಿನ್ ಅನ್ನು ಸ್ರವಿಸುವ ಗ್ರಂಥಿ ಯಾವುದು?",
            options = listOf("ಅಡ್ರಿನಲ್ ಗ್ರಂಥಿ (Adrenal Gland)", "ಪಿಟ್ಯುಟರಿ ಗ್ರಂಥಿ", "ವೃಷಣ", "ಅಂಡಾಶಯ"),
            correctAnswer = "ಅಡ್ರಿನಲ್ ಗ್ರಂಥಿ (Adrenal Gland)",
            explanation = "ಮೂತ್ರಪಿಂಡಗಳ ಮೇಲಿರುವ ಅಡ್ರಿನಲ್ ಗ್ರಂಥಿಗಳು ಅಡ್ರಿನಾಲಿನ್ ಹಾರ್ಮೋನ್ ಸ್ರವಿಸಿ ಕೋಪ, ಭಯ, ಒತ್ತಡದ ಸಂದರ್ಭಗಳಲ್ಲಿ ದೇಹವನ್ನು ಸಮತೋಲನದಲ್ಲಿಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q17",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ರಕ್ತದಲ್ಲಿ ಹಿಮೋಗ್ಲೋಬಿನ್ ಕೊರತೆಯಿಂದ ಉಂಟಾಗುವ ರೋಗ ಯಾವುದು?",
            options = listOf("ರಕ್ತಹೀನತೆ (Anemia)", "ಬೇರಿಬೇರಿ", "ಸ್ಕರ್ವಿ", "ರಾತ್ರಿ ಕುರುಡುತನ"),
            correctAnswer = "ರಕ್ತಹೀನತೆ (Anemia)",
            explanation = "ಆಹಾರದಲ್ಲಿ ಕಬ್ಬಿಣಾಂಶದ (Iron) ಕೊರತೆಯಿಂದ ಹಿಮೋಗ್ಲೋಬಿನ್ ಕಡಿಮೆಯಾಗಿ ರಕ್ತಹೀನತೆ (ಅನೀಮಿಯಾ) ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q18",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ವಿಟಮಿನ್ 'ಸಿ' ಕೊರತೆಯಿಂದ ವಸಡುಗಳಿಂದ ರಕ್ತ ಸೋರುವ ರೋಗ ಯಾವುದು?",
            options = listOf("ಸ್ಕರ್ವಿ (Scurvy)", "ರಿಕೇಟ್ಸ್", "ಬೆರಿಬೆರಿ", "ಗಳಗಂಡ"),
            correctAnswer = "ಸ್ಕರ್ವಿ (Scurvy)",
            explanation = "ವಿಟಮಿನ್ 'ಸಿ' ಕೊರತೆಯಿಂದ ಸ್ಕರ್ವಿ ರೋಗ ಬರುತ್ತದೆ. ಇದು ವಸಡುಗಳಲ್ಲಿ ರಕ್ತಸ್ರಾವಕ್ಕೆ ಕಾರಣವಾಗುತ್ತದೆ. ಸಿಟ್ರಸ್ ಹಣ್ಣುಗಳಲ್ಲಿ ವಿಟಮಿನ್ ಸಿ ಹೇರಳವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q19",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮಾನವನ ದೇಹದಲ್ಲಿರುವ ಅತ್ಯಂತ ಉದ್ದವಾದ ಜೀವಕೋಶ ಯಾವುದು?",
            options = listOf("ನರ ಕೋಶ (Neuron)", "ಸ್ನಾಯು ಕೋಶ", "ಕೆಂಪು ರಕ್ತ ಕಣ (RBC)", "ಅಂಡಾಣು"),
            correctAnswer = "ನರ ಕೋಶ (Neuron)",
            explanation = "ನರಕೋಶಗಳು (Neurons) ಮಾನವನ ಶರೀರದಲ್ಲಿ ಅತ್ಯಂತ ಉದ್ದವಾದ ಜೀವಕೋಶಗಳಾಗಿದ್ದು, ಇವು ಸಂದೇಶಗಳನ್ನು ಸಂವಹನ ಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u5_q20",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸ್ಪಷ್ಟವಾದ ಕೋಶಕೇಂದ್ರ ಪೊರೆ ಇಲ್ಲದಿರುವ ಪ್ರಾಚೀನ ಜೀವಕೋಶಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಪ್ರೊಕ್ಯಾರಿಯೋಟಿಕ್ ಕೋಶಗಳು (Prokaryotic cells)", "ಯೂಕ್ಯಾರಿಯೋಟಿಕ್ ಕೋಶಗಳು", "ಬಹುಕೋಶೀಯ ಜೀವಿಗಳು", "ಸಂಕೀರ್ಣ ಕೋಶಗಳು"),
            correctAnswer = "ಪ್ರೊಕ್ಯಾರಿಯೋಟಿಕ್ ಕೋಶಗಳು (Prokaryotic cells)",
            explanation = "ಬ್ಯಾಕ್ಟೀರಿಯಾ ಮತ್ತು ನೀಲಿ-ಹಸಿರು ಪಾಚಿಗಳಲ್ಲಿ ಸುಸ್ಪಷ್ಟ ಕೋಶಕೇಂದ್ರ ಪೊರೆ ಇರುವುದಿಲ್ಲ. ಇವುಗಳನ್ನು ಪ್ರೊಕ್ಯಾರಿಯೋಟಿಕ್ ಜೀವಕೋಶಗಳು ಎನ್ನುತ್ತಾರೆ."
        ),
        // ========================================================
        // ಘಟಕ 6: ಬೆಳೆ ಉತ್ಪಾದನೆ, ಪ್ರಾಣಿಗಳಲ್ಲಿ ಸಂತಾನೋತ್ಪತ್ತಿ ಮತ್ತು ಪರಿಸರ ಸಂರಕ್ಷಣೆ (Crops, Reproduction & Conservation)
        // ========================================================
        QuestionModel(
            id = "nmms_sat_sci_u6_q1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮಳೆಗಾಲದಲ್ಲಿ (ಜೂನ್ ನಿಂದ ಸೆಪ್ಟೆಂಬರ್) ಬೆಳೆಯಲಾಗುವ ಬೆಳೆಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಖಾರಿಫ್ ಬೆಳೆಗಳು (Kharif crops)", "ರಬಿ ಬೆಳೆಗಳು (Rabi crops)", "ಜೈದ್ ಬೆಳೆಗಳು", "ವಾಣಿಜ್ಯ ಬೆಳೆಗಳು"),
            correctAnswer = "ಖಾರಿಫ್ ಬೆಳೆಗಳು (Kharif crops)",
            explanation = "ಮಳೆಗಾಲದಲ್ಲಿ ಬೆಳೆಯುವ ಬೆಳೆಗಳನ್ನು ಖಾರಿಫ್ ಬೆಳೆಗಳು ಎನ್ನುತ್ತಾರೆ (ಉದಾ: ಭತ್ತ, ಮೆಕ್ಕೆಜೋಳ, ಸೋಯಾಬೀನ್, ಕಡಲೆಕಾಯಿ, ಹತ್ತಿ)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q2",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಚಳಿಗಾಲದಲ್ಲಿ (ಅಕ್ಟೋಬರ್ ನಿಂದ ಮಾರ್ಚ್) ಬೆಳೆಯಲಾಗುವ ಗೋಧಿ, ಕಡಲೆ, ಸಾಸಿವೆ ಬೆಳೆಗಳು ಯಾವ ವರ್ಗಕ್ಕೆ ಸೇರಿವೆ?",
            options = listOf("ರಬಿ ಬೆಳೆಗಳು (Rabi crops)", "ಖಾರಿಫ್ ಬೆಳೆಗಳು", "ಬೇಸಿಗೆ ಬೆಳೆಗಳು", "ತೋಟಗಾರಿಕಾ ಬೆಳೆಗಳು"),
            correctAnswer = "ರಬಿ ಬೆಳೆಗಳು (Rabi crops)",
            explanation = "ಚಳಿಗಾಲದಲ್ಲಿ ಬಿತ್ತನೆ ಮಾಡಿ ಬೆಳೆಯುವ ಬೆಳೆಗಳನ್ನು ರಬಿ ಬೆಳೆಗಳು ಎನ್ನುತ್ತಾರೆ (ಉದಾ: ಗೋಧಿ, ಬಾರ್ಲಿ, ಕಡಲೆ, ಬಟಾಣಿ, ಸಾಸಿವೆ)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q3",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಹನಿ ನೀರಾವರಿ (Drip irrigation) ಪದ್ಧತಿಯ ಪ್ರಮುಖ ಪ್ರಯೋಜನವೇನು?",
            options = listOf("ನೀರು ಹನಿ ಹನಿಯಾಗಿ ನೇರವಾಗಿ ಬೇರುಗಳಿಗೆ ತಲುಪಿ ನೀರಿನ ಅಪವ್ಯಯ ತಡೆಯುವುದು", "ಹೆಚ್ಚು ನೀರನ್ನು ವ್ಯರ್ಥ ಮಾಡುವುದು", "ಕಳೆಗಳನ್ನು ಬೆಳೆಸುವುದು", "ಮಣ್ಣಿನ ಸವೆತ ಉಂಟುಮಾಡುವುದು"),
            correctAnswer = "ನೀರು ಹನಿ ಹನಿಯಾಗಿ ನೇರವಾಗಿ ಬೇರುಗಳಿಗೆ ತಲುಪಿ ನೀರಿನ ಅಪವ್ಯಯ ತಡೆಯುವುದು",
            explanation = "ಹನಿ ನೀರಾವರಿಯು ಅತ್ಯಂತ ಮಿತವ್ಯಯಕಾರಿ ವಿಧಾನವಾಗಿದ್ದು, ನೀರು ನೇರವಾಗಿ ಸಸ್ಯಗಳ ಬೇರಿನ ಬಳಿಯೇ ತೊಟ್ಟಿಕ್ಕುವುದರಿಂದ ನೀರಿನ ಅಭಾವವಿರುವ ಪ್ರದೇಶಗಳಿಗೆ ವರದಾನವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q4",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮುಖ್ಯ ಬೆಳೆಗಳ ಜೊತೆಯಲ್ಲಿ ಅನಗತ್ಯವಾಗಿ ಬೆಳೆಯುವ ಕಳೆ ಸಸ್ಯಗಳನ್ನು ನಾಶಪಡಿಸಲು ಬಳಸುವ ರಾಸಾಯನಿಕಗಳಿಗೆ ಏನೆನ್ನುತ್ತಾರೆ?",
            options = listOf("ಕಳೆನಾಶಕಗಳು (Weedicides - ಉದಾ: 2,4-D)", "ಕೀಟನಾಶಕಗಳು", "ರಸಗೊಬ್ಬರಗಳು", "ಶಿಲೀಂಧ್ರನಾಶಕಗಳು"),
            correctAnswer = "ಕಳೆನಾಶಕಗಳು (Weedicides - ಉದಾ: 2,4-D)",
            explanation = "ಬೆಳೆಗಳ ಪೋಷಕಾಂಶ, ನೀರು ಮತ್ತು ಸೂರ್ಯನ ಬೆಳಕನ್ನು ಕಸಿಯುವ ಕಳೆಗಳನ್ನು ಕೊಲ್ಲಲು 2,4-D ನಂತಹ ಕಳೆನಾಶಕಗಳನ್ನು ಸಿಂಪಡಿಸುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q5",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಹೈಡ್ರಾ (Hydra) ಜೀವಿಗಳಲ್ಲಿ ನಡೆಯುವ ಅಲೈಂಗಿಕ ಸಂತಾನೋತ್ಪತ್ತಿಯ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಮೊಗ್ಗುಡುವಿಕೆ (Budding)", "ದ್ವಿದಳನ (Binary fission)", "ಪುನರುತ್ಪತ್ತಿ", "ಕಾಯಜ ಪ್ರಸರಣ"),
            correctAnswer = "ಮೊಗ್ಗುಡುವಿಕೆ (Budding)",
            explanation = "ಹೈಡ್ರಾದ ಶರೀರದಲ್ಲಿ ಸಣ್ಣ ಉಬ್ಬು (ಮೊಗ್ಗು) ಬೆಳೆದು, ಪ್ರತ್ಯೇಕ ಜೀವಿಗಳಾಗಿ ಬೇರ್ಪಡುವ ಪ್ರಕ್ರಿಯೆಗೆ ಮೊಗ್ಗುಡುವಿಕೆ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q6",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಅಮೀಬಾದಲ್ಲಿ (Amoeba) ಸಂತಾನೋತ್ಪತ್ತಿಯು ಸಾಮಾನ್ಯವಾಗಿ ಯಾವ ವಿಧಾನದಲ್ಲಿ ನಡೆಯುತ್ತದೆ?",
            options = listOf("ದ್ವಿದಳನ (Binary Fission)", "ಮೊಗ್ಗುಡುವಿಕೆ", "ಕಲಿಕೋತ್ಪತ್ತಿ", "ಲಿಂಗಾಣು ಸಂಯೋಗ"),
            correctAnswer = "ದ್ವಿದಳನ (Binary Fission)",
            explanation = "ಏಕಕೋಶೀಯ ಅಮೀಬಾದ ಕೋಶಕೇಂದ್ರ ಮತ್ತು ಕೋಶದ್ರವ್ಯ ಎರಡು ಸಮಾನ ಭಾಗಗಳಾಗಿ ವಿಭಜನೆಗೊಳ್ಳುವ ಪ್ರಕ್ರಿಯೆಯೇ ದ್ವಿದಳನ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q7",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕಪ್ಪೆ ಮತ್ತು ಮೀನುಗಳಲ್ಲಿ ನಿಷೇಚನ ಕ್ರಿಯೆಯು ಎಲ್ಲಿ ನಡೆಯುತ್ತದೆ?",
            options = listOf("ದೇಹದ ಹೊರಗೆ (ಬಾಹ್ಯ ನಿಷೇಚನ - External Fertilization)", "ದೇಹದ ಒಳಗೆ (ಆಂತರಿಕ ನಿಷೇಚನ)", "ಗಾಳಿಯಲ್ಲಿ", "ಅಂಡಾಶಯದಲ್ಲಿ"),
            correctAnswer = "ದೇಹದ ಹೊರಗೆ (ಬಾಹ್ಯ ನಿಷೇಚನ - External Fertilization)",
            explanation = "ಕಪ್ಪೆಗಳು ಮತ್ತು ಮೀನುಗಳು ನೀರಿನಲ್ಲಿ ಅಂಡಾಣು ಮತ್ತು ವೀರ್ಯಾಣುಗಳನ್ನು ವಿಸರ್ಜಿಸುತ್ತವೆ, ನೀರಿನ ಮಾಧ್ಯಮದಲ್ಲೇ ಸಂಯೋಗವಾಗುವುದರಿಂದ ಇದು ಬಾಹ್ಯ ನಿಷೇಚನ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q8",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮೊಟ್ಟೆಗಳನ್ನು ಇಡುವ ಮೂಲಕ ಮರಿ ಮಾಡುವ ಪ್ರಾಣಿಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಅಂಡಜ ಪ್ರಾಣಿಗಳು (Oviparous animals)", "ಜರಾಯುಜ ಪ್ರಾಣಿಗಳು (Viviparous animals)", "ಸ್ತನಿಗಳು", "ಉಭಯವಾಸಿಗಳು"),
            correctAnswer = "ಅಂಡಜ ಪ್ರಾಣಿಗಳು (Oviparous animals)",
            explanation = "ಮೊಟ್ಟೆ ಇಡುವ ಪ್ರಾಣಿಗಳನ್ನು ಅಂಡಜ ಪ್ರಾಣಿಗಳು (Oviparous) ಎನ್ನುತ್ತಾರೆ (ಉದಾ: ಹಕ್ಕಿಗಳು, ಹಾವುಗಳು, ಕಪ್ಪೆಗಳು). ನೇರವಾಗಿ ಮರಿ ಹಾಕುವ ಪ್ರಾಣಿಗಳು ಜರಾಯುಜ (Viviparous)."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q9",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕಪ್ಪೆಯ ಗೊದಮೊಟ್ಟೆಯು (Tadpole) ರೂಪಾಂತರಗೊಂಡು ಪ್ರೌಢ ಕಪ್ಪೆಯಾಗುವ ಪ್ರಕ್ರಿಯೆಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ರೂಪಾಂತರ (Metamorphosis)", "ನಿಷೇಚನ", "ಅಂಗಜನನ", "ಬೀಜಾಂಕುರಣ"),
            correctAnswer = "ರೂಪಾಂತರ (Metamorphosis)",
            explanation = "ಕೀಟಗಳು ಮತ್ತು ಕಪ್ಪೆಗಳಲ್ಲಿ ಲಾರ್ವಾ ಹಂತದಿಂದ ತೀವ್ರ ಬದಲಾವಣೆಗಳ ಮೂಲಕ ಪ್ರೌಢ ಜೀವಿಯಾಗಿ ಮಾರ್ಪಾಡಾಗುವುದನ್ನು ರೂಪಾಂತರ (Metamorphosis) ಎನ್ನುತ್ತಾರೆ. ಇದಕ್ಕೆ ಥೈರಾಕ್ಸಿನ್ ಹಾರ್ಮೋನ್ ಅಗತ್ಯ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q10",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಪ್ರಪಂಚದ ಮೊದಲ ತದ್ರೂಪಿ (Cloned) ಸಸ್ತನಿಯಾದ 'ಡಾಲಿ' (Dolly) ಯಾವ ಪ್ರಾಣಿಯಾಗಿದೆ?",
            options = listOf("ಕುರಿ (Sheep)", "ಹಸು", "ನಾಯಿ", "ಬೆಕ್ಕು"),
            correctAnswer = "ಕುರಿ (Sheep)",
            explanation = "ಇಯಾನ್ ವಿಲ್ಮಟ್ ಮತ್ತು ಸಹೋದ್ಯೋಗಿಗಳು 1996 ರಲ್ಲಿ ರೋಸ್ಲಿನ್ ಸಂಸ್ಥೆಯಲ್ಲಿ ಕ್ಲೋನಿಂಗ್ ಮೂಲಕ 'ಡಾಲಿ' ಎಂಬ ಕುರಿಯನ್ನು ಸೃಷ್ಟಿಸಿದರು."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q11",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಅಳಿವಿನಂಚಿನಲ್ಲಿರುವ ಸಸ್ಯ ಮತ್ತು ಪ್ರಾಣಿ ಪ್ರಭೇದಗಳ ದಾಖಲೆಯನ್ನು ಹೊಂದಿರುವ ಅಧಿಕೃತ ಪುಸ್ತಕ ಯಾವುದು?",
            options = listOf("ರೆಡ್ ಡೇಟಾ ಬುಕ್ (Red Data Book)", "ಗ್ರೀನ್ ಡೇಟಾ ಬುಕ್", "ಬ್ಲೂ ಬುಕ್", "ವೈಲ್ಡ್ ಲೈಫ್ ಬುಕ್"),
            correctAnswer = "ರೆಡ್ ಡೇಟಾ ಬುಕ್ (Red Data Book)",
            explanation = "IUCN ಸಂಸ್ಥೆಯು ಅಳಿವಿನಂಚಿನಲ್ಲಿರುವ ಸಸ್ಯಗಳು ಮತ್ತು ವನ್ಯಪ್ರಾಣಿಗಳ ಸ್ಥಿತಿಗತಿಯನ್ನು 'ರೆಡ್ ಡೇಟಾ ಬುಕ್'ನಲ್ಲಿ ದಾಖಲಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q12",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಭಾರತದ ಮೊದಲ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ (National Park) ಯಾವುದು?",
            options = listOf("ಜಿಮ್ ಕಾರ್ಬೆಟ್ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ (ಉತ್ತರಾಖಂಡ)", "ಬಂಡೀಪುರ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ", "ಕಾಜಿರಂಗ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ", "ಗಿರ್ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ"),
            correctAnswer = "ಜಿಮ್ ಕಾರ್ಬೆಟ್ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ (ಉತ್ತರಾಖಂಡ)",
            explanation = "1936 ರಲ್ಲಿ ಸ್ಥಾಪನೆಯಾದ ಜಿಮ್ ಕಾರ್ಬೆಟ್ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ (ಹೇಲೀ ನ್ಯಾಷನಲ್ ಪಾರ್ಕ್) ಭಾರತದ ಪ್ರಪ್ರಥಮ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q13",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದಲ್ಲಿ ಹುಲಿಗಳ ಸಂರಕ್ಷಣೆಗಾಗಿ ಪ್ರಸಿದ್ಧವಾಗಿರುವ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನ ಯಾವುದು?",
            options = listOf("ಬಂಡೀಪುರ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ", "ಬನ್ನೇರುಘಟ್ಟ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ", "ಕೂದ್ರೇಮುಖ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ", "ಅಣಶಿ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ"),
            correctAnswer = "ಬಂಡೀಪುರ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನ",
            explanation = "ಚಾಮರಾಜನಗರ ಜಿಲ್ಲೆಯಲ್ಲಿರುವ ಬಂಡೀಪುರ ರಾಷ್ಟ್ರೀಯ ಉದ್ಯಾನವನವು ಪ್ರಾಜೆಕ್ಟ್ ಟೈಗರ್ ಅಡಿಯಲ್ಲಿ ಹುಲಿ ಸಂರಕ್ಷಣಾ ಪ್ರದೇಶವಾಗಿ ಖ್ಯಾತಿ ಪಡೆದಿದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q14",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ನಿರ್ದಿಷ್ಟ ಭೌಗೋಳಿಕ ಪ್ರದೇಶದಲ್ಲಿ ಮಾತ್ರ ಪ್ರತ್ಯೇಕವಾಗಿ ಕಂಡುಬರುವ ಸಸ್ಯ ಮತ್ತು ಪ್ರಾಣಿ ಪ್ರಭೇದಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸ್ಥಳೀಯ ಪ್ರಭೇದಗಳು (Endemic Species)", "ವಿದೇಶಿ ಪ್ರಭೇದಗಳು", "ಅಳಿದುಹೋದ ಪ್ರಭೇದಗಳು", "ವಿಶೇಷ ಪ್ರಭೇದಗಳು"),
            correctAnswer = "ಸ್ಥಳೀಯ ಪ್ರಭೇದಗಳು (Endemic Species)",
            explanation = "ಯಾವುದೇ ನಿರ್ದಿಷ್ಟ ಪ್ರದೇಶ ಅಥವಾ ಕಾಡಿಗೆ ಮಾತ್ರ ಸೀಮಿತವಾಗಿ ಸ್ವಾಭಾವಿಕವಾಗಿ ಕಂಡುಬರುವ ಪ್ರಭೇದಗಳನ್ನು ಸ್ಥಳೀಯ (Endemic) ಪ್ರಭೇದಗಳು ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q15",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ವಾತಾವರಣದಲ್ಲಿ ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂) ಪ್ರಮಾಣ ಹೆಚ್ಚಾಗುವುದರಿಂದ ಭೂಮಿಯ ತಾಪಮಾನ ಏರಿಕೆಯಾಗುವ ವಿದ್ಯಮಾನ ಯಾವುದು?",
            options = listOf("ಜಾಗತಿಕ ತಾಪಮಾನ ಏರಿಕೆ (Global Warming)", "ಓಝೋನ್ ಸವಕಳಿ", "ಆಮ್ಲ ಮಳೆ", "ಅರಣ್ಯನಾಶ"),
            correctAnswer = "ಜಾಗತಿಕ ತಾಪಮಾನ ಏರಿಕೆ (Global Warming)",
            explanation = "ಹಸಿರುಮನೆ ಅನಿಲಗಳಾದ CO₂, ಮೀಥೇನ್ ಇತ್ಯಾದಿಗಳು ಸೂರ್ಯನ ಉಷ್ಣ ವಿಕಿರಣಗಳನ್ನು ಹಿಡಿದಿಟ್ಟುಕೊಂಡು ಭೂಮಿಯ ಸರಾಸರಿ ಉಷ್ಣತೆಯನ್ನು ಹೆಚ್ಚಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q16",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸೂರ್ಯನಿಂದ ಬರುವ ಹಾನಿಕಾರಕ ಅಲ್ಟ್ರಾವೈಲೆಟ್ (ಯುವಿ) ಕಿರಣಗಳಿಂದ ಭೂಮಿಯ ಜೀವರಾಶಿಯನ್ನು ರಕ್ಷಿಸುವ ಅನಿಲ ಪದರ ಯಾವುದು?",
            options = listOf("ಓಝೋನ್ ಪದರ (Ozone Layer - O₃)", "ಆಕ್ಸಿಜನ್ ಪದರ", "ಸಾರಜನಕ ಪದರ", "ಕಾರ್ಬನ್ ಪದರ"),
            correctAnswer = "ಓಝೋನ್ ಪದರ (Ozone Layer - O₃)",
            explanation = "ವಾತಾವರಣದ ಸಮಭಾಜಕ ವೃತ್ತದ ಮೇಲಿನ ಸ್ಟ್ರಾಟೋಸ್ಪಿಯರ್‌ನಲ್ಲಿರುವ ಓಝೋನ್ ಪದರವು (O₃) ಸೂರ್ಯನ ಹಾನಿಕಾರಕ ಯುವಿ ಕಿರಣಗಳನ್ನು ಹೀರಿಕೊಳ್ಳುತ್ತದೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q17",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಓಝೋನ್ ಪದರದ ಸವಕಳಿಗೆ (ರಂಧ್ರ ಉಂಟಾಗಲು) ಮುಖ್ಯವಾಗಿ ಕಾರಣವಾಗಿರುವ ಮಾನವ ನಿರ್ಮಿತ ರಾಸಾಯನಿಕ ಯಾವುದು?",
            options = listOf("ಕ್ಲೋರೋಫ್ಲೋರೋ ಕಾರ್ಬನ್‌ಗಳು (CFCs)", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್", "ಮೀಥೇನ್", "ಸಲ್ಫರ್ ಡೈಆಕ್ಸೈಡ್"),
            correctAnswer = "ಕ್ಲೋರೋಫ್ಲೋರೋ ಕಾರ್ಬನ್‌ಗಳು (CFCs)",
            explanation = "ರೆಫ್ರಿಜರೇಟರ್‌ಗಳು ಮತ್ತು ಏರ್ ಕಂಡೀಷನರ್‌ಗಳಲ್ಲಿ ಬಳಸಲಾಗುವ CFC ರಾಸಾಯನಿಕಗಳು ವಾತಾವರಣ ತಲುಪಿ ಓಝೋನ್ ಅಣುಗಳನ್ನು ವಿಭಜಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q18",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಮಣ್ಣಿನ ಫಲವತ್ತತೆಯನ್ನು ಹೆಚ್ಚಿಸಲು ದ್ವಿದಳ ಧಾನ್ಯಗಳನ್ನು ಮತ್ತು ಏಕದಳ ಧಾನ್ಯಗಳನ್ನು ಸರದಿಯ ಪ್ರಕಾರ ಬೆಳೆಯುವ ಪದ್ಧತಿ ಯಾವುದು?",
            options = listOf("ಬೆಳೆ ಪರಿವರ್ತನೆ (Crop Rotation)", "ಮಿಶ್ರ ಬೆಳೆ", "ತೀವ್ರ ಬೇಸಾಯ", "ಏಕ ಬೆಳೆ ಪದ್ಧತಿ"),
            correctAnswer = "ಬೆಳೆ ಪರಿವರ್ತನೆ (Crop Rotation)",
            explanation = "ಒಂದೇ ಭೂಮಿಯಲ್ಲಿ ವಿಭಿನ್ನ ಪೋಷಕಾಂಶಗಳ ಸಮತೋಲನ ಕಾಯ್ದುಕೊಳ್ಳಲು ಬೆಳೆಗಳನ್ನು ಬದಲಾಯಿಸಿ ಬೆಳೆಯುವುದನ್ನು ಬೆಳೆ ಪರಿವರ್ತನೆ (Crop Rotation) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q19",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೊಳೆಯುತ್ತಿರುವ ಸಸ್ಯ ಮತ್ತು ಪ್ರಾಣಿ ತ್ಯಾಜ್ಯಗಳಿಂದ ಎರೆಹುಳುಗಳ ಸಹಾಯದಿಂದ ತಯಾರಿಸುವ ನೈಸರ್ಗಿಕ ಜೈವಿಕ ಗೊಬ್ಬರ ಯಾವುದು?",
            options = listOf("ವರ್ಮಿಕಾಂಪೋಸ್ಟ್ (Vermicompost)", "ಯೂರಿಯಾ", "ಡಿಎಪಿ (DAP)", "ಸೂಪರ್ ಫಾಸ್ಫೇಟ್"),
            correctAnswer = "ವರ್ಮಿಕಾಂಪೋಸ್ಟ್ (Vermicompost)",
            explanation = "ಎರೆಹುಳುಗಳು ಜೈವಿಕ ತ್ಯಾಜ್ಯಗಳನ್ನು ತಿಂದು ಫಲವತ್ತಾದ ಕಾಂಪೋಸ್ಟ್ ಗೊಬ್ಬರವಾಗಿ ಪರಿವರ್ತಿಸುವುದನ್ನು ಎರೆಹುಳು ಗೊಬ್ಬರ (ವರ್ಮಿಕಾಂಪೋಸ್ಟ್) ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "nmms_sat_sci_u6_q20",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಪ್ರತಿ ವರ್ಷ 'ವಿಶ್ವ ಪರಿಸರ ದಿನ'ವನ್ನು (World Environment Day) ಯಾವ ದಿನಾಂಕದಂದು ಆಚರಿಸಲಾಗುತ್ತದೆ?",
            options = listOf("ಜೂನ್ 5", "ಏಪ್ರಿಲ್ 22", "ಮಾರ್ಚ್ 21", "ಸೆಪ್ಟೆಂಬರ್ 16"),
            correctAnswer = "ಜೂನ್ 5",
            explanation = "ಪರಿಸರ ಜಾಗೃತಿ ಮೂಡಿಸಲು ವಿಶ್ವಸಂಸ್ಥೆಯ ವತಿಯಿಂದ ಪ್ರತಿವರ್ಷ ಜೂನ್ 5 ರಂದು ವಿಶ್ವ ಪರಿಸರ ದಿನವನ್ನಾಗಿ ಆಚರಿಸಲಾಗುತ್ತದೆ."
        ),

        // ========================================================
        // ಘಟಕ 4: NMMS-2025 ವಿಜ್ಞಾನ ಪ್ರಶ್ನೆಪತ್ರಿಕೆ (NMMS-2025 Paper 2 Science)
        // ========================================================
        QuestionModel(
            id = "nmms_2025_sat_sci_q1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಏಕಮಾನ ವಿಸ್ತೀರ್ಣದ ಮೇಲೆ ವರ್ತಿಸುವ ಲಂಬ ಬಲವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ? [NMMS-2025]",
            options = listOf("ಒತ್ತಡ (Pressure)", "ಘರ್ಷಣೆ (Friction)", "ಕಾರ್ಯ (Work)", "ಸಾಂದ್ರತೆ (Density)"),
            correctAnswer = "ಒತ್ತಡ (Pressure)",
            explanation = "ಒತ್ತಡ = ಬಲ / ವಿಸ್ತೀರ್ಣ (P = F / A). ಇದರ SI ಏಕಮಾನ ಪ್ಯಾಸ್ಕಲ್ (Pascal ಅಥವಾ N/m²). [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q2",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ಸಂಪರ್ಕರಹಿತ ಬಲಕ್ಕೆ (Non-contact Force) ಉದಾಹರಣೆಯಾಗಿದೆ? [NMMS-2025]",
            options = listOf("ಗುರುತ್ವಾಕರ್ಷಣ ಬಲ (Gravitational Force)", "ಸ್ನಾಯು ಬಲ (Muscular Force)", "ಘರ್ಷಣಾ ಬಲ (Frictional Force)", "ಯಾಂತ್ರಿಕ ಬಲ (Mechanical Force)"),
            correctAnswer = "ಗುರುತ್ವಾಕರ್ಷಣ ಬಲ (Gravitational Force)",
            explanation = "ಎರಡು ಕಾಯಗಳ ನಡುವೆ ನೇರ ಸಂಪರ್ಕವಿಲ್ಲದಿದ್ದರೂ ವರ್ತಿಸುವ ಬಲವನ್ನು ಸಂಪರ್ಕರಹಿತ ಬಲ ಎನ್ನುತ್ತಾರೆ (ಉದಾ: ಗುರುತ್ವಾಕರ್ಷಣೆ, ಕಾಂತೀಯ ಬಲ, ಸ್ಥಿರವಿದ್ಯುತ್ ಬಲ). [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q3",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಧ್ವನಿಯ ಪಿಚ್ (Pitch) ಅಥವಾ ತೀಕ್ಷ್ಣತೆಯು ಯಾವುದನ್ನು ಅವಲಂಬಿಸಿದೆ? [NMMS-2025]",
            options = listOf("ಆವರ್ತಾಂಕ (Frequency)", "ವ್ಯಾಪ್ತಿ (Amplitude)", "ವೇಗ (Speed)", "ತರಂಗದೂರ (Wavelength)"),
            correctAnswer = "ಆವರ್ತಾಂಕ (Frequency)",
            explanation = "ಕಂಪನದ ಆವರ್ತಾಂಕವು ಹೆಚ್ಚಾದಷ್ಟೂ ಧ್ವನಿಯ ಪಿಚ್ (ತೀಕ್ಷ್ಣತೆ) ಹೆಚ್ಚಾಗುತ್ತದೆ. ಧ್ವನಿಯ ತಾರತ್ವವು ವ್ಯಾಪ್ತಿಯನ್ನು (Amplitude) ಅವಲಂಬಿಸಿದೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q4",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಮನುಷ್ಯನ ಕಿವಿಗೆ ಕೇಳಿಸಬಲ್ಲ ಶ್ರವ್ಯ ಧ್ವನಿಯ (Audible Sound) ಆವರ್ತಾಂಕ ಶ್ರೇಣಿ ಎಷ್ಟು? [NMMS-2025]",
            options = listOf("20 Hz ನಿಂದ 20,000 Hz", "200 Hz ನಿಂದ 2,000 Hz", "0 Hz ನಿಂದ 20 Hz", "20,000 Hz ಗಿಂತ ಹೆಚ್ಚು"),
            correctAnswer = "20 Hz ನಿಂದ 20,000 Hz",
            explanation = "ಮಾನವನ ಕಿವಿಯ ಶ್ರವ್ಯ ವ್ಯಾಪ್ತಿಯು 20 Hz ನಿಂದ 20,000 Hz ಆಗಿದೆ. 20 Hz ಗಿಂತ ಕಡಿಮೆ ಇದ್ದರೆ ಅವಶ್ರಾವ್ಯ (Infrasonic), 20 kHz ಗಿಂತ ಹೆಚ್ಚು ಇದ್ದರೆ ಶ್ರವಣಾತೀತ (Ultrasonic). [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q5",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ತಾಮ್ರದ ಸಲ್ಫೇಟ್ (CuSO₄) ದ್ರಾವಣದ ಮೂಲಕ ವಿದ್ಯುತ್ ಪ್ರವಾಹ ಹರಿಸಿದಾಗ ತಾಮ್ರವು ಯಾವ ವಿದ್ಯುದ್ವಾರದ ಮೇಲೆ ಸಂಗ್ರಹವಾಗುತ್ತದೆ? [NMMS-2025]",
            options = listOf("ಋಣಾಗ್ರ (Cathode)", "ಧನಾಗ್ರ (Anode)", "ಎರಡರ ಮೇಲೂ", "ಯಾವುದರ ಮೇಲೂ ಇಲ್ಲ"),
            correctAnswer = "ಋಣಾಗ್ರ (Cathode)",
            explanation = "Cu²⁺ ಧನ ಅಯಾನುಗಳು ಋಣ ವಿದ್ಯುದ್ವಾರವಾದ ಕ್ಯಾಥೋಡ್ (Cathode) ಕಡೆಗೆ ಆಕರ್ಷಿತವಾಗಿ ತಾಮ್ರದ ಲೋಹವಾಗಿ ಲೇಪನವಾಗುತ್ತವೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q6",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಮತಲ ದರ್ಪಣದಲ್ಲಿ ಪಾರ್ಶ್ವ ವಿಪರ್ಯಯ (Lateral Inversion) ಎಂದರೆ: [NMMS-2025]",
            options = listOf("ಎಡಭಾಗವು ಬಲಭಾಗವಾಗಿ ಮತ್ತು ಬಲಭಾಗವು ಎಡಭಾಗವಾಗಿ ಕಾಣುವುದು", "ಪ್ರತಿಬಿಂಬವು ತಲೆಕೆಳಗಾಗಿ ಕಾಣುವುದು", "ಪ್ರತಿಬಿಂಬವು ದೊಡ್ಡದಾಗಿ ಕಾಣುವುದು", "ಪ್ರತಿಬಿಂಬವು ಬಣ್ಣ ಬದಲಾಯಿಸುವುದು"),
            correctAnswer = "ಎಡಭಾಗವು ಬಲಭಾಗವಾಗಿ ಮತ್ತು ಬಲಭಾಗವು ಎಡಭಾಗವಾಗಿ ಕಾಣುವುದು",
            explanation = "ಸಮತಲ ದರ್ಪಣದಲ್ಲಿ ವಸ್ತುವಿನ ಬಲ ಭಾಗವು ಎಡವಾಗಿಯೂ, ಎಡ ಭಾಗವು ಬಲವಾಗಿಯೂ ಕಾಣುವ ವಿದ್ಯಮಾನವೇ ಪಾರ್ಶ್ವ ವಿಪರ್ಯಯ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q7",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೋಶದ ಯಾವ ಕಣದಂಗವನ್ನು 'ಕೋಶದ ಶಕ್ತಿ ಕೇಂದ್ರ' (Powerhouse of the Cell) ಎಂದು ಕರೆಯುತ್ತಾರೆ? [NMMS-2025]",
            options = listOf("ಮೈಟೋಕಾಂಡ್ರಿಯ (Mitochondria)", "ರೈಬೋಸೋಮ್", "ಪ್ಲಾಸ್ಟಿಡ್", "ಗಾಲ್ಗಿ ಸಂಕೀರ್ಣ"),
            correctAnswer = "ಮೈಟೋಕಾಂಡ್ರಿಯ (Mitochondria)",
            explanation = "ಮೈಟೋಕಾಂಡ್ರಿಯವು ಸೆಲ್ಯುಲಾರ್ ಶ್ವಾಸಕ್ರಿಯೆ ನಡೆಸಿ ATP ರೂಪದಲ್ಲಿ ಶಕ್ತಿಯನ್ನು ಉತ್ಪಾದಿಸುವುದರಿಂದ ಇದನ್ನು ಕೋಶದ ಶಕ್ತಿಕೇಂದ್ರ ಎನ್ನುತ್ತಾರೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q8",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಸ್ಯಕೋಶದಲ್ಲಿ ಮಾತ್ರ ಕಂಡುಬರುವ ಮತ್ತು ಪ್ರಾಣಿಕೋಶದಲ್ಲಿ ಇಲ್ಲದ ರಚನೆ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಕೋಶಭಿತ್ತಿ ಮತ್ತು ಹರಿತ್ಕಣ (Cell wall & Plastids)", "ಕೋಶಕೇಂದ್ರ (Nucleus)", "ಕೋಶದ್ರವ್ಯ (Cytoplasm)", "ಕೋಶಪೊರೆ (Cell membrane)"),
            correctAnswer = "ಕೋಶಭಿತ್ತಿ ಮತ್ತು ಹರಿತ್ಕಣ (Cell wall & Plastids)",
            explanation = "ಸೆಲ್ಯುಲೋಸ್‌ನಿಂದಾದ ಕೋಶಭಿತ್ತಿ (Cell Wall) ಮತ್ತು ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಗೆ ಬೇಕಾದ ಹರಿತ್ಕಣಗಳು (Chloroplasts) ಕೇವಲ ಸಸ್ಯಕೋಶಗಳಲ್ಲಿ ಮಾತ್ರ ಇರುತ್ತವೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q9",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ವಾತಾವರಣದ ಸಾರಜನಕವನ್ನು ಮಣ್ಣಿನಲ್ಲಿ ಸ್ಥಿರೀಕರಿಸುವ ಸಹಜೀವಿ ಬ್ಯಾಕ್ಟೀರಿಯಾ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ರೈಜೋಬಿಯಂ (Rhizobium)", "ಲ್ಯಾಕ್ಟೋಬ್ಯಾಸಿಲಸ್", "ಈಸ್ಟ್", "ಪೆನ್ಸಿಲಿಯಂ"),
            correctAnswer = "ರೈಜೋಬಿಯಂ (Rhizobium)",
            explanation = "ರೈಜೋಬಿಯಂ ಬ್ಯಾಕ್ಟೀರಿಯಾಗಳು ದ್ವಿದಳ ಧಾನ್ಯ ಸಸ್ಯಗಳ ಬೇರಿನ ಗಂಟುಗಳಲ್ಲಿ ವಾಸಿಸುತ್ತಾ ವಾತಾವರಣದ ನೈಟ್ರೋಜನ್‌ ಅನ್ನು ಸಸ್ಯಗಳು ಹೀರಿಕೊಳ್ಳುವ ನೈಟ್ರೇಟ್‌ಗಳಾಗಿ ಸ್ಥಿರೀಕರಿಸುತ್ತವೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q10",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ದ್ರವರೂಪದಲ್ಲಿರುವ ಏಕೈಕ ಲೋಹ ಮತ್ತು ಏಕೈಕ ಅಲೋಹಗಳು ಕ್ರಮವಾಗಿ: [NMMS-2025]",
            options = listOf("ಪಾದರಸ (Mercury) ಮತ್ತು ಬ್ರೋಮಿನ್ (Bromine)", "ತಾಮ್ರ ಮತ್ತು ಕ್ಲೋರಿನ್", "ಕಬ್ಬಿಣ ಮತ್ತು ಸಲ್ಫರ್", "ಚಿನ್ನ ಮತ್ತು ರಂಜಕ"),
            correctAnswer = "ಪಾದರಸ (Mercury) ಮತ್ತು ಬ್ರೋಮಿನ್ (Bromine)",
            explanation = "ಕೋಣೆಯ ಉಷ್ಣತೆಯಲ್ಲಿ ದ್ರವರೂಪದಲ್ಲಿರುವ ಲೋಹ ಪಾದರಸ (Hg) ಮತ್ತು ದ್ರವರೂಪದಲ್ಲಿರುವ ಅಲೋಹ ಬ್ರೋಮಿನ್ (Br). [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q11",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಲೋಹಗಳು ಆಮ್ಲಗಳೊಂದಿಗೆ ವರ್ತಿಸಿದಾಗ ಬಿಡುಗಡೆಯಾಗುವ ಅನಿಲ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಹೈಡ್ರೋಜನ್ ಅನಿಲ (Hydrogen - H₂)", "ಆಮ್ಲಜನಕ (Oxygen - O₂)", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)", "ಸಾರಜನಕ (Nitrogen - N₂)"),
            correctAnswer = "ಹೈಡ್ರೋಜನ್ ಅನಿಲ (Hydrogen - H₂)",
            explanation = "ಲೋಹ + ಆಮ್ಲ -> ಲವಣ + ಹೈಡ್ರೋಜನ್ ಅನಿಲ (Zn + 2HCl -> ZnCl₂ + H₂↑). ಈ ಅನಿಲವು ಪಾಪ್ ಶಬ್ದದೊಂದಿಗೆ ಉರಿಯುತ್ತದೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q12",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಜ್ವಾಲೆಯ (Flame) ಅತ್ಯಂತ ಬಿಸಿಯಾದ ಮತ್ತು ನೀಲಿ ಬಣ್ಣದ ಹೊರವಲಯ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ದಹನ ಪೂರ್ಣಗೊಂಡ ಹೊರವಲಯ (Non-luminous zone)", "ಮಧ್ಯದ ಹಳದಿ ವಲಯ", "ಒಳಗಿನ ಕಪ್ಪು ವಲಯ", "ತಿರುಳು"),
            correctAnswer = "ದಹನ ಪೂರ್ಣಗೊಂಡ ಹೊರವಲಯ (Non-luminous zone)",
            explanation = "ಸಂಪೂರ್ಣ ಆಮ್ಲಜನಕ ಪೂರೈಕೆಯಾಗುವ ಹೊರವಲಯವು ನೀಲಿ ಬಣ್ಣದಿಂದ ಕೂಡಿರುತ್ತದೆ ಮತ್ತು ಇದು ಜ್ವಾಲೆಯ ಅತ್ಯಂತ ಬಿಸಿಯಾದ ಭಾಗವಾಗಿದೆ (ಅಕ್ಕಸಾಲಿಗರು ಚಿನ್ನ ಕರಗಿಸಲು ಬಳಸುತ್ತಾರೆ). [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q13",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಪ್ಪೆಯಲ್ಲಿ ಲಾರ್ವಾ ಹಂತದಿಂದ (ಟ್ಯಾಡ್ಪೋಲ್) ಪ್ರೌಢ ಕಪ್ಪೆಯಾಗಿ ಬದಲಾಗುವ ಪ್ರಕ್ರಿಯೆಯನ್ನು ಏನೆನ್ನುತ್ತಾರೆ? [NMMS-2025]",
            options = listOf("ರೂಪಾಂತರ (Metamorphosis)", "ದ್ವಿದಳನ (Binary Fission)", "ಮೊಗ್ಗುವಿಕೆ (Budding)", "ಫಲಲೀಕರಣ (Fertilization)"),
            correctAnswer = "ರೂಪಾಂತರ (Metamorphosis)",
            explanation = "ಕೀಟಗಳು ಮತ್ತು ಕಪ್ಪೆಗಳಲ್ಲಿ ಲಾರ್ವಾ ಹಂತದಿಂದ ತೀವ್ರ ಬದಲಾವಣೆಗಳ ಮೂಲಕ ಪ್ರೌಢ ಜೀವಿಯಾಗಿ ಮಾರ್ಪಾಡಾಗುವ ಕ್ರಿಯೆಯನ್ನು ರೂಪಾಂತರ ಎನ್ನುತ್ತಾರೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q14",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಹೆಣ್ಣು ಅನಾಫಿಲಿಸ್ ಸೊಳ್ಳೆಯ ಕಡಿತದಿಂದ ಹರಡುವ ಪ್ರೋಟೋಜೋವಾ ಸೋಂಕು ರೋಗ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಮಲೇರಿಯಾ (Malaria)", "ಡೆಂಗ್ಯೂ (Dengue)", "ಕಾಲರಾ (Cholera)", "ಟೈಫಾಯಿಡ್ (Typhoid)"),
            correctAnswer = "ಮಲೇರಿಯಾ (Malaria)",
            explanation = "ಪ್ಲಾಸ್ಮೋಡಿಯಂ ಎಂಬ ಪ್ರೋಟೋಜೋವಾದಿಂದ ಉಂಟಾಗುವ ಮಲೇರಿಯಾ ರೋಗವನ್ನು ಹೆಣ್ಣು ಅನಾಫಿಲಿಸ್ ಸೊಳ್ಳೆ ವಾಹಕವಾಗಿ ಹರಡುತ್ತದೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q15",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಿಎನ್‌ಜಿ (CNG) ಯ ಮುಖ್ಯ ಘಟಕ ಅನಿಲ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಮೀಥೇನ್ (Methane - CH₄)", "ಬ್ಯುಟೇನ್ (Butane)", "ಪ್ರೊಪೇನ್ (Propane)", "ಈಥೇನ್ (Ethane)"),
            correctAnswer = "ಮೀಥೇನ್ (Methane - CH₄)",
            explanation = "ಸಂಕುಚಿತ ನೈಸರ್ಗಿಕ ಅನಿಲದಲ್ಲಿ (CNG) ಸುಮಾರು 85-95% ಮೀಥೇನ್ ಅನಿಲವಿರುತ್ತದೆ. ಇದು ಕಡಿಮೆ ಮಾಲಿನ್ಯ ಉಂಟುಮಾಡುವ ಸ್ವಚ್ಛ ಇಂಧನ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q16",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಮತಲ ದರ್ಪಣದಲ್ಲಿ (Plane Mirror) ಉಂಟಾಗುವ ಪ್ರತಿಬಿಂಬದ ಲಕ್ಷಣ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಮಿಥ್ಯ, ನೇರ ಮತ್ತು ವಸ್ತುವಿನಷ್ಟೇ ಗಾತ್ರ", "ಸತ್ಯ, ತಲೆಕೆಳಗಾದ ಮತ್ತು ದೊಡ್ಡದು", "ಸತ್ಯ, ನೇರ ಮತ್ತು ಚಿಕ್ಕದು", "ಮಿಥ್ಯ, ತಲೆಕೆಳಗಾದ ಮತ್ತು ದೊಡ್ಡದು"),
            correctAnswer = "ಮಿಥ್ಯ, ನೇರ ಮತ್ತು ವಸ್ತುವಿನಷ್ಟೇ ಗಾತ್ರ",
            explanation = "ಸಮತಲ ದರ್ಪಣವು ಯಾವಾಗಲೂ ಮಿಥ್ಯ (Virtual), ನೇರ (Erect), ವಸ್ತುವಿನಷ್ಟೇ ಸಮಾನ ಗಾತ್ರದ ಮತ್ತು ಪಾರ್ಶ್ವ ಪಲ್ಲಟಗೊಂಡ (Laterally inverted) ಪ್ರತಿಬಿಂಬವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q17",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ವಿದ್ಯುದ್ವಿಭಜನೆಯ (Electrolysis) ಮೂಲಕ ಒಂದು ಲೋಹದ ಮೇಲೆ ಮತ್ತೊಂದು ಲೋಹದ ತೆಳುವಾದ ಲೇಪನ ಮಾಡುವ ಪ್ರಕ್ರಿಯೆಗೆ ಏನೆನ್ನುತ್ತಾರೆ? [NMMS-2025]",
            options = listOf("ವಿದ್ಯುಲ್ಲೇಪನ (Electroplating)", "ಗ್ಯಾಲ್ವನೀಕರಣ (Galvanization)", "ವಿದ್ಯುತ್ಕಾಂತೀಯ ಪ್ರೇರಣೆ", "ಶುದ್ಧೀಕರಣ"),
            correctAnswer = "ವಿದ್ಯುಲ್ಲೇಪನ (Electroplating)",
            explanation = "ವಿದ್ಯುದ್ವಿಶ್ಲೇಷಣೆ ವಿಧಾನದಿಂದ ಅಪೇಕ್ಷಿತ ಲೋಹದ ಪದರವನ್ನು ಮತ್ತೊಂದು ಲೋಹದ ಮೇಲೆ ಲೇಪಿಸುವುದನ್ನು ವಿದ್ಯುಲ್ಲೇಪನ (Electroplating) ಎನ್ನುತ್ತಾರೆ (ಉದಾ: ಕ್ರೋಮಿಯಂ ಲೇಪನ). [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q18",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಕ್ಕರೆಯನ್ನು ಆಲ್ಕೋಹಾಲ್ ಆಗಿ ಪರಿವರ್ತಿಸುವ ಹುದುಗುವಿಕೆ (Fermentation) ಪ್ರಕ್ರಿಯೆಯನ್ನು ಕಂಡುಹಿಡಿದ ವಿಜ್ಞಾನಿ ಯಾರು? [NMMS-2025]",
            options = listOf("ಲೂಯಿ ಪಾಶ್ಚರ್ (Louis Pasteur)", "ಅಲೆಕ್ಸಾಂಡರ್ ಫ್ಲೆಮಿಂಗ್", "ಎಡ್ವರ್ಡ್ ಜೆನ್ನರ್", "ರಾಬರ್ಟ್ ಹುಕ್"),
            correctAnswer = "ಲೂಯಿ ಪಾಶ್ಚರ್ (Louis Pasteur)",
            explanation = "1857 ರಲ್ಲಿ ಲೂಯಿ ಪಾಶ್ಚರ್ ಈಸ್ಟ್ ಸಹಾಯದಿಂದ ನಡೆಯುವ ಹುದುಗುವಿಕೆ ಪ್ರಕ್ರಿಯೆಯನ್ನು ಮತ್ತು ಹಾಲಿನ ಪಾಶ್ಚರೀಕರಣವನ್ನು ಆವಿಷ್ಕರಿಸಿದರು. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q19",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ತೀವ್ರವಾಗಿ ಪ್ರತಿಕ್ರಿಯಿಸುವ ಕಾರಣ ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ (Kerosene) ಸಂಗ್ರಹಿಸಿಡಲಾಗುವ ಕ್ಷಾರ ಲೋಹ? [NMMS-2025]",
            options = listOf("ಸೋಡಿಯಂ (Sodium - Na)", "ಮೆಗ್ನೀಸಿಯಂ", "ಅಲ್ಯೂಮಿನಿಯಂ", "ಚಿನ್ನ"),
            correctAnswer = "ಸೋಡಿಯಂ (Sodium - Na)",
            explanation = "ಸೋಡಿಯಂ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ ಹೆಚ್ಚು ಕ್ರಿಯಾಶೀಲ ಲೋಹಗಳಾಗಿದ್ದು ಗಾಳಿಯಲ್ಲಿನ ಆಮ್ಲಜನಕ ಮತ್ತು ತೇವಾಂಶದೊಂದಿಗೆ ವೇಗವಾಗಿ ವರ್ತಿಸಿ ಬೆಂಕಿ ಹೊತ್ತಿಕೊಳ್ಳುವುದರಿಂದ ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ ಸಂಗ್ರಹಿಸುತ್ತಾರೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q20",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಲ್ಲಿದ್ದಲಿನ ವಿನಾಶಕಾರಿ ಬಟ್ಟಿ ಇಳಿಸುವಿಕೆಯಿಂದ (Destructive distillation of coal) ದೊರೆಯುವ ಕಾರ್ಬನ್‌ನ ಶುದ್ಧ ರೂಪ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಕೋಕ್ (Coke)", "ಕಲ್ಲಿದ್ದಲು ಟಾರು (Coal Tar)", "ಕಲ್ಲಿದ್ದಲು ಅನಿಲ", "ಪೆಟ್ರೋಲಿಯಂ"),
            correctAnswer = "ಕೋಕ್ (Coke)",
            explanation = "ಕೋಕ್ ಕಾರ್ಬನ್‌ನ ಸುಮಾರು 98% ಶುದ್ಧ ರೂಪವಾಗಿದೆ. ಇದನ್ನು ಉಕ್ಕಿನ ತಯಾರಿಕೆ ಮತ್ತು ಲೋಹಗಳ ನಿಷ್ಕರ್ಷಣೆಯಲ್ಲಿ ಅಪಕರ್ಷಣಕಾರಿಯಾಗಿ ಬಳಸುತ್ತಾರೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q21",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಅಳಿವಿನಂಚಿನಲ್ಲಿರುವ ಸಸ್ಯ ಮತ್ತು ಪ್ರಾಣಿ ಪ್ರಭೇದಗಳ ದಾಖಲೆಯನ್ನು ಒಳಗೊಂಡಿರುವ ಅಂತಾರಾಷ್ಟ್ರೀಯ ಪುಸ್ತಕ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ರೆಡ್ ಡಾಟಾ ಬುಕ್ (Red Data Book)", "ಗ್ರೀನ್ ಡಾಟಾ ಬುಕ್", "ಬ್ಲೂ ಬುಕ್", "ವೈಟ್ ಬುಕ್"),
            correctAnswer = "ರೆಡ್ ಡಾಟಾ ಬುಕ್ (Red Data Book)",
            explanation = "IUCN ಸಂಸ್ಥೆಯು ಅಳಿವಿನ ಅಂಚಿನಲ್ಲಿರುವ ಸಸ್ಯ ಮತ್ತು ಪ್ರಾಣಿ ಪ್ರಭೇದಗಳ ವಿವರಗಳನ್ನು 'ರೆಡ್ ಡಾಟಾ ಬುಕ್' ನಲ್ಲಿ ಪ್ರಕಟಿಸುತ್ತದೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q22",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಮಾನವನ ಕಣ್ಣಿನಲ್ಲಿ ಬೆಳಕಿನ ತೀವ್ರತೆಯನ್ನು ಗ್ರಹಿಸುವ ಶಂಕು (Cones) ಮತ್ತು ದಂಡ (Rods) ಜೀವಕೋಶಗಳು ಎಲ್ಲಿರುತ್ತವೆ? [NMMS-2025]",
            options = listOf("ಅಕ್ಷಿಪಟಲ (Retina)", "ಕಣ್ಣುಪಾಪೆ (Pupil)", "ಕಾರ್ನಿಯಾ (Cornea)", "ಮಸೂರ (Lens)"),
            correctAnswer = "ಅಕ್ಷಿಪಟಲ (Retina)",
            explanation = "ಕಣ್ಣಿನ ಹಿಂಭಾಗದಲ್ಲಿರುವ ಅಕ್ಷಿಪಟಲದಲ್ಲಿ (ರೆಟಿನಾ) ದಂಡ ಕೋಶಗಳು (ಮಂದ ಬೆಳಕು ಗ್ರಹಿಸಲು) ಮತ್ತು ಶಂಕು ಕೋಶಗಳು (ಬಣ್ಣ ಹಾಗೂ ತೀಕ್ಷ್ಣ ಬೆಳಕು ಗ್ರಹಿಸಲು) ಇರುತ್ತವೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q23",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಮಾನವನ ದೇಹದಲ್ಲಿ ಗ್ಲುಕೋಸ್ ಮಟ್ಟವನ್ನು ನಿಯಂತ್ರಿಸುವ ಇನ್ಸುಲಿನ್ ಹಾರ್ಮೋನ್ ಅನ್ನು ಸ್ರವಿಸುವ ಗ್ರಂಥಿ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಮೇದೋಜೀರಕ ಗ್ರಂಥಿ (Pancreas)", "ಪಿಟ್ಯುಟರಿ ಗ್ರಂಥಿ", "ಥೈರಾಯ್ಡ್ ಗ್ರಂಥಿ", "ಅಡ್ರಿನಲ್ ಗ್ರಂಥಿ"),
            correctAnswer = "ಮೇದೋಜೀರಕ ಗ್ರಂಥಿ (Pancreas)",
            explanation = "ಮೇದೋಜೀರಕ ಗ್ರಂಥಿಯ ಐಲೆಟ್ಸ್ ಆಫ್ ಲ್ಯಾಂಗರ್‌ಹಾನ್ಸ್ ಕೋಶಗಳು ಇನ್ಸುಲಿನ್ ಹಾರ್ಮೋನ್ ಸ್ರವಿಸುತ್ತವೆ. ಇದರ ಕೊರತೆಯಿಂದ ಮಧುಮೇಹ (Diabetes) ಉಂಟಾಗುತ್ತದೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q24",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಯಾವ ಅನಿಲವನ್ನು 'ಹಸಿರುಮನೆ ಅನಿಲ' (Greenhouse Gas) ಎಂದು ಕರೆಯುತ್ತಾರೆ, ಇದು ಜಾಗತಿಕ ತಾಪಮಾನ ಏರಿಕೆಗೆ (Global Warming) ಪ್ರಮುಖ ಕಾರಣ? [NMMS-2025]",
            options = listOf("ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)", "ಆಮ್ಲಜನಕ (O₂)", "ಸಾರಜನಕ (N₂)", "ಹೈಡ್ರೋಜನ್ (H₂)"),
            correctAnswer = "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)",
            explanation = "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂), ಮೀಥೇನ್ (CH₄) ಮತ್ತು ನೈಟ್ರಸ್ ಆಕ್ಸೈಡ್‌ಗಳು ಭೂಮಿಯಿಂದ ಹೊರಸೂಸುವ ಅತಿಗೆಂಪು ವಿಕಿರಣಗಳನ್ನು ಹಿಡಿದಿಟ್ಟು ತಾಪಮಾನ ಹೆಚ್ಚಿಸುತ್ತವೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q25",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಹೈಡ್ರಾ (Hydra) ದಲ್ಲಿ ಸಾಮಾನ್ಯವಾಗಿ ಕಂಡುಬರುವ ಅಲೈಂಗಿಕ ಸಂತಾನೋತ್ಪತ್ತಿಯ ವಿಧಾನ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಮೊಗ್ಗುವಿಕೆ (Budding)", "ದ್ವಿದಳನ (Binary Fission)", "ತುಂಡಾಗುವಿಕೆ", "ಬೀಜಕ ರಚನೆ"),
            correctAnswer = "ಮೊಗ್ಗುವಿಕೆ (Budding)",
            explanation = "ಹೈಡ್ರಾ ಮತ್ತು ಈಸ್ಟ್‌ಗಳಲ್ಲಿ ಮಾತೃ ಜೀವಿಯ ದೇಹದ ಮೇಲೆ ಸಣ್ಣ ಮೊಗ್ಗು (Bud) ಬೆಳೆದು ಪ್ರತ್ಯೇಕ ಜೀವಿಯಾಗಿ ಬೆಳೆಯುವ ವಿಧಾನವೇ ಮೊಗ್ಗುವಿಕೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q26",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಭೂಕಂಪನದ ತೀವ್ರತೆಯನ್ನು ಅಳೆಯಲು ಬಳಸುವ ಮಾಪಕ (Scale) ಯಾವುದು? [NMMS-2025]",
            options = listOf("ರಿಕ್ಟರ್ ಮಾಪಕ (Richter Scale)", "ಬ್ಯಾರೋಮೀಟರ್", "ಅನಿಮೋಮೀಟರ್", "ಥರ್ಮಾಮೀಟರ್"),
            correctAnswer = "ರಿಕ್ಟರ್ ಮಾಪಕ (Richter Scale)",
            explanation = "ಭೂಕಂಪದ ಅಲೆಗಳನ್ನು ಸಿಸ್ಮೋಗ್ರಾಫ್ ಉಪಕರಣ ದಾಖಲಿಸುತ್ತದೆ ಮತ್ತು ಅದರ ತೀವ್ರತೆಯನ್ನು ರಿಕ್ಟರ್ ಮಾಪಕದಲ್ಲಿ (0-9+) ಅಳೆಯಲಾಗುತ್ತದೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q27",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ತಾಮ್ರದ ಪಾತ್ರೆಗಳು ತೇವಾಂಶವುಳ್ಳ ಗಾಳಿಗೆ ತೆರೆದುಕೊಂಡಾಗ ಅವುಗಳ ಮೇಲೆ ಉಂಟಾಗುವ ಹಸಿರು ಲೇಪನವು ಯಾವುದರ ಮಿಶ್ರಣವಾಗಿದೆ? [NMMS-2025]",
            options = listOf("Cu(OH)₂ ಮತ್ತು CuCO₃", "CuO ಮತ್ತು CuS", "CuSO₄ ಮತ್ತು CuCl₂", "ಕೇವಲ Cu₂O"),
            correctAnswer = "Cu(OH)₂ ಮತ್ತು CuCO₃",
            explanation = "ತಾಮ್ರವು ತೇವಾಂಶವುಳ್ಳ CO₂ ಮತ್ತು O₂ ನೊಂದಿಗೆ ವರ್ತಿಸಿ ಕಾಪರ್ ಹೈಡ್ರಾಕ್ಸೈಡ್ Cu(OH)₂ ಮತ್ತು ಬೇಸಿಕ್ ಕಾಪರ್ ಕಾರ್ಬೊನೇಟ್ CuCO₃ ನ ಹಸಿರು ಪದರವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q28",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಅಡುಗೆ ಅನಿಲ ಸಿಲಿಂಡರ್‌ಗಳಲ್ಲಿ ಅನಿಲ ಸೋರಿಕೆಯನ್ನು (Gas Leakage) ಪತ್ತೆಹಚ್ಚಲು ಬೆರೆಸುವ ತೀವ್ರ ವಾಸನೆಯುಳ್ಳ ಸಂಯುಕ್ತ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಈಥೈಲ್ ಮರ್ಕ್ಯಾಪ್ಟಾನ್ (Ethyl Mercaptan)", "ಮೀಥೇನ್", "ಕ್ಲೋರೋಫಾರ್ಮ್", "ಈಥೇನ್"),
            correctAnswer = "ಈಥೈಲ್ ಮರ್ಕ್ಯಾಪ್ಟಾನ್ (Ethyl Mercaptan)",
            explanation = "LPG (ಬ್ಯುಟೇನ್ ಮತ್ತು ಪ್ರೊಪೇನ್) ವಾಸನೆರಹಿತ ಅನಿಲವಾಗಿದ್ದು, ಸೋರಿಕೆಯಾದರೆ ಅಪಾಯ ತಪ್ಪಿಸಲು ತೀಕ್ಷ್ಣ ವಾಸನೆಯ ಈಥೈಲ್ ಮರ್ಕ್ಯಾಪ್ಟಾನ್ (C₂H₅SH) ಅನ್ನು ಬೆರೆಸುತ್ತಾರೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q29",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ದ್ವಿದಳ ಧಾನ್ಯದ ಸಸ್ಯಗಳಲ್ಲಿ ಸಾರಜನಕ ಸ್ಥಿರೀಕರಣಕ್ಕೆ ಸಹಕರಿಸುವ ಖನಿಜಾಂಶ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಮಾಲಿಬ್ಡಿನಮ್ (Molybdenum)", "ಸೋಡಿಯಂ", "ಕ್ಲೋರಿನ್", "ಅಯೋಡಿನ್"),
            correctAnswer = "ಮಾಲಿಬ್ಡಿನಮ್ (Molybdenum)",
            explanation = "ರೈಜೋಬಿಯಂ ಬ್ಯಾಕ್ಟೀರಿಯಾದಲ್ಲಿರುವ 'ನೈಟ್ರೋಜಿನೇಸ್' ಕಿಣ್ವವು ಸಾರಜನಕ ಸ್ಥಿರೀಕರಣ ಮಾಡಲು ಮಾಲಿಬ್ಡಿನಮ್ (Mo) ಅತ್ಯಗತ್ಯ ಸೂಕ್ಷ್ಮ ಪೋಷಕಾಂಶವಾಗಿದೆ. [NMMS-2025]"
        ),
        QuestionModel(
            id = "nmms_2025_sat_sci_q30",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಯಂತ್ರೋಪಕರಣಗಳಲ್ಲಿ ಘರ್ಷಣೆಯನ್ನು (Friction) ಕಡಿಮೆ ಮಾಡಲು ಚಲಿಸುವ ಭಾಗಗಳ ನಡುವೆ ಬಳಸುವ ಸಾಧನ ಯಾವುದು? [NMMS-2025]",
            options = listOf("ಬಾಲ್ ಬೇರಿಂಗ್‌ಗಳು (Ball Bearings)", "ಸ್ಪ್ರಿಂಗ್‌ಗಳು", "ಬ್ರೇಕ್ ಪ್ಯಾಡ್‌ಗಳು", "ಕಬ್ಬಿಣದ ಮೊಳೆಗಳು"),
            correctAnswer = "ಬಾಲ್ ಬೇರಿಂಗ್‌ಗಳು (Ball Bearings)",
            explanation = "ಜಾರುವ ಘರ್ಷಣೆಯನ್ನು (Sliding friction) ಉರುಳುವ ಘರ್ಷಣೆಯನ್ನಾಗಿ (Rolling friction) ಪರಿವರ್ತಿಸಿ ಘರ್ಷಣೆಯನ್ನು ಕಡಿಮೆ ಮಾಡಲು ಬಾಲ್ ಬೇರಿಂಗ್‌ಗಳನ್ನು ಬಳಸುತ್ತಾರೆ. [NMMS-2025]"
        ),
        // ========================================================
        // ಘಟಕ 5: NMMS-2024 ವಿಜ್ಞಾನ ಪ್ರಶ್ನೆಪತ್ರಿಕೆ (NMMS-2024 Paper 2 Science)
        // ========================================================
        QuestionModel(
            id = "nmms_2024_sat_sci_q1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳು ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆ (Photosynthesis) ಕ್ರಿಯೆಯಲ್ಲಿ ಪರಿಸರದಿಂದ ಹೀರಿಕೊಳ್ಳುವ ಅನಿಲ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)", "ಆಕ್ಸಿಜನ್ (O₂)", "ಸಾರಜನಕ (N₂)", "ಹೈಡ್ರೋಜನ್ (H₂)"),
            correctAnswer = "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)",
            explanation = "ಸಸ್ಯಗಳು ಎಲೆಗಳಲ್ಲಿನ ಪತ್ರರಂಧ್ರಗಳ (Stomata) ಮೂಲಕ CO₂ ಹೀರಿಕೊಂಡು ಸೂರ್ಯನ ಬೆಳಕಿನ ಉಪಸ್ಥಿತಿಯಲ್ಲಿ ಗ್ಲೂಕೋಸ್ ಮತ್ತು ಆಕ್ಸಿಜನ್ ಉತ್ಪಾದಿಸುತ್ತವೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q2",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪ್ರಪಂಚದ ಮೊಟ್ಟಮೊದಲ ಪ್ರತಿಜೀವಕ (Antibiotic) 'ಪೆನ್ಸಿಲಿನ್' ಅನ್ನು 1928 ರಲ್ಲಿ ಆವಿಷ್ಕರಿಸಿದ ವಿಜ್ಞಾನಿ ಯಾರು? [NMMS-2024]",
            options = listOf("ಅಲೆಕ್ಸಾಂಡರ್ ಫ್ಲೆಮಿಂಗ್ (Alexander Fleming)", "ಲೂಯಿ ಪಾಶ್ಚರ್", "ಎಡ್ವರ್ಡ್ ಜೆನ್ನರ್", "ರಾಬರ್ಟ್ ಕೋಚ್"),
            correctAnswer = "ಅಲೆಕ್ಸಾಂಡರ್ ಫ್ಲೆಮಿಂಗ್ (Alexander Fleming)",
            explanation = "ಅಲೆಕ್ಸಾಂಡರ್ ಫ್ಲೆಮಿಂಗ್ ಪೆನ್ಸಿಲಿಯಂ ನೊಟೇಟಂ ಎಂಬ ಶಿಲೀಂಧ್ರದಿಂದ ಪೆನ್ಸಿಲಿನ್ ಪ್ರತಿಜೀವಕವನ್ನು ಕಂಡುಹಿಡಿದರು. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q3",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಸಾಮಾನ್ಯ ಕೊಠಡಿಯ ಉಷ್ಣತೆಯಲ್ಲಿ (Room Temperature) ದ್ರವರೂಪದಲ್ಲಿರುವ ಏಕೈಕ ಲೋಹ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಪಾದರಸ (Mercury - Hg)", "ಬ್ರೋಮಿನ್ (Bromine)", "ಸೋಡಿಯಂ (Sodium)", "ಗ್ಯಾಲಿಯಂ (Gallium)"),
            correctAnswer = "ಪಾದರಸ (Mercury - Hg)",
            explanation = "ಪಾದರಸ (Hg) ಕೊಠಡಿ ತಾಪಮಾನದಲ್ಲಿ ದ್ರವರೂಪದಲ್ಲಿರುವ ಏಕೈಕ ಲೋಹ (ಬ್ರೋಮಿನ್ ದ್ರವರೂಪದ ಅಲೋಹವಾಗಿದೆ). [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q4",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಲೋಹಗಳಂತೆ ಹೊಳೆಯುವ (Lustrous) ವಿಶೇಷ ಗುಣವನ್ನು ಹೊಂದಿರುವ ಅಲೋಹ (Non-metal) ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಅಯೋಡಿನ್ (Iodine)", "ಗಂಧಕ (Sulphur)", "ರಂಜಕ (Phosphorus)", "ಕಾರ್ಬನ್ (Carbon)"),
            correctAnswer = "ಅಯೋಡಿನ್ (Iodine)",
            explanation = "ಸಾಮಾನ್ಯವಾಗಿ ಅಲೋಹಗಳು ಹೊಳಪನ್ನು ಹೊಂದಿರುವುದಿಲ್ಲ, ಆದರೆ ಅಯೋಡಿನ್ ಹೊಳೆಯುವ ನೇರಳೆ ಬಣ್ಣದ ಸ್ಫಟಿಕ ರೂಪದ ಅಲೋಹವಾಗಿದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q5",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮರದ ತಿರುಳಿನಿಂದ (Wood Pulp) ರಾಸಾಯನಿಕ ಸಂಸ್ಕರಣೆ ಮೂಲಕ ತಯಾರಾಗುವ 'ಕೃತಕ ರೇಷ್ಮೆ' (Artificial Silk) ಎಂದು ಕರೆಯಲ್ಪಡುವ ಎಳೆ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ರೇಯಾನ್ (Rayon)", "ನೈಲಾನ್ (Nylon)", "ಪಾಲಿಯೆಸ್ಟರ್ (Polyester)", "ಅಕ್ರಿಲಿಕ್ (Acrylic)"),
            correctAnswer = "ರೇಯಾನ್ (Rayon)",
            explanation = "ರೇಯಾನ್ ನೈಸರ್ಗಿಕ ಮೂಲದ ಮರದ ತಿರುಳಿನಿಂದ ತಯಾರಿಸಲ್ಪಡುವ ಪುನರುತ್ಪಾದಿತ ಸೆಲ್ಯುಲೋಸ್ ಎಳೆಯಾಗಿದ್ದು, ರೇಷ್ಮೆಯಂತಹ ಹೊಳಪು ಹೊಂದಿದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q6",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಈ ಕೆಳಗಿನ ಇಂಧನಗಳಲ್ಲಿ ಅತಿ ಹೆಚ್ಚಿನ ಕ್ಯಾಲೋರಿಫಿಕ್ ಮೌಲ್ಯವನ್ನು (Highest Calorific Value - 1,50,000 kJ/kg) ಹೊಂದಿರುವ ಇಂಧನ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಹೈಡ್ರೋಜನ್ ಅನಿಲ (Hydrogen gas)", "LPG", "ಮೀಥೇನ್ (CNG)", "ಪೆಟ್ರೋಲ್"),
            correctAnswer = "ಹೈಡ್ರೋಜನ್ ಅನಿಲ (Hydrogen gas)",
            explanation = "ಹೈಡ್ರೋಜನ್ ಅನಿಲದ ಕ್ಯಾಲೋರಿಫಿಕ್ ಮೌಲ್ಯ 1,50,000 kJ/kg ಆಗಿದ್ದು ಅತ್ಯಂತ ಸ್ವಚ್ಛ ಮತ್ತು ಪ್ರಬಲ ಇಂಧನವಾಗಿದೆ (LPG = 55,000 kJ/kg). [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q7",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪ್ರೌಢಾವಸ್ಥೆಯಲ್ಲಿ ಪುರುಷರಲ್ಲಿ ದ್ವಿತೀಯ ಲೈಂಗಿಕ ಲಕ್ಷಣಗಳ ಬೆಳವಣಿಗೆಗೆ ಕಾರಣವಾಗುವ ಪ್ರಮುಖ ಹಾರ್ಮೋನ್ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಟೆಸ್ಟೋಸ್ಟೆರಾನ್ (Testosterone)", "ಈಸ್ಟ್ರೋಜನ್ (Estrogen)", "ಇನ್ಸುಲಿನ್ (Insulin)", "ಥೈರಾಕ್ಸಿನ್ (Thyroxine)"),
            correctAnswer = "ಟೆಸ್ಟೋಸ್ಟೆರಾನ್ (Testosterone)",
            explanation = "ವೃಷಣಗಳು ಸ್ರವಿಸುವ ಟೆಸ್ಟೋಸ್ಟೆರಾನ್ ಪುರುಷ ಲೈಂಗಿಕ ಹಾರ್ಮೋನ್ ಆಗಿದ್ದು, ಗಡ್ಡ-ಮೀಸೆ, ಧ್ವನಿ ಗಡಸಾಗುವಿಕೆ ಇತ್ಯಾದಿಗಳನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q8",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಜೀವಕೋಶದ 'ಶಕ್ತಿ ಉತ್ಪಾದನಾ ಕೇಂದ್ರ' (Powerhouse of the Cell) ಎಂದು ಕರೆಯಲ್ಪಡುವ ಕಣದಂಗ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಮೈಟೋಕಾಂಡ್ರಿಯಾ (Mitochondria)", "ರೈಬೋಸೋಮ್", "ಗಾಲ್ಗಿ ಸಂಕೀರ್ಣ", "ಲೈಸೋಸೋಮ್"),
            correctAnswer = "ಮೈಟೋಕಾಂಡ್ರಿಯಾ (Mitochondria)",
            explanation = "ಮೈಟೋಕಾಂಡ್ರಿಯಾದಲ್ಲಿ ಸೆಲ್ಯುಲಾರ್ ಉಸಿರಾಟ ನಡೆದು ATP (Adenosine Triphosphate) ರೂಪದಲ್ಲಿ ಶಕ್ತಿ ಬಿಡುಗಡೆಯಾಗುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q9",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮಾನವನ ಕಿವಿಯು ಗ್ರಹಿಸಬಲ್ಲ ಶ್ರವ್ಯ ಧ್ವನಿ ತರಂಗಗಳ ಆವರ್ತನದ (Audible Frequency Range) ವ್ಯಾಪ್ತಿ ಎಷ್ಟು? [NMMS-2024]",
            options = listOf("20 Hz ನಿಂದ 20,000 Hz", "2 Hz ನಿಂದ 200 Hz", "200 Hz ನಿಂದ 2,000 Hz", "20,000 Hz ಗಿಂತ ಹೆಚ್ಚು"),
            correctAnswer = "20 Hz ನಿಂದ 20,000 Hz",
            explanation = "20 Hz ಗಿಂತ ಕಡಿಮೆ ಇರುವುದು ಅವಶ್ರವ್ಯ (Infrasonic) ಮತ್ತು 20,000 Hz ಗಿಂತ ಹೆಚ್ಚು ಇರುವುದು ಶ್ರವಣಾತೀತ (Ultrasonic) ತರಂಗಗಳು. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q10",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಕಾರಿನ ಬಂಪರ್‌ಗಳು ಮತ್ತು ಸೈಕಲ್ ಹ್ಯಾಂಡಲ್‌ಗಳಿಗೆ ಹೊಳಪು ನೀಡಲು ಮತ್ತು ತುಕ್ಕು ಹಿಡಿಯುವುದನ್ನು ತಡೆಯಲು ಯಾವ ಲೋಹದ ವಿದ್ಯುಲ್ಲೇಪನ (Electroplating) ಮಾಡಲಾಗುತ್ತದೆ? [NMMS-2024]",
            options = listOf("ಕ್ರೋಮಿಯಂ (Chromium)", "ಸತು (Zinc)", "ತಾಮ್ರ (Copper)", "ತವರ (Tin)"),
            correctAnswer = "ಕ್ರೋಮಿಯಂ (Chromium)",
            explanation = "ಕ್ರೋಮಿಯಂ ಲೋಹವು ಅತ್ಯಂತ ಹೊಳಪುಳ್ಳದ್ದು, ಗೀರು ನಿರೋಧಕ ಮತ್ತು ತುಕ್ಕು ಹಿಡಿಯದ ಕಾರಣ ವಿದ್ಯುಲ್ಲೇಪನದಲ್ಲಿ ವ್ಯಾಪಕವಾಗಿ ಬಳಕೆಯಾಗುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q11",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಮೇಲ್ಮೈಯಿಂದ ಎತ್ತರಕ್ಕೆ ಹೋದಂತೆ ವಾತಾವರಣದ ಒತ್ತಡವು (Atmospheric Pressure): [NMMS-2024]",
            options = listOf("ಕ್ರಮೇಣ ಕಡಿಮೆಯಾಗುತ್ತದೆ", "ಹೆಚ್ಚಾಗುತ್ತದೆ", "ಯಾವುದೇ ಬದಲಾವಣೆ ಇರುವುದಿಲ್ಲ", "ಮೊದಲು ಹೆಚ್ಚಾಗಿ ನಂತರ ಕಡಿಮೆಯಾಗುತ್ತದೆ"),
            correctAnswer = "ಕ್ರಮೇಣ ಕಡಿಮೆಯಾಗುತ್ತದೆ",
            explanation = "ಎತ್ತರಕ್ಕೆ ಹೋದಂತೆ ಗಾಳಿಯ ಸಾಂದ್ರತೆ ಮತ್ತು ವಾಯುಸ್ತಂಭದ ತೂಕ ಕಡಿಮೆಯಾಗುವುದರಿಂದ ವಾತಾವರಣದ ಒತ್ತಡ ಕಡಿಮೆಯಾಗುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q12",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಸ್ಥಿರ ಘರ್ಷಣೆ (Static), ಜಾರುವ ಘರ್ಷಣೆ (Sliding) ಮತ್ತು ಉರುಳುವ ಘರ್ಷಣೆಗಳ (Rolling) ಪರಿಮಾಣಗಳ ಸರಿಯಾದ ಇಳಿಕೆ ಕ್ರಮ ಯಾವುದು? [NMMS-2024]",
            options = listOf(
                "ಸ್ಥಿರ ಘರ್ಷಣೆ > ಜಾರುವ ಘರ್ಷಣೆ > ಉರುಳುವ ಘರ್ಷಣೆ",
                "ಉರುಳುವ ಘರ್ಷಣೆ > ಜಾರುವ ಘರ್ಷಣೆ > ಸ್ಥಿರ ಘರ್ಷಣೆ",
                "ಜಾರುವ ಘರ್ಷಣೆ > ಸ್ಥಿರ ಘರ್ಷಣೆ > ಉರುಳುವ ಘರ್ಷಣೆ",
                "ಎಲ್ಲಾ ಘರ್ಷಣೆಗಳೂ ಸಮಾನವಾಗಿರುತ್ತವೆ"
            ),
            correctAnswer = "ಸ್ಥಿರ ಘರ್ಷಣೆ > ಜಾರುವ ಘರ್ಷಣೆ > ಉರುಳುವ ಘರ್ಷಣೆ",
            explanation = "ವಸ್ತುವನ್ನು ಚಲಿಸಲು ಆರಂಭಿಸುವಾಗ ಸ್ಥಿರ ಘರ್ಷಣೆ ಗರಿಷ್ಠವಾಗಿರುತ್ತದೆ; ಚಲನೆಯಲ್ಲಿ ಜಾರುವ ಘರ್ಷಣೆ ಕಡಿಮೆಯಾಗುತ್ತದೆ; ಉರುಳುವ ಘರ್ಷಣೆ ಕನಿಷ್ಠವಾಗಿರುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q13",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒರಟಾದ ಅಥವಾ ಅಸಮತೋಲಿತ ಮೇಲ್ಮೈಯ ಮೇಲೆ ಬೆಳಕು ಬಿದ್ದಾಗ ಎಲ್ಲಾ ದಿಕ್ಕುಗಳಿಗೂ ಚದುರಿ ಪ್ರತಿಫಲನಗೊಳ್ಳುವ ಕ್ರಿಯೆಗೆ ಏನೆನ್ನುತ್ತಾರೆ? [NMMS-2024]",
            options = listOf("ಅನಿಯಮಿತ ಅಥವಾ ಚದುರಿದ ಪ್ರತಿಫಲನ (Diffused Reflection)", "ನಿಯಮಿತ ಪ್ರತಿಫಲನ", "ವಕ್ರೀಭವನ", "ಸಂಪೂರ್ಣ ಆಂತರಿಕ ಪ್ರತಿಫಲನ"),
            correctAnswer = "ಅನಿಯಮಿತ ಅಥವಾ ಚದುರಿದ ಪ್ರತಿಫಲನ (Diffused Reflection)",
            explanation = "ಒರಟು ಮೇಲ್ಮೈಯ ವಿವಿಧ ಬಿಂದುಗಳಲ್ಲಿ ಲಂಬಗಳು ಬೇರೆ ಬೇರೆ ದಿಕ್ಕಿನಲ್ಲಿರುವುದರಿಂದ ಪತನ ಕಿರಣಗಳು ಬೇರೆ ಬೇರೆ ಕೋನಗಳಲ್ಲಿ ಚದುರುತ್ತವೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q14",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ನಮ್ಮ ಸೌರವ್ಯೂಹದಲ್ಲಿರುವ ಅತ್ಯಂತ ದೊಡ್ಡ ಗ್ರಹ (Largest Planet) ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಗುರು (Jupiter)", "ಶನಿ (Saturn)", "ಯುರೇನಸ್ (Uranus)", "ಭೂಮಿ (Earth)"),
            correctAnswer = "ಗುರು (Jupiter)",
            explanation = "ಗುರು ಗ್ರಹವು ಸೌರವ್ಯೂಹದ ಅತಿ ದೊಡ್ಡ ಅನಿಲ ದೈತ್ಯ ಗ್ರಹವಾಗಿದ್ದು, ಸುಮಾರು 1300 ಭೂಮಿಗಳನ್ನು ತನ್ನೊಳಗೆ ಹಿಡಿದಿಟ್ಟುಕೊಳ್ಳಬಲ್ಲದು. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q15",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ತಾಜ್ ಮಹಲ್‌ನ ಅಮೃತಶಿಲೆಯ ಬಣ್ಣ ಹಳದಿಯಾಗಲು ಕಾರಣವಾದ ಆಮ್ಲ ಮಳೆಗೆ (Acid Rain) ಪ್ರಮುಖವಾಗಿ ಕಾರಣವಾದ ಅನಿಲಗಳು ಯಾವುವು? [NMMS-2024]",
            options = listOf("ಸಲ್ಫರ್ ಡೈಆಕ್ಸೈಡ್ (SO₂) ಮತ್ತು ನೈಟ್ರೋಜನ್ ಡೈಆಕ್ಸೈಡ್ (NO₂)", "ಕಾರ್ಬನ್ ಮಾನಾಕ್ಸೈಡ್ ಮತ್ತು ಮೀಥೇನ್", "ಆಕ್ಸಿಜನ್ ಮತ್ತು ಹೈಡ್ರೋಜನ್", "ಆರ್ಗಾನ್ ಮತ್ತು ಹೀಲಿಯಂ"),
            correctAnswer = "ಸಲ್ಫರ್ ಡೈಆಕ್ಸೈಡ್ (SO₂) ಮತ್ತು ನೈಟ್ರೋಜನ್ ಡೈಆಕ್ಸೈಡ್ (NO₂)",
            explanation = "ಕಾರ್ಖಾನೆಗಳ ಹೊಗೆಯಿಂದ ಹೊರಬರುವ SO₂ ಮತ್ತು NO₂ ಮಳೆನೀರಿನೊಂದಿಗೆ ವರ್ತಿಸಿ H₂SO₄ ಮತ್ತು HNO₃ ಆಮ್ಲಗಳನ್ನು ಉಂಟುಮಾಡುತ್ತವೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q16",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಜೇನುತುಪ್ಪ ಮತ್ತು ಮೇಣದ ಉತ್ಪಾದನೆಗಾಗಿ ವೈಜ್ಞಾನಿಕವಾಗಿ ಜೇನುನೊಣಗಳನ್ನು ಸಾಕುವ ಕೃಷಿ ಪದ್ಧತಿಗೆ ಏನೆನ್ನುತ್ತಾರೆ? [NMMS-2024]",
            options = listOf("ಎಪಿಕಲ್ಚರ್ (Apiculture)", "ಸೆರಿಕಲ್ಚರ್ (Sericulture)", "ಪಿಸಿಕಲ್ಚರ್ (Pisciculture)", "ಹಾರ್ಟಿಕಲ್ಚರ್ (Horticulture)"),
            correctAnswer = "ಎಪಿಕಲ್ಚರ್ (Apiculture)",
            explanation = "ಜೇನುನೊಣ ಸಾಕಣೆಯನ್ನು ಎಪಿಕಲ್ಚರ್ ಎಂದೂ, ರೇಷ್ಮೆ ಕೃಷಿಯನ್ನು ಸೆರಿಕಲ್ಚರ್ ಎಂದೂ, ಮೀನು ಸಾಕಣೆಯನ್ನು ಪಿಸಿಕಲ್ಚರ್ ಎಂದೂ ಕರೆಯುತ್ತಾರೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q17",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮಾನವನ ಕಣ್ಣಿನೊಳಗೆ ಪ್ರವೇಶಿಸುವ ಬೆಳಕಿನ ಪ್ರಮಾಣವನ್ನು ನಿಯಂತ್ರಿಸುವ ಬಣ್ಣಯುಕ್ತ ಸ್ನಾಯುಪದರ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಐರಿಸ್ / ಕನೀನಿಕಾ (Iris)", "ಕಾರ್ನಿಯಾ (Cornea)", "ರೆಟಿನಾ (Retina)", "ದೃಕ್ ನರ (Optic Nerve)"),
            correctAnswer = "ಐರಿಸ್ / ಕನೀನಿಕಾ (Iris)",
            explanation = "ಐರಿಸ್ ಕಣ್ಣಿನ ಪಾಪೆಯ (Pupil) ಗಾತ್ರವನ್ನು ಹಿಗ್ಗಿಸಿ ಅಥವಾ ಕುಗ್ಗಿಸಿ ಒಳಪ್ರವೇಶಿಸುವ ಬೆಳಕಿನ ಪ್ರಮಾಣವನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q18",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮಲೇರಿಯಾ ರೋಗವನ್ನು ಹರಡುವ ಹೆಣ್ಣು ಅನಾಫಿಲಿಸ್ ಸೊಳ್ಳೆಯು ಮನುಷ್ಯನ ರಕ್ತಕ್ಕೆ ವರ್ಗಾಯಿಸುವ ರೋಗಾಣು ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಪ್ಲಾಸ್ಮೋಡಿಯಂ (Plasmodium - Protozoa)", "ವೈರಸ್", "ಬ್ಯಾಕ್ಟೀರಿಯಾ", "ಶಿಲೀಂಧ್ರ"),
            correctAnswer = "ಪ್ಲಾಸ್ಮೋಡಿಯಂ (Plasmodium - Protozoa)",
            explanation = "ಮಲೇರಿಯಾ ರೋಗವು ಪ್ಲಾಸ್ಮೋಡಿಯಂ ಎಂಬ ಪ್ರೋಟೋಜೋವಾ ಪರಾವಲಂಬಿ ಜೀವಿಯಿಂದ ಉಂಟಾಗುವ ಸಾಂಕ್ರಾಮಿಕ ರೋಗವಾಗಿದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q19",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಕಬ್ಬಿಣವು ತೇವಾಂಶ ಮತ್ತು ಗಾಳಿಯ ಸಂಪರ್ಕಕ್ಕೆ ಬಂದಾಗ ತುಕ್ಕು ಹಿಡಿಯುವ ಕ್ರಿಯೆಯು ಯಾವ ರೀತಿಯ ಬದಲಾವಣೆಯಾಗಿದೆ? [NMMS-2024]",
            options = listOf("ರಾಸಾಯನಿಕ ಮತ್ತು ಶಾಶ್ವತ ಬದಲಾವಣೆ (Chemical change)", "ಕೇವಲ ಭೌತ ಬದಲಾವಣೆ", "ಹಿಮ್ಮುಖವಾಗಿಸಬಹುದಾದ ಬದಲಾವಣೆ", "ತಾತ್ಕಾಲಿಕ ಬದಲಾವಣೆ"),
            correctAnswer = "ರಾಸಾಯನಿಕ ಮತ್ತು ಶಾಶ್ವತ ಬದಲಾವಣೆ (Chemical change)",
            explanation = "ಕಬ್ಬಿಣವು ಆಕ್ಸಿಜನ್ ಮತ್ತು ನೀರಿನೊಂದಿಗೆ ವರ್ತಿಸಿ ಜಲಸಂಯೋಜಿತ ಐರನ್ ಆಕ್ಸೈಡ್ (Fe₂O₃·xH₂O) ಎಂಬ ಹೊಸ ವಸ್ತುವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q20",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಜೆಟ್ ವಿಮಾನಗಳಲ್ಲಿ ಇಂಧನವಾಗಿ (Aviation turbine fuel) ಬಳಸಲಾಗುವ ಪೆಟ್ರೋಲಿಯಂನ ಪ್ರಮುಖ ಅಂಶ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಸೀಮೆಎಣ್ಣೆ (Kerosene)", "ಪೆಟ್ರೋಲ್", "ಡೀಸೆಲ್", "ದ್ರವೀಕೃತ ಪೆಟ್ರೋಲಿಯಂ ಅನಿಲ"),
            correctAnswer = "ಸೀಮೆಎಣ್ಣೆ (Kerosene)",
            explanation = "ವಿಶೇಷವಾಗಿ ಶುದ್ಧೀಕರಿಸಿದ ಸೀಮೆಎಣ್ಣೆಯು ಕಡಿಮೆ ಘನೀಭವನ ಬಿಂದು ಮತ್ತು ಹೆಚ್ಚಿನ ದಹನ ಸಾಮರ್ಥ್ಯ ಹೊಂದಿರುವುದರಿಂದ ವಿಮಾನಗಳಲ್ಲಿ ಬಳಕೆಯಾಗುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q21",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಏಕಮಾನ ವಿಸ್ತೀರ್ಣದ ಮೇಲೆ ಲಂಬವಾಗಿ ಪ್ರಯೋಗವಾಗುವ ಬಲವನ್ನು (Force per unit area) ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ? [NMMS-2024]",
            options = listOf("ಒತ್ತಡ (Pressure)", "ವೇಗೋತ್ಕರ್ಷ (Acceleration)", "ಗುರುತ್ವಾಕರ್ಷಣೆ", "ಘರ್ಷಣೆ (Friction)"),
            correctAnswer = "ಒತ್ತಡ (Pressure)",
            explanation = "ಒತ್ತಡ P = ಬಲ F ÷ ವಿಸ್ತೀರ್ಣ A. ಇದರ SI ಏಕಮಾನ ಪ್ಯಾಸ್ಕಲ್ (Pascal ಅಥವಾ N/m²). [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q22",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ನಾಲ್ಕು ವಿದ್ಯುತ್ಕಾಂತಗಳನ್ನು ತಯಾರಿಸಲು ಬಳಸಿದ ಅವಾಹಕ ಹೊದಿಕೆಯಿರುವ ತಂತಿಯ ಉದ್ದಗಳು: P = 76 cm, Q = 154 cm, R = 100 cm, S = 130 cm. ಇವುಗಳಲ್ಲಿ ಅತಿ ಹೆಚ್ಚು ಪ್ರಬಲವಾದ ವಿದ್ಯುತ್ಕಾಂತ ಯಾವುದು? [NMMS-2024]",
            options = listOf("Q (154 cm)", "P", "R", "S"),
            correctAnswer = "Q (154 cm)",
            explanation = "ವಿದ್ಯುತ್ಕಾಂತದ ತಂತಿಯ ಉದ್ದ ಹೆಚ್ಚಾದಷ್ಟೂ ಸುತ್ತುಗಳ ಸಂಖ್ಯೆ (Number of turns) ಹೆಚ್ಚಾಗಿ ಕಾಂತೀಯ ಬಲವು ಗರಿಷ್ಠವಾಗಿರುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q23",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಬೆಳಕಿನ ಪ್ರತಿಫಲನಕ್ಕೆ ಸಂಬಂಧಿಸಿದಂತೆ ಅತ್ಯಂತ ನಯವಾದ ಹೊಳಪಾದ ಮೇಲ್ಮೈಯ ನೈಸರ್ಗಿಕ ಸ್ವಭಾವವೆಂದರೆ: [NMMS-2024]",
            options = listOf(
                "ಹೆಚ್ಚು ಪ್ರತಿಫಲನ, ಕಡಿಮೆ ಹೀರಿಕೆ, ಕಡಿಮೆ ಚದುರುವಿಕೆ",
                "ಕಡಿಮೆ ಪ್ರತಿಫಲನ, ಹೆಚ್ಚು ಹೀರಿಕೆ, ಹೆಚ್ಚು ಚದುರುವಿಕೆ",
                "ಹೆಚ್ಚು ಪ್ರತಿಫಲನ, ಕಡಿಮೆ ಹೀರಿಕೆ, ಹೆಚ್ಚು ಚದುರುವಿಕೆ",
                "ಕಡಿಮೆ ಪ್ರತಿಫಲನ, ಹೆಚ್ಚು ಹೀರಿಕೆ, ಕಡಿಮೆ ಚದುರುವಿಕೆ"
            ),
            correctAnswer = "ಹೆಚ್ಚು ಪ್ರತಿಫಲನ, ಕಡಿಮೆ ಹೀರಿಕೆ, ಕಡಿಮೆ ಚದುರುವಿಕೆ",
            explanation = "ನಯವಾದ ಹೊಳಪುಳ್ಳ ಮೇಲ್ಮೈಯು ಬಹುತೇಕ ಬೆಳಕನ್ನು ನಿಯಮಿತವಾಗಿ ಪ್ರತಿಫಲಿಸುತ್ತದೆ ಮತ್ತು ಅತಿ ಕಡಿಮೆ ಬೆಳಕನ್ನು ಹೀರಿಕೊಳ್ಳುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q24",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಹೇಳಿಕೆ 1: ಒಬ್ಬ ವ್ಯಕ್ತಿಯು ಸ್ಕೇಟಿಂಗ್ ಮೈದಾನದ ನಯವಾದ ಮಂಜುಗಡ್ಡೆಯ ಮೇಲೆ ಸುಲಭವಾಗಿ ಸ್ಕೇಟಿಂಗ್ ಮಾಡಬಲ್ಲ. ಹೇಳಿಕೆ 2: ಮೈದಾನದ ಘರ್ಷಣಾ ಬಲವು ವ್ಯಕ್ತಿಯ ಸ್ನಾಯು ಬಲಕ್ಕಿಂತ ಹೆಚ್ಚಾಗಿರುತ್ತದೆ. ಸರಿಯಾದ ಆಯ್ಕೆ ಯಾವುದು? [NMMS-2024]",
            options = listOf(
                "ಹೇಳಿಕೆ 1 ಸರಿಯಾಗಿದೆ ಮತ್ತು ಹೇಳಿಕೆ 2 ತಪ್ಪಾಗಿದೆ",
                "ಎರಡೂ ಹೇಳಿಕೆಗಳು ಸರಿಯಾಗಿವೆ",
                "ಹೇಳಿಕೆ 1 ತಪ್ಪಾಗಿದೆ ಮತ್ತು ಹೇಳಿಕೆ 2 ಸರಿಯಾಗಿದೆ",
                "ಎರಡೂ ಹೇಳಿಕೆಗಳು ತಪ್ಪಾಗಿವೆ"
            ),
            correctAnswer = "ಹೇಳಿಕೆ 1 ಸರಿಯಾಗಿದೆ ಮತ್ತು ಹೇಳಿಕೆ 2 ತಪ್ಪಾಗಿದೆ",
            explanation = "ಮಂಜುಗಡ್ಡೆಯ ಮೇಲೆ ಘರ್ಷಣೆ ಅತ್ಯಂತ ಕಡಿಮೆ ಇರುವುದರಿಂದ ಸ್ಕೇಟಿಂಗ್ ಸುಲಭ, ಆದ್ದರಿಂದ ಹೇಳಿಕೆ 2 ತಪ್ಪು. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q25",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಘರ್ಷಣೆಗೆ ಸಂಬಂಧಿಸಿದಂತೆ ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಸರಿಯಾದ ವೈಜ್ಞಾನಿಕ ನಿಯಮ ಯಾವುದು? [NMMS-2024]",
            options = listOf(
                "ಮೇಲ್ಮೈಯ ಅನಿಯತತೆಗಳು (Irregularities) ಹೆಚ್ಚಾದಂತೆ ಘರ್ಷಣೆ ಹೆಚ್ಚಾಗುತ್ತದೆ",
                "ಮೇಲ್ಮೈಯ ನಿಯತತೆಗಳು ಹೆಚ್ಚಾದಂತೆ ಘರ್ಷಣೆ ಹೆಚ್ಚಾಗುತ್ತದೆ",
                "ಮೇಲ್ಮೈಯ ಅನಿಯತತೆಗಳು ಕಡಿಮೆಯಾದಂತೆ ಘರ್ಷಣೆ ಹೆಚ್ಚಾಗುತ್ತದೆ",
                "ಮೇಲ್ಮೈಯ ಗುಣಲಕ್ಷಣಗಳಿಗೂ ಘರ್ಷಣೆಗೂ ಸಂಬಂಧವಿಲ್ಲ"
            ),
            correctAnswer = "ಮೇಲ್ಮೈಯ ಅನಿಯತತೆಗಳು (Irregularities) ಹೆಚ್ಚಾದಂತೆ ಘರ್ಷಣೆ ಹೆಚ್ಚಾಗುತ್ತದೆ",
            explanation = "ಎರಡು ಮೇಲ್ಮೈಗಳ ನಡುವಿನ ಸೂಕ್ಷ್ಮ ಏರಿಳಿತಗಳು (Irregularities) ಒಂದಕ್ಕೊಂದು ಲಾಕ್ ಆಗುವುದರಿಂದ ಘರ್ಷಣಾ ಬಲ ಹೆಚ್ಚಾಗುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q26",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ವಿಮಾನವನ್ನು ಆಕಾಶದಲ್ಲಿ ಹಾರುವ ಹಕ್ಕಿಯ ಆಕಾರದಲ್ಲಿ (Streamlined shape) ಏರೋಡೈನಾಮಿಕ್ ಆಗಿ ವಿನ್ಯಾಸಗೊಳಿಸಲು ಮುಖ್ಯ ಕಾರಣ: [NMMS-2024]",
            options = listOf(
                "ತರಲಗಳಲ್ಲಿ (ಗಾಳಿಯಲ್ಲಿ) ಉಂಟಾಗುವ ಘರ್ಷಣೆಯನ್ನು ಕಡಿಮೆ ಮಾಡುವುದು",
                "ಸ್ಥಾಯಿ ಘರ್ಷಣೆಯನ್ನು ಕಡಿಮೆ ಮಾಡುವುದು",
                "ಉರುಳು ಘರ್ಷಣೆಯನ್ನು ಹೆಚ್ಚು ಮಾಡುವುದು",
                "ಜಾರು ಘರ್ಷಣೆಯನ್ನು ಹೆಚ್ಚು ಮಾಡುವುದು"
            ),
            correctAnswer = "ತರಲಗಳಲ್ಲಿ (ಗಾಳಿಯಲ್ಲಿ) ಉಂಟಾಗುವ ಘರ್ಷಣೆಯನ್ನು ಕಡಿಮೆ ಮಾಡುವುದು",
            explanation = "ಗಾಳಿಯು ವಿಮಾನದ ಚಲನೆಗೆ ಒಡ್ಡುವ ತರಲ ಘರ್ಷಣೆಯನ್ನು (Drag / Fluid Friction) ಕಡಿಮೆ ಮಾಡಲು ಪಕ್ಷಿಯಂತಹ ಧಾರೆರೇಖಾ ಆಕಾರ ನೀಡಲಾಗುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q27",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮೇಲ್ಮೈಗಳ ಮೇಲಿನ ಘರ್ಷಣಾ ಬಲದ ಸರಿಯಾದ ಇಳಿಕೆ ಕ್ರಮ (Decreasing Order) ಯಾವುದು? [NMMS-2024]",
            options = listOf(
                "ಸಿಮೆಂಟ್ ರಸ್ತೆ > ಗಾರೆಯ ನೆಲ > ನಯವಾದ ಲೋಹ > ನಿರ್ವಾತ",
                "ನಿರ್ವಾತ > ನಯವಾದ ಲೋಹ > ಗಾರೆಯ ನೆಲ > ಸಿಮೆಂಟ್ ರಸ್ತೆ",
                "ಗಾರೆಯ ನೆಲ > ಸಿಮೆಂಟ್ ರಸ್ತೆ > ನಿರ್ವಾತ > ನಯವಾದ ಲೋಹ",
                "ಸಿಮೆಂಟ್ ರಸ್ತೆ > ನಿರ್ವಾತ > ಗಾರೆಯ ನೆಲ > ನಯವಾದ ಲೋಹ"
            ),
            correctAnswer = "ಸಿಮೆಂಟ್ ರಸ್ತೆ > ಗಾರೆಯ ನೆಲ > ನಯವಾದ ಲೋಹ > ನಿರ್ವಾತ",
            explanation = "ಸಿಮೆಂಟ್ ರಸ್ತೆಯ ಒರಟುತನ ಗರಿಷ್ಠ, ನಂತರ ಗಾರೆ ನೆಲ, ನಯವಾದ ಲೋಹ, ಮತ್ತು ನಿರ್ವಾತದಲ್ಲಿ ಮಾಧ್ಯಮವೇ ಇಲ್ಲದಿರುವುದರಿಂದ ಘರ್ಷಣೆ ಶೂನ್ಯ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q28",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಬೈಕ್‌ನ ಪೆಟ್ರೋಲ್ ಟ್ಯಾಂಕ್‌ಗೆ ಬೆಂಕಿ ಬಿದ್ದಾಗ, ಬೆಂಕಿ ನಂದಿಸಲು ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂) ಅಗ್ನಿಶಾಮಕವನ್ನು ಆಯ್ಕೆ ಮಾಡಲು ಸೂಕ್ತ ಕಾರಣ: [NMMS-2024]",
            options = listOf(
                "CO₂ ಗಾಳಿಗಿಂತ ಭಾರವಾಗಿದ್ದು, ಇಂಧನ ಮತ್ತು ಆಕ್ಸಿಜನ್ ನಡುವಿನ ಸಂಪರ್ಕವನ್ನು ಕಡಿತಗೊಳಿಸುತ್ತದೆ",
                "CO₂ ಇಂಧನದ ಜ್ವಲನ ತಾಪವನ್ನು ತಕ್ಷಣ ಕಡಿಮೆ ಮಾಡುತ್ತದೆ",
                "CO₂ ಬೆಂಕಿಗೆ ಹೆಚ್ಚಿನ ಆಕ್ಸಿಜನ್ ಪೂರೈಸುತ್ತದೆ",
                "CO₂ ಪೆಟ್ರೋಲ್‌ನೊಂದಿಗೆ ರಾಸಾಯನಿಕ ಕ್ರಿಯೆ ನಡೆಸಿ ನೀರಾಗುತ್ತದೆ"
            ),
            correctAnswer = "CO₂ ಗಾಳಿಗಿಂತ ಭಾರವಾಗಿದ್ದು, ಇಂಧನ ಮತ್ತು ಆಕ್ಸಿಜನ್ ನಡುವಿನ ಸಂಪರ್ಕವನ್ನು ಕಡಿತಗೊಳಿಸುತ್ತದೆ",
            explanation = "CO₂ ಅನಿಲವು ಆಕ್ಸಿಜನ್‌ಗಿಂತ ಭಾರವಾಗಿರುವುದರಿಂದ ಬೆಂಕಿಯನ್ನು ಕಂಬಳಿಯಂತೆ ಆವರಿಸಿ ಆಕ್ಸಿಜನ್ ಸಂಪರ್ಕ ತಪ್ಪಿಸಿ ಬೆಂಕಿಯನ್ನು ನಂದಿಸುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q29",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮೇಣದಬತ್ತಿಯು ಉರಿಯುವಾಗ ಜ್ವಾಲೆಯನ್ನು (Flame) ಉಂಟುಮಾಡಲು ಕಾರಣವೇನು? [NMMS-2024]",
            options = listOf(
                "ಕರಗಿದ ಮೇಣವು ಬತ್ತಿಯ ಮೂಲಕ ಮೇಲೇರಿ ಆವಿಯಾಗುತ್ತದೆ",
                "ಮೇಣವು ದಪ್ಪ ವಸ್ತುವಾಗಿದ್ದು ಕೇವಲ ಗಾಳಿಯೊಂದಿಗೆ ಉರಿಯುತ್ತದೆ",
                "ಮೇಣದಲ್ಲಿ ಅನಿಲಗಳು ಇರುವುದಿಲ್ಲ",
                "ಮೇಣದ ಬತ್ತಿಯು ದ್ರವವಾಗಿಯೇ ಉಳಿಯುತ್ತದೆ"
            ),
            correctAnswer = "ಕರಗಿದ ಮೇಣವು ಬತ್ತಿಯ ಮೂಲಕ ಮೇಲೇರಿ ಆವಿಯಾಗುತ್ತದೆ",
            explanation = "ದಹನದ ಸಮಯದಲ್ಲಿ ಆವಿಯಾಗುವ (Vapourises) ಯಾವುದೇ ವಸ್ತು ಜ್ವಾಲೆಯನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ. ಮೇಣ ಆವಿಯಾಗಿ ಉರಿದು ಜ್ವಾಲೆ ನೀಡುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q30",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಜೇನುನೊಣ ಕಡಿದಾಗ ಮೊದಲು ಆ ಜಾಗವನ್ನು ನೀರಿನಿಂದ ತೊಳೆದು ನಂತರ ಅಡುಗೆ ಸೋಡಾವನ್ನು ಲೇಪಿಸಲು ವೈಜ್ಞಾನಿಕ ಕಾರಣ: [NMMS-2024]",
            options = listOf(
                "ನೀರು ಆಮ್ಲವನ್ನು ಸಾರರಿಕ್ತಗೊಳಿಸುತ್ತದೆ ಮತ್ತು ಪ್ರತ್ಯಾಮ್ಲೀಯ ಅಡುಗೆ ಸೋಡಾ ಅದನ್ನು ತಟಸ್ಥೀಕರಿಸುತ್ತದೆ",
                "ನೀರು ಪ್ರತ್ಯಾಮ್ಲವಾಗಿದ್ದು ಅಡುಗೆ ಸೋಡಾ ಲವಣವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ",
                "ನೀರು ಮತ್ತು ಅಡುಗೆ ಸೋಡಾ ಎರಡೂ ಆಮ್ಲಗಳಾಗಿವೆ",
                "ಅಡುಗೆ ಸೋಡಾ ಜೇನಿನ ಮುಳ್ಳನ್ನು ಕರಗಿಸುತ್ತದೆ"
            ),
            correctAnswer = "ನೀರು ಆಮ್ಲವನ್ನು ಸಾರರಿಕ್ತಗೊಳಿಸುತ್ತದೆ ಮತ್ತು ಪ್ರತ್ಯಾಮ್ಲೀಯ ಅಡುಗೆ ಸೋಡಾ ಅದನ್ನು ತಟಸ್ಥೀಕರಿಸುತ್ತದೆ",
            explanation = "ಜೇನುನೊಣದ ಕಡಿತದಲ್ಲಿ ಫಾರ್ಮಿಕ್ ಆಮ್ಲವಿರುತ್ತದೆ. ನೀರು ಸಾರತೆ ತಗ್ಗಿಸುತ್ತದೆ, ದುರ್ಬಲ ಪ್ರತ್ಯಾಮ್ಲ ಅಡುಗೆ ಸೋಡಾ (NaHCO₃) ನೋವನ್ನು ನಿವಾರಿಸುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q31",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ನಿಂಬೆರಸಕ್ಕೆ (ಸಿಟ್ರಿಕ್ ಆಮ್ಲ) ಅಡುಗೆ ಸೋಡಾವನ್ನು ಬೆರೆಸಿದಾಗ ಬಿಡುಗಡೆಯಾಗುವ ಅನಿಲವನ್ನು (CO₂) ಪರೀಕ್ಷಿಸುವ ಸೂಕ್ತ ವಿಧಾನ: [NMMS-2024]",
            options = listOf(
                "ಸುಣ್ಣದ ತಿಳಿ ನೀರಿನ ಮೂಲಕ ಹಾಯಿಸಿದಾಗ ಅದು ಹಾಲಿನಂತೆ ಬೆಳ್ಳಗಾಗುತ್ತದೆ",
                "ಉರಿಯುವ ಮೇಣದ ಬತ್ತಿಯನ್ನು ಹಿಡಿದಾಗ ಪಾಪ್ ಶಬ್ದದೊಂದಿಗೆ ಉರಿಯುತ್ತದೆ",
                "ಬೆಂಕಿ ಕಡ್ಡಿ ಹಿಡಿದಾಗ ಪ್ರಕಾಶಮಾನವಾಗಿ ಉರಿಯುತ್ತದೆ",
                "ನೀಲಿ ಲಿಟ್ಮಸ್ ಅನ್ನು ಕೆಂಪು ಮಾಡುವುದಿಲ್ಲ"
            ),
            correctAnswer = "ಸುಣ್ಣದ ತಿಳಿ ನೀರಿನ ಮೂಲಕ ಹಾಯಿಸಿದಾಗ ಅದು ಹಾಲಿನಂತೆ ಬೆಳ್ಳಗಾಗುತ್ತದೆ",
            explanation = "CO₂ ಅನಿಲವು ಸುಣ್ಣದ ತಿಳಿಯಾದ Ca(OH)₂ ನೊಂದಿಗೆ ವರ್ತಿಸಿ ಕರಗದ ಕ್ಯಾಲ್ಸಿಯಂ ಕಾರ್ಬೊನೇಟ್ (CaCO₃) ಉಂಟುಮಾಡಿ ಬೆಳ್ಳಗಾಗಿಸುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q32",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪಳೆಯುಳಿಕೆ ಇಂಧನಗಳು ಅಪೂರ್ಣವಾಗಿ ದಹನಗೊಂಡಾಗ (Incomplete Combustion) ಬಿಡುಗಡೆಯಾಗುವ ಅತ್ಯಂತ ಅಪಾಯಕಾರಿ ವಿಷಾನಿಲ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಕಾರ್ಬನ್ ಮೊನಾಕ್ಸೈಡ್ (CO)", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)", "ಸಲ್ಫರ್ ಡೈಆಕ್ಸೈಡ್", "ಮೀಥೇನ್"),
            correctAnswer = "ಕಾರ್ಬನ್ ಮೊನಾಕ್ಸೈಡ್ (CO)",
            explanation = "ಆಕ್ಸಿಜನ್ ಕೊರತೆಯಿದ್ದಾಗ ಕಾರ್ಬನ್ ಮೊನಾಕ್ಸೈಡ್ ಬಿಡುಗಡೆಯಾಗುತ್ತದೆ; ಇದು ರಕ್ತದ ಹಿಮೋಗ್ಲೋಬಿನ್ ಜೊತೆ ಸೇರಿ ಜೀವಕ್ಕೆ ಮಾರಕವಾಗುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q33",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಉತ್ತರ ಕರ್ನಾಟಕದ ರೈತರು ಒಂದು ಋತುವಿನಲ್ಲಿ ತೊಗರಿ ಮತ್ತು ಮುಂದಿನ ಋತುವಿನಲ್ಲಿ ಜೋಳ ಬೆಳೆಯುವ ಬೆಳೆ ಪರಿವರ್ತನೆಯ (Crop Rotation) ಮುಖ್ಯ ಉದ್ದೇಶ: [NMMS-2024]",
            options = listOf(
                "ಮಣ್ಣಿಗೆ ನೈಟ್ರೋಜನ್ ಅನ್ನು ನೈಸರ್ಗಿಕವಾಗಿ ಮರುಪೂರಣ ಮಾಡುವುದು",
                "ಕೀಟಗಳಿಂದ ಬೆಳೆಯನ್ನು ರಕ್ಷಿಸುವುದು",
                "ನೀರಿನ ಲಭ್ಯತೆಯನ್ನು ಸರಿದೂಗಿಸುವುದು",
                "ದೈನಂದಿನ ಬಳಕೆಗೆ ಆಹಾರ ಧಾನ್ಯ ಪಡೆಯುವುದು"
            ),
            correctAnswer = "ಮಣ್ಣಿಗೆ ನೈಟ್ರೋಜನ್ ಅನ್ನು ನೈಸರ್ಗಿಕವಾಗಿ ಮರುಪೂರಣ ಮಾಡುವುದು",
            explanation = "ದ್ವಿದಳ ಧಾನ್ಯದ ತೊಗರಿಯ ಬೇರಿನ ರೈಜೋಬಿಯಂ ಬ್ಯಾಕ್ಟೀರಿಯಾಗಳು ವಾತಾವರಣದ ಸಾರಜನಕವನ್ನು ಮಣ್ಣಿನಲ್ಲಿ ಸ್ಥಿರೀಕರಿಸಿ ಫಲವತ್ತತೆ ಹೆಚ್ಚಿಸುತ್ತವೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q34",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ರವಾ ಇಡ್ಲಿ ಹಿಟ್ಟಿಗೆ ಮೊಸರು ಬೆರೆಸಿದಾಗ ಹಿಟ್ಟು ಮೃದುವಾಗಿ ಉಬ್ಬಿ ಹುದುಗಲು (Fermentation) ಕಾರಣವಾಗುವ ಮೊಸರಿನಲ್ಲಿರುವ ಸೂಕ್ಷ್ಮಜೀವಿ: [NMMS-2024]",
            options = listOf("ಲ್ಯಾಕ್ಟೋಬ್ಯಾಸಿಲಸ್ (Lactobacillus)", "ಯೀಸ್ಟ್", "ಬ್ರೆಡ್ ಮೋಲ್ಡ್", "ಸಯನೋಬ್ಯಾಕ್ಟೀರಿಯಾ"),
            correctAnswer = "ಲ್ಯಾಕ್ಟೋಬ್ಯಾಸಿಲಸ್ (Lactobacillus)",
            explanation = "ಮೊಸರಿನಲ್ಲಿರುವ ಲ್ಯಾಕ್ಟೋಬ್ಯಾಸಿಲಸ್ ಬ್ಯಾಕ್ಟೀರಿಯಾ ಲ್ಯಾಕ್ಟಿಕ್ ಆಮ್ಲ ಮತ್ತು ಅನಿಲ ಬಿಡುಗಡೆ ಮಾಡಿ ಹಿಟ್ಟು ಹುದುಗುವಂತೆ ಮಾಡುತ್ತದೆ. [NMMS-2024]"
        ),
        QuestionModel(
            id = "nmms_2024_sat_sci_q35",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಈ ಕೆಳಗಿನ ಸಸ್ಯಗಳಲ್ಲಿ ಕೇವಲ ಗಂಡು ಅಥವಾ ಕೇವಲ ಹೆಣ್ಣು ಸಂತಾನೋತ್ಪತ್ತಿ ಅಂಗಗಳನ್ನು ಹೊಂದಿರುವ ಏಕಲಿಂಗಿ (Unisexual) ಹೂಗಳನ್ನು ಬಿಡುವ ಸಸ್ಯ ಯಾವುದು? [NMMS-2024]",
            options = listOf("ಸೌತೆಕಾಯಿ (Cucumber)", "ಸಾಸಿವೆ (Mustard)", "ಗುಲಾಬಿ (Rose)", "ದಾಸವಾಳ (Hibiscus)"),
            correctAnswer = "ಸೌತೆಕಾಯಿ (Cucumber)",
            explanation = "ಸೌತೆಕಾಯಿ, ಕುಂಬಳಕಾಯಿ, ಪಪ್ಪಾಯಿ ಮತ್ತು ಕಲ್ಲಂಗಡಿಗಳಲ್ಲಿ ಗಂಡು ಮತ್ತು ಹೆಣ್ಣು ಹೂಗಳು ಪ್ರತ್ಯೇಕವಾಗಿರುತ್ತವೆ (ಏಕಲಿಂಗಿ ಹೂಗಳು). [NMMS-2024]"
        ),
        // ========================================================
        // ಘಟಕ 6: NMMS-2023 ವಿಜ್ಞಾನ ಪ್ರಶ್ನೆಪತ್ರಿಕೆ (NMMS-2023 Paper 2 Science)
        // ========================================================
        QuestionModel(
            id = "nmms_2023_sat_sci_q1",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮಳೆಗಾಲದಲ್ಲಿ (ಜೂನ್‌ನಿಂದ ಸೆಪ್ಟೆಂಬರ್) ಬೆಳೆಯಲಾಗುವ ಈ ಕೆಳಗಿನ ಬೆಳೆಗಳಲ್ಲಿ ಖಾರಿಫ್ (Kharif) ಬೆಳೆ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ಭತ್ತ (Paddy)", "ಗೋಧಿ (Wheat)", "ಕಡಲೆ (Gram)", "ಸಾಸಿವೆ (Mustard)"),
            correctAnswer = "ಭತ್ತ (Paddy)",
            explanation = "ಭತ್ತ, ಮೆಕ್ಕೆಜೋಳ, ಸೋಯಾಬೀನ್, ಕಡಲೆಕಾಯಿ ಮತ್ತು ಹತ್ತಿ ಖಾರಿಫ್ ಬೆಳೆಗಳು. ಗೋಧಿ, ಕಡಲೆ ಮತ್ತು ಸಾಸಿವೆ ಚಳಿಗಾಲದ ರಬಿ (Rabi) ಬೆಳೆಗಳಾಗಿವೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q2",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮಾನವನಲ್ಲಿ ರಕ್ತಾತಿಸಾರ (Amoebic Dysentery) ರೋಗವನ್ನು ಉಂಟುಮಾಡುವ ಪ್ರೋಟೋಜೋವಾ ಸೂಕ್ಷ್ಮಜೀವಿ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ಎಂಟಮೀಬಾ ಹಿಸ್ಟೋಲಿಟಿಕಾ (Entamoeba)", "ಪ್ಲಾಸ್ಮೋಡಿಯಂ", "ಪ್ಯಾರಾಮೀಶಿಯಂ", "ಯುಗ್ಲಿನಾ"),
            correctAnswer = "ಎಂಟಮೀಬಾ ಹಿಸ್ಟೋಲಿಟಿಕಾ (Entamoeba)",
            explanation = "ಎಂಟಮೀಬಾ ಹಿಸ್ಟೋಲಿಟಿಕಾ ಕರುಳಿನಲ್ಲಿ ಸೋಂಕು ಉಂಟುಮಾಡಿ ಅಮೀಬಿಕ್ ಭೇದಿ ಅಥವಾ ರಕ್ತಾತಿಸಾರಕ್ಕೆ ಕಾರಣವಾಗುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q3",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಯಾವುದೇ ನೈಸರ್ಗಿಕ ಕಚ್ಚಾವಸ್ತುವನ್ನು ಬಳಸದೆ ಕಲ್ಲಿದ್ದಲು, ನೀರು ಮತ್ತು ಗಾಳಿಯಿಂದ 1931 ರಲ್ಲಿ ತಯಾರಿಸಲ್ಪಟ್ಟ ಪ್ರಪ್ರಥಮ ಸಂಪೂರ್ಣ ಸಂಶ್ಲೇಷಿತ ಎಳೆ (Synthetic fibre): [NMMS-2023]",
            options = listOf("ನೈಲಾನ್ (Nylon)", "ರೇಯಾನ್", "ಪಾಲಿಯೆಸ್ಟರ್", "ಅಕ್ರಿಲಿಕ್"),
            correctAnswer = "ನೈಲಾನ್ (Nylon)",
            explanation = "ನೈಲಾನ್ ಮಾನವ ನಿರ್ಮಿತ ಪ್ರಥಮ ಸಂಪೂರ್ಣ ಸಂಶ್ಲೇಷಿತ ಎಳೆಯಾಗಿದ್ದು ಅತ್ಯಂತ ಬಲವಾದ, ಸ್ಥಿತಿಸ್ಥಾಪಕ ಮತ್ತು ಹಗುರವಾದ ಗುಣ ಹೊಂದಿದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q4",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಗಾಳಿಯಲ್ಲಿರುವ ಆಕ್ಸಿಜನ್‌ನೊಂದಿಗೆ ತಕ್ಷಣ ವರ್ತಿಸಿ ಬೆಂಕಿ ಹೊತ್ತಿಕೊಳ್ಳುವುದರಿಂದ ನೀರಿನಲ್ಲಿ ಸಂಗ್ರಹಿಸಿಡುವ ಅಲೋಹ (Non-metal) ಯಾವುದು? [NMMS-2023]",
            options = listOf("ರಂಜಕ (Phosphorus)", "ಗಂಧಕ (Sulphur)", "ಕಾರ್ಬನ್", "ಅಯೋಡಿನ್"),
            correctAnswer = "ರಂಜಕ (Phosphorus)",
            explanation = "ಬಿಳಿ ರಂಜಕವು ಅತ್ಯಂತ ಕ್ರಿಯಾಶೀಲ ಅಲೋಹವಾಗಿದ್ದು ಗಾಳಿಗೆ ತೆರೆದಿಟ್ಟಾಗ ಸುಲಭವಾಗಿ ಹೊತ್ತಿ ಉರಿಯುತ್ತದೆ. ಆದ್ದರಿಂದ ಇದನ್ನು ನೀರಿನಲ್ಲಿ ಶೇಖರಿಸಲಾಗುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q5",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ನೈಸರ್ಗಿಕ ಅನಿಲ (CNG - Compressed Natural Gas) ದಲ್ಲಿ ಅತಿ ಹೆಚ್ಚಿನ ಪ್ರಮಾಣದಲ್ಲಿರುವ ಪ್ರಮುಖ ಹೈಡ್ರೋಕಾರ್ಬನ್ ಅಂಶ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ಮೀಥೇನ್ (Methane - CH₄)", "ಬ್ಯುಟೇನ್", "ಪ್ರೋಪೇನ್", "ಈಥೇನ್"),
            correctAnswer = "ಮೀಥೇನ್ (Methane - CH₄)",
            explanation = "ನೈಸರ್ಗಿಕ ಅನಿಲ ಮತ್ತು ಸಿ.ಎನ್.ಜಿ ಯಲ್ಲಿ ಶೇಕಡಾ 85 ರಿಂದ 95 ರಷ್ಟು ಮೀಥೇನ್ ಅನಿಲವೇ ಇರುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q6",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮೇಣದಬತ್ತಿಯ ಜ್ವಾಲೆಯಲ್ಲಿ ಅತಿ ಹೆಚ್ಚು ಉಷ್ಣತೆಯನ್ನು ಹೊಂದಿರುವ ಸಂಪೂರ್ಣ ದಹನದ ಹೊರ ವಲಯದ ಬಣ್ಣ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ನೀಲಿ (Blue - Non-luminous)", "ಹಳದಿ", "ಕಪ್ಪು", "ಕೆಂಪು"),
            correctAnswer = "ನೀಲಿ (Blue - Non-luminous)",
            explanation = "ಹೊರಗಿನ ನೀಲಿ ವಲಯದಲ್ಲಿ ಆಕ್ಸಿಜನ್ ಸಮೃದ್ಧವಾಗಿ ಸಿಗುವುದರಿಂದ ಸಂಪೂರ್ಣ ದಹನ ನಡೆದು ಅತಿ ಹೆಚ್ಚಿನ ಶಾಖ ಉತ್ಪತ್ತಿಯಾಗುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q7",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದು ನಿರ್ದಿಷ್ಟ ಭೌಗೋಳಿಕ ಪ್ರದೇಶದಲ್ಲಿ ಮಾತ್ರ ನೈಸರ್ಗಿಕವಾಗಿ ಕಂಡುಬರುವ ಸಸ್ಯ ಮತ್ತು ಪ್ರಾಣಿ ಪ್ರಭೇದಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ? [NMMS-2023]",
            options = listOf("ಸ್ಥಳೀಯ ಪ್ರಭೇದಗಳು (Endemic species)", "ಅಳಿವಿನಂಚಿನ ಪ್ರಭೇದಗಳು", "ವಲಸೆ ಪ್ರಭೇದಗಳು", "ಅಪರೂಪದ ಪ್ರಭೇದಗಳು"),
            correctAnswer = "ಸ್ಥಳೀಯ ಪ್ರಭೇದಗಳು (Endemic species)",
            explanation = "ಒಂದು ನಿರ್ದಿಷ್ಟ ಪ್ರದೇಶಕ್ಕೆ ಮಾತ್ರ ಸೀಮಿತವಾಗಿರುವ ಜೀವಿಗಳನ್ನು ಸ್ಥಳೀಯ ಪ್ರಭೇದಗಳು (Endemic species) ಎನ್ನುತ್ತಾರೆ (ಉದಾ: ಪಚ್‌ಮರ್ಹಿಯ ಸಾಲ್ ಮರ ಮತ್ತು ಹಾರುವ ಅಳಿಲು). [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q8",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಜೀವಕೋಶ ಹಾನಿಗೊಳಗಾದಾಗ ಜೀರ್ಣಕಾರಿ ಕಿಣ್ವಗಳನ್ನು ಬಿಡುಗಡೆ ಮಾಡಿ ಸ್ವತಃ ಜೀವಕೋಶವನ್ನೇ ಜೀರ್ಣಿಸಿಕೊಳ್ಳುವುದರಿಂದ 'ಆತ್ಮಹತ್ಯಾ ಸಂಚಿಗಳು' (Suicide bags) ಎನಿಸಿಕೊಂಡ ಕಣದಂಗ: [NMMS-2023]",
            options = listOf("ಲೈಸೋಸೋಮ್‌ಗಳು (Lysosomes)", "ಮೈಟೋಕಾಂಡ್ರಿಯಾ", "ರೈಬೋಸೋಮ್‌ಗಳು", "ಪ್ಲಾಸ್ಟಿಡ್‌ಗಳು"),
            correctAnswer = "ಲೈಸೋಸೋಮ್‌ಗಳು (Lysosomes)",
            explanation = "ಲೈಸೋಸೋಮ್‌ಗಳು ಪ್ರಬಲ ಜೀರ್ಣಕಾರಿ ಕಿಣ್ವಗಳನ್ನು ಹೊಂದಿದ್ದು, ಜೀವಕೋಶ ನಾಶವಾದಾಗ ಸ್ಫೋಟಗೊಂಡು ಸ್ವಂತ ಜೀವಕೋಶವನ್ನೇ ಕರಗಿಸುತ್ತವೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q9",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಅಮೀಬಾದಲ್ಲಿ ಪ್ರಧಾನವಾಗಿ ಕಂಡುಬರುವ ಅಲೈಂಗಿಕ ಸಂತಾನೋತ್ಪತ್ತಿಯ ವಿಧಾನ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ದ್ವಿವಿದಳನ (Binary Fission)", "ಮೊಗ್ಗುಡುವಿಕೆ (Budding)", "ಕಾಯಜ ಸಂತಾನೋತ್ಪತ್ತಿ", "ಬೀಜಕ ರಚನೆ"),
            correctAnswer = "ದ್ವಿವಿದಳನ (Binary Fission)",
            explanation = "ಏಕಕೋಶೀಯ ಅಮೀಬಾದ ಕೋಶಕೇಂದ್ರ ಮೊದಲು ಎರಡಾಗಿ ವಿಭಜನೆಗೊಂಡು ನಂತರ ಜೀವಕೋಶ ಎರಡು ತದ್ರೂಪಿ ಮರಿ ಅಮೀಬಾಗಳಾಗುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q10",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮಾನವ ದೇಹದಲ್ಲಿ ಇತರ ಅಂತಃಸ್ರಾವಕ ಗ್ರಂಥಿಗಳ ಹಾರ್ಮೋನ್ ಸ್ರವಿಕೆಯನ್ನು ನಿಯಂತ್ರಿಸುವ 'ಪ್ರಧಾನ ಗ್ರಂಥಿ' (Master Gland) ಯಾವುದು? [NMMS-2023]",
            options = listOf("ಪಿಟ್ಯುಟರಿ ಗ್ರಂಥಿ (Pituitary Gland)", "ಥೈರಾಯ್ಡ್ ಗ್ರಂಥಿ", "ಮೇದೋಜೀರಕ ಗ್ರಂಥಿ", "ಅಡ್ರಿನಲ್ ಗ್ರಂಥಿ"),
            correctAnswer = "ಪಿಟ್ಯುಟರಿ ಗ್ರಂಥಿ (Pituitary Gland)",
            explanation = "ಮೆದುಳಿನ ಬುಡದಲ್ಲಿರುವ ಪಿಟ್ಯುಟರಿ ಗ್ರಂಥಿಯು ಬೆಳವಣಿಗೆ ಹಾರ್ಮೋನ್ ಹಾಗೂ ಇತರ ಗ್ರಂಥಿಗಳನ್ನು ಉತ್ತೇಜಿಸುವ ಟ್ರೋಪಿಕ್ ಹಾರ್ಮೋನ್‌ಗಳನ್ನು ಸ್ರವಿಸುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q11",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ವಾತಾವರಣದ ಗಾಳಿಯು ಭೂಮಿಯ ಮೇಲ್ಮೈ ಮೇಲೆ ಉಂಟುಮಾಡುವ ವಾತಾವರಣದ ಒತ್ತಡವನ್ನು (Atmospheric pressure) ಅಳೆಯಲು ಬಳಸುವ ಉಪಕರಣ: [NMMS-2023]",
            options = listOf("ಬಾರೋಮೀಟರ್ (Barometer)", "ಥರ್ಮಾಮೀಟರ್", "ಆಲ್ಟಿಮೀಟರ್", "ಆಮ್ಮೀಟರ್"),
            correctAnswer = "ಬಾರೋಮೀಟರ್ (Barometer)",
            explanation = "ಟಾರಿಸೆಲ್ಲಿ ಕಂಡುಹಿಡಿದ ಪಾದರಸದ ಬಾರೋಮೀಟರ್ ವಾತಾವರಣದ ಒತ್ತಡವನ್ನು ನಿಖರವಾಗಿ ಅಳೆಯಲು ಬಳಕೆಯಾಗುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q12",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ದ್ರವಗಳು ಮತ್ತು ಅನಿಲಗಳಲ್ಲಿ (Fluids) ಚಲಿಸುವ ಕಾಯಗಳ ಮೇಲೆ ಮಾಧ್ಯಮವು ಉಂಟುಮಾಡುವ ಘರ್ಷಣಾ ಬಲಕ್ಕೆ ಇರುವ ವೈಜ್ಞಾನಿಕ ಹೆಸರೇನು? [NMMS-2023]",
            options = listOf("ಕರ್ಷಣ / ದ್ರವ ಘರ್ಷಣೆ (Drag)", "ಸ್ಥಿತಿ ಘರ್ಷಣೆ", "ಉರುಳುವ ಘರ್ಷಣೆ", "ಸ್ಥಾಯೀವಿದ್ಯುತ್ ಬಲ"),
            correctAnswer = "ಕರ್ಷಣ / ದ್ರವ ಘರ್ಷಣೆ (Drag)",
            explanation = "ದ್ರವ ಅಥವಾ ಅನಿಲದ ಮೂಲಕ ಚಲಿಸುವ ಯಾವುದೇ ವಸ್ತುವಿನ ಚಲನೆಯನ್ನು ವಿರೋಧಿಸುವ ಬಲಕ್ಕೆ ಕರ್ಷಣ ಅಥವಾ ಡ್ರ್ಯಾಗ್ (Drag) ಎನ್ನುತ್ತಾರೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q13",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಧ್ವನಿಯ ತೀಕ್ಷ್ಣತೆ ಅಥವಾ ಕೀರಲು ಧ್ವನಿಯನ್ನು (Pitch / Shrillness of sound) ನಿರ್ಧರಿಸುವ ಧ್ವನಿ ತರಂಗದ ಪ್ರಮುಖ ಲಕ್ಷಣ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ಆವರ್ತನೆ (Frequency)", "ವ್ಯಾಪ್ತಿ / ಕಂಪನ ವಿಸ್ತಾರ (Amplitude)", "ವೇಗ", "ತರಂಗಾಂತರ"),
            correctAnswer = "ಆವರ್ತನೆ (Frequency)",
            explanation = "ಆವರ್ತನೆ ಹೆಚ್ಚಾದಂತೆ ಧ್ವನಿಯ ಪಿಚ್ (ತೀಕ್ಷ್ಣತೆ) ಹೆಚ್ಚಾಗುತ್ತದೆ. ಕಂಪನ ವಿಸ್ತಾರವು ಶಬ್ದದ ತೀವ್ರತೆಯನ್ನು (Loudness) ನಿರ್ಧರಿಸುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q14",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕಬ್ಬಿಣದ ಚಮಚದ ಮೇಲೆ ಬೆಳ್ಳಿಯ ಲೇಪನ (Electroplating) ಮಾಡುವಾಗ, ಕಬ್ಬಿಣದ ಚಮಚವನ್ನು ಬ್ಯಾಟರಿಯ ಯಾವ ತುದಿಗೆ ಜೋಡಿಸಬೇಕು? [NMMS-2023]",
            options = listOf("ಋಣ ತುದಿ / ಕ್ಯಾಥೋಡ್ (Negative terminal)", "ಧನ ತುದಿ / ಆನೋಡ್", "ಯಾವುದಾದರೂ ತುದಿ", "ಅರ್ಥಿಂಗ್ ತಂತಿ"),
            correctAnswer = "ಋಣ ತುದಿ / ಕ್ಯಾಥೋಡ್ (Negative terminal)",
            explanation = "ವಿದ್ಯುಲ್ಲೇಪನದಲ್ಲಿ ಯಾವ ವಸ್ತುವಿನ ಮೇಲೆ ಲೇಪನ ಮಾಡಬೇಕೋ ಅದನ್ನು ಕ್ಯಾಥೋಡ್ (ಋಣ ತುದಿ) ಗೆ ಮತ್ತು ಲೇಪನ ಮಾಡಬೇಕಾದ ಲೋಹವನ್ನು ಆನೋಡ್ ಗೆ ಸಂಪರ್ಕಿಸಲಾಗುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q15",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದು ವಸ್ತುವಿನಲ್ಲಿ ವಿದ್ಯುತ್ ಆವೇಶ (Electric charge) ಇದೆಯೇ ಅಥವಾ ಇಲ್ಲವೇ ಎಂಬುದನ್ನು ಪರೀಕ್ಷಿಸಲು ಬಳಸುವ ಸರಳ ಭೌತ ಉಪಕರಣ: [NMMS-2023]",
            options = listOf("ವಿದ್ಯುತ್‌ದರ್ಶಕ (Electroscope)", "ವೋಲ್ಟ್‌ಮೀಟರ್", "ಗ್ಯಾಲ್ವನೋಮೀಟರ್", "ಪೆರಿಸ್ಕೋಪ್"),
            correctAnswer = "ವಿದ್ಯುತ್‌ದರ್ಶಕ (Electroscope)",
            explanation = "ಚಿನ್ನದ ಎಲೆಯ ವಿದ್ಯುತ್‌ದರ್ಶಕ (Gold leaf electroscope) ವು ಆವೇಶಭರಿತ ವಸ್ತುವಿನ ಸಂಪರ್ಕದಿಂದ ಎಲೆಗಳು ವಿಕರ್ಷಿಸುವುದರ ಮೂಲಕ ಆವೇಶವನ್ನು ಪತ್ತೆ ಮಾಡುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q16",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಬೆಳಕಿನ ನಿಯಮಿತ ಪ್ರತಿಫಲನದಲ್ಲಿ ಪತನ ಕೋನವು (Angle of incidence, i) 40° ಆಗಿದ್ದರೆ, ಪ್ರತಿಫಲನ ಕೋನದ (Angle of reflection, r) ಅಳತೆ ಎಷ್ಟು? [NMMS-2023]",
            options = listOf("40°", "50°", "80°", "90°"),
            correctAnswer = "40°",
            explanation = "ಬೆಳಕಿನ ಪ್ರತಿಫಲನದ ಮೊದಲ ನಿಯಮದ ಪ್ರಕಾರ ಪತನ ಕೋನವು ಯಾವಾಗಲೂ ಪ್ರತಿಫಲನ ಕೋನಕ್ಕೆ ಸಮನಾಗಿರುತ್ತದೆ (∠i = ∠r). ಆದ್ದರಿಂದ ∠r = 40°. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q17",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಸೂರ್ಯನನ್ನು ಹೊರತುಪಡಿಸಿ ಭೂಮಿಗೆ ಅತ್ಯಂತ ಸಮೀಪದಲ್ಲಿರುವ ನಕ್ಷತ್ರ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ಪ್ರಾಕ್ಸಿಮಾ ಸೆಂಚುರಿ / ಆಲ್ಫಾ ಸೆಂಚುರಿ", "ಸಿರಿಯಸ್ (ಲುಬ್ಧಕ)", "ಧ್ರುವ ನಕ್ಷತ್ರ", "ಬೆಟೆಲ್‌ಗ್ಯೂಸ್"),
            correctAnswer = "ಪ್ರಾಕ್ಸಿಮಾ ಸೆಂಚುರಿ / ಆಲ್ಫಾ ಸೆಂಚುರಿ",
            explanation = "ಆಲ್ಫಾ ಸೆಂಚುರಿ ವ್ಯವಸ್ಥೆಯಲ್ಲಿರುವ ಪ್ರಾಕ್ಸಿಮಾ ಸೆಂಚುರಿ ಭೂಮಿಯಿಂದ ಸುಮಾರು 4.22 ಜ್ಯೋತಿರ್ವರ್ಷಗಳ ದೂರದಲ್ಲಿದ್ದು ಸೂರ್ಯನ ನಂತರದ ಅತಿ ಹತ್ತಿರದ ನಕ್ಷತ್ರವಾಗಿದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q18",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಉಷ್ಣತೆಯನ್ನು ಹೆಚ್ಚಿಸಿ ಜಾಗತಿಕ ತಾಪಮಾನ ಏರಿಕೆಗೆ (Global Warming) ಕಾರಣವಾಗುವ ಪ್ರಮುಖ ಹಸಿರುಮನೆ ಅನಿಲ (Greenhouse Gas) ಯಾವುದು? [NMMS-2023]",
            options = listOf("ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)", "ಆಕ್ಸಿಜನ್", "ಸಾರಜನಕ (Nitrogen)", "ಆರ್ಗಾನ್"),
            correctAnswer = "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ (CO₂)",
            explanation = "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್ ಮತ್ತು ಮೀಥೇನ್ ಅನಿಲಗಳು ಭೂಮಿಯಿಂದ ಹೊರಹೊಮ್ಮುವ ಅವರಕ್ತ ಕಿರಣಗಳನ್ನು ಹಿಡಿದಿಟ್ಟು ತಾಪಮಾನವನ್ನು ಹೆಚ್ಚಿಸುತ್ತವೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q19",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ದ್ವಿದಳ ಧಾನ್ಯ ಸಸ್ಯಗಳ ಬೇರುಗಳ ಗಂಟುಗಳಲ್ಲಿ ವಾಸಿಸುತ್ತಾ ವಾತಾವರಣದ ಸಾರಜನಕವನ್ನು ಸ್ಥಿರೀಕರಿಸುವ ಸಹಜೀವಿ ಬ್ಯಾಕ್ಟೀರಿಯಾ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ರೈಜೋಬಿಯಂ (Rhizobium)", "ಅಜೋಟೋಬ್ಯಾಕ್ಟರ್", "ಸ್ಪೈರೊಗೈರಾ", "ಕ್ಲಾಮಿಡೋಮೊನಾಸ್"),
            correctAnswer = "ರೈಜೋಬಿಯಂ (Rhizobium)",
            explanation = "ರೈಜೋಬಿಯಂ ಬ್ಯಾಕ್ಟೀರಿಯಾಗಳು ದ್ವಿದಳ ಸಸ್ಯಗಳ ಬೇರಿನ ಗಂಟುಗಳಲ್ಲಿ ವಾಸಿಸಿ ಮಣ್ಣಿನ ಫಲವತ್ತತೆಯನ್ನು ನೈಸರ್ಗಿಕವಾಗಿ ಹೆಚ್ಚಿಸುತ್ತವೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q20",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮೆಗ್ನೀಸಿಯಮ್ ತಂತಿಯನ್ನು ಗಾಳಿಯಲ್ಲಿ ಉರಿಸಿದಾಗ ಉಂಟಾಗುವ ಬೂದಿಯನ್ನು (MgO) ನೀರಿನಲ್ಲಿ ಕರಗಿಸಿದಾಗ ದೊರೆಯುವ ದ್ರಾವಣದ ಸ್ವಭಾವವೇನು? [NMMS-2023]",
            options = listOf("ಪ್ರತ್ಯಾಮ್ಲೀಯ (Basic - turns red litmus blue)", "ಆಮ್ಲೀಯ", "ತಟಸ್ಥ", "ಉಪ್ಪಿನ ದ್ರಾವಣ"),
            correctAnswer = "ಪ್ರತ್ಯಾಮ್ಲೀಯ (Basic - turns red litmus blue)",
            explanation = "ಲೋಹದ ಆಕ್ಸೈಡ್‌ಗಳು ಪ್ರತ್ಯಾಮ್ಲೀಯವಾಗಿರುತ್ತವೆ. MgO + H₂O -> Mg(OH)₂ (ಮೆಗ್ನೀಸಿಯಮ್ ಹೈಡ್ರಾಕ್ಸೈಡ್) ಕೆಂಪು ಲಿಟ್ಮಸ್ ಅನ್ನು ನೀಲಿಯಾಗಿಸುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q21",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮಾನವ ದೇಹದ ಪ್ರತಿಯೊಂದು ಸಾಮಾನ್ಯ ಜೀವಕೋಶದ ಕೋಶಕೇಂದ್ರದಲ್ಲಿರುವ ಕ್ರೋಮೋಸೋಮ್‌ಗಳ ಒಟ್ಟು ಜೋಡಿಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು? [NMMS-2023]",
            options = listOf("23 ಜೋಡಿಗಳು (46 ಕ್ರೋಮೋಸೋಮ್)", "22 ಜೋಡಿಗಳು", "24 ಜೋಡಿಗಳು", "46 ಜೋಡಿಗಳು"),
            correctAnswer = "23 ಜೋಡಿಗಳು (46 ಕ್ರೋಮೋಸೋಮ್)",
            explanation = "ಮಾನವನಲ್ಲಿ 22 ಜೋಡಿ ಆಟೋಸೋಮ್‌ಗಳು ಮತ್ತು 1 ಜೋಡಿ ಲೈಂಗಿಕ ಕ್ರೋಮೋಸೋಮ್‌ಗಳು (XX ಅಥವಾ XY) ಸೇರಿದಂತೆ ಒಟ್ಟು 23 ಜೋಡಿ (46) ಇರುತ್ತವೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q22",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮಾನವನ ಕಣ್ಣಿನಲ್ಲಿ ವಸ್ತುವಿನ ನೈಜ ಮತ್ತು ತಲೆಕೆಳಗಾದ ಬಿಂಬವು (Real & inverted image) ಮೂಡುವ ಅತ್ಯಂತ ಸೂಕ್ಷ್ಮ ಹಿಂಬದಿಯ ಪರದೆ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ದೃಷ್ಟಿಪಟಲ / ರೆಟಿನಾ (Retina)", "ಕಣ್ಣಿನ ಪಾಪೆ (Pupil)", "ಕಾರ್ನಿಯಾ", "ಐರಿಸ್"),
            correctAnswer = "ದೃಷ್ಟಿಪಟಲ / ರೆಟಿನಾ (Retina)",
            explanation = "ರೆಟಿನಾದ ಮೇಲಿರುವ ರಾಡ್ ಮತ್ತು ಕೋನ್ ಜೀವಕೋಶಗಳು ಬೆಳಕಿನ ಸಂವೇದನೆಯನ್ನು ಗ್ರಹಿಸಿ ದೃಷ್ಟಿನರದ ಮೂಲಕ ಮೆದುಳಿಗೆ ರವಾನಿಸುತ್ತವೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q23",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಧ್ವನಿಯು ಕೆಳಗಿನ ಯಾವ ಮಾಧ್ಯಮದಲ್ಲಿ ಅತ್ಯಂತ ವೇಗವಾಗಿ ಪ್ರಸಾರವಾಗುತ್ತದೆ? [NMMS-2023]",
            options = listOf("ಘನ ಮಾಧ್ಯಮ (ಉದಾ: ಉಕ್ಕು / ಕಬ್ಬಿಣ)", "ದ್ರವ ಮಾಧ್ಯಮ (ನೀರು)", "ಅನಿಲ ಮಾಧ್ಯಮ (ಗಾಳಿ)", "ನಿರ್ವಾತ ಪ್ರದೇಶ"),
            correctAnswer = "ಘನ ಮಾಧ್ಯಮ (ಉದಾ: ಉಕ್ಕು / ಕಬ್ಬಿಣ)",
            explanation = "ಕಣಗಳು ಅತ್ಯಂತ ಸಾಂದ್ರವಾಗಿ ಜೋಡಣೆಗೊಂಡಿರುವುದರಿಂದ ಧ್ವನಿಯು ಘನವಸ್ತುಗಳಲ್ಲಿ (ಸುಮಾರು 5000 m/s) ಅತ್ಯಂತ ವೇಗವಾಗಿರುತ್ತದೆ. ನಿರ್ವಾತದಲ್ಲಿ ಧ್ವನಿ ಪ್ರಸಾರವಾಗುವುದಿಲ್ಲ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q24",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ನೀಲಿ ಬಣ್ಣದ ತಾಮ್ರದ ಸಲ್ಫೇಟ್ (CuSO₄) ದ್ರಾವಣಕ್ಕೆ ಸತು (Zinc) ವನ್ನು ಸೇರಿಸಿದಾಗ ಉಂಟಾಗುವ ಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆಯಲ್ಲಿ ಕೆಳಗೆ ತಳವೂರುವ ಕೆಂಪು ಲೋಹ ಯಾವುದು? [NMMS-2023]",
            options = listOf("ತಾಮ್ರ (Copper - Cu)", "ಸತು (Zinc)", "ಕಬ್ಬಿಣ", "ಅಲ್ಯೂಮಿನಿಯಂ"),
            correctAnswer = "ತಾಮ್ರ (Copper - Cu)",
            explanation = "ಸತುವು ತಾಮ್ರಕ್ಕಿಂತ ಹೆಚ್ಚು ಕ್ರಿಯಾಶೀಲವಾಗಿರುವುದರಿಂದ Zn + CuSO₄ -> ZnSO₄ + Cu ಕ್ರಿಯೆ ನಡೆದು ತಾಮ್ರವು ಮುಕ್ತವಾಗಿ ತಳದಲ್ಲಿ ಸಂಗ್ರಹವಾಗುತ್ತದೆ. [NMMS-2023]"
        ),
        QuestionModel(
            id = "nmms_2023_sat_sci_q25",
            stdId = 12,
            subjectId = "sat_science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಬಳಿ ನಿಯಮಿತವಾಗಿ ಹಾದುಹೋಗುವ ಪ್ರಸಿದ್ಧ 'ಹ್ಯಾಲಿಯ ಧೂಮಕೇತು' (Halley's Comet) ಸರಿಸುಮಾರು ಎಷ್ಟು ವರ್ಷಗಳಿಗೊಮ್ಮೆ ಗೋಚರಿಸುತ್ತದೆ? [NMMS-2023]",
            options = listOf("76 ವರ್ಷಗಳಿಗೊಮ್ಮೆ", "50 ವರ್ಷಗಳಿಗೊಮ್ಮೆ", "100 ವರ್ಷಗಳಿಗೊಮ್ಮೆ", "25 ವರ್ಷಗಳಿಗೊಮ್ಮೆ"),
            correctAnswer = "76 ವರ್ಷಗಳಿಗೊಮ್ಮೆ",
            explanation = "ಹ್ಯಾಲಿಯ ಧೂಮಕೇತು ಪ್ರತಿ 75-76 ವರ್ಷಗಳಿಗೊಮ್ಮೆ ಸೂರ್ಯನ ಸುತ್ತ ತನ್ನ ಕಕ್ಷೆಯನ್ನು ಪೂರ್ಣಗೊಳಿಸಿ ಭೂಮಿಗೆ ಗೋಚರಿಸುತ್ತದೆ (ಕೊನೆಯದಾಗಿ 1986 ರಲ್ಲಿ ಗೋಚರಿಸಿತ್ತು). [NMMS-2023]"
        )
    )
}
