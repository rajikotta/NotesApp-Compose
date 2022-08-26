package com.raji.notesapp.feature_note.presentation.notes.components

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.raji.notesapp.feature_note.presentation.notes.NotesEvent
import com.raji.notesapp.feature_note.presentation.notes.NotesViewModel
import kotlinx.coroutines.launch


/**
 * Created by Raji on 8/26/22.
 * Golden Scent
 */


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NotesScreen(navController: NavController,
                viewmodel: NotesViewModel = hiltViewModel()) {
    val state = viewmodel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(floatingActionButton = {

        FloatingActionButton(onClick = {},
                backgroundColor = MaterialTheme.colors.primary) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
        }
    }, scaffoldState = scaffoldState) {
        Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                Text("Your Notes", style = MaterialTheme.typography.h4)
                IconButton(onClick = {
                    viewmodel.onEvent(NotesEvent.ToggleOrderSection)
                }) {

                    Icon(imageVector = Icons.Default.Settings,
                            "Sort Options")
                }

            }
            AnimatedVisibility(visible = state.isOrderSectionVisible,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()) {

                OrderSection(modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp), orderChange = {
                    viewmodel.onEvent(NotesEvent.Order(it))
                })
            }
            Spacer(Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.notes) { note ->
                    NoteItem(note = note, modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                            }, onDeleteClick = {
                        viewmodel.onEvent(NotesEvent.DeleteNote(note))
                        scope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(message = "Note Deleted", actionLabel = "Undo")
                            if (result == SnackbarResult.ActionPerformed) {
                                viewmodel.onEvent(NotesEvent.RestoreNote)
                            }
                        }
                    })
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }

}