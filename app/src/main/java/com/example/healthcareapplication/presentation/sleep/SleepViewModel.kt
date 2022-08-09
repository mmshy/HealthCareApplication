package com.example.healthcareapplication.presentation.sleep

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.healthcareapplication.domain.service.StorageService
import com.example.healthcareapplication.domain.usecase.sleep.SleepUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SleepViewModel @Inject constructor (
        private val useCases: SleepUseCases
) : ViewModel(){

        private val _state = mutableStateOf(SleepUiState())
        val uiState: State<SleepUiState> = _state

        init {
            // get list
        }

        fun onEvent(event: SleepEvent) {
                when (event) {
                        is SleepEvent.CheckOutItem -> {
                                /*TODO*/
                        }
                }
        }

        private fun getList() {
                /*TODO*/
        }
}