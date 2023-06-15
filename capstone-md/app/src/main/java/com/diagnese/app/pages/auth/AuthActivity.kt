package com.diagnese.app.pages.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diagnese.app.databinding.ActivityAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private var _binding : ActivityAuthBinding? = null
    private val binding : ActivityAuthBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}