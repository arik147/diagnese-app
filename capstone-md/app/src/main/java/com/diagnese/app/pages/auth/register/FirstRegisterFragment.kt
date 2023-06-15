package com.diagnese.app.pages.auth.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.navigation.Navigation
import com.diagnese.app.R
import com.diagnese.app.databinding.FragmentFirstRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        lateinit var selectedGender : RadioButton
        lateinit var genderText : String

        val bundle = Bundle()


        binding.formFirstRegister.nextButton.setOnClickListener {
            val name = binding.formFirstRegister.firstRegisterFirstEditText.text.toString().trim()
            val age = binding.formFirstRegister.firstRegisterSecondEditText.text.toString().trim()
            val gender = binding.formFirstRegister.genderRadio.checkedRadioButtonId

            if(gender == R.id.radio_selection_male){
                selectedGender = binding.root.findViewById(R.id.radio_selection_male)
                selectedGender.text = resources.getString(R.string.male)
            } else {
                selectedGender = binding.root.findViewById(R.id.radio_selection_female)
                selectedGender.text = resources.getString(R.string.female)
            }
            genderText = selectedGender.text.toString()


            Log.d("passed data", "$age, $name, $genderText")
            validate(name, age)
            bundle.putString(GENDER, genderText)
            bundle.putString(NAME, name)
            bundle.putString(AGE, age)
            Navigation.findNavController(it).navigate(R.id.action_firstRegisterFragment_to_secondRegisterFragment, bundle)
        }

        binding.loginTextBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_firstRegisterFragment_to_loginFragment)
        }


    }

    private fun validate(name : String, age : String){
        when{
            name.isEmpty() -> {
                binding.formFirstRegister.firstRegisterFirstTextField.error = "Name must not be empty"
            }
            age.isEmpty() -> {
                binding.formFirstRegister.ageTextField.error = "Age must not be empty"
            }

        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object{
        const val GENDER = "gender"
        const val AGE = "age"
        const val NAME = "name"
    }

}