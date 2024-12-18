package com.yt.fooddeliveryappui

import android.app.Application
import androidx.room.Room
import com.yt.fooddeliveryappui.database.OrderDataBase

class DataBaseActivity: Application(){

    companion object{
        lateinit var orderDataBase: OrderDataBase
    }

    override fun onCreate() {
        super.onCreate()
        orderDataBase = Room.databaseBuilder(
            applicationContext,
            OrderDataBase::class.java,
            OrderDataBase.NAME
        ).build()
    }

}