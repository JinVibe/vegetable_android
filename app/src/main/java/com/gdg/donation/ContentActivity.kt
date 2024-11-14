package com.gdg.donation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gdg.donation.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}