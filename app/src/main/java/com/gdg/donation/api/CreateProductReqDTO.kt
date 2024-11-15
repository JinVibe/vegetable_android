package com.gdg.donation.api

data class CreateProductReqDto(
    val memberId: Int,
    val imageUrlList: List<String>,
    val productName: String,
    val productType: String,  // Enum 대신 String을 사용했지만, Enum으로 정의할 수도 있습니다.
    val expireDate: String,
    val minUnit: Int,
    val minPrice: Int,
    val measurementUnit: String,
    val totalQuantity: Int,
    val totalPrice: Int,
    val productContent: String
)