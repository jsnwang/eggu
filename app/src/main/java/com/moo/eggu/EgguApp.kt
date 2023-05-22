package com.moo.eggu

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.moo.eggu.data.NoteRepo
import com.moo.eggu.navigation.NavGraph
import com.moo.eggu.ui.components.EgguScaffold

@Composable
fun EgguApp(repo: NoteRepo) {
    val navController = rememberNavController()
    EgguScaffold (navController){
        NavGraph(navController = navController, noteRepo = repo, topPaddingValues = it)
    }
}
