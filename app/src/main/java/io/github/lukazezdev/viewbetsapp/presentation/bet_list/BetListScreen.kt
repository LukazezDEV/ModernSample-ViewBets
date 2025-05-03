package io.github.lukazezdev.viewbetsapp.presentation.bet_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.lukazezdev.viewbetsapp.R
import io.github.lukazezdev.viewbetsapp.presentation.bet_list.components.BetList
import org.koin.androidx.compose.koinViewModel

@Composable
fun BetListScreenRoot(
    viewModel: BetListViewModel = koinViewModel(),
){
    val state by viewModel.state.collectAsStateWithLifecycle()

    BetListScreen(
        state = state,
        onAction = { viewModel.onAction(it) }
    )
}

@Composable
fun BetListScreen(
    state: BetListState,
    onAction: (BetListAction) -> Unit
) {
    val listState = rememberLazyListState()
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = { onAction(BetListAction.OnCalculateOddsButtonClick) },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(stringResource(R.string.bets_update_odds))
                    }
                    Button(
                        onClick = { onAction(BetListAction.OnRefetchBetsButtonClick) },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.outlinedButtonColors()
                    ) {
                        Text(stringResource(R.string.bets_refetch))
                    }
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp) // Standard padding for API 24+
                .background(MaterialTheme.colorScheme.background)
        ) {
            when {
                state.isLoading -> CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
                state.errorStringRes != null -> Text(
                    text = stringResource(state.errorStringRes),
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.error
                )
                state.betResults.isEmpty() -> Text(
                    text = stringResource(R.string.bets_no_results),
                    modifier = Modifier.align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                else -> BetList(
                    bets = state.betResults,
                    modifier = Modifier.fillMaxSize(),
                    scrollState = listState
                )
            }
        }
    }
}
