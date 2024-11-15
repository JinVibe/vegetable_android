package com.gdg.donation.api

data class MemberReqDTO(
    val name: String,
    val email: String,
    val password: String,
    val phoneNum: String
)
