package com.example.weatherapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherInfo
import com.example.weatherapp.data.mappers.toWeatherData
import com.example.weatherapp.domain.weather.WeatherData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment @Inject constructor(): Fragment() {


    // static領域みたいな
    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels();
    private lateinit var todayTimeText: TextView
    private lateinit var weatherImage: ImageView
    private lateinit var currentTempText:TextView
    private lateinit var weatherDescriptionText: TextView
    private lateinit var pressureText: TextView
    private lateinit var dropText: TextView
    private lateinit var windText: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        todayTimeText = view.findViewById(R.id.time_text)
        weatherImage = view.findViewById(R.id.weather_image)
        currentTempText = view.findViewById(R.id.temp_text)
        weatherDescriptionText = view.findViewById(R.id.weather_description_text)
        pressureText = view.findViewById(R.id.pressure_text)
        dropText = view.findViewById(R.id.drop_text)
        windText = view.findViewById(R.id.wind_text)
    }
    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            viewModel.getWeatherInfo(
                q= "KAWASAKI",
                lang = "ja"
            ).let { result ->
                result.data?.toWeatherData()?.let { weatherData ->
                    updateDisplay(weatherData)
                }
                val message = result.message.toString()
            }
        }
    }

    private fun updateDisplay (weatherData: WeatherData) {
        todayTimeText.text = weatherData.time.let{ time -> "今日 ${time.hour}:${time.minute}" }
        weatherImage.setImageResource(weatherData.weatherType.iconRes)
        currentTempText.text = getString(R.string.temp_value, weatherData.temperatureCelsius)
        weatherDescriptionText.text = weatherData.weatherType.weatherDesc
        pressureText.text = getString(R.string.pressure_value, weatherData.pressure)
        dropText.text = "${weatherData.humidity}%"
        windText.text = getString(R.string.wind_value,weatherData.windSpeed.toInt())
    }
}