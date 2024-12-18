package com.yt.fooddeliveryappui.screens.uiscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yt.fooddeliveryappui.commonui.CommonHeader
import com.yt.fooddeliveryappui.ui.theme.Typography
import com.yt.fooddeliveryappui.ui.theme.lightGray

@Composable
fun PrivatePolicyTab(navHostController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(lightGray)
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                CommonHeader(
                    text = "Polityka Prywatności",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    navHostController.navigateUp()
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {

                    Text(text = "\"W Polityce Prywatności zebraliśmy najważniejsze informacje dotyczące Twoich danych osobowych oraz tego, w jaki sposób są one przez nas chronione.",
                        modifier = Modifier,
                        style = Typography.h3,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                        )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Polityka Prywatności stanowi załącznik do Regulaminu Ankavir-Med, którego aktualna wersja jest dostępna na stronie: www.ankavirmed.pl/regulamin",
                        modifier = Modifier,
                        style = Typography.h3,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )

                }

            }
        }
    }
}

