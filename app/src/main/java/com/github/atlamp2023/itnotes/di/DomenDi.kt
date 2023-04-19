package com.github.atlamp2023.itnotes.di

import com.github.atlamp2023.features.main.domain.TestUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<TestUseCase> {
        TestUseCase(repository = get())
    }
}
