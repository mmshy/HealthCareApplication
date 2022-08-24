package com.example.healthcareapplication.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.healthcareapplication.R
import com.example.healthcareapplication.domain.model.MealType
import com.example.healthcareapplication.presentation.screens_and_implementtion.goal.add_goal.GoalCard
import com.example.healthcareapplication.presentation.screens_and_implementtion.meal.MealItem
import com.example.healthcareapplication.presentation.screens_and_implementtion.meal.MealViewModel
import com.example.healthcareapplication.presentation.screens_and_implementtion.meal.add_meal.MealCard
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealScreen(
    viewModel: MealViewModel = hiltViewModel()
) {
    // params
    val uiState by viewModel.state
    var test = uiState.greeting

    val dialogState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {

        if (dialogState.value) {
            Dialog(
                onDismissRequest = {
                    dialogState.value = false
                },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                MealCard(
                    modifier = Modifier
                        .fillMaxWidth(),
                    dialogState = dialogState
                )
            }
        } else {

        }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        dialogState.value = true
                    },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White,
                    shape = CircleShape,
                    modifier = Modifier.size(63.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_round_add_24),
                        contentDescription = "add"
                    )
                }
            }
        ) {


            Surface() {
                ConstraintLayout {
                    val (title, greeting, body, list) = createRefs()

                    Text(
                        text = "Meal",
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.getList() }
                            .constrainAs(title)
                            {}
                    )

                    Text(
                        text = test,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(greeting) {
                                top.linkTo(title.bottom, 28.dp)
                            }
                    )

                    Column(
                        modifier = Modifier
                            .constrainAs(body) {
                                top.linkTo(greeting.bottom, 19.dp)
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.shark_eat_noodle),
                            contentDescription = "banner",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(151.dp)
                                .shadow(elevation = 4.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.height(27.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(19.dp)
                        ) {
                            BriefData(
                                title = null,
                                value = "1",
                                icon = R.drawable.ic_round_set_meal_24
                            )
                            BriefData(
                                title = "Total",
                                value = "1",
                                icon = R.drawable.ic_round_set_meal_24
                            )
                            BriefData(
                                title = null,
                                value = "1",
                                icon = R.drawable.ic_round_set_meal_24
                            )
                        }
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .constrainAs(list) {
                                top.linkTo(body.bottom, 29.dp)
                            },
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(uiState.items) { item ->
                            MealItem(
                                mealDetails = item,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun MealScreenPreview() {
    MealScreen()
}