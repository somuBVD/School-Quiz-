package com.example

import com.example.billing.SubscriptionAccessState
import com.example.billing.SubscriptionConfig
import com.example.billing.TrialCalculator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SubscriptionTrialTest {

    @Test
    fun brandNewUserGetsFull7DayFreeTrial() {
        val start = 1_700_000_000_000L
        val state = TrialCalculator.evaluateAccess(
            trialStartMillis = start,
            nowMillis = start + 1_000L,
            hasActiveSubscription = false
        )

        assertTrue(state is SubscriptionAccessState.FreeTrialActive)
        val active = state as SubscriptionAccessState.FreeTrialActive
        assertEquals(7, active.daysRemaining)
        assertEquals(SubscriptionConfig.DEFAULT_PRICE_TEXT, active.formattedPrice)
    }

    @Test
    fun dayFiveShowsTwoDaysRemaining() {
        val start = 1_700_000_000_000L
        val fiveDaysLater = start + (5L * SubscriptionConfig.MILLIS_PER_DAY) + 60_000L
        val state = TrialCalculator.evaluateAccess(
            trialStartMillis = start,
            nowMillis = fiveDaysLater,
            hasActiveSubscription = false
        )

        assertTrue(state is SubscriptionAccessState.FreeTrialActive)
        val active = state as SubscriptionAccessState.FreeTrialActive
        assertEquals(2, active.daysRemaining)
    }

    @Test
    fun afterSevenDaysWithoutSubscriptionExpiresTrial() {
        val start = 1_700_000_000_000L
        val afterSevenDays = start + SubscriptionConfig.TRIAL_DURATION_MILLIS + 1L
        val state = TrialCalculator.evaluateAccess(
            trialStartMillis = start,
            nowMillis = afterSevenDays,
            hasActiveSubscription = false
        )

        assertTrue(state is SubscriptionAccessState.TrialExpired)
    }

    @Test
    fun activeMonthlySubscriptionUnlocksAfterTrialExpires() {
        val start = 1_700_000_000_000L
        val thirtyDaysLater = start + (30L * SubscriptionConfig.MILLIS_PER_DAY)
        val state = TrialCalculator.evaluateAccess(
            trialStartMillis = start,
            nowMillis = thirtyDaysLater,
            hasActiveSubscription = true,
            isAutoRenewing = true,
            formattedPrice = "₹20.00 / month"
        )

        assertTrue(state is SubscriptionAccessState.Subscribed)
        val subscribed = state as SubscriptionAccessState.Subscribed
        assertEquals("₹20.00 / month", subscribed.formattedPrice)
        assertTrue(subscribed.isAutoRenewing)
    }
}
