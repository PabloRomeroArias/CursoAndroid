package com.devepoler.cursoandroid.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devepoler.cursoandroid.android.core.data.bo.UserBo

class MainViewModel : ViewModel() {
    private val userLiveData = MutableLiveData<UserBo?>()

    fun getUserLiveData() : LiveData<UserBo?> = userLiveData

    fun setUser(user: UserBo? = null) {
        userLiveData.value = user
    }
}