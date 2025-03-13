package com.example.cryptocurrencytracker.ui.screen

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cryptocurrencytracker.model.CryptoCurrency
import com.example.cryptocurrencytracker.viewmodel.CryptoViewModel

@Composable
fun CryptoListScreen(viewModel: CryptoViewModel = viewModel()) {
    // Use collectAsState() to observe StateFlow
    val cryptoList by viewModel.cryptoList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    // Show loading spinner if data is being fetched
    if (isLoading) {
        CircularProgressIndicator()
    } else {
        // Display the list of cryptocurrencies
        LazyColumn {
            items(cryptoList) { crypto ->
                CryptoItem(crypto = crypto)
            }
        }
    }
}

@Composable
fun CryptoItem(crypto: CryptoCurrency) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = crypto.name, fontWeight = FontWeight.Bold)
        Text(text = "$${crypto.currentPrice}") // Correct property name
        Text(text = "24h Change: ${crypto.priceChangePercentage24h}%") // Correct property name
    }
}