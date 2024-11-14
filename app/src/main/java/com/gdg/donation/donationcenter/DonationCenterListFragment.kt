package com.gdg.donation.donationcenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdg.donation.databinding.FragmentDonationCenterListBinding


class DonationCenterListFragment : Fragment() {
    private lateinit var binding : FragmentDonationCenterListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDonationCenterListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}