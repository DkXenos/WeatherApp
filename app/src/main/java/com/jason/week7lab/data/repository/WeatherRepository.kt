package com.jason.week7lab.data.repository

import com.jason.week7lab.data.model.WeatherResponse
import com.jason.week7lab.data.remote.RetrofitInstance
import com.jason.week7lab.utils.Constants
import retrofit2.Response

/**
 * WeatherRepository: Layer Repository dalam MVVM Architecture
 * 
 * Fungsi:
 * - Bertindak sebagai single source of truth untuk data
 * - Mengabstraksi sumber data (API, Database, dll)
 * - Dipanggil oleh ViewModel untuk mendapatkan data
 * 
 * API Key sudah otomatis dimasukkan dari Constants, 
 * sehingga user tidak perlu input manual
 */
class WeatherRepository {
    private val api = RetrofitInstance.api
    
    suspend fun getCurrentWeather(cityName: String): Response<WeatherResponse> {
        return api.getCurrentWeather(
            cityName = cityName,
            apiKey = Constants.API_KEY
        )
    }
    
    suspend fun getCurrentWeatherByCoords(lat: Double, lon: Double): Response<WeatherResponse> {
        return api.getCurrentWeatherByCoords(
            lat = lat,
            lon = lon,
            apiKey = Constants.API_KEY
        )
    }
}
