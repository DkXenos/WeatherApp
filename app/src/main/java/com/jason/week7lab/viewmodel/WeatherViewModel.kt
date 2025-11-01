package com.jason.week7lab.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jason.week7lab.model.WeatherResponse
import com.jason.week7lab.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class WeatherUiState {
    object Initial : WeatherUiState()
    object Loading : WeatherUiState()
    data class Success(val weather: WeatherResponse) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()

    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Initial)
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    private val _apiKey = MutableStateFlow("")
    val apiKey: StateFlow<String> = _apiKey.asStateFlow()

    fun setApiKey(key: String) {
        _apiKey.value = key
    }

    fun searchWeather(cityName: String) {
        if (_apiKey.value.isEmpty()) {
            _uiState.value = WeatherUiState.Error("Please set API key first")
            return
        }

        if (cityName.isEmpty()) {
            _uiState.value = WeatherUiState.Error("Please enter a city name")
            return
        }

        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading

            val result = repository.getWeather(cityName, _apiKey.value)

            _uiState.value = if (result.isSuccess) {
                WeatherUiState.Success(result.getOrNull()!!)
            } else {
                val error = result.exceptionOrNull()
                when {
                    error?.message?.contains("404") == true ->
                        WeatherUiState.Error("HTTP 404 Not Found")
                    error?.message?.contains("401") == true ->
                        WeatherUiState.Error("Invalid API Key")
                    else ->
                        WeatherUiState.Error(error?.message ?: "Something went wrong")
                }
            }
        }
    }
}

