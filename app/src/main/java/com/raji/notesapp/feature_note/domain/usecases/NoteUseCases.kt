package com.raji.notesapp.feature_note.domain.usecases


/**
 * Created by Raji on 8/22/22.
 * Golden Scent
 */
data class NoteUseCases(val getNoteUseCase: GetNoteUseCase,
                        val deleteNote: DeleteNoteUsecase,
                        val addNoteUsecase: AddNoteUsecase,
                        val getNoteDetailsUsecase: GetNoteDetailsUsecase
)
