package com.devepoler.cursoandroid.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.devepoler.cursoandroid.R
import com.devepoler.cursoandroid.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private val binding by lazy { FragmentFirstBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.setOnClickListener {
            navToSecondFragment()
        }
    }

    private fun navToSecondFragment() {
        val direction = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
        findNavController().navigate(direction)
    }
}