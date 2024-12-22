package com.devepoler.cursoandroid.android.ui.coroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devepoler.cursoandroid.databinding.FragmentCoroutinesBinding

class CoroutinesFragment : Fragment() {
    private val binding by lazy { FragmentCoroutinesBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root
}