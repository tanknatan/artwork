package com.seveng.oneapps.presentation.navigation

sealed class Destinations(val route: String) {

    data object SplashScreen : Destinations("splash_screen")
    data object AgeConfirmationScreen : Destinations("age_confirmation_screen")
    data object UnderageScreen : Destinations("delete_this_app_screen")
    data object MainScreen : Destinations("main_screen")
    data object WebViewScreen : Destinations("web_view_screen")

}