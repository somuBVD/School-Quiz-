package com.example.data

/**
 * Standard 8 - Second Language English
 * Consolidated Chapter-Wise MCQs (LBA Revised Question Bank • 2026–27)
 * Complete question bank containing 141 MCQs across Units 1 to 8, Poems, and Supplementary Readings.
 */
object Std8EnglishQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: A Day in the Ashram & Beauty", 42, "Easy"),
        UnitTemplate(2, "Unit 2: Sir C. V. Raman & The Little Busy Bee", 46, "Medium"),
        UnitTemplate(3, "Unit 3: Jamaican Fragment & No Men Are Foreign", 33, "Medium"),
        UnitTemplate(4, "Unit 4: The Boy Who Asked for More & For a Five Year Old", 29, "Medium"),
        UnitTemplate(5, "Unit 5: The Swan and the Princess & Somebody's Mother", 38, "Medium"),
        UnitTemplate(6, "Unit 6: All the World Her Stage", 19, "Hard"),
        UnitTemplate(7, "Unit 7: The Emperor's New Clothes & Machine", 19, "Medium"),
        UnitTemplate(8, "Unit 8: Luther Burbank & Axe in the Wood", 49, "Hard"),
        UnitTemplate(9, "Supplementary Readings: Shastri, Lion, Blue Umbrella, Tereshkova", 23, "Medium"),
        UnitTemplate(10, "Additional Practice: Prose & Poetry Conversions", 14, "Medium")
    )

    val questions: List<QuestionModel> = listOf(
        // ========================================================
        // 🟦 UNIT 1 – A DAY IN THE ASHRAM & POEM – BEAUTY
        // ========================================================
        QuestionModel(
            id = "s_8_eng_1",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "India is my country. The word “India” is a:",
            options = listOf("Verb", "Pronoun", "Noun", "Conjunction"),
            correctAnswer = "Noun",
            explanation = "“India” is the proper name of a specific country, so it is a proper noun."
        ),
        QuestionModel(
            id = "s_8_eng_2",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "She finished her homework quickly. “Quickly” is an:",
            options = listOf("Verb", "Adjective", "Noun", "Adverb"),
            correctAnswer = "Adverb",
            explanation = "“Quickly” describes how she finished her homework, modifying the verb 'finished', so it is an adverb."
        ),
        QuestionModel(
            id = "s_8_eng_3",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Rahul is an intelligent boy. “Intelligent” is an:",
            options = listOf("Noun", "Verb", "Adjective", "Adverb"),
            correctAnswer = "Adjective",
            explanation = "“Intelligent” describes the quality of the noun 'boy', making it an adjective."
        ),
        QuestionModel(
            id = "s_8_eng_4",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The correct prefix for “social” is:",
            options = listOf("anti-", "re-", "non-", "in-"),
            correctAnswer = "non-",
            explanation = "According to the LBA answer key, the prefix given is 'non-' (non-social / anti-social)."
        ),
        QuestionModel(
            id = "s_8_eng_5",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The correct prefix for “visible” is:",
            options = listOf("non-", "re-", "un-", "in-"),
            correctAnswer = "un-",
            explanation = "In the revised key options list, 'un-' is keyed for the item."
        ),
        QuestionModel(
            id = "s_8_eng_6",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The correct prefix for “possible” is:",
            options = listOf("re-", "im-", "mis-", "in-"),
            correctAnswer = "im-",
            explanation = "The prefix 'im-' attaches to 'possible' to form 'impossible'."
        ),
        QuestionModel(
            id = "s_8_eng_7",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Yesterday I saw ___ accident in ___ market.",
            options = listOf("the, an", "an, the", "a, an", "an, a"),
            correctAnswer = "an, the",
            explanation = "'Accident' begins with a vowel sound requiring 'an', and 'market' refers to a specific place requiring 'the'."
        ),
        QuestionModel(
            id = "s_8_eng_8",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Raju is ___ doctor working in ___ hospital.",
            options = listOf("the, a", "an, a", "a, the", "an, an"),
            correctAnswer = "a, the",
            explanation = "Raju is 'a' doctor working in 'the' hospital."
        ),
        QuestionModel(
            id = "s_8_eng_9",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "I saw ___ elephant and ___ zebra at the zoo.",
            options = listOf("the, a", "an, a", "a, the", "an, an"),
            correctAnswer = "an, a",
            explanation = "'Elephant' starts with a vowel sound requiring 'an', while 'zebra' starts with a consonant sound requiring 'a'."
        ),
        QuestionModel(
            id = "s_8_eng_10",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "A plastic chair is the opposite of a heavy chair because it is:",
            options = listOf("dark", "light", "strong", "weak"),
            correctAnswer = "light",
            explanation = "The antonym of 'heavy' in terms of weight is 'light'."
        ),
        QuestionModel(
            id = "s_8_eng_11",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Arjuna was bold but Shakuni was:",
            options = listOf("late", "weak", "timid", "happy"),
            correctAnswer = "timid",
            explanation = "The opposite of bold and courageous is timid."
        ),
        QuestionModel(
            id = "s_8_eng_12",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Making things by hand is called:",
            options = listOf("handiwork", "homework", "machine work", "class work"),
            correctAnswer = "handiwork",
            explanation = "Things made skillfully by hand are called handiwork."
        ),
        QuestionModel(
            id = "s_8_eng_13",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "A group of singers singing hymns is a:",
            options = listOf("choir", "artist", "vocalist", "carpenter"),
            correctAnswer = "choir",
            explanation = "An organized group of singers, especially in church or school assembly, is a choir."
        ),
        QuestionModel(
            id = "s_8_eng_14",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "A person who is not able to see is:",
            options = listOf("deaf", "dumb", "blind", "shy"),
            correctAnswer = "blind",
            explanation = "A person lacking the sense of sight is blind."
        ),
        QuestionModel(
            id = "s_8_eng_15",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The opposite of “fast” is:",
            options = listOf("quick", "speed", "slow", "hurry"),
            correctAnswer = "slow",
            explanation = "The direct antonym of fast is slow."
        ),
        QuestionModel(
            id = "s_8_eng_16",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The homophone that completes “I want to ___ a new bicycle” is:",
            options = listOf("by", "buy", "bye", "bay"),
            correctAnswer = "buy",
            explanation = "'Buy' means to purchase with money."
        ),
        QuestionModel(
            id = "s_8_eng_17",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The founder of Shantiniketan was:",
            options = listOf("C. V. Raman", "Rabindranath Tagore", "Luther Burbank", "Sarojini Naidu"),
            correctAnswer = "Rabindranath Tagore",
            explanation = "Gurudev Rabindranath Tagore founded the open-air school Shantiniketan in West Bengal."
        ),
        QuestionModel(
            id = "s_8_eng_18",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Shantiniketan boys are famous for:",
            options = listOf("book work", "sports and games", "business", "travelling"),
            correctAnswer = "sports and games",
            explanation = "As described in 'A Day in the Ashram', the boys of Shantiniketan are famous for their skill and enthusiasm in sports and games."
        ),
        QuestionModel(
            id = "s_8_eng_19",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The correct suffix to complete “beauti___” is:",
            options = listOf("ful", "ive", "ish", "tion"),
            correctAnswer = "ful",
            explanation = "The suffix '-ful' attaches to the root to form 'beautiful'."
        ),
        QuestionModel(
            id = "s_8_eng_20",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The antonym of “night” is:",
            options = listOf("sad", "day", "happy", "cruel"),
            correctAnswer = "day",
            explanation = "The opposite of night is day."
        ),
        QuestionModel(
            id = "s_8_eng_21",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The word that rhymes with “light” is:",
            options = listOf("sun", "late", "dark", "night"),
            correctAnswer = "night",
            explanation = "'Light' and 'night' share identical ending sound /aɪt/."
        ),
        QuestionModel(
            id = "s_8_eng_22",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The synonym of “start” is:",
            options = listOf("begin", "end", "stop", "finish"),
            correctAnswer = "begin",
            explanation = "'Start' and 'begin' have the same meaning."
        ),
        QuestionModel(
            id = "s_8_eng_23",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "In the poem, people dance for their:",
            options = listOf("food", "harvest", "school", "journey"),
            correctAnswer = "harvest",
            explanation = "In the poem 'Beauty', people are seen dancing in joy for their corn and harvest."
        ),
        QuestionModel(
            id = "s_8_eng_24",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Beauty is heard in the:",
            options = listOf("morning", "night", "classroom", "market"),
            correctAnswer = "night",
            explanation = "The poet notes that beauty is heard in the night, when wind sighs and rain falls."
        ),
        QuestionModel(
            id = "s_8_eng_25",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Which is described as beautiful in the poem?",
            options = listOf("good deeds and happy thoughts", "anger and hatred", "noise and quarrels", "carelessness"),
            correctAnswer = "good deeds and happy thoughts",
            explanation = "Beauty lies within oneself in good deeds and happy thoughts that repeat in dreams and work."
        ),

        // ========================================================
        // 🟦 UNIT 2 – SIR C. V. RAMAN & POEM – THE LITTLE BUSY BEE
        // ========================================================
        QuestionModel(
            id = "s_8_eng_26",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Raman was a kind man. “Kind” is an:",
            options = listOf("Noun", "Verb", "Adjective", "Adverb"),
            correctAnswer = "Adjective",
            explanation = "“Kind” describes the quality of the man, so it is an adjective."
        ),
        QuestionModel(
            id = "s_8_eng_27",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "He writes neatly. “Neatly” is an:",
            options = listOf("Noun", "Verb", "Adjective", "Adverb"),
            correctAnswer = "Adverb",
            explanation = "“Neatly” describes how he writes (manner of action), making it an adverb."
        ),
        QuestionModel(
            id = "s_8_eng_28",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "C. V. Raman was a scientist. “Scientist” is a:",
            options = listOf("Noun", "Verb", "Adjective", "Adverb"),
            correctAnswer = "Noun",
            explanation = "“Scientist” is a common noun denoting a person who studies or practices science."
        ),
        QuestionModel(
            id = "s_8_eng_29",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "They are working hard. “They” is a:",
            options = listOf("Noun", "Pronoun", "Adjective", "Verb"),
            correctAnswer = "Pronoun",
            explanation = "“They” is a third-person plural personal pronoun."
        ),
        QuestionModel(
            id = "s_8_eng_30",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The children are ___ in the ground.",
            options = listOf("play", "playing", "plays", "played"),
            correctAnswer = "playing",
            explanation = "Present continuous tense with 'are' requires the present participle form 'playing'."
        ),
        QuestionModel(
            id = "s_8_eng_31",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Kavya ___ melodiously.",
            options = listOf("sing", "sings", "singing", "sung"),
            correctAnswer = "sings",
            explanation = "Simple present tense with third person singular subject 'Kavya' takes 'sings'."
        ),
        QuestionModel(
            id = "s_8_eng_32",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "He ___ a new dress.",
            options = listOf("have", "has", "having", "had been"),
            correctAnswer = "has",
            explanation = "Third-person singular 'He' takes the singular verb 'has'."
        ),
        QuestionModel(
            id = "s_8_eng_33",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The correct homophone in “Do you like to ___ the music?” is:",
            options = listOf("hear", "here", "hair", "hare"),
            correctAnswer = "hear",
            explanation = "'Hear' refers to perceiving sound with the ears."
        ),
        QuestionModel(
            id = "s_8_eng_34",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The phrasal verb “put on” means:",
            options = listOf("tolerate", "wear", "distribute", "stop functioning"),
            correctAnswer = "wear",
            explanation = "'To put on' clothes means to dress or wear them."
        ),
        QuestionModel(
            id = "s_8_eng_35",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The abbreviation P.U.C. stands for:",
            options = listOf("Pre University Course", "Primary University Class", "Public Union Council", "Preliminary Unit Course"),
            correctAnswer = "Pre University Course",
            explanation = "P.U.C. stands for Pre-University Course."
        ),
        QuestionModel(
            id = "s_8_eng_36",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The noun form of “honest” is:",
            options = listOf("honestly", "honesty", "honour", "honestness"),
            correctAnswer = "honesty",
            explanation = "The abstract noun form of the adjective 'honest' is 'honesty'."
        ),
        QuestionModel(
            id = "s_8_eng_37",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The opposite of “regular” formed with a prefix is:",
            options = listOf("unregular", "irregular", "disregular", "nonregular"),
            correctAnswer = "irregular",
            explanation = "The prefix 'ir-' is used before words starting with 'r' to create 'irregular'."
        ),
        QuestionModel(
            id = "s_8_eng_38",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "C. V. Raman is famous for discovering the:",
            options = listOf("Green Revolution", "Raman Effect", "Theory of Relativity", "laws of motion"),
            correctAnswer = "Raman Effect",
            explanation = "Sir C. V. Raman discovered the scattering of light known worldwide as the Raman Effect."
        ),
        QuestionModel(
            id = "s_8_eng_39",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Raman received the Nobel Prize in:",
            options = listOf("1913", "1920", "1930", "1954"),
            correctAnswer = "1930",
            explanation = "Sir C. V. Raman was awarded the Nobel Prize in Physics in the year 1930."
        ),
        QuestionModel(
            id = "s_8_eng_40",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The synonym of “gather” is:",
            options = listOf("spread", "collect", "give", "bright"),
            correctAnswer = "collect",
            explanation = "'Gather' means to bring together or collect."
        ),
        QuestionModel(
            id = "s_8_eng_41",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The antonym of “sweet” is:",
            options = listOf("taste", "bitter", "unsweet", "sweeter"),
            correctAnswer = "bitter",
            explanation = "The opposite taste of sweet is bitter."
        ),
        QuestionModel(
            id = "s_8_eng_42",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The sweet liquid bees collect from flowers is:",
            options = listOf("nectar", "cell", "juice", "sugar"),
            correctAnswer = "nectar",
            explanation = "Bees collect nectar, the sweet liquid produced by flowers, to make honey."
        ),
        QuestionModel(
            id = "s_8_eng_43",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The word “play” rhymes with:",
            options = listOf("ring", "day", "den", "dog"),
            correctAnswer = "day",
            explanation = "'Play' and 'day' rhyme with identical sound /eɪ/."
        ),
        QuestionModel(
            id = "s_8_eng_44",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The “sweet food” made by the bee refers to:",
            options = listOf("wax", "honey", "flower", "cell"),
            correctAnswer = "honey",
            explanation = "The sweet food made by bees from flower nectar is honey."
        ),
        QuestionModel(
            id = "s_8_eng_45",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "People like the bee because it:",
            options = listOf("is clever only", "gives honey and works hard", "spreads wax only", "sleeps all day"),
            correctAnswer = "gives honey and works hard",
            explanation = "The busy bee is admired for its diligent hard work and for providing sweet honey."
        ),
        QuestionModel(
            id = "s_8_eng_46",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The poem encourages us not to be:",
            options = listOf("kind", "busy", "idle", "helpful"),
            correctAnswer = "idle",
            explanation = "The poem warns against idleness and laziness, urging everyone to work fruitfully like the bee."
        ),

        // ========================================================
        // 🟦 UNIT 3 – JAMAICAN FRAGMENT & POEM – NO MEN ARE FOREIGN
        // ========================================================
        QuestionModel(
            id = "s_8_eng_47",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "She runs very fast. “Fast” is an:",
            options = listOf("Noun", "Verb", "Adverb", "Adjective"),
            correctAnswer = "Adverb",
            explanation = "“Fast” modifies how she runs (verb), so it functions as an adverb here."
        ),
        QuestionModel(
            id = "s_8_eng_48",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The sun is shining. “Sun” is a:",
            options = listOf("Verb", "Noun", "Adjective", "Pronoun"),
            correctAnswer = "Noun",
            explanation = "“Sun” is a noun referring to the celestial star of our solar system."
        ),
        QuestionModel(
            id = "s_8_eng_49",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "In “He and his brother went to the market”, “and” is a:",
            options = listOf("Preposition", "Conjunction", "Article", "Noun"),
            correctAnswer = "Conjunction",
            explanation = "“And” connects words/clauses together, making it a coordinating conjunction."
        ),
        QuestionModel(
            id = "s_8_eng_50",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "They sat under the tree. “Under” is a:",
            options = listOf("Conjunction", "Verb", "Preposition", "Adverb"),
            correctAnswer = "Preposition",
            explanation = "“Under” indicates the position of the subjects relative to the tree, functioning as a preposition."
        ),
        QuestionModel(
            id = "s_8_eng_51",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "I saw ___ elephant at ___ zoo.",
            options = listOf("a, an", "an, the", "the, a", "an, a"),
            correctAnswer = "an, the",
            explanation = "'Elephant' requires 'an' (vowel sound), and 'zoo' refers to a specific place requiring 'the'."
        ),
        QuestionModel(
            id = "s_8_eng_52",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The sun rises in ___ east.",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "the",
            explanation = "Directions like east, west, north, and south always take the definite article 'the'."
        ),
        QuestionModel(
            id = "s_8_eng_53",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The correct homophone in “The wind will ___ the leaves away” is:",
            options = listOf("blow", "blue", "blew", "below"),
            correctAnswer = "blow",
            explanation = "After modal auxiliary 'will', base verb 'blow' is required."
        ),
        QuestionModel(
            id = "s_8_eng_54",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The world needs more:",
            options = listOf("piece", "peace", "peas", "pease"),
            correctAnswer = "peace",
            explanation = "'Peace' means harmony and freedom from war or conflict."
        ),
        QuestionModel(
            id = "s_8_eng_55",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The rabbit ran into its:",
            options = listOf("whole", "hole", "hold", "hall"),
            correctAnswer = "hole",
            explanation = "A rabbit lives in a burrow or 'hole' in the ground."
        ),
        QuestionModel(
            id = "s_8_eng_56",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "She ___ her homework before dinner.",
            options = listOf("has finish", "had finished", "have finished", "was finish"),
            correctAnswer = "had finished",
            explanation = "Past perfect tense 'had finished' shows an action completed prior to another past event (dinner)."
        ),
        QuestionModel(
            id = "s_8_eng_57",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The opposite of “correct” using a prefix is:",
            options = listOf("incorrect", "uncorrect", "discorrect", "recorrect"),
            correctAnswer = "incorrect",
            explanation = "The prefix 'in-' attaches to 'correct' to create 'incorrect'."
        ),
        QuestionModel(
            id = "s_8_eng_58",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The narrator saw two little boys who were:",
            options = listOf("both girls", "one black and one white", "both adults", "two soldiers"),
            correctAnswer = "one black and one white",
            explanation = "In 'Jamaican Fragment', the narrator observes two small boys playing, one black and one white."
        ),
        QuestionModel(
            id = "s_8_eng_59",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The story teaches that children can play together beyond differences of:",
            options = listOf("food", "race", "language only", "clothing"),
            correctAnswer = "race",
            explanation = "The story illustrates that innocence and friendship among children transcend racial boundaries."
        ),
        QuestionModel(
            id = "s_8_eng_60",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The poem “No Men Are Foreign” is written in:",
            options = listOf("a fixed rhyming couplet", "free verse", "a limerick", "a sonnet"),
            correctAnswer = "free verse",
            explanation = "James Kirkup wrote 'No Men Are Foreign' in free verse without a rigid rhyme scheme."
        ),
        QuestionModel(
            id = "s_8_eng_61",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The word “foreign” most nearly means:",
            options = listOf("familiar", "strange", "friendly", "local"),
            correctAnswer = "strange",
            explanation = "Foreign denotes unfamiliar, strange, or belonging to another country."
        ),
        QuestionModel(
            id = "s_8_eng_62",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The line “Beneath all uniforms, a single body breathes” highlights:",
            options = listOf("differences in wealth", "shared humanity", "the need for war", "national borders"),
            correctAnswer = "shared humanity",
            explanation = "It emphasizes the fundamental biological and emotional oneness of all human beings."
        ),
        QuestionModel(
            id = "s_8_eng_63",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The poem warns us against:",
            options = listOf("kindness", "peace", "war", "friendship"),
            correctAnswer = "war",
            explanation = "The poet warns against hatred, prejudice, and taking up arms in war against fellow humans."
        ),
        QuestionModel(
            id = "s_8_eng_64",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The opposite of “loyal” is:",
            options = listOf("faithful", "disloyal", "honest", "patient"),
            correctAnswer = "disloyal",
            explanation = "The negative prefix 'dis-' added to 'loyal' gives 'disloyal'."
        ),
        QuestionModel(
            id = "s_8_eng_65",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The poem’s message is that all people share:",
            options = listOf("the same earth and human emotions", "different planets", "different basic needs", "no common feelings"),
            correctAnswer = "the same earth and human emotions",
            explanation = "The poet emphasizes that we all walk upon the same earth, breathe the same air, and experience common human joys and sorrows."
        ),

        // ========================================================
        // 🟦 UNIT 4 – THE BOY WHO ASKED FOR MORE
        // ========================================================
        QuestionModel(
            id = "s_8_eng_66",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Oliver Twist was born in:",
            options = listOf("a palace", "a poor house", "a school", "a ship"),
            correctAnswer = "a poor house",
            explanation = "Oliver was born into the harsh environment of a workhouse/poor house."
        ),
        QuestionModel(
            id = "s_8_eng_67",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The boys held a council because they were:",
            options = listOf("sleepy", "always hungry and underfed", "lost", "afraid of the weather"),
            correctAnswer = "always hungry and underfed",
            explanation = "The boys suffered from slow starvation and were desperate for more gruel."
        ),
        QuestionModel(
            id = "s_8_eng_68",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The boys chose Oliver to ask for:",
            options = listOf("new clothes", "more food", "a holiday", "a book"),
            correctAnswer = "more food",
            explanation = "They cast lots and Oliver lost, so he was assigned to ask the master for more food."
        ),
        QuestionModel(
            id = "s_8_eng_69",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Oliver’s request for more food was treated as:",
            options = listOf("a reward", "a crime", "a joke", "a lesson"),
            correctAnswer = "a crime",
            explanation = "The workhouse authorities considered asking for seconds an outrageous rebellious crime."
        ),
        QuestionModel(
            id = "s_8_eng_70",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "A reward was offered for Oliver’s capture of:",
            options = listOf("five pounds", "ten pounds", "one pound", "fifty pounds"),
            correctAnswer = "five pounds",
            explanation = "A notice was posted offering five pounds to anybody who would take Oliver off the parish's hands."
        ),
        QuestionModel(
            id = "s_8_eng_71",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The correct question for the answer “The briefcase was stolen at the station” is:",
            options = listOf("When was it stolen?", "Where was it stolen?", "Why was it stolen?", "How was it stolen?"),
            correctAnswer = "Where was it stolen?",
            explanation = "'At the station' denotes a location, so the interrogative 'Where' is appropriate."
        ),
        QuestionModel(
            id = "s_8_eng_72",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The correct question for “The servant let out the secret” is:",
            options = listOf("Whom let out the secret?", "Which let out the secret?", "Who let out the secret?", "How let out the secret?"),
            correctAnswer = "Who let out the secret?",
            explanation = "'The servant' is the subject of the sentence, so the subject question word is 'Who'."
        ),

        // ========================================================
        // 🟦 UNIT 5 – THE SWAN AND THE PRINCESS & POEM – SOMEBODY’S MOTHER
        // ========================================================
        QuestionModel(
            id = "s_8_eng_73",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The correct suffix in “help___” is:",
            options = listOf("ful", "less", "ment", "tion"),
            correctAnswer = "ful",
            explanation = "The standard productive suffix given in the key is '-ful' (helpful)."
        ),
        QuestionModel(
            id = "s_8_eng_74",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The correct spelling is:",
            options = listOf("recieve", "receive", "receeve", "receve"),
            correctAnswer = "receive",
            explanation = "According to the rule 'i before e except after c', 'receive' is correctly spelled with 'ei'."
        ),
        QuestionModel(
            id = "s_8_eng_75",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The opposite of “agreement” is:",
            options = listOf("reinvestment", "disagreement", "illtreatment", "development"),
            correctAnswer = "disagreement",
            explanation = "Prefix 'dis-' forms the opposite: 'disagreement'."
        ),
        QuestionModel(
            id = "s_8_eng_76",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The correct preposition is: “The bird flew ___ Siddhartha.”",
            options = listOf("on", "in", "to", "for"),
            correctAnswer = "to",
            explanation = "The preposition 'to' shows movement toward Siddhartha."
        ),
        QuestionModel(
            id = "s_8_eng_77",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The noun form of “kind” is:",
            options = listOf("kindful", "kindness", "kindly", "kindment"),
            correctAnswer = "kindness",
            explanation = "The abstract noun form of adjective 'kind' is 'kindness'."
        ),
        QuestionModel(
            id = "s_8_eng_78",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The passive form of “Siddhartha nursed the swan back to health” is:",
            options = listOf(
                "The swan was nursed back to health by Siddhartha.",
                "The swan nursed Siddhartha.",
                "Siddhartha was nursed by the swan.",
                "The swan is nurse by Siddhartha."
            ),
            correctAnswer = "The swan was nursed back to health by Siddhartha.",
            explanation = "In past simple passive, object + was + past participle (nursed) + by agent."
        ),
        QuestionModel(
            id = "s_8_eng_79",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The story contrasts Siddhartha’s kindness with Devadatta’s:",
            options = listOf("patience", "cruelty", "honesty", "humour"),
            correctAnswer = "cruelty",
            explanation = "Devadatta shot the innocent bird with an arrow out of cruelty, while Siddhartha saved its life."
        ),
        QuestionModel(
            id = "s_8_eng_80",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The swan decided the case by:",
            options = listOf(
                "staying with Devadatta",
                "flying away and landing between Siddhartha and Devadatta",
                "returning to the forest",
                "hiding in a tree"
            ),
            correctAnswer = "flying away and landing between Siddhartha and Devadatta",
            explanation = "When placed between them, the bird moved to Siddhartha who saved it, confirming the law that the saver has greater right than the killer."
        ),
        QuestionModel(
            id = "s_8_eng_81",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "In “She finished her project quickly”, “quickly” is an:",
            options = listOf("adjective", "adverb", "verb", "noun"),
            correctAnswer = "adverb",
            explanation = "“Quickly” tells how the action was completed, so it is an adverb."
        ),
        QuestionModel(
            id = "s_8_eng_82",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "“Oh! no, I forgot my phone” contains an:",
            options = listOf("interjection", "conjunction", "preposition", "article"),
            correctAnswer = "interjection",
            explanation = "'Oh!' expresses sudden emotion or shock, making it an interjection."
        ),
        QuestionModel(
            id = "s_8_eng_83",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "“The book on the table” uses “on” as a:",
            options = listOf("preposition", "conjunction", "adverb", "article"),
            correctAnswer = "preposition",
            explanation = "'On' shows the spatial relationship between the book and the table, functioning as a preposition."
        ),
        QuestionModel(
            id = "s_8_eng_84",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The poet of “Somebody’s Mother” is:",
            options = listOf("Sarojini Naidu", "Mary Dow Brine", "Rabindranath Tagore", "Emily Dickinson"),
            correctAnswer = "Mary Dow Brine",
            explanation = "Mary Dow Brine wrote the touching narrative poem 'Somebody's Mother'."
        ),
        QuestionModel(
            id = "s_8_eng_85",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The old woman was:",
            options = listOf("young and strong", "old and weak", "rich and proud", "angry and noisy"),
            correctAnswer = "old and weak",
            explanation = "She was bent with the chill of winter and trembling with age."
        ),
        QuestionModel(
            id = "s_8_eng_86",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The boy helped the old woman by:",
            options = listOf("giving her money", "helping her cross the street", "taking her home", "buying her food"),
            correctAnswer = "helping her cross the street",
            explanation = "The cheerful schoolboy guided her trembling feet safely across the crowded slippery street."
        ),
        QuestionModel(
            id = "s_8_eng_87",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The poem teaches us to show:",
            options = listOf("pride", "kindness and compassion", "jealousy", "carelessness"),
            correctAnswer = "kindness and compassion",
            explanation = "It inspires young people to respect and help elderly persons with empathy and love."
        ),

        // ========================================================
        // 🟦 UNIT 6 – ALL THE WORLD HER STAGE
        // ========================================================
        QuestionModel(
            id = "s_8_eng_88",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "According to the answer key, the opposite of “thin” in the first MCQ set is:",
            options = listOf("fat", "tall", "weak", "short"),
            correctAnswer = "fat",
            explanation = "The antonym of thin is fat."
        ),
        QuestionModel(
            id = "s_8_eng_89",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The correct word in the answer key for item 2 is:",
            options = listOf("appeared", "disappeared", "arrived", "looked"),
            correctAnswer = "appeared",
            explanation = "According to the LBA answer key, option A 'appeared' is keyed."
        ),
        QuestionModel(
            id = "s_8_eng_90",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The correct word in the answer key for item 3 is:",
            options = listOf("seriously", "slowly", "happily", "carelessly"),
            correctAnswer = "seriously",
            explanation = "According to the LBA answer key, option A 'seriously' is keyed."
        ),
        QuestionModel(
            id = "s_8_eng_91",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The word “crumpled” means:",
            options = listOf("polished", "crushed", "painted", "folded neatly"),
            correctAnswer = "crushed",
            explanation = "Crumpled means crushed or wrinkled into folds."
        ),
        QuestionModel(
            id = "s_8_eng_92",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The word “fascinated” means:",
            options = listOf("attracted", "frightened", "bored", "confused"),
            correctAnswer = "attracted",
            explanation = "Fascinated means strongly attracted and interested."
        ),
        QuestionModel(
            id = "s_8_eng_93",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The comparative form of “fast” is:",
            options = listOf("fastest", "faster", "more fast", "most fast"),
            correctAnswer = "faster",
            explanation = "The degrees of comparison are fast (positive), faster (comparative), and fastest (superlative)."
        ),
        QuestionModel(
            id = "s_8_eng_94",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The correct article is: “He is ___ honest man.”",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "an",
            explanation = "The 'h' in 'honest' is silent, so the word begins with a vowel sound /ɒ/, requiring the indefinite article 'an'."
        ),
        QuestionModel(
            id = "s_8_eng_95",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The correct language function for asking someone to do something politely is:",
            options = listOf("request", "jeer", "complaint", "warning"),
            correctAnswer = "request",
            explanation = "Polite appeals to have someone do something represent the language function of making a request."
        ),

        // ========================================================
        // 🟦 UNIT 7 – THE EMPEROR’S NEW CLOTHES & POEM – MACHINE
        // ========================================================
        QuestionModel(
            id = "s_8_eng_96",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The Emperor was most fond of:",
            options = listOf("food", "new clothes", "horses", "books"),
            correctAnswer = "new clothes",
            explanation = "The Emperor cared only about dressing well and spending money on fine new robes."
        ),
        QuestionModel(
            id = "s_8_eng_97",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The Emperor pretended to see the clothes because he feared people would think he was:",
            options = listOf("generous", "unfit to be Emperor", "poor", "ill"),
            correctAnswer = "unfit to be Emperor",
            explanation = "The weavers claimed their cloth was invisible to anyone stupid or unfit for office."
        ),
        QuestionModel(
            id = "s_8_eng_98",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The child who exposed the truth said that the Emperor was:",
            options = listOf("beautifully dressed", "wearing invisible clothes", "not wearing any clothes", "wearing armour"),
            correctAnswer = "not wearing any clothes",
            explanation = "An innocent little child cried out that the Emperor had nothing on at all."
        ),
        QuestionModel(
            id = "s_8_eng_99",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The Emperor’s main weakness was his:",
            options = listOf("kindness", "vanity and pride", "courage", "generosity"),
            correctAnswer = "vanity and pride",
            explanation = "Excessive vanity about clothes and fear of losing prestige made him foolish."
        ),
        QuestionModel(
            id = "s_8_eng_100",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The story encourages readers to value:",
            options = listOf("appearance over truth", "honesty and courage", "flattery", "silence"),
            correctAnswer = "honesty and courage",
            explanation = "The classic tale teaches that truth and honesty should always be spoken, even when others conform to lies."
        ),
        QuestionModel(
            id = "s_8_eng_101",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The correct question for “Rama eats a banana” is:",
            options = listOf("How did Rama eat?", "Where does Rama eat?", "When has Rama eaten?", "What does Rama eat?"),
            correctAnswer = "What does Rama eat?",
            explanation = "'A banana' is the direct object, so the question word 'What' with auxiliary 'does' is correct."
        ),
        QuestionModel(
            id = "s_8_eng_102",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Machines are described as children of the:",
            options = listOf("sea", "human brain", "forest", "sun"),
            correctAnswer = "human brain",
            explanation = "In Rudyard Kipling's poem 'The Secret of the Machines', machines acknowledge they were created by the human brain."
        ),
        QuestionModel(
            id = "s_8_eng_103",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "According to the answer key, machines cannot detect:",
            options = listOf("sound", "lies", "light", "movement"),
            correctAnswer = "lies",
            explanation = "Machines cannot comprehend moral falsehood or love; they operate strictly according to physical laws."
        ),
        QuestionModel(
            id = "s_8_eng_104",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Machines do not have human:",
            options = listOf("tools", "feelings and emotions", "wheels", "instructions"),
            correctAnswer = "feelings and emotions",
            explanation = "Machines are purely mechanical and lack pity, anger, forgivefulness, or feelings."
        ),
        QuestionModel(
            id = "s_8_eng_105",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The poem reminds us to use machines:",
            options = listOf("without thinking", "wisely", "for every human decision", "as replacements for all people"),
            correctAnswer = "wisely",
            explanation = "Because machines can kill if mishandled, they must be controlled with care and wisdom."
        ),

        // ========================================================
        // 🟦 UNIT 8 – LUTHER BURBANK & POEM – AXE IN THE WOOD
        // ========================================================
        QuestionModel(
            id = "s_8_eng_106",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The correct answer to Unit 8 MCQ 1 in the answer key is:",
            options = listOf("incorrect", "correct", "possible", "regular"),
            correctAnswer = "incorrect",
            explanation = "According to the LBA answer key, option A 'incorrect' is keyed."
        ),
        QuestionModel(
            id = "s_8_eng_107",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The correct answer to Unit 8 MCQ 2 in the answer key is:",
            options = listOf("although", "because", "unless", "while"),
            correctAnswer = "because",
            explanation = "According to the LBA answer key, option B 'because' is keyed."
        ),
        QuestionModel(
            id = "s_8_eng_108",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The correct answer to Unit 8 MCQ 3 in the answer key is:",
            options = listOf("play", "plays", "played", "playing"),
            correctAnswer = "play",
            explanation = "According to the LBA answer key, option A 'play' is keyed."
        ),
        QuestionModel(
            id = "s_8_eng_109",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The correct answer to Unit 8 MCQ 4 in the answer key is:",
            options = listOf("fame", "famous", "fameful", "famously"),
            correctAnswer = "fame",
            explanation = "According to the LBA answer key, option A 'fame' is keyed."
        ),
        QuestionModel(
            id = "s_8_eng_110",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The correct tag question is: “He is a teacher, ___?”",
            options = listOf("is he", "isn’t he", "does he", "wasn’t he"),
            correctAnswer = "isn’t he",
            explanation = "A positive statement with auxiliary 'is' requires a negative tag 'isn't he?'."
        ),
        QuestionModel(
            id = "s_8_eng_111",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The correct question tag is: “She was present, ___?”",
            options = listOf("isn’t she", "doesn’t she", "wasn’t she", "didn’t she"),
            correctAnswer = "wasn’t she",
            explanation = "A positive statement with 'was' takes the negative tag 'wasn't she?'."
        ),
        QuestionModel(
            id = "s_8_eng_112",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The phrase “want ___ grow” is completed with:",
            options = listOf("grow", "to grow", "growing", "grew"),
            correctAnswer = "to grow",
            explanation = "The verb 'want' is followed by the to-infinitive 'to grow'."
        ),
        QuestionModel(
            id = "s_8_eng_113",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Luther Burbank is known for developing many varieties of:",
            options = listOf("machines", "plants", "buildings", "vehicles"),
            correctAnswer = "plants",
            explanation = "Luther Burbank was a legendary American botanist and horticulturist who developed over 800 plant varieties."
        ),
        QuestionModel(
            id = "s_8_eng_114",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Burbank’s work contributed mainly to:",
            options = listOf("agricultural science", "astronomy", "music", "architecture"),
            correctAnswer = "agricultural science",
            explanation = "His work in plant hybridization revolutionized modern agricultural and botanical science."
        ),
        QuestionModel(
            id = "s_8_eng_115",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The correct answer to poem MCQ 1 in the answer key is:",
            options = listOf("saw", "axe", "branch", "leaf"),
            correctAnswer = "axe",
            explanation = "The poem revolves around the woodcutter's 'axe' in the wood."
        ),
        QuestionModel(
            id = "s_8_eng_116",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The correct answer to poem MCQ 2 in the answer key is:",
            options = listOf("weak", "strong", "small", "soft"),
            correctAnswer = "strong",
            explanation = "According to the LBA answer key, option B 'strong' is keyed."
        ),
        QuestionModel(
            id = "s_8_eng_117",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The correct answer to poem MCQ 3 in the answer key is:",
            options = listOf("animals", "trees", "people", "rivers"),
            correctAnswer = "people",
            explanation = "According to the LBA answer key, option C 'people' is keyed."
        ),
        QuestionModel(
            id = "s_8_eng_118",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The poem encourages us to:",
            options = listOf("cut down every tree", "protect trees and nature", "waste wood", "ignore forests"),
            correctAnswer = "protect trees and nature",
            explanation = "Clifford Dyment's poem laments the quick destruction of a tree that took centuries to grow, inspiring forest conservation."
        ),

        // ========================================================
        // 🟦 SUPPLEMENTARY READINGS 1 TO 4
        // ========================================================
        QuestionModel(
            id = "s_8_eng_119",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Lal Bahadur Shastri is remembered as a:",
            options = listOf("careless leader", "kind and honest leader", "selfish ruler", "famous artist"),
            correctAnswer = "kind and honest leader",
            explanation = "India's second Prime Minister Lal Bahadur Shastri is revered for his humility, integrity, and simplicity."
        ),
        QuestionModel(
            id = "s_8_eng_120",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "When the mango seller’s day was ending, Shastri:",
            options = listOf("took advantage of him", "paid a fair price", "refused to buy mangoes", "asked for free mangoes"),
            correctAnswer = "paid a fair price",
            explanation = "Shastri refused to bargain down a poor vendor just because it was late in the day, demonstrating deep empathy."
        ),
        QuestionModel(
            id = "s_8_eng_121",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "The incident with the mango seller shows Shastri’s:",
            options = listOf("pride", "honesty and compassion", "anger", "carelessness"),
            correctAnswer = "honesty and compassion",
            explanation = "His refusal to exploit a poor man's helplessness is a testament to honesty and compassionate character."
        ),
        QuestionModel(
            id = "s_8_eng_122",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "The lion checked the sound because it had been misunderstood as:",
            options = listOf("a song", "an earthquake", "a storm", "a drum"),
            correctAnswer = "an earthquake",
            explanation = "The panic spread across the forest animals because a falling fruit was rumored to be the earth collapsing."
        ),
        QuestionModel(
            id = "s_8_eng_123",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "The story teaches us to:",
            options = listOf("believe every rumour", "verify facts before believing them", "spread fear", "avoid questions"),
            correctAnswer = "verify facts before believing them",
            explanation = "The fable shows that intelligent beings investigate the truth rather than falling prey to baseless panic."
        ),
        QuestionModel(
            id = "s_8_eng_124",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "The author of “The Blue Umbrella” is:",
            options = listOf("Ruskin Bond", "R. K. Narayan", "Mulk Raj Anand", "Rabindranath Tagore"),
            correctAnswer = "Ruskin Bond",
            explanation = "The famous novella 'The Blue Umbrella' is written by renowned Indian author Ruskin Bond."
        ),
        QuestionModel(
            id = "s_8_eng_125",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "The story is described as teaching:",
            options = listOf("greed and jealousy only", "kindness, honesty and forgiveness", "pride and anger", "fear and silence"),
            correctAnswer = "kindness, honesty and forgiveness",
            explanation = "Binya gives up her prized umbrella to Ram Bharosa, demonstrating selflessness and forgiveness."
        ),
        QuestionModel(
            id = "s_8_eng_126",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Valentina Tereshkova went round the Earth on:",
            options = listOf("16 June 1963", "7 May 1961", "21 November 1970", "15 August 1947"),
            correctAnswer = "16 June 1963",
            explanation = "Soviet cosmonaut Valentina Tereshkova launched aboard Vostok 6 on 16 June 1963, becoming the first woman in space."
        ),
        QuestionModel(
            id = "s_8_eng_127",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Valentina Tereshkova is known as a:",
            options = listOf("plant breeder", "space traveller/cosmonaut", "poet", "scientist who discovered Raman Effect"),
            correctAnswer = "space traveller/cosmonaut",
            explanation = "Valentina Tereshkova is world famous as the first woman space traveler/cosmonaut."
        ),

        // ========================================================
        // 🟦 ADDITIONAL MCQs CONVERTED FROM SHORT-ANSWER & FILL-IN CONTENT
        // ========================================================
        QuestionModel(
            id = "s_8_eng_128",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "The boys spend their evening at Shantiniketan mainly by:",
            options = listOf("playing sports and games", "working in a factory", "watching television", "going to a market"),
            correctAnswer = "playing sports and games",
            explanation = "As described in 'A Day in the Ashram', evenings are devoted to sports, games, and recreation."
        ),
        QuestionModel(
            id = "s_8_eng_129",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "The students’ classes at Shantiniketan are often held:",
            options = listOf("in open air under trees", "only in a large hall", "inside a shopping centre", "at a railway station"),
            correctAnswer = "in open air under trees",
            explanation = "Tagore emphasized natural learning where students sit in small circles in the open air beneath shady trees."
        ),
        QuestionModel(
            id = "s_8_eng_130",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Beauty in the poem is found in:",
            options = listOf("nature, good deeds and happy thoughts", "only expensive things", "only paintings", "only clothes"),
            correctAnswer = "nature, good deeds and happy thoughts",
            explanation = "Beauty is seen in sunlight and trees, heard in gentle winds, and experienced in noble deeds."
        ),
        QuestionModel(
            id = "s_8_eng_131",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Raman could not go to the United Kingdom for higher studies because:",
            options = listOf("he lost his books", "his health broke down", "he had no interest in science", "he failed his examination"),
            correctAnswer = "his health broke down",
            explanation = "A civil surgeon found Raman physically frail and advised him that he would not survive the harsh English climate."
        ),
        QuestionModel(
            id = "s_8_eng_132",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "The burnt currency-note incident shows Raman’s:",
            options = listOf("kindness", "pride", "laziness", "anger"),
            correctAnswer = "kindness",
            explanation = "As Deputy Accountant General, Raman helped an honest villager recover money from accidentally burnt notes."
        ),
        QuestionModel(
            id = "s_8_eng_133",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "On the second day, the narrator saw that:",
            options = listOf("the boys’ roles had changed", "the boys had disappeared", "the boys were fighting adults", "the street was empty"),
            correctAnswer = "the boys’ roles had changed",
            explanation = "The next afternoon, the black boy was playing the master and the white boy was obediently carrying out orders."
        ),
        QuestionModel(
            id = "s_8_eng_134",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Oliver was punished after he asked for:",
            options = listOf("more food", "a new coat", "a holiday", "a teacher"),
            correctAnswer = "more food",
            explanation = "Oliver was locked up in dark confinement simply for pleading, 'Please, sir, I want some more.'"
        ),
        QuestionModel(
            id = "s_8_eng_135",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Siddhartha cared for the swan because it was:",
            options = listOf("injured", "noisy", "hungry for grain", "lost in a city"),
            correctAnswer = "injured",
            explanation = "Prince Siddhartha pulled out the cruel arrow, cleaned the wound, and applied soothing herbs."
        ),
        QuestionModel(
            id = "s_8_eng_136",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "The old woman was struggling to:",
            options = listOf("cross the street", "climb a mountain", "carry a boat", "enter a classroom"),
            correctAnswer = "cross the street",
            explanation = "She feared being run down by busy carriages on the icy street until the compassionate schoolboy helped her."
        ),
        QuestionModel(
            id = "s_8_eng_137",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Sai’s grandfather encouraged her by:",
            options = listOf("listening to her stories", "stopping her from reading", "asking her to leave school", "ignoring her talents"),
            correctAnswer = "listening to her stories",
            explanation = "Her grandfather Sir R. P. Paranjpye patiently listened to her inventive fairy tales and encouraged her creativity."
        ),
        QuestionModel(
            id = "s_8_eng_138",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "The weavers tricked the Emperor by claiming their cloth was:",
            options = listOf("invisible to foolish or unfit people", "made of gold", "very heavy", "only for children"),
            correctAnswer = "invisible to foolish or unfit people",
            explanation = "The swindlers claimed the special fabric could not be seen by anyone unsuited for their post or hopelessly stupid."
        ),
        QuestionModel(
            id = "s_8_eng_139",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Luther Burbank’s work involved developing:",
            options = listOf("new plant varieties", "new languages", "new musical instruments", "new railway lines"),
            correctAnswer = "new plant varieties",
            explanation = "Burbank bred hundreds of new varieties of fruits, vegetables, flowers, and grains."
        ),
        QuestionModel(
            id = "s_8_eng_140",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "The poem’s central message is to:",
            options = listOf("protect trees", "waste natural resources", "cut all old trees", "ignore living things"),
            correctAnswer = "protect trees",
            explanation = "The poem delivers a poignant ecological plea to preserve trees and safeguard nature."
        ),
        QuestionModel(
            id = "s_8_eng_141",
            stdId = 8,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Valentina Tereshkova’s schooling was not smooth and continuous mainly because of:",
            options = listOf("the circumstances of her early life", "her dislike of books", "her work as a teacher", "her travel to India"),
            correctAnswer = "the circumstances of her early life",
            explanation = "Poverty following her father's death in the war forced her to work in a tire factory while attending night school."
        )
,
        // ========================================================
        // 🟦 UNIT 1 – A DAY IN THE ASHRAM & POEM – BEAUTY (ADDITIONAL MCQs)
        // ========================================================
        QuestionModel(
            id = "s_8_eng_142",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "“He is my best friend.” The word “He” is a:",
            options = listOf("Noun", "Pronoun", "Verb", "Adjective"),
            correctAnswer = "Pronoun",
            explanation = "“He” replaces a person’s name, functioning as a personal pronoun."
        ),
        QuestionModel(
            id = "s_8_eng_143",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "“She writes a letter to her mother.” The word “writes” is a:",
            options = listOf("Noun", "Adjective", "Verb", "Adverb"),
            correctAnswer = "Verb",
            explanation = "“Writes” is the action word (verb) performed by the subject."
        ),
        QuestionModel(
            id = "s_8_eng_144",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The correct prefix to form the opposite of “regular” is:",
            options = listOf("dis-", "ir-", "im-", "un-"),
            correctAnswer = "ir-",
            explanation = "The prefix “ir-” attaches to “regular” to form “irregular”."
        ),
        QuestionModel(
            id = "s_8_eng_145",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The correct prefix to form the antonym of “agree” is:",
            options = listOf("un-", "im-", "dis-", "re-"),
            correctAnswer = "dis-",
            explanation = "The prefix “dis-” combines with “agree” to form “disagree”."
        ),
        QuestionModel(
            id = "s_8_eng_146",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Fill in the blanks with suitable articles: “She sat on ___ bench in ___ park.”",
            options = listOf("a, a", "the, the", "an, an", "a, the"),
            correctAnswer = "a, the",
            explanation = "“A bench” introduces a general bench, and “the park” refers to the specific local park."
        ),
        QuestionModel(
            id = "s_8_eng_147",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Fill in the blanks with suitable articles: “Suresh is ___ M.L.A., who is ___ honest politician.”",
            options = listOf("a, a", "an, an", "the, a", "an, a"),
            correctAnswer = "an, an",
            explanation = "“M.L.A.” starts with the vowel sound /em/, and “honest” has a silent “h” (/ɒ/), requiring “an”."
        ),
        QuestionModel(
            id = "s_8_eng_148",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The antonym of “happy” is:",
            options = listOf("sad", "glad", "joyful", "calm"),
            correctAnswer = "sad",
            explanation = "The direct opposite of “happy” is “sad” (or “unhappy”)."
        ),
        QuestionModel(
            id = "s_8_eng_149",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The opposite of “same” is:",
            options = listOf("equal", "similar", "different", "common"),
            correctAnswer = "different",
            explanation = "“Same” means identical; its antonym is “different”."
        ),
        QuestionModel(
            id = "s_8_eng_150",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The opposite of “in time” is:",
            options = listOf("early", "late", "quick", "soon"),
            correctAnswer = "late",
            explanation = "Being “in time” means arriving before the deadline; its opposite is “late”."
        ),
        QuestionModel(
            id = "s_8_eng_151",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The antonym of “enemy” is:",
            options = listOf("stranger", "friend", "rival", "opponent"),
            correctAnswer = "friend",
            explanation = "An “enemy” is an adversary; the opposite is a “friend”."
        ),
        QuestionModel(
            id = "s_8_eng_152",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "A person who designs or makes architectural plans is called a:",
            options = listOf("draftsman", "singer", "farmer", "painter"),
            correctAnswer = "draftsman",
            explanation = "A draftsman is skilled in technical drawing and drafting engineering or architectural plans."
        ),
        QuestionModel(
            id = "s_8_eng_153",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "A person who always arrives exactly on time is:",
            options = listOf("careless", "punctual", "lazy", "late"),
            correctAnswer = "punctual",
            explanation = "“Punctual” describes someone who observes scheduled time strictly."
        ),
        QuestionModel(
            id = "s_8_eng_154",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Which of the following is a countable noun?",
            options = listOf("friend", "water", "air", "soil"),
            correctAnswer = "friend",
            explanation = "“Friend” can be counted individually (one friend, two friends), unlike uncountable substances."
        ),
        QuestionModel(
            id = "s_8_eng_155",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Choose the correct homophone: “The dog wagged its ___.”",
            options = listOf("tale", "tail", "tile", "tall"),
            correctAnswer = "tail",
            explanation = "A “tail” is the hindmost animal appendage; “tale” means a story."
        ),
        QuestionModel(
            id = "s_8_eng_156",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Choose the correct homophone: “He won the first ___ in the race.”",
            options = listOf("price", "prize", "praise", "prise"),
            correctAnswer = "prize",
            explanation = "A “prize” is an award granted for winning; “price” refers to cost."
        ),
        QuestionModel(
            id = "s_8_eng_157",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "In the poem “Beauty”, people are described as:",
            options = listOf("crying in fear", "dancing for their harvest", "sleeping in idle ease", "running in anger"),
            correctAnswer = "dancing for their harvest",
            explanation = "In the poem, the poet describes “people working, or dancing for their harvest”."
        ),
        QuestionModel(
            id = "s_8_eng_158",
            stdId = 8,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "According to the poem, beauty is seen in:",
            options = listOf("sunlight, trees and birds", "only expensive jewelry", "only modern buildings", "only fine clothes"),
            correctAnswer = "sunlight, trees and birds",
            explanation = "The poem begins: “Beauty is seen in the sunlight, the trees, the birds...”."
        ),
        // ========================================================
        // 🟦 UNIT 2 – SIR C. V. RAMAN & POEM – THE LITTLE BUSY BEE (ADDITIONAL MCQs)
        // ========================================================
        QuestionModel(
            id = "s_8_eng_159",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "In “The students were playing in the playground”, the word “playing” is a:",
            options = listOf("Noun", "Pronoun", "Adjective", "Verb"),
            correctAnswer = "Verb",
            explanation = "“Playing” is the action verb in the past continuous tense."
        ),
        QuestionModel(
            id = "s_8_eng_160",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Which of the following forms a meaningful compound word with “break”?",
            options = listOf("break + fast", "break + house", "break + berry", "break + box"),
            correctAnswer = "break + fast",
            explanation = "“Break” and “fast” unite to create the compound word “breakfast”."
        ),
        QuestionModel(
            id = "s_8_eng_161",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Which of the following forms a meaningful compound word with “water”?",
            options = listOf("water + fall", "water + fly", "water + beat", "water + box"),
            correctAnswer = "water + fall",
            explanation = "“Water” and “fall” combine to form “waterfall”."
        ),
        QuestionModel(
            id = "s_8_eng_162",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Which of the following is a recognized compound word?",
            options = listOf("dragon + fly", "dragon + fall", "dragon + box", "dragon + light"),
            correctAnswer = "dragon + fly",
            explanation = "“Dragonfly” is the compound name for the agile winged insect."
        ),
        QuestionModel(
            id = "s_8_eng_163",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Select the correct compound word formed with “heart”:",
            options = listOf("heart + light", "heart + break", "heart + house", "heart + fly"),
            correctAnswer = "heart + break",
            explanation = "“Heartbreak” is an established English compound word expressing intense sorrow."
        ),
        QuestionModel(
            id = "s_8_eng_164",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Which word combination forms a valid compound noun?",
            options = listOf("hand + fall", "hand + shake", "hand + box", "hand + house"),
            correctAnswer = "hand + shake",
            explanation = "“Handshake” is a standard compound noun denoting a mutual greeting."
        ),
        QuestionModel(
            id = "s_8_eng_165",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank with the appropriate auxiliary verb: “The student ___ reading the books.”",
            options = listOf("are", "is", "were", "have"),
            correctAnswer = "is",
            explanation = "The singular subject “The student” takes the singular auxiliary “is”."
        ),
        QuestionModel(
            id = "s_8_eng_166",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct auxiliary verb: “They ___ writing notes.”",
            options = listOf("was", "is", "are", "has"),
            correctAnswer = "are",
            explanation = "The plural pronoun “They” takes the plural auxiliary “are”."
        ),
        QuestionModel(
            id = "s_8_eng_167",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Complete the sentence with the correct word: “Sanju bought a new car ___ week.”",
            options = listOf("last", "lost", "least", "lasted"),
            correctAnswer = "last",
            explanation = "“Last week” is the correct temporal adverbial phrase denoting the previous week."
        ),
        QuestionModel(
            id = "s_8_eng_168",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct pair of homophones: “My ___ wants to see the ___.”",
            options = listOf("son, sun", "sun, son", "son, son", "sun, sun"),
            correctAnswer = "son, sun",
            explanation = "“Son” refers to a male child, while “sun” refers to the star that lights the earth."
        ),
        QuestionModel(
            id = "s_8_eng_169",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Select the proper homophones: “They ___ the ___ every morning.”",
            options = listOf("see, sea", "sea, see", "see, see", "sea, sea"),
            correctAnswer = "see, sea",
            explanation = "“See” denotes looking with eyes, and “sea” denotes the ocean."
        ),
        QuestionModel(
            id = "s_8_eng_170",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the appropriate homophone: “I will ___ my friend today.”",
            options = listOf("meat", "meet", "mete", "met"),
            correctAnswer = "meet",
            explanation = "“Meet” means to encounter someone; “meat” is animal flesh."
        ),
        QuestionModel(
            id = "s_8_eng_171",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The phrasal verb “give up” means to:",
            options = listOf("wear clothes", "tolerate pain", "stop or abandon", "distribute items"),
            correctAnswer = "stop or abandon",
            explanation = "“Give up” means to cease an effort, habit, or attempt."
        ),
        QuestionModel(
            id = "s_8_eng_172",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The phrasal verb “put up with” means to:",
            options = listOf("tolerate or endure", "wear clothes", "distribute awards", "stop functioning"),
            correctAnswer = "tolerate or endure",
            explanation = "“Put up with” is an idiomatic phrasal verb meaning to tolerate an unpleasant situation."
        ),
        QuestionModel(
            id = "s_8_eng_173",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The phrasal verb “break down” means to:",
            options = listOf("distribute sweets", "stop functioning properly", "wear garments", "leave quickly"),
            correctAnswer = "stop functioning properly",
            explanation = "When machines or health “break down”, they cease operating effectively."
        ),
        QuestionModel(
            id = "s_8_eng_174",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The phrasal verb “give away” means to:",
            options = listOf("wear something", "tolerate behavior", "distribute freely", "abandon hope"),
            correctAnswer = "distribute freely",
            explanation = "“Give away” means to present or distribute gifts or awards."
        ),
        QuestionModel(
            id = "s_8_eng_175",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The abbreviation “SSLC” stands for:",
            options = listOf("Secondary School Leaving Certificate", "Senior School Learning Course", "State School Leaving Class", "Secondary Studies Learning Certificate"),
            correctAnswer = "Secondary School Leaving Certificate",
            explanation = "SSLC is the official certificate awarded after completing Class 10."
        ),
        QuestionModel(
            id = "s_8_eng_176",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The educational abbreviation “B.A.” stands for:",
            options = listOf("Bachelor of Arts", "Basic Arts", "Bachelor of Administration", "Board of Arts"),
            correctAnswer = "Bachelor of Arts",
            explanation = "B.A. is an undergraduate degree awarded in humanities and arts."
        ),
        QuestionModel(
            id = "s_8_eng_177",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The academic abbreviation “M.A.” stands for:",
            options = listOf("Master of Arts", "Modern Arts", "Major Arts", "Master Administration"),
            correctAnswer = "Master of Arts",
            explanation = "M.A. is a postgraduate master’s degree in the arts and humanities."
        ),
        QuestionModel(
            id = "s_8_eng_178",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "In competitive examinations, the acronym “CET” stands for:",
            options = listOf("Common Entrance Test", "Central Education Training", "Common Education Term", "College Entrance Training"),
            correctAnswer = "Common Entrance Test",
            explanation = "CET is a standardized examination conducted for professional admissions."
        ),
        QuestionModel(
            id = "s_8_eng_179",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The abstract noun formed from the adjective “kind” is:",
            options = listOf("kindly", "kindness", "kinder", "kindful"),
            correctAnswer = "kindness",
            explanation = "Adding “-ness” to “kind” forms the abstract quality noun “kindness”."
        ),
        QuestionModel(
            id = "s_8_eng_180",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The noun form of the verb “mean” is:",
            options = listOf("meaning", "meaningful", "meant", "meanly"),
            correctAnswer = "meaning",
            explanation = "“Meaning” is the noun representing the significance of a word or action."
        ),
        QuestionModel(
            id = "s_8_eng_181",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The antonym of “fortunate” formed with a prefix is:",
            options = listOf("unfortunate", "disfortunate", "infrequent", "unfortune"),
            correctAnswer = "unfortunate",
            explanation = "The prefix “un-” combines with “fortunate” to produce “unfortunate”."
        ),
        QuestionModel(
            id = "s_8_eng_182",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The antonym of “complete” formed with a prefix is:",
            options = listOf("incomplete", "discomplete", "uncomplete", "recomplete"),
            correctAnswer = "incomplete",
            explanation = "The negative prefix “in-” produces “incomplete”."
        ),
        QuestionModel(
            id = "s_8_eng_183",
            stdId = 8,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Choose the correct prefix form: “My mother likes fruits but she ___ sweets.”",
            options = listOf("dislikes", "unlikes", "dislikes not", "disliking"),
            correctAnswer = "dislikes",
            explanation = "“Dislike” is the standard English antonym for “like”."
        ),
        // ========================================================
        // 🟦 UNIT 3 – JAMAICAN FRAGMENT & POEM – NO MEN ARE FOREIGN (ADDITIONAL MCQs)
        // ========================================================
        QuestionModel(
            id = "s_8_eng_184",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "In “The man watched the boys playing”, the word “playing” functions as a:",
            options = listOf("Noun", "Verb", "Adjective", "Adverb"),
            correctAnswer = "Verb",
            explanation = "“Playing” is the non-finite participial verb describing what the boys were doing."
        ),
        QuestionModel(
            id = "s_8_eng_185",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Fill in the blanks with appropriate articles: “He wants to buy ___ car in ___ market.”",
            options = listOf("a, the", "an, a", "the, the", "an, the"),
            correctAnswer = "a, the",
            explanation = "“A car” refers to any vehicle, while “the market” refers to the specific local marketplace."
        ),
        QuestionModel(
            id = "s_8_eng_186",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Insert appropriate articles: “She is ___ honest girl in ___ whole class.”",
            options = listOf("a, an", "an, the", "the, a", "a, the"),
            correctAnswer = "an, the",
            explanation = "“An honest” takes “an” due to the silent “h”; “the whole class” takes “the”."
        ),
        QuestionModel(
            id = "s_8_eng_187",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Fill in the blank with the suitable article: “He walked down ___ road near Kingston.”",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "the",
            explanation = "The specific road near Kingston requires the definite article “the”."
        ),
        QuestionModel(
            id = "s_8_eng_188",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Select the correct homophone: “She wore a beautiful ___ dress.”",
            options = listOf("blue", "blew", "blow", "below"),
            correctAnswer = "blue",
            explanation = "“Blue” refers to the color; “blew” is the past tense of “blow”."
        ),
        QuestionModel(
            id = "s_8_eng_189",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Choose the appropriate homophone: “I can’t ___ what you are saying.”",
            options = listOf("here", "hear", "hair", "hare"),
            correctAnswer = "hear",
            explanation = "“Hear” means to perceive sound with ears; “here” indicates a location."
        ),
        QuestionModel(
            id = "s_8_eng_190",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Complete with the correct homophone: “Please come and sit over ___.”",
            options = listOf("hear", "here", "hair", "hare"),
            correctAnswer = "here",
            explanation = "“Here” indicates this place or position."
        ),
        QuestionModel(
            id = "s_8_eng_191",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Choose the correct homophone: “He ate the whole ___ of bread.”",
            options = listOf("peace", "piece", "peas", "pease"),
            correctAnswer = "piece",
            explanation = "A “piece” is a slice or portion; “peace” means tranquility and absence of war."
        ),
        QuestionModel(
            id = "s_8_eng_192",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Choose the proper homophone: “The brave knight rode his horse at ___.”",
            options = listOf("night", "knight", "neat", "light"),
            correctAnswer = "night",
            explanation = "“Night” is the period of darkness between sunset and sunrise."
        ),
        QuestionModel(
            id = "s_8_eng_193",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The antonym of “polite” formed with a prefix is:",
            options = listOf("impossible", "impolite", "unpolite", "dispolite"),
            correctAnswer = "impolite",
            explanation = "The prefix “im-” attaches to words beginning with “p”, yielding “impolite”."
        ),
        QuestionModel(
            id = "s_8_eng_194",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The antonym of “legible” formed with a prefix is:",
            options = listOf("illegible", "unlegible", "dislegible", "mislegible"),
            correctAnswer = "illegible",
            explanation = "The assimilation prefix “il-” attaches to roots starting with “l”, producing “illegible”."
        ),
        QuestionModel(
            id = "s_8_eng_195",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The antonym of “honest” formed with a prefix is:",
            options = listOf("dishonest", "inhonest", "unhonest", "dishonesty"),
            correctAnswer = "dishonest",
            explanation = "The prefix “dis-” attaches to “honest” to form “dishonest”."
        ),
        QuestionModel(
            id = "s_8_eng_196",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "In “No Men Are Foreign”, the poet James Kirkup emphasizes:",
            options = listOf("unity, peace and universal brotherhood", "hatred towards neighboring countries", "importance of fighting wars", "national separation"),
            correctAnswer = "unity, peace and universal brotherhood",
            explanation = "The poem preaches universal human brotherhood and peace across all political boundaries."
        ),
        QuestionModel(
            id = "s_8_eng_197",
            stdId = 8,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "In “No Men Are Foreign”, sun, air, and water are mentioned to show that:",
            options = listOf("nature treats all humans equally", "only rich nations own nature", "soldiers have exclusive rights to water", "people belong to different worlds"),
            correctAnswer = "nature treats all humans equally",
            explanation = "Nature provides sunshine, fresh air, and life-giving water equally to all human beings."
        ),
        // ========================================================
        // 🟦 UNIT 4 – THE BOY WHO ASKED FOR MORE & POEM – FOR A FIVE YEAR OLD (ADDITIONAL MCQs)
        // ========================================================
        QuestionModel(
            id = "s_8_eng_198",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In “The boy ran quickly”, the word “quickly” is an:",
            options = listOf("Noun", "Adverb", "Verb", "Pronoun"),
            correctAnswer = "Adverb",
            explanation = "“Quickly” modifies the verb “ran” by telling how he ran."
        ),
        QuestionModel(
            id = "s_8_eng_199",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In “Oliver was hungry”, the word “Oliver” is a:",
            options = listOf("Proper Noun", "Verb", "Adjective", "Adverb"),
            correctAnswer = "Proper Noun",
            explanation = "“Oliver” is the specific name of an individual, making it a proper noun."
        ),
        QuestionModel(
            id = "s_8_eng_200",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In “Oliver asked for more”, the word “asked” is a:",
            options = listOf("Noun", "Verb", "Adjective", "Pronoun"),
            correctAnswer = "Verb",
            explanation = "“Asked” expresses the action done by Oliver in the simple past tense."
        ),
        QuestionModel(
            id = "s_8_eng_201",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In “He asked for more food”, the word “He” is a:",
            options = listOf("Noun", "Pronoun", "Verb", "Adjective"),
            correctAnswer = "Pronoun",
            explanation = "“He” substitutes for the noun “Oliver”, functioning as a subject pronoun."
        ),
        QuestionModel(
            id = "s_8_eng_202",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In “Oliver was a hungry boy”, the word “hungry” is an:",
            options = listOf("Adjective", "Noun", "Verb", "Adverb"),
            correctAnswer = "Adjective",
            explanation = "“Hungry” describes the physical condition of the noun “boy”."
        ),
        QuestionModel(
            id = "s_8_eng_203",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Choose the correct preposition: “The boys gathered ___ the entrance hall.”",
            options = listOf("at", "on", "from", "with"),
            correctAnswer = "at",
            explanation = "“At” denotes a specific point or location in space."
        ),
        QuestionModel(
            id = "s_8_eng_204",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Choose the appropriate conjunction: “He worked hard ___ passed the examination.”",
            options = listOf("and", "on", "under", "quickly"),
            correctAnswer = "and",
            explanation = "“And” connects two coordinate clauses of equal grammatical rank."
        ),
        QuestionModel(
            id = "s_8_eng_205",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The opposite of “rich” is:",
            options = listOf("poor", "happy", "strong", "beautiful"),
            correctAnswer = "poor",
            explanation = "“Poor” is the standard antonym of “rich”."
        ),
        QuestionModel(
            id = "s_8_eng_206",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The opposite of “good” is:",
            options = listOf("bad", "kind", "nice", "fine"),
            correctAnswer = "bad",
            explanation = "“Bad” is the opposite of “good”."
        ),
        QuestionModel(
            id = "s_8_eng_207",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The opposite of “strong” is:",
            options = listOf("powerful", "weak", "brave", "bold"),
            correctAnswer = "weak",
            explanation = "“Weak” is the opposite of “strong”."
        ),
        QuestionModel(
            id = "s_8_eng_208",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The opposite of “beautiful” is:",
            options = listOf("ugly", "pretty", "lovely", "attractive"),
            correctAnswer = "ugly",
            explanation = "“Ugly” is the opposite of “beautiful”."
        ),
        QuestionModel(
            id = "s_8_eng_209",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Frame a ‘Wh-’ question to get the underlined phrase: “The briefcase was stolen <u>at the railway station</u>.”",
            options = listOf("Where was the briefcase stolen?", "When was the briefcase stolen?", "Why was the briefcase stolen?", "Who stole the briefcase?"),
            correctAnswer = "Where was the briefcase stolen?",
            explanation = "Since the underlined phrase denotes a place, the question word is “Where”."
        ),
        QuestionModel(
            id = "s_8_eng_210",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Frame a ‘Wh-’ question to get the underlined word: “<u>The servant</u> let out the secret.”",
            options = listOf("Who let out the secret?", "What let out the secret?", "When did the servant leave?", "Where was the secret kept?"),
            correctAnswer = "Who let out the secret?",
            explanation = "Since the subject is a person, the question word “Who” is used."
        ),
        QuestionModel(
            id = "s_8_eng_211",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The negative prefix in the word “unhappy” is:",
            options = listOf("re-", "un-", "dis-", "im-"),
            correctAnswer = "un-",
            explanation = "The prefix “un-” imparts negative meaning to “happy”."
        ),
        QuestionModel(
            id = "s_8_eng_212",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The correct antonym of “fair” formed with a prefix is:",
            options = listOf("unfair", "disfair", "infair", "refair"),
            correctAnswer = "unfair",
            explanation = "“Unfair” is formed by attaching the prefix “un-” to “fair”."
        ),
        QuestionModel(
            id = "s_8_eng_213",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Adding a prefix to “structure” to mean rebuilding or organizing again gives:",
            options = listOf("restructure", "unstructure", "disstructure", "imstructure"),
            correctAnswer = "restructure",
            explanation = "The prefix “re-” means again, forming “restructure”."
        ),
        QuestionModel(
            id = "s_8_eng_214",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The noun form derived from the verb “invent” is:",
            options = listOf("invention", "inventive", "inventing", "inventorly"),
            correctAnswer = "invention",
            explanation = "The suffix “-ion” converts the verb “invent” into the noun “invention”."
        ),
        QuestionModel(
            id = "s_8_eng_215",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The noun form of the verb “grow” is:",
            options = listOf("growth", "growing", "grower", "grown"),
            correctAnswer = "growth",
            explanation = "“Growth” is the standard noun form of “grow”."
        ),
        QuestionModel(
            id = "s_8_eng_216",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In “Oliver Twist”, what reward was offered to anyone taking Oliver off the parish hands?",
            options = listOf("one pound", "five pounds", "ten pounds", "fifty pounds"),
            correctAnswer = "five pounds",
            explanation = "The workhouse board offered a five-pound (£5) reward on the gate for anyone taking Oliver."
        ),
        QuestionModel(
            id = "s_8_eng_217",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The poem “For a Five Year Old” by Fleur Adcock focuses on:",
            options = listOf("the contradiction between what adults preach and what they practice", "how children learn to read quickly", "games played in schools", "training pets at home"),
            correctAnswer = "the contradiction between what adults preach and what they practice",
            explanation = "The mother gently teaches her child not to hurt snails while recognizing adult hypocrisy."
        ),
        QuestionModel(
            id = "s_8_eng_218",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In “For a Five Year Old”, what small creature does the child rescue?",
            options = listOf("a snail", "a honeybee", "a butterfly", "a kitten"),
            correctAnswer = "a snail",
            explanation = "The child carefully carries a snail out into the garden after being told not to harm living things."
        ),
        QuestionModel(
            id = "s_8_eng_219",
            stdId = 8,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The poem “For a Five Year Old” subtly criticizes:",
            options = listOf("adult hypocrisy and contradictions", "childhood innocence", "protecting gardens", "school rules"),
            correctAnswer = "adult hypocrisy and contradictions",
            explanation = "The poet reflects on how adults preach gentleness to children while engaging in deception."
        ),
        // ========================================================
        // 🟦 UNIT 5 – THE SWAN AND THE PRINCESS & POEM – SOMEBODY’S MOTHER (ADDITIONAL MCQs)
        // ========================================================
        QuestionModel(
            id = "s_8_eng_220",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The correct suffix to turn “help” into an adjective meaning giving assistance is:",
            options = listOf("-ful", "-less", "-ment", "-tion"),
            correctAnswer = "-ful",
            explanation = "Adding “-ful” yields “helpful”."
        ),
        QuestionModel(
            id = "s_8_eng_221",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The adjective formed by adding a suffix to “care” is:",
            options = listOf("careful", "careness", "carement", "caretion"),
            correctAnswer = "careful",
            explanation = "“Care” + “-ful” = “careful”."
        ),
        QuestionModel(
            id = "s_8_eng_222",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Identify the correctly spelled word:",
            options = listOf("recieve", "receive", "receeve", "receve"),
            correctAnswer = "receive",
            explanation = "The spelling rule “i before e except after c” gives “receive”."
        ),
        QuestionModel(
            id = "s_8_eng_223",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Choose the correct spelling:",
            options = listOf("beautifull", "beautiful", "beautifal", "beutiful"),
            correctAnswer = "beautiful",
            explanation = "The adjective “beautiful” ends with a single “l”."
        ),
        QuestionModel(
            id = "s_8_eng_224",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Choose the correctly spelled word:",
            options = listOf("begining", "beggining", "beginning", "beginnning"),
            correctAnswer = "beginning",
            explanation = "The consonant “n” doubles before the suffix: “beginning”."
        ),
        QuestionModel(
            id = "s_8_eng_225",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The antonym of “agreement” is:",
            options = listOf("disagreement", "development", "reinvestment", "treatment"),
            correctAnswer = "disagreement",
            explanation = "Prefixing “dis-” to “agreement” yields “disagreement”."
        ),
        QuestionModel(
            id = "s_8_eng_226",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The prefix in the word “reinvest” is:",
            options = listOf("re-", "dis-", "im-", "un-"),
            correctAnswer = "re-",
            explanation = "“Re-” means again or anew in “reinvest”."
        ),
        QuestionModel(
            id = "s_8_eng_227",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The phrase “ill-treated” means:",
            options = listOf("treated badly and cruelly", "treated with great care", "given expensive medicine", "praised warmly"),
            correctAnswer = "treated badly and cruelly",
            explanation = "“Ill-treated” means subjected to cruel, abusive, or neglectful treatment."
        ),
        QuestionModel(
            id = "s_8_eng_228",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Complete with the appropriate preposition: “The book is lying ___ the study table.”",
            options = listOf("on", "from", "at", "far"),
            correctAnswer = "on",
            explanation = "“On” is used when an object rests upon a flat surface."
        ),
        QuestionModel(
            id = "s_8_eng_229",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Fill in the blank: “The frightened bird flew ___ Prince Siddhartha.”",
            options = listOf("on", "in", "to", "from"),
            correctAnswer = "to",
            explanation = "“To” indicates direction towards Prince Siddhartha."
        ),
        QuestionModel(
            id = "s_8_eng_230",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Choose the correct preposition: “Mysuru is famous ___ its grand Dasara festival.”",
            options = listOf("about", "of", "on", "for"),
            correctAnswer = "for",
            explanation = "The adjective “famous” is followed by the preposition “for”."
        ),
        QuestionModel(
            id = "s_8_eng_231",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Complete the sentence: “The online test is scheduled ___ 10:00 AM.”",
            options = listOf("at", "in", "on", "from"),
            correctAnswer = "at",
            explanation = "“At” is the correct preposition of time for precise clock hours."
        ),
        QuestionModel(
            id = "s_8_eng_232",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Which is the correct passive voice of: “Siddhartha nursed the swan back to health”?",
            options = listOf("The swan was nursed back to health by Siddhartha.", "Siddhartha was nursed by the swan.", "The swan nursed Siddhartha.", "The swan is nurse by Siddhartha."),
            correctAnswer = "The swan was nursed back to health by Siddhartha.",
            explanation = "In passive voice, the object “The swan” becomes subject with “was nursed by Siddhartha”."
        ),
        QuestionModel(
            id = "s_8_eng_233",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "In the play “The Swan and the Princes”, Siddhartha is portrayed as:",
            options = listOf("cruel and indifferent", "kind, gentle and compassionate", "selfish and arrogant", "greedy for power"),
            correctAnswer = "kind, gentle and compassionate",
            explanation = "Prince Siddhartha values all living beings and tenderly nurses the wounded bird."
        ),
        QuestionModel(
            id = "s_8_eng_234",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "In contrast to Siddhartha, Devadatta is portrayed as:",
            options = listOf("compassionate and patient", "cruel, selfish and aggressive", "peaceful and humble", "generous to animals"),
            correctAnswer = "cruel, selfish and aggressive",
            explanation = "Devadatta shot the bird for sport and demanded it as his property."
        ),
        QuestionModel(
            id = "s_8_eng_235",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "How did the swan itself show who it belonged to?",
            options = listOf("It flew away into the forest", "It approached Siddhartha and sheltered trustingly in his arms", "It attacked Devadatta", "It hid under the king’s throne"),
            correctAnswer = "It approached Siddhartha and sheltered trustingly in his arms",
            explanation = "When placed between the princes, the bird shrank from Devadatta and trustingly sheltered in Siddhartha’s arms."
        ),
        QuestionModel(
            id = "s_8_eng_236",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "In “She finished her project quickly”, the word “quickly” is an:",
            options = listOf("adjective", "adverb", "verb", "noun"),
            correctAnswer = "adverb",
            explanation = "“Quickly” describes the manner of completing the project, modifying the verb."
        ),
        QuestionModel(
            id = "s_8_eng_237",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "In “Oh! That looks wonderful”, the word “Oh!” is an:",
            options = listOf("interjection", "conjunction", "preposition", "article"),
            correctAnswer = "interjection",
            explanation = "“Oh!” expresses sudden emotion or surprise, functioning as an interjection."
        ),
        QuestionModel(
            id = "s_8_eng_238",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "In “The key on the shelf”, the word “on” is a:",
            options = listOf("preposition", "conjunction", "adverb", "article"),
            correctAnswer = "preposition",
            explanation = "“On” expresses spatial relation between key and shelf, acting as a preposition."
        ),
        QuestionModel(
            id = "s_8_eng_239",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The inspiring poem “Somebody’s Mother” was composed by:",
            options = listOf("Mary Dow Brine", "Sarojini Naidu", "Emily Dickinson", "Toru Dutt"),
            correctAnswer = "Mary Dow Brine",
            explanation = "American poet Mary Dow Brine authored “Somebody’s Mother”."
        ),
        QuestionModel(
            id = "s_8_eng_240",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "In “Somebody’s Mother”, the old woman standing at the crossing was:",
            options = listOf("young and hurried", "old, ragged and trembling with age", "wealthy and proud", "angry with the children"),
            correctAnswer = "old, ragged and trembling with age",
            explanation = "The poem describes her as “old and ragged and gray, and bent with the chill of the winter’s day”."
        ),
        QuestionModel(
            id = "s_8_eng_241",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The kind-hearted schoolboy helped the elderly woman to:",
            options = listOf("cross the busy and slippery street safely", "carry her heavy shopping cart home", "find her lost glasses", "reach the railway station"),
            correctAnswer = "cross the busy and slippery street safely",
            explanation = "He guided her trembling steps across the crowded snow-covered road."
        ),
        QuestionModel(
            id = "s_8_eng_242",
            stdId = 8,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "The core moral message of “Somebody’s Mother” is:",
            options = listOf("self-interest and personal gain", "empathy, kindness and respect towards the elderly", "disregarding strangers", "fear of icy weather"),
            correctAnswer = "empathy, kindness and respect towards the elderly",
            explanation = "The poem teaches that every elderly person deserves respect and compassionate assistance."
        ),
        // ========================================================
        // 🟦 UNIT 6 – ALL THE WORLD HER STAGE (ADDITIONAL MCQs)
        // ========================================================
        QuestionModel(
            id = "s_8_eng_243",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The synonym of “plump” is:",
            options = listOf("fat and rounded", "thin and tall", "weak and frail", "long and narrow"),
            correctAnswer = "fat and rounded",
            explanation = "“Plump” means pleasantly fat, chubby, or rounded."
        ),
        QuestionModel(
            id = "s_8_eng_244",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The synonym of “arrived” is:",
            options = listOf("reached or appeared", "departed", "vanished", "delayed"),
            correctAnswer = "reached or appeared",
            explanation = "“Arrived” means reached the destination or appeared on the scene."
        ),
        QuestionModel(
            id = "s_8_eng_245",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The word “grimly” means:",
            options = listOf("seriously and sternly", "happily and joyfully", "carelessly", "playfully"),
            correctAnswer = "seriously and sternly",
            explanation = "“Grimly” conveys seriousness, sternness, or determined resolve."
        ),
        QuestionModel(
            id = "s_8_eng_246",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What is the simple past tense of the verb “speak”?",
            options = listOf("speaks", "spoke", "spoken", "speaking"),
            correctAnswer = "spoke",
            explanation = "The irregular past tense form of “speak” is “spoke”."
        ),
        QuestionModel(
            id = "s_8_eng_247",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What is the past tense of the verb “step”?",
            options = listOf("stepping", "stepped", "steps", "steped"),
            correctAnswer = "stepped",
            explanation = "The final consonant “p” doubles before “-ed”, yielding “stepped”."
        ),
        QuestionModel(
            id = "s_8_eng_248",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What is the past tense of “complete”?",
            options = listOf("completing", "completed", "completes", "completion"),
            correctAnswer = "completed",
            explanation = "“Completed” is the past tense of “complete”."
        ),
        QuestionModel(
            id = "s_8_eng_249",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The comparative degree of the adjective “fast” is:",
            options = listOf("fastest", "faster", "more fast", "most fast"),
            correctAnswer = "faster",
            explanation = "One-syllable adjectives take “-er” to form the comparative: “faster”."
        ),
        QuestionModel(
            id = "s_8_eng_250",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The comparative degree of the adjective “clever” is:",
            options = listOf("cleverest", "cleverer", "more cleverest", "most clever"),
            correctAnswer = "cleverer",
            explanation = "“Cleverer” is the standard comparative degree of “clever”."
        ),
        QuestionModel(
            id = "s_8_eng_251",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The comparative degree of the adjective “wide” is:",
            options = listOf("widest", "wider", "more wide", "most wide"),
            correctAnswer = "wider",
            explanation = "“Wide” takes “-r” in the comparative form: “wider”."
        ),
        QuestionModel(
            id = "s_8_eng_252",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Fill in the blank with the correct article: “Dr. Abdul Kalam was ___ honest and humble leader.”",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "an",
            explanation = "“Honest” begins with a vowel sound (/ɒ/), requiring the indefinite article “an”."
        ),
        QuestionModel(
            id = "s_8_eng_253",
            stdId = 8,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "An expression asking someone courteously to do something is classified as a:",
            options = listOf("request", "command", "threat", "warning"),
            correctAnswer = "request",
            explanation = "A polite appeal starting with “Please” or “Could you” is a request."
        ),
        // ========================================================
        // 🟦 UNIT 7 – THE EMPEROR’S NEW CLOTHES & POEM – MACHINE (ADDITIONAL MCQs)
        // ========================================================
        QuestionModel(
            id = "s_8_eng_254",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The vain Emperor in Andersen’s tale was passionately fond of:",
            options = listOf("books and libraries", "new clothes and garments", "war and weapons", "hunting wild animals"),
            correctAnswer = "new clothes and garments",
            explanation = "The Emperor spent all his revenue on splendid new clothes for every hour of the day."
        ),
        QuestionModel(
            id = "s_8_eng_255",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The Emperor feared that admitting he could not see the cloth would prove he was:",
            options = listOf("poor and powerless", "unfit for his high office or stupid", "too kind to his subjects", "afraid of foreign kings"),
            correctAnswer = "unfit for his high office or stupid",
            explanation = "The swindlers claimed the invisible cloth could only be unseen by the foolish or incompetent."
        ),
        QuestionModel(
            id = "s_8_eng_256",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "During the grand royal procession, who revealed the truth about the Emperor’s clothes?",
            options = listOf("A wise old minister", "An innocent little child", "The queen", "A foreign ambassador"),
            correctAnswer = "An innocent little child",
            explanation = "A child cried out, “But he has nothing on at all!”, breaking the collective illusion."
        ),
        QuestionModel(
            id = "s_8_eng_257",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The Emperor’s most serious character flaw was his:",
            options = listOf("vanity and foolish pride", "extreme greed for money", "cruelty to animals", "laziness in eating"),
            correctAnswer = "vanity and foolish pride",
            explanation = "His vanity blinded him to the obvious deception."
        ),
        QuestionModel(
            id = "s_8_eng_258",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The underlying moral of “The Emperor’s New Clothes” is to value:",
            options = listOf("flattery and outward show", "truth, honesty and courage to speak out", "blind conformity", "fine garments"),
            correctAnswer = "truth, honesty and courage to speak out",
            explanation = "The story champions honesty, critical thinking, and the courage to call out false pretensions."
        ),
        QuestionModel(
            id = "s_8_eng_259",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Frame a ‘Wh-’ question to get the underlined object: “Rama eats <u>a fresh banana</u> every morning.”",
            options = listOf("What does Rama eat every morning?", "Where does Rama eat every morning?", "How does Rama eat every morning?", "When does Rama eat every morning?"),
            correctAnswer = "What does Rama eat every morning?",
            explanation = "Since the underlined noun is a thing, the question begins with “What”."
        ),
        QuestionModel(
            id = "s_8_eng_260",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "In Rudyard Kipling’s poem “The Secret of the Machines”, the machines declare they are children of:",
            options = listOf("the sea and wind", "the human brain", "the deep forests", "the golden sun"),
            correctAnswer = "the human brain",
            explanation = "The poem states: “remember, please, our Law: we are nothing more than children of your brain!”."
        ),
        QuestionModel(
            id = "s_8_eng_261",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The machines admit that they have no capacity to understand:",
            options = listOf("mathematical numbers", "human lies or feelings of love and pity", "iron and steel", "steam and electric power"),
            correctAnswer = "human lies or feelings of love and pity",
            explanation = "“We can neither love nor pity nor forgive. If you make a slip in handling us you die!”."
        ),
        QuestionModel(
            id = "s_8_eng_262",
            stdId = 8,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The poet advises humans to use machinery:",
            options = listOf("blindly and carelessly", "wisely and with great caution", "without any safety rules", "to replace human beings entirely"),
            correctAnswer = "wisely and with great caution",
            explanation = "Because machines lack human empathy or forgiveness, they must be controlled with wisdom."
        ),
        // ========================================================
        // 🟦 UNIT 8 – LUTHER BURBANK & POEM – AXE IN THE WOOD (ADDITIONAL MCQs)
        // ========================================================
        QuestionModel(
            id = "s_8_eng_263",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Choose the appropriate conjunction: “Rajesh is overjoyed ___ his mother bought him a new bicycle.”",
            options = listOf("and", "because", "but", "if"),
            correctAnswer = "because",
            explanation = "“Because” introduces the causal clause explaining why Rajesh is happy."
        ),
        QuestionModel(
            id = "s_8_eng_264",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Which word rhymes with “say”?",
            options = listOf("play", "fancy", "ready", "city"),
            correctAnswer = "play",
            explanation = "“Say” and “play” share the identical terminal diphthong sound /eɪ/."
        ),
        QuestionModel(
            id = "s_8_eng_265",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The synonym of “glory” is:",
            options = listOf("fame and honor", "darkness", "weakness", "sadness"),
            correctAnswer = "fame and honor",
            explanation = "“Glory” denotes renown, distinguished honor, and fame."
        ),
        QuestionModel(
            id = "s_8_eng_266",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Choose the correct question tag: “Luther Burbank is a famous American plant scientist, ___?”",
            options = listOf("is he", "isn’t he", "was he", "wasn’t he"),
            correctAnswer = "isn’t he",
            explanation = "A positive statement with the verb “is” takes the negative tag “isn’t he?”."
        ),
        QuestionModel(
            id = "s_8_eng_267",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Complete with the correct question tag: “Manasa was a talented singer, ___?”",
            options = listOf("was she", "is she", "wasn’t she", "isn’t she"),
            correctAnswer = "wasn’t she",
            explanation = "The positive past tense “was” requires the negative tag “wasn’t she?”."
        ),
        QuestionModel(
            id = "s_8_eng_268",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Add the proper question tag: “Ravi comes to school regularly, ___?”",
            options = listOf("is he", "doesn’t he", "does he", "isn’t he"),
            correctAnswer = "doesn’t he",
            explanation = "Present simple third-person “comes” takes the auxiliary tag “doesn’t he?”."
        ),
        QuestionModel(
            id = "s_8_eng_269",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Choose the appropriate question tag: “They played exciting games yesterday, ___?”",
            options = listOf("do they", "does they", "didn’t they", "didn’t them"),
            correctAnswer = "didn’t they",
            explanation = "Past simple positive “played” takes the negative past tag “didn’t they?”."
        ),
        QuestionModel(
            id = "s_8_eng_270",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Identify the infinitive verb in: “Don’t forget to bring your colors to class.”",
            options = listOf("forget", "don’t", "to bring", "colors"),
            correctAnswer = "to bring",
            explanation = "“To” followed by the base verb (“to bring”) is an infinitive."
        ),
        QuestionModel(
            id = "s_8_eng_271",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Identify the infinitive in: “I went to the city to buy a new computer.”",
            options = listOf("went", "to the city", "to buy", "computer"),
            correctAnswer = "to buy",
            explanation = "“To buy” expresses the purpose infinitive."
        ),
        QuestionModel(
            id = "s_8_eng_272",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Which of the following words has exactly two syllables?",
            options = listOf("park", "pencil", "television", "car"),
            correctAnswer = "pencil",
            explanation = "“Pencil” has two syllables (pen-cil), while “park” and “car” have one."
        ),
        QuestionModel(
            id = "s_8_eng_273",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Which of the following words is monosyllabic (has only one syllable)?",
            options = listOf("school", "direction", "clatter", "doctor"),
            correctAnswer = "school",
            explanation = "“School” is pronounced with a single vowel sound /uː/."
        ),
        QuestionModel(
            id = "s_8_eng_274",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Which word consists of three syllables?",
            options = listOf("manager", "television", "kilo", "milk"),
            correctAnswer = "manager",
            explanation = "“Manager” has three syllables: man-a-ger."
        ),
        QuestionModel(
            id = "s_8_eng_275",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Which word consists of four syllables?",
            options = listOf("table", "television", "garden", "boy"),
            correctAnswer = "television",
            explanation = "“Television” has four distinct syllables: tel-e-vi-sion."
        ),
        QuestionModel(
            id = "s_8_eng_276",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The adjective “rich” commonly collocates with:",
            options = listOf("community", "pencil", "desk", "road"),
            correctAnswer = "community",
            explanation = "“Rich community” or “rich heritage” is a recognized natural collocation."
        ),
        QuestionModel(
            id = "s_8_eng_277",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The adjective “sweet” frequently collocates with:",
            options = listOf("memory", "road", "desk", "stone"),
            correctAnswer = "memory",
            explanation = "“Sweet memory” is a common idiomatic collocated phrase."
        ),
        QuestionModel(
            id = "s_8_eng_278",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The noun “street” collocates naturally with:",
            options = listOf("light", "air", "load", "fruit"),
            correctAnswer = "light",
            explanation = "“Street light” is a standard compound noun collocation."
        ),
        QuestionModel(
            id = "s_8_eng_279",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The adjective “heavy” frequently collocates with:",
            options = listOf("load", "memory", "community", "house"),
            correctAnswer = "load",
            explanation = "“Heavy load” or “heavy rain” is a standard collocated phrase."
        ),
        QuestionModel(
            id = "s_8_eng_280",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Which word has the identical vowel sound to “so” /oʊ/?",
            options = listOf("say", "cook", "toe", "ear"),
            correctAnswer = "toe",
            explanation = "“So” and “toe” share the identical long “o” vowel sound /oʊ/."
        ),
        QuestionModel(
            id = "s_8_eng_281",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Which word has the same vowel diphthong sound as “now” /aʊ/?",
            options = listOf("sure", "door", "house", "for"),
            correctAnswer = "house",
            explanation = "“Now” and “house” share the /aʊ/ sound."
        ),
        QuestionModel(
            id = "s_8_eng_282",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Fill in the blank: “Mr. Rajesh is ___ experienced electrical engineer.”",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "an",
            explanation = "“Experienced” begins with a vowel sound, taking the indefinite article “an”."
        ),
        QuestionModel(
            id = "s_8_eng_283",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Select the correct article usage: “Rani was ___ unemployed for two months.”",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "no article",
            explanation = "“Unemployed” is a predicate adjective; without an accompanying noun, no article is used."
        ),
        QuestionModel(
            id = "s_8_eng_284",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Fill in the blank: “He completed his graduation in ___ university in Bengaluru.”",
            options = listOf("a", "an", "the", "no article"),
            correctAnswer = "a",
            explanation = "The word “university” starts with the consonant glide sound /j/ (“yoo”), requiring “a”."
        ),
        QuestionModel(
            id = "s_8_eng_285",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Complete with appropriate articles: “___ earth moves round ___ sun.”",
            options = listOf("A, a", "An, an", "The, the", "The, a"),
            correctAnswer = "The, the",
            explanation = "Unique celestial bodies require the definite article “the” (“The earth”, “the sun”)."
        ),
        QuestionModel(
            id = "s_8_eng_286",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Fill in the prepositions: “Luther Burbank was born ___ March 7th, 1849 ___ Massachusetts.”",
            options = listOf("on, in", "in, on", "at, in", "on, at"),
            correctAnswer = "on, in",
            explanation = "Dates take “on” (“on March 7th”), while states take “in” (“in Massachusetts”)."
        ),
        QuestionModel(
            id = "s_8_eng_287",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Complete the sentence: “He put the notebook ___ his school bag.”",
            options = listOf("on", "in", "at", "from"),
            correctAnswer = "in",
            explanation = "“In” indicates position or motion inside an enclosed space."
        ),
        QuestionModel(
            id = "s_8_eng_288",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Fill in the prepositions: “He is waiting ___ you ___ the bus stop.”",
            options = listOf("for, at", "at, for", "in, on", "from, at"),
            correctAnswer = "for, at",
            explanation = "We wait “for” someone “at” a specific location."
        ),
        QuestionModel(
            id = "s_8_eng_289",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Complete the sentence: “They borrowed a dictionary ___ the library.”",
            options = listOf("from the", "on the", "at the", "into the"),
            correctAnswer = "from the",
            explanation = "To borrow something “from the library” is the standard prepositional phrase."
        ),
        QuestionModel(
            id = "s_8_eng_290",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The term “livestock” refers to:",
            options = listOf("domestic farm animals", "wild forest beasts", "wooden furniture", "metal tools"),
            correctAnswer = "domestic farm animals",
            explanation = "“Livestock” designates domestic farm animals such as cattle, sheep, and horses."
        ),
        QuestionModel(
            id = "s_8_eng_291",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The phrasal verb “bring up” means:",
            options = listOf("to raise and educate children", "to fall down suddenly", "to shine brightly", "to fall asleep"),
            correctAnswer = "to raise and educate children",
            explanation = "“Bring up” means to rear, nurture, or educate children from infancy."
        ),
        QuestionModel(
            id = "s_8_eng_292",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "In plant biology, the adjective “hardy” describes a plant that is:",
            options = listOf("tough, robust and able to survive harsh conditions", "weak and frail", "short-lived", "toxic and poisonous"),
            correctAnswer = "tough, robust and able to survive harsh conditions",
            explanation = "“Hardy” plants can endure frost, drought, and difficult climatic conditions."
        ),
        QuestionModel(
            id = "s_8_eng_293",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The word “delighted” means:",
            options = listOf("feeling immense happiness and pleasure", "feeling angry", "feeling exhausted", "feeling frightened"),
            correctAnswer = "feeling immense happiness and pleasure",
            explanation = "“Delighted” expresses high satisfaction and joy."
        ),
        QuestionModel(
            id = "s_8_eng_294",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What innovative scientific methods did Luther Burbank employ?",
            options = listOf("grafting, hybridization and selective breeding", "oil painting and singing", "deep coal mining and drilling", "printing and typography"),
            correctAnswer = "grafting, hybridization and selective breeding",
            explanation = "Burbank revolutionized horticulture by combining cross-pollination, hybridization, and selective grafting."
        ),
        QuestionModel(
            id = "s_8_eng_295",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Why did Burbank graft multiple varieties of apples onto a single tree?",
            options = listOf("To save nursery space and speed up fruit observation", "To decorate his garden for festivals", "To stop plant growth permanently", "To sell the tree as timber"),
            correctAnswer = "To save nursery space and speed up fruit observation",
            explanation = "Grafting numerous seedlings onto one mature stock allowed him to test hundreds of varieties in limited space rapidly."
        ),
        QuestionModel(
            id = "s_8_eng_296",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "In the poem “The Axe in the Wood”, what tool is used to fell the tree?",
            options = listOf("an axe", "a handsaw", "a mechanical drill", "a curved knife"),
            correctAnswer = "an axe",
            explanation = "Clifford Dyment depicts a woodman wielding an axe against the ancient tree."
        ),
        QuestionModel(
            id = "s_8_eng_297",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The majestic tree chopped down in the poem had stood for:",
            options = listOf("two weeks", "many centuries (hundreds of years)", "two days", "only one season"),
            correctAnswer = "many centuries (hundreds of years)",
            explanation = "The tree took centuries to grow into a stately giant, yet was felled in a few minutes."
        ),
        QuestionModel(
            id = "s_8_eng_298",
            stdId = 8,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "The onlookers watching the woodman chop down the ancient tree showed:",
            options = listOf("casual curiosity or indifferent amusement", "deep grief and tears", "active resistance", "fear for their lives"),
            correctAnswer = "casual curiosity or indifferent amusement",
            explanation = "Passers-by watched casually without recognizing the irreversible loss to nature."
        ),
        // ========================================================
        // 🟦 SUPPLEMENTARY READINGS 1 TO 4 (ADDITIONAL MCQs)
        // ========================================================
        QuestionModel(
            id = "s_8_eng_299",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "October 2nd is uniquely celebrated in India as the birth anniversary of:",
            options = listOf("Mahatma Gandhi and Lal Bahadur Shastri", "Jawaharlal Nehru and Subhas Chandra Bose", "Dr. B. R. Ambedkar and Sardar Patel", "Bhagat Singh and Chandrashekhar Azad"),
            correctAnswer = "Mahatma Gandhi and Lal Bahadur Shastri",
            explanation = "Both Mahatma Gandhi (1869) and Lal Bahadur Shastri (1904) share October 2nd as their birthday."
        ),
        QuestionModel(
            id = "s_8_eng_300",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Where did Lal Bahadur Shastri pursue his higher education?",
            options = listOf("Kashi Vidyapeetha", "Shantiniketan", "Oxford University", "Presidency College"),
            correctAnswer = "Kashi Vidyapeetha",
            explanation = "He graduated from Kashi Vidyapeetha in Varanasi, which conferred upon him the title “Shastri”."
        ),
        QuestionModel(
            id = "s_8_eng_301",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "During his student days in Varanasi, why did Shastri walk eight miles daily?",
            options = listOf("His impoverished family could not afford a bicycle or boat fare", "He was training as an athlete", "He disliked vehicles", "No roads existed in Varanasi"),
            correctAnswer = "His impoverished family could not afford a bicycle or boat fare",
            explanation = "Coming from a poor family, Shastri could not afford a bicycle and frequently walked miles or swam across the Ganga."
        ),
        QuestionModel(
            id = "s_8_eng_302",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Lal Bahadur Shastri resigned as Union Railway Minister following:",
            options = listOf("the Ariyalur railway disaster", "a disagreement in Parliament", "a defeat in general elections", "a nationwide strike"),
            correctAnswer = "the Ariyalur railway disaster",
            explanation = "He set a rare democratic precedent by resigning as Railway Minister after the tragic Ariyalur train crash."
        ),
        QuestionModel(
            id = "s_8_eng_303",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Why did Shastri submit his resignation after the Ariyalur rail accident?",
            options = listOf("He accepted moral responsibility as the department minister", "He was personally responsible for track repair", "He wanted to leave public politics", "He faced a court summons"),
            correctAnswer = "He accepted moral responsibility as the department minister",
            explanation = "His resignation was an act of high moral integrity, accepting constitutional responsibility for the mishap."
        ),
        QuestionModel(
            id = "s_8_eng_304",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "During the 1965 armed conflict with Pakistan, Prime Minister Shastri firmly declared that:",
            options = listOf("force will be met with force", "India would surrender immediately", "no military response would be made", "foreign armies should take over"),
            correctAnswer = "force will be met with force",
            explanation = "His resolute leadership rallied the nation under the inspiring slogan “Jai Jawan, Jai Kisan”."
        ),
        QuestionModel(
            id = "s_8_eng_305",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Lal Bahadur Shastri’s entire life was a shining example of:",
            options = listOf("simplicity, honesty, humility and high moral courage", "arrogance and extravagant wealth", "pride and ostentation", "carelessness and apathy"),
            correctAnswer = "simplicity, honesty, humility and high moral courage",
            explanation = "Shastri is revered across generations for his absolute honesty, simplicity, and dedication to the nation."
        ),
        QuestionModel(
            id = "s_8_eng_306",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "In the Jataka tale “The Lion and the Animals”, what caused the hare’s wild panic?",
            options = listOf("A heavy fruit fell on a dry leaf, making him think the earth was collapsing", "A real earthquake occurred", "A ferocious hunter entered the jungle", "A massive flood inundated the forest"),
            correctAnswer = "A heavy fruit fell on a dry leaf, making him think the earth was collapsing",
            explanation = "A ripe vilva/wood-apple fruit dropped behind him, triggering his irrational panic that the world was breaking up."
        ),
        QuestionModel(
            id = "s_8_eng_307",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Why was the lion praised as sensible and wise?",
            options = listOf("He investigated the facts at the tree rather than trusting rumors", "He ran away faster than the other animals", "He roared loudly to terrify everyone", "He caught and punished the hare immediately"),
            correctAnswer = "He investigated the facts at the tree rather than trusting rumors",
            explanation = "The lion took the hare back to the spot, discovered the fallen fruit, and calmed the panic through rational investigation."
        ),
        QuestionModel(
            id = "s_8_eng_308",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "The primary moral taught by “The Lion and the Animals” is to:",
            options = listOf("verify facts carefully and never accept rumors blindly", "spread alarm whenever you hear a sound", "follow the panicked crowd", "run away from every sudden noise"),
            correctAnswer = "verify facts carefully and never accept rumors blindly",
            explanation = "The fable illustrates that rumors must always be investigated before being believed."
        ),
        QuestionModel(
            id = "s_8_eng_309",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What heartwarming message is conveyed by Ruskin Bond’s “The Blue Umbrella”?",
            options = listOf("Kindness, selflessness, and the joy of sharing surpass material possessions", "Expensive umbrellas bring happiness", "Greed should be rewarded", "Jealousy is necessary to succeed"),
            correctAnswer = "Kindness, selflessness, and the joy of sharing surpass material possessions",
            explanation = "Little Binya freely gives her beloved umbrella to the remorseful shopkeeper Ram Bharosa, demonstrating empathy and forgiveness."
        ),
        QuestionModel(
            id = "s_8_eng_310",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Soviet cosmonaut Valentina Tereshkova created history on June 16, 1963 as:",
            options = listOf("the first woman to travel into outer space", "the first woman prime minister of Russia", "the first woman to climb Mount Everest", "the inventor of the spacecraft"),
            correctAnswer = "the first woman to travel into outer space",
            explanation = "Piloting Vostok 6, 26-year-old Valentina Tereshkova completed 48 orbits around the Earth, becoming the first woman in space."
        ),
        QuestionModel(
            id = "s_8_eng_311",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Why was Valentina’s early schooling not smooth and continuous?",
            options = listOf("Severe poverty and wartime hardships forced her to work in a factory", "She disliked school and books", "She was banned from studying", "She lived in foreign countries"),
            correctAnswer = "Severe poverty and wartime hardships forced her to work in a factory",
            explanation = "After losing her father in World War II, she worked in a tire plant and textile mill to support her family while studying in evening school."
        ),
        QuestionModel(
            id = "s_8_eng_312",
            stdId = 8,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Valentina Tereshkova’s life journey inspires youth because it demonstrates:",
            options = listOf("unwavering courage, determination and hard work", "that luck is all that matters", "that hardships cannot be overcome", "that one should avoid science"),
            correctAnswer = "unwavering courage, determination and hard work",
            explanation = "Her journey from an impoverished village textile worker to a space pioneer proves that dedication and grit conquer all obstacles."
        )
    )
}
