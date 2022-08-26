package com.raji.notesapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/**
 * Created by Raji on 8/23/22.
 * Golden Scent
 */
@Composable
fun DefaultRadioButton(text: String, isChecked: Boolean, onSelected: () -> Unit) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = isChecked,
                onClick = onSelected,
                colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colors.primary,
                        unselectedColor = MaterialTheme.colors.onBackground))
        Spacer(Modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.body1)
    }
}