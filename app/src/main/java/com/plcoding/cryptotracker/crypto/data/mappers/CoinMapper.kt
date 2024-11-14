package com.plcoding.cryptotracker.crypto.data.mappers

import com.plcoding.cryptotracker.crypto.data.network.dto.CoinDto
import com.plcoding.cryptotracker.crypto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id= id,
        name = name,
        symbol = symbol,
        rank = rank,
        marketCapUsD = marketCapUsD,
        priceUsD = priceUsD,
        changePercentageIn24H = changePercent24Hr
    )
}