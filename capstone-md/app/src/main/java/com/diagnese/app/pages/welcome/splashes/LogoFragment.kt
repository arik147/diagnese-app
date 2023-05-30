package com.diagnese.app.pages.welcome.splashes

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.diagnese.app.R
import com.diagnese.app.databinding.FragmentLogoBinding


class LogoFragment : Fragment() {

   private lateinit var binding : FragmentLogoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogoBinding.inflate(inflater, container, false)
        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(R.id.action_logoFragment_to_onBoardingFragment)
        }, 3000)
        return binding.root
    }


}