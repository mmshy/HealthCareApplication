package com.example.healthcareapplication.presentation.screens_and_implementtion.goal.add_goal

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.domain.model.Goal
import com.example.healthcareapplication.domain.usecase.goal.GoalUseCases
import com.example.healthcareapplication.presentation.screens_and_implementtion.goal.GoalStatus
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime.ofInstant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class GoalCardViewModel @Inject constructor(
    private val useCases: GoalUseCases
) : ViewModel() {

    private val uiState = mutableStateOf(GoalCardUiState())
    val state: State<GoalCardUiState> = uiState

    init {
        uiState.value = state.value.copy(
            goalTypeList = listOf(
                GoalType.LOSE_WEIGHT,
                GoalType.GAIN_WEIGHT,
                GoalType.WATER_DRINKING
            )
        )
    }

    private val datePicker = MaterialDatePicker
        .Builder.datePicker()
        .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
        .setTitleText("select")
        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        .build()

    private val datePicker2 = MaterialDatePicker
        .Builder.datePicker()
        .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
        .setTitleText("select")
        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        .build()

    fun showStartDatePicker(activity: AppCompatActivity) {
        datePicker.show(activity.supportFragmentManager, datePicker.tag)

        datePicker.addOnPositiveButtonClickListener { it ->
            val date = ofInstant(Instant.ofEpochMilli(it), ZoneId.systemDefault())
            val timeStamp =
                Timestamp.valueOf(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))

            uiState.value = state.value.copy(startDate = com.google.firebase.Timestamp(timeStamp))
        }
    }

    fun showEndDatePicker(activity: AppCompatActivity) {
        datePicker2.show(activity.supportFragmentManager, datePicker2.tag)

        datePicker2.addOnPositiveButtonClickListener { it ->
            val date = ofInstant(Instant.ofEpochMilli(it), ZoneId.systemDefault())
            val timeStamp =
                Timestamp.valueOf(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))

            uiState.value = state.value.copy(endDate = com.google.firebase.Timestamp(timeStamp))
        }
    }

    fun onNameChange(newValue: String) {
        uiState.value = state.value.copy(name = newValue)
    }

    fun onContentChange(newValue: Int) {
        uiState.value = state.value.copy(content = newValue)
    }

    fun onTypeChange(newValue: GoalType) {
        uiState.value = state.value.copy(goalType = newValue)
    }

    fun addGoal() {
        val goal = Goal(
            name = uiState.value.name,
            type = uiState.value.goalType.toString(),
            content = uiState.value.content,
            status = GoalStatus.DOING.toString(),
            startDate = uiState.value.startDate,
            finishDate = uiState.value.endDate,
        )

        viewModelScope.launch {
            useCases.addGoal(goal)
        }

        //close dialog
    }
}