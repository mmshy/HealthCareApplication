package com.example.healthcareapplication.presentation.screens_and_implementtion.meal.add_meal

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.custom.primaryBtn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealCard(
    modifier: Modifier,
    dialogState: MutableState<Boolean>,
    viewModel: MealCardViewModel = hiltViewModel()
) {

    val activity = unwrap(
        LocalContext.current
    ) as AppCompatActivity

    val uiState by viewModel.state
    var type = uiState.mealType
    var food = uiState.foodCategory
    var amount = uiState.amount
    var calories = uiState.calories


    var mExpanded by remember { mutableStateOf(false) }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    var mExpanded1 by remember { mutableStateOf(false) }

    var mTextFieldSize1 by remember { mutableStateOf(Size.Zero) }

    val icon1 = if (mExpanded1)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

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
                    top = 35.dp,
                    bottom = 45.dp
                ),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Add Meal",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall
            )

            Column(
                modifier = Modifier.padding(top = 32.dp)
            ) {
                OutlinedTextField(
                    value = type.analyticsName,
                    onValueChange = {  },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            mTextFieldSize = coordinates.size.toSize()
                        },
                    label = { Text("Meal Type") },
                    trailingIcon = {
                        Icon(icon, "icon",
                            Modifier.clickable { mExpanded = !mExpanded })
                    },
                    readOnly = true
                )
                DropdownMenu(
                    expanded = mExpanded,
                    onDismissRequest = { mExpanded = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })

                ) {
                    uiState.mealTypeList.forEach { label ->
                        DropdownMenuItem(
                            text = { Text(text = label.analyticsName, color = Color.Black) },
                            onClick = {
                                viewModel.onTypeChange(label)
                                mExpanded = false
                            }
                        )
                    }
                }
            }

            Column(
                modifier = Modifier.padding(top = 27.dp)
            ) {
                OutlinedTextField(
                    value = type.analyticsName,
                    onValueChange = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            mTextFieldSize1 = coordinates.size.toSize()
                        },
                    label = { Text("Food") },
                    trailingIcon = {
                        Icon(icon, "icon",
                            Modifier.clickable { mExpanded = !mExpanded })
                    },
                    readOnly = true
                )
                DropdownMenu(
                    expanded = mExpanded1,
                    onDismissRequest = { mExpanded1 = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { mTextFieldSize1.width.toDp() })

                ) {
                    uiState.mealTypeList.forEach { label ->
                        DropdownMenuItem(
                            text = { Text(text = label.analyticsName, color = Color.Black) },
                            onClick = {
//                                viewModel.onTypeChange(label)
                                mExpanded1 = false
                            }
                        )
                    }
                }
            }

            OutlinedTextField(
                value = amount.toString(),
                onValueChange = { viewModel.onAmountChange(it.toInt()) },
                label = { Text(text = "Weight(gram)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 27.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = calories.toString(),
                onValueChange = { viewModel.onCaloriesChange(it.toInt()) },
                label = { Text(text = "Calories(kcal)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 27.dp, bottom = 45.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            primaryBtn(
                onClick = {
                    viewModel.addMeal()
                    dialogState.value = false
                },
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