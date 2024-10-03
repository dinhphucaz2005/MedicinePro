package com.example.medicinepro.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicinepro.ui.theme.MedicineProTheme

@Preview
@Composable
private fun Preview() {
    MedicineProTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFffffff))
        ) {
            ExButton(Modifier.fillMaxWidth(), "Send Code") { }
        }
    }
}

@Composable
fun ExButton(modifier: Modifier = Modifier, text: String, onClick: (() -> Unit)) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
        )
    ) {
        Text(text, color = MaterialTheme.colorScheme.secondary)
    }
}