package com.devepoler.cursoandroid.kotlin.ifelsewhen

fun main() {
    areTwoShortNumbersEquals(2, 2)

    val totalEarned = calculateTotalMoneyWithExtra(41, 10.0)
    println("El total ganado es $totalEarned")

    printIfTwoStringsHaveSameLength("hola", "casa")
}

// Ejercicio 3.1
fun areTwoShortNumbersEquals(firstShort: Short, secondShort: Short) {
    if (firstShort == secondShort) {
        println("Los números  $firstShort y $secondShort son iguales.")
    }
}

// Ejercicio 3.2
fun calculateTotalMoneyWithExtra(workedHours: Short, pricePerHour: Double) : Double {
    val extraPrice = 1.5
    val totalEarned: Double

    if (workedHours > 40) {
        totalEarned = (40 * pricePerHour) + ((workedHours - 40) * pricePerHour * extraPrice)
    } else {
        totalEarned = workedHours * pricePerHour
    }

    return totalEarned
}

// Ejercicio 3.3
fun printIfTwoStringsHaveSameLength(firstString: String, secondString: String) {
    if (firstString.length == secondString.length) {
        println("$firstString y $secondString tienen la misma longitud")
    }
}