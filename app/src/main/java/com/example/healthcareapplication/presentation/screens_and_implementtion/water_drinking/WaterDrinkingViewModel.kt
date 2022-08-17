package com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.WaterDrinking
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

        GlobalScope.launch (Dispatchers.IO) {

            try {
                Firebase.firestore.collection("sleeps")
                    .whereEqualTo(
                        "updateDate",
                        SimpleDateFormat("dd/MM/yyyy").format(
                            Timestamp.now().toDate()
                        )
                    )
                    .get()
                    .addOnCompleteListener {
                            it ->
                        if (!it.result.isEmpty) {
                            Constants.currentWaterDrinking = it.result.documents[0].toObject<WaterDrinking>()

                            Log.d("current:" , Constants.currentWaterDrinking ?.id.toString())
                        } else {

                            Constants.currentSleep = null
                        }

                        if (Constants.currentWaterDrinking  != null) {
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

    private fun getList() {

        viewModelScope.launch(Dispatchers.Main) {
            try {
                Log.d("curr: ", Constants.currentSleep?.id.toString())
                uiState.value =
                    state.value.copy(items = useCases.getWaterDrinkingDetails(Constants.currentWaterDrinking!!.id))

            } catch (e: Exception) {
                Log.d(e.message, e.message.toString())
            }
        }

    }


}