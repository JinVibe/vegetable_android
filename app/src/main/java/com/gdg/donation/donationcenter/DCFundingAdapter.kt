package com.gdg.donation.donationcenter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdg.donation.R
import com.gdg.donation.databinding.ItemDcFundingBinding
import com.gdg.donation.donationcenter.data.DCFunding

class DCFundingAdapter(private val dcFundingList: List<DCFunding>) : RecyclerView.Adapter<DCFundingAdapter.DCFundingHolder>() {

    inner class DCFundingHolder(private val binding: ItemDcFundingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dcFunding: DCFunding) {
            val progressPercentage = (dcFunding.collectedAmount.toFloat() / dcFunding.targetAmount * 100).toInt()

            if (dcFunding.image.isNullOrBlank()) {
                binding.image.setImageResource(R.drawable.test)
            } else {
                Glide.with(binding.root.context)
                    .load(dcFunding.image)
                    .circleCrop()
                    .into(binding.image)
            }
            binding.progress.progress = progressPercentage
            binding.title.text = dcFunding.title
            binding.percent.text = "${progressPercentage}%"
            binding.writer.text = dcFunding.writer
            binding.dcTag.text = dcFunding.dc_tag
            binding.product1.text = dcFunding.product_1
            binding.product2.text = dcFunding.product_2
            binding.product3.text = dcFunding.product_3
            binding.deadlineAlarm.text = dcFunding.deadline_alarm
            binding.deadlineDday.text = dcFunding.deadline_dday

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, DCFundingDetailActivity::class.java)
                startActivity(binding.root.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DCFundingHolder {
        val binding = ItemDcFundingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DCFundingHolder(binding)
    }

    override fun getItemCount(): Int {
        return dcFundingList.size
    }

    override fun onBindViewHolder(holder: DCFundingHolder, position: Int) {
        holder.bind(dcFundingList[position])
    }
}