package com.jdagnogo.metawheather.di.modules

import com.jdagnogo.metawheather.ui.CityDetailsFragment
import com.jdagnogo.metawheather.ui.HomeFragment
import com.jdagnogo.metawheather.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector()
    abstract fun contributeCityWeatherFragment(): CityDetailsFragment
}