package com.example.data

/**
 * Karnataka Public Service Commission (KPSC — KAS / FDA / SDA / PDO) Question Bank.
 * Standard / Exam ID: 15.
 * Covers: Karnataka History & Culture, Indian Polity & Constitution,
 * Geography & Indian Economy, General Science & Tech, and CSAT Mental Ability.
 */
object KpscQuestionBank {

    val karnatakaHistoryUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Kadambas, Chalukyas, Rashtrakutas & Hoysalas", 5, "Medium"),
        UnitTemplate(2, "Unit 2: Vijayanagara, Mysuru Wodeyars & Ekikarana", 5, "Medium")
    )

    val polityUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Fundamental Rights, DPSP & Amendments", 5, "Medium"),
        UnitTemplate(2, "Unit 2: Parliament, Judiciary & Panchayat Raj", 5, "Hard")
    )

    val geoEconomyUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Physical Geography of India & Karnataka Rivers", 5, "Easy"),
        UnitTemplate(2, "Unit 2: Indian Economy, RBI, NITI Aayog & Budgets", 5, "Hard")
    )

    val scienceTechUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Everyday Physics, Chemistry & Biology", 5, "Easy"),
        UnitTemplate(2, "Unit 2: ISRO Space Missions, Defence & Digital India", 5, "Medium")
    )

    val mentalAbilityUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Quantitative Aptitude, Ratios & Time-Work", 5, "Medium"),
        UnitTemplate(2, "Unit 2: Analytical Reasoning, Directions & Blood Relations", 5, "Medium")
    )

    val karnatakaHistoryQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscKarnatakaHistory") {
            listOf(
                QuestionModel(
                    id = "kpsc_kh_u1_q1",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Who founded the Kadamba dynasty of Banavasi, the first indigenous royal dynasty of Karnataka?",
                    options = listOf("Mayurasharma", "Pulakeshin II", "Vishnuvardhana", "Dantidurga"),
                    correctAnswer = "Mayurasharma",
                    explanation = "Mayurasharma established the Kadamba kingdom at Banavasi around 345 CE, recorded in the Talagunda pillar inscription."
                ),
                QuestionModel(
                    id = "kpsc_kh_u1_q2",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The famous Aihole inscription praising Chalukya Emperor Pulakeshin II was composed by:",
                    options = listOf("Ravikirti", "Pampa", "Ranna", "Bilhana"),
                    correctAnswer = "Ravikirti",
                    explanation = "Court poet Ravikirti composed the 634 CE Aihole inscription detailing Pulakeshin II's victory over Harshavardhana."
                ),
                QuestionModel(
                    id = "kpsc_kh_u1_q3",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The monolithic Kailasanatha temple at Ellora was carved under the patronage of which Rashtrakuta ruler?",
                    options = listOf("Krishna I", "Amoghavarsha I", "Govinda III", "Dhruva"),
                    correctAnswer = "Krishna I",
                    explanation = "Rashtrakuta King Krishna I commissioned the rock-cut Kailasa temple at Ellora in the 8th century CE."
                ),
                QuestionModel(
                    id = "kpsc_kh_u1_q4",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The renowned Chennakesava Temple at Belur was commissioned by which Hoysala ruler in 1117 CE?",
                    options = listOf("Vishnuvardhana", "Veera Ballala II", "Narasimha III", "Sala"),
                    correctAnswer = "Vishnuvardhana",
                    explanation = "Hoysala King Vishnuvardhana built the Chennakesava Temple at Belur to commemorate his victory over the Cholas at Talakadu."
                ),
                QuestionModel(
                    id = "kpsc_kh_u1_q5",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The Halmidi inscription (c. 450 CE), the earliest known full-length Kannada inscription, belongs to which dynasty?",
                    options = listOf("Kadambas", "Gangas", "Chalukyas", "Hoysalas"),
                    correctAnswer = "Kadambas",
                    explanation = "Discovered in Hassan district, the Halmidi inscription dates to the reign of Kadamba king Kakusthavarma."
                ),
                QuestionModel(
                    id = "kpsc_kh_u2_q1",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "The Vijayanagara Empire was founded in 1336 CE on the banks of the Tungabhadra river by:",
                    options = listOf("Harihara I and Bukka Raya I", "Krishnadevaraya and Saluva Narasimha", "Devaraya II and Praudha Devaraya", "Aliya Rama Raya and Tirumala"),
                    correctAnswer = "Harihara I and Bukka Raya I",
                    explanation = "Guided by sage Vidyaranya, brothers Harihara I and Bukka Raya I of the Sangama dynasty founded Vijayanagara in 1336 CE."
                ),
                QuestionModel(
                    id = "kpsc_kh_u2_q2",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Who was the visionary Dewan of Mysore credited with the Krishnaraja Sagar (KRS) Dam and Mysore Bank?",
                    options = listOf("Sir M. Visvesvaraya", "Sir Mirza Ismail", "K. Seshadri Iyer", "C. Rangacharlu"),
                    correctAnswer = "Sir M. Visvesvaraya",
                    explanation = "Bharat Ratna Sir M. Visvesvaraya served as Dewan of Mysore (1912–1918) and spearheaded industrialization and KRS Dam."
                ),
                QuestionModel(
                    id = "kpsc_kh_u2_q3",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "When was Mysore State officially renamed 'Karnataka' during Chief Minister D. Devaraj Urs's tenure?",
                    options = listOf("November 1, 1973", "November 1, 1956", "August 15, 1947", "January 26, 1950"),
                    correctAnswer = "November 1, 1973",
                    explanation = "Mysore State was formed on Nov 1, 1956 (Kannada Rajyotsava) and renamed Karnataka on Nov 1, 1973."
                ),
                QuestionModel(
                    id = "kpsc_kh_u2_q4",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "The 1924 Indian National Congress session — the only one presided over by Mahatma Gandhi — was held in:",
                    options = listOf("Belagavi (Belgaum)", "Bengaluru", "Mysuru", "Hubballi"),
                    correctAnswer = "Belagavi (Belgaum)",
                    explanation = "Mahatma Gandhi presided over the 39th INC session at Belagavi in December 1924."
                ),
                QuestionModel(
                    id = "kpsc_kh_u2_q5",
                    stdId = 15,
                    subjectId = "karnataka_history",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Who is revered as the 'Kannada Kulapurohita' for championing the Karnataka Unification (Ekikarana) Movement?",
                    options = listOf("Aluru Venkata Rao", "Kengal Hanumanthaiah", "S. Nijalingappa", "B.M. Srikantaiah"),
                    correctAnswer = "Aluru Venkata Rao",
                    explanation = "Aluru Venkata Rao inspired the unification movement through his landmark book 'Karnataka Gata Vaibhava'."
                )
            )
        }

    val polityQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscPolity") {
            listOf(
                QuestionModel(
                    id = "kpsc_pol_u1_q1",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which Article of the Indian Constitution did Dr. B.R. Ambedkar describe as the 'Heart and Soul of the Constitution'?",
                    options = listOf("Article 32 (Right to Constitutional Remedies)", "Article 14", "Article 19", "Article 368"),
                    correctAnswer = "Article 32 (Right to Constitutional Remedies)",
                    explanation = "Article 32 empowers citizens to directly approach the Supreme Court for enforcement of Fundamental Rights."
                ),
                QuestionModel(
                    id = "kpsc_pol_u1_q2",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The Directive Principles of State Policy (DPSP) in Part IV of the Indian Constitution were inspired by:",
                    options = listOf("Constitution of Ireland", "Constitution of USA", "Constitution of Canada", "Constitution of Japan"),
                    correctAnswer = "Constitution of Ireland",
                    explanation = "Articles 36 to 51 (DPSP) draw directly from the Irish Constitution's Directive Principles."
                ),
                QuestionModel(
                    id = "kpsc_pol_u1_q3",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which Constitutional Amendment added the words 'Socialist', 'Secular', and 'Integrity' to the Preamble?",
                    options = listOf("42nd Amendment Act, 1976", "44th Amendment Act, 1978", "52nd Amendment Act, 1985", "86th Amendment Act, 2002"),
                    correctAnswer = "42nd Amendment Act, 1976",
                    explanation = "The 42nd Amendment (often called the 'Mini-Constitution') amended the Preamble and introduced Fundamental Duties (Part IVA)."
                ),
                QuestionModel(
                    id = "kpsc_pol_u1_q4",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Article 17 of the Indian Constitution explicitly abolishes:",
                    options = listOf("Untouchability", "Titles", "Child labor", "Preventive detention"),
                    correctAnswer = "Untouchability",
                    explanation = "Article 17 abolishes untouchability and forbids its practice in any form."
                ),
                QuestionModel(
                    id = "kpsc_pol_u1_q5",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "In which landmark 1973 judgment did the Supreme Court establish the 'Basic Structure Doctrine'?",
                    options = listOf("Kesavananda Bharati v. State of Kerala", "Golaknath v. State of Punjab", "Maneka Gandhi v. Union of India", "Minerva Mills Case"),
                    correctAnswer = "Kesavananda Bharati v. State of Kerala",
                    explanation = "A 13-judge bench ruled that Parliament cannot alter the Basic Structure of the Constitution under Article 368."
                ),
                QuestionModel(
                    id = "kpsc_pol_u2_q1",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which Constitutional Amendment granted constitutional status to Panchayati Raj Institutions (Rural Local Self-Government)?",
                    options = listOf("73rd Amendment Act, 1992", "74th Amendment Act, 1992", "71st Amendment Act, 1992", "84th Amendment Act, 2001"),
                    correctAnswer = "73rd Amendment Act, 1992",
                    explanation = "The 73rd Amendment added Part IX and the 11th Schedule for Panchayati Raj; the 74th covered Municipalities."
                ),
                QuestionModel(
                    id = "kpsc_pol_u2_q2",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Who presides over a Joint Sitting of both Houses of the Indian Parliament (Article 108)?",
                    options = listOf("Speaker of the Lok Sabha", "President of India", "Chairman of the Rajya Sabha", "Prime Minister"),
                    correctAnswer = "Speaker of the Lok Sabha",
                    explanation = "While the President summons the joint sitting, the Lok Sabha Speaker presides over it (Article 118)."
                ),
                QuestionModel(
                    id = "kpsc_pol_u2_q3",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which Article deals with the establishment and composition of State Public Service Commissions like KPSC?",
                    options = listOf("Article 315", "Article 280", "Article 324", "Article 356"),
                    correctAnswer = "Article 315",
                    explanation = "Article 315 provides for a Public Service Commission for the Union (UPSC) and for each State (e.g., KPSC)."
                ),
                QuestionModel(
                    id = "kpsc_pol_u2_q4",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "A Money Bill under Article 110 can be introduced ONLY in:",
                    options = listOf("Lok Sabha", "Rajya Sabha", "Either House of Parliament", "Supreme Court"),
                    correctAnswer = "Lok Sabha",
                    explanation = "Money Bills require prior presidential recommendation and can only be introduced in the Lok Sabha."
                ),
                QuestionModel(
                    id = "kpsc_pol_u2_q5",
                    stdId = 15,
                    subjectId = "indian_polity",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "The Karnataka State Legislature is bicameral, consisting of the Vidhana Sabha and the:",
                    options = listOf("Vidhana Parishad (Legislative Council)", "Gram Sabha", "Rajya Sabha", "Zila Parishad"),
                    correctAnswer = "Vidhana Parishad (Legislative Council)",
                    explanation = "Karnataka is one of six Indian states with a bicameral legislature (Vidhana Sabha + Vidhana Parishad)."
                )
            )
        }

    val geoEconomyQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscGeoEconomy") {
            listOf(
                QuestionModel(
                    id = "kpsc_ge_u1_q1",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which is the highest peak in Karnataka?",
                    options = listOf("Mullayanagiri", "Kudremukh", "Nandi Hills", "Kodachadri"),
                    correctAnswer = "Mullayanagiri",
                    explanation = "Mullayanagiri (1,930 m) in the Baba Budangiri range of Chikkamagaluru district is Karnataka's highest peak."
                ),
                QuestionModel(
                    id = "kpsc_ge_u1_q2",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The Jog Falls (Gerosoppa Falls), one of India's tallest plunge waterfalls, is formed by which river?",
                    options = listOf("Sharavathi", "Kaveri", "Krishna", "Netravathi"),
                    correctAnswer = "Sharavathi",
                    explanation = "River Sharavathi in Shivamogga district plunges 253 meters in four distinct cascades (Raja, Rani, Roarer, Rocket)."
                ),
                QuestionModel(
                    id = "kpsc_ge_u1_q3",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which soil type, rich in clay and moisture retention, is ideal for cotton cultivation in North Karnataka?",
                    options = listOf("Black soil (Regur soil)", "Laterite soil", "Sandy desert soil", "Peaty soil"),
                    correctAnswer = "Black soil (Regur soil)",
                    explanation = "Deccan basaltic Black (Regur) soil retains moisture well and is famously suited for cotton."
                ),
                QuestionModel(
                    id = "kpsc_ge_u1_q4",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "River Kaveri originates at Talakaveri in which district of Karnataka?",
                    options = listOf("Kodagu", "Hassan", "Mysuru", "Chamarajanagar"),
                    correctAnswer = "Kodagu",
                    explanation = "Talakaveri in the Brahmagiri hills of Kodagu district is the sacred origin of the Kaveri river."
                ),
                QuestionModel(
                    id = "kpsc_ge_u1_q5",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which mountain pass connects Bengaluru/Mysuru plateau toward coastal Mangaluru?",
                    options = listOf("Shiradi Ghat", "Khyber Pass", "Nathu La", "Rohtang Pass"),
                    correctAnswer = "Shiradi Ghat",
                    explanation = "Shiradi Ghat (along NH-75) cuts through the Western Ghats linking Hassan and Dakshina Kannada districts."
                ),
                QuestionModel(
                    id = "kpsc_ge_u2_q1",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which institution replaced the Planning Commission of India on January 1, 2015?",
                    options = listOf("NITI Aayog", "Finance Commission", "SEBI", "NABARD"),
                    correctAnswer = "NITI Aayog",
                    explanation = "NITI Aayog (National Institution for Transforming India) serves as the Government of India's policy think tank."
                ),
                QuestionModel(
                    id = "kpsc_ge_u2_q2",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "The rate at which the Reserve Bank of India (RBI) lends short-term funds to commercial banks is called:",
                    options = listOf("Repo Rate", "Reverse Repo Rate", "Cash Reserve Ratio", "Fiscal Deficit"),
                    correctAnswer = "Repo Rate",
                    explanation = "RBI raises or lowers the Repo Rate as a key monetary policy tool to manage inflation and liquidity."
                ),
                QuestionModel(
                    id = "kpsc_ge_u2_q3",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Goods and Services Tax (GST) in India was implemented nationwide from:",
                    options = listOf("July 1, 2017", "April 1, 2016", "January 1, 2018", "November 8, 2016"),
                    correctAnswer = "July 1, 2017",
                    explanation = "Introduced via the 101st Constitutional Amendment, GST unified indirect taxes across India on July 1, 2017."
                ),
                QuestionModel(
                    id = "kpsc_ge_u2_q4",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which apex bank focuses specifically on refinancing agriculture and rural development in India?",
                    options = listOf("NABARD", "SIDBI", "EXIM Bank", "NHB"),
                    correctAnswer = "NABARD",
                    explanation = "NABARD (National Bank for Agriculture and Rural Development) was established in 1982 on the Shivraman Committee's recommendation."
                ),
                QuestionModel(
                    id = "kpsc_ge_u2_q5",
                    stdId = 15,
                    subjectId = "geography_economy",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Under which Article of the Constitution is the Union Finance Commission constituted every five years?",
                    options = listOf("Article 280", "Article 112", "Article 265", "Article 300A"),
                    correctAnswer = "Article 280",
                    explanation = "Article 280 mandates the President to constitute a Finance Commission to recommend tax devolution between Centre and States."
                )
            )
        }

    val scienceTechQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscScienceTech") {
            listOf(
                QuestionModel(
                    id = "kpsc_st_u1_q1",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which blood group is universally known as the 'Universal Donor' for red blood cells?",
                    options = listOf("O negative (O⁻)", "AB positive (AB⁺)", "A positive (A⁺)", "B negative (B⁻)"),
                    correctAnswer = "O negative (O⁻)",
                    explanation = "O⁻ red blood cells lack A, B, and Rh antigens, minimizing immune reactions during emergency transfusions."
                ),
                QuestionModel(
                    id = "kpsc_st_u1_q2",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The blue color of the daytime clear sky is primarily caused by:",
                    options = listOf("Rayleigh scattering of sunlight", "Refraction through clouds", "Total internal reflection", "Doppler shift"),
                    correctAnswer = "Rayleigh scattering of sunlight",
                    explanation = "Shorter-wavelength blue light scatters much more strongly by atmospheric gas molecules than longer red wavelengths."
                ),
                QuestionModel(
                    id = "kpsc_st_u1_q3",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "What is the chemical name of Baking Soda commonly used in kitchens?",
                    options = listOf("Sodium bicarbonate (NaHCO₃)", "Sodium carbonate", "Calcium carbonate", "Sodium hydroxide"),
                    correctAnswer = "Sodium bicarbonate (NaHCO₃)",
                    explanation = "Sodium hydrogen carbonate / sodium bicarbonate releases CO₂ gas when heated or reacted with acid."
                ),
                QuestionModel(
                    id = "kpsc_st_u1_q4",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which hormone secreted by the pancreas regulates blood glucose levels?",
                    options = listOf("Insulin", "Thyroxine", "Adrenaline", "Melatonin"),
                    correctAnswer = "Insulin",
                    explanation = "Beta cells of the Islets of Langerhans in the pancreas produce insulin to lower elevated blood sugar."
                ),
                QuestionModel(
                    id = "kpsc_st_u1_q5",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "What is the SI unit of electrical resistance?",
                    options = listOf("Ohm (Ω)", "Volt (V)", "Ampere (A)", "Watt (W)"),
                    correctAnswer = "Ohm (Ω)",
                    explanation = "By Ohm's Law (R = V/I), electrical resistance is measured in Ohms (Ω)."
                ),
                QuestionModel(
                    id = "kpsc_st_u2_q1",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Where is the headquarters of the Indian Space Research Organisation (ISRO) located?",
                    options = listOf("Bengaluru", "Sriharikota", "Thiruvananthapuram", "Ahmedabad"),
                    correctAnswer = "Bengaluru",
                    explanation = "ISRO is headquartered at Antariksh Bhavan in Bengaluru, Karnataka."
                ),
                QuestionModel(
                    id = "kpsc_st_u2_q2",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Chandrayaan-3 made India the first country in the world to soft-land near the:",
                    options = listOf("Lunar South Pole", "Lunar Equator", "Martian North Pole", "Venusian surface"),
                    correctAnswer = "Lunar South Pole",
                    explanation = "On August 23, 2023 (celebrated as National Space Day), Vikram lander and Pragyan rover touched down near the Moon's south pole."
                ),
                QuestionModel(
                    id = "kpsc_st_u2_q3",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Aditya-L1 is India's first dedicated space observatory mission to study the:",
                    options = listOf("Sun", "Jupiter", "Saturn", "Kuiper Belt"),
                    correctAnswer = "Sun",
                    explanation = "Aditya-L1 orbits the Sun-Earth Lagrange Point 1 (L1) to monitor solar corona and space weather continuously."
                ),
                QuestionModel(
                    id = "kpsc_st_u2_q4",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "UPI (Unified Payments Interface), revolutionizing digital payments in India, was developed by:",
                    options = listOf("NPCI (National Payments Corporation of India)", "TRAI", "ISRO", "NASSCOM"),
                    correctAnswer = "NPCI (National Payments Corporation of India)",
                    explanation = "NPCI launched UPI in 2016 to enable instant real-time inter-bank mobile payments."
                ),
                QuestionModel(
                    id = "kpsc_st_u2_q5",
                    stdId = 15,
                    subjectId = "general_science",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which organization develops indigenous defence systems like Agni, Prithvi, and Akash missiles in India?",
                    options = listOf("DRDO", "CSIR", "BARC", "ICMR"),
                    correctAnswer = "DRDO",
                    explanation = "DRDO (Defence Research and Development Organisation) leads India's military R&D programs."
                )
            )
        }

    val mentalAbilityQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("KpscMentalAbility") {
            listOf(
                QuestionModel(
                    id = "kpsc_ma_u1_q1",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "A can complete a piece of work in 12 days and B can complete it in 6 days. Together, how many days will they take?",
                    options = listOf("4 days", "5 days", "3 days", "6 days"),
                    correctAnswer = "4 days",
                    explanation = "Combined 1-day work = 1/12 + 1/6 = 3/12 = 1/4, so together they finish in 4 days."
                ),
                QuestionModel(
                    id = "kpsc_ma_u1_q2",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "If the ratio of boys to girls in a class is 3 : 5 and there are 40 students in total, how many girls are there?",
                    options = listOf("25", "15", "20", "24"),
                    correctAnswer = "25",
                    explanation = "Girls = (5 / (3 + 5)) × 40 = (5 / 8) × 40 = 25."
                ),
                QuestionModel(
                    id = "kpsc_ma_u1_q3",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "A train 150 meters long passes a pole in 15 seconds. What is its speed in km/hr?",
                    options = listOf("36 km/hr", "45 km/hr", "30 km/hr", "54 km/hr"),
                    correctAnswer = "36 km/hr",
                    explanation = "Speed = 150 / 15 = 10 m/s. Multiplying by 18/5 converts to 36 km/hr."
                ),
                QuestionModel(
                    id = "kpsc_ma_u1_q4",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Find the Simple Interest on ₹5,000 at 8% per annum for 3 years.",
                    options = listOf("₹1,200", "₹1,000", "₹1,500", "₹800"),
                    correctAnswer = "₹1,200",
                    explanation = "SI = (P × R × T) / 100 = (5000 × 8 × 3) / 100 = ₹1,200."
                ),
                QuestionModel(
                    id = "kpsc_ma_u1_q5",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "If 15% of a number is 45, what is the number?",
                    options = listOf("300", "250", "350", "450"),
                    correctAnswer = "300",
                    explanation = "0.15 × x = 45 → x = 45 / 0.15 = 300."
                ),
                QuestionModel(
                    id = "kpsc_ma_u2_q1",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "A person walks 4 km North, then turns right and walks 3 km East. How far is the person from the starting point?",
                    options = listOf("5 km", "7 km", "6 km", "4 km"),
                    correctAnswer = "5 km",
                    explanation = "By Pythagoras theorem: √(4² + 3²) = √(16 + 9) = √25 = 5 km."
                ),
                QuestionModel(
                    id = "kpsc_ma_u2_q2",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Pointing to a photograph, Asha says, 'He is the only son of my mother's father.' How is the man related to Asha?",
                    options = listOf("Maternal Uncle", "Brother", "Father", "Cousin"),
                    correctAnswer = "Maternal Uncle",
                    explanation = "Asha's mother's father is her maternal grandfather; his only son is Asha's mother's brother (Maternal Uncle)."
                ),
                QuestionModel(
                    id = "kpsc_ma_u2_q3",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Find the odd one out: Bengaluru, Mysuru, Mangaluru, Chennai",
                    options = listOf("Chennai", "Bengaluru", "Mysuru", "Mangaluru"),
                    correctAnswer = "Chennai",
                    explanation = "Bengaluru, Mysuru, and Mangaluru are cities in Karnataka, whereas Chennai is the capital of Tamil Nadu."
                ),
                QuestionModel(
                    id = "kpsc_ma_u2_q4",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "If Monday falls on the 1st of a month, which day of the week will the 23rd of that month be?",
                    options = listOf("Tuesday", "Monday", "Wednesday", "Thursday"),
                    correctAnswer = "Tuesday",
                    explanation = "23 - 1 = 22 days; 22 mod 7 = 1 day after Monday, which is Tuesday."
                ),
                QuestionModel(
                    id = "kpsc_ma_u2_q5",
                    stdId = 15,
                    subjectId = "mental_ability",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Complete the analogy: Constitution : India :: Magna Carta : ?",
                    options = listOf("England", "France", "Germany", "Russia"),
                    correctAnswer = "England",
                    explanation = "Magna Carta (1215) is the foundational constitutional charter of England."
                )
            )
        }

    val allQuestions: List<QuestionModel>
        get() = karnatakaHistoryQuestions +
            polityQuestions +
            geoEconomyQuestions +
            scienceTechQuestions +
            mentalAbilityQuestions +
            KpscKannadaUnitsQuestionBank.allQuestions
}
