package com.example.healthcareapplication.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.AlignmentLine
import com.example.healthcareapplication.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import com.example.healthcareapplication.presentation.ui.theme.Gray
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.Smoke
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepScreen() {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        // params
//        val state

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
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
                        text = "Sleep",
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(title) {}
                    )

                    Text(
                        text = "something",
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
                                top.linkTo(greeting.bottom, 28.dp)
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
                                value = "5h30'",
                                icon = R.drawable.ic_round_nights_stay_24
                            )
                            Spacer(modifier = Modifier.width(19.dp))
                            BriefData(
                                title = "total",
                                value = "5h30'",
                                icon = R.drawable.ic_round_nights_stay_24
                            )
                            Spacer(modifier = Modifier.width(19.dp))
                            BriefData(
                                title = null,
                                value = "5h30'",
                                icon = R.drawable.ic_round_nights_stay_24
                            )
                        }
                    }

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()

                            .constrainAs(list) {
                                top.linkTo(body.bottom, 39.dp)
                            },
                        verticalArrangement = Arrangement.spacedBy(1.dp)
                    ) {
                        items(3) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(86.dp)
                                    .background(Smoke)
                                    .padding(24.dp, 0.dp)
                            ) {
                                Text(
                                    text = "06:00AM",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(modifier = Modifier.width(24.dp))
                                Text(
                                    text = "...Sleeping",
                                    style = MaterialTheme.typography.labelMedium,
                                    modifier = Modifier.weight(1f),
                                    color = Color.Black
                                )
                                IconButton(
                                    onClick = { /*TODO*/ },
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_round_done_24),
                                        contentDescription = "icon",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(32.dp)
                                    )
                                }
                            }
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
