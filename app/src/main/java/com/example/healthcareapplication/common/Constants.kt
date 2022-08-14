package com.example.healthcareapplication.common

import com.example.healthcareapplication.domain.model.Sleep

class Constants {
    companion object {
        val KEY_USER_COLLECTION = "users"
        val KEY_SLEEP_COLLECTION: String = "sleeps"
        val KEY_SLEEP_DETAIL_COLLECTION: String = "sleep_details"
        val KEY_MEAL_COLLECTION: String = "meals"

        var currentSleep: Sleep? = null
    }
}