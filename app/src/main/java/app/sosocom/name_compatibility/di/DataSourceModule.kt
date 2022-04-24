package app.sosocom.name_compatibility.di

import app.sosocom.data.remote.api.LoveCalculatorApi
import app.sosocom.data.repository.remote.datasource.MainDataSource
import app.sosocom.data.repository.remote.datasource.SplashDataSource
import app.sosocom.data.repository.remote.datasourceimpl.MainDataSourceImpl
import app.sosocom.data.repository.remote.datasourceimpl.SplashDataSourceImpl
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
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
        loveCalculatorApi: LoveCalculatorApi,
        firebaseRTDB: FirebaseDatabase,
        fireStore: FirebaseFirestore
    ) : MainDataSource {
        return MainDataSourceImpl(loveCalculatorApi, firebaseRTDB, fireStore)
    }

    @Provides
    @Singleton
    fun provideSplashDataSource(
        firebaseRTDB : FirebaseDatabase,
        fireStore: FirebaseFirestore
    ) : SplashDataSource {
        return SplashDataSourceImpl(firebaseRTDB, fireStore)
    }
}