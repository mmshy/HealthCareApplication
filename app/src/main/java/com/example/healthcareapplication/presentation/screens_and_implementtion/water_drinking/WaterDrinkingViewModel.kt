package com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.WaterDrinking
import com.example.healthcareapplication.domain.model.WaterDrinkingDetail
import com.example.healthcareapplication.domain.usecase.waterdrinking.WaterDrinkingUseCases
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class WaterDrinkingViewModel @Inject constructor(
    private val useCases: WaterDrinkingUseCases
) : ViewModel() {

    private val uiState = mutableStateOf(WaterDrinkingUiState())
    val state: State<WaterDrinkingUiState> = uiState


    init {
        GlobalScope.launch(Dispatchers.IO) {

            try {
                Firebase.firestore.collection(Constants.KEY_WATERDRINKING_COLLECTION)
                    .whereEqualTo(
                        "updateDate",
                        SimpleDateFormat("dd/MM/yyyy").format(
                            Timestamp.now().toDate()
                        )
                    )
                    .get()
                    .addOnCompleteListener { it ->
                        if (!it.result.isEmpty) {
                            Constants.currentWaterDrinking =
                                it.result.documents[0].toObject<WaterDrinking>()

                            Log.d("current:", Constants.currentWaterDrinking?.id.toString())
                        } else {

                            Constants.currentWaterDrinking = null
                        }

                        if (Constants.currentWaterDrinking != null) {
                            getList()
                        }
                    }
                    .await()

            } catch (e: Exception) {
                Log.d("get today sleep: ", e.toString())
            }


        }
    }

    fun onEvent(event: WaterDrinkingEvent) {
        when (event) {

            else -> {}
        }
    }

    fun addWaterDetail() {
        Log.d("curr test app: ", Constants.currentWaterDrinking?.id.toString())
        viewModelScope.launch(Dispatchers.IO) {
            // new water detail
            var amount = 0
            if (Constants.currentWaterDrinking?.totalQuantity!! > uiState.value.waterCupSize) {
                amount =
                    Constants.currentWaterDrinking?.totalQuantity?.minus(uiState.value.waterCupSize)!!
            }

            var waterDetail = WaterDrinkingDetail(
                time = Timestamp.now(),
                waterDrinkingId = Constants.currentWaterDrinking!!.id,
                quantities = amount,
            )

            // check if waterD of that day is exited??
            if (Constants.currentWaterDrinking != null) {
                // if yes, add sleep detail into sleepList of sleep
                Log.d("state: ", "update")
                Log.d("state: ", Constants.currentWaterDrinking!!.waterDrinkingList.size.toString())
//                currentSleep?.sleepList?.add(sleepDetail)
                Constants.currentWaterDrinking?.waterDrinkingList?.add(waterDetail)
                useCases.updateWaterDrinkingWithNewDetail(waterDetail)

                Constants.currentWaterDrinking!!.waterDrinkingList.add(waterDetail)
            } else {
                Log.d("state: ", "no amount")

            }
        }
    }

    private fun getList() {

        viewModelScope.launch(Dispatchers.Main) {
            try {
                Log.d("curr: ", Constants.currentWaterDrinking?.id.toString())
                uiState.value =
                    state.value.copy(
                        items = useCases.getWaterDrinkingDetails(Constants.currentWaterDrinking!!.id),
                        amount = Constants.currentWaterDrinking!!.totalQuantity
                    )

            } catch (e: Exception) {
                Log.d(e.message, e.message.toString())
            }
        }

    }

     fun updateWaterDrinkingWithNewDetail250ml() {
        viewModelScope.launch(Dispatchers.Main) {
            if(Constants.currentWaterDrinking == null){
                return@launch
            }
            var incomeValue = 0
            if( Constants.currentWaterDrinking!!.totalQuantity >= 250){
                Constants.currentWaterDrinking!!.totalQuantity -= 250
                incomeValue = 250
            }
            else{
                Constants.currentWaterDrinking!!.totalQuantity = 0
                incomeValue = Constants.currentWaterDrinking!!.totalQuantity

            }
            var newDetail = WaterDrinkingDetail(
                waterDrinkingId = Constants.currentWaterDrinking!!.id,
                quantities = incomeValue,
            )
            Constants.currentWaterDrinking!!.waterDrinkingList.add(newDetail)
            useCases.updateWaterDrinkingWithNewDetail(newDetail)


            getList()
        }
    }

    fun updateWaterDrinkingWithNewDetail500ml() {
        viewModelScope.launch(Dispatchers.Main) {
            if(Constants.currentWaterDrinking == null){
                return@launch
            }
            var incomeValue = 0
            if( Constants.currentWaterDrinking!!.totalQuantity >= 500){
                Constants.currentWaterDrinking!!.totalQuantity -= 500
                incomeValue = 250
            }
            else{
                Constants.currentWaterDrinking!!.totalQuantity = 0
                incomeValue = Constants.currentWaterDrinking!!.totalQuantity

            }
            var newDetail = WaterDrinkingDetail(
                waterDrinkingId = Constants.currentWaterDrinking!!.id,
                quantities = incomeValue,
            )
            Constants.currentWaterDrinking!!.waterDrinkingList.add(newDetail)
            useCases.updateWaterDrinkingWithNewDetail(newDetail)


            getList()
        }
    }

    fun showAddWaterCard() {
        if (!state.value.showAddCard) {
            uiState.value = state.value.copy(showAddCard = true)
        }
    }

    fun unShowAddWaterCard() {
        uiState.value = state.value.copy(showAddCard = false)
    }


}