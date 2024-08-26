package com.devepoler.cursoandroid.kotlin.collectionsloops

fun main() {
    exercise5()
}

/*
* Ejercicio 5
* Cree un programa que pida un caracter por teclado.
* Pide palabras (al menos dos)
* Separa en una lista
* Separa en dos listas, si contiene o no el caracter inicial
* */
fun exercise5() {
    val character = getCharacterFromReadLn()
    val words = getAtLeastTwoWords()
    val wordList = getWordsAsList(words)
    printListContainingCharAndNot(character[0], wordList)
}

fun getCharacterFromReadLn(endMessage: String = "end"): String {
    var input : String

    do {
        print("Introduce un caracter (\"$endMessage\" para salir): ")
        input = readln()
    } while(lengthOfInput(input) != 1
        && input != endMessage
    )
    return input
}

fun getAtLeastTwoWords() : String {
    var words: String

    do {
        print("Introduce, al menos, dos palabras: ")
        words = readln()
    } while (numberOfWordsFromAnInput(words) < 2)
    return words
}

/**
 * Returns the number of words from a given input.
 * Split the input with space char as delimiter
 * Filter by elements which are not empty
 * Return size of filtered list
 * @param input given input
 * @return size of filtered not empty elements from splited by space list
 */
fun numberOfWordsFromAnInput(input: String) =
    input
        .split(" ")
        .filter { it.isNotEmpty() }
        .size

fun getWordsAsList(input: String) =
    input
        .split(" ")
        .filter { it.isNotEmpty() }

fun printListContainingCharAndNot(char: Char, wordList: List<String>) {
    val containingList = mutableListOf<String>()
    val notContainingList = mutableListOf<String>()

    for (word in wordList) {
        if (word.contains(char, ignoreCase = true))
            containingList.add(word)
        else
            notContainingList.add(word)
    }

    println("Lista que contiene el caracter $char: $containingList")
    println("Lista que no contiene el caracter $char: $notContainingList")
}

fun lengthOfInput(input: String): Int {
    var counter = 0

    for (char in input) {
        counter ++
    }
    return counter
}

/*
* Ejercicio 4
* Dada una lista de productos y su precio, obtenga el mayor de ellos */
fun exercise4() {
    val productHashMap = getProductHashMap()
    var maxName = ""
    var maxPrice = 0f

    for ((name, price) in productHashMap.entries) {
        if (maxPrice < price) {
            maxName = name
            maxPrice = price
        }
    }
    println("El producto $maxName es el que tiene el máximo valor: $maxPrice")
}
/*
* Ejercicio avanzado
* Pide por teclado una lista de personas. Cada persona tiene nombre y edad.
* Pide al usuario una de estas opciones:
* 1.- Imprimir Nº Personas con el nombre más largo y sus nombres
* 2.- Imprimir Persona más joven
* */
fun person() {
    // matrix o 2D
    val person = hashMapOf<String, Any>(
        "name" to "Pablo",
        "age" to 26
    )
}

fun getProductHashMap() = hashMapOf(
    "Moto" to 2_000f,
    "Coche" to 30_000f,
    "Smart Phone" to 1_000f,
    "Teclado" to 100f,
    "Avión" to 40_000_000f,
    "Kebab" to 4.5f,
)

/*
* Ejercicio 3
* Escriba un algoritmo que lea números hasta que el usuario introduzca end
* Luego, el usuario elegirá qué opción de las siguientes hacer:
* 1.- suma total
* 2.- cantidad de números
* 3.- media
* */
fun exercise3() {
    val numberList = getNumbersFromReadLn()
    executeOperation(numberList)
}

fun getNumbersFromReadLn() : List<Int> {
    val numberList = mutableListOf<Int>()

    do {
        val number = getNumberFromReadLnOrNullIfMessage()

        if (number != null) {
            numberList.add(number)
        }

    } while (number != null)

    return numberList
}

