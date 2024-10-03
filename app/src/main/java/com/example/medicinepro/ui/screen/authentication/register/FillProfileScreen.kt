package com.example.medicinepro.ui.screen.authentication.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.medicinepro.R
import com.example.medicinepro.di.FakeModule
import com.example.medicinepro.ui.components.ExButton
import com.example.medicinepro.ui.components.ExTextField
import com.example.medicinepro.ui.theme.MedicineProTheme


@Preview
@Composable
private fun Preview() {
    MedicineProTheme {
        FillProfileScreen(viewModel = FakeModule.provideRegisterViewModel())
    }
}

@Composable
fun FillProfileScreen(modifier: Modifier = Modifier, viewModel: RegisterViewModel) {

    val nickname by viewModel.nickname.collectAsState()
    val phoneNumber by viewModel.phoneNumber.collectAsState()
    val dateOfBirth by viewModel.dateOfBirth.collectAsState()
    val gender by viewModel.gender.collectAsState()


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                "Fill Your Profile",
                style = MaterialTheme.typography.titleMedium
            )
        }
        ConstraintLayout(
            modifier = Modifier.size(200.dp)
        ) {
            val (ref1, ref2) = createRefs()
            Image(
                painter = painterResource(R.drawable.ic_user),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(ref1) {

                    }
            )
            val temp = 26.dp //margin Value
            Image(
                painter = painterResource(R.drawable.ic_edit),
                contentDescription = null,
                modifier = Modifier.constrainAs(ref2) {
                    bottom.linkTo(parent.bottom, margin = temp)
                    end.linkTo(parent.end, margin = temp)
                }
            )
        }

        val defaultModifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp)

        ExTextField(modifier = defaultModifier, text = nickname, placeHolder = "Nickname") { }
        ExTextField(modifier = defaultModifier, text = phoneNumber, placeHolder = "Phone Number") { }
        ExTextField(
            modifier = defaultModifier,
            text = dateOfBirth,
            placeHolder = "Date of birth",
            painter = painterResource(R.drawable.ic_calendar)
        ) { }
        ExTextField(modifier = defaultModifier, text = gender, placeHolder = "Gender") { }
        ExButton(modifier = defaultModifier, text = "Save") {
            viewModel.saveUser()
        }
    }
}