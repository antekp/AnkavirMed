package com.yt.fooddeliveryappui.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yt.fooddeliveryappui.model.Order


@Dao
interface OrderHistoryDao {

    @Query("SELECT * FROM orders")
    fun getAllOrders(): LiveData<List<Order>>

    @Insert
    fun addOrder(order: Order)

}