package com.example.weatherapp.domain.repository

import com.example.weatherapp.data.WeatherInfo
import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.domain.util.Resource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api:WeatherApi
): WeatherRepository {
    override suspend fun getWeatherInfo(q: String, lang: String): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                api.getWeatherInfo(
                    appid = ,
                    q= q,
                    lang= lang
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error.")
        }

    }

}