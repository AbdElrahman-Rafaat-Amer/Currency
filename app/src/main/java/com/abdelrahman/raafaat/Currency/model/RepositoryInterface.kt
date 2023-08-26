package com.abdelrahman.raafaat.currency.model

import retrofit2.Response

interface RepositoryInterface {

    suspend fun getSymbols(): Response<Symbols>

    suspend fun convertCurrency(
        fromCurrency: String,
        toCurrency: String
    ): Response<Currency>
}