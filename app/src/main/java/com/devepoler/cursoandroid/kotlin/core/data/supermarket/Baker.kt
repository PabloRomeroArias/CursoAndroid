package com.devepoler.cursoandroid.kotlin.core.data.supermarket

class Baker(
    val degree : Float = 40f,
    override val salary: Float = 1500f,
    name : String,
) : Worker(name = name) {
    override fun work() {
        TODO("Not yet implemented")
    }

    override fun toString() = "Baker${super.toString()}"
}