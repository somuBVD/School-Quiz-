import re

script = """
import re

questions_data = [
    # 9 STD ENGLISH (unit 2)
    {
        "prefix": "fln_9_eng",
        "std": 9,
        "unit": 2,
        "header": "9 STD ENGLISH (20 MCQs)",
        "items": [
            ("What is the plural form of “Child”?", ["Childs", "Children", "Childes", "Childrens"], "Children", "The irregular plural form of 'child' is 'children'."),
            ("Choose the opposite of “Ancient”.", ["Old", "Historic", "Modern", "Traditional"], "Modern", "The antonym of 'ancient' (belonging to very distant past) is 'modern'."),
            ("Choose the synonym of “Brave”.", ["Cowardly", "Courageous", "Weak", "Lazy"], "Courageous", "'Courageous' has the same meaning as 'brave'."),
            ("Fill in the blank: She _____ to school every day.", ["go", "going", "goes", "gone"], "goes", "Third-person singular 'she' takes 'goes' in simple present."),
            ("Choose the correct article: He is _____ honest man.", ["a", "an", "the", "no article"], "an", "'Honest' starts with a vowel sound (/ɒ/), requiring article 'an'."),
            ("What is the past tense of “Write”?", ["Writed", "Written", "Wrote", "Writing"], "Wrote", "Simple past tense of 'write' is 'wrote'."),
            ("Identify the noun in the sentence: “The bird sings sweetly.”", ["The", "Bird", "Sings", "Sweetly"], "Bird", "'Bird' is the naming noun in this sentence."),
            ("Choose the correct pronoun: Ravi is my friend. _____ is kind.", ["She", "It", "He", "They"], "He", "'He' is the appropriate subject pronoun for Ravi."),
            ("Fill in the blank: They _____ playing cricket now.", ["is", "am", "are", "was"], "are", "Plural subject 'They' takes 'are' in present continuous tense."),
            ("Choose the correct spelling.", ["Beautifull", "Beutiful", "Beautiful", "Beautifal"], "Beautiful", "The correct spelling is B-e-a-u-t-i-f-u-l."),
            ("Identify the adjective: “It is a beautiful flower.”", ["It", "Is", "Beautiful", "Flower"], "Beautiful", "'Beautiful' describes the noun 'flower'."),
            ("Choose the opposite of “Victory”.", ["Success", "Defeat", "Achievement", "Progress"], "Defeat", "The opposite of victory (win) is defeat (loss)."),
            ("Fill in the blank: I have lived here _____ 2020.", ["for", "since", "from", "by"], "since", "'Since' is used for a specific starting point in time (2020)."),
            ("Choose the correct question tag: You are a student, _____?", ["are you", "do you", "aren't you", "isn't it"], "aren't you", "Positive statement with 'are' takes negative question tag 'aren't you'."),
            ("Identify the verb: “The children played football.”", ["Children", "Played", "Football", "The"], "Played", "'Played' is the action verb in the past tense."),
            ("Choose the correct comparative form of “Good”.", ["Gooder", "More good", "Best", "Better"], "Better", "Comparative degree of 'good' is 'better' (superlative is 'best')."),
            ("Fill in the blank: If it rains, we _____ stay at home.", ["will", "would have", "had", "were"], "will", "First conditional: If + present, will + base verb."),
            ("Choose the correct passive voice: “Ravi wrote a letter.”", ["A letter is written by Ravi.", "A letter was written by Ravi.", "Ravi was written a letter.", "A letter has write by Ravi."], "A letter was written by Ravi.", "Past simple 'wrote' becomes passive 'was written by'."),
            ("What is the plural form of “Mouse”?", ["Mouses", "Mices", "Mice", "Mousees"], "Mice", "The irregular plural of 'mouse' is 'mice'."),
            ("Choose the correct indirect speech: He said, “I am happy.”", ["He said that I am happy.", "He said that he was happy.", "He says that he happy.", "He said he is happily."], "He said that he was happy.", "Direct speech 'am' becomes 'was' in indirect speech.")
        ]
    },
    # 9 STD MATHEMATICS (unit 3)
    {
        "prefix": "fln_9_mat",
        "std": 9,
        "unit": 3,
        "header": "9 STD MATHEMATICS (20 MCQs)",
        "items": [
            ("(-8) + 15 ರ ಮೌಲ್ಯ ಎಷ್ಟು?", ["7", "−7", "23", "−23"], "7", "15 - 8 = 7."),
            ("3/5 + 1/5 ರ ಮೌಲ್ಯ ಎಷ್ಟು?", ["4/10", "4/5", "2/5", "3/10"], "4/5", "ಛೇದಗಳು ಸಮನಾಗಿದ್ದಾಗ ಅಂಶಗಳನ್ನು ಕೂಡಿಸಿದರೆ: 3/5 + 1/5 = 4/5."),
            ("2⁵ ರ ಮೌಲ್ಯ ಎಷ್ಟು?", ["10", "16", "32", "25"], "32", "2 × 2 × 2 × 2 × 2 = 32."),
            ("√144 ರ ಮೌಲ್ಯ ಎಷ್ಟು?", ["10", "11", "12", "14"], "12", "12 × 12 = 144, ಆದ್ದರಿಂದ √144 = 12."),
            ("3x + 5 = 20 ಆದರೆ x ನ ಮೌಲ್ಯ ಎಷ್ಟು?", ["3", "5", "7", "10"], "5", "3x = 20 - 5 = 15 => x = 15 / 3 = 5."),
            ("5a + 3a - 2a ಸರಳ ರೂಪ ಯಾವುದು?", ["10a", "6a", "8a", "5a"], "6a", "5a + 3a = 8a; 8a - 2a = 6a."),
            ("x² - 9 ರ ಅಪವರ್ತನ ರೂಪ ಯಾವುದು?", ["(x - 3)(x + 3)", "(x - 9)(x + 1)", "(x - 3)²", "(x + 9)(x - 1)"], "(x - 3)(x + 3)", "a² - b² = (a - b)(a + b); x² - 3² = (x - 3)(x + 3)."),
            ("x = 2 ಆದರೆ x² + 3x + 1 ರ ಮೌಲ್ಯ ಎಷ್ಟು?", ["7", "9", "11", "13"], "11", "x=2 ಆದಾಗ 2² + 3(2) + 1 = 4 + 6 + 1 = 11."),
            ("ತ್ರಿಭುಜದ ಮೂರು ಒಳಕೋನಗಳ ಮೊತ್ತ ಎಷ್ಟು?", ["90°", "180°", "270°", "360°"], "180°", "ಯಾವುದೇ ತ್ರಿಭುಜದ ಒಳಕೋನಗಳ ಮೊತ್ತ ಯಾವಾಗಲೂ 180° ಆಗಿರುತ್ತದೆ."),
            ("ಒಂದು ತ್ರಿಭುಜದ ಎರಡು ಕೋನಗಳು 50° ಮತ್ತು 60° ಆಗಿದ್ದರೆ, ಮೂರನೇ ಕೋನ ಎಷ್ಟು?", ["60°", "70°", "80°", "90°"], "70°", "180° - (50° + 60°) = 180° - 110° = 70°."),
            ("ಚೌಕದ ಒಂದು ಬದಿಯ ಉದ್ದ 8 ಸೆಂ.ಮೀ. ಆಗಿದ್ದರೆ, ಅದರ ವಿಸ್ತೀರ್ಣ ಎಷ್ಟು?", ["16 ಚ.ಸೆಂ.ಮೀ.", "32 ಚ.ಸೆಂ.ಮೀ.", "64 ಚ.ಸೆಂ.ಮೀ.", "80 ಚ.ಸೆಂ.ಮೀ."], "64 ಚ.ಸೆಂ.ಮೀ.", "ಚೌಕದ ವಿಸ್ತೀರ್ಣ = ಬಾಹು × ಬಾಹು = 8 × 8 = 64 ಚ.ಸೆಂ.ಮೀ."),
            ("ಉದ್ದ 12 ಸೆಂ.ಮೀ. ಮತ್ತು ಅಗಲ 5 ಸೆಂ.ಮೀ. ಇರುವ ಆಯತದ ಪರಿಮಿತಿ ಎಷ್ಟು?", ["17 ಸೆಂ.ಮೀ.", "34 ಸೆಂ.ಮೀ.", "60 ಸೆಂ.ಮೀ.", "30 ಸೆಂ.ಮೀ."], "34 ಸೆಂ.ಮೀ.", "ಆಯತದ ಪರಿಮಿತಿ = 2(ಉದ್ದ + ಅಗಲ) = 2(12 + 5) = 2(17) = 34 ಸೆಂ.ಮೀ."),
            ("ತ್ರಿಜ್ಯ 7 ಸೆಂ.ಮೀ. ಇರುವ ವೃತ್ತದ ಸುತ್ತಳತೆ ಎಷ್ಟು? (π = 22/7)", ["22 ಸೆಂ.ಮೀ.", "44 ಸೆಂ.ಮೀ.", "49 ಸೆಂ.ಮೀ.", "154 ಸೆಂ.ಮೀ."], "44 ಸೆಂ.ಮೀ.", "ವೃತ್ತದ ಸುತ್ತಳತೆ = 2πr = 2 × (22/7) × 7 = 44 ಸೆಂ.ಮೀ."),
            ("200 ರಲ್ಲಿ 25% ಎಷ್ಟು?", ["25", "40", "50", "75"], "50", "200 × (25/100) = 50."),
            ("₹800 ಮೌಲ್ಯದ ವಸ್ತುವಿಗೆ 10% ರಿಯಾಯಿತಿ ನೀಡಿದರೆ, ರಿಯಾಯಿತಿ ಮೊತ್ತ ಎಷ್ಟು?", ["₹40", "₹60", "₹80", "₹100"], "₹80", "800 ರ 10% = 800 × 0.10 = ₹80."),
            ("4, 6, 8, 10, 12 ಇವುಗಳ ಸರಾಸರಿ ಎಷ್ಟು?", ["6", "8", "10", "12"], "8", "(4 + 6 + 8 + 10 + 12) / 5 = 40 / 5 = 8."),
            ("ಒಂದು ನಾಣ್ಯವನ್ನು ಒಮ್ಮೆ ಎಸೆದಾಗ ತಲೆ ಬೀಳುವ ಸಂಭವನೀಯತೆ ಎಷ್ಟು?", ["1/4", "1/3", "1/2", "1"], "1/2", "ಸಾಧ್ಯ ಫಲಿತಾಂಶಗಳು: {ತಲೆ, ಬಾಲ} = 2. ತಲೆ ಬೀಳುವ ಸಂಭವನೀಯತೆ = 1/2."),
            ("x + y = 10 ಮತ್ತು x = 4 ಆದರೆ y ನ ಮೌಲ್ಯ ಎಷ್ಟು?", ["4", "5", "6", "10"], "6", "4 + y = 10 => y = 10 - 4 = 6."),
            ("ಘನದ ಒಂದು ಅಂಚು 3 ಸೆಂ.ಮೀ. ಆಗಿದ್ದರೆ, ಅದರ ಘನಫಲ ಎಷ್ಟು?", ["9 ಘ.ಸೆಂ.ಮೀ.", "18 ಘ.ಸೆಂ.ಮೀ.", "27 ಘ.ಸೆಂ.ಮೀ.", "36 ಘ.ಸೆಂ.ಮೀ."], "27 ಘ.ಸೆಂ.ಮೀ.", "ಘನಫಲ = a³ = 3 × 3 × 3 = 27 ಘ.ಸೆಂ.ಮೀ."),
            ("12 ಮತ್ತು 18 ರ ಮಹತ್ತಮ ಸಾಮಾನ್ಯ ಅಪವರ್ತಕ (ಮ.ಸಾ.ಅ.) ಯಾವುದು?", ["2", "3", "6", "9"], "6", "12 ಮತ್ತು 18 ನ್ನು ಭಾಗಿಸುವ ಗರಿಷ್ಠ ಸಂಖ್ಯೆ 6 (HCF = 6).")
        ]
    },
    # 10 STD KANNADA (unit 1)
    {
        "prefix": "fln_10_kan",
        "std": 10,
        "unit": 1,
        "header": "10 STD KANNADA (20 MCQs)",
        "items": [
            ("ಕನ್ನಡ ವರ್ಣಮಾಲೆಯಲ್ಲಿ ಸ್ವತಂತ್ರವಾಗಿ ಉಚ್ಚರಿಸಬಹುದಾದ ವರ್ಣಗಳನ್ನು ಏನೆಂದು ಕರೆಯುತ್ತಾರೆ?", ["ವ್ಯಂಜನಗಳು", "ಸ್ವರಗಳು", "ಒತ್ತಕ್ಷರಗಳು", "ಸಂಯುಕ್ತಾಕ್ಷರಗಳು"], "ಸ್ವರಗಳು", "ಸ್ವಯಂ ರಾಜಂತೇ ಇತಿ ಸ್ವರಾಃ - ಸ್ವತಂತ್ರವಾಗಿ ಉಚ್ಚರಿಸಲಾಗುವ ವರ್ಣಗಳೇ ಸ್ವರಗಳು."),
            ("‘ಕೈಕೆಲಸ’ ಪದವು ಯಾವ ರೀತಿಯ ಪದಕ್ಕೆ ಉದಾಹರಣೆ?", ["ಜೋಡುಪದ", "ಕ್ರಿಯಾಪದ", "ಸರ್ವನಾಮ", "ಅವ್ಯಯ"], "ಜೋಡುಪದ", "ಕೈ ಮತ್ತು ಕೆಲಸ ಒಟ್ಟಿಗೆ ಸೇರಿ ಆದ ಜೋಡುಪದ/ಸಮಸ್ತ ಪದ."),
            ("‘ಸತ್ಯ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?", ["ನ್ಯಾಯ", "ಧರ್ಮ", "ಅಸತ್ಯ", "ನೀತಿ"], "ಅಸತ್ಯ", "ಸತ್ಯ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಅಸತ್ಯ ಅಥವಾ ಸುಳ್ಳು."),
            ("‘ಸೂರ್ಯ’ ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?", ["ಶಶಿ", "ರವಿ", "ನಿಶೆ", "ತಾರೆ"], "ರವಿ", "ಸೂರ್ಯ, ರವಿ, ಭಾನು, ದಿನಕರ ಇವು ಸಮಾನಾರ್ಥಕಗಳು."),
            ("‘ಅವಳು ಹಾಡನ್ನು ಹಾಡಿದಳು’ ಎಂಬ ವಾಕ್ಯದಲ್ಲಿ ಕ್ರಿಯಾಪದ ಯಾವುದು?", ["ಅವಳು", "ಹಾಡನ್ನು", "ಹಾಡಿದಳು", "ಎಂಬ"], "ಹಾಡಿದಳು", "ಕೆಲಸ ಅಥವಾ ಕ್ರಿಯೆಯನ್ನು ಸೂಚಿಸುವ ಪದ 'ಹಾಡಿದಳು'."),
            ("‘ಮಕ್ಕಳು ಶಾಲೆಗೆ ಹೋದರು’ ಎಂಬ ವಾಕ್ಯ ಯಾವ ಕಾಲವನ್ನು ಸೂಚಿಸುತ್ತದೆ?", ["ವರ್ತಮಾನಕಾಲ", "ಭೂತಕಾಲ", "ಭವಿಷ್ಯತ್ಕಾಲ", "ಯಾವುದೂ ಅಲ್ಲ"], "ಭೂತಕಾಲ", "ಕ್ರಿಯೆ ನಡೆದು ಮುಗಿದಿರುವುದರಿಂದ ಇದು ಭೂತಕಾಲ."),
            ("‘ಒಳ್ಳೆಯ’ ಪದವು ಯಾವ ಪದಭೇದಕ್ಕೆ ಸೇರಿದೆ?", ["ನಾಮಪದ", "ಸರ್ವನಾಮ", "ವಿಶೇಷಣ", "ಕ್ರಿಯಾಪದ"], "ವಿಶೇಷಣ", "ನಾಮಪದದ ಗುಣ ಲಕ್ಷಣಗಳನ್ನು ತಿಳಿಸುವ ಪದ ವಿಶೇಷಣ."),
            ("‘ನಾವು’ ಯಾವ ಪದಭೇದಕ್ಕೆ ಸೇರಿದೆ?", ["ನಾಮಪದ", "ಸರ್ವನಾಮ", "ಕ್ರಿಯಾಪದ", "ವಿಶೇಷಣ"], "ಸರ್ವನಾಮ", "ನಾಮಪದದ ಬದಲಾಗಿ ಬಳಸುವ ಪದ ಸರ್ವನಾಮ (ಪ್ರಥಮ ಪುರುಷ ಬಹುವಚನ)."),
            ("‘ಕತ್ತಲೆ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?", ["ರಾತ್ರಿ", "ನೆರಳು", "ಬೆಳಕು", "ಮೋಡ"], "ಬೆಳಕು", "ಕತ್ತಲೆಯ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಬೆಳಕು."),
            ("‘ಮರಗಳು’ ಪದದ ಏಕವಚನ ರೂಪ ಯಾವುದು?", ["ಮರಕ್ಕೆ", "ಮರದಿಂದ", "ಮರ", "ಮರದ"], "ಮರ", "'ಮರ' ಎಂಬುದು ಏಕವಚನ, 'ಮರಗಳು' ಬಹುವಚನ."),
            ("‘ಹಕ್ಕಿ ಆಕಾಶದಲ್ಲಿ ಹಾರುತ್ತದೆ’ ಎಂಬ ವಾಕ್ಯದಲ್ಲಿ ಕರ್ತೃ ಯಾವುದು?", ["ಆಕಾಶದಲ್ಲಿ", "ಹಾರುತ್ತದೆ", "ಹಕ್ಕಿ", "ಎಂಬ"], "ಹಕ್ಕಿ", "ಕ್ರಿಯೆಯನ್ನು ಮಾಡುವ ಮುಖ್ಯ ನಾಮಪದ 'ಹಕ್ಕಿ' ಕರ್ತೃ ಪದ."),
            ("‘ವೇಗವಾಗಿ’ ಪದವು ಯಾವ ಪದಭೇದಕ್ಕೆ ಸೇರಿದೆ?", ["ನಾಮಪದ", "ಕ್ರಿಯಾವಿಶೇಷಣ", "ಸರ್ವನಾಮ", "ವಿಭಕ್ತಿ ಪ್ರತ್ಯಯ"], "ಕ್ರಿಯಾವಿಶೇಷಣ", "ಕ್ರಿಯಾಪದದ ರೀತಿ ಅಥವಾ ವೇಗವನ್ನು ವಿವರಿಸುವ ಪದ ಕ್ರಿಯಾವಿಶೇಷಣ."),
            ("‘ವಿದ್ಯೆ’ ಪದದ ಸಮಾನಾರ್ಥಕ ಪದ ಯಾವುದು?", ["ಜ್ಞಾನ", "ಅಜ್ಞಾನ", "ಕೋಪ", "ಭಯ"], "ಜ್ಞಾನ", "ವಿದ್ಯೆ ಎಂದರೆ ಜ್ಞಾನ, ಅರಿವು."),
            ("‘ಧೈರ್ಯ’ ಪದದ ವಿರುದ್ಧಾರ್ಥಕ ಪದ ಯಾವುದು?", ["ಸಾಹಸ", "ಶೌರ್ಯ", "ಭಯ", "ಶಕ್ತಿ"], "ಭಯ", "ಧೈರ್ಯದ ವಿರುದ್ಧಾರ್ಥಕ ಭಯ ಅಥವಾ ಹೇಡಿತನ."),
            ("‘ಅವನು ನಾಳೆ ಪರೀಕ್ಷೆ ಬರೆಯುವನು’ ಎಂಬ ವಾಕ್ಯ ಯಾವ ಕಾಲವನ್ನು ಸೂಚಿಸುತ್ತದೆ?", ["ಭೂತಕಾಲ", "ವರ್ತಮಾನಕಾಲ", "ಭವಿಷ್ಯತ್ಕಾಲ", "ಅಪೂರ್ಣ ಭೂತಕಾಲ"], "ಭವಿಷ್ಯತ್ಕಾಲ", "ಮುಂದೆ ನಡೆಯಲಿರುವ ಕೆಲಸವನ್ನು ತಿಳಿಸುವುದು ಭವಿಷ್ಯತ್ಕಾಲ."),
            ("‘ಮನೆಮನೆಗೆ’ ಎಂಬ ಪದವು ಯಾವ ಅರ್ಥವನ್ನು ಸೂಚಿಸುತ್ತದೆ?", ["ಒಂದೇ ಮನೆ", "ಪ್ರತಿಯೊಂದು ಮನೆಗೆ", "ಮನೆಯ ಒಳಗೆ ಮಾತ್ರ", "ಮನೆಯ ಹಿಂದೆ ಮಾತ್ರ"], "ಪ್ರತಿಯೊಂದು ಮನೆಗೆ", "ದ್ವಿರುಕ್ತಿ ರೂಪ 'ಮನೆಮನೆಗೆ' ಎಂದರೆ ಪ್ರತಿಯೊಂದು ಮನೆಗೂ ಎಂದರ್ಥ."),
            ("ಗದ್ಯ ಮತ್ತು ಪದ್ಯಗಳ ನಡುವಿನ ಮುಖ್ಯ ವ್ಯತ್ಯಾಸ ಯಾವುದು?", ["ಗದ್ಯವು ಸಾಮಾನ್ಯ ವಾಕ್ಯರಚನೆಯಲ್ಲಿರುತ್ತದೆ; ಪದ್ಯವು ಛಂದಸ್ಸು ಅಥವಾ ಕಾವ್ಯಾತ್ಮಕ ರಚನೆ ಹೊಂದಿರಬಹುದು", "ಗದ್ಯದಲ್ಲಿ ಅರ್ಥವಿರುವುದಿಲ್ಲ", "ಪದ್ಯದಲ್ಲಿ ಪದಗಳಿರುವುದಿಲ್ಲ", "ಎರಡೂ ಯಾವಾಗಲೂ ಒಂದೇ ರೂಪದಲ್ಲಿರುತ್ತವೆ"], "ಗದ್ಯವು ಸಾಮಾನ್ಯ ವಾಕ್ಯರಚನೆಯಲ್ಲಿರುತ್ತದೆ; ಪದ್ಯವು ಛಂದಸ್ಸು ಅಥವಾ ಕಾವ್ಯಾತ್ಮಕ ರಚನೆ ಹೊಂದಿರಬಹುದು", "ಗದ್ಯವು ಸಾಮಾನ್ಯ ವಾಕ್ಯ ರೂಪದಲ್ಲಿದ್ದು, ಪದ್ಯವು ಲಯ, ಛಂದಸ್ಸು ಹಾಗೂ ಪ್ರಾಸವನ್ನು ಹೊಂದಿರುತ್ತದೆ."),
            ("ಒಂದು ವಾಕ್ಯದಲ್ಲಿ ಪ್ರಶ್ನೆಯನ್ನು ಸೂಚಿಸಲು ಸಾಮಾನ್ಯವಾಗಿ ಯಾವ ವಿರಾಮಚಿಹ್ನೆ ಬಳಸಲಾಗುತ್ತದೆ?", ["ಪೂರ್ಣವಿರಾಮ (.)", "ಅಲ್ಪವಿರಾಮ (,)", "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ (?)", "ಉದ್ಗಾರ ಚಿಹ್ನೆ (!)"], "ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ (?)", "ಪ್ರಶ್ನೆ ವಾಕ್ಯಗಳ ಕೊನೆಯಲ್ಲಿ ಪ್ರಶ್ನಾರ್ಥಕ ಚಿಹ್ನೆ (?) ಬಳಸಲಾಗುತ್ತದೆ."),
            ("‘ದೇಶಪ್ರೇಮ’ ಎಂದರೆ ಏನು?", ["ದೇಶದ ಬಗ್ಗೆ ಪ್ರೀತಿ ಮತ್ತು ಗೌರವ", "ಇತರರನ್ನು ಅವಮಾನಿಸುವುದು", "ಪ್ರಕೃತಿಯನ್ನು ನಾಶಮಾಡುವುದು", "ಸಾರ್ವಜನಿಕ ಆಸ್ತಿಯನ್ನು ಹಾಳುಮಾಡುವುದು"], "ದೇಶದ ಬಗ್ಗೆ ಪ್ರೀತಿ ಮತ್ತು ಗೌರವ", "ಸ್ವದೇಶದ ಬಗ್ಗೆ ಇರುವ ನಿಷ್ಠೆ, ಭಕ್ತಿ ಮತ್ತು ಗೌರವವೇ ದೇಶಪ್ರೇಮ."),
            ("ಪರಿಣಾಮಕಾರಿ ಸಂವಹನಕ್ಕೆ ಅತ್ಯಂತ ಅಗತ್ಯವಾದದ್ದು ಯಾವುದು?", ["ಸ್ಪಷ್ಟವಾದ ಅಭಿವ್ಯಕ್ತಿ ಮತ್ತು ಗಮನವಿಟ್ಟು ಕೇಳುವುದು", "ಇತರರ ಮಾತನ್ನು ಮಧ್ಯದಲ್ಲೇ ನಿಲ್ಲಿಸುವುದು", "ಅಸ್ಪಷ್ಟವಾಗಿ ಮಾತನಾಡುವುದು", "ತಪ್ಪು ಮಾಹಿತಿಯನ್ನು ಹರಡುವುದು"], "ಸ್ಪಷ್ಟವಾದ ಅಭಿವ್ಯಕ್ತಿ ಮತ್ತು ಗಮನವಿಟ್ಟು ಕೇಳುವುದು", "ಉತ್ತಮ ಸಂವಹನಕ್ಕೆ ಸ್ಪಷ್ಟ ಮಾತು ಮತ್ತು ಆಲಿಸುವಿಕೆ ಅತ್ಯಗತ್ಯ.")
        ]
    },
    # 10 STD ENGLISH (unit 2)
    {
        "prefix": "fln_10_eng",
        "std": 10,
        "unit": 2,
        "header": "10 STD ENGLISH (20 MCQs)",
        "items": [
            ("Choose the synonym of “Abundant”.", ["Scarce", "Plentiful", "Empty", "Little"], "Plentiful", "'Abundant' means existing or available in large quantities; plentiful."),
            ("Choose the antonym of “Expand”.", ["Increase", "Extend", "Contract", "Enlarge"], "Contract", "To expand means to grow larger; contract means to decrease or shrink."),
            ("Fill in the blank: Neither Ravi nor his friends _____ present yesterday.", ["was", "were", "is", "has"], "were", "With 'neither... nor', the verb agrees with the closer plural subject 'his friends'."),
            ("Choose the correct passive voice: “The teacher praised the student.”", ["The student praises the teacher.", "The student was praised by the teacher.", "The teacher was praised by the student.", "The student is praising the teacher."], "The student was praised by the teacher.", "Simple past 'praised' turns into 'was praised by'."),
            ("Choose the correct indirect speech: She said, “I am tired.”", ["She said that I am tired.", "She said that she was tired.", "She says that she tired.", "She told that I was tired."], "She said that she was tired.", "Tense changes from present ('am') to past ('was') in reported speech."),
            ("Identify the adjective in the sentence: “The diligent student completed the work.”", ["Student", "Completed", "Diligent", "Work"], "Diligent", "'Diligent' (hardworking) is the adjective modifying 'student'."),
            ("Choose the correct question tag: They have finished the work, _____?", ["haven't they", "don't they", "didn't they", "aren't they"], "haven't they", "Positive statement with 'have finished' takes negative tag 'haven't they'."),
            ("Fill in the blank: If I had studied harder, I _____ the examination.", ["will pass", "would pass", "would have passed", "am passing"], "would have passed", "Third conditional: If + past perfect, would have + past participle."),
            ("Choose the correct spelling.", ["Accomodation", "Accommodation", "Acommodation", "Accommadation"], "Accommodation", "The correct spelling is A-C-C-O-M-M-O-D-A-T-I-O-N (double c, double m)."),
            ("Choose the correct comparative form of “Little” when referring to quantity.", ["Littler", "Least", "Less", "More little"], "Less", "Degrees of quantity: Little, Less, Least."),
            ("Identify the figure of speech: “The wind whispered through the trees.”", ["Simile", "Personification", "Hyperbole", "Oxymoron"], "Personification", "Giving human action ('whispered') to non-human element ('wind')."),
            ("Choose the correct preposition: He is good _____ mathematics.", ["in", "on", "at", "for"], "at", "The standard idiom for competence is 'good at' an activity or subject."),
            ("What is the plural form of “Phenomenon”?", ["Phenomenons", "Phenomena", "Phenomenas", "Phenomeni"], "Phenomena", "'Phenomenon' is a Greek-derived noun whose plural is 'phenomena'."),
            ("Choose the correct sentence.", ["She do not like coffee.", "She does not likes coffee.", "She does not like coffee.", "She not like coffee."], "She does not like coffee.", "'Does not' takes the bare infinitive 'like'."),
            ("Choose the synonym of “Compassion”.", ["Cruelty", "Sympathy", "Anger", "Hatred"], "Sympathy", "'Compassion' means sympathetic pity and concern for the sufferings of others."),
            ("Fill in the blank: By the time we arrived, the train _____.", ["leaves", "has left", "had left", "will leave"], "had left", "Past perfect 'had left' describes an action completed before another past event."),
            ("Choose the antonym of “Optimistic”.", ["Hopeful", "Positive", "Pessimistic", "Confident"], "Pessimistic", "Optimistic (hopeful) is the opposite of pessimistic (expecting worst)."),
            ("Identify the noun clause: “I know that he is honest.”", ["I know", "That he is honest", "He is", "Is honest"], "That he is honest", "'That he is honest' acts as the object of the verb 'know'."),
            ("Choose the correct passive voice: “People speak English all over the world.”", ["English spoke all over the world.", "English is spoken all over the world.", "English was speaking all over the world.", "People are spoken English."], "English is spoken all over the world.", "Present tense 'speak' becomes 'is spoken by'."),
            ("Choose the correct meaning of the idiom “Once in a blue moon”.", ["Every day", "Very frequently", "Very rarely", "At midnight"], "Very rarely", "The idiom 'once in a blue moon' means something that happens very rarely.")
        ]
    },
    # 10 STD MATHEMATICS (unit 3)
    {
        "prefix": "fln_10_mat",
        "std": 10,
        "unit": 3,
        "header": "10 STD MATHEMATICS (20 MCQs)",
        "items": [
            ("x² - 5x + 6 = 0 ಈ ವರ್ಗ ಸಮೀಕರಣದ ಮೂಲಗಳು ಯಾವುವು?", ["1, 6", "2, 3", "−2, −3", "3, 4"], "2, 3", "(x - 2)(x - 3) = 0 => x = 2 ಅಥವಾ x = 3."),
            ("2x + 3 = 11 ಆದರೆ x ನ ಮೌಲ್ಯ ಎಷ್ಟು?", ["2", "3", "4", "5"], "4", "2x = 11 - 3 = 8 => x = 8 / 2 = 4."),
            ("x² - 9 ರ ಅಪವರ್ತನ ರೂಪ ಯಾವುದು?", ["(x - 3)(x + 3)", "(x - 9)(x + 1)", "(x - 3)²", "(x + 9)(x - 1)"], "(x - 3)(x + 3)", "a² - b² = (a - b)(a + b) => x² - 3² = (x - 3)(x + 3)."),
            ("ಸಮಾಂತರ ಶ್ರೇಣಿ 2, 5, 8, 11, ... ಇದರ ಸಾಮಾನ್ಯ ವ್ಯತ್ಯಾಸ ಎಷ್ಟು?", ["2", "3", "5", "8"], "3", "ಸಾಮಾನ್ಯ ವ್ಯತ್ಯಾಸ d = a₂ - a₁ = 5 - 2 = 3."),
            ("ಸಮಾಂತರ ಶ್ರೇಣಿ 3, 7, 11, 15, ... ಇದರ 10ನೇ ಪದ ಎಷ್ಟು?", ["35", "39", "40", "43"], "39", "a_n = a + (n - 1)d => a₁₀ = 3 + 9(4) = 3 + 36 = 39."),
            ("x² + 4x + 4 ರ ಅಪವರ್ತನ ರೂಪ ಯಾವುದು?", ["(x + 2)²", "(x - 2)²", "(x + 4)²", "(x - 4)²"], "(x + 2)²", "(x + 2)² = x² + 2(2)x + 2² = x² + 4x + 4."),
            ("ಒಂದು ತ್ರಿಭುಜದ ಎರಡು ಕೋನಗಳು 50° ಮತ್ತು 60° ಆಗಿದ್ದರೆ, ಮೂರನೇ ಕೋನ ಎಷ್ಟು?", ["60°", "70°", "80°", "90°"], "70°", "180° - (50° + 60°) = 180° - 110° = 70°."),
            ("sin 30° ರ ಮೌಲ್ಯ ಎಷ್ಟು?", ["0", "1/2", "√3/2", "1"], "1/2", "ತ್ರಿಕೋನಮಿತಿಯ ಮೂಲ ಕೋನ ಮೌಲ್ಯ: sin 30° = 1/2."),
            ("cos 60° ರ ಮೌಲ್ಯ ಎಷ್ಟು?", ["0", "1/2", "√3/2", "1"], "1/2", "cos 60° = sin 30° = 1/2."),
            ("tan 45° ರ ಮೌಲ್ಯ ಎಷ್ಟು?", ["0", "1/2", "1", "√3"], "1", "tan 45° = sin 45° / cos 45° = 1."),
            ("ಬಿಂದುಗಳು (0,0) ಮತ್ತು (3,4) ಗಳ ನಡುವಿನ ದೂರ ಎಷ್ಟು?", ["3", "4", "5", "7"], "5", "ದೂರ = √(3² + 4²) = √(9 + 16) = √25 = 5."),
            ("ಬಿಂದುಗಳು (2,4) ಮತ್ತು (6,8) ಗಳ ಮಧ್ಯಬಿಂದು ಯಾವುದು?", ["(4,6)", "(8,12)", "(2,6)", "(3,4)"], "(4,6)", "ಮಧ್ಯಬಿಂದು = ((2+6)/2, (4+8)/2) = (8/2, 12/2) = (4,6)."),
            ("ತ್ರಿಜ್ಯ 7 ಸೆಂ.ಮೀ. ಇರುವ ವೃತ್ತದ ವಿಸ್ತೀರ್ಣ ಎಷ್ಟು? (π = 22/7)", ["44 ಚ.ಸೆಂ.ಮೀ.", "77 ಚ.ಸೆಂ.ಮೀ.", "154 ಚ.ಸೆಂ.ಮೀ.", "308 ಚ.ಸೆಂ.ಮೀ."], "154 ಚ.ಸೆಂ.ಮೀ.", "ವಿಸ್ತೀರ್ಣ = πr² = (22/7) × 7 × 7 = 154 ಚ.ಸೆಂ.ಮೀ."),
            ("ತ್ರಿಜ್ಯ 7 ಸೆಂ.ಮೀ. ಇರುವ ವೃತ್ತದ ಸುತ್ತಳತೆ ಎಷ್ಟು? (π = 22/7)", ["22 ಸೆಂ.ಮೀ.", "44 ಸೆಂ.ಮೀ.", "49 ಸೆಂ.ಮೀ.", "154 ಸೆಂ.ಮೀ."], "44 ಸೆಂ.ಮೀ.", "ಸುತ್ತಳತೆ = 2πr = 2 × (22/7) × 7 = 44 ಸೆಂ.ಮೀ."),
            ("5, 7, 9, 11, 13 ಇವುಗಳ ಸರಾಸರಿ ಎಷ್ಟು?", ["7", "8", "9", "11"], "9", "ಸರಾಸರಿ = (5 + 7 + 9 + 11 + 13) / 5 = 45 / 5 = 9."),
            ("ಒಂದು ನಾಣ್ಯವನ್ನು ಒಮ್ಮೆ ಎಸೆದಾಗ ತಲೆ ಬೀಳುವ ಸಂಭವನೀಯತೆ ಎಷ್ಟು?", ["1/4", "1/3", "1/2", "1"], "1/2", "P(ತಲೆ) = 1/2."),
            ("ಒಂದು ಘನದ ಅಂಚು 4 ಸೆಂ.ಮೀ. ಆಗಿದ್ದರೆ, ಅದರ ಘನಫಲ ಎಷ್ಟು?", ["16 ಘ.ಸೆಂ.ಮೀ.", "32 ಘ.ಸೆಂ.ಮೀ.", "48 ಘ.ಸೆಂ.ಮೀ.", "64 ಘ.ಸೆಂ.ಮೀ."], "64 ಘ.ಸೆಂ.ಮೀ.", "ಘನಫಲ = a³ = 4 × 4 × 4 = 64 ಘ.ಸೆಂ.ಮೀ."),
            ("ಒಂದು ಸಿಲಿಂಡರಿನ ತ್ರಿಜ್ಯ 3 ಸೆಂ.ಮೀ. ಮತ್ತು ಎತ್ತರ 5 ಸೆಂ.ಮೀ. ಆಗಿದ್ದರೆ, ಅದರ ಘನಫಲ ಎಷ್ಟು?", ["15π ಘ.ಸೆಂ.ಮೀ.", "30π ಘ.ಸೆಂ.ಮೀ.", "45π ಘ.ಸೆಂ.ಮೀ.", "60π ಘ.ಸೆಂ.ಮೀ."], "45π ಘ.ಸೆಂ.ಮೀ.", "ಸಿಲಿಂಡರ್ ಘನಫಲ = πr²h = π × 3² × 5 = 45π ಘ.ಸೆಂ.ಮೀ."),
            ("x² - 7x + 12 = 0 ಸಮೀಕರಣದ ಮೂಲಗಳು ಯಾವುವು?", ["2 ಮತ್ತು 6", "3 ಮತ್ತು 4", "−3 ಮತ್ತು −4", "1 ಮತ್ತು 12"], "3 ಮತ್ತು 4", "(x - 3)(x - 4) = 0 => x = 3 ಮತ್ತು x = 4."),
            ("ಎರಡು ಸಂಖ್ಯೆಗಳ ಮ.ಸಾ.ಅ. 6 ಮತ್ತು ಅವುಗಳ ಲ.ಸಾ.ಅ. 36 ಆಗಿದೆ. ಒಂದು ಸಂಖ್ಯೆ 12 ಆಗಿದ್ದರೆ, ಇನ್ನೊಂದು ಸಂಖ್ಯೆ ಎಷ್ಟು?", ["12", "18", "24", "36"], "18", "ಲ.ಸಾ.ಅ. × ಮ.ಸಾ.ಅ. = ಸಂಖ್ಯೆ1 × ಸಂಖ್ಯೆ2 => 36 × 6 = 12 × x => 216 / 12 = 18.")
        ]
    }
]

def escape_str(s):
    return s.replace('\\\\', '\\\\\\\\').replace('"', '\\\\"').replace('\\n', ' ')

lines = []
for sec in questions_data:
    lines.append("        // =========================================================================")
    lines.append(f"        // =========================== {sec['header']} =====================")
    lines.append("        // =========================================================================")
    for idx, item in enumerate(sec['items'], start=1):
        q_text, opts, ans, expl = item
        q_id = f"{sec['prefix']}_{idx}"
        opts_formatted = ", ".join([f'"{escape_str(o)}"' for o in opts])
        comma = "," if (sec != questions_data[-1] or idx != len(sec['items'])) else ""
        lines.append("        QuestionModel(")
        lines.append(f'            id = "{q_id}",')
        lines.append(f'            stdId = {sec["std"]},')
        lines.append('            subjectId = "fln",')
        lines.append(f'            unitId = {sec["unit"]},')
        lines.append('            type = "MCQ",')
        lines.append(f'            questionText = "{escape_str(q_text)}",')
        lines.append(f'            options = listOf({opts_formatted}),')
        lines.append(f'            correctAnswer = "{escape_str(ans)}",')
        lines.append(f'            explanation = "{escape_str(expl)}"')
        lines.append(f'        ){comma}')

new_block = "\\n".join(lines)

with open("app/src/main/java/com/example/data/FlnCompetencyQuestionBank.kt", "r", encoding="utf-8") as f:
    content = f.read()

pattern = r"        // =========================================================================\\n        // =========================== 9 STD ENGLISH \(20 MCQs\) =====================.*"
idx = content.find("        // =========================== 9 STD ENGLISH (20 MCQs) =====================")
if idx != -1:
    header_idx = content.rfind("        // =========================================================================", 0, idx)
    prefix_content = content[:header_idx]
    final_content = prefix_content + new_block + "\\n    )\\n}\\n"
    with open("app/src/main/java/com/example/data/FlnCompetencyQuestionBank.kt", "w", encoding="utf-8") as f:
        f.write(final_content)
    print("Successfully replaced questions with user-provided MCQs!")
else:
    print("Could not find marker!")
"""

with open("/tmp/update_fln.py", "w", encoding="utf-8") as f:
    f.write(script)
