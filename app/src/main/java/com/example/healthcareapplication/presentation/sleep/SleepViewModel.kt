package com.example.healthcareapplication.presentation.sleep

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private var currentSleep: Sleep? = null

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
                            Log.d("current:" , currentSleep?.id.toString())
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

    fun addSleep() {
        viewModelScope.launch(Dispatchers.IO) {

            // check if sleep of that day is exited??
            if (currentSleep != null) {
                // if yes, add sleep detail into sleepList of sleep
                Log.d("state: ", "update")
                var sleepDetail = SleepDetail(
                    startTime = Timestamp.now(),
                    sleepId = currentSleep!!.id
                )
                currentSleep?.sleepList?.add(sleepDetail)
                useCases.updateSleep(currentSleep!!)
            } else {
                Log.d("state: ", "add new")
                // if no, create a new sleep and sleep detail add into a sleepList of new sleep
                var sleep = Sleep()
                sleep.updateDate = SimpleDateFormat("dd/MM/yyyy").format(Timestamp.now().toDate())
                useCases.addSleep(sleep)

                var sleepDetail = SleepDetail(
                    startTime = Timestamp.now(),
                    sleepId = sleep.id
                )

                // update sleepList of sleep
                sleep.sleepList.add(sleepDetail)
                useCases.updateSleep(sleep)

                // update state of sleep
                currentSleep = sleep
            }

        }
    }

    private fun getList() {

        viewModelScope.launch(Dispatchers.Main) {

            try {

//                if (currentSleep != null) {
                    uiState.value = state.value.copy(items = useCases.getSleepDetails(currentSleep!!.id))
//                }

            } catch (e: Exception) {
                Log.d(e.message, e.message.toString())
            }
        }

    }
}