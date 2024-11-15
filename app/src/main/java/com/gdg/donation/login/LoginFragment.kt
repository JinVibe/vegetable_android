package com.gdg.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.gdg.donation.R
import com.gdg.donation.login.RealLoginFragment

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val buttonCreateAccount = view.findViewById<Button>(R.id.buttonCreateAccount)
        val buttonGoogleSignIn = view.findViewById<Button>(R.id.buttonGoogleSignIn)
        val buttonKakaoSignIn = view.findViewById<Button>(R.id.buttonKakaoSignIn)
        val textViewLogin = view.findViewById<TextView>(R.id.textViewLogin)

        buttonCreateAccount.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, SignUpFragment())
                addToBackStack(null)
            }
        }

        // 구글 로그인 API
        buttonGoogleSignIn.setOnClickListener {
            Toast.makeText(activity, "Google로 시작하기 클릭됨", Toast.LENGTH_SHORT).show()
        }

        // 카카오 로그인 API
        buttonKakaoSignIn.setOnClickListener {
            Toast.makeText(activity, "카카오로 시작하기 클릭됨", Toast.LENGTH_SHORT).show()
        }

        // 기본 로그인
        textViewLogin.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, RealLoginFragment())
                addToBackStack(null)
            }
        }

        return view
    }
}






