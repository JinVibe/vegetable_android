package com.gdg.donation

// FindPasswordFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class FindPasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_find_password, container, false)

        // Initialize views
        val buttonResetPassword = view.findViewById<Button>(R.id.buttonResetPassword)

        // Set click listener for reset password button
        buttonResetPassword.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, ResetPasswordFragment())
                addToBackStack(null)
            }
        }

        return view
    }
}