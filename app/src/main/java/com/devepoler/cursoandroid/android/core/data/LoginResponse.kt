package com.devepoler.cursoandroid.android.core.data

import com.devepoler.cursoandroid.android.core.data.bo.UserBo

sealed interface LoginResponse {
    data class Success(val user: UserBo) : LoginResponse
    data class Error(val msg: String) : LoginResponse
}