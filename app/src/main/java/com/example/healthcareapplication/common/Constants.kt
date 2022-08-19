package com.example.healthcareapplication.common

import com.example.healthcareapplication.domain.model.Sleep

class Constants {
    companion object {
        val KEY_USER_COLLECTION = "users"
        val KEY_SLEEP_COLLECTION: String = "sleeps"
        val KEY_SLEEP_DETAIL_COLLECTION: String = "sleep_details"
        val KEY_MEAL_COLLECTION: String = "meals"

        val KEY_WATERDRINKING_COLLECTION: String = "water_drinkings"
        val KEY_WATERDRINKING_DETAIL_COLLECTION: String = "water_drinking_details"

        val KEY_GOAL_COLLECTION: String = "goals"

        var currentSleep: Sleep? = null
    }
}