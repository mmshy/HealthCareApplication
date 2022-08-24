package com.example.healthcareapplication.presentation.screens_and_implementtion.sleep

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.usecase.sleep.SleepUseCases
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
class SleepViewModel @Inject constructor(
    private val useCases: SleepUseCases
) : ViewModel() {

    private val uiState = mutableStateOf(SleepUiState())
    val state: State<SleepUiState> = uiState

    var currentSleep: Sleep? = Constants.currentSleep

    init {

        GlobalScope.launch (Dispatchers.IO) {

            try {
                Firebase.firestore.collection(Constants.KEY_SLEEP_COLLECTION)
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
                val old = event.sleepDetail
                val new = SleepDetail(
                    sleepId = old.sleepId,
                    startTime = old.startTime,
                    status = "Done"
                )

                Log.d("old: ", old.finishTime.toDate().toString())
                Log.d("new: ", new.finishTime.toDate().toString())

                viewModelScope.launch {
                    useCases.updateSleepDetail(old, new)
//                    currentSleep?.sleepList?.remove(old)
//                    currentSleep?.sleepList?.add(new)
//                    Constants.currentSleep?.sleepList?.remove(old)
//                    Constants.currentSleep?.sleepList?.add(new)
                }
            }
        }
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