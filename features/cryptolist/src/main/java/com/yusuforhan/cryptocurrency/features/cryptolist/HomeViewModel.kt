package com.yusuforhan.cryptocurrency.features.cryptolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuforhan.cryptocurrency.core.common.Resource
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import com.yusuforhan.cryptyocurrency.core.domain.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {
    val state = MutableStateFlow(HomeState(null, null, null))

    init {
        getCryptoList()
    }
    private fun getCryptoList() = viewModelScope.launch {
        when (val resource = repository.getCryptoList()) {
            is Resource.Success -> {
                state.value = state.value.copy(isLoading = false, error = null, cryptoList = resource.data)
            }
            is Resource.Error -> state.value = state.value.copy(isLoading = false,error = resource.message,cryptoList = null)
            is Resource.Loading -> state.value = state.value.copy(isLoading = true,error = null,cryptoList = null)
        }
    }
}

data class HomeState(
    val isLoading: Boolean?,
    val error: String?,
    val cryptoList: List<CryptoItemEntity>?
)