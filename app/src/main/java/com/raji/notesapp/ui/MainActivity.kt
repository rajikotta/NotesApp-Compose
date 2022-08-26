package com.raji.notesapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.raji.notesapp.feature_note.presentation.add_edit_note.componenets.AddEditNoteScreen
import com.raji.notesapp.feature_note.presentation.notes.components.NotesScreen
import com.raji.notesapp.feature_note.presentation.util.Screen
import com.raji.notesapp.ui.theme.NotesAppTheme
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Raji on 8/22/22.
 * Golden Scent
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.NoteScreen.route) {
                        composable(route = Screen.NoteScreen.route) { NotesScreen(navController = navController) }
                        composable(route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}", arguments = listOf(
                                navArgument(name = "noteId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "noteColor") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                        )) {
                            val color = it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScreen(navController = navController, noteColor = color)
                        }
                    }

                }
            }
        }

    }
}