package com.diagnese.app.pages.auth.forgetpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.diagnese.app.R
import com.diagnese.app.databinding.FragmentSecondForgetBinding


class SecondForgetFragment : Fragment() {


    private var _binding : FragmentSecondForgetBinding? = null
    private val binding : FragmentSecondForgetBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondForgetBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.loginTextBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_secondForgetFragment_to_loginFragment)
        }

        binding.formSecondForgotPassword.verifyButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_secondForgetFragment_to_thirdForgetFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}