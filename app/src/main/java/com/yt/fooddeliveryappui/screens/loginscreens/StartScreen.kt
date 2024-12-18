package com.yt.fooddeliveryappui.screens.loginscreens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.CommonButton
import com.yt.fooddeliveryappui.commonui.Text65_800
import com.yt.fooddeliveryappui.ui.theme.orange

object StartScreen: Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize(),
//
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.app_icon2), contentDescription = "",
                    modifier = Modifier.size(73.dp),
                    tint = Color.Unspecified
                )

                Text65_800(
                    text = "ANKAVIR-MED",
                    color = orange,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Spacer(modifier = Modifier.height(55.dp))
                Icon(painter = painterResource(id = R.drawable.undraw_medicine_b_1_ol_3), contentDescription = "",tint = Color.Unspecified)
            }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            CommonButton(text = "Zaczynamy"){
                navigator += RegisterScreen
            }

        }
    }
}
}