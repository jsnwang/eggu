package com.moo.eggu

import androidx.compose.runtime.Composable
import com.moo.eggu.navigation.NavGraph
import com.moo.eggu.ui.theme.EgguTheme

@Composable
fun EgguApp() {
    EgguTheme {
        NavGraph()
    }
}



