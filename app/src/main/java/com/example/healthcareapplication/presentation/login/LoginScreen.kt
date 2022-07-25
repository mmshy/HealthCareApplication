package com.example.healthcareapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import com.example.healthcareapplication.presentation.login.LoginViewModel
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun LoginScreen(
    onRegisterClick: () -> Unit,
    onSubmitClick: () -> Unit,
    onForgetPasswordClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        ConstraintLayout (
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .fillMaxSize()
        ) {

            val (column, anotherLogin, register) = createRefs()

            Column(
                modifier = Modifier.constrainAs(column) {
                    top.linkTo(parent.top, margin = 20.dp)
                }
            ) {
                var email by remember {
                    mutableStateOf("")
                }
                var password by remember {
                    mutableStateOf("")
                }
                var passwordVisibility: Boolean by remember { mutableStateOf(false) }
                Image(
                    painterResource(id = R.drawable.shark_sleep),
                    contentDescription = "",
                    modifier = Modifier
                        .height(143.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Sign In",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .absolutePadding(0.dp, 42.dp, 0.dp, 0.dp)
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 22.dp, 0.dp, 0.dp)
                )
                OutlinedTextField(
                    value = password,
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(
                            onClick = { passwordVisibility = !passwordVisibility }
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_round_person_24),
                                ""
                            )
                        }
                    },
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp, 0.dp, 0.dp)
                )
                Text(
                    text = "Forgot Password?",
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp, 0.dp, 0.dp)
                        .clickable {
                            onForgetPasswordClick()
                        }
                )
                primaryBtn(
                    onClick = onSubmitClick,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(0.dp, 20.dp, 0.dp, 0.dp)
                        .height(49.dp)
                    ,
                    text = "Go to App",
                    null
                )

            }

            Column(
                modifier = Modifier.constrainAs(anotherLogin) {
                    top.linkTo(column.bottom, margin = 65.dp)
                }
            ) {
                Text(
                    text = "or",
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 14.dp, 0.dp, 0.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_round_person_24),
                            contentDescription = "",
                            Modifier.size(40.dp)
                        )
                    }
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_round_person_24),
                            contentDescription = "",
                            Modifier.size(40.dp)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.constrainAs(register) {
                    top.linkTo(parent.bottom, margin = (-60).dp)
                }
            ) {
                Text(
                    text = "Dont you have an account?",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    modifier = Modifier.clickable { onRegisterClick() },
                    text = "Create a HCA Account",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginScreen(onRegisterClick = {}, {}, {})
}
