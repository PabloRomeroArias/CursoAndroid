package com.devepoler.cursoandroid.kotlin.erroranddebug

/*
 1. Control de errores con try catch
 2. Debug
 */
fun main() {
    val number = parseReadLnToIntSafely(
        message = "Mete algo: ",
        stopSearchingWord = "bye"
    )
    print(number ?: "No introdujo nada") // operador elvis
}

fun printListElement() {
    print("Introduce palabras: ")
    val input = readln()
    val wordList = input.split(" ")

    try {
        print(wordList[3])
    } catch (exception: IndexOutOfBoundsException) {
        print("El elemento no existe en ese índice")
    }
}

fun parseReadLnToInt() {
    print("Introduce un número: ")
    val input = readln()

    try {
        val number = input.toInt()
        println(number)
        println(Int.MAX_VALUE)
    } catch (ex: NumberFormatException) {
        print("El input introducido \"$input\" no es un número, espabila crack!")
    }
}

fun parseReadLnToIntSafely(
    message : String = "Introduce un número: ",
    stopSearchingWord : String = "exit"
) : Int? {
    var number: Int? = null

    do {
        // breakpoint
        print(message)
        val input = readln()

        try {
            number = input.toInt()
        } catch (ex: NumberFormatException) {
            if (input == stopSearchingWord)
                println("Adiós personita")
            else
                println("El input introducido \"$input\" no es un número, espabila crack! (\"$stopSearchingWord\" para dejar de introducir)")
        }
    } while(number == null && input != stopSearchingWord)

    return number
}