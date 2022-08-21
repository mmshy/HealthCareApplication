package com.example.healthcareapplication.domain.model

class WaterDrinking (
    var totalQuantity        : Int = 0,
    var waterDrinkingList:  MutableList<WaterDrinkingDetail> = mutableListOf()
): HealthData(){

}
