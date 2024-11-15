package com.gdg.donation.donationcenter

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdg.donation.R
import com.gdg.donation.databinding.ActivityDcFundingDetailBinding
import com.gdg.donation.databinding.ItemImagePagerBinding
import com.gdg.donation.databinding.ItemProductNeedBinding
import com.gdg.donation.donationcenter.data.ProductNeed
import com.gdg.donation.dummyImageUrlList
import com.gdg.donation.dummyProductNeedList

class DCFundingDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDcFundingDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDcFundingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 이미지 뷰페이저
        binding.imagePager.adapter = ImagePagerAdapter(dummyImageUrlList) // TODO 실제 list
        
        // 필요 농산물 리사이클러뷰
        binding.productsList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ProductNeedAdapter(dummyProductNeedList)
        }

        // 기부하기 버튼 클릭 리스너
        binding.donationButton.setOnClickListener {
            startActivity(Intent(this, DCFundingDonationActivity::class.java))
        }

        // 뒤로가기
        binding.backButton.setOnClickListener {
            finish()
        }
    }


    ////////////////////////////// 뷰페이저(이미지 스와이프) 관련 클래스 ////////////////////////
    private inner class ImagePagerHolder(private val binding : ItemImagePagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl : String) {
            if (imageUrl.isNullOrBlank()) { // 이미지
                binding.image.setImageResource(R.drawable.dummy_image_1)
            } else {
                Glide.with(binding.image.context).load(imageUrl).into(binding.image)
            }
        }
    }

    private inner class ImagePagerAdapter(private val imageUrlList : List<String>) : RecyclerView.Adapter<ImagePagerHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagePagerHolder {
            val binding = ItemImagePagerBinding.inflate(layoutInflater, parent, false)

            return ImagePagerHolder(binding)
        }

        override fun getItemCount(): Int {
            return imageUrlList.size
        }

        override fun onBindViewHolder(holder: ImagePagerHolder, position: Int) {
            holder.bind(imageUrlList[position])
        }

    }
    //////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////// 리사이클러뷰(필요 농산물) 관련 클래스 ////////////////////////
    inner class ProductNeedHolder(private val binding: ItemProductNeedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productNeed: ProductNeed) {
            val progressPercentage = (productNeed.collectedAmount.toFloat() / productNeed.targetAmount * 100).toInt() // 프로그래스 계산

            if (productNeed.image.isNullOrBlank()) { // 이미지
                binding.image.setImageResource(R.drawable.dummy_image_2)
            } else {
                Glide.with(binding.image.context)
                    .load(productNeed.image)
                    .circleCrop() // 원형으로 자르기
                    .into(binding.image) // 이미지
            }
            binding.progress.progress = progressPercentage // 프로그래스
            binding.percent.text = "${progressPercentage}%" // 퍼센트(숫자)
            binding.collectedAmount.text = productNeed.collectedAmount.toString() // 현재까지 모은 양
            binding.targetAmount.text = "/ ${productNeed.targetAmount.toString()}kg" // 목표량
        }
    }


    inner class ProductNeedAdapter(private val productNeedList: List<ProductNeed>) : RecyclerView.Adapter<ProductNeedHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductNeedHolder {
            val binding = ItemProductNeedBinding.inflate(layoutInflater, parent, false)
            return ProductNeedHolder(binding)
        }

        override fun getItemCount(): Int {
            return productNeedList.size
        }

        override fun onBindViewHolder(holder: ProductNeedHolder, position: Int) {
            holder.bind(productNeedList[position])
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////
}