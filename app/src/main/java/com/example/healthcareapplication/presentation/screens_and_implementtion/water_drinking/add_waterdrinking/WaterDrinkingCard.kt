package com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking.add_waterdrinking

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import com.example.healthcareapplication.presentation.screens_and_implementtion.sleep.add_sleep.SleepCardViewModel
import java.text.SimpleDateFormat


@SuppressLint("SimpleDateFormat")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaterCard(
    modifier: Modifier,
    viewModel: WaterDrinkingCardViewModel = hiltViewModel()
) {

    val activity = unwrap(LocalContext.current) as AppCompatActivity

    val uiState by viewModel.state
    var amount = uiState.amount

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    start = 46.dp,
                    end = 46.dp,
                    top = 45.dp,
                    bottom = 60.dp
                ),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Add Water",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall
            )

            OutlinedTextField(
                value = amount.toString(),
                onValueChange = {
                    if (it != "")
                        viewModel.onWaterIntakeChange(it.toInt())
                },
                label = { Text(text = "Amount") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
            )

            primaryBtn(
                onClick = { viewModel.addWater() },
                modifier = Modifier
                    .width(155.dp)
                    .height(49.dp)
                    .align(Alignment.CenterHorizontally),
                text = null,
                icon = R.drawable.ic_round_done_24
            )

        }
    }
}

private fun unwrap(context: Context): Activity? {
    var context: Context = context
    while (context !is Activity && context is ContextWrapper) {
        context = context.baseContext
    }
    return context as Activity
}