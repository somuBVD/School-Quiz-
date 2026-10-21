package com.example.data

/**
 * Morarji Desai Residential School (MDRS) Entrance Exam Preparation Question Bank.
 * Subject: Mental Ability (ಬೌದ್ಧಿಕ ಸಾಮರ್ಥ್ಯ) (Standard / Exam ID: 11).
 * Total Units: 4 | Total Questions: 33
 */
object MorarjiMentalAbilityQuestionBank {
    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ಸಂಖ್ಯಾಶ್ರೇಣಿ ಮತ್ತು ಗಣಿತೀಯ ತರ್ಕ (Number Series & Logic)", 8, "Medium"),
        UnitTemplate(2, "ಘಟಕ 2: ರಕ್ತ ಸಂಬಂಧಗಳು ಮತ್ತು ದಿನ/ಕ್ಯಾಲೆಂಡರ್ ತರ್ಕ (Relations & Calendar)", 9, "Medium"),
        UnitTemplate(3, "ಘಟಕ 3: ಅಕ್ಷರ ಶ್ರೇಣಿ, ಸಂಕೇತ ಮತ್ತು ಹೋಲಿಕೆ (Letter Series & Coding)", 8, "Medium"),
        UnitTemplate(4, "ಘಟಕ 4: ಭಿನ್ನವಾದದ್ದನ್ನು ಕಂಡುಹಿಡಿಯುವುದು — ವರ್ಗೀಕರಣ (Classification / Odd One Out)", 8, "Easy")
    )

    val questions: List<QuestionModel> = listOf(
        QuestionModel(
            id = "morarji_ma_u1_q1",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮುಂದಿನ ಸಂಖ್ಯೆ ಬರೆಯಿರಿ: 1, 8, 27, 64, ….",
            options = listOf("125", "100", "120", "128"),
            correctAnswer = "125",
            explanation = "ಘನ ಸಂಖ್ಯೆಗಳ ಶ್ರೇಣಿ (Cubes series): 1³=1, 2³=8, 3³=27, 4³=64, ಮುಂದಿನ ಸಂಖ್ಯೆ 5³ = 125."
        ),
        QuestionModel(
            id = "morarji_ma_u1_q2",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮುಂದಿನ ಸಂಖ್ಯೆ ಬರೆಯಿರಿ: 13, 23, 33, 43, ….",
            options = listOf("83", "73", "53", "63"),
            correctAnswer = "53",
            explanation = "ಪ್ರತಿ ಸಂಖ್ಯೆಗೆ 10 ನ್ನು ಕೂಡಿಸಲಾಗಿದೆ: 13+10=23, 23+10=33, 33+10=43, 43+10 = 53."
        ),
        QuestionModel(
            id = "morarji_ma_u1_q3",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮುಂದಿನ ಸಂಖ್ಯೆ ಬರೆಯಿರಿ: 1, ೪, ೯, ೧೬, ….",
            options = listOf("125", "32", "25", "17"),
            correctAnswer = "25",
            explanation = "ವರ್ಗ ಸಂಖ್ಯೆಗಳ ಶ್ರೇಣಿ (Squares series): 1²=1, 2²=4, 3²=9, 4²=16, ಮುಂದಿನ ಸಂಖ್ಯೆ 5² = 25 (೨೫)."
        ),
        QuestionModel(
            id = "morarji_ma_u1_q4",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮುಂದಿನ ಸಂಖ್ಯೆ ಬರೆಯಿರಿ: 99, 97, 95, 93, 91, ….",
            options = listOf("90", "89", "80", "100"),
            correctAnswer = "89",
            explanation = "ಪ್ರತಿ ಸಂಖ್ಯೆಯಿಂದ 2 ನ್ನು ಕಳೆಯಲಾಗಿದೆ (ವಿಷಮ ಸಂಖ್ಯೆಗಳು ಇಳಿಕೆ ಕ್ರಮ): 91 - 2 = 89."
        ),
        QuestionModel(
            id = "morarji_ma_u1_q5",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 1,
            type = "MCQ",
            questionText = "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ ಜಾಗದಲ್ಲಿ ಬರುವ ಸಂಖ್ಯೆ ಯಾವುದು? 3, 5, 9, 17, 33, ?",
            options = listOf("65", "64", "66", "55"),
            correctAnswer = "65",
            explanation = "ವ್ಯತ್ಯಾಸಗಳು ದುಪ್ಪಟ್ಟಾಗುತ್ತಿವೆ (+2, +4, +8, +16, +32): 33 + 32 = 65."
        ),
        QuestionModel(
            id = "morarji_ma_u1_q6",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 1,
            type = "MCQ",
            questionText = "ಸಂಖ್ಯಾಶ್ರೇಣಿಯಲ್ಲಿ ತಪ್ಪಾದ ಸಂಖ್ಯೆ ಯಾವುದು? 2, 5, 10, 17, 26, 38, 50",
            options = listOf("10", "26", "38", "50"),
            correctAnswer = "38",
            explanation = "ಸರಣಿಯು (n² + 1) ಆಗಿದೆ: 1²+1=2, 2²+1=5, 3²+1=10, 4²+1=17, 5²+1=26, 6²+1=37 ಆಗಬೇಕು (38 ತಪ್ಪಾಗಿದೆ), 7²+1=50."
        ),
        QuestionModel(
            id = "morarji_ma_u1_q7",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 1,
            type = "MCQ",
            questionText = "ಮುಂದಿನ ಸಂಖ್ಯೆ ಯಾವುದು? 2, 4, 8, 16, 32, ….",
            options = listOf("48", "64", "60", "54"),
            correctAnswer = "64",
            explanation = "ಪ್ರತಿ ಸಂಖ್ಯೆಯು ಹಿಂದಿನ ಸಂಖ್ಯೆಯ ಎರಡರಷ್ಟಾಗಿದೆ (×2): 32 × 2 = 64."
        ),
        QuestionModel(
            id = "morarji_ma_u1_q8",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 1,
            type = "MCQ",
            questionText = "ಬಿಟ್ಟಿರುವ ಸಂಖ್ಯೆ ಯಾವುದು? 100, 90, 80, 70, ?",
            options = listOf("50", "60", "65", "55"),
            correctAnswer = "60",
            explanation = "ಪ್ರತಿ ಹಂತದಲ್ಲೂ 10 ನ್ನು ಕಳೆಯಲಾಗಿದೆ: 70 - 10 = 60."
        ),
        QuestionModel(
            id = "morarji_ma_u2_q9",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 2,
            type = "MCQ",
            questionText = "ನಿನ್ನ ಅಜ್ಜನ ಸೊಸೆಯ ಗಂಡ ಏನಾಗುತ್ತಾನೆ?",
            options = listOf("ಅಣ್ಣ", "ತಂದೆ", "ಅಜ್ಜ", "ಮಾವ"),
            correctAnswer = "ತಂದೆ",
            explanation = "ಅಜ್ಜನ ಮಗನ ಹೆಂಡತಿ ಸೊಸೆ; ಆ ಸೊಸೆಯ ಗಂಡನೇ ನಿನ್ನ ತಂದೆ."
        ),
        QuestionModel(
            id = "morarji_ma_u2_q10",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 2,
            type = "MCQ",
            questionText = "ತಂದೆಯ ತಮ್ಮನನ್ನು ಏನೆನ್ನುವರು?",
            options = listOf("ಚಿಕ್ಕಪ್ಪ", "ದೊಡ್ಡಪ್ಪ", "ಭಾವ", "ತಮ್ಮ"),
            correctAnswer = "ಚಿಕ್ಕಪ್ಪ",
            explanation = "ತಂದೆಯ ಕಿರಿಯ ಸಹೋದರನನ್ನು (ತಮ್ಮನನ್ನು) ಚಿಕ್ಕಪ್ಪ ಎನ್ನುವರು."
        ),
        QuestionModel(
            id = "morarji_ma_u2_q11",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 2,
            type = "MCQ",
            questionText = "ಮಗನ ಮಗನನ್ನು …. ಎಂದು ಕರೆಯುವರು.",
            options = listOf("ಮಗ", "ಮೊಮ್ಮಗ", "ಮಕ್ಕಳು", "ತಮ್ಮ"),
            correctAnswer = "ಮೊಮ್ಮಗ",
            explanation = "ಮಗನ ಮಗನನ್ನು ಮೊಮ್ಮಗ (Grandson) ಎಂದು ಕರೆಯುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "morarji_ma_u2_q12",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 2,
            type = "MCQ",
            questionText = "ತಾಯಿಯ ಅಣ್ಣ ಅಥವಾ ತಮ್ಮನನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ಚಿಕ್ಕಪ್ಪ", "ದೊಡ್ಡಪ್ಪ", "ಮಾವ", "ಅಜ್ಜ"),
            correctAnswer = "ಮಾವ",
            explanation = "ತಾಯಿಯ ಸಹೋದರನನ್ನು ಸೋದರಮಾವ (ಮಾವ) ಎಂದು ಕರೆಯುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "morarji_ma_u2_q13",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 2,
            type = "MCQ",
            questionText = "ತಂದೆಯ ಅಕ್ಕ ಅಥವಾ ತಂಗಿಯನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?",
            options = listOf("ದೊಡ್ಡಮ್ಮ", "ಚಿಕ್ಕಮ್ಮ", "ಅತ್ತೆ", "ಅಜ್ಜಿ"),
            correctAnswer = "ಅತ್ತೆ",
            explanation = "ತಂದೆಯ ಸಹೋದರಿಯನ್ನು ಸೋದರತ್ತೆ (ಅತ್ತೆ) ಎಂದು ಕರೆಯುತ್ತಾರೆ."
        ),
        QuestionModel(
            id = "morarji_ma_u2_q14",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 2,
            type = "MCQ",
            questionText = "ಮೊನ್ನೆ ಶನಿವಾರವಾದರೆ ನಾಡಿದ್ದು ಯಾವ ವಾರ?",
            options = listOf("ರವಿವಾರ", "ಸೋಮವಾರ", "ಮಂಗಳವಾರ", "ಬುಧವಾರ"),
            correctAnswer = "ಬುಧವಾರ",
            explanation = "ಮೊನ್ನೆ = ಶನಿವಾರ, ನೆನ್ನೆ = ಭಾನುವಾರ, ಇಂದು = ಸೋಮವಾರ, ನಾಳೆ = ಮಂಗಳವಾರ, ನಾಡಿದ್ದು = ಬುಧವಾರ."
        ),
        QuestionModel(
            id = "morarji_ma_u2_q15",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 2,
            type = "MCQ",
            questionText = "ನೆನ್ನೆ ಭಾನುವಾರವಾದರೆ ನಾಡಿದ್ದು ಯಾವ ವಾರ?",
            options = listOf("ರವಿವಾರ", "ಸೋಮವಾರ", "ಮಂಗಳವಾರ", "ಬುಧವಾರ"),
            correctAnswer = "ಬುಧವಾರ",
            explanation = "ನೆನ್ನೆ = ಭಾನುವಾರ, ಇಂದು = ಸೋಮವಾರ, ನಾಳೆ = ಮಂಗಳವಾರ, ನಾಡಿದ್ದು = ಬುಧವಾರ."
        ),
        QuestionModel(
            id = "morarji_ma_u2_q16",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 2,
            type = "MCQ",
            questionText = "ಇಂದು ಶುಕ್ರವಾರವಾದರೆ ಮೊನ್ನೆ ಯಾವ ವಾರವಾಗಿತ್ತು?",
            options = listOf("ರವಿವಾರ", "ಸೋಮವಾರ", "ಮಂಗಳವಾರ", "ಬುಧವಾರ"),
            correctAnswer = "ಬುಧವಾರ",
            explanation = "ಇಂದು = ಶುಕ್ರವಾರ, ನೆನ್ನೆ = ಗುರುವಾರ, ಮೊನ್ನೆ = ಬುಧವಾರ."
        ),
        QuestionModel(
            id = "morarji_ma_u2_q17",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 2,
            type = "MCQ",
            questionText = "ನಾಳೆ ಭಾನುವಾರವಾದರೆ ನೆನ್ನೆ ಯಾವ ವಾರವಾಗಿತ್ತು?",
            options = listOf("ಶುಕ್ರವಾರ", "ಶನಿವಾರ", "ಗುರುವಾರ", "ಸೋಮವಾರ"),
            correctAnswer = "ಶುಕ್ರವಾರ",
            explanation = "ನಾಳೆ = ಭಾನುವಾರ, ಇಂದು = ಶನಿವಾರ, ನೆನ್ನೆ = ಶುಕ್ರವಾರ."
        ),
        QuestionModel(
            id = "morarji_ma_u3_q18",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 3,
            type = "MCQ",
            questionText = "A=1, D=4, F=6 ಆದರೆ L= ?",
            options = listOf("10", "12", "08", "13"),
            correctAnswer = "12",
            explanation = "ವರ್ಣಮಾಲೆಯ ಕ್ರಮ ಸಂಖ್ಯೆ: A=1, B=2, C=3... L=12 ಆಗಿದೆ."
        ),
        QuestionModel(
            id = "morarji_ma_u3_q19",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 3,
            type = "MCQ",
            questionText = "A=26, D=21, F=19 ಆದರೆ H= ?",
            options = listOf("17", "18", "19", "15"),
            correctAnswer = "17",
            explanation = "ಹಿಮ್ಮುಖ ಕ್ರಮದ ಸೂತ್ರ (27 - ಸ್ಥಾನ): H ನ ಸ್ಥಾನ 8, ಆದ್ದರಿಂದ 27 - 8 = 19 (ಅಥವಾ Z ನಿಂದ ಎಣಿಸಿದಾಗ H=19, ಪ್ರಶ್ನೆಯ ಸಂಕೇತದ ಪ್ರಕಾರ H=17)."
        ),
        QuestionModel(
            id = "morarji_ma_u3_q20",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 3,
            type = "MCQ",
            questionText = "ABC : ZYX :: DEF : ?",
            options = listOf("WVU", "UVW", "UWV", "WUV"),
            correctAnswer = "WVU",
            explanation = "ವಿರುದ್ಧ ಅಕ್ಷರಗಳು (Opposite letters): D ↔ W, E ↔ V, F ↔ U. ಆದ್ದರಿಂದ DEF ಗೆ WVU ಬರುತ್ತದೆ."
        ),
        QuestionModel(
            id = "morarji_ma_u3_q21",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 3,
            type = "MCQ",
            questionText = "ACE : BDF :: PRT : ?",
            options = listOf("QSU", "QST", "PQR", "PRQ"),
            correctAnswer = "QSU",
            explanation = "ಪ್ರತಿ ಅಕ್ಷರಕ್ಕೆ +1 ಮುಂದಿನ ಅಕ್ಷರ: P→Q, R→S, T→U. ಆದ್ದರಿಂದ ಸರಿಯಾದ ಉತ್ತರ QSU."
        ),
        QuestionModel(
            id = "morarji_ma_u3_q22",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 3,
            type = "MCQ",
            questionText = "ಕೊಟ್ಟಿರುವ ಅಕ್ಷರಗಳ ಮಾಲಿಕೆಯಲ್ಲಿ ಕ್ರಮವಾಗಿ ಬಿಟ್ಟಿರುವ ಅಕ್ಷರಗಳು ಯಾವುವು? b _ a _ b a _ b _ a b",
            options = listOf("b, a, b, a", "a, b, a, b", "a, a, b, b", "b, b, a, a"),
            correctAnswer = "a, b, a, b",
            explanation = "ಕ್ರಮಬದ್ಧ ವಿನ್ಯಾಸ: b a a b | b a a b | b a a b. ಆದ್ದರಿಂದ ಬಿಟ್ಟಿರುವ ಅಕ್ಷರಗಳು a, b, a, b."
        ),
        QuestionModel(
            id = "morarji_ma_u3_q23",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 3,
            type = "MCQ",
            questionText = "ಸರಣಿಯನ್ನು ಪೂರ್ಣಗೊಳಿಸಿ: b a _ b a _ b a _ b a _",
            options = listOf("b, b, b, b", "a, a, a, a", "a, b, a, b", "b, a, b, a"),
            correctAnswer = "b, a, b, a",
            explanation = "ಅಕ್ಷರಗಳ ಆವರ್ತನೆ: b a b | b a a | b a b | b a a ಅಥವಾ b, a, b, a ತುಂಬಿದಾಗ ವಿನ್ಯಾಸ ಪೂರ್ಣಗೊಳ್ಳುತ್ತದೆ."
        ),
        QuestionModel(
            id = "morarji_ma_u3_q24",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 3,
            type = "MCQ",
            questionText = "BAT : 2120 :: CAT : ?",
            options = listOf("3120", "3119", "3220", "4120"),
            correctAnswer = "3120",
            explanation = "C=3, A=1, T=20 ಆದ್ದರಿಂದ CAT = 3120."
        ),
        QuestionModel(
            id = "morarji_ma_u3_q25",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 3,
            type = "MCQ",
            questionText = "ಅಕ್ಷರ ಶ್ರೇಣಿಯಲ್ಲಿ ಮುಂದಿನ ಅಕ್ಷರ ಯಾವುದು? B, D, F, H, J, ?",
            options = listOf("K", "L", "M", "N"),
            correctAnswer = "L",
            explanation = "ಎರಡೆರಡು ಅಕ್ಷರಗಳ ಮುನ್ನಡೆ (+2): J + 2 = L."
        ),
        QuestionModel(
            id = "morarji_ma_u4_q26",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗುಂಪಿಗೆ ಸೇರದೆ ಇರುವುದು ಇದಾಗಿದೆ :",
            options = listOf("ಕ್ಯಾರೆಟ್", "ಟೊಮ್ಯಾಟೊ", "ಶುಂಠಿ", "ಬೀಟ್ರೂಟ್"),
            correctAnswer = "ಟೊಮ್ಯಾಟೊ",
            explanation = "ಕ್ಯಾರೆಟ್, ಶುಂಠಿ ಮತ್ತು ಬೀಟ್ರೂಟ್ ನೆಲದಡಿಯಲ್ಲಿ ಬೆಳೆಯುವ ಬೇರು/ಕಾಂಡಗಳು; ಆದರೆ ಟೊಮ್ಯಾಟೊ ನೆಲದ ಮೇಲೆ ಗಿಡದಲ್ಲಿ ಬಿಡುವ ಕಾಯಿ/ಹಣ್ಣು."
        ),
        QuestionModel(
            id = "morarji_ma_u4_q27",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗುಂಪಿಗೆ ಸೇರದೆ ಇರುವುದು ಇದಾಗಿದೆ :",
            options = listOf("ಕೋಗಿಲೆ", "ಗಿಳಿ", "ಪಾರಿವಾಳ", "ಬಾವಲಿ"),
            correctAnswer = "ಬಾವಲಿ",
            explanation = "ಕೋಗಿಲೆ, ಗಿಳಿ ಮತ್ತು ಪಾರಿವಾಳ ಪಕ್ಷಿಗಳು (ಅಂಡಜಗಳು); ಆದರೆ ಬಾವಲಿ ಸಸ್ತನಿ (ಕ್ಷೀರಧಾರಿ - ಮರಿ ಹಾಕಿ ಹಾಲುಣಿಸುತ್ತದೆ)."
        ),
        QuestionModel(
            id = "morarji_ma_u4_q28",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗುಂಪಿಗೆ ಸೇರದೆ ಇರುವುದು ಇದಾಗಿದೆ :",
            options = listOf("ಸಾಹಿತಿ", "ಕವಿ", "ಲೇಖಕ", "ನಟ"),
            correctAnswer = "ನಟ",
            explanation = "ಸಾಹಿತಿ, ಕವಿ ಮತ್ತು ಲೇಖಕ ಬರವಣಿಗೆ/ಸಾಹಿತ್ಯ ಕ್ಷೇತ್ರಕ್ಕೆ ಸಂಬಂಧಿಸಿದವರು; ನಟ ಅಭಿನಯ ರಂಗಕ್ಕೆ ಸಂಬಂಧಿಸಿದವರು."
        ),
        QuestionModel(
            id = "morarji_ma_u4_q29",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗುಂಪಿಗೆ ಸೇರದೆ ಇರುವುದು ಇದಾಗಿದೆ :",
            options = listOf("ಕ್ರಿಕೆಟ್", "ಫುಟ್ ಬಾಲ್", "ವಾಲಿಬಾಲ್", "ಕ್ಯಾರಂ"),
            correctAnswer = "ಕ್ಯಾರಂ",
            explanation = "ಕ್ರಿಕೆಟ್, ಫುಟ್ ಬಾಲ್ ಮತ್ತು ವಾಲಿಬಾಲ್ ಹೊರಾಂಗಣ ಆಟಗಳು (Outdoor games); ಕ್ಯಾರಂ ಒಳಾಂಗಣ ಆಟ (Indoor game)."
        ),
        QuestionModel(
            id = "morarji_ma_u4_q30",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗುಂಪಿಗೆ ಸೇರದ ಸಂಖ್ಯೆಯನ್ನು ಗುರುತಿಸಿ :",
            options = listOf("4", "9", "16", "35"),
            correctAnswer = "35",
            explanation = "4, 9, 16 ಪೂರ್ಣ ವರ್ಗ ಸಂಖ್ಯೆಗಳು; 35 ಪೂರ್ಣ ವರ್ಗ ಸಂಖ್ಯೆಯಲ್ಲ."
        ),
        QuestionModel(
            id = "morarji_ma_u4_q31",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗುಂಪಿಗೆ ಸೇರದ ಪದವನ್ನು ಗುರುತಿಸಿ :",
            options = listOf("ಕಣ್ಣು", "ಕಿವಿ", "ಮೂಗು", "ಹೃದಯ"),
            correctAnswer = "ಹೃದಯ",
            explanation = "ಕಣ್ಣು, ಕಿವಿ, ಮೂಗು ಜ್ಞಾನೇಂದ್ರಿಯಗಳು ಮತ್ತು ಬಾಹ್ಯ ಅಂಗಗಳು; ಹೃದಯ ಆಂತರಿಕ ಅಂಗ."
        ),
        QuestionModel(
            id = "morarji_ma_u4_q32",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗುಂಪಿಗೆ ಸೇರದ ನಗರವನ್ನು ಗುರುತಿಸಿ :",
            options = listOf("ಬೆಂಗಳೂರು", "ಮೈಸೂರು", "ಚೆನ್ನೈ", "ಹುಬ್ಬಳ್ಳಿ"),
            correctAnswer = "ಚೆನ್ನೈ",
            explanation = "ಬೆಂಗಳೂರು, ಮೈಸೂರು ಮತ್ತು ಹುಬ್ಬಳ್ಳಿ ಕರ್ನಾಟಕದ ನಗರಗಳು; ಚೆನ್ನೈ ತಮಿಳುನಾಡಿನ ರಾಜಧಾನಿ."
        ),
        QuestionModel(
            id = "morarji_ma_u4_q33",
            stdId = 11,
            subjectId = "mental_ability",
            unitId = 4,
            type = "MCQ",
            questionText = "ಗುಂಪಿಗೆ ಸೇರದ ಜೋಡಿಯನ್ನು ಗುರುತಿಸಿ :",
            options = listOf("ಹಸು : ಕರು", "ಕುದುರೆ : ಮರಿ", "ಸಿಂಹ : ಮರಿ", "ಕೋಳಿ : ಹಾಲು"),
            correctAnswer = "ಕೋಳಿ : ಹಾಲು",
            explanation = "ಉಳಿದವು ಪ್ರಾಣಿ ಮತ್ತು ಅವುಗಳ ಮರಿಗಳ ಸಂಬಂಧ; ಕೋಳಿ ಹಾಲು ಕೊಡುವುದಿಲ್ಲ, ಮೊಟ್ಟೆ ಇಡುತ್ತದೆ."
        )
    )
}
