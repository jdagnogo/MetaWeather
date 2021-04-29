package com.jdagnogo.metawheather.repository.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jdagnogo.metawheather.model.City

@Dao
interface CityDao {
    /**
     * this method will insert the data in the Room database
     * Important: in case that the data have the same id, it will replace the old one
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(city: City)

    @Query("SELECT * FROM city")
    fun getAll(): LiveData<List<City>>
}