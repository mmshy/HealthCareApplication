package com.example.healthcareapplication.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import com.example.healthcareapplication.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import com.example.healthcareapplication.presentation.components.custom.primaryBtnNoPadding
import com.example.healthcareapplication.presentation.components.custom.secondBtn
import com.example.healthcareapplication.presentation.components.custom.secondBtnNoPadding
import com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking.WaterDrinkingViewModel
import com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking.add_waterdrinking.WaterCard
import com.example.healthcareapplication.presentation.screens_and_implementtion.water_drinking.water_Item.WaterItem
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaterDrinkingScreen(
    viewModel: WaterDrinkingViewModel = hiltViewModel()
) {
    val uiState = viewModel.state.value

    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        if (uiState.showAddCard) {
            Dialog(
                onDismissRequest = { viewModel.unShowAddWaterCard() },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                WaterCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { viewModel.showAddWaterCard() },
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
                        text = "Water Drinking",
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(title) {}
                    )

                    Text(
                        text = uiState.greeting,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(greeting) {
                                top.linkTo(title.bottom, 28.dp)
                            }
                    )


                    Row(
                        modifier = Modifier
                            .constrainAs(body) {
                                centerHorizontallyTo(parent)
                                top.linkTo(greeting.bottom, 20.dp)
                            },
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        Spacer(
                            modifier = Modifier
                                .size(10.dp)
                        )
                        Column(
                            modifier = Modifier.height(170.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .size(30.dp)
                            )
                            BriefData(
                                title = null,
                                value = uiState.amount.toString() + "ml",
                                icon = R.drawable.ic_round_nights_stay_24
                            )

                            Row(

                            ) {
                                secondBtnNoPadding(
                                    onClick = { viewModel.updateWaterDrinkingWithNewDetail250ml() },
                                    modifier =
                                    Modifier
                                        .height(40.dp)
                                        .width(100.dp),
                                    text = "250ml",
                                    icon = R.drawable.ic_round_wb_sunny_24
                                )
                                Spacer(modifier = Modifier.size(10.dp))

                                primaryBtnNoPadding(
                                    onClick = { viewModel.updateWaterDrinkingWithNewDetail500ml() },
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(100.dp),
                                    text = "500ml",
                                    icon = R.drawable.ic_round_local_fire_department_24
                                )
                            }

                        }


                        Spacer(
                            modifier = Modifier
                                .size(20.dp)
                        )

                        Box(
                            modifier = Modifier
                                .size(180.dp)
                                .shadow(
                                    elevation = 8.dp,
                                    shape = CircleShape,
                                    clip = true
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(180.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                            )
                        }
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp)
                            .constrainAs(list) {
                                top.linkTo(body.bottom, 30.dp)
                            },
                        verticalArrangement = Arrangement.spacedBy(1.dp)
                    ) {
                        items(uiState.items) { item ->
                            WaterItem(
                                waterDrinkingDetail = item,
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
fun WaterDrinkingPreview() {
    WaterDrinkingScreen()
}
