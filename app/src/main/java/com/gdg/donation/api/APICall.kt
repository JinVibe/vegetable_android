//package com.gdg.donation.api
//
//import android.os.Bundle
//import android.util.Log
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.gdg.donation.R
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class APICall : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // 예시 요청 데이터
//        val productRequest = CreateProductReqDto(
//            memberId = 1,
//            imageUrlList = listOf("https://example.com/images/product_1.jpg", "https://example.com/images/product_2.jpg"),
//            productName = "갓나온 햇살 감자",
//            productType = "POTATO",
//            expireDate = "2024-12-01",
//            minUnit = 10,
//            minPrice = 3000,
//            measurementUnit = "KG",
//            totalQuantity = 20,
//            totalPrice = 60000,
//            productContent = "방금 나온듯한 신선한 감자 사가세요!"
//        )
//
//        // API 호출
//        RetrofitInstance.api.createProduct(productRequest).enqueue(object : Callback<CreateProductResDto> {
//            override fun onResponse(call: Call<CreateProductResDto>, response: Response<CreateProductResDto>) {
//                if (response.isSuccessful) {
//                    // 성공적으로 등록되었을 때
//                    val productResponse = response.body()
//                    productResponse?.let {
//                        Toast.makeText(this@MainActivity, "상품 등록 성공! ID: ${it.productId}", Toast.LENGTH_LONG).show()
//                    }
//                } else {
//                    // 서버 오류 등의 응답이 실패했을 때
//                    Toast.makeText(this@MainActivity, "상품 등록 실패: ${response.code()}", Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<CreateProductResDto>, t: Throwable) {
//                // 네트워크 오류 등 요청 자체가 실패했을 때
//                Toast.makeText(this@MainActivity, "네트워크 오류 발생", Toast.LENGTH_LONG).show()
//                Log.e("API Error", "Error: ${t.message}")
//            }
//        })
//    }
//}
