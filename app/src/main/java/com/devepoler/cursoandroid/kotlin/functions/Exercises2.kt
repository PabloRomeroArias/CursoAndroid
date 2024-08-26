package com.devepoler.cursoandroid.kotlin.functions

import java.util.function.DoubleToLongFunction

// KDoc
fun main() {
    // val message = returnMessage()
    // println(message)

    triangleArea(2.0, 3.0)

    println("El área del círculo es: ${circleLength(3.0)}")

    println("¿Es el año bisiesto? ${isLeapYear(1900)}")
}

/**
 * Ej 1: pide por teclado un mensaje y devuélvelo
 *
 * @return return a message given with readln() function
 */
fun returnMessage(): String {
    print("Introduce tu mensaje: ")
    val message = readln()
    return message
}

/**
 * Ej 2: Dadas la base y la altura de un triángulo, calcula e imprime por pantalla el área del mismo
 *
 * @param base base of the triangle
 * @param height height of the triangle
 */
fun triangleArea(base : Double, height : Double) : Unit {
    val area = (base * height) / 2 // La división es double porque un elemento es double

    println("El área del triángulo de base $base y altura $height es: $area")
}

/* Esta función es exactamente lo mismo que la siguiente sin comentar
fun circleLength3(radius : Double) : Double {
    val length = (2 * 3.14 * radius)

    return (2 * 3.14 * radius)
}
*/

/**
 * Ej 3: Calcula la longitud de la circunferencia dado el radio y la devuelve
 *
 * @param radius radius of the circle
 *
 * @return the circle length
 */
// Vamos a llamar a la librería de Math para el valor exacto de PI
// Cuando son constantes, el nombre del valor va con MAYÚSCULAS_SEPARADAS_CON_GUIÓN_BAJO
fun circleLength(radius : Double) = (2 * Math.PI * radius)

// Si devolvemos un booleano
/**
 * Ej 4: Devuelve si un año es bisiesto o no
 *
 * @param year year to research
 *
 * @return true if is leap year. False otherwise
 */
fun isLeapYear(year : Int) : Boolean {
    // 1900
    val firstCondition = (year % 4 == 0) // 1900 % 4 == 0 SI
    val secondCondition = (year % 100 != 0  // 1900 % 100 != 0 NO
            || year % 400 == 0) // 1900 % 400 NO

    val isLeapYear = firstCondition && secondCondition
    return isLeapYear
}