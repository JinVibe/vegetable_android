package com.gdg.donation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdg.donation.databinding.ActivityContentBinding
import com.gdg.donation.donationcenter.DonationCenterFragment
import com.gdg.donation.farmproducts.FarmProductsFragment
import com.gdg.donation.main.MainFragment
import com.gdg.donation.mypage.MyPageFragment

class ContentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContentBinding

    private val mainFragment = MainFragment() // 메인 프래그먼트
    private val farmProductsFragment = FarmProductsFragment() // 농산품 프래그먼트
    private val donationCenterFragment = DonationCenterFragment() // 기부처 프래그먼트
    private val myPageFragment = MyPageFragment() // 마이페이지 프래그먼트


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 기본 프래그먼트 설정
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, mainFragment).commit()
        }
        
        // 바텀 네비게이션 뷰 클릭 리스너
        binding.bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId) {
                R.id.main_nav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, mainFragment).commit()
                    true
                }
                R.id.farm_products_nav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, farmProductsFragment).commit()
                    true
                }
                R.id.donation_center_nav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, donationCenterFragment).commit()
                    true
                }
                R.id.my_page_nav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, myPageFragment).commit()
                    true
                }
                else -> false
            }
        }
    }
}