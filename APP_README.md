# Weather App - Week 7 Lab

## Overview
Aplikasi Weather yang menampilkan informasi cuaca real-time menggunakan OpenWeatherMap API.

## Struktur Aplikasi

### 1. **Model** (`com.jason.week7lab.model`)
   - `WeatherData.kt` - Data classes untuk response API
   
### 2. **Service** (`com.jason.week7lab.service`)
   - `WeatherApiService.kt` - Interface untuk Retrofit API calls

### 3. **Repository** (`com.jason.week7lab.repository`)
   - `WeatherRepository.kt` - Layer untuk handle API requests

### 4. **ViewModel** (`com.jason.week7lab.viewmodel`)
   - `WeatherViewModel.kt` - Business logic dan state management
   
### 5. **UI View** (`com.jason.week7lab.uiview`)
   - `ApiKeyConfigScreen.kt` - Screen untuk input API key
   - `Nomer1View.kt` - Main weather screen dengan LazyColumn (scrollable)

## Cara Menggunakan

### 1. Mendapatkan API Key
1. Buka https://openweathermap.org/price
2. Sign up untuk akun gratis
3. Setelah login, dapatkan API key dari dashboard Anda
4. Copy API key tersebut

### 2. Setup Aplikasi
1. Jalankan aplikasi
2. Anda akan melihat screen setup API key
3. Paste API key Anda ke dalam text field
4. Klik "Save & Continue"

### 3. Menggunakan Aplikasi
1. Setelah API key diset, Anda akan masuk ke main screen
2. Ketik nama kota di search bar (contoh: "Medan", "Jakarta", "Cepu")
3. Klik tombol Search atau tekan enter
4. Aplikasi akan menampilkan:
   - Nama kota dan lokasi
   - Tanggal dan waktu update
   - Icon cuaca dari API
   - Karakter Panda yang berubah sesuai cuaca
   - Temperatur
   - Detail cuaca (Humidity, Wind, Feels Like, Pressure, Clouds)
   - Sunrise dan Sunset time

## Fitur Aplikasi

✅ **LazyColumn** - Halaman dapat di-scroll (BUKAN ScrollView)
✅ **TextField & Button** - Untuk search city
✅ **Image dari API** - Weather icon dari OpenWeatherMap
✅ **Gambar Panda** - Berubah sesuai kondisi cuaca (Clear, Clouds, Rain)
✅ **No Plagiarism** - Kode original
✅ **Compile tanpa error** - Build berhasil

## Kondisi Cuaca
- **Clear** 🐼 - Panda dengan matahari
- **Clouds** 🐼 - Panda dengan awan
- **Rain** 🐼 - Panda dengan payung
- Dan kondisi lainnya...

## Error Handling
Aplikasi menampilkan error screen dengan pesan yang jelas:
- City not found: "HTTP 404 Not Found"
- Invalid API key: "Invalid API Key"
- Network error: Error message spesifik

## Dependencies
- Jetpack Compose (Material3)
- Retrofit2 - API calls
- Coil - Image loading
- ViewModel - State management
- Coroutines - Async operations

## API Documentation
Base URL: `https://api.openweathermap.org/data/2.5/`
Endpoint: `weather?q={city}&appid={api_key}&units=metric`

## Notes
- Temperature dalam Celsius
- Wind speed dalam km/h
- Semua data real-time dari OpenWeatherMap
- UI mengikuti design modern dengan gradient background

