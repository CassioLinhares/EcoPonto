package br.com.fiap.ecobairro.navigation

sealed class Destination (val route: String){
    object LoginScreen : Destination("Login")
    object SignupScreen : Destination("Signup")
    object NewsScreen : Destination("NewsScreen")
}