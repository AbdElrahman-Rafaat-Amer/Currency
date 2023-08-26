package com.abdelrahman.raafaat.currency.network

import com.abdelrahman.raafaat.currency.model.Symbols
import retrofit2.Response

interface RemoteSource {

    suspend fun getSymbols(): Response<Symbols>

}