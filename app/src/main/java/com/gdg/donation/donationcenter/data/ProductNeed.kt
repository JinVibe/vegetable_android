package com.gdg.donation.donationcenter.data

data class ProductNeed(
    val image : String? = null,
    val targetAmount : Int = 0,
    val collectedAmount : Int = 0,
    val name : String? = null,
)
