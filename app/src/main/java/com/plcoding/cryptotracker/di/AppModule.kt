package com.plcoding.cryptotracker.di

import com.plcoding.cryptotracker.core.data.networking.HTTPClientFactory
import com.plcoding.cryptotracker.crypto.data.network.RemoteCoinDataSource
import com.plcoding.cryptotracker.crypto.domain.CoinDataSource
import com.plcoding.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    single { HTTPClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>() // instead of single { RemoteCoinDataSource(get()) }

    viewModelOf(::CoinListViewModel)
}