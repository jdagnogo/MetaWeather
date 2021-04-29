package com.jdagnogo.metawheather.repository

import com.jdagnogo.metawheather.getKnownCities
import com.jdagnogo.metawheather.model.City
import com.jdagnogo.metawheather.model.Resource
import com.jdagnogo.metawheather.model.Weather
import com.jdagnogo.metawheather.repository.api.WeatherRemoteData
import com.jdagnogo.metawheather.repository.data.CityDao
import com.jdagnogo.metawheather.repository.data.WeatherDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class WeatherRepository @Inject constructor(
        private val remoteData: WeatherRemoteData,
        private val cityDao: CityDao,
        private val dao: WeatherDao) {
    /**
     * An improvement could be to retrive the data from the cityDao
     * And add an functionnality to add them in the database
     */
    suspend fun getCities(): Flow<List<City>> = flow {
        // in the furtur we could used the cityDao in order to retrieve the data from DB
        // for now i will use the default values
        emit(getKnownCities())
    }

    fun getWeathers(location : String, date : Date) :Flow<Resource<List<Weather>>>{
        return resourceAsFlow(
                fetchFromLocal = { dao.getAll(location, date) },
                networkCall = { remoteData.fetchData(location, date) },
                saveCallResource = { weathers -> dao.insertAll(weathers) })
    }

}