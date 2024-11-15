package com.gdg.donation.login

import android.content.Intent
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
import com.gdg.donation.ContentActivity
import com.gdg.donation.FindIdFragment
import com.gdg.donation.FindPasswordFragment
import com.gdg.donation.HomeFragment
import com.gdg.donation.R
import com.gdg.donation.SignUpFragment

class RealLoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_real_login, container, false)

        val buttonLogin = view.findViewById<Button>(R.id.buttonLogin)
        val buttonGoogleSignIn = view.findViewById<AppCompatImageButton>(R.id.buttonGoogleSignIn)
        val buttonKakaoSignIn = view.findViewById<AppCompatImageButton>(R.id.buttonKakaoSignIn)
        val textViewFindId = view.findViewById<TextView>(R.id.textViewFindId)
        val textViewFindPassword = view.findViewById<TextView>(R.id.textViewFindPassword)
        val textViewSignUp = view.findViewById<TextView>(R.id.textViewSignUp)

        buttonLogin.setOnClickListener {

            parentFragmentManager.commit {
                moveToMainScreen()
            }
        }

        buttonGoogleSignIn.setOnClickListener {
            Toast.makeText(activity, "Google로 시작하기 클릭됨", Toast.LENGTH_SHORT).show()
        }

        buttonKakaoSignIn.setOnClickListener {
            Toast.makeText(activity, "카카오로 시작하기 클릭됨", Toast.LENGTH_SHORT).show()
        }

        textViewFindId.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, FindIdFragment())
                addToBackStack(null)
            }
        }

        textViewFindPassword.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, FindPasswordFragment())
                addToBackStack(null)
            }
        }

        textViewSignUp.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, SignUpFragment())
                addToBackStack(null)
            }
        }

        return view
    }

    private fun moveToMainScreen() {
        startActivity(Intent(context, ContentActivity::class.java))
        requireActivity().finish()
    }
}