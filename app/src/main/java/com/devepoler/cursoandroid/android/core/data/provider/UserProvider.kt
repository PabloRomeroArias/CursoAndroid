package com.devepoler.cursoandroid.android.core.data.provider

import com.devepoler.cursoandroid.android.core.data.LoginResponse
import com.devepoler.cursoandroid.android.core.data.bo.LoginFormBo
import com.devepoler.cursoandroid.android.core.data.bo.UserBo

class UserProvider {
    companion object {
        private val users = listOf(
            UserBo("Pablo", "pablo@gmail.com", "123"),
            UserBo("DevePoler", "devepoler@gmail.com", "111"),
        )

        fun doLogin(loginForm: LoginFormBo): LoginResponse {
            val user = users.find {
                it.email == loginForm.email
                        && it.password == loginForm.password

            }

            return if (user != null)
                LoginResponse.Success(user)
            else
                LoginResponse.Error("Login incorrecto")
        }
    }
}
