package com.github.atlamp2023.data.sources

import com.google.gson.Gson
import retrofit2.Retrofit

class RetrofitConfig (
    val retrofit: Retrofit,
    val gson:  Gson
)