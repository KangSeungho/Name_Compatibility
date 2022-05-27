package app.sosocom.name_compatibility.di

import app.sosocom.data.repository.MainRepositoryImpl
import app.sosocom.data.repository.remote.SplashRepositoryImpl
import app.sosocom.data.repository.remote.datasource.MainDataSource
import app.sosocom.data.repository.remote.datasource.SplashDataSource
import app.sosocom.domain.repository.MainRepository
import app.sosocom.domain.repository.SplashRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMainRepository(
        mainDataSource: MainDataSource
    ) : MainRepository {
        return MainRepositoryImpl(mainDataSource)
    }

    @Provides
    fun provideSplashRepository(
        splashDataSource: SplashDataSource
    ): SplashRepository {
        return SplashRepositoryImpl(splashDataSource)
    }
}