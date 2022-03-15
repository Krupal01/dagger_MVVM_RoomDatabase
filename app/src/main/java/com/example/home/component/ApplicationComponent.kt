package com.example.home.component

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.home.module.DatabaseModule
import com.example.home.module.NetworkModule
import com.example.home.module.ViewModelModule
import com.example.home.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class , DatabaseModule::class , ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun getViewModelMap() : Map<Class<*>,ViewModel>

    @Component.Factory
    interface factory{
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}