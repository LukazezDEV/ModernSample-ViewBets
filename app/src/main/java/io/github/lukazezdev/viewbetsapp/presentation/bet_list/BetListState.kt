package io.github.lukazezdev.viewbetsapp.presentation.bet_list

import androidx.annotation.StringRes
import io.github.lukazezdev.viewbetsapp.domain.Bet

data class BetListState(
    val betResults: List<Bet> = emptyList(),
    val isLoading: Boolean = true,
    @StringRes val errorStringRes: Int? = null
)