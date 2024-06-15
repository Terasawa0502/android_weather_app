package com.example.weatherapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.weatherapp.R
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
        view.findViewById<Button>(R.id.button).setOnClickListener {
            lifecycleScope.launch {
                viewModel.getWeatherInfo(
                    q= "KAWASAKI",
                    lang = "ja"
                ).let { result ->
                    val data = result.data.toString()
                    val message = result.message.toString()
                    Log.d("TEST", "data: $data / message: $message")
                }
            }
        }
    }
}