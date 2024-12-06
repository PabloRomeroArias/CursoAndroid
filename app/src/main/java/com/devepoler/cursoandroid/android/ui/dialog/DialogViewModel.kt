package com.devepoler.cursoandroid.android.ui.dialog

import android.icu.util.Calendar
import androidx.lifecycle.ViewModel
import com.google.android.material.datepicker.CalendarConstraints

class DialogViewModel : ViewModel() {
    fun getBounds() : CalendarConstraints {
        return CalendarConstraints.Builder()
            .setStart(getStart())
            .setEnd(getEnd())
            .build()
    }

    private fun getStart() : Long {
        return Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, -7)
        }.timeInMillis
    }

    private fun getEnd() : Long {
        return Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, 7)
        }.timeInMillis
    }
}
