package com.gdg.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.gdg.donation.api.RetrofitInstance
import com.gdg.donation.api.signup.request.SignUpReqDTO
import com.gdg.donation.login.RealLoginFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpFragment : Fragment() {

    private lateinit var editTextName: android.widget.EditText
    private lateinit var editTextContact: android.widget.EditText
    private lateinit var editTextId: android.widget.EditText
    private lateinit var editTextPassword: android.widget.EditText
    private lateinit var editTextPasswordConfirm: android.widget.EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val buttonStart = view.findViewById<Button>(R.id.buttonStart)
        val buttonBack = view.findViewById<Button>(R.id.buttonBack)

        buttonStart.setOnClickListener {
            signUp()
        }

        buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // EditText 초기화
        editTextName = view.findViewById(R.id.editTextName)
        editTextContact = view.findViewById(R.id.editTextContact)
        editTextId = view.findViewById(R.id.editTextId)
        editTextPassword = view.findViewById(R.id.editTextPassword)
        editTextPasswordConfirm = view.findViewById(R.id.editTextPasswordConfirm)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            parentFragmentManager.popBackStack()
        }
    }

    private fun signUp() {
        val name = editTextName.text.toString()
        val phoneNum = editTextContact.text.toString()
        val email = editTextId.text.toString()
        val password = editTextPassword.text.toString()
        val passwordConfirm = editTextPasswordConfirm.text.toString()

        if (password != passwordConfirm) {
            Toast.makeText(context, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        val request = SignUpReqDTO(name,email, password, phoneNum)


        RetrofitInstance.api.signUp(request).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "회원가입 성공!", Toast.LENGTH_SHORT).show()
                    parentFragmentManager.commit {
                        replace(R.id.fragment_container, RealLoginFragment())
                        addToBackStack(null)
                    }
                } else {
                    Toast.makeText(context, "회원가입 실패: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(context, "네트워크 오류 발생", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
