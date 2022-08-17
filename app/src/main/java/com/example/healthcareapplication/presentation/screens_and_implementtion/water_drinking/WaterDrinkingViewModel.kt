package com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.healthcareapplication.domain.usecase.waterdrinking.WaterDrinkingUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
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