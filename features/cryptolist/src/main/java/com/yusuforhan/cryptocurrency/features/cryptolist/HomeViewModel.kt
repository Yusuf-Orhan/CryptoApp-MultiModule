package com.yusuforhan.cryptocurrency.features.cryptolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuforhan.cryptocurrency.core.common.Resource
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoItemEntity
import com.yusuforhan.cryptyocurrency.core.domain.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState(null, null, null))
    val state : StateFlow<HomeState> = _state

    init {
        getCryptoList()
    }
    fun getCryptoList() {
        repository.getCryptoList().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value =
                        state.value.copy(isLoading = false, error = null, cryptoList = result.data)
                }
                is Resource.Error -> _state.value =
                    state.value.copy(isLoading = false, error = result.message, cryptoList = null)

                is Resource.Loading -> _state.value =
                    state.value.copy  (isLoading = true, error = null, cryptoList = null)
            }
        }.launchIn(viewModelScope)
    }
}

data class HomeState(
    val isLoading: Boolean?,
    val error: String?,
    val cryptoList: List<CryptoItemEntity>?
)