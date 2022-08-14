package com.example.healthcareapplication.presentation.sleep

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.service.StorageService
import com.example.healthcareapplication.domain.usecase.sleep.SleepUseCases
import com.example.healthcareapplication.presentation.login.LoginUiState
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.io.Console
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class SleepViewModel @Inject constructor(
    private val useCases: SleepUseCases
) : ViewModel() {

    private val uiState = mutableStateOf(SleepUiState())
    val state: State<SleepUiState> = uiState

    var currentSleep: Sleep? = Constants.currentSleep

    init {

        GlobalScope.launch (Dispatchers.IO) {

            try {
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
                            Constants.currentSleep = currentSleep
                            Log.d("current:" , currentSleep?.id.toString())
                        } else {
                            currentSleep = null
                            Constants.currentSleep = null
                        }

                        if (currentSleep != null) {
                            getList()
                        }

                    }
                    .await()

            } catch (e: Exception) {
                Log.d("get today sleep: ", e.toString())
            }
        }

    }

    fun onEvent(event: SleepEvent) {
        when (event) {
            is SleepEvent.CheckOutItem -> {
                /*TODO*/
            }
        }
    }

    fun showAddSleepCard() {
        if (!state.value.showAddCard) {
            uiState.value = state.value.copy(showAddCard = true)
        }
    }

    fun unShowAddSleepCard() {
//        if (state.value.showAddCard) {
            uiState.value = state.value.copy(showAddCard = false)
//        }
    }

    private fun getList() {

        viewModelScope.launch(Dispatchers.Main) {

            try {

//                if (currentSleep != null) {
                Log.d("curr: ", Constants.currentSleep?.id.toString())
                    uiState.value = state.value.copy(items = useCases.getSleepDetails(currentSleep!!.id))
//                }

            } catch (e: Exception) {
                Log.d(e.message, e.message.toString())
            }
        }

    }
}