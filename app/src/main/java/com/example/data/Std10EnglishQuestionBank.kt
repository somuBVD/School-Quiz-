package com.example.data

/**
 * Standard 10 - Second Language English (SSLC Karnataka Curriculum & LBA Revised Question Bank)
 * 
 * Sourced and constructed from Karnataka SSLC 10th Standard English (Second Language) curriculum:
 *  - Prose 1: A Hero (R. K. Narayan)
 *  - Prose 2: There's a Girl by the Tracks! (Devanur Mahadeva / Rama Sachidanand)
 *  - Prose 3: Gentleman of Rio en Medio (Juan A. A. Sedillo)
 *  - Prose 4: Dr. B. R. Ambedkar (Sri R. Venkataraman)
 *  - Prose 5: The Concert (Shantha Rameshwar Rao)
 *  - Prose 6: The Discovery (Herman Ould)
 *  - Prose 7: Colours of Silence (National Book Trust)
 *  - Prose 8: Science and Hope of Survival (V. I. Keilis-Borok)
 *  - Poem 1: Grandma Climbs a Tree (Ruskin Bond)
 *  - Poem 2: Quality of Mercy (William Shakespeare)
 *  - Poem 3: I am the Land (Marina de Bellagente)
 *  - Poem 4: The Song of India (V. K. Gokak)
 *  - Poem 5: Jazz Poem Two (Carl Wendall Hines, Jr.)
 *  - Poem 6: Ballad of the Tempest (James T. Fields)
 *  - Poem 7: The Blind Boy (Colley Cibber)
 *  - Poem 8: Off to Outer Space Tomorrow Morning (Norman Nicholson)
 *  - Supplementary 1: Narayanpur Incident (Diti Sen)
 *  - Supplementary 2: On Top of the World (Dickey Dolma)
 *  - Supplementary 3: A Great Martyr Ever Cherished (Vipin / Major Padmapani Acharya)
 *  - Supplementary 4: The Bird of Happiness (Tibetan Folktale)
 *  - Unit 21: Grammar, Vocabulary & Language Study (Collocations, Syllabification, Prefixes, Tags, Functions, etc.)
 *
 * Fully covers textual MCQs, converted fill-in-the-blanks, and converted 1-mark questions.
 * All duplicates omitted; all picture-based questions omitted; 100% text-based 4-option MCQs.
 */
