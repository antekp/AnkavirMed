package com.yt.fooddeliveryappui.screens.uiscreens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.*
import com.yt.fooddeliveryappui.model.listOfFood
import com.yt.fooddeliveryappui.model.listOfAlergia
import com.yt.fooddeliveryappui.model.listOfSuplementy
import com.yt.fooddeliveryappui.model.listOfWitaminy
import com.yt.fooddeliveryappui.screens.activities.DetailActivity
import com.yt.fooddeliveryappui.viewmodels.FavoritesViewModel
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.utils.launchActivity
import kotlinx.coroutines.launch


@Composable
fun HomeTab(
    scaffoldState: ScaffoldState,
    favoritesViewModel: FavoritesViewModel
)  {

        val context = LocalContext.current
        val scope = rememberCoroutineScope()

        val horizontalScrollState = rememberScrollState()
        val verticalScrollState = rememberScrollState()
        val search = remember { mutableStateOf("") }
        val lists by remember { mutableStateOf(listOf("Popularne", "Alergia", "Witaminy", "Suplementy")) }
        var currentListValue by remember { mutableStateOf("Popularne") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(verticalScrollState)
                .background(lightGray)
                .padding(bottom = 50.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CommonIconButton(icon = R.drawable.nav_bar){
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, start = 30.dp)
            ) {
                Text34_700(text = "Polecane dla Ciebie", color = Color.Black)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 40.dp)
            ) {
                CommonSearchBar(
                    text = search,
                    isEnabled = false,
                    modifier = Modifier.NoRippleEffect {
                    })

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(horizontalScrollState)
                    .padding(top = 30.dp, bottom = 20.dp, start = 50.dp)
            ) {
                lists.forEach {
                    TabBarListRow(
                        text = it,
                        selected = it == currentListValue,
                    ) {
                        currentListValue = it
                    }
                }
            }

            if (currentListValue == "Popularne")
                PopularTabUi(context, favoritesViewModel)
            else if (currentListValue == "Alergia")
                AlergiaTabUi(context, favoritesViewModel)
            else if (currentListValue == "Witaminy")
                WitaminyTabUi(context, favoritesViewModel)
            else if (currentListValue == "Suplementy")
                SuplementTabUi(context, favoritesViewModel)
        }

}

@Composable
fun PopularTabUi(context:Context, favoritesViewModel: FavoritesViewModel) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 20.dp)
    ) {
        items(listOfFood) { food ->
            FoodEachRow(food,favoritesViewModel){
                context.launchActivity<DetailActivity> {
                    putExtra("data",food)
                }
            }
        }
    }
}

@Composable
fun AlergiaTabUi(context:Context,favoritesViewModel: FavoritesViewModel) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 20.dp)
    ) {
        items(listOfAlergia) { food ->
            FoodEachRow(food,favoritesViewModel){
                context.launchActivity<DetailActivity> {
                    putExtra("data",food)
                }
            }
        }
    }
}

@Composable
fun WitaminyTabUi(context:Context,favoritesViewModel: FavoritesViewModel) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 20.dp)
    ) {
        items(listOfWitaminy) { food ->
            FoodEachRow(food,favoritesViewModel){
                context.launchActivity<DetailActivity> {
                    putExtra("data",food)
                }
            }
        }
    }
}
@Composable
fun SuplementTabUi(context:Context,favoritesViewModel: FavoritesViewModel) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 20.dp)
    ) {
        items(listOfSuplementy) { food ->
            FoodEachRow(food, favoritesViewModel){
                context.launchActivity<DetailActivity> {
                    putExtra("data",food)
                }
            }
        }
    }
}

