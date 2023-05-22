package com.moo.eggu

import androidx.compose.runtime.Composable
import com.moo.eggu.data.NoteRepo
import com.moo.eggu.navigation.NavGraph
import com.moo.eggu.ui.components.EgguScaffold
import com.moo.eggu.ui.theme.EgguTheme

@Composable
fun EgguApp(repo: NoteRepo) {
    EgguTheme {
        EgguScaffold {
            NavGraph(noteRepo = repo)
        }
    }
}



