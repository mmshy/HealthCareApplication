package com.example.healthcareapplication.presentation.screens_and_implementtion.profile.me

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.healthcareapplication.common.APPLICATION_GRAPH
import com.example.healthcareapplication.common.AUTHENTICATION_GRAPH
import com.example.healthcareapplication.common.HOME_GRAPH
import com.example.healthcareapplication.common.PreferenceManage
import com.example.healthcareapplication.data.dao.UserDAO
import com.example.healthcareapplication.domain.model.InvalidUserException
import com.example.healthcareapplication.domain.model.User
import com.example.healthcareapplication.domain.usecase.user.UserAccessUseCases
import com.example.healthcareapplication.presentation.screens_and_implementtion.register.RegisterEvent
import com.example.healthcareapplication.presentation.screens_and_implementtion.register.RegisterUiState
import com.example.healthcareapplication.presentation.screens_and_implementtion.screen.AuthScreens
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeViewModel @Inject constructor(
    private val useCases: UserAccessUseCases,
    private val prefs: PreferenceManage,
    @ApplicationContext private val mContext: Context,
) : ViewModel() {

    var navController: NavHostController? = null

    private val _uiState = mutableStateOf(MeUiState())
    val uiState: State<MeUiState> = _uiState

    init {
        uiState.value.name = prefs.getUser()!!.name
    }

    fun navigateScreen( route: String){
        navController?.popBackStack()
        navController?.navigate(route = route)
        Toast.makeText(mContext, "me to $route", Toast.LENGTH_SHORT).show()
    }

    fun onEvent(event: MeEvent) {
        when (event) {
            is MeEvent.onPersonalClick -> {

            }

            is MeEvent.onHealthDataClick -> {

            }

            is MeEvent.onSettingClick -> {

            }

            is MeEvent.onLogOut -> {
                Log.d("LogoutTesting", Firebase.auth.currentUser!!.uid )
                Firebase.auth.signOut()
                prefs.clear()
                // navigate veef login di
                //navController?.navigate(AUTHENTICATION_GRAPH)
            }
            else -> {

            }
        }
    }
}