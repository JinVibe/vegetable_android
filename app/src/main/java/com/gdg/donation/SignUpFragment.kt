package com.gdg.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        // Initialize views
        val buttonStart = view.findViewById<Button>(R.id.buttonStart)

        // Set click listener for start button
        buttonStart.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, RealLoginFragment())
                addToBackStack(null)
            }
        }

        return view
    }
}