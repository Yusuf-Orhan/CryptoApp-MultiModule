package com.yusuforhan.cryptodetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusuforhan.cryptocurrency.core.common.Resource
import com.yusuforhan.cryptyocurrency.core.domain.entity.CryptoDetail
import com.yusuforhan.cryptyocurrency.core.domain.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: CryptoRepository
): ViewModel() {
    val state = MutableStateFlow(DetailState())
    init {
        getCryptoDetail()
    }
    private fun getCryptoDetail() = viewModelScope.launch {
        when(val result = repository.getCryptoDetail()) {
            is Resource.Loading -> state.value = state.value.copy(isLoading = true)
            is Resource.Success -> state.value = state.value.copy(data = result.data)
            is Resource.Error -> state.value = state.value.copy(error = result.message)
        }
    }

}
data class DetailState(
    val isLoading : Boolean = false,
    val data: CryptoDetail? = null,
    val error : String = ""
)