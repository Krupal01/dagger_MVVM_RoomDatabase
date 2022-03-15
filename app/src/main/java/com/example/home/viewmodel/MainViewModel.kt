package com.example.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.model.ProductItem
import com.example.home.repository.ProductRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val productRepo: ProductRepo) : ViewModel() {

    val productsLiveData : LiveData<List<ProductItem>>
        get()= productRepo.product

    init {
        viewModelScope.launch {
            productRepo.getProductList()
        }
    }

}