package com.example.home.module

import androidx.lifecycle.ViewModel
import com.example.home.viewmodel.MainViewModel
import com.example.home.viewmodel.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {


//    @StringKey("mainViewModel")
    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun mainViewModel(mainViewModel: MainViewModel) : ViewModel


//    @StringKey("mainViewModel2")
    @Binds
    @ClassKey(MainViewModel2::class)
    @IntoMap
    abstract fun mainViewModel2(mainViewModel2: MainViewModel2) : ViewModel


}