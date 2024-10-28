package com.plcoding.cryptotracker.crypto.domain

data class Coin(
    val id: String,
    val name: String,
    val rank: Int,
    val symbol: String,
    val marketCapUsD: Double,
    val priceUsD: Double,
    val changePercentageIn24H: Double
)
