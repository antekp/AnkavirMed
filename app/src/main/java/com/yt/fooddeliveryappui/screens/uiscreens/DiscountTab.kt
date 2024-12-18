package com.yt.fooddeliveryappui.screens.uiscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.CommonHeader
import com.yt.fooddeliveryappui.commonui.Text15_600
import com.yt.fooddeliveryappui.commonui.Text17_600
import com.yt.fooddeliveryappui.ui.theme.lightGray

@Composable
fun DiscountTab(navHostController: NavHostController) {

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
                    text = "Oferty i Promocje",
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
                ) {
                    navHostController.navigateUp()
                }
                EachRowForTextOnly()
            }
        }
    }
}
@Composable
fun EachRowForTextOnly() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Box(modifier = Modifier.background(Color.White)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.undraw_discount_d_4_bd), contentDescription = "",
                    modifier = Modifier.size(70.dp)
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)
                ) {
                    Text17_600(text = "Zapisz się do naszego newslettera!", color = Color.Black)
                    Text15_600(
                        text = "Zapisz się już teraz a otrzymasz 20% zniżki na pierwsze zakupy!",
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        }
    }
}