package com.example.medicinepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.medicinepro.ui.screen.authentication.login.LoginScreen
import com.example.medicinepro.ui.screen.authentication.register.FillProfileScreen
import com.example.medicinepro.ui.theme.MedicineProTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MedicineProTheme {
                FillProfileScreen()
            }
        }
    }
}