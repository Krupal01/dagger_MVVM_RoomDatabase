package com.example.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.home.repository.ProductRepo
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private var map : Map<Class<*>, @JvmSuppressWildcards ViewModel>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}