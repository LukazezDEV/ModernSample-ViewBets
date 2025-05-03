package io.github.lukazezdev.viewbetsapp.domain

import io.github.lukazezdev.viewbetsapp.domain.BetType.*

fun List<Bet>.calculateOdds(): List<Bet> = map { bet ->
    val updatedSellIn = bet.sellIn - if (bet.type == FIRST_GOAL_SCORER) 0 else 1

    val updatedOdds =
        when (bet.type) {
            TOTAL_SCORE, NUMBER_OF_FOULS -> {
                val baseOdds = if (bet.odds < 50) bet.odds + 1 else bet.odds
                if (bet.type == NUMBER_OF_FOULS) baseOdds + additionalFoulsOdds(bet.odds, bet.sellIn) else baseOdds
            }
            FIRST_GOAL_SCORER -> bet.odds
            else -> (bet.odds - 1).coerceAtLeast(0)
        }

    val finalOdds =
        if (updatedSellIn < 0)
            when (bet.type) {
                TOTAL_SCORE -> (updatedOdds + 1).coerceAtMost(50)
                NUMBER_OF_FOULS -> 0
                FIRST_GOAL_SCORER -> updatedOdds
                else -> (updatedOdds - 1).coerceAtLeast(0)
            }
        else
            updatedOdds

    bet.copy(odds = finalOdds, sellIn = updatedSellIn)
}

private fun additionalFoulsOdds(odds: Int, sellIn: Int): Int =
    if (odds >= 50) 0
    else (if (sellIn < 11) 1 else 0)+ (if (sellIn < 6) 1 else 0)