package com.diagnese.app.pages.auth.forgetpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.diagnese.app.R
import com.diagnese.app.databinding.FragmentFirstForgetPasswordBinding


class FirstForgetPasswordFragment : Fragment() {


    private var _binding : FragmentFirstForgetPasswordBinding? = null
    private val binding : FragmentFirstForgetPasswordBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstForgetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.formFirstForgotPassword.sendEmailButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_firstForgetPasswordFragment_to_secondForgetFragment)
        }

        binding.loginTextBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_firstForgetPasswordFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}