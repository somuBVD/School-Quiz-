package com.example.data

/**
 * Standard 10 - Science (ವಿಜ್ಞಾನ - Kannada Medium)
 * Sourced and constructed from Karnataka DSERT / KSEAB LBA Revised Textbook & Question Bank:
 *  - ಅಧ್ಯಾಯ 1: ರಾಸಾಯನಿಕ ಕ್ರಿಯೆಗಳು ಮತ್ತು ಸಮೀಕರಣಗಳು (Chemical Reactions and Equations)
 *  - ಅಧ್ಯಾಯ 2: ಆಮ್ಲಗಳು, ಪ್ರತ್ಯಾಮ್ಲಗಳು ಮತ್ತು ಲವಣಗಳು (Acids, Bases and Salts)
 *  - ಅಧ್ಯಾಯ 3: ಲೋಹಗಳು ಮತ್ತು ಅಲೋಹಗಳು (Metals and Non-metals)
 *  - ಅಧ್ಯಾಯ 4: ಕಾರ್ಬನ್ ಮತ್ತು ಅದರ ಸಂಯುಕ್ತಗಳು (Carbon and its Compounds)
 *  - ಅಧ್ಯಾಯ 5: ಧಾತುಗಳ ಆವರ್ತನೀಯ ವರ್ಗೀಕರಣ (Periodic Classification of Elements)
 *  - ಅಧ್ಯಾಯ 6: ಜೀವಕ್ರಿಯೆಗಳು (Life Processes)
 *  - ಅಧ್ಯಾಯ 7: ನಿಯಂತ್ರಣ ಮತ್ತು ಸಹಭಾಗಿತ್ವ (Control and Coordination)
 *  - ಅಧ್ಯಾಯ 8: ಜೀವಿಗಳು ಹೇಗೆ ಸಂತಾನೋತ್ಪತ್ತಿ ನಡೆಸುತ್ತವೆ? (How do Organisms Reproduce?)
 *  - ಅಧ್ಯಾಯ 9: ಅನುವಂಶೀಯತೆ ಮತ್ತು ಜೀವ ವಿಕಾಸ (Heredity and Evolution)
 *  - ಅಧ್ಯಾಯ 10: ಬೆಳಕು - ಪ್ರತಿಫಲನ ಮತ್ತು ವಕ್ರೀಭವನ (Light - Reflection and Refraction)
 *  - ಅಧ್ಯಾಯ 11: ಮಾನವನ ಕಣ್ಣು ಮತ್ತು ವರ್ಣಮಯ ಜಗತ್ತು (Human Eye and Colourful World)
 *  - ಅಧ್ಯಾಯ 12: ವಿದ್ಯುಚ್ಛಕ್ತಿ (Electricity)
 *  - ಅಧ್ಯಾಯ 13: ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ಕಾಂತೀಯ ಪರಿಣಾಮಗಳು (Magnetic Effects of Electric Current)
 *  - ಅಧ್ಯಾಯ 14: ಶಕ್ತಿಯ ಆಕರಗಳು (Sources of Energy)
 *  - ಅಧ್ಯಾಯ 15: ನಮ್ಮ ಪರಿಸರ (Our Environment)
 *  - ಅಧ್ಯಾಯ 16: ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲಗಳ ಸುಸ್ಥಿರ ನಿರ್ವಹಣೆ (Sustainable Management of Natural Resources)
 *
 * Includes direct textbook MCQs, fill-in-the-blanks converted into 4-option MCQs,
 * and 1-mark questions converted into 4-option MCQs with explanations.
 * All duplicates and picture/diagram-based questions have been omitted.
 */
