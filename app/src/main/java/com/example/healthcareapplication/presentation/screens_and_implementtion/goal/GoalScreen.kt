package com.example.healthcareapplication.presentation.components.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.BriefData
import com.example.healthcareapplication.presentation.components.GoalData
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import com.example.healthcareapplication.presentation.components.custom.secondBtn
import com.example.healthcareapplication.presentation.screens_and_implementtion.forgotpassword.ForgotPasswordEvent
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography
import org.junit.Before

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalScreen() {
    //val uiState by viewModel.state
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        // params
        //var something = uiState.greeting

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { },
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
                        val ( filter, completedAndDoing) = createRefs()
                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .background(Color.Cyan)
                                .constrainAs(filter) {
                                    top.linkTo(parent.top, margin = -15.dp)
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

                            secondBtn(
                                onClick = { },
                                modifier = Modifier
                                    .height(50.dp),
                                text = "On doing",

                                icon = null,
                            )

                            primaryBtn(
                                onClick = { },
                                modifier = Modifier
                                    .height(50.dp),
                                text = "Completed",
                                icon = null

                            )


                        }

                    }




                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp)
                            .constrainAs(list) {
                                top.linkTo(completedAndOnDoing.bottom, 30.dp)
                            },
                        verticalArrangement = Arrangement.spacedBy(1.dp)
                    ) {

                        items(1) {
                            Row(
                                modifier = Modifier
                                    .height(120.dp)
                                    .padding(horizontal = 10.dp)
                                    .background(MaterialTheme.colorScheme.onBackground)
                                    .fillMaxWidth()
                                    ,
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                GoalData(title = "uong 50 lit nuoc", goal = 10, time = 4, timeLeft = 4)
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