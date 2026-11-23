package com.example.billing

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.android.billingclient.api.AcknowledgePurchaseParams
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.PendingPurchasesParams
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryProductDetailsParams
import com.android.billingclient.api.QueryPurchasesParams
import com.example.auth.NamedFirestoreProvider
import com.example.auth.OperationType
import com.example.auth.handleFirestoreError
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

/**
 * Manages the 7-day free trial and ₹20/month auto-renewing Google Play subscription
 * (`school_quiz_monthly_20`).
 *
 * - Tracks trial start timestamp locally AND syncs the earliest start timestamp to Firestore
 *   `/users/{uid}` when the student is signed in with Google so trial state persists across devices.
 * - Connects to Google Play Billing Library to load localized ₹20/month pricing, detect the
 *   7-day Play Store free-trial offer token, launch the Play Billing checkout sheet,
 *   acknowledge purchases, and restore active subscriptions.
 */
class SubscriptionManager private constructor(private val context: Context) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _uiState = MutableStateFlow(buildInitialState())
    val uiState: StateFlow<SubscriptionUiState> = _uiState.asStateFlow()

    @Volatile
    private var cachedProductDetails: ProductDetails? = null

    @Volatile
    private var activePurchase: Purchase? = null

    private val purchasesUpdatedListener = PurchasesUpdatedListener { billingResult, purchases ->
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.OK -> {
                if (!purchases.isNullOrEmpty()) {
                    scope.launch { handlePurchases(purchases) }
                } else {
                    refreshUiState(
                        isProcessing = false,
                        statusMessage = "Purchase updated."
                    )
                }
            }
            BillingClient.BillingResponseCode.USER_CANCELED -> {
                refreshUiState(
                    isProcessing = false,
                    statusMessage = "Subscription checkout cancelled."
                )
            }
            BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED -> {
                refreshPurchases()
                refreshUiState(
                    isProcessing = false,
                    statusMessage = "You already have an active School Quiz subscription."
                )
            }
            else -> {
                refreshUiState(
                    isProcessing = false,
                    errorMessage = mapBillingError(billingResult)
                )
            }
        }
    }

    private val billingClient: BillingClient = BillingClient.newBuilder(context.applicationContext)
        .setListener(purchasesUpdatedListener)
        .enablePendingPurchases(
            PendingPurchasesParams.newBuilder()
                .enableOneTimeProducts()
                .enablePrepaidPlans()
                .build()
        )
        .enableAutoServiceReconnection()
        .build()

    init {
        ensureLocalTrialStartTimestamp()
        startBillingConnection()
    }

    private fun ensureLocalTrialStartTimestamp(): Long {
        val existing = prefs.getLong(KEY_TRIAL_START_MS, 0L)
        if (existing > 0L) return existing
        val now = System.currentTimeMillis()
        prefs.edit().putLong(KEY_TRIAL_START_MS, now).apply()
        return now
    }

    private fun buildInitialState(): SubscriptionUiState {
        val trialStart = ensureLocalTrialStartTimestamp()
        val hasCachedSub = prefs.getBoolean(KEY_SUB_ACTIVE, false)
        val cachedAutoRenew = prefs.getBoolean(KEY_SUB_AUTO_RENEW, true)
        val cachedPrice = prefs.getString(KEY_PRICE_TEXT, SubscriptionConfig.DEFAULT_PRICE_TEXT)
            ?: SubscriptionConfig.DEFAULT_PRICE_TEXT
        val access = TrialCalculator.evaluateAccess(
            trialStartMillis = trialStart,
            nowMillis = System.currentTimeMillis(),
            hasActiveSubscription = hasCachedSub,
            isAutoRenewing = cachedAutoRenew,
            formattedPrice = cachedPrice
        )
        return SubscriptionUiState(
            accessState = access,
            formattedMonthlyPrice = cachedPrice
        )
    }

    fun startBillingConnection() {
        if (billingClient.isReady) {
            querySubscriptionProduct()
            refreshPurchases()
            return
        }
        try {
            billingClient.startConnection(object : BillingClientStateListener {
                override fun onBillingSetupFinished(billingResult: BillingResult) {
                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                        _uiState.value = _uiState.value.copy(
                            isBillingConnected = true,
                            errorMessage = null
                        )
                        querySubscriptionProduct()
                        refreshPurchases()
                    } else {
                        Log.w(TAG, "Play Billing setup note (${billingResult.responseCode}): ${billingResult.debugMessage}")
                        _uiState.value = _uiState.value.copy(isBillingConnected = false)
                    }
                }

                override fun onBillingServiceDisconnected() {
                    _uiState.value = _uiState.value.copy(isBillingConnected = false)
                }
            })
        } catch (t: Throwable) {
            Log.w(TAG, "Billing connection unavailable: ${t.message}")
            _uiState.value = _uiState.value.copy(isBillingConnected = false)
        }
    }

    private fun querySubscriptionProduct() {
        val product = QueryProductDetailsParams.Product.newBuilder()
            .setProductId(SubscriptionConfig.SUBSCRIPTION_PRODUCT_ID)
            .setProductType(BillingClient.ProductType.SUBS)
            .build()

        val params = QueryProductDetailsParams.newBuilder()
            .setProductList(listOf(product))
            .build()

        billingClient.queryProductDetailsAsync(params) { billingResult, queryProductDetailsResult ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                val productDetailsList = queryProductDetailsResult.productDetailsList
                val details = productDetailsList.firstOrNull {
                    it.productId == SubscriptionConfig.SUBSCRIPTION_PRODUCT_ID
                }
                cachedProductDetails = details
                if (details != null) {
                    val offer = selectBestOffer(details)
                    val recurringPhase = offer?.pricingPhases?.pricingPhaseList?.lastOrNull()
                    val formatted = recurringPhase?.formattedPrice?.let { "$it / month" }
                        ?: SubscriptionConfig.DEFAULT_PRICE_TEXT
                    val hasFreeTrialOffer = offer?.pricingPhases?.pricingPhaseList?.any {
                        it.priceAmountMicros == 0L
                    } == true

                    prefs.edit().putString(KEY_PRICE_TEXT, formatted).apply()
                    refreshUiState(
                        isStoreCatalogLoaded = true,
                        isPlayTrialOfferEligible = hasFreeTrialOffer,
                        formattedPrice = formatted
                    )
                } else {
                    refreshUiState(isStoreCatalogLoaded = false)
                }
            } else {
                Log.w(TAG, "Product query failed (${billingResult.responseCode}): ${billingResult.debugMessage}")
            }
        }
    }

    private fun selectBestOffer(details: ProductDetails): ProductDetails.SubscriptionOfferDetails? {
        val offers = details.subscriptionOfferDetails.orEmpty()
        if (offers.isEmpty()) return null
        return offers.firstOrNull { it.offerId == SubscriptionConfig.FREE_TRIAL_OFFER_ID }
            ?: offers.firstOrNull { offer ->
                offer.pricingPhases.pricingPhaseList.any { it.priceAmountMicros == 0L }
            }
            ?: offers.firstOrNull { it.basePlanId == SubscriptionConfig.BASE_PLAN_ID }
            ?: offers.first()
    }

    /**
     * Re-queries Google Play for active subscriptions and refreshes trial/access state.
     */
    fun refreshPurchases(showFeedback: Boolean = false) {
        if (!billingClient.isReady) {
            startBillingConnection()
            if (showFeedback) {
                refreshUiState(statusMessage = "Connecting to Google Play Store to check subscription...")
            }
            return
        }
        val params = QueryPurchasesParams.newBuilder()
            .setProductType(BillingClient.ProductType.SUBS)
            .build()

        billingClient.queryPurchasesAsync(params) { billingResult, purchases ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                scope.launch {
                    handlePurchases(purchases, showFeedback = showFeedback)
                }
            } else if (showFeedback) {
                refreshUiState(errorMessage = mapBillingError(billingResult))
            }
        }
    }

    private suspend fun handlePurchases(purchases: List<Purchase>, showFeedback: Boolean = false) {
        val matchingPurchase = purchases.firstOrNull { purchase ->
            purchase.products.contains(SubscriptionConfig.SUBSCRIPTION_PRODUCT_ID) &&
                purchase.purchaseState == Purchase.PurchaseState.PURCHASED
        }

        if (matchingPurchase != null) {
            activePurchase = matchingPurchase
            if (!matchingPurchase.isAcknowledged) {
                acknowledgePurchase(matchingPurchase)
            }
            prefs.edit()
                .putBoolean(KEY_SUB_ACTIVE, true)
                .putBoolean(KEY_SUB_AUTO_RENEW, matchingPurchase.isAutoRenewing)
                .apply()

            syncSubscriptionToFirestore(
                isSubscribed = true,
                autoRenewing = matchingPurchase.isAutoRenewing,
                orderId = matchingPurchase.orderId
            )

            refreshUiState(
                isProcessing = false,
                statusMessage = if (showFeedback) "Subscription active! All features unlocked." else "School Quiz Monthly Pass is active.",
                errorMessage = null
            )
        } else {
            val pendingPurchase = purchases.firstOrNull { purchase ->
                purchase.products.contains(SubscriptionConfig.SUBSCRIPTION_PRODUCT_ID) &&
                    purchase.purchaseState == Purchase.PurchaseState.PENDING
            }
            activePurchase = null
            prefs.edit().putBoolean(KEY_SUB_ACTIVE, false).apply()

            syncSubscriptionToFirestore(isSubscribed = false, autoRenewing = false, orderId = null)

            refreshUiState(
                isProcessing = false,
                statusMessage = when {
                    pendingPurchase != null -> "Payment is pending confirmation from Google Play."
                    showFeedback -> "No active Google Play subscription found for this account."
                    else -> null
                },
                errorMessage = null
            )
        }
    }

    private fun acknowledgePurchase(purchase: Purchase) {
        val ackParams = AcknowledgePurchaseParams.newBuilder()
            .setPurchaseToken(purchase.purchaseToken)
            .build()
        billingClient.acknowledgePurchase(ackParams) { ackResult ->
            if (ackResult.responseCode != BillingClient.BillingResponseCode.OK) {
                Log.w(TAG, "Acknowledge failed (${ackResult.responseCode}): ${ackResult.debugMessage}")
            }
        }
    }

    /**
     * Launches the official Google Play Billing subscription sheet for the ₹20/month plan
     * (automatically applying the 7-day free trial offer when eligible).
     */
    fun launchSubscriptionFlow(activity: Activity) {
        if (!billingClient.isReady) {
            startBillingConnection()
            refreshUiState(
                errorMessage = "Google Play Billing is connecting. Please make sure Google Play Store is available and try again."
            )
            return
        }

        val details = cachedProductDetails
        if (details == null) {
            querySubscriptionProduct()
            refreshUiState(
                errorMessage = "Subscription plan '${SubscriptionConfig.SUBSCRIPTION_PRODUCT_ID}' is not yet active in Google Play Console. Activate the ₹20/month subscription with a 7-day free trial offer in Play Console to enable live checkout."
            )
            return
        }

        val offer = selectBestOffer(details)
        if (offer == null) {
            refreshUiState(errorMessage = "No active monthly offer found for this subscription in Google Play.")
            return
        }

        val productParams = BillingFlowParams.ProductDetailsParams.newBuilder()
            .setProductDetails(details)
            .setOfferToken(offer.offerToken)
            .build()

        val billingFlowParams = BillingFlowParams.newBuilder()
            .setProductDetailsParamsList(listOf(productParams))
            .build()

        refreshUiState(isProcessing = true, errorMessage = null, statusMessage = null)
        val launchResult = billingClient.launchBillingFlow(activity, billingFlowParams)
        if (launchResult.responseCode != BillingClient.BillingResponseCode.OK) {
            refreshUiState(
                isProcessing = false,
                errorMessage = mapBillingError(launchResult)
            )
        }
    }

    /**
     * Opens the official Google Play Subscriptions management page for this app.
     */
    fun openManageSubscription(context: Context) {
        val url = "https://play.google.com/store/account/subscriptions" +
            "?sku=${SubscriptionConfig.SUBSCRIPTION_PRODUCT_ID}" +
            "&package=${context.packageName}"
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        } catch (t: Throwable) {
            Log.w(TAG, "Could not open Play Store subscriptions page: ${t.message}")
            refreshUiState(errorMessage = "Open Google Play Store → Payments & subscriptions to manage your plan.")
        }
    }

    /**
     * Synchronizes trial start timestamp with Cloud Firestore `/users/{uid}` after Google Sign-In.
     * Uses the earliest timestamp (`min(local, cloud)`) so reinstalling does not infinitely reset the 7-day trial.
     */
    fun syncTrialWithCloudForUser(uid: String) {
        scope.launch {
            val db = NamedFirestoreProvider.getDatabase(context) ?: return@launch
            val docPath = "users/$uid"
            try {
                val snapshot = db.collection("users").document(uid).get().await()
                val localStart = ensureLocalTrialStartTimestamp()
                val cloudStart = snapshot.getLong("trialStartMillis")
                val effectiveStart = if (cloudStart != null && cloudStart > 0L) {
                    minOf(localStart, cloudStart)
                } else {
                    localStart
                }

                if (effectiveStart != localStart) {
                    prefs.edit().putLong(KEY_TRIAL_START_MS, effectiveStart).apply()
                }

                val payload = hashMapOf<String, Any>(
                    "uid" to uid,
                    "trialStartMillis" to effectiveStart,
                    "subscriptionProductId" to SubscriptionConfig.SUBSCRIPTION_PRODUCT_ID,
                    "subscriptionActive" to prefs.getBoolean(KEY_SUB_ACTIVE, false),
                    "updatedAt" to FieldValue.serverTimestamp()
                )
                if (!snapshot.exists()) {
                    payload["createdAt"] = FieldValue.serverTimestamp()
                }
                db.collection("users").document(uid).set(payload, SetOptions.merge()).await()
                refreshUiState()
            } catch (e: CancellationException) {
                throw e
            } catch (t: Throwable) {
                handleFirestoreError(t, OperationType.WRITE, docPath)
            }
        }
    }

    private suspend fun syncSubscriptionToFirestore(
        isSubscribed: Boolean,
        autoRenewing: Boolean,
        orderId: String?
    ) {
        val uid = NamedFirestoreProvider.currentUid(context) ?: return
        val db = NamedFirestoreProvider.getDatabase(context) ?: return
        val docPath = "users/$uid"
        try {
            val payload = hashMapOf<String, Any>(
                "uid" to uid,
                "trialStartMillis" to ensureLocalTrialStartTimestamp(),
                "subscriptionActive" to isSubscribed,
                "subscriptionAutoRenewing" to autoRenewing,
                "subscriptionProductId" to SubscriptionConfig.SUBSCRIPTION_PRODUCT_ID,
                "updatedAt" to FieldValue.serverTimestamp()
            )
            if (!orderId.isNullOrBlank()) {
                payload["subscriptionOrderId"] = orderId
            }
            db.collection("users").document(uid).set(payload, SetOptions.merge()).await()
        } catch (e: CancellationException) {
            throw e
        } catch (t: Throwable) {
            handleFirestoreError(t, OperationType.UPDATE, docPath)
        }
    }

    fun clearBannerMessages() {
        _uiState.value = _uiState.value.copy(statusMessage = null, errorMessage = null)
    }

    private fun refreshUiState(
        isStoreCatalogLoaded: Boolean = _uiState.value.isStoreCatalogLoaded,
        isPlayTrialOfferEligible: Boolean = _uiState.value.isPlayTrialOfferEligible,
        isProcessing: Boolean = _uiState.value.isProcessingPurchase,
        formattedPrice: String = _uiState.value.formattedMonthlyPrice,
        statusMessage: String? = _uiState.value.statusMessage,
        errorMessage: String? = _uiState.value.errorMessage
    ) {
        val trialStart = ensureLocalTrialStartTimestamp()
        val hasSub = activePurchase != null || prefs.getBoolean(KEY_SUB_ACTIVE, false)
        val autoRenew = activePurchase?.isAutoRenewing ?: prefs.getBoolean(KEY_SUB_AUTO_RENEW, true)
        val access = TrialCalculator.evaluateAccess(
            trialStartMillis = trialStart,
            nowMillis = System.currentTimeMillis(),
            hasActiveSubscription = hasSub,
            isAutoRenewing = autoRenew,
            orderId = activePurchase?.orderId,
            formattedPrice = formattedPrice
        )
        _uiState.value = _uiState.value.copy(
            accessState = access,
            isStoreCatalogLoaded = isStoreCatalogLoaded,
            isPlayTrialOfferEligible = isPlayTrialOfferEligible,
            isProcessingPurchase = isProcessing,
            formattedMonthlyPrice = formattedPrice,
            statusMessage = statusMessage,
            errorMessage = errorMessage
        )
    }

    private fun mapBillingError(result: BillingResult): String {
        return when (result.responseCode) {
            BillingClient.BillingResponseCode.BILLING_UNAVAILABLE ->
                "Google Play Billing is unavailable on this device. Please ensure Google Play Store is installed and signed in."
            BillingClient.BillingResponseCode.SERVICE_UNAVAILABLE,
            BillingClient.BillingResponseCode.NETWORK_ERROR ->
                "Unable to reach Google Play Store. Check your internet connection and try again."
            BillingClient.BillingResponseCode.ITEM_UNAVAILABLE ->
                "This subscription plan is not yet published in Google Play Console."
            else ->
                result.debugMessage.ifBlank { "Google Play Billing returned code ${result.responseCode}." }
        }
    }

    companion object {
        private const val TAG = "SubscriptionManager"
        private const val PREFS_NAME = "school_quiz_subscription_prefs"
        private const val KEY_TRIAL_START_MS = "trial_start_millis"
        private const val KEY_SUB_ACTIVE = "subscription_active"
        private const val KEY_SUB_AUTO_RENEW = "subscription_auto_renew"
        private const val KEY_PRICE_TEXT = "subscription_price_text"

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: SubscriptionManager? = null

        fun getInstance(context: Context): SubscriptionManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: SubscriptionManager(context.applicationContext).also { INSTANCE = it }
            }
        }
    }
}
