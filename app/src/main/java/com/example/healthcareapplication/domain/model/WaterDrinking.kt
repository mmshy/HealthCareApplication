package com.example.healthcareapplication.domain.model

class WaterDrinking (
    //var waterDrinkingID : String = "",
    var totalQuantity        : Float = 0.0f,
    var waterDrinkingList:  MutableList<WaterDrinkingDetail> = mutableListOf()
): HealthData(){

}
