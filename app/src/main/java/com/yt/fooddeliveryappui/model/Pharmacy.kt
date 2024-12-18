package com.yt.fooddeliveryappui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pharmacy(
    val name: String,
    val address: String,
    val phoneNumber: String,
) : Parcelable

val pharmacies = listOf(
    Pharmacy("Apteka Oliwna 0.4 km", "aleja Kijowska 64", "12 444 11 60"),
    Pharmacy("Apteka HYGIEIA 1.2 km", "Wrocławska 48", "12 633 44 32"),
    Pharmacy("Apteka Słoneczna 1.6 km", "Racławicka 10", "2 265 67 37"),
    Pharmacy("Apteka Natura 2.2 km", "Kazimierza Wielkiego 7", "12 651 49 19")
)
