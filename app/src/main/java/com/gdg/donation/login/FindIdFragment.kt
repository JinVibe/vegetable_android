package com.gdg.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.gdg.donation.R
import com.gdg.donation.login.FindIdResultFragment

class FindIdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_find_id, container, false)

        // Initialize views
        val buttonFindId = view.findViewById<Button>(R.id.buttonFindId)
        val buttonBack = view.findViewById<Button>(R.id.buttonBack)

        // Set click listener for find ID button
        buttonFindId.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, FindIdResultFragment())
                addToBackStack(null)
            }
        }

        buttonBack.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        return view
    }
}