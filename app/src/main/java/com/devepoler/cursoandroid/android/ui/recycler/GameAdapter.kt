package com.devepoler.cursoandroid.android.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devepoler.cursoandroid.R
import com.devepoler.cursoandroid.android.core.data.bo.GameBo
import com.devepoler.cursoandroid.databinding.ItemGameBinding

class GameAdapter(private val gameList : List<GameBo>)
    : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.render(gameList[position])
    }

    override fun getItemCount() = gameList.size

    inner class GameViewHolder(private val binding : ItemGameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun render(game : GameBo) {
            with(binding) {
                tvTitle.text = game.title
                tvWorth.text = game.worth
                tvPlatforms.text = root.context.getString(R.string.item_game_platforms, game.platforms.joinToString())
            }
        }
    }
}