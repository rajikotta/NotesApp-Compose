package com.raji.notesapp.feature_note.presentation.notes

import com.raji.notesapp.feature_note.domain.models.Note
import com.raji.notesapp.feature_note.domain.util.NoteOrder
import com.raji.notesapp.feature_note.domain.util.OrderType


/**
 * Created by Raji on 8/22/22.
 * Golden Scent
 */
data class NotesState(
        val notes: List<Note> = emptyList(),
        val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending),
        val isOrderSectionVisible: Boolean = false

)

