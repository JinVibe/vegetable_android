package com.gdg.donation.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdg.donation.databinding.FragmentDonationListBinding
import com.gdg.donation.donationcenter.DCFundingAdapter
import com.gdg.donation.dummyDCFundingList

class MyDonationListFragment : Fragment() {
    private lateinit var binding : FragmentDonationListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDonationListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myDonationList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DCFundingAdapter(dummyDCFundingList)
        }
    }
}