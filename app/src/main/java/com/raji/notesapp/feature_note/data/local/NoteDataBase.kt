package com.raji.notesapp.feature_note.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raji.notesapp.feature_note.domain.models.Note

/** * Created by Raji on 22/08/2022. */
@Database(entities = [Note::class], version = 1)
abstract class NoteDataBase:RoomDatabase() {
    abstract val dao : NoteDao
}