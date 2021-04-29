package com.jdagnogo.metawheather.di.modules

import android.content.Context
import com.jdagnogo.metawheather.MetaWeatherApplication
import com.jdagnogo.metawheather.di.utils.AppContext

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    @AppContext
    @Provides
    @Singleton
    fun provideContext(application: MetaWeatherApplication): Context = application
}