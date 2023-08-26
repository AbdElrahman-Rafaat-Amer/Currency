package com.abdelrahman.raafaat.currency.model

import com.abdelrahman.raafaat.currency.network.RemoteSource
import retrofit2.Response

class Repository private constructor(private var remoteSource: RemoteSource) : RepositoryInterface {

    companion object {
        private var instance: Repository? = null
        fun getCurrencyClient(remoteSource: RemoteSource): Repository {
            if (instance == null)
                instance = Repository(remoteSource)
            return instance!!
        }
    }

    override suspend fun getSymbols(): Response<Symbols> = remoteSource.getSymbols()

    override suspend fun convertCurrency(
        fromCurrency: String,
        toCurrency: String
    ): Response<Currency> = remoteSource.convertCurrency(fromCurrency, toCurrency)
}