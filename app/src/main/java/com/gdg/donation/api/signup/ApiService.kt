package com.gdg.donation.api

import com.gdg.donation.api.signup.request.*
import com.gdg.donation.api.signup.response.LogInResDTO
import com.gdg.donation.api.signup.response.findIdResultResDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.*

// 회원가입 API 인터페이스
interface ApiService {
    // 비밀번호 변경
    @PUT("api/member/change/password")
    fun resetPassword(@Body request: ResetPasswordReqDTO): Call<Void>

    // 회원가입 - 성공
    @POST("api/member/new")
    fun signUp(@Body request: SignUpReqDTO): Call<Void>

    // 로그인 - 성공
    @POST("api/member/login")
    fun logIn(
        @Body request: LogInReqDTO
    ): Call<LogInResDTO>

//    // 마이 페이지 열람
//    @GET("api/member/info")
//    fun

    // 아이디(이메일) 찾기
    @GET("api/member/find/id")
    fun findIdResult(
        @Body parameters: findIdResultReqDTO
    ): Call<findIdResultResDTO>

    // 이메일 중복 확인 - 백에서 처리
    @GET("api/member/email/{email}")
    fun checkEmailDuplicate(
        @Path("email") email: String
    ): Call<Boolean>

//    // product-controller
//    @POST("api/product/create")
//    fun

//    @GET("api/product")
//
//    @GET("api/product/{productId}")
//
//    @GET("api/product/search")
//
//    @GET("api/product/cheapest")
//
//    // order-funding-controller
//    @POST("api/orderFunding/create"
//
//
//    @GET("api/orderFunding/{memberId}")
//
//    // funding-controller
//    @POST("api/funding/create")
//
//    @GET("api/funding")
//
//    @GET("api/funding/{fundingId}")
//
//    @GET("api/funding/search")
//
//    @GET("api/funding/deadline")


}