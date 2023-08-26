package com.abdelrahman.raafaat.currency.model

import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("success")
    val isSuccess: Boolean,
    @SerializedName("base")
    val baseCurrency: String,
    val rates: Map<String, Double>?,
    val error: CurrencyError
)