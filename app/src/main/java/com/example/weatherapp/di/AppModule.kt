package com.example.weatherapp.di

import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.repository.WeatherRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

// dagger-hilt用が勝手に生成するためのレシピ的なもの
@Module
@InstallIn(SingletonComponent::class)
object AppModule  {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}