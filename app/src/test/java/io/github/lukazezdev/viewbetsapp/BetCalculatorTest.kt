package io.github.lukazezdev.viewbetsapp

import io.github.lukazezdev.viewbetsapp.domain.Bet
import io.github.lukazezdev.viewbetsapp.domain.BetType.*
import io.github.lukazezdev.viewbetsapp.domain.calculateOdds

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

class BetCalculatorTest : StringSpec({
    "should handle individual bet updates" {
        val scenarios = listOf(
            // TOTAL_SCORE
            Bet(TOTAL_SCORE, 45, 5, "") to Bet(TOTAL_SCORE, 44, 6, ""), // odds=5 -> 6
            Bet(TOTAL_SCORE, 5, 50, "") to Bet(TOTAL_SCORE, 4, 50, ""), // odds=50 -> 50
            Bet(TOTAL_SCORE, 0, 49, "") to Bet(TOTAL_SCORE, -1, 50, ""), // expired: odds=49 -> 50
            // NUMBER_OF_FOULS
            Bet(NUMBER_OF_FOULS, 15, 40, "") to Bet(NUMBER_OF_FOULS, 14, 41, ""), // sellIn > 11: odds=40 -> 41
            Bet(NUMBER_OF_FOULS, 10, 40, "") to Bet(NUMBER_OF_FOULS, 9, 42, ""), // sellIn < 11: odds=40 -> 42
            Bet(NUMBER_OF_FOULS, 5, 40, "") to Bet(NUMBER_OF_FOULS, 4, 43, ""), // sellIn < 6: odds=40 -> 43
            Bet(NUMBER_OF_FOULS, 5, 50, "") to Bet(NUMBER_OF_FOULS, 4, 50, ""), // odds >= 50
            Bet(NUMBER_OF_FOULS, 0, 40, "") to Bet(NUMBER_OF_FOULS, -1, 0, ""), // expired: odds=40 -> 0
            // FIRST_GOAL_SCORER
            Bet(FIRST_GOAL_SCORER, 5, 20, "") to Bet(FIRST_GOAL_SCORER, 5, 20, ""), // no change
            Bet(FIRST_GOAL_SCORER, 0, 20, "") to Bet(FIRST_GOAL_SCORER, 0, 20, ""), // expired: no change
            // WINNING_TEAM
            Bet(WINNING_TEAM, 5, 10, "") to Bet(WINNING_TEAM, 4, 9, ""), // odds=10 -> 9
            Bet(WINNING_TEAM, 5, 0, "") to Bet(WINNING_TEAM, 4, 0, ""), // odds=0 -> 0
            Bet(WINNING_TEAM, 0, 10, "") to Bet(WINNING_TEAM, -1, 8, ""), // expired: odds=10 -> 8
            // OTHER
            Bet(OTHER, 10, 8, "") to Bet(OTHER, 9, 7, ""), // odds=8 -> 7
            Bet(OTHER, 10, 0, "") to Bet(OTHER, 9, 0, ""), // odds=0 -> 0
            Bet(OTHER, 0, 8, "") to Bet(OTHER, -1, 6, "") // expired: odds=8 -> 6
        )

        scenarios.forEach { (input, expected) ->
            listOf(input).calculateOdds().shouldContainExactly(expected)
        }
    }

    "should handle multiple bets with mixed types" {
        val bets = listOf(
            Bet(TOTAL_SCORE, 45, 5, ""),
            Bet(NUMBER_OF_FOULS, 5, 40, ""),
            Bet(FIRST_GOAL_SCORER, 5, 20, ""),
            Bet(WINNING_TEAM, 5, 10, ""),
            Bet(OTHER, 10, 8, "")
        )
        val expected = listOf(
            Bet(TOTAL_SCORE, 44, 6, ""),
            Bet(NUMBER_OF_FOULS, 4, 43, ""),
            Bet(FIRST_GOAL_SCORER, 5, 20, ""),
            Bet(WINNING_TEAM, 4, 9, ""),
            Bet(OTHER, 9, 7, "")
        )
        bets.calculateOdds().shouldContainExactly(expected)
    }
})