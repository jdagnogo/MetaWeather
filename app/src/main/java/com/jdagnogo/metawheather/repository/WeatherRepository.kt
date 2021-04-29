package com.jdagnogo.metawheather.repository

import com.jdagnogo.metawheather.getKnownCities
import com.jdagnogo.metawheather.model.City
import com.jdagnogo.metawheather.repository.api.WeatherRemoteData
import com.jdagnogo.metawheather.repository.data.CityDao
import com.jdagnogo.metawheather.repository.data.WeatherDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepository @Inject constructor(
        private val remoteData: WeatherRemoteData,
        private val cityDao: CityDao,
        private val dao: WeatherDao) {

    suspend fun getCities(): Flow<List<City>> = flow {
        emit(getKnownCities())
    }

}