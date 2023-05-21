package com.moo.eggu.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.moo.eggu.navigation.Destinations
import com.moo.eggu.ui.components.NoteItem
import com.moo.eggu.viewmodel.EgguViewModel

@Composable
fun TaskList(navController: NavController, viewModel: EgguViewModel) {
    val tasks = viewModel.noteList.collectAsState(initial = emptyList())
    Surface {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(tasks.value) {
                    NoteItem(it)
                }
            }

            Button(onClick = {
                navController.navigate(Destinations.HOME) {
                    popUpTo(Destinations.HOME) {
                        inclusive = true
                    }
                }
            },
            ) {
                Text(text = "Back to start")
            }

            Button(onClick = {
                viewModel.deleteNotes()
            },
            ) {
                Text(text = "Delete Table")
            }
        }



    }
}