package com.devepoler.cursoandroid.kotlin.core.data.cinema

import java.util.SortedMap

class Day(
    val dayOfWeek: DayOfWeek,
    val sessionHashMap : SortedMap<Room, Movie>
)