package br.com.carolchiaradia.modularizacao

import android.app.Application
import br.com.carolchiaradia.data.di.dataModules
import br.com.carolchiaradia.domain.di.domainModule
import br.com.carolchiaradia.modularizacao.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(domainModule + dataModules + listOf(presentationModule))
        }
    }
}