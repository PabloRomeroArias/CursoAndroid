package com.devepoler.cursoandroid.android.ui.util

import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import com.devepoler.cursoandroid.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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
                    Toast.makeText(context, "Fruta pulsada", Toast.LENGTH_SHORT).show()
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
    }
}