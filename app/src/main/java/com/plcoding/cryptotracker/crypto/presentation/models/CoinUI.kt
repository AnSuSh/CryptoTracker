package com.plcoding.cryptotracker.crypto.presentation.models

import android.icu.text.NumberFormat
import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.core.presentation.util.getDrawableIdForCoin
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.presentation.coin_detail.DataPoint
import java.util.Locale

data class CoinUI(
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val marketCapUsD: DisplayableNumber,
    val priceUsD: DisplayableNumber,
    val changePercentageIn24H: DisplayableNumber,
    @DrawableRes val resId: Int,
    val coinPriceHistory: List<DataPoint> = emptyList()
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun Coin.toCoinUI(): CoinUI {
    return CoinUI(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        marketCapUsD = marketCapUsD.toDisplayableNumber(),
        priceUsD = priceUsD.toDisplayableNumber(),
        changePercentageIn24H = changePercentageIn24H.toDisplayableNumber(),
        resId = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }

    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}