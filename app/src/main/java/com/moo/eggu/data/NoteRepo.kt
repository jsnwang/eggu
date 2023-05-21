package com.moo.eggu.data

import kotlinx.coroutines.flow.Flow

class NoteRepo(private val dao: NoteDao) {

    fun getAllNotes(): Flow<List<Note>> = dao.getAll()

    suspend fun insert(note: Note) {
        dao.addNote(note)
    }

    suspend fun deleteNotes() = dao.deleteTable()
}