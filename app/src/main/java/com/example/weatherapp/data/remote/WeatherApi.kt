package com.example.weatherapp.data.remote

import com.example.weatherapp.data.WeatherInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getWeatherInfo(
        @Query("appid") appid: String,
        @Query("q") q: String,
        @Query("lang") lang: String
    ): WeatherInfo
}