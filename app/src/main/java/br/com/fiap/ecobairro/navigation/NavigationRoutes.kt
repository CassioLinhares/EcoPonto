package br.com.fiap.ecobairro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.screens.LoginScreen
import br.com.fiap.ecobairro.screens.NewsScreen
import br.com.fiap.ecobairro.screens.SignupScreen


@Composable
fun NavigationRoute() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.LoginScreen.route
    ){
        composable(Destination.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(Destination.NewsScreen.route){
            NewsScreen(navController)
        }
        composable(Destination.SignupScreen.route){
            SignupScreen(navController)
        }
    }
}