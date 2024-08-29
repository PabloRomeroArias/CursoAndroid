package com.devepoler.cursoandroid.kotlin.core.util.extension

fun String.isPalindrome() : Boolean {
    var reversedString = ""

    for (i in this.lastIndex downTo 0) {
        reversedString += this[i]
    }
    return this == reversedString
}