package com.devepoler.cursoandroid.android.ui.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.toast(message : String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.toast(@StringRes resMsg : Int) {
    Toast.makeText(this, resMsg, Toast.LENGTH_SHORT).show()
}