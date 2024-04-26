package com.yusuforhan.cryptocurrency.features.cryptolist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuforhan.cryptocurrency.core.common.Resource
import com.yusuforhan.cryptyocurrency.core.domain.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : CryptoRepository
) : ViewModel() {
    fun getCryptoList() = viewModelScope.launch {
        when(val resource = repository.getCryptoList()) {
            is Resource.Success -> {
                resource.data.forEach {
                    println("Currency : ${it.currency}")
                    println("Price : ${it.price}")
                }
            }
            is Resource.Error -> println("Error : ${resource.message}")
            is Resource.Loading -> println("Loading")
        }
    }
}