package com.example.medicinepro.ui.screen.authentication.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.medicinepro.R
import com.example.medicinepro.ui.components.ExButton
import com.example.medicinepro.ui.components.ExTextField
import com.example.medicinepro.ui.theme.MedicineProTheme

@Preview
@Composable
private fun Preview() {
    MedicineProTheme {
        RegisterScreen()
    }
}

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
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
        Text("HealthPal")
        Text("Create Account")
        Text("We are here to help you!")
        ExTextField(
            text = "", placeHolder = "Your Name",
            modifier = Modifier
                .fillMaxWidth()
        ) { }
        ExTextField(
            text = "", placeHolder = "Your Email",
            modifier = Modifier
                .fillMaxWidth()
        ) { }
        ExTextField(
            text = "", placeHolder = "Your Email",
            modifier = Modifier
                .fillMaxWidth()
        ) { }
        ExButton(
            Modifier
                .fillMaxWidth()
                .height(48.dp),
            "Create Account"
        ) {

        }
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
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
            modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.tertiary),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Image(painter = painterResource(R.drawable.ic_google), contentDescription = null)
            Text(
                "Sign In with Google",
                color = Color.Black,
                modifier = Modifier.padding(start = 12.dp)
            )
        }

        Button(
            onClick = {},
            modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.tertiary),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Image(painter = painterResource(R.drawable.ic_facebook), contentDescription = null)
            Text(
                "Sign In with Facebook",
                color = Color.Black,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
        Text("Do you have an account ? Sign In")
    }
}