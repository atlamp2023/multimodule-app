package com.github.atlamp2023.itnotes.di


import com.github.atlamp2023.features.main.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel <MainViewModel> () {
        params ->
        MainViewModel(useCase = params.get())
    }

}