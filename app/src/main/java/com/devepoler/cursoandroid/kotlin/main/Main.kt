package com.devepoler.cursoandroid.kotlin.main

import com.devepoler.cursoandroid.kotlin.core.data.cinema.Day
import com.devepoler.cursoandroid.kotlin.core.data.cinema.DayOfWeek
import com.devepoler.cursoandroid.kotlin.core.data.cinema.Room
import com.devepoler.cursoandroid.kotlin.core.data.cinema.Row
import com.devepoler.cursoandroid.kotlin.core.data.cinema.Seat
import com.devepoler.cursoandroid.kotlin.core.data.cinema.SeatInputResult
import com.devepoler.cursoandroid.kotlin.core.data.cinema.SeatState
import com.devepoler.cursoandroid.kotlin.core.data.cinema.Session
import com.devepoler.cursoandroid.kotlin.core.provider.WeekProvider

val WEEK = WeekProvider.getWeek()

fun main() {
    chooseWeekDay()
    printExitMessage()
}

fun chooseWeekDay() {
    var option : Int?

    do {
        printChooseWeekDayMessage()
        option = readln().toIntOrNull()
    } while (option !in 1..8)

    if (option == 8) {
        return
    }

    chooseMovie(getDayOfWeekFromInput(option))
}

fun getDayOfWeekFromInput(op : Int?) : DayOfWeek {
    return when(op) {
        1 -> DayOfWeek.Monday
        2 -> DayOfWeek.Tuesday
        3 -> DayOfWeek.Wednesday
        4 -> DayOfWeek.Thursday
        5 -> DayOfWeek.Friday
        6 -> DayOfWeek.Saturday
        7 -> DayOfWeek.Sunday
        else -> DayOfWeek.Monday
    }
}

fun chooseMovie(dayOfWeek : DayOfWeek) {
    val day = WEEK.schedule[dayOfWeek] ?: return

    val maxOptionValue = day.sessionList.size + 2

    var option : Int?

    do {
        printChooseMovieMessage(day)
        option = readln().toIntOrNull()
    } while (option !in 1..maxOptionValue)

    when (option) {
        maxOptionValue -> return
        maxOptionValue - 1 -> chooseWeekDay()
        else -> chooseSeatNumber(dayOfWeek, getSessionFromRoomNumber(day, option))
    }
}

fun getSessionFromRoomNumber(day : Day, option : Int?) : Session? {
    if (option == null) return null

    for (session in day.sessionList) {
        if (session.room.number == option)
            return session
    }
    return null
}

fun chooseSeatNumber(dayOfWeek: DayOfWeek, session : Session?) {
    if (session == null) return

    val maxSeatsAvailable = session.room.getFreeSeats()
    var seatNumber : Int?

    do {
        printChooseSeatNumberMessage(session, maxSeatsAvailable)
        seatNumber = readln().toIntOrNull()
    } while (seatNumber !in -1..maxSeatsAvailable)

    when (seatNumber) {
        in 1..maxSeatsAvailable -> chooseSeats(seatNumber, session, dayOfWeek)
        0 -> chooseMovie(dayOfWeek)
        else -> return
    }
}

fun chooseSeats(seatNumber : Int?, session : Session, dayOfWeek: DayOfWeek) {
    if (seatNumber == null) return

    printChooseSeatsMessage(seatNumber, session)

    var seatInputResult : SeatInputResult = SeatInputResult.Error("No se ha inicializado")

    when (val seatInput = readln()) {
        "1" -> chooseSeatNumber(dayOfWeek, session)
        "2" -> return
        else -> seatInputResult = checkSeatInput(seatInput, seatNumber, session)
    }

    when (seatInputResult) {
        is SeatInputResult.Error -> {
            println("${seatInputResult.msg} (Pulsa intro para continuar)")
            readln()
            chooseSeats(seatNumber, session, dayOfWeek)
        }
        is SeatInputResult.RightInput -> {
            if (fillSessionSeat(seatInputResult.room, session))
                askForOtherBooking(session)
            else {
                println("Fallo al ocupar las butacas. Mira bien las butacas disponibles (Intro para nº butacas)")
                readln()
                chooseSeatNumber(dayOfWeek, session)
            }
        }}
}

fun askForOtherBooking(session: Session) {
    var option : Int?

    do {
        printSessionWithFinalMessage(session)
        option = readln().toIntOrNull()
    } while (option !in 1..2)

    when (option) {
        1 -> chooseWeekDay()
        else -> return
    }
}

