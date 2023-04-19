package com.github.atlamp2023.data.sources

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession

const val BASE_URL = "http://10.0.2.2:5000"

object RetrofitConfigProvider {

    private val customHostnameVerifier = object: HostnameVerifier {
        override fun verify(p0: String?, p1: SSLSession?): Boolean {
            return true;
        }
    }

    val gson = Gson()

    val config = RetrofitConfig(
        retrofit = createRetrofit(),
        gson = gson
    )

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .hostnameVerifier(customHostnameVerifier)
            .build()
    }
}