package com.gdg.donation.donationcenter

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdg.donation.R
import com.gdg.donation.databinding.ActivityDcFundingDonationBinding
import com.gdg.donation.databinding.ItemProductDonationBinding
import com.gdg.donation.donationcenter.data.ProductDonation
import com.gdg.donation.donationcenter.data.ProductNeed
import com.gdg.donation.dummyProductDonationList

class DCFundingDonationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDcFundingDonationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDcFundingDonationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        // 기부 가능 농산품 리스트
        binding.donationProductList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ProductDonationAdapter(dummyProductDonationList)
        }

        binding.donationButton.setOnClickListener {
            val bottomSheet = DonationBottomSheetFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }

    private inner class ProductDonationHolder(private val binding : ItemProductDonationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productDonation : ProductDonation) {
            if (productDonation.image.isNullOrBlank()) { // 이미지
                binding.image.setImageResource(R.drawable.test)
            } else {
                Glide.with(binding.image.context)
                    .load(productDonation.image)
                    .into(binding.image)
            }
            binding.title.text = productDonation.title // 제목
            binding.writer.text = productDonation.writer // 작성자
            binding.price.text = productDonation.price.toString() // kg당 가격
        }
    }

    private inner class ProductDonationAdapter(private val productDonationList : List<ProductDonation>) : RecyclerView.Adapter<ProductDonationHolder>()  {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDonationHolder {
            val binding = ItemProductDonationBinding.inflate(layoutInflater, parent, false)

            return ProductDonationHolder(binding)
        }

        override fun getItemCount(): Int {
            return productDonationList.size
        }

        override fun onBindViewHolder(holder: ProductDonationHolder, position: Int) {
            holder.bind(productDonationList[position])
        }

    }
}
