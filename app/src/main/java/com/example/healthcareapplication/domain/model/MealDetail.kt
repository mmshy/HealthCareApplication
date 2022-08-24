package com.example.healthcareapplication.domain.model

class MealDetail(
    var id          : String = "",
    var mealId      : String = "",
    var calories    : Int = 0,
    var weight      : Int = 0,
    var mealType    : MealType = MealType.BREAKFAST,
    var foodCategory: FoodCategory = FoodCategory()
    ) {

}