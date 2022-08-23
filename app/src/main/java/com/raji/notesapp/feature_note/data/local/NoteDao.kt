package com.raji.notesapp.feature_note.data.local

import androidx.room.*
import com.raji.notesapp.feature_note.domain.models.Note
import kotlinx.coroutines.flow.Flow

/** * Created by Raji on 22/08/2022. */
@Dao
interface NoteDao {

    @Query("select * from notes")
    fun getNotes(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("select * from notes where id LIKE :id")
    suspend fun getNote(id: String): Note?
}