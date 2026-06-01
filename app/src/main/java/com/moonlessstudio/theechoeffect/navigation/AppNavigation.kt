package com.moonlessstudio.theechoeffect.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moonlessstudio.theechoeffect.data.GamePreferences
import com.moonlessstudio.theechoeffect.ui.screens.CharacterSelectionScreen
import com.moonlessstudio.theechoeffect.ui.screens.CreditsScreen
import com.moonlessstudio.theechoeffect.ui.screens.EchoStatusScreen
import com.moonlessstudio.theechoeffect.ui.screens.GameScreen
import com.moonlessstudio.theechoeffect.ui.screens.SplashScreen
import com.moonlessstudio.theechoeffect.ui.screens.StartMenuScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val preferences = remember { GamePreferences(LocalContext.current) }

    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen(onStart = {
                navController.navigate(Routes.START_MENU) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                }
            })
        }
        composable(Routes.START_MENU) {
            StartMenuScreen(
                onNewGame = {
                    preferences.saveLastScreen(Routes.CHARACTER_SELECTION)
                    navController.navigate(Routes.CHARACTER_SELECTION)
                },
                onContinue = {
                    val targetRoute = preferences.getLastScreen().ifBlank { Routes.GAME }
                    navController.navigate(targetRoute)
                },
                onStatus = {
                    preferences.saveLastScreen(Routes.ECHO_STATUS)
                    navController.navigate(Routes.ECHO_STATUS)
                },
                onCredits = {
                    preferences.saveLastScreen(Routes.CREDITS)
                    navController.navigate(Routes.CREDITS)
                }
            )
        }
        composable(Routes.CHARACTER_SELECTION) {
            CharacterSelectionScreen(
                onConfirm = {
                    navController.navigate(Routes.GAME) {
                        popUpTo(Routes.CHARACTER_SELECTION) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Routes.GAME) {
            GameScreen(
                onStatus = { navController.navigate(Routes.ECHO_STATUS) },
                onBackToMenu = {
                    navController.navigate(Routes.START_MENU) {
                        popUpTo(Routes.START_MENU) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.ECHO_STATUS) {
            EchoStatusScreen(onBackToMenu = {
                navController.navigate(Routes.START_MENU) {
                    popUpTo(Routes.START_MENU) { inclusive = true }
                }
            })
        }
        composable(Routes.CREDITS) {
            CreditsScreen(onBack = { navController.popBackStack() })
        }
    }
}
