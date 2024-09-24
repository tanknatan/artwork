package com.rabota.artwork.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("json.php")
    suspend fun getProducts(
        @Query("referrer") referrer: String,
        @Query("firebaseid") firebaseId: String,
        @Query("country") country: String
    ): Response<List<ProductInfoDto>>
}