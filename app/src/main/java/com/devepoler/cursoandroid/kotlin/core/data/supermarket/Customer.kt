package com.devepoler.cursoandroid.kotlin.core.data.supermarket

class Customer(
    val money : Float = 0f,
    name : String
) : Person(name = name) {
    // SUPER para llamar a la clase padre
    // THIS es el objeto mismo en sí
    override fun toString() = "C - ${super.toString()}"
}