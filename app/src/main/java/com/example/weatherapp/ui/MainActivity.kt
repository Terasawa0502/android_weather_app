package com.example.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.weatherapp.R
import com.example.weatherapp.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // installSplashScreen
        installSplashScreen()
        setTheme(R.style.Theme_WeatherApp)
        setContentView(R.layout.activity_main)

        // MainFragmentをセットする
        val mainFragment = MainFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, mainFragment)
            .commit()
    }
}