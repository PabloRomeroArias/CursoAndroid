package com.devepoler.cursoandroid.kotlin.core.data.lossantoscustoms.color

sealed class Color(val hex : String) {
    class Red(hex: String = "FF0000") : Color(hex)
    data class Blue(val isFavourite : Boolean = true, val hex2 : String = "0000FF") : Color(hex2)
    class Yellow(hex : String) : Color(hex)
    class Black(hex : String = "000000") : Color(hex)
    class White(hex : String = "FFFFFF") : Color(hex)
    class Purple(hex : String) : Color(hex)
    class Green(hex : String = "00FF00") : Color(hex)
}