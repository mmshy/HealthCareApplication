package com.example.healthcareapplication.domain.model

import java.net.IDN

class Meal(
    var totalCalories   : Int = 0,
    var mealList        : List<MealDetail> = emptyList()
    ) : HealthData() {

}