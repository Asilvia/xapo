package com.asilvia.xapo

import android.app.Application
import com.asilvia.xapo.shared.network.GitHubServiceAPI
import org.koin.core.context.startKoin
import org.koin.dsl.module

class XapoApplication : Application() {
    var listofModules = module {
        single { GitHubServiceAPI() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listofModules)
        }
    }
}