package com.devepoler.cursoandroid.kotlin.extraexercises

import com.devepoler.cursoandroid.kotlin.core.data.SortedList
import com.devepoler.cursoandroid.kotlin.core.util.extension.isPalindrome
import kotlin.random.Random

fun main() {
    exercise4()
}
/*
* Cree un algoritmo que reciba una lista con palabras
* Devuelve una lista con las palabras palíndromas
* rallar, eje, reconocer, rajar, salas
*/
fun exercise4() {
    val wordList = listOf("rallar", "reconocer", "eje", "DevePoler", "salas")
    val palindromeList = getPalindromeWordList(wordList)

    println("Lista de palíndromas: $palindromeList")
}

fun getPalindromeWordList(wordList : List<String>) : List<String> {
    val palindromeList = mutableListOf<String>()

    for(word in wordList) {
        if (word.isPalindrome())
            palindromeList.add(word)

    }

    return palindromeList
}



/*
* Cree un algoritmo que genere una lista de 20 números aleatorios
* que no contenga duplicados
* */
fun exercise3() {
    val randomUniqueIntList = getRandomUniqueIntList()
    println("Lista sin duplicados: $randomUniqueIntList")

}

fun getRandomUniqueIntList() : List<Int> {
    val intList = mutableListOf<Int>()
    var attemps = 0

    while (intList.size != 20) {
        val random = Random.nextInt(1, 101)
        var found = false

        for (number in intList) {
            if (number == random) {
                found = true
                break
            }
        }

        if (!found)
            intList.add(random)

        attemps++
    }
    println("Intentos necesarios para completar la lista sin duplicados: $attemps")
    return intList
}

/*
* Cree una función que reciba una lista y devuelva si se encuentra ordenada
* ascendente, descendente o no se encuentra ordenada */
fun exercise2() {
    val sortedList = isListSortedOrNot(listOf(5, 2, 1, 0, 1))

    println(sortedList)
}

fun isListSortedOrNot(intList : List<Int>) : SortedList {
    var isSortedDescending = true
    var isSortedAscending = true

    for (i in 0..<intList.lastIndex) {
        if (intList[i] < intList[i + 1])
            isSortedDescending = false

        if (intList[i] > intList[i + 1])
            isSortedAscending = false

    }

    return when {
        !isSortedAscending && !isSortedDescending -> SortedList.NotSorted
        isSortedAscending -> SortedList.Ascending
        else -> SortedList.Descending
    }
}

/*
 * Implementa un algoritmo que calcule la puntuación media de la valoración de
 * 10 jueces, eliminando los valores mínimo y máximo
 * Las puntuaciones van de 0 a 10
*/
fun exercise1() {
    val judgesScoreList = listOf(1f, 2f, 3f, 4f, 10f, 5f, 6f, 7f, 8f, 9f)
    val scoreListReadyToAverage = removeMinAndMaxValueFromList(judgesScoreList)
    val average = calculateAverageFromFloatList(scoreListReadyToAverage)

    println("La media es:$average ($scoreListReadyToAverage)")
}

fun removeMinAndMaxValueFromList(scoreList : List<Float>) : List<Float> {
    val finalList = mutableListOf<Float>()

    var maxValue = -1f
    var minValue = 11f

    for(score in scoreList) {
        if (score < minValue)
            minValue = score

        if (score > maxValue)
            maxValue = score
    }

    for (score in scoreList) {
        if (score != minValue && score != maxValue)
            finalList.add(score)
    }

    return finalList
}

fun calculateAverageFromFloatList(scoreList : List<Float>) : Float {
    var counter = 0
    var sum = 0f

    for (score in scoreList) {
        counter ++
        sum += score
    }

    return sum / counter
}
