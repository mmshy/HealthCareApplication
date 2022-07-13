package com.example.healthcareapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthcareapplication.presentation.ui.theme.HealthCareApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthCareApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting()
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
        Text(text = "Hello, $name")
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text(text = "Name")}
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
fun DefaultPreview() {
    HealthCareApplicationTheme {
        Image(painterResource(id = R.drawable.shark_sleep), "")
    }
}