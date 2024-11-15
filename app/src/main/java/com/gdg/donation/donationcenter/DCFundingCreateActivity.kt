package com.gdg.donation.donationcenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdg.donation.databinding.ActivityDcFundingCreateBinding

class DCFundingCreateActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDcFundingCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDcFundingCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}