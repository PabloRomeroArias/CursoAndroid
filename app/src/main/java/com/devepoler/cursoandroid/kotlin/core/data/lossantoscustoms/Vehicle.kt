package com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms

import com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms.color.Color

// Interface === Contract
interface Vehicle {
    val wheels : Int
    var color : Color

    fun fillWheels()
    fun paint(color : Color)
    fun foo() {
        println("Estamos en la interfaz vehículo. En el método foo")
    }
}