package com.example.ui.dashboard

import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ClipboardManager
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color as AndroidColor
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RadialGradient
import android.graphics.RectF
import android.graphics.Shader
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import com.example.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import kotlin.math.cos
import kotlin.math.sin

enum class SocialSharePlatform(
    val packageName: String?,
    val displayName: String
) {
    SYSTEM_SHEET(null, "Share"),
    WHATSAPP("com.whatsapp", "WhatsApp"),
    INSTAGRAM("com.instagram.android", "Instagram"),
    X_TWITTER("com.twitter.android", "X"),
    TELEGRAM("org.telegram.messenger", "Telegram")
}

/**
 * Renders the Certificate of Excellence into a high-resolution PNG image
 * and shares it directly to social media platforms or saves it to the device gallery
 * without requiring legacy storage permissions.
 */
object CertificateShareHelper {

    private const val TAG = "CertificateShareHelper"
    private const val CERT_WIDTH = 1600
    private const val CERT_HEIGHT = 1120
    private const val CACHE_SUBDIR = "certificates"

    fun formatStandardLabel(standard: Int): String = when (standard) {
        11 -> "Morarji Entrance"
        12 -> "NMMS Scholarship"
        else -> "Standard $standard"
    }

    fun buildShareCaption(
        certificateData: CertificateData,
        grade: String,
        certificateId: String,
        formattedDate: String
    ): String {
        val student = certificateData.studentName.ifBlank { "Dedicated Student" }
        val stdLabel = formatStandardLabel(certificateData.standard)
        val perfectHeadline = if (certificateData.accuracyPercentage == 100) {
            "🌟 Perfect 100% Score! Certificate of Excellence Unlocked!"
        } else {
            "🎓 Certificate of Excellence Earned!"
        }
        return buildString {
            appendLine(perfectHeadline)
            appendLine()
            appendLine("🏅 Student: $student")
            appendLine("📚 $stdLabel • ${certificateData.subjectTitle}")
            appendLine("📖 Unit: ${certificateData.unitName}")
            appendLine("✅ Score: ${certificateData.score}/${certificateData.totalQuestions} (${certificateData.accuracyPercentage}%) — $grade")
            appendLine("🔐 Verified ID: $certificateId")
            appendLine("📅 Issued on: $formattedDate")
            appendLine()
            append("Issued by Karnataka School Quiz Portal ✨ #SchoolQuiz #CertificateOfExcellence #LearningJourney")
        }
    }

    /**
     * Renders a crisp 1600x1120 diploma-style Certificate of Excellence bitmap.
     */
    fun renderCertificateBitmap(
        certificateData: CertificateData,
        grade: String,
        certificateId: String,
        formattedDate: String
    ): Bitmap {
        val bitmap = Bitmap.createBitmap(CERT_WIDTH, CERT_HEIGHT, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val w = CERT_WIDTH.toFloat()
        val h = CERT_HEIGHT.toFloat()

        // 1. Warm Ivory Parchment Gradient Background
        val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            shader = LinearGradient(
                0f, 0f, w, h,
                intArrayOf(
                    AndroidColor.parseColor("#FFFDF7"),
                    AndroidColor.parseColor("#FFFBEB"),
                    AndroidColor.parseColor("#FEF3C7")
                ),
                floatArrayOf(0f, 0.55f, 1f),
                Shader.TileMode.CLAMP
            )
        }
        canvas.drawRect(0f, 0f, w, h, bgPaint)

        // Subtle warm spotlight glow behind center crest
        val glowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            shader = RadialGradient(
                w / 2f, 240f, 440f,
                AndroidColor.argb(55, 251, 191, 36),
                AndroidColor.TRANSPARENT,
                Shader.TileMode.CLAMP
            )
        }
        canvas.drawCircle(w / 2f, 240f, 440f, glowPaint)

