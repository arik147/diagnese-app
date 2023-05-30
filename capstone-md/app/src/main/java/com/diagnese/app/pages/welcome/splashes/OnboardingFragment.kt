package com.diagnese.app.pages.welcome.splashes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.diagnese.app.components.navigation.LandingPager

class OnboardingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireActivity()).apply {
            setContent {
                LandingPager()
            }
        }
    }


}


