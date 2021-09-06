package com.learn.lavsam.mytranslatorl41.application

import android.app.Application
import com.learn.lavsam.mytranslatorl41.di.application
import com.learn.lavsam.mytranslatorl41.di.mainScreen
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}
