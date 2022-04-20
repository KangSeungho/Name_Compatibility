package app.sosocom.name_compatibility.di

import app.sosocom.data.remote.api.LoveCalculatorApi
import app.sosocom.data.repository.remote.datasource.MainDataSource
import app.sosocom.data.repository.remote.datasourceimpl.MainDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        loveCalculatorApi: LoveCalculatorApi
    ) : MainDataSource {
        return MainDataSourceImpl(
            loveCalculatorApi
        )
    }
}