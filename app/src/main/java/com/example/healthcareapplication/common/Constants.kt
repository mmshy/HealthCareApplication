package com.example.healthcareapplication.common

import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.WaterDrinking

class Constants {
    companion object {
        const val dateFormat: String = "dd/MM/yyyy"
        const val KEY_USER_COLLECTION = "users"
        const val KEY_SLEEP_COLLECTION: String = "sleeps"
        const val KEY_SLEEP_DETAIL_COLLECTION: String = "sleep_details"
        const val KEY_MEAL_COLLECTION: String = "meals"

        const val KEY_WATERDRINKING_COLLECTION: String = "water_drinkings"
        const val KEY_WATERDRINKING_DETAIL_COLLECTION: String = "water_drinking_details"

        val KEY_GOAL_COLLECTION: String = "goals"

        var currentSleep: Sleep? = null
        var currentWaterDrinking: WaterDrinking? = null
    }
}