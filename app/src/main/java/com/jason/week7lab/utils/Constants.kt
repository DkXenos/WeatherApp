package com.jason.week7lab.utils

/**
 * Constants object untuk menyimpan konstanta aplikasi
 * 
 * MVVM Architecture Structure:
 * - data/model: Data classes untuk API response
 * - data/remote: API service dan Retrofit instance
 * - data/repository: Repository untuk mengakses data
 * - viewmodel: ViewModel untuk manage UI state
 * - uiview: Composable UI screens
 * - utils: Utility classes dan constants
 * 
 * API Key sudah built-in sehingga user tidak perlu input manual
 */
object Constants {
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    const val API_KEY = "ea03bdbda9cfe2c59941ca96b1c61fc8"
    const val ICON_URL = "https://openweathermap.org/img/wn/"
}
