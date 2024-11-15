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
    @PUT("http://192.168.10.123:8080/api/v1/member/change/password")
    fun resetPassword(@Body request: ResetPasswordReqDTO): Call<Void>

    // 회원가입 - 성공
    @POST("api/v1/member/new")
    fun signUp(@Body request: SignUpReqDTO): Call<Void>

    // 로그인 - 성공
    @POST("api/v1/member/login")
    fun logIn(
        @Body request: LogInReqDTO
    ): Call<LogInResDTO>

//    // 마이 페이지 열람
//    @GET("http://192.168.10.123:8080/api/v1/member/info")
//    fun

    // 아이디(이메일) 찾기
    @GET("api/v1/member/find/id")
    fun findIdResult(
        @Body parameters: findIdResultReqDTO
    ): Call<findIdResultResDTO>

    // 이메일 중복 확인 - 백에서 처리
    @GET("api/v1/member/email/{email}")
    fun checkEmailDuplicate(
        @Path("email") email: String
    ): Call<Boolean>

//    // product-controller
//    @POST("http://192.168.10.123:8080/api/product/create")
//    fun

//    @GET("http://192.168.10.123:8080/api/product")
//
//    @GET("http://192.168.10.123:808ㅁㄴ0/api/product/{productId}")
//
//    @GET("http://192.168.10.123:8080/api/product/search")
//
//    @GET("http://192.168.10.123:8080/api/product/cheapest")
//
//    // order-funding-controller
//    @POST("http://192.168.10.123:8080/api/orderFunding/create"
//
//
//    @GET("http://192.168.10.123:8080/api/orderFunding/{memberId}")
//
//    // funding-controller
//    @POST("http://192.168.10.123:8080/api/funding/create")
//
//    @GET("http://192.168.10.123:8080/api/funding")
//
//    @GET("http://192.168.10.123:8080/api/funding/{fundingId}")
//
//    @GET("http://192.168.10.123:8080/api/funding/search")
//
//    @GET("http://192.168.10.123:8080/api/funding/deadline")


}