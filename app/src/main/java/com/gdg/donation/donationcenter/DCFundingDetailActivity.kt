package com.gdg.donation.donationcenter

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdg.donation.R
import com.gdg.donation.databinding.ActivityDcFundingDetailBinding
import com.gdg.donation.databinding.ItemImagePagerBinding
import com.gdg.donation.databinding.ItemProductBinding
import com.gdg.donation.dummyImageUrlList
import com.gdg.donation.dummyProductList

class DCFundingDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDcFundingDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDcFundingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imagePager.adapter = ImagePagerAdapter(dummyImageUrlList) // TODO 실제 list
        binding.productsList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ProductAdapter(dummyProductList)
        }
    }


    ////////////////////////////// 뷰페이저(이미지 스와이프) 관련 클래스 ////////////////////////
    private inner class ImagePagerHolder(private val binding : ItemImagePagerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl : String) {
            if (imageUrl.isNullOrBlank()) {
                binding.image.setImageResource(R.drawable.test)
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
    inner class ProductHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            if (product.image.isNullOrBlank()) {
                binding.image.setImageResource(R.drawable.test)
            } else {
                Glide.with(binding.image.context)
                    .load(product.image)
                    .circleCrop() // 원형으로 자르기
                    .into(binding.image) // 이미지
            }

            val progressPercentage = (product.collectedAmount.toFloat() / product.targetAmount * 100).toInt()
            binding.progress.progress = progressPercentage
            binding.percent.text = "${progressPercentage}%" // 퍼센트(숫자)
            binding.collectedAmount.text = product.collectedAmount.toString()
            binding.targetAmount.text = "/ ${product.targetAmount.toString()}kg"
        }
    }


    private inner class ProductAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
            val binding = ItemProductBinding.inflate(layoutInflater, parent, false)
            return ProductHolder(binding)
        }

        override fun getItemCount(): Int {
            return productList.size
        }

        override fun onBindViewHolder(holder: ProductHolder, position: Int) {
            holder.bind(productList[position])
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////
}