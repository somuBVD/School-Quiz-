package com.example.data

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.UUID
import java.util.zip.Inflater
import java.util.zip.ZipInputStream

/**
 * Parsed question item with validation state for teacher preview before importing.
 */
data class ParsedBulkQuestion(
    val entity: QuizQuestionEntity,
    val isValid: Boolean,
    val validationMessage: String = "Valid"
)

/**
 * Intelligent parser for bulk quiz questions uploaded via CSV, TSV, Excel (.xlsx/.xls),
 * PDF (.pdf), or Plain Text.
 * Supports auto-detection of column headers, positional columns, question paper formats,
 * and True/False questions.
 */
object BulkQuestionParser {

    /**
     * Inspects a URI from Android Storage Access Framework (SAF), determines the file type,
     * extracts text or spreadsheet rows, and parses into quiz questions.
     * Returns Pair(questions, summaryDescription).
     */
    fun parseFileUri(
        context: Context,
        uri: Uri,
        stdId: Int,
        subjectId: String,
        unitId: Int,
        unitName: String,
        defaultDifficulty: String = "Medium"
    ): Pair<List<ParsedBulkQuestion>, String> {
        val fileName = getFileName(context, uri).lowercase()
        val mimeType = context.contentResolver.getType(uri)?.lowercase() ?: ""

        val isExcel = fileName.endsWith(".xlsx") ||
                mimeType.contains("openxmlformats-officedocument.spreadsheetml") ||
                mimeType.contains("vnd.ms-excel")
        val isPdf = fileName.endsWith(".pdf") || mimeType.contains("pdf")

        // Read magic bytes to be completely certain about binary types
        val headerBytes = try {
            context.contentResolver.openInputStream(uri)?.use { stream ->
                val buffer = ByteArray(16)
                val read = stream.read(buffer)
                if (read > 0) buffer.copyOf(read) else ByteArray(0)
            } ?: ByteArray(0)
        } catch (_: Exception) {
            ByteArray(0)
        }

        val hasZipMagic = headerBytes.size >= 4 &&
                headerBytes[0] == 0x50.toByte() && headerBytes[1] == 0x4B.toByte() &&
                headerBytes[2] == 0x03.toByte() && headerBytes[3] == 0x04.toByte()
        val hasPdfMagic = headerBytes.size >= 4 &&
                headerBytes[0] == 0x25.toByte() && headerBytes[1] == 0x50.toByte() &&
                headerBytes[2] == 0x44.toByte() && headerBytes[3] == 0x46.toByte()

        return when {
            isExcel || hasZipMagic -> {
                try {
                    val questions = context.contentResolver.openInputStream(uri)?.use { stream ->
                        parseExcelStream(stream, stdId, subjectId, unitId, unitName, defaultDifficulty)
                    } ?: emptyList()
                    val formatName = if (questions.isNotEmpty()) "Excel Spreadsheet (.xlsx)" else "Excel File (0 questions)"
                    questions to formatName
                } catch (e: Exception) {
                    // Fallback to text parsing
                    val text = readStreamAsText(context, uri)
                    val questions = parseAuto(text, stdId, subjectId, unitId, unitName, defaultDifficulty)
                    questions to "Excel / Text Fallback"
                }
            }
            isPdf || hasPdfMagic -> {
                try {
                    val questions = context.contentResolver.openInputStream(uri)?.use { stream ->
                        parsePdfStream(stream, stdId, subjectId, unitId, unitName, defaultDifficulty)
                    } ?: emptyList()
                    questions to "PDF Document (.pdf)"
                } catch (e: Exception) {
                    val text = readStreamAsText(context, uri)
                    val questions = parseAuto(text, stdId, subjectId, unitId, unitName, defaultDifficulty)
                    questions to "PDF / Text Stream"
                }
            }
            else -> {
                val text = readStreamAsText(context, uri)
                val questions = parseAuto(text, stdId, subjectId, unitId, unitName, defaultDifficulty)
                val format = if (text.contains(",") || text.contains("\t")) "CSV / TSV File" else "Text Document"
                questions to format
            }
        }
    }

