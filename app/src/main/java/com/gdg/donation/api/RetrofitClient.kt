package com.gdg.donation.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.10.123:8080/api/v1/member/new"

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val productApiService: ProductApiService by lazy {
        instance.create(ProductApiService::class.java)
    }
}
