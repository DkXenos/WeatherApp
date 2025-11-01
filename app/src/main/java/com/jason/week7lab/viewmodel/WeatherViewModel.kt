package com.jason.week7lab.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jason.week7lab.data.model.WeatherResponse
import com.jason.week7lab.data.repository.WeatherRepository
import com.jason.week7lab.utils.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * WeatherUiState: Sealed class untuk merepresentasikan berbagai state UI
 * - Initial: State awal sebelum ada pencarian
 * - Loading: State ketika sedang loading data
 * - Success: State ketika data berhasil diambil
 * - Error: State ketika terjadi error
 */
sealed class WeatherUiState {
    object Initial : WeatherUiState()
    object Loading : WeatherUiState()
    data class Success(val weather: WeatherResponse) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}

/**
 * WeatherViewModel: ViewModel untuk mengelola state dan business logic
 * Mengikuti MVVM Architecture Pattern:
 * - View (Nomer1View.kt) -> ViewModel (ini) -> Repository -> API Service
 * - StateFlow untuk reactive UI updates
 * - API Key sudah built-in, user tidak perlu input manual
 */
class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()

    // StateFlow untuk mengobservasi perubahan UI state dari View
    private val _uiState = MutableStateFlow<WeatherUiState>(WeatherUiState.Initial)
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    // API key sudah built-in dari Constants
    private val apiKey = Constants.API_KEY

    fun searchWeather(cityName: String) {
        if (cityName.isEmpty()) {
            _uiState.value = WeatherUiState.Error("Please enter a city name")
            return
        }

        viewModelScope.launch {
            _uiState.value = WeatherUiState.Loading

            try {
                val response = repository.getCurrentWeather(cityName)
                
                _uiState.value = if (response.isSuccessful && response.body() != null) {
                    WeatherUiState.Success(response.body()!!)
                } else {
                    val errorMessage = when (response.code()) {
                        404 -> "City not found"
                        401 -> "Invalid API Key"
                        else -> "Error: ${response.message()}"
                    }
                    WeatherUiState.Error(errorMessage)
                }
            } catch (e: Exception) {
                _uiState.value = WeatherUiState.Error(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            }
        }
    }
    
    fun resetState() {
        _uiState.value = WeatherUiState.Initial
    }
}

