package com.diagnese.app.pages.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.diagnese.app.R
import com.diagnese.app.databinding.FragmentFirstRegisterBinding


class FirstRegisterFragment : Fragment() {

    private var _binding : FragmentFirstRegisterBinding? = null
    private val binding : FragmentFirstRegisterBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.formFirstRegister.nextButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_firstRegisterFragment_to_secondRegisterFragment)
        }

        binding.loginTextBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_firstRegisterFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}