package com.gdg.donation.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.gdg.donation.*
import com.gdg.donation.api.RetrofitInstance
import com.gdg.donation.api.signup.request.LogInReqDTO
import com.gdg.donation.api.signup.response.LogInResDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RealLoginFragment : Fragment() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText

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
             login()

//            parentFragmentManager.commit {
//                moveToMainScreen()
//            }
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // EditText 초기화
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextPassword = view.findViewById(R.id.editTextPassword)
    }

    private fun login() {
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(requireContext(), "이메일과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        val loginRequest = LogInReqDTO(email, password)

        RetrofitInstance.api.logIn(loginRequest).enqueue(object : Callback<LogInResDTO> {
            override fun onResponse(call: Call<LogInResDTO>, response: Response<LogInResDTO>) {
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), "로그인 성공", Toast.LENGTH_SHORT).show()
                    moveToMainScreen()
                } else {
                    Toast.makeText(requireContext(), "로그인 실패: 이메일이나 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LogInResDTO>, t: Throwable) {
                Toast.makeText(requireContext(), "네트워크 오류 발생", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun moveToMainScreen() {
        startActivity(Intent(context, ContentActivity::class.java))
        requireActivity().finish()
    }
}