    private fun readStreamAsText(context: Context, uri: Uri): String {
        return try {
            context.contentResolver.openInputStream(uri)?.bufferedReader(Charsets.UTF_8)?.use { it.readText() } ?: ""
        } catch (_: Exception) {
            ""
        }
    }

    private fun getFileName(context: Context, uri: Uri): String {
        var name = uri.lastPathSegment?.substringAfterLast('/') ?: "document"
        try {
            context.contentResolver.query(uri, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)?.use { cursor ->
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (nameIndex != -1 && cursor.moveToFirst()) {
                    name = cursor.getString(nameIndex) ?: name
                }
            }
        } catch (_: Exception) {
            // Ignore cursor error
        }
        return name
    }

    /**
     * Pure-Kotlin streaming parser for standard Microsoft Excel OpenXML (.xlsx) files.
     * Decodes `xl/sharedStrings.xml` and worksheet cell values without heavy external libraries.
     */
    fun parseExcelStream(
        inputStream: InputStream,
        stdId: Int,
        subjectId: String,
        unitId: Int,
        unitName: String,
        defaultDifficulty: String = "Medium"
    ): List<ParsedBulkQuestion> {
        val zipIn = ZipInputStream(inputStream)
        var entry = zipIn.nextEntry
        val sharedStrings = mutableListOf<String>()
        val sheetBytes = mutableMapOf<String, ByteArray>()

        while (entry != null) {
            val name = entry.name
            if (name == "xl/sharedStrings.xml") {
                val xml = zipIn.bufferedReader(Charsets.UTF_8).readText()
                // Parse shared strings: each <si> item represents a string value
                val siMatcher = Regex("<si>([\\s\\S]*?)</si>").findAll(xml)
                for (si in siMatcher) {
                    val siContent = si.groupValues[1]
                    val tMatches = Regex("<t(?:\\s+[^>]*)?>([\\s\\S]*?)</t>").findAll(siContent)
                    val fullStr = tMatches.joinToString("") { unescapeXml(it.groupValues[1]) }
                    sharedStrings.add(fullStr)
                }
                if (sharedStrings.isEmpty()) {
                    val directT = Regex("<t(?:\\s+[^>]*)?>([\\s\\S]*?)</t>").findAll(xml)
                    for (m in directT) {
                        sharedStrings.add(unescapeXml(m.groupValues[1]))
                    }
                }
            } else if (name.startsWith("xl/worksheets/sheet") && name.endsWith(".xml")) {
                val bytes = zipIn.readBytes()
                sheetBytes[name] = bytes
            }
            zipIn.closeEntry()
            entry = zipIn.nextEntry
        }

        val targetSheetXmlBytes = sheetBytes["xl/worksheets/sheet1.xml"]
            ?: sheetBytes.values.firstOrNull()
            ?: return emptyList()

        val sheetXml = String(targetSheetXmlBytes, Charsets.UTF_8)
        val rowRegex = Regex("<row[^>]*>([\\s\\S]*?)</row>")
        val cellRegex = Regex("<c\\s+r=\"([A-Z]+)(\\d+)\"(?:[^>]*?\\s+t=\"([^\"]*)\")?[^>]*>([\\s\\S]*?)</c>")
        val valRegex = Regex("<v>([\\s\\S]*?)</v>")
        val inlineRegex = Regex("<is>([\\s\\S]*?)</is>")

        val csvLines = mutableListOf<String>()

        for (rowMatch in rowRegex.findAll(sheetXml)) {
            val rowContent = rowMatch.groupValues[1]
            val cellMap = mutableMapOf<Int, String>()

            for (cMatch in cellRegex.findAll(rowContent)) {
                val colLetters = cMatch.groupValues[1]
                val colIdx = colLettersToIndex(colLetters)
                val type = cMatch.groupValues[3]
                val inner = cMatch.groupValues[4]

                val value = when (type) {
                    "s" -> {
                        val idx = valRegex.find(inner)?.groupValues?.get(1)?.toIntOrNull()
                        if (idx != null && idx in sharedStrings.indices) sharedStrings[idx] else ""
                    }
                    "inlineStr" -> {
                        val isText = inlineRegex.find(inner)?.groupValues?.get(1) ?: ""
                        Regex("<t(?:\\s+[^>]*)?>([\\s\\S]*?)</t>").findAll(isText).joinToString("") { unescapeXml(it.groupValues[1]) }
                    }
                    else -> {
                        val rawV = valRegex.find(inner)?.groupValues?.get(1) ?: ""
                        unescapeXml(rawV)
                    }
                }
                cellMap[colIdx] = value
            }

            if (cellMap.isNotEmpty()) {
                val maxCol = (cellMap.keys.maxOrNull() ?: 0).coerceAtLeast(4)
                val rowValues = (0..maxCol).map { col ->
                    val v = cellMap[col] ?: ""
                    "\"${v.replace("\"", "\"\"")}\""
                }
                csvLines.add(rowValues.joinToString(","))
            }
        }

        if (csvLines.isEmpty()) return emptyList()
        val synthesizedCsv = csvLines.joinToString("\n")
        return parseCsvOrTsv(synthesizedCsv, stdId, subjectId, unitId, unitName, defaultDifficulty)
    }

    /**
     * Extracts text from PDF documents using standard FlateDecode stream decompression
     * and text operator token extraction.
     */
    fun parsePdfStream(
        inputStream: InputStream,
        stdId: Int,
        subjectId: String,
        unitId: Int,
        unitName: String,
        defaultDifficulty: String = "Medium"
    ): List<ParsedBulkQuestion> {
        val pdfBytes = inputStream.readBytes()
        val extractedText = extractTextFromPdfBytes(pdfBytes)
        return parseAuto(extractedText, stdId, subjectId, unitId, unitName, defaultDifficulty)
    }

    /**
     * Scans PDF byte content for uncompressed and flate-compressed streams,
     * extracts text tokens and formatting.
     */
    private fun extractTextFromPdfBytes(bytes: ByteArray): String {
        val sb = StringBuilder()
        val textBlocks = mutableListOf<String>()

        // Search for stream ... endstream blocks
        var pos = 0
        while (pos < bytes.size) {
            val streamMarker = findBytes(bytes, "stream".toByteArray(Charsets.US_ASCII), pos)
            if (streamMarker == -1) break

            // Determine if flate decoded
            val headerSearchStart = (streamMarker - 200).coerceAtLeast(0)
            val headerSub = String(bytes, headerSearchStart, streamMarker - headerSearchStart, Charsets.US_ASCII)
            val isFlate = headerSub.contains("/FlateDecode")

            // Stream data begins after stream\r?\n
            var streamStart = streamMarker + 6
            if (streamStart < bytes.size && bytes[streamStart] == '\r'.code.toByte()) streamStart++
            if (streamStart < bytes.size && bytes[streamStart] == '\n'.code.toByte()) streamStart++

            val endStreamMarker = findBytes(bytes, "endstream".toByteArray(Charsets.US_ASCII), streamStart)
            if (endStreamMarker == -1) break

            var streamEnd = endStreamMarker
            if (streamEnd > streamStart && bytes[streamEnd - 1] == '\n'.code.toByte()) streamEnd--
            if (streamEnd > streamStart && bytes[streamEnd - 1] == '\r'.code.toByte()) streamEnd--

            val streamBytes = bytes.copyOfRange(streamStart, streamEnd)

            val decompressedText = if (isFlate) {
                decompressFlate(streamBytes)
            } else {
                String(streamBytes, Charsets.ISO_8859_1)
            }

            if (decompressedText.isNotBlank()) {
                val blockText = extractPdfTextOperators(decompressedText)
                if (blockText.isNotBlank()) {
                    textBlocks.add(blockText)
                }
            }

            pos = endStreamMarker + 9
        }

        if (textBlocks.isNotEmpty()) {
            return textBlocks.joinToString("\n")
        }

        // Fallback: Scan entire PDF for parenthesized text sequences
        val rawPdf = String(bytes, Charsets.ISO_8859_1)
        val directStrings = Regex("\\(([^()]{3,})\\)").findAll(rawPdf)
        for (match in directStrings) {
            val content = unescapePdfString(match.groupValues[1])
            if (content.length > 4) {
                sb.append(content).append("\n")
            }
        }
        return sb.toString()
    }

    private fun decompressFlate(data: ByteArray): String {
        return try {
            val inflater = Inflater(false)
            inflater.setInput(data)
            val buffer = ByteArray(4096)
            val out = java.io.ByteArrayOutputStream()
            while (!inflater.finished()) {
                val count = inflater.inflate(buffer)
                if (count == 0) break
                out.write(buffer, 0, count)
            }
            inflater.end()
            out.toString("UTF-8")
        } catch (_: Exception) {
            try {
                // Try raw deflate (without zlib header)
                val inflater = Inflater(true)
                inflater.setInput(data)
                val buffer = ByteArray(4096)
                val out = java.io.ByteArrayOutputStream()
                while (!inflater.finished()) {
                    val count = inflater.inflate(buffer)
                    if (count == 0) break
                    out.write(buffer, 0, count)
                }
                inflater.end()
                out.toString("UTF-8")
            } catch (_: Exception) {
                ""
            }
        }
    }

    private fun extractPdfTextOperators(content: String): String {
        val result = StringBuilder()
        val lines = content.lines()

        for (line in lines) {
            val trimmed = line.trim()
            // Single string text show: (hello) Tj or (hello) '
            val tjMatch = Regex("\\((.*?)\\)\\s*(?:Tj|')").findAll(trimmed)
            for (m in tjMatch) {
                result.append(unescapePdfString(m.groupValues[1])).append(" ")
            }

            // Array text show: [(Hello) -10 (World)] TJ
            val tjArrayMatch = Regex("\\[(.*?)\\]\\s*TJ").find(trimmed)
            if (tjArrayMatch != null) {
                val inner = tjArrayMatch.groupValues[1]
                val subStrings = Regex("\\((.*?)\\)").findAll(inner)
                for (s in subStrings) {
                    result.append(unescapePdfString(s.groupValues[1]))
                }
                result.append(" ")
            }

            // Line break operators
            if (trimmed == "T*" || trimmed.endsWith(" T*") || trimmed.endsWith(" TD") || trimmed.endsWith(" Td")) {
                result.append("\n")
            }
        }

        return result.toString().trim()
    }

    private fun unescapePdfString(str: String): String {
        return str
            .replace("\\(", "(")
            .replace("\\)", ")")
            .replace("\\\\", "\\")
            .replace("\\r", "\r")
            .replace("\\n", "\n")
            .replace("\\t", "\t")
            .replace("\\b", "\b")
            .replace("\\f", "\u000C")
    }

    private fun findBytes(haystack: ByteArray, needle: ByteArray, startIndex: Int = 0): Int {
        if (needle.isEmpty() || haystack.isEmpty() || startIndex + needle.size > haystack.size) return -1
        for (i in startIndex..(haystack.size - needle.size)) {
            var found = true
            for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) {
                    found = false
                    break
                }
            }
            if (found) return i
        }
        return -1
    }

    private fun colLettersToIndex(letters: String): Int {
        var index = 0
        for (c in letters.uppercase()) {
            if (c in 'A'..'Z') {
                index = index * 26 + (c - 'A' + 1)
            }
        }
        return (index - 1).coerceAtLeast(0)
    }

    private fun unescapeXml(text: String): String {
        return text
            .replace("&amp;", "&")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("&quot;", "\"")
            .replace("&apos;", "'")
    }

    /**
     * Automatically inspects text content and parses questions based on format.
     */
    fun parseAuto(
        content: String,
        stdId: Int,
        subjectId: String,
        unitId: Int,
        unitName: String,
        defaultDifficulty: String = "Medium"
    ): List<ParsedBulkQuestion> {
        val trimmed = content.trim()
        if (trimmed.isEmpty()) return emptyList()

        // Check if content looks like CSV or TSV (contains commas/tabs in early lines)
        val firstFewLines = trimmed.lines().take(5)
        val hasCsvHeaders = firstFewLines.any { line ->
            val lower = line.lowercase()
            lower.contains("question") || lower.contains("option") || lower.contains("answer")
        }
        val hasDelimiter = firstFewLines.any { it.contains(",") || it.contains("\t") || it.contains(";") }

        return if (hasDelimiter && (hasCsvHeaders || firstFewLines.any { splitRow(it).size >= 4 })) {
            parseCsvOrTsv(trimmed, stdId, subjectId, unitId, unitName, defaultDifficulty)
        } else {
            parseTextOrPdfDocument(trimmed, stdId, subjectId, unitId, unitName, defaultDifficulty)
        }
    }

    /**
     * Parses structured CSV, TSV, or Semicolon-delimited spreadsheet rows.
     */
    fun parseCsvOrTsv(
        csvText: String,
        stdId: Int,
        subjectId: String,
        unitId: Int,
        unitName: String,
        defaultDifficulty: String = "Medium"
    ): List<ParsedBulkQuestion> {
        val lines = csvText.lines().map { it.trim() }.filter { it.isNotEmpty() }
        if (lines.isEmpty()) return emptyList()

        val results = mutableListOf<ParsedBulkQuestion>()

        // Check for header row
        val firstRow = splitRow(lines.first())
        val firstRowLower = firstRow.map { it.lowercase().trim() }
        val hasHeader = firstRowLower.any {
            it.contains("question") || it.contains("q_text") || it.contains("prompt")
        }

        var colQuestion = -1
        var colOptA = -1
        var colOptB = -1
        var colOptC = -1
        var colOptD = -1
        var colAnswer = -1
        var colExplanation = -1
        var colDifficulty = -1
        var colType = -1
        var colUnit = -1
        var colSubject = -1

        val dataLines = if (hasHeader) {
            firstRowLower.forEachIndexed { idx, header ->
                when {
                    header.contains("question") || header.contains("prompt") -> colQuestion = idx
                    header.contains("optiona") || header.contains("option_a") || header.contains("opt1") || header == "a" -> colOptA = idx
                    header.contains("optionb") || header.contains("option_b") || header.contains("opt2") || header == "b" -> colOptB = idx
                    header.contains("optionc") || header.contains("option_c") || header.contains("opt3") || header == "c" -> colOptC = idx
                    header.contains("optiond") || header.contains("option_d") || header.contains("opt4") || header == "d" -> colOptD = idx
                    header.contains("answer") || header.contains("correct") || header == "ans" -> colAnswer = idx
                    header.contains("explanation") || header.contains("reason") || header == "exp" -> colExplanation = idx
                    header.contains("difficulty") || header.contains("level") -> colDifficulty = idx
                    header.contains("type") -> colType = idx
                    header.contains("unit") || header.contains("chapter") -> colUnit = idx
                    header.contains("subject") -> colSubject = idx
                }
            }
            lines.drop(1)
        } else {
            lines
        }

        for (line in dataLines) {
            val cols = splitRow(line)
            if (cols.isEmpty() || cols.all { it.isBlank() }) continue

            val qText: String
            val optA: String
            val optB: String
            val optC: String
            val optD: String
            var answer: String
            val explanation: String
            val diff: String
            val qType: String

            if (hasHeader && colQuestion >= 0) {
                qText = cols.getOrElse(colQuestion) { "" }.trim()
                optA = if (colOptA >= 0) cols.getOrElse(colOptA) { "" }.trim() else ""
                optB = if (colOptB >= 0) cols.getOrElse(colOptB) { "" }.trim() else ""
                optC = if (colOptC >= 0) cols.getOrElse(colOptC) { "" }.trim() else ""
                optD = if (colOptD >= 0) cols.getOrElse(colOptD) { "" }.trim() else ""
                answer = if (colAnswer >= 0) cols.getOrElse(colAnswer) { "" }.trim() else ""
                explanation = if (colExplanation >= 0) cols.getOrElse(colExplanation) { "" }.trim() else ""
                diff = if (colDifficulty >= 0) cols.getOrElse(colDifficulty) { defaultDifficulty }.trim().ifBlank { defaultDifficulty } else defaultDifficulty
                qType = if (colType >= 0) cols.getOrElse(colType) { "MCQ" }.trim().ifBlank { "MCQ" } else "MCQ"
            } else {
                // Positional mapping:
                // 0: Question, 1: OptA, 2: OptB, 3: OptC, 4: OptD, 5: Answer, 6: Explanation, 7: Difficulty, 8: Type
                qText = cols.getOrElse(0) { "" }.trim()
                optA = cols.getOrElse(1) { "" }.trim()
                optB = cols.getOrElse(2) { "" }.trim()
                optC = cols.getOrElse(3) { "" }.trim()
                optD = cols.getOrElse(4) { "" }.trim()
                answer = cols.getOrElse(5) { "" }.trim()
                explanation = cols.getOrElse(6) { "" }.trim()
                diff = cols.getOrElse(7) { defaultDifficulty }.trim().ifBlank { defaultDifficulty }
                qType = cols.getOrElse(8) { "MCQ" }.trim().ifBlank { "MCQ" }
            }

            if (qText.isBlank()) continue

            // Determine options list and match answer
            val optionsList = mutableListOf<String>()
            if (optA.isNotBlank()) optionsList.add(optA)
            if (optB.isNotBlank()) optionsList.add(optB)
            if (optC.isNotBlank()) optionsList.add(optC)
            if (optD.isNotBlank()) optionsList.add(optD)

            // Resolve letter answer e.g. "A" -> optA, "B" -> optB
            val resolvedAnswer = when (answer.uppercase().trim()) {
                "A", "1" -> optA.ifBlank { answer }
                "B", "2" -> optB.ifBlank { answer }
                "C", "3" -> optC.ifBlank { answer }
                "D", "4" -> optD.ifBlank { answer }
                else -> answer
            }

            val finalType = if (qType.equals("TF", ignoreCase = true) || (optionsList.size == 2 && optionsList.any { it.equals("True", true) })) {
                "TF"
            } else {
                "MCQ"
            }

            val finalOptions = if (finalType == "TF" && optionsList.isEmpty()) {
                "True|False"
            } else {
                optionsList.joinToString("|")
            }

            // Validation checks
            val isValid: Boolean
            val validationMessage: String
            when {
                qText.length < 5 -> {
                    isValid = false
                    validationMessage = "Question text too short"
                }
                finalType == "MCQ" && optionsList.size < 2 -> {
                    isValid = false
                    validationMessage = "Requires at least 2 options"
                }
                resolvedAnswer.isBlank() -> {
                    isValid = false
                    validationMessage = "Missing correct answer"
                }
                finalType == "MCQ" && optionsList.none { it.equals(resolvedAnswer, ignoreCase = true) } -> {
                    isValid = true
                    validationMessage = "Answer custom match"
                }
                else -> {
                    isValid = true
                    validationMessage = "Valid"
                }
            }

            val entity = QuizQuestionEntity(
                id = UUID.randomUUID().toString(),
                stdId = stdId,
                subjectId = subjectId,
                unitId = unitId,
                unitName = unitName.ifBlank { "Unit $unitId" },
                type = finalType,
                questionText = qText,
                optionsString = finalOptions,
                correctAnswer = resolvedAnswer,
                explanation = explanation.ifBlank { "Explanation: Correct answer is $resolvedAnswer." },
                difficulty = diff.replaceFirstChar { it.uppercase() },
                points = 10,
                isCustom = true,
                createdAt = System.currentTimeMillis()
            )

            results.add(ParsedBulkQuestion(entity, isValid, validationMessage))
        }

        return results
    }

    /**
     * Parses standard question paper or text/PDF format:
     * 1. Question text
     * A) ...
     * B) ...
     * C) ...
     * D) ...
     * Answer: B
     * Explanation: ...
     */
    fun parseTextOrPdfDocument(
        text: String,
        stdId: Int,
        subjectId: String,
        unitId: Int,
        unitName: String,
        defaultDifficulty: String = "Medium"
    ): List<ParsedBulkQuestion> {
        val lines = text.lines().map { it.trim() }
        val results = mutableListOf<ParsedBulkQuestion>()

        var currentQuestion = ""
        val currentOptions = mutableListOf<String>()
        var currentAnswer = ""
        var currentExplanation = ""
        var currentType = "MCQ"

        fun flushCurrentQuestion() {
            if (currentQuestion.isBlank()) return

            val cleanQ = currentQuestion.replace(Regex("^(Q\\.?\\s*\\d*\\.?|\\d+\\.)\\s*", RegexOption.IGNORE_CASE), "").trim()
            if (cleanQ.isBlank()) return

            // Map letter answer
            var resolvedAnswer = currentAnswer
            val optLetter = currentAnswer.uppercase().trim().removePrefix("OPTION").trim().removePrefix(":").trim()
            if (optLetter == "A" && currentOptions.isNotEmpty()) resolvedAnswer = currentOptions[0]
            else if (optLetter == "B" && currentOptions.size > 1) resolvedAnswer = currentOptions[1]
            else if (optLetter == "C" && currentOptions.size > 2) resolvedAnswer = currentOptions[2]
            else if (optLetter == "D" && currentOptions.size > 3) resolvedAnswer = currentOptions[3]

            val finalType = if (currentOptions.size == 2 && currentOptions.any { it.equals("True", true) }) "TF" else currentType
            val optionsStr = if (finalType == "TF" && currentOptions.isEmpty()) "True|False" else currentOptions.joinToString("|")

            val isValid = cleanQ.length >= 5 && resolvedAnswer.isNotBlank() && (finalType == "TF" || currentOptions.size >= 2)
            val validationMsg = when {
                cleanQ.length < 5 -> "Question too short"
                resolvedAnswer.isBlank() -> "No correct answer detected"
                finalType == "MCQ" && currentOptions.size < 2 -> "Fewer than 2 options"
                else -> "Valid"
            }

            val entity = QuizQuestionEntity(
                id = UUID.randomUUID().toString(),
                stdId = stdId,
                subjectId = subjectId,
                unitId = unitId,
                unitName = unitName.ifBlank { "Unit $unitId" },
                type = finalType,
                questionText = cleanQ,
                optionsString = optionsStr,
                correctAnswer = resolvedAnswer,
                explanation = currentExplanation.ifBlank { "Explanation: The correct answer is $resolvedAnswer." },
                difficulty = defaultDifficulty,
                points = 10,
                isCustom = true,
                createdAt = System.currentTimeMillis()
            )

            results.add(ParsedBulkQuestion(entity, isValid, validationMsg))

            currentQuestion = ""
            currentOptions.clear()
            currentAnswer = ""
            currentExplanation = ""
            currentType = "MCQ"
        }

        for (line in lines) {
            if (line.isBlank()) continue

            // Detect Question start e.g. "1.", "Q1:", "Question 1:"
            val isQuestionStart = line.matches(Regex("^(Q\\.?\\s*\\d*|\\d+|Question\\s+\\d+)[:.)\\s].*", RegexOption.IGNORE_CASE))
            if (isQuestionStart) {
                flushCurrentQuestion()
                currentQuestion = line
                continue
            }

            // Detect Option e.g. "A)", "A.", "(A)", "[A]", "a)"
            val optionMatch = Regex("^[\\[(]?([A-Da-d1-4])[\\]).:]\\s*(.+)$").find(line)
            if (optionMatch != null) {
                val optText = optionMatch.groupValues[2].trim()
                if (optText.isNotBlank()) {
                    currentOptions.add(optText)
                }
                continue
            }

            // Detect Answer e.g. "Answer: B", "Ans: B", "Correct: A"
            val answerMatch = Regex("^(Answer|Ans|Correct\\s*Answer|Correct)[:\\s]+(.+)$", RegexOption.IGNORE_CASE).find(line)
            if (answerMatch != null) {
                currentAnswer = answerMatch.groupValues[2].trim()
                continue
            }

            // Detect Explanation e.g. "Explanation: ..."
            val expMatch = Regex("^(Explanation|Reason|Exp)[:\\s]+(.+)$", RegexOption.IGNORE_CASE).find(line)
            if (expMatch != null) {
                currentExplanation = expMatch.groupValues[2].trim()
                continue
            }

            // If question has started and no options yet, append to question text
            if (currentQuestion.isNotBlank() && currentOptions.isEmpty()) {
                currentQuestion += " $line"
            }
        }

        flushCurrentQuestion()
        return results
    }

    /**
     * Splits a CSV/TSV row respecting quotes.
     */
    private fun splitRow(row: String): List<String> {
        val delimiter = when {
            row.contains("\t") -> '\t'
            row.contains(";") -> ';'
            else -> ','
        }

        val result = mutableListOf<String>()
        var inQuotes = false
        val current = StringBuilder()

        var i = 0
        while (i < row.length) {
            val c = row[i]
            when {
                c == '\"' -> {
                    inQuotes = !inQuotes
                }
                c == delimiter && !inQuotes -> {
                    result.add(current.toString().trim().removeSurrounding("\""))
                    current.setLength(0)
                }
                else -> {
                    current.append(c)
                }
            }
            i++
        }
        result.add(current.toString().trim().removeSurrounding("\""))
        return result
    }

    /**
     * Exports a list of question entities to a standard CSV string with headers.
     */
    fun exportQuestionsToCsv(questions: List<QuizQuestionEntity>): String {
        val sb = StringBuilder()
        sb.append("question,optionA,optionB,optionC,optionD,correctAnswer,explanation,difficulty,type,unitName\n")
        for (q in questions) {
            val opts = q.optionsString.split('|')
            val optA = opts.getOrElse(0) { "" }
            val optB = opts.getOrElse(1) { "" }
            val optC = opts.getOrElse(2) { "" }
            val optD = opts.getOrElse(3) { "" }

            fun escapeCsv(s: String): String = "\"${s.replace("\"", "\"\"")}\""

            sb.append("${escapeCsv(q.questionText)},")
            sb.append("${escapeCsv(optA)},")
            sb.append("${escapeCsv(optB)},")
            sb.append("${escapeCsv(optC)},")
            sb.append("${escapeCsv(optD)},")
            sb.append("${escapeCsv(q.correctAnswer)},")
            sb.append("${escapeCsv(q.explanation)},")
            sb.append("${escapeCsv(q.difficulty)},")
            sb.append("${escapeCsv(q.type)},")
            sb.append("${escapeCsv(q.unitName)}\n")
        }
        return sb.toString()
    }

    /**
     * Pre-formatted CSV sample template with headers for teachers.
     */
    val SAMPLE_CSV_TEMPLATE = """
question,optionA,optionB,optionC,optionD,correctAnswer,explanation,difficulty,type
"What is the chemical symbol for Gold?","Au","Ag","Fe","Cu","Au","Au is derived from the Latin word Aurum.","Easy","MCQ"
"Which organelle is known as the powerhouse of the cell?","Mitochondria","Ribosome","Nucleus","Chloroplast","Mitochondria","Mitochondria generate ATP energy for cellular processes.","Medium","MCQ"
"Light travels faster in water than in air.","True","False","","","False","Light travels fastest in a vacuum and slower in denser media like water.","Medium","TF"
"What is the solution to 3x + 15 = 45?","5","10","15","20","10","Subtracting 15 yields 3x = 30, so x = 10.","Easy","MCQ"
"Which layer of the atmosphere contains the ozone layer?","Stratosphere","Troposphere","Mesosphere","Thermosphere","Stratosphere","The stratosphere houses the ozone layer absorbing UV rays.","Hard","MCQ"
""".trimIndent()

    /**
     * Pre-formatted Question Paper text template for teachers.
     */
    val SAMPLE_PDF_TEXT_TEMPLATE = """
1. What is the value of Pi (π) rounded to two decimal places?
A) 3.12
B) 3.14
C) 3.16
D) 3.18
Answer: B
Explanation: Pi is approximately 3.14159, which rounds to 3.14.

2. Photosynthesis primarily takes place in which part of the plant cell?
A) Chloroplast
B) Mitochondria
C) Cell Wall
D) Vacuole
Answer: A
Explanation: Chloroplasts contain chlorophyll which absorbs solar energy for photosynthesis.

3. Sound waves can travel through a vacuum.
A) True
B) False
Answer: B
Explanation: Sound requires a physical medium (gas, liquid, or solid) to propagate.

4. What is the capital city of Karnataka?
A) Mysuru
B) Mangaluru
C) Bengaluru
D) Hubballi
Answer: C
Explanation: Bengaluru is the state capital and technology hub of Karnataka.

5. Which gas is most abundant in the Earth's atmosphere?
A) Oxygen
B) Nitrogen
C) Carbon Dioxide
D) Argon
Answer: B
Explanation: Nitrogen makes up approximately 78% of the Earth's atmosphere.
""".trimIndent()
}
