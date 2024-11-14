package com.gdg.donation.donationcenter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdg.donation.R
import com.gdg.donation.databinding.FragmentDonationCenterBinding
import com.gdg.donation.databinding.ItemDcFundingBinding
import com.gdg.donation.dummyDCFundingList


class DonationCenterFragment : Fragment() {
    private lateinit var binding : FragmentDonationCenterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDonationCenterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dcFundingList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DCFundingAdapter(dummyDCFundingList)
        }
    }

    ///////////////////////////// 펀딩 리스트 관련 클래스 //////////////////////////
    private inner class DCFundingHolder(private val binding : ItemDcFundingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dcFunding : DCFunding) {
            if (dcFunding.image.isNullOrBlank()) {
                binding.image.setImageResource(R.drawable.test)
            } else {
                Glide.with(requireContext())
                    .load(dcFunding.image)
                    .circleCrop() // 원형으로 자르기
                    .into(binding.image) // 이미지
            }
            val progressPercentage = (dcFunding.collectedAmount.toFloat() / dcFunding.targetAmount * 100).toInt()
            binding.progress.progress = progressPercentage
            binding.title.text = dcFunding.title // 제목
            binding.percent.text = "${progressPercentage}%" // 퍼센트(숫자)
            binding.writer.text = dcFunding.writer // 작성자
            binding.dcTag.text = dcFunding.dc_tag // 기부처 태그
            binding.product1.text = dcFunding.product_1 // 감자
            binding.product2.text = dcFunding.product_2 // 양파
            binding.product3.text = dcFunding.product_3 // 당근
            binding.deadlineAlarm.text = dcFunding.deadline_alarm // 데드라인 알람
            binding.deadlineDday.text = dcFunding.deadline_dday // 데드라인 디데이

            binding.root.setOnClickListener {
                startActivity(Intent(requireContext(), DCFundingDetailActivity::class.java))
            }
        }
    }

    private inner class DCFundingAdapter(private val dcFundingList : List<DCFunding>) : RecyclerView.Adapter<DCFundingHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DCFundingHolder {
            val binding = ItemDcFundingBinding.inflate(layoutInflater,parent,false)

            return DCFundingHolder(binding)
        }

        override fun getItemCount(): Int {
            return dcFundingList.size
        }

        override fun onBindViewHolder(holder: DCFundingHolder, position: Int) {
            holder.bind(dcFundingList[position])
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////
}