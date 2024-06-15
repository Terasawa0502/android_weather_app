package com.example.weatherapp.ui.main

import androidx.lifecycle.ViewModel
import com.example.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val weatherRepository: WeatherRepository
) : ViewModel() {

    suspend fun getWeatherInfo(q:String, lang:String) = withContext(Dispatchers.IO){
        weatherRepository.getWeatherInfo(q, lang)
    }
}