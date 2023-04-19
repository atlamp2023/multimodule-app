package com.github.atlamp2023.features.main.domain

class TestUseCase(private val repository: TestRepository) {
    suspend fun execute(): RecipeItem {
        val result = repository.getData()
        return result
    }
}