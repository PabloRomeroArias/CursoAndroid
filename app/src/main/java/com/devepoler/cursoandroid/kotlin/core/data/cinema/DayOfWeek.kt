package com.devepoler.cursoandroid.kotlin.core.data.cinema

sealed interface DayOfWeek {
    data object Monday : DayOfWeek
    data object Tuesday : DayOfWeek
    data object Wednesday : DayOfWeek
    data object Thursday : DayOfWeek
    data object Friday : DayOfWeek
    data object Saturday : DayOfWeek
    data object Sunday : DayOfWeek
}