package com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms

import com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms.color.Color


class Motorbike(
    override val wheels: Int = 3,
    override var color: Color = Color.Black()
) : Vehicle {
    override fun fillWheels() {
        TODO("Not yet implemented")
    }

    override fun paint(color: Color) {
        println("La moto ha pasado de ${this.color} a $color")
        this.color = color
    }

    override fun foo() {
        println("Estamos en la clase moto. En el método foo")
    }
}