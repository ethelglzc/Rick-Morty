package edu.ulsa.disney.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.ulsa.disney.ui.detail.DetailScreen
import edu.ulsa.disney.ui.home.HomeScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(onItemClick = { id ->
                navController.navigate("detail/$id")
            })
        }

        composable(
            route = "detail/{characterId}",
            arguments = listOf(
                navArgument("characterId") { type = NavType.IntType }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("characterId") ?: 1
            DetailScreen(id = id, onBack = { navController.popBackStack() })
        }
    }
}
