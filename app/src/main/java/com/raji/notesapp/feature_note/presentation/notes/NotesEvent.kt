package com.raji.notesapp.feature_note.presentation.notes

import com.raji.notesapp.feature_note.domain.models.Note
import com.raji.notesapp.feature_note.domain.util.NoteOrder


/**
 * Created by Raji on 8/22/22.
 * Golden Scent
 */
sealed class NotesEvent {
    data class Order(val order: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object ToggleOrderSection : NotesEvent()
    object RestoreNote : NotesEvent()
}