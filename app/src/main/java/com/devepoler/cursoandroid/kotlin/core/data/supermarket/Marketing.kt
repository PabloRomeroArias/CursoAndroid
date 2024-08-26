package com.devepoler.cursoandroid.kotlin.core.data.supermarket

class Marketing(
    val socialMedia : String = "Youtube",
    override val salary: Float = 2500f,
    name : String
) : Worker(name = name) {

    override fun work() {
        TODO("Not yet implemented")
    }

    override fun toString() = "Marketing${super.toString()}"
}