package com.devepoler.cursoandroid.kotlin.introduccion

fun main() {
    // 1. Valores y variables
    val number = 10 // val == value number == nombre del value | 10 (detrás del igual) == valor
    var numberTwo = 14 // var == variable | numberTwo == nombre de la variable | 14 == valor

    println(numberTwo)

    numberTwo = 20

    println(number)
    println(numberTwo)

    // 2. Tipos de datos más comunes
    /*
     * 1. numeros
     * 2. booleans
     * 3. cadena de texto o String
     * 4. listas o arrays
     * */

    // Podemos especificar el tipo poniendo dos puntos detrás del nombre
    val mNumber: Int = 12
    val mBoolean: Boolean = true // o false
    val mString: String = "Mi primer string"
    val mList: List<Int> = listOf(0, 1, 4, 7, 9)

    println(mNumber)
    println(mBoolean)
    println(mString)
    println(mList)

    // 3. Sintaxis
    // Comentario de una linea

    /* Comentario
    * multilinea
    */

    // { bloque de código }

    // 4. Formateo de strings
    val age: Int = 27
    println("Hola, mi edad es: $age años") // Para incluir valores y variables en un string, añadimos $
    println("Este es mi primer booleano, y su valor es: $mBoolean.")

    // 5. Palabras reservadas
    val hi = "hola"
}