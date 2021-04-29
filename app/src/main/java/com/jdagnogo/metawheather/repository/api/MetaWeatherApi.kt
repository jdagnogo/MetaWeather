package com.jdagnogo.metawheather.repository.api

import com.jdagnogo.metawheather.model.Weather
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * This class will retrieved the data from the api.
 */
interface MetaWeatherApi {
    @GET(GET_LOCATION_DAY)
    suspend fun getWeather(
        @Path(value = "woeid") woeId: String,
        @Path(value = "year") year: String,
        @Path(value = "month") month: String,
        @Path(value = "day") day: String
    ): List<Weather>

    companion object {
        const val BASE_URL = "https://www.metaweather.com/"
        private const val GET_LOCATION_DAY = "/api/location/{woeid}/{year}/{month}/{day}"
    }
}