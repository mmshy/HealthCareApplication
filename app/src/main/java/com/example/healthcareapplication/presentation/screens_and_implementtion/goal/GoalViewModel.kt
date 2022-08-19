package com.example.healthcareapplication.presentation.screens_and_implementtion.goal

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.domain.usecase.goal.GoalUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalViewModel @Inject constructor(
    private val useCase: GoalUseCases
): ViewModel() {

    private val uiState = mutableStateOf(GoalUiState())
    val state: State<GoalUiState> = uiState

    init {
        getGoals()
    }

    fun showAddGoalCard() {
        if (!state.value.showAddCard) {
            uiState.value = state.value.copy(showAddCard = true)
        }
    }

    fun unShowAddGoalCard() {
        uiState.value = state.value.copy(showAddCard = false)
    }

    fun onDoingClick() {
        // change from secondary btn to primary btn
            uiState.value = state.value.copy(status = GoalStatus.DOING)
        // get list doing
        getGoals()
    }

    fun onCompleteClick() {
        // change from secondary btn to primary btn
            uiState.value = state.value.copy(status = GoalStatus.COMPLETE)
        // get list complete
        getGoals(goalStatus = GoalStatus.COMPLETE)
    }

    private fun getGoals(goalStatus: GoalStatus = GoalStatus.DOING) {
        // if onDoing show list doing, if complete show list complete
        viewModelScope.launch {
            var list = useCase.getGoals(goalStatus)
        }
    }
}