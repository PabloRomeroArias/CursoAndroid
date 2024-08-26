package com.devepoler.cursoandroid.kotlin.core.data.supermarket

open class Butcher(
    val knifeNumber : Int = 1,
    override val salary: Float = 2000f,
    name :  String
) : Worker(name = name) {

    override fun work() {
        TODO("Not yet implemented")
    }
    override fun toString() = "Butcher${super.toString()}"
}