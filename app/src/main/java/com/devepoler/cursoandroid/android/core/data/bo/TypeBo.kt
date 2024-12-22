package com.devepoler.cursoandroid.android.core.data.bo

sealed interface TypeBo {
    data object Game : TypeBo
    data object DLC : TypeBo
    data object EarlyAccess : TypeBo
    data object Other : TypeBo
}