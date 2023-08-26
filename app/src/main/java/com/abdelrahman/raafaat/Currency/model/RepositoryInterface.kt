package com.abdelrahman.raafaat.currency.model

import retrofit2.Response

interface RepositoryInterface {

    suspend fun getSymbols(): Response<Symbols>

}