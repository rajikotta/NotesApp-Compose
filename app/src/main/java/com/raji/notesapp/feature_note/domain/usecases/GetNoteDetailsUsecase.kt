package com.raji.notesapp.feature_note.domain.usecases

import com.raji.notesapp.feature_note.domain.repositories.NoteRepository


/**
 * Created by Raji on 8/22/22.
 * Golden Scent
 */
class GetNoteDetailsUsecase(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Int) {
        repository.getNote(id)
    }
}