package com.example.cryptocurrencytracker.model

import com.google.gson.annotations.SerializedName

data class CryptoCurrency(
    val id: String,
    val name: String,
    val symbol: String,

    @SerializedName("current_price")
    val currentPrice: Double,

    @SerializedName("price_change_percentage_24h")
    val priceChangePercentage24h: Double
)