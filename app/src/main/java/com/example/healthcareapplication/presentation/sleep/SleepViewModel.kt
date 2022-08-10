package com.example.healthcareapplication.presentation.sleep

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.service.StorageService
import com.example.healthcareapplication.domain.usecase.sleep.SleepUseCases
import com.example.healthcareapplication.presentation.login.LoginUiState
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.Console
import javax.inject.Inject

@HiltViewModel
class SleepViewModel @Inject constructor(
    private val useCases: SleepUseCases
) : ViewModel() {

    var uiState = mutableStateOf(SleepUiState())

    init {
//         getList()
    }

    fun onEvent(event: SleepEvent) {
        when (event) {
            is SleepEvent.CheckOutItem -> {
                /*TODO*/
            }
        }
    }

    fun addSleep() {
        viewModelScope.launch {
            useCases.addSleep(Sleep(2))
        }
    }

    fun getList() {

//        var list: List<Sleep> = emptyList()

        var sb = StringBuilder()

        viewModelScope.launch {
            try {
                val a = Firebase.firestore
                    .collection("users")
                    .get().await()

                for (item in a.documents) {
                    val sleep = item.toObject<Sleep>()
                    sb.append("${sleep?.totalTime}\n")
                }

                uiState.value = uiState.value.copy(greeting = sb.toString())

            } catch (e: Exception) {
                Log.d(e.message, e.message.toString())
            }
        }

    }
}