package com.moo.eggu.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
        fun getAll(): Flow<List<Note>>
    @Insert
    suspend fun addNote(note: Note)
    @Delete
    suspend fun deleteNote(note: Note)
    @Query("DELETE FROM note")
    suspend fun deleteTable()
}