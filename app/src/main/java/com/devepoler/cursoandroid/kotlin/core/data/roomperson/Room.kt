package com.devepoler.cursoandroid.kotlin.core.data.roomperson

class Room(
    private val name : String,
    private val capacity : Int
) {
    private val personList = mutableListOf<Person>()

    private fun fillRoomWithPerson(person: Person) : Boolean {
        return if (personList.size >= capacity)
            false
        else {
            personList.add(person)
            true
        }
    }

    fun fillRoomWithPersonList(pList : List<Person>) : List<Person>? {
        for(i in pList.indices) {
            if (!fillRoomWithPerson(pList[i])) {
                val notFilledPersonList = mutableListOf<Person>()
                notFilledPersonList.addAll(pList.subList(i, pList.lastIndex + 1))
                return notFilledPersonList
            }
        }
        return null
    }

    fun greetMate(person : Person, target : Person) {
        var index = personList.indexOf(person)

        index = if (index < 0)
            personList.lastIndex
        else
            0
        // somos 5 personas
        // yo estoy en la última posición (4)
        // 5 % 5 == 0
        // 4 % 5 ==
        val nextPosition = (index + 1) % personList.size
        val previousPosition = (index - 1 + personList.size) % personList.size

        if (personList[nextPosition] == target
            || personList[previousPosition] == target)
            person.greet(target)
        else
            print("$person está demasiado lejos de $target para saludar")

    }

    override fun toString(): String {
        return personList.joinToString(
            separator = " - ",
            prefix = "$name ($capacity)"
        )
    }
}