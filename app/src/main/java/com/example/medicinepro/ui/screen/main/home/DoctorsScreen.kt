package com.example.medicinepro.ui.screen.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.medicinepro.R
import com.example.medicinepro.ui.components.ExTextField
import com.example.medicinepro.ui.theme.MedicineProTheme

@Preview
@Composable
private fun Preview() {
    MedicineProTheme {
        DoctorsScreen()
    }
}

@Composable
fun DoctorsScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.surface
            )
            .padding(24.dp)
    ) {
        val (textRef, btnRef, searchRef, rowRef) = createRefs()
        val defaultModifier = Modifier.fillMaxWidth()

        Text(
            "All Doctors",
            modifier = Modifier.constrainAs(textRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            },
            style = MaterialTheme.typography.displayLarge
        )


        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null,
            modifier = Modifier.constrainAs(btnRef) {
                top.linkTo(textRef.top)
                bottom.linkTo(textRef.bottom)
                start.linkTo(parent.start)
            })

        ExTextField(
            text = "",
            placeHolder = "Search doctor...",
            modifier = defaultModifier.constrainAs(searchRef) {
                top.linkTo(textRef.bottom, margin = 14.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            painter = painterResource(R.drawable.ic_search)
        ) { }

        LazyRow(
            modifier = defaultModifier.constrainAs(rowRef) {
                top.linkTo(searchRef.bottom, margin = 24.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            items(20) { index ->
                Text("Index $index")
            }
        }
        
    }
}