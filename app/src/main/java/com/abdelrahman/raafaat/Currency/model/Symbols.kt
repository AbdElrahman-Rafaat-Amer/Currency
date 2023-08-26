package com.abdelrahman.raafaat.currency.model

import com.google.gson.annotations.SerializedName

data class Symbols(
    @SerializedName("success")
    val isSuccess: Boolean,
    @SerializedName("symbols")
    val currencies: Map<String, String>?,
    val error: CurrencyError?
)