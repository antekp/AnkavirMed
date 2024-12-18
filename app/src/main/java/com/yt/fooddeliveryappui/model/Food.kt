package com.yt.fooddeliveryappui.model

import android.os.Parcelable
import com.yt.fooddeliveryappui.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val name:String,
    val price:Double,
    val info:String,
    val returnPolicy:String,
    val image:Int,
    val listOFImages:List<Int>
):Parcelable

val listOfFood = listOf(
    Food(
        "Aspirin C",
        9.99,
        "Odbiór w ciągu 1h",
        "Tabletki musujące Aspirin C to lek zawierający składnik przeciwbólowy, przeciwzapalny i przeciwgorączkowy. Ponadto dzięki witaminie C produkt leczniczy wzmacnia system odpornościowy organizmu. Musująca postać tego leku na przeziębienie i grypę przyspiesza jego wchłanianie.",
        R.drawable.aspirinc,
        listOf(
            R.drawable.aspirinc,
            R.drawable.aspirinc2
        )
    ),
    Food(
        "Cholinex",
        8.99,
        "Odbiór w ciągu 1h",
        "Produkt leczniczy do stosowania m.in. w stanach zapalnych błony śluzowej gardła, bólu i obrzęku gardła.",
        R.drawable.cholinex,
        listOf(
            R.drawable.cholinex,
            R.drawable.cholinexdzialanie
        )
    ),
    Food(
        "APAP",
        5.99,
        "Odbiór w ciągu 1h",
        "APAP jako substancję czynną zawiera paracetamol i jest lekiem przeciwbólowym i przeciwgorączkowym. Wskazaniem do stosowania leku są bóle różnego pochodzenia: głowy (w tym napięciowe bóle głowy), menstruacyjne, zębów, mięśni, kostno-stawowe, gardła, nerwobóle oraz gorączka, np. w przeziębieniu i grypie.",
        R.drawable.apap,
        listOf(
            R.drawable.apap,
            R.drawable.apapdzialanie
        )
    ),
    Food(
        "Prezerwatywy Durex",
        9.99,
        "Odbiór w ciągu 1h",
        "DLA BEZPIECZEŃSTWA I KOMFORTU\n" +
                "\n" + " Klasyka - zawsze, gdy ich potrzebujesz." + "\n" +
                "W standardowej rozmiarze i grubości, pokryte silikonowym lubrykantem - więc możesz się zrelaksować i poczuć swój rytm.",
        R.drawable.durex,
        listOf(
            R.drawable.durex,
            R.drawable.durex2
        )
    )
)

