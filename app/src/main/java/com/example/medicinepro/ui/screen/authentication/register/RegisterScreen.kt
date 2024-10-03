package com.example.medicinepro.ui.screen.authentication.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.medicinepro.R
import com.example.medicinepro.di.FakeModule
import com.example.medicinepro.ui.components.ExButton
import com.example.medicinepro.ui.components.ExTextField
import com.example.medicinepro.ui.components.PasswordField
import com.example.medicinepro.ui.theme.MedicineProTheme

@Preview
@Composable
private fun Preview() {
    MedicineProTheme {
        RegisterScreen(viewModel = FakeModule.provideRegisterViewModel())
    }
}

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, viewModel: RegisterViewModel) {

    val name by viewModel.name.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp, alignment = Alignment.CenterVertically)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_logo), contentDescription = null,
            modifier = Modifier.size(66.dp)
        )
        Text("HealthPal", style = MaterialTheme.typography.titleLarge)
        Text("Create Account", style = MaterialTheme.typography.titleMedium)
        Text("We are here to help you!", style = MaterialTheme.typography.titleSmall)

        val defaultModifier = Modifier.fillMaxWidth()

        ExTextField(
            text = name, placeHolder = "Name",
            painter = painterResource(R.drawable.ic_person),
            modifier = defaultModifier
        ) { viewModel.onNameChange(it) }
        ExTextField(
            text = email, placeHolder = "Email",
            painter = painterResource(R.drawable.ic_email),
            modifier = defaultModifier
        ) { viewModel.onEmailChange(it) }
        PasswordField(text = password, modifier = defaultModifier) {
            viewModel.onPasswordChange(it)
        }
        ExButton(
            modifier = defaultModifier,
            "Create Account"
        ) { viewModel.onRegisterClick() }
        ConstraintLayout(
            modifier = defaultModifier
        ) {
            val (textRef, ref1, ref2) = createRefs()

            Text("or", Modifier.constrainAs(textRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
            HorizontalDivider(Modifier.constrainAs(ref1) {
                start.linkTo(parent.start)
                end.linkTo(textRef.start, margin = 12.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            })
            HorizontalDivider(Modifier.constrainAs(ref2) {
                start.linkTo(textRef.end, margin = 12.dp)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = androidx.constraintlayout.compose.Dimension.fillToConstraints
            })
        }
        Button(
            onClick = {},
            modifier = defaultModifier,
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.tertiary),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Image(painter = painterResource(R.drawable.ic_google), contentDescription = null)
            Text(
                "Continue with Google",
                color = Color.Black,
                modifier = Modifier.padding(start = 12.dp)
            )
        }

        Button(
            onClick = {},
            modifier = defaultModifier,
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.tertiary),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Image(painter = painterResource(R.drawable.ic_facebook), contentDescription = null)
            Text(
                "Continue with Facebook",
                color = Color.Black,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
        val annotatedText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            ) {
                append("Do you have an account ? ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF1c64f2),
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            ) {
                append("Sign In")
            }
        }
        Text(annotatedText)
    }
}