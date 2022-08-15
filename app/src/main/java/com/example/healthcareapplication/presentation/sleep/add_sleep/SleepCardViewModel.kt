package com.example.healthcareapplication.presentation.sleep.add_sleep

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthcareapplication.common.Constants
import com.example.healthcareapplication.domain.model.Sleep
import com.example.healthcareapplication.domain.model.SleepDetail
import com.example.healthcareapplication.domain.usecase.sleep.SleepUseCases
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.google.firebase.Timestamp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.time.Duration.Companion.hours

@HiltViewModel
class SleepCardViewModel @Inject constructor (
    private val useCases: SleepUseCases
): ViewModel() {
    private val uiState = mutableStateOf(SleepCardUiState())
    val state: State<SleepCardUiState> = uiState

    private var currentSleep: Sleep? = null

    private val timePicker = MaterialTimePicker
        .Builder()
        .setTimeFormat(TimeFormat.CLOCK_24H)
        .setInputMode(MaterialTimePicker.INPUT_MODE_KEYBOARD)
        .setTitleText("Start")
        .build()

//    var activity: AppCompatActivity? = null

    init {
        currentSleep = Constants.currentSleep
    }

    fun onNoteChange(newValue: String) {
        uiState.value = uiState.value.copy(note = newValue)
    }


    //show time picker
    fun showTimePicker(activity: AppCompatActivity) {

        timePicker.show(activity.supportFragmentManager, timePicker.toString())

        timePicker.addOnPositiveButtonClickListener {
            val combinedCal: Calendar = GregorianCalendar(TimeZone.getTimeZone("GMT+7"))
            combinedCal.set(Calendar.HOUR_OF_DAY, timePicker.hour);
            combinedCal.set(Calendar.MINUTE, timePicker.minute);

            var time = Timestamp(combinedCal.time)
            Log.d("get time: ", time.toDate().toString())

            uiState.value = state.value.copy(startTime = time)
        }
    }

    //add sleep
    fun addSleep() {
        Log.d("curr test app: ", Constants.currentSleep?.id.toString())
        viewModelScope.launch(Dispatchers.IO) {

            // check if sleep of that day is exited??
            if (currentSleep != null) {
                // if yes, add sleep detail into sleepList of sleep
                Log.d("state: ", "update")
                var sleepDetail = SleepDetail(
                    startTime = uiState.value.startTime,
                    sleepId = currentSleep!!.id
                )
                Log.d("state: ", currentSleep!!.sleepList.size.toString())
//                currentSleep?.sleepList?.add(sleepDetail)
                useCases.updateSleep(sleepDetail)

                currentSleep!!.sleepList.add(sleepDetail)
                Constants.currentSleep = currentSleep
            } else {
                Log.d("state: ", "add new")
                // if no, create a new sleep and sleep detail add into a sleepList of new sleep
                var sleep = Sleep()
                sleep.updateDate = SimpleDateFormat("dd/MM/yyyy").format(Timestamp.now().toDate())
                useCases.addSleep(sleep)

                var sleepDetail = SleepDetail(
                    startTime = uiState.value.startTime,
                    sleepId = sleep.id
                )

                // update sleepList of sleep
//                sleep.sleepList.add(sleepDetail)
                useCases.updateSleep(sleepDetail)

                // update state of sleep
                currentSleep = sleep
                Constants.currentSleep = sleep
                currentSleep!!.sleepList.add(sleepDetail)
                Constants.currentSleep = currentSleep
                Log.d("current: ", Constants.currentSleep?.id.toString())
            }
        }
    }
}