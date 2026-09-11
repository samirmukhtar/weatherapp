package com.horncoder.weatherapp.model.api

import com.horncoder.weatherapp.model.response.Constant
import com.horncoder.weatherapp.model.response.WeatherResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherWebServices  {
    private var api: WeatherApi
    val baseUrl = "https://api.weatherapi.com"

    init {
        val retrofit =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit.create(WeatherApi::class.java)
    }

    suspend fun getWeather(city: String): Response<WeatherResponse> {
        return api.getWeather(Constant.apikey, city)
    }

}