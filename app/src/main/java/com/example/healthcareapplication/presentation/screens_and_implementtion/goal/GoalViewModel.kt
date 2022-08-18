package com.example.healthcareapplication.presentation.screens_and_implementtion.goal

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoalViewModel @Inject constructor(

): ViewModel() {

    private val uiState = mutableStateOf(GoalUiState())
    val state: State<GoalUiState> = uiState

    init {

    }

    fun showAddGoalCard() {
        if (!state.value.showAddCard) {
            uiState.value = state.value.copy(showAddCard = true)
        }
    }

    fun unShowAddGoalCard() {
//        if (state.value.showAddCard) {
        uiState.value = state.value.copy(showAddCard = false)
//        }
    }
}