object Std10EnglishQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Prose 1: A Hero", 11, "Easy"),
        UnitTemplate(2, "Prose 2: There's a Girl by the Tracks!", 11, "Medium"),
        UnitTemplate(3, "Prose 3: Gentleman of Rio en Medio", 10, "Medium"),
        UnitTemplate(4, "Prose 4: Dr. B. R. Ambedkar", 10, "Medium"),
        UnitTemplate(5, "Prose 5: The Concert", 10, "Medium"),
        UnitTemplate(6, "Prose 6: The Discovery", 10, "Hard"),
        UnitTemplate(7, "Prose 7: Colours of Silence", 10, "Medium"),
        UnitTemplate(8, "Prose 8: Science and Hope of Survival", 10, "Medium"),
        UnitTemplate(9, "Poem 1: Grandma Climbs a Tree", 10, "Easy"),
        UnitTemplate(10, "Poem 2: Quality of Mercy", 10, "Medium"),
        UnitTemplate(11, "Poem 3: I am the Land", 10, "Medium"),
        UnitTemplate(12, "Poem 4: The Song of India", 10, "Medium"),
        UnitTemplate(13, "Poem 5: Jazz Poem Two", 10, "Medium"),
        UnitTemplate(14, "Poem 6: Ballad of the Tempest", 10, "Medium"),
        UnitTemplate(15, "Poem 7: The Blind Boy", 10, "Easy"),
        UnitTemplate(16, "Poem 8: Off to Outer Space Tomorrow Morning", 10, "Easy"),
        UnitTemplate(17, "Supplementary 1: Narayanpur Incident", 10, "Medium"),
        UnitTemplate(18, "Supplementary 2: On Top of the World", 10, "Medium"),
        UnitTemplate(19, "Supplementary 3: A Great Martyr Ever Cherished", 10, "Hard"),
        UnitTemplate(20, "Supplementary 4: The Bird of Happiness", 10, "Medium"),
        UnitTemplate(21, "Grammar, Vocabulary & Language Study", 11, "Hard")
    )

    val questions: List<QuestionModel> = listOf(
        // ========================================================
        // 🟦 UNIT 1 – PROSE 1: A HERO
        // ========================================================
        QuestionModel(
            id = "s_10_eng_1_1",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Swami's father read a newspaper report about a village lad who had:",
            options = listOf("Saved a child from drowning in a river", "Fought face-to-face with a tiger while returning home", "Caught a notorious burglar in a mansion", "Won a medal for bravery in athletics"),
            correctAnswer = "Fought face-to-face with a tiger while returning home",
            explanation = "The newspaper report described a village boy who confronted a tiger and stayed on a tree until villagers killed it."
        ),
        QuestionModel(
            id = "s_10_eng_1_2",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "According to Swami's father, which quality is more important than strength and age?",
            options = listOf("Courage", "Discipline", "Physical power", "Intelligence"),
            correctAnswer = "Courage",
            explanation = "Swami's father argued that courage is everything, asserting that strength and age are not important if a man has courage."
        ),
        QuestionModel(
            id = "s_10_eng_1_3",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "To test his courage, what challenge did Swami's father give him?",
            options = listOf("To swim across the local river", "To sleep alone that night in the office room", "To go alone to the market at midnight", "To walk through the jungle by himself"),
            correctAnswer = "To sleep alone that night in the office room",
            explanation = "Swami's father challenged him to sleep alone in his office room to overcome his fear of the dark."
        ),
        QuestionModel(
            id = "s_10_eng_1_4",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Where did Swami usually sleep every night before his father's challenge?",
            options = listOf("In his own bedroom with friends", "Beside his grandmother in the passage", "Under the dining table in the hall", "On the rooftop terrace"),
            correctAnswer = "Beside his grandmother in the passage",
            explanation = "Swami was accustomed to sleeping beside his granny in the passage, tucked safely under a blanket."
        ),
        QuestionModel(
            id = "s_10_eng_1_5",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Fill in the blank: Swami found sleeping in his father's office room terrifying because he remembered all the stories of _________ he had heard.",
            options = listOf("wild animals and beasts", "devils and ghosts", "robbers and dacoits", "foreign wars and battles"),
            correctAnswer = "devils and ghosts",
            explanation = "In the dark office room, Swami recalled eerie stories of ghosts and devils, such as the devil by the river."
        ),
        QuestionModel(
            id = "s_10_eng_1_6",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Where did Swami find the most safe and compact spot to sleep inside the office room?",
            options = listOf("On his father's wooden desk", "Under the wooden bench", "Behind the office door", "Near the open window"),
            correctAnswer = "Under the wooden bench",
            explanation = "Swami spread his sheet and lay under the bench, feeling it was a much safer, compact, and reassuring haven."
        ),
        QuestionModel(
            id = "s_10_eng_1_7",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What terrifying nightmare did Swami have while asleep under the bench?",
            options = listOf("He was falling off a high mountain cliff", "A tiger was chasing him and his feet refused to move", "He was caught in a deep ocean whirlpool", "A ghost was pulling him by his hair"),
            correctAnswer = "A tiger was chasing him and his feet refused to move",
            explanation = "Swami dreamt a ferocious tiger was pursuing him, clawing the ground, while his feet were stuck to the earth."
        ),
        QuestionModel(
            id = "s_10_eng_1_8",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "When Swami saw a dark shape moving in the office room, what did he do to defend himself?",
            options = listOf("He screamed loudly for his grandmother", "He threw his heavy brass bell at it", "He bit into its ankle with all his teeth", "He ran out through the back door"),
            correctAnswer = "He bit into its ankle with all his teeth",
            explanation = "Believing it was a devil coming to tear him apart, Swami crawled out, hugged the creature, and dug his teeth into its leg."
        ),
        QuestionModel(
            id = "s_10_eng_1_9",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "Who was the intruder that Swami bitten in the dark?",
            options = listOf("A harmless stray dog", "His father playing a practical joke", "One of the most notorious house-breakers of the district", "A wandering street acrobat"),
            correctAnswer = "One of the most notorious house-breakers of the district",
            explanation = "The person Swami bit was a notorious burglar wanted by the police in several crimes."
        ),
        QuestionModel(
            id = "s_10_eng_1_10",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What did the Police Inspector suggest Swami should become when he grew up?",
            options = listOf("A police officer", "An engine driver", "A magistrate", "A lawyer"),
            correctAnswer = "A police officer",
            explanation = "Impressed by his courage in apprehending the burglar, the Police Inspector invited Swami to join the police."
        ),
        QuestionModel(
            id = "s_10_eng_1_11",
            stdId = 10,
            subjectId = "english",
            unitId = 1,
            type = "MCQ",
            questionText = "What did Swami secretly desire to become in life, rather than joining the police force?",
            options = listOf("An army general or captain", "An engine driver, railway guard, or bus conductor", "A school headmaster or clerk", "A sea captain or pilot"),
            correctAnswer = "An engine driver, railway guard, or bus conductor",
            explanation = "Though he politely agreed to the inspector's suggestion, Swami secretly wanted to be an engine driver, guard, or bus conductor."
        ),
        // ========================================================
        // 🟦 UNIT 2 – PROSE 2: THERE'S A GIRL BY THE TRACKS!
        // ========================================================
        QuestionModel(
            id = "s_10_eng_2_1",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Who was Roma Talreja and what was her occupation?",
            options = listOf("A 21-year-old call centre executive in Mumbai", "A college student from Pune", "A hospital nurse at Divine Multispeciality", "A train ticket examiner on Central Railway"),
            correctAnswer = "A 21-year-old call centre executive in Mumbai",
            explanation = "Roma Talreja was a 21-year-old B.Com graduate working as a call centre executive in Malad, Mumbai."
        ),
        QuestionModel(
            id = "s_10_eng_2_2",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "How did Roma Talreja fall from the moving Mumbai suburban electric train?",
            options = listOf("She slipped while jumping onto a platform", "She was pushed by rowdy commuters", "Due to intense rush-hour overcrowding, she lost her foothold near the open door", "She tripped over a vendor's cart"),
            correctAnswer = "Due to intense rush-hour overcrowding, she lost her foothold near the open door",
            explanation = "Roma was squeezed by the evening rush crowd near the door, lost her balance, and plummeted onto the tracks."
        ),
        QuestionModel(
            id = "s_10_eng_2_3",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Who was Baleshwar Mishra and why had he come to Mumbai?",
            options = listOf("A medical intern seeking training", "A 20-year-old high school dropout from Mirzapur seeking a job", "A police constable posted at Thane", "A commuter on his way to Pune"),
            correctAnswer = "A 20-year-old high school dropout from Mirzapur seeking a job",
            explanation = "Baleshwar Mishra was an unemployed young man from Uttar Pradesh who had come to Mumbai in search of employment."
        ),
        QuestionModel(
            id = "s_10_eng_2_4",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What immediate action did Baleshwar take upon spotting a girl lying beside the railway tracks?",
            options = listOf("He shouted for the station master", "He pulled the red emergency brake handle and jumped onto the tracks", "He recorded the accident on his mobile phone", "He ran to the next carriage to inform railway guards"),
            correctAnswer = "He pulled the red emergency brake handle and jumped onto the tracks",
            explanation = "Without hesitation, Baleshwar pulled the emergency chain and leapt off the moving train to rescue her."
        ),
        QuestionModel(
            id = "s_10_eng_2_5",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Fill in the blank: When Baleshwar carried Roma to the arterial road and pleaded for help, the passing motorists _________.",
            options = listOf("stopped immediately to assist", "refused to slow down and drove past", "called an ambulance for them", "took them to a nearby police station"),
            correctAnswer = "refused to slow down and drove past",
            explanation = "Vehicles sped past callously, unwilling to get involved in an accident victim's emergency."
        ),
        QuestionModel(
            id = "s_10_eng_2_6",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Who finally stopped to help Baleshwar transport the injured Roma to a hospital?",
            options = listOf("A local traffic constable", "A middle-aged Gujarati tempo-truck driver", "A taxi driver returning from Thane", "An autorickshaw driver from Kurla"),
            correctAnswer = "A middle-aged Gujarati tempo-truck driver",
            explanation = "A kind-hearted Gujarati truck driver pulled over and offered his vehicle to rush Roma to medical help."
        ),
        QuestionModel(
            id = "s_10_eng_2_7",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Why was Roma shifted from the small clinic in Nerul/Ghansoli to Divine Multispeciality Hospital?",
            options = listOf("The clinic had no doctors on duty", "The small clinic lacked the specialized equipment needed for critical head trauma", "The hospital bill was too expensive at the clinic", "Roma's brother Dinesh demanded a private ward"),
            correctAnswer = "The small clinic lacked the specialized equipment needed for critical head trauma",
            explanation = "The clinic doctor gave first aid but advised transferring her immediately because of severe head injuries."
        ),
        QuestionModel(
            id = "s_10_eng_2_8",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Which doctor admitted Roma immediately at Divine Multispeciality Hospital without demanding paperwork or money?",
            options = listOf("Dr. Anil Agarwal", "Dr. Sadanand Rao", "Dr. B. R. Sharma", "Dr. Sudheer Talreja"),
            correctAnswer = "Dr. Anil Agarwal",
            explanation = "Dr. Anil Agarwal admitted Roma into the ICU immediately and performed emergency surgery without delay."
        ),
        QuestionModel(
            id = "s_10_eng_2_9",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "How did Baleshwar contact Roma's family to inform them of the accident?",
            options = listOf("He found her brother's phone number stored in her cell phone", "He checked her employee ID card for a landline number", "He posted an emergency alert on social media", "He asked the police to locate her address"),
            correctAnswer = "He found her brother's phone number stored in her cell phone",
            explanation = "Roma feebly whispered her brother Dinesh's phone number, and Baleshwar dialed him using Roma's phone."
        ),
        QuestionModel(
            id = "s_10_eng_2_10",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "Complete the sentence: Baleshwar believed that people in Mumbai avoided helping road and rail victims mainly because they _________.",
            options = listOf("lacked money to pay bills", "were afraid of police inquiries and court hassles", "did not know the local language", "were indifferent to human suffering"),
            correctAnswer = "were afraid of police inquiries and court hassles",
            explanation = "Baleshwar noted that bystanders feared legal entanglements and police questioning if they assisted accident victims."
        ),
        QuestionModel(
            id = "s_10_eng_2_11",
            stdId = 10,
            subjectId = "english",
            unitId = 2,
            type = "MCQ",
            questionText = "What was Roma's reaction when she regained consciousness and learned about Baleshwar's selfless rescue?",
            options = listOf("She felt embarrassed about falling", "She expressed profound gratitude and wondered how a stranger could risk his life for her", "She blamed the railway authorities bitterly", "She requested a transfer out of Mumbai"),
            correctAnswer = "She expressed profound gratitude and wondered how a stranger could risk his life for her",
            explanation = "Roma was deeply moved, realizing she would have died on the cold ballast without Baleshwar's timely bravery."
        ),
        // ========================================================
        // 🟦 UNIT 3 – PROSE 3: GENTLEMAN OF RIO EN MEDIO
        // ========================================================
        QuestionModel(
            id = "s_10_eng_3_1",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "How is Don Anselmo's physical appearance and attire described in the story?",
            options = listOf("He wore a modern business suit with a gold watch", "He wore an old faded green Prince Albert coat, gloves with holes, and carried an umbrella-like cane", "He dressed in traditional cowboy boots and leather jacket", "He wore simple cotton work clothes of a farm labourer"),
            correctAnswer = "He wore an old faded green Prince Albert coat, gloves with holes, and carried an umbrella-like cane",
            explanation = "Don Anselmo arrived in an antique, faded green Prince Albert coat, frayed gloves, carrying the skeleton of an umbrella as a cane."
        ),
        QuestionModel(
            id = "s_10_eng_3_2",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What was the initial agreed price for Don Anselmo's ancestral orchard in Rio en Medio?",
            options = listOf("Six hundred dollars", "Twelve hundred dollars ($1,200)", "Twenty-four hundred dollars ($2,400)", "Five thousand dollars"),
            correctAnswer = "Twelve hundred dollars ($1,200)",
            explanation = "The preliminary agreement agreed to sell the property for twelve hundred dollars in cash."
        ),
        QuestionModel(
            id = "s_10_eng_3_3",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What did the land surveyor discover when he surveyed Don Anselmo's land?",
            options = listOf("The property was encroached by neighbouring ranches", "The land was more than eight acres, nearly double the original estimate", "The orchard had no water rights from the creek", "The land was smaller than three acres"),
            correctAnswer = "The land was more than eight acres, nearly double the original estimate",
            explanation = "The surveyor found that the tract extended to more than eight acres, almost twice the four acres originally thought."
        ),
        QuestionModel(
            id = "s_10_eng_3_4",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What generous offer did the American buyers make upon discovering the larger acreage?",
            options = listOf("To build a new home for Don Anselmo", "To pay double the money—twenty-four hundred dollars ($2,400)", "To grant Don Anselmo lifetime farming rights", "To share fifty percent of future crop harvests"),
            correctAnswer = "To pay double the money—twenty-four hundred dollars ($2,400)",
            explanation = "The buyers were fair and offered to pay $2,400, double the agreed sum, for the additional acreage."
        ),
        QuestionModel(
            id = "s_10_eng_3_5",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Why did Don Anselmo refuse the additional twelve hundred dollars offered by the buyers?",
            options = listOf("He felt insulted because he was a man of principles and had already given his word for $1,200", "He did not trust paper currency", "He believed the buyers were trying to cheat him", "His family forbade him from accepting extra cash"),
            correctAnswer = "He felt insulted because he was a man of principles and had already given his word for $1,200",
            explanation = "Don Anselmo insisted he was a man of his word; having agreed to twelve hundred dollars, he refused to take a cent more."
        ),
        QuestionModel(
            id = "s_10_eng_3_6",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "Fill in the blank: A month after moving in, the American buyers returned to complain that _________ were overrunning the orchard and picking flowers.",
            options = listOf("wild cattle and horses", "the children of the village", "unauthorized campers", "fruit vendors from Santa Fe"),
            correctAnswer = "the children of the village",
            explanation = "The children of Rio en Medio continued playing under the orchard trees and picking blossoms."
        ),
        QuestionModel(
            id = "s_10_eng_3_7",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What explanation did Don Anselmo give regarding his ownership of the trees in the orchard?",
            options = listOf("The government had planted the trees during colonial rule", "He had planted a tree for every newborn child in the village; hence the trees belonged to the children", "The trees were dedicated to the village church", "The trees were mortgaged to a local merchant"),
            correctAnswer = "He had planted a tree for every newborn child in the village; hence the trees belonged to the children",
            explanation = "Don Anselmo maintained that he sold the land, but not the trees, because each tree belonged to a child born in the valley."
        ),
        QuestionModel(
            id = "s_10_eng_3_8",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "According to Don Anselmo, who were the true legal owners of the trees in Rio en Medio?",
            options = listOf("The village priest and church", "The children of Rio en Medio", "His eldest sons and daughters", "The Santa Fe state forest department"),
            correctAnswer = "The children of Rio en Medio",
            explanation = "He clarified that the orchard trees belonged to the village boys and girls, not to him personally."
        ),
        QuestionModel(
            id = "s_10_eng_3_9",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "How was the dispute over the orchard trees finally resolved with the American buyers?",
            options = listOf("The buyers filed an eviction lawsuit in court", "The buyers individually bought each tree from every child and owner in the village", "The village elders cut down all the disputed trees", "Don Anselmo refunded half the purchase money"),
            correctAnswer = "The buyers individually bought each tree from every child and owner in the village",
            explanation = "The buyers spent the following season negotiating and buying individual deeds for each tree from the descendants."
        ),
        QuestionModel(
            id = "s_10_eng_3_10",
            stdId = 10,
            subjectId = "english",
            unitId = 3,
            type = "MCQ",
            questionText = "What character trait of Don Anselmo is highlighted by his refusal of the extra money?",
            options = listOf("Arrogance and stubborness", "High self-respect, honor, and unyielding integrity", "Carelessness about financial matters", "Ignorance of property laws"),
            correctAnswer = "High self-respect, honor, and unyielding integrity",
            explanation = "Don Anselmo embodied the traditional dignity and honor of an old-world Spanish gentleman."
        ),
        // ========================================================
        // 🟦 UNIT 4 – PROSE 4: DR. B. R. AMBEDKAR
        // ========================================================
        QuestionModel(
            id = "s_10_eng_4_1",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "How is Dr. B. R. Ambedkar's voracious reading habit illustrated during his student years in New York and London?",
            options = listOf("He borrowed books only from the university library", "He bought about 2,000 old books in New York and filled numerous crates from London second-hand bookshops", "He memorized law books without purchasing them", "He collected only manuscripts on ancient economics"),
            correctAnswer = "He bought about 2,000 old books in New York and filled numerous crates from London second-hand bookshops",
            explanation = "Ambedkar lived frugally, spending his limited stipends on buying thousands of books in New York and London."
        ),
        QuestionModel(
            id = "s_10_eng_4_2",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Which amendment to the US Constitution deeply influenced Dr. Ambedkar's commitment to social equality?",
            options = listOf("1st Amendment", "14th Amendment", "19th Amendment", "21st Amendment"),
            correctAnswer = "14th Amendment",
            explanation = "The 14th Amendment of the US Constitution, which secured civil rights and freedom for Black Americans, left an indelible mark on him."
        ),
        QuestionModel(
            id = "s_10_eng_4_3",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Which newspapers did Dr. Ambedkar launch to champion the cause of depressed classes?",
            options = listOf("Harijan and Young India", "Mooknayak, Bahishkrit Bharat, and Samata", "Kesari and Maratha", "National Herald and The Hindu"),
            correctAnswer = "Mooknayak, Bahishkrit Bharat, and Samata",
            explanation = "Ambedkar founded Mooknayak (Leader of the Silent), Bahishkrit Bharat, and Samata to voice social injustice."
        ),
        QuestionModel(
            id = "s_10_eng_4_4",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Which institution was established by Dr. Ambedkar in 1924 to promote education and welfare for the underprivileged?",
            options = listOf("Servants of India Society", "Bahishkrit Hitakarini Sabha", "Brahmo Samaj", "Ramakrishna Mission"),
            correctAnswer = "Bahishkrit Hitakarini Sabha",
            explanation = "He set up Bahishkrit Hitakarini Sabha with the motto: 'Educate, Agitate, Organize'."
        ),
        QuestionModel(
            id = "s_10_eng_4_5",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "In the Bombay Legislative Assembly, which oppressed groups did Dr. Ambedkar vigorously defend?",
            options = listOf("Urban industrialists and mill owners", "Small agricultural tenants, peasants, and factory labourers", "Railway contractors and landlords", "Foreign trade merchants"),
            correctAnswer = "Small agricultural tenants, peasants, and factory labourers",
            explanation = "In the Bombay Assembly, Ambedkar fought against feudal agrarian systems (Khoti) and exploitation of industrial workers."
        ),
        QuestionModel(
            id = "s_10_eng_4_6",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "What historic responsibility was entrusted to Dr. Ambedkar by the Constituent Assembly?",
            options = listOf("President of the Union of India", "Chairman of the Constitution Drafting Committee", "First Minister of Finance", "Chief Justice of the Supreme Court"),
            correctAnswer = "Chairman of the Constitution Drafting Committee",
            explanation = "Dr. Ambedkar was unanimously chosen as Chairman of the Drafting Committee to frame the Constitution of free India."
        ),
        QuestionModel(
            id = "s_10_eng_4_7",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Which three foundational ideals inspired by the French Revolution did Dr. Ambedkar enshrine in the Constitution?",
            options = listOf("Faith, Hope, and Charity", "Liberty, Equality, and Fraternity", "Truth, Non-violence, and Peace", "Justice, Authority, and Obedience"),
            correctAnswer = "Liberty, Equality, and Fraternity",
            explanation = "Dr. Ambedkar built the constitutional philosophy on the pillars of Liberty, Equality, and Fraternity."
        ),
        QuestionModel(
            id = "s_10_eng_4_8",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Which ancient Tamil poetess did Dr. Ambedkar quote to emphasize that caste divisions are false?",
            options = listOf("Andal", "Avvai", "Akka Mahadevi", "Karaikkal Ammaiyar"),
            correctAnswer = "Avvai",
            explanation = "Ambedkar quoted Avvai's golden words: 'There are only two castes in the world: the noble who do good, and the ignoble who do evil.'"
        ),
        QuestionModel(
            id = "s_10_eng_4_9",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Fill in the blank: Pandit Jawaharlal Nehru hailed Dr. Ambedkar as a 'symbol of _________ against all oppressive features of Hindu society.'",
            options = listOf("revolt", "peace", "compromise", "tradition"),
            correctAnswer = "revolt",
            explanation = "Nehru paid tribute to Ambedkar as a heroic symbol of revolt against caste prejudice and oppression."
        ),
        QuestionModel(
            id = "s_10_eng_4_10",
            stdId = 10,
            subjectId = "english",
            unitId = 4,
            type = "MCQ",
            questionText = "Which article of the Indian Constitution, drafted under Dr. Ambedkar's guidance, abolished untouchability?",
            options = listOf("Article 14", "Article 17", "Article 21", "Article 32"),
            correctAnswer = "Article 17",
            explanation = "Article 17 of the Indian Constitution declares untouchability abolished and forbids its practice in any form."
        ),
        // ========================================================
        // 🟦 UNIT 5 – PROSE 5: THE CONCERT
        // ========================================================
        QuestionModel(
            id = "s_10_eng_5_1",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What fatal disease was fifteen-year-old Anant suffering from?",
            options = listOf("Tuberculosis", "Cancer (Leukaemia)", "Cardiac failure", "Meningitis"),
            correctAnswer = "Cancer (Leukaemia)",
            explanation = "Anant was diagnosed with cancer (leukaemia) and was undergoing intensive treatment in Bombay."
        ),
        QuestionModel(
            id = "s_10_eng_5_2",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Besides being a musical prodigy on the sitar, what other talents did Anant possess?",
            options = listOf("He was an expert swimmer and cricketer", "He was the fastest runner and best table tennis player in his school", "He was an award-winning painter and sculptor", "He was a state-level chess champion"),
            correctAnswer = "He was the fastest runner and best table tennis player in his school",
            explanation = "Anant excelled both in academics and athletics, being the school's top table-tennis player and fastest runner."
        ),
        QuestionModel(
            id = "s_10_eng_5_3",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What exciting news did Smita read aloud from the morning newspaper?",
            options = listOf("India won the World Cup", "Pandit Ravi Shankar was performing at Shanmukhananda Auditorium the following evening", "A new cancer cure had been discovered in America", "The school announced an unexpected holiday"),
            correctAnswer = "Pandit Ravi Shankar was performing at Shanmukhananda Auditorium the following evening",
            explanation = "The newspaper announced a sitar recital by sitar maestro Pandit Ravi Shankar and tabla maestro Ustad Allah Rakha."
        ),
        QuestionModel(
            id = "s_10_eng_5_4",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Why did Anant's mother caution Smita not to shout or read the news aloud?",
            options = listOf("Because Anant disliked classical music", "Because Anant was critically ill, asleep, and needed absolute rest", "Because the neighbours would complain of noise", "Because their aunt had a severe headache"),
            correctAnswer = "Because Anant was critically ill, asleep, and needed absolute rest",
            explanation = "Anant was desperately weak from chemotherapy and needed undisturbed rest."
        ),
        QuestionModel(
            id = "s_10_eng_5_5",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "With whom did Smita attend the musical concert at the auditorium?",
            options = listOf("Her mother and father", "Her uncle Sadanand", "Her school classmates", "Her brother Anant"),
            correctAnswer = "Her uncle Sadanand",
            explanation = "Smita accompanied her kind uncle Sadanand to Shanmukhananda Auditorium."
        ),
        QuestionModel(
            id = "s_10_eng_5_6",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Who accompanied Pandit Ravi Shankar on the tabla at the concert?",
            options = listOf("Ustad Zakir Hussain", "Ustad Allah Rakha", "Pandit Kishan Maharaj", "Ustad Bismillah Khan"),
            correctAnswer = "Ustad Allah Rakha",
            explanation = "The legendary tabla maestro Ustad Allah Rakha accompanied Pandit Ravi Shankar."
        ),
        QuestionModel(
            id = "s_10_eng_5_7",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What bold request did Smita make backstage after the concert ended?",
            options = listOf("She asked for autographed photographs of the artists", "She asked them to perform at her apartment for her dying brother", "She asked to become their sitar student", "She invited them to inaugurate her school auditorium"),
            correctAnswer = "She asked them to perform at her apartment for her dying brother",
            explanation = "Smita pleaded with Pandit Ravi Shankar and Ustad Allah Rakha to visit their home and play for Anant."
        ),
        QuestionModel(
            id = "s_10_eng_5_8",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "Fill in the blank: A man with a large _________ objected to Smita's request, calling it improper to bother busy artists.",
            options = listOf("turban", "moustache", "spectacles", "overcoat"),
            correctAnswer = "moustache",
            explanation = "A mustachioed man frowned and reprimanded Smita, saying the maestros were too busy for such visits."
        ),
        QuestionModel(
            id = "s_10_eng_5_9",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "How did Pandit Ravi Shankar and Ustad Allah Rakha respond to Smita's heartfelt appeal?",
            options = listOf("They politely declined due to tight tour schedules", "They agreed with warm compassion and promised to come the next morning", "They sent a recorded cassette instead", "They offered financial help for Anant's treatment"),
            correctAnswer = "They agreed with warm compassion and promised to come the next morning",
            explanation = "Moved by Smita's love for her brother, the two great maestros agreed immediately to play for Anant."
        ),
        QuestionModel(
            id = "s_10_eng_5_10",
            stdId = 10,
            subjectId = "english",
            unitId = 5,
            type = "MCQ",
            questionText = "What happened while the maestros were playing soft ragas inside Aunt Sushila's apartment?",
            options = listOf("Anant miraculously recovered his strength", "Anant listened peacefully and took his last breath surrounded by sublime music", "The neighbours forced the musicians to stop", "Anant asked to play the sitar along with them"),
            correctAnswer = "Anant listened peacefully and took his last breath surrounded by sublime music",
            explanation = "As the divine notes filled the room, Anant's soul departed peacefully, fulfilling his final wish."
        ),
        // ========================================================
        // 🟦 UNIT 6 – PROSE 6: THE DISCOVERY
        // ========================================================
        QuestionModel(
            id = "s_10_eng_6_1",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What was the setting of Herman Ould's historical play 'The Discovery'?",
            options = listOf("The royal court of Spain in Madrid", "The poop deck of Christopher Columbus's flagship Santa Maria in 1492", "A tavern in the seaport of Palos", "A newly discovered island in the Caribbean"),
            correctAnswer = "The poop deck of Christopher Columbus's flagship Santa Maria in 1492",
            explanation = "The play is set on the deck of the flagship Santa Maria during Columbus's first voyage to find the westward route."
        ),
        QuestionModel(
            id = "s_10_eng_6_2",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What was the growing attitude of the sailors towards Columbus after weeks of seeing only endless ocean?",
            options = listOf("Eager anticipation and cheerfulness", "Bitter resentment, superstition, despair, and brewing mutiny", "Devoted loyalty and religious reverence", "Indifference to the expedition's outcome"),
            correctAnswer = "Bitter resentment, superstition, despair, and brewing mutiny",
            explanation = "The crew felt terrified of the endless sea, superstitious about falling off the edge of the world, and mutinous."
        ),
        QuestionModel(
            id = "s_10_eng_6_3",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What rude tavern song were the discontented seamen singing on the deck?",
            options = listOf("A song praising the Spanish armada", "A song celebrating tavern rum and cursing the voyage", "A hymn to the Virgin Mary", "A sea shanty about catching whales"),
            correctAnswer = "A song celebrating tavern rum and cursing the voyage",
            explanation = "The seamen sang a rowdy song: 'Here's a health to the lass with the merry black eye... and the devil take the rest!'"
        ),
        QuestionModel(
            id = "s_10_eng_6_4",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Who was Pepe and how did he treat Christopher Columbus?",
            options = listOf("A rebellious helmsman who planned to seize the ship", "A loyal young page boy who stood faithfully by Columbus against the crew", "A Spanish priest conducting daily prayers", "A merchant financing the voyage"),
            correctAnswer = "A loyal young page boy who stood faithfully by Columbus against the crew",
            explanation = "Pepe was Columbus's loyal page who physically defended his captain and warned him of the sailors' plotting."
        ),
        QuestionModel(
            id = "s_10_eng_6_5",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Which aggressive sailor acted as the chief spokesman for the mutinous seamen against Columbus?",
            options = listOf("Pedro Gutierrez", "Guillermo Ires", "Diego", "Juan"),
            correctAnswer = "Guillermo Ires",
            explanation = "Guillermo Ires boldly confronted Columbus, demanding they turn the ships back to Spain."
        ),
        QuestionModel(
            id = "s_10_eng_6_6",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "How did Columbus maintain discipline and authority when the sailors threatened to revolt?",
            options = listOf("He offered them extra gold and rum", "He demonstrated calm authority, resolute faith, and commanded them to do their duty", "He locked himself in the captain's cabin", "He ordered the cannons to be fired at the crew"),
            correctAnswer = "He demonstrated calm authority, resolute faith, and commanded them to do their duty",
            explanation = "Columbus faced down the mutineers with unshakeable calm, stern authority, and supreme confidence."
        ),
        QuestionModel(
            id = "s_10_eng_6_7",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What initial sign of land was observed floating in the sea waters?",
            options = listOf("A carved piece of wood and a fresh green bough", "A flock of seagulls resting on the mast", "An empty Indian canoe", "Pieces of tropical fruit"),
            correctAnswer = "A carved piece of wood and a fresh green bough",
            explanation = "The crew fished up a piece of carved wood and fresh vegetation, proving land was close by."
        ),
        QuestionModel(
            id = "s_10_eng_6_8",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What did Columbus himself spot in the distance at ten o'clock at night?",
            options = listOf("A distant mountain peak", "A moving, flickering light", "A bonfire on the shore", "A lighthouse on a cliff"),
            correctAnswer = "A moving, flickering light",
            explanation = "Columbus was the first to discern a faint, flickering light rising and falling in the nocturnal horizon."
        ),
        QuestionModel(
            id = "s_10_eng_6_9",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "Fill in the blank: What reward had the Queen of Spain promised to whoever sighted land first?",
            options = listOf("A golden sword and title of Duke", "A silk doublet and a lifetime pension", "A share of ten merchant galleons", "Freedom from all taxes for fifty years"),
            correctAnswer = "A silk doublet and a lifetime pension",
            explanation = "Queen Isabella promised a handsome silk doublet and ten thousand maravedis annuity to the first person to sight land."
        ),
        QuestionModel(
            id = "s_10_eng_6_10",
            stdId = 10,
            subjectId = "english",
            unitId = 6,
            type = "MCQ",
            questionText = "What central leadership quality is celebrated in Columbus throughout the play?",
            options = listOf("Merciless cruelty towards enemies", "Steadfast vision, courage, and perseverance in the face of despair", "Willingness to compromise when challenged", "Astrological foresight"),
            correctAnswer = "Steadfast vision, courage, and perseverance in the face of despair",
            explanation = "The play dramatizes how one man's unwavering determination conquered doubt, mutiny, and the unknown."
        ),
        // ========================================================
        // 🟦 UNIT 7 – PROSE 7: COLOURS OF SILENCE
        // ========================================================
        QuestionModel(
            id = "s_10_eng_7_1",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What tragic accident happened to eight-year-old Satish Gujral while hiking in Kashmir?",
            options = listOf("He was struck by lightning during a blizzard", "He lost his footing on a rickety rope bridge and plunged into the rushing rapids", "He was attacked by a Himalayan bear", "He fell down the staircase of a house"),
            correctAnswer = "He lost his footing on a rickety rope bridge and plunged into the rushing rapids",
            explanation = "While hiking with his father and brother across a shaky bridge over rapids, Satish fell into the torrent."
        ),
        QuestionModel(
            id = "s_10_eng_7_2",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What permanent physical disability did Satish suffer as an aftermath of multiple ear surgeries?",
            options = listOf("Complete loss of eyesight", "Permanent deafness and severe speech impediment", "Paralysis of both lower limbs", "Loss of physical memory"),
            correctAnswer = "Permanent deafness and severe speech impediment",
            explanation = "Frequent infections and surgical operations caused severe nerve damage, robbing him of his hearing."
        ),
        QuestionModel(
            id = "s_10_eng_7_3",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Why did ordinary schools refuse to give admission to young Satish?",
            options = listOf("He had failed the annual entrance exam", "Because the headmasters believed a deaf and mute child could not cope with regular classrooms", "Because the tuition fees were unpaid", "Because his father was constantly transferred"),
            correctAnswer = "Because the headmasters believed a deaf and mute child could not cope with regular classrooms",
            explanation = "School principals cruelly turned him away, advising his father to send him to an institution for the handicapped."
        ),
        QuestionModel(
            id = "s_10_eng_7_4",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "How did Satish's elder brother Inder show devotion and care for his brother?",
            options = listOf("He built him a treehouse in the garden", "He sat with him for hours, talking, reading books, and teaching him pronunciation", "He carried him to the market every evening", "He defended him in neighbourhood street fights"),
            correctAnswer = "He sat with him for hours, talking, reading books, and teaching him pronunciation",
            explanation = "Inder was Satish's constant companion, reading stories aloud and helping him practice lip-reading and words."
        ),
        QuestionModel(
            id = "s_10_eng_7_5",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What sight outside the bedroom window first inspired Satish to start drawing?",
            options = listOf("A rainbow across the rain-swept valley", "A restless, beautiful exotic bird with a long crest and reddish tail", "Children flying colourful kites", "A village potter moulding clay lamps"),
            correctAnswer = "A restless, beautiful exotic bird with a long crest and reddish tail",
            explanation = "Satish was captivated by a unique, vibrant bird sitting on a leafy branch and sketched it on paper."
        ),
        QuestionModel(
            id = "s_10_eng_7_6",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Why was Satish's father, Narain Gujral, initially opposed to his son taking up drawing?",
            options = listOf("He feared paint chemicals were poisonous", "He felt artists lead miserable lives and cannot earn a decent livelihood", "He wanted Satish to become a medical doctor", "He disliked modern paintings"),
            correctAnswer = "He felt artists lead miserable lives and cannot earn a decent livelihood",
            explanation = "Mr. Gujral believed painting was an unprofitable pastime that would not help a disabled child become self-reliant."
        ),
        QuestionModel(
            id = "s_10_eng_7_7",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "What caused the dramatic change in Narain Gujral's attitude towards Satish's art?",
            options = listOf("Satish won a gold medal in an international competition", "He saw the extraordinary depth, emotion, and concentration in his son's artwork", "A famous art dealer offered a large sum of money for Satish's paintings", "Inder convinced their mother to intervene"),
            correctAnswer = "He saw the extraordinary depth, emotion, and concentration in his son's artwork",
            explanation = "Observing Satish working with absorbed passion, the father realized art was his son's true calling and bought him paints."
        ),
        QuestionModel(
            id = "s_10_eng_7_8",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Which world-famous art academy did Satish Gujral join to pursue formal artistic training?",
            options = listOf("Royal College of Art, London", "Sir J.J. School of Art, Bombay", "Santiniketan Kala Bhavan", "Baroda Faculty of Fine Arts"),
            correctAnswer = "Sir J.J. School of Art, Bombay",
            explanation = "Satish was enrolled in the renowned Sir J.J. School of Art in Bombay."
        ),
        QuestionModel(
            id = "s_10_eng_7_9",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Which landmark international diplomatic building in New Delhi was designed by Satish Gujral?",
            options = listOf("The American Embassy", "The Belgian Embassy", "The French Cultural Centre", "The British High Commission"),
            correctAnswer = "The Belgian Embassy",
            explanation = "Satish Gujral designed the magnificent Belgian Embassy in New Delhi, selected among the 1000 best architectural works of the 20th century."
        ),
        QuestionModel(
            id = "s_10_eng_7_10",
            stdId = 10,
            subjectId = "english",
            unitId = 7,
            type = "MCQ",
            questionText = "Which prestigious national civilian honour was conferred upon Satish Gujral by the Government of India?",
            options = listOf("Bharat Ratna", "Padma Vibhushan", "Param Vir Chakra", "Arjuna Award"),
            correctAnswer = "Padma Vibhushan",
            explanation = "Satish Gujral was awarded the Padma Vibhushan, India's second highest civilian honour, for his contribution to art and architecture."
        ),
        // ========================================================
        // 🟦 UNIT 8 – PROSE 8: SCIENCE AND HOPE OF SURVIVAL
        // ========================================================
        QuestionModel(
            id = "s_10_eng_8_1",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What was the professional background of the author, V. I. Keilis-Borok?",
            options = listOf("A theoretical astrophysicist studying black holes", "An eminent mathematical geophysicist and seismologist", "A military general in the Soviet army", "A diplomat in the United Nations disarmament committee"),
            correctAnswer = "An eminent mathematical geophysicist and seismologist",
            explanation = "Keilis-Borok was a renowned scientist specializing in underground seismic waves, earthquakes, and mathematics."
        ),
        QuestionModel(
            id = "s_10_eng_8_2",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What was the purpose of the 1960 Geneva Technical Conference attended by Keilis-Borok?",
            options = listOf("To explore the deepest trenches of the Pacific Ocean", "To solve the technical problem of detecting underground nuclear tests for a test ban treaty", "To formulate global regulations for space travel", "To cure infectious diseases across Europe"),
            correctAnswer = "To solve the technical problem of detecting underground nuclear tests for a test ban treaty",
            explanation = "Scientists from the USSR, USA, and UK gathered to find scientific methods to detect secret underground nuclear explosions."
        ),
        QuestionModel(
            id = "s_10_eng_8_3",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What scientific dilemma made it difficult to verify underground nuclear test bans?",
            options = listOf("Underground radiation cannot be measured", "Seismic waves from underground nuclear detonations mimic natural earthquake tremors", "Deep underground rocks block all electronic signals", "Satellites cannot photograph through the earth"),
            correctAnswer = "Seismic waves from underground nuclear detonations mimic natural earthquake tremors",
            explanation = "The primary scientific hurdle was differentiating seismic signatures of earthquakes from secret nuclear tests."
        ),
        QuestionModel(
            id = "s_10_eng_8_4",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What grim acronym describes the geopolitical doctrine that prevented superpowers from launching nuclear war?",
            options = listOf("NATO", "MAD (Mutually Assured Destruction)", "SALT", "UNICEF"),
            correctAnswer = "MAD (Mutually Assured Destruction)",
            explanation = "MAD (Mutually Assured Destruction) meant an atomic attack would guarantee total annihilation for both sides."
        ),
        QuestionModel(
            id = "s_10_eng_8_5",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Why do passionate people choose to become scientists according to Keilis-Borok?",
            options = listOf("To amass vast financial wealth and fame", "For the intellectual joy of discovery, uncovering nature's secrets, and international fellowship", "To wield absolute political power over nations", "To work in air-conditioned laboratories"),
            correctAnswer = "For the intellectual joy of discovery, uncovering nature's secrets, and international fellowship",
            explanation = "Scientists are drawn by curiosity, the thrill of unlocking truth, and the universal camaraderie of science."
        ),
        QuestionModel(
            id = "s_10_eng_8_6",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Fill in the blank: Keilis-Borok explains that while applied science creates modern technology, _________ provides the fundamental understanding of nature.",
            options = listOf("social science", "basic or fundamental science", "military strategy", "financial investment"),
            correctAnswer = "basic or fundamental science",
            explanation = "Basic research is the bedrock of all technological progress and human knowledge."
        ),
        QuestionModel(
            id = "s_10_eng_8_7",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Which planetary threats can only be addressed and mitigated through scientific collaboration?",
            options = listOf("Stock market fluctuations and trade deficits", "Natural hazards (earthquakes, tsunamis), pandemics, pollution, and global warming", "Border disputes between neighboring towns", "Political election campaigns"),
            correctAnswer = "Natural hazards (earthquakes, tsunamis), pandemics, pollution, and global warming",
            explanation = "Environmental degradation, tsunamis, earthquakes, and epidemics require global scientific solutions."
        ),
        QuestionModel(
            id = "s_10_eng_8_8",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "What core message does the author convey regarding the survival of humanity?",
            options = listOf("Only military strength guarantees national survival", "Science is humanity's indispensable hope of survival", "Traditional isolationism will preserve peace", "Modern technology should be abandoned"),
            correctAnswer = "Science is humanity's indispensable hope of survival",
            explanation = "The author concludes that science provides the knowledge, tools, and hope necessary to preserve civilization."
        ),
        QuestionModel(
            id = "s_10_eng_8_9",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Complete the sentence: At the Geneva conference, scientists from opposing Cold War factions discovered that they _________.",
            options = listOf("could not communicate with each other", "shared a common language of logic, objectivity, and mutual scientific respect", "refused to sign any joint scientific declaration", "competed furiously to withhold data"),
            correctAnswer = "shared a common language of logic, objectivity, and mutual scientific respect",
            explanation = "Scientific rationality transcended ideological barriers between Soviet and American experts."
        ),
        QuestionModel(
            id = "s_10_eng_8_10",
            stdId = 10,
            subjectId = "english",
            unitId = 8,
            type = "MCQ",
            questionText = "Who does the author identify as the true guardians capable of warning humanity against catastrophic ecological hazards?",
            options = listOf("Advertising agencies", "Dedicated scientists and researchers", "Corporate shareholders", "Political speechwriters"),
            correctAnswer = "Dedicated scientists and researchers",
            explanation = "Scientists alone possess the analytical tools and knowledge to forecast and mitigate natural and man-made catastrophes."
        ),
        // ========================================================
        // 🟦 UNIT 9 – POEM 1: GRANDMA CLIMBS A TREE
        // ========================================================
        QuestionModel(
            id = "s_10_eng_9_1",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What unique passion did the poet Ruskin Bond's grandmother possess?",
            options = listOf("Knitting sweaters for villagers", "Climbing trees, whether tall or spreading", "Riding horses through mountain passes", "Painting landscape watercolors"),
            correctAnswer = "Climbing trees, whether tall or spreading",
            explanation = "Grandmother had an irresistible passion for climbing trees ever since she was six years old."
        ),
        QuestionModel(
            id = "s_10_eng_9_2",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "At what age did Ruskin Bond's grandmother climb her last tree?",
            options = listOf("Fifty", "Sixty-two", "Seventy-five", "Eighty"),
            correctAnswer = "Sixty-two",
            explanation = "She was sixty-two when she climbed her last tree and couldn't come down until rescued."
        ),
        QuestionModel(
            id = "s_10_eng_9_3",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What did well-meaning neighbours and family tell Grandma as she grew older?",
            options = listOf("That she should migrate to a warmer city", "That she should stop climbing trees and grow old gracefully", "That she should write an autobiography", "That she should hire a gardener"),
            correctAnswer = "That she should stop climbing trees and grow old gracefully",
            explanation = "People warned that climbing trees should stop with age, but Grandma laughed and chose to grow old disgracefully."
        ),
        QuestionModel(
            id = "s_10_eng_9_4",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What did the family doctor strictly recommend when Grandma fell ill with a temperature?",
            options = listOf("A major surgical operation in town", "A quiet week's bed rest", "A daily morning walk in the forest", "A diet of herbal juices"),
            correctAnswer = "A quiet week's bed rest",
            explanation = "The doctor examined her pulse and ordered a quiet, restful week in bed."
        ),
        QuestionModel(
            id = "s_10_eng_9_5",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "How did Grandma feel while confined to her bed for a week?",
            options = listOf("Peaceful, refreshed, and calm", "Like a brief season in hell, trapped away from green branches", "Delighted to read newspapers all day", "Grateful for the extended vacation"),
            correctAnswer = "Like a brief season in hell, trapped away from green branches",
            explanation = "For Grandma, lying in bed away from trees and fluttering leaves felt like being imprisoned in hell."
        ),
        QuestionModel(
            id = "s_10_eng_9_6",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What demand did Grandma make to her son the moment she felt better?",
            options = listOf("To purchase a car for her travels", "To build her a house in a treetop", "To chop down all slippery trees in the garden", "To take her to the seaside"),
            correctAnswer = "To build her a house in a treetop",
            explanation = "Grandma called her dutiful son and demanded that he build her a house in a treetop."
        ),
        QuestionModel(
            id = "s_10_eng_9_7",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Who built the treetop house for Grandma?",
            options = listOf("A local village carpenter", "The poet's father (Grandma's son), with the poet's assistance", "A team of municipal builders", "The family doctor"),
            correctAnswer = "The poet's father (Grandma's son), with the poet's assistance",
            explanation = "The poet's father was an affectionate and dutiful son who built the treehouse with windows and a door."
        ),
        QuestionModel(
            id = "s_10_eng_9_8",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "Fill in the blank: In her treetop house, Grandma lived happily, drinking _________ with her grandson every evening.",
            options = listOf("tea", "sherry", "fruit juice", "lemonade"),
            correctAnswer = "sherry",
            explanation = "The poet would climb up daily with glasses and sherry to toast and uphold her right to live in a tree."
        ),
        QuestionModel(
            id = "s_10_eng_9_9",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What does the phrase 'grow old disgracefully' signify in the poem?",
            options = listOf("Behaving rudely towards family members", "Refusing to conform to conventional age-related restrictions and retaining youthful joy", "Neglecting household responsibilities", "Losing one's temper easily"),
            correctAnswer = "Refusing to conform to conventional age-related restrictions and retaining youthful joy",
            explanation = "It highlights Grandma's defiant, cheerful refusal to let age dampen her adventurous spirit."
        ),
        QuestionModel(
            id = "s_10_eng_9_10",
            stdId = 10,
            subjectId = "english",
            unitId = 9,
            type = "MCQ",
            questionText = "What tone does Ruskin Bond adopt throughout 'Grandma Climbs a Tree'?",
            options = listOf("Melancholic and sorrowful", "Affectionate, humorous, and celebratory", "Sarcastic and judgmental", "Philosophical and pessimistic"),
            correctAnswer = "Affectionate, humorous, and celebratory",
            explanation = "The poem is warm, witty, playful, and filled with deep familial love."
        ),
        // ========================================================
        // 🟦 UNIT 10 – POEM 2: QUALITY OF MERCY
        // ========================================================
        QuestionModel(
            id = "s_10_eng_10_1",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "From which famous play of William Shakespeare is the poem 'Quality of Mercy' extracted?",
            options = listOf("Hamlet", "The Merchant of Venice", "Macbeth", "Julius Caesar"),
            correctAnswer = "The Merchant of Venice",
            explanation = "Portia delivers this celebrated speech in the Venetian courtroom scene of Shakespeare's 'The Merchant of Venice'."
        ),
        QuestionModel(
            id = "s_10_eng_10_2",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "How does mercy fall upon the earth according to Shakespeare?",
            options = listOf("Like a roaring mountain waterfall", "As the gentle rain from heaven upon the place beneath", "Like a violent thunderstorm", "As the autumn frost on leaves"),
            correctAnswer = "As the gentle rain from heaven upon the place beneath",
            explanation = "Portia declares: 'The quality of mercy is not strain'd; It droppeth as the gentle rain from heaven upon the place beneath.'"
        ),
        QuestionModel(
            id = "s_10_eng_10_3",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Why is mercy described as being 'twice blest'?",
            options = listOf("It blesses only the king and his royal court", "It blesseth him that gives and him that takes", "It brings double wealth and fame", "It saves both body and soul"),
            correctAnswer = "It blesseth him that gives and him that takes",
            explanation = "Mercy brings grace and spiritual joy to the one who shows it as well as relief to the one who receives it."
        ),
        QuestionModel(
            id = "s_10_eng_10_4",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Complete the line: 'Tis mightiest in the _________; it becomes the throned monarch better than his crown.'",
            options = listOf("heavens", "mightiest", "humblest", "wisest"),
            correctAnswer = "mightiest",
            explanation = "Mercy shines brightest in those with great power; it is mightiest in the mightiest."
        ),
        QuestionModel(
            id = "s_10_eng_10_5",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "What does an earthly monarch's sceptre symbolize?",
            options = listOf("Spiritual purity and sacrifice", "Temporal power, majesty, and earthly awe", "Mercy and compassion", "Intellectual enlightenment"),
            correctAnswer = "Temporal power, majesty, and earthly awe",
            explanation = "The royal sceptre represents worldly authority, royal majesty, and dread of kingly punishment."
        ),
        QuestionModel(
            id = "s_10_eng_10_6",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Where is mercy enthroned according to Portia?",
            options = listOf("In the king's golden palace", "In the hearts of kings", "In written law books", "In royal crowns"),
            correctAnswer = "In the hearts of kings",
            explanation = "Mercy is an attribute of God Himself, residing deep within the hearts of righteous rulers."
        ),
        QuestionModel(
            id = "s_10_eng_10_7",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "When does earthly power look most like divine, godly power?",
            options = listOf("When monarchs wage victorious wars", "When mercy seasons justice", "When laws are enforced without any pity", "When treasuries are filled with gold"),
            correctAnswer = "When mercy seasons justice",
            explanation = "Portia notes: 'And earthly power doth then show likest God's when mercy seasons justice.'"
        ),
        QuestionModel(
            id = "s_10_eng_10_8",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "Fill in the blank: Mercy is an attribute to _________ Himself.",
            options = listOf("nature", "God", "mankind", "justice"),
            correctAnswer = "God",
            explanation = "Mercy is a divine attribute, reflecting the sublime compassion of God."
        ),
        QuestionModel(
            id = "s_10_eng_10_9",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "What poetic metre is used in 'Quality of Mercy'?",
            options = listOf("Rhymed ballad metre", "Unrhymed iambic pentameter (blank verse)", "Free verse", "Dactylic hexameter"),
            correctAnswer = "Unrhymed iambic pentameter (blank verse)",
            explanation = "The speech is composed in classic Shakespearean blank verse (unrhymed iambic pentameter)."
        ),
        QuestionModel(
            id = "s_10_eng_10_10",
            stdId = 10,
            subjectId = "english",
            unitId = 10,
            type = "MCQ",
            questionText = "What lesson does Portia convey to Shylock through this speech?",
            options = listOf("That strict legal justice without compassion destroys human dignity", "That money is superior to human life", "That courts have no power over merchants", "That contracts can never be questioned"),
            correctAnswer = "That strict legal justice without compassion destroys human dignity",
            explanation = "She urges that justice must be tempered with mercy for salvation and humanity."
        ),
        // ========================================================
        // 🟦 UNIT 11 – POEM 3: I AM THE LAND
        // ========================================================
        QuestionModel(
            id = "s_10_eng_11_1",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "Who is the speaker in Marina de Bellagente's poem 'I am the Land'?",
            options = listOf("A weary farmer toiling in fields", "Mother Earth / The Land personified", "A soldier defending a national border", "An environmental activist"),
            correctAnswer = "Mother Earth / The Land personified",
            explanation = "The poem is a monologue delivered by the personified Earth ('I am the land. I wait.')."
        ),
        QuestionModel(
            id = "s_10_eng_11_2",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "What repetitive refrain underscores the immense patience of the Earth?",
            options = listOf("'I shout'", "'I wait'", "'I fight'", "'I run'"),
            correctAnswer = "'I wait'",
            explanation = "The land repeatedly whispers 'I wait', demonstrating unyielding patience against human greed."
        ),
        QuestionModel(
            id = "s_10_eng_11_3",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "How do human beings treat the land according to the speaker?",
            options = listOf("They preserve it with worship and care", "They shout, buy, sell, dig, plough, and fight wars over ownership", "They leave it completely undisturbed", "They build sanctuaries for all creatures"),
            correctAnswer = "They shout, buy, sell, dig, plough, and fight wars over ownership",
            explanation = "Humanity arrogantly claims ownership, plowing fields, digging holes, and carving borders."
        ),
        QuestionModel(
            id = "s_10_eng_11_4",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "What poetic image does the poet use to describe puddles and flooded hollows watching human antics?",
            options = listOf("Golden mirrors", "With muddy eyes I stare", "Green velvet cloaks", "Tears of sorrow"),
            correctAnswer = "With muddy eyes I stare",
            explanation = "The line 'With muddy eyes I stare...' paints puddles as observant eyes witnessing human foolishness."
        ),
        QuestionModel(
            id = "s_10_eng_11_5",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "What is the metaphor of the 'chain link necklace' in the poem?",
            options = listOf("A beautiful gift of jewelry", "Barbed-wire fences and walls erected by humans that choke the earth", "A line of trees planted across fields", "A railway track connecting cities"),
            correctAnswer = "Barbed-wire fences and walls erected by humans that choke the earth",
            explanation = "The chain link necklace represents boundary fences that divide and choke the natural earth."
        ),
        QuestionModel(
            id = "s_10_eng_11_6",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "Fill in the blank: What is the triumphant, defiant closing declaration of the poem?",
            options = listOf("'You cannot cross the mighty ocean'", "'You cannot put a fence around the planet Earth'", "'You cannot touch the stars in space'", "'You cannot tame the wild winds'"),
            correctAnswer = "'You cannot put a fence around the planet Earth'",
            explanation = "The land asserts its ultimate supremacy: 'You cannot put a fence around the planet Earth.'"
        ),
        QuestionModel(
            id = "s_10_eng_11_7",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "What contrasting emotions are displayed between man and the land?",
            options = listOf("Man is patient while the land is aggressive", "Man is restless, arrogant, and possessive, while the land is patient and enduring", "Both man and land are violent", "Both man and land are sorrowful"),
            correctAnswer = "Man is restless, arrogant, and possessive, while the land is patient and enduring",
            explanation = "Humans are noisy, greedy, and eager to dominate, while the earth calmly outlasts all human regimes."
        ),
        QuestionModel(
            id = "s_10_eng_11_8",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "What environmental warning does the poem implicitly offer to mankind?",
            options = listOf("Humans should stop traveling across countries", "Exploiting and dividing the natural world will never grant true mastery over the planet", "Cities must be built only in deserts", "Fences are necessary for agricultural progress"),
            correctAnswer = "Exploiting and dividing the natural world will never grant true mastery over the planet",
            explanation = "The poem critiques human possessiveness and underscores that nature cannot be subjugated by fences."
        ),
        QuestionModel(
            id = "s_10_eng_11_9",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "Which literary device is predominantly used when the Earth speaks in the first person ('I')?",
            options = listOf("Hyperbole", "Personification", "Alliteration", "Onomatopoeia"),
            correctAnswer = "Personification",
            explanation = "Giving human speech, thoughts, and feelings to the Earth is personification."
        ),
        QuestionModel(
            id = "s_10_eng_11_10",
            stdId = 10,
            subjectId = "english",
            unitId = 11,
            type = "MCQ",
            questionText = "Complete the phrase: When car engines and traffic crowd upon the land, it smells _________.",
            options = listOf("sweet fragrance of blossoms", "acrid fumes and exhaust choke the ground", "cool mountain breeze", "salty coastal air"),
            correctAnswer = "acrid fumes and exhaust choke the ground",
            explanation = "The poem highlights the intrusion of cars, metal lots, and smoke upon nature."
        ),
        // ========================================================
        // 🟦 UNIT 12 – POEM 4: THE SONG OF INDIA
        // ========================================================
        QuestionModel(
            id = "s_10_eng_12_1",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "What is the format of V. K. Gokak's patriotic poem 'The Song of India'?",
            options = listOf("A funeral elegy for fallen soldiers", "A dynamic dialogue between the Poet and Mother India", "A soliloquy by an ancient rishi", "A ballad describing a naval battle"),
            correctAnswer = "A dynamic dialogue between the Poet and Mother India",
            explanation = "The poem is arranged as an alternating conversation between the inquisitive poet and Mother India."
        ),
        QuestionModel(
            id = "s_10_eng_12_2",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "What natural glories does the poet offer to praise first in his song?",
            options = listOf("The vast Thar desert", "The snow-capped Himalayas and the three oceans washing her feet", "The monsoon thunderstorms of Kerala", "The dense teak forests of the Western Ghats"),
            correctAnswer = "The snow-capped Himalayas and the three oceans washing her feet",
            explanation = "The poet wishes to sing of the white peaks of Himalayas and the three seas kissing her shores."
        ),
        QuestionModel(
            id = "s_10_eng_12_3",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "What cultural and historical treasures does the poet wish to celebrate in the second stanza?",
            options = listOf("Rock-cut temples of Ellora, sacred epics, and ancient seers", "Modern cricket stadiums and cinema halls", "Colonial forts and palaces", "Trade routes of the Silk Road"),
            correctAnswer = "Rock-cut temples of Ellora, sacred epics, and ancient seers",
            explanation = "He wants to sing of Ajanta-Ellora rock architecture, epics like Ramayana-Mahabharata, and saintly sages."
        ),
        QuestionModel(
            id = "s_10_eng_12_4",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "Why does Mother India repeatedly interrupt and question the poet's choices?",
            options = listOf("She prefers foreign songs", "She demands that he look also at the misery of the poor, the lepers, and the starving millions", "She wants him to compose only in classical Sanskrit", "She is tired of all poetry"),
            correctAnswer = "She demands that he look also at the misery of the poor, the lepers, and the starving millions",
            explanation = "Mother India insists that true patriotism does not ignore social suffering, disease, poverty, and hunger."
        ),
        QuestionModel(
            id = "s_10_eng_12_5",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "What modern technological achievements does the poet propose singing next?",
            options = listOf("Steam railway lines and telegraph posts", "Dams, steel plants, atomic energy centres, and shipyards", "Digital smartphones and internet satellites", "Textile mills and spinning wheels"),
            correctAnswer = "Dams, steel plants, atomic energy centres, and shipyards",
            explanation = "The poet points to steel mills, hydroelectric dams, and atomic research as symbols of modern progress."
        ),
        QuestionModel(
            id = "s_10_eng_12_6",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "What does Mother India ask the poet to sing about regarding the nation's future?",
            options = listOf("A future of imperial conquests abroad", "The book of the morrow, heralding an era of equality, light, and eradication of sorrow", "A return to medieval rituals", "Perpetual political conflicts"),
            correctAnswer = "The book of the morrow, heralding an era of equality, light, and eradication of sorrow",
            explanation = "Mother desires a song celebrating the unwritten glorious dawn that banishes poverty and inequality."
        ),
        QuestionModel(
            id = "s_10_eng_12_7",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "How does Mother India appear at the end of the poem in the poet's ecstatic vision?",
            options = listOf("As a weeping widow in mourning robes", "As a radiant goddess draped in the blue sky, riding waves of light and dispelling night", "As a fearsome warrior armed with swords", "As a silent statue carved in stone"),
            correctAnswer = "As a radiant goddess draped in the blue sky, riding waves of light and dispelling night",
            explanation = "Mother India rises majestically like the dawn maiden, illuminating the world with truth and dignity."
        ),
        QuestionModel(
            id = "s_10_eng_12_8",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "Fill in the blank: Mother India asks the poet to sing of the millions of hard-working labourers who toiled in _________.",
            options = listOf("luxurious palaces", "filth, sweat, and dirt", "royal courts", "foreign trading ships"),
            correctAnswer = "filth, sweat, and dirt",
            explanation = "She reminds the poet not to overlook the humble coolies and farmers toiling in dirt."
        ),
        QuestionModel(
            id = "s_10_eng_12_9",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "What central social vision is advocated in 'The Song of India'?",
            options = listOf("Blind glorification of the past without reform", "A balanced patriotism that honors heritage while actively resolving poverty, casteism, and suffering", "Abandoning industrialization entirely", "Adopting foreign culture"),
            correctAnswer = "A balanced patriotism that honors heritage while actively resolving poverty, casteism, and suffering",
            explanation = "Gokak advocates a progressive patriotism addressing social realities alongside cultural heritage."
        ),
        QuestionModel(
            id = "s_10_eng_12_10",
            stdId = 10,
            subjectId = "english",
            unitId = 12,
            type = "MCQ",
            questionText = "What does the 'nightmare' in the poem symbolize?",
            options = listOf("A bad dream had by the poet", "The centuries of poverty, oppression, foreign subjugation, and illiteracy", "A terrifying sea storm", "The harsh winter weather"),
            correctAnswer = "The centuries of poverty, oppression, foreign subjugation, and illiteracy",
            explanation = "The nightmare signifies the historical suffering and backwardness that must be swept away by dawn."
        ),
        // ========================================================
        // 🟦 UNIT 13 – POEM 5: JAZZ POEM TWO
        // ========================================================
        QuestionModel(
            id = "s_10_eng_13_1",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "How is the physical appearance of the elderly Jazz musician described by Carl Wendall Hines, Jr.?",
            options = listOf("A youthful man in a sparkling tuxedo", "An aged Black man with a wrinkled face, sagging stomach, closed eyes, and frayed collar", "A military bandsman in crisp uniform", "A jolly street vendor with a trumpet"),
            correctAnswer = "An aged Black man with a wrinkled face, sagging stomach, closed eyes, and frayed collar",
            explanation = "The Jazz player has a tired, wrinkled face, closed eyes, and bears the pain of lifelong hardships."
        ),
        QuestionModel(
            id = "s_10_eng_13_2",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "What clothes does the Jazz player wear in the poem?",
            options = listOf("A faded blue shirt turned dark with sweat, frayed necktie, and old shoes with paper soles", "A gleaming white silk shirt and patent leather shoes", "A warm woollen overcoat and boots", "Traditional African tribal garments"),
            correctAnswer = "A faded blue shirt turned dark with sweat, frayed necktie, and old shoes with paper soles",
            explanation = "His worn-out garments reflect poverty, neglect, and prolonged struggle."
        ),
        QuestionModel(
            id = "s_10_eng_13_3",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "What musical instrument does the Jazz musician carry across his chest?",
            options = listOf("A silver flute", "An old alto saxophone held together by a wire", "A wooden acoustic guitar", "A brass trumpet"),
            correctAnswer = "An old alto saxophone held together by a wire",
            explanation = "He carries an old alto saxophone supported by a wire hanger around his neck."
        ),
        QuestionModel(
            id = "s_10_eng_13_4",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "What happens to the musician the moment he puts the saxophone to his lips and begins to play?",
            options = listOf("He faints from physical exhaustion", "He forgets his weariness and transforms into a soaring bird flying higher and higher", "The audience laughs at his broken instrument", "He remembers only bitter memories of slavery"),
            correctAnswer = "He forgets his weariness and transforms into a soaring bird flying higher and higher",
            explanation = "Through the sublime power of music, he transcends physical misery and flies free like a bird in the sky."
        ),
        QuestionModel(
            id = "s_10_eng_13_5",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "What does the music of the Jazz player express?",
            options = listOf("Military victory and pride", "The deep sorrows, struggles, resilient spirit, and gospel soul of Black people", "Light-hearted tavern comedy", "A critique of classical European orchestra"),
            correctAnswer = "The deep sorrows, struggles, resilient spirit, and gospel soul of Black people",
            explanation = "His soulful melodies proclaim the African-American experience of pain, resilience, and spiritual yearning."
        ),
        QuestionModel(
            id = "s_10_eng_13_6",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "Fill in the blank: What happens when the musician finishes his passionate performance and stops playing?",
            options = listOf("He receives a standing ovation from kings", "He descends back to reality, becoming once again an ordinary, humble Black man", "He immediately starts playing the drums", "He flies away into the clouds forever"),
            correctAnswer = "He descends back to reality, becoming once again an ordinary, humble Black man",
            explanation = "When the music ceases, the bird descends, and he finds himself back on earth as a weary Black man."
        ),
        QuestionModel(
            id = "s_10_eng_13_7",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "Why does the poet describe the musician's face as wrinkled and weary?",
            options = listOf("He worked in desert heat all his life", "It reflects a lifetime of racial discrimination, poverty, and sorrow", "He had been sick for several years", "He was very old and had no family"),
            correctAnswer = "It reflects a lifetime of racial discrimination, poverty, and sorrow",
            explanation = "The wrinkles symbolize the collective historical grief and burdens borne by African Americans."
        ),
        QuestionModel(
            id = "s_10_eng_13_8",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "What literary device is used in the transformation of the player into a bird ('he is no longer a man, he is a bird')?",
            options = listOf("Metaphor", "Oxymoron", "Simile", "Irony"),
            correctAnswer = "Metaphor",
            explanation = "The direct comparison of the elevated artist to a soaring bird is a powerful metaphor for spiritual freedom."
        ),
        QuestionModel(
            id = "s_10_eng_13_9",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "What is the message of 'Jazz Poem Two' regarding art and music?",
            options = listOf("Musical instruments must be expensive to sound good", "True artistic expression has the transcendent power to liberate the human spirit from oppression", "Jazz music is only meant for entertainment", "Musicians should never perform alone"),
            correctAnswer = "True artistic expression has the transcendent power to liberate the human spirit from oppression",
            explanation = "The poem celebrates music as a divine vehicle of freedom, dignity, and transcendence."
        ),
        QuestionModel(
            id = "s_10_eng_13_10",
            stdId = 10,
            subjectId = "english",
            unitId = 13,
            type = "MCQ",
            questionText = "Complete the phrase: His eyes are closed because he wants to _________.",
            options = listOf("sleep peacefully on stage", "shut out the harsh external world and look deep into his musical soul", "avoid seeing the faces of the audience", "hide his failing eyesight"),
            correctAnswer = "shut out the harsh external world and look deep into his musical soul",
            explanation = "Closing his eyes allows him to tap into deep spiritual emotions and pour his soul into the saxophone."
        ),
        // ========================================================
        // 🟦 UNIT 14 – POEM 6: BALLAD OF THE TEMPEST
        // ========================================================
        QuestionModel(
            id = "s_10_eng_14_1",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "What was the setting of the poem 'Ballad of the Tempest' by James T. Fields?",
            options = listOf("A fishing village along the Scottish coast", "A passenger ship caught in a terrifying winter tempest on the open ocean", "A royal navy vessel attacking enemy forts", "An expedition crossing the frozen Arctic sea"),
            correctAnswer = "A passenger ship caught in a terrifying winter tempest on the open ocean",
            explanation = "The poem depicts passengers crowded on a ship battling a terrible winter storm at sea."
        ),
        QuestionModel(
            id = "s_10_eng_14_2",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "How were the passengers feeling inside the cabin during the storm?",
            options = listOf("They were singing joyous sea ballads", "They were huddled in silent dread, shivering and praying in the darkness", "They were enjoying a festive evening meal", "They were arguing with the ship's crew"),
            correctAnswer = "They were huddled in silent dread, shivering and praying in the darkness",
            explanation = "The passengers were crowded in the dark cabin, unable to sleep, waiting in dread for the worst."
        ),
        QuestionModel(
            id = "s_10_eng_14_3",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "What catastrophic damage occurred to the ship during the blast?",
            options = listOf("The rudder broke off completely", "The fierce gale tore away the sails and shattered the mast", "The hull sprang a major leak in the engine room", "The anchor dragged the ship onto sharp rocks"),
            correctAnswer = "The fierce gale tore away the sails and shattered the mast",
            explanation = "The tempest shivered the stout mast and ripped the sails, leaving the ship helpless against the breakers."
        ),
        QuestionModel(
            id = "s_10_eng_14_4",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "What despairing words did the rugged sea captain utter when he staggered down into the cabin?",
            options = listOf("'Abandon ship!'", "'We are lost!'", "'All hands on deck!'", "'Prepare the lifeboats!'"),
            correctAnswer = "'We are lost!'",
            explanation = "Even the experienced captain lost hope, staggering into the cabin and groaning 'We are lost!'"
        ),
        QuestionModel(
            id = "s_10_eng_14_5",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "Who restored hope and courage to everyone in that moment of despair?",
            options = listOf("A brave veteran sailor who took the wheel", "The captain's innocent little daughter", "A traveling priest who read scripture", "The ship's first mate"),
            correctAnswer = "The captain's innocent little daughter",
            explanation = "The captain's young daughter took his cold hand and brought solace with her innocent question."
        ),
        QuestionModel(
            id = "s_10_eng_14_6",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "What innocent, profound question did the little girl ask her father?",
            options = listOf("'Will morning come soon?'", "'Isn't God upon the ocean, just the same as on the land?'", "'Can we swim to the nearest island?'", "'Where are all the lighthouses?'"),
            correctAnswer = "'Isn't God upon the ocean, just the same as on the land?'",
            explanation = "Her childlike faith reminded them that God's protection encompasses the ocean just as it does the land."
        ),
        QuestionModel(
            id = "s_10_eng_14_7",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "What transformative effect did the little girl's words have on the terrified passengers?",
            options = listOf("They laughed at her childish innocence", "They felt a wave of peace, kissed the little maiden, and prayed with renewed faith", "They rushed onto the deck to launch lifeboats", "They ignored her completely"),
            correctAnswer = "They felt a wave of peace, kissed the little maiden, and prayed with renewed faith",
            explanation = "Her words dispelled their terror; they kissed her, and calm faith replaced their despair."
        ),
        QuestionModel(
            id = "s_10_eng_14_8",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "What happened when the storm subsided and morning broke?",
            options = listOf("The ship sank beneath the waves", "The ship weathered the gale and anchored safely in the quiet harbor", "They drifted aimlessly on a deserted shore", "A rescue frigate towed them into port"),
            correctAnswer = "The ship weathered the gale and anchored safely in the quiet harbor",
            explanation = "With God's grace, the ship survived the tempest and sailed safely into harbor at dawn."
        ),
        QuestionModel(
            id = "s_10_eng_14_9",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "Fill in the blank: The poem highlights that childlike _________ can overcome overwhelming terror.",
            options = listOf("curiosity", "faith and innocence", "ignorance", "stubbornness"),
            correctAnswer = "faith and innocence",
            explanation = "Childlike faith in divine mercy can bring calm and courage during life's fiercest tempests."
        ),
        QuestionModel(
            id = "s_10_eng_14_10",
            stdId = 10,
            subjectId = "english",
            unitId = 14,
            type = "MCQ",
            questionText = "What poetic genre does 'Ballad of the Tempest' belong to?",
            options = listOf("Lyrical ballad", "Satirical parody", "Epic canto", "Dramatic monologue"),
            correctAnswer = "Lyrical ballad",
            explanation = "It is a narrative ballad recounting an emotional and dramatic event with rhythmic stanzas."
        ),
        // ========================================================
        // 🟦 UNIT 15 – POEM 7: THE BLIND BOY
        // ========================================================
        QuestionModel(
            id = "s_10_eng_15_1",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "Who is the speaker in Colley Cibber's touching poem 'The Blind Boy'?",
            options = listOf("An elderly physician examining eye patients", "A boy who has been blind since birth", "A loving mother comforting her disabled child", "A schoolteacher teaching Braille"),
            correctAnswer = "A boy who has been blind since birth",
            explanation = "The poem is voiced directly by a cheerful boy who has never possessed the gift of sight."
        ),
        QuestionModel(
            id = "s_10_eng_15_2",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "What great blessing of nature does the blind boy say he can never enjoy?",
            options = listOf("The sweet taste of honey", "The wonderful sight of the sun and the golden light of day", "The soft sound of singing birds", "The cool touch of morning dew"),
            correctAnswer = "The wonderful sight of the sun and the golden light of day",
            explanation = "The boy asks: 'O say what is that thing call'd light, Which I must ne'er enjoy?'"
        ),
        QuestionModel(
            id = "s_10_eng_15_3",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "How does the blind boy distinguish between day and night without sight?",
            options = listOf("By asking his parents every hour", "By feeling the temperature of the air", "He creates his own day and night: whenever he plays it is day, and whenever he sleeps it is night", "By listening to church bells"),
            correctAnswer = "He creates his own day and night: whenever he plays it is day, and whenever he sleeps it is night",
            explanation = "He makes his own day and night: 'My day or night myself I make, Whene'er I sleep or play.'"
        ),
        QuestionModel(
            id = "s_10_eng_15_4",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "How can the blind boy perceive the presence of the sun?",
            options = listOf("By smelling the sunlight", "He can feel the warmth of the sun upon his skin", "By seeing faint shadows", "By hearing the sun's rays"),
            correctAnswer = "He can feel the warmth of the sun upon his skin",
            explanation = "He notes: 'I feel him warm, but how can he / Or make it day or night?'"
        ),
        QuestionModel(
            id = "s_10_eng_15_5",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "Why does the blind boy urge others not to pity or grieve for his blindness?",
            options = listOf("Because he is planning an eye surgery", "Because he cannot miss or mourn a loss he has never known", "Because pity makes him angry", "Because he thinks everyone is blind"),
            correctAnswer = "Because he cannot miss or mourn a loss he has never known",
            explanation = "Having never seen light, he feels no grief over its absence and urges others not to pity him."
        ),
        QuestionModel(
            id = "s_10_eng_15_6",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "What wise resolution does the blind boy make regarding his peace of mind?",
            options = listOf("He will spend his life seeking a cure", "He will never allow what he cannot have to destroy his cheer of mind", "He will isolate himself from society", "He will write complaints to authorities"),
            correctAnswer = "He will never allow what he cannot have to destroy his cheer of mind",
            explanation = "He resolves: 'Then let not what I cannot have / My cheer of mind destroy.'"
        ),
        QuestionModel(
            id = "s_10_eng_15_7",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "What proud title does the boy claim for himself in the final stanza of the poem?",
            options = listOf("'A prince of darkness'", "'A king, although a poor blind boy'", "'A master of music'", "'A champion of patience'"),
            correctAnswer = "'A king, although a poor blind boy'",
            explanation = "Content with his cheerful spirit, he proudly sings: 'Whilst thus I sing, I am a king, Although a poor blind boy.'"
        ),
        QuestionModel(
            id = "s_10_eng_15_8",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "Fill in the blank: The poem emphasizes that true happiness originates from _________ rather than physical circumstances.",
            options = listOf("enormous wealth", "inner contentment and acceptance", "flattery from peers", "frequent travel"),
            correctAnswer = "inner contentment and acceptance",
            explanation = "The poem teaches that serenity comes from an attitude of gratitude and cheerful acceptance."
        ),
        QuestionModel(
            id = "s_10_eng_15_9",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "What is the primary tone of the blind boy throughout the poem?",
            options = listOf("Bitter and resentful", "Cheerful, optimistic, and self-reliant", "Sarcastic and hopeless", "Cold and unfeeling"),
            correctAnswer = "Cheerful, optimistic, and self-reliant",
            explanation = "The speaker is remarkably upbeat, philosophical, and free from self-pity."
        ),
        QuestionModel(
            id = "s_10_eng_15_10",
            stdId = 10,
            subjectId = "english",
            unitId = 15,
            type = "MCQ",
            questionText = "Complete the line: 'With heavy sighs I often hear / You mourn my _________ woe.'",
            options = listOf("unbearable", "hapless", "endless", "terrible"),
            correctAnswer = "hapless",
            explanation = "Cibber writes: 'With heavy sighs I often hear / You mourn my hapless woe; / But sure with patience I can bear / A loss I ne'er can know.'"
        ),
        // ========================================================
        // 🟦 UNIT 16 – POEM 8: OFF TO OUTER SPACE TOMORROW MORNING
        // ========================================================
        QuestionModel(
            id = "s_10_eng_16_1",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "Who is the speaker in Norman Nicholson's poem 'Off to Outer Space Tomorrow Morning'?",
            options = listOf("An astronomer peering through a giant telescope", "An astronaut preparing for a solitary space mission", "A flight technician at the launch control pad", "A schoolboy dreaming of rockets"),
            correctAnswer = "An astronaut preparing for a solitary space mission",
            explanation = "The speaker is an astronaut dressed in his space-suit on the eve of launching into orbit."
        ),
        QuestionModel(
            id = "s_10_eng_16_2",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "Why does the astronaut tell his friends to take a last look at him?",
            options = listOf("Because he is moving to another city", "Because he is about to be launched into orbit and will be completely isolated", "Because he is retiring from his career", "Because he won't be visible in his suit"),
            correctAnswer = "Because he is about to be launched into orbit and will be completely isolated",
            explanation = "He tells companions to look at him today because tomorrow he will be orbiting far out in outer space."
        ),
        QuestionModel(
            id = "s_10_eng_16_3",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "What everyday communications will be totally absent during the space flight?",
            options = listOf("Television broadcasts only", "No letters, no post, no phone calls, and no visitors", "Radio communications with ground control", "Engine sensor readings"),
            correctAnswer = "No letters, no post, no phone calls, and no visitors",
            explanation = "The astronaut explains that no mailman will deliver letters, no phone will ring, and no friends will visit."
        ),
        QuestionModel(
            id = "s_10_eng_16_4",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "How does zero gravity affect ordinary objects inside the space capsule?",
            options = listOf("They become infinitely heavy and stick to the floor", "Objects like a teacup will float around like a planet revolving in orbit", "They dissolve into thin air", "They spin rapidly like tops"),
            correctAnswer = "Objects like a teacup will float around like a planet revolving in orbit",
            explanation = "In the gravity-free environment, cups and items float mid-air in orbital mechanics."
        ),
        QuestionModel(
            id = "s_10_eng_16_5",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "What paradoxical idea does the astronaut express about being 'locked up'?",
            options = listOf("He is locked in a prison cell", "Rather than him being locked in space, the whole world and humanity are being locked away from him", "His capsule doors cannot open", "Space is a tiny locked room"),
            correctAnswer = "Rather than him being locked in space, the whole world and humanity are being locked away from him",
            explanation = "He wittily asserts that when the capsule doors seal, the entire Earth is locked outside."
        ),
        QuestionModel(
            id = "s_10_eng_16_6",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "What will happen to normal tracking of time, calendars, and clocks in space?",
            options = listOf("Clocks will run twice as fast", "There will be no calendars, no tracking of daylight or night, and no routine weekdays", "Every day will be marked as Sunday", "Time will freeze completely"),
            correctAnswer = "There will be no calendars, no tracking of daylight or night, and no routine weekdays",
            explanation = "Outside planetary rotation, standard calendar days and seasons cease to have normal meaning."
        ),
        QuestionModel(
            id = "s_10_eng_16_7",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "Fill in the blank: The countdown before rocket launch proceeds as: 'In _________, seven, six, five, four, three, two, one, zero.'",
            options = listOf("nine, eight", "ten, nine", "twelve, eleven", "twenty, fifteen"),
            correctAnswer = "nine, eight",
            explanation = "The poem echoes the dramatic launch countdown: 'In nine, eight, seven, six, five, four, three, two, one, zero...'"
        ),
        QuestionModel(
            id = "s_10_eng_16_8",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "What is the overall mood and tone of the poem?",
            options = listOf("Gloomy, fearful, and tragic", "Light-hearted, humorous, and delightfully futuristic", "Aggressive and combative", "Dry and purely factual"),
            correctAnswer = "Light-hearted, humorous, and delightfully futuristic",
            explanation = "Nicholson uses an upbeat, rhythmic, and whimsical voice to capture the thrill of space exploration."
        ),
        QuestionModel(
            id = "s_10_eng_16_9",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "Complete the line: 'You can cross out my name from the _________ book; I'm off to outer space tomorrow morning.'",
            options = listOf("telephone", "attendance", "history", "library"),
            correctAnswer = "telephone",
            explanation = "The poet tells acquaintances to strike his name from the telephone book as he won't be receiving calls."
        ),
        QuestionModel(
            id = "s_10_eng_16_10",
            stdId = 10,
            subjectId = "english",
            unitId = 16,
            type = "MCQ",
            questionText = "Why does the poet describe space travel as a 'solitary confinement'?",
            options = listOf("Because space agencies punish astronauts", "Because an astronaut in a solo craft is completely cut off from the physical presence of other human beings", "Because space capsules have no windows", "Because space missions last for fifty years"),
            correctAnswer = "Because an astronaut in a solo craft is completely cut off from the physical presence of other human beings",
            explanation = "He uses the metaphor of solitary confinement to depict absolute detachment from human society."
        ),
        // ========================================================
        // 🟦 UNIT 17 – SUPPLEMENTARY 1: NARAYANPUR INCIDENT
        // ========================================================
        QuestionModel(
            id = "s_10_eng_17_1",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "What historical freedom movement forms the backdrop of the story 'Narayanpur Incident' by Diti Sen?",
            options = listOf("Non-Cooperation Movement of 1920", "Quit India Movement of August 1942", "Salt Satyagraha of 1930", "Swadeshi Movement of 1905"),
            correctAnswer = "Quit India Movement of August 1942",
            explanation = "The story takes place in the small town of Narayanpur during the Quit India agitation of 1942."
        ),
        QuestionModel(
            id = "s_10_eng_17_2",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "Who led the student procession through the streets of Narayanpur?",
            options = listOf("Babu and Manju", "Mohan, a college student", "Sub-Inspector Patil", "The school headmaster"),
            correctAnswer = "Mohan, a college student",
            explanation = "Mohan and his fellow college students organized and led the student protest march."
        ),
        QuestionModel(
            id = "s_10_eng_17_3",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "What was unusual about the students' march that surprised onlookers and police alike?",
            options = listOf("They were throwing stones at government offices", "They marched in absolute pin-drop silence without shouting any slogans", "They arrived on horseback", "They carried weapons and torches"),
            correctAnswer = "They marched in absolute pin-drop silence without shouting any slogans",
            explanation = "The march was completely silent; they walked quietly to avoid giving the police an excuse to lathi-charge or arrest them."
        ),
        QuestionModel(
            id = "s_10_eng_17_4",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "What portrait was carried by the students at the head of the procession?",
            options = listOf("Subhas Chandra Bose", "Mahatma Gandhi", "Jawaharlal Nehru", "Bhagat Singh"),
            correctAnswer = "Mahatma Gandhi",
            explanation = "A girl student carried a framed photograph of Mahatma Gandhi at the front of the silent march."
        ),
        QuestionModel(
            id = "s_10_eng_17_5",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "What secret machine had Mohan and his friends brought into their home at night?",
            options = listOf("A telegraph transmitter", "A cyclostyling machine (duplicator)", "A firearms casting mould", "A shortwave radio receiver"),
            correctAnswer = "A cyclostyling machine (duplicator)",
            explanation = "They brought a secret cyclostyling machine to produce underground copies of Mahatma Gandhi's speech."
        ),
        QuestionModel(
            id = "s_10_eng_17_6",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "Who were Babu and Manju in the story?",
            options = listOf("Neighbouring spies working for the police", "Mohan's younger school-going brother and sister", "British intelligence officers", "Village farmers"),
            correctAnswer = "Mohan's younger school-going brother and sister",
            explanation = "Babu and Manju were Mohan's curious younger siblings who stayed up late to watch the machine."
        ),
        QuestionModel(
            id = "s_10_eng_17_7",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "Who was Sub-Inspector Patil and why did he arrive at their house unexpectedly at night?",
            options = listOf("He came to arrest Mohan immediately", "He was a former school friend of their father who secretly supported freedom and came to warn them of an impending police raid", "He came to inspect their household rations", "He wanted to join the students' college protest"),
            correctAnswer = "He was a former school friend of their father who secretly supported freedom and came to warn them of an impending police raid",
            explanation = "Patil was a family friend in the police who took immense personal risk to alert them of a police search."
        ),
        QuestionModel(
            id = "s_10_eng_17_8",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "How did Sub-Inspector Patil save the family and the secret mission?",
            options = listOf("He bribed the British Deputy Superintendent", "He took the cyclostyling machine with him to hide it safely before the raiding police party arrived", "He destroyed all paper sheets in the house", "He advised Mohan to flee to the jungle"),
            correctAnswer = "He took the cyclostyling machine with him to hide it safely before the raiding police party arrived",
            explanation = "Patil carried away the cyclostyling machine in his own care, leaving the house clean when the police arrived."
        ),
        QuestionModel(
            id = "s_10_eng_17_9",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "Fill in the blank: When the raiding police party finally knocked on the door, they found _________.",
            options = listOf("a mountain of printed leaflets", "nothing incriminating whatsoever", "Mohan operating the duplicator", "Babu holding Mahatma's portrait"),
            correctAnswer = "nothing incriminating whatsoever",
            explanation = "Thanks to Patil's timely intervention, the search party found no evidence and left empty-handed."
        ),
        QuestionModel(
            id = "s_10_eng_17_10",
            stdId = 10,
            subjectId = "english",
            unitId = 17,
            type = "MCQ",
            questionText = "What does the story 'Narayanpur Incident' demonstrate about the Indian freedom struggle?",
            options = listOf("Only armed soldiers contributed to independence", "People from all walks of life, including students, women, and sympathetic police personnel, bravely resisted British rule", "The Quit India Movement was confined only to major metropolitan cities", "Silent protests were ineffective"),
            correctAnswer = "People from all walks of life, including students, women, and sympathetic police personnel, bravely resisted British rule",
            explanation = "The tale highlights the unity, courage, and ingenuity of ordinary citizens during the freedom movement."
        ),
        // ========================================================
        // 🟦 UNIT 18 – SUPPLEMENTARY 2: ON TOP OF THE WORLD
        // ========================================================
        QuestionModel(
            id = "s_10_eng_18_1",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "What historic world record did Dickey Dolma set on May 10, 1993?",
            options = listOf("Fastest solo trek across Antarctica", "Youngest woman in the world to scale Mount Everest at the age of nineteen", "First person to ski down K2", "Youngest pilot to fly over the Himalayas"),
            correctAnswer = "Youngest woman in the world to scale Mount Everest at the age of nineteen",
            explanation = "At just 19 years old, Dickey Dolma became the youngest woman in history to stand on the summit of Mount Everest."
        ),
        QuestionModel(
            id = "s_10_eng_18_2",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "Where was Dickey Dolma born and raised?",
            options = listOf("Leh, Ladakh", "Palchan village near Manali in Himachal Pradesh", "Darjeeling, West Bengal", "Shimla, Himachal Pradesh"),
            correctAnswer = "Palchan village near Manali in Himachal Pradesh",
            explanation = "She was born in Palchan, a scenic mountain village near Manali in Himachal Pradesh."
        ),
        QuestionModel(
            id = "s_10_eng_18_3",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "Which premier institute provided Dickey Dolma with her basic and advanced mountaineering training?",
            options = listOf("Himalayan Mountaineering Institute, Darjeeling", "Western Himalayan Mountaineering Institute, Manali", "Nehru Institute of Mountaineering, Uttarkashi", "Indian Military Academy, Dehradun"),
            correctAnswer = "Western Himalayan Mountaineering Institute, Manali",
            explanation = "She trained at the Western Himalayan Mountaineering Institute in Manali, securing 'A' grades in all courses."
        ),
        QuestionModel(
            id = "s_10_eng_18_4",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "What personal familial hardships did Dickey Dolma suffer in her early youth?",
            options = listOf("She lost her home in an avalanche", "She lost her mother when she was just eleven and her elder brother soon after, while her father was bedridden", "Her family opposed her joining sports", "She had to abandon school to work in farms"),
            correctAnswer = "She lost her mother when she was just eleven and her elder brother soon after, while her father was bedridden",
            explanation = "Her mother passed away when Dolma was 11, followed by her brother's demise and financial distress."
        ),
        QuestionModel(
            id = "s_10_eng_18_5",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "What daily physical preparation did Dickey Dolma undergo before the Everest expedition?",
            options = listOf("Four hours of daily rigorous training, carrying heavy rucksacks, running, and endurance exercises", "Swimming ten kilometres daily", "Practicing yoga in monasteries", "Weightlifting in commercial gyms"),
            correctAnswer = "Four hours of daily rigorous training, carrying heavy rucksacks, running, and endurance exercises",
            explanation = "She devoted at least four hours daily to gruelling fitness routines to build mountaineering stamina."
        ),
        QuestionModel(
            id = "s_10_eng_18_6",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "What profound emotional feeling overcame Dickey Dolma when she finally stood on the peak of Everest?",
            options = listOf("She felt terrified of climbing down", "She felt awestruck, hoisted the Indian Tricolour, and sang the National Anthem with tears of joy", "She felt disappointed by the snowstorms", "She thought of opening a mountaineering school immediately"),
            correctAnswer = "She felt awestruck, hoisted the Indian Tricolour, and sang the National Anthem with tears of joy",
            explanation = "Standing atop the world, she was flooded with sublime pride, planting the Indian flag on the highest crest."
        ),
        QuestionModel(
            id = "s_10_eng_18_7",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "Fill in the blank: Dickey Dolma states that success in life requires one hundred percent _________ and hard work.",
            options = listOf("luck", "dedication", "money", "patronage"),
            correctAnswer = "dedication",
            explanation = "She emphasizes that passion, total dedication, and persistence are keys to conquering life's challenges."
        ),
        QuestionModel(
            id = "s_10_eng_18_8",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "Besides mountaineering, in which winter adventure sport was Dickey Dolma a national champion?",
            options = listOf("Ice hockey", "Skiing", "Figure skating", "Snowboarding"),
            correctAnswer = "Skiing",
            explanation = "Dolma was a talented national-level skier, winning medals in national winter championships."
        ),
        QuestionModel(
            id = "s_10_eng_18_9",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "What lesson does Dickey Dolma's life story impart to students?",
            options = listOf("Mountain climbing is only for wealthy people", "Poverty, grief, and harsh obstacles can be overcome through grit, determination, and courage", "Young people should never take physical risks", "One should only choose easy careers"),
            correctAnswer = "Poverty, grief, and harsh obstacles can be overcome through grit, determination, and courage",
            explanation = "Her inspiring journey shows that unyielding resolve can surmount the highest hurdles."
        ),
        QuestionModel(
            id = "s_10_eng_18_10",
            stdId = 10,
            subjectId = "english",
            unitId = 18,
            type = "MCQ",
            questionText = "Complete the sentence: When asked about her secret to success, Dolma replied that one must always be ready to face _________.",
            options = listOf("defeat without trying", "hardships, challenges, and never give up halfway", "only favorable weather", "wealthy sponsors"),
            correctAnswer = "hardships, challenges, and never give up halfway",
            explanation = "Her philosophy is to embrace hardships with courage and persevere till the summit is conquered."
        ),
        // ========================================================
        // 🟦 UNIT 19 – SUPPLEMENTARY 3: A GREAT MARTYR EVER CHERISHED
        // ========================================================
        QuestionModel(
            id = "s_10_eng_19_1",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "Which major war and military operation is central to the martyrdom of Major Padmapani Acharya?",
            options = listOf("1971 Indo-Pak Liberation War", "1999 Kargil War (Operation Vijay)", "1965 Indo-Pak Conflict", "1962 Sino-Indian War"),
            correctAnswer = "1999 Kargil War (Operation Vijay)",
            explanation = "Major Padmapani Acharya made the supreme sacrifice during Operation Vijay in the 1999 Kargil War."
        ),
        QuestionModel(
            id = "s_10_eng_19_2",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "Which strategic enemy-occupied position in the Drass sector was Major Acharya tasked to capture?",
            options = listOf("Tiger Hill summit", "Tololing Knoll", "Siachen Glacier base", "Point 4875"),
            correctAnswer = "Tololing Knoll",
            explanation = "His company in the 2nd Rajputana Rifles was assigned the perilous mission of capturing the heavily fortified Tololing Knoll."
        ),
        QuestionModel(
            id = "s_10_eng_19_3",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "Which prestigious gallantry decoration was posthumously awarded to Major Padmapani Acharya?",
            options = listOf("Param Vir Chakra (PVC)", "Maha Vir Chakra (MVC)", "Kirti Chakra", "Shaurya Chakra"),
            correctAnswer = "Maha Vir Chakra (MVC)",
            explanation = "For his conspicuous bravery and supreme leadership, he was awarded India's second-highest military honour, the Maha Vir Chakra."
        ),
        QuestionModel(
            id = "s_10_eng_19_4",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "How did Major Acharya act when intense enemy artillery and machine-gun fire pinned down his platoon?",
            options = listOf("He ordered a retreat down the slope", "He fearlessly crawled forward under heavy fire, lobbed grenades into enemy bunkers, and neutralized the post", "He waited for air force fighter jets to bomb the hill", "He radioed for surrender terms"),
            correctAnswer = "He fearlessly crawled forward under heavy fire, lobbed grenades into enemy bunkers, and neutralized the post",
            explanation = "Undeterred by bullet wounds, he charged the enemy bunker single-handedly and cleared the position before breathing his last."
        ),
        QuestionModel(
            id = "s_10_eng_19_5",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "In his poignant final letter to his family, what scripture did Major Acharya advise his loved ones to read?",
            options = listOf("The Ramayana", "The Bhagavad Gita", "The Upanishads", "The Bible"),
            correctAnswer = "The Bhagavad Gita",
            explanation = "He urged his family to read the Bhagavad Gita, seek solace in righteous duty (Dharma), and avoid sorrow."
        ),
        QuestionModel(
            id = "s_10_eng_19_6",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "Who was Charulata in relation to Major Padmapani Acharya?",
            options = listOf("His younger sister who was an army doctor", "His pregnant wife who showed exemplary courage and poise in her grief", "His school teacher in Hyderabad", "His grandmother"),
            correctAnswer = "His pregnant wife who showed exemplary courage and poise in her grief",
            explanation = "His brave wife Charulata was pregnant with their daughter (Aparajita) when the Major laid down his life."
        ),
        QuestionModel(
            id = "s_10_eng_19_7",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "What was Major Acharya's father's military background?",
            options = listOf("He was an admiral in the Indian Navy", "He was a retired Wing Commander of the Indian Air Force (Wing Commander Jagannath Acharya)", "He was a civilian defence secretary", "He was a general in the infantry"),
            correctAnswer = "He was a retired Wing Commander of the Indian Air Force (Wing Commander Jagannath Acharya)",
            explanation = "His father, Wing Commander (Retd.) Jagannath Acharya, proudly affirmed that his son had performed his sacred duty to the motherland."
        ),
        QuestionModel(
            id = "s_10_eng_19_8",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "Fill in the blank: Major Acharya believed that serving the motherland is the highest _________ of a soldier.",
            options = listOf("business", "dharma (duty)", "hobby", "comfort"),
            correctAnswer = "dharma (duty)",
            explanation = "For Major Acharya, defending the nation was the ultimate dharma, above personal life and safety."
        ),
        QuestionModel(
            id = "s_10_eng_19_9",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "What name was given to the daughter born to Charulata after Major Acharya's martyrdom?",
            options = listOf("Padmapriya", "Aparajita (The Undefeated)", "Vijayalakshmi", "Kalyani"),
            correctAnswer = "Aparajita (The Undefeated)",
            explanation = "Their daughter was named Aparajita, symbolizing the unconquered valour of her heroic father."
        ),
        QuestionModel(
            id = "s_10_eng_19_10",
            stdId = 10,
            subjectId = "english",
            unitId = 19,
            type = "MCQ",
            questionText = "What enduring legacy does Major Padmapani Acharya leave behind for the citizens of India?",
            options = listOf("That military careers are financially lucrative", "An eternal example of selflessness, patriotism, and supreme sacrifice for the security of our nation", "That wars can be avoided by surrendering territory", "That youth should avoid defence services"),
            correctAnswer = "An eternal example of selflessness, patriotism, and supreme sacrifice for the security of our nation",
            explanation = "His supreme sacrifice remains an inspiring beacon of patriotism and duty."
        ),
        // ========================================================
        // 🟦 UNIT 20 – SUPPLEMENTARY 4: THE BIRD OF HAPPINESS
        // ========================================================
        QuestionModel(
            id = "s_10_eng_20_1",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "What folk heritage does the enchanting story 'The Bird of Happiness' originate from?",
            options = listOf("Japanese folklore", "Tibetan folktale", "Persian fable", "Mongolian legend"),
            correctAnswer = "Tibetan folktale",
            explanation = "'The Bird of Happiness' is a celebrated traditional folk story from Tibet."
        ),
        QuestionModel(
            id = "s_10_eng_20_2",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "Why were the people of ancient Tibet living in immense misery and sorrow?",
            options = listOf("They were invaded by foreign emperors", "Their land was barren, frozen, lacking warmth, food, and water, guarded by cruel monsters", "They had forgotten how to farm", "A flood had washed away their temples"),
            correctAnswer = "Their land was barren, frozen, lacking warmth, food, and water, guarded by cruel monsters",
            explanation = "The people suffered bitter cold, famine, rocky soils, and the tyranny of three dreadful monsters."
        ),
        QuestionModel(
            id = "s_10_eng_20_3",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "What was the legendary promise regarding the Bird of Happiness?",
            options = listOf("It laid golden eggs every morning", "Wherever it flew, warmth, fragrant blossoms, gushing rivers, and joyful abundance would flourish", "It granted wishes for immortality", "It built golden houses for villagers"),
            correctAnswer = "Wherever it flew, warmth, fragrant blossoms, gushing rivers, and joyful abundance would flourish",
            explanation = "The Bird of Happiness brought eternal spring, bountiful harvests, flowing streams, and unending joy."
        ),
        QuestionModel(
            id = "s_10_eng_20_4",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "Who was the brave Tibetan lad who volunteered to journey to the far mountain to find the bird?",
            options = listOf("Tenzing", "Wangjia", "Norbu", "Dorjee"),
            correctAnswer = "Wangjia",
            explanation = "Young Wangjia boldly undertook the dangerous quest on behalf of his starving people."
        ),
        QuestionModel(
            id = "s_10_eng_20_5",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "What punishment did the first monster with a beard of green stone inflict on Wangjia?",
            options = listOf("Threw him into a cage of wild leopards", "Forced him to walk nine hundred miles over scree and razor-sharp stones until his shoes tore and his feet bled", "Turned his skin into stone", "Forced him to dig a deep trench"),
            correctAnswer = "Forced him to walk nine hundred miles over scree and razor-sharp stones until his shoes tore and his feet bled",
            explanation = "Wangjia was forced to march across 900 miles of sharp gravel, cutting his soles to ribbons."
        ),
        QuestionModel(
            id = "s_10_eng_20_6",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "What ordeal did the second monster with a belly like a mountain impose on Wangjia?",
            options = listOf("Forced him to swim across an ocean of boiling oil", "Demanded he eat poisonous dirt and starve across nine hundred miles of barren wasteland", "Locked him inside a dark cavern", "Forced him to carry a boulder uphill"),
            correctAnswer = "Demanded he eat poisonous dirt and starve across nine hundred miles of barren wasteland",
            explanation = "The second monster starved him, making him crawl through 900 miles of desert with an empty stomach."
        ),
        QuestionModel(
            id = "s_10_eng_20_7",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "What cruel cruelty did the third monster with an old woman's face inflict on Wangjia?",
            options = listOf("Severed both his hands", "Gouged out both his eyes, forcing him to grope blindly for nine hundred miles", "Cut off his tongue so he could not speak", "Poured molten lead into his ears"),
            correctAnswer = "Gouged out both his eyes, forcing him to grope blindly for nine hundred miles",
            explanation = "The cruel monster tore out his eyes, leaving him to crawl 900 miles in total darkness over jagged cliffs."
        ),
        QuestionModel(
            id = "s_10_eng_20_8",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "How did the Bird of Happiness react when the blind, bleeding, exhausted Wangjia reached its mountain?",
            options = listOf("It flew away in fear", "It was deeply touched by his selfless sacrifice, stroked his eyes to restore his sight, healed his wounds, and fed him", "It turned Wangjia into a bird", "It asked him for gold and jewels"),
            correctAnswer = "It was deeply touched by his selfless sacrifice, stroked his eyes to restore his sight, healed his wounds, and fed him",
            explanation = "The Bird tenderly caressed Wangjia, restored his vision, cured his lacerated limbs, and embraced him."
        ),
        QuestionModel(
            id = "s_10_eng_20_9",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "What miracle occurred when Wangjia returned to Tibet riding on the back of the Bird of Happiness?",
            options = listOf("All stones turned into gold coins", "The barren lands blossomed with green forests, crystal rivers flowed, and the people lived in abundance and joy", "The three monsters became kings of Tibet", "The villagers decided to leave Tibet"),
            correctAnswer = "The barren lands blossomed with green forests, crystal rivers flowed, and the people lived in abundance and joy",
            explanation = "The bird's golden wings brought warm breezes, melting ice, lush crops, fruit trees, and lasting happiness."
        ),
        QuestionModel(
            id = "s_10_eng_20_10",
            stdId = 10,
            subjectId = "english",
            unitId = 20,
            type = "MCQ",
            questionText = "What moral virtue is exalted through Wangjia's perilous quest?",
            options = listOf("Greed for personal wealth", "Selfless dedication, endurance, and willingness to sacrifice one's comfort for the happiness of others", "Clever deception of adversaries", "Avoiding any physical difficulty"),
            correctAnswer = "Selfless dedication, endurance, and willingness to sacrifice one's comfort for the happiness of others",
            explanation = "Wangjia represents pure selflessness; he endured unspeakable agony so that his people might taste joy."
        ),
        // ========================================================
        // 🟦 UNIT 21 – GRAMMAR, VOCABULARY & LANGUAGE STUDY
        // ========================================================
        QuestionModel(
            id = "s_10_eng_21_1",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Which word collocates correctly with 'commit'?",
            options = listOf("a mistake", "a crime", "a speech", "an effort"),
            correctAnswer = "a crime",
            explanation = "In English collocations, one 'commits a crime' or 'commits an offence'."
        ),
        QuestionModel(
            id = "s_10_eng_21_2",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "How many syllables are present in the word 'determination'?",
            options = listOf("Three (3)", "Four (4)", "Five (5)", "Six (6)"),
            correctAnswer = "Five (5)",
            explanation = "The word is syllabified as de-ter-mi-na-tion (5 syllables)."
        ),
        QuestionModel(
            id = "s_10_eng_21_3",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Which negative prefix should be added to the word 'patient' to form its antonym?",
            options = listOf("un-", "in-", "im-", "dis-"),
            correctAnswer = "im-",
            explanation = "The correct antonym of 'patient' is 'impatient'."
        ),
        QuestionModel(
            id = "s_10_eng_21_4",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Choose the correct question tag: 'The students wrote the examination well, _________?'",
            options = listOf("did they?", "didn't they?", "weren't they?", "haven't they?"),
            correctAnswer = "didn't they?",
            explanation = "The statement is in past simple positive ('wrote'), so the question tag is negative: 'didn't they?'."
        ),
        QuestionModel(
            id = "s_10_eng_21_5",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Identify the language function in the sentence: 'Could you please lend me your English dictionary for an hour?'",
            options = listOf("Offering advice", "Making a polite request", "Expressing sympathy", "Seeking permission"),
            correctAnswer = "Making a polite request",
            explanation = "'Could you please...' is standard phrasing for making a courteous request."
        ),
        QuestionModel(
            id = "s_10_eng_21_6",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Fill in the blank with the correct conditional form: 'If Baleshwar had not jumped onto the tracks, Roma _________.'",
            options = listOf("would bleed to death", "would have bled to death", "will bleed to death", "shall have bled to death"),
            correctAnswer = "would have bled to death",
            explanation = "Third conditional rule: If + had + past participle (had jumped), main clause uses would have + past participle."
        ),
        QuestionModel(
            id = "s_10_eng_21_7",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Choose the correct passive voice: 'Pandit Ravi Shankar played the sitar with divine mastery.'",
            options = listOf("The sitar is played by Pandit Ravi Shankar with divine mastery.", "The sitar was played by Pandit Ravi Shankar with divine mastery.", "The sitar had been playing by Pandit Ravi Shankar.", "The sitar was being played by Pandit Ravi Shankar."),
            correctAnswer = "The sitar was played by Pandit Ravi Shankar with divine mastery.",
            explanation = "Past simple active ('played') converts to past simple passive ('was played')."
        ),
        QuestionModel(
            id = "s_10_eng_21_8",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Select the appropriate homophone to complete the sentence: 'The school _________ addressed the morning assembly on moral values.'",
            options = listOf("principle", "principal", "prinsepal", "princypal"),
            correctAnswer = "principal",
            explanation = "'Principal' refers to the head of an institution, whereas 'principle' refers to a fundamental truth or moral rule."
        ),
        QuestionModel(
            id = "s_10_eng_21_9",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Choose the correct preposition: 'Dr. B. R. Ambedkar fought relentlessly _________ social discrimination and untouchability.'",
            options = listOf("against", "with", "between", "over"),
            correctAnswer = "against",
            explanation = "One fights 'against' social evils or injustices."
        ),
        QuestionModel(
            id = "s_10_eng_21_10",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Identify the correct reported speech: Swami said, 'I have a terrible headache.'",
            options = listOf("Swami said that he has a terrible headache.", "Swami said that he had a terrible headache.", "Swami told that I had a terrible headache.", "Swami asked if he had a terrible headache."),
            correctAnswer = "Swami said that he had a terrible headache.",
            explanation = "Present simple ('have') shifts back to past simple ('had'), and 1st person 'I' changes to 3rd person 'he'."
        ),
        QuestionModel(
            id = "s_10_eng_21_11",
            stdId = 10,
            subjectId = "english",
            unitId = 21,
            type = "MCQ",
            questionText = "Which word collocates correctly with 'prompt'?",
            options = listOf("attention", "payment", "mistake", "crime"),
            correctAnswer = "payment",
            explanation = "'Prompt payment' is a standard business and language collocation."
        )
    )
}
