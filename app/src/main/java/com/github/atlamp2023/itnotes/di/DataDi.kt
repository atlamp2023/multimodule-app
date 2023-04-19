package com.github.atlamp2023.itnotes.di

import com.github.atlamp2023.data.main.TestDataRepositoryImpl
import com.github.atlamp2023.features.main.domain.TestRepository
import com.github.atlamp2023.itnotes.adapters.AdapterTestRepository
import org.koin.dsl.module

val dataModule = module {

    single<TestDataRepositoryImpl> {
        TestDataRepositoryImpl()
    }

    single<TestRepository> {
        AdapterTestRepository(repository = get())
    }

}

