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

    private var _taskList: MutableStateFlow<List<Task>> = MutableStateFlow(emptyList())
    val taskList: StateFlow<List<Task>> = _taskList.asStateFlow()

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
    var name: String = ""
    var time: String = ""
    private val tmpList = mutableListOf<Task>()

    fun addNote() {
        val note = Note(name = name, time = time)
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
    fun addTask() {
        tmpList.add(Task(name, time))
        _taskList.value = tmpList

        name = ""
        time = ""
    }

    private fun collectFlow() {
        viewModelScope.launch {
            countdownFlow.collect() {time ->
                println("The current time is $time")
            }
        }
    }
}