package com.moo.eggu.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moo.eggu.ui.components.NoteItem
import com.moo.eggu.viewmodel.EgguViewModel

@Composable
fun TaskList(viewModel: EgguViewModel, topPaddingValues: PaddingValues) {
    val tasks = viewModel.noteList.collectAsState(initial = emptyList())
    Surface (modifier = Modifier.padding(topPaddingValues)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 0.dp, 10.dp, 0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            if (tasks.value.isEmpty()) {
                Text(text = "No notes")
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(tasks.value) {
                        NoteItem(it, viewModel)
                    }
                }
            }
        }
    }
}