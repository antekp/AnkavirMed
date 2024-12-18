package com.yt.fooddeliveryappui.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yt.fooddeliveryappui.model.Order


@Database(entities = [Order::class], version = 1)
@TypeConverters(Converters::class)
abstract class OrderDataBase : RoomDatabase(){

    companion object{
        const val NAME = "OrderDataBase"
    }
    abstract fun getOrderHistoryDao(): OrderHistoryDao

}