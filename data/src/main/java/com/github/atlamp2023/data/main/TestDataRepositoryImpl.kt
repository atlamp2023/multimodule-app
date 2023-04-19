package com.github.atlamp2023.data.main

import com.github.atlamp2023.data.sources.RetrofitConfigProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class TestDataRepositoryImpl: TestDataRepository {

    private val retrofit = RetrofitConfigProvider.config.retrofit
    private val recipesApi = retrofit.create(RecipesApi::class.java)

    override suspend fun getData() = CoroutineScope(Dispatchers.IO).async  {
        val result = recipesApi.getRecipes()
        return@async result
    }.await()
}