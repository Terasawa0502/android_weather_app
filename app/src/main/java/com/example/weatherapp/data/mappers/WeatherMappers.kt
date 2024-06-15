package com.example.weatherapp.data.mappers

import com.example.weatherapp.data.WeatherInfo
import com.example.weatherapp.domain.weather.WeatherData
import com.example.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime

private const val ABSOLUTE_TEMPERATURE = 273.15

// 拡張関数
fun WeatherInfo.toWeatherData(): WeatherData {
    return WeatherData(
        time = LocalDateTime.now(),
        temperatureCelsius = main.temp - ABSOLUTE_TEMPERATURE,
        pressure = main.pressure,
        windSpeed = wind.speed,
        humidity = main.humidity,
        weatherType = WeatherType.fromWeatherId(weather.first().id)
    )
}