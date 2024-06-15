package com.example.weatherapp.domain.weather

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Int,
    val windSpeed: Double,
    val humidity: Int,
    val weatherType: WeatherType
)
