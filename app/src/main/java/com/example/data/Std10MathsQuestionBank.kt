package com.example.data

/**
 * Standard 10 - Mathematics (ಗಣಿತ - Kannada Medium)
 * Sourced directly from Karnataka DSERT / DIET LBA SSLC Question Bank 2026-27:
 * All 14 Units arranged unit-wise:
 *  1. ಘಟಕ 1: ವಾಸ್ತವ ಸಂಖ್ಯೆಗಳು (Real Numbers)
 *  2. ಘಟಕ 2: ಬಹುಪದೋಕ್ತಿಗಳು (Polynomials)
 *  3. ಘಟಕ 3: ಎರಡು ಚರಾಕ್ಷರವುಳ್ಳ ರೇಖಾತ್ಮಕ ಸಮೀಕರಣಗಳ ಜೋಡಿಗಳು (Pair of Linear Equations in Two Variables)
 *  4. ಘಟಕ 4: ವರ್ಗ ಸಮೀಕರಣಗಳು (Quadratic Equations)
 *  5. ಘಟಕ 5: ಸಮಾಂತರ ಶ್ರೇಢಿಗಳು (Arithmetic Progressions)
 *  6. ಘಟಕ 6: ತ್ರಿಭುಜಗಳು (Triangles)
 *  7. ಘಟಕ 7: ನಿರ್ದೇಶಾಂಕ ರೇಖಾಗಣಿತ (Coordinate Geometry)
 *  8. ಘಟಕ 8: ತ್ರಿಕೋನಮಿತಿಯ ಪ್ರಸ್ತಾವನೆ (Introduction to Trigonometry)
 *  9. ಘಟಕ 9: ತ್ರಿಕೋನಮಿತಿಯ ಕೆಲವು ಅನ್ವಯಗಳು (Some Applications of Trigonometry)
 * 10. ಘಟಕ 10: ವೃತ್ತಗಳು (Circles)
 * 11. ಘಟಕ 11: ವೃತ್ತಗಳಿಗೆ ಸಂಬಂಧಿಸಿದ ವಿಸ್ತೀರ್ಣಗಳು (Areas Related to Circles)
 * 12. ಘಟಕ 12: ಮೇಲ್ಮೈ ವಿಸ್ತೀರ್ಣಗಳು ಹಾಗೂ ಘನಫಲಗಳು (Surface Areas and Volumes)
 * 13. ಘಟಕ 13: ಸಂಖ್ಯಾಶಾಸ್ತ್ರ (Statistics)
 * 14. ಘಟಕ 14: ಸಂಭವನೀಯತೆ (Probability)
 *
 * Contains authentic direct MCQs, fill-in-the-blanks converted into 4-option MCQs,
 * and 1-mark questions converted into 4-option MCQs with explanations and clean mathematical formulas.
 * All duplicates and picture-based questions have been omitted.
 */
object Std10MathsQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "ಘಟಕ 1: ವಾಸ್ತವ ಸಂಖ್ಯೆಗಳು", 16, "Easy"),
        UnitTemplate(2, "ಘಟಕ 2: ಬಹುಪದೋಕ್ತಿಗಳು", 15, "Medium"),
        UnitTemplate(3, "ಘಟಕ 3: ಎರಡು ಚರಾಕ್ಷರವುಳ್ಳ ರೇಖಾತ್ಮಕ ಸಮೀಕರಣಗಳ ಜೋಡಿಗಳು", 14, "Medium"),
        UnitTemplate(4, "ಘಟಕ 4: ವರ್ಗ ಸಮೀಕರಣಗಳು", 15, "Medium"),
        UnitTemplate(5, "ಘಟಕ 5: ಸಮಾಂತರ ಶ್ರೇಢಿಗಳು", 15, "Medium"),
        UnitTemplate(6, "ಘಟಕ 6: ತ್ರಿಭುಜಗಳು", 14, "Hard"),
        UnitTemplate(7, "ಘಟಕ 7: ನಿರ್ದೇಶಾಂಕ ರೇಖಾಗಣಿತ", 14, "Medium"),
        UnitTemplate(8, "ಘಟಕ 8: ತ್ರಿಕೋನಮಿತಿಯ ಪ್ರಸ್ತಾವನೆ", 20, "Hard"),
        UnitTemplate(9, "ಘಟಕ 9: ತ್ರಿಕೋನಮಿತಿಯ ಕೆಲವು ಅನ್ವಯಗಳು", 12, "Medium"),
        UnitTemplate(10, "ಘಟಕ 10: ವೃತ್ತಗಳು", 13, "Medium"),
        UnitTemplate(11, "ಘಟಕ 11: ವೃತ್ತಗಳಿಗೆ ಸಂಬಂಧಿಸಿದ ವಿಸ್ತೀರ್ಣಗಳು", 13, "Hard"),
        UnitTemplate(12, "ಘಟಕ 12: ಮೇಲ್ಮೈ ವಿಸ್ತೀರ್ಣಗಳು ಹಾಗೂ ಘನಫಲಗಳು", 18, "Hard"),
        UnitTemplate(13, "ಘಟಕ 13: ಸಂಖ್ಯಾಶಾಸ್ತ್ರ", 12, "Easy"),
        UnitTemplate(14, "ಘಟಕ 14: ಸಂಭವನೀಯತೆ", 16, "Easy")
    )

    val questions: List<QuestionModel> =
        Std10MathsQuestionBankPart1.questions + Std10MathsQuestionBankPart2.questions
}
