package com.example.data

/**
 * Standard 7 Mathematics - Part 2 and Advanced Units (LBA Revised 2026-27, 7thMathsKM-LBARevised_1787048371.pdf)
 * Official verified questions without duplicates:
 * Unit 6: ರಚನೆಗಳು ಮತ್ತು ನೆಲಹಾಸುಗಳು (Constructions & Tessellations)
 * Unit 7: ಬೀಜಗಣಿತೀಯ ಅಭಿವ್ಯಕ್ತಿಗಳು ಮತ್ತು ಸರಳ ಸಮೀಕರಣಗಳು (Algebraic Expressions & Equations)
 * Unit 8: ಭಿನ್ನರಾಶಿಗಳೊಂದಿಗೆ ಕ್ರಿಯೆಗಳು ಮತ್ತು ಸಂಖ್ಯಾ ಮಾದರಿಗಳು (Operations on Fractions & Patterns)
 * Unit 9: ಜ್ಯಾಮಿತಿಯ ಅವಲೋಕನಗಳು ಮತ್ತು ಸರ್ವಸಮತೆ (Geometric Concepts & Congruence)
 * Unit 10: ಅಪವರ್ತನಗಳು, ಗುಣಿತಗಳು ಮತ್ತು ದಶಮಾಂಶಗಳ ಮೇಲಿನ ಕ್ರಿಯೆಗಳು (Factors, Multiples & Operations)
 */
object Std7MathsPart2UnitsBank {

