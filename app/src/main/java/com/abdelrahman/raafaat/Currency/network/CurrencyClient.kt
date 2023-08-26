package com.abdelrahman.raafaat.currency.network

import com.abdelrahman.raafaat.currency.model.Symbols
import retrofit2.Response

class CurrencyClient private constructor() : RemoteSource {

    private val currencyHelper = CurrencyHelper.getClient

    companion object {
        private var instance: CurrencyClient? = null
        fun getCurrencyClient(): CurrencyClient {
            if (instance == null)
                instance = CurrencyClient()
            return instance!!
        }
    }

    override suspend fun getSymbols(): Response<Symbols> = currencyHelper.getSymbols()

}