package com.rabota.artwork.di

import android.content.Context
import android.telephony.TelephonyManager
import com.android.installreferrer.api.InstallReferrerClient
import com.google.firebase.analytics.FirebaseAnalytics
import com.rabota.artwork.data.ApiService
import com.rabota.artwork.domain.Prefs
import com.rabota.artwork.data.PrefsImpl
import com.rabota.artwork.data.RepositoryImpl
import com.rabota.artwork.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [DataModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
class DataModule {

    companion object {
        private const val API_URL = "https://blazze.xyz/"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSimCountryCode(@ApplicationContext context: Context): String {
        val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return tm.simCountryIso
    }

    @Provides
    @Singleton
    fun provideFirebaseAnalytics(@ApplicationContext context: Context): FirebaseAnalytics {
        return FirebaseAnalytics.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideInstallReferrerClient(
        @ApplicationContext context: Context
    ): InstallReferrerClient {
        return InstallReferrerClient.newBuilder(context).build()
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {
        @Singleton
        @Binds
        fun bindPrefs(prefsImpl: PrefsImpl): Prefs

        @Singleton
        @Binds
        fun bindRepository(repoImpl: RepositoryImpl): Repository
    }
}