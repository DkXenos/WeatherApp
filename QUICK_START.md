# 🚀 QUICK START GUIDE

## ⚡ Memulai Aplikasi dalam 3 Langkah

### 1️⃣ GET API KEY (5 menit)
1. Buka browser → https://openweathermap.org/price
2. Klik **"Get API key"** di bagian "Free" 
3. Sign up dengan email
4. Verify email
5. Login → Dashboard → API Keys
6. Copy API key Anda (format: `abc123def456...`)

### 2️⃣ RUN APLIKASI
```bash
# Di Android Studio:
1. Open project di folder Week7Lab
2. Klik tombol Run ▶️ (atau Shift + F10)
3. Pilih emulator atau device
4. Tunggu build selesai
```

### 3️⃣ GUNAKAN APLIKASI
1. **Screen pertama** akan muncul → API Key Setup
2. **Paste API key** Anda ke TextField
3. **Klik "Save & Continue"**
4. **Main screen** muncul → Ketik nama kota (contoh: "Medan")
5. **Klik Search** → Lihat hasil cuaca! 🎉

---

## 📱 Tampilan Aplikasi

### Screen 1: API Key Setup
```
🌤️
Weather App Setup
Please enter your OpenWeatherMap API Key

┌─────────────────────────────┐
│ [Paste API key here]       │
└─────────────────────────────┘

┌─────────────────────────────┐
│   Save & Continue           │
└─────────────────────────────┘
```

### Screen 2: Weather Search (Initial)
```
🔍 (icon besar)
Search for a city to get started
```

### Screen 3: Weather Data (Success)
```
📍 Medan
September 24
Updated as of 10:00 AM

🌤️ 🐼
    Clear
    31°C

💧 HUMIDITY  💨 WIND     🌡️ FEELS LIKE
   49%        2km/h        32°

🌧️ RAINFALL  🔽 PRESSURE ☁️ CLOUDS
   0.0 mm      1011hPa      8%

🌅 SUNRISE   🌇 SUNSET
   5:22 AM     5:29 PM
```

---

## 🎯 Testing Checklist

Coba fitur-fitur ini untuk memastikan aplikasi berjalan dengan baik:

### ✅ API Key Setup
- [ ] Screen muncul saat pertama buka
- [ ] Bisa input API key
- [ ] Button "Save & Continue" works
- [ ] Pindah ke weather screen

### ✅ Weather Search
- [ ] TextField bisa diketik
- [ ] Button search bisa diklik
- [ ] Loading indicator muncul
- [ ] Data cuaca ditampilkan

### ✅ Weather Display
- [ ] Nama kota benar
- [ ] Tanggal muncul
- [ ] Temperature ditampilkan
- [ ] Icon cuaca dari API muncul
- [ ] Panda emoji muncul
- [ ] Semua detail cards muncul
- [ ] Sunrise/sunset time benar

### ✅ Error Handling
- [ ] Error message muncul jika kota tidak ditemukan
- [ ] Error message jika API key salah
- [ ] Error message user-friendly

### ✅ Scrolling
- [ ] Page bisa di-scroll dengan LazyColumn
- [ ] Smooth scrolling
- [ ] Semua content visible

---

## 🌍 Test Cities (Coba Semua!)

1. **Medan** - Kota di Indonesia
2. **Jakarta** - Ibu kota Indonesia
3. **Cepu** - Kota kecil
4. **London** - UK
5. **Tokyo** - Japan
6. **New York** - USA
7. **Paris** - France

---

## 🐛 Common Issues & Solutions

### Issue 1: "Invalid API Key"
**Solution:**
- Pastikan API key sudah dicopy dengan benar
- Tunggu 10-15 menit setelah generate API key
- Check email untuk aktivasi

### Issue 2: "HTTP 404 Not Found"
**Solution:**
- Nama kota salah atau tidak ada
- Coba nama kota lain
- Gunakan ejaan Inggris

### Issue 3: Build Error
**Solution:**
```bash
cd /Users/jaysn/Documents/VP/Week7Lab
./gradlew clean
./gradlew build
```

### Issue 4: Emulator Lambat
**Solution:**
- Gunakan real device
- Atau enable Hardware Acceleration
- Close aplikasi lain

---

## 📸 Screenshots Required

Untuk demo, ambil screenshot:
1. ✅ API Key setup screen
2. ✅ Initial search screen
3. ✅ Weather data untuk kota "Clear" (Cepu/London)
4. ✅ Weather data untuk kota "Rain" (Medan)
5. ✅ Weather data untuk kota "Clouds" (Jakarta)
6. ✅ Error screen (salah ketik nama kota)

---

## ✨ Features Highlight

### Yang Sudah Diimplementasi:
✅ Model - Data classes lengkap
✅ Service - Retrofit API
✅ Repository - Error handling
✅ ViewModel - State management
✅ View - LazyColumn scrollable
✅ API Key Config - Dedicated screen
✅ TextField & Button - Custom design
✅ Image dari API - Coil loader
✅ Panda Emoji - Dynamic per weather
✅ Error Handling - User friendly
✅ Loading State - Progress indicator
✅ Beautiful UI - Gradient background

### Design Pattern:
✅ MVVM (Model-View-ViewModel)
✅ Repository Pattern
✅ Reactive Programming (StateFlow)
✅ Dependency Injection ready
✅ Clean Architecture

---

## 🎓 Untuk Presentasi

### Penjelasan Singkat:

**"Aplikasi weather ini menggunakan MVVM architecture dengan Jetpack Compose. 

Data flow: User input city → ViewModel → Repository → Retrofit API → OpenWeatherMap → Response mapped to Model → Update State → UI Recompose.

Aplikasi ini menggunakan LazyColumn untuk scrolling, bukan ScrollView. 

Image weather icon diambil langsung dari API menggunakan Coil library. 

Panda emoji berubah otomatis sesuai kondisi cuaca (Clear, Rain, Clouds).

Error handling sudah diimplementasi untuk berbagai skenario seperti city not found, invalid API key, dan network error.

TextField dan Button search mengikuti design yang diminta dengan Material3 dan custom styling."**

---

## 🎉 READY TO GO!

Aplikasi sudah 100% siap digunakan dan dipresentasikan!

**Good luck! 🚀**

