package com.devepoler.cursoandroid.android.core.util

import android.icu.util.Calendar
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateUtil {
    companion object {
        const val DD_MM_YYYY = "dd/MM/yyyy"
        const val HH_MM = "HH:mm"
        const val HH_MM_DD_MM_YYYY = "$HH_MM $DD_MM_YYYY"


        fun parseDateToString(
            date : Date,
            format : String = HH_MM_DD_MM_YYYY
        ) : String {
            val dateFormat = SimpleDateFormat(format, Locale.getDefault())
            return dateFormat.format(date)
        }

        fun parseLongToString(
            millis : Long,
            format : String = HH_MM_DD_MM_YYYY
        ) = parseDateToString(Date(millis), format)

        fun parseHourMinToString(
            hour : Int,
            minutes : Int,
            format: String = HH_MM
        ) : String {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minutes)

            return parseDateToString(calendar.time, format)
        }
    }
}