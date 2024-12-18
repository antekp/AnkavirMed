package com.yt.fooddeliveryappui.screens.uiscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.CommonButton
import com.yt.fooddeliveryappui.commonui.CommonHeader
import com.yt.fooddeliveryappui.commonui.Text15_600
import com.yt.fooddeliveryappui.commonui.Text17_600
import com.yt.fooddeliveryappui.commonui.Text18_600
import com.yt.fooddeliveryappui.model.Pharmacy
import com.yt.fooddeliveryappui.model.pharmacies
import com.yt.fooddeliveryappui.viewmodels.FavoritesViewModel
import com.yt.fooddeliveryappui.screens.bottomNavigation.BottomBarScreen
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.ui.theme.orange

@Composable
fun CompleteTheOrderTab(navHostController: NavHostController, favoritesViewModel: FavoritesViewModel) {
    val temporaryOrder by favoritesViewModel.temporaryOrders.collectAsState()
    val selectedPharmacy = remember { mutableStateOf<Pharmacy?>(null) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGray)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(lightGray)
                    .padding(bottom = 50.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    CommonHeader(
                        text = "Finalizacja zamówienia",
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                    ) {
                        navHostController.navigateUp()
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.complete_the_order_cart_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .size(150.dp), // Adjust the size as needed
                        tint = Color.Unspecified
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

            }
            Text18_600(
                text = "Twoje produkty",
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 2.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        items(temporaryOrder) { order ->
            EachOrderedRow(order = order, favoritesViewModel = favoritesViewModel)
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Text18_600(
                text = "Apteki w pobliżu",
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 2.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        items(pharmacies) { pharm ->
            EachRowForDeliveryCompleteOrder(
                pharmacy = pharm,
                isSelected = pharm == selectedPharmacy.value,
                onSelect = { selectedPharmacy.value = it }
            )
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
            CommonButton(
                text = "Złóż zamówienie",
                foregroundColor = Color.White,
                backgroundColor = orange,
                onClick = {

                    favoritesViewModel.completeOrder()
                    navHostController.navigate(BottomBarScreen.Home.route)
                }
            )
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Composable
fun EachRowForDeliveryCompleteOrder(
    pharmacy: Pharmacy,
    isSelected: Boolean,
    onSelect: (Pharmacy) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .clickable { onSelect(pharmacy) },
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
                    painter = painterResource(id = R.drawable.undraw_delivery_address_re_cjca),
                    contentDescription = "",
                    modifier = Modifier.size(70.dp)
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    Text17_600(text = pharmacy.name, color = Color.Black)
                    Text15_600(
                        text = pharmacy.address,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
                RadioButton(
                    selected = isSelected,
                    onClick = { onSelect(pharmacy) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = orange
                    ),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}