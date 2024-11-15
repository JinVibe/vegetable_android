package com.gdg.donation.donationcenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdg.donation.R
import com.gdg.donation.databinding.ItemProductDonationBinding
import com.gdg.donation.donationcenter.data.ProductDonation

class ProductDonationAdapter(private val productDonationList: List<ProductDonation>) : RecyclerView.Adapter<ProductDonationAdapter.ProductDonationHolder>() {

    inner class ProductDonationHolder(private val binding: ItemProductDonationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productDonation: ProductDonation) {
            if (productDonation.image.isNullOrBlank()) {
                binding.image.setImageResource(R.drawable.dummy_image_2)
            } else {
                Glide.with(binding.image.context)
                    .load(productDonation.image)
                    .into(binding.image)
            }
            binding.title.text = productDonation.title
            binding.writer.text = productDonation.writer
            binding.price.text = productDonation.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDonationHolder {
        val binding = ItemProductDonationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductDonationHolder(binding)
    }

    override fun getItemCount(): Int {
        return productDonationList.size
    }

    override fun onBindViewHolder(holder: ProductDonationHolder, position: Int) {
        holder.bind(productDonationList[position])
    }
}