package com.jason.week7lab.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jason.week7lab.ui.components.BackgroundContainer
import com.jason.week7lab.ui.components.SearchBar
import com.jason.week7lab.ui.view.ErrorView
import com.jason.week7lab.ui.view.InitialView
import com.jason.week7lab.ui.view.LoadingView
import com.jason.week7lab.ui.view.WeatherContent
import com.jason.week7lab.viewmodel.WeatherUiState
import com.jason.week7lab.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var searchText by remember { mutableStateOf("") }

    BackgroundContainer {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            // Search Bar at the top
            item {
                SearchBar(
                    searchText = searchText,
                    onSearchTextChange = { searchText = it },
                    onSearch = {
                        viewModel.searchWeather(searchText)
                    }
                )
            }


            item {
                when (val state = uiState) {
                    is WeatherUiState.Initial -> {
                        InitialView()
                    }
                    is WeatherUiState.Loading -> {
                        LoadingView()
                    }
                    is WeatherUiState.Success -> {
                        WeatherContent(weather = state.weather)
                    }
                    is WeatherUiState.Error -> {
                        ErrorView(message = state.message)
                    }
                }
            }
        }
    }
}

