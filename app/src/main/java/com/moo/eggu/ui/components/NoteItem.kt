package com.moo.eggu.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moo.eggu.data.Note
import com.moo.eggu.viewmodel.EgguViewModel

@Composable
fun NoteItem(note: Note, viewModel: EgguViewModel) {
    Card(
        shape = RoundedCornerShape(4.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = note.name,
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    fontSize = 18.sp, color = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                textAlign = TextAlign.Center
            )
            IconButton(onClick = {  viewModel.showDeleteDialog() }) {
                Icon(Icons.Rounded.Delete, "Delete")
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = note.time,
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    fontSize = 16.sp, color = MaterialTheme.colorScheme.onTertiaryContainer
                ),
                textAlign = TextAlign.Center
            )
        }
    }
     if (viewModel.showDeleteDialog.value) {
         AlertDialog(onDismissRequest = { viewModel.dismissDeleteDialog() },
             title = { Text(text = "Delete") },
             text = { Text(text = "Are you sure you want to delete this note?") },
             confirmButton = {
                 Button(onClick = { viewModel.deleteNote(note) }) {
                     Text(text = "Yes")
                 }
             },
             dismissButton = {
                 Button(onClick = { viewModel.dismissDeleteDialog()}) {
                     Text(text = "Cancel")
                 }
             }
         )
     }
}
