package com.gdg.donation.donationcenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdg.donation.databinding.ActivityDcFundingDetailBinding

class DCFundingDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDcFundingDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDcFundingDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}