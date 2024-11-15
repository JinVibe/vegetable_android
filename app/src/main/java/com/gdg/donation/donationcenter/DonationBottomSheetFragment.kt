package com.gdg.donation.donationcenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gdg.donation.R
import com.gdg.donation.databinding.BottomSheetDonationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DonationBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding : BottomSheetDonationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetDonationBinding.inflate(inflater, container, false)
        val view = binding.root
        view.setBackgroundResource(R.drawable.bottom_sheet_background)
        return view
    }

}