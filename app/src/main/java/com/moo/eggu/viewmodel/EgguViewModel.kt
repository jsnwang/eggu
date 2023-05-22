package com.moo.eggu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moo.eggu.data.Note
import com.moo.eggu.data.NoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EgguViewModel(private val repo: NoteRepo): ViewModel() {

    val noteList: Flow<List<Note>> = repo.getAllNotes()

    val countdownFlow = flow<Int> {
        val start = 10
        var current = start
        emit(current)
        while (current > 0) {
            delay(1000)
            current--
            emit(current)
        }
    }
    var subject: String = ""
    var content: String = ""
    private val tmpList = mutableListOf<Task>()

    fun addNote() {
        val note = Note(name = subject, time = content)
        viewModelScope.launch {
            repo.insert(note)
        }

    }

    fun deleteNotes() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.deleteNotes()
            }
        }
    }
    private fun collectFlow() {
        viewModelScope.launch {
            countdownFlow.collect() {time ->
                println("The current time is $time")
            }
        }
    }
}