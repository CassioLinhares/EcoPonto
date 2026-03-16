package br.com.fiap.ecobairro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.screens.LoginScreen


@Composable
fun NavigationRoute() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.LoginScreen.route
    ){
        composable(Destination.LoginScreen.route){
            LoginScreen()
        }
    }
    
}