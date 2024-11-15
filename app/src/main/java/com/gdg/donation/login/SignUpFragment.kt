package com.gdg.donation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.gdg.donation.R
import com.gdg.donation.login.RealLoginFragment

class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val buttonStart = view.findViewById<Button>(R.id.buttonStart)
        val buttonBack = view.findViewById<Button>(R.id.buttonBack)

        buttonStart.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, RealLoginFragment())
                addToBackStack(null)
            }
        }

        buttonBack.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            parentFragmentManager.popBackStack()
        }
    }
}