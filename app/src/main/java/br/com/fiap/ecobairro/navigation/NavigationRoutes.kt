package br.com.fiap.ecobairro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.ecobairro.screens.LoginScreen
import br.com.fiap.ecobairro.screens.NewsScreen
import br.com.fiap.ecobairro.screens.SignupScreen
import br.com.fiap.ecobairro.screens.CadastroScreen
import br.com.fiap.ecobairro.screens.DonationScreen


@Composable
fun NavigationRoute() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.DonationScreen.route
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
        composable(Destination.Cadastro.route)
        {
            CadastroScreen(navController)
        }
        composable(Destination.DonationScreen.route)
        {
           DonationScreen(navController)
        }

    }
}