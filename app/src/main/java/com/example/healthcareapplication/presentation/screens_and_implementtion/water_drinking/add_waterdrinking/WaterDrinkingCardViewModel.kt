package com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking.add_waterdrinking

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.common.PreferenceHelper.customPreference
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.model.WaterDrinking
import com.example.healthcareapplication.domain.model.WaterDrinkingDetail
import com.example.healthcareapplication.domain.usecase.waterdrinking.WaterDrinkingUseCases
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.google.firebase.Timestamp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WaterDrinkingCardViewModel @Inject constructor(
    private val useCases: WaterDrinkingUseCases
) : ViewModel() {

    private val uiState = mutableStateOf(WaterDrinkingCardUiState())
    val state: State<WaterDrinkingCardUiState> = uiState

    //private var currentWaterDrinking: WaterDrinking? = null

    private val timePicker = MaterialTimePicker
        .Builder()
        .setTimeFormat(TimeFormat.CLOCK_24H)
        .setInputMode(MaterialTimePicker.INPUT_MODE_KEYBOARD)
        .setTitleText("Start")
        .build()

    init {
        //currentWaterDrinking = Constants.currentWaterDrinking

        if (Constants.currentWaterDrinking != null) {
            uiState.value.amount =
                Constants.currentWaterDrinking!!.totalQuantity
        }

    }


    fun onWaterIntakeChange(newValue: Int) {
        uiState.value = uiState.value.copy(amount = newValue)
        if (Constants.currentWaterDrinking == null) {
            var water = WaterDrinking(
                totalQuantity = uiState.value.amount
            )
            water.updateDate = SimpleDateFormat("dd/MM/yyyy").format(Timestamp.now().toDate())
            Constants.currentWaterDrinking = water
        }
        Constants.currentWaterDrinking!!.totalQuantity = newValue
    }

    //add sleep
    fun addWater() {
        Log.d("curr test app: ", Constants.currentWaterDrinking?.id.toString())
        viewModelScope.launch(Dispatchers.IO) {

            // check if waterD of that day is exited??
            if (Constants.currentWaterDrinking != null) {
                Constants.currentWaterDrinking!!.updateDate =
                    SimpleDateFormat("dd/MM/yyyy").format(Timestamp.now().toDate())
                useCases.updateWaterDrinking(Constants.currentWaterDrinking!!)
            } else {
                Log.d("state: ", "add new")
                // if no, create a new sleep and sleep detail add into a sleepList of new sleep
                // new water detail
                var water = WaterDrinking(
                    totalQuantity = uiState.value.amount
                )
                water.updateDate = SimpleDateFormat("dd/MM/yyyy").format(Timestamp.now().toDate())

                useCases.addWaterDrinking(water)

                // update state of sleep
                Constants.currentWaterDrinking = water
                Log.d("current: ", Constants.currentWaterDrinking?.id.toString())
            }

        }
    }


}