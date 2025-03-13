package com.example.cryptocurrencytracker.repository

import com.example.cryptocurrencytracker.model.CryptoCurrency
import retrofit2.http.GET

interface CryptoApiService {
    @GET("coins/markets?vs_currency=usd")
    suspend fun getCryptoData(): List<CryptoCurrency>
}