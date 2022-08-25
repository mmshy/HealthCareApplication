package com.example.healthcareapplication.presentation.screens_and_implementtion.login

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.healthcareapplication.common.*
import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.usecase.user.UserAccessUseCases
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCases: UserAccessUseCases,
    private val prefs: PreferenceManage,
    @ApplicationContext private val mContext: Context,
) : ViewModel() {


    var navController: NavHostController? = null

    var uiState = mutableStateOf(LoginUiState())

    init {
        if(prefs.getUser() != null){
            navigateScreen()
        }
    }

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }


    fun navigateScreen(){
        navController?.popBackStack()
        navController?.navigate(route = "home_graph")
        Toast.makeText(mContext, "let me in pls", Toast.LENGTH_SHORT).show()
    }
    fun onLoginEvent() {

        //check valid email
        /*TODO*/

        //check valid password
        /*TODO*/

        viewModelScope.launch {

            useCases.authenticate(
                email = uiState.value.email,
                password = uiState.value.password
            ) { error ->
                if (error == null) {

                    Firebase.firestore.collection(Constants.KEY_USER_COLLECTION)
                        .whereEqualTo(
                            "userID",
                            Firebase.auth.currentUser?.uid
                        )
                        .get()
                        .addOnCompleteListener() { it ->
                            if (!it.result.isEmpty) {
                                prefs.putUser(
                                    it.result.documents[0].toObject<User>()
                                )
                                Log.d("current:", prefs.getUser()?.userID.toString())
                            }
                            /*TODO: open main screen*/
                           navigateScreen()
                            /*TODO: show error*/

                        }


                }
                else{
                    Toast.makeText(mContext, "wrong email or password", Toast.LENGTH_SHORT).show()
                }
            }

            fun openRegisterScreen() {

            }

            fun openForgotPasswordScreen() {

            }
        }
    }
}