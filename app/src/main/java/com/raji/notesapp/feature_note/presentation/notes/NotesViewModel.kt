package com.raji.notesapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raji.notesapp.feature_note.domain.models.Note
import com.raji.notesapp.feature_note.domain.usecases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Raji on 8/22/22.
 * Golden Scent
 */
@HiltViewModel
class NotesViewModel @Inject constructor(private val noteUseCases: NoteUseCases) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.DeleteNote ->
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }

            is NotesEvent.Order ->
                if (state.value.noteOrder == event.order &&
                        state.value.noteOrder.orderType::class == event.order.orderType::class)
                    return

            NotesEvent.RestoreNote ->
                viewModelScope.launch {
                    noteUseCases.addNoteUsecase(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }

            NotesEvent.ToggleOrderSection ->

                _state.value = state.value.copy(isOrderSectionVisible = !state.value.isOrderSectionVisible)
        }
    }
}