package com.plcoding.cryptotracker.crypto.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.crypto.presentation.coin_list.components.CoinListItem
import com.plcoding.cryptotracker.crypto.presentation.coin_list.components.coinPreview
import com.plcoding.cryptotracker.crypto.presentation.models.CoinUI
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListScreen(
    state: CoinListState,
    onClickAction: (CoinListAction) -> Unit,
    modifier: Modifier = Modifier
) {

    if (state.isLoading) {
        Box(modifier = modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.coins) { item: CoinUI ->
                CoinListItem(item = item, onClick = {
                    onClickAction(CoinListAction.OnCoinClick(item))
                }, modifier = Modifier.fillMaxWidth())
                HorizontalDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@PreviewLightDark
@Composable
private fun CoinListPreviewLoading() {
    CryptoTrackerTheme {
        CoinListScreen(state = CoinListState(isLoading = true), onClickAction = {})
    }
}

@Preview
@PreviewLightDark
@Composable
private fun CoinListPreviewReady() {
    CryptoTrackerTheme {
        CoinListScreen(
            state = CoinListState(isLoading = false,
                coins = (1..50).map {
                    coinPreview.copy(
                        id = it.toString()
                    )
                }
            ),
            onClickAction = {},
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}