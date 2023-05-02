package com.moo.eggu

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moo.eggu.ui.components.EgguScaffold
import com.moo.eggu.ui.theme.EgguTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EgguTheme {
                EgguScaffold(title = "Title", onNavigationIconClick = { /*TODO*/ },) {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        //color = MaterialTheme.colorScheme.background
                    ) {
                        SixButtons()
                    }
                }
            }
        }
    }
}
@Composable
@Preview
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
fun SixButtons() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            ) {
                Text("Button 1")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                shape = RectangleShape
            ) {
                Text("Button 2")
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                shape = RectangleShape
            ) {
                Text("Button 3")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                shape = RectangleShape
            ) {
                Text("Button 4")
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                shape = RectangleShape
            ) {
                Text("Button 5")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                shape = RectangleShape
            ) {
                Text("Button 6")
            }
        }
    }
}