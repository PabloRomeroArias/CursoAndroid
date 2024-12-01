package com.devepoler.cursoandroid.android.ui.home

import android.icu.util.Calendar
import androidx.lifecycle.ViewModel
import com.google.android.material.datepicker.CalendarConstraints

class HomeViewModel : ViewModel() {
    fun getBounds() : CalendarConstraints {
        return CalendarConstraints.Builder()
            .setStart(getStart())
            .setEnd(getEnd())
            .build()
    }

    private fun getStart() : Long {
        return Calendar.getInstance().apply {
            set(2023, 0, 1)
        }.timeInMillis
    }

    private fun getEnd() : Long {
        return Calendar.getInstance().apply {
            set(2025, 11, 31)
        }.timeInMillis
    }
}