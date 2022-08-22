package com.raji.notesapp.feature_note.domain.util


/**
 * Created by Raji on 8/22/22.
 * Golden Scent
 */
sealed class OrderType {
    object Ascending:OrderType()
    object Descending:OrderType()
}