    val questions: List<QuestionModel> = listOf(
        // ==================== ಘಟಕ 6: ರಚನೆಗಳು ಮತ್ತು ನೆಲಹಾಸುಗಳು (Constructions & Tessellations) ====================
        QuestionModel(
            id = "s_7_mat_u6_1",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಜ್ಯಾಮಿತಿಯ ನಿರ್ಮಾಣಗಳಲ್ಲಿ ಬಳಸುವ ಪ್ರಮುಖ ಉಪಕರಣಗಳು ಯಾವುವು?",
            options = listOf("ಕೋನಮಾಪಕ ಮತ್ತು ಅಳಿಸುವ ರಬ್ಬರ್", "ಅಳತೆ ಪಟ್ಟಿ ಮತ್ತು ಕೈವಾರ", "ಮೂಲೆ ಪಟ್ಟಿ ಮತ್ತು ಕೋನಮಾಪಕ", "ಪೆನ್ಸಿಲ್ ಮತ್ತು ಅಳಿಸುವ ರಬ್ಬರ್ ಮಾತ್ರ"),
            correctAnswer = "ಅಳತೆ ಪಟ್ಟಿ ಮತ್ತು ಕೈವಾರ",
            explanation = "ರೇಖಾಗಣಿತದ ಸಾಂಪ್ರದಾಯಿಕ ನಿರ್ಮಾಣಗಳಲ್ಲಿ ಕೇವಲ ಅಳತೆ ಪಟ್ಟಿ (Straightedge) ಮತ್ತು ಕೈವಾರ (Compass) ಗಳನ್ನು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u6_2",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಸಮಮಿತಿ ಕಮಾನುಗಳ ನಿರ್ಮಾಣದಲ್ಲಿ XY ಸಹಾಯಕ ರೇಖೆಯ ಪಾತ್ರವೇನು?",
            options = listOf("ಕಮಾನುಗಳ ಎತ್ತರವನ್ನು ಹೆಚ್ಚಿಸುತ್ತದೆ", "ಕಮಾನುಗಳ ತ್ರಿಜ್ಯವನ್ನು ಅಳೆಯಲು ಸಹಾಯ ಮಾಡುತ್ತದೆ", "ಎರಡು ಕಮಾನುಗಳ ಕೇಂದ್ರಗಳನ್ನು ನೇರವಾಗಿ ಸಂಪರ್ಕಿಸುತ್ತದೆ", "ಕೋನದ ಅಳತೆಯನ್ನು ಬದಲಾಯಿಸುತ್ತದೆ"),
            correctAnswer = "ಎರಡು ಕಮಾನುಗಳ ಕೇಂದ್ರಗಳನ್ನು ನೇರವಾಗಿ ಸಂಪರ್ಕಿಸುತ್ತದೆ",
            explanation = "XY ಸಹಾಯಕ ರೇಖೆಯು ಕಮಾನುಗಳ ಎರಡು ಕೇಂದ್ರಗಳನ್ನು ನೇರವಾಗಿ ಸಂಪರ್ಕಿಸುವ ರೇಖೆಯಾಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u6_3",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "XY ರೇಖಾಖಂಡದ ಲಂಬ ದ್ವಿಭಾಜಕವನ್ನು ರಚಿಸುವಾಗ ಕೈವಾರದ ತ್ರಿಜ್ಯ ಹೇಗಿರಬೇಕು?",
            options = listOf("XY ಉದ್ದದ ಅರ್ಧಕ್ಕಿಂತ ಕಡಿಮೆ", "XY ಉದ್ದದ ಅರ್ಧಕ್ಕೆ ಸಮ", "XY ಉದ್ದದ ಅರ್ಧಕ್ಕಿಂತ ಹೆಚ್ಚು", "XY ಉದ್ದಕ್ಕೆ ಸಮ"),
            correctAnswer = "XY ಉದ್ದದ ಅರ್ಧಕ್ಕಿಂತ ಹೆಚ್ಚು",
            explanation = "ಕಮಾನುಗಳು ಪರಸ್ಪರ ಛೇದಿಸಲು ಕೈವಾರದ ತ್ರಿಜ್ಯವು ರೇಖಾಖಂಡದ ಅರ್ಧಕ್ಕಿಂತ ಹೆಚ್ಚಾಗಿರಬೇಕು (> 1/2 XY)."
        ),
        QuestionModel(
            id = "s_7_mat_u6_4",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಲಂಬ ದ್ವಿಭಾಜಕವನ್ನು ರಚಿಸಲು ಕಮಾನುಗಳನ್ನು ಎಲ್ಲಿ ಎಳೆಯಬೇಕು?",
            options = listOf("ರೇಖಾಖಂಡದ ಮೇಲ್ಭಾಗದಲ್ಲಿ ಮಾತ್ರ", "ರೇಖಾಖಂಡದ ಮೇಲ್ಭಾಗದಲ್ಲಿ ಮತ್ತು ಕೆಳಭಾಗದಲ್ಲಿ", "ರೇಖಾಖಂಡದ ಮೇಲೆ ಮಾತ್ರ", "ರೇಖಾಖಂಡದ ತುದಿಗಳಲ್ಲಿ ಮಾತ್ರ"),
            correctAnswer = "ರೇಖಾಖಂಡದ ಮೇಲ್ಭಾಗದಲ್ಲಿ ಮತ್ತು ಕೆಳಭಾಗದಲ್ಲಿ",
            explanation = "ಲಂಬ ದ್ವಿಭಾಜಕ ರೇಖೆಯನ್ನು ಎಳೆಯಲು ರೇಖಾಖಂಡದ ಎರಡೂ ಬದಿಗಳಲ್ಲಿ (ಮೇಲೆ ಮತ್ತು ಕೆಳಗೆ) ಕಮಾನುಗಳನ್ನು ಕತ್ತರಿಸಬೇಕು."
        ),
        QuestionModel(
            id = "s_7_mat_u6_5",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಪ್ರಾಚೀನ ವೇದಕಾಲದ ನಿರ್ಮಾಣಕಾರರು ಆಧುನಿಕ ದಿಕ್ಸೂಚಿ ಮತ್ತು ನೇರ ಅಂಚುಗಳ ಬದಲಿಗೆ ಬಳಸುತ್ತಿದ್ದ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಮೂಲೆ ಪಟ್ಟಿ", "ಕೋನಮಾಪಕ", "ಮಾಪನ ಮಾಡಿದ ಹಗ್ಗ ಅಥವಾ ದಾರ (ಶುಲ್ಬ)", "ಅಳತೆ ಪಟ್ಟಿ"),
            correctAnswer = "ಮಾಪನ ಮಾಡಿದ ಹಗ್ಗ ಅಥವಾ ದಾರ (ಶುಲ್ಬ)",
            explanation = "ವೇದ ಕಾಲದ ಶುಲ್ಬ ಸೂತ್ರಗಳಲ್ಲಿ ಜ್ಯಾಮಿತೀಯ ವೇದಿಕೆಗಳನ್ನು ನಿರ್ಮಿಸಲು ಗುರುತು ಮಾಡಿದ ಹಗ್ಗ (ಶುಲ್ಬ) ವನ್ನು ಬಳಸುತ್ತಿದ್ದರು."
        ),
        QuestionModel(
            id = "s_7_mat_u6_6",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದು ಚೌಕದ ಬದಿಯ ಉದ್ದ 16 cm ಇದ್ದರೆ, ಅರ್ಧ ಬದಿಯ ಉದ್ದ ಎಷ್ಟು?",
            options = listOf("16 cm", "12 cm", "8 cm", "4 cm"),
            correctAnswer = "8 cm",
            explanation = "16 cm / 2 = 8 cm."
        ),
        QuestionModel(
            id = "s_7_mat_u6_7",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದು ಷಡ್ಭುಜವನ್ನು ನಿಯಮಿತ ಷಡ್ಭುಜ ಎಂದು ಕರೆಯುವುದು ಯಾವಾಗ?",
            options = listOf("ಎಲ್ಲಾ ಬಾಹುಗಳು ಸಮವಾಗಿದ್ದಾಗ", "ಎಲ್ಲಾ ಕೋನಗಳು ಸಮವಾಗಿದ್ದಾಗ", "ಎಲ್ಲಾ ಬಾಹುಗಳು ಮತ್ತು ಕೋನಗಳು ಸಮವಾಗಿದ್ದಾಗ", "ಎಲ್ಲಾ ಕೋನಗಳು ವಿಭಿನ್ನವಾಗಿದ್ದಾಗ"),
            correctAnswer = "ಎಲ್ಲಾ ಬಾಹುಗಳು ಮತ್ತು ಕೋನಗಳು ಸಮವಾಗಿದ್ದಾಗ",
            explanation = "ಯಾವುದೇ ಬಹುಭುಜಾಕೃತಿಯ ಎಲ್ಲಾ ಬಾಹುಗಳು ಮತ್ತು ಒಳಕೋನಗಳು ಸಮವಾಗಿದ್ದರೆ ಅದು ನಿಯಮಿತ ಬಹುಭುಜಾಕೃತಿ (Regular Polygon)."
        ),
        QuestionModel(
            id = "s_7_mat_u6_8",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದು ಕೋನದ ಅಳತೆ 60° ಆಗಿದ್ದರೆ, ಅದರ ದ್ವಿಭಾಜಕದಿಂದ ಉಂಟಾಗುವ ಎರಡು ಕೋನಗಳ ಅಳತೆ ಯಾವುದು?",
            options = listOf("20° ಮತ್ತು 40°", "15° ಮತ್ತು 45°", "25° ಮತ್ತು 35°", "30° ಮತ್ತು 30°"),
            correctAnswer = "30° ಮತ್ತು 30°",
            explanation = "ಕೋನ ದ್ವಿಭಾಜಕವು ಕೋನವನ್ನು ಎರಡು ಸಮ ಭಾಗಗಳಾಗಿ ವಿಭಜಿಸುತ್ತದೆ: 60° / 2 = 30°."
        ),
        QuestionModel(
            id = "s_7_mat_u6_9",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "∠ABC = 100° ಆಗಿದ್ದು, BX ಕಿರಣವು ∠ABC ಅನ್ನು ದ್ವಿಭಾಗಿಸಿದರೆ, ∠ABX ಎಷ್ಟು?",
            options = listOf("60°", "50°", "30°", "90°"),
            correctAnswer = "50°",
            explanation = "100° / 2 = 50°."
        ),
        QuestionModel(
            id = "s_7_mat_u6_10",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದು ಪೂರ್ಣ ವೃತ್ತವನ್ನು 12 ಸಮಾನ ಭಾಗಗಳಾಗಿ ವಿಭಜಿಸಿದರೆ, ಪ್ರತಿ ಕೇಂದ್ರ ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("30°", "45°", "60°", "90°"),
            correctAnswer = "30°",
            explanation = "ವೃತ್ತದ ಕೇಂದ್ರದಲ್ಲಿನ ಒಟ್ಟು ಕೋನ 360°. 360° / 12 = 30°."
        ),
        QuestionModel(
            id = "s_7_mat_u6_11",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಅಳತೆ ಪಟ್ಟಿ ಮತ್ತು ಕೈವಾರ ಬಳಸಿ ಕೊಟ್ಟಿರುವ ರೇಖೆಗೆ ಸಮಾನಾಂತರ ರೇಖೆಯನ್ನು ರಚಿಸುವಾಗ ಬಳಸುವ ತತ್ವ ಯಾವುದು?",
            options = listOf("ಎರಡು ಲಂಬ ರೇಖೆಗಳನ್ನು ಎಳೆಯುವುದು", "ಅನುರೂಪ ಕೋನಗಳು ಸಮಾನವಾಗಿರುವುದನ್ನು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳುವುದು", "ಕೋನಮಾಪಕದಿಂದ ಅಂತರವನ್ನು ಅಳೆಯುವುದು", "ಕೊಟ್ಟಿರುವ ರೇಖೆಯನ್ನು ದ್ವಿಭಾಗಿಸುವುದು"),
            correctAnswer = "ಅನುರೂಪ ಕೋನಗಳು ಸಮಾನವಾಗಿರುವುದನ್ನು ಖಚಿತಪಡಿಸಿಕೊಳ್ಳುವುದು",
            explanation = "ಸಮಾನಾಂತರ ರೇಖೆಗಳಲ್ಲಿ ಅನುರೂಪ ಕೋನಗಳು ಅಥವಾ ಪರ್ಯಾಯ ಕೋನಗಳು ಸಮನಾಗಿರುತ್ತವೆ ಎಂಬ ತತ್ವವನ್ನು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u6_12",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ನಿಯಮಿತ ಷಡ್ಭುಜಕ್ಕೆ ಎಷ್ಟು ಬಾಹುಗಳಿವೆ?",
            options = listOf("4", "6", "5", "7"),
            correctAnswer = "6",
            explanation = "ಷಡ್ಭುಜಾಕೃತಿಗೆ (Hexagon) 6 ಬಾಹುಗಳಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u6_13",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಷಡ್ಭುಜದ ಎಲ್ಲಾ ಒಳಕೋನಗಳ ಮೊತ್ತ ಎಷ್ಟು?",
            options = listOf("540°", "720°", "360°", "90°"),
            correctAnswer = "720°",
            explanation = "ಒಳಕೋನಗಳ ಮೊತ್ತ = (n − 2) × 180° = (6 − 2) × 180° = 4 × 180° = 720°."
        ),
        QuestionModel(
            id = "s_7_mat_u6_14",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ರೇಖಾಖಂಡದ ಲಂಬ ದ್ವಿಭಾಜಕವನ್ನು ಕೈವಾರ ಮತ್ತು ಅಳತೆ ಪಟ್ಟಿಯಿಂದ ರಚಿಸಲು ಅಗತ್ಯವಿಲ್ಲದ ಸಾಧನ ಯಾವುದು?",
            options = listOf("ಅಳತೆ ಪಟ್ಟಿ", "ಕೋನಮಾಪಕ", "ಕೈವಾರ", "ಪೆನ್ಸಿಲ್"),
            correctAnswer = "ಕೋನಮಾಪಕ",
            explanation = "ಲಂಬ ದ್ವಿಭಾಜಕ ರಚಿಸಲು ಕೋನಮಾಪಕದ ಅಗತ್ಯವಿಲ್ಲ, ಕೇವಲ ಕೈವಾರ ಮತ್ತು ಅಳತೆ ಪಟ್ಟಿ ಸಾಕು."
        ),
        QuestionModel(
            id = "s_7_mat_u6_15",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದು ಪ್ರಮಾಣಿತ ಟ್ಯಾಂಗ್ರಾಮ್ (Tangram) ಒಗಟಿನಲ್ಲಿ ಎಷ್ಟು ತ್ರಿಭುಜಗಳಿವೆ?",
            options = listOf("3", "4", "5", "7"),
            correctAnswer = "5",
            explanation = "ಟ್ಯಾಂಗ್ರಾಮ್‌ನ 7 ತುಣುಕುಗಳಲ್ಲಿ 5 ತ್ರಿಭುಜಗಳು, 1 ಚೌಕ ಮತ್ತು 1 ಸಮಾಂತರ ಚತುರ್ಭುಜ ಇರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u6_16",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಟ್ಯಾಂಗ್ರಾಮ್ ಒಗಟಿನ ತುಣುಕುಗಳನ್ನು ಬಳಸಿ ಆಕೃತಿಗಳನ್ನು ರಚಿಸುವಾಗ ಯಾವ ನಿಯಮ ಪಾಲಿಸಬೇಕು?",
            options = listOf("ಕೇವಲ ಐದು ತುಣುಕುಗಳನ್ನು ಬಳಸಬೇಕು", "ತುಣುಕುಗಳನ್ನು ಒಂದರ ಮೇಲೊಂದು ಇರಿಸಬಹುದು", "ಎಲ್ಲಾ ಏಳು ತುಣುಕುಗಳನ್ನು ಅತಿಕ್ರಮಣವಿಲ್ಲದೆ ಬಳಸಬೇಕು", "ತುಣುಕುಗಳನ್ನು ಕತ್ತರಿಸಿ ಅಳತೆ ಬದಲಾಯಿಸಬೇಕು"),
            correctAnswer = "ಎಲ್ಲಾ ಏಳು ತುಣುಕುಗಳನ್ನು ಅತಿಕ್ರಮಣವಿಲ್ಲದೆ ಬಳಸಬೇಕು",
            explanation = "ಟ್ಯಾಂಗ್ರಾಮ್‌ನ ಮೂಲ ನಿಯಮದಂತೆ ಎಲ್ಲಾ 7 ತುಣುಕುಗಳನ್ನು ಅತಿಕ್ರಮಣವಿಲ್ಲದೆ (without overlapping) ಬಳಸಬೇಕು."
        ),
        QuestionModel(
            id = "s_7_mat_u6_17",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಲಂಬ ದ್ವಿಭಾಜಕವು ರೇಖಾಖಂಡವನ್ನು ಯಾವ ಕೋನದಲ್ಲಿ ವಿಭಜಿಸುತ್ತದೆ?",
            options = listOf("30°", "45°", "90°", "180°"),
            correctAnswer = "90°",
            explanation = "ಲಂಬ ದ್ವಿಭಾಜಕವು (Perpendicular bisector) ರೇಖೆಯನ್ನು 90° ಕೋನದಲ್ಲಿ ಸರಿಯಾಗಿ ಅರ್ಧಕ್ಕೆ ವಿಭಜಿಸುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u6_18",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಮೇಲ್ಮೈಯನ್ನು ಅಂತರವಿಲ್ಲದೆ ಪುನರಾವರ್ತಿತ ಆಕಾರಗಳಿಂದ ಆವರಿಸುವ ವ್ಯವಸ್ಥೆಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಸಮಮಿತಿ", "ಟೆಸಲೇಶನ್ (Tessellation / ನೆಲಹಾಸು)", "ಲಂಬ ದ್ವಿಭಾಜಕ", "ಕೋನ ದ್ವಿಭಾಜಕ"),
            correctAnswer = "ಟೆಸಲೇಶನ್ (Tessellation / ನೆಲಹಾಸು)",
            explanation = "ಯಾವುದೇ ಅಂತರ ಅಥವಾ ಅತಿಕ್ರಮಣವಿಲ್ಲದೆ ಸಮತಲವನ್ನು ಟೈಲ್ಸ್ ಮಾಡುವುದನ್ನು ಟೆಸಲೇಶನ್ ಎನ್ನುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u6_19",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ರೇಖಾಖಂಡದ ಲಂಬ ದ್ವಿಭಾಜಕದ ಮೇಲಿರುವ ಯಾವುದೇ ಬಿಂದುವು ರೇಖಾಖಂಡದ ಎರಡು ತುದಿಗಳಿಂದ ಹೇಗಿರುತ್ತದೆ?",
            options = listOf("ಸಮ ದೂರದಲ್ಲಿರುತ್ತದೆ", "ಬೇರೆ ಬೇರೆ ದೂರದಲ್ಲಿರುತ್ತದೆ", "ಒಂದು ತುದಿಯಲ್ಲೇ ಇರುತ್ತದೆ", "ಯಾವಾಗಲೂ ಮಧ್ಯಬಿಂದುವಾಗಿರುತ್ತದೆ"),
            correctAnswer = "ಸಮ ದೂರದಲ್ಲಿರುತ್ತದೆ",
            explanation = "ಲಂಬ ದ್ವಿಭಾಜಕದ ಮೇಲಿನ ಪ್ರತಿಯೊಂದು ಬಿಂದುವೂ ರೇಖಾಖಂಡದ ಅಂತ್ಯ ಬಿಂದುಗಳಿಂದ ಸಮಾನ ದೂರದಲ್ಲಿರುತ್ತದೆ (Equidistant)."
        ),
        QuestionModel(
            id = "s_7_mat_u6_20",
            stdId = 7,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದೇ ಸಮತಲದಲ್ಲಿ ಎಷ್ಟು ವಿಸ್ತರಿಸಿದರೂ ಪರಸ್ಪರ ಛೇದಿಸದ ಎರಡು ಸರಳ ರೇಖೆಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಛೇದಕ ರೇಖೆಗಳು", "ಲಂಬ ರೇಖೆಗಳು", "ಸಮಾನಾಂತರ ರೇಖೆಗಳು", "ವಕ್ರ ರೇಖೆಗಳು"),
            correctAnswer = "ಸಮಾನಾಂತರ ರೇಖೆಗಳು",
            explanation = "ಪರಸ್ಪರ ಛೇದಿಸದ ಮತ್ತು ಸ್ಥಿರ ಅಂತರ ಹೊಂದಿರುವ ಸರಳ ರೇಖೆಗಳು ಸಮಾನಾಂತರ ರೇಖೆಗಳು (Parallel Lines)."
        ),

        // ==================== ಘಟಕ 7: ಬೀಜಗಣಿತೀಯ ಅಭಿವ್ಯಕ್ತಿಗಳು ಮತ್ತು ಸರಳ ಸಮೀಕರಣಗಳು ====================
        QuestionModel(
            id = "s_7_mat_u7_1",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "3n = 10 + n ಆಗಿದ್ದರೆ, 'n' ನ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("3", "5", "10", "15"),
            correctAnswer = "5",
            explanation = "3n − n = 10 => 2n = 10 => n = 5."
        ),
        QuestionModel(
            id = "s_7_mat_u7_2",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "4l = 16 ಆಗಿದ್ದರೆ, 'l' ನ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("2", "4", "8", "12"),
            correctAnswer = "4",
            explanation = "l = 16 / 4 = 4."
        ),
        QuestionModel(
            id = "s_7_mat_u7_3",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "k + 8 = 12 − k ಆಗಿದ್ದರೆ, 'k' ನ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("1", "2", "4", "8"),
            correctAnswer = "2",
            explanation = "k + k = 12 − 8 => 2k = 4 => k = 2."
        ),
        QuestionModel(
            id = "s_7_mat_u7_4",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "13 − z = 8 ಆಗಿದ್ದರೆ, 'z' ನ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("3", "5", "8", "13"),
            correctAnswer = "5",
            explanation = "z = 13 − 8 = 5."
        ),
        QuestionModel(
            id = "s_7_mat_u7_5",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "p + 4 = 15 ಆಗಿದ್ದರೆ, 'p' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("9", "11", "15", "19"),
            correctAnswer = "11",
            explanation = "p = 15 − 4 = 11."
        ),
        QuestionModel(
            id = "s_7_mat_u7_6",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "x + 9 = 8 ಆಗಿದ್ದರೆ, 'x' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("1", "−1", "17", "−17"),
            correctAnswer = "−1",
            explanation = "x = 8 − 9 = −1."
        ),
        QuestionModel(
            id = "s_7_mat_u7_7",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "6p = 24 ಆಗಿದ್ದರೆ, 'p' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("3", "4", "6", "8"),
            correctAnswer = "4",
            explanation = "p = 24 / 6 = 4."
        ),
        QuestionModel(
            id = "s_7_mat_u7_8",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "3l = 42 ಆಗಿದ್ದರೆ, 'l' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("12", "14", "21", "39"),
            correctAnswer = "14",
            explanation = "l = 42 / 3 = 14."
        ),
        QuestionModel(
            id = "s_7_mat_u7_9",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "4 − y = 2 ಆಗಿದ್ದರೆ, 'y' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("2", "−2", "4", "6"),
            correctAnswer = "2",
            explanation = "y = 4 − 2 = 2."
        ),
        QuestionModel(
            id = "s_7_mat_u7_10",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "6y − 6 = 60 ಆಗಿದ್ದರೆ, 'y' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("9", "10", "11", "12"),
            correctAnswer = "11",
            explanation = "6y = 66 => y = 11."
        ),
        QuestionModel(
            id = "s_7_mat_u7_11",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "5n + 5 = 20 ಆಗಿದ್ದರೆ, 'n' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("2", "3", "4", "5"),
            correctAnswer = "3",
            explanation = "5n = 15 => n = 3."
        ),
        QuestionModel(
            id = "s_7_mat_u7_12",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "6p − 4 = 32 ಆಗಿದ್ದರೆ, 'p' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("4", "5", "6", "8"),
            correctAnswer = "6",
            explanation = "6p = 36 => p = 6."
        ),
        QuestionModel(
            id = "s_7_mat_u7_13",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "9d + 10 = 100 ಆಗಿದ್ದರೆ, 'd' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("9", "10", "11", "12"),
            correctAnswer = "10",
            explanation = "9d = 90 => d = 10."
        ),
        QuestionModel(
            id = "s_7_mat_u7_14",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "3m + 9 = 27 ಆಗಿದ್ದರೆ, 'm' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("3", "6", "9", "12"),
            correctAnswer = "6",
            explanation = "3m = 18 => m = 6."
        ),
        QuestionModel(
            id = "s_7_mat_u7_15",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "12t + 5 = 65 ಆಗಿದ್ದರೆ, 't' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("4", "5", "6", "10"),
            correctAnswer = "5",
            explanation = "12t = 60 => t = 5."
        ),
        QuestionModel(
            id = "s_7_mat_u7_16",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "3u − 7 = 2u + 3 ಆಗಿದ್ದರೆ, 'u' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("4", "7", "10", "14"),
            correctAnswer = "10",
            explanation = "3u − 2u = 3 + 7 => u = 10."
        ),
        QuestionModel(
            id = "s_7_mat_u7_17",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "3x + 4 = 2x + 8 ಆಗಿದ್ದರೆ, 'x' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("2", "4", "6", "12"),
            correctAnswer = "4",
            explanation = "3x − 2x = 8 − 4 => x = 4."
        ),
        QuestionModel(
            id = "s_7_mat_u7_18",
            stdId = 7,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "6y + 7 = 4y + 21 ಆಗಿದ್ದರೆ, 'y' ನ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("5", "6", "7", "14"),
            correctAnswer = "7",
            explanation = "6y − 4y = 21 − 7 => 2y = 14 => y = 7."
        ),

        // ==================== ಘಟಕ 8: ಭಿನ್ನರಾಶಿಗಳೊಂದಿಗೆ ಕ್ರಿಯೆಗಳು ಮತ್ತು ಸಂಖ್ಯಾ ಮಾದರಿಗಳು ====================
        QuestionModel(
            id = "s_7_mat_u8_1",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "1/2 + 1/2 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("1/2", "1", "1/4", "2"),
            correctAnswer = "1",
            explanation = "1/2 + 1/2 = 2/2 = 1."
        ),
        QuestionModel(
            id = "s_7_mat_u8_2",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "3/4 − 1/4 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("1/2", "1/4", "1", "3/8"),
            correctAnswer = "1/2",
            explanation = "3/4 − 1/4 = 2/4 = 1/2."
        ),
        QuestionModel(
            id = "s_7_mat_u8_3",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "2/3 × 3 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("2/9", "2", "3/2", "1"),
            correctAnswer = "2",
            explanation = "(2 × 3) / 3 = 2."
        ),
        QuestionModel(
            id = "s_7_mat_u8_4",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "1/2 × 1/3 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("2/5", "1/5", "1/6", "5/6"),
            correctAnswer = "1/6",
            explanation = "(1 × 1) / (2 × 3) = 1/6."
        ),
        QuestionModel(
            id = "s_7_mat_u8_5",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "3/4 ÷ 1/2 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("3/8", "3/2", "2/3", "1/4"),
            correctAnswer = "3/2",
            explanation = "3/4 × 2/1 = 6/4 = 3/2."
        ),
        QuestionModel(
            id = "s_7_mat_u8_6",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "2/5 + 1/5 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("3/10", "1/5", "3/5", "2/25"),
            correctAnswer = "3/5",
            explanation = "2/5 + 1/5 = 3/5."
        ),
        QuestionModel(
            id = "s_7_mat_u8_7",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "5/6 − 1/3 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("4/3", "1/2", "2/3", "1/3"),
            correctAnswer = "1/2",
            explanation = "5/6 − 2/6 = 3/6 = 1/2."
        ),
        QuestionModel(
            id = "s_7_mat_u8_8",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "4 ÷ 1/2 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("2", "4", "8", "1/8"),
            correctAnswer = "8",
            explanation = "4 × 2/1 = 8."
        ),
        QuestionModel(
            id = "s_7_mat_u8_9",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "2/7 × 7/2 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("0", "1", "2", "1/7"),
            correctAnswer = "1",
            explanation = "ವ್ಯುತ್ಕ್ರಮಗಳ ಗುಣಲಬ್ಧ 1 ಆಗಿರುತ್ತದೆ (2/7 × 7/2 = 1)."
        ),
        QuestionModel(
            id = "s_7_mat_u8_10",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "1 ÷ 1/5 ಇದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("1/5", "1", "4", "5"),
            correctAnswer = "5",
            explanation = "1 × 5/1 = 5."
        ),
        QuestionModel(
            id = "s_7_mat_u8_11",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "n = 2 ಆಗಿದ್ದರೆ, 3n + 2 ರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("6", "7", "8", "9"),
            correctAnswer = "8",
            explanation = "3(2) + 2 = 6 + 2 = 8."
        ),
        QuestionModel(
            id = "s_7_mat_u8_12",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "1, 2, 3, 5, 8, 13, 21, 34,... (ಫಿಬೊನಾಕಿ ಶ್ರೇಣಿ) ಮಾದರಿಯಲ್ಲಿ ಪ್ರತಿ ಮುಂದಿನ ಸಂಖ್ಯೆಯನ್ನು ಹೇಗೆ ಪಡೆಯಲಾಗುತ್ತದೆ?",
            options = listOf("ಹಿಂದಿನ ಸಂಖ್ಯೆಗೆ 2 ಸೇರಿಸಿ", "ಹಿಂದಿನ ಎರಡು ಸಂಖ್ಯೆಗಳನ್ನು ಸೇರಿಸಿ", "ಹಿಂದಿನ ಸಂಖ್ಯೆಯನ್ನು 2 ರಿಂದ ಗುಣಿಸಿ", "ಹಿಂದಿನ ಸಂಖ್ಯೆಯಿಂದ 1 ಕಳೆಯಿರಿ"),
            correctAnswer = "ಹಿಂದಿನ ಎರಡು ಸಂಖ್ಯೆಗಳನ್ನು ಸೇರಿಸಿ",
            explanation = "ಫಿಬೊನಾಕಿ ಸರಣಿಯಲ್ಲಿ ಪ್ರತಿ ಪದವು ಅದರ ಹಿಂದಿನ ಎರಡು ಪದಗಳ ಮೊತ್ತವಾಗಿರುತ್ತದೆ (ಉದಾ: 13 + 21 = 34)."
        ),
        QuestionModel(
            id = "s_7_mat_u8_13",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "4n + 2 ಅಭಿವ್ಯಕ್ತಿಯಲ್ಲಿ n = 3 ಆಗಿದ್ದರೆ ಅದರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("12", "14", "10", "16"),
            correctAnswer = "14",
            explanation = "4(3) + 2 = 12 + 2 = 14."
        ),
        QuestionModel(
            id = "s_7_mat_u8_14",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "Z + Z + Z ಅನ್ನು ಸಂಕ್ಷಿಪ್ತವಾಗಿ ಬರೆಯುವ ಬೀಜಗಣಿತೀಯ ರೂಪ ಯಾವುದು?",
            options = listOf("3Z", "Z + 3", "Z³", "2Z"),
            correctAnswer = "3Z",
            explanation = "ಸಮಾನ ಪದಗಳ ಸಂಕಲನ: Z + Z + Z = 3Z."
        ),
        QuestionModel(
            id = "s_7_mat_u8_15",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "ಮೊದಲ 5 ಬೆಸ ಸಂಖ್ಯೆಗಳ ಸರಿಯಾದ ಗುಂಪು ಯಾವುದು?",
            options = listOf("1, 2, 3, 4, 5", "1, 3, 5, 7, 9", "2, 4, 6, 8, 10", "3, 5, 7, 9, 11"),
            correctAnswer = "1, 3, 5, 7, 9",
            explanation = "1, 3, 5, 7, 9 ಮೊದಲ 5 ಧನಾತ್ಮಕ ಬೆಸ ಸಂಖ್ಯೆಗಳು."
        ),
        QuestionModel(
            id = "s_7_mat_u8_16",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "'n' ಸ್ವಾಭಾವಿಕ ಸಂಖ್ಯೆಯಾಗಿದ್ದಾಗ, 2n ಯಾವ ರೀತಿಯ ಸಂಖ್ಯೆಯನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಯಾವಾಗಲೂ ಬೆಸ ಸಂಖ್ಯೆ", "ಸಮ ಸಂಖ್ಯೆ", "ಯಾವಾಗಲೂ ಋಣ ಸಂಖ್ಯೆ", "ಯಾವಾಗಲೂ ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆ"),
            correctAnswer = "ಸಮ ಸಂಖ್ಯೆ",
            explanation = "2 ರ ಯಾವುದೇ ಗುಣಿತವು ಸಮ ಸಂಖ್ಯೆಯಾಗಿರುತ್ತದೆ (2n)."
        ),
        QuestionModel(
            id = "s_7_mat_u8_17",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "'n' ಸ್ವಾಭಾವಿಕ ಸಂಖ್ಯೆಯಾಗಿದ್ದಾಗ, 2n − 1 ಯಾವ ರೀತಿಯ ಸಂಖ್ಯೆಯನ್ನು ಸೂಚಿಸುತ್ತದೆ?",
            options = listOf("ಸಮ ಸಂಖ್ಯೆ", "ಬೆಸ ಸಂಖ್ಯೆ", "ಶೂನ್ಯ ಮಾತ್ರ", "ಋಣ ಸಂಖ್ಯೆ ಮಾತ್ರ"),
            correctAnswer = "ಬೆಸ ಸಂಖ್ಯೆ",
            explanation = "ಸಮ ಸಂಖ್ಯೆಯಿಂದ 1 ಕಳೆದರೆ ಯಾವಾಗಲೂ ಬೆಸ ಸಂಖ್ಯೆ ಸಿಗುತ್ತದೆ (2n − 1)."
        ),
        QuestionModel(
            id = "s_7_mat_u8_18",
            stdId = 7,
            subjectId = "math",
            unitId = 8,
            type = "MCQ",
            questionText = "n = 4 ಆಗಿದ್ದರೆ, 2n − 1 ರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("6", "7", "8", "9"),
            correctAnswer = "7",
            explanation = "2(4) − 1 = 8 − 1 = 7."
        ),

