package com.jdagnogo.metawheather.di.modules

import com.jdagnogo.metawheather.ui.adapter.CityAdapter
import com.jdagnogo.metawheather.ui.adapter.CityComparator
import com.jdagnogo.metawheather.ui.adapter.WeatherAdapter
import com.jdagnogo.metawheather.ui.adapter.WeatherComparator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AdapterModule {
    @Provides
    @Singleton
    fun provideComparator(): CityComparator = CityComparator()


    @Provides
    @Singleton
    fun provideCityAdapter(comparator: CityComparator): CityAdapter =
        CityAdapter(comparator)

    @Provides
    @Singleton
    fun provideWeatherComparator(): WeatherComparator = WeatherComparator()


    @Provides
    @Singleton
    fun provideWeatherAdapter(comparator: WeatherComparator): WeatherAdapter =
            WeatherAdapter(comparator)
}