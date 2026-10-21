package com.example.data

/**
 * Standard 7 Science Part 2 (Units 7 to 12 - LBA Revised 2026-27, Kannada Medium)
 * Unit 7: ನಿಸರ್ಗದಲ್ಲಿ ಉಷ್ಣ ವರ್ಗಾವಣೆ
 * Unit 8: ಕಾಲ ಮತ್ತು ಚಲನೆಯ ಅಳತೆ
 * Unit 9: ಪ್ರಾಣಿಗಳಲ್ಲಿ ಜೀವ ಕ್ರಿಯೆಗಳು
 * Unit 10: ಸಸ್ಯಗಳಲ್ಲಿ ಜೀವ ಕ್ರಿಯೆಗಳು
 * Unit 11: ಬೆಳಕು: ನೆರಳುಗಳು ಮತ್ತು ಪ್ರತಿಫಲನಗಳು
 * Unit 12: ಭೂಮಿ, ಚಂದ್ರ ಮತ್ತು ಸೂರ್ಯ
 */
object Std7SciencePart2QuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಬದಲಾಗುತ್ತಿರುವ ವಿಜ್ಞಾನದ ಜಗತ್ತು", 14, "Easy"),
        UnitTemplate(2, "ಘಟಕ 2: ಆಮ್ಲಗಳು, ಪ್ರತ್ಯಾಮ್ಲಗಳು ಮತ್ತು ಲವಣಗಳು", 12, "Medium"),
        UnitTemplate(3, "ಘಟಕ 3: ವಿದ್ಯುತ್ ಕ್ಷೇಮ ಮತ್ತು ಮಂಡಲಗಳು", 8, "Medium"),
        UnitTemplate(4, "ಘಟಕ 4: ಲೋಹಗಳು ಮತ್ತು ಅಲೋಹಗಳ ಜಗತ್ತು", 6, "Medium"),
        UnitTemplate(5, "ಘಟಕ 5: ಭೌತ ಮತ್ತು ರಾಸಾಯನಿಕ ಬದಲಾವಣೆಗಳು", 5, "Easy"),
        UnitTemplate(6, "ಘಟಕ 6: ಹದಿಹರೆಯ - ಬೆಳವಣಿಗೆಯ ಹಂತ", 4, "Easy"),
        UnitTemplate(7, "ಘಟಕ 7: ನಿಸರ್ಗದಲ್ಲಿ ಉಷ್ಣ ವರ್ಗಾವಣೆ", 12, "Medium"),
        UnitTemplate(8, "ಘಟಕ 8: ಕಾಲ ಮತ್ತು ಚಲನೆಯ ಅಳತೆ", 12, "Medium"),
        UnitTemplate(9, "ಘಟಕ 9: ಪ್ರಾಣಿಗಳಲ್ಲಿ ಜೀವ ಕ್ರಿಯೆಗಳು", 12, "Hard"),
        UnitTemplate(10, "ಘಟಕ 10: ಸಸ್ಯಗಳಲ್ಲಿ ಜೀವ ಕ್ರಿಯೆಗಳು", 10, "Medium"),
        UnitTemplate(11, "ಘಟಕ 11: ಬೆಳಕು - ನೆರಳು ಮತ್ತು ಪ್ರತಿಫಲನ", 14, "Medium"),
        UnitTemplate(12, "ಘಟಕ 12: ಭೂಮಿ, ಚಂದ್ರ ಮತ್ತು ಸೂರ್ಯ", 14, "Medium")
    )

    val questions: List<QuestionModel> = listOf(
        // ==================== ಘಟಕ 7: ನಿಸರ್ಗದಲ್ಲಿ ಉಷ್ಣ ವರ್ಗಾವಣೆ ====================
        QuestionModel(
            id = "s_7_sci_u7_1",
            stdId = 7,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಘನ ವಸ್ತುಗಳಲ್ಲಿ ಉಷ್ಣ ವರ್ಗಾವಣೆಯಾಗುವ ಮುಖ್ಯ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಉಷ್ಣಸಂವಹನ", "ಉಷ್ಣವಹನ / ಉಷ್ಣಪರಸರಣ (Conduction)", "ಉಷ್ಣವಿಕಿರಣ", "ಬಾಷ್ಪೀಕರಣ"),
            correctAnswer = "ಉಷ್ಣವಹನ / ಉಷ್ಣಪರಸರಣ (Conduction)",
            explanation = "ಘನವಸ್ತುಗಳಲ್ಲಿ ಕಣಗಳ ಚಲನೆಯಿಲ್ಲದೆ ಉಷ್ಣವು ಒಂದು ಕಣದಿಂದ ಇನ್ನೊಂದು ಕಣಕ್ಕೆ ವರ್ಗಾವಣೆಯಾಗುವುದು ಉಷ್ಣವಹನ."
        ),
        QuestionModel(
            id = "s_7_sci_u7_2",
            stdId = 7,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ದ್ರವ ಮತ್ತು ಅನಿಲಗಳಲ್ಲಿ ಉಷ್ಣ ವರ್ಗಾವಣೆಯಾಗುವ ಮುಖ್ಯ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಉಷ್ಣವಹನ", "ಉಷ್ಣಸಂವಹನ (Convection)", "ಉಷ್ಣವಿಕಿರಣ", "ಘನೀಕರಣ"),
            correctAnswer = "ಉಷ್ಣಸಂವಹನ (Convection)",
            explanation = "ದ್ರವ ಮತ್ತು ಅನಿಲಗಳ ಕಣಗಳ ನೈಜ ಚಲನೆಯಿಂದ ಉಷ್ಣ ವರ್ಗಾವಣೆಯಾಗುವುದೇ ಉಷ್ಣಸಂವಹನ."
        ),
        QuestionModel(
            id = "s_7_sci_u7_3",
            stdId = 7,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಯಾವುದೇ ಭೌತಿಕ ಮಾಧ್ಯಮದ ಅಗತ್ಯವಿಲ್ಲದೆ ಶೂನ್ಯದಲ್ಲೂ ನಡೆಯುವ ಉಷ್ಣ ವರ್ಗಾವಣೆಯ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಉಷ್ಣವಹನ", "ಉಷ್ಣಸಂವಹನ", "ಉಷ್ಣವಿಕಿರಣ (Radiation)", "ಬಾಷ್ಪೀಕರಣ"),
            correctAnswer = "ಉಷ್ಣವಿಕಿರಣ (Radiation)",
            explanation = "ವಿಕಿರಣಕ್ಕೆ ಯಾವುದೇ ಮಾಧ್ಯಮದ ಅವಶ್ಯಕತೆಯಿಲ್ಲ; ಸೂರ್ಯನ ಉಷ್ಣ ಭೂಮಿಯನ್ನು ತಲುಪುವುದು ಈ ಮೂಲಕವೇ."
        ),
        QuestionModel(
            id = "s_7_sci_u7_4",
            stdId = 7,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಹಗಲಿನಲ್ಲಿ ಸಮುದ್ರದಿಂದ ಭೂಮಿಯ ಕಡೆಗೆ ಬೀಸುವ ತಂಪಾದ ಗಾಳಿಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ನೆಲದ ಗಾಳಿ", "ಮರುಭೂಮಿ ಗಾಳಿ", "ಕಡಲ ಗಾಳಿ (Sea Breeze)", "ಪರ್ವತ ಗಾಳಿ"),
            correctAnswer = "ಕಡಲ ಗಾಳಿ (Sea Breeze)",
            explanation = "ಹಗಲಿನಲ್ಲಿ ಭೂಮಿ ಬೇಗ ಬಿಸಿಯಾಗಿ ಗಾಳಿ ಮೇಲೆ ಹೋದಾಗ ಸಮುದ್ರದಿಂದ ಬೀಸುವ ಗಾಳಿಯೇ ಕಡಲ ಗಾಳಿ."
        ),
        QuestionModel(
            id = "s_7_sci_u7_5",
            stdId = 7,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಾತ್ರಿಯಲ್ಲಿ ಭೂಮಿಯಿಂದ ಸಮುದ್ರದ ಕಡೆಗೆ ಬೀಸುವ ಗಾಳಿಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಕಡಲ ಗಾಳಿ", "ನೆಲದ ಗಾಳಿ (Land Breeze)", "ಚಂಡಮಾರುತ", "ಪರ್ವತ ಗಾಳಿ"),
            correctAnswer = "ನೆಲದ ಗಾಳಿ (Land Breeze)",
            explanation = "ರಾತ್ರಿಯಲ್ಲಿ ಭೂಮಿ ಸಮುದ್ರಕ್ಕಿಂತ ಬೇಗ ತಣ್ಣಗಾಗುವುದರಿಂದ ಭೂಮಿಯಿಂದ ಸಮುದ್ರಕ್ಕೆ ಬೀಸುವ ಗಾಳಿ."
        ),
        QuestionModel(
            id = "s_7_sci_u7_6",
            stdId = 7,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಬೆವರು ಚರ್ಮದ ಮೇಲೆ ಆವಿಯಾಗುವಾಗ (ಬಾಷ್ಪೀಕರಣ) ನಮಗೆ ಉಂಟಾಗುವ ಪರಿಣಾಮವೇನು?",
            options = listOf("ದೇಹ ಬಿಸಿಯಾಗುತ್ತದೆ", "ತಂಪಿನ ಅನುಭವವಾಗುತ್ತದೆ", "ತೂಕ ಹೆಚ್ಚಾಗುತ್ತದೆ", "ಜ್ವರ ಬರುತ್ತದೆ"),
            correctAnswer = "ತಂಪಿನ ಅನುಭವವಾಗುತ್ತದೆ",
            explanation = "ಬಾಷ್ಪೀಕರಣವು ಸುಪ್ತೋಷ್ಣವನ್ನು ಹೀರಿಕೊಳ್ಳುವುದರಿಂದ ಸುತ್ತಲಿನ ಪರಿಸರ ಅಥವಾ ದೇಹ ತಂಪಾಗುತ್ತದೆ."
        ),

        // ==================== ಘಟಕ 8: ಕಾಲ ಮತ್ತು ಚಲನೆಯ ಅಳತೆ ====================
        QuestionModel(
            id = "s_7_sci_u8_1",
            stdId = 7,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಅಂತಾರಾಷ್ಟ್ರೀಯ ಪದ್ಧತಿಯಲ್ಲಿ (SI) ವೇಗದ ಮಾನ ಯಾವುದು?",
            options = listOf("km/h", "m/s (ಮೀಟರ್ ಪ್ರತಿ ಸೆಕೆಂಡ್)", "km/s", "m/h"),
            correctAnswer = "m/s (ಮೀಟರ್ ಪ್ರತಿ ಸೆಕೆಂಡ್)",
            explanation = "ವೇಗ = ದೂರ / ಕಾಲ = ಮೀಟರ್ / ಸೆಕೆಂಡ್ (m/s)."
        ),
        QuestionModel(
            id = "s_7_sci_u8_2",
            stdId = 7,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ವಾಹನವು ಕ್ರಮಿಸಿದ ಒಟ್ಟು ದೂರವನ್ನು ಅಳೆಯುವ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಸ್ಪೀಡೋಮೀಟರ್", "ಓಡೋಮೀಟರ್ (Odometer)", "ಸ್ಟಾಪ್ ವಾಚ್", "ತಾಪಮಾಪಕ"),
            correctAnswer = "ಓಡೋಮೀಟರ್ (Odometer)",
            explanation = "ಓಡೋಮೀಟರ್ ವಾಹನವು ಕ್ರಮಿಸಿದ ಒಟ್ಟು ದೂರವನ್ನು ಕಿಲೋಮೀಟರ್‌ಗಳಲ್ಲಿ ಅಳೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u8_3",
            stdId = 7,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ವಾಹನದ ತತ್‌ಕ್ಷಣದ ವೇಗವನ್ನು ನೇರವಾಗಿ km/h ನಲ್ಲಿ ಅಳೆಯುವ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಓಡೋಮೀಟರ್", "ಸ್ಟಾಪ್ ವಾಚ್", "ಸ್ಪೀಡೋಮೀಟರ್ (Speedometer)", "ಮೀಟರ್ ಸ್ಕೇಲ್"),
            correctAnswer = "ಸ್ಪೀಡೋಮೀಟರ್ (Speedometer)",
            explanation = "ಸ್ಪೀಡೋಮೀಟರ್ ವಾಹನದ ಚಲನೆಯ ವೇಗವನ್ನು ತೋರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u8_4",
            stdId = 7,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸರಳ ಲೋಲಕವು ಒಂದು ಆಂದೋಲನವನ್ನು ಪೂರ್ಣಗೊಳಿಸಲು ತೆಗೆದುಕೊಳ್ಳುವ ಸಮಯವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ವೇಗ", "ದೂರ", "ಆವರ್ತಾವಧಿ (Time Period)", "ಕಂಪನ"),
            correctAnswer = "ಆವರ್ತಾವಧಿ (Time Period)",
            explanation = "ಒಂದು ಪೂರ್ಣ ಆಂದೋಲನಕ್ಕೆ ತಗಲುವ ಕಾಲವೇ ಆವರ್ತಾವಧಿ."
        ),
        QuestionModel(
            id = "s_7_sci_u8_5",
            stdId = 7,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಒಂದು ವಾಹನವು 2 m/s ವೇಗದಲ್ಲಿ 15 ನಿಮಿಷ (900 ಸೆಕೆಂಡ್) ಚಲಿಸಿದರೆ ಕ್ರಮಿಸುವ ದೂರ ಎಷ್ಟು?",
            options = listOf("1.8 km (1800 m)", "1.5 km", "18 km", "300 m"),
            correctAnswer = "1.8 km (1800 m)",
            explanation = "ದೂರ = ವೇಗ × ಕಾಲ = 2 m/s × (15 × 60 s) = 2 × 900 = 1800 m = 1.8 km."
        ),
        QuestionModel(
            id = "s_7_sci_u8_6",
            stdId = 7,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ವಿಶ್ವದ ಅತಿ ದೊಡ್ಡ ಕಲ್ಲಿನ ಸೌರಗಡಿಯಾರವಾದ ಸಾಮ್ರಾಟ್ ಯಂತ್ರವು ಎಲ್ಲಿದೆ?",
            options = listOf("ಬೆಂಗಳೂರು", "ಜೈಪುರ (ರಾಜಸ್ಥಾನ, ಜಂತರ್ ಮಂತರ್)", "ದೆಹಲಿ", "ಮುಂಬೈ"),
            correctAnswer = "ಜೈಪುರ (ರಾಜಸ್ಥಾನ, ಜಂತರ್ ಮಂತರ್)",
            explanation = "ಜೈಪುರದ ಜಂತರ್ ಮಂತರ್‌ನಲ್ಲಿರುವ ಸಾಮ್ರಾಟ್ ಯಂತ್ರವು 27 ಮೀಟರ್ ಎತ್ತರದ ಬೃಹತ್ ಸೌರ ಗಡಿಯಾರವಾಗಿದೆ."
        ),

        // ==================== ಘಟಕ 9: ಪ್ರಾಣಿಗಳಲ್ಲಿ ಜೀವ ಕ್ರಿಯೆಗಳು ====================
        QuestionModel(
            id = "s_7_sci_u9_1",
            stdId = 7,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ರಕ್ತಕ್ಕೆ ಕೆಂಪು ಬಣ್ಣವನ್ನು ನೀಡುವ ಮತ್ತು ಆಮ್ಲಜನಕವನ್ನು ಸಾಗಿಸುವ ಪ್ರಮುಖ ವರ್ಣಕ ಯಾವುದು?",
            options = listOf("ಕ್ಲೋರೋಫಿಲ್", "ಮೆಲನಿನ್", "ಹಿಮೋಗ್ಲೋಬಿನ್ (Hemoglobin)", "ಪ್ಲಾಸ್ಮಾ"),
            correctAnswer = "ಹಿಮೋಗ್ಲೋಬಿನ್ (Hemoglobin)",
            explanation = "ಕೆಂಪು ರಕ್ತಕಣಗಳಲ್ಲಿರುವ ಕಬ್ಬಿಣಯುಕ್ತ ಪ್ರೋಟೀನ್ ಹಿಮೋಗ್ಲೋಬಿನ್ ಆಮ್ಲಜನಕವನ್ನು ಅಂಗಾಂಶಗಳಿಗೆ ಕೊಂಡೊಯ್ಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u9_2",
            stdId = 7,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ದೇಹಕ್ಕೆ ಪ್ರವೇಶಿಸುವ ರೋಗಾಣುಗಳ ವಿರುದ್ಧ ಹೋರಾಡಿ ರೋಗನಿರೋಧಕತೆ ನೀಡುವ ರಕ್ತಕಣಗಳು ಯಾವುವು?",
            options = listOf("ಕೆಂಪು ರಕ್ತಕಣಗಳು (RBC)", "ಬಿಳಿ ರಕ್ತಕಣಗಳು (WBC)", "ಪ್ಲೇಟ್‌ಲೆಟ್‌ಗಳು", "ಪ್ಲಾಸ್ಮಾ"),
            correctAnswer = "ಬಿಳಿ ರಕ್ತಕಣಗಳು (WBC)",
            explanation = "ಬಿಳಿ ರಕ್ತಕಣಗಳು ದೇಹದ ಸೈನಿಕರಂತೆ ರೋಗಾಣುಗಳನ್ನು ನಾಶಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u9_3",
            stdId = 7,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಗಾಯವಾದಾಗ ರಕ್ತ ಹೆಪ್ಪುಗಟ್ಟುವಿಕೆಯಲ್ಲಿ (Clotting) ಪ್ರಮುಖ ಪಾತ್ರ ವಹಿಸುವ ರಕ್ತದ ಕಣಗಳು ಯಾವುವು?",
            options = listOf("RBC", "WBC", "ಪ್ಲೇಟ್‌ಲೆಟ್‌ಗಳು (ಕಿರುಬಿಲ್ಲೆಗಳು)", "ಹಿಮೋಗ್ಲೋಬಿನ್"),
            correctAnswer = "ಪ್ಲೇಟ್‌ಲೆಟ್‌ಗಳು (ಕಿರುಬಿಲ್ಲೆಗಳು)",
            explanation = "ಪ್ಲೇಟ್‌ಲೆಟ್‌ಗಳು ರಕ್ತಸ್ರಾವವನ್ನು ತಡೆಗಟ್ಟಲು ಹೆಪ್ಪುಗಟ್ಟುವ ಜಾಲವನ್ನು ರೂಪಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u9_4",
            stdId = 7,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಹೃದಯದಿಂದ ದೇಹದ ವಿವಿಧ ಭಾಗಗಳಿಗೆ ಶುದ್ಧ (ಆಮ್ಲಜನಕಯುಕ್ತ) ರಕ್ತವನ್ನು ಒಯ್ಯುವ ರಕ್ತನಾಳಗಳು ಯಾವುವು?",
            options = listOf("ಸಿರೆಗಳು (Veins)", "ಅಪಧಮನಿಗಳು (Arteries)", "ಲೋಮನಾಳಗಳು", "ಮೂತ್ರನಾಳಗಳು"),
            correctAnswer = "ಅಪಧಮನಿಗಳು (Arteries)",
            explanation = "ಅಪಧಮನಿಗಳು ದಪ್ಪ ಭಿತ್ತಿ ಹೊಂದಿದ್ದು ಹೆಚ್ಚಿನ ಒತ್ತಡದಲ್ಲಿ ಹೃದಯದಿಂದ ರಕ್ತವನ್ನು ಅಂಗಗಳಿಗೆ ಒಯ್ಯುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u9_5",
            stdId = 7,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮಾನವನ ವಿಸರ್ಜನಾ ವ್ಯವಸ್ಥೆಯ ಪ್ರಮುಖ ಶೋಧನಾ ಅಂಗಗಳು ಯಾವುವು?",
            options = listOf("ಶ್ವಾಸಕೋಶಗಳು", "ಯಕೃತ್ತು", "ಮೂತ್ರಪಿಂಡಗಳು (Kidneys)", "ಜಠರ"),
            correctAnswer = "ಮೂತ್ರಪಿಂಡಗಳು (Kidneys)",
            explanation = "ಮೂತ್ರಪಿಂಡಗಳು ರಕ್ತದಲ್ಲಿನ ಯೂರಿಯಾ ಮುಂತಾದ ಸಾರಜನಕ ತ್ಯಾಜ್ಯಗಳನ್ನು ಶೋಧಿಸಿ ಮೂತ್ರವನ್ನು ಬೇರ್ಪಡಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u9_6",
            stdId = 7,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮೂತ್ರಪಿಂಡ ವೈಫಲ್ಯಕ್ಕೊಳಗಾದ ವ್ಯಕ್ತಿಯ ರಕ್ತವನ್ನು ಕೃತಕ ಯಂತ್ರದ ಮೂಲಕ ಶೋಧಿಸುವ ಪ್ರಕ್ರಿಯೆ ಯಾವುದು?",
            options = listOf("ಟ್ರಾನ್ಸ್‌ಪ್ಲಾಂಟೇಶನ್", "ಡಯಾಲಿಸಿಸ್ (Dialysis)", "ವಿಸರ್ಜನೆ", "ರಕ್ತಪರಿಚಲನೆ"),
            correctAnswer = "ಡಯಾಲಿಸಿಸ್ (Dialysis)",
            explanation = "ಡಯಾಲಿಸಿಸ್ ಕೃತಕ ಮೂತ್ರಪಿಂಡ ಯಂತ್ರದ ಮೂಲಕ ರಕ್ತ ಶುದ್ಧೀಕರಿಸುವ ವೈದ್ಯಕೀಯ ವಿಧಾನ."
        ),

        // ==================== ಘಟಕ 10: ಸಸ್ಯಗಳಲ್ಲಿ ಜೀವ ಕ್ರಿಯೆಗಳು ====================
        QuestionModel(
            id = "s_7_sci_u10_1",
            stdId = 7,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳಲ್ಲಿ ಬೇರುಗಳಿಂದ ನೀರು ಮತ್ತು ಖನಿಜ ಲವಣಗಳನ್ನು ಎಲೆಗಳಿಗೆ ಸಾಗಿಸುವ ನಾಳೀಯ ಅಂಗಾಂಶ ಯಾವುದು?",
            options = listOf("ಫ್ಲೋಯಮ್", "ಝೈಲಮ್ (Xylem)", "ಪ್ಯಾರೆಂಕೈಮಾ", "ಕ್ಯಾಂಬಿಯಂ"),
            correctAnswer = "ಝೈಲಮ್ (Xylem)",
            explanation = "ಝೈಲಮ್ ಅಂಗಾಂಶವು ಕೆಳಗಿನಿಂದ ಮೇಲಕ್ಕೆ ನೀರು ಮತ್ತು ಲವಣಗಳ ಏಕಮುಖ ಸಾಗಾಣಿಕೆ ನಡೆಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u10_2",
            stdId = 7,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಎಲೆಗಳಲ್ಲಿ ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಯಿಂದ ತಯಾರಾದ ಆಹಾರವನ್ನು ಸಸ್ಯದ ಎಲ್ಲಾ ಭಾಗಗಳಿಗೆ ಸಾಗಿಸುವ ಅಂಗಾಂಶ ಯಾವುದು?",
            options = listOf("ಝೈಲಮ್", "ಫ್ಲೋಯಮ್ (Phloem)", "ಸ್ಟೋಮಾಟಾ", "ರೋಮಬೇರು"),
            correctAnswer = "ಫ್ಲೋಯಮ್ (Phloem)",
            explanation = "ಫ್ಲೋಯಮ್ ಅಂಗಾಂಶವು ಆಹಾರವನ್ನು (ಸಕ್ಕರೆ) ಸಸ್ಯದ ಬೆಳೆಯುವ ಮತ್ತು ಸಂಗ್ರಹಿಸುವ ಭಾಗಗಳಿಗೆ ಸಾಗಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u10_3",
            stdId = 7,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಎಲೆಗಳ ಮೇಲ್ಮೈಯಲ್ಲಿರುವ ಪತ್ರರಂಧ್ರಗಳ (Stomata) ತೆರೆಯುವಿಕೆ ಮತ್ತು ಮುಚ್ಚುವಿಕೆಯನ್ನು ನಿಯಂತ್ರಿಸುವ ಜೀವಕೋಶಗಳು ಯಾವುವು?",
            options = listOf("ಕಾವಲು ಜೀವಕೋಶಗಳು (Guard cells)", "ಅಪಿತಚರ್ಮ ಕೋಶಗಳು", "ಫ್ಲೋಯಮ್ ಕೋಶಗಳು", "ರೋಮಬೇರುಗಳು"),
            correctAnswer = "ಕಾವಲು ಜೀವಕೋಶಗಳು (Guard cells)",
            explanation = "ಕಿಡ್ನಿ ಆಕಾರದ ಕಾವಲು ಕೋಶಗಳು ನೀರಿನ ಒತ್ತಡದ ಆಧಾರದಲ್ಲಿ ಪತ್ರರಂಧ್ರಗಳನ್ನು ತೆರೆಯುತ್ತವೆ ಮತ್ತು ಮುಚ್ಚುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u10_4",
            stdId = 7,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳು ಪತ್ರರಂಧ್ರಗಳ ಮೂಲಕ ನೀರನ್ನು ಆವಿಯ ರೂಪದಲ್ಲಿ ಹೊರಹಾಕುವ ಪ್ರಕ್ರಿಯೆಗೆ ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆ", "ಉಸಿರಾಟ", "ಬಾಷ್ಪ ವಿಸರ್ಜನೆ (Transpiration)", "ವಿಸರ್ಜನೆ"),
            correctAnswer = "ಬಾಷ್ಪ ವಿಸರ್ಜನೆ (Transpiration)",
            explanation = "ಬಾಷ್ಪ ವಿಸರ್ಜನೆಯು ಸಸ್ಯವನ್ನು ತಂಪಾಗಿರಿಸುತ್ತದೆ ಮತ್ತು ಎತ್ತರದ ಮರಗಳಲ್ಲಿ ನೀರನ್ನು ಮೇಲಕ್ಕೆ ಎಳೆಯುವ ಹೀರುಬಲ ಉಂಟುಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u10_5",
            stdId = 7,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬೇರುಗಳು ಮಣ್ಣಿನಿಂದ ನೀರು ಮತ್ತು ಖನಿಜಗಳನ್ನು ಹೀರಿಕೊಳ್ಳಲು ಮೇಲ್ಮೈ ವಿಸ್ತೀರ್ಣವನ್ನು ಹೆಚ್ಚಿಸುವ ಸೂಕ್ಷ್ಮ ರಚನೆಗಳು ಯಾವುವು?",
            options = listOf("ಪತ್ರರಂಧ್ರಗಳು", "ರೋಮಬೇರುಗಳು (Root hairs)", "ಕಾವಲು ಕೋಶಗಳು", "ತೊಗಟೆ"),
            correctAnswer = "ರೋಮಬೇರುಗಳು (Root hairs)",
            explanation = "ರೋಮಬೇರುಗಳು ಅಪಾರ ಪ್ರಮಾಣದ ಮೇಲ್ಮೈ ವಿಸ್ತೀರ್ಣವನ್ನು ಒದಗಿಸಿ ನೀರಿನ ಹೀರಿಕೆಯನ್ನು ಸುಲಭಗೊಳಿಸುತ್ತವೆ."
        ),

        // ==================== ಘಟಕ 11: ಬೆಳಕು: ನೆರಳುಗಳು ಮತ್ತು ಪ್ರತಿಫಲನಗಳು ====================
        QuestionModel(
            id = "s_7_sci_u11_1",
            stdId = 7,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸಮರೂಪ ಮಾಧ್ಯಮದಲ್ಲಿ ಬೆಳಕು ಯಾವಾಗಲೂ ಯಾವ ರೀತಿಯಲ್ಲಿ ಚಲಿಸುತ್ತದೆ?",
            options = listOf("ಅಂಕುಡೊಂಕು ಹಾದಿಯಲ್ಲಿ", "ವಕ್ರರೇಖೆಯಲ್ಲಿ", "ಸರಳರೇಖೆಯ ಪಥದಲ್ಲಿ (Rectilinear propagation)", "ಯಾದೃಚ್ಛಿಕವಾಗಿ"),
            correctAnswer = "ಸರಳರೇಖೆಯ ಪಥದಲ್ಲಿ (Rectilinear propagation)",
            explanation = "ಬೆಳಕು ಯಾವಾಗಲೂ ಸರಳರೇಖೆಯಲ್ಲಿ ಚಲಿಸುತ್ತದೆ, ಆದ್ದರಿಂದಲೇ ಅಪಾರದರ್ಶಕ ವಸ್ತುಗಳು ಅಡ್ಡಬಂದಾಗ ನೆರಳು ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u11_2",
            stdId = 7,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸಮತಲ ದರ್ಪಣದಲ್ಲಿ ಬಿಂಬವು ಎಡ-ಬಲ ಅದಲು ಬದಲಾಗಿ ಕಾಣುವ ವಿದ್ಯಮಾನವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಪಾರ್ಶ್ವ ಪಲ್ಲಟ (Lateral inversion)", "ವಕ್ರೀಭವನ", "ಪ್ರಸರಣ", "ಚದುರುವಿಕೆ"),
            correctAnswer = "ಪಾರ್ಶ್ವ ಪಲ್ಲಟ (Lateral inversion)",
            explanation = "ಕನ್ನಡಿಯ ಮುಂದೆ ನಿಂತಾಗ ನಮ್ಮ ಬಲಗೈ ಎಡಗೈಯಂತೆಯೂ, ಎಡಗೈ ಬಲಗೈಯಂತೆಯೂ ಕಾಣುವುದೇ ಪಾರ್ಶ್ವ ಪಲ್ಲಟ."
        ),
        QuestionModel(
            id = "s_7_sci_u11_3",
            stdId = 7,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸೂಜಿರಂಧ್ರ ಕ್ಯಾಮೆರಾದಲ್ಲಿ (Pinhole camera) ಪರದೆಯ ಮೇಲೆ ಉಂಟಾಗುವ ಬಿಂಬದ ಲಕ್ಷಣವೇನು?",
            options = listOf("ನೇರ ಮತ್ತು ಮಿಥ್ಯ", "ತಲೆಕೆಳಗಾದ ಮತ್ತು ನೈಜ (Inverted & Real)", "ದೊಡ್ಡದಾದ ನೇರ ಬಿಂಬ", "ಪಾರ್ಶ್ವ ಪಲ್ಲಟವಿಲ್ಲದ ಬಿಂಬ"),
            correctAnswer = "ತಲೆಕೆಳಗಾದ ಮತ್ತು ನೈಜ (Inverted & Real)",
            explanation = "ಬೆಳಕು ರಂಧ್ರದ ಮೂಲಕ ಸರಳರೇಖೆಯಲ್ಲಿ ಹಾದುಹೋಗುವುದರಿಂದ ಪರದೆಯ ಮೇಲೆ ತಲೆಕೆಳಗಾದ ನೈಜ ಬಿಂಬ ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u11_4",
            stdId = 7,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಜಲಾಂತರ್ಗಾಮಿ ನೌಕೆಗಳಲ್ಲಿ ನೀರಿನ ಮೇಲಿರುವ ಹಡಗುಗಳನ್ನು ನೋಡಲು ಬಳಸುವ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಸೂಕ್ಷ್ಮದರ್ಶಕ", "ದೂರದರ್ಶಕ", "ಪೆರಿಸ್ಕೋಪ್ (Periscope)", "ಕಾಲೈಡೋಸ್ಕೋಪ್"),
            correctAnswer = "ಪೆರಿಸ್ಕೋಪ್ (Periscope)",
            explanation = "ಪೆರಿಸ್ಕೋಪ್ 45° ಕೋನದಲ್ಲಿ ಇರಿಸಿದ ಎರಡು ಸಮತಲ ದರ್ಪಣಗಳ ಪ್ರತಿಫಲನ ತತ್ವದ ಮೇಲೆ ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u11_5",
            stdId = 7,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸುಂದರ ಬಹುಮುಖ ವಿನ್ಯಾಸಗಳನ್ನು ನೋಡಲು ಕಲಾವಿದರು ಬಳಸುವ, ಬಹು ಪ್ರತಿಫಲನದ ಆಧಾರದ ಮೇಲೆ ಕೆಲಸ ಮಾಡುವ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಕಾಲೈಡೋಸ್ಕೋಪ್ (Kaleidoscope)", "ಪಿನ್‌ಹೋಲ್ ಕ್ಯಾಮೆರಾ", "ಪೆರಿಸ್ಕೋಪ್", "ಸೂಕ್ಷ್ಮದರ್ಶಕ"),
            correctAnswer = "ಕಾಲೈಡೋಸ್ಕೋಪ್ (Kaleidoscope)",
            explanation = "ಕಾಲೈಡೋಸ್ಕೋಪ್‌ನಲ್ಲಿ ಮೂರು ಕನ್ನಡಿಗಳು 60° ಕೋನದಲ್ಲಿದ್ದು ಬಹು ಪ್ರತಿಫಲನದಿಂದ ಆಕರ್ಷಕ ವಿನ್ಯಾಸಗಳನ್ನು ಸೃಷ್ಟಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u11_6",
            stdId = 7,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸೂರ್ಯನ ಬೆಳಕು ಭೂಮಿಯನ್ನು ತಲುಪಲು ತೆಗೆದುಕೊಳ್ಳುವ ಸರಾಸರಿ ಸಮಯ ಎಷ್ಟು?",
            options = listOf("8 ಗಂಟೆ", "8 ನಿಮಿಷ 20 ಸೆಕೆಂಡುಗಳು (ಸುಮಾರು 500 ಸೆಕೆಂಡು)", "2 ಸೆಕೆಂಡು", "1 ಗಂಟೆ"),
            correctAnswer = "8 ನಿಮಿಷ 20 ಸೆಕೆಂಡುಗಳು (ಸುಮಾರು 500 ಸೆಕೆಂಡು)",
            explanation = "ಬೆಳಕಿನ ವೇಗ 3 ಲಕ್ಷ ಕಿಮೀ/ಸೆ ಆಗಿದ್ದು, 15 ಕೋಟಿ ಕಿಮೀ ದೂರವನ್ನು ಕ್ರಮಿಸಲು 8 ನಿಮಿಷ 20 ಸೆಕೆಂಡ್ ತೆಗೆದುಕೊಳ್ಳುತ್ತದೆ."
        ),

        // ==================== ಘಟಕ 12: ಭೂಮಿ, ಚಂದ್ರ ಮತ್ತು ಸೂರ್ಯ ====================
        QuestionModel(
            id = "s_7_sci_u12_1",
            stdId = 7,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಭೂಮಿಯು ತನ್ನ ಅಕ್ಷದ ಸುತ್ತ ಯಾವ ದಿಕ್ಕಿನಿಂದ ಯಾವ ದಿಕ್ಕಿಗೆ ತಿರುಗುತ್ತದೆ (ಅಕ್ಷಭ್ರಮಣ)?",
            options = listOf("ಪೂರ್ವದಿಂದ ಪಶ್ಚಿಮಕ್ಕೆ", "ಪಶ್ಚಿಮದಿಂದ ಪೂರ್ವಕ್ಕೆ (West to East)", "ಉತ್ತರದಿಂದ ದಕ್ಷಿಣಕ್ಕೆ", "ದಕ್ಷಿಣದಿಂದ ಉತ್ತರಕ್ಕೆ"),
            correctAnswer = "ಪಶ್ಚಿಮದಿಂದ ಪೂರ್ವಕ್ಕೆ (West to East)",
            explanation = "ಭೂಮಿ ಪಶ್ಚಿಮದಿಂದ ಪೂರ್ವಕ್ಕೆ ತಿರುಗುವುದರಿಂದ ಸೂರ್ಯ ಮತ್ತು ನಕ್ಷತ್ರಗಳು ಪೂರ್ವದಿಂದ ಪಶ್ಚಿಮಕ್ಕೆ ಚಲಿಸುವಂತೆ ಭಾಸವಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u12_2",
            stdId = 7,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಮೇಲಿನ ಹಗಲು ಮತ್ತು ರಾತ್ರಿಗಳು ಉಂಟಾಗಲು ಮುಖ್ಯ ಕಾರಣವೇನು?",
            options = listOf("ಸೂರ್ಯನ ಪರಿಭ್ರಮಣ", "ಭೂಮಿಯ ಅಕ್ಷಭ್ರಮಣ (Rotation)", "ಭೂಮಿಯ ಪರಿಭ್ರಮಣ", "ಚಂದ್ರನ ಕಕ್ಷೆ"),
            correctAnswer = "ಭೂಮಿಯ ಅಕ್ಷಭ್ರಮಣ (Rotation)",
            explanation = "ಭೂಮಿ ತನ್ನ ಅಕ್ಷದ ಮೇಲೆ 24 ಗಂಟೆಗಳಲ್ಲಿ ಒಂದು ಸುತ್ತು ತಿರುಗುವುದರಿಂದ ಹಗಲು ಮತ್ತು ರಾತ್ರಿ ಉಂಟಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u12_3",
            stdId = 7,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಮೇಲಿನ ಋತುಮಾನಗಳ (Seasons) ಬದಲಾವಣೆಗೆ ಮುಖ್ಯ ಕಾರಣವೇನು?",
            options = listOf(
                "ಕೇವಲ ಭೂಮಿಯ ಅಕ್ಷಭ್ರಮಣ",
                "ಸೂರ್ಯನ ಸುತ್ತ ಭೂಮಿಯ ಪರಿಭ್ರಮಣ ಮತ್ತು ಅದರ ಅಕ್ಷದ ಓರೆ (23.5°)",
                "ಚಂದ್ರನ ಗುರುತ್ವಾಕರ್ಷಣೆ",
                "ಸಮುದ್ರದ ಅಲೆಗಳು"
            ),
            correctAnswer = "ಸೂರ್ಯನ ಸುತ್ತ ಭೂಮಿಯ ಪರಿಭ್ರಮಣ ಮತ್ತು ಅದರ ಅಕ್ಷದ ಓರೆ (23.5°)",
            explanation = "ಭೂಮಿಯ ಅಕ್ಷದ ಓರೆ ಮತ್ತು ಸೂರ್ಯನ ಸುತ್ತಲಿನ ಕಕ್ಷಾ ಪರಿಭ್ರಮಣದಿಂದಾಗಿ ಸೂರ್ಯನ ಕಿರಣಗಳ ಕೋನ ಬದಲಾಗಿ ಋತುಗಳು ಉಂಟಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u12_4",
            stdId = 7,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಚಂದ್ರಗ್ರಹಣವು (Lunar Eclipse) ಯಾವಾಗ ಸಂಭವಿಸುತ್ತದೆ?",
            options = listOf(
                "ಚಂದ್ರನು ಸೂರ್ಯ ಮತ್ತು ಭೂಮಿಯ ನಡುವೆ ಬಂದಾಗ",
                "ಭೂಮಿಯು ಸೂರ್ಯ ಮತ್ತು ಚಂದ್ರನ ನಡುವೆ ಬಂದಾಗ (ಹುಣ್ಣಿಮೆಯಂದು)",
                "ಸೂರ್ಯನು ಭೂಮಿ ಮತ್ತು ಚಂದ್ರನ ನಡುವೆ ಬಂದಾಗ",
                "ಅಮಾವಾಸ್ಯೆಯಂದು ಮಾತ್ರ"
            ),
            correctAnswer = "ಭೂಮಿಯು ಸೂರ್ಯ ಮತ್ತು ಚಂದ್ರನ ನಡುವೆ ಬಂದಾಗ (ಹುಣ್ಣಿಮೆಯಂದು)",
            explanation = "ಭೂಮಿಯ ನೆರಳು ಚಂದ್ರನ ಮೇಲೆ ಬಿದ್ದಾಗ ಚಂದ್ರಗ್ರಹಣ ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u12_5",
            stdId = 7,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಸೂರ್ಯಗ್ರಹಣವು (Solar Eclipse) ಯಾವಾಗ ಸಂಭವಿಸುತ್ತದೆ?",
            options = listOf(
                "ಭೂಮಿಯು ಸೂರ್ಯ ಮತ್ತು ಚಂದ್ರನ ನಡುವೆ ಬಂದಾಗ",
                "ಚಂದ್ರನು ಸೂರ್ಯ ಮತ್ತು ಭೂಮಿಯ ನಡುವೆ ಬಂದಾಗ (ಅಮಾವಾಸ್ಯೆಯಂದು)",
                "ಹುಣ್ಣಿಮೆಯ ದಿನದಂದು",
                "ಚಂದ್ರನು ಸೂರ್ಯನಿಂದ ದೂರ ಸರಿದಾಗ"
            ),
            correctAnswer = "ಚಂದ್ರನು ಸೂರ್ಯ ಮತ್ತು ಭೂಮಿಯ ನಡುವೆ ಬಂದಾಗ (ಅಮಾವಾಸ್ಯೆಯಂದು)",
            explanation = "ಚಂದ್ರನ ನೆರಳು ಭೂಮಿಯ ಮೇಲೆ ಬಿದ್ದಾಗ ಸೂರ್ಯನ ಬೆಳಕು ಮರೆಯಾಗಿ ಸೂರ್ಯಗ್ರಹಣ ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_sci_u12_6",
            stdId = 7,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಭೂಮಿಯಿಂದ ನಾವು ಯಾವಾಗಲೂ ಚಂದ್ರನ ಒಂದೇ ಮುಖವನ್ನು ನೋಡಲು ಕಾರಣವೇನು?",
            options = listOf(
                "ಚಂದ್ರನಿಗೆ ಭ್ರಮಣವಿಲ್ಲ",
                "ಚಂದ್ರನ ಅಕ್ಷಭ್ರಮಣ ಮತ್ತು ಪರಿಭ್ರಮಣ ಅವಧಿಗಳು ಸಮನಾಗಿವೆ (27.3 ದಿನಗಳು)",
                "ಭೂಮಿ ಚಂದ್ರನ ಜೊತೆ ತಿರುಗುವುದಿಲ್ಲ",
                "ಚಂದ್ರನ ಇನ್ನೊಂದು ಬದಿಗೆ ಬೆಳಕಿಲ್ಲ"
            ),
            correctAnswer = "ಚಂದ್ರನ ಅಕ್ಷಭ್ರಮಣ ಮತ್ತು ಪರಿಭ್ರಮಣ ಅವಧಿಗಳು ಸಮನಾಗಿವೆ (27.3 ದಿನಗಳು)",
            explanation = "Synchronous rotation ಕಾರಣದಿಂದ ಚಂದ್ರನ ಅದೇ ಮುಖ ಸದಾ ಭೂಮಿಯ ಕಡೆಗೆ ಮುಖ ಮಾಡಿರುತ್ತದೆ."
        )
    )
}
