package com.gdg.donation.donationcenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdg.donation.databinding.FragmentDonationCenterBinding



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
}