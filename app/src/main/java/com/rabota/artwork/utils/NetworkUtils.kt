package com.rabota.artwork.utils

import okio.IOException
import retrofit2.Response

object NetworkUtils {
    /**
     *  Safe API call with mapper of [Response]
     *  @param mapper mapper of [Response]
     *  @param apiCall api call returning [Response]
     *  @return [Result] of [T] - mapped body of [Response]
     */
    suspend fun <T, R, E> safeApiCall(
        @Suppress("UNCHECKED_CAST")
        mapper: (E) -> T = { it as T },
        apiCall: suspend () -> R,
    ): Result<T> where T : Any, R : Response<E> {
        return try {
            Result.success(mapper(apiCall().body() ?: throw IOException()))
        } catch (e: Exception) {
            log(e)
            Result.failure(e)
        }
    }
}