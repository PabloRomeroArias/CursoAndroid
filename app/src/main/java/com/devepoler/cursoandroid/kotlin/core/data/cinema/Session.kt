package com.devepoler.cursoandroid.kotlin.core.data.cinema

class Session(
    val room : Room,
    val movie: Movie
) {
    override fun toString(): String {
        return "$room\nPelícula: $movie"
    }

    fun fillSeats(fakeRoom: Room) : Boolean {
        fakeRoom.rowList.forEach { row ->
            row.seatList.forEach { seat ->
                val realSeat = room.getSeatByRowAndSeatNumber(row.number, seat.number)

                return if (canFillSeat(realSeat)) {
                    // !! asegura que no va a ser nulo
                    if (room.fillSeat(row, realSeat!!)) {
                        true
                    } else
                        false
                } else
                    false
            }
        }
        return true
    }

    private fun canFillSeat(seat : Seat?) =
        seat != null
                && seat.state == SeatState.Free
}