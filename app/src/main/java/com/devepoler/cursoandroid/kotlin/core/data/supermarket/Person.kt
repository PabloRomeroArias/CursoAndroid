package com.devepoler.cursoandroid.kotlin.core.data.supermarket

// Esqueleto
abstract class Person(
    var name : String = "Anonymous",
    var age : Int = 20,
    var country : String = "España",
) {
    // Un método es una función de una clase
    fun greetPerson(person : Person) {
        println("Hola ${person.name}, me llamo ${this.name}")
    }

    fun dialogue(person: Person) {
        val message = """
            #### DIÁLOGO SÚPER INTENSO entre ${this.name} y ${person.name} ####
            
            (${this.name}): Hola ${person.name}, ¿cómo estás?
            (${person.name}): Hola ${this.name}, muy bien, gracias por preguntar, ¿y tú?
            (${this.name}): Me alegro. Yo estoy súper content@ porque soy programador
        """.trimIndent()

        println(message)
    }

    override fun toString() = "$name: ($age años)"
}