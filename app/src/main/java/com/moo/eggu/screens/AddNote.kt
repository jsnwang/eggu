package com.moo.eggu.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.moo.eggu.navigation.Destinations
import com.moo.eggu.viewmodel.EgguViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNote(navController: NavController, viewModel: EgguViewModel, topPaddingValues: PaddingValues) {
    val focusManager = LocalFocusManager.current
    Surface (modifier = Modifier.padding(topPaddingValues)){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextField(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                value = viewModel.subjectText,
                onValueChange = { viewModel.subjectText = it },
                label = { Text(text = "Subject") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                maxLines = 3,
            )
            TextField(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                value = viewModel.contentText,
                onValueChange = { viewModel.contentText = it },
                label = { Text(text = "Note") },
                maxLines = 2,
            )
            Button(
                onClick = {
                    navController.navigate(Destinations.NOTES)
                    viewModel.addNote()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Text("Add")
            }
        }
    }
}