        // ==================== ಘಟಕ 9: ಜ್ಯಾಮಿತಿಯ ಅವಲೋಕನಗಳು ಮತ್ತು ಸರ್ವಸಮತೆ (Geometry & Congruence) ====================
        QuestionModel(
            id = "s_7_mat_u9_1",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸರ್ವಸಮ ಆಕೃತಿಗಳಲ್ಲಿ (Congruent figures) ಯಾವುದು ಸಮನಾಗಿರುತ್ತದೆ?",
            options = listOf("ಆಕಾರ ಮಾತ್ರ", "ವಿಸ್ತೀರ್ಣ ಮಾತ್ರ", "ಆಕಾರ ಮತ್ತು ಗಾತ್ರ ಎರಡೂ", "ಬಣ್ಣ ಮಾತ್ರ"),
            correctAnswer = "ಆಕಾರ ಮತ್ತು ಗಾತ್ರ ಎರಡೂ",
            explanation = "ಸರ್ವಸಮ ಆಕೃತಿಗಳು ಒಂದೇ ಆಕಾರ ಮತ್ತು ಒಂದೇ ಅಳತೆಯನ್ನು (ಗಾತ್ರ) ಹೊಂದಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u9_2",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸಮಬಾಹು ತ್ರಿಭುಜದ ಪ್ರತಿಯೊಂದು ಕೋನದ ಅಳತೆ ಎಷ್ಟು?",
            options = listOf("45°", "60°", "90°", "120°"),
            correctAnswer = "60°",
            explanation = "ಸಮಬಾಹು ತ್ರಿಭುಜದಲ್ಲಿ ಎಲ್ಲಾ ಮೂರು ಕೋನಗಳು ಸಮ: 180° / 3 = 60°."
        ),
        QuestionModel(
            id = "s_7_mat_u9_3",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಜ್ಯಾಮಿತಿಯಲ್ಲಿ ಸರ್ವಸಮತೆಯನ್ನು ಸೂಚಿಸುವ ಸಂಕೇತ ಯಾವುದು?",
            options = listOf("=", "≈", "△", "≅"),
            correctAnswer = "≅",
            explanation = "ಸರ್ವಸಮತೆಗೆ '≅' ಚಿಹ್ನೆಯನ್ನು ಬಳಸಲಾಗುತ್ತದೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u9_4",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಸಮದ್ವಿಬಾಹು ತ್ರಿಭುಜದಲ್ಲಿ ಸಮನಾದ ಬಾಹುಗಳಿಗೆ ಅಭಿಮುಖವಾಗಿರುವ ಕೋನಗಳು ಹೇಗಿರುತ್ತವೆ?",
            options = listOf("ಸಮನಾಗಿರುತ್ತವೆ", "ಪೂರಕವಾಗಿರುತ್ತವೆ", "ಪರಿಪೂರಕವಾಗಿರುತ್ತವೆ", "ಲಂಬವಾಗಿರುತ್ತವೆ"),
            correctAnswer = "ಸಮನಾಗಿರುತ್ತವೆ",
            explanation = "ಸಮದ್ವಿಬಾಹು ತ್ರಿಭುಜದಲ್ಲಿ ಸಮಬಾಹುಗಳ ಎದುರಿನ ಕೋನಗಳು ಪರಸ್ಪರ ಸಮವಾಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u9_5",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "△ABC ಮತ್ತು △PQR ಗಳಲ್ಲಿ AB = PQ, BC = QR ಮತ್ತು ∠B = ∠Q ಆಗಿದ್ದರೆ, ಯಾವ ಸರ್ವಸಮತಾ ಸಿದ್ಧಾಂತ ಅನ್ವಯಿಸುತ್ತದೆ?",
            options = listOf("ಬಾ.ಬಾ.ಬಾ (SSS)", "ಬಾ.ಕೋ.ಬಾ (SAS)", "ಕೋ.ಬಾ.ಕೋ (ASA)", "ಲಂ.ವಿ.ಬಾ (RHS)"),
            correctAnswer = "ಬಾ.ಕೋ.ಬಾ (SAS)",
            explanation = "ಎರಡು ಬಾಹುಗಳು ಮತ್ತು ಅವುಗಳ ನಡುವಿನ ಕೋನ ಸಮನಾಗಿರುವುದರಿಂದ ಬಾ.ಕೋ.ಬಾ (SAS) ನಿಯಮ."
        ),
        QuestionModel(
            id = "s_7_mat_u9_6",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "△ABC ≅ △PQR ಆದರೆ, AC ಬಾಹುವಿಗೆ ಅನುರೂಪವಾದ ಬಾಹು ಯಾವುದು?",
            options = listOf("PQ", "QR", "PR", "AB"),
            correctAnswer = "PR",
            explanation = "ಅನುರೂಪ ಭಾಗಗಳ ನಿಯಮದಂತೆ (CPCT) AC ಗೆ ಅನುರೂಪ ಬಾಹು PR."
        ),
        QuestionModel(
            id = "s_7_mat_u9_7",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಎರಡು ವೃತ್ತಗಳು ಸರ್ವಸಮವಾಗಿರಲು ಅವುಗಳು ಏನನ್ನು ಹೊಂದಿರಬೇಕು?",
            options = listOf("ಒಂದೇ ಬಣ್ಣ", "ಒಂದೇ ವೃತ್ತಕೇಂದ್ರ", "ಸಮಾನ ತ್ರಿಜ್ಯಗಳು (Equal radii)", "ವಿಭಿನ್ನ ಪರಿಧಿ"),
            correctAnswer = "ಸಮಾನ ತ್ರಿಜ್ಯಗಳು (Equal radii)",
            explanation = "ಎರಡು ವೃತ್ತಗಳ ತ್ರಿಜ್ಯಗಳು ಸಮಾನವಾಗಿದ್ದರೆ (r₁ = r₂) ಅವು ಸರ್ವಸಮ ವೃತ್ತಗಳಾಗುತ್ತವೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u9_8",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "△ABC ≅ △PQR ಆಗಿದ್ದು, AB = 5 cm ಇದ್ದರೆ, PQ ನ ಉದ್ದ ಎಷ್ಟು?",
            options = listOf("10 cm", "5 cm", "2.5 cm", "ಹೇಳಲು ಸಾಧ್ಯವಿಲ್ಲ"),
            correctAnswer = "5 cm",
            explanation = "ಸರ್ವಸಮ ತ್ರಿಭುಜಗಳ ಅನುರೂಪ ಬಾಹುಗಳು ಸಮಾನ: PQ = AB = 5 cm."
        ),
        QuestionModel(
            id = "s_7_mat_u9_9",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "△ABC ≅ △PQR ಆದರೆ, ∠A ಗೆ ಅನುರೂಪವಾದ ಕೋನ ಯಾವುದು?",
            options = listOf("∠P", "∠Q", "∠R", "ಯಾವುದೂ ಅಲ್ಲ"),
            correctAnswer = "∠P",
            explanation = "ಮೊದಲ ಶೃಂಗ A ಗೆ ಅನುರೂಪ ಶೃಂಗ P ಆಗಿರುವುದರಿಂದ ∠A = ∠P."
        ),
        QuestionModel(
            id = "s_7_mat_u9_10",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "ಎರಡು ತ್ರಿಭುಜಗಳ ಮೂರು ಅನುರೂಪ ಬಾಹುಗಳು ಪರಸ್ಪರ ಸಮನಾಗಿದ್ದರೆ, ಯಾವ ನಿಯಮದಂತೆ ಅವು ಸರ್ವಸಮವಾಗುತ್ತವೆ?",
            options = listOf("ಬಾ.ಕೋ.ಬಾ (SAS)", "ಕೋ.ಬಾ.ಕೋ (ASA)", "ಬಾ.ಬಾ.ಬಾ (SSS)", "ಲಂ.ವಿ.ಬಾ (RHS)"),
            correctAnswer = "ಬಾ.ಬಾ.ಬಾ (SSS)",
            explanation = "ಮೂರು ಬಾಹುಗಳು ಸಮನಾಗಿದ್ದರೆ ಬಾಹು-ಬಾಹು-ಬಾಹು (SSS) ಸರ್ವಸಮತೆ."
        ),
        QuestionModel(
            id = "s_7_mat_u9_11",
            stdId = 7,
            subjectId = "math",
            unitId = 9,
            type = "MCQ",
            questionText = "△ABC ≅ △DEF ಮತ್ತು AB = 6 cm ಇದ್ದರೆ, DE ನ ಉದ್ದ ಎಷ್ಟು?",
            options = listOf("3 cm", "6 cm", "12 cm", "9 cm"),
            correctAnswer = "6 cm",
            explanation = "ಸರ್ವಸಮ ತ್ರಿಭುಜಗಳಲ್ಲಿ DE = AB = 6 cm."
        ),

