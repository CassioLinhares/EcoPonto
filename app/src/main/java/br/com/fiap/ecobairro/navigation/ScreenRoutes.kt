package br.com.fiap.ecobairro.navigation

sealed class Destination (val route: String){
    object LoginScreen : Destination("Login")
    object signupScreen : Destination("Signup")
    object newsScreen : Destination("Signup")
}