package com.gdg.donation.donationcenter

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdg.donation.databinding.ActivityDonationCompleteBinding
import com.gdg.donation.databinding.BottomSheetDonationBinding

class DonationCompleteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDonationCompleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDonationCompleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.completeButton.setOnClickListener {
            finish()
        }
    }
}