        // ==================== ಘಟಕ 10: ಅಪವರ್ತನಗಳು ಮತ್ತು ದಶಮಾಂಶಗಳ ಮೇಲಿನ ಕ್ರಿಯೆಗಳು ====================
        QuestionModel(
            id = "s_7_mat_u10_1",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "4 ರ ಎಲ್ಲಾ ಅಪವರ್ತನಗಳು (Factors) ಯಾವುವು?",
            options = listOf("2 ಮಾತ್ರ", "1, 2", "1, 2, 4", "3, 4"),
            correctAnswer = "1, 2, 4",
            explanation = "4 ನ್ನು ನಿಶ್ಶೇಷವಾಗಿ ಭಾಗಿಸುವ ಸಂಖ್ಯೆಗಳು 1, 2, ಮತ್ತು 4."
        ),
        QuestionModel(
            id = "s_7_mat_u10_2",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "90 ರ ಅವಿಭಾಜ್ಯ ಅಪವರ್ತನಗಳ ಗುಣಲಬ್ಧ (Prime factorization) ಯಾವುದು?",
            options = listOf("3 × 10", "3 × 5 × 2", "3 × 2 × 3", "2 × 3 × 3 × 5"),
            correctAnswer = "2 × 3 × 3 × 5",
            explanation = "2 × 3 × 3 × 5 = 2 × 9 × 5 = 90."
        ),
        QuestionModel(
            id = "s_7_mat_u10_3",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "121 ನ್ನು ಅವಿಭಾಜ್ಯ ಅಪವರ್ತನಗಳ ಗುಣಲಬ್ಧದ ರೂಪದಲ್ಲಿ ಬರೆದಾಗ:",
            options = listOf("11 × 10", "11 × 11", "11 × 12", "11 × 13"),
            correctAnswer = "11 × 11",
            explanation = "11 × 11 = 121 (11 ಅವಿಭಾಜ್ಯ ಸಂಖ್ಯೆ)."
        ),
        QuestionModel(
            id = "s_7_mat_u10_4",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "14 ಮತ್ತು 35 ರ ಗರಿಷ್ಠ ಸಾಮಾನ್ಯ ಅಪವರ್ತನ (HCF / ಮ.ಸಾ.ಅ) ಯಾವುದು?",
            options = listOf("3", "2", "7", "5"),
            correctAnswer = "7",
            explanation = "14 = 2 × 7, 35 = 5 × 7. ಸಾಮಾನ್ಯ ಅಪವರ್ತನ = 7."
        ),
        QuestionModel(
            id = "s_7_mat_u10_5",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "45 ಮತ್ತು 75 ರ ಗರಿಷ್ಠ ಸಾಮಾನ್ಯ ಅಪವರ್ತನ (HCF) ಯಾವುದು?",
            options = listOf("15", "20", "30", "45"),
            correctAnswer = "15",
            explanation = "45 = 15 × 3, 75 = 15 × 5. ಆದ್ದರಿಂದ HCF = 15."
        ),
        QuestionModel(
            id = "s_7_mat_u10_6",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "15 ಮತ್ತು 20 ರ ಕನಿಷ್ಠ ಸಾಮಾನ್ಯ ಗುಣಿತ (LCM / ಲ.ಸಾ.ಅ) ಯಾವುದು?",
            options = listOf("60", "30", "20", "10"),
            correctAnswer = "60",
            explanation = "15 ಮತ್ತು 20 ಎರಡರಿಂದಲೂ ಭಾಗವಾಗುವ ಕನಿಷ್ಠ ಸಂಖ್ಯೆ 60."
        ),
        QuestionModel(
            id = "s_7_mat_u10_7",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "72 ಮತ್ತು 120 ರ ಗರಿಷ್ಠ ಸಾಮಾನ್ಯ ಅಪವರ್ತನ (HCF) ಎಷ್ಟು?",
            options = listOf("360", "120", "24", "72"),
            correctAnswer = "24",
            explanation = "72 = 24 × 3, 120 = 24 × 5. HCF = 24."
        ),
        QuestionModel(
            id = "s_7_mat_u10_8",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "123 ÷ 10 ಇದರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("1.23", "1230", "12.3", "0.123"),
            correctAnswer = "12.3",
            explanation = "10 ರಿಂದ ಭಾಗಿಸಿದಾಗ ದಶಮಾಂಶ ಬಿಂದು ಒಂದು ಸ್ಥಾನ ಎಡಕ್ಕೆ ಸರಿಯುತ್ತದೆ: 12.3."
        ),
        QuestionModel(
            id = "s_7_mat_u10_9",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "9.5 × 5 ಇದರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("475", "4.75", "0.475", "47.5"),
            correctAnswer = "47.5",
            explanation = "95 × 5 = 475 => 47.5."
        ),
        QuestionModel(
            id = "s_7_mat_u10_10",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "123 ÷ 1000 ಇದರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("1.23", "12.3", "0.123", "1230"),
            correctAnswer = "0.123",
            explanation = "123 / 1000 = 0.123."
        ),
        QuestionModel(
            id = "s_7_mat_u10_11",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "12.5 × 7 ಇದರ ಮೌಲ್ಯ ಎಷ್ಟು?",
            options = listOf("87.5", "8.75", "875", "19.5"),
            correctAnswer = "87.5",
            explanation = "125 × 7 = 875 => 87.5."
        ),
        QuestionModel(
            id = "s_7_mat_u10_12",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "0.7, 0.07, 0.707 ಸಂಖ್ಯೆಗಳ ಸರಿಯಾದ ಏರಿಕೆ ಕ್ರಮ (Ascending order) ಯಾವುದು?",
            options = listOf("0.07, 0.7, 0.707", "0.07, 0.707, 0.7", "0.7, 0.707, 0.07", "0.707, 0.07, 0.7"),
            correctAnswer = "0.07, 0.7, 0.707",
            explanation = "0.070 < 0.700 < 0.707."
        ),
        QuestionModel(
            id = "s_7_mat_u10_13",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "3.58 × 5 ರ ಗುಣಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("17.9", "1.79", "179", "8.58"),
            correctAnswer = "17.9",
            explanation = "358 × 5 = 1790 => 17.90 = 17.9."
        ),
        QuestionModel(
            id = "s_7_mat_u10_14",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "0.06 ÷ 5 ರ ಭಾಗಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("0.12", "1.2", "0.012", "12"),
            correctAnswer = "0.012",
            explanation = "6 / 5 = 1.2 => 0.06 / 5 = 0.012."
        ),
        QuestionModel(
            id = "s_7_mat_u10_15",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "18 × 1.2 ರ ಗುಣಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("2.16", "21.6", "216", "19.2"),
            correctAnswer = "21.6",
            explanation = "18 × 12 = 216 => 21.6."
        ),
        QuestionModel(
            id = "s_7_mat_u10_16",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "0.18 × 0.12 ರ ಗುಣಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("2.16", "0.216", "0.0216", "0.00216"),
            correctAnswer = "0.0216",
            explanation = "18 × 12 = 216; 4 ದಶಮಾಂಶ ಸ್ಥಾನಗಳಿರುವುದರಿಂದ 0.0216."
        ),
        QuestionModel(
            id = "s_7_mat_u10_17",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "0.07 × 0.06 ರ ಗುಣಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("0.42", "0.042", "0.0042", "4.2"),
            correctAnswer = "0.0042",
            explanation = "7 × 6 = 42; 4 ದಶಮಾಂಶ ಸ್ಥಾನಗಳಿರುವುದರಿಂದ 0.0042."
        ),
        QuestionModel(
            id = "s_7_mat_u10_18",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "756 ÷ 36 ರ ಭಾಗಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("2.1", "21", "210", "0.21"),
            correctAnswer = "21",
            explanation = "756 / 36 = 21."
        ),
        QuestionModel(
            id = "s_7_mat_u10_19",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "4.5 × 0.9 ರ ಗುಣಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("40.5", "4.05", "0.405", "5.4"),
            correctAnswer = "4.05",
            explanation = "45 × 9 = 405 => 4.05."
        ),
        QuestionModel(
            id = "s_7_mat_u10_20",
            stdId = 7,
            subjectId = "math",
            unitId = 10,
            type = "MCQ",
            questionText = "4.5 × 0.5 ರ ಗುಣಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("22.5", "2.25", "0.225", "9"),
            correctAnswer = "2.25",
            explanation = "45 × 5 = 225 => 2.25."
        )
    )
}
