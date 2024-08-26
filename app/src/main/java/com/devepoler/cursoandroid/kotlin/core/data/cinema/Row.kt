package com.devepoler.cursoandroid.kotlin.core.data.cinema

class Row(
    val number : Int,
    val seatList : List<Seat>
) {
    override fun toString(): String {
        val prefix = if (number < 10)
            " $number"
        else
            number.toString()
        return seatList.joinToString(
            separator = " ",
            prefix = "$prefix |"
        )
    }
}