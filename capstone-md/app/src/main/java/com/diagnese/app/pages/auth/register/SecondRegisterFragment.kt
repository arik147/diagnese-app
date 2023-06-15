package com.diagnese.app.pages.auth.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.diagnese.app.R
import com.diagnese.app.core.domain.data.User
import com.diagnese.app.databinding.FragmentSecondRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondRegisterFragment : Fragment() {

    private var _binding : FragmentSecondRegisterBinding? = null
    private val binding : FragmentSecondRegisterBinding get() = _binding!!

    private val registerViewModel by viewModels<RegisterViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondRegisterBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val age = arguments?.getString(FirstRegisterFragment.AGE)
        val name = arguments?.getString(FirstRegisterFragment.NAME)
        val gender = arguments?.getString(FirstRegisterFragment.GENDER)


        Log.d("passed data", "$age, $name, $gender")



        binding.loginTextBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_secondRegisterFragment_to_loginFragment)
        }


        binding.formSecondRegister.registerButton.setOnClickListener {
            val email = binding.formSecondRegister.firstRegisterSecondEditText.text.toString().trim()
            val password = binding.formSecondRegister.secondRegistersSecondEditText.text.toString().trim()
            val confirmPassword = binding.formSecondRegister.thirdRegisterSecondEditText.text.toString().trim()

            val user = User(
                email = email,
                age = (age ?: "1").toInt(),
                name = name ?: "",
                gender = gender ?: ""
            )

            validate(email, password, confirmPassword)
            registerViewModel.register(email, password, user)
            registerViewModel.getUser()
            Navigation.findNavController(it).navigate(R.id.action_secondRegisterFragment_to_loginFragment)
        }
    }

    private fun validate(email : String, password : String, confirmPassword : String){
        when{
            email.isEmpty() -> {
                binding.formSecondRegister.firstRegisterTextField.error = "Email must not be empty"
            }
            password.isEmpty() -> {
                binding.formSecondRegister.secondRegisterTextField.error = "Password must not be empty"
            }
            confirmPassword.isEmpty() -> {
                binding.formSecondRegister.thirdRegisterTextField.error = "Password must not be empty"
            }
            password.length <= 8 -> {
                binding.formSecondRegister.secondRegisterTextField.error = "Password must not be at least 8 characters"
            }
            password != confirmPassword -> {
                binding.formSecondRegister.thirdRegisterTextField.error = "Password does not match"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}