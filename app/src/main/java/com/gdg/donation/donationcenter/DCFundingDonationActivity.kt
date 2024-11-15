package com.gdg.donation.donationcenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdg.donation.databinding.ActivityDcFundingDonationBinding

class DCFundingDonationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDcFundingDonationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDcFundingDonationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}