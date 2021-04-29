package com.jdagnogo.metawheather.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.jdagnogo.metawheather.repository.data.MetaWeatherDatabase.Companion.CITY_TABLE

/**
 * This data class represent an City
 * WoeId is the unique identifier from the api
 */
@Entity(tableName = CITY_TABLE)
data class City(
    @PrimaryKey @field:SerializedName("woeid") val woeId: String = "",
    @field:SerializedName("name") val name: String = ""
)