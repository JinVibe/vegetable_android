package com.gdg.donation.farmproducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdg.donation.databinding.FragmentFarmProductsBinding

class FarmProductsFragment : Fragment() {
    private lateinit var binding : FragmentFarmProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFarmProductsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}