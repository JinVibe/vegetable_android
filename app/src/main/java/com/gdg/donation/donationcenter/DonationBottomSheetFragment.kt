package com.gdg.donation.donationcenter

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.gdg.donation.R
import com.gdg.donation.databinding.BottomSheetDonationBinding
import com.gdg.donation.donationcenter.data.ProductDonation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DonationBottomSheetFragment(private val productDonation : ProductDonation) : BottomSheetDialogFragment() {
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

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 뒤로가기
        binding.backButton.setOnClickListener {
            dismiss()
        }

        var count = 1

        binding.title.text = productDonation.title
        binding.writer.text = productDonation.writer
        binding.price.text = DecimalFormat("#,###").format(productDonation.price).toString() + " 원"

        binding.minusButton.setOnClickListener {
            count--

            val totalPrice = count * productDonation.price
            val formattedTotalPrice = DecimalFormat("#,###").format(totalPrice)

            binding.count.text = count.toString()
            binding.totalPrice.text = formattedTotalPrice.toString() + "원"
        }

        binding.plusButton.setOnClickListener {
            count++

            val totalPrice = count * productDonation.price
            val formattedTotalPrice = DecimalFormat("#,###").format(totalPrice)

            binding.count.text = count.toString()
            binding.totalPrice.text = formattedTotalPrice.toString() + "원"
        }

        binding.donationButton.setOnClickListener {
            dismiss()
            requireActivity().finish()
            startActivity(Intent(context, DonationCompleteActivity::class.java))
        }
    }

}