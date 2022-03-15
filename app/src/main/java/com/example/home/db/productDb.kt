package com.example.home.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.home.model.ProductItem

@Database(entities = [ProductItem::class], version = 1)
abstract class ProductDb :RoomDatabase(){

    abstract fun getProductDao() : ProductDao
}