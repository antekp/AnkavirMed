package com.yt.fooddeliveryappui.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yt.fooddeliveryappui.model.Food

class Converters {

    @TypeConverter
    fun fromFoodList(foodList: List<Food>): String {
        return Gson().toJson(foodList)
    }

    @TypeConverter
    fun toFoodList(foodListString: String): List<Food> {
        val listType = object : TypeToken<List<Food>>() {}.type
        return Gson().fromJson(foodListString, listType)
    }

    @TypeConverter
    fun fromIntList(intList: List<Int>): String {
        return Gson().toJson(intList)
    }

    @TypeConverter
    fun toIntList(intListString: String): List<Int> {
        val listType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(intListString, listType)
    }

}
