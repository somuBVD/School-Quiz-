package com.example.data

/**
 * Standard 7 Hindi (LBA Revised 2026-27, 7thLBAHindi-REVISED_1788068183.pdf)
 * Official Question Bank containing all 18 lessons/topics with authentic MCQs and answers.
 */
object Std7HindiQuestionBank {

    val units: List<UnitTemplate> = listOf(
        UnitTemplate(1, "पाठ 1: पढ़ना है जी पढ़ना है", 5, "Easy"),
        UnitTemplate(2, "पाठ 2: अध्यापक और विद्यार्थी", 5, "Easy"),
        UnitTemplate(3, "पाठ 3: सुनो मेरी कहानी", 5, "Medium"),
        UnitTemplate(4, "पाठ 4: मैं भी नाम कमाता", 5, "Medium"),
        UnitTemplate(5, "पाठ 5: जिसकी मेहनत उसकी जीत", 5, "Medium"),
        UnitTemplate(6, "पाठ 6: हमारे राष्ट्रीय प्रतीक", 5, "Easy"),
        UnitTemplate(7, "पाठ 7: रसोईघर", 5, "Easy"),
        UnitTemplate(8, "पाठ 8: गिनती (50–70)", 5, "Medium"),
        UnitTemplate(9, "पाठ 9: दिल्ली", 5, "Medium"),
        UnitTemplate(10, "पाठ 10: मेरी अभिलाषा है", 5, "Easy"),
        UnitTemplate(11, "पाठ 11: समझदार राजू", 5, "Medium"),
        UnitTemplate(12, "पाठ 12: मित्र के नाम पत्र", 5, "Medium"),
        UnitTemplate(13, "पाठ 13: बसंत", 5, "Medium"),
        UnitTemplate(14, "पाठ 14: सूझ-बूझ", 5, "Hard"),
        UnitTemplate(15, "पाठ 15: अनमोल वचन", 5, "Hard"),
        UnitTemplate(16, "पाठ 16: कर्नाटक", 5, "Medium"),
        UnitTemplate(17, "पाठ 17: बाल दिवस", 5, "Easy"),
        UnitTemplate(18, "पाठ 18: व्याकरण और भाषा ज्ञान", 6, "Medium")
    )

