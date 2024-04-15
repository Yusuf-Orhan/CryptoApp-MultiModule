package com.yusuforhan.cryptocurrency.features.cryptolist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuforhan.cryptocurrency.core.common.Resource
import com.yusuforhan.cryptyocurrency.core.domain.repository.CryptoRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository : CryptoRepository
) : ViewModel() {
    fun getCryptoList() = viewModelScope.launch {

    }
}