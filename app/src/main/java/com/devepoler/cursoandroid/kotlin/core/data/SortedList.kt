package com.devepoler.cursoandroid.kotlin.core.data

interface SortedList {
    data object Ascending : SortedList
    data object Descending : SortedList
    data object NotSorted : SortedList
}