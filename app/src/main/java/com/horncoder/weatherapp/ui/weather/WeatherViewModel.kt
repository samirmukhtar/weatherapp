package com.horncoder.weatherapp.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.horncoder.weatherapp.model.WeatherRepository
import com.horncoder.weatherapp.model.api.NetworkResponse
import com.horncoder.weatherapp.model.response.WeatherResponse
import retrofit2.Response

class WeatherViewModel(private val repository: WeatherRepository = WeatherRepository()) :
    ViewModel() {
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherResponse>>()
    val weatherResult: LiveData<NetworkResponse<WeatherResponse>> = _weatherResult

    suspend fun getData(city: String): Response<WeatherResponse> {
        _weatherResult.value = NetworkResponse.Loading
        try {
            val response = repository.getWeather(city)
            if (response.isSuccessful) {
                response.body()?.let {
                    _weatherResult.value = NetworkResponse.Success(it)
                }

            } else {
                _weatherResult.value = NetworkResponse.Error("Failed to load data!")
            }
        } catch (e: Exception) {
            _weatherResult.value = NetworkResponse.Error("Failed to load data!")
        }
        return repository.getWeather(city)
    }


}