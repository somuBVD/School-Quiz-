package com.example.data

/**
 * Standard 6 Hindi (LBA) consolidated question bank containing all 104 verified MCQs
 * across Lessons 1, 8-17 (Grammar), 19-23 (Stories, Poems, Essays), and 25 (Van Mahotsav).
 */
object Std6HindiQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "पाठ 1: संरचक रेखाएँ", 5, "Easy"),
        UnitTemplate(8, "पाठ 8: मैं, हम, तू, तुम, आप", 7, "Easy"),
        UnitTemplate(9, "पाठ 9: यह, ये, वह, वे", 5, "Easy"),
        UnitTemplate(10, "पाठ 10: मेरा, हमारा, तेरा, तुम्हारा", 8, "Easy"),
        UnitTemplate(11, "पाठ 11: इसका, इनका, उसका, उनका", 7, "Medium"),
        UnitTemplate(12, "पाठ 12: का, की, के", 8, "Medium"),
        UnitTemplate(13, "पाठ 13: आया, आये, आयी, आयीं", 4, "Medium"),
        UnitTemplate(14, "पाठ 14: था, थे, थी, थीं", 3, "Medium"),
        UnitTemplate(15, "पाठ 15: ता, ते, ती", 8, "Medium"),
        UnitTemplate(16, "पाठ 16: रहा, रही, रहे", 9, "Medium"),
        UnitTemplate(17, "पाठ 17: जायेगा, जायेंगे, जायेगी, जायेंगी", 5, "Medium"),
        UnitTemplate(19, "पाठ 19: हाथी मेरा साथी (कहानी)", 7, "Easy"),
        UnitTemplate(20, "पाठ 20: रेल का खेल (कविता)", 5, "Easy"),
        UnitTemplate(21, "पाठ 21: चतुर बंदर (कहानी)", 8, "Medium"),
        UnitTemplate(22, "पाठ 22: माँ का प्यार (कविता)", 5, "Easy"),
        UnitTemplate(23, "पाठ 23: अक्षर ही अक्षर (निबंध)", 5, "Medium"),
        UnitTemplate(25, "पाठ 25: वनमहोत्सव", 5, "Easy")
    )

    val questions: List<QuestionModel> = listOf(
        // === पाठ 1: संरचक रेखाएँ ===
        QuestionModel(
            id = "s_6_hin_u1_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 1,
            type = "MCQ",
            questionText = "- o - o – o –o - इसमें पड़ी रेखाएँ हैं:",
            options = listOf("2", "3", "4", "5"),
            correctAnswer = "5",
            explanation = "दी गई आकृति में कुल 5 पड़ी रेखाएँ (-) हैं।"
        ),
        QuestionModel(
            id = "s_6_hin_u1_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 1,
            type = "MCQ",
            questionText = "० -० -० इसमें पूर्ण गोल हैं:",
            options = listOf("2", "3", "5", "1"),
            correctAnswer = "3",
            explanation = "दी गई आकृति में 3 पूर्ण गोल (०) हैं।"
        ),
        QuestionModel(
            id = "s_6_hin_u1_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 1,
            type = "MCQ",
            questionText = "“c” इस अक्षर को कहते हैं:",
            options = listOf("अर्धगोल", "अर्धमात्रा", "चंद्रबिंदु", "पूर्ण गोल"),
            correctAnswer = "अर्धगोल",
            explanation = "वर्णमाला व रेखा अभ्यास में 'c' को अर्धगोल कहा जाता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u1_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 1,
            type = "MCQ",
            questionText = "“M” में तिरछी रेखाएँ हैं:",
            options = listOf("1", "2", "3", "4"),
            correctAnswer = "2",
            explanation = "अक्षर 'M' में 2 खड़ी रेखाएँ और बीच में 2 तिरछी रेखाएँ होती हैं।"
        ),
        QuestionModel(
            id = "s_6_hin_u1_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 1,
            type = "MCQ",
            questionText = "“K” में खड़ी रेखा है:",
            options = listOf("2", "4", "1", "3"),
            correctAnswer = "1",
            explanation = "अक्षर 'K' में 1 खड़ी रेखा और 2 तिरछी रेखाएँ होती हैं।"
        ),

        // === पाठ 8: मैं, हम, तू, तुम, आप ===
        QuestionModel(
            id = "s_6_hin_u8_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 8,
            type = "MCQ",
            questionText = "मैं ______ हूँ।",
            options = listOf("छात्रा", "छात्र", "छात्र हैं", "छात्र हो"),
            correctAnswer = "छात्र",
            explanation = "वाक्य के लिंग और वचन के अनुसार 'मैं छात्र हूँ' सही है।"
        ),
        QuestionModel(
            id = "s_6_hin_u8_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 8,
            type = "MCQ",
            questionText = "हम ______ हैं।",
            options = listOf("लड़का", "लड़की", "लड़के", "लड़का है"),
            correctAnswer = "लड़के",
            explanation = "'हम' बहुवचन सर्वनाम है, अतः 'लड़के हैं' सही रूप है।"
        ),
        QuestionModel(
            id = "s_6_hin_u8_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 8,
            type = "MCQ",
            questionText = "तू ______ है।",
            options = listOf("मोहन", "लड़के", "हम", "आप"),
            correctAnswer = "मोहन",
            explanation = "एकवचन कर्ता के साथ 'तू मोहन है' उचित है।"
        ),
        QuestionModel(
            id = "s_6_hin_u8_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 8,
            type = "MCQ",
            questionText = "राजू किताब ______ है।",
            options = listOf("पढ़ती", "पढ़ता", "पढ़ते", "पढ़ना"),
            correctAnswer = "पढ़ता",
            explanation = "पुल्लिंग एकवचन कर्ता (राजू) के साथ 'पढ़ता' क्रिया आती है।"
        ),
        QuestionModel(
            id = "s_6_hin_u8_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 8,
            type = "MCQ",
            questionText = "रानी किताब ______ है।",
            options = listOf("पढ़ता", "पढ़ते", "पढ़ती", "पढ़ना"),
            correctAnswer = "पढ़ती",
            explanation = "स्त्रीलिंग एकवचन कर्ता (रानी) के साथ 'पढ़ती' क्रिया आती है।"
        ),
        QuestionModel(
            id = "s_6_hin_u8_6",
            stdId = 6,
            subjectId = "hindi",
            unitId = 8,
            type = "MCQ",
            questionText = "विद्यार्थी पाठशाला ______ हैं।",
            options = listOf("जाता", "जाती", "जाते", "जाना"),
            correctAnswer = "जाते",
            explanation = "बहुवचन 'हैं' के साथ 'जाते' क्रिया का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u8_7",
            stdId = 6,
            subjectId = "hindi",
            unitId = 8,
            type = "MCQ",
            questionText = "विद्यार्थिनी पाठशाला ______ है।",
            options = listOf("जाती", "जाते", "जाता", "जाना"),
            correctAnswer = "जाती",
            explanation = "स्त्रीलिंग एकवचन (विद्यार्थिनी) के साथ 'जाती' क्रिया आती है।"
        ),

        // === पाठ 9: यह, ये, वह, वे ===
        QuestionModel(
            id = "s_6_hin_u9_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 9,
            type = "MCQ",
            questionText = "______ संतरा है।",
            options = listOf("ये", "यह", "वे", "हम"),
            correctAnswer = "यह",
            explanation = "एकवचन निकटवर्ती संज्ञा के लिए 'यह' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u9_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 9,
            type = "MCQ",
            questionText = "______ तितलियाँ हैं।",
            options = listOf("वह", "यह", "वे", "मेरा"),
            correctAnswer = "वे",
            explanation = "बहुवचन संज्ञा 'तितलियाँ हैं' के लिए 'वे' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u9_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 9,
            type = "MCQ",
            questionText = "______ फूल है।",
            options = listOf("वह", "वे", "ये", "हम"),
            correctAnswer = "वह",
            explanation = "एकवचन संज्ञा 'फूल है' के लिए 'वह' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u9_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 9,
            type = "MCQ",
            questionText = "______ कलम है।",
            options = listOf("ये", "यह", "वे", "तुम"),
            correctAnswer = "यह",
            explanation = "एकवचन के लिए 'यह कलम है' सही है।"
        ),
        QuestionModel(
            id = "s_6_hin_u9_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 9,
            type = "MCQ",
            questionText = "______ पढ़े।",
            options = listOf("यह", "वह", "वे", "मेरा"),
            correctAnswer = "वे",
            explanation = "बहुवचन क्रिया 'पढ़े' के साथ 'वे' आता है।"
        ),

        // === पाठ 10: मेरा, हमारा, तेरा, तुम्हारा ===
        QuestionModel(
            id = "s_6_hin_u10_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 10,
            type = "MCQ",
            questionText = "______ भाई है।",
            options = listOf("मेरी", "मेरे", "मेरा", "मुझे"),
            correctAnswer = "मेरे",
            explanation = "संबोधन व आदरार्थक रूप में 'मेरे भाई है' उपयुक्त है।"
        ),
        QuestionModel(
            id = "s_6_hin_u10_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 10,
            type = "MCQ",
            questionText = "______ बहन है।",
            options = listOf("मेरी", "मेरा", "मेरे", "हमारा"),
            correctAnswer = "मेरी",
            explanation = "स्त्रीलिंग संज्ञा 'बहन' के साथ 'मेरी' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u10_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 10,
            type = "MCQ",
            questionText = "______ चाचा हैं।",
            options = listOf("मेरी", "मेरा", "मेरे", "हमारी"),
            correctAnswer = "मेरे",
            explanation = "आदरार्थक बहुवचन 'चाचा हैं' के साथ 'मेरे' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u10_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 10,
            type = "MCQ",
            questionText = "______ माँ है।",
            options = listOf("मेरा", "मेरी", "मेरे", "हमारा"),
            correctAnswer = "मेरी",
            explanation = "स्त्रीलिंग संज्ञा 'माँ' के साथ संबंधबोधक 'मेरी' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u10_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 10,
            type = "MCQ",
            questionText = "मेरा नाम सविता है। यह मेरा ______ है।",
            options = listOf("खेत", "कमरा", "भाई", "बहन"),
            correctAnswer = "कमरा",
            explanation = "पाठ के अभ्यास के अनुसार 'यह मेरा कमरा है' सही है।"
        ),
        QuestionModel(
            id = "s_6_hin_u10_6",
            stdId = 6,
            subjectId = "hindi",
            unitId = 10,
            type = "MCQ",
            questionText = "कुत्ता ______ होता है।",
            options = listOf("वफ़ादार", "हरा", "ठंडा", "मीठा"),
            correctAnswer = "वफ़ादार",
            explanation = "कुत्ता स्वभाव से एक वफ़ादार जानवर होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u10_7",
            stdId = 6,
            subjectId = "hindi",
            unitId = 10,
            type = "MCQ",
            questionText = "खरगोश ______ खाता है।",
            options = listOf("किताब", "गाजर", "कलम", "कपड़ा"),
            correctAnswer = "गाजर",
            explanation = "खरगोश को गाजर खाना बहुत पसंद है।"
        ),
        QuestionModel(
            id = "s_6_hin_u10_8",
            stdId = 6,
            subjectId = "hindi",
            unitId = 10,
            type = "MCQ",
            questionText = "तुम्हारा विद्यालय ______ है।",
            options = listOf("साफ-सुथरा", "वफ़ादार", "मीठा", "ठंडा"),
            correctAnswer = "साफ-सुथरा",
            explanation = "विद्यालय के विशेषण के रूप में 'साफ-सुथरा' उपयुक्त है।"
        ),

        // === पाठ 11: इसका, इनका, उसका, उनका ===
        QuestionModel(
            id = "s_6_hin_u11_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 11,
            type = "MCQ",
            questionText = "यह घोड़ा है। ______ रंग काला है।",
            options = listOf("इसका", "इनका", "हमारी", "उनकी"),
            correctAnswer = "इसका",
            explanation = "निकटवर्ती एकवचन 'यह घोड़ा' के लिए 'इसका' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u11_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 11,
            type = "MCQ",
            questionText = "राघव ______ पड़ोसी है।",
            options = listOf("हमारा", "हमारे", "हमारी", "मेरा"),
            correctAnswer = "हमारा",
            explanation = "राघव के लिए संबंधवाचक रूप 'हमारा पड़ोसी' सही है।"
        ),
        QuestionModel(
            id = "s_6_hin_u11_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 11,
            type = "MCQ",
            questionText = "______ परिवार बड़ा है।",
            options = listOf("इसका", "इनका", "उनकी", "मेरा"),
            correctAnswer = "इनका",
            explanation = "आदरार्थक या बहुवचन संदर्भ में 'इनका परिवार बड़ा है' सही है।"
        ),
        QuestionModel(
            id = "s_6_hin_u11_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 11,
            type = "MCQ",
            questionText = "______ घर स्कूल के पास है।",
            options = listOf("मेरी", "मेरा", "हमारे", "हमारी"),
            correctAnswer = "मेरा",
            explanation = "पुल्लिंग संज्ञा 'घर' के साथ 'मेरा' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u11_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 11,
            type = "MCQ",
            questionText = "______ बहन अध्यापिका है।",
            options = listOf("मेरा", "मेरी", "मेरे", "हमारा"),
            correctAnswer = "मेरी",
            explanation = "स्त्रीलिंग संज्ञा 'बहन' के साथ 'मेरी' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u11_6",
            stdId = 6,
            subjectId = "hindi",
            unitId = 11,
            type = "MCQ",
            questionText = "हाथी एक जंगली जानवर है। ______ शरीर बड़ा है।",
            options = listOf("इसके", "उसकी", "उनका", "हमारी"),
            correctAnswer = "इसके",
            explanation = "हाथी के संदर्भ में वाक्य-पूर्ति हेतु 'इसके' सही है।"
        ),
        QuestionModel(
            id = "s_6_hin_u11_7",
            stdId = 6,
            subjectId = "hindi",
            unitId = 11,
            type = "MCQ",
            questionText = "कविता सुंदर लिखती है। ______ लिखावट शुद्ध भी होती है।",
            options = listOf("इसकी", "इसका", "उनके", "हमारा"),
            correctAnswer = "इसकी",
            explanation = "स्त्रीलिंग संज्ञा 'लिखावट' के साथ 'इसकी' आता है।"
        ),

        // === पाठ 12: का, की, के ===
        QuestionModel(
            id = "s_6_hin_u12_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 12,
            type = "MCQ",
            questionText = "राजा दशरथ ______ बड़ा बेटा राम था।",
            options = listOf("की", "का", "के", "को"),
            correctAnswer = "का",
            explanation = "पुल्लिंग एकवचन 'बेटा' के साथ 'का' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u12_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 12,
            type = "MCQ",
            questionText = "राजा दशरथ ______ चार बेटे थे।",
            options = listOf("की", "का", "के", "को"),
            correctAnswer = "के",
            explanation = "बहुवचन संज्ञा 'चार बेटे' के साथ संबंध कारक 'के' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u12_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 12,
            type = "MCQ",
            questionText = "राजा दशरथ ______ तीन रानियाँ थीं।",
            options = listOf("के", "का", "की", "को"),
            correctAnswer = "की",
            explanation = "स्त्रीलिंग संज्ञा 'रानियाँ' के साथ संबंध कारक 'की' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u12_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 12,
            type = "MCQ",
            questionText = "वह संजू ______ भाई है।",
            options = listOf("का", "की", "के", "को"),
            correctAnswer = "का",
            explanation = "पुल्लिंग 'भाई' के साथ 'का' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u12_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 12,
            type = "MCQ",
            questionText = "यह दीपा ______ बहन है।",
            options = listOf("का", "की", "के", "को"),
            correctAnswer = "की",
            explanation = "स्त्रीलिंग 'बहन' के साथ संबंध कारक 'की' का प्रयोग होता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u12_6",
            stdId = 6,
            subjectId = "hindi",
            unitId = 12,
            type = "MCQ",
            questionText = "वे सीमा ______ पिता हैं।",
            options = listOf("का", "की", "के", "को"),
            correctAnswer = "के",
            explanation = "आदरार्थक बहुवचन 'पिता हैं' के साथ 'के' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u12_7",
            stdId = 6,
            subjectId = "hindi",
            unitId = 12,
            type = "MCQ",
            questionText = "मोहन ______ मित्र गाँव गया है।",
            options = listOf("का", "की", "के", "को"),
            correctAnswer = "का",
            explanation = "पुल्लिंग एकवचन 'मित्र' के साथ 'का' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u12_8",
            stdId = 6,
            subjectId = "hindi",
            unitId = 12,
            type = "MCQ",
            questionText = "फूल ______ रंग लाल है।",
            options = listOf("की", "के", "का", "को"),
            correctAnswer = "का",
            explanation = "पुल्लिंग संज्ञा 'रंग' के साथ 'का' आता है।"
        ),

        // === पाठ 13: आया, आये, आयी, आयीं ===
        QuestionModel(
            id = "s_6_hin_u13_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 13,
            type = "MCQ",
            questionText = "माली बगीचे से ______।",
            options = listOf("आया", "आयी", "आयीं", "आयेगी"),
            correctAnswer = "आया",
            explanation = "पुल्लिंग एकवचन 'माली' के साथ भूतकाल क्रिया 'आया' होगी।"
        ),
        QuestionModel(
            id = "s_6_hin_u13_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 13,
            type = "MCQ",
            questionText = "दादाजी जलेबी ______।",
            options = listOf("लाया", "लायें", "लायी", "लायीं"),
            correctAnswer = "लायें",
            explanation = "आदरार्थक क्रिया रूप के अनुसार 'दादाजी जलेबी लायें' सही है।"
        ),
        QuestionModel(
            id = "s_6_hin_u13_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 13,
            type = "MCQ",
            questionText = "वनिता पाठशाला से ______।",
            options = listOf("आया", "आयी", "आये", "आयीं"),
            correctAnswer = "आयी",
            explanation = "स्त्रीलिंग एकवचन 'वनिता' के साथ 'आयी' क्रिया आती है।"
        ),
        QuestionModel(
            id = "s_6_hin_u13_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 13,
            type = "MCQ",
            questionText = "चिड़ियाँ ______।",
            options = listOf("आया", "आये", "आयी", "आयीं"),
            correctAnswer = "आयीं",
            explanation = "स्त्रीलिंग बहुवचन 'चिड़ियाँ' के साथ अनुनासिक 'आयीं' क्रिया रूप आता है।"
        ),

        // === पाठ 14: था, थे, थी, थीं ===
        QuestionModel(
            id = "s_6_hin_u14_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 14,
            type = "MCQ",
            questionText = "अमित सिपाही ______।",
            options = listOf("थी", "थे", "था", "थीं"),
            correctAnswer = "था",
            explanation = "पुल्लिंग एकवचन भूतकाल सहायक क्रिया 'था' है।"
        ),
        QuestionModel(
            id = "s_6_hin_u14_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 14,
            type = "MCQ",
            questionText = "राकेश और राहुल मित्र ______।",
            options = listOf("था", "थी", "थे", "थीं"),
            correctAnswer = "थे",
            explanation = "पुल्लिंग बहुवचन कर्ता के साथ 'थे' सहायक क्रिया आती है।"
        ),
        QuestionModel(
            id = "s_6_hin_u14_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 14,
            type = "MCQ",
            questionText = "रूपा और सलमा सहेलियाँ ______।",
            options = listOf("था", "थे", "थी", "थीं"),
            correctAnswer = "थीं",
            explanation = "स्त्रीलिंग बहुवचन कर्ता (सहेलियाँ) के साथ 'थीं' आता है।"
        ),

        // === पाठ 15: ता, ते, ती ===
        QuestionModel(
            id = "s_6_hin_u15_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 15,
            type = "MCQ",
            questionText = "राधा गाँव ______ है।",
            options = listOf("जाता", "जाते", "जाती", "जाओ"),
            correctAnswer = "जाती",
            explanation = "स्त्रीलिंग एकवचन (राधा) के साथ 'जाती है' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u15_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 15,
            type = "MCQ",
            questionText = "सुमन दूध पी______ है।",
            options = listOf("ता", "ते", "ती", "ना"),
            correctAnswer = "ता",
            explanation = "अभ्यास के अनुसार 'पीता है' रूप दिया गया है।"
        ),
        QuestionModel(
            id = "s_6_hin_u15_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 15,
            type = "MCQ",
            questionText = "लता सुंदर गा______ है।",
            options = listOf("ता", "ते", "ती", "ना"),
            correctAnswer = "ती",
            explanation = "स्त्रीलिंग एकवचन कर्ता 'लता' के साथ 'गाती है' बनता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u15_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 15,
            type = "MCQ",
            questionText = "खरगोश गाजर खा______ है।",
            options = listOf("ता", "ते", "ती", "ना"),
            correctAnswer = "ता",
            explanation = "पुल्लिंग एकवचन 'खरगोश' के साथ 'खाता है' बनता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u15_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 15,
            type = "MCQ",
            questionText = "बच्चे मैदान में खेल______ हैं।",
            options = listOf("ता", "ते", "ती", "ना"),
            correctAnswer = "ते",
            explanation = "पुल्लिंग बहुवचन 'बच्चे' के साथ 'खेलते हैं' बनता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u15_6",
            stdId = 6,
            subjectId = "hindi",
            unitId = 15,
            type = "MCQ",
            questionText = "लड़कियाँ पाठ पढ़______ हैं।",
            options = listOf("ता", "ते", "ती", "ना"),
            correctAnswer = "ती",
            explanation = "स्त्रीलिंग बहुवचन 'लड़कियाँ' के साथ क्रिया रूप 'पढ़ती हैं' बनता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u15_7",
            stdId = 6,
            subjectId = "hindi",
            unitId = 15,
            type = "MCQ",
            questionText = "रमेश ______ है।",
            options = listOf("गाता", "गाती", "गाते", "गाना"),
            correctAnswer = "गाता",
            explanation = "पुल्लिंग एकवचन कर्ता 'रमेश' के साथ 'गाता है' सही है।"
        ),
        QuestionModel(
            id = "s_6_hin_u15_8",
            stdId = 6,
            subjectId = "hindi",
            unitId = 15,
            type = "MCQ",
            questionText = "राम ______ है।",
            options = listOf("अच्छी", "अच्छा", "अच्छे", "अच्छाई"),
            correctAnswer = "अच्छा",
            explanation = "पुल्लिंग एकवचन विशेषण 'अच्छा' सही है।"
        ),

        // === पाठ 16: रहा, रही, रहे ===
        QuestionModel(
            id = "s_6_hin_u16_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 16,
            type = "MCQ",
            questionText = "रवि रोटी खा______ है।",
            options = listOf("रहा", "रही", "रहे", "गई"),
            correctAnswer = "रहा",
            explanation = "पुल्लिंग एकवचन कर्ता (रवि) के साथ 'खा रहा है' आएगा।"
        ),
        QuestionModel(
            id = "s_6_hin_u16_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 16,
            type = "MCQ",
            questionText = "रीना पराठा खा______ है।",
            options = listOf("रहा", "रही", "रहे", "गए"),
            correctAnswer = "रही",
            explanation = "स्त्रीलिंग एकवचन कर्ता (रीना) के साथ 'खा रही है' आएगा।"
        ),
        QuestionModel(
            id = "s_6_hin_u16_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 16,
            type = "MCQ",
            questionText = "पिताजी कॉफी पी______ हैं।",
            options = listOf("रही", "रहा", "रहे", "गई"),
            correctAnswer = "रहे",
            explanation = "आदरार्थक बहुवचन 'पिताजी' के साथ 'पी रहे हैं' आएगा।"
        ),
        QuestionModel(
            id = "s_6_hin_u16_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 16,
            type = "MCQ",
            questionText = "अनूप कपड़े बेच______ है।",
            options = listOf("रहा", "रही", "रहे", "गई"),
            correctAnswer = "रहा",
            explanation = "पुल्लिंग एकवचन (अनूप) के साथ 'बेच रहा है' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u16_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 16,
            type = "MCQ",
            questionText = "नीता गाड़ी चला______ है।",
            options = listOf("रहा", "रही", "रहे", "गए"),
            correctAnswer = "रही",
            explanation = "स्त्रीलिंग एकवचन (नीता) के साथ 'चला रही है' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u16_6",
            stdId = 6,
            subjectId = "hindi",
            unitId = 16,
            type = "MCQ",
            questionText = "बच्चा हँस______ है।",
            options = listOf("रही", "रहे", "रहा", "गई"),
            correctAnswer = "रहा",
            explanation = "पुल्लिंग एकवचन (बच्चा) के साथ 'हँस रहा है' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u16_7",
            stdId = 6,
            subjectId = "hindi",
            unitId = 16,
            type = "MCQ",
            questionText = "बुढ़िया जा______ है।",
            options = listOf("रहा", "रही", "रहे", "गए"),
            correctAnswer = "रही",
            explanation = "स्त्रीलिंग कर्ता (बुढ़िया) के साथ 'जा रही है' आता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u16_8",
            stdId = 6,
            subjectId = "hindi",
            unitId = 16,
            type = "MCQ",
            questionText = "अध्यापक पढ़ा______ है।",
            options = listOf("रहा", "रही", "रहे", "गई"),
            correctAnswer = "रहा",
            explanation = "वाक्य संरचना के अनुसार 'पढ़ा रहा है' सही है।"
        ),
        QuestionModel(
            id = "s_6_hin_u16_9",
            stdId = 6,
            subjectId = "hindi",
            unitId = 16,
            type = "MCQ",
            questionText = "नानाजी आ______ हैं।",
            options = listOf("रहा", "रही", "रहे", "गया"),
            correctAnswer = "रहे",
            explanation = "आदरार्थक बहुवचन 'नानाजी' के साथ 'आ रहे हैं' आता है।"
        ),

        // === पाठ 17: जायेगा, जायेंगे, जायेगी, जायेंगी ===
        QuestionModel(
            id = "s_6_hin_u17_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 17,
            type = "MCQ",
            questionText = "विजय धारवाड़ ______।",
            options = listOf("जायेगी", "जायेगा", "जायेंगी", "गये"),
            correctAnswer = "जायेगा",
            explanation = "पुल्लिंग एकवचन 'विजय' के साथ भविष्यत् काल क्रिया 'जायेगा' आएगी।"
        ),
        QuestionModel(
            id = "s_6_hin_u17_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 17,
            type = "MCQ",
            questionText = "वह पेड़ा ______।",
            options = listOf("लायेंगी", "लायेगा", "लायी", "लायेगी"),
            correctAnswer = "लायेगा",
            explanation = "पुल्लिंग संदर्भ में भविष्यत् क्रिया 'लायेगा' होगी।"
        ),
        QuestionModel(
            id = "s_6_hin_u17_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 17,
            type = "MCQ",
            questionText = "अंजली नागपुर ______।",
            options = listOf("जायेगा", "जायेगी", "जायेंगे", "गये"),
            correctAnswer = "जायेगी",
            explanation = "स्त्रीलिंग एकवचन 'अंजली' के साथ भविष्यत् काल में 'जायेगी' आएगा।"
        ),
        QuestionModel(
            id = "s_6_hin_u17_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 17,
            type = "MCQ",
            questionText = "पिताजी शहर ______।",
            options = listOf("जायेंगी", "जायेंगे", "जायेगी", "जायेगा"),
            correctAnswer = "जायेंगे",
            explanation = "आदरार्थक बहुवचन 'पिताजी' के साथ भविष्यत् काल क्रिया 'जायेंगे' होगी।"
        ),
        QuestionModel(
            id = "s_6_hin_u17_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 17,
            type = "MCQ",
            questionText = "वह किताबें ______।",
            options = listOf("लायेगी", "लायेंगे", "लायेगा", "लाया"),
            correctAnswer = "लायेगी",
            explanation = "स्त्रीलिंग संदर्भ में भविष्यत् काल क्रिया 'लायेगी' सही है।"
        ),

        // === पाठ 19: हाथी मेरा साथी (कहानी) ===
        QuestionModel(
            id = "s_6_hin_u19_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 19,
            type = "MCQ",
            questionText = "______ को प्यास लगी थी।",
            options = listOf("हाथी", "गिलहरी", "मगरमच्छ", "चिड़िया"),
            correctAnswer = "गिलहरी",
            explanation = "कहानी 'हाथी मेरा साथी' में नन्हीं गिलहरी को बहुत प्यास लगी थी।"
        ),
        QuestionModel(
            id = "s_6_hin_u19_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 19,
            type = "MCQ",
            questionText = "गिलहरी का गला ______ रहा था।",
            options = listOf("सूख", "गा", "हँस", "दौड़"),
            correctAnswer = "सूख",
            explanation = "प्यास के मारे गिलहरी का गला सूख रहा था।"
        ),
        QuestionModel(
            id = "s_6_hin_u19_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 19,
            type = "MCQ",
            questionText = "गिलहरी पानी की ______ में निकली।",
            options = listOf("खोज", "पढ़ाई", "सैर", "यात्रा"),
            correctAnswer = "खोज",
            explanation = "प्यास बुझाने के लिए गिलहरी पानी की खोज में निकली।"
        ),
        QuestionModel(
            id = "s_6_hin_u19_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 19,
            type = "MCQ",
            questionText = "______ में पानी था।",
            options = listOf("घर", "कुएँ", "जंगल", "सड़क"),
            correctAnswer = "कुएँ",
            explanation = "कुएँ में गहराई पर पानी था जहाँ गिलहरी नहीं पहुँच सकती थी।"
        ),
        QuestionModel(
            id = "s_6_hin_u19_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 19,
            type = "MCQ",
            questionText = "हाथी ने गिलहरी को अपनी ______ से पानी पिलाया।",
            options = listOf("पूँछ", "सूँड", "टाँग", "पीठ"),
            correctAnswer = "सूँड",
            explanation = "दयालु हाथी ने अपनी सूँड में पानी भरकर गिलहरी को पिलाया।"
        ),
        QuestionModel(
            id = "s_6_hin_u19_6",
            stdId = 6,
            subjectId = "hindi",
            unitId = 19,
            type = "MCQ",
            questionText = "हाथी गिलहरी को एक ______ के पास ले गया।",
            options = listOf("दुकान", "कुएँ", "विद्यालय", "पेड़"),
            correctAnswer = "कुएँ",
            explanation = "हाथी गिलहरी को पानी पिलाने के लिए एक कुएँ के पास ले गया।"
        ),
        QuestionModel(
            id = "s_6_hin_u19_7",
            stdId = 6,
            subjectId = "hindi",
            unitId = 19,
            type = "MCQ",
            questionText = "गिलहरी ने कहा, “अब से तू मेरा ______।”",
            options = listOf("शत्रु", "साथी", "शिक्षक", "मालिक"),
            correctAnswer = "साथी",
            explanation = "गिलहरी ने कृतज्ञ होकर हाथी से कहा- 'अब से तू मेरा सच्चा साथी है'।"
        ),

        // === पाठ 20: रेल का खेल (कविता) ===
        QuestionModel(
            id = "s_6_hin_u20_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 20,
            type = "MCQ",
            questionText = "मोहन तुम ______ बन जाओ।",
            options = listOf("गार्ड", "इंजन", "पटरी", "झंडी"),
            correctAnswer = "इंजन",
            explanation = "कविता 'रेल का खेल' में मोहन को इंजन बनने को कहा गया है।"
        ),
        QuestionModel(
            id = "s_6_hin_u20_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 20,
            type = "MCQ",
            questionText = "लाल-______ झंडा दिखलाओ।",
            options = listOf("काला", "हरा", "सफेद", "नीला"),
            correctAnswer = "हरा",
            explanation = "रेलगाड़ी के खेल में लाल-हरा झंडा दिखलाने की बात कही गई है।"
        ),
        QuestionModel(
            id = "s_6_hin_u20_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 20,
            type = "MCQ",
            questionText = "______ उड़ाती जाती रेल।",
            options = listOf("धूल", "धुआँ", "पानी", "हवा"),
            correctAnswer = "धुआँ",
            explanation = "कविता के अनुसार 'धुआँ उड़ाती जाती रेल' पंक्ति आती है।"
        ),
        QuestionModel(
            id = "s_6_hin_u20_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 20,
            type = "MCQ",
            questionText = "रेल ______ पर चलती है।",
            options = listOf("सड़क", "पटरी", "मैदान", "नदी"),
            correctAnswer = "पटरी",
            explanation = "रेलगाड़ी लोहे की पटरियों पर दौड़ती है।"
        ),
        QuestionModel(
            id = "s_6_hin_u20_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 20,
            type = "MCQ",
            questionText = "छुक-छुक करती ______ रेल।",
            options = listOf("आती", "जाती", "बैठती", "सोती"),
            correctAnswer = "जाती",
            explanation = "कविता में 'छुक-छुक करती जाती रेल' पंक्ति का वर्णन है।"
        ),

        // === पाठ 21: चतुर बंदर (कहानी) ===
        QuestionModel(
            id = "s_6_hin_u21_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 21,
            type = "MCQ",
            questionText = "बंदर मगरमच्छ के ______ पर बैठकर सैर करता था।",
            options = listOf("पेट", "पीठ", "कमर", "सेना"),
            correctAnswer = "पीठ",
            explanation = "कहानी में बंदर मगरमच्छ की पीठ पर बैठकर नदी में सैर करता था।"
        ),
        QuestionModel(
            id = "s_6_hin_u21_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 21,
            type = "MCQ",
            questionText = "बंदर और मगरमच्छ में गहरी ______ थी।",
            options = listOf("दुश्मनी", "दोस्ती", "लड़ाई", "नाराज़गी"),
            correctAnswer = "दोस्ती",
            explanation = "जामुन के पेड़ पर रहने वाले बंदर और नदी के मगरमच्छ में गहरी दोस्ती थी।"
        ),
        QuestionModel(
            id = "s_6_hin_u21_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 21,
            type = "MCQ",
            questionText = "बंदर मगरमच्छ को मीठे-मीठे ______ देता था।",
            options = listOf("अमरूद", "जामुन", "सेब", "केला"),
            correctAnswer = "जामुन",
            explanation = "बंदर पेड़ से मीठे जामुन तोड़कर अपने मित्र मगरमच्छ को देता था।"
        ),
        QuestionModel(
            id = "s_6_hin_u21_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 21,
            type = "MCQ",
            questionText = "मगरमच्छ की पत्नी ने ______ माँगा।",
            options = listOf("जामुन", "कलेजा", "मिठाई", "दवाई"),
            correctAnswer = "कलेजा",
            explanation = "मगरमच्छ की दुष्ट पत्नी ने बंदर का मीठा कलेजा खाने की ज़िद की।"
        ),
        QuestionModel(
            id = "s_6_hin_u21_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 21,
            type = "MCQ",
            questionText = "मगरमच्छ ने बंदर को ______ के लिए बुलाया।",
            options = listOf("खेलने", "नाचने", "तैरने", "खाने"),
            correctAnswer = "खाने",
            explanation = "मगरमच्छ ने बहाना बनाकर बंदर को घर पर खाने के लिए आमंत्रित किया।"
        ),
        QuestionModel(
            id = "s_6_hin_u21_6",
            stdId = 6,
            subjectId = "hindi",
            unitId = 21,
            type = "MCQ",
            questionText = "मगरमच्छ नदी ______ सैर करता था।",
            options = listOf("का", "की", "में", "को"),
            correctAnswer = "में",
            explanation = "अधिकरण कारक 'नदी में सैर करता था' सही प्रयोग है।"
        ),
        QuestionModel(
            id = "s_6_hin_u21_7",
            stdId = 6,
            subjectId = "hindi",
            unitId = 21,
            type = "MCQ",
            questionText = "बंदर मगरमच्छ ______ जामुन देता था।",
            options = listOf("का", "को", "की", "के"),
            correctAnswer = "को",
            explanation = "कर्म/संप्रदान कारक 'को' का प्रयोग यहाँ उचित है।"
        ),
        QuestionModel(
            id = "s_6_hin_u21_8",
            stdId = 6,
            subjectId = "hindi",
            unitId = 21,
            type = "MCQ",
            questionText = "बंदर ने संकट के समय ______ से काम लिया।",
            options = listOf("मूर्खता", "चतुराई", "आलस", "क्रोध"),
            correctAnswer = "चतुराई",
            explanation = "बंदर ने चतुराई से कहा कि उसका कलेजा तो पेड़ पर ही रह गया है।"
        ),

        // === पाठ 22: माँ का प्यार (कविता) ===
        QuestionModel(
            id = "s_6_hin_u22_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 22,
            type = "MCQ",
            questionText = "मेरी माँ रोज ______ जगाती है।",
            options = listOf("देर से", "सुबह", "रात में", "दोपहर में"),
            correctAnswer = "सुबह",
            explanation = "कविता के अनुसार माँ रोज सवेरे सुबह जगाती है।"
        ),
        QuestionModel(
            id = "s_6_hin_u22_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 22,
            type = "MCQ",
            questionText = "मेरे पिताजी रोज ______ कहानी सुनाते हैं।",
            options = listOf("अच्छी", "कल", "छोटी", "सुबह"),
            correctAnswer = "अच्छी",
            explanation = "अभ्यास के अनुसार पिताजी रोज अच्छी-अच्छी कहानियाँ सुनाते हैं।"
        ),
        QuestionModel(
            id = "s_6_hin_u22_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 22,
            type = "MCQ",
            questionText = "मेरी नानी रोज ______ से फल लाती हैं।",
            options = listOf("विद्यालय", "बाजार", "जंगल", "नदी"),
            correctAnswer = "बाजार",
            explanation = "नानी बाजार जाकर ताजे फल लाती हैं।"
        ),
        QuestionModel(
            id = "s_6_hin_u22_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 22,
            type = "MCQ",
            questionText = "उँगली ______ लिखना सिखाया।",
            options = listOf("पकड़कर", "छोड़कर", "देखकर", "बुलाकर"),
            correctAnswer = "पकड़कर",
            explanation = "माँ ने उँगली पकड़कर चलना और लिखना सिखाया।"
        ),
        QuestionModel(
            id = "s_6_hin_u22_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 22,
            type = "MCQ",
            questionText = "खाकर ठोकर ______ सिखाया।",
            options = listOf("बैठना", "उठना", "सोना", "दौड़ना"),
            correctAnswer = "उठना",
            explanation = "जीवन में ठोकर खाकर फिर से संभलकर उठना सिखाया।"
        ),

        // === पाठ 23: अक्षर ही अक्षर (निबंध) ===
        QuestionModel(
            id = "s_6_hin_u23_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 23,
            type = "MCQ",
            questionText = "समाचार पत्र में देखो ______।",
            options = listOf("पुस्तक", "भाषा", "गाना", "अक्षर"),
            correctAnswer = "अक्षर",
            explanation = "पाठ 'अक्षर ही अक्षर' में समाचार पत्र में अक्षरों की दुनिया का उल्लेख है।"
        ),
        QuestionModel(
            id = "s_6_hin_u23_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 23,
            type = "MCQ",
            questionText = "अक्षरों की खोज ______ की सबसे बड़ी सोच है।",
            options = listOf("मनुष्य", "भाषा", "नागरिक", "समाज"),
            correctAnswer = "मनुष्य",
            explanation = "अक्षरों की खोज मानव सभ्यता के इतिहास में मनुष्य की सबसे बड़ी खोज है।"
        ),
        QuestionModel(
            id = "s_6_hin_u23_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 23,
            type = "MCQ",
            questionText = "चलते-चलते मानव ने ______ को अपनाया।",
            options = listOf("खाना", "अक्षर", "भाषा", "विचार"),
            correctAnswer = "भाषा",
            explanation = "विकास की यात्रा में मनुष्य ने अपने विचारों के आदान-प्रदान हेतु भाषा को अपनाया।"
        ),
        QuestionModel(
            id = "s_6_hin_u23_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 23,
            type = "MCQ",
            questionText = "प्रारंभ में ______ के माध्यम से मानव विचार प्रकट करता था।",
            options = listOf("चित्रों", "भाव", "माध्यम", "किताब"),
            correctAnswer = "चित्रों",
            explanation = "लिपि के विकास से पहले आदिमानव गुफाओं में चित्रों के माध्यम से अपने भाव प्रकट करता था।"
        ),
        QuestionModel(
            id = "s_6_hin_u23_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 23,
            type = "MCQ",
            questionText = "‘दुःख’ का विलोम शब्द ______ है।",
            options = listOf("शत्रु", "सुख", "आरंभ", "खोज"),
            correctAnswer = "सुख",
            explanation = "दुःख का विपरीतार्थक (विलोम) शब्द 'सुख' होता है।"
        ),

        // === पाठ 25: वनमहोत्सव (पर्यावरण) ===
        QuestionModel(
            id = "s_6_hin_u25_1",
            stdId = 6,
            subjectId = "hindi",
            unitId = 25,
            type = "MCQ",
            questionText = "विश्व पर्यावरण दिवस ______ जून को मनाया जाता है।",
            options = listOf("1", "5", "15", "21"),
            correctAnswer = "5",
            explanation = "प्रतिवर्ष 5 जून को विश्व पर्यावरण दिवस मनाया जाता है।"
        ),
        QuestionModel(
            id = "s_6_hin_u25_2",
            stdId = 6,
            subjectId = "hindi",
            unitId = 25,
            type = "MCQ",
            questionText = "लता और गीता ने पेड़ों के चारों तरफ ______ के बाड़ लगाने के लिए कहा।",
            options = listOf("लकड़ी", "तारों", "कपड़े", "कागज"),
            correctAnswer = "तारों",
            explanation = "पौधों को जानवरों से बचाने के लिए चारों तरफ तारों की बाड़ लगाने की बात कही गई।"
        ),
        QuestionModel(
            id = "s_6_hin_u25_3",
            stdId = 6,
            subjectId = "hindi",
            unitId = 25,
            type = "MCQ",
            questionText = "राजीव ने कहा, “मैं हर साल अपने ______ पर एक पेड़ लगाकर मनाऊँगा।”",
            options = listOf("जन्मदिन", "परीक्षा", "खेल", "त्योहार"),
            correctAnswer = "जन्मदिन",
            explanation = "राजीव ने हर वर्ष अपने जन्मदिन के शुभ अवसर पर एक पौधा लगाने का संकल्प लिया।"
        ),
        QuestionModel(
            id = "s_6_hin_u25_4",
            stdId = 6,
            subjectId = "hindi",
            unitId = 25,
            type = "MCQ",
            questionText = "पेड़ों से ______ होती है।",
            options = listOf("गर्मी", "वर्षा", "लड़ाई", "धूल"),
            correctAnswer = "वर्षा",
            explanation = "घने वृक्ष पर्यावरण को ठंडा रखते हैं और अच्छी वर्षा लाने में सहायक होते हैं।"
        ),
        QuestionModel(
            id = "s_6_hin_u25_5",
            stdId = 6,
            subjectId = "hindi",
            unitId = 25,
            type = "MCQ",
            questionText = "पेड़ों से शुद्ध ______ मिलती है।",
            options = listOf("मिट्टी", "हवा", "धूल", "आग"),
            correctAnswer = "हवा",
            explanation = "पेड़ कार्बन डाइऑक्साइड सोखकर हमें जीवनदायी शुद्ध ऑक्सीजन (हवा) देते हैं।"
        )
    )
}
