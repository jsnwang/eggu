package com.moo.eggu

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.moo.eggu.data.NoteDatabase
import com.moo.eggu.data.NoteRepo
import com.moo.eggu.ui.theme.EgguTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = NoteDatabase.getInstance(applicationContext)
        val repo = NoteRepo(db.noteDao())
        setContent {
            EgguTheme() {
                EgguApp(repo)
            }
        }
    }

    private lateinit var receiver: PowerConnectionReceiver

    override fun onResume() {
        super.onResume()

        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }

        receiver = PowerConnectionReceiver()
        registerReceiver(receiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

}

