package com.gdg.donation

// LoginFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Initialize views
        val buttonCreateAccount = view.findViewById<Button>(R.id.buttonCreateAccount)
        val buttonGoogleSignIn = view.findViewById<Button>(R.id.buttonGoogleSignIn)
        val buttonKakaoSignIn = view.findViewById<Button>(R.id.buttonKakaoSignIn)
        val textViewLogin = view.findViewById<TextView>(R.id.textViewLogin)

        // Set click listener for create account button
        buttonCreateAccount.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, SignUpFragment())
                addToBackStack(null)
            }
        }

        // Set click listener for Google sign-in button
        buttonGoogleSignIn.setOnClickListener {
            Toast.makeText(activity, "Google로 시작하기 클릭됨", Toast.LENGTH_SHORT).show()
        }

        // Set click listener for Kakao sign-in button
        buttonKakaoSignIn.setOnClickListener {
            Toast.makeText(activity, "카카오로 시작하기 클릭됨", Toast.LENGTH_SHORT).show()
        }

        // Set click listener for login text
        textViewLogin.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, RealLoginFragment())
                addToBackStack(null)
            }
        }

        return view
    }
}






