package com.moo.eggu.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moo.eggu.data.NoteRepo

class EgguViewModelFactory(private val repository: NoteRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EgguViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EgguViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}