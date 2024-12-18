package com.yt.fooddeliveryappui.commonui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.model.Drawer
import com.yt.fooddeliveryappui.model.Food
import com.yt.fooddeliveryappui.viewmodels.FavoritesViewModel
import com.yt.fooddeliveryappui.ui.theme.*



@Composable
fun Text65_800(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.h1, modifier = modifier)
}

@Composable
fun Text13_400(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.subtitle1, modifier = modifier)
}

@Composable
fun Text22_700(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = detailTypography.h2, modifier = modifier)
}

@Composable
fun Text28_600(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        color = color,
        style = detailTypography.h2,
        modifier = modifier,
        textAlign = textAlign
    )
}

@Composable
fun Text34_700(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.h2, modifier = modifier)
}

@Composable
fun Text17_700(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.h6, modifier = modifier)
}

@Composable
fun Text22_600(
    text: String,
    color: Color = Color.White,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = color,
        style = Typography.h5,
        modifier = modifier,
        textAlign = textAlign
    )
}


@Composable
fun Text17_600(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.body2, modifier = modifier)
}

@Composable
fun Text17_400(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.h4, modifier = modifier)
}


@Composable
fun Text18_600(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.body1, modifier = modifier)
}

@Composable
fun Text15_600(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = Typography.h3, modifier = modifier)
}

@Composable
fun Text15_400(
    text: String,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = text, color = color, style = detailTypography.body1, modifier = modifier)
}

@SuppressLint("UnnecessaryComposedModifier", "ModifierFactoryUnreferencedReceiver")
@Composable
inline fun Modifier.NoRippleEffect(crossinline onClick: () -> Unit) = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}


@Composable
fun CommonButton(
    text: String,
    foregroundColor: Color = Color.White,
    backgroundColor: Color = orange,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(30.dp)
    ) {
        Box(
            modifier = modifier
                .background(backgroundColor)
                .clickable {
                    onClick()
                }
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text17_600(
                text = text,
                color = foregroundColor,
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
    }

}

@Composable
fun CommonLine(
    width: Dp = 0.dp,
    height: Dp = 0.dp,
    modifier: Modifier = Modifier,
    color: Color = orange
) {
    Box(
        modifier = modifier
            .width(width)
            .height(height)
            .background(color)
    )
}

@Composable
fun CommonTextField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    TextField(
        value = text,
        onValueChange = { newText ->
            onTextChange(newText)
        },
        textStyle = TextStyle(color = Color.Black),
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = lightGray,
            textColor = Color.Black,
            unfocusedIndicatorColor = Color.Black,
            focusedIndicatorColor = Color.Black,
        ),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

@Composable
fun CommonIconButton(
    icon: Int,
    tint: Color = Color.Unspecified,
    size: Dp = 36.dp,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = Modifier.size(size),
            tint = tint
        )
    }

}

@Composable
fun CommonSearchBar(
    text: MutableState<String>,
    trailingIcon: Int = R.drawable.search,
    backgroundColor: Color = searchBackground,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {

    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = backgroundColor,
            cursorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledPlaceholderColor = placeholder,
            disabledLabelColor = placeholder,
            disabledLeadingIconColor = gray
        ),
        enabled = isEnabled,
//        placeholder = { Text17_600(text = "Search", color = placeholder) },
        label = { Text17_600(text = if (isEnabled) "" else "Szukaj", color = placeholder) },
        leadingIcon = {
            Icon(
                painterResource(id = trailingIcon),
                contentDescription = "",
                modifier = Modifier.size(18.dp),
                tint = Color.Unspecified
            )
        }

    )

}

@Composable
fun TabBarListRow(
    text: String,
    selected: Boolean,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .width(87.dp)
            .NoRippleEffect {
                onClick()
            }
    ) {
        Text17_400(
            text = text,
            color = if (selected) orange else textColor,
            modifier = Modifier.align(CenterHorizontally)
        )
        if (selected)
            CommonLine(
                height = 3.dp,
                width = 87.dp,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .background(orange)
            )
    }
}

@Composable
fun FoodEachRow(
    food: Food,
    favoritesViewModel: FavoritesViewModel,
    onClick: () -> Unit = {}
) {
    val favorites by favoritesViewModel.favorites.collectAsState()
    val isFavorite = favorites.contains(food)
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier.padding(10.dp)
    ) {
        Box(modifier = Modifier
            .background(Color.White)
            .NoRippleEffect {
                onClick()
            }
        ) {
            Column(
                horizontalAlignment = CenterHorizontally,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
            ) {
                Row( modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFavorite) Color.Red else Color.Gray,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                if (isFavorite) {
                                    favoritesViewModel.removeFavorite(food)
                                } else {
                                    favoritesViewModel.addFavorite(food)
                                }
                            }
                    )
                    Spacer(modifier = Modifier.width(50.dp))
                    CommonIconButton(icon = R.drawable.noun_shopping_cart_37209, onClick = {favoritesViewModel.addToCart(food)})
                }
                Image(
                    painter = painterResource(id = food.image),
                    contentDescription = "",
                    Modifier.size(164.dp)
                )
                Text22_600(
                    text = food.name,
                    color = Color.Black,
                    modifier = Modifier.align(CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text17_700(text = "${food.price} zł", color = orange)
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }

}



@Composable
fun DrawerContent(
    drawer: Drawer,
    navController: NavController,
    scaffoldState: ScaffoldState,// Dodaj NavController jako argument
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 20.dp)
            .clickable {
                navController.navigate(drawer.route)

            }
    ) {
        Icon(
            painter = painterResource(id = drawer.icon),
            contentDescription = drawer.name,
            modifier = Modifier.size(24.dp),
            tint = Color.Unspecified
        )
        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text17_600(text = drawer.name, color = Color.White)

        }
    }
}


@Composable
fun CommonHeader(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        IconButton(onClick = {
            onClick()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.back), contentDescription = "",
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
        }

        Text18_600(
            text = text,
            color = Color.Black,
            modifier = Modifier
                .align(CenterVertically)
                .padding(start = 20.dp)
        )

    }
}