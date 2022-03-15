package com.example.home.module

import android.content.Context
import androidx.room.Room
import com.example.home.db.ProductDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDataBase(context : Context) : ProductDb {
        return Room.databaseBuilder(context , ProductDb::class.java , "ProductDb").build()
    }

}