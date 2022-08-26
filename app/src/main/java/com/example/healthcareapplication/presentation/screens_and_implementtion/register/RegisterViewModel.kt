package com.example.healthcareapplication.presentation.screens_and_implementtion.register

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.healthcareapplication.common.PreferenceManage
import com.example.healthcareapplication.data.dao.UserDAO
import com.example.healthcareapplication.domain.model.InvalidUserException
import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.usecase.user.UserAccessUseCases
import com.google.firebase.firestore.ktx.toObject
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val useCases: UserAccessUseCases,
    private val prefs: PreferenceManage,
    @ApplicationContext private val mContext: Context
) : ViewModel() {

    var navController: NavHostController? = null

    private val _uiState = mutableStateOf(RegisterUiState())
    val uiState: State<RegisterUiState> = _uiState


    init {

    }

    fun onEmailChange(newValue: String) {
        _uiState.value = uiState.value.copy(
            email = newValue
        )
    }

    fun onNameChange(newValue: String) {
        _uiState.value = uiState.value.copy(
            name = newValue
        )
    }

    fun onPasswordChange(newValue: String) {
        _uiState.value = uiState.value.copy(
            password = newValue
        )
    }

    fun onConfirmPasswordhange(newValue: String) {
        _uiState.value = uiState.value.copy(
            confirmPassword = newValue
        )
    }


    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.CreateUser -> {
                viewModelScope.launch {
                    if (uiState.value.password == uiState.value.confirmPassword
                        && uiState.value.email != ""
                        && uiState.value.name != ""
                    ) {
                        val user = User(
                            email = _uiState.value.email,
                            name = _uiState.value.name,
                            password = _uiState.value.password
                        )
                        try {
                            useCases.createAccount(user)
                            prefs.putUser(user)

                            navController?.navigate(route = "home_graph")
                        } catch (e: InvalidUserException) {

                        }
                    }
                }
            }
            else -> {

            }
        }
    }
}
