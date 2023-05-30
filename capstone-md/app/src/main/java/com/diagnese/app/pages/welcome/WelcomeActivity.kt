package com.diagnese.app.pages.welcome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diagnese.app.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private var _binding : ActivityWelcomeBinding? = null
    private val binding : ActivityWelcomeBinding? get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}