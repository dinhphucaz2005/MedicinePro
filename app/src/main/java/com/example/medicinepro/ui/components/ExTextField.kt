package com.example.medicinepro.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicinepro.R
import com.example.medicinepro.ui.theme.MedicineProTheme

@Preview
@Composable
private fun Preview() {
    MedicineProTheme {

        ExTextField(
            Modifier.fillMaxWidth(),
            "", "Your Email"
        ) {

        }
    }
}

@Composable
fun ExTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeHolder: String,
    painter: Painter? = null,
    onValueChange: (String) -> Unit,
) {
    if (painter != null) {
        OutlinedTextField(
            modifier = modifier,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_email), contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            value = text,
            placeholder = {
                Text(placeHolder, color = MaterialTheme.colorScheme.tertiary)
            },
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                focusedBorderColor = MaterialTheme.colorScheme.tertiary,
                unfocusedTextColor = MaterialTheme.colorScheme.tertiary
            ),
            singleLine = true,
            onValueChange = { onValueChange(it) }
        )
    } else {
        OutlinedTextField(
            modifier = modifier,
            value = text,
            placeholder = {
                Text(placeHolder, color = MaterialTheme.colorScheme.tertiary)
            },
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                focusedBorderColor = MaterialTheme.colorScheme.tertiary,
                unfocusedTextColor = MaterialTheme.colorScheme.tertiary
            ),
            singleLine = true,
            onValueChange = { onValueChange(it) }
        )
    }
}