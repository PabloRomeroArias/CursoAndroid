package com.devepoler.cursoandroid.android.core.data.provider

import com.devepoler.cursoandroid.android.core.data.bo.GameBo
import com.devepoler.cursoandroid.android.core.data.bo.TypeBo

class GameProvider {
    companion object {
        private val games = listOf(
            GameBo(
                "Game 1",
                "$7.99",
                "Game 1 description",
                listOf("PC", "XBox"),
                TypeBo.Game,
                200
            ),
            GameBo(
                "DLC 1",
                "$3.90",
                "DLC 1 description",
                listOf("Steam"),
                TypeBo.DLC,
                1500
            ),
            GameBo(
                "Coming soon 1",
                "$24.95",
                "Coming soon 1 description",
                listOf("Epic game store"),
                TypeBo.EarlyAccess,
                1500
            ),
            GameBo(
                "Other 1",
                "$75",
                "Other 1 description",
                listOf("Playstation 4", "Nintendo Switch"),
                TypeBo.Other,
                73
            ),
            GameBo(
                "Game 2",
                "$17.99",
                "Game 2 description",
                listOf("PC"),
                TypeBo.Game,
                200
            ),
            GameBo(
                "Game 3",
                "$12",
                "Game 3 description",
                listOf("Playstation 5"),
                TypeBo.Game,
                200
            )
        )

        fun getFreeGames(): List<GameBo> {
            return games
        }
    }

}