object Std10ScienceQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಅಧ್ಯಾಯ 1: ರಾಸಾಯನಿಕ ಕ್ರಿಯೆಗಳು ಮತ್ತು ಸಮೀಕರಣಗಳು", 15, "Medium"),
        UnitTemplate(2, "ಅಧ್ಯಾಯ 2: ಆಮ್ಲಗಳು, ಪ್ರತ್ಯಾಮ್ಲಗಳು ಮತ್ತು ಲವಣಗಳು", 15, "Medium"),
        UnitTemplate(3, "ಅಧ್ಯಾಯ 3: ಲೋಹಗಳು ಮತ್ತು ಅಲೋಹಗಳು", 15, "Medium"),
        UnitTemplate(4, "ಅಧ್ಯಾಯ 4: ಕಾರ್ಬನ್ ಮತ್ತು ಅದರ ಸಂಯುಕ್ತಗಳು", 15, "Hard"),
        UnitTemplate(5, "ಅಧ್ಯಾಯ 5: ಧಾತುಗಳ ಆವರ್ತನೀಯ ವರ್ಗೀಕರಣ", 15, "Medium"),
        UnitTemplate(6, "ಅಧ್ಯಾಯ 6: ಜೀವಕ್ರಿಯೆಗಳು", 16, "Hard"),
        UnitTemplate(7, "ಅಧ್ಯಾಯ 7: ನಿಯಂತ್ರಣ ಮತ್ತು ಸಹಭಾಗಿತ್ವ", 15, "Medium"),
        UnitTemplate(8, "ಅಧ್ಯಾಯ 8: ಜೀವಿಗಳು ಹೇಗೆ ಸಂತಾನೋತ್ಪತ್ತಿ ನಡೆಸುತ್ತವೆ?", 15, "Medium"),
        UnitTemplate(9, "ಅಧ್ಯಾಯ 9: ಅನುವಂಶೀಯತೆ ಮತ್ತು ಜೀವ ವಿಕಾಸ", 15, "Hard"),
        UnitTemplate(10, "ಅಧ್ಯಾಯ 10: ಬೆಳಕು - ಪ್ರತಿಫಲನ ಮತ್ತು ವಕ್ರೀಭವನ", 16, "Hard"),
        UnitTemplate(11, "ಅಧ್ಯಾಯ 11: ಮಾನವನ ಕಣ್ಣು ಮತ್ತು ವರ್ಣಮಯ ಜಗತ್ತು", 15, "Medium"),
        UnitTemplate(12, "ಅಧ್ಯಾಯ 12: ವಿದ್ಯುಚ್ಛಕ್ತಿ", 16, "Hard"),
        UnitTemplate(13, "ಅಧ್ಯಾಯ 13: ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ಕಾಂತೀಯ ಪರಿಣಾಮಗಳು", 15, "Hard"),
        UnitTemplate(14, "ಅಧ್ಯಾಯ 14: ಶಕ್ತಿಯ ಆಕರಗಳು", 15, "Easy"),
        UnitTemplate(15, "ಅಧ್ಯಾಯ 15: ನಮ್ಮ ಪರಿಸರ", 15, "Easy"),
        UnitTemplate(16, "ಅಧ್ಯಾಯ 16: ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲಗಳ ಸುಸ್ಥಿರ ನಿರ್ವಹಣೆ", 15, "Easy")
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 1: ರಾಸಾಯನಿಕ ಕ್ರಿಯೆಗಳು ಮತ್ತು ಸಮೀಕರಣಗಳು
    // ========================================================
    private val u1Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u1_1",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "Fe2O3 + 2Al -> Al2O3 + 2Fe ಈ ಕ್ರಿಯೆಯು ಈ ಕೆಳಗಿನ ಯಾವುದಕ್ಕೆ ಉದಾಹರಣೆಯಾಗಿದೆ?",
            options = listOf("ಸಂಯೋಗ ಕ್ರಿಯೆ", "ದ್ವಿಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ", "ವಿಘಟನ ಕ್ರಿಯೆ", "ಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ"),
            correctAnswer = "ಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ",
            explanation = "ಹೆಚ್ಚು ಕ್ರಿಯಾಶೀಲವಾದ ಅಲ್ಯೂಮಿನಿಯಂ (Al) ಕಬ್ಬಿಣವನ್ನು (Fe) ಅದರ ಆಕ್ಸೈಡ್‌ನಿಂದ ಸ್ಥಾನಪಲ್ಲಟಗೊಳಿಸುತ್ತದೆ. ಆದ್ದರಿಂದ ಇದು ಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u1_2",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕಬ್ಬಿಣದ ಪುಡಿಗೆ ಸಾರಹೀನ ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲವನ್ನು ಸೇರಿಸಿದಾಗ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಹೈಡ್ರೋಜನ್ ಅನಿಲ ಮತ್ತು ಐರನ್ ಕ್ಲೋರೈಡ್ ಉಂಟಾಗುತ್ತದೆ", "ಕ್ಲೋರಿನ್ ಅನಿಲ ಮತ್ತು ಐರನ್ ಹೈಡ್ರಾಕ್ಸೈಡ್ ಉಂಟಾಗುತ್ತದೆ", "ಯಾವುದೇ ಕ್ರಿಯೆ ನಡೆಯುವುದಿಲ್ಲ", "ಕಬ್ಬಿಣದ ಲವಣ ಮತ್ತು ನೀರು ಉಂಟಾಗುತ್ತದೆ"),
            correctAnswer = "ಹೈಡ್ರೋಜನ್ ಅನಿಲ ಮತ್ತು ಐರನ್ ಕ್ಲೋರೈಡ್ ಉಂಟಾಗುತ್ತದೆ",
            explanation = "ಲೋಹಗಳು ಸಾರಹೀನ ಆಮ್ಲಗಳೊಂದಿಗೆ ವರ್ತಿಸಿದಾಗ ಲೋಹದ ಲವಣ ಮತ್ತು ಹೈಡ್ರೋಜನ್ ಅನಿಲವನ್ನು ಬಿಡುಗಡೆ ಮಾಡುತ್ತವೆ: Fe + 2HCl -> FeCl2 + H2."
        ),
        QuestionModel(
            id = "s_10_sci_u1_3",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕ್ಯಾಲ್ಸಿಯಂ ಆಕ್ಸೈಡ್ (ಸುಟ್ಟ ಸುಣ್ಣ) ನೀರಿನೊಂದಿಗೆ ತೀವ್ರವಾಗಿ ವರ್ತಿಸಿ ಅರಳಿದ ಸುಣ್ಣವನ್ನು ಉಂಟುಮಾಡುವುದು ಯಾವ ವಿಧದ ಕ್ರಿಯೆ?",
            options = listOf("ಬಹಿರುಷ್ಣಕ ಸಂಯೋಗ ಕ್ರಿಯೆ", "ಅಂತರುಷ್ಣಕ ವಿಘಟನ ಕ್ರಿಯೆ", "ದ್ವಿಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ", "ಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ"),
            correctAnswer = "ಬಹಿರುಷ್ಣಕ ಸಂಯೋಗ ಕ್ರಿಯೆ",
            explanation = "CaO + H2O -> Ca(OH)2 + ತಾಪ. ಎರಡು ಪ್ರತಿವರ್ತಕಗಳು ಸೇರಿ ಒಂದೇ ಉತ್ಪನ್ನವಾಗುವುದರಿಂದ ಸಂಯೋಗ ಕ್ರಿಯೆ, ಹಾಗೂ ತಾಪ ಬಿಡುಗಡೆಯಾಗುವುದರಿಂದ ಬಹಿರುಷ್ಣಕ ಕ್ರಿಯೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u1_4",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ರಾಸಾಯನಿಕ ಸಮೀಕರಣಗಳನ್ನು ಸರಿದೂಗಿಸಲು ಕಾರಣವಾಗಿರುವ ಪ್ರಮುಖ ನಿಯಮ ಯಾವುದು?",
            options = listOf("ರಾಶಿ ಸಂರಕ್ಷಣಾ ನಿಯಮ", "ಸ್ಥಿರ ಪ್ರಮಾಣದ ನಿಯಮ", "ನ್ಯೂಟನ್‌ನ ನಿಯಮ", "ಶಕ್ತಿ ಸಂರಕ್ಷಣಾ ನಿಯಮ"),
            correctAnswer = "ರಾಶಿ ಸಂರಕ್ಷಣಾ ನಿಯಮ",
            explanation = "ರಾಸಾಯನಿಕ ಕ್ರಿಯೆಯಲ್ಲಿ ರಾಶಿಯನ್ನು ಸೃಷ್ಟಿಸಲು ಅಥವಾ ಲಯಗೊಳಿಸಲು ಸಾಧ್ಯವಿಲ್ಲ. ಪ್ರತಿವರ್ತಕಗಳ ಒಟ್ಟು ರಾಶಿಯು ಉತ್ಪನ್ನಗಳ ಒಟ್ಟು ರಾಶಿಗೆ ಸಮನಾಗಿರಬೇಕು."
        ),
        QuestionModel(
            id = "s_10_sci_u1_5",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬಿಟ್ಟ ಸ್ಥಳ ತುಂಬಿರಿ: ಜಲಜನಕವನ್ನು ಪಡೆದುಕೊಳ್ಳುವ ಅಥವಾ ಆಕ್ಸಿಜನ್ ಅನ್ನು ಕಳೆದುಕೊಳ್ಳುವ ಕ್ರಿಯೆಯನ್ನು ________ ಎನ್ನುವರು.",
            options = listOf("ಅಪಕರ್ಷಣ", "ಆಕ್ಸಿಡೀಕರಣ", "ವಿಘಟನೆ", "ಸಂಯೋಗ"),
            correctAnswer = "ಅಪಕರ್ಷಣ",
            explanation = "ಆಕ್ಸಿಜನ್ ಕಳೆದುಕೊಳ್ಳುವ ಅಥವಾ ಹೈಡ್ರೋಜನ್ ಪಡೆದುಕೊಳ್ಳುವ ಪ್ರಕ್ರಿಯೆಗೆ ಅಪಕರ್ಷಣ (Reduction) ಎನ್ನುವರು."
        ),
        QuestionModel(
            id = "s_10_sci_u1_6",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬಿಟ್ಟ ಸ್ಥಳ ತುಂಬಿರಿ: ಜೀರ್ಣಕ್ರಿಯೆಯಲ್ಲಿ ಆಹಾರ ವಿಭಜನೆಯಾಗಿ ಗ್ಲೂಕೋಸ್ ಉಂಟಾಗಿ ಶಕ್ತಿ ಬಿಡುಗಡೆಯಾಗುವ ಉಸಿರಾಟ ಕ್ರಿಯೆಯು ಒಂದು ________ ಕ್ರಿಯೆಯಾಗಿದೆ.",
            options = listOf("ಬಹಿರುಷ್ಣಕ", "ಅಂತರುಷ್ಣಕ", "ದಹನವಿಲ್ಲದ", "ಭೌತಿಕ"),
            correctAnswer = "ಬಹಿರುಷ್ಣಕ",
            explanation = "ಉಸಿರಾಟದಲ್ಲಿ ಗ್ಲೂಕೋಸ್ ಆಕ್ಸಿಜನ್‌ನೊಂದಿಗೆ ವರ್ತಿಸಿ ಶಕ್ತಿಯನ್ನು ಬಿಡುಗಡೆ ಮಾಡುವುದರಿಂದ ಇದು ಬಹಿರುಷ್ಣಕ ಕ್ರಿಯೆಯಾಗಿದೆ (Exothermic reaction)."
        ),
        QuestionModel(
            id = "s_10_sci_u1_7",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸೀಸದ ನೈಟ್ರೇಟ್ (ಲೆಡ್ ನೈಟ್ರೇಟ್) ಪುಡಿಯನ್ನು ಕಾಯಿಸಿದಾಗ ಹೊರಬರುವ ಕಂದು ಬಣ್ಣದ ಹೊಗೆ ಯಾವುದು?",
            options = listOf("ನೈಟ್ರೋಜನ್ ಡೈಆಕ್ಸೈಡ್ (NO2)", "ಆಕ್ಸಿಜನ್ (O2)", "ನೈಟ್ರೋಜನ್ (N2)", "ಲೆಡ್ ಆಕ್ಸೈಡ್ (PbO)"),
            correctAnswer = "ನೈಟ್ರೋಜನ್ ಡೈಆಕ್ಸೈಡ್ (NO2)",
            explanation = "2Pb(NO3)2 ಕಾಯಿಸಿದಾಗ 2PbO + 4NO2 + O2 ಉಂಟಾಗುತ್ತದೆ. ಹೊರಬರುವ ಕಂದು ಬಣ್ಣದ ಅನಿಲವೇ ನೈಟ್ರೋಜನ್ ಡೈಆಕ್ಸೈಡ್."
        ),
        QuestionModel(
            id = "s_10_sci_u1_8",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬೆಳ್ಳಿಯ ಕ್ಲೋರೈಡ್ (AgCl) ಅನ್ನು ಸೂರ್ಯನ ಬೆಳಕಿನಲ್ಲಿ ಇಟ್ಟಾಗ ಬೂದು ಬಣ್ಣಕ್ಕೆ ತಿರುಗಲು ಕಾರಣವೇನು?",
            options = listOf("ಸೂರ್ಯನ ಬೆಳಕಿನಿಂದ ದ್ಯುತಿ ವಿಘಟನೆ ಹೊಂದಿ ಬೆಳ್ಳಿ ಉಂಟಾಗುವುದು", "ಆಕ್ಸಿಡೀಕರಣಗೊಳ್ಳುವುದು", "ಸ್ಥಾನಪಲ್ಲಟಗೊಳ್ಳುವುದು", "ನೀರಿನೊಂದಿಗೆ ಸಂಯೋಗಗೊಳ್ಳುವುದು"),
            correctAnswer = "ಸೂರ್ಯನ ಬೆಳಕಿನಿಂದ ದ್ಯುತಿ ವಿಘಟನೆ ಹೊಂದಿ ಬೆಳ್ಳಿ ಉಂಟಾಗುವುದು",
            explanation = "2AgCl ಸೂರ್ಯನ ಬೆಳಕಿನಲ್ಲಿ 2Ag + Cl2 ಆಗಿ ವಿಘಟನೆ ಹೊಂದುತ್ತದೆ. ಉಂಟಾದ ಬೆಳ್ಳಿಯು ಬೂದು ಬಣ್ಣದ್ದಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u1_9",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಕಪ್ಪು-ಬಿಳುಪು ಛಾಯಾಗ್ರಹಣದಲ್ಲಿ (Black & White Photography) ಬಳಸುವ ರಾಸಾಯನಿಕ ಯಾವುದು?",
            options = listOf("ಸಿಲ್ವರ್ ಬ್ರೋಮೈಡ್ (AgBr)", "ಕ್ಯಾಲ್ಸಿಯಂ ಕ್ಲೋರೈಡ್", "ಸೋಡಿಯಂ ಕ್ಲೋರೈಡ್", "ಜಿಂಕ್ ಸಲ್ಫೇಟ್"),
            correctAnswer = "ಸಿಲ್ವರ್ ಬ್ರೋಮೈಡ್ (AgBr)",
            explanation = "ಸಿಲ್ವರ್ ಬ್ರೋಮೈಡ್ ಅಥವಾ ಸಿಲ್ವರ್ ಕ್ಲೋರೈಡ್ ಅನ್ನು ಕಪ್ಪು-ಬಿಳುಪು ಛಾಯಾಗ್ರಹಣದಲ್ಲಿ ದ್ಯುತಿ ವಿಘಟನ ಕ್ರಿಯೆಗಾಗಿ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u1_10",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬಿಟ್ಟ ಸ್ಥಳ ತುಂಬಿರಿ: ಎಣ್ಣೆ ಮತ್ತು ಕೊಬ್ಬುಯುಕ್ತ ಆಹಾರ ಪದಾರ್ಥಗಳು ಗಾಳಿಗೆ ತೆರೆದಿಟ್ಟಾಗ ಆಕ್ಸಿಡೀಕರಣಗೊಂಡು ವಾಸನೆ ಮತ್ತು ರುಚಿ ಬದಲಾಗುವುದನ್ನು ________ ಎನ್ನುವರು.",
            options = listOf("ಕಮಟುವಿಕೆ (Rancidity)", "ಸವೆತ (Corrosion)", "ಪ್ರಕ್ಷೇಪಣ", "ತಟಸ್ಥೀಕರಣ"),
            correctAnswer = "ಕಮಟುವಿಕೆ (Rancidity)",
            explanation = "ಕೊಬ್ಬು ಮತ್ತು ಎಣ್ಣೆ ಪದಾರ್ಥಗಳು ಆಕ್ಸಿಡೀಕರಣಗೊಂಡು ಕೆಟ್ಟ ವಾಸನೆ ಮತ್ತು ರುಚಿಯನ್ನು ಪಡೆಯುವುದೇ ಕಮಟುವಿಕೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u1_11",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಆಲೂಗಡ್ಡೆ ಚಿಪ್ಸ್ ಪ್ಯಾಕೆಟ್‌ಗಳು ಆಕ್ಸಿಡೀಕರಣಗೊಳ್ಳದಂತೆ ಪ್ಯಾಕ್ ಮಾಡುವಾಗ ಯಾವ ಅನಿಲವನ್ನು ತುಂಬುತ್ತಾರೆ?",
            options = listOf("ಸಾರಜನಕ (Nitrogen)", "ಆಮ್ಲಜನಕ (Oxygen)", "ಹೈಡ್ರೋಜನ್", "ಕ್ಲೋರಿನ್"),
            correctAnswer = "ಸಾರಜನಕ (Nitrogen)",
            explanation = "ಸಾರಜನಕವು ಜಡ ಅನಿಲವಾಗಿದ್ದು ಆಕ್ಸಿಡೀಕರಣವನ್ನು ತಡೆದು ಚಿಪ್ಸ್ ಕಮಟಾಗದಂತೆ ರಕ್ಷಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u1_12",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ತಾಮ್ರದ ಪುಡಿಯನ್ನು ಗಾಳಿಯಲ್ಲಿ ಕಾಯಿಸಿದಾಗ ಅದರ ಮೇಲ್ಮೈ ಕಪ್ಪು ಬಣ್ಣಕ್ಕೆ ತಿರುಗಲು ಕಾರಣವೇನು?",
            options = listOf("ಕ್ಯುಪ್ರಿಕ್ ಆಕ್ಸೈಡ್ (CuO) ಉಂಟಾಗುವುದು", "ತಾಮ್ರ ಕರಗುವುದು", "ತಾಮ್ರದ ನೈಟ್ರೇಟ್ ಉಂಟಾಗುವುದು", "ಹೈಡ್ರೋಜನ್ ಅನಿಲ ಬಿಡುಗಡೆಯಾಗುವುದು"),
            correctAnswer = "ಕ್ಯುಪ್ರಿಕ್ ಆಕ್ಸೈಡ್ (CuO) ಉಂಟಾಗುವುದು",
            explanation = "2Cu + O2 -> 2CuO. ತಾಮ್ರವು ಆಮ್ಲಜನಕದೊಂದಿಗೆ ವರ್ತಿಸಿ ಕಪ್ಪು ಬಣ್ಣದ ಕಾಪರ್ ಆಕ್ಸೈಡ್ ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u1_13",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬೆಳ್ಳಿಯ ವಸ್ತುಗಳು ಗಾಳಿಗೆ ತೆರೆದಿಟ್ಟಾಗ ಕಪ್ಪಾಗಲು ಅವುಗಳ ಮೇಲೆ ಉಂಟಾಗುವ ಪದರ ಯಾವುದು?",
            options = listOf("ಸಿಲ್ವರ್ ಸಲ್ಫೈಡ್ (Ag2S)", "ಸಿಲ್ವರ್ ಆಕ್ಸೈಡ್", "ಸಿಲ್ವರ್ ನೈಟ್ರೇಟ್", "ಸಿಲ್ವರ್ ಕ್ಲೋರೈಡ್"),
            correctAnswer = "ಸಿಲ್ವರ್ ಸಲ್ಫೈಡ್ (Ag2S)",
            explanation = "ಗಾಳಿಯಲ್ಲಿರುವ ಹೈಡ್ರೋಜನ್ ಸಲ್ಫೈಡ್ ಜೊತೆ ಬೆಳ್ಳಿ ವರ್ತಿಸಿ ಕಪ್ಪು ಬಣ್ಣದ ಸಿಲ್ವರ್ ಸಲ್ಫೈಡ್ ಪದರವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u1_14",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪ್ರತಿವರ್ತಕಗಳ ನಡುವೆ ಅಯಾನುಗಳ ವಿನಿಮಯ ನಡೆಯುವ ಕ್ರಿಯೆಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ದ್ವಿಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ", "ಸಂಯೋಗ ಕ್ರಿಯೆ", "ವಿಘಟನ ಕ್ರಿಯೆ", "ಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ"),
            correctAnswer = "ದ್ವಿಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ",
            explanation = "ಎರಡು ಸಂಯುಕ್ತಗಳ ನಡುವೆ ಧನ ಮತ್ತು ಋಣ ಅಯಾನುಗಳು ಪರಸ್ಪರ ವಿನಿಮಯಗೊಳ್ಳುವ ಕ್ರಿಯೆಯೇ ದ್ವಿಸ್ಥಾನಪಲ್ಲಟ ಕ್ರಿಯೆ (Double displacement)."
        ),
        QuestionModel(
            id = "s_10_sci_u1_15",
            stdId = 10,
            subjectId = "science",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸೋಡಿಯಂ ಸಲ್ಫೇಟ್ ಮತ್ತು ಬೇರಿಯಂ ಕ್ಲೋರೈಡ್ ದ್ರಾವಣಗಳನ್ನು ಬೆರೆಸಿದಾಗ ಉಂಟಾಗುವ ಬಿಳಿ ಪ್ರಕ್ಷೇಪ ಯಾವುದು?",
            options = listOf("ಬೇರಿಯಂ ಸಲ್ಫೇಟ್ (BaSO4)", "ಸೋಡಿಯಂ ಕ್ಲೋರೈಡ್", "ಬೇರಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್", "ಸೋಡಿಯಂ ಆಕ್ಸೈಡ್"),
            correctAnswer = "ಬೇರಿಯಂ ಸಲ್ಫೇಟ್ (BaSO4)",
            explanation = "Na2SO4 + BaCl2 -> BaSO4(s) + 2NaCl. ಕರಗದ ಬಿಳಿ ಬಣ್ಣದ ಬೇರಿಯಂ ಸಲ್ಫೇಟ್ ಪ್ರಕ್ಷೇಪ ಉಂಟಾಗುತ್ತದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 2: ಆಮ್ಲಗಳು, ಪ್ರತ್ಯಾಮ್ಲಗಳು ಮತ್ತು ಲವಣಗಳು
    // ========================================================
    private val u2Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u2_1",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಒಂದು ದ್ರಾವಣವು ಕೆಂಪು ಲಿಟ್ಮಸ್ ಅನ್ನು ನೀಲಿ ಬಣ್ಣಕ್ಕೆ ತಿರುಗಿಸಿದರೆ ಅದರ pH ಮೌಲ್ಯವು ಬಹುಶಃ ಎಷ್ಟು ಇರಬಹುದು?",
            options = listOf("1", "4", "5", "10"),
            correctAnswer = "10",
            explanation = "ಕೆಂಪು ಲಿಟ್ಮಸ್ ಅನ್ನು ನೀಲಿ ಬಣ್ಣಕ್ಕೆ ತಿರುಗಿಸುವುದು ಪ್ರತ್ಯಾಮ್ಲ. ಪ್ರತ್ಯಾಮ್ಲಗಳ pH ಮೌಲ್ಯವು 7 ಕ್ಕಿಂತ ಹೆಚ್ಚಾಗಿರುತ್ತದೆ (ಇಲ್ಲಿ 10)."
        ),
        QuestionModel(
            id = "s_10_sci_u2_2",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಒಂದು ದ್ರಾವಣವು ಪುಡಿಮಾಡಿದ ಮೊಟ್ಟೆಯ ಚೂರನ್ನು ಕರಗಿಸಿ ಅನಿಲವನ್ನು ಬಿಡುಗಡೆ ಮಾಡುತ್ತದೆ. ಈ ಅನಿಲವು ಸುಣ್ಣದ ತಿಳಿನೀರನ್ನು ಹಾಲಿನಂತೆ ಬೆಳ್ಳಗಾಗಿಸುತ್ತದೆ. ಆ ದ್ರಾವಣ ಯಾವುದು?",
            options = listOf("NaCl", "HCl", "LiCl", "KCl"),
            correctAnswer = "HCl",
            explanation = "ಮೊಟ್ಟೆಯ ಚೂರು ಕ್ಯಾಲ್ಸಿಯಂ ಕಾರ್ಬೋನೇಟ್ (CaCO3) ನಿಂದಾಗಿದೆ. ಇದು ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲದೊಂದಿಗೆ ವರ್ತಿಸಿದಾಗ CO2 ಅನಿಲ ಬಿಡುಗಡೆಯಾಗಿ ಸುಣ್ಣದ ನೀರನ್ನು ಹಾಲಿನಂತೆ ಬೆಳ್ಳಗಾಗಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_3",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಜಠರದಲ್ಲಿ ಅತಿಯಾದ ಆಮ್ಲ ಉತ್ಪತ್ತಿಯಾಗಿ ಆಸಿಡಿಟಿ ಉಂಟಾದಾಗ ಚಿಕಿತ್ಸೆಗೆ ಬಳಸುವ ಆಂಟಾಸಿಡ್ (ಪ್ರತ್ಯಾಮ್ಲ) ಯಾವುದು?",
            options = listOf("ಮಿಲ್ಕ್ ಆಫ್ ಮೆಗ್ನೀಸಿಯಾ [Mg(OH)2]", "ಸೋಡಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್", "ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲ", "ಸಲ್ಫ್ಯೂರಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಮಿಲ್ಕ್ ಆಫ್ ಮೆಗ್ನೀಸಿಯಾ [Mg(OH)2]",
            explanation = "ಮೆಗ್ನೀಸಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್ ಒಂದು ಸೌಮ್ಯ ಪ್ರತ್ಯಾಮ್ಲವಾಗಿದ್ದು, ಜಠರದ ಅಧಿಕ ಆಮ್ಲವನ್ನು ತಟಸ್ಥಗೊಳಿಸಿ ಆಸಿಡಿಟಿಯನ್ನು ಕಡಿಮೆ ಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_4",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಹಲ್ಲಿನ ಎನಾಮಲ್ ಮಾನವನ ದೇಹದ ಅತ್ಯಂತ ಗಟ್ಟಿಯಾದ ವಸ್ತುವಾಗಿದೆ. ಇದು ಯಾವುದರಿಂದ ಮಾಡಲ್ಪಟ್ಟಿದೆ?",
            options = listOf("ಕ್ಯಾಲ್ಸಿಯಂ ಫಾಸ್ಫೇಟ್ (ಹೈಡ್ರಾಕ್ಸಿ ಅಪಟೈಟ್)", "ಕ್ಯಾಲ್ಸಿಯಂ ಕಾರ್ಬೋನೇಟ್", "ಮೆಗ್ನೀಸಿಯಂ ಆಕ್ಸೈಡ್", "ಸೋಡಿಯಂ ಕ್ಲೋರೈಡ್"),
            correctAnswer = "ಕ್ಯಾಲ್ಸಿಯಂ ಫಾಸ್ಫೇಟ್ (ಹೈಡ್ರಾಕ್ಸಿ ಅಪಟೈಟ್)",
            explanation = "ಹಲ್ಲಿನ ಹೊರಕವಚವಾದ ಎನಾಮಲ್ ಕ್ಯಾಲ್ಸಿಯಂ ಫಾಸ್ಫೇಟ್‌ನ ಸ್ಫಟಿಕ ರೂಪದಿಂದ ಮಾಡಲ್ಪಟ್ಟಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_5",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬಾಯಿಯ pH ಮೌಲ್ಯವು ಎಷ್ಟಕ್ಕಿಂತ ಕಡಿಮೆಯಾದಾಗ ಹಲ್ಲಿನ ಸವೆತ (Tooth decay) ಪ್ರಾರಂಭವಾಗುತ್ತದೆ?",
            options = listOf("5.5", "7.0", "8.5", "6.8"),
            correctAnswer = "5.5",
            explanation = "ಬಾಯಿಯಲ್ಲಿರುವ ಬ್ಯಾಕ್ಟೀರಿಯಾಗಳು ಆಹಾರ ಕಣಗಳನ್ನು ಹುದುಗಿಸಿ ಆಮ್ಲ ಉತ್ಪಾದಿಸಿದಾಗ pH 5.5 ಕ್ಕಿಂತ ಕಡಿಮೆಯಾಗಿ ಎನಾಮಲ್ ಸವೆಯಲು ಆರಂಭವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_6",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಇರುವೆ ಕಡಿತ ಅಥವಾ ನೆಟಲ್ ಗಿಡದ ಮುಳ್ಳು ಚುಚ್ಚಿದಾಗ ಉರಿಯುವ ಅನುಭವಕ್ಕೆ ಕಾರಣವಾಗುವ ಆಮ್ಲ ಯಾವುದು?",
            options = listOf("ಮೆಥನೋಯಿಕ್ ಆಮ್ಲ (ಫಾರ್ಮಿಕ್ ಆಮ್ಲ)", "ಅಸಿಟಿಕ್ ಆಮ್ಲ", "ಸಿಟ್ರಿಕ್ ಆಮ್ಲ", "ಟಾರ್ಟಾರಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಮೆಥನೋಯಿಕ್ ಆಮ್ಲ (ಫಾರ್ಮಿಕ್ ಆಮ್ಲ)",
            explanation = "ಇರುವೆ ಮತ್ತು ನೆಟಲ್ ಮುಳ್ಳುಗಳು ಮೆಥನೋಯಿಕ್ ಆಮ್ಲವನ್ನು (Methanoic acid) ಸ್ರವಿಸುವುದರಿಂದ ಚರ್ಮದಲ್ಲಿ ತೀವ್ರ ಉರಿ ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_7",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ತೊಳೆಯುವ ಸೋಡಾದ (ವಾಷಿಂಗ್ ಸೋಡಾ) ಸರಿಯಾದ ರಾಸಾಯನಿಕ ಸೂತ್ರ ಯಾವುದು?",
            options = listOf("Na2CO3·10H2O", "NaHCO3", "CaSO4·2H2O", "CaOCl2"),
            correctAnswer = "Na2CO3·10H2O",
            explanation = "ಸೋಡಿಯಂ ಕಾರ್ಬೋನೇಟ್ ಡೆಕಾಹೈಡ್ರೇಟ್ (Na2CO3·10H2O) ವಾಷಿಂಗ್ ಸೋಡಾದ ರಾಸಾಯನಿಕ ಸೂತ್ರವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_8",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬೇಕಿಂಗ್ ಪೌಡರ್ ತಯಾರಿಕೆಯಲ್ಲಿ ಬೇಕಿಂಗ್ ಸೋಡಾದ ಜೊತೆಗೆ ಬಳಸುವ ಖಾದ್ಯ ಆಮ್ಲ ಯಾವುದು?",
            options = listOf("ಟಾರ್ಟಾರಿಕ್ ಆಮ್ಲ", "ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲ", "ಸಲ್ಫ್ಯೂರಿಕ್ ಆಮ್ಲ", "ನೈಟ್ರಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಟಾರ್ಟಾರಿಕ್ ಆಮ್ಲ",
            explanation = "ಬೇಕಿಂಗ್ ಸೋಡಾ (NaHCO3) ಮತ್ತು ಮೃದು ಖಾದ್ಯ ಆಮ್ಲವಾದ ಟಾರ್ಟಾರಿಕ್ ಆಮ್ಲದ ಮಿಶ್ರಣವೇ ಬೇಕಿಂಗ್ ಪೌಡರ್."
        ),
        QuestionModel(
            id = "s_10_sci_u2_9",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಪ್ಲಾಸ್ಟರ್ ಆಫ್ ಪ್ಯಾರಿಸ್‌ನ ರಾಸಾಯನಿಕ ಸೂತ್ರ ಯಾವುದು?",
            options = listOf("CaSO4·½H2O", "CaSO4·2H2O", "CuSO4·5H2O", "FeSO4·7H2O"),
            correctAnswer = "CaSO4·½H2O",
            explanation = "ಪ್ಲಾಸ್ಟರ್ ಆಫ್ ಪ್ಯಾರಿಸ್ ಎಂದರೆ ಕ್ಯಾಲ್ಸಿಯಂ ಸಲ್ಫೇಟ್ ಹೆಮಿಹೈಡ್ರೇಟ್ (CaSO4·½H2O)."
        ),
        QuestionModel(
            id = "s_10_sci_u2_10",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಬ್ಲೀಚಿಂಗ್ ಪೌಡರ್‌ನ (ಚಲುವೆ ಪುಡಿ) ರಾಸಾಯನಿಕ ಹೆಸರು ಮತ್ತು ಸೂತ್ರ ಯಾವುದು?",
            options = listOf("ಕ್ಯಾಲ್ಸಿಯಂ ಆಕ್ಸಿಕ್ಲೋರೈಡ್ (CaOCl2)", "ಕ್ಯಾಲ್ಸಿಯಂ ಕಾರ್ಬೋನೇಟ್", "ಸೋಡಿಯಂ ಕ್ಲೋರೈಡ್", "ಕ್ಯಾಲ್ಸಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್"),
            correctAnswer = "ಕ್ಯಾಲ್ಸಿಯಂ ಆಕ್ಸಿಕ್ಲೋರೈಡ್ (CaOCl2)",
            explanation = "ಒಣ ಅರಳಿದ ಸುಣ್ಣದ ಮೇಲೆ ಕ್ಲೋರಿನ್ ಹಾಯಿಸಿದಾಗ ಬ್ಲೀಚಿಂಗ್ ಪೌಡರ್ (CaOCl2) ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_11",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಆಸಿಡ್ ಮಳೆ (ಆಮ್ಲ ಮಳೆ) ಎಂದು ಕರೆಯಲು ಮಳೆಯ ನೀರಿನ pH ಮೌಲ್ಯವು ಎಷ್ಟಕ್ಕಿಂತ ಕಡಿಮೆಯಿರಬೇಕು?",
            options = listOf("5.6", "7.0", "6.5", "8.0"),
            correctAnswer = "5.6",
            explanation = "ಮಳೆಯ ನೀರಿನ pH ಮೌಲ್ಯವು 5.6 ಕ್ಕಿಂತ ಕಡಿಮೆಯಾದಾಗ ಅದನ್ನು ಆಮ್ಲ ಮಳೆ ಎಂದು ಕರೆಯಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_12",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಕ್ಲೋರ್-ಆಲ್ಕಲಿ ಪ್ರಕ್ರಿಯೆಯಲ್ಲಿ ಆನೋಡ್ ಬಳಿ ಬಿಡುಗಡೆಯಾಗುವ ಅನಿಲ ಯಾವುದು?",
            options = listOf("ಕ್ಲೋರಿನ್ ಅನಿಲ (Cl2)", "ಹೈಡ್ರೋಜನ್ ಅನಿಲ (H2)", "ಆಕ್ಸಿಜನ್ ಅನಿಲ", "ಸಾರಜನಕ ಅನಿಲ"),
            correctAnswer = "ಕ್ಲೋರಿನ್ ಅನಿಲ (Cl2)",
            explanation = "ಸೋಡಿಯಂ ಕ್ಲೋರೈಡ್ ಜಲೀಯ ದ್ರಾವಣದ ವಿದ್ಯುದ್ವಿಭಜನೆಯಲ್ಲಿ ಆನೋಡ್ ಬಳಿ ಕ್ಲೋರಿನ್ ಮತ್ತು ಕ್ಯಾಥೋಡ್ ಬಳಿ ಹೈಡ್ರೋಜನ್ ಬಿಡುಗಡೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_13",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ಲೋಹಗಳು ಆಮ್ಲಗಳೊಂದಿಗೆ ವರ್ತಿಸಿದಾಗ ಬಿಡುಗಡೆಯಾಗುವ ಅನಿಲವನ್ನು ಹೇಗೆ ಪರೀಕ್ಷಿಸಲಾಗುತ್ತದೆ?",
            options = listOf("ಉರಿಯುವ ಬೆಂಕಿಕಡ್ಡಿಯನ್ನು ತಂದಾಗ 'ಪಾಪ್' ಶಬ್ದದೊಂದಿಗೆ ಉರಿಯುತ್ತದೆ", "ಸುಣ್ಣದ ತಿಳಿನೀರನ್ನು ಹಾಲಿನಂತೆ ಬೆಳ್ಳಗಾಗಿಸುತ್ತದೆ", "ವಾಸನೆಯಿಂದ ಗುರುತಿಸಲಾಗುತ್ತದೆ", "ನೀಲಿ ಲಿಟ್ಮಸ್ ಅನ್ನು ಕೆಂಪಾಗಿಸುತ್ತದೆ"),
            correctAnswer = "ಉರಿಯುವ ಬೆಂಕಿಕಡ್ಡಿಯನ್ನು ತಂದಾಗ 'ಪಾಪ್' ಶಬ್ದದೊಂದಿಗೆ ಉರಿಯುತ್ತದೆ",
            explanation = "ಬಿಡುಗಡೆಯಾಗುವ ಹೈಡ್ರೋಜನ್ ಅನಿಲದ ಬಳಿ ಉರಿಯುವ ಕಡ್ಡಿ ತಂದಾಗ ಅದು ವಿಶಿಷ್ಟ 'ಪಾಪ್' ಶಬ್ದದೊಂದಿಗೆ ಉರಿಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_14",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ನೀರಿನ ಕಾಯಂ ಗಡಸುತನವನ್ನು ನಿವಾರಿಸಲು ಬಳಸುವ ಸೋಡಿಯಂ ಸಂಯುಕ್ತ ಯಾವುದು?",
            options = listOf("ವಾಷಿಂಗ್ ಸೋಡಾ (Na2CO3·10H2O)", "ಬೇಕಿಂಗ್ ಸೋಡಾ", "ಬ್ಲೀಚಿಂಗ್ ಪೌಡರ್", "ಸೋಡಿಯಂ ಹೈಡ್ರಾಕ್ಸೈಡ್"),
            correctAnswer = "ವಾಷಿಂಗ್ ಸೋಡಾ (Na2CO3·10H2O)",
            explanation = "ನೀರಿನಲ್ಲಿರುವ ಕರಗಿದ ಕ್ಯಾಲ್ಸಿಯಂ ಮತ್ತು ಮೆಗ್ನೀಸಿಯಂ ಲವಣಗಳನ್ನು ಪ್ರಕ್ಷೇಪಿಸಲು ವಾಷಿಂಗ್ ಸೋಡಾವನ್ನು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u2_15",
            stdId = 10,
            subjectId = "science",
            unitId = 2,
            type = "MCQ",
            questionText = "ತಾಮ್ರದ ಪಾತ್ರೆಗಳ ಮೇಲಿನ ಹಸಿರು ಪದರವನ್ನು ಸ್ವಚ್ಛಗೊಳಿಸಲು ನಿಂಬೆ ರಸವನ್ನು ಬಳಸಲು ಕಾರಣವೇನು?",
            options = listOf("ಹಸಿರು ಪದರವು ಪ್ರತ್ಯಾಮ್ಲೀಯ ಬೇಸಿಕ್ ಕಾಪರ್ ಕಾರ್ಬೋನೇಟ್ ಆಗಿದ್ದು ನಿಂಬೆಯ ಆಮ್ಲದೊಂದಿಗೆ ತಟಸ್ಥಗೊಳ್ಳುತ್ತದೆ", "ನಿಂಬೆ ರಸವು ತಾಮ್ರವನ್ನು ಕರಗಿಸುತ್ತದೆ", "ನಿಂಬೆ ರಸವು ಪ್ರತ್ಯಾಮ್ಲವಾಗಿದೆ", "ಹಸಿರು ಪದರವು ಆಮ್ಲೀಯವಾಗಿದೆ"),
            correctAnswer = "ಹಸಿರು ಪದರವು ಪ್ರತ್ಯಾಮ್ಲೀಯ ಬೇಸಿಕ್ ಕಾಪರ್ ಕಾರ್ಬೋನೇಟ್ ಆಗಿದ್ದು ನಿಂಬೆಯ ಆಮ್ಲದೊಂದಿಗೆ ತಟಸ್ಥಗೊಳ್ಳುತ್ತದೆ",
            explanation = "ತಾಮ್ರದ ಮೇಲಿನ ಹಸಿರು ಪದರವು ಪ್ರತ್ಯಾಮ್ಲೀಯ ಕಾಪರ್ ಕಾರ್ಬೋನೇಟ್ ಆಗಿದೆ. ನಿಂಬೆಯಲ್ಲಿರುವ ಸಿಟ್ರಿಕ್ ಆಮ್ಲವು ಇದನ್ನು ತಟಸ್ಥಗೊಳಿಸಿ ಕರಗಿಸುತ್ತದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 3: ಲೋಹಗಳು ಮತ್ತು ಅಲೋಹಗಳು
    // ========================================================
    private val u3Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u3_1",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೋಣೆಯ ಉಷ್ಣತೆಯಲ್ಲಿ ದ್ರವರೂಪದಲ್ಲಿರುವ ಏಕೈಕ ಲೋಹ ಯಾವುದು?",
            options = listOf("ಪಾದರಸ (Mercury)", "ಬ್ರೋಮಿನ್", "ಸೋಡಿಯಂ", "ಗ್ಯಾಲಿಯಂ"),
            correctAnswer = "ಪಾದರಸ (Mercury)",
            explanation = "ಪಾದರಸವು (Hg) ಕೋಣೆಯ ಉಷ್ಣತೆಯಲ್ಲಿ ದ್ರವರೂಪದಲ್ಲಿರುವ ಏಕೈಕ ಲೋಹವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_2",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೋಣೆಯ ಉಷ್ಣತೆಯಲ್ಲಿ ದ್ರವರೂಪದಲ್ಲಿರುವ ಏಕೈಕ ಅಲೋಹ ಯಾವುದು?",
            options = listOf("ಬ್ರೋಮಿನ್ (Bromine)", "ಕ್ಲೋರಿನ್", "ಅಯೋಡಿನ್", "ರಂಜಕ"),
            correctAnswer = "ಬ್ರೋಮಿನ್ (Bromine)",
            explanation = "ಬ್ರೋಮಿನ್ ಕೋಣೆಯ ಸಾಮಾನ್ಯ ಉಷ್ಣತೆಯಲ್ಲಿ ದ್ರವರೂಪದಲ್ಲಿರುವ ಏಕೈಕ ಅಲೋಹವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_3",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಚಾಕುವಿನಿಂದ ಸುಲಭವಾಗಿ ಕತ್ತರಿಸಬಹುದಾದ ಅತ್ಯಂತ ಮೃದುವಾದ ಲೋಹಗಳು ಯಾವುವು?",
            options = listOf("ಸೋಡಿಯಂ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ", "ಕಬ್ಬಿಣ ಮತ್ತು ತಾಮ್ರ", "ಅಲ್ಯೂಮಿನಿಯಂ ಮತ್ತು ಸತು", "ಚಿನ್ನ ಮತ್ತು ಬೆಳ್ಳಿ"),
            correctAnswer = "ಸೋಡಿಯಂ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ",
            explanation = "ಸೋಡಿಯಂ (Na) ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ (K) ಅತ್ಯಂತ ಮೃದುವಾದ ಕ್ಷಾರಲೋಹಗಳಾಗಿದ್ದು ಚಾಕುವಿನಿಂದ ಸುಲಭವಾಗಿ ತುಂಡರಿಸಬಹುದು."
        ),
        QuestionModel(
            id = "s_10_sci_u3_4",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಗಾಳಿಯಲ್ಲಿ ತೆರೆದಿಟ್ಟಾಗ ತಕ್ಷಣ ಬೆಂಕಿ ಹೊತ್ತಿಕೊಳ್ಳುವುದರಿಂದ ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ (Kerosene) ಸಂಗ್ರಹಿಸಿಡುವ ಲೋಹಗಳು ಯಾವುವು?",
            options = listOf("ಸೋಡಿಯಂ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ", "ಮೆಗ್ನೀಸಿಯಂ ಮತ್ತು ಕ್ಯಾಲ್ಸಿಯಂ", "ಕಬ್ಬಿಣ ಮತ್ತು ಸತು", "ತಾಮ್ರ ಮತ್ತು ಪಾದರಸ"),
            correctAnswer = "ಸೋಡಿಯಂ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ",
            explanation = "ಸೋಡಿಯಂ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ ಅತೀವ ಕ್ರಿಯಾಶೀಲ ಲೋಹಗಳಾಗಿದ್ದು ಗಾಳಿಯ ಆಕ್ಸಿಜನ್ ಮತ್ತು ತೇವಾಂಶದೊಂದಿಗೆ ಸ್ಫೋಟಕವಾಗಿ ವರ್ತಿಸುವುದರಿಂದ ಸೀಮೆಎಣ್ಣೆಯಲ್ಲಿ ಮುಳುಗಿಸಿಡಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_5",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಆಮ್ಲ ಮತ್ತು ಪ್ರತ್ಯಾಮ್ಲ ಎರಡರೊಂದಿಗೂ ವರ್ತಿಸಿ ಲವಣ ಮತ್ತು ನೀರನ್ನು ಉಂಟುಮಾಡುವ ಉಭಯವರ್ತಿ ಆಕ್ಸೈಡ್‌ಗಳಿಗೆ (Amphoteric oxides) ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಅಲ್ಯೂಮಿನಿಯಂ ಆಕ್ಸೈಡ್ ಮತ್ತು ಜಿಂಕ್ ಆಕ್ಸೈಡ್", "ಸೋಡಿಯಂ ಆಕ್ಸೈಡ್ ಮತ್ತು ಪೊಟ್ಯಾಸಿಯಂ ಆಕ್ಸೈಡ್", "ಕಬ್ಬಿಣದ ಆಕ್ಸೈಡ್ ಮತ್ತು ಕಾಪರ್ ಆಕ್ಸೈಡ್", "ಕ್ಯಾಲ್ಸಿಯಂ ಆಕ್ಸೈಡ್ ಮತ್ತು ಮೆಗ್ನೀಸಿಯಂ ಆಕ್ಸೈಡ್"),
            correctAnswer = "ಅಲ್ಯೂಮಿನಿಯಂ ಆಕ್ಸೈಡ್ ಮತ್ತು ಜಿಂಕ್ ಆಕ್ಸೈಡ್",
            explanation = "Al2O3 ಮತ್ತು ZnO ಆಮ್ಲ ಹಾಗೂ ಪ್ರತ್ಯಾಮ್ಲ ಎರಡರ ಗುಣಗಳನ್ನೂ ಪ್ರದರ್ಶಿಸುವ ಉಭಯವರ್ತಿ ಆಕ್ಸೈಡ್‌ಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_6",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಚಿನ್ನ ಮತ್ತು ಪ್ಲಾಟಿನಂ ಅನ್ನು ಕರಗಿಸುವ ಸಾಮರ್ಥ್ಯವಿರುವ ಅಕ್ವಾರಿಜಿಯಾ (ರಾಜೋದಕ) ಮಿಶ್ರಣದಲ್ಲಿರುವ ಆಮ್ಲಗಳ ಅನುಪಾತ ಯಾವುದು?",
            options = listOf("ಸಾರ HCl ಮತ್ತು ಸಾರ HNO3 (3:1)", "ಸಾರ HCl ಮತ್ತು ಸಾರ H2SO4 (1:3)", "ಸಾರ HNO3 ಮತ್ತು ಸಾರ HCl (3:1)", "ಸಾರ H2SO4 ಮತ್ತು ಸಾರ HNO3 (1:1)"),
            correctAnswer = "ಸಾರ HCl ಮತ್ತು ಸಾರ HNO3 (3:1)",
            explanation = "ಸಾರ ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲ ಮತ್ತು ಸಾರ ನೈಟ್ರಿಕ್ ಆಮ್ಲಗಳ 3:1 ಪ್ರಮಾಣದ ತಾಜಾ ಮಿಶ್ರಣವೇ ಅಕ್ವಾರಿಜಿಯಾ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_7",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಅಧಿಕ ಗಾಳಿಯ ಉಪಸ್ಥಿತಿಯಲ್ಲಿ ಸಲ್ಫೈಡ್ ಅದಿರನ್ನು ಕಾಯಿಸಿ ಆಕ್ಸೈಡ್ ಆಗಿ ಪರಿವರ್ತಿಸುವ ವಿಧಾನವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಹುರಿಯುವಿಕೆ (Roasting)", "ಭಸ್ಮೀಕರಣ (Calcination)", "ವಿದ್ಯುದ್ವಿಭಜನೆ", "ಶುದ್ಧೀಕರಣ"),
            correctAnswer = "ಹುರಿಯುವಿಕೆ (Roasting)",
            explanation = "ಸಲ್ಫೈಡ್ ಅದಿರುಗಳನ್ನು ಹೆಚ್ಚಿನ ಗಾಳಿಯ ಸಂಪರ್ಕದಲ್ಲಿ ತೀವ್ರವಾಗಿ ಕಾಯಿಸಿ ಆಕ್ಸೈಡ್ ಮಾಡುವ ಪ್ರಕ್ರಿಯೆಯೇ ಹುರಿಯುವಿಕೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_8",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸೀಮಿತ ಗಾಳಿಯ ಉಪಸ್ಥಿತಿಯಲ್ಲಿ ಕಾರ್ಬೋನೇಟ್ ಅದಿರನ್ನು ಕಾಯಿಸಿ ಆಕ್ಸೈಡ್ ಆಗಿ ಪರಿವರ್ತಿಸುವ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಭಸ್ಮೀಕರಣ (Calcination)", "ಹುರಿಯುವಿಕೆ (Roasting)", "ಅಪಕರ್ಷಣ", "ಕರಗಿಸುವಿಕೆ"),
            correctAnswer = "ಭಸ್ಮೀಕರಣ (Calcination)",
            explanation = "ಕಾರ್ಬೋನೇಟ್ ಅದಿರನ್ನು ಸೀಮಿತ ಗಾಳಿಯಲ್ಲಿ ಕಾಯಿಸಿ ಆಕ್ಸೈಡ್ ಆಗಿ ಪರಿವರ್ತಿಸುವ ವಿಧಾನವೇ ಭಸ್ಮೀಕರಣ (ಕ್ಯಾಲ್ಸಿನೇಷನ್)."
        ),
        QuestionModel(
            id = "s_10_sci_u3_9",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕಬ್ಬಿಣದ ಹಳಿಗಳನ್ನು ಬೆಸೆಯಲು ಬಳಸುವ ಥರ್ಮಿಟ್ ಕ್ರಿಯೆಯಲ್ಲಿ (Thermite process) ಅಪಕರ್ಷಣಕಾರಿಯಾಗಿ ಬಳಸುವ ವಸ್ತು ಯಾವುದು?",
            options = listOf("ಅಲ್ಯೂಮಿನಿಯಂ ಪುಡಿ", "ಕಾರ್ಬನ್", "ಸೋಡಿಯಂ", "ಮೆಗ್ನೀಸಿಯಂ"),
            correctAnswer = "ಅಲ್ಯೂಮಿನಿಯಂ ಪುಡಿ",
            explanation = "Fe2O3 ಜೊತೆ ಅಲ್ಯೂಮಿನಿಯಂ ಪುಡಿ ಬೆರೆಸಿ ಕಾಯಿಸಿದಾಗ ದ್ರವರೂಪದ ಕಬ್ಬಿಣ ಉಂಟಾಗಿ ಹಳಿಗಳನ್ನು ಬೆಸೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_10",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕಬ್ಬಿಣದ ವಸ್ತುಗಳು ತುಕ್ಕು ಹಿಡಿಯದಂತೆ ತಡೆಯಲು ಅವುಗಳ ಮೇಲೆ ಸತುವಿನ (Zinc) ತೆಳು ಪದರ ಲೇಪಿಸುವ ವಿಧಾನಕ್ಕೆ ಏನೆನ್ನುವರು?",
            options = listOf("ಗಾಲ್ವನೀಕರಣ (Galvanisation)", "ವಿದ್ಯುಲ್ಲೇಪನ", "ಮಿಶ್ರಲೋಹ ತಯಾರಿಕೆ", "ಅನೋಡೀಕರಣ"),
            correctAnswer = "ಗಾಲ್ವನೀಕರಣ (Galvanisation)",
            explanation = "ಕಬ್ಬಿಣ ಅಥವಾ ಉಕ್ಕಿನ ಮೇಲೆ ಸತುವಿನ ರಕ್ಷಣಾತ್ಮಕ ಪದರ ಲೇಪಿಸುವುದನ್ನು ಗಾಲ್ವನೀಕರಣ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_11",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಹಿತ್ತಾಳೆ (Brass) ಎಂಬುದು ಈ ಕೆಳಗಿನ ಯಾವ ಲೋಹಗಳ ಮಿಶ್ರಲೋಹವಾಗಿದೆ?",
            options = listOf("ತಾಮ್ರ ಮತ್ತು ಸತು (Cu + Zn)", "ತಾಮ್ರ ಮತ್ತು ತವರ (Cu + Sn)", "ಸೀಸ ಮತ್ತು ತವರ (Pb + Sn)", "ಕಬ್ಬಿಣ ಮತ್ತು ಕ್ರೋಮಿಯಂ"),
            correctAnswer = "ತಾಮ್ರ ಮತ್ತು ಸತು (Cu + Zn)",
            explanation = "ಹಿತ್ತಾಳೆಯು ತಾಮ್ರ (Copper) ಮತ್ತು ಸತು (Zinc) ಗಳ ಮಿಶ್ರಲೋಹವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_12",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕಂಚು (Bronze) ಈ ಕೆಳಗಿನ ಯಾವ ಲೋಹಗಳ ಮಿಶ್ರಲೋಹವಾಗಿದೆ?",
            options = listOf("ತಾಮ್ರ ಮತ್ತು ತವರ (Cu + Sn)", "ತಾಮ್ರ ಮತ್ತು ಸತು", "ಸೀಸ ಮತ್ತು ತವರ", "ಕಬ್ಬಿಣ ಮತ್ತು ನಿಕ್ಕಲ್"),
            correctAnswer = "ತಾಮ್ರ ಮತ್ತು ತವರ (Cu + Sn)",
            explanation = "ಕಂಚು ತಾಮ್ರ (Cu) ಮತ್ತು ತವರದ (Sn) ಮಿಶ್ರಲೋಹವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_13",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ತಂತಿಗಳನ್ನು ಬೆಸೆಯಲು ಬಳಸುವ ಸಾಲ್ಡರ್ (Solder) ಮಿಶ್ರಲೋಹದ ಘಟಕಗಳು ಯಾವುವು?",
            options = listOf("ಸೀಸ ಮತ್ತು ತವರ (Pb + Sn)", "ತಾಮ್ರ ಮತ್ತು ಸತು", "ಕಬ್ಬಿಣ ಮತ್ತು ಕಾರ್ಬನ್", "ಅಲ್ಯೂಮಿನಿಯಂ ಮತ್ತು ಮೆಗ್ನೀಸಿಯಂ"),
            correctAnswer = "ಸೀಸ ಮತ್ತು ತವರ (Pb + Sn)",
            explanation = "ಸಾಲ್ಡರ್ ಕಡಿಮೆ ಕರಗುವ ಬಿಂದುವನ್ನು ಹೊಂದಿರುವ ಸೀಸ (Lead) ಮತ್ತು ತವರದ (Tin) ಮಿಶ್ರಲೋಹವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_14",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸಿನಬಾರ್ (Cinnabar) ಎಂಬುದು ಯಾವ ಲೋಹದ ಪ್ರಮುಖ ಅದಿರಾಗಿದೆ?",
            options = listOf("ಪಾದರಸ (Hg)", "ತಾಮ್ರ (Cu)", "ಸತು (Zn)", "ಕಬ್ಬಿಣ (Fe)"),
            correctAnswer = "ಪಾದರಸ (Hg)",
            explanation = "ಸಿನಬಾರ್ (HgS - ಮರ್ಕ್ಯುರಿಕ್ ಸಲ್ಫೈಡ್) ಪಾದರಸದ ಪ್ರಮುಖ ಅದಿರಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u3_15",
            stdId = 10,
            subjectId = "science",
            unitId = 3,
            type = "MCQ",
            questionText = "ಅಯಾನಿಕ್ ಸಂಯುಕ್ತಗಳ ವಿಶಿಷ್ಟ ಲಕ್ಷಣ ಯಾವುದು?",
            options = listOf("ಹೆಚ್ಚಿನ ಕರಗುವ ಬಿಂದು ಮತ್ತು ಕುದಿಯುವ ಬಿಂದು ಹೊಂದಿರುತ್ತವೆ", "ನೀರಿನಲ್ಲಿ ಕರಗುವುದಿಲ್ಲ", "ಘನ ಸ್ಥಿತಿಯಲ್ಲಿ ವಿದ್ಯುತ್ತನ್ನು ಹರಿಸುತ್ತವೆ", "ಕಡಿಮೆ ಕರಗುವ ಬಿಂದು ಹೊಂದಿರುತ್ತವೆ"),
            correctAnswer = "ಹೆಚ್ಚಿನ ಕರಗುವ ಬಿಂದು ಮತ್ತು ಕುದಿಯುವ ಬಿಂದು ಹೊಂದಿರುತ್ತವೆ",
            explanation = "ಅಯಾನುಗಳ ನಡುವಿನ ಬಲವಾದ ಸ್ಥಾಯೀವಿದ್ಯುತ್ ಆಕರ್ಷಣಾ ಬಲವನ್ನು ಮುರಿಯಲು ಹೆಚ್ಚಿನ ಶಕ್ತಿ ಬೇಕಾಗಿರುವುದರಿಂದ ಅಯಾನಿಕ್ ಸಂಯುಕ್ತಗಳ ಕರಗುವ ಬಿಂದು ಅಧಿಕವಾಗಿರುತ್ತದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 4: ಕಾರ್ಬನ್ ಮತ್ತು ಅದರ ಸಂಯುಕ್ತಗಳು
    // ========================================================
    private val u4Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u4_1",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಈಥೇನ್ (C2H6) ಅಣುವು ಎಷ್ಟು ಸಹವೇಲೆನ್ಸೀಯ ಬಂಧಗಳನ್ನು ಹೊಂದಿದೆ?",
            options = listOf("6", "7", "8", "9"),
            correctAnswer = "7",
            explanation = "ಈಥೇನ್‌ನಲ್ಲಿ ಒಂದು C-C ಏಕಬಂಧ ಮತ್ತು ಆರು C-H ಏಕಬಂಧಗಳು ಸೇರಿ ಒಟ್ಟು 7 ಸಹವೇಲೆನ್ಸೀಯ ಬಂಧಗಳಿವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u4_2",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಬ್ಯೂಟನೋನ್ ನಾಲ್ಕು ಕಾರ್ಬನ್‌ಗಳ ಸಂಯುಕ್ತವಾಗಿದ್ದು ಇದರಲ್ಲಿರುವ ಕ್ರಿಯಾಗಂಪು (Functional Group) ಯಾವುದು?",
            options = listOf("ಕಾರ್ಬಾಕ್ಸಿಲಿಕ್ ಆಮ್ಲ", "ಆಲ್ಡಿಹೈಡ್", "ಕೀಟೋನ್", "ಆಲ್ಕೋಹಾಲ್"),
            correctAnswer = "ಕೀಟೋನ್",
            explanation = "ಬ್ಯೂಟನೋನ್‌ನಲ್ಲಿ (>C=O) ಕೀಟೋನ್ ಕ್ರಿಯಾಗಂಪು ಇರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u4_3",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಅಡುಗೆ ಮಾಡುವಾಗ ಪಾತ್ರೆಯ ತಳವು ಹೊರಭಾಗದಲ್ಲಿ ಕಪ್ಪಾಗುತ್ತಿದ್ದರೆ ಅದರ ಅರ್ಥವೇನು?",
            options = listOf("ಆಹಾರವು ಸರಿಯಾಗಿ ಬೆಂದಿಲ್ಲ", "ಇಂಧನವು ಅಪೂರ್ಣವಾಗಿ ದಹಿಸುತ್ತಿದೆ", "ಇಂಧನವು ಸಂಪೂರ್ಣವಾಗಿ ದಹಿಸುತ್ತಿದೆ", "ಇಂಧನವು ಒದ್ದೆಯಾಗಿದೆ"),
            correctAnswer = "ಇಂಧನವು ಅಪೂರ್ಣವಾಗಿ ದಹಿಸುತ್ತಿದೆ",
            explanation = "ಸಾಕಷ್ಟು ಆಕ್ಸಿಜನ್ ಸಿಗದೆ ಇಂಧನ ಅಪೂರ್ಣ ದಹನವಾದಾಗ ಮಸಿ (ಕಾರ್ಬನ್ ಕಣಗಳು) ಉಂಟಾಗಿ ಪಾತ್ರೆಯ ತಳ ಕಪ್ಪಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u4_4",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ವಾಹಕವಾಗಿರುವ ಕಾರ್ಬನ್‌ನ ಬಹುರೂಪ ಯಾವುದು?",
            options = listOf("ಗ್ರ್ಯಾಫೈಟ್", "ವಜ್ರ", "ಫುಲ್ಲರೀನ್", "ಕಲ್ಲಿದ್ದಲು"),
            correctAnswer = "ಗ್ರ್ಯಾಫೈಟ್",
            explanation = "ಗ್ರ್ಯಾಫೈಟ್‌ನಲ್ಲಿ ಪ್ರತಿಯೊಂದು ಕಾರ್ಬನ್ ಮೂರು ಕಾರ್ಬನ್‌ಗಳೊಂದಿಗೆ ಬಂಧ ಹೊಂದಿದ್ದು ಒಂದು ಮುಕ್ತ ಎಲೆಕ್ಟ್ರಾನ್ ಇರುವುದರಿಂದ ಅದು ವಿದ್ಯುತ್ ವಾಹಕವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u4_5",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕಾರ್ಬನ್ ಪರಮಾಣುಗಳು ಪರಸ್ಪರ ಬಂಧವೇರ್ಪಡಿಸಿ ಉದ್ದನೆಯ ಸರಪಳಿ ರೂಪಿಸುವ ವಿಶಿಷ್ಟ ಸಾಮರ್ಥ್ಯವನ್ನು ಏನೆನ್ನುವರು?",
            options = listOf("ಕೆಟನೀಕರಣ (Catenation)", "ಚತುರ್ವೇಲೆನ್ಸಿ", "ಬಹುರೂಪತೆ", "ಸಮಘಟಕತೆ"),
            correctAnswer = "ಕೆಟನೀಕರಣ (Catenation)",
            explanation = "ಕಾರ್ಬನ್ ತನ್ನದೇ ಪರಮಾಣುಗಳೊಂದಿಗೆ ಬಲವಾದ ಸಹವೇಲೆನ್ಸೀಯ ಬಂಧಗಳ ಮೂಲಕ ದೊಡ್ಡ ಅಣುಗಳನ್ನು ಸೃಷ್ಟಿಸುವ ಗುಣಕ್ಕೆ ಕೆಟನೀಕರಣ ಎನ್ನುವರು."
        ),
        QuestionModel(
            id = "s_10_sci_u4_6",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಆಲ್ಕೇನ್‌ಗಳ ಸಾಮಾನ್ಯ ಆಣ್ವಿಕ ಸೂತ್ರ ಯಾವುದು?",
            options = listOf("CnH2n+2", "CnH2n", "CnH2n-2", "CnH2n+1"),
            correctAnswer = "CnH2n+2",
            explanation = "ಪರ್ಯಾಪ್ತ ಹೈಡ್ರೋಕಾರ್ಬನ್‌ಗಳಾದ ಆಲ್ಕೇನ್‌ಗಳ ಸಾಮಾನ್ಯ ಸೂತ್ರ CnH2n+2."
        ),
        QuestionModel(
            id = "s_10_sci_u4_7",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಆಲ್ಕೀನ್‌ಗಳು ಮತ್ತು ಆಲ್ಕೈನ್‌ಗಳ ಸಾಮಾನ್ಯ ಸೂತ್ರಗಳು ಅನುಕ್ರಮವಾಗಿ ಯಾವುವು?",
            options = listOf("CnH2n ಮತ್ತು CnH2n-2", "CnH2n+2 ಮತ್ತು CnH2n", "CnH2n-2 ಮತ್ತು CnH2n", "CnH2n ಮತ್ತು CnH2n+2"),
            correctAnswer = "CnH2n ಮತ್ತು CnH2n-2",
            explanation = "ದ್ವಿಬಂಧ ಹೊಂದಿರುವ ಆಲ್ಕೀನ್‌ಗಳ ಸೂತ್ರ CnH2n ಮತ್ತು ತ್ರಿಬಂಧ ಹೊಂದಿರುವ ಆಲ್ಕೈನ್‌ಗಳ ಸೂತ್ರ CnH2n-2."
        ),
        QuestionModel(
            id = "s_10_sci_u4_8",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಬೆಂಜೀನ್‌ನ (Benzene) ಅಣುಸೂತ್ರ ಯಾವುದು?",
            options = listOf("C6H6", "C6H12", "C6H14", "C5H10"),
            correctAnswer = "C6H6",
            explanation = "ಬೆಂಜೀನ್ ಆರು ಕಾರ್ಬನ್ ಮತ್ತು ಆರು ಹೈಡ್ರೋಜನ್ ಹೊಂದಿರುವ ಚಕ್ರೀಯ ಹೈಡ್ರೋಕಾರ್ಬನ್ (C6H6)."
        ),
        QuestionModel(
            id = "s_10_sci_u4_9",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಆಹಾರ ಸಂರಕ್ಷಕವಾಗಿ ಬಳಸುವ ವಿನೆಗಾರ್ (Vinegar) ಎಂದರೆ ಏನು?",
            options = listOf("ನೀರಿನಲ್ಲಿ 5-8% ಅಸಿಟಿಕ್ ಆಮ್ಲದ ದ್ರಾವಣ", "ಶುದ್ಧ ಇಥನಾಲ್", "10% ಸಿಟ್ರಿಕ್ ಆಮ್ಲ", "ಸಾರಹೀನ ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ನೀರಿನಲ್ಲಿ 5-8% ಅಸಿಟಿಕ್ ಆಮ್ಲದ ದ್ರಾವಣ",
            explanation = "ನೀರಿನಲ್ಲಿ 5 ರಿಂದ 8 ಪ್ರತಿಶತ ಈಥನೋಯಿಕ್ ಆಮ್ಲದ (ಅಸಿಟಿಕ್ ಆಮ್ಲ) ದ್ರಾವಣವನ್ನು ವಿನೆಗಾರ್ ಎಂದು ಕರೆಯಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u4_10",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಆಲ್ಕೋಹಾಲ್ ಮತ್ತು ಕಾರ್ಬಾಕ್ಸಿಲಿಕ್ ಆಮ್ಲಗಳು ಆಮ್ಲೀಯ ವೇಗವರ್ಧಕದ ಸಮ್ಮುಖದಲ್ಲಿ ವರ್ತಿಸಿ ಸುವಾಸನಾಯುಕ್ತ ಉತ್ಪನ್ನ ನೀಡುವುದನ್ನು ಏನೆನ್ನುವರು?",
            options = listOf("ಎಸ್ಟರೀಕರಣ (Esterification)", "ಸಾಬೂನೀಕರಣ", "ಹೈಡ್ರೋಜನೀಕರಣ", "ದಹನ"),
            correctAnswer = "ಎಸ್ಟರೀಕರಣ (Esterification)",
            explanation = "ಇಥನಾಲ್ ಮತ್ತು ಈಥನೋಯಿಕ್ ಆಮ್ಲಗಳು ವರ್ತಿಸಿ ಸಿಹಿ ಸುವಾಸನೆಯುಳ್ಳ ಎಸ್ಟರ್ ಉಂಟಾಗುವುದೇ ಎಸ್ಟರೀಕರಣ."
        ),
        QuestionModel(
            id = "s_10_sci_u4_11",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಸ್ಯಜನ್ಯ ಎಣ್ಣೆಗಳಿಂದ ವನಸ್ಪತಿ ತುಪ್ಪ ತಯಾರಿಸಲು ಬಳಸುವ ಸಂಕಲನ ಕ್ರಿಯೆಯಲ್ಲಿ ವೇಗವರ್ಧಕವಾಗಿ ಬಳಸುವ ಲೋಹ ಯಾವುದು?",
            options = listOf("ನಿಕ್ಕಲ್ (Ni)", "ಕಬ್ಬಿಣ (Fe)", "ತಾಮ್ರ (Cu)", "ಸತು (Zn)"),
            correctAnswer = "ನಿಕ್ಕಲ್ (Ni)",
            explanation = "ಅಪರ್ಯಾಪ್ತ ಸಸ್ಯ ತೈಲಗಳಿಗೆ ಹೈಡ್ರೋಜನ್ ಸೇರಿಸಿ ಪರ್ಯಾಪ್ತ ಕೊಬ್ಬಾಗಿ ಪರಿವರ್ತಿಸಲು ನಿಕ್ಕಲ್ ಅಥವಾ ಪಲ್ಲಾಡಿಯಂ ವೇಗವರ್ಧಕ ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u4_12",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಾಬೂನಿನ ಅಣುವಿನಲ್ಲಿರುವ ಜಲವಿಕರ್ಷಕ (Hydrophobic) ಭಾಗ ಯಾವುದು?",
            options = listOf("ಹೈಡ್ರೋಕಾರ್ಬನ್ ಬಾಲ", "ಅಯಾನಿಕ್ ತುದಿ", "ಸೋಡಿಯಂ ಅಯಾನು", "ಕಾರ್ಬಾಕ್ಸಿಲೇಟ್ ಗುಂಪು"),
            correctAnswer = "ಹೈಡ್ರೋಕಾರ್ಬನ್ ಬಾಲ",
            explanation = "ಸಾಬೂನಿನ ಉದ್ದನೆಯ ಹೈಡ್ರೋಕಾರ್ಬನ್ ಸರಪಳಿಯು ಜಲವಿಕರ್ಷಕವಾಗಿದ್ದು ತೈಲ ಅಥವಾ ಕೊಳೆಯನ್ನು ಆಕರ್ಷಿಸುತ್ತದೆ; ಅಯಾನಿಕ್ ತುದಿ ಜಲಾಕರ್ಷಕವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u4_13",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಸಾಬೂನಿನ ಅಣುಗಳು ಕೊಳೆಯ ಸುತ್ತಲೂ ಕಣಗಳ ಪುಂಜವನ್ನು ರೂಪಿಸುವ ರಚನೆಗೆ ಏನೆನ್ನುವರು?",
            options = listOf("ಮಿಸೆಲ್ (Micelle)", "ಸ್ಫಟಿಕ", "ಎಮಲ್ಷನ್", "ಜೆಲ್"),
            correctAnswer = "ಮಿಸೆಲ್ (Micelle)",
            explanation = "ಸಾಬೂನಿನ ಜಲವಿಕರ್ಷಕ ಬಾಲಗಳು ಮಧ್ಯಭಾಗದಲ್ಲಿ ಕೊಳೆಯನ್ನು ಹಿಡಿದು ಅಯಾನಿಕ್ ತುದಿಗಳು ನೀರಿನ ಕಡೆಗೆ ಹೊರಮುಖವಾಗಿ ನಿಲ್ಲುವ ರಚನೆಯೇ ಮಿಸೆಲ್."
        ),
        QuestionModel(
            id = "s_10_sci_u4_14",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗಡಸು ನೀರಿನಲ್ಲಿರುವ ಕ್ಯಾಲ್ಸಿಯಂ ಮತ್ತು ಮೆಗ್ನೀಸಿಯಂ ಅಯಾನುಗಳೊಂದಿಗೆ ಗಸಿಯನ್ನು ರೂಪಿಸದೆ ಸುಲಭವಾಗಿ ನೊರೆ ನೀಡುವ ಶುಚಿಕಾರಿ ಯಾವುದು?",
            options = listOf("ಮಾರ್ಜಕ (Detergent)", "ಸಾಬೂನು", "ಸುಣ್ಣದ ನೀರು", "ಸೋಡಿಯಂ ಕ್ಲೋರೈಡ್"),
            correctAnswer = "ಮಾರ್ಜಕ (Detergent)",
            explanation = "ಮಾರ್ಜಕಗಳು ಸಲ್ಫೋನೇಟ್ ಲವಣಗಳಾಗಿದ್ದು ಗಡಸು ನೀರಿನ ಕ್ಯಾಲ್ಸಿಯಂ ಮತ್ತು ಮೆಗ್ನೀಸಿಯಂ ಜೊತೆ ಕರಗದ ಗಸಿಯನ್ನು ಉಂಟುಮಾಡುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_10_sci_u4_15",
            stdId = 10,
            subjectId = "science",
            unitId = 4,
            type = "MCQ",
            questionText = "ಇಥನಾಲ್ ಅನ್ನು ಪ್ರಬಲ ಆಕ್ಸಿಡೀಕಾರಕಗಳಾದ ಕ್ಷಾರೀಯ KMnO4 ನೊಂದಿಗೆ ಕಾಯಿಸಿದಾಗ ಉಂಟಾಗುವ ಉತ್ಪನ್ನ ಯಾವುದು?",
            options = listOf("ಈಥನೋಯಿಕ್ ಆಮ್ಲ (CH3COOH)", "ಮೀಥೇನ್", "ಕ್ಲೋರೋಫಾರ್ಮ್", "ಈಥೇನ್"),
            correctAnswer = "ಈಥನೋಯಿಕ್ ಆಮ್ಲ (CH3COOH)",
            explanation = "ಆಲ್ಕೋಹಾಲ್ ಸಂಪೂರ್ಣ ಆಕ್ಸಿಡೀಕರಣಗೊಂಡು ಕಾರ್ಬಾಕ್ಸಿಲಿಕ್ ಆಮ್ಲವಾಗುತ್ತದೆ: CH3CH2OH + [O] -> CH3COOH."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 5: ಧಾತುಗಳ ಆವರ್ತನೀಯ ವರ್ಗೀಕರಣ
    // ========================================================
    private val u5Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u5_1",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಧಾತುಗಳನ್ನು ಮೂರು ಮೂರರ ಗುಂಪುಗಳಾಗಿ ಜೋಡಿಸಿ 'ತ್ರಿವಳಿಗಳ ನಿಯಮ' ವನ್ನು ಮಂಡಿಸಿದ ವಿಜ್ಞಾನಿ ಯಾರು?",
            options = listOf("ಡೋಬರೈನರ್", "ನ್ಯೂಲ್ಯಾಂಡ್ಸ್", "ಮೆಂಡಲೀವ್", "ಮೋಸ್ಲೆ"),
            correctAnswer = "ಡೋಬರೈನರ್",
            explanation = "ಜರ್ಮನ್ ವಿಜ್ಞಾನಿ ಡೋಬರೈನರ್ ಧಾತುಗಳ ರಾಶಿಗಳನ್ನು ಆಧರಿಸಿ ತ್ರಿವಳಿಗಳ ನಿಯಮವನ್ನು (Law of Triads) ರೂಪಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_10_sci_u5_2",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಪ್ರತಿ ಎಂಟನೇ ಧಾತುವಿನ ಗುಣಗಳು ಮೊದಲನೇ ಧಾತುವಿನ ಗುಣಗಳನ್ನು ಹೋಲುತ್ತವೆ ಎಂದು ಹೇಳುವ 'ಅಷ್ಟಕಗಳ ನಿಯಮ' ವನ್ನು ರೂಪಿಸಿದವರು ಯಾರು?",
            options = listOf("ನ್ಯೂಲ್ಯಾಂಡ್ಸ್", "ಡೋಬರೈನರ್", "ಮೆಂಡಲೀವ್", "ರುದರ್‌ಫೋರ್ಡ್"),
            correctAnswer = "ನ್ಯೂಲ್ಯಾಂಡ್ಸ್",
            explanation = "ಸಂಗೀತದ ಸ್ವರಗಳಂತೆ ಪ್ರತಿ ಎಂಟನೇ ಧಾತುವು ಮೊದಲ ಧಾತುವಿನ ಗುಣವನ್ನು ಹೊಂದಿರುತ್ತದೆ ಎಂದು ಜಾನ್ ನ್ಯೂಲ್ಯಾಂಡ್ಸ್ ತಿಳಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_10_sci_u5_3",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮೆಂಡಲೀವ್‌ರ ಆವರ್ತಕ ನಿಯಮದ ಪ್ರಕಾರ ಧಾತುಗಳ ಗುಣಗಳು ಅವುಗಳ ಯಾವುದರ ಆವರ್ತನೀಯ ಕಾರ್ಯಗಳಾಗಿವೆ?",
            options = listOf("ಪರಮಾಣು ರಾಶಿ", "ಪರಮಾಣು ಸಂಖ್ಯೆ", "ಸಾಂದ್ರತೆ", "ವೇಲೆನ್ಸಿ"),
            correctAnswer = "ಪರಮಾಣು ರಾಶಿ",
            explanation = "ಮೆಂಡಲೀವ್‌ರ ಮೂಲ ಆವರ್ತಕ ನಿಯಮವು ಧಾತುಗಳ ಗುಣಗಳು ಅವುಗಳ ಪರಮಾಣು ರಾಶಿಗಳ ಆವರ್ತನೀಯ ಕಾರ್ಯಗಳಾಗಿವೆ ಎಂದು ತಿಳಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u5_4",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಆಧುನಿಕ ಆವರ್ತಕ ನಿಯಮವನ್ನು ರೂಪಿಸಿದ ವಿಜ್ಞಾನಿ ಯಾರು?",
            options = listOf("ಹೆನ್ರಿ ಮೋಸ್ಲೆ", "ಮೆಂಡಲೀವ್", "ಡಾಲ್ಟನ್", "ನೀಲ್ಸ್ ಬೋರ್"),
            correctAnswer = "ಹೆನ್ರಿ ಮೋಸ್ಲೆ",
            explanation = "1913 ರಲ್ಲಿ ಹೆನ್ರಿ ಮೋಸ್ಲೆ ಧಾತುವಿನ ಪರಮಾಣು ರಾಶಿಗಿಂತ ಪರಮಾಣು ಸಂಖ್ಯೆಯು ಹೆಚ್ಚು ಮೂಲಭೂತ ಗುಣಲಕ್ಷಣವೆಂದು ತೋರಿಸಿ ಆಧುನಿಕ ಆವರ್ತಕ ನಿಯಮ ನೀಡಿದರು."
        ),
        QuestionModel(
            id = "s_10_sci_u5_5",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಆಧುನಿಕ ಆವರ್ತಕ ಕೋಷ್ಟಕದಲ್ಲಿರುವ ಆವರ್ತಗಳು (Periods) ಮತ್ತು ಗುಂಪುಗಳ (Groups) ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("7 ಆವರ್ತಗಳು ಮತ್ತು 18 ಗುಂಪುಗಳು", "8 ಆವರ್ತಗಳು ಮತ್ತು 7 ಗುಂಪುಗಳು", "7 ಆವರ್ತಗಳು ಮತ್ತು 8 ಗುಂಪುಗಳು", "18 ಆವರ್ತಗಳು ಮತ್ತು 7 ಗುಂಪುಗಳು"),
            correctAnswer = "7 ಆವರ್ತಗಳು ಮತ್ತು 18 ಗುಂಪುಗಳು",
            explanation = "ಆಧುನಿಕ ಆವರ್ತಕ ಕೋಷ್ಟಕದಲ್ಲಿ 7 ಅಡ್ಡಸಾಲುಗಳು (ಆವರ್ತಗಳು) ಮತ್ತು 18 ಲಂಬಸಾಲುಗಳು (ಗುಂಪುಗಳು) ಇವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u5_6",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಆವರ್ತಕ ಕೋಷ್ಟಕದ ಒಂದು ಗುಂಪಿನಲ್ಲಿ ಮೇಲಿನಿಂದ ಕೆಳಕ್ಕೆ ಹೋದಂತೆ ಪರಮಾಣು ತ್ರಿಜ್ಯ (ಗಾತ್ರ) ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಹೆಚ್ಚಾಗುತ್ತದೆ", "ಕಡಿಮೆಯಾಗುತ್ತದೆ", "ಬದಲಾಗುವುದಿಲ್ಲ", "ಮೊದಲು ಕಡಿಮೆಯಾಗಿ ನಂತರ ಹೆಚ್ಚುತ್ತದೆ"),
            correctAnswer = "ಹೆಚ್ಚಾಗುತ್ತದೆ",
            explanation = "ಗುಂಪಿನಲ್ಲಿ ಕೆಳಕ್ಕೆ ಹೋದಂತೆ ಹೊಸ ಕವಚಗಳು (shells) ಸೇರ್ಪಡೆಯಾಗುವುದರಿಂದ ಪರಮಾಣುವಿನ ಗಾತ್ರ ಹೆಚ್ಚಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u5_7",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಆವರ್ತಕ ಕೋಷ್ಟಕದ ಒಂದು ಆವರ್ತದಲ್ಲಿ ಎಡದಿಂದ ಬಲಕ್ಕೆ ಹೋದಂತೆ ಪರಮಾಣು ತ್ರಿಜ್ಯ (ಗಾತ್ರ) ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಕಡಿಮೆಯಾಗುತ್ತದೆ", "ಹೆಚ್ಚಾಗುತ್ತದೆ", "ಬದಲಾಗುವುದಿಲ್ಲ", "ಸ್ಥಿರವಾಗಿರುತ್ತದೆ"),
            correctAnswer = "ಕಡಿಮೆಯಾಗುತ್ತದೆ",
            explanation = "ಕೇಂದ್ರದ ಧನಾವೇಶ ಹೆಚ್ಚಾಗುವುದರಿಂದ ಎಲೆಕ್ಟ್ರಾನ್‌ಗಳು ಬೀಜಕೇಂದ್ರದತ್ತ ಹೆಚ್ಚು ಆಕರ್ಷಿತವಾಗಿ ಪರಮಾಣು ಗಾತ್ರ ಕುಗ್ಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u5_8",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಆವರ್ತಕ ಕೋಷ್ಟಕದಲ್ಲಿ ಅತ್ಯಂತ ಹೆಚ್ಚು ವಿದ್ಯುತ್ ಋಣೀಯತೆ (Electronegativity) ಹೊಂದಿರುವ ಧಾತು ಯಾವುದು?",
            options = listOf("ಫ್ಲೋರಿನ್ (F)", "ಕ್ಲೋರಿನ್ (Cl)", "ಆಕ್ಸಿಜನ್ (O)", "ಸೋಡಿಯಂ (Na)"),
            correctAnswer = "ಫ್ಲೋರಿನ್ (F)",
            explanation = "ಫ್ಲೋರಿನ್ ಅತ್ಯಂತ ಸಣ್ಣ ಗಾತ್ರ ಮತ್ತು ಪ್ರಬಲ ಬೀಜಕೇಂದ್ರ ಆಕರ್ಷಣೆ ಹೊಂದಿರುವುದರಿಂದ ಗರಿಷ್ಠ ವಿದ್ಯುತ್ ಋಣೀಯತೆ ಹೊಂದಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u5_9",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಜಡ ಅನಿಲಗಳನ್ನು (ಉದಾ: ಹೀಲಿಯಂ, ನಿಯಾನ್, ಆರ್ಗಾನ್) ಆವರ್ತಕ ಕೋಷ್ಟಕದ ಯಾವ ಗುಂಪಿನಲ್ಲಿ ಇರಿಸಲಾಗಿದೆ?",
            options = listOf("18ನೇ ಗುಂಪು", "1ನೇ ಗುಂಪು", "17ನೇ ಗುಂಪು", "2ನೇ ಗುಂಪು"),
            correctAnswer = "18ನೇ ಗುಂಪು",
            explanation = "ಸಂಪೂರ್ಣ ಭರ್ತಿಯಾದ ಬಾಹ್ಯ ಕವಚವನ್ನು ಹೊಂದಿರುವ ಜಡ ಅನಿಲಗಳನ್ನು 18ನೇ ಶೂನ್ಯ ಗುಂಪಿನಲ್ಲಿ ಇರಿಸಲಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u5_10",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಮೆಂಡಲೀವ್ ತಮ್ಮ ಆವರ್ತಕ ಕೋಷ್ಟಕದಲ್ಲಿ ಭವಿಷ್ಯದಲ್ಲಿ ಆವಿಷ್ಕಾರವಾಗಲಿರುವ ಗ್ಯಾಲಿಯಂ ಧಾತುವಿಗೆ ಯಾವ ತಾತ್ಕಾಲಿಕ ಹೆಸರನ್ನು ಇರಿಸಿದ್ದರು?",
            options = listOf("ಎಕಾ-ಅಲ್ಯೂಮಿನಿಯಂ", "ಎಕಾ-ಬೋರಾನ್", "ಎಕಾ-ಸಿಲಿಕಾನ್", "ಎಕಾ-ಮ್ಯಾಂಗನೀಸ್"),
            correctAnswer = "ಎಕಾ-ಅಲ್ಯೂಮಿನಿಯಂ",
            explanation = "ಮೆಂಡಲೀವ್ ಗ್ಯಾಲಿಯಂ ಅನ್ನು 'ಎಕಾ-ಅಲ್ಯೂಮಿನಿಯಂ' ಎಂದೂ, ಜರ್ಮೇನಿಯಂ ಅನ್ನು 'ಎಕಾ-ಸಿಲಿಕಾನ್' ಎಂದೂ ಕರೆದು ಖಾಲಿ ಜಾಗ ಬಿಟ್ಟಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_10_sci_u5_11",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಧಾತುವಿನ ಪರಮಾಣು ಸಂಖ್ಯೆ 12 ಆಗಿದೆ. ಆಧುನಿಕ ಆವರ್ತಕ ಕೋಷ್ಟಕದಲ್ಲಿ ಅದರ ಸ್ಥಾನ ಯಾವುದು?",
            options = listOf("3ನೇ ಆವರ್ತ, 2ನೇ ಗುಂಪು", "2ನೇ ಆವರ್ತ, 3ನೇ ಗುಂಪು", "3ನೇ ಆವರ್ತ, 12ನೇ ಗುಂಪು", "2ನೇ ಆವರ್ತ, 2ನೇ ಗುಂಪು"),
            correctAnswer = "3ನೇ ಆವರ್ತ, 2ನೇ ಗುಂಪು",
            explanation = "ಪರಮಾಣು ಸಂಖ್ಯೆ 12 (ಮೆಗ್ನೀಸಿಯಂ) ರ ಎಲೆಕ್ಟ್ರಾನ್ ವಿನ್ಯಾಸ 2, 8, 2. ಮೂರು ಕವಚಗಳಿರುವುದರಿಂದ 3ನೇ ಆವರ್ತ, ಹೊರಕವಚದಲ್ಲಿ 2 ಎಲೆಕ್ಟ್ರಾನ್‌ಗಳಿರುವುದರಿಂದ 2ನೇ ಗುಂಪು."
        ),
        QuestionModel(
            id = "s_10_sci_u5_12",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಆವರ್ತದಲ್ಲಿ ಎಡದಿಂದ ಬಲಕ್ಕೆ ಚಲಿಸಿದಾಗ ಧಾತುಗಳ ಲೋಹೀಯ ಗುಣ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಕಡಿಮೆಯಾಗುತ್ತದೆ", "ಹೆಚ್ಚಾಗುತ್ತದೆ", "ಬದಲಾಗುವುದಿಲ್ಲ", "ಸ್ಥಿರವಾಗಿರುತ್ತದೆ"),
            correctAnswer = "ಕಡಿಮೆಯಾಗುತ್ತದೆ",
            explanation = "ಎಡದಿಂದ ಬಲಕ್ಕೆ ಹೋದಂತೆ ಎಲೆಕ್ಟ್ರಾನ್ ಕಳೆದುಕೊಳ್ಳುವ ಪ್ರವೃತ್ತಿ ಕಡಿಮೆಯಾಗುವುದರಿಂದ ಲೋಹೀಯ ಗುಣ ಕಡಿಮೆಯಾಗಿ ಅಲೋಹೀಯ ಗುಣ ಹೆಚ್ಚುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u5_13",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ನ್ಯೂಲ್ಯಾಂಡ್ಸ್‌ರ ಅಷ್ಟಕಗಳ ನಿಯಮವು ಯಾವ ಧಾತುವಿನವರೆಗೆ ಮಾತ್ರ ಅನ್ವಯಿಸುತ್ತಿತ್ತು?",
            options = listOf("ಕ್ಯಾಲ್ಸಿಯಂ", "ಕಬ್ಬಿಣ", "ಸೋಡಿಯಂ", "ಆಕ್ಸಿಜನ್"),
            correctAnswer = "ಕ್ಯಾಲ್ಸಿಯಂ",
            explanation = "ನ್ಯೂಲ್ಯಾಂಡ್ಸ್ ಅಷ್ಟಕಗಳ ನಿಯಮವು ಕೇವಲ ಕ್ಯಾಲ್ಸಿಯಂವರೆಗೆ ಮಾತ್ರ ಸರಿಯಾಗಿ ಅನ್ವಯಿಸುತ್ತಿತ್ತು, ನಂತರದ ಭಾರವಾದ ಧಾತುಗಳಿಗೆ ಅನ್ವಯಿಸಲಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_10_sci_u5_14",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಆವರ್ತಕ ಕೋಷ್ಟಕದಲ್ಲಿ ಹಾಲೋಜನ್‌ಗಳು ಇರುವ ಗುಂಪು ಯಾವುದು?",
            options = listOf("17ನೇ ಗುಂಪು", "1ನೇ ಗುಂಪು", "16ನೇ ಗುಂಪು", "2ನೇ ಗುಂಪು"),
            correctAnswer = "17ನೇ ಗುಂಪು",
            explanation = "ಫ್ಲೋರಿನ್, ಕ್ಲೋರಿನ್, ಬ್ರೋಮಿನ್, ಅಯೋಡಿನ್‌ಗಳನ್ನೊಳಗೊಂಡ ಲವಣೋತ್ಪಾದಕ ಹಾಲೋಜನ್‌ಗಳು 17ನೇ ಗುಂಪಿನಲ್ಲಿವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u5_15",
            stdId = 10,
            subjectId = "science",
            unitId = 5,
            type = "MCQ",
            questionText = "ಡೋಬರೈನರ್‌ನ ಮೊದಲ ತ್ರಿವಳಿಯ ಧಾತುಗಳು ಯಾವುವು?",
            options = listOf("ಲಿಥಿಯಂ, ಸೋಡಿಯಂ, ಪೊಟ್ಯಾಸಿಯಂ (Li, Na, K)", "ಕ್ಲೋರಿನ್, ಬ್ರೋಮಿನ್, ಅಯೋಡಿನ್", "ಕ್ಯಾಲ್ಸಿಯಂ, ಸ್ಟ್ರಾನ್ಷಿಯಂ, ಬೇರಿಯಂ", "ಕಬ್ಬಿಣ, ಕೋಬಾಲ್ಟ್, ನಿಕ್ಕಲ್"),
            correctAnswer = "ಲಿಥಿಯಂ, ಸೋಡಿಯಂ, ಪೊಟ್ಯಾಸಿಯಂ (Li, Na, K)",
            explanation = "Li (7) ಮತ್ತು K (39) ಪರಮಾಣು ರಾಶಿಯ ಸರಾಸರಿಯು Na (23) ಗೆ ಸಮನಾಗಿರುವ ಮೊದಲ ತ್ರಿವಳಿಯಾಗಿದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 6: ಜೀವಕ್ರಿಯೆಗಳು
    // ========================================================
    private val u6Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u6_1",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮಾನವನ ಜೀರ್ಣಾಂಗವ್ಯೂಹದಲ್ಲಿ ಲಾಲಾರಸದಲ್ಲಿರುವ ಯಾವ ಕಿಣ್ವವು ಸಂಕೀರ್ಣ ಪಿಷ್ಟವನ್ನು ಸರಳ ಸಕ್ಕರೆಯನ್ನಾಗಿ ಪರಿವರ್ತಿಸುತ್ತದೆ?",
            options = listOf("ಲಾಲಾರಸದ ಅಮೈಲೇಸ್ (ಟಯಲಿನ್)", "ಪೆಪ್ಸಿನ್", "ಟ್ರಿಪ್ಸಿನ್", "ಲೈಪೇಸ್"),
            correctAnswer = "ಲಾಲಾರಸದ ಅಮೈಲೇಸ್ (ಟಯಲಿನ್)",
            explanation = "ಲಾಲಾರಸದಲ್ಲಿರುವ ಅಮೈಲೇಸ್ ಕಿಣ್ವವು ಪಿಷ್ಟವನ್ನು ಮಾಲ್ಟೋಸ್ ಎಂಬ ಸರಳ ಸಕ್ಕರೆಯನ್ನಾಗಿ ವಿಭಜಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_2",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಜಠರದ ಒಳಪದರವನ್ನು ಹೈಡ್ರೋಕ್ಲೋರಿಕ್ ಆಮ್ಲದ ಕ್ರಿಯೆಯಿಂದ ರಕ್ಷಿಸುವ ಲೋಳೆಯಂತಹ ಸ್ರಾವ ಯಾವುದು?",
            options = listOf("ಶ್ಲೇಷ್ಮ (Mucus)", "ಪೆಪ್ಸಿನ್", "ಪಿತ್ತರಸ", "ಟ್ರಿಪ್ಸಿನ್"),
            correctAnswer = "ಶ್ಲೇಷ್ಮ (Mucus)",
            explanation = "ಜಠರದ ಗ್ರಂಥಿಗಳು ಸ್ರವಿಸುವ ಶ್ಲೇಷ್ಮವು ಜಠರದ ಭಿತ್ತಿಯನ್ನು ಪ್ರಬಲ ಆಮ್ಲದಿಂದ ರಕ್ಷಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_3",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕೊಬ್ಬಿನ ದೊಡ್ಡ ಕಣಗಳನ್ನು ಸಣ್ಣ ಕಣಗಳನ್ನಾಗಿ ವಿಭಜಿಸುವ 'ಎಮಲ್ಸೀಕರಣ' (Emulsification) ಕ್ರಿಯೆಯನ್ನು ನಡೆಸುವ ಸ್ರಾವ ಯಾವುದು?",
            options = listOf("ಪಿತ್ತರಸ (Bile juice)", "ಜಠರ ರಸ", "ಮೇದೋಜೀರಕ ರಸ", "ಲಾಲಾರಸ"),
            correctAnswer = "ಪಿತ್ತರಸ (Bile juice)",
            explanation = "ಯಕೃತ್ತಿನಿಂದ ಸ್ರವಿಸಲ್ಪಡುವ ಪಿತ್ತರಸದ ಲವಣಗಳು ಜೀರ್ಣಕ್ರಿಯೆಯಲ್ಲಿ ಕೊಬ್ಬಿನ ಎಮಲ್ಸೀಕರಣವನ್ನು ಉಂಟುಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_4",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಜೀರ್ಣವಾದ ಆಹಾರವನ್ನು ಹೀರಿಕೊಳ್ಳಲು ಸಣ್ಣ ಕರುಳಿನ ಒಳಭಿತ್ತಿಯಲ್ಲಿರುವ ಬೆರಳಿನಂತಹ ರಚನೆಗಳನ್ನು ಏನೆನ್ನುವರು?",
            options = listOf("ವಿಲ್ಲೈಗಳು (Villi)", "ನೆಫ್ರಾನ್‌ಗಳು", "ಅಲ್ವಿಯೋಲೈಗಳು", "ಸಿನಾಪ್ಸ್‌ಗಳು"),
            correctAnswer = "ವಿಲ್ಲೈಗಳು (Villi)",
            explanation = "ಸಣ್ಣ ಕರುಳಿನಲ್ಲಿರುವ ವಿಲ್ಲೈಗಳು ಹೀರಿಕೆಯ ಮೇಲ್ಮೈ ವಿಸ್ತೀರ್ಣವನ್ನು ಹೆಚ್ಚಿಸಿ ರಕ್ತಕ್ಕೆ ಪೋಷಕಾಂಶಗಳನ್ನು ಸಾಗಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_5",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಕೋಶೀಯ ಉಸಿರಾಟದಲ್ಲಿ ಗ್ಲೂಕೋಸ್ ಮೂರು ಕಾರ್ಬನ್‌ಗಳ ಪೈರುವೇಟ್ ಆಗಿ ವಿಭಜನೆಯಾಗುವ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಕೋಶದ್ರವ್ಯ (Cytoplasm)", "ಮೈಟೊಕಾಂಡ್ರಿಯಾ", "ನ್ಯೂಕ್ಲಿಯಸ್", "ರೈಬೋಸೋಮ್"),
            correctAnswer = "ಕೋಶದ್ರವ್ಯ (Cytoplasm)",
            explanation = "ಗ್ಲೈಕೋಲಿಸಿಸ್ ಕ್ರಿಯೆಯು ಜೀವಕೋಶದ ಕೋಶದ್ರವ್ಯದಲ್ಲಿ ನಡೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_6",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ತೀವ್ರ ವ್ಯಾಯಾಮದ ಸಮಯದಲ್ಲಿ ಸ್ನಾಯು ಕೋಶಗಳಲ್ಲಿ ಆಮ್ಲಜನಕದ ಕೊರತೆಯಿಂದ ಪೈರುವೇಟ್ ಯಾವುದಾಗಿ ಪರಿವರ್ತನೆಯಾಗಿ ಸೆಳೆತ ಉಂಟುಮಾಡುತ್ತದೆ?",
            options = listOf("ಲ್ಯಾಕ್ಟಿಕ್ ಆಮ್ಲ", "ಎಥನಾಲ್", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್", "ಸಿಟ್ರಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಲ್ಯಾಕ್ಟಿಕ್ ಆಮ್ಲ",
            explanation = "ಆಕ್ಸಿಜನ್ ಕೊರತೆಯಿಂದ ಸ್ನಾಯುಗಳಲ್ಲಿ ಲ್ಯಾಕ್ಟಿಕ್ ಆಮ್ಲ ಉತ್ಪತ್ತಿಯಾಗಿ ಶೇಖರಣೆಗೊಳ್ಳುವುದರಿಂದ ಸ್ನಾಯು ಸೆಳೆತ ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_7",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ವಾಯು ಉಸಿರಾಟದಲ್ಲಿ ಪೈರುವೇಟ್ ಸಂಪೂರ್ಣವಾಗಿ CO2, ನೀರು ಮತ್ತು ಶಕ್ತಿಯಾಗಿ ವಿಭಜನೆಯಾಗುವ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಮೈಟೊಕಾಂಡ್ರಿಯಾ", "ಕೋಶದ್ರವ್ಯ", "ಕ್ಲೋರೋಪ್ಲಾಸ್ಟ್", "ಗಾಲ್ಗಿ ಸಂಕೀರ್ಣ"),
            correctAnswer = "ಮೈಟೊಕಾಂಡ್ರಿಯಾ",
            explanation = "ಆಮ್ಲಜನಕದ ಉಪಸ್ಥಿತಿಯಲ್ಲಿ ನಡೆಯುವ ಕ್ರೆಬ್ಸ್ ಚಕ್ರವು ಜೀವಕೋಶದ ಶಕ್ತಿ ಕೇಂದ್ರವಾದ ಮೈಟೊಕಾಂಡ್ರಿಯಾದಲ್ಲಿ ನಡೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_8",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಶ್ವಾಸಕೋಶಗಳಲ್ಲಿ ಅನಿಲ ವಿನಿಮಯಕ್ಕಾಗಿ ವಿಶಾಲವಾದ ಮೇಲ್ಮೈಯನ್ನು ಒದಗಿಸುವ ಬಲೂನಿನಂತಹ ರಚನೆಗಳು ಯಾವುವು?",
            options = listOf("ಅಲ್ವಿಯೋಲೈಗಳು (ವಾಯುಕೋಶಗಳು)", "ಶ್ವಾಸನಾಳಗಳು", "ವಿಲ್ಲೈಗಳು", "ನೆಫ್ರಾನ್‌ಗಳು"),
            correctAnswer = "ಅಲ್ವಿಯೋಲೈಗಳು (ವಾಯುಕೋಶಗಳು)",
            explanation = "ಶ್ವಾಸಕೋಶಗಳ ತುದಿಯಲ್ಲಿರುವ ಅಲ್ವಿಯೋಲೈಗಳು (Alveoli) ರಕ್ತ ಮತ್ತು ಗಾಳಿಯ ನಡುವೆ O2 ಮತ್ತು CO2 ವಿನಿಮಯಕ್ಕೆ ನೆರವಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_9",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮಾನವನ ದೇಹದಲ್ಲಿ ಆಕ್ಸಿಜನ್ ಅನ್ನು ಶ್ವಾಸಕೋಶಗಳಿಂದ ದೇಹದ ವಿವಿಧ ಅಂಗಾಂಶಗಳಿಗೆ ಸಾಗಿಸುವ ಉಸಿರಾಟ ವರ್ಣಕ ಯಾವುದು?",
            options = listOf("ಹಿಮೋಗ್ಲೋಬಿನ್", "ಪ್ಲಾಸ್ಮಾ", "ಪ್ಲೇಟ್‌ಲೆಟ್‌ಗಳು", "ಬಿಳಿ ರಕ್ತಕಣಗಳು"),
            correctAnswer = "ಹಿಮೋಗ್ಲೋಬಿನ್",
            explanation = "ಕೆಂಪು ರಕ್ತಕಣಗಳಲ್ಲಿರುವ ಹಿಮೋಗ್ಲೋಬಿನ್ ಆಕ್ಸಿಜನ್‌ಗೆ ಹೆಚ್ಚಿನ ಆಕರ್ಷಣೆ ಹೊಂದಿದ್ದು ಆಕ್ಸಿಹಿಮೋಗ್ಲೋಬಿನ್ ರೂಪದಲ್ಲಿ ಸಾಗಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_10",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮಾನವನ ಹೃದಯದಲ್ಲಿ ಆಕ್ಸಿಜನ್‌ಯುಕ್ತ ಮತ್ತು ಆಕ್ಸಿಜನ್‌ರಹಿತ ರಕ್ತ ಬೆರೆಯದಂತೆ ತಡೆಯಲು ಎಷ್ಟು ಕೋಣೆಗಳಿವೆ?",
            options = listOf("4 ಕೋಣೆಗಳು", "2 ಕೋಣೆಗಳು", "3 ಕೋಣೆಗಳು", "1 ಕೋಣೆ"),
            correctAnswer = "4 ಕೋಣೆಗಳು",
            explanation = "ಮಾನವನ ಹೃದಯವು ಎರಡು ಹೃತ್ಕರ್ಣಗಳು ಮತ್ತು ಎರಡು ಹೃತ್ಕುಕ್ಷಿಗಳು ಸೇರಿ 4 ಕೋಣೆಗಳನ್ನು ಹೊಂದಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_11",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ರಕ್ತ ಹೆಪ್ಪುಗಟ್ಟುವಿಕೆಗೆ (Blood clotting) ಕಾರಣವಾಗುವ ರಕ್ತದ ಕಣಗಳು ಯಾವುವು?",
            options = listOf("ಪ್ಲೇಟ್‌ಲೆಟ್‌ಗಳು (ಕಿರುಬಿಲ್ಲೆಗಳು)", "ಕೆಂಪು ರಕ್ತಕಣಗಳು", "ಬಿಳಿ ರಕ್ತಕಣಗಳು", "ಪ್ಲಾಸ್ಮಾ"),
            correctAnswer = "ಪ್ಲೇಟ್‌ಲೆಟ್‌ಗಳು (ಕಿರುಬಿಲ್ಲೆಗಳು)",
            explanation = "ಗಾಯವಾದಾಗ ರಕ್ತ ಸೋರುವುದನ್ನು ತಡೆಯಲು ರಕ್ತ ಕಿರುಬಿಲ್ಲೆಗಳು (Platelets) ಹೆಪ್ಪುಗಟ್ಟುವಿಕೆಯನ್ನು ಉಂಟುಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_12",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳಲ್ಲಿ ಬೇರುಗಳಿಂದ ಎಲೆಗಳಿಗೆ ನೀರು ಮತ್ತು ಖನಿಜ ಲವಣಗಳನ್ನು ಸಾಗಿಸುವ ನಾಳೀಯ ಅಂಗಾಂಶ ಯಾವುದು?",
            options = listOf("ಕ್ಸೈಲಂ (Xylem)", "ಫ್ಲೋಯಂ (Phloem)", "ಪ್ಯಾರಂಕೈಮಾ", "ಕೊಲಂಕೈಮಾ"),
            correctAnswer = "ಕ್ಸೈಲಂ (Xylem)",
            explanation = "ಕ್ಸೈಲಂ ಅಂಗಾಂಶವು ನೀರು ಮತ್ತು ಕರಗಿದ ಖನಿಜಗಳನ್ನು ಮೇಲ್ಮುಖವಾಗಿ ಸಾಗಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_13",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳಲ್ಲಿ ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಯ ಆಹಾರ ಉತ್ಪನ್ನಗಳನ್ನು ಎಲೆಗಳಿಂದ ಇತರ ಭಾಗಗಳಿಗೆ ಸಾಗಿಸುವ ಕ್ರಿಯೆ ಮತ್ತು ಅಂಗಾಂಶ ಯಾವುದು?",
            options = listOf("ಸ್ಥಳಾಂತರ ಕ್ರಿಯೆ - ಫ್ಲೋಯಂ", "ಬಾಷ್ಪವಿಸರ್ಜನೆ - ಕ್ಸೈಲಂ", "ಆಸ್ಮಾಸಿಸ್ - ಪ್ಯಾರಂಕೈಮಾ", "ವಿಸರಣೆ - ಕ್ಲೋರೋಪ್ಲಾಸ್ಟ್"),
            correctAnswer = "ಸ್ಥಳಾಂತರ ಕ್ರಿಯೆ - ಫ್ಲೋಯಂ",
            explanation = "ಕರಗಿದ ಆಹಾರ ಪದಾರ್ಥಗಳನ್ನು ಸಸ್ಯದ ಎಲ್ಲಾ ಭಾಗಗಳಿಗೆ ಸಾಗಿಸುವ ಕ್ರಿಯೆಗೆ ಸ್ಥಳಾಂತರ (Translocation) ಎನ್ನುವರು, ಇದನ್ನು ಫ್ಲೋಯಂ ಅಂಗಾಂಶ ನಿರ್ವಹಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_14",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮಾನವನ ಮೂತ್ರಪಿಂಡದ ರಚನಾತ್ಮಕ ಮತ್ತು ಕಾರ್ಯಾತ್ಮಕ ಮೂಲ ಘಟಕ ಯಾವುದು?",
            options = listOf("ನೆಫ್ರಾನ್ (Nephron)", "ನ್ಯೂರಾನ್", "ಅಲ್ವಿಯೋಲೈ", "ವಿಲ್ಲೈ"),
            correctAnswer = "ನೆಫ್ರಾನ್ (Nephron)",
            explanation = "ಮೂತ್ರಪಿಂಡದಲ್ಲಿ ರಕ್ತವನ್ನು ಸೋಸಿ ಮೂತ್ರವನ್ನು ಉತ್ಪಾದಿಸುವ ಮೂಲ ಸೋಸುವಿಕೆ ಘಟಕವೇ ನೆಫ್ರಾನ್."
        ),
        QuestionModel(
            id = "s_10_sci_u6_15",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಪತ್ರರಂಧ್ರಗಳು (Stomata) ತೆರೆಯುವುದು ಮತ್ತು ಮುಚ್ಚುವುದನ್ನು ನಿಯಂತ್ರಿಸುವ ಕೋಶಗಳು ಯಾವುವು?",
            options = listOf("ಕಾವಲು ಕೋಶಗಳು (Guard cells)", "ಎಪಿಡರ್ಮಲ್ ಕೋಶಗಳು", "ಕ್ಸೈಲಂ ಕೋಶಗಳು", "ಕ್ಲೋರೋಫಿಲ್ ಕೋಶಗಳು"),
            correctAnswer = "ಕಾವಲು ಕೋಶಗಳು (Guard cells)",
            explanation = "ಕಾವಲು ಕೋಶಗಳು ನೀರನ್ನು ಹೀರಿಕೊಂಡು ಉಬ್ಬಿದಾಗ ರಂಧ್ರ ತೆರೆಯುತ್ತದೆ ಮತ್ತು ನೀರನ್ನು ಕಳೆದುಕೊಂಡು ಕುಗ್ಗಿದಾಗ ರಂಧ್ರ ಮುಚ್ಚುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u6_16",
            stdId = 10,
            subjectId = "science",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮೂತ್ರಪಿಂಡಗಳು ವಿಫಲವಾದ ರೋಗಿಗಳಲ್ಲಿ ಕೃತಕವಾಗಿ ರಕ್ತದಿಂದ ಸಾರಜನಕಯುಕ್ತ ತ್ಯಾಜ್ಯಗಳನ್ನು ತೆಗೆದುಹಾಕುವ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಹಿಮೋಡಯಾಲಿಸಿಸ್ (ಡಯಾಲಿಸಿಸ್)", "ಎಲೆಕ್ಟ್ರೋಪ್ಲೇಟಿಂಗ್", "ಆಂಜಿಯೋಗ್ರಾಮ್", "ಎಂಡೋಸ್ಕೋಪಿ"),
            correctAnswer = "ಹಿಮೋಡಯಾಲಿಸಿಸ್ (ಡಯಾಲಿಸಿಸ್)",
            explanation = "ಕೃತಕ ಮೂತ್ರಪಿಂಡ ಯಂತ್ರದ ಮೂಲಕ ರೋಗಿಯ ರಕ್ತವನ್ನು ಸೋಸಿ ಶುದ್ಧೀಕರಿಸುವ ವೈದ್ಯಕೀಯ ವಿಧಾನವೇ ಹಿಮೋಡಯಾಲಿಸಿಸ್."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 7: ನಿಯಂತ್ರಣ ಮತ್ತು ಸಹಭಾಗಿತ್ವ
    // ========================================================
    private val u7Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u7_1",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ನರಮಂಡಲದ ರಚನಾತ್ಮಕ ಮತ್ತು ಕಾರ್ಯಾತ್ಮಕ ಮೂಲ ಘಟಕ ಯಾವುದು?",
            options = listOf("ನ್ಯೂರಾನ್ (ನರಕೋಶ)", "ನೆಫ್ರಾನ್", "ಆಕ್ಸಾನ್", "ಡೆಂಡ್ರೈಟ್"),
            correctAnswer = "ನ್ಯೂರಾನ್ (ನರಕೋಶ)",
            explanation = "ಮಾನವನ ನರಮಂಡಲದ ಸಂಕೇತಗಳನ್ನು ಸ್ವೀಕರಿಸಿ ರವಾನಿಸುವ ಮೂಲ ಘಟಕವೇ ನ್ಯೂರಾನ್."
        ),
        QuestionModel(
            id = "s_10_sci_u7_2",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಎರಡು ನರಕೋಶಗಳ ನಡುವಿನ ಸೂಕ್ಷ್ಮ ಸಂಧಿಸ್ಥಳವನ್ನು (ಅಂತರ) ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸಿನಾಪ್ಸ್ (Synapse)", "ಆಕ್ಸಾನ್", "ಡೆಂಡ್ರೈಟ್", "ನೋಡ್"),
            correctAnswer = "ಸಿನಾಪ್ಸ್ (Synapse)",
            explanation = "ಒಂದು ನರಕೋಶದ ಅಂತ್ಯ ಮತ್ತು ಮುಂದಿನ ನರಕೋಶದ ಡೆಂಡ್ರೈಟ್ ನಡುವಿನ ಸೂಕ್ಷ್ಮ ಅಂತರಕ್ಕೆ ಸಿನಾಪ್ಸ್ ಎನ್ನುವರು; ಇಲ್ಲಿ ರಾಸಾಯನಿಕ ಸಂಕೇತ ರವಾನೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_3",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಬಿಸಿ ವಸ್ತುವನ್ನು ಮುಟ್ಟಿದಾಗ ತಕ್ಷಣ ಕೈಯನ್ನು ಹಿಂದಕ್ಕೆ ತೆಗೆದುಕೊಳ್ಳುವಂತಹ ಅಪ್ರಯತ್ನಪೂರ್ವಕ ಕ್ರಿಯೆಯನ್ನು ನಿಯಂತ್ರಿಸುವ ಕೇಂದ್ರ ಯಾವುದು?",
            options = listOf("ಮೆದುಳುಬಳ್ಳಿ (Spinal cord)", "ಮಹಾಮಸ್ತಿಷ್ಕ", "ಅನುಮಸ್ತಿಷ್ಕ", "ಕಣ್ಣು"),
            correctAnswer = "ಮೆದುಳುಬಳ್ಳಿ (Spinal cord)",
            explanation = "ಪರಾವರ್ತಿತ ಕ್ರಿಯೆಗಳನ್ನು (Reflex actions) ಮೆದುಳುಬಳ್ಳಿಯು ತಕ್ಷಣದ ಪ್ರತಿಕ್ರಿಯೆಗಾಗಿ ನಿಯಂತ್ರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_4",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ದೇಹದ ಭಂಗಿ ಮತ್ತು ಸಮತೋಲನವನ್ನು ಕಾಪಾಡುವ ಹಾಗೂ ನಿಖರವಾದ ಐಚ್ಛಿಕ ಚಲನೆಗಳನ್ನು ನಿಯಂತ್ರಿಸುವ ಮೆದುಳಿನ ಭಾಗ ಯಾವುದು?",
            options = listOf("ಅನುಮಸ್ತಿಷ್ಕ (Cerebellum)", "ಮಹಾಮಸ್ತಿಷ್ಕ (Cerebrum)", "ಮಜ್ಜಾಮುಖ (Medulla)", "ಪಾನ್ಸ್"),
            correctAnswer = "ಅನುಮಸ್ತಿಷ್ಕ (Cerebellum)",
            explanation = "ಹಿಮ್ಮೆದುಳಿನ ಭಾಗವಾದ ಅನುಮಸ್ತಿಷ್ಕವು ದೇಹದ ಭಂಗಿ, ಸಮತೋಲನ ಮತ್ತು ಸ್ನಾಯುಗಳ ಹೊಂದಾಣಿಕೆಯನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_5",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಕ್ತದೊತ್ತಡ, ಲಾಲಾರಸ ಸ್ರವಿಕೆ ಮತ್ತು ವಾಂತಿ ಮುಂತಾದ ಅನೈಚ್ಛಿಕ ಕ್ರಿಯೆಗಳನ್ನು ನಿಯಂತ್ರಿಸುವ ಮೆದುಳಿನ ಭಾಗ ಯಾವುದು?",
            options = listOf("ಮಜ್ಜಾಮುಖ (Medulla)", "ಮಹಾಮಸ್ತಿಷ್ಕ", "ಅನುಮಸ್ತಿಷ್ಕ", "ಹೈಪೋಥಲಮಸ್"),
            correctAnswer = "ಮಜ್ಜಾಮುಖ (Medulla)",
            explanation = "ಹಿಮ್ಮೆದುಳಿನಲ್ಲಿರುವ ಮಜ್ಜಾಮುಖವು ಹೃದಯ ಬಡಿತ, ರಕ್ತದೊತ್ತಡ, ವಾಂತಿ ಮುಂತಾದ ಜೀವಾಧಾರ ಅನೈಚ್ಛಿಕ ಕ್ರಿಯೆಗಳನ್ನು ನಿಯಂತ್ರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_6",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳಲ್ಲಿ ಕೋಶ ವಿಭಜನೆಯನ್ನು ತೀವ್ರವಾಗಿ ಪ್ರಚೋದಿಸುವ ಸಸ್ಯ ಹಾರ್ಮೋನ್ ಯಾವುದು?",
            options = listOf("ಸೈಟೋಕೈನಿನ್ (Cytokinin)", "ಆಕ್ಸಿನ್", "ಜಿಬ್ಬರೆಲ್ಲಿನ್", "ಅಬ್ಸಿಸಿಕ್ ಆಮ್ಲ"),
            correctAnswer = "ಸೈಟೋಕೈನಿನ್ (Cytokinin)",
            explanation = "ಸೈಟೋಕೈನಿನ್‌ಗಳು ಹಣ್ಣು ಮತ್ತು ಬೀಜಗಳಂತಹ ಕೋಶ ವಿಭಜನೆ ವೇಗವಾಗಿ ನಡೆಯುವ ಭಾಗಗಳಲ್ಲಿ ಕಂಡುಬರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_7",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳ ಕಾಂಡದ ತುದಿಯು ಬೆಳಕಿನ ಕಡೆಗೆ ಬಾಗಲು ಕಾರಣವಾಗುವ ಸಸ್ಯ ಹಾರ್ಮೋನ್ ಯಾವುದು?",
            options = listOf("ಆಕ್ಸಿನ್ (Auxin)", "ಅಬ್ಸಿಸಿಕ್ ಆಮ್ಲ", "ಎಥಿಲಿನ್", "ಇನ್ಸುಲಿನ್"),
            correctAnswer = "ಆಕ್ಸಿನ್ (Auxin)",
            explanation = "ಆಕ್ಸಿನ್ ಹಾರ್ಮೋನ್ ನೆರಳಿನ ಭಾಗದಲ್ಲಿ ಶೇಖರಣೆಗೊಂಡು ಕೋಶಗಳ ಬೆಳವಣಿಗೆಯನ್ನು ಹೆಚ್ಚಿಸುವುದರಿಂದ ಸಸ್ಯದ ತುದಿ ಬೆಳಕಿನ ಕಡೆಗೆ ಬಾಗುತ್ತದೆ (ದ್ಯುತ್ಯನುವರ್ತನೆ)."
        ),
        QuestionModel(
            id = "s_10_sci_u7_8",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಸಸ್ಯಗಳಲ್ಲಿ ಬೆಳವಣಿಗೆಯನ್ನು ಪ್ರತಿಬಂಧಿಸುವ ಮತ್ತು ಎಲೆಗಳು ಉದುರಲು ಕಾರಣವಾಗುವ ಹಾರ್ಮೋನ್ ಯಾವುದು?",
            options = listOf("ಅಬ್ಸಿಸಿಕ್ ಆಮ್ಲ (Abscisic acid)", "ಆಕ್ಸಿನ್", "ಜಿಬ್ಬರೆಲ್ಲಿನ್", "ಸೈಟೋಕೈನಿನ್"),
            correctAnswer = "ಅಬ್ಸಿಸಿಕ್ ಆಮ್ಲ (Abscisic acid)",
            explanation = "ಅಬ್ಸಿಸಿಕ್ ಆಮ್ಲವು ಬೆಳವಣಿಗೆಯನ್ನು ಪ್ರತಿಬಂಧಿಸುವ ಹಾರ್ಮೋನ್ ಆಗಿದ್ದು ಎಲೆಗಳು ಬಾಡಿ ಉದುರಲು ಪ್ರೇರೇಪಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_9",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ರಕ್ತದಲ್ಲಿ ಗ್ಲೂಕೋಸ್ ಮಟ್ಟವನ್ನು ನಿಯಂತ್ರಿಸುವ ಹಾರ್ಮೋನ್ ಯಾವುದು ಮತ್ತು ಅದನ್ನು ಸ್ರವಿಸುವ ಗ್ರಂಥಿ ಯಾವುದು?",
            options = listOf("ಇನ್ಸುಲಿನ್ - ಮೇದೋಜೀರಕ ಗ್ರಂಥಿ (Pancreas)", "ಥೈರಾಕ್ಸಿನ್ - ಥೈರಾಯ್ಡ್ ಗ್ರಂಥಿ", "ಅಡ್ರಿನಲಿನ್ - ಅಡ್ರಿನಲ್ ಗ್ರಂಥಿ", "ಬೆಳವಣಿಗೆ ಹಾರ್ಮೋನ್ - ಪಿಟ್ಯುಟರಿ"),
            correctAnswer = "ಇನ್ಸುಲಿನ್ - ಮೇದೋಜೀರಕ ಗ್ರಂಥಿ (Pancreas)",
            explanation = "ಮೇದೋಜೀರಕ ಗ್ರಂಥಿಯು ಇನ್ಸುಲಿನ್ ಸ್ರವಿಸುತ್ತದೆ. ಇದರ ಕೊರತೆಯಿಂದ ಮಧುಮೇಹ (Diabetes) ರೋಗ ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_10",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಭಯ ಅಥವಾ ತುರ್ತು ಸಂದರ್ಭದಲ್ಲಿ ದೇಹವನ್ನು ಸನ್ನದ್ಧಗೊಳಿಸುವ 'ತುರ್ತು ಪರಿಸ್ಥಿತಿ ಹಾರ್ಮೋನ್' ಯಾವುದು?",
            options = listOf("ಅಡ್ರಿನಲಿನ್ (Adrenaline)", "ಇನ್ಸುಲಿನ್", "ಈಸ್ಟ್ರೋಜನ್", "ಥೈರಾಕ್ಸಿನ್"),
            correctAnswer = "ಅಡ್ರಿನಲಿನ್ (Adrenaline)",
            explanation = "ಅಡ್ರಿನಲ್ ಗ್ರಂಥಿಯಿಂದ ಸ್ರವಿಸಲ್ಪಡುವ ಅಡ್ರಿನಲಿನ್ ಹೃದಯ ಬಡಿತ ಮತ್ತು ರಕ್ತ ಪರಿಚಲನೆಯನ್ನು ಹೆಚ್ಚಿಸಿ ದೇಹವನ್ನು ತುರ್ತು ಸವಾಲಿಗೆ ಸಜ್ಜುಗೊಳಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_11",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಥೈರಾಕ್ಸಿನ್ ಹಾರ್ಮೋನ್‌ನ ಸಂಶ್ಲೇಷಣೆಗೆ ಆಹಾರದಲ್ಲಿ ಯಾವ ಪೋಷಕಾಂಶವು ಅತ್ಯಗತ್ಯವಾಗಿದೆ?",
            options = listOf("ಅಯೋಡಿನ್ (Iodine)", "ಕಬ್ಬಿಣ", "ಕ್ಯಾಲ್ಸಿಯಂ", "ರಂಜಕ"),
            correctAnswer = "ಅಯೋಡಿನ್ (Iodine)",
            explanation = "ಥೈರಾಯ್ಡ್ ಗ್ರಂಥಿಯು ಥೈರಾಕ್ಸಿನ್ ಉತ್ಪಾದಿಸಲು ಅಯೋಡಿನ್ ಅಗತ್ಯ. ಇದರ ಕೊರತೆಯಿಂದ ಕುತ್ತಿಗೆ ಊದಿಕೊಳ್ಳುವ ಗಳಗಂಡ (Goitre) ರೋಗ ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_12",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಪರಾಗರೇಣು ಅಂಡಾಶಯದ ಕಡೆಗೆ ಪರಾಗನಳವನ್ನು ಬೆಳೆಸುವುದು ಯಾವ ವಿಧದ ಚಲನೆಗೆ ಉದಾಹರಣೆಯಾಗಿದೆ?",
            options = listOf("ರಾಸಾಯನಿಕಾನುವರ್ತನೆ (Chemotropism)", "ದ್ಯುತ್ಯನುವರ್ತನೆ", "ಗುರುತ್ವಾನುವರ್ತನೆ", "ಜಲಾನುವರ್ತನೆ"),
            correctAnswer = "ರಾಸಾಯನಿಕಾನುವರ್ತನೆ (Chemotropism)",
            explanation = "ಶಲಾಕಾಗ್ರದಿಂದ ಸ್ರವಿಸಲ್ಪಡುವ ರಾಸಾಯನಿಕಗಳಿಗೆ ಪ್ರತಿಕ್ರಿಯೆಯಾಗಿ ಪರಾಗನಳವು ಬೆಳೆಯುವುದರಿಂದ ಇದು ರಾಸಾಯನಿಕಾನುವರ್ತನೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_13",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಮುಟ್ಟಿದರೆ ಮುನಿ (Touch-me-not / Mimosa pudica) ಗಿಡದ ಎಲೆಗಳನ್ನು ಮುಟ್ಟಿದಾಗ ಮುದುಡಿಕೊಳ್ಳಲು ಕಾರಣವೇನು?",
            options = listOf("ಎಲೆಗಳ ಬುಡದಲ್ಲಿ ನೀರಿನ ಪ್ರಮಾಣದ ಬದಲಾವಣೆಯಿಂದ ಕೋಶಗಳ ಆಕಾರ ಬದಲಾಗುವುದು", "ದ್ಯುತ್ಯನುವರ್ತನೆ", "ರಾಸಾಯನಿಕಗಳ ಸ್ರವಿಕೆ", "ಸೂರ್ಯನ ಬೆಳಕಿನ ಕೊರತೆ"),
            correctAnswer = "ಎಲೆಗಳ ಬುಡದಲ್ಲಿ ನೀರಿನ ಪ್ರಮಾಣದ ಬದಲಾವಣೆಯಿಂದ ಕೋಶಗಳ ಆಕಾರ ಬದಲಾಗುವುದು",
            explanation = "ಕೋಶಗಳಲ್ಲಿನ ನೀರಿನ ಅಂಶ ಬದಲಾಗುವುದರಿಂದ ಕೋಶಗಳು ಊದಿಕೊಳ್ಳುತ್ತವೆ ಅಥವಾ ಕುಗ್ಗುತ್ತವೆ, ಇದರಿಂದ ಎಲೆ ಮುದುಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_14",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಮೆದುಳಿನ ಯಾವ ಭಾಗವು ಆಲೋಚನೆ, ಸ್ಮರಣಶಕ್ತಿ ಮತ್ತು ಕಲಿಕೆಯ ಮುಖ್ಯ ಕೇಂದ್ರವಾಗಿದೆ?",
            options = listOf("ಮಹಾಮಸ್ತಿಷ್ಕ (Cerebrum)", "ಅನುಮಸ್ತಿಷ್ಕ", "ಮಜ್ಜಾಮುಖ", "ಹೈಪೋಥಲಮಸ್"),
            correctAnswer = "ಮಹಾಮಸ್ತಿಷ್ಕ (Cerebrum)",
            explanation = "ಮುಮ್ಮೆದುಳಿನ ಮುಖ್ಯ ಭಾಗವಾದ ಮಹಾಮಸ್ತಿಷ್ಕವು ಜ್ಞಾನ, ಸ್ಮರಣಶಕ್ತಿ ಮತ್ತು ತಾರ್ಕಿಕ ಆಲೋಚನೆಗಳ ಕೇಂದ್ರವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u7_15",
            stdId = 10,
            subjectId = "science",
            unitId = 7,
            type = "MCQ",
            questionText = "ಪುರುಷರಲ್ಲಿ ಪ್ರೌಢಾವಸ್ಥೆಯ ಲಕ್ಷಣಗಳನ್ನು ಮತ್ತು ಶುಕ್ರಾಣು ಉತ್ಪಾದನೆಯನ್ನು ನಿಯಂತ್ರಿಸುವ ಹಾರ್ಮೋನ್ ಯಾವುದು?",
            options = listOf("ಟೆಸ್ಟೋಸ್ಟೆರಾನ್ (Testosterone)", "ಈಸ್ಟ್ರೋಜನ್", "ಪ್ರೊಜೆಸ್ಟೆರಾನ್", "ಇನ್ಸುಲಿನ್"),
            correctAnswer = "ಟೆಸ್ಟೋಸ್ಟೆರಾನ್ (Testosterone)",
            explanation = "ವೃಷಣಗಳಿಂದ ಸ್ರವಿಸಲ್ಪಡುವ ಟೆಸ್ಟೋಸ್ಟೆರಾನ್ ಪುರುಷ ಲೈಂಗಿಕ ಹಾರ್ಮೋನ್ ಆಗಿದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 8: ಜೀವಿಗಳು ಹೇಗೆ ಸಂತಾನೋತ್ಪತ್ತಿ ನಡೆಸುತ್ತವೆ?
    // ========================================================
    private val u8Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u8_1",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಅಮೀಬಾದಲ್ಲಿ ನಡೆಯುವ ನಿರ್ಲಿಂಗ ಸಂತಾನೋತ್ಪತ್ತಿ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ದ್ವಿವಿದಳನ (Binary fission)", "ಮೊಗ್ಗುವಿಕೆ", "ಬಹು ವಿದಳನ", "ಪುನರುತ್ಪತ್ತಿ"),
            correctAnswer = "ದ್ವಿವಿದಳನ (Binary fission)",
            explanation = "ಅಮೀಬಾದಲ್ಲಿ ಒಂದು ಕೋಶವು ಎರಡು ಸಮಾನ ಪುತ್ರಿಕೋಶಗಳಾಗಿ ವಿಭಜನೆಗೊಳ್ಳುವ ದ್ವಿವಿದಳನ ನಡೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_2",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಹೈಡ್ರಾ ಮತ್ತು ಈಸ್ಟ್‌ಗಳಲ್ಲಿ ಹೊಸ ಜೀವಿಯು ಹೊರಬೆಳವಣಿಗೆಯಿಂದ ವೃದ್ಧಿಯಾಗುವ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಮೊಗ್ಗುವಿಕೆ (Budding)", "ತುಂಡಾಗುವಿಕೆ", "ದ್ವಿವಿದಳನ", "ಬೀಜಕ ರಚನೆ"),
            correctAnswer = "ಮೊಗ್ಗುವಿಕೆ (Budding)",
            explanation = "ಪೋಷಕ ಜೀವಿಯ ದೇಹದ ಮೇಲೆ ಮೊಗ್ಗು (Bud) ಬೆಳೆದು ಪ್ರತ್ಯೇಕ ಜೀವಿಯಾಗಿ ಮಾರ್ಪಡುವ ವಿಧಾನವೇ ಮೊಗ್ಗುವಿಕೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_3",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಪ್ಲನೇರಿಯಾ ಜೀವಿಯ ದೇಹವು ಆಕಸ್ಮಿಕವಾಗಿ ತುಂಡಾದಾಗ ಪ್ರತಿ ತುಂಡು ಸಂಪೂರ್ಣ ಜೀವಿಯಾಗಿ ಬೆಳೆಯುವ ಸಾಮರ್ಥ್ಯಕ್ಕೆ ಏನೆನ್ನುವರು?",
            options = listOf("ಪುನರುತ್ಪತ್ತಿ (Regeneration)", "ತುಂಡಾಗುವಿಕೆ", "ಮೊಗ್ಗುವಿಕೆ", "ಬೀಜಕ ರಚನೆ"),
            correctAnswer = "ಪುನರುತ್ಪತ್ತಿ (Regeneration)",
            explanation = "ಪ್ಲನೇರಿಯಾ ಮತ್ತು ಹೈಡ್ರಾಗಳಲ್ಲಿ ದೇಹದ ತುಂಡುಗಳು ಸಂಪೂರ್ಣ ಜೀವಿಯಾಗಿ ಮರುಹುಟ್ಟು ಪಡೆಯುವ ವಿಧಾನ ಪುನರುತ್ಪತ್ತಿ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_4",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಬ್ರಯೋಫಿಲ್ಲಮ್ (ಕಾಡುಬಸಳೆ) ಸಸ್ಯದಲ್ಲಿ ಕಾಯಜ ಸಂತಾನೋತ್ಪತ್ತಿ ಎಲ್ಲಿ ನಡೆಯುತ್ತದೆ?",
            options = listOf("ಎಲೆಯ ಅಂಚಿನಲ್ಲಿರುವ ಮೊಗ್ಗುಗಳಿಂದ", "ಕಾಂಡದಿಂದ", "ಬೇರುಗಳಿಂದ", "ಹೂವಿನಿಂದ"),
            correctAnswer = "ಎಲೆಯ ಅಂಚಿನಲ್ಲಿರುವ ಮೊಗ್ಗುಗಳಿಂದ",
            explanation = "ಬ್ರಯೋಫಿಲ್ಲಮ್‌ನ ಎಲೆಯ ಅಂಚಿನ ಕಚ್ಚುಗಳಲ್ಲಿರುವ ಮೊಗ್ಗುಗಳು ಮಣ್ಣಿಗೆ ಬಿದ್ದಾಗ ಹೊಸ ಗಿಡಗಳಾಗಿ ಬೆಳೆಯುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_5",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಹೂವಿನಲ್ಲಿ ಪರಾಗರೇಣುಗಳು ಉತ್ಪತ್ತಿಯಾಗುವ ಗಂಡು ಸಂತಾನೋತ್ಪತ್ತಿ ಭಾಗ ಯಾವುದು?",
            options = listOf("ಪರಾಗಕೋಶ (Anther)", "ಶಲಾಕಾಗ್ರ", "ಅಂಡಾಶಯ", "ದಳ"),
            correctAnswer = "ಪರಾಗಕೋಶ (Anther)",
            explanation = "ಕೇಸರದ ತುದಿಯಲ್ಲಿರುವ ಪರಾಗಕೋಶದಲ್ಲಿ ಹಳದಿ ಬಣ್ಣದ ಪರಾಗರೇಣುಗಳು ಉತ್ಪತ್ತಿಯಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_6",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಹೂವಿನ ಹೆಣ್ಣು ಸಂತಾನೋತ್ಪತ್ತಿ ಅಂಗವಾದ ಶಲಾಕೆಯ (Carpel) ಮೂರು ಪ್ರಮುಖ ಭಾಗಗಳು ಯಾವುವು?",
            options = listOf("ಶಲಾಕಾಗ್ರ, ಶಲಾಕಾನಳ ಮತ್ತು ಅಂಡಾಶಯ", "ಪರಾಗಕೋಶ, ಕೇಸರದಂಡ ಮತ್ತು ದಳ", "ಪುಷ್ಪಪಾತ್ರೆ, ಪುಷ್ಪದಳ ಮತ್ತು ತೊಟ್ಟು", "ಅಂಡಾಣು, ಶುಕ್ರಾಣು ಮತ್ತು ಜರಾಯು"),
            correctAnswer = "ಶಲಾಕಾಗ್ರ, ಶಲಾಕಾನಳ ಮತ್ತು ಅಂಡಾಶಯ",
            explanation = "ಶಲಾಕೆಯು ತುದಿಯ ಜಿಗುಟಾದ ಶಲಾಕಾಗ್ರ, ಮಧ್ಯದ ಕೊಳವೆಯಂತಹ ಶಲಾಕಾನಳ ಮತ್ತು ಕೆಳಭಾಗದ ಉಬ್ಬಿದ ಅಂಡಾಶಯವನ್ನು ಹೊಂದಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_7",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಫಲೀಕರಣದ ನಂತರ ಹೂವಿನ ಅಂಡಾಶಯವು ಏನಾಗಿ ಮಾರ್ಪಡುತ್ತದೆ?",
            options = listOf("ಹಣ್ಣು", "ಬೀಜ", "ಹೂವು", "ಎಲೆ"),
            correctAnswer = "ಹಣ್ಣು",
            explanation = "ಫಲೀಕರಣದ ನಂತರ ಅಂಡಗಳು ಬೀಜಗಳಾಗಿಯೂ ಮತ್ತು ಸಂಪೂರ್ಣ ಅಂಡಾಶಯವು ಹಣ್ಣಾಗಿಯೂ ಬೆಳೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_8",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಪುರುಷರಲ್ಲಿ ಶುಕ್ರಾಣುಗಳು ಉತ್ಪತ್ತಿಯಾಗಲು ದೇಹದ ಉಷ್ಣತೆಗಿಂತ ಕಡಿಮೆ ಉಷ್ಣತೆ ಬೇಕಾಗಿರುವುದರಿಂದ ವೃಷಣಗಳು ಎಲ್ಲಿರುತ್ತವೆ?",
            options = listOf("ವೃಷಣ ಚೀಲದಲ್ಲಿ (Scrotum)", "ಹೊಟ್ಟೆಯ ಕುಳಿಯಲ್ಲಿ", "ಮೂತ್ರಕೋಶದಲ್ಲಿ", "ವಿಸರ್ಜನಾ ನಾಳದಲ್ಲಿ"),
            correctAnswer = "ವೃಷಣ ಚೀಲದಲ್ಲಿ (Scrotum)",
            explanation = "ಶುಕ್ರಾಣು ಜನನಕ್ಕೆ ದೇಹದ ಸಹಜ ತಾಪಮಾನಕ್ಕಿಂತ 2-3°C ಕಡಿಮೆ ತಾಪ ಬೇಕಾಗಿರುವುದರಿಂದ ವೃಷಣಗಳು ವೃಷಣ ಚೀಲದಲ್ಲಿ ಸ್ಥಿತವಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_9",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ತಾಯಿಯ ಗರ್ಭಕೋಶದಲ್ಲಿ ಬೆಳೆಯುತ್ತಿರುವ ಭ್ರೂಣಕ್ಕೆ ರಕ್ತದ ಮೂಲಕ ಆಕ್ಸಿಜನ್ ಮತ್ತು ಗ್ಲೂಕೋಸ್ ಒದಗಿಸುವ ವಿಶೇಷ ಅಂಗಾಂಶ ಯಾವುದು?",
            options = listOf("ಜರಾಯು (Placenta)", "ಫಾಲೋಪಿಯನ್ ನಳಿಕೆ", "ಅಂಡಾಶಯ", "ಗರ್ಭಕಂಠ"),
            correctAnswer = "ಜರಾಯು (Placenta)",
            explanation = "ಜರಾಯು ತಾಯಿಯ ರಕ್ತ ಮತ್ತು ಭ್ರೂಣದ ನಡುವೆ ಪೋಷಕಾಂಶ ಮತ್ತು ಆಕ್ಸಿಜನ್ ವಿನಿಮಯಕ್ಕೆ ನೆರವಾಗುವ ಬಿಲ್ಲೆಯಾಕಾರದ ಅಂಗಾಂಶವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_10",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಸ್ತ್ರೀಯರಲ್ಲಿ ಪ್ರತಿ ತಿಂಗಳು ಬಿಡುಗಡೆಯಾದ ಅಂಡಾಣು ಫಲೀಕರಣಗೊಳ್ಳದಿದ್ದಾಗ ಗರ್ಭಕೋಶದ ಒಳಪದರ ಕಳಚಿ ರಕ್ತದೊಂದಿಗೆ ಹೊರಬರುವುದನ್ನು ಏನೆನ್ನುವರು?",
            options = listOf("ಋತುಚಕ್ರ (ಋತುಸ್ರಾವ)", "ಅಂಡೋತ್ಪತ್ತಿ", "ಗರ್ಭಧಾರಣೆ", "ಸ್ಥಾಪನೆ"),
            correctAnswer = "ಋತುಚಕ್ರ (ಋತುಸ್ರಾವ)",
            explanation = "ಫಲೀಕರಣವಾಗದ ಅಂಡಾಣು ಮತ್ತು ರಕ್ತನಾಳಗಳಿಂದ ಕೂಡಿದ ಗರ್ಭಕೋಶದ ದಪ್ಪ ಭಿತ್ತಿ ಕಳಚಿ ಹೊರಹೋಗುವುದೇ ಋತುಚಕ್ರ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_11",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಬ್ಯಾಕ್ಟೀರಿಯಾಗಳಿಂದ ಹರಡುವ ಲೈಂಗಿಕ ಸಂಪರ್ಕದ ರೋಗಗಳು (STDs) ಯಾವುವು?",
            options = listOf("ಗೊನೊರಿಯಾ ಮತ್ತು ಸಿಫಿಲಿಸ್", "ಏಡ್ಸ್ ಮತ್ತು ಜನನಾಂಗದ ಮಚ್ಚೆಗಳು", "ಮಲೇರಿಯಾ ಮತ್ತು ಟೈಫಾಯಿಡ್", "ಕಾಮಾಲೆ ಮತ್ತು ಕ್ಷಯ"),
            correctAnswer = "ಗೊನೊರಿಯಾ ಮತ್ತು ಸಿಫಿಲಿಸ್",
            explanation = "ಗೊನೊರಿಯಾ ಮತ್ತು ಸಿಫಿಲಿಸ್ ಬ್ಯಾಕ್ಟೀರಿಯಾದಿಂದ ಹರಡುವ ಲೈಂಗಿಕ ರೋಗಗಳು; ಏಡ್ಸ್ ಮತ್ತು ಮಚ್ಚೆಗಳು ವೈರಸ್‌ನಿಂದ ಹರಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_12",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಪುರುಷರಲ್ಲಿ ಸಂತಾನೋತ್ಪತ್ತಿ ನಿಯಂತ್ರಣಕ್ಕಾಗಿ ಶುಕ್ರನಾಳವನ್ನು ಕತ್ತರಿಸಿ ಕಟ್ಟಿಹಾಕುವ ಶಸ್ತ್ರಚಿಕಿತ್ಸಾ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ವ್ಯಾಸೆಕ್ಟಮಿ (Vasectomy)", "ಟ್ಯೂಬೆಕ್ಟಮಿ (Tubectomy)", "ಕಾಪರ್-ಟಿ", "ಗರ್ಭನಿರೋಧಕ ಮಾತ್ರೆಗಳು"),
            correctAnswer = "ವ್ಯಾಸೆಕ್ಟಮಿ (Vasectomy)",
            explanation = "ಶುಕ್ರಾಣು ಸಾಗಣೆಯನ್ನು ತಡೆಯಲು ಶುಕ್ರನಾಳವನ್ನು ಕತ್ತರಿಸಿ ಕಟ್ಟುವುದೇ ವ್ಯಾಸೆಕ್ಟಮಿ; ಮಹಿಳೆಯರಲ್ಲಿ ಅಂಡನಾಳ ಕಟ್ಟುವುದು ಟ್ಯೂಬೆಕ್ಟಮಿ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_13",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಮಹಿಳೆಯರ ಗರ್ಭಕೋಶದಲ್ಲಿ ಅಳವಡಿಸುವ ಭ್ರೂಣ ಸ್ಥಾಪನೆಯನ್ನು ತಡೆಯುವ ಗರ್ಭನಿರೋಧಕ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಕಾಪರ್-ಟಿ (Copper-T)", "ಕಾಂಡೋಮ್", "ಮಾತ್ರೆಗಳು", "ವ್ಯಾಸೆಕ್ಟಮಿ"),
            correctAnswer = "ಕಾಪರ್-ಟಿ (Copper-T)",
            explanation = "ಕಾಪರ್-ಟಿಯು ಗರ್ಭಕೋಶದಲ್ಲಿ ಅಳವಡಿಸುವ ಆಂತರಿಕ ಗರ್ಭನಿರೋಧಕ ಸಾಧನವಾಗಿದೆ (IUD)."
        ),
        QuestionModel(
            id = "s_10_sci_u8_14",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ಮಾನವರಲ್ಲಿ ನಿಖರವಾಗಿ ಅಂಡಾಣು ಮತ್ತು ಶುಕ್ರಾಣುಗಳ ಫಲೀಕರಣ ನಡೆಯುವ ಸ್ಥಳ ಯಾವುದು?",
            options = listOf("ಅಂಡನಾಳ (ಫಾಲೋಪಿಯನ್ ಟ್ಯೂಬ್)", "ಗರ್ಭಕೋಶ", "ಅಂಡಾಶಯ", "ಯೋನಿ"),
            correctAnswer = "ಅಂಡನಾಳ (ಫಾಲೋಪಿಯನ್ ಟ್ಯೂಬ್)",
            explanation = "ಅಂಡಾಣು ಮತ್ತು ಶುಕ್ರಾಣುವಿನ ಸಮ್ಮಿಲನವು ಅಂಡನಾಳದ (ಫಾಲೋಪಿಯನ್ ನಳಿಕೆ) ಒಳಗಡೆ ನಡೆಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u8_15",
            stdId = 10,
            subjectId = "science",
            unitId = 8,
            type = "MCQ",
            questionText = "ರೈಜೋಪಸ್ (ಬ್ರೆಡ್ ಮೋಲ್ಡ್) ಶಿಲೀಂಧ್ರದಲ್ಲಿ ಸಂತಾನೋತ್ಪತ್ತಿಯು ಯಾವುದರ ಮೂಲಕ ನಡೆಯುತ್ತದೆ?",
            options = listOf("ಬೀಜಕಗಳು (Spores)", "ದ್ವಿವಿದಳನ", "ಪುನರುತ್ಪತ್ತಿ", "ಮೊಗ್ಗುವಿಕೆ"),
            correctAnswer = "ಬೀಜಕಗಳು (Spores)",
            explanation = "ಬ್ರೆಡ್ ಬೂಸ್ಟಿನಲ್ಲಿರುವ ಬೀಜಕಪಾತ್ರೆಗಳಲ್ಲಿ ಹಗುರವಾದ ಸೂಕ್ಷ್ಮ ಬೀಜಕಗಳು ಉತ್ಪತ್ತಿಯಾಗಿ ಗಾಳಿಯ ಮೂಲಕ ಪ್ರಸಾರವಾಗುತ್ತವೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 9: ಅನುವಂಶೀಯತೆ ಮತ್ತು ಜೀವ ವಿಕಾಸ
    // ========================================================
    private val u9Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u9_1",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಅನುವಂಶೀಯತೆಯ ಪಿತಾಮಹ (Father of Genetics) ಎಂದು ಯಾರನ್ನು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಗ್ರೆಗರ್ ಜೋಹಾನ್ ಮೆಂಡೆಲ್", "ಚಾರ್ಲ್ಸ್ ಡಾರ್ವಿನ್", "ಜೆ. ಬಿ. ಎಸ್. ಹಾಲ್ಡೇನ್", "ಲ್ಯಾಮಾರ್ಕ್"),
            correctAnswer = "ಗ್ರೆಗರ್ ಜೋಹಾನ್ ಮೆಂಡೆಲ್",
            explanation = "ಬಟಾಣಿ ಗಿಡಗಳ ಮೇಲೆ ಸಂಕರಣ ಪ್ರಯೋಗಗಳನ್ನು ನಡೆಸಿ ಅನುವಂಶೀಯತೆಯ ನಿಯಮಗಳನ್ನು ರೂಪಿಸಿದ ಮೆಂಡೆಲ್‌ರನ್ನು ಅನುವಂಶೀಯತೆಯ ಪಿತಾಮಹ ಎನ್ನುವರು."
        ),
        QuestionModel(
            id = "s_10_sci_u9_2",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮೆಂಡೆಲ್‌ರ ಏಕತಳಿ ಸಂಕರಣದ (Monohybrid cross) F2 ಪೀಳಿಗೆಯ ಬಾಹ್ಯಲಕ್ಷಣ (Phenotype) ಅನುಪಾತ ಎಷ್ಟು?",
            options = listOf("3:1", "1:2:1", "9:3:3:1", "2:1"),
            correctAnswer = "3:1",
            explanation = "F2 ಪೀಳಿಗೆಯಲ್ಲಿ 3 ಎತ್ತರದ ಗಿಡಗಳು ಮತ್ತು 1 ಗಿಡ್ಡ ಗಿಡ ಉಂಟಾಗುವುದರಿಂದ ಫಿನೋಟೈಪ್ ಅನುಪಾತ 3:1."
        ),
        QuestionModel(
            id = "s_10_sci_u9_3",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮೆಂಡೆಲ್‌ರ ಏಕತಳಿ ಸಂಕರಣದ F2 ಪೀಳಿಗೆಯ ವಂಶವಾಹಿ (Genotype) ಅನುಪಾತ ಎಷ್ಟು?",
            options = listOf("1:2:1", "3:1", "9:3:3:1", "1:1"),
            correctAnswer = "1:2:1",
            explanation = "ವಂಶವಾಹಿ ಅನುಪಾತವು 1 TT (ಶುದ್ಧ ಎತ್ತರ) : 2 Tt (ಮಿಶ್ರ ಎತ್ತರ) : 1 tt (ಶುದ್ಧ ಗಿಡ್ಡ) = 1:2:1 ಆಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u9_4",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮೆಂಡೆಲ್‌ರ ದ್ವಿತಳಿ ಸಂಕರಣದ (Dihybrid cross) F2 ಪೀಳಿಗೆಯ ಫಿನೋಟೈಪ್ ಅನುಪಾತ ಯಾವುದು?",
            options = listOf("9:3:3:1", "3:1", "1:2:1", "9:1:1:3"),
            correctAnswer = "9:3:3:1",
            explanation = "ಎರಡು ಲಕ್ಷಣಗಳನ್ನು ಪರಿಗಣಿಸಿದ ದ್ವಿತಳಿ ಸಂಕರಣದ F2 ಪೀಳಿಗೆಯಲ್ಲಿ 9:3:3:1 ಅನುಪಾತವು ಕಂಡುಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u9_5",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮಾನವನ ಜೀವಕೋಶದಲ್ಲಿರುವ ಒಟ್ಟು ಕ್ರೋಮೋಸೋಮ್‌ಗಳ (ವರ್ಣತಂತುಗಳ) ಜೋಡಿಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("23 ಜೋಡಿಗಳು (46)", "22 ಜೋಡಿಗಳು", "24 ಜೋಡಿಗಳು", "46 ಜೋಡಿಗಳು"),
            correctAnswer = "23 ಜೋಡಿಗಳು (46)",
            explanation = "ಮಾನವನಲ್ಲಿ 22 ಜೋಡಿ ಆಟೋಸೋಮ್‌ಗಳು ಮತ್ತು 1 ಜೋಡಿ ಲೈಂಗಿಕ ವರ್ಣತಂತುಗಳು ಸೇರಿ ಒಟ್ಟು 23 ಜೋಡಿ (46) ಕ್ರೋಮೋಸೋಮ್‌ಗಳಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u9_6",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮಾನವ ಪುರುಷ ಮತ್ತು ಸ್ತ್ರೀಯರಲ್ಲಿರುವ ಲೈಂಗಿಕ ವರ್ಣತಂತುಗಳ ಜೋಡಿಗಳು ಅನುಕ್ರಮವಾಗಿ ಯಾವುವು?",
            options = listOf("XY ಮತ್ತು XX", "XX ಮತ್ತು XY", "YY ಮತ್ತು XX", "XX ಮತ್ತು YY"),
            correctAnswer = "XY ಮತ್ತು XX",
            explanation = "ಪುರುಷರಲ್ಲಿ ಒಂದು X ಮತ್ತು ಒಂದು Y ವರ್ಣತಂತುಗಳಿರುತ್ತವೆ (XY); ಸ್ತ್ರೀಯರಲ್ಲಿ ಎರಡೂ ಸಮಾನವಾದ X ವರ್ಣತಂತುಗಳಿರುತ್ತವೆ (XX)."
        ),
        QuestionModel(
            id = "s_10_sci_u9_7",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮಾನವರಲ್ಲಿ ಜನಿಸುವ ಮಗುವಿನ ಲಿಂಗ ನಿರ್ಧಾರವು ಯಾರಿಂದ ಬರುವ ವರ್ಣತಂತುವಿನ ಮೇಲೆ ಅವಲಂಬಿತವಾಗಿರುತ್ತದೆ?",
            options = listOf("ತಂದೆಯ ಶುಕ್ರಾಣು (X ಅಥವಾ Y)", "ತಾಯಿಯ ಅಂಡಾಣು", "ಪರಿಸರದ ತಾಪಮಾನ", "ಆಹಾರ"),
            correctAnswer = "ತಂದೆಯ ಶುಕ್ರಾಣು (X ಅಥವಾ Y)",
            explanation = "ತಾಯಿಯು ಯಾವಾಗಲೂ X ವರ್ಣತಂತುವನ್ನು ನೀಡುತ್ತಾಳೆ. ತಂದೆಯಿಂದ X ಬಂದರೆ ಹೆಣ್ಣು (XX), Y ಬಂದರೆ ಗಂಡು ಮಗು (XY) ಜನಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u9_8",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಮೂಲಭೂತ ರಚನೆಯಲ್ಲಿ ಒಂದೇ ಆಗಿದ್ದು ವಿಭಿನ್ನ ಕಾರ್ಯಗಳನ್ನು ನಿರ್ವಹಿಸುವ ಅಂಗಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸಮರೂಪ ಅಂಗಗಳು (Homologous organs)", "ಕಾರ್ಯಾತ್ಮಕ ಅಂಗಗಳು (Analogous organs)", "ಅವಶೇಷಾಂಗಗಳು", "ಪಳೆಯುಳಿಕೆಗಳು"),
            correctAnswer = "ಸಮರೂಪ ಅಂಗಗಳು (Homologous organs)",
            explanation = "ಕಪ್ಪೆ, ಹಲ್ಲಿ, ಪಕ್ಷಿ ಮತ್ತು ಮಾನವನ ಮುಂಗಾಲುಗಳು ಒಂದೇ ರಚನೆ ಹೊಂದಿದ್ದು ಬೇರೆ ಬೇರೆ ಕಾರ್ಯಗಳನ್ನು ಮಾಡುವುದರಿಂದ ಅವು ಸಮರೂಪ ಅಂಗಗಳು."
        ),
        QuestionModel(
            id = "s_10_sci_u9_9",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಕಾರ್ಯದಲ್ಲಿ ಒಂದೇ ಆಗಿದ್ದು ವಿಭಿನ್ನ ಮೂಲಭೂತ ರಚನೆಯನ್ನು ಹೊಂದಿರುವ ಅಂಗಗಳಿಗೆ ಉದಾಹರಣೆ ಯಾವುದು?",
            options = listOf("ಬಾವಲಿ ಮತ್ತು ಪಕ್ಷಿಯ ರೆಕ್ಕೆಗಳು (ಕಾರ್ಯಾತ್ಮಕ ಅಂಗಗಳು)", "ಮಾನವ ಮತ್ತು ಕಪ್ಪೆಯ ಮುಂಗಾಲುಗಳು", "ಬೆಕ್ಕಿನ ಕಾಲು ಮತ್ತು ತಿಮಿಂಗಿಲದ ಈಜುರೆಕ್ಕೆ", "ಕುದುರೆಯ ಕಾಲು ಮತ್ತು ಮಾನವನ ಕೈ"),
            correctAnswer = "ಬಾವಲಿ ಮತ್ತು ಪಕ್ಷಿಯ ರೆಕ್ಕೆಗಳು (ಕಾರ್ಯಾತ್ಮಕ ಅಂಗಗಳು)",
            explanation = "ಬಾವಲಿಯ ರೆಕ್ಕೆ ಚರ್ಮದ ಮಡಿಕೆಗಳಿಂದಾಗಿದೆ, ಪಕ್ಷಿಯ ರೆಕ್ಕೆ ಗರಿಗಳಿಂದಾಗಿದೆ. ಇವು ಹಾರುವ ಒಂದೇ ಕೆಲಸ ಮಾಡುತ್ತವೆ, ಆದ್ದರಿಂದ ಕಾರ್ಯಾತ್ಮಕ ಅಂಗಗಳು."
        ),
        QuestionModel(
            id = "s_10_sci_u9_10",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "'ನೈಸರ್ಗಿಕ ಆಯ್ಕೆಯ ಮೂಲಕ ಜೀವಿಗಳ ಉಗಮ' (The Origin of Species) ಸಿದ್ಧಾಂತವನ್ನು ಪ್ರತಿಪಾದಿಸಿದ ವಿಜ್ಞಾನಿ ಯಾರು?",
            options = listOf("ಚಾರ್ಲ್ಸ್ ಡಾರ್ವಿನ್", "ಗ್ರೆಗರ್ ಮೆಂಡೆಲ್", "ಸ್ಟಾನ್ಲಿ ಮಿಲ್ಲರ್", "ಹಾಲ್ಡೇನ್"),
            correctAnswer = "ಚಾರ್ಲ್ಸ್ ಡಾರ್ವಿನ್",
            explanation = "ಚಾರ್ಲ್ಸ್ ಡಾರ್ವಿನ್ 1859 ರಲ್ಲಿ ನೈಸರ್ಗಿಕ ಆಯ್ಕೆ ಸಿದ್ಧಾಂತವನ್ನು ತಮ್ಮ 'ದಿ ಆರಿಜಿನ್ ಆಫ್ ಸ್ಪೀಶೀಸ್' ಕೃತಿಯಲ್ಲಿ ಪ್ರಕಟಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_10_sci_u9_11",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಪ್ರಾಚೀನ ಕಾಲದ ಜೀವಿಗಳ ಭೂಮಿಯ ಪದರಗಳಲ್ಲಿ ಸಂರಕ್ಷಿಸಲ್ಪಟ್ಟ ಗುರುತುಗಳು ಅಥವಾ ಅವಶೇಷಗಳನ್ನು ಏನೆನ್ನುವರು?",
            options = listOf("ಪಳೆಯುಳಿಕೆಗಳು (Fossils)", "ಅವಶೇಷಾಂಗಗಳು", "ವಂಶವಾಹಿಗಳು", "ವರ್ಣತಂತುಗಳು"),
            correctAnswer = "ಪಳೆಯುಳಿಕೆಗಳು (Fossils)",
            explanation = "ಹಿಂದೆ ಬದುಕಿ ಮಣ್ಣಿನಲ್ಲಿ ಹೂತುಹೋದ ಜೀವಿಗಳ ಉಳಿಕೆಗಳು ಅಥವಾ ಗುರುತುಗಳೇ ಪಳೆಯುಳಿಕೆಗಳು."
        ),
        QuestionModel(
            id = "s_10_sci_u9_12",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಪಳೆಯುಳಿಕೆಗಳ ವಯಸ್ಸನ್ನು ನಿರ್ಧರಿಸಲು ಬಳಸುವ ಸಾಮಾನ್ಯ ವೈಜ್ಞಾನಿಕ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ಕಾರ್ಬನ್ ಡೇಟಿಂಗ್ (C-14 ವಿಕಿರಣಶೀಲ ವಿಧಾನ)", "ರಕ್ತ ಪರೀಕ್ಷೆ", "ವಿದ್ಯುದ್ವಿಭಜನೆ", "ವರ್ಣರೇಖನ"),
            correctAnswer = "ಕಾರ್ಬನ್ ಡೇಟಿಂಗ್ (C-14 ವಿಕಿರಣಶೀಲ ವಿಧಾನ)",
            explanation = "ಪಳೆಯುಳಿಕೆಯಲ್ಲಿರುವ ವಿಕಿರಣಶೀಲ ಕಾರ್ಬನ್-14 ಐಸೊಟೋಪಿನ ಪ್ರಮಾಣವನ್ನು ಅಳೆದು ಅದರ ವಯಸ್ಸನ್ನು ಅಂದಾಜಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u9_13",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸರೀಸೃಪಗಳು ಮತ್ತು ಪಕ್ಷಿಗಳೆರಡರ ಲಕ್ಷಣಗಳನ್ನೂ ಹೊಂದಿರುವ ಸಂಪರ್ಕ ಕೊಂಡಿಯಾದ ಪಳೆಯುಳಿಕೆ ಯಾವುದು?",
            options = listOf("ಆರ್ಕಿಯೋಪ್ಟೆರಿಕ್ಸ್ (Archaeopteryx)", "ಡೈನೋಸಾರ್", "ಟ್ರೈಲೋಬೈಟ್", "ಅಮೋನೈಟ್"),
            correctAnswer = "ಆರ್ಕಿಯೋಪ್ಟೆರಿಕ್ಸ್ (Archaeopteryx)",
            explanation = "ಆರ್ಕಿಯೋಪ್ಟೆರಿಕ್ಸ್ ಹಕ್ಕಿಗಳಂತೆ ಗರಿಗಳ ರೆಕ್ಕೆಗಳನ್ನು ಮತ್ತು ಸರೀಸೃಪಗಳಂತೆ ಬಾಲ, ಹಲ್ಲುಗಳನ್ನು ಹೊಂದಿದ್ದ ಕೊಂಡಿ ಪಳೆಯುಳಿಕೆಯಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u9_14",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಆಹಾರ ಕೊರತೆಯಿಂದ ದುರ್ಬಲವಾದ ದುಂಬಿಯ ತೂಕ ಕಡಿಮೆಯಾಗುವುದು ಮುಂದಿನ ಪೀಳಿಗೆಗೆ ವರ್ಗಾವಣೆಯಾಗುವುದಿಲ್ಲ. ಏಕೆಂದರೆ ಇದು:",
            options = listOf("ಗಳಿಸಿದ ಲಕ್ಷಣ (Acquired trait) ವಾಗಿದ್ದು DNA ಯಲ್ಲಿ ಬದಲಾವಣೆ ಉಂಟುಮಾಡುವುದಿಲ್ಲ", "ಅನುವಂಶೀಯ ಲಕ್ಷಣ", "ವಿಕೃತ ಲಕ್ಷಣ", "ವಂಶವಾಹಿ ಬದಲಾವಣೆ"),
            correctAnswer = "ಗಳಿಸಿದ ಲಕ್ಷಣ (Acquired trait) ವಾಗಿದ್ದು DNA ಯಲ್ಲಿ ಬದಲಾವಣೆ ಉಂಟುಮಾಡುವುದಿಲ್ಲ",
            explanation = "ಜೀವಿತಾವಧಿಯಲ್ಲಿ ಗಳಿಸಿದ ಲಕ್ಷಣಗಳು ಲೈಂಗಿಕ ಕೋಶಗಳ DNA ಯನ್ನು ಬದಲಾಯಿಸುವುದಿಲ್ಲ, ಆದ್ದರಿಂದ ವಂಶಪಾರಂಪರ್ಯವಾಗಿ ಬರುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_10_sci_u9_15",
            stdId = 10,
            subjectId = "science",
            unitId = 9,
            type = "MCQ",
            questionText = "ಆರಂಭಿಕ ಭೂಮಿಯ ವಾತಾವರಣದಲ್ಲಿ ಸರಳ ಅಜೈವಿಕ ಅಣುಗಳಿಂದ ಅಮೈನೋ ಆಮ್ಲಗಳು ಸಂಶ್ಲೇಷಿಸಲ್ಪಟ್ಟವು ಎಂದು ಪ್ರಯೋಗದ ಮೂಲಕ ಸಾಬೀತುಪಡಿಸಿದವರು ಯಾರು?",
            options = listOf("ಸ್ಟಾನ್ಲಿ ಮಿಲ್ಲರ್ ಮತ್ತು ಹೆರಾಲ್ಡ್ ಯುರೇ", "ಮೆಂಡೆಲ್ ಮತ್ತು ಮಾರ್ಗನ್", "ಡಾರ್ವಿನ್ ಮತ್ತು ವ್ಯಾಲೇಸ್", "ರಾಬರ್ಟ್ ಹುಕ್"),
            correctAnswer = "ಸ್ಟಾನ್ಲಿ ಮಿಲ್ಲರ್ ಮತ್ತು ಹೆರಾಲ್ಡ್ ಯುರೇ",
            explanation = "1953 ರಲ್ಲಿ ಮಿಲ್ಲರ್ ಮತ್ತು ಯುರೇ ಕೃತಕವಾಗಿ ಮಿಂಚು ಹರಿಸಿ ಜೈವಿಕ ಅಣುಗಳ ಮೂಲವನ್ನು ಪ್ರಯೋಗಾಲಯದಲ್ಲಿ ನಿರೂಪಿಸಿದರು."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 10: ಬೆಳಕು - ಪ್ರತಿಫಲನ ಮತ್ತು ವಕ್ರೀಭವನ
    // ========================================================
    private val u10Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u10_1",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ವಾಹನಗಳ ಹಿನ್ನೋಟ ದರ್ಪಣವಾಗಿ (Rear-view mirror) ಬಳಸುವ ದರ್ಪಣ ಯಾವುದು?",
            options = listOf("ಪೀನ ದರ್ಪಣ (Convex mirror)", "ನಿಮ್ನ ದರ್ಪಣ (Concave mirror)", "ಸಮತಲ ದರ್ಪಣ", "ಪೀನ ಮಸೂರ"),
            correctAnswer = "ಪೀನ ದರ್ಪಣ (Convex mirror)",
            explanation = "ಪೀನ ದರ್ಪಣವು ಯಾವಾಗಲೂ ನೇರವಾದ, ಚಿಕ್ಕದಾದ ಪ್ರತಿಬಿಂಬವನ್ನು ನೀಡುತ್ತದೆ ಮತ್ತು ವಿಶಾಲ ದೃಷ್ಟಿ ಕ್ಷೇತ್ರವನ್ನು ಒದಗಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_2",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ವಾಹನಗಳ ಮುಂಭಾಗದ ದೀಪಗಳಲ್ಲಿ (Headlights) ಮತ್ತು ದಂತವೈದ್ಯರು ಹಲ್ಲುಗಳನ್ನು ದೊಡ್ಡದಾಗಿ ನೋಡಲು ಬಳಸುವ ದರ್ಪಣ ಯಾವುದು?",
            options = listOf("ನಿಮ್ನ ದರ್ಪಣ (Concave mirror)", "ಪೀನ ದರ್ಪಣ", "ಸಮತಲ ದರ್ಪಣ", "ದ್ವಿನಿಮ್ನ ಮಸೂರ"),
            correctAnswer = "ನಿಮ್ನ ದರ್ಪಣ (Concave mirror)",
            explanation = "ನಿಮ್ನ ದರ್ಪಣದ ಪ್ರಧಾನ ಸಂಗಮದಲ್ಲಿ ಬೆಳಕಿನ ಆಕರವನ್ನಿಟ್ಟಾಗ ಅದು ಸಮಾಂತರ ಬೆಳಕಿನ ಶಕ್ತಿಯುತ ಕಿರಣವನ್ನು ನೀಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_3",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಗೋಳೀಯ ದರ್ಪಣದ ವಕ್ರತಾ ತ್ರಿಜ್ಯ (R) ಮತ್ತು ಸಂಗಮ ದೂರ (f) ಗಳ ನಡುವಿನ ಸರಿಯಾದ ಸಂಬಂಧ ಯಾವುದು?",
            options = listOf("R = 2f", "f = 2R", "R = f/2", "R = f + 2"),
            correctAnswer = "R = 2f",
            explanation = "ಗೋಳೀಯ ದರ್ಪಣದ ಸಂಗಮ ದೂರವು ಅದರ ವಕ್ರತಾ ತ್ರಿಜ್ಯದ ಅರ್ಧದಷ್ಟಿರುತ್ತದೆ (f = R/2 ಅಥವಾ R = 2f)."
        ),
        QuestionModel(
            id = "s_10_sci_u10_4",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಗೋಳೀಯ ದರ್ಪಣ ಸೂತ್ರ (Mirror formula) ಯಾವುದು?",
            options = listOf("1/f = 1/v + 1/u", "1/f = 1/v - 1/u", "1/v = 1/f + 1/u", "f = u + v"),
            correctAnswer = "1/f = 1/v + 1/u",
            explanation = "ದರ್ಪಣ ಸೂತ್ರವು 1/f = 1/v + 1/u ಆಗಿರುತ್ತದೆ; ಮಸೂರ ಸೂತ್ರದಲ್ಲಿ 1/v - 1/u ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_5",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಗೋಳೀಯ ಮಸೂರ ಸೂತ್ರ (Lens formula) ಯಾವುದು?",
            options = listOf("1/f = 1/v - 1/u", "1/f = 1/v + 1/u", "1/u = 1/v - 1/f", "f = v - u"),
            correctAnswer = "1/f = 1/v - 1/u",
            explanation = "ಮಸೂರ ಸೂತ್ರವು 1/f = 1/v - 1/u ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_6",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಮಸೂರದ ಸಾಮರ್ಥ್ಯದ (Power of lens) SI ಏಕಮಾನ ಯಾವುದು?",
            options = listOf("ಡಯಾಪ್ಟರ್ (Dioptre - D)", "ಮೀಟರ್", "ವ್ಯಾಟ್", "ಜೌಲ್"),
            correctAnswer = "ಡಯಾಪ್ಟರ್ (Dioptre - D)",
            explanation = "1 ಮೀಟರ್ ಸಂಗಮ ದೂರವಿರುವ ಮಸೂರದ ಸಾಮರ್ಥ್ಯವೇ 1 ಡಯಾಪ್ಟರ್ (P = 1/f)."
        ),
        QuestionModel(
            id = "s_10_sci_u10_7",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಒಂದು ಪೀನ ಮಸೂರದ ಸಂಗಮ ದೂರವು 2 ಮೀಟರ್ ಆಗಿದ್ದರೆ ಅದರ ಸಾಮರ್ಥ್ಯ (Power) ಎಷ್ಟು?",
            options = listOf("+0.5 D", "-0.5 D", "+2.0 D", "-2.0 D"),
            correctAnswer = "+0.5 D",
            explanation = "P = 1/f = 1 / (+2 m) = +0.5 D. ಪೀನ ಮಸೂರದ ಸಾಮರ್ಥ್ಯ ಧನಾತ್ಮಕವಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_8",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬೆಳಕಿನ ವಕ್ರೀಭವನದ ಎರಡನೇ ನಿಯಮಕ್ಕೆ (sin i / sin r = ಸ್ಥಿರಾಂಕ) ಇರುವ ಇನ್ನೊಂದು ಹೆಸರೇನು?",
            options = listOf("ಸ್ನೆಲ್‌ನ ನಿಯಮ (Snell's Law)", "ನ್ಯೂಟನ್‌ನ ನಿಯಮ", "ಓಂನ ನಿಯಮ", "ಫ್ಯಾರಡೆ ನಿಯಮ"),
            correctAnswer = "ಸ್ನೆಲ್‌ನ ನಿಯಮ (Snell's Law)",
            explanation = "ಪತನ ಕೋನದ ಸೈನ್ ಮತ್ತು ವಕ್ರೀಭವನ ಕೋನದ ಸೈನ್‌ಗಳ ಅನುಪಾತವು ಸ್ಥಿರಾಂಕವಾಗಿರುತ್ತದೆ ಎಂಬುದೇ ಸ್ನೆಲ್‌ನ ನಿಯಮ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_9",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಈ ಕೆಳಗಿನ ಮಾಧ್ಯಮಗಳಲ್ಲಿ ಅತ್ಯಂತ ಹೆಚ್ಚಿನ ವಕ್ರೀಭವನಾಂಕ (2.42) ಹೊಂದಿರುವ ವಸ್ತು ಯಾವುದು?",
            options = listOf("ವಜ್ರ (Diamond)", "ಗಾಜು", "ನೀರು", "ಸೀಮೆಎಣ್ಣೆ"),
            correctAnswer = "ವಜ್ರ (Diamond)",
            explanation = "ವಜ್ರದ ವಕ್ರೀಭವನಾಂಕವು 2.42 ಆಗಿದ್ದು, ಇದರಲ್ಲಿ ಬೆಳಕಿನ ವೇಗ ಅತ್ಯಂತ ಕಡಿಮೆಯಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_10",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಒಂದು ನಿಮ್ನ ದರ್ಪಣದಲ್ಲಿ ವಸ್ತುವನ್ನು ಎಲ್ಲಿಟ್ಟಾಗ ಅದೇ ಗಾತ್ರದ ಸತ್ಯ ಮತ್ತು ತಲೆಕೆಳಗಾದ ಪ್ರತಿಬಿಂಬ ಉಂಟಾಗುತ್ತದೆ?",
            options = listOf("ವಕ್ರತಾ ಕೇಂದ್ರ 'C' ನಲ್ಲಿಟ್ಟಾಗ", "ಸಂಗಮ ಬಿಂದು 'F' ನಲ್ಲಿಟ್ಟಾಗ", "ಧ್ರುವ 'P' ನಲ್ಲಿಟ್ಟಾಗ", "ಅನಂತ ದೂರದಲ್ಲಿಟ್ಟಾಗ"),
            correctAnswer = "ವಕ್ರತಾ ಕೇಂದ್ರ 'C' ನಲ್ಲಿಟ್ಟಾಗ",
            explanation = "ವಸ್ತುವನ್ನು ನಿಮ್ನ ದರ್ಪಣದ 'C' ಮೇಲಿಟ್ಟಾಗ ಪ್ರತಿಬಿಂಬವೂ 'C' ನಲ್ಲೇ ವಸ್ತುವಿನಷ್ಟೇ ಗಾತ್ರದ ಸತ್ಯ ಪ್ರತಿಬಿಂಬವಾಗಿ ಉಂಟಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_11",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಒಂದು ಪೀನ ಮಸೂರದಲ್ಲಿ ನೇರವಾದ ಮತ್ತು ವರ್ಧಿಸಿದ ಮಿಥ್ಯ ಪ್ರತಿಬಿಂಬ ಪಡೆಯಲು ವಸ್ತುವನ್ನು ಎಲ್ಲಿಡಬೇಕು?",
            options = listOf("ದೃಕ್ ಕೇಂದ್ರ 'O' ಮತ್ತು ಸಂಗಮ ಬಿಂದು 'F1' ಗಳ ನಡುವೆ", "2F1 ನಲ್ಲಿ", "F1 ನಲ್ಲಿ", "ಅನಂತ ದೂರದಲ್ಲಿ"),
            correctAnswer = "ದೃಕ್ ಕೇಂದ್ರ 'O' ಮತ್ತು ಸಂಗಮ ಬಿಂದು 'F1' ಗಳ ನಡುವೆ",
            explanation = "ವಸ್ತುವನ್ನು ಮಸೂರಕ್ಕೆ ತೀರಾ ಹತ್ತಿರದಲ್ಲಿ (O ಮತ್ತು F1 ನಡುವೆ) ಇಟ್ಟಾಗ ಮಾತ್ರ ವರ್ಧಿಸಿದ ನೇರ ಮಿಥ್ಯ ಪ್ರತಿಬಿಂಬ ಮೂಡುತ್ತದೆ (ಭೂತಗನ್ನಡಿ ತತ್ವ)."
        ),
        QuestionModel(
            id = "s_10_sci_u10_12",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಬೆಳಕಿನ ಕಿರಣವು ಸಾಂದ್ರ ಮಾಧ್ಯಮದಿಂದ (ಗಾಜಿನಿಂದ) ವಿರಳ ಮಾಧ್ಯಮಕ್ಕೆ (ಗಾಳಿಗೆ) ಚಲಿಸಿದಾಗ ಏನಾಗುತ್ತದೆ?",
            options = listOf("ಲಂಬದಿಂದ ದೂರ ಸರಿಯುತ್ತದೆ ಮತ್ತು ವೇಗ ಹೆಚ್ಚಾಗುತ್ತದೆ", "ಲಂಬದ ಕಡೆಗೆ ಬಾಗುತ್ತದೆ", "ಬದಲಾಗದೆ ನೇರವಾಗಿ ಚಲಿಸುತ್ತದೆ", "ಹಿಂದಕ್ಕೆ ಪ್ರತಿಫಲಿಸುತ್ತದೆ"),
            correctAnswer = "ಲಂಬದಿಂದ ದೂರ ಸರಿಯುತ್ತದೆ ಮತ್ತು ವೇಗ ಹೆಚ್ಚಾಗುತ್ತದೆ",
            explanation = "ಸಾಂದ್ರದಿಂದ ವಿರಳ ಮಾಧ್ಯಮಕ್ಕೆ ಹೋದಾಗ ಬೆಳಕಿನ ವೇಗ ಹೆಚ್ಚಾಗಿ ಅದು ಲಂಬದಿಂದ ದೂರ ಸರಿಯುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_13",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಒಂದು ಸಮತಲ ದರ್ಪಣದ ವರ್ಧನೆ (Magnification) ಯಾವಾಗಲೂ ಎಷ್ಟು ಇರುತ್ತದೆ?",
            options = listOf("+1", "-1", "0", "ಅನಂತ"),
            correctAnswer = "+1",
            explanation = "ಸಮತಲ ದರ್ಪಣದ ಪ್ರತಿಬಿಂಬವು ವಸ್ತುವಿನಷ್ಟೇ ಗಾತ್ರದ್ದಾಗಿದ್ದು (h' = h) ನೇರವಾಗಿರುತ್ತದೆ (+ ಚಿಹ್ನೆ), ಆದ್ದರಿಂದ m = +1."
        ),
        QuestionModel(
            id = "s_10_sci_u10_14",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ಸೂರ್ಯನ ಬೆಳಕನ್ನು ಕೇಂದ್ರೀಕರಿಸಿ ಕಾಗದವನ್ನು ಸುಡಲು ಬಳಸಬಹುದಾದ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಪೀನ ಮಸೂರ (ಅಥವಾ ನಿಮ್ನ ದರ್ಪಣ)", "ನಿಮ್ನ ಮಸೂರ", "ಪೀನ ದರ್ಪಣ", "ಗಾಜಿನ ಚಪ್ಪಡಿ"),
            correctAnswer = "ಪೀನ ಮಸೂರ (ಅಥವಾ ನಿಮ್ನ ದರ್ಪಣ)",
            explanation = "ಪೀನ ಮಸೂರವು ಕಲೆಯುವ (ಅಭಿಸರಣ) ಮಸೂರವಾಗಿದ್ದು ಸೂರ್ಯನ ಸಮಾಂತರ ಕಿರಣಗಳನ್ನು ಸಂಗಮ ಬಿಂದುವಿನಲ್ಲಿ ಕೇಂದ್ರೀಕರಿಸಿ ತಾಪ ಹೆಚ್ಚಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u10_15",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ದರ್ಪಣದ ಸಂಗಮ ದೂರವು -15 cm ಆಗಿದೆ. ಹಾಗಾದರೆ ಅದು ಯಾವ ದರ್ಪಣವಾಗಿದೆ?",
            options = listOf("ನಿಮ್ನ ದರ್ಪಣ", "ಪೀನ ದರ್ಪಣ", "ಸಮತಲ ದರ್ಪಣ", "ಉಭಯ ದರ್ಪಣ"),
            correctAnswer = "ನಿಮ್ನ ದರ್ಪಣ",
            explanation = "ಚಿಹ್ನಾ ಪದ್ಧತಿಯ ಪ್ರಕಾರ ನಿಮ್ನ ದರ್ಪಣದ ಮತ್ತು ನಿಮ್ನ ಮಸೂರದ ಸಂಗಮ ದೂರ ಯಾವಾಗಲೂ ಋಣಾತ್ಮಕವಾಗಿರುತ್ತದೆ (-)."
        ),
        QuestionModel(
            id = "s_10_sci_u10_16",
            stdId = 10,
            subjectId = "science",
            unitId = 10,
            type = "MCQ",
            questionText = "ನೀರಿನಲ್ಲಿ ಅರ್ಧ ಮುಳುಗಿಸಿದ ಪೆನ್ಸಿಲ್ ನೀರಿನ ಮೇಲ್ಮೈಯಲ್ಲಿ ಬಾಗಿದಂತೆ ಕಾಣಲು ಕಾರಣವೇನು?",
            options = listOf("ಬೆಳಕಿನ ವಕ್ರೀಭವನ (Refraction)", "ಬೆಳಕಿನ ಪ್ರತಿಫಲನ", "ಬೆಳಕಿನ ಚದುರುವಿಕೆ", "ವರ್ಣವಿಭಜನೆ"),
            correctAnswer = "ಬೆಳಕಿನ ವಕ್ರೀಭವನ (Refraction)",
            explanation = "ಬೆಳಕು ನೀರಿನಿಂದ ಗಾಳಿಗೆ ಬಂದಾಗ ವಕ್ರೀಭವನ ಹೊಂದಿ ಲಂಬದಿಂದ ದೂರ ಸರಿಯುವುದರಿಂದ ಪೆನ್ಸಿಲ್ ಮೇಲಕ್ಕೆ ಎದ್ದಂತೆ ಬಾಗಿ ಕಾಣುತ್ತದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 11: ಮಾನವನ ಕಣ್ಣು ಮತ್ತು ವರ್ಣಮಯ ಜಗತ್ತು
    // ========================================================
    private val u11Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u11_1",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಮಾನವನ ಕಣ್ಣಿನಲ್ಲಿ ಬೆಳಕನ್ನು ಗ್ರಹಿಸುವ ಪರದೆ ಯಾವುದು ಮತ್ತು ಅದರ ಮೇಲೆ ಮೂಡುವ ಪ್ರತಿಬಿಂಬದ ಲಕ್ಷಣವೇನು?",
            options = listOf("ಅಕ್ಷಿಪಟಲ (ರೆಟಿನಾ) - ಸತ್ಯ ಮತ್ತು ತಲೆಕೆಳಗಾದ ಪ್ರತಿಬಿಂಬ", "ಕಣ್ಣಿನ ಪಾಪೆ - ಮಿಥ್ಯ ಪ್ರತಿಬಿಂಬ", "ಕಾರ್ನಿಯಾ - ನೇರ ಪ್ರತಿಬಿಂಬ", "ಐರಿಸ್ - ದೊಡ್ಡ ಪ್ರತಿಬಿಂಬ"),
            correctAnswer = "ಅಕ್ಷಿಪಟಲ (ರೆಟಿನಾ) - ಸತ್ಯ ಮತ್ತು ತಲೆಕೆಳಗಾದ ಪ್ರತಿಬಿಂಬ",
            explanation = "ಕಣ್ಣಿನ ಹಿಂಭಾಗದಲ್ಲಿರುವ ರೆಟಿನಾದ ಮೇಲೆ ಕಣ್ಣಿನ ಪೀನ ಮಸೂರವು ಸತ್ಯ ಮತ್ತು ತಲೆಕೆಳಗಾದ ಪ್ರತಿಬಿಂಬವನ್ನು ಮೂಡಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u11_2",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕಣ್ಣಿನ ಮಸೂರದ ಸಂಗಮ ದೂರವನ್ನು ಬದಲಾಯಿಸಿ ವಸ್ತುಗಳನ್ನು ಸ್ಪಷ್ಟವಾಗಿ ನೋಡಲು ನೆರವಾಗುವ ಸ್ನಾಯುಗಳು ಯಾವುವು?",
            options = listOf("ಸಿಲಿಯರಿ ಸ್ನಾಯುಗಳು (Ciliary muscles)", "ಕಣ್ಣಿನ ಪಾಪೆ ಸ್ನಾಯುಗಳು", "ಹೃದಯ ಸ್ನಾಯುಗಳು", "ಐರಿಸ್ ಸ್ನಾಯುಗಳು"),
            correctAnswer = "ಸಿಲಿಯರಿ ಸ್ನಾಯುಗಳು (Ciliary muscles)",
            explanation = "ಸಿಲಿಯರಿ ಸ್ನಾಯುಗಳು ಸಂಕೋಚನ ಮತ್ತು ವಿಕಸನ ಹೊಂದುವ ಮೂಲಕ ಕಣ್ಣಿನ ಮಸೂರದ ವಕ್ರತೆಯನ್ನು ಬದಲಾಯಿಸುತ್ತವೆ (ಹೊಂದಾಣಿಕೆಯ ಸಾಮರ್ಥ್ಯ)."
        ),
        QuestionModel(
            id = "s_10_sci_u11_3",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸಾಮಾನ್ಯ ದೃಷ್ಟಿ ಹೊಂದಿರುವ ಯುವ ವಯಸ್ಕನ ಸ್ಪಷ್ಟ ದೃಷ್ಟಿಯ ಕನಿಷ್ಠ ದೂರ ಎಷ್ಟು?",
            options = listOf("25 cm", "2.5 cm", "25 m", "2.5 m"),
            correctAnswer = "25 cm",
            explanation = "ಯಾವುದೇ ಆಯಾಸವಿಲ್ಲದೆ ಸ್ಪಷ್ಟವಾಗಿ ನೋಡಬಹುದಾದ ಕನಿಷ್ಠ ದೂರ 25 ಸೆಂ.ಮೀ (Near point of the eye)."
        ),
        QuestionModel(
            id = "s_10_sci_u11_4",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸಮೀಪದ ದೃಷ್ಟಿ ದೋಷವನ್ನು (ಮಯೋಪಿಯಾ / Myopia) ಸರಿಪಡಿಸಲು ಬಳಸುವ ಸೂಕ್ತ ಮಸೂರ ಯಾವುದು?",
            options = listOf("ನಿಮ್ನ ಮಸೂರ (Concave lens)", "ಪೀನ ಮಸೂರ (Convex lens)", "ದ್ವಿಸಂಗಮ ಮಸೂರ", "ಸಿಲಿಂಡರಾಕಾರದ ಮಸೂರ"),
            correctAnswer = "ನಿಮ್ನ ಮಸೂರ (Concave lens)",
            explanation = "ಮಯೋಪಿಯಾದಲ್ಲಿ ಪ್ರತಿಬಿಂಬವು ರೆಟಿನಾಕ್ಕಿಂತ ಮುಂಚೆಯೇ ಮೂಡುತ್ತದೆ; ಸೂಕ್ತ ಸಾಮರ್ಥ್ಯದ ನಿಮ್ನ ಮಸೂರವು ಬೆಳಕನ್ನು ಅಪಸರಿಸಿ ರೆಟಿನಾದ ಮೇಲೆ ಕೇಂದ್ರೀಕರಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u11_5",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ದೂರದ ದೃಷ್ಟಿ ದೋಷವನ್ನು (ಹೈಪರ್‌ಮೆಟ್ರೋಪಿಯಾ / Hypermetropia) ಸರಿಪಡಿಸಲು ಬಳಸುವ ಸೂಕ್ತ ಮಸೂರ ಯಾವುದು?",
            options = listOf("ಪೀನ ಮಸೂರ (Convex lens)", "ನಿಮ್ನ ಮಸೂರ", "ಸಮತಲ ಮಸೂರ", "ಬೈಫೋಕಲ್ ಮಸೂರ"),
            correctAnswer = "ಪೀನ ಮಸೂರ (Convex lens)",
            explanation = "ಹೈಪರ್‌ಮೆಟ್ರೋಪಿಯಾದಲ್ಲಿ ಪ್ರತಿಬಿಂಬ ರೆಟಿನಾದ ಹಿಂದೆ ಮೂಡುತ್ತದೆ. ಪೀನ ಮಸೂರವು ಬೆಳಕನ್ನು ಒಗ್ಗೂಡಿಸಿ ರೆಟಿನಾದ ಮೇಲೆ ತರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u11_6",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ವೃದ್ಧಾಪ್ಯದಲ್ಲಿ ಸಿಲಿಯರಿ ಸ್ನಾಯುಗಳು ದುರ್ಬಲಗೊಂಡು ಸಮೀಪದ ವಸ್ತುಗಳು ಕಾಣಿಸದಿರುವ (ಪ್ರೆಸ್‌ಬಯೋಪಿಯಾ) ದೋಷ ನಿವಾರಣೆಗೆ ಬಳಸುವ ಮಸೂರ ಯಾವುದು?",
            options = listOf("ದ್ವಿಸಂಗಮ ಮಸೂರ (Bifocal lens)", "ಕೇವಲ ಪೀನ ಮಸೂರ", "ಕೇವಲ ನಿಮ್ನ ಮಸೂರ", "ಸಮತಲ ಗಾಜು"),
            correctAnswer = "ದ್ವಿಸಂಗಮ ಮಸೂರ (Bifocal lens)",
            explanation = "ದ್ವಿಸಂಗಮ ಮಸೂರದ ಮೇಲ್ಭಾಗ ನಿಮ್ನ ಮಸೂರವಾಗಿದ್ದು (ದೂರ ನೋಡಲು) ಮತ್ತು ಕೆಳಭಾಗ ಪೀನ ಮಸೂರವಾಗಿರುತ್ತದೆ (ಓದಲು)."
        ),
        QuestionModel(
            id = "s_10_sci_u11_7",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಗಾಜಿನ ಪ್ರಿಸ್ಮ್ ಮೂಲಕ ಬಿಳಿ ಬೆಳಕನ್ನು ಹಾಯಿಸಿದಾಗ ಅದು ಏಳು ಬಣ್ಣಗಳ ಪಟ್ಟಿಯಾಗಿ ವಿಭಜನೆಗೊಳ್ಳುವ ವಿದ್ಯಮಾನಕ್ಕೆ ಏನೆನ್ನುವರು?",
            options = listOf("ಬೆಳಕಿನ ವರ್ಣವಿಭಜನೆ (Dispersion)", "ಪ್ರತಿಫಲನ", "ಚದುರುವಿಕೆ", "ವಕ್ರೀಭವನ"),
            correctAnswer = "ಬೆಳಕಿನ ವರ್ಣವಿಭಜನೆ (Dispersion)",
            explanation = "ವಿವಿಧ ಬಣ್ಣಗಳು ಪ್ರಿಸ್ಮ್‌ನಲ್ಲಿ ಬೇರೆ ಬೇರೆ ವೇಗ ಮತ್ತು ಕೋನಗಳಲ್ಲಿ ವಕ್ರೀಭವನ ಹೊಂದುವುದರಿಂದ ವರ್ಣವಿಭಜನೆ ಉಂಟಾಗುತ್ತದೆ (VIBGYOR)."
        ),
        QuestionModel(
            id = "s_10_sci_u11_8",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಪ್ರಿಸ್ಮ್‌ನಲ್ಲಿ ಕನಿಷ್ಠ ಬಾಗುವಿಕೆಗೆ ಒಳಗಾಗುವ ಮತ್ತು ಗರಿಷ್ಠ ಬಾಗುವಿಕೆಗೆ ಒಳಗಾಗುವ ಬಣ್ಣಗಳು ಅನುಕ್ರಮವಾಗಿ ಯಾವುವು?",
            options = listOf("ಕೆಂಪು (ಕನಿಷ್ಠ) ಮತ್ತು ನೇರಳೆ (ಗರಿಷ್ಠ)", "ನೇರಳೆ (ಕನಿಷ್ಠ) ಮತ್ತು ಕೆಂಪು (ಗರಿಷ್ಠ)", "ಹಳದಿ ಮತ್ತು ಹಸಿರು", "ನೀಲಿ ಮತ್ತು ಕಿತ್ತಳೆ"),
            correctAnswer = "ಕೆಂಪು (ಕನಿಷ್ಠ) ಮತ್ತು ನೇರಳೆ (ಗರಿಷ್ಠ)",
            explanation = "ಕೆಂಪು ಬೆಳಕಿನ ತರಂಗಾಂತರ ಗರಿಷ್ಠವಾಗಿರುವುದರಿಂದ ಅದು ಕನಿಷ್ಠ ಬಾಗುತ್ತದೆ; ನೇರಳೆ ಬೆಳಕಿನ ತರಂಗಾಂತರ ಕಡಿಮೆ ಇರುವುದರಿಂದ ಅದು ಅತಿ ಹೆಚ್ಚು ಬಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u11_9",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಮಳೆಯ ನಂತರ ಆಕಾಶದಲ್ಲಿ ಕಾಮನಬಿಲ್ಲು (Rainbow) ಉಂಟಾಗಲು ಕಾರಣವೇನು?",
            options = listOf("ವಾತಾವರಣದ ನೀರಿನ ಬಿಂದುಗಳಿಂದ ಸೂರ್ಯನ ಬೆಳಕಿನ ವಕ್ರೀಭವನ, ವರ್ಣವಿಭಜನೆ ಮತ್ತು ಆಂತರಿಕ ಪ್ರತಿಫಲನ", "ಕೇವಲ ಬೆಳಕಿನ ಪ್ರತಿಫಲನ", "ಬೆಳಕಿನ ಚದುರುವಿಕೆ ಮಾತ್ರ", "ಕೇವಲ ಆಂತರಿಕ ಪ್ರತಿಫಲನ"),
            correctAnswer = "ವಾತಾವರಣದ ನೀರಿನ ಬಿಂದುಗಳಿಂದ ಸೂರ್ಯನ ಬೆಳಕಿನ ವಕ್ರೀಭವನ, ವರ್ಣವಿಭಜನೆ ಮತ್ತು ಆಂತರಿಕ ಪ್ರತಿಫಲನ",
            explanation = "ವಾತಾವರಣದಲ್ಲಿ ತೇಲುವ ಸಣ್ಣ ನೀರಿನ ಹನಿಗಳು ಸಣ್ಣ ಪ್ರಿಸ್ಮ್‌ಗಳಂತೆ ವರ್ತಿಸಿ ಕಾಮನಬಿಲ್ಲನ್ನು ಉಂಟುಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u11_10",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ರಾತ್ರಿಯ ಆಕಾಶದಲ್ಲಿ ನಕ್ಷತ್ರಗಳು ಮಿನುಗಲು ಮುಖ್ಯ ಕಾರಣವೇನು?",
            options = listOf("ವಾತಾವರಣದ ವಕ್ರೀಭವನ (Atmospheric refraction)", "ಬೆಳಕಿನ ಚದುರುವಿಕೆ", "ನಕ್ಷತ್ರಗಳ ಚಲನೆ", "ಬೆಳಕಿನ ಆಂತರಿಕ ಪ್ರತಿಫಲನ"),
            correctAnswer = "ವಾತಾವರಣದ ವಕ್ರೀಭವನ (Atmospheric refraction)",
            explanation = "ಭೂಮಿಯ ವಾತಾವರಣದ ವಿವಿಧ ಸಾಂದ್ರತೆಯ ಗಾಳಿಯ ಪದರಗಳ ಮೂಲಕ ಬರುವಾಗ ನಕ್ಷತ್ರದ ಬೆಳಕು ನಿರಂತರ ವಕ್ರೀಭವನಗೊಂಡು ಮಿನುಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u11_11",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ವಾತಾವರಣದ ವಕ್ರೀಭವನದಿಂದಾಗಿ ನೈಜ ಸೂರ್ಯೋದಯಕ್ಕಿಂತ ಮುಂಚಿತವಾಗಿ ಮತ್ತು ನೈಜ ಸೂರ್ಯಾಸ್ತದ ನಂತರ ಸೂರ್ಯನು ಎಷ್ಟು ನಿಮಿಷಗಳ ಕಾಲ ಕಾಣಿಸುತ್ತಾನೆ?",
            options = listOf("2 ನಿಮಿಷಗಳ ಕಾಲ", "4 ನಿಮಿಷಗಳ ಕಾಲ", "1 ನಿಮಿಷ", "5 ನಿಮಿಷ"),
            correctAnswer = "2 ನಿಮಿಷಗಳ ಕಾಲ",
            explanation = "ಮುಂಚಿತ ಸೂರ್ಯೋದಯ 2 ನಿಮಿಷ ಮತ್ತು ತಡವಾದ ಸೂರ್ಯಾಸ್ತ 2 ನಿಮಿಷ ಸೇರಿ ಹಗಲಿನ ಅವಧಿ ಸುಮಾರು 4 ನಿಮಿಷ ಹೆಚ್ಚಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u11_12",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಸ್ವಚ್ಛವಾದ ಆಕಾಶವು ನೀಲಿ ಬಣ್ಣವಾಗಿ ಕಾಣಲು ಕಾರಣವೇನು?",
            options = listOf("ವಾತಾವರಣದ ಕಣಗಳಿಂದ ಕಡಿಮೆ ತರಂಗಾಂತರದ ನೀಲಿ ಬೆಳಕಿನ ಚದುರುವಿಕೆ (Scattering)", "ಸಮುದ್ರದ ನೀರಿನ ಪ್ರತಿಫಲನ", "ಆಕಾಶದಲ್ಲಿ ನೀಲಿ ಬಣ್ಣದ ಅನಿಲವಿರುವುದು", "ಬೆಳಕಿನ ವರ್ಣವಿಭಜನೆ"),
            correctAnswer = "ವಾತಾವರಣದ ಕಣಗಳಿಂದ ಕಡಿಮೆ ತರಂಗಾಂತರದ ನೀಲಿ ಬೆಳಕಿನ ಚದುರುವಿಕೆ (Scattering)",
            explanation = "ಗಾಳಿಯಲ್ಲಿರುವ ಸೂಕ್ಷ್ಮ ಕಣಗಳು ಕೆಂಪು ಬೆಳಕಿಗಿಂತ ಕಡಿಮೆ ತರಂಗಾಂತರ ಹೊಂದಿರುವ ನೀಲಿ ಬೆಳಕನ್ನು ಹೆಚ್ಚು ಪ್ರಬಲವಾಗಿ ಚದುರಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u11_13",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಅಪಾಯದ ಸಂಕೇತವಾಗಿ ಕೆಂಪು ಬಣ್ಣದ ದೀಪಗಳನ್ನೇ ಬಳಸಲು ವೈಜ್ಞಾನಿಕ ಕಾರಣವೇನು?",
            options = listOf("ಕೆಂಪು ಬೆಳಕಿನ ತರಂಗಾಂತರ ಹೆಚ್ಚಾಗಿದ್ದು ಮಂಜು ಮತ್ತು ಹೊಗೆಯಲ್ಲಿ ಅತಿ ಕಡಿಮೆ ಚದುರುತ್ತದೆ", "ಕೆಂಪು ಬೆಳಕಿಗೆ ಕಣ್ಣು ಹೆಚ್ಚು ಆಕರ್ಷಿತವಾಗುತ್ತದೆ", "ಕೆಂಪು ಬೆಳಕಿನ ವೇಗ ಹೆಚ್ಚು", "ಕೆಂಪು ಬೆಳಕು ಹೆಚ್ಚು ಬಿಸಿಯಾಗಿರುತ್ತದೆ"),
            correctAnswer = "ಕೆಂಪು ಬೆಳಕಿನ ತರಂಗಾಂತರ ಹೆಚ್ಚಾಗಿದ್ದು ಮಂಜು ಮತ್ತು ಹೊಗೆಯಲ್ಲಿ ಅತಿ ಕಡಿಮೆ ಚದುರುತ್ತದೆ",
            explanation = "ರೇಲೆ ಚದುರುವಿಕೆ ನಿಯಮದ ಪ್ರಕಾರ ಕೆಂಪು ಬೆಳಕು ಅತಿ ಹೆಚ್ಚು ತರಂಗಾಂತರ ಹೊಂದಿರುವುದರಿಂದ ಕನಿಷ್ಠ ಚದುರಿ ದೂರದವರೆಗೆ ಸ್ಪಷ್ಟವಾಗಿ ಕಾಣಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u11_14",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಕಲಿಲ ಕಣಗಳ ಮೂಲಕ ಬೆಳಕು ಹರಿದಾಗ ಬೆಳಕಿನ ಪಥವು ಗೋಚರವಾಗುವ ವಿದ್ಯಮಾನಕ್ಕೆ ಏನೆನ್ನುವರು?",
            options = listOf("ಟಿಂಡಾಲ್ ಪರಿಣಾಮ (Tyndall effect)", "ಡಾಪ್ಲರ್ ಪರಿಣಾಮ", "ರಾಮನ್ ಪರಿಣಾಮ", "ದ್ಯುತಿವಿದ್ಯುತ್ ಪರಿಣಾಮ"),
            correctAnswer = "ಟಿಂಡಾಲ್ ಪರಿಣಾಮ (Tyndall effect)",
            explanation = "ಧೂಳಿನ ಕಣಗಳು ಬೆಳಕನ್ನು ಚದುರಿಸುವುದರಿಂದ ಬೆಳಕಿನ ಕಿರಣ ಗೋಚರವಾಗುವುದೇ ಟಿಂಡಾಲ್ ಪರಿಣಾಮ (ಉದಾ: ದಟ್ಟ ಕಾಡಿನಲ್ಲಿ ಸೂರ್ಯನ ಕಿರಣ)."
        ),
        QuestionModel(
            id = "s_10_sci_u11_15",
            stdId = 10,
            subjectId = "science",
            unitId = 11,
            type = "MCQ",
            questionText = "ಬಾಹ್ಯಾಕಾಶ ಯಾತ್ರಿಗೆ ಆಕಾಶವು ಕಪ್ಪು ಬಣ್ಣವಾಗಿ ಕಾಣಲು ಕಾರಣವೇನು?",
            options = listOf("ಬಾಹ್ಯಾಕಾಶದಲ್ಲಿ ವಾತಾವರಣವಿಲ್ಲದಿರುವುದರಿಂದ ಬೆಳಕಿನ ಚದುರುವಿಕೆ ನಡೆಯುವುದಿಲ್ಲ", "ಸೂರ್ಯನ ಬೆಳಕು ಬಾಹ್ಯಾಕಾಶವನ್ನು ತಲುಪುವುದಿಲ್ಲ", "ಬಾಹ್ಯಾಕಾಶದಲ್ಲಿ ಕತ್ತಲಿರುತ್ತದೆ", "ನಕ್ಷತ್ರಗಳ ಬೆಳಕು ಹೀರಿಕೊಳ್ಳಲ್ಪಡುತ್ತದೆ"),
            correctAnswer = "ಬಾಹ್ಯಾಕಾಶದಲ್ಲಿ ವಾತಾವರಣವಿಲ್ಲದಿರುವುದರಿಂದ ಬೆಳಕಿನ ಚದುರುವಿಕೆ ನಡೆಯುವುದಿಲ್ಲ",
            explanation = "ವಾತಾವರಣ ಮತ್ತು ಕಣಗಳಿಲ್ಲದ ಜಾಗದಲ್ಲಿ ಬೆಳಕು ಚದುರುವುದಿಲ್ಲ, ಆದ್ದರಿಂದ ಬಾಹ್ಯಾಕಾಶದಲ್ಲಿ ಆಕಾಶವು ಕಪ್ಪಾಗಿ ಕಾಣುತ್ತದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 12: ವಿದ್ಯುಚ್ಛಕ್ತಿ
    // ========================================================
    private val u12Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u12_1",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಪ್ರವಾಹದ (Electric Current - I) SI ಏಕಮಾನ ಯಾವುದು?",
            options = listOf("ಆಂಪಿಯರ್ (Ampere - A)", "ವೋಲ್ಟ್", "ಓಮ್", "ಕೂಲಂಬ್"),
            correctAnswer = "ಆಂಪಿಯರ್ (Ampere - A)",
            explanation = "ವಿದ್ಯುತ್ ಪ್ರವಾಹದ SI ಏಕಮಾನ ಆಂಪಿಯರ್ (I = Q/t)."
        ),
        QuestionModel(
            id = "s_10_sci_u12_2",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ವಿಭವಾಂತರದ (Potential Difference - V) SI ಏಕಮಾನ ಯಾವುದು?",
            options = listOf("ವೋಲ್ಟ್ (Volt - V)", "ಆಂಪಿಯರ್", "ಜೌಲ್", "ವ್ಯಾಟ್"),
            correctAnswer = "ವೋಲ್ಟ್ (Volt - V)",
            explanation = "ವಿದ್ಯುತ್ ವಿಭವಾಂತರದ SI ಏಕಮಾನ ವೋಲ್ಟ್ (V = W/Q)."
        ),
        QuestionModel(
            id = "s_10_sci_u12_3",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಮಂಡಲದಲ್ಲಿ ವಿದ್ಯುತ್ ಪ್ರವಾಹವನ್ನು ಅಳೆಯಲು ಬಳಸುವ ಉಪಕರಣ ಮತ್ತು ಅದನ್ನು ಮಂಡಲದಲ್ಲಿ ಜೋಡಿಸುವ ಕ್ರಮ ಯಾವುದು?",
            options = listOf("ಅಮ್ಮೀಟರ್ - ಸರಣಿ ಜೋಡಣೆ", "ವೋಲ್ಟ್‌ಮೀಟರ್ - ಸಮಾಂತರ ಜೋಡಣೆ", "ಅಮ್ಮೀಟರ್ - ಸಮಾಂತರ ಜೋಡಣೆ", "ಗ್ಯಾಲ್ವನೋಮೀಟರ್ - ಸರಣಿ ಜೋಡಣೆ"),
            correctAnswer = "ಅಮ್ಮೀಟರ್ - ಸರಣಿ ಜೋಡಣೆ",
            explanation = "ಅಮ್ಮೀಟರ್ ಕಡಿಮೆ ರೋಧ ಹೊಂದಿದ್ದು ವಿದ್ಯುತ್ ಪ್ರವಾಹ ಅಳೆಯಲು ಯಾವಾಗಲೂ ಸರಣಿ ಕ್ರಮದಲ್ಲಿ ಜೋಡಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u12_4",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಸ್ಥಿರ ಉಷ್ಣತೆಯಲ್ಲಿ ಲೋಹದ ವಾಹಕದ ತುದಿಗಳ ನಡುವಿನ ವಿಭವಾಂತರವು (V) ಅದರಲ್ಲಿ ಹರಿಯುವ ವಿದ್ಯುತ್ ಪ್ರವಾಹಕ್ಕೆ (I) ನೇರ ಅನುಪಾತದಲ್ಲಿರುತ್ತದೆ ಎಂದು ತಿಳಿಸುವ ನಿಯಮ ಯಾವುದು?",
            options = listOf("ಓಂನ ನಿಯಮ (Ohm's Law)", "ಜೌಲ್‌ನ ನಿಯಮ", "ಆಂಪಿಯರ್ ನಿಯಮ", "ಫ್ಲೆಮಿಂಗ್ ನಿಯಮ"),
            correctAnswer = "ಓಂನ ನಿಯಮ (Ohm's Law)",
            explanation = "V ∝ I ಅಥವಾ V = IR ಎಂಬುದೇ ಓಂನ ನಿಯಮವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u12_5",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ರೋಧದ (Resistance - R) SI ಏಕಮಾನ ಯಾವುದು?",
            options = listOf("ಓಮ್ (Ohm - Ω)", "ವೋಲ್ಟ್", "ಆಂಪಿಯರ್", "ಓಮ್ ಮೀಟರ್"),
            correctAnswer = "ಓಮ್ (Ohm - Ω)",
            explanation = "ರೋಧದ SI ಏಕಮಾನ ಓಮ್ (Ω) ಆಗಿದೆ (R = V/I)."
        ),
        QuestionModel(
            id = "s_10_sci_u12_6",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ರೋಧಶೀಲತೆಯ (Resistivity - ρ) SI ಏಕಮಾನ ಯಾವುದು?",
            options = listOf("ಓಮ್ ಮೀಟರ್ (Ω·m)", "ಓಮ್ / ಮೀಟರ್", "ಓಮ್", "ವೋಲ್ಟ್ ಮೀಟರ್"),
            correctAnswer = "ಓಮ್ ಮೀಟರ್ (Ω·m)",
            explanation = "ರೋಧಶೀಲತೆಯ SI ಏಕಮಾನ ಓಮ್-ಮೀಟರ್ (Ω·m) ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u12_7",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಒಂದು ವಾಹಕದ ರೋಧವು (Resistance) ಈ ಕೆಳಗಿನ ಯಾವುದರ ಮೇಲೆ ಅವಲಂಬಿತವಾಗಿರುವುದಿಲ್ಲ?",
            options = listOf("ವಾಹಕದ ತೂಕ", "ವಾಹಕದ ಉದ್ದ", "ಅಡ್ಡಕೊಯ್ಲಿನ ವಿಸ್ತೀರ್ಣ", "ವಸ್ತುವಿನ ಸ್ವಭಾವ ಮತ್ತು ತಾಪಮಾನ"),
            correctAnswer = "ವಾಹಕದ ತೂಕ",
            explanation = "ರೋಧವು R = ρL/A ಸೂತ್ರದಂತೆ ಉದ್ದ, ಅಡ್ಡಕೊಯ್ಲಿನ ವಿಸ್ತೀರ್ಣ, ವಸ್ತುವಿನ ಸ್ವಭಾವ ಮತ್ತು ತಾಪದ ಮೇಲೆ ಅವಲಂಬಿತವಾಗಿದೆ; ತೂಕದ ಮೇಲಲ್ಲ."
        ),
        QuestionModel(
            id = "s_10_sci_u12_8",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "R1 ಮತ್ತು R2 ರೋಧಕಗಳನ್ನು ಸಮಾಂತರವಾಗಿ ಜೋಡಿಸಿದಾಗ ಅವುಗಳ ಸಮಾನ ರೋಧ (Rp) ಸೂತ್ರ ಯಾವುದು?",
            options = listOf("1/Rp = 1/R1 + 1/R2", "Rp = R1 + R2", "Rp = R1 × R2", "1/Rp = R1 + R2"),
            correctAnswer = "1/Rp = 1/R1 + 1/R2",
            explanation = "ಸಮಾಂತರ ಜೋಡಣೆಯಲ್ಲಿ 1/Rp = 1/R1 + 1/R2 ಅಥವಾ Rp = (R1·R2)/(R1 + R2)."
        ),
        QuestionModel(
            id = "s_10_sci_u12_9",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಬಲ್ಬ್‌ನ ಫಿಲಮೆಂಟ್ ತಯಾರಿಸಲು ಟಂಗ್‌ಸ್ಟನ್ (Tungsten) ಲೋಹವನ್ನೇ ಬಳಸಲು ಕಾರಣವೇನು?",
            options = listOf("ಅತ್ಯಧಿಕ ಕರಗುವ ಬಿಂದು (3380°C) ಮತ್ತು ಹೆಚ್ಚಿನ ರೋಧಶೀಲತೆ ಹೊಂದಿದೆ", "ಕಡಿಮೆ ಕರಗುವ ಬಿಂದು ಹೊಂದಿದೆ", "ವಿದ್ಯುತ್ ಹರಿಯುವುದಿಲ್ಲ", "ಅಗ್ಗದ ಲೋಹವಾಗಿದೆ"),
            correctAnswer = "ಅತ್ಯಧಿಕ ಕರಗುವ ಬಿಂದು (3380°C) ಮತ್ತು ಹೆಚ್ಚಿನ ರೋಧಶೀಲತೆ ಹೊಂದಿದೆ",
            explanation = "ಟಂಗ್‌ಸ್ಟನ್ ಅತ್ಯುನ್ನತ ಕರಗುವ ಬಿಂದು ಹೊಂದಿರುವುದರಿಂದ ಪ್ರಖರ ಬೆಳಕು ನೀಡುವಾಗ ಕರಗುವುದಿಲ್ಲ."
        ),
        QuestionModel(
            id = "s_10_sci_u12_10",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಇಸ್ತ್ರಿ ಪೆಟ್ಟಿಗೆ ಮತ್ತು ಹೀಟರ್‌ಗಳಲ್ಲಿ ಬಳಸುವ ತಾಪಕ ಸುರುಳಿಯನ್ನು ನಿಕ್ರೋಮ್ (Nichrome) ಮಿಶ್ರಲೋಹದಿಂದ ಮಾಡಲು ಕಾರಣವೇನು?",
            options = listOf("ಹೆಚ್ಚಿನ ರೋಧಶೀಲತೆ ಹೊಂದಿದ್ದು ಅತಿ ಹೆಚ್ಚಿನ ತಾಪದಲ್ಲೂ ಆಕ್ಸಿಡೀಕರಣಗೊಳ್ಳುವುದಿಲ್ಲ (ಉರಿಯುವುದಿಲ್ಲ)", "ಕಡಿಮೆ ರೋಧ ಹೊಂದಿದೆ", "ಬೇಗನೆ ಕರಗುತ್ತದೆ", "ವಿದ್ಯುತ್ ಉಳಿಸುತ್ತದೆ"),
            correctAnswer = "ಹೆಚ್ಚಿನ ರೋಧಶೀಲತೆ ಹೊಂದಿದ್ದು ಅತಿ ಹೆಚ್ಚಿನ ತಾಪದಲ್ಲೂ ಆಕ್ಸಿಡೀಕರಣಗೊಳ್ಳುವುದಿಲ್ಲ (ಉರಿಯುವುದಿಲ್ಲ)",
            explanation = "ನಿಕ್ರೋಮ್ ಹೆಚ್ಚಿನ ರೋಧಶೀಲತೆ ಮತ್ತು ಕೆಂಪಗೆ ಕಾದಾಗಲೂ ಆಕ್ಸಿಡೀಕರಣಕ್ಕೆ ಒಳಗಾಗದ ವಿಶಿಷ್ಟ ಗುಣ ಹೊಂದಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u12_11",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಜೌಲ್‌ನ ಶಾಖೋತ್ಪನ್ನ ನಿಯಮದ ಗಣಿತೀಯ ಸೂತ್ರ ಯಾವುದು?",
            options = listOf("H = I²Rt", "H = IRt", "H = VIt²", "H = I/Rt"),
            correctAnswer = "H = I²Rt",
            explanation = "ಉತ್ಪತ್ತಿಯಾದ ಶಾಖವು ಪ್ರವಾಹದ ವರ್ಗಕ್ಕೆ, ರೋಧಕ್ಕೆ ಮತ್ತು ಸಮಯಕ್ಕೆ ನೇರ ಅನುಪಾತದಲ್ಲಿರುತ್ತದೆ (H = I²Rt = VIt)."
        ),
        QuestionModel(
            id = "s_10_sci_u12_12",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಸಾಮರ್ಥ್ಯದ (Electric Power - P) SI ಏಕಮಾನ ಯಾವುದು?",
            options = listOf("ವ್ಯಾಟ್ (Watt - W)", "ಜೌಲ್", "ಕಿಲೋವ್ಯಾಟ್ ಗಂಟೆ", "ವೋಲ್ಟ್"),
            correctAnswer = "ವ್ಯಾಟ್ (Watt - W)",
            explanation = "ವಿದ್ಯುತ್ ಸಾಮರ್ಥ್ಯದ SI ಏಕಮಾನ ವ್ಯಾಟ್ (1 W = 1 V × 1 A)."
        ),
        QuestionModel(
            id = "s_10_sci_u12_13",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ವಾಣಿಜ್ಯ ವಿದ್ಯುತ್ ಶಕ್ತಿಯ ಏಕಮಾನವಾದ 1 ಕಿಲೋವ್ಯಾಟ್ ಗಂಟೆ (1 kWh) ಎಷ್ಟು ಜೌಲ್‌ಗಳಿಗೆ ಸಮ?",
            options = listOf("3.6 × 10^6 J", "3.6 × 10^5 J", "360 J", "1000 J"),
            correctAnswer = "3.6 × 10^6 J",
            explanation = "1 kWh = 1000 W × 3600 s = 3,600,000 J = 3.6 × 10^6 Joules."
        ),
        QuestionModel(
            id = "s_10_sci_u12_14",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಮನೆಯ ವಿದ್ಯುತ್ ಮಂಡಲಗಳಲ್ಲಿ ವಿದ್ಯುತ್ ಉಪಕರಣಗಳನ್ನು ಸಮಾಂತರವಾಗಿ (Parallel) ಜೋಡಿಸಲು ಮುಖ್ಯ ಕಾರಣವೇನು?",
            options = listOf("ಪ್ರತಿಯೊಂದು ಉಪಕರಣಕ್ಕೂ ಸಮಾನ ವೋಲ್ಟೇಜ್ ದೊರೆಯುತ್ತದೆ ಮತ್ತು ಒಂದು ಸ್ಥಗಿತಗೊಂಡರೆ ಇತರ ಉಪಕರಣಗಳು ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತವೆ", "ರೋಧ ಹೆಚ್ಚಾಗುತ್ತದೆ", "ವಿದ್ಯುತ್ ಪ್ರವಾಹ ಎಲ್ಲದರಲ್ಲೂ ಒಂದೇ ಆಗಿರುತ್ತದೆ", "ವಿದ್ಯುತ್ ಬಿಲ್ ಕಡಿಮೆಯಾಗುತ್ತದೆ"),
            correctAnswer = "ಪ್ರತಿಯೊಂದು ಉಪಕರಣಕ್ಕೂ ಸಮಾನ ವೋಲ್ಟೇಜ್ ದೊರೆಯುತ್ತದೆ ಮತ್ತು ಒಂದು ಸ್ಥಗಿತಗೊಂಡರೆ ಇತರ ಉಪಕರಣಗಳು ಕಾರ್ಯನಿರ್ವಹಿಸುತ್ತವೆ",
            explanation = "ಸಮಾಂತರ ಜೋಡಣೆಯಲ್ಲಿ ಎಲ್ಲಾ ಸಾಧನಗಳಿಗೆ 220V ಸಮಾನ ವಿಭವಾಂತರ ಸಿಗುತ್ತದೆ ಹಾಗೂ ಪ್ರತ್ಯೇಕ ಸ್ವಿಚ್ ಇರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u12_15",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "2 Ω, 3 Ω ಮತ್ತು 6 Ω ರೋಧಗಳನ್ನು ಸಮಾಂತರವಾಗಿ ಜೋಡಿಸಿದಾಗ ಅವುಗಳ ಸಮಾನ ರೋಧ ಎಷ್ಟು?",
            options = listOf("1 Ω", "11 Ω", "0.5 Ω", "6 Ω"),
            correctAnswer = "1 Ω",
            explanation = "1/Rp = 1/2 + 1/3 + 1/6 = (3 + 2 + 1)/6 = 6/6 = 1 Ω. ಆದ್ದರಿಂದ Rp = 1 Ω."
        ),
        QuestionModel(
            id = "s_10_sci_u12_16",
            stdId = 10,
            subjectId = "science",
            unitId = 12,
            type = "MCQ",
            questionText = "ಮಂಡಲದಲ್ಲಿ ಮಿತಿಮೀರಿದ ವಿದ್ಯುತ್ ಪ್ರವಾಹದಿಂದ ಉಪಕರಣಗಳನ್ನು ರಕ್ಷಿಸುವ ಸುರಕ್ಷತಾ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಫ್ಯೂಸ್ (Fuse)", "ಅಮ್ಮೀಟರ್", "ವೋಲ್ಟ್‌ಮೀಟರ್", "ರಿಯೋಸ್ಟಾಟ್"),
            correctAnswer = "ಫ್ಯೂಸ್ (Fuse)",
            explanation = "ಫ್ಯೂಸ್ ಕಡಿಮೆ ಕರಗುವ ಬಿಂದು ಹೊಂದಿರುವ ಸೀಸ-ತವರದ ತಂತಿಯಾಗಿದ್ದು ಹೆಚ್ಚಿನ ಪ್ರವಾಹ ಬಂದಾಗ ಕರಗಿ ಮಂಡಲವನ್ನು ಕಡಿತಗೊಳಿಸುತ್ತದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 13: ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ಕಾಂತೀಯ ಪರಿಣಾಮಗಳು
    // ========================================================
    private val u13Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u13_1",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಪ್ರವಾಹವು ತನ್ನ ಸುತ್ತಲೂ ಕಾಂತಕ್ಷೇತ್ರವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ ಎಂದು ಆಕಸ್ಮಿಕವಾಗಿ ಮೊದಲು ಕಂಡುಹಿಡಿದ ವಿಜ್ಞಾನಿ ಯಾರು?",
            options = listOf("ಹ್ಯಾನ್ಸ್ ಕ್ರಿಶ್ಚಿಯನ್ ಆಯ್‌ಸ್ಟರ್ಡ್", "ಮೈಕೆಲ್ ಫ್ಯಾರಡೆ", "ಆಂಡ್ರೆ ಮೇರಿ ಆಂಪಿಯರ್", "ಜೇಮ್ಸ್ ಜೌಲ್"),
            correctAnswer = "ಹ್ಯಾನ್ಸ್ ಕ್ರಿಶ್ಚಿಯನ್ ಆಯ್‌ಸ್ಟರ್ಡ್",
            explanation = "1820 ರಲ್ಲಿ ಆಯ್‌ಸ್ಟರ್ಡ್ ವಿದ್ಯುತ್ ಹರಿಯುವ ತಂತಿಯ ಬಳಿ ಕಾಂತಸೂಚಿ ಇಟ್ಟಾಗ ಅದು ವಿಚಲನೆ ಹೊಂದುವುದನ್ನು ಗಮನಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_10_sci_u13_2",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ನೇರ ವಿದ್ಯುತ್ ವಾಹಕದ ಸುತ್ತ ಉಂಟಾಗುವ ಕಾಂತೀಯ ಬಲರೇಖೆಗಳ ದಿಕ್ಕನ್ನು ನಿರ್ಧರಿಸಲು ಬಳಸುವ ನಿಯಮ ಯಾವುದು?",
            options = listOf("ಬಲಗೈ ಹೆಬ್ಬೆರಳಿನ ನಿಯಮ (Right-Hand Thumb Rule)", "ಫ್ಲೆಮಿಂಗ್‌ನ ಎಡಗೈ ನಿಯಮ", "ಫ್ಲೆಮಿಂಗ್‌ನ ಬಲಗೈ ನಿಯಮ", "ಸ್ನೆಲ್ ನಿಯಮ"),
            correctAnswer = "ಬಲಗೈ ಹೆಬ್ಬೆರಳಿನ ನಿಯಮ (Right-Hand Thumb Rule)",
            explanation = "ಹೆಬ್ಬೆರಳು ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ದಿಕ್ಕನ್ನು ಸೂಚಿಸಿದಾಗ, ತಂತಿಯನ್ನು ಸುತ್ತುವರಿದ ಬೆರಳುಗಳು ಕಾಂತೀಯ ಬಲರೇಖೆಗಳ ದಿಕ್ಕನ್ನು ಸೂಚಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u13_3",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ರೋಧಕ ಕವಚವಿರುವ ತಾಮ್ರದ ತಂತಿಯನ್ನು ಸಿಲಿಂಡರ್ ಆಕಾರದಲ್ಲಿ ಸುತ್ತಿ ತಯಾರಿಸಿದ ರಚನೆಗೆ ಏನೆನ್ನುವರು?",
            options = listOf("ಸೊಲೆನಾಯ್ಡ್ (Solenoid)", "ಆರ್ಮೇಚರ್", "ಕಮ್ಯುಟೇಟರ್", "ಸ್ಪ್ಲಿಟ್ ರಿಂಗ್"),
            correctAnswer = "ಸೊಲೆನಾಯ್ಡ್ (Solenoid)",
            explanation = "ಸೊಲೆನಾಯ್ಡ್‌ನಲ್ಲಿ ವಿದ್ಯುತ್ ಹರಿದಾಗ ಅದು ದಂಡಕಾಂತದಂತೆಯೇ ಏಕರೂಪದ ಪ್ರಬಲ ಕಾಂತಕ್ಷೇತ್ರವನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u13_4",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಮೋಟಾರ್‌ನ ಕಾರ್ಯನಿರ್ವಹಣೆಯು ಯಾವ ನಿಯಮವನ್ನು ಆಧರಿಸಿದೆ?",
            options = listOf("ಫ್ಲೆಮಿಂಗ್‌ನ ಎಡಗೈ ನಿಯಮ (Fleming's Left-Hand Rule)", "ಫ್ಲೆಮಿಂಗ್‌ನ ಬಲಗೈ ನಿಯಮ", "ಬಲಗೈ ಹೆಬ್ಬೆರಳಿನ ನಿಯಮ", "ಓಂನ ನಿಯಮ"),
            correctAnswer = "ಫ್ಲೆಮಿಂಗ್‌ನ ಎಡಗೈ ನಿಯಮ (Fleming's Left-Hand Rule)",
            explanation = "ಕಾಂತಕ್ಷೇತ್ರದಲ್ಲಿರುವ ವಾಹಕದ ಮೇಲೆ ಉಂಟಾಗುವ ಚಲನೆಯ ಬಲದ ದಿಕ್ಕನ್ನು ಫ್ಲೆಮಿಂಗ್‌ನ ಎಡಗೈ ನಿಯಮದಿಂದ ನಿರ್ಧರಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u13_5",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಮೋಟಾರ್ (Electric Motor) ಯಾವ ಶಕ್ತಿಯನ್ನು ಯಾವ ಶಕ್ತಿಯಾಗಿ ಪರಿವರ್ತಿಸುತ್ತದೆ?",
            options = listOf("ವಿದ್ಯುತ್ ಶಕ್ತಿಯನ್ನು ಯಾಂತ್ರಿಕ ಶಕ್ತಿಯಾಗಿ", "ಯಾಂತ್ರಿಕ ಶಕ್ತಿಯನ್ನು ವಿದ್ಯುತ್ ಶಕ್ತಿಯಾಗಿ", "ರಾಸಾಯನಿಕ ಶಕ್ತಿಯನ್ನು ವಿದ್ಯುತ್ ಆಗಿ", "ಶಾಖ ಶಕ್ತಿಯನ್ನು ಬೆಳಕಾಗಿ"),
            correctAnswer = "ವಿದ್ಯುತ್ ಶಕ್ತಿಯನ್ನು ಯಾಂತ್ರಿಕ ಶಕ್ತಿಯಾಗಿ",
            explanation = "ವಿದ್ಯುತ್ ಮೋಟಾರ್ ವಿದ್ಯುತ್ ಶಕ್ತಿಯನ್ನು ಯಾಂತ್ರಿಕ (ಚಲನ) ಶಕ್ತಿಯಾಗಿ ಪರಿವರ್ತಿಸುತ್ತದೆ (ಫ್ಯಾನ್, ಮಿಕ್ಸರ್, ಪಂಪ್)."
        ),
        QuestionModel(
            id = "s_10_sci_u13_6",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ಬದಲಾಗುವ ಕಾಂತಕ್ಷೇತ್ರದಿಂದ ವಾಹಕದಲ್ಲಿ ಪ್ರೇರಿತ ವಿದ್ಯುತ್ ಪ್ರವಾಹ ಉಂಟಾಗುವ 'ವಿದ್ಯುತ್ಕಾಂತೀಯ ಪ್ರೇರಣೆ'ಯನ್ನು (Electromagnetic Induction) ಕಂಡುಹಿಡಿದವರು ಯಾರು?",
            options = listOf("ಮೈಕೆಲ್ ಫ್ಯಾರಡೆ", "ಆಯ್‌ಸ್ಟರ್ಡ್", "ಥಾಮಸ್ ಎಡಿಸನ್", "ಅಲೆಕ್ಸಾಂಡರ್ ವೋಲ್ಟಾ"),
            correctAnswer = "ಮೈಕೆಲ್ ಫ್ಯಾರಡೆ",
            explanation = "1831 ರಲ್ಲಿ ಮೈಕೆಲ್ ಫ್ಯಾರಡೆ ಕಾಂತೀಯ ಪ್ರೇರಣೆಯ ತತ್ವವನ್ನು ಆವಿಷ್ಕರಿಸಿ ಡೈನಮೋ ತಯಾರಿಕೆಗೆ ನಾಂದಿ ಹಾಡಿದರು."
        ),
        QuestionModel(
            id = "s_10_sci_u13_7",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ವಾಹಕದಲ್ಲಿ ಉಂಟಾಗುವ ಪ್ರೇರಿತ ವಿದ್ಯುತ್ ಪ್ರವಾಹದ (Induced current) ದಿಕ್ಕನ್ನು ನಿರ್ಧರಿಸುವ ನಿಯಮ ಯಾವುದು?",
            options = listOf("ಫ್ಲೆಮಿಂಗ್‌ನ ಬಲಗೈ ನಿಯಮ (Fleming's Right-Hand Rule)", "ಫ್ಲೆಮಿಂಗ್‌ನ ಎಡಗೈ ನಿಯಮ", "ಬಲಗೈ ಹೆಬ್ಬೆರಳಿನ ನಿಯಮ", "ಲೆನ್ಸ್ ನಿಯಮ"),
            correctAnswer = "ಫ್ಲೆಮಿಂಗ್‌ನ ಬಲಗೈ ನಿಯಮ (Fleming's Right-Hand Rule)",
            explanation = "ಜನರೇಟರ್‌ನಲ್ಲಿ ಪ್ರೇರಿತ ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ದಿಕ್ಕನ್ನು ಫ್ಲೆಮಿಂಗ್‌ನ ಬಲಗೈ ನಿಯಮದಿಂದ ತಿಳಿಯಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u13_8",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಜನರೇಟರ್ (Electric Generator / Dynamo) ಯಾವ ಶಕ್ತಿಯನ್ನು ಯಾವ ಶಕ್ತಿಯಾಗಿ ಪರಿವರ್ತಿಸುತ್ತದೆ?",
            options = listOf("ಯಾಂತ್ರಿಕ ಶಕ್ತಿಯನ್ನು ವಿದ್ಯುತ್ ಶಕ್ತಿಯಾಗಿ", "ವಿದ್ಯುತ್ ಶಕ್ತಿಯನ್ನು ಯಾಂತ್ರಿಕ ಶಕ್ತಿಯಾಗಿ", "ಕಾಂತೀಯ ಶಕ್ತಿಯನ್ನು ಶಾಖವಾಗಿ", "ಶಾಖ ಶಕ್ತಿಯನ್ನು ಯಾಂತ್ರಿಕ ಶಕ್ತಿಯಾಗಿ"),
            correctAnswer = "ಯಾಂತ್ರಿಕ ಶಕ್ತಿಯನ್ನು ವಿದ್ಯುತ್ ಶಕ್ತಿಯಾಗಿ",
            explanation = "ವಿದ್ಯುತ್ಕಾಂತೀಯ ಪ್ರೇರಣೆಯ ತತ್ವದ ಮೇಲೆ ಕಾರ್ಯನಿರ್ವಹಿಸುವ ಜನರೇಟರ್ ಯಾಂತ್ರಿಕ ಶಕ್ತಿಯನ್ನು ವಿದ್ಯುತ್ ಶಕ್ತಿಯಾಗಿ ಪರಿವರ್ತಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u13_9",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ಭಾರತದಲ್ಲಿ ಮನೆಬಳಕೆಗೆ ಸರಬರಾಜು ಮಾಡುವ ಪ್ರತ್ಯಾವರ್ತಕ ವಿದ್ಯುತ್ ಪ್ರವಾಹದ (AC) ಆವರ್ತನ (Frequency) ಎಷ್ಟು?",
            options = listOf("50 Hz", "60 Hz", "100 Hz", "220 Hz"),
            correctAnswer = "50 Hz",
            explanation = "ಭಾರತದಲ್ಲಿ AC ವಿದ್ಯುತ್ ಪ್ರತಿ ಸೆಕೆಂಡಿಗೆ 50 ಬಾರಿ ತನ್ನ ದಿಕ್ಕನ್ನು ಬದಲಾಯಿಸುತ್ತದೆ (ಆವರ್ತನ = 50 Hz, ವಿಭವಾಂತರ = 220 V)."
        ),
        QuestionModel(
            id = "s_10_sci_u13_10",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ಮನೆಯ ವಿದ್ಯುತ್ ಮಂಡಲದಲ್ಲಿ ಸಜೀವ ತಂತಿ (Live wire) ಮತ್ತು ತಟಸ್ಥ ತಂತಿಗಳ (Neutral wire) ಬಣ್ಣಗಳು ಅನುಕ್ರಮವಾಗಿ ಯಾವುವು?",
            options = listOf("ಕೆಂಪು ಮತ್ತು ಕಪ್ಪು", "ಹಸಿರು ಮತ್ತು ಕೆಂಪು", "ಕಪ್ಪು ಮತ್ತು ಬಿಳಿ", "ಹಳದಿ ಮತ್ತು ನೀಲಿ"),
            correctAnswer = "ಕೆಂಪು ಮತ್ತು ಕಪ್ಪು",
            explanation = "ಲೈವ್ ತಂತಿಯು ಕೆಂಪು ಬಣ್ಣದ ಇನ್ಸುಲೇಷನ್ ಹೊಂದಿದ್ದರೆ, ತಟಸ್ಥ (ನ್ಯೂಟ್ರಲ್) ತಂತಿಯು ಕಪ್ಪು ಬಣ್ಣದ್ದಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u13_11",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ಲೋಹದ ಕವಚವಿರುವ ಉಪಕರಣಗಳಿಂದ ವಿದ್ಯುತ್ ಆಘಾತ (Electric shock) ತಡೆಯಲು ಬಳಸುವ ಭೂಸಂಪರ್ಕ ತಂತಿಯ (Earth wire) ಬಣ್ಣ ಯಾವುದು?",
            options = listOf("ಹಸಿರು", "ಕೆಂಪು", "ಕಪ್ಪು", "ನೀಲಿ"),
            correctAnswer = "ಹಸಿರು",
            explanation = "ಭೂಸಂಪರ್ಕ ತಂತಿಯು ಹಸಿರು ಬಣ್ಣದ್ದಾಗಿದ್ದು, ಯಾವುದೇ ವಿದ್ಯುತ್ ಸೋರಿಕೆಯಾದಾಗ ಪ್ರವಾಹವನ್ನು ಸುರಕ್ಷಿತವಾಗಿ ಭೂಮಿಗೆ ಹರಿಸಿ ಆಘಾತ ತಪ್ಪಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u13_12",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ಸಜೀವ ತಂತಿ ಮತ್ತು ತಟಸ್ಥ ತಂತಿಗಳು ನೇರವಾಗಿ ಪರಸ್ಪರ ಸ್ಪರ್ಶಿಸಿದಾಗ ಮಂಡಲದಲ್ಲಿ ಅತಿಯಾದ ವಿದ್ಯುತ್ ಪ್ರವಾಹ ಹರಿಯುವ ಸ್ಥಿತಿಯನ್ನು ಏನೆನ್ನುವರು?",
            options = listOf("ಹ್ರಸ್ವ ಮಂಡಲ (Short circuit)", "ಅಧಿಕ ಭಾರ (Overloading)", "ಭೂಸಂಪರ್ಕ", "ಮುಕ್ತ ಮಂಡಲ"),
            correctAnswer = "ಹ್ರಸ್ವ ಮಂಡಲ (Short circuit)",
            explanation = "ತಂತಿಗಳ ಇನ್ಸುಲೇಷನ್ ಹಾನಿಯಾಗಿ ಲೈವ್ ಮತ್ತು ನ್ಯೂಟ್ರಲ್ ತಂತಿಗಳು ತಾಕಿದಾಗ ರೋಧ ಶೂನ್ಯವಾಗಿ ಭಾರಿ ಪ್ರವಾಹ ಹರಿಯುವುದೇ ಶಾರ್ಟ್ ಸರ್ಕ್ಯೂಟ್."
        ),
        QuestionModel(
            id = "s_10_sci_u13_13",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ದಂಡಕಾಂತದ ಕಾಂತೀಯ ಬಲರೇಖೆಗಳ ಗುಣಲಕ್ಷಣಗಳಲ್ಲಿ ಯಾವುದು ತಪ್ಪಾಗಿದೆ?",
            options = listOf("ಎರಡು ಬಲರೇಖೆಗಳು ಪರಸ್ಪರ ಛೇದಿಸುತ್ತವೆ", "ಕಾಂತದ ಹೊರಗೆ ಉತ್ತರ ಧ್ರುವದಿಂದ ಹೊರಟು ದಕ್ಷಿಣ ಧ್ರುವವನ್ನು ಸೇರುತ್ತವೆ", "ಕಾಂತದ ಒಳಗೆ ದಕ್ಷಿಣ ಧ್ರುವದಿಂದ ಉತ್ತರ ಧ್ರುವದ ಕಡೆಗೆ ಇರುತ್ತವೆ", "ಇವು ನಿರಂತರ ಆವೃತ ವಕ್ರರೇಖೆಗಳಾಗಿವೆ"),
            correctAnswer = "ಎರಡು ಬಲರೇಖೆಗಳು ಪರಸ್ಪರ ಛೇದಿಸುತ್ತವೆ",
            explanation = "ಎರಡು ಕಾಂತೀಯ ಬಲರೇಖೆಗಳು ಎಂದಿಗೂ ಒಂದನ್ನೊಂದು ಛೇದಿಸುವುದಿಲ್ಲ, ಏಕೆಂದರೆ ಛೇದಿಸಿದರೆ ಆ ಬಿಂದುವಿನಲ್ಲಿ ಕಾಂತಕ್ಷೇತ್ರಕ್ಕೆ ಎರಡು ದಿಕ್ಕುಗಳಿರುತ್ತವೆ, ಇದು ಅಸಾಧ್ಯ."
        ),
        QuestionModel(
            id = "s_10_sci_u13_14",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ ಮೋಟಾರ್‌ನಲ್ಲಿ ವಿದ್ಯುತ್ ಪ್ರವಾಹದ ದಿಕ್ಕನ್ನು ಪ್ರತಿ ಅರ್ಧ ಸುತ್ತಿಗೆ ಬದಲಾಯಿಸುವ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಕವಲೊಡೆದ ಉಂಗುರಗಳು / ಕಮ್ಯುಟೇಟರ್ (Split rings)", "ಜಾರುವ ಉಂಗುರಗಳು", "ಕಾರ್ಬನ್ ಕುಂಚಗಳು", "ಆಕ್ಸಲ್"),
            correctAnswer = "ಕವಲೊಡೆದ ಉಂಗುರಗಳು / ಕಮ್ಯುಟೇಟರ್ (Split rings)",
            explanation = "ಕವಲೊಡೆದ ಅರ್ಧ ಉಂಗುರಗಳು ಕಮ್ಯುಟೇಟರ್ ಆಗಿ ವರ್ತಿಸಿ ಸುರುಳಿಯಲ್ಲಿ ಪ್ರವಾಹದ ದಿಕ್ಕನ್ನು ಬದಲಿಸಿ ನಿರಂತರವಾಗಿ ಒಂದೇ ದಿಕ್ಕಿನಲ್ಲಿ ತಿರುಗುವಂತೆ ಮಾಡುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u13_15",
            stdId = 10,
            subjectId = "science",
            unitId = 13,
            type = "MCQ",
            questionText = "ವಿದ್ಯುತ್ಕಾಂತವನ್ನು (Electromagnet) ತಯಾರಿಸಲು ಸೊಲೆನಾಯ್ಡ್‌ನ ಒಳಗಡೆ ಇರಿಸುವ ಅತ್ಯುತ್ತಮ ಕಾಂತೀಯ ವಸ್ತು ಯಾವುದು?",
            options = listOf("ಮೆದು ಕಬ್ಬಿಣ (Soft iron)", "ಉಕ್ಕು", "ಅಲ್ಯೂಮಿನಿಯಂ", "ತಾಮ್ರ"),
            correctAnswer = "ಮೆದು ಕಬ್ಬಿಣ (Soft iron)",
            explanation = "ಮೆದು ಕಬ್ಬಿಣವು ಸುಲಭವಾಗಿ ಪ್ರಬಲವಾಗಿ ಕಾಂತೀಯಗೊಳ್ಳುತ್ತದೆ ಮತ್ತು ವಿದ್ಯುತ್ ನಿಲ್ಲಿಸಿದಾಗ ತಕ್ಷಣ ಕಾಂತತ್ವವನ್ನು ಕಳೆದುಕೊಳ್ಳುತ್ತದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 14: ಶಕ್ತಿಯ ಆಕರಗಳು
    // ========================================================
    private val u14Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u14_1",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ನವೀಕರಿಸಲಾಗದ ಪಳೆಯುಳಿಕೆ ಇಂಧನವಾಗಿದೆ?",
            options = listOf("ಕಲ್ಲಿದ್ದಲು ಮತ್ತು ಪೆಟ್ರೋಲಿಯಂ", "ಸೌರ ಶಕ್ತಿ", "ಪವನ ಶಕ್ತಿ", "ಜೈವಿಕ ಅನಿಲ"),
            correctAnswer = "ಕಲ್ಲಿದ್ದಲು ಮತ್ತು ಪೆಟ್ರೋಲಿಯಂ",
            explanation = "ಕಲ್ಲಿದ್ದಲು ಮತ್ತು ಪೆಟ್ರೋಲಿಯಂಗಳು ಸೀಮಿತ ಪ್ರಮಾಣದಲ್ಲಿದ್ದು ಪುನರುತ್ಪತ್ತಿಗೆ ಲಕ್ಷಾಂತರ ವರ್ಷಗಳು ಬೇಕಾಗುವುದರಿಂದ ನವೀಕರಿಸಲಾಗದ ಇಂಧನಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_2",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಜೈವಿಕ ಅನಿಲದ (Biogas / Gobar gas) ಪ್ರಮುಖ ಘಟಕ ಯಾವುದು?",
            options = listOf("ಮೀಥೇನ್ (ಸುಮಾರು 75% CH4)", "ಹೈಡ್ರೋಜನ್", "ಈಥೇನ್", "ಕಾರ್ಬನ್ ಮೊನಾಕ್ಸೈಡ್"),
            correctAnswer = "ಮೀಥೇನ್ (ಸುಮಾರು 75% CH4)",
            explanation = "ಬಯೋಗ್ಯಾಸ್‌ನಲ್ಲಿ ಸುಮಾರು 75% ನಷ್ಟು ಮೀಥೇನ್ ಅನಿಲವಿರುತ್ತದೆ, ಇದು ಅತ್ಯುತ್ತಮ ಹೊಗೆರಹಿತ ಇಂಧನವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_3",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಪವನ ವಿದ್ಯುತ್ ಜನರೇಟರ್‌ನಲ್ಲಿ ಟರ್ಬೈನ್ ತಿರುಗಿಸಲು ಗಾಳಿಯ ಕನಿಷ್ಠ ವೇಗ ಎಷ್ಟಿರಬೇಕು?",
            options = listOf("15 km/h", "5 km/h", "30 km/h", "50 km/h"),
            correctAnswer = "15 km/h",
            explanation = "ಪವನ ಶಕ್ತಿಯಿಂದ ಪರಿಣಾಮಕಾರಿಯಾಗಿ ವಿದ್ಯುತ್ ಉತ್ಪಾದಿಸಲು ಗಾಳಿಯ ವೇಗ ಕನಿಷ್ಠ 15 ಕಿ.ಮೀ/ಗಂಟೆ ಇರಬೇಕು."
        ),
        QuestionModel(
            id = "s_10_sci_u14_4",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ವಿಶ್ವದಲ್ಲಿ 'ಗಾಳಿಗಳ ದೇಶ' (Country of Winds) ಎಂದು ಕರೆಯಲ್ಪಡುವ ದೇಶ ಯಾವುದು?",
            options = listOf("ಡೆನ್ಮಾರ್ಕ್ (Denmark)", "ಭಾರತ", "ಜರ್ಮನಿ", "ನೆದರ್ಲ್ಯಾಂಡ್ಸ್"),
            correctAnswer = "ಡೆನ್ಮಾರ್ಕ್ (Denmark)",
            explanation = "ಡೆನ್ಮಾರ್ಕ್ ತನ್ನ ಒಟ್ಟು ವಿದ್ಯುತ್ ಬೇಡಿಕೆಯ 25% ಕ್ಕಿಂತ ಹೆಚ್ಚು ಭಾಗವನ್ನು ಪವನ ಶಕ್ತಿಯಿಂದ ಉತ್ಪಾದಿಸುವುದರಿಂದ ಈ ಹೆಸರು ಪಡೆದಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_5",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಸೌರ ಕೋಶಗಳನ್ನು (Solar cells) ತಯಾರಿಸಲು ವ್ಯಾಪಕವಾಗಿ ಬಳಸುವ ಅರೆವಾಹಕ ಧಾತು ಯಾವುದು?",
            options = listOf("ಸಿಲಿಕಾನ್ (Silicon)", "ತಾಮ್ರ", "ಕಬ್ಬಿಣ", "ಅಲ್ಯೂಮಿನಿಯಂ"),
            correctAnswer = "ಸಿಲಿಕಾನ್ (Silicon)",
            explanation = "ಸಿಲಿಕಾನ್ ಅರೆವಾಹಕವಾಗಿದ್ದು ಸೂರ್ಯನ ಬೆಳಕಿನ ಶಕ್ತಿಯನ್ನು ನೇರವಾಗಿ ವಿದ್ಯುತ್ ಶಕ್ತಿಯನ್ನಾಗಿ ಪರಿವರ್ತಿಸಲು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_6",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಬಾಕ್ಸ್ ಮಾದರಿಯ ಸೌರ ಕುಕ್ಕರ್‌ನಲ್ಲಿ ಹಸಿರುಮನೆ ಪರಿಣಾಮದಿಂದ ಶಾಖವನ್ನು ಹಿಡಿದಿಟ್ಟುಕೊಳ್ಳಲು ಮೇಲ್ಭಾಗದಲ್ಲಿ ಏನನ್ನು ಮುಚ್ಚಲಾಗುತ್ತದೆ?",
            options = listOf("ಗಾಜಿನ ಹಾಳೆ (Glass sheet)", "ಕನ್ನಡಿ", "ಪ್ಲಾಸ್ಟಿಕ್ ಹಾಳೆ", "ಕಬ್ಬಿಣದ ಹಾಳೆ"),
            correctAnswer = "ಗಾಜಿನ ಹಾಳೆ (Glass sheet)",
            explanation = "ಗಾಜಿನ ಮುಚ್ಚಳವು ಸೂರ್ಯನ ವಿಕಿರಣ ಒಳಬರಲು ಬಿಡುತ್ತದೆ ಆದರೆ ಹೊರಸೂಸುವ ಅತಿಗೆಂಪು ಶಾಖವನ್ನು ಹೊರಹೋಗದಂತೆ ತಡೆದು ತಾಪವನ್ನು ಹೆಚ್ಚಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_7",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಸಾಗರ ಉಷ್ಣ ಶಕ್ತಿ ಪರಿವರ್ತನಾ (OTEC) ಸ್ಥಾವರ ಕಾರ್ಯನಿರ್ವಹಿಸಲು ಮೇಲ್ಮೈ ನೀರು ಮತ್ತು 2 ಕಿ.ಮೀ ಆಳದ ನೀರಿನ ನಡುವಿನ ಕನಿಷ್ಠ ತಾಪಮಾನ ವ್ಯತ್ಯಾಸ ಎಷ್ಟಿರಬೇಕು?",
            options = listOf("20°C ಅಥವಾ ಹೆಚ್ಚು", "10°C", "5°C", "50°C"),
            correctAnswer = "20°C ಅಥವಾ ಹೆಚ್ಚು",
            explanation = "OTEC ಯಂತ್ರದಲ್ಲಿ ದ್ರವ ಅಮೋನಿಯಾವನ್ನು ಕುದಿಸಿ ಟರ್ಬೈನ್ ತಿರುಗಿಸಲು ಮೇಲ್ಮೈ ಮತ್ತು ಆಳದ ನೀರಿನ ನಡುವೆ ಕನಿಷ್ಠ 20°C (20 K) ತಾಪಮಾನದ ವ್ಯತ್ಯಾಸವಿರಬೇಕು."
        ),
        QuestionModel(
            id = "s_10_sci_u14_8",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಭೂಮಿಯ ಆಳದಲ್ಲಿ ಶಿಲೆಗಳ ಕರಗುವಿಕೆಯಿಂದ ಉತ್ಪತ್ತಿಯಾಗುವ ಆವಿ ಮತ್ತು ಶಾಖದಿಂದ ಪಡೆಯುವ ಶಕ್ತಿ ಯಾವುದು?",
            options = listOf("ಭೂಶಾಖದ ಶಕ್ತಿ (Geothermal energy)", "ಉಬ್ಬರವಿಳಿತದ ಶಕ್ತಿ", "ಪರಮಾಣು ಶಕ್ತಿ", "ಜೈವಿಕ ಶಕ್ತಿ"),
            correctAnswer = "ಭೂಶಾಖದ ಶಕ್ತಿ (Geothermal energy)",
            explanation = "ಭೂಮಿಯ ಒಳಗಿನ ಬಿಸಿಯಾದ ತಾಣಗಳಿಂದ (Hot spots) ಬರುವ ಹಬೆಯಿಂದ ಟರ್ಬೈನ್ ತಿರುಗಿಸಿ ವಿದ್ಯುತ್ ಪಡೆಯುವುದೇ ಭೂಶಾಖ ಶಕ್ತಿ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_9",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಪರಮಾಣು ವಿದ್ಯುತ್ ಸ್ಥಾವರಗಳಲ್ಲಿ ನಿಯಂತ್ರಿತ ವಿದಳನ ಕ್ರಿಯೆಗೆ (Nuclear fission) ಇಂಧನವಾಗಿ ಬಳಸುವ ವಿಕಿರಣಶೀಲ ಧಾತು ಯಾವುದು?",
            options = listOf("ಯುರೇನಿಯಂ (U-235)", "ಕಬ್ಬಿಣ", "ಹೈಡ್ರೋಜನ್", "ಕಲ್ಲಿದ್ದಲು"),
            correctAnswer = "ಯುರೇನಿಯಂ (U-235)",
            explanation = "ಯುರೇನಿಯಂ-235, ಪ್ಲುಟೋನಿಯಂ ಅಥವಾ ಥೋರಿಯಂ ಪರಮಾಣು ಬೀಜಗಳನ್ನು ವಿದಳನಗೊಳಿಸಿ ಅಗಾಧ ಶಕ್ತಿಯನ್ನು ಪಡೆಯಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_10",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಸೂರ್ಯ ಮತ್ತು ನಕ್ಷತ್ರಗಳಲ್ಲಿ ನಿರಂತರವಾಗಿ ಅಗಾಧ ಶಕ್ತಿಯು ಉತ್ಪತ್ತಿಯಾಗಲು ಕಾರಣವಾದ ಕ್ರಿಯೆ ಯಾವುದು?",
            options = listOf("ಪರಮಾಣು ಸಮ್ಮಿಲನ ಕ್ರಿಯೆ (Nuclear fusion)", "ಪರಮಾಣು ವಿದಳನ ಕ್ರಿಯೆ", "ರಾಸಾಯನಿಕ ದಹನ ಕ್ರಿಯೆ", "ವಿಕಿರಣ ಕ್ಷಯ"),
            correctAnswer = "ಪರಮಾಣು ಸಮ್ಮಿಲನ ಕ್ರಿಯೆ (Nuclear fusion)",
            explanation = "ಲಘು ಹೈಡ್ರೋಜನ್ ಪರಮಾಣು ಬೀಜಗಳು ಅತೀವ ತಾಪ-ಒತ್ತಡದಲ್ಲಿ ಸಮ್ಮಿಲನಗೊಂಡು ಹೀಲಿಯಂ ಆಗುವಾಗ ಅಗಾಧ ಶಕ್ತಿ ಬಿಡುಗಡೆಯಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_11",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಜಲವಿದ್ಯುತ್ ಸ್ಥಾವರಗಳಲ್ಲಿ (Hydroelectric plants) ಆಣೆಕಟ್ಟಿನಲ್ಲಿ ಶೇಖರಿಸಲ್ಪಟ್ಟ ನೀರಿನ ಯಾವ ಶಕ್ತಿಯು ವಿದ್ಯುತ್ ಶಕ್ತಿಯಾಗಿ ಪರಿವರ್ತನೆಯಾಗುತ್ತದೆ?",
            options = listOf("ಪ್ರಚ್ಛನ್ನ ಶಕ್ತಿಯು ಚಲನ ಶಕ್ತಿಯಾಗಿ ನಂತರ ವಿದ್ಯುತ್ ಶಕ್ತಿಯಾಗಿ", "ರಾಸಾಯನಿಕ ಶಕ್ತಿಯು ವಿದ್ಯುತ್ ಆಗಿ", "ಶಾಖ ಶಕ್ತಿಯು ಯಾಂತ್ರಿಕ ಶಕ್ತಿಯಾಗಿ", "ಕಾಂತೀಯ ಶಕ್ತಿಯಾಗಿ"),
            correctAnswer = "ಪ್ರಚ್ಛನ್ನ ಶಕ್ತಿಯು ಚಲನ ಶಕ್ತಿಯಾಗಿ ನಂತರ ವಿದ್ಯುತ್ ಶಕ್ತಿಯಾಗಿ",
            explanation = "ಎತ್ತರದಲ್ಲಿ ಸಂಗ್ರಹಿಸಿದ ನೀರಿನ ಪ್ರಚ್ಛನ್ನ ಶಕ್ತಿಯು ವೇಗವಾಗಿ ಹರಿಯುವಾಗ ಚಲನ ಶಕ್ತಿಯಾಗಿ ಟರ್ಬೈನ್ ತಿರುಗಿಸಿ ವಿದ್ಯುತ್ ಉತ್ಪಾದಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_12",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಉತ್ತಮ ಇಂಧನದ ಪ್ರಮುಖ ಲಕ್ಷಣಗಳಲ್ಲಿ ಯಾವುದು ಸರಿಯಾಗಿದೆ?",
            options = listOf("ಹೆಚ್ಚಿನ ಕ್ಯಾಲೋರಿಫಿಕ್ ಮೌಲ್ಯ ಮತ್ತು ಕಡಿಮೆ ಹೊಗೆ ಉತ್ಪಾದಿಸಬೇಕು", "ಕಡಿಮೆ ಕ್ಯಾಲೋರಿಫಿಕ್ ಮೌಲ್ಯ ಹೊಂದಿರಬೇಕು", "ಹೆಚ್ಚಿನ ಪ್ರಮಾಣದ ಬೂದಿ ಉಳಿಸಬೇಕು", "ಅತಿ ಕಡಿಮೆ ಉಷ್ಣತೆಯಲ್ಲಿ ಉರಿಯಬೇಕು"),
            correctAnswer = "ಹೆಚ್ಚಿನ ಕ್ಯಾಲೋರಿಫಿಕ್ ಮೌಲ್ಯ ಮತ್ತು ಕಡಿಮೆ ಹೊಗೆ ಉತ್ಪಾದಿಸಬೇಕು",
            explanation = "ಆದರ್ಶ ಇಂಧನವು ಏಕಮಾನ ರಾಶಿಗೆ ಹೆಚ್ಚಿನ ಶಾಖ ನೀಡಬೇಕು ಮತ್ತು ಪರಿಸರ ಮಾಲಿನ್ಯವನ್ನು ಉಂಟುಮಾಡಬಾರದು."
        ),
        QuestionModel(
            id = "s_10_sci_u14_13",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಸಿಎನ್‌ಜಿ (CNG - Compressed Natural Gas) ಯ ಪ್ರಮುಖ ಘಟಕ ಯಾವುದು?",
            options = listOf("ಮೀಥೇನ್", "ಬ್ಯುಟೇನ್", "ಪ್ರೊಪೇನ್", "ಹೈಡ್ರೋಜನ್"),
            correctAnswer = "ಮೀಥೇನ್",
            explanation = "ಸಂಕುಚಿತ ನೈಸರ್ಗಿಕ ಅನಿಲದ ಮುಖ್ಯ ಘಟಕ ಮೀಥೇನ್ ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_14",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಎಲ್‌ಪಿಜಿ (LPG) ಯ ಪ್ರಮುಖ ಘಟಕ ಯಾವುದು ಮತ್ತು ಸೋರಿಕೆಯನ್ನು ಪತ್ತೆಹಚ್ಚಲು ಬೆರೆಸುವ ವಾಸನೆಯುಕ್ತ ರಾಸಾಯನಿಕ ಯಾವುದು?",
            options = listOf("ಬ್ಯುಟೇನ್ - ಈಥೈಲ್ ಮರ್ಕ್ಯಾಪ್ಟನ್", "ಮೀಥೇನ್ - ಕ್ಲೋರಿನ್", "ಈಥೇನ್ - ಸಲ್ಫರ್", "ಪ್ರೊಪೇನ್ - ಆಕ್ಸಿಜನ್"),
            correctAnswer = "ಬ್ಯುಟೇನ್ - ಈಥೈಲ್ ಮರ್ಕ್ಯಾಪ್ಟನ್",
            explanation = "ದ್ರವೀಕೃತ ಪೆಟ್ರೋಲಿಯಂ ಅನಿಲದ ಮುಖ್ಯ ಘಟಕ ಬ್ಯುಟೇನ್. ಸೋರಿಕೆ ವಾಸನೆಗಾಗಿ ಈಥೈಲ್ ಮರ್ಕ್ಯಾಪ್ಟನ್ ಸೇರಿಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u14_15",
            stdId = 10,
            subjectId = "science",
            unitId = 14,
            type = "MCQ",
            questionText = "ಪರಮಾಣು ತ್ಯಾಜ್ಯ ವಿಲೇವಾರಿಯ ಅತ್ಯಂತ ಗಂಭೀರವಾದ ಅಪಾಯವೇನು?",
            options = listOf("ಪರಿಸರದಲ್ಲಿ ದೀರ್ಘಕಾಲಿಕ ಹಾನಿಕಾರಕ ವಿಕಿರಣಗಳ ಹೊರಸೂಸುವಿಕೆ", "ಹೆಚ್ಚಿನ ಹೊಗೆ ಉಂಟಾಗುವುದು", "ನೀರಿನ ಕೊರತೆ", "ಅತಿಯಾದ ಶಬ್ದ"),
            correctAnswer = "ಪರಿಸರದಲ್ಲಿ ದೀರ್ಘಕಾಲಿಕ ಹಾನಿಕಾರಕ ವಿಕಿರಣಗಳ ಹೊರಸೂಸುವಿಕೆ",
            explanation = "ಪರಮಾಣು ತ್ಯಾಜ್ಯವು ಅಪಾಯಕಾರಿ ವಿಕಿರಣಗಳನ್ನು ಹೊರಸೂಸುವುದರಿಂದ ಜೀವಕೋಶಗಳಲ್ಲಿ ಕ್ಯಾನ್ಸರ್ ಮತ್ತು ರೂಪಾಂತರಗಳನ್ನು ಉಂಟುಮಾಡುತ್ತದೆ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 15: ನಮ್ಮ ಪರಿಸರ
    // ========================================================
    private val u15Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u15_1",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಈ ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಯಾವುದು ಜೈವಿಕ ವಿಘಟನೆ ಹೊಂದುವ (Biodegradable) ತ್ಯಾಜ್ಯಗಳ ಗುಂಪಾಗಿದೆ?",
            options = listOf("ಹುಲ್ಲು, ಹೂವುಗಳು ಮತ್ತು ಚರ್ಮದ ಚೂರುಗಳು", "ಪ್ಲಾಸ್ಟಿಕ್, ಗಾಜು ಮತ್ತು ರಬ್ಬರ್", "ಡಿಡಿಟಿ, ಕೀಟನಾಶಕಗಳು ಮತ್ತು ಪ್ಲಾಸ್ಟಿಕ್", "ಅಲ್ಯೂಮಿನಿಯಂ ಡಬ್ಬಿ, ಗಾಜು ಮತ್ತು ಪಾಲಿಥಿನ್"),
            correctAnswer = "ಹುಲ್ಲು, ಹೂವುಗಳು ಮತ್ತು ಚರ್ಮದ ಚೂರುಗಳು",
            explanation = "ನೈಸರ್ಗಿಕ ಸೂಕ್ಷ್ಮಜೀವಿಗಳ ಜೈವಿಕ ಕ್ರಿಯೆಯಿಂದ ಸರಳ ವಸ್ತುಗಳಾಗಿ ಕೊಳೆಯುವ ಪದಾರ್ಥಗಳು ಜೈವಿಕ ವಿಘಟನೀಯ ವಸ್ತುಗಳಾಗಿವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u15_2",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಆಹಾರ ಸರಪಳಿಯಲ್ಲಿ ಪ್ರತಿಯೊಂದು ಹಂತವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಪೋಷಣಾ ಸ್ತರ (Trophic level)", "ಪರಿಸರ ವ್ಯವಸ್ಥೆ", "ಜೈವಿಕ ಸ್ತರ", "ಆಹಾರ ಜಾಲ"),
            correctAnswer = "ಪೋಷಣಾ ಸ್ತರ (Trophic level)",
            explanation = "ಆಹಾರ ಸರಪಳಿಯಲ್ಲಿ ಶಕ್ತಿ ವರ್ಗಾವಣೆಯ ಪ್ರತಿಯೊಂದು ಹಂತವನ್ನು ಪೋಷಣಾ ಸ್ತರ ಎನ್ನುತ್ತಾರೆ (ಉತ್ಪಾದಕಗಳು, ಪ್ರಾಥಮಿಕ ಗ್ರಾಹಕಗಳು, ಇತ್ಯಾದಿ)."
        ),
        QuestionModel(
            id = "s_10_sci_u15_3",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಆಹಾರ ಸರಪಳಿಯ ಮೊದಲ ಪೋಷಣಾ ಸ್ತರದಲ್ಲಿ ಯಾವಾಗಲೂ ಯಾವ ಜೀವಿಗಳು ಇರುತ್ತವೆ?",
            options = listOf("ಉತ್ಪಾದಕಗಳು (ಹಸಿರು ಸಸ್ಯಗಳು)", "ಸಸ್ಯಾಹಾರಿಗಳು", "ಮಾಂಸಾಹಾರಿಗಳು", "ವಿಘಟಕಗಳು"),
            correctAnswer = "ಉತ್ಪಾದಕಗಳು (ಹಸಿರು ಸಸ್ಯಗಳು)",
            explanation = "ಸೂರ್ಯನ ಬೆಳಕನ್ನು ಬಳಸಿಕೊಂಡು ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಯಿಂದ ಆಹಾರ ತಯಾರಿಸುವ ಸ್ವಪೋಷಕಗಳೇ ಉತ್ಪಾದಕಗಳು."
        ),
        QuestionModel(
            id = "s_10_sci_u15_4",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಆಹಾರ ಸರಪಳಿಯಲ್ಲಿ ಒಂದು ಪೋಷಣಾ ಸ್ತರದಿಂದ ಮುಂದಿನ ಪೋಷಣಾ ಸ್ತರಕ್ಕೆ ವರ್ಗಾವಣೆಯಾಗುವ ಶಕ್ತಿಯ ಶೇಕಡಾವಾರು ಪ್ರಮಾಣ ಎಷ್ಟು?",
            options = listOf("10%", "1%", "50%", "90%"),
            correctAnswer = "10%",
            explanation = "ಲಿಂಡೆಮನ್‌ನ 10% ನಿಯಮದ ಪ್ರಕಾರ ಕೇವಲ 10% ಸಾವಯವ ಶಕ್ತಿ ಮಾತ್ರ ಮುಂದಿನ ಹಂತಕ್ಕೆ ಲಭ್ಯವಾಗುತ್ತದೆ; ಉಳಿದ 90% ಜೀವರಕ್ಷಣೆ ಮತ್ತು ಶಾಖವಾಗಿ ನಷ್ಟವಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u15_5",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಹಸಿರು ಸಸ್ಯಗಳು ತಮ್ಮ ಎಲೆಗಳ ಮೇಲೆ ಬೀಳುವ ಸೂರ್ಯನ ಬೆಳಕಿನ ಶಕ್ತಿಯ ಎಷ್ಟು ಶೇಕಡಾವನ್ನು ಮಾತ್ರ ಆಹಾರ ಶಕ್ತಿಯನ್ನಾಗಿ ಪರಿವರ್ತಿಸುತ್ತವೆ?",
            options = listOf("ಸುಮಾರು 1%", "10%", "25%", "50%"),
            correctAnswer = "ಸುಮಾರು 1%",
            explanation = "ಭೂಮಿಯ ಮೇಲಿನ ಹಸಿರು ಸಸ್ಯಗಳು ಒಟ್ಟು ಸೌರ ಶಕ್ತಿಯ ಕೇವಲ 1% ನಷ್ಟು ಭಾಗವನ್ನು ಮಾತ್ರ ದ್ಯುತಿಸಂಶ್ಲೇಷಣೆಯಲ್ಲಿ ಬಳಸಿಕೊಳ್ಳುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u15_6",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಆಹಾರ ಸರಪಳಿಯಲ್ಲಿ ಪ್ರತಿ ಪೋಷಣಾ ಸ್ತರದಲ್ಲೂ ಜೈವಿಕ ವಿಘಟನೆಯಾಗದ ಕೀಟನಾಶಕಗಳ (ಡಿಡಿಟಿ) ಸಾಂದ್ರತೆ ಹೆಚ್ಚಾಗುವ ಪ್ರಕ್ರಿಯೆಗೆ ಏನೆನ್ನುವರು?",
            options = listOf("ಜೈವಿಕ ವರ್ಧನೆ (Biological magnification)", "ಯುಟ್ರೋಫಿಕೇಶನ್", "ಜೈವಿಕ ಸಂರಕ್ಷಣೆ", "ಮಾಲಿನ್ಯ"),
            correctAnswer = "ಜೈವಿಕ ವರ್ಧನೆ (Biological magnification)",
            explanation = "ಕೊಳೆಯದ ರಾಸಾಯನಿಕಗಳು ಪ್ರತಿ ಹಂತದಲ್ಲೂ ಶೇಖರಣೆಯಾಗುತ್ತಾ ಸರ್ವೋಚ್ಚ ಗ್ರಾಹಕನಲ್ಲಿ (ಮಾನವನಲ್ಲಿ) ಗರಿಷ್ಠ ಪ್ರಮಾಣದಲ್ಲಿ ತಲುಪುವುದೇ ಜೈವಿಕ ವರ್ಧನೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u15_7",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಓಝೋನ್ ಅಣುವಿನಲ್ಲಿರುವ ಆಮ್ಲಜನಕದ ಪರಮಾಣುಗಳ ಸಂಖ್ಯೆ ಎಷ್ಟು ಮತ್ತು ಅದರ ಸೂತ್ರ ಯಾವುದು?",
            options = listOf("3 ಪರಮಾಣುಗಳು - O3", "2 ಪರಮಾಣುಗಳು - O2", "1 ಪರಮಾಣು - O", "4 ಪರಮಾಣುಗಳು - O4"),
            correctAnswer = "3 ಪರಮಾಣುಗಳು - O3",
            explanation = "ಓಝೋನ್ ಮೂರು ಆಕ್ಸಿಜನ್ ಪರಮಾಣುಗಳಿಂದಾದ ಅಣುವಾಗಿದೆ (O3)."
        ),
        QuestionModel(
            id = "s_10_sci_u15_8",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ವಾತಾವರಣದ ಮೇಲ್ಪದರದಲ್ಲಿರುವ ಓಝೋನ್ ಪದರವು ಭೂಮಿಯನ್ನು ಸೂರ್ಯನ ಯಾವ ಅಪಾಯಕಾರಿ ವಿಕಿರಣಗಳಿಂದ ರಕ್ಷಿಸುತ್ತದೆ?",
            options = listOf("ನೇರಳಾತೀತ ವಿಕಿರಣಗಳು (UV rays)", "ಅತಿಗೆಂಪು ವಿಕಿರಣಗಳು", "ಕ್ಷ-ಕಿರಣಗಳು", "ಗಾಮಾ ಕಿರಣಗಳು"),
            correctAnswer = "ನೇರಳಾತೀತ ವಿಕಿರಣಗಳು (UV rays)",
            explanation = "ಓಝೋನ್ ಪದರವು ಹಾನಿಕಾರಕ ಯುವಿ ಕಿರಣಗಳನ್ನು ತಡೆದು ಚರ್ಮದ ಕ್ಯಾನ್ಸರ್ ಮತ್ತು ಕಣ್ಣಿನ ಪೊರೆಗಳಿಂದ ಜೀವರಾಶಿಯನ್ನು ರಕ್ಷಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u15_9",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ರೆಫ್ರಿಜರೇಟರ್ ಮತ್ತು ಅಗ್ನಿಶಾಮಕಗಳಲ್ಲಿ ಬಳಸಲಾಗುವ ಓಝೋನ್ ಸವಕಳಿಗೆ ಕಾರಣವಾದ ಮುಖ್ಯ ಮಾನವ ನಿರ್ಮಿತ ರಾಸಾಯನಿಕ ಯಾವುದು?",
            options = listOf("ಕ್ಲೋರೋಫ್ಲೋರೋ ಕಾರ್ಬನ್‌ಗಳು (CFCs)", "ಕಾರ್ಬನ್ ಡೈಆಕ್ಸೈಡ್", "ಮೀಥೇನ್", "ಸಲ್ಫರ್ ಡೈಆಕ್ಸೈಡ್"),
            correctAnswer = "ಕ್ಲೋರೋಫ್ಲೋರೋ ಕಾರ್ಬನ್‌ಗಳು (CFCs)",
            explanation = "CFC ಗಳು ಸ್ಟ್ರಾಟೋಸ್ಪಿಯರ್‌ನಲ್ಲಿ ಕ್ಲೋರಿನ್ ಪರಮಾಣುಗಳನ್ನು ಬಿಡುಗಡೆ ಮಾಡಿ ಓಝೋನ್ ಕವಚವನ್ನು ನಾಶಪಡಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u15_10",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ವಿಶ್ವಸಂಸ್ಥೆಯ ಪರಿಸರ ಕಾರ್ಯಕ್ರಮವು (UNEP) ಸಿಎಫ್‌ಸಿ ಉತ್ಪಾದನೆಯನ್ನು 1986 ರ ಮಟ್ಟದಲ್ಲೇ ಸ್ಥಗಿತಗೊಳಿಸಲು ಒಪ್ಪಂದ ರೂಪಿಸಿದ ವರ್ಷ ಯಾವುದು?",
            options = listOf("1987 (ಮಾಂಟ್ರಿಯಲ್ ಪ್ರೋಟೋಕಾಲ್)", "1992", "1980", "2000"),
            correctAnswer = "1987 (ಮಾಂಟ್ರಿಯಲ್ ಪ್ರೋಟೋಕಾಲ್)",
            explanation = "1987 ರಲ್ಲಿ UNEP ಜಾಗತಿಕ ಒಪ್ಪಂದದ ಮೂಲಕ CFC ಉತ್ಪಾದನೆಯನ್ನು ತಡೆಹಿಡಿಯಿತು."
        ),
        QuestionModel(
            id = "s_10_sci_u15_11",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಒಂದು ಸರಳ ಹುಲ್ಲುಗಾವಲು ಪರಿಸರ ವ್ಯವಸ್ಥೆಯಲ್ಲಿ ಸರಿಯಾದ ಆಹಾರ ಸರಪಳಿ ಯಾವುದು?",
            options = listOf("ಹುಲ್ಲು -> ಜಿಂಕೆ -> ಹುಲಿ", "ಹುಲ್ಲು -> ಕಪ್ಪೆ -> ಕೀಟ -> ಹಾವು", "ಹುಲಿ -> ಹುಲ್ಲು -> ಜಿಂಕೆ", "ಕೀಟ -> ಹುಲ್ಲು -> ಹದ್ದು"),
            correctAnswer = "ಹುಲ್ಲು -> ಜಿಂಕೆ -> ಹುಲಿ",
            explanation = "ಉತ್ಪಾದಕ (ಹುಲ್ಲು) ವನ್ನು ಸಸ್ಯಾಹಾರಿ (ಜಿಂಕೆ) ತಿನ್ನುತ್ತದೆ, ಅದನ್ನು ಉನ್ನತ ಮಾಂಸಾಹಾರಿ (ಹುಲಿ) ತಿನ್ನುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u15_12",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಸತ್ತ ಜೀವಿಗಳ ಸಾವಯವ ಪದಾರ್ಥಗಳನ್ನು ವಿಘಟಿಸಿ ಮಣ್ಣಿಗೆ ಪೋಷಕಾಂಶಗಳನ್ನು ಮರುಪೂರಣ ಮಾಡುವ ಜೀವಿಗಳು ಯಾವುವು?",
            options = listOf("ವಿಘಟಕಗಳು (ಬ್ಯಾಕ್ಟೀರಿಯಾ ಮತ್ತು ಶಿಲೀಂಧ್ರಗಳು)", "ಉತ್ಪಾದಕಗಳು", "ಪ್ರಾಥಮಿಕ ಗ್ರಾಹಕಗಳು", "ಪರಾವಲಂಬಿಗಳು"),
            correctAnswer = "ವಿಘಟಕಗಳು (ಬ್ಯಾಕ್ಟೀರಿಯಾ ಮತ್ತು ಶಿಲೀಂಧ್ರಗಳು)",
            explanation = "ವಿಘಟಕಗಳು ತ್ಯಾಜ್ಯವನ್ನು ವಿಭಜಿಸಿ ಪೋಷಕಾಂಶಗಳ ಚಕ್ರೀಕರಣಕ್ಕೆ ಕಾರಣವಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u15_13",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಆಹಾರ ಸರಪಳಿಗಳ ಅಂತರ್-ಸಂಪರ್ಕಿತ ಜಾಲವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಆಹಾರ ಜಾಲ (Food web)", "ಆಹಾರ ಸ್ತರ", "ಪರಿಸರ ಪಿರಮಿಡ್", "ಜೈವಿಕ ಸಮುದಾಯ"),
            correctAnswer = "ಆಹಾರ ಜಾಲ (Food web)",
            explanation = "ನಿಸರ್ಗದಲ್ಲಿ ಹಲವಾರು ಆಹಾರ ಸರಪಳಿಗಳು ಪರಸ್ಪರ ಹೆಣೆದುಕೊಂಡು ಆಹಾರ ಜಾಲವನ್ನು ರೂಪಿಸುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u15_14",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ಪರಿಸರ ವ್ಯವಸ್ಥೆಯಲ್ಲಿ ಶಕ್ತಿಯ ಹರಿವು ಯಾವಾಗಲೂ ಯಾವ ರೀತಿಯಾಗಿರುತ್ತದೆ?",
            options = listOf("ಏಕಮುಖವಾಗಿರುತ್ತದೆ (Unidirectional)", "ದ್ವಿಮುಖವಾಗಿರುತ್ತದೆ", "ಚಕ್ರೀಯವಾಗಿರುತ್ತದೆ", "ಬಹುಮುಖವಾಗಿರುತ್ತದೆ"),
            correctAnswer = "ಏಕಮುಖವಾಗಿರುತ್ತದೆ (Unidirectional)",
            explanation = "ಸೂರ್ಯನಿಂದ ಸಸ್ಯಗಳಿಗೆ, ಸಸ್ಯಗಳಿಂದ ಪ್ರಾಣಿಗಳಿಗೆ ಹರಿಯುವ ಶಕ್ತಿಯು ಎಂದಿಗೂ ಹಿಮ್ಮುಖವಾಗಿ ಹಿಂದಿರುಗಲಾರದು (ಏಕಮುಖ ಹರಿವು)."
        ),
        QuestionModel(
            id = "s_10_sci_u15_15",
            stdId = 10,
            subjectId = "science",
            unitId = 15,
            type = "MCQ",
            questionText = "ನಗರಗಳಲ್ಲಿ ತ್ಯಾಜ್ಯ ವಿಲೇವಾರಿಗೆ ಅತ್ಯಂತ ಪರಿಸರಸ್ನೇಹಿ ವಿಧಾನ ಯಾವುದು?",
            options = listOf("ತ್ಯಾಜ್ಯವನ್ನು ಹಸಿ ಮತ್ತು ಒಣ ತ್ಯಾಜ್ಯವಾಗಿ ಪ್ರತ್ಯೇಕಿಸಿ ಗೊಬ್ಬರ ಮತ್ತು ಮರುಚಕ್ರೀಕರಣ ಮಾಡುವುದು", "ತ್ಯಾಜ್ಯವನ್ನು ನದಿಗೆ ಎಸೆಯುವುದು", "ತೆರೆದ ಜಾಗದಲ್ಲಿ ಸುಡುವುದು", "ಭೂಮಿಯಲ್ಲಿ ಹೂತುಹಾಕುವುದು"),
            correctAnswer = "ತ್ಯಾಜ್ಯವನ್ನು ಹಸಿ ಮತ್ತು ಒಣ ತ್ಯಾಜ್ಯವಾಗಿ ಪ್ರತ್ಯೇಕಿಸಿ ಗೊಬ್ಬರ ಮತ್ತು ಮರುಚಕ್ರೀಕರಣ ಮಾಡುವುದು",
            explanation = "ಮೂಲದಲ್ಲೇ ವಿಂಗಡಣೆ ಮಾಡಿ ಜೈವಿಕ ತ್ಯಾಜ್ಯವನ್ನು ಕಾಂಪೋಸ್ಟ್ ಮಾಡುವುದು ಮತ್ತು ಒಣ ತ್ಯಾಜ್ಯವನ್ನು ಮರುಬಳಸುವುದು ಉತ್ತಮ ಪದ್ಧತಿ."
        )
    )

    // ========================================================
    // 🟦 ಅಧ್ಯಾಯ 16: ನೈಸರ್ಗಿಕ ಸಂಪನ್ಮೂಲಗಳ ಸುಸ್ಥಿರ ನಿರ್ವಹಣೆ
    // ========================================================
    private val u16Questions = listOf(
        QuestionModel(
            id = "s_10_sci_u16_1",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಪರಿಸರ ಸಂರಕ್ಷಣೆಯ 5 'R' ಸೂತ್ರಗಳಲ್ಲಿ ಮೊದಲ 'Refuse' ನ ಅರ್ಥವೇನು?",
            options = listOf("ಪರಿಸರಕ್ಕೆ ಹಾನಿಯುಂಟುಮಾಡುವ ವಸ್ತುಗಳನ್ನು ಬಳಸಲು ನಿರಾಕರಿಸುವುದು", "ಮರುಬಳಕೆ ಮಾಡುವುದು", "ಕಡಿಮೆ ಮಾಡುವುದು", "ಮರುಉದ್ದೇಶಿಸುವುದು"),
            correctAnswer = "ಪರಿಸರಕ್ಕೆ ಹಾನಿಯುಂಟುಮಾಡುವ ವಸ್ತುಗಳನ್ನು ಬಳಸಲು ನಿರಾಕರಿಸುವುದು",
            explanation = "Refuse ಎಂದರೆ ಒಮ್ಮೆ ಬಳಸಿ ಎಸೆಯುವ ಪ್ಲಾಸ್ಟಿಕ್ ಕವರ್‌ಗಳಂತಹ ಹಾನಿಕಾರಕ ವಸ್ತುಗಳನ್ನು ನಿರಾಕರಿಸುವುದು."
        ),
        QuestionModel(
            id = "s_10_sci_u16_2",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ನೀರಿನ ಮಾಲಿನ್ಯವನ್ನು ಮತ್ತು ರೋಗಾಣುಗಳ ಇರುವಿಕೆಯನ್ನು ಸೂಚಿಸುವ ಮಾನವನ ಕರುಳಿನಲ್ಲಿ ಕಂಡುಬರುವ ಬ್ಯಾಕ್ಟೀರಿಯಾ ಯಾವುದು?",
            options = listOf("ಕೋಲಿಫಾರ್ಮ್ ಬ್ಯಾಕ್ಟೀರಿಯಾ (Coliform bacteria)", "ಲ್ಯಾಕ್ಟೋಬ್ಯಾಸಿಲಸ್", "ರೈಜೋಬಿಯಂ", "ಸ್ಪೈರಿಲಂ"),
            correctAnswer = "ಕೋಲಿಫಾರ್ಮ್ ಬ್ಯಾಕ್ಟೀರಿಯಾ (Coliform bacteria)",
            explanation = "ನೀರಿನಲ್ಲಿ ಕೋಲಿಫಾರ್ಮ್ ಬ್ಯಾಕ್ಟೀರಿಯಾದ ಉಪಸ್ಥಿತಿಯು ಮಲಮೂತ್ರಗಳಿಂದ ನೀರು ಕಲುಷಿತಗೊಂಡಿರುವುದನ್ನು ಸೂಚಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u16_3",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಗಂಗಾ ನದಿಯ ನೀರಿನ ಗುಣಮಟ್ಟ ಸುಧಾರಿಸಲು 'ಗಂಗಾ ಕ್ರಿಯಾ ಯೋಜನೆ' (GAP) ಪ್ರಾರಂಭವಾದ ವರ್ಷ ಯಾವುದು?",
            options = listOf("1985", "1995", "2000", "1975"),
            correctAnswer = "1985",
            explanation = "ಗಂಗಾ ನದಿಯ ತೀವ್ರ ಮಾಲಿನ್ಯ ತಡೆಯಲು 1985 ರಲ್ಲಿ ಗಂಗಾ ಕ್ರಿಯಾ ಯೋಜನೆಯನ್ನು ಜಾರಿಗೆ ತರಲಾಯಿತು."
        ),
        QuestionModel(
            id = "s_10_sci_u16_4",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "1731 ರಲ್ಲಿ ರಾಜಸ್ಥಾನದ ಖೇಜ್ರಿ ಮರಗಳನ್ನು ರಕ್ಷಿಸಲು ಪ್ರಾಣಾರ್ಪಣೆ ಮಾಡಿದ ಮಹಿಳೆ ಯಾರು?",
            options = listOf("ಅಮೃತಾ ದೇವಿ ಬಿಷ್ಣೋಯಿ", "ಮೇಧಾ ಪಾಟ್ಕರ್", "ಗೌರಾ ದೇವಿ", "ಸಾಲಮರದ ತಿಮ್ಮಕ್ಕ"),
            correctAnswer = "ಅಮೃತಾ ದೇವಿ ಬಿಷ್ಣೋಯಿ",
            explanation = "ಅಮೃತಾ ದೇವಿ ಬಿಷ್ಣೋಯಿ ಮತ್ತು 363 ಜನ ಗ್ರಾಮಸ್ಥರು ಖೇಜ್ರಿ ಮರಗಳನ್ನು ಕಡಿಯದಂತೆ ತಬ್ಬಿಕೊಂಡು ತಮ್ಮ ಪ್ರಾಣವನ್ನೇ ಅರ್ಪಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_10_sci_u16_5",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಭಾರತ ಸರ್ಕಾರವು ವನ್ಯಜೀವಿ ಸಂರಕ್ಷಣೆಗಾಗಿ ನೀಡುವ ಅತ್ಯುನ್ನತ ರಾಷ್ಟ್ರೀಯ ಪ್ರಶಸ್ತಿ ಯಾವುದು?",
            options = listOf("ಅಮೃತಾ ದೇವಿ ಬಿಷ್ಣೋಯಿ ರಾಷ್ಟ್ರೀಯ ಪ್ರಶಸ್ತಿ", "ರಾಜೀವ್ ಗಾಂಧಿ ಪ್ರಶಸ್ತಿ", "ಪದ್ಮಶ್ರೀ ಪ್ರಶಸ್ತಿ", "ದ್ರೋಣಾಚಾರ್ಯ ಪ್ರಶಸ್ತಿ"),
            correctAnswer = "ಅಮೃತಾ ದೇವಿ ಬಿಷ್ಣೋಯಿ ರಾಷ್ಟ್ರೀಯ ಪ್ರಶಸ್ತಿ",
            explanation = "ವನ್ಯಜೀವಿಗಳ ಸಂರಕ್ಷಣೆಯಲ್ಲಿ ಶೌರ್ಯ ಮತ್ತು ಸಮರ್ಪಣೆ ಪ್ರದರ್ಶಿಸಿದವರಿಗೆ ಈ ಪ್ರಶಸ್ತಿ ನೀಡಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u16_6",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "1970 ರ ದಶಕದಲ್ಲಿ ಉತ್ತರಾಖಂಡದ ತೆಹ್ರಿ ಗರ್ವಾಲ್‌ನ ರೆನಿ ಗ್ರಾಮದಲ್ಲಿ ಮರಗಳನ್ನು ಅಪ್ಪಿಕೊಂಡು ರಕ್ಷಿಸಿದ ಪ್ರಸಿದ್ಧ ಚಳವಳಿ ಯಾವುದು?",
            options = listOf("ಚಿಪ್ಕೋ ಚಳವಳಿ (Chipko Movement)", "ಅಪ್ಪಿಕೊ ಚಳವಳಿ", "ನರ್ಮದಾ ಬಚಾವೋ ಆಂದೋಲನ", "ಸೈಲೆಂಟ್ ವ್ಯಾಲಿ ಚಳವಳಿ"),
            correctAnswer = "ಚಿಪ್ಕೋ ಚಳವಳಿ (Chipko Movement)",
            explanation = "ಗ್ರಾಮದ ಮಹಿಳೆಯರು ಮರಗಳನ್ನು ತಬ್ಬಿಕೊಂಡು ಗುತ್ತಿಗೆದಾರರು ಮರ ಕಡಿಯದಂತೆ ತಡೆದ ಜನಪ್ರಿಯ ಚಳವಳಿಯೇ ಚಿಪ್ಕೋ ಚಳವಳಿ."
        ),
        QuestionModel(
            id = "s_10_sci_u16_7",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಪಶ್ಚಿಮ ಬಂಗಾಳದ ಮಿಡ್ನಾಪುರ ಜಿಲ್ಲೆಯ ಅರಬಾರಿ ಅರಣ್ಯದಲ್ಲಿ ಸ್ಥಳೀಯರ ಸಹಭಾಗಿತ್ವದಿಂದ ಯಾವ ಮರಗಳ ಕಾಡನ್ನು ಪುನಶ್ಚೇತನಗೊಳಿಸಲಾಯಿತು?",
            options = listOf("ಸಾಲ್ ಮರಗಳು (Sal trees)", "ತೇಗದ ಮರಗಳು", "ಶ್ರೀಗಂಧದ ಮರಗಳು", "ನೀಲಗಿರಿ ಮರಗಳು"),
            correctAnswer = "ಸಾಲ್ ಮರಗಳು (Sal trees)",
            explanation = "ಅರಣ್ಯಾಧಿಕಾರಿ ಎ. ಕೆ. ಬ್ಯಾನರ್ಜಿ ಗ್ರಾಮಸ್ಥರಿಗೆ ಉದ್ಯೋಗ ಮತ್ತು ಉತ್ಪನ್ನಗಳ ಪಾಲು ನೀಡಿ ಅವನತಿಯಲ್ಲಿದ್ದ ಸಾಲ್ ಕಾಡನ್ನು ಉಳಿಸಿದರು."
        ),
        QuestionModel(
            id = "s_10_sci_u16_8",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಕರ್ನಾಟಕದಲ್ಲಿ ಸಾಂಪ್ರದಾಯಿಕವಾಗಿ ಮಳೆ ನೀರು ಕೊಯ್ಲಿಗೆ ಬಳಸುತ್ತಿದ್ದ ಪ್ರಾಚೀನ ರಚನೆಗಳು ಯಾವುವು?",
            options = listOf("ಕಟ್ಟಾಗಳು (Kattas)", "ಖಾದಿನ್‌ಗಳು", "ಕುಲ್ಹ್‌ಗಳು", "ಬಂದಾರಸ್"),
            correctAnswer = "ಕಟ್ಟಾಗಳು (Kattas)",
            explanation = "ಕರ್ನಾಟಕದಲ್ಲಿ ಹಳ್ಳಗಳಿಗೆ ಮಣ್ಣು ಮತ್ತು ಕಲ್ಲುಗಳಿಂದ ತಾತ್ಕಾಲಿಕ ಅಣೆಕಟ್ಟು ಕಟ್ಟಿ ನೀರು ಇಂಗಿಸುವ ಪದ್ಧತಿಗೆ ಕಟ್ಟಾಗಳು ಎನ್ನುವರು."
        ),
        QuestionModel(
            id = "s_10_sci_u16_9",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಹಿಮಾಚಲ ಪ್ರದೇಶದ ಬೆಟ್ಟ ಪ್ರದೇಶಗಳಲ್ಲಿ ಶತಮಾನಗಳಿಂದ ಜಾರಿಯಲ್ಲಿದ್ದ ಸಾಂಪ್ರದಾಯಿಕ ಕಾಲುವೆ ನೀರಾವರಿ ವ್ಯವಸ್ಥೆ ಯಾವುದು?",
            options = listOf("ಕುಲ್ಹ್‌ಗಳು (Kulhs)", "ನಾದಿಗಳು", "ಆಹಾರ್-ಪೈನ್ಸ್", "ಎರಿಸ್"),
            correctAnswer = "ಕುಲ್ಹ್‌ಗಳು (Kulhs)",
            explanation = "ಹಿಮಾಚಲ ಪ್ರದೇಶದಲ್ಲಿ ನೀರ್ಗಲ್ಲು ಕರಗಿದ ನೀರನ್ನು ಹಳ್ಳಿಗಳಿಗೆ ತಿರುಗಿಸಲು ನಿರ್ಮಿಸಿದ ಕಾಲುವೆಗಳೇ ಕುಲ್ಹ್‌ಗಳು."
        ),
        QuestionModel(
            id = "s_10_sci_u16_10",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ರಾಜಸ್ಥಾನದಲ್ಲಿ ಕೃಷಿ ಭೂಮಿಯಲ್ಲಿ ಮಳೆ ನೀರನ್ನು ಹಿಡಿದಿಟ್ಟು ಅಂತರ್ಜಲ ಮರುಪೂರಣ ಮಾಡಲು ಬಳಸುವ ಪ್ರಾಚೀನ ವ್ಯವಸ್ಥೆ ಯಾವುದು?",
            options = listOf("ಖಾದಿನ್ ಮತ್ತು ನಾದಿಗಳು (Khadins & Nadis)", "ಕಟ್ಟಾಗಳು", "ಸುರಂಗಂ", "ತಾಲ್ಸ್"),
            correctAnswer = "ಖಾದಿನ್ ಮತ್ತು ನಾದಿಗಳು (Khadins & Nadis)",
            explanation = "ರಾಜಸ್ಥಾನದ ಮರುಭೂಮಿ ಪ್ರದೇಶದಲ್ಲಿ ಖಾದಿನ್ ಪದ್ಧತಿಯಿಂದ ಮಳೆ ನೀರು ಸಂಗ್ರಹಿಸಿ ತೇವಾಂಶವಿರುವ ನೆಲದಲ್ಲಿ ಬೆಳೆ ಬೆಳೆಯಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u16_11",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಬೃಹತ್ ಅಣೆಕಟ್ಟುಗಳ ನಿರ್ಮಾಣಕ್ಕೆ ಸಂಬಂಧಿಸಿದಂತೆ ಸಾರ್ವಜನಿಕರು ವಿರೋಧಿಸಲು ಕಾರಣವಾದ ಮೂರು ಪ್ರಮುಖ ಸಮಸ್ಯೆಗಳು ಯಾವುವು?",
            options = listOf("ಸಾಮಾಜಿಕ, ಆರ್ಥಿಕ ಮತ್ತು ಪರಿಸರ ಸಮಸ್ಯೆಗಳು", "ಕೇವಲ ವಿದ್ಯುತ್ ಕೊರತೆ", "ಕೇವಲ ನೀರಿನ ಕೊರತೆ", "ಕೇವಲ ಸಾರಿಗೆ ಸಮಸ್ಯೆ"),
            correctAnswer = "ಸಾಮಾಜಿಕ, ಆರ್ಥಿಕ ಮತ್ತು ಪರಿಸರ ಸಮಸ್ಯೆಗಳು",
            explanation = "ಬುಡಕಟ್ಟು ಜನರ ಸ್ಥಳಾಂತರ (ಸಾಮಾಜಿಕ), ಅಪಾರ ವೆಚ್ಚ (ಆರ್ಥಿಕ) ಮತ್ತು ಜೀವವೈವಿಧ್ಯದ ನಾಶ (ಪರಿಸರ ಸಮಸ್ಯೆಗಳು) ಉಂಟಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u16_12",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ನರ್ಮದಾ ನದಿಗೆ ಕಟ್ಟಲಾದ 'ಸರ್ದಾರ್ ಸರೋವರ್' ಅಣೆಕಟ್ಟಿನ ಎತ್ತರ ಹೆಚ್ಚಿಸುವುದರ ವಿರುದ್ಧ ಹೋರಾಡಿದ ಪ್ರಸಿದ್ಧ ಆಂದೋಲನ ಯಾವುದು?",
            options = listOf("ನರ್ಮದಾ ಬಚಾವೋ ಆಂದೋಲನ", "ಚಿಪ್ಕೋ ಚಳವಳಿ", "ಅಪ್ಪಿಕೊ ಚಳವಳಿ", "ಗಂಗಾ ಸಂರಕ್ಷಣೆ"),
            correctAnswer = "ನರ್ಮದಾ ಬಚಾವೋ ಆಂದೋಲನ",
            explanation = "ಮೇಧಾ ಪಾಟ್ಕರ್ ಅವರ ನೇತೃತ್ವದಲ್ಲಿ ಮುಳುಗಡೆ ಸಂತ್ರಸ್ತರ ಪುನರ್ವಸತಿಗಾಗಿ ನಡೆದ ಹೋರಾಟವೇ ನರ್ಮದಾ ಬಚಾವೋ ಆಂದೋಲನ."
        ),
        QuestionModel(
            id = "s_10_sci_u16_13",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಅಂತರ್ಜಲ ಸಂಗ್ರಹಣೆಯ ಪ್ರಮುಖ ಪ್ರಯೋಜನಗಳಲ್ಲಿ ಯಾವುದು ತಪ್ಪಾಗಿದೆ?",
            options = listOf("ಇದು ಸೊಳ್ಳೆಗಳು ಸಂತಾನೋತ್ಪತ್ತಿ ಮಾಡಲು ಅನುಕೂಲ ಮಾಡಿಕೊಡುತ್ತದೆ", "ಇದು ಆವಿಯಾಗುವುದಿಲ್ಲ", "ಇದು ಮಲಮೂತ್ರ ಮತ್ತು ಕಲ್ಮಷಗಳಿಂದ ರಕ್ಷಿಸಲ್ಪಟ್ಟಿರುತ್ತದೆ", "ಇದು ವಿಶಾಲ ಪ್ರದೇಶದ ಬಾವಿಗಳನ್ನು ಮರುಪೂರಣ ಮಾಡುತ್ತದೆ"),
            correctAnswer = "ಇದು ಸೊಳ್ಳೆಗಳು ಸಂತಾನೋತ್ಪತ್ತಿ ಮಾಡಲು ಅನುಕೂಲ ಮಾಡಿಕೊಡುತ್ತದೆ",
            explanation = "ಭೂಮಿಯ ಕೆಳಗೆ ಸಂಗ್ರಹವಾಗುವ ಅಂತರ್ಜಲದಲ್ಲಿ ಸೊಳ್ಳೆಗಳು ಬೆಳೆಯುವುದಿಲ್ಲ, ಇದು ಅಂತರ್ಜಲದ ಮಹತ್ವದ ಪ್ರಯೋಜನವಾಗಿದೆ."
        ),
        QuestionModel(
            id = "s_10_sci_u16_14",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಅರಣ್ಯಗಳ ಸಂರಕ್ಷಣೆಯಲ್ಲಿ 'ಪಾಲುದಾರರು' (Stakeholders) ಎಂದರೆ ಯಾರು?",
            options = listOf("ಅರಣ್ಯದ ಒಳಗಡೆ ಮತ್ತು ಸುತ್ತಮುತ್ತ ವಾಸಿಸುವ ಜನರು, ಅರಣ್ಯ ಇಲಾಖೆ, ಉದ್ಯಮಿಗಳು ಮತ್ತು ಪರಿಸರಾಸಕ್ತರು", "ಕೇವಲ ಗುತ್ತಿಗೆದಾರರು", "ಕೇವಲ ಪ್ರವಾಸಿಗರು", "ಕೇವಲ ನಗರವಾಸಿಗಳು"),
            correctAnswer = "ಅರಣ್ಯದ ಒಳಗಡೆ ಮತ್ತು ಸುತ್ತಮುತ್ತ ವಾಸಿಸುವ ಜನರು, ಅರಣ್ಯ ಇಲಾಖೆ, ಉದ್ಯಮಿಗಳು ಮತ್ತು ಪರಿಸರಾಸಕ್ತರು",
            explanation = "ಅರಣ್ಯ ಸಂಪನ್ಮೂಲಗಳನ್ನು ಅವಲಂಬಿಸಿರುವ ಮತ್ತು ನಿರ್ವಹಿಸುವ ಎಲ್ಲಾ ನಾಲ್ಕು ಗುಂಪುಗಳೇ ಪಾಲುದಾರರು."
        ),
        QuestionModel(
            id = "s_10_sci_u16_15",
            stdId = 10,
            subjectId = "science",
            unitId = 16,
            type = "MCQ",
            questionText = "ಸುಸ್ಥಿರ ಅಭಿವೃದ್ಧಿಯ (Sustainable Development) ಮುಖ್ಯ ಉದ್ದೇಶವೇನು?",
            options = listOf("ಪ್ರಸ್ತುತ ತಲೆಮಾರಿನ ಮೂಲಭೂತ ಅಗತ್ಯಗಳನ್ನು ಪೂರೈಸುತ್ತಲೇ ಭವಿಷ್ಯದ ತಲೆಮಾರಿಗಾಗಿ ಸಂಪನ್ಮೂಲಗಳನ್ನು ಸಂರಕ್ಷಿಸುವುದು", "ಎಲ್ಲಾ ಸಂಪನ್ಮೂಲಗಳನ್ನು ತಕ್ಷಣವೇ ಬಳಸಿ ಮುಗಿಸುವುದು", "ಯಾವುದೇ ನೈಸರ್ಗಿಕ ವಸ್ತುವನ್ನು ಬಳಸದಿರುವುದು", "ಕೇವಲ ಕೈಗಾರಿಕೆಗಳ ಅಭಿವೃದ್ಧಿ"),
            correctAnswer = "ಪ್ರಸ್ತುತ ತಲೆಮಾರಿನ ಮೂಲಭೂತ ಅಗತ್ಯಗಳನ್ನು ಪೂರೈಸುತ್ತಲೇ ಭವಿಷ್ಯದ ತಲೆಮಾರಿಗಾಗಿ ಸಂಪನ್ಮೂಲಗಳನ್ನು ಸಂರಕ್ಷಿಸುವುದು",
            explanation = "ಪರಿಸರಕ್ಕೆ ಹಾನಿಯಾಗದಂತೆ ಮಾನವನ ಇಂದಿನ ಅಗತ್ಯಗಳನ್ನು ಪೂರೈಸಿ ಮುಂದಿನ ಪೀಳಿಗೆಯ ಹಿತ ಕಾಯುವುದೇ ಸುಸ್ಥಿರ ಅಭಿವೃದ್ಧಿ."
        )
    )

    val questions: List<QuestionModel> = u1Questions + u2Questions + u3Questions + u4Questions +
            u5Questions + u6Questions + u7Questions + u8Questions +
            u9Questions + u10Questions + u11Questions + u12Questions +
            u13Questions + u14Questions + u15Questions + u16Questions
}
