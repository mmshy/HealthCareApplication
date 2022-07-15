package com.example.healthcareapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.ui.theme.HealthCareApplicationTheme
import com.example.healthcareapplication.presentation.ui.theme.Lato

@Composable
fun LoginScreen() {
    ConstraintLayout {

        val (column, anotherLogin, register) = createRefs()

        Column(
            modifier = Modifier.constrainAs(column) {
                top.linkTo(parent.top, margin = 16.dp)
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
                text = "SignIn",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") }
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
                onValueChange = { password = it }, label = { Text(text = "Password") }
            )
            Text(
                text = "Forgot Password?",
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxWidth()
            )
            androidx.compose.material.Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Go to App",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

        Column(
            modifier = Modifier.constrainAs(anotherLogin) {
                top.linkTo(column.bottom, margin = 16.dp)
            }
        ) {
            Text(
                text = "or",
                style = MaterialTheme.typography.labelSmall
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_round_person_24),
                        contentDescription = ""
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_round_person_24),
                        contentDescription = ""
                    )
                }
            }
        }

        Row(
            modifier = Modifier.constrainAs(register) {
                top.linkTo(parent.bottom, margin = (-16).dp)
            }
        ) {
            Text(
                text = "Dont you have an account?",
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "Create a HCA Account",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginScreen()
}
