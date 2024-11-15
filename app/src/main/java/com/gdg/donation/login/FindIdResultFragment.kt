package com.gdg.donation.login

// FindIdResultFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.gdg.donation.R

class FindIdResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_find_id_result, container, false)

        // Initialize views
        val buttonLogin = view.findViewById<Button>(R.id.buttonLogin)

        // Set click listener for login button
        buttonLogin.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, RealLoginFragment())
                addToBackStack(null)
            }
        }

        return view
    }
}