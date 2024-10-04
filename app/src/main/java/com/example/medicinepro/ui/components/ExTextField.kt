package com.example.medicinepro.ui.components

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

        PasswordField(
            modifier = Modifier.fillMaxWidth(),
            text = ""
        ) {}
    }
}


@Composable
fun PasswordField(
    modifier: Modifier = Modifier,
    placeHolder: String = "Password",
    text: String,
    onValueChange: (String) -> Unit,
) {
    val outlineTextFieldDefaultColor = OutlinedTextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.tertiary,
        unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
        disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
        focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        focusedBorderColor = MaterialTheme.colorScheme.tertiary,
        unfocusedBorderColor = MaterialTheme.colorScheme.tertiary
    )

    OutlinedTextField(
        modifier = modifier,
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_lock), contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary,
            )
        },
        value = text,
        placeholder = {
            Text(placeHolder, color = MaterialTheme.colorScheme.tertiary)
        },
        shape = RoundedCornerShape(8.dp),
        colors = outlineTextFieldDefaultColor,
        singleLine = true,
        onValueChange = { onValueChange(it) }
    )
}

@Composable
fun ExTextField(
    modifier: Modifier = Modifier,
    text: String,
    placeHolder: String,
    painter: Painter? = null,
    onValueChange: (String) -> Unit,
) {
    val outlineTextFieldDefaultColor = OutlinedTextFieldDefaults.colors(
        focusedTextColor = MaterialTheme.colorScheme.tertiary,
        unfocusedTextColor = MaterialTheme.colorScheme.tertiary,
        disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
        focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
        focusedBorderColor = MaterialTheme.colorScheme.tertiary,
        unfocusedBorderColor = MaterialTheme.colorScheme.tertiary
    )
    if (painter != null) {
        OutlinedTextField(
            modifier = modifier,
            leadingIcon = {
                Icon(
                    painter = painter, contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            value = text,
            placeholder = {
                Text(placeHolder, color = MaterialTheme.colorScheme.tertiary)
            },
            shape = RoundedCornerShape(8.dp),
            colors = outlineTextFieldDefaultColor,
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
            colors = outlineTextFieldDefaultColor,
            singleLine = true,
            onValueChange = { onValueChange(it) }
        )
    }
}