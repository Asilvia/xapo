package com.asilvia.xapo

import android.app.Application
import com.asilvia.xapo.main.di.MainModule
import com.asilvia.xapo.shared.di.ApiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class XapoApplication : Application() {

    var listofModules = listOf(
        ApiModule.retrofitModule,
        MainModule.module,
        ApiModule.apiModule)


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@XapoApplication)
            modules(listofModules)
        }
    }
}