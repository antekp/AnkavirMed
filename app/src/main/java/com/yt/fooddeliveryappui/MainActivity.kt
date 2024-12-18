package com.yt.fooddeliveryappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface

import androidx.compose.ui.Modifier

import cafe.adriel.voyager.navigator.Navigator
import com.yt.fooddeliveryappui.screens.loginscreens.StartScreen

import com.yt.fooddeliveryappui.ui.theme.AnkavirAppUiTheme



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            AnkavirAppUiTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    Navigator(screen = StartScreen)
                }
            }
        }
    }
}
