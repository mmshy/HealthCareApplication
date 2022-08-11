package com.example.healthcareapplication.domain.model

import java.net.IDN

class Meal(
    var totalCalories   : Float = 0f,
    var mealType        : MealType = MealType(),
    var userID          : String = ""
    ) : HealthData() {

}