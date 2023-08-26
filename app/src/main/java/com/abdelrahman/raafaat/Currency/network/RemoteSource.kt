package com.abdelrahman.raafaat.currency.network

import com.abdelrahman.raafaat.currency.model.Currency
import com.abdelrahman.raafaat.currency.model.Symbols
import retrofit2.Response

interface RemoteSource {

    suspend fun getSymbols(): Response<Symbols>

    suspend fun convertCurrency(
        fromCurrency: String,
        toCurrency: String
    ): Response<Currency>
}