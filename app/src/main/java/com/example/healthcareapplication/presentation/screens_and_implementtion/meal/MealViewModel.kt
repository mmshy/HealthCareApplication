package com.example.healthcareapplication.presentation.screens_and_implementtion.meal

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.Meal
import com.example.healthcareapplication.domain.model.MealDetail
import com.example.healthcareapplication.domain.model.MealType
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.usecase.meal.MealUseCases
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val useCases: MealUseCases
) : ViewModel() {
    private val uiState = mutableStateOf(MealUiState())
    val state: State<MealUiState> = uiState

    var currentMeal: Meal? = Constants.currentMeal

    init {
        GlobalScope.launch(Dispatchers.IO) {

            try {
                Firebase.firestore.collection(Constants.KEY_MEAL_COLLECTION)
                    .whereEqualTo(
                        "updateDate",
                        SimpleDateFormat("dd/MM/yyyy").format(
                            Timestamp.now().toDate()
                        )
                    )
                    .get()
                    .addOnCompleteListener { it ->
                        if (!it.result.isEmpty) {
                            currentMeal = it.result.documents[0].toObject<Meal>()
                            Constants.currentMeal = currentMeal
                            Log.d("current:", currentMeal?.id.toString())
                        } else {
                            Log.d("curr:", "empty")
                            currentMeal = null
                            Constants.currentMeal = null
                        }

                        if (currentMeal != null) {
                            getListByType(null)
                        }

                    }
                    .await()

            } catch (e: Exception) {
                Log.d("get today sleep: ", e.toString())
            }
        }
    }

    fun getList() {
        viewModelScope.launch(Dispatchers.Main) {
//            uiState.value = state.value.copy(items = useCases.getMealDetails(currentMeal!!, null))
        }
    }

    private fun getListByType(type: MealType?) {

        viewModelScope.launch(Dispatchers.Main) {
            if (type != null) {
//                uiState.value = state.value.copy(items = useCases.getMealDetails(currentMeal!!, type))
            } else {

                var result = mutableListOf<List<MealDetail>>()
                for (i in MealType.values()) {
                    var list = mutableListOf<MealDetail>()
                    useCases.getMealDetails(currentMeal!!, i).forEach { item -> list.add(item) }
                    Log.d("list: ", list.size.toString())
                    if (list.isNotEmpty()) {
                        result.add(list)
                        Log.d("result: ", result[0].toString())
                    }
                }

                Log.d("result: ", result[0].toString())
                uiState.value = state.value.copy(items = result)
            }
        }
    }
}