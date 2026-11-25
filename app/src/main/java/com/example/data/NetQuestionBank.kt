package com.example.data

/**
 * UGC-NET / KSET Paper 1 Question Bank.
 * Standard / Exam ID: 14.
 * Covers: Teaching & Research Aptitude, Logical Reasoning & DI,
 * ICT & Communication, and People, Environment & Higher Education.
 */
object NetQuestionBank {

    val teachingResearchUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Teaching Aptitude, Levels & Evaluation Systems", 5, "Medium"),
        UnitTemplate(2, "Unit 2: Research Methodology, Hypothesis & Sampling", 5, "Hard"),
        UnitTemplate(3, "Unit 3: Research Ethics, Citations & Academic Integrity", 5, "Medium")
    )

    val logicalReasoningUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Syllogisms, Indian Logic (Pramanas) & Fallacies", 5, "Hard"),
        UnitTemplate(2, "Unit 2: Number Series, Percentages & Data Interpretation", 5, "Medium")
    )

    val ictCommunicationUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Effective Classroom & Mass Communication", 5, "Easy"),
        UnitTemplate(2, "Unit 2: ICT Basics, Networking & Digital Initiatives", 5, "Medium")
    )

    val higherEdEnvUnits: List<UnitTemplate> = listOf(
        UnitTemplate(1, "Unit 1: Sustainable Development Goals & Climate Treaties", 5, "Medium"),
        UnitTemplate(2, "Unit 2: Higher Education System, NEP 2020 & UGC", 5, "Medium")
    )

    val teachingResearchQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("NetTeachingResearch") {
            listOf(
                QuestionModel(
                    id = "net_tr_u1_q1",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which level of teaching focuses on problem-solving, critical inquiry, and independent original thinking?",
                    options = listOf("Reflective Level", "Memory Level", "Understanding Level", "Autonomous Recall Level"),
                    correctAnswer = "Reflective Level",
                    explanation = "Hunt's Reflective Level is the highest level of teaching, engaging learners in critical analysis and problem-solving."
                ),
                QuestionModel(
                    id = "net_tr_u1_q2",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "SWAYAM, launched by the Government of India, is a national platform for:",
                    options = listOf("Massive Open Online Courses (MOOCs)", "University grant disbursements", "Campus placement tracking", "Library book barcoding"),
                    correctAnswer = "Massive Open Online Courses (MOOCs)",
                    explanation = "SWAYAM (Study Webs of Active-Learning for Young Aspiring Minds) offers free online courses from Class 9 to post-graduation."
                ),
                QuestionModel(
                    id = "net_tr_u1_q3",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "In Choice Based Credit System (CBCS), students are assessed using:",
                    options = listOf("Grade points and SGPA/CGPA", "Raw percentage ranks only", "Pass/Fail checkboxes only", "Attendance marks alone"),
                    correctAnswer = "Grade points and SGPA/CGPA",
                    explanation = "UGC's CBCS uses a 10-point grading scale to compute Semester Grade Point Average (SGPA) and Cumulative GPA (CGPA)."
                ),
                QuestionModel(
                    id = "net_tr_u1_q4",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "A test that consistently yields the same results when repeated under identical conditions is said to have high:",
                    options = listOf("Reliability", "Difficulty", "Subjectivity", "Ambiguity"),
                    correctAnswer = "Reliability",
                    explanation = "Reliability measures consistency of measurement, whereas validity measures whether the test assesses what it intends to measure."
                ),
                QuestionModel(
                    id = "net_tr_u1_q5",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which teaching method was originally championed by Socrates to stimulate critical thinking through probing questions?",
                    options = listOf("Dialectical / Question-Answer Method", "Demonstration Method", "Project Method", "Heuristic Lab Method"),
                    correctAnswer = "Dialectical / Question-Answer Method",
                    explanation = "The Socratic method uses structured questioning and dialogue to uncover underlying assumptions and deepen reasoning."
                ),
                QuestionModel(
                    id = "net_tr_u2_q1",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Rejecting a true null hypothesis (H₀) in statistical hypothesis testing is called a:",
                    options = listOf("Type I Error (Alpha error)", "Type II Error (Beta error)", "Sampling bias", "Standard deviation"),
                    correctAnswer = "Type I Error (Alpha error)",
                    explanation = "A Type I error (false positive) occurs when a true null hypothesis is rejected; failing to reject a false H₀ is a Type II error."
                ),
                QuestionModel(
                    id = "net_tr_u2_q2",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which of the following is a non-probability sampling technique?",
                    options = listOf("Snowball sampling", "Simple random sampling", "Stratified random sampling", "Cluster sampling"),
                    correctAnswer = "Snowball sampling",
                    explanation = "Snowball, convenience, quota, and purposive sampling are non-probability techniques where not all population members have equal selection odds."
                ),
                QuestionModel(
                    id = "net_tr_u2_q3",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Research aimed at solving an immediate, practical problem within a specific classroom or organization is called:",
                    options = listOf("Action Research", "Fundamental Research", "Historical Research", "Ex-post facto Research"),
                    correctAnswer = "Action Research",
                    explanation = "Action research follows a cyclic Plan → Act → Observe → Reflect process to improve local practices immediately."
                ),
                QuestionModel(
                    id = "net_tr_u2_q4",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "In experimental research, the variable deliberately manipulated by the researcher is the:",
                    options = listOf("Independent variable", "Dependent variable", "Extraneous variable", "Confounding variable"),
                    correctAnswer = "Independent variable",
                    explanation = "The independent variable is manipulated to observe its effect on the dependent (outcome) variable."
                ),
                QuestionModel(
                    id = "net_tr_u2_q5",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which research design studies cause-and-effect relationships after the event has already occurred without manipulating variables?",
                    options = listOf("Ex-post facto research", "True experimental research", "Ethnographic research", "Phenomenology"),
                    correctAnswer = "Ex-post facto research",
                    explanation = "Ex-post facto ('after the fact') research investigates existing differences when manipulation is impossible or unethical."
                ),
                QuestionModel(
                    id = "net_tr_u3_q1",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "Presenting someone else's published ideas, text, or data as one's own without proper attribution is known as:",
                    options = listOf("Plagiarism", "Triangulation", "Peer review", "Replication"),
                    correctAnswer = "Plagiarism",
                    explanation = "Plagiarism is a serious violation of research ethics; UGC mandates similarity checks for theses and scholarly papers."
                ),
                QuestionModel(
                    id = "net_tr_u3_q2",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "In APA citation style, what does 'et al.' signify in an in-text citation?",
                    options = listOf("And others", "In the same place", "See above", "Compare with"),
                    correctAnswer = "And others",
                    explanation = "'et al.' comes from Latin 'et alia' meaning 'and others', used for sources with three or more authors in APA 7th edition."
                ),
                QuestionModel(
                    id = "net_tr_u3_q3",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "Which metric measures the average number of citations received per paper published in a journal over the preceding two years?",
                    options = listOf("Impact Factor", "p-value", "Chi-square", "Standard Error"),
                    correctAnswer = "Impact Factor",
                    explanation = "Journal Impact Factor (JIF) reflects the yearly mean number of citations to articles published in the last two years."
                ),
                QuestionModel(
                    id = "net_tr_u3_q4",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "Making up fictitious experimental data and reporting it in a journal article is known as:",
                    options = listOf("Fabrication", "Paraphrasing", "Meta-analysis", "Cross-validation"),
                    correctAnswer = "Fabrication",
                    explanation = "Fabrication (inventing data) and Falsification (manipulating data) are top forms of scientific misconduct."
                ),
                QuestionModel(
                    id = "net_tr_u3_q5",
                    stdId = 14,
                    subjectId = "teaching_research",
                    unitId = 3,
                    type = "MCQ",
                    questionText = "Shodhganga, maintained by INFLIBNET, is an Indian digital repository of:",
                    options = listOf("Electronic Ph.D. Theses and Dissertations", "Undergraduate attendance sheets", "School textbooks only", "Patent court rulings"),
                    correctAnswer = "Electronic Ph.D. Theses and Dissertations",
                    explanation = "Shodhganga provides open access to full-text Indian doctoral theses submitted across universities."
                )
            )
        }

    val logicalReasoningQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("NetLogicalReasoning") {
            listOf(
                QuestionModel(
                    id = "net_lr_u1_q1",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "In Indian Logic (Nyaya philosophy), knowledge gained through direct sensory contact with an object is called:",
                    options = listOf("Pratyaksha (Perception)", "Anumana (Inference)", "Upamana (Comparison)", "Shabda (Testimony)"),
                    correctAnswer = "Pratyaksha (Perception)",
                    explanation = "Nyaya recognizes four Pramanas: Pratyaksha (perception), Anumana (inference), Upamana (comparison), and Shabda (verbal testimony)."
                ),
                QuestionModel(
                    id = "net_lr_u1_q2",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "In the classical Square of Opposition, if 'All researchers are ethical' is TRUE, then 'Some researchers are not ethical' is:",
                    options = listOf("False", "True", "Undetermined", "Equivalent"),
                    correctAnswer = "False",
                    explanation = "A ('All S are P') and O ('Some S are not P') propositions are contradictories — they can never have the same truth value."
                ),
                QuestionModel(
                    id = "net_lr_u1_q3",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Attacking the personal character of an opponent instead of addressing their argument commits which fallacy?",
                    options = listOf("Ad Hominem", "Straw Man", "Slippery Slope", "Red Herring"),
                    correctAnswer = "Ad Hominem",
                    explanation = "Argumentum ad hominem ('against the person') diverts focus from the claim's logic to personal attacks."
                ),
                QuestionModel(
                    id = "net_lr_u1_q4",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "In the Nyaya syllogism 'The hill has fire because it has smoke', 'smoke' represents the:",
                    options = listOf("Hetu (Middle term / Reason)", "Paksha (Minor term)", "Sadhya (Major term)", "Udaharana (Example)"),
                    correctAnswer = "Hetu (Middle term / Reason)",
                    explanation = "Hill = Paksha (subject), Fire = Sadhya (what is to be proved), Smoke = Hetu (the reason/sign)."
                ),
                QuestionModel(
                    id = "net_lr_u1_q5",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "An argument whose conclusion follows with absolute necessity from its premises is called:",
                    options = listOf("Deductive argument", "Inductive argument", "Analogical argument", "Abductive guess"),
                    correctAnswer = "Deductive argument",
                    explanation = "In a valid deductive argument, it is impossible for the premises to be true and the conclusion false."
                ),
                QuestionModel(
                    id = "net_lr_u2_q1",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Find the next term in the series: 3, 8, 15, 24, 35, ?",
                    options = listOf("48", "46", "49", "50"),
                    correctAnswer = "48",
                    explanation = "Differences increase by +2: +5, +7, +9, +11, +13 → 35 + 13 = 48 (also n² - 1 for n = 2..7)."
                ),
                QuestionModel(
                    id = "net_lr_u2_q2",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "A university's student enrollment rose from 4,000 to 5,000 in one year. What is the percentage increase?",
                    options = listOf("25%", "20%", "30%", "15%"),
                    correctAnswer = "25%",
                    explanation = "Percentage increase = ((5000 - 4000) / 4000) × 100 = 1000 / 40 = 25%."
                ),
                QuestionModel(
                    id = "net_lr_u2_q3",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "If the average score of 5 students is 72 and a 6th student scores 90, what is the new average?",
                    options = listOf("75", "74", "76", "78"),
                    correctAnswer = "75",
                    explanation = "Total of 5 = 5 × 72 = 360. Adding 90 gives 450. New average = 450 / 6 = 75."
                ),
                QuestionModel(
                    id = "net_lr_u2_q4",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "In a pie chart representing a ₹36,000 research budget, a sector of 90° represents how much money?",
                    options = listOf("₹9,000", "₹6,000", "₹12,000", "₹4,500"),
                    correctAnswer = "₹9,000",
                    explanation = "90° / 360° = 1/4 of the total budget → 36,000 / 4 = ₹9,000."
                ),
                QuestionModel(
                    id = "net_lr_u2_q5",
                    stdId = 14,
                    subjectId = "logical_reasoning",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "If 'PAPER' is coded as 'QBQFS', how is 'STUDY' coded in the same scheme?",
                    options = listOf("TUVEZ", "TUVDZ", "STVEZ", "TUVEY"),
                    correctAnswer = "TUVEZ",
                    explanation = "Each letter is shifted forward by +1 in the alphabet: S→T, T→U, U→V, D→E, Y→Z."
                )
            )
        }

    val ictCommunicationQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("NetIctComm") {
            listOf(
                QuestionModel(
                    id = "net_ict_u1_q1",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "In communication theory, the process of converting a sender's ideas into symbols, words, or gestures is called:",
                    options = listOf("Encoding", "Decoding", "Feedback", "Channeling"),
                    correctAnswer = "Encoding",
                    explanation = "The sender encodes thoughts into a message; the receiver decodes it and sends feedback."
                ),
                QuestionModel(
                    id = "net_ict_u1_q2",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Communication that relies on posture, facial expressions, eye contact, and gestures is known as:",
                    options = listOf("Kinesics (Non-verbal communication)", "Proxemics", "Semantic communication", "Chronemics"),
                    correctAnswer = "Kinesics (Non-verbal communication)",
                    explanation = "Kinesics studies body language and facial gestures; Proxemics studies physical space; Chronemics studies time."
                ),
                QuestionModel(
                    id = "net_ict_u1_q3",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which type of communication occurs when an individual reflects silently within themselves?",
                    options = listOf("Intrapersonal communication", "Interpersonal communication", "Mass communication", "Group communication"),
                    correctAnswer = "Intrapersonal communication",
                    explanation = "Intrapersonal communication takes place internally within a single person's mind."
                ),
                QuestionModel(
                    id = "net_ict_u1_q4",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "When jargon or ambiguous vocabulary causes misunderstanding in a lecture, it is an example of a:",
                    options = listOf("Semantic barrier", "Physical barrier", "Mechanical barrier", "Chronological barrier"),
                    correctAnswer = "Semantic barrier",
                    explanation = "Semantic barriers arise from differences in language meaning, technical jargon, or poor word choice."
                ),
                QuestionModel(
                    id = "net_ict_u1_q5",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "In classroom communication, immediate feedback is most characteristic of:",
                    options = listOf("Synchronous face-to-face communication", "Asynchronous print newsletters", "One-way radio broadcast", "Archived video lectures"),
                    correctAnswer = "Synchronous face-to-face communication",
                    explanation = "Synchronous interaction lets teachers immediately read student responses and clarify doubts."
                ),
                QuestionModel(
                    id = "net_ict_u2_q1",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which memory in a computer is volatile and loses its contents when power is switched off?",
                    options = listOf("RAM (Random Access Memory)", "ROM (Read Only Memory)", "SSD (Solid State Drive)", "Hard Disk Drive"),
                    correctAnswer = "RAM (Random Access Memory)",
                    explanation = "RAM stores active data temporarily while powered on; ROM and SSDs retain data without power."
                ),
                QuestionModel(
                    id = "net_ict_u2_q2",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "What is the binary equivalent of the decimal number 25?",
                    options = listOf("11001", "10101", "11011", "10011"),
                    correctAnswer = "11001",
                    explanation = "25 = 16 + 8 + 0 + 0 + 1 = 1×2⁴ + 1×2³ + 0×2² + 0×2¹ + 1×2⁰ = 11001₂."
                ),
                QuestionModel(
                    id = "net_ict_u2_q3",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "In email headers, what does 'BCC' stand for?",
                    options = listOf("Blind Carbon Copy", "Basic Copy Control", "Broadcast Carbon Channel", "Binary Content Code"),
                    correctAnswer = "Blind Carbon Copy",
                    explanation = "BCC sends a copy of the email while hiding those recipients' email addresses from everyone else."
                ),
                QuestionModel(
                    id = "net_ict_u2_q4",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Deceptive emails impersonating trusted institutions to steal passwords or banking details are called:",
                    options = listOf("Phishing", "Firewalling", "Encrypting", "Caching"),
                    correctAnswer = "Phishing",
                    explanation = "Phishing uses social engineering via fraudulent emails or links to harvest sensitive credentials."
                ),
                QuestionModel(
                    id = "net_ict_u2_q5",
                    stdId = 14,
                    subjectId = "ict_communication",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which protocol is primarily used to securely transfer web pages over the Internet?",
                    options = listOf("HTTPS", "FTP", "SMTP", "POP3"),
                    correctAnswer = "HTTPS",
                    explanation = "HTTPS (Hypertext Transfer Protocol Secure) encrypts web traffic using TLS/SSL."
                )
            )
        }

    val higherEdEnvQuestions: List<QuestionModel>
        get() = QuestionBankCache.getOrLoad("NetHigherEdEnv") {
            listOf(
                QuestionModel(
                    id = "net_he_u1_q1",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "How many Sustainable Development Goals (SDGs) were adopted by the United Nations for the 2030 Agenda?",
                    options = listOf("17 Goals", "8 Goals", "12 Goals", "21 Goals"),
                    correctAnswer = "17 Goals",
                    explanation = "The UN adopted 17 SDGs in 2015 (replacing the 8 Millennium Development Goals) to be achieved by 2030."
                ),
                QuestionModel(
                    id = "net_he_u1_q2",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The Montreal Protocol (1987) is an international treaty designed to protect:",
                    options = listOf("The Ozone Layer by phasing out CFCs", "Endangered wetlands", "Antarctic marine life", "Migratory bird routes"),
                    correctAnswer = "The Ozone Layer by phasing out CFCs",
                    explanation = "The Montreal Protocol successfully phased down chlorofluorocarbons (CFCs) and other ozone-depleting substances."
                ),
                QuestionModel(
                    id = "net_he_u1_q3",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "Which SDG specifically focuses on 'Quality Education' for all?",
                    options = listOf("SDG 4", "SDG 1", "SDG 7", "SDG 13"),
                    correctAnswer = "SDG 4",
                    explanation = "SDG 4 aims to ensure inclusive and equitable quality education and promote lifelong learning opportunities."
                ),
                QuestionModel(
                    id = "net_he_u1_q4",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "The International Solar Alliance (ISA), headquartered in Gurugram, was jointly launched by India and:",
                    options = listOf("France", "Germany", "Japan", "Australia"),
                    correctAnswer = "France",
                    explanation = "India and France launched the International Solar Alliance at COP21 in Paris in November 2015."
                ),
                QuestionModel(
                    id = "net_he_u1_q5",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 1,
                    type = "MCQ",
                    questionText = "High Biochemical Oxygen Demand (BOD) in a river indicates:",
                    options = listOf("Heavy organic water pollution", "Pure distilled water", "Absence of bacteria", "High dissolved oxygen"),
                    correctAnswer = "Heavy organic water pollution",
                    explanation = "Elevated BOD means microbes consume large amounts of oxygen to decompose organic waste, stressing aquatic life."
                ),
                QuestionModel(
                    id = "net_he_u2_q1",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which ancient Indian center of higher learning located in Bihar attracted scholars like Xuanzang?",
                    options = listOf("Nalanda University", "Takshashila", "Vallabhi", "Pushpagiri"),
                    correctAnswer = "Nalanda University",
                    explanation = "Nalanda Mahavihara in Bihar flourished from the 5th to 12th centuries CE and hosted renowned international scholars."
                ),
                QuestionModel(
                    id = "net_he_u2_q2",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which statutory body was established in 1956 to coordinate and maintain standards of university education in India?",
                    options = listOf("UGC (University Grants Commission)", "AICTE", "NCTE", "NCERT"),
                    correctAnswer = "UGC (University Grants Commission)",
                    explanation = "The University Grants Commission became a statutory body under the UGC Act of 1956."
                ),
                QuestionModel(
                    id = "net_he_u2_q3",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "NAAC (National Assessment and Accreditation Council), responsible for accrediting Indian higher education institutions, is headquartered in:",
                    options = listOf("Bengaluru", "New Delhi", "Mumbai", "Hyderabad"),
                    correctAnswer = "Bengaluru",
                    explanation = "NAAC is an autonomous body under UGC headquartered in Bengaluru, Karnataka."
                ),
                QuestionModel(
                    id = "net_he_u2_q4",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "NEP 2020 targets increasing the Gross Enrolment Ratio (GER) in higher education in India to 50% by:",
                    options = listOf("2035", "2025", "2040", "2050"),
                    correctAnswer = "2035",
                    explanation = "The National Education Policy 2020 aims to reach 50% GER in higher education by 2035."
                ),
                QuestionModel(
                    id = "net_he_u2_q5",
                    stdId = 14,
                    subjectId = "higher_ed_env",
                    unitId = 2,
                    type = "MCQ",
                    questionText = "Which commission (1948–49), chaired by Dr. S. Radhakrishnan, shaped independent India's university education system?",
                    options = listOf("University Education Commission", "Kothari Commission", "Mudaliar Commission", "Hunter Commission"),
                    correctAnswer = "University Education Commission",
                    explanation = "The Radhakrishnan Commission (1948–49) recommended establishing the UGC and strengthening Indian universities."
                )
            )
        }

    val allQuestions: List<QuestionModel>
        get() = teachingResearchQuestions + logicalReasoningQuestions + ictCommunicationQuestions + higherEdEnvQuestions
}
