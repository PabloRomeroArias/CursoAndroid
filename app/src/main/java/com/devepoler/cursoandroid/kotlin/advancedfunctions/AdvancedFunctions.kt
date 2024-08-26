package com.devepoler.cursoandroid.kotlin.advancedfunctions

/*
* 1.- Funciones de extensión
* 2.- Funciones lambda
* 3.- Recursividad
* */

fun main() {
    extension()
    lambdaFunction()
    recursion()
    println("Esta es la última línea de código")
}

fun extension() {
    val number = 4

    number.dec()

    val string = "Hola"
    val float = 5.0F
    string.length
    println(string.plus("float")) // Hola5

    number.isLeapYear()

    string.myFirstExtension()

    val message = "Mensaje super chulo"

    message.myFirstExtension()
}

fun String.myFirstExtension() {
    println("$this es el string que me ha llamado")
    println("El tamaño del string es $length")
    println("Estamos en nuestra primera función de extensión")
}

fun Int.isLeapYear() : Boolean {
    // 1900
    val firstCondition = (this % 4 == 0) // 1900 % 4 == 0 SI
    val secondCondition = (this % 100 != 0  // 1900 % 100 != 0 NO
            || this % 400 == 0) // 1900 % 400 NO

    val isLeapYear = firstCondition && secondCondition
    return isLeapYear
}

fun lambdaFunction() {
    val add = { firstNumber : Int, secondNumber : Int -> firstNumber + secondNumber}
    val subtract = { firstNumber : Int, secondNumber : Int -> firstNumber - secondNumber}

    val addResult = operacionMolona(4, 5, add)
    val subtractResult = operacionMolona(4, 5, subtract)

    println("El resultado de la suma es: $addResult")
    println("El resultado de la resta es: $subtractResult")
}

fun operacionMolona(
    firstNumber : Int,
    secondNumber : Int,
    operation : (Int, Int) -> Int
) : Int {
    return operation(firstNumber, secondNumber)
}


// factorial de 5 == 5 * 4 * 3 * 2 * 1 === !5
fun recursion() {
    // Tiene que existir un caso base

    print("El factorial es: ${factorial(5)}")
}

fun factorial(number : Int) : Int {
    if (number == 1)
        return 1

    return number * factorial(number - 1)
}