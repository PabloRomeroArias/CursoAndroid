package com.devepoler.cursoandroid.android.ui.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.util.forEach
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.devepoler.cursoandroid.R
import com.devepoler.cursoandroid.android.core.extension.toast
import com.devepoler.cursoandroid.android.core.util.DateUtil
import com.devepoler.cursoandroid.android.core.util.DialogUtil
import com.devepoler.cursoandroid.databinding.FragmentDialogBinding
import com.google.android.material.timepicker.TimeFormat

class DialogFragment : Fragment() {
    private val binding by lazy { FragmentDialogBinding.inflate(layoutInflater) }
    private val viewModel : DialogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btSimpleDialog.setOnClickListener { showSimpleDialog() }
            btSingleChoiceDialog.setOnClickListener { showSingleChoiceDialog() }
            btMultipleChoiceDialog.setOnClickListener { showMultipleChoiceDialog() }
            btTimePicker.setOnClickListener { showTimePicker() }
            btDatePicker.setOnClickListener { showDatePicker() }
        }
    }

    private fun showSimpleDialog() {
        DialogUtil.showSimpleMaterialDialog(
            requireContext(),
            R.string.dialog_title,
            R.string.dialog_message,
            onClick = { _, which ->
                val message = when (which) {
                    DialogInterface.BUTTON_POSITIVE -> "positivo"
                    DialogInterface.BUTTON_NEGATIVE -> "negativo"
                    DialogInterface.BUTTON_NEUTRAL -> "neutral"
                    else -> "desconocido"
                }
                requireContext().toast("Pulsado $message")
            }
        )
    }

    private fun showSingleChoiceDialog() {
        DialogUtil.showSingleChoiceDialog(
            requireContext(),
            onClick = { dialog, _ ->
                val listView = (dialog as AlertDialog).listView

                val fruit = listView.adapter.getItem(listView.checkedItemPosition) as String

                requireContext().toast(fruit)
            }
        )
    }

    private fun showMultipleChoiceDialog() {
        val fruitList = resources.getStringArray(R.array.fruits)

        DialogUtil.showMultipleChoiceDialog(
            requireContext(),
            onClick = { dialog, _ ->
                val checkedItemPositions = (dialog as AlertDialog).listView.checkedItemPositions
                val favouriteFruitList = mutableListOf<String>()
                checkedItemPositions.forEach { key, _ ->
                    favouriteFruitList.add(fruitList[key])
                }
                requireContext().toast(favouriteFruitList.toString())
            }
        )
    }

    private fun showTimePicker() {
        DialogUtil.showTimePickerDialog(
            childFragmentManager,
            R.string.time_picker_title,
            22,
            30,
            TimeFormat.CLOCK_24H
        ) { h, m ->

            val timeString = DateUtil.parseHourMinToString(h, m)

            requireContext().toast(R.string.selected_time, timeString)
        }
    }

    private fun showDatePicker() {
        DialogUtil.showDatePickerDialog(
            childFragmentManager,
            R.string.date_picker_title,
            viewModel.getBounds(),
        ) { millis ->
            val dateString = DateUtil.parseLongToString(
                millis,
                DateUtil.DD_MM_YYYY
            )
            requireContext().toast(R.string.selected_date, dateString)
        }
    }
}