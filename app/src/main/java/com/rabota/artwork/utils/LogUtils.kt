package com.rabota.artwork.utils

import android.util.Log

object LogUtils {
    inline fun <reified T> T.log(message: String? = null) {
        Log.d(T::class.java.simpleName, message ?: "$this")
    }

    inline fun <reified T> T.log(throwable: Throwable? = null) {
        Log.e(T::class.java.simpleName, "$this", throwable)
    }
}