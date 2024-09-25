package com.seveng.oneapps.presentation.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.seveng.oneapps.presentation.view.AgeConfirmationScreen
import com.seveng.oneapps.presentation.view.MainScreen
import com.seveng.oneapps.presentation.view.SplashScreen
import com.seveng.oneapps.presentation.view.UnderageScreen
import com.seveng.oneapps.presentation.view.WebViewScreen
import com.seveng.oneapps.presentation.viewmodel.MainViewModel

@Composable
fun NavigationScreen(
    navHostController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val products by viewModel.products.collectAsState()
    NavHost(
        navController = navHostController,
        startDestination = Destinations.SplashScreen.route,
        modifier = Modifier,
    ) {

        composable(route = Destinations.SplashScreen.route) {
            SplashScreen {
                navHostController.navigate(Destinations.MainScreen.route) {
                    popUpTo(Destinations.SplashScreen.route) {
                        inclusive = true
                    }
                }
//                when {
//                    !viewModel.startStepCompleted -> {
//                        navHostController.navigate(Destinations.AgeConfirmationScreen.route) {
//                            popUpTo(Destinations.SplashScreen.route) {
//                                inclusive = true
//                            }
//                        }
//                    }
//                    viewModel.startStepCompleted && !viewModel.eighteenOver -> {
//                        navHostController.navigate(Destinations.UnderageScreen.route) {
//                            popUpTo(Destinations.SplashScreen.route) {
//                                inclusive = true
//                            }
//                        }
//                    }
//                    viewModel.startStepCompleted && viewModel.eighteenOver -> {
//                        navHostController.navigate(Destinations.MainScreen.route) {
//                            popUpTo(Destinations.SplashScreen.route) {
//                                inclusive = true
//                            }
//                        }
//                    }
//                }
            }
        }
//        composable(route = Destinations.AgeConfirmationScreen.route) {
//            AgeConfirmationScreen(
//                onYesClick = {
//                    viewModel.startStepCompleted = true
//                    viewModel.eighteenOver = true
//                    navHostController.navigate(Destinations.MainScreen.route) {
//                        popUpTo(Destinations.AgeConfirmationScreen.route) {
//                            inclusive = true
//                        }
//                    }
//                },
//                onNoClick = {
//                    viewModel.startStepCompleted = true
//                    viewModel.eighteenOver = false
//                    navHostController.navigate(Destinations.UnderageScreen.route) {
//                        popUpTo(Destinations.AgeConfirmationScreen.route) {
//                            inclusive = true
//                        }
//                    }
//                }
//            )
//        }
//        composable(route = Destinations.UnderageScreen.route) {
//            UnderageScreen()
//        }

        composable(route = Destinations.MainScreen.route) {
            MainScreen(products, navHostController)
        }
        composable(
            route = "${Destinations.WebViewScreen.route}/{url}",
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { backStackEntry ->
            val encodedUrl = backStackEntry.arguments?.getString("url")
            val url = encodedUrl?.let { Uri.decode(it) }  // Декодируем URL перед передачей
            if (url != null) {
                WebViewScreen("https://www.google.com")  // Передаем URL в функцию экрана
            }
        }

    }
}
