package com.abdelrahman.raafaat.currency.network

import com.abdelrahman.raafaat.currency.model.Symbols
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {

    @GET("symbols")
    suspend fun getSymbols( @Query("access_key") accessKey: String = "801077f1c0574b901458398a04082f90"): Response<Symbols>
}