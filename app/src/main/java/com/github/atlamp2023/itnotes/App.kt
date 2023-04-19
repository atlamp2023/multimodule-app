package com.github.atlamp2023.itnotes

import android.app.Application
import com.github.atlamp2023.itnotes.di.appModule
import com.github.atlamp2023.itnotes.di.dataModule
import com.github.atlamp2023.itnotes.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            //androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(
                appModule,
                dataModule,
                domainModule
            )
        }
    }
}