package com.github.atlamp2023.itnotes.map

import com.github.atlamp2023.data.main.RecipeDataItem
import com.github.atlamp2023.features.main.domain.RecipeItem

fun RecipeDataItem.toRecipeItem() = RecipeItem(
    command = this.command,
    description = this.description
)
