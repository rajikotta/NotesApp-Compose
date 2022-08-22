package com.raji.notesapp.feature_note.data.repository

import com.raji.notesapp.feature_note.data.local.NoteDao
import com.raji.notesapp.feature_note.domain.models.Note
import com.raji.notesapp.feature_note.domain.repositories.NoteRepository
import kotlinx.coroutines.flow.Flow

/** * Created by Raji on 22/08/2022. */
class NoteRepositoryImpl(val dao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNote(id: String): Note? {
        return dao.getNote(id)
    }

    override suspend fun deleteNote(note: Note) {
        dao.delete(note)
    }

    override suspend fun insertNote(note: Note) {
        dao.insert(note)
    }
}