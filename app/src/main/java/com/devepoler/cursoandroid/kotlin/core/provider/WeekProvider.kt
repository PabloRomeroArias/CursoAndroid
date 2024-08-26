package com.devepoler.cursoandroid.kotlin.core.provider

import com.devepoler.cursoandroid.kotlin.core.data.cinema.Day
import com.devepoler.cursoandroid.kotlin.core.data.cinema.DayOfWeek
import com.devepoler.cursoandroid.kotlin.core.data.cinema.Movie
import com.devepoler.cursoandroid.kotlin.core.data.cinema.Room
import com.devepoler.cursoandroid.kotlin.core.data.cinema.Row
import com.devepoler.cursoandroid.kotlin.core.data.cinema.Seat
import com.devepoler.cursoandroid.kotlin.core.data.cinema.SeatState
import com.devepoler.cursoandroid.kotlin.core.data.cinema.Week

class WeekProvider {

    // bloque estático
    companion object {
        fun getWeek(): Week {
            return Week(
                hashMapOf(
                    DayOfWeek.Monday to getMonday(),
                    DayOfWeek.Tuesday to getTuesday(),
                    DayOfWeek.Wednesday to getWednesday(),
                    DayOfWeek.Thursday to getThursday(),
                    DayOfWeek.Friday to getFriday(),
                    DayOfWeek.Saturday to getSaturday(),
                    DayOfWeek.Sunday to getSunday()
                )
            )
        }

        private fun getMonday(): Day {
            return Day(
                DayOfWeek.Monday,
                sortedMapOf(
                    compareBy { it.number },
                    Room(1, getRowList()) to Movie("DeadPool"),
                    Room(2, getRowList()) to Movie("Doraemon"),
                    Room(3, getRowList()) to Movie("Saw")
                )
            )
        }

        private fun getTuesday(): Day {
            return Day(
                DayOfWeek.Tuesday,
                sortedMapOf(
                    compareBy { it.number },
                    Room(1, getRowList()) to Movie("Fast and Furious"),
                    Room(2, getRowList()) to Movie("Spiderman"),
                    Room(3, getRowList()) to Movie("Rompiendo el círculo")
                )
            )
        }

        private fun getWednesday(): Day {
            return Day(
                DayOfWeek.Wednesday,
                sortedMapOf(
                    compareBy { it.number },
                    Room(1, getRowList()) to Movie("Fast and Furious"),
                    Room(2, getRowList()) to Movie("Spiderman"),
                    Room(3, getRowList()) to Movie("Rompiendo el círculo")
                )
            )
        }

        private fun getThursday(): Day {
            return Day(
                DayOfWeek.Thursday,
                sortedMapOf(
                    compareBy { it.number },
                    Room(1, getRowList()) to Movie("Fast and Furious"),
                    Room(2, getRowList()) to Movie("Spiderman"),
                    Room(3, getRowList()) to Movie("Rompiendo el círculo")
                )
            )
        }

        private fun getFriday(): Day {
            return Day(
                DayOfWeek.Friday,
                sortedMapOf(
                    compareBy { it.number },
                    Room(1, getRowList()) to Movie("Fast and Furious"),
                    Room(2, getRowList()) to Movie("Spiderman"),
                    Room(3, getRowList()) to Movie("Rompiendo el círculo")
                )
            )
        }

        private fun getSaturday(): Day {
            return Day(
                DayOfWeek.Saturday,
                sortedMapOf(
                    compareBy { it.number },
                    Room(1, getRowList()) to Movie("Fast and Furious"),
                    Room(2, getRowList()) to Movie("Spiderman"),
                    Room(3, getRowList()) to Movie("Rompiendo el círculo")
                )
            )
        }

        private fun getSunday(): Day {
            return Day(
                DayOfWeek.Sunday,
                sortedMapOf(
                    compareBy { it.number },
                    Room(1, getRowList()) to Movie("Fast and Furious"),
                    Room(2, getRowList()) to Movie("Spiderman"),
                    Room(3, getRowList()) to Movie("Rompiendo el círculo")
                )
            )
        }

        private fun getRowList(): List<Row> {
            val rowList = mutableListOf<Row>()

            for (i in 1..15)
                rowList.add(Row(i, getSeatList()))

            return rowList
        }

        private fun getSeatList(): List<Seat> {
            val seatList = mutableListOf<Seat>()

            for (i in 1..20) {
                val state: SeatState = when (i) {
                    2 -> SeatState.Filled
                    19 -> SeatState.Disabled
                    else -> SeatState.Free
                }
                seatList.add(Seat(i, state))
            }
            return seatList
        }
    }
}