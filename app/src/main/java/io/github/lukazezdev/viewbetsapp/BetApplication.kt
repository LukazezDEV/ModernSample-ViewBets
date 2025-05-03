package io.github.lukazezdev.viewbetsapp

import android.app.Application
import io.github.lukazezdev.viewbetsapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BetApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BetApplication)
            modules(appModule)
        }
    }
}