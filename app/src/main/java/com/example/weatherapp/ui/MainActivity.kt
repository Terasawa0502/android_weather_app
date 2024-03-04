package com.example.weatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.R
import com.example.weatherapp.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // MainFragmentをセットする
        val mainFragment = MainFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, mainFragment)
            .commit()
    }
}