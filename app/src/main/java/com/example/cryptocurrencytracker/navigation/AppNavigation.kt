package com.example.cryptocurrencytracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrencytracker.ui.screen.CryptoListScreen
import com.example.cryptocurrencytracker.ui.screen.InfoScreen

@Composable
fun AppNavigation() {
    // Create a NavController
    val navController = rememberNavController()

    // Define the navigation graph
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        // Main Screen
        composable("main") {
            CryptoListScreen()
        }
        // Info Screen
        composable("info") {
            InfoScreen()
        }
    }
}