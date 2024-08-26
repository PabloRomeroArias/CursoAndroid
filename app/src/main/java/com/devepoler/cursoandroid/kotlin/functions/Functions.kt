package com.devepoler.cursoandroid.kotlin.functions

/*
* 1. Introducción a las funciones
* 2. Parámetros de entrada y opcionales
* 3. Parámetros de salida
* 4. Datos por teclado
* 5. Nulos y operador Elvis
*/

// bloque de código que ejecuta una serie de instrucciones
// siempre y cuando sean llamadas
// print("mensaje")

fun main() {
    /*println("Primer mensaje del algoritmo")
    firstFunction()
    println("Último mensaje del algoritmo")
    println("Cadena de caracteres")

    greetPerson("Pablo", 27)

    optionalParameter(
        "Negro",
        "Azul",
    )

    val message = returnFunction()
    println(message)
*/
    // readKeyboardData()
    nullFunction()
}

// Firma de la función
fun firstFunction() {
    println("Estamos en nuestra primera función")
    println("Y esto mola mogollón")
}

fun greetPerson(name : String, age: Int) {
    println("Hola, $name. Sé que tienes $age años")
}

fun optionalParameter(
    hatedColor: String,
    mehColor: String,
    favouriteColor: String = "Lila",
) {
    println("Mi color favorito es el $favouriteColor, el odiado es el $hatedColor y el $mehColor, ni fú, ni fá")
}

fun returnFunction() : String {
    return "Primer mensaje devuelto en mi super función"
}

fun readKeyboardData() {
    print("Escribe tu primer mensaje: ")
    val message = readln()
    println(message)
}

fun nullFunction() {
    print("Introduce tu edad: ")
    // ? indica que el value es nulable
    // se parece al tupé de Elvis Presley ?:
    val age = readln().toIntOrNull() ?: -1
    println("Tu edad es de $age años.")
}