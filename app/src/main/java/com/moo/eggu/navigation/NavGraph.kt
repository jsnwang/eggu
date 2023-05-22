package com.moo.eggu.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moo.eggu.data.NoteRepo
import com.moo.eggu.screens.AddNote
import com.moo.eggu.screens.TaskList
import com.moo.eggu.viewmodel.EgguViewModel
import com.moo.eggu.viewmodel.EgguViewModelFactory

@Composable
fun NavGraph(navController: NavHostController, noteRepo: NoteRepo) {
    val viewModel: EgguViewModel = viewModel(factory = EgguViewModelFactory(noteRepo))

    NavHost(navController = navController, startDestination = Destinations.NOTES) {
        composable(Destinations.ADD) { AddNote(navController, viewModel) }
        composable(Destinations.NOTES) { TaskList(navController, viewModel) }
    }
}