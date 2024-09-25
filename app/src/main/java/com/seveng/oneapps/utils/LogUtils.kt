package com.seveng.oneapps.utils

import android.util.Log

inline fun <reified T> T.log(message: String? = null) {
    Log.d(T::class.java.simpleName, message ?: "throwable.stackTraceToString")
}

inline fun <reified T> T.log(throwable: Throwable? = null) {
    Log.e(T::class.java.simpleName, "${throwable?.stackTraceToString()}", throwable)
}
