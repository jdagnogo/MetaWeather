package com.jdagnogo.metawheather.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.jdagnogo.metawheather.createUrl
import com.jdagnogo.metawheather.databinding.ListWeatherBinding
import com.jdagnogo.metawheather.displayAs
import com.jdagnogo.metawheather.model.Weather

class WeatherViewHolder(private val binding: ListWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
                parent: ViewGroup
        ): WeatherViewHolder {
            val binding =
                    ListWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return WeatherViewHolder(binding)
        }

        private const val HUMIDITY = "Humidity"
        private const val PREDICABILITY = "Predicability"
        private const val DIRECTION_COMPASS = "Compass"
    }

    fun bind(weather: Weather) {
        with(binding) {
            weatherHumidity.text = weather.humidity.displayAs(HUMIDITY)
            weatherAirPressure.text = weather.directionCompass.displayAs(DIRECTION_COMPASS)
            weatherPredictability.text = weather.predictability.displayAs(PREDICABILITY)
            val requestOptions = RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
            Glide
                    .with(itemView.context)
                    .load(weather.stateAbbr.createUrl())
                    .apply(requestOptions)
                    .into(weatherIcon)
        }
    }

}