package com.raji.notesapp.feature_note.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raji.notesapp.ui.theme.*

/** * Created by Raji on 21/08/2022. */
@Entity(tableName = "notes")
data class Note(
        val title: String,
        val content: String,
        val timeStamp: Long,
        val color: Int,
        @PrimaryKey(autoGenerate = true) val id: Int? = null
) {
    companion object {
        val noteColors = listOf(OrangeRed, LightGreen, Violet, BabyBlue, RedPink)
    }


}

class InvalidNoteException(message: String) : Exception(message) {

}