fun executeOperation(numberList: List<Int>) {
    val operation = chooseOperation()

    when(operation) {
        "1" -> println("Suma total de $numberList: ${totalAmount(numberList)}")
        "2" -> println("Números totales de $numberList: ${totalNumbers(numberList)}")
        "3" -> println("Media de $numberList: ${average(numberList)}")
        else -> println("Nos has hackeado mi bro. Relájate un poco")
    }
}

fun totalAmount(numberList: List<Int>) : Int {
    var totalAmount = 0

    for (number in numberList) {
        totalAmount += number
    }
    return totalAmount
}

fun totalNumbers(numberList: List<Int>) : Int {
    var counter = 0

    for (number in numberList) {
        counter++
    }
    return counter
}

fun average(numberList: List<Int>) = totalAmount(numberList).toFloat()/totalNumbers(numberList)

fun chooseOperation() : String {
    // 1 2 3
    var input: String
    do {
        print(getOperationMessage())
        input = readln()
    } while (input != "1"
        && input != "2"
        && input != "3"
    )
    return input
}

fun getOperationMessage() = """
    #### OPERACIONES ####
    1.- Suma
    2.- Números totales
    3.- Media
    Introduce operación: 
""".trimIndent()

/*
* Ejercicio 2
* Cree un programa que pida una cadena por teclado y la imprima sin vocales, sin consonantes
* y con las vocales en mayúsculas
* */
fun exercise2() {
    print("Introduce un string: ")
    val input = readln()
    // val inputWV = stringWithoutVowels(input)
    println("El input $input sin vocales: ${stringWithoutVowels(input)}")
    println("El input $input sin consonantes: ${stringWithoutConsonants(input)}")
    println("El input $input con vocales mayúsculas: ${upperVowels(input)}")

}

/**
 * Return a given string without vowels
 * @param input the given string
 * @return input without vowels
 */
fun stringWithoutVowels(input : String) : String {
    var stringWithoutVowels = ""

    for (character in input) {
        // NO SE USA .replace("a", "")
        if (!getVowels().contains(character, ignoreCase = true)) { // Comprobamos que no sea vocal
            stringWithoutVowels += character
        }
    }
    return stringWithoutVowels
}

fun getVowels() = "aeiouàáâäæãåāèéêëęēìíîïĩīòóôöõøōùúûüũūýÿŷ"

fun stringWithoutConsonants(input : String) : String {
    var stringWithoutConsonants = ""

    for (character in input) {
        if (getVowels().contains(character, ignoreCase = true)) { // Comprobamos que no sea vocal
            stringWithoutConsonants += character
        }
    }
    return stringWithoutConsonants
}

fun upperVowels(input : String) : String {
    var stringWitUpperVowels = ""

    for (character in input) {
        if (getVowels().contains(character, ignoreCase = true)) { // Es una vocal
            stringWitUpperVowels += character.uppercase()
        } else {
            stringWitUpperVowels += character
        }
    }
    return stringWitUpperVowels
}

/*
* Ejercicio 1
* Crea una función que pida por teclado un entero y no pare hasta que el usuario
* introduzca un entero o introduzca una cadena vacía.
* La función tiene que devolver el número o nulo si no introduce nada
* */

/**
 * Read a number from readln() function and returns it. If input is empty, returns null
 */
fun exercise1() {
    // WHILE o DO_WHILE??
    // while (condicion) {} primero se evalua y luego ejecuta el bloque de codigo (puede llegar a no ejecutarse)
    // do {} while(condicion) primero ejecuta y luego evalua (se ejecuta, al menos, una vez)
    // Al leer por pantalla (readln) siempre usaremos do_while
    println("Número introducido: ${getNumberFromReadLnOrNullIfMessage("") ?: "-"}")
}

fun getNumberFromReadLnOrNullIfMessage(endMessage : String = "end") : Int? {
    var number : Int?

    do {
        print("Introduce un número (\"$endMessage\" para salir): ")
        val input = readln()
        number = input.toIntOrNull()
    } while(input != endMessage && number == null)
    // cadena no sea vacía y no sea un número
    return number
}
