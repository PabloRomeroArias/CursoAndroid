package com.devepoler.cursoandroid.kotlin.core.data.cinema

sealed interface SeatState {
    data object Free : SeatState
    data object Filled : SeatState
    data object Disabled : SeatState
}