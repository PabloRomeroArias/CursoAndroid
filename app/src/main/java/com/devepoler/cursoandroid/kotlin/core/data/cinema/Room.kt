package com.devepoler.cursoandroid.kotlin.core.data.cinema

class Room(
    val number : Int,
    val rowList : List<Row>
) {
    fun getFreeSeats() : Int {
        var counter = 0

        for (row in rowList) {
            counter += row.seatList.count { seat ->
                seat.state == SeatState.Free
            }
        }

        return counter
    }

    fun fillSeat(row: Row, seat: Seat) : Boolean {
        rowList
            .find { it.number == row.number }
            ?.seatList?.forEach {
                if (it.number == seat.number) {
                    it.fillSeat()
                    return true
                }
            }

        return false
    }

    fun getSeatByRowAndSeatNumber(rowNumber : Int, seatNumber : Int) : Seat? {
        return rowList
            .find { it.number == rowNumber } // Buscamos fila
            ?.seatList
            ?.find { it.number == seatNumber } // Buscamos asiento
    }
     override fun toString(): String {
        val message = rowList.joinToString(
            separator = "\n",
            prefix = "==== Sala $number ====\n",
        )
        return message
    }
}