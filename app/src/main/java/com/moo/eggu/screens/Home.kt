package com.moo.eggu.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

            val time = viewModel.countdownFlow.collectAsState(initial = 10)
            Box (modifier = Modifier.fillMaxWidth()) {
                Text(text = time.value.toString(), modifier = Modifier.align(Alignment.Center).size(30.dp))
            }
            var text by remember { mutableStateOf("") }
            TextField(value = text, onValueChange = {text = it}, label = { Text(text = "Name")})
            Button(
                onClick = { navController.navigate(Destinations.ADD)
                          viewModel.subject = text},
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