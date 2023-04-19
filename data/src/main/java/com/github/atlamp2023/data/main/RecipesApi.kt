package com.github.atlamp2023.data.main

import retrofit2.http.GET

interface RecipesApi {
    @GET("/api/git")
    suspend fun getRecipes(): RecipeDataItem
}