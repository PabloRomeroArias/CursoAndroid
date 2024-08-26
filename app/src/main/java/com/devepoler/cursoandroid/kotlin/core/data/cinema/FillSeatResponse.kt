package com.devepoler.cursoandroid.kotlin.core.data.cinema

sealed interface FillSeatResponse {
    data object SuccessfullyFilled : FillSeatResponse
    data object AlreadyFilled : FillSeatResponse
    data object Disabled : FillSeatResponse
}