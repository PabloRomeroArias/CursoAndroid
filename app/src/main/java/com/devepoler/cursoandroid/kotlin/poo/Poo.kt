package com.devepoler.cursoandroid.kotlin.poo

import com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms.Bike
import com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms.Motorbike
import com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms.color.Color
import com.devepoler.cursoandroid.kotlin.core.data.supermarket.Baker
import com.devepoler.cursoandroid.kotlin.core.data.supermarket.Butcher
import com.devepoler.cursoandroid.kotlin.core.data.supermarket.Customer
import com.devepoler.cursoandroid.kotlin.core.data.supermarket.Marketing
import com.devepoler.cursoandroid.kotlin.core.data.supermarket.Person
import com.devepoler.cursoandroid.kotlin.core.data.supermarket.Worker

// Sealed interface y sealed class
fun main() {
    sealedInterface()
}

fun sealedInterface() {
    val bikeList = listOf(
        Bike(4, Color.White()),
        Bike(4, Color.Blue()),
        Bike(4, Color.Black()),
        Bike(4, Color.Red()),
        Bike(4)
    )

    for (bike in bikeList)
        println("Color: ${bike.color} | hex: ${bike.color.hex}")
}

fun abstract() {
    val workerList = getPersonList().filterIsInstance<Worker>()

    for (worker in workerList) {
        println("$worker -> ${worker.salary}€ al mes")
    }
}

fun interfaces() {
    val bike = Bike()
    val motorbike = Motorbike()

    bike.paint(Color.Red())
    motorbike.paint(Color.Yellow("c6d40d"))
    bike.foo()
    motorbike.foo()
}

// Inheritance
// Polymorphism
fun inheritance() {

    val personList = getPersonList()

    for(person in personList) {
        when(person) {
            is Customer -> {
                person.money
            }

            is Baker -> {
                person.degree
                person.salary
                person.work()
            }

            is Butcher -> {
                person.knifeNumber
                person.salary
                person.work()
            }

            is Marketing -> {
                person.socialMedia
                person.work()
            }

            is Worker -> {
                print("No has casteado todos los trabajadores")
                person.work()
            }
        }
    }
}

fun getPersonList():  List<Person> {
    return listOf(
        Customer(name = "Pablo"),
        Baker(name = "García"),
        Butcher(name = "Lola"),
        Marketing(name = "Alberto")
    )
}

fun interestingMethods() {
    val numberList = mutableListOf(1, 5, 4, 2, 6)
    println(numberList)
    numberList.add(9)

    // val person = Person("Pablo", 26, "Españita")
    // println("Llamada a toString: $person")
    // print("Mensaje final: $person")
    // val person2 = Person("Perico", 30, "Bolivia")

    // person2.greetPerson(person)

    // person.dialogue(person2)

    // val person3 = Person(age = -45)
    // val person4 = Person("Isabel")

    // person4.dialogue(person3)

    // person.work()
    // person3.work()
}

// Le damos vida a la clase (esqueleto)
fun constructors() {
    // val person = Person("Pepito")
    // val person2 = Person(country = "Italia")
    // val person3 = Person(country = "Rumania", age = 25)

    //println(person)
    // println(person2)
    // println(person3)
}

fun introduction() {
    val number = 5 // Instanciamos/Creamos un objeto de tipo entero
    val string = "Hola mundo de la POO" // Instanciamos/Creamos un objeto de tipo string
    string.length // atributo de string

    // val person = Person("Pablo", 26, "Españita") // Llamamos a la función constructor

    /*
    println(person.name) // atributo de la clase persona
    println(person.age)
    println(person.country)

    person.work()

     */
}