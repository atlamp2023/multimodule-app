package com.github.atlamp2023.features.main.domain

interface TestRepository {
    suspend fun getData(): RecipeItem
}