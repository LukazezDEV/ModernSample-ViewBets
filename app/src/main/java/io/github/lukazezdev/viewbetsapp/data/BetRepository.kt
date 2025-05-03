package io.github.lukazezdev.viewbetsapp.data

import android.content.Context
import io.github.lukazezdev.viewbetsapp.core_utils.domain.DataError
import io.github.lukazezdev.viewbetsapp.core_utils.domain.Result
import io.github.lukazezdev.viewbetsapp.core_utils.domain.map
import io.github.lukazezdev.viewbetsapp.domain.Bet
import io.github.lukazezdev.viewbetsapp.domain.BetRepositoryInterface

class BetRepository(
    private val remoteBetDataSource: RemoteBetDataSource,
    private val context: Context
): BetRepositoryInterface {
    override suspend fun fetchBets(): Result<List<Bet>, DataError.Remote> =
        remoteBetDataSource
            .fetchBets()
            .map { result ->
                result.map { it.toBet(context) }
            }
}