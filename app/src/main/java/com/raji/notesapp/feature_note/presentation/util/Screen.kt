package com.raji.notesapp.feature_note.presentation.util


/**
 * Created by Raji on 8/26/22.
 * Golden Scent
 */
sealed class Screen(val route: String) {
    object NoteScreen : Screen("notes_screen")
    object AddEditNoteScreen : Screen("add_edit_note_screen")
}
