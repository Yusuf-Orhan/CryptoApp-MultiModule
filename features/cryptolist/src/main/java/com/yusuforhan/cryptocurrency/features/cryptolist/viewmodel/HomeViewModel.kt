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
        val resource = repository.getCryptoList()
        when(resource) {
            is Resource.Success -> {
                resource.data.forEach {
                    println(it.name)
                    println(it.price)
                }
            }
            is Resource.Error -> println("Error : ${resource.message}")
            is Resource.Loading -> println("Loading")
        }
    }
}