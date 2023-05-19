package com.moo.eggu.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>
}