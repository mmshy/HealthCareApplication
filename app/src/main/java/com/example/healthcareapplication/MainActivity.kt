package com.example.healthcareapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.healthcareapplication.common.PreferenceManage
import com.example.healthcareapplication.di.AppModule
import com.example.healthcareapplication.presentation.components.ForgotPasswordScreen
import com.example.healthcareapplication.presentation.components.LoginScreen
import com.example.healthcareapplication.presentation.components.MainScreen
import com.example.healthcareapplication.presentation.components.RegisterScreen
import com.example.healthcareapplication.presentation.components.screens.DashboardScreen
import com.example.healthcareapplication.presentation.nav_graph.HomeNavGraph
import com.example.healthcareapplication.presentation.nav_graph.MainNavGraph
import com.example.healthcareapplication.presentation.ui.theme.HealthCareApplicationTheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity(

) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(PreferenceManage(this).getUser() != null){
            setContent {
                HealthCareApplicationTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        HomeNavGraph(navController = rememberNavController())
                    }
                }
            }
        }
        else{
            setContent {
                HealthCareApplicationTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MainNavGraph(navController = rememberNavController())
                    }
                }
            }
        }

    }
}


@Composable
fun Greeting() {
    var name by remember {
        mutableStateOf("")
    }

    Column() {
        Text(
            text = "Hello, $name",
            style = MaterialTheme.typography.headlineLarge
        )
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text(text = "Name")},
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.Person, contentDescription = "")
                }
            }
        )
    }
}

@Composable
fun Calculator(
    quantity: Int,
    increase: () -> Unit,
    decrease: () -> Unit
) {
    Row() {
        Button(onClick = increase) {
            Text(text = "-")
        }
        Text(text = quantity.toString())
        Button(onClick = decrease) {
            Text(text = "+")
        }
    }
}

@Composable
fun ScrollBoxes() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .size(100.dp)
            .verticalScroll(rememberScrollState())
    ) {
        repeat(10) {
            Text("Item $it", modifier = Modifier.padding(2.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(
) {
    HealthCareApplicationTheme {
        MainScreen()
    }
}