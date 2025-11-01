# 🔑 CARA INPUT API KEY

## Langkah-langkah Detail:

### 1. Pertama Kali Membuka Aplikasi

Ketika Anda pertama kali menjalankan aplikasi, Anda akan melihat **API Key Configuration Screen** dengan tampilan:
- Background gradient biru
- Icon cuaca besar 🌤️
- Judul "Weather App Setup"
- TextField untuk input API key
- Tombol "Save & Continue"
- Info cara mendapatkan API key

### 2. Input API Key

```
┌─────────────────────────────────────────┐
│         Weather App Setup               │
│                                         │
│   Please enter your OpenWeatherMap     │
│              API Key                    │
│                                         │
│  ┌───────────────────────────────────┐ │
│  │ API Key                           │ │
│  │ [Paste your API key here]        │ │
│  └───────────────────────────────────┘ │
│                                         │
│  ┌───────────────────────────────────┐ │
│  │     Save & Continue               │ │
│  └───────────────────────────────────┘ │
│                                         │
│  ℹ️ How to get API Key:                │
│  1. Visit https://openweathermap...   │
│  2. Sign up for free                   │
│  3. Get your API key                   │
│  4. Paste it above                     │
└─────────────────────────────────────────┘
```

### 3. Langkah Input:

1. **Klik TextField** yang bertuliskan "Enter your API key here"
2. **Paste API Key** Anda (contoh: `abcd1234efgh5678ijkl9012mnop3456`)
3. **Klik tombol "Save & Continue"**
4. Aplikasi akan otomatis pindah ke weather screen

### 4. API Key Tersimpan

Setelah Anda input API key:
- ✅ API key disimpan di WeatherViewModel
- ✅ Tidak perlu input ulang selama aplikasi berjalan
- ✅ Langsung bisa search cuaca

### 5. Jika Sudah Ada API Key

Jika API key sudah di-set, di bagian bawah tombol akan muncul:
- ✓ Text hijau: "API Key is already set"
- Tombol "Continue to App" untuk langsung ke main screen

## 📝 Contoh API Key

API Key biasanya berbentuk string panjang seperti:
```
a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6
```

**PENTING:** 
- Gunakan API key GRATIS dari OpenWeatherMap
- Jangan share API key Anda ke orang lain
- Simpan API key dengan aman

## 🔄 Cara Ganti API Key

Jika ingin ganti API key:
1. Close aplikasi
2. Buka ulang aplikasi
3. Screen config akan muncul lagi
4. Input API key baru
5. Klik "Save & Continue"

## 💡 Tips

- Copy-paste API key langsung dari email/dashboard OpenWeatherMap
- Pastikan tidak ada spasi di awal atau akhir
- Jika error "Invalid API Key", tunggu 10-15 menit (API key baru butuh aktivasi)

## 🎯 Di Kode

API key dikelola di:
```kotlin
// File: WeatherViewModel.kt
private val _apiKey = MutableStateFlow("")
val apiKey: StateFlow<String> = _apiKey.asStateFlow()

fun setApiKey(key: String) {
    _apiKey.value = key
}
```

Digunakan untuk API call di:
```kotlin
// File: WeatherRepository.kt
suspend fun getWeather(cityName: String, apiKey: String): Result<WeatherResponse>
```

## ✅ Done!

Setelah API key di-set, Anda bisa langsung menggunakan aplikasi untuk cek cuaca di berbagai kota!

