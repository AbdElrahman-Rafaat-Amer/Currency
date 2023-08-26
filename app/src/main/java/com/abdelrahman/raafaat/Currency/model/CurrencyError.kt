package com.abdelrahman.raafaat.currency.model

import com.google.gson.annotations.SerializedName

data class CurrencyError(
    @SerializedName("code")
    val errorCode: Int,
    @SerializedName("type")
    val errorType: String = "",
    @SerializedName("info")
    val errorInfo: String = ""
)