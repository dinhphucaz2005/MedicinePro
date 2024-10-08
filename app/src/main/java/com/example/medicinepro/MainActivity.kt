package com.example.medicinepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.medicinepro.domain.repository.AuthenticationRepository
import com.example.medicinepro.ui.screen.main.MainScreen
import com.example.medicinepro.ui.theme.MedicineProTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authenticationRepository: AuthenticationRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            authenticationRepository.register()
        }
        setContent {
            MedicineProTheme {
                MainScreen()
            }
        }
    }
}