package br.com.fiap.ecobairro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.screens.InitialScreen
import br.com.fiap.ecobairro.screens.NewsScreen
import br.com.fiap.ecobairro.screens.SignupScreen

import br.com.fiap.ecobairro.screens.DonationScreen
import br.com.fiap.ecobairro.screens.HomeScreen
import br.com.fiap.ecobairro.screens.LocationScreen
import br.com.fiap.ecobairro.screens.LoginScreen
import br.com.fiap.ecobairro.screens.ProfileScreen


@Composable
fun NavigationRoute() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.InialScreen.route
    ){
        composable(Destination.InialScreen.route){
            InitialScreen(navController)
        }
        composable(Destination.NewsScreen.route){
            NewsScreen(navController)
        }
        composable(Destination.SignupScreen.route){
            SignupScreen(navController)
        }
        composable(Destination.DonationScreen.route)
        {
            DonationScreen(navController)
        }
        composable(Destination.LoginScreen.route)
        {
            LoginScreen(navController)
        }
        composable(Destination.ProfileScreen.route)
        {
            ProfileScreen(navController)
        }
        composable(Destination.HomeScreen.route)
        {
            HomeScreen(navController)
        }
        composable(Destination.LocationScreen.route)
        {
            LocationScreen(navController)
        }

    }
}