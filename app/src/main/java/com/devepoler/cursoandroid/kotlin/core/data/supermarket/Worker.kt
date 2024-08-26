package com.devepoler.cursoandroid.kotlin.core.data.supermarket

abstract class Worker(
    name : String
) : Person(name = name) {
    abstract val salary : Float
    abstract fun work()

    override fun toString() = " - ${super.toString()}"
}