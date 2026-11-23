package com.example.billing

import kotlin.math.ceil

/**
 * Subscription configuration matching Google Play Console setup:
 * - Subscription Product ID: school_quiz_monthly_20
 * - Base Plan ID: monthly-20-inr (₹20/month auto-renewing)
 * - Free Trial Offer ID: free-trial-7d (7 days free trial, then ₹20/month)
 */
object SubscriptionConfig {
    const val SUBSCRIPTION_PRODUCT_ID = "school_quiz_monthly_20"
    const val BASE_PLAN_ID = "monthly-20-inr"
    const val FREE_TRIAL_OFFER_ID = "free-trial-7d"

    const val TRIAL_DURATION_DAYS = 7
    const val MILLIS_PER_HOUR = 60L * 60L * 1000L
    const val MILLIS_PER_DAY = 24L * MILLIS_PER_HOUR
    const val TRIAL_DURATION_MILLIS = TRIAL_DURATION_DAYS * MILLIS_PER_DAY

    const val DEFAULT_PRICE_TEXT = "₹20 / month"
    const val PLAN_TITLE = "School Quiz Monthly Pass"
}

sealed class SubscriptionAccessState {
    /** User has an active paid or Google Play free-trial subscription. */
    data class Subscribed(
        val planTitle: String = SubscriptionConfig.PLAN_TITLE,
        val formattedPrice: String = SubscriptionConfig.DEFAULT_PRICE_TEXT,
        val isAutoRenewing: Boolean = true,
        val orderId: String? = null
    ) : SubscriptionAccessState()

    /** User is within their 7-day free trial window. */
    data class FreeTrialActive(
        val daysRemaining: Int,
        val hoursRemaining: Int,
        val trialEndMillis: Long,
        val progressFraction: Float,
        val formattedPrice: String = SubscriptionConfig.DEFAULT_PRICE_TEXT
    ) : SubscriptionAccessState()

    /** 7-day free trial has ended and no active Google Play subscription was found. */
    data class TrialExpired(
        val trialEndMillis: Long,
        val formattedPrice: String = SubscriptionConfig.DEFAULT_PRICE_TEXT
    ) : SubscriptionAccessState()
}

data class SubscriptionUiState(
    val accessState: SubscriptionAccessState = SubscriptionAccessState.FreeTrialActive(
        daysRemaining = SubscriptionConfig.TRIAL_DURATION_DAYS,
        hoursRemaining = SubscriptionConfig.TRIAL_DURATION_DAYS * 24,
        trialEndMillis = System.currentTimeMillis() + SubscriptionConfig.TRIAL_DURATION_MILLIS,
        progressFraction = 1f,
        formattedPrice = SubscriptionConfig.DEFAULT_PRICE_TEXT
    ),
    val isBillingConnected: Boolean = false,
    val isStoreCatalogLoaded: Boolean = false,
    val isPlayTrialOfferEligible: Boolean = true,
    val isProcessingPurchase: Boolean = false,
    val formattedMonthlyPrice: String = SubscriptionConfig.DEFAULT_PRICE_TEXT,
    val statusMessage: String? = null,
    val errorMessage: String? = null
) {
    val hasFullAccess: Boolean
        get() = accessState !is SubscriptionAccessState.TrialExpired
}

/**
 * Pure, deterministic evaluator for the 7-day free trial + ₹20/month subscription state.
 */
object TrialCalculator {
    fun evaluateAccess(
        trialStartMillis: Long,
        nowMillis: Long,
        hasActiveSubscription: Boolean,
        isAutoRenewing: Boolean = true,
        orderId: String? = null,
        formattedPrice: String = SubscriptionConfig.DEFAULT_PRICE_TEXT
    ): SubscriptionAccessState {
        if (hasActiveSubscription) {
            return SubscriptionAccessState.Subscribed(
                planTitle = SubscriptionConfig.PLAN_TITLE,
                formattedPrice = formattedPrice,
                isAutoRenewing = isAutoRenewing,
                orderId = orderId
            )
        }

        val safeStart = if (trialStartMillis <= 0L) nowMillis else minOf(trialStartMillis, nowMillis)
        val trialEnd = safeStart + SubscriptionConfig.TRIAL_DURATION_MILLIS
        val remainingMs = trialEnd - nowMillis

        if (remainingMs <= 0L) {
            return SubscriptionAccessState.TrialExpired(
                trialEndMillis = trialEnd,
                formattedPrice = formattedPrice
            )
        }

        val hoursRemaining = ceil(remainingMs.toDouble() / SubscriptionConfig.MILLIS_PER_HOUR).toInt().coerceAtLeast(1)
        val daysRemaining = ceil(remainingMs.toDouble() / SubscriptionConfig.MILLIS_PER_DAY).toInt()
            .coerceIn(1, SubscriptionConfig.TRIAL_DURATION_DAYS)
        val progress = (remainingMs.toFloat() / SubscriptionConfig.TRIAL_DURATION_MILLIS.toFloat()).coerceIn(0f, 1f)

        return SubscriptionAccessState.FreeTrialActive(
            daysRemaining = daysRemaining,
            hoursRemaining = hoursRemaining,
            trialEndMillis = trialEnd,
            progressFraction = progress,
            formattedPrice = formattedPrice
        )
    }
}
