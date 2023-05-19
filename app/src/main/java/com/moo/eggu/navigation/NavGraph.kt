package com.moo.eggu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moo.eggu.screens.Home
import com.moo.eggu.screens.TaskList
import com.moo.eggu.screens.Time
import com.moo.eggu.viewmodel.EgguViewModel

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    val viewModel = EgguViewModel()
    NavHost(navController = navController, startDestination = Destinations.HOME) {
        composable(Destinations.HOME) { Home(navController, viewModel) }
        composable(Destinations.TIME) { Time(navController, viewModel) }
        composable(Destinations.TASKS) { TaskList(navController, viewModel) }
    }
}