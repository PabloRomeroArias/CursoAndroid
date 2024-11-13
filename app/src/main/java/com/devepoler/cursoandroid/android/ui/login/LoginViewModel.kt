package com.devepoler.cursoandroid.android.ui.login

import androidx.lifecycle.ViewModel
import com.devepoler.cursoandroid.android.data.bo.LoginFormBo
import com.devepoler.cursoandroid.android.data.provider.UserProvider

class LoginViewModel : ViewModel() {
    fun login(loginForm: LoginFormBo) = UserProvider.doLogin(loginForm)
}