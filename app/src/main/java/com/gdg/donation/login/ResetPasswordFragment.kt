package com.gdg.donation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.gdg.donation.R

class ResetPasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_reset_password, container, false)

        val buttonLogin = view.findViewById<Button>(R.id.buttonLogin)
        val buttonBack = view.findViewById<Button>(R.id.buttonBack)

        buttonLogin.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, RealLoginFragment())
                addToBackStack(null)
            }
        }

        buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack() // 뒤로 가기 기능 수행
        }

        return view
    }
}