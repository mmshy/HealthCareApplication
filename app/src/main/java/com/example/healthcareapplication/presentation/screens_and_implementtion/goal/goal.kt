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
                    val (title, filter, body, list) = createRefs()

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

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .constrainAs(filter)
                            {
                                centerHorizontallyTo(parent)
                            }
                            .fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier
                            .width(50.dp)
                            .background(Color.Blue)
                        )


                        Column(

                        ) {
                            Spacer(modifier = Modifier
                                .size(20.dp)
                                .background(Color.Blue))

                            Box(
                                modifier = Modifier
                                    .size(35.dp)
                                    .clip(CircleShape)
                                    .background(Color.Cyan)
                            )
                        }
                    }





                    /*Text(
                        text = "something",
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

                        ) {
                        Spacer(modifier = Modifier.size(20.dp))

                        Column(

                        ) {
                            BriefData(
                                title = null,
                                value = "uiState.data1",
                                icon = R.drawable.ic_round_nights_stay_24
                            )
                            Spacer(modifier = Modifier.width(19.dp))
                            BriefData(
                                title = "total",
                                value = "uiState.data2",
                                icon = R.drawable.ic_round_nights_stay_24
                            )
                            Spacer(modifier = Modifier.width(19.dp))
                            BriefData(
                                title = null,
                                value = "uiState.data3",
                                icon = R.drawable.ic_round_nights_stay_24
                            )
                        }

                        Spacer(modifier = Modifier
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.primary))

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

                        items(3) {
                            Row(
                                modifier = Modifier
                                    .height(65.dp)
                                    .background(MaterialTheme.colorScheme.onBackground)
                                    .fillMaxWidth()
                                    .padding(20.dp, 0.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Bread",
                                    style = MaterialTheme.typography.bodySmall,
                                )
                                Text(
                                    text = "100gr",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = Color.Black
                                )
                                Text(
                                    text = "100kcal",
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                        }
                    }*/

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