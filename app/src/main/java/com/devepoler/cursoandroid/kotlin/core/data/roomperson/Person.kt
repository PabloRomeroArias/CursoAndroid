package com.devepoler.cursoandroid.kotlin.core.data.roomperson

class Person(
    val name : String,
) {

    fun greet(other : Person) {
        println("Hola ${other.name}, soy $name")
    }
    override fun toString() = name
}