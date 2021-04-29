package com.jdagnogo.metawheather.repository.api

import javax.inject.Inject

class WeatherRemoteData  @Inject constructor(
    private val api: MetaWeatherApi) {
}