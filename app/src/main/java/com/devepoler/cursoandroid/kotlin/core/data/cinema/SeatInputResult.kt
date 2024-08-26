package com.devepoler.cursoandroid.kotlin.core.data.cinema

sealed interface SeatInputResult {
    data class RightInput(val room : Room) : SeatInputResult
    data class Error(val msg: String) : SeatInputResult
}