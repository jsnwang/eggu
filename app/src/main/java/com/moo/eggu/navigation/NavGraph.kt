package com.moo.eggu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moo.eggu.ui.Home
import com.moo.eggu.ui.Time
import com.moo.eggu.viewmodel.EgguViewModel

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    val viewModel = EgguViewModel()
    NavHost(navController = navController, startDestination = Destinations.HOME) {
        composable(Destinations.HOME) { Home(navController, EgguViewModel()) }
        composable(Destinations.TIME) { Time(navController, EgguViewModel()) }
    }

}