package com.yt.fooddeliveryappui.model

import com.yt.fooddeliveryappui.R

data class Payment(
    val name: String,
    val image: Int
)

val paymentDetails = arrayOf(
    Payment(
        "Karta płatnicza",
        R.drawable.card
    ),
    Payment(
        "Konto bankowe",
        R.drawable.bank,
    ),
    Payment(
        "Paypal",
        R.drawable.paypal
    )
)
