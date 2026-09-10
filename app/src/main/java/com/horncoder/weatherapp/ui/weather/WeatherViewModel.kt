package com.horncoder.weatherapp.ui.weather

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.horncoder.weatherapp.model.WeatherRepository
import com.horncoder.weatherapp.model.response.Constant
import com.horncoder.weatherapp.model.response.Location
import com.horncoder.weatherapp.model.response.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class WeatherViewModel(private val repository: WeatherRepository = WeatherRepository()): ViewModel() {


    suspend fun getData(city: String): Response<WeatherResponse>{

        val response = repository.getWeather(city)
        if (response.isSuccessful){
            Log.d("City", response.body().toString())

        } else {
            Log.d("City", response.message())
        }
        return repository.getWeather(city)
    }


}