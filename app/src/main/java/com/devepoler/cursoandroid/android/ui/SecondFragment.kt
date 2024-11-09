package com.devepoler.cursoandroid.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.devepoler.cursoandroid.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private val binding by lazy { FragmentSecondBinding.inflate(layoutInflater) }
    private val args : SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvName.text = args.name
    }

}