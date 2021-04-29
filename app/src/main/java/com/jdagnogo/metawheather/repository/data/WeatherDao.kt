package com.jdagnogo.metawheather.repository.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jdagnogo.metawheather.model.Weather
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    /**
     * this method will insert the data in the Room database
     * Important: in case that the data have the same id, it will replace the old one
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(venues: List<Weather>)

    /**
     * this method will retrieve the data in the Room database
     * It will return only the data with the correct query
     */
    @Query("SELECT * FROM consolidate_weather WHERE `location` LIKE :queryString")
    fun getAll(queryString: String): Flow<List<Weather>>
}