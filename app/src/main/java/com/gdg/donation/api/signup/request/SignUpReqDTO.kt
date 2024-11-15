package com.gdg.donation.api.signup.request

data class SignUpReqDTO(
    val name: String,
    val email: String,
    val password: String,
    val phoneNum: String
)