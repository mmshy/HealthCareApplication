package com.example.healthcareapplication.presentation.screens_and_implementtion.meal.add_meal

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.*
import com.example.healthcareapplication.domain.usecase.meal.MealUseCases
import com.google.firebase.Timestamp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class MealCardViewModel @Inject constructor(
    private val useCases: MealUseCases
): ViewModel() {

    private val uiState = mutableStateOf(MealCardUiState())
    val state: State<MealCardUiState> = uiState

    private var currentMeal: Meal? = null

    init {

        currentMeal = Constants.currentMeal

        uiState.value = state.value.copy(
            mealTypeList = MealType.values().reversed()
        )
    }

    fun onTypeChange(newValue: MealType) {
        uiState.value = state.value.copy(mealType = newValue)
    }

    fun onFoodCategoryChange(newValue: FoodCategory) {
        uiState.value = state.value.copy(foodCategory = newValue)
    }

    fun onAmountChange(newValue: Int) {
        uiState.value = state.value.copy(amount = newValue)
    }

    fun onCaloriesChange(newValue: Int) {
        uiState.value = state.value.copy(calories = newValue)
    }

    fun addMeal() {
        viewModelScope.launch(Dispatchers.IO) {

            if (currentMeal != null) {
                Log.d("state: ", "update")
                var mealDetail = MealDetail(
                    mealId = currentMeal!!.id,
                    mealType = uiState.value.mealType
                )

                // TODO: update Meal
                useCases.addMealDetail(mealDetail)

                // TODO: add meal Detail

                // TODO: update current Meal

            } else {
                Log.d("state: ", "add new")

                var meal = Meal()
                meal.updateDate = SimpleDateFormat("dd/MM/yyyy").format(Timestamp.now().toDate())
                useCases.addMeal(meal)

                // TODO: create a meal detail
                val mealDetail = MealDetail(
                    mealId = meal.id,
                    mealType = uiState.value.mealType
                )

                useCases.addMealDetail(mealDetail)

                // TODO: update Meal

                // TODO: update current Meal
            }
        }
    }
}