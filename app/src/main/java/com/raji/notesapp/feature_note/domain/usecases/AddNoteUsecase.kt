package com.raji.notesapp.feature_note.domain.usecases

import com.raji.notesapp.feature_note.domain.models.InvalidNoteException
import com.raji.notesapp.feature_note.domain.models.Note
import com.raji.notesapp.feature_note.domain.repositories.NoteRepository


/**
 * Created by Raji on 8/22/22.
 * Golden Scent
 */
class AddNoteUsecase(private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank())
            throw InvalidNoteException("Title can't be empty")
        if (note.content.isBlank())
            throw InvalidNoteException("Content can't be empty")
        repository.insertNote(note)
    }
}