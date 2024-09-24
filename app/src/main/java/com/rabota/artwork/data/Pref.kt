package com.rabota.artwork.data


import android.content.Context
import android.content.SharedPreferences
import com.rabota.artwork.domain.Prefs
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PrefsImpl @Inject constructor(@ApplicationContext context: Context): Prefs {
    private val prefs: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_START_STEP_COMPLETED = "StartStepCompleted"
    }


    override var startStepCompleted: Boolean
        get() = prefs.getBoolean(KEY_START_STEP_COMPLETED, false)
        set(value) {
            prefs.edit().putBoolean(KEY_START_STEP_COMPLETED, value).apply()
        }

    override var eighteenOver : Boolean
        get() = prefs.getBoolean("EighteenOver", false)
        set(value) {
            prefs.edit().putBoolean("EighteenOver", value).apply()
        }


}