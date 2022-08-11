package com.example.healthcareapplication.presentation.components

import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealScreen() {
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
                        text = "Meal",
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
                            .constrainAs(list) {
                                top.linkTo(body.bottom, 29.dp)
                            }
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(1.dp)
                    ) {
                        item {
                            Row(
                                modifier = Modifier
                                    .height(65.dp)
                                    .background(MaterialTheme.colorScheme.primary)
                                    .fillMaxWidth()
                                    .padding(20.dp, 0.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Breakfast",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "200kcal",
                                    color = Color.White,
                                    style = MaterialTheme.typography.headlineSmall
                                )
                            }
                        }
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