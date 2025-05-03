package io.github.lukazezdev.viewbetsapp.di

import io.github.lukazezdev.viewbetsapp.core_utils.data.HttpClientFactory
import io.github.lukazezdev.viewbetsapp.data.BetRepository
import io.github.lukazezdev.viewbetsapp.data.RemoteBetDataSource
import io.github.lukazezdev.viewbetsapp.data.RemoteBetDataSourceInterface
import io.github.lukazezdev.viewbetsapp.domain.BetRepositoryInterface
import io.github.lukazezdev.viewbetsapp.presentation.bet_list.BetListViewModel
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<HttpClientEngine> { OkHttp.create() }
    single { HttpClientFactory.create(get()) }

    singleOf(::RemoteBetDataSource).bind<RemoteBetDataSourceInterface>()
    singleOf(::BetRepository).bind<BetRepositoryInterface>()

    viewModelOf(::BetListViewModel)
}