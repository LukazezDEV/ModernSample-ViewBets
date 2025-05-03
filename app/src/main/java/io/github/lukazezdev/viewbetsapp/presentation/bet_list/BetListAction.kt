package io.github.lukazezdev.viewbetsapp.presentation.bet_list

sealed interface BetListAction {
    data object OnCalculateOddsButtonClick: BetListAction
    data object OnRefetchBetsButtonClick: BetListAction
}