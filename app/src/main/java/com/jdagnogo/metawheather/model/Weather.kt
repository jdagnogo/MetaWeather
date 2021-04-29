package com.jdagnogo.metawheather.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "consolidate_weather")
data class Weather(
    @PrimaryKey @field:SerializedName("id") val id: String = "",
    @field:SerializedName("weather_state_name") val stateName: String = "",
    @field:SerializedName("weather_state_abbr") val stateAbbe: String = "",
    @field:SerializedName("location") val location: String = "",
    @field:SerializedName("data") val date: Date = Calendar.getInstance().time,
    @field:SerializedName("wind_direction_compass") val directionCompass: String = "",
    @field:SerializedName("min_temp") val minTemp: Float = 0f,
    @field:SerializedName("max_temp") val maxTemp: Float = 0f,
    @field:SerializedName("wind_speed") val windSpeed: Float = 0f,
    @field:SerializedName("wind_direction") val windDirection: Float = 0f,
    @field:SerializedName("humidity") val humidity: Float = 0f,
    @field:SerializedName("predictability") val predictability: Float = 0f
)