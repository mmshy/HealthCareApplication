package com.example.healthcareapplication.domain.model

class TrackingDetail (
    var trackingID          : String = "",
    var sleepList           : MutableList<Sleep> = mutableListOf(),
    var mealList            : MutableList<Meal> = mutableListOf(),
    var waterDrinkingList   : MutableList<WaterDrinking> = mutableListOf(),
    var weightList          : MutableList<Weight> = mutableListOf(),
    var periodList          : MutableList<Period> = mutableListOf()

    ){

}