package com.jason.week7lab.uiview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.jason.week7lab.data.model.*
import com.jason.week7lab.ui.theme.Week7LabTheme
import com.jason.week7lab.utils.Constants
import com.jason.week7lab.viewmodel.WeatherUiState
import com.jason.week7lab.viewmodel.WeatherViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable aasdasdasd
fun Soal1View(viewModel: WeatherViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A237E),
                        Color(0xFF283593),
                        Color(0xFF3949AB),
                        Color(0xFF5C6BC0)
                    )
                )
            )
    ) {
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

            // Content based on state
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

@Composable
fun SearchBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* Menu action */ },
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.2f))
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.White
            )
        }

        OutlinedTextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            modifier = Modifier.weight(1f),
            placeholder = {
                Text(
                    "Enter city name...",
                    color = Color.White.copy(alpha = 0.6f)
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White.copy(alpha = 0.5f),
                cursorColor = Color.White
            ),
            shape = RoundedCornerShape(24.dp),
            singleLine = true
        )

        IconButton(
            onClick = onSearch,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.2f))
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White
            )
        }
    }
}

@Composable
fun InitialView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            tint = Color.White.copy(alpha = 0.5f)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Search for a city to get started",
            fontSize = 18.sp,
            color = Color.White.copy(alpha = 0.7f),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoadingView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        CircularProgressIndicator(
            color = Color.White,
            modifier = Modifier.size(60.dp)
        )
    }
}

@Composable
fun ErrorView(message: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "⚠️",
            fontSize = 80.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Oops! Something went wrong",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = message,
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.8f),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun WeatherContent(weather: WeatherResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Location Pin Icon and City Name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(
                text = "📍 ${weather.name}",
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }

        // Date
        Text(
            text = formatDate(weather.dt),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "Updated as of ${formatTime(weather.dt)}",
            fontSize = 12.sp,
            color = Color.White.copy(alpha = 0.7f),
            modifier = Modifier.padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Weather Icon and Main Info
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Weather Icon from API
            if (weather.weather.isNotEmpty()) {
                val iconCode = weather.weather[0].icon
                val iconUrl = "${Constants.ICON_URL}${iconCode}@2x.png"

                Image(
                    painter = rememberAsyncImagePainter(iconUrl),
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Panda character placeholder
            Text(
                text = getWeatherEmoji(weather.weather.firstOrNull()?.main ?: "Clear"),
                fontSize = 100.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Weather Description
        if (weather.weather.isNotEmpty()) {
            Text(
                text = weather.weather[0].main,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        // Temperature
        Text(
            text = "${weather.main.temp.toInt()}°C",
            fontSize = 72.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Weather Details Grid
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherDetailCard(
                icon = "💧",
                label = "HUMIDITY",
                value = "${weather.main.humidity}%"
            )

            WeatherDetailCard(
                icon = "💨",
                label = "WIND",
                value = "${weather.wind.speed.toInt()} km/h"
            )

            WeatherDetailCard(
                icon = "🌡️",
                label = "FEELS LIKE",
                value = "${weather.main.feelsLike.toInt()}°"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherDetailCard(
                icon = "🌧️",
                label = "RAINFALL",
                value = "0.0 mm"
            )

            WeatherDetailCard(
                icon = "🔽",
                label = "PRESSURE",
                value = "${weather.main.pressure} hPa"
            )

            WeatherDetailCard(
                icon = "☁️",
                label = "CLOUDS",
                value = "${weather.clouds.all}%"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sunrise and Sunset
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherDetailCard(
                icon = "🌅",
                label = "SUNRISE",
                value = formatTime(weather.sys.sunrise)
            )

            WeatherDetailCard(
                icon = "🌇",
                label = "SUNSET",
                value = formatTime(weather.sys.sunset)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun WeatherDetailCard(icon: String, label: String, value: String) {
    Card(
        modifier = Modifier
            .width(110.dp)
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.15f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = icon,
                fontSize = 28.sp
            )
            Text(
                text = label,
                fontSize = 10.sp,
                color = Color.White.copy(alpha = 0.7f),
                fontWeight = FontWeight.Medium
            )
            Text(
                text = value,
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

fun getWeatherEmoji(weatherMain: String): String {
    return when (weatherMain.lowercase()) {
        "clear" -> "🐼"
        "clouds" -> "🐼"
        "rain" -> "🐼"
        "drizzle" -> "🐼"
        "thunderstorm" -> "🐼"
        "snow" -> "🐼"
        else -> "🐼"
    }
}

fun formatDate(timestamp: Long): String {
    val sdf = SimpleDateFormat("MMMM dd", Locale.ENGLISH)
    return sdf.format(Date(timestamp * 1000))
}

fun formatTime(timestamp: Long): String {
    val sdf = SimpleDateFormat("h:mm a", Locale.ENGLISH)
    return sdf.format(Date(timestamp * 1000))
}

// Preview untuk melihat UI tanpa menjalankan emulator
@Preview(showBackground = true, showSystemUi = true, name = "Weather App Preview")
@Composable
fun Nomer1ViewPreview() {
    Week7LabTheme {
        Soal1View()
    }
}

@Preview(showBackground = false, name = "Weather Content with Data")
@Composable
fun WeatherContentPreview() {
    Week7LabTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1A237E),
                            Color(0xFF283593),
                            Color(0xFF3949AB),
                            Color(0xFF5C6BC0)
                        )
                    )
                )
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    WeatherContent(
                        weather = WeatherResponse(
                            coord = Coord(lon = 106.85, lat = -6.21),
                            weather = listOf(
                                Weather(
                                    id = 800,
                                    main = "Clear",
                                    description = "clear sky",
                                    icon = "01d"
                                )
                            ),
                            base = "stations",
                            main = Main(
                                temp = 30.5,
                                feelsLike = 33.2,
                                tempMin = 29.0,
                                tempMax = 32.0,
                                pressure = 1012,
                                humidity = 70
                            ),
                            visibility = 10000,
                            wind = Wind(speed = 3.5, deg = 180, gust = null),
                            clouds = Clouds(all = 20),
                            dt = System.currentTimeMillis() / 1000,
                            sys = Sys(
                                type = 1,
                                id = 9374,
                                country = "ID",
                                sunrise = 1635724800,
                                sunset = 1635768000
                            ),
                            timezone = 25200,
                            id = 1642911,
                            name = "Jakarta",
                            cod = 200
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false, name = "Initial State Preview")
@Composable
fun InitialViewPreview() {
    Week7LabTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1A237E),
                            Color(0xFF283593),
                            Color(0xFF3949AB),
                            Color(0xFF5C6BC0)
                        )
                    )
                )
        ) {
            InitialView()
        }
    }
}

@Preview(showBackground = false, name = "Loading State Preview")
@Composable
fun LoadingViewPreview() {
    Week7LabTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1A237E),
                            Color(0xFF283593),
                            Color(0xFF3949AB),
                            Color(0xFF5C6BC0)
                        )
                    )
                )
        ) {
            LoadingView()
        }
    }
}

@Preview(showBackground = false, name = "Error State Preview")
@Composable
fun ErrorViewPreview() {
    Week7LabTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1A237E),
                            Color(0xFF283593),
                            Color(0xFF3949AB),
                            Color(0xFF5C6BC0)
                        )
                    )
                )
        ) {
            ErrorView("City not found. Please try another city.")
        }
    }
}


