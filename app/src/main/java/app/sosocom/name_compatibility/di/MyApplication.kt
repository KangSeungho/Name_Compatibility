package app.sosocom.name_compatibility.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    companion object {
        private lateinit var application: MyApplication
        fun getInstance() = application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}