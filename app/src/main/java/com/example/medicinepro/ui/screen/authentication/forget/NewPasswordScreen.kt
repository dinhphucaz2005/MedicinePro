package com.example.medicinepro.ui.screen.authentication.forget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicinepro.R
import com.example.medicinepro.di.FakeModule
import com.example.medicinepro.ui.components.ExButton
import com.example.medicinepro.ui.components.PasswordField
import com.example.medicinepro.ui.theme.MedicineProTheme

@Preview
@Composable
private fun Preview() {
    MedicineProTheme {
        NewPasswordScreen(viewModel = FakeModule.provideForgetPasswordViewModel())
    }
}

@Composable
fun NewPasswordScreen(modifier: Modifier = Modifier, viewModel: ForgetPasswordViewModel) {

    val newPassword by viewModel.newPassword.collectAsState()
    val confirmPassword by viewModel.confirmPassword.collectAsState()

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
        Text("Create new password", style = MaterialTheme.typography.titleMedium)
        Text(
            "Your new password must be different from" +
                    " previously used password",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleSmall
        )

        val defaultModifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)

        PasswordField(
            text = newPassword, placeHolder = "New Password",
            modifier = defaultModifier
        ) { viewModel.onPasswordChange(it) }

        PasswordField(
            text = confirmPassword, placeHolder = "Confirm Password",
            modifier = defaultModifier
        ) { viewModel.onConfirmPasswordChange(it) }
        ExButton(
            modifier = defaultModifier,
            text = "Send Code"
        ) { viewModel.resetPassword() }
    }
}