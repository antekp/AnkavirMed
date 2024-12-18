package com.yt.fooddeliveryappui.model

import com.yt.fooddeliveryappui.R

data class Drawer(
    val icon:Int,
    val name:String,
    val route: String
)

val drawerContent = listOf(
    Drawer(
        R.drawable.profile_icon,
        "Profil",
        "Profil"

    ),
    Drawer(
        R.drawable.cart_icon,
        "Zamówienia",
        "Zamówienia"
    ),
    Drawer(
        R.drawable.offer_icon,
        "Oferty i promocje",
        "Oferty i promocje"
    ),
    Drawer(
        R.drawable.privacy_icon,
        "Polityka prywatności",
        "Polityka prywatności"
    ),
    Drawer(
        R.drawable.security_icon,
        "Bezpieczeństwo",
        "Bezpieczeństwo"
    ),
)
