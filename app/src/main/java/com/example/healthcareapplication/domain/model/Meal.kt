package com.example.healthcareapplication.domain.model

import java.net.IDN

class Meal(
    //var mealID      : String = "",
    var calories    : Float = 0F,
    var weight      : Float = 0F,
    var foodCategory: FoodCategory = FoodCategory()
) : HealthData() {
    fun todo() {
        println("Hello " + this.weight + this.foodCategory.name)
    }
}