package com.gdg.donation.donationcenter.data

data class DCFunding(
    val image : String? = null,
    val targetAmount : Int = 0,
    val collectedAmount : Int = 0,
    val title : String? = null,
    val writer : String? = null,
    val dc_tag : String? = null,
    val product_1 : String? = null,
    val product_2 : String? = null,
    val product_3 : String? = null,
    val deadline_alarm : String? = null,
    val deadline_dday : String? = null,
)
