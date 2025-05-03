package io.github.lukazezdev.viewbetsapp.domain

data class Bet(
    val type: BetType,
    val sellIn: Int,
    val odds: Int,
    val imageUrl: String
)
