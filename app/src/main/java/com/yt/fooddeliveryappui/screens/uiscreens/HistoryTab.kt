package com.yt.fooddeliveryappui.screens.uiscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.CommonHeader
import com.yt.fooddeliveryappui.commonui.Text17_600
import com.yt.fooddeliveryappui.commonui.Text22_600
import com.yt.fooddeliveryappui.model.Order
import com.yt.fooddeliveryappui.viewmodels.FavoritesViewModel
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.ui.theme.orange

@Composable
fun HistoryTab(navHostController: NavHostController, favoritesViewModel: FavoritesViewModel) {

    val orderedItems by favoritesViewModel.finishedOrders.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(lightGray)
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                CommonHeader(
                    text = "Historia zamówień",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    navHostController.navigateUp()
                }
                orderedItems?.let { items ->
                    LazyColumn {
                        items(items) { order ->
                            EachOrderedRow(order = order, favoritesViewModel = favoritesViewModel)
                        }
                    }
                } ?: run {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text22_600(
                            text = "Brak historii zamówień",
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EachOrderedRow(
    order: Order,
    favoritesViewModel: FavoritesViewModel
) {
    val totalPrice = order.items.sumOf { it.price }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(modifier = Modifier.background(Color.White)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.complete_order),
                    contentDescription = "",
                    modifier = Modifier.size(70.dp)
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    // Wyświetlenie każdej pozycji zamówienia
                    order.items.forEach { food ->
                        Text17_600(text = food.name, color = Color.Black)
                    }
                }
                Text22_600(
                    text = "${totalPrice} zł",
                    color = orange,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}



