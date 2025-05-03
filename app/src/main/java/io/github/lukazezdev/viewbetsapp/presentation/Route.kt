package io.github.lukazezdev.viewbetsapp.presentation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object BetList: Route
}