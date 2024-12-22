package com.devepoler.cursoandroid.android.ui.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.devepoler.cursoandroid.databinding.FragmentGameListBinding

class GameListFragment : Fragment() {
    private val binding by lazy { FragmentGameListBinding.inflate(layoutInflater) }
    private val viewModel : GameListViewModel by viewModels()

    private val gameList by lazy { viewModel.getGameList() }
    private val adapter by lazy { GameAdapter(gameList) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
    }

    private fun initRecycler() {
        binding.rvGame.adapter = this.adapter
    }
}