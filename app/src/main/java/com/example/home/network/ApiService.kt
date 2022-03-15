package com.example.home.network

import com.example.home.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducList() : Response<List<ProductItem>>
}