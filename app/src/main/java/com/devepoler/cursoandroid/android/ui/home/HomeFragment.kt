package com.devepoler.cursoandroid.android.ui.home

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.util.forEach
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.devepoler.cursoandroid.R
import com.devepoler.cursoandroid.android.ui.util.DialogUtil
import com.devepoler.cursoandroid.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val args : HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvName.text = getString(R.string.home_welcome, args.name ?: "Invitado",)

            root.setOnClickListener { showDialog() }
        }

        showDialog()
    }

    private fun showDialog() { showMultipleChoiceDialog() }

    private fun showSimpleDialog() {
        DialogUtil.showSimpleMaterialDialog(
            requireContext(),
            R.string.home_dialog_title,
            R.string.home_dialog_message,
            onClick = { _, which ->
                val message = when (which) {
                    DialogInterface.BUTTON_POSITIVE -> "positivo"
                    DialogInterface.BUTTON_NEGATIVE -> "negativo"
                    DialogInterface.BUTTON_NEUTRAL -> "neutral"
                    else -> "desconocido"
                }
                Toast.makeText(context, "Pulsado $message", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun showSingleChoiceDialog() {
        DialogUtil.showSingleChoiceDialog(
            requireContext(),
            onClick = { dialog, _ ->
                val listView = (dialog as AlertDialog).listView

                val fruit = listView.adapter.getItem(listView.checkedItemPosition) as String

                Toast.makeText(requireContext(), fruit, Toast.LENGTH_SHORT).show()
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
                Toast.makeText(requireContext(), favouriteFruitList.toString(), Toast.LENGTH_SHORT).show()
            }
        )
    }
}