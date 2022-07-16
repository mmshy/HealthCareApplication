package com.example.healthcareapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.healthcareapplication.R
import com.example.healthcareapplication.presentation.components.custom.primaryBtn
import com.example.healthcareapplication.presentation.components.custom.secondBtn
import com.example.healthcareapplication.presentation.ui.theme.LightColorScheme
import com.example.healthcareapplication.presentation.ui.theme.myTypography

@Composable
fun ForgotPasswordScreen() {
    MaterialTheme(
        typography = myTypography,
        colorScheme = LightColorScheme
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(16.dp, 0.dp)
        ) {

            val (title, input, submitBtn, image, backToLoginBtn) = createRefs()

            var email by remember {
                mutableStateOf("")
            }

            Text(
                text = "Forgot Password",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {
                        top.linkTo(parent.top, 9.dp)
                    }
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(input) {
                        top.linkTo(title.bottom, 50.dp)
                    }
            )

            primaryBtn(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .constrainAs(submitBtn) {
                        top.linkTo(input.bottom, 34.dp)
                        centerHorizontallyTo(parent)
                    }
                    .height(49.dp),
                text = "Next",
                icon = null
            )

            Image(
                painterResource(id = R.drawable.shark_sleep),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(image) {
                        top.linkTo(submitBtn.bottom, 50.dp)
                    }
            )

            secondBtn(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(49.dp)
                    .constrainAs(backToLoginBtn) {
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
@Preview (showBackground = true)
fun ForgotPasswordScreenPreview() {
    ForgotPasswordScreen()
}