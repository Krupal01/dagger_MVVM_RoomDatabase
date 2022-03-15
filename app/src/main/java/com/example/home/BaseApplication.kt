package com.example.home

import android.app.Application
import com.example.home.component.ApplicationComponent
import com.example.home.component.DaggerApplicationComponent

class BaseApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(applicationContext)

    }
}