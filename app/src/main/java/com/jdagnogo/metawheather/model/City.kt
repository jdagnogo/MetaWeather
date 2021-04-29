package com.jdagnogo.metawheather.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.jdagnogo.metawheather.repository.data.MetaWeatherDatabase.Companion.CITY_TABLE

@Entity(tableName = CITY_TABLE)
data class City(
    @PrimaryKey @field:SerializedName("id") val id: String = "",
    @field:SerializedName("woeid") val woeId: String = "",
    @field:SerializedName("name") val name: String = ""
)