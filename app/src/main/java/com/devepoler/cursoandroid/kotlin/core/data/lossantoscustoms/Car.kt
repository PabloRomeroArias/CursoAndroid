package com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms

import com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms.color.Color

class Car(
    override val wheels: Int,
    override var color: Color
) : Vehicle {
    override fun fillWheels() {
        TODO("Not yet implemented")
    }

    override fun paint(color: Color) {
        TODO("Not yet implemented")
    }
}