package com.rabota.artwork.domain


interface Repository {
    var startStepCompleted: Boolean
    var eighteenOver : Boolean

    suspend fun getProducts(): Result<List<ProductInfo>>
}