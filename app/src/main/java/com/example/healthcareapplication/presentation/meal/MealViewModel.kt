package com.example.healthcareapplication.presentation.meal

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.test.services.events.TimeStamp
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.MealType
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.usecase.meal.MealUseCases
import com.example.healthcareapplication.presentation.sleep.SleepEvent
import com.google.firebase.Timestamp.now
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val useCases: MealUseCases
) : ViewModel()
{
    var uiState = mutableStateOf(MealUiState())

    init {
        getList()
    }

    fun onEvent(event: MealEvent) {
        when (event) {
            is MealEvent.addMeal-> {
               viewModelScope.launch{

               }
            }
        }
    }

    fun addMeal() {
        viewModelScope.launch {
            useCases.addMeal(Meal(totalCalories = 10f, MealType(), userID = "test"))
        }
    }


    fun getList() {
        var sb = StringBuilder()

        viewModelScope.launch {
            try {
                val a = Firebase.firestore
                    .collection(Constants.KEY_MEAL_COLLECTION)
                    .get().await()
                for (item in a.documents) {
                    val meal = item.toObject<Meal>()
                    sb.append("${meal?.totalCalories}\n")
                }

                uiState.value = uiState.value.copy(greeting = sb.toString())

            } catch (e: Exception) {
                Log.d(e.message, e.message.toString())
            }
        }

    }
}