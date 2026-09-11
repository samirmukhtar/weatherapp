package com.horncoder.weatherapp.model

import com.horncoder.weatherapp.model.api.WeatherWebServices
import com.horncoder.weatherapp.model.response.WeatherResponse
import retrofit2.Response

class WeatherRepository(private val webServices: WeatherWebServices = WeatherWebServices()) {
    suspend fun getWeather(city: String): Response<WeatherResponse>{
        return webServices.getWeather(city)
    }
}