    val questions: List<QuestionModel> = listOf(
        // ==================== पाठ 1: पढ़ना है जी पढ़ना है ====================
        QuestionModel(
            id = "std7_hindi_u1_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 1,
            questionText = "कवि के अनुसार हमें मेहनत से क्या नहीं करना चाहिए?",
            options = listOf("डरना", "भागना", "हँसना", "रोना"),
            correctAnswer = "डरना"
        ),
        QuestionModel(
            id = "std7_hindi_u1_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 1,
            questionText = "पापा और मम्मी का नाम किससे ऊँचा होगा?",
            options = listOf("खेलने से", "पढ़ने और आगे बढ़ने से", "सोने से", "बातें करने से"),
            correctAnswer = "पढ़ने और आगे बढ़ने से"
        ),
        QuestionModel(
            id = "std7_hindi_u1_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 1,
            questionText = "‘पढ़ना है जी पढ़ना है’ कविता के कवि कौन हैं?",
            options = listOf("हरिवंश राय बच्चन", "चंद्रपाल शर्मा ‘यादव’", "मैथिलीशरण गुप्त", "महादेवी वर्मा"),
            correctAnswer = "चंद्रपाल शर्मा ‘यादव’"
        ),
        QuestionModel(
            id = "std7_hindi_u1_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 1,
            questionText = "इम्तिहान की तैयारी के लिए हमें क्या करना चाहिए?",
            options = listOf("दिन-रात एक करना", "खेलकूद करना", "घूमना", "सोते रहना"),
            correctAnswer = "दिन-रात एक करना"
        ),
        QuestionModel(
            id = "std7_hindi_u1_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 1,
            questionText = "‘ताल’ शब्द का समान तुक वाला (Rhyming) शब्द क्या है?",
            options = listOf("बाल", "मेहनत", "सवेरा", "किताब"),
            correctAnswer = "बाल"
        ),

        // ==================== पाठ 2: अध्यापक और विद्यार्थी ====================
        QuestionModel(
            id = "std7_hindi_u2_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 2,
            questionText = "संवाद में विद्यार्थी का नाम क्या है?",
            options = listOf("राजू", "पवन", "अमन", "रोहन"),
            correctAnswer = "पवन"
        ),
        QuestionModel(
            id = "std7_hindi_u2_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 2,
            questionText = "पवन किस कक्षा में पढ़ता है?",
            options = listOf("पाँचवीं", "छठी", "सातवीं", "आठवीं"),
            correctAnswer = "सातवीं"
        ),
        QuestionModel(
            id = "std7_hindi_u2_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 2,
            questionText = "विद्यार्थी ने कक्षा में प्रवेश करते समय अध्यापक से क्या कहा?",
            options = listOf("नमस्ते सर", "नमस्ते गुरुजी, क्या मैं अंदर आ सकता हूँ?", "शुभ प्रभात", "धन्यवाद"),
            correctAnswer = "नमस्ते गुरुजी, क्या मैं अंदर आ सकता हूँ?"
        ),
        QuestionModel(
            id = "std7_hindi_u2_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 2,
            questionText = "‘अध्यापक’ शब्द का स्त्रीलिंग रूप क्या है?",
            options = listOf("अध्यापकी", "अध्यापिका", "शिक्षिका", "अध्यापिक"),
            correctAnswer = "अध्यापिका"
        ),
        QuestionModel(
            id = "std7_hindi_u2_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 2,
            questionText = "कक्षा में प्रवेश करने से पहले हमें क्या लेनी चाहिए?",
            options = listOf("अनुमति (आज्ञा)", "किताब", "कलम", "छुट्टी"),
            correctAnswer = "अनुमति (आज्ञा)"
        ),

        // ==================== पाठ 3: सुनो मेरी कहानी ====================
        QuestionModel(
            id = "std7_hindi_u3_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 3,
            questionText = "इस पाठ में अपनी आत्मकथा कौन सुना रहा है?",
            options = listOf("पेड़", "नदी", "सड़क", "पुस्तक"),
            correctAnswer = "पेड़"
        ),
        QuestionModel(
            id = "std7_hindi_u3_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 3,
            questionText = "पेड़ हमें जीने के लिए कौन-सी आवश्यक गैस देता है?",
            options = listOf("नाइट्रोजन", "ऑक्सीजन (प्राणवायु)", "कार्बन डाइऑक्साइड", "हाइड्रोजन"),
            correctAnswer = "ऑक्सीजन (प्राणवायु)"
        ),
        QuestionModel(
            id = "std7_hindi_u3_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 3,
            questionText = "पेड़ की जड़ें मिट्टी में क्या बाँधकर रखती हैं?",
            options = listOf("पानी और मिट्टी (मृदा संरक्षण)", "हवा", "धूप", "पत्थर"),
            correctAnswer = "पानी और मिट्टी (मृदा संरक्षण)"
        ),
        QuestionModel(
            id = "std7_hindi_u3_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 3,
            questionText = "पेड़ धूप में खड़ा रहकर राहगीरों को क्या देता है?",
            options = listOf("छाया", "फल", "फूल", "ये सभी"),
            correctAnswer = "ये सभी"
        ),
        QuestionModel(
            id = "std7_hindi_u3_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 3,
            questionText = "‘वृक्ष’ शब्द का पर्यायवाची शब्द क्या है?",
            options = listOf("पेड़ (तरु)", "सरिता", "पर्वत", "कमल"),
            correctAnswer = "पेड़ (तरु)"
        ),

        // ==================== पाठ 4: मैं भी नाम कमाता ====================
        QuestionModel(
            id = "std7_hindi_u4_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 4,
            questionText = "बालक किसकी वर्दी पहनना चाहता है?",
            options = listOf("पुलिस की", "सैनिक (फौजी) की", "डॉक्टर की", "वकील की"),
            correctAnswer = "सैनिक (फौजी) की"
        ),
        QuestionModel(
            id = "std7_hindi_u4_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 4,
            questionText = "बालक हाथों में क्या लेकर सरहद पर जाना चाहता है?",
            options = listOf("किताब", "बंदूक", "तिरंगा", "कलम"),
            correctAnswer = "बंदूक"
        ),
        QuestionModel(
            id = "std7_hindi_u4_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 4,
            questionText = "बालक देश की रक्षा करके क्या कमाना चाहता है?",
            options = listOf("धन", "नाम और यश", "आराम", "पुरस्कार"),
            correctAnswer = "नाम और यश"
        ),
        QuestionModel(
            id = "std7_hindi_u4_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 4,
            questionText = "‘सैनिक’ शब्द का मुख्य कार्य क्या है?",
            options = listOf("देश की रक्षा करना", "व्यापार करना", "खेती करना", "गाना गाना"),
            correctAnswer = "देश की रक्षा करना"
        ),
        QuestionModel(
            id = "std7_hindi_u4_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 4,
            questionText = "‘वीर’ शब्द का विलोम (विरुद्धार्थक) शब्द क्या है?",
            options = listOf("कायर", "साहसी", "बलवान", "योद्धा"),
            correctAnswer = "कायर"
        ),

        // ==================== पाठ 5: जिसकी मेहनत उसकी जीत ====================
        QuestionModel(
            id = "std7_hindi_u5_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 5,
            questionText = "दीवार पर चढ़ते समय बार-बार कौन फिसलती है?",
            options = listOf("तितली", "नन्हीं चींटी", "मधुमक्खी", "मकड़ी"),
            correctAnswer = "नन्हीं चींटी"
        ),
        QuestionModel(
            id = "std7_hindi_u5_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 5,
            questionText = "चींटी दाना लेकर कहाँ चढ़ती है?",
            options = listOf("पेड़ पर", "सौ बार दीवारों पर", "छत पर", "पहाड़ पर"),
            correctAnswer = "सौ बार दीवारों पर"
        ),
        QuestionModel(
            id = "std7_hindi_u5_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 5,
            questionText = "कोशिश करने वालों की कभी क्या नहीं होती?",
            options = listOf("हार", "जीत", "तारीफ", "खुशी"),
            correctAnswer = "हार"
        ),
        QuestionModel(
            id = "std7_hindi_u5_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 5,
            questionText = "गोताखोर सिंधु (समुद्र) में डुबकियाँ लगाकर क्या ढूंढता है?",
            options = listOf("मछली", "मोती", "शंख", "पत्थर"),
            correctAnswer = "मोती"
        ),
        QuestionModel(
            id = "std7_hindi_u5_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 5,
            questionText = "‘जीत’ शब्द का विलोम शब्द क्या है?",
            options = listOf("हार", "सफलता", "विजय", "प्रयास"),
            correctAnswer = "हार"
        ),

        // ==================== पाठ 6: हमारे राष्ट्रीय प्रतीक ====================
        QuestionModel(
            id = "std7_hindi_u6_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 6,
            questionText = "भारत का राष्ट्रीय पक्षी कौन-सा है?",
            options = listOf("तोता", "मोर", "कबूतर", "हंस"),
            correctAnswer = "मोर"
        ),
        QuestionModel(
            id = "std7_hindi_u6_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 6,
            questionText = "भारत का राष्ट्रीय पशु कौन-सा है?",
            options = listOf("शेर", "बाघ (Tiger)", "हाथी", "चीता"),
            correctAnswer = "बाघ (Tiger)"
        ),
        QuestionModel(
            id = "std7_hindi_u6_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 6,
            questionText = "हमारे राष्ट्रीय ध्वज तिरंगे में कितने रंग हैं?",
            options = listOf("दो", "तीन", "चार", "पाँच"),
            correctAnswer = "तीन"
        ),
        QuestionModel(
            id = "std7_hindi_u6_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 6,
            questionText = "तिरंगे के बीच में स्थित अशोक चक्र में कितनी तीलियाँ (Spokes) हैं?",
            options = listOf("20", "22", "24", "26"),
            correctAnswer = "24"
        ),
        QuestionModel(
            id = "std7_hindi_u6_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 6,
            questionText = "हमारा राष्ट्रीय गान ‘जन गण मन’ किसके द्वारा लिखा गया है?",
            options = listOf("बंकिमचंद्र चटर्जी", "रवींद्रनाथ टैगोर", "महात्मा गाँधी", "सरोजिनी नायडू"),
            correctAnswer = "रवींद्रनाथ टैगोर"
        ),

        // ==================== पाठ 7: रसोईघर ====================
        QuestionModel(
            id = "std7_hindi_u7_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 7,
            questionText = "सब्जी और फल काटने के लिए किसका उपयोग किया जाता है?",
            options = listOf("चम्मच", "चाकू", "बेलन", "कड़ाही"),
            correctAnswer = "चाकू"
        ),
        QuestionModel(
            id = "std7_hindi_u7_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 7,
            questionText = "रोटी बेलने के लिए चकला के साथ किस साधन का उपयोग होता है?",
            options = listOf("थाली", "बेलन", "चिमटा", "कटोरी"),
            correctAnswer = "बेलन"
        ),
        QuestionModel(
            id = "std7_hindi_u7_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 7,
            questionText = "गर्म रोटी या तवा पकड़ने के लिए किस औज़ार का प्रयोग करते हैं?",
            options = listOf("चिमटा", "छलनी", "गिलास", "चाकू"),
            correctAnswer = "चिमटा"
        ),
        QuestionModel(
            id = "std7_hindi_u7_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 7,
            questionText = "‘रसोईघर’ का अर्थ क्या है?",
            options = listOf("भोजन पकाने का कमरा (Kitchen)", "सोने का कमरा", "पढ़ने का कमरा", "स्नानघर"),
            correctAnswer = "भोजन पकाने का कमरा (Kitchen)"
        ),
        QuestionModel(
            id = "std7_hindi_u7_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 7,
            questionText = "आटा छानने के लिए किसका उपयोग किया जाता है?",
            options = listOf("छलनी", "थाली", "कड़छी", "गिलास"),
            correctAnswer = "छलनी"
        ),

        // ==================== पाठ 8: गिनती (50–70) ====================
        QuestionModel(
            id = "std7_hindi_u8_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 8,
            questionText = "संख्या ‘55’ को हिन्दी शब्दों में क्या कहते हैं?",
            options = listOf("पचास", "पचपन", "पैंसठ", "पचहत्तर"),
            correctAnswer = "पचपन"
        ),
        QuestionModel(
            id = "std7_hindi_u8_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 8,
            questionText = "संख्या ‘60’ को हिन्दी में क्या कहा जाता है?",
            options = listOf("सत्तावन", "साठ", "सत्तर", "इकसठ"),
            correctAnswer = "साठ"
        ),
        QuestionModel(
            id = "std7_hindi_u8_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 8,
            questionText = "हिन्दी शब्द ‘बांसठ’ किस संख्या का रूप है?",
            options = listOf("52", "62", "72", "64"),
            correctAnswer = "62"
        ),
        QuestionModel(
            id = "std7_hindi_u8_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 8,
            questionText = "संख्या ‘70’ को हिन्दी में क्या कहते हैं?",
            options = listOf("साठ", "सत्तर", "अस्सी", "उनासी"),
            correctAnswer = "सत्तर"
        ),
        QuestionModel(
            id = "std7_hindi_u8_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 8,
            questionText = "संख्या 59 (Fifty-Nine) का सही हिन्दी नाम क्या है?",
            options = listOf("उनसठ", "उनहत्तर", "उनचास", "उनतालीस"),
            correctAnswer = "उनसठ"
        ),

        // ==================== पाठ 9: दिल्ली ====================
        QuestionModel(
            id = "std7_hindi_u9_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 9,
            questionText = "भारत की राजधानी का नाम क्या है?",
            options = listOf("मुंबई", "दिल्ली", "कोलकाता", "बेंगलुरु"),
            correctAnswer = "दिल्ली"
        ),
        QuestionModel(
            id = "std7_hindi_u9_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 9,
            questionText = "दिल्ली किस पवित्र नदी के तट पर बसी है?",
            options = listOf("गंगा", "यमुना", "गोदावरी", "कावेरी"),
            correctAnswer = "यमुना"
        ),
        QuestionModel(
            id = "std7_hindi_u9_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 9,
            questionText = "स्वतंत्रता दिवस पर प्रधानमंत्री किस ऐतिहासिक स्थल पर तिरंगा फहराते हैं?",
            options = listOf("इंडिया गेट", "लाल किला", "कुतुब मीनार", "संसद भवन"),
            correctAnswer = "लाल किला"
        ),
        QuestionModel(
            id = "std7_hindi_u9_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 9,
            questionText = "दिल्ली में स्थित ईंटों से बनी विश्व की सबसे ऊँची मीनार कौन-सी है?",
            options = listOf("कुतुब मीनार", "चारमीनार", "झूलता मीनार", "विजय स्तंभ"),
            correctAnswer = "कुतुब मीनार"
        ),
        QuestionModel(
            id = "std7_hindi_u9_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 9,
            questionText = "महात्मा गाँधी जी की समाधि स्थल का नाम क्या है?",
            options = listOf("विजय घाट", "राजघाट", "शांति वन", "शक्ति स्थल"),
            correctAnswer = "राजघाट"
        ),

        // ==================== पाठ 10: मेरी अभिलाषा है ====================
        QuestionModel(
            id = "std7_hindi_u10_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 10,
            questionText = "बालक किसकी तरह चमकना चाहता है?",
            options = listOf("सूरज सा", "चाँद सा", "तारों सा", "दीपक सा"),
            correctAnswer = "सूरज सा"
        ),
        QuestionModel(
            id = "std7_hindi_u10_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 10,
            questionText = "बालक किसकी तरह शीतलता देना चाहता है?",
            options = listOf("चंदा सा", "हवा सा", "जल सा", "फूल सा"),
            correctAnswer = "चंदा सा"
        ),
        QuestionModel(
            id = "std7_hindi_u10_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 10,
            questionText = "बालक फूलों की तरह क्या करना चाहता है?",
            options = listOf("महकना", "हँसना", "रोना", "दौड़ना"),
            correctAnswer = "महकना"
        ),
        QuestionModel(
            id = "std7_hindi_u10_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 10,
            questionText = "‘अभिलाषा’ शब्द का अर्थ क्या है?",
            options = listOf("इच्छा (कामना)", "निराशा", "क्रोध", "आलस्य"),
            correctAnswer = "इच्छा (कामना)"
        ),
        QuestionModel(
            id = "std7_hindi_u10_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 10,
            questionText = "‘पक्षी’ की तरह बालक क्या करना चाहता है?",
            options = listOf("चहकना और कूजना", "तैरना", "दौड़ना", "बैठना"),
            correctAnswer = "चहकना और कूजना"
        ),

        // ==================== पाठ 11: समझदार राजू ====================
        QuestionModel(
            id = "std7_hindi_u11_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 11,
            questionText = "राजू ने रेलवे पटरी पर क्या देखा था?",
            options = listOf("टूटी हुई पटरी", "गाय", "पेड़", "पत्थर"),
            correctAnswer = "टूटी हुई पटरी"
        ),
        QuestionModel(
            id = "std7_hindi_u11_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 11,
            questionText = "सामने से आती रेलगाड़ी को रोकने के लिए राजू ने क्या किया?",
            options = listOf("अपनी लाल कमीज़ लहराई", "सीटी बजाई", "पत्थर फेंका", "भाग गया"),
            correctAnswer = "अपनी लाल कमीज़ लहराई"
        ),
        QuestionModel(
            id = "std7_hindi_u11_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 11,
            questionText = "राजू की समझदारी और साहस से क्या टल गया?",
            options = listOf("बड़ा रेल हादसा (दुर्घटना)", "वर्षा", "तूफान", "चोरी"),
            correctAnswer = "बड़ा रेल हादसा (दुर्घटना)"
        ),
        QuestionModel(
            id = "std7_hindi_u11_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 11,
            questionText = "रेलगाड़ी के ड्राइवर ने लाल कपड़ा देखकर क्या किया?",
            options = listOf("गाड़ी की गति बढ़ा दी", "इमरजेंसी ब्रेक लगाकर गाड़ी रोक दी", "हॉर्न बजाया", "गाड़ी मोड़ दी"),
            correctAnswer = "इमरजेंसी ब्रेक लगाकर गाड़ी रोक दी"
        ),
        QuestionModel(
            id = "std7_hindi_u11_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 11,
            questionText = "साहस और समझदारी के लिए राजू को किससे सम्मानित किया गया?",
            options = listOf("वीरता पुरस्कार से", "डाँट से", "सज़ा से", "खिलौने से"),
            correctAnswer = "वीरता पुरस्कार से"
        ),

        // ==================== पाठ 12: मित्र के नाम पत्र ====================
        QuestionModel(
            id = "std7_hindi_u12_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 12,
            questionText = "पत्र लिखते समय मित्र के लिए कौन-सा संबोधन उपयुक्त है?",
            options = listOf("आदरणीय", "प्रिय मित्र", "पूज्य", "महोदय"),
            correctAnswer = "प्रिय मित्र"
        ),
        QuestionModel(
            id = "std7_hindi_u12_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 12,
            questionText = "पत्र के अंत में मित्र के लिए क्या लिखा जाता है?",
            options = listOf("तुम्हारा मित्र", "आपका आज्ञाकारी", "भवदीय", "प्रार्थी"),
            correctAnswer = "तुम्हारा मित्र"
        ),
        QuestionModel(
            id = "std7_hindi_u12_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 12,
            questionText = "पत्र में मित्र ने अपने शहर के किस दर्शनीय स्थल का वर्णन किया था?",
            options = listOf("मैसूर पैलेस और चिड़ियाघर", "हवा महल", "ताजमहल", "स्वर्ण मंदिर"),
            correctAnswer = "मैसूर पैलेस और चिड़ियाघर"
        ),
        QuestionModel(
            id = "std7_hindi_u12_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 12,
            questionText = "पत्र के लिफाफे पर किसका पता लिखा जाता है?",
            options = listOf("पत्र पाने वाले का", "पत्र लिखने वाले का", "डाकिए का", "अध्यापक का"),
            correctAnswer = "पत्र पाने वाले का"
        ),
        QuestionModel(
            id = "std7_hindi_u12_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 12,
            questionText = "‘पत्र’ शब्द का एक और समानार्थी शब्द क्या है?",
            options = listOf("चिट्ठी (खत)", "पुस्तक", "अखबार", "पत्रिका"),
            correctAnswer = "चिट्ठी (खत)"
        ),

        // ==================== पाठ 13: बसंत ====================
        QuestionModel(
            id = "std7_hindi_u13_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 13,
            questionText = "ऋतुओं का राजा (ऋतुराज) किसे कहा जाता है?",
            options = listOf("वर्षा ऋतु", "बसंत ऋतु", "ग्रीष्म ऋतु", "शरद ऋतु"),
            correctAnswer = "बसंत ऋतु"
        ),
        QuestionModel(
            id = "std7_hindi_u13_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 13,
            questionText = "बसंत ऋतु में बाग-बगीचों में क्या खिलते हैं?",
            options = listOf("रंग-बिरंगे फूल", "सूखे पत्ते", "कांटे", "बर्फ"),
            correctAnswer = "रंग-बिरंगे फूल"
        ),
        QuestionModel(
            id = "std7_hindi_u13_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 13,
            questionText = "बसंत ऋतु में कौन-सा पक्षी मधुर स्वर में कूकता है?",
            options = listOf("कौआ", "कोयल", "बगुला", "चील"),
            correctAnswer = "कोयल"
        ),
        QuestionModel(
            id = "std7_hindi_u13_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 13,
            questionText = "बसंत ऋतु में हवा कैसी चलती है?",
            options = listOf("मंद और सुगंधित (सुहावनी)", "बहुत बर्फीली", "तेज आंधी जैसी", "गर्म लू जैसी"),
            correctAnswer = "मंद और सुगंधित (सुहावनी)"
        ),
        QuestionModel(
            id = "std7_hindi_u13_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 13,
            questionText = "खेतों में किस पौधे के पीले फूल लहराते हैं?",
            options = listOf("सरसों के", "गेंदे के", "गुलाब के", "कमल के"),
            correctAnswer = "सरसों के"
        ),

        // ==================== पाठ 14: सूझ-बूझ ====================
        QuestionModel(
            id = "std7_hindi_u14_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 14,
            questionText = "अकबर के दरबार में अपनी बुद्धि और सूझ-बूझ के लिए कौन प्रसिद्ध थे?",
            options = listOf("बीरबल", "तानसेन", "टोडरमल", "मानसिंह"),
            correctAnswer = "बीरबल"
        ),
        QuestionModel(
            id = "std7_hindi_u14_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 14,
            questionText = "बादशाह अकबर ने खींची गई लकीर को बिना छुए क्या करने को कहा?",
            options = listOf("मिटाने को", "छोटा करने को", "लाल रंगने को", "मोड़ने को"),
            correctAnswer = "छोटा करने को"
        ),
        QuestionModel(
            id = "std7_hindi_u14_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 14,
            questionText = "बीरबल ने अकबर की लकीर को छोटा करने के लिए क्या युक्ति की?",
            options = listOf("उसके नीचे एक बड़ी लकीर खींच दी", "उसे कपड़े से पोंछ दिया", "तोड़ दिया", "पानी डाल दिया"),
            correctAnswer = "उसके नीचे एक बड़ी लकीर खींच दी"
        ),
        QuestionModel(
            id = "std7_hindi_u14_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 14,
            questionText = "कठिन से कठिन समस्या का समाधान किससे निकाला जा सकता है?",
            options = listOf("सूझ-बूझ और धैर्य से", "गुस्से से", "झगड़े से", "रोना-धोना करने से"),
            correctAnswer = "सूझ-बूझ और धैर्य से"
        ),
        QuestionModel(
            id = "std7_hindi_u14_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 14,
            questionText = "बीरबल की बुद्धिमानी देखकर बादशाह अकबर ने क्या किया?",
            options = listOf("सराहना और पुरस्कार दिया", "नाराज हुए", "सजा दी", "दरबार से निकाल दिया"),
            correctAnswer = "सराहना और पुरस्कार दिया"
        ),

        // ==================== पाठ 15: अनमोल वचन ====================
        QuestionModel(
            id = "std7_hindi_u15_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 15,
            questionText = "कबीरदास जी के अनुसार काल का काम कब करना चाहिए?",
            options = listOf("आज", "परसों", "कभी नहीं", "अगले महीने"),
            correctAnswer = "आज"
        ),
        QuestionModel(
            id = "std7_hindi_u15_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 15,
            questionText = "‘ऐसी बानी बोलिए, मन का आपा खोइ’ में किसका महत्व बताया गया है?",
            options = listOf("मीठी और विनम्र वाणी का", "कठोर बात का", "चुप रहने का", "चीखने का"),
            correctAnswer = "मीठी और विनम्र वाणी का"
        ),
        QuestionModel(
            id = "std7_hindi_u15_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 15,
            questionText = "रहीम के अनुसार जो विपत्ति में काम आता है वही सच्चा क्या होता है?",
            options = listOf("मित्र", "शत्रु", "पड़ोसी", "रिश्तेदार"),
            correctAnswer = "मित्र"
        ),
        QuestionModel(
            id = "std7_hindi_u15_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 15,
            questionText = "‘धीरे-धीरे रे मना, धीरे सब कुछ होय। माली सींचे सौ घड़ा, ______ आए फल होय।’",
            options = listOf("ऋतु", "मौसम", "दिन", "रात"),
            correctAnswer = "ऋतु"
        ),
        QuestionModel(
            id = "std7_hindi_u15_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 15,
            questionText = "‘काल करे सो आज कर, आज करे सो अब। पल में ______ होएगी, बहुरि करेगा कब?’",
            options = listOf("परलय", "सुबह", "शाम", "दोपहर"),
            correctAnswer = "परलय"
        ),

        // ==================== पाठ 16: कर्नाटक ====================
        QuestionModel(
            id = "std7_hindi_u16_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 16,
            questionText = "कर्नाटक की राजधानी कौन-सा नगर है?",
            options = listOf("मैसूर", "बेंगलुरु", "हुबली", "मंगलोर"),
            correctAnswer = "बेंगलुरु"
        ),
        QuestionModel(
            id = "std7_hindi_u16_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 16,
            questionText = "कर्नाटक में बोली जाने वाली प्रमुख राजभाषा कौन-सी है?",
            options = listOf("तमिल", "कन्नड़", "तेलुगु", "मराठी"),
            correctAnswer = "ಕನ್ನಡ (Kannada)"
        ),
        QuestionModel(
            id = "std7_hindi_u16_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 16,
            questionText = "कर्नाटक की जीवनरेखा मानी जाने वाली प्रमुख दक्षिण नदी कौन-सी है?",
            options = listOf("कावेरी", "गंगा", "नर्मदा", "सिंधु"),
            correctAnswer = "कावेरी"
        ),
        QuestionModel(
            id = "std7_hindi_u16_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 16,
            questionText = "बेंगलुरु को भारत की किस नगरी के नाम से जाना जाता है?",
            options = listOf("सिलिकॉन सिटी (IT Capital) और उद्यान नगरी", "गुलाबी नगरी", "इस्पात नगरी", "नवाबों की नगरी"),
            correctAnswer = "सिलिकॉन सिटी (IT Capital) और उद्यान नगरी"
        ),
        QuestionModel(
            id = "std7_hindi_u16_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 16,
            questionText = "कर्नाटक का विश्वप्रसिद्ध भव्य जलप्रपात कौन-सा है?",
            options = listOf("जोग जलप्रपात (Jog Falls)", "धुआंधार", "हुंडरू", "चित्रकूट"),
            correctAnswer = "जोग जलप्रपात (Jog Falls)"
        ),

        // ==================== पाठ 17: बाल दिवस ====================
        QuestionModel(
            id = "std7_hindi_u17_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 17,
            questionText = "भारत में बाल दिवस प्रतिवर्ष किस तिथि को मनाया जाता है?",
            options = listOf("14 नवंबर", "2 अक्टूबर", "5 सितंबर", "26 जनवरी"),
            correctAnswer = "14 नवंबर"
        ),
        QuestionModel(
            id = "std7_hindi_u17_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 17,
            questionText = "बाल दिवस किसके जन्मदिवस के उपलक्ष्य में मनाया जाता है?",
            options = listOf("पंडित जवाहरलाल नेहरू", "महात्मा गाँधी", "डॉ. राधाकृष्णन", "सरदार पटेल"),
            correctAnswer = "पंडित जवाहरलाल नेहरू"
        ),
        QuestionModel(
            id = "std7_hindi_u17_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 17,
            questionText = "बच्चे पंडित नेहरू जी को प्यार से क्या बुलाते थे?",
            options = listOf("चाचा नेहरू", "बापू", "नेताजी", "गुरुदेव"),
            correctAnswer = "चाचा नेहरू"
        ),
        QuestionModel(
            id = "std7_hindi_u17_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 17,
            questionText = "पंडित नेहरू जी को कौन-सा फूल सबसे अधिक प्रिय था?",
            options = listOf("लाल गुलाब", "कमल", "सूरजमुखी", "गेंदा"),
            correctAnswer = "लाल गुलाब"
        ),
        QuestionModel(
            id = "std7_hindi_u17_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 17,
            questionText = "पंडित नेहरू भारत के कौन-से प्रधानमंत्री थे?",
            options = listOf("प्रथम (पहले)", "दूसरे", "तीसरे", "चौथे"),
            correctAnswer = "प्रथम (पहले)"
        ),

        // ==================== पाठ 18: व्याकरण और भाषा ज्ञान ====================
        QuestionModel(
            id = "std7_hindi_u18_q1",
            stdId = 7,
            subjectId = "hindi",
            unitId = 18,
            questionText = "किसी व्यक्ति, वस्तु, स्थान या भाव के नाम को क्या कहते हैं?",
            options = listOf("संज्ञा", "सर्वनाम", "विशेषण", "क्रिया"),
            correctAnswer = "संज्ञा"
        ),
        QuestionModel(
            id = "std7_hindi_u18_q2",
            stdId = 7,
            subjectId = "hindi",
            unitId = 18,
            questionText = "‘लड़का’ शब्द का बहुवचन रूप क्या है?",
            options = listOf("लड़के", "लड़कों", "लड़कियाँ", "लड़काई"),
            correctAnswer = "लड़के"
        ),
        QuestionModel(
            id = "std7_hindi_u18_q3",
            stdId = 7,
            subjectId = "hindi",
            unitId = 18,
            questionText = "‘सूर्य’ का पर्यायवाची शब्द कौन-सा है?",
            options = listOf("दिनकर (रवि)", "शशि", "निशा", "वारिद"),
            correctAnswer = "दिनकर (रवि)"
        ),
        QuestionModel(
            id = "std7_hindi_u18_q4",
            stdId = 7,
            subjectId = "hindi",
            unitId = 18,
            questionText = "‘सच’ शब्द का विलोम शब्द क्या है?",
            options = listOf("झूठ", "सही", "सत्य", "धर्म"),
            correctAnswer = "झूठ"
        ),
        QuestionModel(
            id = "std7_hindi_u18_q5",
            stdId = 7,
            subjectId = "hindi",
            unitId = 18,
            questionText = "संज्ञा के स्थान पर प्रयोग किए जाने वाले शब्द क्या कहलाते हैं?",
            options = listOf("सर्वनाम", "विशेषण", "क्रिया", "कारक"),
            correctAnswer = "सर्वनाम"
        ),
        QuestionModel(
            id = "std7_hindi_u18_q6",
            stdId = 7,
            subjectId = "hindi",
            unitId = 18,
            questionText = "‘राधा मधुर गाती है’ वाक्य में ‘मधुर’ शब्द क्या है?",
            options = listOf("क्रियाविशेषण", "संज्ञा", "सर्वनाम", "सर्वनाम"),
            correctAnswer = "क्रियाविशेषण"
        )
    )
}
