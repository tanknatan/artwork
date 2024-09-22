package com.rabota.artwork.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rabota.artwork.data.Prefs
import com.rabota.artwork.presentation.view.AgeConfirmationScreen
import com.rabota.artwork.presentation.view.SplashScreen
import com.rabota.artwork.presentation.view.UnderageScreen

@Composable
fun NavigationScreen(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Destinations.SplashScreen.route,
        modifier = Modifier,

        ) {


        composable(route = Destinations.SplashScreen.route) {
            SplashScreen {
                if (!Prefs.startStepCompleted) {
                    navHostController.navigate(Destinations.AgeConfirmationScreen.route) {
                        popUpTo(Destinations.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                } else if (Prefs.startStepCompleted && !Prefs.eighteenOver) {
                    navHostController.navigate(Destinations.UnderageScreen.route) {
                        popUpTo(Destinations.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                } else if (Prefs.startStepCompleted && Prefs.eighteenOver) {
                    navHostController.navigate(Destinations.MainScreen.route) {
                        popUpTo(Destinations.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            }
        }
        composable(route = Destinations.AgeConfirmationScreen.route) {
            AgeConfirmationScreen(
                onYesClick = {
                    Prefs.startStepCompleted = true
                    Prefs.eighteenOver = true
                    navHostController.navigate(Destinations.MainScreen.route) {
                        popUpTo(Destinations.AgeConfirmationScreen.route) {
                            inclusive = true
                        }
                    }
                },
                onNoClick = {
                    Prefs.startStepCompleted = true
                    Prefs.eighteenOver = false
                    navHostController.navigate(Destinations.UnderageScreen.route) {
                        popUpTo(Destinations.AgeConfirmationScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(route = Destinations.UnderageScreen.route) {
            UnderageScreen()
        }
    }
}