        // 2. Ornate Double Gold Diploma Borders
        val outerBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 10f
            color = AndroidColor.parseColor("#B45309")
        }
        canvas.drawRoundRect(RectF(36f, 36f, w - 36f, h - 36f), 28f, 28f, outerBorderPaint)

        val innerBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 3.5f
            color = AndroidColor.parseColor("#D97706")
        }
        canvas.drawRoundRect(RectF(58f, 58f, w - 58f, h - 58f), 20f, 20f, innerBorderPaint)

        // Decorative Gold Corner Ornaments
        val cornerFillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
            color = AndroidColor.parseColor("#D97706")
        }
        val cornerOffsets = listOf(
            Pair(78f, 78f),
            Pair(w - 78f, 78f),
            Pair(78f, h - 78f),
            Pair(w - 78f, h - 78f)
        )
        cornerOffsets.forEach { (cx, cy) ->
            canvas.drawCircle(cx, cy, 8f, cornerFillPaint)
            val ringPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                style = Paint.Style.STROKE
                strokeWidth = 2.5f
                color = AndroidColor.parseColor("#92400E")
            }
            canvas.drawCircle(cx, cy, 14f, ringPaint)
        }

        // 3. Top Verified ID Pill (Top-Right inside border)
        val pillRect = RectF(w - 430f, 84f, w - 92f, 132f)
        val pillBgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.argb(38, 217, 119, 6)
        }
        val pillBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 2f
            color = AndroidColor.parseColor("#D97706")
        }
        canvas.drawRoundRect(pillRect, 14f, 14f, pillBgPaint)
        canvas.drawRoundRect(pillRect, 14f, 14f, pillBorderPaint)

        val idPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#92400E")
            textSize = 21f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText("VERIFIED ID: $certificateId", pillRect.centerX(), pillRect.centerY() + 7f, idPaint)

        // Perfect Score Gold Ribbon (Top-Left inside border if 100%)
        if (certificateData.accuracyPercentage == 100) {
            val ribbonRect = RectF(92f, 84f, 410f, 132f)
            val ribbonBgPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                color = AndroidColor.parseColor("#D97706")
            }
            canvas.drawRoundRect(ribbonRect, 14f, 14f, ribbonBgPaint)
            val ribbonTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                color = AndroidColor.WHITE
                textSize = 21f
                typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
                textAlign = Paint.Align.CENTER
            }
            canvas.drawText("★ PERFECT SCORE ★", ribbonRect.centerX(), ribbonRect.centerY() + 7f, ribbonTextPaint)
        }

        // 4. Royal Gold Medallion Crest (Top-Center)
        val sealCx = w / 2f
        val sealCy = 165f
        val sealRadius = 62f

        val sealFillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            shader = RadialGradient(
                sealCx - 14f, sealCy - 16f, sealRadius * 1.4f,
                AndroidColor.parseColor("#FDE68A"),
                AndroidColor.parseColor("#B45309"),
                Shader.TileMode.CLAMP
            )
        }
        canvas.drawCircle(sealCx, sealCy, sealRadius, sealFillPaint)

        val sealRimPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 5f
            color = AndroidColor.parseColor("#92400E")
        }
        canvas.drawCircle(sealCx, sealCy, sealRadius, sealRimPaint)

        // 5-Pointed Gold Star inside Seal
        val starPath = createStarPath(sealCx, sealCy, 34f, 15f, 5)
        val starPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#FFFBEB")
            style = Paint.Style.FILL
        }
        canvas.drawPath(starPath, starPaint)

        // 5. Title & Portal Subtitle
        val titlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#78350F")
            textSize = 56f
            typeface = Typeface.create(Typeface.SERIF, Typeface.BOLD)
            letterSpacing = 0.08f
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText("CERTIFICATE OF EXCELLENCE", w / 2f, 294f, titlePaint)

        val portalPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#B45309")
            textSize = 26f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            letterSpacing = 0.06f
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText("KARNATAKA STATE SCHOOL QUIZ PORTAL", w / 2f, 336f, portalPaint)

        // Ornamental Center Divider
        val dividerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#D97706")
            strokeWidth = 3f
        }
        canvas.drawLine(w / 2f - 240f, 366f, w / 2f + 240f, 366f, dividerPaint)

        // 6. Recipient Line & Student Name
        val presentedPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#78350F")
            textSize = 26f
            typeface = Typeface.create(Typeface.SERIF, Typeface.ITALIC)
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText("This certificate is proudly presented to", w / 2f, 422f, presentedPaint)

        val studentName = certificateData.studentName.ifBlank { "Dedicated Student" }
        val namePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#0F172A")
            typeface = Typeface.create(Typeface.SERIF, Typeface.BOLD)
            textAlign = Paint.Align.CENTER
            textSize = fitTextSize(studentName, 64f, 34f, w - 260f, this)
        }
        canvas.drawText(studentName, w / 2f, 502f, namePaint)

        // Subtle underline under student name
        val nameWidth = namePaint.measureText(studentName).coerceIn(280f, w - 320f)
        val underlinePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#F59E0B")
            strokeWidth = 3f
        }
        canvas.drawLine(w / 2f - nameWidth / 2f, 522f, w / 2f + nameWidth / 2f, 522f, underlinePaint)

        val achievementPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#475569")
            textSize = 24f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL)
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText(
            "For outstanding achievement and mastery in the curriculum assessment",
            w / 2f,
            568f,
            achievementPaint
        )

        // 7. Subject & Unit Highlight Card
        val cardRect = RectF(180f, 598f, w - 180f, 742f)
        val cardFillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#FEF3C7")
        }
        val cardBorderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 3f
            color = AndroidColor.parseColor("#F59E0B")
        }
        canvas.drawRoundRect(cardRect, 20f, 20f, cardFillPaint)
        canvas.drawRoundRect(cardRect, 20f, 20f, cardBorderPaint)

        val stdLabel = formatStandardLabel(certificateData.standard)
        val subjectPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#B45309")
            textSize = 27f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText("${certificateData.subjectTitle}  •  $stdLabel", w / 2f, 646f, subjectPaint)

        val unitDisplay = "\"${certificateData.unitName}\""
        val unitPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#1E293B")
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            textAlign = Paint.Align.CENTER
            textSize = fitTextSize(unitDisplay, 34f, 22f, cardRect.width() - 64f, this)
        }
        canvas.drawText(unitDisplay, w / 2f, 706f, unitPaint)

        // 8. Performance Metrics Row (Score | Accuracy | Rating)
        val metricY = 838f
        val metricLabelY = 876f
        val col1X = w * 0.25f
        val col2X = w * 0.50f
        val col3X = w * 0.75f

        val valuePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            textSize = 44f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            textAlign = Paint.Align.CENTER
        }
        val metricLabelPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#78350F")
            textSize = 22f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            textAlign = Paint.Align.CENTER
        }

        valuePaint.color = AndroidColor.parseColor("#059669")
        canvas.drawText("${certificateData.score}/${certificateData.totalQuestions}", col1X, metricY, valuePaint)
        canvas.drawText("SCORE", col1X, metricLabelY, metricLabelPaint)

        valuePaint.color = AndroidColor.parseColor("#2563EB")
        canvas.drawText("${certificateData.accuracyPercentage}%", col2X, metricY, valuePaint)
        canvas.drawText("ACCURACY", col2X, metricLabelY, metricLabelPaint)

        valuePaint.color = AndroidColor.parseColor("#D97706")
        valuePaint.textSize = fitTextSize(grade, 36f, 24f, 360f, valuePaint)
        canvas.drawText(grade, col3X, metricY, valuePaint)
        canvas.drawText("RATING", col3X, metricLabelY, metricLabelPaint)

        // Metric Vertical Separators
        val sepPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.argb(90, 217, 119, 6)
            strokeWidth = 2.5f
        }
        canvas.drawLine(w * 0.375f, 790f, w * 0.375f, 886f, sepPaint)
        canvas.drawLine(w * 0.625f, 790f, w * 0.625f, 886f, sepPaint)

        // 9. Footer: Date & Portal Signature
        val footerLabelPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#78350F")
            textSize = 21f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL)
            textAlign = Paint.Align.LEFT
        }
        val footerValPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#0F172A")
            textSize = 26f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            textAlign = Paint.Align.LEFT
        }
        canvas.drawText("Issued on:", 128f, 972f, footerLabelPaint)
        canvas.drawText(formattedDate, 128f, 1008f, footerValPaint)
        canvas.drawLine(128f, 1024f, 440f, 1024f, dividerPaint)

        val rightLabelPaint = Paint(footerLabelPaint).apply { textAlign = Paint.Align.RIGHT }
        val rightValPaint = Paint(footerValPaint).apply {
            color = AndroidColor.parseColor("#B45309")
            textAlign = Paint.Align.RIGHT
        }
        canvas.drawText("Verified Portal Seal", w - 128f, 972f, rightLabelPaint)
        canvas.drawText("ಕಲಿಕಾ ಕರ್ನಾಟಕ • School Quiz", w - 128f, 1008f, rightValPaint)
        canvas.drawLine(w - 480f, 1024f, w - 128f, 1024f, dividerPaint)

        // Bottom subtle branding watermark
        val brandPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = AndroidColor.parseColor("#92400E")
            alpha = 170
            textSize = 19f
            typeface = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD)
            textAlign = Paint.Align.CENTER
        }
        canvas.drawText("SCHOOL QUIZ APP  •  ACADEMIC EXCELLENCE", w / 2f, 1054f, brandPaint)

        return bitmap
    }

    private fun fitTextSize(
        text: String,
        maxSize: Float,
        minSize: Float,
        maxWidth: Float,
        paint: Paint
    ): Float {
        var size = maxSize
        paint.textSize = size
        while (size > minSize && paint.measureText(text) > maxWidth) {
            size -= 2f
            paint.textSize = size
        }
        return size
    }

    private fun createStarPath(
        cx: Float,
        cy: Float,
        outerRadius: Float,
        innerRadius: Float,
        points: Int
    ): Path {
        val path = Path()
        val angleStep = Math.PI / points
        var angle = -Math.PI / 2.0
        for (i in 0 until points * 2) {
            val r = if (i % 2 == 0) outerRadius else innerRadius
            val x = (cx + r * cos(angle)).toFloat()
            val y = (cy + r * sin(angle)).toFloat()
            if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
            angle += angleStep
        }
        path.close()
        return path
    }

    private fun exportCertificateToCacheUri(
        context: Context,
        bitmap: Bitmap,
        certificateId: String
    ): Uri {
        val dir = File(context.cacheDir, CACHE_SUBDIR).apply {
            if (!exists()) mkdirs()
        }
        // Keep cache tidy by removing older temporary certificate PNGs
        dir.listFiles()?.forEach { existing ->
            if (existing.isFile && existing.name.endsWith(".png")) {
                existing.delete()
            }
        }
        val safeId = certificateId.replace(Regex("[^A-Za-z0-9_-]"), "_")
        val file = File(dir, "Certificate_of_Excellence_$safeId.png")
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.flush()
        }
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )
    }

    /**
     * Renders and shares the Certificate of Excellence PNG + achievement caption
     * directly to the chosen social platform or via Android's native Share Sheet.
     */
    suspend fun shareCertificate(
        context: Context,
        certificateData: CertificateData,
        grade: String,
        certificateId: String,
        formattedDate: String,
        platform: SocialSharePlatform = SocialSharePlatform.SYSTEM_SHEET
    ) {
        val caption = buildShareCaption(certificateData, grade, certificateId, formattedDate)
        val subject = "Certificate of Excellence: ${certificateData.studentName.ifBlank { "Student" }}"

        val imageUri: Uri? = withContext(Dispatchers.IO) {
            var bitmap: Bitmap? = null
            try {
                bitmap = renderCertificateBitmap(certificateData, grade, certificateId, formattedDate)
                exportCertificateToCacheUri(context, bitmap, certificateId)
            } catch (e: Exception) {
                Log.e(TAG, "Failed to render/export certificate PNG", e)
                null
            } finally {
                bitmap?.recycle()
            }
        }

        withContext(Dispatchers.Main) {
            if (imageUri == null) {
                Toast.makeText(
                    context,
                    context.getString(R.string.certificate_share_error_toast),
                    Toast.LENGTH_SHORT
                ).show()
                launchTextShareFallback(context, subject, caption)
                return@withContext
            }

            fun buildImageIntent(targetPackage: String? = null): Intent {
                return Intent(Intent.ACTION_SEND).apply {
                    type = "image/png"
                    putExtra(Intent.EXTRA_STREAM, imageUri)
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                    putExtra(Intent.EXTRA_TEXT, caption)
                    clipData = ClipData.newRawUri("Certificate of Excellence", imageUri)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    if (targetPackage != null) {
                        setPackage(targetPackage)
                    }
                }
            }

            val chooserTitle = context.getString(R.string.certificate_share_chooser_title)
            if (platform.packageName != null) {
                try {
                    context.startActivity(buildImageIntent(platform.packageName))
                    return@withContext
                } catch (_: ActivityNotFoundException) {
                    Toast.makeText(
                        context,
                        "${platform.displayName} not found — opening Share Sheet",
                        Toast.LENGTH_SHORT
                    ).show()
                } catch (e: Exception) {
                    Log.w(TAG, "Direct share to ${platform.displayName} failed, falling back to chooser", e)
                }
            }

            try {
                val chooser = Intent.createChooser(buildImageIntent(), chooserTitle).apply {
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                context.startActivity(chooser)
            } catch (e: Exception) {
                Log.e(TAG, "Failed to open share chooser", e)
                launchTextShareFallback(context, subject, caption)
            }
        }
    }

    /**
     * Saves the rendered Certificate of Excellence PNG to the device's Pictures gallery
     * via MediaStore (zero storage permissions required on Android 10+).
     */
    suspend fun saveCertificateToGallery(
        context: Context,
        certificateData: CertificateData,
        grade: String,
        certificateId: String,
        formattedDate: String
    ): Boolean {
        val saved = withContext(Dispatchers.IO) {
            var bitmap: Bitmap? = null
            try {
                bitmap = renderCertificateBitmap(certificateData, grade, certificateId, formattedDate)
                val safeId = certificateId.replace(Regex("[^A-Za-z0-9_-]"), "_")
                val fileName = "Certificate_of_Excellence_$safeId.png"

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    val values = ContentValues().apply {
                        put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
                        put(MediaStore.Images.Media.MIME_TYPE, "image/png")
                        put(
                            MediaStore.Images.Media.RELATIVE_PATH,
                            "${Environment.DIRECTORY_PICTURES}/SchoolQuizCertificates"
                        )
                        put(MediaStore.Images.Media.IS_PENDING, 1)
                    }
                    val resolver = context.contentResolver
                    val uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
                        ?: return@withContext false
                    resolver.openOutputStream(uri)?.use { out ->
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
                        out.flush()
                    } ?: return@withContext false
                    values.clear()
                    values.put(MediaStore.Images.Media.IS_PENDING, 0)
                    resolver.update(uri, values, null, null)
                    true
                } else {
                    // API 24-28: Export to app-private Pictures dir (zero runtime permission)
                    val appPicturesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                        ?: context.cacheDir
                    val outFile = File(appPicturesDir, fileName)
                    FileOutputStream(outFile).use { out ->
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
                        out.flush()
                    }
                    true
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save certificate PNG to gallery", e)
                false
            } finally {
                bitmap?.recycle()
            }
        }

        withContext(Dispatchers.Main) {
            if (saved) {
                Toast.makeText(
                    context,
                    context.getString(R.string.certificate_saved_toast),
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    context,
                    "Could not save certificate image.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return saved
    }

    fun copyCaptionToClipboard(context: Context, caption: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
        clipboard?.setPrimaryClip(ClipData.newPlainText("Certificate of Excellence", caption))
        Toast.makeText(
            context,
            context.getString(R.string.certificate_copied_toast),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun launchTextShareFallback(context: Context, subject: String, caption: String) {
        val textIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, caption)
        }
        context.startActivity(
            Intent.createChooser(
                textIntent,
                context.getString(R.string.certificate_share_chooser_title)
            )
        )
    }
}
