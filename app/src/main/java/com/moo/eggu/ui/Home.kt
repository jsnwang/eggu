package com.moo.eggu.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.moo.eggu.navigation.Destinations
import com.moo.eggu.viewmodel.EgguViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController, viewModel: EgguViewModel) {
    Surface {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            var text by remember { mutableStateOf("") }
            TextField(value = text, onValueChange = {text = it}, label = { Text(text = "Name")})
            Button(
                onClick = { navController.navigate(Destinations.TIME)
                          viewModel.name = text},
                modifier = Modifier
                    .fillMaxWidth(.75f)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Text("SUBMIT")
            }
        }
    }
}