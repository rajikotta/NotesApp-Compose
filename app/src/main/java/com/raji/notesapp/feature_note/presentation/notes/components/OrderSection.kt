package com.raji.notesapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raji.notesapp.feature_note.domain.util.NoteOrder
import com.raji.notesapp.feature_note.domain.util.OrderType


/**
 * Created by Raji on 8/23/22.
 * Golden Scent
 */
@Composable
fun OrderSection(modifier: Modifier,
                 noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
                 orderChange: (NoteOrder) -> Unit) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {

            DefaultRadioButton(text = "Title", isChecked = noteOrder is NoteOrder.Title, onSelected = { orderChange(NoteOrder.Title(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "Date", isChecked = noteOrder is NoteOrder.Date, onSelected = { orderChange(NoteOrder.Date(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "Color", isChecked = noteOrder is NoteOrder.Color, onSelected = { orderChange(NoteOrder.Color(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(text = "Ascending", isChecked = noteOrder.orderType is OrderType.Ascending, onSelected = { orderChange(noteOrder.copy(OrderType.Ascending)) })
            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "Descending", isChecked = noteOrder.orderType is OrderType.Descending, onSelected = { orderChange(noteOrder.copy(OrderType.Descending)) })
            Spacer(modifier = Modifier.width(8.dp))

        }

    }

}