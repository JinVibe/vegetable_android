package com.gdg.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class RealLoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_real_login, container, false)

        // Initialize views
        val buttonLogin = view.findViewById<Button>(R.id.buttonLogin)
        val buttonGoogleSignIn = view.findViewById<AppCompatImageButton>(R.id.buttonGoogleSignIn)
        val buttonKakaoSignIn = view.findViewById<AppCompatImageButton>(R.id.buttonKakaoSignIn)
        val textViewFindId = view.findViewById<TextView>(R.id.textViewFindId)
        val textViewFindPassword = view.findViewById<TextView>(R.id.textViewFindPassword)
        val textViewSignUp = view.findViewById<TextView>(R.id.textViewSignUp)

        // Set click listener for login button
        buttonLogin.setOnClickListener {
            Toast.makeText(activity, "로그인 클릭됨", Toast.LENGTH_SHORT).show()
        }

        // Set click listener for Google sign-in button
        buttonGoogleSignIn.setOnClickListener {
            Toast.makeText(activity, "Google로 시작하기 클릭됨", Toast.LENGTH_SHORT).show()
        }

        // Set click listener for Kakao sign-in button
        buttonKakaoSignIn.setOnClickListener {
            Toast.makeText(activity, "카카오로 시작하기 클릭됨", Toast.LENGTH_SHORT).show()
        }

        // Set click listener for find ID button
        textViewFindId.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, FindIdFragment())
                addToBackStack(null)
            }
        }

        // Set click listener for find Password button
        textViewFindPassword.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, FindPasswordFragment())
                addToBackStack(null)
            }
        }

        // Set click listener for Sign Up button
        textViewSignUp.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, SignUpFragment())
                addToBackStack(null)
            }
        }

        return view
    }
}
