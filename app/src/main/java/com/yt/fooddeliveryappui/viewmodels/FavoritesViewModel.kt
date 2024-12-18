package com.yt.fooddeliveryappui.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yt.fooddeliveryappui.DataBaseActivity
import com.yt.fooddeliveryappui.model.Food
import com.yt.fooddeliveryappui.model.Order
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    //variables
    private val _favorites = MutableStateFlow<List<Food>>(emptyList())
    val favorites: StateFlow<List<Food>> get() = _favorites

    private val _shopCart = MutableStateFlow<List<Food>>(emptyList())
    val shopCart: StateFlow<List<Food>> get() = _shopCart

    private val orderDao = DataBaseActivity.orderDataBase.getOrderHistoryDao()
    val finishedOrders: LiveData<List<Order>> get() = orderDao.getAllOrders()

    private val _temporaryOrders = MutableStateFlow<List<Order>>(emptyList())
    val temporaryOrders: StateFlow<List<Order>> get() = _temporaryOrders

    //cart shopping functions
    fun addToCart(food: Food)
    {
        viewModelScope.launch {
            val currentList = _shopCart.value.toMutableList()
            currentList.add(food)
            _shopCart.value = currentList
        }
    }

    fun deleteFromToCart(food: Food)
    {
        viewModelScope.launch {
            val currentList = _shopCart.value.toMutableList()
            currentList.remove(food)
            _shopCart.value = currentList
        }
    }

    //favorite functions
    fun addFavorite(food: Food) {
        viewModelScope.launch {
            val currentList = _favorites.value.toMutableList()
            if (!currentList.contains(food)) {
                currentList.add(food)
                _favorites.value = currentList
            }
        }
    }
    fun removeFavorite(food: Food) {
        viewModelScope.launch {
            val currentList = _favorites.value.toMutableList()
            if (currentList.contains(food)) {
                currentList.remove(food)
                _favorites.value = currentList
            }
        }
    }
    fun isFavorite(food: Food): Boolean {
        return _favorites.value.contains(food)
    }

    //order functions

    fun completeOrder() {
        viewModelScope.launch {
            val cartItems = _shopCart.value.toList()
            if (cartItems.isNotEmpty()) {

                viewModelScope.launch(Dispatchers.IO) {
                    orderDao.addOrder(Order(items = cartItems))
                }


                // Clear the shopping cart
                _shopCart.value = emptyList()
                _temporaryOrders.value = emptyList()
            }
        }
    }

    fun temporaryOrder() {
        viewModelScope.launch {
            val cartItems = _shopCart.value.toList()
            if (cartItems.isNotEmpty()) {
                val currentTemporaryOrders = _temporaryOrders.value.toMutableList()
                val existingItems = currentTemporaryOrders.flatMap { it.items }

                val newItems = cartItems.filter { it !in existingItems }
                if (newItems.isNotEmpty()) {
                    val newOrder = Order(items = newItems)
                    currentTemporaryOrders.add(newOrder)
                    _temporaryOrders.value = currentTemporaryOrders

                    // Clear the shopping cart
                    //_shopCart.value = emptyList()
                }
            }
        }
    }
}