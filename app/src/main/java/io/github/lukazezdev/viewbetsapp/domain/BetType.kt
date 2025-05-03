package io.github.lukazezdev.viewbetsapp.domain

import androidx.annotation.StringRes
import io.github.lukazezdev.viewbetsapp.R

enum class BetType(@StringRes val stringId: Int) {
    WINNING_TEAM(R.string.bet_type_winning_team),
    PLAYER_PERFORMANCE(R.string.bet_type_player_performance),
    CORNER_KICKS(R.string.bet_type_corner_kicks),
    TOTAL_SCORE(R.string.bet_type_total_score),
    FIRST_GOAL_SCORER(R.string.bet_type_first_goal_scorer),
    NUMBER_OF_FOULS(R.string.bet_type_number_of_fouls),
    OTHER(R.string.bet_type_other);
}