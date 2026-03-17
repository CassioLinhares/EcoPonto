package br.com.fiap.ecobairro.navigation

sealed class Destination (val route: String){
    object InialScreen : Destination("InitialScreen")
    object LoginScreen : Destination("LoginScreen")
    object NewsScreen : Destination("NewsScreen")
    object SignupScreen: Destination("SignupScreen")
    object DonationScreen: Destination("DonationScreen")
    object ProfileScreen: Destination("ProfileScreen")
    object HomeScreen: Destination("HomeScreen")
    object LocationScreen: Destination("LocationScreen")



}