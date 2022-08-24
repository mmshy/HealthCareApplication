package com.example.healthcareapplication.presentation.screens_and_implementtion.goal

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import com.example.healthcareapplication.presentation.components.custom.secondBtn
import com.example.healthcareapplication.presentation.screens_and_implementtion.goal.add_goal.GoalCard
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography
import org.junit.Before

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalScreen(
    viewModel: GoalViewModel = hiltViewModel()
) {
    val uiState by viewModel.state

    val dialogState: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        // params

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
                GoalCard(
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
                    modifier = Modifier
                        .size(63.dp)
                        .absoluteOffset(0.dp, (-70).dp)
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
                    val (title, completedAndOnDoing, list) = createRefs()

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .constrainAs(title)
                            {
                                centerHorizontallyTo(parent)
                            }
                            .fillMaxWidth()
                    )
                    {
                        Text(
                            text = "Goal",
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Center,

                            )
                    }

                    ConstraintLayout(
                        modifier = Modifier
                            .constrainAs(completedAndOnDoing)
                            {
                                centerHorizontallyTo(parent)
                                top.linkTo(title.top, margin = 30.dp)
                            }
                    ) {
                        val (filter, completedAndDoing) = createRefs()
                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .background(Color.Cyan)
                                .constrainAs(filter) {
                                    top.linkTo(parent.top, margin = (-15).dp)
                                    end.linkTo(parent.end, margin = 10.dp)
                                }

                        )
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .constrainAs(completedAndDoing)
                                {
                                    top.linkTo(title.bottom, margin = 0.dp)
                                }
                                .fillMaxWidth()
                        )
                        {

                            if (uiState.status == GoalStatus.DOING) {
                                primaryBtn(
                                    onClick = {},
                                    modifier = Modifier
                                        .height(50.dp),
                                    text = "On doing",
                                    icon = null,
                                )
                                secondBtn(
                                    onClick = { viewModel.onCompleteClick() },
                                    modifier = Modifier
                                        .height(50.dp),
                                    text = "Completed",
                                    icon = null

                                )
                            } else {
                                secondBtn(
                                    onClick = { viewModel.onDoingClick() },
                                    modifier = Modifier
                                        .height(50.dp),
                                    text = "On doing",
                                    icon = null,
                                )
                                primaryBtn(
                                    onClick = {},
                                    modifier = Modifier
                                        .height(50.dp),
                                    text = "Completed",
                                    icon = null

                                )
                            }

                        }

                    }




                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp, end = 10.dp, start = 10.dp)
                            .constrainAs(list) {
                                top.linkTo(completedAndOnDoing.bottom, 30.dp)
                            },
                        verticalArrangement = Arrangement.spacedBy(1.dp)
                    ) {

                        items(uiState.listGoal) { item ->
                            Row(
                                modifier = Modifier
                                    .height(110.dp)
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.secondary),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                GoalData(goal = item)
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
@Preview
fun GoalScreenPreview() {
    GoalScreen()
}