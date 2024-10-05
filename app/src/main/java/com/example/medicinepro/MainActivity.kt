package com.example.medicinepro

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.medicinepro.ui.screen.main.MainScreen
import com.example.medicinepro.ui.theme.MedicineProTheme
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    @Serializable
    data class Data(
        val fact: String,
        val length: Int
    )

    @Inject
    lateinit var httpClient: HttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            val result: Data = httpClient.get("/fact").body()
            Log.d(TAG, "onCreate: $result")
        }
        setContent {
            MedicineProTheme {
                MainScreen()
            }
        }
    }
}