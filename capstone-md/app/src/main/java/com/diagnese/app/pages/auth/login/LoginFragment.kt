package com.diagnese.app.pages.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.diagnese.app.R
import com.diagnese.app.databinding.FragmentLoginBinding
import com.diagnese.app.pages.home.MainActivity


class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding : FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerTextBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_firstRegisterFragment)
        }

        binding.formLoginCard.loginButton.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}