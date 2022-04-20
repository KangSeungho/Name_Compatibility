package app.sosocom.name_compatibility.di

import app.sosocom.domain.repository.MainRepository
import app.sosocom.domain.usecase.CheckLoveCalculatorUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideCheckLoveCalculatorUseCase(repository : MainRepository) = CheckLoveCalculatorUseCase(repository)
}