package com.example.healthcareapplication.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import com.example.healthcareapplication.presentation.components.custom.secondBtn
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun RegisterScreen(
    onBackToLoginClick: () -> Unit
) {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(16.dp, 0.dp)
        ) {

            val (title, column, signUpBtn, backToSignInBtn) = createRefs()
            var email by remember {
                mutableStateOf("")
            }
            var name by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            var confirmPassword by remember {
                mutableStateOf("")
            }
            var passwordVisibility: Boolean by remember { mutableStateOf(false) }
            var passwordVisibility1: Boolean by remember { mutableStateOf(false) }

            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {
                        top.linkTo(parent.top, 23.dp)
                    }
            )

            Column(
                modifier = Modifier
                    .constrainAs(column) {
                        top.linkTo(title.bottom, 25.dp)
                    }
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    modifier = Modifier
                        .fillMaxWidth()
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(text = "Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp, 0.dp, 0.dp)
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
                OutlinedTextField(
                    value = confirmPassword,
                    visualTransformation = if (passwordVisibility1) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(
                            onClick = { passwordVisibility1 = !passwordVisibility1 }
                        ) {
                            Icon(
                                painterResource(id = R.drawable.ic_round_person_24),
                                ""
                            )
                        }
                    },
                    onValueChange = { confirmPassword = it },
                    label = { Text(text = "Confirm Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 16.dp, 0.dp, 0.dp)
                )
            }

            primaryBtn(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .constrainAs(signUpBtn) {
                        top.linkTo(column.bottom, 40.dp)
                    }
                    .fillMaxWidth()
                    .height(49.dp),
                text = "Next",
                icon = null
            )

            secondBtn(
                onClick = { onBackToLoginClick() },
                modifier = Modifier
                    .height(49.dp)
                    .constrainAs(backToSignInBtn) {
                        bottom.linkTo(parent.bottom, margin = 36.dp)
                    }
                    .fillMaxWidth(),
                text = "Back to Login",
                null
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview() {
    RegisterScreen({})
}