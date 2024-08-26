package com.devepoler.cursoandroid.kotlin.collectionsloops

 /*
 1. Colecciones
 2. Bucles
    2.1 While / do while
    2.2 For
 3. Break and Continue
 4. HashMap (o diccionarios)
  */
fun main() {
    //collections()
    // loops()
    hashMapFunction()
}

// Colecciones
fun collections() {
    val mCollection = listOf<Int>(1, 6, 6)

    println("Mi primera colección: $mCollection")

    // Strings (cadena de caracteres)
    // List y MutableList
    // Array y ArrayList

    /* CRUD Create Read Update Delete
     String  SI     SI  SI      SI
     */

    var mString = "String super creativo. "
    var message = ""
    // Create
    mString += "Otro string" // += es lo mismo que string = string + "Otro string"

    // Read
    // SUPER IMPORTANTE: El primer índice es el 0
    // El último índice es N - 1 (siendo N la longitud del string)
    val mChar = mString[0]

    val lastIndex = mString.lastIndex // mString.length - 1
    val mLastChar = mString[lastIndex] // == mString.get(lastIndex)

    message += "\nRead con String (primer caracter): $mChar"
    message += "\nRead con String (último caracter): $mLastChar"

    // Update Delete NO SE PUEDEN EN STRINGS

    message += "\nCreate con String: $mString"

    // List colecciones inmutables (Similar a Array)
    val mList = listOf<Int>(1, 2, 4)

    // Create Update Delete NO SE PUEDEN
    // Read
    val mItem = mList[2]
    message += "\nRead list second item: $mItem"

    // MutableList (Similar a ArrayList)
    val mMutableList = mutableListOf<String>("First item", "Second item", "Hi world!")

    // Create
    mMutableList.add("New element")
    mMutableList.add(0, "Item in index")

    // Read
    val mMutableListLastItem = mMutableList[mMutableList.lastIndex]

    message += "\nMutable list: $mMutableList"

    // Update
    mMutableList[0] = "New updated item"

    message += "\nMutable list updated: $mMutableList"

    // Delete
    mMutableList.removeAt(0)
    var anyDeletedItem = mMutableList.remove("Hola buenos días")
    anyDeletedItem = mMutableList.remove("Hi world!")

    message += "\nMutable list after delete: $mMutableList"
    message += "\nElemento borrado? $anyDeletedItem"
    message += "\nMutable list last item: $mMutableListLastItem"

    println(message)
}

fun loops() {
    // mWhile()
    // doWhile()
    // forLoop()
}
// Estos bucles se usan cuando no hay certeza de las veces que se va a iterar
fun mWhile() {
    var phoneNumber = ""
    // Actualizar en todas las iteraciones la condición
    while (phoneNumber.length != 9) {
        print("Introduce un número de teléfono (9 números): ")
        phoneNumber = readln()
    }
}
// While puede NO ejecutarse el bloque de código según el statement
// do While se ejectuta, al menos, 1 iteración del bloque de código
fun doWhile() {
    var phoneNumber: String
    // Actualizar en todas las iteraciones la condición
    do {
        print("Introduce un número de teléfono (9 números): ")
        phoneNumber = readln()
    } while ((phoneNumber.length != 9))
}
// Se sabe el número de veces que se va a iterar
fun forLoop() {
    val mString = "String a recorrer"

    for (char in mString) {
        println("Elemento: $char")
    }

    val fruitList = listOf<String>("Melon", "Watermelon", "Lemon", "Banana")

    println("Mi lista de frutas:")

    for (fruit in fruitList) {
        println("Fruta: $fruit")
    }

    println("Loop with range")
    // Range
    for (number in 1..10) {
        println(number)
    }

    println("Loop with break")
    // break and continue
    for (number in 1..5) {
        if (number == 4) {
            break // Sale del loop
        }
        println(number)
    }

    println("Loop with continue")

    for (number in 1..5) {
        if (number == 4) {
            continue // Salta a la siguiente iteración
        }
        println(number)
    }

    println("Range with characters (ASCII)")

    // Código ASCII
    for (char in  '['..'e'){
        println(char)
    }
}

fun hashMapFunction() {
    // colección de pares de elementos Clave - Valor
    // también conocidos como diccionarios
    val nameAgeHashMap = hashMapOf<String, Int>(
        "Pablo" to 27,
        "Pepe" to 40,
        "Andrea" to 34,
    )
    // CRUD
    // create
    nameAgeHashMap["Fulanito"] = 19

    // read
    val key = "Pepe"
    var age = nameAgeHashMap[key]
    println("Edad de $key: $age")

    // update
    nameAgeHashMap[key] = 41
    age = nameAgeHashMap[key]

    println("Edad de $key después de su cumpleaños: $age")

    println("Mi primer hashmap: $nameAgeHashMap")

    // delete
    age = nameAgeHashMap.remove("Fulanito")
    val isRemoved = nameAgeHashMap.remove("Pablo", 27)

    println("Mi hasmap después de borrar: $nameAgeHashMap")
    println("La edad del nombre borrado: $age")
    println("Ha sido borrado el elemento? $isRemoved")

    // Loop hashmap
    // for (key in hashMap.keys) {}
    // for (value in hashMap.values) {}
    // for ((key, value) in hashMap) {}
    for ((name, loopAge) in nameAgeHashMap) {
        println("Name: $name. Age: $loopAge")
    }
}