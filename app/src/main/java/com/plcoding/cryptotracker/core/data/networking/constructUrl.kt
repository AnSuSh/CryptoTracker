package com.plcoding.cryptotracker.core.data.networking

import com.plcoding.cryptotracker.BuildConfig

fun constructUrl(urlString: String): String {
    return when {
        urlString.contains(BuildConfig.BASE_URL) -> urlString
        urlString.startsWith("/") -> BuildConfig.BASE_URL + urlString.drop(1)
        else -> BuildConfig.BASE_URL + urlString
    }
}