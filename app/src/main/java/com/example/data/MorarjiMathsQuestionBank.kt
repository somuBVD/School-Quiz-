package com.example.data

/**
 * Morarji Desai Residential School (MDRS) Entrance Exam Preparation Question Bank.
 * Subject: Mathematics (ಗಣಿತ) (Standard / Exam ID: 11).
 * Total Units: 7 | Complete curriculum coverage for Class 5 to Class 6 MDRS entrance.
 */
object MorarjiMathsQuestionBank {
    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಸಂಖ್ಯಾ ಪದ್ಧತಿ ಮತ್ತು ಸ್ಥಾನಬೆಲೆ", 6, "Easy"),
        UnitTemplate(2, "ಘಟಕ 2: ಸಂಕಲನ ಮತ್ತು ವ್ಯವಕಲನ", 6, "Easy"),
        UnitTemplate(3, "ಘಟಕ 3: ಗುಣಾಕಾರ ಮತ್ತು ಭಾಗಾಕಾರ", 6, "Medium"),
        UnitTemplate(4, "ಘಟಕ 4: ಭಿನ್ನರಾಶಿಗಳು ಮತ್ತು ದಶಮಾಂಶಗಳು", 6, "Medium"),
        UnitTemplate(5, "ಘಟಕ 5: ಅಳತೆಗಳು — ಉದ್ದ, ತೂಕ, ಕಾಲ ಮತ್ತು ಹಣ", 6, "Medium"),
        UnitTemplate(6, "ಘಟಕ 6: ಜ್ಯಾಮಿತಿ, ಆಕೃತಿಗಳು ಮತ್ತು ಕೋನಗಳು", 6, "Medium"),
        UnitTemplate(7, "ಘಟಕ 7: ಪರಿಧಿ, ವಿಸ್ತೀರ್ಣ ಮತ್ತು ನಿತ್ಯಜೀವನದ ಲೆಕ್ಕಗಳು", 6, "Hard")
    )

    val questions: List<QuestionModel> = listOf(
        // ========================================================
        // ಘಟಕ 1: ಸಂಖ್ಯಾ ಪದ್ಧತಿ ಮತ್ತು ಸ್ಥಾನಬೆಲೆ (Number System & Place Value)
        // ========================================================
        QuestionModel(
            id = "morarji_math_u1_q1",
            stdId = 11,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "“ನಲವತ್ತೈದು ಸಾವಿರದ ಆರುನೂರ ಹದಿನೆಂಟು” ಇದನ್ನು ಸಂಖ್ಯಾರೂಪದಲ್ಲಿ ಬರೆದಾಗ:",
            options = listOf("45618", "54608", "45608", "45068"),
            correctAnswer = "45618",
            explanation = "40000 + 5000 + 600 + 10 + 8 = 45,618 (ನಲವತ್ತೈದು ಸಾವಿರದ ಆರುನೂರ ಹದಿನೆಂಟು)."
        ),
        QuestionModel(
            id = "morarji_math_u1_q2",
            stdId = 11,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "4940 ನ್ನು ಪದದಲ್ಲಿ ಬರೆದಾಗ:",
            options = listOf("ನಾಲ್ಕು ಸಾವಿರದ ಒಂಬೈನೂರ ನಲವತ್ತು", "ನಾಲ್ಕು ಸಾವಿರದ ನಲವತ್ತು", "ನಾಲ್ಕು ಸಾವಿರದ ನಾಲ್ಕು", "ನಾಲ್ಕು ನೂರ ನಲವತ್ತು"),
            correctAnswer = "ನಾಲ್ಕು ಸಾವಿರದ ಒಂಬೈನೂರ ನಲವತ್ತು",
            explanation = "4940 = ನಾಲ್ಕು ಸಾವಿರದ ಒಂಬೈನೂರ ನಲವತ್ತು."
        ),
        QuestionModel(
            id = "morarji_math_u1_q3",
            stdId = 11,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "35012, ಇದನ್ನು ಅಕ್ಷರದಲ್ಲಿ ಬರೆದಾಗ:",
            options = listOf("ಮೂವತ್ತೈದು ಸಾವಿರದ ಹನ್ನೆರಡು", "ಮೂರು ಸಾವಿರದ ಐದುನೂರ ಹನ್ನೆರಡು", "ಮೂರು ಸಾವಿರದ ಎರಡು ನೂರ ಹದಿನೆರಡು", "ಮೂವತ್ತೆರಡು ಸಾವಿರದ ಒಂದುನೂರ ಎರಡು"),
            correctAnswer = "ಮೂವತ್ತೈದು ಸಾವಿರದ ಹನ್ನೆರಡು",
            explanation = "35012 = ಮೂವತ್ತೈದು ಸಾವಿರದ ಹನ್ನೆರಡು."
        ),
        QuestionModel(
            id = "morarji_math_u1_q4",
            stdId = 11,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "78,452 ರಲ್ಲಿ 8 ರ ಸ್ಥಾನಬೆಲೆ (Place Value) ಎಷ್ಟು?",
            options = listOf("8,000", "800", "80,000", "80"),
            correctAnswer = "8,000",
            explanation = "8 ಸಾವಿರದ ಸ್ಥಾನದಲ್ಲಿದೆ (Thousands place), ಆದ್ದರಿಂದ ಅದರ ಸ್ಥಾನಬೆಲೆ 8 × 1000 = 8,000."
        ),
        QuestionModel(
            id = "morarji_math_u1_q5",
            stdId = 11,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "ಐದು ಅಂಕಿಗಳ ಅತ್ಯಂತ ದೊಡ್ಡ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("99,999", "10,000", "99,990", "90,000"),
            correctAnswer = "99,999",
            explanation = "ಐದು ಅಂಕಿಗಳ ಅತ್ಯಂತ ದೊಡ್ಡ ಸಂಖ್ಯೆ 99,999."
        ),
        QuestionModel(
            id = "morarji_math_u1_q6",
            stdId = 11,
            subjectId = "math",
            unitId = 1,
            type = "MCQ",
            questionText = "7, 0, 4, 8, 3 ಅಂಕಿಗಳನ್ನು ಒಮ್ಮೆ ಮಾತ್ರ ಬಳಸಿ ರಚಿಸಬಹುದಾದ ಅತ್ಯಂತ ಚಿಕ್ಕ 5 ಅಂಕಿಗಳ ಸಂಖ್ಯೆ ಯಾವುದು?",
            options = listOf("30,478", "03,478", "34,078", "30,748"),
            correctAnswer = "30,478",
            explanation = "ಶೂನ್ಯವನ್ನು ಮೊದಲ ಸ್ಥಾನದಲ್ಲಿಡಲು ಸಾಧ್ಯವಿಲ್ಲ, ಆದ್ದರಿಂದ ಎರಡನೇ ಚಿಕ್ಕ ಅಂಕಿಯಾದ 3 ನ್ನು ಮೊದಲು ಬರೆದು ನಂತರ 0, 4, 7, 8 ಜೋಡಿಸಿದರೆ 30,478 ಬರುತ್ತದೆ."
        ),

        // ========================================================
        // ಘಟಕ 2: ಸಂಕಲನ ಮತ್ತು ವ್ಯವಕಲನ (Addition & Subtraction)
        // ========================================================
        QuestionModel(
            id = "morarji_math_u2_q1",
            stdId = 11,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "25700 + 2546 + 16413 = ….",
            options = listOf("44659", "44349", "44369", "44379"),
            correctAnswer = "44659",
            explanation = "25700 + 2546 + 16413 = 44659."
        ),
        QuestionModel(
            id = "morarji_math_u2_q2",
            stdId = 11,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "3548 + 2120 = ….",
            options = listOf("5668", "5768", "5688", "5486"),
            correctAnswer = "5668",
            explanation = "3548 + 2120 = 5668."
        ),
        QuestionModel(
            id = "morarji_math_u2_q3",
            stdId = 11,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "9 + 99 + 999 ಇವುಗಳ ಮೊತ್ತವೇನು?",
            options = listOf("1107", "9999", "99999", "1999"),
            correctAnswer = "1107",
            explanation = "9 + 99 + 999 = 1107."
        ),
        QuestionModel(
            id = "morarji_math_u2_q4",
            stdId = 11,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "6423 – 1202 = ….",
            options = listOf("5221", "6221", "4221", "5122"),
            correctAnswer = "5221",
            explanation = "6423 - 1202 = 5221."
        ),
        QuestionModel(
            id = "morarji_math_u2_q5",
            stdId = 11,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "24500 + 2500 - 7000 = ….",
            options = listOf("20000", "27000", "34000", "22000"),
            correctAnswer = "20000",
            explanation = "24500 + 2500 = 27000, ಮತ್ತು 27000 - 7000 = 20000."
        ),
        QuestionModel(
            id = "morarji_math_u2_q6",
            stdId = 11,
            subjectId = "math",
            unitId = 2,
            type = "MCQ",
            questionText = "ಒಂದು ಗ್ರಾಮದ ಜನಸಂಖ್ಯೆ 8,450. ಅದರಲ್ಲಿ 4,120 ಪುರುಷರಿದ್ದರೆ, ಮಹಿಳೆಯರ ಸಂಖ್ಯೆ ಎಷ್ಟು?",
            options = listOf("4,330", "4,230", "4,130", "4,430"),
            correctAnswer = "4,330",
            explanation = "8,450 - 4,120 = 4,330."
        ),

        // ========================================================
        // ಘಟಕ 3: ಗುಣಾಕಾರ ಮತ್ತು ಭಾಗಾಕಾರ (Multiplication & Division)
        // ========================================================
        QuestionModel(
            id = "morarji_math_u3_q1",
            stdId = 11,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "125 × 8 ರ ಗುಣಲಬ್ಧವೆಷ್ಟು?",
            options = listOf("1000", "950", "1250", "800"),
            correctAnswer = "1000",
            explanation = "125 × 8 = 1000."
        ),
        QuestionModel(
            id = "morarji_math_u3_q2",
            stdId = 11,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಪುಸ್ತಕದ ಬೆಲೆ ₹45 ಆದರೆ, ಅಂತಹ 12 ಪುಸ್ತಕಗಳ ಒಟ್ಟು ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("₹540", "₹500", "₹480", "₹600"),
            correctAnswer = "₹540",
            explanation = "45 × 12 = 540."
        ),
        QuestionModel(
            id = "morarji_math_u3_q3",
            stdId = 11,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "720 ನ್ನು 9 ರಿಂದ ಭಾಗಿಸಿದಾಗ ಬರುವ ಭಾಗಲಬ್ಧ ಎಷ್ಟು?",
            options = listOf("80", "70", "90", "8"),
            correctAnswer = "80",
            explanation = "720 ÷ 9 = 80."
        ),
        QuestionModel(
            id = "morarji_math_u3_q4",
            stdId = 11,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಯಾವುದೇ ಸಂಖ್ಯೆಯನ್ನು ಸೊನ್ನೆಯಿಂದ (0) ಗುಣಿಸಿದಾಗ ಬರುವ ಗುಣಲಬ್ಧ ಯಾವಾಗಲೂ:",
            options = listOf("0", "1", "ಅದೇ ಸಂಖ್ಯೆ", "ಹತ್ತು"),
            correctAnswer = "0",
            explanation = "ಯಾವುದೇ ಸಂಖ್ಯೆಯನ್ನು 0 ಯಿಂದ ಗುಣಿಸಿದಾಗ ಫಲಿತಾಂಶ ಯಾವಾಗಲೂ 0 ಆಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "morarji_math_u3_q5",
            stdId = 11,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "345 ನ್ನು 15 ರಿಂದ ಭಾಗಿಸಿದಾಗ ಶೇಷವು (Remainder) ಎಷ್ಟು ಉಳಿಯುತ್ತದೆ?",
            options = listOf("0", "5", "3", "1"),
            correctAnswer = "0",
            explanation = "345 ÷ 15 = 23, ಸಂಪೂರ್ಣವಾಗಿ ಭಾಗವಾಗುತ್ತದೆ, ಶೇಷ 0."
        ),
        QuestionModel(
            id = "morarji_math_u3_q6",
            stdId = 11,
            subjectId = "math",
            unitId = 3,
            type = "MCQ",
            questionText = "ಒಂದು ಪೆಟ್ಟಿಗೆಯಲ್ಲಿ 24 ಸೇಬುಗಳಿವೆ. ಅಂತಹ 15 ಪೆಟ್ಟಿಗೆಗಳಲ್ಲಿರುವ ಒಟ್ಟು ಸೇಬುಗಳೆಷ್ಟು?",
            options = listOf("360", "340", "380", "400"),
            correctAnswer = "360",
            explanation = "24 × 15 = 360 ಸೇಬುಗಳು."
        ),

        // ========================================================
        // ಘಟಕ 4: ಭಿನ್ನರಾಶಿಗಳು ಮತ್ತು ದಶಮಾಂಶಗಳು (Fractions & Decimals)
        // ========================================================
        QuestionModel(
            id = "morarji_math_u4_q1",
            stdId = 11,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "3/4 ಭಿನ್ನರಾಶಿಯಲ್ಲಿ ಛೇದ (Denominator) ಯಾವುದು?",
            options = listOf("4", "3", "7", "1"),
            correctAnswer = "4",
            explanation = "ಭಿನ್ನರಾಶಿಯಲ್ಲಿ ಮೇಲಿನ ಸಂಖ್ಯೆ ಅಂಶ (Numerator = 3), ಕೆಳಗಿನ ಸಂಖ್ಯೆ ಛೇದ (Denominator = 4)."
        ),
        QuestionModel(
            id = "morarji_math_u4_q2",
            stdId = 11,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "1/2 ಮತ್ತು 1/4 ಇವುಗಳ ಮೊತ್ತವೆಷ್ಟು?",
            options = listOf("3/4", "2/6", "1/8", "2/4"),
            correctAnswer = "3/4",
            explanation = "1/2 = 2/4. ಆದ್ದರಿಂದ 2/4 + 1/4 = 3/4."
        ),
        QuestionModel(
            id = "morarji_math_u4_q3",
            stdId = 11,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "1/2 ನ್ನು ದಶಮಾಂಶ ರೂಪದಲ್ಲಿ ಬರೆದಾಗ:",
            options = listOf("0.5", "0.2", "0.25", "0.05"),
            correctAnswer = "0.5",
            explanation = "1 ÷ 2 = 0.5 (ಅರ್ಧ)."
        ),
        QuestionModel(
            id = "morarji_math_u4_q4",
            stdId = 11,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "0.75 ನ್ನು ಸಾಮಾನ್ಯ ಭಿನ್ನರಾಶಿಯಾಗಿ ಪರಿವರ್ತಿಸಿದಾಗ:",
            options = listOf("3/4", "7/5", "1/4", "1/2"),
            correctAnswer = "3/4",
            explanation = "0.75 = 75/100 = 3/4."
        ),
        QuestionModel(
            id = "morarji_math_u4_q5",
            stdId = 11,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "ಕೆಳಗಿನವುಗಳಲ್ಲಿ ಸಮ ಭಿನ್ನರಾಶಿ (Proper Fraction) ಯಾವುದು?",
            options = listOf("5/8", "9/4", "7/3", "8/5"),
            correctAnswer = "5/8",
            explanation = "ಅಂಶವು ಛೇದಕ್ಕಿಂತ ಚಿಕ್ಕದಾಗಿರುವ ಭಿನ್ನರಾಶಿಯನ್ನು ಸಮ ಭಿನ್ನರಾಶಿ ಎನ್ನುತ್ತಾರೆ (5 < 8)."
        ),
        QuestionModel(
            id = "morarji_math_u4_q6",
            stdId = 11,
            subjectId = "math",
            unitId = 4,
            type = "MCQ",
            questionText = "5/7 - 2/7 ರ ಬೆಲೆ ಎಷ್ಟು?",
            options = listOf("3/7", "7/7", "3/0", "3/14"),
            correctAnswer = "3/7",
            explanation = "ಛೇದಗಳು ಸಮನಾಗಿರುವುದರಿಂದ: (5 - 2)/7 = 3/7."
        ),

        // ========================================================
        // ಘಟಕ 5: ಅಳತೆಗಳು — ಉದ್ದ, ತೂಕ, ಕಾಲ ಮತ್ತು ಹಣ (Measurements)
        // ========================================================
        QuestionModel(
            id = "morarji_math_u5_q1",
            stdId = 11,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "1 ಕಿಲೋಮೀಟರ್ (km) ನಲ್ಲಿ ಎಷ್ಟು ಮೀಟರ್‌ಗಳಿವೆ?",
            options = listOf("1000 ಮೀಟರ್", "100 ಮೀಟರ್", "10 ಮೀಟರ್", "10000 ಮೀಟರ್"),
            correctAnswer = "1000 ಮೀಟರ್",
            explanation = "1 km = 1,000 ಮೀಟರ್."
        ),
        QuestionModel(
            id = "morarji_math_u5_q2",
            stdId = 11,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "2 ಕಿಲೋಗ್ರಾಂ (kg) = ಎಷ್ಟು ಗ್ರಾಂಗಳು?",
            options = listOf("2000 ಗ್ರಾಂ", "200 ಗ್ರಾಂ", "20 ಗ್ರಾಂ", "500 ಗ್ರಾಂ"),
            correctAnswer = "2000 ಗ್ರಾಂ",
            explanation = "1 kg = 1000 ಗ್ರಾಂ, ಆದ್ದರಿಂದ 2 kg = 2000 ಗ್ರಾಂ."
        ),
        QuestionModel(
            id = "morarji_math_u5_q3",
            stdId = 11,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "3 ಗಂಟೆಗಳಲ್ಲಿ ಎಷ್ಟು ನಿಮಿಷಗಳಿವೆ?",
            options = listOf("180 ನಿಮಿಷ", "120 ನಿಮಿಷ", "150 ನಿಮಿಷ", "200 ನಿಮಿಷ"),
            correctAnswer = "180 ನಿಮಿಷ",
            explanation = "1 ಗಂಟೆ = 60 ನಿಮಿಷ. 3 × 60 = 180 ನಿಮಿಷಗಳು."
        ),
        QuestionModel(
            id = "morarji_math_u5_q4",
            stdId = 11,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಒಂದು ಲೀಟರ್‌ನಲ್ಲಿ (L) ಎಷ್ಟು ಮಿಲಿಲೀಟರ್‌ಗಳಿವೆ (mL)?",
            options = listOf("1000 mL", "100 mL", "500 mL", "10000 mL"),
            correctAnswer = "1000 mL",
            explanation = "1 L = 1000 mL."
        ),
        QuestionModel(
            id = "morarji_math_u5_q5",
            stdId = 11,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ರಾಜು ಬಳಿ ₹50 ಇತ್ತು. ಅವನು ₹23.50 ರ ಪೆನ್ ಖರೀದಿಸಿದರೆ, ಅವನ ಬಳಿ ಉಳಿದ ಹಣವೆಷ್ಟು?",
            options = listOf("₹26.50", "₹27.50", "₹26.00", "₹25.50"),
            correctAnswer = "₹26.50",
            explanation = "₹50.00 - ₹23.50 = ₹26.50."
        ),
        QuestionModel(
            id = "morarji_math_u5_q6",
            stdId = 11,
            subjectId = "math",
            unitId = 5,
            type = "MCQ",
            questionText = "ಲೀಪ್ ವರ್ಷದಲ್ಲಿ (Leap Year) ಫೆಬ್ರವರಿ ತಿಂಗಳಲ್ಲಿ ಎಷ್ಟು ದಿನಗಳಿರುತ್ತವೆ?",
            options = listOf("29 ದಿನಗಳು", "28 ದಿನಗಳು", "30 ದಿನಗಳು", "31 ದಿನಗಳು"),
            correctAnswer = "29 ದಿನಗಳು",
            explanation = "ಸಾಮಾನ್ಯ ವರ್ಷದಲ್ಲಿ 28 ದಿನಗಳಿರುತ್ತವೆ, ಲೀಪ್ ವರ್ಷದಲ್ಲಿ 29 ದಿನಗಳಿರುತ್ತವೆ."
        ),

        // ========================================================
        // ಘಟಕ 6: ಜ್ಯಾಮಿತಿ, ಆಕೃತಿಗಳು ಮತ್ತು ಕೋನಗಳು (Geometry, Shapes & Angles)
        // ========================================================
        QuestionModel(
            id = "morarji_math_u6_q1",
            stdId = 11,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "90° ಅಳತೆಯ ಕೋನವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಲಂಬಕೋನ (Right Angle)", "ಲಘುಕೋನ (Acute Angle)", "ವಿಶಾಲಕೋನ (Obtuse Angle)", "ಸರಳಕೋನ (Straight Angle)"),
            correctAnswer = "ಲಂಬಕೋನ (Right Angle)",
            explanation = "ನಿಖರವಾಗಿ 90° ಇರುವ ಕೋನವೇ ಲಂಬಕೋನ."
        ),
        QuestionModel(
            id = "morarji_math_u6_q2",
            stdId = 11,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ತ್ರಿಭುಜದ ಮೂರು ಒಳಕೋನಗಳ ಮೊತ್ತ ಎಷ್ಟು?",
            options = listOf("180°", "360°", "90°", "270°"),
            correctAnswer = "180°",
            explanation = "ಯಾವುದೇ ತ್ರಿಭುಜದ ಮೂರು ಕೋನಗಳ ಮೊತ್ತ ಯಾವಾಗಲೂ 180° ಆಗಿರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "morarji_math_u6_q3",
            stdId = 11,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ನಾಲ್ಕೂ ಬಾಹುಗಳು ಪರಸ್ಪರ ಸಮನಾಗಿರುವ ಚತುರ್ಭುಜ ಯಾವುದು?",
            options = listOf("ಚೌಕ (Square)", "ಆಯತ (Rectangle)", "ತ್ರಾಪಿಜ್ಯ (Trapezium)", "ವೃತ್ತ (Circle)"),
            correctAnswer = "ಚೌಕ (Square)",
            explanation = "ಚೌಕದ ನಾಲ್ಕೂ ಬಾಹುಗಳು ಸಮನಾಗಿರುತ್ತವೆ ಮತ್ತು ಎಲ್ಲಾ ಕೋನಗಳು 90° ಆಗಿರುತ್ತವೆ."
        ),
        QuestionModel(
            id = "morarji_math_u6_q4",
            stdId = 11,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ವೃತ್ತದ ಕೇಂದ್ರ ಬಿಂದುವಿನ ಮೂಲಕ ಹಾದುಹೋಗುವ ಅತ್ಯಂತ ಉದ್ದವಾದ ಜ್ಯಾವನ್ನು ಏನೆನ್ನುತ್ತಾರೆ?",
            options = listOf("ವ್ಯಾಸ (Diameter)", "ತ್ರಿಜ್ಯ (Radius)", "ಕಂಸ (Arc)", "ಪರಿಧಿ (Circumference)"),
            correctAnswer = "ವ್ಯಾಸ (Diameter)",
            explanation = "ವೃತ್ತ ಕೇಂದ್ರದ ಮೂಲಕ ಹಾದುಹೋಗುವ ರೇಖಾಖಂಡವೇ ವ್ಯಾಸ (ವ್ಯಾಸ = 2 × ತ್ರಿಜ್ಯ)."
        ),
        QuestionModel(
            id = "morarji_math_u6_q5",
            stdId = 11,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "90° ಗಿಂತ ಕಡಿಮೆ ಇರುವ ಕೋನವನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಲಘುಕೋನ (Acute angle)", "ವಿಶಾಲಕೋನ (Obtuse angle)", "ಲಂಬಕೋನ (Right angle)", "ಶೂನ್ಯ ಕೋನ"),
            correctAnswer = "ಲಘುಕೋನ (Acute angle)",
            explanation = "0° ಗಿಂತ ಹೆಚ್ಚು ಮತ್ತು 90° ಗಿಂತ ಕಡಿಮೆ ಇರುವ ಕೋನ ಲಘುಕೋನ."
        ),
        QuestionModel(
            id = "morarji_math_u6_q6",
            stdId = 11,
            subjectId = "math",
            unitId = 6,
            type = "MCQ",
            questionText = "ಒಂದು ಘನಾಕೃತಿಗೆ (Cube) ಎಷ್ಟು ಮುಖಗಳಿರುತ್ತವೆ (Faces)?",
            options = listOf("6", "8", "12", "4"),
            correctAnswer = "6",
            explanation = "ಘನಕ್ಕೆ 6 ಮುಖಗಳು, 8 ಶೃಂಗಗಳು ಮತ್ತು 12 ಅಂಚುಗಳಿರುತ್ತವೆ."
        ),

        // ========================================================
        // ಘಟಕ 7: ಪರಿಧಿ, ವಿಸ್ತೀರ್ಣ ಮತ್ತು ನಿತ್ಯಜೀವನದ ಲೆಕ್ಕಗಳು (Perimeter, Area & Real-life)
        // ========================================================
        QuestionModel(
            id = "morarji_math_u7_q1",
            stdId = 11,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "ಬಾಹುವಿನ ಉದ್ದ 6 ಸೆಂ.ಮೀ. ಇರುವ ಚೌಕದ ಪರಿಧಿ (Perimeter) ಎಷ್ಟು?",
            options = listOf("24 ಸೆಂ.ಮೀ.", "36 ಸೆಂ.ಮೀ.", "12 ಸೆಂ.ಮೀ.", "18 ಸೆಂ.ಮೀ."),
            correctAnswer = "24 ಸೆಂ.ಮೀ.",
            explanation = "ಚೌಕದ ಪರಿಧಿ = 4 × ಬಾಹು = 4 × 6 = 24 ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "morarji_math_u7_q2",
            stdId = 11,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "ಉದ್ದ 8 ಮೀಟರ್ ಮತ್ತು ಅಗಲ 5 ಮೀಟರ್ ಇರುವ ಆಯತದ ವಿಸ್ತೀರ್ಣ (Area) ಎಷ್ಟು?",
            options = listOf("40 ಚದರ ಮೀಟರ್", "26 ಮೀಟರ್", "13 ಚದರ ಮೀಟರ್", "80 ಚದರ ಮೀಟರ್"),
            correctAnswer = "40 ಚದರ ಮೀಟರ್",
            explanation = "ಆಯತದ ವಿಸ್ತೀರ್ಣ = ಉದ್ದ × ಅಗಲ = 8 × 5 = 40 ಚದರ ಮೀಟರ್."
        ),
        QuestionModel(
            id = "morarji_math_u7_q3",
            stdId = 11,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "ಬಾಹುವಿನ ಉದ್ದ 5 ಸೆಂ.ಮೀ. ಇರುವ ಚೌಕದ ವಿಸ್ತೀರ್ಣ ಎಷ್ಟು?",
            options = listOf("25 ಚದರ ಸೆಂ.ಮೀ.", "20 ಸೆಂ.ಮೀ.", "10 ಚದರ ಸೆಂ.ಮೀ.", "30 ಚದರ ಸೆಂ.ಮೀ."),
            correctAnswer = "25 ಚದರ ಸೆಂ.ಮೀ.",
            explanation = "ಚೌಕದ ವಿಸ್ತೀರ್ಣ = ಬಾಹು × ಬಾಹು = 5 × 5 = 25 ಚದರ ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "morarji_math_u7_q4",
            stdId = 11,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "ಉದ್ದ 10 ಸೆಂ.ಮೀ. ಮತ್ತು ಅಗಲ 4 ಸೆಂ.ಮೀ. ಇರುವ ಆಯತದ ಪರಿಧಿ ಎಷ್ಟು?",
            options = listOf("28 ಸೆಂ.ಮೀ.", "40 ಸೆಂ.ಮೀ.", "14 ಸೆಂ.ಮೀ.", "24 ಸೆಂ.ಮೀ."),
            correctAnswer = "28 ಸೆಂ.ಮೀ.",
            explanation = "ಆಯತದ ಪರಿಧಿ = 2 × (ಉದ್ದ + ಅಗಲ) = 2 × (10 + 4) = 2 × 14 = 28 ಸೆಂ.ಮೀ."
        ),
        QuestionModel(
            id = "morarji_math_u7_q5",
            stdId = 11,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "ಒಬ್ಬ ವ್ಯಾಪಾರಿ ₹400 ಕ್ಕೆ ಕೊಂಡ ವಸ್ತುವನ್ನು ₹480 ಕ್ಕೆ ಮಾರಿದರೆ, ಅವನಿಗೆ ಆದ ಲಾಭವೆಷ್ಟು?",
            options = listOf("₹80 ಲಾಭ", "₹60 ಲಾಭ", "₹80 ನಷ್ಟ", "₹100 ಲಾಭ"),
            correctAnswer = "₹80 ಲಾಭ",
            explanation = "ಮಾರಿದ ಬೆಲೆ ₹480 - ಕೊಂಡ ಬೆಲೆ ₹400 = ₹80 ಲಾಭ."
        ),
        QuestionModel(
            id = "morarji_math_u7_q6",
            stdId = 11,
            subjectId = "math",
            unitId = 7,
            type = "MCQ",
            questionText = "12, 18, ಮತ್ತು 24 ಗಳ ಸರಾಸರಿ (Average) ಎಷ್ಟು?",
            options = listOf("18", "16", "20", "54"),
            correctAnswer = "18",
            explanation = "ಸರಾಸರಿ = (12 + 18 + 24) ÷ 3 = 54 ÷ 3 = 18."
        )
    )
}
