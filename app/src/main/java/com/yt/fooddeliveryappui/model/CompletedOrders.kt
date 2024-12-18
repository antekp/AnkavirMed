package com.yt.fooddeliveryappui.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val items: List<Food>,
    val timestamp: Long = System.currentTimeMillis() // Use the current time as the default value
) : Parcelable
