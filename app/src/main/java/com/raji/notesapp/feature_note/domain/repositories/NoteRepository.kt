package com.raji.notesapp.feature_note.domain.repositories

import com.raji.notesapp.feature_note.domain.models.Note
import kotlinx.coroutines.flow.Flow

/** * Created by Raji on 22/08/2022. */
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNote(id:Int):Note?

    suspend fun deleteNote(note:Note)

    suspend fun insertNote(note:Note)
}