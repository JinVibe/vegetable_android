package com.gdg.donation.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ProductApiService {
    @POST("/api/product/create")
    fun createProduct(@Body product: CreateProductReqDto): Call<CreateProductResDto>
}
