package com.jason.week7lab.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.jason.week7lab.R
import com.jason.week7lab.data.model.*
import com.jason.week7lab.ui.components.WeatherDetailCard
import com.jason.week7lab.utils.Constants
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun WeatherContent(weather: WeatherResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

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


            Image(
                painter = painterResource(id = getWeatherPandaDrawable(weather.weather.firstOrNull()?.main ?: "Clear")),
                contentDescription = "Weather Panda",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        if (weather.weather.isNotEmpty()) {
            Text(
                text = weather.weather[0].main,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }


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
                iconRes = R.drawable.humidity,
                label = "HUMIDITY",
                value = "${weather.main.humidity}%"
            )

            WeatherDetailCard(
                iconRes = R.drawable.angin,
                label = "WIND",
                value = "${weather.wind.speed.toInt()} km/h"
            )

            WeatherDetailCard(
                iconRes = R.drawable.temperatur,
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
                iconRes = R.drawable.hujan,
                label = "RAINFALL",
                value = "0.0 mm"
            )

            WeatherDetailCard(
                iconRes = R.drawable.devices,
                label = "PRESSURE",
                value = "${weather.main.pressure} hPa"
            )

            WeatherDetailCard(
                iconRes = R.drawable.awan,
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
                iconRes = R.drawable.sunrise,
                label = "SUNRISE",
                value = formatTime(weather.sys.sunrise)
            )

            WeatherDetailCard(
                iconRes = R.drawable.sunset,
                label = "SUNSET",
                value = formatTime(weather.sys.sunset)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

/**
 * Helper function to get the appropriate panda drawable based on weather
 */
fun getWeatherPandaDrawable(weatherMain: String): Int {
    return when (weatherMain.lowercase()) {
        "clear" -> R.drawable.panda_cerah
        "clouds" -> R.drawable.panda_berawan
        "rain", "drizzle", "thunderstorm" -> R.drawable.panda_hujan
        else -> R.drawable.panda_cerah
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

