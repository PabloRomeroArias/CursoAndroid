package com.devepoler.cursoandroid.kotlin.ifelsewhen

import kotlin.math.pow

/*
* If
* If-else
* nested if
* when
* */
fun main() {
    // if: bloque de código que se ejecuta si y solo si se cumple un statement, es decir,
    // al evaluarse dicho statment, éste es true
    if (true) {
        println("Dentro de nuestro primerito IF")
    }

    var age = 29

    if (age >= 18) {
        println("Eres mayor de edad")
    }

    age = 15

    // if-else
    if (age >= 18) {
        println("Eres mayor de edad")
    } else { // si no se ejectuta el if, se ejecuta el else
        println("Lo siento, no puedes entrar en las discotecas")
    }

    val hasCar = false
    val hasMotorbike = true

    if (hasCar && hasMotorbike) {
        println("tienes ambos")
    } else {
        println("No tiene un coche O no tiene una moto")
    }

    // nested if (else)
    if (hasCar && hasMotorbike) {
        println("tienes ambos")
    } else {
        if (!hasCar) { // no tiene un coche
            println("El vehículo que le faltaba era el coche")
        } else { // tiene un coche
            println("El vehículo que le faltaba era la moto")
        }
    }

    if (hasCar && hasMotorbike) {
        println("tienes ambos")
    } else {
        if (!hasCar && !hasMotorbike) { // no tiene ningún vehículo
            println("No tiene ningún vehículo")
        } else { // al menos, tiene un vehículo
            if (hasCar) { // no tiene un coche
                println("El vehículo que le faltaba era la moto")
            } else { // tiene un coche
                println("El vehículo que le faltaba era el coche")
            }
        }
    }

    // when
    when {
        hasCar && hasMotorbike -> { // if
            println("Tiene un coche y una moto (when)")
        }
        !hasMotorbike && hasCar -> { // else
            println("Tiene un coche pero no tiene moto (when)")
        }
        hasMotorbike -> { // else
            println("Tiene una moto pero no tiene coche (when)")
        }

        else -> { // else
            println("No tiene ningún vehículo (when)")
        }
    }

    val firstNumber = 1
    val secondNumber = 7.0
    print("Introduce operador: ")
    val operator = readln()

    when (operator) {
        "+" -> {
            println("$firstNumber + $secondNumber = ${firstNumber + secondNumber}")
        }
        "-" -> {
            println("$firstNumber - $secondNumber = ${firstNumber - secondNumber}")
        }
        "*" -> {
            println("$firstNumber x $secondNumber = ${firstNumber * secondNumber}")
        }
        "/" -> {
            println("$firstNumber / $secondNumber = ${firstNumber / secondNumber}")
        }
        "%" -> {
            println("$firstNumber % $secondNumber = ${firstNumber % secondNumber}")
        }
        "**" -> {
            println("$secondNumber ** $secondNumber = ${secondNumber.pow(secondNumber)}")
        }
        else -> {
            println("Operador \"$operator\" no válido")
        }
    }
}