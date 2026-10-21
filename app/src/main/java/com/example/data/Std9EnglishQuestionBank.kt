package com.example.data

/**
 * Standard 9 - Second Language English
 * Consolidated Unit-Wise Question Bank (Karnataka DSERT / KSEAB Revised Curriculum)
 *
 * Sourced and constructed from Karnataka 9th Std English syllabus:
 *  - Unit 1: The Enchanted Pool (Prose) & Upagupta (Poem)
 *  - Unit 2: The Three Questions (Prose) & Gratefulness (Poem)
 *  - Unit 3: My Beginnings (Prose) & A Girl Called Golden (Poem)
 *  - Unit 4: Whatever We Do (Prose) & The Wonderful Words (Poem)
 *  - Unit 5: Justice Above Self (Prose) & Justice (Poem)
 *  - Unit 6: The Noble Bishop (Prose) & Nobleness Enkindleth Nobleness (Poem)
 *  - Unit 7: The Will of Sacrifice (Prose) & The Song of Freedom (Poem)
 *  - Unit 8: To My Country Men (Prose) & It Never Comes Again (Poem)
 *  - Unit 9: Supplementary Reading (Aruna Asaf Ali, The Happy Cure, Ranji's Wonderful Bat, Monday Morning)
 *  - Unit 10: Grammar, Vocabulary & Language in Use
 *
 * Includes direct MCQs, converted fill-in-the-blanks, and converted 1-mark comprehension questions.
 * All duplicates omitted; all picture-based questions omitted; 100% text-based 4-option MCQs.
 */
