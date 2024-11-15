package com.gdg.donation.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://3.38.223.188:8080/") // 서버의 기본 URL
            .client(client) // 헤더를 추가한 OkHttpClient 사용
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
