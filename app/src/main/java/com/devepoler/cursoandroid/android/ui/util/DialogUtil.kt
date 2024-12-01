package com.devepoler.cursoandroid.android.ui.util

import android.content.Context
import android.content.DialogInterface
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager
import com.devepoler.cursoandroid.R
import com.devepoler.cursoandroid.android.ui.extension.toast
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.timepicker.MaterialTimePicker

class DialogUtil {
    companion object {
        fun showSimpleMaterialDialog(
            context : Context,
            @StringRes resTitle : Int,
            @StringRes resMessage : Int,
            @StringRes resPositive : Int = R.string.accept,
            @StringRes resNegative : Int = R.string.cancel,
            @StringRes resNeutral : Int = R.string.back,
            onClick : (dialog : DialogInterface, which : Int) -> Unit,
        ) {
            MaterialAlertDialogBuilder(context)
                .setTitle(resTitle)
                .setMessage(resMessage)
                .setPositiveButton(resPositive, onClick)
                .setNegativeButton(resNegative, onClick)
                .setNeutralButton(resNeutral, onClick)
                .show() // .build()
        }

        fun showSingleChoiceDialog(
            context: Context,
            @StringRes resTitle : Int = R.string.fruit_title,
            @StringRes resPositive : Int = R.string.confirm,
            @ArrayRes resItems : Int = R.array.fruits,
            selectedItem : Int = -1,
            onClick : (dialog : DialogInterface, which : Int) -> Unit,
        ) {
            MaterialAlertDialogBuilder(context)
                .setTitle(resTitle)
                .setSingleChoiceItems(resItems, selectedItem) { _, _ ->
                    context.toast("Fruta pulsada")
                }
                .setPositiveButton(resPositive, onClick)
                .show()
        }

        fun showMultipleChoiceDialog(
            context: Context,
            @StringRes resTitle : Int = R.string.fruits_title,
            @StringRes resPositive : Int = R.string.confirm,
            @ArrayRes resItems : Int = R.array.fruits,
            onClick : (dialog : DialogInterface, which : Int) -> Unit,
        ) {
            MaterialAlertDialogBuilder(context)
                .setTitle(resTitle)
                .setMultiChoiceItems(resItems, null, null)
                .setPositiveButton(resPositive, onClick)
                .show()
        }

        fun showTimePickerDialog(
            manager : FragmentManager,
            @StringRes restTitle : Int,
            hour : Int,
            min : Int,
            timeFormat : Int,
            onPositive : (hour : Int, minutes : Int) -> Unit
        ) {
            val picker =
                MaterialTimePicker.Builder()
                    .setTimeFormat(timeFormat)
                    .setHour(hour)
                    .setMinute(min)
                    .setTitleText(restTitle)
                    .build()

            picker.addOnPositiveButtonClickListener {
                onPositive(picker.hour, picker.minute)
            }

            picker.show(manager, null)
        }

        fun showDatePickerDialog(
            manager : FragmentManager,
            @StringRes restTitle : Int,
            bounds : CalendarConstraints
        ) {
            val picker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText(restTitle)
                    .setCalendarConstraints(bounds)
                    .build()

            picker.show(manager, null)
        }
    }
}