package com.moo.eggu.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.moo.eggu.navigation.Destinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navigationIcon: () -> Unit, navController: NavController) {
    TopAppBar(
        title = { Text(text = "Notes") },
        navigationIcon = {
            IconButton(onClick = navigationIcon) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = {
                if (navController.currentDestination != navController.findDestination(Destinations.ADD)) {
                    navController.navigate(Destinations.ADD)
                }
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        },
    )
}