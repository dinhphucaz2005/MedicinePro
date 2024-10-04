package com.example.medicinepro.ui.screen.authentication.forget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.medicinepro.R
import com.example.medicinepro.di.FakeModule
import com.example.medicinepro.ui.components.ExButton
import com.example.medicinepro.ui.components.ExTextField
import com.example.medicinepro.ui.screen.authentication.register.RegisterViewModel
import com.example.medicinepro.ui.theme.MedicineProTheme

@Preview
@Composable
private fun Preview() {
    MedicineProTheme {
        VerifyCodeScreen(viewModel = FakeModule.provideForgetPasswordViewModel())
    }
}

@Composable
fun VerifyCodeScreen(modifier: Modifier = Modifier, viewModel: ForgetPasswordViewModel) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        IconButton(onClick = {}, Modifier.align(Alignment.Start)) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
        }
        Icon(
            painter = painterResource(R.drawable.ic_logo), contentDescription = null,
            modifier = Modifier.size(66.dp)
        )
        Text("HealthPal", style = MaterialTheme.typography.titleLarge)
        Text("Forget Password?", style = MaterialTheme.typography.titleMedium)
        Text(
            "Enter  you Email, we will send you a" +
                    "\nverification code.",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleSmall
        )
        val defaultModifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
        Row(
            modifier = defaultModifier
        ) {
            for (i in 0..4) {
                ExTextField(
                    text = "", placeHolder = "",
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f)
                        .aspectRatio(1f),
                ) {

                }
            }
        }
        ExButton(
            modifier = defaultModifier,
            text = "Verify"
        ) {
            viewModel.verifyCode()
        }
        val annotatedText = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            ) {
                append("Didn't get the Code? ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color(0xFF1c64f2),
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            ) {
                append("Resend")
            }
        }
        Text(annotatedText)
    }
}