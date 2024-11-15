package com.gdg.donation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdg.donation.databinding.FragmentMainBinding
import com.gdg.donation.donationcenter.DCFundingAdapter
import com.gdg.donation.donationcenter.DCFundingDonationActivity
import com.gdg.donation.donationcenter.DonationCenterFragment
import com.gdg.donation.donationcenter.ProductDonationAdapter
import com.gdg.donation.dummyDCFundingList
import com.gdg.donation.dummyProductDonationList

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding // 자동 생성이라는데..

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fundingList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DCFundingAdapter(dummyDCFundingList)
        }

        binding.productList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ProductDonationAdapter(dummyProductDonationList)
        }
    }
}