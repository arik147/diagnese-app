package com.diagnese.app.pages.auth.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.diagnese.app.R
import com.diagnese.app.databinding.FragmentLoginBinding
import com.diagnese.app.pages.home.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding : FragmentLoginBinding get() = _binding!!

    private val loginViewModel by viewModels<LoginViewModel>()


    private val googleSignInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val account = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val result = account.getResult(ApiException::class.java)
            val credentials = GoogleAuthProvider.getCredential(result.idToken,null )
            loginViewModel.loginWithGoogle(credentials)
        } catch (it : ApiException){
            it.printStackTrace()
        }
    }


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
            val email = binding.formLoginCard.firstLoginEditText.text.toString().trim()
            val password = binding.formLoginCard.secondLoginEditText.text.toString().trim()
            validate(email, password)
            loginViewModel.login(email, password)
            startActivity(Intent(requireActivity(), MainActivity::class.java))
            requireActivity().finish()

        }

        binding.formLoginCard.forgotPasswordButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_firstForgetPasswordFragment)
        }

        binding.formLoginCard.googleButton.setOnClickListener{
             val gso =  GoogleSignInOptions
                 .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                 .requestIdToken(getString(R.string.default_web_client_id))
                 .requestEmail()
                 .build()

            val googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
            googleSignInLauncher.launch(googleSignInClient.signInIntent)
            startActivity(Intent(requireActivity(), MainActivity::class.java))
            requireActivity().finish()
        }


    }



    private fun validate(email : String, password : String){
        when{
            email.isEmpty() -> {
                binding.formLoginCard.firstLoginTextField.error = "Email must not be empty"
            }
            password.isEmpty() -> {
                binding.formLoginCard.secondLoginTextField.error = "Password must not be empty"
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}