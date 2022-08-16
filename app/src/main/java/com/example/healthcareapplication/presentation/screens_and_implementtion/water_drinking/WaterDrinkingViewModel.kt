package com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.usecase.sleep.SleepUseCases
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

            /*try {
                Firebase.firestore.collection("sleeps")
                    .whereEqualTo(
                        "updateDate",
//                        "14:14",
                        SimpleDateFormat("dd/MM/yyyy").format(
                            Timestamp.now().toDate()
                        )
                    )
                    .get()
                    .addOnCompleteListener {
                        it ->
                        if (!it.result.isEmpty) {
                            currentSleep = it.result.documents[0].toObject<Sleep>()
                            Log.d("current:" , currentSleep?.id.toString())
                        }

                        if (currentSleep != null) {
                            getList()
                        }

                    }
                    .await()

            } catch (e: Exception) {
                Log.d("get today sleep: ", e.toString())
            }*/
        }

    }

    fun onEvent(event: WaterDrinkingEvent) {
        when (event) {

        }
    }


}