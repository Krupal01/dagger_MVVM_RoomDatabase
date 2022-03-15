package com.example.home.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.home.model.ProductItem

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(products : List<ProductItem>)

    @Query("select * from productitem")
    fun getAll() : List<ProductItem>

}