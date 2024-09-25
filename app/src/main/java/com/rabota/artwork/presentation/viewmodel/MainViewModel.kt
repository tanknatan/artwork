package com.rabota.artwork.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rabota.artwork.domain.ProductInfo
import com.rabota.artwork.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _products = MutableStateFlow<List<ProductInfo>>(emptyList())
    val products = _products.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getProducts().onSuccess { _products.value = it }
        }
    }

    var eighteenOver: Boolean
        get() = repository.eighteenOver
        set(value) { repository.eighteenOver = value }

    var startStepCompleted: Boolean
        get() = repository.startStepCompleted
        set(value) { repository.startStepCompleted = value }
}