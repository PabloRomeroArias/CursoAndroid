package com.devepoler.cursoandroid.android.ui.recycler

import androidx.lifecycle.ViewModel
import com.devepoler.cursoandroid.android.core.data.provider.GameProvider

class GameListViewModel : ViewModel() {
    fun getGameList() = GameProvider.getFreeGames()
}