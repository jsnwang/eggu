package com.moo.eggu.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moo.eggu.data.Note

@Composable
fun NoteItem(note: Note) {
    Card(
        shape = RoundedCornerShape(4.dp),
    ) {
        Row {
            Text(
                text = note.name,
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    fontSize = 24.sp, color = Color.Red),
                textAlign = TextAlign.Center
            )
            Text(
                text = note.time,
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    fontSize = 24.sp, color = Color.Black),
                textAlign = TextAlign.Center
            )
        }
    }
}