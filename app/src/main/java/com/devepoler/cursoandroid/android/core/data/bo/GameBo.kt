package com.devepoler.cursoandroid.android.core.data.bo

data class GameBo(
    val title : String,
    val worth : String,
    val description : String,
    val platforms : List<String>,
    val type : TypeBo,
    val users : Int,
)
