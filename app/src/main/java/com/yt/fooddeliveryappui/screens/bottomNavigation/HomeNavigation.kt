package com.yt.fooddeliveryappui.screens.bottomNavigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yt.fooddeliveryappui.viewmodels.FavoritesViewModel
import com.yt.fooddeliveryappui.screens.uiscreens.CartTab
import com.yt.fooddeliveryappui.screens.uiscreens.CompleteTheOrderTab
import com.yt.fooddeliveryappui.screens.uiscreens.DiscountTab
import com.yt.fooddeliveryappui.screens.uiscreens.HistoryTab
import com.yt.fooddeliveryappui.screens.uiscreens.HomeTab
import com.yt.fooddeliveryappui.screens.uiscreens.PrivatePolicyTab
import com.yt.fooddeliveryappui.screens.uiscreens.ProfileTab
import com.yt.fooddeliveryappui.screens.uiscreens.SecurityTab
import com.yt.fooddeliveryappui.screens.uiscreens.WishListTab
import com.yt.fooddeliveryappui.viewmodels.AuthViewModel


@Composable
fun HomeNavigation(
    navHostController: NavHostController,
    scaffoldState: ScaffoldState,
    favoritesViewModel: FavoritesViewModel,
) {

    NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route ){
        composable(BottomBarScreen.Home.route){
            HomeTab(scaffoldState, favoritesViewModel = favoritesViewModel)
        }

        composable(BottomBarScreen.Fav.route){
            WishListTab(navHostController, favoritesViewModel)
        }

        composable(BottomBarScreen.Profile.route){
            ProfileTab(navHostController)
        }

        composable(BottomBarScreen.History.route){
            HistoryTab(navHostController, favoritesViewModel)
        }
        composable(BottomBarScreen.Cart.route)
        {
            CartTab(navHostController, favoritesViewModel)
        }
        composable("Profil")
        {
            ProfileTab(navHostController = navHostController)
        }
        composable("Zamówienia")
        {
            HistoryTab(navHostController,favoritesViewModel)
        }
        composable("Oferty i Promocje")
        {
            DiscountTab(navHostController)
        }
        composable("Polityka prywatności")
        {
            PrivatePolicyTab(navHostController)
        }
        composable("Bezpiecześtwo")
        {
            SecurityTab(navHostController)
        }
        composable("Finalizacja Zamówienia")
        {
            CompleteTheOrderTab(navHostController, favoritesViewModel)
        }

    }

}