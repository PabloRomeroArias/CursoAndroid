package com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms

import com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms.color.Color

// Las clases se heredan
// Las interfaces se implementan
class Bike(
    override val wheels: Int = 2,
    override var color: Color = Color.Yellow("c6d40d")
) : Vehicle {
    override fun fillWheels() {
        TODO("Not yet implemented")
    }

    override fun paint(color: Color) {
        println("La bici ha pasado de ${this.color} a $color")
        this.color = color
    }

    override fun foo() {
        println("Estamos en la clase Bike. En el método sobreescrito foo")
    }
}