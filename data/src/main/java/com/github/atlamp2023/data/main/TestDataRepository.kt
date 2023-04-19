package com.github.atlamp2023.data.main

interface TestDataRepository {
    suspend fun getData(): RecipeDataItem
}