fun printSessionWithFinalMessage(session: Session) {
    print("""
        $session
        1.- Realizar otra reserva
        2.- Salir
        Introduce opción: 
    """.trimIndent())
} 

fun fillSessionSeat(fakeRoom : Room, session : Session) : Boolean {
    val sessionFilledSuccessFully = session.fillSeats(fakeRoom)

    println(session)

    return sessionFilledSuccessFully
}

fun checkSeatInput(input : String, totalSeatNumber: Int, session: Session) : SeatInputResult {
    val rowSeatInputList = input.split(" ") // [1;13, 1;14, 1;5, 2;3, 2;4, 2;5]

    // {1=[1;1, 1;2, 1;3, 1;4], 4=[4;1, 4;2, 4;3, 4;4]}
    val rowSeatHashMap = rowSeatInputList.groupBy {
        val endIndex = it.indexOf(";")
        it.substring(0, endIndex)
    }

    val rowList = mutableListOf<Row>()

    // row 1 rowSeat (valor) -> [1;1, 1;2, 1;3]
    for ((row, rowSeatList) in rowSeatHashMap) {
        val seatList = mutableListOf<Seat>()

        val rowNumber = row.toIntOrNull()
            ?: return SeatInputResult.Error("La fila \"$row\" no es un número")

        for (rowSeat in rowSeatList) {
            val startIndex = rowSeat.indexOf(";") + 1
            val seatNumber = rowSeat.substring(startIndex).toIntOrNull()
                ?: return SeatInputResult.Error("La butaca \"$rowSeat\" es un número")
            seatList.add(Seat(seatNumber))
        }
        rowList.add(Row(rowNumber, seatList))
    }

    val room = Room(0, rowList)
    val seatNumberSelected = room.getFreeSeats()

    if (seatNumberSelected != totalSeatNumber)
        return SeatInputResult.Error("$totalSeatNumber asientos totales. $seatNumberSelected seleccionados")

    return SeatInputResult.RightInput(room)
}

fun printChooseSeatsMessage(seatNumber: Int, session: Session) {
    print(
        """
            $session
        1.- Volver atrás (Seleccionar butacas. $seatNumber en total)
        2.- Salir
        Introduzca butacas (FILA;BUTACA | Ej - 1;14 1;15 1;16): 
        """.trimIndent()
    )
}

fun printChooseSeatNumberMessage(session : Session, maxSeatsAvailable: Int?) {
    print(
        """$session
        0.- Volver atrás (Elegir película)
        -1.- Salir
        ¿Cuántas butacas quieres? ($maxSeatsAvailable como máximo): 
    """.trimIndent()
    )
}

fun printChooseMovieMessage(day : Day?) {
    if (day == null) {
        println("Error en el sistema")
        return
    }

    var counter = 1
    var message = "\n${day.dayOfWeek}\n"

    for (session in day.sessionList) {
        message += "${session.room.number}.- ${session.movie}.\n"
        counter++
    }

    message += """
        $counter.- Volver atrás (Elegir día de la semana)
        ${++counter}.- Salir
        Selecciona una película: 
    """.trimIndent()

    print(message)
}

fun printChooseWeekDayMessage() {
    print("""
        1.- Lunes
        2.- Martes
        3.- Miércoles
        4.- Jueves
        5.- Viernes
        6.- Sábado
        7.- Domingo
        8.- Salir
        Introduce un día de la semana (8 para salir): 
    """.trimIndent()
    )
}

fun printExitMessage() {
    println("Hasta pronto!")
}












fun testRoom() {
    val roomList = getRoomList()

    for (room in roomList) {
        println(room)
        println()
    }
}

fun getRoomList() : List<Room> {
    val roomList = mutableListOf<Room>()

    for (i in 1..10)
        roomList.add(Room(i, getRowList()))

    return roomList
}

fun testRow() {
    val rowList = getRowList()

    for (row in rowList)
        println(row)
}

fun getRowList() : List<Row> {
    val rowList = mutableListOf<Row>()

    for (i in 1..15)
        rowList.add(Row(i, getSeatList()))

    return rowList
}

fun testSeat() {
    val seatList = getSeatList()

    for (seat in seatList)
        println("$seat $seat $seat $seat $seat")
}

fun getSeatList() : List<Seat> {
    val seatList = mutableListOf<Seat>()

    for (i in 1..20) {
        val state : SeatState = when (i) {
            2 -> SeatState.Filled
            19 -> SeatState.Disabled
            else -> SeatState.Free
        }
        seatList.add(Seat(i, state))
    }

    return seatList
}