package com.devepoler.cursoandroid.kotlin.introduccion

fun main() {
    /* Operadores
    * 1. Aritméticos
    * 2. Relacionales
    * 3. Lógicos
    * 4. Asignación
    * */

    /* 1. Aritméticos
    * Suma, resta, multiplicación, división, resto (o módulo), incremento y decremento
    * */
    var firstNumber : Int = 10
    var secondNumber : Int = 5
    val thirstNumber : Double = 4.0

    val addition : Int = firstNumber + secondNumber + 13
    val subtract : Int = firstNumber - secondNumber - 20
    val multiplication : Int = firstNumber * secondNumber
    val division : Double = firstNumber / thirstNumber // barra inclinada == slash
    val increment: Int = ++firstNumber // hay que poner el doble + delante o detrás, según nos convenga
    val decrement: Int = --secondNumber // hay que poner el doble - delante o detrás, según nos convenga
    val modulus: Int = firstNumber % secondNumber

    println("Suma: $addition")
    println("Resta: $subtract")
    println("Multiplicación: $multiplication")
    println("División: $division")
    println("Incremento: $increment")
    println("Decremento: $decrement")
    println("Resto ($firstNumber % $secondNumber): $modulus")

    /* 2. Relacionales
    * Comparan un elemento con otro
    * Igualdad, Desigualdad, mayor que, menor que, mayor igual que, menor igual que
    */

    val firstRelationalNumber : Int = 5
    val secondRelationalNumber : Int = 6

    val equal: Boolean = firstRelationalNumber == secondRelationalNumber // estamos comparando, nos devuelve un BOOLEANO
    val notEqual = firstRelationalNumber != secondRelationalNumber

    val greaterThan = firstRelationalNumber > secondRelationalNumber
    val lowerThan = firstRelationalNumber < secondRelationalNumber

    val greaterOrEqualThan = firstRelationalNumber >= secondRelationalNumber
    val lowerOrEqualThan = firstRelationalNumber <= secondRelationalNumber

    // El símbolo ! cambia el booleano o la expresión dada

    println("$firstRelationalNumber == $secondRelationalNumber: $equal")
    println("Desigual: $notEqual")
    println("Mayor que: $greaterThan")
    println("Menor que: $lowerThan")
    println("Mayor o igual que: $greaterOrEqualThan")
    println("Menor o igual que: $lowerOrEqualThan")

    /* 3. Lógicos
    * AND, OR, !
    */
    // && tengo un coche y una moto. Es verdad si, y solo si, tengo ambos, es decir, son true
    // false: al menos, uno de los dos "predicados" (o statement) es false
    val hasCar = false
    val hasBike = false

    // || tengo un coche O una moto. Es verdad, si, al menos, un statemnt es true

    val hasBothVehicles = !(hasCar && hasBike)
    val hasAtLeastOneVehicle = hasCar || hasBike

    println("Tiene un coche y una moto: $hasBothVehicles")
    println("Tiene un coche o una moto: $hasAtLeastOneVehicle")

    /* 4. Asignación
    * =, +=, -=, *=, /= %=
    * */
    var assignmentNumber = 1.0

    assignmentNumber = 4.0
    assignmentNumber += 10 // === assignment = assignment + 10
    assignmentNumber -= 1 // === assignment = assignment - 1
    assignmentNumber *= 2 // === assignment = assignment * 2
    assignmentNumber /= 2 // === assignment = assignment * 2
    assignmentNumber %= 3

    println(assignmentNumber)
}