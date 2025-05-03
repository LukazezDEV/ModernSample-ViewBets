package io.github.lukazezdev.viewbetsapp.presentation.bet_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.lukazezdev.viewbetsapp.R
import io.github.lukazezdev.viewbetsapp.core_utils.domain.onError
import io.github.lukazezdev.viewbetsapp.core_utils.domain.onSuccess
import io.github.lukazezdev.viewbetsapp.data.BetRepository
import io.github.lukazezdev.viewbetsapp.domain.calculateOdds
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BetListViewModel(
    private val betRepository: BetRepository
): ViewModel() {
    private val _state = MutableStateFlow(BetListState())
    val state = _state
        .onStart {
            viewModelScope.launch { fetchBets() }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: BetListAction) {
        when(action){
            BetListAction.OnCalculateOddsButtonClick -> calculateOdds()
            BetListAction.OnRefetchBetsButtonClick -> fetchBets()
        }
    }

    private fun fetchBets() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        betRepository
            .fetchBets()
            .also { delay(200) } //Simulates loading
            .onSuccess { bets ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        betResults = bets,
                        errorStringRes = null,
                    )
                }
            }
            .onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        betResults = emptyList(),
                        errorStringRes = error.stringRes
                    )
                }
            }
    }

    private fun calculateOdds() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true) }
        delay(300L) //Simulates loading
        _state.update {
            if (it.betResults.isEmpty()) {
                it.copy(
                    isLoading = false,
                    errorStringRes = R.string.bets_no_results
                )
            } else {
                it.copy(
                    isLoading = false,
                    betResults = it.betResults.calculateOdds(),
                    errorStringRes = null
                )
            }
        }

    }
}