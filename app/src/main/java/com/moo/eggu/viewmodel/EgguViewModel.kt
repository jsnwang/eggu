package com.moo.eggu.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moo.eggu.data.Note
import com.moo.eggu.data.NoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EgguViewModel(private val repo: NoteRepo): ViewModel() {

    val noteList: Flow<List<Note>> = repo.getAllNotes()

    val showDeleteDialog = mutableStateOf(false)

    var subjectText by mutableStateOf("")
    var contentText by mutableStateOf("")
    fun showDeleteDialog() {
        showDeleteDialog.value = true
    }

    fun dismissDeleteDialog() {
        showDeleteDialog.value = false
    }

    fun addNote() {
        val note = Note(name = subjectText, time = contentText)
        viewModelScope.launch {
            repo.insert(note)
        }
        subjectText = ""
        contentText = ""
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repo.delete(note)
        }
    }

    fun deleteNotes() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.deleteNotes()
            }
        }
    }
}