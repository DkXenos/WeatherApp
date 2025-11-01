package com.jason.week7lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jason.week7lab.ui.theme.Week7LabTheme
import com.jason.week7lab.uiview.ApiKeyConfigScreen
import com.jason.week7lab.uiview.Soal1View
import com.jason.week7lab.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week7LabTheme {
                WeatherApp()
            }
        }
    }
}

@Composable
fun WeatherApp() {
    val viewModel: WeatherViewModel = viewModel()
    val apiKey by viewModel.apiKey.collectAsState()
    var showConfigScreen by remember { mutableStateOf(true) }

    // Show config screen if no API key is set
    LaunchedEffect(apiKey) {
        if (apiKey.isNotEmpty()) {
            showConfigScreen = false
        }
    }

    if (showConfigScreen) {
        ApiKeyConfigScreen(
            viewModel = viewModel,
            onApiKeySet = {
                showConfigScreen = false
            }
        )
    } else {
        Soal1View(viewModel = viewModel)
    }
}