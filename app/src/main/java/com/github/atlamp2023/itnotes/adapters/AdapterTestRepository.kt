package com.github.atlamp2023.itnotes.adapters

import com.github.atlamp2023.data.main.TestDataRepositoryImpl
import com.github.atlamp2023.features.main.domain.RecipeItem
import com.github.atlamp2023.features.main.domain.TestRepository
import com.github.atlamp2023.itnotes.map.toRecipeItem

class AdapterTestRepository(val repository: TestDataRepositoryImpl): TestRepository {
    override suspend fun getData(): RecipeItem {
        return repository.getData().toRecipeItem()
    }
}