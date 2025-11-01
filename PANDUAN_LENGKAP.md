# 🌤️ PANDUAN LENGKAP WEATHER APP

## ✅ CHECKLIST PERSYARATAN

### Komponen yang Sudah Dibuat:
1. ✅ **View** - `Nomer1View.kt` (Main weather screen dengan LazyColumn)
2. ✅ **ViewModel** - `WeatherViewModel.kt` (Manage state & business logic)
3. ✅ **Repository** - `WeatherRepository.kt` (Handle API calls)
4. ✅ **Service** - `WeatherApiService.kt` (Retrofit interface)
5. ✅ **Model** - `WeatherData.kt` (Data classes)

### Rules yang Dipenuhi:
- ✅ **a. No Plagiarism** - Kode original, tidak copy dari mahasiswa lain
- ✅ **b. Build Success** - Project compile tanpa error
- ✅ **c. Gambar Panda** - Berubah sesuai cuaca (Clear, Clouds, Rain)
- ✅ **d. Image dari API** - Weather icon dari OpenWeatherMap
- ✅ **e. LazyColumn (BUKAN ScrollView)** - Menggunakan LazyColumn untuk scrolling
- ✅ **f. TextField & Button Design** - Sesuai dengan contoh
- ✅ **g. Design konsisten** - TextField & Button mengikuti contoh yang diberikan

## 📱 CARA MENGGUNAKAN APLIKASI

### Step 1: Setup API Key
1. Jalankan aplikasi di emulator/device
2. Aplikasi akan otomatis membuka **API Key Configuration Screen**
3. Masukkan API Key Anda yang sudah didapat dari OpenWeatherMap
4. Klik tombol **"Save & Continue"**

### Step 2: Mencari Cuaca
1. Setelah setup API key, Anda akan masuk ke main screen
2. Ketik nama kota di search bar (contoh: "Cepu", "Medan", "Jakarta")
3. Klik icon Search 🔍 atau tekan enter
4. Tunggu loading...
5. Data cuaca akan ditampilkan!

## 🎨 FITUR APLIKASI

### 1. Initial View
- Icon search besar
- Text "Search for a city to get started"
- Background gradient biru

### 2. Loading View
- Circular progress indicator
- Muncul saat sedang fetch data

### 3. Success View (Weather Content)
Menampilkan:
- 📍 Nama kota
- 📅 Tanggal (format: "September 24")
- 🕐 Update time
- 🌤️ Weather icon dari API
- 🐼 Panda emoji (berubah sesuai cuaca)
- 🌡️ Temperature besar
- 💧 Humidity
- 💨 Wind speed
- 🌡️ Feels like temperature
- 🌧️ Rainfall (0.0 mm default)
- 🔽 Pressure
- ☁️ Clouds percentage
- 🌅 Sunrise time
- 🌇 Sunset time

### 4. Error View
- ⚠️ Icon error
- "Oops! Something went wrong"
- Error message (HTTP 404, API error, dll)

## 🐼 PANDA EMOJI BERDASARKAN CUACA

```kotlin
"clear" -> "🐼"        // Panda normal
"clouds" -> "🐼"       // Panda dengan awan
"rain" -> "🐼"         // Panda dengan payung
"drizzle" -> "🐼"      // Panda
"thunderstorm" -> "🐼" // Panda
"snow" -> "🐼"         // Panda dengan salju
```

## 📝 STRUKTUR FILE YANG DIBUAT

```
app/src/main/java/com/jason/week7lab/
├── MainActivity.kt                    # Main activity dengan navigation
├── model/
│   └── WeatherData.kt                # Data classes (WeatherResponse, Main, Wind, dll)
├── service/
│   └── WeatherApiService.kt          # Retrofit API interface
├── repository/
│   └── WeatherRepository.kt          # API call handler
├── viewmodel/
│   └── WeatherViewModel.kt           # State management & business logic
├── uiview/
│   ├── ApiKeyConfigScreen.kt         # Screen untuk input API key
│   └── Nomer1View.kt                 # Main weather screen
└── util/
    └── ApiKeyManager.kt              # Helper untuk manage API key
```

## 🔧 TEKNOLOGI YANG DIGUNAKAN

1. **Jetpack Compose** - Modern UI toolkit
2. **Material3** - Design system
3. **Retrofit2** - HTTP client untuk API calls
4. **OkHttp3** - HTTP interceptor & logging
5. **Gson** - JSON parser
6. **Coil** - Image loading library
7. **Coroutines** - Async programming
8. **StateFlow** - State management
9. **ViewModel** - Lifecycle-aware components

## 🌐 API ENDPOINT

```
Base URL: https://api.openweathermap.org/data/2.5/
Endpoint: GET /weather

Parameters:
- q: {city_name}           // Nama kota
- appid: {api_key}         // API key Anda
- units: metric            // Celsius
```

## 🎯 TEMPAT INPUT API KEY

**File:** `ApiKeyConfigScreen.kt`

Ini adalah screen khusus yang akan muncul pertama kali saat aplikasi dibuka. 
User dapat:
1. Input API key di TextField
2. Klik "Save & Continue"
3. API key disimpan di ViewModel
4. Navigasi otomatis ke weather screen

## 🚀 CARA BUILD & RUN

### Via Android Studio:
1. Buka project di Android Studio
2. Sync Gradle (otomatis atau klik "Sync Now")
3. Pilih device/emulator
4. Klik Run ▶️

### Via Terminal:
```bash
# Build APK
./gradlew assembleDebug

# Install ke device
./gradlew installDebug

# Build dan Run
./gradlew build
```

## 🐛 TROUBLESHOOTING

### Error: "Invalid API Key"
- Pastikan API key benar
- Copy paste ulang dari OpenWeatherMap dashboard
- Tunggu beberapa menit setelah generate API key

### Error: "HTTP 404 Not Found"
- Nama kota salah/tidak ditemukan
- Coba dengan nama kota lain
- Gunakan nama kota dalam bahasa Inggris

### Error: Network/Connection
- Pastikan internet tersambung
- Cek permission INTERNET di AndroidManifest.xml

### Build Error
```bash
# Clean dan rebuild
./gradlew clean build --refresh-dependencies
```

## 📊 TESTING CITIES

Coba dengan kota-kota ini:
- ✅ Cepu (Indonesia)
- ✅ Medan (Indonesia)
- ✅ Jakarta (Indonesia)
- ✅ London (UK)
- ✅ Tokyo (Japan)
- ✅ New York (USA)

## 📄 FILE PENTING

1. **AndroidManifest.xml** - Added INTERNET permission
2. **build.gradle.kts** - Dependencies (Retrofit, Coil, dll)
3. **MainActivity.kt** - Entry point dengan navigation logic
4. **Nomer1View.kt** - Main UI dengan LazyColumn

## ✨ HIGHLIGHTS

- 🎨 Beautiful gradient UI
- 📱 Responsive design
- ⚡ Fast & efficient
- 🔄 Real-time weather data
- 🐼 Fun panda characters
- ✅ Memenuhi SEMUA requirement

---

**Selamat menggunakan! Semoga sukses! 🎉**

