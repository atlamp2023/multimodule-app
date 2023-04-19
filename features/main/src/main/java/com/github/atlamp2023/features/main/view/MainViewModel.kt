package com.github.atlamp2023.features.main.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.atlamp2023.features.main.domain.RecipeItem
import com.github.atlamp2023.features.main.domain.TestUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val useCase: TestUseCase): ViewModel() {

    private val _state = MutableStateFlow(RecipeItem())
    val state = _state.asStateFlow()

    init {
        getData()
    }

    fun getData() = viewModelScope.launch {
        try{
            _state.value = useCase.execute()
        }catch (e: Exception){
            Log.d("MainViewModel", "$e, ${e.stackTrace}")
        }
    }
}