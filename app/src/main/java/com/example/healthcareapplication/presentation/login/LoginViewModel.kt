package com.example.healthcareapplication.presentation.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.healthcareapplication.domain.usecase.UserAccessUseCases
import com.google.firebase.auth.EmailAuthProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCases: UserAccessUseCases
): ViewModel() {

    var navController: NavHostController? = null

    var uiState = mutableStateOf(LoginUiState())

    init {
        /*TODO*/
    }

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun onLoginEvent() {

        //check valid email
        /*TODO*/

        //check valid password
        /*TODO*/

        viewModelScope.launch {

            navController?.navigate(route = "home_graph")

            // check if account exist
            /*useCases.authenticate(
                email = uiState.value.email,
                password = uiState.value.password
            ) { error ->
                if (error == null) {
                    *//*TODO: open main screen*//*
                    navController.navigate(route = "home_graph")
                }
                else {
                    *//*TODO: show error*//*
                }
            }*/

        }
    }

    fun openRegisterScreen() {

    }

    fun openForgotPasswordScreen() {

    }
}