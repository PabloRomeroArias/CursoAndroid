package com.devepoler.cursoandroid.android.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devepoler.cursoandroid.android.core.data.bo.GameBo
import com.devepoler.cursoandroid.databinding.ItemGameBinding

class GameAdapter(
    private val gameList : List<GameBo>
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun getItemCount() = gameList.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.render(gameList[position])
    }

    inner class GameViewHolder(
        private val binding : ItemGameBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun render(game : GameBo) {
            with(binding) {
                tvTitle.text = game.title
                tvWorth.text = game.worth
                tvUsers.text = game.users.toString()
                tvPlatforms.text = game.platforms.joinToString()
                tvType.text = game.type.toString()
            }
        }
    }
}