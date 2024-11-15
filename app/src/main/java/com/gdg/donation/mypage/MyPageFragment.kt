package com.gdg.donation.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gdg.donation.R
import com.gdg.donation.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {
    private lateinit var binding : FragmentMyPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.box.setOnClickListener {
            val myDonationListFragment = MyDonationListFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,myDonationListFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}