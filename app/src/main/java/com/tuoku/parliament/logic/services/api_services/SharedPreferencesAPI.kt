package com.tuoku.parliament.logic.services.api_services

import android.content.SharedPreferences

object SharedPreferencesAPI {

    private lateinit var prefs: SharedPreferences

    fun setFile(file:SharedPreferences){
        prefs = file
    }

    fun setMillis(millis:Long){
        with (prefs.edit()){
            putLong("lastMillis",millis)
            apply()
        }
    }

    fun getMillis(): Long {
        return prefs.getLong("lastMillis", 0)
    }
}