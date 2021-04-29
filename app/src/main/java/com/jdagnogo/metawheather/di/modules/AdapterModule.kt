package com.jdagnogo.metawheather.di.modules

import com.jdagnogo.metawheather.ui.adapter.CityAdapter
import com.jdagnogo.metawheather.ui.adapter.CityComparator
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
    fun provideStoreListAdapter(comparator: CityComparator): CityAdapter =
        CityAdapter(comparator)
}