object Std9EnglishQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: The Enchanted Pool & Upagupta", 23, "Easy"),
        UnitTemplate(2, "Unit 2: The Three Questions & Gratefulness", 17, "Medium"),
        UnitTemplate(3, "Unit 3: My Beginnings & A Girl Called Golden", 15, "Medium"),
        UnitTemplate(4, "Unit 4: Whatever We Do & The Wonderful Words", 12, "Easy"),
        UnitTemplate(5, "Unit 5: Justice Above Self & Justice", 16, "Medium"),
        UnitTemplate(6, "Unit 6: The Noble Bishop & Nobleness Enkindleth Nobleness", 15, "Medium"),
        UnitTemplate(7, "Unit 7: The Will of Sacrifice & The Song of Freedom", 10, "Hard"),
        UnitTemplate(8, "Unit 8: To My Country Men & It Never Comes Again", 10, "Medium"),
        UnitTemplate(9, "Unit 9: Supplementary Reading (Aruna Asaf Ali, Happy Cure, Ranji, Tom)", 17, "Medium"),
        UnitTemplate(10, "Unit 10: Grammar, Vocabulary & Language in Use", 15, "Hard")
    )

    val questions: List<QuestionModel> = listOf(
        // ========================================================
        // 🟦 UNIT 1 – THE ENCHANTED POOL & UPAGUPTA
        // ========================================================
        QuestionModel(
            id = "s_9_eng_1_1",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The Pandava brothers were following a deer in the forest and felt very thirsty. Who did Yudhishthira send first to search for water?",
            options = listOf("Nakula", "Sahadeva", "Arjuna", "Bhima"),
            correctAnswer = "Nakula",
            explanation = "Yudhishthira sent Nakula, the son of Madri, first to climb a tree and look for water in the forest."
        ),
        QuestionModel(
            id = "s_9_eng_1_2",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "When Nakula reached the pool and was about to drink, a warning voice stopped him. The voice belonged to:",
            options = listOf("A celestial Gandharva", "The Yaksha", "A wild sage", "Lord Indra"),
            correctAnswer = "The Yaksha",
            explanation = "The invisible voice was that of the Yaksha, who warned Nakula not to drink before answering his questions."
        ),
        QuestionModel(
            id = "s_9_eng_1_3",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Fill in the blank: Nakula ignored the warning of the Yaksha because he was _________ and drank the water.",
            options = listOf("distracted by beasts", "overpowered by intense thirst", "angry at his brothers", "unconscious of his surroundings"),
            correctAnswer = "overpowered by intense thirst",
            explanation = "Nakula disregarded the warning because his thirst was unbearable, and upon drinking, he fell dead."
        ),
        QuestionModel(
            id = "s_9_eng_1_4",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What happened to Sahadeva, Arjuna, and Bhima when they reached the enchanted pool?",
            options = listOf(
                "They fled in panic back to Yudhishthira",
                "They answered all questions correctly",
                "They also drank without answering and fell dead",
                "They killed the hidden crane in the pool"
            ),
            correctAnswer = "They also drank without answering and fell dead",
            explanation = "Each of the brothers disregarded the warning voice due to desperate thirst and collapsed dead beside the pool."
        ),
        QuestionModel(
            id = "s_9_eng_1_5",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "When Yudhishthira arrived at the pool, he saw his mighty brothers lying dead like:",
            options = listOf("Fallen flagstaffs", "Uprooted giant trees", "Sleeping warriors", "Wounded lions"),
            correctAnswer = "Fallen flagstaffs",
            explanation = "C. Rajagopalachari describes the fallen brothers lying like fallen flagstaffs beside the crystal water."
        ),
        QuestionModel(
            id = "s_9_eng_1_6",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "According to Yudhishthira's answer to the Yaksha, what rescues man in danger?",
            options = listOf("Courage", "Wealth", "A sharp sword", "Swift running"),
            correctAnswer = "Courage",
            explanation = "Yaksha asked 'What rescues man in danger?' and Yudhishthira replied: 'Courage rescues man in danger.'"
        ),
        QuestionModel(
            id = "s_9_eng_1_7",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Fill in the blank: By the study of which science does man become wise? Yudhishthira answered that man becomes wise by _________.",
            options = listOf(
                "memorizing all four Vedas",
                "association with the great in wisdom",
                "performing severe penance",
                "reading thousands of holy scriptures"
            ),
            correctAnswer = "association with the great in wisdom",
            explanation = "Yudhishthira stated that man becomes wise not by reading any shastra alone, but through association with the wise."
        ),
        QuestionModel(
            id = "s_9_eng_1_8",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The Yaksha asked, 'What is more swiftly moving than the wind?' Yudhishthira answered:",
            options = listOf("The mind", "A flying arrow", "A storm cloud", "A running deer"),
            correctAnswer = "The mind",
            explanation = "Yudhishthira replied that the human mind travels and changes faster than the swiftest wind."
        ),
        QuestionModel(
            id = "s_9_eng_1_9",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What is more blighted and withered than dried straw according to Yudhishthira?",
            options = listOf("A diseased leaf", "An empty grain store", "A sorrow-stricken heart", "A barren desert"),
            correctAnswer = "A sorrow-stricken heart",
            explanation = "Yudhishthira answered: 'A sorrow-stricken heart is more blighted than dried straw.'"
        ),
        QuestionModel(
            id = "s_9_eng_1_10",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What befriends a traveler on his journey according to the dialogue between Yaksha and Yudhishthira?",
            options = listOf("Learning and knowledge", "Gold and jewels", "A sturdy chariot", "A faithful dog"),
            correctAnswer = "Learning and knowledge",
            explanation = "Yudhishthira answered that 'Learning' is the true friend and guide of a traveler."
        ),
        QuestionModel(
            id = "s_9_eng_1_11",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Who is the steadfast friend of one who stays at home?",
            options = listOf("The mother", "The wife", "The elder son", "The loyal servant"),
            correctAnswer = "The wife",
            explanation = "Yudhishthira replied to the Yaksha that the wife is the lifelong companion and friend of one who stays at home."
        ),
        QuestionModel(
            id = "s_9_eng_1_12",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Fill in the blank: Who accompanies a man in death? Yudhishthira replied that _________ alone accompanies the soul on its solitary journey after death.",
            options = listOf(
                "Good deeds and Dharma",
                "The accumulated worldly gold",
                "The family name and lineage",
                "The royal crown and sceptre"
            ),
            correctAnswer = "Good deeds and Dharma",
            explanation = "Yudhishthira stated that Dharma (righteousness) alone accompanies the soul after death; everything else is left behind."
        ),
        QuestionModel(
            id = "s_9_eng_1_13",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Which is the biggest vessel in existence according to Yudhishthira?",
            options = listOf(
                "The boundless sky",
                "The great ocean",
                "The Earth, which contains all within itself",
                "The human heart"
            ),
            correctAnswer = "The Earth, which contains all within itself",
            explanation = "Yudhishthira answered: 'The Earth, which contains all things within itself, is the greatest vessel.'"
        ),
        QuestionModel(
            id = "s_9_eng_1_14",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What is true happiness defined as by Yudhishthira?",
            options = listOf(
                "The result of good conduct and virtue",
                "Having enormous wealth and comfort",
                "Victory over all royal rivals",
                "Living without doing any hard work"
            ),
            correctAnswer = "The result of good conduct and virtue",
            explanation = "Yudhishthira stated: 'Happiness is the result of good conduct.'"
        ),
        QuestionModel(
            id = "s_9_eng_1_15",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What is that, by abandoning which man becomes loved by all?",
            options = listOf("Pride", "Food", "Sleep", "Wealth"),
            correctAnswer = "Pride",
            explanation = "Yudhishthira answered: 'Pride, for by giving up pride, a man becomes beloved of everyone.'"
        ),
        QuestionModel(
            id = "s_9_eng_1_16",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What is the loss which yields joy and not sorrow when given up?",
            options = listOf("Anger", "Money", "Fame", "Kingdom"),
            correctAnswer = "Anger",
            explanation = "Yudhishthira explained: 'Anger; if we give up being angry, we will no longer be subject to sorrow.'"
        ),
        QuestionModel(
            id = "s_9_eng_1_17",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What makes one a real Brahmana? Is it birth, learning, or good conduct?",
            options = listOf(
                "Birth into a noble priestly family",
                "Learning and mastery of the four Vedas",
                "Good conduct alone",
                "Wealth and royal patronage"
            ),
            correctAnswer = "Good conduct alone",
            explanation = "Yudhishthira explained that birth and learning do not make one a Brahmana; good conduct alone determines true virtue."
        ),
        QuestionModel(
            id = "s_9_eng_1_18",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "When granted the life of one brother, why did Yudhishthira specifically choose Nakula?",
            options = listOf(
                "Because Nakula was his favorite warrior",
                "Because Bhima and Arjuna were too arrogant",
                "To ensure both mothers, Kunti and Madri, had a surviving son",
                "Because Nakula asked for it first"
            ),
            correctAnswer = "To ensure both mothers, Kunti and Madri, had a surviving son",
            explanation = "Yudhishthira upheld impartiality: as Kunti's surviving son, he wanted Madri's son Nakula to live so both mothers had a son."
        ),
        QuestionModel(
            id = "s_9_eng_1_19",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Who was the Yaksha in reality?",
            options = listOf(
                "Lord Yama, the God of Justice and Death",
                "Lord Indra in disguise",
                "Lord Shiva testing devotion",
                "Sage Vyasa testing knowledge"
            ),
            correctAnswer = "Lord Yama, the God of Justice and Death",
            explanation = "The Yaksha was Lord Yama (Dharmaraja), who had assumed that form to test Yudhishthira's justice and wisdom."
        ),
        QuestionModel(
            id = "s_9_eng_1_20",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "In the poem 'Upagupta' by Rabindranath Tagore, where was Upagupta sleeping?",
            options = listOf(
                "Inside the royal Buddhist monastery",
                "In the dusty earth by the city wall of Mathura",
                "On a soft bed in Vasavadatta's garden",
                "On the bank of river Yamuna"
            ),
            correctAnswer = "In the dusty earth by the city wall of Mathura",
            explanation = "Tagore writes that Upagupta, the ascetic disciple of Buddha, lay asleep in the dust by the ramparts of Mathura."
        ),
        QuestionModel(
            id = "s_9_eng_1_21",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Who accidentally touched Upagupta with her feet in the dark night?",
            options = listOf(
                "A palace servant",
                "Vasavadatta, the dancing girl",
                "A royal queen of Mathura",
                "An old beggar woman"
            ),
            correctAnswer = "Vasavadatta, the dancing girl",
            explanation = "Vasavadatta, proud of her youth and beauty and adorned with jewels, stumbled over him in the darkness."
        ),
        QuestionModel(
            id = "s_9_eng_1_22",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "When Vasavadatta invited Upagupta to her home, what was his calm reply?",
            options = listOf(
                "'I can never enter the house of a dancer'",
                "'When the time is ripe, I will visit you'",
                "'Give your wealth to the poor first'",
                "'Depart from me, proud woman'"
            ),
            correctAnswer = "'When the time is ripe, I will visit you'",
            explanation = "Upagupta told her: 'Woman, go on your way; when the time is ripe, I will come to you.'"
        ),
        QuestionModel(
            id = "s_9_eng_1_23",
            stdId = 9,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Why was Vasavadatta driven out of the city gates years later?",
            options = listOf(
                "She lost all her fortune in trade",
                "She was struck with the deadly contagious pestilence (smallpox)",
                "The king banished her for treason",
                "She gave up dancing to become a nun"
            ),
            correctAnswer = "She was struck with the deadly contagious pestilence (smallpox)",
            explanation = "She was struck with black pestilence and her body covered with sores; townspeople drove her out to avoid contagion."
        ),

        // ========================================================
        // 🟦 UNIT 2 – THE THREE QUESTIONS & GRATEFULNESS
        // ========================================================
        QuestionModel(
            id = "s_9_eng_2_1",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "In Leo Tolstoy's story 'The Three Questions', what did the King want to know to never fail in life?",
            options = listOf(
                "How to win every war, how to acquire gold, and how to conquer neighboring kingdoms",
                "The right time for every action, the right people to listen to, and the most important thing to do",
                "How to live forever, how to choose a queen, and how to build temples",
                "Who his true friends were, what food to eat, and when to sleep"
            ),
            correctAnswer = "The right time for every action, the right people to listen to, and the most important thing to do",
            explanation = "The King believed that knowing the right time, the right people, and the most important business would prevent failure."
        ),
        QuestionModel(
            id = "s_9_eng_2_2",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Why did the King decide to consult the hermit in the forest?",
            options = listOf(
                "The hermit was widely renowned for his profound wisdom",
                "The hermit sent an invitation to the royal court",
                "The hermit had magical healing potions",
                "The King's ministers forced him to visit the forest"
            ),
            correctAnswer = "The hermit was widely renowned for his profound wisdom",
            explanation = "Since all the scholars and wise men gave contradictory answers, the King sought the renowned hermit."
        ),
        QuestionModel(
            id = "s_9_eng_2_3",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: The hermit received only _________, so the King put on simple clothes before meeting him.",
            options = listOf("wealthy merchants", "learned scholars", "common folk", "holy priests"),
            correctAnswer = "common folk",
            explanation = "Because the hermit associated only with simple common people, the King dressed as a commoner and left his horse behind."
        ),
        QuestionModel(
            id = "s_9_eng_2_4",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What was the hermit doing when the King arrived at his forest hut?",
            options = listOf(
                "Digging flower beds in front of his hut",
                "Meditating under a banyan tree",
                "Reading an ancient manuscript",
                "Cooking soup over a wooden fire"
            ),
            correctAnswer = "Digging flower beds in front of his hut",
            explanation = "The hermit was frail and breathless, digging the earth in front of his hut when the King approached him."
        ),
        QuestionModel(
            id = "s_9_eng_2_5",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What act of kindness did the King perform when he saw the hermit was frail and tired?",
            options = listOf(
                "He gave the hermit a bag of gold coins",
                "He took the spade and dug the ground himself",
                "He ordered his soldiers to build a new hut",
                "He fetched bread and wine from his carriage"
            ),
            correctAnswer = "He took the spade and dug the ground himself",
            explanation = "Seeing the hermit breathing heavily with fatigue, the King took the spade and continued digging the beds."
        ),
        QuestionModel(
            id = "s_9_eng_2_6",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Who came running out of the forest holding his hands pressed against his bleeding stomach?",
            options = listOf("A royal messenger", "A wounded bearded man", "A forest hunter", "The King's bodyguard"),
            correctAnswer = "A wounded bearded man",
            explanation = "A bearded man ran out of the woods, pressing a severe wound on his stomach with blood flowing freely."
        ),
        QuestionModel(
            id = "s_9_eng_2_7",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "How did the King save the wounded bearded man's life?",
            options = listOf(
                "He gave him royal medicine from his carriage",
                "He washed and bandaged the wound repeatedly with his handkerchief until the bleeding stopped",
                "He carried him to the nearest hospital in the city",
                "He cast a healing spell learned from the hermit"
            ),
            correctAnswer = "He washed and bandaged the wound repeatedly with his handkerchief until the bleeding stopped",
            explanation = "The King tirelessly washed the wound and bandaged it with his handkerchief and the hermit's towel until bleeding ceased."
        ),
        QuestionModel(
            id = "s_9_eng_2_8",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Why had the bearded man sworn to take revenge on the King?",
            options = listOf(
                "The King had executed his brother and seized his property",
                "The King had banished him from the city",
                "The King had defeated his army in battle",
                "The King refused to pay him for his service"
            ),
            correctAnswer = "The King had executed his brother and seized his property",
            explanation = "The man was the King's enemy because the King had previously put his brother to death and confiscated his estate."
        ),
        QuestionModel(
            id = "s_9_eng_2_9",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "How was the bearded man wounded before reaching the hermit's hut?",
            options = listOf(
                "He was attacked by a wild leopard",
                "The King's bodyguard recognized him and wounded him",
                "He fell upon his own sharp dagger",
                "The hermit struck him with a staff"
            ),
            correctAnswer = "The King's bodyguard recognized him and wounded him",
            explanation = "When the man came out of ambush, the King's bodyguard recognized him and wounded him."
        ),
        QuestionModel(
            id = "s_9_eng_2_10",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "According to the hermit, what is the only time that is truly important?",
            options = listOf(
                "The past, when lessons were learned",
                "The future, which holds all hope",
                "The present ('Now'), because it is the only time we have power to act",
                "The dawn of a new day"
            ),
            correctAnswer = "The present ('Now'), because it is the only time we have power to act",
            explanation = "The hermit explained: 'Remember then: there is only one time that is important—Now! It is the only time when we have any power.'"
        ),
        QuestionModel(
            id = "s_9_eng_2_11",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "According to the hermit's final explanation, who is the most necessary person in life?",
            options = listOf(
                "The King or ruler",
                "The person with whom you are at any given moment",
                "A learned philosopher",
                "A physician"
            ),
            correctAnswer = "The person with whom you are at any given moment",
            explanation = "The most necessary person is the one with whom you are, for no one knows whether he will have dealings with anyone else."
        ),
        QuestionModel(
            id = "s_9_eng_2_12",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the most important affair or business in life according to the hermit?",
            options = listOf(
                "To acquire lasting fame and fortune",
                "To do good to the person you are with",
                "To rule justly and expand boundaries",
                "To build memorials for future generations"
            ),
            correctAnswer = "To do good to the person you are with",
            explanation = "The most important business is to do that person good, because for that purpose alone was man sent into this life."
        ),
        QuestionModel(
            id = "s_9_eng_2_13",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "In the poem 'Gratefulness' by Joseph T. Renaldi, why is the speaker grateful for having eyes?",
            options = listOf(
                "To read ancient books and manuscripts",
                "To see the activities of the earth and the colors of day and night",
                "To recognize enemies from afar",
                "To count worldly possessions"
            ),
            correctAnswer = "To see the activities of the earth and the colors of day and night",
            explanation = "The poet gives thanks for eyes that can see the beauty and activities of the earth."
        ),
        QuestionModel(
            id = "s_9_eng_2_14",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: The poet prays for ears so that he may hear the _________ of those who need comfort.",
            options = listOf("cheers and applause", "crying and weeping", "songs and laughter", "whispers and secrets"),
            correctAnswer = "crying and weeping",
            explanation = "The poet thanks God for ears that hear the cries of those who need compassion and solace."
        ),
        QuestionModel(
            id = "s_9_eng_2_15",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Why does the poet express gratitude for having lips?",
            options = listOf(
                "To speak words of comfort, peace, and reassurance to others",
                "To sing melodic songs in royal courts",
                "To taste delicious feast dishes",
                "To argue persuasively in debates"
            ),
            correctAnswer = "To speak words of comfort, peace, and reassurance to others",
            explanation = "Lips are gifted so that they may speak soothing words of heart-felt comfort to the distressed."
        ),
        QuestionModel(
            id = "s_9_eng_2_16",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the purpose of having a compassionate heart according to Joseph T. Renaldi?",
            options = listOf(
                "To store personal pride and triumphs",
                "To feel sympathy and empathy for the sorrows of others",
                "To beat fast in times of adventure",
                "To love only one's immediate relatives"
            ),
            correctAnswer = "To feel sympathy and empathy for the sorrows of others",
            explanation = "A thankful heart beats with empathy, sharing the grief and suffering of fellow human beings."
        ),
        QuestionModel(
            id = "s_9_eng_2_17",
            stdId = 9,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What should hands be used for, as expressed in the poem 'Gratefulness'?",
            options = listOf(
                "To hold swords and weapons",
                "To reach out and lift those who stumble and fall",
                "To gather gold and silver coins",
                "To clap for wealthy leaders"
            ),
            correctAnswer = "To reach out and lift those who stumble and fall",
            explanation = "The poet is thankful for hands that can assist, support, and lift those who falter."
        ),

        // ========================================================
        // 🟦 UNIT 3 – MY BEGINNINGS & A GIRL CALLED GOLDEN
        // ========================================================
        QuestionModel(
            id = "s_9_eng_3_1",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "In 'My Beginnings', Kapil Dev mentions that he was born in which city and on what date?",
            options = listOf(
                "Chandigarh on 6th January 1959",
                "Amritsar on 15th August 1957",
                "Delhi on 2nd October 1960",
                "Jalandhar on 26th January 1958"
            ),
            correctAnswer = "Chandigarh on 6th January 1959",
            explanation = "Kapil Dev was born on a cold winter morning in Chandigarh on January 6, 1959."
        ),
        QuestionModel(
            id = "s_9_eng_3_2",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What did Kapil Dev's mother affectionately call him during his childhood?",
            options = listOf("The quiet scholar", "The naughtiest child in the family", "The little captain", "The speedy runner"),
            correctAnswer = "The naughtiest child in the family",
            explanation = "His mother always claimed that he was the naughtiest child who could never sit quietly in one place."
        ),
        QuestionModel(
            id = "s_9_eng_3_3",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What was one of young Kapil Dev's favorite mischievous pastimes with his friends?",
            options = listOf(
                "Climbing orchard trees to pluck fruits like guavas and papayas from neighbors' gardens",
                "Flying kites from temple rooftops",
                "Riding wild horses on the countryside road",
                "Swimming across flooded rivers"
            ),
            correctAnswer = "Climbing orchard trees to pluck fruits like guavas and papayas from neighbors' gardens",
            explanation = "Kapil and his companions loved jumping over garden walls to pick guavas and papayas in neighbors' orchards."
        ),
        QuestionModel(
            id = "s_9_eng_3_4",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Fill in the blank: The neighboring lady who had beautiful fruit trees owned ferocious _________ that Kapil and his friends had to evade.",
            options = listOf("dogs", "monkeys", "watchmen", "geese"),
            correctAnswer = "dogs",
            explanation = "The lady owned fierce dogs, and escaping them while carrying stolen fruits was an exhilarating childhood challenge."
        ),
        QuestionModel(
            id = "s_9_eng_3_5",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "How did Kapil Dev describe his mother's reaction when he returned home dirty and bruised after playing?",
            options = listOf(
                "She scolded him gently but washed his clothes and fed him lovingly",
                "She locked him in his bedroom for the whole day",
                "She forbade him from stepping out of the house forever",
                "She called the neighborhood policeman"
            ),
            correctAnswer = "She scolded him gently but washed his clothes and fed him lovingly",
            explanation = "His mother would affectionately chide him for his messy clothes but always showered him with warmth and wholesome food."
        ),
        QuestionModel(
            id = "s_9_eng_3_6",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "In which sport did Kapil Dev initially dream of representing his school and state before choosing cricket?",
            options = listOf("Football and athletics", "Table tennis and badminton", "Wrestling and boxing", "Swimming and hockey"),
            correctAnswer = "Football and athletics",
            explanation = "Kapil Dev had immense stamina and passion for outdoor sports, excelling in running and football before turning to cricket."
        ),
        QuestionModel(
            id = "s_9_eng_3_7",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Against which country did Kapil Dev play his debut Test match in cricket?",
            options = listOf("Pakistan", "England", "Australia", "West Indies"),
            correctAnswer = "Pakistan",
            explanation = "Kapil Dev made his historic Test debut against Pakistan at Faisalabad in 1978."
        ),
        QuestionModel(
            id = "s_9_eng_3_8",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What glorious achievement did the Indian cricket team achieve under Kapil Dev's captaincy in 1983?",
            options = listOf(
                "Winning the Prudential Cricket World Cup at Lord's",
                "Winning the Asian Games gold medal",
                "Winning the Olympic Cricket Trophy",
                "Winning five consecutive Test series overseas"
            ),
            correctAnswer = "Winning the Prudential Cricket World Cup at Lord's",
            explanation = "Kapil Dev led India to their historic maiden Cricket World Cup triumph against the West Indies at Lord's in 1983."
        ),
        QuestionModel(
            id = "s_9_eng_3_9",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What message does Kapil Dev's life story impart to young students?",
            options = listOf(
                "Hard work, disciplined practice, and passion turn humble beginnings into world-class success",
                "Success comes entirely through luck and wealthy sponsors",
                "Sports should only be played as a hobby, not a career",
                "Childhood mischief prevents one from achieving greatness"
            ),
            correctAnswer = "Hard work, disciplined practice, and passion turn humble beginnings into world-class success",
            explanation = "His journey proves that relentless dedication, physical fitness, and passion overcome every obstacle."
        ),
        QuestionModel(
            id = "s_9_eng_3_10",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Who is the legendary athlete celebrated in the poem 'A Girl Called Golden' by David Bateson?",
            options = listOf("P. T. Usha", "Betty Cuthbert", "Wilma Rudolph", "Fanny Blankers-Koen"),
            correctAnswer = "Betty Cuthbert",
            explanation = "The poem celebrates Australia's golden sprint queen, Betty Cuthbert."
        ),
        QuestionModel(
            id = "s_9_eng_3_11",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "At which Olympic Games did Betty Cuthbert win three gold medals?",
            options = listOf(
                "1956 Melbourne Olympics",
                "1960 Rome Olympics",
                "1964 Tokyo Olympics",
                "1952 Helsinki Olympics"
            ),
            correctAnswer = "1956 Melbourne Olympics",
            explanation = "At the 1956 Melbourne Olympic Games, eighteen-year-old Betty won gold medals in 100m, 200m, and 4x100m relay."
        ),
        QuestionModel(
            id = "s_9_eng_3_12",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Why was Betty Cuthbert nicknamed the 'Golden Girl'?",
            options = listOf(
                "She wore a solid gold running suit",
                "She had golden-blonde hair and won three Olympic gold medals",
                "She came from a family of gold prospectors",
                "She won an award made of 24-carat gold"
            ),
            correctAnswer = "She had golden-blonde hair and won three Olympic gold medals",
            explanation = "Her natural golden hair and her triple gold medal sweep earned her the enduring title 'Golden Girl'."
        ),
        QuestionModel(
            id = "s_9_eng_3_13",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "How does David Bateson describe Betty's posture and style while sprinting towards the finish line?",
            options = listOf(
                "Head tilted back, mouth open wide, pumping arms with fierce determination",
                "Leaning forward with eyes closed in prayer",
                "Looking sideways at her competitors to gauge distance",
                "Gliding smoothly without any visible exertion"
            ),
            correctAnswer = "Head tilted back, mouth open wide, pumping arms with fierce determination",
            explanation = "The poem pictures her iconic sprinting form: head thrown back, mouth gasping for air, driving with supreme effort."
        ),
        QuestionModel(
            id = "s_9_eng_3_14",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Fill in the blank: Betty was coached by _________, whose strict training helped her achieve Olympic excellence.",
            options = listOf("Ernie Cavell", "Percy Cerutty", "Arthur Lydiard", "Franz Stampfl"),
            correctAnswer = "Ernie Cavell",
            explanation = "Coach Ernie Cavell spotted her raw sprinting gift in school and trained her to reach world records."
        ),
        QuestionModel(
            id = "s_9_eng_3_15",
            stdId = 9,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What is the central inspirational theme of 'A Girl Called Golden'?",
            options = listOf(
                "Relentless effort and dedicated training can bring glory to oneself and one's nation",
                "Running is easier than academic study",
                "Only teenagers can win Olympic medals",
                "Winning medals brings immense monetary fortune"
            ),
            correctAnswer = "Relentless effort and dedicated training can bring glory to oneself and one's nation",
            explanation = "The poem highlights how grueling practice, perseverance, and passion lead to athletic immortality."
        ),

        // ========================================================
        // 🟦 UNIT 4 – WHATEVER WE DO & THE WONDERFUL WORDS
        // ========================================================
        QuestionModel(
            id = "s_9_eng_4_1",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In the lesson 'Whatever We Do' by Clifford Martis, what is the central principle of human action?",
            options = listOf(
                "Whatever we do, it should be done with grace, excellence, and thoroughness",
                "Whatever we do, we must ensure maximum financial profit",
                "We should only do things when someone is supervising us",
                "Speed is far more important than quality in all work"
            ),
            correctAnswer = "Whatever we do, it should be done with grace, excellence, and thoroughness",
            explanation = "Clifford Martis emphasizes that whether an action is big or small, it must be performed with polish and excellence."
        ),
        QuestionModel(
            id = "s_9_eng_4_2",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Which polite expressions are described as 'magic words' in civilized human interaction?",
            options = listOf(
                "'Please', 'Thank you', 'Sorry', and 'Excuse me'",
                "'Hurry up', 'Get out', 'Listen to me', and 'Quiet'",
                "'Give me', 'Take this', 'Do it now', and 'Move aside'",
                "'Yes', 'No', 'Never', and 'Always'"
            ),
            correctAnswer = "'Please', 'Thank you', 'Sorry', and 'Excuse me'",
            explanation = "Words like 'Please', 'Thank you', 'Sorry', and 'Excuse me' sweeten human relationships and remove friction."
        ),
        QuestionModel(
            id = "s_9_eng_4_3",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Fill in the blank: When speaking on the telephone in public or at home, a considerate person should speak _________.",
            options = listOf("at the top of his voice", "softly and clearly without disturbing others", "using harsh slang words", "for hours without pausing"),
            correctAnswer = "softly and clearly without disturbing others",
            explanation = "Good telephone etiquette requires speaking gently and clearly so as not to cause inconvenience to bystanders."
        ),
        QuestionModel(
            id = "s_9_eng_4_4",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "What example does the author give of true craftsmanship and devotion to work?",
            options = listOf(
                "A carpenter polishing the back and underside of a table with the same care as the front",
                "A builder using cheap cement to finish construction quickly",
                "A shopkeeper who never sweeps his shop floor",
                "An artist who leaves his canvas half painted"
            ),
            correctAnswer = "A carpenter polishing the back and underside of a table with the same care as the front",
            explanation = "A true craftsman takes pride in unseen details, ensuring perfection even where eyes do not routinely see."
        ),
        QuestionModel(
            id = "s_9_eng_4_5",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "How should a responsible citizen behave when boarding a bus or purchasing tickets in public places?",
            options = listOf(
                "Stand patiently in a queue and wait for one's turn",
                "Push ahead of women and elderly citizens",
                "Bribe the conductor to get a front seat",
                "Jump through the window to grab a seat"
            ),
            correctAnswer = "Stand patiently in a queue and wait for one's turn",
            explanation = "Queue discipline is the hallmark of a civilized, polite, and considerate society."
        ),
        QuestionModel(
            id = "s_9_eng_4_6",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Why is listening patiently considered a vital social virtue in 'Whatever We Do'?",
            options = listOf(
                "It shows respect to the speaker and avoids unnecessary misunderstandings",
                "It allows one to plan how to insult the speaker",
                "It wastes the speaker's time",
                "It makes one appear completely silent"
            ),
            correctAnswer = "It shows respect to the speaker and avoids unnecessary misunderstandings",
            explanation = "Attentive listening demonstrates courtesy, prevents errors, and fosters healthy human relationships."
        ),
        QuestionModel(
            id = "s_9_eng_4_7",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Who wrote the inspiring poem 'The Wonderful Words'?",
            options = listOf("Mary O'Neill", "Sarojini Naidu", "William Wordsworth", "Robert Frost"),
            correctAnswer = "Mary O'Neill",
            explanation = "The poem 'The Wonderful Words' was composed by Mary O'Neill."
        ),
        QuestionModel(
            id = "s_9_eng_4_8",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Fill in the blank: 'Never let a thought shrivel and die for want of a way to _________ it.'",
            options = listOf("hide", "say", "forget", "punish"),
            correctAnswer = "say",
            explanation = "The opening lines state: 'Never let a thought shrivel and die / For want of a way to say it.'"
        ),
        QuestionModel(
            id = "s_9_eng_4_9",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "How does the poet describe the English language in 'The Wonderful Words'?",
            options = listOf(
                "A wonderful game that everyone can play",
                "A difficult puzzle that only scholars can solve",
                "A rigid code without any flexibility",
                "A dry collection of historical rules"
            ),
            correctAnswer = "A wonderful game that everyone can play",
            explanation = "Mary O'Neill calls English a delightful game where matching words to thoughts brings ideas alive."
        ),
        QuestionModel(
            id = "s_9_eng_4_10",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "What are words compared to in the line: 'For words are the food and dress of thought'?",
            options = listOf(
                "They give body and movement to our unspoken thoughts",
                "They disguise our thoughts like a mask",
                "They consume our intellect like fire",
                "They weigh down the mind like heavy stones"
            ),
            correctAnswer = "They give body and movement to our unspoken thoughts",
            explanation = "Words clothe our thoughts, giving them visible shape, vitality, and power to communicate."
        ),
        QuestionModel(
            id = "s_9_eng_4_11",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "What does everyone long to hear according to the poem?",
            options = listOf(
                "Some fresh and beautiful thing spoken with elegance",
                "Flattery and false compliments",
                "Sensational rumors and gossip",
                "Angry arguments and shouting"
            ),
            correctAnswer = "Some fresh and beautiful thing spoken with elegance",
            explanation = "The human mind naturally craves new, uplifting, and beautifully expressed thoughts."
        ),
        QuestionModel(
            id = "s_9_eng_4_12",
            stdId = 9,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Where does a thought remain imprisoned until words set it free?",
            options = listOf(
                "Behind our eyes and within our mind",
                "Inside ancient dictionaries",
                "In dusty library books",
                "In the ears of our listeners"
            ),
            correctAnswer = "Behind our eyes and within our mind",
            explanation = "Only carefully chosen words have the power to release captive ideas trapped in our minds."
        ),

        // ========================================================
        // 🟦 UNIT 5 – JUSTICE ABOVE SELF & JUSTICE
        // ========================================================
        QuestionModel(
            id = "s_9_eng_5_1",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "In Premchand's famous story 'Justice Above Self', who were the two inseparable childhood friends?",
            options = listOf(
                "Jumman Sheikh and Algu Chaudhary",
                "Samjhu Sahu and Ramdhan Mishra",
                "Budhiram and Rupa",
                "Hori and Gobar"
            ),
            correctAnswer = "Jumman Sheikh and Algu Chaudhary",
            explanation = "Jumman Sheikh and Algu Chaudhary shared a deep bond of friendship and mutual trust in the village."
        ),
        QuestionModel(
            id = "s_9_eng_5_2",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "On what condition did Jumman's elderly maternal aunt transfer her piece of property to him?",
            options = listOf(
                "That Jumman would look after her and provide for her needs until her death",
                "That Jumman would pay her five hundred rupees in cash every month",
                "That Jumman would build a separate house for her",
                "That Jumman would sell the land and share the proceeds"
            ),
            correctAnswer = "That Jumman would look after her and provide for her needs until her death",
            explanation = "The aunt deeded her land to Jumman with the understanding that he would care for and support her for life."
        ),
        QuestionModel(
            id = "s_9_eng_5_3",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "How did Jumman and his wife Kariman treat the old aunt after a few years had passed?",
            options = listOf(
                "They grew indifferent, insulted her, and begrudged her even a little food",
                "They sent her on an all-expenses-paid holy pilgrimage",
                "They built a grand orchard for her enjoyment",
                "They appointed special attendants to serve her"
            ),
            correctAnswer = "They grew indifferent, insulted her, and begrudged her even a little food",
            explanation = "Once the property was registered, Jumman and his wife ill-treated the aunt and insulted her when she asked for meals."
        ),
        QuestionModel(
            id = "s_9_eng_5_4",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "When the aunt requested a modest monthly allowance to cook her meals separately, how did Jumman react?",
            options = listOf(
                "He insulted her shamelessly and claimed money did not grow on trees in his house",
                "He readily agreed and paid her in advance",
                "He asked Algu Chaudhary to pay her",
                "He handed the property back to her"
            ),
            correctAnswer = "He insulted her shamelessly and claimed money did not grow on trees in his house",
            explanation = "Jumman rudely refused, telling her that money did not grow on trees."
        ),
        QuestionModel(
            id = "s_9_eng_5_5",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Where did the village elders meet to hold the Panchayat regarding the aunt's complaint?",
            options = listOf(
                "Under the ancient banyan tree",
                "Inside the village temple hall",
                "In the courtyard of the Zamindar's mansion",
                "On the bank of the village river"
            ),
            correctAnswer = "Under the ancient banyan tree",
            explanation = "The Panchayat was traditionally convened under the shade of the sacred banyan tree."
        ),
        QuestionModel(
            id = "s_9_eng_5_6",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Whom did the aunt nominate as the Head Panch (Sarpanch) for the dispute?",
            options = listOf("Algu Chaudhary", "Samjhu Sahu", "The village headman", "Jumman Sheikh"),
            correctAnswer = "Algu Chaudhary",
            explanation = "The aunt nominated Algu Chaudhary, saying: 'The Panch has neither friend nor enemy; God lives in the heart of the Panch.'"
        ),
        QuestionModel(
            id = "s_9_eng_5_7",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Why was Jumman secretly delighted when Algu Chaudhary was named Sarpanch?",
            options = listOf(
                "He knew Algu was his best friend and believed Algu would surely rule in his favor",
                "He planned to bribe Algu with cattle",
                "He wanted to test Algu's legal knowledge",
                "He had already written the judgment for Algu"
            ),
            correctAnswer = "He knew Algu was his best friend and believed Algu would surely rule in his favor",
            explanation = "Jumman was confident that his deep friendship with Algu would guarantee a decision in his favor."
        ),
        QuestionModel(
            id = "s_9_eng_5_8",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What historic judgment did Algu Chaudhary pronounce as Head Panch?",
            options = listOf(
                "Jumman must pay his aunt a monthly allowance, or the property would revert back to her",
                "The aunt must leave the village immediately",
                "Jumman was innocent and could throw the aunt out",
                "The property must be sold and divided equally among all villagers"
            ),
            correctAnswer = "Jumman must pay his aunt a monthly allowance, or the property would revert back to her",
            explanation = "Algu placed justice above friendship, ruling that Jumman must pay an allowance or return the land."
        ),
        QuestionModel(
            id = "s_9_eng_5_9",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What happened to the friendship between Jumman and Algu after the verdict?",
            options = listOf(
                "Jumman became Algu's bitter enemy and sought an opportunity for revenge",
                "Their friendship grew even stronger immediately",
                "They decided to go into business together",
                "They both left the village in anger"
            ),
            correctAnswer = "Jumman became Algu's bitter enemy and sought an opportunity for revenge",
            explanation = "Jumman felt betrayed by Algu, broke off all relations, and waited for an opportunity to avenge himself."
        ),
        QuestionModel(
            id = "s_9_eng_5_10",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "To whom did Algu sell his fine bullock on the promise of payment within a month?",
            options = listOf("Samjhu Sahu, the village cart-driver", "Jumman Sheikh", "The wealthy money-lender", "The village postman"),
            correctAnswer = "Samjhu Sahu, the village cart-driver",
            explanation = "Algu sold his bullock to Samjhu Sahu, who promised to pay the price within a month."
        ),
        QuestionModel(
            id = "s_9_eng_5_11",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Why did the bullock die within a month of being bought by Samjhu Sahu?",
            options = listOf(
                "Sahu overworked the bullock with four trips a day and starved it of proper fodder and water",
                "The bullock was poisoned by an unknown enemy",
                "The bullock fell into an open well",
                "The bullock was bitten by a poisonous snake"
            ),
            correctAnswer = "Sahu overworked the bullock with four trips a day and starved it of proper fodder and water",
            explanation = "Sahu cruelly overloaded the poor animal and provided no grass or care, causing it to drop dead from exhaustion."
        ),
        QuestionModel(
            id = "s_9_eng_5_12",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "When Algu asked for the price of the bullock, Sahu refused and called a Panchayat. Whom did Sahu nominate as Head Panch?",
            options = listOf("Jumman Sheikh", "The village priest", "His own elder brother", "A stranger from the city"),
            correctAnswer = "Jumman Sheikh",
            explanation = "Sahu chose Jumman, knowing that Jumman was Algu's enemy and would surely favor Sahu."
        ),
        QuestionModel(
            id = "s_9_eng_5_13",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "As soon as Jumman sat on the sacred seat of the Sarpanch, what realization dawned upon him?",
            options = listOf(
                "That as a judge, he represented God and must deliver impartial justice without malice or bias",
                "That he could now crush Algu financially without consequence",
                "That he should demand a bribe from both parties",
                "That he should resign from the Panchayat immediately"
            ),
            correctAnswer = "That as a judge, he represented God and must deliver impartial justice without malice or bias",
            explanation = "Sitting on the judgment seat, Jumman felt the heavy responsibility of truth and conscience above personal hatred."
        ),
        QuestionModel(
            id = "s_9_eng_5_14",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What was Jumman's final verdict regarding Samjhu Sahu and Algu Chaudhary?",
            options = listOf(
                "Samjhu Sahu must pay the full price to Algu, as the bullock was healthy when sold",
                "Algu must pay Sahu a fine for selling a sick animal",
                "Both parties must bear half the loss",
                "The case was dismissed without any payment"
            ),
            correctAnswer = "Samjhu Sahu must pay the full price to Algu, as the bullock was healthy when sold",
            explanation = "Jumman ruled that the death was caused solely by Sahu's ill-treatment, so Sahu had to pay the promised amount."
        ),
        QuestionModel(
            id = "s_9_eng_5_15",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "In the poem 'Justice' by Praveen Kumar, how is Justice traditionally depicted in symbols?",
            options = listOf(
                "Blindfolded holding a pair of balanced scales in hand",
                "A roaring lion with a sharp sword",
                "A crowned king seated on a golden throne",
                "A running athlete carrying a flaming torch"
            ),
            correctAnswer = "Blindfolded holding a pair of balanced scales in hand",
            explanation = "Justice is universally symbolized by Lady Justice wearing a blindfold and holding scales to signify impartiality."
        ),
        QuestionModel(
            id = "s_9_eng_5_16",
            stdId = 9,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What lament does the poet Praveen Kumar express regarding the state of justice in the modern world?",
            options = listOf(
                "Justice is often traded like merchandise, delayed, or denied to the impoverished",
                "Justice is handed out too quickly without proper hearings",
                "Courts are completely empty and neglected",
                "Everyone in society receives immediate fair justice"
            ),
            correctAnswer = "Justice is often traded like merchandise, delayed, or denied to the impoverished",
            explanation = "The poet laments that justice is often shackled by money, influence, and delay, depriving the weak of fairness."
        ),

        // ========================================================
        // 🟦 UNIT 6 – THE NOBLE BISHOP & NOBLENESS ENKINDLETH NOBLENESS
        // ========================================================
        QuestionModel(
            id = "s_9_eng_6_1",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The prose 'The Noble Bishop' is adapted from which monumental world masterpiece by Victor Hugo?",
            options = listOf("Les Misérables", "The Hunchback of Notre-Dame", "War and Peace", "Great Expectations"),
            correctAnswer = "Les Misérables",
            explanation = "The story is an excerpt from Victor Hugo's classic novel 'Les Misérables'."
        ),
        QuestionModel(
            id = "s_9_eng_6_2",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What was the name of the kind Bishop of Digne, renowned for his boundless charity?",
            options = listOf(
                "Bishop Bienvenu (Monseigneur Welcome)",
                "Bishop Myriel of Paris",
                "Bishop Claude Frollo",
                "Bishop Javert"
            ),
            correctAnswer = "Bishop Bienvenu (Monseigneur Welcome)",
            explanation = "Bishop Myriel, affectionately known as Bishop Bienvenu ('Welcome'), was renowned for giving everything to the poor."
        ),
        QuestionModel(
            id = "s_9_eng_6_3",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Who lived with the Bishop in his modest house?",
            options = listOf(
                "His sister Baptistine and housemaid Madame Magloire",
                "A squad of armed guards and royal servants",
                "His two brothers and nephews",
                "A community of young scholars"
            ),
            correctAnswer = "His sister Baptistine and housemaid Madame Magloire",
            explanation = "The saintly Bishop lived peacefully with his sister Mademoiselle Baptistine and servant Madame Magloire."
        ),
        QuestionModel(
            id = "s_9_eng_6_4",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Why had Jean Valjean been condemned to nineteen years of hard labor in the galleys?",
            options = listOf(
                "Five years for stealing a loaf of bread to feed his sister's starving children, and fourteen years for escape attempts",
                "For assassinating a royal tax collector",
                "For robbing a wealthy cathedral",
                "For deserting the French national army"
            ),
            correctAnswer = "Five years for stealing a loaf of bread to feed his sister's starving children, and fourteen years for escape attempts",
            explanation = "He stole a loaf of bread to save his sister's starving children (5 years) and attempted multiple escapes (14 additional years)."
        ),
        QuestionModel(
            id = "s_9_eng_6_5",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Why was Jean Valjean refused food and lodging at all inns and cottages in Digne?",
            options = listOf(
                "He carried a yellow passport identifying him as a dangerous ex-convict",
                "He did not possess any money to pay for lodging",
                "He arrived after midnight when gates were locked",
                "He was accompanied by wild beasts"
            ),
            correctAnswer = "He carried a yellow passport identifying him as a dangerous ex-convict",
            explanation = "The yellow passport marked him as an outcast and dangerous convict whom no innkeeper would admit."
        ),
        QuestionModel(
            id = "s_9_eng_6_6",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "How did the Bishop greet Jean Valjean when the exhausted convict knocked at his door?",
            options = listOf(
                "He welcomed him warmly as 'brother', invited him to dinner, and prepared a bed with white sheets",
                "He asked to examine his passport and called the police",
                "He told him to sleep outside in the stable",
                "He gave him dry crusts of bread and shut the door"
            ),
            correctAnswer = "He welcomed him warmly as 'brother', invited him to dinner, and prepared a bed with white sheets",
            explanation = "The Bishop greeted him with profound Christian love, addressing him as 'brother' and offering his best hospitality."
        ),
        QuestionModel(
            id = "s_9_eng_6_7",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What valuable items tempted Jean Valjean during the middle of the night?",
            options = listOf(
                "The Bishop's silver plates and soup ladle",
                "The Bishop's golden watch and cross",
                "A chest of gold coins in the chapel",
                "The Bishop's silk vestments"
            ),
            correctAnswer = "The Bishop's silver plates and soup ladle",
            explanation = "Seeing the heavy silver tableware locked in the cupboard tempted Valjean, who stole them and fled into the night."
        ),
        QuestionModel(
            id = "s_9_eng_6_8",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What did the Bishop tell the gendarmes (police) when they brought the captured Valjean back with the stolen silver?",
            options = listOf(
                "That he had gifted the silver to Valjean, and Valjean had even forgotten the two silver candlesticks",
                "That Valjean had broken in and deserved life imprisonment",
                "That the silver belonged to the French government",
                "That Valjean should be publicly whipped in the square"
            ),
            correctAnswer = "That he had gifted the silver to Valjean, and Valjean had even forgotten the two silver candlesticks",
            explanation = "The Bishop told the police he had given the silver to Valjean as a gift, handing him the silver candlesticks as well."
        ),
        QuestionModel(
            id = "s_9_eng_6_9",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What solemn words did the Bishop say to Jean Valjean before parting?",
            options = listOf(
                "'Jean Valjean, my brother, remember you promised me to employ this silver to become an honest man'",
                "'Leave this country and never show your face in Digne again'",
                "'Pay me back the cost of this silver within a year'",
                "'Report yourself to the police commissioner tomorrow'"
            ),
            correctAnswer = "'Jean Valjean, my brother, remember you promised me to employ this silver to become an honest man'",
            explanation = "The Bishop redeemed Valjean's soul: 'I have bought your soul from evil thoughts and given it to God; use this silver to become an honest man.'"
        ),
        QuestionModel(
            id = "s_9_eng_6_10",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Who wrote the poem 'Nobleness Enkindleth Nobleness'?",
            options = listOf("James Russell Lowell", "John Keats", "Lord Byron", "Percy Bysshe Shelley"),
            correctAnswer = "James Russell Lowell",
            explanation = "The poem was written by the American poet James Russell Lowell."
        ),
        QuestionModel(
            id = "s_9_eng_6_11",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "In the poem, what did the stranger who came to Yussouf's tent in the desert plead for?",
            options = listOf(
                "Food, shelter, and protection from his fierce pursuers",
                "A bag of pearls to trade in Baghdad",
                "A duel with Yussouf's strongest warrior",
                "Directions to the nearest oasis"
            ),
            correctAnswer = "Food, shelter, and protection from his fierce pursuers",
            explanation = "The hunted stranger pleaded for shelter, saying his enemies were hot on his trail."
        ),
        QuestionModel(
            id = "s_9_eng_6_12",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "How did Yussouf receive the fugitive stranger in his desert tent?",
            options = listOf(
                "He welcomed him, declaring that his tent belonged to God and was free to every stranger",
                "He demanded twenty gold coins before letting him enter",
                "He ordered his servants to tie the stranger's hands",
                "He hid behind his carpets in fear"
            ),
            correctAnswer = "He welcomed him, declaring that his tent belonged to God and was free to every stranger",
            explanation = "Yussouf practiced sacred desert hospitality: 'This tent is mine, but no more than it is God's, and all is free to you.'"
        ),
        QuestionModel(
            id = "s_9_eng_6_13",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What did Yussouf give the stranger before dawn to help him escape safely?",
            options = listOf(
                "Gold and his swiftest desert steed",
                "A camel laden with silk and incense",
                "A forged letter of royal pardon",
                "A hidden route map drawn on leather"
            ),
            correctAnswer = "Gold and his swiftest desert steed",
            explanation = "Yussouf woke the guest before sunrise, gave him a purse of gold, and prepared his fastest horse."
        ),
        QuestionModel(
            id = "s_9_eng_6_14",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Overwhelmed by Yussouf's supreme kindness, what shocking truth did the stranger confess?",
            options = listOf(
                "That he was Ibrahim, the murderer of Yussouf's own beloved son",
                "That he was a royal prince sent to spy on Yussouf",
                "That he had stolen all the gold from the tent",
                "That the pursuers were actually his loyal companions"
            ),
            correctAnswer = "That he was Ibrahim, the murderer of Yussouf's own beloved son",
            explanation = "Ibrahim broke down in tears, confessing: 'I slew your first-born son, and I am the fugitive you harbored!'"
        ),
        QuestionModel(
            id = "s_9_eng_6_15",
            stdId = 9,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "How did Yussouf react to the murderer's confession?",
            options = listOf(
                "He gave him thrice the gold and forgave him, avenging his son by transforming an enemy into a noble soul",
                "He drew his curved scimitar and struck him down",
                "He handed him over to the desert executioners",
                "He banished him to starve in the barren wilderness"
            ),
            correctAnswer = "He gave him thrice the gold and forgave him, avenging his son by transforming an enemy into a noble soul",
            explanation = "Yussouf responded with divine nobility: 'Take thrice the gold; you have made my dead son an angel, and turned darkness into nobility.'"
        ),

        // ========================================================
        // 🟦 UNIT 7 – THE WILL OF SACRIFICE & THE SONG OF FREEDOM
        // ========================================================
        QuestionModel(
            id = "s_9_eng_7_1",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "In the lesson 'The Will of Sacrifice', what supreme virtue is celebrated among India's freedom fighters?",
            options = listOf(
                "Selfless sacrifice and willingness to lay down one's life for motherland and freedom",
                "Accumulating personal fame and political offices",
                "Signing treaties with the colonizers for peace",
                "Fleeing abroad to lead a comfortable life"
            ),
            correctAnswer = "Selfless sacrifice and willingness to lay down one's life for motherland and freedom",
            explanation = "The chapter highlights how supreme patriots willingly sacrificed their youth and lives for the nation."
        ),
        QuestionModel(
            id = "s_9_eng_7_2",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Which iconic revolutionary trio was hanged on 23rd March 1931 in Lahore Central Jail?",
            options = listOf(
                "Bhagat Singh, Rajguru, and Sukhdev",
                "Chandrashekhar Azad, Ashfaqulla Khan, and Ram Prasad Bismil",
                "Subhas Chandra Bose, Rash Behari Bose, and Mohan Singh",
                "Lala Lajpat Rai, Bal Gangadhar Tilak, and Bipin Chandra Pal"
            ),
            correctAnswer = "Bhagat Singh, Rajguru, and Sukhdev",
            explanation = "Bhagat Singh, Shivaram Rajguru, and Sukhdev Thapar embraced martyrdom smilingly on March 23, 1931."
        ),
        QuestionModel(
            id = "s_9_eng_7_3",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Fill in the blank: Bhagat Singh and Batukeshwar Dutt threw harmless smoke bombs into the Central Legislative Assembly to _________.",
            options = listOf(
                "'make the deaf hear' and protest oppressive British bills without killing anyone",
                "destroy the entire legislative building",
                "assassinate the British Viceroy",
                "escape under the cover of smoke"
            ),
            correctAnswer = "'make the deaf hear' and protest oppressive British bills without killing anyone",
            explanation = "Their leaflets proclaimed: 'It takes a loud noise to make the deaf hear'; they courted arrest without injuring anyone."
        ),
        QuestionModel(
            id = "s_9_eng_7_4",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What famous patriotic slogan was popularized across India by young Bhagat Singh?",
            options = listOf("Inquilab Zindabad (Long Live the Revolution)", "Jai Hind", "Do or Die", "Swaraj is my Birthright"),
            correctAnswer = "Inquilab Zindabad (Long Live the Revolution)",
            explanation = "Bhagat Singh popularized 'Inquilab Zindabad' as the battle cry of freedom against tyranny."
        ),
        QuestionModel(
            id = "s_9_eng_7_5",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What did Bhagat Singh and his comrades request the British governor before their execution?",
            options = listOf(
                "To be treated as prisoners of war and shot by a firing squad rather than hanged as common criminals",
                "To be granted an unconditional pardon",
                "To be allowed to meet their families in England",
                "To postpone their hanging by one year"
            ),
            correctAnswer = "To be treated as prisoners of war and shot by a firing squad rather than hanged as common criminals",
            explanation = "They boldly wrote that as soldiers of the Indian revolutionary army, they should be shot as prisoners of war."
        ),
        QuestionModel(
            id = "s_9_eng_7_6",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Who is the fiery national poet who composed 'The Song of Freedom'?",
            options = listOf("Subrahmanya Bharati", "Rabindranath Tagore", "Kuvempu", "Sarojini Naidu"),
            correctAnswer = "Subrahmanya Bharati",
            explanation = "The revolutionary Tamil poet Mahakavi Subrahmanya Bharati composed 'The Song of Freedom'."
        ),
        QuestionModel(
            id = "s_9_eng_7_7",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Fill in the blank: 'This is the hour of song and dance, for _________ freedom is ours at last!'",
            options = listOf("blissful", "partial", "temporary", "distant"),
            correctAnswer = "blissful",
            explanation = "The opening triumphant line proclaims: 'This is the hour of song and dance, / For blissful freedom is ours at last!'"
        ),
        QuestionModel(
            id = "s_9_eng_7_8",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What evils of the past are declared abolished and vanished in 'The Song of Freedom'?",
            options = listOf(
                "Slavery, servility, caste divisions, and deceitful tricks",
                "Scientific inventions and modern machinery",
                "Music, arts, and joyous dance",
                "Farming and agricultural trade"
            ),
            correctAnswer = "Slavery, servility, caste divisions, and deceitful tricks",
            explanation = "Bharati proclaims that the days of bowing down to masters, fear, and caste discrimination are dead forever."
        ),
        QuestionModel(
            id = "s_9_eng_7_9",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "How does the poet view all Indian citizens in the dawn of freedom?",
            options = listOf(
                "All are equal peers and beloved children of one motherland",
                "Divided strictly by rank and inherited wealth",
                "Ruled perpetually by imperial governors",
                "Isolated in independent regional principalities"
            ),
            correctAnswer = "All are equal peers and beloved children of one motherland",
            explanation = "Bharati affirms the democratic ideal of universal human brotherhood and equal dignity."
        ),
        QuestionModel(
            id = "s_9_eng_7_10",
            stdId = 9,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What divine symbol does Bharati invoke when saluting the arrival of freedom?",
            options = listOf(
                "The radiant Sun of freedom breaking through the night",
                "A roaring thundercloud over the mountain",
                "A golden crown placed on a warrior's head",
                "A swift river overflowing its banks"
            ),
            correctAnswer = "The radiant Sun of freedom breaking through the night",
            explanation = "The poet salutes the golden sunrise of liberty dispersing centuries of colonial darkness and despair."
        ),

        // ========================================================
        // 🟦 UNIT 8 – TO MY COUNTRY MEN & IT NEVER COMES AGAIN
        // ========================================================
        QuestionModel(
            id = "s_9_eng_8_1",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Who is the author of the patriotic address 'To My Country Men'?",
            options = listOf("Dr. A. P. J. Abdul Kalam", "Dr. B. R. Ambedkar", "Jawaharlal Nehru", "Sardar Vallabhbhai Patel"),
            correctAnswer = "Dr. A. P. J. Abdul Kalam",
            explanation = "The piece is an excerpt from the inspiring writings and speeches of Dr. A.P.J. Abdul Kalam, the 'Missile Man' of India."
        ),
        QuestionModel(
            id = "s_9_eng_8_2",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What were the three visions that Dr. A. P. J. Abdul Kalam outlined for India?",
            options = listOf(
                "Freedom, Development, and Standing up to the world with strength",
                "Conquest of neighbors, nuclear dominance, and political empire",
                "Luxury for all, free electricity, and abolishing taxes",
                "Westernization, industrial automation, and space tourism"
            ),
            correctAnswer = "Freedom, Development, and Standing up to the world with strength",
            explanation = "Dr. Kalam emphasized India's first vision (Freedom won in 1857-1947), second (Development into an economic power), and third (Strength)."
        ),
        QuestionModel(
            id = "s_9_eng_8_3",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Why did Dr. Kalam emphasize that India must be strong both economically and militarily?",
            options = listOf(
                "Because 'Strength respects strength', and no one respects a weak nation",
                "Because India wanted to wage war on foreign nations",
                "To prove that ancient weapons were obsolete",
                "To compete with Hollywood and world cinema"
            ),
            correctAnswer = "Because 'Strength respects strength', and no one respects a weak nation",
            explanation = "Dr. Kalam famously affirmed that in world geopolitics, only strength respects strength; weakness earns no respect."
        ),
        QuestionModel(
            id = "s_9_eng_8_4",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What year did Dr. Kalam envision as the milestone by which India should become a fully developed nation?",
            options = listOf("2020", "2010", "2030", "2050"),
            correctAnswer = "2020",
            explanation = "Through his vision 'India 2020', Dr. Kalam charted the blueprint for transforming India into a developed knowledge society."
        ),
        QuestionModel(
            id = "s_9_eng_8_5",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What did Dr. Kalam urge the young minds of India to ignite?",
            options = listOf(
                "Their imagination, innovative spirit, and confidence in indigenous capabilities",
                "Bonfires on university campuses",
                "Petty political rivalries on social media",
                "Desire to migrate permanently to foreign countries"
            ),
            correctAnswer = "Their imagination, innovative spirit, and confidence in indigenous capabilities",
            explanation = "Dr. Kalam believed the ignited mind of youth is the most powerful resource on earth."
        ),
        QuestionModel(
            id = "s_9_eng_8_6",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What common negative attitude among citizens did Dr. Kalam challenge in his address?",
            options = listOf(
                "Blaming the government and system for everything instead of actively contributing to civic cleanliness and progress",
                "Studying too hard in mathematics and science",
                "Planting too many trees along roadways",
                "Respecting cultural traditions too deeply"
            ),
            correctAnswer = "Blaming the government and system for everything instead of actively contributing to civic cleanliness and progress",
            explanation = "Dr. Kalam urged citizens to take personal responsibility for civic pride, hygiene, and national progress instead of passive complaining."
        ),
        QuestionModel(
            id = "s_9_eng_8_7",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Who composed the reflective poem 'It Never Comes Again'?",
            options = listOf("Richard Henry Stoddard", "Henry Wadsworth Longfellow", "Walt Whitman", "Ralph Waldo Emerson"),
            correctAnswer = "Richard Henry Stoddard",
            explanation = "The poem 'It Never Comes Again' was penned by the 19th-century American poet Richard Henry Stoddard."
        ),
        QuestionModel(
            id = "s_9_eng_8_8",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Fill in the blank: 'There are gains for all our losses, there are _________ for all our pain.'",
            options = listOf("balms", "rewards", "excuses", "sorrows"),
            correctAnswer = "balms",
            explanation = "The opening couplet observes: 'There are gains for all our losses, / There are balms for all our pain.'"
        ),
        QuestionModel(
            id = "s_9_eng_8_9",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "According to Stoddard, what departs from our lives and never comes again?",
            options = listOf(
                "Youth, the sweet dream of innocence and carefree joy",
                "Material wealth and royal treasure",
                "The spring season of nature",
                "The morning sunrise"
            ),
            correctAnswer = "Youth, the sweet dream of innocence and carefree joy",
            explanation = "The poet laments that when youth departs, it takes something precious from our hearts that never returns."
        ),
        QuestionModel(
            id = "s_9_eng_8_10",
            stdId = 9,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Though adulthood brings greater strength and wisdom under manhood's reign, what do we forever miss?",
            options = listOf(
                "The sweet, fresh, and magical wonder of youth",
                "The ability to sleep without dreaming",
                "Having nothing to do all day",
                "Childhood toys and games"
            ),
            correctAnswer = "The sweet, fresh, and magical wonder of youth",
            explanation = "The poem reflects that despite the strength of adulthood, the pure sweetness of youthful spirit is lost forever."
        ),

        // ========================================================
        // 🟦 UNIT 9 – SUPPLEMENTARY READING
        // ========================================================
        QuestionModel(
            id = "s_9_eng_9_1",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "By what affectionate title is Aruna Asaf Ali revered in the Indian Independence Movement?",
            options = listOf(
                "The Grand Old Lady of the Independence Movement",
                "The Nightingale of India",
                "The Iron Lady of India",
                "The Queen of Jhansi"
            ),
            correctAnswer = "The Grand Old Lady of the Independence Movement",
            explanation = "Aruna Asaf Ali is reverently known as the 'Grand Old Lady of the Independence Movement' and 'Heroine of 1942'."
        ),
        QuestionModel(
            id = "s_9_eng_9_2",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What daring historic act did Aruna Asaf Ali perform on 9th August 1942 at Gowalia Tank Maidan, Bombay?",
            options = listOf(
                "She hoisted the Indian National Congress tricolor flag amidst tear gas and police lathis",
                "She stormed the British Viceroy's palace",
                "She hijacked a British warship in Bombay harbor",
                "She destroyed the railway lines to Delhi"
            ),
            correctAnswer = "She hoisted the Indian National Congress tricolor flag amidst tear gas and police lathis",
            explanation = "Defying British arrest orders during Quit India, she unfurled the national tricolor at Gowalia Tank Maidan."
        ),
        QuestionModel(
            id = "s_9_eng_9_3",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Which underground newspaper did Aruna Asaf Ali publish along with Ram Manohar Lohia during Quit India?",
            options = listOf("Inquilab", "Young India", "Harijan", "Kesari"),
            correctAnswer = "Inquilab",
            explanation = "Operating underground to evade British warrants, she published the revolutionary monthly journal 'Inquilab'."
        ),
        QuestionModel(
            id = "s_9_eng_9_4",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What civic position was Aruna Asaf Ali elected to in 1958?",
            options = listOf("First Mayor of Delhi", "Chief Minister of Uttar Pradesh", "Governor of Bombay", "President of the Red Cross"),
            correctAnswer = "First Mayor of Delhi",
            explanation = "In 1958, Aruna Asaf Ali was elected as the very first Mayor of Delhi."
        ),
        QuestionModel(
            id = "s_9_eng_9_5",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "In the folk tale 'The Happy Cure', what mysterious ailment struck the King?",
            options = listOf(
                "Severe melancholy and boredom, feeling ill despite no physical disease",
                "A burning tropical fever",
                "Loss of vision and hearing",
                "A broken arm caused by a fall from his horse"
            ),
            correctAnswer = "Severe melancholy and boredom, feeling ill despite no physical disease",
            explanation = "The pampered King believed he was dying of an incurable disease, though physicians found him physically sound."
        ),
        QuestionModel(
            id = "s_9_eng_9_6",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What unusual remedy did the wise old physician prescribe to cure the unhappy King?",
            options = listOf(
                "To sleep for one night wearing the shirt of an entirely happy man",
                "To drink water from the holy river Nile",
                "To fast for forty days in a cave",
                "To give away his royal crown to the poorest citizen"
            ),
            correctAnswer = "To sleep for one night wearing the shirt of an entirely happy man",
            explanation = "The doctor advised that wearing the shirt of a truly happy man for a single night would transfer pure happiness to the King."
        ),
        QuestionModel(
            id = "s_9_eng_9_7",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "When royal couriers searched the kingdom, why were the rich merchants and courtiers unable to provide a shirt?",
            options = listOf(
                "Every person they met had some worry, grievance, fear, or unsatisfied craving",
                "All the shirts in the city had been purchased by the army",
                "No citizen was allowed to possess linen shirts",
                "The merchants hid their clothes in underground vaults"
            ),
            correctAnswer = "Every person they met had some worry, grievance, fear, or unsatisfied craving",
            explanation = "Even the wealthiest and most powerful individuals harbored anxieties, greed, or jealousies."
        ),
        QuestionModel(
            id = "s_9_eng_9_8",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "When the couriers finally found a poor singing laborer who claimed he was 100% happy, what surprising fact did they discover?",
            options = listOf(
                "The happy man was so poor that he possessed no shirt at all!",
                "The happy man refused to speak to royal messengers",
                "The happy man was wearing a shirt made of pure gold",
                "The happy man was the King's own long-lost brother"
            ),
            correctAnswer = "The happy man was so poor that he possessed no shirt at all!",
            explanation = "The laborer was completely happy with his simple life, but he owned no shirt, proving happiness comes from inner contentment."
        ),
        QuestionModel(
            id = "s_9_eng_9_9",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Who is the author of the delightful sports story 'Ranji's Wonderful Bat'?",
            options = listOf("Ruskin Bond", "R. K. Narayan", "Mulk Raj Anand", "Vikram Seth"),
            correctAnswer = "Ruskin Bond",
            explanation = "The renowned Indian-born author Ruskin Bond wrote 'Ranji's Wonderful Bat'."
        ),
        QuestionModel(
            id = "s_9_eng_9_10",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Why was young Ranji disheartened and dropped from his school cricket team?",
            options = listOf(
                "He scored zero (a duck) and low scores in three consecutive matches",
                "He was caught cheating by the umpire",
                "He arrived two hours late for the tournament match",
                "He injured his knee while bowling"
            ),
            correctAnswer = "He scored zero (a duck) and low scores in three consecutive matches",
            explanation = "Ranji was deeply dejected after failing to score runs and being relegated to twelfth man."
        ),
        QuestionModel(
            id = "s_9_eng_9_11",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Who gave Ranji the 'lucky' bat that revived his batting confidence?",
            options = listOf(
                "Mr. Kumar, the friendly sports shop owner and former Ranji Trophy cricketer",
                "His school cricket coach Mr. Sharma",
                "His grandfather who was a colonel",
                "The captain of the rival team"
            ),
            correctAnswer = "Mr. Kumar, the friendly sports shop owner and former Ranji Trophy cricketer",
            explanation = "Mr. Kumar gifted Ranji an old bat, encouraging him by saying it was a lucky century-scoring bat."
        ),
        QuestionModel(
            id = "s_9_eng_9_12",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What score did Ranji achieve in his next match playing with the bat given by Mr. Kumar?",
            options = listOf("An unbeaten 58 runs", "A quick 15 runs", "Exactly 100 runs", "A single boundary"),
            correctAnswer = "An unbeaten 58 runs",
            explanation = "Energized with fresh confidence, Ranji struck boundaries all over the ground and scored 58 not out."
        ),
        QuestionModel(
            id = "s_9_eng_9_13",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "When Ranji lost the bat in a bus and became desperate, what vital truth did Mr. Kumar reveal?",
            options = listOf(
                "The magic was never in the wooden bat, but in Ranji's own eyes, wrists, and self-belief",
                "That Mr. Kumar had a hundred more magic bats in stock",
                "That Ranji should immediately quit playing cricket",
                "That the bat had been cursed by a magician"
            ),
            correctAnswer = "The magic was never in the wooden bat, but in Ranji's own eyes, wrists, and self-belief",
            explanation = "Mr. Kumar explained that a bat is merely wood; true power and skill reside inside the player's confidence."
        ),
        QuestionModel(
            id = "s_9_eng_9_14",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "In Mark Twain's classic story 'Monday Morning', why did Tom Sawyer dread Monday mornings?",
            options = listOf(
                "Because Monday morning began another week's slow suffering and imprisonment in school",
                "Because he had to wash the entire backyard fence every Monday",
                "Because he had to take bitter medicine every Monday morning",
                "Because his aunt forced him to fast on Mondays"
            ),
            correctAnswer = "Because Monday morning began another week's slow suffering and imprisonment in school",
            explanation = "Tom always found Monday mornings miserable because it meant leaving freedom for classroom confinement."
        ),
        QuestionModel(
            id = "s_9_eng_9_15",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What physical ailment did Tom initially consider feigning to stay away from school?",
            options = listOf(
                "A loose upper tooth and a sore toe",
                "A broken arm and high fever",
                "Loss of eyesight in both eyes",
                "Severe chest pain and cough"
            ),
            correctAnswer = "A loose upper tooth and a sore toe",
            explanation = "Tom remembered his loose upper front tooth, but feared Aunt Polly would yank it out, so he focused on his sore toe."
        ),
        QuestionModel(
            id = "s_9_eng_9_16",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "How did Tom awaken his sleeping half-brother Sid to create a theatrical spectacle?",
            options = listOf(
                "He produced loud, heart-rending groans and pretended to be on his deathbed",
                "He splashed a bucket of cold water over Sid's head",
                "He set off firecrackers under Sid's bed",
                "He called the village doctor into the bedroom"
            ),
            correctAnswer = "He produced loud, heart-rending groans and pretended to be on his deathbed",
            explanation = "Tom groaned in agony, gasping that he was dying and forgiving everyone, which panicked Sid."
        ),
        QuestionModel(
            id = "s_9_eng_9_17",
            stdId = 9,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "How did Aunt Polly extract Tom's loose tooth once she saw through his school-skipping trick?",
            options = listOf(
                "She tied one end of a silk thread to the tooth, the other to the bedpost, and thrust a burning chunk of fire near his face",
                "She took him to the town dental surgeon with heavy forceps",
                "She gave him hard apples to bite into",
                "She pulled it out with her bare fingers while he was asleep"
            ),
            correctAnswer = "She tied one end of a silk thread to the tooth, the other to the bedpost, and thrust a burning chunk of fire near his face",
            explanation = "Aunt Polly tied silk thread between the tooth and bedpost, flicked a hot coal at him, and Tom jerked back, leaving the tooth dangling."
        ),

        // ========================================================
        // 🟦 UNIT 10 – GRAMMAR, VOCABULARY & LANGUAGE IN USE
        // ========================================================
        QuestionModel(
            id = "s_9_eng_10_1",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Identify the part of speech of the word 'bravely' in: 'The soldiers fought bravely on the mountain battlefield.'",
            options = listOf("Adverb", "Adjective", "Noun", "Preposition"),
            correctAnswer = "Adverb",
            explanation = "'Bravely' describes how the soldiers fought, modifying the verb 'fought', which makes it an adverb of manner."
        ),
        QuestionModel(
            id = "s_9_eng_10_2",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Choose the correct preposition to complete the sentence: 'The courageous athlete jumped _________ the pool to rescue the child.'",
            options = listOf("into", "onto", "in", "above"),
            correctAnswer = "into",
            explanation = "'Into' denotes movement towards the inside of something (entering the water)."
        ),
        QuestionModel(
            id = "s_9_eng_10_3",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Fill in the blank with the appropriate tense: 'Neither the teacher nor the students _________ present in the auditorium yesterday.'",
            options = listOf("were", "was", "is", "are"),
            correctAnswer = "were",
            explanation = "When subjects are joined by 'neither... nor', the verb agrees with the nearer subject ('students' is plural, so 'were' in past tense)."
        ),
        QuestionModel(
            id = "s_9_eng_10_4",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Convert into Passive Voice: 'The Yaksha asked Yudhishthira many philosophical questions.'",
            options = listOf(
                "Yudhishthira was asked many philosophical questions by the Yaksha.",
                "Many philosophical questions had asked Yudhishthira by the Yaksha.",
                "Yudhishthira is being asked many philosophical questions by the Yaksha.",
                "The Yaksha was asked many questions by Yudhishthira."
            ),
            correctAnswer = "Yudhishthira was asked many philosophical questions by the Yaksha.",
            explanation = "Simple past active 'asked' transforms into 'was asked' with Yudhishthira as the subject."
        ),
        QuestionModel(
            id = "s_9_eng_10_5",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Select the correct Question Tag: 'Kapil Dev captained India to world cup victory, _________?'",
            options = listOf("didn't he", "did he", "wasn't he", "doesn't he"),
            correctAnswer = "didn't he",
            explanation = "The statement is affirmative in simple past ('captained'), so the tag must be negative: 'didn't he?'."
        ),
        QuestionModel(
            id = "s_9_eng_10_6",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Identify the Figure of Speech in the line: 'His mighty brothers lay dead like fallen flagstaffs beside the water.'",
            options = listOf("Simile", "Metaphor", "Personification", "Hyperbole"),
            correctAnswer = "Simile",
            explanation = "A comparison using 'like' ('like fallen flagstaffs') is a Simile."
        ),
        QuestionModel(
            id = "s_9_eng_10_7",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Identify the Figure of Speech in: 'Words are the food and dress of thought.'",
            options = listOf("Metaphor", "Simile", "Irony", "Alliteration"),
            correctAnswer = "Metaphor",
            explanation = "Directly identifying words as food and dress without using 'like' or 'as' is a Metaphor."
        ),
        QuestionModel(
            id = "s_9_eng_10_8",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Choose the correct antonym of the word 'BENEVOLENT' as demonstrated by the Bishop of Digne:",
            options = listOf("Malevolent", "Generous", "Kind", "Righteous"),
            correctAnswer = "Malevolent",
            explanation = "'Benevolent' means kind and well-meaning; its direct antonym is 'malevolent' (wishing evil to others)."
        ),
        QuestionModel(
            id = "s_9_eng_10_9",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Select the one-word substitute for: 'A person who does not believe in the existence of God.'",
            options = listOf("Atheist", "Theist", "Agnostic", "Ascetic"),
            correctAnswer = "Atheist",
            explanation = "An atheist is one who disbelieves or lacks belief in the existence of God or gods."
        ),
        QuestionModel(
            id = "s_9_eng_10_10",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Select the one-word substitute for: 'One who sacrifices his life for the sake of his country.'",
            options = listOf("Martyr", "Patriot", "Mercenary", "Traitor"),
            correctAnswer = "Martyr",
            explanation = "A martyr is a person who suffers death rather than renounce his cause or religion or country."
        ),
        QuestionModel(
            id = "s_9_eng_10_11",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Change the degree of comparison: 'Mount Everest is higher than any other peak in the world.' (Into Superlative Degree)",
            options = listOf(
                "Mount Everest is the highest peak in the world.",
                "Mount Everest is as high as all peaks in the world.",
                "No other peak is as high as Mount Everest in the world.",
                "Mount Everest is very high among world peaks."
            ),
            correctAnswer = "Mount Everest is the highest peak in the world.",
            explanation = "Comparative 'higher than any other peak' converts into superlative 'the highest peak'."
        ),
        QuestionModel(
            id = "s_9_eng_10_12",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Choose the correctly spelled word:",
            options = listOf("Pestilence", "Pestalence", "Pestelence", "Pestillence"),
            correctAnswer = "Pestilence",
            explanation = "The correct spelling is 'P-E-S-T-I-L-E-N-C-E', meaning a fatal epidemic disease."
        ),
        QuestionModel(
            id = "s_9_eng_10_13",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Identify the correct Indirect Speech: 'The Bishop said to Jean Valjean, \"You belong no longer to evil, but to good.\"'",
            options = listOf(
                "The Bishop told Jean Valjean that he belonged no longer to evil, but to good.",
                "The Bishop said Jean Valjean that you belonged no longer to evil, but to good.",
                "The Bishop told to Jean Valjean that he has belonged to evil and good.",
                "The Bishop asked Jean Valjean if he belongs to good."
            ),
            correctAnswer = "The Bishop told Jean Valjean that he belonged no longer to evil, but to good.",
            explanation = "Present tense 'belong' changes to past tense 'belonged', and second person pronoun 'you' changes to third person 'he'."
        ),
        QuestionModel(
            id = "s_9_eng_10_14",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Fill in the blank with the appropriate modal verb: 'We _________ respect our national flag and constitution under all circumstances.'",
            options = listOf("ought to", "might", "could", "would"),
            correctAnswer = "ought to",
            explanation = "'Ought to' expresses moral obligation and duty towards civic and constitutional values."
        ),
        QuestionModel(
            id = "s_9_eng_10_15",
            stdId = 9,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "What is the collective noun for a collection of ships or warships?",
            options = listOf("Fleet", "Flock", "Herd", "Swarm"),
            correctAnswer = "Fleet",
            explanation = "A group of ships or warships under one command or sailing together is called a 'fleet'."
        )
    )
}
