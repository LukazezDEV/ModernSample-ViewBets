package io.github.lukazezdev.viewbetsapp.domain

import io.github.lukazezdev.viewbetsapp.core_utils.domain.DataError
import io.github.lukazezdev.viewbetsapp.core_utils.domain.Result

interface BetRepositoryInterface {
    suspend fun fetchBets(): Result<List<Bet>, DataError.Remote>
}