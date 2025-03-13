package com.example.cryptocurrencytracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencytracker.model.CryptoCurrency
import com.example.cryptocurrencytracker.repository.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoViewModel : ViewModel() {
    // Use MutableStateFlow for mutable state
    private val _cryptoList = MutableStateFlow<List<CryptoCurrency>>(emptyList())
    val cryptoList: StateFlow<List<CryptoCurrency>> get() = _cryptoList

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    init {
        loadCryptoData()
    }

    private fun loadCryptoData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getCryptoData()
                _cryptoList.value = response
            } catch (e: Exception) {
                // Handle error (e.g., show error message)
            } finally {
                _isLoading.value = false
            }
        }
    }
}