package app.sosocom.name_compatibility.di

import app.sosocom.data.repository.MainRepositoryImpl
import app.sosocom.data.repository.remote.datasource.MainDataSource
import app.sosocom.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        mainDataSource: MainDataSource
    ) : MainRepository {
        return MainRepositoryImpl(
            mainDataSource
        )
    }
}