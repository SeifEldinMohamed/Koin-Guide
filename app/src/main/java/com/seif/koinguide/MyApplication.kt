package com.seif.koinguide

import android.app.Application
import com.seif.koinguide.di.activityModule
import com.seif.koinguide.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger() // to enable logging feature of koin
            androidContext(this@MyApplication)// used when we want to inject the application context
            modules(appModule, activityModule)
        }
    }
}