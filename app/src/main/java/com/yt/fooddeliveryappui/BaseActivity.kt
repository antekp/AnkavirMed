package com.yt.fooddeliveryappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.yt.fooddeliveryappui.ui.theme.AnkavirAppUiTheme

abstract class BaseActivity : ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnkavirAppUiTheme() {
                    Content()
            }
        }
    }

    @Composable
    abstract fun Content()
}