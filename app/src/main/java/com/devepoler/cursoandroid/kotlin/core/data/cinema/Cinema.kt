package com.devepoler.cursoandroid.kotlin.core.data.cinema

class Cinema(
    private val name : String,
    private val roomList : List<Room> = emptyList(),
) {
    override fun toString() = name
}