package io.github.lukazezdev.viewbetsapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.lukazezdev.viewbetsapp.core_utils.presentation.AppTheme
import io.github.lukazezdev.viewbetsapp.presentation.bet_list.BetListScreenRoot
import io.github.lukazezdev.viewbetsapp.presentation.bet_list.BetListViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    AppTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Route.BetList) {
            composable<Route.BetList> {
                val viewModel = koinViewModel<BetListViewModel>()
                BetListScreenRoot(viewModel)
            }
        }
    }
}
