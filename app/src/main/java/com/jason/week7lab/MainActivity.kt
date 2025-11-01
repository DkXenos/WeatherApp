package com.jason.week7lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jason.week7lab.ui.theme.Week7LabTheme
import com.jason.week7lab.ui.screens.WeatherScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week7LabTheme {
                WeatherScreen()
            }
        }
    }
}