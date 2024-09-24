package com.rabota.artwork.data

import com.android.installreferrer.api.InstallReferrerClient
import com.android.installreferrer.api.InstallReferrerStateListener
import com.google.firebase.analytics.FirebaseAnalytics
import com.rabota.artwork.domain.Prefs
import com.rabota.artwork.domain.ProductInfo
import com.rabota.artwork.domain.Repository
import com.rabota.artwork.utils.NetworkUtils.safeApiCall
import com.rabota.artwork.utils.toProductInfoList
import kotlinx.coroutines.delay
import java.net.URLEncoder
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val prefs: Prefs,
    private val apiService: ApiService,
    private val installReferrerClient: InstallReferrerClient,
    private val countryCode: String,
    private val firebaseAnalytics: FirebaseAnalytics
): Repository {

    override var startStepCompleted: Boolean
        get() = prefs.startStepCompleted
        set(value) { prefs.startStepCompleted = value }

    override var eighteenOver : Boolean
        get() = prefs.eighteenOver
        set(value) { prefs.eighteenOver = value }

    override suspend fun getProducts(): Result<List<ProductInfo>> {
        return safeApiCall(List<ProductInfoDto>::toProductInfoList) {
            var referrer = "test"
            var firebaseId = "test"
            var isHandledReferrer = false
            var isHandledFirebase = false
            firebaseAnalytics.appInstanceId.addOnSuccessListener {
                if (it != null) {
                    firebaseId = it
                }
                isHandledFirebase = true
            }.addOnCompleteListener {
                isHandledFirebase = true
            }
            installReferrerClient.startConnection(object : InstallReferrerStateListener {
                override fun onInstallReferrerSetupFinished(responseCode: Int) {
                    if (responseCode == InstallReferrerClient.InstallReferrerResponse.OK) {
                        val referrerDetails = installReferrerClient.installReferrer
                        val encodedInstallReferrer = URLEncoder.encode(referrerDetails.installReferrer, "UTF-8")
                        referrer = encodedInstallReferrer
                    }
                    isHandledReferrer = true
                }

                override fun onInstallReferrerServiceDisconnected() {
                    isHandledReferrer = true
                }

            })
            var delay = 0
            while ((!isHandledReferrer || !isHandledFirebase) && delay < 10) {
                delay(100L)
                delay++
            }
            apiService.getProducts(referrer, firebaseId, countryCode)
        }
    }
}