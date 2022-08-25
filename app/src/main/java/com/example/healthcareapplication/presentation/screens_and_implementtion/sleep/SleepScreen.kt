package com.example.healthcareapplication.presentation.screens_and_implementtion.sleep

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.healthcareapplication.presentation.components.BriefData
import com.example.healthcareapplication.presentation.screens_and_implementtion.sleep.add_sleep.SleepCard
import com.example.healthcareapplication.presentation.sleep.SleepItem
import com.example.healthcareapplication.presentation.sleep.SleepItemTrick
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepScreen(
    viewModel: SleepViewModel = hiltViewModel()
) {

//    DisposableEffect(viewModel) {
//        viewModel.addListener()
//        onDispose { viewModel.removeListener() }
//    }

    val uiState by viewModel.state
    val dialogState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        // params

        var something = uiState.greeting

        if (dialogState.value) {
            Dialog(
                onDismissRequest = { dialogState.value = false },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                SleepCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    dialogState = dialogState
                )
            }
        } else {

        }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { dialogState.value = true },
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
            Surface(
                Modifier.wrapContentHeight(unbounded = false)
            ) {
                ConstraintLayout(
                    Modifier.wrapContentHeight(unbounded = false)
                ) {
                    val (title, greeting, body, list) = createRefs()

                    Text(
                        text = "Sleep",
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(title) {}
                    )

                    Text(
                        text = something,
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
                                centerHorizontallyTo(parent)
                                top.linkTo(greeting.bottom, 20.dp)
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(250.dp)
                                .shadow(
                                    elevation = 8.dp,
                                    shape = CircleShape,
                                    clip = true
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(230.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                            )
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        Row(
                            verticalAlignment = Alignment.Top
                        ) {
                            BriefData(
                                title = null,
                                value = uiState.data1,
                                icon = R.drawable.ic_round_nights_stay_24
                            )
                            Spacer(modifier = Modifier.width(19.dp))
                            BriefData(
                                title = "total",
                                value = uiState.data2,
                                icon = R.drawable.ic_round_nights_stay_24
                            )
                            Spacer(modifier = Modifier.width(19.dp))
                            BriefData(
                                title = null,
                                value = uiState.data3,
                                icon = R.drawable.ic_round_nights_stay_24
                            )
                        }
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(unbounded = true)
                            .padding(bottom = 30.dp)
                            .constrainAs(list) {
                                top.linkTo(body.bottom, 30.dp)
                            },
                        verticalArrangement = Arrangement.spacedBy(1.dp)
                    ) {
                        items(uiState.items) { item ->
                            SleepItem(
                                sleep = item,
                                onCheckOutItem = { viewModel.onEvent(SleepEvent.CheckOutItem(item)) }
                            )
                        }
                        items(5) {
                            SleepItemTrick()
                        }
                    }

                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SleepScreenPreview() {
    SleepScreen()
}
