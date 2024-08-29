package com.devepoler.cursoandroid.kotlin.extraexercises

import com.devepoler.cursoandroid.kotlin.core.data.roomperson.Person
import com.devepoler.cursoandroid.kotlin.core.data.roomperson.Room

/*
Cree una clase Habitación con los atributos nombre, capacidad y personas.
La habitación estará vacía y el programa la irá llenando de una o varias Personas a la vez,
si no caben las personas, el programa mostrará las personas que se han quedado fuera.
Las personas están sentadas en círculo.
La habitación permitirá que una persona salude a las dos que estén junto a ella,
*/

fun main() {
    val room = Room("Sala otaku", 3)

    val personList = getPersonList()

    val notFilled = room.fillRoomWithPersonList(personList)

    if (notFilled == null)
        println("Han cabido todas las personas en la habitación")
    else
        println("No han entrado: $notFilled")

    room.greetMate(personList[0], personList[2])
}

fun getPersonList() : List<Person> {
    return listOf(
        Person("Pablo"),
        Person("Isabel"),
        Person("Oscar"),
        Person("Manuel"),
    )
}