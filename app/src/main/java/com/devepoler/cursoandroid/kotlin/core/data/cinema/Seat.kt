package com.devepoler.cursoandroid.kotlin.core.data.cinema

class Seat(
    val number : Int,
    var state : SeatState = SeatState.Free
) {
    fun fillSeat() : FillSeatResponse {
        return when (state) {
            SeatState.Disabled -> FillSeatResponse.Disabled
            SeatState.Filled -> FillSeatResponse.AlreadyFilled
            SeatState.Free -> {
                state = SeatState.Filled
                FillSeatResponse.SuccessfullyFilled
            }
        }
    }

    override fun toString(): String {
        val message = when(state) {
            SeatState.Disabled -> " "
            SeatState.Filled -> "X"
            SeatState.Free -> "$number"
        }
        return if (message.length == 1) " $message"
        else message
    }
}