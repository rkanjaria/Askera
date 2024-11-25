package com.ai.askera.ui.main

import android.app.Application
import com.ai.askera.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AskeraApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AskeraApp)
            androidLogger()
            modules(appModule)
        }
    }
}