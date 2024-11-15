package com.gdg.donation.login

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
import com.gdg.donation.R

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
            Toast.makeText(activity, "로그인 클릭됨", Toast.LENGTH_SHORT).show()
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
}
