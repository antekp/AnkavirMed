package com.yt.fooddeliveryappui.screens.bottomNavigation

import com.yt.fooddeliveryappui.R


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {


    object Home: BottomBarScreen(
        route = "home",
        title = "Start",
        icon = R.drawable.home_tab,
        icon_focused = R.drawable.home_tab
    )

    object Fav: BottomBarScreen(
        route = "Fav",
        title = "Ulubione",
        icon = R.drawable.fav_tab,
        icon_focused = R.drawable.fav_tab
    )

    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profil",
        icon = R.drawable.profile_tab,
        icon_focused = R.drawable.profile_tab
    )

    object History: BottomBarScreen(
        route = "history",
        title = "Historia",
        icon = R.drawable.history_tab,
        icon_focused = R.drawable.history_tab
    )
    object Cart: BottomBarScreen(
        route = "Koszyk",
        title = "Koszyk",
        icon = R.drawable.shopping_cart_outline,
        icon_focused = R.drawable.shopping_cart_outline
    )

}