package com.example.healthcareapplication.presentation.components.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.healthcareapplication.R
import com.example.healthcareapplication.common.MEAL_NAVIGATION
import com.example.healthcareapplication.common.SLEEP_NAVIGATION
import com.example.healthcareapplication.presentation.components.custom.DashboardBtn
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun DashboardScreen(
    navController: NavHostController
) {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        ConstraintLayout(
        ) {
            val (title, body) = createRefs()

            var completedGoal: Int = 7
            var totalGoal: Int = 8

            Text(
                text = "Dashboard",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {}
            )

            Box(
                modifier = Modifier
                    .constrainAs(body) {
                        top.linkTo(title.bottom, 25.dp)
                    }
                    .fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.shark_sleep),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(83.dp)
                        .clip(CircleShape)
                        .align(Alignment.TopCenter)
                        .zIndex(1F),
                )


                    Image(
                        painterResource(id = R.drawable.backgroud_image),
                        "",
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillBounds
                    )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 160.dp, 16.dp, 0.dp)
                        .zIndex(1f)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier
                                .width(150.dp)
                                .height(138.dp)
                                .background(Color.White, RoundedCornerShape(8.dp)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Goals",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = "Completed",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                            Row(
                                modifier = Modifier.padding(0.dp, 15.dp, 0.dp, 0.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "$completedGoal",
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = MaterialTheme.colorScheme.primary,
                                )
                                Text(
                                    text = "/$totalGoal",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                            }
                        }

                        DashboardBtn(
                            onClick = { /*TODO*/ },
                            title = "Water",
                            icon = R.drawable.ic_round_person_24
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                    ) {
                        DashboardBtn(
                            onClick = {
                                navController.navigate(route = MEAL_NAVIGATION)
                            },
                            title = "Meal",
                            icon = R.drawable.ic_round_person_24
                        )
                        DashboardBtn(
                            onClick = {
                                navController.navigate(route = SLEEP_NAVIGATION)
                            },
                            title = "Sleep",
                            icon = R.drawable.ic_round_person_24
                        )
                    }

                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview() {
    DashboardScreen(rememberNavController())
}