package io.github.lukazezdev.viewbetsapp.data

import io.github.lukazezdev.viewbetsapp.core_utils.data.safeCall
import io.github.lukazezdev.viewbetsapp.core_utils.domain.DataError
import io.github.lukazezdev.viewbetsapp.core_utils.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get

interface RemoteBetDataSourceInterface{
    suspend fun fetchBets(): Result<List<BetResponseObject>, DataError.Remote>
}

private const val URL = "https://run.mocky.io/v3/6878f2bf-56c6-4ff4-8c16-449d88128f73"

class RemoteBetDataSource(
    private val httpClient: HttpClient
): RemoteBetDataSourceInterface {

    override suspend fun fetchBets(): Result<List<BetResponseObject>, DataError.Remote>
        = safeCall<List<BetResponseObject>> {
            httpClient.get(
                urlString = URL
            )
        }
}