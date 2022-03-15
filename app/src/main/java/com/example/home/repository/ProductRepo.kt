package com.example.home.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.home.db.ProductDb
import com.example.home.model.ProductItem
import com.example.home.network.ApiService
import javax.inject.Inject

class ProductRepo @Inject constructor(private val apiService: ApiService , private var productDb1: ProductDb) {

    private val _products = MutableLiveData<List<ProductItem>>()
    val product :LiveData<List<ProductItem>>
        get() = _products

    suspend fun getProductList(){
        val response = apiService.getProducList()
        if (response.isSuccessful && response.body()!=null){
            productDb1.getProductDao().addAll(response.body()!!)
            _products.postValue(response.body())
        }
    }

}