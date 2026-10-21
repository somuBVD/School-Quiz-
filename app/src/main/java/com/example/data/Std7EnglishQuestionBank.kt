package com.example.data

/**
 * Standard 7 English (LBA Revised 2026-27, 7thEnglishLBARevised_1787048371.pdf)
 * Authentic Question Bank containing prose and poem MCQs across all units.
 */
object Std7EnglishQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Healthy Life & The Gymnastic Clock", 17, "Easy"),
        UnitTemplate(2, "Unit 2: Avoid Plastics & Awareness", 12, "Medium"),
        UnitTemplate(3, "Unit 3: Ekalavya & Why God Made Teachers", 12, "Medium"),
        UnitTemplate(4, "Unit 4: Leg Trap & Froth and Bubble", 10, "Medium"),
        UnitTemplate(5, "Unit 5: The Wonder Bowl & Abou Ben Adhem", 14, "Medium"),
        UnitTemplate(6, "Unit 6: Journey to the Top & Mountain Climbing", 10, "Hard"),
        UnitTemplate(7, "Unit 7: A Nest with Grand Parents & Dear Grandma", 10, "Easy"),
        UnitTemplate(8, "Unit 8: Wealth and Values & The Quarrel", 12, "Medium")
    )

    val questions: List<QuestionModel> = listOf(
        // ========================================================
        // 🟦 UNIT 1: Healthy Life (Prose) & The Gymnastic Clock (Poem)
        // ========================================================
        QuestionModel(
            id = "s_7_eng_u1_1",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "One who drinks the potion would lose the desire to",
            options = listOf("die", "play", "live", "work"),
            correctAnswer = "live",
            explanation = "According to the story 'Healthy Life', drinking the evil potion caused people to lose their desire to live active and cheerful lives."
        ),
        QuestionModel(
            id = "s_7_eng_u1_2",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "While collecting energy, a witch made a mistake in",
            options = listOf("collecting resources", "uttering words", "destroying forest", "making potion"),
            correctAnswer = "uttering words",
            explanation = "While chanting to focus the evil spell's energy, one witch made a mistake in uttering the words."
        ),
        QuestionModel(
            id = "s_7_eng_u1_3",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "All the witches were changed into tiny creatures like",
            options = listOf("germs", "snails", "monsters", "animals"),
            correctAnswer = "germs",
            explanation = "The explosion that resulted from the mistake trapped all the witches, turning them into tiny microscopic germs."
        ),
        QuestionModel(
            id = "s_7_eng_u1_4",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The doctor could understand that witches could not tolerate",
            options = listOf("joy and happy life", "wellbeing", "patience", "torture"),
            correctAnswer = "joy and happy life",
            explanation = "Dr. Fitton-Healthy realized that the tiny germs (the witches) could not survive in people who enjoyed health, joy, and active happy lives."
        ),
        QuestionModel(
            id = "s_7_eng_u1_5",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "In the lesson 'Healthy Life', the result of the explosion was that",
            options = listOf("The forest was burned completely", "The witches were trapped as germs in a bottle", "All animals died", "The potion disappeared"),
            correctAnswer = "The witches were trapped as germs in a bottle",
            explanation = "The explosion destroyed the witches' stronghold and compressed them into tiny germs trapped inside a glass bottle."
        ),
        QuestionModel(
            id = "s_7_eng_u1_6",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Who discovered the cure and the truth about the wasting disease?",
            options = listOf("Dr. Fitton-Healthy", "Dr. Watson", "A forest fairy", "The village chief"),
            correctAnswer = "Dr. Fitton-Healthy",
            explanation = "Dr. Fitton-Healthy conducted research using his microscope and found the cure to eliminate the germ witches."
        ),
        QuestionModel(
            id = "s_7_eng_u1_7",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What was the remedy prescribed by Dr. Fitton-Healthy to stay immune?",
            options = listOf("Sleeping all day", "Eating fruits, vegetables, and playing outdoor games", "Taking bitter medicines forever", "Staying inside closed rooms"),
            correctAnswer = "Eating fruits, vegetables, and playing outdoor games",
            explanation = "Healthy nutritious food, fresh air, physical exercise, and a cheerful attitude destroyed the witches."
        ),
        QuestionModel(
            id = "s_7_eng_u1_8",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Where were the witches preparing their dangerous black potion?",
            options = listOf("In a modern lab", "In a deep, dark forest in a cauldron", "In a school classroom", "On a ship at sea"),
            correctAnswer = "In a deep, dark forest in a cauldron",
            explanation = "The witches gathered together in the forest around a huge cauldron to prepare the potion."
        ),
        QuestionModel(
            id = "s_7_eng_u1_9",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What effect did the germ have on children and adults who were infected?",
            options = listOf("They became superhuman", "They felt lazy, sad, and wanted to eat only junk food", "They could fly", "They became invisible"),
            correctAnswer = "They felt lazy, sad, and wanted to eat only junk food",
            explanation = "The germ made infected individuals crave unhealthy food, avoid fresh vegetables, and stay inactive."
        ),
        QuestionModel(
            id = "s_7_eng_u1_10",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The author of the prose lesson 'Healthy Life' is",
            options = listOf("Pedro Pablo Sacristan", "R.K. Narayan", "Ruskin Bond", "M.C. Davies"),
            correctAnswer = "Pedro Pablo Sacristan",
            explanation = "'Healthy Life' was written by the renowned children's author Pedro Pablo Sacristan."
        ),
        QuestionModel(
            id = "s_7_eng_u1_11",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "In 'The Gymnastic Clock', what does the little clock say every morning?",
            options = listOf("\"Go to sleep!\"", "\"Don't forget your exercises!\"", "\"Time to eat!\"", "\"Run away!\""),
            correctAnswer = "\"Don't forget your exercises!\"",
            explanation = "The clock greets the poet every morning with the reminder: 'Don't forget your exercises!'"
        ),
        QuestionModel(
            id = "s_7_eng_u1_12",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "How does the clock perform its exercises in the poem?",
            options = listOf("By jumping up and down", "By swinging both its hands", "By ringing loud bells", "By rolling on the floor"),
            correctAnswer = "By swinging both its hands",
            explanation = "The clock exercises by moving and swinging both of its hands round and round."
        ),
        QuestionModel(
            id = "s_7_eng_u1_13",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What does the poet do in response to the clock's movements?",
            options = listOf("Swings his arms above his head", "Throws a pillow at it", "Turns off the alarm", "Leaves the house"),
            correctAnswer = "Swings his arms above his head",
            explanation = "The poet copies the clock, raising and swinging both arms above his head."
        ),
        QuestionModel(
            id = "s_7_eng_u1_14",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What does the poet say to the clock regarding boasting?",
            options = listOf("\"You boast too much\"", "\"I can swing my arms just like you, but I don't boast\"", "\"I am stronger than you\"", "\"You are too small\""),
            correctAnswer = "\"I can swing my arms just like you, but I don't boast\"",
            explanation = "The poet playfully says that he can exercise just like the clock without bragging or boasting."
        ),
        QuestionModel(
            id = "s_7_eng_u1_15",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Who is the poet of 'The Gymnastic Clock'?",
            options = listOf("M.C. Davies", "William Wordsworth", "Robert Frost", "T.S. Eliot"),
            correctAnswer = "M.C. Davies",
            explanation = "The poem 'The Gymnastic Clock' was written by M.C. Davies."
        ),
        QuestionModel(
            id = "s_7_eng_u1_16",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "The literary device where the clock is given human qualities like speaking and exercising is called",
            options = listOf("Personification", "Metaphor", "Simile", "Alliteration"),
            correctAnswer = "Personification",
            explanation = "Attributing human traits such as talking and exercising to an inanimate object like a clock is personification."
        ),
        QuestionModel(
            id = "s_7_eng_u1_17",
            stdId = 7,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What is the central moral lesson taught by Unit 1?",
            options = listOf("Health, discipline, and daily exercise are essential for a happy life", "Clocks should be kept silent", "Witches always win", "Studying without rest is best"),
            correctAnswer = "Health, discipline, and daily exercise are essential for a happy life",
            explanation = "Both 'Healthy Life' and 'The Gymnastic Clock' emphasize physical fitness, nutritious eating, and regular exercise."
        ),

        // ========================================================
        // 🟦 UNIT 2: Avoid Plastics (Prose) & Awareness (Poem)
        // ========================================================
        QuestionModel(
            id = "s_7_eng_u2_1",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Why has plastic become so universally popular in daily life?",
            options = listOf("It is cheap, lightweight, and durable", "It dissolves quickly in water", "It is made of edible plants", "It costs more than gold"),
            correctAnswer = "It is cheap, lightweight, and durable",
            explanation = "Plastic is widely used because it is lightweight, waterproof, inexpensive, and easily molded into shapes."
        ),
        QuestionModel(
            id = "s_7_eng_u2_2",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What is the biggest environmental hazard associated with plastic?",
            options = listOf("It is non-biodegradable and takes hundreds of years to decompose", "It tastes sweet", "It is very heavy", "It attracts rain"),
            correctAnswer = "It is non-biodegradable and takes hundreds of years to decompose",
            explanation = "Plastics do not decay naturally through microbial action, causing long-term pollution in soil and oceans."
        ),
        QuestionModel(
            id = "s_7_eng_u2_3",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Burning plastic waste is hazardous to health because it releases",
            options = listOf("Toxic fumes, dioxins, and carcinogens", "Pure oxygen", "Pleasant fragrance", "Harmless steam"),
            correctAnswer = "Toxic fumes, dioxins, and carcinogens",
            explanation = "Incinerating plastic releases deadly toxic gases that contaminate the air and cause respiratory ailments."
        ),
        QuestionModel(
            id = "s_7_eng_u2_4",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What happens to stray cattle and animals when they consume plastic garbage?",
            options = listOf("They become stronger", "They choke and suffer fatal intestinal blockage", "They digest it easily", "They gain weight safely"),
            correctAnswer = "They choke and suffer fatal intestinal blockage",
            explanation = "Cows and other animals ingest plastic bags discarded with food leftovers, causing painful deaths from blocked intestines."
        ),
        QuestionModel(
            id = "s_7_eng_u2_5",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Which eco-friendly alternatives should we carry when shopping?",
            options = listOf("Cloth bags, jute bags, and paper bags", "Single-use thin polythene", "Styrofoam boxes", "Plastic sheets"),
            correctAnswer = "Cloth bags, jute bags, and paper bags",
            explanation = "Bags made from cotton cloth, jute, or recycled paper are biodegradable and reusable."
        ),
        QuestionModel(
            id = "s_7_eng_u2_6",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What are the essential '4 Rs' in environmental waste management?",
            options = listOf("Refuse, Reduce, Reuse, Recycle", "Read, Remember, Revise, Repeat", "Run, Rest, Return, Race", "React, Repair, Retain, Realize"),
            correctAnswer = "Refuse, Reduce, Reuse, Recycle",
            explanation = "The 4 Rs principle helps minimize environmental pollution: Refuse single-use plastics, Reduce usage, Reuse containers, and Recycle scrap."
        ),
        QuestionModel(
            id = "s_7_eng_u2_7",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "How does plastic buried in the ground damage the soil and groundwater?",
            options = listOf("It prevents rainwater from percolating into the aquifers", "It adds rich nutrients to crops", "It cools the underground soil", "It purifies well water"),
            correctAnswer = "It prevents rainwater from percolating into the aquifers",
            explanation = "Impermeable plastic layers form an artificial barrier that stops rainwater percolation, lowering the groundwater table."
        ),
        QuestionModel(
            id = "s_7_eng_u2_8",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "In the poem 'Awareness', what is the poet's main concern?",
            options = listOf("Destruction of nature and environmental pollution", "Lack of playground facilities", "The price of vegetables", "Travelling to foreign countries"),
            correctAnswer = "Destruction of nature and environmental pollution",
            explanation = "The poem 'Awareness' issues a passionate warning about environmental destruction and human indifference."
        ),
        QuestionModel(
            id = "s_7_eng_u2_9",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "According to the poet in 'Awareness', why are trees being ruthlessly cut down?",
            options = listOf("Due to human greed and commercialization", "Because birds requested it", "To allow sunlight for rocks", "Because trees are harmful"),
            correctAnswer = "Due to human greed and commercialization",
            explanation = "Deforestation is driven by human greed, industrialization, and unchecked commercial development."
        ),
        QuestionModel(
            id = "s_7_eng_u2_10",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What has polluted our once pristine rivers and lakes according to 'Awareness'?",
            options = listOf("Industrial effluents and plastic garbage", "Fallen flower petals", "Fresh rain showers", "Fish swimming in water"),
            correctAnswer = "Industrial effluents and plastic garbage",
            explanation = "Water bodies are choked with untreated chemical wastes, sewage, and non-biodegradable plastics."
        ),
        QuestionModel(
            id = "s_7_eng_u2_11",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What call to action does the poem 'Awareness' give to mankind?",
            options = listOf("Wake up and protect Mother Earth before it is too late", "Build more concrete buildings", "Ignore the environment", "Cut down remaining forests"),
            correctAnswer = "Wake up and protect Mother Earth before it is too late",
            explanation = "The poet urges every human being to develop ecological awareness and safeguard our planet for future generations."
        ),
        QuestionModel(
            id = "s_7_eng_u2_12",
            stdId = 7,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "The opposite (antonym) of the word 'degrade' in environmental context is",
            options = listOf("Preserve / Restore", "Destroy", "Pollute", "Damage"),
            correctAnswer = "Preserve / Restore",
            explanation = "Degradation means deterioration; its antonym is preservation or restoration."
        ),

        // ========================================================
        // 🟦 UNIT 3: Ekalavya (Prose) & Why God Made Teachers (Poem)
        // ========================================================
        QuestionModel(
            id = "s_7_eng_u3_1",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Who was Ekalavya's father in the epic Mahabharata?",
            options = listOf("Hiranyadhanus, the Nishada chieftain", "Dronacharya", "King Shantanu", "Bhishma"),
            correctAnswer = "Hiranyadhanus, the Nishada chieftain",
            explanation = "Ekalavya was the prince of the Nishada forest tribe, the son of King Hiranyadhanus."
        ),
        QuestionModel(
            id = "s_7_eng_u3_2",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Whom did Ekalavya approach to learn archery and martial sciences?",
            options = listOf("Guru Dronacharya", "Lord Krishna", "Guru Parashurama", "Kripacharya"),
            correctAnswer = "Guru Dronacharya",
            explanation = "Ekalavya approached Guru Dronacharya, the master teacher of archery to the Kuru princes."
        ),
        QuestionModel(
            id = "s_7_eng_u3_3",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Why did Dronacharya decline to accept Ekalavya as his direct student?",
            options = listOf("He had committed to teach only royal Kshatriya princes", "Ekalavya had no bow", "Ekalavya came too late", "Drona had stopped teaching"),
            correctAnswer = "He had committed to teach only royal Kshatriya princes",
            explanation = "Dronacharya was the royal tutor for the Pandavas and Kauravas, bound by his duty to teach exclusively royal Kshatriyas."
        ),
        QuestionModel(
            id = "s_7_eng_u3_4",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "After being rejected, how did Ekalavya practice archery in the forest?",
            options = listOf("He sculpted a clay idol of Dronacharya and practiced before it with dedication", "He gave up archery forever", "He went to a foreign country", "He fought with birds"),
            correctAnswer = "He sculpted a clay idol of Dronacharya and practiced before it with dedication",
            explanation = "Ekalavya made a clay statue of Dronacharya, worshiped it as his master, and practiced archery diligently every day."
        ),
        QuestionModel(
            id = "s_7_eng_u3_5",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "How did Ekalavya silence the barking hunting dog in the forest?",
            options = listOf("He shot seven arrows into its open mouth without hurting it", "He threw a rock at it", "He tied the dog to a tree", "He ran away in fear"),
            correctAnswer = "He shot seven arrows into its open mouth without hurting it",
            explanation = "Ekalavya displayed marvelous skill by filling the barking dog's mouth with arrows in rapid succession without causing any injury."
        ),
        QuestionModel(
            id = "s_7_eng_u3_6",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What promise had Guru Drona given to Prince Arjuna?",
            options = listOf("That no archer in the entire world would surpass him", "That he would make Arjuna emperor", "That he would give Arjuna a golden chariot", "That Arjuna would never have to fight"),
            correctAnswer = "That no archer in the entire world would surpass him",
            explanation = "Drona had promised Arjuna that he would be the greatest and unmatched archer on earth."
        ),
        QuestionModel(
            id = "s_7_eng_u3_7",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What Guru Dakshina (fee) did Dronacharya demand from Ekalavya?",
            options = listOf("His right thumb", "A chest of jewels", "His golden bow", "A royal elephant"),
            correctAnswer = "His right thumb",
            explanation = "To fulfill his vow to Arjuna, Dronacharya asked Ekalavya for his right thumb as Guru Dakshina."
        ),
        QuestionModel(
            id = "s_7_eng_u3_8",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "How did Ekalavya react when Dronacharya asked for his right thumb?",
            options = listOf("He instantly severed it with a smile and placed it at Drona's feet", "He refused angrily", "He ran away into the jungle", "He challenged Drona to a duel"),
            correctAnswer = "He instantly severed it with a smile and placed it at Drona's feet",
            explanation = "Ekalavya did not hesitate for a second; his supreme devotion to his Guru made him offer his thumb gladly."
        ),
        QuestionModel(
            id = "s_7_eng_u3_9",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "According to the poem 'Why God Made Teachers', what is the purpose of teachers?",
            options = listOf("To guide children, provide wisdom, and nurture their dreams", "To give homework and punish them", "To earn high salaries", "To build classrooms"),
            correctAnswer = "To guide children, provide wisdom, and nurture their dreams",
            explanation = "The poem describes teachers as divine instruments created to guide children with patience, wisdom, and loving encouragement."
        ),
        QuestionModel(
            id = "s_7_eng_u3_10",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "In the poem 'Why God Made Teachers', teachers are compared to",
            options = listOf("Guiding lights and gentle companions", "Strict prison wardens", "Silent statues", "Distant mountains"),
            correctAnswer = "Guiding lights and gentle companions",
            explanation = "Teachers show the right path like a beacon of light and help students develop confidence and character."
        ),
        QuestionModel(
            id = "s_7_eng_u3_11",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "The quality that best defines Ekalavya in world literature is",
            options = listOf("Unmatched guru-bhakti (devotion to teacher) and dedication", "Arrogance and anger", "Deceit and trickery", "Cowardice"),
            correctAnswer = "Unmatched guru-bhakti (devotion to teacher) and dedication",
            explanation = "Ekalavya remains the eternal symbol of unshakeable loyalty, discipline, and reverence towards one's teacher."
        ),
        QuestionModel(
            id = "s_7_eng_u3_12",
            stdId = 7,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What is the past tense of the irregular verb 'shoot'?",
            options = listOf("Shot", "Shooted", "Shooting", "Shoten"),
            correctAnswer = "Shot",
            explanation = "The past tense form of the verb 'shoot' is 'shot' (shoot -> shot -> shot)."
        ),

        // ========================================================
        // 🟦 UNIT 4: Leg Trap (Prose) & Froth and Bubble (Poem)
        // ========================================================
        QuestionModel(
            id = "s_7_eng_u4_1",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In the story 'Leg Trap', which sport is passionately played by Dhiraj and his friends?",
            options = listOf("Football (Soccer)", "Cricket", "Basketball", "Hockey"),
            correctAnswer = "Football (Soccer)",
            explanation = "The exciting school sports story 'Leg Trap' centers around an inter-school football match."
        ),
        QuestionModel(
            id = "s_7_eng_u4_2",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "What conflict did Dhiraj face at home regarding his love for football?",
            options = listOf("His parents wanted him to prioritize his studies and exams", "He didn't have shoes", "He wasn't allowed to eat dinner", "He had no teammates"),
            correctAnswer = "His parents wanted him to prioritize his studies and exams",
            explanation = "Dhiraj's parents were worried that his excessive devotion to football would affect his academic performance."
        ),
        QuestionModel(
            id = "s_7_eng_u4_3",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "What football technique is referred to by the term 'trap'?",
            options = listOf("Controlling and bringing the moving ball under instant control with one's foot", "Tripping an opponent player", "Catching the ball with hands", "Kicking the goalpost"),
            correctAnswer = "Controlling and bringing the moving ball under instant control with one's foot",
            explanation = "In football, 'trapping' is the skill of cushioning and controlling a passed or airborne ball with the feet or chest."
        ),
        QuestionModel(
            id = "s_7_eng_u4_4",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "How did Dhiraj prove himself to his parents and his school team?",
            options = listOf("By balancing good academic grades while leading his team to sports victory", "By quitting school", "By blaming his coach", "By refusing to practice"),
            correctAnswer = "By balancing good academic grades while leading his team to sports victory",
            explanation = "Dhiraj showed that discipline allows a student to excel both in classroom studies and on the sports field."
        ),
        QuestionModel(
            id = "s_7_eng_u4_5",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Who wrote the famous poem 'Froth and Bubble'?",
            options = listOf("Adam Lindsay Gordon", "M.C. Davies", "Eleanor Farjeon", "Leigh Hunt"),
            correctAnswer = "Adam Lindsay Gordon",
            explanation = "The poem 'Froth and Bubble' was composed by the Australian poet Adam Lindsay Gordon."
        ),
        QuestionModel(
            id = "s_7_eng_u4_6",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Complete the famous lines: \"Question not, but live and labour, till your goal be won, / Helping every weaker neighbour...\"",
            options = listOf("\"Seeking help from none\"", "\"Fighting till the noon\"", "\"Playing under the sun\"", "\"Sleeping till afternoon\""),
            correctAnswer = "\"Seeking help from none\"",
            explanation = "The poem advises selfless action, helping our neighbours without demanding or expecting help in return."
        ),
        QuestionModel(
            id = "s_7_eng_u4_7",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "According to the poet in 'Froth and Bubble', what two noble virtues stand like solid stone?",
            options = listOf("Kindness in another's trouble and Courage in your own", "Wealth and Fame", "Strength and Anger", "Pride and Beauty"),
            correctAnswer = "Kindness in another's trouble and Courage in your own",
            explanation = "\"Two things stand like stone: / Kindness in another's trouble, / Courage in your own.\""
        ),
        QuestionModel(
            id = "s_7_eng_u4_8",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "What does the metaphor 'Life is mostly froth and bubble' signify?",
            options = listOf("Most worldly pleasures and worries are temporary and fleeting", "Life is full of soap water", "Life cannot be lived", "Bubbles are very heavy"),
            correctAnswer = "Most worldly pleasures and worries are temporary and fleeting",
            explanation = "'Froth and bubble' symbolizes that ephemeral and superficial things fade quickly like bubbles on water."
        ),
        QuestionModel(
            id = "s_7_eng_u4_9",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "The word 'Kindness' belongs to which part of speech?",
            options = listOf("Abstract Noun", "Verb", "Adjective", "Preposition"),
            correctAnswer = "Abstract Noun",
            explanation = "'Kindness' is an abstract noun derived from the adjective 'kind'."
        ),
        QuestionModel(
            id = "s_7_eng_u4_10",
            stdId = 7,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "What message does Unit 4 give to young students?",
            options = listOf("Cultivate sportsmanship, hard work, kindness to others, and courage in adversity", "Avoid all sports", "Focus only on selfish gains", "Never help friends in need"),
            correctAnswer = "Cultivate sportsmanship, hard work, kindness to others, and courage in adversity",
            explanation = "The unit inspires youth to combine determination in sports and studies with moral courage and compassion."
        ),

        // ========================================================
        // 🟦 UNIT 5: The Wonder Bowl (Prose) & Abou Ben Adhem (Poem)
        // ========================================================
        QuestionModel(
            id = "s_7_eng_u5_1",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "From whom did Yudhishthira receive the magical vessel known as the 'Akshaya Patra' (The Wonder Bowl)?",
            options = listOf("Surya (The Sun God)", "Indra", "Agni", "Varuna"),
            correctAnswer = "Surya (The Sun God)",
            explanation = "While the Pandavas were in exile in the forest, Surya gave Yudhishthira the divine Akshaya Patra."
        ),
        QuestionModel(
            id = "s_7_eng_u5_2",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What was the unique boon of the Akshaya Patra?",
            options = listOf("It supplied unlimited food until Draupadi finished her meal for the day", "It turned stones into gold", "It gave eternal youth", "It predicted the future"),
            correctAnswer = "It supplied unlimited food until Draupadi finished her meal for the day",
            explanation = "The Akshaya Patra provided unlimited food each day to feed any number of guests, but became empty once Draupadi ate and washed it."
        ),
        QuestionModel(
            id = "s_7_eng_u5_3",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Which quick-tempered sage arrived at the Pandavas' hermitage along with thousands of disciples?",
            options = listOf("Sage Durvasa", "Sage Vashistha", "Sage Vishwamitra", "Sage Valmiki"),
            correctAnswer = "Sage Durvasa",
            explanation = "Sage Durvasa, notorious for his terrible temper and fiery curses, visited the Pandavas demanding food for his disciples."
        ),
        QuestionModel(
            id = "s_7_eng_u5_4",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Why was Draupadi terrified when Sage Durvasa asked for food?",
            options = listOf("She had already eaten and cleaned the bowl, so no food could come from it that day", "There was no fire in the kitchen", "The bowl was stolen", "She did not want to cook"),
            correctAnswer = "She had already eaten and cleaned the bowl, so no food could come from it that day",
            explanation = "Since Draupadi had already finished her meal and washed the vessel, the Akshaya Patra was exhausted for the day."
        ),
        QuestionModel(
            id = "s_7_eng_u5_5",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Whom did Draupadi pray to in her desperation?",
            options = listOf("Lord Krishna", "Brahma", "Yama", "Shiva"),
            correctAnswer = "Lord Krishna",
            explanation = "In deep distress and fearing Durvasa's curse, Draupadi prayed fervently to Lord Krishna for divine protection."
        ),
        QuestionModel(
            id = "s_7_eng_u5_6",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What did Lord Krishna find clinging to the rim of the washed bowl?",
            options = listOf("A single tiny grain of rice / vegetable leaf", "A gold coin", "A drop of milk", "A flower petal"),
            correctAnswer = "A single tiny grain of rice / vegetable leaf",
            explanation = "Krishna inspected the bowl and found a single tiny leaf of greens / morsel of food sticking to the rim."
        ),
        QuestionModel(
            id = "s_7_eng_u5_7",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What happened when Krishna ate that single morsel with satisfaction?",
            options = listOf("Sage Durvasa and all his disciples felt completely full and satiated", "A feast appeared on the grass", "Durvasa got furious", "The river dried up"),
            correctAnswer = "Sage Durvasa and all his disciples felt completely full and satiated",
            explanation = "Krishna's satisfaction satisfied the hunger of the entire universe, making Durvasa and his followers feel full and belch with satiety."
        ),
        QuestionModel(
            id = "s_7_eng_u5_8",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Who wrote the timeless poem 'Abou Ben Adhem'?",
            options = listOf("Leigh Hunt", "John Keats", "Lord Byron", "Percy Bysshe Shelley"),
            correctAnswer = "Leigh Hunt",
            explanation = "The inspirational narrative poem 'Abou Ben Adhem' was written by the English poet Leigh Hunt."
        ),
        QuestionModel(
            id = "s_7_eng_u5_9",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What was the angel in Abou Ben Adhem's moonlit bedroom writing in?",
            options = listOf("A book of gold", "A roll of parchment", "A silver tablet", "A diary of stone"),
            correctAnswer = "A book of gold",
            explanation = "The angel was described as writing in a book of gold in a room bright as a lily in bloom."
        ),
        QuestionModel(
            id = "s_7_eng_u5_10",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What was the angel recording in the golden book?",
            options = listOf("The names of those who love the Lord", "The list of wealthy merchants", "The history of kings", "The prayers of priests"),
            correctAnswer = "The names of those who love the Lord",
            explanation = "The angel explained: 'The names of those who love the Lord.'"
        ),
        QuestionModel(
            id = "s_7_eng_u5_11",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "When the angel said Abou's name was not among them, what did Abou request?",
            options = listOf("\"Write me as one that loves his fellow men\"", "\"Erase all other names\"", "\"Leave me alone\"", "\"Give me wealth instead\""),
            correctAnswer = "\"Write me as one that loves his fellow men\"",
            explanation = "Abou cheerfully and humbly asked: 'I pray thee then, write me as one that loves his fellow men.'"
        ),
        QuestionModel(
            id = "s_7_eng_u5_12",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "On the following night, what did the angel's book reveal to Abou?",
            options = listOf("Abou's name led all the rest who were blessed by God's love", "Abou's name was deleted", "The book was blank", "The angel had left forever"),
            correctAnswer = "Abou's name led all the rest who were blessed by God's love",
            explanation = "\"And lo! Ben Adhem's name led all the rest!\""
        ),
        QuestionModel(
            id = "s_7_eng_u5_13",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What profound moral does 'Abou Ben Adhem' convey to humanity?",
            options = listOf("True love for God is best expressed through loving and serving one's fellow human beings", "God only loves monks", "Angels visit everyone nightly", "Wealth brings divine blessings"),
            correctAnswer = "True love for God is best expressed through loving and serving one's fellow human beings",
            explanation = "Service to humanity ('Manava Seve') is the purest form of service and devotion to God ('Madhava Seve')."
        ),
        QuestionModel(
            id = "s_7_eng_u5_14",
            stdId = 7,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Choose the correct synonym of the word 'exceeding' as used in \"an angel writing with exceeding peace\":",
            options = listOf("Extremely great / immense", "Very small", "Noisy", "Angry"),
            correctAnswer = "Extremely great / immense",
            explanation = "'Exceeding' in archaic and literary English means immense, surpassing, or extraordinary."
        ),

        // ========================================================
        // 🟦 UNIT 6: Journey to the Top (Prose) & Mountain Climbing (Poem)
        // ========================================================
        QuestionModel(
            id = "s_7_eng_u6_1",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Whose courageous journey to conquer Mount Everest is celebrated in 'Journey to the Top'?",
            options = listOf("Bachendri Pal", "Kalpana Chawla", "Sunita Williams", "P.T. Usha"),
            correctAnswer = "Bachendri Pal",
            explanation = "Bachendri Pal made history in 1984 as the first Indian woman to reach the summit of Mount Everest."
        ),
        QuestionModel(
            id = "s_7_eng_u6_2",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What is the height of Mount Everest, the highest peak in the world?",
            options = listOf("8,848.86 metres", "7,500 metres", "6,200 metres", "9,500 metres"),
            correctAnswer = "8,848.86 metres",
            explanation = "Mount Everest in the Himalayas stands at 8,848.86 metres above sea level."
        ),
        QuestionModel(
            id = "s_7_eng_u6_3",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Which institute did Bachendri Pal train at before attempting the Everest expedition?",
            options = listOf("Nehru Institute of Mountaineering (NIM), Uttarkashi", "National Sports Academy, Delhi", "Himalayan Ski Club, Shimla", "Army War College, Mhow"),
            correctAnswer = "Nehru Institute of Mountaineering (NIM), Uttarkashi",
            explanation = "She received rigorous mountaineering training at the prestigious Nehru Institute of Mountaineering in Uttarkashi."
        ),
        QuestionModel(
            id = "s_7_eng_u6_4",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What terrifying obstacle struck Bachendri Pal's camp at Camp III on the mountain slope?",
            options = listOf("A severe midnight avalanche and crushing ice-fall", "A forest fire", "A tiger attack", "A flash flood"),
            correctAnswer = "A severe midnight avalanche and crushing ice-fall",
            explanation = "A massive avalanche buried her camp under tons of frozen snow; she was heroically dug out by teammates."
        ),
        QuestionModel(
            id = "s_7_eng_u6_5",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "On which date did Bachendri Pal successfully stand atop Mount Everest?",
            options = listOf("23rd May 1984", "15th August 1947", "26th January 1950", "2nd October 1989"),
            correctAnswer = "23rd May 1984",
            explanation = "On 23 May 1984 at 1:07 pm, Bachendri Pal reached the highest point on Earth."
        ),
        QuestionModel(
            id = "s_7_eng_u6_6",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What did Bachendri Pal place at the summit as an offering of devotion and patriotism?",
            options = listOf("The Indian National Tricolour and an image of Goddess Durga", "A golden plate", "Her sleeping bag", "A climbing rope"),
            correctAnswer = "The Indian National Tricolour and an image of Goddess Durga",
            explanation = "She hoisted the Indian flag, bowed her head in prayer, and placed an image of Goddess Durga in the snow."
        ),
        QuestionModel(
            id = "s_7_eng_u6_7",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "In the poem 'Mountain Climbing', what does ascending the steep peak symbolize?",
            options = listOf("Overcoming life's struggles through resilience, effort, and courage", "Running away from work", "Catching wild eagles", "Finding hidden gems"),
            correctAnswer = "Overcoming life's struggles through resilience, effort, and courage",
            explanation = "The arduous climb represents human tenacity and overcoming obstacles to reach the heights of achievement."
        ),
        QuestionModel(
            id = "s_7_eng_u6_8",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What breathtaking sight greets the climber from the mountain summit?",
            options = listOf("A sweeping panoramic vista of endless clouds, sunlit valleys, and horizons", "Dark caves with bats", "A crowded market square", "An empty wall"),
            correctAnswer = "A sweeping panoramic vista of endless clouds, sunlit valleys, and horizons",
            explanation = "Standing on the pinnacle rewards the mountaineer with an exhilarating, majestic view of nature."
        ),
        QuestionModel(
            id = "s_7_eng_u6_9",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "The prefix added to 'possible' to make its opposite meaning is",
            options = listOf("im- (impossible)", "un-", "dis-", "mis-"),
            correctAnswer = "im- (impossible)",
            explanation = "The prefix 'im-' attaches to root words starting with p, b, or m: possible -> impossible."
        ),
        QuestionModel(
            id = "s_7_eng_u6_10",
            stdId = 7,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What key leadership lesson does Bachendri Pal's achievement offer to young girls?",
            options = listOf("No summit is too high if one has self-belief, courage, and perseverance", "Girls should never attempt adventurous sports", "Success comes without training", "Mountaineering is too easy"),
            correctAnswer = "No summit is too high if one has self-belief, courage, and perseverance",
            explanation = "Bachendri Pal proved that determination, hard work, and unshakeable confidence break all gender barriers."
        ),

        // ========================================================
        // 🟦 UNIT 7: A Nest with Grand Parents (Prose) & Dear Grandma and Grandpa (Poem)
        // ========================================================
        QuestionModel(
            id = "s_7_eng_u7_1",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Why is the grandparents' home lovingly referred to as a 'nest' in the lesson?",
            options = listOf("Because it provides warmth, unconditional love, safety, and shelter to children", "Because it is built on high tree branches", "Because it is made of twigs and straw", "Because birds reside inside every room"),
            correctAnswer = "Because it provides warmth, unconditional love, safety, and shelter to children",
            explanation = "Just like a mother bird's nest nurtures baby birds, grandparents provide children with tender care, joy, and emotional comfort."
        ),
        QuestionModel(
            id = "s_7_eng_u7_2",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What did the visiting grandchildren look forward to most during their vacation at their grandparents' house?",
            options = listOf("Delicious home-cooked traditional food and fascinating bedtime stories", "Playing video games all night", "Attending tuition classes", "Cleaning the backyard"),
            correctAnswer = "Delicious home-cooked traditional food and fascinating bedtime stories",
            explanation = "Children cherish the heartwarming tales, affectionate attention, and mouth-watering meals prepared by their grandparents."
        ),
        QuestionModel(
            id = "s_7_eng_u7_3",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What moral values and virtues do grandparents pass on to growing children?",
            options = listOf("Compassion, respect for elders, patience, and cultural roots", "Selfishness and arrogance", "Wastefulness of money", "Anger and impatience"),
            correctAnswer = "Compassion, respect for elders, patience, and cultural roots",
            explanation = "Grandparents impart priceless cultural values, moral principles, and wisdom through life experiences."
        ),
        QuestionModel(
            id = "s_7_eng_u7_4",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "How should family members treat elderly grandparents in their golden years?",
            options = listOf("With empathy, reverence, patient listening, and healthcare support", "By ignoring their needs", "By keeping them in solitude", "By treating them as a burden"),
            correctAnswer = "With empathy, reverence, patient listening, and healthcare support",
            explanation = "Elders deserve our deepest gratitude, love, respect, and attentive companionship."
        ),
        QuestionModel(
            id = "s_7_eng_u7_5",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "In 'Dear Grandma and Grandpa', how do grandparents listen to the children's little stories?",
            options = listOf("With sparkling eyes, smiling warmth, and infinite patience", "By covering their ears", "With boredom and hurry", "By interrupting them angrily"),
            correctAnswer = "With sparkling eyes, smiling warmth, and infinite patience",
            explanation = "The poem illustrates how grandparents always have time to listen tenderly to every little story a child shares."
        ),
        QuestionModel(
            id = "s_7_eng_u7_6",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Grandparents' gentle touch and hugs are described as",
            options = listOf("A comforting blanket of pure love and blessings", "Cold and distant", "Strict and frightening", "Heavy and painful"),
            correctAnswer = "A comforting blanket of pure love and blessings",
            explanation = "Grandparents' affection reassures children and builds feelings of deep emotional security."
        ),
        QuestionModel(
            id = "s_7_eng_u7_7",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What role do grandparents play in modern nuclear families?",
            options = listOf("They bridge generations and keep traditional cultural wisdom alive", "They only watch television", "They increase household expenses", "They have no connection with kids"),
            correctAnswer = "They bridge generations and keep traditional cultural wisdom alive",
            explanation = "Grandparents act as the vital pillar connecting modern generations with heritage, family history, and deep values."
        ),
        QuestionModel(
            id = "s_7_eng_u7_8",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Identify the adjective in the sentence: \"The loving grandmother baked sweet cookies.\"",
            options = listOf("Loving and sweet", "Grandmother and cookies", "Baked", "The and was"),
            correctAnswer = "Loving and sweet",
            explanation = "'Loving' describes grandmother, and 'sweet' describes cookies; both are adjectives."
        ),
        QuestionModel(
            id = "s_7_eng_u7_9",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "The compound word formed by joining 'grand' and 'parents' is",
            options = listOf("Grandparents", "Grand parents", "Parentgrand", "Grandfatherparent"),
            correctAnswer = "Grandparents",
            explanation = "'Grandparents' is a closed compound noun formed by combining the prefix 'grand' and the noun 'parents'."
        ),
        QuestionModel(
            id = "s_7_eng_u7_10",
            stdId = 7,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What emotional message does Unit 7 leave in the hearts of young learners?",
            options = listOf("Cherish, respect, and spend quality time with elders in the family", "Elderly people don't understand kids", "Only money matters in relationships", "Never visit the countryside"),
            correctAnswer = "Cherish, respect, and spend quality time with elders in the family",
            explanation = "The unit inspires students to value family bonds, care for their elders, and appreciate grandparents' blessings."
        ),

        // ========================================================
        // 🟦 UNIT 8: Wealth and Values (Prose) & The Quarrel (Poem)
        // ========================================================
        QuestionModel(
            id = "s_7_eng_u8_1",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "In the lesson 'Wealth and Values', what is defined as the real and lasting treasure of human life?",
            options = listOf("Moral character, integrity, humility, and good deeds", "Huge bank balances and silver palaces", "Diamond necklaces and sports cars", "Winning expensive lotteries"),
            correctAnswer = "Moral character, integrity, humility, and good deeds",
            explanation = "Material wealth comes and goes, but upright character, empathy, and truthfulness remain eternal values."
        ),
        QuestionModel(
            id = "s_7_eng_u8_2",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Why was the wealthy merchant in the story unhappy despite his mountains of gold?",
            options = listOf("He lacked true friends, peace of mind, and compassionate values", "He wanted more gold than the king", "His house was too small", "He had no clothes to wear"),
            correctAnswer = "He lacked true friends, peace of mind, and compassionate values",
            explanation = "Money without empathy or ethical values breeds suspicion, isolation, and loneliness."
        ),
        QuestionModel(
            id = "s_7_eng_u8_3",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What can money buy, and what can it NOT buy?",
            options = listOf("It can buy a bed, but not sleep; food, but not appetite; medicine, but not health", "It can buy everything in heaven and earth", "It cannot buy a pencil", "It buys true love and genuine happiness"),
            correctAnswer = "It can buy a bed, but not sleep; food, but not appetite; medicine, but not health",
            explanation = "Money buys physical commodities, but peace of mind, affection, honesty, and health cannot be bought."
        ),
        QuestionModel(
            id = "s_7_eng_u8_4",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "How does giving and sharing help a person according to 'Wealth and Values'?",
            options = listOf("It multiplies inner joy and enriches both the giver and the receiver", "It makes a person poorer every day", "It wastes money without purpose", "It makes people laugh at you"),
            correctAnswer = "It multiplies inner joy and enriches both the giver and the receiver",
            explanation = "Generosity and selfless sharing bring fulfillment that material hoarding can never match."
        ),
        QuestionModel(
            id = "s_7_eng_u8_5",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Who is the poet of the famous poem 'The Quarrel'?",
            options = listOf("Eleanor Farjeon", "M.C. Davies", "Adam Lindsay Gordon", "Leigh Hunt"),
            correctAnswer = "Eleanor Farjeon",
            explanation = "'The Quarrel' is a delightful, relatable poem composed by Eleanor Farjeon."
        ),
        QuestionModel(
            id = "s_7_eng_u8_6",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "With whom did the speaker in 'The Quarrel' have an argument?",
            options = listOf("Her brother", "Her school teacher", "Her next-door neighbour", "Her pet dog"),
            correctAnswer = "Her brother",
            explanation = "\"I quarreled with my brother / I don't know what about...\""
        ),
        QuestionModel(
            id = "s_7_eng_u8_7",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "How did the quarrel start and how did it grow?",
            options = listOf("\"The start of it was slight, the end of it was strong\"", "\"It started with a fierce fight from the first minute\"", "\"It started with tears and ended in silence\"", "\"It started over a broken bicycle\""),
            correctAnswer = "\"The start of it was slight, the end of it was strong\"",
            explanation = "The disagreement started over a small, trivial matter but quickly escalated into a heated argument."
        ),
        QuestionModel(
            id = "s_7_eng_u8_8",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "How was the sibling quarrel finally resolved in the evening?",
            options = listOf("The brother thumped her on the back and said they couldn't go on hating all night", "Their mother locked them in a room", "They never spoke again", "A judge solved their dispute"),
            correctAnswer = "The brother thumped her on the back and said they couldn't go on hating all night",
            explanation = "\"Then suddenly my brother / Thumped me on the back, / And said, 'Oh, come along! / We can't go on all night...'\""
        ),
        QuestionModel(
            id = "s_7_eng_u8_9",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Why did the poet concede that her brother was 'in the right' in the end?",
            options = listOf("Because he was mature and brave enough to break the ego barrier and apologize first", "Because he won the arm-wrestling contest", "Because he gave her chocolate", "Because he was older"),
            correctAnswer = "Because he was mature and brave enough to break the ego barrier and apologize first",
            explanation = "By stepping forward to reconcile and take the blame, the brother demonstrated nobility of heart."
        ),
        QuestionModel(
            id = "s_7_eng_u8_10",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What universal truth about family relationships does 'The Quarrel' illustrate?",
            options = listOf("Trivial arguments are common between siblings, but love and reconciliation always triumph", "Siblings must always fight", "Brothers are never wrong", "Fights should last for years"),
            correctAnswer = "Trivial arguments are common between siblings, but love and reconciliation always triumph",
            explanation = "Disagreements are natural among loved ones, but holding grudges is harmful; forgiving and reconnecting restores harmony."
        ),
        QuestionModel(
            id = "s_7_eng_u8_11",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What is the antonym of the word 'quarrel'?",
            options = listOf("Agreement / Harmony", "Argument", "Conflict", "Dispute"),
            correctAnswer = "Agreement / Harmony",
            explanation = "'Quarrel' means an angry dispute; its antonym is agreement, peace, or harmony."
        ),
        QuestionModel(
            id = "s_7_eng_u8_12",
            stdId = 7,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What is the ultimate message of the 7th English curriculum across all units?",
            options = listOf("Develop physical health, environmental responsibility, devotion to teachers, moral courage, compassion, and brotherly harmony", "Only score marks in examinations without values", "Avoid learning English grammar", "Stay in isolation"),
            correctAnswer = "Develop physical health, environmental responsibility, devotion to teachers, moral courage, compassion, and brotherly harmony",
            explanation = "The curriculum aims at holistic character building, moral values, linguistic proficiency, and social empathy."
        )
    )
}
