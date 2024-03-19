package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.WeatherInfo
import com.example.weatherapp.domain.util.Resource

interface WeatherRepository {

    suspend fun getWeatherInfo(q: String, lang: String): Resource<WeatherInfo>
}